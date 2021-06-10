package com.rims.drew.parsons.repository;

import org.springframework.data.repository.CrudRepository;

import com.rims.drew.parsons.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem,Long>
{

}
