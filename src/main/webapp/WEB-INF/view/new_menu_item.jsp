<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
	
<link rel="stylesheet" href="/css/main.css">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<title>New Menu Item</title>
</head>
<body>
	<section class="title"> 
		<!-- NAVIGATION BAR --> 
			<nav class="navbar navbar-expand-lg navbar-dark "> 
				<a class="navbar-brand" href="/">RIMS</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarToggler" aria-controls="navbarToggler"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarToggler">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="/menu">Menu</a></li>
						<li class="active nav-item"><a class="nav-link" href="/menu/new">New Item</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Order Summary</a></li>
					</ul>
				</div>
			</nav> 
		</section>
	
	<form:form class="form-horizontal" id="newMenuItemForm" action="save" method="post" modelAttribute="menuItem">
		<fieldset>

			<!-- Form Name -->
			<legend>New Menu Item</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="titleinput">Title</label>
				<div class="col-md-4">
					<form:input id="titleinput" path="title" type="text"
						placeholder="menu item title" class="form-control input-md" />
					
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="priceinput">Price</label>
				<div class="col-md-4">
					<form:input id="priceinput" path="price" type="text"
						placeholder="00.00" class="form-control input-md" /> 
				</div>
			</div>
			

			<div class="form-group">
				<label class="col-md-4 control-label" for="descriptioninput">Description</label>
				<div class="col-md-4">
					<form:input id="descriptioninput" path="description" type="text"
						placeholder="brief description of menu item" class="form-control input-md" /> 
				</div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id">Submit</label>
				<div class="col-md-8">
					<button id="button1id" name="button1id" class="btn btn-dark"
						type="submit" value="save">Create</button>
<!-- 					<button id="button2id" name="button2id" class="btn btn-dark">Cancel</button> -->
				</div>
			</div>

		</fieldset>
	</form:form>
	<!-- Footer -->
	<div id="footer">
		<i class="social-icon bi bi-twitter"></i> <i
			class="social-icon bi bi-facebook"></i> <i
			class="social-icon bi bi-linkedin"></i> <i
			class="social-icon bi bi-envelope"></i>
		<p>
			<span>&#169;</span> Copyright 2021 LumpysLounge
		</p>
	</div>
</body>
</html>