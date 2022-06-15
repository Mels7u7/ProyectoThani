package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class serviciocategwwexportreport_impl extends GXWebReport
{
   public serviciocategwwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicioCateg", GXv_boolean2) ;
         serviciocategwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV51Pgmname))}, new String[] {"GxObject"}) );
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
            AV47Title = "Lista de Servicio Categ" ;
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
         h520( true, 0) ;
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
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV19TFServicioCategId) && (0==AV20TFServicioCategId_To) ) )
      {
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Categ Id", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFServicioCategId), "ZZZ9")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV33TFServicioCategId_To_Description = GXutil.format( "%1 (%2)", "Categ Id", "Hasta", "", "", "", "", "", "", "") ;
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFServicioCategId_To_Description, "")), 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFServicioCategId_To), "ZZZ9")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV21TFLaboratorioId) && (0==AV22TFLaboratorioId_To) ) )
      {
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Laboratorio Id", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFLaboratorioId), "ZZZ9")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV34TFLaboratorioId_To_Description = GXutil.format( "%1 (%2)", "Laboratorio Id", "Hasta", "", "", "", "", "", "", "") ;
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV34TFLaboratorioId_To_Description, "")), 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22TFLaboratorioId_To), "ZZZ9")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV24TFLaboratorioNombre_Sel)==0) )
      {
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Laboratorio Nombre", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFLaboratorioNombre_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFLaboratorioNombre)==0) )
         {
            h520( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Laboratorio Nombre", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFLaboratorioNombre, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV26TFServicioCategNombre_Sel)==0) )
      {
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFServicioCategNombre_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV25TFServicioCategNombre)==0) )
         {
            h520( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFServicioCategNombre, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV28TFServicioCategDescripcion_Sel)==0) )
      {
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFServicioCategDescripcion_Sel, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV27TFServicioCategDescripcion)==0) )
         {
            h520( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFServicioCategDescripcion, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV31TFServicioCategEstado_Sels.fromJSonString(AV29TFServicioCategEstado_SelsJson, null);
      if ( ! ( AV31TFServicioCategEstado_Sels.size() == 0 ) )
      {
         AV36i = 1 ;
         AV54GXV1 = 1 ;
         while ( AV54GXV1 <= AV31TFServicioCategEstado_Sels.size() )
         {
            AV32TFServicioCategEstado_Sel = (String)AV31TFServicioCategEstado_Sels.elementAt(-1+AV54GXV1) ;
            if ( AV36i == 1 )
            {
               AV30TFServicioCategEstado_SelDscs = "" ;
            }
            else
            {
               AV30TFServicioCategEstado_SelDscs += ", " ;
            }
            AV35FilterTFServicioCategEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV32TFServicioCategEstado_Sel) ;
            AV30TFServicioCategEstado_SelDscs += AV35FilterTFServicioCategEstado_SelValueDescription ;
            AV36i = (long)(AV36i+1) ;
            AV54GXV1 = (int)(AV54GXV1+1) ;
         }
         h520( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 129, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFServicioCategEstado_SelDscs, "")), 129, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h520( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h520( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Categ Id", 30, Gx_line+10, 96, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Laboratorio Id", 100, Gx_line+10, 166, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Laboratorio Nombre", 170, Gx_line+10, 302, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 306, Gx_line+10, 440, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 444, Gx_line+10, 578, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Imagen", 582, Gx_line+10, 649, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 653, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV56Serviciocategwwds_1_filterfulltext = AV13FilterFullText ;
      AV57Serviciocategwwds_2_tfserviciocategid = AV19TFServicioCategId ;
      AV58Serviciocategwwds_3_tfserviciocategid_to = AV20TFServicioCategId_To ;
      AV59Serviciocategwwds_4_tflaboratorioid = AV21TFLaboratorioId ;
      AV60Serviciocategwwds_5_tflaboratorioid_to = AV22TFLaboratorioId_To ;
      AV61Serviciocategwwds_6_tflaboratorionombre = AV23TFLaboratorioNombre ;
      AV62Serviciocategwwds_7_tflaboratorionombre_sel = AV24TFLaboratorioNombre_Sel ;
      AV63Serviciocategwwds_8_tfserviciocategnombre = AV25TFServicioCategNombre ;
      AV64Serviciocategwwds_9_tfserviciocategnombre_sel = AV26TFServicioCategNombre_Sel ;
      AV65Serviciocategwwds_10_tfserviciocategdescripcion = AV27TFServicioCategDescripcion ;
      AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel = AV28TFServicioCategDescripcion_Sel ;
      AV67Serviciocategwwds_12_tfserviciocategestado_sels = AV31TFServicioCategEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A290ServicioCategEstado ,
                                           AV67Serviciocategwwds_12_tfserviciocategestado_sels ,
                                           AV56Serviciocategwwds_1_filterfulltext ,
                                           Short.valueOf(AV57Serviciocategwwds_2_tfserviciocategid) ,
                                           Short.valueOf(AV58Serviciocategwwds_3_tfserviciocategid_to) ,
                                           Short.valueOf(AV59Serviciocategwwds_4_tflaboratorioid) ,
                                           Short.valueOf(AV60Serviciocategwwds_5_tflaboratorioid_to) ,
                                           AV62Serviciocategwwds_7_tflaboratorionombre_sel ,
                                           AV61Serviciocategwwds_6_tflaboratorionombre ,
                                           AV64Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                           AV63Serviciocategwwds_8_tfserviciocategnombre ,
                                           AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                           AV65Serviciocategwwds_10_tfserviciocategdescripcion ,
                                           Integer.valueOf(AV67Serviciocategwwds_12_tfserviciocategestado_sels.size()) ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A287ServicioCategNombre ,
                                           A288ServicioCategDescripcion ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN
                                           }
      });
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV56Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV61Serviciocategwwds_6_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV61Serviciocategwwds_6_tflaboratorionombre), "%", "") ;
      lV63Serviciocategwwds_8_tfserviciocategnombre = GXutil.concat( GXutil.rtrim( AV63Serviciocategwwds_8_tfserviciocategnombre), "%", "") ;
      lV65Serviciocategwwds_10_tfserviciocategdescripcion = GXutil.concat( GXutil.rtrim( AV65Serviciocategwwds_10_tfserviciocategdescripcion), "%", "") ;
      /* Using cursor P00522 */
      pr_default.execute(0, new Object[] {lV56Serviciocategwwds_1_filterfulltext, lV56Serviciocategwwds_1_filterfulltext, lV56Serviciocategwwds_1_filterfulltext, lV56Serviciocategwwds_1_filterfulltext, lV56Serviciocategwwds_1_filterfulltext, lV56Serviciocategwwds_1_filterfulltext, lV56Serviciocategwwds_1_filterfulltext, Short.valueOf(AV57Serviciocategwwds_2_tfserviciocategid), Short.valueOf(AV58Serviciocategwwds_3_tfserviciocategid_to), Short.valueOf(AV59Serviciocategwwds_4_tflaboratorioid), Short.valueOf(AV60Serviciocategwwds_5_tflaboratorioid_to), lV61Serviciocategwwds_6_tflaboratorionombre, AV62Serviciocategwwds_7_tflaboratorionombre_sel, lV63Serviciocategwwds_8_tfserviciocategnombre, AV64Serviciocategwwds_9_tfserviciocategnombre_sel, lV65Serviciocategwwds_10_tfserviciocategdescripcion, AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A40LaboratorioId = P00522_A40LaboratorioId[0] ;
         A52ServicioCategId = P00522_A52ServicioCategId[0] ;
         A290ServicioCategEstado = P00522_A290ServicioCategEstado[0] ;
         A288ServicioCategDescripcion = P00522_A288ServicioCategDescripcion[0] ;
         n288ServicioCategDescripcion = P00522_n288ServicioCategDescripcion[0] ;
         A287ServicioCategNombre = P00522_A287ServicioCategNombre[0] ;
         A165LaboratorioNombre = P00522_A165LaboratorioNombre[0] ;
         A40000ServicioCategImagen_GXI = P00522_A40000ServicioCategImagen_GXI[0] ;
         n40000ServicioCategImagen_GXI = P00522_n40000ServicioCategImagen_GXI[0] ;
         A289ServicioCategImagen = P00522_A289ServicioCategImagen[0] ;
         n289ServicioCategImagen = P00522_n289ServicioCategImagen[0] ;
         A165LaboratorioNombre = P00522_A165LaboratorioNombre[0] ;
         AV14ServicioCategEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A290ServicioCategEstado) ;
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
         h520( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9")), 30, Gx_line+10, 96, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9")), 100, Gx_line+10, 166, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A165LaboratorioNombre, "")), 170, Gx_line+10, 302, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A287ServicioCategNombre, "")), 306, Gx_line+10, 440, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A288ServicioCategDescripcion, "")), 444, Gx_line+10, 578, Gx_line+55, 0, 0, 0, 0) ;
         sImgUrl = ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : A289ServicioCategImagen) ;
         getPrinter().GxDrawBitMap(sImgUrl, 582, Gx_line+10, 649, Gx_line+55) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14ServicioCategEstadoDescription, "")), 653, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV15Session.getValue("ServicioCategWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ServicioCategWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("ServicioCategWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV68GXV2 = 1 ;
      while ( AV68GXV2 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV68GXV2));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGID") == 0 )
         {
            AV19TFServicioCategId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFServicioCategId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV21TFLaboratorioId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFLaboratorioId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV23TFLaboratorioNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV24TFLaboratorioNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGNOMBRE") == 0 )
         {
            AV25TFServicioCategNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGNOMBRE_SEL") == 0 )
         {
            AV26TFServicioCategNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGDESCRIPCION") == 0 )
         {
            AV27TFServicioCategDescripcion = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGDESCRIPCION_SEL") == 0 )
         {
            AV28TFServicioCategDescripcion_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGESTADO_SEL") == 0 )
         {
            AV29TFServicioCategEstado_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV31TFServicioCategEstado_Sels.fromJSonString(AV29TFServicioCategEstado_SelsJson, null);
         }
         AV68GXV2 = (int)(AV68GXV2+1) ;
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

   public void h520( boolean bFoot ,
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
               AV45PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV42DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV40AppName = "DVelop Software Solutions" ;
            AV46Phone = "+1 550 8923" ;
            AV44Mail = "info@mail.com" ;
            AV48Website = "http://www.web.com" ;
            AV37AddressLine1 = "French Boulevard 2859" ;
            AV38AddressLine2 = "Downtown" ;
            AV39AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV40AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV46Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV48Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV47Title = "" ;
      AV13FilterFullText = "" ;
      AV33TFServicioCategId_To_Description = "" ;
      AV34TFLaboratorioId_To_Description = "" ;
      AV24TFLaboratorioNombre_Sel = "" ;
      AV23TFLaboratorioNombre = "" ;
      AV26TFServicioCategNombre_Sel = "" ;
      AV25TFServicioCategNombre = "" ;
      AV28TFServicioCategDescripcion_Sel = "" ;
      AV27TFServicioCategDescripcion = "" ;
      AV31TFServicioCategEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29TFServicioCategEstado_SelsJson = "" ;
      AV32TFServicioCategEstado_Sel = "" ;
      AV30TFServicioCategEstado_SelDscs = "" ;
      AV35FilterTFServicioCategEstado_SelValueDescription = "" ;
      A290ServicioCategEstado = "" ;
      A165LaboratorioNombre = "" ;
      A287ServicioCategNombre = "" ;
      A288ServicioCategDescripcion = "" ;
      A289ServicioCategImagen = "" ;
      A40000ServicioCategImagen_GXI = "" ;
      AV56Serviciocategwwds_1_filterfulltext = "" ;
      AV61Serviciocategwwds_6_tflaboratorionombre = "" ;
      AV62Serviciocategwwds_7_tflaboratorionombre_sel = "" ;
      AV63Serviciocategwwds_8_tfserviciocategnombre = "" ;
      AV64Serviciocategwwds_9_tfserviciocategnombre_sel = "" ;
      AV65Serviciocategwwds_10_tfserviciocategdescripcion = "" ;
      AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel = "" ;
      AV67Serviciocategwwds_12_tfserviciocategestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV56Serviciocategwwds_1_filterfulltext = "" ;
      lV61Serviciocategwwds_6_tflaboratorionombre = "" ;
      lV63Serviciocategwwds_8_tfserviciocategnombre = "" ;
      lV65Serviciocategwwds_10_tfserviciocategdescripcion = "" ;
      P00522_A40LaboratorioId = new short[1] ;
      P00522_A52ServicioCategId = new short[1] ;
      P00522_A290ServicioCategEstado = new String[] {""} ;
      P00522_A288ServicioCategDescripcion = new String[] {""} ;
      P00522_n288ServicioCategDescripcion = new boolean[] {false} ;
      P00522_A287ServicioCategNombre = new String[] {""} ;
      P00522_A165LaboratorioNombre = new String[] {""} ;
      P00522_A40000ServicioCategImagen_GXI = new String[] {""} ;
      P00522_n40000ServicioCategImagen_GXI = new boolean[] {false} ;
      P00522_A289ServicioCategImagen = new String[] {""} ;
      P00522_n289ServicioCategImagen = new boolean[] {false} ;
      AV14ServicioCategEstadoDescription = "" ;
      sImgUrl = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV45PageInfo = "" ;
      AV42DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV40AppName = "" ;
      AV46Phone = "" ;
      AV44Mail = "" ;
      AV48Website = "" ;
      AV37AddressLine1 = "" ;
      AV38AddressLine2 = "" ;
      AV39AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.serviciocategwwexportreport__default(),
         new Object[] {
             new Object[] {
            P00522_A40LaboratorioId, P00522_A52ServicioCategId, P00522_A290ServicioCategEstado, P00522_A288ServicioCategDescripcion, P00522_n288ServicioCategDescripcion, P00522_A287ServicioCategNombre, P00522_A165LaboratorioNombre, P00522_A40000ServicioCategImagen_GXI, P00522_n40000ServicioCategImagen_GXI, P00522_A289ServicioCategImagen,
            P00522_n289ServicioCategImagen
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV51Pgmname = "ServicioCategWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV51Pgmname = "ServicioCategWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV19TFServicioCategId ;
   private short AV20TFServicioCategId_To ;
   private short AV21TFLaboratorioId ;
   private short AV22TFLaboratorioId_To ;
   private short A52ServicioCategId ;
   private short A40LaboratorioId ;
   private short AV57Serviciocategwwds_2_tfserviciocategid ;
   private short AV58Serviciocategwwds_3_tfserviciocategid_to ;
   private short AV59Serviciocategwwds_4_tflaboratorioid ;
   private short AV60Serviciocategwwds_5_tflaboratorioid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV54GXV1 ;
   private int AV67Serviciocategwwds_12_tfserviciocategestado_sels_size ;
   private int AV68GXV2 ;
   private long AV36i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV51Pgmname ;
   private String AV32TFServicioCategEstado_Sel ;
   private String A290ServicioCategEstado ;
   private String scmdbuf ;
   private String sImgUrl ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n288ServicioCategDescripcion ;
   private boolean n40000ServicioCategImagen_GXI ;
   private boolean n289ServicioCategImagen ;
   private String AV29TFServicioCategEstado_SelsJson ;
   private String AV47Title ;
   private String AV13FilterFullText ;
   private String AV33TFServicioCategId_To_Description ;
   private String AV34TFLaboratorioId_To_Description ;
   private String AV24TFLaboratorioNombre_Sel ;
   private String AV23TFLaboratorioNombre ;
   private String AV26TFServicioCategNombre_Sel ;
   private String AV25TFServicioCategNombre ;
   private String AV28TFServicioCategDescripcion_Sel ;
   private String AV27TFServicioCategDescripcion ;
   private String AV30TFServicioCategEstado_SelDscs ;
   private String AV35FilterTFServicioCategEstado_SelValueDescription ;
   private String A165LaboratorioNombre ;
   private String A287ServicioCategNombre ;
   private String A288ServicioCategDescripcion ;
   private String A40000ServicioCategImagen_GXI ;
   private String AV56Serviciocategwwds_1_filterfulltext ;
   private String AV61Serviciocategwwds_6_tflaboratorionombre ;
   private String AV62Serviciocategwwds_7_tflaboratorionombre_sel ;
   private String AV63Serviciocategwwds_8_tfserviciocategnombre ;
   private String AV64Serviciocategwwds_9_tfserviciocategnombre_sel ;
   private String AV65Serviciocategwwds_10_tfserviciocategdescripcion ;
   private String AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel ;
   private String lV56Serviciocategwwds_1_filterfulltext ;
   private String lV61Serviciocategwwds_6_tflaboratorionombre ;
   private String lV63Serviciocategwwds_8_tfserviciocategnombre ;
   private String lV65Serviciocategwwds_10_tfserviciocategdescripcion ;
   private String AV14ServicioCategEstadoDescription ;
   private String AV45PageInfo ;
   private String AV42DateInfo ;
   private String AV40AppName ;
   private String AV46Phone ;
   private String AV44Mail ;
   private String AV48Website ;
   private String AV37AddressLine1 ;
   private String AV38AddressLine2 ;
   private String AV39AddressLine3 ;
   private String A289ServicioCategImagen ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private short[] P00522_A40LaboratorioId ;
   private short[] P00522_A52ServicioCategId ;
   private String[] P00522_A290ServicioCategEstado ;
   private String[] P00522_A288ServicioCategDescripcion ;
   private boolean[] P00522_n288ServicioCategDescripcion ;
   private String[] P00522_A287ServicioCategNombre ;
   private String[] P00522_A165LaboratorioNombre ;
   private String[] P00522_A40000ServicioCategImagen_GXI ;
   private boolean[] P00522_n40000ServicioCategImagen_GXI ;
   private String[] P00522_A289ServicioCategImagen ;
   private boolean[] P00522_n289ServicioCategImagen ;
   private GXSimpleCollection<String> AV31TFServicioCategEstado_Sels ;
   private GXSimpleCollection<String> AV67Serviciocategwwds_12_tfserviciocategestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class serviciocategwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00522( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A290ServicioCategEstado ,
                                          GXSimpleCollection<String> AV67Serviciocategwwds_12_tfserviciocategestado_sels ,
                                          String AV56Serviciocategwwds_1_filterfulltext ,
                                          short AV57Serviciocategwwds_2_tfserviciocategid ,
                                          short AV58Serviciocategwwds_3_tfserviciocategid_to ,
                                          short AV59Serviciocategwwds_4_tflaboratorioid ,
                                          short AV60Serviciocategwwds_5_tflaboratorioid_to ,
                                          String AV62Serviciocategwwds_7_tflaboratorionombre_sel ,
                                          String AV61Serviciocategwwds_6_tflaboratorionombre ,
                                          String AV64Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                          String AV63Serviciocategwwds_8_tfserviciocategnombre ,
                                          String AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                          String AV65Serviciocategwwds_10_tfserviciocategdescripcion ,
                                          int AV67Serviciocategwwds_12_tfserviciocategestado_sels_size ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A287ServicioCategNombre ,
                                          String A288ServicioCategDescripcion ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[17];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCategEstado], T1.[ServicioCategDescripcion], T1.[ServicioCategNombre], T2.[LaboratorioNombre], T1.[ServicioCategImagen_GXI]," ;
      scmdbuf += " T1.[ServicioCategImagen] FROM ([ServicioCateg] T1 INNER JOIN [Laboratorio] T2 ON T2.[LaboratorioId] = T1.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV56Serviciocategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T2.[LaboratorioNombre] like '%' + ?) or ( T1.[ServicioCategNombre] like '%' + ?) or ( T1.[ServicioCategDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'I'))");
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
      }
      if ( ! (0==AV57Serviciocategwwds_2_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (0==AV58Serviciocategwwds_3_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (0==AV59Serviciocategwwds_4_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV60Serviciocategwwds_5_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Serviciocategwwds_7_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV61Serviciocategwwds_6_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Serviciocategwwds_7_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Serviciocategwwds_9_tfserviciocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV63Serviciocategwwds_8_tfserviciocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Serviciocategwwds_9_tfserviciocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV65Serviciocategwwds_10_tfserviciocategdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( AV67Serviciocategwwds_12_tfserviciocategestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV67Serviciocategwwds_12_tfserviciocategestado_sels, "T1.[ServicioCategEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LaboratorioId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LaboratorioId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[LaboratorioNombre]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[LaboratorioNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategEstado]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategEstado] DESC" ;
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
                  return conditional_P00522(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00522", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getMultimediaUri(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(7));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               return;
      }
   }

}

