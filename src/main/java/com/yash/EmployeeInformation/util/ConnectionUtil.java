package com.yash.EmployeeInformation.util;


import java.sql.Connection;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class ConnectionUtil {

	@Resource(lookup = "java:jboss/datasources/EIS")
	DataSource source;

	Connection connection = null;
	
	/**
	 * 
	 * @return Connection
	 * 
	 *         This method will return connection from data source
	 * @throws SQLException 
	 *
	 */
	public Connection getConnection() throws SQLException {

		

		try {
			connection = source.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(connection!=null)
			connection.close();
		}

		return connection;
	}

	
	
	
	
}
