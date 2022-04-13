<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>New Dojo</h1>
    <form:form action="/dojo/create" modelAttribute="dojo" method="post">
        <form:label path="name">Name:</form:label>
        <form:input path="name" type="text"/>
        <form:errors path="name"/>
        <button type="submit">Submit</button>
    </form:form>
    <h2>All Dojos</h2>
    <table>
        <tr>
            <th>Name</th>
        </tr>
        <c:forEach items="${dojoList}" var="dojo">
            <tr>
                <td><c:out value="${dojo.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>