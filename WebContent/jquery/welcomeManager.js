$(document)
		.ready(
				function() {

					$('#searchValueText')
							.keyup(
									function() {
										var searchValueTextLength = $(
												'#searchValueText').val().length;
										var searchValueText = $(
												'#searchValueText').val();
										for (var n = 0; n < searchValueText.length; n++) {
											var digit = searchValueText
													.charCodeAt(n) >= 48
													&& searchValueText
															.charCodeAt(n) <= 57
													|| searchValueText
															.charCodeAt(n) == 46
													|| searchValueText
															.charCodeAt(n) == 45;
											if (!digit) {
												$('#spanSearchValueText').text(
														"");

											} else {

												$('#spanSearchValueText').text(
														"Enter String Only");

											}
										}

									});

				});
