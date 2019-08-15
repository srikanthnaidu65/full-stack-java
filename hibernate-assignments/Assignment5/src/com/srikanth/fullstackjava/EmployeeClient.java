package com.srikanth.fullstackjava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployeeClient {

	public static void main(String[] args) {

		SessionFactory sessinFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessinFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessinFactory.openSession();

			Employee e1=new Employee();  
			e1.setEmployeeName("Srikanth"); 
			e1.setEmployeeSalary(10000);

			RegularEmployee e2=new RegularEmployee();
			e2.setEmployeeName("Mahesh");  
			e2.setEmployeeSalary(40000);  
			e2.setQplc(500);  

			ContractEmployee e3=new ContractEmployee();  
			e3.setEmployeeName("Kiran");
			e3.setEmployeeSalary(5000);  
			e3.setAllowance(3000);

			transaction = session.beginTransaction();
			session.save(e1);
			session.save(e2);
			session.save(e3);
			transaction.commit();
			System.out.println("Done.");
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
