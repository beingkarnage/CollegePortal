package collegeportal.faculty;
import java.util.Date;
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
 * Servlet implementation class fac_create_queue
 */
@WebServlet("/fac_create_queue")
public class fac_create_queue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public fac_create_queue() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String q_name=req.getParameter("q_name");
		String max=req.getParameter("max_l");
		String valid=req.getParameter("valid");
		
			try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        String q="insert into active_q values(default,'"+q_name+"',0,'"+max+"','"+valid+"',CURDATE());";
	        stmt.executeUpdate(q);
	        System.out.println(q);
	        ResultSet rs=stmt.executeQuery("select q_id from active_q order by q_id desc limit 1;");
	        rs.next();
	        String last_q=rs.getString("q_id");
	        stmt.executeUpdate("CREATE TABLE queue_"+last_q+"(`sno` INT NOT NULL AUTO_INCREMENT,`uid` CHAR(12) NOT NULL, PRIMARY KEY (`sno`, `uid`), UNIQUE INDEX `uid_UNIQUE` (`uid` ASC) VISIBLE);");
			res.sendRedirect("fac_ho");
			}catch(Exception e) {
			System.out.println(e);
		}
	}

}
