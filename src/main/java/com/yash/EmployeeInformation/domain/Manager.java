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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((managerEmailId == null) ? 0 : managerEmailId.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (managerEmailId == null) {
			if (other.managerEmailId != null)
				return false;
		} else if (!managerEmailId.equals(other.managerEmailId))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerEmailId=" + managerEmailId
				+ ", role=" + role + "]";
	}

	
	
}
