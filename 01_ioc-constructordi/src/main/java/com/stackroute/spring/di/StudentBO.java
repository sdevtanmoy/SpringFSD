package com.stackroute.spring.di;

import java.util.List;
import java.util.Map;

public class StudentBO {

	Map<Student, List<Course>> studentCourseMap;

	public StudentBO(Map<Student, List<Course>> studentCourseMap) {
		this.studentCourseMap = studentCourseMap;
	}

	@Override
	public String toString() {
		return "StudentBO [studentCourseMap=" + studentCourseMap + "]";
	}
	
	
}
