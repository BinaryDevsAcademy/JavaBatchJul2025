package com.jdbcintro;

import com.jdbcintro.databaselayer.DatabaseConnector;

public class App {

	public static void main(String[] args) {
		DatabaseConnector connector = new DatabaseConnector();
		connector.createConnection();
	}

}
