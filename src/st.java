

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/st")
public class st extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public st() {
        super();
    }

    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from clg_ntf limit 15;");
			out.println("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"  <head>\r\n" + 
					"  <style>\r\n" + 
					"  html {\r\n" + 
					"  scroll-behavior: smooth;\r\n" + 
					"}</style>\r\n" + 
					"  \r\n" + 
					"  \r\n" + 
					"  <script>\r\n" + 
					"function scrollWin() {\r\n" + 
					"  window.scrollBy(0,13000);\r\n" + 
					"}\r\n" + 
					"</script>\r\n" + 
					"    <meta charset=\"utf-8\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"\r\n" + 
					"    <title>College Portal</title>\r\n" + 
					"	\r\n" + 
					
					"\r\n" + 
					
					
					"	<link href=\"js/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
					
					"	\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"  \r\n"
					+ "<h3 align=\"center\">College Portal</h3>" + 
					"	<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n" + 
					"  \r\n" + 
					"  \r\n" + 
					"\r\n" + 
					"  \r\n" + 
					"  <div class=\"collapse navbar-collapse\" align=\"center\" id=\"navbarColor02\">\r\n" + 
					"    <ul class=\"navbar-nav mr-auto\">\r\n" + 
					"      <li class=\"nav-item active\">\r\n" + 
					"        <button type=\"button\"  class=\"btn btn-secondary\" href=\"#\">Home <span class=\"sr-only\">(current)</span></button>\r\n" + 
					"      </li>\r\n" + 
					"      <li class=\"nav-item\">\r\n" + 
					"        <button=\"button\" onclick=\"scrollWin()\" class=\"btn btn-secondary\"  href=\"#middle\">Faculty</button>\r\n" + 
					"      </li>\r\n" + 
					"      <li class=\"nav-item\">\r\n" + 
					"        <button=\"button\" onclick=\"scrollWin()\" class=\"btn btn-secondary\" href=\"#\">Student</button>\r\n" + 
					"      </li>\r\n" + 
					"      <li class=\"nav-item\">\r\n" + 
					"        <button=\"button\" class=\"btn btn-secondary\" href=\"#\">About Us</button>\r\n" + 
					"      </li>\r\n" +
					"      <li class=\"nav-item\">\r\n" + 
					"        <button=\"button\" class=\"btn btn-secondary\" href=\"#\">Report Us</button>\r\n" + 
					"      </li>\r\n" +
					"    </ul>\r\n" + 
					"    \r\n" + 
					"  </div>\r\n" + 
					"</nav>\r\n" + 
					"    <div class=\"container-fluid\">\r\n" + 
					"	<div class=\"col-md-12\">\r\n" + 
					"					<h3>\r\n" + 
					"\r\n" + 
					"					</h3>\r\n" + 
					"				</div>\r\n" + 
					"	<div class=\"row\">\r\n" + 
					"		<div class=\"col-md-12\">\r\n" + 
					"			<div class=\"row\">\r\n");
							if(!rs.next()) {
						out.println(
					"				<div class=\"col-md-12\">\r\n" + 
					"					<div class=\"alert alert-dismissible alert-warning\">\r\n" + 
					"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\r\n" + 
					"  <h4 class=\"alert-heading\">NO NOTIFICATIONS PRESENT</h4>\r\n" + 
					"  <p class=\"mb-0\">No Notifiction Found On Portal<a href=\"#\" class=\"alert-link\"></a>.</p>\r\n" + 
					"</div>\r\n" + 
					"				</div>\r\n");}
					out.println("</div>\r\n");
					while(rs.next()) {
						String sub=rs.getString("sub");
						String ntf=rs.getString("ntf");
						String writer=rs.getString("writer");
						String ntf_id=rs.getString("ntf_id");
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
								"						</p>\r\n<form action=\"download_f\"><input type=\"hidden\" name=\"ntf_id\" value="+ntf_id+">"
										+ "<button class=\"btn btn-primary\" type=\"submit\" style=\"border-radius:26px;\">Download Attachments</button> </form>" + 
								"					</div>\r\n" + 
								"				</div>\r\n" + 
								"			</div>\r\n" ); 
									
					}out.println(
					"			<div class=\"row\">\r\n" + 
					"				<div class=\"col-md-5\">\r\n" + 
					"					<form role=\"form\" action=\"student_login\">\r\n" + 
					"						<div class=\"form-group\">\r\n" + 
					"							 \r\n" + 
					"							<label for=\"examplelable\">\r\n" + 
					"								<h4>Student Login</h4>\r\n" + 
					"							</label>\r\n" + 
					"							\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"form-group\">\r\n" + 
					"							 \r\n" + 
					"							<label for=\"exampleInputEmail1\">\r\n" + 
					"								Unique Student Code\r\n" + 
					"							</label>\r\n" + 
					"							<input type=\"text\" name=\"uid\" class=\"form-control\" id=\"exampleInputEmail1\">\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"form-group\">\r\n" + 
					"							 \r\n" + 
					"							<label for=\"exampleInputPassword1\">\r\n" + 
					"								Password\r\n" + 
					"							</label>\r\n" + 
					"							<input type=\"password\" name=\"pass\"class=\"form-control\" id=\"exampleInputPassword1\">\r\n" + 
					"						</div>\r\n" + 
					"						 \r\n" + 
					"						\r\n" + 
					"						<button type=\"submit\" class=\"btn btn-primary\">\r\n" + 
					"							Submit\r\n" + 
					"						</button>\r\n" + 
					"					</form>\r\n" + 
					"				</div>\r\n"+
					"				<div class=\"col-md-2\">\r\n" + 
					"				</div>\r\n" + 
					"				<div class=\"col-md-5\">\r\n" + 
					"					<form action=\"faculty_login\" role=\"form\">\r\n" + 
					"						<div class=\"form-group\">\r\n" + 
					"							 \r\n" + 
					"							<label for=\"examplelable\">\r\n" + 
					"								<h4>Faculty Login</h4>\r\n" + 
					"							</label>\r\n" + 
					"							\r\n" + 
					"						</div>\r\n" + 
					"						\r\n" + 
					"						\r\n" + 
					"						<div class=\"form-group\">\r\n" + 
					"							 \r\n" + 
					"							<label for=\"exampleInputEmail1\">\r\n" + 
					"								Unique Faculty Code\r\n" + 
					"							</label>\r\n" + 
					"							<input type=\"text\" name=\"uid\" class=\"form-control\" id=\"exampleInputEmail1\">\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"form-group\">\r\n" + 
					"							 \r\n" + 
					"							<label for=\"exampleInputPassword1\">\r\n" + 
					"								Password\r\n" + 
					"							</label>\r\n" + 
					"							<input type=\"password\" name=\"pass\" class=\"form-control\" id=\"exampleInputPassword1\">\r\n" + 
					"						</div>\r\n" + 
					"						\r\n" + 
					"						 \r\n" + 
					"						<button type=\"submit\" class=\"btn btn-primary\">\r\n" + 
					"							Submit\r\n" + 
					"						</button>\r\n" + 
					"					</form>\r\n" + 
					"				</div>\r\n" + 
					"				<div class=\"col-md-12\">\r\n" + 
					"					<h3>\r\n" + 
					"						\r\n" + 
					"					</h3>\r\n" + 
					"				</div>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</div>\r\n" + 
					"	<footer class=\"page-footer font-small blue\">\r\n" + 
					"  <div class=\"footer-copyright text-center py-3\">From Team karnage\r\n" + 
					"    <a href=\"\"></a>\r\n" + 
					"  </div>\r\n" + 
					"  \r\n" + 
					"\r\n" + 
					"</footer>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    <script src=\"js/jquery.min.js\"></script>\r\n" + 
					"    <script src=\"js/bootstrap.min.js\"></script>\r\n" + 
					"    <script src=\"js/scripts.js\"></script>\r\n" + 
					"  </body>\r\n" + 
					"</html>");
			}catch(Exception e) {
				out.println(e);
			}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
