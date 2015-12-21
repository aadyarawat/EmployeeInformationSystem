package com.yash.EmployeeInformation.service;


import java.util.List;

import javax.ejb.Local;


import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Skill;

/**
 * 
 * @author aadya.rawat
 *
 */
@Local
public interface EmployeeServiceLocal {

	public String register(Employee employee);
	public int getRegisteredEmpid(String attribute);
	public String saveEmployeeAddress(int recId, Employee employee);
	public List<Skill> getSkillList();
	public List<Skill> getSkillEfficiencyList();
	public String addEmployeeSkillAndEfficiency(int skillNameId, int skillEfficiencyId, int recId);
	public Employee getEmployeeDetail(String emailID);
	public String editEmployeeAddress(int recId, Employee employee);
	public String updateEmployee(Employee employee);
	public List<Skill> getEmployeeSkills(int recId);
	public String deleteEmployeeSkill(int skillId, int efficiencyId, int recId);
}





