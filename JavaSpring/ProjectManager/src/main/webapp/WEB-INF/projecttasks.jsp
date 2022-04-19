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
            <h1>Project: <c:out value="${project.title}"/></h1>
            <p>Project Lead: <c:out value="${project.lead.firstName}"/></p>
            <a href="/dashboard">Return to dashboard</a>
        </div>
        <div class="row">
            <form:form modelAttribute="task" method="post" action="/tasks/create/${project.id}">
                <div class="form-group my-3">
                    <form:label path="description">Add a task ticket for this team:</form:label>
                    <form:textarea path="description" class="form-control" id="task" rows="3"></form:textarea>
                    <form:errors path="description" class="text-danger"/>
                </div>
                <button type="submit" class="btn btn-success w-25">Submit</button>
                </form:form>
        </div>
        <div class="row my-5 ">
            <ul>
                <c:forEach items="${project.tasks}" var="oneTask">
                <li><strong>Added by <c:out value="${oneTask.creatorName}"/> at <c:out value="${oneTask.created_at}"/></strong></li>
                <li><c:out value="${oneTask.description}"/></li>
                </c:forEach>
                
            </ul>
        </div>
    </div> <!-- End of Container -->
</body>
</html>