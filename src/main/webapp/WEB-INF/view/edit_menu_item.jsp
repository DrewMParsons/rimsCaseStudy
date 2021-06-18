<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
		
<title>Edit Menu Item</title>
</head>
<body>
	<section class="title"> 
	<!-- NAVIGATION BAR --> 
		<nav class="navbar navbar-expand-lg navbar-dark "> 
			<a class="navbar-brand" href="/logout">RIMS</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarToggler" aria-controls="navbarToggler"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarToggler">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/menu">Menu</a></li>
					<li class="nav-item"><a class="nav-link" href="/menu/new">New Item</a></li>
					<li class="nav-item"><a class="nav-link" href="/order">Order</a></li>
				</ul>
			</div>
		</nav> 
	</section>
	

	<form:form class="form-horizontal" id="newMenuItemForm" 
		method="post" modelAttribute="menuItem">
		<fieldset>

			<!-- Form Name -->
			<h1>Edit Item: ${menuItem.title}</h1>

			<!-- Text input-->
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="idfield">ID</label>
				<div class="col-md-4">
					<form:input id="idfield" path="id" class="form-control input-md"
						readonly="true" value="${menuItem.id}" />
				</div>
			</div>
			<spring:bind path="title">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-md-4 control-label" for="titleinput">Title</label>
					<div class="col-md-4">
						<form:input id="titleinput" path="title" type="text"
							placeholder="menu item title" class="form-control input-md" />
						<form:errors path="title"></form:errors>
					</div>
				</div>
			</spring:bind>

			<!-- Text input-->
			<spring:bind path="price">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-md-4 control-label" for="priceinput">Price</label>
					<div class="col-md-4">
						<form:input id="priceinput" path="price" type="number" step="0.01" min="1" max="1000"
							 class="form-control input-md" />
							<form:errors path="price"></form:errors>
					</div>
				</div>
				</spring:bind>
			

			<spring:bind path="description">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-md-4 control-label" for="descriptioninput">Description</label>
					<div class="col-md-4">
						<form:input id="descriptioninput" path="description" type="text"
							placeholder="brief description of menu item"
							class="form-control input-md" />
							<form:errors path="description"></form:errors>
					</div>
				</div>
			</spring:bind>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id">Submit</label>
				<div class="col-md-8">
					<button id="button1id" name="button1id" class="btn btn-dark"
						type="submit">Save</button>
					<a class="btn btn-dark" title="CANCEL" role="button" href="/menu">Cancel</a>
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