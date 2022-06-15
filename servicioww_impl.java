package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class servicioww_impl extends GXDataArea
{
   public servicioww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public servicioww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( servicioww_impl.class ));
   }

   public servicioww_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbServicioEstado = new HTMLChoice();
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
            AV27TFServicioId = (short)(GXutil.lval( httpContext.GetPar( "TFServicioId"))) ;
            AV28TFServicioId_To = (short)(GXutil.lval( httpContext.GetPar( "TFServicioId_To"))) ;
            AV29TFServicioNombre = httpContext.GetPar( "TFServicioNombre") ;
            AV30TFServicioNombre_Sel = httpContext.GetPar( "TFServicioNombre_Sel") ;
            AV31TFServicioDescripcion = httpContext.GetPar( "TFServicioDescripcion") ;
            AV32TFServicioDescripcion_Sel = httpContext.GetPar( "TFServicioDescripcion_Sel") ;
            AV33TFServicioCosto = CommonUtil.decimalVal( httpContext.GetPar( "TFServicioCosto"), ".") ;
            AV34TFServicioCosto_To = CommonUtil.decimalVal( httpContext.GetPar( "TFServicioCosto_To"), ".") ;
            AV35TFServicioCategId = (short)(GXutil.lval( httpContext.GetPar( "TFServicioCategId"))) ;
            AV36TFServicioCategId_To = (short)(GXutil.lval( httpContext.GetPar( "TFServicioCategId_To"))) ;
            AV37TFLaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "TFLaboratorioId"))) ;
            AV38TFLaboratorioId_To = (short)(GXutil.lval( httpContext.GetPar( "TFLaboratorioId_To"))) ;
            AV39TFLaboratorioNombre = httpContext.GetPar( "TFLaboratorioNombre") ;
            AV40TFLaboratorioNombre_Sel = httpContext.GetPar( "TFLaboratorioNombre_Sel") ;
            AV41TFServicioComision = (short)(GXutil.lval( httpContext.GetPar( "TFServicioComision"))) ;
            AV42TFServicioComision_To = (short)(GXutil.lval( httpContext.GetPar( "TFServicioComision_To"))) ;
            AV43TFServicioObservacion = httpContext.GetPar( "TFServicioObservacion") ;
            AV44TFServicioObservacion_Sel = httpContext.GetPar( "TFServicioObservacion_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV46TFServicioEstado_Sels);
            AV80Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV52IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV54IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV57IsAuthorized_LaboratorioNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_LaboratorioNombre")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFServicioId, AV28TFServicioId_To, AV29TFServicioNombre, AV30TFServicioNombre_Sel, AV31TFServicioDescripcion, AV32TFServicioDescripcion_Sel, AV33TFServicioCosto, AV34TFServicioCosto_To, AV35TFServicioCategId, AV36TFServicioCategId_To, AV37TFLaboratorioId, AV38TFLaboratorioId_To, AV39TFLaboratorioNombre, AV40TFLaboratorioNombre_Sel, AV41TFServicioComision, AV42TFServicioComision_To, AV43TFServicioObservacion, AV44TFServicioObservacion_Sel, AV46TFServicioEstado_Sels, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV54IsAuthorized_Delete, AV57IsAuthorized_LaboratorioNombre) ;
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
      pa2J2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2J2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110333821", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.servicioww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV80Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV54IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_LABORATORIONOMBRE", getSecureSignedToken( "", AV57IsAuthorized_LaboratorioNombre));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV49GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV50GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV47DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV47DDO_TitleSettingsIcons);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOID", GXutil.ltrim( localUtil.ntoc( AV27TFServicioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFServicioId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIONOMBRE", AV29TFServicioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIONOMBRE_SEL", AV30TFServicioNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIODESCRIPCION", AV31TFServicioDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIODESCRIPCION_SEL", AV32TFServicioDescripcion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOCOSTO", GXutil.ltrim( localUtil.ntoc( AV33TFServicioCosto, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOCOSTO_TO", GXutil.ltrim( localUtil.ntoc( AV34TFServicioCosto_To, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOCATEGID", GXutil.ltrim( localUtil.ntoc( AV35TFServicioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOCATEGID_TO", GXutil.ltrim( localUtil.ntoc( AV36TFServicioCategId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOID", GXutil.ltrim( localUtil.ntoc( AV37TFLaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIOID_TO", GXutil.ltrim( localUtil.ntoc( AV38TFLaboratorioId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIONOMBRE", AV39TFLaboratorioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFLABORATORIONOMBRE_SEL", AV40TFLaboratorioNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOCOMISION", GXutil.ltrim( localUtil.ntoc( AV41TFServicioComision, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOCOMISION_TO", GXutil.ltrim( localUtil.ntoc( AV42TFServicioComision_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOOBSERVACION", AV43TFServicioObservacion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOOBSERVACION_SEL", AV44TFServicioObservacion_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSERVICIOESTADO_SELS", AV46TFServicioEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSERVICIOESTADO_SELS", AV46TFServicioEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV80Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV80Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV52IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV54IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV54IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_LABORATORIONOMBRE", AV57IsAuthorized_LaboratorioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_LABORATORIONOMBRE", getSecureSignedToken( "", AV57IsAuthorized_LaboratorioNombre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSERVICIOESTADO_SELSJSON", AV45TFServicioEstado_SelsJson);
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
         we2J2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2J2( ) ;
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
      return formatLink("com.projectthani.servicioww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "ServicioWW" ;
   }

   public String getPgmdesc( )
   {
      return " Servicio" ;
   }

   public void wb2J0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_2J2( true) ;
      }
      else
      {
         wb_table1_25_2J2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_2J2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioDescripcion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioCosto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Costo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioCategId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Servicio Categ Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Laboratorio Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLaboratorioNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Laboratorio Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioComision_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Comision") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtServicioObservacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Observacion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbServicioEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV53Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A27ServicioId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A281ServicioNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtServicioNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A282ServicioDescripcion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioDescripcion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A283ServicioCosto, (byte)(6), (byte)(2), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioCosto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A52ServicioCategId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioCategId_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A284ServicioComision, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioComision_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A285ServicioObservacion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtServicioObservacion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A286ServicioEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbServicioEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV49GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV50GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
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

   public void start2J2( )
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
         Form.getMeta().addItem("description", " Servicio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2J0( ) ;
   }

   public void ws2J2( )
   {
      start2J2( ) ;
      evt2J2( ) ;
   }

   public void evt2J2( )
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
                           e112J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e162J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e172J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e182J2 ();
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
                           AV51Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV51Update);
                           AV53Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV53Delete);
                           A27ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioId_Internalname), ",", ".")) ;
                           A281ServicioNombre = httpContext.cgiGet( edtServicioNombre_Internalname) ;
                           A282ServicioDescripcion = httpContext.cgiGet( edtServicioDescripcion_Internalname) ;
                           A283ServicioCosto = localUtil.ctond( httpContext.cgiGet( edtServicioCosto_Internalname)) ;
                           A52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".")) ;
                           A40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".")) ;
                           A165LaboratorioNombre = httpContext.cgiGet( edtLaboratorioNombre_Internalname) ;
                           A284ServicioComision = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioComision_Internalname), ",", ".")) ;
                           A285ServicioObservacion = httpContext.cgiGet( edtServicioObservacion_Internalname) ;
                           cmbServicioEstado.setName( cmbServicioEstado.getInternalname() );
                           cmbServicioEstado.setValue( httpContext.cgiGet( cmbServicioEstado.getInternalname()) );
                           A286ServicioEstado = httpContext.cgiGet( cmbServicioEstado.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e192J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e202J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e212J2 ();
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

   public void we2J2( )
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

   public void pa2J2( )
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
                                 short AV27TFServicioId ,
                                 short AV28TFServicioId_To ,
                                 String AV29TFServicioNombre ,
                                 String AV30TFServicioNombre_Sel ,
                                 String AV31TFServicioDescripcion ,
                                 String AV32TFServicioDescripcion_Sel ,
                                 java.math.BigDecimal AV33TFServicioCosto ,
                                 java.math.BigDecimal AV34TFServicioCosto_To ,
                                 short AV35TFServicioCategId ,
                                 short AV36TFServicioCategId_To ,
                                 short AV37TFLaboratorioId ,
                                 short AV38TFLaboratorioId_To ,
                                 String AV39TFLaboratorioNombre ,
                                 String AV40TFLaboratorioNombre_Sel ,
                                 short AV41TFServicioComision ,
                                 short AV42TFServicioComision_To ,
                                 String AV43TFServicioObservacion ,
                                 String AV44TFServicioObservacion_Sel ,
                                 GXSimpleCollection<String> AV46TFServicioEstado_Sels ,
                                 String AV80Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV52IsAuthorized_Update ,
                                 boolean AV54IsAuthorized_Delete ,
                                 boolean AV57IsAuthorized_LaboratorioNombre )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e202J2 ();
      GRID_nCurrentRecord = 0 ;
      rf2J2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SERVICIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SERVICIOID", GXutil.ltrim( localUtil.ntoc( A27ServicioId, (byte)(4), (byte)(0), ".", "")));
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
      rf2J2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV80Pgmname = "ServicioWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf2J2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e202J2 ();
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
                                              A286ServicioEstado ,
                                              AV79Serviciowwds_20_tfservicioestado_sels ,
                                              AV60Serviciowwds_1_filterfulltext ,
                                              Short.valueOf(AV61Serviciowwds_2_tfservicioid) ,
                                              Short.valueOf(AV62Serviciowwds_3_tfservicioid_to) ,
                                              AV64Serviciowwds_5_tfservicionombre_sel ,
                                              AV63Serviciowwds_4_tfservicionombre ,
                                              AV66Serviciowwds_7_tfserviciodescripcion_sel ,
                                              AV65Serviciowwds_6_tfserviciodescripcion ,
                                              AV67Serviciowwds_8_tfserviciocosto ,
                                              AV68Serviciowwds_9_tfserviciocosto_to ,
                                              Short.valueOf(AV69Serviciowwds_10_tfserviciocategid) ,
                                              Short.valueOf(AV70Serviciowwds_11_tfserviciocategid_to) ,
                                              Short.valueOf(AV71Serviciowwds_12_tflaboratorioid) ,
                                              Short.valueOf(AV72Serviciowwds_13_tflaboratorioid_to) ,
                                              AV74Serviciowwds_15_tflaboratorionombre_sel ,
                                              AV73Serviciowwds_14_tflaboratorionombre ,
                                              Short.valueOf(AV75Serviciowwds_16_tfserviciocomision) ,
                                              Short.valueOf(AV76Serviciowwds_17_tfserviciocomision_to) ,
                                              AV78Serviciowwds_19_tfservicioobservacion_sel ,
                                              AV77Serviciowwds_18_tfservicioobservacion ,
                                              Integer.valueOf(AV79Serviciowwds_20_tfservicioestado_sels.size()) ,
                                              Short.valueOf(A27ServicioId) ,
                                              A281ServicioNombre ,
                                              A282ServicioDescripcion ,
                                              A283ServicioCosto ,
                                              Short.valueOf(A52ServicioCategId) ,
                                              Short.valueOf(A40LaboratorioId) ,
                                              A165LaboratorioNombre ,
                                              Short.valueOf(A284ServicioComision) ,
                                              A285ServicioObservacion ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
         lV63Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_4_tfservicionombre), "%", "") ;
         lV65Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV65Serviciowwds_6_tfserviciodescripcion), "%", "") ;
         lV73Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV73Serviciowwds_14_tflaboratorionombre), "%", "") ;
         lV77Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV77Serviciowwds_18_tfservicioobservacion), "%", "") ;
         /* Using cursor H002J2 */
         pr_default.execute(0, new Object[] {lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, Short.valueOf(AV61Serviciowwds_2_tfservicioid), Short.valueOf(AV62Serviciowwds_3_tfservicioid_to), lV63Serviciowwds_4_tfservicionombre, AV64Serviciowwds_5_tfservicionombre_sel, lV65Serviciowwds_6_tfserviciodescripcion, AV66Serviciowwds_7_tfserviciodescripcion_sel, AV67Serviciowwds_8_tfserviciocosto, AV68Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV69Serviciowwds_10_tfserviciocategid), Short.valueOf(AV70Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV71Serviciowwds_12_tflaboratorioid), Short.valueOf(AV72Serviciowwds_13_tflaboratorioid_to), lV73Serviciowwds_14_tflaboratorionombre, AV74Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV75Serviciowwds_16_tfserviciocomision), Short.valueOf(AV76Serviciowwds_17_tfserviciocomision_to), lV77Serviciowwds_18_tfservicioobservacion, AV78Serviciowwds_19_tfservicioobservacion_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A286ServicioEstado = H002J2_A286ServicioEstado[0] ;
            A285ServicioObservacion = H002J2_A285ServicioObservacion[0] ;
            A284ServicioComision = H002J2_A284ServicioComision[0] ;
            A165LaboratorioNombre = H002J2_A165LaboratorioNombre[0] ;
            A40LaboratorioId = H002J2_A40LaboratorioId[0] ;
            A52ServicioCategId = H002J2_A52ServicioCategId[0] ;
            A283ServicioCosto = H002J2_A283ServicioCosto[0] ;
            A282ServicioDescripcion = H002J2_A282ServicioDescripcion[0] ;
            A281ServicioNombre = H002J2_A281ServicioNombre[0] ;
            A27ServicioId = H002J2_A27ServicioId[0] ;
            A40LaboratorioId = H002J2_A40LaboratorioId[0] ;
            A165LaboratorioNombre = H002J2_A165LaboratorioNombre[0] ;
            e212J2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb2J0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2J2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV80Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV80Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV52IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV54IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV54IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_LABORATORIONOMBRE", AV57IsAuthorized_LaboratorioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_LABORATORIONOMBRE", getSecureSignedToken( "", AV57IsAuthorized_LaboratorioNombre));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SERVICIOID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9")));
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
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV79Serviciowwds_20_tfservicioestado_sels ,
                                           AV60Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV61Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV62Serviciowwds_3_tfservicioid_to) ,
                                           AV64Serviciowwds_5_tfservicionombre_sel ,
                                           AV63Serviciowwds_4_tfservicionombre ,
                                           AV66Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV65Serviciowwds_6_tfserviciodescripcion ,
                                           AV67Serviciowwds_8_tfserviciocosto ,
                                           AV68Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV69Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV70Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV71Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV72Serviciowwds_13_tflaboratorioid_to) ,
                                           AV74Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV73Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV75Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV76Serviciowwds_17_tfserviciocomision_to) ,
                                           AV78Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV77Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV79Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV60Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV60Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_4_tfservicionombre), "%", "") ;
      lV65Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV65Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV73Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV73Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV77Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV77Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor H002J3 */
      pr_default.execute(1, new Object[] {lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, lV60Serviciowwds_1_filterfulltext, Short.valueOf(AV61Serviciowwds_2_tfservicioid), Short.valueOf(AV62Serviciowwds_3_tfservicioid_to), lV63Serviciowwds_4_tfservicionombre, AV64Serviciowwds_5_tfservicionombre_sel, lV65Serviciowwds_6_tfserviciodescripcion, AV66Serviciowwds_7_tfserviciodescripcion_sel, AV67Serviciowwds_8_tfserviciocosto, AV68Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV69Serviciowwds_10_tfserviciocategid), Short.valueOf(AV70Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV71Serviciowwds_12_tflaboratorioid), Short.valueOf(AV72Serviciowwds_13_tflaboratorioid_to), lV73Serviciowwds_14_tflaboratorionombre, AV74Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV75Serviciowwds_16_tfserviciocomision), Short.valueOf(AV76Serviciowwds_17_tfserviciocomision_to), lV77Serviciowwds_18_tfservicioobservacion, AV78Serviciowwds_19_tfservicioobservacion_sel});
      GRID_nRecordCount = H002J3_AGRID_nRecordCount[0] ;
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
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFServicioId, AV28TFServicioId_To, AV29TFServicioNombre, AV30TFServicioNombre_Sel, AV31TFServicioDescripcion, AV32TFServicioDescripcion_Sel, AV33TFServicioCosto, AV34TFServicioCosto_To, AV35TFServicioCategId, AV36TFServicioCategId_To, AV37TFLaboratorioId, AV38TFLaboratorioId_To, AV39TFLaboratorioNombre, AV40TFLaboratorioNombre_Sel, AV41TFServicioComision, AV42TFServicioComision_To, AV43TFServicioObservacion, AV44TFServicioObservacion_Sel, AV46TFServicioEstado_Sels, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV54IsAuthorized_Delete, AV57IsAuthorized_LaboratorioNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFServicioId, AV28TFServicioId_To, AV29TFServicioNombre, AV30TFServicioNombre_Sel, AV31TFServicioDescripcion, AV32TFServicioDescripcion_Sel, AV33TFServicioCosto, AV34TFServicioCosto_To, AV35TFServicioCategId, AV36TFServicioCategId_To, AV37TFLaboratorioId, AV38TFLaboratorioId_To, AV39TFLaboratorioNombre, AV40TFLaboratorioNombre_Sel, AV41TFServicioComision, AV42TFServicioComision_To, AV43TFServicioObservacion, AV44TFServicioObservacion_Sel, AV46TFServicioEstado_Sels, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV54IsAuthorized_Delete, AV57IsAuthorized_LaboratorioNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFServicioId, AV28TFServicioId_To, AV29TFServicioNombre, AV30TFServicioNombre_Sel, AV31TFServicioDescripcion, AV32TFServicioDescripcion_Sel, AV33TFServicioCosto, AV34TFServicioCosto_To, AV35TFServicioCategId, AV36TFServicioCategId_To, AV37TFLaboratorioId, AV38TFLaboratorioId_To, AV39TFLaboratorioNombre, AV40TFLaboratorioNombre_Sel, AV41TFServicioComision, AV42TFServicioComision_To, AV43TFServicioObservacion, AV44TFServicioObservacion_Sel, AV46TFServicioEstado_Sels, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV54IsAuthorized_Delete, AV57IsAuthorized_LaboratorioNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFServicioId, AV28TFServicioId_To, AV29TFServicioNombre, AV30TFServicioNombre_Sel, AV31TFServicioDescripcion, AV32TFServicioDescripcion_Sel, AV33TFServicioCosto, AV34TFServicioCosto_To, AV35TFServicioCategId, AV36TFServicioCategId_To, AV37TFLaboratorioId, AV38TFLaboratorioId_To, AV39TFLaboratorioNombre, AV40TFLaboratorioNombre_Sel, AV41TFServicioComision, AV42TFServicioComision_To, AV43TFServicioObservacion, AV44TFServicioObservacion_Sel, AV46TFServicioEstado_Sels, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV54IsAuthorized_Delete, AV57IsAuthorized_LaboratorioNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFServicioId, AV28TFServicioId_To, AV29TFServicioNombre, AV30TFServicioNombre_Sel, AV31TFServicioDescripcion, AV32TFServicioDescripcion_Sel, AV33TFServicioCosto, AV34TFServicioCosto_To, AV35TFServicioCategId, AV36TFServicioCategId_To, AV37TFLaboratorioId, AV38TFLaboratorioId_To, AV39TFLaboratorioNombre, AV40TFLaboratorioNombre_Sel, AV41TFServicioComision, AV42TFServicioComision_To, AV43TFServicioObservacion, AV44TFServicioObservacion_Sel, AV46TFServicioEstado_Sels, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV54IsAuthorized_Delete, AV57IsAuthorized_LaboratorioNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV80Pgmname = "ServicioWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2J0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e192J2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV47DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV49GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV50GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
      e192J2 ();
      if (returnInSub) return;
   }

   public void e192J2( )
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
      GXt_boolean1 = AV57IsAuthorized_LaboratorioNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio", GXv_boolean2) ;
      servicioww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV57IsAuthorized_LaboratorioNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57IsAuthorized_LaboratorioNombre", AV57IsAuthorized_LaboratorioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_LABORATORIONOMBRE", getSecureSignedToken( "", AV57IsAuthorized_LaboratorioNombre));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Servicio" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV47DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV47DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e202J2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
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
      if ( GXutil.strcmp(AV23Session.getValue("ServicioWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("ServicioWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtServicioId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtServicioNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtServicioDescripcion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioDescripcion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioDescripcion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtServicioCosto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCosto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCosto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtServicioCategId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtLaboratorioNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtServicioComision_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioComision_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioComision_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtServicioObservacion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioObservacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioObservacion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbServicioEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbServicioEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbServicioEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV49GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49GridCurrentPage), 10, 0));
      AV50GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50GridPageCount), 10, 0));
      AV60Serviciowwds_1_filterfulltext = AV16FilterFullText ;
      AV61Serviciowwds_2_tfservicioid = AV27TFServicioId ;
      AV62Serviciowwds_3_tfservicioid_to = AV28TFServicioId_To ;
      AV63Serviciowwds_4_tfservicionombre = AV29TFServicioNombre ;
      AV64Serviciowwds_5_tfservicionombre_sel = AV30TFServicioNombre_Sel ;
      AV65Serviciowwds_6_tfserviciodescripcion = AV31TFServicioDescripcion ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = AV32TFServicioDescripcion_Sel ;
      AV67Serviciowwds_8_tfserviciocosto = AV33TFServicioCosto ;
      AV68Serviciowwds_9_tfserviciocosto_to = AV34TFServicioCosto_To ;
      AV69Serviciowwds_10_tfserviciocategid = AV35TFServicioCategId ;
      AV70Serviciowwds_11_tfserviciocategid_to = AV36TFServicioCategId_To ;
      AV71Serviciowwds_12_tflaboratorioid = AV37TFLaboratorioId ;
      AV72Serviciowwds_13_tflaboratorioid_to = AV38TFLaboratorioId_To ;
      AV73Serviciowwds_14_tflaboratorionombre = AV39TFLaboratorioNombre ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = AV40TFLaboratorioNombre_Sel ;
      AV75Serviciowwds_16_tfserviciocomision = AV41TFServicioComision ;
      AV76Serviciowwds_17_tfserviciocomision_to = AV42TFServicioComision_To ;
      AV77Serviciowwds_18_tfservicioobservacion = AV43TFServicioObservacion ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = AV44TFServicioObservacion_Sel ;
      AV79Serviciowwds_20_tfservicioestado_sels = AV46TFServicioEstado_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122J2( )
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
         AV48PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV48PageToGo) ;
      }
   }

   public void e132J2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142J2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioId") == 0 )
         {
            AV27TFServicioId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFServicioId), 4, 0));
            AV28TFServicioId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFServicioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFServicioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioNombre") == 0 )
         {
            AV29TFServicioNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFServicioNombre", AV29TFServicioNombre);
            AV30TFServicioNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFServicioNombre_Sel", AV30TFServicioNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioDescripcion") == 0 )
         {
            AV31TFServicioDescripcion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFServicioDescripcion", AV31TFServicioDescripcion);
            AV32TFServicioDescripcion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFServicioDescripcion_Sel", AV32TFServicioDescripcion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioCosto") == 0 )
         {
            AV33TFServicioCosto = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFServicioCosto", GXutil.ltrimstr( AV33TFServicioCosto, 6, 2));
            AV34TFServicioCosto_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFServicioCosto_To", GXutil.ltrimstr( AV34TFServicioCosto_To, 6, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioCategId") == 0 )
         {
            AV35TFServicioCategId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFServicioCategId), 4, 0));
            AV36TFServicioCategId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFServicioCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFServicioCategId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioId") == 0 )
         {
            AV37TFLaboratorioId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLaboratorioId), 4, 0));
            AV38TFLaboratorioId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFLaboratorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLaboratorioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LaboratorioNombre") == 0 )
         {
            AV39TFLaboratorioNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFLaboratorioNombre", AV39TFLaboratorioNombre);
            AV40TFLaboratorioNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFLaboratorioNombre_Sel", AV40TFLaboratorioNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioComision") == 0 )
         {
            AV41TFServicioComision = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFServicioComision), 4, 0));
            AV42TFServicioComision_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFServicioComision_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFServicioComision_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioObservacion") == 0 )
         {
            AV43TFServicioObservacion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFServicioObservacion", AV43TFServicioObservacion);
            AV44TFServicioObservacion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFServicioObservacion_Sel", AV44TFServicioObservacion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ServicioEstado") == 0 )
         {
            AV45TFServicioEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFServicioEstado_SelsJson", AV45TFServicioEstado_SelsJson);
            AV46TFServicioEstado_Sels.fromJSonString(AV45TFServicioEstado_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFServicioEstado_Sels", AV46TFServicioEstado_Sels);
   }

   private void e212J2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV51Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV51Update);
      if ( AV52IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.servicio", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A27ServicioId,4,0))}, new String[] {"Mode","ServicioId"})  ;
      }
      AV53Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV53Delete);
      if ( AV54IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.servicio", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A27ServicioId,4,0))}, new String[] {"Mode","ServicioId"})  ;
      }
      edtServicioNombre_Link = formatLink("com.projectthani.servicioview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A27ServicioId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"ServicioId","TabCode"})  ;
      if ( AV57IsAuthorized_LaboratorioNombre )
      {
         edtLaboratorioNombre_Link = formatLink("com.projectthani.laboratorioview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A40LaboratorioId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"LaboratorioId","TabCode"})  ;
      }
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

   public void e152J2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "ServicioWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e112J2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("ServicioWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV80Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("ServicioWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "ServicioWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         servicioww_impl.this.GXt_char6 = GXv_char7[0] ;
         AV25ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV25ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem("El filtro seleccionado no existe más.");
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV80Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFServicioEstado_Sels", AV46TFServicioEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e162J2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.servicio", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","ServicioId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e172J2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.serviciowwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      servicioww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      servicioww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFServicioEstado_Sels", AV46TFServicioEstado_Sels);
   }

   public void e182J2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.serviciowwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFServicioEstado_Sels", AV46TFServicioEstado_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioNombre", "", "Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioDescripcion", "", "Descripcion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioCosto", "", "Costo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioCategId", "", "Servicio Categ Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LaboratorioId", "", "Laboratorio Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LaboratorioNombre", "", "Laboratorio Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioComision", "", "Comision", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioObservacion", "", "Observacion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ServicioEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ServicioWWColumnsSelector", GXv_char8) ;
      servicioww_impl.this.GXt_char6 = GXv_char8[0] ;
      AV20UserCustomValue = GXt_char6 ;
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
      GXt_boolean1 = AV52IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio_Update", GXv_boolean2) ;
      servicioww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV52IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52IsAuthorized_Update", AV52IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      if ( ! ( AV52IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV54IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio_Delete", GXv_boolean2) ;
      servicioww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV54IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54IsAuthorized_Delete", AV54IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV54IsAuthorized_Delete));
      if ( ! ( AV54IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV55TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio_Insert", GXv_boolean2) ;
      servicioww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV55TempBoolean = GXt_boolean1 ;
      if ( ! ( AV55TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "ServicioWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFServicioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFServicioId), 4, 0));
      AV28TFServicioId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFServicioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFServicioId_To), 4, 0));
      AV29TFServicioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFServicioNombre", AV29TFServicioNombre);
      AV30TFServicioNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFServicioNombre_Sel", AV30TFServicioNombre_Sel);
      AV31TFServicioDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFServicioDescripcion", AV31TFServicioDescripcion);
      AV32TFServicioDescripcion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFServicioDescripcion_Sel", AV32TFServicioDescripcion_Sel);
      AV33TFServicioCosto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFServicioCosto", GXutil.ltrimstr( AV33TFServicioCosto, 6, 2));
      AV34TFServicioCosto_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFServicioCosto_To", GXutil.ltrimstr( AV34TFServicioCosto_To, 6, 2));
      AV35TFServicioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFServicioCategId), 4, 0));
      AV36TFServicioCategId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFServicioCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFServicioCategId_To), 4, 0));
      AV37TFLaboratorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLaboratorioId), 4, 0));
      AV38TFLaboratorioId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFLaboratorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLaboratorioId_To), 4, 0));
      AV39TFLaboratorioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFLaboratorioNombre", AV39TFLaboratorioNombre);
      AV40TFLaboratorioNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFLaboratorioNombre_Sel", AV40TFLaboratorioNombre_Sel);
      AV41TFServicioComision = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFServicioComision), 4, 0));
      AV42TFServicioComision_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFServicioComision_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFServicioComision_To), 4, 0));
      AV43TFServicioObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFServicioObservacion", AV43TFServicioObservacion);
      AV44TFServicioObservacion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFServicioObservacion_Sel", AV44TFServicioObservacion_Sel);
      AV46TFServicioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV80Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV80Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV80Pgmname+"GridState"), null, null);
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
      AV81GXV1 = 1 ;
      while ( AV81GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV81GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOID") == 0 )
         {
            AV27TFServicioId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFServicioId), 4, 0));
            AV28TFServicioId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFServicioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFServicioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE") == 0 )
         {
            AV29TFServicioNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFServicioNombre", AV29TFServicioNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE_SEL") == 0 )
         {
            AV30TFServicioNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFServicioNombre_Sel", AV30TFServicioNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION") == 0 )
         {
            AV31TFServicioDescripcion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFServicioDescripcion", AV31TFServicioDescripcion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION_SEL") == 0 )
         {
            AV32TFServicioDescripcion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFServicioDescripcion_Sel", AV32TFServicioDescripcion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOSTO") == 0 )
         {
            AV33TFServicioCosto = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFServicioCosto", GXutil.ltrimstr( AV33TFServicioCosto, 6, 2));
            AV34TFServicioCosto_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFServicioCosto_To", GXutil.ltrimstr( AV34TFServicioCosto_To, 6, 2));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGID") == 0 )
         {
            AV35TFServicioCategId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFServicioCategId), 4, 0));
            AV36TFServicioCategId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFServicioCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFServicioCategId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV37TFLaboratorioId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLaboratorioId), 4, 0));
            AV38TFLaboratorioId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFLaboratorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLaboratorioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV39TFLaboratorioNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFLaboratorioNombre", AV39TFLaboratorioNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV40TFLaboratorioNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFLaboratorioNombre_Sel", AV40TFLaboratorioNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOMISION") == 0 )
         {
            AV41TFServicioComision = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFServicioComision), 4, 0));
            AV42TFServicioComision_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFServicioComision_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFServicioComision_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION") == 0 )
         {
            AV43TFServicioObservacion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFServicioObservacion", AV43TFServicioObservacion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION_SEL") == 0 )
         {
            AV44TFServicioObservacion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFServicioObservacion_Sel", AV44TFServicioObservacion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOESTADO_SEL") == 0 )
         {
            AV45TFServicioEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFServicioEstado_SelsJson", AV45TFServicioEstado_SelsJson);
            AV46TFServicioEstado_Sels.fromJSonString(AV45TFServicioEstado_SelsJson, null);
         }
         AV81GXV1 = (int)(AV81GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFServicioNombre_Sel)==0), AV30TFServicioNombre_Sel, GXv_char8) ;
      servicioww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFServicioDescripcion_Sel)==0), AV32TFServicioDescripcion_Sel, GXv_char7) ;
      servicioww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFLaboratorioNombre_Sel)==0), AV40TFLaboratorioNombre_Sel, GXv_char15) ;
      servicioww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFServicioObservacion_Sel)==0), AV44TFServicioObservacion_Sel, GXv_char17) ;
      servicioww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV46TFServicioEstado_Sels.size()==0), AV45TFServicioEstado_SelsJson, GXv_char19) ;
      servicioww_impl.this.GXt_char18 = GXv_char19[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|"+GXt_char13+"||||"+GXt_char14+"||"+GXt_char16+"|"+GXt_char18 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFServicioNombre)==0), AV29TFServicioNombre, GXv_char19) ;
      servicioww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFServicioDescripcion)==0), AV31TFServicioDescripcion, GXv_char17) ;
      servicioww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFLaboratorioNombre)==0), AV39TFLaboratorioNombre, GXv_char15) ;
      servicioww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char8[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFServicioObservacion)==0), AV43TFServicioObservacion, GXv_char8) ;
      servicioww_impl.this.GXt_char13 = GXv_char8[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFServicioId) ? "" : GXutil.str( AV27TFServicioId, 4, 0))+"|"+GXt_char18+"|"+GXt_char16+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFServicioCosto)==0) ? "" : GXutil.str( AV33TFServicioCosto, 6, 2))+"|"+((0==AV35TFServicioCategId) ? "" : GXutil.str( AV35TFServicioCategId, 4, 0))+"|"+((0==AV37TFLaboratorioId) ? "" : GXutil.str( AV37TFLaboratorioId, 4, 0))+"|"+GXt_char14+"|"+((0==AV41TFServicioComision) ? "" : GXutil.str( AV41TFServicioComision, 4, 0))+"|"+GXt_char13+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFServicioId_To) ? "" : GXutil.str( AV28TFServicioId_To, 4, 0))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFServicioCosto_To)==0) ? "" : GXutil.str( AV34TFServicioCosto_To, 6, 2))+"|"+((0==AV36TFServicioCategId_To) ? "" : GXutil.str( AV36TFServicioCategId_To, 4, 0))+"|"+((0==AV38TFLaboratorioId_To) ? "" : GXutil.str( AV38TFLaboratorioId_To, 4, 0))+"||"+((0==AV42TFServicioComision_To) ? "" : GXutil.str( AV42TFServicioComision_To, 4, 0))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV80Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIOID", !((0==AV27TFServicioId)&&(0==AV28TFServicioId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFServicioId, 4, 0)), GXutil.trim( GXutil.str( AV28TFServicioId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIONOMBRE", !(GXutil.strcmp("", AV29TFServicioNombre)==0), (short)(0), AV29TFServicioNombre, "", !(GXutil.strcmp("", AV30TFServicioNombre_Sel)==0), AV30TFServicioNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIODESCRIPCION", !(GXutil.strcmp("", AV31TFServicioDescripcion)==0), (short)(0), AV31TFServicioDescripcion, "", !(GXutil.strcmp("", AV32TFServicioDescripcion_Sel)==0), AV32TFServicioDescripcion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIOCOSTO", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFServicioCosto)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFServicioCosto_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV33TFServicioCosto, 6, 2)), GXutil.trim( GXutil.str( AV34TFServicioCosto_To, 6, 2))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIOCATEGID", !((0==AV35TFServicioCategId)&&(0==AV36TFServicioCategId_To)), (short)(0), GXutil.trim( GXutil.str( AV35TFServicioCategId, 4, 0)), GXutil.trim( GXutil.str( AV36TFServicioCategId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIOID", !((0==AV37TFLaboratorioId)&&(0==AV38TFLaboratorioId_To)), (short)(0), GXutil.trim( GXutil.str( AV37TFLaboratorioId, 4, 0)), GXutil.trim( GXutil.str( AV38TFLaboratorioId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLABORATORIONOMBRE", !(GXutil.strcmp("", AV39TFLaboratorioNombre)==0), (short)(0), AV39TFLaboratorioNombre, "", !(GXutil.strcmp("", AV40TFLaboratorioNombre_Sel)==0), AV40TFLaboratorioNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIOCOMISION", !((0==AV41TFServicioComision)&&(0==AV42TFServicioComision_To)), (short)(0), GXutil.trim( GXutil.str( AV41TFServicioComision, 4, 0)), GXutil.trim( GXutil.str( AV42TFServicioComision_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIOOBSERVACION", !(GXutil.strcmp("", AV43TFServicioObservacion)==0), (short)(0), AV43TFServicioObservacion, "", !(GXutil.strcmp("", AV44TFServicioObservacion_Sel)==0), AV44TFServicioObservacion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFSERVICIOESTADO_SEL", !(AV46TFServicioEstado_Sels.size()==0), (short)(0), AV46TFServicioEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState20[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV80Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV80Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Servicio" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_2J2( boolean wbgen )
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
         wb_table2_30_2J2( true) ;
      }
      else
      {
         wb_table2_30_2J2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_2J2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_2J2e( true) ;
      }
      else
      {
         wb_table1_25_2J2e( false) ;
      }
   }

   public void wb_table2_30_2J2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_ServicioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_2J2e( true) ;
      }
      else
      {
         wb_table2_30_2J2e( false) ;
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
      pa2J2( ) ;
      ws2J2( ) ;
      we2J2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334163", true, true);
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
      httpContext.AddJavascriptSource("servicioww.js", "?20225110334163", false, true);
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
      edtServicioId_Internalname = "SERVICIOID_"+sGXsfl_43_idx ;
      edtServicioNombre_Internalname = "SERVICIONOMBRE_"+sGXsfl_43_idx ;
      edtServicioDescripcion_Internalname = "SERVICIODESCRIPCION_"+sGXsfl_43_idx ;
      edtServicioCosto_Internalname = "SERVICIOCOSTO_"+sGXsfl_43_idx ;
      edtServicioCategId_Internalname = "SERVICIOCATEGID_"+sGXsfl_43_idx ;
      edtLaboratorioId_Internalname = "LABORATORIOID_"+sGXsfl_43_idx ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE_"+sGXsfl_43_idx ;
      edtServicioComision_Internalname = "SERVICIOCOMISION_"+sGXsfl_43_idx ;
      edtServicioObservacion_Internalname = "SERVICIOOBSERVACION_"+sGXsfl_43_idx ;
      cmbServicioEstado.setInternalname( "SERVICIOESTADO_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtServicioId_Internalname = "SERVICIOID_"+sGXsfl_43_fel_idx ;
      edtServicioNombre_Internalname = "SERVICIONOMBRE_"+sGXsfl_43_fel_idx ;
      edtServicioDescripcion_Internalname = "SERVICIODESCRIPCION_"+sGXsfl_43_fel_idx ;
      edtServicioCosto_Internalname = "SERVICIOCOSTO_"+sGXsfl_43_fel_idx ;
      edtServicioCategId_Internalname = "SERVICIOCATEGID_"+sGXsfl_43_fel_idx ;
      edtLaboratorioId_Internalname = "LABORATORIOID_"+sGXsfl_43_fel_idx ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE_"+sGXsfl_43_fel_idx ;
      edtServicioComision_Internalname = "SERVICIOCOMISION_"+sGXsfl_43_fel_idx ;
      edtServicioObservacion_Internalname = "SERVICIOOBSERVACION_"+sGXsfl_43_fel_idx ;
      cmbServicioEstado.setInternalname( "SERVICIOESTADO_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb2J0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV51Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV53Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtServicioId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioId_Internalname,GXutil.ltrim( localUtil.ntoc( A27ServicioId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServicioId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtServicioId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtServicioNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioNombre_Internalname,A281ServicioNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtServicioNombre_Link,"","","",edtServicioNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtServicioNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtServicioDescripcion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioDescripcion_Internalname,A282ServicioDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServicioDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtServicioDescripcion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtServicioCosto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioCosto_Internalname,GXutil.ltrim( localUtil.ntoc( A283ServicioCosto, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A283ServicioCosto, "ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServicioCosto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtServicioCosto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtServicioCategId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioCategId_Internalname,GXutil.ltrim( localUtil.ntoc( A52ServicioCategId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServicioCategId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtServicioCategId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLaboratorioNombre_Internalname,A165LaboratorioNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtLaboratorioNombre_Link,"","","",edtLaboratorioNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLaboratorioNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtServicioComision_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioComision_Internalname,GXutil.ltrim( localUtil.ntoc( A284ServicioComision, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A284ServicioComision), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServicioComision_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtServicioComision_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtServicioObservacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServicioObservacion_Internalname,A285ServicioObservacion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServicioObservacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtServicioObservacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbServicioEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbServicioEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SERVICIOESTADO_" + sGXsfl_43_idx ;
            cmbServicioEstado.setName( GXCCtl );
            cmbServicioEstado.setWebtags( "" );
            cmbServicioEstado.addItem("A", "Activo", (short)(0));
            cmbServicioEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbServicioEstado.getItemCount() > 0 )
            {
               A286ServicioEstado = cmbServicioEstado.getValidValue(A286ServicioEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbServicioEstado,cmbServicioEstado.getInternalname(),GXutil.rtrim( A286ServicioEstado),Integer.valueOf(1),cmbServicioEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbServicioEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbServicioEstado.setValue( GXutil.rtrim( A286ServicioEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbServicioEstado.getInternalname(), "Values", cmbServicioEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes2J2( ) ;
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
      edtServicioId_Internalname = "SERVICIOID" ;
      edtServicioNombre_Internalname = "SERVICIONOMBRE" ;
      edtServicioDescripcion_Internalname = "SERVICIODESCRIPCION" ;
      edtServicioCosto_Internalname = "SERVICIOCOSTO" ;
      edtServicioCategId_Internalname = "SERVICIOCATEGID" ;
      edtLaboratorioId_Internalname = "LABORATORIOID" ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE" ;
      edtServicioComision_Internalname = "SERVICIOCOMISION" ;
      edtServicioObservacion_Internalname = "SERVICIOOBSERVACION" ;
      cmbServicioEstado.setInternalname( "SERVICIOESTADO" );
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
      cmbServicioEstado.setJsonclick( "" );
      edtServicioObservacion_Jsonclick = "" ;
      edtServicioComision_Jsonclick = "" ;
      edtLaboratorioNombre_Jsonclick = "" ;
      edtLaboratorioId_Jsonclick = "" ;
      edtServicioCategId_Jsonclick = "" ;
      edtServicioCosto_Jsonclick = "" ;
      edtServicioDescripcion_Jsonclick = "" ;
      edtServicioNombre_Jsonclick = "" ;
      edtServicioId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtLaboratorioNombre_Link = "" ;
      edtServicioNombre_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbServicioEstado.setVisible( -1 );
      edtServicioObservacion_Visible = -1 ;
      edtServicioComision_Visible = -1 ;
      edtLaboratorioNombre_Visible = -1 ;
      edtLaboratorioId_Visible = -1 ;
      edtServicioCategId_Visible = -1 ;
      edtServicioCosto_Visible = -1 ;
      edtServicioDescripcion_Visible = -1 ;
      edtServicioNombre_Visible = -1 ;
      edtServicioId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Servicio" );
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
      Ddo_grid_Datalistproc = "ServicioWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||||||A:Activo,I:Inactivo" ;
      Ddo_grid_Allowmultipleselection = "|||||||||T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic||||Dynamic||Dynamic|FixedValues" ;
      Ddo_grid_Includedatalist = "|T|T||||T||T|T" ;
      Ddo_grid_Filterisrange = "T|||T|T|T||T||" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Numeric|Numeric|Numeric|Character|Numeric|Character|" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5|6|7|8|9|10" ;
      Ddo_grid_Columnids = "2:ServicioId|3:ServicioNombre|4:ServicioDescripcion|5:ServicioCosto|6:ServicioCategId|7:LaboratorioId|8:LaboratorioNombre|9:ServicioComision|10:ServicioObservacion|11:ServicioEstado" ;
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
      GXCCtl = "SERVICIOESTADO_" + sGXsfl_43_idx ;
      cmbServicioEstado.setName( GXCCtl );
      cmbServicioEstado.setWebtags( "" );
      cmbServicioEstado.addItem("A", "Activo", (short)(0));
      cmbServicioEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbServicioEstado.getItemCount() > 0 )
      {
         A286ServicioEstado = cmbServicioEstado.getValidValue(A286ServicioEstado) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtServicioId_Visible',ctrl:'SERVICIOID',prop:'Visible'},{av:'edtServicioNombre_Visible',ctrl:'SERVICIONOMBRE',prop:'Visible'},{av:'edtServicioDescripcion_Visible',ctrl:'SERVICIODESCRIPCION',prop:'Visible'},{av:'edtServicioCosto_Visible',ctrl:'SERVICIOCOSTO',prop:'Visible'},{av:'edtServicioCategId_Visible',ctrl:'SERVICIOCATEGID',prop:'Visible'},{av:'edtLaboratorioId_Visible',ctrl:'LABORATORIOID',prop:'Visible'},{av:'edtLaboratorioNombre_Visible',ctrl:'LABORATORIONOMBRE',prop:'Visible'},{av:'edtServicioComision_Visible',ctrl:'SERVICIOCOMISION',prop:'Visible'},{av:'edtServicioObservacion_Visible',ctrl:'SERVICIOOBSERVACION',prop:'Visible'},{av:'cmbServicioEstado'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e142J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e212J2',iparms:[{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A27ServicioId',fld:'SERVICIOID',pic:'ZZZ9',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV51Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV53Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtServicioNombre_Link',ctrl:'SERVICIONOMBRE',prop:'Link'},{av:'edtLaboratorioNombre_Link',ctrl:'LABORATORIONOMBRE',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e152J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtServicioId_Visible',ctrl:'SERVICIOID',prop:'Visible'},{av:'edtServicioNombre_Visible',ctrl:'SERVICIONOMBRE',prop:'Visible'},{av:'edtServicioDescripcion_Visible',ctrl:'SERVICIODESCRIPCION',prop:'Visible'},{av:'edtServicioCosto_Visible',ctrl:'SERVICIOCOSTO',prop:'Visible'},{av:'edtServicioCategId_Visible',ctrl:'SERVICIOCATEGID',prop:'Visible'},{av:'edtLaboratorioId_Visible',ctrl:'LABORATORIOID',prop:'Visible'},{av:'edtLaboratorioNombre_Visible',ctrl:'LABORATORIONOMBRE',prop:'Visible'},{av:'edtServicioComision_Visible',ctrl:'SERVICIOCOMISION',prop:'Visible'},{av:'edtServicioObservacion_Visible',ctrl:'SERVICIOOBSERVACION',prop:'Visible'},{av:'cmbServicioEstado'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtServicioId_Visible',ctrl:'SERVICIOID',prop:'Visible'},{av:'edtServicioNombre_Visible',ctrl:'SERVICIONOMBRE',prop:'Visible'},{av:'edtServicioDescripcion_Visible',ctrl:'SERVICIODESCRIPCION',prop:'Visible'},{av:'edtServicioCosto_Visible',ctrl:'SERVICIOCOSTO',prop:'Visible'},{av:'edtServicioCategId_Visible',ctrl:'SERVICIOCATEGID',prop:'Visible'},{av:'edtLaboratorioId_Visible',ctrl:'LABORATORIOID',prop:'Visible'},{av:'edtLaboratorioNombre_Visible',ctrl:'LABORATORIONOMBRE',prop:'Visible'},{av:'edtServicioComision_Visible',ctrl:'SERVICIOCOMISION',prop:'Visible'},{av:'edtServicioObservacion_Visible',ctrl:'SERVICIOOBSERVACION',prop:'Visible'},{av:'cmbServicioEstado'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e162J2',iparms:[{av:'A27ServicioId',fld:'SERVICIOID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e172J2',iparms:[{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e182J2',iparms:[{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFServicioId',fld:'vTFSERVICIOID',pic:'ZZZ9'},{av:'AV28TFServicioId_To',fld:'vTFSERVICIOID_TO',pic:'ZZZ9'},{av:'AV29TFServicioNombre',fld:'vTFSERVICIONOMBRE',pic:''},{av:'AV30TFServicioNombre_Sel',fld:'vTFSERVICIONOMBRE_SEL',pic:''},{av:'AV31TFServicioDescripcion',fld:'vTFSERVICIODESCRIPCION',pic:''},{av:'AV32TFServicioDescripcion_Sel',fld:'vTFSERVICIODESCRIPCION_SEL',pic:''},{av:'AV33TFServicioCosto',fld:'vTFSERVICIOCOSTO',pic:'ZZ9.99'},{av:'AV34TFServicioCosto_To',fld:'vTFSERVICIOCOSTO_TO',pic:'ZZ9.99'},{av:'AV35TFServicioCategId',fld:'vTFSERVICIOCATEGID',pic:'ZZZ9'},{av:'AV36TFServicioCategId_To',fld:'vTFSERVICIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFLaboratorioId',fld:'vTFLABORATORIOID',pic:'ZZZ9'},{av:'AV38TFLaboratorioId_To',fld:'vTFLABORATORIOID_TO',pic:'ZZZ9'},{av:'AV39TFLaboratorioNombre',fld:'vTFLABORATORIONOMBRE',pic:''},{av:'AV40TFLaboratorioNombre_Sel',fld:'vTFLABORATORIONOMBRE_SEL',pic:''},{av:'AV41TFServicioComision',fld:'vTFSERVICIOCOMISION',pic:'ZZZ9'},{av:'AV42TFServicioComision_To',fld:'vTFSERVICIOCOMISION_TO',pic:'ZZZ9'},{av:'AV43TFServicioObservacion',fld:'vTFSERVICIOOBSERVACION',pic:''},{av:'AV44TFServicioObservacion_Sel',fld:'vTFSERVICIOOBSERVACION_SEL',pic:''},{av:'AV46TFServicioEstado_Sels',fld:'vTFSERVICIOESTADO_SELS',pic:''},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV54IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57IsAuthorized_LaboratorioNombre',fld:'vISAUTHORIZED_LABORATORIONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV45TFServicioEstado_SelsJson',fld:'vTFSERVICIOESTADO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_SERVICIOCATEGID","{handler:'valid_Serviciocategid',iparms:[]");
      setEventMetadata("VALID_SERVICIOCATEGID",",oparms:[]}");
      setEventMetadata("VALID_LABORATORIOID","{handler:'valid_Laboratorioid',iparms:[]");
      setEventMetadata("VALID_LABORATORIOID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Servicioestado',iparms:[]");
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
      AV29TFServicioNombre = "" ;
      AV30TFServicioNombre_Sel = "" ;
      AV31TFServicioDescripcion = "" ;
      AV32TFServicioDescripcion_Sel = "" ;
      AV33TFServicioCosto = DecimalUtil.ZERO ;
      AV34TFServicioCosto_To = DecimalUtil.ZERO ;
      AV39TFLaboratorioNombre = "" ;
      AV40TFLaboratorioNombre_Sel = "" ;
      AV43TFServicioObservacion = "" ;
      AV44TFServicioObservacion_Sel = "" ;
      AV46TFServicioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80Pgmname = "" ;
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
      AV47DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45TFServicioEstado_SelsJson = "" ;
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
      AV51Update = "" ;
      AV53Delete = "" ;
      A281ServicioNombre = "" ;
      A282ServicioDescripcion = "" ;
      A283ServicioCosto = DecimalUtil.ZERO ;
      A165LaboratorioNombre = "" ;
      A285ServicioObservacion = "" ;
      A286ServicioEstado = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV79Serviciowwds_20_tfservicioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV60Serviciowwds_1_filterfulltext = "" ;
      lV63Serviciowwds_4_tfservicionombre = "" ;
      lV65Serviciowwds_6_tfserviciodescripcion = "" ;
      lV73Serviciowwds_14_tflaboratorionombre = "" ;
      lV77Serviciowwds_18_tfservicioobservacion = "" ;
      AV60Serviciowwds_1_filterfulltext = "" ;
      AV64Serviciowwds_5_tfservicionombre_sel = "" ;
      AV63Serviciowwds_4_tfservicionombre = "" ;
      AV66Serviciowwds_7_tfserviciodescripcion_sel = "" ;
      AV65Serviciowwds_6_tfserviciodescripcion = "" ;
      AV67Serviciowwds_8_tfserviciocosto = DecimalUtil.ZERO ;
      AV68Serviciowwds_9_tfserviciocosto_to = DecimalUtil.ZERO ;
      AV74Serviciowwds_15_tflaboratorionombre_sel = "" ;
      AV73Serviciowwds_14_tflaboratorionombre = "" ;
      AV78Serviciowwds_19_tfservicioobservacion_sel = "" ;
      AV77Serviciowwds_18_tfservicioobservacion = "" ;
      H002J2_A286ServicioEstado = new String[] {""} ;
      H002J2_A285ServicioObservacion = new String[] {""} ;
      H002J2_A284ServicioComision = new short[1] ;
      H002J2_A165LaboratorioNombre = new String[] {""} ;
      H002J2_A40LaboratorioId = new short[1] ;
      H002J2_A52ServicioCategId = new short[1] ;
      H002J2_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002J2_A282ServicioDescripcion = new String[] {""} ;
      H002J2_A281ServicioNombre = new String[] {""} ;
      H002J2_A27ServicioId = new short[1] ;
      H002J3_AGRID_nRecordCount = new long[1] ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
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
      GXv_boolean2 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char19 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char8 = new String[1] ;
      GXv_SdtWWPGridState20 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.servicioww__default(),
         new Object[] {
             new Object[] {
            H002J2_A286ServicioEstado, H002J2_A285ServicioObservacion, H002J2_A284ServicioComision, H002J2_A165LaboratorioNombre, H002J2_A40LaboratorioId, H002J2_A52ServicioCategId, H002J2_A283ServicioCosto, H002J2_A282ServicioDescripcion, H002J2_A281ServicioNombre, H002J2_A27ServicioId
            }
            , new Object[] {
            H002J3_AGRID_nRecordCount
            }
         }
      );
      AV80Pgmname = "ServicioWW" ;
      /* GeneXus formulas. */
      AV80Pgmname = "ServicioWW" ;
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
   private short AV27TFServicioId ;
   private short AV28TFServicioId_To ;
   private short AV35TFServicioCategId ;
   private short AV36TFServicioCategId_To ;
   private short AV37TFLaboratorioId ;
   private short AV38TFLaboratorioId_To ;
   private short AV41TFServicioComision ;
   private short AV42TFServicioComision_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A27ServicioId ;
   private short A52ServicioCategId ;
   private short A40LaboratorioId ;
   private short A284ServicioComision ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV61Serviciowwds_2_tfservicioid ;
   private short AV62Serviciowwds_3_tfservicioid_to ;
   private short AV69Serviciowwds_10_tfserviciocategid ;
   private short AV70Serviciowwds_11_tfserviciocategid_to ;
   private short AV71Serviciowwds_12_tflaboratorioid ;
   private short AV72Serviciowwds_13_tflaboratorioid_to ;
   private short AV75Serviciowwds_16_tfserviciocomision ;
   private short AV76Serviciowwds_17_tfserviciocomision_to ;
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
   private int edtServicioId_Visible ;
   private int edtServicioNombre_Visible ;
   private int edtServicioDescripcion_Visible ;
   private int edtServicioCosto_Visible ;
   private int edtServicioCategId_Visible ;
   private int edtLaboratorioId_Visible ;
   private int edtLaboratorioNombre_Visible ;
   private int edtServicioComision_Visible ;
   private int edtServicioObservacion_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV79Serviciowwds_20_tfservicioestado_sels_size ;
   private int AV48PageToGo ;
   private int AV81GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV49GridCurrentPage ;
   private long AV50GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV33TFServicioCosto ;
   private java.math.BigDecimal AV34TFServicioCosto_To ;
   private java.math.BigDecimal A283ServicioCosto ;
   private java.math.BigDecimal AV67Serviciowwds_8_tfserviciocosto ;
   private java.math.BigDecimal AV68Serviciowwds_9_tfserviciocosto_to ;
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
   private String AV80Pgmname ;
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
   private String AV51Update ;
   private String edtavUpdate_Link ;
   private String AV53Delete ;
   private String edtavDelete_Link ;
   private String edtServicioNombre_Link ;
   private String edtLaboratorioNombre_Link ;
   private String A286ServicioEstado ;
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
   private String edtServicioId_Internalname ;
   private String edtServicioNombre_Internalname ;
   private String edtServicioDescripcion_Internalname ;
   private String edtServicioCosto_Internalname ;
   private String edtServicioCategId_Internalname ;
   private String edtLaboratorioId_Internalname ;
   private String edtLaboratorioNombre_Internalname ;
   private String edtServicioComision_Internalname ;
   private String edtServicioObservacion_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXt_char18 ;
   private String GXv_char19[] ;
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
   private String edtServicioId_Jsonclick ;
   private String edtServicioNombre_Jsonclick ;
   private String edtServicioDescripcion_Jsonclick ;
   private String edtServicioCosto_Jsonclick ;
   private String edtServicioCategId_Jsonclick ;
   private String edtLaboratorioId_Jsonclick ;
   private String edtLaboratorioNombre_Jsonclick ;
   private String edtServicioComision_Jsonclick ;
   private String edtServicioObservacion_Jsonclick ;
   private String GXCCtl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV52IsAuthorized_Update ;
   private boolean AV54IsAuthorized_Delete ;
   private boolean AV57IsAuthorized_LaboratorioNombre ;
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
   private boolean AV55TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV45TFServicioEstado_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV29TFServicioNombre ;
   private String AV30TFServicioNombre_Sel ;
   private String AV31TFServicioDescripcion ;
   private String AV32TFServicioDescripcion_Sel ;
   private String AV39TFLaboratorioNombre ;
   private String AV40TFLaboratorioNombre_Sel ;
   private String AV43TFServicioObservacion ;
   private String AV44TFServicioObservacion_Sel ;
   private String A281ServicioNombre ;
   private String A282ServicioDescripcion ;
   private String A165LaboratorioNombre ;
   private String A285ServicioObservacion ;
   private String lV60Serviciowwds_1_filterfulltext ;
   private String lV63Serviciowwds_4_tfservicionombre ;
   private String lV65Serviciowwds_6_tfserviciodescripcion ;
   private String lV73Serviciowwds_14_tflaboratorionombre ;
   private String lV77Serviciowwds_18_tfservicioobservacion ;
   private String AV60Serviciowwds_1_filterfulltext ;
   private String AV64Serviciowwds_5_tfservicionombre_sel ;
   private String AV63Serviciowwds_4_tfservicionombre ;
   private String AV66Serviciowwds_7_tfserviciodescripcion_sel ;
   private String AV65Serviciowwds_6_tfserviciodescripcion ;
   private String AV74Serviciowwds_15_tflaboratorionombre_sel ;
   private String AV73Serviciowwds_14_tflaboratorionombre ;
   private String AV78Serviciowwds_19_tfservicioobservacion_sel ;
   private String AV77Serviciowwds_18_tfservicioobservacion ;
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
   private GXSimpleCollection<String> AV79Serviciowwds_20_tfservicioestado_sels ;
   private HTMLChoice cmbServicioEstado ;
   private IDataStoreProvider pr_default ;
   private String[] H002J2_A286ServicioEstado ;
   private String[] H002J2_A285ServicioObservacion ;
   private short[] H002J2_A284ServicioComision ;
   private String[] H002J2_A165LaboratorioNombre ;
   private short[] H002J2_A40LaboratorioId ;
   private short[] H002J2_A52ServicioCategId ;
   private java.math.BigDecimal[] H002J2_A283ServicioCosto ;
   private String[] H002J2_A282ServicioDescripcion ;
   private String[] H002J2_A281ServicioNombre ;
   private short[] H002J2_A27ServicioId ;
   private long[] H002J3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV46TFServicioEstado_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState20[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV47DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class servicioww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002J2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV79Serviciowwds_20_tfservicioestado_sels ,
                                          String AV60Serviciowwds_1_filterfulltext ,
                                          short AV61Serviciowwds_2_tfservicioid ,
                                          short AV62Serviciowwds_3_tfservicioid_to ,
                                          String AV64Serviciowwds_5_tfservicionombre_sel ,
                                          String AV63Serviciowwds_4_tfservicionombre ,
                                          String AV66Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV65Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV67Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV68Serviciowwds_9_tfserviciocosto_to ,
                                          short AV69Serviciowwds_10_tfserviciocategid ,
                                          short AV70Serviciowwds_11_tfserviciocategid_to ,
                                          short AV71Serviciowwds_12_tflaboratorioid ,
                                          short AV72Serviciowwds_13_tflaboratorioid_to ,
                                          String AV74Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV73Serviciowwds_14_tflaboratorionombre ,
                                          short AV75Serviciowwds_16_tfserviciocomision ,
                                          short AV76Serviciowwds_17_tfserviciocomision_to ,
                                          String AV78Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV77Serviciowwds_18_tfservicioobservacion ,
                                          int AV79Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[32];
      Object[] GXv_Object22 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[ServicioEstado], T1.[ServicioObservacion], T1.[ServicioComision], T3.[LaboratorioNombre], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioDescripcion]," ;
      sSelectString += " T1.[ServicioNombre], T1.[ServicioId]" ;
      sFromString = " FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio] T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV60Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
         GXv_int21[9] = (byte)(1) ;
         GXv_int21[10] = (byte)(1) ;
      }
      if ( ! (0==AV61Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int21[11] = (byte)(1) ;
      }
      if ( ! (0==AV62Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int21[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV63Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int21[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int21[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV65Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int21[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int21[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int21[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int21[18] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int21[19] = (byte)(1) ;
      }
      if ( ! (0==AV70Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int21[20] = (byte)(1) ;
      }
      if ( ! (0==AV71Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int21[21] = (byte)(1) ;
      }
      if ( ! (0==AV72Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int21[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV73Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int21[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int21[24] = (byte)(1) ;
      }
      if ( ! (0==AV75Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int21[25] = (byte)(1) ;
      }
      if ( ! (0==AV76Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int21[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV78Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV77Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int21[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV78Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int21[28] = (byte)(1) ;
      }
      if ( AV79Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioNombre]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioDescripcion]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioDescripcion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioCosto]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioCosto] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioCategId]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioCategId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[LaboratorioId]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[LaboratorioId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[LaboratorioNombre]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[LaboratorioNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioComision]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioComision] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioObservacion]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioObservacion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ServicioEstado]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ServicioEstado] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[ServicioId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_H002J3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV79Serviciowwds_20_tfservicioestado_sels ,
                                          String AV60Serviciowwds_1_filterfulltext ,
                                          short AV61Serviciowwds_2_tfservicioid ,
                                          short AV62Serviciowwds_3_tfservicioid_to ,
                                          String AV64Serviciowwds_5_tfservicionombre_sel ,
                                          String AV63Serviciowwds_4_tfservicionombre ,
                                          String AV66Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV65Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV67Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV68Serviciowwds_9_tfserviciocosto_to ,
                                          short AV69Serviciowwds_10_tfserviciocategid ,
                                          short AV70Serviciowwds_11_tfserviciocategid_to ,
                                          short AV71Serviciowwds_12_tflaboratorioid ,
                                          short AV72Serviciowwds_13_tflaboratorioid_to ,
                                          String AV74Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV73Serviciowwds_14_tflaboratorionombre ,
                                          short AV75Serviciowwds_16_tfserviciocomision ,
                                          short AV76Serviciowwds_17_tfserviciocomision_to ,
                                          String AV78Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV77Serviciowwds_18_tfservicioobservacion ,
                                          int AV79Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[29];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio] T3 ON T3.[LaboratorioId]" ;
      scmdbuf += " = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV60Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
         GXv_int24[9] = (byte)(1) ;
         GXv_int24[10] = (byte)(1) ;
      }
      if ( ! (0==AV61Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int24[11] = (byte)(1) ;
      }
      if ( ! (0==AV62Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int24[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV63Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int24[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int24[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV65Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int24[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int24[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int24[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int24[18] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int24[19] = (byte)(1) ;
      }
      if ( ! (0==AV70Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int24[20] = (byte)(1) ;
      }
      if ( ! (0==AV71Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int24[21] = (byte)(1) ;
      }
      if ( ! (0==AV72Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int24[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV73Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int24[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int24[24] = (byte)(1) ;
      }
      if ( ! (0==AV75Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int24[25] = (byte)(1) ;
      }
      if ( ! (0==AV76Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int24[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV78Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV77Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int24[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV78Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int24[28] = (byte)(1) ;
      }
      if ( AV79Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV79Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
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
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
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
                  return conditional_H002J2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
            case 1 :
                  return conditional_H002J3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002J2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002J3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[49], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[50], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[52]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[53]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[57]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[63]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
      }
   }

}

