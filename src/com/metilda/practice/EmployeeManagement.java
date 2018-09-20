package com.metilda.practice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.metilda.practice.filter.Department;
import com.metilda.practice.filter.EmployeeDepartments;
import com.metilda.practice.filter.EmployeeSalary;
import com.metilda.practice.filter.EmployeeTitle;

public class EmployeeManagement {
	
	private String pathName;
	private CSVParser parser;
	//private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	// create HashMap with key employee ID and value employee
	private HashMap<Integer,Employee> empMap = new HashMap<Integer,Employee>(); // key- empNum,value-empObj
	private HashMap<String,Department> deptMap = new HashMap<String,Department>(); //key-deptNum,value-deptObj
	
	public EmployeeManagement(String pathName) {
		this.pathName = pathName;
		readCSVFile();
	}
	
	public void readCSVFile() {
		readEmployeeCSVFile();
		readDepartmentCSVFile();
		readEmployeeDepartmentCSVFile();
		readEmployeeSalaryCSVFile();
		readEmployeeTitleCSVFile();
	}
	
	private void readDepartmentCSVFile() {
		File file = new File(pathName + "/"+ "departments.csv");
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			parser = new CSVParser(bf, CSVFormat.DEFAULT.withHeader("dept_no","dept_name").withIgnoreHeaderCase().withTrim());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int line = 0;
		for(CSVRecord record : parser) {
			if(line == 0) {
				line = 1;
				continue;
			}
			String deptNum = record.get("dept_no");
			String deptName = record.get("dept_name");
			Department deptObj = new Department();
			deptObj.setDeptNum(deptNum);
			deptObj.setDeptName(deptName);
			deptMap.put(deptNum,deptObj);
		}
	}
	
	private void readEmployeeCSVFile() {
		File file = new File(pathName+"/"+"employees.csv");
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			try {
				parser = new CSVParser(bf,CSVFormat.DEFAULT.withHeader("emp_no","birth_date","first_name","last_name","gender","hire_date").withIgnoreHeaderCase().withTrim());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int line= 0;
		for(CSVRecord record: parser) {
			if(line==0) {
				line = 1;
				continue;
			}
			int empNum = Integer.parseInt(record.get("emp_no"));
			String birthDate = record.get("birth_date");
			String firstName = record.get("first_name");
			String lastName = record.get("last_name");
			String gender = record.get("gender");
			String hireDate = record.get("hire_date");
			Employee empObj = new Employee();
			empObj.setBirthDate(birthDate);
			empObj.setFirstName(firstName);
			empObj.setLastName(lastName);
			empObj.setGender(gender);
			empObj.setHireDate(hireDate);
			empMap.put(empNum, empObj);
		}
	}
	
	private void readEmployeeDepartmentCSVFile() {
		File file = new File(pathName+"/"+"employee_departments.csv");
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			try {
				parser = new CSVParser(bf,CSVFormat.DEFAULT.withHeader("emp_no","dept_no","from_date"+"to_date").withIgnoreHeaderCase().withTrim());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int line= 0;
		for(CSVRecord record : parser) {
			if(line == 0) {
				line = 1;
				continue;
			}
			String empNum = record.get("emp_no");
			String deptNum = record.get("dept_no");
			String empExpInCurrdeptFrom = record.get("from_date");
			String empExpInCurrdeptTo = record.get("to_date");
			EmployeeDepartments empDeptsObj = new EmployeeDepartments();
			empDeptsObj.setEmpNum(empNum);
			//empDeptsObj.setDeptNum(deptNum);
			Department dept = deptMap.get(deptNum);
			empDeptsObj.setDept(dept);
			empDeptsObj.setFromDate(empExpInCurrdeptFrom);
			empDeptsObj.setToDate(empExpInCurrdeptTo);
			Employee emp = empMap.get(empNum);
			ArrayList<EmployeeDepartments> empDeptList= emp.getEmpdeptList();
			empDeptList.add(empDeptsObj);
		}
	}
	
	private void readEmployeeSalaryCSVFile() {
		File file = new File(pathName+"/"+"salaries");
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			parser = new CSVParser(bf,CSVFormat.DEFAULT.withHeader("emp_no","salary","from_date","to_date"));
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (IOException e) {
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
			String salary = record.get("salary");
			String fromDate = record.get("from_date");
			String toDate = record.get("to_date");
			EmployeeSalary empSal = new EmployeeSalary();
			empSal.setEmpNum(empNum);
			empSal.setEmpSalary(salary);
			empSal.setFromDate(fromDate);
			empSal.setToDate(toDate);
			Employee emp = empMap.get(empNum);
			ArrayList<EmployeeSalary> empSalList = emp.getEmpSalList();
			empSalList.add(empSal);
		}
	}
	
	private void readEmployeeTitleCSVFile() {
		File file = new File(pathName+"/"+"titles");
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);
			parser = new CSVParser(bf,CSVFormat.DEFAULT.withHeader("emp_no","title","from_date","to_date"));
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (IOException e) {
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
			String title = record.get("title");
			String fromDate = record.get("from_date");
			String toDate = record.get("to_date");
			EmployeeTitle empTitle = new EmployeeTitle();
			empTitle.setEmpNum(empNum);
			empTitle.setEmpTitle(title);
			empTitle.setFromDate(fromDate);
			empTitle.setToDate(toDate);
			Employee emp = empMap.get(empNum);
			ArrayList<EmployeeTitle> empTitleList = emp.getEmpTitleList();
			empTitleList.add(empTitle);
		}
	}
	
	public ArrayList<Employee> getEmployees(){
		ArrayList<Employee> employeeList = new ArrayList<>(empMap.values());
		return employeeList;
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
		
	public static void printEmployeeDetails(ArrayList<Employee> employee) {
	
		for(Employee emp : employee) {
				int empNum = emp.getEmpNum();
				Date birthDate = emp.getBirthDate();
				String firstName = emp.getFirstName();
				String lastName = emp.getLastName();
				String gender = emp.getGender();
				Date hireDate = emp.getHireDate();
				
				System.out.println("EmpNum : " + empNum);
				System.out.println("Birth Date : " + birthDate);
				System.out.println("First Name : "+ firstName);
				System.out.println("Last Name : "+ lastName);
				System.out.println("Gender: " + gender);
				System.out.println("Hire Date : "+ hireDate);
		}
	}	
	
	//Write a method to give a list of employees whose joining date later than 1998.
	public ArrayList<Employee> getEmployeeJoinedLater(int year){
		ArrayList<Employee> empList =new ArrayList<Employee>();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		for(Employee employee : empMap.values()) {
			Date hireDate = employee.getHireDate(); 
			String dateToString = formatter.format(hireDate);
			String[] hireDateArr = dateToString.split("-");
			String yearStr = hireDateArr[0];
			int yearInt = Integer.parseInt(yearStr);
			if(yearInt > year) {
				empList.add(employee);
			}
		}
		return empList;
	}
		
}
/*public enum FilterCondition{EQUALS, GREATER, LESSER}*/
// filter condition class (
	
	// apply filter(employee,birthday,filter condition) --> declare enum inside the interface
//
	
	
	
	
	

