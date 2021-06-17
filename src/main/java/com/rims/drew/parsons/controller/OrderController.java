package com.rims.drew.parsons.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.rims.drew.parsons.service.UserServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	
	@RequestMapping()
	public String order(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName =auth.getName();
		User user = userService.findByUsername(userName);
		
		List<MenuItem> menuItemList= menuItemService.listAll(null);
		
		OrderItem orderItem = new OrderItem();
		model.addAttribute("listMenuItems",menuItemList);
		model.addAttribute("orderItem",orderItem);
		model.addAttribute("user",user);
		
		return "order";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMenuItemToOrder(@ModelAttribute("orderItem")OrderItem orderItem, RedirectAttributes redirectAttributes) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName =auth.getName();
		User user = userService.findByUsername(userName);
		Integer addQuantity = orderItemService.addMenuItem(orderItem.getMenuItem().getId(),orderItem.getQuantity(), user);
		redirectAttributes.addFlashAttribute("success", addQuantity + " " + orderItem.getMenuItem().getTitle() + " added to order");
		return "redirect:/order";
		
	
	}
	
	
	@RequestMapping("/orderdetails")
	public String orderDetails(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName =auth.getName();
		User user = userService.findByUsername(userName);
		List<OrderItem> orderItems = orderItemService.listOrderItems(user);
		model.addAttribute("listOrderItems", orderItems);
		return "order_details";
	}
	
	@RequestMapping("/delete")
	public String deleteOrderItem(@RequestParam long id) {
		
		orderItemService.delete(id);
		return "redirect:/order/orderdetails";
	}
	
	@RequestMapping("/ordercomplete")
	public String completeOrder() {
		
		return "order_complete";
	}

}
