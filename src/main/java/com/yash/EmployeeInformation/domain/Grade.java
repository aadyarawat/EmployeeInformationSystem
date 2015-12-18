package com.yash.EmployeeInformation.domain;

public class Grade {
	private int grade_id;
	private String gradeValue;
	private int employeedetails_id;

	public Grade() {

	}

	public Grade(int grade_id, String gradeValue, int employeedetails_id) {
		this.grade_id = grade_id;
		this.gradeValue = gradeValue;
		this.employeedetails_id = employeedetails_id;
	}

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	public String getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}

	public int getEmployeedetails_id() {
		return employeedetails_id;
	}

	public void setEmployeedetails_id(int employeedetails_id) {
		this.employeedetails_id = employeedetails_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeedetails_id;
		result = prime * result + ((gradeValue == null) ? 0 : gradeValue.hashCode());
		result = prime * result + grade_id;
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
		Grade other = (Grade) obj;
		if (employeedetails_id != other.employeedetails_id)
			return false;
		if (gradeValue == null) {
			if (other.gradeValue != null)
				return false;
		} else if (!gradeValue.equals(other.gradeValue))
			return false;
		if (grade_id != other.grade_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grade [grade_id=" + grade_id + ", gradeValue=" + gradeValue + ", employeedetails_id="
				+ employeedetails_id + "]";
	}

}
