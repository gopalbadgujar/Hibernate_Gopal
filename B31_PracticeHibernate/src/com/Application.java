package com;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Application {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getConnection();
		addEmployee(sf);
		displayAllEmployee(sf);
		singleEmployee(sf);
		updateEmployee(sf);
		deleteEmployee(sf);

	}

	private static void deleteEmployee(SessionFactory sf) {
		System.out.println("---DELETE EMPLOYEE---");
		Session session = sf.openSession();
		System.out.println("Enter the iD :- ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		session.delete(emp);
		session.beginTransaction().commit();
		System.out.println("Data Deleted!!");

	}

	private static void updateEmployee(SessionFactory sf) {
		System.out.println("---UPDATE EMPLOYEE---");
		Session session = sf.openSession();
		System.out.println("Enter the iD :- ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		System.out.println("Update the Name :- ");
		emp.setName(sc.next());

		session.update(emp);
		session.beginTransaction().commit();
		System.out.println("Data Updated !!!");
	}

	private static void singleEmployee(SessionFactory sf) {
		System.out.println("---SINGLE EMPLOYEE DETAILS---");
		Session session = sf.openSession();
		System.out.println("Enter the iD :- ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);
		System.out.println(emp);

	}

	private static void displayAllEmployee(SessionFactory sf) {
		System.out.println("---DISPLAY ALL EMPLOYEES---");
		Session session = sf.openSession();
		Query<Employee> employees = session.createQuery("from Employee");
		List<Employee> employeeList = employees.getResultList();
		System.out.println(employeeList);
	}

	private static void addEmployee(SessionFactory sf) {
		System.out.println("---ADD EMPLOYEES---");
		Session session = sf.openSession();
		System.out.println("How many Employee you want to add:- ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			
			Employee emp = new Employee();

			System.out.println("Enter the ID:- ");
			emp.setId(sc.nextInt());

			System.out.println("Enter the name of Employee:- ");
			emp.setName(sc.next());

			session.save(emp);
			session.beginTransaction().commit();
			System.out.println("Employee Added Successfully!!!!");
		}

	}

}