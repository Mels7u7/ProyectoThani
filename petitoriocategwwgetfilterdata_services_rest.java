package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PetitorioCategWWGetFilterData")
public final  class petitoriocategwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.petitoriocategwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV17DDOName;
      AV17DDOName = entity.getDDOName() ;
      String AV15SearchTxt;
      AV15SearchTxt = entity.getSearchTxt() ;
      String AV16SearchTxtTo;
      AV16SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV21OptionsJson = new String[] { "" };
      String [] AV24OptionsDescJson = new String[] { "" };
      String [] AV26OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("petitoriocategwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.petitoriocategwwgetfilterdata worker = new com.projectthani.petitoriocategwwgetfilterdata(remoteHandle, context);
         worker.execute(AV17DDOName,AV15SearchTxt,AV16SearchTxtTo,AV21OptionsJson,AV24OptionsDescJson,AV26OptionIndexesJson );
         com.projectthani.petitoriocategwwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.petitoriocategwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV21OptionsJson[0]);
         data.setOptionsDescJson(AV24OptionsDescJson[0]);
         data.setOptionIndexesJson(AV26OptionIndexesJson[0]);
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

