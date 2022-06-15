package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/DrogueriaWWGetFilterData")
public final  class drogueriawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.drogueriawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV27DDOName;
      AV27DDOName = entity.getDDOName() ;
      String AV25SearchTxt;
      AV25SearchTxt = entity.getSearchTxt() ;
      String AV26SearchTxtTo;
      AV26SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV31OptionsJson = new String[] { "" };
      String [] AV34OptionsDescJson = new String[] { "" };
      String [] AV36OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("drogueriawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.drogueriawwgetfilterdata worker = new com.projectthani.drogueriawwgetfilterdata(remoteHandle, context);
         worker.execute(AV27DDOName,AV25SearchTxt,AV26SearchTxtTo,AV31OptionsJson,AV34OptionsDescJson,AV36OptionIndexesJson );
         com.projectthani.drogueriawwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.drogueriawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV31OptionsJson[0]);
         data.setOptionsDescJson(AV34OptionsDescJson[0]);
         data.setOptionIndexesJson(AV36OptionIndexesJson[0]);
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

