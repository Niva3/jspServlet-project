package com.Users;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Users.UserModel;
import com.Users.UserDAO;

public class LoginServlet extends HttpServlet
{
	public UserDAO rd = new UserDAO();
	public AddressDAO ad = new AddressDAO();
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		
		UserModel rm = new UserModel();
		AddressModel am = new AddressModel();
		
		if(rm!=null)
		{
			HttpSession session = request.getSession();
            session.setAttribute("user",rm);
		}
        try
        {
        	rd.loginUser(rm,username);
        	String fname = rm.getFirstName();
        	String lname = rm.getLastName();
        	String email = rm.getEmail();
        	String gender = rm.getGender();
        	String language = rm.getLanguages();
        	String contact = rm.getContact();
        	String password = rm.getPassword();
        	String role = rm.getRole();
       
        	int id = rm.getID();
        	
        	request.setAttribute("id",id);
        	request.setAttribute("uname",username);
        	request.setAttribute("fname",fname);
        	request.setAttribute("lname",lname);
        	request.setAttribute("email",email);
        	request.setAttribute("gender",gender);
        	request.setAttribute("contact",contact);
        	request.setAttribute("language",language);
        	request.setAttribute("password",password);
        	request.setAttribute("role",role);
        	
        	/*ad.getAddress(am,1);
        	String line1 = am.getLine1(0);
        	out.print(" line1:"+line1);
        	String line2 = am.getLine2(0);
        	out.print("  line2:"+line2);
        	String city = am.getCity(0);
        	out.print("  city:"+city);
        	String state = am.getState(0);
        	out.print("  state:"+state);
        	String country = am.getCountry(0);
        	out.print("  country:"+country);
        	String pin = am.getPin(0);
        	out.print("  pin:"+pin);
        	
        	request.setAttribute("line1", line1);
        	request.setAttribute("line2", line2);
        	request.setAttribute("city", city);
        	request.setAttribute("state", state);
        	request.setAttribute("country", country);
        	request.setAttribute("pin", pin);*/
        	
        	RequestDispatcher rqd =  request.getRequestDispatcher("login.jsp");
        	rqd.forward(request, response);
        	
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
		
	}
}