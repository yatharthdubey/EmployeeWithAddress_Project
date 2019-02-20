package com.capg.employee.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.NameNotFoundException;

import com.capg.employee.beans.Employee;
import com.capg.employee.exceptions.DuplicateEmployeeIdException;

public class EmployeeRepoImpl implements EmployeeRepo {

	
	HashMap<Integer, Employee> hm = new HashMap<>();

	@Override
	public Employee save(Employee e) throws DuplicateEmployeeIdException{
		
		if(hm.containsKey(e.getId())) {
			throw new DuplicateEmployeeIdException();

		}
		hm.put(e.getId(), e);
		return e;
	}

	@Override
	public List<Employee> findByName(String name) throws com.capg.employee.exceptions.NameNotFoundException {
		
		List<Employee> l = new ArrayList<>();
		hm.forEach((k, v) -> {
				if(name.equals(v.getName()))
				l.add(v);
		});
		if(l.size()==0)
			throw new com.capg.employee.exceptions.NameNotFoundException();
		return l;
		
		
	}

}
