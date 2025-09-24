package com.todolist.ManyToManyMapping;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StudentManyToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<CoursesManyToMany> courses = new LinkedList<>();
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<CoursesManyToMany> getCourses() {
		return courses;
	}
	public void setCourses(List<CoursesManyToMany> courses) {
		this.courses = courses;
	}
	
	public void printCourses() {
		System.out.println(courses);
		for(CoursesManyToMany course : courses) {
			course.printStudents();
		}
	}
	
	@Override
	public String toString() {
		return "StudentManyToMany [studentId=" + studentId + ", studentName=" + studentName + "]";
	}	
	
}
