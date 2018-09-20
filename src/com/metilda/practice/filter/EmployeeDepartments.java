package com.metilda.practice.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeDepartments {

	private int empNum = 0;
	//private String deptNum = null; // change to deptObj // 
	private Department dept = null;
	private Date fromDate = null;
	private Date toDate = null;
	private static SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
	
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
		
	/*public String getDeptNum() {
			return deptNum;
	}
		
	public void setDeptNum(String deptNum) {
			this.deptNum = deptNum;
	}*/
	
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date empExpInCurrdeptFrom) {
		this.fromDate = empExpInCurrdeptFrom;
	}
	
	public void setFromDate(String empExpInCurrdeptFrom) {
		Date date = new Date();
		try {
			date = formatter.parse(empExpInCurrdeptFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fromDate = date;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date empExpInCurrdeptTo) {
		this.toDate = empExpInCurrdeptTo;
	}
	
	public void setToDate(String empExpInCurrdeptTo) {
		Date date = new Date();
		try {
			date = formatter.parse(empExpInCurrdeptTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.toDate = date;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	} 
	
}
