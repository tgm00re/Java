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
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <div class="row">
            <h1>Project Details</h1>
            <a href="/dashboard">Return to dashboard</a>
        </div>
        <div class="row">
            <ul>
                <li>Project Title: <c:out value="${project.title}"/></li>
                <li>Project Description: <c:out value="${project.description}"/></li>
                <li>Due Date: <c:out value="${project.dueDate}"/></li>
            </ul>
        </div>
        <div class="row">
            <a href="/projects/tasks/${project.id}">See tasks</a>
        </div>
        <div class="row">
            <c:if test="${project.lead.id == user_id}">
                <div class="text-end">
                    <a href="/projects/delete/${project.id}"><button class="btn btn-danger w-25">Delete project</button></a>
                </div>
            </c:if>
        </div>
    </div> <!-- End of Container -->
</body>
</html>