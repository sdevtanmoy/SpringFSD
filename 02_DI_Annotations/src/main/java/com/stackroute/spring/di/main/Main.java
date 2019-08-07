/**
 * 
 */
package com.stackroute.spring.di.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.spring.di.config.AdminConfig;
import com.stackroute.spring.di.config.AppConfig;
import com.stackroute.spring.di.model.Course;
import com.stackroute.spring.di.model.Student;

/**
 * @author TanmoyDas
 *
 */
public class Main {

	public static void main(String[] args) {
		//Instantiate Core Container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext adminContext = new AnnotationConfigApplicationContext(AdminConfig.class);
		
		Course course1 = context.getBean(Course.class);
		System.out.println(course1);
		
		course1.setId(1)
		       .setName("Full STack Development(Java)")
		       .setSince(2017);
		System.out.println(course1);
		
		
		Student student1 = context.getBean(Student.class);
		System.out.println("Student-->"+ student1);
		
		  student1.setId(1) .setName("Student1") .setEmail("Student1@gmail.com")
		  .setContactNo(2345345);
		 
	    //System.out.println("Student-->"+ student1);

	}

}
