package com.rims.drew.parsons.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.service.MenuItemService;
import com.rims.drew.parsons.util.Constants;
import com.rims.drew.parsons.validator.EditMenuItemValidator;
import com.rims.drew.parsons.validator.MenuItemValidator;
/**
 * Custom controller for handling all reuqests relating to menu_items and the menu
 * @author Drew
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private MenuItemValidator menuItemValidator;
	
	@Autowired
	private EditMenuItemValidator editMenuItemValidator;
	private List<MenuItem> menuItemList;
	
	/*
	 * Method for menu home page.  imports menu items from DB
	 * also handles any search calls using the @Param keyword entered by the user
	 */
	@RequestMapping

	public String home(Model model,@Param("keyword")String keyword) {
		menuItemList = menuItemService.listAll(keyword);
		model.addAttribute("listMenuItems",menuItemList);
		model.addAttribute("keyword",keyword);
	
		
		return Constants.MENU_PAGE;
	}
	
	/*
	 * Method for new menu item requests
	 */
	@GetMapping("/new")
	public String newMenuItem(Model model, Map<String,Object> mapModel) {
		MenuItem menuItem = new MenuItem();
		model.addAttribute("menuItem",menuItem);
		
		return Constants.NEW_MENU_ITEM_PAGE;
	}
	
	/*
	 * Method for new menu item saves.  includes BindingResult to handle  errors
	 */
	@PostMapping("new")
	public String saveMenuItem(@ModelAttribute("menuItem")MenuItem menuItem,BindingResult bindingResult) {
		menuItemValidator.validate(menuItem, bindingResult);
		
		 if (bindingResult.hasErrors()) {
	            return Constants.NEW_MENU_ITEM_PAGE;
	        }
		menuItemService.save(menuItem);
		return "redirect:/menu";
	}
	/*
	 * Method to handle requests of editing of menu items
	 */
	@RequestMapping("/edit")
	public ModelAndView editMenuItem(@RequestParam long id) {
		ModelAndView mav = new ModelAndView(Constants.EDIT_MENU_ITEM_PAGE);
		MenuItem menuItem = menuItemService.get(id);
		mav.addObject("menuItem", menuItem);
		return mav;	
	}
	/*
	 * Method to handle saving updated menu items. includes BindingResult to handle  errors
	 */
	@PostMapping("/edit")
	public String updateMenuItem(@ModelAttribute("menuItem")MenuItem menuItem,BindingResult bindingResult) {
		editMenuItemValidator.validate(menuItem, bindingResult);
		
		 if (bindingResult.hasErrors()) {
	            return Constants.EDIT_MENU_ITEM_PAGE;
	        }
		menuItemService.save(menuItem);
		return "redirect:/menu";
	}
	
	/*
	 * Delete menu item request handler
	 */
	
	@RequestMapping("/delete")
	public String deleteMenuItem(@RequestParam long id) {
		menuItemService.delete(id);
		return "redirect:/menu";
	}
	/*
	 * Search request handler
	 */
	@RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
		menuItemList = menuItemService.search(keyword);
	
		ModelAndView mav = new ModelAndView(Constants.MENU_PAGE);
		mav.addObject("listMenuItems",menuItemList);
		return mav; 
    }
	

}
