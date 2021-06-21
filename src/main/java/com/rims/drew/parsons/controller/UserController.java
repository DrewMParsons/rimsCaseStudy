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


@Controller
public class UserController
{
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
	@GetMapping({"/","","/index"})
	public String home()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return "redirect:/order";
		return Constants.INDEX;
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return Constants.LOGIN_PAGE;
    }
	
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("userForm", new User());
		return Constants.REGISTER_PAGE;
	}
	
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
