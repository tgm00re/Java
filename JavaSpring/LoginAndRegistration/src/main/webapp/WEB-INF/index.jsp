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
<title>Home</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="bg-dark text-light p-5">
    <div class="container"> <!-- Beginning of Container -->
        <div class="row">
            <div class="col-sm-5 bg-primary bg-gradient p-3">
                <h1 class="text-center">Register</h1>
                <form:form modelAttribute="user" method="post" action="/register">
                    <div class="form-group">
                        <form:label path="username">User Name</form:label>
                        <form:input path="username" type="text" class="form-control" id="username" placeholder="Enter Username"/>
                        <form:errors path="username" class="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="email">Email address</form:label>
                        <form:input path="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email"/>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password</form:label>
                        <form:input path="password" type="password" class="form-control" id="password" placeholder="Password"/>
                        <form:errors path="password" class="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="confirmPassword">Confirm Password</form:label>
                        <form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" placeholder="Password"/>
                        <form:errors path="confirmPassword" class="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-success my-3">Submit</button>
                  </form:form>
            </div>
            <div class="col-sm-2"></div>
            <div class="col-sm-5 bg-success bg-gradient p-3">
                <h1 class="text-center mb-2">Login</h1>
                <form:form method="post" modelAttribute="loginUser" action="/login">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <form:input path="email" type="email" id="form2Example1" class="form-control" />
                        <form:label path="email" class="form-label">Email address</form:label>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                
                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <form:input path="password" type="password" id="form2Example2" class="form-control" />
                        <form:label path="password" class="form-label" for="form2Example2">Password</form:label>
                        <form:errors path="password" class="text-danger"/>
                    </div>
                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
                </form:form>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>