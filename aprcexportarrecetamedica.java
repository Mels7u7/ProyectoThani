package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.aprcexportarrecetamedica", "/com.projectthani.aprcexportarrecetamedica"})
public final  class aprcexportarrecetamedica extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new aprcexportarrecetamedica_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new aprcexportarrecetamedica_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Prc Exportar Receta Medica";
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

