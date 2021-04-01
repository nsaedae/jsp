<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	String file    = mRequest.getFilesystemName("file");
	String regip   = request.getRemoteAddr();
	
	// 세션 사용자 정보객체 가져오기
	UserBean user = (UserBean) session.getAttribute("suser");
	String uid = user.getUid();
	
	// 데이터베이스 처리
	ArticleBean article = new ArticleBean();
	article.setTitle(title);
	article.setContent(content);
	article.setUid(user.getUid());
	article.setRegip(regip);
	
	int seq = ArticleDao.getInstance().insertArticle(article);
	
	// 파일첨부를 했을 경우
	if(file != null){
		// 고유한 파일명 생성
		int i = file.lastIndexOf(".");
		String ext = file.substring(i);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss_");
		String now = sdf.format(new Date());
		
		String newName = now+uid+ext;
		
		// 저장된 파일명 수정(스트림)
		File oldFile = new File(path+"/"+file);
		File newFile = new File(path+"/"+newName);
		oldFile.renameTo(newFile);
		
		// 파일 테이블 INSERT
		ArticleDao.getInstance().insertFile(seq, file, newName);
	}

	// 게시판 목록 리다이렉트
	response.sendRedirect("/Jboard1/list.jsp");

%>