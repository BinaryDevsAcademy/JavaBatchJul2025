package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.HomeService;


@Controller
public class HomeController {
	
	@Autowired
	private HomeService service;

	@GetMapping("/")
	public String homePage() {
		return "homePage.html";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contactPage.html";
	}
	
	@PostMapping("/submit")
	public String contactFormSubmit(
			@RequestParam("username") String username,
			@RequestParam("useremail") String useremail,
			@RequestParam("userphone") long userphone,
			@RequestParam("message") String message
			) {
		boolean status = service.submitContactForm(username, useremail, userphone, message);
		if(status)
			return "success.html";
		return "failure.html";
	}
}
