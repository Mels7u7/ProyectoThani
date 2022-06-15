package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sedewwexportreport_impl extends GXWebReport
{
   public sedewwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede", GXv_boolean2) ;
         sedewwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV72Pgmname))}, new String[] {"GxObject"}) );
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
            AV68Title = "Lista de Sede" ;
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
         h4C0( true, 0) ;
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
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV21TFSedeId) && (0==AV22TFSedeId_To) ) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFSedeId), "ZZZ9")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV51TFSedeId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51TFSedeId_To_Description, "")), 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFSedeId_To), "ZZZ9")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV24TFSedeNombre_Sel)==0) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFSedeNombre_Sel, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFSedeNombre)==0) )
         {
            h4C0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFSedeNombre, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV25TFClinicaId) && (0==AV26TFClinicaId_To) ) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Clinica Id", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV25TFClinicaId), "ZZZ9")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV52TFClinicaId_To_Description = GXutil.format( "%1 (%2)", "Clinica Id", "Hasta", "", "", "", "", "", "", "") ;
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52TFClinicaId_To_Description, "")), 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV26TFClinicaId_To), "ZZZ9")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV27TFClinicaRUC) && (0==AV28TFClinicaRUC_To) ) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Clinica RUC", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV27TFClinicaRUC), "ZZZZZZZZZZ9")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV53TFClinicaRUC_To_Description = GXutil.format( "%1 (%2)", "Clinica RUC", "Hasta", "", "", "", "", "", "", "") ;
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53TFClinicaRUC_To_Description, "")), 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV28TFClinicaRUC_To), "ZZZZZZZZZZ9")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV30TFClinicaNombreComercial_Sel)==0) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Comercial", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFClinicaNombreComercial_Sel, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFClinicaNombreComercial)==0) )
         {
            h4C0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Comercial", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFClinicaNombreComercial, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV32TFUbigeoCode_Sel)==0) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo Code", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFUbigeoCode_Sel, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFUbigeoCode)==0) )
         {
            h4C0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo Code", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFUbigeoCode, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV34TFUbigeoNombre_Sel)==0) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFUbigeoNombre_Sel, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV33TFUbigeoNombre)==0) )
         {
            h4C0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Ubigeo", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFUbigeoNombre, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV36TFSedeDireccion_Sel)==0) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36TFSedeDireccion_Sel, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV35TFSedeDireccion)==0) )
         {
            h4C0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFSedeDireccion, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV38TFSedeCorreo_Sel)==0) )
      {
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Correo", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFSedeCorreo_Sel, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV37TFSedeCorreo)==0) )
         {
            h4C0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Correo", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37TFSedeCorreo, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV41TFSedeEstado_Sels.fromJSonString(AV39TFSedeEstado_SelsJson, null);
      if ( ! ( AV41TFSedeEstado_Sels.size() == 0 ) )
      {
         AV57i = 1 ;
         AV75GXV1 = 1 ;
         while ( AV75GXV1 <= AV41TFSedeEstado_Sels.size() )
         {
            AV42TFSedeEstado_Sel = (String)AV41TFSedeEstado_Sels.elementAt(-1+AV75GXV1) ;
            if ( AV57i == 1 )
            {
               AV40TFSedeEstado_SelDscs = "" ;
            }
            else
            {
               AV40TFSedeEstado_SelDscs += ", " ;
            }
            AV54FilterTFSedeEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV42TFSedeEstado_Sel) ;
            AV40TFSedeEstado_SelDscs += AV54FilterTFSedeEstado_SelValueDescription ;
            AV57i = (long)(AV57i+1) ;
            AV75GXV1 = (int)(AV75GXV1+1) ;
         }
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFSedeEstado_SelDscs, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV45TFSedeTipo_Sels.fromJSonString(AV43TFSedeTipo_SelsJson, null);
      if ( ! ( AV45TFSedeTipo_Sels.size() == 0 ) )
      {
         AV57i = 1 ;
         AV76GXV2 = 1 ;
         while ( AV76GXV2 <= AV45TFSedeTipo_Sels.size() )
         {
            AV46TFSedeTipo_Sel = (String)AV45TFSedeTipo_Sels.elementAt(-1+AV76GXV2) ;
            if ( AV57i == 1 )
            {
               AV44TFSedeTipo_SelDscs = "" ;
            }
            else
            {
               AV44TFSedeTipo_SelDscs += ", " ;
            }
            AV55FilterTFSedeTipo_SelValueDescription = com.projectthani.gxdomaintiposede.getDescription(httpContext,(String)AV46TFSedeTipo_Sel) ;
            AV44TFSedeTipo_SelDscs += AV55FilterTFSedeTipo_SelValueDescription ;
            AV57i = (long)(AV57i+1) ;
            AV76GXV2 = (int)(AV76GXV2+1) ;
         }
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFSedeTipo_SelDscs, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV49TFSedeSector_Sels.fromJSonString(AV47TFSedeSector_SelsJson, null);
      if ( ! ( AV49TFSedeSector_Sels.size() == 0 ) )
      {
         AV57i = 1 ;
         AV77GXV3 = 1 ;
         while ( AV77GXV3 <= AV49TFSedeSector_Sels.size() )
         {
            AV50TFSedeSector_Sel = (String)AV49TFSedeSector_Sels.elementAt(-1+AV77GXV3) ;
            if ( AV57i == 1 )
            {
               AV48TFSedeSector_SelDscs = "" ;
            }
            else
            {
               AV48TFSedeSector_SelDscs += ", " ;
            }
            AV56FilterTFSedeSector_SelValueDescription = com.projectthani.gxdomaintiposector.getDescription(httpContext,(String)AV50TFSedeSector_Sel) ;
            AV48TFSedeSector_SelDscs += AV56FilterTFSedeSector_SelValueDescription ;
            AV57i = (long)(AV57i+1) ;
            AV77GXV3 = (int)(AV77GXV3+1) ;
         }
         h4C0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Sector", 25, Gx_line+0, 122, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48TFSedeSector_SelDscs, "")), 122, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4C0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4C0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 89, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 93, Gx_line+10, 152, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Clinica Id", 156, Gx_line+10, 215, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Clinica RUC", 219, Gx_line+10, 278, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Comercial", 282, Gx_line+10, 341, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo Code", 345, Gx_line+10, 404, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Ubigeo", 408, Gx_line+10, 467, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Direccion", 471, Gx_line+10, 530, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Correo", 534, Gx_line+10, 593, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 597, Gx_line+10, 657, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo", 661, Gx_line+10, 722, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Sector", 726, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV79Sedewwds_1_filterfulltext = AV13FilterFullText ;
      AV80Sedewwds_2_tfsedeid = AV21TFSedeId ;
      AV81Sedewwds_3_tfsedeid_to = AV22TFSedeId_To ;
      AV82Sedewwds_4_tfsedenombre = AV23TFSedeNombre ;
      AV83Sedewwds_5_tfsedenombre_sel = AV24TFSedeNombre_Sel ;
      AV84Sedewwds_6_tfclinicaid = AV25TFClinicaId ;
      AV85Sedewwds_7_tfclinicaid_to = AV26TFClinicaId_To ;
      AV86Sedewwds_8_tfclinicaruc = AV27TFClinicaRUC ;
      AV87Sedewwds_9_tfclinicaruc_to = AV28TFClinicaRUC_To ;
      AV88Sedewwds_10_tfclinicanombrecomercial = AV29TFClinicaNombreComercial ;
      AV89Sedewwds_11_tfclinicanombrecomercial_sel = AV30TFClinicaNombreComercial_Sel ;
      AV90Sedewwds_12_tfubigeocode = AV31TFUbigeoCode ;
      AV91Sedewwds_13_tfubigeocode_sel = AV32TFUbigeoCode_Sel ;
      AV92Sedewwds_14_tfubigeonombre = AV33TFUbigeoNombre ;
      AV93Sedewwds_15_tfubigeonombre_sel = AV34TFUbigeoNombre_Sel ;
      AV94Sedewwds_16_tfsededireccion = AV35TFSedeDireccion ;
      AV95Sedewwds_17_tfsededireccion_sel = AV36TFSedeDireccion_Sel ;
      AV96Sedewwds_18_tfsedecorreo = AV37TFSedeCorreo ;
      AV97Sedewwds_19_tfsedecorreo_sel = AV38TFSedeCorreo_Sel ;
      AV98Sedewwds_20_tfsedeestado_sels = AV41TFSedeEstado_Sels ;
      AV99Sedewwds_21_tfsedetipo_sels = AV45TFSedeTipo_Sels ;
      AV100Sedewwds_22_tfsedesector_sels = AV49TFSedeSector_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV98Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV99Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV100Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV80Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV81Sedewwds_3_tfsedeid_to) ,
                                           AV83Sedewwds_5_tfsedenombre_sel ,
                                           AV82Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV84Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV85Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV86Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV87Sedewwds_9_tfclinicaruc_to) ,
                                           AV89Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV88Sedewwds_10_tfclinicanombrecomercial ,
                                           AV91Sedewwds_13_tfubigeocode_sel ,
                                           AV90Sedewwds_12_tfubigeocode ,
                                           AV93Sedewwds_15_tfubigeonombre_sel ,
                                           AV92Sedewwds_14_tfubigeonombre ,
                                           AV95Sedewwds_17_tfsededireccion_sel ,
                                           AV94Sedewwds_16_tfsededireccion ,
                                           AV97Sedewwds_19_tfsedecorreo_sel ,
                                           AV96Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV98Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV99Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV100Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV79Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV79Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV79Sedewwds_1_filterfulltext), "%", "") ;
      lV82Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV82Sedewwds_4_tfsedenombre), "%", "") ;
      lV88Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV88Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV90Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV90Sedewwds_12_tfubigeocode), 10, "%") ;
      lV92Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV92Sedewwds_14_tfubigeonombre), "%", "") ;
      lV94Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV94Sedewwds_16_tfsededireccion), "%", "") ;
      lV96Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV96Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P004C2 */
      pr_default.execute(0, new Object[] {AV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, lV79Sedewwds_1_filterfulltext, Short.valueOf(AV80Sedewwds_2_tfsedeid), Short.valueOf(AV81Sedewwds_3_tfsedeid_to), lV82Sedewwds_4_tfsedenombre, AV83Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV84Sedewwds_6_tfclinicaid), Short.valueOf(AV85Sedewwds_7_tfclinicaid_to), Long.valueOf(AV86Sedewwds_8_tfclinicaruc), Long.valueOf(AV87Sedewwds_9_tfclinicaruc_to), lV88Sedewwds_10_tfclinicanombrecomercial, AV89Sedewwds_11_tfclinicanombrecomercial_sel, lV90Sedewwds_12_tfubigeocode, AV91Sedewwds_13_tfubigeocode_sel, lV92Sedewwds_14_tfubigeonombre, AV93Sedewwds_15_tfubigeonombre_sel, lV94Sedewwds_16_tfsededireccion, AV95Sedewwds_17_tfsededireccion_sel, lV96Sedewwds_18_tfsedecorreo, AV97Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A118ClinicaRUC = P004C2_A118ClinicaRUC[0] ;
         A28ClinicaId = P004C2_A28ClinicaId[0] ;
         A30SedeId = P004C2_A30SedeId[0] ;
         A280SedeSector = P004C2_A280SedeSector[0] ;
         A279SedeTipo = P004C2_A279SedeTipo[0] ;
         A278SedeEstado = P004C2_A278SedeEstado[0] ;
         A277SedeCorreo = P004C2_A277SedeCorreo[0] ;
         A276SedeDireccion = P004C2_A276SedeDireccion[0] ;
         A185UbigeoNombre = P004C2_A185UbigeoNombre[0] ;
         A44UbigeoCode = P004C2_A44UbigeoCode[0] ;
         A116ClinicaNombreComercial = P004C2_A116ClinicaNombreComercial[0] ;
         A75SedeNombre = P004C2_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P004C2_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P004C2_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P004C2_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P004C2_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P004C2_A116ClinicaNombreComercial[0] ;
         A185UbigeoNombre = P004C2_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P004C2_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P004C2_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P004C2_A188UbigeoDistrito[0] ;
         AV14SedeEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A278SedeEstado) ;
         if ( ! (GXutil.strcmp("", A279SedeTipo)==0) )
         {
            AV15SedeTipoDescription = com.projectthani.gxdomaintiposede.getDescription(httpContext,(String)A279SedeTipo) ;
         }
         else
         {
            AV15SedeTipoDescription = "" ;
         }
         if ( ! (GXutil.strcmp("", A280SedeSector)==0) )
         {
            AV16SedeSectorDescription = com.projectthani.gxdomaintiposector.getDescription(httpContext,(String)A280SedeSector) ;
         }
         else
         {
            AV16SedeSectorDescription = "" ;
         }
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
         h4C0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9")), 30, Gx_line+10, 89, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A75SedeNombre, "")), 93, Gx_line+10, 152, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9")), 156, Gx_line+10, 215, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9")), 219, Gx_line+10, 278, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A116ClinicaNombreComercial, "")), 282, Gx_line+10, 341, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), 345, Gx_line+10, 404, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), 408, Gx_line+10, 467, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A276SedeDireccion, "")), 471, Gx_line+10, 530, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A277SedeCorreo, "")), 534, Gx_line+10, 593, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14SedeEstadoDescription, "")), 597, Gx_line+10, 657, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15SedeTipoDescription, "")), 661, Gx_line+10, 722, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV16SedeSectorDescription, "")), 726, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV17Session.getValue("SedeWWGridState"), "") == 0 )
      {
         AV19GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SedeWWGridState"), null, null);
      }
      else
      {
         AV19GridState.fromxml(AV17Session.getValue("SedeWWGridState"), null, null);
      }
      AV11OrderedBy = AV19GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV19GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV101GXV4 = 1 ;
      while ( AV101GXV4 <= AV19GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV20GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV19GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV101GXV4));
         if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEID") == 0 )
         {
            AV21TFSedeId = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFSedeId_To = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE") == 0 )
         {
            AV23TFSedeNombre = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE_SEL") == 0 )
         {
            AV24TFSedeNombre_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV25TFClinicaId = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFClinicaId_To = (short)(GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV27TFClinicaRUC = GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV28TFClinicaRUC_To = GXutil.lval( AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV29TFClinicaNombreComercial = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV30TFClinicaNombreComercial_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV31TFUbigeoCode = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV32TFUbigeoCode_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV33TFUbigeoNombre = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV34TFUbigeoNombre_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION") == 0 )
         {
            AV35TFSedeDireccion = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION_SEL") == 0 )
         {
            AV36TFSedeDireccion_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO") == 0 )
         {
            AV37TFSedeCorreo = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO_SEL") == 0 )
         {
            AV38TFSedeCorreo_Sel = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEESTADO_SEL") == 0 )
         {
            AV39TFSedeEstado_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSedeEstado_Sels.fromJSonString(AV39TFSedeEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDETIPO_SEL") == 0 )
         {
            AV43TFSedeTipo_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSedeTipo_Sels.fromJSonString(AV43TFSedeTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDESECTOR_SEL") == 0 )
         {
            AV47TFSedeSector_SelsJson = AV20GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFSedeSector_Sels.fromJSonString(AV47TFSedeSector_SelsJson, null);
         }
         AV101GXV4 = (int)(AV101GXV4+1) ;
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

   public void h4C0( boolean bFoot ,
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
               AV66PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV63DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV66PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV63DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV61AppName = "DVelop Software Solutions" ;
            AV67Phone = "+1 550 8923" ;
            AV65Mail = "info@mail.com" ;
            AV69Website = "http://www.web.com" ;
            AV58AddressLine1 = "French Boulevard 2859" ;
            AV59AddressLine2 = "Downtown" ;
            AV60AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV61AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV68Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV67Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV65Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV69Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV58AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV59AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV60AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV72Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV68Title = "" ;
      AV13FilterFullText = "" ;
      AV51TFSedeId_To_Description = "" ;
      AV24TFSedeNombre_Sel = "" ;
      AV23TFSedeNombre = "" ;
      AV52TFClinicaId_To_Description = "" ;
      AV53TFClinicaRUC_To_Description = "" ;
      AV30TFClinicaNombreComercial_Sel = "" ;
      AV29TFClinicaNombreComercial = "" ;
      AV32TFUbigeoCode_Sel = "" ;
      AV31TFUbigeoCode = "" ;
      AV34TFUbigeoNombre_Sel = "" ;
      AV33TFUbigeoNombre = "" ;
      AV36TFSedeDireccion_Sel = "" ;
      AV35TFSedeDireccion = "" ;
      AV38TFSedeCorreo_Sel = "" ;
      AV37TFSedeCorreo = "" ;
      AV41TFSedeEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFSedeEstado_SelsJson = "" ;
      AV42TFSedeEstado_Sel = "" ;
      AV40TFSedeEstado_SelDscs = "" ;
      AV54FilterTFSedeEstado_SelValueDescription = "" ;
      AV45TFSedeTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFSedeTipo_SelsJson = "" ;
      AV46TFSedeTipo_Sel = "" ;
      AV44TFSedeTipo_SelDscs = "" ;
      AV55FilterTFSedeTipo_SelValueDescription = "" ;
      AV49TFSedeSector_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFSedeSector_SelsJson = "" ;
      AV50TFSedeSector_Sel = "" ;
      AV48TFSedeSector_SelDscs = "" ;
      AV56FilterTFSedeSector_SelValueDescription = "" ;
      A278SedeEstado = "" ;
      A279SedeTipo = "" ;
      A280SedeSector = "" ;
      A75SedeNombre = "" ;
      A116ClinicaNombreComercial = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A276SedeDireccion = "" ;
      A277SedeCorreo = "" ;
      AV79Sedewwds_1_filterfulltext = "" ;
      AV82Sedewwds_4_tfsedenombre = "" ;
      AV83Sedewwds_5_tfsedenombre_sel = "" ;
      AV88Sedewwds_10_tfclinicanombrecomercial = "" ;
      AV89Sedewwds_11_tfclinicanombrecomercial_sel = "" ;
      AV90Sedewwds_12_tfubigeocode = "" ;
      AV91Sedewwds_13_tfubigeocode_sel = "" ;
      AV92Sedewwds_14_tfubigeonombre = "" ;
      AV93Sedewwds_15_tfubigeonombre_sel = "" ;
      AV94Sedewwds_16_tfsededireccion = "" ;
      AV95Sedewwds_17_tfsededireccion_sel = "" ;
      AV96Sedewwds_18_tfsedecorreo = "" ;
      AV97Sedewwds_19_tfsedecorreo_sel = "" ;
      AV98Sedewwds_20_tfsedeestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV99Sedewwds_21_tfsedetipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Sedewwds_22_tfsedesector_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV79Sedewwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV82Sedewwds_4_tfsedenombre = "" ;
      lV88Sedewwds_10_tfclinicanombrecomercial = "" ;
      lV90Sedewwds_12_tfubigeocode = "" ;
      lV92Sedewwds_14_tfubigeonombre = "" ;
      lV94Sedewwds_16_tfsededireccion = "" ;
      lV96Sedewwds_18_tfsedecorreo = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P004C2_A118ClinicaRUC = new long[1] ;
      P004C2_A28ClinicaId = new short[1] ;
      P004C2_A30SedeId = new short[1] ;
      P004C2_A280SedeSector = new String[] {""} ;
      P004C2_A279SedeTipo = new String[] {""} ;
      P004C2_A278SedeEstado = new String[] {""} ;
      P004C2_A277SedeCorreo = new String[] {""} ;
      P004C2_A276SedeDireccion = new String[] {""} ;
      P004C2_A185UbigeoNombre = new String[] {""} ;
      P004C2_A44UbigeoCode = new String[] {""} ;
      P004C2_A116ClinicaNombreComercial = new String[] {""} ;
      P004C2_A75SedeNombre = new String[] {""} ;
      P004C2_A186UbigeoDepartamento = new String[] {""} ;
      P004C2_A187UbigeoProvincia = new String[] {""} ;
      P004C2_A188UbigeoDistrito = new String[] {""} ;
      AV14SedeEstadoDescription = "" ;
      AV15SedeTipoDescription = "" ;
      AV16SedeSectorDescription = "" ;
      AV17Session = httpContext.getWebSession();
      AV19GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV20GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV66PageInfo = "" ;
      AV63DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV61AppName = "" ;
      AV67Phone = "" ;
      AV65Mail = "" ;
      AV69Website = "" ;
      AV58AddressLine1 = "" ;
      AV59AddressLine2 = "" ;
      AV60AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sedewwexportreport__default(),
         new Object[] {
             new Object[] {
            P004C2_A118ClinicaRUC, P004C2_A28ClinicaId, P004C2_A30SedeId, P004C2_A280SedeSector, P004C2_A279SedeTipo, P004C2_A278SedeEstado, P004C2_A277SedeCorreo, P004C2_A276SedeDireccion, P004C2_A185UbigeoNombre, P004C2_A44UbigeoCode,
            P004C2_A116ClinicaNombreComercial, P004C2_A75SedeNombre, P004C2_A186UbigeoDepartamento, P004C2_A187UbigeoProvincia, P004C2_A188UbigeoDistrito
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV72Pgmname = "SedeWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV72Pgmname = "SedeWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV21TFSedeId ;
   private short AV22TFSedeId_To ;
   private short AV25TFClinicaId ;
   private short AV26TFClinicaId_To ;
   private short A30SedeId ;
   private short A28ClinicaId ;
   private short AV80Sedewwds_2_tfsedeid ;
   private short AV81Sedewwds_3_tfsedeid_to ;
   private short AV84Sedewwds_6_tfclinicaid ;
   private short AV85Sedewwds_7_tfclinicaid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV75GXV1 ;
   private int AV76GXV2 ;
   private int AV77GXV3 ;
   private int AV98Sedewwds_20_tfsedeestado_sels_size ;
   private int AV99Sedewwds_21_tfsedetipo_sels_size ;
   private int AV100Sedewwds_22_tfsedesector_sels_size ;
   private int AV101GXV4 ;
   private long AV27TFClinicaRUC ;
   private long AV28TFClinicaRUC_To ;
   private long AV57i ;
   private long A118ClinicaRUC ;
   private long AV86Sedewwds_8_tfclinicaruc ;
   private long AV87Sedewwds_9_tfclinicaruc_to ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV72Pgmname ;
   private String AV32TFUbigeoCode_Sel ;
   private String AV31TFUbigeoCode ;
   private String AV42TFSedeEstado_Sel ;
   private String AV46TFSedeTipo_Sel ;
   private String AV50TFSedeSector_Sel ;
   private String A278SedeEstado ;
   private String A279SedeTipo ;
   private String A280SedeSector ;
   private String A44UbigeoCode ;
   private String AV90Sedewwds_12_tfubigeocode ;
   private String AV91Sedewwds_13_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV90Sedewwds_12_tfubigeocode ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV39TFSedeEstado_SelsJson ;
   private String AV43TFSedeTipo_SelsJson ;
   private String AV47TFSedeSector_SelsJson ;
   private String AV68Title ;
   private String AV13FilterFullText ;
   private String AV51TFSedeId_To_Description ;
   private String AV24TFSedeNombre_Sel ;
   private String AV23TFSedeNombre ;
   private String AV52TFClinicaId_To_Description ;
   private String AV53TFClinicaRUC_To_Description ;
   private String AV30TFClinicaNombreComercial_Sel ;
   private String AV29TFClinicaNombreComercial ;
   private String AV34TFUbigeoNombre_Sel ;
   private String AV33TFUbigeoNombre ;
   private String AV36TFSedeDireccion_Sel ;
   private String AV35TFSedeDireccion ;
   private String AV38TFSedeCorreo_Sel ;
   private String AV37TFSedeCorreo ;
   private String AV40TFSedeEstado_SelDscs ;
   private String AV54FilterTFSedeEstado_SelValueDescription ;
   private String AV44TFSedeTipo_SelDscs ;
   private String AV55FilterTFSedeTipo_SelValueDescription ;
   private String AV48TFSedeSector_SelDscs ;
   private String AV56FilterTFSedeSector_SelValueDescription ;
   private String A75SedeNombre ;
   private String A116ClinicaNombreComercial ;
   private String A185UbigeoNombre ;
   private String A276SedeDireccion ;
   private String A277SedeCorreo ;
   private String AV79Sedewwds_1_filterfulltext ;
   private String AV82Sedewwds_4_tfsedenombre ;
   private String AV83Sedewwds_5_tfsedenombre_sel ;
   private String AV88Sedewwds_10_tfclinicanombrecomercial ;
   private String AV89Sedewwds_11_tfclinicanombrecomercial_sel ;
   private String AV92Sedewwds_14_tfubigeonombre ;
   private String AV93Sedewwds_15_tfubigeonombre_sel ;
   private String AV94Sedewwds_16_tfsededireccion ;
   private String AV95Sedewwds_17_tfsededireccion_sel ;
   private String AV96Sedewwds_18_tfsedecorreo ;
   private String AV97Sedewwds_19_tfsedecorreo_sel ;
   private String lV79Sedewwds_1_filterfulltext ;
   private String lV82Sedewwds_4_tfsedenombre ;
   private String lV88Sedewwds_10_tfclinicanombrecomercial ;
   private String lV92Sedewwds_14_tfubigeonombre ;
   private String lV94Sedewwds_16_tfsededireccion ;
   private String lV96Sedewwds_18_tfsedecorreo ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String AV14SedeEstadoDescription ;
   private String AV15SedeTipoDescription ;
   private String AV16SedeSectorDescription ;
   private String AV66PageInfo ;
   private String AV63DateInfo ;
   private String AV61AppName ;
   private String AV67Phone ;
   private String AV65Mail ;
   private String AV69Website ;
   private String AV58AddressLine1 ;
   private String AV59AddressLine2 ;
   private String AV60AddressLine3 ;
   private com.genexus.webpanels.WebSession AV17Session ;
   private IDataStoreProvider pr_default ;
   private long[] P004C2_A118ClinicaRUC ;
   private short[] P004C2_A28ClinicaId ;
   private short[] P004C2_A30SedeId ;
   private String[] P004C2_A280SedeSector ;
   private String[] P004C2_A279SedeTipo ;
   private String[] P004C2_A278SedeEstado ;
   private String[] P004C2_A277SedeCorreo ;
   private String[] P004C2_A276SedeDireccion ;
   private String[] P004C2_A185UbigeoNombre ;
   private String[] P004C2_A44UbigeoCode ;
   private String[] P004C2_A116ClinicaNombreComercial ;
   private String[] P004C2_A75SedeNombre ;
   private String[] P004C2_A186UbigeoDepartamento ;
   private String[] P004C2_A187UbigeoProvincia ;
   private String[] P004C2_A188UbigeoDistrito ;
   private GXSimpleCollection<String> AV41TFSedeEstado_Sels ;
   private GXSimpleCollection<String> AV45TFSedeTipo_Sels ;
   private GXSimpleCollection<String> AV49TFSedeSector_Sels ;
   private GXSimpleCollection<String> AV98Sedewwds_20_tfsedeestado_sels ;
   private GXSimpleCollection<String> AV99Sedewwds_21_tfsedetipo_sels ;
   private GXSimpleCollection<String> AV100Sedewwds_22_tfsedesector_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV19GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV20GridStateFilterValue ;
}

final  class sedewwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV98Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV99Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV100Sedewwds_22_tfsedesector_sels ,
                                          short AV80Sedewwds_2_tfsedeid ,
                                          short AV81Sedewwds_3_tfsedeid_to ,
                                          String AV83Sedewwds_5_tfsedenombre_sel ,
                                          String AV82Sedewwds_4_tfsedenombre ,
                                          short AV84Sedewwds_6_tfclinicaid ,
                                          short AV85Sedewwds_7_tfclinicaid_to ,
                                          long AV86Sedewwds_8_tfclinicaruc ,
                                          long AV87Sedewwds_9_tfclinicaruc_to ,
                                          String AV89Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV88Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV91Sedewwds_13_tfubigeocode_sel ,
                                          String AV90Sedewwds_12_tfubigeocode ,
                                          String AV93Sedewwds_15_tfubigeonombre_sel ,
                                          String AV92Sedewwds_14_tfubigeonombre ,
                                          String AV95Sedewwds_17_tfsededireccion_sel ,
                                          String AV94Sedewwds_16_tfsededireccion ,
                                          String AV97Sedewwds_19_tfsedecorreo_sel ,
                                          String AV96Sedewwds_18_tfsedecorreo ,
                                          int AV98Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV99Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV100Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV79Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[38];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion], T3.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] AS UbigeoNombre, T1.[UbigeoCode], T2.[ClinicaNombreComercial], T1.[SedeNombre], T3.[UbigeoDepartamento]," ;
      scmdbuf += " T3.[UbigeoProvincia], T3.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode]" ;
      scmdbuf += " = T1.[UbigeoCode])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV80Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV81Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV82Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (0==AV84Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV85Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV86Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (0==AV87Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV88Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV91Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV90Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV91Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV93Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV92Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV93Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV94Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV96Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( AV98Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV98Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV99Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV99Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV100Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClinicaId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClinicaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ClinicaRUC]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ClinicaRUC] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ClinicaNombreComercial]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ClinicaNombreComercial] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeCorreo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeEstado]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeEstado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeTipo]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeTipo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeSector]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeSector] DESC" ;
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
                  return conditional_P004C2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , (String)dynConstraints[40] , (String)dynConstraints[41] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004C2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
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
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
      }
   }

}

