package kr.co.farmstory2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.farmstory2.config.DBConfig;
import kr.co.farmstory2.config.Sql;
import kr.co.farmstory2.vo.TermsVo;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	public void insertUser() {}
	
	public TermsVo selectTerms() {
		
		TermsVo vo = new TermsVo();
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_TERMS);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setTerms(rs.getString(1));
				vo.setPrivacy(rs.getString(2));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public int selectUserCount(String uid) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_USER);
			psmt.setString(1, uid);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				count =  rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	public void selectUser() {}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}

}
