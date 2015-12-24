package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.EmployeeInformation.domain.Efficiency;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Grade;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.domain.Skill;

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

	List<Employee> getUnallocatedProjectEmployees(int projectDetails_Id);

	List<Grade> getAllGrades();

	void assignEmployeeGrade(Employee employee);

	List<Efficiency> getAllEfficiencies();

	void updateEmployeeSkill(Skill skill);

	void updateEmployeeGrade(Employee employee);

	List<Skill> getAllSkills();

	void addNewSkill(Skill skill);

	void addEmployeeSkill(Skill skill);
	
	
	 

}
