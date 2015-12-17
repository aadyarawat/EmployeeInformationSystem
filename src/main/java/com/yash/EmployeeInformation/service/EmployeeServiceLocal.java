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

	public void register(Employee employee);
	public int getRegisteredEmpid(String attribute);
	public void saveEmployeeAddress(int recId, Employee employee);
	public List<Skill> getSkillList();
	public List<Skill> getSkillEfficiencyList();
	public void addEmployeeSkillAndEfficiency(String skillName, String skillEfficiency, int recId);
	public Employee getEmployeeDetail(String emailID);
	public void editEmployeeAddress(int recId, Employee employee);
	public void updateEmployee(Employee employee);
}





