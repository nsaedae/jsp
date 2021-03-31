<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String uid  = request.getParameter("uid");
	String pass = request.getParameter("pass");
	
	// 1, 2단계
	Connection conn = DBConfig.getInstance().getConnection();
	
	// 3단계
	String sql = "SELECT * FROM `JBOARD_USER` WHERE `uid`=? AND `pass`=PASSWORD(?);";
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setString(1, uid);
	psmt.setString(2, pass);
	
	// 4단계
	ResultSet rs = psmt.executeQuery();
	
	// 5단계
	if(rs.next()){
		// 회원이 맞을 경우
		UserBean user = new UserBean();
		
		user.setUid(rs.getString(1));
		user.setPass(rs.getString(2));
		user.setName(rs.getString(3));
		user.setNick(rs.getString(4));
		user.setEmail(rs.getString(5));
		user.setHp(rs.getString(6));
		user.setGrade(rs.getInt(7));
		user.setZip(rs.getString(8));
		user.setAddr1(rs.getString(9));
		user.setAddr2(rs.getString(10));
		user.setRegip(rs.getString(11));
		user.setRdate(rs.getString(12));
		
		// 세션 사용자 정보객체 저장
		session.setAttribute("suser", user);
		
		// 게시판 목록 이동
		response.sendRedirect("/Jboard1/list.jsp");
		
	}else{
		// 회원이 아닐 경우
		response.sendRedirect("/Jboard1/user/login.jsp?result=0");
	}
	
	// 6단계
	rs.close();
	psmt.close();
	conn.close();
%>






