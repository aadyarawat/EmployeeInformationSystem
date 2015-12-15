package com.yash.EmployeeInformation.domain;

public class Address {
	private int address_id;
	private int houseNo;
	private String streetName;
	private String city;
	private String state;
	private String pincode;
	private int employeedetails_id;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getEmployeedetails_id() {
		return employeedetails_id;
	}
	public void setEmployeedetails_id(int employeedetails_id) {
		this.employeedetails_id = employeedetails_id;
	}
	
	
	
}
