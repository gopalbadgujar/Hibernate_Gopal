package com.services;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;
import com.model.AadharCard;
import com.model.Person;

public class ServiceIMPL implements Services {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonWithAdharCard() {

		Session session = sf.openSession();
		System.out.println("ADD PERSON WITH AADHARCARD ");
		Person p = new Person();

		System.out.println("Enter pname : ");
		p.setPname(sc.next());

		AadharCard a = new AadharCard();
		System.out.println("Enter aname : ");
		a.setAname(sc.next());

		p.setAdharCard(a);
		a.setPerson(p);

		session.save(p);
		session.beginTransaction().commit();

	}

	@Override
	public void addAdharCradWithPerson() {

		Session session = sf.openSession();
		System.out.println("ADD AADHAR CARD WITH PERSON");

		Person p = new Person();
		System.out.println("Enter pname : ");
		p.setPname(sc.next());

		AadharCard a = new AadharCard();
		System.out.println("Enter aname : ");
		a.setAname(sc.next());

		p.setAdharCard(a);
		a.setPerson(p);

		session.save(a);
		session.beginTransaction().commit();

	}

	@Override
	public void getPersonWithAdharCard() {
		Session session = sf.openSession();
		System.out.println("GET PERSON WITH AADHAR CARD");

		System.out.println("Enter pid : ");
		Person p = session.get(Person.class, sc.nextInt());

		System.out.println(p);// null -- toString

	}

	@Override
	public void getAdharCardwithPerson() {
		Session session = sf.openSession();
		System.out.println("GET AADHAR CARD WITH PERSON ");

		System.out.println("Enter Aid : ");
		AadharCard a = session.get(AadharCard.class, sc.nextInt());

		System.out.println(a);// null -- toString
	}

	@Override
	public void updateAadharCardUsingPID() {
		Session session = sf.openSession();
		System.out.println("UPDATE AADHAR CARD USING PERSON ID");
		System.out.println("Enter pid : ");
		Person p = session.get(Person.class, sc.nextInt());

		if (p != null) {
			AadharCard a = p.getAdharCard();
			System.out.println("Adhar Name : ");
			a.setAname(sc.next());

			session.update(a);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id !!");
		}
	}

	@Override
	public void updatePersonUsingAID() {
		Session session = sf.openSession();
		System.out.println("UPDATE PERSON USING AADHAR ID");
		System.out.println("Enter aid: ");
		AadharCard a = session.get(AadharCard.class, sc.nextInt());
		if (a != null) {
			Person p = a.getPerson();
			System.out.println("Enter Updated Person Name: ");
			p.setPname(sc.next());

			session.update(p);
			session.beginTransaction().commit();
		} else {
			System.err.println("Invalid id !!");
		}

	}

	@Override
	public void deletePersonWithAdharCard() {
		Session session = sf.openSession();
		System.out.println("DELETE PERSON WITH AADHAR CARD");
		System.out.println("Enter pid: ");
		Person p = session.get(Person.class, sc.nextInt());
		if(p != null) {
			session.delete(p);
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Invalid Id !!");
		}
	}

	@Override
	public void deleteAdharCardWithPerson() {
		Session session = sf.openSession();
		System.out.println("DELETE AADHAR CARD WITH PERSON ");

		System.out.println("Enter aid : ");
		AadharCard a = session.get(AadharCard.class, sc.nextInt());

		if (a != null) {
			session.delete(a);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid Id !!");
		}

	}

	@Override
	public void deletePersonOnly() {

		Session session = sf.openSession();

		System.out.println("Enter pid : ");
		Person p = session.get(Person.class, sc.nextInt());

		if (p != null) {

			AadharCard a = p.getAdharCard();

			a.setPerson(null);
			p.setAdharCard(null);

			session.update(p);
			session.update(a);
			session.delete(p);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid Id : ");
		}
	}

	@Override
	public void deleteAdharCardOnly() {

	}

}
