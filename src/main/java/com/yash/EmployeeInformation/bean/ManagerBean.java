package com.yash.EmployeeInformation.bean;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.EmployeeInformation.domain.Efficiency;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Grade;
import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.domain.Skill;
import com.yash.EmployeeInformation.service.ManagerServiceLocal;

@ManagedBean
@SessionScoped
public class ManagerBean {

	@EJB
	ManagerServiceLocal managerService;

	private Employee employee;
	private List<Employee> employees;
	private String searchValueText;
	private String projectName;
	private String projectDuration;
	private String fileName;
	private List<Project> projects;
	private int projectDetails_Id = -1;
	private String feedbackcomment;
	private List<Project> unallocatedEmployeeProjects;
	private String selectedProjectName;
	private String[] selectedEmployees;
	private List<Grade> grades;
	private List<Efficiency> efficiencies;
	private List<Skill> skills;
	private Skill skill;
	private int efficiency_id;
	private int grade_id;
	private int skill_id;
	private int addEfficiency_id;
	private String skillName;

	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getAddEfficiency_id() {
		return addEfficiency_id;
	}

	public void setAddEfficiency_id(int addEfficiency_id) {
		this.addEfficiency_id = addEfficiency_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public List<Skill> getSkills() {
		skills = managerService.getAllSkills();
		List<Skill> employeeSkills = employee.getSkills();
		skills.removeAll(employeeSkills);
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	public int getEfficiency_id() {
		return efficiency_id;
	}

	public void setEfficiency_id(int efficiency_id) {
		this.efficiency_id = efficiency_id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public List<Efficiency> getEfficiencies() {
		efficiencies = managerService.getAllEfficiencies();
		return efficiencies;
	}

	public void setEfficiencies(List<Efficiency> efficiencies) {
		this.efficiencies = efficiencies;
	}

	public List<Grade> getGrades() {
		grades = managerService.getAllGrades();
		System.out.println(grades);
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Project> getUnallocatedEmployeeProjects() {
		List<Project> projectAccordingToEmp = employee.getProjects();
		unallocatedEmployeeProjects = getProjects();
		unallocatedEmployeeProjects.removeAll(projectAccordingToEmp);
		return unallocatedEmployeeProjects;
	}

	public void setUnallocatedEmployeeProjects(List<Project> unallocatedEmployeeProjects) {
		this.unallocatedEmployeeProjects = unallocatedEmployeeProjects;
	}

	public String getSelectedProjectName() {
		return selectedProjectName;
	}

	public void setSelectedProjectName(String selectedProjectName) {
		this.selectedProjectName = selectedProjectName;
	}

	public String[] getSelectedEmployees() {
		return selectedEmployees;
	}

	public void setSelectedEmployees(String[] selectedEmployees) {
		this.selectedEmployees = selectedEmployees;
	}

	public String getFeedbackcomment() {
		return feedbackcomment;
	}

	public void setFeedbackcomment(String feedbackcomment) {
		this.feedbackcomment = feedbackcomment;
	}

	// Check 1.
	public List<Project> getProjects() {
		projects = managerService.getAllProjects();
		System.out.println(projects);
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getProjectDetails_Id() {
		return projectDetails_Id;
	}

	public void setProjectDetails_Id(int projectDetails_Id) {
		this.projectDetails_Id = projectDetails_Id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public String getSearchValueText() {
		return searchValueText;
	}

	public void setSearchValueText(String searchValueText) {
		this.searchValueText = searchValueText;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * 
	 * @author pratik.sethia
	 * @return List of employee with particular name
	 */
	public String searchEmployeeByName() {
		if (searchValueText.equalsIgnoreCase("")) {
			employees = null;
			return "welcomeManager.xhtml?faces-redirect=true&error=Please Enter the Search Value!";

		} else {
			employees = managerService.searchEmployeeByName(searchValueText);
			
			if(employees.isEmpty()){
				return "welcomeManager.xhtml?faces-redirect=true&error=Sorry! No match found";
				
			}
		}
		projectDetails_Id = 0;
		
		return "welcomeManager.xhtml?faces-redirect=true&error=";
	}

	/**
	 * @author kushagra.bhargava This method will save the project details to
	 *         the database. It sends the object of project to the service
	 *         layer.
	 * @return a string for the page redirection
	 */
	public String saveProject() {
		System.out.println(projectName + " " + projectDuration);
		if (projectName.equalsIgnoreCase("") || projectDuration.equalsIgnoreCase("")) {
			if (projectName.equalsIgnoreCase("")) {
				if (projectDuration.equalsIgnoreCase("")) {
					return "allProjects.xhtml?faces-redirect=true&message=Enter Project Name and Project Duration";
				} else {
					return "allProjects.xhtml?faces-redirect=true&message=Enter Project Name";
				}
			} else {
				return "allProjects.xhtml?faces-redirect=true&message=Enter Project Duration";

			}
		} else {
			Set<Project> projectsSet = new HashSet<>(projects);

			Project project = new Project(0, projectName, projectDuration);
			boolean result = projectsSet.add(project);
			if (result == true) {

				managerService.createNewProject(project);
				return "allProjects.xhtml?faces-redirect=true&message=Project Details Saved Successfully";
			}
			return "allProjects.xhtml?faces-redirect=true&message=Project Already Exists";

		}

	}

	public String showAllEmployee() {
		employees = managerService.getAllEmployees();
		searchValueText = null;
		return null;
	}

	/**
	 * @author mayank.yadav allotproject will assign the project to the employee
	 * @return
	 */
	public String allotProject() {
		managerService.allocateProject(projectDetails_Id, employee.getEmployeedetails_id());
		employee = managerService.getEmployee(employee.getEmployeedetails_id());
		unallocatedEmployeeProjects = getUnallocatedEmployeeProjects();
		employees = managerService.getAllEmployees();
		return "ShowEmployeeDetails.xhtml";
	}

	/**
	 * @author pratik.sethia download a particular employees resume file for a
	 *         manager
	 * @return
	 */
	public String downloadFile() {

		String exception;
		String finalFinalName = null;
		try {

			System.out.println("File name>>>>>>>>>>>>>>>>>>" + fileName);

			int index = fileName.lastIndexOf("@");
			finalFinalName = fileName.substring(0, index);
			System.out.println(finalFinalName);

			String PDF_URL = "file://///YITRNG06DT/uploaded/" + finalFinalName + ".doc";
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

			// Set response headers
			response.reset(); // Reset the response in the first place
			response.setHeader("Content-Disposition", "attachment;filename=" + finalFinalName);
			response.setContentType("application/msword");
			// Set
			// only
			// the
			// content type

			// Open response output stream
			OutputStream responseOutputStream = response.getOutputStream();

			// Read Sample contents
			URL url = new URL(PDF_URL);
			InputStream InputStream = url.openStream();
			// Read contents and write them to the output
			byte[] bytesBuffer = new byte[8192];
			int bytesRead;
			while ((bytesRead = InputStream.read(bytesBuffer)) > 0) {
				responseOutputStream.write(bytesBuffer, 0, bytesRead);
			}

			// Make sure that everything is out
			responseOutputStream.flush();

			// Close both streams
			InputStream.close();
			responseOutputStream.close();

			// JSF doc:
			// Signal the JavaServer Faces implementation that the HTTP response
			// for
			// this request has already been generated
			// (such as an HTTP redirect), and that the request processing
			// lifecycle
			// should be terminated
			// as soon as the current phase is completed.
			facesContext.responseComplete();

			return "welcomeManager.xhtml?faces-redirect=true&error=";
		} catch (Exception ex) {
			exception = "Resume is not uploaded by " + finalFinalName;
			return "welcomeManager.xhtml?faces-redirect=true&error=" + exception;
		}
		// return "welcomeManager.xhtml?faces-redirect=true&error=" + exception;
	}

	/***
	 * 
	 * @author phalguni.vatsa
	 */
	public String retrieveEmployeeDetail() {
		Employee employee = (Employee) managerService.getAllEmployees();
		System.out.println(employee);
		return "ShowEmployeeDetails.xhtml";
	}

	/***
	 * 
	 * @author phalguni.vatsa
	 */
	public String addBaseLineInput() {
		managerService.addBaseLineInput(employee);
		return null;
	}

	/**
	 * Method Used to save feedBack for the particular employee
	 * 
	 * @author prakhar.jain
	 * @return
	 */
	public String saveFeedBack() {
		if (employee.getFeedBack().getFeedbackComment() == null) {
			Manager manager = (Manager) session.getAttribute("manager");
			employee.getFeedBack().setFeedbackComment(feedbackcomment+" @"+manager.getManagerName());
			employee.getFeedBack().setLastUpdatedManagerId(manager.getManagerId());
			employee = managerService.saveFeedBack(employee);
			employees = managerService.getAllEmployees();
			feedbackcomment = "";
		} else {
			Manager manager = (Manager) session.getAttribute("manager");
			employee.getFeedBack()
					.setFeedbackComment(employee.getFeedBack().getFeedbackComment().concat("| " + feedbackcomment+" @"+manager.getManagerName()));
			employee.getFeedBack().setLastUpdatedManagerId(manager.getManagerId());
			employee = managerService.updateFeedBack(employee);
			employees = managerService.getAllEmployees();
			feedbackcomment = "";
		}
		return null;
	}

	public String assignProjectToEmployee() {
		System.out.println(projectDetails_Id + " " + employee.getEmail());
		managerService.allocateProject(projectDetails_Id, employee.getEmployeedetails_id());
		employees.remove(employee);
		return null;
	}

	public void getUnallocatedProjectEmployees(ValueChangeEvent event) {
		projectDetails_Id = Integer.parseInt(event.getNewValue().toString());
		if (projectDetails_Id != -1) {
			employees = managerService.getUnallocatedProjectEmployees(projectDetails_Id);
		} else {
			employees = null;
			projectDetails_Id = -1;
		}
		projectDetails_Id = -1;
	}

	public String projectAllocation() {
		projectDetails_Id = -1;
		employees = null;
		return "allProjects.xhtml";
	}

	public String assignEmployeeGrade() {
		if (employee.getGrade().getGrade_id() == 0) {
			employee.getGrade().setGrade_id(grade_id);
			managerService.assignEmployeeGrade(employee);
			employee = managerService.getEmployee(employee.getEmployeedetails_id());
			employees = managerService.getAllEmployees();
		} else {
			employee.getGrade().setGrade_id(grade_id);
			managerService.updateEmployeeGrade(employee);
			employee = managerService.getEmployee(employee.getEmployeedetails_id());
			employees = managerService.getAllEmployees();
		}
		return null;
	}

	public String updateSkillEfficiency() {
		skill.setSkillefficiency_id(efficiency_id);
		managerService.updateEmployeeSkill(skill);
		employee = managerService.getEmployee(employee.getEmployeedetails_id());
		employees = managerService.getAllEmployees();
		return null;
	}

	public String addNewSkill() {
		Skill skill = new Skill();
		skill.setSkillName(skillName);
		List<Skill> skills = managerService.getAllSkills();
		if (skillName.equalsIgnoreCase("")) {

			return "welcomeManager.xhtml?faces-redirect=true&error=Please Enter Skill!";
		}
		for (Skill skill2 : skills) {
			if (skill2.getSkillName().equalsIgnoreCase(skill.getSkillName())) {
				return "welcomeManager.xhtml?faces-redirect=true&error=Skill Already Exists!";
			}
		}
		managerService.addNewSkill(skill);
		return "welcomeManager.xhtml?faces-redirect=true&error=Skill Added Successfully!";
	}
	
	public String addEmployeeSkill(){
		skill=new Skill();
		skill.setSkill_id(skill_id);
		skill.setSkillefficiency_id(addEfficiency_id);
		skill.setEmployeedetails_id(employee.getEmployeedetails_id());
		managerService.addEmployeeSkill(skill);
		employee=managerService.getEmployee(employee.getEmployeedetails_id());
		employees=managerService.getAllEmployees();
		return null;
		}

	public String BackToWelcomeManager(){
		employees=null;
		return "welcomeManager.xhtml?faces-redirect=true";
	}
	
	
	
}