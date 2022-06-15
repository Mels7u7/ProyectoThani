package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.disponibilidadhoraria", "/com.projectthani.disponibilidadhoraria"})
public final  class disponibilidadhoraria extends GXWebObjectStub
{
   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.projectthani.GXcfg.class);
      com.projectthani.disponibilidadhoraria_impl pgm = new com.projectthani.disponibilidadhoraria_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new disponibilidadhoraria_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new disponibilidadhoraria_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Disponibilidad - Thani";
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

