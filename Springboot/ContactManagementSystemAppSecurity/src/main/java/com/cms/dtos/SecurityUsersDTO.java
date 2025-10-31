package com.cms.dtos;

public class SecurityUsersDTO {
	private String username;
	private String userPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "SecurityUsersDTO [username=" + username + ", userPassword=" + userPassword + "]";
	}
	
	
}
