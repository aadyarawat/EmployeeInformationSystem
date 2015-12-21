/**
 * 
 */

$(document)
		.ready(
				function() {
					
					$('#dialog').on('dialogclose', function(event) {
						$('iframe').remove();
						document.getElementById('spinner').style.display='none';
					 });
					// called when key is pressed in textbox
					$("#yash_emp_id").keypress(
							function(e) {
								// if the letter is not digit then display error
								// and don't type anything
								if (e.which != 8 && e.which != 0
										&& (e.which < 48 || e.which > 57)) {
									// display error message
									$("#errmsg").html("Digits Only").show()
											.fadeOut(1000);
									return false;
								}
							});


					$("#mobileNumber").keypress(
							function(e) {
								// if the letter is not digit then display error
								// and don't type anything
								if (e.which != 8 && e.which != 0
										&& (e.which < 48 || e.which > 57)) {
									// display error message
									$("#mobileerror").html("Digits Only")
											.show().fadeOut(1000);
									return false;
								}
							});

					$("#alternateNumber").keypress(
							function(e) {
								// if the letter is not digit then display error
								// and don't type anything
								if (e.which != 8 && e.which != 0
										&& (e.which < 48 || e.which > 57)) {
									// display error message
									$("#alternateerror").html("Digits Only")
											.show().fadeOut(1000);
									return false;
								}
							});

					$("#guidelines").click("click", function() {
						$("#dialog").dialog({

							height : 500,
							width : 800

						});

					});

					$('#firstname')
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

												e.preventDefault();

											}
											if (key >= 48 && key <= 57)

											{
												$('#firstnamemessage').text(
														'Enter Alphabets');
											} else {
												$('#firstnamemessage').text('');
											}
										}
									});

					$('#lastname')
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

												$('#lastnamemessage').text('');
												e.preventDefault();

											}
											if (key >= 48 && key <= 57)

											{
												$('#lastnamemessage').text(
														'Enter Alphabets');
											} else {
												$('#lastnamemessage').text('');
											}
										}
									});

					$('#city')
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

												$('#citymessage').text('');
												e.preventDefault();

											}
											if (key >= 48 && key <= 57)

											{
												$('#citymessage').text(
														'Enter Alphabets');
											} else {
												$('#citymessage').text('');
											}
										}
									});

					$('#state')
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

												$('#statemessage').text('');
												e.preventDefault();

											}

											if (key >= 48 && key <= 57)

											{
												$('#statemessage').text(
														'Enter Alphabets');
											} else {
												$('#statemessage').text('');
											}
										}
									});

					$('#street')
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
													|| (key == 191)
													|| (key == 190)
													|| (key == 189)
													|| (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {

												$('#streetmessage').text('');
												e.preventDefault();

											}
											if (key >= 48 && key <= 57)

											{
												$('#streetmessage').text(
														'Enter Alphabets');
											} else {
												$('#streetmessage').text(' ');
											}
										}
									});

					$("#pincode").keypress(
							function(e) {
								// if the letter is not digit then display error
								// and don't type anything
								if (e.which != 8 && e.which != 0
										&& (e.which < 48 || e.which > 57)) {
									// display error message
									$("#pincodemessage").html("Digits Only")
											.show().fadeOut(1000);
									return false;
								}
							});

					
					$("#houseNo").keypress(
							function(e) {
								// if the letter is not digit then display error
								// and don't type anything
								if (e.which != 8 && e.which != 0
										&& (e.which < 48 || e.which > 57)) {
									// display error message
									$("#houseNoMessage").html("Digits Only")
											.show().fadeOut(1000);
									return false;
								}
							});

					$('body').on('keypress', '#firstname', function(e) {
						console.log(this.value);
						if (e.which === 32 && e.target.selectionStart === 0) {
							return false;
						}
					});

					$('body').on('keypress', '#lastname', function(e) {
						console.log(this.value);
						if (e.which === 32 && e.target.selectionStart === 0) {
							return false;
						}
					});

					$('body').on('keypress', '#city', function(e) {
						console.log(this.value);
						if (e.which === 32 && e.target.selectionStart === 0) {
							return false;
						}
					});

					$('body').on('keypress', '#state', function(e) {
						console.log(this.value);
						if (e.which === 32 && e.target.selectionStart === 0) {
							return false;
						}
					});

					$('body').on('keypress', '#street', function(e) {
						console.log(this.value);
						if (e.which === 32 && e.target.selectionStart === 0) {
							return false;
						}
					});

				});