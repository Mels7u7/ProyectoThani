package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clinicawwexportreport_impl extends GXWebReport
{
   public clinicawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica", GXv_boolean2) ;
         clinicawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV77Pgmname))}, new String[] {"GxObject"}) );
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
            AV73Title = "Lista de Clinica" ;
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
         h8I0( true, 0) ;
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
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV21TFClinicaId) && (0==AV22TFClinicaId_To) ) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFClinicaId), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV57TFClinicaId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV57TFClinicaId_To_Description, "")), 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFClinicaId_To), "ZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV23TFClinicaRUC) && (0==AV24TFClinicaRUC_To) ) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("RUC", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV23TFClinicaRUC), "ZZZZZZZZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV58TFClinicaRUC_To_Description = GXutil.format( "%1 (%2)", "RUC", "Hasta", "", "", "", "", "", "", "") ;
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV58TFClinicaRUC_To_Description, "")), 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV24TFClinicaRUC_To), "ZZZZZZZZZZ9")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV26TFClinicaNombreComercial_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Comercial", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFClinicaNombreComercial_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV25TFClinicaNombreComercial)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Comercial", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFClinicaNombreComercial, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV28TFClinicaNombreAbreviado_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Abrev.", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFClinicaNombreAbreviado_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV27TFClinicaNombreAbreviado)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Abrev.", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFClinicaNombreAbreviado, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV30TFClinicaDireccionComercial_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Direccion Comercial", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFClinicaDireccionComercial_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFClinicaDireccionComercial)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Direccion Comercial", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFClinicaDireccionComercial, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV32TFClinicaCorreo_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Correo", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFClinicaCorreo_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFClinicaCorreo)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Correo", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFClinicaCorreo, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV35TFClinicaMoneda_Sels.fromJSonString(AV33TFClinicaMoneda_SelsJson, null);
      if ( ! ( AV35TFClinicaMoneda_Sels.size() == 0 ) )
      {
         AV62i = 1 ;
         AV80GXV1 = 1 ;
         while ( AV80GXV1 <= AV35TFClinicaMoneda_Sels.size() )
         {
            AV36TFClinicaMoneda_Sel = ((Number) AV35TFClinicaMoneda_Sels.elementAt(-1+AV80GXV1)).shortValue() ;
            if ( AV62i == 1 )
            {
               AV34TFClinicaMoneda_SelDscs = "" ;
            }
            else
            {
               AV34TFClinicaMoneda_SelDscs += ", " ;
            }
            AV59FilterTFClinicaMoneda_SelValueDescription = com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)AV36TFClinicaMoneda_Sel) ;
            AV34TFClinicaMoneda_SelDscs += AV59FilterTFClinicaMoneda_SelValueDescription ;
            AV62i = (long)(AV62i+1) ;
            AV80GXV1 = (int)(AV80GXV1+1) ;
         }
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Moneda", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFClinicaMoneda_SelDscs, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV38TFClinicaTelefono_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Telefono", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFClinicaTelefono_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV37TFClinicaTelefono)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Telefono", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37TFClinicaTelefono, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV40TFClinicaWhatsApp_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Whats App", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFClinicaWhatsApp_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV39TFClinicaWhatsApp)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Whats App", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39TFClinicaWhatsApp, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV42TFClinicaFacebook_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Facebook", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFClinicaFacebook_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV41TFClinicaFacebook)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Facebook", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFClinicaFacebook, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV44TFClinicaTwiter_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Twiter", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFClinicaTwiter_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV43TFClinicaTwiter)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Twiter", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFClinicaTwiter, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV46TFClinicaInstagram_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Instagram", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46TFClinicaInstagram_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV45TFClinicaInstagram)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Instagram", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45TFClinicaInstagram, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV48TFClinicaLinkedin_Sel)==0) )
      {
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Linkedin", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48TFClinicaLinkedin_Sel, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV47TFClinicaLinkedin)==0) )
         {
            h8I0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Linkedin", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47TFClinicaLinkedin, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV51TFClinicaTiempoDeCita_Sels.fromJSonString(AV49TFClinicaTiempoDeCita_SelsJson, null);
      if ( ! ( AV51TFClinicaTiempoDeCita_Sels.size() == 0 ) )
      {
         AV62i = 1 ;
         AV81GXV2 = 1 ;
         while ( AV81GXV2 <= AV51TFClinicaTiempoDeCita_Sels.size() )
         {
            AV52TFClinicaTiempoDeCita_Sel = ((Number) AV51TFClinicaTiempoDeCita_Sels.elementAt(-1+AV81GXV2)).byteValue() ;
            if ( AV62i == 1 )
            {
               AV50TFClinicaTiempoDeCita_SelDscs = "" ;
            }
            else
            {
               AV50TFClinicaTiempoDeCita_SelDscs += ", " ;
            }
            AV60FilterTFClinicaTiempoDeCita_SelValueDescription = com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)AV52TFClinicaTiempoDeCita_Sel) ;
            AV50TFClinicaTiempoDeCita_SelDscs += AV60FilterTFClinicaTiempoDeCita_SelValueDescription ;
            AV62i = (long)(AV62i+1) ;
            AV81GXV2 = (int)(AV81GXV2+1) ;
         }
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tiempo De Cita", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50TFClinicaTiempoDeCita_SelDscs, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV55TFClinicaEstado_Sels.fromJSonString(AV53TFClinicaEstado_SelsJson, null);
      if ( ! ( AV55TFClinicaEstado_Sels.size() == 0 ) )
      {
         AV62i = 1 ;
         AV82GXV3 = 1 ;
         while ( AV82GXV3 <= AV55TFClinicaEstado_Sels.size() )
         {
            AV56TFClinicaEstado_Sel = (String)AV55TFClinicaEstado_Sels.elementAt(-1+AV82GXV3) ;
            if ( AV62i == 1 )
            {
               AV54TFClinicaEstado_SelDscs = "" ;
            }
            else
            {
               AV54TFClinicaEstado_SelDscs += ", " ;
            }
            AV61FilterTFClinicaEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV56TFClinicaEstado_Sel) ;
            AV54TFClinicaEstado_SelDscs += AV61FilterTFClinicaEstado_SelValueDescription ;
            AV62i = (long)(AV62i+1) ;
            AV82GXV3 = (int)(AV82GXV3+1) ;
         }
         h8I0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 130, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54TFClinicaEstado_SelDscs, "")), 130, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h8I0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h8I0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 64, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("RUC", 68, Gx_line+10, 102, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Comercial", 106, Gx_line+10, 140, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Abrev.", 144, Gx_line+10, 178, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Direccion Comercial", 182, Gx_line+10, 216, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Correo", 220, Gx_line+10, 254, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Moneda", 258, Gx_line+10, 292, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Logo", 296, Gx_line+10, 330, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Logo Header", 334, Gx_line+10, 368, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Logo Factura", 372, Gx_line+10, 406, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Logo Boleta", 410, Gx_line+10, 444, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Logo Pago", 448, Gx_line+10, 482, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Telefono", 486, Gx_line+10, 520, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Whats App", 524, Gx_line+10, 558, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Facebook", 562, Gx_line+10, 596, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Twiter", 600, Gx_line+10, 634, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Instagram", 638, Gx_line+10, 672, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Linkedin", 676, Gx_line+10, 710, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tiempo De Cita", 714, Gx_line+10, 748, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 752, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV84Clinicawwds_1_filterfulltext = AV13FilterFullText ;
      AV85Clinicawwds_2_tfclinicaid = AV21TFClinicaId ;
      AV86Clinicawwds_3_tfclinicaid_to = AV22TFClinicaId_To ;
      AV87Clinicawwds_4_tfclinicaruc = AV23TFClinicaRUC ;
      AV88Clinicawwds_5_tfclinicaruc_to = AV24TFClinicaRUC_To ;
      AV89Clinicawwds_6_tfclinicanombrecomercial = AV25TFClinicaNombreComercial ;
      AV90Clinicawwds_7_tfclinicanombrecomercial_sel = AV26TFClinicaNombreComercial_Sel ;
      AV91Clinicawwds_8_tfclinicanombreabreviado = AV27TFClinicaNombreAbreviado ;
      AV92Clinicawwds_9_tfclinicanombreabreviado_sel = AV28TFClinicaNombreAbreviado_Sel ;
      AV93Clinicawwds_10_tfclinicadireccioncomercial = AV29TFClinicaDireccionComercial ;
      AV94Clinicawwds_11_tfclinicadireccioncomercial_sel = AV30TFClinicaDireccionComercial_Sel ;
      AV95Clinicawwds_12_tfclinicacorreo = AV31TFClinicaCorreo ;
      AV96Clinicawwds_13_tfclinicacorreo_sel = AV32TFClinicaCorreo_Sel ;
      AV97Clinicawwds_14_tfclinicamoneda_sels = AV35TFClinicaMoneda_Sels ;
      AV98Clinicawwds_15_tfclinicatelefono = AV37TFClinicaTelefono ;
      AV99Clinicawwds_16_tfclinicatelefono_sel = AV38TFClinicaTelefono_Sel ;
      AV100Clinicawwds_17_tfclinicawhatsapp = AV39TFClinicaWhatsApp ;
      AV101Clinicawwds_18_tfclinicawhatsapp_sel = AV40TFClinicaWhatsApp_Sel ;
      AV102Clinicawwds_19_tfclinicafacebook = AV41TFClinicaFacebook ;
      AV103Clinicawwds_20_tfclinicafacebook_sel = AV42TFClinicaFacebook_Sel ;
      AV104Clinicawwds_21_tfclinicatwiter = AV43TFClinicaTwiter ;
      AV105Clinicawwds_22_tfclinicatwiter_sel = AV44TFClinicaTwiter_Sel ;
      AV106Clinicawwds_23_tfclinicainstagram = AV45TFClinicaInstagram ;
      AV107Clinicawwds_24_tfclinicainstagram_sel = AV46TFClinicaInstagram_Sel ;
      AV108Clinicawwds_25_tfclinicalinkedin = AV47TFClinicaLinkedin ;
      AV109Clinicawwds_26_tfclinicalinkedin_sel = AV48TFClinicaLinkedin_Sel ;
      AV110Clinicawwds_27_tfclinicatiempodecita_sels = AV51TFClinicaTiempoDeCita_Sels ;
      AV111Clinicawwds_28_tfclinicaestado_sels = AV55TFClinicaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV97Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV110Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV111Clinicawwds_28_tfclinicaestado_sels ,
                                           AV84Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV85Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV86Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV87Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV88Clinicawwds_5_tfclinicaruc_to) ,
                                           AV90Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV89Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV92Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV91Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV94Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV93Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV96Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV95Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV97Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV99Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV98Clinicawwds_15_tfclinicatelefono ,
                                           AV101Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV100Clinicawwds_17_tfclinicawhatsapp ,
                                           AV103Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV102Clinicawwds_19_tfclinicafacebook ,
                                           AV105Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV104Clinicawwds_21_tfclinicatwiter ,
                                           AV107Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV106Clinicawwds_23_tfclinicainstagram ,
                                           AV109Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV108Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV110Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV111Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV84Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_1_filterfulltext), "%", "") ;
      lV89Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV89Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV91Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV91Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV93Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV93Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV95Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV95Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV98Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV98Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV100Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV100Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV102Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV102Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV104Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV104Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV106Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV106Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV108Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV108Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P008I2 */
      pr_default.execute(0, new Object[] {lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, lV84Clinicawwds_1_filterfulltext, Short.valueOf(AV85Clinicawwds_2_tfclinicaid), Short.valueOf(AV86Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV87Clinicawwds_4_tfclinicaruc), Long.valueOf(AV88Clinicawwds_5_tfclinicaruc_to), lV89Clinicawwds_6_tfclinicanombrecomercial, AV90Clinicawwds_7_tfclinicanombrecomercial_sel, lV91Clinicawwds_8_tfclinicanombreabreviado, AV92Clinicawwds_9_tfclinicanombreabreviado_sel, lV93Clinicawwds_10_tfclinicadireccioncomercial, AV94Clinicawwds_11_tfclinicadireccioncomercial_sel, lV95Clinicawwds_12_tfclinicacorreo, AV96Clinicawwds_13_tfclinicacorreo_sel, lV98Clinicawwds_15_tfclinicatelefono, AV99Clinicawwds_16_tfclinicatelefono_sel, lV100Clinicawwds_17_tfclinicawhatsapp, AV101Clinicawwds_18_tfclinicawhatsapp_sel, lV102Clinicawwds_19_tfclinicafacebook, AV103Clinicawwds_20_tfclinicafacebook_sel, lV104Clinicawwds_21_tfclinicatwiter, AV105Clinicawwds_22_tfclinicatwiter_sel, lV106Clinicawwds_23_tfclinicainstagram, AV107Clinicawwds_24_tfclinicainstagram_sel, lV108Clinicawwds_25_tfclinicalinkedin, AV109Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A118ClinicaRUC = P008I2_A118ClinicaRUC[0] ;
         A28ClinicaId = P008I2_A28ClinicaId[0] ;
         A121ClinicaEstado = P008I2_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P008I2_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P008I2_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P008I2_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P008I2_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P008I2_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P008I2_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P008I2_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P008I2_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P008I2_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P008I2_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P008I2_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P008I2_A116ClinicaNombreComercial[0] ;
         A40004ClinicaLogoPago_GXI = P008I2_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = P008I2_n40004ClinicaLogoPago_GXI[0] ;
         A40003ClinicaLogoBoleta_GXI = P008I2_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = P008I2_n40003ClinicaLogoBoleta_GXI[0] ;
         A40002ClinicaLogoFactura_GXI = P008I2_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = P008I2_n40002ClinicaLogoFactura_GXI[0] ;
         A40001ClinicaLogoHeader_GXI = P008I2_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = P008I2_n40001ClinicaLogoHeader_GXI[0] ;
         A40000ClinicaLogo_GXI = P008I2_A40000ClinicaLogo_GXI[0] ;
         A345ClinicaLogoPago = P008I2_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = P008I2_n345ClinicaLogoPago[0] ;
         A344ClinicaLogoBoleta = P008I2_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = P008I2_n344ClinicaLogoBoleta[0] ;
         A343ClinicaLogoFactura = P008I2_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = P008I2_n343ClinicaLogoFactura[0] ;
         A342ClinicaLogoHeader = P008I2_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = P008I2_n342ClinicaLogoHeader[0] ;
         A117ClinicaLogo = P008I2_A117ClinicaLogo[0] ;
         AV14ClinicaMonedaDescription = com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)A341ClinicaMoneda) ;
         AV15ClinicaTiempoDeCitaDescription = com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)A120ClinicaTiempoDeCita) ;
         AV16ClinicaEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A121ClinicaEstado) ;
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
         h8I0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9")), 30, Gx_line+10, 64, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9")), 68, Gx_line+10, 102, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A116ClinicaNombreComercial, "")), 106, Gx_line+10, 140, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A80ClinicaNombreAbreviado, "")), 144, Gx_line+10, 178, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A119ClinicaDireccionComercial, "")), 182, Gx_line+10, 216, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A340ClinicaCorreo, "")), 220, Gx_line+10, 254, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14ClinicaMonedaDescription, "")), 258, Gx_line+10, 292, Gx_line+55, 0, 0, 0, 0) ;
         sImgUrl = ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : A117ClinicaLogo) ;
         getPrinter().GxDrawBitMap(sImgUrl, 296, Gx_line+10, 330, Gx_line+55) ;
         sImgUrl = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : A342ClinicaLogoHeader) ;
         getPrinter().GxDrawBitMap(sImgUrl, 334, Gx_line+10, 368, Gx_line+55) ;
         sImgUrl = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : A343ClinicaLogoFactura) ;
         getPrinter().GxDrawBitMap(sImgUrl, 372, Gx_line+10, 406, Gx_line+55) ;
         sImgUrl = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : A344ClinicaLogoBoleta) ;
         getPrinter().GxDrawBitMap(sImgUrl, 410, Gx_line+10, 444, Gx_line+55) ;
         sImgUrl = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : A345ClinicaLogoPago) ;
         getPrinter().GxDrawBitMap(sImgUrl, 448, Gx_line+10, 482, Gx_line+55) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A346ClinicaTelefono, "")), 486, Gx_line+10, 520, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A347ClinicaWhatsApp, "")), 524, Gx_line+10, 558, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A348ClinicaFacebook, "")), 562, Gx_line+10, 596, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A349ClinicaTwiter, "")), 600, Gx_line+10, 634, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A350ClinicaInstagram, "")), 638, Gx_line+10, 672, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A351ClinicaLinkedin, "")), 676, Gx_line+10, 710, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15ClinicaTiempoDeCitaDescription, "")), 714, Gx_line+10, 748, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV16ClinicaEstadoDescription, "")), 752, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV17Session.getValue("ClinicaWWGridState"), "") == 0 )
      {
         AV19GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClinicaWWGridState"), null, null);
      }
      else
      {
         AV19GridState.fromxml(AV17Session.getValue("ClinicaWWGridState"), null, null);
      }
      AV11OrderedBy = AV19GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV19GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV112GXV4 = 1 ;
      while ( AV112GXV4 <= AV19GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV20GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV19GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV112GXV4));
         if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV21TFClinicaId = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFClinicaId_To = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV23TFClinicaRUC = GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV24TFClinicaRUC_To = GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV25TFClinicaNombreComercial = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV26TFClinicaNombreComercial_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO") == 0 )
         {
            AV27TFClinicaNombreAbreviado = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO_SEL") == 0 )
         {
            AV28TFClinicaNombreAbreviado_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL") == 0 )
         {
            AV29TFClinicaDireccionComercial = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL_SEL") == 0 )
         {
            AV30TFClinicaDireccionComercial_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO") == 0 )
         {
            AV31TFClinicaCorreo = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO_SEL") == 0 )
         {
            AV32TFClinicaCorreo_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAMONEDA_SEL") == 0 )
         {
            AV33TFClinicaMoneda_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV35TFClinicaMoneda_Sels.fromJSonString(AV33TFClinicaMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO") == 0 )
         {
            AV37TFClinicaTelefono = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO_SEL") == 0 )
         {
            AV38TFClinicaTelefono_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP") == 0 )
         {
            AV39TFClinicaWhatsApp = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP_SEL") == 0 )
         {
            AV40TFClinicaWhatsApp_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK") == 0 )
         {
            AV41TFClinicaFacebook = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK_SEL") == 0 )
         {
            AV42TFClinicaFacebook_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER") == 0 )
         {
            AV43TFClinicaTwiter = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER_SEL") == 0 )
         {
            AV44TFClinicaTwiter_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM") == 0 )
         {
            AV45TFClinicaInstagram = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM_SEL") == 0 )
         {
            AV46TFClinicaInstagram_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN") == 0 )
         {
            AV47TFClinicaLinkedin = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN_SEL") == 0 )
         {
            AV48TFClinicaLinkedin_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATIEMPODECITA_SEL") == 0 )
         {
            AV49TFClinicaTiempoDeCita_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFClinicaTiempoDeCita_Sels.fromJSonString(AV49TFClinicaTiempoDeCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAESTADO_SEL") == 0 )
         {
            AV53TFClinicaEstado_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFClinicaEstado_Sels.fromJSonString(AV53TFClinicaEstado_SelsJson, null);
         }
         AV112GXV4 = (int)(AV112GXV4+1) ;
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

   public void h8I0( boolean bFoot ,
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
               AV71PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV68DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV71PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV68DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV66AppName = "DVelop Software Solutions" ;
            AV72Phone = "+1 550 8923" ;
            AV70Mail = "info@mail.com" ;
            AV74Website = "http://www.web.com" ;
            AV63AddressLine1 = "French Boulevard 2859" ;
            AV64AddressLine2 = "Downtown" ;
            AV65AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV66AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV73Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV70Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV74Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV63AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV64AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV65AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV77Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV73Title = "" ;
      AV13FilterFullText = "" ;
      AV57TFClinicaId_To_Description = "" ;
      AV58TFClinicaRUC_To_Description = "" ;
      AV26TFClinicaNombreComercial_Sel = "" ;
      AV25TFClinicaNombreComercial = "" ;
      AV28TFClinicaNombreAbreviado_Sel = "" ;
      AV27TFClinicaNombreAbreviado = "" ;
      AV30TFClinicaDireccionComercial_Sel = "" ;
      AV29TFClinicaDireccionComercial = "" ;
      AV32TFClinicaCorreo_Sel = "" ;
      AV31TFClinicaCorreo = "" ;
      AV35TFClinicaMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV33TFClinicaMoneda_SelsJson = "" ;
      AV34TFClinicaMoneda_SelDscs = "" ;
      AV59FilterTFClinicaMoneda_SelValueDescription = "" ;
      AV38TFClinicaTelefono_Sel = "" ;
      AV37TFClinicaTelefono = "" ;
      AV40TFClinicaWhatsApp_Sel = "" ;
      AV39TFClinicaWhatsApp = "" ;
      AV42TFClinicaFacebook_Sel = "" ;
      AV41TFClinicaFacebook = "" ;
      AV44TFClinicaTwiter_Sel = "" ;
      AV43TFClinicaTwiter = "" ;
      AV46TFClinicaInstagram_Sel = "" ;
      AV45TFClinicaInstagram = "" ;
      AV48TFClinicaLinkedin_Sel = "" ;
      AV47TFClinicaLinkedin = "" ;
      AV51TFClinicaTiempoDeCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV49TFClinicaTiempoDeCita_SelsJson = "" ;
      AV50TFClinicaTiempoDeCita_SelDscs = "" ;
      AV60FilterTFClinicaTiempoDeCita_SelValueDescription = "" ;
      AV55TFClinicaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFClinicaEstado_SelsJson = "" ;
      AV56TFClinicaEstado_Sel = "" ;
      AV54TFClinicaEstado_SelDscs = "" ;
      AV61FilterTFClinicaEstado_SelValueDescription = "" ;
      A121ClinicaEstado = "" ;
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A117ClinicaLogo = "" ;
      A40000ClinicaLogo_GXI = "" ;
      A342ClinicaLogoHeader = "" ;
      A40001ClinicaLogoHeader_GXI = "" ;
      A343ClinicaLogoFactura = "" ;
      A40002ClinicaLogoFactura_GXI = "" ;
      A344ClinicaLogoBoleta = "" ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      A345ClinicaLogoPago = "" ;
      A40004ClinicaLogoPago_GXI = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      AV84Clinicawwds_1_filterfulltext = "" ;
      AV89Clinicawwds_6_tfclinicanombrecomercial = "" ;
      AV90Clinicawwds_7_tfclinicanombrecomercial_sel = "" ;
      AV91Clinicawwds_8_tfclinicanombreabreviado = "" ;
      AV92Clinicawwds_9_tfclinicanombreabreviado_sel = "" ;
      AV93Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      AV94Clinicawwds_11_tfclinicadireccioncomercial_sel = "" ;
      AV95Clinicawwds_12_tfclinicacorreo = "" ;
      AV96Clinicawwds_13_tfclinicacorreo_sel = "" ;
      AV97Clinicawwds_14_tfclinicamoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV98Clinicawwds_15_tfclinicatelefono = "" ;
      AV99Clinicawwds_16_tfclinicatelefono_sel = "" ;
      AV100Clinicawwds_17_tfclinicawhatsapp = "" ;
      AV101Clinicawwds_18_tfclinicawhatsapp_sel = "" ;
      AV102Clinicawwds_19_tfclinicafacebook = "" ;
      AV103Clinicawwds_20_tfclinicafacebook_sel = "" ;
      AV104Clinicawwds_21_tfclinicatwiter = "" ;
      AV105Clinicawwds_22_tfclinicatwiter_sel = "" ;
      AV106Clinicawwds_23_tfclinicainstagram = "" ;
      AV107Clinicawwds_24_tfclinicainstagram_sel = "" ;
      AV108Clinicawwds_25_tfclinicalinkedin = "" ;
      AV109Clinicawwds_26_tfclinicalinkedin_sel = "" ;
      AV110Clinicawwds_27_tfclinicatiempodecita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV111Clinicawwds_28_tfclinicaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV84Clinicawwds_1_filterfulltext = "" ;
      lV89Clinicawwds_6_tfclinicanombrecomercial = "" ;
      lV91Clinicawwds_8_tfclinicanombreabreviado = "" ;
      lV93Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      lV95Clinicawwds_12_tfclinicacorreo = "" ;
      lV98Clinicawwds_15_tfclinicatelefono = "" ;
      lV100Clinicawwds_17_tfclinicawhatsapp = "" ;
      lV102Clinicawwds_19_tfclinicafacebook = "" ;
      lV104Clinicawwds_21_tfclinicatwiter = "" ;
      lV106Clinicawwds_23_tfclinicainstagram = "" ;
      lV108Clinicawwds_25_tfclinicalinkedin = "" ;
      P008I2_A118ClinicaRUC = new long[1] ;
      P008I2_A28ClinicaId = new short[1] ;
      P008I2_A121ClinicaEstado = new String[] {""} ;
      P008I2_A120ClinicaTiempoDeCita = new byte[1] ;
      P008I2_A351ClinicaLinkedin = new String[] {""} ;
      P008I2_A350ClinicaInstagram = new String[] {""} ;
      P008I2_A349ClinicaTwiter = new String[] {""} ;
      P008I2_A348ClinicaFacebook = new String[] {""} ;
      P008I2_A347ClinicaWhatsApp = new String[] {""} ;
      P008I2_A346ClinicaTelefono = new String[] {""} ;
      P008I2_A341ClinicaMoneda = new short[1] ;
      P008I2_A340ClinicaCorreo = new String[] {""} ;
      P008I2_A119ClinicaDireccionComercial = new String[] {""} ;
      P008I2_A80ClinicaNombreAbreviado = new String[] {""} ;
      P008I2_A116ClinicaNombreComercial = new String[] {""} ;
      P008I2_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      P008I2_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      P008I2_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      P008I2_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      P008I2_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      P008I2_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      P008I2_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      P008I2_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      P008I2_A40000ClinicaLogo_GXI = new String[] {""} ;
      P008I2_A345ClinicaLogoPago = new String[] {""} ;
      P008I2_n345ClinicaLogoPago = new boolean[] {false} ;
      P008I2_A344ClinicaLogoBoleta = new String[] {""} ;
      P008I2_n344ClinicaLogoBoleta = new boolean[] {false} ;
      P008I2_A343ClinicaLogoFactura = new String[] {""} ;
      P008I2_n343ClinicaLogoFactura = new boolean[] {false} ;
      P008I2_A342ClinicaLogoHeader = new String[] {""} ;
      P008I2_n342ClinicaLogoHeader = new boolean[] {false} ;
      P008I2_A117ClinicaLogo = new String[] {""} ;
      AV14ClinicaMonedaDescription = "" ;
      AV15ClinicaTiempoDeCitaDescription = "" ;
      AV16ClinicaEstadoDescription = "" ;
      sImgUrl = "" ;
      AV17Session = httpContext.getWebSession();
      AV19GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV20GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV71PageInfo = "" ;
      AV68DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV66AppName = "" ;
      AV72Phone = "" ;
      AV70Mail = "" ;
      AV74Website = "" ;
      AV63AddressLine1 = "" ;
      AV64AddressLine2 = "" ;
      AV65AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinicawwexportreport__default(),
         new Object[] {
             new Object[] {
            P008I2_A118ClinicaRUC, P008I2_A28ClinicaId, P008I2_A121ClinicaEstado, P008I2_A120ClinicaTiempoDeCita, P008I2_A351ClinicaLinkedin, P008I2_A350ClinicaInstagram, P008I2_A349ClinicaTwiter, P008I2_A348ClinicaFacebook, P008I2_A347ClinicaWhatsApp, P008I2_A346ClinicaTelefono,
            P008I2_A341ClinicaMoneda, P008I2_A340ClinicaCorreo, P008I2_A119ClinicaDireccionComercial, P008I2_A80ClinicaNombreAbreviado, P008I2_A116ClinicaNombreComercial, P008I2_A40004ClinicaLogoPago_GXI, P008I2_n40004ClinicaLogoPago_GXI, P008I2_A40003ClinicaLogoBoleta_GXI, P008I2_n40003ClinicaLogoBoleta_GXI, P008I2_A40002ClinicaLogoFactura_GXI,
            P008I2_n40002ClinicaLogoFactura_GXI, P008I2_A40001ClinicaLogoHeader_GXI, P008I2_n40001ClinicaLogoHeader_GXI, P008I2_A40000ClinicaLogo_GXI, P008I2_A345ClinicaLogoPago, P008I2_n345ClinicaLogoPago, P008I2_A344ClinicaLogoBoleta, P008I2_n344ClinicaLogoBoleta, P008I2_A343ClinicaLogoFactura, P008I2_n343ClinicaLogoFactura,
            P008I2_A342ClinicaLogoHeader, P008I2_n342ClinicaLogoHeader, P008I2_A117ClinicaLogo
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV77Pgmname = "ClinicaWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV77Pgmname = "ClinicaWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV52TFClinicaTiempoDeCita_Sel ;
   private byte A120ClinicaTiempoDeCita ;
   private short gxcookieaux ;
   private short AV21TFClinicaId ;
   private short AV22TFClinicaId_To ;
   private short AV36TFClinicaMoneda_Sel ;
   private short A341ClinicaMoneda ;
   private short A28ClinicaId ;
   private short AV85Clinicawwds_2_tfclinicaid ;
   private short AV86Clinicawwds_3_tfclinicaid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV80GXV1 ;
   private int AV81GXV2 ;
   private int AV82GXV3 ;
   private int AV97Clinicawwds_14_tfclinicamoneda_sels_size ;
   private int AV110Clinicawwds_27_tfclinicatiempodecita_sels_size ;
   private int AV111Clinicawwds_28_tfclinicaestado_sels_size ;
   private int AV112GXV4 ;
   private long AV23TFClinicaRUC ;
   private long AV24TFClinicaRUC_To ;
   private long AV62i ;
   private long A118ClinicaRUC ;
   private long AV87Clinicawwds_4_tfclinicaruc ;
   private long AV88Clinicawwds_5_tfclinicaruc_to ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV77Pgmname ;
   private String AV38TFClinicaTelefono_Sel ;
   private String AV37TFClinicaTelefono ;
   private String AV40TFClinicaWhatsApp_Sel ;
   private String AV39TFClinicaWhatsApp ;
   private String AV56TFClinicaEstado_Sel ;
   private String A121ClinicaEstado ;
   private String A346ClinicaTelefono ;
   private String A347ClinicaWhatsApp ;
   private String AV98Clinicawwds_15_tfclinicatelefono ;
   private String AV99Clinicawwds_16_tfclinicatelefono_sel ;
   private String AV100Clinicawwds_17_tfclinicawhatsapp ;
   private String AV101Clinicawwds_18_tfclinicawhatsapp_sel ;
   private String scmdbuf ;
   private String lV98Clinicawwds_15_tfclinicatelefono ;
   private String lV100Clinicawwds_17_tfclinicawhatsapp ;
   private String sImgUrl ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n40004ClinicaLogoPago_GXI ;
   private boolean n40003ClinicaLogoBoleta_GXI ;
   private boolean n40002ClinicaLogoFactura_GXI ;
   private boolean n40001ClinicaLogoHeader_GXI ;
   private boolean n345ClinicaLogoPago ;
   private boolean n344ClinicaLogoBoleta ;
   private boolean n343ClinicaLogoFactura ;
   private boolean n342ClinicaLogoHeader ;
   private String AV33TFClinicaMoneda_SelsJson ;
   private String AV49TFClinicaTiempoDeCita_SelsJson ;
   private String AV53TFClinicaEstado_SelsJson ;
   private String AV73Title ;
   private String AV13FilterFullText ;
   private String AV57TFClinicaId_To_Description ;
   private String AV58TFClinicaRUC_To_Description ;
   private String AV26TFClinicaNombreComercial_Sel ;
   private String AV25TFClinicaNombreComercial ;
   private String AV28TFClinicaNombreAbreviado_Sel ;
   private String AV27TFClinicaNombreAbreviado ;
   private String AV30TFClinicaDireccionComercial_Sel ;
   private String AV29TFClinicaDireccionComercial ;
   private String AV32TFClinicaCorreo_Sel ;
   private String AV31TFClinicaCorreo ;
   private String AV34TFClinicaMoneda_SelDscs ;
   private String AV59FilterTFClinicaMoneda_SelValueDescription ;
   private String AV42TFClinicaFacebook_Sel ;
   private String AV41TFClinicaFacebook ;
   private String AV44TFClinicaTwiter_Sel ;
   private String AV43TFClinicaTwiter ;
   private String AV46TFClinicaInstagram_Sel ;
   private String AV45TFClinicaInstagram ;
   private String AV48TFClinicaLinkedin_Sel ;
   private String AV47TFClinicaLinkedin ;
   private String AV50TFClinicaTiempoDeCita_SelDscs ;
   private String AV60FilterTFClinicaTiempoDeCita_SelValueDescription ;
   private String AV54TFClinicaEstado_SelDscs ;
   private String AV61FilterTFClinicaEstado_SelValueDescription ;
   private String A116ClinicaNombreComercial ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A40000ClinicaLogo_GXI ;
   private String A40001ClinicaLogoHeader_GXI ;
   private String A40002ClinicaLogoFactura_GXI ;
   private String A40003ClinicaLogoBoleta_GXI ;
   private String A40004ClinicaLogoPago_GXI ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String AV84Clinicawwds_1_filterfulltext ;
   private String AV89Clinicawwds_6_tfclinicanombrecomercial ;
   private String AV90Clinicawwds_7_tfclinicanombrecomercial_sel ;
   private String AV91Clinicawwds_8_tfclinicanombreabreviado ;
   private String AV92Clinicawwds_9_tfclinicanombreabreviado_sel ;
   private String AV93Clinicawwds_10_tfclinicadireccioncomercial ;
   private String AV94Clinicawwds_11_tfclinicadireccioncomercial_sel ;
   private String AV95Clinicawwds_12_tfclinicacorreo ;
   private String AV96Clinicawwds_13_tfclinicacorreo_sel ;
   private String AV102Clinicawwds_19_tfclinicafacebook ;
   private String AV103Clinicawwds_20_tfclinicafacebook_sel ;
   private String AV104Clinicawwds_21_tfclinicatwiter ;
   private String AV105Clinicawwds_22_tfclinicatwiter_sel ;
   private String AV106Clinicawwds_23_tfclinicainstagram ;
   private String AV107Clinicawwds_24_tfclinicainstagram_sel ;
   private String AV108Clinicawwds_25_tfclinicalinkedin ;
   private String AV109Clinicawwds_26_tfclinicalinkedin_sel ;
   private String lV84Clinicawwds_1_filterfulltext ;
   private String lV89Clinicawwds_6_tfclinicanombrecomercial ;
   private String lV91Clinicawwds_8_tfclinicanombreabreviado ;
   private String lV93Clinicawwds_10_tfclinicadireccioncomercial ;
   private String lV95Clinicawwds_12_tfclinicacorreo ;
   private String lV102Clinicawwds_19_tfclinicafacebook ;
   private String lV104Clinicawwds_21_tfclinicatwiter ;
   private String lV106Clinicawwds_23_tfclinicainstagram ;
   private String lV108Clinicawwds_25_tfclinicalinkedin ;
   private String AV14ClinicaMonedaDescription ;
   private String AV15ClinicaTiempoDeCitaDescription ;
   private String AV16ClinicaEstadoDescription ;
   private String AV71PageInfo ;
   private String AV68DateInfo ;
   private String AV66AppName ;
   private String AV72Phone ;
   private String AV70Mail ;
   private String AV74Website ;
   private String AV63AddressLine1 ;
   private String AV64AddressLine2 ;
   private String AV65AddressLine3 ;
   private String A117ClinicaLogo ;
   private String A342ClinicaLogoHeader ;
   private String A343ClinicaLogoFactura ;
   private String A344ClinicaLogoBoleta ;
   private String A345ClinicaLogoPago ;
   private GXSimpleCollection<Byte> AV51TFClinicaTiempoDeCita_Sels ;
   private GXSimpleCollection<Byte> AV110Clinicawwds_27_tfclinicatiempodecita_sels ;
   private GXSimpleCollection<Short> AV35TFClinicaMoneda_Sels ;
   private GXSimpleCollection<Short> AV97Clinicawwds_14_tfclinicamoneda_sels ;
   private com.genexus.webpanels.WebSession AV17Session ;
   private IDataStoreProvider pr_default ;
   private long[] P008I2_A118ClinicaRUC ;
   private short[] P008I2_A28ClinicaId ;
   private String[] P008I2_A121ClinicaEstado ;
   private byte[] P008I2_A120ClinicaTiempoDeCita ;
   private String[] P008I2_A351ClinicaLinkedin ;
   private String[] P008I2_A350ClinicaInstagram ;
   private String[] P008I2_A349ClinicaTwiter ;
   private String[] P008I2_A348ClinicaFacebook ;
   private String[] P008I2_A347ClinicaWhatsApp ;
   private String[] P008I2_A346ClinicaTelefono ;
   private short[] P008I2_A341ClinicaMoneda ;
   private String[] P008I2_A340ClinicaCorreo ;
   private String[] P008I2_A119ClinicaDireccionComercial ;
   private String[] P008I2_A80ClinicaNombreAbreviado ;
   private String[] P008I2_A116ClinicaNombreComercial ;
   private String[] P008I2_A40004ClinicaLogoPago_GXI ;
   private boolean[] P008I2_n40004ClinicaLogoPago_GXI ;
   private String[] P008I2_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] P008I2_n40003ClinicaLogoBoleta_GXI ;
   private String[] P008I2_A40002ClinicaLogoFactura_GXI ;
   private boolean[] P008I2_n40002ClinicaLogoFactura_GXI ;
   private String[] P008I2_A40001ClinicaLogoHeader_GXI ;
   private boolean[] P008I2_n40001ClinicaLogoHeader_GXI ;
   private String[] P008I2_A40000ClinicaLogo_GXI ;
   private String[] P008I2_A345ClinicaLogoPago ;
   private boolean[] P008I2_n345ClinicaLogoPago ;
   private String[] P008I2_A344ClinicaLogoBoleta ;
   private boolean[] P008I2_n344ClinicaLogoBoleta ;
   private String[] P008I2_A343ClinicaLogoFactura ;
   private boolean[] P008I2_n343ClinicaLogoFactura ;
   private String[] P008I2_A342ClinicaLogoHeader ;
   private boolean[] P008I2_n342ClinicaLogoHeader ;
   private String[] P008I2_A117ClinicaLogo ;
   private GXSimpleCollection<String> AV55TFClinicaEstado_Sels ;
   private GXSimpleCollection<String> AV111Clinicawwds_28_tfclinicaestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV19GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV20GridStateFilterValue ;
}

final  class clinicawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P008I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV97Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV110Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV111Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV84Clinicawwds_1_filterfulltext ,
                                          short AV85Clinicawwds_2_tfclinicaid ,
                                          short AV86Clinicawwds_3_tfclinicaid_to ,
                                          long AV87Clinicawwds_4_tfclinicaruc ,
                                          long AV88Clinicawwds_5_tfclinicaruc_to ,
                                          String AV90Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV89Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV92Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV91Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV94Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV93Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV96Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV95Clinicawwds_12_tfclinicacorreo ,
                                          int AV97Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV99Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV98Clinicawwds_15_tfclinicatelefono ,
                                          String AV101Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV100Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV103Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV102Clinicawwds_19_tfclinicafacebook ,
                                          String AV105Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV104Clinicawwds_21_tfclinicatwiter ,
                                          String AV107Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV106Clinicawwds_23_tfclinicainstagram ,
                                          String AV109Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV108Clinicawwds_25_tfclinicalinkedin ,
                                          int AV110Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV111Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[43];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook], [ClinicaWhatsApp]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial], [ClinicaLogoPago_GXI], [ClinicaLogoBoleta_GXI]," ;
      scmdbuf += " [ClinicaLogoFactura_GXI], [ClinicaLogoHeader_GXI], [ClinicaLogo_GXI], [ClinicaLogoPago], [ClinicaLogoBoleta], [ClinicaLogoFactura], [ClinicaLogoHeader], [ClinicaLogo]" ;
      scmdbuf += " FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV84Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
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
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (0==AV85Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (0==AV86Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV87Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (0==AV88Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV89Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV91Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV93Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV95Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( AV97Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV97Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV99Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV98Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV101Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV100Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV101Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV102Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV105Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV104Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV106Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV108Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( AV110Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV110Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV111Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV111Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaRUC]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaRUC] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaNombreComercial]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaNombreComercial] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaDireccionComercial]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaDireccionComercial] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaCorreo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaMoneda]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaMoneda] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaTelefono]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaTelefono] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaWhatsApp]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaWhatsApp] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaFacebook]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaFacebook] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaTwiter]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaTwiter] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaInstagram]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaInstagram] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaLinkedin]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaLinkedin] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaTiempoDeCita]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaTiempoDeCita] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaEstado]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaEstado] DESC" ;
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
                  return conditional_P008I2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).shortValue() , ((Boolean) dynConstraints[47]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008I2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 15);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(16);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaUri(19);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(20);
               ((String[]) buf[24])[0] = rslt.getMultimediaFile(21, rslt.getVarchar(16));
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getMultimediaFile(22, rslt.getVarchar(17));
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getMultimediaFile(23, rslt.getVarchar(18));
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getMultimediaFile(24, rslt.getVarchar(19));
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getMultimediaFile(25, rslt.getVarchar(20));
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
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
      }
   }

}

