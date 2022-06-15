package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wppacienteexportreport_impl extends GXWebReport
{
   public wppacienteexportreport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 1, 15840, 12240, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         GXv_SdtWWPContext1[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
         AV9WWPContext = GXv_SdtWWPContext1[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S151 ();
         if ( returnInSub )
         {
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV114Title = "Lista de Profesional" ;
         /* Execute user subroutine: 'PRINTFILTERS' */
         S111 ();
         if ( returnInSub )
         {
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'PRINTCOLUMNTITLES' */
         S121 ();
         if ( returnInSub )
         {
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'PRINTDATA' */
         S131 ();
         if ( returnInSub )
         {
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'PRINTFOOTER' */
         S171 ();
         if ( returnInSub )
         {
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h7V0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( ) throws ProcessInterruptedException
   {
      /* 'PRINTFILTERS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV23TFProfesionalId) && (0==AV24TFProfesionalId_To) ) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFProfesionalId), "ZZZZZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV92TFProfesionalId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV92TFProfesionalId_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV24TFProfesionalId_To), "ZZZZZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV27TFProfesionalTipoDocumento_Sels.fromJSonString(AV25TFProfesionalTipoDocumento_SelsJson, null);
      if ( ! ( AV27TFProfesionalTipoDocumento_Sels.size() == 0 ) )
      {
         AV103i = 1 ;
         AV120GXV1 = 1 ;
         while ( AV120GXV1 <= AV27TFProfesionalTipoDocumento_Sels.size() )
         {
            AV28TFProfesionalTipoDocumento_Sel = (String)AV27TFProfesionalTipoDocumento_Sels.elementAt(-1+AV120GXV1) ;
            if ( AV103i == 1 )
            {
               AV26TFProfesionalTipoDocumento_SelDscs = "" ;
            }
            else
            {
               AV26TFProfesionalTipoDocumento_SelDscs += ", " ;
            }
            AV93FilterTFProfesionalTipoDocumento_SelValueDescription = com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV28TFProfesionalTipoDocumento_Sel) ;
            AV26TFProfesionalTipoDocumento_SelDscs += AV93FilterTFProfesionalTipoDocumento_SelValueDescription ;
            AV103i = (long)(AV103i+1) ;
            AV120GXV1 = (int)(AV120GXV1+1) ;
         }
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Documento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFProfesionalTipoDocumento_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV30TFProfesionalNroDocumento_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFProfesionalNroDocumento_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFProfesionalNroDocumento)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFProfesionalNroDocumento, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV32TFProfesionalApellidoPaterno_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Apellido Paterno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFProfesionalApellidoPaterno_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFProfesionalApellidoPaterno)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Apellido Paterno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFProfesionalApellidoPaterno, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV34TFProfesionalApellidoMaterno_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Apellido Materno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFProfesionalApellidoMaterno_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV33TFProfesionalApellidoMaterno)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Apellido Materno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFProfesionalApellidoMaterno, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV36TFProfesionalNombres_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombres", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36TFProfesionalNombres_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV35TFProfesionalNombres)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombres", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFProfesionalNombres, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV38TFProfesionalNombreCompleto2_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Completo2", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFProfesionalNombreCompleto2_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV37TFProfesionalNombreCompleto2)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Completo2", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37TFProfesionalNombreCompleto2, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV39TFProfesionalFechaNacimiento)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV40TFProfesionalFechaNacimiento_To)) ) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha Nacimiento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV39TFProfesionalFechaNacimiento, "99/99/9999"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV94TFProfesionalFechaNacimiento_To_Description = GXutil.format( "%1 (%2)", "Fecha Nacimiento", "Hasta", "", "", "", "", "", "", "") ;
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV94TFProfesionalFechaNacimiento_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV40TFProfesionalFechaNacimiento_To, "99/99/9999"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV43TFProfesionalSexo_Sels.fromJSonString(AV41TFProfesionalSexo_SelsJson, null);
      if ( ! ( AV43TFProfesionalSexo_Sels.size() == 0 ) )
      {
         AV103i = 1 ;
         AV121GXV2 = 1 ;
         while ( AV121GXV2 <= AV43TFProfesionalSexo_Sels.size() )
         {
            AV44TFProfesionalSexo_Sel = (String)AV43TFProfesionalSexo_Sels.elementAt(-1+AV121GXV2) ;
            if ( AV103i == 1 )
            {
               AV42TFProfesionalSexo_SelDscs = "" ;
            }
            else
            {
               AV42TFProfesionalSexo_SelDscs += ", " ;
            }
            AV95FilterTFProfesionalSexo_SelValueDescription = com.projectthani.gxdomainsexo.getDescription(httpContext,(String)AV44TFProfesionalSexo_Sel) ;
            AV42TFProfesionalSexo_SelDscs += AV95FilterTFProfesionalSexo_SelValueDescription ;
            AV103i = (long)(AV103i+1) ;
            AV121GXV2 = (int)(AV121GXV2+1) ;
         }
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Sexo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFProfesionalSexo_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV46TFProfesionalDescripcion_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46TFProfesionalDescripcion_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV45TFProfesionalDescripcion)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45TFProfesionalDescripcion, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV48TFProfesionalCorreo_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Correo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48TFProfesionalCorreo_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV47TFProfesionalCorreo)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Correo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47TFProfesionalCorreo, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV50TFProfesionalCOP_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("CMP", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50TFProfesionalCOP_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV49TFProfesionalCOP)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("CMP", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49TFProfesionalCOP, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV52TFProfesionalColorDisponible_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Color Disponible", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52TFProfesionalColorDisponible_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV51TFProfesionalColorDisponible)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Color Disponible", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51TFProfesionalColorDisponible, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV54TFProfesionalColorCita_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Color Cita", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54TFProfesionalColorCita_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV53TFProfesionalColorCita)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Color Cita", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53TFProfesionalColorCita, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV57TFProfesionalTiempoCita_Sels.fromJSonString(AV55TFProfesionalTiempoCita_SelsJson, null);
      if ( ! ( AV57TFProfesionalTiempoCita_Sels.size() == 0 ) )
      {
         AV103i = 1 ;
         AV122GXV3 = 1 ;
         while ( AV122GXV3 <= AV57TFProfesionalTiempoCita_Sels.size() )
         {
            AV58TFProfesionalTiempoCita_Sel = ((Number) AV57TFProfesionalTiempoCita_Sels.elementAt(-1+AV122GXV3)).byteValue() ;
            if ( AV103i == 1 )
            {
               AV56TFProfesionalTiempoCita_SelDscs = "" ;
            }
            else
            {
               AV56TFProfesionalTiempoCita_SelDscs += ", " ;
            }
            AV96FilterTFProfesionalTiempoCita_SelValueDescription = com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)AV58TFProfesionalTiempoCita_Sel) ;
            AV56TFProfesionalTiempoCita_SelDscs += AV96FilterTFProfesionalTiempoCita_SelValueDescription ;
            AV103i = (long)(AV103i+1) ;
            AV122GXV3 = (int)(AV122GXV3+1) ;
         }
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tiempo Cita", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV56TFProfesionalTiempoCita_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV60TFProfesionalDireccion_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV60TFProfesionalDireccion_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV59TFProfesionalDireccion)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV59TFProfesionalDireccion, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV61TFPaisId) && (0==AV62TFPaisId_To) ) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Pais Id", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV61TFPaisId), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV97TFPaisId_To_Description = GXutil.format( "%1 (%2)", "Pais Id", "Hasta", "", "", "", "", "", "", "") ;
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV97TFPaisId_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV62TFPaisId_To), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV64TFPaisDescripcion_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Pais Descripcion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV64TFPaisDescripcion_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV63TFPaisDescripcion)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Pais Descripcion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV63TFPaisDescripcion, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV66TFUbigeoCode_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo Code", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV66TFUbigeoCode_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV65TFUbigeoCode)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo Code", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV65TFUbigeoCode, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV68TFUbigeoNombre_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV68TFUbigeoNombre_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV67TFUbigeoNombre)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV67TFUbigeoNombre, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV70TFProfesionalTwitter_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Twitter", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV70TFProfesionalTwitter_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV69TFProfesionalTwitter)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Twitter", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV69TFProfesionalTwitter, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV72TFProfesionalFacebook_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Facebook", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72TFProfesionalFacebook_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV71TFProfesionalFacebook)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Facebook", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV71TFProfesionalFacebook, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV74TFProfesionalInstagram_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Instagram", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV74TFProfesionalInstagram_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV73TFProfesionalInstagram)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Instagram", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV73TFProfesionalInstagram, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV76TFProfesionalLinkedin_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Linkedin", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV76TFProfesionalLinkedin_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV75TFProfesionalLinkedin)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Linkedin", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV75TFProfesionalLinkedin, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV78TFProfesionalTelefono_Sel)==0) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Telefono", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV78TFProfesionalTelefono_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV77TFProfesionalTelefono)==0) )
         {
            h7V0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Telefono", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV77TFProfesionalTelefono, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV79TFSecUserId) && (0==AV80TFSecUserId_To) ) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("User Id", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV79TFSecUserId), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV98TFSecUserId_To_Description = GXutil.format( "%1 (%2)", "User Id", "Hasta", "", "", "", "", "", "", "") ;
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV98TFSecUserId_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV80TFSecUserId_To), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV81TFProfesionalFechaRegistro)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV82TFProfesionalFechaRegistro_To)) ) )
      {
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha Registro", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV81TFProfesionalFechaRegistro, "99/99/99"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV99TFProfesionalFechaRegistro_To_Description = GXutil.format( "%1 (%2)", "Fecha Registro", "Hasta", "", "", "", "", "", "", "") ;
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV99TFProfesionalFechaRegistro_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV82TFProfesionalFechaRegistro_To, "99/99/99"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (0==AV83TFProfesionalTerminosCondiciones_Sel) )
      {
         if ( AV83TFProfesionalTerminosCondiciones_Sel == 1 )
         {
            AV100FilterTFProfesionalTerminosCondiciones_SelValueDescription = "Marcado" ;
         }
         else if ( AV83TFProfesionalTerminosCondiciones_Sel == 2 )
         {
            AV100FilterTFProfesionalTerminosCondiciones_SelValueDescription = "Desmarcado" ;
         }
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Terminos Condiciones", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV100FilterTFProfesionalTerminosCondiciones_SelValueDescription, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV86TFProfesionalEstadoCuenta_Sels.fromJSonString(AV84TFProfesionalEstadoCuenta_SelsJson, null);
      if ( ! ( AV86TFProfesionalEstadoCuenta_Sels.size() == 0 ) )
      {
         AV103i = 1 ;
         AV123GXV4 = 1 ;
         while ( AV123GXV4 <= AV86TFProfesionalEstadoCuenta_Sels.size() )
         {
            AV87TFProfesionalEstadoCuenta_Sel = (String)AV86TFProfesionalEstadoCuenta_Sels.elementAt(-1+AV123GXV4) ;
            if ( AV103i == 1 )
            {
               AV85TFProfesionalEstadoCuenta_SelDscs = "" ;
            }
            else
            {
               AV85TFProfesionalEstadoCuenta_SelDscs += ", " ;
            }
            AV101FilterTFProfesionalEstadoCuenta_SelValueDescription = com.projectthani.gxdomainestadocuenta.getDescription(httpContext,(String)AV87TFProfesionalEstadoCuenta_Sel) ;
            AV85TFProfesionalEstadoCuenta_SelDscs += AV101FilterTFProfesionalEstadoCuenta_SelValueDescription ;
            AV103i = (long)(AV103i+1) ;
            AV123GXV4 = (int)(AV123GXV4+1) ;
         }
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado Cuenta", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV85TFProfesionalEstadoCuenta_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV90TFProfesionalEstado_Sels.fromJSonString(AV88TFProfesionalEstado_SelsJson, null);
      if ( ! ( AV90TFProfesionalEstado_Sels.size() == 0 ) )
      {
         AV103i = 1 ;
         AV124GXV5 = 1 ;
         while ( AV124GXV5 <= AV90TFProfesionalEstado_Sels.size() )
         {
            AV91TFProfesionalEstado_Sel = (String)AV90TFProfesionalEstado_Sels.elementAt(-1+AV124GXV5) ;
            if ( AV103i == 1 )
            {
               AV89TFProfesionalEstado_SelDscs = "" ;
            }
            else
            {
               AV89TFProfesionalEstado_SelDscs += ", " ;
            }
            AV102FilterTFProfesionalEstado_SelValueDescription = com.projectthani.gxdomainestadoprofesional.getDescription(httpContext,(String)AV91TFProfesionalEstado_Sel) ;
            AV89TFProfesionalEstado_SelDscs += AV102FilterTFProfesionalEstado_SelValueDescription ;
            AV103i = (long)(AV103i+1) ;
            AV124GXV5 = (int)(AV124GXV5+1) ;
         }
         h7V0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV89TFProfesionalEstado_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h7V0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h7V0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 50, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Documento", 54, Gx_line+10, 74, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nro Documento", 78, Gx_line+10, 98, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Apellido Paterno", 102, Gx_line+10, 122, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Apellido Materno", 126, Gx_line+10, 146, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombres", 150, Gx_line+10, 170, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Completo2", 174, Gx_line+10, 194, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha Nacimiento", 198, Gx_line+10, 218, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Sexo", 222, Gx_line+10, 242, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 246, Gx_line+10, 266, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Correo", 270, Gx_line+10, 290, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("CMP", 294, Gx_line+10, 314, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Color Disponible", 318, Gx_line+10, 338, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Color Cita", 342, Gx_line+10, 362, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tiempo Cita", 366, Gx_line+10, 386, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Direccion", 390, Gx_line+10, 410, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Pais Id", 414, Gx_line+10, 434, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Pais Descripcion", 438, Gx_line+10, 458, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo Code", 462, Gx_line+10, 482, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo", 486, Gx_line+10, 506, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Foto", 510, Gx_line+10, 530, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Twitter", 534, Gx_line+10, 556, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Facebook", 560, Gx_line+10, 582, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Instagram", 586, Gx_line+10, 608, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Linkedin", 612, Gx_line+10, 634, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Telefono", 638, Gx_line+10, 660, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("User Id", 664, Gx_line+10, 685, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha Registro", 689, Gx_line+10, 710, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Terminos Condiciones", 714, Gx_line+10, 735, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado Cuenta", 739, Gx_line+10, 761, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 765, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV126Wppacienteds_1_filterfulltext = AV13FilterFullText ;
      AV127Wppacienteds_2_tfprofesionalid = AV23TFProfesionalId ;
      AV128Wppacienteds_3_tfprofesionalid_to = AV24TFProfesionalId_To ;
      AV129Wppacienteds_4_tfprofesionaltipodocumento_sels = AV27TFProfesionalTipoDocumento_Sels ;
      AV130Wppacienteds_5_tfprofesionalnrodocumento = AV29TFProfesionalNroDocumento ;
      AV131Wppacienteds_6_tfprofesionalnrodocumento_sel = AV30TFProfesionalNroDocumento_Sel ;
      AV132Wppacienteds_7_tfprofesionalapellidopaterno = AV31TFProfesionalApellidoPaterno ;
      AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV32TFProfesionalApellidoPaterno_Sel ;
      AV134Wppacienteds_9_tfprofesionalapellidomaterno = AV33TFProfesionalApellidoMaterno ;
      AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV34TFProfesionalApellidoMaterno_Sel ;
      AV136Wppacienteds_11_tfprofesionalnombres = AV35TFProfesionalNombres ;
      AV137Wppacienteds_12_tfprofesionalnombres_sel = AV36TFProfesionalNombres_Sel ;
      AV138Wppacienteds_13_tfprofesionalnombrecompleto2 = AV37TFProfesionalNombreCompleto2 ;
      AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV38TFProfesionalNombreCompleto2_Sel ;
      AV140Wppacienteds_15_tfprofesionalfechanacimiento = AV39TFProfesionalFechaNacimiento ;
      AV141Wppacienteds_16_tfprofesionalfechanacimiento_to = AV40TFProfesionalFechaNacimiento_To ;
      AV142Wppacienteds_17_tfprofesionalsexo_sels = AV43TFProfesionalSexo_Sels ;
      AV143Wppacienteds_18_tfprofesionaldescripcion = AV45TFProfesionalDescripcion ;
      AV144Wppacienteds_19_tfprofesionaldescripcion_sel = AV46TFProfesionalDescripcion_Sel ;
      AV145Wppacienteds_20_tfprofesionalcorreo = AV47TFProfesionalCorreo ;
      AV146Wppacienteds_21_tfprofesionalcorreo_sel = AV48TFProfesionalCorreo_Sel ;
      AV147Wppacienteds_22_tfprofesionalcop = AV49TFProfesionalCOP ;
      AV148Wppacienteds_23_tfprofesionalcop_sel = AV50TFProfesionalCOP_Sel ;
      AV149Wppacienteds_24_tfprofesionalcolordisponible = AV51TFProfesionalColorDisponible ;
      AV150Wppacienteds_25_tfprofesionalcolordisponible_sel = AV52TFProfesionalColorDisponible_Sel ;
      AV151Wppacienteds_26_tfprofesionalcolorcita = AV53TFProfesionalColorCita ;
      AV152Wppacienteds_27_tfprofesionalcolorcita_sel = AV54TFProfesionalColorCita_Sel ;
      AV153Wppacienteds_28_tfprofesionaltiempocita_sels = AV57TFProfesionalTiempoCita_Sels ;
      AV154Wppacienteds_29_tfprofesionaldireccion = AV59TFProfesionalDireccion ;
      AV155Wppacienteds_30_tfprofesionaldireccion_sel = AV60TFProfesionalDireccion_Sel ;
      AV156Wppacienteds_31_tfpaisid = AV61TFPaisId ;
      AV157Wppacienteds_32_tfpaisid_to = AV62TFPaisId_To ;
      AV158Wppacienteds_33_tfpaisdescripcion = AV63TFPaisDescripcion ;
      AV159Wppacienteds_34_tfpaisdescripcion_sel = AV64TFPaisDescripcion_Sel ;
      AV160Wppacienteds_35_tfubigeocode = AV65TFUbigeoCode ;
      AV161Wppacienteds_36_tfubigeocode_sel = AV66TFUbigeoCode_Sel ;
      AV162Wppacienteds_37_tfubigeonombre = AV67TFUbigeoNombre ;
      AV163Wppacienteds_38_tfubigeonombre_sel = AV68TFUbigeoNombre_Sel ;
      AV164Wppacienteds_39_tfprofesionaltwitter = AV69TFProfesionalTwitter ;
      AV165Wppacienteds_40_tfprofesionaltwitter_sel = AV70TFProfesionalTwitter_Sel ;
      AV166Wppacienteds_41_tfprofesionalfacebook = AV71TFProfesionalFacebook ;
      AV167Wppacienteds_42_tfprofesionalfacebook_sel = AV72TFProfesionalFacebook_Sel ;
      AV168Wppacienteds_43_tfprofesionalinstagram = AV73TFProfesionalInstagram ;
      AV169Wppacienteds_44_tfprofesionalinstagram_sel = AV74TFProfesionalInstagram_Sel ;
      AV170Wppacienteds_45_tfprofesionallinkedin = AV75TFProfesionalLinkedin ;
      AV171Wppacienteds_46_tfprofesionallinkedin_sel = AV76TFProfesionalLinkedin_Sel ;
      AV172Wppacienteds_47_tfprofesionaltelefono = AV77TFProfesionalTelefono ;
      AV173Wppacienteds_48_tfprofesionaltelefono_sel = AV78TFProfesionalTelefono_Sel ;
      AV174Wppacienteds_49_tfsecuserid = AV79TFSecUserId ;
      AV175Wppacienteds_50_tfsecuserid_to = AV80TFSecUserId_To ;
      AV176Wppacienteds_51_tfprofesionalfecharegistro = AV81TFProfesionalFechaRegistro ;
      AV177Wppacienteds_52_tfprofesionalfecharegistro_to = AV82TFProfesionalFechaRegistro_To ;
      AV178Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV83TFProfesionalTerminosCondiciones_Sel ;
      AV179Wppacienteds_54_tfprofesionalestadocuenta_sels = AV86TFProfesionalEstadoCuenta_Sels ;
      AV180Wppacienteds_55_tfprofesionalestado_sels = AV90TFProfesionalEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A173ProfesionalTipoDocumento ,
                                           AV129Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                           A177ProfesionalSexo ,
                                           AV142Wppacienteds_17_tfprofesionalsexo_sels ,
                                           Byte.valueOf(A182ProfesionalTiempoCita) ,
                                           AV153Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                           A197ProfesionalEstadoCuenta ,
                                           AV179Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                           A198ProfesionalEstado ,
                                           AV180Wppacienteds_55_tfprofesionalestado_sels ,
                                           AV126Wppacienteds_1_filterfulltext ,
                                           Integer.valueOf(AV127Wppacienteds_2_tfprofesionalid) ,
                                           Integer.valueOf(AV128Wppacienteds_3_tfprofesionalid_to) ,
                                           Integer.valueOf(AV129Wppacienteds_4_tfprofesionaltipodocumento_sels.size()) ,
                                           AV131Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                           AV130Wppacienteds_5_tfprofesionalnrodocumento ,
                                           AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                           AV132Wppacienteds_7_tfprofesionalapellidopaterno ,
                                           AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                           AV134Wppacienteds_9_tfprofesionalapellidomaterno ,
                                           AV137Wppacienteds_12_tfprofesionalnombres_sel ,
                                           AV136Wppacienteds_11_tfprofesionalnombres ,
                                           AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                           AV138Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                           AV140Wppacienteds_15_tfprofesionalfechanacimiento ,
                                           AV141Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                           Integer.valueOf(AV142Wppacienteds_17_tfprofesionalsexo_sels.size()) ,
                                           AV144Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                           AV143Wppacienteds_18_tfprofesionaldescripcion ,
                                           AV146Wppacienteds_21_tfprofesionalcorreo_sel ,
                                           AV145Wppacienteds_20_tfprofesionalcorreo ,
                                           AV148Wppacienteds_23_tfprofesionalcop_sel ,
                                           AV147Wppacienteds_22_tfprofesionalcop ,
                                           AV150Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                           AV149Wppacienteds_24_tfprofesionalcolordisponible ,
                                           AV152Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                           AV151Wppacienteds_26_tfprofesionalcolorcita ,
                                           Integer.valueOf(AV153Wppacienteds_28_tfprofesionaltiempocita_sels.size()) ,
                                           AV155Wppacienteds_30_tfprofesionaldireccion_sel ,
                                           AV154Wppacienteds_29_tfprofesionaldireccion ,
                                           Short.valueOf(AV156Wppacienteds_31_tfpaisid) ,
                                           Short.valueOf(AV157Wppacienteds_32_tfpaisid_to) ,
                                           AV159Wppacienteds_34_tfpaisdescripcion_sel ,
                                           AV158Wppacienteds_33_tfpaisdescripcion ,
                                           AV161Wppacienteds_36_tfubigeocode_sel ,
                                           AV160Wppacienteds_35_tfubigeocode ,
                                           AV163Wppacienteds_38_tfubigeonombre_sel ,
                                           AV162Wppacienteds_37_tfubigeonombre ,
                                           AV165Wppacienteds_40_tfprofesionaltwitter_sel ,
                                           AV164Wppacienteds_39_tfprofesionaltwitter ,
                                           AV167Wppacienteds_42_tfprofesionalfacebook_sel ,
                                           AV166Wppacienteds_41_tfprofesionalfacebook ,
                                           AV169Wppacienteds_44_tfprofesionalinstagram_sel ,
                                           AV168Wppacienteds_43_tfprofesionalinstagram ,
                                           AV171Wppacienteds_46_tfprofesionallinkedin_sel ,
                                           AV170Wppacienteds_45_tfprofesionallinkedin ,
                                           AV173Wppacienteds_48_tfprofesionaltelefono_sel ,
                                           AV172Wppacienteds_47_tfprofesionaltelefono ,
                                           Short.valueOf(AV174Wppacienteds_49_tfsecuserid) ,
                                           Short.valueOf(AV175Wppacienteds_50_tfsecuserid_to) ,
                                           AV176Wppacienteds_51_tfprofesionalfecharegistro ,
                                           AV177Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                           Byte.valueOf(AV178Wppacienteds_53_tfprofesionalterminoscondiciones_sel) ,
                                           Integer.valueOf(AV179Wppacienteds_54_tfprofesionalestadocuenta_sels.size()) ,
                                           Integer.valueOf(AV180Wppacienteds_55_tfprofesionalestado_sels.size()) ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A174ProfesionalNroDocumento ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A178ProfesionalDescripcion ,
                                           A179ProfesionalCorreo ,
                                           A88ProfesionalCOP ,
                                           A180ProfesionalColorDisponible ,
                                           A181ProfesionalColorCita ,
                                           A183ProfesionalDireccion ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A190ProfesionalTwitter ,
                                           A191ProfesionalFacebook ,
                                           A192ProfesionalInstagram ,
                                           A193ProfesionalLinkedin ,
                                           A194ProfesionalTelefono ,
                                           Short.valueOf(A6SecUserId) ,
                                           A176ProfesionalFechaNacimiento ,
                                           A195ProfesionalFechaRegistro ,
                                           Boolean.valueOf(A196ProfesionalTerminosCondiciones) ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV126Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_1_filterfulltext), "%", "") ;
      lV130Wppacienteds_5_tfprofesionalnrodocumento = GXutil.concat( GXutil.rtrim( AV130Wppacienteds_5_tfprofesionalnrodocumento), "%", "") ;
      lV132Wppacienteds_7_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV132Wppacienteds_7_tfprofesionalapellidopaterno), "%", "") ;
      lV134Wppacienteds_9_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV134Wppacienteds_9_tfprofesionalapellidomaterno), "%", "") ;
      lV136Wppacienteds_11_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV136Wppacienteds_11_tfprofesionalnombres), "%", "") ;
      lV138Wppacienteds_13_tfprofesionalnombrecompleto2 = GXutil.concat( GXutil.rtrim( AV138Wppacienteds_13_tfprofesionalnombrecompleto2), "%", "") ;
      lV143Wppacienteds_18_tfprofesionaldescripcion = GXutil.concat( GXutil.rtrim( AV143Wppacienteds_18_tfprofesionaldescripcion), "%", "") ;
      lV145Wppacienteds_20_tfprofesionalcorreo = GXutil.concat( GXutil.rtrim( AV145Wppacienteds_20_tfprofesionalcorreo), "%", "") ;
      lV147Wppacienteds_22_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV147Wppacienteds_22_tfprofesionalcop), "%", "") ;
      lV149Wppacienteds_24_tfprofesionalcolordisponible = GXutil.padr( GXutil.rtrim( AV149Wppacienteds_24_tfprofesionalcolordisponible), 20, "%") ;
      lV151Wppacienteds_26_tfprofesionalcolorcita = GXutil.padr( GXutil.rtrim( AV151Wppacienteds_26_tfprofesionalcolorcita), 20, "%") ;
      lV154Wppacienteds_29_tfprofesionaldireccion = GXutil.concat( GXutil.rtrim( AV154Wppacienteds_29_tfprofesionaldireccion), "%", "") ;
      lV158Wppacienteds_33_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV158Wppacienteds_33_tfpaisdescripcion), "%", "") ;
      lV160Wppacienteds_35_tfubigeocode = GXutil.padr( GXutil.rtrim( AV160Wppacienteds_35_tfubigeocode), 10, "%") ;
      lV162Wppacienteds_37_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV162Wppacienteds_37_tfubigeonombre), "%", "") ;
      lV164Wppacienteds_39_tfprofesionaltwitter = GXutil.concat( GXutil.rtrim( AV164Wppacienteds_39_tfprofesionaltwitter), "%", "") ;
      lV166Wppacienteds_41_tfprofesionalfacebook = GXutil.concat( GXutil.rtrim( AV166Wppacienteds_41_tfprofesionalfacebook), "%", "") ;
      lV168Wppacienteds_43_tfprofesionalinstagram = GXutil.concat( GXutil.rtrim( AV168Wppacienteds_43_tfprofesionalinstagram), "%", "") ;
      lV170Wppacienteds_45_tfprofesionallinkedin = GXutil.concat( GXutil.rtrim( AV170Wppacienteds_45_tfprofesionallinkedin), "%", "") ;
      lV172Wppacienteds_47_tfprofesionaltelefono = GXutil.padr( GXutil.rtrim( AV172Wppacienteds_47_tfprofesionaltelefono), 20, "%") ;
      /* Using cursor P007V2 */
      pr_default.execute(0, new Object[] {lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, lV126Wppacienteds_1_filterfulltext, Integer.valueOf(AV127Wppacienteds_2_tfprofesionalid), Integer.valueOf(AV128Wppacienteds_3_tfprofesionalid_to), lV130Wppacienteds_5_tfprofesionalnrodocumento, AV131Wppacienteds_6_tfprofesionalnrodocumento_sel, lV132Wppacienteds_7_tfprofesionalapellidopaterno, AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel, lV134Wppacienteds_9_tfprofesionalapellidomaterno, AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel, lV136Wppacienteds_11_tfprofesionalnombres, AV137Wppacienteds_12_tfprofesionalnombres_sel, lV138Wppacienteds_13_tfprofesionalnombrecompleto2, AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel, AV140Wppacienteds_15_tfprofesionalfechanacimiento, AV141Wppacienteds_16_tfprofesionalfechanacimiento_to, lV143Wppacienteds_18_tfprofesionaldescripcion, AV144Wppacienteds_19_tfprofesionaldescripcion_sel, lV145Wppacienteds_20_tfprofesionalcorreo, AV146Wppacienteds_21_tfprofesionalcorreo_sel, lV147Wppacienteds_22_tfprofesionalcop, AV148Wppacienteds_23_tfprofesionalcop_sel, lV149Wppacienteds_24_tfprofesionalcolordisponible, AV150Wppacienteds_25_tfprofesionalcolordisponible_sel, lV151Wppacienteds_26_tfprofesionalcolorcita, AV152Wppacienteds_27_tfprofesionalcolorcita_sel, lV154Wppacienteds_29_tfprofesionaldireccion, AV155Wppacienteds_30_tfprofesionaldireccion_sel, Short.valueOf(AV156Wppacienteds_31_tfpaisid), Short.valueOf(AV157Wppacienteds_32_tfpaisid_to), lV158Wppacienteds_33_tfpaisdescripcion, AV159Wppacienteds_34_tfpaisdescripcion_sel, lV160Wppacienteds_35_tfubigeocode, AV161Wppacienteds_36_tfubigeocode_sel, lV162Wppacienteds_37_tfubigeonombre, AV163Wppacienteds_38_tfubigeonombre_sel, lV164Wppacienteds_39_tfprofesionaltwitter, AV165Wppacienteds_40_tfprofesionaltwitter_sel, lV166Wppacienteds_41_tfprofesionalfacebook, AV167Wppacienteds_42_tfprofesionalfacebook_sel, lV168Wppacienteds_43_tfprofesionalinstagram, AV169Wppacienteds_44_tfprofesionalinstagram_sel, lV170Wppacienteds_45_tfprofesionallinkedin, AV171Wppacienteds_46_tfprofesionallinkedin_sel, lV172Wppacienteds_47_tfprofesionaltelefono, AV173Wppacienteds_48_tfprofesionaltelefono_sel, Short.valueOf(AV174Wppacienteds_49_tfsecuserid), Short.valueOf(AV175Wppacienteds_50_tfsecuserid_to), AV176Wppacienteds_51_tfprofesionalfecharegistro, AV177Wppacienteds_52_tfprofesionalfecharegistro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A196ProfesionalTerminosCondiciones = P007V2_A196ProfesionalTerminosCondiciones[0] ;
         A195ProfesionalFechaRegistro = P007V2_A195ProfesionalFechaRegistro[0] ;
         A6SecUserId = P007V2_A6SecUserId[0] ;
         A43PaisId = P007V2_A43PaisId[0] ;
         A176ProfesionalFechaNacimiento = P007V2_A176ProfesionalFechaNacimiento[0] ;
         A31ProfesionalId = P007V2_A31ProfesionalId[0] ;
         A198ProfesionalEstado = P007V2_A198ProfesionalEstado[0] ;
         A197ProfesionalEstadoCuenta = P007V2_A197ProfesionalEstadoCuenta[0] ;
         A194ProfesionalTelefono = P007V2_A194ProfesionalTelefono[0] ;
         A193ProfesionalLinkedin = P007V2_A193ProfesionalLinkedin[0] ;
         A192ProfesionalInstagram = P007V2_A192ProfesionalInstagram[0] ;
         A191ProfesionalFacebook = P007V2_A191ProfesionalFacebook[0] ;
         A190ProfesionalTwitter = P007V2_A190ProfesionalTwitter[0] ;
         A44UbigeoCode = P007V2_A44UbigeoCode[0] ;
         A184PaisDescripcion = P007V2_A184PaisDescripcion[0] ;
         A183ProfesionalDireccion = P007V2_A183ProfesionalDireccion[0] ;
         A182ProfesionalTiempoCita = P007V2_A182ProfesionalTiempoCita[0] ;
         A181ProfesionalColorCita = P007V2_A181ProfesionalColorCita[0] ;
         A180ProfesionalColorDisponible = P007V2_A180ProfesionalColorDisponible[0] ;
         A88ProfesionalCOP = P007V2_A88ProfesionalCOP[0] ;
         A179ProfesionalCorreo = P007V2_A179ProfesionalCorreo[0] ;
         A178ProfesionalDescripcion = P007V2_A178ProfesionalDescripcion[0] ;
         A177ProfesionalSexo = P007V2_A177ProfesionalSexo[0] ;
         A174ProfesionalNroDocumento = P007V2_A174ProfesionalNroDocumento[0] ;
         A173ProfesionalTipoDocumento = P007V2_A173ProfesionalTipoDocumento[0] ;
         A40000ProfesionalFoto_GXI = P007V2_A40000ProfesionalFoto_GXI[0] ;
         A189ProfesionalFoto = P007V2_A189ProfesionalFoto[0] ;
         A84ProfesionalNombres = P007V2_A84ProfesionalNombres[0] ;
         A86ProfesionalApellidoMaterno = P007V2_A86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P007V2_A85ProfesionalApellidoPaterno[0] ;
         A188UbigeoDistrito = P007V2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007V2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007V2_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P007V2_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P007V2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007V2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007V2_A186UbigeoDepartamento[0] ;
         A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV14ProfesionalTipoDocumentoDescription = com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A173ProfesionalTipoDocumento) ;
         AV15ProfesionalSexoDescription = com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A177ProfesionalSexo) ;
         AV16ProfesionalTiempoCitaDescription = com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)A182ProfesionalTiempoCita) ;
         AV17ProfesionalEstadoCuentaDescription = com.projectthani.gxdomainestadocuenta.getDescription(httpContext,(String)A197ProfesionalEstadoCuenta) ;
         AV18ProfesionalEstadoDescription = com.projectthani.gxdomainestadoprofesional.getDescription(httpContext,(String)A198ProfesionalEstado) ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h7V0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9")), 30, Gx_line+10, 50, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14ProfesionalTipoDocumentoDescription, "")), 54, Gx_line+10, 74, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A174ProfesionalNroDocumento, "")), 78, Gx_line+10, 98, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A85ProfesionalApellidoPaterno, "")), 102, Gx_line+10, 122, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A86ProfesionalApellidoMaterno, "")), 126, Gx_line+10, 146, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A84ProfesionalNombres, "")), 150, Gx_line+10, 170, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A175ProfesionalNombreCompleto2, "")), 174, Gx_line+10, 194, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A176ProfesionalFechaNacimiento, "99/99/9999"), 198, Gx_line+10, 218, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15ProfesionalSexoDescription, "")), 222, Gx_line+10, 242, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A178ProfesionalDescripcion, "")), 246, Gx_line+10, 266, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A179ProfesionalCorreo, "")), 270, Gx_line+10, 290, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A88ProfesionalCOP, "")), 294, Gx_line+10, 314, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A180ProfesionalColorDisponible, "")), 318, Gx_line+10, 338, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A181ProfesionalColorCita, "")), 342, Gx_line+10, 362, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV16ProfesionalTiempoCitaDescription, "")), 366, Gx_line+10, 386, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A183ProfesionalDireccion, "")), 390, Gx_line+10, 410, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9")), 414, Gx_line+10, 434, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A184PaisDescripcion, "")), 438, Gx_line+10, 458, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), 462, Gx_line+10, 482, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), 486, Gx_line+10, 506, Gx_line+55, 0, 0, 0, 0) ;
         sImgUrl = ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : A189ProfesionalFoto) ;
         getPrinter().GxDrawBitMap(sImgUrl, 510, Gx_line+10, 530, Gx_line+55) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A190ProfesionalTwitter, "")), 534, Gx_line+10, 556, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A191ProfesionalFacebook, "")), 560, Gx_line+10, 582, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A192ProfesionalInstagram, "")), 586, Gx_line+10, 608, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A193ProfesionalLinkedin, "")), 612, Gx_line+10, 634, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A194ProfesionalTelefono, "")), 638, Gx_line+10, 660, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9")), 664, Gx_line+10, 685, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A195ProfesionalFechaRegistro, "99/99/99"), 689, Gx_line+10, 710, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.booltostr( A196ProfesionalTerminosCondiciones), 714, Gx_line+10, 735, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV17ProfesionalEstadoCuentaDescription, "")), 739, Gx_line+10, 761, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV18ProfesionalEstadoDescription, "")), 765, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue("WPPacienteGridState"), "") == 0 )
      {
         AV21GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WPPacienteGridState"), null, null);
      }
      else
      {
         AV21GridState.fromxml(AV19Session.getValue("WPPacienteGridState"), null, null);
      }
      AV11OrderedBy = AV21GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV21GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV181GXV6 = 1 ;
      while ( AV181GXV6 <= AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV22GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV181GXV6));
         if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV23TFProfesionalId = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFProfesionalId_To = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTIPODOCUMENTO_SEL") == 0 )
         {
            AV25TFProfesionalTipoDocumento_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFProfesionalTipoDocumento_Sels.fromJSonString(AV25TFProfesionalTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNRODOCUMENTO") == 0 )
         {
            AV29TFProfesionalNroDocumento = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNRODOCUMENTO_SEL") == 0 )
         {
            AV30TFProfesionalNroDocumento_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV31TFProfesionalApellidoPaterno = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV32TFProfesionalApellidoPaterno_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV33TFProfesionalApellidoMaterno = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV34TFProfesionalApellidoMaterno_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV35TFProfesionalNombres = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV36TFProfesionalNombres_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO2") == 0 )
         {
            AV37TFProfesionalNombreCompleto2 = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO2_SEL") == 0 )
         {
            AV38TFProfesionalNombreCompleto2_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFECHANACIMIENTO") == 0 )
         {
            AV39TFProfesionalFechaNacimiento = localUtil.ctod( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV40TFProfesionalFechaNacimiento_To = localUtil.ctod( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALSEXO_SEL") == 0 )
         {
            AV41TFProfesionalSexo_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFProfesionalSexo_Sels.fromJSonString(AV41TFProfesionalSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDESCRIPCION") == 0 )
         {
            AV45TFProfesionalDescripcion = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDESCRIPCION_SEL") == 0 )
         {
            AV46TFProfesionalDescripcion_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCORREO") == 0 )
         {
            AV47TFProfesionalCorreo = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCORREO_SEL") == 0 )
         {
            AV48TFProfesionalCorreo_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV49TFProfesionalCOP = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV50TFProfesionalCOP_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORDISPONIBLE") == 0 )
         {
            AV51TFProfesionalColorDisponible = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORDISPONIBLE_SEL") == 0 )
         {
            AV52TFProfesionalColorDisponible_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORCITA") == 0 )
         {
            AV53TFProfesionalColorCita = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORCITA_SEL") == 0 )
         {
            AV54TFProfesionalColorCita_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTIEMPOCITA_SEL") == 0 )
         {
            AV55TFProfesionalTiempoCita_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFProfesionalTiempoCita_Sels.fromJSonString(AV55TFProfesionalTiempoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDIRECCION") == 0 )
         {
            AV59TFProfesionalDireccion = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDIRECCION_SEL") == 0 )
         {
            AV60TFProfesionalDireccion_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV61TFPaisId = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV62TFPaisId_To = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV63TFPaisDescripcion = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV64TFPaisDescripcion_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV65TFUbigeoCode = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV66TFUbigeoCode_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV67TFUbigeoNombre = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV68TFUbigeoNombre_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTWITTER") == 0 )
         {
            AV69TFProfesionalTwitter = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTWITTER_SEL") == 0 )
         {
            AV70TFProfesionalTwitter_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFACEBOOK") == 0 )
         {
            AV71TFProfesionalFacebook = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFACEBOOK_SEL") == 0 )
         {
            AV72TFProfesionalFacebook_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALINSTAGRAM") == 0 )
         {
            AV73TFProfesionalInstagram = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALINSTAGRAM_SEL") == 0 )
         {
            AV74TFProfesionalInstagram_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALLINKEDIN") == 0 )
         {
            AV75TFProfesionalLinkedin = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALLINKEDIN_SEL") == 0 )
         {
            AV76TFProfesionalLinkedin_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTELEFONO") == 0 )
         {
            AV77TFProfesionalTelefono = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTELEFONO_SEL") == 0 )
         {
            AV78TFProfesionalTelefono_Sel = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV79TFSecUserId = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV80TFSecUserId_To = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFECHAREGISTRO") == 0 )
         {
            AV81TFProfesionalFechaRegistro = localUtil.ctod( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV82TFProfesionalFechaRegistro_To = localUtil.ctod( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTERMINOSCONDICIONES_SEL") == 0 )
         {
            AV83TFProfesionalTerminosCondiciones_Sel = (byte)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALESTADOCUENTA_SEL") == 0 )
         {
            AV84TFProfesionalEstadoCuenta_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV86TFProfesionalEstadoCuenta_Sels.fromJSonString(AV84TFProfesionalEstadoCuenta_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALESTADO_SEL") == 0 )
         {
            AV88TFProfesionalEstado_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV90TFProfesionalEstado_Sels.fromJSonString(AV88TFProfesionalEstado_SelsJson, null);
         }
         AV181GXV6 = (int)(AV181GXV6+1) ;
      }
   }

   public void S144( ) throws ProcessInterruptedException
   {
      /* 'BEFOREPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S161( ) throws ProcessInterruptedException
   {
      /* 'AFTERPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S171( ) throws ProcessInterruptedException
   {
      /* 'PRINTFOOTER' Routine */
      returnInSub = false ;
   }

   public void h7V0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               AV112PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV109DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV112PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV109DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+40) ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            AV107AppName = "DVelop Software Solutions" ;
            AV113Phone = "+1 550 8923" ;
            AV111Mail = "info@mail.com" ;
            AV115Website = "http://www.web.com" ;
            AV104AddressLine1 = "French Boulevard 2859" ;
            AV105AddressLine2 = "Downtown" ;
            AV106AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV107AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV114Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV113Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV111Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV115Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV104AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV105AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV106AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+128) ;
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
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

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV114Title = "" ;
      AV13FilterFullText = "" ;
      AV92TFProfesionalId_To_Description = "" ;
      AV27TFProfesionalTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFProfesionalTipoDocumento_SelsJson = "" ;
      AV28TFProfesionalTipoDocumento_Sel = "" ;
      AV26TFProfesionalTipoDocumento_SelDscs = "" ;
      AV93FilterTFProfesionalTipoDocumento_SelValueDescription = "" ;
      AV30TFProfesionalNroDocumento_Sel = "" ;
      AV29TFProfesionalNroDocumento = "" ;
      AV32TFProfesionalApellidoPaterno_Sel = "" ;
      AV31TFProfesionalApellidoPaterno = "" ;
      AV34TFProfesionalApellidoMaterno_Sel = "" ;
      AV33TFProfesionalApellidoMaterno = "" ;
      AV36TFProfesionalNombres_Sel = "" ;
      AV35TFProfesionalNombres = "" ;
      AV38TFProfesionalNombreCompleto2_Sel = "" ;
      AV37TFProfesionalNombreCompleto2 = "" ;
      AV39TFProfesionalFechaNacimiento = GXutil.nullDate() ;
      AV40TFProfesionalFechaNacimiento_To = GXutil.nullDate() ;
      AV94TFProfesionalFechaNacimiento_To_Description = "" ;
      AV43TFProfesionalSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFProfesionalSexo_SelsJson = "" ;
      AV44TFProfesionalSexo_Sel = "" ;
      AV42TFProfesionalSexo_SelDscs = "" ;
      AV95FilterTFProfesionalSexo_SelValueDescription = "" ;
      AV46TFProfesionalDescripcion_Sel = "" ;
      AV45TFProfesionalDescripcion = "" ;
      AV48TFProfesionalCorreo_Sel = "" ;
      AV47TFProfesionalCorreo = "" ;
      AV50TFProfesionalCOP_Sel = "" ;
      AV49TFProfesionalCOP = "" ;
      AV52TFProfesionalColorDisponible_Sel = "" ;
      AV51TFProfesionalColorDisponible = "" ;
      AV54TFProfesionalColorCita_Sel = "" ;
      AV53TFProfesionalColorCita = "" ;
      AV57TFProfesionalTiempoCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV55TFProfesionalTiempoCita_SelsJson = "" ;
      AV58TFProfesionalTiempoCita_Sel = (byte)(30) ;
      AV56TFProfesionalTiempoCita_SelDscs = "" ;
      AV96FilterTFProfesionalTiempoCita_SelValueDescription = "" ;
      AV60TFProfesionalDireccion_Sel = "" ;
      AV59TFProfesionalDireccion = "" ;
      AV97TFPaisId_To_Description = "" ;
      AV64TFPaisDescripcion_Sel = "" ;
      AV63TFPaisDescripcion = "" ;
      AV66TFUbigeoCode_Sel = "" ;
      AV65TFUbigeoCode = "" ;
      AV68TFUbigeoNombre_Sel = "" ;
      AV67TFUbigeoNombre = "" ;
      AV70TFProfesionalTwitter_Sel = "" ;
      AV69TFProfesionalTwitter = "" ;
      AV72TFProfesionalFacebook_Sel = "" ;
      AV71TFProfesionalFacebook = "" ;
      AV74TFProfesionalInstagram_Sel = "" ;
      AV73TFProfesionalInstagram = "" ;
      AV76TFProfesionalLinkedin_Sel = "" ;
      AV75TFProfesionalLinkedin = "" ;
      AV78TFProfesionalTelefono_Sel = "" ;
      AV77TFProfesionalTelefono = "" ;
      AV98TFSecUserId_To_Description = "" ;
      AV81TFProfesionalFechaRegistro = GXutil.nullDate() ;
      AV82TFProfesionalFechaRegistro_To = GXutil.nullDate() ;
      AV99TFProfesionalFechaRegistro_To_Description = "" ;
      AV100FilterTFProfesionalTerminosCondiciones_SelValueDescription = "" ;
      AV86TFProfesionalEstadoCuenta_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84TFProfesionalEstadoCuenta_SelsJson = "" ;
      AV87TFProfesionalEstadoCuenta_Sel = "" ;
      AV85TFProfesionalEstadoCuenta_SelDscs = "" ;
      AV101FilterTFProfesionalEstadoCuenta_SelValueDescription = "" ;
      AV90TFProfesionalEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88TFProfesionalEstado_SelsJson = "" ;
      AV91TFProfesionalEstado_Sel = "" ;
      AV89TFProfesionalEstado_SelDscs = "" ;
      AV102FilterTFProfesionalEstado_SelValueDescription = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A177ProfesionalSexo = "" ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A178ProfesionalDescripcion = "" ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A180ProfesionalColorDisponible = "" ;
      A181ProfesionalColorCita = "" ;
      A183ProfesionalDireccion = "" ;
      A184PaisDescripcion = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A189ProfesionalFoto = "" ;
      A40000ProfesionalFoto_GXI = "" ;
      A190ProfesionalTwitter = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A193ProfesionalLinkedin = "" ;
      A194ProfesionalTelefono = "" ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      AV126Wppacienteds_1_filterfulltext = "" ;
      AV129Wppacienteds_4_tfprofesionaltipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV130Wppacienteds_5_tfprofesionalnrodocumento = "" ;
      AV131Wppacienteds_6_tfprofesionalnrodocumento_sel = "" ;
      AV132Wppacienteds_7_tfprofesionalapellidopaterno = "" ;
      AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel = "" ;
      AV134Wppacienteds_9_tfprofesionalapellidomaterno = "" ;
      AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel = "" ;
      AV136Wppacienteds_11_tfprofesionalnombres = "" ;
      AV137Wppacienteds_12_tfprofesionalnombres_sel = "" ;
      AV138Wppacienteds_13_tfprofesionalnombrecompleto2 = "" ;
      AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel = "" ;
      AV140Wppacienteds_15_tfprofesionalfechanacimiento = GXutil.nullDate() ;
      AV141Wppacienteds_16_tfprofesionalfechanacimiento_to = GXutil.nullDate() ;
      AV142Wppacienteds_17_tfprofesionalsexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV143Wppacienteds_18_tfprofesionaldescripcion = "" ;
      AV144Wppacienteds_19_tfprofesionaldescripcion_sel = "" ;
      AV145Wppacienteds_20_tfprofesionalcorreo = "" ;
      AV146Wppacienteds_21_tfprofesionalcorreo_sel = "" ;
      AV147Wppacienteds_22_tfprofesionalcop = "" ;
      AV148Wppacienteds_23_tfprofesionalcop_sel = "" ;
      AV149Wppacienteds_24_tfprofesionalcolordisponible = "" ;
      AV150Wppacienteds_25_tfprofesionalcolordisponible_sel = "" ;
      AV151Wppacienteds_26_tfprofesionalcolorcita = "" ;
      AV152Wppacienteds_27_tfprofesionalcolorcita_sel = "" ;
      AV153Wppacienteds_28_tfprofesionaltiempocita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV154Wppacienteds_29_tfprofesionaldireccion = "" ;
      AV155Wppacienteds_30_tfprofesionaldireccion_sel = "" ;
      AV158Wppacienteds_33_tfpaisdescripcion = "" ;
      AV159Wppacienteds_34_tfpaisdescripcion_sel = "" ;
      AV160Wppacienteds_35_tfubigeocode = "" ;
      AV161Wppacienteds_36_tfubigeocode_sel = "" ;
      AV162Wppacienteds_37_tfubigeonombre = "" ;
      AV163Wppacienteds_38_tfubigeonombre_sel = "" ;
      AV164Wppacienteds_39_tfprofesionaltwitter = "" ;
      AV165Wppacienteds_40_tfprofesionaltwitter_sel = "" ;
      AV166Wppacienteds_41_tfprofesionalfacebook = "" ;
      AV167Wppacienteds_42_tfprofesionalfacebook_sel = "" ;
      AV168Wppacienteds_43_tfprofesionalinstagram = "" ;
      AV169Wppacienteds_44_tfprofesionalinstagram_sel = "" ;
      AV170Wppacienteds_45_tfprofesionallinkedin = "" ;
      AV171Wppacienteds_46_tfprofesionallinkedin_sel = "" ;
      AV172Wppacienteds_47_tfprofesionaltelefono = "" ;
      AV173Wppacienteds_48_tfprofesionaltelefono_sel = "" ;
      AV176Wppacienteds_51_tfprofesionalfecharegistro = GXutil.nullDate() ;
      AV177Wppacienteds_52_tfprofesionalfecharegistro_to = GXutil.nullDate() ;
      AV179Wppacienteds_54_tfprofesionalestadocuenta_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV180Wppacienteds_55_tfprofesionalestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV126Wppacienteds_1_filterfulltext = "" ;
      lV130Wppacienteds_5_tfprofesionalnrodocumento = "" ;
      lV132Wppacienteds_7_tfprofesionalapellidopaterno = "" ;
      lV134Wppacienteds_9_tfprofesionalapellidomaterno = "" ;
      lV136Wppacienteds_11_tfprofesionalnombres = "" ;
      lV138Wppacienteds_13_tfprofesionalnombrecompleto2 = "" ;
      lV143Wppacienteds_18_tfprofesionaldescripcion = "" ;
      lV145Wppacienteds_20_tfprofesionalcorreo = "" ;
      lV147Wppacienteds_22_tfprofesionalcop = "" ;
      lV149Wppacienteds_24_tfprofesionalcolordisponible = "" ;
      lV151Wppacienteds_26_tfprofesionalcolorcita = "" ;
      lV154Wppacienteds_29_tfprofesionaldireccion = "" ;
      lV158Wppacienteds_33_tfpaisdescripcion = "" ;
      lV160Wppacienteds_35_tfubigeocode = "" ;
      lV162Wppacienteds_37_tfubigeonombre = "" ;
      lV164Wppacienteds_39_tfprofesionaltwitter = "" ;
      lV166Wppacienteds_41_tfprofesionalfacebook = "" ;
      lV168Wppacienteds_43_tfprofesionalinstagram = "" ;
      lV170Wppacienteds_45_tfprofesionallinkedin = "" ;
      lV172Wppacienteds_47_tfprofesionaltelefono = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P007V2_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      P007V2_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P007V2_A6SecUserId = new short[1] ;
      P007V2_A43PaisId = new short[1] ;
      P007V2_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P007V2_A31ProfesionalId = new int[1] ;
      P007V2_A198ProfesionalEstado = new String[] {""} ;
      P007V2_A197ProfesionalEstadoCuenta = new String[] {""} ;
      P007V2_A194ProfesionalTelefono = new String[] {""} ;
      P007V2_A193ProfesionalLinkedin = new String[] {""} ;
      P007V2_A192ProfesionalInstagram = new String[] {""} ;
      P007V2_A191ProfesionalFacebook = new String[] {""} ;
      P007V2_A190ProfesionalTwitter = new String[] {""} ;
      P007V2_A44UbigeoCode = new String[] {""} ;
      P007V2_A184PaisDescripcion = new String[] {""} ;
      P007V2_A183ProfesionalDireccion = new String[] {""} ;
      P007V2_A182ProfesionalTiempoCita = new byte[1] ;
      P007V2_A181ProfesionalColorCita = new String[] {""} ;
      P007V2_A180ProfesionalColorDisponible = new String[] {""} ;
      P007V2_A88ProfesionalCOP = new String[] {""} ;
      P007V2_A179ProfesionalCorreo = new String[] {""} ;
      P007V2_A178ProfesionalDescripcion = new String[] {""} ;
      P007V2_A177ProfesionalSexo = new String[] {""} ;
      P007V2_A174ProfesionalNroDocumento = new String[] {""} ;
      P007V2_A173ProfesionalTipoDocumento = new String[] {""} ;
      P007V2_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P007V2_A189ProfesionalFoto = new String[] {""} ;
      P007V2_A84ProfesionalNombres = new String[] {""} ;
      P007V2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P007V2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P007V2_A188UbigeoDistrito = new String[] {""} ;
      P007V2_A187UbigeoProvincia = new String[] {""} ;
      P007V2_A186UbigeoDepartamento = new String[] {""} ;
      AV14ProfesionalTipoDocumentoDescription = "" ;
      AV15ProfesionalSexoDescription = "" ;
      AV16ProfesionalTiempoCitaDescription = "" ;
      AV17ProfesionalEstadoCuentaDescription = "" ;
      AV18ProfesionalEstadoDescription = "" ;
      sImgUrl = "" ;
      AV19Session = httpContext.getWebSession();
      AV21GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV22GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV112PageInfo = "" ;
      AV109DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV107AppName = "" ;
      AV113Phone = "" ;
      AV111Mail = "" ;
      AV115Website = "" ;
      AV104AddressLine1 = "" ;
      AV105AddressLine2 = "" ;
      AV106AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wppacienteexportreport__default(),
         new Object[] {
             new Object[] {
            P007V2_A196ProfesionalTerminosCondiciones, P007V2_A195ProfesionalFechaRegistro, P007V2_A6SecUserId, P007V2_A43PaisId, P007V2_A176ProfesionalFechaNacimiento, P007V2_A31ProfesionalId, P007V2_A198ProfesionalEstado, P007V2_A197ProfesionalEstadoCuenta, P007V2_A194ProfesionalTelefono, P007V2_A193ProfesionalLinkedin,
            P007V2_A192ProfesionalInstagram, P007V2_A191ProfesionalFacebook, P007V2_A190ProfesionalTwitter, P007V2_A44UbigeoCode, P007V2_A184PaisDescripcion, P007V2_A183ProfesionalDireccion, P007V2_A182ProfesionalTiempoCita, P007V2_A181ProfesionalColorCita, P007V2_A180ProfesionalColorDisponible, P007V2_A88ProfesionalCOP,
            P007V2_A179ProfesionalCorreo, P007V2_A178ProfesionalDescripcion, P007V2_A177ProfesionalSexo, P007V2_A174ProfesionalNroDocumento, P007V2_A173ProfesionalTipoDocumento, P007V2_A40000ProfesionalFoto_GXI, P007V2_A189ProfesionalFoto, P007V2_A84ProfesionalNombres, P007V2_A86ProfesionalApellidoMaterno, P007V2_A85ProfesionalApellidoPaterno,
            P007V2_A188UbigeoDistrito, P007V2_A187UbigeoProvincia, P007V2_A186UbigeoDepartamento
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private byte AV58TFProfesionalTiempoCita_Sel ;
   private byte AV83TFProfesionalTerminosCondiciones_Sel ;
   private byte A182ProfesionalTiempoCita ;
   private byte AV178Wppacienteds_53_tfprofesionalterminoscondiciones_sel ;
   private short gxcookieaux ;
   private short AV61TFPaisId ;
   private short AV62TFPaisId_To ;
   private short AV79TFSecUserId ;
   private short AV80TFSecUserId_To ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short AV156Wppacienteds_31_tfpaisid ;
   private short AV157Wppacienteds_32_tfpaisid_to ;
   private short AV174Wppacienteds_49_tfsecuserid ;
   private short AV175Wppacienteds_50_tfsecuserid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV23TFProfesionalId ;
   private int AV24TFProfesionalId_To ;
   private int AV120GXV1 ;
   private int AV121GXV2 ;
   private int AV122GXV3 ;
   private int AV123GXV4 ;
   private int AV124GXV5 ;
   private int A31ProfesionalId ;
   private int AV127Wppacienteds_2_tfprofesionalid ;
   private int AV128Wppacienteds_3_tfprofesionalid_to ;
   private int AV129Wppacienteds_4_tfprofesionaltipodocumento_sels_size ;
   private int AV142Wppacienteds_17_tfprofesionalsexo_sels_size ;
   private int AV153Wppacienteds_28_tfprofesionaltiempocita_sels_size ;
   private int AV179Wppacienteds_54_tfprofesionalestadocuenta_sels_size ;
   private int AV180Wppacienteds_55_tfprofesionalestado_sels_size ;
   private int AV181GXV6 ;
   private long AV103i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV28TFProfesionalTipoDocumento_Sel ;
   private String AV44TFProfesionalSexo_Sel ;
   private String AV52TFProfesionalColorDisponible_Sel ;
   private String AV51TFProfesionalColorDisponible ;
   private String AV54TFProfesionalColorCita_Sel ;
   private String AV53TFProfesionalColorCita ;
   private String AV66TFUbigeoCode_Sel ;
   private String AV65TFUbigeoCode ;
   private String AV78TFProfesionalTelefono_Sel ;
   private String AV77TFProfesionalTelefono ;
   private String AV87TFProfesionalEstadoCuenta_Sel ;
   private String AV91TFProfesionalEstado_Sel ;
   private String A173ProfesionalTipoDocumento ;
   private String A177ProfesionalSexo ;
   private String A197ProfesionalEstadoCuenta ;
   private String A198ProfesionalEstado ;
   private String A180ProfesionalColorDisponible ;
   private String A181ProfesionalColorCita ;
   private String A44UbigeoCode ;
   private String A194ProfesionalTelefono ;
   private String AV149Wppacienteds_24_tfprofesionalcolordisponible ;
   private String AV150Wppacienteds_25_tfprofesionalcolordisponible_sel ;
   private String AV151Wppacienteds_26_tfprofesionalcolorcita ;
   private String AV152Wppacienteds_27_tfprofesionalcolorcita_sel ;
   private String AV160Wppacienteds_35_tfubigeocode ;
   private String AV161Wppacienteds_36_tfubigeocode_sel ;
   private String AV172Wppacienteds_47_tfprofesionaltelefono ;
   private String AV173Wppacienteds_48_tfprofesionaltelefono_sel ;
   private String scmdbuf ;
   private String lV149Wppacienteds_24_tfprofesionalcolordisponible ;
   private String lV151Wppacienteds_26_tfprofesionalcolorcita ;
   private String lV160Wppacienteds_35_tfubigeocode ;
   private String lV172Wppacienteds_47_tfprofesionaltelefono ;
   private String sImgUrl ;
   private java.util.Date AV39TFProfesionalFechaNacimiento ;
   private java.util.Date AV40TFProfesionalFechaNacimiento_To ;
   private java.util.Date AV81TFProfesionalFechaRegistro ;
   private java.util.Date AV82TFProfesionalFechaRegistro_To ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private java.util.Date AV140Wppacienteds_15_tfprofesionalfechanacimiento ;
   private java.util.Date AV141Wppacienteds_16_tfprofesionalfechanacimiento_to ;
   private java.util.Date AV176Wppacienteds_51_tfprofesionalfecharegistro ;
   private java.util.Date AV177Wppacienteds_52_tfprofesionalfecharegistro_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean returnInSub ;
   private boolean A196ProfesionalTerminosCondiciones ;
   private boolean AV12OrderedDsc ;
   private String AV25TFProfesionalTipoDocumento_SelsJson ;
   private String AV41TFProfesionalSexo_SelsJson ;
   private String AV55TFProfesionalTiempoCita_SelsJson ;
   private String AV84TFProfesionalEstadoCuenta_SelsJson ;
   private String AV88TFProfesionalEstado_SelsJson ;
   private String AV114Title ;
   private String AV13FilterFullText ;
   private String AV92TFProfesionalId_To_Description ;
   private String AV26TFProfesionalTipoDocumento_SelDscs ;
   private String AV93FilterTFProfesionalTipoDocumento_SelValueDescription ;
   private String AV30TFProfesionalNroDocumento_Sel ;
   private String AV29TFProfesionalNroDocumento ;
   private String AV32TFProfesionalApellidoPaterno_Sel ;
   private String AV31TFProfesionalApellidoPaterno ;
   private String AV34TFProfesionalApellidoMaterno_Sel ;
   private String AV33TFProfesionalApellidoMaterno ;
   private String AV36TFProfesionalNombres_Sel ;
   private String AV35TFProfesionalNombres ;
   private String AV38TFProfesionalNombreCompleto2_Sel ;
   private String AV37TFProfesionalNombreCompleto2 ;
   private String AV94TFProfesionalFechaNacimiento_To_Description ;
   private String AV42TFProfesionalSexo_SelDscs ;
   private String AV95FilterTFProfesionalSexo_SelValueDescription ;
   private String AV46TFProfesionalDescripcion_Sel ;
   private String AV45TFProfesionalDescripcion ;
   private String AV48TFProfesionalCorreo_Sel ;
   private String AV47TFProfesionalCorreo ;
   private String AV50TFProfesionalCOP_Sel ;
   private String AV49TFProfesionalCOP ;
   private String AV56TFProfesionalTiempoCita_SelDscs ;
   private String AV96FilterTFProfesionalTiempoCita_SelValueDescription ;
   private String AV60TFProfesionalDireccion_Sel ;
   private String AV59TFProfesionalDireccion ;
   private String AV97TFPaisId_To_Description ;
   private String AV64TFPaisDescripcion_Sel ;
   private String AV63TFPaisDescripcion ;
   private String AV68TFUbigeoNombre_Sel ;
   private String AV67TFUbigeoNombre ;
   private String AV70TFProfesionalTwitter_Sel ;
   private String AV69TFProfesionalTwitter ;
   private String AV72TFProfesionalFacebook_Sel ;
   private String AV71TFProfesionalFacebook ;
   private String AV74TFProfesionalInstagram_Sel ;
   private String AV73TFProfesionalInstagram ;
   private String AV76TFProfesionalLinkedin_Sel ;
   private String AV75TFProfesionalLinkedin ;
   private String AV98TFSecUserId_To_Description ;
   private String AV99TFProfesionalFechaRegistro_To_Description ;
   private String AV100FilterTFProfesionalTerminosCondiciones_SelValueDescription ;
   private String AV85TFProfesionalEstadoCuenta_SelDscs ;
   private String AV101FilterTFProfesionalEstadoCuenta_SelValueDescription ;
   private String AV89TFProfesionalEstado_SelDscs ;
   private String AV102FilterTFProfesionalEstado_SelValueDescription ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A178ProfesionalDescripcion ;
   private String A179ProfesionalCorreo ;
   private String A88ProfesionalCOP ;
   private String A183ProfesionalDireccion ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A40000ProfesionalFoto_GXI ;
   private String A190ProfesionalTwitter ;
   private String A191ProfesionalFacebook ;
   private String A192ProfesionalInstagram ;
   private String A193ProfesionalLinkedin ;
   private String AV126Wppacienteds_1_filterfulltext ;
   private String AV130Wppacienteds_5_tfprofesionalnrodocumento ;
   private String AV131Wppacienteds_6_tfprofesionalnrodocumento_sel ;
   private String AV132Wppacienteds_7_tfprofesionalapellidopaterno ;
   private String AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel ;
   private String AV134Wppacienteds_9_tfprofesionalapellidomaterno ;
   private String AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel ;
   private String AV136Wppacienteds_11_tfprofesionalnombres ;
   private String AV137Wppacienteds_12_tfprofesionalnombres_sel ;
   private String AV138Wppacienteds_13_tfprofesionalnombrecompleto2 ;
   private String AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel ;
   private String AV143Wppacienteds_18_tfprofesionaldescripcion ;
   private String AV144Wppacienteds_19_tfprofesionaldescripcion_sel ;
   private String AV145Wppacienteds_20_tfprofesionalcorreo ;
   private String AV146Wppacienteds_21_tfprofesionalcorreo_sel ;
   private String AV147Wppacienteds_22_tfprofesionalcop ;
   private String AV148Wppacienteds_23_tfprofesionalcop_sel ;
   private String AV154Wppacienteds_29_tfprofesionaldireccion ;
   private String AV155Wppacienteds_30_tfprofesionaldireccion_sel ;
   private String AV158Wppacienteds_33_tfpaisdescripcion ;
   private String AV159Wppacienteds_34_tfpaisdescripcion_sel ;
   private String AV162Wppacienteds_37_tfubigeonombre ;
   private String AV163Wppacienteds_38_tfubigeonombre_sel ;
   private String AV164Wppacienteds_39_tfprofesionaltwitter ;
   private String AV165Wppacienteds_40_tfprofesionaltwitter_sel ;
   private String AV166Wppacienteds_41_tfprofesionalfacebook ;
   private String AV167Wppacienteds_42_tfprofesionalfacebook_sel ;
   private String AV168Wppacienteds_43_tfprofesionalinstagram ;
   private String AV169Wppacienteds_44_tfprofesionalinstagram_sel ;
   private String AV170Wppacienteds_45_tfprofesionallinkedin ;
   private String AV171Wppacienteds_46_tfprofesionallinkedin_sel ;
   private String lV126Wppacienteds_1_filterfulltext ;
   private String lV130Wppacienteds_5_tfprofesionalnrodocumento ;
   private String lV132Wppacienteds_7_tfprofesionalapellidopaterno ;
   private String lV134Wppacienteds_9_tfprofesionalapellidomaterno ;
   private String lV136Wppacienteds_11_tfprofesionalnombres ;
   private String lV138Wppacienteds_13_tfprofesionalnombrecompleto2 ;
   private String lV143Wppacienteds_18_tfprofesionaldescripcion ;
   private String lV145Wppacienteds_20_tfprofesionalcorreo ;
   private String lV147Wppacienteds_22_tfprofesionalcop ;
   private String lV154Wppacienteds_29_tfprofesionaldireccion ;
   private String lV158Wppacienteds_33_tfpaisdescripcion ;
   private String lV162Wppacienteds_37_tfubigeonombre ;
   private String lV164Wppacienteds_39_tfprofesionaltwitter ;
   private String lV166Wppacienteds_41_tfprofesionalfacebook ;
   private String lV168Wppacienteds_43_tfprofesionalinstagram ;
   private String lV170Wppacienteds_45_tfprofesionallinkedin ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String AV14ProfesionalTipoDocumentoDescription ;
   private String AV15ProfesionalSexoDescription ;
   private String AV16ProfesionalTiempoCitaDescription ;
   private String AV17ProfesionalEstadoCuentaDescription ;
   private String AV18ProfesionalEstadoDescription ;
   private String AV112PageInfo ;
   private String AV109DateInfo ;
   private String AV107AppName ;
   private String AV113Phone ;
   private String AV111Mail ;
   private String AV115Website ;
   private String AV104AddressLine1 ;
   private String AV105AddressLine2 ;
   private String AV106AddressLine3 ;
   private String A189ProfesionalFoto ;
   private GXSimpleCollection<Byte> AV57TFProfesionalTiempoCita_Sels ;
   private GXSimpleCollection<Byte> AV153Wppacienteds_28_tfprofesionaltiempocita_sels ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private IDataStoreProvider pr_default ;
   private boolean[] P007V2_A196ProfesionalTerminosCondiciones ;
   private java.util.Date[] P007V2_A195ProfesionalFechaRegistro ;
   private short[] P007V2_A6SecUserId ;
   private short[] P007V2_A43PaisId ;
   private java.util.Date[] P007V2_A176ProfesionalFechaNacimiento ;
   private int[] P007V2_A31ProfesionalId ;
   private String[] P007V2_A198ProfesionalEstado ;
   private String[] P007V2_A197ProfesionalEstadoCuenta ;
   private String[] P007V2_A194ProfesionalTelefono ;
   private String[] P007V2_A193ProfesionalLinkedin ;
   private String[] P007V2_A192ProfesionalInstagram ;
   private String[] P007V2_A191ProfesionalFacebook ;
   private String[] P007V2_A190ProfesionalTwitter ;
   private String[] P007V2_A44UbigeoCode ;
   private String[] P007V2_A184PaisDescripcion ;
   private String[] P007V2_A183ProfesionalDireccion ;
   private byte[] P007V2_A182ProfesionalTiempoCita ;
   private String[] P007V2_A181ProfesionalColorCita ;
   private String[] P007V2_A180ProfesionalColorDisponible ;
   private String[] P007V2_A88ProfesionalCOP ;
   private String[] P007V2_A179ProfesionalCorreo ;
   private String[] P007V2_A178ProfesionalDescripcion ;
   private String[] P007V2_A177ProfesionalSexo ;
   private String[] P007V2_A174ProfesionalNroDocumento ;
   private String[] P007V2_A173ProfesionalTipoDocumento ;
   private String[] P007V2_A40000ProfesionalFoto_GXI ;
   private String[] P007V2_A189ProfesionalFoto ;
   private String[] P007V2_A84ProfesionalNombres ;
   private String[] P007V2_A86ProfesionalApellidoMaterno ;
   private String[] P007V2_A85ProfesionalApellidoPaterno ;
   private String[] P007V2_A188UbigeoDistrito ;
   private String[] P007V2_A187UbigeoProvincia ;
   private String[] P007V2_A186UbigeoDepartamento ;
   private GXSimpleCollection<String> AV27TFProfesionalTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV43TFProfesionalSexo_Sels ;
   private GXSimpleCollection<String> AV86TFProfesionalEstadoCuenta_Sels ;
   private GXSimpleCollection<String> AV90TFProfesionalEstado_Sels ;
   private GXSimpleCollection<String> AV129Wppacienteds_4_tfprofesionaltipodocumento_sels ;
   private GXSimpleCollection<String> AV142Wppacienteds_17_tfprofesionalsexo_sels ;
   private GXSimpleCollection<String> AV179Wppacienteds_54_tfprofesionalestadocuenta_sels ;
   private GXSimpleCollection<String> AV180Wppacienteds_55_tfprofesionalestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV21GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV22GridStateFilterValue ;
}

final  class wppacienteexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A173ProfesionalTipoDocumento ,
                                          GXSimpleCollection<String> AV129Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                          String A177ProfesionalSexo ,
                                          GXSimpleCollection<String> AV142Wppacienteds_17_tfprofesionalsexo_sels ,
                                          byte A182ProfesionalTiempoCita ,
                                          GXSimpleCollection<Byte> AV153Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                          String A197ProfesionalEstadoCuenta ,
                                          GXSimpleCollection<String> AV179Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                          String A198ProfesionalEstado ,
                                          GXSimpleCollection<String> AV180Wppacienteds_55_tfprofesionalestado_sels ,
                                          String AV126Wppacienteds_1_filterfulltext ,
                                          int AV127Wppacienteds_2_tfprofesionalid ,
                                          int AV128Wppacienteds_3_tfprofesionalid_to ,
                                          int AV129Wppacienteds_4_tfprofesionaltipodocumento_sels_size ,
                                          String AV131Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                          String AV130Wppacienteds_5_tfprofesionalnrodocumento ,
                                          String AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                          String AV132Wppacienteds_7_tfprofesionalapellidopaterno ,
                                          String AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                          String AV134Wppacienteds_9_tfprofesionalapellidomaterno ,
                                          String AV137Wppacienteds_12_tfprofesionalnombres_sel ,
                                          String AV136Wppacienteds_11_tfprofesionalnombres ,
                                          String AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                          String AV138Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                          java.util.Date AV140Wppacienteds_15_tfprofesionalfechanacimiento ,
                                          java.util.Date AV141Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                          int AV142Wppacienteds_17_tfprofesionalsexo_sels_size ,
                                          String AV144Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                          String AV143Wppacienteds_18_tfprofesionaldescripcion ,
                                          String AV146Wppacienteds_21_tfprofesionalcorreo_sel ,
                                          String AV145Wppacienteds_20_tfprofesionalcorreo ,
                                          String AV148Wppacienteds_23_tfprofesionalcop_sel ,
                                          String AV147Wppacienteds_22_tfprofesionalcop ,
                                          String AV150Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                          String AV149Wppacienteds_24_tfprofesionalcolordisponible ,
                                          String AV152Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                          String AV151Wppacienteds_26_tfprofesionalcolorcita ,
                                          int AV153Wppacienteds_28_tfprofesionaltiempocita_sels_size ,
                                          String AV155Wppacienteds_30_tfprofesionaldireccion_sel ,
                                          String AV154Wppacienteds_29_tfprofesionaldireccion ,
                                          short AV156Wppacienteds_31_tfpaisid ,
                                          short AV157Wppacienteds_32_tfpaisid_to ,
                                          String AV159Wppacienteds_34_tfpaisdescripcion_sel ,
                                          String AV158Wppacienteds_33_tfpaisdescripcion ,
                                          String AV161Wppacienteds_36_tfubigeocode_sel ,
                                          String AV160Wppacienteds_35_tfubigeocode ,
                                          String AV163Wppacienteds_38_tfubigeonombre_sel ,
                                          String AV162Wppacienteds_37_tfubigeonombre ,
                                          String AV165Wppacienteds_40_tfprofesionaltwitter_sel ,
                                          String AV164Wppacienteds_39_tfprofesionaltwitter ,
                                          String AV167Wppacienteds_42_tfprofesionalfacebook_sel ,
                                          String AV166Wppacienteds_41_tfprofesionalfacebook ,
                                          String AV169Wppacienteds_44_tfprofesionalinstagram_sel ,
                                          String AV168Wppacienteds_43_tfprofesionalinstagram ,
                                          String AV171Wppacienteds_46_tfprofesionallinkedin_sel ,
                                          String AV170Wppacienteds_45_tfprofesionallinkedin ,
                                          String AV173Wppacienteds_48_tfprofesionaltelefono_sel ,
                                          String AV172Wppacienteds_47_tfprofesionaltelefono ,
                                          short AV174Wppacienteds_49_tfsecuserid ,
                                          short AV175Wppacienteds_50_tfsecuserid_to ,
                                          java.util.Date AV176Wppacienteds_51_tfprofesionalfecharegistro ,
                                          java.util.Date AV177Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                          byte AV178Wppacienteds_53_tfprofesionalterminoscondiciones_sel ,
                                          int AV179Wppacienteds_54_tfprofesionalestadocuenta_sels_size ,
                                          int AV180Wppacienteds_55_tfprofesionalestado_sels_size ,
                                          int A31ProfesionalId ,
                                          String A174ProfesionalNroDocumento ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A178ProfesionalDescripcion ,
                                          String A179ProfesionalCorreo ,
                                          String A88ProfesionalCOP ,
                                          String A180ProfesionalColorDisponible ,
                                          String A181ProfesionalColorCita ,
                                          String A183ProfesionalDireccion ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A190ProfesionalTwitter ,
                                          String A191ProfesionalFacebook ,
                                          String A192ProfesionalInstagram ,
                                          String A193ProfesionalLinkedin ,
                                          String A194ProfesionalTelefono ,
                                          short A6SecUserId ,
                                          java.util.Date A176ProfesionalFechaNacimiento ,
                                          java.util.Date A195ProfesionalFechaRegistro ,
                                          boolean A196ProfesionalTerminosCondiciones ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[85];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT T1.[ProfesionalTerminosCondiciones], T1.[ProfesionalFechaRegistro], T1.[SecUserId], T1.[PaisId], T1.[ProfesionalFechaNacimiento], T1.[ProfesionalId], T1.[ProfesionalEstado]," ;
      scmdbuf += " T1.[ProfesionalEstadoCuenta], T1.[ProfesionalTelefono], T1.[ProfesionalLinkedin], T1.[ProfesionalInstagram], T1.[ProfesionalFacebook], T1.[ProfesionalTwitter]," ;
      scmdbuf += " T1.[UbigeoCode], T2.[PaisDescripcion], T1.[ProfesionalDireccion], T1.[ProfesionalTiempoCita], T1.[ProfesionalColorCita], T1.[ProfesionalColorDisponible], T1.[ProfesionalCOP]," ;
      scmdbuf += " T1.[ProfesionalCorreo], T1.[ProfesionalDescripcion], T1.[ProfesionalSexo], T1.[ProfesionalNroDocumento], T1.[ProfesionalTipoDocumento], T1.[ProfesionalFoto_GXI]," ;
      scmdbuf += " T1.[ProfesionalFoto], T1.[ProfesionalNombres], T1.[ProfesionalApellidoMaterno], T1.[ProfesionalApellidoPaterno], T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento]" ;
      scmdbuf += " FROM (([Profesional] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV126Wppacienteds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '0') or ( T1.[ProfesionalNroDocumento] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] like '%' + ?) or ( T1.[ProfesionalApellidoMaterno] like '%' + ?) or ( T1.[ProfesionalNombres] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'F') or ( T1.[ProfesionalDescripcion] like '%' + ?) or ( T1.[ProfesionalCorreo] like '%' + ?) or ( T1.[ProfesionalCOP] like '%' + ?) or ( T1.[ProfesionalColorDisponible] like '%' + ?) or ( T1.[ProfesionalColorCita] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 30) or ( '1 hora' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 60) or ( T1.[ProfesionalDireccion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[ProfesionalTwitter] like '%' + ?) or ( T1.[ProfesionalFacebook] like '%' + ?) or ( T1.[ProfesionalInstagram] like '%' + ?) or ( T1.[ProfesionalLinkedin] like '%' + ?) or ( T1.[ProfesionalTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( 'cuenta verificada' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CV') or ( 'cuenta por verificar' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CP') or ( 'activo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'I'))");
      }
      else
      {
         GXv_int2[0] = (byte)(1) ;
         GXv_int2[1] = (byte)(1) ;
         GXv_int2[2] = (byte)(1) ;
         GXv_int2[3] = (byte)(1) ;
         GXv_int2[4] = (byte)(1) ;
         GXv_int2[5] = (byte)(1) ;
         GXv_int2[6] = (byte)(1) ;
         GXv_int2[7] = (byte)(1) ;
         GXv_int2[8] = (byte)(1) ;
         GXv_int2[9] = (byte)(1) ;
         GXv_int2[10] = (byte)(1) ;
         GXv_int2[11] = (byte)(1) ;
         GXv_int2[12] = (byte)(1) ;
         GXv_int2[13] = (byte)(1) ;
         GXv_int2[14] = (byte)(1) ;
         GXv_int2[15] = (byte)(1) ;
         GXv_int2[16] = (byte)(1) ;
         GXv_int2[17] = (byte)(1) ;
         GXv_int2[18] = (byte)(1) ;
         GXv_int2[19] = (byte)(1) ;
         GXv_int2[20] = (byte)(1) ;
         GXv_int2[21] = (byte)(1) ;
         GXv_int2[22] = (byte)(1) ;
         GXv_int2[23] = (byte)(1) ;
         GXv_int2[24] = (byte)(1) ;
         GXv_int2[25] = (byte)(1) ;
         GXv_int2[26] = (byte)(1) ;
         GXv_int2[27] = (byte)(1) ;
         GXv_int2[28] = (byte)(1) ;
         GXv_int2[29] = (byte)(1) ;
         GXv_int2[30] = (byte)(1) ;
         GXv_int2[31] = (byte)(1) ;
         GXv_int2[32] = (byte)(1) ;
         GXv_int2[33] = (byte)(1) ;
         GXv_int2[34] = (byte)(1) ;
         GXv_int2[35] = (byte)(1) ;
         GXv_int2[36] = (byte)(1) ;
      }
      if ( ! (0==AV127Wppacienteds_2_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int2[37] = (byte)(1) ;
      }
      if ( ! (0==AV128Wppacienteds_3_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int2[38] = (byte)(1) ;
      }
      if ( AV129Wppacienteds_4_tfprofesionaltipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV129Wppacienteds_4_tfprofesionaltipodocumento_sels, "T1.[ProfesionalTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV131Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV130Wppacienteds_5_tfprofesionalnrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] like ?)");
      }
      else
      {
         GXv_int2[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] = ?)");
      }
      else
      {
         GXv_int2[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV132Wppacienteds_7_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int2[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int2[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV134Wppacienteds_9_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int2[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int2[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV137Wppacienteds_12_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV136Wppacienteds_11_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int2[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV137Wppacienteds_12_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int2[46] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) && ( ! (GXutil.strcmp("", AV138Wppacienteds_13_tfprofesionalnombrecompleto2)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int2[47] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV139Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int2[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV140Wppacienteds_15_tfprofesionalfechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int2[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV141Wppacienteds_16_tfprofesionalfechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int2[50] = (byte)(1) ;
      }
      if ( AV142Wppacienteds_17_tfprofesionalsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV142Wppacienteds_17_tfprofesionalsexo_sels, "T1.[ProfesionalSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV144Wppacienteds_19_tfprofesionaldescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV143Wppacienteds_18_tfprofesionaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] like ?)");
      }
      else
      {
         GXv_int2[51] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Wppacienteds_19_tfprofesionaldescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] = ?)");
      }
      else
      {
         GXv_int2[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV146Wppacienteds_21_tfprofesionalcorreo_sel)==0) && ( ! (GXutil.strcmp("", AV145Wppacienteds_20_tfprofesionalcorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] like ?)");
      }
      else
      {
         GXv_int2[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV146Wppacienteds_21_tfprofesionalcorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] = ?)");
      }
      else
      {
         GXv_int2[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Wppacienteds_23_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV147Wppacienteds_22_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int2[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Wppacienteds_23_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int2[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV150Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) && ( ! (GXutil.strcmp("", AV149Wppacienteds_24_tfprofesionalcolordisponible)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] like ?)");
      }
      else
      {
         GXv_int2[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV150Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] = ?)");
      }
      else
      {
         GXv_int2[58] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Wppacienteds_27_tfprofesionalcolorcita_sel)==0) && ( ! (GXutil.strcmp("", AV151Wppacienteds_26_tfprofesionalcolorcita)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] like ?)");
      }
      else
      {
         GXv_int2[59] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Wppacienteds_27_tfprofesionalcolorcita_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] = ?)");
      }
      else
      {
         GXv_int2[60] = (byte)(1) ;
      }
      if ( AV153Wppacienteds_28_tfprofesionaltiempocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV153Wppacienteds_28_tfprofesionaltiempocita_sels, "T1.[ProfesionalTiempoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV155Wppacienteds_30_tfprofesionaldireccion_sel)==0) && ( ! (GXutil.strcmp("", AV154Wppacienteds_29_tfprofesionaldireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] like ?)");
      }
      else
      {
         GXv_int2[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV155Wppacienteds_30_tfprofesionaldireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] = ?)");
      }
      else
      {
         GXv_int2[62] = (byte)(1) ;
      }
      if ( ! (0==AV156Wppacienteds_31_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int2[63] = (byte)(1) ;
      }
      if ( ! (0==AV157Wppacienteds_32_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int2[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV159Wppacienteds_34_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV158Wppacienteds_33_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int2[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV159Wppacienteds_34_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int2[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV161Wppacienteds_36_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV160Wppacienteds_35_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int2[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV161Wppacienteds_36_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int2[68] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV163Wppacienteds_38_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV162Wppacienteds_37_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int2[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV163Wppacienteds_38_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int2[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV165Wppacienteds_40_tfprofesionaltwitter_sel)==0) && ( ! (GXutil.strcmp("", AV164Wppacienteds_39_tfprofesionaltwitter)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] like ?)");
      }
      else
      {
         GXv_int2[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV165Wppacienteds_40_tfprofesionaltwitter_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] = ?)");
      }
      else
      {
         GXv_int2[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV167Wppacienteds_42_tfprofesionalfacebook_sel)==0) && ( ! (GXutil.strcmp("", AV166Wppacienteds_41_tfprofesionalfacebook)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] like ?)");
      }
      else
      {
         GXv_int2[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV167Wppacienteds_42_tfprofesionalfacebook_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] = ?)");
      }
      else
      {
         GXv_int2[74] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV169Wppacienteds_44_tfprofesionalinstagram_sel)==0) && ( ! (GXutil.strcmp("", AV168Wppacienteds_43_tfprofesionalinstagram)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] like ?)");
      }
      else
      {
         GXv_int2[75] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV169Wppacienteds_44_tfprofesionalinstagram_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] = ?)");
      }
      else
      {
         GXv_int2[76] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV171Wppacienteds_46_tfprofesionallinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV170Wppacienteds_45_tfprofesionallinkedin)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] like ?)");
      }
      else
      {
         GXv_int2[77] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV171Wppacienteds_46_tfprofesionallinkedin_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] = ?)");
      }
      else
      {
         GXv_int2[78] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV173Wppacienteds_48_tfprofesionaltelefono_sel)==0) && ( ! (GXutil.strcmp("", AV172Wppacienteds_47_tfprofesionaltelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] like ?)");
      }
      else
      {
         GXv_int2[79] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV173Wppacienteds_48_tfprofesionaltelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] = ?)");
      }
      else
      {
         GXv_int2[80] = (byte)(1) ;
      }
      if ( ! (0==AV174Wppacienteds_49_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int2[81] = (byte)(1) ;
      }
      if ( ! (0==AV175Wppacienteds_50_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int2[82] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV176Wppacienteds_51_tfprofesionalfecharegistro)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int2[83] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV177Wppacienteds_52_tfprofesionalfecharegistro_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int2[84] = (byte)(1) ;
      }
      if ( AV178Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 1 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 1)");
      }
      if ( AV178Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 2 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 0)");
      }
      if ( AV179Wppacienteds_54_tfprofesionalestadocuenta_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV179Wppacienteds_54_tfprofesionalestadocuenta_sels, "T1.[ProfesionalEstadoCuenta] IN (", ")")+")");
      }
      if ( AV180Wppacienteds_55_tfprofesionalestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV180Wppacienteds_55_tfprofesionalestado_sels, "T1.[ProfesionalEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNombres]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaNacimiento]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaNacimiento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalSexo]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalSexo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCorreo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCOP]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorDisponible]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorDisponible] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorCita]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorCita] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTiempoCita]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTiempoCita] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTwitter]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTwitter] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFacebook]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFacebook] DESC" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalInstagram]" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalInstagram] DESC" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalLinkedin]" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalLinkedin] DESC" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTelefono]" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTelefono] DESC" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaRegistro]" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaRegistro] DESC" ;
      }
      else if ( ( AV11OrderedBy == 26 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTerminosCondiciones]" ;
      }
      else if ( ( AV11OrderedBy == 26 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTerminosCondiciones] DESC" ;
      }
      else if ( ( AV11OrderedBy == 27 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstadoCuenta]" ;
      }
      else if ( ( AV11OrderedBy == 27 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstadoCuenta] DESC" ;
      }
      else if ( ( AV11OrderedBy == 28 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstado]" ;
      }
      else if ( ( AV11OrderedBy == 28 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstado] DESC" ;
      }
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P007V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , ((Number) dynConstraints[37]).intValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).shortValue() , ((Number) dynConstraints[59]).shortValue() , (java.util.Date)dynConstraints[60] , (java.util.Date)dynConstraints[61] , ((Number) dynConstraints[62]).byteValue() , ((Number) dynConstraints[63]).intValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (String)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , (String)dynConstraints[77] , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , (String)dynConstraints[81] , (String)dynConstraints[82] , (String)dynConstraints[83] , (String)dynConstraints[84] , (String)dynConstraints[85] , (String)dynConstraints[86] , ((Number) dynConstraints[87]).shortValue() , (java.util.Date)dynConstraints[88] , (java.util.Date)dynConstraints[89] , ((Boolean) dynConstraints[90]).booleanValue() , ((Number) dynConstraints[91]).shortValue() , ((Boolean) dynConstraints[92]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 1);
               ((String[]) buf[25])[0] = rslt.getMultimediaUri(26);
               ((String[]) buf[26])[0] = rslt.getMultimediaFile(27, rslt.getVarchar(26));
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[122]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[123]).intValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 15);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 15);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 50);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 50);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 50);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 50);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[130], 50);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[131], 50);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 100);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[134]);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[135]);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 5000);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 5000);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 100);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[142], 20);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[143], 20);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[144], 20);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[145], 20);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[148]).shortValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[149]).shortValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 80);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 80);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[152], 10);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[153], 10);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[154], 100);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[155], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[156], 1000);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[157], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[158], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[159], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[160], 1000);
               }
               if ( ((Number) parms[76]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[161], 1000);
               }
               if ( ((Number) parms[77]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[162], 1000);
               }
               if ( ((Number) parms[78]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[163], 1000);
               }
               if ( ((Number) parms[79]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[164], 20);
               }
               if ( ((Number) parms[80]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[165], 20);
               }
               if ( ((Number) parms[81]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[166]).shortValue());
               }
               if ( ((Number) parms[82]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[167]).shortValue());
               }
               if ( ((Number) parms[83]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[168]);
               }
               if ( ((Number) parms[84]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[169]);
               }
               return;
      }
   }

}

