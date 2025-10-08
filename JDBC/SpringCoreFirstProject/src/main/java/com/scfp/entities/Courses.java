package com.scfp.entities;

import org.springframework.stereotype.Component;

@Component
public class Courses {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Courses [name=" + name + "]";
	}
	
	
}
