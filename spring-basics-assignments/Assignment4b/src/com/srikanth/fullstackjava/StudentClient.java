package com.srikanth.fullstackjava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentClient {
	static Logger logger = Logger.getLogger(StudentClient.class.getName());

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Student> students = new ArrayList<Student>();
		ApplicationContext context =new ClassPathXmlApplicationContext("springconfig.xml");
		
		StudentDao dao = (StudentDao) context.getBean("studentDao");
		
		for (int i=1; i<=10; i++) {
			Student s1 = new Student();;	
			s1.setStudentId("S" +i);
			s1.setStudentName("Student" +i);
			s1.setStudentAddress("City" + i);
			dao.saveStudent(s1);
		}

		students = dao.listStudents();

		StudentUtil.getAllDetails(students);
		System.out.println("Enter student id to fetch data");
		String fetchID = br.readLine();
		Student student = dao.getStudent(fetchID);
		StudentUtil.getStudentDetails(student);
	}

}
