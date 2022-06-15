package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class laboratoriowwexportreport_impl extends GXWebReport
{
   public laboratoriowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio", GXv_boolean2) ;
         laboratoriowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
            AV53Title = "Lista de Laboratorio" ;
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
         h460( true, 0) ;
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
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFLaboratorioId) && (0==AV21TFLaboratorioId_To) ) )
      {
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFLaboratorioId), "ZZZ9")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV38TFLaboratorioId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFLaboratorioId_To_Description, "")), 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFLaboratorioId_To), "ZZZ9")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV23TFLaboratorioNombre_Sel)==0) )
      {
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFLaboratorioNombre_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFLaboratorioNombre)==0) )
         {
            h460( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFLaboratorioNombre, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFLaboratorioDescripcion_Sel)==0) )
      {
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFLaboratorioDescripcion_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFLaboratorioDescripcion)==0) )
         {
            h460( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFLaboratorioDescripcion, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV28TFLaboratorioTipoDocumento_Sels.fromJSonString(AV26TFLaboratorioTipoDocumento_SelsJson, null);
      if ( ! ( AV28TFLaboratorioTipoDocumento_Sels.size() == 0 ) )
      {
         AV42i = 1 ;
         AV60GXV1 = 1 ;
         while ( AV60GXV1 <= AV28TFLaboratorioTipoDocumento_Sels.size() )
         {
            AV29TFLaboratorioTipoDocumento_Sel = (String)AV28TFLaboratorioTipoDocumento_Sels.elementAt(-1+AV60GXV1) ;
            if ( AV42i == 1 )
            {
               AV27TFLaboratorioTipoDocumento_SelDscs = "" ;
            }
            else
            {
               AV27TFLaboratorioTipoDocumento_SelDscs += ", " ;
            }
            AV39FilterTFLaboratorioTipoDocumento_SelValueDescription = com.projectthani.gxdomaintipodocumentolaboratorio.getDescription(httpContext,(String)AV29TFLaboratorioTipoDocumento_Sel) ;
            AV27TFLaboratorioTipoDocumento_SelDscs += AV39FilterTFLaboratorioTipoDocumento_SelValueDescription ;
            AV42i = (long)(AV42i+1) ;
            AV60GXV1 = (int)(AV60GXV1+1) ;
         }
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Documento", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFLaboratorioTipoDocumento_SelDscs, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV31TFLaboratorioNroDocumento_Sel)==0) )
      {
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFLaboratorioNroDocumento_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFLaboratorioNroDocumento)==0) )
         {
            h460( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFLaboratorioNroDocumento, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV32TFLaboratorioComision) && (0==AV33TFLaboratorioComision_To) ) )
      {
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Comision", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV32TFLaboratorioComision), "ZZZ9")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV40TFLaboratorioComision_To_Description = GXutil.format( "%1 (%2)", "Comision", "Hasta", "", "", "", "", "", "", "") ;
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFLaboratorioComision_To_Description, "")), 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV33TFLaboratorioComision_To), "ZZZ9")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV36TFLaboratorioEstado_Sels.fromJSonString(AV34TFLaboratorioEstado_SelsJson, null);
      if ( ! ( AV36TFLaboratorioEstado_Sels.size() == 0 ) )
      {
         AV42i = 1 ;
         AV61GXV2 = 1 ;
         while ( AV61GXV2 <= AV36TFLaboratorioEstado_Sels.size() )
         {
            AV37TFLaboratorioEstado_Sel = (String)AV36TFLaboratorioEstado_Sels.elementAt(-1+AV61GXV2) ;
            if ( AV42i == 1 )
            {
               AV35TFLaboratorioEstado_SelDscs = "" ;
            }
            else
            {
               AV35TFLaboratorioEstado_SelDscs += ", " ;
            }
            AV41FilterTFLaboratorioEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV37TFLaboratorioEstado_Sel) ;
            AV35TFLaboratorioEstado_SelDscs += AV41FilterTFLaboratorioEstado_SelValueDescription ;
            AV42i = (long)(AV42i+1) ;
            AV61GXV2 = (int)(AV61GXV2+1) ;
         }
         h460( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFLaboratorioEstado_SelDscs, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h460( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h460( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 86, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 90, Gx_line+10, 202, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 206, Gx_line+10, 318, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Documento", 322, Gx_line+10, 434, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nro Documento", 438, Gx_line+10, 550, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Imagen", 554, Gx_line+10, 610, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Comision", 614, Gx_line+10, 670, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 674, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV63Laboratoriowwds_1_filterfulltext = AV13FilterFullText ;
      AV64Laboratoriowwds_2_tflaboratorioid = AV20TFLaboratorioId ;
      AV65Laboratoriowwds_3_tflaboratorioid_to = AV21TFLaboratorioId_To ;
      AV66Laboratoriowwds_4_tflaboratorionombre = AV22TFLaboratorioNombre ;
      AV67Laboratoriowwds_5_tflaboratorionombre_sel = AV23TFLaboratorioNombre_Sel ;
      AV68Laboratoriowwds_6_tflaboratoriodescripcion = AV24TFLaboratorioDescripcion ;
      AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV25TFLaboratorioDescripcion_Sel ;
      AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV28TFLaboratorioTipoDocumento_Sels ;
      AV71Laboratoriowwds_9_tflaboratorionrodocumento = AV30TFLaboratorioNroDocumento ;
      AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV31TFLaboratorioNroDocumento_Sel ;
      AV73Laboratoriowwds_11_tflaboratoriocomision = AV32TFLaboratorioComision ;
      AV74Laboratoriowwds_12_tflaboratoriocomision_to = AV33TFLaboratorioComision_To ;
      AV75Laboratoriowwds_13_tflaboratorioestado_sels = AV36TFLaboratorioEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A167LaboratorioTipoDocumento ,
                                           AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                           A171LaboratorioEstado ,
                                           AV75Laboratoriowwds_13_tflaboratorioestado_sels ,
                                           AV63Laboratoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV64Laboratoriowwds_2_tflaboratorioid) ,
                                           Short.valueOf(AV65Laboratoriowwds_3_tflaboratorioid_to) ,
                                           AV67Laboratoriowwds_5_tflaboratorionombre_sel ,
                                           AV66Laboratoriowwds_4_tflaboratorionombre ,
                                           AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                           AV68Laboratoriowwds_6_tflaboratoriodescripcion ,
                                           Integer.valueOf(AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                           AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                           AV71Laboratoriowwds_9_tflaboratorionrodocumento ,
                                           Short.valueOf(AV73Laboratoriowwds_11_tflaboratoriocomision) ,
                                           Short.valueOf(AV74Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                           Integer.valueOf(AV75Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A166LaboratorioDescripcion ,
                                           A168LaboratorioNroDocumento ,
                                           Short.valueOf(A170LaboratorioComision) ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV63Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV66Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV66Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
      lV68Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV68Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
      lV71Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV71Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
      /* Using cursor P00462 */
      pr_default.execute(0, new Object[] {lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, lV63Laboratoriowwds_1_filterfulltext, Short.valueOf(AV64Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV65Laboratoriowwds_3_tflaboratorioid_to), lV66Laboratoriowwds_4_tflaboratorionombre, AV67Laboratoriowwds_5_tflaboratorionombre_sel, lV68Laboratoriowwds_6_tflaboratoriodescripcion, AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV71Laboratoriowwds_9_tflaboratorionrodocumento, AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV73Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV74Laboratoriowwds_12_tflaboratoriocomision_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A170LaboratorioComision = P00462_A170LaboratorioComision[0] ;
         A40LaboratorioId = P00462_A40LaboratorioId[0] ;
         A171LaboratorioEstado = P00462_A171LaboratorioEstado[0] ;
         A168LaboratorioNroDocumento = P00462_A168LaboratorioNroDocumento[0] ;
         A167LaboratorioTipoDocumento = P00462_A167LaboratorioTipoDocumento[0] ;
         A166LaboratorioDescripcion = P00462_A166LaboratorioDescripcion[0] ;
         A165LaboratorioNombre = P00462_A165LaboratorioNombre[0] ;
         A40000LaboratorioPhoto_GXI = P00462_A40000LaboratorioPhoto_GXI[0] ;
         A169LaboratorioPhoto = P00462_A169LaboratorioPhoto[0] ;
         AV14LaboratorioTipoDocumentoDescription = com.projectthani.gxdomaintipodocumentolaboratorio.getDescription(httpContext,(String)A167LaboratorioTipoDocumento) ;
         AV15LaboratorioEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A171LaboratorioEstado) ;
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
         h460( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9")), 30, Gx_line+10, 86, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A165LaboratorioNombre, "")), 90, Gx_line+10, 202, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A166LaboratorioDescripcion, "")), 206, Gx_line+10, 318, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14LaboratorioTipoDocumentoDescription, "")), 322, Gx_line+10, 434, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A168LaboratorioNroDocumento, "")), 438, Gx_line+10, 550, Gx_line+55, 0, 0, 0, 0) ;
         sImgUrl = ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : A169LaboratorioPhoto) ;
         getPrinter().GxDrawBitMap(sImgUrl, 554, Gx_line+10, 610, Gx_line+55) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A170LaboratorioComision), "ZZZ9")), 614, Gx_line+10, 670, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15LaboratorioEstadoDescription, "")), 674, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV16Session.getValue("LaboratorioWWGridState"), "") == 0 )
      {
         AV18GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LaboratorioWWGridState"), null, null);
      }
      else
      {
         AV18GridState.fromxml(AV16Session.getValue("LaboratorioWWGridState"), null, null);
      }
      AV11OrderedBy = AV18GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV18GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV76GXV3 = 1 ;
      while ( AV76GXV3 <= AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV19GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV76GXV3));
         if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV20TFLaboratorioId = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFLaboratorioId_To = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV22TFLaboratorioNombre = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV23TFLaboratorioNombre_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION") == 0 )
         {
            AV24TFLaboratorioDescripcion = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION_SEL") == 0 )
         {
            AV25TFLaboratorioDescripcion_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOTIPODOCUMENTO_SEL") == 0 )
         {
            AV26TFLaboratorioTipoDocumento_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV28TFLaboratorioTipoDocumento_Sels.fromJSonString(AV26TFLaboratorioTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO") == 0 )
         {
            AV30TFLaboratorioNroDocumento = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO_SEL") == 0 )
         {
            AV31TFLaboratorioNroDocumento_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOCOMISION") == 0 )
         {
            AV32TFLaboratorioComision = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV33TFLaboratorioComision_To = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOESTADO_SEL") == 0 )
         {
            AV34TFLaboratorioEstado_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFLaboratorioEstado_Sels.fromJSonString(AV34TFLaboratorioEstado_SelsJson, null);
         }
         AV76GXV3 = (int)(AV76GXV3+1) ;
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

   public void h460( boolean bFoot ,
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
               AV51PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV48DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV46AppName = "DVelop Software Solutions" ;
            AV52Phone = "+1 550 8923" ;
            AV50Mail = "info@mail.com" ;
            AV54Website = "http://www.web.com" ;
            AV43AddressLine1 = "French Boulevard 2859" ;
            AV44AddressLine2 = "Downtown" ;
            AV45AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV57Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV53Title = "" ;
      AV13FilterFullText = "" ;
      AV38TFLaboratorioId_To_Description = "" ;
      AV23TFLaboratorioNombre_Sel = "" ;
      AV22TFLaboratorioNombre = "" ;
      AV25TFLaboratorioDescripcion_Sel = "" ;
      AV24TFLaboratorioDescripcion = "" ;
      AV28TFLaboratorioTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFLaboratorioTipoDocumento_SelsJson = "" ;
      AV29TFLaboratorioTipoDocumento_Sel = "" ;
      AV27TFLaboratorioTipoDocumento_SelDscs = "" ;
      AV39FilterTFLaboratorioTipoDocumento_SelValueDescription = "" ;
      AV31TFLaboratorioNroDocumento_Sel = "" ;
      AV30TFLaboratorioNroDocumento = "" ;
      AV40TFLaboratorioComision_To_Description = "" ;
      AV36TFLaboratorioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFLaboratorioEstado_SelsJson = "" ;
      AV37TFLaboratorioEstado_Sel = "" ;
      AV35TFLaboratorioEstado_SelDscs = "" ;
      AV41FilterTFLaboratorioEstado_SelValueDescription = "" ;
      A167LaboratorioTipoDocumento = "" ;
      A171LaboratorioEstado = "" ;
      A165LaboratorioNombre = "" ;
      A166LaboratorioDescripcion = "" ;
      A168LaboratorioNroDocumento = "" ;
      A169LaboratorioPhoto = "" ;
      A40000LaboratorioPhoto_GXI = "" ;
      AV63Laboratoriowwds_1_filterfulltext = "" ;
      AV66Laboratoriowwds_4_tflaboratorionombre = "" ;
      AV67Laboratoriowwds_5_tflaboratorionombre_sel = "" ;
      AV68Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel = "" ;
      AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel = "" ;
      AV75Laboratoriowwds_13_tflaboratorioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV63Laboratoriowwds_1_filterfulltext = "" ;
      lV66Laboratoriowwds_4_tflaboratorionombre = "" ;
      lV68Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      lV71Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      P00462_A170LaboratorioComision = new short[1] ;
      P00462_A40LaboratorioId = new short[1] ;
      P00462_A171LaboratorioEstado = new String[] {""} ;
      P00462_A168LaboratorioNroDocumento = new String[] {""} ;
      P00462_A167LaboratorioTipoDocumento = new String[] {""} ;
      P00462_A166LaboratorioDescripcion = new String[] {""} ;
      P00462_A165LaboratorioNombre = new String[] {""} ;
      P00462_A40000LaboratorioPhoto_GXI = new String[] {""} ;
      P00462_A169LaboratorioPhoto = new String[] {""} ;
      AV14LaboratorioTipoDocumentoDescription = "" ;
      AV15LaboratorioEstadoDescription = "" ;
      sImgUrl = "" ;
      AV16Session = httpContext.getWebSession();
      AV18GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV19GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV51PageInfo = "" ;
      AV48DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV46AppName = "" ;
      AV52Phone = "" ;
      AV50Mail = "" ;
      AV54Website = "" ;
      AV43AddressLine1 = "" ;
      AV44AddressLine2 = "" ;
      AV45AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.laboratoriowwexportreport__default(),
         new Object[] {
             new Object[] {
            P00462_A170LaboratorioComision, P00462_A40LaboratorioId, P00462_A171LaboratorioEstado, P00462_A168LaboratorioNroDocumento, P00462_A167LaboratorioTipoDocumento, P00462_A166LaboratorioDescripcion, P00462_A165LaboratorioNombre, P00462_A40000LaboratorioPhoto_GXI, P00462_A169LaboratorioPhoto
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV57Pgmname = "LaboratorioWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV57Pgmname = "LaboratorioWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV20TFLaboratorioId ;
   private short AV21TFLaboratorioId_To ;
   private short AV32TFLaboratorioComision ;
   private short AV33TFLaboratorioComision_To ;
   private short A40LaboratorioId ;
   private short A170LaboratorioComision ;
   private short AV64Laboratoriowwds_2_tflaboratorioid ;
   private short AV65Laboratoriowwds_3_tflaboratorioid_to ;
   private short AV73Laboratoriowwds_11_tflaboratoriocomision ;
   private short AV74Laboratoriowwds_12_tflaboratoriocomision_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV60GXV1 ;
   private int AV61GXV2 ;
   private int AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ;
   private int AV75Laboratoriowwds_13_tflaboratorioestado_sels_size ;
   private int AV76GXV3 ;
   private long AV42i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV57Pgmname ;
   private String AV29TFLaboratorioTipoDocumento_Sel ;
   private String AV37TFLaboratorioEstado_Sel ;
   private String A167LaboratorioTipoDocumento ;
   private String A171LaboratorioEstado ;
   private String scmdbuf ;
   private String sImgUrl ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV26TFLaboratorioTipoDocumento_SelsJson ;
   private String AV34TFLaboratorioEstado_SelsJson ;
   private String AV53Title ;
   private String AV13FilterFullText ;
   private String AV38TFLaboratorioId_To_Description ;
   private String AV23TFLaboratorioNombre_Sel ;
   private String AV22TFLaboratorioNombre ;
   private String AV25TFLaboratorioDescripcion_Sel ;
   private String AV24TFLaboratorioDescripcion ;
   private String AV27TFLaboratorioTipoDocumento_SelDscs ;
   private String AV39FilterTFLaboratorioTipoDocumento_SelValueDescription ;
   private String AV31TFLaboratorioNroDocumento_Sel ;
   private String AV30TFLaboratorioNroDocumento ;
   private String AV40TFLaboratorioComision_To_Description ;
   private String AV35TFLaboratorioEstado_SelDscs ;
   private String AV41FilterTFLaboratorioEstado_SelValueDescription ;
   private String A165LaboratorioNombre ;
   private String A166LaboratorioDescripcion ;
   private String A168LaboratorioNroDocumento ;
   private String A40000LaboratorioPhoto_GXI ;
   private String AV63Laboratoriowwds_1_filterfulltext ;
   private String AV66Laboratoriowwds_4_tflaboratorionombre ;
   private String AV67Laboratoriowwds_5_tflaboratorionombre_sel ;
   private String AV68Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel ;
   private String AV71Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel ;
   private String lV63Laboratoriowwds_1_filterfulltext ;
   private String lV66Laboratoriowwds_4_tflaboratorionombre ;
   private String lV68Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String lV71Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String AV14LaboratorioTipoDocumentoDescription ;
   private String AV15LaboratorioEstadoDescription ;
   private String AV51PageInfo ;
   private String AV48DateInfo ;
   private String AV46AppName ;
   private String AV52Phone ;
   private String AV50Mail ;
   private String AV54Website ;
   private String AV43AddressLine1 ;
   private String AV44AddressLine2 ;
   private String AV45AddressLine3 ;
   private String A169LaboratorioPhoto ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private IDataStoreProvider pr_default ;
   private short[] P00462_A170LaboratorioComision ;
   private short[] P00462_A40LaboratorioId ;
   private String[] P00462_A171LaboratorioEstado ;
   private String[] P00462_A168LaboratorioNroDocumento ;
   private String[] P00462_A167LaboratorioTipoDocumento ;
   private String[] P00462_A166LaboratorioDescripcion ;
   private String[] P00462_A165LaboratorioNombre ;
   private String[] P00462_A40000LaboratorioPhoto_GXI ;
   private String[] P00462_A169LaboratorioPhoto ;
   private GXSimpleCollection<String> AV28TFLaboratorioTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV36TFLaboratorioEstado_Sels ;
   private GXSimpleCollection<String> AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels ;
   private GXSimpleCollection<String> AV75Laboratoriowwds_13_tflaboratorioestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV18GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV19GridStateFilterValue ;
}

final  class laboratoriowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00462( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV75Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV63Laboratoriowwds_1_filterfulltext ,
                                          short AV64Laboratoriowwds_2_tflaboratorioid ,
                                          short AV65Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV67Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV66Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV68Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV71Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV73Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV74Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV75Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[19];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [LaboratorioComision], [LaboratorioId], [LaboratorioEstado], [LaboratorioNroDocumento], [LaboratorioTipoDocumento], [LaboratorioDescripcion], [LaboratorioNombre]," ;
      scmdbuf += " [LaboratorioPhoto_GXI], [LaboratorioPhoto] FROM [Laboratorio]" ;
      if ( ! (GXutil.strcmp("", AV63Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
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
      if ( ! (0==AV64Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV65Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV66Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV68Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV70Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV71Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (0==AV73Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (0==AV74Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( AV75Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV75Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioComision]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioComision] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioEstado]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioEstado] DESC" ;
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
                  return conditional_P00462(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00462", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaUri(8);
               ((String[]) buf[8])[0] = rslt.getMultimediaFile(9, rslt.getVarchar(8));
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
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               return;
      }
   }

}

