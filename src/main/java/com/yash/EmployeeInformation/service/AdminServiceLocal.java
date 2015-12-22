package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Role;

@Local
public interface AdminServiceLocal {

	List<Manager> getAllManager();

	List<Role> getAllRoles();

	void saveManager(Manager manager);

	void removeManager(Manager manager);

}
