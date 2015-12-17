package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.yash.EmployeeInformation.domain.Address;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Skill;

/**
 * 
 * @author aadya.rawat
 * 
 */
public class EmployeeDaoImpl implements EmployeeDao {

	List<Skill> listSkill = new ArrayList<>();
	List<Skill> listSkillEfficiency = new ArrayList<>();
	
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

	@Override
	public List<Skill> fetchSkill() {
		try

		{
			Connection connection = (Connection) dataSource.getConnection();
			ResultSet resultSet = connection.prepareStatement("SELECT * FROM SKILL").executeQuery();
			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setSkill_id(resultSet.getInt(1));
				skill.setSkillName(resultSet.getString(2));
				listSkill.add(skill);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return listSkill;
	}

	@Override
	public List<Skill> fetchSkillEfficiency() {
		try

		{
			Connection connection = (Connection) dataSource.getConnection();
			ResultSet resultSet = connection.prepareStatement("SELECT * FROM SKILLEFFICIENCY").executeQuery();
			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setSkillefficiency_id(resultSet.getInt(1));
				skill.setEfficiencyType(resultSet.getString(2));
				listSkillEfficiency.add(skill);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return listSkillEfficiency;
	}

	@Override
	public void saveSkillAndEfficiency(String skillName, String skillEfficiency, int recId) {
		String sql = "INSERT INTO EMPLOYEESKILL (SKILL_ID,SKILLEFFICIENCY_ID,EMPLOYEEDETAILS_ID) "
				+ "VALUES ('"+skillName+"','"+skillEfficiency+"','"+recId+"')";
		try {

			Connection connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
