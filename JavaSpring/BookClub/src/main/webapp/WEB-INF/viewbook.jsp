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
<title>View Book</title>
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
                <h1 class="text-primary">{Book Title Goes Here}</h1>
            </div>
            <div class="col-sm-2 text-end">
                <p><a href="/books">back to the shelves</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <p>{user name OR (you if user_name == book creator name} read {book name} by {author name}</p>
                <p>Here are {creator name OR your} thoughts:</p>
            </div>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Repellendus veritatis debitis dignissimos aut consequatur, esse quod saepe, sint voluptate nostrum nemo nulla, minus laborum! Autem, minima qui praesentium officia culpa, vitae maiores animi hic quos quisquam distinctio sit, facilis nulla exercitationem doloribus dolores in reiciendis non magni et possimus eaque incidunt velit magnam? Culpa quo deleniti saepe distinctio nulla hic in consectetur assumenda, minima dignissimos necessitatibus cum, quae explicabo corrupti tempore! Architecto, necessitatibus nesciunt ab non dolor nemo omnis totam ullam dolorem asperiores, voluptatem cumque sequi odio! Illo placeat inventore iusto at eligendi ut repudiandae blanditiis dolorum, ipsa quidem tenetur?</p>
            </div>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-12 text-end">
                <p>{ONLY DISPLAY THIS IF THIS BOOK WAS CREATED BY CURRENT USER!</p>
                <a href="#"><button class="btn btn-primary">Edit</button></a>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>