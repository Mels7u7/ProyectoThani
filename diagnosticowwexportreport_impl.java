package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class diagnosticowwexportreport_impl extends GXWebReport
{
   public diagnosticowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico", GXv_boolean2) ;
         diagnosticowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54Pgmname))}, new String[] {"GxObject"}) );
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
            AV50Title = "Lista de Diagnostico" ;
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
         h440( true, 0) ;
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
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFDiagnosticoId) && (0==AV21TFDiagnosticoId_To) ) )
      {
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFDiagnosticoId), "ZZZZZZZ9")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV36TFDiagnosticoId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36TFDiagnosticoId_To_Description, "")), 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFDiagnosticoId_To), "ZZZZZZZ9")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV23TFDiagnosticoCodigo_Sel)==0) )
      {
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Codigo", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFDiagnosticoCodigo_Sel, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFDiagnosticoCodigo)==0) )
         {
            h440( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Codigo", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFDiagnosticoCodigo, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFDiagnosticoDescripcion_Sel)==0) )
      {
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFDiagnosticoDescripcion_Sel, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFDiagnosticoDescripcion)==0) )
         {
            h440( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFDiagnosticoDescripcion, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV28TFDiagnosticoTipoSexo_Sels.fromJSonString(AV26TFDiagnosticoTipoSexo_SelsJson, null);
      if ( ! ( AV28TFDiagnosticoTipoSexo_Sels.size() == 0 ) )
      {
         AV39i = 1 ;
         AV57GXV1 = 1 ;
         while ( AV57GXV1 <= AV28TFDiagnosticoTipoSexo_Sels.size() )
         {
            AV29TFDiagnosticoTipoSexo_Sel = (String)AV28TFDiagnosticoTipoSexo_Sels.elementAt(-1+AV57GXV1) ;
            if ( AV39i == 1 )
            {
               AV27TFDiagnosticoTipoSexo_SelDscs = "" ;
            }
            else
            {
               AV27TFDiagnosticoTipoSexo_SelDscs += ", " ;
            }
            AV37FilterTFDiagnosticoTipoSexo_SelValueDescription = com.projectthani.gxdomaintiposexodiagnostico.getDescription(httpContext,(String)AV29TFDiagnosticoTipoSexo_Sel) ;
            AV27TFDiagnosticoTipoSexo_SelDscs += AV37FilterTFDiagnosticoTipoSexo_SelValueDescription ;
            AV39i = (long)(AV39i+1) ;
            AV57GXV1 = (int)(AV57GXV1+1) ;
         }
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Sexo", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFDiagnosticoTipoSexo_SelDscs, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV32TFDiagnosticoEstado_Sels.fromJSonString(AV30TFDiagnosticoEstado_SelsJson, null);
      if ( ! ( AV32TFDiagnosticoEstado_Sels.size() == 0 ) )
      {
         AV39i = 1 ;
         AV58GXV2 = 1 ;
         while ( AV58GXV2 <= AV32TFDiagnosticoEstado_Sels.size() )
         {
            AV33TFDiagnosticoEstado_Sel = (String)AV32TFDiagnosticoEstado_Sels.elementAt(-1+AV58GXV2) ;
            if ( AV39i == 1 )
            {
               AV31TFDiagnosticoEstado_SelDscs = "" ;
            }
            else
            {
               AV31TFDiagnosticoEstado_SelDscs += ", " ;
            }
            AV38FilterTFDiagnosticoEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV33TFDiagnosticoEstado_Sel) ;
            AV31TFDiagnosticoEstado_SelDscs += AV38FilterTFDiagnosticoEstado_SelValueDescription ;
            AV39i = (long)(AV39i+1) ;
            AV58GXV2 = (int)(AV58GXV2+1) ;
         }
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFDiagnosticoEstado_SelDscs, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV35TFDiagnosticoLongDesc_Sel)==0) )
      {
         h440( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Long Desc", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFDiagnosticoLongDesc_Sel, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV34TFDiagnosticoLongDesc)==0) )
         {
            h440( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Long Desc", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFDiagnosticoLongDesc, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h440( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h440( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 97, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Codigo", 101, Gx_line+10, 235, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 239, Gx_line+10, 373, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Sexo", 377, Gx_line+10, 511, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 515, Gx_line+10, 649, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Long Desc", 653, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV60Diagnosticowwds_1_filterfulltext = AV13FilterFullText ;
      AV61Diagnosticowwds_2_tfdiagnosticoid = AV20TFDiagnosticoId ;
      AV62Diagnosticowwds_3_tfdiagnosticoid_to = AV21TFDiagnosticoId_To ;
      AV63Diagnosticowwds_4_tfdiagnosticocodigo = AV22TFDiagnosticoCodigo ;
      AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel = AV23TFDiagnosticoCodigo_Sel ;
      AV65Diagnosticowwds_6_tfdiagnosticodescripcion = AV24TFDiagnosticoDescripcion ;
      AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel = AV25TFDiagnosticoDescripcion_Sel ;
      AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels = AV28TFDiagnosticoTipoSexo_Sels ;
      AV68Diagnosticowwds_9_tfdiagnosticoestado_sels = AV32TFDiagnosticoEstado_Sels ;
      AV69Diagnosticowwds_10_tfdiagnosticolongdesc = AV34TFDiagnosticoLongDesc ;
      AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel = AV35TFDiagnosticoLongDesc_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A130DiagnosticoTipoSexo ,
                                           AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                           A131DiagnosticoEstado ,
                                           AV68Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                           AV60Diagnosticowwds_1_filterfulltext ,
                                           Integer.valueOf(AV61Diagnosticowwds_2_tfdiagnosticoid) ,
                                           Integer.valueOf(AV62Diagnosticowwds_3_tfdiagnosticoid_to) ,
                                           AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                           AV63Diagnosticowwds_4_tfdiagnosticocodigo ,
                                           AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                           AV65Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                           Integer.valueOf(AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels.size()) ,
                                           Integer.valueOf(AV68Diagnosticowwds_9_tfdiagnosticoestado_sels.size()) ,
                                           AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                           AV69Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                           Integer.valueOf(A23DiagnosticoId) ,
                                           A107DiagnosticoCodigo ,
                                           A108DiagnosticoDescripcion ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV63Diagnosticowwds_4_tfdiagnosticocodigo = GXutil.concat( GXutil.rtrim( AV63Diagnosticowwds_4_tfdiagnosticocodigo), "%", "") ;
      lV65Diagnosticowwds_6_tfdiagnosticodescripcion = GXutil.concat( GXutil.rtrim( AV65Diagnosticowwds_6_tfdiagnosticodescripcion), "%", "") ;
      lV69Diagnosticowwds_10_tfdiagnosticolongdesc = GXutil.concat( GXutil.rtrim( AV69Diagnosticowwds_10_tfdiagnosticolongdesc), "%", "") ;
      /* Using cursor P00442 */
      pr_default.execute(0, new Object[] {lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, lV60Diagnosticowwds_1_filterfulltext, Integer.valueOf(AV61Diagnosticowwds_2_tfdiagnosticoid), Integer.valueOf(AV62Diagnosticowwds_3_tfdiagnosticoid_to), lV63Diagnosticowwds_4_tfdiagnosticocodigo, AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel, lV65Diagnosticowwds_6_tfdiagnosticodescripcion, AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel, lV69Diagnosticowwds_10_tfdiagnosticolongdesc, AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A23DiagnosticoId = P00442_A23DiagnosticoId[0] ;
         A131DiagnosticoEstado = P00442_A131DiagnosticoEstado[0] ;
         A130DiagnosticoTipoSexo = P00442_A130DiagnosticoTipoSexo[0] ;
         A108DiagnosticoDescripcion = P00442_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P00442_A107DiagnosticoCodigo[0] ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         AV14DiagnosticoTipoSexoDescription = com.projectthani.gxdomaintiposexodiagnostico.getDescription(httpContext,(String)A130DiagnosticoTipoSexo) ;
         AV15DiagnosticoEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A131DiagnosticoEstado) ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h440( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A23DiagnosticoId), "ZZZZZZZ9")), 30, Gx_line+10, 97, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A107DiagnosticoCodigo, "")), 101, Gx_line+10, 235, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A108DiagnosticoDescripcion, "")), 239, Gx_line+10, 373, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14DiagnosticoTipoSexoDescription, "")), 377, Gx_line+10, 511, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15DiagnosticoEstadoDescription, "")), 515, Gx_line+10, 649, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A132DiagnosticoLongDesc, "")), 653, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
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
      if ( GXutil.strcmp(AV16Session.getValue("DiagnosticoWWGridState"), "") == 0 )
      {
         AV18GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DiagnosticoWWGridState"), null, null);
      }
      else
      {
         AV18GridState.fromxml(AV16Session.getValue("DiagnosticoWWGridState"), null, null);
      }
      AV11OrderedBy = AV18GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV18GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV71GXV3 = 1 ;
      while ( AV71GXV3 <= AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV19GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV71GXV3));
         if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOID") == 0 )
         {
            AV20TFDiagnosticoId = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFDiagnosticoId_To = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOCODIGO") == 0 )
         {
            AV22TFDiagnosticoCodigo = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOCODIGO_SEL") == 0 )
         {
            AV23TFDiagnosticoCodigo_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICODESCRIPCION") == 0 )
         {
            AV24TFDiagnosticoDescripcion = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICODESCRIPCION_SEL") == 0 )
         {
            AV25TFDiagnosticoDescripcion_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOTIPOSEXO_SEL") == 0 )
         {
            AV26TFDiagnosticoTipoSexo_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV28TFDiagnosticoTipoSexo_Sels.fromJSonString(AV26TFDiagnosticoTipoSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOESTADO_SEL") == 0 )
         {
            AV30TFDiagnosticoEstado_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV32TFDiagnosticoEstado_Sels.fromJSonString(AV30TFDiagnosticoEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOLONGDESC") == 0 )
         {
            AV34TFDiagnosticoLongDesc = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOLONGDESC_SEL") == 0 )
         {
            AV35TFDiagnosticoLongDesc_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV71GXV3 = (int)(AV71GXV3+1) ;
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

   public void h440( boolean bFoot ,
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
               AV48PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV45DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV43AppName = "DVelop Software Solutions" ;
            AV49Phone = "+1 550 8923" ;
            AV47Mail = "info@mail.com" ;
            AV51Website = "http://www.web.com" ;
            AV40AddressLine1 = "French Boulevard 2859" ;
            AV41AddressLine2 = "Downtown" ;
            AV42AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV54Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV50Title = "" ;
      AV13FilterFullText = "" ;
      AV36TFDiagnosticoId_To_Description = "" ;
      AV23TFDiagnosticoCodigo_Sel = "" ;
      AV22TFDiagnosticoCodigo = "" ;
      AV25TFDiagnosticoDescripcion_Sel = "" ;
      AV24TFDiagnosticoDescripcion = "" ;
      AV28TFDiagnosticoTipoSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFDiagnosticoTipoSexo_SelsJson = "" ;
      AV29TFDiagnosticoTipoSexo_Sel = "" ;
      AV27TFDiagnosticoTipoSexo_SelDscs = "" ;
      AV37FilterTFDiagnosticoTipoSexo_SelValueDescription = "" ;
      AV32TFDiagnosticoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30TFDiagnosticoEstado_SelsJson = "" ;
      AV33TFDiagnosticoEstado_Sel = "" ;
      AV31TFDiagnosticoEstado_SelDscs = "" ;
      AV38FilterTFDiagnosticoEstado_SelValueDescription = "" ;
      AV35TFDiagnosticoLongDesc_Sel = "" ;
      AV34TFDiagnosticoLongDesc = "" ;
      A130DiagnosticoTipoSexo = "" ;
      A131DiagnosticoEstado = "" ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      A132DiagnosticoLongDesc = "" ;
      AV60Diagnosticowwds_1_filterfulltext = "" ;
      AV63Diagnosticowwds_4_tfdiagnosticocodigo = "" ;
      AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel = "" ;
      AV65Diagnosticowwds_6_tfdiagnosticodescripcion = "" ;
      AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel = "" ;
      AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Diagnosticowwds_9_tfdiagnosticoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Diagnosticowwds_10_tfdiagnosticolongdesc = "" ;
      AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel = "" ;
      scmdbuf = "" ;
      lV60Diagnosticowwds_1_filterfulltext = "" ;
      lV63Diagnosticowwds_4_tfdiagnosticocodigo = "" ;
      lV65Diagnosticowwds_6_tfdiagnosticodescripcion = "" ;
      lV69Diagnosticowwds_10_tfdiagnosticolongdesc = "" ;
      P00442_A23DiagnosticoId = new int[1] ;
      P00442_A131DiagnosticoEstado = new String[] {""} ;
      P00442_A130DiagnosticoTipoSexo = new String[] {""} ;
      P00442_A108DiagnosticoDescripcion = new String[] {""} ;
      P00442_A107DiagnosticoCodigo = new String[] {""} ;
      AV14DiagnosticoTipoSexoDescription = "" ;
      AV15DiagnosticoEstadoDescription = "" ;
      AV16Session = httpContext.getWebSession();
      AV18GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV19GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV48PageInfo = "" ;
      AV45DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV43AppName = "" ;
      AV49Phone = "" ;
      AV47Mail = "" ;
      AV51Website = "" ;
      AV40AddressLine1 = "" ;
      AV41AddressLine2 = "" ;
      AV42AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.diagnosticowwexportreport__default(),
         new Object[] {
             new Object[] {
            P00442_A23DiagnosticoId, P00442_A131DiagnosticoEstado, P00442_A130DiagnosticoTipoSexo, P00442_A108DiagnosticoDescripcion, P00442_A107DiagnosticoCodigo
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV54Pgmname = "DiagnosticoWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV54Pgmname = "DiagnosticoWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV20TFDiagnosticoId ;
   private int AV21TFDiagnosticoId_To ;
   private int AV57GXV1 ;
   private int AV58GXV2 ;
   private int A23DiagnosticoId ;
   private int AV61Diagnosticowwds_2_tfdiagnosticoid ;
   private int AV62Diagnosticowwds_3_tfdiagnosticoid_to ;
   private int AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ;
   private int AV68Diagnosticowwds_9_tfdiagnosticoestado_sels_size ;
   private int AV71GXV3 ;
   private long AV39i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV54Pgmname ;
   private String AV29TFDiagnosticoTipoSexo_Sel ;
   private String AV33TFDiagnosticoEstado_Sel ;
   private String A130DiagnosticoTipoSexo ;
   private String A131DiagnosticoEstado ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV26TFDiagnosticoTipoSexo_SelsJson ;
   private String AV30TFDiagnosticoEstado_SelsJson ;
   private String AV50Title ;
   private String AV13FilterFullText ;
   private String AV36TFDiagnosticoId_To_Description ;
   private String AV23TFDiagnosticoCodigo_Sel ;
   private String AV22TFDiagnosticoCodigo ;
   private String AV25TFDiagnosticoDescripcion_Sel ;
   private String AV24TFDiagnosticoDescripcion ;
   private String AV27TFDiagnosticoTipoSexo_SelDscs ;
   private String AV37FilterTFDiagnosticoTipoSexo_SelValueDescription ;
   private String AV31TFDiagnosticoEstado_SelDscs ;
   private String AV38FilterTFDiagnosticoEstado_SelValueDescription ;
   private String AV35TFDiagnosticoLongDesc_Sel ;
   private String AV34TFDiagnosticoLongDesc ;
   private String A107DiagnosticoCodigo ;
   private String A108DiagnosticoDescripcion ;
   private String A132DiagnosticoLongDesc ;
   private String AV60Diagnosticowwds_1_filterfulltext ;
   private String AV63Diagnosticowwds_4_tfdiagnosticocodigo ;
   private String AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel ;
   private String AV65Diagnosticowwds_6_tfdiagnosticodescripcion ;
   private String AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel ;
   private String AV69Diagnosticowwds_10_tfdiagnosticolongdesc ;
   private String AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel ;
   private String lV60Diagnosticowwds_1_filterfulltext ;
   private String lV63Diagnosticowwds_4_tfdiagnosticocodigo ;
   private String lV65Diagnosticowwds_6_tfdiagnosticodescripcion ;
   private String lV69Diagnosticowwds_10_tfdiagnosticolongdesc ;
   private String AV14DiagnosticoTipoSexoDescription ;
   private String AV15DiagnosticoEstadoDescription ;
   private String AV48PageInfo ;
   private String AV45DateInfo ;
   private String AV43AppName ;
   private String AV49Phone ;
   private String AV47Mail ;
   private String AV51Website ;
   private String AV40AddressLine1 ;
   private String AV41AddressLine2 ;
   private String AV42AddressLine3 ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private IDataStoreProvider pr_default ;
   private int[] P00442_A23DiagnosticoId ;
   private String[] P00442_A131DiagnosticoEstado ;
   private String[] P00442_A130DiagnosticoTipoSexo ;
   private String[] P00442_A108DiagnosticoDescripcion ;
   private String[] P00442_A107DiagnosticoCodigo ;
   private GXSimpleCollection<String> AV28TFDiagnosticoTipoSexo_Sels ;
   private GXSimpleCollection<String> AV32TFDiagnosticoEstado_Sels ;
   private GXSimpleCollection<String> AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels ;
   private GXSimpleCollection<String> AV68Diagnosticowwds_9_tfdiagnosticoestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV18GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV19GridStateFilterValue ;
}

final  class diagnosticowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00442( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A130DiagnosticoTipoSexo ,
                                          GXSimpleCollection<String> AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                          String A131DiagnosticoEstado ,
                                          GXSimpleCollection<String> AV68Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                          String AV60Diagnosticowwds_1_filterfulltext ,
                                          int AV61Diagnosticowwds_2_tfdiagnosticoid ,
                                          int AV62Diagnosticowwds_3_tfdiagnosticoid_to ,
                                          String AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                          String AV63Diagnosticowwds_4_tfdiagnosticocodigo ,
                                          String AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                          String AV65Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                          int AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ,
                                          int AV68Diagnosticowwds_9_tfdiagnosticoestado_sels_size ,
                                          String AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                          String AV69Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                          int A23DiagnosticoId ,
                                          String A107DiagnosticoCodigo ,
                                          String A108DiagnosticoDescripcion ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[17];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [DiagnosticoId], [DiagnosticoEstado], [DiagnosticoTipoSexo], [DiagnosticoDescripcion], [DiagnosticoCodigo] FROM [Diagnostico]" ;
      if ( ! (GXutil.strcmp("", AV60Diagnosticowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST([DiagnosticoId] AS decimal(8,0))) like '%' + ?) or ( [DiagnosticoCodigo] like '%' + ?) or ( [DiagnosticoDescripcion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'F') or ( 'ambos' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'A') or ( 'activo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'I') or ( [DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like '%' + ?))");
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
      }
      if ( ! (0==AV61Diagnosticowwds_2_tfdiagnosticoid) )
      {
         addWhere(sWhereString, "([DiagnosticoId] >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV62Diagnosticowwds_3_tfdiagnosticoid_to) )
      {
         addWhere(sWhereString, "([DiagnosticoId] <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV63Diagnosticowwds_4_tfdiagnosticocodigo)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] like ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] = ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV65Diagnosticowwds_6_tfdiagnosticodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV67Diagnosticowwds_8_tfdiagnosticotiposexo_sels, "[DiagnosticoTipoSexo] IN (", ")")+")");
      }
      if ( AV68Diagnosticowwds_9_tfdiagnosticoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV68Diagnosticowwds_9_tfdiagnosticoestado_sels, "[DiagnosticoEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) && ( ! (GXutil.strcmp("", AV69Diagnosticowwds_10_tfdiagnosticolongdesc)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoCodigo]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoCodigo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoTipoSexo]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoTipoSexo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoEstado]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoEstado] DESC" ;
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
                  return conditional_P00442(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00442", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 40);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 1000);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 1000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 300);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 300);
               }
               return;
      }
   }

}

