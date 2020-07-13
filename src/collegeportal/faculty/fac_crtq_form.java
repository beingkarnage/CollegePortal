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
 * Servlet implementation class fac_crt_q
 */
@WebServlet("/fac_crt_q")
public class fac_crtq_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fac_crtq_form() {
        super();
    }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter out=res.getWriter();	 
		  out.println("\r\n" + 
		  		"\r\n" + 
		  		"<html lang=\"en\"><head>\r\n" + 
		  		"    <meta charset=\"utf-8\">\r\n" + 
		  		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
		  		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
		  		"\r\n" + 
		  		"    <title>Create Queue</title>\r\n" + 
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
		  		"						Create Queue\r\n" + 
		  		"					</h3>\r\n" + 
		  		"				</div>\r\n" + 
		  		"			</div>\r\n" + 
		  		"			<br>\r\n" + 
		  		"			\r\n" + 
		  		"				\r\n" + 
		  		"				<div class=\"col-md-12\" style=\"background-color:#2B3E50\">\r\n" + 
		  		"	<div class=\"row\">\r\n" + 
		  		"		<div class=\"col-md-12\">\r\n" + 
		  		"			<div class=\"row\">\r\n" + 
		  		"				<div align=\"center\" class=\"col-md-12\">\r\n" + 
		  		"					<div style=\"padding:25px;background-color: #4E5D6C\">\r\n" + 
		  		"					<form action=\"_create_queue\" method=\"Post\">\r\n" + 
		  		"						<label class=\"col-sm-2 col-form-label\">Queue Name</label>\r\n" + 
		  		"						<input type=\"text\" name=\"q_name\"></br>\r\n" + 
		  		"						<label class=\"col-sm-2 col-form-label\">Max Length</label>\r\n" + 
		  		"						<input type=\"text\" name=\"max_l\"></br>\r\n" + 
		  		"						<label class=\"col-sm-2 col-form-label\">Valid Till</label>\r\n" + 
		  		"						<input type=\"date\" name=\"valid\"></br></br>\r\n" + 
		  		"						<button class=\"btn btn-success\" type=\"submit\">Create Queue</button> \r\n" + 
		  		"					<button class=\"btn btn-outline-primary\" type=\"submit\">back to home</button>\r\n" + 
		  		"					</form></div>\r\n" + 
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
		  		"");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
