package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class configwwexportreport_impl extends GXWebReport
{
   public configwwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConfig", GXv_boolean2) ;
         configwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV46Pgmname))}, new String[] {"GxObject"}) );
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
            AV42Title = "Lista de Config" ;
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
         h650( true, 0) ;
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
         h650( false, 19) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+19) ;
      }
      if ( ! ( (0==AV19TFConfigId) && (0==AV20TFConfigId_To) ) )
      {
         h650( false, 19) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFConfigId), "ZZZ9")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+19) ;
         AV29TFConfigId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h650( false, 19) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFConfigId_To_Description, "")), 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFConfigId_To), "ZZZ9")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+19) ;
      }
      if ( ! (GXutil.strcmp("", AV22TFConfigKey_Sel)==0) )
      {
         h650( false, 19) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Key", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFConfigKey_Sel, "")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+19) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFConfigKey)==0) )
         {
            h650( false, 19) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Key", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFConfigKey, "")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+19) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV24TFConfigValue_Sel)==0) )
      {
         h650( false, 19) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Value", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFConfigValue_Sel, "")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+19) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFConfigValue)==0) )
         {
            h650( false, 19) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Value", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFConfigValue, "")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+19) ;
         }
      }
      AV27TFConfigEstadoR_Sels.fromJSonString(AV25TFConfigEstadoR_SelsJson, null);
      if ( ! ( AV27TFConfigEstadoR_Sels.size() == 0 ) )
      {
         AV31i = 1 ;
         AV49GXV1 = 1 ;
         while ( AV49GXV1 <= AV27TFConfigEstadoR_Sels.size() )
         {
            AV28TFConfigEstadoR_Sel = (String)AV27TFConfigEstadoR_Sels.elementAt(-1+AV49GXV1) ;
            if ( AV31i == 1 )
            {
               AV26TFConfigEstadoR_SelDscs = "" ;
            }
            else
            {
               AV26TFConfigEstadoR_SelDscs += ", " ;
            }
            AV30FilterTFConfigEstadoR_SelValueDescription = com.projectthani.gxdomainestador.getDescription(httpContext,(String)AV28TFConfigEstadoR_Sel) ;
            AV26TFConfigEstadoR_SelDscs += AV30FilterTFConfigEstadoR_SelValueDescription ;
            AV31i = (long)(AV31i+1) ;
            AV49GXV1 = (int)(AV49GXV1+1) ;
         }
         h650( false, 19) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado R", 25, Gx_line+0, 115, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFConfigEstadoR_SelDscs, "")), 115, Gx_line+0, 789, Gx_line+14, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+19) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h650( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h650( false, 36) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 136, Gx_line+26, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Key", 140, Gx_line+10, 352, Gx_line+26, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Value", 356, Gx_line+10, 569, Gx_line+26, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado R", 573, Gx_line+10, 787, Gx_line+26, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+36) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV51Configwwds_1_filterfulltext = AV13FilterFullText ;
      AV52Configwwds_2_tfconfigid = AV19TFConfigId ;
      AV53Configwwds_3_tfconfigid_to = AV20TFConfigId_To ;
      AV54Configwwds_4_tfconfigkey = AV21TFConfigKey ;
      AV55Configwwds_5_tfconfigkey_sel = AV22TFConfigKey_Sel ;
      AV56Configwwds_6_tfconfigvalue = AV23TFConfigValue ;
      AV57Configwwds_7_tfconfigvalue_sel = AV24TFConfigValue_Sel ;
      AV58Configwwds_8_tfconfigestador_sels = AV27TFConfigEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A129ConfigEstadoR ,
                                           AV58Configwwds_8_tfconfigestador_sels ,
                                           AV51Configwwds_1_filterfulltext ,
                                           Short.valueOf(AV52Configwwds_2_tfconfigid) ,
                                           Short.valueOf(AV53Configwwds_3_tfconfigid_to) ,
                                           AV55Configwwds_5_tfconfigkey_sel ,
                                           AV54Configwwds_4_tfconfigkey ,
                                           AV57Configwwds_7_tfconfigvalue_sel ,
                                           AV56Configwwds_6_tfconfigvalue ,
                                           Integer.valueOf(AV58Configwwds_8_tfconfigestador_sels.size()) ,
                                           Short.valueOf(A33ConfigId) ,
                                           A127ConfigKey ,
                                           A128ConfigValue ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV54Configwwds_4_tfconfigkey = GXutil.concat( GXutil.rtrim( AV54Configwwds_4_tfconfigkey), "%", "") ;
      lV56Configwwds_6_tfconfigvalue = GXutil.concat( GXutil.rtrim( AV56Configwwds_6_tfconfigvalue), "%", "") ;
      /* Using cursor P00652 */
      pr_default.execute(0, new Object[] {lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, Short.valueOf(AV52Configwwds_2_tfconfigid), Short.valueOf(AV53Configwwds_3_tfconfigid_to), lV54Configwwds_4_tfconfigkey, AV55Configwwds_5_tfconfigkey_sel, lV56Configwwds_6_tfconfigvalue, AV57Configwwds_7_tfconfigvalue_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A33ConfigId = P00652_A33ConfigId[0] ;
         A129ConfigEstadoR = P00652_A129ConfigEstadoR[0] ;
         A128ConfigValue = P00652_A128ConfigValue[0] ;
         A127ConfigKey = P00652_A127ConfigKey[0] ;
         AV14ConfigEstadoRDescription = com.projectthani.gxdomainestador.getDescription(httpContext,(String)A129ConfigEstadoR) ;
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
         h650( false, 63) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A33ConfigId), "ZZZ9")), 30, Gx_line+10, 136, Gx_line+52, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A127ConfigKey, "")), 140, Gx_line+10, 352, Gx_line+52, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A128ConfigValue, "")), 356, Gx_line+10, 569, Gx_line+52, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14ConfigEstadoRDescription, "")), 573, Gx_line+10, 787, Gx_line+52, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+62, 789, Gx_line+62, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+63) ;
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
      if ( GXutil.strcmp(AV15Session.getValue("ConfigWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConfigWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("ConfigWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV59GXV2 = 1 ;
      while ( AV59GXV2 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV59GXV2));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGID") == 0 )
         {
            AV19TFConfigId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFConfigId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGKEY") == 0 )
         {
            AV21TFConfigKey = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGKEY_SEL") == 0 )
         {
            AV22TFConfigKey_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGVALUE") == 0 )
         {
            AV23TFConfigValue = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGVALUE_SEL") == 0 )
         {
            AV24TFConfigValue_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGESTADOR_SEL") == 0 )
         {
            AV25TFConfigEstadoR_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFConfigEstadoR_Sels.fromJSonString(AV25TFConfigEstadoR_SelsJson, null);
         }
         AV59GXV2 = (int)(AV59GXV2+1) ;
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

   public void h650( boolean bFoot ,
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
               AV40PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV37DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+39, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40PageInfo, "")), 30, Gx_line+15, 409, Gx_line+29, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37DateInfo, "")), 409, Gx_line+15, 789, Gx_line+29, 2, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+39) ;
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
            AV35AppName = "DVelop Software Solutions" ;
            AV41Phone = "+1 550 8923" ;
            AV39Mail = "info@mail.com" ;
            AV43Website = "http://www.web.com" ;
            AV32AddressLine1 = "French Boulevard 2859" ;
            AV33AddressLine2 = "Downtown" ;
            AV34AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+107, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35AppName, "")), 30, Gx_line+30, 283, Gx_line+44, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42Title, "")), 30, Gx_line+44, 283, Gx_line+77, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41Phone, "")), 283, Gx_line+30, 536, Gx_line+45, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39Mail, "")), 283, Gx_line+45, 536, Gx_line+60, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43Website, "")), 283, Gx_line+60, 536, Gx_line+77, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+45, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33AddressLine2, "")), 536, Gx_line+45, 789, Gx_line+60, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34AddressLine3, "")), 536, Gx_line+60, 789, Gx_line+77, 2, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+127) ;
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
      AV46Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV42Title = "" ;
      AV13FilterFullText = "" ;
      AV29TFConfigId_To_Description = "" ;
      AV22TFConfigKey_Sel = "" ;
      AV21TFConfigKey = "" ;
      AV24TFConfigValue_Sel = "" ;
      AV23TFConfigValue = "" ;
      AV27TFConfigEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFConfigEstadoR_SelsJson = "" ;
      AV28TFConfigEstadoR_Sel = "" ;
      AV26TFConfigEstadoR_SelDscs = "" ;
      AV30FilterTFConfigEstadoR_SelValueDescription = "" ;
      A129ConfigEstadoR = "" ;
      A127ConfigKey = "" ;
      A128ConfigValue = "" ;
      AV51Configwwds_1_filterfulltext = "" ;
      AV54Configwwds_4_tfconfigkey = "" ;
      AV55Configwwds_5_tfconfigkey_sel = "" ;
      AV56Configwwds_6_tfconfigvalue = "" ;
      AV57Configwwds_7_tfconfigvalue_sel = "" ;
      AV58Configwwds_8_tfconfigestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Configwwds_1_filterfulltext = "" ;
      lV54Configwwds_4_tfconfigkey = "" ;
      lV56Configwwds_6_tfconfigvalue = "" ;
      P00652_A33ConfigId = new short[1] ;
      P00652_A129ConfigEstadoR = new String[] {""} ;
      P00652_A128ConfigValue = new String[] {""} ;
      P00652_A127ConfigKey = new String[] {""} ;
      AV14ConfigEstadoRDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV40PageInfo = "" ;
      AV37DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV35AppName = "" ;
      AV41Phone = "" ;
      AV39Mail = "" ;
      AV43Website = "" ;
      AV32AddressLine1 = "" ;
      AV33AddressLine2 = "" ;
      AV34AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.configwwexportreport__default(),
         new Object[] {
             new Object[] {
            P00652_A33ConfigId, P00652_A129ConfigEstadoR, P00652_A128ConfigValue, P00652_A127ConfigKey
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV46Pgmname = "ConfigWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV46Pgmname = "ConfigWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV19TFConfigId ;
   private short AV20TFConfigId_To ;
   private short A33ConfigId ;
   private short AV52Configwwds_2_tfconfigid ;
   private short AV53Configwwds_3_tfconfigid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV49GXV1 ;
   private int AV58Configwwds_8_tfconfigestador_sels_size ;
   private int AV59GXV2 ;
   private long AV31i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV46Pgmname ;
   private String AV28TFConfigEstadoR_Sel ;
   private String A129ConfigEstadoR ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV25TFConfigEstadoR_SelsJson ;
   private String AV42Title ;
   private String AV13FilterFullText ;
   private String AV29TFConfigId_To_Description ;
   private String AV22TFConfigKey_Sel ;
   private String AV21TFConfigKey ;
   private String AV24TFConfigValue_Sel ;
   private String AV23TFConfigValue ;
   private String AV26TFConfigEstadoR_SelDscs ;
   private String AV30FilterTFConfigEstadoR_SelValueDescription ;
   private String A127ConfigKey ;
   private String A128ConfigValue ;
   private String AV51Configwwds_1_filterfulltext ;
   private String AV54Configwwds_4_tfconfigkey ;
   private String AV55Configwwds_5_tfconfigkey_sel ;
   private String AV56Configwwds_6_tfconfigvalue ;
   private String AV57Configwwds_7_tfconfigvalue_sel ;
   private String lV51Configwwds_1_filterfulltext ;
   private String lV54Configwwds_4_tfconfigkey ;
   private String lV56Configwwds_6_tfconfigvalue ;
   private String AV14ConfigEstadoRDescription ;
   private String AV40PageInfo ;
   private String AV37DateInfo ;
   private String AV35AppName ;
   private String AV41Phone ;
   private String AV39Mail ;
   private String AV43Website ;
   private String AV32AddressLine1 ;
   private String AV33AddressLine2 ;
   private String AV34AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private short[] P00652_A33ConfigId ;
   private String[] P00652_A129ConfigEstadoR ;
   private String[] P00652_A128ConfigValue ;
   private String[] P00652_A127ConfigKey ;
   private GXSimpleCollection<String> AV27TFConfigEstadoR_Sels ;
   private GXSimpleCollection<String> AV58Configwwds_8_tfconfigestador_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class configwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00652( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A129ConfigEstadoR ,
                                          GXSimpleCollection<String> AV58Configwwds_8_tfconfigestador_sels ,
                                          String AV51Configwwds_1_filterfulltext ,
                                          short AV52Configwwds_2_tfconfigid ,
                                          short AV53Configwwds_3_tfconfigid_to ,
                                          String AV55Configwwds_5_tfconfigkey_sel ,
                                          String AV54Configwwds_4_tfconfigkey ,
                                          String AV57Configwwds_7_tfconfigvalue_sel ,
                                          String AV56Configwwds_6_tfconfigvalue ,
                                          int AV58Configwwds_8_tfconfigestador_sels_size ,
                                          short A33ConfigId ,
                                          String A127ConfigKey ,
                                          String A128ConfigValue ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[11];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ConfigId], [ConfigEstadoR], [ConfigValue], [ConfigKey] FROM [Config]" ;
      if ( ! (GXutil.strcmp("", AV51Configwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ConfigId] AS decimal(4,0))) like '%' + ?) or ( [ConfigKey] like '%' + ?) or ( [ConfigValue] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [ConfigEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ConfigEstadoR] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV52Configwwds_2_tfconfigid) )
      {
         addWhere(sWhereString, "([ConfigId] >= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV53Configwwds_3_tfconfigid_to) )
      {
         addWhere(sWhereString, "([ConfigId] <= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV55Configwwds_5_tfconfigkey_sel)==0) && ( ! (GXutil.strcmp("", AV54Configwwds_4_tfconfigkey)==0) ) )
      {
         addWhere(sWhereString, "([ConfigKey] like ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV55Configwwds_5_tfconfigkey_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigKey] = ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Configwwds_7_tfconfigvalue_sel)==0) && ( ! (GXutil.strcmp("", AV56Configwwds_6_tfconfigvalue)==0) ) )
      {
         addWhere(sWhereString, "([ConfigValue] like ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Configwwds_7_tfconfigvalue_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigValue] = ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( AV58Configwwds_8_tfconfigestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV58Configwwds_8_tfconfigestador_sels, "[ConfigEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigKey]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigKey] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigValue]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigValue] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigEstadoR]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigEstadoR] DESC" ;
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
                  return conditional_P00652(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00652", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 500);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 500);
               }
               return;
      }
   }

}

