package com.rims.drew.parsons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.entity.OrderItem;
import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.repository.MenuItemRepository;
import com.rims.drew.parsons.repository.OrderItemRepository;

@Service
public class OrderItemService
{
	@Autowired
	OrderItemRepository orderRepo;
	
	@Autowired
	MenuItemRepository menuItemRepo;
	
	public void save(OrderItem orderItem) {
		orderRepo.save(orderItem);
	}
	public List<OrderItem> listOrderItems(User user){
		return (List<OrderItem>) orderRepo.findByUser(user);
	}
	
	public List<OrderItem> listAll(){
		return (List<OrderItem>) orderRepo.findAll();
	}
	
	public OrderItem get(Long id) {
		return orderRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		orderRepo.deleteById(id);
	}
	
	public Integer addMenuItem(Long menuItemId,Integer quantity, User user) {
		Integer addedQuantity = quantity;
		MenuItem menuItem = menuItemRepo.findById(menuItemId).get();
		
		OrderItem orderItem = orderRepo.findByUserAndMenuItem(user, menuItem);
		
		//check if item was already added to the cart.
		//If yes, update quantity to add additional order
		if(orderItem !=null) {
			addedQuantity = orderItem.getQuantity()+quantity;
			orderItem.setQuantity(addedQuantity);	
		}else {
			//update order item with values
			orderItem = new OrderItem();
			orderItem.setQuantity(quantity);
			orderItem.setUser(user);
			orderItem.setMenuItem(menuItem);
		}
		orderRepo.save(orderItem);
		
		return addedQuantity;
	}

}
