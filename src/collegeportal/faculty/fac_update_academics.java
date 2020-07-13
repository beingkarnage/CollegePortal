package collegeportal.faculty;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update_academics")
public class fac_update_academics extends HttpServlet {

   
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		
		
		boolean exists=(boolean)sess.getAttribute("exists");
		boolean isLogin=(boolean)sess.getAttribute("isLogin");
		String msg= (String)sess.getAttribute("msg");
		PrintWriter out = res.getWriter();
		out.println("\r\n" + 
				"<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"\r\n" + 
				"    <title>Update Academics</title>\r\n" + 
				"\r\n" + 
				"    <meta name=\"description\" content=\"Source code generated using layoutit.com\">\r\n" + 
				"    <meta name=\"author\" content=\"\">\r\n" + 
				"\r\n" + 
				 
				"	<link href=\"js/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"  <nav class=\"navbar navbar-inverse navbar-expand-lg navbar-dark bg-dark\" style=\"position:static\r\n" + 
				"	\">\r\n" + 
				"  <a class=\"navbar-brand\" href=\"#\"></a>\r\n" + 
				"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor02\" aria-controls=\"navbarColor02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"  </button>\r\n" + 
				"\r\n" + 
				"  <div class=\"collapse navbar-collapse\" id=\"navbarColor02\">\r\n" + 
				"    <ul class=\"navbar-nav mr-auto\">\r\n" + 
				"      <li class=\"nav-item active\">\r\n" + 
				"        <a class=\"nav-link\" href=\"std_home\"> <span class=\"sr-only\">(current)</span></a>\r\n" + 
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
				"    <form action=\"logt\"><button type=\"submit\" class=\"btn btn-outline-primary\" size=\"30px;\"style=\"border-radius:26px;\">\r\n" + 
				"						Logout\r\n" + 
				"					</button></form>\r\n" + 
				"  </div>\r\n" + 
				"</nav>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-md-12\">\r\n" + 
				"			\r\n" + 
				"				\r\n" + 
				"			<br>\r\n" + 
				"			<br>\r\n" + 
				"			<br>\r\n" + 
				"			<br>\r\n" + 
				"			<br>\r\n" + 
				"			<br>\r\n" + 
				"	\r\n" + 
				"			\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-md-12\">\r\n" + 
				"			<div class=\"row\">\r\n" + 
				"				<div class=\"col-md-2\">\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col-md-8\">\r\n" + 
				"					<table class=\"table\">\r\n" + 
				"						<thead>\r\n" + 
				"							<tr class=\"table-dark text-primary\">\r\n" + 
				"								<th>\r\n" + 
				"									Update Academics");
		if(msg.contentEquals("A")) {
			out.println("<p class=\"text-warning\">Student Updated</p>");
			sess.setAttribute("msg","0");
		}else if(exists) {
			out.println("<p class=\"text-success\">Student Found</p>");
			sess.setAttribute("msg","0");
		}
		else {
			out.println("<p class=\"text-danger\">No new student updated yet</p>");
		}
		out.println(
				"								</th>\r\n" + 
				"								<th>\r\n" + 
				"									\r\n" + 
				"								</th>\r\n" + 
				"								\r\n" + 
				"									\r\n" + 
				"								\r\n" + 
				"							</tr>\r\n" + 
				"						</thead>\r\n" + 
				"						<tbody>\r\n" + 
				"							<tr class=\"table-secondry\">\r\n" + 
				"								<td>\r\n" + 
				"								<form action=\"_update_academics\">	Roll No \r\n" + 
				"								</td>\r\n" + 
				"								<td  >\r\n" + 
				"								<input type=\"text\" name=\"roll_no\" required>&emsp;<button style=\"border-radius:7px;\" class=\"btn btn-info\" type=\"submit\">Find Student</button>"+ 
				"								</td>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"							</tr>\r\n" +
				"							<tr class=\"table-dark\">\r\n" + 
				"								<td>\r\n" + 
				"									Subject\r\n" + 
				"								</td>\r\n" + 
				"								<td >" + 
				"									<input type=\"text\" name=\"subject\">"+ 
				"								</td>\r\n" + 
				"								\r\n" + 
				"							</tr>\r\n" + 
	
				"							<tr class=\"table-dark\">\r\n" + 
				"								<td>\r\n" + 
				"									Marks\r\n" + 
				"								</td>\r\n" + 
				"								<td >\r\n" + 
				"									<input type=\"text\" name=\"marks\">" + 
				"								</td>\r\n" +
												
				"								\r\n" + 
				"							</tr>\r\n" );
					
					
				if(exists){
out.println(
"							<tr align=\"center\"><td colspan=\"2\">\r\n" + 
"							<button type=\"submit\"class=\"btn btn-warning\r\n" + 
"							\" style=\"border-radius:26px;\">Update</button></form>\r\n" + 
"							</td>\r\n" + 
"							</tr>\r\n"); 
exists=false;}else {
	out.println(
			"							<tr align=\"center\"><td colspan=\"2\">\r\n" + 
			"							<button type=\"submit\"class=\"btn btn-warning\r\n" + 
			"							\" style=\"border-radius:26px;\" disabled>Update</button></form>\r\n" + 
			"							</td>\r\n" + 
			"							</tr>\r\n"); 	
	
}
				out.println(
				"							<tr align=\"center\"><td colspan=\"2\">\r\n" + 
				"							<form action=\"fac_ho\"><button type=\"submit\"class=\"btn btn-outline-success\r\n" + 
				"							\" style=\"border-radius:26px;\">Back to Home</button></form>\r\n" + 
				"							</td>\r\n" + 
				"							</tr>\r\n" + 
				"						</tbody>\r\n" + 
				"					</table>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"col-md-2\">\r\n");
				
				out.println("				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"    <script src=\"js/jquery.min.js\"></script>\r\n" + 
				"    <script src=\"js/bootstrap.min.js\"></script>\r\n" + 
				"    <script src=\"js/scripts.js\"></script>\r\n" + 
				"  </body>\r\n" + 
				"</html>");

	}


}
