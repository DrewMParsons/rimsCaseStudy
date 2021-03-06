package com.rims.drew.parsons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.repository.MenuItemRepository;
/**
 * Custom Service class used for the menu item table in the database
 * 
 * 
 * @see MenuItemRepository
 * @author Drew
 *
 */
@Service
@Transactional
public class MenuItemService
{
	@Autowired
	MenuItemRepository menuItemRepo;
	
	public void save(MenuItem menuItem) {
		menuItemRepo.save(menuItem);
	}
	
	/*
	 * method used to return list or menu items.includes parameter for keyword to be used in
	 * search menuitems query
	 */
	public List<MenuItem> listAll(String keyword){
		if(keyword ==null || keyword.isEmpty() || keyword.equals("")) {
			return (List<MenuItem>) menuItemRepo.findAll();
		}
		
		return menuItemRepo.search(keyword);
	}
	
	public MenuItem get(Long id) {
		return menuItemRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		menuItemRepo.deleteById(id);
	}

	public List<MenuItem> search(String keyword)
	{
		// TODO Auto-generated method stub
		return menuItemRepo.search(keyword);
	}

	public MenuItem findByTitle(String title)
	{
		// TODO Auto-generated method stub
		return menuItemRepo.findByTitle(title);
	}

}
