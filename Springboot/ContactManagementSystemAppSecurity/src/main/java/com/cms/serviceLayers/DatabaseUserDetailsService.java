package com.cms.serviceLayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.DAOLayers.SecurityUsersDAO;
import com.cms.entities.SecurityUsers;
import com.cms.principleClass.UserDetailsPrinicple;

@Service
public class DatabaseUserDetailsService implements UserDetailsService{
	
	@Autowired
	private SecurityUsersDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUsers user = userDao.findByUserEmail(username);
		System.out.println(user);
		// TODO Auto-generated method stub
		return new UserDetailsPrinicple(user);
	}

}
