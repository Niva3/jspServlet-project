$(document).ready(function() 
{
	var max_fields = 15; //maximum input boxes allowed
	var wrapper = $(".input_fields_wrap"); //Fields wrapper
	var add_button = $(".add_field_button"); //Add button ID
	var x = 1; //initlal text box count
	$(add_button).click(function(e)
	{ //on add input button click
		e.preventDefault();
		if(x < max_fields)
		{ //max input box allowed
			x++; //text box increment
			$(wrapper).append('<div class="row"><div class="col-md-6"><div class="form-group"><label for="">Address Line 1</label><textarea class="form-control" name="address1" required=""></textarea></div><div class="form-group"><label for="">City</label><input name="city" class="form-control" required=""></div><div class="form-group"><label for="">Country</label><textarea class="form-control" name="country" required=""></textarea></div></div><div class="col-md-6"><div class="form-group"><label for="">Address Line 2</label><textarea class="form-control" name="address2" required=""></textarea></div><div class="form-group"><label for="">State</label><textarea class="form-control" name="state" required=""></textarea></div><div class="form-group"><label for="">Pincode</label><input name="pincode" type="text" value="" class="form-control"></div></div><div style="cursor:pointer;background-color:red;" class="remove_field btn btn-info">Remove</div></div>'); //add input box
		}
	});
	$(wrapper).on("click",".remove_field", function(e)
	{ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x--;
	});
});