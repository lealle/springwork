<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA 01</h1>
	<!-- Controller 에서 조작   -->
	<a href="insert?username=test1">데이터 추가</a><br>
	<a href="select?id=1">개별조회</a><br>
	<a href="selectAll">데이터 전체 조회</a><br>
	<a href="delete?id=2">데이터 삭제</a><br>
	<a href="update?id=1&username=이서준">데이터 변경</a><br>
	
</body>
</html>