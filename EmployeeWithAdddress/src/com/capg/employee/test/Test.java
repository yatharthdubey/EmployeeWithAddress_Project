package com.capg.employee.test;

import com.capg.employee.beans.Address;
import com.capg.employee.beans.City;
import com.capg.employee.beans.Country;
import com.capg.employee.exceptions.DuplicateEmployeeIdException;
import com.capg.employee.exceptions.NameCannotBeEmptyException;
import com.capg.employee.exceptions.NameNotFoundException;
import com.capg.employee.exceptions.NegativeEmployeeIdException;
import com.capg.employee.exceptions.NoAddressFieldMustBeEmptyException;
import com.capg.employee.repo.EmployeeRepoImpl;
import com.capg.employee.service.EmployeeService;
import com.capg.employee.service.EmployeeServiceImpl;

public class Test {

	EmployeeService as = new EmployeeServiceImpl(new EmployeeRepoImpl());
	
	@org.junit.Test
	public void whenEmployeeCreatedSuccessfully() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException {
		City ci = new City();
		ci.setName("Agra");
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);
		as.createEmployee(101, "Yatharth", a);
	}
	
	@org.junit.Test(expected = NegativeEmployeeIdException.class)
	public void whenNegativeIdPassedThenNegativeEmployeeIdExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException {
		City ci = new City();
		ci.setName("Agra");
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);
		as.createEmployee(-101, "Yatharth", a);
	}
	
	@org.junit.Test(expected =DuplicateEmployeeIdException.class )
	public void whenIdPasedFoundToBeDuplicateThenDuplicateEmployeeIdExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException {
		City ci = new City();
		ci.setName("Agra");
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);
		as.createEmployee(101, "Yatharth", a);
		as.createEmployee(101, "Yatharth", a);
	}
	
	@org.junit.Test(expected = NameCannotBeEmptyException.class )
	public void whenNameIsPassedEmptyOrNullDuringEmployeeCreationThenNameCannotBeEmptyExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException {
		City ci = new City();
		ci.setName("Agra");
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);
		as.createEmployee(101, null, a);
	}
	@org.junit.Test(expected = NoAddressFieldMustBeEmptyException.class )
	public void whenAddressObjectIsPassedToBeNullThenNoAddressFieldMustBeEmptyExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException {
		Address a = null;
		as.createEmployee(101, "Yatharth", a);

	}

	
	@org.junit.Test(expected = NoAddressFieldMustBeEmptyException.class )
	public void whenAnyAddressFieldIsPassedToBeNullThenNoAddressFieldMustBeEmptyExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException {
		City ci = new City();
//		ci.setName(null);
		Country c = new Country();
//		c.setName(null);
		c.setCity(ci);
		Address a = null;
//		Address a = new Address();
//		a.setAddressLine(null);
//		a.setCountry(c);
		as.createEmployee(101, "Yatharth", a);
	}
	@org.junit.Test(expected = NameCannotBeEmptyException.class )
	public void whenNameIsPassedEmptyOrNullDuringSearchEmployeeByNameThenNameCannotBeEmptyExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException, NameNotFoundException {
		City ci = new City();
		ci.setName("Agra");
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);
		as.createEmployee(101, "Yatharth", a);
		as.searchByName(null);
	}
	@org.junit.Test(expected = NameNotFoundException.class )
	public void whenNameIsPassedButItDoesNotExistInStorageThenNameNotExceptionOccurs() throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException, NameNotFoundException {
		City ci = new City();
		ci.setName("Agra");
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);
		as.createEmployee(101, "Yatharth", a);
		as.searchByName("Dubey");
	}
}
