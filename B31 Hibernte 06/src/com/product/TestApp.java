package com.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

//	(openSession() :  create new object /instance.) --> it always return new instance of session. 
		Session session = sf.openSession();
//		Session session2=sf.openSession();
//		
//		System.out.println(session.hashCode());
//		System.out.println(session2.hashCode());

		//<getCurrentSession() : create new object & returns current active session >
//		Session session=sf.getCurrentSession();//create
//		System.out.println(session.hashCode());
//		
//		session.close();
//		
//		Session session2=sf.getCurrentSession();//
//		System.out.println(session2.hashCode());

		Grocery g = new Grocery();
		g.setGid(11);
		g.setGname("Abc");
//
		Electronics e = new Electronics();
		e.setEname("pqr");

		session.save(e);// 1 3

		int i=(int) session.save(g);//2          -->returns serializable int.
		session.beginTransaction().commit();
		System.out.println(i);

//		session.get(, arg1)
	}
}
