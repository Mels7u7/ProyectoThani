
	$(".navbar ul li").click(function(){
	    if ($(this).hasClass('show')){
	        $('#logedInfo').hide()
	        $('.logged-item').removeClass('show')
	    }else{
	         $('.logged-item').addClass('show')
	    }
	})




	