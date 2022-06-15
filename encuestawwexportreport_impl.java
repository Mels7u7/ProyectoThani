package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class encuestawwexportreport_impl extends GXWebReport
{
   public encuestawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta", GXv_boolean2) ;
         encuestawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV97Pgmname))}, new String[] {"GxObject"}) );
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
            AV92Title = "Lista de Encuesta" ;
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
         h4O0( true, 0) ;
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
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV21TFEncuestaId) && (0==AV22TFEncuestaId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFEncuestaId), "ZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV67TFEncuestaId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV67TFEncuestaId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFEncuestaId_To), "ZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV23TFCitaId) && (0==AV24TFCitaId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cita Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFCitaId), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV68TFCitaId_To_Description = GXutil.format( "%1 (%2)", "Cita Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV68TFCitaId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV24TFCitaId_To), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV25TFSGCitaDisponibilidadProfesionalId) && (0==AV26TFSGCitaDisponibilidadProfesionalId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Profesional Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV25TFSGCitaDisponibilidadProfesionalId), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV69TFSGCitaDisponibilidadProfesionalId_To_Description = GXutil.format( "%1 (%2)", "SGCita Disponibilidad Profesional Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV69TFSGCitaDisponibilidadProfesionalId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV26TFSGCitaDisponibilidadProfesionalId_To), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV28TFSGCitaDisponibilidadProFullName_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Pro Full Name", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFSGCitaDisponibilidadProFullName_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV27TFSGCitaDisponibilidadProFullName)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("SGCita Disponibilidad Pro Full Name", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFSGCitaDisponibilidadProFullName, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV29TFSGCitaDisponibilidadEspecialidadId) && (0==AV30TFSGCitaDisponibilidadEspecialidadId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Especialidad Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV29TFSGCitaDisponibilidadEspecialidadId), "ZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV70TFSGCitaDisponibilidadEspecialidadId_To_Description = GXutil.format( "%1 (%2)", "SGCita Disponibilidad Especialidad Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV70TFSGCitaDisponibilidadEspecialidadId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV30TFSGCitaDisponibilidadEspecialidadId_To), "ZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV32TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Especialidad Nombre", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFSGCitaDisponibilidadEspecialidadNombre_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFSGCitaDisponibilidadEspecialidadNombre)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("SGCita Disponibilidad Especialidad Nombre", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFSGCitaDisponibilidadEspecialidadNombre, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV33TFSGCitaDisponibilidadId) && (0==AV34TFSGCitaDisponibilidadId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV33TFSGCitaDisponibilidadId), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV71TFSGCitaDisponibilidadId_To_Description = GXutil.format( "%1 (%2)", "SGCita Disponibilidad Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV71TFSGCitaDisponibilidadId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV34TFSGCitaDisponibilidadId_To), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV35TFSGCitaDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV36TFSGCitaDisponibilidadFecha_To)) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Fecha", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV35TFSGCitaDisponibilidadFecha, "99/99/99"), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV72TFSGCitaDisponibilidadFecha_To_Description = GXutil.format( "%1 (%2)", "SGCita Disponibilidad Fecha", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72TFSGCitaDisponibilidadFecha_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV36TFSGCitaDisponibilidadFecha_To, "99/99/99"), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV37TFPacienteId) && (0==AV38TFPacienteId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV37TFPacienteId), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV73TFPacienteId_To_Description = GXutil.format( "%1 (%2)", "Paciente Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV73TFPacienteId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV38TFPacienteId_To), "ZZZZZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV40TFPacienteApellidoPaterno_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Apellido Paterno", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFPacienteApellidoPaterno_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV39TFPacienteApellidoPaterno)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Apellido Paterno", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39TFPacienteApellidoPaterno, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV42TFPacienteApellidoMaterno_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Apellido Materno", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFPacienteApellidoMaterno_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV41TFPacienteApellidoMaterno)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Apellido Materno", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFPacienteApellidoMaterno, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV44TFPacienteNombres_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Paciente Nombres", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFPacienteNombres_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV43TFPacienteNombres)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Paciente Nombres", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFPacienteNombres, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV45TFSGCitaDisponibilidadClinicaId) && (0==AV46TFSGCitaDisponibilidadClinicaId_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Clinica Id", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV45TFSGCitaDisponibilidadClinicaId), "ZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV74TFSGCitaDisponibilidadClinicaId_To_Description = GXutil.format( "%1 (%2)", "SGCita Disponibilidad Clinica Id", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV74TFSGCitaDisponibilidadClinicaId_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV46TFSGCitaDisponibilidadClinicaId_To), "ZZZ9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV94TFSGCitaDisponibilidadClinicaNombre_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Clinica Nombre", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV94TFSGCitaDisponibilidadClinicaNombre_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV47TFSGCitaDisponibilidadClinicaNombre)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("SGCita Disponibilidad Clinica Nombre", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47TFSGCitaDisponibilidadClinicaNombre, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV51TFEncuestaAtencion_Sels.fromJSonString(AV49TFEncuestaAtencion_SelsJson, null);
      if ( ! ( AV51TFEncuestaAtencion_Sels.size() == 0 ) )
      {
         AV81i = 1 ;
         AV100GXV1 = 1 ;
         while ( AV100GXV1 <= AV51TFEncuestaAtencion_Sels.size() )
         {
            AV52TFEncuestaAtencion_Sel = (String)AV51TFEncuestaAtencion_Sels.elementAt(-1+AV100GXV1) ;
            if ( AV81i == 1 )
            {
               AV50TFEncuestaAtencion_SelDscs = "" ;
            }
            else
            {
               AV50TFEncuestaAtencion_SelDscs += ", " ;
            }
            if ( GXutil.strcmp(GXutil.trim( AV52TFEncuestaAtencion_Sel), "B") == 0 )
            {
               AV76FilterTFEncuestaAtencion_SelValueDescription = "Buena" ;
            }
            else if ( GXutil.strcmp(GXutil.trim( AV52TFEncuestaAtencion_Sel), "R") == 0 )
            {
               AV76FilterTFEncuestaAtencion_SelValueDescription = "Regular" ;
            }
            else if ( GXutil.strcmp(GXutil.trim( AV52TFEncuestaAtencion_Sel), "M") == 0 )
            {
               AV76FilterTFEncuestaAtencion_SelValueDescription = "Mala" ;
            }
            AV50TFEncuestaAtencion_SelDscs += AV76FilterTFEncuestaAtencion_SelValueDescription ;
            AV81i = (long)(AV81i+1) ;
            AV100GXV1 = (int)(AV100GXV1+1) ;
         }
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Atencion", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50TFEncuestaAtencion_SelDscs, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV55TFEncuestaAtendido_Sels.fromJSonString(AV53TFEncuestaAtendido_SelsJson, null);
      if ( ! ( AV55TFEncuestaAtendido_Sels.size() == 0 ) )
      {
         AV81i = 1 ;
         AV101GXV2 = 1 ;
         while ( AV101GXV2 <= AV55TFEncuestaAtendido_Sels.size() )
         {
            AV56TFEncuestaAtendido_Sel = (String)AV55TFEncuestaAtendido_Sels.elementAt(-1+AV101GXV2) ;
            if ( AV81i == 1 )
            {
               AV54TFEncuestaAtendido_SelDscs = "" ;
            }
            else
            {
               AV54TFEncuestaAtendido_SelDscs += ", " ;
            }
            if ( GXutil.strcmp(GXutil.trim( AV56TFEncuestaAtendido_Sel), "S") == 0 )
            {
               AV77FilterTFEncuestaAtendido_SelValueDescription = "Si" ;
            }
            else if ( GXutil.strcmp(GXutil.trim( AV56TFEncuestaAtendido_Sel), "N") == 0 )
            {
               AV77FilterTFEncuestaAtendido_SelValueDescription = "No" ;
            }
            AV54TFEncuestaAtendido_SelDscs += AV77FilterTFEncuestaAtendido_SelValueDescription ;
            AV81i = (long)(AV81i+1) ;
            AV101GXV2 = (int)(AV101GXV2+1) ;
         }
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Atendido", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54TFEncuestaAtendido_SelDscs, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV57TFEncuestaHoraAtencion) && GXutil.dateCompare(GXutil.nullDate(), AV58TFEncuestaHoraAtencion_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Hora Atencion", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV57TFEncuestaHoraAtencion, "99:99"), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV78TFEncuestaHoraAtencion_To_Description = GXutil.format( "%1 (%2)", "Hora Atencion", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV78TFEncuestaHoraAtencion_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV58TFEncuestaHoraAtencion_To, "99:99"), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV60TFEncuestaComentarios_Sel)==0) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Comentarios", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV60TFEncuestaComentarios_Sel, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV59TFEncuestaComentarios)==0) )
         {
            h4O0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Comentarios", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV59TFEncuestaComentarios, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV61TFEncuestaRecomendacion) && (0==AV62TFEncuestaRecomendacion_To) ) )
      {
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Recomendacion", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV61TFEncuestaRecomendacion), "Z9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV79TFEncuestaRecomendacion_To_Description = GXutil.format( "%1 (%2)", "Recomendacion", "Hasta", "", "", "", "", "", "", "") ;
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV79TFEncuestaRecomendacion_To_Description, "")), 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV62TFEncuestaRecomendacion_To), "Z9")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV65TFEncuestaEstado_Sels.fromJSonString(AV63TFEncuestaEstado_SelsJson, null);
      if ( ! ( AV65TFEncuestaEstado_Sels.size() == 0 ) )
      {
         AV81i = 1 ;
         AV102GXV3 = 1 ;
         while ( AV102GXV3 <= AV65TFEncuestaEstado_Sels.size() )
         {
            AV66TFEncuestaEstado_Sel = (String)AV65TFEncuestaEstado_Sels.elementAt(-1+AV102GXV3) ;
            if ( AV81i == 1 )
            {
               AV64TFEncuestaEstado_SelDscs = "" ;
            }
            else
            {
               AV64TFEncuestaEstado_SelDscs += ", " ;
            }
            if ( GXutil.strcmp(GXutil.trim( AV66TFEncuestaEstado_Sel), "P") == 0 )
            {
               AV80FilterTFEncuestaEstado_SelValueDescription = "Pendiente" ;
            }
            else if ( GXutil.strcmp(GXutil.trim( AV66TFEncuestaEstado_Sel), "R") == 0 )
            {
               AV80FilterTFEncuestaEstado_SelValueDescription = "Realizada" ;
            }
            else if ( GXutil.strcmp(GXutil.trim( AV66TFEncuestaEstado_Sel), "") == 0 )
            {
               AV80FilterTFEncuestaEstado_SelValueDescription = "" ;
            }
            AV64TFEncuestaEstado_SelDscs += AV80FilterTFEncuestaEstado_SelValueDescription ;
            AV81i = (long)(AV81i+1) ;
            AV102GXV3 = (int)(AV102GXV3+1) ;
         }
         h4O0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 245, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV64TFEncuestaEstado_SelDscs, "")), 245, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4O0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4O0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 64, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Cita Id", 68, Gx_line+10, 102, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Profesional Id", 106, Gx_line+10, 140, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Pro Full Name", 144, Gx_line+10, 178, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Especialidad Id", 182, Gx_line+10, 216, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Especialidad Nombre", 220, Gx_line+10, 254, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Id", 258, Gx_line+10, 292, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Fecha", 296, Gx_line+10, 330, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Id", 334, Gx_line+10, 368, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Apellido Paterno", 372, Gx_line+10, 406, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Apellido Materno", 410, Gx_line+10, 444, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Paciente Nombres", 448, Gx_line+10, 482, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Clinica Id", 486, Gx_line+10, 520, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Clinica Nombre", 524, Gx_line+10, 558, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Atencion", 562, Gx_line+10, 596, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Atendido", 600, Gx_line+10, 634, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Hora Atencion", 638, Gx_line+10, 672, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Comentarios", 676, Gx_line+10, 710, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Recomendacion", 714, Gx_line+10, 748, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 752, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV104Encuestawwds_1_filterfulltext = AV13FilterFullText ;
      AV105Encuestawwds_2_tfencuestaid = AV21TFEncuestaId ;
      AV106Encuestawwds_3_tfencuestaid_to = AV22TFEncuestaId_To ;
      AV107Encuestawwds_4_tfcitaid = AV23TFCitaId ;
      AV108Encuestawwds_5_tfcitaid_to = AV24TFCitaId_To ;
      AV109Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV25TFSGCitaDisponibilidadProfesionalId ;
      AV110Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV26TFSGCitaDisponibilidadProfesionalId_To ;
      AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV27TFSGCitaDisponibilidadProFullName ;
      AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV28TFSGCitaDisponibilidadProFullName_Sel ;
      AV113Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV29TFSGCitaDisponibilidadEspecialidadId ;
      AV114Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV30TFSGCitaDisponibilidadEspecialidadId_To ;
      AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV31TFSGCitaDisponibilidadEspecialidadNombre ;
      AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV32TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV117Encuestawwds_14_tfsgcitadisponibilidadid = AV33TFSGCitaDisponibilidadId ;
      AV118Encuestawwds_15_tfsgcitadisponibilidadid_to = AV34TFSGCitaDisponibilidadId_To ;
      AV119Encuestawwds_16_tfsgcitadisponibilidadfecha = AV35TFSGCitaDisponibilidadFecha ;
      AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV36TFSGCitaDisponibilidadFecha_To ;
      AV121Encuestawwds_18_tfpacienteid = AV37TFPacienteId ;
      AV122Encuestawwds_19_tfpacienteid_to = AV38TFPacienteId_To ;
      AV123Encuestawwds_20_tfpacienteapellidopaterno = AV39TFPacienteApellidoPaterno ;
      AV124Encuestawwds_21_tfpacienteapellidopaterno_sel = AV40TFPacienteApellidoPaterno_Sel ;
      AV125Encuestawwds_22_tfpacienteapellidomaterno = AV41TFPacienteApellidoMaterno ;
      AV126Encuestawwds_23_tfpacienteapellidomaterno_sel = AV42TFPacienteApellidoMaterno_Sel ;
      AV127Encuestawwds_24_tfpacientenombres = AV43TFPacienteNombres ;
      AV128Encuestawwds_25_tfpacientenombres_sel = AV44TFPacienteNombres_Sel ;
      AV129Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV45TFSGCitaDisponibilidadClinicaId ;
      AV130Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV46TFSGCitaDisponibilidadClinicaId_To ;
      AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV47TFSGCitaDisponibilidadClinicaNombre ;
      AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV133Encuestawwds_30_tfencuestaatencion_sels = AV51TFEncuestaAtencion_Sels ;
      AV134Encuestawwds_31_tfencuestaatendido_sels = AV55TFEncuestaAtendido_Sels ;
      AV135Encuestawwds_32_tfencuestahoraatencion = AV57TFEncuestaHoraAtencion ;
      AV136Encuestawwds_33_tfencuestahoraatencion_to = AV58TFEncuestaHoraAtencion_To ;
      AV137Encuestawwds_34_tfencuestacomentarios = AV59TFEncuestaComentarios ;
      AV138Encuestawwds_35_tfencuestacomentarios_sel = AV60TFEncuestaComentarios_Sel ;
      AV139Encuestawwds_36_tfencuestarecomendacion = AV61TFEncuestaRecomendacion ;
      AV140Encuestawwds_37_tfencuestarecomendacion_to = AV62TFEncuestaRecomendacion_To ;
      AV141Encuestawwds_38_tfencuestaestado_sels = AV65TFEncuestaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV133Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV134Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV141Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV105Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV106Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV107Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV108Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV109Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV110Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV113Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV114Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV117Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV118Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV119Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV121Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV122Encuestawwds_19_tfpacienteid_to) ,
                                           AV124Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV123Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV126Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV125Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV128Encuestawwds_25_tfpacientenombres_sel ,
                                           AV127Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV129Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV130Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV133Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV134Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV135Encuestawwds_32_tfencuestahoraatencion ,
                                           AV136Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV138Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV137Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV139Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV140Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV141Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV104Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV104Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV104Encuestawwds_1_filterfulltext), "%", "") ;
      lV111Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV123Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV123Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV125Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV125Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV127Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV127Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV137Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV137Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P004O2 */
      pr_default.execute(0, new Object[] {AV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, lV104Encuestawwds_1_filterfulltext, Short.valueOf(AV105Encuestawwds_2_tfencuestaid), Short.valueOf(AV106Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV107Encuestawwds_4_tfcitaid), Integer.valueOf(AV108Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV109Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV110Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV111Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV113Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV114Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV117Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV118Encuestawwds_15_tfsgcitadisponibilidadid_to), AV119Encuestawwds_16_tfsgcitadisponibilidadfecha, AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV121Encuestawwds_18_tfpacienteid), Integer.valueOf(AV122Encuestawwds_19_tfpacienteid_to), lV123Encuestawwds_20_tfpacienteapellidopaterno, AV124Encuestawwds_21_tfpacienteapellidopaterno_sel, lV125Encuestawwds_22_tfpacienteapellidomaterno, AV126Encuestawwds_23_tfpacienteapellidomaterno_sel, lV127Encuestawwds_24_tfpacientenombres, AV128Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV129Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV130Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV135Encuestawwds_32_tfencuestahoraatencion, AV136Encuestawwds_33_tfencuestahoraatencion_to, lV137Encuestawwds_34_tfencuestacomentarios, AV138Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV139Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV140Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A72SGCitaDisponibilidadSedeId = P004O2_A72SGCitaDisponibilidadSedeId[0] ;
         A152EncuestaRecomendacion = P004O2_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P004O2_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P004O2_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P004O2_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P004O2_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P004O2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004O2_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P004O2_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P004O2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P004O2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P004O2_A19CitaId[0] ;
         A37EncuestaId = P004O2_A37EncuestaId[0] ;
         A153EncuestaEstado = P004O2_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P004O2_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P004O2_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P004O2_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P004O2_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P004O2_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P004O2_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P004O2_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P004O2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P004O2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P004O2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P004O2_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P004O2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P004O2_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P004O2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P004O2_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004O2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P004O2_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004O2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P004O2_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P004O2_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P004O2_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P004O2_A82SGCitaDisponibilidadProFullName[0] ;
         A105PacienteNombres = P004O2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P004O2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P004O2_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P004O2_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P004O2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004O2_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P004O2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P004O2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P004O2_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P004O2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P004O2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P004O2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P004O2_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004O2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P004O2_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004O2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P004O2_n86ProfesionalApellidoMaterno[0] ;
         if ( GXutil.strcmp(GXutil.trim( A148EncuestaAtencion), "B") == 0 )
         {
            AV14EncuestaAtencionDescription = "Buena" ;
         }
         else if ( GXutil.strcmp(GXutil.trim( A148EncuestaAtencion), "R") == 0 )
         {
            AV14EncuestaAtencionDescription = "Regular" ;
         }
         else if ( GXutil.strcmp(GXutil.trim( A148EncuestaAtencion), "M") == 0 )
         {
            AV14EncuestaAtencionDescription = "Mala" ;
         }
         if ( GXutil.strcmp(GXutil.trim( A149EncuestaAtendido), "S") == 0 )
         {
            AV15EncuestaAtendidoDescription = "Si" ;
         }
         else if ( GXutil.strcmp(GXutil.trim( A149EncuestaAtendido), "N") == 0 )
         {
            AV15EncuestaAtendidoDescription = "No" ;
         }
         if ( GXutil.strcmp(GXutil.trim( A153EncuestaEstado), "P") == 0 )
         {
            AV16EncuestaEstadoDescription = "Pendiente" ;
         }
         else if ( GXutil.strcmp(GXutil.trim( A153EncuestaEstado), "R") == 0 )
         {
            AV16EncuestaEstadoDescription = "Realizada" ;
         }
         else if ( GXutil.strcmp(GXutil.trim( A153EncuestaEstado), "") == 0 )
         {
            AV16EncuestaEstadoDescription = "" ;
         }
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
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h4O0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9")), 30, Gx_line+10, 64, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), 68, Gx_line+10, 102, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9")), 106, Gx_line+10, 140, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A82SGCitaDisponibilidadProFullName, "")), 144, Gx_line+10, 178, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9")), 182, Gx_line+10, 216, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A146SGCitaDisponibilidadEspecialidadNombre, "")), 220, Gx_line+10, 254, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9")), 258, Gx_line+10, 292, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), 296, Gx_line+10, 330, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")), 334, Gx_line+10, 368, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), 372, Gx_line+10, 406, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), 410, Gx_line+10, 444, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), 448, Gx_line+10, 482, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9")), 486, Gx_line+10, 520, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A78SGCitaDisponibilidadClinicaNombre, "")), 524, Gx_line+10, 558, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14EncuestaAtencionDescription, "")), 562, Gx_line+10, 596, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15EncuestaAtendidoDescription, "")), 600, Gx_line+10, 634, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A150EncuestaHoraAtencion, "99:99"), 638, Gx_line+10, 672, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A151EncuestaComentarios, 676, Gx_line+10, 710, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), "Z9")), 714, Gx_line+10, 748, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV16EncuestaEstadoDescription, "")), 752, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV17Session.getValue("EncuestaWWGridState"), "") == 0 )
      {
         AV19GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EncuestaWWGridState"), null, null);
      }
      else
      {
         AV19GridState.fromxml(AV17Session.getValue("EncuestaWWGridState"), null, null);
      }
      AV11OrderedBy = AV19GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV19GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV142GXV4 = 1 ;
      while ( AV142GXV4 <= AV19GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV20GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV19GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV142GXV4));
         if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAID") == 0 )
         {
            AV21TFEncuestaId = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFEncuestaId_To = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV23TFCitaId = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFCitaId_To = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV25TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV27TFSGCitaDisponibilidadProFullName = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV28TFSGCitaDisponibilidadProFullName_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV29TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV30TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV31TFSGCitaDisponibilidadEspecialidadNombre = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV32TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV33TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV34TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV35TFSGCitaDisponibilidadFecha = localUtil.ctod( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV36TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV37TFPacienteId = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFPacienteId_To = (int)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV39TFPacienteApellidoPaterno = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV40TFPacienteApellidoPaterno_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV41TFPacienteApellidoMaterno = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV42TFPacienteApellidoMaterno_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV43TFPacienteNombres = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV44TFPacienteNombres_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV45TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV46TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV47TFSGCitaDisponibilidadClinicaNombre = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV94TFSGCitaDisponibilidadClinicaNombre_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENCION_SEL") == 0 )
         {
            AV49TFEncuestaAtencion_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFEncuestaAtencion_Sels.fromJSonString(AV49TFEncuestaAtencion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENDIDO_SEL") == 0 )
         {
            AV53TFEncuestaAtendido_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFEncuestaAtendido_Sels.fromJSonString(AV53TFEncuestaAtendido_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAHORAATENCION") == 0 )
         {
            AV57TFEncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV58TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.ctot( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS") == 0 )
         {
            AV59TFEncuestaComentarios = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS_SEL") == 0 )
         {
            AV60TFEncuestaComentarios_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTARECOMENDACION") == 0 )
         {
            AV61TFEncuestaRecomendacion = (byte)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV62TFEncuestaRecomendacion_To = (byte)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAESTADO_SEL") == 0 )
         {
            AV63TFEncuestaEstado_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV65TFEncuestaEstado_Sels.fromJSonString(AV63TFEncuestaEstado_SelsJson, null);
         }
         AV142GXV4 = (int)(AV142GXV4+1) ;
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

   public void h4O0( boolean bFoot ,
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
               AV90PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV87DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV90PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV87DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV85AppName = "DVelop Software Solutions" ;
            AV91Phone = "+1 550 8923" ;
            AV89Mail = "info@mail.com" ;
            AV93Website = "http://www.web.com" ;
            AV82AddressLine1 = "French Boulevard 2859" ;
            AV83AddressLine2 = "Downtown" ;
            AV84AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV85AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV92Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV91Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV89Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV93Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV82AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV83AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV84AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV97Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV92Title = "" ;
      AV13FilterFullText = "" ;
      AV67TFEncuestaId_To_Description = "" ;
      AV68TFCitaId_To_Description = "" ;
      AV69TFSGCitaDisponibilidadProfesionalId_To_Description = "" ;
      AV28TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV27TFSGCitaDisponibilidadProFullName = "" ;
      AV70TFSGCitaDisponibilidadEspecialidadId_To_Description = "" ;
      AV32TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV31TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV71TFSGCitaDisponibilidadId_To_Description = "" ;
      AV35TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV36TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV72TFSGCitaDisponibilidadFecha_To_Description = "" ;
      AV73TFPacienteId_To_Description = "" ;
      AV40TFPacienteApellidoPaterno_Sel = "" ;
      AV39TFPacienteApellidoPaterno = "" ;
      AV42TFPacienteApellidoMaterno_Sel = "" ;
      AV41TFPacienteApellidoMaterno = "" ;
      AV44TFPacienteNombres_Sel = "" ;
      AV43TFPacienteNombres = "" ;
      AV74TFSGCitaDisponibilidadClinicaId_To_Description = "" ;
      AV94TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV47TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV51TFEncuestaAtencion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFEncuestaAtencion_SelsJson = "" ;
      AV52TFEncuestaAtencion_Sel = "" ;
      AV50TFEncuestaAtencion_SelDscs = "" ;
      AV76FilterTFEncuestaAtencion_SelValueDescription = "" ;
      AV55TFEncuestaAtendido_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFEncuestaAtendido_SelsJson = "" ;
      AV56TFEncuestaAtendido_Sel = "" ;
      AV54TFEncuestaAtendido_SelDscs = "" ;
      AV77FilterTFEncuestaAtendido_SelValueDescription = "" ;
      AV57TFEncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      AV58TFEncuestaHoraAtencion_To = GXutil.resetTime( GXutil.nullDate() );
      AV78TFEncuestaHoraAtencion_To_Description = "" ;
      AV60TFEncuestaComentarios_Sel = "" ;
      AV59TFEncuestaComentarios = "" ;
      AV79TFEncuestaRecomendacion_To_Description = "" ;
      AV65TFEncuestaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFEncuestaEstado_SelsJson = "" ;
      AV66TFEncuestaEstado_Sel = "" ;
      AV64TFEncuestaEstado_SelDscs = "" ;
      AV80FilterTFEncuestaEstado_SelValueDescription = "" ;
      A148EncuestaAtencion = "" ;
      A149EncuestaAtendido = "" ;
      A153EncuestaEstado = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      A151EncuestaComentarios = "" ;
      AV104Encuestawwds_1_filterfulltext = "" ;
      AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV119Encuestawwds_16_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV123Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      AV124Encuestawwds_21_tfpacienteapellidopaterno_sel = "" ;
      AV125Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      AV126Encuestawwds_23_tfpacienteapellidomaterno_sel = "" ;
      AV127Encuestawwds_24_tfpacientenombres = "" ;
      AV128Encuestawwds_25_tfpacientenombres_sel = "" ;
      AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV133Encuestawwds_30_tfencuestaatencion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV134Encuestawwds_31_tfencuestaatendido_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV135Encuestawwds_32_tfencuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
      AV136Encuestawwds_33_tfencuestahoraatencion_to = GXutil.resetTime( GXutil.nullDate() );
      AV137Encuestawwds_34_tfencuestacomentarios = "" ;
      AV138Encuestawwds_35_tfencuestacomentarios_sel = "" ;
      AV141Encuestawwds_38_tfencuestaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV104Encuestawwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV111Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      lV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV123Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      lV125Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      lV127Encuestawwds_24_tfpacientenombres = "" ;
      lV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      lV137Encuestawwds_34_tfencuestacomentarios = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      P004O2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P004O2_A152EncuestaRecomendacion = new byte[1] ;
      P004O2_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P004O2_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P004O2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P004O2_A20PacienteId = new int[1] ;
      P004O2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004O2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P004O2_A21SGCitaDisponibilidadId = new int[1] ;
      P004O2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P004O2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P004O2_A19CitaId = new int[1] ;
      P004O2_A37EncuestaId = new short[1] ;
      P004O2_A153EncuestaEstado = new String[] {""} ;
      P004O2_n153EncuestaEstado = new boolean[] {false} ;
      P004O2_A151EncuestaComentarios = new String[] {""} ;
      P004O2_n151EncuestaComentarios = new boolean[] {false} ;
      P004O2_A149EncuestaAtendido = new String[] {""} ;
      P004O2_n149EncuestaAtendido = new boolean[] {false} ;
      P004O2_A148EncuestaAtencion = new String[] {""} ;
      P004O2_n148EncuestaAtencion = new boolean[] {false} ;
      P004O2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P004O2_A105PacienteNombres = new String[] {""} ;
      P004O2_A104PacienteApellidoMaterno = new String[] {""} ;
      P004O2_A103PacienteApellidoPaterno = new String[] {""} ;
      P004O2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P004O2_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P004O2_A84ProfesionalNombres = new String[] {""} ;
      P004O2_n84ProfesionalNombres = new boolean[] {false} ;
      P004O2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P004O2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P004O2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P004O2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      AV14EncuestaAtencionDescription = "" ;
      AV15EncuestaAtendidoDescription = "" ;
      AV16EncuestaEstadoDescription = "" ;
      AV17Session = httpContext.getWebSession();
      AV19GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV20GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV90PageInfo = "" ;
      AV87DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV85AppName = "" ;
      AV91Phone = "" ;
      AV89Mail = "" ;
      AV93Website = "" ;
      AV82AddressLine1 = "" ;
      AV83AddressLine2 = "" ;
      AV84AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuestawwexportreport__default(),
         new Object[] {
             new Object[] {
            P004O2_A72SGCitaDisponibilidadSedeId, P004O2_A152EncuestaRecomendacion, P004O2_A150EncuestaHoraAtencion, P004O2_n150EncuestaHoraAtencion, P004O2_A76SGCitaDisponibilidadClinicaId, P004O2_A20PacienteId, P004O2_A66SGCitaDisponibilidadFecha, P004O2_n66SGCitaDisponibilidadFecha, P004O2_A21SGCitaDisponibilidadId, P004O2_A70SGCitaDisponibilidadEspecialidadId,
            P004O2_A81SGCitaDisponibilidadProfesionalId, P004O2_A19CitaId, P004O2_A37EncuestaId, P004O2_A153EncuestaEstado, P004O2_n153EncuestaEstado, P004O2_A151EncuestaComentarios, P004O2_n151EncuestaComentarios, P004O2_A149EncuestaAtendido, P004O2_n149EncuestaAtendido, P004O2_A148EncuestaAtencion,
            P004O2_n148EncuestaAtencion, P004O2_A78SGCitaDisponibilidadClinicaNombre, P004O2_A105PacienteNombres, P004O2_A104PacienteApellidoMaterno, P004O2_A103PacienteApellidoPaterno, P004O2_A146SGCitaDisponibilidadEspecialidadNombre, P004O2_A82SGCitaDisponibilidadProFullName, P004O2_A84ProfesionalNombres, P004O2_n84ProfesionalNombres, P004O2_A85ProfesionalApellidoPaterno,
            P004O2_n85ProfesionalApellidoPaterno, P004O2_A86ProfesionalApellidoMaterno, P004O2_n86ProfesionalApellidoMaterno
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV97Pgmname = "EncuestaWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV97Pgmname = "EncuestaWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV61TFEncuestaRecomendacion ;
   private byte AV62TFEncuestaRecomendacion_To ;
   private byte A152EncuestaRecomendacion ;
   private byte AV139Encuestawwds_36_tfencuestarecomendacion ;
   private byte AV140Encuestawwds_37_tfencuestarecomendacion_to ;
   private short gxcookieaux ;
   private short AV21TFEncuestaId ;
   private short AV22TFEncuestaId_To ;
   private short AV29TFSGCitaDisponibilidadEspecialidadId ;
   private short AV30TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV45TFSGCitaDisponibilidadClinicaId ;
   private short AV46TFSGCitaDisponibilidadClinicaId_To ;
   private short A37EncuestaId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short AV105Encuestawwds_2_tfencuestaid ;
   private short AV106Encuestawwds_3_tfencuestaid_to ;
   private short AV113Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ;
   private short AV114Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV129Encuestawwds_26_tfsgcitadisponibilidadclinicaid ;
   private short AV130Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ;
   private short AV11OrderedBy ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV23TFCitaId ;
   private int AV24TFCitaId_To ;
   private int AV25TFSGCitaDisponibilidadProfesionalId ;
   private int AV26TFSGCitaDisponibilidadProfesionalId_To ;
   private int AV33TFSGCitaDisponibilidadId ;
   private int AV34TFSGCitaDisponibilidadId_To ;
   private int AV37TFPacienteId ;
   private int AV38TFPacienteId_To ;
   private int AV100GXV1 ;
   private int AV101GXV2 ;
   private int AV102GXV3 ;
   private int A19CitaId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int A20PacienteId ;
   private int AV107Encuestawwds_4_tfcitaid ;
   private int AV108Encuestawwds_5_tfcitaid_to ;
   private int AV109Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ;
   private int AV110Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV117Encuestawwds_14_tfsgcitadisponibilidadid ;
   private int AV118Encuestawwds_15_tfsgcitadisponibilidadid_to ;
   private int AV121Encuestawwds_18_tfpacienteid ;
   private int AV122Encuestawwds_19_tfpacienteid_to ;
   private int AV133Encuestawwds_30_tfencuestaatencion_sels_size ;
   private int AV134Encuestawwds_31_tfencuestaatendido_sels_size ;
   private int AV141Encuestawwds_38_tfencuestaestado_sels_size ;
   private int AV142GXV4 ;
   private long AV81i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV97Pgmname ;
   private String AV52TFEncuestaAtencion_Sel ;
   private String AV56TFEncuestaAtendido_Sel ;
   private String AV66TFEncuestaEstado_Sel ;
   private String A148EncuestaAtencion ;
   private String A149EncuestaAtendido ;
   private String A153EncuestaEstado ;
   private String scmdbuf ;
   private java.util.Date AV57TFEncuestaHoraAtencion ;
   private java.util.Date AV58TFEncuestaHoraAtencion_To ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date AV135Encuestawwds_32_tfencuestahoraatencion ;
   private java.util.Date AV136Encuestawwds_33_tfencuestahoraatencion_to ;
   private java.util.Date AV35TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV36TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV119Encuestawwds_16_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n153EncuestaEstado ;
   private boolean n151EncuestaComentarios ;
   private boolean n149EncuestaAtendido ;
   private boolean n148EncuestaAtencion ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private String AV49TFEncuestaAtencion_SelsJson ;
   private String AV53TFEncuestaAtendido_SelsJson ;
   private String AV63TFEncuestaEstado_SelsJson ;
   private String A151EncuestaComentarios ;
   private String AV92Title ;
   private String AV13FilterFullText ;
   private String AV67TFEncuestaId_To_Description ;
   private String AV68TFCitaId_To_Description ;
   private String AV69TFSGCitaDisponibilidadProfesionalId_To_Description ;
   private String AV28TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV27TFSGCitaDisponibilidadProFullName ;
   private String AV70TFSGCitaDisponibilidadEspecialidadId_To_Description ;
   private String AV32TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV31TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV71TFSGCitaDisponibilidadId_To_Description ;
   private String AV72TFSGCitaDisponibilidadFecha_To_Description ;
   private String AV73TFPacienteId_To_Description ;
   private String AV40TFPacienteApellidoPaterno_Sel ;
   private String AV39TFPacienteApellidoPaterno ;
   private String AV42TFPacienteApellidoMaterno_Sel ;
   private String AV41TFPacienteApellidoMaterno ;
   private String AV44TFPacienteNombres_Sel ;
   private String AV43TFPacienteNombres ;
   private String AV74TFSGCitaDisponibilidadClinicaId_To_Description ;
   private String AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV47TFSGCitaDisponibilidadClinicaNombre ;
   private String AV50TFEncuestaAtencion_SelDscs ;
   private String AV76FilterTFEncuestaAtencion_SelValueDescription ;
   private String AV54TFEncuestaAtendido_SelDscs ;
   private String AV77FilterTFEncuestaAtendido_SelValueDescription ;
   private String AV78TFEncuestaHoraAtencion_To_Description ;
   private String AV60TFEncuestaComentarios_Sel ;
   private String AV59TFEncuestaComentarios ;
   private String AV79TFEncuestaRecomendacion_To_Description ;
   private String AV64TFEncuestaEstado_SelDscs ;
   private String AV80FilterTFEncuestaEstado_SelValueDescription ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String AV104Encuestawwds_1_filterfulltext ;
   private String AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ;
   private String AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV123Encuestawwds_20_tfpacienteapellidopaterno ;
   private String AV124Encuestawwds_21_tfpacienteapellidopaterno_sel ;
   private String AV125Encuestawwds_22_tfpacienteapellidomaterno ;
   private String AV126Encuestawwds_23_tfpacienteapellidomaterno_sel ;
   private String AV127Encuestawwds_24_tfpacientenombres ;
   private String AV128Encuestawwds_25_tfpacientenombres_sel ;
   private String AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV137Encuestawwds_34_tfencuestacomentarios ;
   private String AV138Encuestawwds_35_tfencuestacomentarios_sel ;
   private String lV104Encuestawwds_1_filterfulltext ;
   private String lV111Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String lV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV123Encuestawwds_20_tfpacienteapellidopaterno ;
   private String lV125Encuestawwds_22_tfpacienteapellidomaterno ;
   private String lV127Encuestawwds_24_tfpacientenombres ;
   private String lV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String lV137Encuestawwds_34_tfencuestacomentarios ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String AV14EncuestaAtencionDescription ;
   private String AV15EncuestaAtendidoDescription ;
   private String AV16EncuestaEstadoDescription ;
   private String AV90PageInfo ;
   private String AV87DateInfo ;
   private String AV85AppName ;
   private String AV91Phone ;
   private String AV89Mail ;
   private String AV93Website ;
   private String AV82AddressLine1 ;
   private String AV83AddressLine2 ;
   private String AV84AddressLine3 ;
   private com.genexus.webpanels.WebSession AV17Session ;
   private IDataStoreProvider pr_default ;
   private short[] P004O2_A72SGCitaDisponibilidadSedeId ;
   private byte[] P004O2_A152EncuestaRecomendacion ;
   private java.util.Date[] P004O2_A150EncuestaHoraAtencion ;
   private boolean[] P004O2_n150EncuestaHoraAtencion ;
   private short[] P004O2_A76SGCitaDisponibilidadClinicaId ;
   private int[] P004O2_A20PacienteId ;
   private java.util.Date[] P004O2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P004O2_n66SGCitaDisponibilidadFecha ;
   private int[] P004O2_A21SGCitaDisponibilidadId ;
   private short[] P004O2_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P004O2_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P004O2_A19CitaId ;
   private short[] P004O2_A37EncuestaId ;
   private String[] P004O2_A153EncuestaEstado ;
   private boolean[] P004O2_n153EncuestaEstado ;
   private String[] P004O2_A151EncuestaComentarios ;
   private boolean[] P004O2_n151EncuestaComentarios ;
   private String[] P004O2_A149EncuestaAtendido ;
   private boolean[] P004O2_n149EncuestaAtendido ;
   private String[] P004O2_A148EncuestaAtencion ;
   private boolean[] P004O2_n148EncuestaAtencion ;
   private String[] P004O2_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P004O2_A105PacienteNombres ;
   private String[] P004O2_A104PacienteApellidoMaterno ;
   private String[] P004O2_A103PacienteApellidoPaterno ;
   private String[] P004O2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P004O2_A82SGCitaDisponibilidadProFullName ;
   private String[] P004O2_A84ProfesionalNombres ;
   private boolean[] P004O2_n84ProfesionalNombres ;
   private String[] P004O2_A85ProfesionalApellidoPaterno ;
   private boolean[] P004O2_n85ProfesionalApellidoPaterno ;
   private String[] P004O2_A86ProfesionalApellidoMaterno ;
   private boolean[] P004O2_n86ProfesionalApellidoMaterno ;
   private GXSimpleCollection<String> AV51TFEncuestaAtencion_Sels ;
   private GXSimpleCollection<String> AV55TFEncuestaAtendido_Sels ;
   private GXSimpleCollection<String> AV65TFEncuestaEstado_Sels ;
   private GXSimpleCollection<String> AV133Encuestawwds_30_tfencuestaatencion_sels ;
   private GXSimpleCollection<String> AV134Encuestawwds_31_tfencuestaatendido_sels ;
   private GXSimpleCollection<String> AV141Encuestawwds_38_tfencuestaestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV19GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV20GridStateFilterValue ;
}

final  class encuestawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004O2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV133Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV134Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV141Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV105Encuestawwds_2_tfencuestaid ,
                                          short AV106Encuestawwds_3_tfencuestaid_to ,
                                          int AV107Encuestawwds_4_tfcitaid ,
                                          int AV108Encuestawwds_5_tfcitaid_to ,
                                          int AV109Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV110Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV113Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV114Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV117Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV118Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV119Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV121Encuestawwds_18_tfpacienteid ,
                                          int AV122Encuestawwds_19_tfpacienteid_to ,
                                          String AV124Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV123Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV126Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV125Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV128Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV127Encuestawwds_24_tfpacientenombres ,
                                          short AV129Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV130Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV133Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV134Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV135Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV136Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV138Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV137Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV139Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV140Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV141Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV104Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[57];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId," ;
      scmdbuf += " T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId," ;
      scmdbuf += " T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado], T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion]," ;
      scmdbuf += " T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres], T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno], T7.[EspecialidadNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno]," ;
      scmdbuf += " '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno] FROM ((((((([Encuesta] T1 INNER" ;
      scmdbuf += " JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId]" ;
      scmdbuf += " = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV105Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (0==AV106Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV107Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV108Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (0==AV109Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV111Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( ! (0==AV113Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (0==AV114Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV115Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (0==AV117Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (0==AV118Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV119Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV120Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (0==AV121Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (0==AV122Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV124Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV123Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV125Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV127Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! (0==AV129Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( ! (0==AV130Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV131Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV132Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( AV133Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV133Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV134Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV134Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV135Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV136Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV138Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV137Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (0==AV139Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (0==AV140Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( AV141Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV141Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtencion]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtencion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[ProfesionalId]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[ProfesionalId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[EspecialidadId]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[EspecialidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[EspecialidadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SGCitaDisponibilidadId]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SGCitaDisponibilidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[DisponibilidadFecha]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PacienteId]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PacienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PacienteNombres]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PacienteNombres] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T5.[ClinicaId]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T5.[ClinicaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T6.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T6.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtendido]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtendido] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaHoraAtencion]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaHoraAtencion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaComentarios]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaComentarios] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaRecomendacion]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaRecomendacion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaEstado]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaEstado] DESC" ;
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
                  return conditional_P004O2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , ((Number) dynConstraints[62]).shortValue() , ((Boolean) dynConstraints[63]).booleanValue() , (String)dynConstraints[64] , (String)dynConstraints[65] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004O2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((short[]) buf[9])[0] = rslt.getShort(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((String[]) buf[13])[0] = rslt.getString(12, 1);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
      }
   }

}

