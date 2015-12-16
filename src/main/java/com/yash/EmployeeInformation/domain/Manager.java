package com.yash.EmployeeInformation.domain;

public class Manager {
	private int managerId;
	private String managerName;
	private String managerEmailId;
	private int role;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmailId() {
		return managerEmailId;
	}
	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerEmailId=" + managerEmailId
				+ ", role=" + role + "]";
	}
	
}
