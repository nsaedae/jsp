package kr.co.jboard2.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	// ΩÃ±€≈Ê ∞¥√º
	private static DBConfig instance = new DBConfig();
	private DBConfig() {}

	public static DBConfig getInstance() {
		return instance;
	}
	
	// DB ¡§∫∏
	private final String HOST = "jdbc:mysql://192.168.10.114:3306/chhak";
	private final String USER = "chhak";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		// 1¥‹∞Ë
		Class.forName("com.mysql.jdbc.Driver");
		// 2¥‹∞Ë
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		return conn;
	}
}









