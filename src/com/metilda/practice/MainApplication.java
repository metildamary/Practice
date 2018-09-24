package com.metilda.practice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metilda.practice.filter.AgeFilter;
import com.metilda.practice.filter.DepartmentFilter;
import com.metilda.practice.filter.EmployeeNumberFilter;
import com.metilda.practice.filter.Filter.FilterConditions;
import com.metilda.practice.filter.GenderFilter;
import com.metilda.practice.filter.SalaryFilter;

public class MainApplication {
	
	

	public static void main(String...args) {
		EmployeeManagement empMgt = new EmployeeManagement("C:/Users/Metilda/Downloads/test_db-master");
		empMgt.readCSVFile();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		ArrayList<Employee> empList = empMgt.getEmployees();
		SalaryFilter salFilObj = new SalaryFilter(88958);
		List<Employee> employeeList = salFilObj.applyFilter(empList, FilterConditions.GREATER);
		for(Employee employee : employeeList) {
			System.out.println("Employee Num from Main application : " + employee.getEmpNum()+ "Employee sal : " + employee.getLatestSalary().getEmpSalary() );
		}
		/*DepartmentFilter deptFiltObj = new DepartmentFilter("Development");
		List<Employee> employeeList = deptFiltObj.applyFilter(empList, FilterConditions.EQUALS);
		for(Employee employee : employeeList) {
			System.out.println("Employee Num : " + employee.getEmpNum() );
		}/*
			
		
		/*for(Employee employeeList : empList) {
			System.out.println("FirstName: " + employeeList.getFirstName() + " LastName: " + employeeList.getLastName() + " EmployeeNum: " + employeeList.getEmpNum()
			+ " EmployeeSalary: " + employeeList.getEmpSalList().get(0).getEmpSalary() + " EmployeeDepartmet: " + employeeList.getEmpdeptList().get(0).getDept().getDeptName());
		}*/
		/*AgeFilter ageFilObj = new AgeFilter(40);
		List<Employee> employeeList = ageFilObj.applyFilter(empList, FilterConditions.GREATER);
		for(Employee emp : employeeList) {
			//System.out.println("BirthDate : "+ emp.getBirthDate() + "Name : " + emp.getFirstName() + " "+ emp.getLastName());
			Date birthDate = emp.getBirthDate();
			String formattedBirthDate = formatter.format(birthDate);
			System.out.println("BirthDate : " + formattedBirthDate);
		}*/
		/*for(Employee emp : empList) {
			String firstName =emp.getFirstName();
			String lastName = emp.getLastName();
			System.out.println("Name of the Employee : " +firstName + " " + lastName);
		}
		GenderFilter genFilObj = new GenderFilter("M");
		List<Employee> employeeList = genFilObj.applyFilter(empList, FilterConditions.EQUALS);
		for(Employee emp : employeeList) {
			System.out.println("Gender : " + emp.getGender());
		}
		
		EmployeeNumberFilter empNumObj = new EmployeeNumberFilter(1000);
		List<Employee> employeeList = empNumObj.applyFilter(empList, FilterConditions.GREATER);
		for(Employee emp : employeeList) {
			System.out.println("FirstName: " + emp.getFirstName()+ "LastName: " + emp.getLastName() + "EmpNum: " + emp.getEmpNum());
		}*/
		/*GenderFilter genFilObj = new GenderFilter("M");
		List<Employee> genderEmployeeList = genFilObj.applyFilter(empList, FilterConditions.EQUALS);
		EmployeeNumberFilter empNumObj = new EmployeeNumberFilter(1000);
		List<Employee> EmpNumEmployeeList = empNumObj.applyFilter(genderEmployeeList, FilterConditions.GREATER);*/
		
		
	}
	
	
}
	