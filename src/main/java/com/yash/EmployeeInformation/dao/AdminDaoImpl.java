package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Role;

public class AdminDaoImpl implements AdminDao {

	/*
	 * @Inject ConnectionUtil connectionUtil;
	 */

	@Resource(lookup = "java:jboss/datasources/EIS")
	DataSource source;

	

	@Override
	public List<Manager> getAllEmployee() {
		List<Manager> managers = new ArrayList<Manager>();
		String sql = "select * from managerdetails";
		Connection connection = null;
		try {
			connection = source.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Manager manager = new Manager();
				manager.setManagerId(resultSet.getInt(1));
				manager.setManagerName(resultSet.getString(2));
				manager.setManagerEmailId(resultSet.getString(3));
				manager.setRole(resultSet.getInt(4));
				managers.add(manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return managers;
	}

	
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		List<Role> roles = new ArrayList<Role>();
		String sql = "select * from role";
		Connection connection = null;
		try {
			connection = source.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Role role = new Role();
				role.setRole_id(resultSet.getInt(1));
				role.setRoleType(resultSet.getString(2));
				roles.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return roles;
	}

	@Override
	public void saveManager(Manager manager) {
		// TODO Auto-generated method stub
		String sql="insert into managerdetails(managerName,managerEmailId,role) value('"+manager.getManagerName()+"','"+manager.getManagerEmailId()+"','"+manager.getRole()+"')";
		Connection connection = null;
		try {
			connection = source.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void removeManager(Manager manager) {
		// TODO Auto-generated method stub
		String sql="delete from managerdetails where managerEmailId='"+manager.getManagerEmailId()+"'";
		Connection connection = null;
		try {
			connection = source.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
