package com.todolist.Entites.OneToOneERMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class StudentOneToOne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String password;
	private String email;
	@OneToOne
	private CoursesOneToOne course;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public CoursesOneToOne getCourse() {
		return course;
	}
	public void setCourse(CoursesOneToOne course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "StudentOneToOne [studentId=" + studentId + ", studentName=" + studentName + ", password=" + password
				+ ", email=" + email + ", course=" + course + "]";
	}
	
	
}
