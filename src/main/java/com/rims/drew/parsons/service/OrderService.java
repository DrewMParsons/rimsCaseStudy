package com.rims.drew.parsons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rims.drew.parsons.entity.Order;
import com.rims.drew.parsons.repository.OrderRepository;

@Service
@Transactional
public class OrderService
{
	@Autowired
	OrderRepository orderRepo;
	
	public void save(Order order) {
		orderRepo.save(order);
	}
	
	public List<Order> listAll(){
		return (List<Order>) orderRepo.findAll();
	}
	
	public Order get(Long id) {
		return orderRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		orderRepo.deleteById(id);
	}

}
