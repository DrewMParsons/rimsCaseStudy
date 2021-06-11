package com.rims.drew.parsons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rims.drew.parsons.entity.OrderItem;
import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.repository.OrderItemRepository;

@Service
public class OrderItemService
{
	@Autowired
	OrderItemRepository repo;
	
	public void save(OrderItem orderItem) {
		repo.save(orderItem);
	}
	public List<OrderItem> listOrderItems(User user){
		return (List<OrderItem>) repo.findByUser(user);
	}
	
	public List<OrderItem> listAll(){
		return (List<OrderItem>) repo.findAll();
	}
	
	public OrderItem get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
