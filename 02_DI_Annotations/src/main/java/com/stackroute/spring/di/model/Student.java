/**
 * 
 */
package com.stackroute.spring.di.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author TanmoyDas
 *
 */
@Component
public class Student {

	private int id;
	private String name;
	private String email;
	private int contactNo;
	
	/*
	 * @Autowired()
	 * 
	 * @Qualifier("course2") private Course course;
	 */
	
	@Autowired
	private List<Course> courseList;
	
	public Student() {
	
	}

	/*
	 * public Student(int id, String name, String email, int contactNo, Course
	 * course) {
	 * 
	 * this.id = id; this.name = name; this.email = email; this.contactNo =
	 * contactNo; this.course = course; }
	 */

	/*
	 * @Override public String toString() { return "Student [id=" + id + ", name=" +
	 * name + ", email=" + email + ", contactNo=" + contactNo + ", course=" + course
	 * + "]"; }
	 */
	
	

	public int getId() {
		return id;
	}

	public Student(int id, String name, String email, int contactNo, List<Course> courseList) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", courseList=" + courseList + "]";
	}

	public Student setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Student setEmail(String email) {
		this.email = email;
		return this;
	}

	public int getContactNo() {
		return contactNo;
	}

	public Student setContactNo(int contactNo) {
		this.contactNo = contactNo;
		return this;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public Student setCourseList(List<Course> courseList) {
		this.courseList = courseList;
		return this;
	}

	/*
	 * public Course getCourse() { return course; }
	 * 
	 * public Student setCourse(Course course) { this.course = course; return this;
	 * }
	 */
	


	
}
