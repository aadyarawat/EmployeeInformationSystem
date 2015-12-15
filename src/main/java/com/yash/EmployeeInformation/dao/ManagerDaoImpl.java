package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.yash.EmployeeInformation.domain.Address;
import com.yash.EmployeeInformation.domain.BaseLineInput;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.util.ConnectionUtil;

/**
 * 
 * @author prakhar.jain
 *
 */
public class ManagerDaoImpl implements ManagerDao {

	@Inject
	ConnectionUtil connectionUtil;
	
	
	public BaseLineInput getBaseLineInputDetails(int employeedetails_id){
		BaseLineInput baseLineInput=new BaseLineInput();
		String sql="SELECT * FROM baselineinputdetails WHERE employeedetails_id="+employeedetails_id;
		try {
			ResultSet resultSet=select(sql);
			while(resultSet.next()){
				baseLineInput.setBaselineInputdetail(resultSet.getString(2));
				baseLineInput.setEmployeedetails_id(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return baseLineInput;
	}

	/**
	 * 
	 * @param employeedetails_id
	 * @return
	 */
	public Address getEmployeeAddress(int employeedetails_id){
		Address address=new Address();
		String sql="SELECT * FROM ADDRESS WHERE employeedetails_id="+employeedetails_id;
		
		try {
			ResultSet resultSet=select(sql);
			while(resultSet.next()){
				address.setAddress_id(resultSet.getInt(1));
				address.setHouseNo(resultSet.getInt(2));
				address.setStreetName(resultSet.getString(3));
				address.setCity(resultSet.getString(4));
				address.setState(resultSet.getString(5));
				address.setPincode(resultSet.getString(6));
				address.setEmployeedetails_id(resultSet.getInt(7));
				
			}
		} catch (SQLException e) {
			}
		
		return address;
		
	}
	
	/**
	 * 
	 * @param employeedetails_id
	 * @return
	 */
	public List<Project> getprojects(int employeedetails_id){
		List<Project> projects;
		String querry = "SELECT * FROM `projectallocationdetails` pa INNER JOIN `projectdetails` pd ON pa.`projectDetails_Id`=pd.`projectDetails_Id` WHERE pa.employeedetails_id="+employeedetails_id;
		Project project = null;
		ResultSet resultSet = select(querry);
		projects = new ArrayList<>();
		try {
			while (resultSet.next()) {
				project = new Project();
				project.setProjectDetails_Id(resultSet.getInt(2));
				project.setProjectName(resultSet.getString(5));
				project.setProjectDuration(resultSet.getString(6));
				projects.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projects;
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
		Employee employee = null;
		try {
			ResultSet resultSet = select(sql);
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmployeedetails_id(resultSet.getInt(1));
				employee.setEmployeeId(resultSet.getInt(2));
				employee.setFirstName(resultSet.getString(3));
				employee.setLastName(resultSet.getString(4));
				employee.setEmail(resultSet.getString(5));
				employee.setMobile(resultSet.getString(6));
				employee.setAlternate_mobile(resultSet.getString(7));
				employee.setAddress(getEmployeeAddress(employee.getEmployeedetails_id()));
				employee.setProjects(getprojects(employee.getEmployeedetails_id()));
				employee.setBaseLineInput(getBaseLineInputDetails(employee.getEmployeedetails_id()));
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	/**
	 * @author kushagra.bhargava
	 * 
	 *         This method will take a project object as argument This method
	 *         will convert the project object into query string
	 */

	@Override
	public void saveNewProject(Project project) {
		
		String sql = "insert into projectDetails(projectName , projectDuration) values('" + project.getProjectName()
				+ "','" + project.getProjectDuration() + "')";
				update(sql);
	}
	
	/**
	 * @author kushagra.bhargava
	 * 	This method will take a sql string and process the query for insert and update
	 * @param sql
	 */
	public void update(String sql) {
		Connection connection = connectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author kushagra.bhargava
	 * 	This method will take a sql string and process the query for selection
	 * @param sql
	 */
	public ResultSet select(String sql) {
		Connection connection = connectionUtil.getConnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public String checkAuthorization(String name) {
		// TODO Auto-generated method stub
		String check="";
		String sql="select * from managerdetails where managerEmailId='"+name+"'";
		ResultSet resultSet=select(sql);
		try {
			while(resultSet.next()){
				if(name.equals(resultSet.getString("managerEmailId"))){
					check="manager";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
}
