import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
@WebServlet("/SbcDetails")
public class SbcDetails extends HttpServlet
{
		private static final long serialVersionUID = 1L;
	    public SbcDetails() 
	    {
	        super();
	       
	    }
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
			String userName = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null)
			{
				for(Cookie cookie : cookies)
				{
					if(cookie.getName().equals("userName")) 
						userName = cookie.getValue();
				}
			}
		if(userName == null)
			response.sendRedirect("Login.jsp");
		
		System.out.println("hello");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		JSONParser jsonParser = new JSONParser();
		pw.println("<h1>SBC Details</h1>"); 
		File k = new File("C:\\Users\\cprakash\\Desktop\\DisplaySBC.json");
		 pw.println("<html>");  
			pw.println("<head> <link rel='stylesheet' type='text/css' href='SbcDetails.css'> </head>");
			pw.println("<body>");
			pw.println("<table border=\"1\" align=\"center\" width=\"400\" bgcolor=\"#CCCCCC\">");
			pw.println("<tr>");
				pw.print("<th>Si.No</th>"); 
				pw.println("<th>BoxName</th>");pw.println("<th>Ip</th>");pw.println("<th>UserName</th>");
				pw.println("<th>password</th>");pw.println("<th>BmcIp</th>");
				pw.println("<th>BmcIpusername</th>");pw.println("<th>BmcPass</th>");pw.println("<th>SoftwareLoad</th>");
				pw.println("<th>Assign</th>");pw.println("<th>ReversedBy</th>");
				pw.println("<th>Reserved</th>");pw.println("<th>Vlan</th>");pw.println("<th>Cmts</th>");
			pw.println("</tr>");
			pw.println("<br>");
			
		if(k.length()==0)
		{
			
			pw.println("<h3 align='center' color='red'>No Details Were Found! </h3>");
			
		}
		else
		{
			 
			
				try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\DisplaySBC.json"))
				{
							Object obj = jsonParser.parse(reader);
							JSONArray employeeList = (JSONArray) obj;
						    System.out.println(employeeList.size());
						    Iterator m=employeeList.iterator();
					  for(int i=0;i<employeeList.size();i++)
						  {
						   JSONObject j=(JSONObject) m.next() ;
						   JSONObject employeeObject = (JSONObject) j.get("SBC"); 
					        pw.println("<tr>");
					                pw.println("<td>"+(String) employeeObject.get("sino")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("BoxName")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("Ip")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("UserName")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("password")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("BmcIp")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("BmcIpusername")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("BmcPass")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("SoftwareLoad")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("Assign")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("ReversedBy")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("Reserved")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("Vlan")+"</td>");
					                pw.println("<td>"+(String) employeeObject.get("Cmts")+"</td>");
					        pw.println("</tr>");
					        
							 
						  }
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				}
	       }
		pw.println("</table></br></br>");
		pw.println("<div class='btn' align='center'>");
		pw.println("<form action='Logout' method='get' >");
		 pw.println("<input type='submit' value='LOGOUT' class='btn1'> </form>"); 
		 
		 pw.println("<a href='\\SBC_DETAILS\\SbcDetails.jsp' target=\"_blank\"> <input type='submit' value='Add SBC' class='btn1'> </link>");
		 pw.println("</div>");
		 pw.println("</body>");
		 pw.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
