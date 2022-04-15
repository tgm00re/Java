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
<title>Book Creation</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="bg-dark text-light">
    <div class="container p-2"> <!-- Beginning of Container -->
        <div class="row">
            <div class="col-sm-10">
                <h1 class="text-primary">Add a Book to Your shelf!</h1>
            </div>
            <div class="col-sm-2 text-end">
                <p><a href="/books">back to the shelves</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <form:form>
                    <div class="form-group my-3">
                        <form:label for="title">Title</form:label>
                        <form:input type="text" class="form-control" id="" placeholder="Enter Title"/>
                        <form:errors path="title" class="text-danger"/>
                    </div>
                    <div class="form-group my-3">
                        <form:label for="authorName">Author Name</form:label>
                        <form:input type="text" class="form-control" id="authorName" placeholder="Enter Author Name"/>
                        <form:errors path="authorName" class="text-danger"/>
                    </div>
                    <div class="form-group my-3"> <!-- Text area-->
                        <form:label for="description">My Thoughts</form:label>
                        <form:errors path="description" class="text-danger"/>
                        <form:textarea class="form-control" id="description" rows="3" placeholder="Enter your thoughts here!"></form:textarea>                    
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>