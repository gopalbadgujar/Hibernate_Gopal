package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.producrts.Electronics;
import com.producrts.Grocery;
import com.util.HibernateUtil;

public class TestCache {


	public static void main(String[] args) {
		
		SessionFactory sf= HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		Session session1=sf.openSession();
		
		Electronics e=session.get(Electronics.class, 1);//1
		System.out.println(e);
		
		Grocery g=session.get(Grocery.class, 2);//2
		System.out.println(g);
		
//		session.clear();//clear all cache
//		session.evict(e);//particular object cache clear
		
//		sf.getCache().evict(Electronics.class);
		sf.getCache().evictAll();
		
		
		System.out.println("-----------------------------------");
		
		
		Electronics e1=session1.get(Electronics.class, 1);//3
		System.out.println(e1);
		
		Grocery g1=session1.get(Grocery.class, 2);//4
		System.out.println(g1);
		
		
		
		
//		Electronics e1=session.get(Electronics.class, 1);
//		System.out.println(e1);
//		
//		Electronics e2=session.get(Electronics.class, 1);
//		System.out.println(e2);
		
		
//		
//		Electronics e2=session.get(Electronics.class, 1);//no
//		System.out.println(e2);
//		
//		System.out.println("-----------------------------------");
//		
//		Electronics e3=session.get(Electronics.class, 3);//no
//		System.out.println(e3);
//		
	}
}
