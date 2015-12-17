$(document).ready(function() {
	if ($('#baseLineInputTextArea').val().length != 0) {
		$('#baseLineInputTextArea').attr('readonly', 'true');
		$('#baseLineInputSubmitButton').prop('disabled', true);
	}
});