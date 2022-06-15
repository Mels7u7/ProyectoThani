package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class laboratorioww_impl extends GXDataArea
{
   public laboratorioww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public laboratorioww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( laboratorioww_impl.class ));
   }

   public laboratorioww_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbLaboratorioTipoDocumento = new HTMLChoice();
      cmbLaboratorioEstado = new HTMLChoice();
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
            AV27TFLaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "TFLaboratorioId"))) ;
            AV28TFLaboratorioId_To = (short)(GXutil.lval( httpContext.GetPar( "TFLaboratorioId_To"))) ;
            AV29TFLaboratorioNombre = httpContext.GetPar( "TFLaboratorioNombre") ;
            AV30TFLaboratorioNombre_Sel = httpContext.GetPar( "TFLaboratorioNombre_Sel") ;
            AV31TFLaboratorioDescripcion = httpContext.GetPar( "TFLaboratorioDescripcion") ;
            AV32TFLaboratorioDescripcion_Sel = httpContext.GetPar( "TFLaboratorioDescripcion_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34TFLaboratorioTipoDocumento_Sels);
            AV35TFLaboratorioNroDocumento = httpContext.GetPar( "TFLaboratorioNroDocumento") ;
            AV36TFLaboratorioNroDocumento_Sel = httpContext.GetPar( "TFLaboratorioNroDocumento_Sel") ;
            AV37TFLaboratorioComision = (short)(GXutil.lval( httpContext.GetPar( "TFLaboratorioComision"))) ;
            AV38TFLaboratorioComision_To = (short)(GXutil.lval( httpContext.GetPar( "TFLaboratorioComision_To"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV40TFLaboratorioEstado_Sels);
            AV66Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV46IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV47IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFLaboratorioId, AV28TFLaboratorioId_To, AV29TFLaboratorioNombre, AV30TFLaboratorioNombre_Sel, AV31TFLaboratorioDescripcion, AV32TFLaboratorioDescripcion_Sel, AV34TFLaboratorioTipoDocumento_Sels, AV35TFLaboratorioNroDocumento, AV36TFLaboratorioNroDocumento_Sel, AV37TFLaboratorioComision, AV38TFLaboratorioComision_To, AV40TFLaboratorioEstado_Sels, AV66Pgmname, AV13OrderedBy, AV14OrderedDsc, AV46IsAuthorized_Update, AV47IsAuthorized_Delete) ;
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
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
      pa202( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start202( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033239", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.laboratorioww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV46IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV47IsAuthorized_Delete));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV43GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV44GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV41DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV41DDO_TitleSettingsIcons);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOID", GXutil.ltrim( localUtil.ntoc( AV27TFLaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFLaboratorioId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIONOMBRE", AV29TFLaboratorioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIONOMBRE_SEL", AV30TFLaboratorioNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIODESCRIPCION", AV31TFLaboratorioDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIODESCRIPCION_SEL", AV32TFLaboratorioDescripcion_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLABORATORIOTIPODOCUMENTO_SELS", AV34TFLaboratorioTipoDocumento_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLABORATORIOTIPODOCUMENTO_SELS", AV34TFLaboratorioTipoDocumento_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIONRODOCUMENTO", AV35TFLaboratorioNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIONRODOCUMENTO_SEL", AV36TFLaboratorioNroDocumento_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOCOMISION", GXutil.ltrim( localUtil.ntoc( AV37TFLaboratorioComision, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOCOMISION_TO", GXutil.ltrim( localUtil.ntoc( AV38TFLaboratorioComision_To, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLABORATORIOESTADO_SELS", AV40TFLaboratorioEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLABORATORIOESTADO_SELS", AV40TFLaboratorioEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV66Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV46IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV46IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV47IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV47IsAuthorized_Delete));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOTIPODOCUMENTO_SELSJSON", AV33TFLaboratorioTipoDocumento_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOESTADO_SELSJSON", AV39TFLaboratorioEstado_SelsJson);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
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
         we202( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt202( ) ;
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
      return formatLink("com.projectthani.laboratorioww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "LaboratorioWW" ;
   }

   public String getPgmdesc( )
   {
      return " Laboratorio" ;
   }

   public void wb200( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LaboratorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LaboratorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LaboratorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LaboratorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_202( true) ;
      }
      else
      {
         wb_table1_25_202( false) ;
      }
      return  ;
   }

   public void wb_table1_25_202e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioDescripcion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLaboratorioTipoDocumento.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioNroDocumento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioPhoto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Imagen") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioComision_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Comision") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLaboratorioEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV50Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLaboratorioId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A165LaboratorioNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtLaboratorioNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLaboratorioNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A166LaboratorioDescripcion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLaboratorioDescripcion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A167LaboratorioTipoDocumento));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLaboratorioTipoDocumento.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A168LaboratorioNroDocumento);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLaboratorioNroDocumento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A169LaboratorioPhoto));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLaboratorioPhoto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A170LaboratorioComision, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLaboratorioComision_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A171LaboratorioEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLaboratorioEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV43GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV44GridPageCount);
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
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV41DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV41DDO_TitleSettingsIcons);
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

   public void start202( )
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
         Form.getMeta().addItem("description", " Laboratorio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup200( ) ;
   }

   public void ws202( )
   {
      start202( ) ;
      evt202( ) ;
   }

   public void evt202( )
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
                           e11202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17202 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e18202 ();
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
                           AV50Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV50Delete);
                           A40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".")) ;
                           A165LaboratorioNombre = httpContext.cgiGet( edtLaboratorioNombre_Internalname) ;
                           A166LaboratorioDescripcion = httpContext.cgiGet( edtLaboratorioDescripcion_Internalname) ;
                           cmbLaboratorioTipoDocumento.setName( cmbLaboratorioTipoDocumento.getInternalname() );
                           cmbLaboratorioTipoDocumento.setValue( httpContext.cgiGet( cmbLaboratorioTipoDocumento.getInternalname()) );
                           A167LaboratorioTipoDocumento = httpContext.cgiGet( cmbLaboratorioTipoDocumento.getInternalname()) ;
                           A168LaboratorioNroDocumento = httpContext.cgiGet( edtLaboratorioNroDocumento_Internalname) ;
                           A169LaboratorioPhoto = httpContext.cgiGet( edtLaboratorioPhoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
                           A170LaboratorioComision = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioComision_Internalname), ",", ".")) ;
                           cmbLaboratorioEstado.setName( cmbLaboratorioEstado.getInternalname() );
                           cmbLaboratorioEstado.setValue( httpContext.cgiGet( cmbLaboratorioEstado.getInternalname()) );
                           A171LaboratorioEstado = httpContext.cgiGet( cmbLaboratorioEstado.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19202 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20202 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21202 ();
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

   public void we202( )
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

   public void pa202( )
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
                                 short AV27TFLaboratorioId ,
                                 short AV28TFLaboratorioId_To ,
                                 String AV29TFLaboratorioNombre ,
                                 String AV30TFLaboratorioNombre_Sel ,
                                 String AV31TFLaboratorioDescripcion ,
                                 String AV32TFLaboratorioDescripcion_Sel ,
                                 GXSimpleCollection<String> AV34TFLaboratorioTipoDocumento_Sels ,
                                 String AV35TFLaboratorioNroDocumento ,
                                 String AV36TFLaboratorioNroDocumento_Sel ,
                                 short AV37TFLaboratorioComision ,
                                 short AV38TFLaboratorioComision_To ,
                                 GXSimpleCollection<String> AV40TFLaboratorioEstado_Sels ,
                                 String AV66Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV46IsAuthorized_Update ,
                                 boolean AV47IsAuthorized_Delete )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20202 ();
      GRID_nCurrentRecord = 0 ;
      rf202( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_LABORATORIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "LABORATORIOID", GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ".", "")));
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
      rf202( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV66Pgmname = "LaboratorioWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf202( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e20202 ();
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
                                              A167LaboratorioTipoDocumento ,
                                              AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                              A171LaboratorioEstado ,
                                              AV65Laboratoriowwds_13_tflaboratorioestado_sels ,
                                              AV53Laboratoriowwds_1_filterfulltext ,
                                              Short.valueOf(AV54Laboratoriowwds_2_tflaboratorioid) ,
                                              Short.valueOf(AV55Laboratoriowwds_3_tflaboratorioid_to) ,
                                              AV57Laboratoriowwds_5_tflaboratorionombre_sel ,
                                              AV56Laboratoriowwds_4_tflaboratorionombre ,
                                              AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                              AV58Laboratoriowwds_6_tflaboratoriodescripcion ,
                                              Integer.valueOf(AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                              AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                              AV61Laboratoriowwds_9_tflaboratorionrodocumento ,
                                              Short.valueOf(AV63Laboratoriowwds_11_tflaboratoriocomision) ,
                                              Short.valueOf(AV64Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                              Integer.valueOf(AV65Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                              Short.valueOf(A40LaboratorioId) ,
                                              A165LaboratorioNombre ,
                                              A166LaboratorioDescripcion ,
                                              A168LaboratorioNroDocumento ,
                                              Short.valueOf(A170LaboratorioComision) ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
         lV56Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV56Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
         lV58Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV58Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
         lV61Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV61Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
         /* Using cursor H00202 */
         pr_default.execute(0, new Object[] {lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, Short.valueOf(AV54Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV55Laboratoriowwds_3_tflaboratorioid_to), lV56Laboratoriowwds_4_tflaboratorionombre, AV57Laboratoriowwds_5_tflaboratorionombre_sel, lV58Laboratoriowwds_6_tflaboratoriodescripcion, AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV61Laboratoriowwds_9_tflaboratorionrodocumento, AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV63Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV64Laboratoriowwds_12_tflaboratoriocomision_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A171LaboratorioEstado = H00202_A171LaboratorioEstado[0] ;
            A170LaboratorioComision = H00202_A170LaboratorioComision[0] ;
            A169LaboratorioPhoto = H00202_A169LaboratorioPhoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
            A40000LaboratorioPhoto_GXI = H00202_A40000LaboratorioPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
            A168LaboratorioNroDocumento = H00202_A168LaboratorioNroDocumento[0] ;
            A167LaboratorioTipoDocumento = H00202_A167LaboratorioTipoDocumento[0] ;
            A166LaboratorioDescripcion = H00202_A166LaboratorioDescripcion[0] ;
            A165LaboratorioNombre = H00202_A165LaboratorioNombre[0] ;
            A40LaboratorioId = H00202_A40LaboratorioId[0] ;
            e21202 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb200( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes202( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV66Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV66Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV46IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV46IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV47IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV47IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_LABORATORIOID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9")));
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
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A167LaboratorioTipoDocumento ,
                                           AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                           A171LaboratorioEstado ,
                                           AV65Laboratoriowwds_13_tflaboratorioestado_sels ,
                                           AV53Laboratoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV54Laboratoriowwds_2_tflaboratorioid) ,
                                           Short.valueOf(AV55Laboratoriowwds_3_tflaboratorioid_to) ,
                                           AV57Laboratoriowwds_5_tflaboratorionombre_sel ,
                                           AV56Laboratoriowwds_4_tflaboratorionombre ,
                                           AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                           AV58Laboratoriowwds_6_tflaboratoriodescripcion ,
                                           Integer.valueOf(AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                           AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                           AV61Laboratoriowwds_9_tflaboratorionrodocumento ,
                                           Short.valueOf(AV63Laboratoriowwds_11_tflaboratoriocomision) ,
                                           Short.valueOf(AV64Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                           Integer.valueOf(AV65Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A166LaboratorioDescripcion ,
                                           A168LaboratorioNroDocumento ,
                                           Short.valueOf(A170LaboratorioComision) ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV53Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV56Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV56Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
      lV58Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV58Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
      lV61Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV61Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
      /* Using cursor H00203 */
      pr_default.execute(1, new Object[] {lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, lV53Laboratoriowwds_1_filterfulltext, Short.valueOf(AV54Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV55Laboratoriowwds_3_tflaboratorioid_to), lV56Laboratoriowwds_4_tflaboratorionombre, AV57Laboratoriowwds_5_tflaboratorionombre_sel, lV58Laboratoriowwds_6_tflaboratoriodescripcion, AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV61Laboratoriowwds_9_tflaboratorionrodocumento, AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV63Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV64Laboratoriowwds_12_tflaboratoriocomision_to)});
      GRID_nRecordCount = H00203_AGRID_nRecordCount[0] ;
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
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFLaboratorioId, AV28TFLaboratorioId_To, AV29TFLaboratorioNombre, AV30TFLaboratorioNombre_Sel, AV31TFLaboratorioDescripcion, AV32TFLaboratorioDescripcion_Sel, AV34TFLaboratorioTipoDocumento_Sels, AV35TFLaboratorioNroDocumento, AV36TFLaboratorioNroDocumento_Sel, AV37TFLaboratorioComision, AV38TFLaboratorioComision_To, AV40TFLaboratorioEstado_Sels, AV66Pgmname, AV13OrderedBy, AV14OrderedDsc, AV46IsAuthorized_Update, AV47IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFLaboratorioId, AV28TFLaboratorioId_To, AV29TFLaboratorioNombre, AV30TFLaboratorioNombre_Sel, AV31TFLaboratorioDescripcion, AV32TFLaboratorioDescripcion_Sel, AV34TFLaboratorioTipoDocumento_Sels, AV35TFLaboratorioNroDocumento, AV36TFLaboratorioNroDocumento_Sel, AV37TFLaboratorioComision, AV38TFLaboratorioComision_To, AV40TFLaboratorioEstado_Sels, AV66Pgmname, AV13OrderedBy, AV14OrderedDsc, AV46IsAuthorized_Update, AV47IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFLaboratorioId, AV28TFLaboratorioId_To, AV29TFLaboratorioNombre, AV30TFLaboratorioNombre_Sel, AV31TFLaboratorioDescripcion, AV32TFLaboratorioDescripcion_Sel, AV34TFLaboratorioTipoDocumento_Sels, AV35TFLaboratorioNroDocumento, AV36TFLaboratorioNroDocumento_Sel, AV37TFLaboratorioComision, AV38TFLaboratorioComision_To, AV40TFLaboratorioEstado_Sels, AV66Pgmname, AV13OrderedBy, AV14OrderedDsc, AV46IsAuthorized_Update, AV47IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFLaboratorioId, AV28TFLaboratorioId_To, AV29TFLaboratorioNombre, AV30TFLaboratorioNombre_Sel, AV31TFLaboratorioDescripcion, AV32TFLaboratorioDescripcion_Sel, AV34TFLaboratorioTipoDocumento_Sels, AV35TFLaboratorioNroDocumento, AV36TFLaboratorioNroDocumento_Sel, AV37TFLaboratorioComision, AV38TFLaboratorioComision_To, AV40TFLaboratorioEstado_Sels, AV66Pgmname, AV13OrderedBy, AV14OrderedDsc, AV46IsAuthorized_Update, AV47IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFLaboratorioId, AV28TFLaboratorioId_To, AV29TFLaboratorioNombre, AV30TFLaboratorioNombre_Sel, AV31TFLaboratorioDescripcion, AV32TFLaboratorioDescripcion_Sel, AV34TFLaboratorioTipoDocumento_Sels, AV35TFLaboratorioNroDocumento, AV36TFLaboratorioNroDocumento_Sel, AV37TFLaboratorioComision, AV38TFLaboratorioComision_To, AV40TFLaboratorioEstado_Sels, AV66Pgmname, AV13OrderedBy, AV14OrderedDsc, AV46IsAuthorized_Update, AV47IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV66Pgmname = "LaboratorioWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup200( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19202 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV41DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV43GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV44GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
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
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
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
      e19202 ();
      if (returnInSub) return;
   }

   public void e19202( )
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
      Form.setCaption( " Laboratorio" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV41DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV41DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e20202( )
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
      if ( GXutil.strcmp(AV23Session.getValue("LaboratorioWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("LaboratorioWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtLaboratorioId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioDescripcion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioDescripcion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioDescripcion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbLaboratorioTipoDocumento.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioTipoDocumento.getInternalname(), "Visible", GXutil.ltrimstr( cmbLaboratorioTipoDocumento.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioNroDocumento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNroDocumento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNroDocumento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioPhoto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioPhoto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioPhoto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioComision_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioComision_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioComision_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbLaboratorioEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbLaboratorioEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV43GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GridCurrentPage), 10, 0));
      AV44GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44GridPageCount), 10, 0));
      AV53Laboratoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV54Laboratoriowwds_2_tflaboratorioid = AV27TFLaboratorioId ;
      AV55Laboratoriowwds_3_tflaboratorioid_to = AV28TFLaboratorioId_To ;
      AV56Laboratoriowwds_4_tflaboratorionombre = AV29TFLaboratorioNombre ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = AV30TFLaboratorioNombre_Sel ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = AV31TFLaboratorioDescripcion ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV32TFLaboratorioDescripcion_Sel ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV34TFLaboratorioTipoDocumento_Sels ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = AV35TFLaboratorioNroDocumento ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV36TFLaboratorioNroDocumento_Sel ;
      AV63Laboratoriowwds_11_tflaboratoriocomision = AV37TFLaboratorioComision ;
      AV64Laboratoriowwds_12_tflaboratoriocomision_to = AV38TFLaboratorioComision_To ;
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = AV40TFLaboratorioEstado_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e12202( )
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
         AV42PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV42PageToGo) ;
      }
   }

   public void e13202( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e14202( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioId") == 0 )
         {
            AV27TFLaboratorioId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLaboratorioId), 4, 0));
            AV28TFLaboratorioId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFLaboratorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFLaboratorioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioNombre") == 0 )
         {
            AV29TFLaboratorioNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFLaboratorioNombre", AV29TFLaboratorioNombre);
            AV30TFLaboratorioNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFLaboratorioNombre_Sel", AV30TFLaboratorioNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioDescripcion") == 0 )
         {
            AV31TFLaboratorioDescripcion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFLaboratorioDescripcion", AV31TFLaboratorioDescripcion);
            AV32TFLaboratorioDescripcion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFLaboratorioDescripcion_Sel", AV32TFLaboratorioDescripcion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioTipoDocumento") == 0 )
         {
            AV33TFLaboratorioTipoDocumento_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFLaboratorioTipoDocumento_SelsJson", AV33TFLaboratorioTipoDocumento_SelsJson);
            AV34TFLaboratorioTipoDocumento_Sels.fromJSonString(AV33TFLaboratorioTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioNroDocumento") == 0 )
         {
            AV35TFLaboratorioNroDocumento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFLaboratorioNroDocumento", AV35TFLaboratorioNroDocumento);
            AV36TFLaboratorioNroDocumento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFLaboratorioNroDocumento_Sel", AV36TFLaboratorioNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioComision") == 0 )
         {
            AV37TFLaboratorioComision = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFLaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLaboratorioComision), 4, 0));
            AV38TFLaboratorioComision_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFLaboratorioComision_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLaboratorioComision_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioEstado") == 0 )
         {
            AV39TFLaboratorioEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFLaboratorioEstado_SelsJson", AV39TFLaboratorioEstado_SelsJson);
            AV40TFLaboratorioEstado_Sels.fromJSonString(AV39TFLaboratorioEstado_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLaboratorioEstado_Sels", AV40TFLaboratorioEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFLaboratorioTipoDocumento_Sels", AV34TFLaboratorioTipoDocumento_Sels);
   }

   private void e21202( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV49Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV49Update);
      if ( AV46IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.laboratorio", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A40LaboratorioId,4,0))}, new String[] {"Mode","LaboratorioId"})  ;
      }
      AV50Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV50Delete);
      if ( AV47IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.laboratorio", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A40LaboratorioId,4,0))}, new String[] {"Mode","LaboratorioId"})  ;
      }
      edtLaboratorioNombre_Link = formatLink("com.projectthani.laboratorioview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A40LaboratorioId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"LaboratorioId","TabCode"})  ;
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

   public void e15202( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LaboratorioWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e11202( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("LaboratorioWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV66Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("LaboratorioWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV25ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "LaboratorioWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         laboratorioww_impl.this.GXt_char4 = GXv_char5[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV66Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFLaboratorioTipoDocumento_Sels", AV34TFLaboratorioTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLaboratorioEstado_Sels", AV40TFLaboratorioEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e16202( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.laboratorio", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","LaboratorioId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17202( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char5[0] = AV17ExcelFilename ;
      GXv_char6[0] = AV18ErrorMessage ;
      new com.projectthani.laboratoriowwexport(remoteHandle, context).execute( GXv_char5, GXv_char6) ;
      laboratorioww_impl.this.AV17ExcelFilename = GXv_char5[0] ;
      laboratorioww_impl.this.AV18ErrorMessage = GXv_char6[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLaboratorioEstado_Sels", AV40TFLaboratorioEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFLaboratorioTipoDocumento_Sels", AV34TFLaboratorioTipoDocumento_Sels);
   }

   public void e18202( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.laboratoriowwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLaboratorioEstado_Sels", AV40TFLaboratorioEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFLaboratorioTipoDocumento_Sels", AV34TFLaboratorioTipoDocumento_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioNombre", "", "Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioDescripcion", "", "Descripcion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioTipoDocumento", "", "Tipo Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioNroDocumento", "", "Nro Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioPhoto", "", "Imagen", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioComision", "", "Comision", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LaboratorioEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXt_char4 = AV20UserCustomValue ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LaboratorioWWColumnsSelector", GXv_char6) ;
      laboratorioww_impl.this.GXt_char4 = GXv_char6[0] ;
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
      GXt_boolean9 = AV46IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio_Update", GXv_boolean10) ;
      laboratorioww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV46IsAuthorized_Update = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46IsAuthorized_Update", AV46IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV46IsAuthorized_Update));
      if ( ! ( AV46IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV47IsAuthorized_Delete ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio_Delete", GXv_boolean10) ;
      laboratorioww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV47IsAuthorized_Delete = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47IsAuthorized_Delete", AV47IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV47IsAuthorized_Delete));
      if ( ! ( AV47IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV48TempBoolean ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio_Insert", GXv_boolean10) ;
      laboratorioww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV48TempBoolean = GXt_boolean9 ;
      if ( ! ( AV48TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "LaboratorioWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFLaboratorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLaboratorioId), 4, 0));
      AV28TFLaboratorioId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFLaboratorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFLaboratorioId_To), 4, 0));
      AV29TFLaboratorioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFLaboratorioNombre", AV29TFLaboratorioNombre);
      AV30TFLaboratorioNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFLaboratorioNombre_Sel", AV30TFLaboratorioNombre_Sel);
      AV31TFLaboratorioDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFLaboratorioDescripcion", AV31TFLaboratorioDescripcion);
      AV32TFLaboratorioDescripcion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFLaboratorioDescripcion_Sel", AV32TFLaboratorioDescripcion_Sel);
      AV34TFLaboratorioTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35TFLaboratorioNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFLaboratorioNroDocumento", AV35TFLaboratorioNroDocumento);
      AV36TFLaboratorioNroDocumento_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFLaboratorioNroDocumento_Sel", AV36TFLaboratorioNroDocumento_Sel);
      AV37TFLaboratorioComision = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFLaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLaboratorioComision), 4, 0));
      AV38TFLaboratorioComision_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFLaboratorioComision_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLaboratorioComision_To), 4, 0));
      AV40TFLaboratorioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue(AV66Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV66Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV66Pgmname+"GridState"), null, null);
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
      AV67GXV1 = 1 ;
      while ( AV67GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV67GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV27TFLaboratorioId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLaboratorioId), 4, 0));
            AV28TFLaboratorioId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFLaboratorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFLaboratorioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV29TFLaboratorioNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFLaboratorioNombre", AV29TFLaboratorioNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV30TFLaboratorioNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFLaboratorioNombre_Sel", AV30TFLaboratorioNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION") == 0 )
         {
            AV31TFLaboratorioDescripcion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFLaboratorioDescripcion", AV31TFLaboratorioDescripcion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION_SEL") == 0 )
         {
            AV32TFLaboratorioDescripcion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFLaboratorioDescripcion_Sel", AV32TFLaboratorioDescripcion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOTIPODOCUMENTO_SEL") == 0 )
         {
            AV33TFLaboratorioTipoDocumento_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFLaboratorioTipoDocumento_SelsJson", AV33TFLaboratorioTipoDocumento_SelsJson);
            AV34TFLaboratorioTipoDocumento_Sels.fromJSonString(AV33TFLaboratorioTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO") == 0 )
         {
            AV35TFLaboratorioNroDocumento = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFLaboratorioNroDocumento", AV35TFLaboratorioNroDocumento);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO_SEL") == 0 )
         {
            AV36TFLaboratorioNroDocumento_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFLaboratorioNroDocumento_Sel", AV36TFLaboratorioNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOCOMISION") == 0 )
         {
            AV37TFLaboratorioComision = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFLaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLaboratorioComision), 4, 0));
            AV38TFLaboratorioComision_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFLaboratorioComision_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLaboratorioComision_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOESTADO_SEL") == 0 )
         {
            AV39TFLaboratorioEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFLaboratorioEstado_SelsJson", AV39TFLaboratorioEstado_SelsJson);
            AV40TFLaboratorioEstado_Sels.fromJSonString(AV39TFLaboratorioEstado_SelsJson, null);
         }
         AV67GXV1 = (int)(AV67GXV1+1) ;
      }
      GXt_char4 = "" ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFLaboratorioNombre_Sel)==0), AV30TFLaboratorioNombre_Sel, GXv_char6) ;
      laboratorioww_impl.this.GXt_char4 = GXv_char6[0] ;
      GXt_char13 = "" ;
      GXv_char5[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFLaboratorioDescripcion_Sel)==0), AV32TFLaboratorioDescripcion_Sel, GXv_char5) ;
      laboratorioww_impl.this.GXt_char13 = GXv_char5[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV34TFLaboratorioTipoDocumento_Sels.size()==0), AV33TFLaboratorioTipoDocumento_SelsJson, GXv_char15) ;
      laboratorioww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFLaboratorioNroDocumento_Sel)==0), AV36TFLaboratorioNroDocumento_Sel, GXv_char17) ;
      laboratorioww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV40TFLaboratorioEstado_Sels.size()==0), AV39TFLaboratorioEstado_SelsJson, GXv_char19) ;
      laboratorioww_impl.this.GXt_char18 = GXv_char19[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char4+"|"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|||"+GXt_char18 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFLaboratorioNombre)==0), AV29TFLaboratorioNombre, GXv_char19) ;
      laboratorioww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFLaboratorioDescripcion)==0), AV31TFLaboratorioDescripcion, GXv_char17) ;
      laboratorioww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFLaboratorioNroDocumento)==0), AV35TFLaboratorioNroDocumento, GXv_char15) ;
      laboratorioww_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFLaboratorioId) ? "" : GXutil.str( AV27TFLaboratorioId, 4, 0))+"|"+GXt_char18+"|"+GXt_char16+"||"+GXt_char14+"||"+((0==AV37TFLaboratorioComision) ? "" : GXutil.str( AV37TFLaboratorioComision, 4, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFLaboratorioId_To) ? "" : GXutil.str( AV28TFLaboratorioId_To, 4, 0))+"||||||"+((0==AV38TFLaboratorioComision_To) ? "" : GXutil.str( AV38TFLaboratorioComision_To, 4, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV66Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIOID", !((0==AV27TFLaboratorioId)&&(0==AV28TFLaboratorioId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFLaboratorioId, 4, 0)), GXutil.trim( GXutil.str( AV28TFLaboratorioId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIONOMBRE", !(GXutil.strcmp("", AV29TFLaboratorioNombre)==0), (short)(0), AV29TFLaboratorioNombre, "", !(GXutil.strcmp("", AV30TFLaboratorioNombre_Sel)==0), AV30TFLaboratorioNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIODESCRIPCION", !(GXutil.strcmp("", AV31TFLaboratorioDescripcion)==0), (short)(0), AV31TFLaboratorioDescripcion, "", !(GXutil.strcmp("", AV32TFLaboratorioDescripcion_Sel)==0), AV32TFLaboratorioDescripcion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIOTIPODOCUMENTO_SEL", !(AV34TFLaboratorioTipoDocumento_Sels.size()==0), (short)(0), AV34TFLaboratorioTipoDocumento_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIONRODOCUMENTO", !(GXutil.strcmp("", AV35TFLaboratorioNroDocumento)==0), (short)(0), AV35TFLaboratorioNroDocumento, "", !(GXutil.strcmp("", AV36TFLaboratorioNroDocumento_Sel)==0), AV36TFLaboratorioNroDocumento_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIOCOMISION", !((0==AV37TFLaboratorioComision)&&(0==AV38TFLaboratorioComision_To)), (short)(0), GXutil.trim( GXutil.str( AV37TFLaboratorioComision, 4, 0)), GXutil.trim( GXutil.str( AV38TFLaboratorioComision_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIOESTADO_SEL", !(AV40TFLaboratorioEstado_Sels.size()==0), (short)(0), AV40TFLaboratorioEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV66Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV66Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Laboratorio" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_202( boolean wbgen )
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
         wb_table2_30_202( true) ;
      }
      else
      {
         wb_table2_30_202( false) ;
      }
      return  ;
   }

   public void wb_table2_30_202e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_202e( true) ;
      }
      else
      {
         wb_table1_25_202e( false) ;
      }
   }

   public void wb_table2_30_202( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_LaboratorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_202e( true) ;
      }
      else
      {
         wb_table2_30_202e( false) ;
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
      pa202( ) ;
      ws202( ) ;
      we202( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110332628", true, true);
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
      httpContext.AddJavascriptSource("laboratorioww.js", "?20225110332628", false, true);
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
      edtLaboratorioId_Internalname = "LABORATORIOID_"+sGXsfl_43_idx ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE_"+sGXsfl_43_idx ;
      edtLaboratorioDescripcion_Internalname = "LABORATORIODESCRIPCION_"+sGXsfl_43_idx ;
      cmbLaboratorioTipoDocumento.setInternalname( "LABORATORIOTIPODOCUMENTO_"+sGXsfl_43_idx );
      edtLaboratorioNroDocumento_Internalname = "LABORATORIONRODOCUMENTO_"+sGXsfl_43_idx ;
      edtLaboratorioPhoto_Internalname = "LABORATORIOPHOTO_"+sGXsfl_43_idx ;
      edtLaboratorioComision_Internalname = "LABORATORIOCOMISION_"+sGXsfl_43_idx ;
      cmbLaboratorioEstado.setInternalname( "LABORATORIOESTADO_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtLaboratorioId_Internalname = "LABORATORIOID_"+sGXsfl_43_fel_idx ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE_"+sGXsfl_43_fel_idx ;
      edtLaboratorioDescripcion_Internalname = "LABORATORIODESCRIPCION_"+sGXsfl_43_fel_idx ;
      cmbLaboratorioTipoDocumento.setInternalname( "LABORATORIOTIPODOCUMENTO_"+sGXsfl_43_fel_idx );
      edtLaboratorioNroDocumento_Internalname = "LABORATORIONRODOCUMENTO_"+sGXsfl_43_fel_idx ;
      edtLaboratorioPhoto_Internalname = "LABORATORIOPHOTO_"+sGXsfl_43_fel_idx ;
      edtLaboratorioComision_Internalname = "LABORATORIOCOMISION_"+sGXsfl_43_fel_idx ;
      cmbLaboratorioEstado.setInternalname( "LABORATORIOESTADO_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb200( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV50Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLaboratorioId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioId_Internalname,GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLaboratorioId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLaboratorioId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLaboratorioNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioNombre_Internalname,A165LaboratorioNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtLaboratorioNombre_Link,"","","",edtLaboratorioNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLaboratorioNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLaboratorioDescripcion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioDescripcion_Internalname,A166LaboratorioDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLaboratorioDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLaboratorioDescripcion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLaboratorioTipoDocumento.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLaboratorioTipoDocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LABORATORIOTIPODOCUMENTO_" + sGXsfl_43_idx ;
            cmbLaboratorioTipoDocumento.setName( GXCCtl );
            cmbLaboratorioTipoDocumento.setWebtags( "" );
            cmbLaboratorioTipoDocumento.addItem("6", "RUC", (short)(0));
            cmbLaboratorioTipoDocumento.addItem("1", "DNI", (short)(0));
            if ( cmbLaboratorioTipoDocumento.getItemCount() > 0 )
            {
               A167LaboratorioTipoDocumento = cmbLaboratorioTipoDocumento.getValidValue(A167LaboratorioTipoDocumento) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLaboratorioTipoDocumento,cmbLaboratorioTipoDocumento.getInternalname(),GXutil.rtrim( A167LaboratorioTipoDocumento),Integer.valueOf(1),cmbLaboratorioTipoDocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLaboratorioTipoDocumento.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbLaboratorioTipoDocumento.setValue( GXutil.rtrim( A167LaboratorioTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioTipoDocumento.getInternalname(), "Values", cmbLaboratorioTipoDocumento.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLaboratorioNroDocumento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioNroDocumento_Internalname,A168LaboratorioNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLaboratorioNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLaboratorioNroDocumento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtLaboratorioPhoto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A169LaboratorioPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A169LaboratorioPhoto)==0)&&(GXutil.strcmp("", A40000LaboratorioPhoto_GXI)==0))||!(GXutil.strcmp("", A169LaboratorioPhoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.getResourceRelative(A169LaboratorioPhoto)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioPhoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtLaboratorioPhoto_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A169LaboratorioPhoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLaboratorioComision_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioComision_Internalname,GXutil.ltrim( localUtil.ntoc( A170LaboratorioComision, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A170LaboratorioComision), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLaboratorioComision_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLaboratorioComision_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLaboratorioEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLaboratorioEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LABORATORIOESTADO_" + sGXsfl_43_idx ;
            cmbLaboratorioEstado.setName( GXCCtl );
            cmbLaboratorioEstado.setWebtags( "" );
            cmbLaboratorioEstado.addItem("A", "Activo", (short)(0));
            cmbLaboratorioEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbLaboratorioEstado.getItemCount() > 0 )
            {
               A171LaboratorioEstado = cmbLaboratorioEstado.getValidValue(A171LaboratorioEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLaboratorioEstado,cmbLaboratorioEstado.getInternalname(),GXutil.rtrim( A171LaboratorioEstado),Integer.valueOf(1),cmbLaboratorioEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLaboratorioEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbLaboratorioEstado.setValue( GXutil.rtrim( A171LaboratorioEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioEstado.getInternalname(), "Values", cmbLaboratorioEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes202( ) ;
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
      edtLaboratorioId_Internalname = "LABORATORIOID" ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE" ;
      edtLaboratorioDescripcion_Internalname = "LABORATORIODESCRIPCION" ;
      cmbLaboratorioTipoDocumento.setInternalname( "LABORATORIOTIPODOCUMENTO" );
      edtLaboratorioNroDocumento_Internalname = "LABORATORIONRODOCUMENTO" ;
      edtLaboratorioPhoto_Internalname = "LABORATORIOPHOTO" ;
      edtLaboratorioComision_Internalname = "LABORATORIOCOMISION" ;
      cmbLaboratorioEstado.setInternalname( "LABORATORIOESTADO" );
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
      cmbLaboratorioEstado.setJsonclick( "" );
      edtLaboratorioComision_Jsonclick = "" ;
      edtLaboratorioNroDocumento_Jsonclick = "" ;
      cmbLaboratorioTipoDocumento.setJsonclick( "" );
      edtLaboratorioDescripcion_Jsonclick = "" ;
      edtLaboratorioNombre_Jsonclick = "" ;
      edtLaboratorioId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtLaboratorioNombre_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbLaboratorioEstado.setVisible( -1 );
      edtLaboratorioComision_Visible = -1 ;
      edtLaboratorioPhoto_Visible = -1 ;
      edtLaboratorioNroDocumento_Visible = -1 ;
      cmbLaboratorioTipoDocumento.setVisible( -1 );
      edtLaboratorioDescripcion_Visible = -1 ;
      edtLaboratorioNombre_Visible = -1 ;
      edtLaboratorioId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Laboratorio" );
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
      Ddo_grid_Datalistproc = "LaboratorioWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||6:RUC,1:DNI||||A:Activo,I:Inactivo" ;
      Ddo_grid_Allowmultipleselection = "|||T||||T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|FixedValues|Dynamic|||FixedValues" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|||T" ;
      Ddo_grid_Filterisrange = "T||||||T|" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character||Character||Numeric|" ;
      Ddo_grid_Includefilter = "T|T|T||T||T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T||T|T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5||6|7" ;
      Ddo_grid_Columnids = "2:LaboratorioId|3:LaboratorioNombre|4:LaboratorioDescripcion|5:LaboratorioTipoDocumento|6:LaboratorioNroDocumento|7:LaboratorioPhoto|8:LaboratorioComision|9:LaboratorioEstado" ;
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
      GXCCtl = "LABORATORIOTIPODOCUMENTO_" + sGXsfl_43_idx ;
      cmbLaboratorioTipoDocumento.setName( GXCCtl );
      cmbLaboratorioTipoDocumento.setWebtags( "" );
      cmbLaboratorioTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbLaboratorioTipoDocumento.addItem("1", "DNI", (short)(0));
      if ( cmbLaboratorioTipoDocumento.getItemCount() > 0 )
      {
         A167LaboratorioTipoDocumento = cmbLaboratorioTipoDocumento.getValidValue(A167LaboratorioTipoDocumento) ;
      }
      GXCCtl = "LABORATORIOESTADO_" + sGXsfl_43_idx ;
      cmbLaboratorioEstado.setName( GXCCtl );
      cmbLaboratorioEstado.setWebtags( "" );
      cmbLaboratorioEstado.addItem("A", "Activo", (short)(0));
      cmbLaboratorioEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbLaboratorioEstado.getItemCount() > 0 )
      {
         A171LaboratorioEstado = cmbLaboratorioEstado.getValidValue(A171LaboratorioEstado) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLaboratorioId_Visible',ctrl:'LABORATORIOID',prop:'Visible'},{av:'edtLaboratorioNombre_Visible',ctrl:'LABORATORIONOMBRE',prop:'Visible'},{av:'edtLaboratorioDescripcion_Visible',ctrl:'LABORATORIODESCRIPCION',prop:'Visible'},{av:'cmbLaboratorioTipoDocumento'},{av:'edtLaboratorioNroDocumento_Visible',ctrl:'LABORATORIONRODOCUMENTO',prop:'Visible'},{av:'edtLaboratorioPhoto_Visible',ctrl:'LABORATORIOPHOTO',prop:'Visible'},{av:'edtLaboratorioComision_Visible',ctrl:'LABORATORIOCOMISION',prop:'Visible'},{av:'cmbLaboratorioEstado'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12202',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13202',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e14202',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21202',iparms:[{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV49Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV50Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtLaboratorioNombre_Link',ctrl:'LABORATORIONOMBRE',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e15202',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLaboratorioId_Visible',ctrl:'LABORATORIOID',prop:'Visible'},{av:'edtLaboratorioNombre_Visible',ctrl:'LABORATORIONOMBRE',prop:'Visible'},{av:'edtLaboratorioDescripcion_Visible',ctrl:'LABORATORIODESCRIPCION',prop:'Visible'},{av:'cmbLaboratorioTipoDocumento'},{av:'edtLaboratorioNroDocumento_Visible',ctrl:'LABORATORIONRODOCUMENTO',prop:'Visible'},{av:'edtLaboratorioPhoto_Visible',ctrl:'LABORATORIOPHOTO',prop:'Visible'},{av:'edtLaboratorioComision_Visible',ctrl:'LABORATORIOCOMISION',prop:'Visible'},{av:'cmbLaboratorioEstado'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11202',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLaboratorioId_Visible',ctrl:'LABORATORIOID',prop:'Visible'},{av:'edtLaboratorioNombre_Visible',ctrl:'LABORATORIONOMBRE',prop:'Visible'},{av:'edtLaboratorioDescripcion_Visible',ctrl:'LABORATORIODESCRIPCION',prop:'Visible'},{av:'cmbLaboratorioTipoDocumento'},{av:'edtLaboratorioNroDocumento_Visible',ctrl:'LABORATORIONRODOCUMENTO',prop:'Visible'},{av:'edtLaboratorioPhoto_Visible',ctrl:'LABORATORIOPHOTO',prop:'Visible'},{av:'edtLaboratorioComision_Visible',ctrl:'LABORATORIOCOMISION',prop:'Visible'},{av:'cmbLaboratorioEstado'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16202',iparms:[{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17202',iparms:[{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e18202',iparms:[{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV28TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV29TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV30TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV31TFLaboratorioDescripcion',fld:'vTFLABORATORIODESCRIPCION',pic:''},{av:'AV32TFLaboratorioDescripcion_Sel',fld:'vTFLABORATORIODESCRIPCION_SEL',pic:''},{av:'AV34TFLaboratorioTipoDocumento_Sels',fld:'vTFLABORATORIOTIPODOCUMENTO_SELS',pic:''},{av:'AV35TFLaboratorioNroDocumento',fld:'vTFLABORATORIONRODOCUMENTO',pic:''},{av:'AV36TFLaboratorioNroDocumento_Sel',fld:'vTFLABORATORIONRODOCUMENTO_SEL',pic:''},{av:'AV37TFLaboratorioComision',fld:'vTFLABORATORIOCOMISION',pic:'ZZZ9'},{av:'AV38TFLaboratorioComision_To',fld:'vTFLABORATORIOCOMISION_TO',pic:'ZZZ9'},{av:'AV40TFLaboratorioEstado_Sels',fld:'vTFLABORATORIOESTADO_SELS',pic:''},{av:'AV66Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV47IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV39TFLaboratorioEstado_SelsJson',fld:'vTFLABORATORIOESTADO_SELSJSON',pic:''},{av:'AV33TFLaboratorioTipoDocumento_SelsJson',fld:'vTFLABORATORIOTIPODOCUMENTO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("NULL","{handler:'valid_Laboratorioestado',iparms:[]");
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
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV16FilterFullText = "" ;
      AV21ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV29TFLaboratorioNombre = "" ;
      AV30TFLaboratorioNombre_Sel = "" ;
      AV31TFLaboratorioDescripcion = "" ;
      AV32TFLaboratorioDescripcion_Sel = "" ;
      AV34TFLaboratorioTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFLaboratorioNroDocumento = "" ;
      AV36TFLaboratorioNroDocumento_Sel = "" ;
      AV40TFLaboratorioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Pgmname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
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
      AV41DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33TFLaboratorioTipoDocumento_SelsJson = "" ;
      AV39TFLaboratorioEstado_SelsJson = "" ;
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
      AV50Delete = "" ;
      A165LaboratorioNombre = "" ;
      A166LaboratorioDescripcion = "" ;
      A167LaboratorioTipoDocumento = "" ;
      A168LaboratorioNroDocumento = "" ;
      A169LaboratorioPhoto = "" ;
      A171LaboratorioEstado = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A40000LaboratorioPhoto_GXI = "" ;
      AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Laboratoriowwds_13_tflaboratorioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV53Laboratoriowwds_1_filterfulltext = "" ;
      lV56Laboratoriowwds_4_tflaboratorionombre = "" ;
      lV58Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      lV61Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      AV53Laboratoriowwds_1_filterfulltext = "" ;
      AV57Laboratoriowwds_5_tflaboratorionombre_sel = "" ;
      AV56Laboratoriowwds_4_tflaboratorionombre = "" ;
      AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel = "" ;
      AV58Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel = "" ;
      AV61Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      H00202_A171LaboratorioEstado = new String[] {""} ;
      H00202_A170LaboratorioComision = new short[1] ;
      H00202_A169LaboratorioPhoto = new String[] {""} ;
      H00202_A40000LaboratorioPhoto_GXI = new String[] {""} ;
      H00202_A168LaboratorioNroDocumento = new String[] {""} ;
      H00202_A167LaboratorioTipoDocumento = new String[] {""} ;
      H00202_A166LaboratorioDescripcion = new String[] {""} ;
      H00202_A165LaboratorioNombre = new String[] {""} ;
      H00202_A40LaboratorioId = new short[1] ;
      H00203_AGRID_nRecordCount = new long[1] ;
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
      GXv_char6 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char5 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char19 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXv_SdtWWPGridState20 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      sImgUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.laboratorioww__default(),
         new Object[] {
             new Object[] {
            H00202_A171LaboratorioEstado, H00202_A170LaboratorioComision, H00202_A169LaboratorioPhoto, H00202_A40000LaboratorioPhoto_GXI, H00202_A168LaboratorioNroDocumento, H00202_A167LaboratorioTipoDocumento, H00202_A166LaboratorioDescripcion, H00202_A165LaboratorioNombre, H00202_A40LaboratorioId
            }
            , new Object[] {
            H00203_AGRID_nRecordCount
            }
         }
      );
      AV66Pgmname = "LaboratorioWW" ;
      /* GeneXus formulas. */
      AV66Pgmname = "LaboratorioWW" ;
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
   private short AV27TFLaboratorioId ;
   private short AV28TFLaboratorioId_To ;
   private short AV37TFLaboratorioComision ;
   private short AV38TFLaboratorioComision_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A40LaboratorioId ;
   private short A170LaboratorioComision ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV54Laboratoriowwds_2_tflaboratorioid ;
   private short AV55Laboratoriowwds_3_tflaboratorioid_to ;
   private short AV63Laboratoriowwds_11_tflaboratoriocomision ;
   private short AV64Laboratoriowwds_12_tflaboratoriocomision_to ;
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
   private int edtLaboratorioId_Visible ;
   private int edtLaboratorioNombre_Visible ;
   private int edtLaboratorioDescripcion_Visible ;
   private int edtLaboratorioNroDocumento_Visible ;
   private int edtLaboratorioPhoto_Visible ;
   private int edtLaboratorioComision_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ;
   private int AV65Laboratoriowwds_13_tflaboratorioestado_sels_size ;
   private int AV42PageToGo ;
   private int AV67GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV43GridCurrentPage ;
   private long AV44GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_43_idx="0001" ;
   private String AV66Pgmname ;
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
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
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
   private String AV50Delete ;
   private String edtavDelete_Link ;
   private String edtLaboratorioNombre_Link ;
   private String A167LaboratorioTipoDocumento ;
   private String A171LaboratorioEstado ;
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
   private String edtLaboratorioId_Internalname ;
   private String edtLaboratorioNombre_Internalname ;
   private String edtLaboratorioDescripcion_Internalname ;
   private String edtLaboratorioNroDocumento_Internalname ;
   private String edtLaboratorioPhoto_Internalname ;
   private String edtLaboratorioComision_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char6[] ;
   private String GXt_char13 ;
   private String GXv_char5[] ;
   private String GXt_char18 ;
   private String GXv_char19[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtLaboratorioId_Jsonclick ;
   private String edtLaboratorioNombre_Jsonclick ;
   private String edtLaboratorioDescripcion_Jsonclick ;
   private String GXCCtl ;
   private String edtLaboratorioNroDocumento_Jsonclick ;
   private String sImgUrl ;
   private String edtLaboratorioComision_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV46IsAuthorized_Update ;
   private boolean AV47IsAuthorized_Delete ;
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
   private boolean AV48TempBoolean ;
   private boolean GXt_boolean9 ;
   private boolean GXv_boolean10[] ;
   private boolean A169LaboratorioPhoto_IsBlob ;
   private String AV33TFLaboratorioTipoDocumento_SelsJson ;
   private String AV39TFLaboratorioEstado_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV29TFLaboratorioNombre ;
   private String AV30TFLaboratorioNombre_Sel ;
   private String AV31TFLaboratorioDescripcion ;
   private String AV32TFLaboratorioDescripcion_Sel ;
   private String AV35TFLaboratorioNroDocumento ;
   private String AV36TFLaboratorioNroDocumento_Sel ;
   private String A165LaboratorioNombre ;
   private String A166LaboratorioDescripcion ;
   private String A168LaboratorioNroDocumento ;
   private String A40000LaboratorioPhoto_GXI ;
   private String lV53Laboratoriowwds_1_filterfulltext ;
   private String lV56Laboratoriowwds_4_tflaboratorionombre ;
   private String lV58Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String lV61Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String AV53Laboratoriowwds_1_filterfulltext ;
   private String AV57Laboratoriowwds_5_tflaboratorionombre_sel ;
   private String AV56Laboratoriowwds_4_tflaboratorionombre ;
   private String AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel ;
   private String AV58Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel ;
   private String AV61Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String A169LaboratorioPhoto ;
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
   private GXSimpleCollection<String> AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels ;
   private GXSimpleCollection<String> AV65Laboratoriowwds_13_tflaboratorioestado_sels ;
   private HTMLChoice cmbLaboratorioTipoDocumento ;
   private HTMLChoice cmbLaboratorioEstado ;
   private IDataStoreProvider pr_default ;
   private String[] H00202_A171LaboratorioEstado ;
   private short[] H00202_A170LaboratorioComision ;
   private String[] H00202_A169LaboratorioPhoto ;
   private String[] H00202_A40000LaboratorioPhoto_GXI ;
   private String[] H00202_A168LaboratorioNroDocumento ;
   private String[] H00202_A167LaboratorioTipoDocumento ;
   private String[] H00202_A166LaboratorioDescripcion ;
   private String[] H00202_A165LaboratorioNombre ;
   private short[] H00202_A40LaboratorioId ;
   private long[] H00203_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV34TFLaboratorioTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV40TFLaboratorioEstado_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState20[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector7[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV41DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class laboratorioww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00202( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV65Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV53Laboratoriowwds_1_filterfulltext ,
                                          short AV54Laboratoriowwds_2_tflaboratorioid ,
                                          short AV55Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV57Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV56Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV58Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV61Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV63Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV64Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV65Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[22];
      Object[] GXv_Object22 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " [LaboratorioEstado], [LaboratorioComision], [LaboratorioPhoto], [LaboratorioPhoto_GXI], [LaboratorioNroDocumento], [LaboratorioTipoDocumento], [LaboratorioDescripcion]," ;
      sSelectString += " [LaboratorioNombre], [LaboratorioId]" ;
      sFromString = " FROM [Laboratorio]" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV53Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
      }
      else
      {
         GXv_int21[0] = (byte)(1) ;
         GXv_int21[1] = (byte)(1) ;
         GXv_int21[2] = (byte)(1) ;
         GXv_int21[3] = (byte)(1) ;
         GXv_int21[4] = (byte)(1) ;
         GXv_int21[5] = (byte)(1) ;
         GXv_int21[6] = (byte)(1) ;
         GXv_int21[7] = (byte)(1) ;
         GXv_int21[8] = (byte)(1) ;
      }
      if ( ! (0==AV54Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int21[9] = (byte)(1) ;
      }
      if ( ! (0==AV55Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int21[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV56Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int21[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int21[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV58Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int21[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int21[14] = (byte)(1) ;
      }
      if ( AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV61Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int21[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int21[16] = (byte)(1) ;
      }
      if ( ! (0==AV63Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int21[17] = (byte)(1) ;
      }
      if ( ! (0==AV64Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int21[18] = (byte)(1) ;
      }
      if ( AV65Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV65Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioNombre]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioDescripcion]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioDescripcion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioTipoDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioTipoDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioNroDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioNroDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioComision]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioComision] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [LaboratorioEstado]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [LaboratorioEstado] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY [LaboratorioId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_H00203( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV65Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV53Laboratoriowwds_1_filterfulltext ,
                                          short AV54Laboratoriowwds_2_tflaboratorioid ,
                                          short AV55Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV57Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV56Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV58Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV61Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV63Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV64Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV65Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[19];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM [Laboratorio]" ;
      if ( ! (GXutil.strcmp("", AV53Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
      }
      else
      {
         GXv_int24[0] = (byte)(1) ;
         GXv_int24[1] = (byte)(1) ;
         GXv_int24[2] = (byte)(1) ;
         GXv_int24[3] = (byte)(1) ;
         GXv_int24[4] = (byte)(1) ;
         GXv_int24[5] = (byte)(1) ;
         GXv_int24[6] = (byte)(1) ;
         GXv_int24[7] = (byte)(1) ;
         GXv_int24[8] = (byte)(1) ;
      }
      if ( ! (0==AV54Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int24[9] = (byte)(1) ;
      }
      if ( ! (0==AV55Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int24[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV56Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int24[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int24[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV58Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int24[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int24[14] = (byte)(1) ;
      }
      if ( AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV61Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int24[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int24[16] = (byte)(1) ;
      }
      if ( ! (0==AV63Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int24[17] = (byte)(1) ;
      }
      if ( ! (0==AV64Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int24[18] = (byte)(1) ;
      }
      if ( AV65Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV65Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
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
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
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
                  return conditional_H00202(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() );
            case 1 :
                  return conditional_H00203(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00202", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00203", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
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
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[41]).intValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[42]).intValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[43]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               return;
      }
   }

}

