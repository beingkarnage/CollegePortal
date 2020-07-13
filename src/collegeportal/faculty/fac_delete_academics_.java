package collegeportal.faculty;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class fac_delete_academics_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String roll_no=req.getParameter("std_id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        stmt.executeUpdate("delete from academics where std_id='"+roll_no+"';");
	        res.sendRedirect("delete_academics");
		}catch(Exception e) {
			System.out.println(e);
		}
		}
	

}
