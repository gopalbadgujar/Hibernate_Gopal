package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Entity.Aadhar;
import com.Entity.Person;
import com.hibernateUtil.HibernateUtil;

public class ServiceIMPL implements Services {

	SessionFactory sf = HibernateUtil.getConnection();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonDetailsWithAdhar() {
		Session session = sf.openSession();

		Person p = new Person();
		System.out.println("Enter the Person Name: ");
		p.setPname(sc.next());

		Aadhar a = new Aadhar();
		System.out.println("Enter the Aadhar Name: ");
		a.setAadharName(sc.next());

		p.setAadhar(a);

		session.save(p);
		session.beginTransaction().commit();
		System.out.println("Details Inserted!!!");
	}

	@Override
	public void showAllPersonDetailWithAdhar() {
		Session session = sf.openSession();

		Query<Person> allPersonDetails = session.createQuery("from Person");
		System.out.println(allPersonDetails.getResultList());
	}

	@Override
	public void getsinglePersonDetail() {
		Session session = sf.openSession();
		System.out.println("Enter the Person ID for give the Single Person Details: ");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);
		if (p != null) {
			System.out.println("Person Name: " + p.getPname());
			System.out.println("Person Aadhar Details: " + p.getAadhar());
		} else {
			System.out.println("ID Does not exists. ");
		}
	}

	@Override
	public void updatePersonDetailsUsingPID() {
		Session session = sf.openSession();
		System.out.println("\n UPDATE PERSION DETAILS USING PERSON ID:");
		System.out.println("Enter pid :");
		Person p = session.get(Person.class, sc.nextInt());
		if (p != null) {
			System.out.println("Enter Updated Name of Person: ");
			p.setPname(sc.next());
			System.out.println("Enter the Updated Aadhar Name: ");
			p.getAadhar().setAadharName(sc.next());
			;
			session.update(p);
			session.beginTransaction().commit();
			System.out.println("Details Updated !!");
		} else {
			System.out.println("ID Does not exists.");
		}
	}

	@Override
	public void deleteAdharUsingPID() {
		Session session = sf.openSession();
		System.out.println("DELETE AADHAR DETAILS:");
		System.out.println("Enter the person ID you want to delete:- ");
		Person p = session.get(Person.class, sc.nextInt());

		if (p != null) {
			Aadhar ad = p.getAadhar();
			p.setAadhar(null);

			session.update(p);
			session.beginTransaction().commit();
			System.out.println("Adhar Deleted!!!");
		} else {
			System.out.println("ID Does not exists.");
		}

	}

}
