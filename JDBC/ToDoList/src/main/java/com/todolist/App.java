package com.todolist;

import org.hibernate.Session;

import com.todolist.ManyToManyMapping.CoursesManyToMany;
import com.todolist.ManyToManyMapping.StudentManyToMany;
import com.todolist.OneToManyMapping.CoursesManyToOne;
import com.todolist.OneToManyMapping.StudentOneToMany;

public class App {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		
		config.addAnnotatedClass(StudentOneToMany.class);
		config.addAnnotatedClass(CoursesManyToOne.class);

		config.addAnnotatedClass(StudentManyToMany.class);
		config.addAnnotatedClass(CoursesManyToMany.class);
		
		Session session2 = config.buildSessionFactory().openSession();
		session2.beginTransaction();
		
		System.out.println("Session 1");
			
		StudentManyToMany s1 = session2.find(StudentManyToMany.class, 2);
		System.out.println(s1);
		
		session2.getTransaction().commit();
		
		Session ms = config.buildSessionFactory().openSession();
		
		ms.beginTransaction();
		
		System.out.println("Session 2");
		
		
		StudentManyToMany s2 = ms.find(StudentManyToMany.class, 2);
		System.out.println(s2);
//		s1.printCourses();
		
//		CoursesManyToMany c1 = ms.find(CoursesManyToMany.class, 1);
//		CoursesManyToMany c2 = ms.find(CoursesManyToMany.class, 2);
//		CoursesManyToMany c3 = ms.find(CoursesManyToMany.class, 3);
		
		
		
//		StudentManyToMany s1 = new StudentManyToMany();
//		s1.setStudentName("Yash");
//		s1.getCourses().add(c1);
//		s1.getCourses().add(c3);
//		StudentManyToMany s2 = new StudentManyToMany();
//		s2.setStudentName("Gaberial");
//		s2.getCourses().add(c2);
//		StudentManyToMany s3 = new StudentManyToMany();
//		s3.setStudentName("Lakshman");
//		s3.getCourses().add(c3);
//		s3.getCourses().add(c1);
//		s3.getCourses().add(c2);
//		
//		ms.persist(s1);
//		ms.persist(s3);
//		ms.persist(s2);
//		
//		System.out.println(s1);
//		s1.printCourses();
//		System.out.println(s2);
//		s2.printCourses();
//		System.out.println(s3);
//		s3.printCourses();
		
//		CoursesManyToMany c1 = new CoursesManyToMany();
//		c1.setCourseName("JFS");
//		CoursesManyToMany c2 = new CoursesManyToMany();
//		c2.setCourseName("PFS");
//		CoursesManyToMany c3 = new CoursesManyToMany();
//		c3.setCourseName("DA/DS");
//		
//		ms.persist(c1);
//		ms.persist(c2);
//		ms.persist(c3);
		
		ms.getTransaction().commit();
		ms.close();
		session2.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		StudentOneToMany st1 = new StudentOneToMany();
//		st1.setStudentName("Raghu");
		
//		
//		Session s1 = config.buildSessionFactory().openSession();
//		
//		s1.beginTransaction();
		
		
		
		
		
//		st1.getCourses().add(c2);
//		st1.getCourses().add(c1);
		
//		s1.persist(st1);
//		
//		CoursesManyToOne c1 = new CoursesManyToOne();
//		c1.setCourseName("Jfs");
//		c1.setStudent(st1);
//		
//		CoursesManyToOne c2 = new CoursesManyToOne();
//		c2.setCourseName("pfs");
//		c2.setStudent(st1);
//		
//		System.out.println(st1);
//		
//		s1.persist(c1);
//		s1.persist(c2);
		
//		StudentOneToMany student = s1.find(StudentOneToMany.class, 1); 
//		System.out.println(student);
//		student.printCourses();
//		
//		s1.getTransaction().commit();
//		s1.close();
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		config.addAnnotatedClass(Users.class);

		
		
//		config.addAnnotatedClass(StudentOneToOne.class);
//		config.addAnnotatedClass(CoursesOneToOne.class);
		
		/* OneToOneConfiguration */
//		CoursesOneToOne c1 = new CoursesOneToOne();
//		c1.setCourseName("Java Full Stack");
//		c1.setCourseDuration(6);
//		c1.setCourseDescription("This course is full stack developement");
//		
//		CoursesOneToOne c2 = new CoursesOneToOne();
//		c2.setCourseName("Full Stack Developement in python and java");
//		c2.setCourseDuration(9);
//		c2.setCourseDescription("This course is full stack developement using python and java");
//		
//		CoursesOneToOne c3 = new CoursesOneToOne();
//		c3.setCourseName("Data Science");
//		c3.setCourseDuration(6);
//		c3.setCourseDescription("This course is Data Science");
		
//		StudentOneToOne s1 = new StudentOneToOne();
//		
//		Session session1 = config.buildSessionFactory().openSession();
//		session1.beginTransaction();
//		
//		CoursesOneToOne c = session1.find(CoursesOneToOne.class, 2);
//		
//		System.out.println(c);
		
//		s1 = session1.find(StudentOneToOne.class, 1);
//		s1.setStudentName("Raghu");
//		s1.setEmail("raghu@gmail.com");
//		s1.setPassword("Raghu@1234");
//		s1.setCourse(c);
		
//		session1.persist(s1);
		
//		System.out.println(s1);
		
//		session1.persist(c1);
//		session1.persist(c2);
//		session1.persist(c3);
		
//		session1.getTransaction().commit();
//		session1.close();
		
		//plain java object
////		Users user1 = new Users();
////		user1.setUserName("Tim");
////		user1.setEmail("tim123@gmail.com");
////		user1.setPassword("Tim@12d34");
////		
//		//transient - user1
//		SessionFactory sf = config.buildSessionFactory();
//		Session session1 = sf.openSession();
//		session1.beginTransaction();
//		//CRUD - Persistent state
//		//This is used to save data
////		session1.persist(user1);
//		//This is used to fetch data
////		Users user1 = session1.find(Users.class,1);
//		
//		String HQLbyName = "FROM Users WHERE userName = ?1";
//		List<Users> set = session1.createQuery(HQLbyName,Users.class)
//				.setParameter(1, "Tim")
//				.getResultList();
////		List<Users> set = session1.createQuery(HQLbyName, Users.class).getResultList();
//		System.out.println(set);
//		
//		session1.getTransaction().commit();
//		//Detached - removing objects from presistent state
////		System.out.println(user1);
//		session1.close();
	}

}
