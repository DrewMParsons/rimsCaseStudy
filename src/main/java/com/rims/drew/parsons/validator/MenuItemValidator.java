package com.rims.drew.parsons.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.service.MenuItemService;
/**
 * Custom Validator class for Menu Items
 * 
 * This class handles all form validation for adding new Menu Items
 * custom error messages are found in validation.properties in the resources folder 
 */
@Component
public class MenuItemValidator implements Validator
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
		 if (menuItemService.findByTitle(menuItem.getTitle()) != null) {
	            errors.rejectValue("title", "Duplicate.menuItemForm.title");
	        }
		
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
