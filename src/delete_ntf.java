

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class delete_ntf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete_ntf() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid=req.getParameter("ntf_id");
		HttpSession sess=req.getSession();
		String login_type=(String)sess.getAttribute("login_type");
		String type=req.getParameter("type");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        if(type.contentEquals("std"))
	        {stmt.executeUpdate("delete from std_ntf where ntf_id="+uid+";");}
	        else{stmt.executeUpdate("delete from clg_ntf where ntf_id="+uid+";");}
	        if(login_type.contentEquals("std")) {
	        	if(type.contentEquals("std")){res.sendRedirect("user_ntf");}
	        	else{res.sendRedirect("user_ntf_clg");}
	        }else if(login_type.contentEquals("fac")) {
	        	if(type.contentEquals("std")){res.sendRedirect("user_ntf");}
	        	else {res.sendRedirect("user_ntf_clg");}
	        }else if(login_type.contentEquals("admin")) {
	        	if(type.contentEquals("std")) {res.sendRedirect("manage_ntf_std");}
	        	else {res.sendRedirect("manage_ntf_clg");}	
	        }
	       
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}