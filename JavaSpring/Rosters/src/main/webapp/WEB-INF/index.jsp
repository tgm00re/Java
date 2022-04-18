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
<title>Create</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <div class="row">
            <div class="col-sm-5">
                <h1>Create Student</h1>
                <form:form action="/create/student" modelAttribute="student" method="post">
                    <form:label path="name">Name</form:label>
                    <form:input type="text" path="name" id="name"/>
                    <input type="submit" value="Add Student"/>
                </form:form>
                <ul>
                    <c:forEach items="${studentList}" var="student">
                        <li><a href="/view/student/${student.id}"><c:out value="${student.name}"/></a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-sm-2"></div>
            <div class="col-sm-5">
                <h1>Create Class</h1>
                <form:form action="/create/class" modelAttribute="class" method="post">
                    <form:label path="name">Name</form:label>
                    <form:input type="text" path="name" id="name"/>
                    <button type="submit">Submit</button>
                </form:form>
                <c:forEach items="${classList}" var="oneClass">
                         <li><a href="/view/class/${oneClass.id}"><c:out value="${oneClass.name}"/></a></li> 
                    </c:forEach>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>