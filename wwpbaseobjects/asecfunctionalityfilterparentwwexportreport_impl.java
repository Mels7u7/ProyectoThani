package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class asecfunctionalityfilterparentwwexportreport_impl extends GXWebReport
{
   public asecfunctionalityfilterparentwwexportreport_impl( com.genexus.internet.HttpContext context )
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
         asecfunctionalityfilterparentwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV51Pgmname))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV27WWPContext;
            new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV27WWPContext = GXv_SdtWWPContext3[0] ;
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
            AV46Title = "Lista de Functionality" ;
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
         h1U0( true, 0) ;
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
      if ( ! (GXutil.strcmp("", AV48FilterFullText)==0) )
      {
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48FilterFullText, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (0==AV14SecFunctionalityType) )
      {
         AV13FilterSecFunctionalityTypeValueDescription = com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV14SecFunctionalityType) ;
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterSecFunctionalityTypeValueDescription, "")), 25, Gx_line+0, 814, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV17SecFunctionalityDescription)==0) )
      {
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV17SecFunctionalityDescription, "")), 25, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV20TFSecFunctionalityKey_Sel)==0) )
      {
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Key", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20TFSecFunctionalityKey_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV19TFSecFunctionalityKey)==0) )
         {
            h1U0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Key", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19TFSecFunctionalityKey, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV22TFSecFunctionalityDescription_Sel)==0) )
      {
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Description", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFSecFunctionalityDescription_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFSecFunctionalityDescription)==0) )
         {
            h1U0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Description", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFSecFunctionalityDescription, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV34TFSecFunctionalityType_Sels.fromJSonString(AV32TFSecFunctionalityType_SelsJson, null);
      if ( ! ( AV34TFSecFunctionalityType_Sels.size() == 0 ) )
      {
         AV35i = 1 ;
         AV54GXV1 = 1 ;
         while ( AV54GXV1 <= AV34TFSecFunctionalityType_Sels.size() )
         {
            AV23TFSecFunctionalityType_Sel = ((Number) AV34TFSecFunctionalityType_Sels.elementAt(-1+AV54GXV1)).byteValue() ;
            if ( AV35i == 1 )
            {
               AV33TFSecFunctionalityType_SelDscs = "" ;
            }
            else
            {
               AV33TFSecFunctionalityType_SelDscs += ", " ;
            }
            AV26FilterTFSecFunctionalityType_SelValueDescription = com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV23TFSecFunctionalityType_Sel) ;
            AV33TFSecFunctionalityType_SelDscs += AV26FilterTFSecFunctionalityType_SelValueDescription ;
            AV35i = (long)(AV35i+1) ;
            AV54GXV1 = (int)(AV54GXV1+1) ;
         }
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Type", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFSecFunctionalityType_SelDscs, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV25TFSecParentFunctionalityDescription_Sel)==0) )
      {
         h1U0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Parent Functionality", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFSecParentFunctionalityDescription_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFSecParentFunctionalityDescription)==0) )
         {
            h1U0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Parent Functionality", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFSecParentFunctionalityDescription, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h1U0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h1U0( false, 37) ;
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
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid = AV10SecParentFunctionalityId ;
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = AV48FilterFullText ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype = AV14SecFunctionalityType ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = AV17SecFunctionalityDescription ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = AV19TFSecFunctionalityKey ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel = AV20TFSecFunctionalityKey_Sel ;
      AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = AV21TFSecFunctionalityDescription ;
      AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel = AV22TFSecFunctionalityDescription_Sel ;
      AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels = AV34TFSecFunctionalityType_Sels ;
      AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = AV24TFSecParentFunctionalityDescription ;
      AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel = AV25TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels ,
                                           AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ,
                                           Byte.valueOf(AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype) ,
                                           Short.valueOf(AV16SecFunctionalityDescriptionOperator) ,
                                           AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ,
                                           AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel ,
                                           AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ,
                                           AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel ,
                                           AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels.size()) ,
                                           AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel ,
                                           AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           Long.valueOf(AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid) ,
                                           Long.valueOf(A2SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN
                                           }
      });
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription), "%", "") ;
      lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription), "%", "") ;
      lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey), "%", "") ;
      lV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription), "%", "") ;
      lV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P001U2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid), lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, Byte.valueOf(AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype), lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription, lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription, lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey, AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel, lV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription, AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel, lV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription, AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11SecParentFunctionalityDescription = P001U2_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P001U2_A9SecFunctionalityType[0] ;
         A8SecFunctionalityDescription = P001U2_A8SecFunctionalityDescription[0] ;
         A3SecFunctionalityKey = P001U2_A3SecFunctionalityKey[0] ;
         A2SecParentFunctionalityId = P001U2_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P001U2_n2SecParentFunctionalityId[0] ;
         A1SecFunctionalityId = P001U2_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P001U2_A11SecParentFunctionalityDescription[0] ;
         AV18SecFunctionalityTypeDescription = com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)A9SecFunctionalityType) ;
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
         h1U0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A3SecFunctionalityKey, "")), 30, Gx_line+10, 216, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A8SecFunctionalityDescription, "")), 220, Gx_line+10, 406, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV18SecFunctionalityTypeDescription, "")), 410, Gx_line+10, 596, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV28Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      AV11OrderedBy = AV30GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV30GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV67GXV2 = 1 ;
      while ( AV67GXV2 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV67GXV2));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV48FilterFullText = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SECFUNCTIONALITYTYPE") == 0 )
         {
            AV14SecFunctionalityType = (byte)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV17SecFunctionalityDescription = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16SecFunctionalityDescriptionOperator = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV19TFSecFunctionalityKey = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV20TFSecFunctionalityKey_Sel = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV21TFSecFunctionalityDescription = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV22TFSecFunctionalityDescription_Sel = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV32TFSecFunctionalityType_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV34TFSecFunctionalityType_Sels.fromJSonString(AV32TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV24TFSecParentFunctionalityDescription = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV25TFSecParentFunctionalityDescription_Sel = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECPARENTFUNCTIONALITYID") == 0 )
         {
            AV10SecParentFunctionalityId = GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         AV67GXV2 = (int)(AV67GXV2+1) ;
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

   public void h1U0( boolean bFoot ,
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
               AV44PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV41DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV39AppName = "DVelop Software Solutions" ;
            AV45Phone = "+1 550 8923" ;
            AV43Mail = "info@mail.com" ;
            AV47Website = "http://www.web.com" ;
            AV36AddressLine1 = "French Boulevard 2859" ;
            AV37AddressLine2 = "Downtown" ;
            AV38AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV51Pgmname = "" ;
      AV27WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV46Title = "" ;
      AV48FilterFullText = "" ;
      AV13FilterSecFunctionalityTypeValueDescription = "" ;
      AV17SecFunctionalityDescription = "" ;
      AV20TFSecFunctionalityKey_Sel = "" ;
      AV19TFSecFunctionalityKey = "" ;
      AV22TFSecFunctionalityDescription_Sel = "" ;
      AV21TFSecFunctionalityDescription = "" ;
      AV34TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV32TFSecFunctionalityType_SelsJson = "" ;
      AV33TFSecFunctionalityType_SelDscs = "" ;
      AV26FilterTFSecFunctionalityType_SelValueDescription = "" ;
      AV25TFSecParentFunctionalityDescription_Sel = "" ;
      AV24TFSecParentFunctionalityDescription = "" ;
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = "" ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = "" ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = "" ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel = "" ;
      AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = "" ;
      AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel = "" ;
      AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = "" ;
      AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel = "" ;
      scmdbuf = "" ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = "" ;
      lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = "" ;
      lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = "" ;
      lV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = "" ;
      lV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = "" ;
      P001U2_A11SecParentFunctionalityDescription = new String[] {""} ;
      P001U2_A9SecFunctionalityType = new byte[1] ;
      P001U2_A8SecFunctionalityDescription = new String[] {""} ;
      P001U2_A3SecFunctionalityKey = new String[] {""} ;
      P001U2_A2SecParentFunctionalityId = new long[1] ;
      P001U2_n2SecParentFunctionalityId = new boolean[] {false} ;
      P001U2_A1SecFunctionalityId = new long[1] ;
      AV18SecFunctionalityTypeDescription = "" ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV44PageInfo = "" ;
      AV41DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV39AppName = "" ;
      AV45Phone = "" ;
      AV43Mail = "" ;
      AV47Website = "" ;
      AV36AddressLine1 = "" ;
      AV37AddressLine2 = "" ;
      AV38AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.asecfunctionalityfilterparentwwexportreport__default(),
         new Object[] {
             new Object[] {
            P001U2_A11SecParentFunctionalityDescription, P001U2_A9SecFunctionalityType, P001U2_A8SecFunctionalityDescription, P001U2_A3SecFunctionalityKey, P001U2_A2SecParentFunctionalityId, P001U2_n2SecParentFunctionalityId, P001U2_A1SecFunctionalityId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV51Pgmname = "WWPBaseObjects.ASecFunctionalityFilterParentWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV51Pgmname = "WWPBaseObjects.ASecFunctionalityFilterParentWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14SecFunctionalityType ;
   private byte AV23TFSecFunctionalityType_Sel ;
   private byte A9SecFunctionalityType ;
   private byte AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype ;
   private short gxcookieaux ;
   private short AV16SecFunctionalityDescriptionOperator ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV54GXV1 ;
   private int AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels_size ;
   private int AV67GXV2 ;
   private long AV35i ;
   private long AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ;
   private long AV10SecParentFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV51Pgmname ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n2SecParentFunctionalityId ;
   private String AV32TFSecFunctionalityType_SelsJson ;
   private String AV46Title ;
   private String AV48FilterFullText ;
   private String AV13FilterSecFunctionalityTypeValueDescription ;
   private String AV17SecFunctionalityDescription ;
   private String AV20TFSecFunctionalityKey_Sel ;
   private String AV19TFSecFunctionalityKey ;
   private String AV22TFSecFunctionalityDescription_Sel ;
   private String AV21TFSecFunctionalityDescription ;
   private String AV33TFSecFunctionalityType_SelDscs ;
   private String AV26FilterTFSecFunctionalityType_SelValueDescription ;
   private String AV25TFSecParentFunctionalityDescription_Sel ;
   private String AV24TFSecParentFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ;
   private String AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ;
   private String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ;
   private String AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel ;
   private String AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ;
   private String AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel ;
   private String AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ;
   private String AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel ;
   private String lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ;
   private String lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ;
   private String lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ;
   private String lV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ;
   private String lV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ;
   private String AV18SecFunctionalityTypeDescription ;
   private String AV44PageInfo ;
   private String AV41DateInfo ;
   private String AV39AppName ;
   private String AV45Phone ;
   private String AV43Mail ;
   private String AV47Website ;
   private String AV36AddressLine1 ;
   private String AV37AddressLine2 ;
   private String AV38AddressLine3 ;
   private GXSimpleCollection<Byte> AV34TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private IDataStoreProvider pr_default ;
   private String[] P001U2_A11SecParentFunctionalityDescription ;
   private byte[] P001U2_A9SecFunctionalityType ;
   private String[] P001U2_A8SecFunctionalityDescription ;
   private String[] P001U2_A3SecFunctionalityKey ;
   private long[] P001U2_A2SecParentFunctionalityId ;
   private boolean[] P001U2_n2SecParentFunctionalityId ;
   private long[] P001U2_A1SecFunctionalityId ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV27WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class asecfunctionalityfilterparentwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001U2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels ,
                                          String AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ,
                                          byte AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype ,
                                          short AV16SecFunctionalityDescriptionOperator ,
                                          String AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ,
                                          String AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel ,
                                          String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ,
                                          String AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel ,
                                          String AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ,
                                          int AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels_size ,
                                          String AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel ,
                                          String AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          long AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ,
                                          long A2SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[18];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecFunctionalityType], T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey]," ;
      scmdbuf += " T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      addWhere(sWhereString, "(T1.[SecParentFunctionalityId] = ?)");
      if ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (0==AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityType] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ( AV16SecFunctionalityDescriptionOperator == 0 ) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ( AV16SecFunctionalityDescriptionOperator == 1 ) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like '%' + ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T1.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T1.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T1.[SecFunctionalityKey]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T1.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T1.[SecFunctionalityType]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T1.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T2.[SecFunctionalityDescription] DESC" ;
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
                  return conditional_P001U2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001U2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
                  stmt.setLong(sIdx, ((Number) parms[18]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               return;
      }
   }

}

