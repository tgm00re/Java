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
<title>Create Question</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container p-5"> <!-- Beginning of Container -->
        <div class="row">
            <h1><c:out value="${question.question}"/></h1>
            <a href="/">Dashboard</a>
        </div>
        <div class="row">
            <p>Tags: 
                    <c:forEach items="${question.tags}" var="tag">
                       <c:out value="${tag.subject}"/>
                    </c:forEach>
            </p>
        </div>
        <div class="row">
            <h2>Answers</h2>
            <ul>
                <c:forEach items="${question.answers}" var="answer">
                    <li><c:out value="${answer.answer}"/></li>
                </c:forEach>
            </ul>
        </div>
        <div class="row">
            <h3>Add an answer</h3>
            <form:form modelAttribute="myAnswer" method="post" action="/answer/processcreate/${question.id}">
                <form:label path="answer">Your Answer: </form:label>
                <form:input type="text" path="answer" id="answer"/>
                <form:errors path="answer" class="text-danger"/>
                <input type="submit" value="Submit"/>
            </form:form>
        </div>
    </div> <!-- End of Container -->
</body>
</html>