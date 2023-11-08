package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Student s = new Student(11, "pqr", "Tuljapur");

//		session.save(s);//insert into stu_details(sid,stu_name) values (?,?);
////		session.persist(s);
//		session.saveOrUpdate(s);
////		session.update(s);
//		session.beginTransaction().commit();
//		
////		System.out.println(i);

		Student stu = session.get(Student.class, 11);// instance -- default -- non prametrimes
		System.out.println(stu);
	}
}
