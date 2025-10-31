<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="minsert" method="post">
	ID : <input name="id"><p/>
	NAME : <input name="username"><p/>
	PASSWORD : <input type="password" name="password"><p/>
	<input type="submit" value="회원가입">
	</form>
	
	<form action="binsert" method="post">
	TITLE : <input name="title"><p/>
	CONTENT : <input name="content"><p/>
	<input type="hidden" name="id" value="123">
	<input type="submit" value="BOARD">
	</form>
	
	<a href="mupdate?id=123&username=asd">멤버 이름 수정</a>
	<p/>
	
	<hr>
	
	
	
	
	
	
	
	
	
	
</body>
</html>