package com.yash.EmployeeInformation.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.yash.EmployeeInformation.domain.Manager;
import com.yash.EmployeeInformation.service.ManagerServiceLocal;
import com.yash.EmployeeInformation.service.UserServiceLocal;

@ManagedBean
@SessionScoped
public class UserBean {
	@EJB
	ManagerServiceLocal managerService;

	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

	private Boolean check;
	private String name;
	private String password;
	private Part file;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
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

	public String authenticate() {
		check = getConnection(name, password);
		if (check == false) {
			return "index.xhtml?faces-redirect=true&error=Invalid UserName And Password";
		} else {
			session.setAttribute("eusername", name);
			Manager manager = managerService.checkAuthorization(name);
			if (manager != null) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>hello" + name);
				session.setAttribute("manager", manager);

				return "welcomeManager.xhtml";
			}
			return "welcome.xhtml";
		}

	}

	public boolean getConnection(String ldapUsername, String ldapPassword) {

		final String ldapAdServer = "ldap://inidradc01.yash.com/";

		Hashtable<String, Object> env = new Hashtable<String, Object>();

		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		if (ldapUsername != null) {
			env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
		}
		if (ldapPassword != null) {
			env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
		}

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapAdServer);

		env.put("java.naming.ldap.attributes.binary", "objectSID");
		env.put(Context.REFERRAL, "follow");

		try {
			@SuppressWarnings("unused")
			DirContext ctx = new InitialDirContext(env);

			return true;
		} catch (Exception e) {

			return false;

		}
	}

	public String logout() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
		httpSession.invalidate();
		return "index.xhtml";
	}

	/***
	 * @author deepak.vishwakarma
	 */

	public String downloadFile() throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance(); // Get
																		// HTTP
																		// response
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		response.setHeader("Content-Disposition", "attachment;filename=" + "SampleResume.docx");
		response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		// Get the FacesContext FacesContext
		facesContext = FacesContext.getCurrentInstance();
		// Set response headers response.reset();
		// Reset the response in the first place
		// Set only the content type
		// Open response output stream
		String filename = "SampleResume.doc";
		response.setHeader("Content-Disposition", "attachment;filename=" + "SampleResume.doc");
		OutputStream responseOutputStream = response.getOutputStream();
		String realpath = (String) FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");

		// -----------------RND Begin-----------------

		// String contextpathfilepath = (String)
		// FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
		URL realfilepath = this.getClass().getResource("");
		String newpath = realfilepath.getPath().substring(0, realfilepath.getPath().length() - 1);
		String newpath1 = newpath;
		int i1 = 0;
		if (-1 != newpath.lastIndexOf("\\"))
			i1 = newpath.lastIndexOf("\\");
		newpath1 = newpath.substring(0, i1);
		// File newfile = new File(contextpathfilepath);
		System.out.println("-------context path----->" + newpath1);

		// -----------------RND End-----------------

		int index = realpath.lastIndexOf("\\");
		String path = realpath.substring(0, index + 1);
		File dir = new File(path + "sample");
		dir.mkdirs();
		// Read Sample contents
		File url = new File(dir.getAbsolutePath() + "\\" + filename);
		InputStream inputStream = new FileInputStream(url.getPath());
		// Read contents and write them to the output
		byte[] bytesBuffer = new byte[8192];
		int bytesRead;
		while ((bytesRead = inputStream.read(bytesBuffer)) > 0) {
			responseOutputStream.write(bytesBuffer, 0, bytesRead);
		}
		// Make sure that everything is out responseOutputStream.flush();
		// Close both streams InputStream.close(); responseOutputStream.close();
		// JSF doc:
		// Signal the JavaServer Faces implementation that theHTTP response for
		// this request has already been generated
		// (suchas an HTTP redirect), and that the request processing lifecycle
		// should be terminated
		// as soon as the current phase is completed.
		facesContext.responseComplete();
		return null;
	}

	/***
	 * @author Deepak.vishwakarma
	 * @return
	 */
	@EJB
	UserServiceLocal userService;

	public String uploadFile() {
		Part uploadedFile = getFile();
		if (uploadedFile == null) {
			return "welcome.xhtml?uploadmessage=please select a file to upload&faces-redirect=true";
		}
		String filename = getSubmittedFileName(uploadedFile);
		int lastindex = filename.lastIndexOf(".");
		String filetype = filename.substring(lastindex + 1, lastindex + 4);
		if (filetype.equals("doc")) {
			String uploadmessage = helpUpload();
			return "welcome.xhtml?uploadmessage=" + uploadmessage + "&faces-redirect=true";
		} else {
			return "welcome.xhtml?uploadmessage=please upload a valid word document&faces-redirect=true";
		}
	}

	public String helpUpload() {
		Part uploadedFile = getFile();
		File dir = new File("\\\\YITRNG06DT\\uploaded");
		dir.mkdirs();
		String filename = "sample";
		if (null != session.getAttribute("eusername"))
			filename = (String) session.getAttribute("eusername");
		int index = filename.lastIndexOf("@");
		String finalfilename = filename;
		if (index != -1)
			finalfilename = filename.substring(0, index);
		final Path destination = Paths.get(dir.getAbsolutePath() + "/" + finalfilename + ".doc");
		InputStream bytes = null;
		if (null != uploadedFile) {
			try {
				bytes = uploadedFile.getInputStream();
				if (!destination.toFile().exists())
					Files.copy(bytes, destination);
				else {
					destination.toFile().delete();
					Files.copy(bytes, destination);
				}
				String useremail = filename;
				userService.addResumeDetail(finalfilename, useremail);
				return "upload succesfull";
			} catch (IOException e) {
				e.printStackTrace();
				return "error occured please try again after sometime";
			}
		}
		return "upload Fail";
	}

	public static String getSubmittedFileName(Part filePart) {
		String header = filePart.getHeader("content-disposition");
		if (header == null)
			return null;
		for (String headerPart : header.split(";")) {
			if (headerPart.trim().startsWith("filename")) {
				return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
