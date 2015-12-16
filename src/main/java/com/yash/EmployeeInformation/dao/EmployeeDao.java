package com.yash.EmployeeInformation.dao;

import com.yash.EmployeeInformation.domain.Employee;

public interface EmployeeDao {
	
	public void getRegister(Employee employee);

	public int getEmpidService(String attribute);

     public	void saveAddressService(int recId, Employee employee);
	

	

}
