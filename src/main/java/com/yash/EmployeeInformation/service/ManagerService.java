package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.ManagerDao;
import com.yash.EmployeeInformation.domain.Efficiency;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Grade;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.domain.Skill;

/**
 * Session Bean implementation class EmployeeService
 */
@Stateless
@LocalBean
public class ManagerService implements ManagerServiceLocal {

	@Inject
	ManagerDao managerDao;

	/**
	 * Default constructor.
	 */
	public ManagerService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author prakhar.jain
	 * @return List<Employee> all employees
	 * 
	 */
	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		List<Employee> employees = managerDao.getAllEmployees(sql);
		return employees;
	}

	/**
	 * @author pratik.sethia
	 * 
	 * @return List of Employees with perticular name
	 */
	@Override
	public List<Employee> searchEmployeeByName(String searchValueText) {
		String sql = "SELECT * FROM EMPLOYEE WHERE FIRSTNAME LIKE '" + searchValueText + "%' OR LASTNAME LIKE '"
				+ searchValueText + "%'";
		List<Employee> employees = managerDao.getAllEmployees(sql);
		System.out.println(employees);
		return employees;
	}

	/**
	 * @author kushagra.bhargava
	 * 
	 *         this method convert the project details in to a query string to
	 *         store it in Database.
	 * 
	 *         It takes a project object as a argument.
	 */
	@Override
	public void createNewProject(Project project) {
		// TODO Auto-generated method stub
		managerDao.saveNewProject(project);
	}

	@Override
	public Manager checkAuthorization(String name) {
		// TODO Auto-generated method stub
		Manager manager=managerDao.checkAuthorization(name);
		return manager;
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		String sql="Select * from projectDetails";
		List<Project> projects=managerDao.getAllProjects(sql);
		return projects;
	}

	@Override
	public void allocateProject(int projectDetails_Id, int employeedetails_id) {
		// TODO Auto-generated method stub
		String sql="insert into projectallocationdetails  (projectDetails_id,employeedetails_id) values('"+projectDetails_Id+"','"+employeedetails_id+"')";
		managerDao.saveAllotedProject(sql);
		
	}
	

	/***
	 * @author phalguni.vatsa
	 */
	@Override
	public void addBaseLineInput(Employee employee) {
		managerDao.addBaseLineInput(employee);
		
	}
	

/**
	 * 
	 * This method save the feedBack of employee........
	 * 
	 * @return Employee
	 * 
	 * @param Employee
	 * @author prakhar.jain
	 */
	@Override
	public Employee saveFeedBack(Employee employee) {
		Employee updatedEmployee=null;
		managerDao.saveFeedBack(employee);
		updatedEmployee=getEmployee(employee.getEmployeedetails_id());
		return updatedEmployee;
	}

	/**
	 * 
	 * This method retrieve complete object of employee
	 * 
	 * @return Employee
	 * 
	 * @param employeedetails_id
	 * @author prakhar.jain
	 */
	@Override
	public Employee getEmployee(int employeedetails_id) {
		Employee updatedEmployee=null;
		String sql="SELECT * FROM employee WHERE employeedetails_id="+employeedetails_id;
		List<Employee> employees=managerDao.getAllEmployees(sql);
		for(Employee employee:employees){
			updatedEmployee=employee;
		}
		return updatedEmployee;
	}

	/**
	 * 
	 * This method Update the feedBack of employee........
	 * 
	 * @return Employee
	 * 
	 * @param Employee
	 * @author prakhar.jain
	 */
	@Override
	public Employee updateFeedBack(Employee employee) {
		managerDao.updateFeedBack(employee);
		Employee updatedEmployee=getEmployee(employee.getEmployeedetails_id());
		return updatedEmployee;
	}
	
	
	  @Override
      public List<Employee> getUnallocatedProjectEmployees(int projectDetails_Id) {
             String sql = "SELECT * FROM `employee` ,`projectallocationdetails` WHERE `employee`.`employeedetails_id`= `projectallocationdetails`.`employeedetails_id` AND `projectallocationdetails`.`projectDetails_Id`="+projectDetails_Id;
             List<Employee> allocatedEmployees = managerDao.getAllEmployees(sql);
             List<Employee> employees= getAllEmployees();
             employees.removeAll(allocatedEmployees);
             return employees ;
      }

	@Override
	public List<Grade> getAllGrades() {
		// TODO Auto-generated method stub
		List<Grade>grades= managerDao.getAllGrades();
		return grades;
	}

	@Override
	public void assignEmployeeGrade(Employee employee) {
		
		managerDao.assignEmployeeGrade(employee);
	}

	@Override
	public List<Efficiency> getAllEfficiencies() {
		List<Efficiency> efficiencies= managerDao.getAllEfficiencies();
		return efficiencies;
	}

	@Override
	public void updateEmployeeSkill(Skill skill) {
		managerDao.updateEmployeeEfficiency(skill);
	}

	@Override
	public void updateEmployeeGrade(Employee employee) {
		managerDao.updateEmployeeGrade(employee);
		
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> skills=managerDao.getAllSkills();
		return skills;
	}

	@Override
	public void addEmployeeSkill(Skill skill) {
		managerDao.addEmployeeSkill(skill);
		
	}
}
