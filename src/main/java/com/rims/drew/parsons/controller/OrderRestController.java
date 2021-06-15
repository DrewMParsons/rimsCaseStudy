package com.rims.drew.parsons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.service.OrderItemService;
import com.rims.drew.parsons.service.UserService;

@RestController
public class OrderRestController
{
	@Autowired
	private OrderItemService orderService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/order/add/{menuItemId}/{quantity}")
	public String addMenuItemToOrder(@PathVariable("menuItemId")Long menuItemId,
			@PathVariable("quantity")Integer quantity) {
		
		User user = userService.findById(1L);
		Integer addQuantity = orderService.addMenuItem(menuItemId, quantity, user);
		
		return addQuantity+ "added to cart";
	
	}
	

}
