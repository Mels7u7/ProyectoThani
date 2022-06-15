package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pagoprompt_impl extends GXDataArea
{
   public pagoprompt_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pagoprompt_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagoprompt_impl.class ));
   }

   public pagoprompt_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPagoTipoDocumentoCliente = new HTMLChoice();
      cmbPagoTipoDocumento = new HTMLChoice();
      cmbPagoMoneda = new HTMLChoice();
      cmbPagoEstadoR = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "InOutPagoId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "InOutPagoId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "InOutPagoId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            nRC_GXsfl_24 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_24"))) ;
            nGXsfl_24_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_24_idx"))) ;
            sGXsfl_24_idx = httpContext.GetPar( "sGXsfl_24_idx") ;
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
            AV13FilterFullText = httpContext.GetPar( "FilterFullText") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
            AV8InOutPagoId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8InOutPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutPagoId), 8, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9InOutPagoMonto = CommonUtil.decimalVal( httpContext.GetPar( "InOutPagoMonto"), ".") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9InOutPagoMonto", GXutil.ltrimstr( AV9InOutPagoMonto, 6, 2));
            }
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.wwpbaseobjects.workwithplusmasterpageprompt");
         MasterPageObj.setDataArea(this,true);
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
      pa602( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start602( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034075", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.pagoprompt", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8InOutPagoId,8,0)),GXutil.URLEncode(DecimalUtil.decToString(AV9InOutPagoMonto))}, new String[] {"InOutPagoId","InOutPagoMonto"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV13FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_24", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_24, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV16GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV17GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV14DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV14DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV11OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV12OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINOUTPAGOID", GXutil.ltrim( localUtil.ntoc( AV8InOutPagoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINOUTPAGOMONTO", GXutil.ltrim( localUtil.ntoc( AV9InOutPagoMonto, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
      httpContext.writeTextNL( "</form>") ;
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we602( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt602( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.projectthani.pagoprompt", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8InOutPagoId,8,0)),GXutil.URLEncode(DecimalUtil.decToString(AV9InOutPagoMonto))}, new String[] {"InOutPagoId","InOutPagoMonto"})  ;
   }

   public String getPgmname( )
   {
      return "PagoPrompt" ;
   }

   public String getPgmdesc( )
   {
      return "Selecciona Pago" ;
   }

   public void wb600( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainPrompt", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs", "left", "top", "", "", "div");
         wb_table1_12_602( true) ;
      }
      else
      {
         wb_table1_12_602( false) ;
      }
      return  ;
   }

   public void wb_table1_12_602e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginPrompt GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"24\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cita Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cita Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Monto") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Token") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Documento Cliente") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cliente Denominacion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cliente Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cliente Email") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Numero") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Emision") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Moneda") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nubefact Request") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nubefact Response") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Request") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Response") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Pasarela Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Status Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Disponibilidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Enlace PDF") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Enlace XML") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado R") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridContainer.AddObjectProperty("GridName", "Grid");
         }
         else
         {
            if ( isAjaxCallMode( ) )
            {
               GridContainer = new com.genexus.webpanels.GXWebGrid(context);
            }
            else
            {
               GridContainer.Clear();
            }
            GridContainer.SetWrapped(nGXWrapped);
            GridContainer.AddObjectProperty("GridName", "Grid");
            GridContainer.AddObjectProperty("Header", subGrid_Header);
            GridContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("CmpContext", "");
            GridContainer.AddObjectProperty("InMasterPage", "false");
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18Select));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSelect_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A64CitaCode);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A243PagoToken);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A247PagoTipoDocumentoCliente));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A248PagoClienteNroDocumento);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A249PagoClienteDenominacion);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A250PagoClienteDireccion);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A251PagoClienteEmail);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A244PagoTipoDocumento, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A245PagoNumero, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A253PagoMoneda, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A256PagoNubefactRequest);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A257PagoNubefactResponse);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A308PagoRequest);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A309PagoResponse);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A310PagoPasarelaId);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A311PagoStatusCode, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A338PagoEnlacePDF);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPagoEnlacePDF_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtPagoEnlacePDF_Linktarget));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A339PagoEnlaceXML);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPagoEnlaceXML_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtPagoEnlaceXML_Linktarget));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A246PagoEstadoR));
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
      if ( wbEnd == 24 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_24 = (int)(nGXsfl_24_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV16GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV17GridPageCount);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
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
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV14DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 24 )
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

   public void start602( )
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
         Form.getMeta().addItem("description", "Selecciona Pago", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup600( ) ;
   }

   public void ws602( )
   {
      start602( ) ;
      evt602( ) ;
   }

   public void evt602( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11602 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12602 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13602 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCLEANFILTERS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCleanFilters' */
                           e14602 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) )
                        {
                           nGXsfl_24_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_242( ) ;
                           AV18Select = httpContext.cgiGet( edtavSelect_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavSelect_Internalname, AV18Select);
                           A47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoId_Internalname), ",", ".")) ;
                           A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
                           n19CitaId = false ;
                           A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
                           A66SGCitaDisponibilidadFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 0)) ;
                           n66SGCitaDisponibilidadFecha = false ;
                           A242PagoMonto = localUtil.ctond( httpContext.cgiGet( edtPagoMonto_Internalname)) ;
                           A243PagoToken = httpContext.cgiGet( edtPagoToken_Internalname) ;
                           cmbPagoTipoDocumentoCliente.setName( cmbPagoTipoDocumentoCliente.getInternalname() );
                           cmbPagoTipoDocumentoCliente.setValue( httpContext.cgiGet( cmbPagoTipoDocumentoCliente.getInternalname()) );
                           A247PagoTipoDocumentoCliente = httpContext.cgiGet( cmbPagoTipoDocumentoCliente.getInternalname()) ;
                           A248PagoClienteNroDocumento = httpContext.cgiGet( edtPagoClienteNroDocumento_Internalname) ;
                           A249PagoClienteDenominacion = httpContext.cgiGet( edtPagoClienteDenominacion_Internalname) ;
                           A250PagoClienteDireccion = httpContext.cgiGet( edtPagoClienteDireccion_Internalname) ;
                           A251PagoClienteEmail = httpContext.cgiGet( edtPagoClienteEmail_Internalname) ;
                           cmbPagoTipoDocumento.setName( cmbPagoTipoDocumento.getInternalname() );
                           cmbPagoTipoDocumento.setValue( httpContext.cgiGet( cmbPagoTipoDocumento.getInternalname()) );
                           A244PagoTipoDocumento = (short)(GXutil.lval( httpContext.cgiGet( cmbPagoTipoDocumento.getInternalname()))) ;
                           A245PagoNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoNumero_Internalname), ",", ".")) ;
                           A252PagoFechaEmision = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtPagoFechaEmision_Internalname), 0)) ;
                           cmbPagoMoneda.setName( cmbPagoMoneda.getInternalname() );
                           cmbPagoMoneda.setValue( httpContext.cgiGet( cmbPagoMoneda.getInternalname()) );
                           A253PagoMoneda = (short)(GXutil.lval( httpContext.cgiGet( cmbPagoMoneda.getInternalname()))) ;
                           A256PagoNubefactRequest = httpContext.cgiGet( edtPagoNubefactRequest_Internalname) ;
                           A257PagoNubefactResponse = httpContext.cgiGet( edtPagoNubefactResponse_Internalname) ;
                           A308PagoRequest = httpContext.cgiGet( edtPagoRequest_Internalname) ;
                           A309PagoResponse = httpContext.cgiGet( edtPagoResponse_Internalname) ;
                           A310PagoPasarelaId = httpContext.cgiGet( edtPagoPasarelaId_Internalname) ;
                           A311PagoStatusCode = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoStatusCode_Internalname), ",", ".")) ;
                           A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
                           n34DisponibilidadId = false ;
                           A338PagoEnlacePDF = httpContext.cgiGet( edtPagoEnlacePDF_Internalname) ;
                           A339PagoEnlaceXML = httpContext.cgiGet( edtPagoEnlaceXML_Internalname) ;
                           cmbPagoEstadoR.setName( cmbPagoEstadoR.getInternalname() );
                           cmbPagoEstadoR.setValue( httpContext.cgiGet( cmbPagoEstadoR.getInternalname()) );
                           A246PagoEstadoR = httpContext.cgiGet( cmbPagoEstadoR.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e15602 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e16602 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17602 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV13FilterFullText) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e18602 ();
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

   public void we602( )
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

   public void pa602( )
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
            GX_FocusControl = edtavFilterfulltext_Internalname ;
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
      subsflControlProps_242( ) ;
      while ( nGXsfl_24_idx <= nRC_GXsfl_24 )
      {
         sendrow_242( ) ;
         nGXsfl_24_idx = ((subGrid_Islastpage==1)&&(nGXsfl_24_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV13FilterFullText )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16602 ();
      GRID_nCurrentRecord = 0 ;
      rf602( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAGOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PAGOID", GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAGOMONTO", getSecureSignedToken( "", localUtil.format( A242PagoMonto, "ZZ9.99")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PAGOMONTO", GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ".", "")));
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
      rf602( ) ;
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
      edtavSelect_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSelect_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSelect_Enabled), 5, 0), !bGXsfl_24_Refreshing);
   }

   public void rf602( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(24) ;
      /* Execute user event: Refresh */
      e16602 ();
      nGXsfl_24_idx = 1 ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
      bGXsfl_24_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_242( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV13FilterFullText ,
                                              Integer.valueOf(A47PagoId) ,
                                              Integer.valueOf(A19CitaId) ,
                                              A64CitaCode ,
                                              A242PagoMonto ,
                                              A243PagoToken ,
                                              A247PagoTipoDocumentoCliente ,
                                              A248PagoClienteNroDocumento ,
                                              A249PagoClienteDenominacion ,
                                              A250PagoClienteDireccion ,
                                              A251PagoClienteEmail ,
                                              Short.valueOf(A244PagoTipoDocumento) ,
                                              Integer.valueOf(A245PagoNumero) ,
                                              Short.valueOf(A253PagoMoneda) ,
                                              A256PagoNubefactRequest ,
                                              A257PagoNubefactResponse ,
                                              A308PagoRequest ,
                                              A309PagoResponse ,
                                              A310PagoPasarelaId ,
                                              Integer.valueOf(A311PagoStatusCode) ,
                                              Integer.valueOf(A34DisponibilidadId) ,
                                              A338PagoEnlacePDF ,
                                              A339PagoEnlaceXML ,
                                              A246PagoEstadoR ,
                                              Short.valueOf(AV11OrderedBy) ,
                                              Boolean.valueOf(AV12OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         /* Using cursor H00602 */
         pr_default.execute(0, new Object[] {lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_24_idx = 1 ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A21SGCitaDisponibilidadId = H00602_A21SGCitaDisponibilidadId[0] ;
            A246PagoEstadoR = H00602_A246PagoEstadoR[0] ;
            A339PagoEnlaceXML = H00602_A339PagoEnlaceXML[0] ;
            A338PagoEnlacePDF = H00602_A338PagoEnlacePDF[0] ;
            A34DisponibilidadId = H00602_A34DisponibilidadId[0] ;
            n34DisponibilidadId = H00602_n34DisponibilidadId[0] ;
            A311PagoStatusCode = H00602_A311PagoStatusCode[0] ;
            A310PagoPasarelaId = H00602_A310PagoPasarelaId[0] ;
            A309PagoResponse = H00602_A309PagoResponse[0] ;
            A308PagoRequest = H00602_A308PagoRequest[0] ;
            A257PagoNubefactResponse = H00602_A257PagoNubefactResponse[0] ;
            A256PagoNubefactRequest = H00602_A256PagoNubefactRequest[0] ;
            A253PagoMoneda = H00602_A253PagoMoneda[0] ;
            A252PagoFechaEmision = H00602_A252PagoFechaEmision[0] ;
            A245PagoNumero = H00602_A245PagoNumero[0] ;
            A244PagoTipoDocumento = H00602_A244PagoTipoDocumento[0] ;
            A251PagoClienteEmail = H00602_A251PagoClienteEmail[0] ;
            A250PagoClienteDireccion = H00602_A250PagoClienteDireccion[0] ;
            A249PagoClienteDenominacion = H00602_A249PagoClienteDenominacion[0] ;
            A248PagoClienteNroDocumento = H00602_A248PagoClienteNroDocumento[0] ;
            A247PagoTipoDocumentoCliente = H00602_A247PagoTipoDocumentoCliente[0] ;
            A243PagoToken = H00602_A243PagoToken[0] ;
            A242PagoMonto = H00602_A242PagoMonto[0] ;
            A66SGCitaDisponibilidadFecha = H00602_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H00602_n66SGCitaDisponibilidadFecha[0] ;
            A64CitaCode = H00602_A64CitaCode[0] ;
            A19CitaId = H00602_A19CitaId[0] ;
            n19CitaId = H00602_n19CitaId[0] ;
            A47PagoId = H00602_A47PagoId[0] ;
            A21SGCitaDisponibilidadId = H00602_A21SGCitaDisponibilidadId[0] ;
            A64CitaCode = H00602_A64CitaCode[0] ;
            A66SGCitaDisponibilidadFecha = H00602_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H00602_n66SGCitaDisponibilidadFecha[0] ;
            e17602 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(24) ;
         wb600( ) ;
      }
      bGXsfl_24_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes602( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAGOID"+"_"+sGXsfl_24_idx, getSecureSignedToken( sGXsfl_24_idx, localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAGOMONTO"+"_"+sGXsfl_24_idx, getSecureSignedToken( sGXsfl_24_idx, localUtil.format( A242PagoMonto, "ZZ9.99")));
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
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV13FilterFullText ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A247PagoTipoDocumentoCliente ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A246PagoEstadoR ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      /* Using cursor H00603 */
      pr_default.execute(1, new Object[] {lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText});
      GRID_nRecordCount = H00603_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSelect_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSelect_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSelect_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup600( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15602 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV14DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_24"), ",", ".")) ;
         AV16GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV17GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
         AV13FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV13FilterFullText) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e15602 ();
      if (returnInSub) return;
   }

   public void e15602( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( "Selecciona Pago" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      if ( AV11OrderedBy < 1 )
      {
         AV11OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV14DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV14DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e16602( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      AV16GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GridCurrentPage), 10, 0));
      AV17GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GridPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   public void e11602( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV15PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV15PageToGo) ;
      }
   }

   public void e12602( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13602( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV11OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11OrderedBy), 4, 0));
         AV12OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12OrderedDsc", AV12OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e17602( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV18Select = "<i class=\"fas fa-check\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavSelect_Internalname, AV18Select);
      edtPagoEnlacePDF_Linktarget = "_blank" ;
      edtPagoEnlacePDF_Link = A338PagoEnlacePDF ;
      edtPagoEnlaceXML_Linktarget = "_blank" ;
      edtPagoEnlaceXML_Link = A339PagoEnlaceXML ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(24) ;
      }
      sendrow_242( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_24_Refreshing )
      {
         httpContext.doAjaxLoad(24, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e18602 ();
      if (returnInSub) return;
   }

   public void e18602( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8InOutPagoId = A47PagoId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8InOutPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutPagoId), 8, 0));
      AV9InOutPagoMonto = A242PagoMonto ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9InOutPagoMonto", GXutil.ltrimstr( AV9InOutPagoMonto, 6, 2));
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV8InOutPagoId),AV9InOutPagoMonto});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV8InOutPagoId","AV9InOutPagoMonto"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void e14602( )
   {
      /* 'DoCleanFilters' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CLEANFILTERS' */
      S122 ();
      if (returnInSub) return;
      subgrid_firstpage( ) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV11OrderedBy, 4, 0))+":"+(AV12OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV13FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
   }

   public void wb_table1_12_602( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTopPaddingTop10'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCleanfilters_Internalname, "<i class=\"fas fa-filter CleanFiltersIcon\"></i>", "", "", lblCleanfilters_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOCLEANFILTERS\\'."+"'", "", "TextBlock", 5, "Limpiar filtros", 1, 1, 0, (short)(1), "HLP_PagoPrompt.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, "Filter Full Text", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV13FilterFullText, GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,18);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_PagoPrompt.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_12_602e( true) ;
      }
      else
      {
         wb_table1_12_602e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8InOutPagoId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8InOutPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutPagoId), 8, 0));
      AV9InOutPagoMonto = (java.math.BigDecimal)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9InOutPagoMonto", GXutil.ltrimstr( AV9InOutPagoMonto, 6, 2));
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
      pa602( ) ;
      ws602( ) ;
      we602( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034198", true, true);
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
      httpContext.AddJavascriptSource("pagoprompt.js", "?2022511034198", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_242( )
   {
      edtavSelect_Internalname = "vSELECT_"+sGXsfl_24_idx ;
      edtPagoId_Internalname = "PAGOID_"+sGXsfl_24_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_24_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_24_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_24_idx ;
      edtPagoMonto_Internalname = "PAGOMONTO_"+sGXsfl_24_idx ;
      edtPagoToken_Internalname = "PAGOTOKEN_"+sGXsfl_24_idx ;
      cmbPagoTipoDocumentoCliente.setInternalname( "PAGOTIPODOCUMENTOCLIENTE_"+sGXsfl_24_idx );
      edtPagoClienteNroDocumento_Internalname = "PAGOCLIENTENRODOCUMENTO_"+sGXsfl_24_idx ;
      edtPagoClienteDenominacion_Internalname = "PAGOCLIENTEDENOMINACION_"+sGXsfl_24_idx ;
      edtPagoClienteDireccion_Internalname = "PAGOCLIENTEDIRECCION_"+sGXsfl_24_idx ;
      edtPagoClienteEmail_Internalname = "PAGOCLIENTEEMAIL_"+sGXsfl_24_idx ;
      cmbPagoTipoDocumento.setInternalname( "PAGOTIPODOCUMENTO_"+sGXsfl_24_idx );
      edtPagoNumero_Internalname = "PAGONUMERO_"+sGXsfl_24_idx ;
      edtPagoFechaEmision_Internalname = "PAGOFECHAEMISION_"+sGXsfl_24_idx ;
      cmbPagoMoneda.setInternalname( "PAGOMONEDA_"+sGXsfl_24_idx );
      edtPagoNubefactRequest_Internalname = "PAGONUBEFACTREQUEST_"+sGXsfl_24_idx ;
      edtPagoNubefactResponse_Internalname = "PAGONUBEFACTRESPONSE_"+sGXsfl_24_idx ;
      edtPagoRequest_Internalname = "PAGOREQUEST_"+sGXsfl_24_idx ;
      edtPagoResponse_Internalname = "PAGORESPONSE_"+sGXsfl_24_idx ;
      edtPagoPasarelaId_Internalname = "PAGOPASARELAID_"+sGXsfl_24_idx ;
      edtPagoStatusCode_Internalname = "PAGOSTATUSCODE_"+sGXsfl_24_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_24_idx ;
      edtPagoEnlacePDF_Internalname = "PAGOENLACEPDF_"+sGXsfl_24_idx ;
      edtPagoEnlaceXML_Internalname = "PAGOENLACEXML_"+sGXsfl_24_idx ;
      cmbPagoEstadoR.setInternalname( "PAGOESTADOR_"+sGXsfl_24_idx );
   }

   public void subsflControlProps_fel_242( )
   {
      edtavSelect_Internalname = "vSELECT_"+sGXsfl_24_fel_idx ;
      edtPagoId_Internalname = "PAGOID_"+sGXsfl_24_fel_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_24_fel_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_24_fel_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_24_fel_idx ;
      edtPagoMonto_Internalname = "PAGOMONTO_"+sGXsfl_24_fel_idx ;
      edtPagoToken_Internalname = "PAGOTOKEN_"+sGXsfl_24_fel_idx ;
      cmbPagoTipoDocumentoCliente.setInternalname( "PAGOTIPODOCUMENTOCLIENTE_"+sGXsfl_24_fel_idx );
      edtPagoClienteNroDocumento_Internalname = "PAGOCLIENTENRODOCUMENTO_"+sGXsfl_24_fel_idx ;
      edtPagoClienteDenominacion_Internalname = "PAGOCLIENTEDENOMINACION_"+sGXsfl_24_fel_idx ;
      edtPagoClienteDireccion_Internalname = "PAGOCLIENTEDIRECCION_"+sGXsfl_24_fel_idx ;
      edtPagoClienteEmail_Internalname = "PAGOCLIENTEEMAIL_"+sGXsfl_24_fel_idx ;
      cmbPagoTipoDocumento.setInternalname( "PAGOTIPODOCUMENTO_"+sGXsfl_24_fel_idx );
      edtPagoNumero_Internalname = "PAGONUMERO_"+sGXsfl_24_fel_idx ;
      edtPagoFechaEmision_Internalname = "PAGOFECHAEMISION_"+sGXsfl_24_fel_idx ;
      cmbPagoMoneda.setInternalname( "PAGOMONEDA_"+sGXsfl_24_fel_idx );
      edtPagoNubefactRequest_Internalname = "PAGONUBEFACTREQUEST_"+sGXsfl_24_fel_idx ;
      edtPagoNubefactResponse_Internalname = "PAGONUBEFACTRESPONSE_"+sGXsfl_24_fel_idx ;
      edtPagoRequest_Internalname = "PAGOREQUEST_"+sGXsfl_24_fel_idx ;
      edtPagoResponse_Internalname = "PAGORESPONSE_"+sGXsfl_24_fel_idx ;
      edtPagoPasarelaId_Internalname = "PAGOPASARELAID_"+sGXsfl_24_fel_idx ;
      edtPagoStatusCode_Internalname = "PAGOSTATUSCODE_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_24_fel_idx ;
      edtPagoEnlacePDF_Internalname = "PAGOENLACEPDF_"+sGXsfl_24_fel_idx ;
      edtPagoEnlaceXML_Internalname = "PAGOENLACEXML_"+sGXsfl_24_fel_idx ;
      cmbPagoEstadoR.setInternalname( "PAGOESTADOR_"+sGXsfl_24_fel_idx );
   }

   public void sendrow_242( )
   {
      subsflControlProps_242( ) ;
      wb600( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_24_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_24_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_24_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavSelect_Enabled!=0)&&(edtavSelect_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 25,'',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSelect_Internalname,GXutil.rtrim( AV18Select),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSelect_Enabled!=0)&&(edtavSelect_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,25);\"" : " "),"'"+""+"'"+",false,"+"'"+"EENTER."+sGXsfl_24_idx+"'","","","Seleccionar","",edtavSelect_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSelect_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoId_Internalname,GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaId_Internalname,GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaCode_Internalname,A64CitaCode,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadFecha_Internalname,localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"),localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoMonto_Internalname,GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A242PagoMonto, "ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoMonto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoToken_Internalname,A243PagoToken,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoToken_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPagoTipoDocumentoCliente.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOTIPODOCUMENTOCLIENTE_" + sGXsfl_24_idx ;
            cmbPagoTipoDocumentoCliente.setName( GXCCtl );
            cmbPagoTipoDocumentoCliente.setWebtags( "" );
            cmbPagoTipoDocumentoCliente.addItem("6", "RUC", (short)(0));
            cmbPagoTipoDocumentoCliente.addItem("1", "DNI", (short)(0));
            cmbPagoTipoDocumentoCliente.addItem("4", "CARNET DE EXT.", (short)(0));
            cmbPagoTipoDocumentoCliente.addItem("7", "PASAPORTE", (short)(0));
            cmbPagoTipoDocumentoCliente.addItem("A", "CDI", (short)(0));
            cmbPagoTipoDocumentoCliente.addItem("0", "NO DOMICILIADO", (short)(0));
            if ( cmbPagoTipoDocumentoCliente.getItemCount() > 0 )
            {
               A247PagoTipoDocumentoCliente = cmbPagoTipoDocumentoCliente.getValidValue(A247PagoTipoDocumentoCliente) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoTipoDocumentoCliente,cmbPagoTipoDocumentoCliente.getInternalname(),GXutil.rtrim( A247PagoTipoDocumentoCliente),Integer.valueOf(1),cmbPagoTipoDocumentoCliente.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoTipoDocumentoCliente.setValue( GXutil.rtrim( A247PagoTipoDocumentoCliente) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumentoCliente.getInternalname(), "Values", cmbPagoTipoDocumentoCliente.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteNroDocumento_Internalname,A248PagoClienteNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoClienteNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteDenominacion_Internalname,A249PagoClienteDenominacion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoClienteDenominacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteDireccion_Internalname,A250PagoClienteDireccion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoClienteDireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteEmail_Internalname,A251PagoClienteEmail,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A251PagoClienteEmail,"","","",edtPagoClienteEmail_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPagoTipoDocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOTIPODOCUMENTO_" + sGXsfl_24_idx ;
            cmbPagoTipoDocumento.setName( GXCCtl );
            cmbPagoTipoDocumento.setWebtags( "" );
            cmbPagoTipoDocumento.addItem("1", "Factura", (short)(0));
            cmbPagoTipoDocumento.addItem("2", "Boleta", (short)(0));
            cmbPagoTipoDocumento.addItem("3", "Nota Credito", (short)(0));
            cmbPagoTipoDocumento.addItem("4", "Nota Debito", (short)(0));
            if ( cmbPagoTipoDocumento.getItemCount() > 0 )
            {
               A244PagoTipoDocumento = (short)(GXutil.lval( cmbPagoTipoDocumento.getValidValue(GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoTipoDocumento,cmbPagoTipoDocumento.getInternalname(),GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)),Integer.valueOf(1),cmbPagoTipoDocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoTipoDocumento.setValue( GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumento.getInternalname(), "Values", cmbPagoTipoDocumento.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A245PagoNumero, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoFechaEmision_Internalname,localUtil.format(A252PagoFechaEmision, "99/99/9999"),localUtil.format( A252PagoFechaEmision, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoFechaEmision_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPagoMoneda.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOMONEDA_" + sGXsfl_24_idx ;
            cmbPagoMoneda.setName( GXCCtl );
            cmbPagoMoneda.setWebtags( "" );
            cmbPagoMoneda.addItem("1", "Soles", (short)(0));
            cmbPagoMoneda.addItem("2", "Dólares", (short)(0));
            cmbPagoMoneda.addItem("3", "Euros", (short)(0));
            if ( cmbPagoMoneda.getItemCount() > 0 )
            {
               A253PagoMoneda = (short)(GXutil.lval( cmbPagoMoneda.getValidValue(GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoMoneda,cmbPagoMoneda.getInternalname(),GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)),Integer.valueOf(1),cmbPagoMoneda.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoMoneda.setValue( GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoMoneda.getInternalname(), "Values", cmbPagoMoneda.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoNubefactRequest_Internalname,A256PagoNubefactRequest,A256PagoNubefactRequest,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoNubefactRequest_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoNubefactResponse_Internalname,A257PagoNubefactResponse,A257PagoNubefactResponse,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoNubefactResponse_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoRequest_Internalname,A308PagoRequest,A308PagoRequest,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoRequest_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoResponse_Internalname,A309PagoResponse,A309PagoResponse,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoResponse_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoPasarelaId_Internalname,A310PagoPasarelaId,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoPasarelaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoStatusCode_Internalname,GXutil.ltrim( localUtil.ntoc( A311PagoStatusCode, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoStatusCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoEnlacePDF_Internalname,A338PagoEnlacePDF,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPagoEnlacePDF_Link,edtPagoEnlacePDF_Linktarget,"","",edtPagoEnlacePDF_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoEnlaceXML_Internalname,A339PagoEnlaceXML,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPagoEnlaceXML_Link,edtPagoEnlaceXML_Linktarget,"","",edtPagoEnlaceXML_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPagoEstadoR.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOESTADOR_" + sGXsfl_24_idx ;
            cmbPagoEstadoR.setName( GXCCtl );
            cmbPagoEstadoR.setWebtags( "" );
            cmbPagoEstadoR.addItem("A", "Activo", (short)(0));
            cmbPagoEstadoR.addItem("I", "Inactivo", (short)(0));
            if ( cmbPagoEstadoR.getItemCount() > 0 )
            {
               A246PagoEstadoR = cmbPagoEstadoR.getValidValue(A246PagoEstadoR) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoEstadoR,cmbPagoEstadoR.getInternalname(),GXutil.rtrim( A246PagoEstadoR),Integer.valueOf(1),cmbPagoEstadoR.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoEstadoR.setValue( GXutil.rtrim( A246PagoEstadoR) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoEstadoR.getInternalname(), "Values", cmbPagoEstadoR.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         send_integrity_lvl_hashes602( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_24_idx = ((subGrid_Islastpage==1)&&(nGXsfl_24_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      /* End function sendrow_242 */
   }

   public void init_default_properties( )
   {
      lblCleanfilters_Internalname = "CLEANFILTERS" ;
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavSelect_Internalname = "vSELECT" ;
      edtPagoId_Internalname = "PAGOID" ;
      edtCitaId_Internalname = "CITAID" ;
      edtCitaCode_Internalname = "CITACODE" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtPagoMonto_Internalname = "PAGOMONTO" ;
      edtPagoToken_Internalname = "PAGOTOKEN" ;
      cmbPagoTipoDocumentoCliente.setInternalname( "PAGOTIPODOCUMENTOCLIENTE" );
      edtPagoClienteNroDocumento_Internalname = "PAGOCLIENTENRODOCUMENTO" ;
      edtPagoClienteDenominacion_Internalname = "PAGOCLIENTEDENOMINACION" ;
      edtPagoClienteDireccion_Internalname = "PAGOCLIENTEDIRECCION" ;
      edtPagoClienteEmail_Internalname = "PAGOCLIENTEEMAIL" ;
      cmbPagoTipoDocumento.setInternalname( "PAGOTIPODOCUMENTO" );
      edtPagoNumero_Internalname = "PAGONUMERO" ;
      edtPagoFechaEmision_Internalname = "PAGOFECHAEMISION" ;
      cmbPagoMoneda.setInternalname( "PAGOMONEDA" );
      edtPagoNubefactRequest_Internalname = "PAGONUBEFACTREQUEST" ;
      edtPagoNubefactResponse_Internalname = "PAGONUBEFACTRESPONSE" ;
      edtPagoRequest_Internalname = "PAGOREQUEST" ;
      edtPagoResponse_Internalname = "PAGORESPONSE" ;
      edtPagoPasarelaId_Internalname = "PAGOPASARELAID" ;
      edtPagoStatusCode_Internalname = "PAGOSTATUSCODE" ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID" ;
      edtPagoEnlacePDF_Internalname = "PAGOENLACEPDF" ;
      edtPagoEnlaceXML_Internalname = "PAGOENLACEXML" ;
      cmbPagoEstadoR.setInternalname( "PAGOESTADOR" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
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
      cmbPagoEstadoR.setJsonclick( "" );
      edtPagoEnlaceXML_Jsonclick = "" ;
      edtPagoEnlacePDF_Jsonclick = "" ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtPagoStatusCode_Jsonclick = "" ;
      edtPagoPasarelaId_Jsonclick = "" ;
      edtPagoResponse_Jsonclick = "" ;
      edtPagoRequest_Jsonclick = "" ;
      edtPagoNubefactResponse_Jsonclick = "" ;
      edtPagoNubefactRequest_Jsonclick = "" ;
      cmbPagoMoneda.setJsonclick( "" );
      edtPagoFechaEmision_Jsonclick = "" ;
      edtPagoNumero_Jsonclick = "" ;
      cmbPagoTipoDocumento.setJsonclick( "" );
      edtPagoClienteEmail_Jsonclick = "" ;
      edtPagoClienteDireccion_Jsonclick = "" ;
      edtPagoClienteDenominacion_Jsonclick = "" ;
      edtPagoClienteNroDocumento_Jsonclick = "" ;
      cmbPagoTipoDocumentoCliente.setJsonclick( "" );
      edtPagoToken_Jsonclick = "" ;
      edtPagoMonto_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaId_Jsonclick = "" ;
      edtPagoId_Jsonclick = "" ;
      edtavSelect_Jsonclick = "" ;
      edtavSelect_Visible = -1 ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtPagoEnlaceXML_Linktarget = "" ;
      edtPagoEnlaceXML_Link = "" ;
      edtPagoEnlacePDF_Linktarget = "" ;
      edtPagoEnlacePDF_Link = "" ;
      edtavSelect_Enabled = 1 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Selecciona Pago" );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|1|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25" ;
      Ddo_grid_Columnids = "1:PagoId|2:CitaId|3:CitaCode|4:SGCitaDisponibilidadFecha|5:PagoMonto|6:PagoToken|7:PagoTipoDocumentoCliente|8:PagoClienteNroDocumento|9:PagoClienteDenominacion|10:PagoClienteDireccion|11:PagoClienteEmail|12:PagoTipoDocumento|13:PagoNumero|14:PagoFechaEmision|15:PagoMoneda|16:PagoNubefactRequest|17:PagoNubefactResponse|18:PagoRequest|19:PagoResponse|20:PagoPasarelaId|21:PagoStatusCode|22:DisponibilidadId|23:PagoEnlacePDF|24:PagoEnlaceXML|25:PagoEstadoR" ;
      Ddo_grid_Gridinternalname = "" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      subGrid_Rows = 0 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "PAGOTIPODOCUMENTOCLIENTE_" + sGXsfl_24_idx ;
      cmbPagoTipoDocumentoCliente.setName( GXCCtl );
      cmbPagoTipoDocumentoCliente.setWebtags( "" );
      cmbPagoTipoDocumentoCliente.addItem("6", "RUC", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("1", "DNI", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("4", "CARNET DE EXT.", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("7", "PASAPORTE", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("A", "CDI", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("0", "NO DOMICILIADO", (short)(0));
      if ( cmbPagoTipoDocumentoCliente.getItemCount() > 0 )
      {
         A247PagoTipoDocumentoCliente = cmbPagoTipoDocumentoCliente.getValidValue(A247PagoTipoDocumentoCliente) ;
      }
      GXCCtl = "PAGOTIPODOCUMENTO_" + sGXsfl_24_idx ;
      cmbPagoTipoDocumento.setName( GXCCtl );
      cmbPagoTipoDocumento.setWebtags( "" );
      cmbPagoTipoDocumento.addItem("1", "Factura", (short)(0));
      cmbPagoTipoDocumento.addItem("2", "Boleta", (short)(0));
      cmbPagoTipoDocumento.addItem("3", "Nota Credito", (short)(0));
      cmbPagoTipoDocumento.addItem("4", "Nota Debito", (short)(0));
      if ( cmbPagoTipoDocumento.getItemCount() > 0 )
      {
         A244PagoTipoDocumento = (short)(GXutil.lval( cmbPagoTipoDocumento.getValidValue(GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0))))) ;
      }
      GXCCtl = "PAGOMONEDA_" + sGXsfl_24_idx ;
      cmbPagoMoneda.setName( GXCCtl );
      cmbPagoMoneda.setWebtags( "" );
      cmbPagoMoneda.addItem("1", "Soles", (short)(0));
      cmbPagoMoneda.addItem("2", "Dólares", (short)(0));
      cmbPagoMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbPagoMoneda.getItemCount() > 0 )
      {
         A253PagoMoneda = (short)(GXutil.lval( cmbPagoMoneda.getValidValue(GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0))))) ;
      }
      GXCCtl = "PAGOESTADOR_" + sGXsfl_24_idx ;
      cmbPagoEstadoR.setName( GXCCtl );
      cmbPagoEstadoR.setWebtags( "" );
      cmbPagoEstadoR.addItem("A", "Activo", (short)(0));
      cmbPagoEstadoR.addItem("I", "Inactivo", (short)(0));
      if ( cmbPagoEstadoR.getItemCount() > 0 )
      {
         A246PagoEstadoR = cmbPagoEstadoR.getValidValue(A246PagoEstadoR) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV16GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV17GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11602',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12602',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13602',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'AV11OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV12OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV11OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV12OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17602',iparms:[{av:'A338PagoEnlacePDF',fld:'PAGOENLACEPDF',pic:''},{av:'A339PagoEnlaceXML',fld:'PAGOENLACEXML',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV18Select',fld:'vSELECT',pic:''},{av:'edtPagoEnlacePDF_Linktarget',ctrl:'PAGOENLACEPDF',prop:'Linktarget'},{av:'edtPagoEnlacePDF_Link',ctrl:'PAGOENLACEPDF',prop:'Link'},{av:'edtPagoEnlaceXML_Linktarget',ctrl:'PAGOENLACEXML',prop:'Linktarget'},{av:'edtPagoEnlaceXML_Link',ctrl:'PAGOENLACEXML',prop:'Link'}]}");
      setEventMetadata("ENTER","{handler:'e18602',iparms:[{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9',hsh:true},{av:'A242PagoMonto',fld:'PAGOMONTO',pic:'ZZ9.99',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV8InOutPagoId',fld:'vINOUTPAGOID',pic:'ZZZZZZZ9'},{av:'AV9InOutPagoMonto',fld:'vINOUTPAGOMONTO',pic:'ZZ9.99'}]}");
      setEventMetadata("'DOCLEANFILTERS'","{handler:'e14602',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''}]");
      setEventMetadata("'DOCLEANFILTERS'",",oparms:[{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV16GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV17GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[]");
      setEventMetadata("VALID_CITAID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Pagoestador',iparms:[]");
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
      wcpOAV9InOutPagoMonto = DecimalUtil.ZERO ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13FilterFullText = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      AV9InOutPagoMonto = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV14DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV18Select = "" ;
      A64CitaCode = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      A246PagoEstadoR = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      lV13FilterFullText = "" ;
      H00602_A21SGCitaDisponibilidadId = new int[1] ;
      H00602_A246PagoEstadoR = new String[] {""} ;
      H00602_A339PagoEnlaceXML = new String[] {""} ;
      H00602_A338PagoEnlacePDF = new String[] {""} ;
      H00602_A34DisponibilidadId = new int[1] ;
      H00602_n34DisponibilidadId = new boolean[] {false} ;
      H00602_A311PagoStatusCode = new int[1] ;
      H00602_A310PagoPasarelaId = new String[] {""} ;
      H00602_A309PagoResponse = new String[] {""} ;
      H00602_A308PagoRequest = new String[] {""} ;
      H00602_A257PagoNubefactResponse = new String[] {""} ;
      H00602_A256PagoNubefactRequest = new String[] {""} ;
      H00602_A253PagoMoneda = new short[1] ;
      H00602_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      H00602_A245PagoNumero = new int[1] ;
      H00602_A244PagoTipoDocumento = new short[1] ;
      H00602_A251PagoClienteEmail = new String[] {""} ;
      H00602_A250PagoClienteDireccion = new String[] {""} ;
      H00602_A249PagoClienteDenominacion = new String[] {""} ;
      H00602_A248PagoClienteNroDocumento = new String[] {""} ;
      H00602_A247PagoTipoDocumentoCliente = new String[] {""} ;
      H00602_A243PagoToken = new String[] {""} ;
      H00602_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00602_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00602_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H00602_A64CitaCode = new String[] {""} ;
      H00602_A19CitaId = new int[1] ;
      H00602_n19CitaId = new boolean[] {false} ;
      H00602_A47PagoId = new int[1] ;
      H00603_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      lblCleanfilters_Jsonclick = "" ;
      TempTags = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagoprompt__default(),
         new Object[] {
             new Object[] {
            H00602_A21SGCitaDisponibilidadId, H00602_A246PagoEstadoR, H00602_A339PagoEnlaceXML, H00602_A338PagoEnlacePDF, H00602_A34DisponibilidadId, H00602_n34DisponibilidadId, H00602_A311PagoStatusCode, H00602_A310PagoPasarelaId, H00602_A309PagoResponse, H00602_A308PagoRequest,
            H00602_A257PagoNubefactResponse, H00602_A256PagoNubefactRequest, H00602_A253PagoMoneda, H00602_A252PagoFechaEmision, H00602_A245PagoNumero, H00602_A244PagoTipoDocumento, H00602_A251PagoClienteEmail, H00602_A250PagoClienteDireccion, H00602_A249PagoClienteDenominacion, H00602_A248PagoClienteNroDocumento,
            H00602_A247PagoTipoDocumentoCliente, H00602_A243PagoToken, H00602_A242PagoMonto, H00602_A66SGCitaDisponibilidadFecha, H00602_n66SGCitaDisponibilidadFecha, H00602_A64CitaCode, H00602_A19CitaId, H00602_n19CitaId, H00602_A47PagoId
            }
            , new Object[] {
            H00603_AGRID_nRecordCount
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSelect_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV11OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8InOutPagoId ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_24 ;
   private int nGXsfl_24_idx=1 ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Pagestoshow ;
   private int AV8InOutPagoId ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavSelect_Enabled ;
   private int A47PagoId ;
   private int A19CitaId ;
   private int A245PagoNumero ;
   private int A311PagoStatusCode ;
   private int A34DisponibilidadId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int A21SGCitaDisponibilidadId ;
   private int AV15PageToGo ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int edtavSelect_Visible ;
   private long GRID_nFirstRecordOnPage ;
   private long AV16GridCurrentPage ;
   private long AV17GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal wcpOAV9InOutPagoMonto ;
   private java.math.BigDecimal AV9InOutPagoMonto ;
   private java.math.BigDecimal A242PagoMonto ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_24_idx="0001" ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String AV18Select ;
   private String A247PagoTipoDocumentoCliente ;
   private String edtPagoEnlacePDF_Link ;
   private String edtPagoEnlacePDF_Linktarget ;
   private String edtPagoEnlaceXML_Link ;
   private String edtPagoEnlaceXML_Linktarget ;
   private String A246PagoEstadoR ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSelect_Internalname ;
   private String edtPagoId_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtCitaCode_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtPagoMonto_Internalname ;
   private String edtPagoToken_Internalname ;
   private String edtPagoClienteNroDocumento_Internalname ;
   private String edtPagoClienteDenominacion_Internalname ;
   private String edtPagoClienteDireccion_Internalname ;
   private String edtPagoClienteEmail_Internalname ;
   private String edtPagoNumero_Internalname ;
   private String edtPagoFechaEmision_Internalname ;
   private String edtPagoNubefactRequest_Internalname ;
   private String edtPagoNubefactResponse_Internalname ;
   private String edtPagoRequest_Internalname ;
   private String edtPagoResponse_Internalname ;
   private String edtPagoPasarelaId_Internalname ;
   private String edtPagoStatusCode_Internalname ;
   private String edtDisponibilidadId_Internalname ;
   private String edtPagoEnlacePDF_Internalname ;
   private String edtPagoEnlaceXML_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String tblTablefilters_Internalname ;
   private String lblCleanfilters_Internalname ;
   private String lblCleanfilters_Jsonclick ;
   private String TempTags ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_24_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavSelect_Jsonclick ;
   private String edtPagoId_Jsonclick ;
   private String edtCitaId_Jsonclick ;
   private String edtCitaCode_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtPagoMonto_Jsonclick ;
   private String edtPagoToken_Jsonclick ;
   private String GXCCtl ;
   private String edtPagoClienteNroDocumento_Jsonclick ;
   private String edtPagoClienteDenominacion_Jsonclick ;
   private String edtPagoClienteDireccion_Jsonclick ;
   private String edtPagoClienteEmail_Jsonclick ;
   private String edtPagoNumero_Jsonclick ;
   private String edtPagoFechaEmision_Jsonclick ;
   private String edtPagoNubefactRequest_Jsonclick ;
   private String edtPagoNubefactResponse_Jsonclick ;
   private String edtPagoRequest_Jsonclick ;
   private String edtPagoResponse_Jsonclick ;
   private String edtPagoPasarelaId_Jsonclick ;
   private String edtPagoStatusCode_Jsonclick ;
   private String edtDisponibilidadId_Jsonclick ;
   private String edtPagoEnlacePDF_Jsonclick ;
   private String edtPagoEnlaceXML_Jsonclick ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean AV12OrderedDsc ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n19CitaId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n34DisponibilidadId ;
   private boolean bGXsfl_24_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String AV13FilterFullText ;
   private String A64CitaCode ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String lV13FilterFullText ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbPagoTipoDocumentoCliente ;
   private HTMLChoice cmbPagoTipoDocumento ;
   private HTMLChoice cmbPagoMoneda ;
   private HTMLChoice cmbPagoEstadoR ;
   private IDataStoreProvider pr_default ;
   private int[] H00602_A21SGCitaDisponibilidadId ;
   private String[] H00602_A246PagoEstadoR ;
   private String[] H00602_A339PagoEnlaceXML ;
   private String[] H00602_A338PagoEnlacePDF ;
   private int[] H00602_A34DisponibilidadId ;
   private boolean[] H00602_n34DisponibilidadId ;
   private int[] H00602_A311PagoStatusCode ;
   private String[] H00602_A310PagoPasarelaId ;
   private String[] H00602_A309PagoResponse ;
   private String[] H00602_A308PagoRequest ;
   private String[] H00602_A257PagoNubefactResponse ;
   private String[] H00602_A256PagoNubefactRequest ;
   private short[] H00602_A253PagoMoneda ;
   private java.util.Date[] H00602_A252PagoFechaEmision ;
   private int[] H00602_A245PagoNumero ;
   private short[] H00602_A244PagoTipoDocumento ;
   private String[] H00602_A251PagoClienteEmail ;
   private String[] H00602_A250PagoClienteDireccion ;
   private String[] H00602_A249PagoClienteDenominacion ;
   private String[] H00602_A248PagoClienteNroDocumento ;
   private String[] H00602_A247PagoTipoDocumentoCliente ;
   private String[] H00602_A243PagoToken ;
   private java.math.BigDecimal[] H00602_A242PagoMonto ;
   private java.util.Date[] H00602_A66SGCitaDisponibilidadFecha ;
   private boolean[] H00602_n66SGCitaDisponibilidadFecha ;
   private String[] H00602_A64CitaCode ;
   private int[] H00602_A19CitaId ;
   private boolean[] H00602_n19CitaId ;
   private int[] H00602_A47PagoId ;
   private long[] H00603_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV14DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class pagoprompt__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00602( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13FilterFullText ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A247PagoTipoDocumentoCliente ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          short A244PagoTipoDocumento ,
                                          int A245PagoNumero ,
                                          short A253PagoMoneda ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          String A246PagoEstadoR ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[37];
      Object[] GXv_Object5 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoPasarelaId]," ;
      sSelectString += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoFechaEmision], T1.[PagoNumero], T1.[PagoTipoDocumento]," ;
      sSelectString += " T1.[PagoClienteEmail], T1.[PagoClienteDireccion], T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T1.[PagoMonto]," ;
      sSelectString += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[CitaCode], T1.[CitaId], T1.[PagoId]" ;
      sFromString = " FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
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
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
         GXv_int4[19] = (byte)(1) ;
         GXv_int4[20] = (byte)(1) ;
         GXv_int4[21] = (byte)(1) ;
         GXv_int4[22] = (byte)(1) ;
         GXv_int4[23] = (byte)(1) ;
         GXv_int4[24] = (byte)(1) ;
         GXv_int4[25] = (byte)(1) ;
         GXv_int4[26] = (byte)(1) ;
         GXv_int4[27] = (byte)(1) ;
         GXv_int4[28] = (byte)(1) ;
         GXv_int4[29] = (byte)(1) ;
         GXv_int4[30] = (byte)(1) ;
         GXv_int4[31] = (byte)(1) ;
         GXv_int4[32] = (byte)(1) ;
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoMonto]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoMonto] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[CitaCode]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[CitaCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadFecha]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoToken]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoToken] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumentoCliente]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumentoCliente] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDenominacion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDenominacion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteEmail]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteEmail] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoNumero]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoNumero] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoFechaEmision]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoFechaEmision] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoMoneda]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoMoneda] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactRequest]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactRequest] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactResponse]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactResponse] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoRequest]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoRequest] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoResponse]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoResponse] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoPasarelaId]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoPasarelaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoStatusCode]" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoStatusCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoEnlacePDF]" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoEnlacePDF] DESC" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoEnlaceXML]" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoEnlaceXML] DESC" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoEstadoR]" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoEstadoR] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[PagoId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_H00603( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13FilterFullText ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A247PagoTipoDocumentoCliente ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          short A244PagoTipoDocumento ,
                                          int A245PagoNumero ,
                                          short A253PagoMoneda ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          String A246PagoEstadoR ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[34];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
         GXv_int6[4] = (byte)(1) ;
         GXv_int6[5] = (byte)(1) ;
         GXv_int6[6] = (byte)(1) ;
         GXv_int6[7] = (byte)(1) ;
         GXv_int6[8] = (byte)(1) ;
         GXv_int6[9] = (byte)(1) ;
         GXv_int6[10] = (byte)(1) ;
         GXv_int6[11] = (byte)(1) ;
         GXv_int6[12] = (byte)(1) ;
         GXv_int6[13] = (byte)(1) ;
         GXv_int6[14] = (byte)(1) ;
         GXv_int6[15] = (byte)(1) ;
         GXv_int6[16] = (byte)(1) ;
         GXv_int6[17] = (byte)(1) ;
         GXv_int6[18] = (byte)(1) ;
         GXv_int6[19] = (byte)(1) ;
         GXv_int6[20] = (byte)(1) ;
         GXv_int6[21] = (byte)(1) ;
         GXv_int6[22] = (byte)(1) ;
         GXv_int6[23] = (byte)(1) ;
         GXv_int6[24] = (byte)(1) ;
         GXv_int6[25] = (byte)(1) ;
         GXv_int6[26] = (byte)(1) ;
         GXv_int6[27] = (byte)(1) ;
         GXv_int6[28] = (byte)(1) ;
         GXv_int6[29] = (byte)(1) ;
         GXv_int6[30] = (byte)(1) ;
         GXv_int6[31] = (byte)(1) ;
         GXv_int6[32] = (byte)(1) ;
         GXv_int6[33] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 23 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 24 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 25 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_H00602(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
            case 1 :
                  return conditional_H00603(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00602", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00603", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((short[]) buf[15])[0] = rslt.getShort(15);
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((String[]) buf[18])[0] = rslt.getVarchar(18);
               ((String[]) buf[19])[0] = rslt.getVarchar(19);
               ((String[]) buf[20])[0] = rslt.getString(20, 1);
               ((String[]) buf[21])[0] = rslt.getVarchar(21);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(22,2);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((int[]) buf[26])[0] = rslt.getInt(25);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((int[]) buf[28])[0] = rslt.getInt(26);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[71]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[72]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[73]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               return;
      }
   }

}

