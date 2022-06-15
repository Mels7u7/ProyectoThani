package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wpregistrarreceta", "/com.projectthani.wpregistrarreceta", "/com.projectthani.wpregistrarreceta/gxobject"})
public final  class wpregistrarreceta extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      if ( HttpUtils.isUploadRequest(context) )
      {
         new GXObjectUploadServices().doInternalExecute(context);
      }
      else
      {
         new wpregistrarreceta_impl(context).doExecute();
      }
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wpregistrarreceta_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Registrar Receta";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

