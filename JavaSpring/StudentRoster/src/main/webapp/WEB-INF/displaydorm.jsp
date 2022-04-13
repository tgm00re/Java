<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dorm.name}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
    <a href="/">Home</a>
    <div class="container">
        <div class="display-1"><c:out value="${dorm.name}"/></div>
        <h2>Add student to <c:out value="${dorm.name}"/></h2>
        <form action="/dorm/add/student/${dorm.id}" method="post">
            <select name="studentId">
                <c:forEach items="${studentWithoutDormList}" var="student">
                    <option value="${student.id}"><c:out value="${student.name}"/></option>
                </c:forEach>
            </select>
            <button class="btn btn-primary" type="submit">Add Student</button>
        </form>
        <h2>Students at <c:out value="${dorm.name}"/>:</h2>
        <ul>
            <c:forEach items="${dorm.students}" var="student">
                <li>
                    <c:out value="${student.name}"/>
                    <a class="text-danger" href="/removefromdorm/${dorm.id}/${student.id}">Remove From Dorm</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>