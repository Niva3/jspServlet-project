<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forgot Password Procedure</title>
	</head>
<body>
	<%
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement st=con.createStatement();
			String email=request.getParameter("email");
			String strQuery = "SELECT Password FROM Users where email='"+email+"'";
			ResultSet rs = st.executeQuery(strQuery);
			rs.next();
			String pass = rs.getString("Password");
			String newPass=request.getParameter("newPass");
			if(pass.equals(newPass))
			{
				out.println("<b>You cannot enter your old password</b>");
			}
			else
			{
				String update = "UPDATE users SET Password = '"+newPass+"' where Email='"+email+"'";
				int result=st.executeUpdate(update);
				if(result>0)
				{
			 		out.println("<b>Password Changed Successfully!<b>");
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	%>
	<div align="center">
		<form action="index.jsp" method="post">
			<h4>Please Login with new Credentials</h4><br/>
			<input type="submit" value ="Login"/>
		</form>
	</div>
</body>
</html>