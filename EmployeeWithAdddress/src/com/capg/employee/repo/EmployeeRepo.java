package com.capg.employee.repo;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.capg.employee.beans.Employee;
import com.capg.employee.exceptions.DuplicateEmployeeIdException;

public interface EmployeeRepo {

	Employee save(Employee e) throws DuplicateEmployeeIdException;
	List<Employee> findByName(String name) throws com.capg.employee.exceptions.NameNotFoundException;
	
}
