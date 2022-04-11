<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display One</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light p-3">
	<div class="container-fluid border-bottom pb-2 mb-3">
		<div class="row ">
			<div class="col-sm-8">
				<h1 class="text-center"><c:out value="${language.name}"/></h1>
			</div>
			<div class="col-sm-4 text-center">
				<a href="/"><button class="btn btn-primary ">Home</button></a>
			</div>
		</div>
	</div>
    <div class="container text-start">
        <div class="row">
            <ul class="list-unstyled">
                <li class="my-3">Creator: <c:out value="${language.creator}"/></li>
                <li>Version: <c:out value="${language.version}"/></li>
            </ul>
        </div> 
        <div class="row text-center my-5">
            <div class="col-sm-6"><a href="/languages/edit/${language.id}"><button class="btn btn-primary w-25">Edit</button></a></div>
            <div class="col-sm-6"><a href="/languages/delete/${language.id}"><button class="btn btn-danger w-25">Delete</button></a></div>
        </div>
    </div>
</body>
</html>