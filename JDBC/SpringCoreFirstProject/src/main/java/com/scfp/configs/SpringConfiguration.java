package com.scfp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.scfp.entities.Courses;
import com.scfp.entities.Student;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringConfiguration {
//	@Bean
//	@Primary
//	public Student student() {
//		return new Student();
//	}
//	
//	@Bean
//	public Student student1() {
//		return new Student();
//	}
//	
//	@Bean
//	public Courses courses() {
//		return new Courses();
//	}
}
