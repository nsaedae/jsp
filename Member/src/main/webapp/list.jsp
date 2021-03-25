<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터베이스 처리 1 ~ 6단계
	// 1단계
	// 2단계
	// 3단계
	// 4단계
	// 5단계
	// 6단계
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원목록</title>
</head>
<body>
	<h3>직원목록</h3>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>직급</th>
			<th>부서</th>
			<th>입사일</th>
			<th>관리</th>
		</tr>
		<tr>
			<td>a101</td>
			<td>홍길동</td>
			<td>010-1234-1111</td>
			<td>사원</td>
			<td>101</td>
			<td>21-03-24</td>
			<td>
				<a href="./modify.jsp?uid=a101&name=홍길동&hp=010-1234-1111">수정</a>
				<a href="./proc/deleteProc.jsp?uid=a101">삭제</a>
			</td>		
		</tr>	
	</table>
	
	
	
</body>
</html>