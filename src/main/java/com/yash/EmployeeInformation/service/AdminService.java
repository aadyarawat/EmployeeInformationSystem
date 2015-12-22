package com.yash.EmployeeInformation.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.AdminDao;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Role;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceLocal {

    public AdminService() {
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    AdminDao adminDao;
	@Override
	public List<Manager> getAllManager() {
		List<Manager> managers=null;
		managers=adminDao.getAllEmployee();
		return managers;
	}
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		List<Role> roles=adminDao.getAllRoles();
		return roles;
	}
	@Override
	public void saveManager(Manager manager) {
		adminDao.saveManager(manager);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeManager(Manager manager) {
		// TODO Auto-generated method stub
		adminDao.removeManager(manager);
		
	}
    

}
