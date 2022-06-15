package com.projectthani ;
import com.projectthani.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PetitorioSubCategWWGetFilterData")
public final  class petitoriosubcategwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.projectthani.petitoriosubcategwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV21DDOName;
      AV21DDOName = entity.getDDOName() ;
      String AV19SearchTxt;
      AV19SearchTxt = entity.getSearchTxt() ;
      String AV20SearchTxtTo;
      AV20SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV25OptionsJson = new String[] { "" };
      String [] AV28OptionsDescJson = new String[] { "" };
      String [] AV30OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("petitoriosubcategwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.projectthani.petitoriosubcategwwgetfilterdata worker = new com.projectthani.petitoriosubcategwwgetfilterdata(remoteHandle, context);
         worker.execute(AV21DDOName,AV19SearchTxt,AV20SearchTxtTo,AV25OptionsJson,AV28OptionsDescJson,AV30OptionIndexesJson );
         com.projectthani.petitoriosubcategwwgetfilterdata_RESTInterfaceOUT data = new com.projectthani.petitoriosubcategwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV25OptionsJson[0]);
         data.setOptionsDescJson(AV28OptionsDescJson[0]);
         data.setOptionIndexesJson(AV30OptionIndexesJson[0]);
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
