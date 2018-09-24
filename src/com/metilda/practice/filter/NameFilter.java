package com.metilda.practice.filter;

import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.Employee;
import com.metilda.practice.filter.Filter.FilterConditions;

public class NameFilter implements Filter {
	
	String name = " ";
	
	public NameFilter(String name) {
		super();
		this.name = name;
	}

	public List<Employee> applyFilter(List<Employee> employeeList, FilterConditions condition){
		List<Employee> empList = new ArrayList<Employee>();
		if(!condition.equals(FilterConditions.EQUALS)) {
			return employeeList;
		}
		for(Employee employee : employeeList) {
			String empName = employee.getFirstName();
			if(condition.equals(FilterConditions.EQUALS)) {
				if(empName.equals(name)) {
					empList.add(employee);
				}
			}
		}
		return empList;
	}

}
