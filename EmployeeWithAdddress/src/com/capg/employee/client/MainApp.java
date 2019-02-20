package com.capg.employee.client;

import com.capg.employee.beans.Address;
import com.capg.employee.beans.City;
import com.capg.employee.beans.Country;
import com.capg.employee.exceptions.DuplicateEmployeeIdException;
import com.capg.employee.exceptions.NameCannotBeEmptyException;
import com.capg.employee.exceptions.NameNotFoundException;
import com.capg.employee.exceptions.NegativeEmployeeIdException;
import com.capg.employee.exceptions.NoAddressFieldMustBeEmptyException;
import com.capg.employee.repo.EmployeeRepo;
import com.capg.employee.repo.EmployeeRepoImpl;
import com.capg.employee.service.EmployeeService;
import com.capg.employee.service.EmployeeServiceImpl;

public class MainApp {

	public static void main(String[] args) throws NegativeEmployeeIdException, DuplicateEmployeeIdException, NoAddressFieldMustBeEmptyException, NameCannotBeEmptyException, NameNotFoundException {

		EmployeeRepo ar = new EmployeeRepoImpl();
		EmployeeService as = new EmployeeServiceImpl(ar);
		
		City ci = new City();
		ci.setName("Agra");
		
		Country c = new Country();
		c.setName("India");
		c.setCity(ci);
		
		Address a = new Address();
		a.setAddressLine("abc");
		a.setCountry(c);

		as.createEmployee(101, "Yatharth", a);
		
		City ci1 = new City();
		ci1.setName("Agra");
		
		Country c1 = new Country();
		c1.setName("India");
		c1.setCity(ci1);
		
		Address a1 = new Address();
		a1.setAddressLine("abc");
		a1.setCountry(c1);

		as.createEmployee(102, "Yatharth", a1);
			
		System.out.println(as.searchByName("Yatharth"));
	}

}
