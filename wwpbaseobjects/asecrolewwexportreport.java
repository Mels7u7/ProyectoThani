package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wwpbaseobjects.asecrolewwexportreport", "/com.projectthani.wwpbaseobjects.asecrolewwexportreport"})
public final  class asecrolewwexportreport extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new asecrolewwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new asecrolewwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec Role WWExport Report";
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
