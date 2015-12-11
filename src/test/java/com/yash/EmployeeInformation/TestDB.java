package com.yash.EmployeeInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class TestDB {

	public static Logger logger = Logger.getLogger(TestDB.class.getName());
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://10.26.11.50:3306/employeeinformationsystem"; // url to remote database where access is provided
	private static final String USERNAME = "EmpInfo"; //username to remote connection
	private static final String PASSWORD = "yash@03"; //password provided by connection provider
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) throws SQLException {
		String query = "SELECT * FROM SKILL";
		preparedStatement = getConnection().prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
					logger.info("Skill-id:"+resultSet.getInt(1)+"     skill:"+resultSet.getString(2));
		}
		
	}
	
}
