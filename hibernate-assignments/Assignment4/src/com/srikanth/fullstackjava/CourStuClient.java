package com.srikanth.fullstackjava;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CourStuClient {

	public static void main(String[] args) {
		SessionFactory sessinFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessinFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessinFactory.openSession();

			Student student1 = new Student();
			student1.setStudentId(100);
			student1.setStudentName("Srikanth");

			Student student2 = new Student();
			student2.setStudentId(101);
			student2.setStudentName("Naresh");

			Course course1 = new Course();
			course1.setCourseId(1);
			course1.setCourseName("Hibernate");

			Course course2 = new Course();
			course2.setCourseId(2);
			course2.setCourseName("Angular");

			Set<Course> courses = new HashSet<Course>();
			courses.add(course1);
			courses.add(course2);

			student1.setCourses(courses);
			student2.setCourses(courses);

			transaction = session.beginTransaction();
			session.save(student1);
			session.save(student2);
			transaction.commit();
			System.out.println("Many to Many Done.");
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}

//org.hibernate.AnnotationException: mappedBy reference an unknown target entity property: com.wipro.srikanth.Student.course in com.wipro.srikanth.Course.students
