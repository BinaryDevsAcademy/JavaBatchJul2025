package com.todolist.OneToManyMapping;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StudentOneToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int StudentId;
	private String studentName;
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<CoursesManyToOne> courses = new LinkedList<>();
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<CoursesManyToOne> getCourses() {
		return courses;
	}
	public void setCourses(List<CoursesManyToOne> courses) {
		this.courses = courses;
	}
	
	public void printCourses() {
		for(CoursesManyToOne course : courses) {
			System.out.println(course);
			course.printStudent();
		}
	}
	@Override
	public String toString() {
		
		return "StudentOneToMany [StudentId=" + StudentId + ", studentName=" + studentName +"]";
	}
	
	
}
