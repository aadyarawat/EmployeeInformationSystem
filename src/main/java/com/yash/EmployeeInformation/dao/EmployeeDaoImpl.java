package com.yash.EmployeeInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;


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

	Connection connection = null;

	@Resource(lookup = "java:jboss/datasources/EIS")
	private DataSource dataSource;

	@Override
	public String getRegister(Employee employee) {
		String query = "INSERT INTO EMPLOYEE (YASHEMPLOYEEID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ALTERNATE_MOBILE) VALUES "
				+ "('" + employee.getYashEmployeeId() + "','" + employee.getFirstName() + "','" + employee.getLastName()
				+ "'," + "'" + employee.getEmail() + "','" + employee.getMobile() + "','"
				+ employee.getAlternate_mobile() + "')";

		try {

			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error registering employee check filed values";
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public int getEmpidService(String attribute) {
		int receivedId = 0;
		String query = "SELECT EMPLOYEEDETAILS_ID FROM EMPLOYEE WHERE EMAIL ='" + attribute + "'";
		System.out.println(query);
		try {

			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				receivedId = resultSet.getInt("EMPLOYEEDETAILS_ID");
				
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
		return receivedId;

	}

	@Override
	public String saveAddressService(int recId, Employee employee) {
		String query = "INSERT INTO ADDRESS (HOUSENO,STREETNAME,CITY,STATE,PINCODE,EMPLOYEEDETAILS_ID) VALUES " + "('"
				+ employee.getAddress().getHouseNo() + "','" + employee.getAddress().getStreetName() + "','"
				+ employee.getAddress().getCity() + "'," + "'" + employee.getAddress().getState() + "','"
				+ employee.getAddress().getPincode() + "','" + recId + "')";

		try {

			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error saving address check fields";
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Skill> fetchSkill() {
		try

		{
			connection = (Connection) dataSource.getConnection();
			ResultSet resultSet = connection.prepareStatement("SELECT * FROM SKILL").executeQuery();
			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setSkill_id(resultSet.getInt(1));
				skill.setSkillName(resultSet.getString(2));
				listSkill.add(skill);

			}
		} catch (Exception e) {

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
		return listSkill;
	}

	@Override
	public List<Skill> fetchSkillEfficiency() {
		try

		{
			connection = (Connection) dataSource.getConnection();
			ResultSet resultSet = connection.prepareStatement("SELECT * FROM SKILLEFFICIENCY").executeQuery();
			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setSkillefficiency_id(resultSet.getInt(1));
				skill.setEfficiencyType(resultSet.getString(2));
				listSkillEfficiency.add(skill);
			}
			
		} catch (Exception e) {

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
		return listSkillEfficiency;
	}

	@Override
	public String saveSkillAndEfficiency(int skillName, int skillEfficiency, int recId) {
		String sql = "INSERT INTO EMPLOYEESKILL (SKILL_ID,SKILLEFFICIENCY_ID,EMPLOYEEDETAILS_ID) " + "VALUES ("
				+ skillName + "," + skillEfficiency + "," + recId + ")";
		try {

			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error inserting skill check fields selected";
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Employee getEmployee(String emailID) {
		String query = "SELECT * FROM EMPLOYEE WHERE EMAIL ='" + emailID + "'";
		Employee employee = null;

		try {

			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet == null) {
				return null;
			} else {
				employee = new Employee();
			}
			while (resultSet.next()) {
				employee.setAlternate_mobile(resultSet.getString("alternate_mobile"));
				employee.setFirstName(resultSet.getString("firstname"));
				employee.setLastName(resultSet.getString("lastname"));
				employee.setMobile(resultSet.getString("mobile"));
				employee.setYashEmployeeId(resultSet.getInt("yashemployeeid"));
				employee.setEmployeedetails_id(resultSet.getInt("employeedetails_id"));
				employee.setEmail(emailID);
			}

			String sql = "SELECT * from ADDRESS WHERE employeedetails_id = " + employee.getEmployeedetails_id();

			PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			if (resultSet1 == null) {
				return null;
			}
			while (resultSet1.next()) {
				employee.getAddress().setAddress_id(resultSet1.getInt("address_id"));
				employee.getAddress().setCity(resultSet1.getString("city"));
				employee.getAddress().setHouseNo(resultSet1.getInt("houseno"));
				employee.getAddress().setPincode(resultSet1.getString("pincode"));
				employee.getAddress().setState(resultSet1.getString("state"));
				employee.getAddress().setStreetName(resultSet1.getString("streetname"));
				employee.getAddress().setEmployeedetails_id(employee.getEmployeedetails_id());
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
		return employee;

	}

	@Override
	public String updateEmployeeDetail(Employee employee) {
		String query = "UPDATE `employee` SET `yashemployeeid`='"+employee.getYashEmployeeId()+"' , `firstname`='"+employee.getFirstName()+"' , `lastname`='"+employee.getLastName()+"' , `email`='"+employee.getEmail()+"' , `mobile`='"+employee.getMobile()+"' , `alternate_mobile`='"+employee.getAlternate_mobile()+"'  WHERE `employeedetails_id`="+employee.getEmployeedetails_id();
		return update(query);
	}

	@Override
	public String updateEmployeeAddress(int recId, Employee employee) {
		String query = "UPDATE `address` SET `houseNo`="+employee.getAddress().getHouseNo()+" , streetName='"+employee.getAddress().getStreetName()+"' , state='"+employee.getAddress().getState()+"' ,city='"+employee.getAddress().getCity()+"' , pincode="+employee.getAddress().getPincode()+" WHERE `employeedetails_id`="+employee.getEmployeedetails_id();
		return update(query);
	}

	public String update(String query) {
		try {

			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error Performing Update Check field values";
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Skill> getEmployeeSkills(int recId) {
		String getskillIds="SELECT * FROM `employeeskill` WHERE `employeedetails_id`="+recId;
		try {
			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(getskillIds);	
			ResultSet resultSet1 = preparedStatement.executeQuery();
			List<Skill> skills = new ArrayList<>(); 
			while (resultSet1.next()) {
				Skill skill = new Skill();
				skill.setSkill_id(resultSet1.getInt("skill_id"));
				skill.setSkillefficiency_id(resultSet1.getInt("skillefficiency_id"));
				skills.add(skill);
			}
			for (Skill skill : skills) {
				String getskill = "SELECT skillname from skill where skill_id="+skill.getSkill_id();
				PreparedStatement preparedStatement2 = connection.prepareStatement(getskill);
				ResultSet resultSet = preparedStatement2.executeQuery();
				while(resultSet.next()){
					skill.setSkillName(resultSet.getString("skillname"));
				}
				String getefficiency = "SELECT efficiencyType FROM skillefficiency WHERE skillefficiency_id="+skill.getSkillefficiency_id();	
				PreparedStatement preparedStatement3 = connection.prepareStatement(getefficiency);
				ResultSet resultSet2 = preparedStatement3.executeQuery();
				while(resultSet2.next()){
					skill.setEfficiencyType(resultSet2.getString("efficiencyType"));
				}
			}
			return skills;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String deleteEmployeeSkill(int skillid, int efficiencyId, int recId) {
		String query ="DELETE FROM employeeskill WHERE skill_id="+skillid+" AND `employeedetails_id`="+recId+" AND `skillefficiency_id`="+efficiencyId;
		try {
			connection = (Connection) dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error Performing delete , try again later";
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
	}
}
