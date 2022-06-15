package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/DisponibilidadWWGetFilterData")
public final  class disponibilidadwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.disponibilidadwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV59DDOName;
      AV59DDOName = entity.getDDOName() ;
      String AV57SearchTxt;
      AV57SearchTxt = entity.getSearchTxt() ;
      String AV58SearchTxtTo;
      AV58SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV63OptionsJson = new String[] { "" };
      String [] AV66OptionsDescJson = new String[] { "" };
      String [] AV68OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("disponibilidadwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.disponibilidadwwgetfilterdata worker = new com.projectthani.disponibilidadwwgetfilterdata(remoteHandle, context);
         worker.execute(AV59DDOName,AV57SearchTxt,AV58SearchTxtTo,AV63OptionsJson,AV66OptionsDescJson,AV68OptionIndexesJson );
         com.projectthani.disponibilidadwwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.disponibilidadwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV63OptionsJson[0]);
         data.setOptionsDescJson(AV66OptionsDescJson[0]);
         data.setOptionIndexesJson(AV68OptionIndexesJson[0]);
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

