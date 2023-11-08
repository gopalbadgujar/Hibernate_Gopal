package com.controller;

import com.services.ServiceIMPL;
import com.services.Services;

public class MyController {
	
	
	public static void main(String[] args) {
		
		Services s= new ServiceIMPL();
		
//		s.addPersonWithAdharCard();
		
		s.getAdharCardwithPerson();
		
//		s.addAdharCradWithPerson();
		
//		s.getPersonWithAdharCard();
		
//		s.updateAadharCardUsingPID();
		
//		s.deleteAdharCardWithPerson();
		
//		s.deletePersonOnly();
		
	}

}
