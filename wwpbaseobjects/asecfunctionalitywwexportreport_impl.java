package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class asecfunctionalitywwexportreport_impl extends GXWebReport
{
   public asecfunctionalitywwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
         asecfunctionalitywwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV50Pgmname))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV26WWPContext;
            new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV26WWPContext = GXv_SdtWWPContext3[0] ;
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
            AV45Title = "Lista de Functionality" ;
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
         h1Z0( true, 0) ;
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
      if ( ! (GXutil.strcmp("", AV47FilterFullText)==0) )
      {
         h1Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47FilterFullText, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV19TFSecFunctionalityKey_Sel)==0) )
      {
         h1Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Key", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19TFSecFunctionalityKey_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV18TFSecFunctionalityKey)==0) )
         {
            h1Z0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Key", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV18TFSecFunctionalityKey, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV21TFSecFunctionalityDescription_Sel)==0) )
      {
         h1Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Description", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFSecFunctionalityDescription_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV20TFSecFunctionalityDescription)==0) )
         {
            h1Z0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Description", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20TFSecFunctionalityDescription, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV33TFSecFunctionalityType_Sels.fromJSonString(AV31TFSecFunctionalityType_SelsJson, null);
      if ( ! ( AV33TFSecFunctionalityType_Sels.size() == 0 ) )
      {
         AV34i = 1 ;
         AV53GXV1 = 1 ;
         while ( AV53GXV1 <= AV33TFSecFunctionalityType_Sels.size() )
         {
            AV22TFSecFunctionalityType_Sel = ((Number) AV33TFSecFunctionalityType_Sels.elementAt(-1+AV53GXV1)).byteValue() ;
            if ( AV34i == 1 )
            {
               AV32TFSecFunctionalityType_SelDscs = "" ;
            }
            else
            {
               AV32TFSecFunctionalityType_SelDscs += ", " ;
            }
            AV25FilterTFSecFunctionalityType_SelValueDescription = com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV22TFSecFunctionalityType_Sel) ;
            AV32TFSecFunctionalityType_SelDscs += AV25FilterTFSecFunctionalityType_SelValueDescription ;
            AV34i = (long)(AV34i+1) ;
            AV53GXV1 = (int)(AV53GXV1+1) ;
         }
         h1Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Type", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFSecFunctionalityType_SelDscs, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV24TFSecParentFunctionalityDescription_Sel)==0) )
      {
         h1Z0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Parent Functionality", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFSecParentFunctionalityDescription_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFSecParentFunctionalityDescription)==0) )
         {
            h1Z0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Parent Functionality", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFSecParentFunctionalityDescription, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h1Z0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h1Z0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Key", 30, Gx_line+10, 216, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Description", 220, Gx_line+10, 406, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Type", 410, Gx_line+10, 596, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Parent Functionality", 600, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV47FilterFullText ;
      AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV18TFSecFunctionalityKey ;
      AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV19TFSecFunctionalityKey_Sel ;
      AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV20TFSecFunctionalityDescription ;
      AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV21TFSecFunctionalityDescription_Sel ;
      AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV33TFSecFunctionalityType_Sels ;
      AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV23TFSecParentFunctionalityDescription ;
      AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV24TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                           AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                           AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                           AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                           AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                           AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                           AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV10OrderedBy) ,
                                           Boolean.valueOf(AV11OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
      lV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P001Z2 */
      pr_default.execute(0, new Object[] {lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2SecParentFunctionalityId = P001Z2_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P001Z2_n2SecParentFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P001Z2_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P001Z2_A9SecFunctionalityType[0] ;
         A8SecFunctionalityDescription = P001Z2_A8SecFunctionalityDescription[0] ;
         A3SecFunctionalityKey = P001Z2_A3SecFunctionalityKey[0] ;
         A1SecFunctionalityId = P001Z2_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P001Z2_A11SecParentFunctionalityDescription[0] ;
         AV17SecFunctionalityTypeDescription = com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)A9SecFunctionalityType) ;
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
         h1Z0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A3SecFunctionalityKey, "")), 30, Gx_line+10, 216, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A8SecFunctionalityDescription, "")), 220, Gx_line+10, 406, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV17SecFunctionalityTypeDescription, "")), 410, Gx_line+10, 596, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A11SecParentFunctionalityDescription, "")), 600, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+36) ;
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
      if ( GXutil.strcmp(AV27Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      AV10OrderedBy = AV29GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV11OrderedDsc = AV29GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV63GXV2 = 1 ;
      while ( AV63GXV2 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV2));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV47FilterFullText = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV18TFSecFunctionalityKey = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV19TFSecFunctionalityKey_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV20TFSecFunctionalityDescription = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV21TFSecFunctionalityDescription_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV31TFSecFunctionalityType_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV33TFSecFunctionalityType_Sels.fromJSonString(AV31TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV23TFSecParentFunctionalityDescription = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV24TFSecParentFunctionalityDescription_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV63GXV2 = (int)(AV63GXV2+1) ;
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

   public void h1Z0( boolean bFoot ,
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
               AV43PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV40DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV38AppName = "DVelop Software Solutions" ;
            AV44Phone = "+1 550 8923" ;
            AV42Mail = "info@mail.com" ;
            AV46Website = "http://www.web.com" ;
            AV35AddressLine1 = "French Boulevard 2859" ;
            AV36AddressLine2 = "Downtown" ;
            AV37AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV50Pgmname = "" ;
      AV26WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV45Title = "" ;
      AV47FilterFullText = "" ;
      AV19TFSecFunctionalityKey_Sel = "" ;
      AV18TFSecFunctionalityKey = "" ;
      AV21TFSecFunctionalityDescription_Sel = "" ;
      AV20TFSecFunctionalityDescription = "" ;
      AV33TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV31TFSecFunctionalityType_SelsJson = "" ;
      AV32TFSecFunctionalityType_SelDscs = "" ;
      AV25FilterTFSecFunctionalityType_SelValueDescription = "" ;
      AV24TFSecParentFunctionalityDescription_Sel = "" ;
      AV23TFSecParentFunctionalityDescription = "" ;
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = "" ;
      AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = "" ;
      AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = "" ;
      scmdbuf = "" ;
      lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      lV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      lV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      lV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      P001Z2_A2SecParentFunctionalityId = new long[1] ;
      P001Z2_n2SecParentFunctionalityId = new boolean[] {false} ;
      P001Z2_A11SecParentFunctionalityDescription = new String[] {""} ;
      P001Z2_A9SecFunctionalityType = new byte[1] ;
      P001Z2_A8SecFunctionalityDescription = new String[] {""} ;
      P001Z2_A3SecFunctionalityKey = new String[] {""} ;
      P001Z2_A1SecFunctionalityId = new long[1] ;
      AV17SecFunctionalityTypeDescription = "" ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43PageInfo = "" ;
      AV40DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV38AppName = "" ;
      AV44Phone = "" ;
      AV42Mail = "" ;
      AV46Website = "" ;
      AV35AddressLine1 = "" ;
      AV36AddressLine2 = "" ;
      AV37AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.asecfunctionalitywwexportreport__default(),
         new Object[] {
             new Object[] {
            P001Z2_A2SecParentFunctionalityId, P001Z2_n2SecParentFunctionalityId, P001Z2_A11SecParentFunctionalityDescription, P001Z2_A9SecFunctionalityType, P001Z2_A8SecFunctionalityDescription, P001Z2_A3SecFunctionalityKey, P001Z2_A1SecFunctionalityId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV50Pgmname = "WWPBaseObjects.ASecFunctionalityWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV50Pgmname = "WWPBaseObjects.ASecFunctionalityWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22TFSecFunctionalityType_Sel ;
   private byte A9SecFunctionalityType ;
   private short gxcookieaux ;
   private short AV10OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV53GXV1 ;
   private int AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ;
   private int AV63GXV2 ;
   private long AV34i ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV50Pgmname ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV11OrderedDsc ;
   private boolean n2SecParentFunctionalityId ;
   private String AV31TFSecFunctionalityType_SelsJson ;
   private String AV45Title ;
   private String AV47FilterFullText ;
   private String AV19TFSecFunctionalityKey_Sel ;
   private String AV18TFSecFunctionalityKey ;
   private String AV21TFSecFunctionalityDescription_Sel ;
   private String AV20TFSecFunctionalityDescription ;
   private String AV32TFSecFunctionalityType_SelDscs ;
   private String AV25FilterTFSecFunctionalityType_SelValueDescription ;
   private String AV24TFSecParentFunctionalityDescription_Sel ;
   private String AV23TFSecParentFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ;
   private String AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ;
   private String AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ;
   private String lV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String lV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String lV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String lV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String AV17SecFunctionalityTypeDescription ;
   private String AV43PageInfo ;
   private String AV40DateInfo ;
   private String AV38AppName ;
   private String AV44Phone ;
   private String AV42Mail ;
   private String AV46Website ;
   private String AV35AddressLine1 ;
   private String AV36AddressLine2 ;
   private String AV37AddressLine3 ;
   private GXSimpleCollection<Byte> AV33TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private IDataStoreProvider pr_default ;
   private long[] P001Z2_A2SecParentFunctionalityId ;
   private boolean[] P001Z2_n2SecParentFunctionalityId ;
   private String[] P001Z2_A11SecParentFunctionalityDescription ;
   private byte[] P001Z2_A9SecFunctionalityType ;
   private String[] P001Z2_A8SecFunctionalityDescription ;
   private String[] P001Z2_A3SecFunctionalityKey ;
   private long[] P001Z2_A1SecFunctionalityId ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV26WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class asecfunctionalitywwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001Z2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV10OrderedBy ,
                                          boolean AV11OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecFunctionalityType]," ;
      scmdbuf += " T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey], T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      if ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
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
      }
      if ( (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV56Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV10OrderedBy == 1 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV10OrderedBy == 1 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityKey]" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityType]" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SecFunctionalityDescription] DESC" ;
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
                  return conditional_P001Z2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001Z2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
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
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
      }
   }

}

