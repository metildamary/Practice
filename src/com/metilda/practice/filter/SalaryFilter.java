package com.metilda.practice.filter;

import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.Employee;
import com.metilda.practice.EmployeeSalary;

public class SalaryFilter implements Filter{
	
	int salary = 0;

	public SalaryFilter(int salary) {
		super();
		this.salary = salary;
	}

	public List<Employee> applyFilter(List<Employee> employeeList, FilterConditions condition) {
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee emp: employeeList) {
			EmployeeSalary latestEmpSal = emp.getLatestSalary();
			
			//int empSal = emp.getEmpSalList().get(0).getEmpSalary();
			if(latestEmpSal!=null) {
				int empSal = latestEmpSal.getEmpSalary();
				//System.out.println("EmpSalary : " + empSal);
				int empNum = latestEmpSal.getEmpNum();
				//System.out.println("emp Num from salary filter : " + empNum);
				if(condition.equals(FilterConditions.EQUALS)) {
					if(salary ==empSal) {
						empList.add(emp);
					}
				}
				else if(condition.equals(FilterConditions.GREATER)) {
					if(empSal > salary  ) {
						empList.add(emp);
					}
				}
				if(condition.equals(FilterConditions.LESSER)) {
					if(empSal < salary  ) {
						empList.add(emp);
					}
				}
			}
		}
		return empList;
	}
	
	/*use getLatestSalaty  methods in sal filter and dept filter to check for additional conditions like
	add only the employees whose current salary i.e to_date > today date and which meets the Filterconditions*/
	
	

}
