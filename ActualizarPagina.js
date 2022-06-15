var ClassActualizarPagina = function() {
    return{
          ActualizarPagina:function(valor){
            if (valor==1){
                if (!sessionStorage.getItem("RegistroMedico")) {
                // No existe
                sessionStorage.setItem("RegistroMedico","RegistroMedico")
                location.reload(true)
                }
            }

            if(valor==2){
                if (sessionStorage.getItem("RegistroMedico")) {
                    sessionStorage.removeItem("RegistroMedico")
                } 
            }        
          },
          ActualizarPaginaV2:function(valor){
            if (valor==1){
              if (!sessionStorage.getItem("CalificarMedico")) {
                // No existe
                  sessionStorage.setItem("CalificarMedico",'CalificarMedico')
                  location.reload();
              }else{
                sessionStorage.getItem("CalificarMedico")
              }
            }

            if(valor==2){
              if (sessionStorage.getItem("CalificarMedico")) {
                  sessionStorage.removeItem("CalificarMedico")
              } 
            } 

          },
          ActualizarPaginaV3:function(valor){
            if (valor==1){
              if (!sessionStorage.getItem("CalificarPlataforma")) {
                    // No existe
                      sessionStorage.setItem("CalificarPlataforma",'CalificarPlataforma')
                      location.reload();
              }else{
                sessionStorage.getItem("CalificarPlataforma")

              }
            }
            if(valor==2){
              if (sessionStorage.getItem("CalificarPlataforma")) {
                  sessionStorage.removeItem("CalificarPlataforma")
              } 
            } 

        },
         ActualizarPaginaV4:function(valor){
            if (valor==1){
              if (!sessionStorage.getItem("ActualizarCitaArchivo")) {
                    // No existe
                      sessionStorage.setItem("ActualizarCitaArchivo",'ActualizarCitaArchivo')
                      location.reload();
              }else{
                sessionStorage.getItem("ActualizarCitaArchivo")

              }
            }
            if(valor==2){
              if (sessionStorage.getItem("ActualizarCitaArchivo")) {
                  sessionStorage.removeItem("ActualizarCitaArchivo")
              } 
            } 

        } 
}}

