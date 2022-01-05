<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>
 <%@ page import="java.util.*" %>
 <%@ page import="com.Users.UserModel" %>
 <%@ page import="com.Users.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Page</title>
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
 	<link rel="stylesheet" href="./style.css">
</head>
<style>
	td,th{
	border: 1px solid black;
	text-align: center;
	padding: 10px;
	}
</style>
<body>
 <h1 style="color: white">Welcome Admin!</h1><br>
 <div align="center" id="registerForm">
 
  	<h3>List of all the Users : </h3><br><br>
  	<% 
  		UserDAO rd = new UserDAO();
  		List<UserModel> list = rd.getUsers(); 
  	%>
     <table>
     	<tr >
     		<th>ID</th>
     		<th>User Name</th>
     		<th>First Name</th>
     		<th>Last Name</th>
     		<th>Email</th>
     		<th>Password</th>
     	</tr>
     	<% 
     		for(UserModel rm:list)
     		{
     			out.print("<tr><td>"+rm.getID()+"</td><td>"+rm.getUsername()+"</td><td>"+rm.getFirstName()+"</td><td>"+rm.getLastName()+"</td><td>"+rm.getEmail()+"</td><td>"+rm.getPassword()+"</td></tr>");
     		}
     	%>
     </table>
     <br><br>
    <div id="adminDiv" style="display:inline-flex;">
    	
 		<form action="edit.jsp" method="post">
 			
     		<input type="submit" value="EDIT USER"/>
     		
     	</form>
    	<form action="delete.jsp" method="post">
    		
     		<input type="submit" value="DELETE USER"/>
     		
     	</form>
     	<form action="<%= request.getContextPath() %>/logout" method="post">
     		
			<input type="submit" value="LogOut"></input>
			
	    </form> 
	    
	</div>
	
 </div>
 
</body>
</html>