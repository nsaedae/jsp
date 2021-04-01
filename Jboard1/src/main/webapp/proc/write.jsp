<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.jboard1.bean.ArticleBean"%>
<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.jboard1.config.DBConfig"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String path = request.getServletContext().getRealPath("/file");
	int maxSize = 1024 * 1024 * 10;
	
	MultipartRequest mRequest = new MultipartRequest(request, 
													 path, 
													 maxSize,
													 "UTF-8",
													 new DefaultFileRenamePolicy());
	
	String title   = mRequest.getParameter("title");
	String content = mRequest.getParameter("content");
	String regip   = request.getRemoteAddr();
	
	// 세션 사용자 정보객체 가져오기
	UserBean user = (UserBean) session.getAttribute("suser");
	
	// 데이터베이스 처리
	ArticleBean article = new ArticleBean();
	article.setTitle(title);
	article.setContent(content);
	article.setUid(user.getUid());
	article.setRegip(regip);
	
	ArticleDao.getInstance().insertArticle(article);

	// 게시판 목록 리다이렉트
	response.sendRedirect("/Jboard1/list.jsp");

%>