package collegeportal.faculty;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fac_pass_std
 */
@WebServlet("/fac_pass_std")
public class fac_pass_std extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fac_pass_std() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		String q_id=req.getParameter("q_id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        stmt.executeUpdate("delete from queue_"+q_id+" where uid="+uid+";");
	        ResultSet rs=stmt.executeQuery("select in_q from active_q where q_id="+q_id+";");
	        rs.next();
	        int in_q=Integer.parseInt(rs.getString("in_q"));
	        
	        if(in_q!=0) {
	        	in_q=in_q-1;
	        }
	        stmt.executeUpdate("update active_q set in_q="+in_q+" where q_id="+q_id+";");
	        res.sendRedirect("fac_handle_q?q_id="+q_id);
		}catch(Exception e) {
			System.out.println("In fac_pass"+e.getMessage());
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
