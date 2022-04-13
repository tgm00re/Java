<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
    <div class="container">
        <a href="/student">Create A Student</a>
        <h1 class="display-1">Dormitories</h1>
        <form:form modelAttribute="dormitory" method="post" action="/dorm/create">
            <div class="form-group my-3 w-25">
              <form:label path="name">Create A Dorm</form:label>
              <form:input type="text" class="form-control" path="name" id="name" placeholder="Enter name"/>
              <form:errors path="name" class="text-danger"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form:form>

          <h2 class="display-4 mt-5 text-center">All Dorms</h2>
          <ul class="d-flex justify-content-between">
              <c:forEach items="${dormList}" var="dorm">
                <li><a href="/dorm/view/${dorm.id}"><c:out value="${dorm.name}"/></a></li>
              </c:forEach>
          </ul>
    </div>
</body>
</html>