package com.rims.drew.parsons.util;




/**
 * custom exception class for handling quantity errors in adding order items
 * @author Drew
 *
 */
public class OrderException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private int quantity;

	
	protected OrderException() {}

	public OrderException(String errorMessage, int quantity)
	{
		super();
		this.errorMessage = errorMessage;
		this.quantity = quantity;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
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
