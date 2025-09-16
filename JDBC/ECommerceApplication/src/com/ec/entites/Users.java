package com.ec.entites;

import java.sql.Date;

import com.ec.Enums.UserRoles;

public class Users {
	private int userId;
	private String fullName;
	private String email;
	private UserRoles role = UserRoles.CUSTOMER;
	private String password;
	private Date created_at;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRoles getRole() {
		return role;
	}
	public void setRole(UserRoles role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", role=" + role
				+ ", password=" + password + ", created_at=" + created_at + "]";
	}
	
	
}
