package com.yash.EmployeeInformation.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	@EJB
	private EmployeeServiceLocal employeeServiceLocal;
	private FacesContext facesContext = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
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
	private int skillNameId;
	private int skillEfficiencyId;
	private List<Skill> skillList;
	private List<Skill> skillEfficiencyList;
	private String checkEmployee;
	private String disableTab;
	private List<Skill> employeeSkills = new ArrayList<>();
	private Employee employee = new Employee();
	private Employee oldEmployee = null;
	private Employee sessionEmployee = null;
	private int selectdefault;
	private int recId;

	public int getSelectdefault() {
		return selectdefault;
	}
	public void setSelectdefault(int selectdefault) {
		this.selectdefault = selectdefault;
	}
	public String getDisableTab() {
		return disableTab;
	}
	public void setDisableTab(String disableTab) {
		this.disableTab = disableTab;
	}
	public String getCheckEmployee() {
		// TODO Auto-generated method stub
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
	public int getSkillNameId() {
		return skillNameId;
	}
	public void setSkillNameId(int skillNameId) {
		this.skillNameId = skillNameId;
	}
	public int getSkillEfficiencyId() {
		return skillEfficiencyId;
	}
	public void setSkillEfficiencyId(int skillEfficiencyId) {
		this.skillEfficiencyId = skillEfficiencyId;
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
		if(sessionEmployee!=null){
			if(sessionEmployee.getAddress().getHouseNo()!=0){
				houseNo=sessionEmployee.getAddress().getHouseNo();
			}
		}
		if (oldEmployee != null) {
			houseNo = oldEmployee.getAddress().getHouseNo();
		}
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getAddress().getStreetName()!=null){
				streetName=sessionEmployee.getAddress().getStreetName();
			}
		}
		if (oldEmployee != null) {
			streetName = oldEmployee.getAddress().getStreetName();
		}
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getAddress().getCity()!=null){
				city=sessionEmployee.getAddress().getCity();
			}
		}
		if (oldEmployee != null) {
			city = oldEmployee.getAddress().getCity();
		}
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getAddress().getState()!=null){
				state=sessionEmployee.getAddress().getState();
			}
		}
		if (oldEmployee != null) {
			state = oldEmployee.getAddress().getState();
		}
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getAddress().getPincode()!=null){
				pincode=sessionEmployee.getAddress().getPincode();
			}
		}
		if (oldEmployee != null) {
			pincode = oldEmployee.getAddress().getPincode();
		}
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobile() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getMobile()!=null){
				mobile=sessionEmployee.getMobile();
			}
		}
		if (oldEmployee != null) {
			mobile = oldEmployee.getMobile();
		}
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAlternate_mobile() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getAlternate_mobile()!=null){
				alternate_mobile=sessionEmployee.getAlternate_mobile();
			}
		}
		if (oldEmployee != null) {
			alternate_mobile = oldEmployee.getAlternate_mobile();
		}
		return alternate_mobile;
	}
	public void setAlternate_mobile(String alternate_mobile) {
		this.alternate_mobile = alternate_mobile;
	}
	public Address getAddress() {
		if (oldEmployee != null) {
			address = oldEmployee.getAddress();
		}
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFirstname() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getFirstName()!=null){
				firstname=sessionEmployee.getFirstName();
			}
		}
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
		if(sessionEmployee!=null){
			if(sessionEmployee.getLastName()!=null){
				firstname=sessionEmployee.getLastName();
			}
		}
		if (oldEmployee != null) {
			lastname = oldEmployee.getLastName();
		}
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		recId = employeeServiceLocal.getRegisteredEmpid((String) session.getAttribute("eusername"));
		String sessionEmailValue = (String) session.getAttribute("eusername");
		return sessionEmailValue;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmployeeId() {
		if(sessionEmployee!=null){
			if(sessionEmployee.getYashEmployeeId()!=0){
				employeeId=sessionEmployee.getYashEmployeeId();
			}
		}
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
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public List<Skill> getEmployeeSkills() {
		employeeSkills = employeeServiceLocal.getEmployeeSkills(recId);
		return employeeSkills;
	}
	public void setEmployeeSkills(List<Skill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}
	public String dataSave() {
		/***
		 * @author deepak.vishwakarma
		 * provide sample file to download
		 */
		if (checkEmployee.equals("Edit")) {
			if (firstname == null || lastname == null || email == null || employeeId == 0 || mobile == null) {
				return "welcome.xhtml?employeemessange=Please Fill All Entries&faces-redirect=true";
			}
			if (firstname.equals("") || lastname.equals("") || email.equals("") || employeeId == 0
					|| mobile.equals("")) {
				return "welcome.xhtml?employeemessange=Please Fill All Entries&faces-redirect=true";
			}
			recId = employeeServiceLocal.getRegisteredEmpid((String) session.getAttribute("eusername"));
			employee.setEmployeedetails_id(recId);
			employee.setFirstName(firstname);
			employee.setLastName(lastname);
			employee.setAlternate_mobile(alternate_mobile);
			employee.setEmail(email);
			employee.setYashEmployeeId(employeeId);
			employee.setMobile(mobile);
			String checkemployee = employeeServiceLocal.updateEmployee(employee);
			employee.getAddress().setCity(city);
			employee.getAddress().setHouseNo(houseNo);
			employee.getAddress().setStreetName(streetName);
			employee.getAddress().setState(state);
			employee.getAddress().setPincode(pincode);
			String checkaddress = employeeServiceLocal.editEmployeeAddress(recId, employee);
			if (!checkemployee.equals("success"))
				return "welcome.xhtml?employeemessange=" + checkemployee + "&faces-redirect=true";
			if (!checkaddress.equals("success"))
				return "welcome.xhtml?employeemessange=" + checkaddress + "&faces-redirect=true";
			return "welcome.xhtml?employeemessange=Details Updated Successful&faces-redirect=true";
		} else {
			if (firstname == null || lastname == null || email == null || employeeId == 0 || mobile == null)
				return "welcome.xhtml?employeemessange=Please fill all null&faces-redirect=true";
			if (firstname.equals("") || lastname.equals("") || email.equals("") || employeeId == 0
					|| mobile.equals("")) {
				System.out.println(
						"firstname->" + firstname + "  lastname->" + lastname + "  email->" + email + " emlpoyeeid->"
								+ employeeId + "   mobile->" + mobile + " alternate number->" + alternate_mobile);
				return "welcome.xhtml?employeemessange=Please fill all enteries&faces-redirect=true";
			}
			employee.setFirstName(firstname);
			employee.setLastName(lastname);
			employee.setAlternate_mobile(alternate_mobile);
			employee.setEmail(email);
			employee.setYashEmployeeId(employeeId);
			employee.setMobile(mobile);
			String checkemployee = employeeServiceLocal.register(employee);
			recId = employeeServiceLocal.getRegisteredEmpid((String) session.getAttribute("eusername"));
			employee.setEmployeedetails_id(recId);
			employee.getAddress().setCity(city);
			employee.getAddress().setHouseNo(houseNo);
			employee.getAddress().setStreetName(streetName);
			employee.getAddress().setState(state);
			employee.getAddress().setPincode(pincode);
			String checkaddress = employeeServiceLocal.saveEmployeeAddress(recId, employee);
			if (!checkemployee.equals("success")){
				sessionEmployee = employee;
				session.setAttribute("sesssionEmployee", sessionEmployee);
				return "welcome.xhtml?employeemessange=" + checkemployee + "&faces-redirect=true";
			}
			if (!checkaddress.equals("success")){
				sessionEmployee = employee;
				session.setAttribute("sesssionEmployee", sessionEmployee);
				return "welcome.xhtml?employeemessange=" + checkaddress + "&faces-redirect=true";
			}
			return "welcome.xhtml?employeemessange=Successfully Added Details&faces-redirect=true";
		}
	}
	public String addSkillAndEfficiency() {
		// save skill and efficiency of employee to db
		if (skillNameId == 0 && skillEfficiencyId == 0)
			return "welcome.xhtml?skillmessage=Please Select Skill And Efficiency&faces-redirect=true";
		if (skillNameId == 0)
			return "welcome.xhtml?skillmessage=Please Select a Skill&faces-redirect=true";
		if (skillEfficiencyId == 0)
			return "welcome.xhtml?skillmessage=Please Select a Efficiency&faces-redirect=true";
		for (Skill skill : employeeSkills) {
			if (skillNameId == skill.getSkill_id()) {
				return "welcome.xhtml?skillmessage=Skill Already Exist!! Please Select Another Skill&faces-redirect=true";
			}
		}
		String checkskill = employeeServiceLocal.addEmployeeSkillAndEfficiency(skillNameId, skillEfficiencyId, recId);
		if (!checkskill.equals("success"))
			return "welcome.xhtml?skillmessage=Skill Not Saved!!! Try Again&faces-redirect=true";
		return "welcome.xhtml?skillmessage=Skill Added Successfully&faces-redirect=true";
	}
	public Employee helper() {
		// helper to get already existing employee
		String sessionEmailValue = (String) session.getAttribute("eusername");
		oldEmployee = employeeServiceLocal.getEmployeeDetail(sessionEmailValue);
		return oldEmployee;
	}
	public String deleteEmployeeSkill() {
		/***
		 * @author deepak.vishwakarma
		 * delete employee's skill from db  
		 */
		Map<String, String> requestparams = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		String skillid = (String) requestparams.get("skillid");
		String efficiencyid = (String) requestparams.get("efficiencyid");
		String check = employeeServiceLocal.deleteEmployeeSkill(Integer.parseInt(skillid),
				Integer.parseInt(efficiencyid), recId);
		if (!check.equals("success"))
			return "welcome.xhtml?skillmessage=" + check + "&faces-redirect=true";
		return "welcome.xhtml?skillmessage=Delete successfull&faces-redirect=true";
	}
}