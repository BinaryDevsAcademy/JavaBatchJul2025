package com.jdbcintro.databaselayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
	public void createConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/brollyacademy";
		String username = "root";
		String password = "000";
		try {
			Connection connect = DriverManager.getConnection(url,username,password);
			System.out.println(connect);
		}catch(Exception error) {
			System.out.println(error);
		}
	}
}
