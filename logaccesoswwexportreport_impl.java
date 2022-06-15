package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class logaccesoswwexportreport_impl extends GXWebReport
{
   public logaccesoswwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos", GXv_boolean2) ;
         logaccesoswwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV53Title = "Lista de Log Accesos" ;
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
         h480( true, 0) ;
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
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV19TFLogAccesosId) && (0==AV20TFLogAccesosId_To) ) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Log Id", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFLogAccesosId), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV37TFLogAccesosId_To_Description = GXutil.format( "%1 (%2)", "Log Id", "Hasta", "", "", "", "", "", "", "") ;
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37TFLogAccesosId_To_Description, "")), 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFLogAccesosId_To), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV21TFSecUserId) && (0==AV22TFSecUserId_To) ) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("User Id", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFSecUserId), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV38TFSecUserId_To_Description = GXutil.format( "%1 (%2)", "User Id", "Hasta", "", "", "", "", "", "", "") ;
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFSecUserId_To_Description, "")), 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFSecUserId_To), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV24TFSecUserName_Sel)==0) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("User Name", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFSecUserName_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFSecUserName)==0) )
         {
            h480( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("User Name", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFSecUserName, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV25TFSecRoleId) && (0==AV26TFSecRoleId_To) ) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Role Id", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV25TFSecRoleId), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV39TFSecRoleId_To_Description = GXutil.format( "%1 (%2)", "Role Id", "Hasta", "", "", "", "", "", "", "") ;
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39TFSecRoleId_To_Description, "")), 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV26TFSecRoleId_To), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV28TFSecRoleDescription_Sel)==0) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Role Description", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFSecRoleDescription_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV27TFSecRoleDescription)==0) )
         {
            h480( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Role Description", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFSecRoleDescription, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV30TFLogAccesosFullName_Sel)==0) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombres Completos", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFLogAccesosFullName_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFLogAccesosFullName)==0) )
         {
            h480( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombres Completos", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFLogAccesosFullName, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV33TFLogAccesosTipo_Sels.fromJSonString(AV31TFLogAccesosTipo_SelsJson, null);
      if ( ! ( AV33TFLogAccesosTipo_Sels.size() == 0 ) )
      {
         AV42i = 1 ;
         AV60GXV1 = 1 ;
         while ( AV60GXV1 <= AV33TFLogAccesosTipo_Sels.size() )
         {
            AV34TFLogAccesosTipo_Sel = (String)AV33TFLogAccesosTipo_Sels.elementAt(-1+AV60GXV1) ;
            if ( AV42i == 1 )
            {
               AV32TFLogAccesosTipo_SelDscs = "" ;
            }
            else
            {
               AV32TFLogAccesosTipo_SelDscs += ", " ;
            }
            AV40FilterTFLogAccesosTipo_SelValueDescription = com.projectthani.gxdomaintipoacceso.getDescription(httpContext,(String)AV34TFLogAccesosTipo_Sel) ;
            AV32TFLogAccesosTipo_SelDscs += AV40FilterTFLogAccesosTipo_SelValueDescription ;
            AV42i = (long)(AV42i+1) ;
            AV60GXV1 = (int)(AV60GXV1+1) ;
         }
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFLogAccesosTipo_SelDscs, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV35TFLogAccesosFecha) && GXutil.dateCompare(GXutil.nullDate(), AV36TFLogAccesosFecha_To) ) )
      {
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV35TFLogAccesosFecha, "99/99/99 99:99"), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV41TFLogAccesosFecha_To_Description = GXutil.format( "%1 (%2)", "Fecha", "Hasta", "", "", "", "", "", "", "") ;
         h480( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFLogAccesosFecha_To_Description, "")), 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV36TFLogAccesosFecha_To, "99/99/99 99:99"), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h480( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h480( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Log Id", 30, Gx_line+10, 90, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("User Id", 94, Gx_line+10, 154, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("User Name", 158, Gx_line+10, 279, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Role Id", 283, Gx_line+10, 344, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Role Description", 348, Gx_line+10, 470, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombres Completos", 474, Gx_line+10, 596, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo", 600, Gx_line+10, 722, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha", 726, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV62Logaccesoswwds_1_filterfulltext = AV13FilterFullText ;
      AV63Logaccesoswwds_2_tflogaccesosid = AV19TFLogAccesosId ;
      AV64Logaccesoswwds_3_tflogaccesosid_to = AV20TFLogAccesosId_To ;
      AV65Logaccesoswwds_4_tfsecuserid = AV21TFSecUserId ;
      AV66Logaccesoswwds_5_tfsecuserid_to = AV22TFSecUserId_To ;
      AV67Logaccesoswwds_6_tfsecusername = AV23TFSecUserName ;
      AV68Logaccesoswwds_7_tfsecusername_sel = AV24TFSecUserName_Sel ;
      AV69Logaccesoswwds_8_tfsecroleid = AV25TFSecRoleId ;
      AV70Logaccesoswwds_9_tfsecroleid_to = AV26TFSecRoleId_To ;
      AV71Logaccesoswwds_10_tfsecroledescription = AV27TFSecRoleDescription ;
      AV72Logaccesoswwds_11_tfsecroledescription_sel = AV28TFSecRoleDescription_Sel ;
      AV73Logaccesoswwds_12_tflogaccesosfullname = AV29TFLogAccesosFullName ;
      AV74Logaccesoswwds_13_tflogaccesosfullname_sel = AV30TFLogAccesosFullName_Sel ;
      AV75Logaccesoswwds_14_tflogaccesostipo_sels = AV33TFLogAccesosTipo_Sels ;
      AV76Logaccesoswwds_15_tflogaccesosfecha = AV35TFLogAccesosFecha ;
      AV77Logaccesoswwds_16_tflogaccesosfecha_to = AV36TFLogAccesosFecha_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A227LogAccesosTipo ,
                                           AV75Logaccesoswwds_14_tflogaccesostipo_sels ,
                                           Short.valueOf(AV63Logaccesoswwds_2_tflogaccesosid) ,
                                           Short.valueOf(AV64Logaccesoswwds_3_tflogaccesosid_to) ,
                                           Short.valueOf(AV65Logaccesoswwds_4_tfsecuserid) ,
                                           Short.valueOf(AV66Logaccesoswwds_5_tfsecuserid_to) ,
                                           AV68Logaccesoswwds_7_tfsecusername_sel ,
                                           AV67Logaccesoswwds_6_tfsecusername ,
                                           Short.valueOf(AV69Logaccesoswwds_8_tfsecroleid) ,
                                           Short.valueOf(AV70Logaccesoswwds_9_tfsecroleid_to) ,
                                           AV72Logaccesoswwds_11_tfsecroledescription_sel ,
                                           AV71Logaccesoswwds_10_tfsecroledescription ,
                                           Integer.valueOf(AV75Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                           AV76Logaccesoswwds_15_tflogaccesosfecha ,
                                           AV77Logaccesoswwds_16_tflogaccesosfecha_to ,
                                           Short.valueOf(A41LogAccesosId) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           Short.valueOf(A4SecRoleId) ,
                                           A12SecRoleDescription ,
                                           A228LogAccesosFecha ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV62Logaccesoswwds_1_filterfulltext ,
                                           A172LogAccesosFullName ,
                                           AV74Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                           AV73Logaccesoswwds_12_tflogaccesosfullname } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV67Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV67Logaccesoswwds_6_tfsecusername), "%", "") ;
      lV71Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV71Logaccesoswwds_10_tfsecroledescription), "%", "") ;
      /* Using cursor P00482 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV63Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV64Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV65Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV66Logaccesoswwds_5_tfsecuserid_to), lV67Logaccesoswwds_6_tfsecusername, AV68Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV69Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV70Logaccesoswwds_9_tfsecroleid_to), lV71Logaccesoswwds_10_tfsecroledescription, AV72Logaccesoswwds_11_tfsecroledescription_sel, AV76Logaccesoswwds_15_tflogaccesosfecha, AV77Logaccesoswwds_16_tflogaccesosfecha_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A228LogAccesosFecha = P00482_A228LogAccesosFecha[0] ;
         A6SecUserId = P00482_A6SecUserId[0] ;
         A41LogAccesosId = P00482_A41LogAccesosId[0] ;
         A227LogAccesosTipo = P00482_A227LogAccesosTipo[0] ;
         A12SecRoleDescription = P00482_A12SecRoleDescription[0] ;
         A14SecUserName = P00482_A14SecUserName[0] ;
         A4SecRoleId = P00482_A4SecRoleId[0] ;
         A14SecUserName = P00482_A14SecUserName[0] ;
         A12SecRoleDescription = P00482_A12SecRoleDescription[0] ;
         GXt_char4 = A172LogAccesosFullName ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
         logaccesoswwexportreport_impl.this.GXt_char4 = GXv_char5[0] ;
         A172LogAccesosFullName = GXt_char4 ;
         if ( (GXutil.strcmp("", AV62Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV62Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV62Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV62Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV62Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV62Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV62Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV62Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV62Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
         {
            if ( ! ( (GXutil.strcmp("", AV74Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV73Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV73Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
            {
               if ( (GXutil.strcmp("", AV74Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV74Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
               {
                  AV14LogAccesosTipoDescription = com.projectthani.gxdomaintipoacceso.getDescription(httpContext,(String)A227LogAccesosTipo) ;
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
                  h480( false, 36) ;
                  getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
                  getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9")), 30, Gx_line+10, 90, Gx_line+25, 2, 0, 0, 0) ;
                  getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9")), 94, Gx_line+10, 154, Gx_line+25, 2, 0, 0, 0) ;
                  getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A14SecUserName, "")), 158, Gx_line+10, 279, Gx_line+25, 0, 0, 0, 0) ;
                  getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9")), 283, Gx_line+10, 344, Gx_line+25, 2, 0, 0, 0) ;
                  getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A12SecRoleDescription, "")), 348, Gx_line+10, 470, Gx_line+25, 0, 0, 0, 0) ;
                  getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A172LogAccesosFullName, "")), 474, Gx_line+10, 596, Gx_line+25, 0, 0, 0, 0) ;
                  getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14LogAccesosTipoDescription, "")), 600, Gx_line+10, 722, Gx_line+25, 0, 0, 0, 0) ;
                  getPrinter().GxDrawText(localUtil.format( A228LogAccesosFecha, "99/99/99 99:99"), 726, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
                  getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
                  Gx_OldLine = Gx_line ;
                  Gx_line = (int)(Gx_line+36) ;
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
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV15Session.getValue("LogAccesosWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LogAccesosWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("LogAccesosWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV78GXV2 = 1 ;
      while ( AV78GXV2 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV78GXV2));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSID") == 0 )
         {
            AV19TFLogAccesosId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFLogAccesosId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV21TFSecUserId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFSecUserId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV23TFSecUserName = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV24TFSecUserName_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEID") == 0 )
         {
            AV25TFSecRoleId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFSecRoleId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV27TFSecRoleDescription = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV28TFSecRoleDescription_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME") == 0 )
         {
            AV29TFLogAccesosFullName = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME_SEL") == 0 )
         {
            AV30TFLogAccesosFullName_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSTIPO_SEL") == 0 )
         {
            AV31TFLogAccesosTipo_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV33TFLogAccesosTipo_Sels.fromJSonString(AV31TFLogAccesosTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFECHA") == 0 )
         {
            AV35TFLogAccesosFecha = localUtil.ctot( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV36TFLogAccesosFecha_To = localUtil.ctot( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         AV78GXV2 = (int)(AV78GXV2+1) ;
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

   public void h480( boolean bFoot ,
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
      AV37TFLogAccesosId_To_Description = "" ;
      AV38TFSecUserId_To_Description = "" ;
      AV24TFSecUserName_Sel = "" ;
      AV23TFSecUserName = "" ;
      AV39TFSecRoleId_To_Description = "" ;
      AV28TFSecRoleDescription_Sel = "" ;
      AV27TFSecRoleDescription = "" ;
      AV30TFLogAccesosFullName_Sel = "" ;
      AV29TFLogAccesosFullName = "" ;
      AV33TFLogAccesosTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFLogAccesosTipo_SelsJson = "" ;
      AV34TFLogAccesosTipo_Sel = "" ;
      AV32TFLogAccesosTipo_SelDscs = "" ;
      AV40FilterTFLogAccesosTipo_SelValueDescription = "" ;
      AV35TFLogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      AV36TFLogAccesosFecha_To = GXutil.resetTime( GXutil.nullDate() );
      AV41TFLogAccesosFecha_To_Description = "" ;
      A227LogAccesosTipo = "" ;
      A14SecUserName = "" ;
      A12SecRoleDescription = "" ;
      A172LogAccesosFullName = "" ;
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      AV62Logaccesoswwds_1_filterfulltext = "" ;
      AV67Logaccesoswwds_6_tfsecusername = "" ;
      AV68Logaccesoswwds_7_tfsecusername_sel = "" ;
      AV71Logaccesoswwds_10_tfsecroledescription = "" ;
      AV72Logaccesoswwds_11_tfsecroledescription_sel = "" ;
      AV73Logaccesoswwds_12_tflogaccesosfullname = "" ;
      AV74Logaccesoswwds_13_tflogaccesosfullname_sel = "" ;
      AV75Logaccesoswwds_14_tflogaccesostipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Logaccesoswwds_15_tflogaccesosfecha = GXutil.resetTime( GXutil.nullDate() );
      AV77Logaccesoswwds_16_tflogaccesosfecha_to = GXutil.resetTime( GXutil.nullDate() );
      lV62Logaccesoswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV67Logaccesoswwds_6_tfsecusername = "" ;
      lV71Logaccesoswwds_10_tfsecroledescription = "" ;
      P00482_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00482_A6SecUserId = new short[1] ;
      P00482_A41LogAccesosId = new short[1] ;
      P00482_A227LogAccesosTipo = new String[] {""} ;
      P00482_A12SecRoleDescription = new String[] {""} ;
      P00482_A14SecUserName = new String[] {""} ;
      P00482_A4SecRoleId = new short[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV14LogAccesosTipoDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesoswwexportreport__default(),
         new Object[] {
             new Object[] {
            P00482_A228LogAccesosFecha, P00482_A6SecUserId, P00482_A41LogAccesosId, P00482_A227LogAccesosTipo, P00482_A12SecRoleDescription, P00482_A14SecUserName, P00482_A4SecRoleId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV57Pgmname = "LogAccesosWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV57Pgmname = "LogAccesosWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV19TFLogAccesosId ;
   private short AV20TFLogAccesosId_To ;
   private short AV21TFSecUserId ;
   private short AV22TFSecUserId_To ;
   private short AV25TFSecRoleId ;
   private short AV26TFSecRoleId_To ;
   private short A41LogAccesosId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV63Logaccesoswwds_2_tflogaccesosid ;
   private short AV64Logaccesoswwds_3_tflogaccesosid_to ;
   private short AV65Logaccesoswwds_4_tfsecuserid ;
   private short AV66Logaccesoswwds_5_tfsecuserid_to ;
   private short AV69Logaccesoswwds_8_tfsecroleid ;
   private short AV70Logaccesoswwds_9_tfsecroleid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV60GXV1 ;
   private int AV75Logaccesoswwds_14_tflogaccesostipo_sels_size ;
   private int AV78GXV2 ;
   private long AV42i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV57Pgmname ;
   private String AV34TFLogAccesosTipo_Sel ;
   private String A227LogAccesosTipo ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date AV35TFLogAccesosFecha ;
   private java.util.Date AV36TFLogAccesosFecha_To ;
   private java.util.Date A228LogAccesosFecha ;
   private java.util.Date AV76Logaccesoswwds_15_tflogaccesosfecha ;
   private java.util.Date AV77Logaccesoswwds_16_tflogaccesosfecha_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV31TFLogAccesosTipo_SelsJson ;
   private String AV53Title ;
   private String AV13FilterFullText ;
   private String AV37TFLogAccesosId_To_Description ;
   private String AV38TFSecUserId_To_Description ;
   private String AV24TFSecUserName_Sel ;
   private String AV23TFSecUserName ;
   private String AV39TFSecRoleId_To_Description ;
   private String AV28TFSecRoleDescription_Sel ;
   private String AV27TFSecRoleDescription ;
   private String AV30TFLogAccesosFullName_Sel ;
   private String AV29TFLogAccesosFullName ;
   private String AV32TFLogAccesosTipo_SelDscs ;
   private String AV40FilterTFLogAccesosTipo_SelValueDescription ;
   private String AV41TFLogAccesosFecha_To_Description ;
   private String A14SecUserName ;
   private String A12SecRoleDescription ;
   private String A172LogAccesosFullName ;
   private String AV62Logaccesoswwds_1_filterfulltext ;
   private String AV67Logaccesoswwds_6_tfsecusername ;
   private String AV68Logaccesoswwds_7_tfsecusername_sel ;
   private String AV71Logaccesoswwds_10_tfsecroledescription ;
   private String AV72Logaccesoswwds_11_tfsecroledescription_sel ;
   private String AV73Logaccesoswwds_12_tflogaccesosfullname ;
   private String AV74Logaccesoswwds_13_tflogaccesosfullname_sel ;
   private String lV62Logaccesoswwds_1_filterfulltext ;
   private String lV67Logaccesoswwds_6_tfsecusername ;
   private String lV71Logaccesoswwds_10_tfsecroledescription ;
   private String AV14LogAccesosTipoDescription ;
   private String AV51PageInfo ;
   private String AV48DateInfo ;
   private String AV46AppName ;
   private String AV52Phone ;
   private String AV50Mail ;
   private String AV54Website ;
   private String AV43AddressLine1 ;
   private String AV44AddressLine2 ;
   private String AV45AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00482_A228LogAccesosFecha ;
   private short[] P00482_A6SecUserId ;
   private short[] P00482_A41LogAccesosId ;
   private String[] P00482_A227LogAccesosTipo ;
   private String[] P00482_A12SecRoleDescription ;
   private String[] P00482_A14SecUserName ;
   private short[] P00482_A4SecRoleId ;
   private GXSimpleCollection<String> AV33TFLogAccesosTipo_Sels ;
   private GXSimpleCollection<String> AV75Logaccesoswwds_14_tflogaccesostipo_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class logaccesoswwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00482( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV75Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV63Logaccesoswwds_2_tflogaccesosid ,
                                          short AV64Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV65Logaccesoswwds_4_tfsecuserid ,
                                          short AV66Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV68Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV67Logaccesoswwds_6_tfsecusername ,
                                          short AV69Logaccesoswwds_8_tfsecroleid ,
                                          short AV70Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV72Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV71Logaccesoswwds_10_tfsecroledescription ,
                                          int AV75Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV76Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV77Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV62Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV74Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV73Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[12];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.[LogAccesosFecha], T1.[SecUserId], T1.[LogAccesosId], T1.[LogAccesosTipo], T3.[SecRoleDescription], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV63Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      if ( ! (0==AV64Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      if ( ! (0==AV65Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      if ( ! (0==AV66Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV67Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( ! (0==AV69Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      if ( ! (0==AV70Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int6[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV71Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int6[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int6[9] = (byte)(1) ;
      }
      if ( AV75Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV75Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV76Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV77Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SecUserName]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SecUserName] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha] DESC" ;
      }
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P00482(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00482", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
      }
   }

}

