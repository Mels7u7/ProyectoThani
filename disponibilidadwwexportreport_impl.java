package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidadwwexportreport_impl extends GXWebReport
{
   public disponibilidadwwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad", GXv_boolean2) ;
         disponibilidadwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV105Pgmname))}, new String[] {"GxObject"}) );
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
            AV95Title = "Lista de Disponibilidad" ;
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
         h4K0( true, 0) ;
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
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFDisponibilidadId) && (0==AV21TFDisponibilidadId_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFDisponibilidadId), "ZZZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV70TFDisponibilidadId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV70TFDisponibilidadId_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFDisponibilidadId_To), "ZZZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV23TFEventId_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFEventId_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFEventId)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Id", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFEventId, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFDisponibilidadDescription_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Description", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFDisponibilidadDescription_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFDisponibilidadDescription)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Description", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFDisponibilidadDescription, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV26TFProfesionalId) && (0==AV27TFProfesionalId_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Profesional Id", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV26TFProfesionalId), "ZZZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV71TFProfesionalId_To_Description = GXutil.format( "%1 (%2)", "Profesional Id", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV71TFProfesionalId_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV27TFProfesionalId_To), "ZZZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV29TFProfesionalApellidoPaterno_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Apellido Paterno", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFProfesionalApellidoPaterno_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV28TFProfesionalApellidoPaterno)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Apellido Paterno", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFProfesionalApellidoPaterno, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV31TFProfesionalApellidoMaterno_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Apellido Materno", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFProfesionalApellidoMaterno_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFProfesionalApellidoMaterno)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Apellido Materno", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFProfesionalApellidoMaterno, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV33TFProfesionalNombres_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombres", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFProfesionalNombres_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV32TFProfesionalNombres)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombres", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFProfesionalNombres, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV35TFProfesionalNombreCompleto_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre Completo", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFProfesionalNombreCompleto_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV34TFProfesionalNombreCompleto)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre Completo", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFProfesionalNombreCompleto, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV37TFProfesionalCOP_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("CMP", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37TFProfesionalCOP_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV36TFProfesionalCOP)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("CMP", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36TFProfesionalCOP, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV38TFDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV39TFDisponibilidadFecha_To)) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Fecha", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV38TFDisponibilidadFecha, "99/99/99"), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV72TFDisponibilidadFecha_To_Description = GXutil.format( "%1 (%2)", "Fecha", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV72TFDisponibilidadFecha_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV39TFDisponibilidadFecha_To, "99/99/99"), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV40TFDisponibilidadHoraInicio) && GXutil.dateCompare(GXutil.nullDate(), AV41TFDisponibilidadHoraInicio_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Hora Inicio", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV40TFDisponibilidadHoraInicio, "99:99"), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV73TFDisponibilidadHoraInicio_To_Description = GXutil.format( "%1 (%2)", "Hora Inicio", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV73TFDisponibilidadHoraInicio_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV41TFDisponibilidadHoraInicio_To, "99:99"), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV42TFDisponibilidadHoraFin) && GXutil.dateCompare(GXutil.nullDate(), AV43TFDisponibilidadHoraFin_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Hora Fin", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV42TFDisponibilidadHoraFin, "99:99"), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV74TFDisponibilidadHoraFin_To_Description = GXutil.format( "%1 (%2)", "Hora Fin", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV74TFDisponibilidadHoraFin_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV43TFDisponibilidadHoraFin_To, "99:99"), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV44TFEspecialidadId) && (0==AV45TFEspecialidadId_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Especialidad Id", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV44TFEspecialidadId), "ZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV75TFEspecialidadId_To_Description = GXutil.format( "%1 (%2)", "Especialidad Id", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV75TFEspecialidadId_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV45TFEspecialidadId_To), "ZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV47TFEspecialidadCodigo_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Especialidad Codigo", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47TFEspecialidadCodigo_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV46TFEspecialidadCodigo)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Especialidad Codigo", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46TFEspecialidadCodigo, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV49TFEspecialidadNombre_Sel)==0) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Especialidad Nombre", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49TFEspecialidadNombre_Sel, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV48TFEspecialidadNombre)==0) )
         {
            h4K0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Especialidad Nombre", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48TFEspecialidadNombre, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV58TFDisponibilidadUser) && (0==AV59TFDisponibilidadUser_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("User", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV58TFDisponibilidadUser), "ZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV80TFDisponibilidadUser_To_Description = GXutil.format( "%1 (%2)", "User", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV80TFDisponibilidadUser_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV59TFDisponibilidadUser_To), "ZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV62TFDisponibilidadEstado_Sels.fromJSonString(AV60TFDisponibilidadEstado_SelsJson, null);
      if ( ! ( AV62TFDisponibilidadEstado_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV108GXV1 = 1 ;
         while ( AV108GXV1 <= AV62TFDisponibilidadEstado_Sels.size() )
         {
            AV63TFDisponibilidadEstado_Sel = (String)AV62TFDisponibilidadEstado_Sels.elementAt(-1+AV108GXV1) ;
            if ( AV84i == 1 )
            {
               AV61TFDisponibilidadEstado_SelDscs = "" ;
            }
            else
            {
               AV61TFDisponibilidadEstado_SelDscs += ", " ;
            }
            AV81FilterTFDisponibilidadEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV63TFDisponibilidadEstado_Sel) ;
            AV61TFDisponibilidadEstado_SelDscs += AV81FilterTFDisponibilidadEstado_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV108GXV1 = (int)(AV108GXV1+1) ;
         }
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV61TFDisponibilidadEstado_SelDscs, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV66TFDisponibilidadEstadoCita_Sels.fromJSonString(AV64TFDisponibilidadEstadoCita_SelsJson, null);
      if ( ! ( AV66TFDisponibilidadEstadoCita_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV109GXV2 = 1 ;
         while ( AV109GXV2 <= AV66TFDisponibilidadEstadoCita_Sels.size() )
         {
            AV67TFDisponibilidadEstadoCita_Sel = (String)AV66TFDisponibilidadEstadoCita_Sels.elementAt(-1+AV109GXV2) ;
            if ( AV84i == 1 )
            {
               AV65TFDisponibilidadEstadoCita_SelDscs = "" ;
            }
            else
            {
               AV65TFDisponibilidadEstadoCita_SelDscs += ", " ;
            }
            AV82FilterTFDisponibilidadEstadoCita_SelValueDescription = com.projectthani.gxdomainestadodc.getDescription(httpContext,(String)AV67TFDisponibilidadEstadoCita_Sel) ;
            AV65TFDisponibilidadEstadoCita_SelDscs += AV82FilterTFDisponibilidadEstadoCita_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV109GXV2 = (int)(AV109GXV2+1) ;
         }
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado Cita", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV65TFDisponibilidadEstadoCita_SelDscs, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV68TFDCitaId) && (0==AV69TFDCitaId_To) ) )
      {
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV68TFDCitaId), "ZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV83TFDCitaId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV83TFDCitaId_To_Description, "")), 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV69TFDCitaId_To), "ZZZZZ9")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      AV100TFDisponibilidadTipoCita_Sels.fromJSonString(AV98TFDisponibilidadTipoCita_SelsJson, null);
      if ( ! ( AV100TFDisponibilidadTipoCita_Sels.size() == 0 ) )
      {
         AV84i = 1 ;
         AV110GXV3 = 1 ;
         while ( AV110GXV3 <= AV100TFDisponibilidadTipoCita_Sels.size() )
         {
            AV101TFDisponibilidadTipoCita_Sel = (String)AV100TFDisponibilidadTipoCita_Sels.elementAt(-1+AV110GXV3) ;
            if ( AV84i == 1 )
            {
               AV99TFDisponibilidadTipoCita_SelDscs = "" ;
            }
            else
            {
               AV99TFDisponibilidadTipoCita_SelDscs += ", " ;
            }
            AV102FilterTFDisponibilidadTipoCita_SelValueDescription = com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)AV101TFDisponibilidadTipoCita_Sel) ;
            AV99TFDisponibilidadTipoCita_SelDscs += AV102FilterTFDisponibilidadTipoCita_SelValueDescription ;
            AV84i = (long)(AV84i+1) ;
            AV110GXV3 = (int)(AV110GXV3+1) ;
         }
         h4K0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Cita", 25, Gx_line+0, 136, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV99TFDisponibilidadTipoCita_SelDscs, "")), 136, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4K0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4K0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 64, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Id", 68, Gx_line+10, 102, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Description", 106, Gx_line+10, 140, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Profesional Id", 144, Gx_line+10, 178, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Apellido Paterno", 182, Gx_line+10, 216, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Apellido Materno", 220, Gx_line+10, 254, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombres", 258, Gx_line+10, 292, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre Completo", 296, Gx_line+10, 330, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("CMP", 334, Gx_line+10, 368, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Fecha", 372, Gx_line+10, 406, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Hora Inicio", 410, Gx_line+10, 444, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Hora Fin", 448, Gx_line+10, 482, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Especialidad Id", 486, Gx_line+10, 520, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Especialidad Codigo", 524, Gx_line+10, 558, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Especialidad Nombre", 562, Gx_line+10, 596, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("User", 600, Gx_line+10, 634, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 638, Gx_line+10, 672, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado Cita", 676, Gx_line+10, 710, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Id", 714, Gx_line+10, 748, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Cita", 752, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV112Disponibilidadwwds_1_filterfulltext = AV13FilterFullText ;
      AV113Disponibilidadwwds_2_tfdisponibilidadid = AV20TFDisponibilidadId ;
      AV114Disponibilidadwwds_3_tfdisponibilidadid_to = AV21TFDisponibilidadId_To ;
      AV115Disponibilidadwwds_4_tfeventid = AV22TFEventId ;
      AV116Disponibilidadwwds_5_tfeventid_sel = AV23TFEventId_Sel ;
      AV117Disponibilidadwwds_6_tfdisponibilidaddescription = AV24TFDisponibilidadDescription ;
      AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV25TFDisponibilidadDescription_Sel ;
      AV119Disponibilidadwwds_8_tfprofesionalid = AV26TFProfesionalId ;
      AV120Disponibilidadwwds_9_tfprofesionalid_to = AV27TFProfesionalId_To ;
      AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV28TFProfesionalApellidoPaterno ;
      AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV29TFProfesionalApellidoPaterno_Sel ;
      AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV30TFProfesionalApellidoMaterno ;
      AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV31TFProfesionalApellidoMaterno_Sel ;
      AV125Disponibilidadwwds_14_tfprofesionalnombres = AV32TFProfesionalNombres ;
      AV126Disponibilidadwwds_15_tfprofesionalnombres_sel = AV33TFProfesionalNombres_Sel ;
      AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV34TFProfesionalNombreCompleto ;
      AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV35TFProfesionalNombreCompleto_Sel ;
      AV129Disponibilidadwwds_18_tfprofesionalcop = AV36TFProfesionalCOP ;
      AV130Disponibilidadwwds_19_tfprofesionalcop_sel = AV37TFProfesionalCOP_Sel ;
      AV131Disponibilidadwwds_20_tfdisponibilidadfecha = AV38TFDisponibilidadFecha ;
      AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV39TFDisponibilidadFecha_To ;
      AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV40TFDisponibilidadHoraInicio ;
      AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV41TFDisponibilidadHoraInicio_To ;
      AV135Disponibilidadwwds_24_tfdisponibilidadhorafin = AV42TFDisponibilidadHoraFin ;
      AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV43TFDisponibilidadHoraFin_To ;
      AV137Disponibilidadwwds_26_tfespecialidadid = AV44TFEspecialidadId ;
      AV138Disponibilidadwwds_27_tfespecialidadid_to = AV45TFEspecialidadId_To ;
      AV139Disponibilidadwwds_28_tfespecialidadcodigo = AV46TFEspecialidadCodigo ;
      AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV47TFEspecialidadCodigo_Sel ;
      AV141Disponibilidadwwds_30_tfespecialidadnombre = AV48TFEspecialidadNombre ;
      AV142Disponibilidadwwds_31_tfespecialidadnombre_sel = AV49TFEspecialidadNombre_Sel ;
      AV143Disponibilidadwwds_32_tfdisponibilidaduser = AV58TFDisponibilidadUser ;
      AV144Disponibilidadwwds_33_tfdisponibilidaduser_to = AV59TFDisponibilidadUser_To ;
      AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV62TFDisponibilidadEstado_Sels ;
      AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV66TFDisponibilidadEstadoCita_Sels ;
      AV147Disponibilidadwwds_36_tfdcitaid = AV68TFDCitaId ;
      AV148Disponibilidadwwds_37_tfdcitaid_to = AV69TFDCitaId_To ;
      AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV100TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV113Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV116Disponibilidadwwds_5_tfeventid_sel ,
                                           AV115Disponibilidadwwds_4_tfeventid ,
                                           AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV117Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV119Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV120Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV126Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV125Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV130Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV129Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV131Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV135Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV137Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV138Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV139Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV142Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV141Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV143Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV144Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV112Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV147Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV148Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV112Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV115Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV115Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV117Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV117Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV121Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV123Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV125Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV125Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV127Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV129Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV129Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV139Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV139Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV141Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV141Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P004K3 */
      pr_default.execute(0, new Object[] {AV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, lV112Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV147Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV147Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV148Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV148Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV113Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV114Disponibilidadwwds_3_tfdisponibilidadid_to), lV115Disponibilidadwwds_4_tfeventid, AV116Disponibilidadwwds_5_tfeventid_sel, lV117Disponibilidadwwds_6_tfdisponibilidaddescription, AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV119Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV120Disponibilidadwwds_9_tfprofesionalid_to), lV121Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV123Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV125Disponibilidadwwds_14_tfprofesionalnombres, AV126Disponibilidadwwds_15_tfprofesionalnombres_sel, lV127Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV129Disponibilidadwwds_18_tfprofesionalcop, AV130Disponibilidadwwds_19_tfprofesionalcop_sel, AV131Disponibilidadwwds_20_tfdisponibilidadfecha, AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV135Disponibilidadwwds_24_tfdisponibilidadhorafin, AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV137Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV138Disponibilidadwwds_27_tfespecialidadid_to), lV139Disponibilidadwwds_28_tfespecialidadcodigo, AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV141Disponibilidadwwds_30_tfespecialidadnombre, AV142Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV143Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV144Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A137DisponibilidadUser = P004K3_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P004K3_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P004K3_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P004K3_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P004K3_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P004K3_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P004K3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P004K3_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P004K3_A31ProfesionalId[0] ;
         A34DisponibilidadId = P004K3_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P004K3_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P004K3_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P004K3_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P004K3_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P004K3_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P004K3_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P004K3_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P004K3_A134DisponibilidadDescription[0] ;
         A133EventId = P004K3_A133EventId[0] ;
         A138DCitaId = P004K3_A138DCitaId[0] ;
         n138DCitaId = P004K3_n138DCitaId[0] ;
         A84ProfesionalNombres = P004K3_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004K3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004K3_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P004K3_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P004K3_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P004K3_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P004K3_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004K3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004K3_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P004K3_A138DCitaId[0] ;
         n138DCitaId = P004K3_n138DCitaId[0] ;
         AV14DisponibilidadEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A136DisponibilidadEstado) ;
         AV15DisponibilidadEstadoCitaDescription = com.projectthani.gxdomainestadodc.getDescription(httpContext,(String)A139DisponibilidadEstadoCita) ;
         AV97DisponibilidadTipoCitaDescription = com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)A298DisponibilidadTipoCita) ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
         h4K0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")), 30, Gx_line+10, 64, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A133EventId, "")), 68, Gx_line+10, 102, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A134DisponibilidadDescription, "")), 106, Gx_line+10, 140, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9")), 144, Gx_line+10, 178, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A85ProfesionalApellidoPaterno, "")), 182, Gx_line+10, 216, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A86ProfesionalApellidoMaterno, "")), 220, Gx_line+10, 254, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A84ProfesionalNombres, "")), 258, Gx_line+10, 292, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A83ProfesionalNombreCompleto, "")), 296, Gx_line+10, 330, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A88ProfesionalCOP, "")), 334, Gx_line+10, 368, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A67DisponibilidadFecha, "99/99/99"), 372, Gx_line+10, 406, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A69DisponibilidadHoraInicio, "99:99"), 410, Gx_line+10, 444, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A135DisponibilidadHoraFin, "99:99"), 448, Gx_line+10, 482, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9")), 486, Gx_line+10, 520, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A140EspecialidadCodigo, "")), 524, Gx_line+10, 558, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A71EspecialidadNombre, "")), 562, Gx_line+10, 596, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9")), 600, Gx_line+10, 634, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14DisponibilidadEstadoDescription, "")), 638, Gx_line+10, 672, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15DisponibilidadEstadoCitaDescription, "")), 676, Gx_line+10, 710, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9")), 714, Gx_line+10, 748, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV97DisponibilidadTipoCitaDescription, "")), 752, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV16Session.getValue("DisponibilidadWWGridState"), "") == 0 )
      {
         AV18GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DisponibilidadWWGridState"), null, null);
      }
      else
      {
         AV18GridState.fromxml(AV16Session.getValue("DisponibilidadWWGridState"), null, null);
      }
      AV11OrderedBy = AV18GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV18GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV150GXV4 = 1 ;
      while ( AV150GXV4 <= AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV19GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV150GXV4));
         if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV20TFDisponibilidadId = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFDisponibilidadId_To = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID") == 0 )
         {
            AV22TFEventId = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID_SEL") == 0 )
         {
            AV23TFEventId_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION") == 0 )
         {
            AV24TFDisponibilidadDescription = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION_SEL") == 0 )
         {
            AV25TFDisponibilidadDescription_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV26TFProfesionalId = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV27TFProfesionalId_To = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV28TFProfesionalApellidoPaterno = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV29TFProfesionalApellidoPaterno_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV30TFProfesionalApellidoMaterno = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV31TFProfesionalApellidoMaterno_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV32TFProfesionalNombres = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV33TFProfesionalNombres_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO") == 0 )
         {
            AV34TFProfesionalNombreCompleto = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO_SEL") == 0 )
         {
            AV35TFProfesionalNombreCompleto_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV36TFProfesionalCOP = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV37TFProfesionalCOP_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADFECHA") == 0 )
         {
            AV38TFDisponibilidadFecha = localUtil.ctod( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV39TFDisponibilidadFecha_To = localUtil.ctod( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAINICIO") == 0 )
         {
            AV40TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV41TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAFIN") == 0 )
         {
            AV42TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV43TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV44TFEspecialidadId = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV45TFEspecialidadId_To = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV46TFEspecialidadCodigo = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV47TFEspecialidadCodigo_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV48TFEspecialidadNombre = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV49TFEspecialidadNombre_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADUSER") == 0 )
         {
            AV58TFDisponibilidadUser = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV59TFDisponibilidadUser_To = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADO_SEL") == 0 )
         {
            AV60TFDisponibilidadEstado_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV62TFDisponibilidadEstado_Sels.fromJSonString(AV60TFDisponibilidadEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADOCITA_SEL") == 0 )
         {
            AV64TFDisponibilidadEstadoCita_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFDisponibilidadEstadoCita_Sels.fromJSonString(AV64TFDisponibilidadEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCITAID") == 0 )
         {
            AV68TFDCitaId = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV69TFDCitaId_To = (int)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADTIPOCITA_SEL") == 0 )
         {
            AV98TFDisponibilidadTipoCita_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV100TFDisponibilidadTipoCita_Sels.fromJSonString(AV98TFDisponibilidadTipoCita_SelsJson, null);
         }
         AV150GXV4 = (int)(AV150GXV4+1) ;
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

   public void h4K0( boolean bFoot ,
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
               AV93PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV90DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV93PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV90DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV88AppName = "DVelop Software Solutions" ;
            AV94Phone = "+1 550 8923" ;
            AV92Mail = "info@mail.com" ;
            AV96Website = "http://www.web.com" ;
            AV85AddressLine1 = "French Boulevard 2859" ;
            AV86AddressLine2 = "Downtown" ;
            AV87AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV88AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV95Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV94Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV92Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV96Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV85AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV86AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV87AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV105Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV95Title = "" ;
      AV13FilterFullText = "" ;
      AV70TFDisponibilidadId_To_Description = "" ;
      AV23TFEventId_Sel = "" ;
      AV22TFEventId = "" ;
      AV25TFDisponibilidadDescription_Sel = "" ;
      AV24TFDisponibilidadDescription = "" ;
      AV71TFProfesionalId_To_Description = "" ;
      AV29TFProfesionalApellidoPaterno_Sel = "" ;
      AV28TFProfesionalApellidoPaterno = "" ;
      AV31TFProfesionalApellidoMaterno_Sel = "" ;
      AV30TFProfesionalApellidoMaterno = "" ;
      AV33TFProfesionalNombres_Sel = "" ;
      AV32TFProfesionalNombres = "" ;
      AV35TFProfesionalNombreCompleto_Sel = "" ;
      AV34TFProfesionalNombreCompleto = "" ;
      AV37TFProfesionalCOP_Sel = "" ;
      AV36TFProfesionalCOP = "" ;
      AV38TFDisponibilidadFecha = GXutil.nullDate() ;
      AV39TFDisponibilidadFecha_To = GXutil.nullDate() ;
      AV72TFDisponibilidadFecha_To_Description = "" ;
      AV40TFDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV41TFDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV73TFDisponibilidadHoraInicio_To_Description = "" ;
      AV42TFDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV43TFDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV74TFDisponibilidadHoraFin_To_Description = "" ;
      AV75TFEspecialidadId_To_Description = "" ;
      AV47TFEspecialidadCodigo_Sel = "" ;
      AV46TFEspecialidadCodigo = "" ;
      AV49TFEspecialidadNombre_Sel = "" ;
      AV48TFEspecialidadNombre = "" ;
      AV80TFDisponibilidadUser_To_Description = "" ;
      AV62TFDisponibilidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFDisponibilidadEstado_SelsJson = "" ;
      AV63TFDisponibilidadEstado_Sel = "" ;
      AV61TFDisponibilidadEstado_SelDscs = "" ;
      AV81FilterTFDisponibilidadEstado_SelValueDescription = "" ;
      AV66TFDisponibilidadEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFDisponibilidadEstadoCita_SelsJson = "" ;
      AV67TFDisponibilidadEstadoCita_Sel = "" ;
      AV65TFDisponibilidadEstadoCita_SelDscs = "" ;
      AV82FilterTFDisponibilidadEstadoCita_SelValueDescription = "" ;
      AV83TFDCitaId_To_Description = "" ;
      AV100TFDisponibilidadTipoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98TFDisponibilidadTipoCita_SelsJson = "" ;
      AV101TFDisponibilidadTipoCita_Sel = "" ;
      AV99TFDisponibilidadTipoCita_SelDscs = "" ;
      AV102FilterTFDisponibilidadTipoCita_SelValueDescription = "" ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A83ProfesionalNombreCompleto = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      AV112Disponibilidadwwds_1_filterfulltext = "" ;
      AV115Disponibilidadwwds_4_tfeventid = "" ;
      AV116Disponibilidadwwds_5_tfeventid_sel = "" ;
      AV117Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel = "" ;
      AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = "" ;
      AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = "" ;
      AV125Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      AV126Disponibilidadwwds_15_tfprofesionalnombres_sel = "" ;
      AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = "" ;
      AV129Disponibilidadwwds_18_tfprofesionalcop = "" ;
      AV130Disponibilidadwwds_19_tfprofesionalcop_sel = "" ;
      AV131Disponibilidadwwds_20_tfdisponibilidadfecha = GXutil.nullDate() ;
      AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to = GXutil.nullDate() ;
      AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV135Disponibilidadwwds_24_tfdisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV139Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel = "" ;
      AV141Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      AV142Disponibilidadwwds_31_tfespecialidadnombre_sel = "" ;
      AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV112Disponibilidadwwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV115Disponibilidadwwds_4_tfeventid = "" ;
      lV117Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      lV121Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      lV123Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      lV125Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      lV127Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      lV129Disponibilidadwwds_18_tfprofesionalcop = "" ;
      lV139Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      lV141Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      P004K3_A137DisponibilidadUser = new int[1] ;
      P004K3_A32EspecialidadId = new short[1] ;
      P004K3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P004K3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P004K3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P004K3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P004K3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004K3_n67DisponibilidadFecha = new boolean[] {false} ;
      P004K3_A31ProfesionalId = new int[1] ;
      P004K3_A34DisponibilidadId = new int[1] ;
      P004K3_A298DisponibilidadTipoCita = new String[] {""} ;
      P004K3_A139DisponibilidadEstadoCita = new String[] {""} ;
      P004K3_A136DisponibilidadEstado = new String[] {""} ;
      P004K3_A71EspecialidadNombre = new String[] {""} ;
      P004K3_A140EspecialidadCodigo = new String[] {""} ;
      P004K3_A88ProfesionalCOP = new String[] {""} ;
      P004K3_A83ProfesionalNombreCompleto = new String[] {""} ;
      P004K3_A134DisponibilidadDescription = new String[] {""} ;
      P004K3_A133EventId = new String[] {""} ;
      P004K3_A138DCitaId = new int[1] ;
      P004K3_n138DCitaId = new boolean[] {false} ;
      P004K3_A84ProfesionalNombres = new String[] {""} ;
      P004K3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P004K3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      AV14DisponibilidadEstadoDescription = "" ;
      AV15DisponibilidadEstadoCitaDescription = "" ;
      AV97DisponibilidadTipoCitaDescription = "" ;
      AV16Session = httpContext.getWebSession();
      AV18GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV19GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV93PageInfo = "" ;
      AV90DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV88AppName = "" ;
      AV94Phone = "" ;
      AV92Mail = "" ;
      AV96Website = "" ;
      AV85AddressLine1 = "" ;
      AV86AddressLine2 = "" ;
      AV87AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadwwexportreport__default(),
         new Object[] {
             new Object[] {
            P004K3_A137DisponibilidadUser, P004K3_A32EspecialidadId, P004K3_A135DisponibilidadHoraFin, P004K3_n135DisponibilidadHoraFin, P004K3_A69DisponibilidadHoraInicio, P004K3_n69DisponibilidadHoraInicio, P004K3_A67DisponibilidadFecha, P004K3_n67DisponibilidadFecha, P004K3_A31ProfesionalId, P004K3_A34DisponibilidadId,
            P004K3_A298DisponibilidadTipoCita, P004K3_A139DisponibilidadEstadoCita, P004K3_A136DisponibilidadEstado, P004K3_A71EspecialidadNombre, P004K3_A140EspecialidadCodigo, P004K3_A88ProfesionalCOP, P004K3_A83ProfesionalNombreCompleto, P004K3_A134DisponibilidadDescription, P004K3_A133EventId, P004K3_A138DCitaId,
            P004K3_n138DCitaId, P004K3_A84ProfesionalNombres, P004K3_A85ProfesionalApellidoPaterno, P004K3_A86ProfesionalApellidoMaterno
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV105Pgmname = "DisponibilidadWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV105Pgmname = "DisponibilidadWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV44TFEspecialidadId ;
   private short AV45TFEspecialidadId_To ;
   private short A32EspecialidadId ;
   private short AV137Disponibilidadwwds_26_tfespecialidadid ;
   private short AV138Disponibilidadwwds_27_tfespecialidadid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV20TFDisponibilidadId ;
   private int AV21TFDisponibilidadId_To ;
   private int AV26TFProfesionalId ;
   private int AV27TFProfesionalId_To ;
   private int AV58TFDisponibilidadUser ;
   private int AV59TFDisponibilidadUser_To ;
   private int AV108GXV1 ;
   private int AV109GXV2 ;
   private int AV68TFDCitaId ;
   private int AV69TFDCitaId_To ;
   private int AV110GXV3 ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int A137DisponibilidadUser ;
   private int A138DCitaId ;
   private int AV113Disponibilidadwwds_2_tfdisponibilidadid ;
   private int AV114Disponibilidadwwds_3_tfdisponibilidadid_to ;
   private int AV119Disponibilidadwwds_8_tfprofesionalid ;
   private int AV120Disponibilidadwwds_9_tfprofesionalid_to ;
   private int AV143Disponibilidadwwds_32_tfdisponibilidaduser ;
   private int AV144Disponibilidadwwds_33_tfdisponibilidaduser_to ;
   private int AV147Disponibilidadwwds_36_tfdcitaid ;
   private int AV148Disponibilidadwwds_37_tfdcitaid_to ;
   private int AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ;
   private int AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ;
   private int AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ;
   private int AV150GXV4 ;
   private long AV84i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV105Pgmname ;
   private String AV23TFEventId_Sel ;
   private String AV22TFEventId ;
   private String AV63TFDisponibilidadEstado_Sel ;
   private String AV101TFDisponibilidadTipoCita_Sel ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private String A133EventId ;
   private String AV115Disponibilidadwwds_4_tfeventid ;
   private String AV116Disponibilidadwwds_5_tfeventid_sel ;
   private String scmdbuf ;
   private String lV115Disponibilidadwwds_4_tfeventid ;
   private java.util.Date AV40TFDisponibilidadHoraInicio ;
   private java.util.Date AV41TFDisponibilidadHoraInicio_To ;
   private java.util.Date AV42TFDisponibilidadHoraFin ;
   private java.util.Date AV43TFDisponibilidadHoraFin_To ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio ;
   private java.util.Date AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ;
   private java.util.Date AV135Disponibilidadwwds_24_tfdisponibilidadhorafin ;
   private java.util.Date AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to ;
   private java.util.Date AV38TFDisponibilidadFecha ;
   private java.util.Date AV39TFDisponibilidadFecha_To ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV131Disponibilidadwwds_20_tfdisponibilidadfecha ;
   private java.util.Date AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n67DisponibilidadFecha ;
   private boolean n138DCitaId ;
   private String AV60TFDisponibilidadEstado_SelsJson ;
   private String AV64TFDisponibilidadEstadoCita_SelsJson ;
   private String AV98TFDisponibilidadTipoCita_SelsJson ;
   private String AV95Title ;
   private String AV13FilterFullText ;
   private String AV70TFDisponibilidadId_To_Description ;
   private String AV25TFDisponibilidadDescription_Sel ;
   private String AV24TFDisponibilidadDescription ;
   private String AV71TFProfesionalId_To_Description ;
   private String AV29TFProfesionalApellidoPaterno_Sel ;
   private String AV28TFProfesionalApellidoPaterno ;
   private String AV31TFProfesionalApellidoMaterno_Sel ;
   private String AV30TFProfesionalApellidoMaterno ;
   private String AV33TFProfesionalNombres_Sel ;
   private String AV32TFProfesionalNombres ;
   private String AV35TFProfesionalNombreCompleto_Sel ;
   private String AV34TFProfesionalNombreCompleto ;
   private String AV37TFProfesionalCOP_Sel ;
   private String AV36TFProfesionalCOP ;
   private String AV72TFDisponibilidadFecha_To_Description ;
   private String AV73TFDisponibilidadHoraInicio_To_Description ;
   private String AV74TFDisponibilidadHoraFin_To_Description ;
   private String AV75TFEspecialidadId_To_Description ;
   private String AV47TFEspecialidadCodigo_Sel ;
   private String AV46TFEspecialidadCodigo ;
   private String AV49TFEspecialidadNombre_Sel ;
   private String AV48TFEspecialidadNombre ;
   private String AV80TFDisponibilidadUser_To_Description ;
   private String AV61TFDisponibilidadEstado_SelDscs ;
   private String AV81FilterTFDisponibilidadEstado_SelValueDescription ;
   private String AV67TFDisponibilidadEstadoCita_Sel ;
   private String AV65TFDisponibilidadEstadoCita_SelDscs ;
   private String AV82FilterTFDisponibilidadEstadoCita_SelValueDescription ;
   private String AV83TFDCitaId_To_Description ;
   private String AV99TFDisponibilidadTipoCita_SelDscs ;
   private String AV102FilterTFDisponibilidadTipoCita_SelValueDescription ;
   private String A139DisponibilidadEstadoCita ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String AV112Disponibilidadwwds_1_filterfulltext ;
   private String AV117Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel ;
   private String AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ;
   private String AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ;
   private String AV125Disponibilidadwwds_14_tfprofesionalnombres ;
   private String AV126Disponibilidadwwds_15_tfprofesionalnombres_sel ;
   private String AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ;
   private String AV129Disponibilidadwwds_18_tfprofesionalcop ;
   private String AV130Disponibilidadwwds_19_tfprofesionalcop_sel ;
   private String AV139Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel ;
   private String AV141Disponibilidadwwds_30_tfespecialidadnombre ;
   private String AV142Disponibilidadwwds_31_tfespecialidadnombre_sel ;
   private String lV112Disponibilidadwwds_1_filterfulltext ;
   private String lV117Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String lV121Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String lV123Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String lV125Disponibilidadwwds_14_tfprofesionalnombres ;
   private String lV127Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String lV129Disponibilidadwwds_18_tfprofesionalcop ;
   private String lV139Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String lV141Disponibilidadwwds_30_tfespecialidadnombre ;
   private String AV14DisponibilidadEstadoDescription ;
   private String AV15DisponibilidadEstadoCitaDescription ;
   private String AV97DisponibilidadTipoCitaDescription ;
   private String AV93PageInfo ;
   private String AV90DateInfo ;
   private String AV88AppName ;
   private String AV94Phone ;
   private String AV92Mail ;
   private String AV96Website ;
   private String AV85AddressLine1 ;
   private String AV86AddressLine2 ;
   private String AV87AddressLine3 ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private IDataStoreProvider pr_default ;
   private int[] P004K3_A137DisponibilidadUser ;
   private short[] P004K3_A32EspecialidadId ;
   private java.util.Date[] P004K3_A135DisponibilidadHoraFin ;
   private boolean[] P004K3_n135DisponibilidadHoraFin ;
   private java.util.Date[] P004K3_A69DisponibilidadHoraInicio ;
   private boolean[] P004K3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P004K3_A67DisponibilidadFecha ;
   private boolean[] P004K3_n67DisponibilidadFecha ;
   private int[] P004K3_A31ProfesionalId ;
   private int[] P004K3_A34DisponibilidadId ;
   private String[] P004K3_A298DisponibilidadTipoCita ;
   private String[] P004K3_A139DisponibilidadEstadoCita ;
   private String[] P004K3_A136DisponibilidadEstado ;
   private String[] P004K3_A71EspecialidadNombre ;
   private String[] P004K3_A140EspecialidadCodigo ;
   private String[] P004K3_A88ProfesionalCOP ;
   private String[] P004K3_A83ProfesionalNombreCompleto ;
   private String[] P004K3_A134DisponibilidadDescription ;
   private String[] P004K3_A133EventId ;
   private int[] P004K3_A138DCitaId ;
   private boolean[] P004K3_n138DCitaId ;
   private String[] P004K3_A84ProfesionalNombres ;
   private String[] P004K3_A85ProfesionalApellidoPaterno ;
   private String[] P004K3_A86ProfesionalApellidoMaterno ;
   private GXSimpleCollection<String> AV62TFDisponibilidadEstado_Sels ;
   private GXSimpleCollection<String> AV100TFDisponibilidadTipoCita_Sels ;
   private GXSimpleCollection<String> AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels ;
   private GXSimpleCollection<String> AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ;
   private GXSimpleCollection<String> AV66TFDisponibilidadEstadoCita_Sels ;
   private GXSimpleCollection<String> AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV18GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV19GridStateFilterValue ;
}

final  class disponibilidadwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004K3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV113Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV114Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV116Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV115Disponibilidadwwds_4_tfeventid ,
                                          String AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV117Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV119Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV120Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV126Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV125Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV130Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV129Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV131Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV135Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV137Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV138Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV139Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV142Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV141Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV143Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV144Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV112Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV147Disponibilidadwwds_36_tfdcitaid ,
                                          int AV148Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[59];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId], T1.[DisponibilidadId]," ;
      scmdbuf += " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T3.[ProfesionalCOP], T3.[ProfesionalNombres]" ;
      scmdbuf += " + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription], T1.[EventId], COALESCE(" ;
      scmdbuf += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad]" ;
      scmdbuf += " T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId," ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY" ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV113Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV115Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV117Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( ! (0==AV119Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (0==AV120Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV121Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV122Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV123Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV125Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV127Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV129Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV131Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV132Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV135Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV136Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (0==AV137Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( ! (0==AV138Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV139Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV140Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV142Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV141Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV142Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( ! (0==AV143Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( ! (0==AV144Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV145Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV146Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV149Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EventId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EventId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadDescription]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadDescription] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalNombres]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadFecha]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EspecialidadId]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EspecialidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadCodigo]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadCodigo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadUser]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadUser] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstado]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstadoCita]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstadoCita] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadTipoCita]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadTipoCita] DESC" ;
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
                  return conditional_P004K3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).shortValue() , ((Boolean) dynConstraints[57]).booleanValue() , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , ((Number) dynConstraints[62]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004K3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
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
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
      }
   }

}

