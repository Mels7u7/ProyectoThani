package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ubigeowwexportreport_impl extends GXWebReport
{
   public ubigeowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean2) ;
         ubigeowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55Pgmname))}, new String[] {"GxObject"}) );
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
            AV51Title = "Lista de Ubigeo" ;
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
         h560( true, 0) ;
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
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV20TFUbigeoCode_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20TFUbigeoCode_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV19TFUbigeoCode)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19TFUbigeoCode, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV22TFUbigeoDepartamento_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Departamento", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFUbigeoDepartamento_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFUbigeoDepartamento)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Departamento", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFUbigeoDepartamento, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV24TFUbigeoDepartamentoCode_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Departamento Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFUbigeoDepartamentoCode_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFUbigeoDepartamentoCode)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Departamento Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFUbigeoDepartamentoCode, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV26TFUbigeoProvincia_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Provincia", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFUbigeoProvincia_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV25TFUbigeoProvincia)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Provincia", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFUbigeoProvincia, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV28TFUbigeoProvinciaCode_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Provincia Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFUbigeoProvinciaCode_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV27TFUbigeoProvinciaCode)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Provincia Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFUbigeoProvinciaCode, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV30TFUbigeoDistrito_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Distrito", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFUbigeoDistrito_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFUbigeoDistrito)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Distrito", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFUbigeoDistrito, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV32TFUbigeoDistritoCode_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Distrito Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFUbigeoDistritoCode_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFUbigeoDistritoCode)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Distrito Code", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFUbigeoDistritoCode, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV34TFUbigeoNombre_Sel)==0) )
      {
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFUbigeoNombre_Sel, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV33TFUbigeoNombre)==0) )
         {
            h560( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFUbigeoNombre, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV37TFUbigeoEstado_Sels.fromJSonString(AV35TFUbigeoEstado_SelsJson, null);
      if ( ! ( AV37TFUbigeoEstado_Sels.size() == 0 ) )
      {
         AV40i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV37TFUbigeoEstado_Sels.size() )
         {
            AV38TFUbigeoEstado_Sel = (String)AV37TFUbigeoEstado_Sels.elementAt(-1+AV58GXV1) ;
            if ( AV40i == 1 )
            {
               AV36TFUbigeoEstado_SelDscs = "" ;
            }
            else
            {
               AV36TFUbigeoEstado_SelDscs += ", " ;
            }
            AV39FilterTFUbigeoEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV38TFUbigeoEstado_Sel) ;
            AV36TFUbigeoEstado_SelDscs += AV39FilterTFUbigeoEstado_SelValueDescription ;
            AV40i = (long)(AV40i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
         h560( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 131, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36TFUbigeoEstado_SelDscs, "")), 131, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h560( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h560( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Code", 30, Gx_line+10, 81, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Departamento", 85, Gx_line+10, 187, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Departamento Code", 191, Gx_line+10, 243, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Provincia", 247, Gx_line+10, 351, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Provincia Code", 355, Gx_line+10, 407, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Distrito", 411, Gx_line+10, 515, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Distrito Code", 519, Gx_line+10, 571, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo", 575, Gx_line+10, 679, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 683, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV60Ubigeowwds_1_filterfulltext = AV13FilterFullText ;
      AV61Ubigeowwds_2_tfubigeocode = AV19TFUbigeoCode ;
      AV62Ubigeowwds_3_tfubigeocode_sel = AV20TFUbigeoCode_Sel ;
      AV63Ubigeowwds_4_tfubigeodepartamento = AV21TFUbigeoDepartamento ;
      AV64Ubigeowwds_5_tfubigeodepartamento_sel = AV22TFUbigeoDepartamento_Sel ;
      AV65Ubigeowwds_6_tfubigeodepartamentocode = AV23TFUbigeoDepartamentoCode ;
      AV66Ubigeowwds_7_tfubigeodepartamentocode_sel = AV24TFUbigeoDepartamentoCode_Sel ;
      AV67Ubigeowwds_8_tfubigeoprovincia = AV25TFUbigeoProvincia ;
      AV68Ubigeowwds_9_tfubigeoprovincia_sel = AV26TFUbigeoProvincia_Sel ;
      AV69Ubigeowwds_10_tfubigeoprovinciacode = AV27TFUbigeoProvinciaCode ;
      AV70Ubigeowwds_11_tfubigeoprovinciacode_sel = AV28TFUbigeoProvinciaCode_Sel ;
      AV71Ubigeowwds_12_tfubigeodistrito = AV29TFUbigeoDistrito ;
      AV72Ubigeowwds_13_tfubigeodistrito_sel = AV30TFUbigeoDistrito_Sel ;
      AV73Ubigeowwds_14_tfubigeodistritocode = AV31TFUbigeoDistritoCode ;
      AV74Ubigeowwds_15_tfubigeodistritocode_sel = AV32TFUbigeoDistritoCode_Sel ;
      AV75Ubigeowwds_16_tfubigeonombre = AV33TFUbigeoNombre ;
      AV76Ubigeowwds_17_tfubigeonombre_sel = AV34TFUbigeoNombre_Sel ;
      AV77Ubigeowwds_18_tfubigeoestado_sels = AV37TFUbigeoEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV77Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV60Ubigeowwds_1_filterfulltext ,
                                           AV62Ubigeowwds_3_tfubigeocode_sel ,
                                           AV61Ubigeowwds_2_tfubigeocode ,
                                           AV64Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV63Ubigeowwds_4_tfubigeodepartamento ,
                                           AV66Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV65Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV68Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV67Ubigeowwds_8_tfubigeoprovincia ,
                                           AV70Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV69Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV72Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV71Ubigeowwds_12_tfubigeodistrito ,
                                           AV74Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV73Ubigeowwds_14_tfubigeodistritocode ,
                                           AV76Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV75Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV77Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV60Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV61Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV63Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV65Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV67Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV69Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV69Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV71Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV71Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV73Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV73Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV75Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV75Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P00562 */
      pr_default.execute(0, new Object[] {lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV60Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_2_tfubigeocode, AV62Ubigeowwds_3_tfubigeocode_sel, lV63Ubigeowwds_4_tfubigeodepartamento, AV64Ubigeowwds_5_tfubigeodepartamento_sel, lV65Ubigeowwds_6_tfubigeodepartamentocode, AV66Ubigeowwds_7_tfubigeodepartamentocode_sel, lV67Ubigeowwds_8_tfubigeoprovincia, AV68Ubigeowwds_9_tfubigeoprovincia_sel, lV69Ubigeowwds_10_tfubigeoprovinciacode, AV70Ubigeowwds_11_tfubigeoprovinciacode_sel, lV71Ubigeowwds_12_tfubigeodistrito, AV72Ubigeowwds_13_tfubigeodistrito_sel, lV73Ubigeowwds_14_tfubigeodistritocode, AV74Ubigeowwds_15_tfubigeodistritocode_sel, lV75Ubigeowwds_16_tfubigeonombre, AV76Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A294UbigeoEstado = P00562_A294UbigeoEstado[0] ;
         A44UbigeoCode = P00562_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P00562_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P00562_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P00562_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         AV14UbigeoEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A294UbigeoEstado) ;
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
         h560( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), 30, Gx_line+10, 81, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A186UbigeoDepartamento, "")), 85, Gx_line+10, 187, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A295UbigeoDepartamentoCode, "")), 191, Gx_line+10, 243, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A187UbigeoProvincia, "")), 247, Gx_line+10, 351, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A296UbigeoProvinciaCode, "")), 355, Gx_line+10, 407, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A188UbigeoDistrito, "")), 411, Gx_line+10, 515, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A297UbigeoDistritoCode, "")), 519, Gx_line+10, 571, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), 575, Gx_line+10, 679, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14UbigeoEstadoDescription, "")), 683, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV15Session.getValue("UbigeoWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "UbigeoWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("UbigeoWWGridState"), null, null);
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
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV19TFUbigeoCode = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV20TFUbigeoCode_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO") == 0 )
         {
            AV21TFUbigeoDepartamento = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO_SEL") == 0 )
         {
            AV22TFUbigeoDepartamento_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE") == 0 )
         {
            AV23TFUbigeoDepartamentoCode = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE_SEL") == 0 )
         {
            AV24TFUbigeoDepartamentoCode_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA") == 0 )
         {
            AV25TFUbigeoProvincia = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA_SEL") == 0 )
         {
            AV26TFUbigeoProvincia_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE") == 0 )
         {
            AV27TFUbigeoProvinciaCode = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE_SEL") == 0 )
         {
            AV28TFUbigeoProvinciaCode_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO") == 0 )
         {
            AV29TFUbigeoDistrito = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO_SEL") == 0 )
         {
            AV30TFUbigeoDistrito_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE") == 0 )
         {
            AV31TFUbigeoDistritoCode = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE_SEL") == 0 )
         {
            AV32TFUbigeoDistritoCode_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV33TFUbigeoNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV34TFUbigeoNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOESTADO_SEL") == 0 )
         {
            AV35TFUbigeoEstado_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFUbigeoEstado_Sels.fromJSonString(AV35TFUbigeoEstado_SelsJson, null);
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

   public void h560( boolean bFoot ,
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
               AV49PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV46DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV44AppName = "DVelop Software Solutions" ;
            AV50Phone = "+1 550 8923" ;
            AV48Mail = "info@mail.com" ;
            AV52Website = "http://www.web.com" ;
            AV41AddressLine1 = "French Boulevard 2859" ;
            AV42AddressLine2 = "Downtown" ;
            AV43AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV55Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV51Title = "" ;
      AV13FilterFullText = "" ;
      AV20TFUbigeoCode_Sel = "" ;
      AV19TFUbigeoCode = "" ;
      AV22TFUbigeoDepartamento_Sel = "" ;
      AV21TFUbigeoDepartamento = "" ;
      AV24TFUbigeoDepartamentoCode_Sel = "" ;
      AV23TFUbigeoDepartamentoCode = "" ;
      AV26TFUbigeoProvincia_Sel = "" ;
      AV25TFUbigeoProvincia = "" ;
      AV28TFUbigeoProvinciaCode_Sel = "" ;
      AV27TFUbigeoProvinciaCode = "" ;
      AV30TFUbigeoDistrito_Sel = "" ;
      AV29TFUbigeoDistrito = "" ;
      AV32TFUbigeoDistritoCode_Sel = "" ;
      AV31TFUbigeoDistritoCode = "" ;
      AV34TFUbigeoNombre_Sel = "" ;
      AV33TFUbigeoNombre = "" ;
      AV37TFUbigeoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFUbigeoEstado_SelsJson = "" ;
      AV38TFUbigeoEstado_Sel = "" ;
      AV36TFUbigeoEstado_SelDscs = "" ;
      AV39FilterTFUbigeoEstado_SelValueDescription = "" ;
      A294UbigeoEstado = "" ;
      A44UbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A187UbigeoProvincia = "" ;
      A296UbigeoProvinciaCode = "" ;
      A188UbigeoDistrito = "" ;
      A297UbigeoDistritoCode = "" ;
      A185UbigeoNombre = "" ;
      AV60Ubigeowwds_1_filterfulltext = "" ;
      AV61Ubigeowwds_2_tfubigeocode = "" ;
      AV62Ubigeowwds_3_tfubigeocode_sel = "" ;
      AV63Ubigeowwds_4_tfubigeodepartamento = "" ;
      AV64Ubigeowwds_5_tfubigeodepartamento_sel = "" ;
      AV65Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      AV66Ubigeowwds_7_tfubigeodepartamentocode_sel = "" ;
      AV67Ubigeowwds_8_tfubigeoprovincia = "" ;
      AV68Ubigeowwds_9_tfubigeoprovincia_sel = "" ;
      AV69Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      AV70Ubigeowwds_11_tfubigeoprovinciacode_sel = "" ;
      AV71Ubigeowwds_12_tfubigeodistrito = "" ;
      AV72Ubigeowwds_13_tfubigeodistrito_sel = "" ;
      AV73Ubigeowwds_14_tfubigeodistritocode = "" ;
      AV74Ubigeowwds_15_tfubigeodistritocode_sel = "" ;
      AV75Ubigeowwds_16_tfubigeonombre = "" ;
      AV76Ubigeowwds_17_tfubigeonombre_sel = "" ;
      AV77Ubigeowwds_18_tfubigeoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV60Ubigeowwds_1_filterfulltext = "" ;
      lV61Ubigeowwds_2_tfubigeocode = "" ;
      lV63Ubigeowwds_4_tfubigeodepartamento = "" ;
      lV65Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      lV67Ubigeowwds_8_tfubigeoprovincia = "" ;
      lV69Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      lV71Ubigeowwds_12_tfubigeodistrito = "" ;
      lV73Ubigeowwds_14_tfubigeodistritocode = "" ;
      lV75Ubigeowwds_16_tfubigeonombre = "" ;
      P00562_A294UbigeoEstado = new String[] {""} ;
      P00562_A44UbigeoCode = new String[] {""} ;
      P00562_A188UbigeoDistrito = new String[] {""} ;
      P00562_A187UbigeoProvincia = new String[] {""} ;
      P00562_A186UbigeoDepartamento = new String[] {""} ;
      AV14UbigeoEstadoDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV49PageInfo = "" ;
      AV46DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV44AppName = "" ;
      AV50Phone = "" ;
      AV48Mail = "" ;
      AV52Website = "" ;
      AV41AddressLine1 = "" ;
      AV42AddressLine2 = "" ;
      AV43AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ubigeowwexportreport__default(),
         new Object[] {
             new Object[] {
            P00562_A294UbigeoEstado, P00562_A44UbigeoCode, P00562_A188UbigeoDistrito, P00562_A187UbigeoProvincia, P00562_A186UbigeoDepartamento
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV55Pgmname = "UbigeoWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV55Pgmname = "UbigeoWWExportReport" ;
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
   private int AV58GXV1 ;
   private int AV77Ubigeowwds_18_tfubigeoestado_sels_size ;
   private int AV78GXV2 ;
   private long AV40i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV55Pgmname ;
   private String AV20TFUbigeoCode_Sel ;
   private String AV19TFUbigeoCode ;
   private String AV38TFUbigeoEstado_Sel ;
   private String A294UbigeoEstado ;
   private String A44UbigeoCode ;
   private String AV61Ubigeowwds_2_tfubigeocode ;
   private String AV62Ubigeowwds_3_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV61Ubigeowwds_2_tfubigeocode ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV35TFUbigeoEstado_SelsJson ;
   private String AV51Title ;
   private String AV13FilterFullText ;
   private String AV22TFUbigeoDepartamento_Sel ;
   private String AV21TFUbigeoDepartamento ;
   private String AV24TFUbigeoDepartamentoCode_Sel ;
   private String AV23TFUbigeoDepartamentoCode ;
   private String AV26TFUbigeoProvincia_Sel ;
   private String AV25TFUbigeoProvincia ;
   private String AV28TFUbigeoProvinciaCode_Sel ;
   private String AV27TFUbigeoProvinciaCode ;
   private String AV30TFUbigeoDistrito_Sel ;
   private String AV29TFUbigeoDistrito ;
   private String AV32TFUbigeoDistritoCode_Sel ;
   private String AV31TFUbigeoDistritoCode ;
   private String AV34TFUbigeoNombre_Sel ;
   private String AV33TFUbigeoNombre ;
   private String AV36TFUbigeoEstado_SelDscs ;
   private String AV39FilterTFUbigeoEstado_SelValueDescription ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String A187UbigeoProvincia ;
   private String A296UbigeoProvinciaCode ;
   private String A188UbigeoDistrito ;
   private String A297UbigeoDistritoCode ;
   private String A185UbigeoNombre ;
   private String AV60Ubigeowwds_1_filterfulltext ;
   private String AV63Ubigeowwds_4_tfubigeodepartamento ;
   private String AV64Ubigeowwds_5_tfubigeodepartamento_sel ;
   private String AV65Ubigeowwds_6_tfubigeodepartamentocode ;
   private String AV66Ubigeowwds_7_tfubigeodepartamentocode_sel ;
   private String AV67Ubigeowwds_8_tfubigeoprovincia ;
   private String AV68Ubigeowwds_9_tfubigeoprovincia_sel ;
   private String AV69Ubigeowwds_10_tfubigeoprovinciacode ;
   private String AV70Ubigeowwds_11_tfubigeoprovinciacode_sel ;
   private String AV71Ubigeowwds_12_tfubigeodistrito ;
   private String AV72Ubigeowwds_13_tfubigeodistrito_sel ;
   private String AV73Ubigeowwds_14_tfubigeodistritocode ;
   private String AV74Ubigeowwds_15_tfubigeodistritocode_sel ;
   private String AV75Ubigeowwds_16_tfubigeonombre ;
   private String AV76Ubigeowwds_17_tfubigeonombre_sel ;
   private String lV60Ubigeowwds_1_filterfulltext ;
   private String lV63Ubigeowwds_4_tfubigeodepartamento ;
   private String lV65Ubigeowwds_6_tfubigeodepartamentocode ;
   private String lV67Ubigeowwds_8_tfubigeoprovincia ;
   private String lV69Ubigeowwds_10_tfubigeoprovinciacode ;
   private String lV71Ubigeowwds_12_tfubigeodistrito ;
   private String lV73Ubigeowwds_14_tfubigeodistritocode ;
   private String lV75Ubigeowwds_16_tfubigeonombre ;
   private String AV14UbigeoEstadoDescription ;
   private String AV49PageInfo ;
   private String AV46DateInfo ;
   private String AV44AppName ;
   private String AV50Phone ;
   private String AV48Mail ;
   private String AV52Website ;
   private String AV41AddressLine1 ;
   private String AV42AddressLine2 ;
   private String AV43AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private String[] P00562_A294UbigeoEstado ;
   private String[] P00562_A44UbigeoCode ;
   private String[] P00562_A188UbigeoDistrito ;
   private String[] P00562_A187UbigeoProvincia ;
   private String[] P00562_A186UbigeoDepartamento ;
   private GXSimpleCollection<String> AV37TFUbigeoEstado_Sels ;
   private GXSimpleCollection<String> AV77Ubigeowwds_18_tfubigeoestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class ubigeowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00562( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV77Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV60Ubigeowwds_1_filterfulltext ,
                                          String AV62Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV61Ubigeowwds_2_tfubigeocode ,
                                          String AV64Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV63Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV66Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV65Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV68Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV67Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV70Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV69Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV72Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV71Ubigeowwds_12_tfubigeodistrito ,
                                          String AV74Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV73Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV76Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV75Ubigeowwds_16_tfubigeonombre ,
                                          int AV77Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[26];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
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
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV69Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV71Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV73Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV75Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( AV77Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV77Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoCode]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoDepartamento]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoDepartamento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoProvincia]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoProvincia] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoDistrito]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoDistrito] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoEstado]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoEstado] DESC" ;
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
                  return conditional_P00562(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00562", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
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
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
      }
   }

}

