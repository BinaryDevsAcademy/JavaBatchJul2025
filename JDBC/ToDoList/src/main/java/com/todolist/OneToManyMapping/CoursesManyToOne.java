package com.todolist.OneToManyMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CoursesManyToOne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	@ManyToOne
	private StudentOneToMany student;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public StudentOneToMany getStudent() {
		return student;
	}
	public void setStudent(StudentOneToMany student) {
		this.student = student;
	}
	
	public void printStudent() {
		System.out.println(student);
	}
	
	@Override
	public String toString() {
		
		return "CoursesManyToOne [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	
}
