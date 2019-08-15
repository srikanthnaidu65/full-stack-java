package com.srikanth.fullstackjava;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmpDeptClient {

	public static void main(String[] args) {
		SessionFactory sessinFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessinFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessinFactory.openSession();

			Employee e1 = new Employee();
			e1.setEmpId(20000959);
			e1.setEmpName("Srikanth");

			Employee e2 = new Employee();
			e2.setEmpId(13235);
			e2.setEmpName("Mahesh");

			Department d= new Department();
			d.setDeptId(100);
			d.setDeptName("Java");

			Set<Employee> set = new HashSet<Employee>();
			set.add(e1);
			set.add(e2);

			d.setEmployees(set);

			transaction = session.beginTransaction();
			session.save(d);
			transaction.commit();
			System.out.println("One to Many Done.");
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}