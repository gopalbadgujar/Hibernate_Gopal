package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity    // to map your class to database table
@Table(name ="Subject_of_Student")
@DynamicInsert
@DynamicUpdate
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subId;
	
	@Column(name="subject_Name")
	private String subName;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	@Override
	public String toString() {
		return "Subject ID : "+subId + " , Subject Name : "+ subName;
	}
	
	
	

}
