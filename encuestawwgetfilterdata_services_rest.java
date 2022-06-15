package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/EncuestaWWGetFilterData")
public final  class encuestawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.encuestawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV53DDOName;
      AV53DDOName = entity.getDDOName() ;
      String AV51SearchTxt;
      AV51SearchTxt = entity.getSearchTxt() ;
      String AV52SearchTxtTo;
      AV52SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV57OptionsJson = new String[] { "" };
      String [] AV60OptionsDescJson = new String[] { "" };
      String [] AV62OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("encuestawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.encuestawwgetfilterdata worker = new com.projectthani.encuestawwgetfilterdata(remoteHandle, context);
         worker.execute(AV53DDOName,AV51SearchTxt,AV52SearchTxtTo,AV57OptionsJson,AV60OptionsDescJson,AV62OptionIndexesJson );
         com.projectthani.encuestawwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.encuestawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV57OptionsJson[0]);
         data.setOptionsDescJson(AV60OptionsDescJson[0]);
         data.setOptionIndexesJson(AV62OptionIndexesJson[0]);
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

