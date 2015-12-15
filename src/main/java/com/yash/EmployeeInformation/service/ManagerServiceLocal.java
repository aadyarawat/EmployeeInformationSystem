package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;

@Local
public interface ManagerServiceLocal {

	List<Employee> getAllEmployees();

	List<Employee> searchEmployeeByName(String searchValueText);
	
	void createNewProject(Project project);

}
