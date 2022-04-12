<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Song</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark p-5">
    <div class="container-fluid">
        <div class="row text-end mb-5">
            <a href="/dashboard">Dashboard</a>
        </div>
        <div class="row">
            <form:form modelAttribute="song" method="post" action="/process/create">
                <div class="form-group my-3">
                    <form:errors path="title" class="text-danger"/>
                  <form:input type="text" path="title" class="form-control" id="title" placeholder="Title"/>
                </div>
                <div class="form-group my-3">
                    <form:errors path="artist" class="text-danger"/>
                    <form:input type="text" path="artist" class="form-control" id="artist" placeholder="Artist"/>
                  </div>
                  <div class="form-group my-3">
                    <form:errors path="rating" class="text-danger"/>
                    <form:input type="number" path="rating" class="form-control" id="Rating" min="1" max="10" placeholder="rating"/>
                  </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form:form>
        </div>
    </div>
</body>
</html>