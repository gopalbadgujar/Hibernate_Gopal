package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	static boolean flag = true;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		getEmplDetails();
	}

	private static boolean getEmplDetails() {

		while (flag) {
			System.out.println("Add Employee Details :-");
			flag = sc.nextBoolean();
			if (flag == true) {
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();

				Employee e = new Employee();
				System.out.println("Enter Employee id: ");
				e.setEid(sc.nextInt());
				System.out.println("Enter Employee name: ");
				e.setEname(sc.next());
				System.out.println("Enter Employee address: ");
				e.setAddress(sc.next());

				session.save(e);
				session.beginTransaction().commit();
			} else {
				System.out.println("Exit the Application");
			}
			
			return getEmplDetails();
		}
		System.out.println("Successfully Enter the Employee Data.");
		return flag;
	}
}
