package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Student s1 = new Student();
		System.out.println("Enter Student Id: ");
		s1.setSid(sc.nextInt());
		System.out.println("Enter Student Name: ");
		s1.setSname(sc.next());

		session.update(s1); // return type - int
		session.beginTransaction().commit();

		//(get():-  retrieve a data by using id)--> return type object
		Student sGet = session.get(Student.class, 1); // class name , Id -- primary key
		System.out.println(sGet);// abc 11

		//(load():-  retrieve a data by using id)--> return type object
		Student sLoad= session.load(Student.class, 2); 
		System.out.println(sLoad);

	}
}
