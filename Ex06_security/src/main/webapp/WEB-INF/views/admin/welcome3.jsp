<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome : Admin</h2>
	USER ID : ${pageContext.request.userPrincipal.name } <br>
	<a href="/logout">Logout</a>
<!-- security 하면 구성 및 설계 미리 다 짜고 해야함 -->

</body>
</html>