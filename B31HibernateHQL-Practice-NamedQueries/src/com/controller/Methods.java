package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.Employee;
import com.util.HibernateUtil;

public class Methods {
	static SessionFactory sf = HibernateUtil.getSessionFactory();
	static Session session = sf.openSession();
	static Scanner sc = new Scanner(System.in);

	public static void getNewEmployee() {
		Employee e = new Employee();
		System.out.println("Enter Employee Name : ");
		e.setEname(sc.next());
		System.out.println("Enter Employee Salary : ");
		e.setEsalary(sc.nextDouble());

		session.save(e);
		session.beginTransaction().commit();
		System.out.println("===========================================================================");
	}

	public static void getAllData() {
		// select * from Employee
		Query<Employee> query = session.createNamedQuery("AllEmployeeData");
		query.getResultList().forEach(System.out::println);
		System.out.println("===========================================================================");
	}

	public static void AllEmployees() {
		// select * from Employee
		Query<Employee> query = session.getNamedNativeQuery("AllEmployees");
		query.getResultList().forEach(System.out::println);
		System.out.println("===========================================================================");
	}

	public static void updateData() {
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

	public static void deleteData() {
		Query<Employee> query = session.createQuery("delete from Employee where eid=: id");
		System.out.println("Enter Id: ");
		query.setParameter("id", sc.nextInt());
		query.executeUpdate();
		System.out.println("Deleted...");
		System.out.println("=========================================================================");
	}

	public static void getNameOnly() {
		// select ename from Employee
		Query<Employee> query = session.createQuery("select ename from Employee");
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("=========================================================================");
	}

	public static void getNameAndSalaryOnly() {
		// select ename,esalary from Employee where eid=2
		Query<Object[]> query = session.createQuery("select ename,esalary from Employee where eid=:id ");
		System.out.println("Enter Id : ");
		query.setParameter("id", sc.nextInt());
		Object[] obj = query.getSingleResult();
		System.out.println(Arrays.toString(obj));
		System.out.println("=========================================================================");
	}

	public static void getDataByCondition() {
		// select * from Employee where esalary > 50000
		Query<Employee> query = session.createQuery("from Employee where esalary >:salary");
		System.out.println("Enter Salary: ");
		query.setParameter("salary", sc.nextDouble());
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("=========================================================================");
	}

	public static void getSingleEmployee() {
		Query<Employee> query = session.createNamedQuery("SingleEmployeeData");
		System.out.println("Enter Id : ");
		query.setParameter("id", sc.nextInt());
		System.out.println(query.getSingleResult());
		System.out.println("=========================================================================");
	}

	public static void employeeNameStartsFrom() {
		Query<Employee> query = session.createNamedQuery("employeeNameStartsFrom");
		System.out.println("Enter name : ");
		query.setParameter("name", sc.next());
		System.out.println(query.getResultList());
		System.out.println("=========================================================================");
	}

	public static void searchNameLike() {
		Query<Employee> query = session.createNamedQuery("searchNameLike");
		System.out.println(query.getResultList());
		System.out.println("=========================================================================");
	}

	public static void maxEmployeeSalary() {
		Query<Employee> query = session.createNamedQuery("maxEmployeeSalary");
		System.out.println(query.getSingleResult());
		System.out.println("=========================================================================");
	}

	public static void minEmployeeSalary() {
		Query<Employee> query = session.createNamedQuery("minEmployeeSalary");
		System.out.println(query.getSingleResult());
		System.out.println("=========================================================================");
	}

	public static void avgEmployeeSalary() {
		Query<Employee> query = session.createNamedQuery("avgEmployeeSalary");
		System.out.println(query.getSingleResult());
		System.out.println("=========================================================================");
	}

	public static void countEmployeeSalary() {
		Query<Employee> query = session.createNamedQuery("countEmployeeSalary");
		System.out.println(query.getSingleResult());
		System.out.println("=========================================================================");
	}

}
