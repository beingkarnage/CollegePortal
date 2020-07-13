package collegeportal.admin;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_edit_fac extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public admin_edit_fac() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid=req.getParameter("uid"),name=req.getParameter("name"),pass=req.getParameter("pass"),
				_uid=req.getParameter("fac_uid"),dep=req.getParameter("dep"),code=req.getParameter("code");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
		    Statement stmt=con.createStatement();
		    stmt.executeUpdate("update fac_cred set uid='"+uid+"' where uid='"+_uid+"';");
		    stmt.executeUpdate("update fac_cred set fac_code='"+code+"' where uid='"+_uid+"';");
		    stmt.executeUpdate("update fac_cred set std_name='"+name+"' where uid='"+uid+"';");
		    stmt.executeUpdate("update fac_cred set pass='"+pass+"' where uid='"+uid+"';");
		    stmt.executeUpdate("update fac_cred set dep='"+dep+"' where uid='"+uid+"';");
		    res.sendRedirect("manage_fac");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
