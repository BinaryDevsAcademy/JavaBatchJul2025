package com.cms.serviceLayers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cms.DAOLayers.SecurityUsersDAO;
import com.cms.entities.SecurityUsers;

@Service
public class SecurityUserService {

	@Autowired
	private SecurityUsersDAO userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public SecurityUsers registerUser(SecurityUsers user) {
		String encodedPassword = passwordEncoder.encode(user.getUserPassword());
		
		user.setUserPassword(encodedPassword);
		return userDao.save(user);
	}

	public List<SecurityUsers> getAllUsers() {
		
		return userDao.findAll();
	}

	public String getUserRole(String username) {
		return userDao.findRoleByUsername(username);
	}

}
