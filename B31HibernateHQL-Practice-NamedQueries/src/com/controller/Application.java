package com.controller;

import java.util.Scanner;

public class Application {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;

		while (flag) {
			System.out.println("_______________________________________________________");
			System.out.println("!-----------------------------------------------------!");
			System.out.println("!                                                     !");
			System.out.println("!    1.   GET NEW EMPLOYEE :                          !");
			System.out.println("!    2.   GET ALL DATA :                              !");
			System.out.println("!    3.   GET DATA BY CONDITION :                     !");
			System.out.println("!    4.   GET NAME ONLY :                             !");
			System.out.println("!    5.   GET NAME AND SALARY ONLY :                  !");
			System.out.println("!    6.   EMPLOYEE NAME STARTS FROM :                 !");
			System.out.println("!    7.   UPDATE DATA :                               !");
			System.out.println("!    8.   GET SINGLE EMPLOYEE :                       !");
			System.out.println("!    9.   SEARCH NAME LIKE :                          !");
			System.out.println("!    10.  DELETE DATA :                               !");
			System.out.println("!    11.  MAXIMUM EMPLOYEE SALARY :                   !");
			System.out.println("!    12.  MINIMUM EMPLOYEE SALARY :                   !");
			System.out.println("!    13.  AVERAGE EMPLOYEE SALARY :                   !");
			System.out.println("!    14.  COUNT EMPLOYEE SALARY :                     !");
			System.out.println("!    15.  ALL EMPLOYEES :                             !");
			System.out.println("!    16.  EXIT APPLICATION :                          !");
			System.out.println("!                                                     !");
			System.out.println("!-----------------------------------------------------!");
			System.out.println("_______________________________________________________");

			System.out.println("\n -----CHOOSE THE OPERATION, YOU WANT TO PERFORM:-----");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Methods.getNewEmployee();
				break;
			case 2:
				Methods.getAllData();
				break;
			case 3:
				Methods.getDataByCondition();
				break;
			case 4:
				Methods.getNameOnly();
				break;
			case 5:
				Methods.getNameAndSalaryOnly();
				break;
			case 6:
				Methods.employeeNameStartsFrom();
				break;
			case 7:
				Methods.updateData();
//					int[] i= new int[5];
				break;
			case 8:
				Methods.getSingleEmployee();
				break;
			case 9:
					Methods.searchNameLike();
				break;
			case 10:
				Methods.deleteData();
				break;
			case 11:
				Methods.maxEmployeeSalary();
				break;
			case 12:
				Methods.minEmployeeSalary();
				break;
			case 13:
				Methods.avgEmployeeSalary();
				break;
			case 14:
				Methods.countEmployeeSalary();
				break;
			case 15:
				Methods.AllEmployees();
				break;

			case 16:
				System.out.println("-------EXIT APPLICATION-------");
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice, Please Try Again...");
				break;
			}
		}

	}

}
