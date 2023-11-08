package com.controller;

import com.services.ServiceIMPL;
import com.services.Services;

public class MyController {

	public static void main(String[] args) {
		
		Services s = new ServiceIMPL();
		s.addCarWithEngine();
		s.upadateEngineDataWithEID();
		s.upadteCarDataWithCarID();
		s.updateEngineDataUSsingCId();
//		s.deleteOnlyCar();
		s.deleteOnlyEngine();
		s.deleteCarAndEngine();
	}
}
