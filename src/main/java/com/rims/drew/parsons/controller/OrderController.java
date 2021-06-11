package com.rims.drew.parsons.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rims.drew.parsons.entity.MenuItem;

import com.rims.drew.parsons.service.MenuItemService;
import com.rims.drew.parsons.service.OrderItemService;

@Controller
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private OrderItemService orderService;
	
	
	
	@GetMapping()
	public String home(Model model,Map<String,Object> mapModel)
	{
		
		List<MenuItem> menuItemList= menuItemService.listAll(null);
		
		model.addAttribute("listMenuItems",menuItemList);
		
		return "order";
	}

}
