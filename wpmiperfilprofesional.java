package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.wpmiperfilprofesional", "/com.projectthani.wpmiperfilprofesional", "/com.projectthani.wpmiperfilprofesional/gxobject"})
public final  class wpmiperfilprofesional extends GXWebObjectStub
{
   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.projectthani.GXcfg.class);
      com.projectthani.wpmiperfilprofesional_impl pgm = new com.projectthani.wpmiperfilprofesional_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      if ( HttpUtils.isUploadRequest(context) )
      {
         new GXObjectUploadServices().doInternalExecute(context);
      }
      else
      {
         new wpmiperfilprofesional_impl(context).doExecute();
      }
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wpmiperfilprofesional_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Mi Perfil";
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

