package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoLayers.ContactDetailsDao;
import com.example.demo.entites.ContactDetails;

@Service
public class HomeService {
	@Autowired
	private ContactDetails contactDetails;
	
	@Autowired
	private ContactDetailsDao contactDAO;

	public boolean submitContactForm(
			String username, 
			String useremail, 
			long userphone, 
			String message) {
		contactDetails.setUsername(username);
		contactDetails.setUseremail(useremail);
		contactDetails.setUserphone(userphone);
		contactDetails.setMessage(message);
		
		ContactDetails updatedDetails = null;
		try {
			updatedDetails = contactDAO.save(contactDetails);
		}catch(Exception error) {
			System.out.println(error);
		}
		
		if(updatedDetails == null)
			return false;
		return true;
	}

	public ContactDetails submitContactDetails(ContactDetails details) {
		return contactDAO.save(details);
	}

	public List<ContactDetails> getAllContacts() {
		return contactDAO.findAll();
	}

	public String deleteContact(int id) {
		ContactDetails details = contactDAO.getReferenceById(id);
		System.out.println(details);
		contactDAO.delete(details);
		return "Deleted...";
	}

	public ContactDetails getContactById(int id) {
		ContactDetails details = contactDAO.getReferenceById(id);
		System.out.println(details);
		return details;
	}
	
		
//	getByColName
//	findByColName
	
	public List<ContactDetails> getContactByName(String name) {
		List<ContactDetails> details = contactDAO.findByUsername(name);
		return details;
	}

	public ContactDetails updateContactDetails(ContactDetails details) {
		return contactDAO.save(details);
	}

}
