
import javax.servlet.http.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;   
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.*;
import java.util.*;
@SuppressWarnings("unused")
@WebServlet("/Sbc")
public class Sbc extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public Sbc() {
	}

	
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("YES");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		String s1=req.getParameter("userName");
		String s2=req.getParameter("userPassword");

		JSONParser jsonParser = new JSONParser();
		 int z=0;   

				try (FileReader reader = new FileReader("C:/Users/cprakash/eclipse-workspace/SBC/WebContent/employees.json"))
				{
					
							Object obj = jsonParser.parse(reader);
				 
							JSONArray employeeList = (JSONArray) obj;
							
							
							 System.out.println(employeeList.size());
							
						
						 Iterator m=employeeList.iterator();
						 for(int i=0;i<employeeList.size();i++)
						 {
						   z = parseEmployeeObject( (JSONObject) m.next() ,s1,s2);
							   if(z==1)
							   {
								   break;
								   
							   }
						 }
		 
				} 
					
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(z==1)
				{
					System.out.println("GO");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("SbcDetails");
				    requestDispatcher.include(req, res);
				    
				}
				else
				{
					pw.println("Invalid Credentials!");
				}
				
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	private int parseEmployeeObject(JSONObject employee,String k,String l)
    {
        JSONObject employeeObject = (JSONObject) employee.get("employee"); 
        String userName = (String) employeeObject.get("userName");   
        System.out.println(userName);
	    System.out.println(k);
        String password = (String) employeeObject.get("password"); 
        System.out.println(password);
		System.out.println(l);
		if(userName.equals(k) && password.equals(l))
		{
			System.out.println("Sucess");
			return 1;
			
		}	
       return 0;
        
    }

}
