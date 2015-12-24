
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
	private EmployeeDao employeeDaoIntf;
	public EmployeeService(){
	}
	@Override
	public String register(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.getRegister(employee);
	}
	@Override
	public int getRegisteredEmpid(String attribute) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.getEmpidService(attribute);
	}
	@Override
	public String saveEmployeeAddress(int recId, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.saveAddressService(recId, employee);
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
	public String addEmployeeSkillAndEfficiency(int skillName, int skillEfficiency, int recId) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.saveSkillAndEfficiency(skillName,skillEfficiency,recId);
	}
	@Override
	public Employee getEmployeeDetail(String emailID) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.getEmployee(emailID);
	}
	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.updateEmployeeDetail(employee);
	}
	@Override
	public String editEmployeeAddress(int recId, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.updateEmployeeAddress(recId,employee);
	}
	@Override
	public List<Skill> getEmployeeSkills(int recId) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.getEmployeeSkills(recId);
	}
	@Override
	public String deleteEmployeeSkill(int skillid, int efficiencyId, int recId) {
		// TODO Auto-generated method stub
		return employeeDaoIntf.deleteEmployeeSkill(skillid,efficiencyId,recId);
	}
}