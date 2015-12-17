package com.yash.EmployeeInformation.domain;

public class Skill {

	private String skillName;
	private String efficiencyType;
	private int skill_id;
	private int skillefficiency_id;
	
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
	
	
	
}
