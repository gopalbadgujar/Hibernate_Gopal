package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernateUtil.HibernateUtil;
import com.model.Student;
import com.model.Subject;

public class ServiceImpl implements Services {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithMultipleSubject() {
		System.out.println("\n ADD STUDENT WITH MULTIPLE SUBJECT: ");
		Session session = sf.openSession();

		Student s = new Student();
		System.out.println("Enter sname : ");
		s.setSname(sc.next());

		System.out.println("How many Subject you want to add");
		int n = sc.nextInt();

		List<Subject> subList = new ArrayList<Subject>();
		for (int i = 1; i <= n; i++) {
			Subject sub = new Subject();

			System.out.println("Enter Subject Name : ");
			sub.setSubName(sc.next());

			subList.add(sub);
		}

		s.setSubList(subList);

		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Student With Multiple Subject Added Successfully ! \n");
	}

	@Override
	public void getStudentWithMultipleSubject() {
		System.out.println("\n GET STUDENT WITH MULTIPLE SUBJECT: ");
		Session session = sf.openSession();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter Student id: ");
			Student s = session.get(Student.class, sc.nextInt());
			if (s != null) {
				System.out.println(s + "\n");
				flag = false;
				break;
			} else {
				System.out.println("Invalid Student Id, Please Try Again...");
			}
		}

	}

	@Override
	public void updateStudent() {
		System.out.println("\n UPDATE STUDENT: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter sid");
			Student s = session.get(Student.class, sc.nextInt());
			if (s != null) {
				System.out.println("Enter Updated Name Of Student: ");
				sc.nextLine();
				s.setSname(sc.nextLine());

				session.update(s);
				session.beginTransaction().commit();
				System.out.println("Student Data is Updated Successfully !");
				flag = false;
				break;
			} else {
				System.out.println("Invalid Id is Entered, Plese try again...");
			}
		}
	}

	@Override
	public void updateSubjectUsingSID() {
		System.out.println("\n UPDATE SUBJECT USING STUDENT ID: ");
		Session session = sf.openSession();

		boolean flag1 = true;
		while (flag1) {
			System.out.println("Enter sid : ");
			Student s = session.get(Student.class, sc.nextInt());// list
			if (s != null) {
				boolean flag2 = true;
				while (flag2) {
					System.out.println("Enter subId : ");
					int subId = sc.nextInt();

					List<Subject> sublist = s.getSubList();

					for (Subject sub : sublist) {
						if (subId == sub.getSubId()) {
							System.out.println("Enter Updated Subject Name : ");
							sub.setSubName(sc.next());
							session.update(sub);
							session.beginTransaction().commit();
							System.out.println("Subject Updated Successfully !");
							flag2 = false;
							break;
						}
					}
					if (flag2) {
						System.out.println("Invalid Subject Id, please try again..");
					}
				}

				flag1 = false;
			} else {
				System.out.println("Invalid Student Id...");
			}
		}
	}

	@Override
	public void deleteStudentAndSubject() {
		System.out.println("\n DELETE STUDENT AND SUBJECT: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter sid: ");
			Student s = session.get(Student.class, sc.nextInt());
			if (s != null) {
				session.delete(s);
				session.beginTransaction().commit();
				System.out.println("Student & Subject Deleted Successfully !");
				flag = false;
				break;
			} else {
				System.out.println("Invalid id ");
			}
		}
	}

	@Override
	public void deleteSubjectOnly() {
		System.out.println("DELETE SUBJECT ONLY: ");
		Session session = sf.openSession();

		System.out.println("Enter sid : ");
		Student s = session.get(Student.class, sc.nextInt());
		if (s != null) {
			System.out.println("Enter Subject id : ");
			int subId = sc.nextInt();

			List<Subject> subList = s.getSubList();

			boolean flag = false;

			for (Subject sub : subList) {
				if (subId == sub.getSubId()) {
					subList.remove(sub);
					session.update(s);
					session.delete(sub);
					session.beginTransaction().commit();
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("Successfully deleted");
			} else {
				System.out.println("Subject id Not Found, Please Try Again...");
			}

		} else {
			System.out.println("Invalid input, Please Try Again...");
		}
	}

	@Override
	public void deleteStudentOnly() {
		System.out.println("\n DELETE STUDENT ONLY: ");
		Session session = sf.openSession();

		System.out.println("Enter sid: ");
		Student s = session.get(Student.class, sc.nextInt());
		if (s != null) {
			s.setSubList(null);
			session.update(s);
			session.delete(s);
			session.beginTransaction().commit();
			System.out.println("Student Deleted Succsessfully !");

		} else {
			System.out.println("Invalid input");
		}
	}

	@Override
	public void addSubjectToExistingStudent() {
		System.out.println("\n ADD SUBJECT TO EXISTING STUDENT: ");
		Session session = sf.openSession();

		System.out.println("Enter sid: ");
		Student stu = session.get(Student.class, sc.nextInt());
		if (stu != null) {
			Subject sub = new Subject();
			System.out.println("Enter New Subject Name: ");
			sub.setSubName(sc.next());

			List<Subject> sublist = stu.getSubList();
//			sublist.add(s);

			stu.getSubList().add(sub);

			session.saveOrUpdate(stu);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id");
		}
	}

	@Override
	public void getAllStudentsWithSubjects() {
		System.out.println("\n GET ALL STUDENTS WITH SUBJECTS: ");
		Session session = sf.openSession();

		// select * from student
		Query<Student> query = session.createQuery("from Student");// HQL
		List<Student> sList = query.getResultList();

		System.out.println(sList + "\n");
	}

	@Override
	public void addExistingSubjectToExistingStudent() {
		System.out.println("\n ADD EXISTING SUBJECT TO EXISTING STUDENT: ");
		Session session = sf.openSession();

		System.out.println("Enter Subject id: ");
		Subject sub = session.get(Subject.class, sc.nextInt());
		if (sub != null) {
			System.out.println("Enter sid: ");
			Student stu = session.get(Student.class, sc.nextInt());
			if (stu != null) {
				stu.getSubList().add(sub);
				session.update(stu);
				session.beginTransaction().commit();
			} else {
				System.out.println("Student not exist !!");
			}
		} else {
			System.out.println("subject not exist!!");
		}
	}
}
