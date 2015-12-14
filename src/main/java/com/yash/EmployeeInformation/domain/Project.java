package com.yash.EmployeeInformation.domain;

public class Project {

	private int projectDetails_Id;
	private String projectName;
	private String projectDuration;

	public Project() {

	}

	public Project(int projectDetails_Id, String projectName, String projectDuration) {
		this.projectDetails_Id = projectDetails_Id;
		this.projectName = projectName;
		this.projectDuration = projectDuration;
	}

	@Override
	public String toString() {
		return "Project [projectDetails_Id=" + projectDetails_Id + ", projectName=" + projectName + ", projectDuration="
				+ projectDuration + "]";
	}

	public int getProjectDetails_Id() {
		return projectDetails_Id;
	}

	public void setProjectDetails_Id(int projectDetails_Id) {
		this.projectDetails_Id = projectDetails_Id;
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

	
}
