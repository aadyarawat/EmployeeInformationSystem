package com.yash.EmployeeInformation.domain;

/**
 * @author prakhar.jain
 *
 */
/**
 * @author prakhar.jain
 *
 */
/**
 * @author prakhar.jain
 *
 */
public class FeedBack {
	
	private int feedback_id;
	private String feedbackComment;
	private String lastUpdatedManager;
	private int lastUpdatedManagerId;
	private int employeedetails_id;
	
	
	public int getEmployeedetails_id() {
		return employeedetails_id;
	}
	public void setEmployeedetails_id(int employeedetails_id) {
		this.employeedetails_id = employeedetails_id;
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getFeedbackComment() {
		return feedbackComment;
	}
	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}
	public String getLastUpdatedManager() {
		return lastUpdatedManager;
	}
	public void setLastUpdatedManager(String lastUpdatedManager) {
		this.lastUpdatedManager = lastUpdatedManager;
	}
	public int getLastUpdatedManagerId() {
		return lastUpdatedManagerId;
	}
	public void setLastUpdatedManagerId(int lastUpdatedManagerId) {
		this.lastUpdatedManagerId = lastUpdatedManagerId;
	}

	
	
	

}