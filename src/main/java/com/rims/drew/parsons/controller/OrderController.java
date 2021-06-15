package com.rims.drew.parsons.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.entity.OrderItem;
import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.service.MenuItemService;
import com.rims.drew.parsons.service.OrderItemService;
import com.rims.drew.parsons.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	
	@RequestMapping()
	public String order(Model model,Map<String,Object> mapModel)
	{
		
		List<MenuItem> menuItemList= menuItemService.listAll(null);
		
		model.addAttribute("listMenuItems",menuItemList);
		
		return "order";
	}
	
	//TODO: add auth to only allow logged in user to view page
	//TODO: GET RID OF HARDWIRED USER
	@RequestMapping("/orderdetails")
	public String orderDetails(Model model) {
		
		User user = userService.findById(1L);
		List<OrderItem> orderItems = orderItemService.listOrderItems(user);
		model.addAttribute("listOrderItems", orderItems);
		return "order_details";
	}
	
	@RequestMapping("/delete")
	public String deleteOrderItem(@RequestParam long id) {
		
		orderItemService.delete(id);
		return "redirect:/order/orderdetails";
	}

}
