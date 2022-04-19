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
        <h2 class="text-center">Create a Project</h2>
            <form:form modelAttribute="project" action="/projects/create" method="post">
                <div class="form-group my-3">
                  <form:label path="title">Project Title</form:label>
                  <form:input path="title" type="text" class="form-control" id="title"/>
                  <form:errors path="title" class="text-danger"/>
                </div>
                <div class="form-group my-3">
                    <form:label path="description">Example Description</form:label>
                    <form:textarea path="description" class="form-control" id="description" rows="3"></form:textarea>
                    <form:errors path="description" class="text-danger"/>
                  </div>
                  <div class="form-group my-3">
                    <form:label path="dueDate">Example textarea</form:label>
                    <form:input path="dueDate" type="date" name="dueDate" id="dueDate"/>
                    <form:errors path="dueDate" class="text-danger"/>
                  </div>
                  <div class="text-center">
                      <a href="/dashboard"><button type="button" class="btn btn-danger bg-danger w-25">Cancel</button></a>
                  <button type="submit" class="btn btn-success w-25">Create Project</button>
                  </div>
                  
                </form:form>

    </div> <!-- End of Container -->
</body>
</html>