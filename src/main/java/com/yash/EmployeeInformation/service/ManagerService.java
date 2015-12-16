package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.ManagerDao;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;

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

}
