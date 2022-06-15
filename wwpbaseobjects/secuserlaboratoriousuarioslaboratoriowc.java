package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wwpbaseobjects.secuserlaboratoriousuarioslaboratoriowc", "/com.projectthani.wwpbaseobjects.secuserlaboratoriousuarioslaboratoriowc"})
public final  class secuserlaboratoriousuarioslaboratoriowc extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secuserlaboratoriousuarioslaboratoriowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secuserlaboratoriousuarioslaboratoriowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec User Laboratorio Usuarios Laboratorio WC";
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

