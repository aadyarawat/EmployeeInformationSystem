$(document).ready(function() {

	if ($('#baseLineInputTextArea').val().length != 0) {
		$('#baseLineInputTextArea').attr('disabled', 'true');
		$('#baseLineInputSubmitButton').prop('disabled', true);
	}

});