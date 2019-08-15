package com.srikanth.fullstackjava;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Student getStudent(String id) {
		Student student = hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	@Transactional(readOnly=false)
	public void saveStudent(Student student) {
		hibernateTemplate.save(student);
	}

	public List<Student> listStudents() {
		List <Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}

}
