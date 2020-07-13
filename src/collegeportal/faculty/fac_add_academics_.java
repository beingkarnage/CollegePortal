package collegeportal.faculty;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class fac_add_academics_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		String roll_no=req.getParameter("roll_no");
		String sub=req.getParameter("subject");
		String marks=req.getParameter("marks");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        stmt.executeUpdate("insert into academics values('"+roll_no+"','"+sub+"','"+marks+"');");
	        res.sendRedirect("add_academics");
	        sess.setAttribute("msg","A");
		}catch(Exception e) {
			e.getMessage();
		}
		}
	

}
