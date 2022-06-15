package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class drogueriawwexportreport_impl extends GXWebReport
{
   public drogueriawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria", GXv_boolean2) ;
         drogueriawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV56Pgmname))}, new String[] {"GxObject"}) );
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
            AV52Title = "Lista de Drogueria" ;
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
         h4M0( true, 0) ;
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
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFDrogueriaId) && (0==AV21TFDrogueriaId_To) ) )
      {
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFDrogueriaId), "ZZZ9")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV38TFDrogueriaId_To_Description = GXutil.format( "%1 (%2)", "Id", "Hasta", "", "", "", "", "", "", "") ;
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38TFDrogueriaId_To_Description, "")), 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFDrogueriaId_To), "ZZZ9")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV23TFDrogueriaNombre_Sel)==0) )
      {
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFDrogueriaNombre_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFDrogueriaNombre)==0) )
         {
            h4M0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nombre", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFDrogueriaNombre, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFDrogueriaDescripcion_Sel)==0) )
      {
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFDrogueriaDescripcion_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFDrogueriaDescripcion)==0) )
         {
            h4M0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Descripcion", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFDrogueriaDescripcion, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV28TFDrogueriaTipoDocumento_Sels.fromJSonString(AV26TFDrogueriaTipoDocumento_SelsJson, null);
      if ( ! ( AV28TFDrogueriaTipoDocumento_Sels.size() == 0 ) )
      {
         AV41i = 1 ;
         AV59GXV1 = 1 ;
         while ( AV59GXV1 <= AV28TFDrogueriaTipoDocumento_Sels.size() )
         {
            AV29TFDrogueriaTipoDocumento_Sel = (String)AV28TFDrogueriaTipoDocumento_Sels.elementAt(-1+AV59GXV1) ;
            if ( AV41i == 1 )
            {
               AV27TFDrogueriaTipoDocumento_SelDscs = "" ;
            }
            else
            {
               AV27TFDrogueriaTipoDocumento_SelDscs += ", " ;
            }
            AV39FilterTFDrogueriaTipoDocumento_SelValueDescription = com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV29TFDrogueriaTipoDocumento_Sel) ;
            AV27TFDrogueriaTipoDocumento_SelDscs += AV39FilterTFDrogueriaTipoDocumento_SelValueDescription ;
            AV41i = (long)(AV41i+1) ;
            AV59GXV1 = (int)(AV59GXV1+1) ;
         }
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Tipo Documento", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFDrogueriaTipoDocumento_SelDscs, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV31TFDrogueriaNroDocumento_Sel)==0) )
      {
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31TFDrogueriaNroDocumento_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV30TFDrogueriaNroDocumento)==0) )
         {
            h4M0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Nro Documento", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30TFDrogueriaNroDocumento, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV33TFDrogueriaDireccion_Sel)==0) )
      {
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFDrogueriaDireccion_Sel, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV32TFDrogueriaDireccion)==0) )
         {
            h4M0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Direccion", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV32TFDrogueriaDireccion, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV36TFDrogueriaEstado_Sels.fromJSonString(AV34TFDrogueriaEstado_SelsJson, null);
      if ( ! ( AV36TFDrogueriaEstado_Sels.size() == 0 ) )
      {
         AV41i = 1 ;
         AV60GXV2 = 1 ;
         while ( AV60GXV2 <= AV36TFDrogueriaEstado_Sels.size() )
         {
            AV37TFDrogueriaEstado_Sel = (String)AV36TFDrogueriaEstado_Sels.elementAt(-1+AV60GXV2) ;
            if ( AV41i == 1 )
            {
               AV35TFDrogueriaEstado_SelDscs = "" ;
            }
            else
            {
               AV35TFDrogueriaEstado_SelDscs += ", " ;
            }
            AV40FilterTFDrogueriaEstado_SelValueDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV37TFDrogueriaEstado_Sel) ;
            AV35TFDrogueriaEstado_SelDscs += AV40FilterTFDrogueriaEstado_SelValueDescription ;
            AV41i = (long)(AV41i+1) ;
            AV60GXV2 = (int)(AV60GXV2+1) ;
         }
         h4M0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Estado", 25, Gx_line+0, 114, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFDrogueriaEstado_SelDscs, "")), 114, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4M0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4M0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Id", 30, Gx_line+10, 91, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Nombre", 95, Gx_line+10, 217, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Descripcion", 221, Gx_line+10, 343, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Tipo Documento", 347, Gx_line+10, 469, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Nro Documento", 473, Gx_line+10, 534, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Direccion", 538, Gx_line+10, 660, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Estado", 664, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV62Drogueriawwds_1_filterfulltext = AV13FilterFullText ;
      AV63Drogueriawwds_2_tfdrogueriaid = AV20TFDrogueriaId ;
      AV64Drogueriawwds_3_tfdrogueriaid_to = AV21TFDrogueriaId_To ;
      AV65Drogueriawwds_4_tfdroguerianombre = AV22TFDrogueriaNombre ;
      AV66Drogueriawwds_5_tfdroguerianombre_sel = AV23TFDrogueriaNombre_Sel ;
      AV67Drogueriawwds_6_tfdrogueriadescripcion = AV24TFDrogueriaDescripcion ;
      AV68Drogueriawwds_7_tfdrogueriadescripcion_sel = AV25TFDrogueriaDescripcion_Sel ;
      AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels = AV28TFDrogueriaTipoDocumento_Sels ;
      AV70Drogueriawwds_9_tfdroguerianrodocumento = AV30TFDrogueriaNroDocumento ;
      AV71Drogueriawwds_10_tfdroguerianrodocumento_sel = AV31TFDrogueriaNroDocumento_Sel ;
      AV72Drogueriawwds_11_tfdrogueriadireccion = AV32TFDrogueriaDireccion ;
      AV73Drogueriawwds_12_tfdrogueriadireccion_sel = AV33TFDrogueriaDireccion_Sel ;
      AV74Drogueriawwds_13_tfdrogueriaestado_sels = AV36TFDrogueriaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A143DrogueriaTipoDocumento ,
                                           AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                           A147DrogueriaEstado ,
                                           AV74Drogueriawwds_13_tfdrogueriaestado_sels ,
                                           AV62Drogueriawwds_1_filterfulltext ,
                                           Short.valueOf(AV63Drogueriawwds_2_tfdrogueriaid) ,
                                           Short.valueOf(AV64Drogueriawwds_3_tfdrogueriaid_to) ,
                                           AV66Drogueriawwds_5_tfdroguerianombre_sel ,
                                           AV65Drogueriawwds_4_tfdroguerianombre ,
                                           AV68Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                           AV67Drogueriawwds_6_tfdrogueriadescripcion ,
                                           Integer.valueOf(AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels.size()) ,
                                           AV71Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                           AV70Drogueriawwds_9_tfdroguerianrodocumento ,
                                           AV73Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                           AV72Drogueriawwds_11_tfdrogueriadireccion ,
                                           Integer.valueOf(AV74Drogueriawwds_13_tfdrogueriaestado_sels.size()) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A141DrogueriaNombre ,
                                           A142DrogueriaDescripcion ,
                                           A144DrogueriaNroDocumento ,
                                           A145DrogueriaDireccion ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_1_filterfulltext), "%", "") ;
      lV65Drogueriawwds_4_tfdroguerianombre = GXutil.concat( GXutil.rtrim( AV65Drogueriawwds_4_tfdroguerianombre), "%", "") ;
      lV67Drogueriawwds_6_tfdrogueriadescripcion = GXutil.concat( GXutil.rtrim( AV67Drogueriawwds_6_tfdrogueriadescripcion), "%", "") ;
      lV70Drogueriawwds_9_tfdroguerianrodocumento = GXutil.concat( GXutil.rtrim( AV70Drogueriawwds_9_tfdroguerianrodocumento), "%", "") ;
      lV72Drogueriawwds_11_tfdrogueriadireccion = GXutil.concat( GXutil.rtrim( AV72Drogueriawwds_11_tfdrogueriadireccion), "%", "") ;
      /* Using cursor P004M2 */
      pr_default.execute(0, new Object[] {lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, lV62Drogueriawwds_1_filterfulltext, Short.valueOf(AV63Drogueriawwds_2_tfdrogueriaid), Short.valueOf(AV64Drogueriawwds_3_tfdrogueriaid_to), lV65Drogueriawwds_4_tfdroguerianombre, AV66Drogueriawwds_5_tfdroguerianombre_sel, lV67Drogueriawwds_6_tfdrogueriadescripcion, AV68Drogueriawwds_7_tfdrogueriadescripcion_sel, lV70Drogueriawwds_9_tfdroguerianrodocumento, AV71Drogueriawwds_10_tfdroguerianrodocumento_sel, lV72Drogueriawwds_11_tfdrogueriadireccion, AV73Drogueriawwds_12_tfdrogueriadireccion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A36DrogueriaId = P004M2_A36DrogueriaId[0] ;
         A147DrogueriaEstado = P004M2_A147DrogueriaEstado[0] ;
         A145DrogueriaDireccion = P004M2_A145DrogueriaDireccion[0] ;
         A144DrogueriaNroDocumento = P004M2_A144DrogueriaNroDocumento[0] ;
         A143DrogueriaTipoDocumento = P004M2_A143DrogueriaTipoDocumento[0] ;
         A142DrogueriaDescripcion = P004M2_A142DrogueriaDescripcion[0] ;
         A141DrogueriaNombre = P004M2_A141DrogueriaNombre[0] ;
         AV14DrogueriaTipoDocumentoDescription = com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A143DrogueriaTipoDocumento) ;
         AV15DrogueriaEstadoDescription = com.projectthani.gxdomainestado.getDescription(httpContext,(String)A147DrogueriaEstado) ;
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
         h4M0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9")), 30, Gx_line+10, 91, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A141DrogueriaNombre, "")), 95, Gx_line+10, 217, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A142DrogueriaDescripcion, "")), 221, Gx_line+10, 343, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14DrogueriaTipoDocumentoDescription, "")), 347, Gx_line+10, 469, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A144DrogueriaNroDocumento, "")), 473, Gx_line+10, 534, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A145DrogueriaDireccion, "")), 538, Gx_line+10, 660, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV15DrogueriaEstadoDescription, "")), 664, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV16Session.getValue("DrogueriaWWGridState"), "") == 0 )
      {
         AV18GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DrogueriaWWGridState"), null, null);
      }
      else
      {
         AV18GridState.fromxml(AV16Session.getValue("DrogueriaWWGridState"), null, null);
      }
      AV11OrderedBy = AV18GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV18GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV75GXV3 = 1 ;
      while ( AV75GXV3 <= AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV19GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV18GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV75GXV3));
         if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV20TFDrogueriaId = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFDrogueriaId_To = (short)(GXutil.lval( AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANOMBRE") == 0 )
         {
            AV22TFDrogueriaNombre = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANOMBRE_SEL") == 0 )
         {
            AV23TFDrogueriaNombre_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADESCRIPCION") == 0 )
         {
            AV24TFDrogueriaDescripcion = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADESCRIPCION_SEL") == 0 )
         {
            AV25TFDrogueriaDescripcion_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIATIPODOCUMENTO_SEL") == 0 )
         {
            AV26TFDrogueriaTipoDocumento_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV28TFDrogueriaTipoDocumento_Sels.fromJSonString(AV26TFDrogueriaTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANRODOCUMENTO") == 0 )
         {
            AV30TFDrogueriaNroDocumento = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANRODOCUMENTO_SEL") == 0 )
         {
            AV31TFDrogueriaNroDocumento_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADIRECCION") == 0 )
         {
            AV32TFDrogueriaDireccion = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADIRECCION_SEL") == 0 )
         {
            AV33TFDrogueriaDireccion_Sel = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAESTADO_SEL") == 0 )
         {
            AV34TFDrogueriaEstado_SelsJson = AV19GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFDrogueriaEstado_Sels.fromJSonString(AV34TFDrogueriaEstado_SelsJson, null);
         }
         AV75GXV3 = (int)(AV75GXV3+1) ;
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

   public void h4M0( boolean bFoot ,
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
               AV50PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV47DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV50PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV47DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV45AppName = "DVelop Software Solutions" ;
            AV51Phone = "+1 550 8923" ;
            AV49Mail = "info@mail.com" ;
            AV53Website = "http://www.web.com" ;
            AV42AddressLine1 = "French Boulevard 2859" ;
            AV43AddressLine2 = "Downtown" ;
            AV44AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV45AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV49Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV42AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV43AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV56Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV52Title = "" ;
      AV13FilterFullText = "" ;
      AV38TFDrogueriaId_To_Description = "" ;
      AV23TFDrogueriaNombre_Sel = "" ;
      AV22TFDrogueriaNombre = "" ;
      AV25TFDrogueriaDescripcion_Sel = "" ;
      AV24TFDrogueriaDescripcion = "" ;
      AV28TFDrogueriaTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFDrogueriaTipoDocumento_SelsJson = "" ;
      AV29TFDrogueriaTipoDocumento_Sel = "" ;
      AV27TFDrogueriaTipoDocumento_SelDscs = "" ;
      AV39FilterTFDrogueriaTipoDocumento_SelValueDescription = "" ;
      AV31TFDrogueriaNroDocumento_Sel = "" ;
      AV30TFDrogueriaNroDocumento = "" ;
      AV33TFDrogueriaDireccion_Sel = "" ;
      AV32TFDrogueriaDireccion = "" ;
      AV36TFDrogueriaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFDrogueriaEstado_SelsJson = "" ;
      AV37TFDrogueriaEstado_Sel = "" ;
      AV35TFDrogueriaEstado_SelDscs = "" ;
      AV40FilterTFDrogueriaEstado_SelValueDescription = "" ;
      A143DrogueriaTipoDocumento = "" ;
      A147DrogueriaEstado = "" ;
      A141DrogueriaNombre = "" ;
      A142DrogueriaDescripcion = "" ;
      A144DrogueriaNroDocumento = "" ;
      A145DrogueriaDireccion = "" ;
      AV62Drogueriawwds_1_filterfulltext = "" ;
      AV65Drogueriawwds_4_tfdroguerianombre = "" ;
      AV66Drogueriawwds_5_tfdroguerianombre_sel = "" ;
      AV67Drogueriawwds_6_tfdrogueriadescripcion = "" ;
      AV68Drogueriawwds_7_tfdrogueriadescripcion_sel = "" ;
      AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Drogueriawwds_9_tfdroguerianrodocumento = "" ;
      AV71Drogueriawwds_10_tfdroguerianrodocumento_sel = "" ;
      AV72Drogueriawwds_11_tfdrogueriadireccion = "" ;
      AV73Drogueriawwds_12_tfdrogueriadireccion_sel = "" ;
      AV74Drogueriawwds_13_tfdrogueriaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV62Drogueriawwds_1_filterfulltext = "" ;
      lV65Drogueriawwds_4_tfdroguerianombre = "" ;
      lV67Drogueriawwds_6_tfdrogueriadescripcion = "" ;
      lV70Drogueriawwds_9_tfdroguerianrodocumento = "" ;
      lV72Drogueriawwds_11_tfdrogueriadireccion = "" ;
      P004M2_A36DrogueriaId = new short[1] ;
      P004M2_A147DrogueriaEstado = new String[] {""} ;
      P004M2_A145DrogueriaDireccion = new String[] {""} ;
      P004M2_A144DrogueriaNroDocumento = new String[] {""} ;
      P004M2_A143DrogueriaTipoDocumento = new String[] {""} ;
      P004M2_A142DrogueriaDescripcion = new String[] {""} ;
      P004M2_A141DrogueriaNombre = new String[] {""} ;
      AV14DrogueriaTipoDocumentoDescription = "" ;
      AV15DrogueriaEstadoDescription = "" ;
      AV16Session = httpContext.getWebSession();
      AV18GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV19GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV50PageInfo = "" ;
      AV47DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV45AppName = "" ;
      AV51Phone = "" ;
      AV49Mail = "" ;
      AV53Website = "" ;
      AV42AddressLine1 = "" ;
      AV43AddressLine2 = "" ;
      AV44AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.drogueriawwexportreport__default(),
         new Object[] {
             new Object[] {
            P004M2_A36DrogueriaId, P004M2_A147DrogueriaEstado, P004M2_A145DrogueriaDireccion, P004M2_A144DrogueriaNroDocumento, P004M2_A143DrogueriaTipoDocumento, P004M2_A142DrogueriaDescripcion, P004M2_A141DrogueriaNombre
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV56Pgmname = "DrogueriaWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV56Pgmname = "DrogueriaWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV20TFDrogueriaId ;
   private short AV21TFDrogueriaId_To ;
   private short A36DrogueriaId ;
   private short AV63Drogueriawwds_2_tfdrogueriaid ;
   private short AV64Drogueriawwds_3_tfdrogueriaid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV59GXV1 ;
   private int AV60GXV2 ;
   private int AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ;
   private int AV74Drogueriawwds_13_tfdrogueriaestado_sels_size ;
   private int AV75GXV3 ;
   private long AV41i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV56Pgmname ;
   private String AV29TFDrogueriaTipoDocumento_Sel ;
   private String AV37TFDrogueriaEstado_Sel ;
   private String A143DrogueriaTipoDocumento ;
   private String A147DrogueriaEstado ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV26TFDrogueriaTipoDocumento_SelsJson ;
   private String AV34TFDrogueriaEstado_SelsJson ;
   private String AV52Title ;
   private String AV13FilterFullText ;
   private String AV38TFDrogueriaId_To_Description ;
   private String AV23TFDrogueriaNombre_Sel ;
   private String AV22TFDrogueriaNombre ;
   private String AV25TFDrogueriaDescripcion_Sel ;
   private String AV24TFDrogueriaDescripcion ;
   private String AV27TFDrogueriaTipoDocumento_SelDscs ;
   private String AV39FilterTFDrogueriaTipoDocumento_SelValueDescription ;
   private String AV31TFDrogueriaNroDocumento_Sel ;
   private String AV30TFDrogueriaNroDocumento ;
   private String AV33TFDrogueriaDireccion_Sel ;
   private String AV32TFDrogueriaDireccion ;
   private String AV35TFDrogueriaEstado_SelDscs ;
   private String AV40FilterTFDrogueriaEstado_SelValueDescription ;
   private String A141DrogueriaNombre ;
   private String A142DrogueriaDescripcion ;
   private String A144DrogueriaNroDocumento ;
   private String A145DrogueriaDireccion ;
   private String AV62Drogueriawwds_1_filterfulltext ;
   private String AV65Drogueriawwds_4_tfdroguerianombre ;
   private String AV66Drogueriawwds_5_tfdroguerianombre_sel ;
   private String AV67Drogueriawwds_6_tfdrogueriadescripcion ;
   private String AV68Drogueriawwds_7_tfdrogueriadescripcion_sel ;
   private String AV70Drogueriawwds_9_tfdroguerianrodocumento ;
   private String AV71Drogueriawwds_10_tfdroguerianrodocumento_sel ;
   private String AV72Drogueriawwds_11_tfdrogueriadireccion ;
   private String AV73Drogueriawwds_12_tfdrogueriadireccion_sel ;
   private String lV62Drogueriawwds_1_filterfulltext ;
   private String lV65Drogueriawwds_4_tfdroguerianombre ;
   private String lV67Drogueriawwds_6_tfdrogueriadescripcion ;
   private String lV70Drogueriawwds_9_tfdroguerianrodocumento ;
   private String lV72Drogueriawwds_11_tfdrogueriadireccion ;
   private String AV14DrogueriaTipoDocumentoDescription ;
   private String AV15DrogueriaEstadoDescription ;
   private String AV50PageInfo ;
   private String AV47DateInfo ;
   private String AV45AppName ;
   private String AV51Phone ;
   private String AV49Mail ;
   private String AV53Website ;
   private String AV42AddressLine1 ;
   private String AV43AddressLine2 ;
   private String AV44AddressLine3 ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private IDataStoreProvider pr_default ;
   private short[] P004M2_A36DrogueriaId ;
   private String[] P004M2_A147DrogueriaEstado ;
   private String[] P004M2_A145DrogueriaDireccion ;
   private String[] P004M2_A144DrogueriaNroDocumento ;
   private String[] P004M2_A143DrogueriaTipoDocumento ;
   private String[] P004M2_A142DrogueriaDescripcion ;
   private String[] P004M2_A141DrogueriaNombre ;
   private GXSimpleCollection<String> AV28TFDrogueriaTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV36TFDrogueriaEstado_Sels ;
   private GXSimpleCollection<String> AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels ;
   private GXSimpleCollection<String> AV74Drogueriawwds_13_tfdrogueriaestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV18GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV19GridStateFilterValue ;
}

final  class drogueriawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004M2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A143DrogueriaTipoDocumento ,
                                          GXSimpleCollection<String> AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                          String A147DrogueriaEstado ,
                                          GXSimpleCollection<String> AV74Drogueriawwds_13_tfdrogueriaestado_sels ,
                                          String AV62Drogueriawwds_1_filterfulltext ,
                                          short AV63Drogueriawwds_2_tfdrogueriaid ,
                                          short AV64Drogueriawwds_3_tfdrogueriaid_to ,
                                          String AV66Drogueriawwds_5_tfdroguerianombre_sel ,
                                          String AV65Drogueriawwds_4_tfdroguerianombre ,
                                          String AV68Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                          String AV67Drogueriawwds_6_tfdrogueriadescripcion ,
                                          int AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ,
                                          String AV71Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                          String AV70Drogueriawwds_9_tfdroguerianrodocumento ,
                                          String AV73Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                          String AV72Drogueriawwds_11_tfdrogueriadireccion ,
                                          int AV74Drogueriawwds_13_tfdrogueriaestado_sels_size ,
                                          short A36DrogueriaId ,
                                          String A141DrogueriaNombre ,
                                          String A142DrogueriaDescripcion ,
                                          String A144DrogueriaNroDocumento ,
                                          String A145DrogueriaDireccion ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[23];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [DrogueriaId], [DrogueriaEstado], [DrogueriaDireccion], [DrogueriaNroDocumento], [DrogueriaTipoDocumento], [DrogueriaDescripcion], [DrogueriaNombre] FROM" ;
      scmdbuf += " [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV62Drogueriawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( [DrogueriaNombre] like '%' + ?) or ( [DrogueriaDescripcion] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '0') or ( [DrogueriaNroDocumento] like '%' + ?) or ( [DrogueriaDireccion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [DrogueriaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DrogueriaEstado] = 'I'))");
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
      }
      if ( ! (0==AV63Drogueriawwds_2_tfdrogueriaid) )
      {
         addWhere(sWhereString, "([DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (0==AV64Drogueriawwds_3_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "([DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Drogueriawwds_5_tfdroguerianombre_sel)==0) && ( ! (GXutil.strcmp("", AV65Drogueriawwds_4_tfdroguerianombre)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Drogueriawwds_5_tfdroguerianombre_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV67Drogueriawwds_6_tfdrogueriadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] like ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] = ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Drogueriawwds_8_tfdrogueriatipodocumento_sels, "[DrogueriaTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV71Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV70Drogueriawwds_9_tfdroguerianrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Drogueriawwds_12_tfdrogueriadireccion_sel)==0) && ( ! (GXutil.strcmp("", AV72Drogueriawwds_11_tfdrogueriadireccion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] like ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Drogueriawwds_12_tfdrogueriadireccion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] = ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( AV74Drogueriawwds_13_tfdrogueriaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV74Drogueriawwds_13_tfdrogueriaestado_sels, "[DrogueriaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaEstado]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaEstado] DESC" ;
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
                  return conditional_P004M2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004M2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 80);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 80);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 15);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 15);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               return;
      }
   }

}

