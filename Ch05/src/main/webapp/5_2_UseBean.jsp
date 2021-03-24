<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5_2_UseBean</title>
</head>
<body>
	<h3>2.usebean 태그 실습</h3>
	<%	
		// 전송데이터 수신
		//String name      = request.getParameter("name");
		//String gender    = request.getParameter("gender");
		//String[] hobbies = request.getParameterValues("hobby");
		//String addr      = request.getParameter("addr");
	%>
	
	<jsp:useBean id="member" class="sub1.MemberBean">
		<jsp:setProperty name="member" property="name" />
		<jsp:setProperty name="member" property="gender" />
		<jsp:setProperty name="member" property="hobby" />
		<jsp:setProperty name="member" property="addr" />
	</jsp:useBean>
	
	<p>
		이름 : <%= member.getName() %><br />
		성별 : <%= member.getGender() %><br />
		취미 : 
		<%
			for(String hobby : member.getHobby()){
				out.print(hobby+", ");
			}
		%><br />
		주소 : <%= member.getAddr() %><br />
	</p>
	
</body>
</html>