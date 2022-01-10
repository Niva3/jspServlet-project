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

public class EditServlet extends HttpServlet
{
	UserModel rm = new UserModel();
	UserDAO rgd = new UserDAO();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		try
		{
			HttpSession session = request.getSession();
			int id = (int)session.getAttribute("id");
			rm.setID(id);
			
			if(request.getParameter("efirstName")!=null)
			{
				String editedFirstName = request.getParameter("efirstName");
				rm.setFirstName(editedFirstName);
			}
			if(request.getParameter("elastName")!=null)
			{
				String editedLastName = request.getParameter("eLastName");
				rm.setLastName(editedLastName);
			}
			if(request.getParameter("eUserName")!=null)
			{
				String editedUserName = request.getParameter("eUserName");
				rm.setUsername(editedUserName);
			}
			if(request.getParameter("eEmail")!=null) 
			{
				String editedEmail = request.getParameter("eEmail");
				rm.setEmail(editedEmail);
			}
			if(request.getParameter("eGender")!=null) 
			{
				String editedGender = request.getParameter("eGender");
				rm.setGender(editedGender);
			}
			if(request.getParameter("eLang")!=null) 
			{
				String editedLang = request.getParameter("eLang");
				rm.setLanguages(editedLang);
			}
			if(request.getParameter("eContact")!=null) 
			{
				String editedContact = request.getParameter("eContact");
				rm.setContact(editedContact);
			}
			
			int res = rgd.editUser(rm,id);
			if(res>0)
			{
				System.out.println("edited");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}