package collegeportal.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admin_login
 */
public class admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_login() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean isLogin = false;
		HttpSession sess=req.getSession();
		sess.setAttribute("isLogin",isLogin);
		String uid=req.getParameter("uid");
		String pass=req.getParameter("pass");
		
		if(isLogin==true) {
			res.sendRedirect("admin_home");
		}else{
			
			try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        PreparedStatement pst = con.prepareStatement("Select * from admin_cred where uid=? and pass=?");
	        pst.setString(1, uid);
	        pst.setString(2, pass);
	       
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()) {
	        	try{
        		String admin_name=rs.getString("name");
	        	sess.setAttribute("isLogin", true);
	        	sess.setAttribute("admin_name",admin_name);
	        	sess.setAttribute("uid", uid);
	        	sess.setAttribute("pass",pass);
	        	sess.setAttribute("code","0");
	        	sess.setAttribute("login_type", "admin");
	        	res.sendRedirect("admin_home");
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


}
