<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forgot Password</title>
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
		<!--<div id="header"></div>-->

		<div  align="center">
			<h3 align="center" style="color: white">Forgot Password</h3>
			<form id="forgotForm" action="forgotProcess.jsp" method="post">
			<h4>To change your password:</h4>
			<br><br>
			<table id="table">
				
				<tr>
					<td>Enter e-mail :</td>
					<td><input type="text" name="email"/></td>
				</tr>
				
				<tr>
					<td>Enter new Password :</td>
					<td><input type="text" name="newPass"/></td>
				</tr>
				
			</table>
				<br>
				<input type="submit" value="Confirm"/>
			</form>
		</div>
		<!--<div id="footer"></div>-->
	</body>
</html>