package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/WPBandejaCitasGetFilterData")
public final  class wpbandejacitasgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.wpbandejacitasgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV81DDOName;
      AV81DDOName = entity.getDDOName() ;
      String AV79SearchTxt;
      AV79SearchTxt = entity.getSearchTxt() ;
      String AV80SearchTxtTo;
      AV80SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV85OptionsJson = new String[] { "" };
      String [] AV88OptionsDescJson = new String[] { "" };
      String [] AV90OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("wpbandejacitasgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.wpbandejacitasgetfilterdata worker = new com.projectthani.wpbandejacitasgetfilterdata(remoteHandle, context);
         worker.execute(AV81DDOName,AV79SearchTxt,AV80SearchTxtTo,AV85OptionsJson,AV88OptionsDescJson,AV90OptionIndexesJson );
         com.projectthani.wpbandejacitasgetfilterdata_RESTInterfaceOUT data = new com.projectthani.wpbandejacitasgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV85OptionsJson[0]);
         data.setOptionsDescJson(AV88OptionsDescJson[0]);
         data.setOptionIndexesJson(AV90OptionIndexesJson[0]);
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

