package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pagowwexportreport_impl extends GXWebReport
{
   public pagowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago", GXv_boolean2) ;
         pagowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV115Pgmname))}, new String[] {"GxObject"}) );
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
            AV95Title = "Lista de Pago" ;
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
         h4S0( true, 0) ;
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
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV22TFPagoId) && (0==AV23TFPagoId_To) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFPagoId), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV72TFPagoId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72TFPagoId_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFPagoId_To), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV24TFCitaId) && (0==AV25TFCitaId_To) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cita Id", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV24TFCitaId), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV73TFCitaId_To_Description = GXutil.format( "%1 (%2)", "Cita Id", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV73TFCitaId_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV25TFCitaId_To), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV27TFCitaCode_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cita Code", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFCitaCode_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV26TFCitaCode)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Cita Code", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFCitaCode, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV28TFSGCitaDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV29TFSGCitaDisponibilidadFecha_To)) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("SGCita Disponibilidad Fecha", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV28TFSGCitaDisponibilidadFecha, "99/99/99"), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV74TFSGCitaDisponibilidadFecha_To_Description = GXutil.format( "%1 (%2)", "SGCita Disponibilidad Fecha", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV74TFSGCitaDisponibilidadFecha_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV29TFSGCitaDisponibilidadFecha_To, "99/99/99"), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFPagoMonto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFPagoMonto_To)==0) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Monto", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV30TFPagoMonto, "ZZ9.99")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV75TFPagoMonto_To_Description = GXutil.format( "%1 (%2)", "Monto", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV75TFPagoMonto_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV31TFPagoMonto_To, "ZZ9.99")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV33TFPagoToken_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Token", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFPagoToken_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV32TFPagoToken)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Token", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFPagoToken, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV36TFPagoTipoDocumentoCliente_Sels.fromJSonString(AV34TFPagoTipoDocumentoCliente_SelsJson, null);
      if ( ! ( AV36TFPagoTipoDocumentoCliente_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV118GXV1 = 1 ;
         while ( AV118GXV1 <= AV36TFPagoTipoDocumentoCliente_Sels.size() )
         {
            AV37TFPagoTipoDocumentoCliente_Sel = (String)AV36TFPagoTipoDocumentoCliente_Sels.elementAt(-1+AV118GXV1) ;
            if ( AV84i == 1 )
            {
               AV35TFPagoTipoDocumentoCliente_SelDscs = "" ;
            }
            else
            {
               AV35TFPagoTipoDocumentoCliente_SelDscs += ", " ;
            }
            AV76FilterTFPagoTipoDocumentoCliente_SelValueDescription = com.projectthani.gxdomaintipodocumentocliente.getDescription(httpContext,(String)AV37TFPagoTipoDocumentoCliente_Sel) ;
            AV35TFPagoTipoDocumentoCliente_SelDscs += AV76FilterTFPagoTipoDocumentoCliente_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV118GXV1 = (int)(AV118GXV1+1) ;
         }
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Documento Cliente", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFPagoTipoDocumentoCliente_SelDscs, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV39TFPagoClienteNroDocumento_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39TFPagoClienteNroDocumento_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV38TFPagoClienteNroDocumento)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFPagoClienteNroDocumento, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV41TFPagoClienteDenominacion_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cliente Denominacion", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFPagoClienteDenominacion_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV40TFPagoClienteDenominacion)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Cliente Denominacion", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFPagoClienteDenominacion, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV43TFPagoClienteDireccion_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cliente Direccion", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFPagoClienteDireccion_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV42TFPagoClienteDireccion)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Cliente Direccion", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFPagoClienteDireccion, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV45TFPagoClienteEmail_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cliente Email", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45TFPagoClienteEmail_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV44TFPagoClienteEmail)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Cliente Email", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFPagoClienteEmail, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV48TFPagoTipoDocumento_Sels.fromJSonString(AV46TFPagoTipoDocumento_SelsJson, null);
      if ( ! ( AV48TFPagoTipoDocumento_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV119GXV2 = 1 ;
         while ( AV119GXV2 <= AV48TFPagoTipoDocumento_Sels.size() )
         {
            AV49TFPagoTipoDocumento_Sel = ((Number) AV48TFPagoTipoDocumento_Sels.elementAt(-1+AV119GXV2)).shortValue() ;
            if ( AV84i == 1 )
            {
               AV47TFPagoTipoDocumento_SelDscs = "" ;
            }
            else
            {
               AV47TFPagoTipoDocumento_SelDscs += ", " ;
            }
            AV77FilterTFPagoTipoDocumento_SelValueDescription = com.projectthani.gxdomaintipodocumentopago.getDescription(httpContext,(short)AV49TFPagoTipoDocumento_Sel) ;
            AV47TFPagoTipoDocumento_SelDscs += AV77FilterTFPagoTipoDocumento_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV119GXV2 = (int)(AV119GXV2+1) ;
         }
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Documento", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47TFPagoTipoDocumento_SelDscs, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV50TFPagoNumero) && (0==AV51TFPagoNumero_To) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Numero", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV50TFPagoNumero), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV78TFPagoNumero_To_Description = GXutil.format( "%1 (%2)", "Numero", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV78TFPagoNumero_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV51TFPagoNumero_To), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV52TFPagoFechaEmision)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV53TFPagoFechaEmision_To)) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha Emision", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV52TFPagoFechaEmision, "99/99/9999"), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV79TFPagoFechaEmision_To_Description = GXutil.format( "%1 (%2)", "Fecha Emision", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV79TFPagoFechaEmision_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV53TFPagoFechaEmision_To, "99/99/9999"), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV56TFPagoMoneda_Sels.fromJSonString(AV54TFPagoMoneda_SelsJson, null);
      if ( ! ( AV56TFPagoMoneda_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV120GXV3 = 1 ;
         while ( AV120GXV3 <= AV56TFPagoMoneda_Sels.size() )
         {
            AV57TFPagoMoneda_Sel = ((Number) AV56TFPagoMoneda_Sels.elementAt(-1+AV120GXV3)).shortValue() ;
            if ( AV84i == 1 )
            {
               AV55TFPagoMoneda_SelDscs = "" ;
            }
            else
            {
               AV55TFPagoMoneda_SelDscs += ", " ;
            }
            AV80FilterTFPagoMoneda_SelValueDescription = com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)AV57TFPagoMoneda_Sel) ;
            AV55TFPagoMoneda_SelDscs += AV80FilterTFPagoMoneda_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV120GXV3 = (int)(AV120GXV3+1) ;
         }
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Moneda", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV55TFPagoMoneda_SelDscs, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV65TFPagoNubefactRequest_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nubefact Request", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV65TFPagoNubefactRequest_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV64TFPagoNubefactRequest)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nubefact Request", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV64TFPagoNubefactRequest, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV67TFPagoNubefactResponse_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nubefact Response", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV67TFPagoNubefactResponse_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV66TFPagoNubefactResponse)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nubefact Response", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV66TFPagoNubefactResponse, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV98TFPagoRequest_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Request", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV98TFPagoRequest_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV97TFPagoRequest)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Request", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV97TFPagoRequest, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV100TFPagoResponse_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Response", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV100TFPagoResponse_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV99TFPagoResponse)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Response", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV99TFPagoResponse, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV102TFPagoPasarelaId_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Pasarela Id", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV102TFPagoPasarelaId_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV101TFPagoPasarelaId)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Pasarela Id", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV101TFPagoPasarelaId, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV103TFPagoStatusCode) && (0==AV104TFPagoStatusCode_To) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Status Code", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV103TFPagoStatusCode), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV107TFPagoStatusCode_To_Description = GXutil.format( "%1 (%2)", "Status Code", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV107TFPagoStatusCode_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV104TFPagoStatusCode_To), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV105TFDisponibilidadId) && (0==AV106TFDisponibilidadId_To) ) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Disponibilidad Id", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV105TFDisponibilidadId), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV108TFDisponibilidadId_To_Description = GXutil.format( "%1 (%2)", "Disponibilidad Id", "Hasta", "", "", "", "", "", "", "") ;
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV108TFDisponibilidadId_To_Description, "")), 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV106TFDisponibilidadId_To), "ZZZZZZZ9")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV110TFPagoEnlacePDF_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Enlace PDF", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV110TFPagoEnlacePDF_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV109TFPagoEnlacePDF)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Enlace PDF", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV109TFPagoEnlacePDF, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV112TFPagoEnlaceXML_Sel)==0) )
      {
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Enlace XML", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV112TFPagoEnlaceXML_Sel, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV111TFPagoEnlaceXML)==0) )
         {
            h4S0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Enlace XML", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV111TFPagoEnlaceXML, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV70TFPagoEstadoR_Sels.fromJSonString(AV68TFPagoEstadoR_SelsJson, null);
      if ( ! ( AV70TFPagoEstadoR_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV121GXV4 = 1 ;
         while ( AV121GXV4 <= AV70TFPagoEstadoR_Sels.size() )
         {
            AV71TFPagoEstadoR_Sel = (String)AV70TFPagoEstadoR_Sels.elementAt(-1+AV121GXV4) ;
            if ( AV84i == 1 )
            {
               AV69TFPagoEstadoR_SelDscs = "" ;
            }
            else
            {
               AV69TFPagoEstadoR_SelDscs += ", " ;
            }
            AV83FilterTFPagoEstadoR_SelValueDescription = com.projectthani.gxdomainestador.getDescription(httpContext,(String)AV71TFPagoEstadoR_Sel) ;
            AV69TFPagoEstadoR_SelDscs += AV83FilterTFPagoEstadoR_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV121GXV4 = (int)(AV121GXV4+1) ;
         }
         h4S0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado R", 25, Gx_line+0, 195, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV69TFPagoEstadoR_SelDscs, "")), 195, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4S0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4S0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 56, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Cita Id", 60, Gx_line+10, 86, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Cita Code", 90, Gx_line+10, 116, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("SGCita Disponibilidad Fecha", 120, Gx_line+10, 146, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Monto", 150, Gx_line+10, 176, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Token", 180, Gx_line+10, 206, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Documento Cliente", 210, Gx_line+10, 236, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nro Documento", 240, Gx_line+10, 266, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Cliente Denominacion", 270, Gx_line+10, 296, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Cliente Direccion", 300, Gx_line+10, 326, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Cliente Email", 330, Gx_line+10, 356, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Documento", 360, Gx_line+10, 386, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Numero", 390, Gx_line+10, 416, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha Emision", 420, Gx_line+10, 446, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Moneda", 450, Gx_line+10, 476, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nubefact Request", 480, Gx_line+10, 506, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nubefact Response", 510, Gx_line+10, 536, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Request", 540, Gx_line+10, 566, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Response", 570, Gx_line+10, 597, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Pasarela Id", 601, Gx_line+10, 629, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Status Code", 633, Gx_line+10, 660, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Disponibilidad Id", 664, Gx_line+10, 691, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Enlace PDF", 695, Gx_line+10, 723, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Enlace XML", 727, Gx_line+10, 755, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado R", 759, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV123Pagowwds_1_filterfulltext = AV13FilterFullText ;
      AV124Pagowwds_2_tfpagoid = AV22TFPagoId ;
      AV125Pagowwds_3_tfpagoid_to = AV23TFPagoId_To ;
      AV126Pagowwds_4_tfcitaid = AV24TFCitaId ;
      AV127Pagowwds_5_tfcitaid_to = AV25TFCitaId_To ;
      AV128Pagowwds_6_tfcitacode = AV26TFCitaCode ;
      AV129Pagowwds_7_tfcitacode_sel = AV27TFCitaCode_Sel ;
      AV130Pagowwds_8_tfsgcitadisponibilidadfecha = AV28TFSGCitaDisponibilidadFecha ;
      AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV29TFSGCitaDisponibilidadFecha_To ;
      AV132Pagowwds_10_tfpagomonto = AV30TFPagoMonto ;
      AV133Pagowwds_11_tfpagomonto_to = AV31TFPagoMonto_To ;
      AV134Pagowwds_12_tfpagotoken = AV32TFPagoToken ;
      AV135Pagowwds_13_tfpagotoken_sel = AV33TFPagoToken_Sel ;
      AV136Pagowwds_14_tfpagotipodocumentocliente_sels = AV36TFPagoTipoDocumentoCliente_Sels ;
      AV137Pagowwds_15_tfpagoclientenrodocumento = AV38TFPagoClienteNroDocumento ;
      AV138Pagowwds_16_tfpagoclientenrodocumento_sel = AV39TFPagoClienteNroDocumento_Sel ;
      AV139Pagowwds_17_tfpagoclientedenominacion = AV40TFPagoClienteDenominacion ;
      AV140Pagowwds_18_tfpagoclientedenominacion_sel = AV41TFPagoClienteDenominacion_Sel ;
      AV141Pagowwds_19_tfpagoclientedireccion = AV42TFPagoClienteDireccion ;
      AV142Pagowwds_20_tfpagoclientedireccion_sel = AV43TFPagoClienteDireccion_Sel ;
      AV143Pagowwds_21_tfpagoclienteemail = AV44TFPagoClienteEmail ;
      AV144Pagowwds_22_tfpagoclienteemail_sel = AV45TFPagoClienteEmail_Sel ;
      AV145Pagowwds_23_tfpagotipodocumento_sels = AV48TFPagoTipoDocumento_Sels ;
      AV146Pagowwds_24_tfpagonumero = AV50TFPagoNumero ;
      AV147Pagowwds_25_tfpagonumero_to = AV51TFPagoNumero_To ;
      AV148Pagowwds_26_tfpagofechaemision = AV52TFPagoFechaEmision ;
      AV149Pagowwds_27_tfpagofechaemision_to = AV53TFPagoFechaEmision_To ;
      AV150Pagowwds_28_tfpagomoneda_sels = AV56TFPagoMoneda_Sels ;
      AV151Pagowwds_29_tfpagonubefactrequest = AV64TFPagoNubefactRequest ;
      AV152Pagowwds_30_tfpagonubefactrequest_sel = AV65TFPagoNubefactRequest_Sel ;
      AV153Pagowwds_31_tfpagonubefactresponse = AV66TFPagoNubefactResponse ;
      AV154Pagowwds_32_tfpagonubefactresponse_sel = AV67TFPagoNubefactResponse_Sel ;
      AV155Pagowwds_33_tfpagorequest = AV97TFPagoRequest ;
      AV156Pagowwds_34_tfpagorequest_sel = AV98TFPagoRequest_Sel ;
      AV157Pagowwds_35_tfpagoresponse = AV99TFPagoResponse ;
      AV158Pagowwds_36_tfpagoresponse_sel = AV100TFPagoResponse_Sel ;
      AV159Pagowwds_37_tfpagopasarelaid = AV101TFPagoPasarelaId ;
      AV160Pagowwds_38_tfpagopasarelaid_sel = AV102TFPagoPasarelaId_Sel ;
      AV161Pagowwds_39_tfpagostatuscode = AV103TFPagoStatusCode ;
      AV162Pagowwds_40_tfpagostatuscode_to = AV104TFPagoStatusCode_To ;
      AV163Pagowwds_41_tfdisponibilidadid = AV105TFDisponibilidadId ;
      AV164Pagowwds_42_tfdisponibilidadid_to = AV106TFDisponibilidadId_To ;
      AV165Pagowwds_43_tfpagoenlacepdf = AV109TFPagoEnlacePDF ;
      AV166Pagowwds_44_tfpagoenlacepdf_sel = AV110TFPagoEnlacePDF_Sel ;
      AV167Pagowwds_45_tfpagoenlacexml = AV111TFPagoEnlaceXML ;
      AV168Pagowwds_46_tfpagoenlacexml_sel = AV112TFPagoEnlaceXML_Sel ;
      AV169Pagowwds_47_tfpagoestador_sels = AV70TFPagoEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV136Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV145Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV150Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV169Pagowwds_47_tfpagoestador_sels ,
                                           AV123Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV124Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV125Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV126Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV127Pagowwds_5_tfcitaid_to) ,
                                           AV129Pagowwds_7_tfcitacode_sel ,
                                           AV128Pagowwds_6_tfcitacode ,
                                           AV130Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV132Pagowwds_10_tfpagomonto ,
                                           AV133Pagowwds_11_tfpagomonto_to ,
                                           AV135Pagowwds_13_tfpagotoken_sel ,
                                           AV134Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV136Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV138Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV137Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV140Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV139Pagowwds_17_tfpagoclientedenominacion ,
                                           AV142Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV141Pagowwds_19_tfpagoclientedireccion ,
                                           AV144Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV143Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV145Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV146Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV147Pagowwds_25_tfpagonumero_to) ,
                                           AV148Pagowwds_26_tfpagofechaemision ,
                                           AV149Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV150Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV152Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV151Pagowwds_29_tfpagonubefactrequest ,
                                           AV154Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV153Pagowwds_31_tfpagonubefactresponse ,
                                           AV156Pagowwds_34_tfpagorequest_sel ,
                                           AV155Pagowwds_33_tfpagorequest ,
                                           AV158Pagowwds_36_tfpagoresponse_sel ,
                                           AV157Pagowwds_35_tfpagoresponse ,
                                           AV160Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV159Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV161Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV162Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV163Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV164Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV166Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV165Pagowwds_43_tfpagoenlacepdf ,
                                           AV168Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV167Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV169Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV123Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV123Pagowwds_1_filterfulltext), "%", "") ;
      lV128Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV128Pagowwds_6_tfcitacode), "%", "") ;
      lV134Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV134Pagowwds_12_tfpagotoken), "%", "") ;
      lV137Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV137Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV139Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV139Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV141Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV141Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV143Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV143Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV151Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV151Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV153Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV153Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV155Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV155Pagowwds_33_tfpagorequest), "%", "") ;
      lV157Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV157Pagowwds_35_tfpagoresponse), "%", "") ;
      lV159Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV159Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV165Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV165Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV167Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV167Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P004S2 */
      pr_default.execute(0, new Object[] {lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, lV123Pagowwds_1_filterfulltext, Integer.valueOf(AV124Pagowwds_2_tfpagoid), Integer.valueOf(AV125Pagowwds_3_tfpagoid_to), Integer.valueOf(AV126Pagowwds_4_tfcitaid), Integer.valueOf(AV127Pagowwds_5_tfcitaid_to), lV128Pagowwds_6_tfcitacode, AV129Pagowwds_7_tfcitacode_sel, AV130Pagowwds_8_tfsgcitadisponibilidadfecha, AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV132Pagowwds_10_tfpagomonto, AV133Pagowwds_11_tfpagomonto_to, lV134Pagowwds_12_tfpagotoken, AV135Pagowwds_13_tfpagotoken_sel, lV137Pagowwds_15_tfpagoclientenrodocumento, AV138Pagowwds_16_tfpagoclientenrodocumento_sel, lV139Pagowwds_17_tfpagoclientedenominacion, AV140Pagowwds_18_tfpagoclientedenominacion_sel, lV141Pagowwds_19_tfpagoclientedireccion, AV142Pagowwds_20_tfpagoclientedireccion_sel, lV143Pagowwds_21_tfpagoclienteemail, AV144Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV146Pagowwds_24_tfpagonumero), Integer.valueOf(AV147Pagowwds_25_tfpagonumero_to), AV148Pagowwds_26_tfpagofechaemision, AV149Pagowwds_27_tfpagofechaemision_to, lV151Pagowwds_29_tfpagonubefactrequest, AV152Pagowwds_30_tfpagonubefactrequest_sel, lV153Pagowwds_31_tfpagonubefactresponse, AV154Pagowwds_32_tfpagonubefactresponse_sel, lV155Pagowwds_33_tfpagorequest, AV156Pagowwds_34_tfpagorequest_sel, lV157Pagowwds_35_tfpagoresponse, AV158Pagowwds_36_tfpagoresponse_sel, lV159Pagowwds_37_tfpagopasarelaid, AV160Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV161Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV162Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV163Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV164Pagowwds_42_tfdisponibilidadid_to), lV165Pagowwds_43_tfpagoenlacepdf, AV166Pagowwds_44_tfpagoenlacepdf_sel, lV167Pagowwds_45_tfpagoenlacexml, AV168Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A21SGCitaDisponibilidadId = P004S2_A21SGCitaDisponibilidadId[0] ;
         A34DisponibilidadId = P004S2_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P004S2_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P004S2_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P004S2_A252PagoFechaEmision[0] ;
         A245PagoNumero = P004S2_A245PagoNumero[0] ;
         A242PagoMonto = P004S2_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P004S2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004S2_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P004S2_A19CitaId[0] ;
         n19CitaId = P004S2_n19CitaId[0] ;
         A47PagoId = P004S2_A47PagoId[0] ;
         A246PagoEstadoR = P004S2_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P004S2_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P004S2_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P004S2_A310PagoPasarelaId[0] ;
         A309PagoResponse = P004S2_A309PagoResponse[0] ;
         A308PagoRequest = P004S2_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P004S2_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P004S2_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P004S2_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P004S2_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P004S2_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P004S2_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P004S2_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P004S2_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P004S2_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P004S2_A243PagoToken[0] ;
         A64CitaCode = P004S2_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P004S2_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P004S2_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P004S2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004S2_n66SGCitaDisponibilidadFecha[0] ;
         AV14PagoTipoDocumentoClienteDescription = com.projectthani.gxdomaintipodocumentocliente.getDescription(httpContext,(String)A247PagoTipoDocumentoCliente) ;
         AV15PagoTipoDocumentoDescription = com.projectthani.gxdomaintipodocumentopago.getDescription(httpContext,(short)A244PagoTipoDocumento) ;
         AV16PagoMonedaDescription = com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)A253PagoMoneda) ;
         AV17PagoEstadoRDescription = com.projectthani.gxdomainestador.getDescription(httpContext,(String)A246PagoEstadoR) ;
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
         h4S0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9")), 30, Gx_line+10, 56, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), 60, Gx_line+10, 86, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A64CitaCode, "")), 90, Gx_line+10, 116, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), 120, Gx_line+10, 146, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A242PagoMonto, "ZZ9.99")), 150, Gx_line+10, 176, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A243PagoToken, "")), 180, Gx_line+10, 206, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14PagoTipoDocumentoClienteDescription, "")), 210, Gx_line+10, 236, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A248PagoClienteNroDocumento, "")), 240, Gx_line+10, 266, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A249PagoClienteDenominacion, "")), 270, Gx_line+10, 296, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A250PagoClienteDireccion, "")), 300, Gx_line+10, 326, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A251PagoClienteEmail, "")), 330, Gx_line+10, 356, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15PagoTipoDocumentoDescription, "")), 360, Gx_line+10, 386, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9")), 390, Gx_line+10, 416, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A252PagoFechaEmision, "99/99/9999"), 420, Gx_line+10, 446, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV16PagoMonedaDescription, "")), 450, Gx_line+10, 476, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A256PagoNubefactRequest, 480, Gx_line+10, 506, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A257PagoNubefactResponse, 510, Gx_line+10, 536, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A308PagoRequest, 540, Gx_line+10, 566, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A309PagoResponse, 570, Gx_line+10, 597, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A310PagoPasarelaId, "")), 601, Gx_line+10, 629, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9")), 633, Gx_line+10, 660, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")), 664, Gx_line+10, 691, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A338PagoEnlacePDF, "")), 695, Gx_line+10, 723, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A339PagoEnlaceXML, "")), 727, Gx_line+10, 755, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV17PagoEstadoRDescription, "")), 759, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV18Session.getValue("PagoWWGridState"), "") == 0 )
      {
         AV20GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PagoWWGridState"), null, null);
      }
      else
      {
         AV20GridState.fromxml(AV18Session.getValue("PagoWWGridState"), null, null);
      }
      AV11OrderedBy = AV20GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV20GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV170GXV5 = 1 ;
      while ( AV170GXV5 <= AV20GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV21GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV20GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV170GXV5));
         if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOID") == 0 )
         {
            AV22TFPagoId = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV23TFPagoId_To = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV24TFCitaId = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV25TFCitaId_To = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV26TFCitaCode = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV27TFCitaCode_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV28TFSGCitaDisponibilidadFecha = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV29TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONTO") == 0 )
         {
            AV30TFPagoMonto = CommonUtil.decimalVal( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV31TFPagoMonto_To = CommonUtil.decimalVal( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN") == 0 )
         {
            AV32TFPagoToken = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN_SEL") == 0 )
         {
            AV33TFPagoToken_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTOCLIENTE_SEL") == 0 )
         {
            AV34TFPagoTipoDocumentoCliente_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFPagoTipoDocumentoCliente_Sels.fromJSonString(AV34TFPagoTipoDocumentoCliente_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO") == 0 )
         {
            AV38TFPagoClienteNroDocumento = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV39TFPagoClienteNroDocumento_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION") == 0 )
         {
            AV40TFPagoClienteDenominacion = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION_SEL") == 0 )
         {
            AV41TFPagoClienteDenominacion_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION") == 0 )
         {
            AV42TFPagoClienteDireccion = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION_SEL") == 0 )
         {
            AV43TFPagoClienteDireccion_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL") == 0 )
         {
            AV44TFPagoClienteEmail = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL_SEL") == 0 )
         {
            AV45TFPagoClienteEmail_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTO_SEL") == 0 )
         {
            AV46TFPagoTipoDocumento_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFPagoTipoDocumento_Sels.fromJSonString(AV46TFPagoTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUMERO") == 0 )
         {
            AV50TFPagoNumero = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV51TFPagoNumero_To = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOFECHAEMISION") == 0 )
         {
            AV52TFPagoFechaEmision = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV53TFPagoFechaEmision_To = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONEDA_SEL") == 0 )
         {
            AV54TFPagoMoneda_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFPagoMoneda_Sels.fromJSonString(AV54TFPagoMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST") == 0 )
         {
            AV64TFPagoNubefactRequest = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST_SEL") == 0 )
         {
            AV65TFPagoNubefactRequest_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE") == 0 )
         {
            AV66TFPagoNubefactResponse = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE_SEL") == 0 )
         {
            AV67TFPagoNubefactResponse_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST") == 0 )
         {
            AV97TFPagoRequest = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST_SEL") == 0 )
         {
            AV98TFPagoRequest_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE") == 0 )
         {
            AV99TFPagoResponse = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE_SEL") == 0 )
         {
            AV100TFPagoResponse_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID") == 0 )
         {
            AV101TFPagoPasarelaId = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID_SEL") == 0 )
         {
            AV102TFPagoPasarelaId_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOSTATUSCODE") == 0 )
         {
            AV103TFPagoStatusCode = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV104TFPagoStatusCode_To = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV105TFDisponibilidadId = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV106TFDisponibilidadId_To = (int)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF") == 0 )
         {
            AV109TFPagoEnlacePDF = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF_SEL") == 0 )
         {
            AV110TFPagoEnlacePDF_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML") == 0 )
         {
            AV111TFPagoEnlaceXML = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML_SEL") == 0 )
         {
            AV112TFPagoEnlaceXML_Sel = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOESTADOR_SEL") == 0 )
         {
            AV68TFPagoEstadoR_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV70TFPagoEstadoR_Sels.fromJSonString(AV68TFPagoEstadoR_SelsJson, null);
         }
         AV170GXV5 = (int)(AV170GXV5+1) ;
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

   public void h4S0( boolean bFoot ,
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
      AV115Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV95Title = "" ;
      AV13FilterFullText = "" ;
      AV72TFPagoId_To_Description = "" ;
      AV73TFCitaId_To_Description = "" ;
      AV27TFCitaCode_Sel = "" ;
      AV26TFCitaCode = "" ;
      AV28TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV29TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV74TFSGCitaDisponibilidadFecha_To_Description = "" ;
      AV30TFPagoMonto = DecimalUtil.ZERO ;
      AV31TFPagoMonto_To = DecimalUtil.ZERO ;
      AV75TFPagoMonto_To_Description = "" ;
      AV33TFPagoToken_Sel = "" ;
      AV32TFPagoToken = "" ;
      AV36TFPagoTipoDocumentoCliente_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFPagoTipoDocumentoCliente_SelsJson = "" ;
      AV37TFPagoTipoDocumentoCliente_Sel = "" ;
      AV35TFPagoTipoDocumentoCliente_SelDscs = "" ;
      AV76FilterTFPagoTipoDocumentoCliente_SelValueDescription = "" ;
      AV39TFPagoClienteNroDocumento_Sel = "" ;
      AV38TFPagoClienteNroDocumento = "" ;
      AV41TFPagoClienteDenominacion_Sel = "" ;
      AV40TFPagoClienteDenominacion = "" ;
      AV43TFPagoClienteDireccion_Sel = "" ;
      AV42TFPagoClienteDireccion = "" ;
      AV45TFPagoClienteEmail_Sel = "" ;
      AV44TFPagoClienteEmail = "" ;
      AV48TFPagoTipoDocumento_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV46TFPagoTipoDocumento_SelsJson = "" ;
      AV47TFPagoTipoDocumento_SelDscs = "" ;
      AV77FilterTFPagoTipoDocumento_SelValueDescription = "" ;
      AV78TFPagoNumero_To_Description = "" ;
      AV52TFPagoFechaEmision = GXutil.nullDate() ;
      AV53TFPagoFechaEmision_To = GXutil.nullDate() ;
      AV79TFPagoFechaEmision_To_Description = "" ;
      AV56TFPagoMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV54TFPagoMoneda_SelsJson = "" ;
      AV55TFPagoMoneda_SelDscs = "" ;
      AV80FilterTFPagoMoneda_SelValueDescription = "" ;
      AV65TFPagoNubefactRequest_Sel = "" ;
      AV64TFPagoNubefactRequest = "" ;
      AV67TFPagoNubefactResponse_Sel = "" ;
      AV66TFPagoNubefactResponse = "" ;
      AV98TFPagoRequest_Sel = "" ;
      AV97TFPagoRequest = "" ;
      AV100TFPagoResponse_Sel = "" ;
      AV99TFPagoResponse = "" ;
      AV102TFPagoPasarelaId_Sel = "" ;
      AV101TFPagoPasarelaId = "" ;
      AV107TFPagoStatusCode_To_Description = "" ;
      AV108TFDisponibilidadId_To_Description = "" ;
      AV110TFPagoEnlacePDF_Sel = "" ;
      AV109TFPagoEnlacePDF = "" ;
      AV112TFPagoEnlaceXML_Sel = "" ;
      AV111TFPagoEnlaceXML = "" ;
      AV70TFPagoEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFPagoEstadoR_SelsJson = "" ;
      AV71TFPagoEstadoR_Sel = "" ;
      AV69TFPagoEstadoR_SelDscs = "" ;
      AV83FilterTFPagoEstadoR_SelValueDescription = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A246PagoEstadoR = "" ;
      A64CitaCode = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      AV123Pagowwds_1_filterfulltext = "" ;
      AV128Pagowwds_6_tfcitacode = "" ;
      AV129Pagowwds_7_tfcitacode_sel = "" ;
      AV130Pagowwds_8_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV132Pagowwds_10_tfpagomonto = DecimalUtil.ZERO ;
      AV133Pagowwds_11_tfpagomonto_to = DecimalUtil.ZERO ;
      AV134Pagowwds_12_tfpagotoken = "" ;
      AV135Pagowwds_13_tfpagotoken_sel = "" ;
      AV136Pagowwds_14_tfpagotipodocumentocliente_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV137Pagowwds_15_tfpagoclientenrodocumento = "" ;
      AV138Pagowwds_16_tfpagoclientenrodocumento_sel = "" ;
      AV139Pagowwds_17_tfpagoclientedenominacion = "" ;
      AV140Pagowwds_18_tfpagoclientedenominacion_sel = "" ;
      AV141Pagowwds_19_tfpagoclientedireccion = "" ;
      AV142Pagowwds_20_tfpagoclientedireccion_sel = "" ;
      AV143Pagowwds_21_tfpagoclienteemail = "" ;
      AV144Pagowwds_22_tfpagoclienteemail_sel = "" ;
      AV145Pagowwds_23_tfpagotipodocumento_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV148Pagowwds_26_tfpagofechaemision = GXutil.nullDate() ;
      AV149Pagowwds_27_tfpagofechaemision_to = GXutil.nullDate() ;
      AV150Pagowwds_28_tfpagomoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV151Pagowwds_29_tfpagonubefactrequest = "" ;
      AV152Pagowwds_30_tfpagonubefactrequest_sel = "" ;
      AV153Pagowwds_31_tfpagonubefactresponse = "" ;
      AV154Pagowwds_32_tfpagonubefactresponse_sel = "" ;
      AV155Pagowwds_33_tfpagorequest = "" ;
      AV156Pagowwds_34_tfpagorequest_sel = "" ;
      AV157Pagowwds_35_tfpagoresponse = "" ;
      AV158Pagowwds_36_tfpagoresponse_sel = "" ;
      AV159Pagowwds_37_tfpagopasarelaid = "" ;
      AV160Pagowwds_38_tfpagopasarelaid_sel = "" ;
      AV165Pagowwds_43_tfpagoenlacepdf = "" ;
      AV166Pagowwds_44_tfpagoenlacepdf_sel = "" ;
      AV167Pagowwds_45_tfpagoenlacexml = "" ;
      AV168Pagowwds_46_tfpagoenlacexml_sel = "" ;
      AV169Pagowwds_47_tfpagoestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV123Pagowwds_1_filterfulltext = "" ;
      lV128Pagowwds_6_tfcitacode = "" ;
      lV134Pagowwds_12_tfpagotoken = "" ;
      lV137Pagowwds_15_tfpagoclientenrodocumento = "" ;
      lV139Pagowwds_17_tfpagoclientedenominacion = "" ;
      lV141Pagowwds_19_tfpagoclientedireccion = "" ;
      lV143Pagowwds_21_tfpagoclienteemail = "" ;
      lV151Pagowwds_29_tfpagonubefactrequest = "" ;
      lV153Pagowwds_31_tfpagonubefactresponse = "" ;
      lV155Pagowwds_33_tfpagorequest = "" ;
      lV157Pagowwds_35_tfpagoresponse = "" ;
      lV159Pagowwds_37_tfpagopasarelaid = "" ;
      lV165Pagowwds_43_tfpagoenlacepdf = "" ;
      lV167Pagowwds_45_tfpagoenlacexml = "" ;
      P004S2_A21SGCitaDisponibilidadId = new int[1] ;
      P004S2_A34DisponibilidadId = new int[1] ;
      P004S2_n34DisponibilidadId = new boolean[] {false} ;
      P004S2_A311PagoStatusCode = new int[1] ;
      P004S2_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P004S2_A245PagoNumero = new int[1] ;
      P004S2_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004S2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004S2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P004S2_A19CitaId = new int[1] ;
      P004S2_n19CitaId = new boolean[] {false} ;
      P004S2_A47PagoId = new int[1] ;
      P004S2_A246PagoEstadoR = new String[] {""} ;
      P004S2_A339PagoEnlaceXML = new String[] {""} ;
      P004S2_A338PagoEnlacePDF = new String[] {""} ;
      P004S2_A310PagoPasarelaId = new String[] {""} ;
      P004S2_A309PagoResponse = new String[] {""} ;
      P004S2_A308PagoRequest = new String[] {""} ;
      P004S2_A257PagoNubefactResponse = new String[] {""} ;
      P004S2_A256PagoNubefactRequest = new String[] {""} ;
      P004S2_A253PagoMoneda = new short[1] ;
      P004S2_A244PagoTipoDocumento = new short[1] ;
      P004S2_A251PagoClienteEmail = new String[] {""} ;
      P004S2_A250PagoClienteDireccion = new String[] {""} ;
      P004S2_A249PagoClienteDenominacion = new String[] {""} ;
      P004S2_A248PagoClienteNroDocumento = new String[] {""} ;
      P004S2_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P004S2_A243PagoToken = new String[] {""} ;
      P004S2_A64CitaCode = new String[] {""} ;
      AV14PagoTipoDocumentoClienteDescription = "" ;
      AV15PagoTipoDocumentoDescription = "" ;
      AV16PagoMonedaDescription = "" ;
      AV17PagoEstadoRDescription = "" ;
      AV18Session = httpContext.getWebSession();
      AV20GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV21GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagowwexportreport__default(),
         new Object[] {
             new Object[] {
            P004S2_A21SGCitaDisponibilidadId, P004S2_A34DisponibilidadId, P004S2_n34DisponibilidadId, P004S2_A311PagoStatusCode, P004S2_A252PagoFechaEmision, P004S2_A245PagoNumero, P004S2_A242PagoMonto, P004S2_A66SGCitaDisponibilidadFecha, P004S2_n66SGCitaDisponibilidadFecha, P004S2_A19CitaId,
            P004S2_n19CitaId, P004S2_A47PagoId, P004S2_A246PagoEstadoR, P004S2_A339PagoEnlaceXML, P004S2_A338PagoEnlacePDF, P004S2_A310PagoPasarelaId, P004S2_A309PagoResponse, P004S2_A308PagoRequest, P004S2_A257PagoNubefactResponse, P004S2_A256PagoNubefactRequest,
            P004S2_A253PagoMoneda, P004S2_A244PagoTipoDocumento, P004S2_A251PagoClienteEmail, P004S2_A250PagoClienteDireccion, P004S2_A249PagoClienteDenominacion, P004S2_A248PagoClienteNroDocumento, P004S2_A247PagoTipoDocumentoCliente, P004S2_A243PagoToken, P004S2_A64CitaCode
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV115Pgmname = "PagoWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV115Pgmname = "PagoWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV49TFPagoTipoDocumento_Sel ;
   private short AV57TFPagoMoneda_Sel ;
   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV22TFPagoId ;
   private int AV23TFPagoId_To ;
   private int AV24TFCitaId ;
   private int AV25TFCitaId_To ;
   private int AV118GXV1 ;
   private int AV119GXV2 ;
   private int AV50TFPagoNumero ;
   private int AV51TFPagoNumero_To ;
   private int AV120GXV3 ;
   private int AV103TFPagoStatusCode ;
   private int AV104TFPagoStatusCode_To ;
   private int AV105TFDisponibilidadId ;
   private int AV106TFDisponibilidadId_To ;
   private int AV121GXV4 ;
   private int A47PagoId ;
   private int A19CitaId ;
   private int A245PagoNumero ;
   private int A311PagoStatusCode ;
   private int A34DisponibilidadId ;
   private int AV124Pagowwds_2_tfpagoid ;
   private int AV125Pagowwds_3_tfpagoid_to ;
   private int AV126Pagowwds_4_tfcitaid ;
   private int AV127Pagowwds_5_tfcitaid_to ;
   private int AV146Pagowwds_24_tfpagonumero ;
   private int AV147Pagowwds_25_tfpagonumero_to ;
   private int AV161Pagowwds_39_tfpagostatuscode ;
   private int AV162Pagowwds_40_tfpagostatuscode_to ;
   private int AV163Pagowwds_41_tfdisponibilidadid ;
   private int AV164Pagowwds_42_tfdisponibilidadid_to ;
   private int AV136Pagowwds_14_tfpagotipodocumentocliente_sels_size ;
   private int AV145Pagowwds_23_tfpagotipodocumento_sels_size ;
   private int AV150Pagowwds_28_tfpagomoneda_sels_size ;
   private int AV169Pagowwds_47_tfpagoestador_sels_size ;
   private int A21SGCitaDisponibilidadId ;
   private int AV170GXV5 ;
   private long AV84i ;
   private java.math.BigDecimal AV30TFPagoMonto ;
   private java.math.BigDecimal AV31TFPagoMonto_To ;
   private java.math.BigDecimal A242PagoMonto ;
   private java.math.BigDecimal AV132Pagowwds_10_tfpagomonto ;
   private java.math.BigDecimal AV133Pagowwds_11_tfpagomonto_to ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV115Pgmname ;
   private String AV37TFPagoTipoDocumentoCliente_Sel ;
   private String AV71TFPagoEstadoR_Sel ;
   private String A247PagoTipoDocumentoCliente ;
   private String A246PagoEstadoR ;
   private String scmdbuf ;
   private java.util.Date AV28TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV29TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV52TFPagoFechaEmision ;
   private java.util.Date AV53TFPagoFechaEmision_To ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private java.util.Date AV130Pagowwds_8_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date AV148Pagowwds_26_tfpagofechaemision ;
   private java.util.Date AV149Pagowwds_27_tfpagofechaemision_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n34DisponibilidadId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n19CitaId ;
   private String AV34TFPagoTipoDocumentoCliente_SelsJson ;
   private String AV46TFPagoTipoDocumento_SelsJson ;
   private String AV54TFPagoMoneda_SelsJson ;
   private String AV68TFPagoEstadoR_SelsJson ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String AV95Title ;
   private String AV13FilterFullText ;
   private String AV72TFPagoId_To_Description ;
   private String AV73TFCitaId_To_Description ;
   private String AV27TFCitaCode_Sel ;
   private String AV26TFCitaCode ;
   private String AV74TFSGCitaDisponibilidadFecha_To_Description ;
   private String AV75TFPagoMonto_To_Description ;
   private String AV33TFPagoToken_Sel ;
   private String AV32TFPagoToken ;
   private String AV35TFPagoTipoDocumentoCliente_SelDscs ;
   private String AV76FilterTFPagoTipoDocumentoCliente_SelValueDescription ;
   private String AV39TFPagoClienteNroDocumento_Sel ;
   private String AV38TFPagoClienteNroDocumento ;
   private String AV41TFPagoClienteDenominacion_Sel ;
   private String AV40TFPagoClienteDenominacion ;
   private String AV43TFPagoClienteDireccion_Sel ;
   private String AV42TFPagoClienteDireccion ;
   private String AV45TFPagoClienteEmail_Sel ;
   private String AV44TFPagoClienteEmail ;
   private String AV47TFPagoTipoDocumento_SelDscs ;
   private String AV77FilterTFPagoTipoDocumento_SelValueDescription ;
   private String AV78TFPagoNumero_To_Description ;
   private String AV79TFPagoFechaEmision_To_Description ;
   private String AV55TFPagoMoneda_SelDscs ;
   private String AV80FilterTFPagoMoneda_SelValueDescription ;
   private String AV65TFPagoNubefactRequest_Sel ;
   private String AV64TFPagoNubefactRequest ;
   private String AV67TFPagoNubefactResponse_Sel ;
   private String AV66TFPagoNubefactResponse ;
   private String AV98TFPagoRequest_Sel ;
   private String AV97TFPagoRequest ;
   private String AV100TFPagoResponse_Sel ;
   private String AV99TFPagoResponse ;
   private String AV102TFPagoPasarelaId_Sel ;
   private String AV101TFPagoPasarelaId ;
   private String AV107TFPagoStatusCode_To_Description ;
   private String AV108TFDisponibilidadId_To_Description ;
   private String AV110TFPagoEnlacePDF_Sel ;
   private String AV109TFPagoEnlacePDF ;
   private String AV112TFPagoEnlaceXML_Sel ;
   private String AV111TFPagoEnlaceXML ;
   private String AV69TFPagoEstadoR_SelDscs ;
   private String AV83FilterTFPagoEstadoR_SelValueDescription ;
   private String A64CitaCode ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String AV123Pagowwds_1_filterfulltext ;
   private String AV128Pagowwds_6_tfcitacode ;
   private String AV129Pagowwds_7_tfcitacode_sel ;
   private String AV134Pagowwds_12_tfpagotoken ;
   private String AV135Pagowwds_13_tfpagotoken_sel ;
   private String AV137Pagowwds_15_tfpagoclientenrodocumento ;
   private String AV138Pagowwds_16_tfpagoclientenrodocumento_sel ;
   private String AV139Pagowwds_17_tfpagoclientedenominacion ;
   private String AV140Pagowwds_18_tfpagoclientedenominacion_sel ;
   private String AV141Pagowwds_19_tfpagoclientedireccion ;
   private String AV142Pagowwds_20_tfpagoclientedireccion_sel ;
   private String AV143Pagowwds_21_tfpagoclienteemail ;
   private String AV144Pagowwds_22_tfpagoclienteemail_sel ;
   private String AV151Pagowwds_29_tfpagonubefactrequest ;
   private String AV152Pagowwds_30_tfpagonubefactrequest_sel ;
   private String AV153Pagowwds_31_tfpagonubefactresponse ;
   private String AV154Pagowwds_32_tfpagonubefactresponse_sel ;
   private String AV155Pagowwds_33_tfpagorequest ;
   private String AV156Pagowwds_34_tfpagorequest_sel ;
   private String AV157Pagowwds_35_tfpagoresponse ;
   private String AV158Pagowwds_36_tfpagoresponse_sel ;
   private String AV159Pagowwds_37_tfpagopasarelaid ;
   private String AV160Pagowwds_38_tfpagopasarelaid_sel ;
   private String AV165Pagowwds_43_tfpagoenlacepdf ;
   private String AV166Pagowwds_44_tfpagoenlacepdf_sel ;
   private String AV167Pagowwds_45_tfpagoenlacexml ;
   private String AV168Pagowwds_46_tfpagoenlacexml_sel ;
   private String lV123Pagowwds_1_filterfulltext ;
   private String lV128Pagowwds_6_tfcitacode ;
   private String lV134Pagowwds_12_tfpagotoken ;
   private String lV137Pagowwds_15_tfpagoclientenrodocumento ;
   private String lV139Pagowwds_17_tfpagoclientedenominacion ;
   private String lV141Pagowwds_19_tfpagoclientedireccion ;
   private String lV143Pagowwds_21_tfpagoclienteemail ;
   private String lV151Pagowwds_29_tfpagonubefactrequest ;
   private String lV153Pagowwds_31_tfpagonubefactresponse ;
   private String lV155Pagowwds_33_tfpagorequest ;
   private String lV157Pagowwds_35_tfpagoresponse ;
   private String lV159Pagowwds_37_tfpagopasarelaid ;
   private String lV165Pagowwds_43_tfpagoenlacepdf ;
   private String lV167Pagowwds_45_tfpagoenlacexml ;
   private String AV14PagoTipoDocumentoClienteDescription ;
   private String AV15PagoTipoDocumentoDescription ;
   private String AV16PagoMonedaDescription ;
   private String AV17PagoEstadoRDescription ;
   private String AV93PageInfo ;
   private String AV90DateInfo ;
   private String AV88AppName ;
   private String AV94Phone ;
   private String AV92Mail ;
   private String AV96Website ;
   private String AV85AddressLine1 ;
   private String AV86AddressLine2 ;
   private String AV87AddressLine3 ;
   private GXSimpleCollection<Short> AV48TFPagoTipoDocumento_Sels ;
   private GXSimpleCollection<Short> AV56TFPagoMoneda_Sels ;
   private GXSimpleCollection<Short> AV145Pagowwds_23_tfpagotipodocumento_sels ;
   private GXSimpleCollection<Short> AV150Pagowwds_28_tfpagomoneda_sels ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private IDataStoreProvider pr_default ;
   private int[] P004S2_A21SGCitaDisponibilidadId ;
   private int[] P004S2_A34DisponibilidadId ;
   private boolean[] P004S2_n34DisponibilidadId ;
   private int[] P004S2_A311PagoStatusCode ;
   private java.util.Date[] P004S2_A252PagoFechaEmision ;
   private int[] P004S2_A245PagoNumero ;
   private java.math.BigDecimal[] P004S2_A242PagoMonto ;
   private java.util.Date[] P004S2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P004S2_n66SGCitaDisponibilidadFecha ;
   private int[] P004S2_A19CitaId ;
   private boolean[] P004S2_n19CitaId ;
   private int[] P004S2_A47PagoId ;
   private String[] P004S2_A246PagoEstadoR ;
   private String[] P004S2_A339PagoEnlaceXML ;
   private String[] P004S2_A338PagoEnlacePDF ;
   private String[] P004S2_A310PagoPasarelaId ;
   private String[] P004S2_A309PagoResponse ;
   private String[] P004S2_A308PagoRequest ;
   private String[] P004S2_A257PagoNubefactResponse ;
   private String[] P004S2_A256PagoNubefactRequest ;
   private short[] P004S2_A253PagoMoneda ;
   private short[] P004S2_A244PagoTipoDocumento ;
   private String[] P004S2_A251PagoClienteEmail ;
   private String[] P004S2_A250PagoClienteDireccion ;
   private String[] P004S2_A249PagoClienteDenominacion ;
   private String[] P004S2_A248PagoClienteNroDocumento ;
   private String[] P004S2_A247PagoTipoDocumentoCliente ;
   private String[] P004S2_A243PagoToken ;
   private String[] P004S2_A64CitaCode ;
   private GXSimpleCollection<String> AV36TFPagoTipoDocumentoCliente_Sels ;
   private GXSimpleCollection<String> AV70TFPagoEstadoR_Sels ;
   private GXSimpleCollection<String> AV136Pagowwds_14_tfpagotipodocumentocliente_sels ;
   private GXSimpleCollection<String> AV169Pagowwds_47_tfpagoestador_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV20GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV21GridStateFilterValue ;
}

final  class pagowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004S2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV136Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV145Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV150Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV169Pagowwds_47_tfpagoestador_sels ,
                                          String AV123Pagowwds_1_filterfulltext ,
                                          int AV124Pagowwds_2_tfpagoid ,
                                          int AV125Pagowwds_3_tfpagoid_to ,
                                          int AV126Pagowwds_4_tfcitaid ,
                                          int AV127Pagowwds_5_tfcitaid_to ,
                                          String AV129Pagowwds_7_tfcitacode_sel ,
                                          String AV128Pagowwds_6_tfcitacode ,
                                          java.util.Date AV130Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV132Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV133Pagowwds_11_tfpagomonto_to ,
                                          String AV135Pagowwds_13_tfpagotoken_sel ,
                                          String AV134Pagowwds_12_tfpagotoken ,
                                          int AV136Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV138Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV137Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV140Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV139Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV142Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV141Pagowwds_19_tfpagoclientedireccion ,
                                          String AV144Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV143Pagowwds_21_tfpagoclienteemail ,
                                          int AV145Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV146Pagowwds_24_tfpagonumero ,
                                          int AV147Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV148Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV149Pagowwds_27_tfpagofechaemision_to ,
                                          int AV150Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV152Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV151Pagowwds_29_tfpagonubefactrequest ,
                                          String AV154Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV153Pagowwds_31_tfpagonubefactresponse ,
                                          String AV156Pagowwds_34_tfpagorequest_sel ,
                                          String AV155Pagowwds_33_tfpagorequest ,
                                          String AV158Pagowwds_36_tfpagoresponse_sel ,
                                          String AV157Pagowwds_35_tfpagoresponse ,
                                          String AV160Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV159Pagowwds_37_tfpagopasarelaid ,
                                          int AV161Pagowwds_39_tfpagostatuscode ,
                                          int AV162Pagowwds_40_tfpagostatuscode_to ,
                                          int AV163Pagowwds_41_tfdisponibilidadid ,
                                          int AV164Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV166Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV165Pagowwds_43_tfpagoenlacepdf ,
                                          String AV168Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV167Pagowwds_45_tfpagoenlacexml ,
                                          int AV169Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[76];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero], T1.[PagoMonto]," ;
      scmdbuf += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV123Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
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
      }
      if ( ! (0==AV124Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (0==AV125Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (0==AV126Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (0==AV127Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV128Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV130Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV131Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV132Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV133Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( AV136Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV138Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV137Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV140Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV139Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV140Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV142Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV141Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV142Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV144Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV143Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( AV145Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV145Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV146Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (0==AV147Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV148Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV149Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( AV150Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV150Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV152Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV151Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int4[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV154Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV153Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int4[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV154Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int4[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV156Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV155Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int4[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV156Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int4[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV158Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV157Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int4[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV158Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int4[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV160Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV159Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int4[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV160Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int4[67] = (byte)(1) ;
      }
      if ( ! (0==AV161Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int4[68] = (byte)(1) ;
      }
      if ( ! (0==AV162Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int4[69] = (byte)(1) ;
      }
      if ( ! (0==AV163Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[70] = (byte)(1) ;
      }
      if ( ! (0==AV164Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV166Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV165Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int4[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV166Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int4[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV168Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV167Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int4[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV168Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int4[75] = (byte)(1) ;
      }
      if ( AV169Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV169Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoMonto]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoMonto] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoId] DESC" ;
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
         scmdbuf += " ORDER BY T2.[CitaCode]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[CitaCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[DisponibilidadFecha]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoToken]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoToken] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumentoCliente]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumentoCliente] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDenominacion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDenominacion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteEmail]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteEmail] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoNumero]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoNumero] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoFechaEmision]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoFechaEmision] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoMoneda]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoMoneda] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactRequest]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactRequest] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactResponse]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactResponse] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoRequest]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoRequest] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoResponse]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoResponse] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoPasarelaId]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoPasarelaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoStatusCode]" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoStatusCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlacePDF]" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlacePDF] DESC" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlaceXML]" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlaceXML] DESC" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoEstadoR]" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoEstadoR] DESC" ;
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
                  return conditional_P004S2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , ((Boolean) dynConstraints[77]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004S2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
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
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
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
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
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
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
      }
   }

}

