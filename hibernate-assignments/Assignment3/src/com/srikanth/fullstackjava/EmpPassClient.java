package com.srikanth.fullstackjava;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;

public class EmpPassClient {

	public static void main(String[] args) {
		SessionFactory sessinFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessinFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessinFactory.openSession();

			Passport passport = new Passport();
			passport.setPassportNo("A3589155");
			passport.setIssueAuthority("Republic of India");

			Employee employee = new Employee();
			employee.setEmpId(20000959);
			employee.setEmpName("Srikanth");
			employee.setCity("Bangalore");
			
			employee.setPassport(passport);
			
			Passport passport1 = new Passport();
			passport1.setPassportNo("B5481456");
			passport1.setIssueAuthority("Republic of India");

			Employee employee1 = new Employee();
			employee1.setEmpId(10055);
			employee1.setEmpName("Kiran");
			employee1.setCity("Chittoor");

			employee1.setPassport(passport1);

			transaction = session.beginTransaction();
			session.save(employee);
			session.save(employee1);
			transaction.commit();
			System.out.println("One to One Done.");
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}