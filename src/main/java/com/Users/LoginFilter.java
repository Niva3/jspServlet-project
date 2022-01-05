package com.Users;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginFilter implements Filter
{
	public void init(FilterConfig config) throws ServletException {}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException 
	{  
		String passDB="";
		String role="";
		resp.setContentType("text/html");
	    PrintWriter out=resp.getWriter();  
	    
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) resp;
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement smt = con.createStatement();
			String uname = request.getParameter("username");
			String pass = request.getParameter("password");
			String strQuery = "SELECT Password,Role FROM users where Username ='"+uname+"'";
			ResultSet rs = smt.executeQuery(strQuery);
			while(rs.next())
			{
				passDB = rs.getString("Password");
				role = rs.getString("Role");
			}
			if(pass.equals(passDB) && role.equalsIgnoreCase("user"))
			{  
			   chain.doFilter(req, resp);  
			}  
			else if(pass.equals(passDB) && role.equalsIgnoreCase("admin"))
			{
				RequestDispatcher rqd=req.getRequestDispatcher("admin.jsp");
				rqd.forward(req, resp);
			}
			else
			{  
				out.print("<b style=\"color: white\">Invalid Credentials!<b>");  
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");  
				rd.include(req, resp);  
			}  
	    }
	    
	    catch (Exception e)
		{
			e.printStackTrace();
		}
	             
	}  
	    public void destroy() {}  
}