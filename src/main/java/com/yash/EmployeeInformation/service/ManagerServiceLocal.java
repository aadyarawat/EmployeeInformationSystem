package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;

@Local
public interface ManagerServiceLocal {

	List<Employee> getAllEmployees();

	List<Employee> searchEmployeeByName(String searchValueText);

	void createNewProject(Project project);

	Manager checkAuthorization(String name);

	List<Project> getAllProjects();

	void allocateProject(int projectDetails_Id, int employeedetails_id);

	void addBaseLineInput(Employee employee);

	Employee saveFeedBack(Employee employee);

	Employee getEmployee(int employeedetails_id);

	Employee updateFeedBack(Employee employee);

}
