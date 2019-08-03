
import javax.servlet.http.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;   
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.*;
import java.util.*;

/**
 * Servlet implementation class Sbc
 */
@WebServlet("/Sbc")
public class Sbc extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Sbc() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("YES");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		String s1=req.getParameter("userName");
		String s2=req.getParameter("userPassword");

		/*
		 * if(s1.equals("java4s")&&s2.equals("java4s")) pw.println("Login Success...!");
		 * else pw.println("Login Failed...!"); pw.close();
		 */
		 
		JSONParser jsonParser = new JSONParser();
		 int z=0;   
		// System.out.println(System.getProperty("java.class.path"));
			//C:\Users\cprakash\Downloads\apache-tomee-8.0.0-M3-webprofile\webapps\student\src
		 //String path="C:/Users/cprakash/eclipse-workspace/SBC/WebContent/employees.json";
				try (FileReader reader = new FileReader("/SBC/WebContent/employees.json"))
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
						   z = parseEmployeeObject( (JSONObject) m.next() ,s1,s2);
							   if(z==1)
							   {
								   break;
								   
							   }
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
		
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private int parseEmployeeObject(JSONObject employee,String k,String l)
    {
         //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee"); 
         
        //Get employee first name
        String userName = (String) employeeObject.get("userName");   
        System.out.println(userName);
		
         System.out.println(k);
        //Get employee last name
        String password = (String) employeeObject.get("password"); 
        System.out.println(password);
		System.out.println(l);
		if(userName.equals(k) && password.equals(l))
		{
			System.out.println("Sucess");
			return 1;
			
		}
		
		
       return 0;
        //Get employee website name
        
    }

}
