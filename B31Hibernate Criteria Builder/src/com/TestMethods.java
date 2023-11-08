package com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TestMethods {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	static Scanner sc = new Scanner(System.in);

	public static void getAllStudent(SessionFactory sf) {
		// select * from stu_details
		Session session = sf.openSession();

		// 1. Get Builder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// 2. create criteria query
		CriteriaQuery<Student> criteriaquery = builder.createQuery(Student.class);

		// 3. copy of table
		Root<Student> root = criteriaquery.from(Student.class);

		// 4. Query Build
		criteriaquery.select(root);

		// 5. provide the query to session
		Query<Student> query = session.createQuery(criteriaquery);
		List<Student> slist = query.getResultList();
		System.out.println(slist);
		System.out.println("============================================================================");
	}

	public static void getSingleStudent(SessionFactory sf) {
		// select * from stu_details where sid = 1;
		Session session = sf.openSession();

		// 1. Get Builder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// 2. create criteria query
		CriteriaQuery<Student> criteriaquery = builder.createQuery(Student.class);

		// 3. copy of table
		Root<Student> root = criteriaquery.from(Student.class);

		// 4. Query Build
		System.out.println("Enter Id: ");
		criteriaquery.select(root).where(builder.equal(root.get("sid"), sc.nextInt()));

		// 5. provide the query to session
		Query<Student> query = session.createQuery(criteriaquery);
		Student s = query.getSingleResult();
		System.out.println(s);
		System.out.println("============================================================================");
	}
	
	public static void getMaxMarksOfStudent(SessionFactory sf) {
		// select max(marks) from stu_details
		Session session = sf.openSession();

		// 1. Get Builder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// 2. create criteria query
		CriteriaQuery<Double> criteriaquery = builder.createQuery(Double.class);

		// 3. copy of table
		Root<Student> root = criteriaquery.from(Student.class);

		// 4. Query Build
		System.out.println("Enter Id: ");
		criteriaquery.select(builder.max(root.get("marks")));

		// 5. provide the query to session
		Query<Double> query = session.createQuery(criteriaquery);
		double d = query.getSingleResult();
		System.out.println(d);
		System.out.println("============================================================================");
	}
	
	

	public static void getDataByCondition(SessionFactory sf) {
		// select * from student_deatils where marks > 50.00
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student where marks >: smarks");
		System.out.println("Enter Marks: ");
		query.setParameter("smarks", sc.nextDouble());
		List<Student> list = query.getResultList();

		System.out.println(list);
		System.out.println("============================================================================");
	}

	public static void getNameOnly(SessionFactory sf) {
		// select name from student_deatils

		Session session = sf.openSession();
		Query<String> query = session.createQuery("select sname from Student");
		List<String> list = query.getResultList();

		System.out.println(list);
		System.out.println("============================================================================");
	}

	public static void getNameAndMarksOnly(SessionFactory sf) {

		// select sname,marks from student_deatils where sid=4

		Session session = sf.openSession();
		Query<Object[]> query = session.createQuery("select sname,marks from Student where sid=2");

		Object[] obj = query.getSingleResult();

		System.out.println(Arrays.toString(obj));
		System.out.println("============================================================================");
	}

	// update
	public static void updateData(SessionFactory sf) {
		// select * from student_deatils

		Session session = sf.openSession();
		session.beginTransaction();
		Query<Student> query = session.createQuery("update Student Set sname=:name where sid =:id");// hql
		System.out.println("Enter Updated Name: ");
		query.setParameter("name", sc.next());
		System.out.println("Enter Id: ");
		query.setParameter("id", sc.nextInt());

		query.executeUpdate();
		System.out.println("update");
		System.out.println("============================================================================");
	}

	public static void getNewStudent(SessionFactory sf) {
		Session session = sf.openSession();
		Student s1 = new Student();
		System.out.println("Enter The Name of Student: ");
		s1.setSname(sc.next());
		System.out.println("Enter The Marks of Student: ");
		s1.setMarks(sc.nextDouble());
		session.save(s1);
		session.beginTransaction().commit();
	}

	public static void searchNameLike(SessionFactory sf) {
		//
		Session session = sf.openSession();
		session.beginTransaction();
		Query<Student> query = session.createNamedQuery("searchNameLike");
		List<Student> list = query.getResultList();
		System.out.println(list);
		System.out.println("============================================================================");
	}

}
