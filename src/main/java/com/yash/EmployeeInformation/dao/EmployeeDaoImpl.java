package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.yash.EmployeeInformation.domain.Address;
import com.yash.EmployeeInformation.domain.Employee;

/**
 * 
 * @author aadya.rawat
 * 
 */
public class EmployeeDaoImpl implements EmployeeDao {

	@Resource(lookup = "java:jboss/datasources/EIS")
	private DataSource dataSource;

	@Override
	public void getRegister(Employee employee) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO EMPLOYEE (EMPLOYEEID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ALTERNATE_MOBILE) VALUES "
				+ "('" + employee.getYashEmployeeId() + "','" + employee.getFirstName() + "','" + employee.getLastName()
				+ "'," + "'" + employee.getEmail() + "','" + employee.getMobile() + "','"
				+ employee.getAlternate_mobile() + "')";

		try {

			Connection connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getEmpidService(String attribute) {
		int receivedId = 0;
		String query = "SELECT EMPLOYEEDETAILS_ID FROM EMPLOYEE WHERE EMAIL ='" + attribute + "'";
		try {

			Connection connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				receivedId = resultSet.getInt("EMPLOYEEDETAILS_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receivedId;
		
	}

	@Override
	public void saveAddressService(int recId,Employee employee) {
		String query = "INSERT INTO ADDRESS (HOUSENO,STREETNAME,CITY,STATE,PINCODE,EMPLOYEEDETAILS_ID) VALUES "+"('" + employee.getAddress().getHouseNo() + "','" + employee.getAddress().getStreetName() + "','" + employee.getAddress().getCity()
				+ "'," + "'" +employee.getAddress().getState() + "','" + employee.getAddress().getPincode() + "','"+recId+"')";
		
		try {

			Connection connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
