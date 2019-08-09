import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
@WebServlet("/JsonWriting")
public class JsonWriting extends HttpServlet
{
	 private static final long serialVersionUID = 1L;
	 JSONArray SBCObjectList = new JSONArray();   
		     public JsonWriting()
		     {
		        super();
		     }
	      @SuppressWarnings({ "unused", "unchecked" })
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
				PrintWriter pw=response.getWriter();
				response.setContentType("text/html");
				System.out.println("Hey im at JsonWriting");
				JSONObject SBCDetails = new JSONObject();
				SBCDetails.put("sino", request.getParameter("sino"));
				SBCDetails.put("BoxName", request.getParameter("BoxName"));
				SBCDetails.put("Ip",request.getParameter("Ip"));
				SBCDetails.put("UserName", request.getParameter("UserName"));
				SBCDetails.put("password", request.getParameter("password"));
				SBCDetails.put("BmcIp", request.getParameter("BmcIp"));
				SBCDetails.put("BmcIpusername",request.getParameter("BmcIpusername"));
				SBCDetails.put("BmcPass", request.getParameter("BmcPass"));
				SBCDetails.put("SoftwareLoad", request.getParameter("SoftwareLoad"));
				SBCDetails.put("Assign",request.getParameter("Assign"));
				SBCDetails.put("ReversedBy",request.getParameter("ReversedBy"));
				SBCDetails.put("Reserved",request.getParameter("Reserved"));
				SBCDetails.put("Vlan",request.getParameter("Vlan"));
				SBCDetails.put("Cmts", request.getParameter("Cmts"));
				JSONObject SBCObject = new JSONObject();
				SBCObject.put("SBC", SBCDetails);
				SBCObjectList = getRecords();
				SBCObjectList.add(SBCObject);
						try (FileWriter file = new FileWriter("C:\\Users\\cprakash\\Desktop\\DisplaySBC.json"))
						{
							 
				            file.write(SBCObjectList.toJSONString());
									            file.flush();
								/*
								 * RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sucess");
								 * requestDispatcher.include(request, response);
								 */
							pw.println("<html><head></head><body><h4>Record Inserted Sucessfully!</h4></body></html>");
				 
				        } 
						catch (Exception e) 
						{
				            e.printStackTrace();
				        }
				
				
			}
	private JSONArray getRecords() throws IOException {
		
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("C:\\Users\\cprakash\\Desktop\\DisplaySBC.json"))
		{
			
		        	Object obj = jsonParser.parse(reader);
					JSONArray employeeList = (JSONArray) obj;
					return employeeList;
 
		} 
		catch(Exception e)
		{
	         
		}


   return new JSONArray();




}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
