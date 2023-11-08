package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(query = "from Employee", name = "AllEmployeeData"),
	@NamedQuery(query = "from Employee where eid =: id", name = "SingleEmployeeData"),
	@NamedQuery(query = "select max(esalary) from Employee" ,  name = "maxEmployeeSalary"),
	@NamedQuery(query = "select min(esalary) from Employee" ,  name = "minEmployeeSalary"),
	@NamedQuery(query = "select avg(esalary) from Employee" ,  name = "avgEmployeeSalary"),
	@NamedQuery(query = "select count(esalary) from Employee" ,  name = "countEmployeeSalary"),
	@NamedQuery(query = "from Employee where ename like :name", name = "employeeNameStartsFrom"),
	@NamedQuery(query = "from Employee where ename like 'm%'", name = "searchNameLike"),

})

@NamedNativeQueries({
	@NamedNativeQuery(query = "select * from employee ", name = "AllEmployees", resultClass = Employee.class)
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	private String ename;
	
	private double esalary;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
	}	
}
