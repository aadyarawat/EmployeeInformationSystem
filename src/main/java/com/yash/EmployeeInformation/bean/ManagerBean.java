package com.yash.EmployeeInformation.bean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yash.EmployeeInformation.domain.Project;


@ManagedBean
@SessionScoped
public class ManagerBean {

	private List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	
	}
	
	
	
	@PostConstruct
	public void getAllEmployees(){
		
	}
	
	
}
