package com.metilda.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeSalary {
	
	private int empNum = 0;
	private int empSalary = 0;
	private Date fromDate = null;
	private Date toDate = null;
	SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
	
	public int getEmpNum() {
		return empNum;
	}
	
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	
	public void setEmpNum(String empNum) {
		this.empNum = Integer.parseInt(empNum);
	}
	
	public int getEmpSalary() {
		return empSalary;
	}
	
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	public void setEmpSalary(String empSalary) {
		this.empSalary = Integer.parseInt(empSalary);
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public void setFromDate(String fromDate) {
		Date date = new Date();
		try {
			date = formatter.parse(fromDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fromDate = date;
	}
	
	public Date getToDate() {
		return toDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public void setToDate(String toDate) {
		Date date = new Date();
		try {
			date = formatter.parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.toDate = date;
	}

}
