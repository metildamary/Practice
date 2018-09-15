package com.metilda.practice.filter;

import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.Employee;

public class NameFilter implements Filter {
	
	String name = " ";
	
	public NameFilter(String name) {
		super();
		this.name = name;
	}

	public List<Employee> applyFilter(List<Employee> employee, FilterConditions condition){
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee employeeList : employee) {
			String empName = employeeList.getFirstName();
			if(condition.equals(FilterConditions.EQUALS)) {
				if(empName.equals(name)) {
					empList.add(employeeList);
				}else {
					return employee;
				}
			}
		}
		return empList;
	}

}
