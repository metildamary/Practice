package com.metilda.practice.filter;


import java.util.Date;
import java.util.List;

import com.metilda.practice.Employee;

public interface Filter {
	
	enum FilterConditions {EQUALS, GREATER, LESSER}
	
	public List<Employee> applyFilter(List<Employee> employee, FilterConditions condition );

}


// NameFilter
//AgeFilter
/*GenderFilter*/