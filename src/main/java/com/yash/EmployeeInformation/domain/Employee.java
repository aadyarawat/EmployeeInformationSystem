package com.yash.EmployeeInformation.domain;

import java.util.List;

public class Employee {
	private int employeedetails_id;
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private String mobile;
	private String alternate_mobile;
	private List<Project> projects;
	private BaseLineInput baseLineInput;
	private FeedBack feedBack;
	private List<Skill> skills;
	
	
	
	public int getEmployeedetails_id() {
		return employeedetails_id;
	}

	public void setEmployeedetails_id(int employeedetails_id) {
		this.employeedetails_id = employeedetails_id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlternate_mobile() {
		return alternate_mobile;
	}

	public void setAlternate_mobile(String alternate_mobile) {
		this.alternate_mobile = alternate_mobile;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public BaseLineInput getBaseLineInput() {
		return baseLineInput;
	}

	public void setBaseLineInput(BaseLineInput baseLineInput) {
		this.baseLineInput = baseLineInput;
	}

	public FeedBack getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
	
}
