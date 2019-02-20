package com.capg.employee.service;

import java.util.List;

import com.capg.employee.beans.Address;
import com.capg.employee.beans.Employee;
import com.capg.employee.exceptions.DuplicateEmployeeIdException;
import com.capg.employee.exceptions.NameCannotBeEmptyException;
import com.capg.employee.exceptions.NameNotFoundException;
import com.capg.employee.exceptions.NegativeEmployeeIdException;
import com.capg.employee.exceptions.NoAddressFieldMustBeEmptyException;

public interface EmployeeService {

	Employee createEmployee(int id,String name, Address address) throws NegativeEmployeeIdException, DuplicateEmployeeIdException,NoAddressFieldMustBeEmptyException,NameCannotBeEmptyException;
	
	List<Employee> searchByName(String name) throws NameNotFoundException,NameCannotBeEmptyException;
	
}
