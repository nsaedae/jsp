<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String uid = request.getParameter("uid");
	
	// 데이터베이스 처리 1~6단계
	// 1단계
	// 2단계
	// 3단계
	// 4단계
	String sql = "DELETE FROM `MEMBER` WHERE `uid`='"+uid+"';";
	
	// 5단계
	// 6단계
	
	// 리다이렉트
	response.sendRedirect("../list.jsp");
%>