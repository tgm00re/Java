<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display One</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container p-5 bg-dark text-light">
		<h1 class="mb-4">Expense Details</h1>
		<ul>
			<li>Name: <c:out value="${expense.name}"/></li>
			<li>Description: <c:out value="${expense.description}"/></li>
			<li>Vendor: <c:out value="${expense.vendor}"/></li>
			<li>Amount Spent: <c:out value="${expense.price}"/></li>
		</ul>
	</div>
</body>
</html>