package com.yash.EmployeeInformation.domain;

public class Role {
	int role_id;
	String roleType;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", roleType=" + roleType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleType == null) ? 0 : roleType.hashCode());
		result = prime * result + role_id;
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
		Role other = (Role) obj;
		if (roleType == null) {
			if (other.roleType != null)
				return false;
		} else if (!roleType.equals(other.roleType))
			return false;
		if (role_id != other.role_id)
			return false;
		return true;
	}
	
	
}
