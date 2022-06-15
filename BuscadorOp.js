var ShowOpBuscador = function() {
    return {
           showGenero:function(className){
                $("#TEXTBLOCKGENERO").click(function(){

                    if ($('#Angle').hasClass('fa-angle-right')){
                        $('#Angle').removeClass('fa-angle-right')
                        $('#Angle').addClass('fa-angle-down') 
                        $('#TABLE6').show()
                    }else{
                        $('#Angle').removeClass('fa-angle-down')
                        $('#Angle').addClass('fa-angle-right')  
                        $('#TABLE6').hide()

                    }     
                })
            
           },
           showTipoCita:function(className){
            $("#TBTIPOATENCION").click(function(){

                    if ($('#AngleA').hasClass('fa-angle-right')){
                        $('#AngleA').removeClass('fa-angle-right')
                        $('#AngleA').addClass('fa-angle-down') 
                        $('#TABLE11').show()
                    }else{
                        $('#AngleA').removeClass('fa-angle-down')
                        $('#AngleA').addClass('fa-angle-right')  
                        $('#TABLE11').hide()

                    }     
                })
            
           },
           showEspecialidades:function(className){
            $("#TBESPECIALIDADES").click(function(){

                    if ($('#AngleE').hasClass('fa-angle-right')){
                        $('#AngleE').removeClass('fa-angle-right')
                        $('#AngleE').addClass('fa-angle-down') 
                        $('#TABLE19').show()
                    }else{
                        $('#AngleE').removeClass('fa-angle-down')
                        $('#AngleE').addClass('fa-angle-right')  
                        $('#TABLE19').hide()

                    }     
                })
            
           },
           showRangoPrecios:function(className){
            $("#TBRANGOPRECIOS").click(function(){

                    if ($('#AngleRP').hasClass('fa-angle-right')){
                        $('#AngleRP').removeClass('fa-angle-right')
                        $('#AngleRP').addClass('fa-angle-down') 
                        $('#TABLE18').show()
                    }else{
                        $('#AngleRP').removeClass('fa-angle-down')
                        $('#AngleRP').addClass('fa-angle-right')  
                        $('#TABLE18').hide()

                    }     
                })
            
           },
           showDepartamento:function(className){
            $("#TBDEPARTAMENTO").click(function(){

                    if ($('#TABLE13').hasClass('ShowTable1')){
                        $('#TABLE13').removeClass('ShowTable1')
                        $('#TABLE13').addClass('ShowTable10') 
                        $('#TABLE13').show()
                    }else{
                        $('#TABLE13').removeClass('ShowTable10')
                        $('#TABLE13').addClass('ShowTable1')  
                        $('#TABLE13').hide()

                    }     
                })
            
           },
           showProvincia:function(className){
            $("#TBPROVINCIA").click(function(){

                    if ($('#TABLE17').hasClass('ShowTable2')){
                        $('#TABLE17').removeClass('ShowTable2')
                        $('#TABLE17').addClass('ShowTable11') 
                        $('#TABLE17').show()
                    }else{
                        $('#TABLE17').removeClass('ShowTable11')
                        $('#TABLE17').addClass('ShowTable2')  
                        $('#TABLE17').hide()

                    }     
                })
            
           },
           showDistrito:function(className){
            $("#TBDISTRITO").click(function(){

                    if ($('#TABLE15').hasClass('ShowTable3')){
                        $('#TABLE15').removeClass('ShowTable3')
                        $('#TABLE15').addClass('ShowTable12') 
                        $('#TABLE15').show()
                    }else{
                        $('#TABLE15').removeClass('ShowTable12')
                        $('#TABLE15').addClass('ShowTable3')  
                        $('#TABLE15').hide()

                    }     
                })
            
           },
           showPrueba:function(className){

            console.log('Probando GeneXus')
           }

    }
}

















    