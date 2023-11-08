package com.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p1")
public class Grocery {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//->variable level annotation.
	@GeneratedValue(strategy = GenerationType.AUTO)//->variable level annotation.
	private int gid;

	@Column(name = "Daily_Products")
	private String gname;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	@Override
	public String toString() {
		return "Grocery [gid=" + gid + ", gname=" + gname + "]";
	}

}
