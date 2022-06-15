var SweetAlert= function() {
    return {

        successAlert:function(Icon,Mensaje,Url){
                Swal.fire({
                        icon:Icon ,
                        title:Mensaje ,
                        showConfirmButton: true,
                        confirmButtonText: "Cerrar"
                        }).then(function(result){
                           if (result.value) {
                           Window.location=Url
                  }
                })
        },

        Alert:function(Icon,Mensaje,MsgHtml,Url){
                Swal.fire({
                        icon:Icon ,
                        title:Mensaje ,
                        html:MsgHtml,
                        showConfirmButton: true,
                        confirmButtonText: "Cerrar"
                        }).then(function(result){
                           if (result.value) {
                           Window.location=Url
                  }
                })
        }





   }
}




           
				