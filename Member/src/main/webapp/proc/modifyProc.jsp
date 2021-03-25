<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	// 전송 데이터 수신
	String uid  = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp   = request.getParameter("hp");
	String pos  = request.getParameter("pos");
	String dep  = request.getParameter("dep");
	
	// 데이터베이스 처리 1 ~ 6단계
	// 1단계
	// 2단계
	// 3단계
	// 4단계
	String sql  = "UPDATE `MEMBER` SET ";
		   sql += "`name`='"+name+"', ";
		   sql += "`hp`='"+hp+"', ";
		   sql += "`pos`='"+pos+"', ";
		   sql += "`dep`="+dep+" ";
		   sql += "WHERE `uid`='"+uid+"';";
	
	// 5단계
	// 6단계
	
	// 리다이렉트
	response.sendRedirect("../list.jsp");
%>