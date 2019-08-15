package com.srikanth.fullstackjava;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student getStudent(String id) {
		String sql = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(sql, 
				new Object[]{id}, new StudentMapper());
		return student;
	}

	public List<Student> listStudents() {
		String sql = "select * from student";
		List <Student> students = jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}

}
