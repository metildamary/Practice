package com.metilda.practice;
import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.filter.AgeFilter;
import com.metilda.practice.filter.EmployeeNumberFilter;
import com.metilda.practice.filter.Filter.FilterConditions;
import com.metilda.practice.filter.GenderFilter;

public class MainApplication {
	
	

	public static void main(String...args) {
		EmployeeManagement empMgt = new EmployeeManagement("C:/Users/Metilda/Downloads/employees1.csv");
		empMgt.readCSVFile();
		
		ArrayList<Employee> empList = empMgt.getEmployees();
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
		AgeFilter ageFilObj = new AgeFilter(20);
		List<Employee> employeeList = ageFilObj.applyFilter(empList, FilterConditions.LESSER);
		for(Employee emp : employeeList) {
			System.out.println("BirthDate : "+ emp.getBirthDate() + "Name : " + emp.getFirstName() + " "+ emp.getLastName());
		}
		EmployeeNumberFilter empNumObj = new EmployeeNumberFilter(1000);
		List<Employee> employeeList = empNumObj.applyFilter(empList, FilterConditions.GREATER);
		for(Employee emp : employeeList) {
			System.out.println("FirstName: " + emp.getFirstName()+ "LastName: " + emp.getLastName() + "EmpNum: " + emp.getEmpNum());
		}*/
		GenderFilter genFilObj = new GenderFilter("M");
		List<Employee> genderEmployeeList = genFilObj.applyFilter(empList, FilterConditions.EQUALS);
		EmployeeNumberFilter empNumObj = new EmployeeNumberFilter(1000);
		List<Employee> EmpNumEmployeeList = empNumObj.applyFilter(genderEmployeeList, FilterConditions.GREATER);
		
		
	}
}
	//getMaleEmployees()
	//Write a static method in EmployeeManagement to print employee details where the employees are passed as an argument.
	//Write a method to give a list of employees whose joining date later than 1998.


//