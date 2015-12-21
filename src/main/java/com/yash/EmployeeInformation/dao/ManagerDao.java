package com.yash.EmployeeInformation.dao;

import java.util.List;

import com.yash.EmployeeInformation.domain.Efficiency;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Grade;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.domain.Skill;

public interface ManagerDao {

	List<Employee> getAllEmployees(String sql);

	void saveNewProject(Project project);

	Manager checkAuthorization(String name);

	List<Project> getAllProjects(String sql);

	void saveAllotedProject(String sql);

	void addBaseLineInput(Employee employee);

	void saveFeedBack(Employee employee);

	void updateFeedBack(Employee employee);

	List<Grade> getAllGrades();

	void assignEmployeeGrade(Employee employee);

	List<Efficiency> getAllEfficiencies();

	void updateEmployeeEfficiency(Skill skill);

	void updateEmployeeGrade(Employee employee);

	List<Skill> getAllSkills();

	void addEmployeeSkill(Skill skill);

}

