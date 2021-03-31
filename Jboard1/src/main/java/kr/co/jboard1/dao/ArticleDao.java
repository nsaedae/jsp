package kr.co.jboard1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.bean.ArticleBean;
import kr.co.jboard1.config.DBConfig;

public class ArticleDao {
	
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {}
	
	public static ArticleDao getInstance() {
		return instance;
	}
	
	public void selectCountArticle() throws Exception {
		/*
		String sqlCount = "SELECT COUNT(*) FROM `JBOARD_ARTICLE`;";
		Statement stmt = conn.createStatement();
		
		ResultSet rsCount = stmt.executeQuery(sqlCount);
		
		if(rsCount.next()){
			total = rsCount.getInt(1);
		}
		*/
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
	
	public void selectArticle() throws Exception {}
	
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
	
	public void deleteArticle() throws Exception {}
}
