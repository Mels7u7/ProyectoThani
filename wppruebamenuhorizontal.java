package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wppruebamenuhorizontal", "/com.projectthani.wppruebamenuhorizontal"})
public final  class wppruebamenuhorizontal extends GXWebObjectStub
{
   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.projectthani.GXcfg.class);
      com.projectthani.wppruebamenuhorizontal_impl pgm = new com.projectthani.wppruebamenuhorizontal_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wppruebamenuhorizontal_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wppruebamenuhorizontal_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WPPrueba Menu Horizontal";
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

