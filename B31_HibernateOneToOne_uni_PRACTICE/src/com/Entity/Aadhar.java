package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aadhar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	private String aadharName;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAadharName() {
		return aadharName;
	}

	public void setAadharName(String aadharName) {
		this.aadharName = aadharName;
	}

	@Override
	public String toString() {
		return "Aadhar [aid=" + aid + ", aadharName=" + aadharName + "]";
	}
	
	
}
