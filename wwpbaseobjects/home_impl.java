package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class home_impl extends GXDataArea
{
   public home_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public home_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( home_impl.class ));
   }

   public home_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            nRC_GXsfl_147 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_147"))) ;
            nGXsfl_147_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_147_idx"))) ;
            sGXsfl_147_idx = httpContext.GetPar( "sGXsfl_147_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrid_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7SDTNotificationsData);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Width", GXutil.rtrim( Dvpanel_tablecards_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Autowidth", GXutil.booltostr( Dvpanel_tablecards_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Autoheight", GXutil.booltostr( Dvpanel_tablecards_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Cls", GXutil.rtrim( Dvpanel_tablecards_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Title", GXutil.rtrim( Dvpanel_tablecards_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Collapsible", GXutil.booltostr( Dvpanel_tablecards_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Collapsed", GXutil.booltostr( Dvpanel_tablecards_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Showcollapseicon", GXutil.booltostr( Dvpanel_tablecards_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Iconposition", GXutil.rtrim( Dvpanel_tablecards_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Autoscroll", GXutil.booltostr( Dvpanel_tablecards_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Width", GXutil.rtrim( Dvpanel_tablenotifications_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autowidth", GXutil.booltostr( Dvpanel_tablenotifications_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autoheight", GXutil.booltostr( Dvpanel_tablenotifications_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Cls", GXutil.rtrim( Dvpanel_tablenotifications_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Title", GXutil.rtrim( Dvpanel_tablenotifications_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Collapsible", GXutil.booltostr( Dvpanel_tablenotifications_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Collapsed", GXutil.booltostr( Dvpanel_tablenotifications_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Showcollapseicon", GXutil.booltostr( Dvpanel_tablenotifications_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Iconposition", GXutil.rtrim( Dvpanel_tablenotifications_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autoscroll", GXutil.booltostr( Dvpanel_tablenotifications_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHAREA_Height", GXutil.rtrim( Utchartsmootharea_Height));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHAREA_Type", GXutil.rtrim( Utchartsmootharea_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHAREA_Charttype", GXutil.rtrim( Utchartsmootharea_Charttype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR1_Type", GXutil.rtrim( Progressbar1_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR1_Cls", GXutil.rtrim( Progressbar1_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR1_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar1_Percentage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR2_Type", GXutil.rtrim( Progressbar2_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR2_Cls", GXutil.rtrim( Progressbar2_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR2_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar2_Percentage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR3_Type", GXutil.rtrim( Progressbar3_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR3_Cls", GXutil.rtrim( Progressbar3_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR3_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar3_Percentage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR4_Type", GXutil.rtrim( Progressbar4_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR4_Cls", GXutil.rtrim( Progressbar4_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR4_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar4_Percentage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Width", GXutil.rtrim( Dvpanel_tablechart1_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Autowidth", GXutil.booltostr( Dvpanel_tablechart1_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Autoheight", GXutil.booltostr( Dvpanel_tablechart1_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Cls", GXutil.rtrim( Dvpanel_tablechart1_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Title", GXutil.rtrim( Dvpanel_tablechart1_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Collapsible", GXutil.booltostr( Dvpanel_tablechart1_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Collapsed", GXutil.booltostr( Dvpanel_tablechart1_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Showcollapseicon", GXutil.booltostr( Dvpanel_tablechart1_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Iconposition", GXutil.rtrim( Dvpanel_tablechart1_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Autoscroll", GXutil.booltostr( Dvpanel_tablechart1_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Height", GXutil.rtrim( Utchartsmoothline_Height));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Type", GXutil.rtrim( Utchartsmoothline_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Charttype", GXutil.rtrim( Utchartsmoothline_Charttype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Xaxistitle", GXutil.rtrim( Utchartsmoothline_Xaxistitle));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Width", GXutil.rtrim( Dvpanel_tablechart4_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Autowidth", GXutil.booltostr( Dvpanel_tablechart4_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Autoheight", GXutil.booltostr( Dvpanel_tablechart4_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Cls", GXutil.rtrim( Dvpanel_tablechart4_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Title", GXutil.rtrim( Dvpanel_tablechart4_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Collapsible", GXutil.booltostr( Dvpanel_tablechart4_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Collapsed", GXutil.booltostr( Dvpanel_tablechart4_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Showcollapseicon", GXutil.booltostr( Dvpanel_tablechart4_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Iconposition", GXutil.rtrim( Dvpanel_tablechart4_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Autoscroll", GXutil.booltostr( Dvpanel_tablechart4_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Height", GXutil.rtrim( Utchartdoughnut_Height));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Type", GXutil.rtrim( Utchartdoughnut_Type));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Showvalues", GXutil.booltostr( Utchartdoughnut_Showvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Charttype", GXutil.rtrim( Utchartdoughnut_Charttype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Width", GXutil.rtrim( Dvpanel_tablechart3_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Autowidth", GXutil.booltostr( Dvpanel_tablechart3_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Autoheight", GXutil.booltostr( Dvpanel_tablechart3_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Cls", GXutil.rtrim( Dvpanel_tablechart3_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Title", GXutil.rtrim( Dvpanel_tablechart3_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Collapsible", GXutil.booltostr( Dvpanel_tablechart3_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Collapsed", GXutil.booltostr( Dvpanel_tablechart3_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Showcollapseicon", GXutil.booltostr( Dvpanel_tablechart3_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Iconposition", GXutil.rtrim( Dvpanel_tablechart3_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Autoscroll", GXutil.booltostr( Dvpanel_tablechart3_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.wwpbaseobjects.workwithplusmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa072( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start072( ) ;
      }
      return gxajaxcallmode ;
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
      httpContext.writeValue( Form.getCaption()) ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033119", false, true);
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
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/echarts.min.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/extension/bmap.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-3d.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-more.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/funnel.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/solid-gauge.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/oatPivot/gxpivotjs.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/echarts.min.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/extension/bmap.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-3d.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-more.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/funnel.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/solid-gauge.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/oatPivot/gxpivotjs.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/echarts.min.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/extension/bmap.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-3d.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-more.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/funnel.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/solid-gauge.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/oatPivot/gxpivotjs.js", "", false, true);
      httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.home", new String[] {}, new String[] {}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTNOTIFICATIONSDATA", getSecureSignedToken( "", AV7SDTNotificationsData));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtnotificationsdata", AV7SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtnotificationsdata", AV7SDTNotificationsData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtnotificationsdata", getSecureSignedToken( "", AV7SDTNotificationsData));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_147", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_147, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vELEMENTS", AV28Elements);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vELEMENTS", AV28Elements);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPARAMETERS", AV29Parameters);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPARAMETERS", AV29Parameters);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMCLICKDATA", AV30ItemClickData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMCLICKDATA", AV30ItemClickData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMDOUBLECLICKDATA", AV31ItemDoubleClickData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMDOUBLECLICKDATA", AV31ItemDoubleClickData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDRAGANDDROPDATA", AV32DragAndDropData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDRAGANDDROPDATA", AV32DragAndDropData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFILTERCHANGEDDATA", AV33FilterChangedData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFILTERCHANGEDDATA", AV33FilterChangedData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMEXPANDDATA", AV34ItemExpandData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMEXPANDDATA", AV34ItemExpandData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vITEMCOLLAPSEDATA", AV35ItemCollapseData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vITEMCOLLAPSEDATA", AV35ItemCollapseData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTNOTIFICATIONSDATA", getSecureSignedToken( "", AV7SDTNotificationsData));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Width", GXutil.rtrim( Dvpanel_tablecards_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Autowidth", GXutil.booltostr( Dvpanel_tablecards_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Autoheight", GXutil.booltostr( Dvpanel_tablecards_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Cls", GXutil.rtrim( Dvpanel_tablecards_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Title", GXutil.rtrim( Dvpanel_tablecards_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Collapsible", GXutil.booltostr( Dvpanel_tablecards_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Collapsed", GXutil.booltostr( Dvpanel_tablecards_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Showcollapseicon", GXutil.booltostr( Dvpanel_tablecards_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Iconposition", GXutil.rtrim( Dvpanel_tablecards_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECARDS_Autoscroll", GXutil.booltostr( Dvpanel_tablecards_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Width", GXutil.rtrim( Dvpanel_tablenotifications_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autowidth", GXutil.booltostr( Dvpanel_tablenotifications_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autoheight", GXutil.booltostr( Dvpanel_tablenotifications_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Cls", GXutil.rtrim( Dvpanel_tablenotifications_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Title", GXutil.rtrim( Dvpanel_tablenotifications_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Collapsible", GXutil.booltostr( Dvpanel_tablenotifications_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Collapsed", GXutil.booltostr( Dvpanel_tablenotifications_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Showcollapseicon", GXutil.booltostr( Dvpanel_tablenotifications_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Iconposition", GXutil.rtrim( Dvpanel_tablenotifications_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLENOTIFICATIONS_Autoscroll", GXutil.booltostr( Dvpanel_tablenotifications_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHAREA_Height", GXutil.rtrim( Utchartsmootharea_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHAREA_Type", GXutil.rtrim( Utchartsmootharea_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHAREA_Charttype", GXutil.rtrim( Utchartsmootharea_Charttype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR1_Type", GXutil.rtrim( Progressbar1_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR1_Cls", GXutil.rtrim( Progressbar1_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR1_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar1_Percentage, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR2_Type", GXutil.rtrim( Progressbar2_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR2_Cls", GXutil.rtrim( Progressbar2_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR2_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar2_Percentage, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR3_Type", GXutil.rtrim( Progressbar3_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR3_Cls", GXutil.rtrim( Progressbar3_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR3_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar3_Percentage, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR4_Type", GXutil.rtrim( Progressbar4_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR4_Cls", GXutil.rtrim( Progressbar4_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROGRESSBAR4_Percentage", GXutil.ltrim( localUtil.ntoc( Progressbar4_Percentage, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Width", GXutil.rtrim( Dvpanel_tablechart1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Autowidth", GXutil.booltostr( Dvpanel_tablechart1_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Autoheight", GXutil.booltostr( Dvpanel_tablechart1_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Cls", GXutil.rtrim( Dvpanel_tablechart1_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Title", GXutil.rtrim( Dvpanel_tablechart1_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Collapsible", GXutil.booltostr( Dvpanel_tablechart1_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Collapsed", GXutil.booltostr( Dvpanel_tablechart1_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Showcollapseicon", GXutil.booltostr( Dvpanel_tablechart1_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Iconposition", GXutil.rtrim( Dvpanel_tablechart1_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART1_Autoscroll", GXutil.booltostr( Dvpanel_tablechart1_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Height", GXutil.rtrim( Utchartsmoothline_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Type", GXutil.rtrim( Utchartsmoothline_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Charttype", GXutil.rtrim( Utchartsmoothline_Charttype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTSMOOTHLINE_Xaxistitle", GXutil.rtrim( Utchartsmoothline_Xaxistitle));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Width", GXutil.rtrim( Dvpanel_tablechart4_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Autowidth", GXutil.booltostr( Dvpanel_tablechart4_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Autoheight", GXutil.booltostr( Dvpanel_tablechart4_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Cls", GXutil.rtrim( Dvpanel_tablechart4_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Title", GXutil.rtrim( Dvpanel_tablechart4_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Collapsible", GXutil.booltostr( Dvpanel_tablechart4_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Collapsed", GXutil.booltostr( Dvpanel_tablechart4_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Showcollapseicon", GXutil.booltostr( Dvpanel_tablechart4_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Iconposition", GXutil.rtrim( Dvpanel_tablechart4_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART4_Autoscroll", GXutil.booltostr( Dvpanel_tablechart4_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Height", GXutil.rtrim( Utchartdoughnut_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Type", GXutil.rtrim( Utchartdoughnut_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Showvalues", GXutil.booltostr( Utchartdoughnut_Showvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UTCHARTDOUGHNUT_Charttype", GXutil.rtrim( Utchartdoughnut_Charttype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Width", GXutil.rtrim( Dvpanel_tablechart3_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Autowidth", GXutil.booltostr( Dvpanel_tablechart3_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Autoheight", GXutil.booltostr( Dvpanel_tablechart3_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Cls", GXutil.rtrim( Dvpanel_tablechart3_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Title", GXutil.rtrim( Dvpanel_tablechart3_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Collapsible", GXutil.booltostr( Dvpanel_tablechart3_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Collapsed", GXutil.booltostr( Dvpanel_tablechart3_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Showcollapseicon", GXutil.booltostr( Dvpanel_tablechart3_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Iconposition", GXutil.rtrim( Dvpanel_tablechart3_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLECHART3_Autoscroll", GXutil.booltostr( Dvpanel_tablechart3_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
   }

   public void renderHtmlCloseForm( )
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we072( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt072( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.projectthani.wwpbaseobjects.home", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Home" ;
   }

   public String getPgmdesc( )
   {
      return "Inicio" ;
   }

   public void wb070( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablecards.setProperty("Width", Dvpanel_tablecards_Width);
         ucDvpanel_tablecards.setProperty("AutoWidth", Dvpanel_tablecards_Autowidth);
         ucDvpanel_tablecards.setProperty("AutoHeight", Dvpanel_tablecards_Autoheight);
         ucDvpanel_tablecards.setProperty("Cls", Dvpanel_tablecards_Cls);
         ucDvpanel_tablecards.setProperty("Title", Dvpanel_tablecards_Title);
         ucDvpanel_tablecards.setProperty("Collapsible", Dvpanel_tablecards_Collapsible);
         ucDvpanel_tablecards.setProperty("Collapsed", Dvpanel_tablecards_Collapsed);
         ucDvpanel_tablecards.setProperty("ShowCollapseIcon", Dvpanel_tablecards_Showcollapseicon);
         ucDvpanel_tablecards.setProperty("IconPosition", Dvpanel_tablecards_Iconposition);
         ucDvpanel_tablecards.setProperty("AutoScroll", Dvpanel_tablecards_Autoscroll);
         ucDvpanel_tablecards.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablecards_Internalname, "DVPANEL_TABLECARDSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLECARDSContainer"+"TableCards"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecards_Internalname, 1, 0, "px", 0, "px", "PanelCardContainer", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard1_Internalname, 1, 0, "px", 0, "px", "TableCardNumber", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table1_16_072( true) ;
      }
      else
      {
         wb_table1_16_072( false) ;
      }
      return  ;
   }

   public void wb_table1_16_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecard1_Internalname, "Value Card1", "col-sm-3 DashboardNumberCardNoBorderLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecard1_Internalname, GXutil.ltrim( localUtil.ntoc( AV8ValueCard1, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecard1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV8ValueCard1), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV8ValueCard1), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecard1_Jsonclick, 0, "DashboardNumberCardNoBorder", "", "", "", "", 1, edtavValuecard1_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table2_28_072( true) ;
      }
      else
      {
         wb_table2_28_072( false) ;
      }
      return  ;
   }

   public void wb_table2_28_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard2_Internalname, 1, 0, "px", 0, "px", "TableCardNumber", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table3_41_072( true) ;
      }
      else
      {
         wb_table3_41_072( false) ;
      }
      return  ;
   }

   public void wb_table3_41_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecard2_Internalname, "Value Card2", "col-sm-3 DashboardNumberCardNoBorderLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecard2_Internalname, GXutil.ltrim( localUtil.ntoc( AV9ValueCard2, (byte)(11), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecard2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV9ValueCard2), "$ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV9ValueCard2), "$ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecard2_Jsonclick, 0, "DashboardNumberCardNoBorder", "", "", "", "", 1, edtavValuecard2_Enabled, 0, "text", "", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPIPrice", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table4_53_072( true) ;
      }
      else
      {
         wb_table4_53_072( false) ;
      }
      return  ;
   }

   public void wb_table4_53_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard3_Internalname, 1, 0, "px", 0, "px", "TableCardNumber", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table5_66_072( true) ;
      }
      else
      {
         wb_table5_66_072( false) ;
      }
      return  ;
   }

   public void wb_table5_66_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecard3_Internalname, "Value Card3", "col-sm-3 DashboardNumberCardNoBorderLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecard3_Internalname, AV10ValueCard3, GXutil.rtrim( localUtil.format( AV10ValueCard3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,75);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecard3_Jsonclick, 0, "DashboardNumberCardNoBorder", "", "", "", "", 1, edtavValuecard3_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "KPIVarchar", "left", true, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table6_78_072( true) ;
      }
      else
      {
         wb_table6_78_072( false) ;
      }
      return  ;
   }

   public void wb_table6_78_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard4_Internalname, 1, 0, "px", 0, "px", "TableCardNumber", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table7_91_072( true) ;
      }
      else
      {
         wb_table7_91_072( false) ;
      }
      return  ;
   }

   public void wb_table7_91_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecard4_Internalname, "Value Card4", "col-sm-3 DashboardNumberCardNoBorderLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecard4_Internalname, GXutil.ltrim( localUtil.ntoc( AV11ValueCard4, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecard4_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV11ValueCard4), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV11ValueCard4), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,100);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecard4_Jsonclick, 0, "DashboardNumberCardNoBorder", "", "", "", "", 1, edtavValuecard4_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table8_103_072( true) ;
      }
      else
      {
         wb_table8_103_072( false) ;
      }
      return  ;
   }

   public void wb_table8_103_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard5_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table9_116_072( true) ;
      }
      else
      {
         wb_table9_116_072( false) ;
      }
      return  ;
   }

   public void wb_table9_116_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecard5_Internalname, "Value Card5", "col-sm-3 DashboardNumberCardNoBorderLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecard5_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ValueCard5, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecard5_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ValueCard5), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ValueCard5), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,125);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecard5_Jsonclick, 0, "DashboardNumberCardNoBorder", "", "", "", "", 1, edtavValuecard5_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         wb_table10_128_072( true) ;
      }
      else
      {
         wb_table10_128_072( false) ;
      }
      return  ;
   }

   public void wb_table10_128_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-md-5 col-lg-4 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablenotifications.setProperty("Width", Dvpanel_tablenotifications_Width);
         ucDvpanel_tablenotifications.setProperty("AutoWidth", Dvpanel_tablenotifications_Autowidth);
         ucDvpanel_tablenotifications.setProperty("AutoHeight", Dvpanel_tablenotifications_Autoheight);
         ucDvpanel_tablenotifications.setProperty("Cls", Dvpanel_tablenotifications_Cls);
         ucDvpanel_tablenotifications.setProperty("Title", Dvpanel_tablenotifications_Title);
         ucDvpanel_tablenotifications.setProperty("Collapsible", Dvpanel_tablenotifications_Collapsible);
         ucDvpanel_tablenotifications.setProperty("Collapsed", Dvpanel_tablenotifications_Collapsed);
         ucDvpanel_tablenotifications.setProperty("ShowCollapseIcon", Dvpanel_tablenotifications_Showcollapseicon);
         ucDvpanel_tablenotifications.setProperty("IconPosition", Dvpanel_tablenotifications_Iconposition);
         ucDvpanel_tablenotifications.setProperty("AutoScroll", Dvpanel_tablenotifications_Autoscroll);
         ucDvpanel_tablenotifications.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablenotifications_Internalname, "DVPANEL_TABLENOTIFICATIONSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLENOTIFICATIONSContainer"+"TableNotifications"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablenotifications_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 NotificationSubtitleCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblNotificationssubtitle_Internalname, lblNotificationssubtitle_Caption, "", "", lblNotificationssubtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 GridNoBorderNoHeader CellMarginTop HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"147\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGrid_Backcolorstyle == 0 )
            {
               subGrid_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
            else
            {
               subGrid_Titlebackstyle = (byte)(1) ;
               if ( subGrid_Backcolorstyle == 1 )
               {
                  subGrid_Titlebackcolor = subGrid_Allbackcolor ;
                  if ( GXutil.len( subGrid_Class) > 0 )
                  {
                     subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGrid_Class) > 0 )
                  {
                     subGrid_Linesclass = subGrid_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Notification Icon Class") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Notification Title") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeSecondary"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Notification Datetime") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridContainer.AddObjectProperty("GridName", "Grid");
         }
         else
         {
            GridContainer.AddObjectProperty("GridName", "Grid");
            GridContainer.AddObjectProperty("Header", subGrid_Header);
            GridContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
            GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("CmpContext", "");
            GridContainer.AddObjectProperty("InMasterPage", "false");
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", AV6NotificationIcon);
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavNotificationicon_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavNotificationicon_Format, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationiconclass_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationtitle_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationdatetime_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 147 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_147 = (int)(nGXsfl_147_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            AV42GXV1 = nGXsfl_147_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-md-7 col-lg-8 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablechart1.setProperty("Width", Dvpanel_tablechart1_Width);
         ucDvpanel_tablechart1.setProperty("AutoWidth", Dvpanel_tablechart1_Autowidth);
         ucDvpanel_tablechart1.setProperty("AutoHeight", Dvpanel_tablechart1_Autoheight);
         ucDvpanel_tablechart1.setProperty("Cls", Dvpanel_tablechart1_Cls);
         ucDvpanel_tablechart1.setProperty("Title", Dvpanel_tablechart1_Title);
         ucDvpanel_tablechart1.setProperty("Collapsible", Dvpanel_tablechart1_Collapsible);
         ucDvpanel_tablechart1.setProperty("Collapsed", Dvpanel_tablechart1_Collapsed);
         ucDvpanel_tablechart1.setProperty("ShowCollapseIcon", Dvpanel_tablechart1_Showcollapseicon);
         ucDvpanel_tablechart1.setProperty("IconPosition", Dvpanel_tablechart1_Iconposition);
         ucDvpanel_tablechart1.setProperty("AutoScroll", Dvpanel_tablechart1_Autoscroll);
         ucDvpanel_tablechart1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablechart1_Internalname, "DVPANEL_TABLECHART1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLECHART1Container"+"TableChart1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablechart1_Internalname, 1, 0, "px", divTablechart1_Height, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-7", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablereport_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCharttitle_Internalname, "Sales: Last Month", "", "", lblCharttitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SimpleCardTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartsmootharea.setProperty("Elements", AV28Elements);
         ucUtchartsmootharea.setProperty("Parameters", AV29Parameters);
         ucUtchartsmootharea.setProperty("Height", Utchartsmootharea_Height);
         ucUtchartsmootharea.setProperty("Type", Utchartsmootharea_Type);
         ucUtchartsmootharea.setProperty("Title", Utchartsmootharea_Title);
         ucUtchartsmootharea.setProperty("ChartType", Utchartsmootharea_Charttype);
         ucUtchartsmootharea.setProperty("ItemClickData", AV30ItemClickData);
         ucUtchartsmootharea.setProperty("ItemDoubleClickData", AV31ItemDoubleClickData);
         ucUtchartsmootharea.setProperty("DragAndDropData", AV32DragAndDropData);
         ucUtchartsmootharea.setProperty("FilterChangedData", AV33FilterChangedData);
         ucUtchartsmootharea.setProperty("ItemExpandData", AV34ItemExpandData);
         ucUtchartsmootharea.setProperty("ItemCollapseData", AV35ItemCollapseData);
         ucUtchartsmootharea.render(context, "queryviewer", Utchartsmootharea_Internalname, "UTCHARTSMOOTHAREAContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-5 CellPaddingRight30", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablereportgoals_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIndicatorstitle_Internalname, "Goal Completion", "", "", lblIndicatorstitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SimpleCardTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop30", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabletitle1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptionprogressbar1_Internalname, "Added Products", "", "", lblDescriptionprogressbar1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table11_176_072( true) ;
      }
      else
      {
         wb_table11_176_072( false) ;
      }
      return  ;
   }

   public void wb_table11_176_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucProgressbar1.setProperty("Type", Progressbar1_Type);
         ucProgressbar1.setProperty("Caption", Progressbar1_Caption);
         ucProgressbar1.setProperty("Cls", Progressbar1_Cls);
         ucProgressbar1.setProperty("Percentage", Progressbar1_Percentage);
         ucProgressbar1.render(context, "dvelop.gxbootstrap.dvprogressindicator", Progressbar1_Internalname, "PROGRESSBAR1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabletitle2_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptionprogressbar2_Internalname, "Complete Purchase", "", "", lblDescriptionprogressbar2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table12_195_072( true) ;
      }
      else
      {
         wb_table12_195_072( false) ;
      }
      return  ;
   }

   public void wb_table12_195_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucProgressbar2.setProperty("Type", Progressbar2_Type);
         ucProgressbar2.setProperty("Caption", Progressbar2_Caption);
         ucProgressbar2.setProperty("Cls", Progressbar2_Cls);
         ucProgressbar2.setProperty("Percentage", Progressbar2_Percentage);
         ucProgressbar2.render(context, "dvelop.gxbootstrap.dvprogressindicator", Progressbar2_Internalname, "PROGRESSBAR2Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabletitle3_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptionprogressbar3_Internalname, "Like to Page", "", "", lblDescriptionprogressbar3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table13_214_072( true) ;
      }
      else
      {
         wb_table13_214_072( false) ;
      }
      return  ;
   }

   public void wb_table13_214_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucProgressbar3.setProperty("Type", Progressbar3_Type);
         ucProgressbar3.setProperty("Caption", Progressbar3_Caption);
         ucProgressbar3.setProperty("Cls", Progressbar3_Cls);
         ucProgressbar3.setProperty("Percentage", Progressbar3_Percentage);
         ucProgressbar3.render(context, "dvelop.gxbootstrap.dvprogressindicator", Progressbar3_Internalname, "PROGRESSBAR3Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabletitle4_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptionprogressbar4_Internalname, "Contact us", "", "", lblDescriptionprogressbar4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table14_233_072( true) ;
      }
      else
      {
         wb_table14_233_072( false) ;
      }
      return  ;
   }

   public void wb_table14_233_072e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucProgressbar4.setProperty("Type", Progressbar4_Type);
         ucProgressbar4.setProperty("Caption", Progressbar4_Caption);
         ucProgressbar4.setProperty("Cls", Progressbar4_Cls);
         ucProgressbar4.setProperty("Percentage", Progressbar4_Percentage);
         ucProgressbar4.render(context, "dvelop.gxbootstrap.dvprogressindicator", Progressbar4_Internalname, "PROGRESSBAR4Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-md-7 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablechart4.setProperty("Width", Dvpanel_tablechart4_Width);
         ucDvpanel_tablechart4.setProperty("AutoWidth", Dvpanel_tablechart4_Autowidth);
         ucDvpanel_tablechart4.setProperty("AutoHeight", Dvpanel_tablechart4_Autoheight);
         ucDvpanel_tablechart4.setProperty("Cls", Dvpanel_tablechart4_Cls);
         ucDvpanel_tablechart4.setProperty("Title", Dvpanel_tablechart4_Title);
         ucDvpanel_tablechart4.setProperty("Collapsible", Dvpanel_tablechart4_Collapsible);
         ucDvpanel_tablechart4.setProperty("Collapsed", Dvpanel_tablechart4_Collapsed);
         ucDvpanel_tablechart4.setProperty("ShowCollapseIcon", Dvpanel_tablechart4_Showcollapseicon);
         ucDvpanel_tablechart4.setProperty("IconPosition", Dvpanel_tablechart4_Iconposition);
         ucDvpanel_tablechart4.setProperty("AutoScroll", Dvpanel_tablechart4_Autoscroll);
         ucDvpanel_tablechart4.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablechart4_Internalname, "DVPANEL_TABLECHART4Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLECHART4Container"+"TableChart4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablechart4_Internalname, 1, 0, "px", divTablechart4_Height, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartsmoothline.setProperty("Elements", AV28Elements);
         ucUtchartsmoothline.setProperty("Parameters", AV29Parameters);
         ucUtchartsmoothline.setProperty("Height", Utchartsmoothline_Height);
         ucUtchartsmoothline.setProperty("Type", Utchartsmoothline_Type);
         ucUtchartsmoothline.setProperty("Title", Utchartsmoothline_Title);
         ucUtchartsmoothline.setProperty("ChartType", Utchartsmoothline_Charttype);
         ucUtchartsmoothline.setProperty("XAxisTitle", Utchartsmoothline_Xaxistitle);
         ucUtchartsmoothline.setProperty("ItemClickData", AV30ItemClickData);
         ucUtchartsmoothline.setProperty("ItemDoubleClickData", AV31ItemDoubleClickData);
         ucUtchartsmoothline.setProperty("DragAndDropData", AV32DragAndDropData);
         ucUtchartsmoothline.setProperty("FilterChangedData", AV33FilterChangedData);
         ucUtchartsmoothline.setProperty("ItemExpandData", AV34ItemExpandData);
         ucUtchartsmoothline.setProperty("ItemCollapseData", AV35ItemCollapseData);
         ucUtchartsmoothline.render(context, "queryviewer", Utchartsmoothline_Internalname, "UTCHARTSMOOTHLINEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-md-5 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablechart3.setProperty("Width", Dvpanel_tablechart3_Width);
         ucDvpanel_tablechart3.setProperty("AutoWidth", Dvpanel_tablechart3_Autowidth);
         ucDvpanel_tablechart3.setProperty("AutoHeight", Dvpanel_tablechart3_Autoheight);
         ucDvpanel_tablechart3.setProperty("Cls", Dvpanel_tablechart3_Cls);
         ucDvpanel_tablechart3.setProperty("Title", Dvpanel_tablechart3_Title);
         ucDvpanel_tablechart3.setProperty("Collapsible", Dvpanel_tablechart3_Collapsible);
         ucDvpanel_tablechart3.setProperty("Collapsed", Dvpanel_tablechart3_Collapsed);
         ucDvpanel_tablechart3.setProperty("ShowCollapseIcon", Dvpanel_tablechart3_Showcollapseicon);
         ucDvpanel_tablechart3.setProperty("IconPosition", Dvpanel_tablechart3_Iconposition);
         ucDvpanel_tablechart3.setProperty("AutoScroll", Dvpanel_tablechart3_Autoscroll);
         ucDvpanel_tablechart3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablechart3_Internalname, "DVPANEL_TABLECHART3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLECHART3Container"+"TableChart3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablechart3_Internalname, 1, 0, "px", divTablechart3_Height, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUtchartdoughnut.setProperty("Elements", AV28Elements);
         ucUtchartdoughnut.setProperty("Parameters", AV29Parameters);
         ucUtchartdoughnut.setProperty("Height", Utchartdoughnut_Height);
         ucUtchartdoughnut.setProperty("Type", Utchartdoughnut_Type);
         ucUtchartdoughnut.setProperty("Title", Utchartdoughnut_Title);
         ucUtchartdoughnut.setProperty("ShowValues", Utchartdoughnut_Showvalues);
         ucUtchartdoughnut.setProperty("ChartType", Utchartdoughnut_Charttype);
         ucUtchartdoughnut.setProperty("ItemClickData", AV30ItemClickData);
         ucUtchartdoughnut.setProperty("ItemDoubleClickData", AV31ItemDoubleClickData);
         ucUtchartdoughnut.setProperty("DragAndDropData", AV32DragAndDropData);
         ucUtchartdoughnut.setProperty("FilterChangedData", AV33FilterChangedData);
         ucUtchartdoughnut.setProperty("ItemExpandData", AV34ItemExpandData);
         ucUtchartdoughnut.setProperty("ItemCollapseData", AV35ItemCollapseData);
         ucUtchartdoughnut.render(context, "queryviewer", Utchartdoughnut_Internalname, "UTCHARTDOUGHNUTContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 147 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               AV42GXV1 = nGXsfl_147_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start072( )
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
         Form.getMeta().addItem("description", "Inicio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup070( ) ;
   }

   public void ws072( )
   {
      start072( ) ;
      evt072( ) ;
   }

   public void evt072( )
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
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_147_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_147_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_147_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1472( ) ;
                           AV42GXV1 = (int)(nGXsfl_147_idx+GRID_nFirstRecordOnPage) ;
                           if ( ( AV7SDTNotificationsData.size() >= AV42GXV1 ) && ( AV42GXV1 > 0 ) )
                           {
                              AV7SDTNotificationsData.currentItem( ((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)) );
                              AV6NotificationIcon = httpContext.cgiGet( edtavNotificationicon_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavNotificationicon_Internalname, AV6NotificationIcon);
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
                                 e11072 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12072 ();
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
   }

   public void we072( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa072( )
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
            GX_FocusControl = edtavValuecard1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1472( ) ;
      while ( nGXsfl_147_idx <= nRC_GXsfl_147 )
      {
         sendrow_1472( ) ;
         nGXsfl_147_idx = ((subGrid_Islastpage==1)&&(nGXsfl_147_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_147_idx+1) ;
         sGXsfl_147_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_147_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1472( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> AV7SDTNotificationsData )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID_nCurrentRecord = 0 ;
      rf072( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf072( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavValuecard1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard1_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue1_Enabled), 5, 0), true);
      edtavValuecard2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard2_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue2_Enabled), 5, 0), true);
      edtavValuecard3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard3_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue3_Enabled), 5, 0), true);
      edtavValuecard4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard4_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue4_Enabled), 5, 0), true);
      edtavValuecard5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard5_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue5_Enabled), 5, 0), true);
      edtavNotificationicon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNotificationicon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNotificationicon_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationiconclass_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationiconclass_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationtitle_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationdatetime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdatetime_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavValueprogressbar1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar1_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar1_Enabled), 5, 0), true);
      edtavValueprogressbar2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar2_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar2_Enabled), 5, 0), true);
      edtavValueprogressbar3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar3_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar3_Enabled), 5, 0), true);
      edtavValueprogressbar4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar4_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar4_Enabled), 5, 0), true);
   }

   public void rf072( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(147) ;
      nGXsfl_147_idx = 1 ;
      sGXsfl_147_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_147_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1472( ) ;
      bGXsfl_147_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1472( ) ;
         e12072 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_147_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e12072 ();
         }
         wbEnd = (short)(147) ;
         wb070( ) ;
      }
      bGXsfl_147_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes072( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTNOTIFICATIONSDATA", AV7SDTNotificationsData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTNOTIFICATIONSDATA", getSecureSignedToken( "", AV7SDTNotificationsData));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      return AV7SDTNotificationsData.size() ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7SDTNotificationsData) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavValuecard1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard1_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue1_Enabled), 5, 0), true);
      edtavValuecard2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard2_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue2_Enabled), 5, 0), true);
      edtavValuecard3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard3_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue3_Enabled), 5, 0), true);
      edtavValuecard4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard4_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue4_Enabled), 5, 0), true);
      edtavValuecard5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecard5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecard5_Enabled), 5, 0), true);
      edtavNumbersecondaryvalue5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNumbersecondaryvalue5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNumbersecondaryvalue5_Enabled), 5, 0), true);
      edtavNotificationicon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNotificationicon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNotificationicon_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationiconclass_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationiconclass_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationtitle_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtnotificationsdata__notificationdatetime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdatetime_Enabled), 5, 0), !bGXsfl_147_Refreshing);
      edtavValueprogressbar1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar1_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar1_Enabled), 5, 0), true);
      edtavValueprogressbar2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar2_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar2_Enabled), 5, 0), true);
      edtavValueprogressbar3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar3_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar3_Enabled), 5, 0), true);
      edtavValueprogressbar4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValueprogressbar4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValueprogressbar4_Enabled), 5, 0), true);
      edtavTotalvalueprogressbar4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotalvalueprogressbar4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotalvalueprogressbar4_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup070( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11072 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtnotificationsdata"), AV7SDTNotificationsData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vELEMENTS"), AV28Elements);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPARAMETERS"), AV29Parameters);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMCLICKDATA"), AV30ItemClickData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMDOUBLECLICKDATA"), AV31ItemDoubleClickData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDRAGANDDROPDATA"), AV32DragAndDropData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFILTERCHANGEDDATA"), AV33FilterChangedData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMEXPANDDATA"), AV34ItemExpandData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vITEMCOLLAPSEDATA"), AV35ItemCollapseData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTNOTIFICATIONSDATA"), AV7SDTNotificationsData);
         /* Read saved values. */
         nRC_GXsfl_147 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_147"), ",", ".")) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_tablecards_Width = httpContext.cgiGet( "DVPANEL_TABLECARDS_Width") ;
         Dvpanel_tablecards_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECARDS_Autowidth")) ;
         Dvpanel_tablecards_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECARDS_Autoheight")) ;
         Dvpanel_tablecards_Cls = httpContext.cgiGet( "DVPANEL_TABLECARDS_Cls") ;
         Dvpanel_tablecards_Title = httpContext.cgiGet( "DVPANEL_TABLECARDS_Title") ;
         Dvpanel_tablecards_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECARDS_Collapsible")) ;
         Dvpanel_tablecards_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECARDS_Collapsed")) ;
         Dvpanel_tablecards_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECARDS_Showcollapseicon")) ;
         Dvpanel_tablecards_Iconposition = httpContext.cgiGet( "DVPANEL_TABLECARDS_Iconposition") ;
         Dvpanel_tablecards_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECARDS_Autoscroll")) ;
         Dvpanel_tablenotifications_Width = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Width") ;
         Dvpanel_tablenotifications_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Autowidth")) ;
         Dvpanel_tablenotifications_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Autoheight")) ;
         Dvpanel_tablenotifications_Cls = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Cls") ;
         Dvpanel_tablenotifications_Title = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Title") ;
         Dvpanel_tablenotifications_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Collapsible")) ;
         Dvpanel_tablenotifications_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Collapsed")) ;
         Dvpanel_tablenotifications_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Showcollapseicon")) ;
         Dvpanel_tablenotifications_Iconposition = httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Iconposition") ;
         Dvpanel_tablenotifications_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLENOTIFICATIONS_Autoscroll")) ;
         Utchartsmootharea_Height = httpContext.cgiGet( "UTCHARTSMOOTHAREA_Height") ;
         Utchartsmootharea_Type = httpContext.cgiGet( "UTCHARTSMOOTHAREA_Type") ;
         Utchartsmootharea_Charttype = httpContext.cgiGet( "UTCHARTSMOOTHAREA_Charttype") ;
         Progressbar1_Type = httpContext.cgiGet( "PROGRESSBAR1_Type") ;
         Progressbar1_Cls = httpContext.cgiGet( "PROGRESSBAR1_Cls") ;
         Progressbar1_Percentage = (int)(localUtil.ctol( httpContext.cgiGet( "PROGRESSBAR1_Percentage"), ",", ".")) ;
         Progressbar2_Type = httpContext.cgiGet( "PROGRESSBAR2_Type") ;
         Progressbar2_Cls = httpContext.cgiGet( "PROGRESSBAR2_Cls") ;
         Progressbar2_Percentage = (int)(localUtil.ctol( httpContext.cgiGet( "PROGRESSBAR2_Percentage"), ",", ".")) ;
         Progressbar3_Type = httpContext.cgiGet( "PROGRESSBAR3_Type") ;
         Progressbar3_Cls = httpContext.cgiGet( "PROGRESSBAR3_Cls") ;
         Progressbar3_Percentage = (int)(localUtil.ctol( httpContext.cgiGet( "PROGRESSBAR3_Percentage"), ",", ".")) ;
         Progressbar4_Type = httpContext.cgiGet( "PROGRESSBAR4_Type") ;
         Progressbar4_Cls = httpContext.cgiGet( "PROGRESSBAR4_Cls") ;
         Progressbar4_Percentage = (int)(localUtil.ctol( httpContext.cgiGet( "PROGRESSBAR4_Percentage"), ",", ".")) ;
         Dvpanel_tablechart1_Width = httpContext.cgiGet( "DVPANEL_TABLECHART1_Width") ;
         Dvpanel_tablechart1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART1_Autowidth")) ;
         Dvpanel_tablechart1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART1_Autoheight")) ;
         Dvpanel_tablechart1_Cls = httpContext.cgiGet( "DVPANEL_TABLECHART1_Cls") ;
         Dvpanel_tablechart1_Title = httpContext.cgiGet( "DVPANEL_TABLECHART1_Title") ;
         Dvpanel_tablechart1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART1_Collapsible")) ;
         Dvpanel_tablechart1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART1_Collapsed")) ;
         Dvpanel_tablechart1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART1_Showcollapseicon")) ;
         Dvpanel_tablechart1_Iconposition = httpContext.cgiGet( "DVPANEL_TABLECHART1_Iconposition") ;
         Dvpanel_tablechart1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART1_Autoscroll")) ;
         Utchartsmoothline_Height = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Height") ;
         Utchartsmoothline_Type = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Type") ;
         Utchartsmoothline_Charttype = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Charttype") ;
         Utchartsmoothline_Xaxistitle = httpContext.cgiGet( "UTCHARTSMOOTHLINE_Xaxistitle") ;
         Dvpanel_tablechart4_Width = httpContext.cgiGet( "DVPANEL_TABLECHART4_Width") ;
         Dvpanel_tablechart4_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART4_Autowidth")) ;
         Dvpanel_tablechart4_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART4_Autoheight")) ;
         Dvpanel_tablechart4_Cls = httpContext.cgiGet( "DVPANEL_TABLECHART4_Cls") ;
         Dvpanel_tablechart4_Title = httpContext.cgiGet( "DVPANEL_TABLECHART4_Title") ;
         Dvpanel_tablechart4_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART4_Collapsible")) ;
         Dvpanel_tablechart4_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART4_Collapsed")) ;
         Dvpanel_tablechart4_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART4_Showcollapseicon")) ;
         Dvpanel_tablechart4_Iconposition = httpContext.cgiGet( "DVPANEL_TABLECHART4_Iconposition") ;
         Dvpanel_tablechart4_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART4_Autoscroll")) ;
         Utchartdoughnut_Height = httpContext.cgiGet( "UTCHARTDOUGHNUT_Height") ;
         Utchartdoughnut_Type = httpContext.cgiGet( "UTCHARTDOUGHNUT_Type") ;
         Utchartdoughnut_Showvalues = GXutil.strtobool( httpContext.cgiGet( "UTCHARTDOUGHNUT_Showvalues")) ;
         Utchartdoughnut_Charttype = httpContext.cgiGet( "UTCHARTDOUGHNUT_Charttype") ;
         Dvpanel_tablechart3_Width = httpContext.cgiGet( "DVPANEL_TABLECHART3_Width") ;
         Dvpanel_tablechart3_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART3_Autowidth")) ;
         Dvpanel_tablechart3_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART3_Autoheight")) ;
         Dvpanel_tablechart3_Cls = httpContext.cgiGet( "DVPANEL_TABLECHART3_Cls") ;
         Dvpanel_tablechart3_Title = httpContext.cgiGet( "DVPANEL_TABLECHART3_Title") ;
         Dvpanel_tablechart3_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART3_Collapsible")) ;
         Dvpanel_tablechart3_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART3_Collapsed")) ;
         Dvpanel_tablechart3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART3_Showcollapseicon")) ;
         Dvpanel_tablechart3_Iconposition = httpContext.cgiGet( "DVPANEL_TABLECHART3_Iconposition") ;
         Dvpanel_tablechart3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLECHART3_Autoscroll")) ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         nRC_GXsfl_147 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_147"), ",", ".")) ;
         nGXsfl_147_fel_idx = 0 ;
         while ( nGXsfl_147_fel_idx < nRC_GXsfl_147 )
         {
            nGXsfl_147_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_147_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_147_fel_idx+1) ;
            sGXsfl_147_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_147_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1472( ) ;
            AV42GXV1 = (int)(nGXsfl_147_fel_idx+GRID_nFirstRecordOnPage) ;
            if ( ( AV7SDTNotificationsData.size() >= AV42GXV1 ) && ( AV42GXV1 > 0 ) )
            {
               AV7SDTNotificationsData.currentItem( ((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)) );
               AV6NotificationIcon = httpContext.cgiGet( edtavNotificationicon_Internalname) ;
            }
         }
         if ( nGXsfl_147_fel_idx == 0 )
         {
            nGXsfl_147_idx = 1 ;
            sGXsfl_147_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_147_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1472( ) ;
         }
         nGXsfl_147_fel_idx = 1 ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard1_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard1_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARD1");
            GX_FocusControl = edtavValuecard1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8ValueCard1 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8ValueCard1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ValueCard1), 8, 0));
         }
         else
         {
            AV8ValueCard1 = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecard1_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8ValueCard1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ValueCard1), 8, 0));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue1_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue1_Internalname)), DecimalUtil.stringToDec("99.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vNUMBERSECONDARYVALUE1");
            GX_FocusControl = edtavNumbersecondaryvalue1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV14NumberSecondaryValue1 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14NumberSecondaryValue1", GXutil.ltrimstr( AV14NumberSecondaryValue1, 5, 2));
         }
         else
         {
            AV14NumberSecondaryValue1 = localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue1_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14NumberSecondaryValue1", GXutil.ltrimstr( AV14NumberSecondaryValue1, 5, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard2_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard2_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARD2");
            GX_FocusControl = edtavValuecard2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9ValueCard2 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9ValueCard2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9ValueCard2), 8, 0));
         }
         else
         {
            AV9ValueCard2 = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecard2_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9ValueCard2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9ValueCard2), 8, 0));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue2_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue2_Internalname)), DecimalUtil.stringToDec("99.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vNUMBERSECONDARYVALUE2");
            GX_FocusControl = edtavNumbersecondaryvalue2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV15NumberSecondaryValue2 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15NumberSecondaryValue2", GXutil.ltrimstr( AV15NumberSecondaryValue2, 5, 2));
         }
         else
         {
            AV15NumberSecondaryValue2 = localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue2_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15NumberSecondaryValue2", GXutil.ltrimstr( AV15NumberSecondaryValue2, 5, 2));
         }
         AV10ValueCard3 = httpContext.cgiGet( edtavValuecard3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ValueCard3", AV10ValueCard3);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue3_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue3_Internalname)), DecimalUtil.stringToDec("99.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vNUMBERSECONDARYVALUE3");
            GX_FocusControl = edtavNumbersecondaryvalue3_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16NumberSecondaryValue3 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16NumberSecondaryValue3", GXutil.ltrimstr( AV16NumberSecondaryValue3, 5, 2));
         }
         else
         {
            AV16NumberSecondaryValue3 = localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue3_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16NumberSecondaryValue3", GXutil.ltrimstr( AV16NumberSecondaryValue3, 5, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard4_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard4_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARD4");
            GX_FocusControl = edtavValuecard4_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11ValueCard4 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11ValueCard4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11ValueCard4), 8, 0));
         }
         else
         {
            AV11ValueCard4 = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecard4_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11ValueCard4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11ValueCard4), 8, 0));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue4_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue4_Internalname)), DecimalUtil.stringToDec("99.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vNUMBERSECONDARYVALUE4");
            GX_FocusControl = edtavNumbersecondaryvalue4_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17NumberSecondaryValue4 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17NumberSecondaryValue4", GXutil.ltrimstr( AV17NumberSecondaryValue4, 5, 2));
         }
         else
         {
            AV17NumberSecondaryValue4 = localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue4_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17NumberSecondaryValue4", GXutil.ltrimstr( AV17NumberSecondaryValue4, 5, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard5_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecard5_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARD5");
            GX_FocusControl = edtavValuecard5_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV23ValueCard5 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ValueCard5", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ValueCard5), 8, 0));
         }
         else
         {
            AV23ValueCard5 = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecard5_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ValueCard5", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ValueCard5), 8, 0));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue5_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue5_Internalname)), DecimalUtil.stringToDec("99.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vNUMBERSECONDARYVALUE5");
            GX_FocusControl = edtavNumbersecondaryvalue5_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18NumberSecondaryValue5 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18NumberSecondaryValue5", GXutil.ltrimstr( AV18NumberSecondaryValue5, 5, 2));
         }
         else
         {
            AV18NumberSecondaryValue5 = localUtil.ctond( httpContext.cgiGet( edtavNumbersecondaryvalue5_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18NumberSecondaryValue5", GXutil.ltrimstr( AV18NumberSecondaryValue5, 5, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar1_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar1_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUEPROGRESSBAR1");
            GX_FocusControl = edtavValueprogressbar1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV24ValueProgressBar1 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ValueProgressBar1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ValueProgressBar1), 4, 0));
         }
         else
         {
            AV24ValueProgressBar1 = (short)(localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar1_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ValueProgressBar1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ValueProgressBar1), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar1_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar1_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTALVALUEPROGRESSBAR1");
            GX_FocusControl = edtavTotalvalueprogressbar1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19TotalValueProgressBar1 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19TotalValueProgressBar1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19TotalValueProgressBar1), 4, 0));
         }
         else
         {
            AV19TotalValueProgressBar1 = (short)(localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar1_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19TotalValueProgressBar1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19TotalValueProgressBar1), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar2_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar2_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUEPROGRESSBAR2");
            GX_FocusControl = edtavValueprogressbar2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV25ValueProgressBar2 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ValueProgressBar2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ValueProgressBar2), 4, 0));
         }
         else
         {
            AV25ValueProgressBar2 = (short)(localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar2_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ValueProgressBar2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ValueProgressBar2), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar2_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar2_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTALVALUEPROGRESSBAR2");
            GX_FocusControl = edtavTotalvalueprogressbar2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20TotalValueProgressBar2 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20TotalValueProgressBar2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20TotalValueProgressBar2), 4, 0));
         }
         else
         {
            AV20TotalValueProgressBar2 = (short)(localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar2_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20TotalValueProgressBar2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20TotalValueProgressBar2), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar3_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar3_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUEPROGRESSBAR3");
            GX_FocusControl = edtavValueprogressbar3_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV26ValueProgressBar3 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ValueProgressBar3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ValueProgressBar3), 4, 0));
         }
         else
         {
            AV26ValueProgressBar3 = (short)(localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar3_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ValueProgressBar3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ValueProgressBar3), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar3_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar3_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTALVALUEPROGRESSBAR3");
            GX_FocusControl = edtavTotalvalueprogressbar3_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV21TotalValueProgressBar3 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21TotalValueProgressBar3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TotalValueProgressBar3), 4, 0));
         }
         else
         {
            AV21TotalValueProgressBar3 = (short)(localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar3_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21TotalValueProgressBar3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TotalValueProgressBar3), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar4_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar4_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUEPROGRESSBAR4");
            GX_FocusControl = edtavValueprogressbar4_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27ValueProgressBar4 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27ValueProgressBar4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27ValueProgressBar4), 4, 0));
         }
         else
         {
            AV27ValueProgressBar4 = (short)(localUtil.ctol( httpContext.cgiGet( edtavValueprogressbar4_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27ValueProgressBar4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27ValueProgressBar4), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar4_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar4_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTALVALUEPROGRESSBAR4");
            GX_FocusControl = edtavTotalvalueprogressbar4_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV22TotalValueProgressBar4 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TotalValueProgressBar4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TotalValueProgressBar4), 4, 0));
         }
         else
         {
            AV22TotalValueProgressBar4 = (short)(localUtil.ctol( httpContext.cgiGet( edtavTotalvalueprogressbar4_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TotalValueProgressBar4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TotalValueProgressBar4), 4, 0));
         }
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
      e11072 ();
      if (returnInSub) return;
   }

   public void e11072( )
   {
      /* Start Routine */
      returnInSub = false ;
      divTablechart3_Height = 427 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablechart3_Internalname, "Height", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablechart3_Height), 9, 0), true);
      divTablechart4_Height = 427 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablechart4_Internalname, "Height", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablechart4_Height), 9, 0), true);
      divTablechart1_Height = 326 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablechart1_Internalname, "Height", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablechart1_Height), 9, 0), true);
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      subGrid_Rows = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      AV8ValueCard1 = 352 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8ValueCard1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ValueCard1), 8, 0));
      AV9ValueCard2 = 75520 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9ValueCard2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9ValueCard2), 8, 0));
      AV10ValueCard3 = "+560" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ValueCard3", AV10ValueCard3);
      AV11ValueCard4 = 2540 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11ValueCard4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11ValueCard4), 8, 0));
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = AV5HomeSampleData ;
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[0] = GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
      new com.projectthani.wwpbaseobjects.gethomesampledata(remoteHandle, context).execute( GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2) ;
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[0] ;
      AV5HomeSampleData = GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
      AV13Axis = (com.projectthani.SdtQueryViewerElements_Element)new com.projectthani.SdtQueryViewerElements_Element(remoteHandle, context);
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Name( "ProductStatus" );
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Visible( "No" );
      AV12Axes.add(AV13Axis, 0);
      AV13Axis = (com.projectthani.SdtQueryViewerElements_Element)new com.projectthani.SdtQueryViewerElements_Element(remoteHandle, context);
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Name( "Check" );
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Visible( "No" );
      AV12Axes.add(AV13Axis, 0);
      GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 = AV7SDTNotificationsData ;
      GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4[0] = GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 ;
      new com.projectthani.wwpbaseobjects.getnotificationsamples(remoteHandle, context).execute( GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4) ;
      GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 = GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4[0] ;
      AV7SDTNotificationsData = GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 ;
      gx_BV147 = true ;
      if ( AV7SDTNotificationsData.size() == 0 )
      {
         lblNotificationssubtitle_Caption = "No tienes nuevas notificaciones" ;
         httpContext.ajax_rsp_assign_prop("", false, lblNotificationssubtitle_Internalname, "Caption", lblNotificationssubtitle_Caption, true);
      }
      else if ( AV7SDTNotificationsData.size() == 1 )
      {
         lblNotificationssubtitle_Caption = "Tienes 1 nueva notificación" ;
         httpContext.ajax_rsp_assign_prop("", false, lblNotificationssubtitle_Internalname, "Caption", lblNotificationssubtitle_Caption, true);
      }
      else
      {
         lblNotificationssubtitle_Caption = GXutil.format( "Tienes %1 nuevas notificaciones", GXutil.trim( GXutil.str( AV7SDTNotificationsData.size(), 9, 0)), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblNotificationssubtitle_Internalname, "Caption", lblNotificationssubtitle_Caption, true);
      }
      AV23ValueCard5 = 7251 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ValueCard5", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ValueCard5), 8, 0));
      AV13Axis = (com.projectthani.SdtQueryViewerElements_Element)new com.projectthani.SdtQueryViewerElements_Element(remoteHandle, context);
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Name( "Check" );
      AV13Axis.setgxTv_SdtQueryViewerElements_Element_Visible( "No" );
      AV12Axes.add(AV13Axis, 0);
      AV14NumberSecondaryValue1 = DecimalUtil.doubleToDec(18) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14NumberSecondaryValue1", GXutil.ltrimstr( AV14NumberSecondaryValue1, 5, 2));
      AV15NumberSecondaryValue2 = DecimalUtil.doubleToDec(41) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15NumberSecondaryValue2", GXutil.ltrimstr( AV15NumberSecondaryValue2, 5, 2));
      AV16NumberSecondaryValue3 = DecimalUtil.doubleToDec(25) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16NumberSecondaryValue3", GXutil.ltrimstr( AV16NumberSecondaryValue3, 5, 2));
      AV17NumberSecondaryValue4 = DecimalUtil.doubleToDec(8) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17NumberSecondaryValue4", GXutil.ltrimstr( AV17NumberSecondaryValue4, 5, 2));
      AV18NumberSecondaryValue5 = DecimalUtil.doubleToDec(12) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18NumberSecondaryValue5", GXutil.ltrimstr( AV18NumberSecondaryValue5, 5, 2));
      AV24ValueProgressBar1 = (short)(1568) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ValueProgressBar1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ValueProgressBar1), 4, 0));
      AV19TotalValueProgressBar1 = (short)(1890) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19TotalValueProgressBar1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19TotalValueProgressBar1), 4, 0));
      AV25ValueProgressBar2 = (short)(421) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ValueProgressBar2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ValueProgressBar2), 4, 0));
      AV20TotalValueProgressBar2 = (short)(752) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20TotalValueProgressBar2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20TotalValueProgressBar2), 4, 0));
      AV26ValueProgressBar3 = (short)(1669) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ValueProgressBar3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ValueProgressBar3), 4, 0));
      AV21TotalValueProgressBar3 = (short)(2256) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21TotalValueProgressBar3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TotalValueProgressBar3), 4, 0));
      AV27ValueProgressBar4 = (short)(1085) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ValueProgressBar4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27ValueProgressBar4), 4, 0));
      AV22TotalValueProgressBar4 = (short)(5423) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22TotalValueProgressBar4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TotalValueProgressBar4), 4, 0));
   }

   private void e12072( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV7SDTNotificationsData.size() )
      {
         AV7SDTNotificationsData.currentItem( ((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)) );
         edtavNotificationicon_Format = (short)(2) ;
         AV6NotificationIcon = GXutil.format( "<i class=\"%1 %2\"></i>", ((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)(AV7SDTNotificationsData.currentItem())).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass(), "NotificationFontIconGrid", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavNotificationicon_Internalname, AV6NotificationIcon);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(147) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1472( ) ;
            GRID_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRID_nCurrentRecord + 1 >= subgrid_fnc_recordcount( ) )
            {
               GRID_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_147_Refreshing )
         {
            httpContext.doAjaxLoad(147, GridRow);
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table14_233_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTabletotal4_Internalname, tblTabletotal4_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValueprogressbar4_Internalname, "Value Progress Bar4", "gx-form-item ProgressBarAdminV2NumberLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValueprogressbar4_Internalname, GXutil.ltrim( localUtil.ntoc( AV27ValueProgressBar4, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValueprogressbar4_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV27ValueProgressBar4), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV27ValueProgressBar4), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,237);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValueprogressbar4_Jsonclick, 0, "ProgressBarAdminV2Number", "", "", "", "", 1, edtavValueprogressbar4_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblSeparatorprogressbar4_Internalname, "/", "", "", lblSeparatorprogressbar4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ProgressBarAdminV2NumberTotal", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTotalvalueprogressbar4_Internalname, "Total Value Progress Bar4", "gx-form-item ProgressBarAdminV2NumberTotalLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 242,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTotalvalueprogressbar4_Internalname, GXutil.ltrim( localUtil.ntoc( AV22TotalValueProgressBar4, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavTotalvalueprogressbar4_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV22TotalValueProgressBar4), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV22TotalValueProgressBar4), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,242);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotalvalueprogressbar4_Jsonclick, 0, "ProgressBarAdminV2NumberTotal", "", "", "", "", 1, edtavTotalvalueprogressbar4_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table14_233_072e( true) ;
      }
      else
      {
         wb_table14_233_072e( false) ;
      }
   }

   public void wb_table13_214_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTabletotal3_Internalname, tblTabletotal3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValueprogressbar3_Internalname, "Value Progress Bar3", "gx-form-item ProgressBarAdminV2NumberLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 218,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValueprogressbar3_Internalname, GXutil.ltrim( localUtil.ntoc( AV26ValueProgressBar3, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValueprogressbar3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV26ValueProgressBar3), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV26ValueProgressBar3), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,218);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValueprogressbar3_Jsonclick, 0, "ProgressBarAdminV2Number", "", "", "", "", 1, edtavValueprogressbar3_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblSeparatorprogressbar3_Internalname, "/", "", "", lblSeparatorprogressbar3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ProgressBarAdminV2NumberTotal", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTotalvalueprogressbar3_Internalname, "Total Value Progress Bar3", "gx-form-item ProgressBarAdminV2NumberTotalLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTotalvalueprogressbar3_Internalname, GXutil.ltrim( localUtil.ntoc( AV21TotalValueProgressBar3, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavTotalvalueprogressbar3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21TotalValueProgressBar3), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21TotalValueProgressBar3), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,223);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotalvalueprogressbar3_Jsonclick, 0, "ProgressBarAdminV2NumberTotal", "", "", "", "", 1, edtavTotalvalueprogressbar3_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table13_214_072e( true) ;
      }
      else
      {
         wb_table13_214_072e( false) ;
      }
   }

   public void wb_table12_195_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTabletotal2_Internalname, tblTabletotal2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValueprogressbar2_Internalname, "Value Progress Bar2", "gx-form-item ProgressBarAdminV2NumberLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValueprogressbar2_Internalname, GXutil.ltrim( localUtil.ntoc( AV25ValueProgressBar2, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValueprogressbar2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV25ValueProgressBar2), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV25ValueProgressBar2), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,199);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValueprogressbar2_Jsonclick, 0, "ProgressBarAdminV2Number", "", "", "", "", 1, edtavValueprogressbar2_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblSeparatorprogressbar2_Internalname, "/", "", "", lblSeparatorprogressbar2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ProgressBarAdminV2NumberTotal", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTotalvalueprogressbar2_Internalname, "Total Value Progress Bar2", "gx-form-item ProgressBarAdminV2NumberTotalLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 204,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTotalvalueprogressbar2_Internalname, GXutil.ltrim( localUtil.ntoc( AV20TotalValueProgressBar2, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavTotalvalueprogressbar2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20TotalValueProgressBar2), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20TotalValueProgressBar2), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,204);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotalvalueprogressbar2_Jsonclick, 0, "ProgressBarAdminV2NumberTotal", "", "", "", "", 1, edtavTotalvalueprogressbar2_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table12_195_072e( true) ;
      }
      else
      {
         wb_table12_195_072e( false) ;
      }
   }

   public void wb_table11_176_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTabletotal1_Internalname, tblTabletotal1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValueprogressbar1_Internalname, "Value Progress Bar1", "gx-form-item ProgressBarAdminV2NumberLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 180,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValueprogressbar1_Internalname, GXutil.ltrim( localUtil.ntoc( AV24ValueProgressBar1, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValueprogressbar1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV24ValueProgressBar1), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV24ValueProgressBar1), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,180);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValueprogressbar1_Jsonclick, 0, "ProgressBarAdminV2Number", "", "", "", "", 1, edtavValueprogressbar1_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblSeparatorprogressbar1_Internalname, "/", "", "", lblSeparatorprogressbar1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ProgressBarAdminV2NumberTotal", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTotalvalueprogressbar1_Internalname, "Total Value Progress Bar1", "gx-form-item ProgressBarAdminV2NumberTotalLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 185,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTotalvalueprogressbar1_Internalname, GXutil.ltrim( localUtil.ntoc( AV19TotalValueProgressBar1, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavTotalvalueprogressbar1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19TotalValueProgressBar1), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19TotalValueProgressBar1), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,185);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotalvalueprogressbar1_Jsonclick, 0, "ProgressBarAdminV2NumberTotal", "", "", "", "", 1, edtavTotalvalueprogressbar1_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table11_176_072e( true) ;
      }
      else
      {
         wb_table11_176_072e( false) ;
      }
   }

   public void wb_table10_128_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedmoreinfoiconcard5_Internalname, tblTablemergedmoreinfoiconcard5_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard5_Internalname, "<i class='fas fa-caret-down FontColorIconDanger' style='font-size: 12px'></i>", "", "", lblMoreinfoiconcard5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavNumbersecondaryvalue5_Internalname, "Number Secondary Value5", "gx-form-item DashboardPercentageDangerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavNumbersecondaryvalue5_Internalname, GXutil.ltrim( localUtil.ntoc( AV18NumberSecondaryValue5, (byte)(5), (byte)(2), ",", "")), GXutil.ltrim( ((edtavNumbersecondaryvalue5_Enabled!=0) ? localUtil.format( AV18NumberSecondaryValue5, "Z9%") : localUtil.format( AV18NumberSecondaryValue5, "Z9%"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNumbersecondaryvalue5_Jsonclick, 0, "DashboardPercentageDanger", "", "", "", "", 1, edtavNumbersecondaryvalue5_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWPPercentage", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard5caption_Internalname, "From last month", "", "", lblMoreinfocard5caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table10_128_072e( true) ;
      }
      else
      {
         wb_table10_128_072e( false) ;
      }
   }

   public void wb_table9_116_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedicon5_Internalname, tblTablemergedicon5_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon5_Internalname, "<i class='fas fa-tag ProgressCardIcon' style='font-size: 12px'></i>", "", "", lblIcon5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard5_Internalname, "Mentions", "", "", lblDescriptioncard5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_116_072e( true) ;
      }
      else
      {
         wb_table9_116_072e( false) ;
      }
   }

   public void wb_table8_103_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedmoreinfoiconcard4_Internalname, tblTablemergedmoreinfoiconcard4_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard4_Internalname, "<i class='fas fa-caret-down FontColorIconDanger' style='font-size: 12px'></i>", "", "", lblMoreinfoiconcard4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavNumbersecondaryvalue4_Internalname, "Number Secondary Value4", "gx-form-item DashboardPercentageDangerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavNumbersecondaryvalue4_Internalname, GXutil.ltrim( localUtil.ntoc( AV17NumberSecondaryValue4, (byte)(5), (byte)(2), ",", "")), GXutil.ltrim( ((edtavNumbersecondaryvalue4_Enabled!=0) ? localUtil.format( AV17NumberSecondaryValue4, "Z9%") : localUtil.format( AV17NumberSecondaryValue4, "Z9%"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNumbersecondaryvalue4_Jsonclick, 0, "DashboardPercentageDanger", "", "", "", "", 1, edtavNumbersecondaryvalue4_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWPPercentage", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard4caption_Internalname, "Desde el mes pasado", "", "", lblMoreinfocard4caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_103_072e( true) ;
      }
      else
      {
         wb_table8_103_072e( false) ;
      }
   }

   public void wb_table7_91_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedicon4_Internalname, tblTablemergedicon4_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon4_Internalname, "<i class='fas fa-heart ProgressCardIcon' style='font-size: 12px'></i>", "", "", lblIcon4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard4_Internalname, "Views", "", "", lblDescriptioncard4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_91_072e( true) ;
      }
      else
      {
         wb_table7_91_072e( false) ;
      }
   }

   public void wb_table6_78_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedmoreinfoiconcard3_Internalname, tblTablemergedmoreinfoiconcard3_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard3_Internalname, "<i class='fas fa-caret-down FontColorIconDanger' style='font-size: 12px'></i>", "", "", lblMoreinfoiconcard3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavNumbersecondaryvalue3_Internalname, "Number Secondary Value3", "gx-form-item DashboardPercentageDangerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavNumbersecondaryvalue3_Internalname, GXutil.ltrim( localUtil.ntoc( AV16NumberSecondaryValue3, (byte)(5), (byte)(2), ",", "")), GXutil.ltrim( ((edtavNumbersecondaryvalue3_Enabled!=0) ? localUtil.format( AV16NumberSecondaryValue3, "Z9%") : localUtil.format( AV16NumberSecondaryValue3, "Z9%"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNumbersecondaryvalue3_Jsonclick, 0, "DashboardPercentageDanger", "", "", "", "", 1, edtavNumbersecondaryvalue3_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWPPercentage", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard3caption_Internalname, "Desde el mes pasado", "", "", lblMoreinfocard3caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_78_072e( true) ;
      }
      else
      {
         wb_table6_78_072e( false) ;
      }
   }

   public void wb_table5_66_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedicon3_Internalname, tblTablemergedicon3_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon3_Internalname, "<i class='fas fa-user ProgressCardIcon' style='font-size: 12px'></i>", "", "", lblIcon3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard3_Internalname, "Users", "", "", lblDescriptioncard3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_66_072e( true) ;
      }
      else
      {
         wb_table5_66_072e( false) ;
      }
   }

   public void wb_table4_53_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedmoreinfoiconcard2_Internalname, tblTablemergedmoreinfoiconcard2_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard2_Internalname, "<i class='fas fa-caret-down FontColorIconDanger' style='font-size: 12px'></i>", "", "", lblMoreinfoiconcard2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavNumbersecondaryvalue2_Internalname, "Number Secondary Value2", "gx-form-item DashboardPercentageDangerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavNumbersecondaryvalue2_Internalname, GXutil.ltrim( localUtil.ntoc( AV15NumberSecondaryValue2, (byte)(5), (byte)(2), ",", "")), GXutil.ltrim( ((edtavNumbersecondaryvalue2_Enabled!=0) ? localUtil.format( AV15NumberSecondaryValue2, "Z9%") : localUtil.format( AV15NumberSecondaryValue2, "Z9%"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNumbersecondaryvalue2_Jsonclick, 0, "DashboardPercentageDanger", "", "", "", "", 1, edtavNumbersecondaryvalue2_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWPPercentage", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard2caption_Internalname, "Desde el mes pasado", "", "", lblMoreinfocard2caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_53_072e( true) ;
      }
      else
      {
         wb_table4_53_072e( false) ;
      }
   }

   public void wb_table3_41_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedicon2_Internalname, tblTablemergedicon2_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon2_Internalname, "<i class='fas fa-university ProgressCardIcon' style='font-size: 12px'></i>", "", "", lblIcon2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard2_Internalname, "Revenue", "", "", lblDescriptioncard2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_41_072e( true) ;
      }
      else
      {
         wb_table3_41_072e( false) ;
      }
   }

   public void wb_table2_28_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedmoreinfoiconcard1_Internalname, tblTablemergedmoreinfoiconcard1_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard1_Internalname, "<i class='fas fa-caret-up FontColorIconSuccess' style='font-size: 12px'></i>", "", "", lblMoreinfoiconcard1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavNumbersecondaryvalue1_Internalname, "Number Secondary Value1", "gx-form-item DashboardPercentageSuccessLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'" + sGXsfl_147_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavNumbersecondaryvalue1_Internalname, GXutil.ltrim( localUtil.ntoc( AV14NumberSecondaryValue1, (byte)(5), (byte)(2), ",", "")), GXutil.ltrim( ((edtavNumbersecondaryvalue1_Enabled!=0) ? localUtil.format( AV14NumberSecondaryValue1, "Z9%") : localUtil.format( AV14NumberSecondaryValue1, "Z9%"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNumbersecondaryvalue1_Jsonclick, 0, "DashboardPercentageSuccess", "", "", "", "", 1, edtavNumbersecondaryvalue1_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWPPercentage", "right", false, "", "HLP_WWPBaseObjects\\Home.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard1caption_Internalname, "Desde el mes pasado", "", "", lblMoreinfocard1caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_28_072e( true) ;
      }
      else
      {
         wb_table2_28_072e( false) ;
      }
   }

   public void wb_table1_16_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemergedicon1_Internalname, tblTablemergedicon1_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon1_Internalname, "<i class='fas fa-shopping-cart ProgressCardIcon' style='font-size: 12px'></i>", "", "", lblIcon1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard1_Internalname, "Sales", "", "", lblDescriptioncard1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Home.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_16_072e( true) ;
      }
      else
      {
         wb_table1_16_072e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa072( ) ;
      ws072( ) ;
      we072( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
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
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/highcharts/css/highcharts.css", "");
      httpContext.AddStyleSheetFile("QueryViewer/QueryViewer.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110332147", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("wwpbaseobjects/home.js", "?20225110332148", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/echarts.min.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/extension/bmap.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-3d.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-more.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/funnel.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/solid-gauge.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/oatPivot/gxpivotjs.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DVProgressIndicator/DVProgressIndicatorRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/echarts.min.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/extension/bmap.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-3d.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-more.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/funnel.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/solid-gauge.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/oatPivot/gxpivotjs.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/QueryViewerCommon.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/echarts.min.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/Echarts/dist/extension/bmap.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-3d.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/highcharts-more.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/funnel.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/highcharts/modules/solid-gauge.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/oatPivot/gxpivotjs.js", "", false, true);
         httpContext.AddJavascriptSource("QueryViewer/QueryViewerRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_1472( )
   {
      edtavNotificationicon_Internalname = "vNOTIFICATIONICON_"+sGXsfl_147_idx ;
      edtavSdtnotificationsdata__notificationiconclass_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONICONCLASS_"+sGXsfl_147_idx ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE_"+sGXsfl_147_idx ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME_"+sGXsfl_147_idx ;
   }

   public void subsflControlProps_fel_1472( )
   {
      edtavNotificationicon_Internalname = "vNOTIFICATIONICON_"+sGXsfl_147_fel_idx ;
      edtavSdtnotificationsdata__notificationiconclass_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONICONCLASS_"+sGXsfl_147_fel_idx ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE_"+sGXsfl_147_fel_idx ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME_"+sGXsfl_147_fel_idx ;
   }

   public void sendrow_1472( )
   {
      subsflControlProps_1472( ) ;
      wb070( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_147_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_147_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_147_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavNotificationicon_Internalname,AV6NotificationIcon,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavNotificationicon_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavNotificationicon_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Short.valueOf(edtavNotificationicon_Format),Integer.valueOf(147),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationiconclass_Internalname,((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationiconclass_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtnotificationsdata__notificationiconclass_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(147),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationtitle_Internalname,((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationtitle_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtnotificationsdata__notificationtitle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(147),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeSecondary" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationdatetime_Internalname,localUtil.ttoc( ((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime(), 10, 8, 0, 3, "/", ":", " "),localUtil.format( ((com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)AV7SDTNotificationsData.elementAt(-1+AV42GXV1)).getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime(), "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationdatetime_Jsonclick,Integer.valueOf(0),"AttributeSecondary","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtnotificationsdata__notificationdatetime_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(147),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes072( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_147_idx = ((subGrid_Islastpage==1)&&(nGXsfl_147_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_147_idx+1) ;
         sGXsfl_147_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_147_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1472( ) ;
      }
      /* End function sendrow_1472 */
   }

   public void init_default_properties( )
   {
      lblIcon1_Internalname = "ICON1" ;
      lblDescriptioncard1_Internalname = "DESCRIPTIONCARD1" ;
      tblTablemergedicon1_Internalname = "TABLEMERGEDICON1" ;
      edtavValuecard1_Internalname = "vVALUECARD1" ;
      lblMoreinfoiconcard1_Internalname = "MOREINFOICONCARD1" ;
      edtavNumbersecondaryvalue1_Internalname = "vNUMBERSECONDARYVALUE1" ;
      lblMoreinfocard1caption_Internalname = "MOREINFOCARD1CAPTION" ;
      tblTablemergedmoreinfoiconcard1_Internalname = "TABLEMERGEDMOREINFOICONCARD1" ;
      divCard1_Internalname = "CARD1" ;
      lblIcon2_Internalname = "ICON2" ;
      lblDescriptioncard2_Internalname = "DESCRIPTIONCARD2" ;
      tblTablemergedicon2_Internalname = "TABLEMERGEDICON2" ;
      edtavValuecard2_Internalname = "vVALUECARD2" ;
      lblMoreinfoiconcard2_Internalname = "MOREINFOICONCARD2" ;
      edtavNumbersecondaryvalue2_Internalname = "vNUMBERSECONDARYVALUE2" ;
      lblMoreinfocard2caption_Internalname = "MOREINFOCARD2CAPTION" ;
      tblTablemergedmoreinfoiconcard2_Internalname = "TABLEMERGEDMOREINFOICONCARD2" ;
      divCard2_Internalname = "CARD2" ;
      lblIcon3_Internalname = "ICON3" ;
      lblDescriptioncard3_Internalname = "DESCRIPTIONCARD3" ;
      tblTablemergedicon3_Internalname = "TABLEMERGEDICON3" ;
      edtavValuecard3_Internalname = "vVALUECARD3" ;
      lblMoreinfoiconcard3_Internalname = "MOREINFOICONCARD3" ;
      edtavNumbersecondaryvalue3_Internalname = "vNUMBERSECONDARYVALUE3" ;
      lblMoreinfocard3caption_Internalname = "MOREINFOCARD3CAPTION" ;
      tblTablemergedmoreinfoiconcard3_Internalname = "TABLEMERGEDMOREINFOICONCARD3" ;
      divCard3_Internalname = "CARD3" ;
      lblIcon4_Internalname = "ICON4" ;
      lblDescriptioncard4_Internalname = "DESCRIPTIONCARD4" ;
      tblTablemergedicon4_Internalname = "TABLEMERGEDICON4" ;
      edtavValuecard4_Internalname = "vVALUECARD4" ;
      lblMoreinfoiconcard4_Internalname = "MOREINFOICONCARD4" ;
      edtavNumbersecondaryvalue4_Internalname = "vNUMBERSECONDARYVALUE4" ;
      lblMoreinfocard4caption_Internalname = "MOREINFOCARD4CAPTION" ;
      tblTablemergedmoreinfoiconcard4_Internalname = "TABLEMERGEDMOREINFOICONCARD4" ;
      divCard4_Internalname = "CARD4" ;
      lblIcon5_Internalname = "ICON5" ;
      lblDescriptioncard5_Internalname = "DESCRIPTIONCARD5" ;
      tblTablemergedicon5_Internalname = "TABLEMERGEDICON5" ;
      edtavValuecard5_Internalname = "vVALUECARD5" ;
      lblMoreinfoiconcard5_Internalname = "MOREINFOICONCARD5" ;
      edtavNumbersecondaryvalue5_Internalname = "vNUMBERSECONDARYVALUE5" ;
      lblMoreinfocard5caption_Internalname = "MOREINFOCARD5CAPTION" ;
      tblTablemergedmoreinfoiconcard5_Internalname = "TABLEMERGEDMOREINFOICONCARD5" ;
      divCard5_Internalname = "CARD5" ;
      divTablecards_Internalname = "TABLECARDS" ;
      Dvpanel_tablecards_Internalname = "DVPANEL_TABLECARDS" ;
      lblNotificationssubtitle_Internalname = "NOTIFICATIONSSUBTITLE" ;
      edtavNotificationicon_Internalname = "vNOTIFICATIONICON" ;
      edtavSdtnotificationsdata__notificationiconclass_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONICONCLASS" ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE" ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = "SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME" ;
      divTablenotifications_Internalname = "TABLENOTIFICATIONS" ;
      Dvpanel_tablenotifications_Internalname = "DVPANEL_TABLENOTIFICATIONS" ;
      lblCharttitle_Internalname = "CHARTTITLE" ;
      Utchartsmootharea_Internalname = "UTCHARTSMOOTHAREA" ;
      divTablereport_Internalname = "TABLEREPORT" ;
      lblIndicatorstitle_Internalname = "INDICATORSTITLE" ;
      lblDescriptionprogressbar1_Internalname = "DESCRIPTIONPROGRESSBAR1" ;
      edtavValueprogressbar1_Internalname = "vVALUEPROGRESSBAR1" ;
      lblSeparatorprogressbar1_Internalname = "SEPARATORPROGRESSBAR1" ;
      edtavTotalvalueprogressbar1_Internalname = "vTOTALVALUEPROGRESSBAR1" ;
      tblTabletotal1_Internalname = "TABLETOTAL1" ;
      divTabletitle1_Internalname = "TABLETITLE1" ;
      Progressbar1_Internalname = "PROGRESSBAR1" ;
      lblDescriptionprogressbar2_Internalname = "DESCRIPTIONPROGRESSBAR2" ;
      edtavValueprogressbar2_Internalname = "vVALUEPROGRESSBAR2" ;
      lblSeparatorprogressbar2_Internalname = "SEPARATORPROGRESSBAR2" ;
      edtavTotalvalueprogressbar2_Internalname = "vTOTALVALUEPROGRESSBAR2" ;
      tblTabletotal2_Internalname = "TABLETOTAL2" ;
      divTabletitle2_Internalname = "TABLETITLE2" ;
      Progressbar2_Internalname = "PROGRESSBAR2" ;
      lblDescriptionprogressbar3_Internalname = "DESCRIPTIONPROGRESSBAR3" ;
      edtavValueprogressbar3_Internalname = "vVALUEPROGRESSBAR3" ;
      lblSeparatorprogressbar3_Internalname = "SEPARATORPROGRESSBAR3" ;
      edtavTotalvalueprogressbar3_Internalname = "vTOTALVALUEPROGRESSBAR3" ;
      tblTabletotal3_Internalname = "TABLETOTAL3" ;
      divTabletitle3_Internalname = "TABLETITLE3" ;
      Progressbar3_Internalname = "PROGRESSBAR3" ;
      lblDescriptionprogressbar4_Internalname = "DESCRIPTIONPROGRESSBAR4" ;
      edtavValueprogressbar4_Internalname = "vVALUEPROGRESSBAR4" ;
      lblSeparatorprogressbar4_Internalname = "SEPARATORPROGRESSBAR4" ;
      edtavTotalvalueprogressbar4_Internalname = "vTOTALVALUEPROGRESSBAR4" ;
      tblTabletotal4_Internalname = "TABLETOTAL4" ;
      divTabletitle4_Internalname = "TABLETITLE4" ;
      Progressbar4_Internalname = "PROGRESSBAR4" ;
      divTablereportgoals_Internalname = "TABLEREPORTGOALS" ;
      divTablechart1_Internalname = "TABLECHART1" ;
      Dvpanel_tablechart1_Internalname = "DVPANEL_TABLECHART1" ;
      Utchartsmoothline_Internalname = "UTCHARTSMOOTHLINE" ;
      divTablechart4_Internalname = "TABLECHART4" ;
      Dvpanel_tablechart4_Internalname = "DVPANEL_TABLECHART4" ;
      Utchartdoughnut_Internalname = "UTCHARTDOUGHNUT" ;
      divTablechart3_Internalname = "TABLECHART3" ;
      Dvpanel_tablechart3_Internalname = "DVPANEL_TABLECHART3" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      edtavSdtnotificationsdata__notificationdatetime_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationtitle_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationiconclass_Jsonclick = "" ;
      edtavNotificationicon_Jsonclick = "" ;
      edtavNumbersecondaryvalue1_Jsonclick = "" ;
      edtavNumbersecondaryvalue1_Enabled = 1 ;
      edtavNumbersecondaryvalue2_Jsonclick = "" ;
      edtavNumbersecondaryvalue2_Enabled = 1 ;
      edtavNumbersecondaryvalue3_Jsonclick = "" ;
      edtavNumbersecondaryvalue3_Enabled = 1 ;
      edtavNumbersecondaryvalue4_Jsonclick = "" ;
      edtavNumbersecondaryvalue4_Enabled = 1 ;
      edtavNumbersecondaryvalue5_Jsonclick = "" ;
      edtavNumbersecondaryvalue5_Enabled = 1 ;
      edtavTotalvalueprogressbar1_Jsonclick = "" ;
      edtavTotalvalueprogressbar1_Enabled = 1 ;
      edtavValueprogressbar1_Jsonclick = "" ;
      edtavValueprogressbar1_Enabled = 1 ;
      edtavTotalvalueprogressbar2_Jsonclick = "" ;
      edtavTotalvalueprogressbar2_Enabled = 1 ;
      edtavValueprogressbar2_Jsonclick = "" ;
      edtavValueprogressbar2_Enabled = 1 ;
      edtavTotalvalueprogressbar3_Jsonclick = "" ;
      edtavTotalvalueprogressbar3_Enabled = 1 ;
      edtavValueprogressbar3_Jsonclick = "" ;
      edtavValueprogressbar3_Enabled = 1 ;
      edtavTotalvalueprogressbar4_Jsonclick = "" ;
      edtavTotalvalueprogressbar4_Enabled = 1 ;
      edtavValueprogressbar4_Jsonclick = "" ;
      edtavValueprogressbar4_Enabled = 1 ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = -1 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = -1 ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = -1 ;
      Utchartdoughnut_Title = "" ;
      divTablechart3_Height = 0 ;
      Utchartsmoothline_Title = "" ;
      divTablechart4_Height = 0 ;
      Progressbar4_Caption = "" ;
      Progressbar3_Caption = "" ;
      Progressbar2_Caption = "" ;
      Progressbar1_Caption = "" ;
      Utchartsmootharea_Title = "" ;
      divTablechart1_Height = 0 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      edtavNotificationicon_Format = (short)(1) ;
      edtavNotificationicon_Enabled = 0 ;
      subGrid_Header = "" ;
      subGrid_Class = "GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblNotificationssubtitle_Caption = "Tienes %1 nuevas notificaciones" ;
      edtavValuecard5_Jsonclick = "" ;
      edtavValuecard5_Enabled = 1 ;
      edtavValuecard4_Jsonclick = "" ;
      edtavValuecard4_Enabled = 1 ;
      edtavValuecard3_Jsonclick = "" ;
      edtavValuecard3_Enabled = 1 ;
      edtavValuecard2_Jsonclick = "" ;
      edtavValuecard2_Enabled = 1 ;
      edtavValuecard1_Jsonclick = "" ;
      edtavValuecard1_Enabled = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Inicio" );
      Dvpanel_tablechart3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart3_Iconposition = "Right" ;
      Dvpanel_tablechart3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart3_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart3_Title = "Orders" ;
      Dvpanel_tablechart3_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablechart3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablechart3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart3_Width = "100%" ;
      Utchartdoughnut_Charttype = "Doughnut" ;
      Utchartdoughnut_Showvalues = GXutil.toBoolean( 0) ;
      Utchartdoughnut_Type = "Chart" ;
      Utchartdoughnut_Height = "450px" ;
      Dvpanel_tablechart4_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart4_Iconposition = "Right" ;
      Dvpanel_tablechart4_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart4_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart4_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart4_Title = "Task Board" ;
      Dvpanel_tablechart4_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablechart4_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablechart4_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart4_Width = "100%" ;
      Utchartsmoothline_Xaxistitle = " " ;
      Utchartsmoothline_Charttype = "Bar" ;
      Utchartsmoothline_Type = "Chart" ;
      Utchartsmoothline_Height = "450px" ;
      Dvpanel_tablechart1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart1_Iconposition = "Right" ;
      Dvpanel_tablechart1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tablechart1_Title = "" ;
      Dvpanel_tablechart1_Cls = "PanelNoHeader" ;
      Dvpanel_tablechart1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablechart1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablechart1_Width = "100%" ;
      Progressbar4_Percentage = 20 ;
      Progressbar4_Cls = "ProgressBarMaterial" ;
      Progressbar4_Type = "Bar" ;
      Progressbar3_Percentage = 74 ;
      Progressbar3_Cls = "ProgressBarMaterial" ;
      Progressbar3_Type = "Bar" ;
      Progressbar2_Percentage = 56 ;
      Progressbar2_Cls = "ProgressBarMaterial" ;
      Progressbar2_Type = "Bar" ;
      Progressbar1_Percentage = 83 ;
      Progressbar1_Cls = "ProgressBarMaterial" ;
      Progressbar1_Type = "Bar" ;
      Utchartsmootharea_Charttype = "SmoothLine" ;
      Utchartsmootharea_Type = "Chart" ;
      Utchartsmootharea_Height = "240px" ;
      Dvpanel_tablenotifications_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Iconposition = "Right" ;
      Dvpanel_tablenotifications_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Title = "Notificaciones" ;
      Dvpanel_tablenotifications_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablenotifications_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablenotifications_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablenotifications_Width = "100%" ;
      Dvpanel_tablecards_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablecards_Iconposition = "Right" ;
      Dvpanel_tablecards_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablecards_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablecards_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tablecards_Title = "" ;
      Dvpanel_tablecards_Cls = "PanelNoHeader" ;
      Dvpanel_tablecards_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablecards_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablecards_Width = "100%" ;
      subGrid_Rows = 0 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:147,pic:'',hsh:true},{av:'nRC_GXsfl_147',ctrl:'GRID',prop:'GridRC',grid:147}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e12072',iparms:[{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:147,pic:'',hsh:true},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_147',ctrl:'GRID',prop:'GridRC',grid:147}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtavNotificationicon_Format',ctrl:'vNOTIFICATIONICON',prop:'Format'},{av:'AV6NotificationIcon',fld:'vNOTIFICATIONICON',pic:''}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:147,pic:'',hsh:true},{av:'nRC_GXsfl_147',ctrl:'GRID',prop:'GridRC',grid:147}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:147,pic:'',hsh:true},{av:'nRC_GXsfl_147',ctrl:'GRID',prop:'GridRC',grid:147}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:147,pic:'',hsh:true},{av:'nRC_GXsfl_147',ctrl:'GRID',prop:'GridRC',grid:147}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:147,pic:'',hsh:true},{av:'nRC_GXsfl_147',ctrl:'GRID',prop:'GridRC',grid:147}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[]");
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
      AV7SDTNotificationsData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>(com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class, "WWP_SDTNotificationsDataSampleItem", "ProjectThani", remoteHandle);
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV28Elements = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element>(com.projectthani.SdtQueryViewerElements_Element.class, "Element", "ProjectThani", remoteHandle);
      AV29Parameters = new GXBaseCollection<com.projectthani.SdtQueryViewerParameters_Parameter>(com.projectthani.SdtQueryViewerParameters_Parameter.class, "Parameter", "ProjectThani", remoteHandle);
      AV30ItemClickData = new com.projectthani.SdtQueryViewerItemClickData(remoteHandle, context);
      AV31ItemDoubleClickData = new com.projectthani.SdtQueryViewerItemDoubleClickData(remoteHandle, context);
      AV32DragAndDropData = new com.projectthani.SdtQueryViewerDragAndDropData(remoteHandle, context);
      AV33FilterChangedData = new com.projectthani.SdtQueryViewerFilterChangedData(remoteHandle, context);
      AV34ItemExpandData = new com.projectthani.SdtQueryViewerItemExpandData(remoteHandle, context);
      AV35ItemCollapseData = new com.projectthani.SdtQueryViewerItemCollapseData(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_tablecards = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV10ValueCard3 = "" ;
      ucDvpanel_tablenotifications = new com.genexus.webpanels.GXUserControl();
      lblNotificationssubtitle_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV6NotificationIcon = "" ;
      ucDvpanel_tablechart1 = new com.genexus.webpanels.GXUserControl();
      lblCharttitle_Jsonclick = "" ;
      ucUtchartsmootharea = new com.genexus.webpanels.GXUserControl();
      lblIndicatorstitle_Jsonclick = "" ;
      lblDescriptionprogressbar1_Jsonclick = "" ;
      ucProgressbar1 = new com.genexus.webpanels.GXUserControl();
      lblDescriptionprogressbar2_Jsonclick = "" ;
      ucProgressbar2 = new com.genexus.webpanels.GXUserControl();
      lblDescriptionprogressbar3_Jsonclick = "" ;
      ucProgressbar3 = new com.genexus.webpanels.GXUserControl();
      lblDescriptionprogressbar4_Jsonclick = "" ;
      ucProgressbar4 = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_tablechart4 = new com.genexus.webpanels.GXUserControl();
      ucUtchartsmoothline = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_tablechart3 = new com.genexus.webpanels.GXUserControl();
      ucUtchartdoughnut = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV14NumberSecondaryValue1 = DecimalUtil.ZERO ;
      AV15NumberSecondaryValue2 = DecimalUtil.ZERO ;
      AV16NumberSecondaryValue3 = DecimalUtil.ZERO ;
      AV17NumberSecondaryValue4 = DecimalUtil.ZERO ;
      AV18NumberSecondaryValue5 = DecimalUtil.ZERO ;
      AV5HomeSampleData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "ProjectThani", remoteHandle);
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "ProjectThani", remoteHandle);
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2 = new GXBaseCollection[1] ;
      AV13Axis = new com.projectthani.SdtQueryViewerElements_Element(remoteHandle, context);
      AV12Axes = new GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element>(com.projectthani.SdtQueryViewerElements_Element.class, "Element", "ProjectThani", remoteHandle);
      GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>(com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class, "WWP_SDTNotificationsDataSampleItem", "ProjectThani", remoteHandle);
      GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4 = new GXBaseCollection[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      lblSeparatorprogressbar4_Jsonclick = "" ;
      lblSeparatorprogressbar3_Jsonclick = "" ;
      lblSeparatorprogressbar2_Jsonclick = "" ;
      lblSeparatorprogressbar1_Jsonclick = "" ;
      lblMoreinfoiconcard5_Jsonclick = "" ;
      lblMoreinfocard5caption_Jsonclick = "" ;
      lblIcon5_Jsonclick = "" ;
      lblDescriptioncard5_Jsonclick = "" ;
      lblMoreinfoiconcard4_Jsonclick = "" ;
      lblMoreinfocard4caption_Jsonclick = "" ;
      lblIcon4_Jsonclick = "" ;
      lblDescriptioncard4_Jsonclick = "" ;
      lblMoreinfoiconcard3_Jsonclick = "" ;
      lblMoreinfocard3caption_Jsonclick = "" ;
      lblIcon3_Jsonclick = "" ;
      lblDescriptioncard3_Jsonclick = "" ;
      lblMoreinfoiconcard2_Jsonclick = "" ;
      lblMoreinfocard2caption_Jsonclick = "" ;
      lblIcon2_Jsonclick = "" ;
      lblDescriptioncard2_Jsonclick = "" ;
      lblMoreinfoiconcard1_Jsonclick = "" ;
      lblMoreinfocard1caption_Jsonclick = "" ;
      lblIcon1_Jsonclick = "" ;
      lblDescriptioncard1_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavValuecard1_Enabled = 0 ;
      edtavNumbersecondaryvalue1_Enabled = 0 ;
      edtavValuecard2_Enabled = 0 ;
      edtavNumbersecondaryvalue2_Enabled = 0 ;
      edtavValuecard3_Enabled = 0 ;
      edtavNumbersecondaryvalue3_Enabled = 0 ;
      edtavValuecard4_Enabled = 0 ;
      edtavNumbersecondaryvalue4_Enabled = 0 ;
      edtavValuecard5_Enabled = 0 ;
      edtavNumbersecondaryvalue5_Enabled = 0 ;
      edtavNotificationicon_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationiconclass_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      edtavValueprogressbar1_Enabled = 0 ;
      edtavTotalvalueprogressbar1_Enabled = 0 ;
      edtavValueprogressbar2_Enabled = 0 ;
      edtavTotalvalueprogressbar2_Enabled = 0 ;
      edtavValueprogressbar3_Enabled = 0 ;
      edtavTotalvalueprogressbar3_Enabled = 0 ;
      edtavValueprogressbar4_Enabled = 0 ;
      edtavTotalvalueprogressbar4_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GRID_nEOF ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte subGrid_Backstyle ;
   private short wbEnd ;
   private short wbStart ;
   private short edtavNotificationicon_Format ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV24ValueProgressBar1 ;
   private short AV19TotalValueProgressBar1 ;
   private short AV25ValueProgressBar2 ;
   private short AV20TotalValueProgressBar2 ;
   private short AV26ValueProgressBar3 ;
   private short AV21TotalValueProgressBar3 ;
   private short AV27ValueProgressBar4 ;
   private short AV22TotalValueProgressBar4 ;
   private int nRC_GXsfl_147 ;
   private int nGXsfl_147_idx=1 ;
   private int subGrid_Rows ;
   private int Progressbar1_Percentage ;
   private int Progressbar2_Percentage ;
   private int Progressbar3_Percentage ;
   private int Progressbar4_Percentage ;
   private int AV8ValueCard1 ;
   private int edtavValuecard1_Enabled ;
   private int AV9ValueCard2 ;
   private int edtavValuecard2_Enabled ;
   private int edtavValuecard3_Enabled ;
   private int AV11ValueCard4 ;
   private int edtavValuecard4_Enabled ;
   private int AV23ValueCard5 ;
   private int edtavValuecard5_Enabled ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavNotificationicon_Enabled ;
   private int edtavSdtnotificationsdata__notificationiconclass_Enabled ;
   private int edtavSdtnotificationsdata__notificationtitle_Enabled ;
   private int edtavSdtnotificationsdata__notificationdatetime_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int AV42GXV1 ;
   private int divTablechart1_Height ;
   private int divTablechart4_Height ;
   private int divTablechart3_Height ;
   private int subGrid_Islastpage ;
   private int edtavNumbersecondaryvalue1_Enabled ;
   private int edtavNumbersecondaryvalue2_Enabled ;
   private int edtavNumbersecondaryvalue3_Enabled ;
   private int edtavNumbersecondaryvalue4_Enabled ;
   private int edtavNumbersecondaryvalue5_Enabled ;
   private int edtavValueprogressbar1_Enabled ;
   private int edtavTotalvalueprogressbar1_Enabled ;
   private int edtavValueprogressbar2_Enabled ;
   private int edtavTotalvalueprogressbar2_Enabled ;
   private int edtavValueprogressbar3_Enabled ;
   private int edtavTotalvalueprogressbar3_Enabled ;
   private int edtavValueprogressbar4_Enabled ;
   private int edtavTotalvalueprogressbar4_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int nGXsfl_147_fel_idx=1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV14NumberSecondaryValue1 ;
   private java.math.BigDecimal AV15NumberSecondaryValue2 ;
   private java.math.BigDecimal AV16NumberSecondaryValue3 ;
   private java.math.BigDecimal AV17NumberSecondaryValue4 ;
   private java.math.BigDecimal AV18NumberSecondaryValue5 ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_147_idx="0001" ;
   private String Dvpanel_tablecards_Width ;
   private String Dvpanel_tablecards_Cls ;
   private String Dvpanel_tablecards_Title ;
   private String Dvpanel_tablecards_Iconposition ;
   private String Dvpanel_tablenotifications_Width ;
   private String Dvpanel_tablenotifications_Cls ;
   private String Dvpanel_tablenotifications_Title ;
   private String Dvpanel_tablenotifications_Iconposition ;
   private String Utchartsmootharea_Height ;
   private String Utchartsmootharea_Type ;
   private String Utchartsmootharea_Charttype ;
   private String Progressbar1_Type ;
   private String Progressbar1_Cls ;
   private String Progressbar2_Type ;
   private String Progressbar2_Cls ;
   private String Progressbar3_Type ;
   private String Progressbar3_Cls ;
   private String Progressbar4_Type ;
   private String Progressbar4_Cls ;
   private String Dvpanel_tablechart1_Width ;
   private String Dvpanel_tablechart1_Cls ;
   private String Dvpanel_tablechart1_Title ;
   private String Dvpanel_tablechart1_Iconposition ;
   private String Utchartsmoothline_Height ;
   private String Utchartsmoothline_Type ;
   private String Utchartsmoothline_Charttype ;
   private String Utchartsmoothline_Xaxistitle ;
   private String Dvpanel_tablechart4_Width ;
   private String Dvpanel_tablechart4_Cls ;
   private String Dvpanel_tablechart4_Title ;
   private String Dvpanel_tablechart4_Iconposition ;
   private String Utchartdoughnut_Height ;
   private String Utchartdoughnut_Type ;
   private String Utchartdoughnut_Charttype ;
   private String Dvpanel_tablechart3_Width ;
   private String Dvpanel_tablechart3_Cls ;
   private String Dvpanel_tablechart3_Title ;
   private String Dvpanel_tablechart3_Iconposition ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String Dvpanel_tablecards_Internalname ;
   private String divTablecards_Internalname ;
   private String divCard1_Internalname ;
   private String edtavValuecard1_Internalname ;
   private String TempTags ;
   private String edtavValuecard1_Jsonclick ;
   private String divCard2_Internalname ;
   private String edtavValuecard2_Internalname ;
   private String edtavValuecard2_Jsonclick ;
   private String divCard3_Internalname ;
   private String edtavValuecard3_Internalname ;
   private String edtavValuecard3_Jsonclick ;
   private String divCard4_Internalname ;
   private String edtavValuecard4_Internalname ;
   private String edtavValuecard4_Jsonclick ;
   private String divCard5_Internalname ;
   private String edtavValuecard5_Internalname ;
   private String edtavValuecard5_Jsonclick ;
   private String Dvpanel_tablenotifications_Internalname ;
   private String divTablenotifications_Internalname ;
   private String lblNotificationssubtitle_Internalname ;
   private String lblNotificationssubtitle_Caption ;
   private String lblNotificationssubtitle_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String Dvpanel_tablechart1_Internalname ;
   private String divTablechart1_Internalname ;
   private String divTablereport_Internalname ;
   private String lblCharttitle_Internalname ;
   private String lblCharttitle_Jsonclick ;
   private String Utchartsmootharea_Title ;
   private String Utchartsmootharea_Internalname ;
   private String divTablereportgoals_Internalname ;
   private String lblIndicatorstitle_Internalname ;
   private String lblIndicatorstitle_Jsonclick ;
   private String divTabletitle1_Internalname ;
   private String lblDescriptionprogressbar1_Internalname ;
   private String lblDescriptionprogressbar1_Jsonclick ;
   private String Progressbar1_Caption ;
   private String Progressbar1_Internalname ;
   private String divTabletitle2_Internalname ;
   private String lblDescriptionprogressbar2_Internalname ;
   private String lblDescriptionprogressbar2_Jsonclick ;
   private String Progressbar2_Caption ;
   private String Progressbar2_Internalname ;
   private String divTabletitle3_Internalname ;
   private String lblDescriptionprogressbar3_Internalname ;
   private String lblDescriptionprogressbar3_Jsonclick ;
   private String Progressbar3_Caption ;
   private String Progressbar3_Internalname ;
   private String divTabletitle4_Internalname ;
   private String lblDescriptionprogressbar4_Internalname ;
   private String lblDescriptionprogressbar4_Jsonclick ;
   private String Progressbar4_Caption ;
   private String Progressbar4_Internalname ;
   private String Dvpanel_tablechart4_Internalname ;
   private String divTablechart4_Internalname ;
   private String Utchartsmoothline_Title ;
   private String Utchartsmoothline_Internalname ;
   private String Dvpanel_tablechart3_Internalname ;
   private String divTablechart3_Internalname ;
   private String Utchartdoughnut_Title ;
   private String Utchartdoughnut_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavNotificationicon_Internalname ;
   private String edtavNumbersecondaryvalue1_Internalname ;
   private String edtavNumbersecondaryvalue2_Internalname ;
   private String edtavNumbersecondaryvalue3_Internalname ;
   private String edtavNumbersecondaryvalue4_Internalname ;
   private String edtavNumbersecondaryvalue5_Internalname ;
   private String edtavSdtnotificationsdata__notificationiconclass_Internalname ;
   private String edtavSdtnotificationsdata__notificationtitle_Internalname ;
   private String edtavSdtnotificationsdata__notificationdatetime_Internalname ;
   private String edtavValueprogressbar1_Internalname ;
   private String edtavTotalvalueprogressbar1_Internalname ;
   private String edtavValueprogressbar2_Internalname ;
   private String edtavTotalvalueprogressbar2_Internalname ;
   private String edtavValueprogressbar3_Internalname ;
   private String edtavTotalvalueprogressbar3_Internalname ;
   private String edtavValueprogressbar4_Internalname ;
   private String edtavTotalvalueprogressbar4_Internalname ;
   private String sGXsfl_147_fel_idx="0001" ;
   private String tblTabletotal4_Internalname ;
   private String edtavValueprogressbar4_Jsonclick ;
   private String lblSeparatorprogressbar4_Internalname ;
   private String lblSeparatorprogressbar4_Jsonclick ;
   private String edtavTotalvalueprogressbar4_Jsonclick ;
   private String tblTabletotal3_Internalname ;
   private String edtavValueprogressbar3_Jsonclick ;
   private String lblSeparatorprogressbar3_Internalname ;
   private String lblSeparatorprogressbar3_Jsonclick ;
   private String edtavTotalvalueprogressbar3_Jsonclick ;
   private String tblTabletotal2_Internalname ;
   private String edtavValueprogressbar2_Jsonclick ;
   private String lblSeparatorprogressbar2_Internalname ;
   private String lblSeparatorprogressbar2_Jsonclick ;
   private String edtavTotalvalueprogressbar2_Jsonclick ;
   private String tblTabletotal1_Internalname ;
   private String edtavValueprogressbar1_Jsonclick ;
   private String lblSeparatorprogressbar1_Internalname ;
   private String lblSeparatorprogressbar1_Jsonclick ;
   private String edtavTotalvalueprogressbar1_Jsonclick ;
   private String tblTablemergedmoreinfoiconcard5_Internalname ;
   private String lblMoreinfoiconcard5_Internalname ;
   private String lblMoreinfoiconcard5_Jsonclick ;
   private String edtavNumbersecondaryvalue5_Jsonclick ;
   private String lblMoreinfocard5caption_Internalname ;
   private String lblMoreinfocard5caption_Jsonclick ;
   private String tblTablemergedicon5_Internalname ;
   private String lblIcon5_Internalname ;
   private String lblIcon5_Jsonclick ;
   private String lblDescriptioncard5_Internalname ;
   private String lblDescriptioncard5_Jsonclick ;
   private String tblTablemergedmoreinfoiconcard4_Internalname ;
   private String lblMoreinfoiconcard4_Internalname ;
   private String lblMoreinfoiconcard4_Jsonclick ;
   private String edtavNumbersecondaryvalue4_Jsonclick ;
   private String lblMoreinfocard4caption_Internalname ;
   private String lblMoreinfocard4caption_Jsonclick ;
   private String tblTablemergedicon4_Internalname ;
   private String lblIcon4_Internalname ;
   private String lblIcon4_Jsonclick ;
   private String lblDescriptioncard4_Internalname ;
   private String lblDescriptioncard4_Jsonclick ;
   private String tblTablemergedmoreinfoiconcard3_Internalname ;
   private String lblMoreinfoiconcard3_Internalname ;
   private String lblMoreinfoiconcard3_Jsonclick ;
   private String edtavNumbersecondaryvalue3_Jsonclick ;
   private String lblMoreinfocard3caption_Internalname ;
   private String lblMoreinfocard3caption_Jsonclick ;
   private String tblTablemergedicon3_Internalname ;
   private String lblIcon3_Internalname ;
   private String lblIcon3_Jsonclick ;
   private String lblDescriptioncard3_Internalname ;
   private String lblDescriptioncard3_Jsonclick ;
   private String tblTablemergedmoreinfoiconcard2_Internalname ;
   private String lblMoreinfoiconcard2_Internalname ;
   private String lblMoreinfoiconcard2_Jsonclick ;
   private String edtavNumbersecondaryvalue2_Jsonclick ;
   private String lblMoreinfocard2caption_Internalname ;
   private String lblMoreinfocard2caption_Jsonclick ;
   private String tblTablemergedicon2_Internalname ;
   private String lblIcon2_Internalname ;
   private String lblIcon2_Jsonclick ;
   private String lblDescriptioncard2_Internalname ;
   private String lblDescriptioncard2_Jsonclick ;
   private String tblTablemergedmoreinfoiconcard1_Internalname ;
   private String lblMoreinfoiconcard1_Internalname ;
   private String lblMoreinfoiconcard1_Jsonclick ;
   private String edtavNumbersecondaryvalue1_Jsonclick ;
   private String lblMoreinfocard1caption_Internalname ;
   private String lblMoreinfocard1caption_Jsonclick ;
   private String tblTablemergedicon1_Internalname ;
   private String lblIcon1_Internalname ;
   private String lblIcon1_Jsonclick ;
   private String lblDescriptioncard1_Internalname ;
   private String lblDescriptioncard1_Jsonclick ;
   private String ROClassString ;
   private String edtavNotificationicon_Jsonclick ;
   private String edtavSdtnotificationsdata__notificationiconclass_Jsonclick ;
   private String edtavSdtnotificationsdata__notificationtitle_Jsonclick ;
   private String edtavSdtnotificationsdata__notificationdatetime_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_tablecards_Autowidth ;
   private boolean Dvpanel_tablecards_Autoheight ;
   private boolean Dvpanel_tablecards_Collapsible ;
   private boolean Dvpanel_tablecards_Collapsed ;
   private boolean Dvpanel_tablecards_Showcollapseicon ;
   private boolean Dvpanel_tablecards_Autoscroll ;
   private boolean Dvpanel_tablenotifications_Autowidth ;
   private boolean Dvpanel_tablenotifications_Autoheight ;
   private boolean Dvpanel_tablenotifications_Collapsible ;
   private boolean Dvpanel_tablenotifications_Collapsed ;
   private boolean Dvpanel_tablenotifications_Showcollapseicon ;
   private boolean Dvpanel_tablenotifications_Autoscroll ;
   private boolean Dvpanel_tablechart1_Autowidth ;
   private boolean Dvpanel_tablechart1_Autoheight ;
   private boolean Dvpanel_tablechart1_Collapsible ;
   private boolean Dvpanel_tablechart1_Collapsed ;
   private boolean Dvpanel_tablechart1_Showcollapseicon ;
   private boolean Dvpanel_tablechart1_Autoscroll ;
   private boolean Dvpanel_tablechart4_Autowidth ;
   private boolean Dvpanel_tablechart4_Autoheight ;
   private boolean Dvpanel_tablechart4_Collapsible ;
   private boolean Dvpanel_tablechart4_Collapsed ;
   private boolean Dvpanel_tablechart4_Showcollapseicon ;
   private boolean Dvpanel_tablechart4_Autoscroll ;
   private boolean Utchartdoughnut_Showvalues ;
   private boolean Dvpanel_tablechart3_Autowidth ;
   private boolean Dvpanel_tablechart3_Autoheight ;
   private boolean Dvpanel_tablechart3_Collapsible ;
   private boolean Dvpanel_tablechart3_Collapsed ;
   private boolean Dvpanel_tablechart3_Showcollapseicon ;
   private boolean Dvpanel_tablechart3_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_147_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV147 ;
   private String AV10ValueCard3 ;
   private String AV6NotificationIcon ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablecards ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablenotifications ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablechart1 ;
   private com.genexus.webpanels.GXUserControl ucUtchartsmootharea ;
   private com.genexus.webpanels.GXUserControl ucProgressbar1 ;
   private com.genexus.webpanels.GXUserControl ucProgressbar2 ;
   private com.genexus.webpanels.GXUserControl ucProgressbar3 ;
   private com.genexus.webpanels.GXUserControl ucProgressbar4 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablechart4 ;
   private com.genexus.webpanels.GXUserControl ucUtchartsmoothline ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablechart3 ;
   private com.genexus.webpanels.GXUserControl ucUtchartdoughnut ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> AV5HomeSampleData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[] ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> AV7SDTNotificationsData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> GXt_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem3 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> GXv_objcol_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem4[] ;
   private GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element> AV28Elements ;
   private GXBaseCollection<com.projectthani.SdtQueryViewerElements_Element> AV12Axes ;
   private GXBaseCollection<com.projectthani.SdtQueryViewerParameters_Parameter> AV29Parameters ;
   private com.projectthani.SdtQueryViewerElements_Element AV13Axis ;
   private com.projectthani.SdtQueryViewerItemClickData AV30ItemClickData ;
   private com.projectthani.SdtQueryViewerItemDoubleClickData AV31ItemDoubleClickData ;
   private com.projectthani.SdtQueryViewerDragAndDropData AV32DragAndDropData ;
   private com.projectthani.SdtQueryViewerFilterChangedData AV33FilterChangedData ;
   private com.projectthani.SdtQueryViewerItemExpandData AV34ItemExpandData ;
   private com.projectthani.SdtQueryViewerItemCollapseData AV35ItemCollapseData ;
}

