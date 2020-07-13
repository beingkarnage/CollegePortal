package collegeportal.admin;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class admin_add_fac extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public admin_add_fac() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid=req.getParameter("uid"),name=req.getParameter("name"),pass=req.getParameter("pass"),
				dep=req.getParameter("dep"),fac_code=req.getParameter("code");
		HttpSession sess=req.getSession();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
		    Statement stmt=con.createStatement();
		    try {
		    stmt.executeUpdate("insert into fac_cred values('"+uid+"','"+pass+"','"+name+"','"+dep+"','"+fac_code+"');");
		    }catch(Exception e) {
		    	sess.setAttribute("code","uidexists");
		    }res.sendRedirect("manage_faac");
		}catch(Exception e) {
			System.out.println(e);
		}
			
		
	}


}
