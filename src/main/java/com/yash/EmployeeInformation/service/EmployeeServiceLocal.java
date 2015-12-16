package com.yash.EmployeeInformation.service;


import javax.ejb.Local;

import com.yash.EmployeeInformation.domain.Address;
import com.yash.EmployeeInformation.domain.Employee;

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
}





