package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citawwexportreport_impl extends GXWebReport
{
   public citawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean2) ;
         citawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV116Pgmname))}, new String[] {"GxObject"}) );
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
            AV95Title = "Lista de Cita" ;
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
         h420( true, 0) ;
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
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV19TFCitaId) && (0==AV20TFCitaId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFCitaId), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV71TFCitaId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV71TFCitaId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFCitaId_To), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV22TFCitaCode_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Code", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFCitaCode_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFCitaCode)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Code", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFCitaCode, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV23TFPacienteId) && (0==AV24TFPacienteId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFPacienteId), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV72TFPacienteId_To_Description = GXutil.format( "%1 (%2)", "Paciente Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72TFPacienteId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV24TFPacienteId_To), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV26TFPacienteApellidoPaterno_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Apellido Paterno", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFPacienteApellidoPaterno_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV25TFPacienteApellidoPaterno)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Apellido Paterno", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFPacienteApellidoPaterno, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV28TFPacienteApellidoMaterno_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Apellido Materno", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFPacienteApellidoMaterno_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV27TFPacienteApellidoMaterno)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Apellido Materno", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFPacienteApellidoMaterno, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV30TFPacienteNombres_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Nombres", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFPacienteNombres_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFPacienteNombres)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Nombres", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFPacienteNombres, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV32TFPacienteNroDocumento_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Nro Documento", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFPacienteNroDocumento_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFPacienteNroDocumento)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Nro Documento", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFPacienteNroDocumento, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV109TFCitaTipoDiagnostico_Sels.fromJSonString(AV107TFCitaTipoDiagnostico_SelsJson, null);
      if ( ! ( AV109TFCitaTipoDiagnostico_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV119GXV1 = 1 ;
         while ( AV119GXV1 <= AV109TFCitaTipoDiagnostico_Sels.size() )
         {
            AV40TFCitaTipoDiagnostico_Sel = (String)AV109TFCitaTipoDiagnostico_Sels.elementAt(-1+AV119GXV1) ;
            if ( AV84i == 1 )
            {
               AV108TFCitaTipoDiagnostico_SelDscs = "" ;
            }
            else
            {
               AV108TFCitaTipoDiagnostico_SelDscs += ", " ;
            }
            AV110FilterTFCitaTipoDiagnostico_SelValueDescription = com.projectthani.gxdomaintipodiagnostico.getDescription(httpContext,(String)AV40TFCitaTipoDiagnostico_Sel) ;
            AV108TFCitaTipoDiagnostico_SelDscs += AV110FilterTFCitaTipoDiagnostico_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV119GXV1 = (int)(AV119GXV1+1) ;
         }
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Diagnostico", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV108TFCitaTipoDiagnostico_SelDscs, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV41TFSGCitaDisponibilidadId) && (0==AV42TFSGCitaDisponibilidadId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Disponibilidad Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV41TFSGCitaDisponibilidadId), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV74TFSGCitaDisponibilidadId_To_Description = GXutil.format( "%1 (%2)", "Disponibilidad Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV74TFSGCitaDisponibilidadId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV42TFSGCitaDisponibilidadId_To), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFSGCitaDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV44TFSGCitaDisponibilidadFecha_To)) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Disponibilidad Fecha", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV43TFSGCitaDisponibilidadFecha, "99/99/99"), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV75TFSGCitaDisponibilidadFecha_To_Description = GXutil.format( "%1 (%2)", "Disponibilidad Fecha", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV75TFSGCitaDisponibilidadFecha_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV44TFSGCitaDisponibilidadFecha_To, "99/99/99"), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV45TFSGCitaDisponibilidadHoraInicio) && GXutil.dateCompare(GXutil.nullDate(), AV46TFSGCitaDisponibilidadHoraInicio_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Hora Inicio", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV45TFSGCitaDisponibilidadHoraInicio, "99:99"), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV76TFSGCitaDisponibilidadHoraInicio_To_Description = GXutil.format( "%1 (%2)", "Hora Inicio", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV76TFSGCitaDisponibilidadHoraInicio_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV46TFSGCitaDisponibilidadHoraInicio_To, "99:99"), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV111TFSGCitaDisponibilidadHoraFin) && GXutil.dateCompare(GXutil.nullDate(), AV112TFSGCitaDisponibilidadHoraFin_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Hora Fin", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV111TFSGCitaDisponibilidadHoraFin, "99:99"), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV113TFSGCitaDisponibilidadHoraFin_To_Description = GXutil.format( "%1 (%2)", "Hora Fin", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV113TFSGCitaDisponibilidadHoraFin_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV112TFSGCitaDisponibilidadHoraFin_To, "99:99"), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV47TFSGCitaDisponibilidadEspecialidadId) && (0==AV48TFSGCitaDisponibilidadEspecialidadId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Especialidad Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV47TFSGCitaDisponibilidadEspecialidadId), "ZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV77TFSGCitaDisponibilidadEspecialidadId_To_Description = GXutil.format( "%1 (%2)", "Especialidad Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV77TFSGCitaDisponibilidadEspecialidadId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV48TFSGCitaDisponibilidadEspecialidadId_To), "ZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV50TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Especialidad Nombre", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50TFSGCitaDisponibilidadEspecialidadNombre_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV49TFSGCitaDisponibilidadEspecialidadNombre)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Especialidad Nombre", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49TFSGCitaDisponibilidadEspecialidadNombre, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV51TFSGCitaDisponibilidadSedeId) && (0==AV52TFSGCitaDisponibilidadSedeId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Sede Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV51TFSGCitaDisponibilidadSedeId), "ZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV78TFSGCitaDisponibilidadSedeId_To_Description = GXutil.format( "%1 (%2)", "Sede Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV78TFSGCitaDisponibilidadSedeId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV52TFSGCitaDisponibilidadSedeId_To), "ZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV97TFSGCitaDisponibilidadSedeNombre_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Sede Nombre", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV97TFSGCitaDisponibilidadSedeNombre_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV53TFSGCitaDisponibilidadSedeNombre)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Sede Nombre", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53TFSGCitaDisponibilidadSedeNombre, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV55TFSGCitaDisponibilidadClinicaId) && (0==AV56TFSGCitaDisponibilidadClinicaId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Clinica Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV55TFSGCitaDisponibilidadClinicaId), "ZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV80TFSGCitaDisponibilidadClinicaId_To_Description = GXutil.format( "%1 (%2)", "Clinica Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV80TFSGCitaDisponibilidadClinicaId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV56TFSGCitaDisponibilidadClinicaId_To), "ZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV98TFSGCitaDisponibilidadClinicaNombre_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Clinica Nombre", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV98TFSGCitaDisponibilidadClinicaNombre_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV57TFSGCitaDisponibilidadClinicaNombre)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Clinica Nombre", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV57TFSGCitaDisponibilidadClinicaNombre, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV59TFSGCitaDisponibilidadProfesionalId) && (0==AV60TFSGCitaDisponibilidadProfesionalId_To) ) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Profesional Id", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV59TFSGCitaDisponibilidadProfesionalId), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV82TFSGCitaDisponibilidadProfesionalId_To_Description = GXutil.format( "%1 (%2)", "Profesional Id", "Hasta", "", "", "", "", "", "", "") ;
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV82TFSGCitaDisponibilidadProfesionalId_To_Description, "")), 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV60TFSGCitaDisponibilidadProfesionalId_To), "ZZZZZZZ9")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV62TFSGCitaDisponibilidadProFullName_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Full Name", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV62TFSGCitaDisponibilidadProFullName_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV61TFSGCitaDisponibilidadProFullName)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Full Name", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV61TFSGCitaDisponibilidadProFullName, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV64TFSGCitaDisponibilidadProCOP_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Pro COP", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV64TFSGCitaDisponibilidadProCOP_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV63TFSGCitaDisponibilidadProCOP)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Pro COP", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV63TFSGCitaDisponibilidadProCOP, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV67TFCitaEstadoCita_Sels.fromJSonString(AV65TFCitaEstadoCita_SelsJson, null);
      if ( ! ( AV67TFCitaEstadoCita_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV120GXV2 = 1 ;
         while ( AV120GXV2 <= AV67TFCitaEstadoCita_Sels.size() )
         {
            AV68TFCitaEstadoCita_Sel = (String)AV67TFCitaEstadoCita_Sels.elementAt(-1+AV120GXV2) ;
            if ( AV84i == 1 )
            {
               AV66TFCitaEstadoCita_SelDscs = "" ;
            }
            else
            {
               AV66TFCitaEstadoCita_SelDscs += ", " ;
            }
            AV83FilterTFCitaEstadoCita_SelValueDescription = com.projectthani.gxdomainestadocita.getDescription(httpContext,(String)AV68TFCitaEstadoCita_Sel) ;
            AV66TFCitaEstadoCita_SelDscs += AV83FilterTFCitaEstadoCita_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV120GXV2 = (int)(AV120GXV2+1) ;
         }
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado Cita", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV66TFCitaEstadoCita_SelDscs, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV70TFCitaInforme_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Informe", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV70TFCitaInforme_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV69TFCitaInforme)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Informe", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV69TFCitaInforme, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV100TFCitaAntecedentes_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Antecedentes", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV100TFCitaAntecedentes_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV99TFCitaAntecedentes)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Antecedentes", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV99TFCitaAntecedentes, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV102TFCitaLink_Sel)==0) )
      {
         h420( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Link", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV102TFCitaLink_Sel, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV101TFCitaLink)==0) )
         {
            h420( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Link", 25, Gx_line+0, 161, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV101TFCitaLink, "")), 161, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h420( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h420( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 56, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Code", 60, Gx_line+10, 86, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Id", 90, Gx_line+10, 116, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Apellido Paterno", 120, Gx_line+10, 146, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Apellido Materno", 150, Gx_line+10, 176, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Nombres", 180, Gx_line+10, 206, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Nro Documento", 210, Gx_line+10, 236, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Diagnostico", 240, Gx_line+10, 266, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Disponibilidad Id", 270, Gx_line+10, 296, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Disponibilidad Fecha", 300, Gx_line+10, 326, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Hora Inicio", 330, Gx_line+10, 356, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Hora Fin", 360, Gx_line+10, 386, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Especialidad Id", 390, Gx_line+10, 416, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Especialidad Nombre", 420, Gx_line+10, 446, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Sede Id", 450, Gx_line+10, 476, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Sede Nombre", 480, Gx_line+10, 506, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Clinica Id", 510, Gx_line+10, 536, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Clinica Nombre", 540, Gx_line+10, 566, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Profesional Id", 570, Gx_line+10, 596, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Full Name", 600, Gx_line+10, 627, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Pro COP", 631, Gx_line+10, 659, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado Cita", 663, Gx_line+10, 691, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Informe", 695, Gx_line+10, 723, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Antecedentes", 727, Gx_line+10, 755, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Link", 759, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV122Citawwds_1_filterfulltext = AV13FilterFullText ;
      AV123Citawwds_2_tfcitaid = AV19TFCitaId ;
      AV124Citawwds_3_tfcitaid_to = AV20TFCitaId_To ;
      AV125Citawwds_4_tfcitacode = AV21TFCitaCode ;
      AV126Citawwds_5_tfcitacode_sel = AV22TFCitaCode_Sel ;
      AV127Citawwds_6_tfpacienteid = AV23TFPacienteId ;
      AV128Citawwds_7_tfpacienteid_to = AV24TFPacienteId_To ;
      AV129Citawwds_8_tfpacienteapellidopaterno = AV25TFPacienteApellidoPaterno ;
      AV130Citawwds_9_tfpacienteapellidopaterno_sel = AV26TFPacienteApellidoPaterno_Sel ;
      AV131Citawwds_10_tfpacienteapellidomaterno = AV27TFPacienteApellidoMaterno ;
      AV132Citawwds_11_tfpacienteapellidomaterno_sel = AV28TFPacienteApellidoMaterno_Sel ;
      AV133Citawwds_12_tfpacientenombres = AV29TFPacienteNombres ;
      AV134Citawwds_13_tfpacientenombres_sel = AV30TFPacienteNombres_Sel ;
      AV135Citawwds_14_tfpacientenrodocumento = AV31TFPacienteNroDocumento ;
      AV136Citawwds_15_tfpacientenrodocumento_sel = AV32TFPacienteNroDocumento_Sel ;
      AV137Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV138Citawwds_17_tfsgcitadisponibilidadid = AV41TFSGCitaDisponibilidadId ;
      AV139Citawwds_18_tfsgcitadisponibilidadid_to = AV42TFSGCitaDisponibilidadId_To ;
      AV140Citawwds_19_tfsgcitadisponibilidadfecha = AV43TFSGCitaDisponibilidadFecha ;
      AV141Citawwds_20_tfsgcitadisponibilidadfecha_to = AV44TFSGCitaDisponibilidadFecha_To ;
      AV142Citawwds_21_tfsgcitadisponibilidadhorainicio = AV45TFSGCitaDisponibilidadHoraInicio ;
      AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV46TFSGCitaDisponibilidadHoraInicio_To ;
      AV144Citawwds_23_tfsgcitadisponibilidadhorafin = AV111TFSGCitaDisponibilidadHoraFin ;
      AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV112TFSGCitaDisponibilidadHoraFin_To ;
      AV146Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV47TFSGCitaDisponibilidadEspecialidadId ;
      AV147Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV48TFSGCitaDisponibilidadEspecialidadId_To ;
      AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV49TFSGCitaDisponibilidadEspecialidadNombre ;
      AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV50TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV150Citawwds_29_tfsgcitadisponibilidadsedeid = AV51TFSGCitaDisponibilidadSedeId ;
      AV151Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV52TFSGCitaDisponibilidadSedeId_To ;
      AV152Citawwds_31_tfsgcitadisponibilidadsedenombre = AV53TFSGCitaDisponibilidadSedeNombre ;
      AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV97TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV154Citawwds_33_tfsgcitadisponibilidadclinicaid = AV55TFSGCitaDisponibilidadClinicaId ;
      AV155Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV56TFSGCitaDisponibilidadClinicaId_To ;
      AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV57TFSGCitaDisponibilidadClinicaNombre ;
      AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV98TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV59TFSGCitaDisponibilidadProfesionalId ;
      AV159Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV60TFSGCitaDisponibilidadProfesionalId_To ;
      AV160Citawwds_39_tfsgcitadisponibilidadprofullname = AV61TFSGCitaDisponibilidadProFullName ;
      AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV62TFSGCitaDisponibilidadProFullName_Sel ;
      AV162Citawwds_41_tfsgcitadisponibilidadprocop = AV63TFSGCitaDisponibilidadProCOP ;
      AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV64TFSGCitaDisponibilidadProCOP_Sel ;
      AV164Citawwds_43_tfcitaestadocita_sels = AV67TFCitaEstadoCita_Sels ;
      AV165Citawwds_44_tfcitainforme = AV69TFCitaInforme ;
      AV166Citawwds_45_tfcitainforme_sel = AV70TFCitaInforme_Sel ;
      AV167Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV168Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV169Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV170Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A65CitaTipoDiagnostico ,
                                           AV137Citawwds_16_tfcitatipodiagnostico_sels ,
                                           A89CitaEstadoCita ,
                                           AV164Citawwds_43_tfcitaestadocita_sels ,
                                           AV122Citawwds_1_filterfulltext ,
                                           Integer.valueOf(AV123Citawwds_2_tfcitaid) ,
                                           Integer.valueOf(AV124Citawwds_3_tfcitaid_to) ,
                                           AV126Citawwds_5_tfcitacode_sel ,
                                           AV125Citawwds_4_tfcitacode ,
                                           Integer.valueOf(AV127Citawwds_6_tfpacienteid) ,
                                           Integer.valueOf(AV128Citawwds_7_tfpacienteid_to) ,
                                           AV130Citawwds_9_tfpacienteapellidopaterno_sel ,
                                           AV129Citawwds_8_tfpacienteapellidopaterno ,
                                           AV132Citawwds_11_tfpacienteapellidomaterno_sel ,
                                           AV131Citawwds_10_tfpacienteapellidomaterno ,
                                           AV134Citawwds_13_tfpacientenombres_sel ,
                                           AV133Citawwds_12_tfpacientenombres ,
                                           AV136Citawwds_15_tfpacientenrodocumento_sel ,
                                           AV135Citawwds_14_tfpacientenrodocumento ,
                                           Integer.valueOf(AV137Citawwds_16_tfcitatipodiagnostico_sels.size()) ,
                                           Integer.valueOf(AV138Citawwds_17_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV139Citawwds_18_tfsgcitadisponibilidadid_to) ,
                                           AV140Citawwds_19_tfsgcitadisponibilidadfecha ,
                                           AV141Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                           AV142Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                           AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                           AV144Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                           AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                           Short.valueOf(AV146Citawwds_25_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV147Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                           Short.valueOf(AV150Citawwds_29_tfsgcitadisponibilidadsedeid) ,
                                           Short.valueOf(AV151Citawwds_30_tfsgcitadisponibilidadsedeid_to) ,
                                           AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV152Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                           Short.valueOf(AV154Citawwds_33_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV155Citawwds_34_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV158Citawwds_37_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV159Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                           AV160Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                           AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                           AV162Citawwds_41_tfsgcitadisponibilidadprocop ,
                                           Integer.valueOf(AV164Citawwds_43_tfcitaestadocita_sels.size()) ,
                                           AV166Citawwds_45_tfcitainforme_sel ,
                                           AV165Citawwds_44_tfcitainforme ,
                                           AV168Citawwds_47_tfcitaantecedentes_sel ,
                                           AV167Citawwds_46_tfcitaantecedentes ,
                                           AV170Citawwds_49_tfcitalink_sel ,
                                           AV169Citawwds_48_tfcitalink ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Short.valueOf(A72SGCitaDisponibilidadSedeId) ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A87SGCitaDisponibilidadProCOP ,
                                           A90CitaInforme ,
                                           A100CitaAntecedentes ,
                                           A91CitaLink ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV122Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV122Citawwds_1_filterfulltext), "%", "") ;
      lV125Citawwds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV125Citawwds_4_tfcitacode), "%", "") ;
      lV129Citawwds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV129Citawwds_8_tfpacienteapellidopaterno), "%", "") ;
      lV131Citawwds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV131Citawwds_10_tfpacienteapellidomaterno), "%", "") ;
      lV133Citawwds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV133Citawwds_12_tfpacientenombres), "%", "") ;
      lV135Citawwds_14_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV135Citawwds_14_tfpacientenrodocumento), "%", "") ;
      lV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV152Citawwds_31_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV152Citawwds_31_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV156Citawwds_35_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV160Citawwds_39_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV160Citawwds_39_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV162Citawwds_41_tfsgcitadisponibilidadprocop = GXutil.concat( GXutil.rtrim( AV162Citawwds_41_tfsgcitadisponibilidadprocop), "%", "") ;
      lV165Citawwds_44_tfcitainforme = GXutil.concat( GXutil.rtrim( AV165Citawwds_44_tfcitainforme), "%", "") ;
      lV167Citawwds_46_tfcitaantecedentes = GXutil.concat( GXutil.rtrim( AV167Citawwds_46_tfcitaantecedentes), "%", "") ;
      lV169Citawwds_48_tfcitalink = GXutil.concat( GXutil.rtrim( AV169Citawwds_48_tfcitalink), "%", "") ;
      /* Using cursor P00422 */
      pr_default.execute(0, new Object[] {lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, lV122Citawwds_1_filterfulltext, Integer.valueOf(AV123Citawwds_2_tfcitaid), Integer.valueOf(AV124Citawwds_3_tfcitaid_to), lV125Citawwds_4_tfcitacode, AV126Citawwds_5_tfcitacode_sel, Integer.valueOf(AV127Citawwds_6_tfpacienteid), Integer.valueOf(AV128Citawwds_7_tfpacienteid_to), lV129Citawwds_8_tfpacienteapellidopaterno, AV130Citawwds_9_tfpacienteapellidopaterno_sel, lV131Citawwds_10_tfpacienteapellidomaterno, AV132Citawwds_11_tfpacienteapellidomaterno_sel, lV133Citawwds_12_tfpacientenombres, AV134Citawwds_13_tfpacientenombres_sel, lV135Citawwds_14_tfpacientenrodocumento, AV136Citawwds_15_tfpacientenrodocumento_sel, Integer.valueOf(AV138Citawwds_17_tfsgcitadisponibilidadid), Integer.valueOf(AV139Citawwds_18_tfsgcitadisponibilidadid_to), AV140Citawwds_19_tfsgcitadisponibilidadfecha, AV141Citawwds_20_tfsgcitadisponibilidadfecha_to, AV142Citawwds_21_tfsgcitadisponibilidadhorainicio, AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to, AV144Citawwds_23_tfsgcitadisponibilidadhorafin, AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to, Short.valueOf(AV146Citawwds_25_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV147Citawwds_26_tfsgcitadisponibilidadespecialidadid_to), lV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre, AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel, Short.valueOf(AV150Citawwds_29_tfsgcitadisponibilidadsedeid), Short.valueOf(AV151Citawwds_30_tfsgcitadisponibilidadsedeid_to), lV152Citawwds_31_tfsgcitadisponibilidadsedenombre, AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel, Short.valueOf(AV154Citawwds_33_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV155Citawwds_34_tfsgcitadisponibilidadclinicaid_to), lV156Citawwds_35_tfsgcitadisponibilidadclinicanombre, AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel, Integer.valueOf(AV158Citawwds_37_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV159Citawwds_38_tfsgcitadisponibilidadprofesionalid_to), lV160Citawwds_39_tfsgcitadisponibilidadprofullname, AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel, lV162Citawwds_41_tfsgcitadisponibilidadprocop, AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel, lV165Citawwds_44_tfcitainforme, AV166Citawwds_45_tfcitainforme_sel, lV167Citawwds_46_tfcitaantecedentes, AV168Citawwds_47_tfcitaantecedentes_sel, lV169Citawwds_48_tfcitalink, AV170Citawwds_49_tfcitalink_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A81SGCitaDisponibilidadProfesionalId = P00422_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00422_A76SGCitaDisponibilidadClinicaId[0] ;
         A72SGCitaDisponibilidadSedeId = P00422_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00422_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A387SGCitaDisponibilidadHoraFin = P00422_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P00422_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P00422_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P00422_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P00422_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00422_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00422_A21SGCitaDisponibilidadId[0] ;
         A20PacienteId = P00422_A20PacienteId[0] ;
         A19CitaId = P00422_A19CitaId[0] ;
         A91CitaLink = P00422_A91CitaLink[0] ;
         n91CitaLink = P00422_n91CitaLink[0] ;
         A100CitaAntecedentes = P00422_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = P00422_n100CitaAntecedentes[0] ;
         A90CitaInforme = P00422_A90CitaInforme[0] ;
         n90CitaInforme = P00422_n90CitaInforme[0] ;
         A89CitaEstadoCita = P00422_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P00422_n89CitaEstadoCita[0] ;
         A87SGCitaDisponibilidadProCOP = P00422_A87SGCitaDisponibilidadProCOP[0] ;
         A82SGCitaDisponibilidadProFullName = P00422_A82SGCitaDisponibilidadProFullName[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00422_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P00422_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00422_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A65CitaTipoDiagnostico = P00422_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = P00422_n65CitaTipoDiagnostico[0] ;
         A106PacienteNroDocumento = P00422_A106PacienteNroDocumento[0] ;
         A105PacienteNombres = P00422_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00422_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00422_A103PacienteApellidoPaterno[0] ;
         A64CitaCode = P00422_A64CitaCode[0] ;
         A84ProfesionalNombres = P00422_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00422_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00422_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00422_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00422_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00422_n86ProfesionalApellidoMaterno[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00422_A81SGCitaDisponibilidadProfesionalId[0] ;
         A72SGCitaDisponibilidadSedeId = P00422_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00422_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A387SGCitaDisponibilidadHoraFin = P00422_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P00422_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P00422_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P00422_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P00422_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00422_n66SGCitaDisponibilidadFecha[0] ;
         A87SGCitaDisponibilidadProCOP = P00422_A87SGCitaDisponibilidadProCOP[0] ;
         A84ProfesionalNombres = P00422_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00422_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00422_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00422_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00422_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00422_n86ProfesionalApellidoMaterno[0] ;
         A76SGCitaDisponibilidadClinicaId = P00422_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P00422_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00422_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00422_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A106PacienteNroDocumento = P00422_A106PacienteNroDocumento[0] ;
         A105PacienteNombres = P00422_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00422_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00422_A103PacienteApellidoPaterno[0] ;
         AV106CitaTipoDiagnosticoDescription = com.projectthani.gxdomaintipodiagnostico.getDescription(httpContext,(String)A65CitaTipoDiagnostico) ;
         AV14CitaEstadoCitaDescription = com.projectthani.gxdomainestadocita.getDescription(httpContext,(String)A89CitaEstadoCita) ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
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
         h420( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), 30, Gx_line+10, 56, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A64CitaCode, "")), 60, Gx_line+10, 86, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")), 90, Gx_line+10, 116, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), 120, Gx_line+10, 146, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), 150, Gx_line+10, 176, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), 180, Gx_line+10, 206, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A106PacienteNroDocumento, "")), 210, Gx_line+10, 236, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV106CitaTipoDiagnosticoDescription, "")), 240, Gx_line+10, 266, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9")), 270, Gx_line+10, 296, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), 300, Gx_line+10, 326, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A68SGCitaDisponibilidadHoraInicio, "99:99"), 330, Gx_line+10, 356, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A387SGCitaDisponibilidadHoraFin, "99:99"), 360, Gx_line+10, 386, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9")), 390, Gx_line+10, 416, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A146SGCitaDisponibilidadEspecialidadNombre, "")), 420, Gx_line+10, 446, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), "ZZZ9")), 450, Gx_line+10, 476, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A73SGCitaDisponibilidadSedeNombre, "")), 480, Gx_line+10, 506, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9")), 510, Gx_line+10, 536, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A78SGCitaDisponibilidadClinicaNombre, "")), 540, Gx_line+10, 566, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9")), 570, Gx_line+10, 596, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A82SGCitaDisponibilidadProFullName, "")), 600, Gx_line+10, 627, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A87SGCitaDisponibilidadProCOP, "")), 631, Gx_line+10, 659, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14CitaEstadoCitaDescription, "")), 663, Gx_line+10, 691, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A90CitaInforme, 695, Gx_line+10, 723, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A100CitaAntecedentes, 727, Gx_line+10, 755, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A91CitaLink, "")), 759, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
            pr_default.close(0);
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
      if ( GXutil.strcmp(AV15Session.getValue("CitaWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CitaWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("CitaWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV171GXV3 = 1 ;
      while ( AV171GXV3 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV171GXV3));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV19TFCitaId = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFCitaId_To = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV21TFCitaCode = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV22TFCitaCode_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV23TFPacienteId = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFPacienteId_To = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV25TFPacienteApellidoPaterno = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV26TFPacienteApellidoPaterno_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV27TFPacienteApellidoMaterno = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV28TFPacienteApellidoMaterno_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV29TFPacienteNombres = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV30TFPacienteNombres_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV31TFPacienteNroDocumento = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV32TFPacienteNroDocumento_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITATIPODIAGNOSTICO_SEL") == 0 )
         {
            AV107TFCitaTipoDiagnostico_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV109TFCitaTipoDiagnostico_Sels.fromJSonString(AV107TFCitaTipoDiagnostico_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV41TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV43TFSGCitaDisponibilidadFecha = localUtil.ctod( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV44TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAINICIO") == 0 )
         {
            AV45TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV46TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAFIN") == 0 )
         {
            AV111TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV112TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV47TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV48TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV49TFSGCitaDisponibilidadEspecialidadNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV50TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDEID") == 0 )
         {
            AV51TFSGCitaDisponibilidadSedeId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV52TFSGCitaDisponibilidadSedeId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE") == 0 )
         {
            AV53TFSGCitaDisponibilidadSedeNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE_SEL") == 0 )
         {
            AV97TFSGCitaDisponibilidadSedeNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV55TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV57TFSGCitaDisponibilidadClinicaNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV98TFSGCitaDisponibilidadClinicaNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV59TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV60TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV61TFSGCitaDisponibilidadProFullName = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV62TFSGCitaDisponibilidadProFullName_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROCOP") == 0 )
         {
            AV63TFSGCitaDisponibilidadProCOP = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROCOP_SEL") == 0 )
         {
            AV64TFSGCitaDisponibilidadProCOP_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOCITA_SEL") == 0 )
         {
            AV65TFCitaEstadoCita_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFCitaEstadoCita_Sels.fromJSonString(AV65TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAINFORME") == 0 )
         {
            AV69TFCitaInforme = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAINFORME_SEL") == 0 )
         {
            AV70TFCitaInforme_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAANTECEDENTES") == 0 )
         {
            AV99TFCitaAntecedentes = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAANTECEDENTES_SEL") == 0 )
         {
            AV100TFCitaAntecedentes_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITALINK") == 0 )
         {
            AV101TFCitaLink = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITALINK_SEL") == 0 )
         {
            AV102TFCitaLink_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV171GXV3 = (int)(AV171GXV3+1) ;
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

   public void h420( boolean bFoot ,
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
               AV93PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV90DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV93PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV90DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV88AppName = "DVelop Software Solutions" ;
            AV94Phone = "+1 550 8923" ;
            AV92Mail = "info@mail.com" ;
            AV96Website = "http://www.web.com" ;
            AV85AddressLine1 = "French Boulevard 2859" ;
            AV86AddressLine2 = "Downtown" ;
            AV87AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV88AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV95Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV94Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV92Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV96Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV85AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV86AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV87AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV116Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV95Title = "" ;
      AV13FilterFullText = "" ;
      AV71TFCitaId_To_Description = "" ;
      AV22TFCitaCode_Sel = "" ;
      AV21TFCitaCode = "" ;
      AV72TFPacienteId_To_Description = "" ;
      AV26TFPacienteApellidoPaterno_Sel = "" ;
      AV25TFPacienteApellidoPaterno = "" ;
      AV28TFPacienteApellidoMaterno_Sel = "" ;
      AV27TFPacienteApellidoMaterno = "" ;
      AV30TFPacienteNombres_Sel = "" ;
      AV29TFPacienteNombres = "" ;
      AV32TFPacienteNroDocumento_Sel = "" ;
      AV31TFPacienteNroDocumento = "" ;
      AV109TFCitaTipoDiagnostico_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV107TFCitaTipoDiagnostico_SelsJson = "" ;
      AV40TFCitaTipoDiagnostico_Sel = "" ;
      AV108TFCitaTipoDiagnostico_SelDscs = "" ;
      AV110FilterTFCitaTipoDiagnostico_SelValueDescription = "" ;
      AV74TFSGCitaDisponibilidadId_To_Description = "" ;
      AV43TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV44TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV75TFSGCitaDisponibilidadFecha_To_Description = "" ;
      AV45TFSGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV46TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV76TFSGCitaDisponibilidadHoraInicio_To_Description = "" ;
      AV111TFSGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV112TFSGCitaDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV113TFSGCitaDisponibilidadHoraFin_To_Description = "" ;
      AV77TFSGCitaDisponibilidadEspecialidadId_To_Description = "" ;
      AV50TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV49TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV78TFSGCitaDisponibilidadSedeId_To_Description = "" ;
      AV97TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      AV53TFSGCitaDisponibilidadSedeNombre = "" ;
      AV80TFSGCitaDisponibilidadClinicaId_To_Description = "" ;
      AV98TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV57TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV82TFSGCitaDisponibilidadProfesionalId_To_Description = "" ;
      AV62TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV61TFSGCitaDisponibilidadProFullName = "" ;
      AV64TFSGCitaDisponibilidadProCOP_Sel = "" ;
      AV63TFSGCitaDisponibilidadProCOP = "" ;
      AV67TFCitaEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65TFCitaEstadoCita_SelsJson = "" ;
      AV68TFCitaEstadoCita_Sel = "" ;
      AV66TFCitaEstadoCita_SelDscs = "" ;
      AV83FilterTFCitaEstadoCita_SelValueDescription = "" ;
      AV70TFCitaInforme_Sel = "" ;
      AV69TFCitaInforme = "" ;
      AV100TFCitaAntecedentes_Sel = "" ;
      AV99TFCitaAntecedentes = "" ;
      AV102TFCitaLink_Sel = "" ;
      AV101TFCitaLink = "" ;
      A65CitaTipoDiagnostico = "" ;
      A89CitaEstadoCita = "" ;
      A64CitaCode = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A91CitaLink = "" ;
      AV122Citawwds_1_filterfulltext = "" ;
      AV125Citawwds_4_tfcitacode = "" ;
      AV126Citawwds_5_tfcitacode_sel = "" ;
      AV129Citawwds_8_tfpacienteapellidopaterno = "" ;
      AV130Citawwds_9_tfpacienteapellidopaterno_sel = "" ;
      AV131Citawwds_10_tfpacienteapellidomaterno = "" ;
      AV132Citawwds_11_tfpacienteapellidomaterno_sel = "" ;
      AV133Citawwds_12_tfpacientenombres = "" ;
      AV134Citawwds_13_tfpacientenombres_sel = "" ;
      AV135Citawwds_14_tfpacientenrodocumento = "" ;
      AV136Citawwds_15_tfpacientenrodocumento_sel = "" ;
      AV137Citawwds_16_tfcitatipodiagnostico_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV140Citawwds_19_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV141Citawwds_20_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV142Citawwds_21_tfsgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV144Citawwds_23_tfsgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV152Citawwds_31_tfsgcitadisponibilidadsedenombre = "" ;
      AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = "" ;
      AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre = "" ;
      AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV160Citawwds_39_tfsgcitadisponibilidadprofullname = "" ;
      AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV162Citawwds_41_tfsgcitadisponibilidadprocop = "" ;
      AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel = "" ;
      AV164Citawwds_43_tfcitaestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV165Citawwds_44_tfcitainforme = "" ;
      AV166Citawwds_45_tfcitainforme_sel = "" ;
      AV167Citawwds_46_tfcitaantecedentes = "" ;
      AV168Citawwds_47_tfcitaantecedentes_sel = "" ;
      AV169Citawwds_48_tfcitalink = "" ;
      AV170Citawwds_49_tfcitalink_sel = "" ;
      scmdbuf = "" ;
      lV122Citawwds_1_filterfulltext = "" ;
      lV125Citawwds_4_tfcitacode = "" ;
      lV129Citawwds_8_tfpacienteapellidopaterno = "" ;
      lV131Citawwds_10_tfpacienteapellidomaterno = "" ;
      lV133Citawwds_12_tfpacientenombres = "" ;
      lV135Citawwds_14_tfpacientenrodocumento = "" ;
      lV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV152Citawwds_31_tfsgcitadisponibilidadsedenombre = "" ;
      lV156Citawwds_35_tfsgcitadisponibilidadclinicanombre = "" ;
      lV160Citawwds_39_tfsgcitadisponibilidadprofullname = "" ;
      lV162Citawwds_41_tfsgcitadisponibilidadprocop = "" ;
      lV165Citawwds_44_tfcitainforme = "" ;
      lV167Citawwds_46_tfcitaantecedentes = "" ;
      lV169Citawwds_48_tfcitalink = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      P00422_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00422_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00422_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00422_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00422_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P00422_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P00422_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P00422_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P00422_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00422_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00422_A21SGCitaDisponibilidadId = new int[1] ;
      P00422_A20PacienteId = new int[1] ;
      P00422_A19CitaId = new int[1] ;
      P00422_A91CitaLink = new String[] {""} ;
      P00422_n91CitaLink = new boolean[] {false} ;
      P00422_A100CitaAntecedentes = new String[] {""} ;
      P00422_n100CitaAntecedentes = new boolean[] {false} ;
      P00422_A90CitaInforme = new String[] {""} ;
      P00422_n90CitaInforme = new boolean[] {false} ;
      P00422_A89CitaEstadoCita = new String[] {""} ;
      P00422_n89CitaEstadoCita = new boolean[] {false} ;
      P00422_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      P00422_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00422_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00422_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P00422_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00422_A65CitaTipoDiagnostico = new String[] {""} ;
      P00422_n65CitaTipoDiagnostico = new boolean[] {false} ;
      P00422_A106PacienteNroDocumento = new String[] {""} ;
      P00422_A105PacienteNombres = new String[] {""} ;
      P00422_A104PacienteApellidoMaterno = new String[] {""} ;
      P00422_A103PacienteApellidoPaterno = new String[] {""} ;
      P00422_A64CitaCode = new String[] {""} ;
      P00422_A84ProfesionalNombres = new String[] {""} ;
      P00422_n84ProfesionalNombres = new boolean[] {false} ;
      P00422_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00422_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00422_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00422_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      AV106CitaTipoDiagnosticoDescription = "" ;
      AV14CitaEstadoCitaDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV93PageInfo = "" ;
      AV90DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV88AppName = "" ;
      AV94Phone = "" ;
      AV92Mail = "" ;
      AV96Website = "" ;
      AV85AddressLine1 = "" ;
      AV86AddressLine2 = "" ;
      AV87AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citawwexportreport__default(),
         new Object[] {
             new Object[] {
            P00422_A81SGCitaDisponibilidadProfesionalId, P00422_A76SGCitaDisponibilidadClinicaId, P00422_A72SGCitaDisponibilidadSedeId, P00422_A70SGCitaDisponibilidadEspecialidadId, P00422_A387SGCitaDisponibilidadHoraFin, P00422_n387SGCitaDisponibilidadHoraFin, P00422_A68SGCitaDisponibilidadHoraInicio, P00422_n68SGCitaDisponibilidadHoraInicio, P00422_A66SGCitaDisponibilidadFecha, P00422_n66SGCitaDisponibilidadFecha,
            P00422_A21SGCitaDisponibilidadId, P00422_A20PacienteId, P00422_A19CitaId, P00422_A91CitaLink, P00422_n91CitaLink, P00422_A100CitaAntecedentes, P00422_n100CitaAntecedentes, P00422_A90CitaInforme, P00422_n90CitaInforme, P00422_A89CitaEstadoCita,
            P00422_n89CitaEstadoCita, P00422_A87SGCitaDisponibilidadProCOP, P00422_A82SGCitaDisponibilidadProFullName, P00422_A78SGCitaDisponibilidadClinicaNombre, P00422_A73SGCitaDisponibilidadSedeNombre, P00422_A146SGCitaDisponibilidadEspecialidadNombre, P00422_A65CitaTipoDiagnostico, P00422_n65CitaTipoDiagnostico, P00422_A106PacienteNroDocumento, P00422_A105PacienteNombres,
            P00422_A104PacienteApellidoMaterno, P00422_A103PacienteApellidoPaterno, P00422_A64CitaCode, P00422_A84ProfesionalNombres, P00422_n84ProfesionalNombres, P00422_A85ProfesionalApellidoPaterno, P00422_n85ProfesionalApellidoPaterno, P00422_A86ProfesionalApellidoMaterno, P00422_n86ProfesionalApellidoMaterno
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV116Pgmname = "CitaWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV116Pgmname = "CitaWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV47TFSGCitaDisponibilidadEspecialidadId ;
   private short AV48TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV51TFSGCitaDisponibilidadSedeId ;
   private short AV52TFSGCitaDisponibilidadSedeId_To ;
   private short AV55TFSGCitaDisponibilidadClinicaId ;
   private short AV56TFSGCitaDisponibilidadClinicaId_To ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short AV146Citawwds_25_tfsgcitadisponibilidadespecialidadid ;
   private short AV147Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV150Citawwds_29_tfsgcitadisponibilidadsedeid ;
   private short AV151Citawwds_30_tfsgcitadisponibilidadsedeid_to ;
   private short AV154Citawwds_33_tfsgcitadisponibilidadclinicaid ;
   private short AV155Citawwds_34_tfsgcitadisponibilidadclinicaid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV19TFCitaId ;
   private int AV20TFCitaId_To ;
   private int AV23TFPacienteId ;
   private int AV24TFPacienteId_To ;
   private int AV119GXV1 ;
   private int AV41TFSGCitaDisponibilidadId ;
   private int AV42TFSGCitaDisponibilidadId_To ;
   private int AV59TFSGCitaDisponibilidadProfesionalId ;
   private int AV60TFSGCitaDisponibilidadProfesionalId_To ;
   private int AV120GXV2 ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int AV123Citawwds_2_tfcitaid ;
   private int AV124Citawwds_3_tfcitaid_to ;
   private int AV127Citawwds_6_tfpacienteid ;
   private int AV128Citawwds_7_tfpacienteid_to ;
   private int AV138Citawwds_17_tfsgcitadisponibilidadid ;
   private int AV139Citawwds_18_tfsgcitadisponibilidadid_to ;
   private int AV158Citawwds_37_tfsgcitadisponibilidadprofesionalid ;
   private int AV159Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV137Citawwds_16_tfcitatipodiagnostico_sels_size ;
   private int AV164Citawwds_43_tfcitaestadocita_sels_size ;
   private int AV171GXV3 ;
   private long AV84i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV116Pgmname ;
   private String AV68TFCitaEstadoCita_Sel ;
   private String A89CitaEstadoCita ;
   private String scmdbuf ;
   private java.util.Date AV45TFSGCitaDisponibilidadHoraInicio ;
   private java.util.Date AV46TFSGCitaDisponibilidadHoraInicio_To ;
   private java.util.Date AV111TFSGCitaDisponibilidadHoraFin ;
   private java.util.Date AV112TFSGCitaDisponibilidadHoraFin_To ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date AV142Citawwds_21_tfsgcitadisponibilidadhorainicio ;
   private java.util.Date AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to ;
   private java.util.Date AV144Citawwds_23_tfsgcitadisponibilidadhorafin ;
   private java.util.Date AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to ;
   private java.util.Date AV43TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV44TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV140Citawwds_19_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV141Citawwds_20_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n91CitaLink ;
   private boolean n100CitaAntecedentes ;
   private boolean n90CitaInforme ;
   private boolean n89CitaEstadoCita ;
   private boolean n65CitaTipoDiagnostico ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private String AV107TFCitaTipoDiagnostico_SelsJson ;
   private String AV65TFCitaEstadoCita_SelsJson ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String AV95Title ;
   private String AV13FilterFullText ;
   private String AV71TFCitaId_To_Description ;
   private String AV22TFCitaCode_Sel ;
   private String AV21TFCitaCode ;
   private String AV72TFPacienteId_To_Description ;
   private String AV26TFPacienteApellidoPaterno_Sel ;
   private String AV25TFPacienteApellidoPaterno ;
   private String AV28TFPacienteApellidoMaterno_Sel ;
   private String AV27TFPacienteApellidoMaterno ;
   private String AV30TFPacienteNombres_Sel ;
   private String AV29TFPacienteNombres ;
   private String AV32TFPacienteNroDocumento_Sel ;
   private String AV31TFPacienteNroDocumento ;
   private String AV40TFCitaTipoDiagnostico_Sel ;
   private String AV108TFCitaTipoDiagnostico_SelDscs ;
   private String AV110FilterTFCitaTipoDiagnostico_SelValueDescription ;
   private String AV74TFSGCitaDisponibilidadId_To_Description ;
   private String AV75TFSGCitaDisponibilidadFecha_To_Description ;
   private String AV76TFSGCitaDisponibilidadHoraInicio_To_Description ;
   private String AV113TFSGCitaDisponibilidadHoraFin_To_Description ;
   private String AV77TFSGCitaDisponibilidadEspecialidadId_To_Description ;
   private String AV50TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV49TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV78TFSGCitaDisponibilidadSedeId_To_Description ;
   private String AV97TFSGCitaDisponibilidadSedeNombre_Sel ;
   private String AV53TFSGCitaDisponibilidadSedeNombre ;
   private String AV80TFSGCitaDisponibilidadClinicaId_To_Description ;
   private String AV98TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV57TFSGCitaDisponibilidadClinicaNombre ;
   private String AV82TFSGCitaDisponibilidadProfesionalId_To_Description ;
   private String AV62TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV61TFSGCitaDisponibilidadProFullName ;
   private String AV64TFSGCitaDisponibilidadProCOP_Sel ;
   private String AV63TFSGCitaDisponibilidadProCOP ;
   private String AV66TFCitaEstadoCita_SelDscs ;
   private String AV83FilterTFCitaEstadoCita_SelValueDescription ;
   private String AV70TFCitaInforme_Sel ;
   private String AV69TFCitaInforme ;
   private String AV100TFCitaAntecedentes_Sel ;
   private String AV99TFCitaAntecedentes ;
   private String AV102TFCitaLink_Sel ;
   private String AV101TFCitaLink ;
   private String A65CitaTipoDiagnostico ;
   private String A64CitaCode ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String A91CitaLink ;
   private String AV122Citawwds_1_filterfulltext ;
   private String AV125Citawwds_4_tfcitacode ;
   private String AV126Citawwds_5_tfcitacode_sel ;
   private String AV129Citawwds_8_tfpacienteapellidopaterno ;
   private String AV130Citawwds_9_tfpacienteapellidopaterno_sel ;
   private String AV131Citawwds_10_tfpacienteapellidomaterno ;
   private String AV132Citawwds_11_tfpacienteapellidomaterno_sel ;
   private String AV133Citawwds_12_tfpacientenombres ;
   private String AV134Citawwds_13_tfpacientenombres_sel ;
   private String AV135Citawwds_14_tfpacientenrodocumento ;
   private String AV136Citawwds_15_tfpacientenrodocumento_sel ;
   private String AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV152Citawwds_31_tfsgcitadisponibilidadsedenombre ;
   private String AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ;
   private String AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre ;
   private String AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV160Citawwds_39_tfsgcitadisponibilidadprofullname ;
   private String AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel ;
   private String AV162Citawwds_41_tfsgcitadisponibilidadprocop ;
   private String AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel ;
   private String AV165Citawwds_44_tfcitainforme ;
   private String AV166Citawwds_45_tfcitainforme_sel ;
   private String AV167Citawwds_46_tfcitaantecedentes ;
   private String AV168Citawwds_47_tfcitaantecedentes_sel ;
   private String AV169Citawwds_48_tfcitalink ;
   private String AV170Citawwds_49_tfcitalink_sel ;
   private String lV122Citawwds_1_filterfulltext ;
   private String lV125Citawwds_4_tfcitacode ;
   private String lV129Citawwds_8_tfpacienteapellidopaterno ;
   private String lV131Citawwds_10_tfpacienteapellidomaterno ;
   private String lV133Citawwds_12_tfpacientenombres ;
   private String lV135Citawwds_14_tfpacientenrodocumento ;
   private String lV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV152Citawwds_31_tfsgcitadisponibilidadsedenombre ;
   private String lV156Citawwds_35_tfsgcitadisponibilidadclinicanombre ;
   private String lV160Citawwds_39_tfsgcitadisponibilidadprofullname ;
   private String lV162Citawwds_41_tfsgcitadisponibilidadprocop ;
   private String lV165Citawwds_44_tfcitainforme ;
   private String lV167Citawwds_46_tfcitaantecedentes ;
   private String lV169Citawwds_48_tfcitalink ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String AV106CitaTipoDiagnosticoDescription ;
   private String AV14CitaEstadoCitaDescription ;
   private String AV93PageInfo ;
   private String AV90DateInfo ;
   private String AV88AppName ;
   private String AV94Phone ;
   private String AV92Mail ;
   private String AV96Website ;
   private String AV85AddressLine1 ;
   private String AV86AddressLine2 ;
   private String AV87AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private int[] P00422_A81SGCitaDisponibilidadProfesionalId ;
   private short[] P00422_A76SGCitaDisponibilidadClinicaId ;
   private short[] P00422_A72SGCitaDisponibilidadSedeId ;
   private short[] P00422_A70SGCitaDisponibilidadEspecialidadId ;
   private java.util.Date[] P00422_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P00422_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P00422_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P00422_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P00422_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00422_n66SGCitaDisponibilidadFecha ;
   private int[] P00422_A21SGCitaDisponibilidadId ;
   private int[] P00422_A20PacienteId ;
   private int[] P00422_A19CitaId ;
   private String[] P00422_A91CitaLink ;
   private boolean[] P00422_n91CitaLink ;
   private String[] P00422_A100CitaAntecedentes ;
   private boolean[] P00422_n100CitaAntecedentes ;
   private String[] P00422_A90CitaInforme ;
   private boolean[] P00422_n90CitaInforme ;
   private String[] P00422_A89CitaEstadoCita ;
   private boolean[] P00422_n89CitaEstadoCita ;
   private String[] P00422_A87SGCitaDisponibilidadProCOP ;
   private String[] P00422_A82SGCitaDisponibilidadProFullName ;
   private String[] P00422_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00422_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P00422_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00422_A65CitaTipoDiagnostico ;
   private boolean[] P00422_n65CitaTipoDiagnostico ;
   private String[] P00422_A106PacienteNroDocumento ;
   private String[] P00422_A105PacienteNombres ;
   private String[] P00422_A104PacienteApellidoMaterno ;
   private String[] P00422_A103PacienteApellidoPaterno ;
   private String[] P00422_A64CitaCode ;
   private String[] P00422_A84ProfesionalNombres ;
   private boolean[] P00422_n84ProfesionalNombres ;
   private String[] P00422_A85ProfesionalApellidoPaterno ;
   private boolean[] P00422_n85ProfesionalApellidoPaterno ;
   private String[] P00422_A86ProfesionalApellidoMaterno ;
   private boolean[] P00422_n86ProfesionalApellidoMaterno ;
   private GXSimpleCollection<String> AV67TFCitaEstadoCita_Sels ;
   private GXSimpleCollection<String> AV164Citawwds_43_tfcitaestadocita_sels ;
   private GXSimpleCollection<String> AV109TFCitaTipoDiagnostico_Sels ;
   private GXSimpleCollection<String> AV137Citawwds_16_tfcitatipodiagnostico_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class citawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00422( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A65CitaTipoDiagnostico ,
                                          GXSimpleCollection<String> AV137Citawwds_16_tfcitatipodiagnostico_sels ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV164Citawwds_43_tfcitaestadocita_sels ,
                                          String AV122Citawwds_1_filterfulltext ,
                                          int AV123Citawwds_2_tfcitaid ,
                                          int AV124Citawwds_3_tfcitaid_to ,
                                          String AV126Citawwds_5_tfcitacode_sel ,
                                          String AV125Citawwds_4_tfcitacode ,
                                          int AV127Citawwds_6_tfpacienteid ,
                                          int AV128Citawwds_7_tfpacienteid_to ,
                                          String AV130Citawwds_9_tfpacienteapellidopaterno_sel ,
                                          String AV129Citawwds_8_tfpacienteapellidopaterno ,
                                          String AV132Citawwds_11_tfpacienteapellidomaterno_sel ,
                                          String AV131Citawwds_10_tfpacienteapellidomaterno ,
                                          String AV134Citawwds_13_tfpacientenombres_sel ,
                                          String AV133Citawwds_12_tfpacientenombres ,
                                          String AV136Citawwds_15_tfpacientenrodocumento_sel ,
                                          String AV135Citawwds_14_tfpacientenrodocumento ,
                                          int AV137Citawwds_16_tfcitatipodiagnostico_sels_size ,
                                          int AV138Citawwds_17_tfsgcitadisponibilidadid ,
                                          int AV139Citawwds_18_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV140Citawwds_19_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV141Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV142Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                          java.util.Date AV144Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                          short AV146Citawwds_25_tfsgcitadisponibilidadespecialidadid ,
                                          short AV147Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                          short AV150Citawwds_29_tfsgcitadisponibilidadsedeid ,
                                          short AV151Citawwds_30_tfsgcitadisponibilidadsedeid_to ,
                                          String AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV152Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                          short AV154Citawwds_33_tfsgcitadisponibilidadclinicaid ,
                                          short AV155Citawwds_34_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                          int AV158Citawwds_37_tfsgcitadisponibilidadprofesionalid ,
                                          int AV159Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV160Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                          String AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                          String AV162Citawwds_41_tfsgcitadisponibilidadprocop ,
                                          int AV164Citawwds_43_tfcitaestadocita_sels_size ,
                                          String AV166Citawwds_45_tfcitainforme_sel ,
                                          String AV165Citawwds_44_tfcitainforme ,
                                          String AV168Citawwds_47_tfcitaantecedentes_sel ,
                                          String AV167Citawwds_46_tfcitaantecedentes ,
                                          String AV170Citawwds_49_tfcitalink_sel ,
                                          String AV169Citawwds_48_tfcitalink ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          int A21SGCitaDisponibilidadId ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          short A72SGCitaDisponibilidadSedeId ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A87SGCitaDisponibilidadProCOP ,
                                          String A90CitaInforme ,
                                          String A100CitaAntecedentes ,
                                          String A91CitaLink ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[75];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T4.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId," ;
      scmdbuf += " T2.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T2.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T2.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio," ;
      scmdbuf += " T2.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PacienteId], T1.[CitaId], T1.[CitaLink], T1.[CitaAntecedentes]," ;
      scmdbuf += " T1.[CitaInforme], T1.[CitaEstadoCita], T3.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, COALESCE( T3.[ProfesionalNombres], '') + ' ' + COALESCE( T3.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " '') + ' ' + COALESCE( T3.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T5.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre," ;
      scmdbuf += " T4.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T6.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T1.[CitaTipoDiagnostico], T7.[PacienteNroDocumento]," ;
      scmdbuf += " T7.[PacienteNombres], T7.[PacienteApellidoMaterno], T7.[PacienteApellidoPaterno], T1.[CitaCode], T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM (((((([Cita] T1 INNER JOIN [Disponibilidad] T2 ON T2.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] =" ;
      scmdbuf += " T2.[ProfesionalId]) INNER JOIN [Sede] T4 ON T4.[SedeId] = T2.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T5 ON T5.[ClinicaId] = T4.[ClinicaId]) INNER JOIN" ;
      scmdbuf += " [Especialidad] T6 ON T6.[EspecialidadId] = T2.[EspecialidadId]) INNER JOIN [Paciente] T7 ON T7.[PacienteId] = T1.[PacienteId])" ;
      if ( ! (GXutil.strcmp("", AV122Citawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T1.[CitaCode] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T7.[PacienteApellidoPaterno] like '%' + ?) or ( T7.[PacienteApellidoMaterno] like '%' + ?) or ( T7.[PacienteNombres] like '%' + ?) or ( T7.[PacienteNroDocumento] like '%' + ?) or ( 'prensuntivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Prensuntivo') or ( 'definitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Definitivo') or ( 'repetitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Repetitivo') or ( CONVERT( char(8), CAST(T1.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T6.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[SGSedeDisponibilidadSedeId] AS decimal(4,0))) like '%' + ?) or ( T4.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T4.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T5.[ClinicaNombreAbreviado] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( T1.[CitaInforme] like '%' + ?) or ( T1.[CitaAntecedentes] like '%' + ?) or ( T1.[CitaLink] like '%' + ?))");
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
      }
      if ( ! (0==AV123Citawwds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (0==AV124Citawwds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Citawwds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV125Citawwds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Citawwds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( ! (0==AV127Citawwds_6_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (0==AV128Citawwds_7_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Citawwds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV129Citawwds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Citawwds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV132Citawwds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV131Citawwds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV132Citawwds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV134Citawwds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV133Citawwds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV134Citawwds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Citawwds_15_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV135Citawwds_14_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Citawwds_15_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( AV137Citawwds_16_tfcitatipodiagnostico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV137Citawwds_16_tfcitatipodiagnostico_sels, "T1.[CitaTipoDiagnostico] IN (", ")")+")");
      }
      if ( ! (0==AV138Citawwds_17_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( ! (0==AV139Citawwds_18_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV140Citawwds_19_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV141Citawwds_20_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV142Citawwds_21_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV143Citawwds_22_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV144Citawwds_23_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV145Citawwds_24_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (0==AV146Citawwds_25_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( ! (0==AV147Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV148Citawwds_27_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV149Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (0==AV150Citawwds_29_tfsgcitadisponibilidadsedeid) )
      {
         addWhere(sWhereString, "(T2.[SGSedeDisponibilidadSedeId] >= ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (0==AV151Citawwds_30_tfsgcitadisponibilidadsedeid_to) )
      {
         addWhere(sWhereString, "(T2.[SGSedeDisponibilidadSedeId] <= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV152Citawwds_31_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV153Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( ! (0==AV154Citawwds_33_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T4.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[59] = (byte)(1) ;
      }
      if ( ! (0==AV155Citawwds_34_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T4.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[60] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV156Citawwds_35_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int4[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV157Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int4[62] = (byte)(1) ;
      }
      if ( ! (0==AV158Citawwds_37_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int4[63] = (byte)(1) ;
      }
      if ( ! (0==AV159Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int4[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV160Citawwds_39_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV161Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) && ( ! (GXutil.strcmp("", AV162Citawwds_41_tfsgcitadisponibilidadprocop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int4[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV163Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int4[68] = (byte)(1) ;
      }
      if ( AV164Citawwds_43_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV164Citawwds_43_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV166Citawwds_45_tfcitainforme_sel)==0) && ( ! (GXutil.strcmp("", AV165Citawwds_44_tfcitainforme)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] like ?)");
      }
      else
      {
         GXv_int4[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV166Citawwds_45_tfcitainforme_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] = ?)");
      }
      else
      {
         GXv_int4[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV168Citawwds_47_tfcitaantecedentes_sel)==0) && ( ! (GXutil.strcmp("", AV167Citawwds_46_tfcitaantecedentes)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] like ?)");
      }
      else
      {
         GXv_int4[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV168Citawwds_47_tfcitaantecedentes_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] = ?)");
      }
      else
      {
         GXv_int4[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV170Citawwds_49_tfcitalink_sel)==0) && ( ! (GXutil.strcmp("", AV169Citawwds_48_tfcitalink)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] like ?)");
      }
      else
      {
         GXv_int4[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV170Citawwds_49_tfcitalink_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] = ?)");
      }
      else
      {
         GXv_int4[74] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaCode]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteNombres]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteNombres] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaTipoDiagnostico]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaTipoDiagnostico] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SGCitaDisponibilidadId]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SGCitaDisponibilidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadFecha]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadId]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T6.[EspecialidadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T6.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SGSedeDisponibilidadSedeId]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SGSedeDisponibilidadSedeId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[SedeNombre]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[SedeNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[ClinicaId]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[ClinicaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T5.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T5.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ProfesionalId]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ProfesionalId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName] DESC" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaEstadoCita]" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaEstadoCita] DESC" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaInforme]" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaInforme] DESC" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaAntecedentes]" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaAntecedentes] DESC" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaLink]" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaLink] DESC" ;
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
                  return conditional_P00422(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (java.util.Date)dynConstraints[22] , (java.util.Date)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).shortValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (java.util.Date)dynConstraints[75] , (java.util.Date)dynConstraints[76] , (java.util.Date)dynConstraints[77] , ((Number) dynConstraints[78]).shortValue() , ((Boolean) dynConstraints[79]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00422", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(15);
               ((String[]) buf[22])[0] = rslt.getVarchar(16);
               ((String[]) buf[23])[0] = rslt.getVarchar(17);
               ((String[]) buf[24])[0] = rslt.getVarchar(18);
               ((String[]) buf[25])[0] = rslt.getVarchar(19);
               ((String[]) buf[26])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((String[]) buf[32])[0] = rslt.getVarchar(25);
               ((String[]) buf[33])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[104]).intValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[105]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[108]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[109]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 15);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 15);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[118]).intValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[119]).intValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[120]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[121]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[122], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[123], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[124], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[125], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[126]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[127]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 40);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 40);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[130]).shortValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[131]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 80);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[134]).shortValue());
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[135]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 100);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 100);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[138]).intValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[139]).intValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 40);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 40);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 200);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[145], 200);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 200);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               return;
      }
   }

}

