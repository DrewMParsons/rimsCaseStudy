package com.rims.drew.parsons.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	private List<MenuItem> menuItemList;
	
	@RequestMapping
	public String home(Model model,@Param("keyword")String keyword) {
		menuItemList = menuItemService.listAll(keyword);
		model.addAttribute("listMenuItems",menuItemList);
		model.addAttribute("keyword",keyword);
	
		
		return "menu_index";
	}
	
	@RequestMapping("/new")
	public String newMenuItem(Model model, Map<String,Object> mapModel) {
		MenuItem menuItem = new MenuItem();
		model.addAttribute("menuItem",menuItem);
		//mapModel.put("menuItem",menuItem);
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
		menuItemList = menuItemService.search(keyword);
	
		ModelAndView mav = new ModelAndView("menu_index");
		mav.addObject("listMenuItems",menuItemList);
		return mav; 
    }
	

}
