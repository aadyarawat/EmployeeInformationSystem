
package com.yash.EmployeeInformation.service;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.EmployeeDao;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Skill;

/**
 * 
 * @author aadya.rawat
 *
 */
@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceLocal {

	@Inject
	EmployeeDao employeeDaoIntf;
	
	public EmployeeService(){
	}
	@Override
	public void register(Employee employee) {
		employeeDaoIntf.getRegister(employee);
		
	}
	@Override
	public int getRegisteredEmpid(String attribute) {
		return employeeDaoIntf.getEmpidService(attribute);
		
	}
	
	@Override
	public void saveEmployeeAddress(int recId, Employee employee) {
		employeeDaoIntf.saveAddressService(recId, employee);
	}
	@Override
	public List<Skill> getSkillList() {
		// TODO Auto-generated method stub
		return employeeDaoIntf.fetchSkill();
		
	}
	@Override
	public List<Skill> getSkillEfficiencyList() {
		// TODO Auto-generated method stub
		return employeeDaoIntf.fetchSkillEfficiency();
		
	}
	@Override
	public void addEmployeeSkillAndEfficiency(String skillName, String skillEfficiency, int recId) {
		employeeDaoIntf.saveSkillAndEfficiency(skillName,skillEfficiency,recId);
		
	}
	@Override
	public Employee getEmployeeDetail(String emailID) {
		return employeeDaoIntf.getEmployee(emailID);
		
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeDaoIntf.updateEmployeeDetail(employee);
		
	}
	@Override
	public void editEmployeeAddress(int recId, Employee employee) {
		employeeDaoIntf.updateEmployeeAddress(recId,employee);
	}

}





   

