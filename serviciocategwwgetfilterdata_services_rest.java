package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ServicioCategWWGetFilterData")
public final  class serviciocategwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.serviciocategwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV25DDOName;
      AV25DDOName = entity.getDDOName() ;
      String AV23SearchTxt;
      AV23SearchTxt = entity.getSearchTxt() ;
      String AV24SearchTxtTo;
      AV24SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV29OptionsJson = new String[] { "" };
      String [] AV32OptionsDescJson = new String[] { "" };
      String [] AV34OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("serviciocategwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.serviciocategwwgetfilterdata worker = new com.projectthani.serviciocategwwgetfilterdata(remoteHandle, context);
         worker.execute(AV25DDOName,AV23SearchTxt,AV24SearchTxtTo,AV29OptionsJson,AV32OptionsDescJson,AV34OptionIndexesJson );
         com.projectthani.serviciocategwwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.serviciocategwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV29OptionsJson[0]);
         data.setOptionsDescJson(AV32OptionsDescJson[0]);
         data.setOptionIndexesJson(AV34OptionIndexesJson[0]);
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

