import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class download_file extends HttpServlet {
 
    protected void doGet(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        // reads input file from an absolute path
    	//String file=request.getParameter("ntf_uid");
     try {
    	String ntf_id=req.getParameter("ntf_id");
    	String filepath="C:/Users/intel/Desktop/collegetemp/"+ntf_id+"/"+ntf_id;
    	HttpSession sess = req.getSession(); 
    	String type = (String)sess.getAttribute("login_type");
    	
    	File ex=new File(filepath+".txt");
    	
    	if(ex.exists()) {
    		System.out.println("sending txt file");
    	}else {
	    	ex = new File(filepath+".pdf");
	    	if(ex.exists()) {
	    		System.out.println("sending pdf");
	    		}else {
	    			ex= new File(filepath+".xls");
	    			if(ex.exists()) {
	    				System.out.println("sending xls file");
	    			  				}else {
	    			  					ex=new File(filepath+".docx");
	    			  					if(ex.exists()) {
	    			  					System.out.println("sending docx");
	    			  									}else {
	    			  										ex=new File(filepath+".jpg");
	    			  										if(!ex.exists())
	    			  											System.out.println("no attachment present");
	    			  											sess.setAttribute("msg","N");
	    			  											if(type.contentEquals("admin"))res.sendRedirect("admin_home");
	    			  											else res.sendRedirect(type+"_ho");
	    			  									      }
	    			  					 }
	    			   }
    	      }
    	
        String filePath = "C:/Users/intel/Desktop/collegetemp/1/*";
        File downloadFile = ex;
       
        FileInputStream inStream = new FileInputStream(downloadFile);
        
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        res.setContentType(mimeType);
        res.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        res.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = res.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();     }catch(Exception e) {
        	e.getMessage();
        }
    }
}