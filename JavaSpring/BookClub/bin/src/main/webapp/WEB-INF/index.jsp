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
<title>Book Club</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="bg-dark text-light">
    <div class="container p-2"> <!-- Beginning of Container -->
        <div class="row">
            <div class="col-sm-12">
                <h1 class="text-primary">Book Club</h1>
                <p>A place for friends to share thoughts on books!</p>
            </div>
        </div>
        <div class="row">
            <!-- Register -->
            <div class="col-sm-5">
                <h2>Register</h2>
                <form:form modelAttribute="user" action="/register" method="post">
                    <div class="form-group">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter Name"/>
                        <form:errors path="name" class="text-danger"/>
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
                        <form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"/>
                        <form:errors path="confirmPassword" class="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-primary my-3">Submit</button>
                </form:form>
            </div>
            <div class="col-sm-2"></div>
            <!-- Login -->
            <div class="col-sm-5">
                <h2>Login</h2>
                <form:form modelAttribute="loginUser" action="/login" method="post">
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
                    <button type="submit" class="btn btn-primary my-3">Submit</button>
                </form:form>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>