package com.yash.EmployeeInformation.dao;

import java.util.List;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Skill;

public interface EmployeeDao {
	
	public void getRegister(Employee employee);

	public int getEmpidService(String attribute);

     public	void saveAddressService(int recId, Employee employee);
	
     public List<Skill> fetchSkill();

 	public List<Skill> fetchSkillEfficiency();

 	public void saveSkillAndEfficiency(String skillName, String skillEfficiency, int recId);
 	
 	public Employee getEmployee(String emailID);

	public void updateEmployeeDetail(Employee employee);

	public void updateEmployeeAddress(int recId, Employee employee);

	

}
