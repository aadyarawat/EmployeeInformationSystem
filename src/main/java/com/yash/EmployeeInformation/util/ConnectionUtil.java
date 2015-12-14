package com.yash.EmployeeInformation.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class ConnectionUtil {

	@Resource(lookup = "java:jboss/datasources/EIS")
	DataSource source;

	/**
	 * 
	 * @return Connection
	 * 
	 *         This method will return connection from data source
	 *
	 */
	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = source.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}
}
