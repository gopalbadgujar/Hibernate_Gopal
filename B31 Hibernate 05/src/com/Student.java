package com;

public class Student {

	private int sid;
	
	private String sname;
	
	private String address;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + "]";
	}

	public Student(int sid, String sname, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
	}
	
	
}
