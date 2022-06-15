package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wwpbaseobjects.secusersecuserroleassociation", "/com.projectthani.wwpbaseobjects.secusersecuserroleassociation"})
public final  class secusersecuserroleassociation extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secusersecuserroleassociation_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secusersecuserroleassociation_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec User Sec User Role Association";
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

