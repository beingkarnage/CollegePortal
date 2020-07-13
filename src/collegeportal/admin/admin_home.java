package collegeportal.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class admin_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public admin_home() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		HttpSession sess=req.getSession();
		boolean isLogin=(boolean)sess.getAttribute("isLogin");
		if(isLogin) {
			out.println("\r\n" + 
					"\r\n" + 
					"<html lang=\"en\"><head>\r\n" + 
					"    <meta charset=\"utf-8\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"\r\n" + 
					"    <title>Admin Home</title>\r\n" + 
					"\r\n" + 
					"    <meta name=\"description\" content=\"Source code generated using layoutit.com\">\r\n" + 
					"    <meta name=\"author\" content=\"LayoutIt!\">\r\n" + 
					"\r\n" + 
					"	<link href=\"js/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
					"	<style>\r\n" + 
					"	\r\n" + 
					"	.heading{\r\n" + 
					"		text-align:center;\r\n" + 
					"		padding:50px;\r\n" + 
					"		background-color:#4A5969;\r\n" + 
					"		\r\n" + 
					"	}\r\n" + 
					"	.form{\r\n" + 
					"	padding:20px;\r\n" + 
					"	text-align:center;\r\n" + 
					"	}\r\n" + 
					"	\r\n" + 
					"	</style>\r\n" + 
					"  \r\n" + 
					"  </head>\r\n" + 
					"	<body>\r\n" + 
					"	<div class=\"heading\">\r\n" + 
					"		<h2>Admin Login</h2>\r\n" +
					"   <form action=\"logt\"> <button type=\"submit\" class=\"btn btn-outline-primary\" size=\"30px;\" style=\"border-radius:26px;\">\r\n" + 
					"						Logout\r\n" + 
					"					</button></form>\r\n" + 
					"	</div><br>\r\n" + 
					"	<div class=\"row\" align=\"center\">\r\n" + 
					"		<div class=\"col-md-3\"><form action=\"manage_std\"><button class=\"btn btn-lg btn-success\" style=\"border-radius: 25px\">Students</button></form></div>\r\n" + 
					"		<div class=\"col-md-3\"><form action=\"manage_fac\"><button class=\"btn btn-lg btn-success\" style=\"border-radius: 25px\">Faculties</button></form></div>\r\n" + 
					"		<div class=\"col-md-3\"><form action=\"manage_ntf\"><button class=\"btn btn-lg btn-success\" style=\"border-radius: 25px\">Notifications</button></form></div>\r\n" +
				
					"	</div>\r\n" + 
					" <br><br><br><div><form action=\"show_reports\"><button  class=\"btn btn-info\" type=\"submit\">Show Reports</button></form></div> " +
					"	\r\n" + 
					"	</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}else {
			
			out.println("Unauthorized login");
		}
	}

}
