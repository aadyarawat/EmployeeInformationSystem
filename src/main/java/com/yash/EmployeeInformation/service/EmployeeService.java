package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.EmployeeDao;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;

/**
 * Session Bean implementation class EmployeeService
 */
@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceLocal {

	@Inject
	EmployeeDao employeeDao;

	/**
	 * Default constructor.
	 */
	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author prakhar.jain
	 * @return List<Employee> all employees
	 * 
	 */
	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employeedetails";
		List<Employee> employees = employeeDao.getAllEmployees(sql);
		return employees;
	}

	/**
	 * @author pratik.sethia
	 * 
	 * @return List of Employees with perticular name
	 */
	@Override
	public List<Employee> searchEmployeeByName(String searchValueText) {
		String sql = "SELECT * FROM EMPLOYEEDETAILS WHERE FIRSTNAME LIKE '" + searchValueText + "%' OR LASTNAME LIKE '"
				+ searchValueText + "%'";
		List<Employee> employees = employeeDao.getAllEmployees(sql);
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
		employeeDao.saveNewProject(project);
	}

}
