

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/std_createpost")
public class std_createpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public std_createpost() {
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		HttpSession sess=req.getSession();
		String code=(String)sess.getAttribute("code");
		out.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"  <head>\r\n" + 
				"    <title>Post Notifications</title>\r\n" + 
				"\r\n" + 
				"    <meta name=\"description\" content=\"Source code generated using layoutit.com\">\r\n" + 
				"    <meta name=\"author\" content=\"LayoutIt!\">\r\n" + 
				"\r\n" + 
		
				"	<link href=\"js/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"<nav class=\"navbar navbar-inverse navbar-expand-lg navbar-dark bg-dark\" style=\"position:static\r\n" + 
				"	\">\r\n" + 
				"  <a class=\"navbar-brand\" href=\"#\"></a>\r\n" + 
				"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor02\" aria-controls=\"navbarColor02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"  </button>\r\n" + 
				"\r\n" + 
				"  <div class=\"collapse navbar-collapse\" id=\"navbarColor02\">\r\n" + 
				"    <ul class=\"navbar-nav mr-auto\">\r\n" + 
				"      <li class=\"nav-item active\">\r\n" + 
				"        <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\r\n" + 
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
				"	\r\n" + 
				"    <button type=\"button\" class=\"btn btn-outline-primary\" size=\"30px;\"style=\"border-radius:26px;\">\r\n" + 
				"						Logout\r\n" + 
				"					</button>\r\n" + 
				"  </div>\r\n" + 
				"</nav>\r\n"); 
				
			out.println(
				"<br><br>\r\n" + 
				"<h1 align=\"center\">Create Post</h1>\r\n" + 
				"    <div class=\"container-fluid\">\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-md-12\">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-md-12\">\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-md-1\">\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-md-10\">\r\n" + 
				"			<form method=\"post\" action=\"UploadServlet\"role=\"form\" enctype=\"multipart/form-data\">\r\n" + 
				"				<div class=\"form-group\">\r\n" + 
				"					 \r\n" + 
				"					<label for=\"exampleInputEmail1\">\r\n" + 
				"						Subject\r\n" + 
				"					</label>\r\n" + 
				"					<input type=\"text\" name=\"sub\" class=\"form-control\" placeholder=\"Subject\"maxlength=\"35\"id=\"exampleInputEmail1\"  required/>\r\n" + 
				"	</div><div class=\"form-group\">			"
				+ "<input type=\"file\" name=\"uploadFile\" >"
				+ "</div>\r\n" + 
				"				<div class=\"form-group\">\r\n" + 
				"					 \r\n" + 
				"					<label for=\"exampleInputPassword1\">\r\n" + 
				"						Person of Responsiblity\r\n" + 
				"					</label>\r\n" + 
				"					<input type=\"text\" name=\"writer\" class=\"form-control\" placeholder=\"Person of Responsiblity \" maxlength=\"15\"id=\"exampleInputEmail1\"  />\r\n" + 
				"					\r\n" + 
				"				</div>\r\n" +
				"<label class=\"radio-container m-r-45\">Student\r\n" + 
				"                                            <input type=\"radio\" name=\"privacy\" value=\"s\" >\r\n" + 
				"                                            <span class=\"checkmark\"></span>\r\n" + 
				"                                        </label>\r\n" + 
				                                    
				"										<label class=\"radio-container\">All\r\n" + 
				"                                            <input type=\"radio\" name=\"privacy\" value=\"a\" >\r\n" + 
				"                                            <span class=\"checkmark\"></span>\r\n" + 
				"                                        </label>"+
				"				<div class=\"form-group\">\r\n" + 
				"					 \r\n" + 
				"					<label for=\"exampleInputPassword1\">\r\n" + 
				"						Description\r\n" + 
				"					</label>\r\n" + 
				"					\r\n" + 
				"					<textarea maxlength=\"250\"  name=\"ntf\"placeholder=\"Write Description (250 Words)\" style=\"font-size:12pt;height:250px;width:100%\"  required></textarea>\r\n" + 
				"				</div>\r\n" + 
				"				<input type=\"hidden\" value=\"ntf\" name=\"type\">" + 
				"				<button style=\"height:50px;width:300px;position:absolute;left:450px;border-radius:25px\"align=\"center\" type=\"submit\" class=\"btn btn-outline-success btn-lg\" >\r\n" + 
				"					    Post     \r\n" + 
				"				</button>\r\n" + 
				"			</form>\r\n" + 
				"			<button class=\"btn btn-sm btn-outline-warning\r\n" + 
				"							\" style=\"border-radius:26px;\">Back to Home</button>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"col-md-1\">\r\n" + 
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

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

}


