package com.yash.EmployeeInformation.dao;

import java.util.List;

import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Role;

public interface AdminDao {

	List<Manager> getAllEmployee();

	List<Role> getAllRoles();

	void saveManager(Manager manager);

	void removeManager(Manager manager);

}
