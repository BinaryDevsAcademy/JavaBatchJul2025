package com.ec.DAOLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ec.DAOLayer.Interfaces.DatabaseConnectorImpl;
import com.ec.Enums.UserRoles;
import com.ec.Model.Frontend;
import com.ec.entites.Product;
import com.ec.entites.Users;

public class DatabaseDAO implements DatabaseConnectorImpl{
	
	private Connection connect = null;
	private PreparedStatement ps = null;
	
	public DatabaseDAO() {
		System.out.println(this.connectToDatabase("root", "0000"));
	}
	

	@Override
	public String connectToDatabase(String username, String password) {
		try {
			if(connect != null) {
				throw new Exception("Connection already existed");
			}
			
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ecommerce_app", username, password);
			return "Connected to server";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}

	@Override
	public void registerUser(Users userInfo) {
		String saveQuery = "INSERT INTO users(full_name, email, password, role) VALUES (?,?,?,?);";
		try {
			ps = connect.prepareStatement(saveQuery);
			ps.setString(1, userInfo.getFullName());
			ps.setString(2, userInfo.getEmail());
			ps.setString(3, userInfo.getPassword());
			ps.setString(4, userInfo.getRole().name());
			ps.executeUpdate();
			System.out.println("Registration Successfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Registration not success");
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public Users loginUser(String username, String password) {
		String fetchSQL = "SELECT * FROM users WHERE email = ? and password = ?";
		try {
			ps = connect.prepareStatement(fetchSQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Users user = new Users();
			rs.next();
			user.setUserId(rs.getInt("user_id"));
			user.setFullName(rs.getString("full_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			String role = rs.getString("role").toUpperCase();
			UserRoles userRole = null; 
			userRole = userRole.valueOf(role);
			user.setRole(userRole);
			
			return user;
		}catch(Exception e) {
			return new Users();
		}
	}


	@Override
	public void registerProduct(Product product) {
		String saveProductSQL = "INSERT INTO products(seller_id,product_name,description,price,stock) VALUES(?,?,?,?,?) ";
		try {
			ps = connect.prepareStatement(saveProductSQL);
			ps.setInt(1, product.getSeller_id().getUserId());
			ps.setString(2, product.getProduct_name());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStock());
			
			ps.executeUpdate();
			System.out.println("Successfully added the product");
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}


	@Override
	public void logout() {
		try {
			connect.close();
			System.out.println("You have been logged out");
			new Frontend().intro();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public List<Product> viewProducts(Users user) {

		String viewProductsSQL = "SELECT * FROM products WHERE seller_id = ?;";
		

		List<Product> products = new LinkedList<>();
		try {
			ps = connect.prepareStatement(viewProductsSQL);
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setStock(rs.getInt("stock"));
				product.setCreated_at(rs.getDate("created_at"));
				product.setUpdate_at(rs.getDate("updated_at"));
				product.setSeller_id(user);
				
				products.add(product);
			}
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return products;
	}
	
}
