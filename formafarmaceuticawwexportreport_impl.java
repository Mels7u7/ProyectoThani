package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class formafarmaceuticawwexportreport_impl extends GXWebReport
{
   public formafarmaceuticawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFormaFarmaceutica", GXv_boolean2) ;
         formafarmaceuticawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48Pgmname))}, new String[] {"GxObject"}) );
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
            AV44Title = "Lista de Forma Farmaceutica" ;
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
         h7X0( true, 0) ;
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
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV19TFFormaFarmaceuticaId) && (0==AV20TFFormaFarmaceuticaId_To) ) )
      {
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Farmaceutica", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFFormaFarmaceuticaId), "ZZZ9")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV31TFFormaFarmaceuticaId_To_Description = GXutil.format( "%1 (%2)", "Farmaceutica", "Hasta", "", "", "", "", "", "", "") ;
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFFormaFarmaceuticaId_To_Description, "")), 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFFormaFarmaceuticaId_To), "ZZZ9")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV22TFFormaFarmaceuticaCodigo_Sel)==0) )
      {
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Farmaceutica Codigo", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFFormaFarmaceuticaCodigo_Sel, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFFormaFarmaceuticaCodigo)==0) )
         {
            h7X0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Farmaceutica Codigo", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFFormaFarmaceuticaCodigo, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV24TFFormaFarmaceuticaDescripcion_Sel)==0) )
      {
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Farmaceutica Descripcion", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFFormaFarmaceuticaDescripcion_Sel, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFFormaFarmaceuticaDescripcion)==0) )
         {
            h7X0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Farmaceutica Descripcion", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFFormaFarmaceuticaDescripcion, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV27TFFormaFarmaceuticaEstado_Sels.fromJSonString(AV25TFFormaFarmaceuticaEstado_SelsJson, null);
      if ( ! ( AV27TFFormaFarmaceuticaEstado_Sels.size() == 0 ) )
      {
         AV33i = 1 ;
         AV51GXV1 = 1 ;
         while ( AV51GXV1 <= AV27TFFormaFarmaceuticaEstado_Sels.size() )
         {
            AV28TFFormaFarmaceuticaEstado_Sel = (String)AV27TFFormaFarmaceuticaEstado_Sels.elementAt(-1+AV51GXV1) ;
            if ( AV33i == 1 )
            {
               AV26TFFormaFarmaceuticaEstado_SelDscs = "" ;
            }
            else
            {
               AV26TFFormaFarmaceuticaEstado_SelDscs += ", " ;
            }
            AV32FilterTFFormaFarmaceuticaEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV28TFFormaFarmaceuticaEstado_Sel) ;
            AV26TFFormaFarmaceuticaEstado_SelDscs += AV32FilterTFFormaFarmaceuticaEstado_SelValueDescription ;
            AV33i = (long)(AV33i+1) ;
            AV51GXV1 = (int)(AV51GXV1+1) ;
         }
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Farmaceutica Estado", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFFormaFarmaceuticaEstado_SelDscs, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV30TFFormaFarmaceuticaDescripcion2_Sel)==0) )
      {
         h7X0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Farmaceutica Descripcion2", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFFormaFarmaceuticaDescripcion2_Sel, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV29TFFormaFarmaceuticaDescripcion2)==0) )
         {
            h7X0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Farmaceutica Descripcion2", 25, Gx_line+0, 166, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29TFFormaFarmaceuticaDescripcion2, "")), 166, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h7X0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h7X0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Farmaceutica", 30, Gx_line+10, 112, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Farmaceutica Codigo", 116, Gx_line+10, 280, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Farmaceutica Descripcion", 284, Gx_line+10, 448, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Farmaceutica Estado", 452, Gx_line+10, 617, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Farmaceutica Descripcion2", 621, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV53Formafarmaceuticawwds_1_filterfulltext = AV13FilterFullText ;
      AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid = AV19TFFormaFarmaceuticaId ;
      AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to = AV20TFFormaFarmaceuticaId_To ;
      AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = AV21TFFormaFarmaceuticaCodigo ;
      AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = AV22TFFormaFarmaceuticaCodigo_Sel ;
      AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = AV23TFFormaFarmaceuticaDescripcion ;
      AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = AV24TFFormaFarmaceuticaDescripcion_Sel ;
      AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = AV27TFFormaFarmaceuticaEstado_Sels ;
      AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = AV29TFFormaFarmaceuticaDescripcion2 ;
      AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = AV30TFFormaFarmaceuticaDescripcion2_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A163FormaFarmaceuticaEstado ,
                                           AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                           AV53Formafarmaceuticawwds_1_filterfulltext ,
                                           Short.valueOf(AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) ,
                                           AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                           AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                           AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                           AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                           Integer.valueOf(AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels.size()) ,
                                           AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                           AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A161FormaFarmaceuticaCodigo ,
                                           A162FormaFarmaceuticaDescripcion ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = GXutil.concat( GXutil.rtrim( AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo), "%", "") ;
      lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = GXutil.concat( GXutil.rtrim( AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion), "%", "") ;
      lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = GXutil.concat( GXutil.rtrim( AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2), "%", "") ;
      /* Using cursor P007X2 */
      pr_default.execute(0, new Object[] {lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, Short.valueOf(AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid), Short.valueOf(AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to), lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo, AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel, lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion, AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel, lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2, AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A39FormaFarmaceuticaId = P007X2_A39FormaFarmaceuticaId[0] ;
         A163FormaFarmaceuticaEstado = P007X2_A163FormaFarmaceuticaEstado[0] ;
         A162FormaFarmaceuticaDescripcion = P007X2_A162FormaFarmaceuticaDescripcion[0] ;
         A161FormaFarmaceuticaCodigo = P007X2_A161FormaFarmaceuticaCodigo[0] ;
         A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
         AV14FormaFarmaceuticaEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A163FormaFarmaceuticaEstado) ;
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
         h7X0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9")), 30, Gx_line+10, 112, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A161FormaFarmaceuticaCodigo, "")), 116, Gx_line+10, 280, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A162FormaFarmaceuticaDescripcion, "")), 284, Gx_line+10, 448, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14FormaFarmaceuticaEstadoDescription, "")), 452, Gx_line+10, 617, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A164FormaFarmaceuticaDescripcion2, "")), 621, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV15Session.getValue("FormaFarmaceuticaWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "FormaFarmaceuticaWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("FormaFarmaceuticaWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV63GXV2 = 1 ;
      while ( AV63GXV2 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV2));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV19TFFormaFarmaceuticaId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICACODIGO") == 0 )
         {
            AV21TFFormaFarmaceuticaCodigo = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICACODIGO_SEL") == 0 )
         {
            AV22TFFormaFarmaceuticaCodigo_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION") == 0 )
         {
            AV23TFFormaFarmaceuticaDescripcion = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION_SEL") == 0 )
         {
            AV24TFFormaFarmaceuticaDescripcion_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAESTADO_SEL") == 0 )
         {
            AV25TFFormaFarmaceuticaEstado_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFFormaFarmaceuticaEstado_Sels.fromJSonString(AV25TFFormaFarmaceuticaEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION2") == 0 )
         {
            AV29TFFormaFarmaceuticaDescripcion2 = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION2_SEL") == 0 )
         {
            AV30TFFormaFarmaceuticaDescripcion2_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
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

   public void h7X0( boolean bFoot ,
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
               AV42PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV39DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV37AppName = "DVelop Software Solutions" ;
            AV43Phone = "+1 550 8923" ;
            AV41Mail = "info@mail.com" ;
            AV45Website = "http://www.web.com" ;
            AV34AddressLine1 = "French Boulevard 2859" ;
            AV35AddressLine2 = "Downtown" ;
            AV36AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV48Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV44Title = "" ;
      AV13FilterFullText = "" ;
      AV31TFFormaFarmaceuticaId_To_Description = "" ;
      AV22TFFormaFarmaceuticaCodigo_Sel = "" ;
      AV21TFFormaFarmaceuticaCodigo = "" ;
      AV24TFFormaFarmaceuticaDescripcion_Sel = "" ;
      AV23TFFormaFarmaceuticaDescripcion = "" ;
      AV27TFFormaFarmaceuticaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFFormaFarmaceuticaEstado_SelsJson = "" ;
      AV28TFFormaFarmaceuticaEstado_Sel = "" ;
      AV26TFFormaFarmaceuticaEstado_SelDscs = "" ;
      AV32FilterTFFormaFarmaceuticaEstado_SelValueDescription = "" ;
      AV30TFFormaFarmaceuticaDescripcion2_Sel = "" ;
      AV29TFFormaFarmaceuticaDescripcion2 = "" ;
      A163FormaFarmaceuticaEstado = "" ;
      A161FormaFarmaceuticaCodigo = "" ;
      A162FormaFarmaceuticaDescripcion = "" ;
      A164FormaFarmaceuticaDescripcion2 = "" ;
      AV53Formafarmaceuticawwds_1_filterfulltext = "" ;
      AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = "" ;
      AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = "" ;
      AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = "" ;
      AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = "" ;
      AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = "" ;
      AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = "" ;
      scmdbuf = "" ;
      lV53Formafarmaceuticawwds_1_filterfulltext = "" ;
      lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = "" ;
      lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = "" ;
      lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = "" ;
      P007X2_A39FormaFarmaceuticaId = new short[1] ;
      P007X2_A163FormaFarmaceuticaEstado = new String[] {""} ;
      P007X2_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      P007X2_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      AV14FormaFarmaceuticaEstadoDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV42PageInfo = "" ;
      AV39DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV37AppName = "" ;
      AV43Phone = "" ;
      AV41Mail = "" ;
      AV45Website = "" ;
      AV34AddressLine1 = "" ;
      AV35AddressLine2 = "" ;
      AV36AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.formafarmaceuticawwexportreport__default(),
         new Object[] {
             new Object[] {
            P007X2_A39FormaFarmaceuticaId, P007X2_A163FormaFarmaceuticaEstado, P007X2_A162FormaFarmaceuticaDescripcion, P007X2_A161FormaFarmaceuticaCodigo
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV48Pgmname = "FormaFarmaceuticaWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV48Pgmname = "FormaFarmaceuticaWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV19TFFormaFarmaceuticaId ;
   private short AV20TFFormaFarmaceuticaId_To ;
   private short A39FormaFarmaceuticaId ;
   private short AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid ;
   private short AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV51GXV1 ;
   private int AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ;
   private int AV63GXV2 ;
   private long AV33i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV48Pgmname ;
   private String AV28TFFormaFarmaceuticaEstado_Sel ;
   private String A163FormaFarmaceuticaEstado ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV25TFFormaFarmaceuticaEstado_SelsJson ;
   private String AV44Title ;
   private String AV13FilterFullText ;
   private String AV31TFFormaFarmaceuticaId_To_Description ;
   private String AV22TFFormaFarmaceuticaCodigo_Sel ;
   private String AV21TFFormaFarmaceuticaCodigo ;
   private String AV24TFFormaFarmaceuticaDescripcion_Sel ;
   private String AV23TFFormaFarmaceuticaDescripcion ;
   private String AV26TFFormaFarmaceuticaEstado_SelDscs ;
   private String AV32FilterTFFormaFarmaceuticaEstado_SelValueDescription ;
   private String AV30TFFormaFarmaceuticaDescripcion2_Sel ;
   private String AV29TFFormaFarmaceuticaDescripcion2 ;
   private String A161FormaFarmaceuticaCodigo ;
   private String A162FormaFarmaceuticaDescripcion ;
   private String A164FormaFarmaceuticaDescripcion2 ;
   private String AV53Formafarmaceuticawwds_1_filterfulltext ;
   private String AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ;
   private String AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ;
   private String AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ;
   private String AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ;
   private String AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ;
   private String AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ;
   private String lV53Formafarmaceuticawwds_1_filterfulltext ;
   private String lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ;
   private String lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ;
   private String lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ;
   private String AV14FormaFarmaceuticaEstadoDescription ;
   private String AV42PageInfo ;
   private String AV39DateInfo ;
   private String AV37AppName ;
   private String AV43Phone ;
   private String AV41Mail ;
   private String AV45Website ;
   private String AV34AddressLine1 ;
   private String AV35AddressLine2 ;
   private String AV36AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private short[] P007X2_A39FormaFarmaceuticaId ;
   private String[] P007X2_A163FormaFarmaceuticaEstado ;
   private String[] P007X2_A162FormaFarmaceuticaDescripcion ;
   private String[] P007X2_A161FormaFarmaceuticaCodigo ;
   private GXSimpleCollection<String> AV27TFFormaFarmaceuticaEstado_Sels ;
   private GXSimpleCollection<String> AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class formafarmaceuticawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A163FormaFarmaceuticaEstado ,
                                          GXSimpleCollection<String> AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                          String AV53Formafarmaceuticawwds_1_filterfulltext ,
                                          short AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid ,
                                          short AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ,
                                          String AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                          String AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                          String AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                          String AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                          int AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ,
                                          String AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                          String AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                          short A39FormaFarmaceuticaId ,
                                          String A161FormaFarmaceuticaCodigo ,
                                          String A162FormaFarmaceuticaDescripcion ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaEstado], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaCodigo] FROM [FormaFarmaceutica]" ;
      if ( ! (GXutil.strcmp("", AV53Formafarmaceuticawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( [FormaFarmaceuticaCodigo] like '%' + ?) or ( [FormaFarmaceuticaDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'I') or ( [FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like '%' + ?))");
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
      if ( ! (0==AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) && ( ! (GXutil.strcmp("", AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels, "[FormaFarmaceuticaEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) && ( ! (GXutil.strcmp("", AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaCodigo]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaCodigo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaEstado]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaEstado] DESC" ;
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
                  return conditional_P007X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 1000);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 1000);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
               }
               return;
      }
   }

}

