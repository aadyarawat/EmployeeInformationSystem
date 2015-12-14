package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.EmployeeInformation.domain.Employee;

@Local
public interface EmployeeServiceLocal {

	List<Employee> getAllEmployees();

	List<Employee> searchEmployeeByName(String searchValueText);

}
