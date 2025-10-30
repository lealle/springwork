<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #02</h1>
	<!-- Controller 에서 조작   -->
	<a href="insert">데이터 추가</a><br>
	<a href="selectAll">데이터 전체 조회</a><br>
	<a href="selectById?id=1">개별조회 byId</a><br>
	<hr>
	<a href="selectByName?name=이서준">개별조회 by Name</a><br>
	<a href="selectByEmail?email=test5@tjoeun.com">개별조회 by Name</a><br>
	<a href="selectByNameLike?name=김">리스트 조회 by Name Like</a><br>
	<a href="selectByNameLikeNameDesc?name=김">리스트 조회 by Name Like Desc</a><br>
	
	
	
	<a href="delete?id=2">데이터 삭제</a><br>
	<a href="update?id=1&username=이서준">데이터 변경</a><br>
	
</body>
</html>