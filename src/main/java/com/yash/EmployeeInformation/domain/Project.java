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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

}