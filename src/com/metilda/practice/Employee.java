package com.metilda.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.metilda.practice.filter.EmployeeDepartments;
import com.metilda.practice.filter.EmployeeSalary;
import com.metilda.practice.filter.EmployeeTitle;

public class Employee {
	
	private int empNum = 0;
	private Date birthDate = null;
	private String firstName = null;
	private String lastName = null;
	private String gender = null;
	private Date hireDate = null;
	private int salary = 0;
	private Date empSalFrom = null;
	private Date empSalTo = null;
	private String empTitle = null;
	private Date empTitleFrom = null;
	private Date empTitleTo = null;
	private static SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
	private ArrayList<EmployeeDepartments> empDeptList = new ArrayList<EmployeeDepartments>();
	private ArrayList<EmployeeSalary> empSalList = new ArrayList<EmployeeSalary>();
	private ArrayList<EmployeeTitle> empTitleList = new ArrayList<EmployeeTitle>();
	
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
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
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
		Date date = new Date();
		try {
			date = formatter.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hireDate = date;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setSalary(String salary) {
		this.salary = Integer.parseInt(salary);
	}


	public Date getEmpSalFrom() {
		return empSalFrom;
	}

	public void setEmpSalFrom(Date empSalFrom) {
		this.empSalFrom = empSalFrom;
	}
	
	public void setEmpSalFrom(String empSalFrom) {
		Date date = new Date();
		try {
			date = formatter.parse(empSalFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.empSalFrom = date;
	}

	public Date getEmpSalTo() {
		return empSalTo;
	}

	public void setEmpSalTo(Date empSalTo) {
		this.empSalTo = empSalTo;
	}

	public void setEmpSalTo(String empSalTo) {
		Date date = new Date();
		try {
			date = formatter.parse(empSalTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.empSalTo = date;
	}
	
	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public Date getEmpTitleFrom() {
		return empTitleFrom;
	}

	public void setEmpTitleFrom(Date empTitleFrom) {
		this.empTitleFrom = empTitleFrom;
	}
	
	public void setEmpTitleFrom(String empTitleFrom) {
		Date date = new Date();
		try {
			date = formatter.parse(empTitleFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.empTitleFrom = date;
	}

	public Date getEmpTitleTo() {
		return empTitleTo;
	}

	public void setEmpTitleTo(Date empTitleTo) {
		this.empTitleTo = empTitleTo;
	}
	
	public void setEmpTitleTo(String empTitleTo) {
		Date date = new Date();
		try {
			date = formatter.parse(empTitleTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.empTitleTo = date;
	}

	public ArrayList<EmployeeDepartments> getEmpdeptList() {
		return empDeptList;
	}

	public void setEmpdeptList(ArrayList<EmployeeDepartments> empdeptList) {
		this.empDeptList = empdeptList;
	}

	public ArrayList<EmployeeSalary> getEmpSalList() {
		return empSalList;
	}

	public void setEmpSalList(ArrayList<EmployeeSalary> empSalList) {
		this.empSalList = empSalList;
	}

	public ArrayList<EmployeeTitle> getEmpTitleList() {
		return empTitleList;
	}

	public void setEmpTitleList(ArrayList<EmployeeTitle> empTitleList) {
		this.empTitleList = empTitleList;
	}

}

/*Iterate employee list and save the details in haspMap(employee ID , employee)
 * create dept filter ,title filter and salary filter
 * create instance variable and getter setter for dept,title,salary
 * */
