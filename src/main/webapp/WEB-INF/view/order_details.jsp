<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
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
		
<title>Order Details</title>
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
					<li class="nav-item"><a class="nav-link" href="/menu/new">New Item</a></li>
					<li class="nav-item"><a class="nav-link" href="/order">Order Items</a></li>
					<li class="active nav-item"><a class="nav-link" href="/order/orderdetails">Order Summary</a></li>
				</ul>	
			</div>
		</nav> 
	</section>
	
<section id="hero">	
	<div>
		<h1>Order Details:</h1>
	 	<br/>
	</div>   
	
	<div class="row m-1">
		<div class="col-sm-8">
			<c:forEach items = "${listOrderItems}" var="orderItem">
				<div class="row border rounded">
					<div class="col-2">
						<div>${orderItem.id}</div>
						<div><a class="delete-item btn btn-info" role="button" href="/order/delete?id=${orderItem.id}"><i class="fas fa-trash"></i></a></div>
						
					</div>
					<div class = "col-6">
						<div>
							<span class="h4">${orderItem.menuItem.title}</span>
						</div>
						<div>
							<span class="h4">Quantity: </span>
							<span class="h4">${orderItem.quantity}</span>
						</div>
						
						<div>
							<span class="h4">Subtotal = $</span>
							<span class="h4 itemSubtotal">${orderItem.menuItem.price * orderItem.quantity}</span>
						</div>
					</div>
				</div>
				<div class="row m-1">&#160;</div>
			</c:forEach>
		</div>
		<div class="col-sm-4">
			<div>
				<span class="h3">Sub Total: $ </span> <span class="h3" id="total"></span>
			</div>
			<div class="mt-2">
				<span class="h3" >Total(+ tax): $ </span><span class="h3" id="totalWithTax"></span>
			</div>
			<div class="mt-2">
				<a href="order/order_complete" role="button" class="btn btn-dark btn-lg"><i
                            class="bi bi-cart-check-fill"></i>Order Now</a>
			</div>
		</div>
	</div>
</section>
 <!-- Footer -->
 <!--TODO:Footer IS NOT RESPONSIVE, TOO BIG, CUTS OFF BOTTOM OF SECTION IN SMALL SCREEN  --> 
    <div id="footer">
        <i class="social-icon bi bi-twitter"></i>
        <i class="social-icon bi bi-facebook"></i>
        <i class="social-icon bi bi-linkedin"></i>
        <i class="social-icon bi bi-envelope"></i>
        <p><span>&#169;</span> Copyright 2021 LumpysLounge</p>
    </div>
    <script src="/js/quantity_button.js"></script>
    <script src="/js/update_quantity.js"></script>
</body>
</html>