
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class add_attachments_
 */

public class submit_assignment extends HttpServlet {
 
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
	
		String ass_id="",std_id=(String)sess.getAttribute("roll_no");
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items;
		try {
			items = upload.parseRequest(req);
		
		// Create a factory for disk-based file items

		// Set factory constraints
		factory.setSizeThreshold(10 * 1024);
		String path="C:/Users/intel/Desktop/collegetemp/assignments";
		
		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Create a new file upload handler

		
		// Set overall request size constraint
		upload.setSizeMax(10 * 1024);

		// Parse the request
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		try {	
		 	
		 	Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
		while (iter.hasNext()) {
		 FileItem item = iter.next();

		 if (item.isFormField()) {
			 System.out.println("item form field");
			 String name = item.getFieldName();
			 String value = item.getString();
			if(name.contentEquals("id")) {ass_id=value;}
			System.out.println("id"+ass_id);
			
		 } String attach_uid=ass_id+"_"+std_id;
		 	
		        if(!item.isFormField()) {
		        	System.out.println("this is ass uid "+ass_id);
		    			 		uploadDir=new File(path+"/"+attach_uid);
		    			 		if (!uploadDir.exists()) {
		    						uploadDir.mkdir();
		    					}
		    			 		factory.setRepository(uploadDir);
		    			 		DiskFileItemFactory factoryx = new DiskFileItemFactory(10 * 1024 * 1024, uploadDir);
		    			 		System.out.println(attach_uid);
		    					String fileName =new File(item.getName()).getName();
		    					// filtering only these extensions files
		    					if(!fileName.endsWith(".pdf")) {
		    						String rd = (String)sess.getAttribute("login_type");
		    						res.sendRedirect(rd+"_home");
		    					
		    						
		    						
		    					}else {
		    						fileName = attach_uid+".pdf";
		    					}
		    					System.out.println("file upload");
		    					String filePath = uploadDir + File.separator +fileName;
		    				
		    					File storeFile = new File(filePath);
		    					item.write(storeFile);
		    					System.out.println("st file"+storeFile);
		    					stmt.executeUpdate("insert into submit_assignments values('"+ass_id+"','"+std_id+"',NOW());");
		    		 }
		 }
		res.sendRedirect("std_ho");
		} catch (Exception e) {
			e.printStackTrace();
		}}catch(Exception e) {System.out.println(e);}
		sess.setAttribute("msg","@");
		
	}

}
