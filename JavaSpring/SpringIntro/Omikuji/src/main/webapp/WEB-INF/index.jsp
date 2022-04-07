<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
	<div class="container">
		<form action="/handleform" method="post">
		<div class="form-group">
		    <label for="exampleFormControlSelect1">Pick any number from 5 to 25</label>
		    <input type="number" name="number" min="5" max="25" required/>
		  </div>
		  <div class="form-group my-2">
		    <input type="text" class="form-control" name="city" placeholder="Enter name of any city">
		  </div>
		  <div class="form-group my-2">
		    <input type="text" class="form-control" name="person" placeholder="Enter name of any real person">
		  </div>
		  <div class="form-group my-2">
		    <input type="text" class="form-control" name="hobby" placeholder="Enter professional endeavor or hobby">
		  </div>
		  <div class="form-group my-2">
		    <input type="text" class="form-control" name="thing" placeholder="Enter any type of living thing">
		  </div>
		  
		  <div class="form-group my-2">
		    <label for="">Say something nice to someone.</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" name="message" rows="3"></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		
</div>
</body>
</html>


