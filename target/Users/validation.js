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
			$('#fistName').after('<span class="error">This feild is required</span>');
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
		if(password.length < 8)
		{
			$('#password').after('<span class="error">Password should be 8 charcters long</span>');
		}
		if(password!=con_password)
		{
			
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
	
	$('#loginForm').submit(function(e){
		
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