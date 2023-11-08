package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Student s = new Student();
		s.setSid(18);
		s.setSname("abcde");

		session.save(s); // return type - int
		session.beginTransaction().commit();
		
		s.setSname("Pqr");
		
		System.out.println("\n get() method");
		Student sGet = session.get(Student.class, 18); // class name , Id -- primary key
		System.out.println(sGet.getSid());  //  13
		System.out.println(sGet.getSname());//abcd

//		System.out.println("\n load() method");
//		Student sLoad= session.load(Student.class, 14); 
//		System.out.println(sLoad.getSid());
//		System.out.println(sLoad.getSname());

//		session.update(s);  // return-type void
//		session.beginTransaction().commit();

//		session.delete(s);
//		session.beginTransaction().commit();

//		session.saveOrUpdate(s);//not present - insert : present - update // return-type void
//		session.beginTransaction().commit();

//		Student s=session.get(Student.class, 11);//(retrieve a data by using id)--> return type object
//		System.out.println(s.getSid());
//		System.out.println(s.getSname());

//		Student s1 = session.load(Student.class, 11);// proxy lazy (retrieve a data by using id)--> return type object
//		System.out.println(s1.getSid());
//		System.out.println(s.getSname());

	}
}
