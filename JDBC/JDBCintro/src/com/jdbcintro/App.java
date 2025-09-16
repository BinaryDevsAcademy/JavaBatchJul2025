package com.jdbcintro;

import com.jdbcintro.databaselayer.DatabaseConnector;

public class App {

	public static void main(String[] args) {
		
		DatabaseConnector connector = new DatabaseConnector();
		connector.createConnection("root", "0000");
		
//		connector.saveData(5, "Robert", 25);
//		connector.updateData(4, "Bruce");
		connector.getData();
//		connector.getUserById(1);
	}

}
