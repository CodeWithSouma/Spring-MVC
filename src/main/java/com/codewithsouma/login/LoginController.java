package com.codewithsouma.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String handelLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(!service.validateUser(name,password)) {
			model.put("errorMessage", "Invalid credential !!!");
			return "login";
		}
		else {
			model.put("name", name);
			System.out.println("Name: "+name+" Password: "+password);
			return "welcome";
		}
	}
	
}
