package com.yash.EmployeeInformation.service;

import javax.ejb.Local;

@Local
public interface UserServiceLocal {

	void addResumeDetail(String finalfilename, String useremail);

	
}
