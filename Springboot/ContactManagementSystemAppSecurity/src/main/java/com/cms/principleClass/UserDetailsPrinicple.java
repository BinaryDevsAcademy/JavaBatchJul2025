package com.cms.principleClass;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cms.entities.SecurityUsers;

public class UserDetailsPrinicple implements UserDetails {
	
	private SecurityUsers user = null;
	
	

	 

	public UserDetailsPrinicple(SecurityUsers user2) {
		// TODO Auto-generated constructor stub
		this.user = user2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserEmail();
	}

}
