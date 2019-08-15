package com.srikanth.fullstackjava;

import java.util.Iterator;
import java.util.List;

public class Student {

	private String studentId;
	private String studentName;
	private String studentAddress;

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

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public void getAllDetails(List<Student> students) {
		students.forEach(t -> System.out.println("Student Id : "+t.getStudentId()
				+", Student Name : "+t.getStudentName()+", Address : "+t.getStudentAddress())); 

	}

	public void getDetails(List<Student> students, String studentId) {
		Iterator<Student> itr = students.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			if(studentId.equals(s.getStudentId())) {
				System.out.println("Student Id : "+s.getStudentId()
				+", Student Name : "+s.getStudentName()+", Address : "+s.getStudentAddress());
			}
		}
	}

}
