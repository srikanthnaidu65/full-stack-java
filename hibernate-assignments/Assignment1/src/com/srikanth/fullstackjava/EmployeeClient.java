package com.srikanth.fullstackjava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployeeClient {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

		Employee employee = new Employee(20000959, "Srikanth", "B2");
		EmployeeClient client = new EmployeeClient();

		//Save
		System.out.println("Saving Employee: ");
		client.saveEmployee(employee);

		//Read
		System.out.println("Reading Employee: ");
		client.displayEmployee(employee.getEmployeeId());

		//Update
		employee.setEmployeeName("Srikanth Naidu");
		System.out.println("Updating Employee: ");
		client.updateEmployee(employee);

		//Delete
		System.out.println("Deleting Employee: ");
		client.deleteEmployee(employee);

		System.out.println("Done");
	}

	private void deleteEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	private void updateEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.update(employee);
			transaction.commit();
			displayEmployee(employee.getEmployeeId());
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	private void displayEmployee(Integer employeeId) {
		Session session = null;
		Employee employee = null;
		try {
			session = sessionFactory.openSession();

			employee = (Employee) session.get(Employee.class, employeeId);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	private void saveEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}
