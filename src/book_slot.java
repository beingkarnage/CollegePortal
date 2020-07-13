

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/book_slot")
public class book_slot extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public book_slot() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		PrintWriter out=res.getWriter();
		boolean isLogin=true;
		if(isLogin) {
		String q_id=req.getParameter("q_id");
		String uid=(String)sess.getAttribute("uid");
		sess.setAttribute("msg","");
		boolean isUidExists=false,isQFull=false;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select in_q,max_l from active_q where q_id="+q_id+";");
        
        if(rs.next()) {
        String msg = "";
        if(rs.getString("in_q").contentEquals(rs.getString("max_l"))) {
        	isQFull=true;
        	msg = "*";
        }
        rs.close();
        rs = stmt.executeQuery("select * from queue_"+q_id+" where uid ="+uid+";");
        if(rs.next()) {
        	isUidExists=true;
        	msg = msg + "[" + rs.getString("sno") + "]";
        }
        //////////////////////////////
        rs.close();
        sess.setAttribute("msg", msg);
        if(!(isUidExists || isQFull)) {
        	stmt.executeUpdate("insert into queue_"+q_id+" values(default,'"+uid+"')");
        	rs = stmt.executeQuery("select in_q from active_q where q_id="+q_id+";");
        	rs.next();
        	int in_q=Integer.parseInt(rs.getString("in_q"))+1;
        	rs.close();
        	stmt.executeUpdate("update active_q set in_q="+in_q+" where q_id="+q_id+";");
        	rs=stmt.executeQuery("select sno from queue_"+q_id+" where uid="+uid+";");
        	sess.setAttribute("msg","("+rs.getString("sno")+")");
        }}else {System.out.println("no such queue exists queue"+q_id);}
        
        
	}catch(Exception e) {System.out.println(e.getMessage()+"\n"+e.getCause());}
	
		res.sendRedirect("std_ho");
		
		}else {
			out.println("Unauthorized login detected");
		}
	}
}
