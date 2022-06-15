package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class logaccesosww_impl extends GXDataArea
{
   public logaccesosww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public logaccesosww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logaccesosww_impl.class ));
   }

   public logaccesosww_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbLogAccesosTipo = new HTMLChoice();
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
            AV26ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
            AV16FilterFullText = httpContext.GetPar( "FilterFullText") ;
            AV27TFLogAccesosId = (short)(GXutil.lval( httpContext.GetPar( "TFLogAccesosId"))) ;
            AV28TFLogAccesosId_To = (short)(GXutil.lval( httpContext.GetPar( "TFLogAccesosId_To"))) ;
            AV29TFSecUserId = (short)(GXutil.lval( httpContext.GetPar( "TFSecUserId"))) ;
            AV30TFSecUserId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSecUserId_To"))) ;
            AV31TFSecUserName = httpContext.GetPar( "TFSecUserName") ;
            AV32TFSecUserName_Sel = httpContext.GetPar( "TFSecUserName_Sel") ;
            AV33TFSecRoleId = (short)(GXutil.lval( httpContext.GetPar( "TFSecRoleId"))) ;
            AV34TFSecRoleId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSecRoleId_To"))) ;
            AV35TFSecRoleDescription = httpContext.GetPar( "TFSecRoleDescription") ;
            AV36TFSecRoleDescription_Sel = httpContext.GetPar( "TFSecRoleDescription_Sel") ;
            AV37TFLogAccesosFullName = httpContext.GetPar( "TFLogAccesosFullName") ;
            AV38TFLogAccesosFullName_Sel = httpContext.GetPar( "TFLogAccesosFullName_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV40TFLogAccesosTipo_Sels);
            AV41TFLogAccesosFecha = localUtil.parseDTimeParm( httpContext.GetPar( "TFLogAccesosFecha")) ;
            AV42TFLogAccesosFecha_To = localUtil.parseDTimeParm( httpContext.GetPar( "TFLogAccesosFecha_To")) ;
            AV75Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV51IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV52IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV53IsAuthorized_SecUserName = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_SecUserName")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFLogAccesosId, AV28TFLogAccesosId_To, AV29TFSecUserId, AV30TFSecUserId_To, AV31TFSecUserName, AV32TFSecUserName_Sel, AV33TFSecRoleId, AV34TFSecRoleId_To, AV35TFSecRoleDescription, AV36TFSecRoleDescription_Sel, AV37TFLogAccesosFullName, AV38TFLogAccesosFullName_Sel, AV40TFLogAccesosTipo_Sels, AV41TFLogAccesosFecha, AV42TFLogAccesosFecha_To, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV51IsAuthorized_Update, AV52IsAuthorized_Delete, AV53IsAuthorized_SecUserName) ;
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
      pa222( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start222( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110332822", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.logaccesosww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV51IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SECUSERNAME", getSecureSignedToken( "", AV53IsAuthorized_SecUserName));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV48GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV49GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV46DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV46DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_LOGACCESOSFECHAAUXDATETO", localUtil.dtoc( AV44DDO_LogAccesosFechaAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSID", GXutil.ltrim( localUtil.ntoc( AV27TFLogAccesosId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFLogAccesosId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERID", GXutil.ltrim( localUtil.ntoc( AV29TFSecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERID_TO", GXutil.ltrim( localUtil.ntoc( AV30TFSecUserId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERNAME", AV31TFSecUserName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERNAME_SEL", AV32TFSecUserName_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLEID", GXutil.ltrim( localUtil.ntoc( AV33TFSecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLEID_TO", GXutil.ltrim( localUtil.ntoc( AV34TFSecRoleId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLEDESCRIPTION", AV35TFSecRoleDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLEDESCRIPTION_SEL", AV36TFSecRoleDescription_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSFULLNAME", AV37TFLogAccesosFullName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSFULLNAME_SEL", AV38TFLogAccesosFullName_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLOGACCESOSTIPO_SELS", AV40TFLogAccesosTipo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLOGACCESOSTIPO_SELS", AV40TFLogAccesosTipo_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSFECHA", localUtil.ttoc( AV41TFLogAccesosFecha, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSFECHA_TO", localUtil.ttoc( AV42TFLogAccesosFecha_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV75Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV51IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV51IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV52IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SECUSERNAME", AV53IsAuthorized_SecUserName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SECUSERNAME", getSecureSignedToken( "", AV53IsAuthorized_SecUserName));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLOGACCESOSTIPO_SELSJSON", AV39TFLogAccesosTipo_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_LOGACCESOSFECHAAUXDATE", localUtil.dtoc( AV43DDO_LogAccesosFechaAuxDate, 0, "/"));
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
         we222( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt222( ) ;
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
      return formatLink("com.projectthani.logaccesosww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "LogAccesosWW" ;
   }

   public String getPgmdesc( )
   {
      return " Log Accesos" ;
   }

   public void wb220( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesosWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesosWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesosWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesosWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_222( true) ;
      }
      else
      {
         wb_table1_25_222( false) ;
      }
      return  ;
   }

   public void wb_table1_25_222e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLogAccesosId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Log Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecUserId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "User Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecUserName_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "User Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecRoleId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Role Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecRoleDescription_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Role Description") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLogAccesosFullName_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombres Completos") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLogAccesosTipo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLogAccesosFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV55Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV56Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A41LogAccesosId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLogAccesosId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A14SecUserName);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSecUserName_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecRoleId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A12SecRoleDescription);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecRoleDescription_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A172LogAccesosFullName);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtLogAccesosFullName_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLogAccesosFullName_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A227LogAccesosTipo));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLogAccesosTipo.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A228LogAccesosFecha, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLogAccesosFecha_Visible, (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV48GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV49GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV46DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV46DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_logaccesosfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_logaccesosfechaauxdatetext_Internalname, AV45DDO_LogAccesosFechaAuxDateText, GXutil.rtrim( localUtil.format( AV45DDO_LogAccesosFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_logaccesosfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LogAccesosWW.htm");
         /* User Defined Control */
         ucTflogaccesosfecha_rangepicker.setProperty("Start Date", AV43DDO_LogAccesosFechaAuxDate);
         ucTflogaccesosfecha_rangepicker.setProperty("End Date", AV44DDO_LogAccesosFechaAuxDateTo);
         ucTflogaccesosfecha_rangepicker.render(context, "wwp.daterangepicker", Tflogaccesosfecha_rangepicker_Internalname, "TFLOGACCESOSFECHA_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void start222( )
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
         Form.getMeta().addItem("description", " Log Accesos", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup220( ) ;
   }

   public void ws222( )
   {
      start222( ) ;
      evt222( ) ;
   }

   public void evt222( )
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
                           e11222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17222 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e18222 ();
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
                           AV55Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV55Update);
                           AV56Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV56Delete);
                           A41LogAccesosId = (short)(localUtil.ctol( httpContext.cgiGet( edtLogAccesosId_Internalname), ",", ".")) ;
                           A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
                           A14SecUserName = httpContext.cgiGet( edtSecUserName_Internalname) ;
                           A4SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), ",", ".")) ;
                           A12SecRoleDescription = httpContext.cgiGet( edtSecRoleDescription_Internalname) ;
                           A172LogAccesosFullName = httpContext.cgiGet( edtLogAccesosFullName_Internalname) ;
                           cmbLogAccesosTipo.setName( cmbLogAccesosTipo.getInternalname() );
                           cmbLogAccesosTipo.setValue( httpContext.cgiGet( cmbLogAccesosTipo.getInternalname()) );
                           A227LogAccesosTipo = httpContext.cgiGet( cmbLogAccesosTipo.getInternalname()) ;
                           A228LogAccesosFecha = localUtil.ctot( httpContext.cgiGet( edtLogAccesosFecha_Internalname), 0) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19222 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20222 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21222 ();
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

   public void we222( )
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

   public void pa222( )
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
                                 byte AV26ManageFiltersExecutionStep ,
                                 com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV16FilterFullText ,
                                 short AV27TFLogAccesosId ,
                                 short AV28TFLogAccesosId_To ,
                                 short AV29TFSecUserId ,
                                 short AV30TFSecUserId_To ,
                                 String AV31TFSecUserName ,
                                 String AV32TFSecUserName_Sel ,
                                 short AV33TFSecRoleId ,
                                 short AV34TFSecRoleId_To ,
                                 String AV35TFSecRoleDescription ,
                                 String AV36TFSecRoleDescription_Sel ,
                                 String AV37TFLogAccesosFullName ,
                                 String AV38TFLogAccesosFullName_Sel ,
                                 GXSimpleCollection<String> AV40TFLogAccesosTipo_Sels ,
                                 java.util.Date AV41TFLogAccesosFecha ,
                                 java.util.Date AV42TFLogAccesosFecha_To ,
                                 String AV75Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV51IsAuthorized_Update ,
                                 boolean AV52IsAuthorized_Delete ,
                                 boolean AV53IsAuthorized_SecUserName )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20222 ();
      GRID_nCurrentRecord = 0 ;
      rf222( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_LOGACCESOSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "LOGACCESOSID", GXutil.ltrim( localUtil.ntoc( A41LogAccesosId, (byte)(4), (byte)(0), ".", "")));
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
      rf222( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV75Pgmname = "LogAccesosWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public int subgridclient_rec_count_fnc( )
   {
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
      GRID_nRecordCount = 0 ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A227LogAccesosTipo ,
                                           AV72Logaccesoswwds_14_tflogaccesostipo_sels ,
                                           Short.valueOf(AV60Logaccesoswwds_2_tflogaccesosid) ,
                                           Short.valueOf(AV61Logaccesoswwds_3_tflogaccesosid_to) ,
                                           Short.valueOf(AV62Logaccesoswwds_4_tfsecuserid) ,
                                           Short.valueOf(AV63Logaccesoswwds_5_tfsecuserid_to) ,
                                           AV65Logaccesoswwds_7_tfsecusername_sel ,
                                           AV64Logaccesoswwds_6_tfsecusername ,
                                           Short.valueOf(AV66Logaccesoswwds_8_tfsecroleid) ,
                                           Short.valueOf(AV67Logaccesoswwds_9_tfsecroleid_to) ,
                                           AV69Logaccesoswwds_11_tfsecroledescription_sel ,
                                           AV68Logaccesoswwds_10_tfsecroledescription ,
                                           Integer.valueOf(AV72Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                           AV73Logaccesoswwds_15_tflogaccesosfecha ,
                                           AV74Logaccesoswwds_16_tflogaccesosfecha_to ,
                                           Short.valueOf(A41LogAccesosId) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           Short.valueOf(A4SecRoleId) ,
                                           A12SecRoleDescription ,
                                           A228LogAccesosFecha ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           AV59Logaccesoswwds_1_filterfulltext ,
                                           A172LogAccesosFullName ,
                                           AV71Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                           AV70Logaccesoswwds_12_tflogaccesosfullname } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV64Logaccesoswwds_6_tfsecusername), "%", "") ;
      lV68Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV68Logaccesoswwds_10_tfsecroledescription), "%", "") ;
      /* Using cursor H00222 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV60Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV61Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV62Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV63Logaccesoswwds_5_tfsecuserid_to), lV64Logaccesoswwds_6_tfsecusername, AV65Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV66Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV67Logaccesoswwds_9_tfsecroleid_to), lV68Logaccesoswwds_10_tfsecroledescription, AV69Logaccesoswwds_11_tfsecroledescription_sel, AV73Logaccesoswwds_15_tflogaccesosfecha, AV74Logaccesoswwds_16_tflogaccesosfecha_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A228LogAccesosFecha = H00222_A228LogAccesosFecha[0] ;
         A227LogAccesosTipo = H00222_A227LogAccesosTipo[0] ;
         A12SecRoleDescription = H00222_A12SecRoleDescription[0] ;
         A6SecUserId = H00222_A6SecUserId[0] ;
         A41LogAccesosId = H00222_A41LogAccesosId[0] ;
         A14SecUserName = H00222_A14SecUserName[0] ;
         A4SecRoleId = H00222_A4SecRoleId[0] ;
         A14SecUserName = H00222_A14SecUserName[0] ;
         A12SecRoleDescription = H00222_A12SecRoleDescription[0] ;
         GXt_char1 = A172LogAccesosFullName ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char2) ;
         logaccesosww_impl.this.GXt_char1 = GXv_char2[0] ;
         A172LogAccesosFullName = GXt_char1 ;
         if ( (GXutil.strcmp("", AV59Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV59Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV59Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
         {
            if ( ! ( (GXutil.strcmp("", AV71Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV70Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV70Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
            {
               if ( (GXutil.strcmp("", AV71Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV71Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
               {
                  GRID_nRecordCount = (long)(GRID_nRecordCount+1) ;
               }
            }
         }
         pr_default.readNext(0);
      }
      GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
      pr_default.close(0);
      return (int)(GRID_nRecordCount) ;
   }

   public void rf222( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e20222 ();
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
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              A227LogAccesosTipo ,
                                              AV72Logaccesoswwds_14_tflogaccesostipo_sels ,
                                              Short.valueOf(AV60Logaccesoswwds_2_tflogaccesosid) ,
                                              Short.valueOf(AV61Logaccesoswwds_3_tflogaccesosid_to) ,
                                              Short.valueOf(AV62Logaccesoswwds_4_tfsecuserid) ,
                                              Short.valueOf(AV63Logaccesoswwds_5_tfsecuserid_to) ,
                                              AV65Logaccesoswwds_7_tfsecusername_sel ,
                                              AV64Logaccesoswwds_6_tfsecusername ,
                                              Short.valueOf(AV66Logaccesoswwds_8_tfsecroleid) ,
                                              Short.valueOf(AV67Logaccesoswwds_9_tfsecroleid_to) ,
                                              AV69Logaccesoswwds_11_tfsecroledescription_sel ,
                                              AV68Logaccesoswwds_10_tfsecroledescription ,
                                              Integer.valueOf(AV72Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                              AV73Logaccesoswwds_15_tflogaccesosfecha ,
                                              AV74Logaccesoswwds_16_tflogaccesosfecha_to ,
                                              Short.valueOf(A41LogAccesosId) ,
                                              Short.valueOf(A6SecUserId) ,
                                              A14SecUserName ,
                                              Short.valueOf(A4SecRoleId) ,
                                              A12SecRoleDescription ,
                                              A228LogAccesosFecha ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              AV59Logaccesoswwds_1_filterfulltext ,
                                              A172LogAccesosFullName ,
                                              AV71Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                              AV70Logaccesoswwds_12_tflogaccesosfullname } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV64Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV64Logaccesoswwds_6_tfsecusername), "%", "") ;
         lV68Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV68Logaccesoswwds_10_tfsecroledescription), "%", "") ;
         /* Using cursor H00223 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV60Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV61Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV62Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV63Logaccesoswwds_5_tfsecuserid_to), lV64Logaccesoswwds_6_tfsecusername, AV65Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV66Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV67Logaccesoswwds_9_tfsecroleid_to), lV68Logaccesoswwds_10_tfsecroledescription, AV69Logaccesoswwds_11_tfsecroledescription_sel, AV73Logaccesoswwds_15_tflogaccesosfecha, AV74Logaccesoswwds_16_tflogaccesosfecha_to});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         GRID_nEOF = (byte)(0) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         while ( ( (pr_default.getStatus(1) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A228LogAccesosFecha = H00223_A228LogAccesosFecha[0] ;
            A227LogAccesosTipo = H00223_A227LogAccesosTipo[0] ;
            A12SecRoleDescription = H00223_A12SecRoleDescription[0] ;
            A6SecUserId = H00223_A6SecUserId[0] ;
            A41LogAccesosId = H00223_A41LogAccesosId[0] ;
            A14SecUserName = H00223_A14SecUserName[0] ;
            A4SecRoleId = H00223_A4SecRoleId[0] ;
            A14SecUserName = H00223_A14SecUserName[0] ;
            A12SecRoleDescription = H00223_A12SecRoleDescription[0] ;
            GXt_char1 = A172LogAccesosFullName ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char2) ;
            logaccesosww_impl.this.GXt_char1 = GXv_char2[0] ;
            A172LogAccesosFullName = GXt_char1 ;
            if ( (GXutil.strcmp("", AV59Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV59Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV59Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
            {
               if ( ! ( (GXutil.strcmp("", AV71Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV70Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV70Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
               {
                  if ( (GXutil.strcmp("", AV71Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV71Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
                  {
                     e21222 ();
                  }
               }
            }
            pr_default.readNext(1);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(1) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(1);
         wbEnd = (short)(43) ;
         wb220( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes222( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV75Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV51IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV51IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV52IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SECUSERNAME", AV53IsAuthorized_SecUserName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SECUSERNAME", getSecureSignedToken( "", AV53IsAuthorized_SecUserName));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_LOGACCESOSID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9")));
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
      return (int)(subgridclient_rec_count_fnc()) ;
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
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFLogAccesosId, AV28TFLogAccesosId_To, AV29TFSecUserId, AV30TFSecUserId_To, AV31TFSecUserName, AV32TFSecUserName_Sel, AV33TFSecRoleId, AV34TFSecRoleId_To, AV35TFSecRoleDescription, AV36TFSecRoleDescription_Sel, AV37TFLogAccesosFullName, AV38TFLogAccesosFullName_Sel, AV40TFLogAccesosTipo_Sels, AV41TFLogAccesosFecha, AV42TFLogAccesosFecha_To, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV51IsAuthorized_Update, AV52IsAuthorized_Delete, AV53IsAuthorized_SecUserName) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
      if ( GRID_nEOF == 0 )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFLogAccesosId, AV28TFLogAccesosId_To, AV29TFSecUserId, AV30TFSecUserId_To, AV31TFSecUserName, AV32TFSecUserName_Sel, AV33TFSecRoleId, AV34TFSecRoleId_To, AV35TFSecRoleDescription, AV36TFSecRoleDescription_Sel, AV37TFLogAccesosFullName, AV38TFLogAccesosFullName_Sel, AV40TFLogAccesosTipo_Sels, AV41TFLogAccesosFecha, AV42TFLogAccesosFecha_To, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV51IsAuthorized_Update, AV52IsAuthorized_Delete, AV53IsAuthorized_SecUserName) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFLogAccesosId, AV28TFLogAccesosId_To, AV29TFSecUserId, AV30TFSecUserId_To, AV31TFSecUserName, AV32TFSecUserName_Sel, AV33TFSecRoleId, AV34TFSecRoleId_To, AV35TFSecRoleDescription, AV36TFSecRoleDescription_Sel, AV37TFLogAccesosFullName, AV38TFLogAccesosFullName_Sel, AV40TFLogAccesosTipo_Sels, AV41TFLogAccesosFecha, AV42TFLogAccesosFecha_To, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV51IsAuthorized_Update, AV52IsAuthorized_Delete, AV53IsAuthorized_SecUserName) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFLogAccesosId, AV28TFLogAccesosId_To, AV29TFSecUserId, AV30TFSecUserId_To, AV31TFSecUserName, AV32TFSecUserName_Sel, AV33TFSecRoleId, AV34TFSecRoleId_To, AV35TFSecRoleDescription, AV36TFSecRoleDescription_Sel, AV37TFLogAccesosFullName, AV38TFLogAccesosFullName_Sel, AV40TFLogAccesosTipo_Sels, AV41TFLogAccesosFecha, AV42TFLogAccesosFecha_To, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV51IsAuthorized_Update, AV52IsAuthorized_Delete, AV53IsAuthorized_SecUserName) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFLogAccesosId, AV28TFLogAccesosId_To, AV29TFSecUserId, AV30TFSecUserId_To, AV31TFSecUserName, AV32TFSecUserName_Sel, AV33TFSecRoleId, AV34TFSecRoleId_To, AV35TFSecRoleDescription, AV36TFSecRoleDescription_Sel, AV37TFLogAccesosFullName, AV38TFLogAccesosFullName_Sel, AV40TFLogAccesosTipo_Sels, AV41TFLogAccesosFecha, AV42TFLogAccesosFecha_To, AV75Pgmname, AV13OrderedBy, AV14OrderedDsc, AV51IsAuthorized_Update, AV52IsAuthorized_Delete, AV53IsAuthorized_SecUserName) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV75Pgmname = "LogAccesosWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup220( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19222 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV46DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV48GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV49GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV43DDO_LogAccesosFechaAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_LOGACCESOSFECHAAUXDATE"), 0) ;
         AV44DDO_LogAccesosFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_LOGACCESOSFECHAAUXDATETO"), 0) ;
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
         AV45DDO_LogAccesosFechaAuxDateText = httpContext.cgiGet( edtavDdo_logaccesosfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45DDO_LogAccesosFechaAuxDateText", AV45DDO_LogAccesosFechaAuxDateText);
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
      e19222 ();
      if (returnInSub) return;
   }

   public void e19222( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFLOGACCESOSFECHA_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_logaccesosfechaauxdatetext_Internalname});
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
      GXt_boolean3 = AV53IsAuthorized_SecUserName ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser", GXv_boolean4) ;
      logaccesosww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV53IsAuthorized_SecUserName = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53IsAuthorized_SecUserName", AV53IsAuthorized_SecUserName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SECUSERNAME", getSecureSignedToken( "", AV53IsAuthorized_SecUserName));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Log Accesos" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV46DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV46DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e20222( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext7[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
      AV6WWPContext = GXv_SdtWWPContext7[0] ;
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
      if ( GXutil.strcmp(AV23Session.getValue("LogAccesosWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("LogAccesosWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtLogAccesosId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSecUserId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSecUserName_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSecRoleId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecRoleId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSecRoleDescription_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecRoleDescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleDescription_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLogAccesosFullName_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosFullName_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosFullName_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbLogAccesosTipo.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLogAccesosTipo.getInternalname(), "Visible", GXutil.ltrimstr( cmbLogAccesosTipo.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtLogAccesosFecha_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosFecha_Visible), 5, 0), !bGXsfl_43_Refreshing);
      AV48GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48GridCurrentPage), 10, 0));
      AV49GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49GridPageCount), 10, 0));
      AV59Logaccesoswwds_1_filterfulltext = AV16FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV27TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV28TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV29TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV30TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV31TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV32TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV33TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV34TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV35TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV36TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV37TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV38TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV40TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV41TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV42TFLogAccesosFecha_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e12222( )
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
         AV47PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV47PageToGo) ;
      }
   }

   public void e13222( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e14222( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LogAccesosId") == 0 )
         {
            AV27TFLogAccesosId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFLogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLogAccesosId), 4, 0));
            AV28TFLogAccesosId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFLogAccesosId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFLogAccesosId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecUserId") == 0 )
         {
            AV29TFSecUserId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFSecUserId), 4, 0));
            AV30TFSecUserId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFSecUserId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecUserName") == 0 )
         {
            AV31TFSecUserName = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFSecUserName", AV31TFSecUserName);
            AV32TFSecUserName_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFSecUserName_Sel", AV32TFSecUserName_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecRoleId") == 0 )
         {
            AV33TFSecRoleId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFSecRoleId), 4, 0));
            AV34TFSecRoleId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFSecRoleId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFSecRoleId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecRoleDescription") == 0 )
         {
            AV35TFSecRoleDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFSecRoleDescription", AV35TFSecRoleDescription);
            AV36TFSecRoleDescription_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSecRoleDescription_Sel", AV36TFSecRoleDescription_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LogAccesosFullName") == 0 )
         {
            AV37TFLogAccesosFullName = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFLogAccesosFullName", AV37TFLogAccesosFullName);
            AV38TFLogAccesosFullName_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFLogAccesosFullName_Sel", AV38TFLogAccesosFullName_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LogAccesosTipo") == 0 )
         {
            AV39TFLogAccesosTipo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFLogAccesosTipo_SelsJson", AV39TFLogAccesosTipo_SelsJson);
            AV40TFLogAccesosTipo_Sels.fromJSonString(AV39TFLogAccesosTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LogAccesosFecha") == 0 )
         {
            AV41TFLogAccesosFecha = localUtil.ctot( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFLogAccesosFecha", localUtil.ttoc( AV41TFLogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
            AV42TFLogAccesosFecha_To = localUtil.ctot( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFLogAccesosFecha_To", localUtil.ttoc( AV42TFLogAccesosFecha_To, 8, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV42TFLogAccesosFecha_To) )
            {
               AV42TFLogAccesosFecha_To = localUtil.ymdhmsToT( (short)(GXutil.year( AV42TFLogAccesosFecha_To)), (byte)(GXutil.month( AV42TFLogAccesosFecha_To)), (byte)(GXutil.day( AV42TFLogAccesosFecha_To)), (byte)(23), (byte)(59), (byte)(59)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV42TFLogAccesosFecha_To", localUtil.ttoc( AV42TFLogAccesosFecha_To, 8, 5, 0, 3, "/", ":", " "));
            }
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLogAccesosTipo_Sels", AV40TFLogAccesosTipo_Sels);
   }

   private void e21222( )
   {
      if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
      {
         /* Grid_Load Routine */
         returnInSub = false ;
         AV55Update = "<i class=\"fa fa-pen\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV55Update);
         if ( AV51IsAuthorized_Update )
         {
            edtavUpdate_Link = formatLink("com.projectthani.logaccesos", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A41LogAccesosId,4,0))}, new String[] {"Mode","LogAccesosId"})  ;
         }
         AV56Delete = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV56Delete);
         if ( AV52IsAuthorized_Delete )
         {
            edtavDelete_Link = formatLink("com.projectthani.logaccesos", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A41LogAccesosId,4,0))}, new String[] {"Mode","LogAccesosId"})  ;
         }
         if ( AV53IsAuthorized_SecUserName )
         {
            edtSecUserName_Link = formatLink("com.projectthani.wwpbaseobjects.secuserview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A6SecUserId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecUserId","TabCode"})  ;
         }
         edtLogAccesosFullName_Link = formatLink("com.projectthani.logaccesosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A41LogAccesosId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"LogAccesosId","TabCode"})  ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(43) ;
         }
         sendrow_432( ) ;
         GRID_nEOF = (byte)(1) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
         {
            GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
         }
      }
      if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
      {
         GRID_nEOF = (byte)(0) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
      }
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_43_Refreshing )
      {
         httpContext.doAjaxLoad(43, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e15222( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LogAccesosWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e11222( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("LogAccesosWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV75Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("LogAccesosWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char1 = AV25ManageFiltersXml ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "LogAccesosWWFilters", Ddo_managefilters_Activeeventkey, GXv_char2) ;
         logaccesosww_impl.this.GXt_char1 = GXv_char2[0] ;
         AV25ManageFiltersXml = GXt_char1 ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLogAccesosTipo_Sels", AV40TFLogAccesosTipo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e16222( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.logaccesos", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","LogAccesosId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17222( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char2[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.logaccesoswwexport(remoteHandle, context).execute( GXv_char2, GXv_char8) ;
      logaccesosww_impl.this.AV17ExcelFilename = GXv_char2[0] ;
      logaccesosww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLogAccesosTipo_Sels", AV40TFLogAccesosTipo_Sels);
   }

   public void e18222( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.logaccesoswwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFLogAccesosTipo_Sels", AV40TFLogAccesosTipo_Sels);
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
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LogAccesosId", "", "Log Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecUserId", "", "User Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecUserName", "", "User Name", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecRoleId", "", "Role Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecRoleDescription", "", "Role Description", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LogAccesosFullName", "", "Nombres Completos", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LogAccesosTipo", "", "Tipo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LogAccesosFecha", "", "Fecha", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char1 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char1 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LogAccesosWWColumnsSelector", GXv_char8) ;
      logaccesosww_impl.this.GXt_char1 = GXv_char8[0] ;
      AV20UserCustomValue = GXt_char1 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV21ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV51IsAuthorized_Update ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Update", GXv_boolean4) ;
      logaccesosww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV51IsAuthorized_Update = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51IsAuthorized_Update", AV51IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV51IsAuthorized_Update));
      if ( ! ( AV51IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean3 = AV52IsAuthorized_Delete ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Delete", GXv_boolean4) ;
      logaccesosww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV52IsAuthorized_Delete = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52IsAuthorized_Delete", AV52IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      if ( ! ( AV52IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean3 = AV54TempBoolean ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Insert", GXv_boolean4) ;
      logaccesosww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV54TempBoolean = GXt_boolean3 ;
      if ( ! ( AV54TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "LogAccesosWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFLogAccesosId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFLogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLogAccesosId), 4, 0));
      AV28TFLogAccesosId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFLogAccesosId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFLogAccesosId_To), 4, 0));
      AV29TFSecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFSecUserId), 4, 0));
      AV30TFSecUserId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFSecUserId_To), 4, 0));
      AV31TFSecUserName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFSecUserName", AV31TFSecUserName);
      AV32TFSecUserName_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFSecUserName_Sel", AV32TFSecUserName_Sel);
      AV33TFSecRoleId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFSecRoleId), 4, 0));
      AV34TFSecRoleId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFSecRoleId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFSecRoleId_To), 4, 0));
      AV35TFSecRoleDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFSecRoleDescription", AV35TFSecRoleDescription);
      AV36TFSecRoleDescription_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFSecRoleDescription_Sel", AV36TFSecRoleDescription_Sel);
      AV37TFLogAccesosFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFLogAccesosFullName", AV37TFLogAccesosFullName);
      AV38TFLogAccesosFullName_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFLogAccesosFullName_Sel", AV38TFLogAccesosFullName_Sel);
      AV40TFLogAccesosTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41TFLogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFLogAccesosFecha", localUtil.ttoc( AV41TFLogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
      AV42TFLogAccesosFecha_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFLogAccesosFecha_To", localUtil.ttoc( AV42TFLogAccesosFecha_To, 8, 5, 0, 3, "/", ":", " "));
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
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSID") == 0 )
         {
            AV27TFLogAccesosId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFLogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLogAccesosId), 4, 0));
            AV28TFLogAccesosId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFLogAccesosId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFLogAccesosId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV29TFSecUserId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFSecUserId), 4, 0));
            AV30TFSecUserId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFSecUserId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV31TFSecUserName = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFSecUserName", AV31TFSecUserName);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV32TFSecUserName_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFSecUserName_Sel", AV32TFSecUserName_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEID") == 0 )
         {
            AV33TFSecRoleId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFSecRoleId), 4, 0));
            AV34TFSecRoleId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFSecRoleId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFSecRoleId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV35TFSecRoleDescription = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFSecRoleDescription", AV35TFSecRoleDescription);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV36TFSecRoleDescription_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSecRoleDescription_Sel", AV36TFSecRoleDescription_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME") == 0 )
         {
            AV37TFLogAccesosFullName = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFLogAccesosFullName", AV37TFLogAccesosFullName);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME_SEL") == 0 )
         {
            AV38TFLogAccesosFullName_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFLogAccesosFullName_Sel", AV38TFLogAccesosFullName_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSTIPO_SEL") == 0 )
         {
            AV39TFLogAccesosTipo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFLogAccesosTipo_SelsJson", AV39TFLogAccesosTipo_SelsJson);
            AV40TFLogAccesosTipo_Sels.fromJSonString(AV39TFLogAccesosTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFECHA") == 0 )
         {
            AV41TFLogAccesosFecha = localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFLogAccesosFecha", localUtil.ttoc( AV41TFLogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
            AV42TFLogAccesosFecha_To = localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFLogAccesosFecha_To", localUtil.ttoc( AV42TFLogAccesosFecha_To, 8, 5, 0, 3, "/", ":", " "));
            AV43DDO_LogAccesosFechaAuxDate = GXutil.resetTime(AV41TFLogAccesosFecha) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43DDO_LogAccesosFechaAuxDate", localUtil.format(AV43DDO_LogAccesosFechaAuxDate, "99/99/99"));
            AV44DDO_LogAccesosFechaAuxDateTo = GXutil.resetTime(AV42TFLogAccesosFecha_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44DDO_LogAccesosFechaAuxDateTo", localUtil.format(AV44DDO_LogAccesosFechaAuxDateTo, "99/99/99"));
         }
         AV76GXV1 = (int)(AV76GXV1+1) ;
      }
      GXt_char1 = "" ;
      GXv_char8[0] = GXt_char1 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFSecUserName_Sel)==0), AV32TFSecUserName_Sel, GXv_char8) ;
      logaccesosww_impl.this.GXt_char1 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char2[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFSecRoleDescription_Sel)==0), AV36TFSecRoleDescription_Sel, GXv_char2) ;
      logaccesosww_impl.this.GXt_char13 = GXv_char2[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFLogAccesosFullName_Sel)==0), AV38TFLogAccesosFullName_Sel, GXv_char15) ;
      logaccesosww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV40TFLogAccesosTipo_Sels.size()==0), AV39TFLogAccesosTipo_SelsJson, GXv_char17) ;
      logaccesosww_impl.this.GXt_char16 = GXv_char17[0] ;
      Ddo_grid_Selectedvalue_set = "||"+GXt_char1+"||"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFSecUserName)==0), AV31TFSecUserName, GXv_char17) ;
      logaccesosww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFSecRoleDescription)==0), AV35TFSecRoleDescription, GXv_char15) ;
      logaccesosww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char8[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFLogAccesosFullName)==0), AV37TFLogAccesosFullName, GXv_char8) ;
      logaccesosww_impl.this.GXt_char13 = GXv_char8[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFLogAccesosId) ? "" : GXutil.str( AV27TFLogAccesosId, 4, 0))+"|"+((0==AV29TFSecUserId) ? "" : GXutil.str( AV29TFSecUserId, 4, 0))+"|"+GXt_char16+"|"+((0==AV33TFSecRoleId) ? "" : GXutil.str( AV33TFSecRoleId, 4, 0))+"|"+GXt_char14+"|"+GXt_char13+"||"+(GXutil.dateCompare(GXutil.nullDate(), AV41TFLogAccesosFecha) ? "" : localUtil.dtoc( AV43DDO_LogAccesosFechaAuxDate, 3, "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFLogAccesosId_To) ? "" : GXutil.str( AV28TFLogAccesosId_To, 4, 0))+"|"+((0==AV30TFSecUserId_To) ? "" : GXutil.str( AV30TFSecUserId_To, 4, 0))+"||"+((0==AV34TFSecRoleId_To) ? "" : GXutil.str( AV34TFSecRoleId_To, 4, 0))+"||||"+(GXutil.dateCompare(GXutil.nullDate(), AV42TFLogAccesosFecha_To) ? "" : localUtil.dtoc( AV44DDO_LogAccesosFechaAuxDateTo, 3, "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV75Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFLOGACCESOSID", !((0==AV27TFLogAccesosId)&&(0==AV28TFLogAccesosId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFLogAccesosId, 4, 0)), GXutil.trim( GXutil.str( AV28TFLogAccesosId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFSECUSERID", !((0==AV29TFSecUserId)&&(0==AV30TFSecUserId_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFSecUserId, 4, 0)), GXutil.trim( GXutil.str( AV30TFSecUserId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFSECUSERNAME", !(GXutil.strcmp("", AV31TFSecUserName)==0), (short)(0), AV31TFSecUserName, "", !(GXutil.strcmp("", AV32TFSecUserName_Sel)==0), AV32TFSecUserName_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFSECROLEID", !((0==AV33TFSecRoleId)&&(0==AV34TFSecRoleId_To)), (short)(0), GXutil.trim( GXutil.str( AV33TFSecRoleId, 4, 0)), GXutil.trim( GXutil.str( AV34TFSecRoleId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFSECROLEDESCRIPTION", !(GXutil.strcmp("", AV35TFSecRoleDescription)==0), (short)(0), AV35TFSecRoleDescription, "", !(GXutil.strcmp("", AV36TFSecRoleDescription_Sel)==0), AV36TFSecRoleDescription_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFLOGACCESOSFULLNAME", !(GXutil.strcmp("", AV37TFLogAccesosFullName)==0), (short)(0), AV37TFLogAccesosFullName, "", !(GXutil.strcmp("", AV38TFLogAccesosFullName_Sel)==0), AV38TFLogAccesosFullName_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFLOGACCESOSTIPO_SEL", !(AV40TFLogAccesosTipo_Sels.size()==0), (short)(0), AV40TFLogAccesosTipo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFLOGACCESOSFECHA", !(GXutil.dateCompare(GXutil.nullDate(), AV41TFLogAccesosFecha)&&GXutil.dateCompare(GXutil.nullDate(), AV42TFLogAccesosFecha_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV41TFLogAccesosFecha, 8, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV42TFLogAccesosFecha_To, 8, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
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
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LogAccesos" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_222( boolean wbgen )
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
         wb_table2_30_222( true) ;
      }
      else
      {
         wb_table2_30_222( false) ;
      }
      return  ;
   }

   public void wb_table2_30_222e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_222e( true) ;
      }
      else
      {
         wb_table1_25_222e( false) ;
      }
   }

   public void wb_table2_30_222( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_LogAccesosWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_222e( true) ;
      }
      else
      {
         wb_table2_30_222e( false) ;
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
      pa222( ) ;
      ws222( ) ;
      we222( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110333151", true, true);
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
      httpContext.AddJavascriptSource("logaccesosww.js", "?20225110333151", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_idx ;
      edtLogAccesosId_Internalname = "LOGACCESOSID_"+sGXsfl_43_idx ;
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_43_idx ;
      edtSecUserName_Internalname = "SECUSERNAME_"+sGXsfl_43_idx ;
      edtSecRoleId_Internalname = "SECROLEID_"+sGXsfl_43_idx ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION_"+sGXsfl_43_idx ;
      edtLogAccesosFullName_Internalname = "LOGACCESOSFULLNAME_"+sGXsfl_43_idx ;
      cmbLogAccesosTipo.setInternalname( "LOGACCESOSTIPO_"+sGXsfl_43_idx );
      edtLogAccesosFecha_Internalname = "LOGACCESOSFECHA_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtLogAccesosId_Internalname = "LOGACCESOSID_"+sGXsfl_43_fel_idx ;
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_43_fel_idx ;
      edtSecUserName_Internalname = "SECUSERNAME_"+sGXsfl_43_fel_idx ;
      edtSecRoleId_Internalname = "SECROLEID_"+sGXsfl_43_fel_idx ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION_"+sGXsfl_43_fel_idx ;
      edtLogAccesosFullName_Internalname = "LOGACCESOSFULLNAME_"+sGXsfl_43_fel_idx ;
      cmbLogAccesosTipo.setInternalname( "LOGACCESOSTIPO_"+sGXsfl_43_fel_idx );
      edtLogAccesosFecha_Internalname = "LOGACCESOSFECHA_"+sGXsfl_43_fel_idx ;
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb220( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV55Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV56Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLogAccesosId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLogAccesosId_Internalname,GXutil.ltrim( localUtil.ntoc( A41LogAccesosId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLogAccesosId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLogAccesosId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSecUserId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserId_Internalname,GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecUserId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecUserId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecUserName_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserName_Internalname,A14SecUserName,"","","'"+""+"'"+",false,"+"'"+""+"'",edtSecUserName_Link,"","","",edtSecUserName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecUserName_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSecRoleId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecRoleId_Internalname,GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecRoleId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecRoleId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecRoleDescription_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecRoleDescription_Internalname,A12SecRoleDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecRoleDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecRoleDescription_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(120),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLogAccesosFullName_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLogAccesosFullName_Internalname,A172LogAccesosFullName,"","","'"+""+"'"+",false,"+"'"+""+"'",edtLogAccesosFullName_Link,"","","",edtLogAccesosFullName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLogAccesosFullName_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLogAccesosTipo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLogAccesosTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LOGACCESOSTIPO_" + sGXsfl_43_idx ;
            cmbLogAccesosTipo.setName( GXCCtl );
            cmbLogAccesosTipo.setWebtags( "" );
            cmbLogAccesosTipo.addItem("I", "Ingreso", (short)(0));
            cmbLogAccesosTipo.addItem("S", "Salida", (short)(0));
            if ( cmbLogAccesosTipo.getItemCount() > 0 )
            {
               A227LogAccesosTipo = cmbLogAccesosTipo.getValidValue(A227LogAccesosTipo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLogAccesosTipo,cmbLogAccesosTipo.getInternalname(),GXutil.rtrim( A227LogAccesosTipo),Integer.valueOf(1),cmbLogAccesosTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLogAccesosTipo.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbLogAccesosTipo.setValue( GXutil.rtrim( A227LogAccesosTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLogAccesosTipo.getInternalname(), "Values", cmbLogAccesosTipo.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLogAccesosFecha_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLogAccesosFecha_Internalname,localUtil.ttoc( A228LogAccesosFecha, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A228LogAccesosFecha, "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLogAccesosFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLogAccesosFecha_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes222( ) ;
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
      edtLogAccesosId_Internalname = "LOGACCESOSID" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      edtSecUserName_Internalname = "SECUSERNAME" ;
      edtSecRoleId_Internalname = "SECROLEID" ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION" ;
      edtLogAccesosFullName_Internalname = "LOGACCESOSFULLNAME" ;
      cmbLogAccesosTipo.setInternalname( "LOGACCESOSTIPO" );
      edtLogAccesosFecha_Internalname = "LOGACCESOSFECHA" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_logaccesosfechaauxdatetext_Internalname = "vDDO_LOGACCESOSFECHAAUXDATETEXT" ;
      Tflogaccesosfecha_rangepicker_Internalname = "TFLOGACCESOSFECHA_RANGEPICKER" ;
      divDdo_logaccesosfechaauxdates_Internalname = "DDO_LOGACCESOSFECHAAUXDATES" ;
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
      edtLogAccesosFecha_Jsonclick = "" ;
      cmbLogAccesosTipo.setJsonclick( "" );
      edtLogAccesosFullName_Jsonclick = "" ;
      edtSecRoleDescription_Jsonclick = "" ;
      edtSecRoleId_Jsonclick = "" ;
      edtSecUserName_Jsonclick = "" ;
      edtSecUserId_Jsonclick = "" ;
      edtLogAccesosId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_logaccesosfechaauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtLogAccesosFullName_Link = "" ;
      edtSecUserName_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtLogAccesosFecha_Visible = -1 ;
      cmbLogAccesosTipo.setVisible( -1 );
      edtLogAccesosFullName_Visible = -1 ;
      edtSecRoleDescription_Visible = -1 ;
      edtSecRoleId_Visible = -1 ;
      edtSecUserName_Visible = -1 ;
      edtSecUserId_Visible = -1 ;
      edtLogAccesosId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Log Accesos" );
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
      Ddo_grid_Datalistproc = "LogAccesosWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||I:Ingreso,S:Salida|" ;
      Ddo_grid_Allowmultipleselection = "||||||T|" ;
      Ddo_grid_Datalisttype = "||Dynamic||Dynamic|Dynamic|FixedValues|" ;
      Ddo_grid_Includedatalist = "||T||T|T|T|" ;
      Ddo_grid_Filterisrange = "T|T||T||||P" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Character|Numeric|Character|Character||Date" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T||T|T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5||6|7" ;
      Ddo_grid_Columnids = "2:LogAccesosId|3:SecUserId|4:SecUserName|5:SecRoleId|6:SecRoleDescription|7:LogAccesosFullName|8:LogAccesosTipo|9:LogAccesosFecha" ;
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
      GXCCtl = "LOGACCESOSTIPO_" + sGXsfl_43_idx ;
      cmbLogAccesosTipo.setName( GXCCtl );
      cmbLogAccesosTipo.setWebtags( "" );
      cmbLogAccesosTipo.addItem("I", "Ingreso", (short)(0));
      cmbLogAccesosTipo.addItem("S", "Salida", (short)(0));
      if ( cmbLogAccesosTipo.getItemCount() > 0 )
      {
         A227LogAccesosTipo = cmbLogAccesosTipo.getValidValue(A227LogAccesosTipo) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLogAccesosId_Visible',ctrl:'LOGACCESOSID',prop:'Visible'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtSecUserName_Visible',ctrl:'SECUSERNAME',prop:'Visible'},{av:'edtSecRoleId_Visible',ctrl:'SECROLEID',prop:'Visible'},{av:'edtSecRoleDescription_Visible',ctrl:'SECROLEDESCRIPTION',prop:'Visible'},{av:'edtLogAccesosFullName_Visible',ctrl:'LOGACCESOSFULLNAME',prop:'Visible'},{av:'cmbLogAccesosTipo'},{av:'edtLogAccesosFecha_Visible',ctrl:'LOGACCESOSFECHA',prop:'Visible'},{av:'AV48GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV49GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12222',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13222',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e14222',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21222',iparms:[{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A41LogAccesosId',fld:'LOGACCESOSID',pic:'ZZZ9',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV55Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV56Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtSecUserName_Link',ctrl:'SECUSERNAME',prop:'Link'},{av:'edtLogAccesosFullName_Link',ctrl:'LOGACCESOSFULLNAME',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e15222',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLogAccesosId_Visible',ctrl:'LOGACCESOSID',prop:'Visible'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtSecUserName_Visible',ctrl:'SECUSERNAME',prop:'Visible'},{av:'edtSecRoleId_Visible',ctrl:'SECROLEID',prop:'Visible'},{av:'edtSecRoleDescription_Visible',ctrl:'SECROLEDESCRIPTION',prop:'Visible'},{av:'edtLogAccesosFullName_Visible',ctrl:'LOGACCESOSFULLNAME',prop:'Visible'},{av:'cmbLogAccesosTipo'},{av:'edtLogAccesosFecha_Visible',ctrl:'LOGACCESOSFECHA',prop:'Visible'},{av:'AV48GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV49GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11222',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'AV43DDO_LogAccesosFechaAuxDate',fld:'vDDO_LOGACCESOSFECHAAUXDATE',pic:''},{av:'AV44DDO_LogAccesosFechaAuxDateTo',fld:'vDDO_LOGACCESOSFECHAAUXDATETO',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV43DDO_LogAccesosFechaAuxDate',fld:'vDDO_LOGACCESOSFECHAAUXDATE',pic:''},{av:'AV44DDO_LogAccesosFechaAuxDateTo',fld:'vDDO_LOGACCESOSFECHAAUXDATETO',pic:''},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLogAccesosId_Visible',ctrl:'LOGACCESOSID',prop:'Visible'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtSecUserName_Visible',ctrl:'SECUSERNAME',prop:'Visible'},{av:'edtSecRoleId_Visible',ctrl:'SECROLEID',prop:'Visible'},{av:'edtSecRoleDescription_Visible',ctrl:'SECROLEDESCRIPTION',prop:'Visible'},{av:'edtLogAccesosFullName_Visible',ctrl:'LOGACCESOSFULLNAME',prop:'Visible'},{av:'cmbLogAccesosTipo'},{av:'edtLogAccesosFecha_Visible',ctrl:'LOGACCESOSFECHA',prop:'Visible'},{av:'AV48GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV49GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16222',iparms:[{av:'A41LogAccesosId',fld:'LOGACCESOSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17222',iparms:[{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV43DDO_LogAccesosFechaAuxDate',fld:'vDDO_LOGACCESOSFECHAAUXDATE',pic:''},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV44DDO_LogAccesosFechaAuxDateTo',fld:'vDDO_LOGACCESOSFECHAAUXDATETO',pic:''}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV43DDO_LogAccesosFechaAuxDate',fld:'vDDO_LOGACCESOSFECHAAUXDATE',pic:''},{av:'AV44DDO_LogAccesosFechaAuxDateTo',fld:'vDDO_LOGACCESOSFECHAAUXDATETO',pic:''},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e18222',iparms:[{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV43DDO_LogAccesosFechaAuxDate',fld:'vDDO_LOGACCESOSFECHAAUXDATE',pic:''},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV44DDO_LogAccesosFechaAuxDateTo',fld:'vDDO_LOGACCESOSFECHAAUXDATETO',pic:''}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFLogAccesosId',fld:'vTFLOGACCESOSID',pic:'ZZZ9'},{av:'AV28TFLogAccesosId_To',fld:'vTFLOGACCESOSID_TO',pic:'ZZZ9'},{av:'AV29TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV30TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV31TFSecUserName',fld:'vTFSECUSERNAME',pic:''},{av:'AV32TFSecUserName_Sel',fld:'vTFSECUSERNAME_SEL',pic:''},{av:'AV33TFSecRoleId',fld:'vTFSECROLEID',pic:'ZZZ9'},{av:'AV34TFSecRoleId_To',fld:'vTFSECROLEID_TO',pic:'ZZZ9'},{av:'AV35TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV36TFSecRoleDescription_Sel',fld:'vTFSECROLEDESCRIPTION_SEL',pic:''},{av:'AV37TFLogAccesosFullName',fld:'vTFLOGACCESOSFULLNAME',pic:''},{av:'AV38TFLogAccesosFullName_Sel',fld:'vTFLOGACCESOSFULLNAME_SEL',pic:''},{av:'AV40TFLogAccesosTipo_Sels',fld:'vTFLOGACCESOSTIPO_SELS',pic:''},{av:'AV41TFLogAccesosFecha',fld:'vTFLOGACCESOSFECHA',pic:'99/99/99 99:99'},{av:'AV42TFLogAccesosFecha_To',fld:'vTFLOGACCESOSFECHA_TO',pic:'99/99/99 99:99'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV53IsAuthorized_SecUserName',fld:'vISAUTHORIZED_SECUSERNAME',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV43DDO_LogAccesosFechaAuxDate',fld:'vDDO_LOGACCESOSFECHAAUXDATE',pic:''},{av:'AV44DDO_LogAccesosFechaAuxDateTo',fld:'vDDO_LOGACCESOSFECHAAUXDATETO',pic:''},{av:'AV39TFLogAccesosTipo_SelsJson',fld:'vTFLOGACCESOSTIPO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_LOGACCESOSID","{handler:'valid_Logaccesosid',iparms:[]");
      setEventMetadata("VALID_LOGACCESOSID",",oparms:[]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[]");
      setEventMetadata("VALID_SECUSERID",",oparms:[]}");
      setEventMetadata("VALID_SECUSERNAME","{handler:'valid_Secusername',iparms:[]");
      setEventMetadata("VALID_SECUSERNAME",",oparms:[]}");
      setEventMetadata("VALID_SECROLEID","{handler:'valid_Secroleid',iparms:[]");
      setEventMetadata("VALID_SECROLEID",",oparms:[]}");
      setEventMetadata("VALID_SECROLEDESCRIPTION","{handler:'valid_Secroledescription',iparms:[]");
      setEventMetadata("VALID_SECROLEDESCRIPTION",",oparms:[]}");
      setEventMetadata("VALID_LOGACCESOSFULLNAME","{handler:'valid_Logaccesosfullname',iparms:[]");
      setEventMetadata("VALID_LOGACCESOSFULLNAME",",oparms:[]}");
      setEventMetadata("VALID_LOGACCESOSTIPO","{handler:'valid_Logaccesostipo',iparms:[]");
      setEventMetadata("VALID_LOGACCESOSTIPO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Logaccesosfecha',iparms:[]");
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
      AV21ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV16FilterFullText = "" ;
      AV31TFSecUserName = "" ;
      AV32TFSecUserName_Sel = "" ;
      AV35TFSecRoleDescription = "" ;
      AV36TFSecRoleDescription_Sel = "" ;
      AV37TFLogAccesosFullName = "" ;
      AV38TFLogAccesosFullName_Sel = "" ;
      AV40TFLogAccesosTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFLogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      AV42TFLogAccesosFecha_To = GXutil.resetTime( GXutil.nullDate() );
      AV75Pgmname = "" ;
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
      AV46DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV44DDO_LogAccesosFechaAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV39TFLogAccesosTipo_SelsJson = "" ;
      AV43DDO_LogAccesosFechaAuxDate = GXutil.nullDate() ;
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
      AV55Update = "" ;
      AV56Delete = "" ;
      A14SecUserName = "" ;
      A12SecRoleDescription = "" ;
      A172LogAccesosFullName = "" ;
      A227LogAccesosTipo = "" ;
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV45DDO_LogAccesosFechaAuxDateText = "" ;
      ucTflogaccesosfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV59Logaccesoswwds_1_filterfulltext = "" ;
      AV64Logaccesoswwds_6_tfsecusername = "" ;
      AV65Logaccesoswwds_7_tfsecusername_sel = "" ;
      AV68Logaccesoswwds_10_tfsecroledescription = "" ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = "" ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = "" ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = "" ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Logaccesoswwds_15_tflogaccesosfecha = GXutil.resetTime( GXutil.nullDate() );
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      lV59Logaccesoswwds_1_filterfulltext = "" ;
      lV64Logaccesoswwds_6_tfsecusername = "" ;
      lV68Logaccesoswwds_10_tfsecroledescription = "" ;
      H00222_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00222_A227LogAccesosTipo = new String[] {""} ;
      H00222_A12SecRoleDescription = new String[] {""} ;
      H00222_A6SecUserId = new short[1] ;
      H00222_A41LogAccesosId = new short[1] ;
      H00222_A14SecUserName = new String[] {""} ;
      H00222_A4SecRoleId = new short[1] ;
      H00223_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00223_A227LogAccesosTipo = new String[] {""} ;
      H00223_A12SecRoleDescription = new String[] {""} ;
      H00223_A6SecUserId = new short[1] ;
      H00223_A41LogAccesosId = new short[1] ;
      H00223_A14SecUserName = new String[] {""} ;
      H00223_A4SecRoleId = new short[1] ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV25ManageFiltersXml = "" ;
      AV17ExcelFilename = "" ;
      AV18ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char8 = new String[1] ;
      GXv_SdtWWPGridState18 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesosww__default(),
         new Object[] {
             new Object[] {
            H00222_A228LogAccesosFecha, H00222_A227LogAccesosTipo, H00222_A12SecRoleDescription, H00222_A6SecUserId, H00222_A41LogAccesosId, H00222_A14SecUserName, H00222_A4SecRoleId
            }
            , new Object[] {
            H00223_A228LogAccesosFecha, H00223_A227LogAccesosTipo, H00223_A12SecRoleDescription, H00223_A6SecUserId, H00223_A41LogAccesosId, H00223_A14SecUserName, H00223_A4SecRoleId
            }
         }
      );
      AV75Pgmname = "LogAccesosWW" ;
      /* GeneXus formulas. */
      AV75Pgmname = "LogAccesosWW" ;
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
   private short AV27TFLogAccesosId ;
   private short AV28TFLogAccesosId_To ;
   private short AV29TFSecUserId ;
   private short AV30TFSecUserId_To ;
   private short AV33TFSecRoleId ;
   private short AV34TFSecRoleId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A41LogAccesosId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV60Logaccesoswwds_2_tflogaccesosid ;
   private short AV61Logaccesoswwds_3_tflogaccesosid_to ;
   private short AV62Logaccesoswwds_4_tfsecuserid ;
   private short AV63Logaccesoswwds_5_tfsecuserid_to ;
   private short AV66Logaccesoswwds_8_tfsecroleid ;
   private short AV67Logaccesoswwds_9_tfsecroleid_to ;
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
   private int edtLogAccesosId_Visible ;
   private int edtSecUserId_Visible ;
   private int edtSecUserName_Visible ;
   private int edtSecRoleId_Visible ;
   private int edtSecRoleDescription_Visible ;
   private int edtLogAccesosFullName_Visible ;
   private int edtLogAccesosFecha_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int AV72Logaccesoswwds_14_tflogaccesostipo_sels_size ;
   private int AV47PageToGo ;
   private int AV76GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV48GridCurrentPage ;
   private long AV49GridPageCount ;
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
   private String AV55Update ;
   private String edtavUpdate_Link ;
   private String AV56Delete ;
   private String edtavDelete_Link ;
   private String edtSecUserName_Link ;
   private String edtLogAccesosFullName_Link ;
   private String A227LogAccesosTipo ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_logaccesosfechaauxdates_Internalname ;
   private String edtavDdo_logaccesosfechaauxdatetext_Internalname ;
   private String edtavDdo_logaccesosfechaauxdatetext_Jsonclick ;
   private String Tflogaccesosfecha_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtLogAccesosId_Internalname ;
   private String edtSecUserId_Internalname ;
   private String edtSecUserName_Internalname ;
   private String edtSecRoleId_Internalname ;
   private String edtSecRoleDescription_Internalname ;
   private String edtLogAccesosFullName_Internalname ;
   private String edtLogAccesosFecha_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char13 ;
   private String GXv_char8[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtLogAccesosId_Jsonclick ;
   private String edtSecUserId_Jsonclick ;
   private String edtSecUserName_Jsonclick ;
   private String edtSecRoleId_Jsonclick ;
   private String edtSecRoleDescription_Jsonclick ;
   private String edtLogAccesosFullName_Jsonclick ;
   private String GXCCtl ;
   private String edtLogAccesosFecha_Jsonclick ;
   private java.util.Date AV41TFLogAccesosFecha ;
   private java.util.Date AV42TFLogAccesosFecha_To ;
   private java.util.Date A228LogAccesosFecha ;
   private java.util.Date AV73Logaccesoswwds_15_tflogaccesosfecha ;
   private java.util.Date AV74Logaccesoswwds_16_tflogaccesosfecha_to ;
   private java.util.Date AV44DDO_LogAccesosFechaAuxDateTo ;
   private java.util.Date AV43DDO_LogAccesosFechaAuxDate ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV51IsAuthorized_Update ;
   private boolean AV52IsAuthorized_Delete ;
   private boolean AV53IsAuthorized_SecUserName ;
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
   private boolean AV54TempBoolean ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private String AV39TFLogAccesosTipo_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV31TFSecUserName ;
   private String AV32TFSecUserName_Sel ;
   private String AV35TFSecRoleDescription ;
   private String AV36TFSecRoleDescription_Sel ;
   private String AV37TFLogAccesosFullName ;
   private String AV38TFLogAccesosFullName_Sel ;
   private String A14SecUserName ;
   private String A12SecRoleDescription ;
   private String A172LogAccesosFullName ;
   private String AV45DDO_LogAccesosFechaAuxDateText ;
   private String AV59Logaccesoswwds_1_filterfulltext ;
   private String AV64Logaccesoswwds_6_tfsecusername ;
   private String AV65Logaccesoswwds_7_tfsecusername_sel ;
   private String AV68Logaccesoswwds_10_tfsecroledescription ;
   private String AV69Logaccesoswwds_11_tfsecroledescription_sel ;
   private String AV70Logaccesoswwds_12_tflogaccesosfullname ;
   private String AV71Logaccesoswwds_13_tflogaccesosfullname_sel ;
   private String lV59Logaccesoswwds_1_filterfulltext ;
   private String lV64Logaccesoswwds_6_tfsecusername ;
   private String lV68Logaccesoswwds_10_tfsecroledescription ;
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
   private com.genexus.webpanels.GXUserControl ucTflogaccesosfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private HTMLChoice cmbLogAccesosTipo ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] H00222_A228LogAccesosFecha ;
   private String[] H00222_A227LogAccesosTipo ;
   private String[] H00222_A12SecRoleDescription ;
   private short[] H00222_A6SecUserId ;
   private short[] H00222_A41LogAccesosId ;
   private String[] H00222_A14SecUserName ;
   private short[] H00222_A4SecRoleId ;
   private java.util.Date[] H00223_A228LogAccesosFecha ;
   private String[] H00223_A227LogAccesosTipo ;
   private String[] H00223_A12SecRoleDescription ;
   private short[] H00223_A6SecUserId ;
   private short[] H00223_A41LogAccesosId ;
   private String[] H00223_A14SecUserName ;
   private short[] H00223_A4SecRoleId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV40TFLogAccesosTipo_Sels ;
   private GXSimpleCollection<String> AV72Logaccesoswwds_14_tflogaccesostipo_sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV46DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
}

final  class logaccesosww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00222( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV72Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV60Logaccesoswwds_2_tflogaccesosid ,
                                          short AV61Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV62Logaccesoswwds_4_tfsecuserid ,
                                          short AV63Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV65Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV64Logaccesoswwds_6_tfsecusername ,
                                          short AV66Logaccesoswwds_8_tfsecroleid ,
                                          short AV67Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV69Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV68Logaccesoswwds_10_tfsecroledescription ,
                                          int AV72Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV73Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV74Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV59Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV71Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV70Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[12];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT T1.[LogAccesosFecha], T1.[LogAccesosTipo], T3.[SecRoleDescription], T1.[SecUserId], T1.[LogAccesosId], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV60Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
      }
      if ( ! (0==AV61Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int19[1] = (byte)(1) ;
      }
      if ( ! (0==AV62Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      if ( ! (0==AV63Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV64Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int19[5] = (byte)(1) ;
      }
      if ( ! (0==AV66Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int19[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int19[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV68Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int19[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int19[9] = (byte)(1) ;
      }
      if ( AV72Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV72Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV73Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV74Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SecUserName]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SecUserName] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha] DESC" ;
      }
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H00223( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV72Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV60Logaccesoswwds_2_tflogaccesosid ,
                                          short AV61Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV62Logaccesoswwds_4_tfsecuserid ,
                                          short AV63Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV65Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV64Logaccesoswwds_6_tfsecusername ,
                                          short AV66Logaccesoswwds_8_tfsecroleid ,
                                          short AV67Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV69Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV68Logaccesoswwds_10_tfsecroledescription ,
                                          int AV72Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV73Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV74Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV59Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV71Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV70Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[12];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT T1.[LogAccesosFecha], T1.[LogAccesosTipo], T3.[SecRoleDescription], T1.[SecUserId], T1.[LogAccesosId], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV60Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
      }
      if ( ! (0==AV61Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int22[1] = (byte)(1) ;
      }
      if ( ! (0==AV62Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int22[2] = (byte)(1) ;
      }
      if ( ! (0==AV63Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV64Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( ! (0==AV66Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV68Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( AV72Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV72Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV73Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV74Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SecUserName]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SecUserName] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha] DESC" ;
      }
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
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
                  return conditional_H00222(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] );
            case 1 :
                  return conditional_H00223(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00222", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00223", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
      }
   }

}

