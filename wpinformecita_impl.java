package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpinformecita_impl extends GXWebPanel
{
   public wpinformecita_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpinformecita_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpinformecita_impl.class ));
   }

   public wpinformecita_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSdtpacientedata_pacientetipodocumento = new HTMLChoice();
      cmbavSdtcitadata_citaestadocita = new HTMLChoice();
      cmbavSdtcitadata_citatipodiagnostico = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtdiagnosticogrids") == 0 )
         {
            nRC_GXsfl_128 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_128"))) ;
            nGXsfl_128_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_128_idx"))) ;
            sGXsfl_128_idx = httpContext.GetPar( "sGXsfl_128_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtdiagnosticogrids_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtdiagnosticogrids") == 0 )
         {
            subGridsdtdiagnosticogrids_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtdiagnosticogrids_Rows"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Width", GXutil.rtrim( Dvpanel_panelinformacioncita_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Autowidth", GXutil.booltostr( Dvpanel_panelinformacioncita_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Autoheight", GXutil.booltostr( Dvpanel_panelinformacioncita_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Cls", GXutil.rtrim( Dvpanel_panelinformacioncita_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Title", GXutil.rtrim( Dvpanel_panelinformacioncita_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Collapsible", GXutil.booltostr( Dvpanel_panelinformacioncita_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Collapsed", GXutil.booltostr( Dvpanel_panelinformacioncita_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Showcollapseicon", GXutil.booltostr( Dvpanel_panelinformacioncita_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Iconposition", GXutil.rtrim( Dvpanel_panelinformacioncita_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Autoscroll", GXutil.booltostr( Dvpanel_panelinformacioncita_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Width", GXutil.rtrim( Dvpanel_diagnostico_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Autowidth", GXutil.booltostr( Dvpanel_diagnostico_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Autoheight", GXutil.booltostr( Dvpanel_diagnostico_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Cls", GXutil.rtrim( Dvpanel_diagnostico_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Title", GXutil.rtrim( Dvpanel_diagnostico_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Collapsible", GXutil.booltostr( Dvpanel_diagnostico_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Collapsed", GXutil.booltostr( Dvpanel_diagnostico_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Showcollapseicon", GXutil.booltostr( Dvpanel_diagnostico_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Iconposition", GXutil.rtrim( Dvpanel_diagnostico_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Autoscroll", GXutil.booltostr( Dvpanel_diagnostico_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtdiagnosticogrids_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridsdtdiagnosticogrids_empowerer_Infinitescrolling));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV5CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CitaId), 8, 0));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa6D2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws6D2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we6D2( ) ;
            }
         }
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.projectthani.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( "Informe Cita") ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034652", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpinformecita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0))}, new String[] {"CitaId"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpacientedata", AV31SDTPacienteData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpacientedata", AV31SDTPacienteData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtcitadata", AV27SDTCitaDAta);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtcitadata", AV27SDTCitaDAta);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtdiagnosticogrids", AV30SDTDiagnosticoGrids);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtdiagnosticogrids", AV30SDTDiagnosticoGrids);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_128", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_128, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTCITADATA", AV27SDTCitaDAta);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTCITADATA", AV27SDTCitaDAta);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDIAGNOSTICOGRIDS", AV30SDTDiagnosticoGrids);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDIAGNOSTICOGRIDS", AV30SDTDiagnosticoGrids);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV5CitaId, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDIAGNOSTICOGRID", AV28SDTDiagnosticoGrid);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDIAGNOSTICOGRID", AV28SDTDiagnosticoGrid);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEETCONFIG", AV9MeetConfig);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEETCONFIG", AV9MeetConfig);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOCODIGO", AV11DiagnosticoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICODESCRIPCION", AV12DiagnosticoDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOLONGDESC", AV15DiagnosticoLongDesc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOID", GXutil.ltrim( localUtil.ntoc( AV14DiagnosticoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISSUCCESS", AV7isSuccess);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Width", GXutil.rtrim( Dvpanel_panelinformacioncita_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Autowidth", GXutil.booltostr( Dvpanel_panelinformacioncita_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Autoheight", GXutil.booltostr( Dvpanel_panelinformacioncita_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Cls", GXutil.rtrim( Dvpanel_panelinformacioncita_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Title", GXutil.rtrim( Dvpanel_panelinformacioncita_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Collapsible", GXutil.booltostr( Dvpanel_panelinformacioncita_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Collapsed", GXutil.booltostr( Dvpanel_panelinformacioncita_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Showcollapseicon", GXutil.booltostr( Dvpanel_panelinformacioncita_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Iconposition", GXutil.rtrim( Dvpanel_panelinformacioncita_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELINFORMACIONCITA_Autoscroll", GXutil.booltostr( Dvpanel_panelinformacioncita_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Width", GXutil.rtrim( Dvpanel_diagnostico_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Autowidth", GXutil.booltostr( Dvpanel_diagnostico_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Autoheight", GXutil.booltostr( Dvpanel_diagnostico_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Cls", GXutil.rtrim( Dvpanel_diagnostico_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Title", GXutil.rtrim( Dvpanel_diagnostico_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Collapsible", GXutil.booltostr( Dvpanel_diagnostico_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Collapsed", GXutil.booltostr( Dvpanel_diagnostico_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Showcollapseicon", GXutil.booltostr( Dvpanel_diagnostico_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Iconposition", GXutil.rtrim( Dvpanel_diagnostico_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_DIAGNOSTICO_Autoscroll", GXutil.booltostr( Dvpanel_diagnostico_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtdiagnosticogrids_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridsdtdiagnosticogrids_empowerer_Infinitescrolling));
   }

   public void renderHtmlCloseForm6D2( )
   {
      sendCloseFormHiddens( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WPInformeCita" ;
   }

   public String getPgmdesc( )
   {
      return "Informe Cita" ;
   }

   public void wb6D0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 15,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnretornarhome_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Regresar", bttBtnretornarhome_Jsonclick, 7, "Regresar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116d1_client"+"'", TempTags, "", 2, "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         wb_table1_20_6D2( true) ;
      }
      else
      {
         wb_table1_20_6D2( false) ;
      }
      return  ;
   }

   public void wb_table1_20_6D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelinformacioncita.setProperty("Width", Dvpanel_panelinformacioncita_Width);
         ucDvpanel_panelinformacioncita.setProperty("AutoWidth", Dvpanel_panelinformacioncita_Autowidth);
         ucDvpanel_panelinformacioncita.setProperty("AutoHeight", Dvpanel_panelinformacioncita_Autoheight);
         ucDvpanel_panelinformacioncita.setProperty("Cls", Dvpanel_panelinformacioncita_Cls);
         ucDvpanel_panelinformacioncita.setProperty("Title", Dvpanel_panelinformacioncita_Title);
         ucDvpanel_panelinformacioncita.setProperty("Collapsible", Dvpanel_panelinformacioncita_Collapsible);
         ucDvpanel_panelinformacioncita.setProperty("Collapsed", Dvpanel_panelinformacioncita_Collapsed);
         ucDvpanel_panelinformacioncita.setProperty("ShowCollapseIcon", Dvpanel_panelinformacioncita_Showcollapseicon);
         ucDvpanel_panelinformacioncita.setProperty("IconPosition", Dvpanel_panelinformacioncita_Iconposition);
         ucDvpanel_panelinformacioncita.setProperty("AutoScroll", Dvpanel_panelinformacioncita_Autoscroll);
         ucDvpanel_panelinformacioncita.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelinformacioncita_Internalname, "DVPANEL_PANELINFORMACIONCITAContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELINFORMACIONCITAContainer"+"PanelInformacionCita"+"\" style=\"display:none;\">") ;
         wb_table2_74_6D2( true) ;
      }
      else
      {
         wb_table2_74_6D2( false) ;
      }
      return  ;
   }

   public void wb_table2_74_6D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_diagnostico.setProperty("Width", Dvpanel_diagnostico_Width);
         ucDvpanel_diagnostico.setProperty("AutoWidth", Dvpanel_diagnostico_Autowidth);
         ucDvpanel_diagnostico.setProperty("AutoHeight", Dvpanel_diagnostico_Autoheight);
         ucDvpanel_diagnostico.setProperty("Cls", Dvpanel_diagnostico_Cls);
         ucDvpanel_diagnostico.setProperty("Title", Dvpanel_diagnostico_Title);
         ucDvpanel_diagnostico.setProperty("Collapsible", Dvpanel_diagnostico_Collapsible);
         ucDvpanel_diagnostico.setProperty("Collapsed", Dvpanel_diagnostico_Collapsed);
         ucDvpanel_diagnostico.setProperty("ShowCollapseIcon", Dvpanel_diagnostico_Showcollapseicon);
         ucDvpanel_diagnostico.setProperty("IconPosition", Dvpanel_diagnostico_Iconposition);
         ucDvpanel_diagnostico.setProperty("AutoScroll", Dvpanel_diagnostico_Autoscroll);
         ucDvpanel_diagnostico.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_diagnostico_Internalname, "DVPANEL_DIAGNOSTICOContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_DIAGNOSTICOContainer"+"Diagnostico"+"\" style=\"display:none;\">") ;
         wb_table3_113_6D2( true) ;
      }
      else
      {
         wb_table3_113_6D2( false) ;
      }
      return  ;
   }

   public void wb_table3_113_6D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable2.setProperty("Width", Dvpanel_unnamedtable2_Width);
         ucDvpanel_unnamedtable2.setProperty("AutoWidth", Dvpanel_unnamedtable2_Autowidth);
         ucDvpanel_unnamedtable2.setProperty("AutoHeight", Dvpanel_unnamedtable2_Autoheight);
         ucDvpanel_unnamedtable2.setProperty("Cls", Dvpanel_unnamedtable2_Cls);
         ucDvpanel_unnamedtable2.setProperty("Title", Dvpanel_unnamedtable2_Title);
         ucDvpanel_unnamedtable2.setProperty("Collapsible", Dvpanel_unnamedtable2_Collapsible);
         ucDvpanel_unnamedtable2.setProperty("Collapsed", Dvpanel_unnamedtable2_Collapsed);
         ucDvpanel_unnamedtable2.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable2_Showcollapseicon);
         ucDvpanel_unnamedtable2.setProperty("IconPosition", Dvpanel_unnamedtable2_Iconposition);
         ucDvpanel_unnamedtable2.setProperty("AutoScroll", Dvpanel_unnamedtable2_Autoscroll);
         ucDvpanel_unnamedtable2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable2_Internalname, "DVPANEL_UNNAMEDTABLE2Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE2Container"+"UnnamedTable2"+"\" style=\"display:none;\">") ;
         wb_table4_135_6D2( true) ;
      }
      else
      {
         wb_table4_135_6D2( false) ;
      }
      return  ;
   }

   public void wb_table4_135_6D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection_meet_container_Internalname, 1, 0, "px", 0, "px", "TableZFront", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucMsgdvelop.render(context, "dvelop.dvmessage", Msgdvelop_Internalname, "MSGDVELOPContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtdiagnosticogrids_empowerer.setProperty("InfiniteScrolling", Gridsdtdiagnosticogrids_empowerer_Infinitescrolling);
         ucGridsdtdiagnosticogrids_empowerer.render(context, "wwp.gridempowerer", Gridsdtdiagnosticogrids_empowerer_Internalname, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 128 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nEOF", GRIDSDTDIAGNOSTICOGRIDS_nEOF);
               GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage);
               AV66GXV18 = nGXsfl_128_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtdiagnosticogridsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtdiagnosticogrids", GridsdtdiagnosticogridsContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtdiagnosticogridsContainerData", GridsdtdiagnosticogridsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtdiagnosticogridsContainerData"+"V", GridsdtdiagnosticogridsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtdiagnosticogridsContainerData"+"V"+"\" value='"+GridsdtdiagnosticogridsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start6D2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Informe Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6D0( ) ;
   }

   public void ws6D2( )
   {
      start6D2( ) ;
      evt6D2( ) ;
   }

   public void evt6D2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "'DOGUARDAR'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoGuardar' */
                        e126D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'DOSALIR'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoSalir' */
                        e136D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'DOUNIRSELLAMADA'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoUnirseLlamada' */
                        e146D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.SELECTDIAGNOSTICO") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e156D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.REPROGRAMARCITA") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e166D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "GRIDSDTDIAGNOSTICOGRIDSPAGING") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        sEvt = httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDSPAGING") ;
                        if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                        {
                           subgridsdtdiagnosticogrids_firstpage( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                        {
                           subgridsdtdiagnosticogrids_previouspage( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                        {
                           subgridsdtdiagnosticogrids_nextpage( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                        {
                           subgridsdtdiagnosticogrids_lastpage( ) ;
                        }
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                     if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 28), "GRIDSDTDIAGNOSTICOGRIDS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "'DOEXPORTAREPICRISIS'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "VDIAGNOSTICOELIMINAR.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "VDIAGNOSTICOELIMINAR.CLICK") == 0 ) )
                     {
                        nGXsfl_128_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_1282( ) ;
                        AV66GXV18 = nGXsfl_128_idx ;
                        if ( ( AV30SDTDiagnosticoGrids.size() >= AV66GXV18 ) && ( AV66GXV18 > 0 ) )
                        {
                           AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
                           AV13DiagnosticoEliminar = httpContext.cgiGet( edtavDiagnosticoeliminar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDiagnosticoeliminar_Internalname, AV13DiagnosticoEliminar);
                        }
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e176D2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDSDTDIAGNOSTICOGRIDS.LOAD") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e186D2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "'DOEXPORTAREPICRISIS'") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: 'DoExportarEpicrisis' */
                              e196D2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "VDIAGNOSTICOELIMINAR.CLICK") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e206D2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 Rfr0gs = false ;
                                 if ( ! Rfr0gs )
                                 {
                                 }
                                 dynload_actions( ) ;
                              }
                              /* No code required for Cancel button. It is implemented as the Reset button. */
                           }
                           else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                           }
                        }
                        else
                        {
                        }
                     }
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we6D2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6D2( ) ;
         }
      }
   }

   public void pa6D2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavSdtpacientedata_pacienteapellidopaterno_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridsdtdiagnosticogrids_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1282( ) ;
      while ( nGXsfl_128_idx <= nRC_GXsfl_128 )
      {
         sendrow_1282( ) ;
         nGXsfl_128_idx = ((subGridsdtdiagnosticogrids_Islastpage==1)&&(nGXsfl_128_idx+1>subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ? 1 : nGXsfl_128_idx+1) ;
         sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1282( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtdiagnosticogridsContainer)) ;
      /* End function gxnrGridsdtdiagnosticogrids_newrow */
   }

   public void gxgrgridsdtdiagnosticogrids_refresh( int subGridsdtdiagnosticogrids_Rows )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = 0 ;
      rf6D2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtdiagnosticogrids_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavSdtpacientedata_pacientetipodocumento.getItemCount() > 0 )
      {
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( cmbavSdtpacientedata_pacientetipodocumento.getValidValue(AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtpacientedata_pacientetipodocumento.setValue( GXutil.rtrim( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Values", cmbavSdtpacientedata_pacientetipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavSdtcitadata_citaestadocita.getItemCount() > 0 )
      {
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citaestadocita( cmbavSdtcitadata_citaestadocita.getValidValue(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtcitadata_citaestadocita.setValue( GXutil.rtrim( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citaestadocita.getInternalname(), "Values", cmbavSdtcitadata_citaestadocita.ToJavascriptSource(), true);
      }
      if ( cmbavSdtcitadata_citatipodiagnostico.getItemCount() > 0 )
      {
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citatipodiagnostico( cmbavSdtcitadata_citatipodiagnostico.getValidValue(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtcitadata_citatipodiagnostico.setValue( GXutil.rtrim( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Values", cmbavSdtcitadata_citatipodiagnostico.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = 0 ;
      GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = 0 ;
      GXCCtl = "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage_" + sGXsfl_128_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf6D2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV71Pgmname = "WPInformeCita" ;
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidopaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidomaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenombres_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientecorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientecorreo_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientetelefono_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled), 5, 0), true);
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtpacientedata_pacientetipodocumento.getEnabled(), 5, 0), true);
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenrodocumento_Enabled), 5, 0), true);
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citapesodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citapesodescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaestaturadescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaestaturadescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled), 5, 0), true);
      edtavDiagnosticoeliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiagnosticoeliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiagnosticoeliminar_Enabled), 5, 0), !bGXsfl_128_Refreshing);
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled), 5, 0), !bGXsfl_128_Refreshing);
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citamotivoconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citamotivoconsulta_Enabled), 5, 0), true);
   }

   public void rf6D2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtdiagnosticogridsContainer.ClearRows();
      }
      wbStart = (short)(128) ;
      nGXsfl_128_idx = (int)(1+GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage) ;
      sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1282( ) ;
      bGXsfl_128_Refreshing = true ;
      GridsdtdiagnosticogridsContainer.AddObjectProperty("GridName", "Gridsdtdiagnosticogrids");
      GridsdtdiagnosticogridsContainer.AddObjectProperty("CmpContext", "");
      GridsdtdiagnosticogridsContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtdiagnosticogridsContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
      GridsdtdiagnosticogridsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtdiagnosticogridsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtdiagnosticogridsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtdiagnosticogridsContainer.setPageSize( subgridsdtdiagnosticogrids_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1282( ) ;
         e186D2 ();
         if ( ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord > 0 ) && ( GRIDSDTDIAGNOSTICOGRIDS_nGridOutOfScope == 0 ) && ( nGXsfl_128_idx == 1 ) )
         {
            GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = 0 ;
            GRIDSDTDIAGNOSTICOGRIDS_nGridOutOfScope = 1 ;
            subgridsdtdiagnosticogrids_firstpage( ) ;
            e186D2 ();
         }
         wbEnd = (short)(128) ;
         wb6D0( ) ;
      }
      bGXsfl_128_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6D2( )
   {
   }

   public int subgridsdtdiagnosticogrids_fnc_pagecount( )
   {
      GRIDSDTDIAGNOSTICOGRIDS_nRecordCount = subgridsdtdiagnosticogrids_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTDIAGNOSTICOGRIDS_nRecordCount) % (subgridsdtdiagnosticogrids_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTDIAGNOSTICOGRIDS_nRecordCount/ (double) (subgridsdtdiagnosticogrids_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTDIAGNOSTICOGRIDS_nRecordCount/ (double) (subgridsdtdiagnosticogrids_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtdiagnosticogrids_fnc_recordcount( )
   {
      return AV30SDTDiagnosticoGrids.size() ;
   }

   public int subgridsdtdiagnosticogrids_fnc_recordsperpage( )
   {
      if ( subGridsdtdiagnosticogrids_Rows > 0 )
      {
         return subGridsdtdiagnosticogrids_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtdiagnosticogrids_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage/ (double) (subgridsdtdiagnosticogrids_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtdiagnosticogrids_firstpage( )
   {
      GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtdiagnosticogrids_nextpage( )
   {
      GRIDSDTDIAGNOSTICOGRIDS_nRecordCount = subgridsdtdiagnosticogrids_fnc_recordcount( ) ;
      if ( ( GRIDSDTDIAGNOSTICOGRIDS_nRecordCount >= subgridsdtdiagnosticogrids_fnc_recordsperpage( ) ) && ( GRIDSDTDIAGNOSTICOGRIDS_nEOF == 0 ) )
      {
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = (long)(GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage+subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRIDSDTDIAGNOSTICOGRIDS_nEOF == 1 )
      {
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTDIAGNOSTICOGRIDS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtdiagnosticogrids_previouspage( )
   {
      if ( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage >= subgridsdtdiagnosticogrids_fnc_recordsperpage( ) )
      {
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = (long)(GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage-subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtdiagnosticogrids_lastpage( )
   {
      GRIDSDTDIAGNOSTICOGRIDS_nRecordCount = subgridsdtdiagnosticogrids_fnc_recordcount( ) ;
      if ( GRIDSDTDIAGNOSTICOGRIDS_nRecordCount > subgridsdtdiagnosticogrids_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTDIAGNOSTICOGRIDS_nRecordCount) % (subgridsdtdiagnosticogrids_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = (long)(GRIDSDTDIAGNOSTICOGRIDS_nRecordCount-subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = (long)(GRIDSDTDIAGNOSTICOGRIDS_nRecordCount-((int)((GRIDSDTDIAGNOSTICOGRIDS_nRecordCount) % (subgridsdtdiagnosticogrids_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtdiagnosticogrids_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = (long)(subgridsdtdiagnosticogrids_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV71Pgmname = "WPInformeCita" ;
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidopaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidomaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenombres_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientecorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientecorreo_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientetelefono_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled), 5, 0), true);
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtpacientedata_pacientetipodocumento.getEnabled(), 5, 0), true);
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenrodocumento_Enabled), 5, 0), true);
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citapesodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citapesodescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaestaturadescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaestaturadescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled), 5, 0), true);
      edtavDiagnosticoeliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiagnosticoeliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiagnosticoeliminar_Enabled), 5, 0), !bGXsfl_128_Refreshing);
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled), 5, 0), !bGXsfl_128_Refreshing);
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citamotivoconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citamotivoconsulta_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup6D0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e176D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpacientedata"), AV31SDTPacienteData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtcitadata"), AV27SDTCitaDAta);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtdiagnosticogrids"), AV30SDTDiagnosticoGrids);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTDIAGNOSTICOGRIDS"), AV30SDTDiagnosticoGrids);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTDIAGNOSTICOGRID"), AV28SDTDiagnosticoGrid);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTCITADATA"), AV27SDTCitaDAta);
         /* Read saved values. */
         nRC_GXsfl_128 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_128"), ",", ".")) ;
         AV5CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vCITAID"), ",", ".")) ;
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTDIAGNOSTICOGRIDS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_nEOF"), ",", ".")) ;
         subGridsdtdiagnosticogrids_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         Dvpanel_panelinformacioncita_Width = httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Width") ;
         Dvpanel_panelinformacioncita_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Autowidth")) ;
         Dvpanel_panelinformacioncita_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Autoheight")) ;
         Dvpanel_panelinformacioncita_Cls = httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Cls") ;
         Dvpanel_panelinformacioncita_Title = httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Title") ;
         Dvpanel_panelinformacioncita_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Collapsible")) ;
         Dvpanel_panelinformacioncita_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Collapsed")) ;
         Dvpanel_panelinformacioncita_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Showcollapseicon")) ;
         Dvpanel_panelinformacioncita_Iconposition = httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Iconposition") ;
         Dvpanel_panelinformacioncita_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELINFORMACIONCITA_Autoscroll")) ;
         Dvpanel_diagnostico_Width = httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Width") ;
         Dvpanel_diagnostico_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Autowidth")) ;
         Dvpanel_diagnostico_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Autoheight")) ;
         Dvpanel_diagnostico_Cls = httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Cls") ;
         Dvpanel_diagnostico_Title = httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Title") ;
         Dvpanel_diagnostico_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Collapsible")) ;
         Dvpanel_diagnostico_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Collapsed")) ;
         Dvpanel_diagnostico_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Showcollapseicon")) ;
         Dvpanel_diagnostico_Iconposition = httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Iconposition") ;
         Dvpanel_diagnostico_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_DIAGNOSTICO_Autoscroll")) ;
         Dvpanel_unnamedtable2_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Width") ;
         Dvpanel_unnamedtable2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autowidth")) ;
         Dvpanel_unnamedtable2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoheight")) ;
         Dvpanel_unnamedtable2_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Cls") ;
         Dvpanel_unnamedtable2_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Title") ;
         Dvpanel_unnamedtable2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsible")) ;
         Dvpanel_unnamedtable2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsed")) ;
         Dvpanel_unnamedtable2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showcollapseicon")) ;
         Dvpanel_unnamedtable2_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Iconposition") ;
         Dvpanel_unnamedtable2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoscroll")) ;
         Gridsdtdiagnosticogrids_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Gridinternalname") ;
         Gridsdtdiagnosticogrids_empowerer_Infinitescrolling = httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Infinitescrolling") ;
         nRC_GXsfl_128 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_128"), ",", ".")) ;
         nGXsfl_128_fel_idx = 0 ;
         while ( nGXsfl_128_fel_idx < nRC_GXsfl_128 )
         {
            nGXsfl_128_fel_idx = ((subGridsdtdiagnosticogrids_Islastpage==1)&&(nGXsfl_128_fel_idx+1>subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ? 1 : nGXsfl_128_fel_idx+1) ;
            sGXsfl_128_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1282( ) ;
            AV66GXV18 = nGXsfl_128_fel_idx ;
            if ( ( AV30SDTDiagnosticoGrids.size() >= AV66GXV18 ) && ( AV66GXV18 > 0 ) )
            {
               AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
               AV13DiagnosticoEliminar = httpContext.cgiGet( edtavDiagnosticoeliminar_Internalname) ;
            }
         }
         if ( nGXsfl_128_fel_idx == 0 )
         {
            nGXsfl_128_idx = 1 ;
            sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1282( ) ;
         }
         nGXsfl_128_fel_idx = 1 ;
         /* Read variables values. */
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacienteapellidopaterno( httpContext.cgiGet( edtavSdtpacientedata_pacienteapellidopaterno_Internalname) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacienteapellidomaterno( httpContext.cgiGet( edtavSdtpacientedata_pacienteapellidomaterno_Internalname) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientenombres( httpContext.cgiGet( edtavSdtpacientedata_pacientenombres_Internalname) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientecorreo( httpContext.cgiGet( edtavSdtpacientedata_pacientecorreo_Internalname) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetelefono( httpContext.cgiGet( edtavSdtpacientedata_pacientetelefono_Internalname) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion( httpContext.cgiGet( edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname) );
         cmbavSdtpacientedata_pacientetipodocumento.setName( cmbavSdtpacientedata_pacientetipodocumento.getInternalname() );
         cmbavSdtpacientedata_pacientetipodocumento.setValue( httpContext.cgiGet( cmbavSdtpacientedata_pacientetipodocumento.getInternalname()) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( httpContext.cgiGet( cmbavSdtpacientedata_pacientetipodocumento.getInternalname()) );
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientenrodocumento( httpContext.cgiGet( edtavSdtpacientedata_pacientenrodocumento_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citapesodescripcion( httpContext.cgiGet( edtavSdtcitadata_citapesodescripcion_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citaestaturadescripcion( httpContext.cgiGet( edtavSdtcitadata_citaestaturadescripcion_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname) );
         if ( localUtil.vcdate( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "SDTCITADATA_SGCITADISPONIBILIDADFECHA");
            GX_FocusControl = edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( GXutil.nullDate() );
         }
         else
         {
            AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( localUtil.ctod( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname), 3) );
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "SDTCITADATA_SGCITADISPONIBILIDADHORAINICIO");
            GX_FocusControl = edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( GXutil.nullDate() );
         }
         else
         {
            AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( localUtil.ctot( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname)) );
         }
         cmbavSdtcitadata_citaestadocita.setName( cmbavSdtcitadata_citaestadocita.getInternalname() );
         cmbavSdtcitadata_citaestadocita.setValue( httpContext.cgiGet( cmbavSdtcitadata_citaestadocita.getInternalname()) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citaestadocita( httpContext.cgiGet( cmbavSdtcitadata_citaestadocita.getInternalname()) );
         cmbavSdtcitadata_citatipodiagnostico.setName( cmbavSdtcitadata_citatipodiagnostico.getInternalname() );
         cmbavSdtcitadata_citatipodiagnostico.setValue( httpContext.cgiGet( cmbavSdtcitadata_citatipodiagnostico.getInternalname()) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citatipodiagnostico( httpContext.cgiGet( cmbavSdtcitadata_citatipodiagnostico.getInternalname()) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citamotivoconsulta( httpContext.cgiGet( edtavSdtcitadata_citamotivoconsulta_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citaantecedentes( httpContext.cgiGet( edtavSdtcitadata_citaantecedentes_Internalname) );
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citainforme( httpContext.cgiGet( edtavSdtcitadata_citainforme_Internalname) );
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e176D2 ();
      if (returnInSub) return;
   }

   public void e176D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV43isOpenVideoCall = false ;
      bttBtnregistrarreceta_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnregistrarreceta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnregistrarreceta_Visible), 5, 0), true);
      if ( ! (0==AV5CitaId) )
      {
         /* Execute user subroutine: 'LOADDATA' */
         S112 ();
         if (returnInSub) return;
      }
      else
      {
         httpContext.GX_msglist.addItem("El Id de la Cita no puede estar vacía");
         httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV5CitaId)});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV5CitaId"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      lblBtntxtepicrisis_Link = formatLink("com.projectthani.aprocepicrisis", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0))}, new String[] {"CitaId"})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtntxtepicrisis_Internalname, "Link", lblBtntxtepicrisis_Link, true);
      lblBtntxtepicrisis_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtntxtepicrisis_Internalname, "Linktarget", lblBtntxtepicrisis_Linktarget, true);
      GXt_boolean1 = AV18IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WPInformeCita", GXv_boolean2) ;
      wpinformecita_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV18IsAuthorized = GXt_boolean1 ;
      if ( ! AV18IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV71Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      Gridsdtdiagnosticogrids_empowerer_Gridinternalname = subGridsdtdiagnosticogrids_Internalname ;
      ucGridsdtdiagnosticogrids_empowerer.sendProperty(context, "", false, Gridsdtdiagnosticogrids_empowerer_Internalname, "GridInternalName", Gridsdtdiagnosticogrids_empowerer_Gridinternalname);
      subGridsdtdiagnosticogrids_Rows = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
      /* Using cursor H006D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV5CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89CitaEstadoCita = H006D2_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = H006D2_n89CitaEstadoCita[0] ;
         A95CitaEstado = H006D2_A95CitaEstado[0] ;
         n95CitaEstado = H006D2_n95CitaEstado[0] ;
         A19CitaId = H006D2_A19CitaId[0] ;
         A20PacienteId = H006D2_A20PacienteId[0] ;
         A64CitaCode = H006D2_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = H006D2_A21SGCitaDisponibilidadId[0] ;
         AV44PacienteId = A20PacienteId ;
         AV45CodigoCita = A64CitaCode ;
         AV46DisponibilidadId = A21SGCitaDisponibilidadId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV33Domain = "meet.jit.si" ;
      AV73Roomname = AV45CodigoCita ;
      AV9MeetConfig = (com.hugao.hugaojitsiclient.common.SdtMeetConfig)new com.hugao.hugaojitsiclient.common.SdtMeetConfig(remoteHandle, context);
      AV9MeetConfig.setgxTv_SdtMeetConfig_Domain( AV33Domain );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().setgxTv_SdtMeetConfig_Options_Roomname( AV73Roomname );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Deeplinking( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Sharingchrome( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Sharingfirefox( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Notstoreroom( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Welcomepage( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Closepage( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Defaultlanguage( "es" );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startaudioonly( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startwithaudiomuted( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startwithvideomuted( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Resolution( (short)(1080) );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Recording().setgxTv_SdtMeetConfig_Options_Config_Recording_Recordingsservice( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Recording().setgxTv_SdtMeetConfig_Options_Config_Recording_Livestreamingenabled( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Filmstriponly( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Jitsiwatermark( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Watermarkforguests( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Brandwatermark( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Poweredby( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Verticalfilmstrip( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Disableringing( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Mobileapppromo( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Connectionindicatordisabled( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Videoqualitylabeldisabled( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().getgxTv_SdtMeetConfig_Options_InterfaceConfig_Settingssections().add("devices", 0);
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Videolayoutfit( "both" );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Openinmobilebrowser( true );
   }

   private void e186D2( )
   {
      /* Gridsdtdiagnosticogrids_Load Routine */
      returnInSub = false ;
      AV66GXV18 = 1 ;
      while ( AV66GXV18 <= AV30SDTDiagnosticoGrids.size() )
      {
         AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
         AV13DiagnosticoEliminar = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDiagnosticoeliminar_Internalname, AV13DiagnosticoEliminar);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(128) ;
         }
         if ( ( subGridsdtdiagnosticogrids_Islastpage == 1 ) || ( subGridsdtdiagnosticogrids_Rows == 0 ) || ( ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord >= GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage ) && ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord < GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage + subgridsdtdiagnosticogrids_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1282( ) ;
            GRIDSDTDIAGNOSTICOGRIDS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord + 1 >= subgridsdtdiagnosticogrids_fnc_recordcount( ) )
            {
               GRIDSDTDIAGNOSTICOGRIDS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = (long)(GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_128_Refreshing )
         {
            httpContext.doAjaxLoad(128, GridsdtdiagnosticogridsRow);
         }
         AV66GXV18 = (int)(AV66GXV18+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e126D2( )
   {
      AV66GXV18 = nGXsfl_128_idx ;
      if ( AV30SDTDiagnosticoGrids.size() >= AV66GXV18 )
      {
         AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
      }
      /* 'DoGuardar' Routine */
      returnInSub = false ;
      GXv_char3[0] = AV16ErrorMessageSaveCita ;
      GXv_boolean2[0] = AV6isSaved ;
      new com.projectthani.prcguardarinformecita(remoteHandle, context).execute( AV27SDTCitaDAta, GXv_char3, GXv_boolean2) ;
      wpinformecita_impl.this.AV16ErrorMessageSaveCita = GXv_char3[0] ;
      wpinformecita_impl.this.AV6isSaved = GXv_boolean2[0] ;
      if ( AV6isSaved )
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", AV16ErrorMessageSaveCita, "success", "", "true"));
         new com.projectthani.prcguardardiagnosticos(remoteHandle, context).execute( AV30SDTDiagnosticoGrids, AV5CitaId) ;
         if ( GXutil.strcmp(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita(), "F") == 0 )
         {
            bttBtnreprogramar_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnreprogramar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnreprogramar_Visible), 5, 0), true);
            bttBtnregistrarreceta_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnregistrarreceta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnregistrarreceta_Visible), 5, 0), true);
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", AV16ErrorMessageSaveCita, "error", "", "true"));
      }
      /*  Sending Event outputs  */
   }

   public void e136D2( )
   {
      /* 'DoSalir' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV5CitaId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV5CitaId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void e146D2( )
   {
      /* 'DoUnirseLlamada' Routine */
      returnInSub = false ;
      AV43isOpenVideoCall = true ;
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Displayname( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname() );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Email( "" );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Avatarimage( "" );
      AV8JitsiJWTContext = (com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext)new com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext(remoteHandle, context);
      AV8JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Id( java.util.UUID.randomUUID( ).toString() );
      AV8JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Name( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname() );
      AV8JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Email( "" );
      AV8JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Avatar( "" );
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "_JITSI_MEET_CONTAINER", divSection_meet_container_Internalname);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "UseAllWindowForMeet", true);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "DisposeOnUnload", false);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "PipLocation", "tr");
      this.executeExternalObjectMethod("", false, "gx.hugao.jitsiclient.meet", "prepare", new Object[] {AV9MeetConfig,Boolean.valueOf(true)}, false);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV9MeetConfig", AV9MeetConfig);
   }

   public void e196D2( )
   {
      /* 'DoExportarEpicrisis' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.aprocepicrisis", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0))}, new String[] {"CitaId"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
   }

   public void e156D2( )
   {
      AV66GXV18 = nGXsfl_128_idx ;
      if ( AV30SDTDiagnosticoGrids.size() >= AV66GXV18 )
      {
         AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
      }
      /* GlobalEvents_Selectdiagnostico Routine */
      returnInSub = false ;
      AV28SDTDiagnosticoGrid = (com.projectthani.SdtSDTDiagnosticoGrid)new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo( AV11DiagnosticoCodigo );
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion( AV12DiagnosticoDescripcion );
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc( AV15DiagnosticoLongDesc );
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid( AV14DiagnosticoId );
      AV30SDTDiagnosticoGrids.add(AV28SDTDiagnosticoGrid, 0);
      gx_BV128 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28SDTDiagnosticoGrid", AV28SDTDiagnosticoGrid);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30SDTDiagnosticoGrids", AV30SDTDiagnosticoGrids);
      nGXsfl_128_bak_idx = nGXsfl_128_idx ;
      gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      nGXsfl_128_idx = nGXsfl_128_bak_idx ;
      sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1282( ) ;
   }

   public void e206D2( )
   {
      AV66GXV18 = nGXsfl_128_idx ;
      if ( AV30SDTDiagnosticoGrids.size() >= AV66GXV18 )
      {
         AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
      }
      /* Diagnosticoeliminar_Click Routine */
      returnInSub = false ;
      AV28SDTDiagnosticoGrid = (com.projectthani.SdtSDTDiagnosticoGrid)((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.currentItem());
      AV17i = (short)(AV30SDTDiagnosticoGrids.size()) ;
      while ( AV17i > 0 )
      {
         if ( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV17i)).getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid() == AV28SDTDiagnosticoGrid.getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid() )
         {
            AV30SDTDiagnosticoGrids.removeItem(AV17i);
            gx_BV128 = true ;
            new com.projectthani.prceliminardiagnostico(remoteHandle, context).execute( AV5CitaId, AV28SDTDiagnosticoGrid.getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid()) ;
         }
         AV17i = (short)(AV17i-1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28SDTDiagnosticoGrid", AV28SDTDiagnosticoGrid);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30SDTDiagnosticoGrids", AV30SDTDiagnosticoGrids);
      nGXsfl_128_bak_idx = nGXsfl_128_idx ;
      gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      nGXsfl_128_idx = nGXsfl_128_bak_idx ;
      sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1282( ) ;
   }

   public void e166D2( )
   {
      AV66GXV18 = nGXsfl_128_idx ;
      if ( AV30SDTDiagnosticoGrids.size() >= AV66GXV18 )
      {
         AV30SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)) );
      }
      /* GlobalEvents_Reprogramarcita Routine */
      returnInSub = false ;
      if ( AV7isSuccess )
      {
         /* Execute user subroutine: 'LOADDATA' */
         S112 ();
         if (returnInSub) return;
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", "Se reprogramó satisfactoriamente", "success", "", "true"));
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", "Ocurrió un error al realizar la reprogramación", "error", "", "true"));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27SDTCitaDAta", AV27SDTCitaDAta);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31SDTPacienteData", AV31SDTPacienteData);
      if ( gx_BV128 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30SDTDiagnosticoGrids", AV30SDTDiagnosticoGrids);
         nGXsfl_128_bak_idx = nGXsfl_128_idx ;
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
         nGXsfl_128_idx = nGXsfl_128_bak_idx ;
         sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1282( ) ;
      }
   }

   public void S112( )
   {
      /* 'LOADDATA' Routine */
      returnInSub = false ;
      GXt_SdtSDTCitaData4 = AV27SDTCitaDAta;
      GXv_SdtSDTCitaData5[0] = GXt_SdtSDTCitaData4;
      new com.projectthani.dpgetcitabyid(remoteHandle, context).execute( AV5CitaId, GXv_SdtSDTCitaData5) ;
      GXt_SdtSDTCitaData4 = GXv_SdtSDTCitaData5[0] ;
      AV27SDTCitaDAta = GXt_SdtSDTCitaData4;
      GXt_SdtSDTPacienteData6 = AV31SDTPacienteData;
      GXv_SdtSDTPacienteData7[0] = GXt_SdtSDTPacienteData6;
      new com.projectthani.dpgetpacientebyid(remoteHandle, context).execute( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Pacienteid(), GXv_SdtSDTPacienteData7) ;
      GXt_SdtSDTPacienteData6 = GXv_SdtSDTPacienteData7[0] ;
      AV31SDTPacienteData = GXt_SdtSDTPacienteData6;
      GXt_objcol_SdtSDTDiagnosticoGrid8 = AV30SDTDiagnosticoGrids ;
      GXv_objcol_SdtSDTDiagnosticoGrid9[0] = GXt_objcol_SdtSDTDiagnosticoGrid8 ;
      new com.projectthani.dpgetdiagnosticosbycitaid(remoteHandle, context).execute( AV5CitaId, GXv_objcol_SdtSDTDiagnosticoGrid9) ;
      GXt_objcol_SdtSDTDiagnosticoGrid8 = GXv_objcol_SdtSDTDiagnosticoGrid9[0] ;
      AV30SDTDiagnosticoGrids = GXt_objcol_SdtSDTDiagnosticoGrid8 ;
      gx_BV128 = true ;
      if ( GXutil.strcmp(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita(), "F") == 0 )
      {
         bttBtnreprogramar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnreprogramar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnreprogramar_Visible), 5, 0), true);
         bttBtnregistrarreceta_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnregistrarreceta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnregistrarreceta_Visible), 5, 0), true);
      }
   }

   public void wb_table4_135_6D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "TableFullWidth", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb10'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citamotivoconsulta_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citamotivoconsulta_Internalname, "Motivo Consulta", "gx-form-item AttributeFormCustomLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtcitadata_citamotivoconsulta_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citamotivoconsulta(), "", "", (short)(0), 1, edtavSdtcitadata_citamotivoconsulta_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb10'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citaantecedentes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citaantecedentes_Internalname, "Antecedentes", "gx-form-item AttributeFormCustomLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 145,'',false,'" + sGXsfl_128_idx + "',0)\"" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtcitadata_citaantecedentes_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaantecedentes(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,145);\"", (short)(0), 1, edtavSdtcitadata_citaantecedentes_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb10'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citainforme_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citainforme_Internalname, "Historia Médico Actual", "gx-form-item AttributeFormCustomLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 150,'',false,'" + sGXsfl_128_idx + "',0)\"" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtcitadata_citainforme_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citainforme(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,150);\"", (short)(0), 1, edtavSdtcitadata_citainforme_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnguardar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Guardar", bttBtnguardar_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGUARDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblBtntxtepicrisis_Internalname, "Epicrisis", lblBtntxtepicrisis_Link, lblBtntxtepicrisis_Linktarget, lblBtntxtepicrisis_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonMaterialPrincipal AttributeSizeLarge", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnsalir_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Salir", bttBtnsalir_Jsonclick, 5, "Salir", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSALIR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_135_6D2e( true) ;
      }
      else
      {
         wb_table4_135_6D2e( false) ;
      }
   }

   public void wb_table3_113_6D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblDiagnostico_Internalname, tblDiagnostico_Internalname, "", "TableFullWidth", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb10 DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtcitadata_citatipodiagnostico_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtcitadata_citatipodiagnostico_Internalname, "Tipo Diagnóstico", "", "", lblTextblocksdtcitadata_citatipodiagnostico_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Cita Tipo Diagnostico", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'" + sGXsfl_128_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtcitadata_citatipodiagnostico, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), GXutil.rtrim( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citatipodiagnostico()), 1, cmbavSdtcitadata_citatipodiagnostico.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavSdtcitadata_citatipodiagnostico.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeFormCustom", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,122);\"", "", true, (byte)(1), "HLP_WPInformeCita.htm");
         cmbavSdtcitadata_citatipodiagnostico.setValue( GXutil.rtrim( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Values", cmbavSdtcitadata_citatipodiagnostico.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb10'>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnagregardiagnostico_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Asignar Diagnóstico", bttBtnagregardiagnostico_Jsonclick, 7, "Asignar Diagnóstico", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e216d1_client"+"'", TempTags, "", 2, "HLP_WPInformeCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\" class='mb10 ml15 AttributeFormCustom HasGridEmpowerer'>") ;
         /*  Grid Control  */
         GridsdtdiagnosticogridsContainer.SetWrapped(nGXWrapped);
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtdiagnosticogridsContainer"+"DivS\" data-gxgridid=\"128\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtdiagnosticogrids_Internalname, subGridsdtdiagnosticogrids_Internalname, "", "GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtdiagnosticogrids_Backcolorstyle == 0 )
            {
               subGridsdtdiagnosticogrids_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtdiagnosticogrids_Class) > 0 )
               {
                  subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtdiagnosticogrids_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtdiagnosticogrids_Backcolorstyle == 1 )
               {
                  subGridsdtdiagnosticogrids_Titlebackcolor = subGridsdtdiagnosticogrids_Allbackcolor ;
                  if ( GXutil.len( subGridsdtdiagnosticogrids_Class) > 0 )
                  {
                     subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtdiagnosticogrids_Class) > 0 )
                  {
                     subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeFormCustom"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeFormCustom"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Diagnósticos Asignados") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtdiagnosticogridsContainer.AddObjectProperty("GridName", "Gridsdtdiagnosticogrids");
         }
         else
         {
            GridsdtdiagnosticogridsContainer.AddObjectProperty("GridName", "Gridsdtdiagnosticogrids");
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Header", subGridsdtdiagnosticogrids_Header);
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("CmpContext", "");
            GridsdtdiagnosticogridsContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtdiagnosticogridsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtdiagnosticogridsColumn.AddObjectProperty("Value", AV13DiagnosticoEliminar);
            GridsdtdiagnosticogridsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDiagnosticoeliminar_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddColumnProperties(GridsdtdiagnosticogridsColumn);
            GridsdtdiagnosticogridsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtdiagnosticogridsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddColumnProperties(GridsdtdiagnosticogridsColumn);
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 128 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_128 = (int)(nGXsfl_128_idx-1) ;
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nEOF", GRIDSDTDIAGNOSTICOGRIDS_nEOF);
            GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage);
            AV66GXV18 = nGXsfl_128_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtdiagnosticogridsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtdiagnosticogrids", GridsdtdiagnosticogridsContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtdiagnosticogridsContainerData", GridsdtdiagnosticogridsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtdiagnosticogridsContainerData"+"V", GridsdtdiagnosticogridsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtdiagnosticogridsContainerData"+"V"+"\" value='"+GridsdtdiagnosticogridsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_113_6D2e( true) ;
      }
      else
      {
         wb_table3_113_6D2e( false) ;
      }
   }

   public void wb_table2_74_6D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelinformacioncita_Internalname, tblPanelinformacioncita_Internalname, "", "TableFullWidth", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Especialidad", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(), GXutil.rtrim( localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname, "Sede", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre(), GXutil.rtrim( localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadsedenombre_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, "Profesional", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname(), GXutil.rtrim( localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadprofullname_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, "Fecha", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, localUtil.format(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha(), "99/99/99"), localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha(), "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadfecha_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPInformeCita.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, "Hora Inicio", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, localUtil.ttoc( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio(), 10, 8, 0, 3, "/", ":", " "), localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio(), "99:99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadhorainicio_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPInformeCita.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSdtcitadata_citaestadocita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtcitadata_citaestadocita.getInternalname(), "Estado", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'" + sGXsfl_128_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtcitadata_citaestadocita, cmbavSdtcitadata_citaestadocita.getInternalname(), GXutil.rtrim( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita()), 1, cmbavSdtcitadata_citaestadocita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavSdtcitadata_citaestadocita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeFormCustom", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", "", true, (byte)(1), "HLP_WPInformeCita.htm");
         cmbavSdtcitadata_citaestadocita.setValue( GXutil.rtrim( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citaestadocita.getInternalname(), "Values", cmbavSdtcitadata_citaestadocita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Right", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnregistrarreceta_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Registrar Receta", bttBtnregistrarreceta_Jsonclick, 7, "Registrar Receta", "", StyleString, ClassString, bttBtnregistrarreceta_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e226d1_client"+"'", TempTags, "", 2, "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 mt10", "Right", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialWarn" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnreprogramar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Re-Programar", bttBtnreprogramar_Jsonclick, 7, "Re-Programar", "", StyleString, ClassString, bttBtnreprogramar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e236d1_client"+"'", TempTags, "", 2, "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_74_6D2e( true) ;
      }
      else
      {
         wb_table2_74_6D2e( false) ;
      }
   }

   public void wb_table1_20_6D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "TableFullWidth", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable5_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacienteapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Ap. Paterno", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacienteapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacienteapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Ap. Materno", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacienteapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientenombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientenombres_Internalname, "Nombres", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientenombres_Internalname, AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenombres(), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenombres(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientenombres_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientenombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientecorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientecorreo_Internalname, "Correo", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientecorreo_Internalname, AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientecorreo(), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientecorreo(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientecorreo_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientecorreo_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientetelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientetelefono_Internalname, "Telefono", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientetelefono_Internalname, GXutil.rtrim( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetelefono()), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetelefono(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientetelefono_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientetelefono_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Fecha Nac.", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSdtpacientedata_pacientetipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Tipo Documento", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtpacientedata_pacientetipodocumento, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), GXutil.rtrim( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()), 1, cmbavSdtpacientedata_pacientetipodocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavSdtpacientedata_pacientetipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeFormCustom", "", "", "", "", true, (byte)(1), "HLP_WPInformeCita.htm");
         cmbavSdtpacientedata_pacientetipodocumento.setValue( GXutil.rtrim( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Values", cmbavSdtpacientedata_pacientetipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientenrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientenrodocumento_Internalname, "Nro Documento", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientenrodocumento_Internalname, AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenrodocumento(), GXutil.rtrim( localUtil.format( AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenrodocumento(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientenrodocumento_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientenrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citapesodescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citapesodescripcion_Internalname, "Peso", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citapesodescripcion_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citapesodescripcion(), GXutil.rtrim( localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citapesodescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citapesodescripcion_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_citapesodescripcion_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-md-4 col-lg-3 mb10 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citaestaturadescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citaestaturadescripcion_Internalname, "Estatura", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citaestaturadescripcion_Internalname, AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestaturadescripcion(), GXutil.rtrim( localUtil.format( AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestaturadescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citaestaturadescripcion_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_citaestaturadescripcion_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPInformeCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnunirsellamada_Internalname, "gx.evt.setGridEvt("+GXutil.str( 128, 3, 0)+","+"null"+");", "Unirse a la llamada", bttBtnunirsellamada_Jsonclick, 5, "Unirse a la llamada", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUNIRSELLAMADA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPInformeCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_20_6D2e( true) ;
      }
      else
      {
         wb_table1_20_6D2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CitaId), 8, 0));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa6D2( ) ;
      ws6D2( ) ;
      we6D2( ) ;
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110341141", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("wpinformecita.js", "?20225110341141", false, true);
      httpContext.AddJavascriptSource("Resources\\HugaoJitsiClient\\gx-hugao-jitsiclient.js", "", false, true);
      httpContext.AddJavascriptSource("Resources\\HugaoJitsiClient\\gx-hugao-jitsiclient.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1282( )
   {
      edtavDiagnosticoeliminar_Internalname = "vDIAGNOSTICOELIMINAR_"+sGXsfl_128_idx ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOLONGDESC_"+sGXsfl_128_idx ;
   }

   public void subsflControlProps_fel_1282( )
   {
      edtavDiagnosticoeliminar_Internalname = "vDIAGNOSTICOELIMINAR_"+sGXsfl_128_fel_idx ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOLONGDESC_"+sGXsfl_128_fel_idx ;
   }

   public void sendrow_1282( )
   {
      subsflControlProps_1282( ) ;
      wb6D0( ) ;
      if ( ( subGridsdtdiagnosticogrids_Rows * 1 == 0 ) || ( nGXsfl_128_idx - GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage <= subgridsdtdiagnosticogrids_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtdiagnosticogridsRow = GXWebRow.GetNew(context,GridsdtdiagnosticogridsContainer) ;
         if ( subGridsdtdiagnosticogrids_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtdiagnosticogrids_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtdiagnosticogrids_Class, "") != 0 )
            {
               subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Odd" ;
            }
         }
         else if ( subGridsdtdiagnosticogrids_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtdiagnosticogrids_Backstyle = (byte)(0) ;
            subGridsdtdiagnosticogrids_Backcolor = subGridsdtdiagnosticogrids_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtdiagnosticogrids_Class, "") != 0 )
            {
               subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtdiagnosticogrids_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtdiagnosticogrids_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtdiagnosticogrids_Class, "") != 0 )
            {
               subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Odd" ;
            }
            subGridsdtdiagnosticogrids_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtdiagnosticogrids_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtdiagnosticogrids_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_128_idx) % (2))) == 0 )
            {
               subGridsdtdiagnosticogrids_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtdiagnosticogrids_Class, "") != 0 )
               {
                  subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtdiagnosticogrids_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtdiagnosticogrids_Class, "") != 0 )
               {
                  subGridsdtdiagnosticogrids_Linesclass = subGridsdtdiagnosticogrids_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_128_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDiagnosticoeliminar_Enabled!=0)&&(edtavDiagnosticoeliminar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 129,'',false,'"+sGXsfl_128_idx+"',128)\"" : " ") ;
         ROClassString = "AttributeFormCustom" ;
         GridsdtdiagnosticogridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDiagnosticoeliminar_Internalname,AV13DiagnosticoEliminar,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDiagnosticoeliminar_Enabled!=0)&&(edtavDiagnosticoeliminar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,129);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDIAGNOSTICOELIMINAR.CLICK."+sGXsfl_128_idx+"'","","","","",edtavDiagnosticoeliminar_Jsonclick,Integer.valueOf(5),"AttributeFormCustom","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDiagnosticoeliminar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(128),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeFormCustom" ;
         GridsdtdiagnosticogridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname,((com.projectthani.SdtSDTDiagnosticoGrid)AV30SDTDiagnosticoGrids.elementAt(-1+AV66GXV18)).getgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtdiagnosticogrids__diagnosticolongdesc_Jsonclick,Integer.valueOf(0),"AttributeFormCustom","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(128),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes6D2( ) ;
         GridsdtdiagnosticogridsContainer.AddRow(GridsdtdiagnosticogridsRow);
         nGXsfl_128_idx = ((subGridsdtdiagnosticogrids_Islastpage==1)&&(nGXsfl_128_idx+1>subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ? 1 : nGXsfl_128_idx+1) ;
         sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1282( ) ;
      }
      /* End function sendrow_1282 */
   }

   public void init_default_properties( )
   {
      bttBtnretornarhome_Internalname = "BTNRETORNARHOME" ;
      edtavSdtpacientedata_pacienteapellidopaterno_Internalname = "SDTPACIENTEDATA_PACIENTEAPELLIDOPATERNO" ;
      edtavSdtpacientedata_pacienteapellidomaterno_Internalname = "SDTPACIENTEDATA_PACIENTEAPELLIDOMATERNO" ;
      edtavSdtpacientedata_pacientenombres_Internalname = "SDTPACIENTEDATA_PACIENTENOMBRES" ;
      edtavSdtpacientedata_pacientecorreo_Internalname = "SDTPACIENTEDATA_PACIENTECORREO" ;
      edtavSdtpacientedata_pacientetelefono_Internalname = "SDTPACIENTEDATA_PACIENTETELEFONO" ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname = "SDTPACIENTEDATA_PACIENTEFECHANACIMIENTODESCRIPCION" ;
      cmbavSdtpacientedata_pacientetipodocumento.setInternalname( "SDTPACIENTEDATA_PACIENTETIPODOCUMENTO" );
      edtavSdtpacientedata_pacientenrodocumento_Internalname = "SDTPACIENTEDATA_PACIENTENRODOCUMENTO" ;
      edtavSdtcitadata_citapesodescripcion_Internalname = "SDTCITADATA_CITAPESODESCRIPCION" ;
      edtavSdtcitadata_citaestaturadescripcion_Internalname = "SDTCITADATA_CITAESTATURADESCRIPCION" ;
      divUnnamedtable5_Internalname = "UNNAMEDTABLE5" ;
      bttBtnunirsellamada_Internalname = "BTNUNIRSELLAMADA" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADSEDENOMBRE" ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADPROFULLNAME" ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADFECHA" ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADHORAINICIO" ;
      cmbavSdtcitadata_citaestadocita.setInternalname( "SDTCITADATA_CITAESTADOCITA" );
      bttBtnregistrarreceta_Internalname = "BTNREGISTRARRECETA" ;
      bttBtnreprogramar_Internalname = "BTNREPROGRAMAR" ;
      divUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      tblPanelinformacioncita_Internalname = "PANELINFORMACIONCITA" ;
      Dvpanel_panelinformacioncita_Internalname = "DVPANEL_PANELINFORMACIONCITA" ;
      lblTextblocksdtcitadata_citatipodiagnostico_Internalname = "TEXTBLOCKSDTCITADATA_CITATIPODIAGNOSTICO" ;
      cmbavSdtcitadata_citatipodiagnostico.setInternalname( "SDTCITADATA_CITATIPODIAGNOSTICO" );
      divUnnamedtablesdtcitadata_citatipodiagnostico_Internalname = "UNNAMEDTABLESDTCITADATA_CITATIPODIAGNOSTICO" ;
      bttBtnagregardiagnostico_Internalname = "BTNAGREGARDIAGNOSTICO" ;
      edtavDiagnosticoeliminar_Internalname = "vDIAGNOSTICOELIMINAR" ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOLONGDESC" ;
      tblDiagnostico_Internalname = "DIAGNOSTICO" ;
      Dvpanel_diagnostico_Internalname = "DVPANEL_DIAGNOSTICO" ;
      edtavSdtcitadata_citamotivoconsulta_Internalname = "SDTCITADATA_CITAMOTIVOCONSULTA" ;
      edtavSdtcitadata_citaantecedentes_Internalname = "SDTCITADATA_CITAANTECEDENTES" ;
      edtavSdtcitadata_citainforme_Internalname = "SDTCITADATA_CITAINFORME" ;
      bttBtnguardar_Internalname = "BTNGUARDAR" ;
      lblBtntxtepicrisis_Internalname = "BTNTXTEPICRISIS" ;
      bttBtnsalir_Internalname = "BTNSALIR" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      Dvpanel_unnamedtable2_Internalname = "DVPANEL_UNNAMEDTABLE2" ;
      divSection_meet_container_Internalname = "SECTION_MEET_CONTAINER" ;
      Msgdvelop_Internalname = "MSGDVELOP" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Gridsdtdiagnosticogrids_empowerer_Internalname = "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridsdtdiagnosticogrids_Internalname = "GRIDSDTDIAGNOSTICOGRIDS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Jsonclick = "" ;
      edtavDiagnosticoeliminar_Jsonclick = "" ;
      edtavDiagnosticoeliminar_Visible = -1 ;
      edtavSdtcitadata_citaestaturadescripcion_Jsonclick = "" ;
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      edtavSdtcitadata_citapesodescripcion_Jsonclick = "" ;
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      edtavSdtpacientedata_pacientenrodocumento_Jsonclick = "" ;
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      cmbavSdtpacientedata_pacientetipodocumento.setJsonclick( "" );
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick = "" ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      edtavSdtpacientedata_pacientetelefono_Jsonclick = "" ;
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      edtavSdtpacientedata_pacientecorreo_Jsonclick = "" ;
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      edtavSdtpacientedata_pacientenombres_Jsonclick = "" ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick = "" ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick = "" ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      bttBtnreprogramar_Visible = 1 ;
      bttBtnregistrarreceta_Visible = 1 ;
      cmbavSdtcitadata_citaestadocita.setJsonclick( "" );
      cmbavSdtcitadata_citaestadocita.setEnabled( 1 );
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      subGridsdtdiagnosticogrids_Allowcollapsing = (byte)(0) ;
      subGridsdtdiagnosticogrids_Allowselection = (byte)(0) ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      edtavDiagnosticoeliminar_Enabled = 1 ;
      subGridsdtdiagnosticogrids_Header = "" ;
      subGridsdtdiagnosticogrids_Class = "GridNoBorder WorkWith" ;
      subGridsdtdiagnosticogrids_Backcolorstyle = (byte)(0) ;
      cmbavSdtcitadata_citatipodiagnostico.setJsonclick( "" );
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 1 );
      lblBtntxtepicrisis_Linktarget = "" ;
      lblBtntxtepicrisis_Link = "" ;
      edtavSdtcitadata_citainforme_Enabled = 1 ;
      edtavSdtcitadata_citaantecedentes_Enabled = 1 ;
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      edtavSdtcitadata_citamotivoconsulta_Enabled = -1 ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = -1 ;
      edtavSdtcitadata_citaestaturadescripcion_Enabled = -1 ;
      edtavSdtcitadata_citapesodescripcion_Enabled = -1 ;
      edtavSdtpacientedata_pacientenrodocumento_Enabled = -1 ;
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( -1 );
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = -1 ;
      edtavSdtpacientedata_pacientetelefono_Enabled = -1 ;
      edtavSdtpacientedata_pacientecorreo_Enabled = -1 ;
      edtavSdtpacientedata_pacientenombres_Enabled = -1 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = -1 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = -1 ;
      Gridsdtdiagnosticogrids_empowerer_Infinitescrolling = "Grid" ;
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Title = "" ;
      Dvpanel_unnamedtable2_Cls = "PanelCard_GrayTitle Panel_BaseColor" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      Dvpanel_diagnostico_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_diagnostico_Iconposition = "Right" ;
      Dvpanel_diagnostico_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_diagnostico_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_diagnostico_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_diagnostico_Title = "Diagnóstico" ;
      Dvpanel_diagnostico_Cls = "PanelCard_GrayTitle Panel_BaseColor" ;
      Dvpanel_diagnostico_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_diagnostico_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_diagnostico_Width = "100%" ;
      Dvpanel_panelinformacioncita_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelinformacioncita_Iconposition = "Right" ;
      Dvpanel_panelinformacioncita_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelinformacioncita_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelinformacioncita_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_panelinformacioncita_Title = "Información de la Cita" ;
      Dvpanel_panelinformacioncita_Cls = "PanelCard_GrayTitle Panel_BaseColor" ;
      Dvpanel_panelinformacioncita_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelinformacioncita_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelinformacioncita_Width = "100%" ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Title = "Información del Paciente" ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle Panel_BaseColor" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      subGridsdtdiagnosticogrids_Rows = 50 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavSdtpacientedata_pacientetipodocumento.setName( "SDTPACIENTEDATA_PACIENTETIPODOCUMENTO" );
      cmbavSdtpacientedata_pacientetipodocumento.setWebtags( "" );
      cmbavSdtpacientedata_pacientetipodocumento.addItem("1", "DNI", (short)(0));
      cmbavSdtpacientedata_pacientetipodocumento.addItem("6", "RUC", (short)(0));
      cmbavSdtpacientedata_pacientetipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavSdtpacientedata_pacientetipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavSdtpacientedata_pacientetipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavSdtpacientedata_pacientetipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavSdtpacientedata_pacientetipodocumento.getItemCount() > 0 )
      {
         AV31SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( cmbavSdtpacientedata_pacientetipodocumento.getValidValue(AV31SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
      }
      cmbavSdtcitadata_citaestadocita.setName( "SDTCITADATA_CITAESTADOCITA" );
      cmbavSdtcitadata_citaestadocita.setWebtags( "" );
      cmbavSdtcitadata_citaestadocita.addItem("R", "Registrado", (short)(0));
      cmbavSdtcitadata_citaestadocita.addItem("C", "Confirmado", (short)(0));
      cmbavSdtcitadata_citaestadocita.addItem("A", "En Atención", (short)(0));
      cmbavSdtcitadata_citaestadocita.addItem("F", "Finalizado", (short)(0));
      cmbavSdtcitadata_citaestadocita.addItem("X", "Cancelado", (short)(0));
      cmbavSdtcitadata_citaestadocita.addItem("N", "No se presentó", (short)(0));
      if ( cmbavSdtcitadata_citaestadocita.getItemCount() > 0 )
      {
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citaestadocita( cmbavSdtcitadata_citaestadocita.getValidValue(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citaestadocita()) );
      }
      cmbavSdtcitadata_citatipodiagnostico.setName( "SDTCITADATA_CITATIPODIAGNOSTICO" );
      cmbavSdtcitadata_citatipodiagnostico.setWebtags( "" );
      cmbavSdtcitadata_citatipodiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
      if ( cmbavSdtcitadata_citatipodiagnostico.getItemCount() > 0 )
      {
         AV27SDTCitaDAta.setgxTv_SdtSDTCitaData_Citatipodiagnostico( cmbavSdtcitadata_citatipodiagnostico.getValidValue(AV27SDTCitaDAta.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS.LOAD","{handler:'e186D2',iparms:[]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS.LOAD",",oparms:[{av:'AV13DiagnosticoEliminar',fld:'vDIAGNOSTICOELIMINAR',pic:''}]}");
      setEventMetadata("'DORETORNARHOME'","{handler:'e116D1',iparms:[]");
      setEventMetadata("'DORETORNARHOME'",",oparms:[]}");
      setEventMetadata("'DOGUARDAR'","{handler:'e126D2',iparms:[{av:'AV27SDTCitaDAta',fld:'vSDTCITADATA',pic:''},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOGUARDAR'",",oparms:[{ctrl:'BTNREPROGRAMAR',prop:'Visible'},{ctrl:'BTNREGISTRARRECETA',prop:'Visible'}]}");
      setEventMetadata("'DOSALIR'","{handler:'e136D2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOSALIR'",",oparms:[]}");
      setEventMetadata("'DOAGREGARDIAGNOSTICO'","{handler:'e216D1',iparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''}]");
      setEventMetadata("'DOAGREGARDIAGNOSTICO'",",oparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''}]}");
      setEventMetadata("'DOREGISTRARRECETA'","{handler:'e226D1',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOREGISTRARRECETA'",",oparms:[]}");
      setEventMetadata("'DOREPROGRAMAR'","{handler:'e236D1',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'AV27SDTCitaDAta',fld:'vSDTCITADATA',pic:''}]");
      setEventMetadata("'DOREPROGRAMAR'",",oparms:[]}");
      setEventMetadata("'DOUNIRSELLAMADA'","{handler:'e146D2',iparms:[{av:'AV27SDTCitaDAta',fld:'vSDTCITADATA',pic:''},{av:'AV9MeetConfig',fld:'vMEETCONFIG',pic:''}]");
      setEventMetadata("'DOUNIRSELLAMADA'",",oparms:[{av:'AV9MeetConfig',fld:'vMEETCONFIG',pic:''},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Containername()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Containername'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Useallwindow()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Useallwindow'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Disposeonunload()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Disposeonunload'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Piplocation()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Piplocation'}]}");
      setEventMetadata("'DOEXPORTAREPICRISIS'","{handler:'e196D2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORTAREPICRISIS'",",oparms:[]}");
      setEventMetadata("GLOBALEVENTS.SELECTDIAGNOSTICO","{handler:'e156D2',iparms:[{av:'AV11DiagnosticoCodigo',fld:'vDIAGNOSTICOCODIGO',pic:''},{av:'AV12DiagnosticoDescripcion',fld:'vDIAGNOSTICODESCRIPCION',pic:''},{av:'AV15DiagnosticoLongDesc',fld:'vDIAGNOSTICOLONGDESC',pic:''},{av:'AV14DiagnosticoId',fld:'vDIAGNOSTICOID',pic:'ZZZZZZZ9'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("GLOBALEVENTS.SELECTDIAGNOSTICO",",oparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128}]}");
      setEventMetadata("VDIAGNOSTICOELIMINAR.CLICK","{handler:'e206D2',iparms:[{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("VDIAGNOSTICOELIMINAR.CLICK",",oparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128}]}");
      setEventMetadata("GLOBALEVENTS.REPROGRAMARCITA","{handler:'e166D2',iparms:[{av:'AV7isSuccess',fld:'vISSUCCESS',pic:''},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("GLOBALEVENTS.REPROGRAMARCITA",",oparms:[{av:'AV27SDTCitaDAta',fld:'vSDTCITADATA',pic:''},{av:'AV31SDTPacienteData',fld:'vSDTPACIENTEDATA',pic:''},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128},{ctrl:'BTNREPROGRAMAR',prop:'Visible'},{ctrl:'BTNREGISTRARRECETA',prop:'Visible'}]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_FIRSTPAGE","{handler:'subgridsdtdiagnosticogrids_firstpage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_PREVPAGE","{handler:'subgridsdtdiagnosticogrids_previouspage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_NEXTPAGE","{handler:'subgridsdtdiagnosticogrids_nextpage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_LASTPAGE","{handler:'subgridsdtdiagnosticogrids_lastpage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV30SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:128,pic:''},{av:'nRC_GXsfl_128',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:128}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_GXV4","{handler:'validv_Gxv4',iparms:[]");
      setEventMetadata("VALIDV_GXV4",",oparms:[]}");
      setEventMetadata("VALIDV_GXV7","{handler:'validv_Gxv7',iparms:[]");
      setEventMetadata("VALIDV_GXV7",",oparms:[]}");
      setEventMetadata("VALIDV_GXV16","{handler:'validv_Gxv16',iparms:[]");
      setEventMetadata("VALIDV_GXV16",",oparms:[]}");
      setEventMetadata("VALIDV_GXV17","{handler:'validv_Gxv17',iparms:[]");
      setEventMetadata("VALIDV_GXV17",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv19',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gridsdtdiagnosticogrids_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV31SDTPacienteData = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      AV27SDTCitaDAta = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      AV30SDTDiagnosticoGrids = new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>(com.projectthani.SdtSDTDiagnosticoGrid.class, "SDTDiagnosticoGrid", "ProjectThani", remoteHandle);
      AV28SDTDiagnosticoGrid = new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      AV9MeetConfig = new com.hugao.hugaojitsiclient.common.SdtMeetConfig(remoteHandle, context);
      AV11DiagnosticoCodigo = "" ;
      AV12DiagnosticoDescripcion = "" ;
      AV15DiagnosticoLongDesc = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnretornarhome_Jsonclick = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelinformacioncita = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_diagnostico = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      ucMsgdvelop = new com.genexus.webpanels.GXUserControl();
      ucGridsdtdiagnosticogrids_empowerer = new com.genexus.webpanels.GXUserControl();
      GridsdtdiagnosticogridsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV13DiagnosticoEliminar = "" ;
      GXCCtl = "" ;
      AV71Pgmname = "" ;
      scmdbuf = "" ;
      H006D2_A89CitaEstadoCita = new String[] {""} ;
      H006D2_n89CitaEstadoCita = new boolean[] {false} ;
      H006D2_A95CitaEstado = new String[] {""} ;
      H006D2_n95CitaEstado = new boolean[] {false} ;
      H006D2_A19CitaId = new int[1] ;
      H006D2_A20PacienteId = new int[1] ;
      H006D2_A64CitaCode = new String[] {""} ;
      H006D2_A21SGCitaDisponibilidadId = new int[1] ;
      A89CitaEstadoCita = "" ;
      A95CitaEstado = "" ;
      A64CitaCode = "" ;
      AV45CodigoCita = "" ;
      AV33Domain = "" ;
      AV73Roomname = "" ;
      GridsdtdiagnosticogridsRow = new com.genexus.webpanels.GXWebRow();
      AV16ErrorMessageSaveCita = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV8JitsiJWTContext = new com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext(remoteHandle, context);
      GXt_SdtSDTCitaData4 = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      GXv_SdtSDTCitaData5 = new com.projectthani.SdtSDTCitaData[1] ;
      GXt_SdtSDTPacienteData6 = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      GXv_SdtSDTPacienteData7 = new com.projectthani.SdtSDTPacienteData[1] ;
      GXt_objcol_SdtSDTDiagnosticoGrid8 = new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>(com.projectthani.SdtSDTDiagnosticoGrid.class, "SDTDiagnosticoGrid", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTDiagnosticoGrid9 = new GXBaseCollection[1] ;
      bttBtnguardar_Jsonclick = "" ;
      lblBtntxtepicrisis_Jsonclick = "" ;
      bttBtnsalir_Jsonclick = "" ;
      lblTextblocksdtcitadata_citatipodiagnostico_Jsonclick = "" ;
      bttBtnagregardiagnostico_Jsonclick = "" ;
      subGridsdtdiagnosticogrids_Linesclass = "" ;
      GridsdtdiagnosticogridsColumn = new com.genexus.webpanels.GXWebColumn();
      bttBtnregistrarreceta_Jsonclick = "" ;
      bttBtnreprogramar_Jsonclick = "" ;
      bttBtnunirsellamada_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpinformecita__default(),
         new Object[] {
             new Object[] {
            H006D2_A89CitaEstadoCita, H006D2_n89CitaEstadoCita, H006D2_A95CitaEstado, H006D2_n95CitaEstado, H006D2_A19CitaId, H006D2_A20PacienteId, H006D2_A64CitaCode, H006D2_A21SGCitaDisponibilidadId
            }
         }
      );
      AV71Pgmname = "WPInformeCita" ;
      /* GeneXus formulas. */
      AV71Pgmname = "WPInformeCita" ;
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      edtavDiagnosticoeliminar_Enabled = 0 ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
   }

   private byte GRIDSDTDIAGNOSTICOGRIDS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte subGridsdtdiagnosticogrids_Backcolorstyle ;
   private byte subGridsdtdiagnosticogrids_Titlebackstyle ;
   private byte subGridsdtdiagnosticogrids_Allowselection ;
   private byte subGridsdtdiagnosticogrids_Allowhovering ;
   private byte subGridsdtdiagnosticogrids_Allowcollapsing ;
   private byte subGridsdtdiagnosticogrids_Collapsed ;
   private byte nGXWrapped ;
   private byte subGridsdtdiagnosticogrids_Backstyle ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV17i ;
   private int wcpOAV5CitaId ;
   private int nRC_GXsfl_128 ;
   private int nGXsfl_128_idx=1 ;
   private int subGridsdtdiagnosticogrids_Rows ;
   private int AV5CitaId ;
   private int AV14DiagnosticoId ;
   private int AV66GXV18 ;
   private int subGridsdtdiagnosticogrids_Islastpage ;
   private int edtavSdtpacientedata_pacienteapellidopaterno_Enabled ;
   private int edtavSdtpacientedata_pacienteapellidomaterno_Enabled ;
   private int edtavSdtpacientedata_pacientenombres_Enabled ;
   private int edtavSdtpacientedata_pacientecorreo_Enabled ;
   private int edtavSdtpacientedata_pacientetelefono_Enabled ;
   private int edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled ;
   private int edtavSdtpacientedata_pacientenrodocumento_Enabled ;
   private int edtavSdtcitadata_citapesodescripcion_Enabled ;
   private int edtavSdtcitadata_citaestaturadescripcion_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadsedenombre_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled ;
   private int edtavDiagnosticoeliminar_Enabled ;
   private int edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled ;
   private int edtavSdtcitadata_citamotivoconsulta_Enabled ;
   private int GRIDSDTDIAGNOSTICOGRIDS_nGridOutOfScope ;
   private int nGXsfl_128_fel_idx=1 ;
   private int bttBtnregistrarreceta_Visible ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV44PacienteId ;
   private int AV46DisponibilidadId ;
   private int bttBtnreprogramar_Visible ;
   private int nGXsfl_128_bak_idx=1 ;
   private int edtavSdtcitadata_citaantecedentes_Enabled ;
   private int edtavSdtcitadata_citainforme_Enabled ;
   private int subGridsdtdiagnosticogrids_Titlebackcolor ;
   private int subGridsdtdiagnosticogrids_Allbackcolor ;
   private int subGridsdtdiagnosticogrids_Selectedindex ;
   private int subGridsdtdiagnosticogrids_Selectioncolor ;
   private int subGridsdtdiagnosticogrids_Hoveringcolor ;
   private int idxLst ;
   private int subGridsdtdiagnosticogrids_Backcolor ;
   private int edtavDiagnosticoeliminar_Visible ;
   private long GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage ;
   private long GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord ;
   private long GRIDSDTDIAGNOSTICOGRIDS_nRecordCount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_128_idx="0001" ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_panelinformacioncita_Width ;
   private String Dvpanel_panelinformacioncita_Cls ;
   private String Dvpanel_panelinformacioncita_Title ;
   private String Dvpanel_panelinformacioncita_Iconposition ;
   private String Dvpanel_diagnostico_Width ;
   private String Dvpanel_diagnostico_Cls ;
   private String Dvpanel_diagnostico_Title ;
   private String Dvpanel_diagnostico_Iconposition ;
   private String Dvpanel_unnamedtable2_Width ;
   private String Dvpanel_unnamedtable2_Cls ;
   private String Dvpanel_unnamedtable2_Title ;
   private String Dvpanel_unnamedtable2_Iconposition ;
   private String Gridsdtdiagnosticogrids_empowerer_Gridinternalname ;
   private String Gridsdtdiagnosticogrids_empowerer_Infinitescrolling ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String TempTags ;
   private String bttBtnretornarhome_Internalname ;
   private String bttBtnretornarhome_Jsonclick ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String Dvpanel_panelinformacioncita_Internalname ;
   private String Dvpanel_diagnostico_Internalname ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divSection_meet_container_Internalname ;
   private String Msgdvelop_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Gridsdtdiagnosticogrids_empowerer_Internalname ;
   private String sStyleString ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavDiagnosticoeliminar_Internalname ;
   private String edtavSdtpacientedata_pacienteapellidopaterno_Internalname ;
   private String GXCCtl ;
   private String AV71Pgmname ;
   private String edtavSdtpacientedata_pacienteapellidomaterno_Internalname ;
   private String edtavSdtpacientedata_pacientenombres_Internalname ;
   private String edtavSdtpacientedata_pacientecorreo_Internalname ;
   private String edtavSdtpacientedata_pacientetelefono_Internalname ;
   private String edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname ;
   private String edtavSdtpacientedata_pacientenrodocumento_Internalname ;
   private String edtavSdtcitadata_citapesodescripcion_Internalname ;
   private String edtavSdtcitadata_citaestaturadescripcion_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadsedenombre_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname ;
   private String edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname ;
   private String edtavSdtcitadata_citamotivoconsulta_Internalname ;
   private String sGXsfl_128_fel_idx="0001" ;
   private String edtavSdtcitadata_citaantecedentes_Internalname ;
   private String edtavSdtcitadata_citainforme_Internalname ;
   private String bttBtnregistrarreceta_Internalname ;
   private String lblBtntxtepicrisis_Link ;
   private String lblBtntxtepicrisis_Internalname ;
   private String lblBtntxtepicrisis_Linktarget ;
   private String subGridsdtdiagnosticogrids_Internalname ;
   private String scmdbuf ;
   private String A89CitaEstadoCita ;
   private String A95CitaEstado ;
   private String GXv_char3[] ;
   private String bttBtnreprogramar_Internalname ;
   private String tblUnnamedtable2_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String bttBtnguardar_Internalname ;
   private String bttBtnguardar_Jsonclick ;
   private String lblBtntxtepicrisis_Jsonclick ;
   private String bttBtnsalir_Internalname ;
   private String bttBtnsalir_Jsonclick ;
   private String tblDiagnostico_Internalname ;
   private String divUnnamedtablesdtcitadata_citatipodiagnostico_Internalname ;
   private String lblTextblocksdtcitadata_citatipodiagnostico_Internalname ;
   private String lblTextblocksdtcitadata_citatipodiagnostico_Jsonclick ;
   private String bttBtnagregardiagnostico_Internalname ;
   private String bttBtnagregardiagnostico_Jsonclick ;
   private String subGridsdtdiagnosticogrids_Class ;
   private String subGridsdtdiagnosticogrids_Linesclass ;
   private String subGridsdtdiagnosticogrids_Header ;
   private String tblPanelinformacioncita_Internalname ;
   private String divUnnamedtable4_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadsedenombre_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadprofullname_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadfecha_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadhorainicio_Jsonclick ;
   private String bttBtnregistrarreceta_Jsonclick ;
   private String bttBtnreprogramar_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String divUnnamedtable5_Internalname ;
   private String edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick ;
   private String edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick ;
   private String edtavSdtpacientedata_pacientenombres_Jsonclick ;
   private String edtavSdtpacientedata_pacientecorreo_Jsonclick ;
   private String edtavSdtpacientedata_pacientetelefono_Jsonclick ;
   private String edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick ;
   private String edtavSdtpacientedata_pacientenrodocumento_Jsonclick ;
   private String edtavSdtcitadata_citapesodescripcion_Jsonclick ;
   private String edtavSdtcitadata_citaestaturadescripcion_Jsonclick ;
   private String bttBtnunirsellamada_Internalname ;
   private String bttBtnunirsellamada_Jsonclick ;
   private String ROClassString ;
   private String edtavDiagnosticoeliminar_Jsonclick ;
   private String edtavSdtdiagnosticogrids__diagnosticolongdesc_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean Dvpanel_panelinformacioncita_Autowidth ;
   private boolean Dvpanel_panelinformacioncita_Autoheight ;
   private boolean Dvpanel_panelinformacioncita_Collapsible ;
   private boolean Dvpanel_panelinformacioncita_Collapsed ;
   private boolean Dvpanel_panelinformacioncita_Showcollapseicon ;
   private boolean Dvpanel_panelinformacioncita_Autoscroll ;
   private boolean Dvpanel_diagnostico_Autowidth ;
   private boolean Dvpanel_diagnostico_Autoheight ;
   private boolean Dvpanel_diagnostico_Collapsible ;
   private boolean Dvpanel_diagnostico_Collapsed ;
   private boolean Dvpanel_diagnostico_Showcollapseicon ;
   private boolean Dvpanel_diagnostico_Autoscroll ;
   private boolean Dvpanel_unnamedtable2_Autowidth ;
   private boolean Dvpanel_unnamedtable2_Autoheight ;
   private boolean Dvpanel_unnamedtable2_Collapsible ;
   private boolean Dvpanel_unnamedtable2_Collapsed ;
   private boolean Dvpanel_unnamedtable2_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable2_Autoscroll ;
   private boolean AV7isSuccess ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_128_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV43isOpenVideoCall ;
   private boolean AV18IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean n89CitaEstadoCita ;
   private boolean n95CitaEstado ;
   private boolean AV6isSaved ;
   private boolean GXv_boolean2[] ;
   private boolean gx_BV128 ;
   private String AV11DiagnosticoCodigo ;
   private String AV12DiagnosticoDescripcion ;
   private String AV15DiagnosticoLongDesc ;
   private String AV13DiagnosticoEliminar ;
   private String A64CitaCode ;
   private String AV45CodigoCita ;
   private String AV33Domain ;
   private String AV73Roomname ;
   private String AV16ErrorMessageSaveCita ;
   private com.genexus.webpanels.GXWebGrid GridsdtdiagnosticogridsContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtdiagnosticogridsRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtdiagnosticogridsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelinformacioncita ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_diagnostico ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.webpanels.GXUserControl ucMsgdvelop ;
   private com.genexus.webpanels.GXUserControl ucGridsdtdiagnosticogrids_empowerer ;
   private HTMLChoice cmbavSdtpacientedata_pacientetipodocumento ;
   private HTMLChoice cmbavSdtcitadata_citaestadocita ;
   private HTMLChoice cmbavSdtcitadata_citatipodiagnostico ;
   private IDataStoreProvider pr_default ;
   private String[] H006D2_A89CitaEstadoCita ;
   private boolean[] H006D2_n89CitaEstadoCita ;
   private String[] H006D2_A95CitaEstado ;
   private boolean[] H006D2_n95CitaEstado ;
   private int[] H006D2_A19CitaId ;
   private int[] H006D2_A20PacienteId ;
   private String[] H006D2_A64CitaCode ;
   private int[] H006D2_A21SGCitaDisponibilidadId ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> AV30SDTDiagnosticoGrids ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> GXt_objcol_SdtSDTDiagnosticoGrid8 ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> GXv_objcol_SdtSDTDiagnosticoGrid9[] ;
   private com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext AV8JitsiJWTContext ;
   private com.hugao.hugaojitsiclient.common.SdtMeetConfig AV9MeetConfig ;
   private com.projectthani.SdtSDTCitaData AV27SDTCitaDAta ;
   private com.projectthani.SdtSDTCitaData GXt_SdtSDTCitaData4 ;
   private com.projectthani.SdtSDTCitaData GXv_SdtSDTCitaData5[] ;
   private com.projectthani.SdtSDTDiagnosticoGrid AV28SDTDiagnosticoGrid ;
   private com.projectthani.SdtSDTPacienteData AV31SDTPacienteData ;
   private com.projectthani.SdtSDTPacienteData GXt_SdtSDTPacienteData6 ;
   private com.projectthani.SdtSDTPacienteData GXv_SdtSDTPacienteData7[] ;
}

final  class wpinformecita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006D2", "SELECT TOP 1 [CitaEstadoCita], [CitaEstado], [CitaId], [PacienteId], [CitaCode], [SGCitaDisponibilidadId] FROM [Cita] WHERE ([CitaId] = ?) AND ([CitaEstado] = 'A') AND ([CitaEstadoCita] = 'R') ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

