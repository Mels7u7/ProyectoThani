var ShowOpcionVerPerfil = function() {
    return {
           showVerPerfil:function(className){
			$(".navbar ul li").click(function(){
			    if ($(this).hasClass('show')){
			        $('#logedInfo').hide()
			        $('.logged-item').removeClass('show')
			    }else{
			         $('.logged-item').addClass('show')
			    }
			})

           }

    }
}


	