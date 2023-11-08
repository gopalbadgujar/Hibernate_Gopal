package com.controller;

import java.util.Scanner;

import com.services.ServiceImpl;
import com.services.Services;

public class MyController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = true;
		Services s = new ServiceImpl();

		while (flag) {
			System.out.println("________________________________________________________");
			System.out.println("!------------------------------------------------------!");
			System.out.println("!                                                      !");
			System.out.println("!    1.   ADD STUDENT WITH MULTIPLE SUBJECT:           !");
			System.out.println("!    2.   GET STUDENT WITH MULITPLE SUBJECT:           !");
			System.out.println("!    3.   UPDATE STUDENT:                              !");
			System.out.println("!    4.   UPDATE SUBJECT USING STUDENT ID:             !");
			System.out.println("!    5.   DELETE STUDENT AND SUBJECT:                  !");
			System.out.println("!    6.   DELETE SUBJECT ONLY:                         !");
			System.out.println("!    7.   DELETE STUDENT ONLY:                         !");
			System.out.println("!    8.   ADD SUBJECT TO EXISTING STUDENT:             !");
			System.out.println("!    9.   GET ALL STUDENTS WITH SUBJECTS:              !");
			System.out.println("!    10.  ADD SUBJECT TO EXISTING SUBJECT:             !");
			System.out.println("!    11.  APPLICATION EXIT:                            !");
			System.out.println("!                                                      !");
			System.out.println("!------------------------------------------------------!");
			System.out.println("________________________________________________________");

			System.out.println("\n -----CHOOSE THE OPERATION, YOU WANT TO PERFORM:----- \n");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.addStudentWithMultipleSubject();
				break;
			case 2:
				s.getStudentWithMultipleSubject();
				break;
			case 3:
				s.updateStudent();
				break;
			case 4:
				s.updateSubjectUsingSID();
				break;
			case 5:
				s.deleteStudentAndSubject();
				break;
			case 6:
				s.deleteSubjectOnly();
				break;
			case 7:
				s.deleteStudentOnly();
				break;
			case 8:
				s.addSubjectToExistingStudent();
				break;
			case 9:
				s.getAllStudentsWithSubjects();
				break;
			case 10:
				s.addExistingSubjectToExistingStudent();
				break;
			case 11:
				flag = false;
				System.out.println("---Exit Application---");
				break;

			default:
				System.out.println("Invalid Choice !!!");
				break;
			}

		}
	}

}
