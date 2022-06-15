package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ubigeoww_impl extends GXDataArea
{
   public ubigeoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ubigeoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ubigeoww_impl.class ));
   }

   public ubigeoww_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbUbigeoEstado = new HTMLChoice();
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
            AV16FilterFullText = httpContext.GetPar( "FilterFullText") ;
            AV26ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
            AV27TFUbigeoCode = httpContext.GetPar( "TFUbigeoCode") ;
            AV28TFUbigeoCode_Sel = httpContext.GetPar( "TFUbigeoCode_Sel") ;
            AV29TFUbigeoDepartamento = httpContext.GetPar( "TFUbigeoDepartamento") ;
            AV30TFUbigeoDepartamento_Sel = httpContext.GetPar( "TFUbigeoDepartamento_Sel") ;
            AV31TFUbigeoDepartamentoCode = httpContext.GetPar( "TFUbigeoDepartamentoCode") ;
            AV32TFUbigeoDepartamentoCode_Sel = httpContext.GetPar( "TFUbigeoDepartamentoCode_Sel") ;
            AV33TFUbigeoProvincia = httpContext.GetPar( "TFUbigeoProvincia") ;
            AV34TFUbigeoProvincia_Sel = httpContext.GetPar( "TFUbigeoProvincia_Sel") ;
            AV35TFUbigeoProvinciaCode = httpContext.GetPar( "TFUbigeoProvinciaCode") ;
            AV36TFUbigeoProvinciaCode_Sel = httpContext.GetPar( "TFUbigeoProvinciaCode_Sel") ;
            AV37TFUbigeoDistrito = httpContext.GetPar( "TFUbigeoDistrito") ;
            AV38TFUbigeoDistrito_Sel = httpContext.GetPar( "TFUbigeoDistrito_Sel") ;
            AV39TFUbigeoDistritoCode = httpContext.GetPar( "TFUbigeoDistritoCode") ;
            AV40TFUbigeoDistritoCode_Sel = httpContext.GetPar( "TFUbigeoDistritoCode_Sel") ;
            AV41TFUbigeoNombre = httpContext.GetPar( "TFUbigeoNombre") ;
            AV42TFUbigeoNombre_Sel = httpContext.GetPar( "TFUbigeoNombre_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV44TFUbigeoEstado_Sels);
            AV75Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV50IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV52IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFUbigeoCode, AV28TFUbigeoCode_Sel, AV29TFUbigeoDepartamento, AV30TFUbigeoDepartamento_Sel, AV31TFUbigeoDepartamentoCode, AV32TFUbigeoDepartamentoCode_Sel, AV33TFUbigeoProvincia, AV34TFUbigeoProvincia_Sel, AV35TFUbigeoProvinciaCode, AV36TFUbigeoProvinciaCode_Sel, AV37TFUbigeoDistrito, AV38TFUbigeoDistrito_Sel, AV39TFUbigeoDistritoCode, AV40TFUbigeoDistritoCode_Sel, AV41TFUbigeoNombre, AV42TFUbigeoNombre_Sel, AV44TFUbigeoEstado_Sels, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV50IsAuthorized_Update, AV52IsAuthorized_Delete) ;
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
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
      pa2H2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2H2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033368", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.ubigeoww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV16FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_43", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_43, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV24ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV24ManageFiltersData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV47GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV48GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV45DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV45DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE", GXutil.rtrim( AV27TFUbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE_SEL", GXutil.rtrim( AV28TFUbigeoCode_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODEPARTAMENTO", AV29TFUbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODEPARTAMENTO_SEL", AV30TFUbigeoDepartamento_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODEPARTAMENTOCODE", AV31TFUbigeoDepartamentoCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODEPARTAMENTOCODE_SEL", AV32TFUbigeoDepartamentoCode_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOPROVINCIA", AV33TFUbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOPROVINCIA_SEL", AV34TFUbigeoProvincia_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOPROVINCIACODE", AV35TFUbigeoProvinciaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOPROVINCIACODE_SEL", AV36TFUbigeoProvinciaCode_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODISTRITO", AV37TFUbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODISTRITO_SEL", AV38TFUbigeoDistrito_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODISTRITOCODE", AV39TFUbigeoDistritoCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEODISTRITOCODE_SEL", AV40TFUbigeoDistritoCode_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE", AV41TFUbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE_SEL", AV42TFUbigeoNombre_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFUBIGEOESTADO_SELS", AV44TFUbigeoEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFUBIGEOESTADO_SELS", AV44TFUbigeoEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV75Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV50IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV52IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOESTADO_SELSJSON", AV43TFUbigeoEstado_SelsJson);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
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
         we2H2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2H2( ) ;
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
      return formatLink("com.projectthani.ubigeoww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "UbigeoWW" ;
   }

   public String getPgmdesc( )
   {
      return " Ubigeo" ;
   }

   public void wb2H0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_UbigeoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_UbigeoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_UbigeoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_UbigeoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_2H2( true) ;
      }
      else
      {
         wb_table1_25_2H2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_2H2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoDepartamento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Departamento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoDepartamentoCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Departamento Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoProvincia_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Provincia") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoProvinciaCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Provincia Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoDistrito_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Distrito") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoDistritoCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Distrito Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbUbigeoEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV49Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A44UbigeoCode));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A186UbigeoDepartamento);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoDepartamento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A295UbigeoDepartamentoCode);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoDepartamentoCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A187UbigeoProvincia);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoProvincia_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A296UbigeoProvinciaCode);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoProvinciaCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A188UbigeoDistrito);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoDistrito_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A297UbigeoDistritoCode);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoDistritoCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A185UbigeoNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtUbigeoNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A294UbigeoEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbUbigeoEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV47GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV48GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV45DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV45DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
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

   public void start2H2( )
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
         Form.getMeta().addItem("description", " Ubigeo", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2H0( ) ;
   }

   public void ws2H2( )
   {
      start2H2( ) ;
      evt2H2( ) ;
   }

   public void evt2H2( )
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
                           e112H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e162H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e172H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e182H2 ();
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
                           AV49Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV49Update);
                           AV51Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV51Delete);
                           A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
                           A186UbigeoDepartamento = httpContext.cgiGet( edtUbigeoDepartamento_Internalname) ;
                           A295UbigeoDepartamentoCode = httpContext.cgiGet( edtUbigeoDepartamentoCode_Internalname) ;
                           A187UbigeoProvincia = httpContext.cgiGet( edtUbigeoProvincia_Internalname) ;
                           A296UbigeoProvinciaCode = httpContext.cgiGet( edtUbigeoProvinciaCode_Internalname) ;
                           A188UbigeoDistrito = httpContext.cgiGet( edtUbigeoDistrito_Internalname) ;
                           A297UbigeoDistritoCode = httpContext.cgiGet( edtUbigeoDistritoCode_Internalname) ;
                           A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
                           cmbUbigeoEstado.setName( cmbUbigeoEstado.getInternalname() );
                           cmbUbigeoEstado.setValue( httpContext.cgiGet( cmbUbigeoEstado.getInternalname()) );
                           A294UbigeoEstado = httpContext.cgiGet( cmbUbigeoEstado.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e192H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e202H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e212H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV16FilterFullText) != 0 )
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

   public void we2H2( )
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

   public void pa2H2( )
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
                                 String AV16FilterFullText ,
                                 byte AV26ManageFiltersExecutionStep ,
                                 com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV27TFUbigeoCode ,
                                 String AV28TFUbigeoCode_Sel ,
                                 String AV29TFUbigeoDepartamento ,
                                 String AV30TFUbigeoDepartamento_Sel ,
                                 String AV31TFUbigeoDepartamentoCode ,
                                 String AV32TFUbigeoDepartamentoCode_Sel ,
                                 String AV33TFUbigeoProvincia ,
                                 String AV34TFUbigeoProvincia_Sel ,
                                 String AV35TFUbigeoProvinciaCode ,
                                 String AV36TFUbigeoProvinciaCode_Sel ,
                                 String AV37TFUbigeoDistrito ,
                                 String AV38TFUbigeoDistrito_Sel ,
                                 String AV39TFUbigeoDistritoCode ,
                                 String AV40TFUbigeoDistritoCode_Sel ,
                                 String AV41TFUbigeoNombre ,
                                 String AV42TFUbigeoNombre_Sel ,
                                 GXSimpleCollection<String> AV44TFUbigeoEstado_Sels ,
                                 String AV75Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV50IsAuthorized_Update ,
                                 boolean AV52IsAuthorized_Delete )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e202H2 ();
      GRID_nCurrentRecord = 0 ;
      rf2H2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_UBIGEOCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A44UbigeoCode, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOCODE", GXutil.rtrim( A44UbigeoCode));
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
      rf2H2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV75Pgmname = "UbigeoWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf2H2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e202H2 ();
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
                                              A294UbigeoEstado ,
                                              AV74Ubigeowwds_18_tfubigeoestado_sels ,
                                              AV57Ubigeowwds_1_filterfulltext ,
                                              AV59Ubigeowwds_3_tfubigeocode_sel ,
                                              AV58Ubigeowwds_2_tfubigeocode ,
                                              AV61Ubigeowwds_5_tfubigeodepartamento_sel ,
                                              AV60Ubigeowwds_4_tfubigeodepartamento ,
                                              AV63Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                              AV62Ubigeowwds_6_tfubigeodepartamentocode ,
                                              AV65Ubigeowwds_9_tfubigeoprovincia_sel ,
                                              AV64Ubigeowwds_8_tfubigeoprovincia ,
                                              AV67Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                              AV66Ubigeowwds_10_tfubigeoprovinciacode ,
                                              AV69Ubigeowwds_13_tfubigeodistrito_sel ,
                                              AV68Ubigeowwds_12_tfubigeodistrito ,
                                              AV71Ubigeowwds_15_tfubigeodistritocode_sel ,
                                              AV70Ubigeowwds_14_tfubigeodistritocode ,
                                              AV73Ubigeowwds_17_tfubigeonombre_sel ,
                                              AV72Ubigeowwds_16_tfubigeonombre ,
                                              Integer.valueOf(AV74Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                              A44UbigeoCode ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
         lV58Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV58Ubigeowwds_2_tfubigeocode), 10, "%") ;
         lV60Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
         lV62Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV62Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
         lV64Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV64Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
         lV66Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV66Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
         lV68Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV68Ubigeowwds_12_tfubigeodistrito), "%", "") ;
         lV70Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV70Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
         lV72Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV72Ubigeowwds_16_tfubigeonombre), "%", "") ;
         /* Using cursor H002H2 */
         pr_default.execute(0, new Object[] {lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV58Ubigeowwds_2_tfubigeocode, AV59Ubigeowwds_3_tfubigeocode_sel, lV60Ubigeowwds_4_tfubigeodepartamento, AV61Ubigeowwds_5_tfubigeodepartamento_sel, lV62Ubigeowwds_6_tfubigeodepartamentocode, AV63Ubigeowwds_7_tfubigeodepartamentocode_sel, lV64Ubigeowwds_8_tfubigeoprovincia, AV65Ubigeowwds_9_tfubigeoprovincia_sel, lV66Ubigeowwds_10_tfubigeoprovinciacode, AV67Ubigeowwds_11_tfubigeoprovinciacode_sel, lV68Ubigeowwds_12_tfubigeodistrito, AV69Ubigeowwds_13_tfubigeodistrito_sel, lV70Ubigeowwds_14_tfubigeodistritocode, AV71Ubigeowwds_15_tfubigeodistritocode_sel, lV72Ubigeowwds_16_tfubigeonombre, AV73Ubigeowwds_17_tfubigeonombre_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A294UbigeoEstado = H002H2_A294UbigeoEstado[0] ;
            A44UbigeoCode = H002H2_A44UbigeoCode[0] ;
            A188UbigeoDistrito = H002H2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H002H2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H002H2_A186UbigeoDepartamento[0] ;
            A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
            A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
            A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
            A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
            e212H2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb2H0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2H2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV75Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV50IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV52IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_UBIGEOCODE"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, GXutil.rtrim( localUtil.format( A44UbigeoCode, ""))));
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
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV74Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV57Ubigeowwds_1_filterfulltext ,
                                           AV59Ubigeowwds_3_tfubigeocode_sel ,
                                           AV58Ubigeowwds_2_tfubigeocode ,
                                           AV61Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV60Ubigeowwds_4_tfubigeodepartamento ,
                                           AV63Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV62Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV65Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV64Ubigeowwds_8_tfubigeoprovincia ,
                                           AV67Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV66Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV69Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV68Ubigeowwds_12_tfubigeodistrito ,
                                           AV71Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV70Ubigeowwds_14_tfubigeodistritocode ,
                                           AV73Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV72Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV74Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV57Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_1_filterfulltext), "%", "") ;
      lV58Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV58Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV60Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV60Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV62Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV62Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV64Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV64Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV66Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV66Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV68Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV68Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV70Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV70Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV72Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV72Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor H002H3 */
      pr_default.execute(1, new Object[] {lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV57Ubigeowwds_1_filterfulltext, lV58Ubigeowwds_2_tfubigeocode, AV59Ubigeowwds_3_tfubigeocode_sel, lV60Ubigeowwds_4_tfubigeodepartamento, AV61Ubigeowwds_5_tfubigeodepartamento_sel, lV62Ubigeowwds_6_tfubigeodepartamentocode, AV63Ubigeowwds_7_tfubigeodepartamentocode_sel, lV64Ubigeowwds_8_tfubigeoprovincia, AV65Ubigeowwds_9_tfubigeoprovincia_sel, lV66Ubigeowwds_10_tfubigeoprovinciacode, AV67Ubigeowwds_11_tfubigeoprovinciacode_sel, lV68Ubigeowwds_12_tfubigeodistrito, AV69Ubigeowwds_13_tfubigeodistrito_sel, lV70Ubigeowwds_14_tfubigeodistritocode, AV71Ubigeowwds_15_tfubigeodistritocode_sel, lV72Ubigeowwds_16_tfubigeonombre, AV73Ubigeowwds_17_tfubigeonombre_sel});
      GRID_nRecordCount = H002H3_AGRID_nRecordCount[0] ;
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
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFUbigeoCode, AV28TFUbigeoCode_Sel, AV29TFUbigeoDepartamento, AV30TFUbigeoDepartamento_Sel, AV31TFUbigeoDepartamentoCode, AV32TFUbigeoDepartamentoCode_Sel, AV33TFUbigeoProvincia, AV34TFUbigeoProvincia_Sel, AV35TFUbigeoProvinciaCode, AV36TFUbigeoProvinciaCode_Sel, AV37TFUbigeoDistrito, AV38TFUbigeoDistrito_Sel, AV39TFUbigeoDistritoCode, AV40TFUbigeoDistritoCode_Sel, AV41TFUbigeoNombre, AV42TFUbigeoNombre_Sel, AV44TFUbigeoEstado_Sels, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV50IsAuthorized_Update, AV52IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFUbigeoCode, AV28TFUbigeoCode_Sel, AV29TFUbigeoDepartamento, AV30TFUbigeoDepartamento_Sel, AV31TFUbigeoDepartamentoCode, AV32TFUbigeoDepartamentoCode_Sel, AV33TFUbigeoProvincia, AV34TFUbigeoProvincia_Sel, AV35TFUbigeoProvinciaCode, AV36TFUbigeoProvinciaCode_Sel, AV37TFUbigeoDistrito, AV38TFUbigeoDistrito_Sel, AV39TFUbigeoDistritoCode, AV40TFUbigeoDistritoCode_Sel, AV41TFUbigeoNombre, AV42TFUbigeoNombre_Sel, AV44TFUbigeoEstado_Sels, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV50IsAuthorized_Update, AV52IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFUbigeoCode, AV28TFUbigeoCode_Sel, AV29TFUbigeoDepartamento, AV30TFUbigeoDepartamento_Sel, AV31TFUbigeoDepartamentoCode, AV32TFUbigeoDepartamentoCode_Sel, AV33TFUbigeoProvincia, AV34TFUbigeoProvincia_Sel, AV35TFUbigeoProvinciaCode, AV36TFUbigeoProvinciaCode_Sel, AV37TFUbigeoDistrito, AV38TFUbigeoDistrito_Sel, AV39TFUbigeoDistritoCode, AV40TFUbigeoDistritoCode_Sel, AV41TFUbigeoNombre, AV42TFUbigeoNombre_Sel, AV44TFUbigeoEstado_Sels, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV50IsAuthorized_Update, AV52IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFUbigeoCode, AV28TFUbigeoCode_Sel, AV29TFUbigeoDepartamento, AV30TFUbigeoDepartamento_Sel, AV31TFUbigeoDepartamentoCode, AV32TFUbigeoDepartamentoCode_Sel, AV33TFUbigeoProvincia, AV34TFUbigeoProvincia_Sel, AV35TFUbigeoProvinciaCode, AV36TFUbigeoProvinciaCode_Sel, AV37TFUbigeoDistrito, AV38TFUbigeoDistrito_Sel, AV39TFUbigeoDistritoCode, AV40TFUbigeoDistritoCode_Sel, AV41TFUbigeoNombre, AV42TFUbigeoNombre_Sel, AV44TFUbigeoEstado_Sels, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV50IsAuthorized_Update, AV52IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFUbigeoCode, AV28TFUbigeoCode_Sel, AV29TFUbigeoDepartamento, AV30TFUbigeoDepartamento_Sel, AV31TFUbigeoDepartamentoCode, AV32TFUbigeoDepartamentoCode_Sel, AV33TFUbigeoProvincia, AV34TFUbigeoProvincia_Sel, AV35TFUbigeoProvinciaCode, AV36TFUbigeoProvinciaCode_Sel, AV37TFUbigeoDistrito, AV38TFUbigeoDistrito_Sel, AV39TFUbigeoDistritoCode, AV40TFUbigeoDistritoCode_Sel, AV41TFUbigeoNombre, AV42TFUbigeoNombre_Sel, AV44TFUbigeoEstado_Sels, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV50IsAuthorized_Update, AV52IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV75Pgmname = "UbigeoWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2H0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e192H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV45DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV47GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV48GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV16FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV16FilterFullText) != 0 )
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
      e192H2 ();
      if (returnInSub) return;
   }

   public void e192H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV8HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Ubigeo" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV13OrderedBy < 1 )
      {
         AV13OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV45DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV45DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e202H2( )
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
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV26ManageFiltersExecutionStep == 1 )
      {
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV26ManageFiltersExecutionStep == 2 )
      {
         AV26ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("UbigeoWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("UbigeoWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtUbigeoCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoDepartamento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDepartamento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDepartamento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoDepartamentoCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDepartamentoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDepartamentoCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoProvincia_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoProvincia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoProvincia_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoProvinciaCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoProvinciaCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoProvinciaCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoDistrito_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDistrito_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDistrito_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoDistritoCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDistritoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDistritoCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbUbigeoEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbUbigeoEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbUbigeoEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV47GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47GridCurrentPage), 10, 0));
      AV48GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48GridPageCount), 10, 0));
      AV57Ubigeowwds_1_filterfulltext = AV16FilterFullText ;
      AV58Ubigeowwds_2_tfubigeocode = AV27TFUbigeoCode ;
      AV59Ubigeowwds_3_tfubigeocode_sel = AV28TFUbigeoCode_Sel ;
      AV60Ubigeowwds_4_tfubigeodepartamento = AV29TFUbigeoDepartamento ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = AV30TFUbigeoDepartamento_Sel ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = AV31TFUbigeoDepartamentoCode ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = AV32TFUbigeoDepartamentoCode_Sel ;
      AV64Ubigeowwds_8_tfubigeoprovincia = AV33TFUbigeoProvincia ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = AV34TFUbigeoProvincia_Sel ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = AV35TFUbigeoProvinciaCode ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = AV36TFUbigeoProvinciaCode_Sel ;
      AV68Ubigeowwds_12_tfubigeodistrito = AV37TFUbigeoDistrito ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = AV38TFUbigeoDistrito_Sel ;
      AV70Ubigeowwds_14_tfubigeodistritocode = AV39TFUbigeoDistritoCode ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = AV40TFUbigeoDistritoCode_Sel ;
      AV72Ubigeowwds_16_tfubigeonombre = AV41TFUbigeoNombre ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = AV42TFUbigeoNombre_Sel ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = AV44TFUbigeoEstado_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122H2( )
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
         AV46PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV46PageToGo) ;
      }
   }

   public void e132H2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142H2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV13OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoCode") == 0 )
         {
            AV27TFUbigeoCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFUbigeoCode", AV27TFUbigeoCode);
            AV28TFUbigeoCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFUbigeoCode_Sel", AV28TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoDepartamento") == 0 )
         {
            AV29TFUbigeoDepartamento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFUbigeoDepartamento", AV29TFUbigeoDepartamento);
            AV30TFUbigeoDepartamento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFUbigeoDepartamento_Sel", AV30TFUbigeoDepartamento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoDepartamentoCode") == 0 )
         {
            AV31TFUbigeoDepartamentoCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFUbigeoDepartamentoCode", AV31TFUbigeoDepartamentoCode);
            AV32TFUbigeoDepartamentoCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFUbigeoDepartamentoCode_Sel", AV32TFUbigeoDepartamentoCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoProvincia") == 0 )
         {
            AV33TFUbigeoProvincia = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFUbigeoProvincia", AV33TFUbigeoProvincia);
            AV34TFUbigeoProvincia_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFUbigeoProvincia_Sel", AV34TFUbigeoProvincia_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoProvinciaCode") == 0 )
         {
            AV35TFUbigeoProvinciaCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFUbigeoProvinciaCode", AV35TFUbigeoProvinciaCode);
            AV36TFUbigeoProvinciaCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFUbigeoProvinciaCode_Sel", AV36TFUbigeoProvinciaCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoDistrito") == 0 )
         {
            AV37TFUbigeoDistrito = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFUbigeoDistrito", AV37TFUbigeoDistrito);
            AV38TFUbigeoDistrito_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFUbigeoDistrito_Sel", AV38TFUbigeoDistrito_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoDistritoCode") == 0 )
         {
            AV39TFUbigeoDistritoCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFUbigeoDistritoCode", AV39TFUbigeoDistritoCode);
            AV40TFUbigeoDistritoCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFUbigeoDistritoCode_Sel", AV40TFUbigeoDistritoCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoNombre") == 0 )
         {
            AV41TFUbigeoNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFUbigeoNombre", AV41TFUbigeoNombre);
            AV42TFUbigeoNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFUbigeoNombre_Sel", AV42TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoEstado") == 0 )
         {
            AV43TFUbigeoEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFUbigeoEstado_SelsJson", AV43TFUbigeoEstado_SelsJson);
            AV44TFUbigeoEstado_Sels.fromJSonString(AV43TFUbigeoEstado_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFUbigeoEstado_Sels", AV44TFUbigeoEstado_Sels);
   }

   private void e212H2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV49Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV49Update);
      if ( AV50IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.ubigeo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.rtrim(A44UbigeoCode))}, new String[] {"Mode","UbigeoCode"})  ;
      }
      AV51Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV51Delete);
      if ( AV52IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.ubigeo", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.rtrim(A44UbigeoCode))}, new String[] {"Mode","UbigeoCode"})  ;
      }
      edtUbigeoNombre_Link = formatLink("com.projectthani.ubigeoview", new String[] {GXutil.URLEncode(GXutil.rtrim(A44UbigeoCode)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"UbigeoCode","TabCode"})  ;
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

   public void e152H2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "UbigeoWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e112H2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("UbigeoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV75Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("UbigeoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV25ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "UbigeoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         ubigeoww_impl.this.GXt_char4 = GXv_char5[0] ;
         AV25ManageFiltersXml = GXt_char4 ;
         if ( (GXutil.strcmp("", AV25ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem("El filtro seleccionado no existe más.");
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV75Pgmname+"GridState", AV25ManageFiltersXml) ;
            AV11GridState.fromxml(AV25ManageFiltersXml, null, null);
            AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
            AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFUbigeoEstado_Sels", AV44TFUbigeoEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e162H2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.ubigeo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","UbigeoCode"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e172H2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char5[0] = AV17ExcelFilename ;
      GXv_char6[0] = AV18ErrorMessage ;
      new com.projectthani.ubigeowwexport(remoteHandle, context).execute( GXv_char5, GXv_char6) ;
      ubigeoww_impl.this.AV17ExcelFilename = GXv_char5[0] ;
      ubigeoww_impl.this.AV18ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV17ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV17ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV18ErrorMessage);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFUbigeoEstado_Sels", AV44TFUbigeoEstado_Sels);
   }

   public void e182H2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.ubigeowwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFUbigeoEstado_Sels", AV44TFUbigeoEstado_Sels);
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV13OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV21ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoCode", "", "Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoDepartamento", "", "Departamento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoDepartamentoCode", "", "Departamento Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoProvincia", "", "Provincia", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoProvinciaCode", "", "Provincia Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoDistrito", "", "Distrito", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoDistritoCode", "", "Distrito Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXt_char4 = AV20UserCustomValue ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "UbigeoWWColumnsSelector", GXv_char6) ;
      ubigeoww_impl.this.GXt_char4 = GXv_char6[0] ;
      AV20UserCustomValue = GXt_char4 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector7[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector8[0] = AV21ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, GXv_SdtWWPColumnsSelector8) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector7[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean9 = AV50IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo_Update", GXv_boolean10) ;
      ubigeoww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV50IsAuthorized_Update = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50IsAuthorized_Update", AV50IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      if ( ! ( AV50IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV52IsAuthorized_Delete ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo_Delete", GXv_boolean10) ;
      ubigeoww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV52IsAuthorized_Delete = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52IsAuthorized_Delete", AV52IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      if ( ! ( AV52IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV53TempBoolean ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo_Insert", GXv_boolean10) ;
      ubigeoww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV53TempBoolean = GXt_boolean9 ;
      if ( ! ( AV53TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = AV24ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "UbigeoWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFUbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFUbigeoCode", AV27TFUbigeoCode);
      AV28TFUbigeoCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFUbigeoCode_Sel", AV28TFUbigeoCode_Sel);
      AV29TFUbigeoDepartamento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFUbigeoDepartamento", AV29TFUbigeoDepartamento);
      AV30TFUbigeoDepartamento_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFUbigeoDepartamento_Sel", AV30TFUbigeoDepartamento_Sel);
      AV31TFUbigeoDepartamentoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFUbigeoDepartamentoCode", AV31TFUbigeoDepartamentoCode);
      AV32TFUbigeoDepartamentoCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFUbigeoDepartamentoCode_Sel", AV32TFUbigeoDepartamentoCode_Sel);
      AV33TFUbigeoProvincia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFUbigeoProvincia", AV33TFUbigeoProvincia);
      AV34TFUbigeoProvincia_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFUbigeoProvincia_Sel", AV34TFUbigeoProvincia_Sel);
      AV35TFUbigeoProvinciaCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFUbigeoProvinciaCode", AV35TFUbigeoProvinciaCode);
      AV36TFUbigeoProvinciaCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFUbigeoProvinciaCode_Sel", AV36TFUbigeoProvinciaCode_Sel);
      AV37TFUbigeoDistrito = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFUbigeoDistrito", AV37TFUbigeoDistrito);
      AV38TFUbigeoDistrito_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFUbigeoDistrito_Sel", AV38TFUbigeoDistrito_Sel);
      AV39TFUbigeoDistritoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFUbigeoDistritoCode", AV39TFUbigeoDistritoCode);
      AV40TFUbigeoDistritoCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFUbigeoDistritoCode_Sel", AV40TFUbigeoDistritoCode_Sel);
      AV41TFUbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFUbigeoNombre", AV41TFUbigeoNombre);
      AV42TFUbigeoNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFUbigeoNombre_Sel", AV42TFUbigeoNombre_Sel);
      AV44TFUbigeoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue(AV75Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV75Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV75Pgmname+"GridState"), null, null);
      }
      AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
      AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV76GXV1 = 1 ;
      while ( AV76GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV76GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV27TFUbigeoCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFUbigeoCode", AV27TFUbigeoCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV28TFUbigeoCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFUbigeoCode_Sel", AV28TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO") == 0 )
         {
            AV29TFUbigeoDepartamento = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFUbigeoDepartamento", AV29TFUbigeoDepartamento);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO_SEL") == 0 )
         {
            AV30TFUbigeoDepartamento_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFUbigeoDepartamento_Sel", AV30TFUbigeoDepartamento_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE") == 0 )
         {
            AV31TFUbigeoDepartamentoCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFUbigeoDepartamentoCode", AV31TFUbigeoDepartamentoCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE_SEL") == 0 )
         {
            AV32TFUbigeoDepartamentoCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFUbigeoDepartamentoCode_Sel", AV32TFUbigeoDepartamentoCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA") == 0 )
         {
            AV33TFUbigeoProvincia = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFUbigeoProvincia", AV33TFUbigeoProvincia);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA_SEL") == 0 )
         {
            AV34TFUbigeoProvincia_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFUbigeoProvincia_Sel", AV34TFUbigeoProvincia_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE") == 0 )
         {
            AV35TFUbigeoProvinciaCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFUbigeoProvinciaCode", AV35TFUbigeoProvinciaCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE_SEL") == 0 )
         {
            AV36TFUbigeoProvinciaCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFUbigeoProvinciaCode_Sel", AV36TFUbigeoProvinciaCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO") == 0 )
         {
            AV37TFUbigeoDistrito = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFUbigeoDistrito", AV37TFUbigeoDistrito);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO_SEL") == 0 )
         {
            AV38TFUbigeoDistrito_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFUbigeoDistrito_Sel", AV38TFUbigeoDistrito_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE") == 0 )
         {
            AV39TFUbigeoDistritoCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFUbigeoDistritoCode", AV39TFUbigeoDistritoCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE_SEL") == 0 )
         {
            AV40TFUbigeoDistritoCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFUbigeoDistritoCode_Sel", AV40TFUbigeoDistritoCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV41TFUbigeoNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFUbigeoNombre", AV41TFUbigeoNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV42TFUbigeoNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFUbigeoNombre_Sel", AV42TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOESTADO_SEL") == 0 )
         {
            AV43TFUbigeoEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFUbigeoEstado_SelsJson", AV43TFUbigeoEstado_SelsJson);
            AV44TFUbigeoEstado_Sels.fromJSonString(AV43TFUbigeoEstado_SelsJson, null);
         }
         AV76GXV1 = (int)(AV76GXV1+1) ;
      }
      GXt_char4 = "" ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFUbigeoCode_Sel)==0), AV28TFUbigeoCode_Sel, GXv_char6) ;
      ubigeoww_impl.this.GXt_char4 = GXv_char6[0] ;
      GXt_char13 = "" ;
      GXv_char5[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFUbigeoDepartamento_Sel)==0), AV30TFUbigeoDepartamento_Sel, GXv_char5) ;
      ubigeoww_impl.this.GXt_char13 = GXv_char5[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFUbigeoDepartamentoCode_Sel)==0), AV32TFUbigeoDepartamentoCode_Sel, GXv_char15) ;
      ubigeoww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFUbigeoProvincia_Sel)==0), AV34TFUbigeoProvincia_Sel, GXv_char17) ;
      ubigeoww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFUbigeoProvinciaCode_Sel)==0), AV36TFUbigeoProvinciaCode_Sel, GXv_char19) ;
      ubigeoww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFUbigeoDistrito_Sel)==0), AV38TFUbigeoDistrito_Sel, GXv_char21) ;
      ubigeoww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFUbigeoDistritoCode_Sel)==0), AV40TFUbigeoDistritoCode_Sel, GXv_char23) ;
      ubigeoww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFUbigeoNombre_Sel)==0), AV42TFUbigeoNombre_Sel, GXv_char25) ;
      ubigeoww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV44TFUbigeoEstado_Sels.size()==0), AV43TFUbigeoEstado_SelsJson, GXv_char27) ;
      ubigeoww_impl.this.GXt_char26 = GXv_char27[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char4+"|"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"|"+GXt_char24+"|"+GXt_char26 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV27TFUbigeoCode)==0), AV27TFUbigeoCode, GXv_char27) ;
      ubigeoww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFUbigeoDepartamento)==0), AV29TFUbigeoDepartamento, GXv_char25) ;
      ubigeoww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFUbigeoDepartamentoCode)==0), AV31TFUbigeoDepartamentoCode, GXv_char23) ;
      ubigeoww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFUbigeoProvincia)==0), AV33TFUbigeoProvincia, GXv_char21) ;
      ubigeoww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFUbigeoProvinciaCode)==0), AV35TFUbigeoProvinciaCode, GXv_char19) ;
      ubigeoww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFUbigeoDistrito)==0), AV37TFUbigeoDistrito, GXv_char17) ;
      ubigeoww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFUbigeoDistritoCode)==0), AV39TFUbigeoDistritoCode, GXv_char15) ;
      ubigeoww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char6[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV41TFUbigeoNombre)==0), AV41TFUbigeoNombre, GXv_char6) ;
      ubigeoww_impl.this.GXt_char13 = GXv_char6[0] ;
      Ddo_grid_Filteredtext_set = GXt_char26+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+GXt_char18+"|"+GXt_char16+"|"+GXt_char14+"|"+GXt_char13+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV75Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEOCODE", !(GXutil.strcmp("", AV27TFUbigeoCode)==0), (short)(0), AV27TFUbigeoCode, "", !(GXutil.strcmp("", AV28TFUbigeoCode_Sel)==0), AV28TFUbigeoCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEODEPARTAMENTO", !(GXutil.strcmp("", AV29TFUbigeoDepartamento)==0), (short)(0), AV29TFUbigeoDepartamento, "", !(GXutil.strcmp("", AV30TFUbigeoDepartamento_Sel)==0), AV30TFUbigeoDepartamento_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEODEPARTAMENTOCODE", !(GXutil.strcmp("", AV31TFUbigeoDepartamentoCode)==0), (short)(0), AV31TFUbigeoDepartamentoCode, "", !(GXutil.strcmp("", AV32TFUbigeoDepartamentoCode_Sel)==0), AV32TFUbigeoDepartamentoCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEOPROVINCIA", !(GXutil.strcmp("", AV33TFUbigeoProvincia)==0), (short)(0), AV33TFUbigeoProvincia, "", !(GXutil.strcmp("", AV34TFUbigeoProvincia_Sel)==0), AV34TFUbigeoProvincia_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEOPROVINCIACODE", !(GXutil.strcmp("", AV35TFUbigeoProvinciaCode)==0), (short)(0), AV35TFUbigeoProvinciaCode, "", !(GXutil.strcmp("", AV36TFUbigeoProvinciaCode_Sel)==0), AV36TFUbigeoProvinciaCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEODISTRITO", !(GXutil.strcmp("", AV37TFUbigeoDistrito)==0), (short)(0), AV37TFUbigeoDistrito, "", !(GXutil.strcmp("", AV38TFUbigeoDistrito_Sel)==0), AV38TFUbigeoDistrito_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEODISTRITOCODE", !(GXutil.strcmp("", AV39TFUbigeoDistritoCode)==0), (short)(0), AV39TFUbigeoDistritoCode, "", !(GXutil.strcmp("", AV40TFUbigeoDistritoCode_Sel)==0), AV40TFUbigeoDistritoCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEONOMBRE", !(GXutil.strcmp("", AV41TFUbigeoNombre)==0), (short)(0), AV41TFUbigeoNombre, "", !(GXutil.strcmp("", AV42TFUbigeoNombre_Sel)==0), AV42TFUbigeoNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEOESTADO_SEL", !(AV44TFUbigeoEstado_Sels.size()==0), (short)(0), AV44TFUbigeoEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV75Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV75Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Ubigeo" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_2H2( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV24ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_30_2H2( true) ;
      }
      else
      {
         wb_table2_30_2H2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_2H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_2H2e( true) ;
      }
      else
      {
         wb_table1_25_2H2e( false) ;
      }
   }

   public void wb_table2_30_2H2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_UbigeoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_2H2e( true) ;
      }
      else
      {
         wb_table2_30_2H2e( false) ;
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
      pa2H2( ) ;
      ws2H2( ) ;
      we2H2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110333939", true, true);
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
      httpContext.AddJavascriptSource("ubigeoww.js", "?20225110333939", false, true);
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
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_idx ;
      edtUbigeoDepartamento_Internalname = "UBIGEODEPARTAMENTO_"+sGXsfl_43_idx ;
      edtUbigeoDepartamentoCode_Internalname = "UBIGEODEPARTAMENTOCODE_"+sGXsfl_43_idx ;
      edtUbigeoProvincia_Internalname = "UBIGEOPROVINCIA_"+sGXsfl_43_idx ;
      edtUbigeoProvinciaCode_Internalname = "UBIGEOPROVINCIACODE_"+sGXsfl_43_idx ;
      edtUbigeoDistrito_Internalname = "UBIGEODISTRITO_"+sGXsfl_43_idx ;
      edtUbigeoDistritoCode_Internalname = "UBIGEODISTRITOCODE_"+sGXsfl_43_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_idx ;
      cmbUbigeoEstado.setInternalname( "UBIGEOESTADO_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoDepartamento_Internalname = "UBIGEODEPARTAMENTO_"+sGXsfl_43_fel_idx ;
      edtUbigeoDepartamentoCode_Internalname = "UBIGEODEPARTAMENTOCODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoProvincia_Internalname = "UBIGEOPROVINCIA_"+sGXsfl_43_fel_idx ;
      edtUbigeoProvinciaCode_Internalname = "UBIGEOPROVINCIACODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoDistrito_Internalname = "UBIGEODISTRITO_"+sGXsfl_43_fel_idx ;
      edtUbigeoDistritoCode_Internalname = "UBIGEODISTRITOCODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_fel_idx ;
      cmbUbigeoEstado.setInternalname( "UBIGEOESTADO_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb2H0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV49Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV51Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoCode_Internalname,GXutil.rtrim( A44UbigeoCode),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoDepartamento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoDepartamento_Internalname,A186UbigeoDepartamento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoDepartamento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoDepartamento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoDepartamentoCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoDepartamentoCode_Internalname,A295UbigeoDepartamentoCode,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoDepartamentoCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoDepartamentoCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoProvincia_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoProvincia_Internalname,A187UbigeoProvincia,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoProvincia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoProvincia_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoProvinciaCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoProvinciaCode_Internalname,A296UbigeoProvinciaCode,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoProvinciaCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoProvinciaCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoDistrito_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoDistrito_Internalname,A188UbigeoDistrito,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoDistrito_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoDistrito_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoDistritoCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoDistritoCode_Internalname,A297UbigeoDistritoCode,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoDistritoCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoDistritoCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoNombre_Internalname,A185UbigeoNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtUbigeoNombre_Link,"","","",edtUbigeoNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtUbigeoNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbUbigeoEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbUbigeoEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "UBIGEOESTADO_" + sGXsfl_43_idx ;
            cmbUbigeoEstado.setName( GXCCtl );
            cmbUbigeoEstado.setWebtags( "" );
            cmbUbigeoEstado.addItem("A", "Activo", (short)(0));
            cmbUbigeoEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbUbigeoEstado.getItemCount() > 0 )
            {
               A294UbigeoEstado = cmbUbigeoEstado.getValidValue(A294UbigeoEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbUbigeoEstado,cmbUbigeoEstado.getInternalname(),GXutil.rtrim( A294UbigeoEstado),Integer.valueOf(1),cmbUbigeoEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbUbigeoEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbUbigeoEstado.setValue( GXutil.rtrim( A294UbigeoEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbUbigeoEstado.getInternalname(), "Values", cmbUbigeoEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes2H2( ) ;
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
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      edtUbigeoDepartamento_Internalname = "UBIGEODEPARTAMENTO" ;
      edtUbigeoDepartamentoCode_Internalname = "UBIGEODEPARTAMENTOCODE" ;
      edtUbigeoProvincia_Internalname = "UBIGEOPROVINCIA" ;
      edtUbigeoProvinciaCode_Internalname = "UBIGEOPROVINCIACODE" ;
      edtUbigeoDistrito_Internalname = "UBIGEODISTRITO" ;
      edtUbigeoDistritoCode_Internalname = "UBIGEODISTRITOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      cmbUbigeoEstado.setInternalname( "UBIGEOESTADO" );
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
      cmbUbigeoEstado.setJsonclick( "" );
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoDistritoCode_Jsonclick = "" ;
      edtUbigeoDistrito_Jsonclick = "" ;
      edtUbigeoProvinciaCode_Jsonclick = "" ;
      edtUbigeoProvincia_Jsonclick = "" ;
      edtUbigeoDepartamentoCode_Jsonclick = "" ;
      edtUbigeoDepartamento_Jsonclick = "" ;
      edtUbigeoCode_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtUbigeoNombre_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbUbigeoEstado.setVisible( -1 );
      edtUbigeoNombre_Visible = -1 ;
      edtUbigeoDistritoCode_Visible = -1 ;
      edtUbigeoDistrito_Visible = -1 ;
      edtUbigeoProvinciaCode_Visible = -1 ;
      edtUbigeoProvincia_Visible = -1 ;
      edtUbigeoDepartamentoCode_Visible = -1 ;
      edtUbigeoDepartamento_Visible = -1 ;
      edtUbigeoCode_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Ubigeo" );
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
      Ddo_grid_Datalistproc = "UbigeoWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||||A:Activo,I:Inactivo" ;
      Ddo_grid_Allowmultipleselection = "||||||||T" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues" ;
      Ddo_grid_Includedatalist = "T" ;
      Ddo_grid_Filtertype = "Character|Character|Character|Character|Character|Character|Character|Character|" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T||T||T|||T" ;
      Ddo_grid_Columnssortvalues = "1|2||3||4|||5" ;
      Ddo_grid_Columnids = "2:UbigeoCode|3:UbigeoDepartamento|4:UbigeoDepartamentoCode|5:UbigeoProvincia|6:UbigeoProvinciaCode|7:UbigeoDistrito|8:UbigeoDistritoCode|9:UbigeoNombre|10:UbigeoEstado" ;
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
      GXCCtl = "UBIGEOESTADO_" + sGXsfl_43_idx ;
      cmbUbigeoEstado.setName( GXCCtl );
      cmbUbigeoEstado.setWebtags( "" );
      cmbUbigeoEstado.addItem("A", "Activo", (short)(0));
      cmbUbigeoEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbUbigeoEstado.getItemCount() > 0 )
      {
         A294UbigeoEstado = cmbUbigeoEstado.getValidValue(A294UbigeoEstado) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoDepartamento_Visible',ctrl:'UBIGEODEPARTAMENTO',prop:'Visible'},{av:'edtUbigeoDepartamentoCode_Visible',ctrl:'UBIGEODEPARTAMENTOCODE',prop:'Visible'},{av:'edtUbigeoProvincia_Visible',ctrl:'UBIGEOPROVINCIA',prop:'Visible'},{av:'edtUbigeoProvinciaCode_Visible',ctrl:'UBIGEOPROVINCIACODE',prop:'Visible'},{av:'edtUbigeoDistrito_Visible',ctrl:'UBIGEODISTRITO',prop:'Visible'},{av:'edtUbigeoDistritoCode_Visible',ctrl:'UBIGEODISTRITOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'cmbUbigeoEstado'},{av:'AV47GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV48GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e142H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e212H2',iparms:[{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV49Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV51Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtUbigeoNombre_Link',ctrl:'UBIGEONOMBRE',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e152H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoDepartamento_Visible',ctrl:'UBIGEODEPARTAMENTO',prop:'Visible'},{av:'edtUbigeoDepartamentoCode_Visible',ctrl:'UBIGEODEPARTAMENTOCODE',prop:'Visible'},{av:'edtUbigeoProvincia_Visible',ctrl:'UBIGEOPROVINCIA',prop:'Visible'},{av:'edtUbigeoProvinciaCode_Visible',ctrl:'UBIGEOPROVINCIACODE',prop:'Visible'},{av:'edtUbigeoDistrito_Visible',ctrl:'UBIGEODISTRITO',prop:'Visible'},{av:'edtUbigeoDistritoCode_Visible',ctrl:'UBIGEODISTRITOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'cmbUbigeoEstado'},{av:'AV47GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV48GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoDepartamento_Visible',ctrl:'UBIGEODEPARTAMENTO',prop:'Visible'},{av:'edtUbigeoDepartamentoCode_Visible',ctrl:'UBIGEODEPARTAMENTOCODE',prop:'Visible'},{av:'edtUbigeoProvincia_Visible',ctrl:'UBIGEOPROVINCIA',prop:'Visible'},{av:'edtUbigeoProvinciaCode_Visible',ctrl:'UBIGEOPROVINCIACODE',prop:'Visible'},{av:'edtUbigeoDistrito_Visible',ctrl:'UBIGEODISTRITO',prop:'Visible'},{av:'edtUbigeoDistritoCode_Visible',ctrl:'UBIGEODISTRITOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'cmbUbigeoEstado'},{av:'AV47GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV48GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e162H2',iparms:[{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e172H2',iparms:[{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e182H2',iparms:[{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV28TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV29TFUbigeoDepartamento',fld:'vTFUBIGEODEPARTAMENTO',pic:''},{av:'AV30TFUbigeoDepartamento_Sel',fld:'vTFUBIGEODEPARTAMENTO_SEL',pic:''},{av:'AV31TFUbigeoDepartamentoCode',fld:'vTFUBIGEODEPARTAMENTOCODE',pic:''},{av:'AV32TFUbigeoDepartamentoCode_Sel',fld:'vTFUBIGEODEPARTAMENTOCODE_SEL',pic:''},{av:'AV33TFUbigeoProvincia',fld:'vTFUBIGEOPROVINCIA',pic:''},{av:'AV34TFUbigeoProvincia_Sel',fld:'vTFUBIGEOPROVINCIA_SEL',pic:''},{av:'AV35TFUbigeoProvinciaCode',fld:'vTFUBIGEOPROVINCIACODE',pic:''},{av:'AV36TFUbigeoProvinciaCode_Sel',fld:'vTFUBIGEOPROVINCIACODE_SEL',pic:''},{av:'AV37TFUbigeoDistrito',fld:'vTFUBIGEODISTRITO',pic:''},{av:'AV38TFUbigeoDistrito_Sel',fld:'vTFUBIGEODISTRITO_SEL',pic:''},{av:'AV39TFUbigeoDistritoCode',fld:'vTFUBIGEODISTRITOCODE',pic:''},{av:'AV40TFUbigeoDistritoCode_Sel',fld:'vTFUBIGEODISTRITOCODE_SEL',pic:''},{av:'AV41TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV42TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV44TFUbigeoEstado_Sels',fld:'vTFUBIGEOESTADO_SELS',pic:''},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV43TFUbigeoEstado_SelsJson',fld:'vTFUBIGEOESTADO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'}]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[]}");
      setEventMetadata("VALID_UBIGEODEPARTAMENTO","{handler:'valid_Ubigeodepartamento',iparms:[]");
      setEventMetadata("VALID_UBIGEODEPARTAMENTO",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOPROVINCIA","{handler:'valid_Ubigeoprovincia',iparms:[]");
      setEventMetadata("VALID_UBIGEOPROVINCIA",",oparms:[]}");
      setEventMetadata("VALID_UBIGEODISTRITO","{handler:'valid_Ubigeodistrito',iparms:[]");
      setEventMetadata("VALID_UBIGEODISTRITO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Ubigeoestado',iparms:[]");
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
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV16FilterFullText = "" ;
      AV21ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27TFUbigeoCode = "" ;
      AV28TFUbigeoCode_Sel = "" ;
      AV29TFUbigeoDepartamento = "" ;
      AV30TFUbigeoDepartamento_Sel = "" ;
      AV31TFUbigeoDepartamentoCode = "" ;
      AV32TFUbigeoDepartamentoCode_Sel = "" ;
      AV33TFUbigeoProvincia = "" ;
      AV34TFUbigeoProvincia_Sel = "" ;
      AV35TFUbigeoProvinciaCode = "" ;
      AV36TFUbigeoProvinciaCode_Sel = "" ;
      AV37TFUbigeoDistrito = "" ;
      AV38TFUbigeoDistrito_Sel = "" ;
      AV39TFUbigeoDistritoCode = "" ;
      AV40TFUbigeoDistritoCode_Sel = "" ;
      AV41TFUbigeoNombre = "" ;
      AV42TFUbigeoNombre_Sel = "" ;
      AV44TFUbigeoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Pgmname = "" ;
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
      AV24ManageFiltersData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV45DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV43TFUbigeoEstado_SelsJson = "" ;
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
      AV49Update = "" ;
      AV51Delete = "" ;
      A44UbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A187UbigeoProvincia = "" ;
      A296UbigeoProvinciaCode = "" ;
      A188UbigeoDistrito = "" ;
      A297UbigeoDistritoCode = "" ;
      A185UbigeoNombre = "" ;
      A294UbigeoEstado = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV74Ubigeowwds_18_tfubigeoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV57Ubigeowwds_1_filterfulltext = "" ;
      lV58Ubigeowwds_2_tfubigeocode = "" ;
      lV60Ubigeowwds_4_tfubigeodepartamento = "" ;
      lV62Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      lV64Ubigeowwds_8_tfubigeoprovincia = "" ;
      lV66Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      lV68Ubigeowwds_12_tfubigeodistrito = "" ;
      lV70Ubigeowwds_14_tfubigeodistritocode = "" ;
      lV72Ubigeowwds_16_tfubigeonombre = "" ;
      AV57Ubigeowwds_1_filterfulltext = "" ;
      AV59Ubigeowwds_3_tfubigeocode_sel = "" ;
      AV58Ubigeowwds_2_tfubigeocode = "" ;
      AV61Ubigeowwds_5_tfubigeodepartamento_sel = "" ;
      AV60Ubigeowwds_4_tfubigeodepartamento = "" ;
      AV63Ubigeowwds_7_tfubigeodepartamentocode_sel = "" ;
      AV62Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      AV65Ubigeowwds_9_tfubigeoprovincia_sel = "" ;
      AV64Ubigeowwds_8_tfubigeoprovincia = "" ;
      AV67Ubigeowwds_11_tfubigeoprovinciacode_sel = "" ;
      AV66Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      AV69Ubigeowwds_13_tfubigeodistrito_sel = "" ;
      AV68Ubigeowwds_12_tfubigeodistrito = "" ;
      AV71Ubigeowwds_15_tfubigeodistritocode_sel = "" ;
      AV70Ubigeowwds_14_tfubigeodistritocode = "" ;
      AV73Ubigeowwds_17_tfubigeonombre_sel = "" ;
      AV72Ubigeowwds_16_tfubigeonombre = "" ;
      H002H2_A294UbigeoEstado = new String[] {""} ;
      H002H2_A44UbigeoCode = new String[] {""} ;
      H002H2_A188UbigeoDistrito = new String[] {""} ;
      H002H2_A187UbigeoProvincia = new String[] {""} ;
      H002H2_A186UbigeoDepartamento = new String[] {""} ;
      H002H3_AGRID_nRecordCount = new long[1] ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV25ManageFiltersXml = "" ;
      AV17ExcelFilename = "" ;
      AV18ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector7 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      GXt_char26 = "" ;
      GXv_char27 = new String[1] ;
      GXt_char24 = "" ;
      GXv_char25 = new String[1] ;
      GXt_char22 = "" ;
      GXv_char23 = new String[1] ;
      GXt_char20 = "" ;
      GXv_char21 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char19 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char6 = new String[1] ;
      GXv_SdtWWPGridState28 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ubigeoww__default(),
         new Object[] {
             new Object[] {
            H002H2_A294UbigeoEstado, H002H2_A44UbigeoCode, H002H2_A188UbigeoDistrito, H002H2_A187UbigeoProvincia, H002H2_A186UbigeoDepartamento
            }
            , new Object[] {
            H002H3_AGRID_nRecordCount
            }
         }
      );
      AV75Pgmname = "UbigeoWW" ;
      /* GeneXus formulas. */
      AV75Pgmname = "UbigeoWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV26ManageFiltersExecutionStep ;
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
   private short AV13OrderedBy ;
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
   private int edtUbigeoCode_Visible ;
   private int edtUbigeoDepartamento_Visible ;
   private int edtUbigeoDepartamentoCode_Visible ;
   private int edtUbigeoProvincia_Visible ;
   private int edtUbigeoProvinciaCode_Visible ;
   private int edtUbigeoDistrito_Visible ;
   private int edtUbigeoDistritoCode_Visible ;
   private int edtUbigeoNombre_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV74Ubigeowwds_18_tfubigeoestado_sels_size ;
   private int AV46PageToGo ;
   private int AV76GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV47GridCurrentPage ;
   private long AV48GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_43_idx="0001" ;
   private String AV27TFUbigeoCode ;
   private String AV28TFUbigeoCode_Sel ;
   private String AV75Pgmname ;
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
   private String subGrid_Header ;
   private String AV49Update ;
   private String edtavUpdate_Link ;
   private String AV51Delete ;
   private String edtavDelete_Link ;
   private String A44UbigeoCode ;
   private String edtUbigeoNombre_Link ;
   private String A294UbigeoEstado ;
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
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoDepartamento_Internalname ;
   private String edtUbigeoDepartamentoCode_Internalname ;
   private String edtUbigeoProvincia_Internalname ;
   private String edtUbigeoProvinciaCode_Internalname ;
   private String edtUbigeoDistrito_Internalname ;
   private String edtUbigeoDistritoCode_Internalname ;
   private String edtUbigeoNombre_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String lV58Ubigeowwds_2_tfubigeocode ;
   private String AV59Ubigeowwds_3_tfubigeocode_sel ;
   private String AV58Ubigeowwds_2_tfubigeocode ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String GXt_char26 ;
   private String GXv_char27[] ;
   private String GXt_char24 ;
   private String GXv_char25[] ;
   private String GXt_char22 ;
   private String GXv_char23[] ;
   private String GXt_char20 ;
   private String GXv_char21[] ;
   private String GXt_char18 ;
   private String GXv_char19[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char13 ;
   private String GXv_char6[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoDepartamento_Jsonclick ;
   private String edtUbigeoDepartamentoCode_Jsonclick ;
   private String edtUbigeoProvincia_Jsonclick ;
   private String edtUbigeoProvinciaCode_Jsonclick ;
   private String edtUbigeoDistrito_Jsonclick ;
   private String edtUbigeoDistritoCode_Jsonclick ;
   private String edtUbigeoNombre_Jsonclick ;
   private String GXCCtl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV50IsAuthorized_Update ;
   private boolean AV52IsAuthorized_Delete ;
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
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV53TempBoolean ;
   private boolean GXt_boolean9 ;
   private boolean GXv_boolean10[] ;
   private String AV43TFUbigeoEstado_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV29TFUbigeoDepartamento ;
   private String AV30TFUbigeoDepartamento_Sel ;
   private String AV31TFUbigeoDepartamentoCode ;
   private String AV32TFUbigeoDepartamentoCode_Sel ;
   private String AV33TFUbigeoProvincia ;
   private String AV34TFUbigeoProvincia_Sel ;
   private String AV35TFUbigeoProvinciaCode ;
   private String AV36TFUbigeoProvinciaCode_Sel ;
   private String AV37TFUbigeoDistrito ;
   private String AV38TFUbigeoDistrito_Sel ;
   private String AV39TFUbigeoDistritoCode ;
   private String AV40TFUbigeoDistritoCode_Sel ;
   private String AV41TFUbigeoNombre ;
   private String AV42TFUbigeoNombre_Sel ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String A187UbigeoProvincia ;
   private String A296UbigeoProvinciaCode ;
   private String A188UbigeoDistrito ;
   private String A297UbigeoDistritoCode ;
   private String A185UbigeoNombre ;
   private String lV57Ubigeowwds_1_filterfulltext ;
   private String lV60Ubigeowwds_4_tfubigeodepartamento ;
   private String lV62Ubigeowwds_6_tfubigeodepartamentocode ;
   private String lV64Ubigeowwds_8_tfubigeoprovincia ;
   private String lV66Ubigeowwds_10_tfubigeoprovinciacode ;
   private String lV68Ubigeowwds_12_tfubigeodistrito ;
   private String lV70Ubigeowwds_14_tfubigeodistritocode ;
   private String lV72Ubigeowwds_16_tfubigeonombre ;
   private String AV57Ubigeowwds_1_filterfulltext ;
   private String AV61Ubigeowwds_5_tfubigeodepartamento_sel ;
   private String AV60Ubigeowwds_4_tfubigeodepartamento ;
   private String AV63Ubigeowwds_7_tfubigeodepartamentocode_sel ;
   private String AV62Ubigeowwds_6_tfubigeodepartamentocode ;
   private String AV65Ubigeowwds_9_tfubigeoprovincia_sel ;
   private String AV64Ubigeowwds_8_tfubigeoprovincia ;
   private String AV67Ubigeowwds_11_tfubigeoprovinciacode_sel ;
   private String AV66Ubigeowwds_10_tfubigeoprovinciacode ;
   private String AV69Ubigeowwds_13_tfubigeodistrito_sel ;
   private String AV68Ubigeowwds_12_tfubigeodistrito ;
   private String AV71Ubigeowwds_15_tfubigeodistritocode_sel ;
   private String AV70Ubigeowwds_14_tfubigeodistritocode ;
   private String AV73Ubigeowwds_17_tfubigeonombre_sel ;
   private String AV72Ubigeowwds_16_tfubigeonombre ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV74Ubigeowwds_18_tfubigeoestado_sels ;
   private HTMLChoice cmbUbigeoEstado ;
   private IDataStoreProvider pr_default ;
   private String[] H002H2_A294UbigeoEstado ;
   private String[] H002H2_A44UbigeoCode ;
   private String[] H002H2_A188UbigeoDistrito ;
   private String[] H002H2_A187UbigeoProvincia ;
   private String[] H002H2_A186UbigeoDepartamento ;
   private long[] H002H3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV44TFUbigeoEstado_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState28[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector7[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV45DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class ubigeoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV74Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV57Ubigeowwds_1_filterfulltext ,
                                          String AV59Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV58Ubigeowwds_2_tfubigeocode ,
                                          String AV61Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV60Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV63Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV62Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV65Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV64Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV67Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV66Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV69Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV68Ubigeowwds_12_tfubigeodistrito ,
                                          String AV71Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV70Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV73Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV72Ubigeowwds_16_tfubigeonombre ,
                                          int AV74Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[29];
      Object[] GXv_Object30 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento]" ;
      sFromString = " FROM [Ubigeo]" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV57Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int29[0] = (byte)(1) ;
         GXv_int29[1] = (byte)(1) ;
         GXv_int29[2] = (byte)(1) ;
         GXv_int29[3] = (byte)(1) ;
         GXv_int29[4] = (byte)(1) ;
         GXv_int29[5] = (byte)(1) ;
         GXv_int29[6] = (byte)(1) ;
         GXv_int29[7] = (byte)(1) ;
         GXv_int29[8] = (byte)(1) ;
         GXv_int29[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV58Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int29[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int29[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV60Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int29[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int29[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV62Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int29[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int29[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV64Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int29[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int29[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV66Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int29[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int29[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV68Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int29[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int29[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV71Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV70Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int29[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int29[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV72Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int29[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int29[25] = (byte)(1) ;
      }
      if ( AV74Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV74Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [UbigeoCode]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [UbigeoCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [UbigeoDepartamento]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [UbigeoDepartamento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [UbigeoProvincia]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [UbigeoProvincia] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [UbigeoDistrito]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [UbigeoDistrito] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [UbigeoEstado]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [UbigeoEstado] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY [UbigeoCode]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
   }

   protected Object[] conditional_H002H3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV74Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV57Ubigeowwds_1_filterfulltext ,
                                          String AV59Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV58Ubigeowwds_2_tfubigeocode ,
                                          String AV61Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV60Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV63Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV62Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV65Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV64Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV67Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV66Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV69Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV68Ubigeowwds_12_tfubigeodistrito ,
                                          String AV71Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV70Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV73Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV72Ubigeowwds_16_tfubigeonombre ,
                                          int AV74Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int32 = new byte[26];
      Object[] GXv_Object33 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV57Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int32[0] = (byte)(1) ;
         GXv_int32[1] = (byte)(1) ;
         GXv_int32[2] = (byte)(1) ;
         GXv_int32[3] = (byte)(1) ;
         GXv_int32[4] = (byte)(1) ;
         GXv_int32[5] = (byte)(1) ;
         GXv_int32[6] = (byte)(1) ;
         GXv_int32[7] = (byte)(1) ;
         GXv_int32[8] = (byte)(1) ;
         GXv_int32[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV58Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int32[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int32[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV60Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int32[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int32[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV62Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int32[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int32[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV64Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int32[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int32[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV66Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int32[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int32[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV68Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int32[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int32[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV71Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV70Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int32[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int32[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV72Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int32[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int32[25] = (byte)(1) ;
      }
      if ( AV74Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV74Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object33[0] = scmdbuf ;
      GXv_Object33[1] = GXv_int32 ;
      return GXv_Object33 ;
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
                  return conditional_H002H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
            case 1 :
                  return conditional_H002H3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002H3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[39], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[40], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[55]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[56]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[57]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
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
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
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
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
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
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
      }
   }

}

