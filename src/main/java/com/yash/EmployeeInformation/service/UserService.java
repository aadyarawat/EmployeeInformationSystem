package com.yash.EmployeeInformation.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.EmployeeInformation.dao.UserDao;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceLocal {

    /**
     * Default constructor. 
     */
	
	@Inject
	UserDao userDao;
	
    public UserService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void addResumeDetail(String finalfilename, String useremail) {
		userDao.addResumeDetail(finalfilename,useremail);
	}
}
