package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LogAccesosWWGetFilterData")
public final  class logaccesoswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.logaccesoswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV29DDOName;
      AV29DDOName = entity.getDDOName() ;
      String AV27SearchTxt;
      AV27SearchTxt = entity.getSearchTxt() ;
      String AV28SearchTxtTo;
      AV28SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV33OptionsJson = new String[] { "" };
      String [] AV36OptionsDescJson = new String[] { "" };
      String [] AV38OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("logaccesoswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.logaccesoswwgetfilterdata worker = new com.projectthani.logaccesoswwgetfilterdata(remoteHandle, context);
         worker.execute(AV29DDOName,AV27SearchTxt,AV28SearchTxtTo,AV33OptionsJson,AV36OptionsDescJson,AV38OptionIndexesJson );
         com.projectthani.logaccesoswwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.logaccesoswwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV33OptionsJson[0]);
         data.setOptionsDescJson(AV36OptionsDescJson[0]);
         data.setOptionIndexesJson(AV38OptionIndexesJson[0]);
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

