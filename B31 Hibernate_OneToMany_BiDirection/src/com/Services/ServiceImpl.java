package com.Services;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Company;
import com.model.Employee;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCompanyWithEmployee() {
		System.out.println("\n ADD COMPANY WITH EMPLOYEE: ");
		Session session = sf.openSession();

		Company c = new Company();
		System.out.println("Enter Company Name: ");
		c.setCname(sc.next());

		System.out.println("How many Employee you want to add: ");
		int noOfEmp = sc.nextInt();

		List<Employee> elist = c.getElist();

		for (int i = 1; i <= noOfEmp; i++) {
			Employee e = new Employee();
			System.out.println("Enter Employee Name : ");
			e.setEname(sc.next());
			e.setCompany(c);
			elist.add(e);
		}
		c.setElist(elist);
		session.save(c);
		session.beginTransaction().commit();
		System.out.println("Company & Employee Added Successfully ! ");
	}

	@Override
	public void getCompanyWithMultipleEmloyee() {//////////////////////////
		System.out.println("\n GET COMPANY WITH MULTIPLE EMPLOYEE: ");
		Session session = sf.openSession();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				System.out.println(c + "\n");
				flag = false;
				break;
			} else {
				System.out.println("Invalid Company Id, Please Try Again...");
			}
		}
	}

	@Override
	public void addEmployeeWithCompany() {///////////////////////////////
		System.out.println("\n ADD EMPLOYEE WITH COMPANY: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company Id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				System.out.println("Add New Employee: ");
				List<Employee> elist = c.getElist();

				System.out.println("Enter New Employee Name: ");
				Employee e = new Employee();
				e.setEname(sc.next());
				e.setCompany(c);
				elist.add(e);
				c.setElist(elist);

				session.update(c);
				session.beginTransaction().commit();
				System.out.println("Employee Added Successfully !");
				flag = false;
				break;

			} else {
				System.out.println("Invalid Company Id, Please Try Again...");
			}
		}
	}

	@Override
	public void updateCompany() {
		System.out.println("\n UPDATE COMPANY: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company Id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				System.out.println("Enter Updated Company Name: ");
				c.setCname(sc.next());
				session.update(c);
				session.beginTransaction().commit();
				System.out.println("Company Updataed Successfully !");
				flag = false;
				break;

			} else {
				System.out.println("Invalid Company Id, Please Try Again...");
			}
		}
	}

	@Override
	public void updateEmployeeUsingCID() {
		System.out.println("\n UPDATE EMPLOYEE USING COMPANY ID: ");
		Session session = sf.openSession();

		System.out.println("Enter Company Id: ");
		Company c = session.get(Company.class, sc.nextInt());
		if (c != null) {
			System.out.println("Enter Employee id: ");
			Employee emp = session.get(Employee.class, sc.nextInt());
			if (emp != null) {
				System.out.println("Enter Updated Employee Name: ");
				emp.setEname(sc.next());

				session.update(c);
				session.beginTransaction().commit();
				System.out.println("By Using Company Id, Employee Updated Successfully ! ");
			} else {
				System.out.println("Invalid Employee Id, Plese Try Again...");
			}
		} else {
			System.out.println("Invalid Company Id, Plese Try Again...");
		}
	}

	@Override
	public void updateCompanyUsingEID() { ///////////////////
		System.out.println("\n UPDATE COMPANY USING EMPLOYEE ID: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Employee id: ");
			Employee e = session.get(Employee.class, sc.nextInt());
			if (e != null) {
				Company c = e.getCompany();
				System.out.println("Enter Updated Company Name: ");
				c.setCname(sc.next());

				session.update(e);
				session.beginTransaction().commit();
				System.out.println("Company Update Successfully !");
				flag = false;
				break;

			} else {
				System.out.println("Invalid Employee Id, Plese Try Again...");
			}
		}
	}

	@Override
	public void deleteCompanyAndEmployees() {
		System.out.println("\n DELETE COMPANY AND EMPLOYEES: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				session.delete(c);

				session.beginTransaction().commit();
				System.out.println("Company And Employee Deleted Successfully !");
				flag = false;
				break;
			} else {
				System.out.println("Invalid Company Id, Plese Try Again...");
			}
		}
	}

	@Override
	public void deleteEmployeeOnlyUsingCID() {
		System.out.println("\n DELETE EMPLOYEE ONLY USING COMPANY ID: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				List<Employee> elist = c.getElist();
				System.out.println("Enter Employee id: ");
				int eid = sc.nextInt();
				for (Employee e : elist) {
					if (eid == e.getEid()) {
						elist.remove(e);
						e.setCompany(null);

						session.update(c);
						session.delete(e);
						session.beginTransaction().commit();
						break;
					}
				}
				flag = false;
				break;
			} else {
				System.out.println("Invalid Company Id, Plese Try Again...");
			}
		}
	}

	@Override
	public void deleteComapanyWithoutEmployee() {
		System.out.println("\n DELETE COMPANY WITHOUT EMPLOYEE: ");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				List<Employee> elist = c.getElist();
				c.setElist(null);
				for (Employee e : elist) {
					e.setCompany(null);
				}
				session.update(c);
				session.delete(c);
				session.beginTransaction().commit();
				System.out.println("Company Deleted Successfully !");
				flag = false;
				break;
			} else {
				System.out.println("Invalid Id, Please Try Again...");
			}
		}
	}

	@Override
	public void deleteAllEmpoyeeUsingCid() {
		System.out.println("\n DELETE ALL EMPLOYEE USING COMPANY ID");
		Session session = sf.openSession();

		boolean flag = true;
		while (flag) {
			System.out.println("Enter Company id: ");
			Company c = session.get(Company.class, sc.nextInt());
			if (c != null) {
				List<Employee> elist = c.getElist();
				c.setElist(null);
				for (Employee e : elist) {
					e.setCompany(null);
					session.delete(e);
				}
				session.update(c);
				session.beginTransaction().commit();
				System.out.println("Employee Deleted Successfully !");
				flag = false;
				break;
			} else {
				System.out.println("Invalid Id, Please Try Again...");
			}
		}
	}

	@Override
	public void addExistingEmployeeToExistingCompany() { //*********************//
		System.out.println("\n ADD EXISTING EMPLOYEE TO EXISTING COMPANY:");
		Session session = sf.openSession();

		System.out.println("Enter Employee id: ");
		Employee emp = session.get(Employee.class, sc.nextInt());
		if (emp != null) {
			System.out.println("Enter Company id: ");
			Company com = session.get(Company.class, sc.nextInt());
			if (com != null) {
				com.getElist().add(emp);
				session.update(com);
				session.beginTransaction().commit();
			} else {
				System.out.println("Company not exist !!");
			}
		} else {
			System.out.println("Employee not exist!!");
		}
	}

}
