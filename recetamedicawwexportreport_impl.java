package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class recetamedicawwexportreport_impl extends GXWebReport
{
   public recetamedicawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica", GXv_boolean2) ;
         recetamedicawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
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
            AV55Title = "Lista de Receta Medica" ;
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
         h500( true, 0) ;
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
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV18TFRecetaMedicaId) && (0==AV19TFRecetaMedicaId_To) ) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medica Id", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18TFRecetaMedicaId), "ZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV40TFRecetaMedicaId_To_Description = GXutil.format( "%1 (%2)", "Medica Id", "Hasta", "", "", "", "", "", "", "") ;
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFRecetaMedicaId_To_Description, "")), 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFRecetaMedicaId_To), "ZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFCitaId) && (0==AV21TFCitaId_To) ) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Cita Id", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFCitaId), "ZZZZZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV41TFCitaId_To_Description = GXutil.format( "%1 (%2)", "Cita Id", "Hasta", "", "", "", "", "", "", "") ;
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFCitaId_To_Description, "")), 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFCitaId_To), "ZZZZZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV22TFMedicamentoId) && (0==AV23TFMedicamentoId_To) ) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medicamento Id", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFMedicamentoId), "ZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV42TFMedicamentoId_To_Description = GXutil.format( "%1 (%2)", "Medicamento Id", "Hasta", "", "", "", "", "", "", "") ;
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFMedicamentoId_To_Description, "")), 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFMedicamentoId_To), "ZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV25TFMedicamentoCodigo_Sel)==0) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medicamento Codigo", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFMedicamentoCodigo_Sel, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFMedicamentoCodigo)==0) )
         {
            h500( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Medicamento Codigo", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFMedicamentoCodigo, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV27TFMedicamentoNombre_Sel)==0) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medicamento Nombre", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFMedicamentoNombre_Sel, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV26TFMedicamentoNombre)==0) )
         {
            h500( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Medicamento Nombre", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFMedicamentoNombre, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV29TFMedicamentoFormaFarm_Sel)==0) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medicamento Forma Farm", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFMedicamentoFormaFarm_Sel, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV28TFMedicamentoFormaFarm)==0) )
         {
            h500( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Medicamento Forma Farm", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFMedicamentoFormaFarm, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV31TFRecetaMedicaConcentracion_Sel)==0) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medica Concentracion", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFRecetaMedicaConcentracion_Sel, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFRecetaMedicaConcentracion)==0) )
         {
            h500( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Medica Concentracion", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFRecetaMedicaConcentracion, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV32TFRecetaMedicaCantidad) && (0==AV33TFRecetaMedicaCantidad_To) ) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medica Cantidad", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV32TFRecetaMedicaCantidad), "ZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV43TFRecetaMedicaCantidad_To_Description = GXutil.format( "%1 (%2)", "Medica Cantidad", "Hasta", "", "", "", "", "", "", "") ;
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFRecetaMedicaCantidad_To_Description, "")), 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV33TFRecetaMedicaCantidad_To), "ZZZ9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV35TFRecetaMedicaAtencion_Sel)==0) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medica Atencion", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFRecetaMedicaAtencion_Sel, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV34TFRecetaMedicaAtencion)==0) )
         {
            h500( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Medica Atencion", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFRecetaMedicaAtencion, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV38TFRecetaMedicaFlag) && (0==AV39TFRecetaMedicaFlag_To) ) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Medica Flag", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV38TFRecetaMedicaFlag), "9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV44TFRecetaMedicaFlag_To_Description = GXutil.format( "%1 (%2)", "Medica Flag", "Hasta", "", "", "", "", "", "", "") ;
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFRecetaMedicaFlag_To_Description, "")), 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV39TFRecetaMedicaFlag_To), "9")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV58TFRecetaIndicaciones_Sel)==0) )
      {
         h500( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Indicaciones", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV58TFRecetaIndicaciones_Sel, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV57TFRecetaIndicaciones)==0) )
         {
            h500( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Indicaciones", 25, Gx_line+0, 159, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV57TFRecetaIndicaciones, "")), 159, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h500( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h500( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Medica Id", 30, Gx_line+10, 89, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Cita Id", 93, Gx_line+10, 152, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Medicamento Id", 156, Gx_line+10, 215, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Medicamento Codigo", 219, Gx_line+10, 278, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Medicamento Nombre", 282, Gx_line+10, 341, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Medicamento Forma Farm", 345, Gx_line+10, 404, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Medica Concentracion", 408, Gx_line+10, 467, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Medica Cantidad", 471, Gx_line+10, 530, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Medica Atencion", 534, Gx_line+10, 594, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Medica Archivo", 598, Gx_line+10, 658, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Medica Flag", 662, Gx_line+10, 722, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Indicaciones", 726, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV65Recetamedicawwds_1_filterfulltext = AV13FilterFullText ;
      AV66Recetamedicawwds_2_tfrecetamedicaid = AV18TFRecetaMedicaId ;
      AV67Recetamedicawwds_3_tfrecetamedicaid_to = AV19TFRecetaMedicaId_To ;
      AV68Recetamedicawwds_4_tfcitaid = AV20TFCitaId ;
      AV69Recetamedicawwds_5_tfcitaid_to = AV21TFCitaId_To ;
      AV70Recetamedicawwds_6_tfmedicamentoid = AV22TFMedicamentoId ;
      AV71Recetamedicawwds_7_tfmedicamentoid_to = AV23TFMedicamentoId_To ;
      AV72Recetamedicawwds_8_tfmedicamentocodigo = AV24TFMedicamentoCodigo ;
      AV73Recetamedicawwds_9_tfmedicamentocodigo_sel = AV25TFMedicamentoCodigo_Sel ;
      AV74Recetamedicawwds_10_tfmedicamentonombre = AV26TFMedicamentoNombre ;
      AV75Recetamedicawwds_11_tfmedicamentonombre_sel = AV27TFMedicamentoNombre_Sel ;
      AV76Recetamedicawwds_12_tfmedicamentoformafarm = AV28TFMedicamentoFormaFarm ;
      AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV29TFMedicamentoFormaFarm_Sel ;
      AV78Recetamedicawwds_14_tfrecetamedicaconcentracion = AV30TFRecetaMedicaConcentracion ;
      AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV31TFRecetaMedicaConcentracion_Sel ;
      AV80Recetamedicawwds_16_tfrecetamedicacantidad = AV32TFRecetaMedicaCantidad ;
      AV81Recetamedicawwds_17_tfrecetamedicacantidad_to = AV33TFRecetaMedicaCantidad_To ;
      AV82Recetamedicawwds_18_tfrecetamedicaatencion = AV34TFRecetaMedicaAtencion ;
      AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV35TFRecetaMedicaAtencion_Sel ;
      AV84Recetamedicawwds_20_tfrecetamedicaflag = AV38TFRecetaMedicaFlag ;
      AV85Recetamedicawwds_21_tfrecetamedicaflag_to = AV39TFRecetaMedicaFlag_To ;
      AV86Recetamedicawwds_22_tfrecetaindicaciones = AV57TFRecetaIndicaciones ;
      AV87Recetamedicawwds_23_tfrecetaindicaciones_sel = AV58TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV65Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV66Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV67Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV68Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV69Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV70Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV71Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV73Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV72Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV75Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV74Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV76Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV78Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV80Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV81Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV82Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV84Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV85Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV87Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV86Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV72Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV72Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV74Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV74Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV76Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV76Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV78Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV78Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV82Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV82Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV86Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV86Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P00502 */
      pr_default.execute(0, new Object[] {lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, Short.valueOf(AV66Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV67Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV68Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV69Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV70Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV71Recetamedicawwds_7_tfmedicamentoid_to), lV72Recetamedicawwds_8_tfmedicamentocodigo, AV73Recetamedicawwds_9_tfmedicamentocodigo_sel, lV74Recetamedicawwds_10_tfmedicamentonombre, AV75Recetamedicawwds_11_tfmedicamentonombre_sel, lV76Recetamedicawwds_12_tfmedicamentoformafarm, AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV78Recetamedicawwds_14_tfrecetamedicaconcentracion, AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV80Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV81Recetamedicawwds_17_tfrecetamedicacantidad_to), lV82Recetamedicawwds_18_tfrecetamedicaatencion, AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV84Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV85Recetamedicawwds_21_tfrecetamedicaflag_to), lV86Recetamedicawwds_22_tfrecetaindicaciones, AV87Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A272RecetaMedicaFlag = P00502_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P00502_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P00502_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P00502_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P00502_A42MedicamentoId[0] ;
         n42MedicamentoId = P00502_n42MedicamentoId[0] ;
         A19CitaId = P00502_A19CitaId[0] ;
         A50RecetaMedicaId = P00502_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P00502_A332RecetaIndicaciones[0] ;
         A273RecetaMedicaAtencion = P00502_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P00502_n273RecetaMedicaAtencion[0] ;
         A268RecetaMedicaConcentracion = P00502_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P00502_n268RecetaMedicaConcentracion[0] ;
         A231MedicamentoFormaFarm = P00502_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P00502_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P00502_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P00502_A229MedicamentoCodigo[0] ;
         A267RecetaMedicaNombreArchivo = P00502_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = P00502_n267RecetaMedicaNombreArchivo[0] ;
         edt270_Filename = A267RecetaMedicaNombreArchivo ;
         A271RecetaArchivoTipo = P00502_A271RecetaArchivoTipo[0] ;
         edt270_Filetype = A271RecetaArchivoTipo ;
         A270RecetaMedicaArchivo = P00502_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = P00502_n270RecetaMedicaArchivo[0] ;
         A231MedicamentoFormaFarm = P00502_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P00502_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P00502_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P00502_A229MedicamentoCodigo[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h500( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9")), 30, Gx_line+10, 89, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), 93, Gx_line+10, 152, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A42MedicamentoId), "ZZZ9")), 156, Gx_line+10, 215, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A229MedicamentoCodigo, "")), 219, Gx_line+10, 278, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A230MedicamentoNombre, "")), 282, Gx_line+10, 341, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A231MedicamentoFormaFarm, "")), 345, Gx_line+10, 404, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A268RecetaMedicaConcentracion, "")), 408, Gx_line+10, 467, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9")), 471, Gx_line+10, 530, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A273RecetaMedicaAtencion, "")), 534, Gx_line+10, 594, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A270RecetaMedicaArchivo, "")), 598, Gx_line+10, 658, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A272RecetaMedicaFlag), "9")), 662, Gx_line+10, 722, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A332RecetaIndicaciones, "")), 726, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
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
      if ( GXutil.strcmp(AV14Session.getValue("RecetaMedicaWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "RecetaMedicaWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("RecetaMedicaWWGridState"), null, null);
      }
      AV11OrderedBy = AV16GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV16GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV88GXV1 = 1 ;
      while ( AV88GXV1 <= AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV17GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV88GXV1));
         if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAID") == 0 )
         {
            AV18TFRecetaMedicaId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFRecetaMedicaId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV20TFCitaId = (int)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFCitaId_To = (int)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOID") == 0 )
         {
            AV22TFMedicamentoId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV23TFMedicamentoId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO") == 0 )
         {
            AV24TFMedicamentoCodigo = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO_SEL") == 0 )
         {
            AV25TFMedicamentoCodigo_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE") == 0 )
         {
            AV26TFMedicamentoNombre = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE_SEL") == 0 )
         {
            AV27TFMedicamentoNombre_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM") == 0 )
         {
            AV28TFMedicamentoFormaFarm = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM_SEL") == 0 )
         {
            AV29TFMedicamentoFormaFarm_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION") == 0 )
         {
            AV30TFRecetaMedicaConcentracion = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION_SEL") == 0 )
         {
            AV31TFRecetaMedicaConcentracion_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACANTIDAD") == 0 )
         {
            AV32TFRecetaMedicaCantidad = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV33TFRecetaMedicaCantidad_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION") == 0 )
         {
            AV34TFRecetaMedicaAtencion = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION_SEL") == 0 )
         {
            AV35TFRecetaMedicaAtencion_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAFLAG") == 0 )
         {
            AV38TFRecetaMedicaFlag = (byte)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV39TFRecetaMedicaFlag_To = (byte)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES") == 0 )
         {
            AV57TFRecetaIndicaciones = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES_SEL") == 0 )
         {
            AV58TFRecetaIndicaciones_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV88GXV1 = (int)(AV88GXV1+1) ;
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

   public void h500( boolean bFoot ,
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
               AV53PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV50DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV48AppName = "DVelop Software Solutions" ;
            AV54Phone = "+1 550 8923" ;
            AV52Mail = "info@mail.com" ;
            AV56Website = "http://www.web.com" ;
            AV45AddressLine1 = "French Boulevard 2859" ;
            AV46AddressLine2 = "Downtown" ;
            AV47AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV55Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV56Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV61Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV55Title = "" ;
      AV13FilterFullText = "" ;
      AV40TFRecetaMedicaId_To_Description = "" ;
      AV41TFCitaId_To_Description = "" ;
      AV42TFMedicamentoId_To_Description = "" ;
      AV25TFMedicamentoCodigo_Sel = "" ;
      AV24TFMedicamentoCodigo = "" ;
      AV27TFMedicamentoNombre_Sel = "" ;
      AV26TFMedicamentoNombre = "" ;
      AV29TFMedicamentoFormaFarm_Sel = "" ;
      AV28TFMedicamentoFormaFarm = "" ;
      AV31TFRecetaMedicaConcentracion_Sel = "" ;
      AV30TFRecetaMedicaConcentracion = "" ;
      AV43TFRecetaMedicaCantidad_To_Description = "" ;
      AV35TFRecetaMedicaAtencion_Sel = "" ;
      AV34TFRecetaMedicaAtencion = "" ;
      AV44TFRecetaMedicaFlag_To_Description = "" ;
      AV58TFRecetaIndicaciones_Sel = "" ;
      AV57TFRecetaIndicaciones = "" ;
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      A268RecetaMedicaConcentracion = "" ;
      A273RecetaMedicaAtencion = "" ;
      A270RecetaMedicaArchivo = "" ;
      A332RecetaIndicaciones = "" ;
      AV65Recetamedicawwds_1_filterfulltext = "" ;
      AV72Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      AV73Recetamedicawwds_9_tfmedicamentocodigo_sel = "" ;
      AV74Recetamedicawwds_10_tfmedicamentonombre = "" ;
      AV75Recetamedicawwds_11_tfmedicamentonombre_sel = "" ;
      AV76Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel = "" ;
      AV78Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = "" ;
      AV82Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel = "" ;
      AV86Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      AV87Recetamedicawwds_23_tfrecetaindicaciones_sel = "" ;
      scmdbuf = "" ;
      lV65Recetamedicawwds_1_filterfulltext = "" ;
      lV72Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      lV74Recetamedicawwds_10_tfmedicamentonombre = "" ;
      lV76Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      lV78Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      lV82Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      lV86Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      P00502_A272RecetaMedicaFlag = new byte[1] ;
      P00502_n272RecetaMedicaFlag = new boolean[] {false} ;
      P00502_A269RecetaMedicaCantidad = new short[1] ;
      P00502_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P00502_A42MedicamentoId = new short[1] ;
      P00502_n42MedicamentoId = new boolean[] {false} ;
      P00502_A19CitaId = new int[1] ;
      P00502_A50RecetaMedicaId = new short[1] ;
      P00502_A332RecetaIndicaciones = new String[] {""} ;
      P00502_A273RecetaMedicaAtencion = new String[] {""} ;
      P00502_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P00502_A268RecetaMedicaConcentracion = new String[] {""} ;
      P00502_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P00502_A231MedicamentoFormaFarm = new String[] {""} ;
      P00502_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P00502_A230MedicamentoNombre = new String[] {""} ;
      P00502_A229MedicamentoCodigo = new String[] {""} ;
      P00502_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      P00502_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      P00502_A271RecetaArchivoTipo = new String[] {""} ;
      P00502_A270RecetaMedicaArchivo = new String[] {""} ;
      P00502_n270RecetaMedicaArchivo = new boolean[] {false} ;
      A267RecetaMedicaNombreArchivo = "" ;
      edt270_Filename = "" ;
      A271RecetaArchivoTipo = "" ;
      edt270_Filetype = "" ;
      AV14Session = httpContext.getWebSession();
      AV16GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV53PageInfo = "" ;
      AV50DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV48AppName = "" ;
      AV54Phone = "" ;
      AV52Mail = "" ;
      AV56Website = "" ;
      AV45AddressLine1 = "" ;
      AV46AddressLine2 = "" ;
      AV47AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedicawwexportreport__default(),
         new Object[] {
             new Object[] {
            P00502_A272RecetaMedicaFlag, P00502_n272RecetaMedicaFlag, P00502_A269RecetaMedicaCantidad, P00502_n269RecetaMedicaCantidad, P00502_A42MedicamentoId, P00502_n42MedicamentoId, P00502_A19CitaId, P00502_A50RecetaMedicaId, P00502_A332RecetaIndicaciones, P00502_A273RecetaMedicaAtencion,
            P00502_n273RecetaMedicaAtencion, P00502_A268RecetaMedicaConcentracion, P00502_n268RecetaMedicaConcentracion, P00502_A231MedicamentoFormaFarm, P00502_n231MedicamentoFormaFarm, P00502_A230MedicamentoNombre, P00502_A229MedicamentoCodigo, P00502_A267RecetaMedicaNombreArchivo, P00502_n267RecetaMedicaNombreArchivo, P00502_A271RecetaArchivoTipo,
            P00502_A270RecetaMedicaArchivo, P00502_n270RecetaMedicaArchivo
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV61Pgmname = "RecetaMedicaWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV61Pgmname = "RecetaMedicaWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV38TFRecetaMedicaFlag ;
   private byte AV39TFRecetaMedicaFlag_To ;
   private byte A272RecetaMedicaFlag ;
   private byte AV84Recetamedicawwds_20_tfrecetamedicaflag ;
   private byte AV85Recetamedicawwds_21_tfrecetamedicaflag_to ;
   private short gxcookieaux ;
   private short AV18TFRecetaMedicaId ;
   private short AV19TFRecetaMedicaId_To ;
   private short AV22TFMedicamentoId ;
   private short AV23TFMedicamentoId_To ;
   private short AV32TFRecetaMedicaCantidad ;
   private short AV33TFRecetaMedicaCantidad_To ;
   private short A50RecetaMedicaId ;
   private short A42MedicamentoId ;
   private short A269RecetaMedicaCantidad ;
   private short AV66Recetamedicawwds_2_tfrecetamedicaid ;
   private short AV67Recetamedicawwds_3_tfrecetamedicaid_to ;
   private short AV70Recetamedicawwds_6_tfmedicamentoid ;
   private short AV71Recetamedicawwds_7_tfmedicamentoid_to ;
   private short AV80Recetamedicawwds_16_tfrecetamedicacantidad ;
   private short AV81Recetamedicawwds_17_tfrecetamedicacantidad_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV20TFCitaId ;
   private int AV21TFCitaId_To ;
   private int A19CitaId ;
   private int AV68Recetamedicawwds_4_tfcitaid ;
   private int AV69Recetamedicawwds_5_tfcitaid_to ;
   private int AV88GXV1 ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV61Pgmname ;
   private String scmdbuf ;
   private String edt270_Filename ;
   private String edt270_Filetype ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n42MedicamentoId ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n270RecetaMedicaArchivo ;
   private String A270RecetaMedicaArchivo ;
   private String AV55Title ;
   private String AV13FilterFullText ;
   private String AV40TFRecetaMedicaId_To_Description ;
   private String AV41TFCitaId_To_Description ;
   private String AV42TFMedicamentoId_To_Description ;
   private String AV25TFMedicamentoCodigo_Sel ;
   private String AV24TFMedicamentoCodigo ;
   private String AV27TFMedicamentoNombre_Sel ;
   private String AV26TFMedicamentoNombre ;
   private String AV29TFMedicamentoFormaFarm_Sel ;
   private String AV28TFMedicamentoFormaFarm ;
   private String AV31TFRecetaMedicaConcentracion_Sel ;
   private String AV30TFRecetaMedicaConcentracion ;
   private String AV43TFRecetaMedicaCantidad_To_Description ;
   private String AV35TFRecetaMedicaAtencion_Sel ;
   private String AV34TFRecetaMedicaAtencion ;
   private String AV44TFRecetaMedicaFlag_To_Description ;
   private String AV58TFRecetaIndicaciones_Sel ;
   private String AV57TFRecetaIndicaciones ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String A268RecetaMedicaConcentracion ;
   private String A273RecetaMedicaAtencion ;
   private String A332RecetaIndicaciones ;
   private String AV65Recetamedicawwds_1_filterfulltext ;
   private String AV72Recetamedicawwds_8_tfmedicamentocodigo ;
   private String AV73Recetamedicawwds_9_tfmedicamentocodigo_sel ;
   private String AV74Recetamedicawwds_10_tfmedicamentonombre ;
   private String AV75Recetamedicawwds_11_tfmedicamentonombre_sel ;
   private String AV76Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel ;
   private String AV78Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ;
   private String AV82Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel ;
   private String AV86Recetamedicawwds_22_tfrecetaindicaciones ;
   private String AV87Recetamedicawwds_23_tfrecetaindicaciones_sel ;
   private String lV65Recetamedicawwds_1_filterfulltext ;
   private String lV72Recetamedicawwds_8_tfmedicamentocodigo ;
   private String lV74Recetamedicawwds_10_tfmedicamentonombre ;
   private String lV76Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String lV78Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String lV82Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String lV86Recetamedicawwds_22_tfrecetaindicaciones ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private String AV53PageInfo ;
   private String AV50DateInfo ;
   private String AV48AppName ;
   private String AV54Phone ;
   private String AV52Mail ;
   private String AV56Website ;
   private String AV45AddressLine1 ;
   private String AV46AddressLine2 ;
   private String AV47AddressLine3 ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private byte[] P00502_A272RecetaMedicaFlag ;
   private boolean[] P00502_n272RecetaMedicaFlag ;
   private short[] P00502_A269RecetaMedicaCantidad ;
   private boolean[] P00502_n269RecetaMedicaCantidad ;
   private short[] P00502_A42MedicamentoId ;
   private boolean[] P00502_n42MedicamentoId ;
   private int[] P00502_A19CitaId ;
   private short[] P00502_A50RecetaMedicaId ;
   private String[] P00502_A332RecetaIndicaciones ;
   private String[] P00502_A273RecetaMedicaAtencion ;
   private boolean[] P00502_n273RecetaMedicaAtencion ;
   private String[] P00502_A268RecetaMedicaConcentracion ;
   private boolean[] P00502_n268RecetaMedicaConcentracion ;
   private String[] P00502_A231MedicamentoFormaFarm ;
   private boolean[] P00502_n231MedicamentoFormaFarm ;
   private String[] P00502_A230MedicamentoNombre ;
   private String[] P00502_A229MedicamentoCodigo ;
   private String[] P00502_A267RecetaMedicaNombreArchivo ;
   private boolean[] P00502_n267RecetaMedicaNombreArchivo ;
   private String[] P00502_A271RecetaArchivoTipo ;
   private String[] P00502_A270RecetaMedicaArchivo ;
   private boolean[] P00502_n270RecetaMedicaArchivo ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class recetamedicawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00502( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV65Recetamedicawwds_1_filterfulltext ,
                                          short AV66Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV67Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV68Recetamedicawwds_4_tfcitaid ,
                                          int AV69Recetamedicawwds_5_tfcitaid_to ,
                                          short AV70Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV71Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV73Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV72Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV75Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV74Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV76Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV78Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV80Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV81Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV82Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV84Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV85Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV87Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV86Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[33];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones], T1.[RecetaMedicaAtencion]," ;
      scmdbuf += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo], T1.[RecetaMedicaNombreArchivo], T1.[RecetaArchivoTipo]," ;
      scmdbuf += " T1.[RecetaMedicaArchivo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV65Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
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
      }
      if ( ! (0==AV66Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (0==AV67Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (0==AV68Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (0==AV69Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (0==AV70Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (0==AV71Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV72Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV74Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV76Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV78Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV80Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV81Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV82Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (0==AV84Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (0==AV85Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV86Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaConcentracion]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaConcentracion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaId] DESC" ;
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
         scmdbuf += " ORDER BY T1.[MedicamentoId]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MedicamentoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoCodigo]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoCodigo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoNombre]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoFormaFarm]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoFormaFarm] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaCantidad]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaCantidad] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaAtencion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaAtencion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaFlag]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaFlag] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaIndicaciones]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaIndicaciones] DESC" ;
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
                  return conditional_P00502(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00502", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((String[]) buf[17])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(13);
               ((String[]) buf[20])[0] = rslt.getBLOBFile(14, rslt.getVarchar(13), rslt.getVarchar(12));
               ((boolean[]) buf[21])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
      }
   }

}

