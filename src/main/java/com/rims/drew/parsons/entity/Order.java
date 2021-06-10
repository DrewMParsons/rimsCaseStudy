package com.rims.drew.parsons.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long user;
	private BigDecimal totalPrice;
	
	@OneToMany(mappedBy="order")
	private Set<OrderItem> orderItems;
	
	
	public Order()
	{
		super();
	}
	
	

	public Order(Long id, Long user, BigDecimal total, Set<OrderItem> orderItems)
	{
		super();
		this.id = id;
		this.user = user;
		this.totalPrice = total;
		this.orderItems = orderItems;
	}


	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	
	

	public Long getUser()
	{
		return user;
	}
	
	public void setUser(Long user)
	{
		this.user = user;
	}
	
	public BigDecimal getTotal()
	{
		return totalPrice;
	}
	public void setTotal(BigDecimal total)
	{
		this.totalPrice = total;
	}
	
	public Set<OrderItem> getOrderItems()
	{
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems)
	{
		this.orderItems = orderItems;
	}
	
	

}
