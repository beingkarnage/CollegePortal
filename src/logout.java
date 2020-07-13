

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logout() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession sess=req.getSession();
	String l=(String)sess.getAttribute("login_type");
	sess.invalidate();
	if(l.contentEquals("std")) {
		res.sendRedirect("/sa");
	}else if(l.contentEquals("fac")){
		res.sendRedirect("/sa");
		}else if(l.contentEquals("admin")) {
			res.sendRedirect("admin_login.html");
		}
	}

}
