package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/EncuestaLoadDVCombo")
public final  class encuestaloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.encuestaloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV17ComboName;
      AV17ComboName = entity.getComboName() ;
      String AV19TrnMode;
      AV19TrnMode = entity.getTrnMode() ;
      boolean AV21IsDynamicCall;
      AV21IsDynamicCall = entity.getIsDynamicCall() ;
      short AV25EncuestaId;
      AV25EncuestaId = entity.getEncuestaId() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV16SelectedValue = new String[] { "" };
      String [] AV22SelectedText = new String[] { "" };
      String [] AV13Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("encuestaloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.encuestaloaddvcombo worker = new com.projectthani.encuestaloaddvcombo(remoteHandle, context);
         worker.execute(AV17ComboName,AV19TrnMode,AV21IsDynamicCall,AV25EncuestaId,AV12SearchTxt,AV16SelectedValue,AV22SelectedText,AV13Combo_DataJson );
         com.projectthani.encuestaloaddvcombo_RESTInterfaceOUT data = new com.projectthani.encuestaloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV16SelectedValue[0]);
         data.setSelectedText(AV22SelectedText[0]);
         data.setCombo_DataJson(AV13Combo_DataJson[0]);
         builder = Response.okWrapped(data);
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

}

