package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.detallecalendario", "/com.projectthani.detallecalendario"})
public final  class detallecalendario extends GXWebObjectStub
{
   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.projectthani.GXcfg.class);
      com.projectthani.detallecalendario_impl pgm = new com.projectthani.detallecalendario_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new detallecalendario_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new detallecalendario_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Disponibilidad del Profesional - Thani";
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

