$(document).ready(function(){
	
	$('#registerForm').submit(function(e){
		
		e.preventDefault();
		var fname = $('#firstName').val();
		var lname = $('#lastName').val();
		var email = $('#email').val();
		var password = $('#password').val();
		var con_password = $('#con_password').val();
		
		if(fname.length < 1)
		{
			$('#firstName').after('<span class="error">This feild is required</span>');
		}
		if(lname.length < 1)
		{
			$('#lastName').after('<span class="error">This feild is required</span>');
		}
		if(email.length < 1)
		{
			$('#email').after('<span class="error">This feild is required</span>');
		}
		else
		{
			var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			var validEmail = regex.test(email);
			if(!validEmail)
			{
				$('#email').after('<span class="error">Enter a valid email address</spann>');
			}
		}
		if(password.length < 5)
		{
			$('#password').after('<span class="error" style="color:red">Password should be 5 charcters long</span>');
		}
		if(password!=con_password)
		{
			$('#con_password').after('<span class="error">Confirm password doesnt match your password</span>');
		}
	});
	
	jQuery('#registerForm').validate({
	    rules: {
	        password: {
	            required: true,
	            minlength: 5
	        },
	        con_password: {
	            required: true,
	            minlength: 5,
	            equalTo: "#password"
	        }
	    },
		messages: {
			password: {minlegth: 'Password must be atleast 5 characters long'},
			con_password: {equalTo: 'password and confirm password does not match'}
		}
	}); 
	
	$('#formLogin').submit(function(e){
		
		e.preventDefault();
		var username = $('#uname').val();
		var password = $('#pass').val();
		
		if(username.length < 1)
		{
			$('#uname').after('<span class="error">Required</span>');
		}
		if(password.length < 1)
		{
			$('#pass').after('<span class="error">Required</span>');
		}
		
	});
	
});