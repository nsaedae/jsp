package kr.co.jboard1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.bean.ArticleBean;
import kr.co.jboard1.config.DBConfig;
import kr.co.jboard1.config.Sql;

public class ArticleDao {
	
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {}
	
	public static ArticleDao getInstance() {
		return instance;
	}
	
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart   = (groupCurrent - 1) * 10 + 1;
		int groupEnd     = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	
	public int selectCountArticle() throws Exception {
		
		Connection conn = DBConfig.getInstance().getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(Sql.SELECT_COUNT_ARTICLE);
		
		int total = 0;
		
		if(rs.next()){
			total = rs.getInt(1);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
	}
	
	public void insertArticle(ArticleBean article) throws Exception {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
		psmt.setString(1, article.getTitle());
		psmt.setString(2, article.getContent());
		psmt.setString(3, article.getUid());
		psmt.setString(4, article.getRegip());
		
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
	}
	
	public ArticleBean selectArticle(String seq) throws Exception {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
		psmt.setString(1, seq);
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		ArticleBean ab = new ArticleBean();
		
		if(rs.next()) {
			ab.setSeq(rs.getInt(1));
			ab.setParent(rs.getInt(2));
			ab.setComment(rs.getInt(3));
			ab.setCate(rs.getString(4));
			ab.setTitle(rs.getString(5));
			ab.setContent(rs.getString(6));
			ab.setFile(rs.getInt(7));
			ab.setHit(rs.getInt(8));
			ab.setUid(rs.getString(9));
			ab.setRegip(rs.getString(10));
			ab.setRdate(rs.getString(11));
		}
				
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
		return ab;
	}
	
	public List<ArticleBean> selectArticles(int start) throws Exception {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
		psmt.setInt(1, start);
		
		// 4단계
		ResultSet rs = psmt.executeQuery();
		
		// 5단계
		List<ArticleBean> articles = new ArrayList<>();
		
		while(rs.next()){
			ArticleBean ab = new ArticleBean();
			ab.setSeq(rs.getInt(1));
			ab.setParent(rs.getInt(2));
			ab.setComment(rs.getInt(3));
			ab.setCate(rs.getString(4));
			ab.setTitle(rs.getString(5));
			ab.setContent(rs.getString(6));
			ab.setFile(rs.getInt(7));
			ab.setHit(rs.getInt(8));
			ab.setUid(rs.getString(9));
			ab.setRegip(rs.getString(10));
			ab.setRdate(rs.getString(11));
			ab.setNick(rs.getString(12));
			
			articles.add(ab);
		}
		
		// 6단계
		rs.close();
		psmt.close();
		conn.close();
		
		return articles;
	}
	
	public void updateArticle() throws Exception {}
	
	public void updateArticleHit(String seq) throws Exception {
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
		psmt.setString(1, seq);
		
		// 4단계
		psmt.executeUpdate();
		
		// 5단계
		// 6단계
		psmt.close();
		conn.close();
	}
	
	
	public void deleteArticle() throws Exception {}
}
