/**
 * 
 */
package com.stackroute.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TanmoyDas
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//instantiate Spring core container
		
		//BeanFacotry
		//ApplicationContext
		//WebApplicationContext

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("context loaded");
		
		Course course1 = context.getBean("course1", Course.class);
		System.out.println(course1.hashCode() +" -- "+ course1);
		
		Course course2 = context.getBean("course2", Course.class);
		  System.out.println(course2.hashCode());
		  Course course3 = context.getBean("course3",
		  Course.class); System.out.println(course3);
		 
		Course course1obj = context.getBean("course1", Course.class);
		System.out.println(course1obj.hashCode());
		
		System.out.println("----------------------------------------------");
		
		Student student = context.getBean("student1", Student.class);
		System.out.println(student.hashCode() + " -- "+student);
		
		System.out.println("----------------------------------------------");
		
		
		StudentBO studentBO1 = context.getBean("studentBO1", StudentBO.class);
		
		System.out.println(studentBO1);
	}

}
