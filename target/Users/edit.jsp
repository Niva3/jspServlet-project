<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Details</title>
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
 	<link rel="stylesheet" href="./style.css">
</head>
<body>
 <div align="center">
  <h1 style="color: white">Edit Details</h1><br><br>
  <form id="editForm" action="<%= request.getContextPath() %>/edit" method="post">
  	<h3>Enter new details to be updated :</h3>
   <table style="width: 80%">
   <tr>
   	<td>Your ID : </td>
   	<td>
   		<%
	     	int id = (int)session.getAttribute("id");
			out.print(id);
			session.setAttribute("id",id);
		%>
	</td>
   </tr>
    <tr>
	     <td>First Name</td>
	     <td>
	     	<input type="text" name="efirstName" />
		 </td>
    </tr>
    <tr>
	     <td>Last Name</td>
	     <td>
	     	<input type="text" name="elastName" />
		 </td>
    </tr>
    <tr>
	     <td>UserName</td>
	     <td>
	     	<input type="text" name="eUserName" />
	     </td>
    </tr>
    <tr>
	     <td>Email</td>
	     <td>
	     	<input type="text" name="eEmail" />
	     </td>
    </tr>
    <tr>
	     <td>Address</td>
	     <td>
	     	<input type="text" name="eAddr" />
	     </td>
    </tr>
   </table>
   <input type="submit" value="Edit and Save" />
  </form>
 </div>
</body>
</html>