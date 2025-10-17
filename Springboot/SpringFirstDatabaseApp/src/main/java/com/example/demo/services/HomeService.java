package com.example.demo.services;

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

}
