package com.yash.EmployeeInformation.dao;

import java.util.List;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Skill;

public interface EmployeeDao {
	
	public String getRegister(Employee employee);

	public int getEmpidService(String attribute);

     public	String saveAddressService(int recId, Employee employee);
	
     public List<Skill> fetchSkill();

 	public List<Skill> fetchSkillEfficiency();

 	public String saveSkillAndEfficiency(int skillName, int skillEfficiency, int recId);
 	
 	public Employee getEmployee(String emailID);

	public String updateEmployeeDetail(Employee employee);

	public String updateEmployeeAddress(int recId, Employee employee);

	public List<Skill> getEmployeeSkills(int recId);

	public String deleteEmployeeSkill(int skillid, int efficiencyId, int recId);

	

}
