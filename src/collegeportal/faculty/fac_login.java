package collegeportal.faculty;

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
 * Servlet implementation class fac_login
 */
@WebServlet("/fac_login")
public class fac_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fac_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean isLogin = false;
		HttpSession sess=req.getSession();
		sess.setAttribute("isLogin",isLogin);
		String uid=req.getParameter("uid");
		String pass=req.getParameter("pass");
			try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        PreparedStatement pst = con.prepareStatement("Select * from fac_cred where uid=? and pass=?;");
	        pst.setString(1, uid);
	        pst.setString(2, pass);
	        ResultSet rs = pst.executeQuery();
	        

	        if(rs.next()) {
	        	String fac_name=rs.getString("name");
	        	String department=rs.getString("dep");
	        	String fac_code= rs.getString("fac_code");
	        	sess.setAttribute("isLogin", true);
	        	sess.setAttribute("uid", uid);
	        	sess.setAttribute("msg","0");
	        	sess.setAttribute("name",fac_name);
	        	sess.setAttribute("dep",department );
	        	sess.setAttribute("login_type","fac");
	        	sess.setAttribute("fac_code",fac_code);
	        
	        	res.sendRedirect("/sa/fac_ho");
	        }else {
	        	res.sendRedirect("sa");
	        }
		}catch(Exception e) {
			System.out.println("fac_login"+e);
		}
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
