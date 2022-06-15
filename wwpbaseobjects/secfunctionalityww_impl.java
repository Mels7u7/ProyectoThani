package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secfunctionalityww_impl extends GXDataArea
{
   public secfunctionalityww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secfunctionalityww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityww_impl.class ));
   }

   public secfunctionalityww_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSecFunctionalityType = new HTMLChoice();
      chkSecFunctionalityActive = UIFactory.getCheckbox(this);
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
            nRC_GXsfl_43 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_43"))) ;
            nGXsfl_43_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_43_idx"))) ;
            sGXsfl_43_idx = httpContext.GetPar( "sGXsfl_43_idx") ;
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
            AV87FilterFullText = httpContext.GetPar( "FilterFullText") ;
            AV34ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV72ColumnsSelector);
            AV41TFSecFunctionalityKey = httpContext.GetPar( "TFSecFunctionalityKey") ;
            AV42TFSecFunctionalityKey_Sel = httpContext.GetPar( "TFSecFunctionalityKey_Sel") ;
            AV45TFSecFunctionalityDescription = httpContext.GetPar( "TFSecFunctionalityDescription") ;
            AV46TFSecFunctionalityDescription_Sel = httpContext.GetPar( "TFSecFunctionalityDescription_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV81TFSecFunctionalityType_Sels);
            AV52TFSecParentFunctionalityDescription = httpContext.GetPar( "TFSecParentFunctionalityDescription") ;
            AV53TFSecParentFunctionalityDescription_Sel = httpContext.GetPar( "TFSecParentFunctionalityDescription_Sel") ;
            AV99Pgmname = httpContext.GetPar( "Pgmname") ;
            AV29OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV30OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV18IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV19IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV87FilterFullText, AV34ManageFiltersExecutionStep, AV72ColumnsSelector, AV41TFSecFunctionalityKey, AV42TFSecFunctionalityKey_Sel, AV45TFSecFunctionalityDescription, AV46TFSecFunctionalityDescription_Sel, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV53TFSecParentFunctionalityDescription_Sel, AV99Pgmname, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_gridcolumnsselector_Titlecontrolidtoreplace));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      pa0P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0P2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331086", false, true);
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
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
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
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV99Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV87FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_43", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_43, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV38ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV38ManageFiltersData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV83GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV84GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV55DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV55DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV72ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV72ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV34ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYKEY", AV41TFSecFunctionalityKey);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYKEY_SEL", AV42TFSecFunctionalityKey_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYDESCRIPTION", AV45TFSecFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYDESCRIPTION_SEL", AV46TFSecFunctionalityDescription_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECFUNCTIONALITYTYPE_SELS", AV81TFSecFunctionalityType_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECFUNCTIONALITYTYPE_SELS", AV81TFSecFunctionalityType_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECPARENTFUNCTIONALITYDESCRIPTION", AV52TFSecParentFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL", AV53TFSecParentFunctionalityDescription_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV99Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV99Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV29OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV30OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV18IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV19IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV27GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV27GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYTYPE_SELSJSON", AV80TFSecFunctionalityType_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_gridcolumnsselector_Titlecontrolidtoreplace));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0P2( ) ;
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
      return formatLink("com.projectthani.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecFunctionalityWW" ;
   }

   public String getPgmdesc( )
   {
      return " Functionality" ;
   }

   public void wb0P0( )
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
         ucDvpanel_tableheader.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableheader_Internalname, "DVPANEL_TABLEHEADERContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEHEADERContainer"+"TableHeader"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupColorFilledActions", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_0P2( true) ;
      }
      else
      {
         wb_table1_25_0P2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_0P2e( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
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
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"43\">") ;
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
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUaviewchildren_Class+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecFunctionalityKey_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Key") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecFunctionalityDescription_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Description") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbSecFunctionalityType.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Type") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecParentFunctionalityDescription_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Parent Functionality") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV11Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV24UAViewChildren));
            GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUaviewchildren_Class));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUaviewchildren_Link));
            GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavUaviewchildren_Tooltiptext));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A3SecFunctionalityKey);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityKey_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A8SecFunctionalityDescription);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSecFunctionalityDescription_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityDescription_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A9SecFunctionalityType, (byte)(2), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbSecFunctionalityType.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2SecParentFunctionalityId, (byte)(10), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A11SecParentFunctionalityDescription);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSecParentFunctionalityDescription_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecParentFunctionalityDescription_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( A7SecFunctionalityActive));
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
      if ( wbEnd == 43 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_43 = (int)(nGXsfl_43_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV83GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV84GridPageCount);
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
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV55DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV55DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV72ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 43 )
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

   public void start0P2( )
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
         Form.getMeta().addItem("description", " Functionality", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0P0( ) ;
   }

   public void ws0P2( )
   {
      start0P2( ) ;
      evt0P2( ) ;
   }

   public void evt0P2( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e110P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e120P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e130P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e140P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e150P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e160P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e170P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e180P2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_43_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_432( ) ;
                           AV11Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV11Update);
                           AV12Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV12Delete);
                           AV24UAViewChildren = httpContext.cgiGet( edtavUaviewchildren_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaviewchildren_Internalname, "Bitmap", ((GXutil.strcmp("", AV24UAViewChildren)==0) ? AV98Uaviewchildren_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24UAViewChildren))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaviewchildren_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24UAViewChildren), true);
                           A1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") ;
                           A3SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
                           A8SecFunctionalityDescription = httpContext.cgiGet( edtSecFunctionalityDescription_Internalname) ;
                           cmbSecFunctionalityType.setName( cmbSecFunctionalityType.getInternalname() );
                           cmbSecFunctionalityType.setValue( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()) );
                           A9SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
                           A2SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), ",", ".") ;
                           n2SecParentFunctionalityId = false ;
                           A11SecParentFunctionalityDescription = httpContext.cgiGet( edtSecParentFunctionalityDescription_Internalname) ;
                           A7SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( chkSecFunctionalityActive.getInternalname())) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e190P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e200P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e210P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV87FilterFullText) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
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

   public void we0P2( )
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

   public void pa0P2( )
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
      subsflControlProps_432( ) ;
      while ( nGXsfl_43_idx <= nRC_GXsfl_43 )
      {
         sendrow_432( ) ;
         nGXsfl_43_idx = ((subGrid_Islastpage==1)&&(nGXsfl_43_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV87FilterFullText ,
                                 byte AV34ManageFiltersExecutionStep ,
                                 com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV72ColumnsSelector ,
                                 String AV41TFSecFunctionalityKey ,
                                 String AV42TFSecFunctionalityKey_Sel ,
                                 String AV45TFSecFunctionalityDescription ,
                                 String AV46TFSecFunctionalityDescription_Sel ,
                                 GXSimpleCollection<Byte> AV81TFSecFunctionalityType_Sels ,
                                 String AV52TFSecParentFunctionalityDescription ,
                                 String AV53TFSecParentFunctionalityDescription_Sel ,
                                 String AV99Pgmname ,
                                 short AV29OrderedBy ,
                                 boolean AV30OrderedDsc ,
                                 boolean AV18IsAuthorized_Update ,
                                 boolean AV19IsAuthorized_Delete )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e200P2 ();
      GRID_nCurrentRecord = 0 ;
      rf0P2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
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
      rf0P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV99Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf0P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e200P2 ();
      nGXsfl_43_idx = 1 ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_432( ) ;
      bGXsfl_43_Refreshing = true ;
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
         subsflControlProps_432( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Byte.valueOf(A9SecFunctionalityType) ,
                                              AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                              AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                              AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                              AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                              AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                              AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                              Integer.valueOf(AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                              AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                              AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                              A3SecFunctionalityKey ,
                                              A8SecFunctionalityDescription ,
                                              A11SecParentFunctionalityDescription ,
                                              Short.valueOf(AV29OrderedBy) ,
                                              Boolean.valueOf(AV30OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
         lV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
         lV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
         lV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
         /* Using cursor H000P2 */
         pr_default.execute(0, new Object[] {lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A7SecFunctionalityActive = H000P2_A7SecFunctionalityActive[0] ;
            A11SecParentFunctionalityDescription = H000P2_A11SecParentFunctionalityDescription[0] ;
            A2SecParentFunctionalityId = H000P2_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = H000P2_n2SecParentFunctionalityId[0] ;
            A9SecFunctionalityType = H000P2_A9SecFunctionalityType[0] ;
            A8SecFunctionalityDescription = H000P2_A8SecFunctionalityDescription[0] ;
            A3SecFunctionalityKey = H000P2_A3SecFunctionalityKey[0] ;
            A1SecFunctionalityId = H000P2_A1SecFunctionalityId[0] ;
            A11SecParentFunctionalityDescription = H000P2_A11SecParentFunctionalityDescription[0] ;
            e210P2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb0P0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0P2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV99Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV99Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV18IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV19IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9")));
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
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                           AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                           AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                           AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                           AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                           AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                           AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV29OrderedBy) ,
                                           Boolean.valueOf(AV30OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
      lV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor H000P3 */
      pr_default.execute(1, new Object[] {lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel});
      GRID_nRecordCount = H000P3_AGRID_nRecordCount[0] ;
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
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV87FilterFullText, AV34ManageFiltersExecutionStep, AV72ColumnsSelector, AV41TFSecFunctionalityKey, AV42TFSecFunctionalityKey_Sel, AV45TFSecFunctionalityDescription, AV46TFSecFunctionalityDescription_Sel, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV53TFSecParentFunctionalityDescription_Sel, AV99Pgmname, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87FilterFullText, AV34ManageFiltersExecutionStep, AV72ColumnsSelector, AV41TFSecFunctionalityKey, AV42TFSecFunctionalityKey_Sel, AV45TFSecFunctionalityDescription, AV46TFSecFunctionalityDescription_Sel, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV53TFSecParentFunctionalityDescription_Sel, AV99Pgmname, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87FilterFullText, AV34ManageFiltersExecutionStep, AV72ColumnsSelector, AV41TFSecFunctionalityKey, AV42TFSecFunctionalityKey_Sel, AV45TFSecFunctionalityDescription, AV46TFSecFunctionalityDescription_Sel, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV53TFSecParentFunctionalityDescription_Sel, AV99Pgmname, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87FilterFullText, AV34ManageFiltersExecutionStep, AV72ColumnsSelector, AV41TFSecFunctionalityKey, AV42TFSecFunctionalityKey_Sel, AV45TFSecFunctionalityDescription, AV46TFSecFunctionalityDescription_Sel, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV53TFSecParentFunctionalityDescription_Sel, AV99Pgmname, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV87FilterFullText, AV34ManageFiltersExecutionStep, AV72ColumnsSelector, AV41TFSecFunctionalityKey, AV42TFSecFunctionalityKey_Sel, AV45TFSecFunctionalityDescription, AV46TFSecFunctionalityDescription_Sel, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV53TFSecParentFunctionalityDescription_Sel, AV99Pgmname, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV99Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e190P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV38ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV55DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV72ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV83GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV84GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Dvpanel_tableheader_Width = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Width") ;
         Dvpanel_tableheader_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autowidth")) ;
         Dvpanel_tableheader_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autoheight")) ;
         Dvpanel_tableheader_Cls = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Cls") ;
         Dvpanel_tableheader_Title = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Title") ;
         Dvpanel_tableheader_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Collapsible")) ;
         Dvpanel_tableheader_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Collapsed")) ;
         Dvpanel_tableheader_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Showcollapseicon")) ;
         Dvpanel_tableheader_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Iconposition") ;
         Dvpanel_tableheader_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autoscroll")) ;
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
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Innewwindow1_Width = httpContext.cgiGet( "INNEWWINDOW1_Width") ;
         Innewwindow1_Height = httpContext.cgiGet( "INNEWWINDOW1_Height") ;
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_gridcolumnsselector_Titlecontrolidtoreplace = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV87FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87FilterFullText", AV87FilterFullText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV87FilterFullText) != 0 )
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
      e190P2 ();
      if (returnInSub) return;
   }

   public void e190P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV7HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Functionality" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV29OrderedBy < 1 )
      {
         AV29OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV55DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV55DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e200P2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV79WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV79WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV34ManageFiltersExecutionStep == 1 )
      {
         AV34ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34ManageFiltersExecutionStep", GXutil.str( AV34ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV34ManageFiltersExecutionStep == 2 )
      {
         AV34ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34ManageFiltersExecutionStep", GXutil.str( AV34ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV13Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector"), "") != 0 )
      {
         AV60ColumnsSelectorXML = AV13Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector") ;
         AV72ColumnsSelector.fromxml(AV60ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtSecFunctionalityKey_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSecFunctionalityDescription_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityDescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityDescription_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbSecFunctionalityType.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Visible", GXutil.ltrimstr( cmbSecFunctionalityType.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtSecParentFunctionalityDescription_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityDescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityDescription_Visible), 5, 0), !bGXsfl_43_Refreshing);
      AV83GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83GridCurrentPage), 10, 0));
      AV84GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84GridPageCount), 10, 0));
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV87FilterFullText ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV42TFSecFunctionalityKey_Sel ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV46TFSecFunctionalityDescription_Sel ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV53TFSecParentFunctionalityDescription_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72ColumnsSelector", AV72ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38ManageFiltersData", AV38ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27GridState", AV27GridState);
   }

   public void e120P2( )
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
         AV82PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV82PageToGo) ;
      }
   }

   public void e130P2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e140P2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV29OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
         AV30OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30OrderedDsc", AV30OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityKey") == 0 )
         {
            AV41TFSecFunctionalityKey = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSecFunctionalityKey", AV41TFSecFunctionalityKey);
            AV42TFSecFunctionalityKey_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSecFunctionalityKey_Sel", AV42TFSecFunctionalityKey_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityDescription") == 0 )
         {
            AV45TFSecFunctionalityDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFSecFunctionalityDescription", AV45TFSecFunctionalityDescription);
            AV46TFSecFunctionalityDescription_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFSecFunctionalityDescription_Sel", AV46TFSecFunctionalityDescription_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityType") == 0 )
         {
            AV80TFSecFunctionalityType_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecFunctionalityType_SelsJson", AV80TFSecFunctionalityType_SelsJson);
            AV81TFSecFunctionalityType_Sels.fromJSonString(GXutil.strReplace( AV80TFSecFunctionalityType_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecParentFunctionalityDescription") == 0 )
         {
            AV52TFSecParentFunctionalityDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSecParentFunctionalityDescription", AV52TFSecParentFunctionalityDescription);
            AV53TFSecParentFunctionalityDescription_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFSecParentFunctionalityDescription_Sel", AV53TFSecParentFunctionalityDescription_Sel);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFSecFunctionalityType_Sels", AV81TFSecFunctionalityType_Sels);
   }

   private void e210P2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV11Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV11Update);
      if ( AV18IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0))}, new String[] {"Mode","SecFunctionalityId"})  ;
      }
      AV12Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV12Delete);
      if ( AV19IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0))}, new String[] {"Mode","SecFunctionalityId"})  ;
      }
      AV24UAViewChildren = context.getHttpContext().getImagePath( "f11923b6-6acd-4a79-bfc0-0cfc6f3bced5", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUaviewchildren_Internalname, AV24UAViewChildren);
      AV98Uaviewchildren_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "f11923b6-6acd-4a79-bfc0-0cfc6f3bced5", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavUaviewchildren_Tooltiptext = "View Actions, Tabs and Modes" ;
      GXt_boolean4 = AV15TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new com.projectthani.wwpbaseobjects.secfunctionalityhaschildren(remoteHandle, context).execute( A1SecFunctionalityId, GXv_boolean5) ;
      secfunctionalityww_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV15TempBoolean = GXt_boolean4 ;
      if ( AV15TempBoolean )
      {
         edtavUaviewchildren_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityfilterparentww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0))}, new String[] {"SecParentFunctionalityId"})  ;
         edtavUaviewchildren_Class = "ActionBaseColorAttribute" ;
      }
      else
      {
         edtavUaviewchildren_Link = "" ;
         edtavUaviewchildren_Class = "Invisible" ;
      }
      edtSecFunctionalityDescription_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1SecFunctionalityId,10,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecFunctionalityId","TabCode"})  ;
      edtSecParentFunctionalityDescription_Link = formatLink("com.projectthani.wwpbaseobjects.secfunctionalityview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A2SecParentFunctionalityId,10,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecFunctionalityId","TabCode"})  ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(43) ;
      }
      sendrow_432( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_43_Refreshing )
      {
         httpContext.doAjaxLoad(43, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e150P2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV60ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV72ColumnsSelector.fromJSonString(AV60ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWColumnsSelector", ((GXutil.strcmp("", AV60ColumnsSelectorXML)==0) ? "" : AV72ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72ColumnsSelector", AV72ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38ManageFiltersData", AV38ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27GridState", AV27GridState);
   }

   public void e110P2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S182 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("WWPBaseObjects.SecFunctionalityWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV99Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV34ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34ManageFiltersExecutionStep", GXutil.str( AV34ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("WWPBaseObjects.SecFunctionalityWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV34ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34ManageFiltersExecutionStep", GXutil.str( AV34ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV35ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         secfunctionalityww_impl.this.GXt_char6 = GXv_char7[0] ;
         AV35ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV35ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem("El filtro seleccionado no existe más.");
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV99Pgmname+"GridState", AV35ManageFiltersXml) ;
            AV27GridState.fromxml(AV35ManageFiltersXml, null, null);
            AV29OrderedBy = AV27GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
            AV30OrderedDsc = AV27GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30OrderedDsc", AV30OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S192 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
            httpContext.doAjaxRefresh();
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27GridState", AV27GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFSecFunctionalityType_Sels", AV81TFSecFunctionalityType_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72ColumnsSelector", AV72ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38ManageFiltersData", AV38ManageFiltersData);
   }

   public void e160P2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","SecFunctionalityId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e170P2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV32ExcelFilename ;
      GXv_char8[0] = AV33ErrorMessage ;
      new com.projectthani.wwpbaseobjects.secfunctionalitywwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      secfunctionalityww_impl.this.AV32ExcelFilename = GXv_char7[0] ;
      secfunctionalityww_impl.this.AV33ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV32ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV32ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV33ErrorMessage);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27GridState", AV27GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFSecFunctionalityType_Sels", AV81TFSecFunctionalityType_Sels);
   }

   public void e180P2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.wwpbaseobjects.asecfunctionalitywwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27GridState", AV27GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFSecFunctionalityType_Sels", AV81TFSecFunctionalityType_Sels);
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV29OrderedBy, 4, 0))+":"+(AV30OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV72ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV72ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecFunctionalityKey", "", "Key", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV72ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecFunctionalityDescription", "", "Description", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV72ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecFunctionalityType", "", "Type", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV72ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecParentFunctionalityDescription", "", "Parent Functionality", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV67UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWColumnsSelector", GXv_char8) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char8[0] ;
      AV67UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV67UserCustomValue)==0) ) )
      {
         AV85ColumnsSelectorAux.fromxml(AV67UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV85ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV72ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV85ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV72ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean4 = AV18IsAuthorized_Update ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFunctionality", GXv_boolean5) ;
      secfunctionalityww_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV18IsAuthorized_Update = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18IsAuthorized_Update", AV18IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      if ( ! ( AV18IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean4 = AV19IsAuthorized_Delete ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFunctionality", GXv_boolean5) ;
      secfunctionalityww_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV19IsAuthorized_Delete = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19IsAuthorized_Delete", AV19IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      if ( ! ( AV19IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean4 = AV15TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFunctionality", GXv_boolean5) ;
      secfunctionalityww_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV15TempBoolean = GXt_boolean4 ;
      if ( ! ( AV15TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = AV38ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV38ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV87FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87FilterFullText", AV87FilterFullText);
      AV41TFSecFunctionalityKey = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFSecFunctionalityKey", AV41TFSecFunctionalityKey);
      AV42TFSecFunctionalityKey_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFSecFunctionalityKey_Sel", AV42TFSecFunctionalityKey_Sel);
      AV45TFSecFunctionalityDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFSecFunctionalityDescription", AV45TFSecFunctionalityDescription);
      AV46TFSecFunctionalityDescription_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFSecFunctionalityDescription_Sel", AV46TFSecFunctionalityDescription_Sel);
      AV81TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV52TFSecParentFunctionalityDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFSecParentFunctionalityDescription", AV52TFSecParentFunctionalityDescription);
      AV53TFSecParentFunctionalityDescription_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFSecParentFunctionalityDescription_Sel", AV53TFSecParentFunctionalityDescription_Sel);
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV13Session.getValue(AV99Pgmname+"GridState"), "") == 0 )
      {
         AV27GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV99Pgmname+"GridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV13Session.getValue(AV99Pgmname+"GridState"), null, null);
      }
      AV29OrderedBy = AV27GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
      AV30OrderedDsc = AV27GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30OrderedDsc", AV30OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV27GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV27GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV27GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV100GXV1 = 1 ;
      while ( AV100GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV100GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV87FilterFullText = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87FilterFullText", AV87FilterFullText);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV41TFSecFunctionalityKey = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSecFunctionalityKey", AV41TFSecFunctionalityKey);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV42TFSecFunctionalityKey_Sel = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSecFunctionalityKey_Sel", AV42TFSecFunctionalityKey_Sel);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV45TFSecFunctionalityDescription = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFSecFunctionalityDescription", AV45TFSecFunctionalityDescription);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV46TFSecFunctionalityDescription_Sel = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFSecFunctionalityDescription_Sel", AV46TFSecFunctionalityDescription_Sel);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV80TFSecFunctionalityType_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecFunctionalityType_SelsJson", AV80TFSecFunctionalityType_SelsJson);
            AV81TFSecFunctionalityType_Sels.fromJSonString(AV80TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV52TFSecParentFunctionalityDescription = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSecParentFunctionalityDescription", AV52TFSecParentFunctionalityDescription);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV53TFSecParentFunctionalityDescription_Sel = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFSecParentFunctionalityDescription_Sel", AV53TFSecParentFunctionalityDescription_Sel);
         }
         AV100GXV1 = (int)(AV100GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFSecFunctionalityKey_Sel)==0), AV42TFSecFunctionalityKey_Sel, GXv_char8) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV46TFSecFunctionalityDescription_Sel)==0), AV46TFSecFunctionalityDescription_Sel, GXv_char7) ;
      secfunctionalityww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV53TFSecParentFunctionalityDescription_Sel)==0), AV53TFSecParentFunctionalityDescription_Sel, GXv_char15) ;
      secfunctionalityww_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char6+"|"+GXt_char13+"|"+((AV81TFSecFunctionalityType_Sels.size()==0) ? "" : AV80TFSecFunctionalityType_SelsJson)+"|"+GXt_char14 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV41TFSecFunctionalityKey)==0), AV41TFSecFunctionalityKey, GXv_char15) ;
      secfunctionalityww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char8[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFSecFunctionalityDescription)==0), AV45TFSecFunctionalityDescription, GXv_char8) ;
      secfunctionalityww_impl.this.GXt_char13 = GXv_char8[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFSecParentFunctionalityDescription)==0), AV52TFSecParentFunctionalityDescription, GXv_char7) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char14+"|"+GXt_char13+"||"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV27GridState.fromxml(AV13Session.getValue(AV99Pgmname+"GridState"), null, null);
      AV27GridState.setgxTv_SdtWWPGridState_Orderedby( AV29OrderedBy );
      AV27GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV30OrderedDsc );
      AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "FILTERFULLTEXT", !(GXutil.strcmp("", AV87FilterFullText)==0), (short)(0), AV87FilterFullText, "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECFUNCTIONALITYKEY", !(GXutil.strcmp("", AV41TFSecFunctionalityKey)==0), (short)(0), AV41TFSecFunctionalityKey, "", !(GXutil.strcmp("", AV42TFSecFunctionalityKey_Sel)==0), AV42TFSecFunctionalityKey_Sel, "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECFUNCTIONALITYDESCRIPTION", !(GXutil.strcmp("", AV45TFSecFunctionalityDescription)==0), (short)(0), AV45TFSecFunctionalityDescription, "", !(GXutil.strcmp("", AV46TFSecFunctionalityDescription_Sel)==0), AV46TFSecFunctionalityDescription_Sel, "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECFUNCTIONALITYTYPE_SEL", !(AV81TFSecFunctionalityType_Sels.size()==0), (short)(0), AV81TFSecFunctionalityType_Sels.toJSonString(false), "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECPARENTFUNCTIONALITYDESCRIPTION", !(GXutil.strcmp("", AV52TFSecParentFunctionalityDescription)==0), (short)(0), AV52TFSecParentFunctionalityDescription, "", !(GXutil.strcmp("", AV53TFSecParentFunctionalityDescription_Sel)==0), AV53TFSecParentFunctionalityDescription_Sel, "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      AV27GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV27GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV99Pgmname+"GridState", AV27GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV99Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV7HTTPRequest.getScriptName()+"?"+AV7HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "WWPBaseObjects.SecFunctionality" );
      AV13Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_0P2( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV38ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_30_0P2( true) ;
      }
      else
      {
         wb_table2_30_0P2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_0P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_0P2e( true) ;
      }
      else
      {
         wb_table1_25_0P2e( false) ;
      }
   }

   public void wb_table2_30_0P2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV87FilterFullText, GXutil.rtrim( localUtil.format( AV87FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_0P2e( true) ;
      }
      else
      {
         wb_table2_30_0P2e( false) ;
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
      pa0P2( ) ;
      ws0P2( ) ;
      we0P2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331422", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secfunctionalityww.js", "?20225110331422", false, true);
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
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_idx ;
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN_"+sGXsfl_43_idx ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_43_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_43_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_43_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_43_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_43_idx ;
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION_"+sGXsfl_43_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN_"+sGXsfl_43_fel_idx ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_43_fel_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_43_fel_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_43_fel_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_43_fel_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_43_fel_idx ;
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION_"+sGXsfl_43_fel_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb0P0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_43_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_43_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_43_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV11Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV12Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = edtavUaviewchildren_Class ;
         StyleString = "" ;
         AV24UAViewChildren_IsBlob = (boolean)(((GXutil.strcmp("", AV24UAViewChildren)==0)&&(GXutil.strcmp("", AV98Uaviewchildren_GXI)==0))||!(GXutil.strcmp("", AV24UAViewChildren)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV24UAViewChildren)==0) ? AV98Uaviewchildren_GXI : httpContext.getResourceRelative(AV24UAViewChildren)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavUaviewchildren_Internalname,sImgUrl,edtavUaviewchildren_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"",edtavUaviewchildren_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWActionColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV24UAViewChildren_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecFunctionalityKey_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityKey_Internalname,A3SecFunctionalityKey,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityKey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecFunctionalityKey_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecFunctionalityDescription_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityDescription_Internalname,A8SecFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'",edtSecFunctionalityDescription_Link,"","","",edtSecFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSecFunctionalityDescription_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbSecFunctionalityType.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbSecFunctionalityType.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_43_idx ;
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
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSecFunctionalityType,cmbSecFunctionalityType.getInternalname(),GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)),Integer.valueOf(1),cmbSecFunctionalityType.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbSecFunctionalityType.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A2SecParentFunctionalityId, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecParentFunctionalityDescription_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityDescription_Internalname,A11SecParentFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'",edtSecParentFunctionalityDescription_Link,"","","",edtSecParentFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecParentFunctionalityDescription_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_43_idx ;
         chkSecFunctionalityActive.setName( GXCCtl );
         chkSecFunctionalityActive.setWebtags( "" );
         chkSecFunctionalityActive.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_43_Refreshing);
         chkSecFunctionalityActive.setCheckedValue( "false" );
         A7SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A7SecFunctionalityActive)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSecFunctionalityActive.getInternalname(),GXutil.booltostr( A7SecFunctionalityActive),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         send_integrity_lvl_hashes0P2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_43_idx = ((subGrid_Islastpage==1)&&(nGXsfl_43_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
      }
      /* End function sendrow_432 */
   }

   public void init_default_properties( )
   {
      bttBtninsert_Internalname = "BTNINSERT" ;
      bttBtnexport_Internalname = "BTNEXPORT" ;
      bttBtnexportreport_Internalname = "BTNEXPORTREPORT" ;
      bttBtneditcolumns_Internalname = "BTNEDITCOLUMNS" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      Dvpanel_tableheader_Internalname = "DVPANEL_TABLEHEADER" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN" ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY" ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION" ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE" );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID" ;
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION" ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
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
      chkSecFunctionalityActive.setCaption( "" );
      edtSecParentFunctionalityDescription_Jsonclick = "" ;
      edtSecParentFunctionalityId_Jsonclick = "" ;
      cmbSecFunctionalityType.setJsonclick( "" );
      edtSecFunctionalityDescription_Jsonclick = "" ;
      edtSecFunctionalityKey_Jsonclick = "" ;
      edtSecFunctionalityId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtSecParentFunctionalityDescription_Link = "" ;
      edtSecFunctionalityDescription_Link = "" ;
      edtavUaviewchildren_Tooltiptext = "View Actions, Tabs and Modes" ;
      edtavUaviewchildren_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtSecParentFunctionalityDescription_Visible = -1 ;
      cmbSecFunctionalityType.setVisible( -1 );
      edtSecFunctionalityDescription_Visible = -1 ;
      edtSecFunctionalityKey_Visible = -1 ;
      edtavUaviewchildren_Class = "ActionBaseColorAttribute" ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Functionality" );
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = "" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector hidden-xs" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = "Selecciona columnas" ;
      Innewwindow1_Target = "" ;
      Innewwindow1_Height = "50" ;
      Innewwindow1_Width = "50" ;
      Ddo_grid_Datalistproc = "WWPBaseObjects.SecFunctionalityWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||1:Mode,2:Action,3:Tab,4:Object,5:Attribute|" ;
      Ddo_grid_Allowmultipleselection = "||T|" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|FixedValues|Dynamic" ;
      Ddo_grid_Includedatalist = "T" ;
      Ddo_grid_Filtertype = "Character|Character||Character" ;
      Ddo_grid_Includefilter = "T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4" ;
      Ddo_grid_Columnids = "4:SecFunctionalityKey|5:SecFunctionalityDescription|6:SecFunctionalityType|8:SecParentFunctionalityDescription" ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_43_idx ;
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
      GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_43_idx ;
      chkSecFunctionalityActive.setName( GXCCtl );
      chkSecFunctionalityActive.setWebtags( "" );
      chkSecFunctionalityActive.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_43_Refreshing);
      chkSecFunctionalityActive.setCheckedValue( "false" );
      A7SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A7SecFunctionalityActive)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtSecFunctionalityKey_Visible',ctrl:'SECFUNCTIONALITYKEY',prop:'Visible'},{av:'edtSecFunctionalityDescription_Visible',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'cmbSecFunctionalityType'},{av:'edtSecParentFunctionalityDescription_Visible',ctrl:'SECPARENTFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'AV83GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV84GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV38ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e120P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e130P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e140P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e210P2',iparms:[{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A2SecParentFunctionalityId',fld:'SECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV11Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV12Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV24UAViewChildren',fld:'vUAVIEWCHILDREN',pic:''},{av:'edtavUaviewchildren_Tooltiptext',ctrl:'vUAVIEWCHILDREN',prop:'Tooltiptext'},{av:'edtavUaviewchildren_Link',ctrl:'vUAVIEWCHILDREN',prop:'Link'},{av:'edtavUaviewchildren_Class',ctrl:'vUAVIEWCHILDREN',prop:'Class'},{av:'edtSecFunctionalityDescription_Link',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Link'},{av:'edtSecParentFunctionalityDescription_Link',ctrl:'SECPARENTFUNCTIONALITYDESCRIPTION',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e150P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtSecFunctionalityKey_Visible',ctrl:'SECFUNCTIONALITYKEY',prop:'Visible'},{av:'edtSecFunctionalityDescription_Visible',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'cmbSecFunctionalityType'},{av:'edtSecParentFunctionalityDescription_Visible',ctrl:'SECPARENTFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'AV83GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV84GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV38ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e110P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtSecFunctionalityKey_Visible',ctrl:'SECFUNCTIONALITYKEY',prop:'Visible'},{av:'edtSecFunctionalityDescription_Visible',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'cmbSecFunctionalityType'},{av:'edtSecParentFunctionalityDescription_Visible',ctrl:'SECPARENTFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'AV83GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV84GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV38ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e160P2',iparms:[{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e170P2',iparms:[{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV27GridState',fld:'vGRIDSTATE',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e180P2',iparms:[{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV27GridState',fld:'vGRIDSTATE',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV87FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV34ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV42TFSecFunctionalityKey_Sel',fld:'vTFSECFUNCTIONALITYKEY_SEL',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV46TFSecFunctionalityDescription_Sel',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV53TFSecParentFunctionalityDescription_Sel',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SEL',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'}]}");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID","{handler:'valid_Secparentfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Secfunctionalityactive',iparms:[]");
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
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV87FilterFullText = "" ;
      AV72ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV41TFSecFunctionalityKey = "" ;
      AV42TFSecFunctionalityKey_Sel = "" ;
      AV45TFSecFunctionalityDescription = "" ;
      AV46TFSecFunctionalityDescription_Sel = "" ;
      AV81TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV52TFSecParentFunctionalityDescription = "" ;
      AV53TFSecParentFunctionalityDescription_Sel = "" ;
      AV99Pgmname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV38ManageFiltersData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV55DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV27GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV80TFSecFunctionalityType_SelsJson = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_tableheader = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttBtnexport_Jsonclick = "" ;
      bttBtnexportreport_Jsonclick = "" ;
      bttBtneditcolumns_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV11Update = "" ;
      AV12Delete = "" ;
      AV24UAViewChildren = "" ;
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV98Uaviewchildren_GXI = "" ;
      AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      scmdbuf = "" ;
      lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      lV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      lV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      lV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = "" ;
      AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = "" ;
      AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = "" ;
      AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      H000P2_A7SecFunctionalityActive = new boolean[] {false} ;
      H000P2_A11SecParentFunctionalityDescription = new String[] {""} ;
      H000P2_A2SecParentFunctionalityId = new long[1] ;
      H000P2_n2SecParentFunctionalityId = new boolean[] {false} ;
      H000P2_A9SecFunctionalityType = new byte[1] ;
      H000P2_A8SecFunctionalityDescription = new String[] {""} ;
      H000P2_A3SecFunctionalityKey = new String[] {""} ;
      H000P2_A1SecFunctionalityId = new long[1] ;
      H000P3_AGRID_nRecordCount = new long[1] ;
      AV7HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV79WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV13Session = httpContext.getWebSession();
      AV60ColumnsSelectorXML = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV35ManageFiltersXml = "" ;
      AV32ExcelFilename = "" ;
      AV33ErrorMessage = "" ;
      AV67UserCustomValue = "" ;
      AV85ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = new GXBaseCollection[1] ;
      AV28GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char8 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState16 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      sImgUrl = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalityww__default(),
         new Object[] {
             new Object[] {
            H000P2_A7SecFunctionalityActive, H000P2_A11SecParentFunctionalityDescription, H000P2_A2SecParentFunctionalityId, H000P2_n2SecParentFunctionalityId, H000P2_A9SecFunctionalityType, H000P2_A8SecFunctionalityDescription, H000P2_A3SecFunctionalityKey, H000P2_A1SecFunctionalityId
            }
            , new Object[] {
            H000P3_AGRID_nRecordCount
            }
         }
      );
      AV99Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      /* GeneXus formulas. */
      AV99Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV34ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte A9SecFunctionalityType ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV29OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtSecFunctionalityKey_Visible ;
   private int edtSecFunctionalityDescription_Visible ;
   private int edtSecParentFunctionalityDescription_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ;
   private int AV82PageToGo ;
   private int AV100GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV83GridCurrentPage ;
   private long AV84GridPageCount ;
   private long A1SecFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_43_idx="0001" ;
   private String AV99Pgmname ;
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
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Innewwindow1_Width ;
   private String Innewwindow1_Height ;
   private String Innewwindow1_Target ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_gridcolumnsselector_Titlecontrolidtoreplace ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String Dvpanel_tableheader_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String bttBtnexport_Internalname ;
   private String bttBtnexport_Jsonclick ;
   private String bttBtnexportreport_Internalname ;
   private String bttBtnexportreport_Jsonclick ;
   private String bttBtneditcolumns_Internalname ;
   private String bttBtneditcolumns_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String edtavUaviewchildren_Class ;
   private String subGrid_Header ;
   private String AV11Update ;
   private String edtavUpdate_Link ;
   private String AV12Delete ;
   private String edtavDelete_Link ;
   private String edtavUaviewchildren_Link ;
   private String edtavUaviewchildren_Tooltiptext ;
   private String edtSecFunctionalityDescription_Link ;
   private String edtSecParentFunctionalityDescription_Link ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtavUaviewchildren_Internalname ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityDescription_Internalname ;
   private String edtSecParentFunctionalityId_Internalname ;
   private String edtSecParentFunctionalityDescription_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char13 ;
   private String GXv_char8[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String sImgUrl ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String GXCCtl ;
   private String edtSecParentFunctionalityId_Jsonclick ;
   private String edtSecParentFunctionalityDescription_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV30OrderedDsc ;
   private boolean AV18IsAuthorized_Update ;
   private boolean AV19IsAuthorized_Delete ;
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
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean A7SecFunctionalityActive ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean n2SecParentFunctionalityId ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV15TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean AV24UAViewChildren_IsBlob ;
   private String AV80TFSecFunctionalityType_SelsJson ;
   private String AV60ColumnsSelectorXML ;
   private String AV35ManageFiltersXml ;
   private String AV67UserCustomValue ;
   private String AV87FilterFullText ;
   private String AV41TFSecFunctionalityKey ;
   private String AV42TFSecFunctionalityKey_Sel ;
   private String AV45TFSecFunctionalityDescription ;
   private String AV46TFSecFunctionalityDescription_Sel ;
   private String AV52TFSecParentFunctionalityDescription ;
   private String AV53TFSecParentFunctionalityDescription_Sel ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV98Uaviewchildren_GXI ;
   private String lV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String lV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String lV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String lV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ;
   private String AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ;
   private String AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ;
   private String AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String AV32ExcelFilename ;
   private String AV33ErrorMessage ;
   private String AV24UAViewChildren ;
   private GXSimpleCollection<Byte> AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ;
   private GXSimpleCollection<Byte> AV81TFSecFunctionalityType_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV7HTTPRequest ;
   private com.genexus.webpanels.WebSession AV13Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private HTMLChoice cmbSecFunctionalityType ;
   private ICheckbox chkSecFunctionalityActive ;
   private IDataStoreProvider pr_default ;
   private boolean[] H000P2_A7SecFunctionalityActive ;
   private String[] H000P2_A11SecParentFunctionalityDescription ;
   private long[] H000P2_A2SecParentFunctionalityId ;
   private boolean[] H000P2_n2SecParentFunctionalityId ;
   private byte[] H000P2_A9SecFunctionalityType ;
   private String[] H000P2_A8SecFunctionalityDescription ;
   private String[] H000P2_A3SecFunctionalityKey ;
   private long[] H000P2_A1SecFunctionalityId ;
   private long[] H000P3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV38ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV79WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState16[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV55DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV72ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV85ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
}

final  class secfunctionalityww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H000P2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV29OrderedBy ,
                                          boolean AV30OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[17];
      Object[] GXv_Object18 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[SecFunctionalityActive], T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecFunctionalityType]," ;
      sSelectString += " T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey], T1.[SecFunctionalityId]" ;
      sFromString = " FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecParentFunctionalityId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int17[0] = (byte)(1) ;
         GXv_int17[1] = (byte)(1) ;
         GXv_int17[2] = (byte)(1) ;
         GXv_int17[3] = (byte)(1) ;
         GXv_int17[4] = (byte)(1) ;
         GXv_int17[5] = (byte)(1) ;
         GXv_int17[6] = (byte)(1) ;
         GXv_int17[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int17[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int17[13] = (byte)(1) ;
      }
      if ( ( AV29OrderedBy == 1 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV29OrderedBy == 1 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityKey]" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityType]" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[SecFunctionalityDescription] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_H000P3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV29OrderedBy ,
                                          boolean AV30OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[14];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecParentFunctionalityId])" ;
      if ( ! (GXutil.strcmp("", AV90Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int20[0] = (byte)(1) ;
         GXv_int20[1] = (byte)(1) ;
         GXv_int20[2] = (byte)(1) ;
         GXv_int20[3] = (byte)(1) ;
         GXv_int20[4] = (byte)(1) ;
         GXv_int20[5] = (byte)(1) ;
         GXv_int20[6] = (byte)(1) ;
         GXv_int20[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV91Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV93Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV96Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int20[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int20[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV29OrderedBy == 1 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 1 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
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
                  return conditional_H000P2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
            case 1 :
                  return conditional_H000P3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H000P2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H000P3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
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
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
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

