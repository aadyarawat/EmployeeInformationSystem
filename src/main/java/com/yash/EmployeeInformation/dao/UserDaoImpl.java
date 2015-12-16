package com.yash.EmployeeInformation.dao;

import java.sql.Connection;

import javax.inject.Inject;

import com.yash.EmployeeInformation.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	@Inject
	ConnectionUtil connectionUtil;
	
	
	@Override
	public boolean addResumeDetail(String finalfilename, String useremail) {
		String query = "INSERT INTO RESUME (RESUMENAME,EMPLOYEEEMAIL) VALUES ('"+finalfilename+"','"+useremail+"')";
		Connection connection = connectionUtil.getConnection();
		try {
			connection.prepareStatement(query).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
