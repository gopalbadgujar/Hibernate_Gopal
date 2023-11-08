package com;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {
	static Scanner sc = new Scanner(System.in);
//	 TestMethods tm = new TestMethods();

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		 TestMethods tm = new TestMethods();


		boolean flag = true;
		while (flag) {
			System.out.println("_______________________________________________________");
			System.out.println("!-----------------------------------------------------!");
			System.out.println("!                                                     !");
			System.out.println("!    1.   GET NEW STUDENT :                           !");
			System.out.println("!    2.   GET ALL DATA :                              !");
			System.out.println("!    3.   GET DATA BY CONDITION :                     !");
			System.out.println("!    4.   GET NAME ONLY :                             !");
			System.out.println("!    5.   GET NAME AND MARKS ONLY :                   !");
			System.out.println("!    6.   UPDATE DATA :                               !");
			System.out.println("!    7.   GET SINGLE STUDENT :                        !");
			System.out.println("!    8.   SEARCH NAME LIKE :                          !");
			System.out.println("!    9.   EXIT APPLICATION:                           !");
//			System.out.println("!    10.  :         !");
//			System.out.println("!    11.  :   !");
//			System.out.println("!    12.  :                            !");
			System.out.println("!                                                      !");
			System.out.println("!------------------------------------------------------!");
			System.out.println("________________________________________________________");

			System.out.println("\n -----CHOOSE THE OPERATION, YOU WANT TO PERFORM:----- \n");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				TestMethods.getNewStudent(sf);
				break;
			case 2:
				TestMethods.getAllData(sf);
				break;
			case 3:
				TestMethods.getDataByCondition(sf);
				break;
			case 4:
				TestMethods.getNameOnly(sf);
				break;
			case 5:
				TestMethods.getNameAndMarksOnly(sf);
				break;
			case 6:
				TestMethods.updateData(sf);
//				int[] i= new int[5];
				break;
			case 7:
				TestMethods.getSingleStudent(sf);
				break;
			case 8:
				TestMethods.searchNameLike(sf);
				break;
				
			case 9:
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
