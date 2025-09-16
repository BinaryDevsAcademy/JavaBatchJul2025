package com.todolist;

import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
	}

}
