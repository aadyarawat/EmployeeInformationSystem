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
	
	
	$('#firstname').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
        	$('#firstnamemessage').fadeOut(1000);
            return true;
        }
        else
        {
        e.preventDefault();
        $('#firstnamemessage').text('Enter Alphabets');
        return false;
        }
    });
	
	$('#lastname').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
        	$('#lastnamemessage').fadeOut(1000);
            return true;
        }
        else
        {
        e.preventDefault();
        $('#lastnamemessage').text('Enter Alphabets');
        return false;
        }
    });
	
	$('#city').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z]+$");
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
        var regex = new RegExp("^[a-zA-Z]+$");
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
	
	
	
	$("#pincode").keypress(function(e) {
		// if the letter is not digit then display error and don't type anything
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			// display error message
			$("#pincodemessage").html("Digits Only").show().fadeOut(3000);
			return false;
		}
	});

});