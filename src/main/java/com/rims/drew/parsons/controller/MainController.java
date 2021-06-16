package com.rims.drew.parsons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
	@GetMapping({"/","","/index"})
	public String home()
	{
		return "index";
	}
	
	@GetMapping({"/login"})
	public String login()
	{
		return "login";
	}
	@GetMapping({"/register"})
	public String register()
	{
		return "register";
	}


}
