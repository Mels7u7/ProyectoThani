package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.petitoriocategww", "/com.projectthani.petitoriocategww"})
public final  class petitoriocategww extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new petitoriocategww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new petitoriocategww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Petitorio Categ";
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

