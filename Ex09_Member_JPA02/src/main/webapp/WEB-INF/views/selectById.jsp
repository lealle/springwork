<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #02</h1>
	<c:if test= "${member !=null }">
		ID : ${member.id }<p/>
		이름 : ${member.username }<p/>
		EMAIL : ${member.email }<p/>
	
	</c:if>
	
	
	
</body>
</html>