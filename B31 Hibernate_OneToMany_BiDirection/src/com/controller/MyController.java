package com.controller;

import java.util.Scanner;

import com.Services.ServiceImpl;
import com.Services.Services;

public class MyController {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;
		Services s = new ServiceImpl();

		while (flag) {
			System.out.println("_______________________________________________________");
			System.out.println("!-----------------------------------------------------!");
			System.out.println("!                                                     !");
			System.out.println("!    1.   ADD COMPANY WITH MULTIPLE EMPLOYEE:          !");
			System.out.println("!    2.   GET COMPANY WITH MULTILE EMPLOYEE:           !");
			System.out.println("!    3.   ADD EMPLOYEE WITH COMPANY:                   !");
			System.out.println("!    4.   UPDATE COMPANY:                              !");
			System.out.println("!    5.   UPDATE EMPLOYEE USING COMPANY ID:            !");
			System.out.println("!    6.   UPDATE COMPANY USING EMPLOYEE ID:            !");
			System.out.println("!    7.   DELETE COMPANY AND EMPLOYEES:                !");
			System.out.println("!    8.   DELETE EMPLOYEE ONLY USING COMPANY ID:       !");
			System.out.println("!    9.   DELETE COMAPANY WITHOUT EMPLOYEE:            !");
			System.out.println("!    10.  DELETE ALL EMPOYEE USING COMPANY ID:         !");
			System.out.println("!    11.  ADD EXISTING EMPLOYEE TO EXISTING COMPANY:   !");
			System.out.println("!    12.  APPLICATION EXIT:                            !");
			System.out.println("!                                                      !");
			System.out.println("!------------------------------------------------------!");
			System.out.println("________________________________________________________");

			System.out.println("\n -----CHOOSE THE OPERATION, YOU WANT TO PERFORM:----- \n");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.addCompanyWithEmployee();
				break;
			case 2: 
				s.getCompanyWithMultipleEmloyee();
				break;
			case 3:
				s.addEmployeeWithCompany();
				break;
			case 4:
				s.updateCompany();
				break;
			case 5:
				s.updateEmployeeUsingCID();
				break;
			case 6:
				s.updateCompanyUsingEID();
				break;
			case 7:
				s.deleteCompanyAndEmployees();
				break;
			case 8:
				s.deleteEmployeeOnlyUsingCID();
				break;
			case 9:
				s.deleteComapanyWithoutEmployee();
				break;
			case 10:
				s.deleteAllEmpoyeeUsingCid();
				break;
			case 11:
				s.addExistingEmployeeToExistingCompany();
				break;
			case 12:
				flag = false;
				System.out.println("---Exit Application---");
				break;

			default:
				System.out.println("Invalid Choice, Try Again... !!!");
				break;
			}

		}
	}
}
