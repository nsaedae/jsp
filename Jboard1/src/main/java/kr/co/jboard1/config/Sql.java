package kr.co.jboard1.config;

public class Sql {
	
	// User 관련
	public static final String SELECT_TERMS = "SELECT * FROM `JBOARD_TERMS`;";
	public static final String INSERT_USER  = "INSERT INTO `JBOARD_USER` SET "
											   + "`uid`=?,"
											   + "`pass`=PASSWORD(?),"
											   + "`name`=?,"
											   + "`nick`=?,"
											   + "`email`=?,"
											   + "`hp`=?,"
											   + "`zip`=?,"
											   + "`addr1`=?,"
											   + "`addr2`=?,"
											   + "`regip`=?,"
											   + "`rdate`=NOW();";
	
	
	// Article 관련
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM `JBOARD_ARTICLE`;";
	public static final String SELECT_ARTICLES = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid = b.uid "
												+ "ORDER BY `seq` DESC "
												+ "LIMIT ?, 10";

	public static final String INSERT_ARTICLE = "INSERT INTO `JBOARD_ARTICLE` SET "
												+ "`title`=?, "
												+ "`content`=?, "
												+ "`uid`=?, "
												+ "`regip`=?, "
												+ "`rdate`=NOW();";
	
	
}
