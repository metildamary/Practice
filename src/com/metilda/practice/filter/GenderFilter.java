package com.metilda.practice.filter;

import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.Employee;

public class GenderFilter implements Filter {
	
	String gender = null;
	
	public GenderFilter(String gender) {
		super();
		this.gender = gender;
	}

	public List<Employee> applyFilter(List<Employee> employeeList, FilterConditions condition){
		List<Employee> empList = new ArrayList<Employee>();
		if(!condition.equals(FilterConditions.EQUALS)) {
			return employeeList;
		}
		for(Employee emp : employeeList) {
			String empGender = emp.getGender();
			if(condition.equals(FilterConditions.EQUALS)) {
				if(empGender.equals(gender)) {
					empList.add(emp);
				}
			}	
		}
		return employeeList;
	} 

}


// emp sal,dept, will be separate csv file. can put in same folder or anywhere // reading all the files have to print all the details of employee
//including sal,dept,genfer and so and so. With existing filters get corresponding details of the employee
