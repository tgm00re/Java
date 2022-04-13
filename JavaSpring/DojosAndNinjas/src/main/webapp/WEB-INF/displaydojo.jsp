<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Single dojo</title>
</head>
<body>
    <h1><c:out value="${dojo.name}"/></h1>
    <h3>Students:</h3>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        <c:forEach items="${dojo.ninjas}" var="ninja">
            <tr>
                <td><c:out value="${ninja.firstName}"/></td>
                <td><c:out value="${ninja.lastName}"/></td>
                <td><c:out value="${ninja.age}"/></td>
            </tr>
        </c:forEach>
        
    </table>
</body>
</html>