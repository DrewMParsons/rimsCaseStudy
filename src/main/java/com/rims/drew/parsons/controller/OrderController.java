package com.rims.drew.parsons.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String order(Model model)
	{
		
		OrderItem orderItem = new OrderItem();
		List<MenuItem> menuItemList= menuItemService.listAll(null);
		User user = userService.findById(1L);
		List<OrderItem> orderItems = orderItemService.listOrderItems(user);
		model.addAttribute("listOrderItems", orderItems);
		model.addAttribute("listMenuItems",menuItemList);
		model.addAttribute("orderItem",orderItem);
		
		return "order";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMenuItemToOrder(@ModelAttribute("orderItem")OrderItem orderItem, RedirectAttributes redirectAttributes) {
		
		User user = userService.findById(1L);
		Integer addQuantity = orderItemService.addMenuItem(orderItem.getMenuItem().getId(),orderItem.getQuantity(), user);
		redirectAttributes.addFlashAttribute("success", addQuantity + " " + orderItem.getMenuItem().getTitle() + " added to order");
		return "redirect:/order";
		
	
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
