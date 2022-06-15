package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class especialidadwwexportreport_impl extends GXWebReport
{
   public especialidadwwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean2) ;
         especialidadwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV44Title = "Lista de Especialidad" ;
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
         h4Q0( true, 0) ;
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
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV19TFEspecialidadId) && (0==AV20TFEspecialidadId_To) ) )
      {
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFEspecialidadId), "ZZZ9")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV31TFEspecialidadId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFEspecialidadId_To_Description, "")), 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFEspecialidadId_To), "ZZZ9")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV22TFEspecialidadNombre_Sel)==0) )
      {
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFEspecialidadNombre_Sel, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV21TFEspecialidadNombre)==0) )
         {
            h4Q0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21TFEspecialidadNombre, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV24TFEspecialidadDescripcion_Sel)==0) )
      {
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFEspecialidadDescripcion_Sel, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV23TFEspecialidadDescripcion)==0) )
         {
            h4Q0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFEspecialidadDescripcion, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV26TFEspecialidadCodigo_Sel)==0) )
      {
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Codigo", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFEspecialidadCodigo_Sel, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV25TFEspecialidadCodigo)==0) )
         {
            h4Q0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Codigo", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFEspecialidadCodigo, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV29TFEspecialidadEstado_Sels.fromJSonString(AV27TFEspecialidadEstado_SelsJson, null);
      if ( ! ( AV29TFEspecialidadEstado_Sels.size() == 0 ) )
      {
         AV33i = 1 ;
         AV51GXV1 = 1 ;
         while ( AV51GXV1 <= AV29TFEspecialidadEstado_Sels.size() )
         {
            AV30TFEspecialidadEstado_Sel = (String)AV29TFEspecialidadEstado_Sels.elementAt(-1+AV51GXV1) ;
            if ( AV33i == 1 )
            {
               AV28TFEspecialidadEstado_SelDscs = "" ;
            }
            else
            {
               AV28TFEspecialidadEstado_SelDscs += ", " ;
            }
            AV32FilterTFEspecialidadEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV30TFEspecialidadEstado_Sel) ;
            AV28TFEspecialidadEstado_SelDscs += AV32FilterTFEspecialidadEstado_SelValueDescription ;
            AV33i = (long)(AV33i+1) ;
            AV51GXV1 = (int)(AV51GXV1+1) ;
         }
         h4Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 90, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28TFEspecialidadEstado_SelDscs, "")), 90, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4Q0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4Q0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 111, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 115, Gx_line+10, 279, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 283, Gx_line+10, 447, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Codigo", 451, Gx_line+10, 533, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Foto", 537, Gx_line+10, 619, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 623, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV53Especialidadwwds_1_filterfulltext = AV13FilterFullText ;
      AV54Especialidadwwds_2_tfespecialidadid = AV19TFEspecialidadId ;
      AV55Especialidadwwds_3_tfespecialidadid_to = AV20TFEspecialidadId_To ;
      AV56Especialidadwwds_4_tfespecialidadnombre = AV21TFEspecialidadNombre ;
      AV57Especialidadwwds_5_tfespecialidadnombre_sel = AV22TFEspecialidadNombre_Sel ;
      AV58Especialidadwwds_6_tfespecialidaddescripcion = AV23TFEspecialidadDescripcion ;
      AV59Especialidadwwds_7_tfespecialidaddescripcion_sel = AV24TFEspecialidadDescripcion_Sel ;
      AV60Especialidadwwds_8_tfespecialidadcodigo = AV25TFEspecialidadCodigo ;
      AV61Especialidadwwds_9_tfespecialidadcodigo_sel = AV26TFEspecialidadCodigo_Sel ;
      AV62Especialidadwwds_10_tfespecialidadestado_sels = AV29TFEspecialidadEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A156EspecialidadEstado ,
                                           AV62Especialidadwwds_10_tfespecialidadestado_sels ,
                                           AV53Especialidadwwds_1_filterfulltext ,
                                           Short.valueOf(AV54Especialidadwwds_2_tfespecialidadid) ,
                                           Short.valueOf(AV55Especialidadwwds_3_tfespecialidadid_to) ,
                                           AV57Especialidadwwds_5_tfespecialidadnombre_sel ,
                                           AV56Especialidadwwds_4_tfespecialidadnombre ,
                                           AV59Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                           AV58Especialidadwwds_6_tfespecialidaddescripcion ,
                                           AV61Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                           AV60Especialidadwwds_8_tfespecialidadcodigo ,
                                           Integer.valueOf(AV62Especialidadwwds_10_tfespecialidadestado_sels.size()) ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A71EspecialidadNombre ,
                                           A154EspecialidadDescripcion ,
                                           A140EspecialidadCodigo ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV56Especialidadwwds_4_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV56Especialidadwwds_4_tfespecialidadnombre), "%", "") ;
      lV58Especialidadwwds_6_tfespecialidaddescripcion = GXutil.concat( GXutil.rtrim( AV58Especialidadwwds_6_tfespecialidaddescripcion), "%", "") ;
      lV60Especialidadwwds_8_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV60Especialidadwwds_8_tfespecialidadcodigo), "%", "") ;
      /* Using cursor P004Q2 */
      pr_default.execute(0, new Object[] {lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, Short.valueOf(AV54Especialidadwwds_2_tfespecialidadid), Short.valueOf(AV55Especialidadwwds_3_tfespecialidadid_to), lV56Especialidadwwds_4_tfespecialidadnombre, AV57Especialidadwwds_5_tfespecialidadnombre_sel, lV58Especialidadwwds_6_tfespecialidaddescripcion, AV59Especialidadwwds_7_tfespecialidaddescripcion_sel, lV60Especialidadwwds_8_tfespecialidadcodigo, AV61Especialidadwwds_9_tfespecialidadcodigo_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32EspecialidadId = P004Q2_A32EspecialidadId[0] ;
         A156EspecialidadEstado = P004Q2_A156EspecialidadEstado[0] ;
         A140EspecialidadCodigo = P004Q2_A140EspecialidadCodigo[0] ;
         A154EspecialidadDescripcion = P004Q2_A154EspecialidadDescripcion[0] ;
         A71EspecialidadNombre = P004Q2_A71EspecialidadNombre[0] ;
         A40000EspecialidadFoto_GXI = P004Q2_A40000EspecialidadFoto_GXI[0] ;
         A155EspecialidadFoto = P004Q2_A155EspecialidadFoto[0] ;
         AV14EspecialidadEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A156EspecialidadEstado) ;
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
         h4Q0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9")), 30, Gx_line+10, 111, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A71EspecialidadNombre, "")), 115, Gx_line+10, 279, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A154EspecialidadDescripcion, "")), 283, Gx_line+10, 447, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A140EspecialidadCodigo, "")), 451, Gx_line+10, 533, Gx_line+55, 0, 0, 0, 0) ;
         sImgUrl = ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : A155EspecialidadFoto) ;
         getPrinter().GxDrawBitMap(sImgUrl, 537, Gx_line+10, 619, Gx_line+55) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14EspecialidadEstadoDescription, "")), 623, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV15Session.getValue("EspecialidadWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EspecialidadWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("EspecialidadWWGridState"), null, null);
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
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV19TFEspecialidadId = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFEspecialidadId_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV21TFEspecialidadNombre = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV22TFEspecialidadNombre_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADDESCRIPCION") == 0 )
         {
            AV23TFEspecialidadDescripcion = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADDESCRIPCION_SEL") == 0 )
         {
            AV24TFEspecialidadDescripcion_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV25TFEspecialidadCodigo = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV26TFEspecialidadCodigo_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADESTADO_SEL") == 0 )
         {
            AV27TFEspecialidadEstado_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV29TFEspecialidadEstado_Sels.fromJSonString(AV27TFEspecialidadEstado_SelsJson, null);
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

   public void h4Q0( boolean bFoot ,
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
      AV31TFEspecialidadId_To_Description = "" ;
      AV22TFEspecialidadNombre_Sel = "" ;
      AV21TFEspecialidadNombre = "" ;
      AV24TFEspecialidadDescripcion_Sel = "" ;
      AV23TFEspecialidadDescripcion = "" ;
      AV26TFEspecialidadCodigo_Sel = "" ;
      AV25TFEspecialidadCodigo = "" ;
      AV29TFEspecialidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27TFEspecialidadEstado_SelsJson = "" ;
      AV30TFEspecialidadEstado_Sel = "" ;
      AV28TFEspecialidadEstado_SelDscs = "" ;
      AV32FilterTFEspecialidadEstado_SelValueDescription = "" ;
      A156EspecialidadEstado = "" ;
      A71EspecialidadNombre = "" ;
      A154EspecialidadDescripcion = "" ;
      A140EspecialidadCodigo = "" ;
      A155EspecialidadFoto = "" ;
      A40000EspecialidadFoto_GXI = "" ;
      AV53Especialidadwwds_1_filterfulltext = "" ;
      AV56Especialidadwwds_4_tfespecialidadnombre = "" ;
      AV57Especialidadwwds_5_tfespecialidadnombre_sel = "" ;
      AV58Especialidadwwds_6_tfespecialidaddescripcion = "" ;
      AV59Especialidadwwds_7_tfespecialidaddescripcion_sel = "" ;
      AV60Especialidadwwds_8_tfespecialidadcodigo = "" ;
      AV61Especialidadwwds_9_tfespecialidadcodigo_sel = "" ;
      AV62Especialidadwwds_10_tfespecialidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV53Especialidadwwds_1_filterfulltext = "" ;
      lV56Especialidadwwds_4_tfespecialidadnombre = "" ;
      lV58Especialidadwwds_6_tfespecialidaddescripcion = "" ;
      lV60Especialidadwwds_8_tfespecialidadcodigo = "" ;
      P004Q2_A32EspecialidadId = new short[1] ;
      P004Q2_A156EspecialidadEstado = new String[] {""} ;
      P004Q2_A140EspecialidadCodigo = new String[] {""} ;
      P004Q2_A154EspecialidadDescripcion = new String[] {""} ;
      P004Q2_A71EspecialidadNombre = new String[] {""} ;
      P004Q2_A40000EspecialidadFoto_GXI = new String[] {""} ;
      P004Q2_A155EspecialidadFoto = new String[] {""} ;
      AV14EspecialidadEstadoDescription = "" ;
      sImgUrl = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.especialidadwwexportreport__default(),
         new Object[] {
             new Object[] {
            P004Q2_A32EspecialidadId, P004Q2_A156EspecialidadEstado, P004Q2_A140EspecialidadCodigo, P004Q2_A154EspecialidadDescripcion, P004Q2_A71EspecialidadNombre, P004Q2_A40000EspecialidadFoto_GXI, P004Q2_A155EspecialidadFoto
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV48Pgmname = "EspecialidadWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV48Pgmname = "EspecialidadWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV19TFEspecialidadId ;
   private short AV20TFEspecialidadId_To ;
   private short A32EspecialidadId ;
   private short AV54Especialidadwwds_2_tfespecialidadid ;
   private short AV55Especialidadwwds_3_tfespecialidadid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV51GXV1 ;
   private int AV62Especialidadwwds_10_tfespecialidadestado_sels_size ;
   private int AV63GXV2 ;
   private long AV33i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV48Pgmname ;
   private String AV30TFEspecialidadEstado_Sel ;
   private String A156EspecialidadEstado ;
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
   private String AV27TFEspecialidadEstado_SelsJson ;
   private String AV44Title ;
   private String AV13FilterFullText ;
   private String AV31TFEspecialidadId_To_Description ;
   private String AV22TFEspecialidadNombre_Sel ;
   private String AV21TFEspecialidadNombre ;
   private String AV24TFEspecialidadDescripcion_Sel ;
   private String AV23TFEspecialidadDescripcion ;
   private String AV26TFEspecialidadCodigo_Sel ;
   private String AV25TFEspecialidadCodigo ;
   private String AV28TFEspecialidadEstado_SelDscs ;
   private String AV32FilterTFEspecialidadEstado_SelValueDescription ;
   private String A71EspecialidadNombre ;
   private String A154EspecialidadDescripcion ;
   private String A140EspecialidadCodigo ;
   private String A40000EspecialidadFoto_GXI ;
   private String AV53Especialidadwwds_1_filterfulltext ;
   private String AV56Especialidadwwds_4_tfespecialidadnombre ;
   private String AV57Especialidadwwds_5_tfespecialidadnombre_sel ;
   private String AV58Especialidadwwds_6_tfespecialidaddescripcion ;
   private String AV59Especialidadwwds_7_tfespecialidaddescripcion_sel ;
   private String AV60Especialidadwwds_8_tfespecialidadcodigo ;
   private String AV61Especialidadwwds_9_tfespecialidadcodigo_sel ;
   private String lV53Especialidadwwds_1_filterfulltext ;
   private String lV56Especialidadwwds_4_tfespecialidadnombre ;
   private String lV58Especialidadwwds_6_tfespecialidaddescripcion ;
   private String lV60Especialidadwwds_8_tfespecialidadcodigo ;
   private String AV14EspecialidadEstadoDescription ;
   private String AV42PageInfo ;
   private String AV39DateInfo ;
   private String AV37AppName ;
   private String AV43Phone ;
   private String AV41Mail ;
   private String AV45Website ;
   private String AV34AddressLine1 ;
   private String AV35AddressLine2 ;
   private String AV36AddressLine3 ;
   private String A155EspecialidadFoto ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private short[] P004Q2_A32EspecialidadId ;
   private String[] P004Q2_A156EspecialidadEstado ;
   private String[] P004Q2_A140EspecialidadCodigo ;
   private String[] P004Q2_A154EspecialidadDescripcion ;
   private String[] P004Q2_A71EspecialidadNombre ;
   private String[] P004Q2_A40000EspecialidadFoto_GXI ;
   private String[] P004Q2_A155EspecialidadFoto ;
   private GXSimpleCollection<String> AV29TFEspecialidadEstado_Sels ;
   private GXSimpleCollection<String> AV62Especialidadwwds_10_tfespecialidadestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class especialidadwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004Q2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A156EspecialidadEstado ,
                                          GXSimpleCollection<String> AV62Especialidadwwds_10_tfespecialidadestado_sels ,
                                          String AV53Especialidadwwds_1_filterfulltext ,
                                          short AV54Especialidadwwds_2_tfespecialidadid ,
                                          short AV55Especialidadwwds_3_tfespecialidadid_to ,
                                          String AV57Especialidadwwds_5_tfespecialidadnombre_sel ,
                                          String AV56Especialidadwwds_4_tfespecialidadnombre ,
                                          String AV59Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                          String AV58Especialidadwwds_6_tfespecialidaddescripcion ,
                                          String AV61Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                          String AV60Especialidadwwds_8_tfespecialidadcodigo ,
                                          int AV62Especialidadwwds_10_tfespecialidadestado_sels_size ,
                                          short A32EspecialidadId ,
                                          String A71EspecialidadNombre ,
                                          String A154EspecialidadDescripcion ,
                                          String A140EspecialidadCodigo ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [EspecialidadId], [EspecialidadEstado], [EspecialidadCodigo], [EspecialidadDescripcion], [EspecialidadNombre], [EspecialidadFoto_GXI], [EspecialidadFoto]" ;
      scmdbuf += " FROM [Especialidad]" ;
      if ( ! (GXutil.strcmp("", AV53Especialidadwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( [EspecialidadNombre] like '%' + ?) or ( [EspecialidadDescripcion] like '%' + ?) or ( [EspecialidadCodigo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [EspecialidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [EspecialidadEstado] = 'I'))");
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
      if ( ! (0==AV54Especialidadwwds_2_tfespecialidadid) )
      {
         addWhere(sWhereString, "([EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV55Especialidadwwds_3_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "([EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Especialidadwwds_5_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV56Especialidadwwds_4_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Especialidadwwds_5_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV58Especialidadwwds_6_tfespecialidaddescripcion)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Especialidadwwds_9_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV60Especialidadwwds_8_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Especialidadwwds_9_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( AV62Especialidadwwds_10_tfespecialidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV62Especialidadwwds_10_tfespecialidadestado_sels, "[EspecialidadEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadCodigo]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadCodigo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadEstado]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadEstado] DESC" ;
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
                  return conditional_P004Q2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004Q2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getMultimediaFile(7, rslt.getVarchar(6));
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
                  stmt.setVarchar(sIdx, (String)parms[24], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 4);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 4);
               }
               return;
      }
   }

}

