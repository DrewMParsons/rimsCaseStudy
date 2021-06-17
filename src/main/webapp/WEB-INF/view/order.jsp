<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
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
<link rel="stylesheet" href="css/main.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
		
<title>Order Menu Items</title>
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
					<li class="active nav-item"><a class="nav-link" href="/order">Order Items</a></li>
					<li class="nav-item"><a class="nav-link" href="/order/orderdetails">Order Summary</a></li>
				</ul>	
			</div>
		</nav> 
	</section>
	
<section id="table">	
<div align="center">
    
    
    <table class= "table table-striped table-hover" >
    <thead class="thead-dark">
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Price</th>
            <th scope="col">Description</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listMenuItems}" var="menuItem">
        <tr>
            <th scope="row">${menuItem.title}</th>
            <td>${menuItem.price}</td>
            <td>${menuItem.description}</td>
            
            <td>
            <div>
            	<form:form class="form-horizontal" id="addMenuItemToOrder" action="order/add" method="post" modelAttribute="orderItem">
							<nav>
								<ul class= "pagination">
									<li class="page-item">
										<a data-value="${menuItem.id}" class="page-link minusButton" href=""><b>-</b></a>
									</li>
									<li class="page-item">
										<form:hidden id="menuItem" path="menuItem" value="${menuItem.id}"/>
										<form:input id="quantity${menuItem.id}" path="quantity" type="text" style="max-width: 50px" onkeydown="return false;" class="form-control text-center" value="${quantity}" />
									</li>
									
									<li class="page-item">
										<a data-value="${menuItem.id}"class="page-link plusButton" href=""><b>+</b></a>
									</li>	
									<li class="page-item">
										<button class="btn btn-info" title="ADD TO CART" type="submit" method="POST" value="add"><i class="fas fa-eye"></i></button>
									</li>
									<li class="page-item">
										<a class="btn btn-info" title="VIEW CART" role="button" href="/order/orderdetails"><i class="fas fa-shopping-cart"></i></a>
									</li>
									
								</ul>
							</nav>
							</form:form>
						</div> 
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
  

</div>   
</section>
<script type="text/javascript">
//JS for Closing the Alert-fades out after 3 seconds
setTimeout(function () {
    
	$('.alert').alert('close');
}, 3000);
</script>
<div class="alert alert-sucess fade show" id="success-alert" display="${empty success? none: inline-block}">
  <strong>${success}</strong> 
</div>


 <!-- Footer -->
    <div id="footer">
        <i class="social-icon bi bi-twitter"></i>
        <i class="social-icon bi bi-facebook"></i>
        <i class="social-icon bi bi-linkedin"></i>
        <i class="social-icon bi bi-envelope"></i>
        <p><span>&#169;</span> Copyright 2021 LumpysLounge</p>
    </div>
    <script src="/js/quantity_button.js"></script>
</body>
</html>