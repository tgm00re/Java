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
    <div class="container p-5"> <!-- Beginning of Container -->
        <div class="row text-center">
            <h1 class="text-info">Project Manager</h1>
            <p>A place for teamms to manage projects</p>
        </div>
        <div class="row bg-dark p-3 text-light">
            <div class="col-sm-5">
                <h2 class="text-center">Register</h2>
                <form:form method="post" modelAttribute="user" action="/register">
                    <div class="form-group my-3">
                        <form:label path="firstName">First Name</form:label>
                        <form:input path="firstName" type="text" class="form-control" id="firstName"/>
                        <form:errors path="firstName" class="text-danger"/>
                    </div>
                    <div class="form-group my-3">
                        <form:label path="lastName">Last Name</form:label>
                        <form:input path="lastName" type="text" class="form-control" id="lastName"/>
                        <form:errors path="lastName" class="text-danger"/>
                    </div>
                    <div class="form-group my-3">
                        <form:label path="email">Email address</form:label>
                        <form:input path="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email"/>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                    <div class="form-group my-3">
                        <form:label path="password">Password</form:label>
                        <form:input path="password" type="password" class="form-control" id="password" placeholder="Password"/>
                        <form:errors path="password" class="text-danger"/>
                    </div>
                    <div class="form-group my-3">
                        <form:label path="confirmPassword">Confirm Password</form:label>
                        <form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" placeholder="Confirm password"/>
                        <form:errors path="confirmPassword" class="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form:form>
            </div>
        <div class="col-sm-2"></div>
        <div class="col-sm-5">
            <h2 class="text-center">Login</h2>
            <form:form method="post" modelAttribute="loginUser" action="/login">
                <div class="form-group my-3">
                    <form:label path="email">Email address</form:label>
                    <form:input path="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email"/>
                    <form:errors path="email" class="text-danger"/>
                </div>
                <div class="form-group my-3">
                    <form:label path="password">Password</form:label>
                    <form:input path="password" type="password" class="form-control" id="password" placeholder="Password"/>
                    <form:errors path="password" class="text-danger"/>
                </div>
                <button type="submit" class="btn btn-success">Login</button>
            </form:form>
        </div>
        </div>
        
    </div> <!-- End of Container -->
</body>
</html>