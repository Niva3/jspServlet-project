package com.Users;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			session.removeAttribute("user");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
		}
	}
}