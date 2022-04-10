<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Book</title>
</head>
<body>
	<h1><c:out value="${book.title}"/></h1>
	<ul>
		<li>Description: <c:out value="${book.description}"/></li>
		<li>Language: <c:out value="${book.language}"/></li>
		<li>Pages: <c:out value="${book.pages}"/></li>
	</ul>
</body>
</html>