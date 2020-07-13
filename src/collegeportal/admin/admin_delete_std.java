package collegeportal.admin;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_delete_std extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_delete_std() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
		    Statement stmt=con.createStatement();
		    stmt.executeUpdate("delete from std_cred where uid="+uid+";");
		    res.sendRedirect("manage_std");
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
