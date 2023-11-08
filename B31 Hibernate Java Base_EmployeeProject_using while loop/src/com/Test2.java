package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test2 {

	static boolean flag = true;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		getEmpDetails();
	}

	private static void getEmpDetails() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		while (flag) {
			System.out.println("Enter the option: ");
			System.out.println("1 Register ");
			System.out.println("2 exist");
			int i = sc.nextInt();
			if (i == 1) {
				Employee e = new Employee();
				System.out.println("Enter Employee id: ");
				e.setEid(sc.nextInt());
				System.out.println("Enter Employee name: ");
				e.setEname(sc.next());
				System.out.println("Enter Employee address: ");
				e.setAddress(sc.next());

				session.saveOrUpdate(e);
				session.beginTransaction().commit();
				System.out.println("Successfully Enter the Employee Data.");
			} else {
				System.out.println("Exit the Application.");
				flag = false;
			}
		}
	}

}
