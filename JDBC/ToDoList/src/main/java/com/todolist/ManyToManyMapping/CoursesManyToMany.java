package com.todolist.ManyToManyMapping;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class CoursesManyToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	@ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
	private List<StudentManyToMany> students = new LinkedList<>();

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

	public List<StudentManyToMany> getStudents() {
		return students;
	}

	public void setStudents(List<StudentManyToMany> students) {
		this.students = students;
	}
	
	public void printStudents() {
		System.out.println(students);
	}

	@Override
	public String toString() {
		return "CoursesManyToMany [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	
	
}
