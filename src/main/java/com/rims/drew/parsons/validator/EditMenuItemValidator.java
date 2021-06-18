package com.rims.drew.parsons.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.service.MenuItemService;

@Component
public class EditMenuItemValidator implements Validator
{
	@Autowired
	MenuItemService menuItemService;

	@Override
	public boolean supports(Class<?> clazz)
	{

		return MenuItem.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		MenuItem menuItem = (MenuItem) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
		 
		
		if (menuItem.getPrice() == null || menuItem.getPrice().equals(null))
		{
			errors.rejectValue("price", "Size.menuItemForm.price");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");

		if (menuItem.getPrice() != null)
		{
			if (menuItem.getPrice().doubleValue() <= 0 || menuItem.getPrice().doubleValue() > 1000)
			{
				errors.rejectValue("price", "Size.menuItemForm.price");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");

	}

}
