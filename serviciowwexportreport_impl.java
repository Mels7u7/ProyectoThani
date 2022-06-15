package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class serviciowwexportreport_impl extends GXWebReport
{
   public serviciowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio", GXv_boolean2) ;
         serviciowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV62Pgmname))}, new String[] {"GxObject"}) );
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
            AV58Title = "Lista de Servicio" ;
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
         h580( true, 0) ;
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
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV19TFServicioId) && (0==AV20TFServicioId_To) ) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFServicioId), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV41TFServicioId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFServicioId_To_Description, "")), 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFServicioId_To), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV22TFServicioNombre_Sel)==0) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFServicioNombre_Sel, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFServicioNombre)==0) )
         {
            h580( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFServicioNombre, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV24TFServicioDescripcion_Sel)==0) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFServicioDescripcion_Sel, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFServicioDescripcion)==0) )
         {
            h580( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFServicioDescripcion, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFServicioCosto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFServicioCosto_To)==0) ) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Costo", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV25TFServicioCosto, "ZZ9.99")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV42TFServicioCosto_To_Description = GXutil.format( "%1 (%2)", "Costo", "Hasta", "", "", "", "", "", "", "") ;
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFServicioCosto_To_Description, "")), 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV26TFServicioCosto_To, "ZZ9.99")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV27TFServicioCategId) && (0==AV28TFServicioCategId_To) ) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Servicio Categ Id", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV27TFServicioCategId), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV43TFServicioCategId_To_Description = GXutil.format( "%1 (%2)", "Servicio Categ Id", "Hasta", "", "", "", "", "", "", "") ;
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFServicioCategId_To_Description, "")), 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV28TFServicioCategId_To), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV29TFLaboratorioId) && (0==AV30TFLaboratorioId_To) ) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Laboratorio Id", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV29TFLaboratorioId), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV44TFLaboratorioId_To_Description = GXutil.format( "%1 (%2)", "Laboratorio Id", "Hasta", "", "", "", "", "", "", "") ;
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFLaboratorioId_To_Description, "")), 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV30TFLaboratorioId_To), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV32TFLaboratorioNombre_Sel)==0) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Laboratorio Nombre", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFLaboratorioNombre_Sel, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV31TFLaboratorioNombre)==0) )
         {
            h580( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Laboratorio Nombre", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFLaboratorioNombre, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV33TFServicioComision) && (0==AV34TFServicioComision_To) ) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Comision", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV33TFServicioComision), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV45TFServicioComision_To_Description = GXutil.format( "%1 (%2)", "Comision", "Hasta", "", "", "", "", "", "", "") ;
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45TFServicioComision_To_Description, "")), 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV34TFServicioComision_To), "ZZZ9")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV36TFServicioObservacion_Sel)==0) )
      {
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Observacion", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36TFServicioObservacion_Sel, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV35TFServicioObservacion)==0) )
         {
            h580( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Observacion", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFServicioObservacion, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV39TFServicioEstado_Sels.fromJSonString(AV37TFServicioEstado_SelsJson, null);
      if ( ! ( AV39TFServicioEstado_Sels.size() == 0 ) )
      {
         AV47i = 1 ;
         AV65GXV1 = 1 ;
         while ( AV65GXV1 <= AV39TFServicioEstado_Sels.size() )
         {
            AV40TFServicioEstado_Sel = (String)AV39TFServicioEstado_Sels.elementAt(-1+AV65GXV1) ;
            if ( AV47i == 1 )
            {
               AV38TFServicioEstado_SelDscs = "" ;
            }
            else
            {
               AV38TFServicioEstado_SelDscs += ", " ;
            }
            AV46FilterTFServicioEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV40TFServicioEstado_Sel) ;
            AV38TFServicioEstado_SelDscs += AV46FilterTFServicioEstado_SelValueDescription ;
            AV47i = (long)(AV47i+1) ;
            AV65GXV1 = (int)(AV65GXV1+1) ;
         }
         h580( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 139, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFServicioEstado_SelDscs, "")), 139, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h580( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h580( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 102, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 106, Gx_line+10, 178, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 182, Gx_line+10, 254, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Costo", 258, Gx_line+10, 330, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Servicio Categ Id", 334, Gx_line+10, 406, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Laboratorio Id", 410, Gx_line+10, 482, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Laboratorio Nombre", 486, Gx_line+10, 558, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Comision", 562, Gx_line+10, 634, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Observacion", 638, Gx_line+10, 710, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 714, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV67Serviciowwds_1_filterfulltext = AV13FilterFullText ;
      AV68Serviciowwds_2_tfservicioid = AV19TFServicioId ;
      AV69Serviciowwds_3_tfservicioid_to = AV20TFServicioId_To ;
      AV70Serviciowwds_4_tfservicionombre = AV21TFServicioNombre ;
      AV71Serviciowwds_5_tfservicionombre_sel = AV22TFServicioNombre_Sel ;
      AV72Serviciowwds_6_tfserviciodescripcion = AV23TFServicioDescripcion ;
      AV73Serviciowwds_7_tfserviciodescripcion_sel = AV24TFServicioDescripcion_Sel ;
      AV74Serviciowwds_8_tfserviciocosto = AV25TFServicioCosto ;
      AV75Serviciowwds_9_tfserviciocosto_to = AV26TFServicioCosto_To ;
      AV76Serviciowwds_10_tfserviciocategid = AV27TFServicioCategId ;
      AV77Serviciowwds_11_tfserviciocategid_to = AV28TFServicioCategId_To ;
      AV78Serviciowwds_12_tflaboratorioid = AV29TFLaboratorioId ;
      AV79Serviciowwds_13_tflaboratorioid_to = AV30TFLaboratorioId_To ;
      AV80Serviciowwds_14_tflaboratorionombre = AV31TFLaboratorioNombre ;
      AV81Serviciowwds_15_tflaboratorionombre_sel = AV32TFLaboratorioNombre_Sel ;
      AV82Serviciowwds_16_tfserviciocomision = AV33TFServicioComision ;
      AV83Serviciowwds_17_tfserviciocomision_to = AV34TFServicioComision_To ;
      AV84Serviciowwds_18_tfservicioobservacion = AV35TFServicioObservacion ;
      AV85Serviciowwds_19_tfservicioobservacion_sel = AV36TFServicioObservacion_Sel ;
      AV86Serviciowwds_20_tfservicioestado_sels = AV39TFServicioEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV86Serviciowwds_20_tfservicioestado_sels ,
                                           AV67Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV68Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV69Serviciowwds_3_tfservicioid_to) ,
                                           AV71Serviciowwds_5_tfservicionombre_sel ,
                                           AV70Serviciowwds_4_tfservicionombre ,
                                           AV73Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV72Serviciowwds_6_tfserviciodescripcion ,
                                           AV74Serviciowwds_8_tfserviciocosto ,
                                           AV75Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV76Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV77Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV78Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV79Serviciowwds_13_tflaboratorioid_to) ,
                                           AV81Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV80Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV82Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV83Serviciowwds_17_tfserviciocomision_to) ,
                                           AV85Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV84Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV86Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV67Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_1_filterfulltext), "%", "") ;
      lV70Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV70Serviciowwds_4_tfservicionombre), "%", "") ;
      lV72Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV72Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV80Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV80Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV84Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV84Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor P00582 */
      pr_default.execute(0, new Object[] {lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, lV67Serviciowwds_1_filterfulltext, Short.valueOf(AV68Serviciowwds_2_tfservicioid), Short.valueOf(AV69Serviciowwds_3_tfservicioid_to), lV70Serviciowwds_4_tfservicionombre, AV71Serviciowwds_5_tfservicionombre_sel, lV72Serviciowwds_6_tfserviciodescripcion, AV73Serviciowwds_7_tfserviciodescripcion_sel, AV74Serviciowwds_8_tfserviciocosto, AV75Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV76Serviciowwds_10_tfserviciocategid), Short.valueOf(AV77Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV78Serviciowwds_12_tflaboratorioid), Short.valueOf(AV79Serviciowwds_13_tflaboratorioid_to), lV80Serviciowwds_14_tflaboratorionombre, AV81Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV82Serviciowwds_16_tfserviciocomision), Short.valueOf(AV83Serviciowwds_17_tfserviciocomision_to), lV84Serviciowwds_18_tfservicioobservacion, AV85Serviciowwds_19_tfservicioobservacion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A284ServicioComision = P00582_A284ServicioComision[0] ;
         A40LaboratorioId = P00582_A40LaboratorioId[0] ;
         A52ServicioCategId = P00582_A52ServicioCategId[0] ;
         A283ServicioCosto = P00582_A283ServicioCosto[0] ;
         A27ServicioId = P00582_A27ServicioId[0] ;
         A286ServicioEstado = P00582_A286ServicioEstado[0] ;
         A285ServicioObservacion = P00582_A285ServicioObservacion[0] ;
         A165LaboratorioNombre = P00582_A165LaboratorioNombre[0] ;
         A282ServicioDescripcion = P00582_A282ServicioDescripcion[0] ;
         A281ServicioNombre = P00582_A281ServicioNombre[0] ;
         A40LaboratorioId = P00582_A40LaboratorioId[0] ;
         A165LaboratorioNombre = P00582_A165LaboratorioNombre[0] ;
         AV14ServicioEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A286ServicioEstado) ;
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
         h580( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9")), 30, Gx_line+10, 102, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A281ServicioNombre, "")), 106, Gx_line+10, 178, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A282ServicioDescripcion, "")), 182, Gx_line+10, 254, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A283ServicioCosto, "ZZ9.99")), 258, Gx_line+10, 330, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9")), 334, Gx_line+10, 406, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9")), 410, Gx_line+10, 482, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A165LaboratorioNombre, "")), 486, Gx_line+10, 558, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A284ServicioComision), "ZZZ9")), 562, Gx_line+10, 634, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A285ServicioObservacion, "")), 638, Gx_line+10, 710, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14ServicioEstadoDescription, "")), 714, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV15Session.getValue("ServicioWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ServicioWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("ServicioWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV87GXV2 = 1 ;
      while ( AV87GXV2 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV87GXV2));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOID") == 0 )
         {
            AV19TFServicioId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFServicioId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE") == 0 )
         {
            AV21TFServicioNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE_SEL") == 0 )
         {
            AV22TFServicioNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION") == 0 )
         {
            AV23TFServicioDescripcion = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION_SEL") == 0 )
         {
            AV24TFServicioDescripcion_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOSTO") == 0 )
         {
            AV25TFServicioCosto = CommonUtil.decimalVal( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV26TFServicioCosto_To = CommonUtil.decimalVal( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGID") == 0 )
         {
            AV27TFServicioCategId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV28TFServicioCategId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV29TFLaboratorioId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV30TFLaboratorioId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV31TFLaboratorioNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV32TFLaboratorioNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOMISION") == 0 )
         {
            AV33TFServicioComision = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV34TFServicioComision_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION") == 0 )
         {
            AV35TFServicioObservacion = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION_SEL") == 0 )
         {
            AV36TFServicioObservacion_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOESTADO_SEL") == 0 )
         {
            AV37TFServicioEstado_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFServicioEstado_Sels.fromJSonString(AV37TFServicioEstado_SelsJson, null);
         }
         AV87GXV2 = (int)(AV87GXV2+1) ;
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

   public void h580( boolean bFoot ,
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
               AV56PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV53DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV56PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV51AppName = "DVelop Software Solutions" ;
            AV57Phone = "+1 550 8923" ;
            AV55Mail = "info@mail.com" ;
            AV59Website = "http://www.web.com" ;
            AV48AddressLine1 = "French Boulevard 2859" ;
            AV49AddressLine2 = "Downtown" ;
            AV50AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV58Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV57Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV55Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV59Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV58Title = "" ;
      AV13FilterFullText = "" ;
      AV41TFServicioId_To_Description = "" ;
      AV22TFServicioNombre_Sel = "" ;
      AV21TFServicioNombre = "" ;
      AV24TFServicioDescripcion_Sel = "" ;
      AV23TFServicioDescripcion = "" ;
      AV25TFServicioCosto = DecimalUtil.ZERO ;
      AV26TFServicioCosto_To = DecimalUtil.ZERO ;
      AV42TFServicioCosto_To_Description = "" ;
      AV43TFServicioCategId_To_Description = "" ;
      AV44TFLaboratorioId_To_Description = "" ;
      AV32TFLaboratorioNombre_Sel = "" ;
      AV31TFLaboratorioNombre = "" ;
      AV45TFServicioComision_To_Description = "" ;
      AV36TFServicioObservacion_Sel = "" ;
      AV35TFServicioObservacion = "" ;
      AV39TFServicioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFServicioEstado_SelsJson = "" ;
      AV40TFServicioEstado_Sel = "" ;
      AV38TFServicioEstado_SelDscs = "" ;
      AV46FilterTFServicioEstado_SelValueDescription = "" ;
      A286ServicioEstado = "" ;
      A281ServicioNombre = "" ;
      A282ServicioDescripcion = "" ;
      A283ServicioCosto = DecimalUtil.ZERO ;
      A165LaboratorioNombre = "" ;
      A285ServicioObservacion = "" ;
      AV67Serviciowwds_1_filterfulltext = "" ;
      AV70Serviciowwds_4_tfservicionombre = "" ;
      AV71Serviciowwds_5_tfservicionombre_sel = "" ;
      AV72Serviciowwds_6_tfserviciodescripcion = "" ;
      AV73Serviciowwds_7_tfserviciodescripcion_sel = "" ;
      AV74Serviciowwds_8_tfserviciocosto = DecimalUtil.ZERO ;
      AV75Serviciowwds_9_tfserviciocosto_to = DecimalUtil.ZERO ;
      AV80Serviciowwds_14_tflaboratorionombre = "" ;
      AV81Serviciowwds_15_tflaboratorionombre_sel = "" ;
      AV84Serviciowwds_18_tfservicioobservacion = "" ;
      AV85Serviciowwds_19_tfservicioobservacion_sel = "" ;
      AV86Serviciowwds_20_tfservicioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Serviciowwds_1_filterfulltext = "" ;
      lV70Serviciowwds_4_tfservicionombre = "" ;
      lV72Serviciowwds_6_tfserviciodescripcion = "" ;
      lV80Serviciowwds_14_tflaboratorionombre = "" ;
      lV84Serviciowwds_18_tfservicioobservacion = "" ;
      P00582_A284ServicioComision = new short[1] ;
      P00582_A40LaboratorioId = new short[1] ;
      P00582_A52ServicioCategId = new short[1] ;
      P00582_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00582_A27ServicioId = new short[1] ;
      P00582_A286ServicioEstado = new String[] {""} ;
      P00582_A285ServicioObservacion = new String[] {""} ;
      P00582_A165LaboratorioNombre = new String[] {""} ;
      P00582_A282ServicioDescripcion = new String[] {""} ;
      P00582_A281ServicioNombre = new String[] {""} ;
      AV14ServicioEstadoDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV56PageInfo = "" ;
      AV53DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV51AppName = "" ;
      AV57Phone = "" ;
      AV55Mail = "" ;
      AV59Website = "" ;
      AV48AddressLine1 = "" ;
      AV49AddressLine2 = "" ;
      AV50AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.serviciowwexportreport__default(),
         new Object[] {
             new Object[] {
            P00582_A284ServicioComision, P00582_A40LaboratorioId, P00582_A52ServicioCategId, P00582_A283ServicioCosto, P00582_A27ServicioId, P00582_A286ServicioEstado, P00582_A285ServicioObservacion, P00582_A165LaboratorioNombre, P00582_A282ServicioDescripcion, P00582_A281ServicioNombre
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV62Pgmname = "ServicioWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV62Pgmname = "ServicioWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV19TFServicioId ;
   private short AV20TFServicioId_To ;
   private short AV27TFServicioCategId ;
   private short AV28TFServicioCategId_To ;
   private short AV29TFLaboratorioId ;
   private short AV30TFLaboratorioId_To ;
   private short AV33TFServicioComision ;
   private short AV34TFServicioComision_To ;
   private short A27ServicioId ;
   private short A52ServicioCategId ;
   private short A40LaboratorioId ;
   private short A284ServicioComision ;
   private short AV68Serviciowwds_2_tfservicioid ;
   private short AV69Serviciowwds_3_tfservicioid_to ;
   private short AV76Serviciowwds_10_tfserviciocategid ;
   private short AV77Serviciowwds_11_tfserviciocategid_to ;
   private short AV78Serviciowwds_12_tflaboratorioid ;
   private short AV79Serviciowwds_13_tflaboratorioid_to ;
   private short AV82Serviciowwds_16_tfserviciocomision ;
   private short AV83Serviciowwds_17_tfserviciocomision_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV65GXV1 ;
   private int AV86Serviciowwds_20_tfservicioestado_sels_size ;
   private int AV87GXV2 ;
   private long AV47i ;
   private java.math.BigDecimal AV25TFServicioCosto ;
   private java.math.BigDecimal AV26TFServicioCosto_To ;
   private java.math.BigDecimal A283ServicioCosto ;
   private java.math.BigDecimal AV74Serviciowwds_8_tfserviciocosto ;
   private java.math.BigDecimal AV75Serviciowwds_9_tfserviciocosto_to ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV62Pgmname ;
   private String AV40TFServicioEstado_Sel ;
   private String A286ServicioEstado ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV37TFServicioEstado_SelsJson ;
   private String AV58Title ;
   private String AV13FilterFullText ;
   private String AV41TFServicioId_To_Description ;
   private String AV22TFServicioNombre_Sel ;
   private String AV21TFServicioNombre ;
   private String AV24TFServicioDescripcion_Sel ;
   private String AV23TFServicioDescripcion ;
   private String AV42TFServicioCosto_To_Description ;
   private String AV43TFServicioCategId_To_Description ;
   private String AV44TFLaboratorioId_To_Description ;
   private String AV32TFLaboratorioNombre_Sel ;
   private String AV31TFLaboratorioNombre ;
   private String AV45TFServicioComision_To_Description ;
   private String AV36TFServicioObservacion_Sel ;
   private String AV35TFServicioObservacion ;
   private String AV38TFServicioEstado_SelDscs ;
   private String AV46FilterTFServicioEstado_SelValueDescription ;
   private String A281ServicioNombre ;
   private String A282ServicioDescripcion ;
   private String A165LaboratorioNombre ;
   private String A285ServicioObservacion ;
   private String AV67Serviciowwds_1_filterfulltext ;
   private String AV70Serviciowwds_4_tfservicionombre ;
   private String AV71Serviciowwds_5_tfservicionombre_sel ;
   private String AV72Serviciowwds_6_tfserviciodescripcion ;
   private String AV73Serviciowwds_7_tfserviciodescripcion_sel ;
   private String AV80Serviciowwds_14_tflaboratorionombre ;
   private String AV81Serviciowwds_15_tflaboratorionombre_sel ;
   private String AV84Serviciowwds_18_tfservicioobservacion ;
   private String AV85Serviciowwds_19_tfservicioobservacion_sel ;
   private String lV67Serviciowwds_1_filterfulltext ;
   private String lV70Serviciowwds_4_tfservicionombre ;
   private String lV72Serviciowwds_6_tfserviciodescripcion ;
   private String lV80Serviciowwds_14_tflaboratorionombre ;
   private String lV84Serviciowwds_18_tfservicioobservacion ;
   private String AV14ServicioEstadoDescription ;
   private String AV56PageInfo ;
   private String AV53DateInfo ;
   private String AV51AppName ;
   private String AV57Phone ;
   private String AV55Mail ;
   private String AV59Website ;
   private String AV48AddressLine1 ;
   private String AV49AddressLine2 ;
   private String AV50AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private short[] P00582_A284ServicioComision ;
   private short[] P00582_A40LaboratorioId ;
   private short[] P00582_A52ServicioCategId ;
   private java.math.BigDecimal[] P00582_A283ServicioCosto ;
   private short[] P00582_A27ServicioId ;
   private String[] P00582_A286ServicioEstado ;
   private String[] P00582_A285ServicioObservacion ;
   private String[] P00582_A165LaboratorioNombre ;
   private String[] P00582_A282ServicioDescripcion ;
   private String[] P00582_A281ServicioNombre ;
   private GXSimpleCollection<String> AV39TFServicioEstado_Sels ;
   private GXSimpleCollection<String> AV86Serviciowwds_20_tfservicioestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class serviciowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00582( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV86Serviciowwds_20_tfservicioestado_sels ,
                                          String AV67Serviciowwds_1_filterfulltext ,
                                          short AV68Serviciowwds_2_tfservicioid ,
                                          short AV69Serviciowwds_3_tfservicioid_to ,
                                          String AV71Serviciowwds_5_tfservicionombre_sel ,
                                          String AV70Serviciowwds_4_tfservicionombre ,
                                          String AV73Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV72Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV74Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV75Serviciowwds_9_tfserviciocosto_to ,
                                          short AV76Serviciowwds_10_tfserviciocategid ,
                                          short AV77Serviciowwds_11_tfserviciocategid_to ,
                                          short AV78Serviciowwds_12_tflaboratorioid ,
                                          short AV79Serviciowwds_13_tflaboratorioid_to ,
                                          String AV81Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV80Serviciowwds_14_tflaboratorionombre ,
                                          short AV82Serviciowwds_16_tfserviciocomision ,
                                          short AV83Serviciowwds_17_tfserviciocomision_to ,
                                          String AV85Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV84Serviciowwds_18_tfservicioobservacion ,
                                          int AV86Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[29];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioComision], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioId], T1.[ServicioEstado], T1.[ServicioObservacion], T3.[LaboratorioNombre]," ;
      scmdbuf += " T1.[ServicioDescripcion], T1.[ServicioNombre] FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio]" ;
      scmdbuf += " T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV67Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
      }
      if ( ! (0==AV68Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV71Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV70Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV72Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (0==AV76Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (0==AV77Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV78Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (0==AV79Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV80Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV82Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV83Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV84Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( AV86Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV86Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCosto]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCosto] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategId]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[LaboratorioId]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[LaboratorioId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[LaboratorioNombre]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[LaboratorioNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioComision]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioComision] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioObservacion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioObservacion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioEstado]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioEstado] DESC" ;
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
                  return conditional_P00582(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00582", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
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
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
      }
   }

}

