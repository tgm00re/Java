<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninja</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/ninja/create" modelAttribute="ninja" method="post">
        <form:select path="dojo">
            <c:forEach items="${dojoList}" var="dojo">
                <form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>            
            </c:forEach>
        </form:select>
        <div class="form-group">
            <form:label path="firstName">Name:</form:label>
            <form:input path="firstName" type="text"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name</form:label>
            <form:input path="lastName" type="text"/>
        </div>
        <div class="form-group">
            <form:label path="age">Age</form:label>
            <form:input type="number" path="age"/>
        </div>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>