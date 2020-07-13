package collegeportal.faculty;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/_update_academics")
public class fac_update_academics_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		String roll_no=req.getParameter("roll_no");
		String sub=req.getParameter("subject");
		String marks=req.getParameter("marks");
		System.out.println("sub "+sub);
		boolean exists =(boolean)sess.getAttribute("exists");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        if(!(roll_no.isEmpty())&&(sub.isEmpty()||marks.isEmpty())) {
	        System.out.println("roll no  checking..");
	        ResultSet rs=stmt.executeQuery("select * from academics where std_id='"+roll_no+"';");
	        if(rs.next()) {	        
	        sess.setAttribute("exists",true);
	        res.sendRedirect("update_academics");
	        }}else if(!(sub.isEmpty()||marks.isEmpty())&&(exists)){
	        	System.out.println("updating record");
	        	stmt.executeUpdate("UPDATE academics SET marks = '"+marks+"' WHERE std_id= '"+roll_no+"' and sub = '"+sub+"';");
	        	res.sendRedirect("update_academics");
	        	sess.setAttribute("msg","A");
	        	sess.setAttribute("exists",false);
	        }
		}catch(Exception e) {
			e.getMessage();
		}
		}
	

}
