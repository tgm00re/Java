<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Fruity Loops</title>
	<!-- for Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-dark text-light text-center">
	<div class="container p-5">
		<h1>Fruity Loops</h1>
		<table class="table text-light">
  			<thead>
   			    <tr>
     				<th scope="col">Name</th>
      				<th scope="col">Price</th>
    			</tr>
  			</thead>
  			<tbody>
  			<c:forEach var="fruit" items="${fruits}">
    			<tr class="text-light">
      				<td><c:out value="${fruit.name}"/></td>
      				<td><c:out value="${fruit.price}"/></td>
    			</tr>
    		</c:forEach>
  			</tbody>
		</table>
		
	</div>
	
</body>
</html>