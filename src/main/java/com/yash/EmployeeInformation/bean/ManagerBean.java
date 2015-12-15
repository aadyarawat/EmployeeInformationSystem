package com.yash.EmployeeInformation.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.service.ManagerServiceLocal;

@ManagedBean
@SessionScoped
public class ManagerBean {

	@EJB
	ManagerServiceLocal managerService;

	private List<Employee> employees;
	private String searchValueText;
	private String projectName;
	private String projectDuration;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public String getSearchValueText() {
		return searchValueText;
	}

	public void setSearchValueText(String searchValueText) {
		this.searchValueText = searchValueText;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * 
	 * @author pratik.sethia
	 * @return List of employee with particular name
	 */
	public String searchEmployeeByName() {
		if (searchValueText.equalsIgnoreCase("")) {
			employees = null;
		} else {
			employees = managerService.searchEmployeeByName(searchValueText);
		}

		return null;

	}

	/**
	 * @author kushagra.bhargava This method will save the project details to
	 *         the database. It sends the object of project to the service
	 *         layer.
	 * @return a string for the page redirection
	 */
	public String saveProject() {
		Project project = new Project(0, projectName, projectDuration);
		managerService.createNewProject(project);
		return "projectDetails.xhtml?faces-redirect=true";
	}

	/**
	 * @author pratik.sethia
	 * 
	 *         This method will populate the list of the employee on the loading
	 *         of the page.
	 */
	@PostConstruct
	public void getAllEmployeesList() {
		employees = managerService.getAllEmployees();
		}
	
	public String showAllEmployee(){
		employees = managerService.getAllEmployees();
		return null;
	}
	
	

}
