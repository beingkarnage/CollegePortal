

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class user_ntfs
 */
public class user_ntfs_clg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public user_ntfs_clg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		PrintWriter out=res.getWriter();
		String login_type=(String)sess.getAttribute("login_type");
		String uid=(String)sess.getAttribute("uid");
		try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from clg_ntf where uid="+uid+";");
            out.println("\r\n" + 
            		"<html lang=\"en\"><head>\r\n" + 
            		"    <meta charset=\"utf-8\">\r\n" + 
            		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
            		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
            		"\r\n" + 
            		"    <title>Your Notifications</title>\r\n" + 
            		"\r\n" + 
            		"    <meta name=\"description\" content=\"Source code generated using layoutit.com\">\r\n" + 
            		"\r\n" + 
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
            		"			\r\n" + 
            		"				<div class=\"row\">\r\n" + 
            		"				<div class=\"col-md-12\">\r\n" + 
            		"					<h3 align=\"center\" class=\"\">\r\n" + 
            		"						Your Notifications\r\n" + 
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
            		"								<th></th>									\r\n" + 
            		 
            		"								<th><h4 style=\"position:relative;left:215px;\">All Your Notifications</h3></th>\r\n" + 
            		"								<th></th><th></th>	\r\n" +
            		"								\r\n" + 
            		"									\r\n" + 
            		"								\r\n" + 
            		"							</tr>\r\n" + 
            		"						</thead>\r\n" + 
            		"						<tbody>\r\n" + 
            		"							<tr class=\"table-secondry\">\r\n" + 
            		"								<td>Ntf ID#</td>\r\n" + 
            		"								\r\n" + 
            		"								<td>Writer</td>\r\n" + 
            		"								<td>Subject</td>\r\n" + 
            		"				\r\n" + 
            		"			\r\n" + 
            		"								<td>\r\n" + 
            		"									Description\r\n" + 
            		"								</td>\r\n" + 
            		"								\r\n" + 
            		"								\r\n" + 
            		"								\r\n" + 
            		"							</tr></br></br>\r\n" );
            		while(rs.next()) {
            			if(uid.contentEquals(rs.getString("uid"))) {
            				String ntf_id=rs.getString("ntf_id");
            				String ntf=rs.getString("ntf");
            				String sub=rs.getString("sub");
            				String writer=rs.getString("writer");
           
            				
            				out.println(	
            		"							<tr class=\"table-dark\">\r\n" + 
            		"								<td>"+ntf_id+"</td>\r\n" + 
               		"								<td>"+writer+"</td>\r\n" + 
            		"								<td>"+sub+"</td>\r\n" + 
            		"								<td>"+ntf+"</td>\r\n" + 
            		"								<td><form action=\"download_f\"><input type=\"hidden\" name=\"ntf_id\" value="+uid+">" + 
            		"										<button class=\"btn btn-primary\" type=\"submit\" style=\"border-radius:26px;\">Download Attachments</button> </form></td>\r\n" + 
            		"<td><form action=\"delete_ntf\"><input type=\"hidden\" name=\"ntf_id\" value="+uid+"> <input type=\"hidden\" name=\"type\" value=\"clg\">" + 
            		"										<button class=\"btn btn-danger\" type=\"submit\" style=\"border-radius:26px;\">Delete</button> </form></td>"+
            		"							</tr>\r\n" + 
            		"						\r\n" );}
            		}
            		String link_type="";
            		if(login_type.contains("fac")) {link_type="fac_ho";}
            		if(login_type.contains("std")) {link_type="std_home";}
            		out.println("<tr align=\"center\"><td colspan=\"6\">\r\n" + 
                    		"							<form action="+link_type+"><button type=\"submit\" class=\"btn btn-outline-success\r\n" + 
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
            		""); 
		}catch(Exception e) {
			
		}
	
	}

}
