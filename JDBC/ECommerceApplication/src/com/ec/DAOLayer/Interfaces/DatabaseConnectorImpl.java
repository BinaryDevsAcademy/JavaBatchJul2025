package com.ec.DAOLayer.Interfaces;

import java.util.List;

import com.ec.entites.Product;
import com.ec.entites.Users;

public interface DatabaseConnectorImpl {
	public String connectToDatabase(String username, String password);
	public void registerUser(Users userInfo);
	public Users loginUser(String username, String password);
	public void registerProduct(Product product);
	public void logout();
	public List<Product> viewProducts(Users user);
}
