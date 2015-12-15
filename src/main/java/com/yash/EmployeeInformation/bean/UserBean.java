package com.yash.EmployeeInformation.bean;

import java.util.Hashtable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpSession;

import com.yash.EmployeeInformation.service.ManagerServiceLocal;



@ManagedBean
@SessionScoped
public class UserBean {
	private Boolean check;
	private String name;
	private String password;
	
	@EJB
	ManagerServiceLocal managerService;
	
	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
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
	
	public String authenticate(){
	check=getConnection(name, password);
	if(check==false){
		return "index.xhtml?faces-redirect=true&error=Invalid UserName And Password";
	}
	else{	
		session.setAttribute("SessionEmail", name);
		String checkAuthorize=managerService.checkAuthorization(name);
		if("manager".equalsIgnoreCase(checkAuthorize)){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>hello"+name);
			return "welcomeManager.xhtml";
		}
		return "welcome.xhtml";
	}
	
	}
	
	
	public boolean getConnection(String ldapUsername,String ldapPassword )
	{
			
		final  String ldapAdServer ="ldap://inidradc01.yash.com/";
       
		 Hashtable<String, Object> env = new    Hashtable<String, Object>();
	       
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        
        if(ldapUsername != null) 
        {
            env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
        }
        if(ldapPassword != null) 
        {
            env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
        }
        
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapAdServer);

        env.put("java.naming.ldap.attributes.binary", "objectSID");
        env.put(Context.REFERRAL,"follow");
        
       try
       {
    	   @SuppressWarnings("unused")
    	   DirContext ctx = new InitialDirContext(env);

    	   return true;
       }
       catch(Exception e)
       {

    	   return false;
    	   
       }
	}
	
}
