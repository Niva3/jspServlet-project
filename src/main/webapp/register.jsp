<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
 	<link rel="stylesheet" href="./style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
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
 <div>
  <h3 align="center" style="color: white">User Register Form</h3>
  <form id="registerForm" action="<%= request.getContextPath() %>/register" method="post">
   
   <table id="table" style="width: 80%">
    <tr>
     <td><b>User Name</b></td>
     <td><input id="userName" type="text" name="username" /></td>
    </tr>
    
    <tr>
     <td><b>First Name</b></td>
     <td><input id="firstName" type="text" name="firstName" /></td>
    </tr>
    
    <tr>
     <td><b>Last Name</b></td>
     <td><input id="lastName" type="text" name="lastName" /></td>
    </tr>
    
    <tr>
     <td><b>Email</b></td>
     <td><input id="email" type="text" name="email" /></td>
    </tr>
    
    <tr>
     <td><b>Gender</b></td>
     <td>
     	 <input type="radio" name="gender" value="male" />Male
     	 <input type="radio" name="gender" value="female" />Female
     </td>
    </tr>
    
    <tr>
     <td><b>Languages Known</b></td>
     <td>
     	<input type="checkbox" name="lang" value="english" /> English
     	<input type="checkbox" name="lang" value="hindi" /> Hindi
     	<input type="checkbox" name="lang" value="gujarati" /> Gujarati
     </td>
    </tr>
    
    <tr>
     <td><b>Contact No.</b></td>
     <td><input id="contact" type="text" name="contact" /></td>
    </tr>
    
    <tr>
     <td><b>Password</b></td>
     <td><input id="password" type="password" name="password" /></td>
    </tr>
    
    <tr>
     <td><b>Confirm Password</b></td>
     <td><input id="con_password" type="password" name="con_password" /></td>
    </tr>
    
    <tr>
    	<td><b>Role</b></td>
    	<td><select name="role" id="role"><option value="admin">Admin</option><option value="user">User</option></select></td>
    </tr>
    
    <tr>
      <td><b>Date of Birth</b></td>
      <td><input type="date" id="birthday" name="birthday"></td>
    </tr>
   
   </table>
   <br>
 
	 <div class="col-md-12">
		
			<div class="input_fields_wrap">
			<div class="row">
			<div class="col-md-6">
			<div class="form-group">
				<label for="">Address Line 1</label>
				<textarea class="form-control" name="address1"></textarea>
			</div>
			<div class="form-group">
				<label for="">City</label>
				<input name="city" class="form-control" >
			</div>
			<div class="form-group">
				<label for="">Country</label>
				<textarea class="form-control" name="country"></textarea>
			</div>
			</div>
			<div class="col-md-6">
			<div class="form-group">
				<label for="">Address Line 2</label>
				<textarea class="form-control" name="address2"></textarea>
			</div>
			<div class="form-group">
				<label for="">State</label>
				<textarea class="form-control" name="state" ></textarea>
			</div>
			<div class="form-group">
				<label for="">Pincode</label>
				<input name="pincode" type="text" value="" class="form-control">
			</div>
			</div>
		<button style="background-color:green;" class="add_field_button btn btn-info active">Add More Address</button>
		</div>
		</div>
		
	 </div>
	<br>
	<br>
   <input type="submit" value="Submit" />
  </form>
 </div>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="fields.js"></script>
 <div id="footer"></div>
</body>
</html>