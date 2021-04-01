<%@page import="kr.co.jboard1.dao.UserDao"%>
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
	
	// 데이터베이스 처리
	UserBean user = UserDao.getInstance().selectUser(uid, pass);
	
	if(user != null){
		// 세션 사용자 정보객체 저장
		session.setAttribute("suser", user);
		// 게시판 목록 이동
		response.sendRedirect("/Jboard1/list.jsp");
	}else{
		// 회원이 아닐 경우
		response.sendRedirect("/Jboard1/user/login.jsp?result=0");
	}
%>






