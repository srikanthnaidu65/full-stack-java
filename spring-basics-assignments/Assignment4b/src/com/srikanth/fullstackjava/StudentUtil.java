package com.srikanth.fullstackjava;

import java.util.List;

public class StudentUtil {
	
	public static void getAllDetails(List<Student> students) {
		students.forEach(t -> System.out.println("Student Id : "+t.getStudentId()
		+", Student Name : "+t.getStudentName()+", Address : "+t.getStudentAddress())); 

	}

	public static void getStudentDetails(Student student) {
		System.out.println("Student Id : "+student.getStudentId()
		+", Student Name : "+student.getStudentName()+", Address : "+student.getStudentAddress());
	}

}
