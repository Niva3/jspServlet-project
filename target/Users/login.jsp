<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.Users.AddressModel" %>
<%@ page import="com.Users.AddressDAO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Details</title>
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
 	<link rel="stylesheet" href="./style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(function(){
			$('#header').load("header.html");
			$('#footer').load("footer.html");
		})
	</script>
</head>
<style>
	td,th{
	border: 1px solid black;
	text-align: center;
	padding: 10px;
	}
</style>
<body>
	
 <div align="center">
  <h1 style="color: white">User Details</h1>
  <form id="loginForm" action="edit.jsp" method="post">
  
   <table style="width: 80%">
   <tr>
	     <td>ID</td>
	     <td>
	     	<%
	     		int id=(int)request.getAttribute("id");
				out.print(id);
				session.setAttribute("id",id);
			%>
		 </td>
    </tr>
    <tr>
	     <td>First Name</td>
	     <td>
	     	<%
	     		String firstname=(String)request.getAttribute("fname");
				out.print(firstname);
			%>
		 </td>
    </tr>
    <tr>
	     <td>Last Name</td>
	     <td>
	     	<%
	     		String lastname=(String)request.getAttribute("lname");
				out.print(lastname);
			%>
		 </td>
    </tr>
    <tr>
	     <td>UserName</td>
	     <td>
	     	<%
	     		String username=(String)request.getAttribute("uname");
				out.print(username);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Email</td>
	     <td>
	     	<%
	     		String email=(String)request.getAttribute("email");
				out.print(email);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Gender</td>
	     <td>
	     	<%
	     		String gender=(String)request.getAttribute("gender");
				out.print(gender);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Languages Known</td>
	     <td>
	     	<%
	     		String language=(String)request.getAttribute("language");
				out.print(language);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Contact</td>
	     <td>
	     	<%
	     		String contact=(String)request.getAttribute("contact");
				out.print(contact);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Password</td>
	     <td>
	     	<%
	     		String password=(String)request.getAttribute("password");
				out.print(password);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Role</td>
	     <td>
	     	<%
	     		String role=(String)request.getAttribute("role");
				out.print(role);
			%>
	     </td>
    </tr>
    <!--<tr>
	     <td>Address</td>
	     <td>
	     	<%--
	     		String line1=(String)request.getAttribute("line1");
	     		String line2=(String)request.getAttribute("line2");
	     		String city=(String)request.getAttribute("city");
	     		String state=(String)request.getAttribute("state");
	     		String country=(String)request.getAttribute("country");
	     		String pin=(String)request.getAttribute("pin");
	     		out.print(line1+","+line2+","+city+","+state+","+country+","+pin);
			--%>
	     </td>
    </tr>-->
    <%
  		AddressDAO ad = new AddressDAO();
    	AddressModel adm =new AddressModel();
  		List<AddressModel> list = ad.getAdd(adm,id);
  		int index=0;
  		for(AddressModel am:list)
  		{
  			out.print("<tr><td>Address "+(index+1)+"</td><td>"+am.getLine1(index)+","+am.getLine2(index)+","+am.getCity(index)+","+am.getState(index)+","+am.getCountry(index)+","+am.getPin(index)+"</td></tr>");
  			index++;
  		}
 	 %>
    
   </table>
   <input type="submit" class="button" value="Edit" />
  </form>
  <form action="<%= request.getContextPath() %>/logout" method="post">
		<input type="submit" class="button" value="LogOut"></input>
  </form> 
 </div>

</body>
</html>