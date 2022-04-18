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
            <h1>Questions Dashboard</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-12">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">Question</th>
                  <th scope="col">Tags</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${questionList}" var="question">
                  <tr>
                    <td><a href="/view/question/${question.id}"><c:out value="${question.question}"/></a></td>
                    <td>
                      <c:forEach items="${question.tags}" var="tag">
                        <span><c:out value="${tag.subject}"/>,</span>
                      </c:forEach>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="row text-end">
          <a href="/create/question">New Question</a>
        </div>
    </div> <!-- End of Container -->
</body>
</html>