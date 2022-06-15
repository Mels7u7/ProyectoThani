package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class medicamentowwexportreport_impl extends GXWebReport
{
   public medicamentowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento", GXv_boolean2) ;
         medicamentowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV41Pgmname))}, new String[] {"GxObject"}) );
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
            AV37Title = "Lista de Medicamento" ;
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
         h7Z0( true, 0) ;
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
         h7Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV18TFMedicamentoId) && (0==AV19TFMedicamentoId_To) ) )
      {
         h7Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18TFMedicamentoId), "ZZZ9")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV26TFMedicamentoId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h7Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFMedicamentoId_To_Description, "")), 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFMedicamentoId_To), "ZZZ9")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV21TFMedicamentoCodigo_Sel)==0) )
      {
         h7Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Codigo", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFMedicamentoCodigo_Sel, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV20TFMedicamentoCodigo)==0) )
         {
            h7Z0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Codigo", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20TFMedicamentoCodigo, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV23TFMedicamentoNombre_Sel)==0) )
      {
         h7Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFMedicamentoNombre_Sel, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFMedicamentoNombre)==0) )
         {
            h7Z0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFMedicamentoNombre, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFMedicamentoFormaFarm_Sel)==0) )
      {
         h7Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Forma Farm", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFMedicamentoFormaFarm_Sel, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFMedicamentoFormaFarm)==0) )
         {
            h7Z0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Forma Farm", 25, Gx_line+0, 89, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFMedicamentoFormaFarm, "")), 89, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h7Z0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h7Z0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 154, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Codigo", 158, Gx_line+10, 282, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 286, Gx_line+10, 534, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Forma Farm", 538, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV45Medicamentowwds_1_filterfulltext = AV13FilterFullText ;
      AV46Medicamentowwds_2_tfmedicamentoid = AV18TFMedicamentoId ;
      AV47Medicamentowwds_3_tfmedicamentoid_to = AV19TFMedicamentoId_To ;
      AV48Medicamentowwds_4_tfmedicamentocodigo = AV20TFMedicamentoCodigo ;
      AV49Medicamentowwds_5_tfmedicamentocodigo_sel = AV21TFMedicamentoCodigo_Sel ;
      AV50Medicamentowwds_6_tfmedicamentonombre = AV22TFMedicamentoNombre ;
      AV51Medicamentowwds_7_tfmedicamentonombre_sel = AV23TFMedicamentoNombre_Sel ;
      AV52Medicamentowwds_8_tfmedicamentoformafarm = AV24TFMedicamentoFormaFarm ;
      AV53Medicamentowwds_9_tfmedicamentoformafarm_sel = AV25TFMedicamentoFormaFarm_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV45Medicamentowwds_1_filterfulltext ,
                                           Short.valueOf(AV46Medicamentowwds_2_tfmedicamentoid) ,
                                           Short.valueOf(AV47Medicamentowwds_3_tfmedicamentoid_to) ,
                                           AV49Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                           AV48Medicamentowwds_4_tfmedicamentocodigo ,
                                           AV51Medicamentowwds_7_tfmedicamentonombre_sel ,
                                           AV50Medicamentowwds_6_tfmedicamentonombre ,
                                           AV53Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                           AV52Medicamentowwds_8_tfmedicamentoformafarm ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV45Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_1_filterfulltext), "%", "") ;
      lV45Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_1_filterfulltext), "%", "") ;
      lV45Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_1_filterfulltext), "%", "") ;
      lV45Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_1_filterfulltext), "%", "") ;
      lV48Medicamentowwds_4_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV48Medicamentowwds_4_tfmedicamentocodigo), "%", "") ;
      lV50Medicamentowwds_6_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV50Medicamentowwds_6_tfmedicamentonombre), "%", "") ;
      lV52Medicamentowwds_8_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV52Medicamentowwds_8_tfmedicamentoformafarm), "%", "") ;
      /* Using cursor P007Z2 */
      pr_default.execute(0, new Object[] {lV45Medicamentowwds_1_filterfulltext, lV45Medicamentowwds_1_filterfulltext, lV45Medicamentowwds_1_filterfulltext, lV45Medicamentowwds_1_filterfulltext, Short.valueOf(AV46Medicamentowwds_2_tfmedicamentoid), Short.valueOf(AV47Medicamentowwds_3_tfmedicamentoid_to), lV48Medicamentowwds_4_tfmedicamentocodigo, AV49Medicamentowwds_5_tfmedicamentocodigo_sel, lV50Medicamentowwds_6_tfmedicamentonombre, AV51Medicamentowwds_7_tfmedicamentonombre_sel, lV52Medicamentowwds_8_tfmedicamentoformafarm, AV53Medicamentowwds_9_tfmedicamentoformafarm_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A42MedicamentoId = P007Z2_A42MedicamentoId[0] ;
         A231MedicamentoFormaFarm = P007Z2_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P007Z2_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P007Z2_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P007Z2_A229MedicamentoCodigo[0] ;
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
         h7Z0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A42MedicamentoId), "ZZZ9")), 30, Gx_line+10, 154, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A229MedicamentoCodigo, "")), 158, Gx_line+10, 282, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A230MedicamentoNombre, "")), 286, Gx_line+10, 534, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A231MedicamentoFormaFarm, "")), 538, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+36) ;
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
      if ( GXutil.strcmp(AV14Session.getValue("MedicamentoWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MedicamentoWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("MedicamentoWWGridState"), null, null);
      }
      AV11OrderedBy = AV16GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV16GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV54GXV1 = 1 ;
      while ( AV54GXV1 <= AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV17GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV54GXV1));
         if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOID") == 0 )
         {
            AV18TFMedicamentoId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFMedicamentoId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO") == 0 )
         {
            AV20TFMedicamentoCodigo = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO_SEL") == 0 )
         {
            AV21TFMedicamentoCodigo_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE") == 0 )
         {
            AV22TFMedicamentoNombre = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE_SEL") == 0 )
         {
            AV23TFMedicamentoNombre_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM") == 0 )
         {
            AV24TFMedicamentoFormaFarm = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM_SEL") == 0 )
         {
            AV25TFMedicamentoFormaFarm_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV54GXV1 = (int)(AV54GXV1+1) ;
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

   public void h7Z0( boolean bFoot ,
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
               AV35PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV32DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV30AppName = "DVelop Software Solutions" ;
            AV36Phone = "+1 550 8923" ;
            AV34Mail = "info@mail.com" ;
            AV38Website = "http://www.web.com" ;
            AV27AddressLine1 = "French Boulevard 2859" ;
            AV28AddressLine2 = "Downtown" ;
            AV29AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV41Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV37Title = "" ;
      AV13FilterFullText = "" ;
      AV26TFMedicamentoId_To_Description = "" ;
      AV21TFMedicamentoCodigo_Sel = "" ;
      AV20TFMedicamentoCodigo = "" ;
      AV23TFMedicamentoNombre_Sel = "" ;
      AV22TFMedicamentoNombre = "" ;
      AV25TFMedicamentoFormaFarm_Sel = "" ;
      AV24TFMedicamentoFormaFarm = "" ;
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      AV45Medicamentowwds_1_filterfulltext = "" ;
      AV48Medicamentowwds_4_tfmedicamentocodigo = "" ;
      AV49Medicamentowwds_5_tfmedicamentocodigo_sel = "" ;
      AV50Medicamentowwds_6_tfmedicamentonombre = "" ;
      AV51Medicamentowwds_7_tfmedicamentonombre_sel = "" ;
      AV52Medicamentowwds_8_tfmedicamentoformafarm = "" ;
      AV53Medicamentowwds_9_tfmedicamentoformafarm_sel = "" ;
      scmdbuf = "" ;
      lV45Medicamentowwds_1_filterfulltext = "" ;
      lV48Medicamentowwds_4_tfmedicamentocodigo = "" ;
      lV50Medicamentowwds_6_tfmedicamentonombre = "" ;
      lV52Medicamentowwds_8_tfmedicamentoformafarm = "" ;
      P007Z2_A42MedicamentoId = new short[1] ;
      P007Z2_A231MedicamentoFormaFarm = new String[] {""} ;
      P007Z2_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P007Z2_A230MedicamentoNombre = new String[] {""} ;
      P007Z2_A229MedicamentoCodigo = new String[] {""} ;
      AV14Session = httpContext.getWebSession();
      AV16GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35PageInfo = "" ;
      AV32DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV30AppName = "" ;
      AV36Phone = "" ;
      AV34Mail = "" ;
      AV38Website = "" ;
      AV27AddressLine1 = "" ;
      AV28AddressLine2 = "" ;
      AV29AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.medicamentowwexportreport__default(),
         new Object[] {
             new Object[] {
            P007Z2_A42MedicamentoId, P007Z2_A231MedicamentoFormaFarm, P007Z2_n231MedicamentoFormaFarm, P007Z2_A230MedicamentoNombre, P007Z2_A229MedicamentoCodigo
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV41Pgmname = "MedicamentoWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV41Pgmname = "MedicamentoWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV18TFMedicamentoId ;
   private short AV19TFMedicamentoId_To ;
   private short A42MedicamentoId ;
   private short AV46Medicamentowwds_2_tfmedicamentoid ;
   private short AV47Medicamentowwds_3_tfmedicamentoid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV54GXV1 ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV41Pgmname ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n231MedicamentoFormaFarm ;
   private String AV37Title ;
   private String AV13FilterFullText ;
   private String AV26TFMedicamentoId_To_Description ;
   private String AV21TFMedicamentoCodigo_Sel ;
   private String AV20TFMedicamentoCodigo ;
   private String AV23TFMedicamentoNombre_Sel ;
   private String AV22TFMedicamentoNombre ;
   private String AV25TFMedicamentoFormaFarm_Sel ;
   private String AV24TFMedicamentoFormaFarm ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String AV45Medicamentowwds_1_filterfulltext ;
   private String AV48Medicamentowwds_4_tfmedicamentocodigo ;
   private String AV49Medicamentowwds_5_tfmedicamentocodigo_sel ;
   private String AV50Medicamentowwds_6_tfmedicamentonombre ;
   private String AV51Medicamentowwds_7_tfmedicamentonombre_sel ;
   private String AV52Medicamentowwds_8_tfmedicamentoformafarm ;
   private String AV53Medicamentowwds_9_tfmedicamentoformafarm_sel ;
   private String lV45Medicamentowwds_1_filterfulltext ;
   private String lV48Medicamentowwds_4_tfmedicamentocodigo ;
   private String lV50Medicamentowwds_6_tfmedicamentonombre ;
   private String lV52Medicamentowwds_8_tfmedicamentoformafarm ;
   private String AV35PageInfo ;
   private String AV32DateInfo ;
   private String AV30AppName ;
   private String AV36Phone ;
   private String AV34Mail ;
   private String AV38Website ;
   private String AV27AddressLine1 ;
   private String AV28AddressLine2 ;
   private String AV29AddressLine3 ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private short[] P007Z2_A42MedicamentoId ;
   private String[] P007Z2_A231MedicamentoFormaFarm ;
   private boolean[] P007Z2_n231MedicamentoFormaFarm ;
   private String[] P007Z2_A230MedicamentoNombre ;
   private String[] P007Z2_A229MedicamentoCodigo ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class medicamentowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007Z2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV45Medicamentowwds_1_filterfulltext ,
                                          short AV46Medicamentowwds_2_tfmedicamentoid ,
                                          short AV47Medicamentowwds_3_tfmedicamentoid_to ,
                                          String AV49Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                          String AV48Medicamentowwds_4_tfmedicamentocodigo ,
                                          String AV51Medicamentowwds_7_tfmedicamentonombre_sel ,
                                          String AV50Medicamentowwds_6_tfmedicamentonombre ,
                                          String AV53Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                          String AV52Medicamentowwds_8_tfmedicamentoformafarm ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[12];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [MedicamentoId], [MedicamentoFormaFarm], [MedicamentoNombre], [MedicamentoCodigo] FROM [Medicamento]" ;
      if ( ! (GXutil.strcmp("", AV45Medicamentowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( [MedicamentoCodigo] like '%' + ?) or ( [MedicamentoNombre] like '%' + ?) or ( [MedicamentoFormaFarm] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV46Medicamentowwds_2_tfmedicamentoid) )
      {
         addWhere(sWhereString, "([MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV47Medicamentowwds_3_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "([MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV49Medicamentowwds_5_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV48Medicamentowwds_4_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV49Medicamentowwds_5_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV51Medicamentowwds_7_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV50Medicamentowwds_6_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV51Medicamentowwds_7_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV53Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV52Medicamentowwds_8_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [MedicamentoCodigo]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [MedicamentoCodigo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [MedicamentoId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [MedicamentoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [MedicamentoNombre]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [MedicamentoNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [MedicamentoFormaFarm]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [MedicamentoFormaFarm] DESC" ;
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
                  return conditional_P007Z2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007Z2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 15);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 15);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
      }
   }

}

