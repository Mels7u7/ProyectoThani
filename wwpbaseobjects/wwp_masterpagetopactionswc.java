package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wwpbaseobjects.wwp_masterpagetopactionswc", "/com.projectthani.wwpbaseobjects.wwp_masterpagetopactionswc"})
public final  class wwp_masterpagetopactionswc extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_masterpagetopactionswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_masterpagetopactionswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Master Page Top Actions WC";
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
