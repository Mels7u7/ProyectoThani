package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PagoWWGetFilterData")
public final  class pagowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.pagowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV55DDOName;
      AV55DDOName = entity.getDDOName() ;
      String AV53SearchTxt;
      AV53SearchTxt = entity.getSearchTxt() ;
      String AV54SearchTxtTo;
      AV54SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV59OptionsJson = new String[] { "" };
      String [] AV62OptionsDescJson = new String[] { "" };
      String [] AV64OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("pagowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.pagowwgetfilterdata worker = new com.projectthani.pagowwgetfilterdata(remoteHandle, context);
         worker.execute(AV55DDOName,AV53SearchTxt,AV54SearchTxtTo,AV59OptionsJson,AV62OptionsDescJson,AV64OptionIndexesJson );
         com.projectthani.pagowwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.pagowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV59OptionsJson[0]);
         data.setOptionsDescJson(AV62OptionsDescJson[0]);
         data.setOptionIndexesJson(AV64OptionIndexesJson[0]);
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

