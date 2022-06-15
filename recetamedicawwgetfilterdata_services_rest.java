package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/RecetaMedicaWWGetFilterData")
public final  class recetamedicawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.recetamedicawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV35DDOName;
      AV35DDOName = entity.getDDOName() ;
      String AV33SearchTxt;
      AV33SearchTxt = entity.getSearchTxt() ;
      String AV34SearchTxtTo;
      AV34SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV39OptionsJson = new String[] { "" };
      String [] AV42OptionsDescJson = new String[] { "" };
      String [] AV44OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("recetamedicawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.recetamedicawwgetfilterdata worker = new com.projectthani.recetamedicawwgetfilterdata(remoteHandle, context);
         worker.execute(AV35DDOName,AV33SearchTxt,AV34SearchTxtTo,AV39OptionsJson,AV42OptionsDescJson,AV44OptionIndexesJson );
         com.projectthani.recetamedicawwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.recetamedicawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV39OptionsJson[0]);
         data.setOptionsDescJson(AV42OptionsDescJson[0]);
         data.setOptionIndexesJson(AV44OptionIndexesJson[0]);
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

