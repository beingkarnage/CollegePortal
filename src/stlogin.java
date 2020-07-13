

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/stlogin")
public class stlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public stlogin() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		boolean isLogin = false;
		HttpSession sess=req.getSession();
		sess.setAttribute("isLogin",isLogin);
		String uid=req.getParameter("uid");
		String pass=req.getParameter("pass");
		
		if(isLogin==true) {
			res.sendRedirect("std_home");
		}else{
			
			try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        PreparedStatement pst = con.prepareStatement("Select * from std_cred where uid=? and pass=?");
	        pst.setString(1, uid);
	        pst.setString(2, pass);
	       
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()) {
	        	try{
        		String std_name=rs.getString("std_name");
	        	String branch=rs.getString("branch");
	        	String roll_no=rs.getString("roll_no");
	        	sess.setAttribute("isLogin", true);
	        	sess.setAttribute("std_name", std_name);
	        	sess.setAttribute("uid", uid);
	        	sess.setAttribute("pass",pass);
	        	sess.setAttribute("roll_no", roll_no);
	        	sess.setAttribute("branch", branch);
	        	sess.setAttribute("msg","0");
	        	sess.setAttribute("login_type", "std");
	        	
	        	res.sendRedirect("std_home");
	        	}catch(Exception e) {
	        		System.out.println(e);
	        	}
	        }else {
	        	res.sendRedirect("invalidcred.html");
	        }
		}catch(Exception e) {
			
		}
		}
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("server running in post");
		doGet(req, res);
	}

}
