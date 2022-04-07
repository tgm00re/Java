<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Display</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
	<div class="container">
		<p>In <c:out value="${number}"/> years, 
		you will live in <c:out value="${city}"/> 
		with <c:out value="${person}"/> as your roommate,
		 <c:out value="${hobby}"/> for a living. 
		The next time you see a <c:out value="${thing}"/>, you will have good luck. 
		Also, <c:out value="${message}"/>.</p>
	</div>
</body>
</html>