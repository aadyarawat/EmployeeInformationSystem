package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.util.ConnectionUtil;

/**
 * 
 * @author prakhar.jain
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	@Resource(lookup = "java:jboss/datasources/EIS")
	DataSource source;

	/**
	 * 
	 * @return Connection
	 * 
	 *         This method will return connection from data source
	 *
	 */
	@Override
	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = source.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * 
	 * @author prakhar.jain
	 * @return List<Employee>
	 * 
	 * 
	 */

	@Override
	public List<Employee> getAllEmployees(String sql) {
		List<Employee> employees = new ArrayList<>();
		List<Project> projects;
		Employee employee = null;
		Project project = null;
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmployeedetails_id(resultSet.getInt(1));
				employee.setEmployeeId(resultSet.getInt(2));
				employee.setFirstName(resultSet.getString(3));
				employee.setLastName(resultSet.getString(4));
				employee.setEmail(resultSet.getString(5));
				employee.setAddress(resultSet.getString(6));
				employee.setState(resultSet.getString(7));
				employee.setCity(resultSet.getString(8));
				employee.setMobile(resultSet.getString(9));
				employee.setAlternate_mobile(resultSet.getString(10));
				employee.setResume_id(resultSet.getInt(11));
				String querry = "SELECT * FROM `projectallocationdetails` pa INNER JOIN `projectdetails` pd ON pa.`projectDetails_Id`=pd.`projectDetails_Id` WHERE pa.`employeeId`=?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(querry);
				preparedStatement2.setInt(1, employee.getEmployeeId());
				ResultSet resultSet2 = preparedStatement2.executeQuery();
				projects = new ArrayList<>();
				while (resultSet2.next()) {
					project = new Project();
					project.setProjectDetails_Id(resultSet2.getInt(2));
					project.setProjectName(resultSet2.getString(5));
					projects.add(project);
				}
				employee.setProjects(projects);
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Inject
	ConnectionUtil connectionUtil;

	/**
	 * @author kushagra.bhargava
	 * 
	 *         This method will take a project object as argument This method
	 *         will convert the project object into query string
	 */

	@Override
	public void saveNewProject(Project project) {
		// TODO Auto-generated method stub
		String sql = "insert into projectDetails(projectName , projectDuration) values('" + project.getProjectName()
				+ "','" + project.getProjectDuration() + "')";
		Connection connection = connectionUtil.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
