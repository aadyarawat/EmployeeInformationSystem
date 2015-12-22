package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import javax.sql.DataSource;



public class UserDaoImpl implements UserDao {
	
	@Resource(lookup = "java:jboss/datasources/EIS")
	private DataSource dataSource;
	
	Connection connection = null;
	
	@Override
	public String addResumeDetail(String finalfilename, String useremail) {
		String query = "INSERT INTO RESUME (RESUMENAME,EMPLOYEEEMAIL) VALUES ('"+finalfilename+"','"+useremail+"')";
		try {
			connection = dataSource.getConnection();
			connection.prepareStatement(query).executeUpdate();
			return "Upload succesfull";
		} catch (Exception e) {
			if(e.getClass().getName().equalsIgnoreCase("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException"))
			return "File Updated ";else return "Error occured while upload please try again";
		}finally {
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}