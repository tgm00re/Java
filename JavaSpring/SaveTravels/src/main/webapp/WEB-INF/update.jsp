<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container bg-dark text-light p-5">
        <form:form action="/expense/edit/process/${expense.id}" method="post" modelAttribute="expense">
			<div class="form-group">
                <form:errors path="name" class="text-danger"/>
			    <form:input type="text" path="name" class="form-control" id="name" placeholder="Expense Name"/>
			  </div>
              <div class="form-group">
	            <form:errors path="vendor" class="text-danger"/>
			    <form:input type="text" path="vendor" class="form-control" id="vendor" placeholder="Vendor"/>
			  </div>
              <div class="form-group">
	            <form:errors path="price" class="text-danger"/>
			    <form:input type="number" path="price" class="form-control" id="price" placeholder="Price" step="0.01"/>
			  </div>
              <div class="form-group">
                <form:errors path="description" class="text-danger"/>
			    <form:textarea type="text" path="description" class="form-control" id="description" placeholder="Description"></form:textarea>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
    </div>
</body>
</html>