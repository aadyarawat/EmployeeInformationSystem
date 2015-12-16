package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;

import com.yash.EmployeeInformation.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	@Inject
	ConnectionUtil connectionUtil;
	
	
	@Override
	public String addResumeDetail(String finalfilename, String useremail) {
		String query = "INSERT INTO RESUME (RESUMENAME,EMPLOYEEEMAIL) VALUES ('"+finalfilename+"','"+useremail+"')";
		Connection connection = connectionUtil.getConnection();
		try {
			connection.prepareStatement(query).executeUpdate();
			return "Uploaded succesfull";
		} catch (Exception e) {
			//e.printStackTrace();
			if(e.getClass().getName().equalsIgnoreCase("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException"))
			System.out.println("Already Existed File Updated for"+finalfilename);
			return "Already Existed File Updated ";
		}
	}
}