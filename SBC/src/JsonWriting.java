

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

/**
 * Servlet implementation class JsonWriting
 */
@WebServlet("/JsonWriting")
public class JsonWriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 JSONArray SBCObjectList = new JSONArray();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonWriting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		System.out.println("Hey im at JsonWriting");
		String s1=request.getParameter("sino");
		String s2=request.getParameter("BoxName");
		String s3=request.getParameter("Ip");
		String s4=request.getParameter("UserName");
		String s5=request.getParameter("password");
		String s6=request.getParameter("BmcIp");
		
		String s7=request.getParameter("BmcIpusername");
		String s8=request.getParameter("BmcPass");
		String s9=request.getParameter("SoftwareLoad");
		String s10=request.getParameter("Assign");
		String s11=request.getParameter("ReversedBy");
		String s12=request.getParameter("Reserved");
		String s13=request.getParameter("Vlan");
		String s14=request.getParameter("Cmts");
		JSONObject SBCDetails = new JSONObject();
		SBCDetails.put("si.no", s1);
		SBCDetails.put("BoxName", s2);
		SBCDetails.put("Ip",s3);
		SBCDetails.put("UserName", s4);
		SBCDetails.put("password", s5);
		SBCDetails.put("BmcIp", s6);
		SBCDetails.put("BmcIpusername",s7);
		SBCDetails.put("BmcPass", s8);
		SBCDetails.put("SoftwareLoad", s9);
		SBCDetails.put("Assign", s10);
		SBCDetails.put("ReversedBy", s11);
		SBCDetails.put("Reserved",s12);
		SBCDetails.put("Vlan", s13);
		SBCDetails.put("Cmts", s14);
		JSONObject SBCObject = new JSONObject();
		SBCObject.put("SBC", SBCDetails);
		SBCObjectList.add(SBCObject);
		
		
		try (FileWriter file = new FileWriter("C:\\Users\\cprakash\\Desktop\\DisplaySBC.json")) {
			 
            file.write(SBCObjectList.toJSONString());
            file.flush();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sucess");
    	    requestDispatcher.include(request, response);
    		response.getWriter().append("Served at: ").append(request.getContextPath());
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
