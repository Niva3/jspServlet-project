package com.Users;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	UserDAO rd = new UserDAO();
	AddressDAO ad = new AddressDAO();
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		
		try {
			System.out.println("===================test======================");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter(); 
			out.println("testing");
			
			
			String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String gender = request.getParameter("gender");
	        String contact = request.getParameter("contact");
	        String role = "user";
	        
	       /* out.println(role);
	        out.println(username);
	        out.println(email);
	        out.println(gender);*/
	        
	        
	        String languages="";
	        String lang[] = request.getParameterValues("lang");
	        for(int i=0; i<lang.length;i++)
	        {
	        	languages = languages + lang[i] + " ";
	        }
	        
	        String line1[] = request.getParameterValues("address1");
	        String line2[] = request.getParameterValues("address2");
	        String city[] = request.getParameterValues("city");
	        String country[] = request.getParameterValues("country");
	        String state[] = request.getParameterValues("state");
	        String pin[] = request.getParameterValues("pincode");
	        
	        int total_addresses = line1.length;
	        
	        out.println("add: "+total_addresses);
	        
	        for(int i=0;i<total_addresses;i++)
	        {
	        	out.print(line1[i]+" ");
	        }
	        //out.println(line1);
	        
	        UserModel rm = new UserModel();
	        AddressModel am = new AddressModel();
	        
	        rm.setFirstName(firstName);
	        rm.setLastName(lastName);
	        rm.setUsername(username);
	        rm.setEmail(email);
	        rm.setPassword(password);
	        rm.setRole(role);
	        rm.setGender(gender);
	        rm.setLanguages(languages);
	        rm.setContact(contact);
	        
	       // out.println(rm.getFirstName());
	        
	        for(int i=0; i<line1.length; i++)
	        {
	        	am.setLine1(line1[i]);
	        }
	        for(int i=0; i<line1.length; i++)
	        {
	        	String l1=am.getLine1(i);
	        	out.println("function:"+l1);
	        }
	        for(int i=0; i<line2.length; i++)
	        {
	        	am.setLine2(line2[i]);
	        }
	        for(int i=0;i<city.length; i++)
	        {
	        	am.setCity(city[i]);
	        }
	        for(int i=0;i<country.length; i++)
	        {
	        	am.setCountry(country[i]);
	        }
	        for(int i=0;i<state.length; i++)
	        {
	        	am.setState(state[i]);
	        }
	        for(int i=0;i<pin.length; i++)
	        {
	        	am.setPin(pin[i]);
	        }
	        
	        int result1 = rd.registerUser(rm);
	        
	        
	        int result2=0;
	        //result2 = ad.registerAddr(am);
	        try {
	        	for(int i=0; i<total_addresses; i++)
		        {
		        	out.println(i);
		        	out.println(am.toString());
		        	if(ad==null)
		        	{
		        		out.print("DAO is null");
		        	}
		        	result2=ad.registerAddr(am,i,username,out);
		        }
	        }
	        catch(Exception e)
	        {
	        	out.println("LOOP:"+e);
	        	
	        }
	        out.println("result1: "+result1);
	        out.println("result2: "+result2);
	        
	        if(result1>0 && result2>0)
	        {
	        	RequestDispatcher rqd = request.getRequestDispatcher("success.jsp");
		        rqd.forward(request, response);
	        }
	        else
	        {
	        	out.println("user not registered");
	        }
	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
         
	}

}