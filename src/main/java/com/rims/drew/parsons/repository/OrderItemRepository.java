package com.rims.drew.parsons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.entity.OrderItem;
import com.rims.drew.parsons.entity.User;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>
{
	
	public List<OrderItem> findByUser(User user);
	
	public OrderItem findByUserAndMenuItem(User user, MenuItem menuItem);

}
