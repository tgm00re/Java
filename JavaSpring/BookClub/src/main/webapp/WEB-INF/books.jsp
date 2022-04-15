<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="bg-dark text-light">
    <div class="container p-2"> <!-- Beginning of Container -->
        <div class="row">
            <div class="col-sm-10">
                <h1 class="text-primary">Welcome, <c:out value="${user_name}"/></h1>
                <p>Books from everyone's shelves:</p>
            </div>
            <div class="col-sm-2 text-end">
                <p><a href="/logout">Logout</a></p>
                <p><a href="/books/new">+ Add to my shelf!</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Title</th>
                        <th scope="col">Author Name</th>
                        <th scope="col">Posted By</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <th scope="row"><c:out value="${book.id}"/></th>
                                <td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
                                <td><c:out value="${book.authorName}"/></td>
                                <td><c:out value="${book.user.name}"/></td>
                            </tr>
                        </c:forEach>
                    
                    </tbody>
                </table>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>