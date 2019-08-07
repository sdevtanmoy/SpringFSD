/**
 * 
 */
package com.stackroute.spring.di.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.stackroute.spring.di.model.Course;
import com.stackroute.spring.di.model.Student;

/**
 * @author TanmoyDas
 *
 */
@Configuration// equlivalent to one beans.xml configuration xml file
@ComponentScan(basePackages = {"com.stackroute.spring.di.model"})
public class AppConfig {

	
	/*
	  // Bean Definition // Factory method 
	
	 @Qualifier("course1")
	  @Bean(name = "course1") 
	  public Course getCourse1() {
		  System.out.println("getCourse1() is called.."); 
		  return new Course(1, "Full Stack Development(java)", 2019); 
	  }
	  
	  @Qualifier("course2")
	  @Bean(name = "course2")
	  public Course getCourse2() { 
		  System.out.println("getCourse2() is called..");
		  return new Course(2, "Full Stack Development(.NET)", 2018); 
	  }
	  
	  @Qualifier("course3")
	  @Bean(name = "course3")
	  public Course getCourse3() { 
		  System.out.println("getCourse3() is called..");
		  return new Course(3, "Full Stack Development(.MEAN)", 2017); 
	  }
	  
	  @Bean public Student getStudent1() { 
		  return new Student(); 
		  // return new Student(1,"Student1","Student1@gmail.com",3453454,getCourse1()); 
		  // return  new Student(1,"Student1","Student1@gmail.com",3453454, 
		  //new ArrayList<Course>(Arrays.asList(getCourse1(),getCourse2()))); 
		  }
	 
	*/
}
