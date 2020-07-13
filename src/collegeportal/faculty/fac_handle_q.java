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

/**
 * Servlet implementation class fac_handle_q
 */
public class fac_handle_q extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public fac_handle_q() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String q_id=req.getParameter("q_id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeportal", "root", "tosif");
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from queue_"+q_id+";");
	       PrintWriter out=res.getWriter();
	        out.println("\r\n" + 
	        		"<html lang=\"en\"><head>\r\n" + 
	        		"    <meta charset=\"utf-8\">\r\n" + 
	        		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
	        		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	        		"\r\n" + 
	        		"    <title>Handle Queue</title>\r\n" + 
	        		"\r\n" + 
	        		"    <meta name=\"description\" content=\"Source code generated using layoutit.com\">\r\n" + 
	        		"    <meta name=\"author\" content=\"LayoutIt!\">\r\n" + 
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
	        		"						Current Active Queues\r\n" + 
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
	        		"								<th>\r\n" + 
	        		"									Active Queues\r\n" + 
	        		"								</th>\r\n" + 
	        		"							<th>			\r\n" + 
	        		"								</th><th>\r\n" + 
	        		"									\r\n" + 
	        		"								\r\n" + 
	        		"									\r\n" + 
	        		"									\r\n" + 
	        		"								\r\n" + 
	        		"							</tr>\r\n" + 
	        		"						</thead>\r\n" + 
	        		"						<tbody>\r\n" + 
	        		"							<tr class=\"table-secondry\">\r\n" + 
	        		"								<td>\r\n" + 
	        		"									Sno\r\n" + 
	        		"								</td>\r\n" + 
	        		"								<td>\r\n" + 
	        		"									UID of Student\r\n" + 
	        		"								</td>\r\n" + 
	        		"								<td>\r\n" + 
	        		"									Pass						</td>\r\n" + 
	        		"			\r\n" + 
	        		"																\r\n" + 
	        		"							</tr>\r\n" + 
	        		"");
	        while(rs.next()) {
	        	String sno=rs.getString("sno");
	        	String uid=rs.getString("uid");
	        	out.println("<tr class=\"table-dark\"> "+
						"<td>"+sno+"</td> " + 
		"				<td>" + 
						uid+  
		"				</td>" + 
		"				<td>" + 
		"				<form action=\"pass_std\"><input type=\"hidden\" name=\"q_id\" value="+q_id+"><input type=\"hidden\" name=\"uid\" value="+uid+"><button type=\"submit\" class=\"btn btn-outline-info\" "+ 
		"				 style=\"border-radius:20px;\">Pass</button></form></td>" + 
		"				</tr>");
	        }
	        out.println( 
					"	<tr align=\"center\"><td colspan=\"3\">\r\n" + 
					"							<form action=\"fac_ho\"><button type=\"submit\" class=\"btn btn-outline-success\r\n" + 
					"							\" style=\"border-radius:26px;\">Back to Home</button></form>\r\n" + 
					"							</td>\r\n" + 
					"							</tr>					"
					+ "</tbody>\r\n" + 
					"					</table>\r\n" + 
					"				</div>\r\n" + 
					"		</div>\r\n" + 
					"</div>		</div>\r\n" + 
					"		</div>\r\n" + 
					"	\r\n" + 
					"	<br>\r\n" + 
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
					""); ;
	        
	        
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
