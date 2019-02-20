package com.capg.employee.beans;

public class Address {

	private String addressLine;
	Country country;
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public Country getCountry() {
		return country;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", country=" + country + "]";
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
