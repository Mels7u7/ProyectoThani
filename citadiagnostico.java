package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.citadiagnostico", "/com.projectthani.citadiagnostico"})
public final  class citadiagnostico extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new citadiagnostico_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new citadiagnostico_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cita Diagnostico";
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

