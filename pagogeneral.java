package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.pagogeneral", "/com.projectthani.pagogeneral"})
public final  class pagogeneral extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pagogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pagogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pago General";
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
