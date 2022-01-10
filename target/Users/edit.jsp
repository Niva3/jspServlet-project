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
<style>
	td,th{
	border: 1px solid black;
	text-align: center;
	padding: 10px;
	}
</style>
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
   			if(session.getAttribute("id")!=null)
   			{
   				int id = (int)session.getAttribute("id");
   				out.print(id);
   				session.setAttribute("id",id);
   			}
   			else
   			{
   				int id = Integer.parseInt(request.getParameter("editID"));
   				out.print(id);
   				session.setAttribute("id",id);
   			}
	     	
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
	     <td>Gender</td>
	     <td>
	     	<input type="text" name="eGender" />
	     </td>
    </tr>
    <tr>
	     <td>Languages Known</td>
	     <td>
	     	<input type="text" name="eLang" />
	     </td>
    </tr>
    <tr>
	     <td>Contact</td>
	     <td>
	     	<input type="text" name="eContact" />
	     </td>
    </tr>
   </table>
   <br><br>
   <input type="submit" class="button" value="Edit and Save" />
  </form>
 </div>
</body>
</html>