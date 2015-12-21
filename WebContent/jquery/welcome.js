/**
 * 
 */

$(function() {

	$("#accordion").accordion({
		collapsible : true,
		autoHeight : false,
		navigation : true,

		beforeActivate : function(event, ui) {
			ui.newHeader.add(ui.newPanel).prependTo(this)
		}

	})
});