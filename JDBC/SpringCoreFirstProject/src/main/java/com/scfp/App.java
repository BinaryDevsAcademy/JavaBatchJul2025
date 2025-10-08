package com.scfp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.scfp.configs.SpringConfiguration;
import com.scfp.entities.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("SpringAnnotationBasedConfiguration.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		
		Student s1 = appContext.getBean(Student.class);
//		Student s1 = (Student) appContext.getBean("student1");

		System.out.println(s1);
		
		Student s2 = appContext.getBean("student1", Student.class);
		System.out.println(s2);
		
//		new Student(1);

//		Student s1 = new Student();
//		Student s2 = new Student();
//		Student s3 = new Student();
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
	}

}
