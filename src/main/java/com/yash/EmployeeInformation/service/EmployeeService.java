
package com.yash.EmployeeInformation.service;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.EmployeeDao;
import com.yash.EmployeeInformation.domain.Address;
import com.yash.EmployeeInformation.domain.Employee;

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

}





   

