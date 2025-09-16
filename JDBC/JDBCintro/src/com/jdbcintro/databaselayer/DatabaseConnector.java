package com.jdbcintro.databaselayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	/* 
	 * statement helps us to run the sql queries in java
	 * we get the statement from the connection object.
	 * - we use method createStatement() to get the statement object.
	 *  */
	
//	init we will not have any statement object so because of that I am assigning a null value to it.
	private Statement statement = null;
	private PreparedStatement ps = null;
	private Connection connect = null;
	
	public void createConnection(String username, String password) {
		String url = "jdbc:mysql://127.0.0.1:3306/brollyacademy";
		try {
			
			/* We need Connection object to perform various operations in sql 
			 * - But Connection is a interface so that we can't create object directly.
			 * - We need a class help to create connection object.
			 * - We are having DriverManager (Class) which helps us to create connection object.
			 * - In DriverManager we are having a method called getConnection(url, username, password);
			 * 		- url - tells the DriverManager about database location.
			* 		- username and password - to login in database server
			 * - with the help of getConnection we can get the Connection object.
			 * */
			connect = DriverManager.getConnection(url,username,password);
			System.out.println("Connection created with database");
			
//		creating statement object only when statement is null
			if(statement == null) {
				statement = connect.createStatement();
			}
			
		}catch(Exception error) {
			System.out.println(error);
		}
	}
	
	// This is a user-defined method, which will helps us to save data into database
	public void saveData(int id, String name, int age) {
		//Writing insert query and assigning values dynamically to the query using string concat method
//		String saveQuery = "INSERT INTO jdbcExample VALUES("+id+", '"+name+"', "+age+");";
		String preparedSaveQuery = "INSERT INTO jdbcExample VALUES(?,?,?)";
		System.out.println(preparedSaveQuery);
		try {
			/*
			 * In statement Interface we are having different methods to execute sql
			 * queries.
			 * 
			 * - save or update or delete - executeUpdate(); or execute();
			 * - we have to send sqlQuery as args
			 */
//			int status = statement.executeUpdate(saveQuery);
			ps = connect.prepareStatement(preparedSaveQuery);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			
			ps.executeUpdate();
			System.out.println("Data saved Succesfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void updateData(int id, String name) {
		String sqlUpdateQuery = "UPDATE jdbcExample SET name = '"+name+"' WHERE id = "+4+"; ";
		try {
			statement.executeUpdate(sqlUpdateQuery);
			System.out.println("Data updated successfully at id "+id);
		}catch(Exception error) {
			System.out.println(error.getMessage());
		}
	}
	
	public void getData() {
		String sqlSelectQuery = "SELECT * FROM jdbcExample";
		try {
			ResultSet rs = statement.executeQuery(sqlSelectQuery);
			printColName(rs);
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+ " " +rs.getString("name") + " "+rs.getInt("age"));
			}
		}catch(Exception error) {
			System.err.println(error.getMessage());
		}
	}
	
	public void getUserById(int id) {
		try {
			ps = connect.prepareStatement("SELECT * FROM jdbcExample WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			printColName(rs);
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" |  "+rs.getString("name")+ " | "+rs.getInt("age"));
			}
		}catch(Exception error) {
			System.err.println(error.getMessage());
		}
	}
	
	public void printColName(ResultSet rs) throws SQLException {
		ResultSetMetaData f = rs.getMetaData();
		
		for(int i = 1; i <= f.getColumnCount(); i ++) {
			System.out.print(f.getColumnName(i)+ " | ");
		}
	}
	
}

