package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Student s = new Student();
		s.setSid(12);
		s.setSname("Mohit");

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Success");

//		 SessionFactory == Session == save

	}

}
