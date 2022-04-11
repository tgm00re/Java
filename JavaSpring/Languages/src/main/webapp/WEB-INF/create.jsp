<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light p-3">
	<div class="container-fluid border-bottom pb-2 mb-3">
		<div class="row ">
			<div class="col-sm-8">
				<h1 class="text-center">Create a Language</h1>
			</div>
			<div class="col-sm-4 text-center">
				<a href="/"><button class="btn btn-primary ">Home</button></a>
			</div>
		</div>
	</div>
    <div class="container">
        <form:form modelAttribute="language" method="post" action="/process/create">
			<div class="row my-3">
			  <div class="col-6">
				<form:input type="text" path="name" class="form-control" placeholder="Name"/>
			  </div>
			  <div class="col-6">
				<form:input type="text" path="creator" class="form-control" placeholder="Creator"/>
			  </div>
			</div>
			<div class="row my-3">
				<div class="col-6">
					<form:input type="text" path="version" class="form-control" placeholder="Version"/>
				</div>
			</div>
			<div class="w-100 text-end">
				<button class="btn btn-success">Create</button>
			</div>
		</form:form>
    </div>
</body>
</html>