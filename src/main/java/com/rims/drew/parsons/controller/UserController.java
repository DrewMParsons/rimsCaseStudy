package com.rims.drew.parsons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.service.SecurityService;
import com.rims.drew.parsons.service.UserService;
import com.rims.drew.parsons.util.Constants;
import com.rims.drew.parsons.validator.UserValidator;

/**
 * Custom controller for handling all requests for the landing, login, and register pages
 * @author Drew
 *
 */
@Controller
public class UserController
{
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    
    /*
     * Request handler for landing(home) page.  Redirects authenticated users to the order page
     */
	@GetMapping({"/","","/index"})
	public String home()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return "redirect:/order";
		return Constants.INDEX;
	}
	
	
	/*
	 * handles login page requests for login/logout with error messages for invalid logins
	 */
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return Constants.LOGIN_PAGE;
    }
	
	/*
	 * Register page requests
	 */
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("userForm", new User());
		return Constants.REGISTER_PAGE;
	}
	/*
	 * Post request for Register page. Validates user form and on success saves user to DB
	 * user is then automatically logged in to the system, and is redirected to the order page 
	 */
	@PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return Constants.REGISTER_PAGE;
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/order";
    }


}
