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
       
        	int id = rm.getID();
        	
        	/*String line1 = am.getLine1(0);
        	String line2 = am.getLine2(0);
        	String city = am.getCity(0);
        	String pin = am.getPin(0);*/
        	
        	request.setAttribute("id",id);
        	request.setAttribute("uname",username);
        	request.setAttribute("fname",fname);
        	request.setAttribute("lname",lname);
        	request.setAttribute("email",email);
        	
        	/*request.setAttribute("line1", line1);
        	request.setAttribute("line2", line2);
        	request.setAttribute("city", city);
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