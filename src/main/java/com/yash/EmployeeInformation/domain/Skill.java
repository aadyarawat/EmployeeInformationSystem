package com.yash.EmployeeInformation.domain;

public class Skill {

	private String skillName;
	private String efficiencyType;
	private int skill_id;
	private int skillefficiency_id;
	private int employeedetails_id;
	
	
	
	public int getEmployeedetails_id() {
		return employeedetails_id;
	}
	public void setEmployeedetails_id(int employeedetails_id) {
		this.employeedetails_id = employeedetails_id;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public int getSkillefficiency_id() {
		return skillefficiency_id;
	}
	public void setSkillefficiency_id(int skillefficiency_id) {
		this.skillefficiency_id = skillefficiency_id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getEfficiencyType() {
		return efficiencyType;
	}
	public void setEfficiencyType(String efficiencyType) {
		this.efficiencyType = efficiencyType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		result = prime * result + skill_id;
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
		Skill other = (Skill) obj;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		if (skill_id != other.skill_id)
			return false;
		return true;
	}
	
	
	
}
