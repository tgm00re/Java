<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Your Gold: <c:out value="${gold}"/></h1>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="card" style="width: 18rem;">
				  <div class="card-body">
				    <h5 class="card-title">Farm</h5>
				    <p class="card-text">Earns 10-20 gold.</p>
				    <form action="/find" method="post">
				    	<input type="hidden" name="adventure" value="farm"/>
				    	<button class="btn btn-primary">Find gold</button>
				    </form>
				  </div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" style="width: 18rem;">
				  <div class="card-body">
				    <h5 class="card-title">Cave</h5>
				    <p class="card-text">Earns 10-20 gold.</p>
				    <form action="/find" method="post">
				    	<input type="hidden" name="adventure" value="cave"/>
				    	<button class="btn btn-primary">Find gold</button>
				    </form>
				  </div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" style="width: 18rem;">
				  <div class="card-body">
				    <h5 class="card-title">House</h5>
				    <p class="card-text">Earns 10-20 gold.</p>
				    <form action="/find" method="post">
				    	<input type="hidden" name="adventure" value="house"/>
				    	<button class="btn btn-primary">Find gold</button>
				    </form>
				  </div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card" style="width: 18rem;">
				  <div class="card-body">
				    <h5 class="card-title">Quest</h5>
				    <p class="card-text">Earns/takes 0-50 gold.</p>
				    <form action="/find" method="post">
				    	<input type="hidden" name="adventure" value="quest"/>
				    	<button class="btn btn-primary">Find gold</button>
				    </form>
				  </div>
				</div>
			</div>
		</div>
		<div class="row">
			<ul class="list-group">
			   <c:forEach var="activity" items="${activities}" >
			  	<li class="list-group-item"><c:out value="${activity}"/></li>
			  </c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>