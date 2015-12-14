package com.yash.EmployeeInformation.bean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.service.EmployeeServiceLocal;



@ManagedBean
@SessionScoped
public class ManagerBean {

	@Inject EmployeeServiceLocal employeeService;
	
	private List<Employee> employees;
	
	private String searchValueText;
	
	
	
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
	 * @author prakhar.jain
	 * 
	 * @return List of all employees
	 *//*
	public String getAllEmployees(){
		employees=employeeService.getAllEmployees();
		for(Employee employee:employees){
			System.out.println(employee.getFirstName()+" "+employee.getLastName());
			for(Project project:employee.getProjects()){
				System.out.println(project.getProjectName());
			}
		}
		return "test.xhtml?faces-redirect=true";
	}*/
	
	/**
	 * 
	 * @author pratik.sethia
	 * @return List of employee with perticular name
	 */
	public String searchEmployeeByName(){
		if(searchValueText.equalsIgnoreCase("")){
			employees=employeeService.getAllEmployees();
		 }else{
		 employees=employeeService.searchEmployeeByName(searchValueText);
		}
		 
		return null;
	
		}
	
	
}
