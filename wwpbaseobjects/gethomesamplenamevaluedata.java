package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wwpbaseobjects.gethomesamplenamevaluedata", "/com.projectthani.wwpbaseobjects.gethomesamplenamevaluedata"})
public final  class gethomesamplenamevaluedata extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gethomesamplenamevaluedata_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gethomesamplenamevaluedata_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Get Home Sample Name Value Data";
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

