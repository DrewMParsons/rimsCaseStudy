package com.rims.drew.parsons.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.entity.Order;
import com.rims.drew.parsons.service.MenuItemService;
import com.rims.drew.parsons.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private OrderService orderService;
	
	private List<MenuItem> menuItemList;
	
	@GetMapping()
	public String home(Model model,Map<String,Object> mapModel)
	{
		Order order = new Order();
		menuItemList= menuItemService.listAll(null);
		model.addAttribute("order", order);
		model.addAttribute("listMenuItems",menuItemList);
		
		return "order";
	}

}
