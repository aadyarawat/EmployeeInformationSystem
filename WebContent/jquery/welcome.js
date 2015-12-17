/**
 * 
 */
 $(function() {
    $( "#accordion" ).accordion({
      collapsible: true,

      beforeActivate: function( event, ui ) {
      ui.newHeader.add(ui.newPanel).prependTo(this)
      }

    })
  });