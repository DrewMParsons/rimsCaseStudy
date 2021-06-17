package com.rims.drew.parsons.entity;

import javax.persistence.CascadeType;
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
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "menu_item_id")
	MenuItem menuItem;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "user_id")
	User user;
	
	int quantity;

	public OrderItem()
	{
		super();
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

	

	public User getUser()
	{
		return user;
	}


	public void setUser(User user)
	{
		this.user = user;
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
