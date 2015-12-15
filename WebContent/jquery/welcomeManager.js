/**
 * 
 */

$(document).ready(function(){
	
	
	$('#searchValueText').keyup(function(){
		var searchValueTextLength = $('#searchValueText').val().length;
		var searchValueText = $('#searchValueText').val();
		for (var n = 0; n < contact.length; n++) {
			var digit = contact.charCodeAt(n) >= 48 && contact.charCodeAt(n) <= 57 || contact.charCodeAt(n) == 46 || contact.charCodeAt(n) == 45;
			
			if(!digit){
				$('#spanSearchValueText').text("");
			
			}else{
				
				$('#spanSearchValueText').text("Enter String Only");
			
			}
		}
		
	});
	
}); 


