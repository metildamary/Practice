package com.metilda.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	
	private int empNum = 0;
	private Date birthDate = null;
	private String firstName = null;
	private String lastName = null;
	private String gender = null;
	private Date hireDate = null;
	private static SimpleDateFormat formatter;
	
	public Employee() {
		
	}
	
	public Employee(int empNum, Date birthDate, String firstName, String lastName, String gender,
			Date hireDate) {
		super();
		this.empNum = empNum;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}
	
	public Employee(String empNum, String birthDate, String firstName, String lastName, String gender,
			String hireDate) {
		//call the changed methods and set it to the instance variable
		setEmpNum(empNum);
		setBirthDate(birthDate);
		setHireDate(hireDate);
	}
	//create new methods for setEmpNum accepting int parameter
	
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		int employeeNum = Integer.parseInt(empNum);
		this.empNum = employeeNum;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
	    formatter = new SimpleDateFormat("DD-MM-YYYY");
		Date date = new Date();
		try {
			 date = formatter.parse(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.birthDate = date;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		formatter = new SimpleDateFormat("DD-MM-YYYY");
		Date date = new Date();
		try {
			date = formatter.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hireDate = date;
	}
	
	

}
