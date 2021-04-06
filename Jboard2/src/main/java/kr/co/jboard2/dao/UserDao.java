package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.jboard2.config.DBConfig;
import kr.co.jboard2.config.Sql;
import kr.co.jboard2.vo.TermsVo;

public class UserDao {
	// �̱��� ��ü
	private static final UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao() {}

	
	
	public void insertUser() throws Exception {}
	public void selectUser() throws Exception {}
	public void selectUsers() throws Exception {}
	public TermsVo selectTerms() throws Exception {
		// 1,2�ܰ�
		Connection conn = DBConfig.getInstance().getConnection();		
		// 3�ܰ�
		Statement stmt = conn.createStatement();
		// 4�ܰ�
		ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
		// 5�ܰ�
		TermsVo vo = new TermsVo();
		
		if(rs.next()) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}
		// 6�ܰ�
		rs.close();
		stmt.close();
		conn.close();
		
		return vo;
	}
	public void updateUser() throws Exception {}
	public void deleteUser() throws Exception {}
	
	
}
