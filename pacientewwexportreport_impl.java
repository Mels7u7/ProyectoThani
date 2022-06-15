package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacientewwexportreport_impl extends GXWebReport
{
   public pacientewwexportreport_impl( com.genexus.internet.HttpContext context )
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
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
         pacientewwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV104Pgmname))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV9WWPContext;
            new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV9WWPContext = GXv_SdtWWPContext3[0] ;
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
            AV98Title = "Lista de Paciente" ;
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
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h7R0( true, 0) ;
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
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV22TFPacienteId) && (0==AV23TFPacienteId_To) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFPacienteId), "ZZZZZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV76TFPacienteId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV76TFPacienteId_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFPacienteId_To), "ZZZZZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV25TFPacienteApellidoPaterno_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Apellido Paterno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFPacienteApellidoPaterno_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFPacienteApellidoPaterno)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Apellido Paterno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFPacienteApellidoPaterno, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV27TFPacienteApellidoMaterno_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Apellido Materno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFPacienteApellidoMaterno_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV26TFPacienteApellidoMaterno)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Apellido Materno", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFPacienteApellidoMaterno, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV29TFPacienteNombres_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombres", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFPacienteNombres_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV28TFPacienteNombres)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombres", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFPacienteNombres, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV31TFPacienteNombreCompleto_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Completo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFPacienteNombreCompleto_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFPacienteNombreCompleto)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Completo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFPacienteNombreCompleto, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFPacienteFechaNacimiento)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV33TFPacienteFechaNacimiento_To)) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha Nacimiento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV32TFPacienteFechaNacimiento, "99/99/99"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV77TFPacienteFechaNacimiento_To_Description = GXutil.format( "%1 (%2)", "Fecha Nacimiento", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV77TFPacienteFechaNacimiento_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV33TFPacienteFechaNacimiento_To, "99/99/99"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV36TFPacienteTipoDocumento_Sels.fromJSonString(AV34TFPacienteTipoDocumento_SelsJson, null);
      if ( ! ( AV36TFPacienteTipoDocumento_Sels.size() == 0 ) )
      {
         AV87i = 1 ;
         AV107GXV1 = 1 ;
         while ( AV107GXV1 <= AV36TFPacienteTipoDocumento_Sels.size() )
         {
            AV37TFPacienteTipoDocumento_Sel = (String)AV36TFPacienteTipoDocumento_Sels.elementAt(-1+AV107GXV1) ;
            if ( AV87i == 1 )
            {
               AV35TFPacienteTipoDocumento_SelDscs = "" ;
            }
            else
            {
               AV35TFPacienteTipoDocumento_SelDscs += ", " ;
            }
            AV78FilterTFPacienteTipoDocumento_SelValueDescription = com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV37TFPacienteTipoDocumento_Sel) ;
            AV35TFPacienteTipoDocumento_SelDscs += AV78FilterTFPacienteTipoDocumento_SelValueDescription ;
            AV87i = (long)(AV87i+1) ;
            AV107GXV1 = (int)(AV107GXV1+1) ;
         }
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Documento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFPacienteTipoDocumento_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV39TFPacienteNroDocumento_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39TFPacienteNroDocumento_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV38TFPacienteNroDocumento)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFPacienteNroDocumento, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV41TFPacienteDireccion_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFPacienteDireccion_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV40TFPacienteDireccion)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFPacienteDireccion, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV48TFPacienteSexo_Sels.fromJSonString(AV46TFPacienteSexo_SelsJson, null);
      if ( ! ( AV48TFPacienteSexo_Sels.size() == 0 ) )
      {
         AV87i = 1 ;
         AV108GXV2 = 1 ;
         while ( AV108GXV2 <= AV48TFPacienteSexo_Sels.size() )
         {
            AV49TFPacienteSexo_Sel = (String)AV48TFPacienteSexo_Sels.elementAt(-1+AV108GXV2) ;
            if ( AV87i == 1 )
            {
               AV47TFPacienteSexo_SelDscs = "" ;
            }
            else
            {
               AV47TFPacienteSexo_SelDscs += ", " ;
            }
            AV80FilterTFPacienteSexo_SelValueDescription = com.projectthani.gxdomainsexo.getDescription(httpContext,(String)AV49TFPacienteSexo_Sel) ;
            AV47TFPacienteSexo_SelDscs += AV80FilterTFPacienteSexo_SelValueDescription ;
            AV87i = (long)(AV87i+1) ;
            AV108GXV2 = (int)(AV108GXV2+1) ;
         }
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Sexo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47TFPacienteSexo_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV51TFPacienteCorreo_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Correo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51TFPacienteCorreo_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV50TFPacienteCorreo)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Correo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50TFPacienteCorreo, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV53TFPacienteTelefono_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Telefono", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53TFPacienteTelefono_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV52TFPacienteTelefono)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Telefono", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52TFPacienteTelefono, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV54TFPaisId) && (0==AV55TFPaisId_To) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Pais Id", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV54TFPaisId), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV81TFPaisId_To_Description = GXutil.format( "%1 (%2)", "Pais Id", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV81TFPaisId_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV55TFPaisId_To), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV57TFPaisDescripcion_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Pais Descripcion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV57TFPaisDescripcion_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV56TFPaisDescripcion)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Pais Descripcion", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV56TFPaisDescripcion, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV60TFPacienteEstado_Sels.fromJSonString(AV58TFPacienteEstado_SelsJson, null);
      if ( ! ( AV60TFPacienteEstado_Sels.size() == 0 ) )
      {
         AV87i = 1 ;
         AV109GXV3 = 1 ;
         while ( AV109GXV3 <= AV60TFPacienteEstado_Sels.size() )
         {
            AV61TFPacienteEstado_Sel = (String)AV60TFPacienteEstado_Sels.elementAt(-1+AV109GXV3) ;
            if ( AV87i == 1 )
            {
               AV59TFPacienteEstado_SelDscs = "" ;
            }
            else
            {
               AV59TFPacienteEstado_SelDscs += ", " ;
            }
            AV82FilterTFPacienteEstado_SelValueDescription = com.projectthani.gxdomainestadopaciente.getDescription(httpContext,(String)AV61TFPacienteEstado_Sel) ;
            AV59TFPacienteEstado_SelDscs += AV82FilterTFPacienteEstado_SelValueDescription ;
            AV87i = (long)(AV87i+1) ;
            AV109GXV3 = (int)(AV109GXV3+1) ;
         }
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV59TFPacienteEstado_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV62TFSecUserId) && (0==AV63TFSecUserId_To) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("User Id", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV62TFSecUserId), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV83TFSecUserId_To_Description = GXutil.format( "%1 (%2)", "User Id", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV83TFSecUserId_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV63TFSecUserId_To), "ZZZ9")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV65TFUbigeoCode_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo Code", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV65TFUbigeoCode_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV64TFUbigeoCode)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo Code", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV64TFUbigeoCode, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV67TFUbigeoNombre_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV67TFUbigeoNombre_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV66TFUbigeoNombre)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV66TFUbigeoNombre, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFPacienteEstatura)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFPacienteEstatura_To)==0) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estatura", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV68TFPacienteEstatura, "9.99")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV84TFPacienteEstatura_To_Description = GXutil.format( "%1 (%2)", "Estatura", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV84TFPacienteEstatura_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV69TFPacienteEstatura_To, "9.99")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFPacientePeso)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFPacientePeso_To)==0) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Peso", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV70TFPacientePeso, "ZZ9.99")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV85TFPacientePeso_To_Description = GXutil.format( "%1 (%2)", "Peso", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV85TFPacientePeso_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV71TFPacientePeso_To, "ZZ9.99")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV73TFPacienteNombreAnexo_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Anexo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV73TFPacienteNombreAnexo_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV72TFPacienteNombreAnexo)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Anexo", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72TFPacienteNombreAnexo, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV44TFPacienteEnterarse_Sels.fromJSonString(AV42TFPacienteEnterarse_SelsJson, null);
      if ( ! ( AV44TFPacienteEnterarse_Sels.size() == 0 ) )
      {
         AV87i = 1 ;
         AV110GXV4 = 1 ;
         while ( AV110GXV4 <= AV44TFPacienteEnterarse_Sels.size() )
         {
            AV45TFPacienteEnterarse_Sel = (String)AV44TFPacienteEnterarse_Sels.elementAt(-1+AV110GXV4) ;
            if ( AV87i == 1 )
            {
               AV43TFPacienteEnterarse_SelDscs = "" ;
            }
            else
            {
               AV43TFPacienteEnterarse_SelDscs += ", " ;
            }
            AV79FilterTFPacienteEnterarse_SelValueDescription = com.projectthani.gxdomainorigenpaciente.getDescription(httpContext,(String)AV45TFPacienteEnterarse_Sel) ;
            AV43TFPacienteEnterarse_SelDscs += AV79FilterTFPacienteEnterarse_SelValueDescription ;
            AV87i = (long)(AV87i+1) ;
            AV110GXV4 = (int)(AV110GXV4+1) ;
         }
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Enterarse", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFPacienteEnterarse_SelDscs, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV101TFPacienteEspecifique_Sel)==0) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Especifique", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV101TFPacienteEspecifique_Sel, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV100TFPacienteEspecifique)==0) )
         {
            h7R0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Especifique", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV100TFPacienteEspecifique, "")), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV74TFPacienteFechaRegistro) && GXutil.dateCompare(GXutil.nullDate(), AV75TFPacienteFechaRegistro_To) ) )
      {
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha Registro", 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV74TFPacienteFechaRegistro, "99/99/99 99:99"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV86TFPacienteFechaRegistro_To_Description = GXutil.format( "%1 (%2)", "Fecha Registro", "Hasta", "", "", "", "", "", "", "") ;
         h7R0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV86TFPacienteFechaRegistro_To_Description, "")), 25, Gx_line+0, 145, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV75TFPacienteFechaRegistro_To, "99/99/99 99:99"), 145, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h7R0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h7R0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 56, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Apellido Paterno", 60, Gx_line+10, 86, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Apellido Materno", 90, Gx_line+10, 116, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombres", 120, Gx_line+10, 146, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Completo", 150, Gx_line+10, 176, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha Nacimiento", 180, Gx_line+10, 206, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Documento", 210, Gx_line+10, 236, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nro Documento", 240, Gx_line+10, 266, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Direccion", 270, Gx_line+10, 296, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Sexo", 300, Gx_line+10, 326, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Correo", 330, Gx_line+10, 356, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Telefono", 360, Gx_line+10, 386, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Pais Id", 390, Gx_line+10, 416, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Pais Descripcion", 420, Gx_line+10, 446, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 450, Gx_line+10, 476, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("User Id", 480, Gx_line+10, 506, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo Code", 510, Gx_line+10, 536, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo", 540, Gx_line+10, 567, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estatura", 571, Gx_line+10, 598, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Peso", 602, Gx_line+10, 629, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Anexo", 633, Gx_line+10, 661, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Anexos", 665, Gx_line+10, 692, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Enterarse", 696, Gx_line+10, 724, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Especifique", 728, Gx_line+10, 756, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha Registro", 760, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV112Pacientewwds_1_filterfulltext = AV13FilterFullText ;
      AV113Pacientewwds_2_tfpacienteid = AV22TFPacienteId ;
      AV114Pacientewwds_3_tfpacienteid_to = AV23TFPacienteId_To ;
      AV115Pacientewwds_4_tfpacienteapellidopaterno = AV24TFPacienteApellidoPaterno ;
      AV116Pacientewwds_5_tfpacienteapellidopaterno_sel = AV25TFPacienteApellidoPaterno_Sel ;
      AV117Pacientewwds_6_tfpacienteapellidomaterno = AV26TFPacienteApellidoMaterno ;
      AV118Pacientewwds_7_tfpacienteapellidomaterno_sel = AV27TFPacienteApellidoMaterno_Sel ;
      AV119Pacientewwds_8_tfpacientenombres = AV28TFPacienteNombres ;
      AV120Pacientewwds_9_tfpacientenombres_sel = AV29TFPacienteNombres_Sel ;
      AV121Pacientewwds_10_tfpacientenombrecompleto = AV30TFPacienteNombreCompleto ;
      AV122Pacientewwds_11_tfpacientenombrecompleto_sel = AV31TFPacienteNombreCompleto_Sel ;
      AV123Pacientewwds_12_tfpacientefechanacimiento = AV32TFPacienteFechaNacimiento ;
      AV124Pacientewwds_13_tfpacientefechanacimiento_to = AV33TFPacienteFechaNacimiento_To ;
      AV125Pacientewwds_14_tfpacientetipodocumento_sels = AV36TFPacienteTipoDocumento_Sels ;
      AV126Pacientewwds_15_tfpacientenrodocumento = AV38TFPacienteNroDocumento ;
      AV127Pacientewwds_16_tfpacientenrodocumento_sel = AV39TFPacienteNroDocumento_Sel ;
      AV128Pacientewwds_17_tfpacientedireccion = AV40TFPacienteDireccion ;
      AV129Pacientewwds_18_tfpacientedireccion_sel = AV41TFPacienteDireccion_Sel ;
      AV130Pacientewwds_19_tfpacientesexo_sels = AV48TFPacienteSexo_Sels ;
      AV131Pacientewwds_20_tfpacientecorreo = AV50TFPacienteCorreo ;
      AV132Pacientewwds_21_tfpacientecorreo_sel = AV51TFPacienteCorreo_Sel ;
      AV133Pacientewwds_22_tfpacientetelefono = AV52TFPacienteTelefono ;
      AV134Pacientewwds_23_tfpacientetelefono_sel = AV53TFPacienteTelefono_Sel ;
      AV135Pacientewwds_24_tfpaisid = AV54TFPaisId ;
      AV136Pacientewwds_25_tfpaisid_to = AV55TFPaisId_To ;
      AV137Pacientewwds_26_tfpaisdescripcion = AV56TFPaisDescripcion ;
      AV138Pacientewwds_27_tfpaisdescripcion_sel = AV57TFPaisDescripcion_Sel ;
      AV139Pacientewwds_28_tfpacienteestado_sels = AV60TFPacienteEstado_Sels ;
      AV140Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV141Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV142Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV143Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV144Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV145Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV146Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV147Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV148Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV149Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV150Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV151Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV152Pacientewwds_41_tfpacienteenterarse_sels = AV44TFPacienteEnterarse_Sels ;
      AV153Pacientewwds_42_tfpacienteespecifique = AV100TFPacienteEspecifique ;
      AV154Pacientewwds_43_tfpacienteespecifique_sel = AV101TFPacienteEspecifique_Sel ;
      AV155Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV156Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV125Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV130Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV139Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV152Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV112Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV113Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV114Pacientewwds_3_tfpacienteid_to) ,
                                           AV116Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV115Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV118Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV117Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV120Pacientewwds_9_tfpacientenombres_sel ,
                                           AV119Pacientewwds_8_tfpacientenombres ,
                                           AV122Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV121Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV123Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV124Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV125Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV127Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV126Pacientewwds_15_tfpacientenrodocumento ,
                                           AV129Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV128Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV130Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV132Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV131Pacientewwds_20_tfpacientecorreo ,
                                           AV134Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV133Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV135Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV136Pacientewwds_25_tfpaisid_to) ,
                                           AV138Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV137Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV139Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV140Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV141Pacientewwds_30_tfsecuserid_to) ,
                                           AV143Pacientewwds_32_tfubigeocode_sel ,
                                           AV142Pacientewwds_31_tfubigeocode ,
                                           AV145Pacientewwds_34_tfubigeonombre_sel ,
                                           AV144Pacientewwds_33_tfubigeonombre ,
                                           AV146Pacientewwds_35_tfpacienteestatura ,
                                           AV147Pacientewwds_36_tfpacienteestatura_to ,
                                           AV148Pacientewwds_37_tfpacientepeso ,
                                           AV149Pacientewwds_38_tfpacientepeso_to ,
                                           AV151Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV150Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV152Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV154Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV153Pacientewwds_42_tfpacienteespecifique ,
                                           AV155Pacientewwds_44_tfpacientefecharegistro ,
                                           AV156Pacientewwds_45_tfpacientefecharegistro_to ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           A215PacienteDireccion ,
                                           A217PacienteCorreo ,
                                           A218PacienteTelefono ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           Short.valueOf(A6SecUserId) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A220PacienteEstatura ,
                                           A221PacientePeso ,
                                           A222PacienteNombreAnexo ,
                                           A225PacienteEspecifique ,
                                           A213PacienteFechaNacimiento ,
                                           A226PacienteFechaRegistro ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV112Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Pacientewwds_1_filterfulltext), "%", "") ;
      lV115Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV117Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV119Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV121Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV121Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV126Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV126Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV128Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV128Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV131Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV131Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV133Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV133Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV137Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV137Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV142Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV142Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV144Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV144Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV150Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV150Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV153Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV153Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P007R2 */
      pr_default.execute(0, new Object[] {lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, lV112Pacientewwds_1_filterfulltext, Integer.valueOf(AV113Pacientewwds_2_tfpacienteid), Integer.valueOf(AV114Pacientewwds_3_tfpacienteid_to), lV115Pacientewwds_4_tfpacienteapellidopaterno, AV116Pacientewwds_5_tfpacienteapellidopaterno_sel, lV117Pacientewwds_6_tfpacienteapellidomaterno, AV118Pacientewwds_7_tfpacienteapellidomaterno_sel, lV119Pacientewwds_8_tfpacientenombres, AV120Pacientewwds_9_tfpacientenombres_sel, lV121Pacientewwds_10_tfpacientenombrecompleto, AV122Pacientewwds_11_tfpacientenombrecompleto_sel, AV123Pacientewwds_12_tfpacientefechanacimiento, AV124Pacientewwds_13_tfpacientefechanacimiento_to, lV126Pacientewwds_15_tfpacientenrodocumento, AV127Pacientewwds_16_tfpacientenrodocumento_sel, lV128Pacientewwds_17_tfpacientedireccion, AV129Pacientewwds_18_tfpacientedireccion_sel, lV131Pacientewwds_20_tfpacientecorreo, AV132Pacientewwds_21_tfpacientecorreo_sel, lV133Pacientewwds_22_tfpacientetelefono, AV134Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV135Pacientewwds_24_tfpaisid), Short.valueOf(AV136Pacientewwds_25_tfpaisid_to), lV137Pacientewwds_26_tfpaisdescripcion, AV138Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV140Pacientewwds_29_tfsecuserid), Short.valueOf(AV141Pacientewwds_30_tfsecuserid_to), lV142Pacientewwds_31_tfubigeocode, AV143Pacientewwds_32_tfubigeocode_sel, lV144Pacientewwds_33_tfubigeonombre, AV145Pacientewwds_34_tfubigeonombre_sel, AV146Pacientewwds_35_tfpacienteestatura, AV147Pacientewwds_36_tfpacienteestatura_to, AV148Pacientewwds_37_tfpacientepeso, AV149Pacientewwds_38_tfpacientepeso_to, lV150Pacientewwds_39_tfpacientenombreanexo, AV151Pacientewwds_40_tfpacientenombreanexo_sel, lV153Pacientewwds_42_tfpacienteespecifique, AV154Pacientewwds_43_tfpacienteespecifique_sel, AV155Pacientewwds_44_tfpacientefecharegistro, AV156Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A226PacienteFechaRegistro = P007R2_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P007R2_A221PacientePeso[0] ;
         A220PacienteEstatura = P007R2_A220PacienteEstatura[0] ;
         A6SecUserId = P007R2_A6SecUserId[0] ;
         n6SecUserId = P007R2_n6SecUserId[0] ;
         A43PaisId = P007R2_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P007R2_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P007R2_A20PacienteId[0] ;
         A225PacienteEspecifique = P007R2_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P007R2_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P007R2_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P007R2_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P007R2_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P007R2_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P007R2_A44UbigeoCode[0] ;
         n44UbigeoCode = P007R2_n44UbigeoCode[0] ;
         A219PacienteEstado = P007R2_A219PacienteEstado[0] ;
         A184PaisDescripcion = P007R2_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P007R2_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P007R2_A217PacienteCorreo[0] ;
         A216PacienteSexo = P007R2_A216PacienteSexo[0] ;
         A215PacienteDireccion = P007R2_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P007R2_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P007R2_A214PacienteTipoDocumento[0] ;
         A223PacienteAnexos = P007R2_A223PacienteAnexos[0] ;
         n223PacienteAnexos = P007R2_n223PacienteAnexos[0] ;
         A105PacienteNombres = P007R2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P007R2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P007R2_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P007R2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007R2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007R2_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P007R2_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P007R2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007R2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007R2_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV14PacienteTipoDocumentoDescription = com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A214PacienteTipoDocumento) ;
         AV16PacienteSexoDescription = com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A216PacienteSexo) ;
         AV17PacienteEstadoDescription = com.projectthani.gxdomainestadopaciente.getDescription(httpContext,(String)A219PacienteEstado) ;
         AV15PacienteEnterarseDescription = com.projectthani.gxdomainorigenpaciente.getDescription(httpContext,(String)A224PacienteEnterarse) ;
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
         h7R0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")), 30, Gx_line+10, 56, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), 60, Gx_line+10, 86, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), 90, Gx_line+10, 116, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), 120, Gx_line+10, 146, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A212PacienteNombreCompleto, "")), 150, Gx_line+10, 176, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A213PacienteFechaNacimiento, "99/99/99"), 180, Gx_line+10, 206, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14PacienteTipoDocumentoDescription, "")), 210, Gx_line+10, 236, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A106PacienteNroDocumento, "")), 240, Gx_line+10, 266, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A215PacienteDireccion, "")), 270, Gx_line+10, 296, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV16PacienteSexoDescription, "")), 300, Gx_line+10, 326, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A217PacienteCorreo, "")), 330, Gx_line+10, 356, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A218PacienteTelefono, "")), 360, Gx_line+10, 386, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9")), 390, Gx_line+10, 416, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A184PaisDescripcion, "")), 420, Gx_line+10, 446, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV17PacienteEstadoDescription, "")), 450, Gx_line+10, 476, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9")), 480, Gx_line+10, 506, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), 510, Gx_line+10, 536, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), 540, Gx_line+10, 567, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A220PacienteEstatura, "9.99")), 571, Gx_line+10, 598, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A221PacientePeso, "ZZ9.99")), 602, Gx_line+10, 629, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A222PacienteNombreAnexo, "")), 633, Gx_line+10, 661, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A223PacienteAnexos, "")), 665, Gx_line+10, 692, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15PacienteEnterarseDescription, "")), 696, Gx_line+10, 724, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A225PacienteEspecifique, 728, Gx_line+10, 756, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A226PacienteFechaRegistro, "99/99/99 99:99"), 760, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV18Session.getValue("PacienteWWGridState"), "") == 0 )
      {
         AV20GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PacienteWWGridState"), null, null);
      }
      else
      {
         AV20GridState.fromxml(AV18Session.getValue("PacienteWWGridState"), null, null);
      }
      AV11OrderedBy = AV20GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV20GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV157GXV5 = 1 ;
      while ( AV157GXV5 <= AV20GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV21GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV20GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV157GXV5));
         if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV22TFPacienteId = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV23TFPacienteId_To = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV24TFPacienteApellidoPaterno = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV25TFPacienteApellidoPaterno_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV26TFPacienteApellidoMaterno = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV27TFPacienteApellidoMaterno_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV28TFPacienteNombres = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV29TFPacienteNombres_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO") == 0 )
         {
            AV30TFPacienteNombreCompleto = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO_SEL") == 0 )
         {
            AV31TFPacienteNombreCompleto_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHANACIMIENTO") == 0 )
         {
            AV32TFPacienteFechaNacimiento = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV33TFPacienteFechaNacimiento_To = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETIPODOCUMENTO_SEL") == 0 )
         {
            AV34TFPacienteTipoDocumento_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFPacienteTipoDocumento_Sels.fromJSonString(AV34TFPacienteTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV38TFPacienteNroDocumento = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV39TFPacienteNroDocumento_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION") == 0 )
         {
            AV40TFPacienteDireccion = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION_SEL") == 0 )
         {
            AV41TFPacienteDireccion_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTESEXO_SEL") == 0 )
         {
            AV46TFPacienteSexo_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFPacienteSexo_Sels.fromJSonString(AV46TFPacienteSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO") == 0 )
         {
            AV50TFPacienteCorreo = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO_SEL") == 0 )
         {
            AV51TFPacienteCorreo_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO") == 0 )
         {
            AV52TFPacienteTelefono = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO_SEL") == 0 )
         {
            AV53TFPacienteTelefono_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV54TFPaisId = (short)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV55TFPaisId_To = (short)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV56TFPaisDescripcion = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV57TFPaisDescripcion_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTADO_SEL") == 0 )
         {
            AV58TFPacienteEstado_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV60TFPacienteEstado_Sels.fromJSonString(AV58TFPacienteEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV62TFSecUserId = (short)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV63TFSecUserId_To = (short)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV64TFUbigeoCode = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV65TFUbigeoCode_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV66TFUbigeoNombre = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV67TFUbigeoNombre_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTATURA") == 0 )
         {
            AV68TFPacienteEstatura = CommonUtil.decimalVal( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV69TFPacienteEstatura_To = CommonUtil.decimalVal( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEPESO") == 0 )
         {
            AV70TFPacientePeso = CommonUtil.decimalVal( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV71TFPacientePeso_To = CommonUtil.decimalVal( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO") == 0 )
         {
            AV72TFPacienteNombreAnexo = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO_SEL") == 0 )
         {
            AV73TFPacienteNombreAnexo_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEENTERARSE_SEL") == 0 )
         {
            AV42TFPacienteEnterarse_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFPacienteEnterarse_Sels.fromJSonString(AV42TFPacienteEnterarse_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE") == 0 )
         {
            AV100TFPacienteEspecifique = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE_SEL") == 0 )
         {
            AV101TFPacienteEspecifique_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHAREGISTRO") == 0 )
         {
            AV74TFPacienteFechaRegistro = localUtil.ctot( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV75TFPacienteFechaRegistro_To = localUtil.ctot( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         AV157GXV5 = (int)(AV157GXV5+1) ;
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

   public void h7R0( boolean bFoot ,
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
               AV96PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV93DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV96PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV93DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV91AppName = "DVelop Software Solutions" ;
            AV97Phone = "+1 550 8923" ;
            AV95Mail = "info@mail.com" ;
            AV99Website = "http://www.web.com" ;
            AV88AddressLine1 = "French Boulevard 2859" ;
            AV89AddressLine2 = "Downtown" ;
            AV90AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV91AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV98Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV97Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV95Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV99Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV88AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV89AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV90AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      GXv_boolean2 = new boolean[1] ;
      AV104Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV98Title = "" ;
      AV13FilterFullText = "" ;
      AV76TFPacienteId_To_Description = "" ;
      AV25TFPacienteApellidoPaterno_Sel = "" ;
      AV24TFPacienteApellidoPaterno = "" ;
      AV27TFPacienteApellidoMaterno_Sel = "" ;
      AV26TFPacienteApellidoMaterno = "" ;
      AV29TFPacienteNombres_Sel = "" ;
      AV28TFPacienteNombres = "" ;
      AV31TFPacienteNombreCompleto_Sel = "" ;
      AV30TFPacienteNombreCompleto = "" ;
      AV32TFPacienteFechaNacimiento = GXutil.nullDate() ;
      AV33TFPacienteFechaNacimiento_To = GXutil.nullDate() ;
      AV77TFPacienteFechaNacimiento_To_Description = "" ;
      AV36TFPacienteTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFPacienteTipoDocumento_SelsJson = "" ;
      AV37TFPacienteTipoDocumento_Sel = "" ;
      AV35TFPacienteTipoDocumento_SelDscs = "" ;
      AV78FilterTFPacienteTipoDocumento_SelValueDescription = "" ;
      AV39TFPacienteNroDocumento_Sel = "" ;
      AV38TFPacienteNroDocumento = "" ;
      AV41TFPacienteDireccion_Sel = "" ;
      AV40TFPacienteDireccion = "" ;
      AV48TFPacienteSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFPacienteSexo_SelsJson = "" ;
      AV49TFPacienteSexo_Sel = "" ;
      AV47TFPacienteSexo_SelDscs = "" ;
      AV80FilterTFPacienteSexo_SelValueDescription = "" ;
      AV51TFPacienteCorreo_Sel = "" ;
      AV50TFPacienteCorreo = "" ;
      AV53TFPacienteTelefono_Sel = "" ;
      AV52TFPacienteTelefono = "" ;
      AV81TFPaisId_To_Description = "" ;
      AV57TFPaisDescripcion_Sel = "" ;
      AV56TFPaisDescripcion = "" ;
      AV60TFPacienteEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFPacienteEstado_SelsJson = "" ;
      AV61TFPacienteEstado_Sel = "" ;
      AV59TFPacienteEstado_SelDscs = "" ;
      AV82FilterTFPacienteEstado_SelValueDescription = "" ;
      AV83TFSecUserId_To_Description = "" ;
      AV65TFUbigeoCode_Sel = "" ;
      AV64TFUbigeoCode = "" ;
      AV67TFUbigeoNombre_Sel = "" ;
      AV66TFUbigeoNombre = "" ;
      AV68TFPacienteEstatura = DecimalUtil.ZERO ;
      AV69TFPacienteEstatura_To = DecimalUtil.ZERO ;
      AV84TFPacienteEstatura_To_Description = "" ;
      AV70TFPacientePeso = DecimalUtil.ZERO ;
      AV71TFPacientePeso_To = DecimalUtil.ZERO ;
      AV85TFPacientePeso_To_Description = "" ;
      AV73TFPacienteNombreAnexo_Sel = "" ;
      AV72TFPacienteNombreAnexo = "" ;
      AV44TFPacienteEnterarse_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFPacienteEnterarse_SelsJson = "" ;
      AV45TFPacienteEnterarse_Sel = "" ;
      AV43TFPacienteEnterarse_SelDscs = "" ;
      AV79FilterTFPacienteEnterarse_SelValueDescription = "" ;
      AV101TFPacienteEspecifique_Sel = "" ;
      AV100TFPacienteEspecifique = "" ;
      AV74TFPacienteFechaRegistro = GXutil.now( ) ;
      AV75TFPacienteFechaRegistro_To = GXutil.now( ) ;
      AV86TFPacienteFechaRegistro_To_Description = "" ;
      A214PacienteTipoDocumento = "" ;
      A216PacienteSexo = "" ;
      A219PacienteEstado = "" ;
      A224PacienteEnterarse = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A212PacienteNombreCompleto = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      A184PaisDescripcion = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      A223PacienteAnexos = "" ;
      A225PacienteEspecifique = "" ;
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      AV112Pacientewwds_1_filterfulltext = "" ;
      AV115Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      AV116Pacientewwds_5_tfpacienteapellidopaterno_sel = "" ;
      AV117Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      AV118Pacientewwds_7_tfpacienteapellidomaterno_sel = "" ;
      AV119Pacientewwds_8_tfpacientenombres = "" ;
      AV120Pacientewwds_9_tfpacientenombres_sel = "" ;
      AV121Pacientewwds_10_tfpacientenombrecompleto = "" ;
      AV122Pacientewwds_11_tfpacientenombrecompleto_sel = "" ;
      AV123Pacientewwds_12_tfpacientefechanacimiento = GXutil.nullDate() ;
      AV124Pacientewwds_13_tfpacientefechanacimiento_to = GXutil.nullDate() ;
      AV125Pacientewwds_14_tfpacientetipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV126Pacientewwds_15_tfpacientenrodocumento = "" ;
      AV127Pacientewwds_16_tfpacientenrodocumento_sel = "" ;
      AV128Pacientewwds_17_tfpacientedireccion = "" ;
      AV129Pacientewwds_18_tfpacientedireccion_sel = "" ;
      AV130Pacientewwds_19_tfpacientesexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV131Pacientewwds_20_tfpacientecorreo = "" ;
      AV132Pacientewwds_21_tfpacientecorreo_sel = "" ;
      AV133Pacientewwds_22_tfpacientetelefono = "" ;
      AV134Pacientewwds_23_tfpacientetelefono_sel = "" ;
      AV137Pacientewwds_26_tfpaisdescripcion = "" ;
      AV138Pacientewwds_27_tfpaisdescripcion_sel = "" ;
      AV139Pacientewwds_28_tfpacienteestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV142Pacientewwds_31_tfubigeocode = "" ;
      AV143Pacientewwds_32_tfubigeocode_sel = "" ;
      AV144Pacientewwds_33_tfubigeonombre = "" ;
      AV145Pacientewwds_34_tfubigeonombre_sel = "" ;
      AV146Pacientewwds_35_tfpacienteestatura = DecimalUtil.ZERO ;
      AV147Pacientewwds_36_tfpacienteestatura_to = DecimalUtil.ZERO ;
      AV148Pacientewwds_37_tfpacientepeso = DecimalUtil.ZERO ;
      AV149Pacientewwds_38_tfpacientepeso_to = DecimalUtil.ZERO ;
      AV150Pacientewwds_39_tfpacientenombreanexo = "" ;
      AV151Pacientewwds_40_tfpacientenombreanexo_sel = "" ;
      AV152Pacientewwds_41_tfpacienteenterarse_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV153Pacientewwds_42_tfpacienteespecifique = "" ;
      AV154Pacientewwds_43_tfpacienteespecifique_sel = "" ;
      AV155Pacientewwds_44_tfpacientefecharegistro = GXutil.resetTime( GXutil.nullDate() );
      AV156Pacientewwds_45_tfpacientefecharegistro_to = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      lV112Pacientewwds_1_filterfulltext = "" ;
      lV115Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      lV117Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      lV119Pacientewwds_8_tfpacientenombres = "" ;
      lV121Pacientewwds_10_tfpacientenombrecompleto = "" ;
      lV126Pacientewwds_15_tfpacientenrodocumento = "" ;
      lV128Pacientewwds_17_tfpacientedireccion = "" ;
      lV131Pacientewwds_20_tfpacientecorreo = "" ;
      lV133Pacientewwds_22_tfpacientetelefono = "" ;
      lV137Pacientewwds_26_tfpaisdescripcion = "" ;
      lV142Pacientewwds_31_tfubigeocode = "" ;
      lV144Pacientewwds_33_tfubigeonombre = "" ;
      lV150Pacientewwds_39_tfpacientenombreanexo = "" ;
      lV153Pacientewwds_42_tfpacienteespecifique = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P007R2_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P007R2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007R2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007R2_A6SecUserId = new short[1] ;
      P007R2_n6SecUserId = new boolean[] {false} ;
      P007R2_A43PaisId = new short[1] ;
      P007R2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P007R2_A20PacienteId = new int[1] ;
      P007R2_A225PacienteEspecifique = new String[] {""} ;
      P007R2_n225PacienteEspecifique = new boolean[] {false} ;
      P007R2_A224PacienteEnterarse = new String[] {""} ;
      P007R2_n224PacienteEnterarse = new boolean[] {false} ;
      P007R2_A222PacienteNombreAnexo = new String[] {""} ;
      P007R2_n222PacienteNombreAnexo = new boolean[] {false} ;
      P007R2_A44UbigeoCode = new String[] {""} ;
      P007R2_n44UbigeoCode = new boolean[] {false} ;
      P007R2_A219PacienteEstado = new String[] {""} ;
      P007R2_A184PaisDescripcion = new String[] {""} ;
      P007R2_A218PacienteTelefono = new String[] {""} ;
      P007R2_A217PacienteCorreo = new String[] {""} ;
      P007R2_A216PacienteSexo = new String[] {""} ;
      P007R2_A215PacienteDireccion = new String[] {""} ;
      P007R2_A106PacienteNroDocumento = new String[] {""} ;
      P007R2_A214PacienteTipoDocumento = new String[] {""} ;
      P007R2_A223PacienteAnexos = new String[] {""} ;
      P007R2_n223PacienteAnexos = new boolean[] {false} ;
      P007R2_A105PacienteNombres = new String[] {""} ;
      P007R2_A104PacienteApellidoMaterno = new String[] {""} ;
      P007R2_A103PacienteApellidoPaterno = new String[] {""} ;
      P007R2_A188UbigeoDistrito = new String[] {""} ;
      P007R2_A187UbigeoProvincia = new String[] {""} ;
      P007R2_A186UbigeoDepartamento = new String[] {""} ;
      AV14PacienteTipoDocumentoDescription = "" ;
      AV16PacienteSexoDescription = "" ;
      AV17PacienteEstadoDescription = "" ;
      AV15PacienteEnterarseDescription = "" ;
      AV18Session = httpContext.getWebSession();
      AV20GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV21GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV96PageInfo = "" ;
      AV93DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV91AppName = "" ;
      AV97Phone = "" ;
      AV95Mail = "" ;
      AV99Website = "" ;
      AV88AddressLine1 = "" ;
      AV89AddressLine2 = "" ;
      AV90AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacientewwexportreport__default(),
         new Object[] {
             new Object[] {
            P007R2_A226PacienteFechaRegistro, P007R2_A221PacientePeso, P007R2_A220PacienteEstatura, P007R2_A6SecUserId, P007R2_n6SecUserId, P007R2_A43PaisId, P007R2_A213PacienteFechaNacimiento, P007R2_A20PacienteId, P007R2_A225PacienteEspecifique, P007R2_n225PacienteEspecifique,
            P007R2_A224PacienteEnterarse, P007R2_n224PacienteEnterarse, P007R2_A222PacienteNombreAnexo, P007R2_n222PacienteNombreAnexo, P007R2_A44UbigeoCode, P007R2_n44UbigeoCode, P007R2_A219PacienteEstado, P007R2_A184PaisDescripcion, P007R2_A218PacienteTelefono, P007R2_A217PacienteCorreo,
            P007R2_A216PacienteSexo, P007R2_A215PacienteDireccion, P007R2_A106PacienteNroDocumento, P007R2_A214PacienteTipoDocumento, P007R2_A223PacienteAnexos, P007R2_n223PacienteAnexos, P007R2_A105PacienteNombres, P007R2_A104PacienteApellidoMaterno, P007R2_A103PacienteApellidoPaterno, P007R2_A188UbigeoDistrito,
            P007R2_A187UbigeoProvincia, P007R2_A186UbigeoDepartamento
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV104Pgmname = "PacienteWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV104Pgmname = "PacienteWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV54TFPaisId ;
   private short AV55TFPaisId_To ;
   private short AV62TFSecUserId ;
   private short AV63TFSecUserId_To ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short AV135Pacientewwds_24_tfpaisid ;
   private short AV136Pacientewwds_25_tfpaisid_to ;
   private short AV140Pacientewwds_29_tfsecuserid ;
   private short AV141Pacientewwds_30_tfsecuserid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV22TFPacienteId ;
   private int AV23TFPacienteId_To ;
   private int AV107GXV1 ;
   private int AV108GXV2 ;
   private int AV109GXV3 ;
   private int AV110GXV4 ;
   private int A20PacienteId ;
   private int AV113Pacientewwds_2_tfpacienteid ;
   private int AV114Pacientewwds_3_tfpacienteid_to ;
   private int AV125Pacientewwds_14_tfpacientetipodocumento_sels_size ;
   private int AV130Pacientewwds_19_tfpacientesexo_sels_size ;
   private int AV139Pacientewwds_28_tfpacienteestado_sels_size ;
   private int AV152Pacientewwds_41_tfpacienteenterarse_sels_size ;
   private int AV157GXV5 ;
   private long AV87i ;
   private java.math.BigDecimal AV68TFPacienteEstatura ;
   private java.math.BigDecimal AV69TFPacienteEstatura_To ;
   private java.math.BigDecimal AV70TFPacientePeso ;
   private java.math.BigDecimal AV71TFPacientePeso_To ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private java.math.BigDecimal AV146Pacientewwds_35_tfpacienteestatura ;
   private java.math.BigDecimal AV147Pacientewwds_36_tfpacienteestatura_to ;
   private java.math.BigDecimal AV148Pacientewwds_37_tfpacientepeso ;
   private java.math.BigDecimal AV149Pacientewwds_38_tfpacientepeso_to ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV104Pgmname ;
   private String AV37TFPacienteTipoDocumento_Sel ;
   private String AV49TFPacienteSexo_Sel ;
   private String AV53TFPacienteTelefono_Sel ;
   private String AV52TFPacienteTelefono ;
   private String AV61TFPacienteEstado_Sel ;
   private String AV65TFUbigeoCode_Sel ;
   private String AV64TFUbigeoCode ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private String A219PacienteEstado ;
   private String A218PacienteTelefono ;
   private String A44UbigeoCode ;
   private String AV133Pacientewwds_22_tfpacientetelefono ;
   private String AV134Pacientewwds_23_tfpacientetelefono_sel ;
   private String AV142Pacientewwds_31_tfubigeocode ;
   private String AV143Pacientewwds_32_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV133Pacientewwds_22_tfpacientetelefono ;
   private String lV142Pacientewwds_31_tfubigeocode ;
   private java.util.Date AV74TFPacienteFechaRegistro ;
   private java.util.Date AV75TFPacienteFechaRegistro_To ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date AV155Pacientewwds_44_tfpacientefecharegistro ;
   private java.util.Date AV156Pacientewwds_45_tfpacientefecharegistro_to ;
   private java.util.Date AV32TFPacienteFechaNacimiento ;
   private java.util.Date AV33TFPacienteFechaNacimiento_To ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private java.util.Date AV123Pacientewwds_12_tfpacientefechanacimiento ;
   private java.util.Date AV124Pacientewwds_13_tfpacientefechanacimiento_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n6SecUserId ;
   private boolean n225PacienteEspecifique ;
   private boolean n224PacienteEnterarse ;
   private boolean n222PacienteNombreAnexo ;
   private boolean n44UbigeoCode ;
   private boolean n223PacienteAnexos ;
   private String AV34TFPacienteTipoDocumento_SelsJson ;
   private String AV46TFPacienteSexo_SelsJson ;
   private String AV58TFPacienteEstado_SelsJson ;
   private String AV42TFPacienteEnterarse_SelsJson ;
   private String A225PacienteEspecifique ;
   private String A223PacienteAnexos ;
   private String AV98Title ;
   private String AV13FilterFullText ;
   private String AV76TFPacienteId_To_Description ;
   private String AV25TFPacienteApellidoPaterno_Sel ;
   private String AV24TFPacienteApellidoPaterno ;
   private String AV27TFPacienteApellidoMaterno_Sel ;
   private String AV26TFPacienteApellidoMaterno ;
   private String AV29TFPacienteNombres_Sel ;
   private String AV28TFPacienteNombres ;
   private String AV31TFPacienteNombreCompleto_Sel ;
   private String AV30TFPacienteNombreCompleto ;
   private String AV77TFPacienteFechaNacimiento_To_Description ;
   private String AV35TFPacienteTipoDocumento_SelDscs ;
   private String AV78FilterTFPacienteTipoDocumento_SelValueDescription ;
   private String AV39TFPacienteNroDocumento_Sel ;
   private String AV38TFPacienteNroDocumento ;
   private String AV41TFPacienteDireccion_Sel ;
   private String AV40TFPacienteDireccion ;
   private String AV47TFPacienteSexo_SelDscs ;
   private String AV80FilterTFPacienteSexo_SelValueDescription ;
   private String AV51TFPacienteCorreo_Sel ;
   private String AV50TFPacienteCorreo ;
   private String AV81TFPaisId_To_Description ;
   private String AV57TFPaisDescripcion_Sel ;
   private String AV56TFPaisDescripcion ;
   private String AV59TFPacienteEstado_SelDscs ;
   private String AV82FilterTFPacienteEstado_SelValueDescription ;
   private String AV83TFSecUserId_To_Description ;
   private String AV67TFUbigeoNombre_Sel ;
   private String AV66TFUbigeoNombre ;
   private String AV84TFPacienteEstatura_To_Description ;
   private String AV85TFPacientePeso_To_Description ;
   private String AV73TFPacienteNombreAnexo_Sel ;
   private String AV72TFPacienteNombreAnexo ;
   private String AV45TFPacienteEnterarse_Sel ;
   private String AV43TFPacienteEnterarse_SelDscs ;
   private String AV79FilterTFPacienteEnterarse_SelValueDescription ;
   private String AV101TFPacienteEspecifique_Sel ;
   private String AV100TFPacienteEspecifique ;
   private String AV86TFPacienteFechaRegistro_To_Description ;
   private String A224PacienteEnterarse ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A212PacienteNombreCompleto ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A222PacienteNombreAnexo ;
   private String AV112Pacientewwds_1_filterfulltext ;
   private String AV115Pacientewwds_4_tfpacienteapellidopaterno ;
   private String AV116Pacientewwds_5_tfpacienteapellidopaterno_sel ;
   private String AV117Pacientewwds_6_tfpacienteapellidomaterno ;
   private String AV118Pacientewwds_7_tfpacienteapellidomaterno_sel ;
   private String AV119Pacientewwds_8_tfpacientenombres ;
   private String AV120Pacientewwds_9_tfpacientenombres_sel ;
   private String AV121Pacientewwds_10_tfpacientenombrecompleto ;
   private String AV122Pacientewwds_11_tfpacientenombrecompleto_sel ;
   private String AV126Pacientewwds_15_tfpacientenrodocumento ;
   private String AV127Pacientewwds_16_tfpacientenrodocumento_sel ;
   private String AV128Pacientewwds_17_tfpacientedireccion ;
   private String AV129Pacientewwds_18_tfpacientedireccion_sel ;
   private String AV131Pacientewwds_20_tfpacientecorreo ;
   private String AV132Pacientewwds_21_tfpacientecorreo_sel ;
   private String AV137Pacientewwds_26_tfpaisdescripcion ;
   private String AV138Pacientewwds_27_tfpaisdescripcion_sel ;
   private String AV144Pacientewwds_33_tfubigeonombre ;
   private String AV145Pacientewwds_34_tfubigeonombre_sel ;
   private String AV150Pacientewwds_39_tfpacientenombreanexo ;
   private String AV151Pacientewwds_40_tfpacientenombreanexo_sel ;
   private String AV153Pacientewwds_42_tfpacienteespecifique ;
   private String AV154Pacientewwds_43_tfpacienteespecifique_sel ;
   private String lV112Pacientewwds_1_filterfulltext ;
   private String lV115Pacientewwds_4_tfpacienteapellidopaterno ;
   private String lV117Pacientewwds_6_tfpacienteapellidomaterno ;
   private String lV119Pacientewwds_8_tfpacientenombres ;
   private String lV121Pacientewwds_10_tfpacientenombrecompleto ;
   private String lV126Pacientewwds_15_tfpacientenrodocumento ;
   private String lV128Pacientewwds_17_tfpacientedireccion ;
   private String lV131Pacientewwds_20_tfpacientecorreo ;
   private String lV137Pacientewwds_26_tfpaisdescripcion ;
   private String lV144Pacientewwds_33_tfubigeonombre ;
   private String lV150Pacientewwds_39_tfpacientenombreanexo ;
   private String lV153Pacientewwds_42_tfpacienteespecifique ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String AV14PacienteTipoDocumentoDescription ;
   private String AV16PacienteSexoDescription ;
   private String AV17PacienteEstadoDescription ;
   private String AV15PacienteEnterarseDescription ;
   private String AV96PageInfo ;
   private String AV93DateInfo ;
   private String AV91AppName ;
   private String AV97Phone ;
   private String AV95Mail ;
   private String AV99Website ;
   private String AV88AddressLine1 ;
   private String AV89AddressLine2 ;
   private String AV90AddressLine3 ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P007R2_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P007R2_A221PacientePeso ;
   private java.math.BigDecimal[] P007R2_A220PacienteEstatura ;
   private short[] P007R2_A6SecUserId ;
   private boolean[] P007R2_n6SecUserId ;
   private short[] P007R2_A43PaisId ;
   private java.util.Date[] P007R2_A213PacienteFechaNacimiento ;
   private int[] P007R2_A20PacienteId ;
   private String[] P007R2_A225PacienteEspecifique ;
   private boolean[] P007R2_n225PacienteEspecifique ;
   private String[] P007R2_A224PacienteEnterarse ;
   private boolean[] P007R2_n224PacienteEnterarse ;
   private String[] P007R2_A222PacienteNombreAnexo ;
   private boolean[] P007R2_n222PacienteNombreAnexo ;
   private String[] P007R2_A44UbigeoCode ;
   private boolean[] P007R2_n44UbigeoCode ;
   private String[] P007R2_A219PacienteEstado ;
   private String[] P007R2_A184PaisDescripcion ;
   private String[] P007R2_A218PacienteTelefono ;
   private String[] P007R2_A217PacienteCorreo ;
   private String[] P007R2_A216PacienteSexo ;
   private String[] P007R2_A215PacienteDireccion ;
   private String[] P007R2_A106PacienteNroDocumento ;
   private String[] P007R2_A214PacienteTipoDocumento ;
   private String[] P007R2_A223PacienteAnexos ;
   private boolean[] P007R2_n223PacienteAnexos ;
   private String[] P007R2_A105PacienteNombres ;
   private String[] P007R2_A104PacienteApellidoMaterno ;
   private String[] P007R2_A103PacienteApellidoPaterno ;
   private String[] P007R2_A188UbigeoDistrito ;
   private String[] P007R2_A187UbigeoProvincia ;
   private String[] P007R2_A186UbigeoDepartamento ;
   private GXSimpleCollection<String> AV36TFPacienteTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV48TFPacienteSexo_Sels ;
   private GXSimpleCollection<String> AV60TFPacienteEstado_Sels ;
   private GXSimpleCollection<String> AV125Pacientewwds_14_tfpacientetipodocumento_sels ;
   private GXSimpleCollection<String> AV130Pacientewwds_19_tfpacientesexo_sels ;
   private GXSimpleCollection<String> AV139Pacientewwds_28_tfpacienteestado_sels ;
   private GXSimpleCollection<String> AV44TFPacienteEnterarse_Sels ;
   private GXSimpleCollection<String> AV152Pacientewwds_41_tfpacienteenterarse_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV20GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV21GridStateFilterValue ;
}

final  class pacientewwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007R2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV125Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV130Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV139Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV152Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV112Pacientewwds_1_filterfulltext ,
                                          int AV113Pacientewwds_2_tfpacienteid ,
                                          int AV114Pacientewwds_3_tfpacienteid_to ,
                                          String AV116Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV115Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV118Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV117Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV120Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV119Pacientewwds_8_tfpacientenombres ,
                                          String AV122Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV121Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV123Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV124Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV125Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV127Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV126Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV129Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV128Pacientewwds_17_tfpacientedireccion ,
                                          int AV130Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV132Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV131Pacientewwds_20_tfpacientecorreo ,
                                          String AV134Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV133Pacientewwds_22_tfpacientetelefono ,
                                          short AV135Pacientewwds_24_tfpaisid ,
                                          short AV136Pacientewwds_25_tfpaisid_to ,
                                          String AV138Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV137Pacientewwds_26_tfpaisdescripcion ,
                                          int AV139Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV140Pacientewwds_29_tfsecuserid ,
                                          short AV141Pacientewwds_30_tfsecuserid_to ,
                                          String AV143Pacientewwds_32_tfubigeocode_sel ,
                                          String AV142Pacientewwds_31_tfubigeocode ,
                                          String AV145Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV144Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV146Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV147Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV148Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV149Pacientewwds_38_tfpacientepeso_to ,
                                          String AV151Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV150Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV152Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV154Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV153Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV155Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV156Pacientewwds_45_tfpacientefecharegistro_to ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          String A215PacienteDireccion ,
                                          String A217PacienteCorreo ,
                                          String A218PacienteTelefono ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          short A6SecUserId ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          java.math.BigDecimal A220PacienteEstatura ,
                                          java.math.BigDecimal A221PacientePeso ,
                                          String A222PacienteNombreAnexo ,
                                          String A225PacienteEspecifique ,
                                          java.util.Date A213PacienteFechaNacimiento ,
                                          java.util.Date A226PacienteFechaRegistro ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[76];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteAnexos], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV112Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
         GXv_int4[19] = (byte)(1) ;
         GXv_int4[20] = (byte)(1) ;
         GXv_int4[21] = (byte)(1) ;
         GXv_int4[22] = (byte)(1) ;
         GXv_int4[23] = (byte)(1) ;
         GXv_int4[24] = (byte)(1) ;
         GXv_int4[25] = (byte)(1) ;
         GXv_int4[26] = (byte)(1) ;
         GXv_int4[27] = (byte)(1) ;
         GXv_int4[28] = (byte)(1) ;
         GXv_int4[29] = (byte)(1) ;
         GXv_int4[30] = (byte)(1) ;
         GXv_int4[31] = (byte)(1) ;
         GXv_int4[32] = (byte)(1) ;
         GXv_int4[33] = (byte)(1) ;
         GXv_int4[34] = (byte)(1) ;
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (0==AV113Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (0==AV114Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV122Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV121Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV122Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV123Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV124Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( AV125Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV125Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV127Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV126Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV128Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( AV130Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV130Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV132Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV131Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV132Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV134Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV133Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV134Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (0==AV135Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( ! (0==AV136Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV138Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV137Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int4[59] = (byte)(1) ;
      }
      if ( AV139Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV139Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV140Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int4[60] = (byte)(1) ;
      }
      if ( ! (0==AV141Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int4[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV143Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV142Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int4[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV143Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int4[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV145Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV144Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV145Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV146Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int4[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV147Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int4[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV148Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int4[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV149Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int4[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV151Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV150Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int4[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV151Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int4[71] = (byte)(1) ;
      }
      if ( AV152Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV152Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV154Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV153Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int4[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV154Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int4[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV155Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int4[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV156Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int4[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombres]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombres] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaNacimiento]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaNacimiento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteSexo]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteSexo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteCorreo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteTelefono]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteTelefono] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstado]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstatura]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstatura] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacientePeso]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacientePeso] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombreAnexo]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombreAnexo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEnterarse]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEnterarse] DESC" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEspecifique]" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEspecifique] DESC" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaRegistro]" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaRegistro] DESC" ;
      }
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P007R2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] , ((Number) dynConstraints[74]).shortValue() , ((Boolean) dynConstraints[75]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007R2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(11, 10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 1);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(15);
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((String[]) buf[21])[0] = rslt.getVarchar(17);
               ((String[]) buf[22])[0] = rslt.getVarchar(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((String[]) buf[24])[0] = rslt.getBLOBFile(20, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((String[]) buf[28])[0] = rslt.getVarchar(23);
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((String[]) buf[31])[0] = rslt.getVarchar(26);
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
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[122]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[123]);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 15);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 15);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 500);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 500);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[130], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[131], 20);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[132]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[133]).shortValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 80);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[136]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[137]).shortValue());
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[138], 10);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[139], 10);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[142], 2);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[143], 2);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[144], 2);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[145], 2);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 100);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 200);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[150], false);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[151], false);
               }
               return;
      }
   }

}

