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
import com.yash.EmployeeInformation.domain.BaseLineInput;
import com.yash.EmployeeInformation.domain.Efficiency;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.FeedBack;
import com.yash.EmployeeInformation.domain.Grade;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.domain.Skill;

/**
 * This class Manages all the operations of done on employee
 * 
 * @author prakhar.jain
 *
 */
public class ManagerDaoImpl implements ManagerDao {

	/*
	 * @Inject ConnectionUtil connectionUtil;
	 */

	@Resource(lookup = "java:jboss/datasources/EIS")
	DataSource source;

	Connection connection = null;

	/**
	 * This method Returns feedback of employee // replace this method
	 * 
	 * @author prakhar.jain
	 * @param employeedetails_id
	 * @return
	 */
	public FeedBack getEmployeeFeedback(int employeedetails_id) {
		
		FeedBack feedBack = new FeedBack();
		String sql = "SELECT * FROM  `feedbackdetails` fb INNER JOIN `managerdetails` md ON fb.`lastUpdatedManagerId`=md.`managerDetails_Id` WHERE employeedetails_id="
				+ employeedetails_id;
		ResultSet resultSet=null;
		try {
			resultSet = select(sql);
			while (resultSet.next()) {
				feedBack.setFeedback_id(resultSet.getInt(1));
				feedBack.setFeedbackComment(resultSet.getString(2));
				feedBack.setLastUpdatedManager(resultSet.getString(6));
				feedBack.setLastUpdatedManagerId(resultSet.getInt(5));
				feedBack.setEmployeedetails_id(resultSet.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return feedBack;
	}

	/**
	 * 
	 * This method Returns BaseLine input of employee
	 * 
	 * @author prakhar.jain
	 * @param employeedetails_id
	 * @return
	 */
	public BaseLineInput getBaseLineInputDetails(int employeedetails_id) {
		BaseLineInput baseLineInput = new BaseLineInput();
		String sql = "SELECT * FROM baselineinputdetails WHERE employeedetails_id=" + employeedetails_id;
		ResultSet resultSet=null;
		try {
			resultSet = select(sql);
			while (resultSet.next()) {
				baseLineInput.setBaselineInputdetail(resultSet.getString(2));
				baseLineInput.setEmployeedetails_id(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return baseLineInput;
	}

	/**
	 * 
	 * This method Returns Address of employee
	 * 
	 * @author prakhar.jain
	 * @param employeedetails_id
	 * @return
	 */
	public Address getEmployeeAddress(int employeedetails_id) {
		Address address = new Address();
		String sql = "SELECT * FROM ADDRESS WHERE employeedetails_id=" + employeedetails_id;
		ResultSet resultSet=null;
		try {
			 resultSet = select(sql);
			while (resultSet.next()) {
				address.setAddress_id(resultSet.getInt(1));
				address.setHouseNo(resultSet.getInt(2));
				address.setStreetName(resultSet.getString(3));
				address.setCity(resultSet.getString(4));
				address.setState(resultSet.getString(5));
				address.setPincode(resultSet.getString(6));
				address.setEmployeedetails_id(resultSet.getInt(7));

			}
		} catch (SQLException e) {
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return address;

	}

	/**
	 * 
	 * This method Returns Projects of employee
	 * 
	 * @param employeedetails_id
	 * @return
	 */
	public List<Project> getEmployeeprojects(int employeedetails_id) {
		List<Project> projects;
		String querry = "SELECT * FROM `projectallocationdetails` pa INNER JOIN `projectdetails` pd ON pa.`projectDetails_Id`=pd.`projectDetails_Id` WHERE pa.employeedetails_id="
				+ employeedetails_id;
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
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projects;
	}

	/**
	 * This method return All Employees
	 * 
	 * @author prakhar.jain
	 * @return employees
	 * 
	 */
	@Override
	public List<Employee> getAllEmployees(String sql) {
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		ResultSet resultSet = select(sql);
		try {
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmployeedetails_id(resultSet.getInt(1));
				employee.setYashEmployeeId(resultSet.getInt(2));
				employee.setFirstName(resultSet.getString(3));
				employee.setLastName(resultSet.getString(4));
				employee.setEmail(resultSet.getString(5));
				employee.setMobile(resultSet.getString(6));
				employee.setAlternate_mobile(resultSet.getString(7));
				employee.setAddress(getEmployeeAddress(employee.getEmployeedetails_id()));
				employee.setProjects(getEmployeeprojects(employee.getEmployeedetails_id()));
				employee.setBaseLineInput(getBaseLineInputDetails(employee.getEmployeedetails_id()));
				employee.setFeedBack(getEmployeeFeedback(employee.getEmployeedetails_id()));
				employee.setSkills(getEmployeeSkills(employee.getEmployeedetails_id()));
				employee.setGrade(getEmployeeGrade(employee.getEmployeedetails_id()));
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employees;
	}

	private Grade getEmployeeGrade(int employeedetails_id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM grade g INNER JOIN `gradedetails` gd ON g.`grade_id`=gd.`gradeId` where employeedetails_id="+employeedetails_id;
		Grade grade=new Grade();
		ResultSet resultSet=select(sql);
		try {
			while(resultSet.next()){
				grade.setGrade_id(resultSet.getInt(1));
				grade.setGradeValue(resultSet.getString(2));
				grade.setEmployeedetails_id(resultSet.getInt(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return grade;
	}

	/**
	 * this method returns skills of employees
	 * 
	 * @param employeedetails_id
	 * @return
	 */
	private List<Skill> getEmployeeSkills(int employeedetails_id) {
		List<Skill> skills = new ArrayList<>();
		Skill skill;
		String sql = "SELECT * FROM employeeskill where employeedetails_id=" + employeedetails_id;
		ResultSet resultSet = select(sql);
		try {
			while (resultSet.next()) {
				skill = new Skill();
				skill.setEmployeedetails_id(employeedetails_id);
				sql = "SELECT * FROM skill where skill_id=" + resultSet.getInt(2);
				ResultSet resultSet2 = select(sql);
				while (resultSet2.next()) {
					skill.setSkillName(resultSet2.getString(2));
					skill.setSkill_id(resultSet.getInt(2));
				}

				sql = "SELECT * FROM skillefficiency where skillefficiency_id=" + resultSet.getInt(4);
				ResultSet resultSet3 = select(sql);
				while (resultSet3.next()) {
					skill.setEfficiencyType(resultSet3.getString(2));
					skill.setSkillefficiency_id(resultSet.getInt(4));
				}
				skills.add(skill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return skills;
	}

	/**
	 * @author kushagra.bhargava
	 * 
	 *         This method will take a project object as argument This method
	 *         will convert the project object into query string
	 */

	@Override
	public void saveNewProject(Project project) {
		try {

			String sql = "insert into projectDetails(projectName , projectDuration) values('" + project.getProjectName()
					+ "','" + project.getProjectDuration() + "')";
			update(sql);
		} catch (Exception e) {
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

	/**
	 * @author kushagra.bhargava This method will take a sql string and process
	 *         the query for insert and update
	 * @param sql
	 */
	public void update(String sql) {
		try {
			// Connection connection = connectionUtil.getConnection();
			connection = source.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author kushagra.bhargava This method will take a sql string and process
	 *         the query for selection
	 * @param sql
	 */
	public ResultSet select(String sql) {
		ResultSet resultSet = null;
		try {
			// Connection connection = connectionUtil.getConnection();
			connection = source.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public Manager checkAuthorization(String name) {
		// TODO Auto-generated method stub
		//int check = 0;
		String sql = "select * from managerdetails where managerEmailId='" + name + "'";
		ResultSet resultSet = select(sql);
		Manager manager = null;
		try {
			if (resultSet != null)
				while (resultSet.next()) {

					if (name.equals(resultSet.getString("managerEmailId"))) {
						manager = new Manager();
						manager.setManagerId(resultSet.getInt(1));
						manager.setManagerName(resultSet.getString(2));
						manager.setManagerEmailId(resultSet.getString(3));
						manager.setRole(resultSet.getInt(4));
					}
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
		return manager;
	}

	@Override
	public List<Project> getAllProjects(String sql) {
		// TODO Auto-generated method stub
		List<Project> projects = new ArrayList<>();
		ResultSet resultSet = select(sql);
		try {
			
			
			while (resultSet.next()) {
				Project project = new Project();

				project.setProjectName(resultSet.getString("projectName"));
				project.setProjectDetails_Id(resultSet.getInt("projectDetails_Id"));
				project.setProjectDuration(resultSet.getString("projectDuration"));
				projects.add(project);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return projects;
	}

	@Override
	public void saveAllotedProject(String sql) {
		// TODO Auto-generated method stub
		try {
			update(sql);

		} catch (Exception e) {
			// TODO: handle exception
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

	/***
	 * @author phalguni.vatsa
	 */
	@Override
	public void addBaseLineInput(Employee employee) {

		try {
			String query = "Insert into baselineinputdetails (baselineInput, employeedetails_id) values('"
					+ employee.getBaseLineInput().getBaselineInputdetail() + "', '" + employee.getEmployeedetails_id()
					+ "')";
			System.out.println(query);
			update(query);
		} catch (Exception e) {
			// TODO: handle exception
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

	/**
	 * 
	 * Method to save the feedBack of employee
	 * 
	 * @author prakhar.jain
	 * @param Employee
	 * 
	 * 
	 */
	@Override
	public void saveFeedBack(Employee employee) {
		try {
			String sql = "INSERT INTO feedbackdetails (feedback,lastUpdatedManagerId,employeedetails_id) values('"
					+ employee.getFeedBack().getFeedbackComment() + "',"
					+ employee.getFeedBack().getLastUpdatedManagerId() + "," + employee.getEmployeedetails_id() + ")";
			update(sql);

		} catch (Exception e) {
			// TODO: handle exception
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

	/**
	 * Method to Update the feedBack of employee if given by another manager or
	 * the same manager
	 * 
	 * @param Employee
	 * @author prakhar.jain
	 */
	@Override
	public void updateFeedBack(Employee employee) {
		try {
			String sql = "UPDATE feedbackdetails SET feedback ='" + employee.getFeedBack().getFeedbackComment()
					+ "', lastUpdatedManagerId=" + employee.getFeedBack().getLastUpdatedManagerId()
					+ " WHERE `employeedetails_id`=" + employee.getEmployeedetails_id();
			update(sql);

		} catch (Exception e) {
			// TODO: handle exception
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
	public List<Grade> getAllGrades() {
		// TODO Auto-generated method stub
		List<Grade> grades = new ArrayList<Grade>();
		String sql = "SELECT * FROM grade";
		ResultSet resultSet = select(sql);
		try {
			while (resultSet.next()) {
				Grade grade = new Grade();
				grade.setGrade_id(resultSet.getInt(1));
				grade.setGradeValue(resultSet.getString(2));
				grades.add(grade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return grades;
	}

	@Override
	public void assignEmployeeGrade(Employee employee) {
		String sql="Insert into gradedetails(gradeId,employeedetails_id) values("+employee.getGrade().getGrade_id()+","+employee.getEmployeedetails_id()+")";
		update(sql);
	}

	@Override
	public List<Efficiency> getAllEfficiencies() {
		List<Efficiency> efficiencies=new ArrayList<>();
		String sql="Select * from skillefficiency";
		ResultSet resultSet= select(sql);
		Efficiency efficiency=null;
		try {
			while (resultSet.next()) {
				efficiency=new Efficiency();
				efficiency.setSkillefficiency_id(resultSet.getInt(1));
				efficiency.setEfficiencyType(resultSet.getString(2));
				efficiencies.add(efficiency);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (connection != null)
					connection.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	return efficiencies;
}

	@Override
	public void updateEmployeeEfficiency(Skill skill) {
		String sql="Update employeeskill set skillefficiency_id="+skill.getSkillefficiency_id()+" where skill_id="+skill.getSkill_id()+" and employeedetails_id="+skill.getEmployeedetails_id();
		update(sql);
	}

	@Override
	public void updateEmployeeGrade(Employee employee) {
		String sql="UPDATE gradedetails set gradeId="+employee.getGrade().getGrade_id()+" Where employeedetails_id="+employee.getEmployeedetails_id();
		update(sql);
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> skills=new ArrayList<>();
		String sql="Select * from skill";
		ResultSet resultSet=select(sql);
		try {
			while (resultSet.next()) {
				Skill skill=new Skill();
				skill.setSkill_id(resultSet.getInt(1));
				skill.setSkillName(resultSet.getString(2));
				skills.add(skill);
			}
		} catch (SQLException e) {
			try {
					if(connection!=null)
						connection.close();
					if(resultSet!=null){
						resultSet.close();
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
		}
		return skills;
	}

	 @Override
	    public void addNewSkill(Skill skill) {
	        String query= "insert into skill (skillName) values ('"+skill.getSkillName()+"')";
	        update(query);
	        
	    }
	 
	 @Override
		public void addEmployeeSkill(Skill skill) {
			String sql="INSERT INTO employeeskill(skill_id,employeedetails_id,skillefficiency_id) Values("+skill.getSkill_id()+","+skill.getEmployeedetails_id()+","+skill.getSkillefficiency_id()+")";
			update(sql);
		}
}
