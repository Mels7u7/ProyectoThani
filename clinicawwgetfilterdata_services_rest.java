package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ClinicaWWGetFilterData")
public final  class clinicawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.clinicawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV43DDOName;
      AV43DDOName = entity.getDDOName() ;
      String AV41SearchTxt;
      AV41SearchTxt = entity.getSearchTxt() ;
      String AV42SearchTxtTo;
      AV42SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV47OptionsJson = new String[] { "" };
      String [] AV50OptionsDescJson = new String[] { "" };
      String [] AV52OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("clinicawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.clinicawwgetfilterdata worker = new com.projectthani.clinicawwgetfilterdata(remoteHandle, context);
         worker.execute(AV43DDOName,AV41SearchTxt,AV42SearchTxtTo,AV47OptionsJson,AV50OptionsDescJson,AV52OptionIndexesJson );
         com.projectthani.clinicawwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.clinicawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV47OptionsJson[0]);
         data.setOptionsDescJson(AV50OptionsDescJson[0]);
         data.setOptionIndexesJson(AV52OptionIndexesJson[0]);
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

