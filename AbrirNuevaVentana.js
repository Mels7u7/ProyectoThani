var DirectionPage = function() {
    return {
           NewPage:function(url){
           	// Abrir nuevo tab
            var win = window.open(url, '_blank');
            // Cambiar el foco al nuevo tab (punto opcional)
            win.focus();

           }

    }
}
