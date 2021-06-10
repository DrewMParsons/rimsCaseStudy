package com.rims.drew.parsons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rims.drew.parsons.entity.OrderItem;
import com.rims.drew.parsons.repository.OrderItemRepository;

public class OrderItemService
{
	@Autowired
	OrderItemRepository repo;
	
	public void save(OrderItem orderItem) {
		repo.save(orderItem);
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
