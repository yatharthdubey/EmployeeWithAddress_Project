package com.capg.employee.beans;

public class City {

	private String name;

	public City() {
		super();
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}
	
	
}
