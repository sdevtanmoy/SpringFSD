/**
 * 
 */
package com.stackroute.spring.di;

import java.util.List;

/**
 * @author TanmoyDas
 *
 */
public class Student {

	private int id;
	private String name;
	private String email;
	private int contactNo;
	
	List<Course> coursesList;

	public Student(int id, String name, String email, int contactNo, List<Course> coursesList) {
		System.out.println(this.getClass().getCanonicalName());
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.coursesList = coursesList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", coursesList=" + coursesList + "]";
	}
	
	
}
