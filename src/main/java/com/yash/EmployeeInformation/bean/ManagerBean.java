package com.yash.EmployeeInformation.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Project;
import com.yash.EmployeeInformation.service.ManagerServiceLocal;

@ManagedBean
@SessionScoped
public class ManagerBean {

	@EJB
	ManagerServiceLocal managerService;

	private List<Employee> employees;
	private String searchValueText;
	private String projectName;
	private String projectDuration;
	private String recievedEmail;
	
	
	public String getRecievedEmail() {
		return recievedEmail;
	}

	public void setRecievedEmail(String recievedEmail) {
		this.recievedEmail = recievedEmail;
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

	
	public String showAllEmployee(){
		employees = managerService.getAllEmployees();
		return null;
	}
	
	public String downloadFile()  {
		try{
			
			System.out.println("File name>>>>>>>>>>>>>>>>>>" +recievedEmail);
			String PDF_URL = "file://///YITRNG06DT/uploaded/"+ recievedEmail+".doc";
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			
			
			
			// Set response headers
			response.reset(); // Reset the response in the first place
			response.setHeader("Content-Disposition", "attachment;filename=" + recievedEmail); 
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
			//new FileInputStream(url.getPath());
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
			// Signal the JavaServer Faces implementation that the HTTP response for
			// this request has already been generated
			// (such as an HTTP redirect), and that the request processing lifecycle
			// should be terminated
			// as soon as the current phase is completed.
			facesContext.responseComplete();
			
			return null;
		}catch(Exception ex){
			
		}
		return null;
	}
	

}
