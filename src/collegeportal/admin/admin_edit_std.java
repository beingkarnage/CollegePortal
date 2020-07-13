package collegeportal.admin;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_edit_std extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public admin_edit_std() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid=req.getParameter("uid"),name=req.getParameter("name"),pass=req.getParameter("pass"),
				_uid=req.getParameter("std_uid"),roll_no=req.getParameter("roll_no"),branch=req.getParameter("branch");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
		    Statement stmt=con.createStatement();
		    System.out.println("old uid "+_uid+" new uid "+uid);
		    stmt.executeUpdate("update std_cred set uid='"+uid+"' where uid='"+_uid+"';");
		    stmt.executeUpdate("update std_cred set std_name='"+name+"' where uid='"+uid+"';");
		    stmt.executeUpdate("update std_cred set pass='"+pass+"' where uid='"+uid+"';");
		    stmt.executeUpdate("update std_cred set roll_no='"+roll_no+"' where uid='"+uid+"';");
		    stmt.executeUpdate("update std_cred set branch='"+branch+"' where uid='"+uid+"';");
		    res.sendRedirect("manage_std");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
