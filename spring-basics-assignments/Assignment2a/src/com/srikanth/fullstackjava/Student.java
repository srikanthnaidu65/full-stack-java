package com.srikanth.fullstackjava;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String studentId;
	private String studentName;
	private List<Test> studentTest = new ArrayList<Test>();
	private Test test;

	public Student() {
		super();
	}

	public Student(String studentId, String studentName, List<Test> studentTest, Test test) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentTest = studentTest;
		this.test = test;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Test> getStudentTest() {
		return studentTest;
	}

	public void setStudentTest(List<Test> studentTest) {
		this.studentTest = studentTest;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void showStudentDetails() {
		System.out.println("Student Id: " +studentId+ ", Student Name: " +studentName);
	}

	public void showTestDetails() {
		studentTest.forEach(t -> System.out.println("Test Id : "+t.getTestId()+", Test Title : "
				+t.getTestTitle()+", Test Marks : "+t.getTestMarks())); 
	}

	public void addTest(String id, String title, int marks) {
		test.setTestId(id);
		test.setTestTitle(title);
		test.setTestMarks(marks);
		studentTest.add(test);
	}

}
