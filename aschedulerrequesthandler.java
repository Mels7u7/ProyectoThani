package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.aschedulerrequesthandler", "/com.projectthani.aschedulerrequesthandler"})
public final  class aschedulerrequesthandler extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new aschedulerrequesthandler_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new aschedulerrequesthandler_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Scheduler Request Handler";
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

