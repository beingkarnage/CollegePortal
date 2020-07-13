package collegeportal.faculty;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class fac_create_assignment_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		String fac_code = req.getParameter("fac_code");
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		String year=req.getParameter("year");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        stmt.executeUpdate("insert into assignments values(default,'"+fac_code+"','"+sub+"','"+content+"','"+year+"');");
	        res.sendRedirect("create_assignment");
	        sess.setAttribute("msg","C");
		}catch(Exception e) {
			e.getMessage();
		}
		}
	

}
