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
<link rel="stylesheet" href="css/main.css">

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<title>Menu Items</title>
</head>
<body>
<section id="table">
<div class="topnav">
 		<a href="${pageContext.request.contextPath}/">Home</a>
 		<a class="active" href="${pageContext.request.contextPath}/menu">Menu</a>
    	<a href="#">Order Summary</a>
    	
    	<div class="search-container">
    		<form method="get" action="menu/search">
      			<input type="text" placeholder="Search.." name="keyword">
      			<button type="submit" value="Search"><i class="fa fa-search"></i></button>
    		</form>
  		</div>
	</div>
<div align="center">
    
    
<!--     <form method="get" action="customer/search"> -->
<!--         <input type="text" name="keyword" /> &nbsp; -->
<!--         <input type="submit" value="Search" /> -->
<!--     </form> -->
    
    <table class= "table table-striped table-hover" >
    <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Price</th>
            <th scope="col">Description</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listMenuItems}" var="menuItem">
        <tr>
            <th scope="row">${menuItem.id}</th>
            <td>${menuItem.title}</td>
            <td>${menuItem.price}</td>
            <td>${menuItem.description}</td>
            
            <td>
            <a class="btn btn-info" role="button" href="menu/edit?id=${menuItem.id}"><i class="fas fa-edit"></i></a>
<%--             <a class="btn btn-info" role="button" href="menuItem/order?id=${menuItem.id}"><i class="far fa-eye"></i></a> --%>
            <a class="btn btn-info" role="button" href="menu/delete?id=${menuItem.id}"><i class="far fa-trash-alt"></i></a>
             
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
  
    <a href="menu/new" role="button" class="btn btn-outline-light btn-lg"><i
                            class="bi bi-door-open-fill"></i>New Menu Item</a>

</div>   
</section>
 <!-- Footer -->
    <div id="footer">
        <i class="social-icon bi bi-twitter"></i>
        <i class="social-icon bi bi-facebook"></i>
        <i class="social-icon bi bi-linkedin"></i>
        <i class="social-icon bi bi-envelope"></i>
        <p><span>&#169;</span> Copyright 2021 LumpysLounge</p>
    </div>
</body>
</html>