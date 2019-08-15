package com.srikanth.fullstackjava;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getString("id"));
		student.setStudentName(rs.getString("name"));
		student.setStudentAddress(rs.getString("address"));
		return student;
	}
} 
