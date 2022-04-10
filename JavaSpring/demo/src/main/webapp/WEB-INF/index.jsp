<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	
	<div class="container"><table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col">Pages</th>
    </tr>
  </thead>
  
  <tbody>
  	<c:forEach items="${bookList}" var="book" >
    <tr>
      <th scope="row"><c:out value="${book.id}"/></th>
      <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
      <td><c:out value="${book.language }"/></td>
      <td><c:out value="${book.pages}"/></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
	

</body>
</html>