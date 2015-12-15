package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.util.List;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;

public interface ManagerDao {

	List<Employee> getAllEmployees(String sql);

	void saveNewProject(Project project);

	String checkAuthorization(String name);
}
