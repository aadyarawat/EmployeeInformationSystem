package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 
 * @author prakhar.jain
 *
 */
public class EmployeeDaoImpl implements EmployeeDao{

	@Resource(lookup="java:jboss/datasources/EIS")
	DataSource source;
	
	
	/**
	 * 
	 * this method will return connection from data source
	 */
	@Override
	public Connection getConnection(){
		
		Connection connection=null;
		
		try {
			connection = source.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
