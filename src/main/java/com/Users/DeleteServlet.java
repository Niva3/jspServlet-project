package com.Users;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Users.UserModel;
import com.Users.UserDAO;

public class DeleteServlet extends HttpServlet
{
	UserModel rm = new UserModel();
	UserDAO rgd = new UserDAO();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		
		try
		{
			int id = Integer.parseInt(request.getParameter("deleteID"));
			rm.setID(id);
			
			int result = rgd.deleteUser(rm, id, out);
			
			if(result==0)
			{
				out.print("user not deleted");
			}
		}
		catch(Exception e)
		{
			out.print("****: "+e+"****");
		}
	}
}