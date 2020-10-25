package com.rowel.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sun.istack.Nullable;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeid")
	private Integer empid;
	@Column(name="employeename")
	@NotNull
	private String ename;
	@NotNull
	private Integer ssn;
	@NotNull
	private String address;
	@NotNull
	private Integer dno;
	@NotNull
	private Double salary;
	@NotNull
	private String sex;
	@Nullable
	private Integer superssn;
	
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empid, String ename, Integer ssn, String address, Integer dno, Double salary,
			String sex, Integer superssn) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.ssn = ssn;
		this.address = address;
		this.dno = dno;
		this.salary = salary;
		this.sex = sex;
		this.superssn = superssn;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", eName=" + ename + ", ssn=" + ssn + ", address=" + address
				+ ", dno=" + dno + ", salary=" + salary + ", sex=" + sex + ", superssn=" + superssn
				+ "]";
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getSuperssn() {
		return superssn;
	}

	public void setSuperssn(Integer superssn) {
		this.superssn = superssn;
	}

	
}
