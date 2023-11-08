package com;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEid(1);
		emp.setEname("abc");

		Configuration cfg = new Configuration();
		Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		session.save(emp);

		session.beginTransaction().commit();

		System.out.println("Successfull!!");
	}
}
