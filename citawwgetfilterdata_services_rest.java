package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/CitaWWGetFilterData")
public final  class citawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.citawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV63DDOName;
      AV63DDOName = entity.getDDOName() ;
      String AV61SearchTxt;
      AV61SearchTxt = entity.getSearchTxt() ;
      String AV62SearchTxtTo;
      AV62SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV67OptionsJson = new String[] { "" };
      String [] AV70OptionsDescJson = new String[] { "" };
      String [] AV72OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("citawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.citawwgetfilterdata worker = new com.projectthani.citawwgetfilterdata(remoteHandle, context);
         worker.execute(AV63DDOName,AV61SearchTxt,AV62SearchTxtTo,AV67OptionsJson,AV70OptionsDescJson,AV72OptionIndexesJson );
         com.projectthani.citawwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.citawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV67OptionsJson[0]);
         data.setOptionsDescJson(AV70OptionsDescJson[0]);
         data.setOptionIndexesJson(AV72OptionIndexesJson[0]);
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

