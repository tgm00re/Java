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
<body class="bg-dark text-center text-light">
	<h1>Display Page</h1>
	<h2>You have visited the index page <c:out value="${count}"/> times</h2>
	<a href="/">Index Page</a>
	<a href="/doubleIndex">Add 2 to count!</a>
	<a href="/resetCount">Reset the count</a>
</body>
</html>