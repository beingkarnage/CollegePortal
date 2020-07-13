package collegeportal.faculty;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class fac_home
 */
@WebServlet("/fac_home")
public class fac_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fac_home() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		sess.setAttribute("exists",false);//this session attribute is required to identify is student exists in academics
		String msg=(String)sess.getAttribute("msg");
		boolean isLogin=(boolean)sess.getAttribute("isLogin");
		System.out.println(isLogin);
		PrintWriter out=res.getWriter();
		if(isLogin){
		
	        
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	            Statement stmt=con.createStatement();
	            ResultSet rs=stmt.executeQuery("select * from std_ntf limit 50;");
			out.println("<html lang=\"en\"><head>\r\n" + 
					"    <title>Faculty Home</title>\r\n" + 
					
					"	<link href=\"js/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"	<nav class=\"navbar navbar-inverse navbar-expand-lg navbar-dark bg-dark\" style=\"position:static\r\n" + 
					"	\">\r\n" + 
					"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor02\" aria-controls=\"navbarColor02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"  </button>\r\n" + 
					"</br><h3>Faculty Panel</h3>" + 
					
					"  <div class=\"collapse navbar-collapse\" id=\"navbarColor02\">\r\n" + 
					"    <ul class=\"navbar-nav mr-auto\">\r\n" + 
					"      <li class=\"nav-item active\">\r\n" + 
					"        <a class=\"nav-link\" href=\"#\"><span class=\"sr-only\">(current)</span></a>\r\n" + 
					"      </li>\r\n" + 
					"      <li class=\"nav-item\">\r\n" + 
					"        <a class=\"nav-link\" href=\"#\"></a>\r\n" + 
					"      </li>\r\n" + 
					"      <li class=\"nav-item\">\r\n" + 
					"        <a class=\"nav-link\" href=\"#\"></a>\r\n" + 
					"      </li>\r\n" + 
					"      <li class=\"nav-item\">\r\n" + 
					"        <a class=\"nav-link\" href=\"#\"></a>\r\n" + 
					"      </li>\r\n" + 
					"    </ul>\r\n" + 
					"   <form action=\"logt\"> <button type=\"submit\" class=\"btn btn-outline-primary\" size=\"30px;\" style=\"border-radius:26px;\">\r\n" + 
					"						Logout\r\n" + 
					"					</button></form>\r\n" + 
					"  </div>\r\n" + 
					"</nav>\r\n" + 
					"\r\n" + 
					"    <div class=\"container-fluid\">\r\n" + 
					"	<div class=\"row\">\r\n" + 
					"		<div class=\"col-md-12\">\r\n" + 
					"			\r\n" + 
					"			\r\n" + 
					"				<div class=\"row\">\r\n" + 
					"				<div class=\"col-md-12\">\r\n" + 
					"					<h3 align=\"center\" class=\"\">\r\n" + 
					"						College Notifications\r\n" + 
					"					</h3>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"			<div class=\"row\" style=\"background-color:#2F4A66;\">\r\n" + 
					"				<div class=\"col-md-3\">\r\n" + 
					"					<ul class=\"nav flex-column\" style=\"position:fixed;\">\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link active\" href=\"#\">Dashboard</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link\" href=\"fac_pro\">My Profile</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							\r\n" + 
					"							<a class=\"nav-link \" href=\"create_qform\">Create Queue</a>\r\n" + 
					"						</li>\r\n" + 
											"<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"fac_active_queue\">Active Queues</a>\r\n" + 
					"						</li>\r\n" + 
					"<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"add_academics\">Add Academics</a>\r\n" + 
					"						</li>\r\n" + 
					"<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"update_academics\">Update Academics</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"delete_academics\">Delete Academics</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"create_assignment\">Create Assignment</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"view_assignment\">View Assignment</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"clg_ntf\">College Notifications</a>\r\n" + 
					"						</li>\r\n" + 
					"						<li class=\"nav-item\">\r\n" + 
					"							<a class=\"nav-link \" href=\"std_ntf\">Student Notifications</a>\r\n" + 
					"						</li>\r\n" + 
						
					"						<li class=\"nav-item\">\r\n" + 
					"							\r\n" + 
					"							<a class=\"nav-link \" href=\"std_cntf\">Post Your Notice</a>\r\n" + 
					"						</li>\r\n" +  
					"						<li class=\"nav-item\">\r\n" + 
					"							\r\n" + 
					"							<a class=\"nav-link \" href=\"user_ntf\">Your Notifications</a>\r\n" + 
					"						</li>\r\n" +
					"						\r\n" + 
											
					"						\r\n" + 
					"					</ul>\r\n" + 
					"				</div>\r\n" + 
					"				<div class=\"col-md-9\" style=\"background-color:#2B3E50\">\r\n");
			
			
			if(msg.contains("!")) {
				out.println("<div class=\"col-md-12\">\r\n" + 
						"					<div class=\"alert alert-dismissible alert-success\">\r\n" + 
						"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\r\n" + 
						"  <h4 class=\"alert-heading\">Info !!!</h4>\r\n" + 
						"  <p class=\"mb-0\">Your Notification has been posted <a href=\"std_ho\" class=\"alert-link\">You can see it on Your profile </a>.</p>\r\n" + 
						"</div>\r\n" + 
						"				</div>");sess.setAttribute("msg", "0");
				
			}if(msg.contains("N")) {
				out.println("<div class=\"col-md-12\">\r\n" + 
						"					<div class=\"alert alert-dismissible alert-success\">\r\n" + 
						"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\r\n" + 
						"  <h4 class=\"alert-heading\">Sorry No attachment found at that Notification</h4>\r\n" + 
						"  <p class=\"mb-0\"> Check Others <a href=\"fac_ho\" class=\"alert-link\">here  </a>.</p>\r\n" + 
						"</div>\r\n" + 
						"				</div>");sess.setAttribute("msg", "0");
				
			}
			while(rs.next()) {
				String ntf_id=rs.getString("ntf_id");
				String sub=rs.getString("sub");
				String ntf=rs.getString("ntf");
				String writer=rs.getString("writer");
				out.println(
				"	<div class=\"row\">\r\n" + 
						"		<div class=\"col-md-12\">\r\n" + 
						"			<div class=\"row\">\r\n" + 
						"				<div class=\"col-md-12\">\r\n" + 
						"					<div class=\"jumbotron\">\r\n" + 
						"						<h5>ID# "+ntf_id+"</h5><h3>\r\n" + 
						"							"+sub+"\r\n" + 
						"						</h3>\r\n" + 
						"						<p>\r\nBy: " + 
						                               writer   +
						"						</p>\r\n" + 
						"						<p>\r\n" + 
												  ntf    +
						"						</p>\r\n" + 
						"	<form action=\"download_f\"><input type=\"hidden\" name=\"ntf_id\" value="+ntf_id+"><button class=\"btn btn-primary\" type=\"submit\" style=\"border-radius:26px;\">Download Attachments</button> </form>				"
						+ "</div>\r\n" + 
						"				</div>\r\n" + 
						"			</div><div></div>\r\n" ); }
					out.println(
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</div>\r\n" + 
					"	<footer class=\"page-footer font-small blue\">\r\n" + 
					"  <div class=\"footer-copyright text-center py-3\">Made with bootstrap\r\n" + 
					"    <a href=\"https://google.com\"> and lots of google</a>\r\n" + 
					"  </div>\r\n" + 
					"  \r\n" + 
					"\r\n" + 
					"</footer>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    <script src=\"js/jquery.min.js\"></script>\r\n" + 
					"    <script src=\"js/bootstrap.min.js\"></script>\r\n" + 
					"    <script src=\"js/scripts.js\"></script>\r\n" + 
					"  \r\n" + 
					"</body></html>");
					con.close();
					stmt.close();
		}catch(Exception e) {
			out.println("fac"+e);
		}
		}else {
			out.println("Unautorized access");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
