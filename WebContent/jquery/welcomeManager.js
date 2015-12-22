$(document)
		.ready(
				function() {

					$('#searchValueText')
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
												$('#spanSearchValueText').text(
														'Enter Alphabets');
											} else {
												$('#spanSearchValueText').text(
														'');
											}
										}
									});

				});

$(document).ready(function() {
	$("#addSkillsButton").click("click", function() {
		$("#addSkillsDialog").dialog({

			height : 180,
			width : 600

		});

	});
	$('#skillEnterText')
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

						$('#spanSearchValueText').text('');
						e.preventDefault();

					}
					if (key >= 48 && key <= 57)

					{
						$('#spanSearchValueText').text(
								'Enter Alphabets');
					} else {
						$('#spanSearchValueText').text('');
					}
				}
			});

});