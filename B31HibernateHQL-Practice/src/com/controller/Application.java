package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.Employee;
import com.util.HibernateUtil;

public class Application {

	static SessionFactory sf = HibernateUtil.getSessionFactory();
	static Session session = sf.openSession();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

//		Employee e = new Employee();
//		e.setEname("Vijay");
//		e.setEsalary(48700.66);
//
//		session.save(e);
//		session.beginTransaction().commit();
		System.out.println("-----------------------------------------------------------------------");

//		getAllData();
//
//		getDataByCondition();

//		getNameOnly();
//
//		getNameAndMarksOnly();

//		updateData();

//		deleteData();
	}

	private static void deleteData() {
		session.beginTransaction();
		Query<Employee> query = session.createQuery("delete from Employee where eid=: id");
		System.out.println("Enter Id: ");
		query.setParameter("id", sc.nextInt());
		query.executeUpdate();
		System.out.println("Deleted...");
		System.out.println("=========================================================================");
	}

	private static void updateData() {
		// update Employee set ename = '----', esalary = 12334.09 where eid = 2
		session.beginTransaction();
		Query<Employee> query = session.createQuery("update Employee set ename=:name, esalary=:salary where eid =:id");
		System.out.println("Enter Updated Name : ");
		query.setParameter("name", sc.next());
		System.out.println("Enter Updated Salary : ");
		query.setParameter("salary", sc.nextDouble());
		System.out.println("Enter Id: ");
		query.setParameter("id", sc.nextInt());

		query.executeUpdate();
		System.out.println("Updated...");
		System.out.println("=========================================================================");
	}

	public static void getNameAndMarksOnly() {
		// select ename,esalary from Employee where eid=2
		Query<Object[]> query = session.createQuery("select ename,esalary from Employee where eid=2");
		Object[] obj = query.getSingleResult();
		System.out.println(Arrays.toString(obj));
		System.out.println("=========================================================================");
	}

	private static void getNameOnly() {
		// select ename from Employee
		Query<Employee> query = session.createQuery("select ename from Employee");
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("=========================================================================");
	}

	private static void getDataByCondition() {
		// select * from Employee where esalary > 50000
		Query<Employee> query = session.createQuery("from Employee where esalary > 50000");
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("=========================================================================");
	}

	private static void getAllData() {
		// select * from Employee
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("===========================================================================");
	}
}
