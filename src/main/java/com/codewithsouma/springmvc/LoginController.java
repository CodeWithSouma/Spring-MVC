package com.codewithsouma.springmvc;

import java.security.Provider.Service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codewithsouma.jee.LoginService;

@Controller
public class LoginController {
	
	private LoginService service = new LoginService();
	
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
