package com.yash.EmployeeInformation.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.EmployeeInformation.domain.Address;
import com.yash.EmployeeInformation.domain.Employee;
import com.yash.EmployeeInformation.domain.Skill;
import com.yash.EmployeeInformation.service.EmployeeServiceLocal;

/**
 * 
 * @author aadya.rawat
 *
 */

@ManagedBean
@SessionScoped
public class EmployeeBean {

	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

	private String name;
	private String password;
	private Address address;
	private int employeeId;
	private String alternate_mobile;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private int houseNo;
	private String streetName;
	private String city;
	private String state;
	private String pincode;
	private String skillName;
	private String skillEfficiency;
	private List<Skill> skillList;
	private List<Skill> skillEfficiencyList;
	private String checkEmployee;
	private String disableTab;
	Employee employee = new Employee();
	Employee oldEmployee = null;

	public String getDisableTab() {
		return disableTab;
	}

	public void setDisableTab(String disableTab) {
		this.disableTab = disableTab;
	}

	public String getCheckEmployee() {
		if (recId != 0) {
			checkEmployee = "Edit";
			disableTab = "";
		} else {
			checkEmployee = "Save";
			disableTab = "ui-state-disabled";
		}

		return checkEmployee;
	}

	public void setCheckEmployee(String checkEmployee) {
		this.checkEmployee = checkEmployee;
	}

	@EJB
	EmployeeServiceLocal employeeServiceLocal;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillEfficiency() {
		return skillEfficiency;
	}

	public void setSkillEfficiency(String skillEfficiency) {
		this.skillEfficiency = skillEfficiency;
	}

	public List<Skill> getSkillList() {
		skillList = employeeServiceLocal.getSkillList();
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public List<Skill> getSkillEfficiencyList() {
		skillEfficiencyList = employeeServiceLocal.getSkillEfficiencyList();
		return skillEfficiencyList;
	}

	public void setSkillEfficiencyList(List<Skill> skillEfficiencyList) {
		this.skillEfficiencyList = skillEfficiencyList;
	}

	public int getHouseNo() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			houseNo = oldEmployee.getAddress().getHouseNo();
		}

		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			streetName = oldEmployee.getAddress().getStreetName();
		}

		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			city = oldEmployee.getAddress().getCity();
		}

		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			state = oldEmployee.getAddress().getState();
		}

		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			pincode = oldEmployee.getAddress().getPincode();
		}
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobile() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			mobile = oldEmployee.getMobile();
		}

		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlternate_mobile() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			alternate_mobile = oldEmployee.getAlternate_mobile();
		}

		return alternate_mobile;
	}

	public void setAlternate_mobile(String alternate_mobile) {
		this.alternate_mobile = alternate_mobile;
	}

	public Address getAddress() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			address = oldEmployee.getAddress();
		}

		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstname() {
		oldEmployee = helper();
		if (oldEmployee != null) {
			firstname = oldEmployee.getFirstName();
		}
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			lastname = oldEmployee.getLastName();
		}

		return lastname;
	}

	public void setLastname(String lastname) {

		this.lastname = lastname;
	}

	public String getEmail() {
		// helper();
		recId = employeeServiceLocal.getRegisteredEmpid((String) session.getAttribute("eusername"));
		String sessionEmailValue = (String) session.getAttribute("eusername");
		return sessionEmailValue;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployeeId() {
		// oldEmployee = helper();
		if (oldEmployee != null) {

			employeeId = oldEmployee.getYashEmployeeId();
		}

		return employeeId;
	}

	public void setEmployeeId(int employeeId) {

		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	int recId;

	public int getRecId() {
		/*
		 * recId =
		 * employeeServiceLocal.getRegisteredEmpid((String)session.getAttribute(
		 * "eusername")); System.out.println(recId);
		 */
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public String dataSave() {

		if (checkEmployee.equals("Edit")) {
			recId = employeeServiceLocal.getRegisteredEmpid((String) session.getAttribute("eusername"));
			employee.setEmployeedetails_id(recId);
			employee.setFirstName(firstname);
			employee.setLastName(lastname);
			employee.setAlternate_mobile(alternate_mobile);
			employee.setEmail(email);
			employee.setYashEmployeeId(employeeId);
			employee.setMobile(mobile);
			employeeServiceLocal.updateEmployee(employee);
			System.out.println("update call-------for employee--");
			employee.getAddress().setCity(city);
			employee.getAddress().setHouseNo(houseNo);
			employee.getAddress().setStreetName(streetName);
			employee.getAddress().setState(state);
			employee.getAddress().setPincode(pincode);
			employeeServiceLocal.editEmployeeAddress(recId, employee);
			System.out.println("update call------for address---");
			return "welcome.xhtml?employeemessange=Updated Your Details&faces-redirect=true";
		} else {
			employee.setFirstName(firstname);
			employee.setLastName(lastname);
			employee.setAlternate_mobile(alternate_mobile);
			employee.setEmail(email);
			employee.setYashEmployeeId(employeeId);
			employee.setMobile(mobile);
			employeeServiceLocal.register(employee);
			recId = employeeServiceLocal.getRegisteredEmpid((String) session.getAttribute("eusername"));
			employee.setEmployeedetails_id(recId);
			System.out.println("INSIDE SAVE -------------" + recId);
			employee.getAddress().setCity(city);
			employee.getAddress().setHouseNo(houseNo);
			employee.getAddress().setStreetName(streetName);
			employee.getAddress().setState(state);
			employee.getAddress().setPincode(pincode);
			employeeServiceLocal.saveEmployeeAddress(recId, employee);
			return "welcome.xhtml?employeemessange=Successfully Added Details&faces-redirect=true";

		}

	}

	public String addSkillAndEfficiency() {
		System.out.println("ADD AND EFFIC +CELLED");
		System.out.println("SKILL NAME ---------" + skillName);
		System.out.println("SKILL Efficiency NAME ---------" + skillEfficiency);
		System.out.println("SKILL ID FROM EMAIL ---------" + recId);
		employeeServiceLocal.addEmployeeSkillAndEfficiency(skillName, skillEfficiency, recId);
		return "welcome.xhtml?skillmessage=Successfully Added &faces-redirect=true";

	}

	public Employee helper() {
		String sessionEmailValue = (String) session.getAttribute("eusername");
		oldEmployee = employeeServiceLocal.getEmployeeDetail(sessionEmailValue);
		return oldEmployee;
	}

}
