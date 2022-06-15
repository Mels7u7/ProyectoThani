package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secrolesecfunctionalityrolewc_impl extends GXWebComponent
{
   public secrolesecfunctionalityrolewc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secrolesecfunctionalityrolewc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolesecfunctionalityrolewc_impl.class ));
   }

   public secrolesecfunctionalityrolewc_impl( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
      cmbavSecfunctionalitytype = new HTMLChoice();
      cmbSecFunctionalityType = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV8SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecRoleId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(AV8SecRoleId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
            {
               nRC_GXsfl_35 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_35"))) ;
               nGXsfl_35_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_35_idx"))) ;
               sGXsfl_35_idx = httpContext.GetPar( "sGXsfl_35_idx") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
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
               AV73FilterFullText = httpContext.GetPar( "FilterFullText") ;
               cmbavSecfunctionalitytype.fromJSonString( httpContext.GetNextPar( ));
               AV14SecFunctionalityType = (byte)(GXutil.lval( httpContext.GetPar( "SecFunctionalityType"))) ;
               AV8SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
               AV60ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
               AV76Pgmname = httpContext.GetPar( "Pgmname") ;
               AV20OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
               AV21OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
               AV44TFSecFunctionalityKey = httpContext.GetPar( "TFSecFunctionalityKey") ;
               AV45TFSecFunctionalityKey_Sel = httpContext.GetPar( "TFSecFunctionalityKey_Sel") ;
               httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV68TFSecFunctionalityType_Sels);
               AV55TFSecParentFunctionalityDescription = httpContext.GetPar( "TFSecParentFunctionalityDescription") ;
               AV56TFSecParentFunctionalityDescription_Sel = httpContext.GetPar( "TFSecParentFunctionalityDescription_Sel") ;
               AV41IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
               AV40IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
               AV16IsAuthorized_SecFunctionalityDescription = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_SecFunctionalityDescription")) ;
               AV42IsAuthorized_SecParentFunctionalityDescription = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_SecParentFunctionalityDescription")) ;
               A4SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               init_default_properties( ) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxgrgrid_refresh( subGrid_Rows, AV73FilterFullText, AV14SecFunctionalityType, AV8SecRoleId, AV60ManageFiltersExecutionStep, AV76Pgmname, AV20OrderedBy, AV21OrderedDsc, AV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, AV68TFSecFunctionalityType_Sels, AV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, AV41IsAuthorized_Update, AV40IsAuthorized_Delete, AV16IsAuthorized_SecFunctionalityDescription, AV42IsAuthorized_SecParentFunctionalityDescription, A4SecRoleId, sPrefix) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa142( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "Sec Role Sec Functionality Role WC") ;
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
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?202251103294", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secrolesecfunctionalityrolewc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8SecRoleId,4,0))}, new String[] {"SecRoleId"}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV76Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV41IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV40IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV16IsAuthorized_SecFunctionalityDescription));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV42IsAuthorized_SecParentFunctionalityDescription));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"SecRoleSecFunctionalityRoleWC");
      forbiddenHiddens.add("SecRoleId", localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\secrolesecfunctionalityrolewc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXH_vFILTERFULLTEXT", AV73FilterFullText);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXH_vSECFUNCTIONALITYTYPE", GXutil.ltrim( localUtil.ntoc( AV14SecFunctionalityType, (byte)(2), (byte)(0), ",", "")));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_35", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_35, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMANAGEFILTERSDATA", AV64ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMANAGEFILTERSDATA", AV64ManageFiltersData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV70GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV71GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV58DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV58DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8SecRoleId", GXutil.ltrim( localUtil.ntoc( wcpOAV8SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV60ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV76Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV76Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV20OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV21OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFSECFUNCTIONALITYKEY", AV44TFSecFunctionalityKey);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFSECFUNCTIONALITYKEY_SEL", AV45TFSecFunctionalityKey_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFSECFUNCTIONALITYTYPE_SELS", AV68TFSecFunctionalityType_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFSECFUNCTIONALITYTYPE_SELS", AV68TFSecFunctionalityType_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFSECPARENTFUNCTIONALITYDESCRIPTION", AV55TFSecParentFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL", AV56TFSecParentFunctionalityDescription_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSECROLEID", GXutil.ltrim( localUtil.ntoc( AV8SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV41IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV41IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV40IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV40IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION", AV16IsAuthorized_SecFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV16IsAuthorized_SecFunctionalityDescription));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION", AV42IsAuthorized_SecParentFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV42IsAuthorized_SecParentFunctionalityDescription));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vGRIDSTATE", AV17GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vGRIDSTATE", AV17GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFSECFUNCTIONALITYTYPE_SELSJSON", AV67TFSecFunctionalityType_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm142( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecRoleSecFunctionalityRoleWC" ;
   }

   public String getPgmdesc( )
   {
      return "Sec Role Sec Functionality Role WC" ;
   }

   public void wb140( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wwpbaseobjects.secrolesecfunctionalityrolewc");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         }
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablegridheader_Internalname, 1, 0, "px", 0, "px", "Table100x100", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableheader.setProperty("Width", Dvpanel_tableheader_Width);
         ucDvpanel_tableheader.setProperty("AutoWidth", Dvpanel_tableheader_Autowidth);
         ucDvpanel_tableheader.setProperty("AutoHeight", Dvpanel_tableheader_Autoheight);
         ucDvpanel_tableheader.setProperty("Cls", Dvpanel_tableheader_Cls);
         ucDvpanel_tableheader.setProperty("Title", Dvpanel_tableheader_Title);
         ucDvpanel_tableheader.setProperty("Collapsible", Dvpanel_tableheader_Collapsible);
         ucDvpanel_tableheader.setProperty("Collapsed", Dvpanel_tableheader_Collapsed);
         ucDvpanel_tableheader.setProperty("ShowCollapseIcon", Dvpanel_tableheader_Showcollapseicon);
         ucDvpanel_tableheader.setProperty("IconPosition", Dvpanel_tableheader_Iconposition);
         ucDvpanel_tableheader.setProperty("AutoScroll", Dvpanel_tableheader_Autoscroll);
         ucDvpanel_tableheader.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableheader_Internalname, sPrefix+"DVPANEL_TABLEHEADERContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEHEADERContainer"+"TableHeader"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_16_142( true) ;
      }
      else
      {
         wb_table1_16_142( false) ;
      }
      return  ;
   }

   public void wb_table1_16_142e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
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
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"35\">") ;
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Functionality Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Functionality Key") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Functionality Type") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Functionality Description") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Parent Functionality") ;
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
            GridContainer.AddObjectProperty("CmpContext", sPrefix);
            GridContainer.AddObjectProperty("InMasterPage", "false");
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV39Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV38Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A3SecFunctionalityKey);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A9SecFunctionalityType, (byte)(2), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A8SecFunctionalityDescription);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSecFunctionalityDescription_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A11SecParentFunctionalityDescription);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSecParentFunctionalityDescription_Link));
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
      if ( wbEnd == 35 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_35 = (int)(nGXsfl_35_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV70GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV71GridPageCount);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
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
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV58DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecRoleId_Internalname, GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecRoleId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecRoleId_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecRoleSecFunctionalityRoleWC.htm");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 35 )
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
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start142( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "Sec Role Sec Functionality Role WC", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup140( ) ;
         }
      }
   }

   public void ws142( )
   {
      start142( ) ;
      evt142( ) ;
   }

   public void evt142( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
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
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11142 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12142 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13142 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14142 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavFilterfulltext_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup140( ) ;
                           }
                           nGXsfl_35_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_35_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_35_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_352( ) ;
                           AV39Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV39Update);
                           AV38Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV38Delete);
                           A1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") ;
                           A3SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
                           cmbSecFunctionalityType.setName( cmbSecFunctionalityType.getInternalname() );
                           cmbSecFunctionalityType.setValue( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()) );
                           A9SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
                           A8SecFunctionalityDescription = httpContext.cgiGet( edtSecFunctionalityDescription_Internalname) ;
                           A11SecParentFunctionalityDescription = httpContext.cgiGet( edtSecParentFunctionalityDescription_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e15142 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e16142 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e17142 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          /* Set Refresh If Filterfulltext Changed */
                                          if ( GXutil.strcmp(httpContext.cgiGet( sPrefix+"GXH_vFILTERFULLTEXT"), AV73FilterFullText) != 0 )
                                          {
                                             Rfr0gs = true ;
                                          }
                                          /* Set Refresh If Secfunctionalitytype Changed */
                                          if ( localUtil.ctol( httpContext.cgiGet( sPrefix+"GXH_vSECFUNCTIONALITYTYPE"), ",", ".") != AV14SecFunctionalityType )
                                          {
                                             Rfr0gs = true ;
                                          }
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup140( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
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

   public void we142( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm142( ) ;
         }
      }
   }

   public void pa142( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavFilterfulltext_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      subsflControlProps_352( ) ;
      while ( nGXsfl_35_idx <= nRC_GXsfl_35 )
      {
         sendrow_352( ) ;
         nGXsfl_35_idx = ((subGrid_Islastpage==1)&&(nGXsfl_35_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_35_idx+1) ;
         sGXsfl_35_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_35_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_352( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV73FilterFullText ,
                                 byte AV14SecFunctionalityType ,
                                 short AV8SecRoleId ,
                                 byte AV60ManageFiltersExecutionStep ,
                                 String AV76Pgmname ,
                                 short AV20OrderedBy ,
                                 boolean AV21OrderedDsc ,
                                 String AV44TFSecFunctionalityKey ,
                                 String AV45TFSecFunctionalityKey_Sel ,
                                 GXSimpleCollection<Byte> AV68TFSecFunctionalityType_Sels ,
                                 String AV55TFSecParentFunctionalityDescription ,
                                 String AV56TFSecParentFunctionalityDescription_Sel ,
                                 boolean AV41IsAuthorized_Update ,
                                 boolean AV40IsAuthorized_Delete ,
                                 boolean AV16IsAuthorized_SecFunctionalityDescription ,
                                 boolean AV42IsAuthorized_SecParentFunctionalityDescription ,
                                 short A4SecRoleId ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16142 ();
      GRID_nCurrentRecord = 0 ;
      rf142( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"SecRoleSecFunctionalityRoleWC");
      forbiddenHiddens.add("SecRoleId", localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\secrolesecfunctionalityrolewc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
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
      if ( cmbavSecfunctionalitytype.getItemCount() > 0 )
      {
         AV14SecFunctionalityType = (byte)(GXutil.lval( cmbavSecfunctionalitytype.getValidValue(GXutil.trim( GXutil.str( AV14SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecFunctionalityType), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSecfunctionalitytype.setValue( GXutil.trim( GXutil.str( AV14SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavSecfunctionalitytype.getInternalname(), "Values", cmbavSecfunctionalitytype.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf142( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV76Pgmname = "WWPBaseObjects.SecRoleSecFunctionalityRoleWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_35_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_35_Refreshing);
   }

   public void rf142( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(35) ;
      /* Execute user event: Refresh */
      e16142 ();
      nGXsfl_35_idx = 1 ;
      sGXsfl_35_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_35_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_352( ) ;
      bGXsfl_35_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
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
         subsflControlProps_352( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Byte.valueOf(A9SecFunctionalityType) ,
                                              AV68TFSecFunctionalityType_Sels ,
                                              AV73FilterFullText ,
                                              Byte.valueOf(AV14SecFunctionalityType) ,
                                              AV45TFSecFunctionalityKey_Sel ,
                                              AV44TFSecFunctionalityKey ,
                                              Integer.valueOf(AV68TFSecFunctionalityType_Sels.size()) ,
                                              AV56TFSecParentFunctionalityDescription_Sel ,
                                              AV55TFSecParentFunctionalityDescription ,
                                              A3SecFunctionalityKey ,
                                              A8SecFunctionalityDescription ,
                                              A11SecParentFunctionalityDescription ,
                                              Short.valueOf(AV20OrderedBy) ,
                                              Boolean.valueOf(AV21OrderedDsc) ,
                                              Short.valueOf(AV8SecRoleId) ,
                                              Short.valueOf(A4SecRoleId) } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
         lV44TFSecFunctionalityKey = GXutil.concat( GXutil.rtrim( AV44TFSecFunctionalityKey), "%", "") ;
         lV55TFSecParentFunctionalityDescription = GXutil.concat( GXutil.rtrim( AV55TFSecParentFunctionalityDescription), "%", "") ;
         /* Using cursor H00142 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV8SecRoleId), lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, Byte.valueOf(AV14SecFunctionalityType), lV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, lV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_35_idx = 1 ;
         sGXsfl_35_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_35_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_352( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2SecParentFunctionalityId = H00142_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = H00142_n2SecParentFunctionalityId[0] ;
            A4SecRoleId = H00142_A4SecRoleId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
            A11SecParentFunctionalityDescription = H00142_A11SecParentFunctionalityDescription[0] ;
            A8SecFunctionalityDescription = H00142_A8SecFunctionalityDescription[0] ;
            A9SecFunctionalityType = H00142_A9SecFunctionalityType[0] ;
            A3SecFunctionalityKey = H00142_A3SecFunctionalityKey[0] ;
            A1SecFunctionalityId = H00142_A1SecFunctionalityId[0] ;
            A2SecParentFunctionalityId = H00142_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = H00142_n2SecParentFunctionalityId[0] ;
            A8SecFunctionalityDescription = H00142_A8SecFunctionalityDescription[0] ;
            A9SecFunctionalityType = H00142_A9SecFunctionalityType[0] ;
            A3SecFunctionalityKey = H00142_A3SecFunctionalityKey[0] ;
            A11SecParentFunctionalityDescription = H00142_A11SecParentFunctionalityDescription[0] ;
            e17142 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(35) ;
         wb140( ) ;
      }
      bGXsfl_35_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes142( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV76Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV76Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV41IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV41IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV40IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV40IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION", AV16IsAuthorized_SecFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV16IsAuthorized_SecFunctionalityDescription));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION", AV42IsAuthorized_SecParentFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV42IsAuthorized_SecParentFunctionalityDescription));
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
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV68TFSecFunctionalityType_Sels ,
                                           AV73FilterFullText ,
                                           Byte.valueOf(AV14SecFunctionalityType) ,
                                           AV45TFSecFunctionalityKey_Sel ,
                                           AV44TFSecFunctionalityKey ,
                                           Integer.valueOf(AV68TFSecFunctionalityType_Sels.size()) ,
                                           AV56TFSecParentFunctionalityDescription_Sel ,
                                           AV55TFSecParentFunctionalityDescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV20OrderedBy) ,
                                           Boolean.valueOf(AV21OrderedDsc) ,
                                           Short.valueOf(AV8SecRoleId) ,
                                           Short.valueOf(A4SecRoleId) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV73FilterFullText = GXutil.concat( GXutil.rtrim( AV73FilterFullText), "%", "") ;
      lV44TFSecFunctionalityKey = GXutil.concat( GXutil.rtrim( AV44TFSecFunctionalityKey), "%", "") ;
      lV55TFSecParentFunctionalityDescription = GXutil.concat( GXutil.rtrim( AV55TFSecParentFunctionalityDescription), "%", "") ;
      /* Using cursor H00143 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV8SecRoleId), lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, lV73FilterFullText, Byte.valueOf(AV14SecFunctionalityType), lV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, lV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel});
      GRID_nRecordCount = H00143_AGRID_nRecordCount[0] ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV73FilterFullText, AV14SecFunctionalityType, AV8SecRoleId, AV60ManageFiltersExecutionStep, AV76Pgmname, AV20OrderedBy, AV21OrderedDsc, AV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, AV68TFSecFunctionalityType_Sels, AV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, AV41IsAuthorized_Update, AV40IsAuthorized_Delete, AV16IsAuthorized_SecFunctionalityDescription, AV42IsAuthorized_SecParentFunctionalityDescription, A4SecRoleId, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV73FilterFullText, AV14SecFunctionalityType, AV8SecRoleId, AV60ManageFiltersExecutionStep, AV76Pgmname, AV20OrderedBy, AV21OrderedDsc, AV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, AV68TFSecFunctionalityType_Sels, AV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, AV41IsAuthorized_Update, AV40IsAuthorized_Delete, AV16IsAuthorized_SecFunctionalityDescription, AV42IsAuthorized_SecParentFunctionalityDescription, A4SecRoleId, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV73FilterFullText, AV14SecFunctionalityType, AV8SecRoleId, AV60ManageFiltersExecutionStep, AV76Pgmname, AV20OrderedBy, AV21OrderedDsc, AV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, AV68TFSecFunctionalityType_Sels, AV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, AV41IsAuthorized_Update, AV40IsAuthorized_Delete, AV16IsAuthorized_SecFunctionalityDescription, AV42IsAuthorized_SecParentFunctionalityDescription, A4SecRoleId, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV73FilterFullText, AV14SecFunctionalityType, AV8SecRoleId, AV60ManageFiltersExecutionStep, AV76Pgmname, AV20OrderedBy, AV21OrderedDsc, AV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, AV68TFSecFunctionalityType_Sels, AV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, AV41IsAuthorized_Update, AV40IsAuthorized_Delete, AV16IsAuthorized_SecFunctionalityDescription, AV42IsAuthorized_SecParentFunctionalityDescription, A4SecRoleId, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV73FilterFullText, AV14SecFunctionalityType, AV8SecRoleId, AV60ManageFiltersExecutionStep, AV76Pgmname, AV20OrderedBy, AV21OrderedDsc, AV44TFSecFunctionalityKey, AV45TFSecFunctionalityKey_Sel, AV68TFSecFunctionalityType_Sels, AV55TFSecParentFunctionalityDescription, AV56TFSecParentFunctionalityDescription_Sel, AV41IsAuthorized_Update, AV40IsAuthorized_Delete, AV16IsAuthorized_SecFunctionalityDescription, AV42IsAuthorized_SecParentFunctionalityDescription, A4SecRoleId, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV76Pgmname = "WWPBaseObjects.SecRoleSecFunctionalityRoleWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_35_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_35_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup140( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15142 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vMANAGEFILTERSDATA"), AV64ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV58DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_35 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_35"), ",", ".")) ;
         AV70GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), ",", ".") ;
         AV71GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), ",", ".") ;
         wcpOAV8SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8SecRoleId"), ",", ".")) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_managefilters_Icontype = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Cls") ;
         Dvpanel_tableheader_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Width") ;
         Dvpanel_tableheader_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Autowidth")) ;
         Dvpanel_tableheader_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Autoheight")) ;
         Dvpanel_tableheader_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Cls") ;
         Dvpanel_tableheader_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Title") ;
         Dvpanel_tableheader_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Collapsible")) ;
         Dvpanel_tableheader_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Collapsed")) ;
         Dvpanel_tableheader_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Showcollapseicon")) ;
         Dvpanel_tableheader_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Iconposition") ;
         Dvpanel_tableheader_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Autoscroll")) ;
         Gridpaginationbar_Class = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( sPrefix+"DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( sPrefix+"DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( sPrefix+"DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( sPrefix+"DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistproc") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_get") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV73FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73FilterFullText", AV73FilterFullText);
         cmbavSecfunctionalitytype.setName( cmbavSecfunctionalitytype.getInternalname() );
         cmbavSecfunctionalitytype.setValue( httpContext.cgiGet( cmbavSecfunctionalitytype.getInternalname()) );
         AV14SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbavSecfunctionalitytype.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecFunctionalityType), 2, 0));
         A4SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"SecRoleSecFunctionalityRoleWC");
         A4SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         forbiddenHiddens.add("SecRoleId", localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("wwpbaseobjects\\secrolesecfunctionalityrolewc:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( sPrefix+"GXH_vFILTERFULLTEXT"), AV73FilterFullText) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( sPrefix+"GXH_vSECFUNCTIONALITYTYPE"), ",", ".") != AV14SecFunctionalityType )
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
      e15142 ();
      if (returnInSub) return;
   }

   public void e15142( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      /* Execute user subroutine: 'LOADSAVEDFILTERS' */
      S112 ();
      if (returnInSub) return;
      GXt_boolean1 = AV16IsAuthorized_SecFunctionalityDescription ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV16IsAuthorized_SecFunctionalityDescription = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16IsAuthorized_SecFunctionalityDescription", AV16IsAuthorized_SecFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV16IsAuthorized_SecFunctionalityDescription));
      GXt_boolean1 = AV42IsAuthorized_SecParentFunctionalityDescription ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV42IsAuthorized_SecParentFunctionalityDescription = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42IsAuthorized_SecParentFunctionalityDescription", AV42IsAuthorized_SecParentFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION", getSecureSignedToken( sPrefix, AV42IsAuthorized_SecParentFunctionalityDescription));
      AV14SecFunctionalityType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecFunctionalityType), 2, 0));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtSecRoleId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtSecRoleId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleId_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV20OrderedBy < 1 )
      {
         AV20OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV58DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV58DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e16142( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext5[0] = AV66WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV66WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV60ManageFiltersExecutionStep == 1 )
      {
         AV60ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV60ManageFiltersExecutionStep == 2 )
      {
         AV60ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      AV70GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70GridCurrentPage), 10, 0));
      AV71GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71GridPageCount), 10, 0));
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV64ManageFiltersData", AV64ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV17GridState", AV17GridState);
   }

   public void e12142( )
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
         AV69PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV69PageToGo) ;
      }
   }

   public void e13142( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e14142( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV20OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20OrderedBy), 4, 0));
         AV21OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21OrderedDsc", AV21OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityKey") == 0 )
         {
            AV44TFSecFunctionalityKey = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFSecFunctionalityKey", AV44TFSecFunctionalityKey);
            AV45TFSecFunctionalityKey_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFSecFunctionalityKey_Sel", AV45TFSecFunctionalityKey_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityType") == 0 )
         {
            AV67TFSecFunctionalityType_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFSecFunctionalityType_SelsJson", AV67TFSecFunctionalityType_SelsJson);
            AV68TFSecFunctionalityType_Sels.fromJSonString(GXutil.strReplace( AV67TFSecFunctionalityType_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecParentFunctionalityDescription") == 0 )
         {
            AV55TFSecParentFunctionalityDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFSecParentFunctionalityDescription", AV55TFSecParentFunctionalityDescription);
            AV56TFSecParentFunctionalityDescription_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFSecParentFunctionalityDescription_Sel", AV56TFSecParentFunctionalityDescription_Sel);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV68TFSecFunctionalityType_Sels", AV68TFSecFunctionalityType_Sels);
   }

   private void e17142( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV39Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV39Update);
      if ( AV41IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityrole", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0)),GXutil.URLEncode(GXutil.ltrimstr(A4SecRoleId,4,0))}, new String[] {})  ;
      }
      AV38Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV38Delete);
      if ( AV40IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityrole", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0)),GXutil.URLEncode(GXutil.ltrimstr(A4SecRoleId,4,0))}, new String[] {})  ;
      }
      if ( AV16IsAuthorized_SecFunctionalityDescription )
      {
         edtSecFunctionalityDescription_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecFunctionalityId","TabCode"})  ;
      }
      if ( AV42IsAuthorized_SecParentFunctionalityDescription )
      {
         edtSecParentFunctionalityDescription_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecFunctionalityId","TabCode"})  ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(35) ;
      }
      sendrow_352( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_35_Refreshing )
      {
         httpContext.doAjaxLoad(35, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11142( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S172 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("WWPBaseObjects.SecRoleSecFunctionalityRoleWCFilters")),GXutil.URLEncode(GXutil.rtrim(AV76Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV60ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("WWPBaseObjects.SecRoleSecFunctionalityRoleWCFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV60ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else
      {
         GXt_char6 = AV61ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "WWPBaseObjects.SecRoleSecFunctionalityRoleWCFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         secrolesecfunctionalityrolewc_impl.this.GXt_char6 = GXv_char7[0] ;
         AV61ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV61ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem("El filtro seleccionado no existe más.");
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV76Pgmname+"GridState", AV61ManageFiltersXml) ;
            AV17GridState.fromxml(AV61ManageFiltersXml, null, null);
            AV20OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20OrderedBy), 4, 0));
            AV21OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21OrderedDsc", AV21OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S182 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
            httpContext.doAjaxRefreshCmp(sPrefix);
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV17GridState", AV17GridState);
      cmbavSecfunctionalitytype.setValue( GXutil.trim( GXutil.str( AV14SecFunctionalityType, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavSecfunctionalitytype.getInternalname(), "Values", cmbavSecfunctionalitytype.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV68TFSecFunctionalityType_Sels", AV68TFSecFunctionalityType_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV64ManageFiltersData", AV64ManageFiltersData);
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV20OrderedBy, 4, 0))+":"+(AV21OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV41IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "SecFunctionalityRole", GXv_boolean2) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV41IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41IsAuthorized_Update", AV41IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV41IsAuthorized_Update));
      if ( ! ( AV41IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_35_Refreshing);
      }
      GXt_boolean1 = AV40IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "SecFunctionalityRole", GXv_boolean2) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV40IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40IsAuthorized_Delete", AV40IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV40IsAuthorized_Delete));
      if ( ! ( AV40IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_35_Refreshing);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = AV64ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "WWPBaseObjects.SecRoleSecFunctionalityRoleWCFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[0] ;
      AV64ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV73FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73FilterFullText", AV73FilterFullText);
      AV14SecFunctionalityType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecFunctionalityType), 2, 0));
      AV44TFSecFunctionalityKey = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFSecFunctionalityKey", AV44TFSecFunctionalityKey);
      AV45TFSecFunctionalityKey_Sel = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFSecFunctionalityKey_Sel", AV45TFSecFunctionalityKey_Sel);
      AV68TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV55TFSecParentFunctionalityDescription = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFSecParentFunctionalityDescription", AV55TFSecParentFunctionalityDescription);
      AV56TFSecParentFunctionalityDescription_Sel = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFSecParentFunctionalityDescription_Sel", AV56TFSecParentFunctionalityDescription_Sel);
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV15Session.getValue(AV76Pgmname+"GridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV76Pgmname+"GridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue(AV76Pgmname+"GridState"), null, null);
      }
      AV20OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20OrderedBy), 4, 0));
      AV21OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21OrderedDsc", AV21OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S182 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV17GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV17GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S182( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV77GXV1 = 1 ;
      while ( AV77GXV1 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV1));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV73FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73FilterFullText", AV73FilterFullText);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SECFUNCTIONALITYTYPE") == 0 )
         {
            AV14SecFunctionalityType = (byte)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecFunctionalityType), 2, 0));
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV44TFSecFunctionalityKey = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFSecFunctionalityKey", AV44TFSecFunctionalityKey);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV45TFSecFunctionalityKey_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFSecFunctionalityKey_Sel", AV45TFSecFunctionalityKey_Sel);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV67TFSecFunctionalityType_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFSecFunctionalityType_SelsJson", AV67TFSecFunctionalityType_SelsJson);
            AV68TFSecFunctionalityType_Sels.fromJSonString(AV67TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV55TFSecParentFunctionalityDescription = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFSecParentFunctionalityDescription", AV55TFSecParentFunctionalityDescription);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV56TFSecParentFunctionalityDescription_Sel = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFSecParentFunctionalityDescription_Sel", AV56TFSecParentFunctionalityDescription_Sel);
         }
         AV77GXV1 = (int)(AV77GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFSecFunctionalityKey_Sel)==0), AV45TFSecFunctionalityKey_Sel, GXv_char7) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV56TFSecParentFunctionalityDescription_Sel)==0), AV56TFSecParentFunctionalityDescription_Sel, GXv_char11) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_char10 = GXv_char11[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char6+"|"+((AV68TFSecFunctionalityType_Sels.size()==0) ? "" : AV67TFSecFunctionalityType_SelsJson)+"||"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFSecFunctionalityKey)==0), AV44TFSecFunctionalityKey, GXv_char11) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV55TFSecParentFunctionalityDescription)==0), AV55TFSecParentFunctionalityDescription, GXv_char7) ;
      secrolesecfunctionalityrolewc_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char10+"|||"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV17GridState.fromxml(AV15Session.getValue(AV76Pgmname+"GridState"), null, null);
      AV17GridState.setgxTv_SdtWWPGridState_Orderedby( AV20OrderedBy );
      AV17GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV21OrderedDsc );
      AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "FILTERFULLTEXT", !(GXutil.strcmp("", AV73FilterFullText)==0), (short)(0), AV73FilterFullText, "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "SECFUNCTIONALITYTYPE", !(0==AV14SecFunctionalityType), (short)(0), GXutil.trim( GXutil.str( AV14SecFunctionalityType, 2, 0)), "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFSECFUNCTIONALITYKEY", !(GXutil.strcmp("", AV44TFSecFunctionalityKey)==0), (short)(0), AV44TFSecFunctionalityKey, "", !(GXutil.strcmp("", AV45TFSecFunctionalityKey_Sel)==0), AV45TFSecFunctionalityKey_Sel, "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFSECFUNCTIONALITYTYPE_SEL", !(AV68TFSecFunctionalityType_Sels.size()==0), (short)(0), AV68TFSecFunctionalityType_Sels.toJSonString(false), "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFSECPARENTFUNCTIONALITYDESCRIPTION", !(GXutil.strcmp("", AV55TFSecParentFunctionalityDescription)==0), (short)(0), AV55TFSecParentFunctionalityDescription, "", !(GXutil.strcmp("", AV56TFSecParentFunctionalityDescription_Sel)==0), AV56TFSecParentFunctionalityDescription_Sel, "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      if ( ! (0==AV8SecRoleId) )
      {
         AV18GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&SECROLEID" );
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV8SecRoleId, 4, 0) );
         AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV18GridStateFilterValue, 0);
      }
      AV17GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV76Pgmname+"GridState", AV17GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV76Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "WWPBaseObjects.SecFunctionalityRole" );
      AV11TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV11TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "SecRoleId" );
      AV11TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8SecRoleId, 4, 0) );
      AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV11TrnContextAtt, 0);
      AV15Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_16_142( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV64ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, sPrefix+"DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_21_142( true) ;
      }
      else
      {
         wb_table2_21_142( false) ;
      }
      return  ;
   }

   public void wb_table2_21_142e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_16_142e( true) ;
      }
      else
      {
         wb_table1_16_142e( false) ;
      }
   }

   public void wb_table2_21_142( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, "Filter Full Text", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'" + sPrefix + "',false,'" + sGXsfl_35_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV73FilterFullText, GXutil.rtrim( localUtil.format( AV73FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_WWPBaseObjects\\SecRoleSecFunctionalityRoleWC.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableDynamicFilters'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSecfunctionalitytype.getInternalname(), "Sec Functionality Type", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'" + sGXsfl_35_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSecfunctionalitytype, cmbavSecfunctionalitytype.getInternalname(), GXutil.trim( GXutil.str( AV14SecFunctionalityType, 2, 0)), 1, cmbavSecfunctionalitytype.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavSecfunctionalitytype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "", true, (byte)(1), "HLP_WWPBaseObjects\\SecRoleSecFunctionalityRoleWC.htm");
         cmbavSecfunctionalitytype.setValue( GXutil.trim( GXutil.str( AV14SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavSecfunctionalitytype.getInternalname(), "Values", cmbavSecfunctionalitytype.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_21_142e( true) ;
      }
      else
      {
         wb_table2_21_142e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecRoleId), 4, 0));
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
      pa142( ) ;
      ws142( ) ;
      we142( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV8SecRoleId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa142( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\secrolesecfunctionalityrolewc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa142( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV8SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecRoleId), 4, 0));
      }
      wcpOAV8SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8SecRoleId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( AV8SecRoleId != wcpOAV8SecRoleId ) ) )
      {
         setjustcreated();
      }
      wcpOAV8SecRoleId = AV8SecRoleId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV8SecRoleId = httpContext.cgiGet( sPrefix+"AV8SecRoleId_CTRL") ;
      if ( GXutil.len( sCtrlAV8SecRoleId) > 0 )
      {
         AV8SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV8SecRoleId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecRoleId), 4, 0));
      }
      else
      {
         AV8SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV8SecRoleId_PARM"), ",", ".")) ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa142( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws142( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws142( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8SecRoleId_PARM", GXutil.ltrim( localUtil.ntoc( AV8SecRoleId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8SecRoleId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8SecRoleId_CTRL", GXutil.rtrim( sCtrlAV8SecRoleId));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we142( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110321137", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secrolesecfunctionalityrolewc.js", "?20225110321137", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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

   public void subsflControlProps_352( )
   {
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_35_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_35_idx ;
      edtSecFunctionalityId_Internalname = sPrefix+"SECFUNCTIONALITYID_"+sGXsfl_35_idx ;
      edtSecFunctionalityKey_Internalname = sPrefix+"SECFUNCTIONALITYKEY_"+sGXsfl_35_idx ;
      cmbSecFunctionalityType.setInternalname( sPrefix+"SECFUNCTIONALITYTYPE_"+sGXsfl_35_idx );
      edtSecFunctionalityDescription_Internalname = sPrefix+"SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_35_idx ;
      edtSecParentFunctionalityDescription_Internalname = sPrefix+"SECPARENTFUNCTIONALITYDESCRIPTION_"+sGXsfl_35_idx ;
   }

   public void subsflControlProps_fel_352( )
   {
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_35_fel_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_35_fel_idx ;
      edtSecFunctionalityId_Internalname = sPrefix+"SECFUNCTIONALITYID_"+sGXsfl_35_fel_idx ;
      edtSecFunctionalityKey_Internalname = sPrefix+"SECFUNCTIONALITYKEY_"+sGXsfl_35_fel_idx ;
      cmbSecFunctionalityType.setInternalname( sPrefix+"SECFUNCTIONALITYTYPE_"+sGXsfl_35_fel_idx );
      edtSecFunctionalityDescription_Internalname = sPrefix+"SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_35_fel_idx ;
      edtSecParentFunctionalityDescription_Internalname = sPrefix+"SECPARENTFUNCTIONALITYDESCRIPTION_"+sGXsfl_35_fel_idx ;
   }

   public void sendrow_352( )
   {
      subsflControlProps_352( ) ;
      wb140( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_35_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_35_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_35_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV39Update),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(35),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV38Delete),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(35),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(35),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityKey_Internalname,A3SecFunctionalityKey,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityKey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(35),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_35_idx ;
         cmbSecFunctionalityType.setName( GXCCtl );
         cmbSecFunctionalityType.setWebtags( "" );
         cmbSecFunctionalityType.addItem("1", "Mode", (short)(0));
         cmbSecFunctionalityType.addItem("2", "Action", (short)(0));
         cmbSecFunctionalityType.addItem("3", "Tab", (short)(0));
         cmbSecFunctionalityType.addItem("4", "Object", (short)(0));
         cmbSecFunctionalityType.addItem("5", "Attribute", (short)(0));
         if ( cmbSecFunctionalityType.getItemCount() > 0 )
         {
            A9SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0))))) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSecFunctionalityType,cmbSecFunctionalityType.getInternalname(),GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)),Integer.valueOf(1),cmbSecFunctionalityType.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), !bGXsfl_35_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityDescription_Internalname,A8SecFunctionalityDescription,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtSecFunctionalityDescription_Link,"","","",edtSecFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(35),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityDescription_Internalname,A11SecParentFunctionalityDescription,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtSecParentFunctionalityDescription_Link,"","","",edtSecParentFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(35),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes142( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_35_idx = ((subGrid_Islastpage==1)&&(nGXsfl_35_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_35_idx+1) ;
         sGXsfl_35_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_35_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_352( ) ;
      }
      /* End function sendrow_352 */
   }

   public void init_default_properties( )
   {
      Ddo_managefilters_Internalname = sPrefix+"DDO_MANAGEFILTERS" ;
      edtavFilterfulltext_Internalname = sPrefix+"vFILTERFULLTEXT" ;
      cmbavSecfunctionalitytype.setInternalname( sPrefix+"vSECFUNCTIONALITYTYPE" );
      tblTablefilters_Internalname = sPrefix+"TABLEFILTERS" ;
      tblTablerightheader_Internalname = sPrefix+"TABLERIGHTHEADER" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      Dvpanel_tableheader_Internalname = sPrefix+"DVPANEL_TABLEHEADER" ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE" ;
      edtavDelete_Internalname = sPrefix+"vDELETE" ;
      edtSecFunctionalityId_Internalname = sPrefix+"SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = sPrefix+"SECFUNCTIONALITYKEY" ;
      cmbSecFunctionalityType.setInternalname( sPrefix+"SECFUNCTIONALITYTYPE" );
      edtSecFunctionalityDescription_Internalname = sPrefix+"SECFUNCTIONALITYDESCRIPTION" ;
      edtSecParentFunctionalityDescription_Internalname = sPrefix+"SECPARENTFUNCTIONALITYDESCRIPTION" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtSecRoleId_Internalname = sPrefix+"SECROLEID" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusTheme");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      edtSecParentFunctionalityDescription_Jsonclick = "" ;
      edtSecFunctionalityDescription_Jsonclick = "" ;
      cmbSecFunctionalityType.setJsonclick( "" );
      edtSecFunctionalityKey_Jsonclick = "" ;
      edtSecFunctionalityId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      cmbavSecfunctionalitytype.setJsonclick( "" );
      cmbavSecfunctionalitytype.setEnabled( 1 );
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtSecRoleId_Jsonclick = "" ;
      edtSecRoleId_Visible = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtSecParentFunctionalityDescription_Link = "" ;
      edtSecFunctionalityDescription_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Datalistproc = "WWPBaseObjects.SecRoleSecFunctionalityRoleWCGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|1:Mode,2:Action,3:Tab,4:Object,5:Attribute||" ;
      Ddo_grid_Allowmultipleselection = "|T||" ;
      Ddo_grid_Datalisttype = "Dynamic|FixedValues||Dynamic" ;
      Ddo_grid_Includedatalist = "T|T||T" ;
      Ddo_grid_Filtertype = "Character|||Character" ;
      Ddo_grid_Includefilter = "T|||T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|1|4" ;
      Ddo_grid_Columnids = "3:SecFunctionalityKey|4:SecFunctionalityType|5:SecFunctionalityDescription|6:SecParentFunctionalityDescription" ;
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
      Dvpanel_tableheader_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Iconposition = "Right" ;
      Dvpanel_tableheader_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tableheader_Title = "Opciones" ;
      Dvpanel_tableheader_Cls = "PanelNoHeader" ;
      Dvpanel_tableheader_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableheader_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Width = "100%" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      cmbavSecfunctionalitytype.setName( "vSECFUNCTIONALITYTYPE" );
      cmbavSecfunctionalitytype.setWebtags( "" );
      cmbavSecfunctionalitytype.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), "Todos", (short)(0));
      cmbavSecfunctionalitytype.addItem("1", "Mode", (short)(0));
      cmbavSecfunctionalitytype.addItem("2", "Action", (short)(0));
      cmbavSecfunctionalitytype.addItem("3", "Tab", (short)(0));
      cmbavSecfunctionalitytype.addItem("4", "Object", (short)(0));
      cmbavSecfunctionalitytype.addItem("5", "Attribute", (short)(0));
      if ( cmbavSecfunctionalitytype.getItemCount() > 0 )
      {
      }
      GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_35_idx ;
      cmbSecFunctionalityType.setName( GXCCtl );
      cmbSecFunctionalityType.setWebtags( "" );
      cmbSecFunctionalityType.addItem("1", "Mode", (short)(0));
      cmbSecFunctionalityType.addItem("2", "Action", (short)(0));
      cmbSecFunctionalityType.addItem("3", "Tab", (short)(0));
      cmbSecFunctionalityType.addItem("4", "Object", (short)(0));
      cmbSecFunctionalityType.addItem("5", "Attribute", (short)(0));
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV73FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'cmbavSecfunctionalitytype'},{av:'AV14SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'AV8SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV76Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV16IsAuthorized_SecFunctionalityDescription',fld:'vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'AV42IsAuthorized_SecParentFunctionalityDescription',fld:'vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV70GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV71GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV17GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12142',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV73FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'cmbavSecfunctionalitytype'},{av:'AV14SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'AV8SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV76Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV16IsAuthorized_SecFunctionalityDescription',fld:'vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'AV42IsAuthorized_SecParentFunctionalityDescription',fld:'vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13142',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV73FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'cmbavSecfunctionalitytype'},{av:'AV14SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'AV8SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV76Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV16IsAuthorized_SecFunctionalityDescription',fld:'vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'AV42IsAuthorized_SecParentFunctionalityDescription',fld:'vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e14142',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV73FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'cmbavSecfunctionalitytype'},{av:'AV14SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'AV8SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV76Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV16IsAuthorized_SecFunctionalityDescription',fld:'vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'AV42IsAuthorized_SecParentFunctionalityDescription',fld:'vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV67TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17142',iparms:[{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV16IsAuthorized_SecFunctionalityDescription',fld:'vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'AV42IsAuthorized_SecParentFunctionalityDescription',fld:'vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV39Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV38Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtSecFunctionalityDescription_Link',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Link'},{av:'edtSecParentFunctionalityDescription_Link',ctrl:'SECPARENTFUNCTIONALITYDESCRIPTION',prop:'Link'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11142',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV73FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'cmbavSecfunctionalitytype'},{av:'AV14SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'AV8SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV76Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV16IsAuthorized_SecFunctionalityDescription',fld:'vISAUTHORIZED_SECFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'AV42IsAuthorized_SecParentFunctionalityDescription',fld:'vISAUTHORIZED_SECPARENTFUNCTIONALITYDESCRIPTION',pic:'',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'sPrefix'},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV17GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV17GridState',fld:'vGRIDSTATE',pic:''},{av:'AV20OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV21OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV73FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'cmbavSecfunctionalitytype'},{av:'AV14SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'AV44TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV68TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV55TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV56TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV67TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV70GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV71GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VALIDV_SECFUNCTIONALITYTYPE","{handler:'validv_Secfunctionalitytype',iparms:[]");
      setEventMetadata("VALIDV_SECFUNCTIONALITYTYPE",",oparms:[]}");
      setEventMetadata("VALID_SECFUNCTIONALITYID","{handler:'valid_Secfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Secparentfunctionalitydescription',iparms:[]");
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
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV73FilterFullText = "" ;
      AV76Pgmname = "" ;
      AV44TFSecFunctionalityKey = "" ;
      AV45TFSecFunctionalityKey_Sel = "" ;
      AV68TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV55TFSecParentFunctionalityDescription = "" ;
      AV56TFSecParentFunctionalityDescription_Sel = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV64ManageFiltersData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV58DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV67TFSecFunctionalityType_SelsJson = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableheader = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV39Update = "" ;
      AV38Delete = "" ;
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      lV73FilterFullText = "" ;
      lV44TFSecFunctionalityKey = "" ;
      lV55TFSecParentFunctionalityDescription = "" ;
      H00142_A2SecParentFunctionalityId = new long[1] ;
      H00142_n2SecParentFunctionalityId = new boolean[] {false} ;
      H00142_A4SecRoleId = new short[1] ;
      H00142_A11SecParentFunctionalityDescription = new String[] {""} ;
      H00142_A8SecFunctionalityDescription = new String[] {""} ;
      H00142_A9SecFunctionalityType = new byte[1] ;
      H00142_A3SecFunctionalityKey = new String[] {""} ;
      H00142_A1SecFunctionalityId = new long[1] ;
      H00143_AGRID_nRecordCount = new long[1] ;
      hsh = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV66WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV61ManageFiltersXml = "" ;
      GXv_boolean2 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9 = new GXBaseCollection[1] ;
      AV15Session = httpContext.getWebSession();
      AV18GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState12 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9HTTPRequest = httpContext.getHttpRequest();
      AV11TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      TempTags = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8SecRoleId = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secrolesecfunctionalityrolewc__default(),
         new Object[] {
             new Object[] {
            H00142_A2SecParentFunctionalityId, H00142_n2SecParentFunctionalityId, H00142_A4SecRoleId, H00142_A11SecParentFunctionalityDescription, H00142_A8SecFunctionalityDescription, H00142_A9SecFunctionalityType, H00142_A3SecFunctionalityKey, H00142_A1SecFunctionalityId
            }
            , new Object[] {
            H00143_AGRID_nRecordCount
            }
         }
      );
      AV76Pgmname = "WWPBaseObjects.SecRoleSecFunctionalityRoleWC" ;
      /* GeneXus formulas. */
      AV76Pgmname = "WWPBaseObjects.SecRoleSecFunctionalityRoleWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV14SecFunctionalityType ;
   private byte AV60ManageFiltersExecutionStep ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte A9SecFunctionalityType ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short wcpOAV8SecRoleId ;
   private short AV8SecRoleId ;
   private short AV20OrderedBy ;
   private short A4SecRoleId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_35 ;
   private int nGXsfl_35_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int edtSecRoleId_Visible ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV68TFSecFunctionalityType_Sels_size ;
   private int AV69PageToGo ;
   private int AV77GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV70GridCurrentPage ;
   private long AV71GridPageCount ;
   private long A1SecFunctionalityId ;
   private long GRID_nCurrentRecord ;
   private long A2SecParentFunctionalityId ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_35_idx="0001" ;
   private String AV76Pgmname ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Dvpanel_tableheader_Width ;
   private String Dvpanel_tableheader_Cls ;
   private String Dvpanel_tableheader_Title ;
   private String Dvpanel_tableheader_Iconposition ;
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
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String Dvpanel_tableheader_Internalname ;
   private String divTableheader_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String AV39Update ;
   private String edtavUpdate_Link ;
   private String AV38Delete ;
   private String edtavDelete_Link ;
   private String edtSecFunctionalityDescription_Link ;
   private String edtSecParentFunctionalityDescription_Link ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtSecRoleId_Internalname ;
   private String edtSecRoleId_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavFilterfulltext_Internalname ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityDescription_Internalname ;
   private String edtSecParentFunctionalityDescription_Internalname ;
   private String scmdbuf ;
   private String hsh ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String TempTags ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sCtrlAV8SecRoleId ;
   private String sGXsfl_35_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String GXCCtl ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String edtSecParentFunctionalityDescription_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV21OrderedDsc ;
   private boolean AV41IsAuthorized_Update ;
   private boolean AV40IsAuthorized_Delete ;
   private boolean AV16IsAuthorized_SecFunctionalityDescription ;
   private boolean AV42IsAuthorized_SecParentFunctionalityDescription ;
   private boolean Dvpanel_tableheader_Autowidth ;
   private boolean Dvpanel_tableheader_Autoheight ;
   private boolean Dvpanel_tableheader_Collapsible ;
   private boolean Dvpanel_tableheader_Collapsed ;
   private boolean Dvpanel_tableheader_Showcollapseicon ;
   private boolean Dvpanel_tableheader_Autoscroll ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_35_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n2SecParentFunctionalityId ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV67TFSecFunctionalityType_SelsJson ;
   private String AV61ManageFiltersXml ;
   private String AV73FilterFullText ;
   private String AV44TFSecFunctionalityKey ;
   private String AV45TFSecFunctionalityKey_Sel ;
   private String AV55TFSecParentFunctionalityDescription ;
   private String AV56TFSecParentFunctionalityDescription_Sel ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String lV73FilterFullText ;
   private String lV44TFSecFunctionalityKey ;
   private String lV55TFSecParentFunctionalityDescription ;
   private GXSimpleCollection<Byte> AV68TFSecFunctionalityType_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavSecfunctionalitytype ;
   private HTMLChoice cmbSecFunctionalityType ;
   private IDataStoreProvider pr_default ;
   private long[] H00142_A2SecParentFunctionalityId ;
   private boolean[] H00142_n2SecParentFunctionalityId ;
   private short[] H00142_A4SecRoleId ;
   private String[] H00142_A11SecParentFunctionalityDescription ;
   private String[] H00142_A8SecFunctionalityDescription ;
   private byte[] H00142_A9SecFunctionalityType ;
   private String[] H00142_A3SecFunctionalityKey ;
   private long[] H00142_A1SecFunctionalityId ;
   private long[] H00143_AGRID_nRecordCount ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV64ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV66WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV11TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV58DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class secrolesecfunctionalityrolewc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00142( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV68TFSecFunctionalityType_Sels ,
                                          String AV73FilterFullText ,
                                          byte AV14SecFunctionalityType ,
                                          String AV45TFSecFunctionalityKey_Sel ,
                                          String AV44TFSecFunctionalityKey ,
                                          int AV68TFSecFunctionalityType_Sels_size ,
                                          String AV56TFSecParentFunctionalityDescription_Sel ,
                                          String AV55TFSecParentFunctionalityDescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV20OrderedBy ,
                                          boolean AV21OrderedDsc ,
                                          short AV8SecRoleId ,
                                          short A4SecRoleId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[17];
      Object[] GXv_Object14 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecRoleId], T3.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T2.[SecFunctionalityDescription]," ;
      sSelectString += " T2.[SecFunctionalityType], T2.[SecFunctionalityKey], T1.[SecFunctionalityId]" ;
      sFromString = " FROM (([SecFunctionalityRole] T1 INNER JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecFunctionalityId]) LEFT JOIN [SecFunctionality] T3 ON T3.[SecFunctionalityId]" ;
      sFromString += " = T2.[SecParentFunctionalityId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.[SecRoleId] = ?)");
      if ( ! (GXutil.strcmp("", AV73FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( T2.[SecFunctionalityKey] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?) or ( T3.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int13[1] = (byte)(1) ;
         GXv_int13[2] = (byte)(1) ;
         GXv_int13[3] = (byte)(1) ;
         GXv_int13[4] = (byte)(1) ;
         GXv_int13[5] = (byte)(1) ;
         GXv_int13[6] = (byte)(1) ;
         GXv_int13[7] = (byte)(1) ;
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (0==AV14SecFunctionalityType) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityType] = ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV45TFSecFunctionalityKey_Sel)==0) && ( ! (GXutil.strcmp("", AV44TFSecFunctionalityKey)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int13[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV45TFSecFunctionalityKey_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int13[11] = (byte)(1) ;
      }
      if ( AV68TFSecFunctionalityType_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV68TFSecFunctionalityType_Sels, "T2.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV56TFSecParentFunctionalityDescription_Sel)==0) && ( ! (GXutil.strcmp("", AV55TFSecParentFunctionalityDescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int13[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56TFSecParentFunctionalityDescription_Sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int13[13] = (byte)(1) ;
      }
      if ( ( AV20OrderedBy == 1 ) && ! AV21OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecRoleId], T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV20OrderedBy == 1 ) && ( AV21OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecRoleId] DESC, T2.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ! AV21OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecRoleId], T2.[SecFunctionalityKey]" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ( AV21OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecRoleId] DESC, T2.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ! AV21OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecRoleId], T2.[SecFunctionalityType]" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ( AV21OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecRoleId] DESC, T2.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ! AV21OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecRoleId], T3.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ( AV21OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecRoleId] DESC, T3.[SecFunctionalityDescription] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityId], T1.[SecRoleId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_H00143( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV68TFSecFunctionalityType_Sels ,
                                          String AV73FilterFullText ,
                                          byte AV14SecFunctionalityType ,
                                          String AV45TFSecFunctionalityKey_Sel ,
                                          String AV44TFSecFunctionalityKey ,
                                          int AV68TFSecFunctionalityType_Sels_size ,
                                          String AV56TFSecParentFunctionalityDescription_Sel ,
                                          String AV55TFSecParentFunctionalityDescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV20OrderedBy ,
                                          boolean AV21OrderedDsc ,
                                          short AV8SecRoleId ,
                                          short A4SecRoleId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[14];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([SecFunctionalityRole] T1 INNER JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecFunctionalityId]) LEFT JOIN [SecFunctionality]" ;
      scmdbuf += " T3 ON T3.[SecFunctionalityId] = T2.[SecParentFunctionalityId])" ;
      addWhere(sWhereString, "(T1.[SecRoleId] = ?)");
      if ( ! (GXutil.strcmp("", AV73FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( T2.[SecFunctionalityKey] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T2.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?) or ( T3.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int16[1] = (byte)(1) ;
         GXv_int16[2] = (byte)(1) ;
         GXv_int16[3] = (byte)(1) ;
         GXv_int16[4] = (byte)(1) ;
         GXv_int16[5] = (byte)(1) ;
         GXv_int16[6] = (byte)(1) ;
         GXv_int16[7] = (byte)(1) ;
         GXv_int16[8] = (byte)(1) ;
      }
      if ( ! (0==AV14SecFunctionalityType) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityType] = ?)");
      }
      else
      {
         GXv_int16[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV45TFSecFunctionalityKey_Sel)==0) && ( ! (GXutil.strcmp("", AV44TFSecFunctionalityKey)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int16[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV45TFSecFunctionalityKey_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int16[11] = (byte)(1) ;
      }
      if ( AV68TFSecFunctionalityType_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV68TFSecFunctionalityType_Sels, "T2.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV56TFSecParentFunctionalityDescription_Sel)==0) && ( ! (GXutil.strcmp("", AV55TFSecParentFunctionalityDescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int16[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56TFSecParentFunctionalityDescription_Sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int16[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV20OrderedBy == 1 ) && ! AV21OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 1 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ! AV21OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ! AV21OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ! AV21OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
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
                  return conditional_H00142(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() );
            case 1 :
                  return conditional_H00143(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00142", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00143", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((long[]) buf[7])[0] = rslt.getLong(7);
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
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
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
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[32]).intValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
      }
   }

}

