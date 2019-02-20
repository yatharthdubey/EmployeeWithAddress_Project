package com.capg.employee.beans;

public class Country {

	private String name;
	City city;
	
	public String getName() {
		return name;
	}
	public Country() {
		super();
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", city=" + city + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
}
