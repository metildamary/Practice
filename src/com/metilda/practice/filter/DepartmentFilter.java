package com.metilda.practice.filter;

import java.util.ArrayList;
import java.util.List;

import com.metilda.practice.Employee;
import com.metilda.practice.EmployeeDepartments;
import com.metilda.practice.filter.Filter.FilterConditions;

public class DepartmentFilter implements Filter{
	
	private String deptName = null;
	
	public DepartmentFilter(String deptName) {
		super();
		this.deptName = deptName;
	}
	
	

	public List<Employee> applyFilter(List<Employee> employeeList, FilterConditions condition) {
		List<Employee> empList = new ArrayList<Employee>();
		if(!condition.equals(FilterConditions.EQUALS)) {
			return employeeList;
		}
		for(Employee emp : employeeList) {
			EmployeeDepartments latestEmpDept = emp.getLatestDepartment();
			int empNum =emp.getEmpNum();
			//System.out.println("Employee Num: " + empNum);
			//System.out.println("LatestEmpDept : " + latestEmpDept);
			//System.out.println("DepartName : " + departName);
			//String departName = emp.getEmpdeptList().get(0).getDept().getDeptName();
			if(latestEmpDept!=null) {
				if(condition.equals(FilterConditions.EQUALS)) {
					String departName = latestEmpDept.getDept().getDeptName();
					if(deptName.equals(departName)) {
						empList.add(emp);
					}
				}
			}
		}
		return empList;
	}

}
