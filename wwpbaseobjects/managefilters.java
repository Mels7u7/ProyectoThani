package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wwpbaseobjects.managefilters", "/com.projectthani.wwpbaseobjects.managefilters"})
public final  class managefilters extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new managefilters_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new managefilters_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Gestionador de filtros";
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

