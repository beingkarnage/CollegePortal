
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
@WebServlet("/add_attachments_")
public class add_attachments_ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public add_attachments_() {
		super();
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
	
		String uid="",writer="",sub="",ntf="",privacy="";
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
		String path="C:/Users/intel/Desktop/collegetemp";
		
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
		 	String attach_uid=Long.toString(System.currentTimeMillis())+uid;
		 	Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
		while (iter.hasNext()) {
		 FileItem item = iter.next();

		 if (item.isFormField()) {
			 System.out.println("item form field");
			 String name = item.getFieldName();
			 String value = item.getString();
			if(name.contains("uuid")) {uid=(String)sess.getAttribute("uid");}
			if(name.contains("privacy")) {privacy=value;}
			if(name.contains("writer")) {writer=value;}
			if(name.contains("sub")) {sub=value;}
			if(name.contains("ntf")) {ntf=value;}
			
		 } 
		        if(!item.isFormField()) {
		    			System.out.println("file upload runing");
		    			 		uploadDir=new File(path+attach_uid);
		    			 		if (!uploadDir.exists()) {
		    						uploadDir.mkdir();
		    					}
		    			 		factory.setRepository(uploadDir);
		    			 		DiskFileItemFactory factoryx = new DiskFileItemFactory(10 * 1024 * 1024, uploadDir);
		    			 		System.out.println(attach_uid);
		    					String fileName =new File(item.getName()).getName();
		    					// filtering only these extensions files
		    					if(fileName.endsWith(".pdf")) {
		    						fileName = attach_uid+".pdf";
		    					}else if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
		    						fileName = attach_uid + ".jpg";
		    					}else if(fileName.endsWith(".txt")) {
		    						fileName =attach_uid+".txt";
		    					}else if(fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
		    						fileName =attach_uid+".xls";
		    					}else if(fileName.endsWith(".docx")) {
		    						fileName=attach_uid+".docx";
		    					}else {
		    						String rd = (String)sess.getAttribute("login_type");
		    						res.sendRedirect(rd+"_home");
		    					}
		    					System.out.println("file upload");
		    					String filePath = uploadDir + File.separator +fileName;
		    					File storeFile = new File(filePath);
		    					item.write(storeFile);
		    		 }
		 }
		if(privacy.contains("s")) {
        	System.out.println("std_ntf running");
        	uid=(String)sess.getAttribute("uid");
        stmt.executeUpdate("insert into std_ntf values('"+attach_uid+"','"+uid+"','"+sub+"','"+writer+"','"+ntf+"');");
        }else {
        	System.out.println("clg_ntf running");
        	uid=(String)sess.getAttribute("uid");
        	stmt.executeUpdate("insert into clg_ntf values('"+attach_uid+"','"+uid+"','"+sub+"','"+writer+"','"+ntf+"');");
        }
		res.sendRedirect("std_ho");
		} catch (Exception e) {
			e.printStackTrace();
		}}catch(Exception e) {System.out.println(e);}
		sess.setAttribute("msg","!");
		
	}

}
