<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Languages</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light p-3">
    <h1 class="text-center border-bottom pb-3">Languages</h1>
    <div class="container">
        <div class="row">
            <table class="table table-dark mb-5">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Creator</th>
                <th scope="col">Version</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${languageList}" var="language">
              <tr>
             	<th scope="row"><a href="/languages/view/${language.id}"><c:out value="${language.name}"/></a></th>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td><a href="/languages/edit/${language.id}"><button class="btn btn-primary w-10">Edit</button></a> | <a href="/languages/delete/${language.id}"><button class="btn btn-danger w-10">Delete</button></a></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="row">
            <div class="col text-center"><a href="/create"><button class="btn btn-primary w-10">Add A Langauge</button></a></div>
        </div>
        
    </div>
</body>
</html>