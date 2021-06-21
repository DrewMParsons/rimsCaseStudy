/**
 * Script used to update the calculated Total on the order summary when the quantity is changed.DOES NOT UPDATE ON THE DB!
 */
 const SALES_TAX = .06;
$(document).ready(function(){
	updateTotal();
	
});

function updateTotal(){
	total = 0.0;
	$(".itemSubtotal").each(function(index,element){
		total = total + parseFloat(element.innerHTML)
	});
	$("#total").text(total);
	totalWithTax = Math.round((total +(total*SALES_TAX)+Number.EPSILON)*100)/100;
	$("#totalWithTax").text(totalWithTax);
};

function updateSubTotal(){
	$(".itemQuantity").each(function(index,element){
		quantity = parseInt(element.value);
		(".itemSubtotal").text(quantity*10);
	});
};