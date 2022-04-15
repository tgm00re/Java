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
<title>${book.title}</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="bg-dark text-light">
    <div class="container"> <!-- Beginning of Container -->
        <div class="row">
            <div class="col-sm-10">
                <h1 class="text-primary"><c:out value="${book.title}"/></h1>
            </div>
            <div class="col-sm-2 text-end">
                <p><a href="/books">back to the shelves</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                
                <p><c:out value="${user_id == book.user.id ? 'You' : book.user.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.authorName}"/></p>
                <p>Here are <c:out value="${user_id == book.user.id ? 'your' : book.user.name }"/> thoughts:</p>
            </div>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <p><c:out value="${book.description}"/></p>
            </div>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-12 text-end">
                <c:if test="${user_id == book.user.id}">
                    <a href="/books/${book.id}/edit"><button class="btn btn-primary">Edit</button></a>
                </c:if>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>