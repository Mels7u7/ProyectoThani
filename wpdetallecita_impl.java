package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpdetallecita_impl extends GXWebPanel
{
   public wpdetallecita_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpdetallecita_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpdetallecita_impl.class ));
   }

   public wpdetallecita_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSdtpacientedata_pacientetipodocumento = new HTMLChoice();
      cmbavSdtpacientedata_pacientesexo = new HTMLChoice();
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
            nRC_GXsfl_166 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_166"))) ;
            nGXsfl_166_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_166_idx"))) ;
            sGXsfl_166_idx = httpContext.GetPar( "sGXsfl_166_idx") ;
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Width", GXutil.rtrim( Dvpanel_paneldiagnostico_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Autowidth", GXutil.booltostr( Dvpanel_paneldiagnostico_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Autoheight", GXutil.booltostr( Dvpanel_paneldiagnostico_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Cls", GXutil.rtrim( Dvpanel_paneldiagnostico_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Title", GXutil.rtrim( Dvpanel_paneldiagnostico_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Collapsible", GXutil.booltostr( Dvpanel_paneldiagnostico_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Collapsed", GXutil.booltostr( Dvpanel_paneldiagnostico_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Showcollapseicon", GXutil.booltostr( Dvpanel_paneldiagnostico_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Iconposition", GXutil.rtrim( Dvpanel_paneldiagnostico_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Autoscroll", GXutil.booltostr( Dvpanel_paneldiagnostico_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Width", GXutil.rtrim( Dvpanel_paneldetalles_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Autowidth", GXutil.booltostr( Dvpanel_paneldetalles_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Autoheight", GXutil.booltostr( Dvpanel_paneldetalles_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Cls", GXutil.rtrim( Dvpanel_paneldetalles_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Title", GXutil.rtrim( Dvpanel_paneldetalles_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Collapsible", GXutil.booltostr( Dvpanel_paneldetalles_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Collapsed", GXutil.booltostr( Dvpanel_paneldetalles_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Showcollapseicon", GXutil.booltostr( Dvpanel_paneldetalles_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Iconposition", GXutil.rtrim( Dvpanel_paneldetalles_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Autoscroll", GXutil.booltostr( Dvpanel_paneldetalles_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Width", GXutil.rtrim( Dvpanel_panebtns_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Autowidth", GXutil.booltostr( Dvpanel_panebtns_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Autoheight", GXutil.booltostr( Dvpanel_panebtns_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Cls", GXutil.rtrim( Dvpanel_panebtns_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Title", GXutil.rtrim( Dvpanel_panebtns_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Collapsible", GXutil.booltostr( Dvpanel_panebtns_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Collapsed", GXutil.booltostr( Dvpanel_panebtns_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Showcollapseicon", GXutil.booltostr( Dvpanel_panebtns_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Iconposition", GXutil.rtrim( Dvpanel_panebtns_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Autoscroll", GXutil.booltostr( Dvpanel_panebtns_Autoscroll));
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
            AV6CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CitaId), 8, 0));
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
         pa6I2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws6I2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we6I2( ) ;
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
      httpContext.writeValue( "Detalle Cita") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034852", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpdetallecita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV6CitaId,8,0))}, new String[] {"CitaId"}) +"\">") ;
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpacientedata", AV30SDTPacienteData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpacientedata", AV30SDTPacienteData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtcitadata", AV27SDTCitaData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtcitadata", AV27SDTCitaData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtdiagnosticogrids", AV29SDTDiagnosticoGrids);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtdiagnosticogrids", AV29SDTDiagnosticoGrids);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_166", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_166, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTCITADATA", AV27SDTCitaData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTCITADATA", AV27SDTCitaData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDIAGNOSTICOGRIDS", AV29SDTDiagnosticoGrids);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDIAGNOSTICOGRIDS", AV29SDTDiagnosticoGrids);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV6CitaId, (byte)(8), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEETCONFIG", AV24MeetConfig);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEETCONFIG", AV24MeetConfig);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOCODIGO", AV8DiagnosticoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICODESCRIPCION", AV9DiagnosticoDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOLONGDESC", AV12DiagnosticoLongDesc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOID", GXutil.ltrim( localUtil.ntoc( AV11DiagnosticoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISSUCCESS", AV23isSuccess);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vURLEP", AV32UrlEp);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Width", GXutil.rtrim( Dvpanel_paneldiagnostico_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Autowidth", GXutil.booltostr( Dvpanel_paneldiagnostico_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Autoheight", GXutil.booltostr( Dvpanel_paneldiagnostico_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Cls", GXutil.rtrim( Dvpanel_paneldiagnostico_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Title", GXutil.rtrim( Dvpanel_paneldiagnostico_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Collapsible", GXutil.booltostr( Dvpanel_paneldiagnostico_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Collapsed", GXutil.booltostr( Dvpanel_paneldiagnostico_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Showcollapseicon", GXutil.booltostr( Dvpanel_paneldiagnostico_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Iconposition", GXutil.rtrim( Dvpanel_paneldiagnostico_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDIAGNOSTICO_Autoscroll", GXutil.booltostr( Dvpanel_paneldiagnostico_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Width", GXutil.rtrim( Dvpanel_paneldetalles_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Autowidth", GXutil.booltostr( Dvpanel_paneldetalles_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Autoheight", GXutil.booltostr( Dvpanel_paneldetalles_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Cls", GXutil.rtrim( Dvpanel_paneldetalles_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Title", GXutil.rtrim( Dvpanel_paneldetalles_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Collapsible", GXutil.booltostr( Dvpanel_paneldetalles_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Collapsed", GXutil.booltostr( Dvpanel_paneldetalles_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Showcollapseicon", GXutil.booltostr( Dvpanel_paneldetalles_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Iconposition", GXutil.rtrim( Dvpanel_paneldetalles_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLES_Autoscroll", GXutil.booltostr( Dvpanel_paneldetalles_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Width", GXutil.rtrim( Dvpanel_panebtns_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Autowidth", GXutil.booltostr( Dvpanel_panebtns_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Autoheight", GXutil.booltostr( Dvpanel_panebtns_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Cls", GXutil.rtrim( Dvpanel_panebtns_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Title", GXutil.rtrim( Dvpanel_panebtns_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Collapsible", GXutil.booltostr( Dvpanel_panebtns_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Collapsed", GXutil.booltostr( Dvpanel_panebtns_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Showcollapseicon", GXutil.booltostr( Dvpanel_panebtns_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Iconposition", GXutil.rtrim( Dvpanel_panebtns_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEBTNS_Autoscroll", GXutil.booltostr( Dvpanel_panebtns_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtdiagnosticogrids_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridsdtdiagnosticogrids_empowerer_Infinitescrolling));
   }

   public void renderHtmlCloseForm6I2( )
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
      return "WPDetalleCita" ;
   }

   public String getPgmdesc( )
   {
      return "Detalle Cita" ;
   }

   public void wb6I0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table TableTransactionTemplate", "left", "top", "", "", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablacontenedor_Internalname, 1, 0, "px", 0, "px", "TableInfoCitasContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelbuttons.setProperty("Width", Dvpanel_panelbuttons_Width);
         ucDvpanel_panelbuttons.setProperty("AutoWidth", Dvpanel_panelbuttons_Autowidth);
         ucDvpanel_panelbuttons.setProperty("AutoHeight", Dvpanel_panelbuttons_Autoheight);
         ucDvpanel_panelbuttons.setProperty("Cls", Dvpanel_panelbuttons_Cls);
         ucDvpanel_panelbuttons.setProperty("Title", Dvpanel_panelbuttons_Title);
         ucDvpanel_panelbuttons.setProperty("Collapsible", Dvpanel_panelbuttons_Collapsible);
         ucDvpanel_panelbuttons.setProperty("Collapsed", Dvpanel_panelbuttons_Collapsed);
         ucDvpanel_panelbuttons.setProperty("ShowCollapseIcon", Dvpanel_panelbuttons_Showcollapseicon);
         ucDvpanel_panelbuttons.setProperty("IconPosition", Dvpanel_panelbuttons_Iconposition);
         ucDvpanel_panelbuttons.setProperty("AutoScroll", Dvpanel_panelbuttons_Autoscroll);
         ucDvpanel_panelbuttons.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelbuttons_Internalname, "DVPANEL_PANELBUTTONSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELBUTTONSContainer"+"PanelButtons"+"\" style=\"display:none;\">") ;
         wb_table1_17_6I2( true) ;
      }
      else
      {
         wb_table1_17_6I2( false) ;
      }
      return  ;
   }

   public void wb_table1_17_6I2e( boolean wbgen )
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
         ucDvpanel_paneldetalles.setProperty("Width", Dvpanel_paneldetalles_Width);
         ucDvpanel_paneldetalles.setProperty("AutoWidth", Dvpanel_paneldetalles_Autowidth);
         ucDvpanel_paneldetalles.setProperty("AutoHeight", Dvpanel_paneldetalles_Autoheight);
         ucDvpanel_paneldetalles.setProperty("Cls", Dvpanel_paneldetalles_Cls);
         ucDvpanel_paneldetalles.setProperty("Title", Dvpanel_paneldetalles_Title);
         ucDvpanel_paneldetalles.setProperty("Collapsible", Dvpanel_paneldetalles_Collapsible);
         ucDvpanel_paneldetalles.setProperty("Collapsed", Dvpanel_paneldetalles_Collapsed);
         ucDvpanel_paneldetalles.setProperty("ShowCollapseIcon", Dvpanel_paneldetalles_Showcollapseicon);
         ucDvpanel_paneldetalles.setProperty("IconPosition", Dvpanel_paneldetalles_Iconposition);
         ucDvpanel_paneldetalles.setProperty("AutoScroll", Dvpanel_paneldetalles_Autoscroll);
         ucDvpanel_paneldetalles.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneldetalles_Internalname, "DVPANEL_PANELDETALLESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELDETALLESContainer"+"PanelDetalles"+"\" style=\"display:none;\">") ;
         wb_table2_33_6I2( true) ;
      }
      else
      {
         wb_table2_33_6I2( false) ;
      }
      return  ;
   }

   public void wb_table2_33_6I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panebtns.setProperty("Width", Dvpanel_panebtns_Width);
         ucDvpanel_panebtns.setProperty("AutoWidth", Dvpanel_panebtns_Autowidth);
         ucDvpanel_panebtns.setProperty("AutoHeight", Dvpanel_panebtns_Autoheight);
         ucDvpanel_panebtns.setProperty("Cls", Dvpanel_panebtns_Cls);
         ucDvpanel_panebtns.setProperty("Title", Dvpanel_panebtns_Title);
         ucDvpanel_panebtns.setProperty("Collapsible", Dvpanel_panebtns_Collapsible);
         ucDvpanel_panebtns.setProperty("Collapsed", Dvpanel_panebtns_Collapsed);
         ucDvpanel_panebtns.setProperty("ShowCollapseIcon", Dvpanel_panebtns_Showcollapseicon);
         ucDvpanel_panebtns.setProperty("IconPosition", Dvpanel_panebtns_Iconposition);
         ucDvpanel_panebtns.setProperty("AutoScroll", Dvpanel_panebtns_Autoscroll);
         ucDvpanel_panebtns.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panebtns_Internalname, "DVPANEL_PANEBTNSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANEBTNSContainer"+"PaneBtns"+"\" style=\"display:none;\">") ;
         wb_table3_174_6I2( true) ;
      }
      else
      {
         wb_table3_174_6I2( false) ;
      }
      return  ;
   }

   public void wb_table3_174_6I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemeetcontainer_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
      if ( wbEnd == 166 )
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
               AV60GXV25 = nGXsfl_166_idx ;
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

   public void start6I2( )
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
         Form.getMeta().addItem("description", "Detalle Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6I0( ) ;
   }

   public void ws6I2( )
   {
      start6I2( ) ;
      evt6I2( ) ;
   }

   public void evt6I2( )
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
                     else if ( GXutil.strcmp(sEvt, "'DOBTNGUARDAR'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoBtnGuardar' */
                        e116I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'DOBTNCANCELAR'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoBtnCancelar' */
                        e126I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'DOBTNUNIRSEVIDEOLLAMADA'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoBtnUnirseVideollamada' */
                        e136I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.SELECTDIAGNOSTICO") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e146I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.REPROGRAMARCITA") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e156I2 ();
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
                     if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 28), "GRIDSDTDIAGNOSTICOGRIDS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "VDIAGNOSTICOELIMINAR.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "VDIAGNOSTICOELIMINAR.CLICK") == 0 ) )
                     {
                        nGXsfl_166_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_1662( ) ;
                        AV60GXV25 = nGXsfl_166_idx ;
                        if ( ( AV29SDTDiagnosticoGrids.size() >= AV60GXV25 ) && ( AV60GXV25 > 0 ) )
                        {
                           AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
                           AV10DiagnosticoEliminar = httpContext.cgiGet( edtavDiagnosticoeliminar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDiagnosticoeliminar_Internalname, AV10DiagnosticoEliminar);
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
                              e166I2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDSDTDIAGNOSTICOGRIDS.LOAD") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e176I2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "VDIAGNOSTICOELIMINAR.CLICK") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e186I2 ();
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

   public void we6I2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6I2( ) ;
         }
      }
   }

   public void pa6I2( )
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
            GX_FocusControl = edtavSdtpacientedata_pacientenombres_Internalname ;
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
      subsflControlProps_1662( ) ;
      while ( nGXsfl_166_idx <= nRC_GXsfl_166 )
      {
         sendrow_1662( ) ;
         nGXsfl_166_idx = ((subGridsdtdiagnosticogrids_Islastpage==1)&&(nGXsfl_166_idx+1>subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ? 1 : nGXsfl_166_idx+1) ;
         sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1662( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtdiagnosticogridsContainer)) ;
      /* End function gxnrGridsdtdiagnosticogrids_newrow */
   }

   public void gxgrgridsdtdiagnosticogrids_refresh( int subGridsdtdiagnosticogrids_Rows )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = 0 ;
      rf6I2( ) ;
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
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( cmbavSdtpacientedata_pacientetipodocumento.getValidValue(AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtpacientedata_pacientetipodocumento.setValue( GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Values", cmbavSdtpacientedata_pacientetipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavSdtpacientedata_pacientesexo.getItemCount() > 0 )
      {
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientesexo( cmbavSdtpacientedata_pacientesexo.getValidValue(AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientesexo()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtpacientedata_pacientesexo.setValue( GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientesexo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientesexo.getInternalname(), "Values", cmbavSdtpacientedata_pacientesexo.ToJavascriptSource(), true);
      }
      if ( cmbavSdtcitadata_citaestadocita.getItemCount() > 0 )
      {
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citaestadocita( cmbavSdtcitadata_citaestadocita.getValidValue(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtcitadata_citaestadocita.setValue( GXutil.rtrim( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citaestadocita.getInternalname(), "Values", cmbavSdtcitadata_citaestadocita.ToJavascriptSource(), true);
      }
      if ( cmbavSdtcitadata_citatipodiagnostico.getItemCount() > 0 )
      {
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citatipodiagnostico( cmbavSdtcitadata_citatipodiagnostico.getValidValue(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtcitadata_citatipodiagnostico.setValue( GXutil.rtrim( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Values", cmbavSdtcitadata_citatipodiagnostico.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = 0 ;
      GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = 0 ;
      GXCCtl = "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage_" + sGXsfl_166_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf6I2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV63Pgmname = "WPDetalleCita" ;
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenombres_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidopaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidomaterno_Enabled), 5, 0), true);
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtpacientedata_pacientetipodocumento.getEnabled(), 5, 0), true);
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenrodocumento_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled), 5, 0), true);
      cmbavSdtpacientedata_pacientesexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientesexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtpacientedata_pacientesexo.getEnabled(), 5, 0), true);
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientetelefono_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientecorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientecorreo_Enabled), 5, 0), true);
      edtavSdtcitadata_citaestatura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaestatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaestatura_Enabled), 5, 0), true);
      edtavSdtcitadata_citapeso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citapeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citapeso_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientedireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientedireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientedireccion_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled), 5, 0), true);
      edtavSdtcitadata_citafechareserva_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citafechareserva_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citafechareserva_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled), 5, 0), true);
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citamotivoconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citamotivoconsulta_Enabled), 5, 0), true);
      edtavSdtcitadata_citacode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citacode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citacode_Enabled), 5, 0), true);
      edtavDiagnosticoeliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiagnosticoeliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiagnosticoeliminar_Enabled), 5, 0), !bGXsfl_166_Refreshing);
      edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled), 5, 0), !bGXsfl_166_Refreshing);
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled), 5, 0), !bGXsfl_166_Refreshing);
   }

   public void rf6I2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtdiagnosticogridsContainer.ClearRows();
      }
      wbStart = (short)(166) ;
      nGXsfl_166_idx = (int)(1+GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage) ;
      sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1662( ) ;
      bGXsfl_166_Refreshing = true ;
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
         subsflControlProps_1662( ) ;
         e176I2 ();
         if ( ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord > 0 ) && ( GRIDSDTDIAGNOSTICOGRIDS_nGridOutOfScope == 0 ) && ( nGXsfl_166_idx == 1 ) )
         {
            GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = 0 ;
            GRIDSDTDIAGNOSTICOGRIDS_nGridOutOfScope = 1 ;
            subgridsdtdiagnosticogrids_firstpage( ) ;
            e176I2 ();
         }
         wbEnd = (short)(166) ;
         wb6I0( ) ;
      }
      bGXsfl_166_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6I2( )
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
      return AV29SDTDiagnosticoGrids.size() ;
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
      AV63Pgmname = "WPDetalleCita" ;
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenombres_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidopaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidomaterno_Enabled), 5, 0), true);
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtpacientedata_pacientetipodocumento.getEnabled(), 5, 0), true);
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenrodocumento_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled), 5, 0), true);
      cmbavSdtpacientedata_pacientesexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientesexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtpacientedata_pacientesexo.getEnabled(), 5, 0), true);
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientetelefono_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientecorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientecorreo_Enabled), 5, 0), true);
      edtavSdtcitadata_citaestatura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaestatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaestatura_Enabled), 5, 0), true);
      edtavSdtcitadata_citapeso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citapeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citapeso_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientedireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientedireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientedireccion_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled), 5, 0), true);
      edtavSdtcitadata_citafechareserva_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citafechareserva_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citafechareserva_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled), 5, 0), true);
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citamotivoconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citamotivoconsulta_Enabled), 5, 0), true);
      edtavSdtcitadata_citacode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citacode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citacode_Enabled), 5, 0), true);
      edtavDiagnosticoeliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiagnosticoeliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiagnosticoeliminar_Enabled), 5, 0), !bGXsfl_166_Refreshing);
      edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled), 5, 0), !bGXsfl_166_Refreshing);
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled), 5, 0), !bGXsfl_166_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup6I0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e166I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpacientedata"), AV30SDTPacienteData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtcitadata"), AV27SDTCitaData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtdiagnosticogrids"), AV29SDTDiagnosticoGrids);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTDIAGNOSTICOGRIDS"), AV29SDTDiagnosticoGrids);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTDIAGNOSTICOGRID"), AV28SDTDiagnosticoGrid);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTCITADATA"), AV27SDTCitaData);
         /* Read saved values. */
         nRC_GXsfl_166 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_166"), ",", ".")) ;
         AV6CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vCITAID"), ",", ".")) ;
         AV32UrlEp = httpContext.cgiGet( "vURLEP") ;
         GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTDIAGNOSTICOGRIDS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_nEOF"), ",", ".")) ;
         subGridsdtdiagnosticogrids_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_panelbuttons_Width = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Width") ;
         Dvpanel_panelbuttons_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Autowidth")) ;
         Dvpanel_panelbuttons_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Autoheight")) ;
         Dvpanel_panelbuttons_Cls = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Cls") ;
         Dvpanel_panelbuttons_Title = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Title") ;
         Dvpanel_panelbuttons_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Collapsible")) ;
         Dvpanel_panelbuttons_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Collapsed")) ;
         Dvpanel_panelbuttons_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Showcollapseicon")) ;
         Dvpanel_panelbuttons_Iconposition = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Iconposition") ;
         Dvpanel_panelbuttons_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Autoscroll")) ;
         Dvpanel_paneldiagnostico_Width = httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Width") ;
         Dvpanel_paneldiagnostico_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Autowidth")) ;
         Dvpanel_paneldiagnostico_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Autoheight")) ;
         Dvpanel_paneldiagnostico_Cls = httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Cls") ;
         Dvpanel_paneldiagnostico_Title = httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Title") ;
         Dvpanel_paneldiagnostico_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Collapsible")) ;
         Dvpanel_paneldiagnostico_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Collapsed")) ;
         Dvpanel_paneldiagnostico_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Showcollapseicon")) ;
         Dvpanel_paneldiagnostico_Iconposition = httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Iconposition") ;
         Dvpanel_paneldiagnostico_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDIAGNOSTICO_Autoscroll")) ;
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), ",", ".")) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         Dvpanel_paneldetalles_Width = httpContext.cgiGet( "DVPANEL_PANELDETALLES_Width") ;
         Dvpanel_paneldetalles_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLES_Autowidth")) ;
         Dvpanel_paneldetalles_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLES_Autoheight")) ;
         Dvpanel_paneldetalles_Cls = httpContext.cgiGet( "DVPANEL_PANELDETALLES_Cls") ;
         Dvpanel_paneldetalles_Title = httpContext.cgiGet( "DVPANEL_PANELDETALLES_Title") ;
         Dvpanel_paneldetalles_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLES_Collapsible")) ;
         Dvpanel_paneldetalles_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLES_Collapsed")) ;
         Dvpanel_paneldetalles_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLES_Showcollapseicon")) ;
         Dvpanel_paneldetalles_Iconposition = httpContext.cgiGet( "DVPANEL_PANELDETALLES_Iconposition") ;
         Dvpanel_paneldetalles_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLES_Autoscroll")) ;
         Dvpanel_panebtns_Width = httpContext.cgiGet( "DVPANEL_PANEBTNS_Width") ;
         Dvpanel_panebtns_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEBTNS_Autowidth")) ;
         Dvpanel_panebtns_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEBTNS_Autoheight")) ;
         Dvpanel_panebtns_Cls = httpContext.cgiGet( "DVPANEL_PANEBTNS_Cls") ;
         Dvpanel_panebtns_Title = httpContext.cgiGet( "DVPANEL_PANEBTNS_Title") ;
         Dvpanel_panebtns_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEBTNS_Collapsible")) ;
         Dvpanel_panebtns_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEBTNS_Collapsed")) ;
         Dvpanel_panebtns_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEBTNS_Showcollapseicon")) ;
         Dvpanel_panebtns_Iconposition = httpContext.cgiGet( "DVPANEL_PANEBTNS_Iconposition") ;
         Dvpanel_panebtns_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEBTNS_Autoscroll")) ;
         Gridsdtdiagnosticogrids_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Gridinternalname") ;
         Gridsdtdiagnosticogrids_empowerer_Infinitescrolling = httpContext.cgiGet( "GRIDSDTDIAGNOSTICOGRIDS_EMPOWERER_Infinitescrolling") ;
         nRC_GXsfl_166 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_166"), ",", ".")) ;
         nGXsfl_166_fel_idx = 0 ;
         while ( nGXsfl_166_fel_idx < nRC_GXsfl_166 )
         {
            nGXsfl_166_fel_idx = ((subGridsdtdiagnosticogrids_Islastpage==1)&&(nGXsfl_166_fel_idx+1>subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ? 1 : nGXsfl_166_fel_idx+1) ;
            sGXsfl_166_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1662( ) ;
            AV60GXV25 = nGXsfl_166_fel_idx ;
            if ( ( AV29SDTDiagnosticoGrids.size() >= AV60GXV25 ) && ( AV60GXV25 > 0 ) )
            {
               AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
               AV10DiagnosticoEliminar = httpContext.cgiGet( edtavDiagnosticoeliminar_Internalname) ;
            }
         }
         if ( nGXsfl_166_fel_idx == 0 )
         {
            nGXsfl_166_idx = 1 ;
            sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1662( ) ;
         }
         nGXsfl_166_fel_idx = 1 ;
         /* Read variables values. */
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientenombres( httpContext.cgiGet( edtavSdtpacientedata_pacientenombres_Internalname) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacienteapellidopaterno( httpContext.cgiGet( edtavSdtpacientedata_pacienteapellidopaterno_Internalname) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacienteapellidomaterno( httpContext.cgiGet( edtavSdtpacientedata_pacienteapellidomaterno_Internalname) );
         cmbavSdtpacientedata_pacientetipodocumento.setName( cmbavSdtpacientedata_pacientetipodocumento.getInternalname() );
         cmbavSdtpacientedata_pacientetipodocumento.setValue( httpContext.cgiGet( cmbavSdtpacientedata_pacientetipodocumento.getInternalname()) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( httpContext.cgiGet( cmbavSdtpacientedata_pacientetipodocumento.getInternalname()) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientenrodocumento( httpContext.cgiGet( edtavSdtpacientedata_pacientenrodocumento_Internalname) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion( httpContext.cgiGet( edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname) );
         cmbavSdtpacientedata_pacientesexo.setName( cmbavSdtpacientedata_pacientesexo.getInternalname() );
         cmbavSdtpacientedata_pacientesexo.setValue( httpContext.cgiGet( cmbavSdtpacientedata_pacientesexo.getInternalname()) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientesexo( httpContext.cgiGet( cmbavSdtpacientedata_pacientesexo.getInternalname()) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetelefono( httpContext.cgiGet( edtavSdtpacientedata_pacientetelefono_Internalname) );
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientecorreo( httpContext.cgiGet( edtavSdtpacientedata_pacientecorreo_Internalname) );
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavSdtcitadata_citaestatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavSdtcitadata_citaestatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SDTCITADATA_CITAESTATURA");
            GX_FocusControl = edtavSdtcitadata_citaestatura_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citaestatura( DecimalUtil.ZERO );
         }
         else
         {
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citaestatura( localUtil.ctond( httpContext.cgiGet( edtavSdtcitadata_citaestatura_Internalname)) );
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavSdtcitadata_citapeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavSdtcitadata_citapeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SDTCITADATA_CITAPESO");
            GX_FocusControl = edtavSdtcitadata_citapeso_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citapeso( DecimalUtil.ZERO );
         }
         else
         {
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citapeso( localUtil.ctond( httpContext.cgiGet( edtavSdtcitadata_citapeso_Internalname)) );
         }
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientedireccion( httpContext.cgiGet( edtavSdtpacientedata_pacientedireccion_Internalname) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname) );
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavSdtcitadata_citafechareserva_Internalname), (byte)(3), (byte)(0)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "SDTCITADATA_CITAFECHARESERVA");
            GX_FocusControl = edtavSdtcitadata_citafechareserva_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citafechareserva( GXutil.nullDate() );
         }
         else
         {
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citafechareserva( localUtil.ctot( httpContext.cgiGet( edtavSdtcitadata_citafechareserva_Internalname)) );
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "SDTCITADATA_SGCITADISPONIBILIDADFECHA");
            GX_FocusControl = edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( GXutil.nullDate() );
         }
         else
         {
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( localUtil.ctod( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname), 3) );
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "SDTCITADATA_SGCITADISPONIBILIDADHORAINICIO");
            GX_FocusControl = edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( GXutil.nullDate() );
         }
         else
         {
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( localUtil.ctot( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname)) );
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "SDTCITADATA_SGCITADISPONIBILIDADHORAFIN");
            GX_FocusControl = edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin( GXutil.nullDate() );
         }
         else
         {
            AV27SDTCitaData.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin( localUtil.ctot( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname)) );
         }
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citamotivoconsulta( httpContext.cgiGet( edtavSdtcitadata_citamotivoconsulta_Internalname) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citacode( httpContext.cgiGet( edtavSdtcitadata_citacode_Internalname) );
         cmbavSdtcitadata_citaestadocita.setName( cmbavSdtcitadata_citaestadocita.getInternalname() );
         cmbavSdtcitadata_citaestadocita.setValue( httpContext.cgiGet( cmbavSdtcitadata_citaestadocita.getInternalname()) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citaestadocita( httpContext.cgiGet( cmbavSdtcitadata_citaestadocita.getInternalname()) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citaantecedentes( httpContext.cgiGet( edtavSdtcitadata_citaantecedentes_Internalname) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citainforme( httpContext.cgiGet( edtavSdtcitadata_citainforme_Internalname) );
         cmbavSdtcitadata_citatipodiagnostico.setName( cmbavSdtcitadata_citatipodiagnostico.getInternalname() );
         cmbavSdtcitadata_citatipodiagnostico.setValue( httpContext.cgiGet( cmbavSdtcitadata_citatipodiagnostico.getInternalname()) );
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citatipodiagnostico( httpContext.cgiGet( cmbavSdtcitadata_citatipodiagnostico.getInternalname()) );
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
      e166I2 ();
      if (returnInSub) return;
   }

   public void e166I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.getJscriptsrc().add("AbrirNuevaVentana.js") ;
      AV21isOpenVideoCall = false ;
      if ( ! (0==AV6CitaId) )
      {
         /* Execute user subroutine: 'LOADDATA' */
         S112 ();
         if (returnInSub) return;
      }
      else
      {
         httpContext.GX_msglist.addItem("El Id de la Cita no puede estar vacía");
         httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV6CitaId)});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV6CitaId"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      GXt_boolean1 = AV20IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WPInformeCita", GXv_boolean2) ;
      wpdetallecita_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV20IsAuthorized = GXt_boolean1 ;
      if ( ! AV20IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV63Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      Gridsdtdiagnosticogrids_empowerer_Gridinternalname = subGridsdtdiagnosticogrids_Internalname ;
      ucGridsdtdiagnosticogrids_empowerer.sendProperty(context, "", false, Gridsdtdiagnosticogrids_empowerer_Internalname, "GridInternalName", Gridsdtdiagnosticogrids_empowerer_Gridinternalname);
      subGridsdtdiagnosticogrids_Rows = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtdiagnosticogrids_Rows, (byte)(6), (byte)(0), ".", "")));
      /* Using cursor H006I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV6CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A95CitaEstado = H006I2_A95CitaEstado[0] ;
         n95CitaEstado = H006I2_n95CitaEstado[0] ;
         A19CitaId = H006I2_A19CitaId[0] ;
         A20PacienteId = H006I2_A20PacienteId[0] ;
         A89CitaEstadoCita = H006I2_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = H006I2_n89CitaEstadoCita[0] ;
         A64CitaCode = H006I2_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = H006I2_A21SGCitaDisponibilidadId[0] ;
         AV25PacienteId = A20PacienteId ;
         AV16EstadoCita = A89CitaEstadoCita ;
         AV7CodigoCita = A64CitaCode ;
         AV13DisponibilidadId = A21SGCitaDisponibilidadId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV16EstadoCita, "F") == 0 )
      {
         bttBtnbtnreprogramarcita_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnreprogramarcita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnreprogramarcita_Visible), 5, 0), true);
         bttBtnbtnunirsevideollamada_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnunirsevideollamada_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnunirsevideollamada_Visible), 5, 0), true);
         bttBtnagregardiagnostico_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnagregardiagnostico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnagregardiagnostico_Visible), 5, 0), true);
         bttBtnbtnguardar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnguardar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnguardar_Visible), 5, 0), true);
         bttBtnbtncancelar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnbtncancelar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtncancelar_Visible), 5, 0), true);
         cmbavSdtcitadata_citaestadocita.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citaestadocita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcitadata_citaestadocita.getEnabled(), 5, 0), true);
         edtavSdtcitadata_citaantecedentes_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaantecedentes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaantecedentes_Enabled), 5, 0), true);
         edtavSdtcitadata_citainforme_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citainforme_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citainforme_Enabled), 5, 0), true);
         cmbavSdtcitadata_citatipodiagnostico.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcitadata_citatipodiagnostico.getEnabled(), 5, 0), true);
      }
      AV14Domain = "meet.jit.si" ;
      AV26RoomName = AV7CodigoCita ;
      AV24MeetConfig = (com.hugao.hugaojitsiclient.common.SdtMeetConfig)new com.hugao.hugaojitsiclient.common.SdtMeetConfig(remoteHandle, context);
      AV24MeetConfig.setgxTv_SdtMeetConfig_Domain( AV14Domain );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().setgxTv_SdtMeetConfig_Options_Roomname( AV26RoomName );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Deeplinking( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Sharingchrome( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Sharingfirefox( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Notstoreroom( true );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Welcomepage( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Closepage( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Defaultlanguage( "es" );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startaudioonly( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startwithaudiomuted( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startwithvideomuted( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Resolution( (short)(1080) );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Recording().setgxTv_SdtMeetConfig_Options_Config_Recording_Recordingsservice( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Recording().setgxTv_SdtMeetConfig_Options_Config_Recording_Livestreamingenabled( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Filmstriponly( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Jitsiwatermark( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Watermarkforguests( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Brandwatermark( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Poweredby( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Verticalfilmstrip( true );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Disableringing( true );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Mobileapppromo( false );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Connectionindicatordisabled( true );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Videoqualitylabeldisabled( true );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().getgxTv_SdtMeetConfig_Options_InterfaceConfig_Settingssections().add("devices", 0);
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Videolayoutfit( "both" );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Openinmobilebrowser( true );
   }

   private void e176I2( )
   {
      /* Gridsdtdiagnosticogrids_Load Routine */
      returnInSub = false ;
      AV60GXV25 = 1 ;
      while ( AV60GXV25 <= AV29SDTDiagnosticoGrids.size() )
      {
         AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
         AV10DiagnosticoEliminar = "<i class=\"fa fa-times\" style=\"font-size:16px;\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDiagnosticoeliminar_Internalname, AV10DiagnosticoEliminar);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(166) ;
         }
         if ( ( subGridsdtdiagnosticogrids_Islastpage == 1 ) || ( subGridsdtdiagnosticogrids_Rows == 0 ) || ( ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord >= GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage ) && ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord < GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage + subgridsdtdiagnosticogrids_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1662( ) ;
            GRIDSDTDIAGNOSTICOGRIDS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord + 1 >= subgridsdtdiagnosticogrids_fnc_recordcount( ) )
            {
               GRIDSDTDIAGNOSTICOGRIDS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTDIAGNOSTICOGRIDS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTDIAGNOSTICOGRIDS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord = (long)(GRIDSDTDIAGNOSTICOGRIDS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_166_Refreshing )
         {
            httpContext.doAjaxLoad(166, GridsdtdiagnosticogridsRow);
         }
         AV60GXV25 = (int)(AV60GXV25+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e116I2( )
   {
      AV60GXV25 = nGXsfl_166_idx ;
      if ( AV29SDTDiagnosticoGrids.size() >= AV60GXV25 )
      {
         AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
      }
      /* 'DoBtnGuardar' Routine */
      returnInSub = false ;
      GXv_char3[0] = AV15ErrorMessageSaveCita ;
      GXv_boolean2[0] = AV22isSaved ;
      new com.projectthani.prcguardarinformecita(remoteHandle, context).execute( AV27SDTCitaData, GXv_char3, GXv_boolean2) ;
      wpdetallecita_impl.this.AV15ErrorMessageSaveCita = GXv_char3[0] ;
      wpdetallecita_impl.this.AV22isSaved = GXv_boolean2[0] ;
      if ( AV22isSaved )
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", AV15ErrorMessageSaveCita, "success", "", "true"));
         new com.projectthani.prcguardardiagnosticos(remoteHandle, context).execute( AV29SDTDiagnosticoGrids, AV6CitaId) ;
         if ( GXutil.strcmp(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita(), "F") == 0 )
         {
            bttBtnbtnreprogramarcita_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnreprogramarcita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnreprogramarcita_Visible), 5, 0), true);
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", AV15ErrorMessageSaveCita, "error", "", "true"));
      }
      /*  Sending Event outputs  */
   }

   public void e126I2( )
   {
      /* 'DoBtnCancelar' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV6CitaId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV6CitaId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void e136I2( )
   {
      /* 'DoBtnUnirseVideollamada' Routine */
      returnInSub = false ;
      AV21isOpenVideoCall = true ;
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Displayname( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname() );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Email( "" );
      AV24MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Avatarimage( "" );
      AV5JitsiJWTContext = (com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext)new com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext(remoteHandle, context);
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Id( java.util.UUID.randomUUID( ).toString() );
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Name( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname() );
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Email( "" );
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Avatar( "" );
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "_JITSI_MEET_CONTAINER", divTablemeetcontainer_Internalname);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "UseAllWindowForMeet", true);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "DisposeOnUnload", false);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "PipLocation", "tr");
      this.executeExternalObjectMethod("", false, "gx.hugao.jitsiclient.meet", "prepare", new Object[] {AV24MeetConfig,Boolean.valueOf(true)}, false);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24MeetConfig", AV24MeetConfig);
   }

   public void e146I2( )
   {
      AV60GXV25 = nGXsfl_166_idx ;
      if ( AV29SDTDiagnosticoGrids.size() >= AV60GXV25 )
      {
         AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
      }
      /* GlobalEvents_Selectdiagnostico Routine */
      returnInSub = false ;
      AV28SDTDiagnosticoGrid = (com.projectthani.SdtSDTDiagnosticoGrid)new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo( AV8DiagnosticoCodigo );
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion( AV9DiagnosticoDescripcion );
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc( AV12DiagnosticoLongDesc );
      AV28SDTDiagnosticoGrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid( AV11DiagnosticoId );
      AV29SDTDiagnosticoGrids.add(AV28SDTDiagnosticoGrid, 0);
      gx_BV166 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28SDTDiagnosticoGrid", AV28SDTDiagnosticoGrid);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29SDTDiagnosticoGrids", AV29SDTDiagnosticoGrids);
      nGXsfl_166_bak_idx = nGXsfl_166_idx ;
      gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      nGXsfl_166_idx = nGXsfl_166_bak_idx ;
      sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1662( ) ;
   }

   public void e186I2( )
   {
      AV60GXV25 = nGXsfl_166_idx ;
      if ( AV29SDTDiagnosticoGrids.size() >= AV60GXV25 )
      {
         AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
      }
      /* Diagnosticoeliminar_Click Routine */
      returnInSub = false ;
      AV28SDTDiagnosticoGrid = (com.projectthani.SdtSDTDiagnosticoGrid)((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.currentItem());
      AV19i = (short)(AV29SDTDiagnosticoGrids.size()) ;
      while ( AV19i > 0 )
      {
         if ( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV19i)).getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid() == AV28SDTDiagnosticoGrid.getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid() )
         {
            AV29SDTDiagnosticoGrids.removeItem(AV19i);
            gx_BV166 = true ;
            new com.projectthani.prceliminardiagnostico(remoteHandle, context).execute( AV6CitaId, AV28SDTDiagnosticoGrid.getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid()) ;
         }
         AV19i = (short)(AV19i-1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28SDTDiagnosticoGrid", AV28SDTDiagnosticoGrid);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29SDTDiagnosticoGrids", AV29SDTDiagnosticoGrids);
      nGXsfl_166_bak_idx = nGXsfl_166_idx ;
      gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
      nGXsfl_166_idx = nGXsfl_166_bak_idx ;
      sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1662( ) ;
   }

   public void e156I2( )
   {
      AV60GXV25 = nGXsfl_166_idx ;
      if ( AV29SDTDiagnosticoGrids.size() >= AV60GXV25 )
      {
         AV29SDTDiagnosticoGrids.currentItem( ((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)) );
      }
      /* GlobalEvents_Reprogramarcita Routine */
      returnInSub = false ;
      if ( AV23isSuccess )
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27SDTCitaData", AV27SDTCitaData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30SDTPacienteData", AV30SDTPacienteData);
      if ( gx_BV166 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29SDTDiagnosticoGrids", AV29SDTDiagnosticoGrids);
         nGXsfl_166_bak_idx = nGXsfl_166_idx ;
         gxgrgridsdtdiagnosticogrids_refresh( subGridsdtdiagnosticogrids_Rows) ;
         nGXsfl_166_idx = nGXsfl_166_bak_idx ;
         sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1662( ) ;
      }
   }

   public void S112( )
   {
      /* 'LOADDATA' Routine */
      returnInSub = false ;
      GXt_SdtSDTCitaData4 = AV27SDTCitaData;
      GXv_SdtSDTCitaData5[0] = GXt_SdtSDTCitaData4;
      new com.projectthani.dpgetcitabyid(remoteHandle, context).execute( AV6CitaId, GXv_SdtSDTCitaData5) ;
      GXt_SdtSDTCitaData4 = GXv_SdtSDTCitaData5[0] ;
      AV27SDTCitaData = GXt_SdtSDTCitaData4;
      GXt_SdtSDTPacienteData6 = AV30SDTPacienteData;
      GXv_SdtSDTPacienteData7[0] = GXt_SdtSDTPacienteData6;
      new com.projectthani.dpgetpacientebyid(remoteHandle, context).execute( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Pacienteid(), GXv_SdtSDTPacienteData7) ;
      GXt_SdtSDTPacienteData6 = GXv_SdtSDTPacienteData7[0] ;
      AV30SDTPacienteData = GXt_SdtSDTPacienteData6;
      GXt_objcol_SdtSDTDiagnosticoGrid8 = AV29SDTDiagnosticoGrids ;
      GXv_objcol_SdtSDTDiagnosticoGrid9[0] = GXt_objcol_SdtSDTDiagnosticoGrid8 ;
      new com.projectthani.dpgetdiagnosticosbycitaid(remoteHandle, context).execute( AV6CitaId, GXv_objcol_SdtSDTDiagnosticoGrid9) ;
      GXt_objcol_SdtSDTDiagnosticoGrid8 = GXv_objcol_SdtSDTDiagnosticoGrid9[0] ;
      AV29SDTDiagnosticoGrids = GXt_objcol_SdtSDTDiagnosticoGrid8 ;
      gx_BV166 = true ;
      if ( GXutil.strcmp(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita(), "F") == 0 )
      {
      }
   }

   public void wb_table3_174_6I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanebtns_Internalname, tblPanebtns_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnguardar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "GUARDAR", bttBtnbtnguardar_Jsonclick, 5, "GUARDAR", "", StyleString, ClassString, bttBtnbtnguardar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNGUARDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtncancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "CANCELAR", bttBtnbtncancelar_Jsonclick, 5, "CANCELAR", "", StyleString, ClassString, bttBtnbtncancelar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNCANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_174_6I2e( true) ;
      }
      else
      {
         wb_table3_174_6I2e( false) ;
      }
   }

   public void wb_table2_33_6I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPaneldetalles_Internalname, tblPaneldetalles_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabinfopaciente_title_Internalname, "Información del Paciente", "", "", lblTabinfopaciente_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPDetalleCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabInfoPaciente") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientenombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientenombres_Internalname, "Nombres", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientenombres_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenombres(), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenombres(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientenombres_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacientenombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacienteapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Apellido Paterno", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacienteapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacienteapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Apellido Materno", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacienteapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSdtpacientedata_pacientetipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Tipo Documento", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtpacientedata_pacientetipodocumento, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()), 1, cmbavSdtpacientedata_pacientetipodocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavSdtpacientedata_pacientetipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_WPDetalleCita.htm");
         cmbavSdtpacientedata_pacientetipodocumento.setValue( GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientetipodocumento.getInternalname(), "Values", cmbavSdtpacientedata_pacientetipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientenrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientenrodocumento_Internalname, "Nro Documento", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientenrodocumento_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenrodocumento(), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenrodocumento(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientenrodocumento_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacientenrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Fecha Nacimiento", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSdtpacientedata_pacientesexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtpacientedata_pacientesexo.getInternalname(), "Sexo", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtpacientedata_pacientesexo, cmbavSdtpacientedata_pacientesexo.getInternalname(), GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientesexo()), 1, cmbavSdtpacientedata_pacientesexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavSdtpacientedata_pacientesexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_WPDetalleCita.htm");
         cmbavSdtpacientedata_pacientesexo.setValue( GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientesexo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtpacientedata_pacientesexo.getInternalname(), "Values", cmbavSdtpacientedata_pacientesexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientetelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientetelefono_Internalname, "Telefono", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientetelefono_Internalname, GXutil.rtrim( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetelefono()), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetelefono(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientetelefono_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacientetelefono_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientecorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientecorreo_Internalname, "Correo", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientecorreo_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientecorreo(), GXutil.rtrim( localUtil.format( AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientecorreo(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientecorreo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtpacientedata_pacientecorreo_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citaestatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citaestatura_Internalname, "Estatura", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citaestatura_Internalname, GXutil.ltrim( localUtil.ntoc( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestatura(), (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtavSdtcitadata_citaestatura_Enabled!=0) ? localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestatura(), "9.99") : localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestatura(), "9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citaestatura_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_citaestatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citapeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citapeso_Internalname, "Peso", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citapeso_Internalname, GXutil.ltrim( localUtil.ntoc( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citapeso(), (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtavSdtcitadata_citapeso_Enabled!=0) ? localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citapeso(), "ZZ9.99") : localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citapeso(), "ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citapeso_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_citapeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtpacientedata_pacientedireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientedireccion_Internalname, "Dirección", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtpacientedata_pacientedireccion_Internalname, AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientedireccion(), "", "", (short)(0), 1, edtavSdtpacientedata_pacientedireccion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabinfocita_title_Internalname, "Información de la Cita", "", "", lblTabinfocita_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPDetalleCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabInfoCita") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableinformecita_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, "Medico", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname, AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname(), GXutil.rtrim( localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadprofullname_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Especialidad", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(), GXutil.rtrim( localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citafechareserva_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citafechareserva_Internalname, "Fecha Reserva", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavSdtcitadata_citafechareserva_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citafechareserva_Internalname, localUtil.ttoc( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citafechareserva(), 10, 8, 0, 3, "/", ":", " "), localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citafechareserva(), "99/99/99 99:99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citafechareserva_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_citafechareserva_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavSdtcitadata_citafechareserva_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavSdtcitadata_citafechareserva_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPDetalleCita.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, "Fecha Cita", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname, localUtil.format(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha(), "99/99/99"), localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha(), "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadfecha_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPDetalleCita.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, "Hora Inicio", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname, localUtil.ttoc( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio(), 10, 8, 0, 3, "/", ":", " "), localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio(), "99:99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadhorainicio_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPDetalleCita.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname, "Hora Fin", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname, localUtil.ttoc( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin(), 10, 8, 0, 3, "/", ":", " "), localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin(), "99:99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadhorafin_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPDetalleCita.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citamotivoconsulta_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citamotivoconsulta_Internalname, "Motivo Consulta", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtcitadata_citamotivoconsulta_Internalname, AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citamotivoconsulta(), "", "", (short)(0), 1, edtavSdtcitadata_citamotivoconsulta_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citacode_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citacode_Internalname, "Codigo Cita", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citacode_Internalname, AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citacode(), GXutil.rtrim( localUtil.format( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citacode(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citacode_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavSdtcitadata_citacode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSdtcitadata_citaestadocita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtcitadata_citaestadocita.getInternalname(), "Estado Cita", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 137,'',false,'" + sGXsfl_166_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtcitadata_citaestadocita, cmbavSdtcitadata_citaestadocita.getInternalname(), GXutil.rtrim( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita()), 1, cmbavSdtcitadata_citaestadocita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavSdtcitadata_citaestadocita.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,137);\"", "", true, (byte)(1), "HLP_WPDetalleCita.htm");
         cmbavSdtcitadata_citaestadocita.setValue( GXutil.rtrim( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citaestadocita.getInternalname(), "Values", cmbavSdtcitadata_citaestadocita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citaantecedentes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citaantecedentes_Internalname, "Antecedentes", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'" + sGXsfl_166_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtcitadata_citaantecedentes_Internalname, AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaantecedentes(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,142);\"", (short)(0), 1, edtavSdtcitadata_citaantecedentes_Enabled, 1, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSdtcitadata_citainforme_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citainforme_Internalname, "HISTORIA MÉDICO ACTUAL", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 146,'',false,'" + sGXsfl_166_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavSdtcitadata_citainforme_Internalname, AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citainforme(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,146);\"", (short)(0), 1, edtavSdtcitadata_citainforme_Enabled, 1, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabdiagnostico_title_Internalname, "Diagnóstico", "", "", lblTabdiagnostico_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPDetalleCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabDiagnostico") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablediagnostico_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSdtcitadata_citatipodiagnostico.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Tipo Diagnóstico", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'" + sGXsfl_166_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtcitadata_citatipodiagnostico, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), GXutil.rtrim( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citatipodiagnostico()), 1, cmbavSdtcitadata_citatipodiagnostico.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavSdtcitadata_citatipodiagnostico.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,156);\"", "", true, (byte)(1), "HLP_WPDetalleCita.htm");
         cmbavSdtcitadata_citatipodiagnostico.setValue( GXutil.rtrim( AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Values", cmbavSdtcitadata_citatipodiagnostico.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnagregardiagnostico_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "Agregar Diagnóstico", bttBtnagregardiagnostico_Jsonclick, 7, "Agregar Diagnóstico", "", StyleString, ClassString, bttBtnagregardiagnostico_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e196i1_client"+"'", TempTags, "", 2, "HLP_WPDetalleCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_paneldiagnostico.setProperty("Width", Dvpanel_paneldiagnostico_Width);
         ucDvpanel_paneldiagnostico.setProperty("AutoWidth", Dvpanel_paneldiagnostico_Autowidth);
         ucDvpanel_paneldiagnostico.setProperty("AutoHeight", Dvpanel_paneldiagnostico_Autoheight);
         ucDvpanel_paneldiagnostico.setProperty("Cls", Dvpanel_paneldiagnostico_Cls);
         ucDvpanel_paneldiagnostico.setProperty("Title", Dvpanel_paneldiagnostico_Title);
         ucDvpanel_paneldiagnostico.setProperty("Collapsible", Dvpanel_paneldiagnostico_Collapsible);
         ucDvpanel_paneldiagnostico.setProperty("Collapsed", Dvpanel_paneldiagnostico_Collapsed);
         ucDvpanel_paneldiagnostico.setProperty("ShowCollapseIcon", Dvpanel_paneldiagnostico_Showcollapseicon);
         ucDvpanel_paneldiagnostico.setProperty("IconPosition", Dvpanel_paneldiagnostico_Iconposition);
         ucDvpanel_paneldiagnostico.setProperty("AutoScroll", Dvpanel_paneldiagnostico_Autoscroll);
         ucDvpanel_paneldiagnostico.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneldiagnostico_Internalname, "DVPANEL_PANELDIAGNOSTICOContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELDIAGNOSTICOContainer"+"PanelDiagnostico"+"\" style=\"display:none;\">") ;
         wb_table4_163_6I2( true) ;
      }
      else
      {
         wb_table4_163_6I2( false) ;
      }
      return  ;
   }

   public void wb_table4_163_6I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_33_6I2e( true) ;
      }
      else
      {
         wb_table2_33_6I2e( false) ;
      }
   }

   public void wb_table4_163_6I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPaneldiagnostico_Internalname, tblPaneldiagnostico_Internalname, "", "TablePanelDiagnostico", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\" class='HasGridEmpowerer'>") ;
         /*  Grid Control  */
         GridsdtdiagnosticogridsContainer.SetWrapped(nGXWrapped);
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtdiagnosticogridsContainer"+"DivS\" data-gxgridid=\"166\">") ;
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeDeleteDiagnostico"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Eliminar") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Codigo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Descripción") ;
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
            GridsdtdiagnosticogridsColumn.AddObjectProperty("Value", AV10DiagnosticoEliminar);
            GridsdtdiagnosticogridsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDiagnosticoeliminar_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtdiagnosticogridsContainer.AddColumnProperties(GridsdtdiagnosticogridsColumn);
            GridsdtdiagnosticogridsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtdiagnosticogridsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      if ( wbEnd == 166 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_166 = (int)(nGXsfl_166_idx-1) ;
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nEOF", GRIDSDTDIAGNOSTICOGRIDS_nEOF);
            GridsdtdiagnosticogridsContainer.AddObjectProperty("GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage", GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage);
            AV60GXV25 = nGXsfl_166_idx ;
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
         wb_table4_163_6I2e( true) ;
      }
      else
      {
         wb_table4_163_6I2e( false) ;
      }
   }

   public void wb_table1_17_6I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelbuttons_Internalname, tblPanelbuttons_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         ClassString = "BtnEnter" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnregresar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "Regresar", bttBtnbtnregresar_Jsonclick, 7, "Regresar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e206i1_client"+"'", TempTags, "", 2, "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnunirsevideollamada_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "videollamada", bttBtnbtnunirsevideollamada_Jsonclick, 5, "videollamada", "", StyleString, ClassString, bttBtnbtnunirsevideollamada_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNUNIRSEVIDEOLLAMADA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnregreceta_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "Registrar Receta", bttBtnbtnregreceta_Jsonclick, 7, "Registrar Receta", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e216i1_client"+"'", TempTags, "", 2, "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnreprogramarcita_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "Reprogramar cita", bttBtnbtnreprogramarcita_Jsonclick, 7, "Reprogramar cita", "", StyleString, ClassString, bttBtnbtnreprogramarcita_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e226i1_client"+"'", TempTags, "", 2, "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnepicrisis_Internalname, "gx.evt.setGridEvt("+GXutil.str( 166, 3, 0)+","+"null"+");", "Epicrisis", bttBtnbtnepicrisis_Jsonclick, 7, "Epicrisis", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e236i1_client"+"'", TempTags, "", 2, "HLP_WPDetalleCita.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_17_6I2e( true) ;
      }
      else
      {
         wb_table1_17_6I2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CitaId), 8, 0));
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
      pa6I2( ) ;
      ws6I2( ) ;
      we6I2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110341350", true, true);
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
      httpContext.AddJavascriptSource("wpdetallecita.js", "?20225110341351", false, true);
      httpContext.AddJavascriptSource("Resources\\HugaoJitsiClient\\gx-hugao-jitsiclient.js", "", false, true);
      httpContext.AddJavascriptSource("Resources\\HugaoJitsiClient\\gx-hugao-jitsiclient.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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

   public void subsflControlProps_1662( )
   {
      edtavDiagnosticoeliminar_Internalname = "vDIAGNOSTICOELIMINAR_"+sGXsfl_166_idx ;
      edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOCODIGO_"+sGXsfl_166_idx ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOLONGDESC_"+sGXsfl_166_idx ;
   }

   public void subsflControlProps_fel_1662( )
   {
      edtavDiagnosticoeliminar_Internalname = "vDIAGNOSTICOELIMINAR_"+sGXsfl_166_fel_idx ;
      edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOCODIGO_"+sGXsfl_166_fel_idx ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOLONGDESC_"+sGXsfl_166_fel_idx ;
   }

   public void sendrow_1662( )
   {
      subsflControlProps_1662( ) ;
      wb6I0( ) ;
      if ( ( subGridsdtdiagnosticogrids_Rows * 1 == 0 ) || ( nGXsfl_166_idx - GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage <= subgridsdtdiagnosticogrids_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_166_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_166_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDiagnosticoeliminar_Enabled!=0)&&(edtavDiagnosticoeliminar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 167,'',false,'"+sGXsfl_166_idx+"',166)\"" : " ") ;
         ROClassString = "AttributeDeleteDiagnostico" ;
         GridsdtdiagnosticogridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDiagnosticoeliminar_Internalname,AV10DiagnosticoEliminar,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDiagnosticoeliminar_Enabled!=0)&&(edtavDiagnosticoeliminar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,167);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDIAGNOSTICOELIMINAR.CLICK."+sGXsfl_166_idx+"'","","","","",edtavDiagnosticoeliminar_Jsonclick,Integer.valueOf(5),"AttributeDeleteDiagnostico","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDiagnosticoeliminar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(166),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtdiagnosticogridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname,((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)).getgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtdiagnosticogrids__diagnosticocodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(166),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtdiagnosticogridsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtdiagnosticogridsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname,((com.projectthani.SdtSDTDiagnosticoGrid)AV29SDTDiagnosticoGrids.elementAt(-1+AV60GXV25)).getgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtdiagnosticogrids__diagnosticolongdesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(166),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes6I2( ) ;
         GridsdtdiagnosticogridsContainer.AddRow(GridsdtdiagnosticogridsRow);
         nGXsfl_166_idx = ((subGridsdtdiagnosticogrids_Islastpage==1)&&(nGXsfl_166_idx+1>subgridsdtdiagnosticogrids_fnc_recordsperpage( )) ? 1 : nGXsfl_166_idx+1) ;
         sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1662( ) ;
      }
      /* End function sendrow_1662 */
   }

   public void init_default_properties( )
   {
      bttBtnbtnregresar_Internalname = "BTNBTNREGRESAR" ;
      bttBtnbtnunirsevideollamada_Internalname = "BTNBTNUNIRSEVIDEOLLAMADA" ;
      bttBtnbtnregreceta_Internalname = "BTNBTNREGRECETA" ;
      bttBtnbtnreprogramarcita_Internalname = "BTNBTNREPROGRAMARCITA" ;
      bttBtnbtnepicrisis_Internalname = "BTNBTNEPICRISIS" ;
      tblPanelbuttons_Internalname = "PANELBUTTONS" ;
      Dvpanel_panelbuttons_Internalname = "DVPANEL_PANELBUTTONS" ;
      lblTabinfopaciente_title_Internalname = "TABINFOPACIENTE_TITLE" ;
      edtavSdtpacientedata_pacientenombres_Internalname = "SDTPACIENTEDATA_PACIENTENOMBRES" ;
      edtavSdtpacientedata_pacienteapellidopaterno_Internalname = "SDTPACIENTEDATA_PACIENTEAPELLIDOPATERNO" ;
      edtavSdtpacientedata_pacienteapellidomaterno_Internalname = "SDTPACIENTEDATA_PACIENTEAPELLIDOMATERNO" ;
      cmbavSdtpacientedata_pacientetipodocumento.setInternalname( "SDTPACIENTEDATA_PACIENTETIPODOCUMENTO" );
      edtavSdtpacientedata_pacientenrodocumento_Internalname = "SDTPACIENTEDATA_PACIENTENRODOCUMENTO" ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname = "SDTPACIENTEDATA_PACIENTEFECHANACIMIENTODESCRIPCION" ;
      cmbavSdtpacientedata_pacientesexo.setInternalname( "SDTPACIENTEDATA_PACIENTESEXO" );
      edtavSdtpacientedata_pacientetelefono_Internalname = "SDTPACIENTEDATA_PACIENTETELEFONO" ;
      edtavSdtpacientedata_pacientecorreo_Internalname = "SDTPACIENTEDATA_PACIENTECORREO" ;
      edtavSdtcitadata_citaestatura_Internalname = "SDTCITADATA_CITAESTATURA" ;
      edtavSdtcitadata_citapeso_Internalname = "SDTCITADATA_CITAPESO" ;
      edtavSdtpacientedata_pacientedireccion_Internalname = "SDTPACIENTEDATA_PACIENTEDIRECCION" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      lblTabinfocita_title_Internalname = "TABINFOCITA_TITLE" ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADPROFULLNAME" ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtavSdtcitadata_citafechareserva_Internalname = "SDTCITADATA_CITAFECHARESERVA" ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADFECHA" ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADHORAINICIO" ;
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADHORAFIN" ;
      edtavSdtcitadata_citamotivoconsulta_Internalname = "SDTCITADATA_CITAMOTIVOCONSULTA" ;
      edtavSdtcitadata_citacode_Internalname = "SDTCITADATA_CITACODE" ;
      cmbavSdtcitadata_citaestadocita.setInternalname( "SDTCITADATA_CITAESTADOCITA" );
      edtavSdtcitadata_citaantecedentes_Internalname = "SDTCITADATA_CITAANTECEDENTES" ;
      edtavSdtcitadata_citainforme_Internalname = "SDTCITADATA_CITAINFORME" ;
      divTableinformecita_Internalname = "TABLEINFORMECITA" ;
      lblTabdiagnostico_title_Internalname = "TABDIAGNOSTICO_TITLE" ;
      cmbavSdtcitadata_citatipodiagnostico.setInternalname( "SDTCITADATA_CITATIPODIAGNOSTICO" );
      bttBtnagregardiagnostico_Internalname = "BTNAGREGARDIAGNOSTICO" ;
      edtavDiagnosticoeliminar_Internalname = "vDIAGNOSTICOELIMINAR" ;
      edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOCODIGO" ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname = "SDTDIAGNOSTICOGRIDS__DIAGNOSTICOLONGDESC" ;
      tblPaneldiagnostico_Internalname = "PANELDIAGNOSTICO" ;
      Dvpanel_paneldiagnostico_Internalname = "DVPANEL_PANELDIAGNOSTICO" ;
      divTablediagnostico_Internalname = "TABLEDIAGNOSTICO" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      tblPaneldetalles_Internalname = "PANELDETALLES" ;
      Dvpanel_paneldetalles_Internalname = "DVPANEL_PANELDETALLES" ;
      bttBtnbtnguardar_Internalname = "BTNBTNGUARDAR" ;
      bttBtnbtncancelar_Internalname = "BTNBTNCANCELAR" ;
      tblPanebtns_Internalname = "PANEBTNS" ;
      Dvpanel_panebtns_Internalname = "DVPANEL_PANEBTNS" ;
      divTablacontenedor_Internalname = "TABLACONTENEDOR" ;
      Msgdvelop_Internalname = "MSGDVELOP" ;
      divTablemeetcontainer_Internalname = "TABLEMEETCONTAINER" ;
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
      edtavSdtdiagnosticogrids__diagnosticocodigo_Jsonclick = "" ;
      edtavDiagnosticoeliminar_Jsonclick = "" ;
      edtavDiagnosticoeliminar_Visible = -1 ;
      bttBtnbtnreprogramarcita_Visible = 1 ;
      bttBtnbtnunirsevideollamada_Visible = 1 ;
      subGridsdtdiagnosticogrids_Allowcollapsing = (byte)(0) ;
      subGridsdtdiagnosticogrids_Allowselection = (byte)(0) ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
      edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled = 0 ;
      edtavDiagnosticoeliminar_Enabled = 1 ;
      subGridsdtdiagnosticogrids_Header = "" ;
      subGridsdtdiagnosticogrids_Class = "GridNoBorder WorkWith" ;
      subGridsdtdiagnosticogrids_Backcolorstyle = (byte)(0) ;
      bttBtnagregardiagnostico_Visible = 1 ;
      cmbavSdtcitadata_citatipodiagnostico.setJsonclick( "" );
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 1 );
      edtavSdtcitadata_citainforme_Enabled = 1 ;
      edtavSdtcitadata_citaantecedentes_Enabled = 1 ;
      cmbavSdtcitadata_citaestadocita.setJsonclick( "" );
      cmbavSdtcitadata_citaestadocita.setEnabled( 1 );
      edtavSdtcitadata_citacode_Jsonclick = "" ;
      edtavSdtcitadata_citacode_Enabled = 0 ;
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      edtavSdtcitadata_citafechareserva_Jsonclick = "" ;
      edtavSdtcitadata_citafechareserva_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      edtavSdtpacientedata_pacientedireccion_Enabled = 0 ;
      edtavSdtcitadata_citapeso_Jsonclick = "" ;
      edtavSdtcitadata_citapeso_Enabled = 0 ;
      edtavSdtcitadata_citaestatura_Jsonclick = "" ;
      edtavSdtcitadata_citaestatura_Enabled = 0 ;
      edtavSdtpacientedata_pacientecorreo_Jsonclick = "" ;
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      edtavSdtpacientedata_pacientetelefono_Jsonclick = "" ;
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      cmbavSdtpacientedata_pacientesexo.setJsonclick( "" );
      cmbavSdtpacientedata_pacientesexo.setEnabled( 0 );
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick = "" ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      edtavSdtpacientedata_pacientenrodocumento_Jsonclick = "" ;
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      cmbavSdtpacientedata_pacientetipodocumento.setJsonclick( "" );
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick = "" ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick = "" ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacientenombres_Jsonclick = "" ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      bttBtnbtncancelar_Visible = 1 ;
      bttBtnbtnguardar_Visible = 1 ;
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 1 );
      edtavSdtcitadata_citainforme_Enabled = 1 ;
      edtavSdtcitadata_citaantecedentes_Enabled = 1 ;
      cmbavSdtcitadata_citaestadocita.setEnabled( 1 );
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = -1 ;
      edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled = -1 ;
      edtavSdtcitadata_citacode_Enabled = -1 ;
      edtavSdtcitadata_citamotivoconsulta_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = -1 ;
      edtavSdtcitadata_citafechareserva_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = -1 ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = -1 ;
      edtavSdtpacientedata_pacientedireccion_Enabled = -1 ;
      edtavSdtcitadata_citapeso_Enabled = -1 ;
      edtavSdtcitadata_citaestatura_Enabled = -1 ;
      edtavSdtpacientedata_pacientecorreo_Enabled = -1 ;
      edtavSdtpacientedata_pacientetelefono_Enabled = -1 ;
      cmbavSdtpacientedata_pacientesexo.setEnabled( -1 );
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = -1 ;
      edtavSdtpacientedata_pacientenrodocumento_Enabled = -1 ;
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( -1 );
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = -1 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = -1 ;
      edtavSdtpacientedata_pacientenombres_Enabled = -1 ;
      Gridsdtdiagnosticogrids_empowerer_Infinitescrolling = "Grid" ;
      Dvpanel_panebtns_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panebtns_Iconposition = "Right" ;
      Dvpanel_panebtns_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panebtns_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panebtns_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panebtns_Title = "" ;
      Dvpanel_panebtns_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panebtns_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panebtns_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panebtns_Width = "100%" ;
      Dvpanel_paneldetalles_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalles_Iconposition = "Right" ;
      Dvpanel_paneldetalles_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalles_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalles_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneldetalles_Title = "" ;
      Dvpanel_paneldetalles_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_paneldetalles_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneldetalles_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalles_Width = "100%" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "" ;
      Gxuitabspanel_tabs_Pagecount = 3 ;
      Dvpanel_paneldiagnostico_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneldiagnostico_Iconposition = "Right" ;
      Dvpanel_paneldiagnostico_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneldiagnostico_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_paneldiagnostico_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneldiagnostico_Title = "Diagnósticos Asignados" ;
      Dvpanel_paneldiagnostico_Cls = "DVBootstrapResponsivePanel" ;
      Dvpanel_paneldiagnostico_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneldiagnostico_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneldiagnostico_Width = "100%" ;
      Dvpanel_panelbuttons_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Iconposition = "Right" ;
      Dvpanel_panelbuttons_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelbuttons_Title = "" ;
      Dvpanel_panelbuttons_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelbuttons_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelbuttons_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Width = "100%" ;
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
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientetipodocumento( cmbavSdtpacientedata_pacientetipodocumento.getValidValue(AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientetipodocumento()) );
      }
      cmbavSdtpacientedata_pacientesexo.setName( "SDTPACIENTEDATA_PACIENTESEXO" );
      cmbavSdtpacientedata_pacientesexo.setWebtags( "" );
      cmbavSdtpacientedata_pacientesexo.addItem("M", "Masculino", (short)(0));
      cmbavSdtpacientedata_pacientesexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavSdtpacientedata_pacientesexo.getItemCount() > 0 )
      {
         AV30SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientesexo( cmbavSdtpacientedata_pacientesexo.getValidValue(AV30SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientesexo()) );
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
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citaestadocita( cmbavSdtcitadata_citaestadocita.getValidValue(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citaestadocita()) );
      }
      cmbavSdtcitadata_citatipodiagnostico.setName( "SDTCITADATA_CITATIPODIAGNOSTICO" );
      cmbavSdtcitadata_citatipodiagnostico.setWebtags( "" );
      cmbavSdtcitadata_citatipodiagnostico.addItem("", "Seleccionar", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
      if ( cmbavSdtcitadata_citatipodiagnostico.getItemCount() > 0 )
      {
         AV27SDTCitaData.setgxTv_SdtSDTCitaData_Citatipodiagnostico( cmbavSdtcitadata_citatipodiagnostico.getValidValue(AV27SDTCitaData.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS.LOAD","{handler:'e176I2',iparms:[]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS.LOAD",",oparms:[{av:'AV10DiagnosticoEliminar',fld:'vDIAGNOSTICOELIMINAR',pic:''}]}");
      setEventMetadata("'DOBTNGUARDAR'","{handler:'e116I2',iparms:[{av:'AV27SDTCitaData',fld:'vSDTCITADATA',pic:''},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166},{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOBTNGUARDAR'",",oparms:[{ctrl:'BTNBTNREPROGRAMARCITA',prop:'Visible'}]}");
      setEventMetadata("'DOBTNCANCELAR'","{handler:'e126I2',iparms:[{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOBTNCANCELAR'",",oparms:[]}");
      setEventMetadata("'DOAGREGARDIAGNOSTICO'","{handler:'e196I1',iparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''}]");
      setEventMetadata("'DOAGREGARDIAGNOSTICO'",",oparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''}]}");
      setEventMetadata("'DOBTNREGRESAR'","{handler:'e206I1',iparms:[]");
      setEventMetadata("'DOBTNREGRESAR'",",oparms:[]}");
      setEventMetadata("'DOBTNUNIRSEVIDEOLLAMADA'","{handler:'e136I2',iparms:[{av:'AV27SDTCitaData',fld:'vSDTCITADATA',pic:''},{av:'AV24MeetConfig',fld:'vMEETCONFIG',pic:''}]");
      setEventMetadata("'DOBTNUNIRSEVIDEOLLAMADA'",",oparms:[{av:'AV24MeetConfig',fld:'vMEETCONFIG',pic:''},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Containername()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Containername'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Useallwindow()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Useallwindow'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Disposeonunload()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Disposeonunload'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Piplocation()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Piplocation'}]}");
      setEventMetadata("'DOBTNREGRECETA'","{handler:'e216I1',iparms:[{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOBTNREGRECETA'",",oparms:[]}");
      setEventMetadata("'DOBTNREPROGRAMARCITA'","{handler:'e226I1',iparms:[{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'AV27SDTCitaData',fld:'vSDTCITADATA',pic:''}]");
      setEventMetadata("'DOBTNREPROGRAMARCITA'",",oparms:[]}");
      setEventMetadata("'DOBTNEPICRISIS'","{handler:'e236I1',iparms:[{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOBTNEPICRISIS'",",oparms:[]}");
      setEventMetadata("GLOBALEVENTS.SELECTDIAGNOSTICO","{handler:'e146I2',iparms:[{av:'AV8DiagnosticoCodigo',fld:'vDIAGNOSTICOCODIGO',pic:''},{av:'AV9DiagnosticoDescripcion',fld:'vDIAGNOSTICODESCRIPCION',pic:''},{av:'AV12DiagnosticoLongDesc',fld:'vDIAGNOSTICOLONGDESC',pic:''},{av:'AV11DiagnosticoId',fld:'vDIAGNOSTICOID',pic:'ZZZZZZZ9'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("GLOBALEVENTS.SELECTDIAGNOSTICO",",oparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]}");
      setEventMetadata("VDIAGNOSTICOELIMINAR.CLICK","{handler:'e186I2',iparms:[{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166},{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("VDIAGNOSTICOELIMINAR.CLICK",",oparms:[{av:'AV28SDTDiagnosticoGrid',fld:'vSDTDIAGNOSTICOGRID',pic:''},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]}");
      setEventMetadata("GLOBALEVENTS.REPROGRAMARCITA","{handler:'e156I2',iparms:[{av:'AV23isSuccess',fld:'vISSUCCESS',pic:''},{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'}]");
      setEventMetadata("GLOBALEVENTS.REPROGRAMARCITA",",oparms:[{av:'AV27SDTCitaData',fld:'vSDTCITADATA',pic:''},{av:'AV30SDTPacienteData',fld:'vSDTPACIENTEDATA',pic:''},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_FIRSTPAGE","{handler:'subgridsdtdiagnosticogrids_firstpage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_PREVPAGE","{handler:'subgridsdtdiagnosticogrids_previouspage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_NEXTPAGE","{handler:'subgridsdtdiagnosticogrids_nextpage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_LASTPAGE","{handler:'subgridsdtdiagnosticogrids_lastpage',iparms:[{av:'GRIDSDTDIAGNOSTICOGRIDS_nFirstRecordOnPage'},{av:'GRIDSDTDIAGNOSTICOGRIDS_nEOF'},{av:'subGridsdtdiagnosticogrids_Rows',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'Rows'},{av:'AV29SDTDiagnosticoGrids',fld:'vSDTDIAGNOSTICOGRIDS',grid:166,pic:''},{av:'nRC_GXsfl_166',ctrl:'GRIDSDTDIAGNOSTICOGRIDS',prop:'GridRC',grid:166}]");
      setEventMetadata("GRIDSDTDIAGNOSTICOGRIDS_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_GXV4","{handler:'validv_Gxv4',iparms:[]");
      setEventMetadata("VALIDV_GXV4",",oparms:[]}");
      setEventMetadata("VALIDV_GXV7","{handler:'validv_Gxv7',iparms:[]");
      setEventMetadata("VALIDV_GXV7",",oparms:[]}");
      setEventMetadata("VALIDV_GXV9","{handler:'validv_Gxv9',iparms:[]");
      setEventMetadata("VALIDV_GXV9",",oparms:[]}");
      setEventMetadata("VALIDV_GXV21","{handler:'validv_Gxv21',iparms:[]");
      setEventMetadata("VALIDV_GXV21",",oparms:[]}");
      setEventMetadata("VALIDV_GXV24","{handler:'validv_Gxv24',iparms:[]");
      setEventMetadata("VALIDV_GXV24",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv27',iparms:[]");
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
      AV30SDTPacienteData = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      AV27SDTCitaData = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      AV29SDTDiagnosticoGrids = new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>(com.projectthani.SdtSDTDiagnosticoGrid.class, "SDTDiagnosticoGrid", "ProjectThani", remoteHandle);
      AV28SDTDiagnosticoGrid = new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      AV24MeetConfig = new com.hugao.hugaojitsiclient.common.SdtMeetConfig(remoteHandle, context);
      AV8DiagnosticoCodigo = "" ;
      AV9DiagnosticoDescripcion = "" ;
      AV12DiagnosticoLongDesc = "" ;
      AV32UrlEp = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_panelbuttons = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_paneldetalles = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panebtns = new com.genexus.webpanels.GXUserControl();
      ucMsgdvelop = new com.genexus.webpanels.GXUserControl();
      ucGridsdtdiagnosticogrids_empowerer = new com.genexus.webpanels.GXUserControl();
      GridsdtdiagnosticogridsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10DiagnosticoEliminar = "" ;
      GXCCtl = "" ;
      AV63Pgmname = "" ;
      scmdbuf = "" ;
      H006I2_A95CitaEstado = new String[] {""} ;
      H006I2_n95CitaEstado = new boolean[] {false} ;
      H006I2_A19CitaId = new int[1] ;
      H006I2_A20PacienteId = new int[1] ;
      H006I2_A89CitaEstadoCita = new String[] {""} ;
      H006I2_n89CitaEstadoCita = new boolean[] {false} ;
      H006I2_A64CitaCode = new String[] {""} ;
      H006I2_A21SGCitaDisponibilidadId = new int[1] ;
      A95CitaEstado = "" ;
      A89CitaEstadoCita = "" ;
      A64CitaCode = "" ;
      AV16EstadoCita = "" ;
      AV7CodigoCita = "" ;
      AV14Domain = "" ;
      AV26RoomName = "" ;
      GridsdtdiagnosticogridsRow = new com.genexus.webpanels.GXWebRow();
      AV15ErrorMessageSaveCita = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV5JitsiJWTContext = new com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext(remoteHandle, context);
      GXt_SdtSDTCitaData4 = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      GXv_SdtSDTCitaData5 = new com.projectthani.SdtSDTCitaData[1] ;
      GXt_SdtSDTPacienteData6 = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      GXv_SdtSDTPacienteData7 = new com.projectthani.SdtSDTPacienteData[1] ;
      GXt_objcol_SdtSDTDiagnosticoGrid8 = new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>(com.projectthani.SdtSDTDiagnosticoGrid.class, "SDTDiagnosticoGrid", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTDiagnosticoGrid9 = new GXBaseCollection[1] ;
      TempTags = "" ;
      bttBtnbtnguardar_Jsonclick = "" ;
      bttBtnbtncancelar_Jsonclick = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblTabinfopaciente_title_Jsonclick = "" ;
      lblTabinfocita_title_Jsonclick = "" ;
      lblTabdiagnostico_title_Jsonclick = "" ;
      bttBtnagregardiagnostico_Jsonclick = "" ;
      ucDvpanel_paneldiagnostico = new com.genexus.webpanels.GXUserControl();
      subGridsdtdiagnosticogrids_Linesclass = "" ;
      GridsdtdiagnosticogridsColumn = new com.genexus.webpanels.GXWebColumn();
      bttBtnbtnregresar_Jsonclick = "" ;
      bttBtnbtnunirsevideollamada_Jsonclick = "" ;
      bttBtnbtnregreceta_Jsonclick = "" ;
      bttBtnbtnreprogramarcita_Jsonclick = "" ;
      bttBtnbtnepicrisis_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpdetallecita__default(),
         new Object[] {
             new Object[] {
            H006I2_A95CitaEstado, H006I2_n95CitaEstado, H006I2_A19CitaId, H006I2_A20PacienteId, H006I2_A89CitaEstadoCita, H006I2_n89CitaEstadoCita, H006I2_A64CitaCode, H006I2_A21SGCitaDisponibilidadId
            }
         }
      );
      AV63Pgmname = "WPDetalleCita" ;
      /* GeneXus formulas. */
      AV63Pgmname = "WPDetalleCita" ;
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      cmbavSdtpacientedata_pacientetipodocumento.setEnabled( 0 );
      edtavSdtpacientedata_pacientenrodocumento_Enabled = 0 ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      cmbavSdtpacientedata_pacientesexo.setEnabled( 0 );
      edtavSdtpacientedata_pacientetelefono_Enabled = 0 ;
      edtavSdtpacientedata_pacientecorreo_Enabled = 0 ;
      edtavSdtcitadata_citaestatura_Enabled = 0 ;
      edtavSdtcitadata_citapeso_Enabled = 0 ;
      edtavSdtpacientedata_pacientedireccion_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      edtavSdtcitadata_citafechareserva_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled = 0 ;
      edtavSdtcitadata_citamotivoconsulta_Enabled = 0 ;
      edtavSdtcitadata_citacode_Enabled = 0 ;
      edtavDiagnosticoeliminar_Enabled = 0 ;
      edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled = 0 ;
      edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled = 0 ;
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
   private short AV19i ;
   private int wcpOAV6CitaId ;
   private int nRC_GXsfl_166 ;
   private int nGXsfl_166_idx=1 ;
   private int subGridsdtdiagnosticogrids_Rows ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int AV6CitaId ;
   private int AV11DiagnosticoId ;
   private int AV60GXV25 ;
   private int subGridsdtdiagnosticogrids_Islastpage ;
   private int edtavSdtpacientedata_pacientenombres_Enabled ;
   private int edtavSdtpacientedata_pacienteapellidopaterno_Enabled ;
   private int edtavSdtpacientedata_pacienteapellidomaterno_Enabled ;
   private int edtavSdtpacientedata_pacientenrodocumento_Enabled ;
   private int edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled ;
   private int edtavSdtpacientedata_pacientetelefono_Enabled ;
   private int edtavSdtpacientedata_pacientecorreo_Enabled ;
   private int edtavSdtcitadata_citaestatura_Enabled ;
   private int edtavSdtcitadata_citapeso_Enabled ;
   private int edtavSdtpacientedata_pacientedireccion_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadprofullname_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled ;
   private int edtavSdtcitadata_citafechareserva_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadfecha_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadhorainicio_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadhorafin_Enabled ;
   private int edtavSdtcitadata_citamotivoconsulta_Enabled ;
   private int edtavSdtcitadata_citacode_Enabled ;
   private int edtavDiagnosticoeliminar_Enabled ;
   private int edtavSdtdiagnosticogrids__diagnosticocodigo_Enabled ;
   private int edtavSdtdiagnosticogrids__diagnosticolongdesc_Enabled ;
   private int GRIDSDTDIAGNOSTICOGRIDS_nGridOutOfScope ;
   private int nGXsfl_166_fel_idx=1 ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV25PacienteId ;
   private int AV13DisponibilidadId ;
   private int bttBtnbtnreprogramarcita_Visible ;
   private int bttBtnbtnunirsevideollamada_Visible ;
   private int bttBtnagregardiagnostico_Visible ;
   private int bttBtnbtnguardar_Visible ;
   private int bttBtnbtncancelar_Visible ;
   private int edtavSdtcitadata_citaantecedentes_Enabled ;
   private int edtavSdtcitadata_citainforme_Enabled ;
   private int nGXsfl_166_bak_idx=1 ;
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
   private String sGXsfl_166_idx="0001" ;
   private String Dvpanel_panelbuttons_Width ;
   private String Dvpanel_panelbuttons_Cls ;
   private String Dvpanel_panelbuttons_Title ;
   private String Dvpanel_panelbuttons_Iconposition ;
   private String Dvpanel_paneldiagnostico_Width ;
   private String Dvpanel_paneldiagnostico_Cls ;
   private String Dvpanel_paneldiagnostico_Title ;
   private String Dvpanel_paneldiagnostico_Iconposition ;
   private String Gxuitabspanel_tabs_Class ;
   private String Dvpanel_paneldetalles_Width ;
   private String Dvpanel_paneldetalles_Cls ;
   private String Dvpanel_paneldetalles_Title ;
   private String Dvpanel_paneldetalles_Iconposition ;
   private String Dvpanel_panebtns_Width ;
   private String Dvpanel_panebtns_Cls ;
   private String Dvpanel_panebtns_Title ;
   private String Dvpanel_panebtns_Iconposition ;
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
   private String divTablacontenedor_Internalname ;
   private String Dvpanel_panelbuttons_Internalname ;
   private String Dvpanel_paneldetalles_Internalname ;
   private String Dvpanel_panebtns_Internalname ;
   private String Msgdvelop_Internalname ;
   private String divTablemeetcontainer_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Gridsdtdiagnosticogrids_empowerer_Internalname ;
   private String sStyleString ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavDiagnosticoeliminar_Internalname ;
   private String edtavSdtpacientedata_pacientenombres_Internalname ;
   private String GXCCtl ;
   private String AV63Pgmname ;
   private String edtavSdtpacientedata_pacienteapellidopaterno_Internalname ;
   private String edtavSdtpacientedata_pacienteapellidomaterno_Internalname ;
   private String edtavSdtpacientedata_pacientenrodocumento_Internalname ;
   private String edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname ;
   private String edtavSdtpacientedata_pacientetelefono_Internalname ;
   private String edtavSdtpacientedata_pacientecorreo_Internalname ;
   private String edtavSdtcitadata_citaestatura_Internalname ;
   private String edtavSdtcitadata_citapeso_Internalname ;
   private String edtavSdtpacientedata_pacientedireccion_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadprofullname_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname ;
   private String edtavSdtcitadata_citafechareserva_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadfecha_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadhorainicio_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadhorafin_Internalname ;
   private String edtavSdtcitadata_citamotivoconsulta_Internalname ;
   private String edtavSdtcitadata_citacode_Internalname ;
   private String edtavSdtdiagnosticogrids__diagnosticocodigo_Internalname ;
   private String edtavSdtdiagnosticogrids__diagnosticolongdesc_Internalname ;
   private String sGXsfl_166_fel_idx="0001" ;
   private String edtavSdtcitadata_citaantecedentes_Internalname ;
   private String edtavSdtcitadata_citainforme_Internalname ;
   private String subGridsdtdiagnosticogrids_Internalname ;
   private String scmdbuf ;
   private String A95CitaEstado ;
   private String A89CitaEstadoCita ;
   private String AV16EstadoCita ;
   private String bttBtnbtnreprogramarcita_Internalname ;
   private String bttBtnbtnunirsevideollamada_Internalname ;
   private String bttBtnagregardiagnostico_Internalname ;
   private String bttBtnbtnguardar_Internalname ;
   private String bttBtnbtncancelar_Internalname ;
   private String GXv_char3[] ;
   private String tblPanebtns_Internalname ;
   private String TempTags ;
   private String bttBtnbtnguardar_Jsonclick ;
   private String bttBtnbtncancelar_Jsonclick ;
   private String tblPaneldetalles_Internalname ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblTabinfopaciente_title_Internalname ;
   private String lblTabinfopaciente_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String edtavSdtpacientedata_pacientenombres_Jsonclick ;
   private String edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick ;
   private String edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick ;
   private String edtavSdtpacientedata_pacientenrodocumento_Jsonclick ;
   private String edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick ;
   private String edtavSdtpacientedata_pacientetelefono_Jsonclick ;
   private String edtavSdtpacientedata_pacientecorreo_Jsonclick ;
   private String edtavSdtcitadata_citaestatura_Jsonclick ;
   private String edtavSdtcitadata_citapeso_Jsonclick ;
   private String lblTabinfocita_title_Internalname ;
   private String lblTabinfocita_title_Jsonclick ;
   private String divTableinformecita_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadprofullname_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick ;
   private String edtavSdtcitadata_citafechareserva_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadfecha_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadhorainicio_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadhorafin_Jsonclick ;
   private String edtavSdtcitadata_citacode_Jsonclick ;
   private String lblTabdiagnostico_title_Internalname ;
   private String lblTabdiagnostico_title_Jsonclick ;
   private String divTablediagnostico_Internalname ;
   private String bttBtnagregardiagnostico_Jsonclick ;
   private String Dvpanel_paneldiagnostico_Internalname ;
   private String tblPaneldiagnostico_Internalname ;
   private String subGridsdtdiagnosticogrids_Class ;
   private String subGridsdtdiagnosticogrids_Linesclass ;
   private String subGridsdtdiagnosticogrids_Header ;
   private String tblPanelbuttons_Internalname ;
   private String bttBtnbtnregresar_Internalname ;
   private String bttBtnbtnregresar_Jsonclick ;
   private String bttBtnbtnunirsevideollamada_Jsonclick ;
   private String bttBtnbtnregreceta_Internalname ;
   private String bttBtnbtnregreceta_Jsonclick ;
   private String bttBtnbtnreprogramarcita_Jsonclick ;
   private String bttBtnbtnepicrisis_Internalname ;
   private String bttBtnbtnepicrisis_Jsonclick ;
   private String ROClassString ;
   private String edtavDiagnosticoeliminar_Jsonclick ;
   private String edtavSdtdiagnosticogrids__diagnosticocodigo_Jsonclick ;
   private String edtavSdtdiagnosticogrids__diagnosticolongdesc_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_panelbuttons_Autowidth ;
   private boolean Dvpanel_panelbuttons_Autoheight ;
   private boolean Dvpanel_panelbuttons_Collapsible ;
   private boolean Dvpanel_panelbuttons_Collapsed ;
   private boolean Dvpanel_panelbuttons_Showcollapseicon ;
   private boolean Dvpanel_panelbuttons_Autoscroll ;
   private boolean Dvpanel_paneldiagnostico_Autowidth ;
   private boolean Dvpanel_paneldiagnostico_Autoheight ;
   private boolean Dvpanel_paneldiagnostico_Collapsible ;
   private boolean Dvpanel_paneldiagnostico_Collapsed ;
   private boolean Dvpanel_paneldiagnostico_Showcollapseicon ;
   private boolean Dvpanel_paneldiagnostico_Autoscroll ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean Dvpanel_paneldetalles_Autowidth ;
   private boolean Dvpanel_paneldetalles_Autoheight ;
   private boolean Dvpanel_paneldetalles_Collapsible ;
   private boolean Dvpanel_paneldetalles_Collapsed ;
   private boolean Dvpanel_paneldetalles_Showcollapseicon ;
   private boolean Dvpanel_paneldetalles_Autoscroll ;
   private boolean Dvpanel_panebtns_Autowidth ;
   private boolean Dvpanel_panebtns_Autoheight ;
   private boolean Dvpanel_panebtns_Collapsible ;
   private boolean Dvpanel_panebtns_Collapsed ;
   private boolean Dvpanel_panebtns_Showcollapseicon ;
   private boolean Dvpanel_panebtns_Autoscroll ;
   private boolean AV23isSuccess ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_166_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV21isOpenVideoCall ;
   private boolean AV20IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean n95CitaEstado ;
   private boolean n89CitaEstadoCita ;
   private boolean AV22isSaved ;
   private boolean GXv_boolean2[] ;
   private boolean gx_BV166 ;
   private String AV8DiagnosticoCodigo ;
   private String AV9DiagnosticoDescripcion ;
   private String AV12DiagnosticoLongDesc ;
   private String AV32UrlEp ;
   private String AV10DiagnosticoEliminar ;
   private String A64CitaCode ;
   private String AV7CodigoCita ;
   private String AV14Domain ;
   private String AV26RoomName ;
   private String AV15ErrorMessageSaveCita ;
   private com.genexus.webpanels.GXWebGrid GridsdtdiagnosticogridsContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtdiagnosticogridsRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtdiagnosticogridsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelbuttons ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneldetalles ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panebtns ;
   private com.genexus.webpanels.GXUserControl ucMsgdvelop ;
   private com.genexus.webpanels.GXUserControl ucGridsdtdiagnosticogrids_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneldiagnostico ;
   private HTMLChoice cmbavSdtpacientedata_pacientetipodocumento ;
   private HTMLChoice cmbavSdtpacientedata_pacientesexo ;
   private HTMLChoice cmbavSdtcitadata_citaestadocita ;
   private HTMLChoice cmbavSdtcitadata_citatipodiagnostico ;
   private IDataStoreProvider pr_default ;
   private String[] H006I2_A95CitaEstado ;
   private boolean[] H006I2_n95CitaEstado ;
   private int[] H006I2_A19CitaId ;
   private int[] H006I2_A20PacienteId ;
   private String[] H006I2_A89CitaEstadoCita ;
   private boolean[] H006I2_n89CitaEstadoCita ;
   private String[] H006I2_A64CitaCode ;
   private int[] H006I2_A21SGCitaDisponibilidadId ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> AV29SDTDiagnosticoGrids ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> GXt_objcol_SdtSDTDiagnosticoGrid8 ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> GXv_objcol_SdtSDTDiagnosticoGrid9[] ;
   private com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext AV5JitsiJWTContext ;
   private com.hugao.hugaojitsiclient.common.SdtMeetConfig AV24MeetConfig ;
   private com.projectthani.SdtSDTCitaData AV27SDTCitaData ;
   private com.projectthani.SdtSDTCitaData GXt_SdtSDTCitaData4 ;
   private com.projectthani.SdtSDTCitaData GXv_SdtSDTCitaData5[] ;
   private com.projectthani.SdtSDTDiagnosticoGrid AV28SDTDiagnosticoGrid ;
   private com.projectthani.SdtSDTPacienteData AV30SDTPacienteData ;
   private com.projectthani.SdtSDTPacienteData GXt_SdtSDTPacienteData6 ;
   private com.projectthani.SdtSDTPacienteData GXv_SdtSDTPacienteData7[] ;
}

final  class wpdetallecita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006I2", "SELECT TOP 1 [CitaEstado], [CitaId], [PacienteId], [CitaEstadoCita], [CitaCode], [SGCitaDisponibilidadId] FROM [Cita] WHERE ([CitaId] = ?) AND ([CitaEstado] = 'A') ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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

