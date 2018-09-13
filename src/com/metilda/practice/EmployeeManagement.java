package com.metilda.practice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class EmployeeManagement {
	
	private String fileName;
	private CSVParser parser;
	private ArrayList<Employee> emp = new ArrayList<Employee>();
	
	public EmployeeManagement(String fileName) {
		this.fileName = fileName;
	}
	
	public void readCSVFile() {
		
		File file = new File(fileName);
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			parser = new CSVParser(bf,CSVFormat.DEFAULT.withHeader("emp_no","birth_date","first_name","last_name","gender","hire_date").withIgnoreHeaderCase().withTrim());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int line = 0; 
		for(CSVRecord record: parser) {
			if(line == 0) {
				line = 1;
				continue;
			}
			String empNum = record.get("emp_no");
			String birthDate = record.get("birth_date");
			String firstName = record.get("first_name");
			String lastName = record.get("last_name");
			String gender = record.get("gender");
			String hireDate = record.get("hire_date"); //10-02-198
			Employee empObj = new Employee(empNum,birthDate,firstName,lastName,gender,hireDate);
			emp.add(empObj);
			}
	}
	
	public ArrayList<Employee> getEmployees(){
		return emp;
	}
	
	//getMaleEmployees()
	public ArrayList<Employee> getMaleEmployees(){
		
		ArrayList<Employee> maleEmp = new ArrayList<Employee>();
		readCSVFile();
		ArrayList<Employee> empList = getEmployees();
		for(Employee emp : empList) {
			String gender = emp.getGender();
			if(gender.equals("M")) {
				maleEmp.add(emp);
			}
		}
		return maleEmp;
	}
	
	//Write a static method in EmployeeManagement to print employee details where the employees are passed as an argument.
		
	public static void printEmployeeDetails(Employee employee) {
		EmployeeManagement empMgt = new EmployeeManagement(null);
		ArrayList<Employee> empList = empMgt.getEmployees();
		for(Employee emp : empList) {
			if(emp.equals(employee)) {
				String empNum = emp.getEmpNum();
				String birthDate = emp.getBirthDate();
				String firstName = emp.getFirstName();
				String lastName = emp.getLastName();
				String gender = emp.getGender();
				String hireDate = emp.getHireDate();
				
				System.out.println("EmpNum : " + empNum);
				System.out.println("Birth Date : " + birthDate);
				System.out.println("First Name : "+ firstName);
				System.out.println("Last Name : "+ lastName);
				System.out.println("Gender: " + gender);
				System.out.println("Hire Date : "+ hireDate);
			}
		}
		
	}	
	
	//Write a method to give a list of employees whose joining date later than 1998.
	public ArrayList<Employee> getEmployeeJoinedLater(int year){
		ArrayList<Employee> empList =new ArrayList<Employee>();
		for(Employee employee : emp) {
			String hireDate = employee.getHireDate(); 
			String[] hireDateArr = hireDate.split("-");
			String yearStr = hireDateArr[0];
			int yearInt = Integer.parseInt(yearStr);
			if(yearInt > year) {
				empList.add(employee);
			}
		}
		return empList;
	}
		
}
	
	
	
	
	
	
	

