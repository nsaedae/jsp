<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_3_Loop</title>
</head>
<body>
	<!-- 
		날짜 : 2021/03/23
		이름 : 김철학
		내용 : JSP 스크립트릿 반복문 실습하기
	-->
	<h3>3.JSP 반복문</h3>
	
	<h4>for</h4>
	<%
		for(int i=1 ; i<=5 ; i++){
			out.println("<h4>for 반복문 : "+i+"</h4>");
		}	
	%>	
	
	<h4>while</h4>
	<%
		int i = 1;
		while( i <= 5 ){
	%>
		<h4>while 반복문 : <%= i %></h4>
	<%
			i++;
		}
	%>
	
	<h4>구구단</h4>
	<table border="1">
		<tr>
			<th>2단</th>
			<th>3단</th>
			<th>4단</th>
			<th>5단</th>
			<th>6단</th>
			<th>7단</th>
			<th>8단</th>
			<th>9단</th>
		</tr>
		<%
			for(int a=1 ; a<=9 ; a++){
		%>
			<tr>
				<% 
					for(int b=2 ; b<=9 ; b++){
						
						int c = a * b;						
				%>				
					<td><%= b %> x <%= a %> = <%= c %></td>					
				<% 
					}
				%>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>