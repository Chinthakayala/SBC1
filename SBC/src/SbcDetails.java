

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class SbcDetails
 */
@WebServlet("/SbcDetails")
public class SbcDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SbcDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		JSONParser jsonParser = new JSONParser();
		pw.println("<h1>SBC Details</h1>"); /* res.sendRedirect("/redirect.html");C:\\Users\\cprakash\\eclipse-workspace\\SBC\\WebContent */
		
		File k = new File("C:\\Users\\cprakash\\Desktop\\DisplaySBC.json");
		 pw.println("<html>");  
			pw.println("<head> <link rel='stylesheet' type='text/css' href='style_SbcDetails.css'> </head>");
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
					//Read JSON file
							Object obj = jsonParser.parse(reader);
				 
							JSONArray employeeList = (JSONArray) obj;
							//System.out.println(employeeList);
							
							 System.out.println(employeeList.size());
							//Iterate over employee array
						 // employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ,s1,s2) );
					
						 Iterator m=employeeList.iterator();
						 
						
						 for(int i=0;i<employeeList.size();i++)
						 {
						   JSONObject j=(JSONObject) m.next() ;
						   JSONObject employeeObject = (JSONObject) j.get("SBC"); 
					         
					        //Get employee first name
					        String s1 = (String) employeeObject.get("sino");  
					        String s2 = (String) employeeObject.get("BoxName"); 
					        String s3 = (String) employeeObject.get("Ip"); 
					        String s4 = (String) employeeObject.get("UserName");  
					        String s5 = (String) employeeObject.get("password"); 
					        String s6 = (String) employeeObject.get("BmcIp"); 
					        String s7 = (String) employeeObject.get("BmcIpusername"); 
					        String s8 = (String) employeeObject.get("BmcPass"); 
					        String s9 = (String) employeeObject.get("SoftwareLoad"); 
					        String s10 = (String) employeeObject.get("Assign"); 
					        String s11 = (String) employeeObject.get("ReversedBy"); 
					        String s12 = (String) employeeObject.get("Reserved"); 
					        String s13 = (String) employeeObject.get("Vlan"); 
					        String s14 = (String) employeeObject.get("Cmts"); 
					        
					     
						/* System.out.println(s1+" 	 "+s2+"		"+s3+"     "+s4+"   "+s5+"    "+s6); */
					        pw.println("<tr>");
					                pw.println("<td>"+s1+"</td>");pw.println("<td>"+s2+"</td>");
					                pw.println("<td>"+s3+"</td>");pw.println("<td>"+s4+"</td>");
					                pw.println("<td>"+s5+"</td>");pw.println("<td>"+s6+"</td>");
					                pw.println("<td>"+s7+"</td>");pw.println("<td>"+s8+"</td>");
					                pw.println("<td>"+s9+"</td>");pw.println("<td>"+s10+"</td>");
					                pw.println("<td>"+s11+"</td>");pw.println("<td>"+s12+"</td>");
					                pw.println("<td>"+s13+"</td>");pw.println("<td>"+s14+"</td>");
					        pw.println("</tr>");
					        
							 
						 }
						 
		 
						 
		 
				} 
					catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e)
					{
						e.printStackTrace();
					} 
					catch (ParseException e)
					{
						System.out.println();e.printStackTrace();
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				/*
				 * response.getWriter().append("Served at: ").append(request.getContextPath());
				 */
	       }
		pw.println("</table>");
		pw.println("<br><br>");
		 pw.println("<a href=''><input type='submit' value='LOGOUT'>");
		 pw.println("<a href='\\SBC\\SbcDetails.html'> <input type='submit'value='Add SBC'> </a>");
		 pw.println("</body>");
		 pw.println("</html>");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
