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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.service.MenuItemService;
import com.rims.drew.parsons.validator.MenuItemValidator;

@Controller
@RequestMapping("/menu")
public class MenuController
{
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private MenuItemValidator menuItemValidator;
	
	private List<MenuItem> menuItemList;
	
	@RequestMapping
	public String home(Model model,@Param("keyword")String keyword) {
		menuItemList = menuItemService.listAll(keyword);
		model.addAttribute("listMenuItems",menuItemList);
		model.addAttribute("keyword",keyword);
	
		
		return "menu_index";
	}
	
	@GetMapping("/new")
	public String newMenuItem(Model model, Map<String,Object> mapModel) {
		MenuItem menuItem = new MenuItem();
		model.addAttribute("menuItem",menuItem);
		//mapModel.put("menuItem",menuItem);
		return "new_menu_item";
	}
	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("new")
	public String saveMenuItem(@ModelAttribute("menuItem")MenuItem menuItem,BindingResult bindingResult) {
		menuItemValidator.validate(menuItem, bindingResult);
		
		 if (bindingResult.hasErrors()) {
	            return "new_menu_item";
	        }
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
	
	@PostMapping("/edit")
	public String updateMenuItem(@ModelAttribute("menuItem")MenuItem menuItem,BindingResult bindingResult) {
		menuItemValidator.validate(menuItem, bindingResult);
		
		 if (bindingResult.hasErrors()) {
	            return "edit_menu_item";
	        }
		menuItemService.save(menuItem);
		return "redirect:/menu";
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
