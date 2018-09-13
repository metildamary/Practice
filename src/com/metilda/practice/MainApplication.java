package com.metilda.practice;
import java.util.ArrayList;

public class MainApplication {
	
	public static void main(String...args) {
		EmployeeManagement empMgt = new EmployeeManagement("C:/Users/Metilda/Downloads/employees1.csv");
		empMgt.readCSVFile();
		ArrayList<Employee> empList = empMgt.getEmployees();
		for(Employee emp : empList) {
			String firstName =emp.getFirstName();
			String lastName = emp.getLastName();
			System.out.println("Name of the Employee : " +firstName + " " + lastName);
		}
	}
	
	//getMaleEmployees()
	//Write a static method in EmployeeManagement to print employee details where the employees are passed as an argument.
	//Write a method to give a list of employees whose joining date later than 1998.
}
