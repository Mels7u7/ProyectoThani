package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidadprompt_impl extends GXDataArea
{
   public disponibilidadprompt_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidadprompt_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadprompt_impl.class ));
   }

   public disponibilidadprompt_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDisponibilidadEstado = new HTMLChoice();
      cmbDisponibilidadEstadoCita = new HTMLChoice();
      cmbDisponibilidadTipoCita = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "InOutDisponibilidadId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "InOutDisponibilidadId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "InOutDisponibilidadId") ;
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
            AV12FilterFullText = httpContext.GetPar( "FilterFullText") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV12FilterFullText) ;
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
            AV8InOutDisponibilidadId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8InOutDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutDisponibilidadId), 8, 0));
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
      pa5T2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start5T2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110335815", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.disponibilidadprompt", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8InOutDisponibilidadId,8,0))}, new String[] {"InOutDisponibilidadId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV12FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_24", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_24, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV15GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV16GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV13DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV13DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV10OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV11OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINOUTDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV8InOutDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
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
         we5T2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt5T2( ) ;
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
      return formatLink("com.projectthani.disponibilidadprompt", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8InOutDisponibilidadId,8,0))}, new String[] {"InOutDisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "DisponibilidadPrompt" ;
   }

   public String getPgmdesc( )
   {
      return "Selecciona Disponibilidad" ;
   }

   public void wb5T0( )
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
         wb_table1_12_5T2( true) ;
      }
      else
      {
         wb_table1_12_5T2( false) ;
      }
      return  ;
   }

   public void wb_table1_12_5T2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Description") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Completo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "CMP") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hora Inicio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hora Fin") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Codigo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "User") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Cita") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV17Select));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSelect_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A133EventId));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A134DisponibilidadDescription);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A85ProfesionalApellidoPaterno);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A86ProfesionalApellidoMaterno);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A84ProfesionalNombres);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A83ProfesionalNombreCompleto);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A88ProfesionalCOP);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A140EspecialidadCodigo);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A71EspecialidadNombre);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A137DisponibilidadUser, (byte)(6), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A136DisponibilidadEstado));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A139DisponibilidadEstadoCita);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A298DisponibilidadTipoCita));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV15GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV16GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV13DDO_TitleSettingsIcons);
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

   public void start5T2( )
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
         Form.getMeta().addItem("description", "Selecciona Disponibilidad", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup5T0( ) ;
   }

   public void ws5T2( )
   {
      start5T2( ) ;
      evt5T2( ) ;
   }

   public void evt5T2( )
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
                           e115T2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e125T2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e135T2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCLEANFILTERS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCleanFilters' */
                           e145T2 ();
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
                           AV17Select = httpContext.cgiGet( edtavSelect_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavSelect_Internalname, AV17Select);
                           A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
                           A133EventId = httpContext.cgiGet( edtEventId_Internalname) ;
                           A134DisponibilidadDescription = httpContext.cgiGet( edtDisponibilidadDescription_Internalname) ;
                           A31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".")) ;
                           A85ProfesionalApellidoPaterno = httpContext.cgiGet( edtProfesionalApellidoPaterno_Internalname) ;
                           A86ProfesionalApellidoMaterno = httpContext.cgiGet( edtProfesionalApellidoMaterno_Internalname) ;
                           A84ProfesionalNombres = httpContext.cgiGet( edtProfesionalNombres_Internalname) ;
                           A83ProfesionalNombreCompleto = httpContext.cgiGet( edtProfesionalNombreCompleto_Internalname) ;
                           A88ProfesionalCOP = httpContext.cgiGet( edtProfesionalCOP_Internalname) ;
                           A67DisponibilidadFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadFecha_Internalname), 0)) ;
                           n67DisponibilidadFecha = false ;
                           A69DisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraInicio_Internalname), 0)) ;
                           n69DisponibilidadHoraInicio = false ;
                           A135DisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraFin_Internalname), 0)) ;
                           n135DisponibilidadHoraFin = false ;
                           A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
                           A140EspecialidadCodigo = httpContext.cgiGet( edtEspecialidadCodigo_Internalname) ;
                           A71EspecialidadNombre = httpContext.cgiGet( edtEspecialidadNombre_Internalname) ;
                           A137DisponibilidadUser = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadUser_Internalname), ",", ".")) ;
                           cmbDisponibilidadEstado.setName( cmbDisponibilidadEstado.getInternalname() );
                           cmbDisponibilidadEstado.setValue( httpContext.cgiGet( cmbDisponibilidadEstado.getInternalname()) );
                           A136DisponibilidadEstado = httpContext.cgiGet( cmbDisponibilidadEstado.getInternalname()) ;
                           cmbDisponibilidadEstadoCita.setName( cmbDisponibilidadEstadoCita.getInternalname() );
                           cmbDisponibilidadEstadoCita.setValue( httpContext.cgiGet( cmbDisponibilidadEstadoCita.getInternalname()) );
                           A139DisponibilidadEstadoCita = httpContext.cgiGet( cmbDisponibilidadEstadoCita.getInternalname()) ;
                           A138DCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtDCitaId_Internalname), ",", ".")) ;
                           n138DCitaId = false ;
                           cmbDisponibilidadTipoCita.setName( cmbDisponibilidadTipoCita.getInternalname() );
                           cmbDisponibilidadTipoCita.setValue( httpContext.cgiGet( cmbDisponibilidadTipoCita.getInternalname()) );
                           A298DisponibilidadTipoCita = httpContext.cgiGet( cmbDisponibilidadTipoCita.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e155T2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e165T2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e175T2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV12FilterFullText) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e185T2 ();
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

   public void we5T2( )
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

   public void pa5T2( )
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
                                 String AV12FilterFullText )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e165T2 ();
      GRID_nCurrentRecord = 0 ;
      rf5T2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_DISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
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
      rf5T2( ) ;
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

   public void rf5T2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(24) ;
      /* Execute user event: Refresh */
      e165T2 ();
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
                                              Short.valueOf(AV10OrderedBy) ,
                                              Boolean.valueOf(AV11OrderedDsc) ,
                                              AV12FilterFullText ,
                                              Integer.valueOf(A34DisponibilidadId) ,
                                              A133EventId ,
                                              A134DisponibilidadDescription ,
                                              Integer.valueOf(A31ProfesionalId) ,
                                              A85ProfesionalApellidoPaterno ,
                                              A86ProfesionalApellidoMaterno ,
                                              A84ProfesionalNombres ,
                                              A83ProfesionalNombreCompleto ,
                                              A88ProfesionalCOP ,
                                              Short.valueOf(A32EspecialidadId) ,
                                              A140EspecialidadCodigo ,
                                              A71EspecialidadNombre ,
                                              Integer.valueOf(A137DisponibilidadUser) ,
                                              A136DisponibilidadEstado ,
                                              A139DisponibilidadEstadoCita ,
                                              Integer.valueOf(A138DCitaId) ,
                                              A298DisponibilidadTipoCita } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING
                                              }
         });
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
         /* Using cursor H005T3 */
         pr_default.execute(0, new Object[] {AV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_24_idx = 1 ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A298DisponibilidadTipoCita = H005T3_A298DisponibilidadTipoCita[0] ;
            A139DisponibilidadEstadoCita = H005T3_A139DisponibilidadEstadoCita[0] ;
            A136DisponibilidadEstado = H005T3_A136DisponibilidadEstado[0] ;
            A137DisponibilidadUser = H005T3_A137DisponibilidadUser[0] ;
            A71EspecialidadNombre = H005T3_A71EspecialidadNombre[0] ;
            A140EspecialidadCodigo = H005T3_A140EspecialidadCodigo[0] ;
            A32EspecialidadId = H005T3_A32EspecialidadId[0] ;
            A135DisponibilidadHoraFin = H005T3_A135DisponibilidadHoraFin[0] ;
            n135DisponibilidadHoraFin = H005T3_n135DisponibilidadHoraFin[0] ;
            A69DisponibilidadHoraInicio = H005T3_A69DisponibilidadHoraInicio[0] ;
            n69DisponibilidadHoraInicio = H005T3_n69DisponibilidadHoraInicio[0] ;
            A67DisponibilidadFecha = H005T3_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = H005T3_n67DisponibilidadFecha[0] ;
            A88ProfesionalCOP = H005T3_A88ProfesionalCOP[0] ;
            A83ProfesionalNombreCompleto = H005T3_A83ProfesionalNombreCompleto[0] ;
            A31ProfesionalId = H005T3_A31ProfesionalId[0] ;
            A134DisponibilidadDescription = H005T3_A134DisponibilidadDescription[0] ;
            A133EventId = H005T3_A133EventId[0] ;
            A34DisponibilidadId = H005T3_A34DisponibilidadId[0] ;
            A138DCitaId = H005T3_A138DCitaId[0] ;
            n138DCitaId = H005T3_n138DCitaId[0] ;
            A84ProfesionalNombres = H005T3_A84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H005T3_A85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H005T3_A86ProfesionalApellidoMaterno[0] ;
            A71EspecialidadNombre = H005T3_A71EspecialidadNombre[0] ;
            A140EspecialidadCodigo = H005T3_A140EspecialidadCodigo[0] ;
            A88ProfesionalCOP = H005T3_A88ProfesionalCOP[0] ;
            A84ProfesionalNombres = H005T3_A84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H005T3_A85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H005T3_A86ProfesionalApellidoMaterno[0] ;
            A138DCitaId = H005T3_A138DCitaId[0] ;
            n138DCitaId = H005T3_n138DCitaId[0] ;
            e175T2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(24) ;
         wb5T0( ) ;
      }
      bGXsfl_24_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes5T2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_DISPONIBILIDADID"+"_"+sGXsfl_24_idx, getSecureSignedToken( sGXsfl_24_idx, localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")));
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
                                           Short.valueOf(AV10OrderedBy) ,
                                           Boolean.valueOf(AV11OrderedDsc) ,
                                           AV12FilterFullText ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A83ProfesionalNombreCompleto ,
                                           A88ProfesionalCOP ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           A136DisponibilidadEstado ,
                                           A139DisponibilidadEstadoCita ,
                                           Integer.valueOf(A138DCitaId) ,
                                           A298DisponibilidadTipoCita } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING
                                           }
      });
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      lV12FilterFullText = GXutil.concat( GXutil.rtrim( AV12FilterFullText), "%", "") ;
      /* Using cursor H005T5 */
      pr_default.execute(1, new Object[] {AV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText, lV12FilterFullText});
      GRID_nRecordCount = H005T5_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV12FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV12FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV12FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV12FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV12FilterFullText) ;
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

   public void strup5T0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e155T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV13DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_24"), ",", ".")) ;
         AV15GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV16GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
         AV12FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12FilterFullText", AV12FilterFullText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV12FilterFullText) != 0 )
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
      e155T2 ();
      if (returnInSub) return;
   }

   public void e155T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( "Selecciona Disponibilidad" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      if ( AV10OrderedBy < 1 )
      {
         AV10OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV13DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV13DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e165T2( )
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
      AV15GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GridCurrentPage), 10, 0));
      AV16GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GridPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   public void e115T2( )
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
         AV14PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV14PageToGo) ;
      }
   }

   public void e125T2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e135T2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV10OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10OrderedBy), 4, 0));
         AV11OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OrderedDsc", AV11OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e175T2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV17Select = "<i class=\"fas fa-check\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavSelect_Internalname, AV17Select);
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
      e185T2 ();
      if (returnInSub) return;
   }

   public void e185T2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8InOutDisponibilidadId = A34DisponibilidadId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8InOutDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutDisponibilidadId), 8, 0));
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV8InOutDisponibilidadId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV8InOutDisponibilidadId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void e145T2( )
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
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV10OrderedBy, 4, 0))+":"+(AV11OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV12FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12FilterFullText", AV12FilterFullText);
   }

   public void wb_table1_12_5T2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTopPaddingTop10'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCleanfilters_Internalname, "<i class=\"fas fa-filter CleanFiltersIcon\"></i>", "", "", lblCleanfilters_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOCLEANFILTERS\\'."+"'", "", "TextBlock", 5, "Limpiar filtros", 1, 1, 0, (short)(1), "HLP_DisponibilidadPrompt.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, "Filter Full Text", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV12FilterFullText, GXutil.rtrim( localUtil.format( AV12FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,18);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_DisponibilidadPrompt.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_12_5T2e( true) ;
      }
      else
      {
         wb_table1_12_5T2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8InOutDisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8InOutDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutDisponibilidadId), 8, 0));
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
      pa5T2( ) ;
      ws5T2( ) ;
      we5T2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335934", true, true);
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
      httpContext.AddJavascriptSource("disponibilidadprompt.js", "?20225110335934", false, true);
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
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_24_idx ;
      edtEventId_Internalname = "EVENTID_"+sGXsfl_24_idx ;
      edtDisponibilidadDescription_Internalname = "DISPONIBILIDADDESCRIPTION_"+sGXsfl_24_idx ;
      edtProfesionalId_Internalname = "PROFESIONALID_"+sGXsfl_24_idx ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO_"+sGXsfl_24_idx ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO_"+sGXsfl_24_idx ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES_"+sGXsfl_24_idx ;
      edtProfesionalNombreCompleto_Internalname = "PROFESIONALNOMBRECOMPLETO_"+sGXsfl_24_idx ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP_"+sGXsfl_24_idx ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA_"+sGXsfl_24_idx ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO_"+sGXsfl_24_idx ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN_"+sGXsfl_24_idx ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_24_idx ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO_"+sGXsfl_24_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_24_idx ;
      edtDisponibilidadUser_Internalname = "DISPONIBILIDADUSER_"+sGXsfl_24_idx ;
      cmbDisponibilidadEstado.setInternalname( "DISPONIBILIDADESTADO_"+sGXsfl_24_idx );
      cmbDisponibilidadEstadoCita.setInternalname( "DISPONIBILIDADESTADOCITA_"+sGXsfl_24_idx );
      edtDCitaId_Internalname = "DCITAID_"+sGXsfl_24_idx ;
      cmbDisponibilidadTipoCita.setInternalname( "DISPONIBILIDADTIPOCITA_"+sGXsfl_24_idx );
   }

   public void subsflControlProps_fel_242( )
   {
      edtavSelect_Internalname = "vSELECT_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_24_fel_idx ;
      edtEventId_Internalname = "EVENTID_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadDescription_Internalname = "DISPONIBILIDADDESCRIPTION_"+sGXsfl_24_fel_idx ;
      edtProfesionalId_Internalname = "PROFESIONALID_"+sGXsfl_24_fel_idx ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO_"+sGXsfl_24_fel_idx ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO_"+sGXsfl_24_fel_idx ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES_"+sGXsfl_24_fel_idx ;
      edtProfesionalNombreCompleto_Internalname = "PROFESIONALNOMBRECOMPLETO_"+sGXsfl_24_fel_idx ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN_"+sGXsfl_24_fel_idx ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_24_fel_idx ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO_"+sGXsfl_24_fel_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_24_fel_idx ;
      edtDisponibilidadUser_Internalname = "DISPONIBILIDADUSER_"+sGXsfl_24_fel_idx ;
      cmbDisponibilidadEstado.setInternalname( "DISPONIBILIDADESTADO_"+sGXsfl_24_fel_idx );
      cmbDisponibilidadEstadoCita.setInternalname( "DISPONIBILIDADESTADOCITA_"+sGXsfl_24_fel_idx );
      edtDCitaId_Internalname = "DCITAID_"+sGXsfl_24_fel_idx ;
      cmbDisponibilidadTipoCita.setInternalname( "DISPONIBILIDADTIPOCITA_"+sGXsfl_24_fel_idx );
   }

   public void sendrow_242( )
   {
      subsflControlProps_242( ) ;
      wb5T0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSelect_Internalname,GXutil.rtrim( AV17Select),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSelect_Enabled!=0)&&(edtavSelect_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,25);\"" : " "),"'"+""+"'"+",false,"+"'"+"EENTER."+sGXsfl_24_idx+"'","","","Seleccionar","",edtavSelect_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSelect_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEventId_Internalname,GXutil.rtrim( A133EventId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEventId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadDescription_Internalname,A134DisponibilidadDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"WWPBaseObjects\\WWP_Description","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalId_Internalname,GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalApellidoPaterno_Internalname,A85ProfesionalApellidoPaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalApellidoPaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalApellidoMaterno_Internalname,A86ProfesionalApellidoMaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalApellidoMaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalNombres_Internalname,A84ProfesionalNombres,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalNombreCompleto_Internalname,A83ProfesionalNombreCompleto,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalNombreCompleto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalCOP_Internalname,A88ProfesionalCOP,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalCOP_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadFecha_Internalname,localUtil.format(A67DisponibilidadFecha, "99/99/99"),localUtil.format( A67DisponibilidadFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadHoraInicio_Internalname,localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A69DisponibilidadHoraInicio, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadHoraInicio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadHoraFin_Internalname,localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A135DisponibilidadHoraFin, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadHoraFin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadCodigo_Internalname,A140EspecialidadCodigo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadNombre_Internalname,A71EspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadUser_Internalname,GXutil.ltrim( localUtil.ntoc( A137DisponibilidadUser, (byte)(6), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadUser_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbDisponibilidadEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DISPONIBILIDADESTADO_" + sGXsfl_24_idx ;
            cmbDisponibilidadEstado.setName( GXCCtl );
            cmbDisponibilidadEstado.setWebtags( "" );
            cmbDisponibilidadEstado.addItem("A", "Activo", (short)(0));
            cmbDisponibilidadEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbDisponibilidadEstado.getItemCount() > 0 )
            {
               A136DisponibilidadEstado = cmbDisponibilidadEstado.getValidValue(A136DisponibilidadEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDisponibilidadEstado,cmbDisponibilidadEstado.getInternalname(),GXutil.rtrim( A136DisponibilidadEstado),Integer.valueOf(1),cmbDisponibilidadEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbDisponibilidadEstado.setValue( GXutil.rtrim( A136DisponibilidadEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstado.getInternalname(), "Values", cmbDisponibilidadEstado.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbDisponibilidadEstadoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DISPONIBILIDADESTADOCITA_" + sGXsfl_24_idx ;
            cmbDisponibilidadEstadoCita.setName( GXCCtl );
            cmbDisponibilidadEstadoCita.setWebtags( "" );
            cmbDisponibilidadEstadoCita.addItem("L", "Libre", (short)(0));
            cmbDisponibilidadEstadoCita.addItem("O", "Ocupado", (short)(0));
            cmbDisponibilidadEstadoCita.addItem("E", "Expiró", (short)(0));
            if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
            {
               A139DisponibilidadEstadoCita = cmbDisponibilidadEstadoCita.getValidValue(A139DisponibilidadEstadoCita) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDisponibilidadEstadoCita,cmbDisponibilidadEstadoCita.getInternalname(),GXutil.rtrim( A139DisponibilidadEstadoCita),Integer.valueOf(1),cmbDisponibilidadEstadoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","svchar","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbDisponibilidadEstadoCita.setValue( GXutil.rtrim( A139DisponibilidadEstadoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstadoCita.getInternalname(), "Values", cmbDisponibilidadEstadoCita.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDCitaId_Internalname,GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDCitaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbDisponibilidadTipoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DISPONIBILIDADTIPOCITA_" + sGXsfl_24_idx ;
            cmbDisponibilidadTipoCita.setName( GXCCtl );
            cmbDisponibilidadTipoCita.setWebtags( "" );
            cmbDisponibilidadTipoCita.addItem("V", "Virtual", (short)(0));
            cmbDisponibilidadTipoCita.addItem("P", "En consultorio", (short)(0));
            cmbDisponibilidadTipoCita.addItem("D", "Visita a domicilio", (short)(0));
            if ( cmbDisponibilidadTipoCita.getItemCount() > 0 )
            {
               A298DisponibilidadTipoCita = cmbDisponibilidadTipoCita.getValidValue(A298DisponibilidadTipoCita) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDisponibilidadTipoCita,cmbDisponibilidadTipoCita.getInternalname(),GXutil.rtrim( A298DisponibilidadTipoCita),Integer.valueOf(1),cmbDisponibilidadTipoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbDisponibilidadTipoCita.setValue( GXutil.rtrim( A298DisponibilidadTipoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadTipoCita.getInternalname(), "Values", cmbDisponibilidadTipoCita.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         send_integrity_lvl_hashes5T2( ) ;
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
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID" ;
      edtEventId_Internalname = "EVENTID" ;
      edtDisponibilidadDescription_Internalname = "DISPONIBILIDADDESCRIPTION" ;
      edtProfesionalId_Internalname = "PROFESIONALID" ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO" ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO" ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES" ;
      edtProfesionalNombreCompleto_Internalname = "PROFESIONALNOMBRECOMPLETO" ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP" ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA" ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO" ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN" ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID" ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO" ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE" ;
      edtDisponibilidadUser_Internalname = "DISPONIBILIDADUSER" ;
      cmbDisponibilidadEstado.setInternalname( "DISPONIBILIDADESTADO" );
      cmbDisponibilidadEstadoCita.setInternalname( "DISPONIBILIDADESTADOCITA" );
      edtDCitaId_Internalname = "DCITAID" ;
      cmbDisponibilidadTipoCita.setInternalname( "DISPONIBILIDADTIPOCITA" );
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
      cmbDisponibilidadTipoCita.setJsonclick( "" );
      edtDCitaId_Jsonclick = "" ;
      cmbDisponibilidadEstadoCita.setJsonclick( "" );
      cmbDisponibilidadEstado.setJsonclick( "" );
      edtDisponibilidadUser_Jsonclick = "" ;
      edtEspecialidadNombre_Jsonclick = "" ;
      edtEspecialidadCodigo_Jsonclick = "" ;
      edtEspecialidadId_Jsonclick = "" ;
      edtDisponibilidadHoraFin_Jsonclick = "" ;
      edtDisponibilidadHoraInicio_Jsonclick = "" ;
      edtDisponibilidadFecha_Jsonclick = "" ;
      edtProfesionalCOP_Jsonclick = "" ;
      edtProfesionalNombreCompleto_Jsonclick = "" ;
      edtProfesionalNombres_Jsonclick = "" ;
      edtProfesionalApellidoMaterno_Jsonclick = "" ;
      edtProfesionalApellidoPaterno_Jsonclick = "" ;
      edtProfesionalId_Jsonclick = "" ;
      edtDisponibilidadDescription_Jsonclick = "" ;
      edtEventId_Jsonclick = "" ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtavSelect_Jsonclick = "" ;
      edtavSelect_Visible = -1 ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtavSelect_Enabled = 1 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Selecciona Disponibilidad" );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18" ;
      Ddo_grid_Columnids = "1:DisponibilidadId|2:EventId|3:DisponibilidadDescription|4:ProfesionalId|5:ProfesionalApellidoPaterno|6:ProfesionalApellidoMaterno|7:ProfesionalNombres|9:ProfesionalCOP|10:DisponibilidadFecha|11:DisponibilidadHoraInicio|12:DisponibilidadHoraFin|13:EspecialidadId|14:EspecialidadCodigo|15:EspecialidadNombre|16:DisponibilidadUser|17:DisponibilidadEstado|18:DisponibilidadEstadoCita|20:DisponibilidadTipoCita" ;
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
      GXCCtl = "DISPONIBILIDADESTADO_" + sGXsfl_24_idx ;
      cmbDisponibilidadEstado.setName( GXCCtl );
      cmbDisponibilidadEstado.setWebtags( "" );
      cmbDisponibilidadEstado.addItem("A", "Activo", (short)(0));
      cmbDisponibilidadEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbDisponibilidadEstado.getItemCount() > 0 )
      {
         A136DisponibilidadEstado = cmbDisponibilidadEstado.getValidValue(A136DisponibilidadEstado) ;
      }
      GXCCtl = "DISPONIBILIDADESTADOCITA_" + sGXsfl_24_idx ;
      cmbDisponibilidadEstadoCita.setName( GXCCtl );
      cmbDisponibilidadEstadoCita.setWebtags( "" );
      cmbDisponibilidadEstadoCita.addItem("L", "Libre", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("O", "Ocupado", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("E", "Expiró", (short)(0));
      if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
      {
         A139DisponibilidadEstadoCita = cmbDisponibilidadEstadoCita.getValidValue(A139DisponibilidadEstadoCita) ;
      }
      GXCCtl = "DISPONIBILIDADTIPOCITA_" + sGXsfl_24_idx ;
      cmbDisponibilidadTipoCita.setName( GXCCtl );
      cmbDisponibilidadTipoCita.setWebtags( "" );
      cmbDisponibilidadTipoCita.addItem("V", "Virtual", (short)(0));
      cmbDisponibilidadTipoCita.addItem("P", "En consultorio", (short)(0));
      cmbDisponibilidadTipoCita.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbDisponibilidadTipoCita.getItemCount() > 0 )
      {
         A298DisponibilidadTipoCita = cmbDisponibilidadTipoCita.getValidValue(A298DisponibilidadTipoCita) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV12FilterFullText',fld:'vFILTERFULLTEXT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV15GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV16GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e115T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV12FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e125T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV12FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e135T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV12FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'AV10OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV11OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV10OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV11OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e175T2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV17Select',fld:'vSELECT',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e185T2',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV8InOutDisponibilidadId',fld:'vINOUTDISPONIBILIDADID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("'DOCLEANFILTERS'","{handler:'e145T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV12FilterFullText',fld:'vFILTERFULLTEXT',pic:''}]");
      setEventMetadata("'DOCLEANFILTERS'",",oparms:[{av:'AV12FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV15GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV16GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_DISPONIBILIDADID","{handler:'valid_Disponibilidadid',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALID","{handler:'valid_Profesionalid',iparms:[]");
      setEventMetadata("VALID_PROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADID","{handler:'valid_Especialidadid',iparms:[]");
      setEventMetadata("VALID_ESPECIALIDADID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Disponibilidadtipocita',iparms:[]");
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
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV12FilterFullText = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV13DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV17Select = "" ;
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A83ProfesionalNombreCompleto = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      lV12FilterFullText = "" ;
      H005T3_A298DisponibilidadTipoCita = new String[] {""} ;
      H005T3_A139DisponibilidadEstadoCita = new String[] {""} ;
      H005T3_A136DisponibilidadEstado = new String[] {""} ;
      H005T3_A137DisponibilidadUser = new int[1] ;
      H005T3_A71EspecialidadNombre = new String[] {""} ;
      H005T3_A140EspecialidadCodigo = new String[] {""} ;
      H005T3_A32EspecialidadId = new short[1] ;
      H005T3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H005T3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      H005T3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H005T3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      H005T3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H005T3_n67DisponibilidadFecha = new boolean[] {false} ;
      H005T3_A88ProfesionalCOP = new String[] {""} ;
      H005T3_A83ProfesionalNombreCompleto = new String[] {""} ;
      H005T3_A31ProfesionalId = new int[1] ;
      H005T3_A134DisponibilidadDescription = new String[] {""} ;
      H005T3_A133EventId = new String[] {""} ;
      H005T3_A34DisponibilidadId = new int[1] ;
      H005T3_A138DCitaId = new int[1] ;
      H005T3_n138DCitaId = new boolean[] {false} ;
      H005T3_A84ProfesionalNombres = new String[] {""} ;
      H005T3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H005T3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H005T5_AGRID_nRecordCount = new long[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadprompt__default(),
         new Object[] {
             new Object[] {
            H005T3_A298DisponibilidadTipoCita, H005T3_A139DisponibilidadEstadoCita, H005T3_A136DisponibilidadEstado, H005T3_A137DisponibilidadUser, H005T3_A71EspecialidadNombre, H005T3_A140EspecialidadCodigo, H005T3_A32EspecialidadId, H005T3_A135DisponibilidadHoraFin, H005T3_n135DisponibilidadHoraFin, H005T3_A69DisponibilidadHoraInicio,
            H005T3_n69DisponibilidadHoraInicio, H005T3_A67DisponibilidadFecha, H005T3_n67DisponibilidadFecha, H005T3_A88ProfesionalCOP, H005T3_A83ProfesionalNombreCompleto, H005T3_A31ProfesionalId, H005T3_A134DisponibilidadDescription, H005T3_A133EventId, H005T3_A34DisponibilidadId, H005T3_A138DCitaId,
            H005T3_n138DCitaId, H005T3_A84ProfesionalNombres, H005T3_A85ProfesionalApellidoPaterno, H005T3_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            H005T5_AGRID_nRecordCount
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
   private short AV10OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A32EspecialidadId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8InOutDisponibilidadId ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_24 ;
   private int nGXsfl_24_idx=1 ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Pagestoshow ;
   private int AV8InOutDisponibilidadId ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavSelect_Enabled ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int A137DisponibilidadUser ;
   private int A138DCitaId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV14PageToGo ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int edtavSelect_Visible ;
   private long GRID_nFirstRecordOnPage ;
   private long AV15GridCurrentPage ;
   private long AV16GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
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
   private String AV17Select ;
   private String A133EventId ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSelect_Internalname ;
   private String edtDisponibilidadId_Internalname ;
   private String edtEventId_Internalname ;
   private String edtDisponibilidadDescription_Internalname ;
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalApellidoPaterno_Internalname ;
   private String edtProfesionalApellidoMaterno_Internalname ;
   private String edtProfesionalNombres_Internalname ;
   private String edtProfesionalNombreCompleto_Internalname ;
   private String edtProfesionalCOP_Internalname ;
   private String edtDisponibilidadFecha_Internalname ;
   private String edtDisponibilidadHoraInicio_Internalname ;
   private String edtDisponibilidadHoraFin_Internalname ;
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadCodigo_Internalname ;
   private String edtEspecialidadNombre_Internalname ;
   private String edtDisponibilidadUser_Internalname ;
   private String edtDCitaId_Internalname ;
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
   private String edtDisponibilidadId_Jsonclick ;
   private String edtEventId_Jsonclick ;
   private String edtDisponibilidadDescription_Jsonclick ;
   private String edtProfesionalId_Jsonclick ;
   private String edtProfesionalApellidoPaterno_Jsonclick ;
   private String edtProfesionalApellidoMaterno_Jsonclick ;
   private String edtProfesionalNombres_Jsonclick ;
   private String edtProfesionalNombreCompleto_Jsonclick ;
   private String edtProfesionalCOP_Jsonclick ;
   private String edtDisponibilidadFecha_Jsonclick ;
   private String edtDisponibilidadHoraInicio_Jsonclick ;
   private String edtDisponibilidadHoraFin_Jsonclick ;
   private String edtEspecialidadId_Jsonclick ;
   private String edtEspecialidadCodigo_Jsonclick ;
   private String edtEspecialidadNombre_Jsonclick ;
   private String edtDisponibilidadUser_Jsonclick ;
   private String GXCCtl ;
   private String edtDCitaId_Jsonclick ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean AV11OrderedDsc ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n138DCitaId ;
   private boolean bGXsfl_24_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV12FilterFullText ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A139DisponibilidadEstadoCita ;
   private String lV12FilterFullText ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbDisponibilidadEstado ;
   private HTMLChoice cmbDisponibilidadEstadoCita ;
   private HTMLChoice cmbDisponibilidadTipoCita ;
   private IDataStoreProvider pr_default ;
   private String[] H005T3_A298DisponibilidadTipoCita ;
   private String[] H005T3_A139DisponibilidadEstadoCita ;
   private String[] H005T3_A136DisponibilidadEstado ;
   private int[] H005T3_A137DisponibilidadUser ;
   private String[] H005T3_A71EspecialidadNombre ;
   private String[] H005T3_A140EspecialidadCodigo ;
   private short[] H005T3_A32EspecialidadId ;
   private java.util.Date[] H005T3_A135DisponibilidadHoraFin ;
   private boolean[] H005T3_n135DisponibilidadHoraFin ;
   private java.util.Date[] H005T3_A69DisponibilidadHoraInicio ;
   private boolean[] H005T3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] H005T3_A67DisponibilidadFecha ;
   private boolean[] H005T3_n67DisponibilidadFecha ;
   private String[] H005T3_A88ProfesionalCOP ;
   private String[] H005T3_A83ProfesionalNombreCompleto ;
   private int[] H005T3_A31ProfesionalId ;
   private String[] H005T3_A134DisponibilidadDescription ;
   private String[] H005T3_A133EventId ;
   private int[] H005T3_A34DisponibilidadId ;
   private int[] H005T3_A138DCitaId ;
   private boolean[] H005T3_n138DCitaId ;
   private String[] H005T3_A84ProfesionalNombres ;
   private String[] H005T3_A85ProfesionalApellidoPaterno ;
   private String[] H005T3_A86ProfesionalApellidoMaterno ;
   private long[] H005T5_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV13DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class disponibilidadprompt__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H005T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV10OrderedBy ,
                                          boolean AV11OrderedDsc ,
                                          String AV12FilterFullText ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A83ProfesionalNombreCompleto ,
                                          String A88ProfesionalCOP ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          String A136DisponibilidadEstado ,
                                          String A139DisponibilidadEstadoCita ,
                                          int A138DCitaId ,
                                          String A298DisponibilidadTipoCita )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[26];
      Object[] GXv_Object5 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T1.[DisponibilidadUser], T2.[EspecialidadNombre], T2.[EspecialidadCodigo]," ;
      sSelectString += " T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T3.[ProfesionalCOP], T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno]" ;
      sSelectString += " + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[ProfesionalId], T1.[DisponibilidadDescription], T1.[EventId], T1.[DisponibilidadId], COALESCE(" ;
      sSelectString += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno]" ;
      sFromString = " FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId])" ;
      sFromString += " LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId])" ;
      sFromString += " AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      if ( ( AV10OrderedBy == 1 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV10OrderedBy == 1 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EventId]" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EventId] DESC" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadDescription]" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadDescription] DESC" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV10OrderedBy == 5 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV10OrderedBy == 5 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV10OrderedBy == 6 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV10OrderedBy == 6 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV10OrderedBy == 7 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalNombres]" ;
      }
      else if ( ( AV10OrderedBy == 7 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV10OrderedBy == 8 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV10OrderedBy == 8 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV10OrderedBy == 9 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadFecha]" ;
      }
      else if ( ( AV10OrderedBy == 9 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV10OrderedBy == 10 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV10OrderedBy == 10 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV10OrderedBy == 11 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV10OrderedBy == 11 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV10OrderedBy == 12 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EspecialidadId]" ;
      }
      else if ( ( AV10OrderedBy == 12 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EspecialidadId] DESC" ;
      }
      else if ( ( AV10OrderedBy == 13 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[EspecialidadCodigo]" ;
      }
      else if ( ( AV10OrderedBy == 13 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[EspecialidadCodigo] DESC" ;
      }
      else if ( ( AV10OrderedBy == 14 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[EspecialidadNombre]" ;
      }
      else if ( ( AV10OrderedBy == 14 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV10OrderedBy == 15 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadUser]" ;
      }
      else if ( ( AV10OrderedBy == 15 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadUser] DESC" ;
      }
      else if ( ( AV10OrderedBy == 16 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstado]" ;
      }
      else if ( ( AV10OrderedBy == 16 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstado] DESC" ;
      }
      else if ( ( AV10OrderedBy == 17 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstadoCita]" ;
      }
      else if ( ( AV10OrderedBy == 17 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstadoCita] DESC" ;
      }
      else if ( ( AV10OrderedBy == 18 ) && ! AV11OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadTipoCita]" ;
      }
      else if ( ( AV10OrderedBy == 18 ) && ( AV11OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadTipoCita] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_H005T5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV10OrderedBy ,
                                          boolean AV11OrderedDsc ,
                                          String AV12FilterFullText ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A83ProfesionalNombreCompleto ,
                                          String A88ProfesionalCOP ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          String A136DisponibilidadEstado ,
                                          String A139DisponibilidadEstadoCita ,
                                          int A138DCitaId ,
                                          String A298DisponibilidadTipoCita )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[23];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad] T3 ON T3.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T2 ON T2.[ProfesionalId]" ;
      scmdbuf += " = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId]" ;
      scmdbuf += " = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T2.[ProfesionalApellidoPaterno] like '%' + ?) or ( T2.[ProfesionalApellidoMaterno] like '%' + ?) or ( T2.[ProfesionalNombres] like '%' + ?) or ( T2.[ProfesionalNombres] + ' ' + T2.[ProfesionalApellidoPaterno] + ' ' + T2.[ProfesionalApellidoMaterno] like '%' + ?) or ( T2.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T3.[EspecialidadCodigo] like '%' + ?) or ( T3.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      scmdbuf += sWhereString ;
      if ( ( AV10OrderedBy == 1 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 1 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 3 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 4 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 5 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 5 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 6 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 6 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 7 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 7 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 8 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 8 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 9 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 9 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 10 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 10 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 11 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 11 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 12 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 12 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 13 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 13 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 14 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 14 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 15 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 15 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 16 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 16 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 17 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 17 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 18 ) && ! AV11OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV10OrderedBy == 18 ) && ( AV11OrderedDsc ) )
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
                  return conditional_H005T3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] );
            case 1 :
                  return conditional_H005T5(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H005T5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(8));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getString(15, 20);
               ((int[]) buf[18])[0] = rslt.getInt(16);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
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
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[49]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[50]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[51]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
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

