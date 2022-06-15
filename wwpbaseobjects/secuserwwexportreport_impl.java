package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuserwwexportreport_impl extends GXWebReport
{
   public secuserwwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser", GXv_boolean2) ;
         secuserwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV62Pgmname))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV32WWPContext;
            new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV32WWPContext = GXv_SdtWWPContext3[0] ;
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
            AV46Title = "Lista de User" ;
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
         h2A0( true, 0) ;
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
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48FilterFullText, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV28TFSecUserId) && (0==AV29TFSecUserId_To) ) )
      {
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV28TFSecUserId), "ZZZ9")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV35TFSecUserId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFSecUserId_To_Description, "")), 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV29TFSecUserId_To), "ZZZ9")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV31TFSecUserName_Sel)==0) )
      {
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Name", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFSecUserName_Sel, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFSecUserName)==0) )
         {
            h2A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Name", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFSecUserName, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV51TFSecUserPassword_Sel)==0) )
      {
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Password", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51TFSecUserPassword_Sel, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV50TFSecUserPassword)==0) )
         {
            h2A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Password", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50TFSecUserPassword, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV53TFSecUserEmail_Sel)==0) )
      {
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Correo", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53TFSecUserEmail_Sel, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV52TFSecUserEmail)==0) )
         {
            h2A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Correo", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52TFSecUserEmail, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV56TFSecUserEstadoR_Sels.fromJSonString(AV54TFSecUserEstadoR_SelsJson, null);
      if ( ! ( AV56TFSecUserEstadoR_Sels.size() == 0 ) )
      {
         AV59i = 1 ;
         AV65GXV1 = 1 ;
         while ( AV65GXV1 <= AV56TFSecUserEstadoR_Sels.size() )
         {
            AV57TFSecUserEstadoR_Sel = (String)AV56TFSecUserEstadoR_Sels.elementAt(-1+AV65GXV1) ;
            if ( AV59i == 1 )
            {
               AV55TFSecUserEstadoR_SelDscs = "" ;
            }
            else
            {
               AV55TFSecUserEstadoR_SelDscs += ", " ;
            }
            AV58FilterTFSecUserEstadoR_SelValueDescription = com.projectthani.gxdomainestador.getDescription(httpContext,(String)AV57TFSecUserEstadoR_Sel) ;
            AV55TFSecUserEstadoR_SelDscs += AV58FilterTFSecUserEstadoR_SelValueDescription ;
            AV59i = (long)(AV59i+1) ;
            AV65GXV1 = (int)(AV65GXV1+1) ;
         }
         h2A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado R", 25, Gx_line+0, 80, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV55TFSecUserEstadoR_SelDscs, "")), 80, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h2A0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h2A0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 112, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Name", 116, Gx_line+10, 280, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Password", 284, Gx_line+10, 448, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Correo", 452, Gx_line+10, 617, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado R", 621, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV67Wwpbaseobjects_secuserwwds_1_filterfulltext = AV48FilterFullText ;
      AV68Wwpbaseobjects_secuserwwds_2_tfsecuserid = AV28TFSecUserId ;
      AV69Wwpbaseobjects_secuserwwds_3_tfsecuserid_to = AV29TFSecUserId_To ;
      AV70Wwpbaseobjects_secuserwwds_4_tfsecusername = AV30TFSecUserName ;
      AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = AV31TFSecUserName_Sel ;
      AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = AV50TFSecUserPassword ;
      AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = AV51TFSecUserPassword_Sel ;
      AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail = AV52TFSecUserEmail ;
      AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = AV53TFSecUserEmail_Sel ;
      AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = AV56TFSecUserEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A211SecUserEstadoR ,
                                           AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                           AV67Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                           Short.valueOf(AV68Wwpbaseobjects_secuserwwds_2_tfsecuserid) ,
                                           Short.valueOf(AV69Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) ,
                                           AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                           AV70Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                           AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                           AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                           AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                           AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                           Integer.valueOf(AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels.size()) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           A15SecUserPassword ,
                                           A122SecUserEmail ,
                                           Short.valueOf(AV10OrderedBy) ,
                                           Boolean.valueOf(AV11OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV70Wwpbaseobjects_secuserwwds_4_tfsecusername = GXutil.concat( GXutil.rtrim( AV70Wwpbaseobjects_secuserwwds_4_tfsecusername), "%", "") ;
      lV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = GXutil.concat( GXutil.rtrim( AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword), "%", "") ;
      lV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail = GXutil.concat( GXutil.rtrim( AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail), "%", "") ;
      /* Using cursor P002A2 */
      pr_default.execute(0, new Object[] {lV67Wwpbaseobjects_secuserwwds_1_filterfulltext, lV67Wwpbaseobjects_secuserwwds_1_filterfulltext, lV67Wwpbaseobjects_secuserwwds_1_filterfulltext, lV67Wwpbaseobjects_secuserwwds_1_filterfulltext, lV67Wwpbaseobjects_secuserwwds_1_filterfulltext, lV67Wwpbaseobjects_secuserwwds_1_filterfulltext, Short.valueOf(AV68Wwpbaseobjects_secuserwwds_2_tfsecuserid), Short.valueOf(AV69Wwpbaseobjects_secuserwwds_3_tfsecuserid_to), lV70Wwpbaseobjects_secuserwwds_4_tfsecusername, AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel, lV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword, AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel, lV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail, AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6SecUserId = P002A2_A6SecUserId[0] ;
         A211SecUserEstadoR = P002A2_A211SecUserEstadoR[0] ;
         A122SecUserEmail = P002A2_A122SecUserEmail[0] ;
         A15SecUserPassword = P002A2_A15SecUserPassword[0] ;
         A14SecUserName = P002A2_A14SecUserName[0] ;
         AV49SecUserEstadoRDescription = com.projectthani.gxdomainestador.getDescription(httpContext,(String)A211SecUserEstadoR) ;
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
         h2A0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9")), 30, Gx_line+10, 112, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A14SecUserName, "")), 116, Gx_line+10, 280, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A15SecUserPassword, "")), 284, Gx_line+10, 448, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A122SecUserEmail, "")), 452, Gx_line+10, 617, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49SecUserEstadoRDescription, "")), 621, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV33Session.getValue("WWPBaseObjects.SecUserWWGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV33Session.getValue("WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      AV10OrderedBy = AV24GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV11OrderedDsc = AV24GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV77GXV2 = 1 ;
      while ( AV77GXV2 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV2));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV48FilterFullText = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV28TFSecUserId = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV29TFSecUserId_To = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV30TFSecUserName = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV31TFSecUserName_Sel = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPASSWORD") == 0 )
         {
            AV50TFSecUserPassword = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPASSWORD_SEL") == 0 )
         {
            AV51TFSecUserPassword_Sel = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSEREMAIL") == 0 )
         {
            AV52TFSecUserEmail = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSEREMAIL_SEL") == 0 )
         {
            AV53TFSecUserEmail_Sel = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERESTADOR_SEL") == 0 )
         {
            AV54TFSecUserEstadoR_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFSecUserEstadoR_Sels.fromJSonString(AV54TFSecUserEstadoR_SelsJson, null);
         }
         AV77GXV2 = (int)(AV77GXV2+1) ;
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

   public void h2A0( boolean bFoot ,
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
      AV62Pgmname = "" ;
      AV32WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV46Title = "" ;
      AV48FilterFullText = "" ;
      AV35TFSecUserId_To_Description = "" ;
      AV31TFSecUserName_Sel = "" ;
      AV30TFSecUserName = "" ;
      AV51TFSecUserPassword_Sel = "" ;
      AV50TFSecUserPassword = "" ;
      AV53TFSecUserEmail_Sel = "" ;
      AV52TFSecUserEmail = "" ;
      AV56TFSecUserEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFSecUserEstadoR_SelsJson = "" ;
      AV57TFSecUserEstadoR_Sel = "A" ;
      AV55TFSecUserEstadoR_SelDscs = "" ;
      AV58FilterTFSecUserEstadoR_SelValueDescription = "" ;
      A211SecUserEstadoR = "" ;
      A14SecUserName = "" ;
      A15SecUserPassword = "" ;
      A122SecUserEmail = "" ;
      AV67Wwpbaseobjects_secuserwwds_1_filterfulltext = "" ;
      AV70Wwpbaseobjects_secuserwwds_4_tfsecusername = "" ;
      AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = "" ;
      AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = "" ;
      AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = "" ;
      AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail = "" ;
      AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = "" ;
      AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Wwpbaseobjects_secuserwwds_1_filterfulltext = "" ;
      lV70Wwpbaseobjects_secuserwwds_4_tfsecusername = "" ;
      lV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = "" ;
      lV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail = "" ;
      P002A2_A6SecUserId = new short[1] ;
      P002A2_A211SecUserEstadoR = new String[] {""} ;
      P002A2_A122SecUserEmail = new String[] {""} ;
      P002A2_A15SecUserPassword = new String[] {""} ;
      P002A2_A14SecUserName = new String[] {""} ;
      AV49SecUserEstadoRDescription = "" ;
      AV33Session = httpContext.getWebSession();
      AV24GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secuserwwexportreport__default(),
         new Object[] {
             new Object[] {
            P002A2_A6SecUserId, P002A2_A211SecUserEstadoR, P002A2_A122SecUserEmail, P002A2_A15SecUserPassword, P002A2_A14SecUserName
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV62Pgmname = "WWPBaseObjects.SecUserWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV62Pgmname = "WWPBaseObjects.SecUserWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV28TFSecUserId ;
   private short AV29TFSecUserId_To ;
   private short A6SecUserId ;
   private short AV68Wwpbaseobjects_secuserwwds_2_tfsecuserid ;
   private short AV69Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ;
   private short AV10OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV65GXV1 ;
   private int AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ;
   private int AV77GXV2 ;
   private long AV59i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV62Pgmname ;
   private String AV57TFSecUserEstadoR_Sel ;
   private String A211SecUserEstadoR ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV11OrderedDsc ;
   private String AV54TFSecUserEstadoR_SelsJson ;
   private String AV46Title ;
   private String AV48FilterFullText ;
   private String AV35TFSecUserId_To_Description ;
   private String AV31TFSecUserName_Sel ;
   private String AV30TFSecUserName ;
   private String AV51TFSecUserPassword_Sel ;
   private String AV50TFSecUserPassword ;
   private String AV53TFSecUserEmail_Sel ;
   private String AV52TFSecUserEmail ;
   private String AV55TFSecUserEstadoR_SelDscs ;
   private String AV58FilterTFSecUserEstadoR_SelValueDescription ;
   private String A14SecUserName ;
   private String A15SecUserPassword ;
   private String A122SecUserEmail ;
   private String AV67Wwpbaseobjects_secuserwwds_1_filterfulltext ;
   private String AV70Wwpbaseobjects_secuserwwds_4_tfsecusername ;
   private String AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ;
   private String AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ;
   private String AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ;
   private String AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail ;
   private String AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ;
   private String lV67Wwpbaseobjects_secuserwwds_1_filterfulltext ;
   private String lV70Wwpbaseobjects_secuserwwds_4_tfsecusername ;
   private String lV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ;
   private String lV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail ;
   private String AV49SecUserEstadoRDescription ;
   private String AV44PageInfo ;
   private String AV41DateInfo ;
   private String AV39AppName ;
   private String AV45Phone ;
   private String AV43Mail ;
   private String AV47Website ;
   private String AV36AddressLine1 ;
   private String AV37AddressLine2 ;
   private String AV38AddressLine3 ;
   private com.genexus.webpanels.WebSession AV33Session ;
   private IDataStoreProvider pr_default ;
   private short[] P002A2_A6SecUserId ;
   private String[] P002A2_A211SecUserEstadoR ;
   private String[] P002A2_A122SecUserEmail ;
   private String[] P002A2_A15SecUserPassword ;
   private String[] P002A2_A14SecUserName ;
   private GXSimpleCollection<String> AV56TFSecUserEstadoR_Sels ;
   private GXSimpleCollection<String> AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV32WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class secuserwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002A2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A211SecUserEstadoR ,
                                          GXSimpleCollection<String> AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                          String AV67Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                          short AV68Wwpbaseobjects_secuserwwds_2_tfsecuserid ,
                                          short AV69Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ,
                                          String AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                          String AV70Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                          String AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                          String AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                          String AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                          String AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                          int AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          String A15SecUserPassword ,
                                          String A122SecUserEmail ,
                                          short AV10OrderedBy ,
                                          boolean AV11OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [SecUserId], [SecUserEstadoR], [SecUserEmail], [SecUserPassword], [SecUserName] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV67Wwpbaseobjects_secuserwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([SecUserId] AS decimal(4,0))) like '%' + ?) or ( [SecUserName] like '%' + ?) or ( [SecUserPassword] like '%' + ?) or ( [SecUserEmail] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [SecUserEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [SecUserEstadoR] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV68Wwpbaseobjects_secuserwwds_2_tfsecuserid) )
      {
         addWhere(sWhereString, "([SecUserId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV69Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) )
      {
         addWhere(sWhereString, "([SecUserId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV70Wwpbaseobjects_secuserwwds_4_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "([SecUserName] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserName] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) && ( ! (GXutil.strcmp("", AV72Wwpbaseobjects_secuserwwds_6_tfsecuserpassword)==0) ) )
      {
         addWhere(sWhereString, "([SecUserPassword] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserPassword] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) && ( ! (GXutil.strcmp("", AV74Wwpbaseobjects_secuserwwds_8_tfsecuseremail)==0) ) )
      {
         addWhere(sWhereString, "([SecUserEmail] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserEmail] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV76Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels, "[SecUserEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV10OrderedBy == 1 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserName]" ;
      }
      else if ( ( AV10OrderedBy == 1 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserName] DESC" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserId]" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserId] DESC" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserPassword]" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserPassword] DESC" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserEmail]" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserEmail] DESC" ;
      }
      else if ( ( AV10OrderedBy == 5 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserEstadoR]" ;
      }
      else if ( ( AV10OrderedBy == 5 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserEstadoR] DESC" ;
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
                  return conditional_P002A2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002A2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
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

