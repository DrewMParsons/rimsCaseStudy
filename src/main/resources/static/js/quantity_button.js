/*
Functions used to create onclick functionality for plus and minus buttons located on the order and order details pages
The input form field is updated when either the plus or minus button are clicked
Will not update if: new value from minus would be zero(customer should use delete button)
Will not update if: new value from plus is greater than 20 (max amount allowed to be ordered at a time)

*/




$(document).ready(function(){
	$(".minusButton").on("click",function(event){
	event.preventDefault();
	orderItemId = $(this).data("value");
	console.log(orderItemId);
	quantityInput = document.getElementById("quantity"+ orderItemId);
	console.log(quantityInput.value);
	newQuantity = parseInt(quantityInput.value)-1;
	if(newQuantity>0) quantityInput.value= newQuantity;
	
//	quantityInput = $("quantity"+ orderItemId);
//	console.log(quantityInput.value);
//	newQuantity = parseInt(quantityInput.val())-1;
//	if(newQuantity>0) quantityInput.val(newQuantity);

	});
	
	$(".plusButton").on("click",function(event){
	event.preventDefault();
	orderItemId = $(this).data("value");
	console.log(orderItemId);
	quantityInput = document.getElementById("quantity"+ orderItemId);
	console.log(quantityInput.value);
	newQuantity = parseInt(quantityInput.value)+1;
	if(newQuantity<=20) quantityInput.value= newQuantity;
	


	});
});


