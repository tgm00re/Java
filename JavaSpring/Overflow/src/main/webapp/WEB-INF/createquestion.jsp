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
<title>Dashboard</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <div class="row">
        <div class="col-sm-12">
            <h1>What is your question?</h1>
        </div>
        </div>
        <div class="row">
            <form:form action="/question/processcreate" modelAttribute="addQuestion" method="post">
                <form:label path="question">Question</form:label>
                <form:textarea path="question" id="question" rows="3"></form:textarea>
                <form:errors path="question" class="text-danger"/>
                <p></p>
                <form:label path="tags">Tags (up to 3, comma separated)</form:label>
                <form:input type="text" path="tags"/>
                <form:errors path="tags" class="text-danger"/>
                <input type="submit" value="Submit">
            </form:form>
        </div>
        <div class="row text-end">
            <a href="/">Dashboard</a>
        </div>
    </div> <!-- End of Container -->
</body>
</html>