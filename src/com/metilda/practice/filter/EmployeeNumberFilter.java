package com.metilda.practice.filter;

import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.Employee;

public class EmployeeNumberFilter implements Filter {

	int empNum = 0;
	
	public EmployeeNumberFilter(int empNum) {
		super();
		this.empNum = empNum;
	}

	public List<Employee> applyFilter(List<Employee> employees, FilterConditions condition){
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee emp : employees) {
			int employeeNumber = emp.getEmpNum();
			if(condition.equals(FilterConditions.EQUALS)) {
				if(employeeNumber == empNum) {
					empList.add(emp);
				}
			}if(condition.equals(FilterConditions.GREATER)) {
				if(employeeNumber > empNum) {
					empList.add(emp);
				}
			}if(condition.equals(FilterConditions.LESSER)) {
				if(employeeNumber < empNum) {
					empList.add(emp);
				}
			}
		}
		return empList;
	}
}
