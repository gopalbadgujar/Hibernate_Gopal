package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	private String cname;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Engine engine; // instance of Engine in the Car

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + ", engine=" + engine + "]";
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
