package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/users")
	public String users() {
		return "users.jsp";
	}
	
}
