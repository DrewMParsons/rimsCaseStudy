package com.rims.drew.parsons.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.service.MenuItemService;

@Controller
@RequestMapping("/menu")
public class MenuController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@RequestMapping
	public ModelAndView home() {
		List<MenuItem> menuItemsList = menuItemService.listAll();
		ModelAndView mav = new ModelAndView("menu_index");
		mav.addObject("listMenuItems",menuItemsList);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newMenuItem(Map<String,Object> model) {
		MenuItem menuItem = new MenuItem();
		model.put("menuItem",menuItem);
		return "new_menu_item";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMenuItem(@ModelAttribute("menuItem")MenuItem menuItem) {
		menuItemService.save(menuItem);
		return "redirect:/menu";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editMenuItem(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_menu_item");
		MenuItem menuItem = menuItemService.get(id);
		mav.addObject("menuItem", menuItem);
		return mav;	
	}
	
	@RequestMapping("/delete")
	public String deleteMenuItem(@RequestParam long id) {
		menuItemService.delete(id);
		return "redirect:/menu";
	}
	
	@RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
		List<MenuItem> result = menuItemService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
     
        return mav;    
    }
	

}
