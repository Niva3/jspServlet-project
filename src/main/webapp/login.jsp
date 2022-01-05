<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
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
	     <td>Address line 1</td>
	     <td>
	     	<%
	     		String addr1=(String)request.getAttribute("line1");
				out.print(addr1);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Address line 2</td>
	     <td>
	     	<%
	     		String addr2=(String)request.getAttribute("line2");
				out.print(addr2);
			%>
	     </td>
    </tr>
    <tr>
	     <td>City</td>
	     <td>
	     	<%
	     		String city=(String)request.getAttribute("city");
				out.print(city);
			%>
	     </td>
    </tr>
    <tr>
	     <td>Pincode</td>
	     <td>
	     	<%
	     		String pin=(String)request.getAttribute("pin");
				out.print(pin);
			%>
	     </td>
    </tr>
   </table>
   <input type="submit" value="Edit" />
  </form>
  <form action="<%= request.getContextPath() %>/logout" method="post">
		<input type="submit" value="LogOut"></input>
  </form> 
 </div>

</body>
</html>