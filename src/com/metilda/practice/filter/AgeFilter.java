package com.metilda.practice.filter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.metilda.practice.Employee;

public class AgeFilter implements Filter {
	
	int age = 0;
	

	public AgeFilter(int age) {
		super();
		this.age = age;
	}

	public List<Employee> applyFilter(List<Employee> employees, FilterConditions condition){ //condition LESSER
		
		List<Employee> empList = new ArrayList<Employee>();
		LocalDate today = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		for(Employee employee : employees) {
			Date birthDate = employee.getBirthDate();
			Instant instant = birthDate.toInstant();
			LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
			Period p = Period.between(localDate, today); // birthdate,todayDate
			int ageInYears = p.getYears();//32
			//System.out.println("ageIn Years " + employee.getBirthDate());
			
			if(condition.equals(FilterConditions.LESSER)) {
				if(ageInYears < age) {
					empList.add(employee);
				}
			} else if (condition.equals(FilterConditions.GREATER)) {
				if(ageInYears > age) {
					empList.add(employee);
				}
				
			} else if(condition.equals(FilterConditions.EQUALS)) {
				if(ageInYears == age) {
					empList.add(employee);
				}
			}
		}
		return empList;
	}

}
