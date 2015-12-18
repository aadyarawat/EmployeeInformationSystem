/**
 * 
 */

$(document).ready(function() {
	// called when key is pressed in textbox
	$("#yash_emp_id").keypress(function(e) {
		// if the letter is not digit then display error and don't type anything
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			// display error message
			$("#errmsg").html("Digits Only").show().fadeOut(3000);
			return false;
		}
	});

	$("#mobileNumber").keypress(function(e) {
		// if the letter is not digit then display error and don't type anything
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			// display error message
			$("#mobileerror").html("Digits Only").show().fadeOut(3000);
			return false;
		}
	});

	$("#guidelines").click("click", function() {
		$("#dialog").dialog({

			height : 500,
			width : 800

		});

	});
	
	
	/*$('#firstname').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z\b]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
        	$('#firstnamemessage').fadeOut(1000);
            return true;
        }
        else
        {
        //e.preventDefault();
        $('#firstnamemessage').text('Enter Alphabets');
        return false;
        }
    });
	
	$('#lastname').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z\b]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
        	$('#lastnamemessage').fadeOut(1000);
            return true;
        }
        else
        {
       // e.preventDefault();
        $('#lastnamemessage').text('Enter Alphabets');
        return false;
        }
    });
	
	$('#city').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z\b]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
        	$('#citymessage').fadeOut(1000);
            return true;
        }
        else
        {
        e.preventDefault();
        $('#citymessage').text('Enter Alphabets');
        return false;
        }
    });
	
	$('#state').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z\b]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
        	$('#statemessage').fadeOut(1000);
            return true;
        }
        else
        {
        e.preventDefault();
        $('#statemessage').text('Enter Alphabets');
        return false;
        }
    });
	*/
	
	$('#firstname').keydown(function (e) {
		if ( e.ctrlKey || e.altKey) {
		 
		e.preventDefault();
		}
		 
		 
		else {
		var key = e.keyCode;
		if (!((key == 8) || (key == 9) || (key == 16) ||  (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
		 
		$('#firstnamemessage').fadeOut(1000);
		e.preventDefault();
		 
		 
		}
		if(key >= 48 && key <= 57)
		 
		{
		$('#firstnamemessage').text('Enter Alphabets');
		}
		}
		});
		 
		$('#lastname').keydown(function (e) {
		if ( e.ctrlKey || e.altKey) {
		 
		e.preventDefault();
		}
		 
		 
		else {
		var key = e.keyCode;
		if (!((key == 8) || (key == 9) || (key == 16) ||  (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
		 
		$('#firstnamemessage').fadeOut(1000);
		e.preventDefault();
		 
		 
		}
		if(key >= 48 && key <= 57)
		 
		{
		$('#firstnamemessage').text('Enter Alphabets');
		}
		}
		});
		 
		$('#city').keydown(function (e) {
		if ( e.ctrlKey || e.altKey) {
		 
		e.preventDefault();
		}
		 
		 
		else {
		var key = e.keyCode;
		if (!((key == 8) || (key == 9) || (key == 16) ||  (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
		 
		$('#firstnamemessage').fadeOut(1000);
		e.preventDefault();
		 
		 
		}
		if(key >= 48 && key <= 57)
		 
		{
		$('#firstnamemessage').text('Enter Alphabets');
		}
		}
		});
		 
		$('#state').keydown(function (e) {
		if ( e.ctrlKey || e.altKey) {
		 
		e.preventDefault();
		}
		 
		 
		else {
		var key = e.keyCode;
		if (!((key == 8) || (key == 9) || (key == 16) ||  (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
		 
		$('#firstnamemessage').fadeOut(1000);
		e.preventDefault();
		 
		 
		}
		if(key >= 48 && key <= 57)
		 
		{
		$('#firstnamemessage').text('Enter Alphabets');
		}
		}
		});
	
	
	$("#pincode").keypress(function(e) {
		// if the letter is not digit then display error and don't type anything
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			// display error message
			$("#pincodemessage").html("Digits Only").show().fadeOut(3000);
			return false;
		}
	});
	
	$("#houseNo").keypress(function(e) {
		// if the letter is not digit then display error and don't type anything
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
		// display error message
		$("#houseNoMessage").html("Digits Only").show().fadeOut(3000);
		return false;
		}
		});

});