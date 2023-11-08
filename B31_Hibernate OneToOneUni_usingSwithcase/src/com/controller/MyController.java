package com.controller;

import java.util.Scanner;

import com.services.ServiceIMPL;
import com.services.Services;

public class MyController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;
		Services s = new ServiceIMPL();
		System.out.println("_______________________________________________________");
		System.out.println("!-----------------------------------------------------!");
		System.out.println("!                                                     !");
		System.out.println("!    1.  ADD CAR WITH ENGINE:                         !");
		System.out.println("!    2.  UPDATE ENGINE DATA WITH ENGINE ID:           !");
		System.out.println("!    3.  UPDATE CAR DATA WITH CAR ID:                 !");
		System.out.println("!    4.  UPDATE ENGINE DATA USING CAR ID:             !");
		System.out.println("!    5.  DELETE ONLY CAR:                             !");
		System.out.println("!    6.  DELETE ONLY ENGINE:                          !");
		System.out.println("!    7.  DELETE CAR AND ENGINE:                       !");
		System.out.println("!    8.  GET CAR WITH ENGINE:                         !");
		System.out.println("!    9.  APPLICATION EXIT:                            !");
		System.out.println("!                                                     !");
		System.out.println("!-----------------------------------------------------!");
		System.out.println("_______________________________________________________");

		while (flag) {
			System.out.println("Choose The Operation: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.addCarWithEngine();
				break;
			case 2:
				s.upadateEngineDataWithEID();
				break;
			case 3:
				s.upadteCarDataWithCarID();
				break;
			case 4:
				s.updateEngineDataUsingCId();
				break;
			case 5:
				s.deleteOnlyCar();
				break;
			case 6:
				s.deleteOnlyEngine();
				break;
			case 7:
				s.deleteCarAndEngine();
				break;
			case 8:
				s.getCarWithEngine();
				break;
			case 9:
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
