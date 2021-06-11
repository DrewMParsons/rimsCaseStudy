package com.rims.drew.parsons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Long>
{

}
