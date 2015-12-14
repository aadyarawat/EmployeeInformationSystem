package com.yash.TestBean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class HelloBean {
	
	Logger logger= Logger.getLogger(HelloBean.class.getName());
	
	String message;
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String downloadFile() throws IOException {
		String URL = "Deepak.doc";
		// Get the FacesContext
		FacesContext facesContext = FacesContext.getCurrentInstance();

		// Get HTTP response
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		

		// Set response headers
		response.reset(); // Reset the response in the first place
		response.setHeader("Content-Disposition", "attachment;filename=" + "SampleResume.doc"); // Set
																						// only
																						// the
		// content type

		// Open response output stream
		OutputStream responseOutputStream = response.getOutputStream();

		
		String realpath = (String)FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		int index = realpath.lastIndexOf("\\");
		String path = realpath.substring(0, index+1);
		File dir = new File(path+"sample");
		dir.mkdirs();
		
		// Read Sample contents
		URL url = new URL("file://D:/ejb wildfly/wildfly-8.2.0.Final/wildfly-8.2.0.Final/standalone/deployments/sample"+ URL);
		InputStream InputStream = url.openStream();
		// Read contents and write them to the output
		byte[] bytesBuffer = new byte[2048];
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
	}
	
	public String getRealPath(){
		String realpath = (String)FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		int index = realpath.lastIndexOf("\\");
		String path = realpath.substring(0, index+1);
		File dir = new File(path+"sample");
		dir.mkdirs();
		this.message="---->"+dir.getPath()+"-->"+dir.exists();
		return null;
	}
}