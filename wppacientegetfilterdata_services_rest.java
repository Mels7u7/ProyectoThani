package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/WPPacienteGetFilterData")
public final  class wppacientegetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.wppacientegetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV72DDOName;
      AV72DDOName = entity.getDDOName() ;
      String AV70SearchTxt;
      AV70SearchTxt = entity.getSearchTxt() ;
      String AV71SearchTxtTo;
      AV71SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV76OptionsJson = new String[] { "" };
      String [] AV79OptionsDescJson = new String[] { "" };
      String [] AV81OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("wppacientegetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.wppacientegetfilterdata worker = new com.projectthani.wppacientegetfilterdata(remoteHandle, context);
         worker.execute(AV72DDOName,AV70SearchTxt,AV71SearchTxtTo,AV76OptionsJson,AV79OptionsDescJson,AV81OptionIndexesJson );
         com.projectthani.wppacientegetfilterdata_RESTInterfaceOUT data = new com.projectthani.wppacientegetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV76OptionsJson[0]);
         data.setOptionsDescJson(AV79OptionsDescJson[0]);
         data.setOptionIndexesJson(AV81OptionIndexesJson[0]);
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

