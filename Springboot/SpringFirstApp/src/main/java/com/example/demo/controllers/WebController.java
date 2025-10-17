package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {



	@RequestMapping("/")
	public String home() {
		System.out.println("Home page request recieved");
		return "home.html";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact.html";
	}
	
	//request - default --> get method
//	@RequestMapping(method = RequestMethod.GET, value="/users")
	@PostMapping("/users")
	public String users(@RequestParam("name") String name) {
		System.out.println(name);
		return "users.jsp";
	}
	
}
