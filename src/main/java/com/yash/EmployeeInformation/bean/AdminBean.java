package com.yash.EmployeeInformation.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Role;
import com.yash.EmployeeInformation.service.AdminServiceLocal;

@ManagedBean
@SessionScoped
public class AdminBean {

	List<Manager> managers;
	List<Role> roles;
	private Manager manager;
	private String managerName;
	private String managerEmail;
	private int role;


	@EJB
	AdminServiceLocal adminService;
	
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public List<Role> getRoles() {
		roles = adminService.getAllRoles();
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Manager> getManagers() {
		managers = adminService.getAllManager();
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public String addManager() {
		System.out.println("add>>>>>>>>" + manager);
		System.out.println(managers.contains(manager));

		for (Manager manager1 : managers) {
			if (manager1.getManagerEmailId().equals(managerEmail)) {
				return "registerManager.xhtml?faces-redirect=true & message=Manager Already Exists! ";
			}
		}
		Manager manager=new Manager();
		manager.setManagerEmailId(managerEmail);
		manager.setManagerName(managerName);
		manager.setRole(role);
		adminService.saveManager(manager);
		
		return "registerManager.xhtml?faces-redirect=true&message=Manager Added Successfuly!";
	}

	public String deleteManager() {
		System.out.println("delete");
		adminService.removeManager(manager);
		managerEmail="";
		managerName="";
		
		return "registerManager.xhtml?faces-redirect=true&message=Manager Deleted Successfuly!";
	}
}
