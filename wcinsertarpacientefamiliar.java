package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wcinsertarpacientefamiliar", "/com.projectthani.wcinsertarpacientefamiliar"})
public final  class wcinsertarpacientefamiliar extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wcinsertarpacientefamiliar_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wcinsertarpacientefamiliar_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WCInsertar Paciente Familiar";
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

