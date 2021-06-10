package com.rims.drew.parsons.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_menu_item")
public class OrderItem
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "menu_item_id")
	MenuItem menuItem;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;
	
	int quantity;

	public OrderItem()
	{
		super();
	}

	public OrderItem(Long id, MenuItem menuItem, Order order, int quantity)
	{
		super();
		this.id = id;
		this.menuItem = menuItem;
		this.order = order;
		this.quantity = quantity;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public MenuItem getMenuItem()
	{
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem)
	{
		this.menuItem = menuItem;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	
	

}
