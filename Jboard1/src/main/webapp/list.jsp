<%@page import="kr.co.jboard1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 세션 사용자 정보 가져오기
	UserBean user = (UserBean) session.getAttribute("suser");
	
	if(user == null){
		// 로그인 안하고 게시판 목록을 요청했을 경우
		response.sendRedirect("/Jboard1/user/login.jsp?result=2");
		return; // 프로그램 종료
	}

	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
    <link rel="stylesheet" href="/Jboard1/css/style.css">    
</head>
<body>
    <div id="wrapper">
        <section id="board" class="list">
            <h3>글목록</h3>
            <article>
                <p>
                    <%= user.getNick() %>님 반갑습니다.
                    <a href="/Jboard1/user/proc/logout.jsp" class="logout">[로그아웃]</a>
                </p>
                <table border="0">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td><a href="./view.html">테스트 제목입니다.</a>&nbsp;[3]</td>
                        <td>길동이</td>
                        <td>20-05-12</td>
                        <td>12</td>
                    </tr>
                </table>
            </article>

            <!-- 페이지 네비게이션 -->
            <div class="paging">
                <a href="#" class="prev">이전</a>
                <a href="#" class="num current">1</a>                
                <a href="#" class="num">2</a>                
                <a href="#" class="num">3</a>                
                <a href="#" class="next">다음</a>
            </div>

            <!-- 글쓰기 버튼 -->
            <a href="./write.html" class="btnWrite">글쓰기</a>

        </section>
    </div>    
</body>
</html>