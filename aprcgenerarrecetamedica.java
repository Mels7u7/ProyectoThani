package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.projectthani.aprcgenerarrecetamedica", "/com.projectthani.aprcgenerarrecetamedica"})
public final  class aprcgenerarrecetamedica extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new aprcgenerarrecetamedica_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new aprcgenerarrecetamedica_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Prc Generar Receta Medica";
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

