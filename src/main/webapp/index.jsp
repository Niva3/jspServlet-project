<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
 	<link rel="stylesheet" href="./style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="./validation.js"></script>
	<script>
		$(function(){
			$('#header').load("header.html");
			$('#footer').load("footer.html");
		})
	</script>
	</head>
    <body>
        <!-- partial:index.partial.html -->
			<div class="login-form">
			
			    <h1>Login</h1>
			    <div class="action">
			      <div class="content">
			    
			       <form id="formLogin" action="<%= request.getContextPath() %>/login" method="post">
				      <div class="input-field">
				        <input id="uname" type="text" name="username" placeholder="Username">
				      </div>
				      <div class="input-field">
				        <input id="pass" type="password" name="password" placeholder="Password">
				      </div>
				      <a href="forgot.jsp" class="link">Forgot Your Password?</a>
				      <!-- 
				      <form action="forgot.jsp" method="post">
				        <input type="submit" value="Forgot Password"></input>
				      </form>
				       -->
				       <input type="submit" class="button" value="Sign in"></input>
			        </form>
			        
			        <form action="register.jsp" method="post">
			        	<input type="submit" class="button" value="Register"></input>
			      	</form>
			      	
			      </div>
			    </div>
			</div>
        
       <script  src="./script.js"></script>
    </body>
</html>