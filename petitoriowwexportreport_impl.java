package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class petitoriowwexportreport_impl extends GXWebReport
{
   public petitoriowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio", GXv_boolean2) ;
         petitoriowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58Pgmname))}, new String[] {"GxObject"}) );
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
            AV54Title = "Lista de Petitorio" ;
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
         h4A0( true, 0) ;
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
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV18TFPetitorioId) && (0==AV19TFPetitorioId_To) ) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18TFPetitorioId), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV38TFPetitorioId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFPetitorioId_To_Description, "")), 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFPetitorioId_To), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFDrogueriaId) && (0==AV21TFDrogueriaId_To) ) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Drogueria Id", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFDrogueriaId), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV39TFDrogueriaId_To_Description = GXutil.format( "%1 (%2)", "Drogueria Id", "Hasta", "", "", "", "", "", "", "") ;
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39TFDrogueriaId_To_Description, "")), 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFDrogueriaId_To), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV23TFPetitorioPrincipioActivo_Sel)==0) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Principio Activo", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFPetitorioPrincipioActivo_Sel, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFPetitorioPrincipioActivo)==0) )
         {
            h4A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Principio Activo", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFPetitorioPrincipioActivo, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFPetitorioProducto_Sel)==0) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Producto", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFPetitorioProducto_Sel, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFPetitorioProducto)==0) )
         {
            h4A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Producto", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFPetitorioProducto, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV26TFPetitorioCategId) && (0==AV27TFPetitorioCategId_To) ) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Petitorio Categ Id", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV26TFPetitorioCategId), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV40TFPetitorioCategId_To_Description = GXutil.format( "%1 (%2)", "Petitorio Categ Id", "Hasta", "", "", "", "", "", "", "") ;
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40TFPetitorioCategId_To_Description, "")), 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV27TFPetitorioCategId_To), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV28TFPetitorioSubCategId) && (0==AV29TFPetitorioSubCategId_To) ) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Sub Categoría", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV28TFPetitorioSubCategId), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV41TFPetitorioSubCategId_To_Description = GXutil.format( "%1 (%2)", "Sub Categoría", "Hasta", "", "", "", "", "", "", "") ;
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFPetitorioSubCategId_To_Description, "")), 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV29TFPetitorioSubCategId_To), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV31TFPetitorioConcentracion_Sel)==0) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Concentracion", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFPetitorioConcentracion_Sel, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFPetitorioConcentracion)==0) )
         {
            h4A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Concentracion", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFPetitorioConcentracion, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (0==AV32TFFormaFarmaceuticaId) && (0==AV33TFFormaFarmaceuticaId_To) ) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Forma Farmaceutica", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV32TFFormaFarmaceuticaId), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV42TFFormaFarmaceuticaId_To_Description = GXutil.format( "%1 (%2)", "Forma Farmaceutica", "Hasta", "", "", "", "", "", "", "") ;
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42TFFormaFarmaceuticaId_To_Description, "")), 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV33TFFormaFarmaceuticaId_To), "ZZZ9")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV35TFPetitorioPresentacion_Sel)==0) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Presentacion", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFPetitorioPresentacion_Sel, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV34TFPetitorioPresentacion)==0) )
         {
            h4A0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Presentacion", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFPetitorioPresentacion, "")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFPetitorioPrecio)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFPetitorioPrecio_To)==0) ) )
      {
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Precio", 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV36TFPetitorioPrecio, "ZZZ9.99")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV43TFPetitorioPrecio_To_Description = GXutil.format( "%1 (%2)", "Precio", "Hasta", "", "", "", "", "", "", "") ;
         h4A0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43TFPetitorioPrecio_To_Description, "")), 25, Gx_line+0, 155, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( AV37TFPetitorioPrecio_To, "ZZZ9.99")), 155, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4A0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4A0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 81, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Drogueria Id", 85, Gx_line+10, 136, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Principio Activo", 140, Gx_line+10, 242, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Producto", 246, Gx_line+10, 348, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Petitorio Categ Id", 352, Gx_line+10, 403, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Sub Categoría", 407, Gx_line+10, 459, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Concentracion", 463, Gx_line+10, 567, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Forma Farmaceutica", 571, Gx_line+10, 623, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Presentacion", 627, Gx_line+10, 731, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Precio", 735, Gx_line+10, 787, Gx_line+27, 2, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV62Petitoriowwds_1_filterfulltext = AV13FilterFullText ;
      AV63Petitoriowwds_2_tfpetitorioid = AV18TFPetitorioId ;
      AV64Petitoriowwds_3_tfpetitorioid_to = AV19TFPetitorioId_To ;
      AV65Petitoriowwds_4_tfdrogueriaid = AV20TFDrogueriaId ;
      AV66Petitoriowwds_5_tfdrogueriaid_to = AV21TFDrogueriaId_To ;
      AV67Petitoriowwds_6_tfpetitorioprincipioactivo = AV22TFPetitorioPrincipioActivo ;
      AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV23TFPetitorioPrincipioActivo_Sel ;
      AV69Petitoriowwds_8_tfpetitorioproducto = AV24TFPetitorioProducto ;
      AV70Petitoriowwds_9_tfpetitorioproducto_sel = AV25TFPetitorioProducto_Sel ;
      AV71Petitoriowwds_10_tfpetitoriocategid = AV26TFPetitorioCategId ;
      AV72Petitoriowwds_11_tfpetitoriocategid_to = AV27TFPetitorioCategId_To ;
      AV73Petitoriowwds_12_tfpetitoriosubcategid = AV28TFPetitorioSubCategId ;
      AV74Petitoriowwds_13_tfpetitoriosubcategid_to = AV29TFPetitorioSubCategId_To ;
      AV75Petitoriowwds_14_tfpetitorioconcentracion = AV30TFPetitorioConcentracion ;
      AV76Petitoriowwds_15_tfpetitorioconcentracion_sel = AV31TFPetitorioConcentracion_Sel ;
      AV77Petitoriowwds_16_tfformafarmaceuticaid = AV32TFFormaFarmaceuticaId ;
      AV78Petitoriowwds_17_tfformafarmaceuticaid_to = AV33TFFormaFarmaceuticaId_To ;
      AV79Petitoriowwds_18_tfpetitoriopresentacion = AV34TFPetitorioPresentacion ;
      AV80Petitoriowwds_19_tfpetitoriopresentacion_sel = AV35TFPetitorioPresentacion_Sel ;
      AV81Petitoriowwds_20_tfpetitorioprecio = AV36TFPetitorioPrecio ;
      AV82Petitoriowwds_21_tfpetitorioprecio_to = AV37TFPetitorioPrecio_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV62Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV63Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV64Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV65Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV66Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV67Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV70Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV69Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV71Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV72Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV73Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV74Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV76Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV75Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV77Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV78Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV80Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV79Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV81Petitoriowwds_20_tfpetitorioprecio ,
                                           AV82Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV62Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Petitoriowwds_1_filterfulltext), "%", "") ;
      lV67Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV67Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV69Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV69Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV75Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV75Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV79Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV79Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor P004A2 */
      pr_default.execute(0, new Object[] {lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, lV62Petitoriowwds_1_filterfulltext, Short.valueOf(AV63Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV64Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV65Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV66Petitoriowwds_5_tfdrogueriaid_to), lV67Petitoriowwds_6_tfpetitorioprincipioactivo, AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV69Petitoriowwds_8_tfpetitorioproducto, AV70Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV71Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV72Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV73Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV74Petitoriowwds_13_tfpetitoriosubcategid_to), lV75Petitoriowwds_14_tfpetitorioconcentracion, AV76Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV77Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV78Petitoriowwds_17_tfformafarmaceuticaid_to), lV79Petitoriowwds_18_tfpetitoriopresentacion, AV80Petitoriowwds_19_tfpetitoriopresentacion_sel, AV81Petitoriowwds_20_tfpetitorioprecio, AV82Petitoriowwds_21_tfpetitorioprecio_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A264PetitorioPrecio = P004A2_A264PetitorioPrecio[0] ;
         A39FormaFarmaceuticaId = P004A2_A39FormaFarmaceuticaId[0] ;
         A48PetitorioSubCategId = P004A2_A48PetitorioSubCategId[0] ;
         A49PetitorioCategId = P004A2_A49PetitorioCategId[0] ;
         A36DrogueriaId = P004A2_A36DrogueriaId[0] ;
         A25PetitorioId = P004A2_A25PetitorioId[0] ;
         A261PetitorioPresentacion = P004A2_A261PetitorioPresentacion[0] ;
         A260PetitorioConcentracion = P004A2_A260PetitorioConcentracion[0] ;
         A263PetitorioProducto = P004A2_A263PetitorioProducto[0] ;
         A262PetitorioPrincipioActivo = P004A2_A262PetitorioPrincipioActivo[0] ;
         A49PetitorioCategId = P004A2_A49PetitorioCategId[0] ;
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
         h4A0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9")), 30, Gx_line+10, 81, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9")), 85, Gx_line+10, 136, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A262PetitorioPrincipioActivo, "")), 140, Gx_line+10, 242, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A263PetitorioProducto, "")), 246, Gx_line+10, 348, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9")), 352, Gx_line+10, 403, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9")), 407, Gx_line+10, 459, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A260PetitorioConcentracion, "")), 463, Gx_line+10, 567, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9")), 571, Gx_line+10, 623, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A261PetitorioPresentacion, "")), 627, Gx_line+10, 731, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A264PetitorioPrecio, "ZZZ9.99")), 735, Gx_line+10, 787, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
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
      if ( GXutil.strcmp(AV14Session.getValue("PetitorioWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("PetitorioWWGridState"), null, null);
      }
      AV11OrderedBy = AV16GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV16GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV83GXV1 = 1 ;
      while ( AV83GXV1 <= AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV17GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV83GXV1));
         if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOID") == 0 )
         {
            AV18TFPetitorioId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFPetitorioId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV20TFDrogueriaId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFDrogueriaId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO") == 0 )
         {
            AV22TFPetitorioPrincipioActivo = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO_SEL") == 0 )
         {
            AV23TFPetitorioPrincipioActivo_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO") == 0 )
         {
            AV24TFPetitorioProducto = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO_SEL") == 0 )
         {
            AV25TFPetitorioProducto_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV26TFPetitorioCategId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV27TFPetitorioCategId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV28TFPetitorioSubCategId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV29TFPetitorioSubCategId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION") == 0 )
         {
            AV30TFPetitorioConcentracion = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION_SEL") == 0 )
         {
            AV31TFPetitorioConcentracion_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV32TFFormaFarmaceuticaId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV33TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION") == 0 )
         {
            AV34TFPetitorioPresentacion = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION_SEL") == 0 )
         {
            AV35TFPetitorioPresentacion_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRECIO") == 0 )
         {
            AV36TFPetitorioPrecio = CommonUtil.decimalVal( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV37TFPetitorioPrecio_To = CommonUtil.decimalVal( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         AV83GXV1 = (int)(AV83GXV1+1) ;
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

   public void h4A0( boolean bFoot ,
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
               AV52PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV49DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV47AppName = "DVelop Software Solutions" ;
            AV53Phone = "+1 550 8923" ;
            AV51Mail = "info@mail.com" ;
            AV55Website = "http://www.web.com" ;
            AV44AddressLine1 = "French Boulevard 2859" ;
            AV45AddressLine2 = "Downtown" ;
            AV46AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV55Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV58Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV54Title = "" ;
      AV13FilterFullText = "" ;
      AV38TFPetitorioId_To_Description = "" ;
      AV39TFDrogueriaId_To_Description = "" ;
      AV23TFPetitorioPrincipioActivo_Sel = "" ;
      AV22TFPetitorioPrincipioActivo = "" ;
      AV25TFPetitorioProducto_Sel = "" ;
      AV24TFPetitorioProducto = "" ;
      AV40TFPetitorioCategId_To_Description = "" ;
      AV41TFPetitorioSubCategId_To_Description = "" ;
      AV31TFPetitorioConcentracion_Sel = "" ;
      AV30TFPetitorioConcentracion = "" ;
      AV42TFFormaFarmaceuticaId_To_Description = "" ;
      AV35TFPetitorioPresentacion_Sel = "" ;
      AV34TFPetitorioPresentacion = "" ;
      AV36TFPetitorioPrecio = DecimalUtil.ZERO ;
      AV37TFPetitorioPrecio_To = DecimalUtil.ZERO ;
      AV43TFPetitorioPrecio_To_Description = "" ;
      A262PetitorioPrincipioActivo = "" ;
      A263PetitorioProducto = "" ;
      A260PetitorioConcentracion = "" ;
      A261PetitorioPresentacion = "" ;
      A264PetitorioPrecio = DecimalUtil.ZERO ;
      AV62Petitoriowwds_1_filterfulltext = "" ;
      AV67Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel = "" ;
      AV69Petitoriowwds_8_tfpetitorioproducto = "" ;
      AV70Petitoriowwds_9_tfpetitorioproducto_sel = "" ;
      AV75Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      AV76Petitoriowwds_15_tfpetitorioconcentracion_sel = "" ;
      AV79Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      AV80Petitoriowwds_19_tfpetitoriopresentacion_sel = "" ;
      AV81Petitoriowwds_20_tfpetitorioprecio = DecimalUtil.ZERO ;
      AV82Petitoriowwds_21_tfpetitorioprecio_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV62Petitoriowwds_1_filterfulltext = "" ;
      lV67Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      lV69Petitoriowwds_8_tfpetitorioproducto = "" ;
      lV75Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      lV79Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      P004A2_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004A2_A39FormaFarmaceuticaId = new short[1] ;
      P004A2_A48PetitorioSubCategId = new short[1] ;
      P004A2_A49PetitorioCategId = new short[1] ;
      P004A2_A36DrogueriaId = new short[1] ;
      P004A2_A25PetitorioId = new short[1] ;
      P004A2_A261PetitorioPresentacion = new String[] {""} ;
      P004A2_A260PetitorioConcentracion = new String[] {""} ;
      P004A2_A263PetitorioProducto = new String[] {""} ;
      P004A2_A262PetitorioPrincipioActivo = new String[] {""} ;
      AV14Session = httpContext.getWebSession();
      AV16GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV52PageInfo = "" ;
      AV49DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV47AppName = "" ;
      AV53Phone = "" ;
      AV51Mail = "" ;
      AV55Website = "" ;
      AV44AddressLine1 = "" ;
      AV45AddressLine2 = "" ;
      AV46AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriowwexportreport__default(),
         new Object[] {
             new Object[] {
            P004A2_A264PetitorioPrecio, P004A2_A39FormaFarmaceuticaId, P004A2_A48PetitorioSubCategId, P004A2_A49PetitorioCategId, P004A2_A36DrogueriaId, P004A2_A25PetitorioId, P004A2_A261PetitorioPresentacion, P004A2_A260PetitorioConcentracion, P004A2_A263PetitorioProducto, P004A2_A262PetitorioPrincipioActivo
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV58Pgmname = "PetitorioWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV58Pgmname = "PetitorioWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV18TFPetitorioId ;
   private short AV19TFPetitorioId_To ;
   private short AV20TFDrogueriaId ;
   private short AV21TFDrogueriaId_To ;
   private short AV26TFPetitorioCategId ;
   private short AV27TFPetitorioCategId_To ;
   private short AV28TFPetitorioSubCategId ;
   private short AV29TFPetitorioSubCategId_To ;
   private short AV32TFFormaFarmaceuticaId ;
   private short AV33TFFormaFarmaceuticaId_To ;
   private short A25PetitorioId ;
   private short A36DrogueriaId ;
   private short A49PetitorioCategId ;
   private short A48PetitorioSubCategId ;
   private short A39FormaFarmaceuticaId ;
   private short AV63Petitoriowwds_2_tfpetitorioid ;
   private short AV64Petitoriowwds_3_tfpetitorioid_to ;
   private short AV65Petitoriowwds_4_tfdrogueriaid ;
   private short AV66Petitoriowwds_5_tfdrogueriaid_to ;
   private short AV71Petitoriowwds_10_tfpetitoriocategid ;
   private short AV72Petitoriowwds_11_tfpetitoriocategid_to ;
   private short AV73Petitoriowwds_12_tfpetitoriosubcategid ;
   private short AV74Petitoriowwds_13_tfpetitoriosubcategid_to ;
   private short AV77Petitoriowwds_16_tfformafarmaceuticaid ;
   private short AV78Petitoriowwds_17_tfformafarmaceuticaid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV83GXV1 ;
   private java.math.BigDecimal AV36TFPetitorioPrecio ;
   private java.math.BigDecimal AV37TFPetitorioPrecio_To ;
   private java.math.BigDecimal A264PetitorioPrecio ;
   private java.math.BigDecimal AV81Petitoriowwds_20_tfpetitorioprecio ;
   private java.math.BigDecimal AV82Petitoriowwds_21_tfpetitorioprecio_to ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV58Pgmname ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV54Title ;
   private String AV13FilterFullText ;
   private String AV38TFPetitorioId_To_Description ;
   private String AV39TFDrogueriaId_To_Description ;
   private String AV23TFPetitorioPrincipioActivo_Sel ;
   private String AV22TFPetitorioPrincipioActivo ;
   private String AV25TFPetitorioProducto_Sel ;
   private String AV24TFPetitorioProducto ;
   private String AV40TFPetitorioCategId_To_Description ;
   private String AV41TFPetitorioSubCategId_To_Description ;
   private String AV31TFPetitorioConcentracion_Sel ;
   private String AV30TFPetitorioConcentracion ;
   private String AV42TFFormaFarmaceuticaId_To_Description ;
   private String AV35TFPetitorioPresentacion_Sel ;
   private String AV34TFPetitorioPresentacion ;
   private String AV43TFPetitorioPrecio_To_Description ;
   private String A262PetitorioPrincipioActivo ;
   private String A263PetitorioProducto ;
   private String A260PetitorioConcentracion ;
   private String A261PetitorioPresentacion ;
   private String AV62Petitoriowwds_1_filterfulltext ;
   private String AV67Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel ;
   private String AV69Petitoriowwds_8_tfpetitorioproducto ;
   private String AV70Petitoriowwds_9_tfpetitorioproducto_sel ;
   private String AV75Petitoriowwds_14_tfpetitorioconcentracion ;
   private String AV76Petitoriowwds_15_tfpetitorioconcentracion_sel ;
   private String AV79Petitoriowwds_18_tfpetitoriopresentacion ;
   private String AV80Petitoriowwds_19_tfpetitoriopresentacion_sel ;
   private String lV62Petitoriowwds_1_filterfulltext ;
   private String lV67Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String lV69Petitoriowwds_8_tfpetitorioproducto ;
   private String lV75Petitoriowwds_14_tfpetitorioconcentracion ;
   private String lV79Petitoriowwds_18_tfpetitoriopresentacion ;
   private String AV52PageInfo ;
   private String AV49DateInfo ;
   private String AV47AppName ;
   private String AV53Phone ;
   private String AV51Mail ;
   private String AV55Website ;
   private String AV44AddressLine1 ;
   private String AV45AddressLine2 ;
   private String AV46AddressLine3 ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P004A2_A264PetitorioPrecio ;
   private short[] P004A2_A39FormaFarmaceuticaId ;
   private short[] P004A2_A48PetitorioSubCategId ;
   private short[] P004A2_A49PetitorioCategId ;
   private short[] P004A2_A36DrogueriaId ;
   private short[] P004A2_A25PetitorioId ;
   private String[] P004A2_A261PetitorioPresentacion ;
   private String[] P004A2_A260PetitorioConcentracion ;
   private String[] P004A2_A263PetitorioProducto ;
   private String[] P004A2_A262PetitorioPrincipioActivo ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class petitoriowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004A2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV62Petitoriowwds_1_filterfulltext ,
                                          short AV63Petitoriowwds_2_tfpetitorioid ,
                                          short AV64Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV65Petitoriowwds_4_tfdrogueriaid ,
                                          short AV66Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV67Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV70Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV69Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV71Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV72Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV73Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV74Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV76Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV75Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV77Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV78Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV80Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV79Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV81Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV82Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[30];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioPrecio], T1.[FormaFarmaceuticaId], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[DrogueriaId], T1.[PetitorioId], T1.[PetitorioPresentacion]," ;
      scmdbuf += " T1.[PetitorioConcentracion], T1.[PetitorioProducto], T1.[PetitorioPrincipioActivo] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId]" ;
      scmdbuf += " = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV62Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
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
      if ( ! (0==AV63Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (0==AV64Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (0==AV65Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (0==AV66Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV67Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV69Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (0==AV71Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (0==AV72Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (0==AV73Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV74Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV75Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV79Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrincipioActivo]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrincipioActivo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DrogueriaId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DrogueriaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioProducto]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioProducto] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategId]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioConcentracion]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioConcentracion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[FormaFarmaceuticaId]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[FormaFarmaceuticaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPresentacion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPresentacion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrecio]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrecio] DESC" ;
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
                  return conditional_P004A2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004A2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
      }
   }

}

