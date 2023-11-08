package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AadharCard aadharCard;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public AadharCard getAdharCard() {
		return aadharCard;
	}

	public void setAdharCard(AadharCard adharCard) {
		this.aadharCard = adharCard;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", adharCard=" + aadharCard + "]";
	}
	
	

}
