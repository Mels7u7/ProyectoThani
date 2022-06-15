package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wprecuperarpassword", "/com.projectthani.wprecuperarpassword"})
public final  class wprecuperarpassword extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wprecuperarpassword_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wprecuperarpassword_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Recuperar Password";
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

