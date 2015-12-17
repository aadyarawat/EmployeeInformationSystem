package com.yash.EmployeeInformation.service;

import javax.ejb.Local;

@Local
public interface UserServiceLocal {

	String addResumeDetail(String finalfilename, String useremail);

	
}
