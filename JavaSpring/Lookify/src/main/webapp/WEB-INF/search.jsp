<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
    <nav class="d-flex justify-content-around p-3 align-items-center">
      <p>Song by artist: <c:out value="${name}"/></p>
      <form class="form-inline my-2 my-lg-0 d-flex" method="post" action="/process/search">
        <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search"/>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
      <a href="/dashboard">Dashboard</a>
    </nav>
    <div class="container">
        <table class="table table-dark">
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Rating</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${songList}" var="song">
            <tr>
              <td><a href="/songs/view/${song.id}"><c:out value="${song.title}"/></a></td>
              <td><c:out value="${song.rating}"/></td>
              <td><a class="text-danger" href="/songs/delete/${song.id}">Delete</a></td>
            </tr>
          </c:forEach>
    </div>
    

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>