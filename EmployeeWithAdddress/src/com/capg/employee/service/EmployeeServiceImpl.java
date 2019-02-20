package com.capg.employee.service;

import java.util.List;

import com.capg.employee.beans.Address;
import com.capg.employee.beans.Employee;
import com.capg.employee.exceptions.DuplicateEmployeeIdException;
import com.capg.employee.exceptions.NameCannotBeEmptyException;
import com.capg.employee.exceptions.NameNotFoundException;
import com.capg.employee.exceptions.NegativeEmployeeIdException;
import com.capg.employee.exceptions.NoAddressFieldMustBeEmptyException;
import com.capg.employee.repo.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeRepo employeeRepo;

	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee createEmployee(int id,String name, Address address) throws NegativeEmployeeIdException, DuplicateEmployeeIdException,NoAddressFieldMustBeEmptyException,NameCannotBeEmptyException{

		if(id<0) {
			throw new NegativeEmployeeIdException();
		}
		else if (name ==null || name.equals("")) {
			throw new NameCannotBeEmptyException();
		}
		else if(address == null || address.getAddressLine()==null || address.getCountry().getName()==null||address.getCountry().getCity().getName()==null) {
			throw new NoAddressFieldMustBeEmptyException();
		}
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setAddress(address);
		employeeRepo.save(emp);
		return emp;
	}

	@Override
	public List<Employee> searchByName(String name) throws NameNotFoundException,NameCannotBeEmptyException {
	
		if(name==null || name.equals(""))
			throw new NameCannotBeEmptyException();
		List<Employee> l= employeeRepo.findByName(name);
		return l;
				
	}

}
