$(document).ready(function() {
	
	$('.adminInputText')
		.keydown(
				function(e) {
					if (e.ctrlKey || e.altKey) {

						e.preventDefault();
					}

					else {
						var key = e.keyCode;
						if (!((key == 8) || (key == 9)
								|| (key == 16)
								|| (key == 32)
								|| (key == 46)
								|| (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {

							$('#adminMessageSpan').text('');
							e.preventDefault();

						}
						if (key >= 48 && key <= 57)

						{
							$('#adminMessageSpan').text(
									'Enter Alphabets');
						} else {
							$('#adminMessageSpan').text('');
						}
					}
				});
	
	
	$('#email').keyup(function(){
		var emailValid = $('#email').val();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([yash])+\.)+([com]{2,4})+$/;
		if(!filter.test(emailValid)){
		
		$('#spanEmail').text("Enter Valid Email-ID");
		}else{
		
		$('#spanEmail').text("")
		}
		
		});
	
	
});