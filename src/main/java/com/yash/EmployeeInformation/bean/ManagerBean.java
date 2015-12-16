package com.yash.EmployeeInformation.bean;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.yash.EmployeeInformation.domain.Employee;
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
	private int projectDetails_Id;

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
		} else {
			employees = managerService.searchEmployeeByName(searchValueText);
		}

		return null;

	}

	/**
	 * @author kushagra.bhargava This method will save the project details to
	 *         the database. It sends the object of project to the service
	 *         layer.
	 * @return a string for the page redirection
	 */
	public String saveProject() {
		Project project = new Project(0, projectName, projectDuration);
		managerService.createNewProject(project);
		return "projectDetails.xhtml?faces-redirect=true";
	}

	/**
	 * @author pratik.sethia
	 * 
	 *         This method will populate the list of the employee on the loading
	 *         of the page.
	 */
	@PostConstruct
	public void getAllEmployeesList() {
		employees = managerService.getAllEmployees();
	}

	public String showAllEmployee() {
		employees = managerService.getAllEmployees();
		return null;
	}

	public String addEmployeeToProject() {
		System.out.println("hello");
		return "#";
	}

	/**
	 * @author mayank.yadav 
	 *	allotproject will assign the project to the employee
	 * @return
	 */
	public String allotProject() {
		// pending task
		// get the emplyeedetails_id from employeeObject
		System.out.println("allot");
		managerService.allocateProject(projectDetails_Id, employee.getEmployeedetails_id());

		return "ShowEmployeeDetails.xhtml";
	}

	/**
	 * @author pratik.sethia
	 * 	download a particular employees resume file for a manager
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

			return "welcomeManager.xhtml?faces-redirect=true";
		} catch (Exception ex) {
			exception = "Resume is not uploaded by " + finalFinalName;
		}
		return "welcomeManager.xhtml?faces-redirect=true&error=" + exception;
	}
}
