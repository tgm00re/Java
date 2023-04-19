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
<title>Login</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    
    
    <section class="vh-100" style="background-color: #eee;">
        <div class="container-fluid h-custom">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">

                <p class="text-center h1 fw-bold mx-1 mx-md-4 mt-4">Login</p>

              <form:form modelAttribute="loginUser" method="post" action="/bookclub/process/login">
                <!-- Email input -->
                <div class="form-outline mb-4 mt-2 pt-5">
                  <form:input path="name" type="text" id="form3Example3" class="form-control form-control-lg"
                    placeholder="Enter your name" />
                    <form:errors path="name" class="text-danger"/>
                </div>
      
                <div class="d-flex justify-content-between align-items-center">
                </div>
      
                <div class="text-center text-lg-start mt-2 pt-2">
                  <input type="submit" value="Login" class="btn btn-primary btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;"/>
                  <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="/bookclub/register"
                      class="link-danger">Register</a></p>
                </div>
      
              </form:form>
            </div>
          </div>
        </div>
        
      </section>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>