package collegeportal.faculty;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fac_delete_q
 */
@WebServlet("/fac_delete_q")
public class fac_delete_q extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public fac_delete_q() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String q_id= req.getParameter("q_id");
		System.out.println("q__id received to dlete "+q_id);
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        stmt.executeUpdate("drop table queue_"+q_id+";");
	        stmt.executeUpdate("delete from active_q where q_id="+q_id+";");
	        res.sendRedirect("fac_active_queue");
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
