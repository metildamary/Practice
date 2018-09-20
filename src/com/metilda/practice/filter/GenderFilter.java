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

	public List<Employee> applyFilter(List<Employee> employee, FilterConditions condition){
		List<Employee> employeeList = new ArrayList<Employee>();
		for(Employee empList : employee) {
			String empGender = empList.getGender();
			if(condition.equals(FilterConditions.EQUALS)) {
				if(empGender.equals(gender)) {
					employeeList.add(empList);
				}
			}else {
				return employee;
			}
				
		}
		return employeeList;
	} 

}


// emp sal,dept, will be separate csv file. can put in same folder or anywhere // reading all the files have to print all the details of employee
//including sal,dept,genfer and so and so. With existing filters get corresponding details of the employee
