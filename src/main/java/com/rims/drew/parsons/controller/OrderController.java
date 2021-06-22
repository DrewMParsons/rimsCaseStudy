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
import com.rims.drew.parsons.util.Constants;

/**
 * Custom controller for handling all requests related to orders
 * 
 * @author Drew
 *
 */
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

	/*
	 * Handles requests for the order page. Inlcudes call to the DB for all
	 * menuitems, checks DB for user auth and details.
	 */
	@RequestMapping()
	public String order(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User user = userService.findByUsername(userName);

		List<MenuItem> menuItemList = menuItemService.listAll(null);

		OrderItem orderItem = new OrderItem();
		model.addAttribute("listMenuItems", menuItemList);
		model.addAttribute("orderItem", orderItem);
		model.addAttribute("user", user);

		return Constants.ORDER_PAGE;
	}

	/*
	 * Method call for adding an item to a users order. call to DB for user auth and
	 * to add item to users order Includes a check on quantity of zero Success
	 * message is returned to the screen in case of item added or item quantity of
	 * zero
	 */
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addMenuItemToOrder(@ModelAttribute("orderItem") OrderItem orderItem,
//			RedirectAttributes redirectAttributes)
//	{
//		
//			int quantity = orderItem.getQuantity();
//			if(quantity<1) {
//				redirectAttributes.addFlashAttribute("success",
//						"Quantity must be greater than "+ quantity);
//				return "redirect:/order";
//			}
//		
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			String userName = auth.getName();
//			User user = userService.findByUsername(userName);
//			Integer addQuantity = orderItemService.addMenuItem(orderItem.getMenuItem().getId(), orderItem.getQuantity(),
//					user);
//			redirectAttributes.addFlashAttribute("success",
//					addQuantity + " " + orderItem.getMenuItem().getTitle() + " added to order");
//			return "redirect:/order";
//			
//		
//	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMenuItemToOrder(@ModelAttribute("orderItem") OrderItem orderItem,
			RedirectAttributes redirectAttributes)
	{
		
			try
			{
				int quantity = orderItem.getQuantity();
				if(quantity<1) {
					throw new OrderException("success",0);		
				}

				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String userName = auth.getName();
				User user = userService.findByUsername(userName);
				Integer addQuantity = orderItemService.addMenuItem(orderItem.getMenuItem().getId(), orderItem.getQuantity(),
						user);
				redirectAttributes.addFlashAttribute("success",
						addQuantity + " " + orderItem.getMenuItem().getTitle() + " added to order");
				return "redirect:/order";
			} catch (OrderException oe)
			{
				
				redirectAttributes.addFlashAttribute(oe.getErrorMessage(),"Quantity must be greater than "+ oe.getQuantity());
				return "redirect:/order";
			}
			
		
	}


	/*
	 * Method for all requests to the order summary page. Checks DB for user auth
	 * and users order items
	 */
	@RequestMapping("/orderdetails")
	public String orderDetails(Model model)
	{

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User user = userService.findByUsername(userName);
		List<OrderItem> orderItems = orderItemService.listOrderItems(user);
		model.addAttribute("listOrderItems", orderItems);
		return Constants.ORDER_DETAIL_PAGE;
	}

	/*
	 * handles calls to remove items from order summary
	 */
	@RequestMapping("/delete")
	public String deleteOrderItem(@RequestParam long id)
	{

		orderItemService.delete(id);
		return "redirect:/order/orderdetails";
	}

	/*
	 * handles calls to complete order, currently only returns success page for
	 * order
	 * 
	 */
	@RequestMapping("/ordercomplete")
	public String completeOrder()
	{

		return Constants.ORDER_COMPLETE_PAGE;
	}

}
