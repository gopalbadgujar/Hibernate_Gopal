package com.controller;

import java.util.Scanner;

import com.service.ServiceIMPL;
import com.service.Services;

public class HomeController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;
		Services s = new ServiceIMPL();
		System.out.println("_______________________________________________________");
		System.out.println("!-----------------------------------------------------!");
		System.out.println("!                                                     !");
		System.out.println("!    1.  Add Person Details With Aadhar:              !");
		System.out.println("!    2.  Show All Person Details With Aadhar:         !");
		System.out.println("!    3.  Get Single Person Details:                   !");
		System.out.println("!    4.  Update Person Details Using Person Id:       !");
		System.out.println("!    5.  Delete Aadhar:                               !");
		System.out.println("!    6.  Exit Application:                            !");		
		System.out.println("!                                                     !");
		System.out.println("!-----------------------------------------------------!");
		System.out.println("_______________________________________________________");


		while (flag) {
			System.out.println("Choose Your Choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.addPersonDetailsWithAdhar();
				break;
			case 2:
				s.showAllPersonDetailWithAdhar();
				break;
			case 3:
				s.getsinglePersonDetail();
				break;
			case 4:
				s.updatePersonDetailsUsingPID();
				break;
			case 5:
				s.deleteAdharUsingPID();
				break;

			case 6:
				flag = false;
				System.out.println("---Exit Application---");
				break;

			default:
				System.out.println("Invalid Choice, Please Try Again..");
				break;
			}
		}
	}
}
