package com.ec.Model;

import java.util.List;
import java.util.Scanner;

import com.ec.DAOLayer.DatabaseDAO;
import com.ec.DAOLayer.Interfaces.DatabaseConnectorImpl;
import com.ec.Model.interfaces.Dashboard;
import com.ec.entites.Product;
import com.ec.entites.Users;

public class SellerDashboard implements Dashboard {
	
	public Scanner scanner = new Scanner(System.in);
	private DatabaseConnectorImpl database = null;
	
	public SellerDashboard() {
		database = new DatabaseDAO();
	}
	
	@Override
	public void products(Users user) {
		List<Product> products = database.viewProducts(user);
		for(Product product : products) {
			System.out.println(product);
		}
	}
	
	@Override
	public void viewDashboard(Users user) {
		System.out.println("****** SELLER DASHBOARD *******");
		System.out.println("1. Add Product");
		System.out.println("2. Edit Product");
		System.out.println("3. view orders");
		System.out.println("4. view my products");
		System.out.println("5. Logout");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
		case 1 :
			System.out.println("Add product");
			this.addProduct(user);
			break;
		case 2 :
			System.out.println("Edit product");
			break;
		case 3 :
			System.out.println("View Orders");
			break;
		case 4 :
			System.out.println("View My Proudcts");
			this.products(user);
			break;
		case 5 :
			System.out.println("Logout");
			database.logout();
			break;
		default : 
			System.out.println("Select a valid input");
			this.viewDashboard(user);
		break;
		}
	}

	@Override
	public void addProduct(Users user) {
		Product product = new Product();
		System.out.println("Enter product name : ");
		product.setProduct_name(scanner.nextLine());
		System.out.println("Enter product description");
		product.setDescription(scanner.nextLine());
		System.out.println("Enter product price : ");
		product.setPrice(scanner.nextDouble());
		System.out.println("Enter product stock available : ");
		product.setStock(scanner.nextInt());
		product.setSeller_id(user);
		database.registerProduct(product);
		
		this.viewDashboard(product.getSeller_id());
	}

}
