<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Success</title>
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
    	
		<div id="header"></div>
		<h4 align="center">User Registered Successfully!</h4>
        <form id="successForm" action="index.jsp" method="post">
        	<div id="successDiv" align="center">
        		<input id="successBtn" type="submit" value="Login"></input>
        	</div>
        </form>
        <div id="footer"></div>
    </body>
</html>