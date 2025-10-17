package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.ContactDetails;
import com.example.demo.services.HomeService;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "")
public class ContactsController {
	
	@Autowired
	private HomeService service;
	
	@GetMapping("")
	public List<ContactDetails> getContacts(){
		return service.getAllContacts();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteContact(@PathVariable("id") int id) {
		return service.deleteContact(id);
	}
	
	@GetMapping("/get/{id}")
	public ContactDetails getContactById(@PathVariable("id") int id) {
		return service.getContactById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<ContactDetails> getContactByName(@PathVariable("name") String name){
		return service.getContactByName(name);
	}
	
	@PutMapping("/update/{id}")
	public ContactDetails updateContactDetails(@RequestBody ContactDetails details) {
		return service.updateContactDetails(details);
	}
}
