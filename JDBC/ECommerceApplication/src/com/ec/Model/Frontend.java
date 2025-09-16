package com.ec.Model;

import java.util.Scanner;

import com.ec.DAOLayer.DatabaseDAO;
import com.ec.DAOLayer.Interfaces.DatabaseConnectorImpl;
import com.ec.Enums.UserRoles;
import com.ec.Model.interfaces.Dashboard;
import com.ec.Model.interfaces.FrontendInterface;
import com.ec.entites.Users;

public class Frontend implements FrontendInterface{
	
	DatabaseConnectorImpl dbConnector = null;
	
	public Frontend() {
		if(dbConnector == null) {
			dbConnector = new DatabaseDAO();
		}
	}
	
	public Scanner scanner = new Scanner(System.in);
	
	public void intro() {
		System.out.println("Do you have a account press '1' - login");
		System.out.println("If not please press '2' - register");
		int choice = scanner.nextInt();
		scanner.nextLine();
		if(choice == 1) {
			this.login();
		}else {
			this.register();
		}
	}
	
	@Override
	public void login() {
		System.out.println("********* LOGIN PAGE ***************");
		System.out.println("Enter your username : ");
		String email = scanner.nextLine();
		System.out.println("Enter your password : ");
		String password = scanner.nextLine();
		System.out.println("************************************");
		Users user = dbConnector.loginUser(email, password);
		if(user.getUserId() == 0) {
			System.out.println("Invalid username or password");
			this.intro();
		}else {
			Dashboard dashboard = null;
			if(user.getRole() == UserRoles.ADMIN) {
				
			}else if(user.getRole() == UserRoles.SELLER) {
				System.out.println(user);
				dashboard = new SellerDashboard();
				dashboard.viewDashboard(user);
			}else {
				
			}
		}
	}

	@Override
	public void register() {
		System.out.println("************ WELCOME TO REGISTRATION PAGE **************************");
		Users userInfo;
		System.out.println("Do you want to register as seller? - press '1' to register as seller");
		System.out.println("Do you want to register as customer? - press '2' to register as customer");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		if(choice == 1) {
			System.out.println("Welcome new seller...");
			userInfo = getInfo();
			userInfo.setRole(UserRoles.SELLER);
			System.out.println(userInfo);
		}else {
			System.out.println("Welcome new customer...");
			userInfo = getInfo();
		}
		dbConnector.registerUser(userInfo);
		//calling the login page
		System.out.println("**************************************************");
		this.login();
		
	}
	
	public Users getInfo() {
		System.out.println("Enter your full name : ");
		String fullName = scanner.nextLine();
		
		System.out.println("Enter your email id : ");
		String emailId = scanner.nextLine();
		
		System.out.println("Enter your password : ");
		String password = scanner.nextLine();
		
		Users userInfo = new Users();
		userInfo.setEmail(emailId);
		userInfo.setFullName(fullName);
		userInfo.setPassword(password);
		
		return userInfo;
		
	}
	
}
