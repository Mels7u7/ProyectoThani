package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.confcomision", "/com.projectthani.confcomision"})
public final  class confcomision extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new confcomision_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new confcomision_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conf Comision";
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

