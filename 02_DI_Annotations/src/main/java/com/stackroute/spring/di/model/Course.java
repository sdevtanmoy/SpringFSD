/**
 * 
 */
package com.stackroute.spring.di.model;

import org.springframework.stereotype.Component;

/**
 * @author TanmoyDas
 *
 */
@Component
public class Course {

	private int id;
	private String name;
	private int since;
	
	
	
	public Course() {

	}
	public Course(int id, String name, int since) {
		System.out.println(this.getClass().getCanonicalName());
		this.id = id;
		this.name = name;
		this.since = since;
	}
	public int getId() {
		return id;
	}
	public Course setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Course setName(String name) {
		this.name = name;
		return this;
	}
	public int getSince() {
		return since;
	}
	public Course setSince(int since) {
		this.since = since;
		return this;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + name + ", since=" + since + "]";
	}
	
	
}
