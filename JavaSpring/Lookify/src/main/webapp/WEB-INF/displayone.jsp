<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Single Song</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light d-flex flex-column vh-100 justify-content-center align-items-center">
    <a href="/dashboard">Dashboard</a>
    <div class="container">
        <ul>
            <li>Title: <c:out value="${song.title}"/></li>
            <li>Artist: <c:out value="${song.artist}"/></li>
            <li>Rating (1-10) <c:out value="${song.rating}"/></li>
        </ul>
        <a href="/songs/delete/${song.id}"><button class="btn btn-danger">Delete</button></a>
    </div>
</body>
</html>