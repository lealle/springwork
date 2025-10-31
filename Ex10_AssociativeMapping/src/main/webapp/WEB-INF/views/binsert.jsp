<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록 성공</h1>
	제목 : ${ board.title} <p/>
	내용 : ${ board.content} <p/>
	작성자 : ${ board.member} <p/>
	작성자 : ${ board.member.id } <p/>
	
</body>
</html>