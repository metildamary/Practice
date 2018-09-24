package com.metilda.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Employee {
	
	private int empNum = 0;
	private Date birthDate = null;
	private String firstName = null;
	private String lastName = null;
	private String gender = null;
	private Date hireDate = null;
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



/* create getLatestSalary and getLatestDepartment methods in EMployee class
with condition if the emp to date is > today return that salary and department
use these methods in sal filter and dept filter to check for additional conditions like
add only the employees whose current salary i.e to_date > today date and which meets the Filterconditions
*/
	public EmployeeSalary getLatestSalary() {
		EmployeeSalary employeeSal = null;
		Date today = new Date();
		for(EmployeeSalary empSal : empSalList) {//empNum,empSal,empfromDate,empToDate
			Date toDate = empSal.getToDate();
			if(toDate.after(today)) {
				employeeSal = empSal;
			}
		}
		return employeeSal;
	}
	
	public EmployeeDepartments getLatestDepartment() {
		EmployeeDepartments employeeDept = null;
		Date today = new Date();
		for(EmployeeDepartments empDept : empDeptList ) {
			Date toDate = empDept.getToDate();
			if(toDate.after(today)) {
				employeeDept =  empDept;
			}
		}
		return employeeDept;
	}
}





