package com.srikanth.fullstackjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentTestClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

		//Student 1
		Student s1 = (Student) context.getBean("student");
		s1.setStudentId("S001");
		s1.setStudentName("Steve");
		s1.addTest("T001", "Core Java Test", 80);
		System.out.println("-----Student Details-----");
		s1.showStudentDetails();
		System.out.println("-----Test Details-----");
		s1.showTestDetails();

		//Student 2
		Student s2 = (Student) context.getBean("student");
		s2.setStudentId("S002");
		s2.setStudentName("Jobs");
		s2.addTest("T001", "Core Java Test", 78);
		s2.addTest("T002", "Angular Test", 79);
		System.out.println("-----Student Details-----");
		s2.showStudentDetails();
		System.out.println("-----Test Details-----");
		s2.showTestDetails();

	}

}
