package collegeportal.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class admin_manage_std
 */
public class admin_manage_std_ntfs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin_manage_std_ntfs() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter out=res.getWriter();
	try {
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from std_ntf;");
	out.println( 
    		"<html lang=\"en\"><head>\r\n" + 
    		"    <meta charset=\"utf-8\">\r\n" + 
    		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
    		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
    		"\r\n" + 
    		"    <title>Manage Faculty</title>\r\n" + 
    		"	<link href=\"js/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
    		"  </head>\r\n" + 
    		"  <body>\r\n" + 
    		"	<nav class=\"navbar navbar-inverse navbar-expand-lg navbar-dark bg-dark\" style=\"position:static\r\n" + 
    		"	\">\r\n" + 
    		"  <a class=\"navbar-brand\" href=\"#\"></a>\r\n" + 
    		"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor02\" aria-controls=\"navbarColor02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
    		"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
    		"  </button>\r\n" + 
    		"\r\n" + 
    		"  <div class=\"collapse navbar-collapse\" id=\"navbarColor02\">\r\n" + 
    		"    <ul class=\"navbar-nav mr-auto\">\r\n" + 
    		"      \r\n" + 
    		"    </ul>\r\n" + 
    		"   <form action=\"logt\"> <button type=\"submit\" class=\"btn btn-outline-primary\" size=\"30px;\" style=\"border-radius:26px;\">\r\n" + 
    		"						Logout\r\n" + 
    		"					</button></form>\r\n" + 
    		"  </div>\r\n" + 
    		"</nav>\r\n" + 
    		"<br>\r\n" + 
    		"    <div class=\"container-fluid\">\r\n" + 
    		"	<div class=\"row\">\r\n" + 
    		"		<div class=\"col-md-12\">\r\n" + 
    		"			\r\n" + 
    		"			<form action=\"manage_clg_ntf\"><button class=\"btn btn-outline-primary\">Show College Ntf </button></form>\r\n" + 
    		"				<div class=\"row\">\r\n" + 
    		"				<div class=\"col-md-12\">\r\n" + 
    		"					<h3 align=\"center\" class=\"\">\r\n" + 
    		"						Manage Notifications\r\n" + 
    		"					</h3>\r\n" + 
    		"				</div>\r\n" + 
    		"			</div>\r\n" + 
    		"			<br>\r\n" + 
    		"			\r\n" + 
    		"				\r\n" + 
    		"				<div class=\"col-md-12\" style=\"background-color:#2B3E50\">\r\n" + 
    		"\r\n" + 
    		"	<div class=\"row\">\r\n" + 
    		"		<div class=\"col-md-12\">\r\n" + 
    		"			<div class=\"row\">\r\n" + 
    		"				<div class=\"col-md-12\">\r\n" + 
    		"					<table class=\"table\">\r\n" + 
    		"						<thead>\r\n" + 
    		"							<tr class=\"table-dark text-primary\">\r\n" + 
    		"								<th></th>\r\n" + 
    		"								<th></th><th></th>									\r\n" + 
    		 
    		"								<th><h4 style= \"position:relative;left:50%;\">All Notifications</h3></th><th></th><th></th><th></th>	\r\n" +
    		"								\r\n" + 
    		"									\r\n" + 
    		"								\r\n" + 
    		"							</tr>\r\n" + 
    		"						</thead>\r\n" + 
    		"						<tbody>\r\n" + 
    		"							<tr class=\"table-secondry\">\r\n" + 
    		"								<td>Ntf UID#</td>\r\n" + 
    		"								\r\n" + 
    		"								<td>UID of Writer</td>\r\n" + 
    		"								<td>Subject</td>\r\n" + 
    		"				\r\n" + 
    		"			\r\n" + 
    		"								<td>\r\n" + 
    		"									Writer\r\n" + 
    		"								</td>\r\n" + 
    		"								<td>\r\n" + 
    		"									Notification\r\n" + 
    										
			"							</tr></br></br>\r\n" );
    		while(rs.next()) {
    				String ntf_uid=rs.getString("ntf_id");
    				String uid=rs.getString("uid");
    				String sub=rs.getString("sub");
    				String writer=rs.getString("writer");
    				String ntf=rs.getString("ntf");
    				
    				out.println(	
    		"							<tr class=\"table-dark\">\r\n" + 
    		"								<td>"+ntf_uid+"</td>\r\n" + 
       		"								<td>"+uid+"</td>\r\n" + 
    		"								<td>"+sub+"</td>\r\n" + 
    		"								<td>"+writer+"</td>\r\n" +
    		"								<td>"+ntf+"</td>\r\n" +
    		"								<td><form action=\"download_f\"><input type=\"hidden\" name=\"ntf_id\" value="+uid+">" + 
    		"										<button class=\"btn btn-primary\" type=\"submit\" style=\"border-radius:26px;\">Download</button> </form></td>\r\n" + 
    		"<td><form action=\"delete_ntf_std\"><input type=\"hidden\" name=\"ntf_id\" value="+ntf_uid+"><input type=\"hidden\" name=\"type\" value=\"std\">" + 
    		"										<button class=\"btn btn-danger\" type=\"submit\" style=\"border-radius:26px;\">Delete</button> </form></td>"+
    		"							</tr>\r\n" + 
    		"						\r\n" );}
    		out.println("<tr align=\"center\"><td colspan=\"6\">\r\n" + 
            		"							<form action=\"admin_home\"><button type=\"submit\" class=\"btn btn-outline-success\r\n" + 
            		"							\" style=\"border-radius:26px;\">Back to Home</button></form>\r\n" + 
            		"							</tr>"
    				+ "</tbody></table></div>\r\n" + 
    		"		</div>\r\n" + 
    		"</div>		</div>\r\n" + 
    		"		</div>\r\n" + 
    		"	\r\n" + 
    		
    		"	<footer class=\"page-footer font-small blue\">\r\n" + 
    		"  <div class=\"footer-copyright text-center py-3\">Made with bootstrap\r\n" + 
    		"    <a href=\"https://google.com\"> and lots of google</a>\r\n" + 
    		"  </div>\r\n" + 
    		"  \r\n" + 
    		"\r\n" + 
    		"</footer>\r\n" + 
    		"</div>\r\n" + 
    		"\r\n" + 
    		"    <script src=\"js/jquery.min.js\"></script>\r\n" + 
    		"    <script src=\"js/bootstrap.min.js\"></script>\r\n" + 
    		"    <script src=\"js/scripts.js\"></script>\r\n" + 
    		"  \r\n" + 
    		"</body></html>\r\n" + 
    		""); }catch(Exception e) {System.out.println(e);}
	}


}
