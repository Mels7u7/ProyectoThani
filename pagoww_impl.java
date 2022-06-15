package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pagoww_impl extends GXDataArea
{
   public pagoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pagoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagoww_impl.class ));
   }

   public pagoww_impl( int remoteHandle ,
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
            AV27TFPagoId = (int)(GXutil.lval( httpContext.GetPar( "TFPagoId"))) ;
            AV28TFPagoId_To = (int)(GXutil.lval( httpContext.GetPar( "TFPagoId_To"))) ;
            AV29TFCitaId = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId"))) ;
            AV30TFCitaId_To = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId_To"))) ;
            AV31TFCitaCode = httpContext.GetPar( "TFCitaCode") ;
            AV32TFCitaCode_Sel = httpContext.GetPar( "TFCitaCode_Sel") ;
            AV33TFSGCitaDisponibilidadFecha = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha")) ;
            AV34TFSGCitaDisponibilidadFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha_To")) ;
            AV37TFPagoMonto = CommonUtil.decimalVal( httpContext.GetPar( "TFPagoMonto"), ".") ;
            AV38TFPagoMonto_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPagoMonto_To"), ".") ;
            AV39TFPagoToken = httpContext.GetPar( "TFPagoToken") ;
            AV40TFPagoToken_Sel = httpContext.GetPar( "TFPagoToken_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV42TFPagoTipoDocumentoCliente_Sels);
            AV43TFPagoClienteNroDocumento = httpContext.GetPar( "TFPagoClienteNroDocumento") ;
            AV44TFPagoClienteNroDocumento_Sel = httpContext.GetPar( "TFPagoClienteNroDocumento_Sel") ;
            AV45TFPagoClienteDenominacion = httpContext.GetPar( "TFPagoClienteDenominacion") ;
            AV46TFPagoClienteDenominacion_Sel = httpContext.GetPar( "TFPagoClienteDenominacion_Sel") ;
            AV47TFPagoClienteDireccion = httpContext.GetPar( "TFPagoClienteDireccion") ;
            AV48TFPagoClienteDireccion_Sel = httpContext.GetPar( "TFPagoClienteDireccion_Sel") ;
            AV49TFPagoClienteEmail = httpContext.GetPar( "TFPagoClienteEmail") ;
            AV50TFPagoClienteEmail_Sel = httpContext.GetPar( "TFPagoClienteEmail_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV52TFPagoTipoDocumento_Sels);
            AV53TFPagoNumero = (int)(GXutil.lval( httpContext.GetPar( "TFPagoNumero"))) ;
            AV54TFPagoNumero_To = (int)(GXutil.lval( httpContext.GetPar( "TFPagoNumero_To"))) ;
            AV55TFPagoFechaEmision = localUtil.parseDateParm( httpContext.GetPar( "TFPagoFechaEmision")) ;
            AV56TFPagoFechaEmision_To = localUtil.parseDateParm( httpContext.GetPar( "TFPagoFechaEmision_To")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60TFPagoMoneda_Sels);
            AV67TFPagoNubefactRequest = httpContext.GetPar( "TFPagoNubefactRequest") ;
            AV68TFPagoNubefactRequest_Sel = httpContext.GetPar( "TFPagoNubefactRequest_Sel") ;
            AV69TFPagoNubefactResponse = httpContext.GetPar( "TFPagoNubefactResponse") ;
            AV70TFPagoNubefactResponse_Sel = httpContext.GetPar( "TFPagoNubefactResponse_Sel") ;
            AV86TFPagoRequest = httpContext.GetPar( "TFPagoRequest") ;
            AV87TFPagoRequest_Sel = httpContext.GetPar( "TFPagoRequest_Sel") ;
            AV88TFPagoResponse = httpContext.GetPar( "TFPagoResponse") ;
            AV89TFPagoResponse_Sel = httpContext.GetPar( "TFPagoResponse_Sel") ;
            AV90TFPagoPasarelaId = httpContext.GetPar( "TFPagoPasarelaId") ;
            AV91TFPagoPasarelaId_Sel = httpContext.GetPar( "TFPagoPasarelaId_Sel") ;
            AV92TFPagoStatusCode = (int)(GXutil.lval( httpContext.GetPar( "TFPagoStatusCode"))) ;
            AV93TFPagoStatusCode_To = (int)(GXutil.lval( httpContext.GetPar( "TFPagoStatusCode_To"))) ;
            AV94TFDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "TFDisponibilidadId"))) ;
            AV95TFDisponibilidadId_To = (int)(GXutil.lval( httpContext.GetPar( "TFDisponibilidadId_To"))) ;
            AV96TFPagoEnlacePDF = httpContext.GetPar( "TFPagoEnlacePDF") ;
            AV97TFPagoEnlacePDF_Sel = httpContext.GetPar( "TFPagoEnlacePDF_Sel") ;
            AV98TFPagoEnlaceXML = httpContext.GetPar( "TFPagoEnlaceXML") ;
            AV99TFPagoEnlaceXML_Sel = httpContext.GetPar( "TFPagoEnlaceXML_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV72TFPagoEstadoR_Sels);
            AV149Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV78IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV80IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV83IsAuthorized_CitaCode = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_CitaCode")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPagoId, AV28TFPagoId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFCitaCode, AV32TFCitaCode_Sel, AV33TFSGCitaDisponibilidadFecha, AV34TFSGCitaDisponibilidadFecha_To, AV37TFPagoMonto, AV38TFPagoMonto_To, AV39TFPagoToken, AV40TFPagoToken_Sel, AV42TFPagoTipoDocumentoCliente_Sels, AV43TFPagoClienteNroDocumento, AV44TFPagoClienteNroDocumento_Sel, AV45TFPagoClienteDenominacion, AV46TFPagoClienteDenominacion_Sel, AV47TFPagoClienteDireccion, AV48TFPagoClienteDireccion_Sel, AV49TFPagoClienteEmail, AV50TFPagoClienteEmail_Sel, AV52TFPagoTipoDocumento_Sels, AV53TFPagoNumero, AV54TFPagoNumero_To, AV55TFPagoFechaEmision, AV56TFPagoFechaEmision_To, AV60TFPagoMoneda_Sels, AV67TFPagoNubefactRequest, AV68TFPagoNubefactRequest_Sel, AV69TFPagoNubefactResponse, AV70TFPagoNubefactResponse_Sel, AV86TFPagoRequest, AV87TFPagoRequest_Sel, AV88TFPagoResponse, AV89TFPagoResponse_Sel, AV90TFPagoPasarelaId, AV91TFPagoPasarelaId_Sel, AV92TFPagoStatusCode, AV93TFPagoStatusCode_To, AV94TFDisponibilidadId, AV95TFDisponibilidadId_To, AV96TFPagoEnlacePDF, AV97TFPagoEnlacePDF_Sel, AV98TFPagoEnlaceXML, AV99TFPagoEnlaceXML_Sel, AV72TFPagoEstadoR_Sels, AV149Pgmname, AV13OrderedBy, AV14OrderedDsc, AV78IsAuthorized_Update, AV80IsAuthorized_Delete, AV83IsAuthorized_CitaCode) ;
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
      pa262( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start262( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110333825", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pagoww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV149Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV78IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV80IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CITACODE", getSecureSignedToken( "", AV83IsAuthorized_CitaCode));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV75GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV76GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV73DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV73DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO", localUtil.dtoc( AV36DDO_SGCitaDisponibilidadFechaAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PAGOFECHAEMISIONAUXDATETO", localUtil.dtoc( AV58DDO_PagoFechaEmisionAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOID", GXutil.ltrim( localUtil.ntoc( AV27TFPagoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFPagoId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID", GXutil.ltrim( localUtil.ntoc( AV29TFCitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID_TO", GXutil.ltrim( localUtil.ntoc( AV30TFCitaId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITACODE", AV31TFCitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITACODE_SEL", AV32TFCitaCode_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA", localUtil.dtoc( AV33TFSGCitaDisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA_TO", localUtil.dtoc( AV34TFSGCitaDisponibilidadFecha_To, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOMONTO", GXutil.ltrim( localUtil.ntoc( AV37TFPagoMonto, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOMONTO_TO", GXutil.ltrim( localUtil.ntoc( AV38TFPagoMonto_To, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOTOKEN", AV39TFPagoToken);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOTOKEN_SEL", AV40TFPagoToken_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAGOTIPODOCUMENTOCLIENTE_SELS", AV42TFPagoTipoDocumentoCliente_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAGOTIPODOCUMENTOCLIENTE_SELS", AV42TFPagoTipoDocumentoCliente_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTENRODOCUMENTO", AV43TFPagoClienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTENRODOCUMENTO_SEL", AV44TFPagoClienteNroDocumento_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTEDENOMINACION", AV45TFPagoClienteDenominacion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTEDENOMINACION_SEL", AV46TFPagoClienteDenominacion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTEDIRECCION", AV47TFPagoClienteDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTEDIRECCION_SEL", AV48TFPagoClienteDireccion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTEEMAIL", AV49TFPagoClienteEmail);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOCLIENTEEMAIL_SEL", AV50TFPagoClienteEmail_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAGOTIPODOCUMENTO_SELS", AV52TFPagoTipoDocumento_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAGOTIPODOCUMENTO_SELS", AV52TFPagoTipoDocumento_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGONUMERO", GXutil.ltrim( localUtil.ntoc( AV53TFPagoNumero, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGONUMERO_TO", GXutil.ltrim( localUtil.ntoc( AV54TFPagoNumero_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOFECHAEMISION", localUtil.dtoc( AV55TFPagoFechaEmision, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOFECHAEMISION_TO", localUtil.dtoc( AV56TFPagoFechaEmision_To, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAGOMONEDA_SELS", AV60TFPagoMoneda_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAGOMONEDA_SELS", AV60TFPagoMoneda_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGONUBEFACTREQUEST", AV67TFPagoNubefactRequest);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGONUBEFACTREQUEST_SEL", AV68TFPagoNubefactRequest_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGONUBEFACTRESPONSE", AV69TFPagoNubefactResponse);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGONUBEFACTRESPONSE_SEL", AV70TFPagoNubefactResponse_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOREQUEST", AV86TFPagoRequest);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOREQUEST_SEL", AV87TFPagoRequest_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGORESPONSE", AV88TFPagoResponse);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGORESPONSE_SEL", AV89TFPagoResponse_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOPASARELAID", AV90TFPagoPasarelaId);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOPASARELAID_SEL", AV91TFPagoPasarelaId_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOSTATUSCODE", GXutil.ltrim( localUtil.ntoc( AV92TFPagoStatusCode, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOSTATUSCODE_TO", GXutil.ltrim( localUtil.ntoc( AV93TFPagoStatusCode_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV94TFDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV95TFDisponibilidadId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOENLACEPDF", AV96TFPagoEnlacePDF);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOENLACEPDF_SEL", AV97TFPagoEnlacePDF_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOENLACEXML", AV98TFPagoEnlaceXML);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOENLACEXML_SEL", AV99TFPagoEnlaceXML_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAGOESTADOR_SELS", AV72TFPagoEstadoR_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAGOESTADOR_SELS", AV72TFPagoEstadoR_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV149Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV149Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV78IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV78IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV80IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV80IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_CITACODE", AV83IsAuthorized_CitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CITACODE", getSecureSignedToken( "", AV83IsAuthorized_CitaCode));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON", AV41TFPagoTipoDocumentoCliente_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOTIPODOCUMENTO_SELSJSON", AV51TFPagoTipoDocumento_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOMONEDA_SELSJSON", AV59TFPagoMoneda_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAGOESTADOR_SELSJSON", AV71TFPagoEstadoR_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE", localUtil.dtoc( AV35DDO_SGCitaDisponibilidadFechaAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PAGOFECHAEMISIONAUXDATE", localUtil.dtoc( AV57DDO_PagoFechaEmisionAuxDate, 0, "/"));
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
         we262( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt262( ) ;
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
      return formatLink("com.projectthani.pagoww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "PagoWW" ;
   }

   public String getPgmdesc( )
   {
      return " Pago" ;
   }

   public void wb260( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PagoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PagoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PagoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PagoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_262( true) ;
      }
      else
      {
         wb_table1_25_262( false) ;
      }
      return  ;
   }

   public void wb_table1_25_262e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cita Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cita Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoMonto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Monto") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoToken_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Token") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPagoTipoDocumentoCliente.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Documento Cliente") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoClienteNroDocumento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoClienteDenominacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cliente Denominacion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoClienteDireccion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cliente Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoClienteEmail_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cliente Email") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPagoTipoDocumento.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoNumero_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Numero") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoFechaEmision_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Emision") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPagoMoneda.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Moneda") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoNubefactRequest_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nubefact Request") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoNubefactResponse_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nubefact Response") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoRequest_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Request") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoResponse_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Response") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoPasarelaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Pasarela Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoStatusCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Status Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Disponibilidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoEnlacePDF_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Enlace PDF") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtPagoEnlaceXML_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Enlace XML") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPagoEstadoR.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV77Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV79Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A64CitaCode);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCitaCode_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadFecha_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPagoMonto_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoMonto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A243PagoToken);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoToken_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A247PagoTipoDocumentoCliente));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPagoTipoDocumentoCliente.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A248PagoClienteNroDocumento);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoClienteNroDocumento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A249PagoClienteDenominacion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoClienteDenominacion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A250PagoClienteDireccion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoClienteDireccion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A251PagoClienteEmail);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoClienteEmail_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A244PagoTipoDocumento, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPagoTipoDocumento.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A245PagoNumero, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoNumero_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoFechaEmision_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A253PagoMoneda, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPagoMoneda.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A256PagoNubefactRequest);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoNubefactRequest_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A257PagoNubefactResponse);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoNubefactResponse_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A308PagoRequest);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoRequest_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A309PagoResponse);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoResponse_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A310PagoPasarelaId);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoPasarelaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A311PagoStatusCode, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoStatusCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A338PagoEnlacePDF);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPagoEnlacePDF_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtPagoEnlacePDF_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoEnlacePDF_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A339PagoEnlaceXML);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPagoEnlaceXML_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtPagoEnlaceXML_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPagoEnlaceXML_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A246PagoEstadoR));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPagoEstadoR.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV75GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV76GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV73DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV73DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname, AV84DDO_SGCitaDisponibilidadFechaAuxDateText, GXutil.rtrim( localUtil.format( AV84DDO_SGCitaDisponibilidadFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoWW.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("Start Date", AV35DDO_SGCitaDisponibilidadFechaAuxDate);
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("End Date", AV36DDO_SGCitaDisponibilidadFechaAuxDateTo);
         ucTfsgcitadisponibilidadfecha_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadfecha_rangepicker_Internalname, "TFSGCITADISPONIBILIDADFECHA_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_pagofechaemisionauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_pagofechaemisionauxdatetext_Internalname, AV85DDO_PagoFechaEmisionAuxDateText, GXutil.rtrim( localUtil.format( AV85DDO_PagoFechaEmisionAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_pagofechaemisionauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoWW.htm");
         /* User Defined Control */
         ucTfpagofechaemision_rangepicker.setProperty("Start Date", AV57DDO_PagoFechaEmisionAuxDate);
         ucTfpagofechaemision_rangepicker.setProperty("End Date", AV58DDO_PagoFechaEmisionAuxDateTo);
         ucTfpagofechaemision_rangepicker.render(context, "wwp.daterangepicker", Tfpagofechaemision_rangepicker_Internalname, "TFPAGOFECHAEMISION_RANGEPICKERContainer");
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

   public void start262( )
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
         Form.getMeta().addItem("description", " Pago", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup260( ) ;
   }

   public void ws262( )
   {
      start262( ) ;
      evt262( ) ;
   }

   public void evt262( )
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
                           e11262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e18262 ();
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
                           AV77Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV77Update);
                           AV79Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV79Delete);
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
                                 e19262 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20262 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21262 ();
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

   public void we262( )
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

   public void pa262( )
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
                                 int AV27TFPagoId ,
                                 int AV28TFPagoId_To ,
                                 int AV29TFCitaId ,
                                 int AV30TFCitaId_To ,
                                 String AV31TFCitaCode ,
                                 String AV32TFCitaCode_Sel ,
                                 java.util.Date AV33TFSGCitaDisponibilidadFecha ,
                                 java.util.Date AV34TFSGCitaDisponibilidadFecha_To ,
                                 java.math.BigDecimal AV37TFPagoMonto ,
                                 java.math.BigDecimal AV38TFPagoMonto_To ,
                                 String AV39TFPagoToken ,
                                 String AV40TFPagoToken_Sel ,
                                 GXSimpleCollection<String> AV42TFPagoTipoDocumentoCliente_Sels ,
                                 String AV43TFPagoClienteNroDocumento ,
                                 String AV44TFPagoClienteNroDocumento_Sel ,
                                 String AV45TFPagoClienteDenominacion ,
                                 String AV46TFPagoClienteDenominacion_Sel ,
                                 String AV47TFPagoClienteDireccion ,
                                 String AV48TFPagoClienteDireccion_Sel ,
                                 String AV49TFPagoClienteEmail ,
                                 String AV50TFPagoClienteEmail_Sel ,
                                 GXSimpleCollection<Short> AV52TFPagoTipoDocumento_Sels ,
                                 int AV53TFPagoNumero ,
                                 int AV54TFPagoNumero_To ,
                                 java.util.Date AV55TFPagoFechaEmision ,
                                 java.util.Date AV56TFPagoFechaEmision_To ,
                                 GXSimpleCollection<Short> AV60TFPagoMoneda_Sels ,
                                 String AV67TFPagoNubefactRequest ,
                                 String AV68TFPagoNubefactRequest_Sel ,
                                 String AV69TFPagoNubefactResponse ,
                                 String AV70TFPagoNubefactResponse_Sel ,
                                 String AV86TFPagoRequest ,
                                 String AV87TFPagoRequest_Sel ,
                                 String AV88TFPagoResponse ,
                                 String AV89TFPagoResponse_Sel ,
                                 String AV90TFPagoPasarelaId ,
                                 String AV91TFPagoPasarelaId_Sel ,
                                 int AV92TFPagoStatusCode ,
                                 int AV93TFPagoStatusCode_To ,
                                 int AV94TFDisponibilidadId ,
                                 int AV95TFDisponibilidadId_To ,
                                 String AV96TFPagoEnlacePDF ,
                                 String AV97TFPagoEnlacePDF_Sel ,
                                 String AV98TFPagoEnlaceXML ,
                                 String AV99TFPagoEnlaceXML_Sel ,
                                 GXSimpleCollection<String> AV72TFPagoEstadoR_Sels ,
                                 String AV149Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV78IsAuthorized_Update ,
                                 boolean AV80IsAuthorized_Delete ,
                                 boolean AV83IsAuthorized_CitaCode )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20262 ();
      GRID_nCurrentRecord = 0 ;
      rf262( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAGOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PAGOID", GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ".", "")));
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
      rf262( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV149Pgmname = "PagoWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf262( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e20262 ();
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
                                              A247PagoTipoDocumentoCliente ,
                                              AV115Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                              Short.valueOf(A244PagoTipoDocumento) ,
                                              AV124Pagowwds_23_tfpagotipodocumento_sels ,
                                              Short.valueOf(A253PagoMoneda) ,
                                              AV129Pagowwds_28_tfpagomoneda_sels ,
                                              A246PagoEstadoR ,
                                              AV148Pagowwds_47_tfpagoestador_sels ,
                                              AV102Pagowwds_1_filterfulltext ,
                                              Integer.valueOf(AV103Pagowwds_2_tfpagoid) ,
                                              Integer.valueOf(AV104Pagowwds_3_tfpagoid_to) ,
                                              Integer.valueOf(AV105Pagowwds_4_tfcitaid) ,
                                              Integer.valueOf(AV106Pagowwds_5_tfcitaid_to) ,
                                              AV108Pagowwds_7_tfcitacode_sel ,
                                              AV107Pagowwds_6_tfcitacode ,
                                              AV109Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                              AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                              AV111Pagowwds_10_tfpagomonto ,
                                              AV112Pagowwds_11_tfpagomonto_to ,
                                              AV114Pagowwds_13_tfpagotoken_sel ,
                                              AV113Pagowwds_12_tfpagotoken ,
                                              Integer.valueOf(AV115Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                              AV117Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                              AV116Pagowwds_15_tfpagoclientenrodocumento ,
                                              AV119Pagowwds_18_tfpagoclientedenominacion_sel ,
                                              AV118Pagowwds_17_tfpagoclientedenominacion ,
                                              AV121Pagowwds_20_tfpagoclientedireccion_sel ,
                                              AV120Pagowwds_19_tfpagoclientedireccion ,
                                              AV123Pagowwds_22_tfpagoclienteemail_sel ,
                                              AV122Pagowwds_21_tfpagoclienteemail ,
                                              Integer.valueOf(AV124Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                              Integer.valueOf(AV125Pagowwds_24_tfpagonumero) ,
                                              Integer.valueOf(AV126Pagowwds_25_tfpagonumero_to) ,
                                              AV127Pagowwds_26_tfpagofechaemision ,
                                              AV128Pagowwds_27_tfpagofechaemision_to ,
                                              Integer.valueOf(AV129Pagowwds_28_tfpagomoneda_sels.size()) ,
                                              AV131Pagowwds_30_tfpagonubefactrequest_sel ,
                                              AV130Pagowwds_29_tfpagonubefactrequest ,
                                              AV133Pagowwds_32_tfpagonubefactresponse_sel ,
                                              AV132Pagowwds_31_tfpagonubefactresponse ,
                                              AV135Pagowwds_34_tfpagorequest_sel ,
                                              AV134Pagowwds_33_tfpagorequest ,
                                              AV137Pagowwds_36_tfpagoresponse_sel ,
                                              AV136Pagowwds_35_tfpagoresponse ,
                                              AV139Pagowwds_38_tfpagopasarelaid_sel ,
                                              AV138Pagowwds_37_tfpagopasarelaid ,
                                              Integer.valueOf(AV140Pagowwds_39_tfpagostatuscode) ,
                                              Integer.valueOf(AV141Pagowwds_40_tfpagostatuscode_to) ,
                                              Integer.valueOf(AV142Pagowwds_41_tfdisponibilidadid) ,
                                              Integer.valueOf(AV143Pagowwds_42_tfdisponibilidadid_to) ,
                                              AV145Pagowwds_44_tfpagoenlacepdf_sel ,
                                              AV144Pagowwds_43_tfpagoenlacepdf ,
                                              AV147Pagowwds_46_tfpagoenlacexml_sel ,
                                              AV146Pagowwds_45_tfpagoenlacexml ,
                                              Integer.valueOf(AV148Pagowwds_47_tfpagoestador_sels.size()) ,
                                              Integer.valueOf(A47PagoId) ,
                                              Integer.valueOf(A19CitaId) ,
                                              A64CitaCode ,
                                              A242PagoMonto ,
                                              A243PagoToken ,
                                              A248PagoClienteNroDocumento ,
                                              A249PagoClienteDenominacion ,
                                              A250PagoClienteDireccion ,
                                              A251PagoClienteEmail ,
                                              Integer.valueOf(A245PagoNumero) ,
                                              A256PagoNubefactRequest ,
                                              A257PagoNubefactResponse ,
                                              A308PagoRequest ,
                                              A309PagoResponse ,
                                              A310PagoPasarelaId ,
                                              Integer.valueOf(A311PagoStatusCode) ,
                                              Integer.valueOf(A34DisponibilidadId) ,
                                              A338PagoEnlacePDF ,
                                              A339PagoEnlaceXML ,
                                              A66SGCitaDisponibilidadFecha ,
                                              A252PagoFechaEmision ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
         lV107Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV107Pagowwds_6_tfcitacode), "%", "") ;
         lV113Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV113Pagowwds_12_tfpagotoken), "%", "") ;
         lV116Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV116Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
         lV118Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV118Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
         lV120Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV120Pagowwds_19_tfpagoclientedireccion), "%", "") ;
         lV122Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV122Pagowwds_21_tfpagoclienteemail), "%", "") ;
         lV130Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV130Pagowwds_29_tfpagonubefactrequest), "%", "") ;
         lV132Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV132Pagowwds_31_tfpagonubefactresponse), "%", "") ;
         lV134Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV134Pagowwds_33_tfpagorequest), "%", "") ;
         lV136Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV136Pagowwds_35_tfpagoresponse), "%", "") ;
         lV138Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV138Pagowwds_37_tfpagopasarelaid), "%", "") ;
         lV144Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV144Pagowwds_43_tfpagoenlacepdf), "%", "") ;
         lV146Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV146Pagowwds_45_tfpagoenlacexml), "%", "") ;
         /* Using cursor H00262 */
         pr_default.execute(0, new Object[] {lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, Integer.valueOf(AV103Pagowwds_2_tfpagoid), Integer.valueOf(AV104Pagowwds_3_tfpagoid_to), Integer.valueOf(AV105Pagowwds_4_tfcitaid), Integer.valueOf(AV106Pagowwds_5_tfcitaid_to), lV107Pagowwds_6_tfcitacode, AV108Pagowwds_7_tfcitacode_sel, AV109Pagowwds_8_tfsgcitadisponibilidadfecha, AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV111Pagowwds_10_tfpagomonto, AV112Pagowwds_11_tfpagomonto_to, lV113Pagowwds_12_tfpagotoken, AV114Pagowwds_13_tfpagotoken_sel, lV116Pagowwds_15_tfpagoclientenrodocumento, AV117Pagowwds_16_tfpagoclientenrodocumento_sel, lV118Pagowwds_17_tfpagoclientedenominacion, AV119Pagowwds_18_tfpagoclientedenominacion_sel, lV120Pagowwds_19_tfpagoclientedireccion, AV121Pagowwds_20_tfpagoclientedireccion_sel, lV122Pagowwds_21_tfpagoclienteemail, AV123Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV125Pagowwds_24_tfpagonumero), Integer.valueOf(AV126Pagowwds_25_tfpagonumero_to), AV127Pagowwds_26_tfpagofechaemision, AV128Pagowwds_27_tfpagofechaemision_to, lV130Pagowwds_29_tfpagonubefactrequest, AV131Pagowwds_30_tfpagonubefactrequest_sel, lV132Pagowwds_31_tfpagonubefactresponse, AV133Pagowwds_32_tfpagonubefactresponse_sel, lV134Pagowwds_33_tfpagorequest, AV135Pagowwds_34_tfpagorequest_sel, lV136Pagowwds_35_tfpagoresponse, AV137Pagowwds_36_tfpagoresponse_sel, lV138Pagowwds_37_tfpagopasarelaid, AV139Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV140Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV141Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV142Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV143Pagowwds_42_tfdisponibilidadid_to), lV144Pagowwds_43_tfpagoenlacepdf, AV145Pagowwds_44_tfpagoenlacepdf_sel, lV146Pagowwds_45_tfpagoenlacexml, AV147Pagowwds_46_tfpagoenlacexml_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A21SGCitaDisponibilidadId = H00262_A21SGCitaDisponibilidadId[0] ;
            A246PagoEstadoR = H00262_A246PagoEstadoR[0] ;
            A339PagoEnlaceXML = H00262_A339PagoEnlaceXML[0] ;
            A338PagoEnlacePDF = H00262_A338PagoEnlacePDF[0] ;
            A34DisponibilidadId = H00262_A34DisponibilidadId[0] ;
            n34DisponibilidadId = H00262_n34DisponibilidadId[0] ;
            A311PagoStatusCode = H00262_A311PagoStatusCode[0] ;
            A310PagoPasarelaId = H00262_A310PagoPasarelaId[0] ;
            A309PagoResponse = H00262_A309PagoResponse[0] ;
            A308PagoRequest = H00262_A308PagoRequest[0] ;
            A257PagoNubefactResponse = H00262_A257PagoNubefactResponse[0] ;
            A256PagoNubefactRequest = H00262_A256PagoNubefactRequest[0] ;
            A253PagoMoneda = H00262_A253PagoMoneda[0] ;
            A252PagoFechaEmision = H00262_A252PagoFechaEmision[0] ;
            A245PagoNumero = H00262_A245PagoNumero[0] ;
            A244PagoTipoDocumento = H00262_A244PagoTipoDocumento[0] ;
            A251PagoClienteEmail = H00262_A251PagoClienteEmail[0] ;
            A250PagoClienteDireccion = H00262_A250PagoClienteDireccion[0] ;
            A249PagoClienteDenominacion = H00262_A249PagoClienteDenominacion[0] ;
            A248PagoClienteNroDocumento = H00262_A248PagoClienteNroDocumento[0] ;
            A247PagoTipoDocumentoCliente = H00262_A247PagoTipoDocumentoCliente[0] ;
            A243PagoToken = H00262_A243PagoToken[0] ;
            A242PagoMonto = H00262_A242PagoMonto[0] ;
            A66SGCitaDisponibilidadFecha = H00262_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H00262_n66SGCitaDisponibilidadFecha[0] ;
            A64CitaCode = H00262_A64CitaCode[0] ;
            A19CitaId = H00262_A19CitaId[0] ;
            n19CitaId = H00262_n19CitaId[0] ;
            A47PagoId = H00262_A47PagoId[0] ;
            A21SGCitaDisponibilidadId = H00262_A21SGCitaDisponibilidadId[0] ;
            A64CitaCode = H00262_A64CitaCode[0] ;
            A66SGCitaDisponibilidadFecha = H00262_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H00262_n66SGCitaDisponibilidadFecha[0] ;
            e21262 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb260( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes262( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV149Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV149Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV78IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV78IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV80IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV80IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_CITACODE", AV83IsAuthorized_CitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CITACODE", getSecureSignedToken( "", AV83IsAuthorized_CitaCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PAGOID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9")));
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
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV115Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV124Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV129Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV148Pagowwds_47_tfpagoestador_sels ,
                                           AV102Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV103Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV104Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV105Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV106Pagowwds_5_tfcitaid_to) ,
                                           AV108Pagowwds_7_tfcitacode_sel ,
                                           AV107Pagowwds_6_tfcitacode ,
                                           AV109Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV111Pagowwds_10_tfpagomonto ,
                                           AV112Pagowwds_11_tfpagomonto_to ,
                                           AV114Pagowwds_13_tfpagotoken_sel ,
                                           AV113Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV115Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV117Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV116Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV119Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV118Pagowwds_17_tfpagoclientedenominacion ,
                                           AV121Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV120Pagowwds_19_tfpagoclientedireccion ,
                                           AV123Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV122Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV124Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV125Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV126Pagowwds_25_tfpagonumero_to) ,
                                           AV127Pagowwds_26_tfpagofechaemision ,
                                           AV128Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV129Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV131Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV130Pagowwds_29_tfpagonubefactrequest ,
                                           AV133Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV132Pagowwds_31_tfpagonubefactresponse ,
                                           AV135Pagowwds_34_tfpagorequest_sel ,
                                           AV134Pagowwds_33_tfpagorequest ,
                                           AV137Pagowwds_36_tfpagoresponse_sel ,
                                           AV136Pagowwds_35_tfpagoresponse ,
                                           AV139Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV138Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV140Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV141Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV142Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV143Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV145Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV144Pagowwds_43_tfpagoenlacepdf ,
                                           AV147Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV146Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV148Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV102Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV102Pagowwds_1_filterfulltext), "%", "") ;
      lV107Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV107Pagowwds_6_tfcitacode), "%", "") ;
      lV113Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV113Pagowwds_12_tfpagotoken), "%", "") ;
      lV116Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV116Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV118Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV118Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV120Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV120Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV122Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV122Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV130Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV130Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV132Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV132Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV134Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV134Pagowwds_33_tfpagorequest), "%", "") ;
      lV136Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV136Pagowwds_35_tfpagoresponse), "%", "") ;
      lV138Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV138Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV144Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV144Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV146Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV146Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor H00263 */
      pr_default.execute(1, new Object[] {lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, lV102Pagowwds_1_filterfulltext, Integer.valueOf(AV103Pagowwds_2_tfpagoid), Integer.valueOf(AV104Pagowwds_3_tfpagoid_to), Integer.valueOf(AV105Pagowwds_4_tfcitaid), Integer.valueOf(AV106Pagowwds_5_tfcitaid_to), lV107Pagowwds_6_tfcitacode, AV108Pagowwds_7_tfcitacode_sel, AV109Pagowwds_8_tfsgcitadisponibilidadfecha, AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV111Pagowwds_10_tfpagomonto, AV112Pagowwds_11_tfpagomonto_to, lV113Pagowwds_12_tfpagotoken, AV114Pagowwds_13_tfpagotoken_sel, lV116Pagowwds_15_tfpagoclientenrodocumento, AV117Pagowwds_16_tfpagoclientenrodocumento_sel, lV118Pagowwds_17_tfpagoclientedenominacion, AV119Pagowwds_18_tfpagoclientedenominacion_sel, lV120Pagowwds_19_tfpagoclientedireccion, AV121Pagowwds_20_tfpagoclientedireccion_sel, lV122Pagowwds_21_tfpagoclienteemail, AV123Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV125Pagowwds_24_tfpagonumero), Integer.valueOf(AV126Pagowwds_25_tfpagonumero_to), AV127Pagowwds_26_tfpagofechaemision, AV128Pagowwds_27_tfpagofechaemision_to, lV130Pagowwds_29_tfpagonubefactrequest, AV131Pagowwds_30_tfpagonubefactrequest_sel, lV132Pagowwds_31_tfpagonubefactresponse, AV133Pagowwds_32_tfpagonubefactresponse_sel, lV134Pagowwds_33_tfpagorequest, AV135Pagowwds_34_tfpagorequest_sel, lV136Pagowwds_35_tfpagoresponse, AV137Pagowwds_36_tfpagoresponse_sel, lV138Pagowwds_37_tfpagopasarelaid, AV139Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV140Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV141Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV142Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV143Pagowwds_42_tfdisponibilidadid_to), lV144Pagowwds_43_tfpagoenlacepdf, AV145Pagowwds_44_tfpagoenlacepdf_sel, lV146Pagowwds_45_tfpagoenlacexml, AV147Pagowwds_46_tfpagoenlacexml_sel});
      GRID_nRecordCount = H00263_AGRID_nRecordCount[0] ;
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
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPagoId, AV28TFPagoId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFCitaCode, AV32TFCitaCode_Sel, AV33TFSGCitaDisponibilidadFecha, AV34TFSGCitaDisponibilidadFecha_To, AV37TFPagoMonto, AV38TFPagoMonto_To, AV39TFPagoToken, AV40TFPagoToken_Sel, AV42TFPagoTipoDocumentoCliente_Sels, AV43TFPagoClienteNroDocumento, AV44TFPagoClienteNroDocumento_Sel, AV45TFPagoClienteDenominacion, AV46TFPagoClienteDenominacion_Sel, AV47TFPagoClienteDireccion, AV48TFPagoClienteDireccion_Sel, AV49TFPagoClienteEmail, AV50TFPagoClienteEmail_Sel, AV52TFPagoTipoDocumento_Sels, AV53TFPagoNumero, AV54TFPagoNumero_To, AV55TFPagoFechaEmision, AV56TFPagoFechaEmision_To, AV60TFPagoMoneda_Sels, AV67TFPagoNubefactRequest, AV68TFPagoNubefactRequest_Sel, AV69TFPagoNubefactResponse, AV70TFPagoNubefactResponse_Sel, AV86TFPagoRequest, AV87TFPagoRequest_Sel, AV88TFPagoResponse, AV89TFPagoResponse_Sel, AV90TFPagoPasarelaId, AV91TFPagoPasarelaId_Sel, AV92TFPagoStatusCode, AV93TFPagoStatusCode_To, AV94TFDisponibilidadId, AV95TFDisponibilidadId_To, AV96TFPagoEnlacePDF, AV97TFPagoEnlacePDF_Sel, AV98TFPagoEnlaceXML, AV99TFPagoEnlaceXML_Sel, AV72TFPagoEstadoR_Sels, AV149Pgmname, AV13OrderedBy, AV14OrderedDsc, AV78IsAuthorized_Update, AV80IsAuthorized_Delete, AV83IsAuthorized_CitaCode) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPagoId, AV28TFPagoId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFCitaCode, AV32TFCitaCode_Sel, AV33TFSGCitaDisponibilidadFecha, AV34TFSGCitaDisponibilidadFecha_To, AV37TFPagoMonto, AV38TFPagoMonto_To, AV39TFPagoToken, AV40TFPagoToken_Sel, AV42TFPagoTipoDocumentoCliente_Sels, AV43TFPagoClienteNroDocumento, AV44TFPagoClienteNroDocumento_Sel, AV45TFPagoClienteDenominacion, AV46TFPagoClienteDenominacion_Sel, AV47TFPagoClienteDireccion, AV48TFPagoClienteDireccion_Sel, AV49TFPagoClienteEmail, AV50TFPagoClienteEmail_Sel, AV52TFPagoTipoDocumento_Sels, AV53TFPagoNumero, AV54TFPagoNumero_To, AV55TFPagoFechaEmision, AV56TFPagoFechaEmision_To, AV60TFPagoMoneda_Sels, AV67TFPagoNubefactRequest, AV68TFPagoNubefactRequest_Sel, AV69TFPagoNubefactResponse, AV70TFPagoNubefactResponse_Sel, AV86TFPagoRequest, AV87TFPagoRequest_Sel, AV88TFPagoResponse, AV89TFPagoResponse_Sel, AV90TFPagoPasarelaId, AV91TFPagoPasarelaId_Sel, AV92TFPagoStatusCode, AV93TFPagoStatusCode_To, AV94TFDisponibilidadId, AV95TFDisponibilidadId_To, AV96TFPagoEnlacePDF, AV97TFPagoEnlacePDF_Sel, AV98TFPagoEnlaceXML, AV99TFPagoEnlaceXML_Sel, AV72TFPagoEstadoR_Sels, AV149Pgmname, AV13OrderedBy, AV14OrderedDsc, AV78IsAuthorized_Update, AV80IsAuthorized_Delete, AV83IsAuthorized_CitaCode) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPagoId, AV28TFPagoId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFCitaCode, AV32TFCitaCode_Sel, AV33TFSGCitaDisponibilidadFecha, AV34TFSGCitaDisponibilidadFecha_To, AV37TFPagoMonto, AV38TFPagoMonto_To, AV39TFPagoToken, AV40TFPagoToken_Sel, AV42TFPagoTipoDocumentoCliente_Sels, AV43TFPagoClienteNroDocumento, AV44TFPagoClienteNroDocumento_Sel, AV45TFPagoClienteDenominacion, AV46TFPagoClienteDenominacion_Sel, AV47TFPagoClienteDireccion, AV48TFPagoClienteDireccion_Sel, AV49TFPagoClienteEmail, AV50TFPagoClienteEmail_Sel, AV52TFPagoTipoDocumento_Sels, AV53TFPagoNumero, AV54TFPagoNumero_To, AV55TFPagoFechaEmision, AV56TFPagoFechaEmision_To, AV60TFPagoMoneda_Sels, AV67TFPagoNubefactRequest, AV68TFPagoNubefactRequest_Sel, AV69TFPagoNubefactResponse, AV70TFPagoNubefactResponse_Sel, AV86TFPagoRequest, AV87TFPagoRequest_Sel, AV88TFPagoResponse, AV89TFPagoResponse_Sel, AV90TFPagoPasarelaId, AV91TFPagoPasarelaId_Sel, AV92TFPagoStatusCode, AV93TFPagoStatusCode_To, AV94TFDisponibilidadId, AV95TFDisponibilidadId_To, AV96TFPagoEnlacePDF, AV97TFPagoEnlacePDF_Sel, AV98TFPagoEnlaceXML, AV99TFPagoEnlaceXML_Sel, AV72TFPagoEstadoR_Sels, AV149Pgmname, AV13OrderedBy, AV14OrderedDsc, AV78IsAuthorized_Update, AV80IsAuthorized_Delete, AV83IsAuthorized_CitaCode) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPagoId, AV28TFPagoId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFCitaCode, AV32TFCitaCode_Sel, AV33TFSGCitaDisponibilidadFecha, AV34TFSGCitaDisponibilidadFecha_To, AV37TFPagoMonto, AV38TFPagoMonto_To, AV39TFPagoToken, AV40TFPagoToken_Sel, AV42TFPagoTipoDocumentoCliente_Sels, AV43TFPagoClienteNroDocumento, AV44TFPagoClienteNroDocumento_Sel, AV45TFPagoClienteDenominacion, AV46TFPagoClienteDenominacion_Sel, AV47TFPagoClienteDireccion, AV48TFPagoClienteDireccion_Sel, AV49TFPagoClienteEmail, AV50TFPagoClienteEmail_Sel, AV52TFPagoTipoDocumento_Sels, AV53TFPagoNumero, AV54TFPagoNumero_To, AV55TFPagoFechaEmision, AV56TFPagoFechaEmision_To, AV60TFPagoMoneda_Sels, AV67TFPagoNubefactRequest, AV68TFPagoNubefactRequest_Sel, AV69TFPagoNubefactResponse, AV70TFPagoNubefactResponse_Sel, AV86TFPagoRequest, AV87TFPagoRequest_Sel, AV88TFPagoResponse, AV89TFPagoResponse_Sel, AV90TFPagoPasarelaId, AV91TFPagoPasarelaId_Sel, AV92TFPagoStatusCode, AV93TFPagoStatusCode_To, AV94TFDisponibilidadId, AV95TFDisponibilidadId_To, AV96TFPagoEnlacePDF, AV97TFPagoEnlacePDF_Sel, AV98TFPagoEnlaceXML, AV99TFPagoEnlaceXML_Sel, AV72TFPagoEstadoR_Sels, AV149Pgmname, AV13OrderedBy, AV14OrderedDsc, AV78IsAuthorized_Update, AV80IsAuthorized_Delete, AV83IsAuthorized_CitaCode) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPagoId, AV28TFPagoId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFCitaCode, AV32TFCitaCode_Sel, AV33TFSGCitaDisponibilidadFecha, AV34TFSGCitaDisponibilidadFecha_To, AV37TFPagoMonto, AV38TFPagoMonto_To, AV39TFPagoToken, AV40TFPagoToken_Sel, AV42TFPagoTipoDocumentoCliente_Sels, AV43TFPagoClienteNroDocumento, AV44TFPagoClienteNroDocumento_Sel, AV45TFPagoClienteDenominacion, AV46TFPagoClienteDenominacion_Sel, AV47TFPagoClienteDireccion, AV48TFPagoClienteDireccion_Sel, AV49TFPagoClienteEmail, AV50TFPagoClienteEmail_Sel, AV52TFPagoTipoDocumento_Sels, AV53TFPagoNumero, AV54TFPagoNumero_To, AV55TFPagoFechaEmision, AV56TFPagoFechaEmision_To, AV60TFPagoMoneda_Sels, AV67TFPagoNubefactRequest, AV68TFPagoNubefactRequest_Sel, AV69TFPagoNubefactResponse, AV70TFPagoNubefactResponse_Sel, AV86TFPagoRequest, AV87TFPagoRequest_Sel, AV88TFPagoResponse, AV89TFPagoResponse_Sel, AV90TFPagoPasarelaId, AV91TFPagoPasarelaId_Sel, AV92TFPagoStatusCode, AV93TFPagoStatusCode_To, AV94TFDisponibilidadId, AV95TFDisponibilidadId_To, AV96TFPagoEnlacePDF, AV97TFPagoEnlacePDF_Sel, AV98TFPagoEnlaceXML, AV99TFPagoEnlaceXML_Sel, AV72TFPagoEstadoR_Sels, AV149Pgmname, AV13OrderedBy, AV14OrderedDsc, AV78IsAuthorized_Update, AV80IsAuthorized_Delete, AV83IsAuthorized_CitaCode) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV149Pgmname = "PagoWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup260( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19262 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV73DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV75GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV76GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV35DDO_SGCitaDisponibilidadFechaAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE"), 0) ;
         AV36DDO_SGCitaDisponibilidadFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO"), 0) ;
         AV57DDO_PagoFechaEmisionAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_PAGOFECHAEMISIONAUXDATE"), 0) ;
         AV58DDO_PagoFechaEmisionAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_PAGOFECHAEMISIONAUXDATETO"), 0) ;
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
         AV84DDO_SGCitaDisponibilidadFechaAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV84DDO_SGCitaDisponibilidadFechaAuxDateText", AV84DDO_SGCitaDisponibilidadFechaAuxDateText);
         AV85DDO_PagoFechaEmisionAuxDateText = httpContext.cgiGet( edtavDdo_pagofechaemisionauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85DDO_PagoFechaEmisionAuxDateText", AV85DDO_PagoFechaEmisionAuxDateText);
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
      e19262 ();
      if (returnInSub) return;
   }

   public void e19262( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFPAGOFECHAEMISION_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_pagofechaemisionauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFSGCITADISPONIBILIDADFECHA_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname});
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
      GXt_boolean1 = AV83IsAuthorized_CitaCode ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean2) ;
      pagoww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV83IsAuthorized_CitaCode = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83IsAuthorized_CitaCode", AV83IsAuthorized_CitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CITACODE", getSecureSignedToken( "", AV83IsAuthorized_CitaCode));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Pago" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV73DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV73DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e20262( )
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
      if ( GXutil.strcmp(AV23Session.getValue("PagoWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("PagoWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtPagoId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadFecha_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadFecha_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoMonto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoMonto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoMonto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoToken_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoToken_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoToken_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPagoTipoDocumentoCliente.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumentoCliente.getInternalname(), "Visible", GXutil.ltrimstr( cmbPagoTipoDocumentoCliente.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoClienteNroDocumento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteNroDocumento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteNroDocumento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoClienteDenominacion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteDenominacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteDenominacion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoClienteDireccion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteDireccion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteDireccion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoClienteEmail_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteEmail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteEmail_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPagoTipoDocumento.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumento.getInternalname(), "Visible", GXutil.ltrimstr( cmbPagoTipoDocumento.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoNumero_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoNumero_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoFechaEmision_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoFechaEmision_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoFechaEmision_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPagoMoneda.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoMoneda.getInternalname(), "Visible", GXutil.ltrimstr( cmbPagoMoneda.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoNubefactRequest_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoNubefactRequest_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoNubefactRequest_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoNubefactResponse_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoNubefactResponse_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoNubefactResponse_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoRequest_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoRequest_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoRequest_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoResponse_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoResponse_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoResponse_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoPasarelaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoPasarelaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoPasarelaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoStatusCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoStatusCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoStatusCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDisponibilidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoEnlacePDF_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoEnlacePDF_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoEnlacePDF_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPagoEnlaceXML_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoEnlaceXML_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoEnlaceXML_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPagoEstadoR.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoEstadoR.getInternalname(), "Visible", GXutil.ltrimstr( cmbPagoEstadoR.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV75GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75GridCurrentPage), 10, 0));
      AV76GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76GridPageCount), 10, 0));
      AV102Pagowwds_1_filterfulltext = AV16FilterFullText ;
      AV103Pagowwds_2_tfpagoid = AV27TFPagoId ;
      AV104Pagowwds_3_tfpagoid_to = AV28TFPagoId_To ;
      AV105Pagowwds_4_tfcitaid = AV29TFCitaId ;
      AV106Pagowwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV107Pagowwds_6_tfcitacode = AV31TFCitaCode ;
      AV108Pagowwds_7_tfcitacode_sel = AV32TFCitaCode_Sel ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = AV33TFSGCitaDisponibilidadFecha ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV34TFSGCitaDisponibilidadFecha_To ;
      AV111Pagowwds_10_tfpagomonto = AV37TFPagoMonto ;
      AV112Pagowwds_11_tfpagomonto_to = AV38TFPagoMonto_To ;
      AV113Pagowwds_12_tfpagotoken = AV39TFPagoToken ;
      AV114Pagowwds_13_tfpagotoken_sel = AV40TFPagoToken_Sel ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = AV42TFPagoTipoDocumentoCliente_Sels ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = AV43TFPagoClienteNroDocumento ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = AV44TFPagoClienteNroDocumento_Sel ;
      AV118Pagowwds_17_tfpagoclientedenominacion = AV45TFPagoClienteDenominacion ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = AV46TFPagoClienteDenominacion_Sel ;
      AV120Pagowwds_19_tfpagoclientedireccion = AV47TFPagoClienteDireccion ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = AV48TFPagoClienteDireccion_Sel ;
      AV122Pagowwds_21_tfpagoclienteemail = AV49TFPagoClienteEmail ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = AV50TFPagoClienteEmail_Sel ;
      AV124Pagowwds_23_tfpagotipodocumento_sels = AV52TFPagoTipoDocumento_Sels ;
      AV125Pagowwds_24_tfpagonumero = AV53TFPagoNumero ;
      AV126Pagowwds_25_tfpagonumero_to = AV54TFPagoNumero_To ;
      AV127Pagowwds_26_tfpagofechaemision = AV55TFPagoFechaEmision ;
      AV128Pagowwds_27_tfpagofechaemision_to = AV56TFPagoFechaEmision_To ;
      AV129Pagowwds_28_tfpagomoneda_sels = AV60TFPagoMoneda_Sels ;
      AV130Pagowwds_29_tfpagonubefactrequest = AV67TFPagoNubefactRequest ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = AV68TFPagoNubefactRequest_Sel ;
      AV132Pagowwds_31_tfpagonubefactresponse = AV69TFPagoNubefactResponse ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = AV70TFPagoNubefactResponse_Sel ;
      AV134Pagowwds_33_tfpagorequest = AV86TFPagoRequest ;
      AV135Pagowwds_34_tfpagorequest_sel = AV87TFPagoRequest_Sel ;
      AV136Pagowwds_35_tfpagoresponse = AV88TFPagoResponse ;
      AV137Pagowwds_36_tfpagoresponse_sel = AV89TFPagoResponse_Sel ;
      AV138Pagowwds_37_tfpagopasarelaid = AV90TFPagoPasarelaId ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = AV91TFPagoPasarelaId_Sel ;
      AV140Pagowwds_39_tfpagostatuscode = AV92TFPagoStatusCode ;
      AV141Pagowwds_40_tfpagostatuscode_to = AV93TFPagoStatusCode_To ;
      AV142Pagowwds_41_tfdisponibilidadid = AV94TFDisponibilidadId ;
      AV143Pagowwds_42_tfdisponibilidadid_to = AV95TFDisponibilidadId_To ;
      AV144Pagowwds_43_tfpagoenlacepdf = AV96TFPagoEnlacePDF ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = AV97TFPagoEnlacePDF_Sel ;
      AV146Pagowwds_45_tfpagoenlacexml = AV98TFPagoEnlaceXML ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = AV99TFPagoEnlaceXML_Sel ;
      AV148Pagowwds_47_tfpagoestador_sels = AV72TFPagoEstadoR_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e12262( )
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
         AV74PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV74PageToGo) ;
      }
   }

   public void e13262( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e14262( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoId") == 0 )
         {
            AV27TFPagoId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPagoId), 8, 0));
            AV28TFPagoId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPagoId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPagoId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaId") == 0 )
         {
            AV29TFCitaId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
            AV30TFCitaId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaCode") == 0 )
         {
            AV31TFCitaCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFCitaCode", AV31TFCitaCode);
            AV32TFCitaCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFCitaCode_Sel", AV32TFCitaCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadFecha") == 0 )
         {
            AV33TFSGCitaDisponibilidadFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSGCitaDisponibilidadFecha", localUtil.format(AV33TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV34TFSGCitaDisponibilidadFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFSGCitaDisponibilidadFecha_To", localUtil.format(AV34TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoMonto") == 0 )
         {
            AV37TFPagoMonto = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPagoMonto", GXutil.ltrimstr( AV37TFPagoMonto, 6, 2));
            AV38TFPagoMonto_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPagoMonto_To", GXutil.ltrimstr( AV38TFPagoMonto_To, 6, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoToken") == 0 )
         {
            AV39TFPagoToken = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFPagoToken", AV39TFPagoToken);
            AV40TFPagoToken_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFPagoToken_Sel", AV40TFPagoToken_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoTipoDocumentoCliente") == 0 )
         {
            AV41TFPagoTipoDocumentoCliente_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFPagoTipoDocumentoCliente_SelsJson", AV41TFPagoTipoDocumentoCliente_SelsJson);
            AV42TFPagoTipoDocumentoCliente_Sels.fromJSonString(AV41TFPagoTipoDocumentoCliente_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoClienteNroDocumento") == 0 )
         {
            AV43TFPagoClienteNroDocumento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFPagoClienteNroDocumento", AV43TFPagoClienteNroDocumento);
            AV44TFPagoClienteNroDocumento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFPagoClienteNroDocumento_Sel", AV44TFPagoClienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoClienteDenominacion") == 0 )
         {
            AV45TFPagoClienteDenominacion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPagoClienteDenominacion", AV45TFPagoClienteDenominacion);
            AV46TFPagoClienteDenominacion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPagoClienteDenominacion_Sel", AV46TFPagoClienteDenominacion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoClienteDireccion") == 0 )
         {
            AV47TFPagoClienteDireccion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPagoClienteDireccion", AV47TFPagoClienteDireccion);
            AV48TFPagoClienteDireccion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFPagoClienteDireccion_Sel", AV48TFPagoClienteDireccion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoClienteEmail") == 0 )
         {
            AV49TFPagoClienteEmail = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFPagoClienteEmail", AV49TFPagoClienteEmail);
            AV50TFPagoClienteEmail_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPagoClienteEmail_Sel", AV50TFPagoClienteEmail_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoTipoDocumento") == 0 )
         {
            AV51TFPagoTipoDocumento_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFPagoTipoDocumento_SelsJson", AV51TFPagoTipoDocumento_SelsJson);
            AV52TFPagoTipoDocumento_Sels.fromJSonString(GXutil.strReplace( AV51TFPagoTipoDocumento_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoNumero") == 0 )
         {
            AV53TFPagoNumero = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFPagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFPagoNumero), 8, 0));
            AV54TFPagoNumero_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFPagoNumero_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFPagoNumero_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoFechaEmision") == 0 )
         {
            AV55TFPagoFechaEmision = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFPagoFechaEmision", localUtil.format(AV55TFPagoFechaEmision, "99/99/9999"));
            AV56TFPagoFechaEmision_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFPagoFechaEmision_To", localUtil.format(AV56TFPagoFechaEmision_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoMoneda") == 0 )
         {
            AV59TFPagoMoneda_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFPagoMoneda_SelsJson", AV59TFPagoMoneda_SelsJson);
            AV60TFPagoMoneda_Sels.fromJSonString(GXutil.strReplace( AV59TFPagoMoneda_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoNubefactRequest") == 0 )
         {
            AV67TFPagoNubefactRequest = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFPagoNubefactRequest", AV67TFPagoNubefactRequest);
            AV68TFPagoNubefactRequest_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFPagoNubefactRequest_Sel", AV68TFPagoNubefactRequest_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoNubefactResponse") == 0 )
         {
            AV69TFPagoNubefactResponse = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFPagoNubefactResponse", AV69TFPagoNubefactResponse);
            AV70TFPagoNubefactResponse_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFPagoNubefactResponse_Sel", AV70TFPagoNubefactResponse_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoRequest") == 0 )
         {
            AV86TFPagoRequest = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFPagoRequest", AV86TFPagoRequest);
            AV87TFPagoRequest_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFPagoRequest_Sel", AV87TFPagoRequest_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoResponse") == 0 )
         {
            AV88TFPagoResponse = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFPagoResponse", AV88TFPagoResponse);
            AV89TFPagoResponse_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV89TFPagoResponse_Sel", AV89TFPagoResponse_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoPasarelaId") == 0 )
         {
            AV90TFPagoPasarelaId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFPagoPasarelaId", AV90TFPagoPasarelaId);
            AV91TFPagoPasarelaId_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFPagoPasarelaId_Sel", AV91TFPagoPasarelaId_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoStatusCode") == 0 )
         {
            AV92TFPagoStatusCode = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFPagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92TFPagoStatusCode), 8, 0));
            AV93TFPagoStatusCode_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFPagoStatusCode_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV93TFPagoStatusCode_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadId") == 0 )
         {
            AV94TFDisponibilidadId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94TFDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV94TFDisponibilidadId), 8, 0));
            AV95TFDisponibilidadId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95TFDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95TFDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoEnlacePDF") == 0 )
         {
            AV96TFPagoEnlacePDF = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96TFPagoEnlacePDF", AV96TFPagoEnlacePDF);
            AV97TFPagoEnlacePDF_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFPagoEnlacePDF_Sel", AV97TFPagoEnlacePDF_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoEnlaceXML") == 0 )
         {
            AV98TFPagoEnlaceXML = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFPagoEnlaceXML", AV98TFPagoEnlaceXML);
            AV99TFPagoEnlaceXML_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFPagoEnlaceXML_Sel", AV99TFPagoEnlaceXML_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PagoEstadoR") == 0 )
         {
            AV71TFPagoEstadoR_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFPagoEstadoR_SelsJson", AV71TFPagoEstadoR_SelsJson);
            AV72TFPagoEstadoR_Sels.fromJSonString(AV71TFPagoEstadoR_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72TFPagoEstadoR_Sels", AV72TFPagoEstadoR_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFPagoMoneda_Sels", AV60TFPagoMoneda_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV52TFPagoTipoDocumento_Sels", AV52TFPagoTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42TFPagoTipoDocumentoCliente_Sels", AV42TFPagoTipoDocumentoCliente_Sels);
   }

   private void e21262( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV77Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV77Update);
      if ( AV78IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.pago", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A47PagoId,8,0))}, new String[] {"Mode","PagoId"})  ;
      }
      AV79Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV79Delete);
      if ( AV80IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.pago", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A47PagoId,8,0))}, new String[] {"Mode","PagoId"})  ;
      }
      if ( AV83IsAuthorized_CitaCode )
      {
         edtCitaCode_Link = formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CitaId","TabCode"})  ;
      }
      edtPagoMonto_Link = formatLink("com.projectthani.pagoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A47PagoId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PagoId","TabCode"})  ;
      edtPagoEnlacePDF_Linktarget = "_blank" ;
      edtPagoEnlacePDF_Link = A338PagoEnlacePDF ;
      edtPagoEnlaceXML_Linktarget = "_blank" ;
      edtPagoEnlaceXML_Link = A339PagoEnlaceXML ;
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

   public void e15262( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "PagoWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e11262( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("PagoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV149Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("PagoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "PagoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         pagoww_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV149Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42TFPagoTipoDocumentoCliente_Sels", AV42TFPagoTipoDocumentoCliente_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV52TFPagoTipoDocumento_Sels", AV52TFPagoTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFPagoMoneda_Sels", AV60TFPagoMoneda_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72TFPagoEstadoR_Sels", AV72TFPagoEstadoR_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e16262( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.pago", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","PagoId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17262( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.pagowwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      pagoww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      pagoww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72TFPagoEstadoR_Sels", AV72TFPagoEstadoR_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFPagoMoneda_Sels", AV60TFPagoMoneda_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV52TFPagoTipoDocumento_Sels", AV52TFPagoTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42TFPagoTipoDocumentoCliente_Sels", AV42TFPagoTipoDocumentoCliente_Sels);
   }

   public void e18262( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.pagowwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72TFPagoEstadoR_Sels", AV72TFPagoEstadoR_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFPagoMoneda_Sels", AV60TFPagoMoneda_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV52TFPagoTipoDocumento_Sels", AV52TFPagoTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42TFPagoTipoDocumentoCliente_Sels", AV42TFPagoTipoDocumentoCliente_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Cita Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaCode", "", "Cita Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadFecha", "", "SGCita Disponibilidad Fecha", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoMonto", "", "Monto", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoToken", "", "Token", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoTipoDocumentoCliente", "", "Documento Cliente", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteNroDocumento", "", "Nro Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteDenominacion", "", "Cliente Denominacion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteDireccion", "", "Cliente Direccion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteEmail", "", "Cliente Email", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoTipoDocumento", "", "Tipo Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoNumero", "", "Numero", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoFechaEmision", "", "Fecha Emision", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoMoneda", "", "Moneda", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoNubefactRequest", "", "Nubefact Request", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoNubefactResponse", "", "Nubefact Response", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoRequest", "", "Request", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoResponse", "", "Response", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoPasarelaId", "", "Pasarela Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoStatusCode", "", "Status Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadId", "", "Disponibilidad Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoEnlacePDF", "", "Enlace PDF", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoEnlaceXML", "", "Enlace XML", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoEstadoR", "", "Estado R", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PagoWWColumnsSelector", GXv_char8) ;
      pagoww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV78IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Update", GXv_boolean2) ;
      pagoww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV78IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78IsAuthorized_Update", AV78IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV78IsAuthorized_Update));
      if ( ! ( AV78IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV80IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Delete", GXv_boolean2) ;
      pagoww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV80IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80IsAuthorized_Delete", AV80IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV80IsAuthorized_Delete));
      if ( ! ( AV80IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV81TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Insert", GXv_boolean2) ;
      pagoww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV81TempBoolean = GXt_boolean1 ;
      if ( ! ( AV81TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "PagoWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFPagoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPagoId), 8, 0));
      AV28TFPagoId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFPagoId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPagoId_To), 8, 0));
      AV29TFCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
      AV30TFCitaId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
      AV31TFCitaCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFCitaCode", AV31TFCitaCode);
      AV32TFCitaCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFCitaCode_Sel", AV32TFCitaCode_Sel);
      AV33TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFSGCitaDisponibilidadFecha", localUtil.format(AV33TFSGCitaDisponibilidadFecha, "99/99/99"));
      AV34TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFSGCitaDisponibilidadFecha_To", localUtil.format(AV34TFSGCitaDisponibilidadFecha_To, "99/99/99"));
      AV37TFPagoMonto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFPagoMonto", GXutil.ltrimstr( AV37TFPagoMonto, 6, 2));
      AV38TFPagoMonto_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFPagoMonto_To", GXutil.ltrimstr( AV38TFPagoMonto_To, 6, 2));
      AV39TFPagoToken = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFPagoToken", AV39TFPagoToken);
      AV40TFPagoToken_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFPagoToken_Sel", AV40TFPagoToken_Sel);
      AV42TFPagoTipoDocumentoCliente_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43TFPagoClienteNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFPagoClienteNroDocumento", AV43TFPagoClienteNroDocumento);
      AV44TFPagoClienteNroDocumento_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFPagoClienteNroDocumento_Sel", AV44TFPagoClienteNroDocumento_Sel);
      AV45TFPagoClienteDenominacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFPagoClienteDenominacion", AV45TFPagoClienteDenominacion);
      AV46TFPagoClienteDenominacion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFPagoClienteDenominacion_Sel", AV46TFPagoClienteDenominacion_Sel);
      AV47TFPagoClienteDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFPagoClienteDireccion", AV47TFPagoClienteDireccion);
      AV48TFPagoClienteDireccion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFPagoClienteDireccion_Sel", AV48TFPagoClienteDireccion_Sel);
      AV49TFPagoClienteEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFPagoClienteEmail", AV49TFPagoClienteEmail);
      AV50TFPagoClienteEmail_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFPagoClienteEmail_Sel", AV50TFPagoClienteEmail_Sel);
      AV52TFPagoTipoDocumento_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV53TFPagoNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFPagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFPagoNumero), 8, 0));
      AV54TFPagoNumero_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFPagoNumero_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFPagoNumero_To), 8, 0));
      AV55TFPagoFechaEmision = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFPagoFechaEmision", localUtil.format(AV55TFPagoFechaEmision, "99/99/9999"));
      AV56TFPagoFechaEmision_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFPagoFechaEmision_To", localUtil.format(AV56TFPagoFechaEmision_To, "99/99/9999"));
      AV60TFPagoMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV67TFPagoNubefactRequest = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFPagoNubefactRequest", AV67TFPagoNubefactRequest);
      AV68TFPagoNubefactRequest_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68TFPagoNubefactRequest_Sel", AV68TFPagoNubefactRequest_Sel);
      AV69TFPagoNubefactResponse = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69TFPagoNubefactResponse", AV69TFPagoNubefactResponse);
      AV70TFPagoNubefactResponse_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70TFPagoNubefactResponse_Sel", AV70TFPagoNubefactResponse_Sel);
      AV86TFPagoRequest = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86TFPagoRequest", AV86TFPagoRequest);
      AV87TFPagoRequest_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87TFPagoRequest_Sel", AV87TFPagoRequest_Sel);
      AV88TFPagoResponse = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88TFPagoResponse", AV88TFPagoResponse);
      AV89TFPagoResponse_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89TFPagoResponse_Sel", AV89TFPagoResponse_Sel);
      AV90TFPagoPasarelaId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90TFPagoPasarelaId", AV90TFPagoPasarelaId);
      AV91TFPagoPasarelaId_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV91TFPagoPasarelaId_Sel", AV91TFPagoPasarelaId_Sel);
      AV92TFPagoStatusCode = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92TFPagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92TFPagoStatusCode), 8, 0));
      AV93TFPagoStatusCode_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV93TFPagoStatusCode_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV93TFPagoStatusCode_To), 8, 0));
      AV94TFDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV94TFDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV94TFDisponibilidadId), 8, 0));
      AV95TFDisponibilidadId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95TFDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95TFDisponibilidadId_To), 8, 0));
      AV96TFPagoEnlacePDF = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96TFPagoEnlacePDF", AV96TFPagoEnlacePDF);
      AV97TFPagoEnlacePDF_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97TFPagoEnlacePDF_Sel", AV97TFPagoEnlacePDF_Sel);
      AV98TFPagoEnlaceXML = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98TFPagoEnlaceXML", AV98TFPagoEnlaceXML);
      AV99TFPagoEnlaceXML_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99TFPagoEnlaceXML_Sel", AV99TFPagoEnlaceXML_Sel);
      AV72TFPagoEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV149Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV149Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV149Pgmname+"GridState"), null, null);
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
      AV150GXV1 = 1 ;
      while ( AV150GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV150GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOID") == 0 )
         {
            AV27TFPagoId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPagoId), 8, 0));
            AV28TFPagoId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPagoId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPagoId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV29TFCitaId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
            AV30TFCitaId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV31TFCitaCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFCitaCode", AV31TFCitaCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV32TFCitaCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFCitaCode_Sel", AV32TFCitaCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV33TFSGCitaDisponibilidadFecha = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSGCitaDisponibilidadFecha", localUtil.format(AV33TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV34TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFSGCitaDisponibilidadFecha_To", localUtil.format(AV34TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONTO") == 0 )
         {
            AV37TFPagoMonto = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPagoMonto", GXutil.ltrimstr( AV37TFPagoMonto, 6, 2));
            AV38TFPagoMonto_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPagoMonto_To", GXutil.ltrimstr( AV38TFPagoMonto_To, 6, 2));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN") == 0 )
         {
            AV39TFPagoToken = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFPagoToken", AV39TFPagoToken);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN_SEL") == 0 )
         {
            AV40TFPagoToken_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFPagoToken_Sel", AV40TFPagoToken_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTOCLIENTE_SEL") == 0 )
         {
            AV41TFPagoTipoDocumentoCliente_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFPagoTipoDocumentoCliente_SelsJson", AV41TFPagoTipoDocumentoCliente_SelsJson);
            AV42TFPagoTipoDocumentoCliente_Sels.fromJSonString(AV41TFPagoTipoDocumentoCliente_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO") == 0 )
         {
            AV43TFPagoClienteNroDocumento = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFPagoClienteNroDocumento", AV43TFPagoClienteNroDocumento);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV44TFPagoClienteNroDocumento_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFPagoClienteNroDocumento_Sel", AV44TFPagoClienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION") == 0 )
         {
            AV45TFPagoClienteDenominacion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPagoClienteDenominacion", AV45TFPagoClienteDenominacion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION_SEL") == 0 )
         {
            AV46TFPagoClienteDenominacion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPagoClienteDenominacion_Sel", AV46TFPagoClienteDenominacion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION") == 0 )
         {
            AV47TFPagoClienteDireccion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPagoClienteDireccion", AV47TFPagoClienteDireccion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION_SEL") == 0 )
         {
            AV48TFPagoClienteDireccion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFPagoClienteDireccion_Sel", AV48TFPagoClienteDireccion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL") == 0 )
         {
            AV49TFPagoClienteEmail = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFPagoClienteEmail", AV49TFPagoClienteEmail);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL_SEL") == 0 )
         {
            AV50TFPagoClienteEmail_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPagoClienteEmail_Sel", AV50TFPagoClienteEmail_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTO_SEL") == 0 )
         {
            AV51TFPagoTipoDocumento_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFPagoTipoDocumento_SelsJson", AV51TFPagoTipoDocumento_SelsJson);
            AV52TFPagoTipoDocumento_Sels.fromJSonString(AV51TFPagoTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUMERO") == 0 )
         {
            AV53TFPagoNumero = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFPagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFPagoNumero), 8, 0));
            AV54TFPagoNumero_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFPagoNumero_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFPagoNumero_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOFECHAEMISION") == 0 )
         {
            AV55TFPagoFechaEmision = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFPagoFechaEmision", localUtil.format(AV55TFPagoFechaEmision, "99/99/9999"));
            AV56TFPagoFechaEmision_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFPagoFechaEmision_To", localUtil.format(AV56TFPagoFechaEmision_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONEDA_SEL") == 0 )
         {
            AV59TFPagoMoneda_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFPagoMoneda_SelsJson", AV59TFPagoMoneda_SelsJson);
            AV60TFPagoMoneda_Sels.fromJSonString(AV59TFPagoMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST") == 0 )
         {
            AV67TFPagoNubefactRequest = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFPagoNubefactRequest", AV67TFPagoNubefactRequest);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST_SEL") == 0 )
         {
            AV68TFPagoNubefactRequest_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFPagoNubefactRequest_Sel", AV68TFPagoNubefactRequest_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE") == 0 )
         {
            AV69TFPagoNubefactResponse = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFPagoNubefactResponse", AV69TFPagoNubefactResponse);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE_SEL") == 0 )
         {
            AV70TFPagoNubefactResponse_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFPagoNubefactResponse_Sel", AV70TFPagoNubefactResponse_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST") == 0 )
         {
            AV86TFPagoRequest = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFPagoRequest", AV86TFPagoRequest);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST_SEL") == 0 )
         {
            AV87TFPagoRequest_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFPagoRequest_Sel", AV87TFPagoRequest_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE") == 0 )
         {
            AV88TFPagoResponse = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFPagoResponse", AV88TFPagoResponse);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE_SEL") == 0 )
         {
            AV89TFPagoResponse_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV89TFPagoResponse_Sel", AV89TFPagoResponse_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID") == 0 )
         {
            AV90TFPagoPasarelaId = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFPagoPasarelaId", AV90TFPagoPasarelaId);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID_SEL") == 0 )
         {
            AV91TFPagoPasarelaId_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFPagoPasarelaId_Sel", AV91TFPagoPasarelaId_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOSTATUSCODE") == 0 )
         {
            AV92TFPagoStatusCode = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFPagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92TFPagoStatusCode), 8, 0));
            AV93TFPagoStatusCode_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFPagoStatusCode_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV93TFPagoStatusCode_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV94TFDisponibilidadId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94TFDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV94TFDisponibilidadId), 8, 0));
            AV95TFDisponibilidadId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95TFDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95TFDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF") == 0 )
         {
            AV96TFPagoEnlacePDF = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96TFPagoEnlacePDF", AV96TFPagoEnlacePDF);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF_SEL") == 0 )
         {
            AV97TFPagoEnlacePDF_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFPagoEnlacePDF_Sel", AV97TFPagoEnlacePDF_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML") == 0 )
         {
            AV98TFPagoEnlaceXML = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFPagoEnlaceXML", AV98TFPagoEnlaceXML);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML_SEL") == 0 )
         {
            AV99TFPagoEnlaceXML_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFPagoEnlaceXML_Sel", AV99TFPagoEnlaceXML_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOESTADOR_SEL") == 0 )
         {
            AV71TFPagoEstadoR_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFPagoEstadoR_SelsJson", AV71TFPagoEstadoR_SelsJson);
            AV72TFPagoEstadoR_Sels.fromJSonString(AV71TFPagoEstadoR_SelsJson, null);
         }
         AV150GXV1 = (int)(AV150GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFCitaCode_Sel)==0), AV32TFCitaCode_Sel, GXv_char8) ;
      pagoww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFPagoToken_Sel)==0), AV40TFPagoToken_Sel, GXv_char7) ;
      pagoww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV42TFPagoTipoDocumentoCliente_Sels.size()==0), AV41TFPagoTipoDocumentoCliente_SelsJson, GXv_char15) ;
      pagoww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFPagoClienteNroDocumento_Sel)==0), AV44TFPagoClienteNroDocumento_Sel, GXv_char17) ;
      pagoww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV46TFPagoClienteDenominacion_Sel)==0), AV46TFPagoClienteDenominacion_Sel, GXv_char19) ;
      pagoww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV48TFPagoClienteDireccion_Sel)==0), AV48TFPagoClienteDireccion_Sel, GXv_char21) ;
      pagoww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV50TFPagoClienteEmail_Sel)==0), AV50TFPagoClienteEmail_Sel, GXv_char23) ;
      pagoww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV68TFPagoNubefactRequest_Sel)==0), AV68TFPagoNubefactRequest_Sel, GXv_char25) ;
      pagoww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV70TFPagoNubefactResponse_Sel)==0), AV70TFPagoNubefactResponse_Sel, GXv_char27) ;
      pagoww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV87TFPagoRequest_Sel)==0), AV87TFPagoRequest_Sel, GXv_char29) ;
      pagoww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV89TFPagoResponse_Sel)==0), AV89TFPagoResponse_Sel, GXv_char31) ;
      pagoww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV91TFPagoPasarelaId_Sel)==0), AV91TFPagoPasarelaId_Sel, GXv_char33) ;
      pagoww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV97TFPagoEnlacePDF_Sel)==0), AV97TFPagoEnlacePDF_Sel, GXv_char35) ;
      pagoww_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV99TFPagoEnlaceXML_Sel)==0), AV99TFPagoEnlaceXML_Sel, GXv_char37) ;
      pagoww_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV72TFPagoEstadoR_Sels.size()==0), AV71TFPagoEstadoR_SelsJson, GXv_char39) ;
      pagoww_impl.this.GXt_char38 = GXv_char39[0] ;
      Ddo_grid_Selectedvalue_set = "||"+GXt_char6+"|||"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"|"+((AV52TFPagoTipoDocumento_Sels.size()==0) ? "" : AV51TFPagoTipoDocumento_SelsJson)+"|||"+((AV60TFPagoMoneda_Sels.size()==0) ? "" : AV59TFPagoMoneda_SelsJson)+"|"+GXt_char24+"|"+GXt_char26+"|"+GXt_char28+"|"+GXt_char30+"|"+GXt_char32+"|||"+GXt_char34+"|"+GXt_char36+"|"+GXt_char38 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFCitaCode)==0), AV31TFCitaCode, GXv_char39) ;
      pagoww_impl.this.GXt_char38 = GXv_char39[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFPagoToken)==0), AV39TFPagoToken, GXv_char37) ;
      pagoww_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFPagoClienteNroDocumento)==0), AV43TFPagoClienteNroDocumento, GXv_char35) ;
      pagoww_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFPagoClienteDenominacion)==0), AV45TFPagoClienteDenominacion, GXv_char33) ;
      pagoww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV47TFPagoClienteDireccion)==0), AV47TFPagoClienteDireccion, GXv_char31) ;
      pagoww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFPagoClienteEmail)==0), AV49TFPagoClienteEmail, GXv_char29) ;
      pagoww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV67TFPagoNubefactRequest)==0), AV67TFPagoNubefactRequest, GXv_char27) ;
      pagoww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV69TFPagoNubefactResponse)==0), AV69TFPagoNubefactResponse, GXv_char25) ;
      pagoww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV86TFPagoRequest)==0), AV86TFPagoRequest, GXv_char23) ;
      pagoww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV88TFPagoResponse)==0), AV88TFPagoResponse, GXv_char21) ;
      pagoww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV90TFPagoPasarelaId)==0), AV90TFPagoPasarelaId, GXv_char19) ;
      pagoww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV96TFPagoEnlacePDF)==0), AV96TFPagoEnlacePDF, GXv_char17) ;
      pagoww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV98TFPagoEnlaceXML)==0), AV98TFPagoEnlaceXML, GXv_char15) ;
      pagoww_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFPagoId) ? "" : GXutil.str( AV27TFPagoId, 8, 0))+"|"+((0==AV29TFCitaId) ? "" : GXutil.str( AV29TFCitaId, 8, 0))+"|"+GXt_char38+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV33TFSGCitaDisponibilidadFecha)) ? "" : localUtil.dtoc( AV33TFSGCitaDisponibilidadFecha, 3, "/"))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFPagoMonto)==0) ? "" : GXutil.str( AV37TFPagoMonto, 6, 2))+"|"+GXt_char36+"||"+GXt_char34+"|"+GXt_char32+"|"+GXt_char30+"|"+GXt_char28+"||"+((0==AV53TFPagoNumero) ? "" : GXutil.str( AV53TFPagoNumero, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55TFPagoFechaEmision)) ? "" : localUtil.dtoc( AV55TFPagoFechaEmision, 3, "/"))+"||"+GXt_char26+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+GXt_char18+"|"+((0==AV92TFPagoStatusCode) ? "" : GXutil.str( AV92TFPagoStatusCode, 8, 0))+"|"+((0==AV94TFDisponibilidadId) ? "" : GXutil.str( AV94TFDisponibilidadId, 8, 0))+"|"+GXt_char16+"|"+GXt_char14+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFPagoId_To) ? "" : GXutil.str( AV28TFPagoId_To, 8, 0))+"|"+((0==AV30TFCitaId_To) ? "" : GXutil.str( AV30TFCitaId_To, 8, 0))+"||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV34TFSGCitaDisponibilidadFecha_To)) ? "" : localUtil.dtoc( AV34TFSGCitaDisponibilidadFecha_To, 3, "/"))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFPagoMonto_To)==0) ? "" : GXutil.str( AV38TFPagoMonto_To, 6, 2))+"||||||||"+((0==AV54TFPagoNumero_To) ? "" : GXutil.str( AV54TFPagoNumero_To, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56TFPagoFechaEmision_To)) ? "" : localUtil.dtoc( AV56TFPagoFechaEmision_To, 3, "/"))+"|||||||"+((0==AV93TFPagoStatusCode_To) ? "" : GXutil.str( AV93TFPagoStatusCode_To, 8, 0))+"|"+((0==AV95TFDisponibilidadId_To) ? "" : GXutil.str( AV95TFDisponibilidadId_To, 8, 0))+"|||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV149Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOID", !((0==AV27TFPagoId)&&(0==AV28TFPagoId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFPagoId, 8, 0)), GXutil.trim( GXutil.str( AV28TFPagoId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITAID", !((0==AV29TFCitaId)&&(0==AV30TFCitaId_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFCitaId, 8, 0)), GXutil.trim( GXutil.str( AV30TFCitaId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITACODE", !(GXutil.strcmp("", AV31TFCitaCode)==0), (short)(0), AV31TFCitaCode, "", !(GXutil.strcmp("", AV32TFCitaCode_Sel)==0), AV32TFCitaCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADFECHA", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV33TFSGCitaDisponibilidadFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV34TFSGCitaDisponibilidadFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV33TFSGCitaDisponibilidadFecha, 3, "/")), GXutil.trim( localUtil.dtoc( AV34TFSGCitaDisponibilidadFecha_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOMONTO", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFPagoMonto)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFPagoMonto_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV37TFPagoMonto, 6, 2)), GXutil.trim( GXutil.str( AV38TFPagoMonto_To, 6, 2))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOTOKEN", !(GXutil.strcmp("", AV39TFPagoToken)==0), (short)(0), AV39TFPagoToken, "", !(GXutil.strcmp("", AV40TFPagoToken_Sel)==0), AV40TFPagoToken_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOTIPODOCUMENTOCLIENTE_SEL", !(AV42TFPagoTipoDocumentoCliente_Sels.size()==0), (short)(0), AV42TFPagoTipoDocumentoCliente_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOCLIENTENRODOCUMENTO", !(GXutil.strcmp("", AV43TFPagoClienteNroDocumento)==0), (short)(0), AV43TFPagoClienteNroDocumento, "", !(GXutil.strcmp("", AV44TFPagoClienteNroDocumento_Sel)==0), AV44TFPagoClienteNroDocumento_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOCLIENTEDENOMINACION", !(GXutil.strcmp("", AV45TFPagoClienteDenominacion)==0), (short)(0), AV45TFPagoClienteDenominacion, "", !(GXutil.strcmp("", AV46TFPagoClienteDenominacion_Sel)==0), AV46TFPagoClienteDenominacion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOCLIENTEDIRECCION", !(GXutil.strcmp("", AV47TFPagoClienteDireccion)==0), (short)(0), AV47TFPagoClienteDireccion, "", !(GXutil.strcmp("", AV48TFPagoClienteDireccion_Sel)==0), AV48TFPagoClienteDireccion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOCLIENTEEMAIL", !(GXutil.strcmp("", AV49TFPagoClienteEmail)==0), (short)(0), AV49TFPagoClienteEmail, "", !(GXutil.strcmp("", AV50TFPagoClienteEmail_Sel)==0), AV50TFPagoClienteEmail_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOTIPODOCUMENTO_SEL", !(AV52TFPagoTipoDocumento_Sels.size()==0), (short)(0), AV52TFPagoTipoDocumento_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGONUMERO", !((0==AV53TFPagoNumero)&&(0==AV54TFPagoNumero_To)), (short)(0), GXutil.trim( GXutil.str( AV53TFPagoNumero, 8, 0)), GXutil.trim( GXutil.str( AV54TFPagoNumero_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOFECHAEMISION", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55TFPagoFechaEmision))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56TFPagoFechaEmision_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV55TFPagoFechaEmision, 3, "/")), GXutil.trim( localUtil.dtoc( AV56TFPagoFechaEmision_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOMONEDA_SEL", !(AV60TFPagoMoneda_Sels.size()==0), (short)(0), AV60TFPagoMoneda_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGONUBEFACTREQUEST", !(GXutil.strcmp("", AV67TFPagoNubefactRequest)==0), (short)(0), AV67TFPagoNubefactRequest, "", !(GXutil.strcmp("", AV68TFPagoNubefactRequest_Sel)==0), AV68TFPagoNubefactRequest_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGONUBEFACTRESPONSE", !(GXutil.strcmp("", AV69TFPagoNubefactResponse)==0), (short)(0), AV69TFPagoNubefactResponse, "", !(GXutil.strcmp("", AV70TFPagoNubefactResponse_Sel)==0), AV70TFPagoNubefactResponse_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOREQUEST", !(GXutil.strcmp("", AV86TFPagoRequest)==0), (short)(0), AV86TFPagoRequest, "", !(GXutil.strcmp("", AV87TFPagoRequest_Sel)==0), AV87TFPagoRequest_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGORESPONSE", !(GXutil.strcmp("", AV88TFPagoResponse)==0), (short)(0), AV88TFPagoResponse, "", !(GXutil.strcmp("", AV89TFPagoResponse_Sel)==0), AV89TFPagoResponse_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOPASARELAID", !(GXutil.strcmp("", AV90TFPagoPasarelaId)==0), (short)(0), AV90TFPagoPasarelaId, "", !(GXutil.strcmp("", AV91TFPagoPasarelaId_Sel)==0), AV91TFPagoPasarelaId_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOSTATUSCODE", !((0==AV92TFPagoStatusCode)&&(0==AV93TFPagoStatusCode_To)), (short)(0), GXutil.trim( GXutil.str( AV92TFPagoStatusCode, 8, 0)), GXutil.trim( GXutil.str( AV93TFPagoStatusCode_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFDISPONIBILIDADID", !((0==AV94TFDisponibilidadId)&&(0==AV95TFDisponibilidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV94TFDisponibilidadId, 8, 0)), GXutil.trim( GXutil.str( AV95TFDisponibilidadId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOENLACEPDF", !(GXutil.strcmp("", AV96TFPagoEnlacePDF)==0), (short)(0), AV96TFPagoEnlacePDF, "", !(GXutil.strcmp("", AV97TFPagoEnlacePDF_Sel)==0), AV97TFPagoEnlacePDF_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOENLACEXML", !(GXutil.strcmp("", AV98TFPagoEnlaceXML)==0), (short)(0), AV98TFPagoEnlaceXML, "", !(GXutil.strcmp("", AV99TFPagoEnlaceXML_Sel)==0), AV99TFPagoEnlaceXML_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPAGOESTADOR_SEL", !(AV72TFPagoEstadoR_Sels.size()==0), (short)(0), AV72TFPagoEstadoR_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV149Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV149Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Pago" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_262( boolean wbgen )
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
         wb_table2_30_262( true) ;
      }
      else
      {
         wb_table2_30_262( false) ;
      }
      return  ;
   }

   public void wb_table2_30_262e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_262e( true) ;
      }
      else
      {
         wb_table1_25_262e( false) ;
      }
   }

   public void wb_table2_30_262( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_PagoWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_262e( true) ;
      }
      else
      {
         wb_table2_30_262e( false) ;
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
      pa262( ) ;
      ws262( ) ;
      we262( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334531", true, true);
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
      httpContext.AddJavascriptSource("pagoww.js", "?20225110334532", false, true);
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
      edtPagoId_Internalname = "PAGOID_"+sGXsfl_43_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_43_idx ;
      edtPagoMonto_Internalname = "PAGOMONTO_"+sGXsfl_43_idx ;
      edtPagoToken_Internalname = "PAGOTOKEN_"+sGXsfl_43_idx ;
      cmbPagoTipoDocumentoCliente.setInternalname( "PAGOTIPODOCUMENTOCLIENTE_"+sGXsfl_43_idx );
      edtPagoClienteNroDocumento_Internalname = "PAGOCLIENTENRODOCUMENTO_"+sGXsfl_43_idx ;
      edtPagoClienteDenominacion_Internalname = "PAGOCLIENTEDENOMINACION_"+sGXsfl_43_idx ;
      edtPagoClienteDireccion_Internalname = "PAGOCLIENTEDIRECCION_"+sGXsfl_43_idx ;
      edtPagoClienteEmail_Internalname = "PAGOCLIENTEEMAIL_"+sGXsfl_43_idx ;
      cmbPagoTipoDocumento.setInternalname( "PAGOTIPODOCUMENTO_"+sGXsfl_43_idx );
      edtPagoNumero_Internalname = "PAGONUMERO_"+sGXsfl_43_idx ;
      edtPagoFechaEmision_Internalname = "PAGOFECHAEMISION_"+sGXsfl_43_idx ;
      cmbPagoMoneda.setInternalname( "PAGOMONEDA_"+sGXsfl_43_idx );
      edtPagoNubefactRequest_Internalname = "PAGONUBEFACTREQUEST_"+sGXsfl_43_idx ;
      edtPagoNubefactResponse_Internalname = "PAGONUBEFACTRESPONSE_"+sGXsfl_43_idx ;
      edtPagoRequest_Internalname = "PAGOREQUEST_"+sGXsfl_43_idx ;
      edtPagoResponse_Internalname = "PAGORESPONSE_"+sGXsfl_43_idx ;
      edtPagoPasarelaId_Internalname = "PAGOPASARELAID_"+sGXsfl_43_idx ;
      edtPagoStatusCode_Internalname = "PAGOSTATUSCODE_"+sGXsfl_43_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_43_idx ;
      edtPagoEnlacePDF_Internalname = "PAGOENLACEPDF_"+sGXsfl_43_idx ;
      edtPagoEnlaceXML_Internalname = "PAGOENLACEXML_"+sGXsfl_43_idx ;
      cmbPagoEstadoR.setInternalname( "PAGOESTADOR_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtPagoId_Internalname = "PAGOID_"+sGXsfl_43_fel_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_fel_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_43_fel_idx ;
      edtPagoMonto_Internalname = "PAGOMONTO_"+sGXsfl_43_fel_idx ;
      edtPagoToken_Internalname = "PAGOTOKEN_"+sGXsfl_43_fel_idx ;
      cmbPagoTipoDocumentoCliente.setInternalname( "PAGOTIPODOCUMENTOCLIENTE_"+sGXsfl_43_fel_idx );
      edtPagoClienteNroDocumento_Internalname = "PAGOCLIENTENRODOCUMENTO_"+sGXsfl_43_fel_idx ;
      edtPagoClienteDenominacion_Internalname = "PAGOCLIENTEDENOMINACION_"+sGXsfl_43_fel_idx ;
      edtPagoClienteDireccion_Internalname = "PAGOCLIENTEDIRECCION_"+sGXsfl_43_fel_idx ;
      edtPagoClienteEmail_Internalname = "PAGOCLIENTEEMAIL_"+sGXsfl_43_fel_idx ;
      cmbPagoTipoDocumento.setInternalname( "PAGOTIPODOCUMENTO_"+sGXsfl_43_fel_idx );
      edtPagoNumero_Internalname = "PAGONUMERO_"+sGXsfl_43_fel_idx ;
      edtPagoFechaEmision_Internalname = "PAGOFECHAEMISION_"+sGXsfl_43_fel_idx ;
      cmbPagoMoneda.setInternalname( "PAGOMONEDA_"+sGXsfl_43_fel_idx );
      edtPagoNubefactRequest_Internalname = "PAGONUBEFACTREQUEST_"+sGXsfl_43_fel_idx ;
      edtPagoNubefactResponse_Internalname = "PAGONUBEFACTRESPONSE_"+sGXsfl_43_fel_idx ;
      edtPagoRequest_Internalname = "PAGOREQUEST_"+sGXsfl_43_fel_idx ;
      edtPagoResponse_Internalname = "PAGORESPONSE_"+sGXsfl_43_fel_idx ;
      edtPagoPasarelaId_Internalname = "PAGOPASARELAID_"+sGXsfl_43_fel_idx ;
      edtPagoStatusCode_Internalname = "PAGOSTATUSCODE_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_43_fel_idx ;
      edtPagoEnlacePDF_Internalname = "PAGOENLACEPDF_"+sGXsfl_43_fel_idx ;
      edtPagoEnlaceXML_Internalname = "PAGOENLACEXML_"+sGXsfl_43_fel_idx ;
      cmbPagoEstadoR.setInternalname( "PAGOESTADOR_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb260( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV77Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV79Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPagoId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoId_Internalname,GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCitaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaId_Internalname,GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtCitaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCitaCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaCode_Internalname,A64CitaCode,"","","'"+""+"'"+",false,"+"'"+""+"'",edtCitaCode_Link,"","","",edtCitaCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtCitaCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadFecha_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadFecha_Internalname,localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"),localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadFecha_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPagoMonto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoMonto_Internalname,GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A242PagoMonto, "ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'",edtPagoMonto_Link,"","","",edtPagoMonto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPagoMonto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoToken_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoToken_Internalname,A243PagoToken,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoToken_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoToken_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPagoTipoDocumentoCliente.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPagoTipoDocumentoCliente.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOTIPODOCUMENTOCLIENTE_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoTipoDocumentoCliente,cmbPagoTipoDocumentoCliente.getInternalname(),GXutil.rtrim( A247PagoTipoDocumentoCliente),Integer.valueOf(1),cmbPagoTipoDocumentoCliente.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPagoTipoDocumentoCliente.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoTipoDocumentoCliente.setValue( GXutil.rtrim( A247PagoTipoDocumentoCliente) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumentoCliente.getInternalname(), "Values", cmbPagoTipoDocumentoCliente.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoClienteNroDocumento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteNroDocumento_Internalname,A248PagoClienteNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoClienteNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoClienteNroDocumento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoClienteDenominacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteDenominacion_Internalname,A249PagoClienteDenominacion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoClienteDenominacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoClienteDenominacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoClienteDireccion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteDireccion_Internalname,A250PagoClienteDireccion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoClienteDireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoClienteDireccion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoClienteEmail_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoClienteEmail_Internalname,A251PagoClienteEmail,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A251PagoClienteEmail,"","","",edtPagoClienteEmail_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoClienteEmail_Visible),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbPagoTipoDocumento.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPagoTipoDocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOTIPODOCUMENTO_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoTipoDocumento,cmbPagoTipoDocumento.getInternalname(),GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)),Integer.valueOf(1),cmbPagoTipoDocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbPagoTipoDocumento.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoTipoDocumento.setValue( GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumento.getInternalname(), "Values", cmbPagoTipoDocumento.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPagoNumero_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A245PagoNumero, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoNumero_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPagoFechaEmision_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoFechaEmision_Internalname,localUtil.format(A252PagoFechaEmision, "99/99/9999"),localUtil.format( A252PagoFechaEmision, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoFechaEmision_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoFechaEmision_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbPagoMoneda.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPagoMoneda.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOMONEDA_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoMoneda,cmbPagoMoneda.getInternalname(),GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)),Integer.valueOf(1),cmbPagoMoneda.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbPagoMoneda.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoMoneda.setValue( GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoMoneda.getInternalname(), "Values", cmbPagoMoneda.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoNubefactRequest_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoNubefactRequest_Internalname,A256PagoNubefactRequest,A256PagoNubefactRequest,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoNubefactRequest_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoNubefactRequest_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoNubefactResponse_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoNubefactResponse_Internalname,A257PagoNubefactResponse,A257PagoNubefactResponse,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoNubefactResponse_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoNubefactResponse_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoRequest_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoRequest_Internalname,A308PagoRequest,A308PagoRequest,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoRequest_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoRequest_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoResponse_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoResponse_Internalname,A309PagoResponse,A309PagoResponse,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoResponse_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoResponse_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoPasarelaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoPasarelaId_Internalname,A310PagoPasarelaId,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoPasarelaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoPasarelaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPagoStatusCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoStatusCode_Internalname,GXutil.ltrim( localUtil.ntoc( A311PagoStatusCode, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPagoStatusCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoStatusCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDisponibilidadId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoEnlacePDF_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoEnlacePDF_Internalname,A338PagoEnlacePDF,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPagoEnlacePDF_Link,edtPagoEnlacePDF_Linktarget,"","",edtPagoEnlacePDF_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoEnlacePDF_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPagoEnlaceXML_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPagoEnlaceXML_Internalname,A339PagoEnlaceXML,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPagoEnlaceXML_Link,edtPagoEnlaceXML_Linktarget,"","",edtPagoEnlaceXML_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPagoEnlaceXML_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPagoEstadoR.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPagoEstadoR.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAGOESTADOR_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPagoEstadoR,cmbPagoEstadoR.getInternalname(),GXutil.rtrim( A246PagoEstadoR),Integer.valueOf(1),cmbPagoEstadoR.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPagoEstadoR.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPagoEstadoR.setValue( GXutil.rtrim( A246PagoEstadoR) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoEstadoR.getInternalname(), "Values", cmbPagoEstadoR.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes262( ) ;
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
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname = "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETEXT" ;
      Tfsgcitadisponibilidadfecha_rangepicker_Internalname = "TFSGCITADISPONIBILIDADFECHA_RANGEPICKER" ;
      divDdo_sgcitadisponibilidadfechaauxdates_Internalname = "DDO_SGCITADISPONIBILIDADFECHAAUXDATES" ;
      edtavDdo_pagofechaemisionauxdatetext_Internalname = "vDDO_PAGOFECHAEMISIONAUXDATETEXT" ;
      Tfpagofechaemision_rangepicker_Internalname = "TFPAGOFECHAEMISION_RANGEPICKER" ;
      divDdo_pagofechaemisionauxdates_Internalname = "DDO_PAGOFECHAEMISIONAUXDATES" ;
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
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_pagofechaemisionauxdatetext_Jsonclick = "" ;
      edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtPagoEnlaceXML_Linktarget = "" ;
      edtPagoEnlaceXML_Link = "" ;
      edtPagoEnlacePDF_Linktarget = "" ;
      edtPagoEnlacePDF_Link = "" ;
      edtPagoMonto_Link = "" ;
      edtCitaCode_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbPagoEstadoR.setVisible( -1 );
      edtPagoEnlaceXML_Visible = -1 ;
      edtPagoEnlacePDF_Visible = -1 ;
      edtDisponibilidadId_Visible = -1 ;
      edtPagoStatusCode_Visible = -1 ;
      edtPagoPasarelaId_Visible = -1 ;
      edtPagoResponse_Visible = -1 ;
      edtPagoRequest_Visible = -1 ;
      edtPagoNubefactResponse_Visible = -1 ;
      edtPagoNubefactRequest_Visible = -1 ;
      cmbPagoMoneda.setVisible( -1 );
      edtPagoFechaEmision_Visible = -1 ;
      edtPagoNumero_Visible = -1 ;
      cmbPagoTipoDocumento.setVisible( -1 );
      edtPagoClienteEmail_Visible = -1 ;
      edtPagoClienteDireccion_Visible = -1 ;
      edtPagoClienteDenominacion_Visible = -1 ;
      edtPagoClienteNroDocumento_Visible = -1 ;
      cmbPagoTipoDocumentoCliente.setVisible( -1 );
      edtPagoToken_Visible = -1 ;
      edtPagoMonto_Visible = -1 ;
      edtSGCitaDisponibilidadFecha_Visible = -1 ;
      edtCitaCode_Visible = -1 ;
      edtCitaId_Visible = -1 ;
      edtPagoId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Pago" );
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
      Ddo_grid_Datalistproc = "PagoWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||6:RUC,1:DNI,4:CARNET DE EXT.,7:PASAPORTE,A:CDI,0:NO DOMICILIADO|||||1:Factura,2:Boleta,3:Nota Credito,4:Nota Debito|||1:Soles,2:Dólares,3:Euros||||||||||A:Activo,I:Inactivo" ;
      Ddo_grid_Allowmultipleselection = "||||||T|||||T|||T||||||||||T" ;
      Ddo_grid_Datalisttype = "||Dynamic|||Dynamic|FixedValues|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|||FixedValues|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|||Dynamic|Dynamic|FixedValues" ;
      Ddo_grid_Includedatalist = "||T|||T|T|T|T|T|T|T|||T|T|T|T|T|T|||T|T|T" ;
      Ddo_grid_Filterisrange = "T|T||P|T||||||||T|P|||||||T|T|||" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Character|Date|Numeric|Character||Character|Character|Character|Character||Numeric|Date||Character|Character|Character|Character|Character|Numeric|Numeric|Character|Character|" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T||T|T|T|T||T|T||T|T|T|T|T|T|T|T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|1|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25" ;
      Ddo_grid_Columnids = "2:PagoId|3:CitaId|4:CitaCode|5:SGCitaDisponibilidadFecha|6:PagoMonto|7:PagoToken|8:PagoTipoDocumentoCliente|9:PagoClienteNroDocumento|10:PagoClienteDenominacion|11:PagoClienteDireccion|12:PagoClienteEmail|13:PagoTipoDocumento|14:PagoNumero|15:PagoFechaEmision|16:PagoMoneda|17:PagoNubefactRequest|18:PagoNubefactResponse|19:PagoRequest|20:PagoResponse|21:PagoPasarelaId|22:PagoStatusCode|23:DisponibilidadId|24:PagoEnlacePDF|25:PagoEnlaceXML|26:PagoEstadoR" ;
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
      GXCCtl = "PAGOTIPODOCUMENTOCLIENTE_" + sGXsfl_43_idx ;
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
      GXCCtl = "PAGOTIPODOCUMENTO_" + sGXsfl_43_idx ;
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
      GXCCtl = "PAGOMONEDA_" + sGXsfl_43_idx ;
      cmbPagoMoneda.setName( GXCCtl );
      cmbPagoMoneda.setWebtags( "" );
      cmbPagoMoneda.addItem("1", "Soles", (short)(0));
      cmbPagoMoneda.addItem("2", "Dólares", (short)(0));
      cmbPagoMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbPagoMoneda.getItemCount() > 0 )
      {
         A253PagoMoneda = (short)(GXutil.lval( cmbPagoMoneda.getValidValue(GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0))))) ;
      }
      GXCCtl = "PAGOESTADOR_" + sGXsfl_43_idx ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPagoId_Visible',ctrl:'PAGOID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtCitaCode_Visible',ctrl:'CITACODE',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtPagoMonto_Visible',ctrl:'PAGOMONTO',prop:'Visible'},{av:'edtPagoToken_Visible',ctrl:'PAGOTOKEN',prop:'Visible'},{av:'cmbPagoTipoDocumentoCliente'},{av:'edtPagoClienteNroDocumento_Visible',ctrl:'PAGOCLIENTENRODOCUMENTO',prop:'Visible'},{av:'edtPagoClienteDenominacion_Visible',ctrl:'PAGOCLIENTEDENOMINACION',prop:'Visible'},{av:'edtPagoClienteDireccion_Visible',ctrl:'PAGOCLIENTEDIRECCION',prop:'Visible'},{av:'edtPagoClienteEmail_Visible',ctrl:'PAGOCLIENTEEMAIL',prop:'Visible'},{av:'cmbPagoTipoDocumento'},{av:'edtPagoNumero_Visible',ctrl:'PAGONUMERO',prop:'Visible'},{av:'edtPagoFechaEmision_Visible',ctrl:'PAGOFECHAEMISION',prop:'Visible'},{av:'cmbPagoMoneda'},{av:'edtPagoNubefactRequest_Visible',ctrl:'PAGONUBEFACTREQUEST',prop:'Visible'},{av:'edtPagoNubefactResponse_Visible',ctrl:'PAGONUBEFACTRESPONSE',prop:'Visible'},{av:'edtPagoRequest_Visible',ctrl:'PAGOREQUEST',prop:'Visible'},{av:'edtPagoResponse_Visible',ctrl:'PAGORESPONSE',prop:'Visible'},{av:'edtPagoPasarelaId_Visible',ctrl:'PAGOPASARELAID',prop:'Visible'},{av:'edtPagoStatusCode_Visible',ctrl:'PAGOSTATUSCODE',prop:'Visible'},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'edtPagoEnlacePDF_Visible',ctrl:'PAGOENLACEPDF',prop:'Visible'},{av:'edtPagoEnlaceXML_Visible',ctrl:'PAGOENLACEXML',prop:'Visible'},{av:'cmbPagoEstadoR'},{av:'AV75GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV76GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12262',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13262',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e14262',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21262',iparms:[{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A338PagoEnlacePDF',fld:'PAGOENLACEPDF',pic:''},{av:'A339PagoEnlaceXML',fld:'PAGOENLACEXML',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV77Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV79Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtCitaCode_Link',ctrl:'CITACODE',prop:'Link'},{av:'edtPagoMonto_Link',ctrl:'PAGOMONTO',prop:'Link'},{av:'edtPagoEnlacePDF_Linktarget',ctrl:'PAGOENLACEPDF',prop:'Linktarget'},{av:'edtPagoEnlacePDF_Link',ctrl:'PAGOENLACEPDF',prop:'Link'},{av:'edtPagoEnlaceXML_Linktarget',ctrl:'PAGOENLACEXML',prop:'Linktarget'},{av:'edtPagoEnlaceXML_Link',ctrl:'PAGOENLACEXML',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e15262',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtPagoId_Visible',ctrl:'PAGOID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtCitaCode_Visible',ctrl:'CITACODE',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtPagoMonto_Visible',ctrl:'PAGOMONTO',prop:'Visible'},{av:'edtPagoToken_Visible',ctrl:'PAGOTOKEN',prop:'Visible'},{av:'cmbPagoTipoDocumentoCliente'},{av:'edtPagoClienteNroDocumento_Visible',ctrl:'PAGOCLIENTENRODOCUMENTO',prop:'Visible'},{av:'edtPagoClienteDenominacion_Visible',ctrl:'PAGOCLIENTEDENOMINACION',prop:'Visible'},{av:'edtPagoClienteDireccion_Visible',ctrl:'PAGOCLIENTEDIRECCION',prop:'Visible'},{av:'edtPagoClienteEmail_Visible',ctrl:'PAGOCLIENTEEMAIL',prop:'Visible'},{av:'cmbPagoTipoDocumento'},{av:'edtPagoNumero_Visible',ctrl:'PAGONUMERO',prop:'Visible'},{av:'edtPagoFechaEmision_Visible',ctrl:'PAGOFECHAEMISION',prop:'Visible'},{av:'cmbPagoMoneda'},{av:'edtPagoNubefactRequest_Visible',ctrl:'PAGONUBEFACTREQUEST',prop:'Visible'},{av:'edtPagoNubefactResponse_Visible',ctrl:'PAGONUBEFACTRESPONSE',prop:'Visible'},{av:'edtPagoRequest_Visible',ctrl:'PAGOREQUEST',prop:'Visible'},{av:'edtPagoResponse_Visible',ctrl:'PAGORESPONSE',prop:'Visible'},{av:'edtPagoPasarelaId_Visible',ctrl:'PAGOPASARELAID',prop:'Visible'},{av:'edtPagoStatusCode_Visible',ctrl:'PAGOSTATUSCODE',prop:'Visible'},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'edtPagoEnlacePDF_Visible',ctrl:'PAGOENLACEPDF',prop:'Visible'},{av:'edtPagoEnlaceXML_Visible',ctrl:'PAGOENLACEXML',prop:'Visible'},{av:'cmbPagoEstadoR'},{av:'AV75GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV76GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11262',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPagoId_Visible',ctrl:'PAGOID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtCitaCode_Visible',ctrl:'CITACODE',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtPagoMonto_Visible',ctrl:'PAGOMONTO',prop:'Visible'},{av:'edtPagoToken_Visible',ctrl:'PAGOTOKEN',prop:'Visible'},{av:'cmbPagoTipoDocumentoCliente'},{av:'edtPagoClienteNroDocumento_Visible',ctrl:'PAGOCLIENTENRODOCUMENTO',prop:'Visible'},{av:'edtPagoClienteDenominacion_Visible',ctrl:'PAGOCLIENTEDENOMINACION',prop:'Visible'},{av:'edtPagoClienteDireccion_Visible',ctrl:'PAGOCLIENTEDIRECCION',prop:'Visible'},{av:'edtPagoClienteEmail_Visible',ctrl:'PAGOCLIENTEEMAIL',prop:'Visible'},{av:'cmbPagoTipoDocumento'},{av:'edtPagoNumero_Visible',ctrl:'PAGONUMERO',prop:'Visible'},{av:'edtPagoFechaEmision_Visible',ctrl:'PAGOFECHAEMISION',prop:'Visible'},{av:'cmbPagoMoneda'},{av:'edtPagoNubefactRequest_Visible',ctrl:'PAGONUBEFACTREQUEST',prop:'Visible'},{av:'edtPagoNubefactResponse_Visible',ctrl:'PAGONUBEFACTRESPONSE',prop:'Visible'},{av:'edtPagoRequest_Visible',ctrl:'PAGOREQUEST',prop:'Visible'},{av:'edtPagoResponse_Visible',ctrl:'PAGORESPONSE',prop:'Visible'},{av:'edtPagoPasarelaId_Visible',ctrl:'PAGOPASARELAID',prop:'Visible'},{av:'edtPagoStatusCode_Visible',ctrl:'PAGOSTATUSCODE',prop:'Visible'},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'edtPagoEnlacePDF_Visible',ctrl:'PAGOENLACEPDF',prop:'Visible'},{av:'edtPagoEnlaceXML_Visible',ctrl:'PAGOENLACEXML',prop:'Visible'},{av:'cmbPagoEstadoR'},{av:'AV75GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV76GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16262',iparms:[{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17262',iparms:[{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e18262',iparms:[{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPagoId',fld:'vTFPAGOID',pic:'ZZZZZZZ9'},{av:'AV28TFPagoId_To',fld:'vTFPAGOID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV32TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV33TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV34TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV37TFPagoMonto',fld:'vTFPAGOMONTO',pic:'ZZ9.99'},{av:'AV38TFPagoMonto_To',fld:'vTFPAGOMONTO_TO',pic:'ZZ9.99'},{av:'AV39TFPagoToken',fld:'vTFPAGOTOKEN',pic:''},{av:'AV40TFPagoToken_Sel',fld:'vTFPAGOTOKEN_SEL',pic:''},{av:'AV42TFPagoTipoDocumentoCliente_Sels',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELS',pic:''},{av:'AV43TFPagoClienteNroDocumento',fld:'vTFPAGOCLIENTENRODOCUMENTO',pic:''},{av:'AV44TFPagoClienteNroDocumento_Sel',fld:'vTFPAGOCLIENTENRODOCUMENTO_SEL',pic:''},{av:'AV45TFPagoClienteDenominacion',fld:'vTFPAGOCLIENTEDENOMINACION',pic:''},{av:'AV46TFPagoClienteDenominacion_Sel',fld:'vTFPAGOCLIENTEDENOMINACION_SEL',pic:''},{av:'AV47TFPagoClienteDireccion',fld:'vTFPAGOCLIENTEDIRECCION',pic:''},{av:'AV48TFPagoClienteDireccion_Sel',fld:'vTFPAGOCLIENTEDIRECCION_SEL',pic:''},{av:'AV49TFPagoClienteEmail',fld:'vTFPAGOCLIENTEEMAIL',pic:''},{av:'AV50TFPagoClienteEmail_Sel',fld:'vTFPAGOCLIENTEEMAIL_SEL',pic:''},{av:'AV52TFPagoTipoDocumento_Sels',fld:'vTFPAGOTIPODOCUMENTO_SELS',pic:''},{av:'AV53TFPagoNumero',fld:'vTFPAGONUMERO',pic:'ZZZZZZZ9'},{av:'AV54TFPagoNumero_To',fld:'vTFPAGONUMERO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFPagoFechaEmision',fld:'vTFPAGOFECHAEMISION',pic:''},{av:'AV56TFPagoFechaEmision_To',fld:'vTFPAGOFECHAEMISION_TO',pic:''},{av:'AV60TFPagoMoneda_Sels',fld:'vTFPAGOMONEDA_SELS',pic:''},{av:'AV67TFPagoNubefactRequest',fld:'vTFPAGONUBEFACTREQUEST',pic:''},{av:'AV68TFPagoNubefactRequest_Sel',fld:'vTFPAGONUBEFACTREQUEST_SEL',pic:''},{av:'AV69TFPagoNubefactResponse',fld:'vTFPAGONUBEFACTRESPONSE',pic:''},{av:'AV70TFPagoNubefactResponse_Sel',fld:'vTFPAGONUBEFACTRESPONSE_SEL',pic:''},{av:'AV86TFPagoRequest',fld:'vTFPAGOREQUEST',pic:''},{av:'AV87TFPagoRequest_Sel',fld:'vTFPAGOREQUEST_SEL',pic:''},{av:'AV88TFPagoResponse',fld:'vTFPAGORESPONSE',pic:''},{av:'AV89TFPagoResponse_Sel',fld:'vTFPAGORESPONSE_SEL',pic:''},{av:'AV90TFPagoPasarelaId',fld:'vTFPAGOPASARELAID',pic:''},{av:'AV91TFPagoPasarelaId_Sel',fld:'vTFPAGOPASARELAID_SEL',pic:''},{av:'AV92TFPagoStatusCode',fld:'vTFPAGOSTATUSCODE',pic:'ZZZZZZZ9'},{av:'AV93TFPagoStatusCode_To',fld:'vTFPAGOSTATUSCODE_TO',pic:'ZZZZZZZ9'},{av:'AV94TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV95TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV96TFPagoEnlacePDF',fld:'vTFPAGOENLACEPDF',pic:''},{av:'AV97TFPagoEnlacePDF_Sel',fld:'vTFPAGOENLACEPDF_SEL',pic:''},{av:'AV98TFPagoEnlaceXML',fld:'vTFPAGOENLACEXML',pic:''},{av:'AV99TFPagoEnlaceXML_Sel',fld:'vTFPAGOENLACEXML_SEL',pic:''},{av:'AV72TFPagoEstadoR_Sels',fld:'vTFPAGOESTADOR_SELS',pic:''},{av:'AV149Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV78IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV80IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV83IsAuthorized_CitaCode',fld:'vISAUTHORIZED_CITACODE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV71TFPagoEstadoR_SelsJson',fld:'vTFPAGOESTADOR_SELSJSON',pic:''},{av:'AV59TFPagoMoneda_SelsJson',fld:'vTFPAGOMONEDA_SELSJSON',pic:''},{av:'AV51TFPagoTipoDocumento_SelsJson',fld:'vTFPAGOTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV41TFPagoTipoDocumentoCliente_SelsJson',fld:'vTFPAGOTIPODOCUMENTOCLIENTE_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
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
      AV31TFCitaCode = "" ;
      AV32TFCitaCode_Sel = "" ;
      AV33TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV34TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV37TFPagoMonto = DecimalUtil.ZERO ;
      AV38TFPagoMonto_To = DecimalUtil.ZERO ;
      AV39TFPagoToken = "" ;
      AV40TFPagoToken_Sel = "" ;
      AV42TFPagoTipoDocumentoCliente_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFPagoClienteNroDocumento = "" ;
      AV44TFPagoClienteNroDocumento_Sel = "" ;
      AV45TFPagoClienteDenominacion = "" ;
      AV46TFPagoClienteDenominacion_Sel = "" ;
      AV47TFPagoClienteDireccion = "" ;
      AV48TFPagoClienteDireccion_Sel = "" ;
      AV49TFPagoClienteEmail = "" ;
      AV50TFPagoClienteEmail_Sel = "" ;
      AV52TFPagoTipoDocumento_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV55TFPagoFechaEmision = GXutil.nullDate() ;
      AV56TFPagoFechaEmision_To = GXutil.nullDate() ;
      AV60TFPagoMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV67TFPagoNubefactRequest = "" ;
      AV68TFPagoNubefactRequest_Sel = "" ;
      AV69TFPagoNubefactResponse = "" ;
      AV70TFPagoNubefactResponse_Sel = "" ;
      AV86TFPagoRequest = "" ;
      AV87TFPagoRequest_Sel = "" ;
      AV88TFPagoResponse = "" ;
      AV89TFPagoResponse_Sel = "" ;
      AV90TFPagoPasarelaId = "" ;
      AV91TFPagoPasarelaId_Sel = "" ;
      AV96TFPagoEnlacePDF = "" ;
      AV97TFPagoEnlacePDF_Sel = "" ;
      AV98TFPagoEnlaceXML = "" ;
      AV99TFPagoEnlaceXML_Sel = "" ;
      AV72TFPagoEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV149Pgmname = "" ;
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
      AV73DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV36DDO_SGCitaDisponibilidadFechaAuxDateTo = GXutil.nullDate() ;
      AV58DDO_PagoFechaEmisionAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV41TFPagoTipoDocumentoCliente_SelsJson = "" ;
      AV51TFPagoTipoDocumento_SelsJson = "" ;
      AV59TFPagoMoneda_SelsJson = "" ;
      AV71TFPagoEstadoR_SelsJson = "" ;
      AV35DDO_SGCitaDisponibilidadFechaAuxDate = GXutil.nullDate() ;
      AV57DDO_PagoFechaEmisionAuxDate = GXutil.nullDate() ;
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
      AV77Update = "" ;
      AV79Delete = "" ;
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
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV84DDO_SGCitaDisponibilidadFechaAuxDateText = "" ;
      ucTfsgcitadisponibilidadfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV85DDO_PagoFechaEmisionAuxDateText = "" ;
      ucTfpagofechaemision_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV115Pagowwds_14_tfpagotipodocumentocliente_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV124Pagowwds_23_tfpagotipodocumento_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV129Pagowwds_28_tfpagomoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV148Pagowwds_47_tfpagoestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV102Pagowwds_1_filterfulltext = "" ;
      lV107Pagowwds_6_tfcitacode = "" ;
      lV113Pagowwds_12_tfpagotoken = "" ;
      lV116Pagowwds_15_tfpagoclientenrodocumento = "" ;
      lV118Pagowwds_17_tfpagoclientedenominacion = "" ;
      lV120Pagowwds_19_tfpagoclientedireccion = "" ;
      lV122Pagowwds_21_tfpagoclienteemail = "" ;
      lV130Pagowwds_29_tfpagonubefactrequest = "" ;
      lV132Pagowwds_31_tfpagonubefactresponse = "" ;
      lV134Pagowwds_33_tfpagorequest = "" ;
      lV136Pagowwds_35_tfpagoresponse = "" ;
      lV138Pagowwds_37_tfpagopasarelaid = "" ;
      lV144Pagowwds_43_tfpagoenlacepdf = "" ;
      lV146Pagowwds_45_tfpagoenlacexml = "" ;
      AV102Pagowwds_1_filterfulltext = "" ;
      AV108Pagowwds_7_tfcitacode_sel = "" ;
      AV107Pagowwds_6_tfcitacode = "" ;
      AV109Pagowwds_8_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV111Pagowwds_10_tfpagomonto = DecimalUtil.ZERO ;
      AV112Pagowwds_11_tfpagomonto_to = DecimalUtil.ZERO ;
      AV114Pagowwds_13_tfpagotoken_sel = "" ;
      AV113Pagowwds_12_tfpagotoken = "" ;
      AV117Pagowwds_16_tfpagoclientenrodocumento_sel = "" ;
      AV116Pagowwds_15_tfpagoclientenrodocumento = "" ;
      AV119Pagowwds_18_tfpagoclientedenominacion_sel = "" ;
      AV118Pagowwds_17_tfpagoclientedenominacion = "" ;
      AV121Pagowwds_20_tfpagoclientedireccion_sel = "" ;
      AV120Pagowwds_19_tfpagoclientedireccion = "" ;
      AV123Pagowwds_22_tfpagoclienteemail_sel = "" ;
      AV122Pagowwds_21_tfpagoclienteemail = "" ;
      AV127Pagowwds_26_tfpagofechaemision = GXutil.nullDate() ;
      AV128Pagowwds_27_tfpagofechaemision_to = GXutil.nullDate() ;
      AV131Pagowwds_30_tfpagonubefactrequest_sel = "" ;
      AV130Pagowwds_29_tfpagonubefactrequest = "" ;
      AV133Pagowwds_32_tfpagonubefactresponse_sel = "" ;
      AV132Pagowwds_31_tfpagonubefactresponse = "" ;
      AV135Pagowwds_34_tfpagorequest_sel = "" ;
      AV134Pagowwds_33_tfpagorequest = "" ;
      AV137Pagowwds_36_tfpagoresponse_sel = "" ;
      AV136Pagowwds_35_tfpagoresponse = "" ;
      AV139Pagowwds_38_tfpagopasarelaid_sel = "" ;
      AV138Pagowwds_37_tfpagopasarelaid = "" ;
      AV145Pagowwds_44_tfpagoenlacepdf_sel = "" ;
      AV144Pagowwds_43_tfpagoenlacepdf = "" ;
      AV147Pagowwds_46_tfpagoenlacexml_sel = "" ;
      AV146Pagowwds_45_tfpagoenlacexml = "" ;
      H00262_A21SGCitaDisponibilidadId = new int[1] ;
      H00262_A246PagoEstadoR = new String[] {""} ;
      H00262_A339PagoEnlaceXML = new String[] {""} ;
      H00262_A338PagoEnlacePDF = new String[] {""} ;
      H00262_A34DisponibilidadId = new int[1] ;
      H00262_n34DisponibilidadId = new boolean[] {false} ;
      H00262_A311PagoStatusCode = new int[1] ;
      H00262_A310PagoPasarelaId = new String[] {""} ;
      H00262_A309PagoResponse = new String[] {""} ;
      H00262_A308PagoRequest = new String[] {""} ;
      H00262_A257PagoNubefactResponse = new String[] {""} ;
      H00262_A256PagoNubefactRequest = new String[] {""} ;
      H00262_A253PagoMoneda = new short[1] ;
      H00262_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      H00262_A245PagoNumero = new int[1] ;
      H00262_A244PagoTipoDocumento = new short[1] ;
      H00262_A251PagoClienteEmail = new String[] {""} ;
      H00262_A250PagoClienteDireccion = new String[] {""} ;
      H00262_A249PagoClienteDenominacion = new String[] {""} ;
      H00262_A248PagoClienteNroDocumento = new String[] {""} ;
      H00262_A247PagoTipoDocumentoCliente = new String[] {""} ;
      H00262_A243PagoToken = new String[] {""} ;
      H00262_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00262_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00262_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H00262_A64CitaCode = new String[] {""} ;
      H00262_A19CitaId = new int[1] ;
      H00262_n19CitaId = new boolean[] {false} ;
      H00262_A47PagoId = new int[1] ;
      H00263_AGRID_nRecordCount = new long[1] ;
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
      GXv_char8 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char38 = "" ;
      GXv_char39 = new String[1] ;
      GXt_char36 = "" ;
      GXv_char37 = new String[1] ;
      GXt_char34 = "" ;
      GXv_char35 = new String[1] ;
      GXt_char32 = "" ;
      GXv_char33 = new String[1] ;
      GXt_char30 = "" ;
      GXv_char31 = new String[1] ;
      GXt_char28 = "" ;
      GXv_char29 = new String[1] ;
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
      GXv_SdtWWPGridState40 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagoww__default(),
         new Object[] {
             new Object[] {
            H00262_A21SGCitaDisponibilidadId, H00262_A246PagoEstadoR, H00262_A339PagoEnlaceXML, H00262_A338PagoEnlacePDF, H00262_A34DisponibilidadId, H00262_n34DisponibilidadId, H00262_A311PagoStatusCode, H00262_A310PagoPasarelaId, H00262_A309PagoResponse, H00262_A308PagoRequest,
            H00262_A257PagoNubefactResponse, H00262_A256PagoNubefactRequest, H00262_A253PagoMoneda, H00262_A252PagoFechaEmision, H00262_A245PagoNumero, H00262_A244PagoTipoDocumento, H00262_A251PagoClienteEmail, H00262_A250PagoClienteDireccion, H00262_A249PagoClienteDenominacion, H00262_A248PagoClienteNroDocumento,
            H00262_A247PagoTipoDocumentoCliente, H00262_A243PagoToken, H00262_A242PagoMonto, H00262_A66SGCitaDisponibilidadFecha, H00262_n66SGCitaDisponibilidadFecha, H00262_A64CitaCode, H00262_A19CitaId, H00262_n19CitaId, H00262_A47PagoId
            }
            , new Object[] {
            H00263_AGRID_nRecordCount
            }
         }
      );
      AV149Pgmname = "PagoWW" ;
      /* GeneXus formulas. */
      AV149Pgmname = "PagoWW" ;
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
   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV27TFPagoId ;
   private int AV28TFPagoId_To ;
   private int AV29TFCitaId ;
   private int AV30TFCitaId_To ;
   private int AV53TFPagoNumero ;
   private int AV54TFPagoNumero_To ;
   private int AV92TFPagoStatusCode ;
   private int AV93TFPagoStatusCode_To ;
   private int AV94TFDisponibilidadId ;
   private int AV95TFDisponibilidadId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtPagoId_Visible ;
   private int edtCitaId_Visible ;
   private int edtCitaCode_Visible ;
   private int edtSGCitaDisponibilidadFecha_Visible ;
   private int edtPagoMonto_Visible ;
   private int edtPagoToken_Visible ;
   private int edtPagoClienteNroDocumento_Visible ;
   private int edtPagoClienteDenominacion_Visible ;
   private int edtPagoClienteDireccion_Visible ;
   private int edtPagoClienteEmail_Visible ;
   private int edtPagoNumero_Visible ;
   private int edtPagoFechaEmision_Visible ;
   private int edtPagoNubefactRequest_Visible ;
   private int edtPagoNubefactResponse_Visible ;
   private int edtPagoRequest_Visible ;
   private int edtPagoResponse_Visible ;
   private int edtPagoPasarelaId_Visible ;
   private int edtPagoStatusCode_Visible ;
   private int edtDisponibilidadId_Visible ;
   private int edtPagoEnlacePDF_Visible ;
   private int edtPagoEnlaceXML_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
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
   private int AV115Pagowwds_14_tfpagotipodocumentocliente_sels_size ;
   private int AV124Pagowwds_23_tfpagotipodocumento_sels_size ;
   private int AV129Pagowwds_28_tfpagomoneda_sels_size ;
   private int AV148Pagowwds_47_tfpagoestador_sels_size ;
   private int AV103Pagowwds_2_tfpagoid ;
   private int AV104Pagowwds_3_tfpagoid_to ;
   private int AV105Pagowwds_4_tfcitaid ;
   private int AV106Pagowwds_5_tfcitaid_to ;
   private int AV125Pagowwds_24_tfpagonumero ;
   private int AV126Pagowwds_25_tfpagonumero_to ;
   private int AV140Pagowwds_39_tfpagostatuscode ;
   private int AV141Pagowwds_40_tfpagostatuscode_to ;
   private int AV142Pagowwds_41_tfdisponibilidadid ;
   private int AV143Pagowwds_42_tfdisponibilidadid_to ;
   private int A21SGCitaDisponibilidadId ;
   private int AV74PageToGo ;
   private int AV150GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV75GridCurrentPage ;
   private long AV76GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV37TFPagoMonto ;
   private java.math.BigDecimal AV38TFPagoMonto_To ;
   private java.math.BigDecimal A242PagoMonto ;
   private java.math.BigDecimal AV111Pagowwds_10_tfpagomonto ;
   private java.math.BigDecimal AV112Pagowwds_11_tfpagomonto_to ;
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
   private String AV149Pgmname ;
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
   private String AV77Update ;
   private String edtavUpdate_Link ;
   private String AV79Delete ;
   private String edtavDelete_Link ;
   private String edtCitaCode_Link ;
   private String edtPagoMonto_Link ;
   private String A247PagoTipoDocumentoCliente ;
   private String edtPagoEnlacePDF_Link ;
   private String edtPagoEnlacePDF_Linktarget ;
   private String edtPagoEnlaceXML_Link ;
   private String edtPagoEnlaceXML_Linktarget ;
   private String A246PagoEstadoR ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_sgcitadisponibilidadfechaauxdates_Internalname ;
   private String edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname ;
   private String edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick ;
   private String Tfsgcitadisponibilidadfecha_rangepicker_Internalname ;
   private String divDdo_pagofechaemisionauxdates_Internalname ;
   private String edtavDdo_pagofechaemisionauxdatetext_Internalname ;
   private String edtavDdo_pagofechaemisionauxdatetext_Jsonclick ;
   private String Tfpagofechaemision_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
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
   private String GXt_char6 ;
   private String GXv_char8[] ;
   private String GXt_char13 ;
   private String GXv_char7[] ;
   private String GXt_char38 ;
   private String GXv_char39[] ;
   private String GXt_char36 ;
   private String GXv_char37[] ;
   private String GXt_char34 ;
   private String GXv_char35[] ;
   private String GXt_char32 ;
   private String GXv_char33[] ;
   private String GXt_char30 ;
   private String GXv_char31[] ;
   private String GXt_char28 ;
   private String GXv_char29[] ;
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
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
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
   private java.util.Date AV33TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV34TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV55TFPagoFechaEmision ;
   private java.util.Date AV56TFPagoFechaEmision_To ;
   private java.util.Date AV36DDO_SGCitaDisponibilidadFechaAuxDateTo ;
   private java.util.Date AV58DDO_PagoFechaEmisionAuxDateTo ;
   private java.util.Date AV35DDO_SGCitaDisponibilidadFechaAuxDate ;
   private java.util.Date AV57DDO_PagoFechaEmisionAuxDate ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private java.util.Date AV109Pagowwds_8_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date AV127Pagowwds_26_tfpagofechaemision ;
   private java.util.Date AV128Pagowwds_27_tfpagofechaemision_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV78IsAuthorized_Update ;
   private boolean AV80IsAuthorized_Delete ;
   private boolean AV83IsAuthorized_CitaCode ;
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
   private boolean n19CitaId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n34DisponibilidadId ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV81TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV41TFPagoTipoDocumentoCliente_SelsJson ;
   private String AV51TFPagoTipoDocumento_SelsJson ;
   private String AV59TFPagoMoneda_SelsJson ;
   private String AV71TFPagoEstadoR_SelsJson ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV31TFCitaCode ;
   private String AV32TFCitaCode_Sel ;
   private String AV39TFPagoToken ;
   private String AV40TFPagoToken_Sel ;
   private String AV43TFPagoClienteNroDocumento ;
   private String AV44TFPagoClienteNroDocumento_Sel ;
   private String AV45TFPagoClienteDenominacion ;
   private String AV46TFPagoClienteDenominacion_Sel ;
   private String AV47TFPagoClienteDireccion ;
   private String AV48TFPagoClienteDireccion_Sel ;
   private String AV49TFPagoClienteEmail ;
   private String AV50TFPagoClienteEmail_Sel ;
   private String AV67TFPagoNubefactRequest ;
   private String AV68TFPagoNubefactRequest_Sel ;
   private String AV69TFPagoNubefactResponse ;
   private String AV70TFPagoNubefactResponse_Sel ;
   private String AV86TFPagoRequest ;
   private String AV87TFPagoRequest_Sel ;
   private String AV88TFPagoResponse ;
   private String AV89TFPagoResponse_Sel ;
   private String AV90TFPagoPasarelaId ;
   private String AV91TFPagoPasarelaId_Sel ;
   private String AV96TFPagoEnlacePDF ;
   private String AV97TFPagoEnlacePDF_Sel ;
   private String AV98TFPagoEnlaceXML ;
   private String AV99TFPagoEnlaceXML_Sel ;
   private String A64CitaCode ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String AV84DDO_SGCitaDisponibilidadFechaAuxDateText ;
   private String AV85DDO_PagoFechaEmisionAuxDateText ;
   private String lV102Pagowwds_1_filterfulltext ;
   private String lV107Pagowwds_6_tfcitacode ;
   private String lV113Pagowwds_12_tfpagotoken ;
   private String lV116Pagowwds_15_tfpagoclientenrodocumento ;
   private String lV118Pagowwds_17_tfpagoclientedenominacion ;
   private String lV120Pagowwds_19_tfpagoclientedireccion ;
   private String lV122Pagowwds_21_tfpagoclienteemail ;
   private String lV130Pagowwds_29_tfpagonubefactrequest ;
   private String lV132Pagowwds_31_tfpagonubefactresponse ;
   private String lV134Pagowwds_33_tfpagorequest ;
   private String lV136Pagowwds_35_tfpagoresponse ;
   private String lV138Pagowwds_37_tfpagopasarelaid ;
   private String lV144Pagowwds_43_tfpagoenlacepdf ;
   private String lV146Pagowwds_45_tfpagoenlacexml ;
   private String AV102Pagowwds_1_filterfulltext ;
   private String AV108Pagowwds_7_tfcitacode_sel ;
   private String AV107Pagowwds_6_tfcitacode ;
   private String AV114Pagowwds_13_tfpagotoken_sel ;
   private String AV113Pagowwds_12_tfpagotoken ;
   private String AV117Pagowwds_16_tfpagoclientenrodocumento_sel ;
   private String AV116Pagowwds_15_tfpagoclientenrodocumento ;
   private String AV119Pagowwds_18_tfpagoclientedenominacion_sel ;
   private String AV118Pagowwds_17_tfpagoclientedenominacion ;
   private String AV121Pagowwds_20_tfpagoclientedireccion_sel ;
   private String AV120Pagowwds_19_tfpagoclientedireccion ;
   private String AV123Pagowwds_22_tfpagoclienteemail_sel ;
   private String AV122Pagowwds_21_tfpagoclienteemail ;
   private String AV131Pagowwds_30_tfpagonubefactrequest_sel ;
   private String AV130Pagowwds_29_tfpagonubefactrequest ;
   private String AV133Pagowwds_32_tfpagonubefactresponse_sel ;
   private String AV132Pagowwds_31_tfpagonubefactresponse ;
   private String AV135Pagowwds_34_tfpagorequest_sel ;
   private String AV134Pagowwds_33_tfpagorequest ;
   private String AV137Pagowwds_36_tfpagoresponse_sel ;
   private String AV136Pagowwds_35_tfpagoresponse ;
   private String AV139Pagowwds_38_tfpagopasarelaid_sel ;
   private String AV138Pagowwds_37_tfpagopasarelaid ;
   private String AV145Pagowwds_44_tfpagoenlacepdf_sel ;
   private String AV144Pagowwds_43_tfpagoenlacepdf ;
   private String AV147Pagowwds_46_tfpagoenlacexml_sel ;
   private String AV146Pagowwds_45_tfpagoenlacexml ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private GXSimpleCollection<Short> AV124Pagowwds_23_tfpagotipodocumento_sels ;
   private GXSimpleCollection<Short> AV129Pagowwds_28_tfpagomoneda_sels ;
   private GXSimpleCollection<Short> AV52TFPagoTipoDocumento_Sels ;
   private GXSimpleCollection<Short> AV60TFPagoMoneda_Sels ;
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
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfpagofechaemision_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV115Pagowwds_14_tfpagotipodocumentocliente_sels ;
   private GXSimpleCollection<String> AV148Pagowwds_47_tfpagoestador_sels ;
   private HTMLChoice cmbPagoTipoDocumentoCliente ;
   private HTMLChoice cmbPagoTipoDocumento ;
   private HTMLChoice cmbPagoMoneda ;
   private HTMLChoice cmbPagoEstadoR ;
   private IDataStoreProvider pr_default ;
   private int[] H00262_A21SGCitaDisponibilidadId ;
   private String[] H00262_A246PagoEstadoR ;
   private String[] H00262_A339PagoEnlaceXML ;
   private String[] H00262_A338PagoEnlacePDF ;
   private int[] H00262_A34DisponibilidadId ;
   private boolean[] H00262_n34DisponibilidadId ;
   private int[] H00262_A311PagoStatusCode ;
   private String[] H00262_A310PagoPasarelaId ;
   private String[] H00262_A309PagoResponse ;
   private String[] H00262_A308PagoRequest ;
   private String[] H00262_A257PagoNubefactResponse ;
   private String[] H00262_A256PagoNubefactRequest ;
   private short[] H00262_A253PagoMoneda ;
   private java.util.Date[] H00262_A252PagoFechaEmision ;
   private int[] H00262_A245PagoNumero ;
   private short[] H00262_A244PagoTipoDocumento ;
   private String[] H00262_A251PagoClienteEmail ;
   private String[] H00262_A250PagoClienteDireccion ;
   private String[] H00262_A249PagoClienteDenominacion ;
   private String[] H00262_A248PagoClienteNroDocumento ;
   private String[] H00262_A247PagoTipoDocumentoCliente ;
   private String[] H00262_A243PagoToken ;
   private java.math.BigDecimal[] H00262_A242PagoMonto ;
   private java.util.Date[] H00262_A66SGCitaDisponibilidadFecha ;
   private boolean[] H00262_n66SGCitaDisponibilidadFecha ;
   private String[] H00262_A64CitaCode ;
   private int[] H00262_A19CitaId ;
   private boolean[] H00262_n19CitaId ;
   private int[] H00262_A47PagoId ;
   private long[] H00263_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV42TFPagoTipoDocumentoCliente_Sels ;
   private GXSimpleCollection<String> AV72TFPagoEstadoR_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState40[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV73DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class pagoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00262( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV115Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV124Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV129Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV148Pagowwds_47_tfpagoestador_sels ,
                                          String AV102Pagowwds_1_filterfulltext ,
                                          int AV103Pagowwds_2_tfpagoid ,
                                          int AV104Pagowwds_3_tfpagoid_to ,
                                          int AV105Pagowwds_4_tfcitaid ,
                                          int AV106Pagowwds_5_tfcitaid_to ,
                                          String AV108Pagowwds_7_tfcitacode_sel ,
                                          String AV107Pagowwds_6_tfcitacode ,
                                          java.util.Date AV109Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV111Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV112Pagowwds_11_tfpagomonto_to ,
                                          String AV114Pagowwds_13_tfpagotoken_sel ,
                                          String AV113Pagowwds_12_tfpagotoken ,
                                          int AV115Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV117Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV116Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV119Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV118Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV121Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV120Pagowwds_19_tfpagoclientedireccion ,
                                          String AV123Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV122Pagowwds_21_tfpagoclienteemail ,
                                          int AV124Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV125Pagowwds_24_tfpagonumero ,
                                          int AV126Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV127Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV128Pagowwds_27_tfpagofechaemision_to ,
                                          int AV129Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV131Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV130Pagowwds_29_tfpagonubefactrequest ,
                                          String AV133Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV132Pagowwds_31_tfpagonubefactresponse ,
                                          String AV135Pagowwds_34_tfpagorequest_sel ,
                                          String AV134Pagowwds_33_tfpagorequest ,
                                          String AV137Pagowwds_36_tfpagoresponse_sel ,
                                          String AV136Pagowwds_35_tfpagoresponse ,
                                          String AV139Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV138Pagowwds_37_tfpagopasarelaid ,
                                          int AV140Pagowwds_39_tfpagostatuscode ,
                                          int AV141Pagowwds_40_tfpagostatuscode_to ,
                                          int AV142Pagowwds_41_tfdisponibilidadid ,
                                          int AV143Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV145Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV144Pagowwds_43_tfpagoenlacepdf ,
                                          String AV147Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV146Pagowwds_45_tfpagoenlacexml ,
                                          int AV148Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int41 = new byte[79];
      Object[] GXv_Object42 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoPasarelaId]," ;
      sSelectString += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoFechaEmision], T1.[PagoNumero], T1.[PagoTipoDocumento]," ;
      sSelectString += " T1.[PagoClienteEmail], T1.[PagoClienteDireccion], T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T1.[PagoMonto]," ;
      sSelectString += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[CitaCode], T1.[CitaId], T1.[PagoId]" ;
      sFromString = " FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV102Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int41[0] = (byte)(1) ;
         GXv_int41[1] = (byte)(1) ;
         GXv_int41[2] = (byte)(1) ;
         GXv_int41[3] = (byte)(1) ;
         GXv_int41[4] = (byte)(1) ;
         GXv_int41[5] = (byte)(1) ;
         GXv_int41[6] = (byte)(1) ;
         GXv_int41[7] = (byte)(1) ;
         GXv_int41[8] = (byte)(1) ;
         GXv_int41[9] = (byte)(1) ;
         GXv_int41[10] = (byte)(1) ;
         GXv_int41[11] = (byte)(1) ;
         GXv_int41[12] = (byte)(1) ;
         GXv_int41[13] = (byte)(1) ;
         GXv_int41[14] = (byte)(1) ;
         GXv_int41[15] = (byte)(1) ;
         GXv_int41[16] = (byte)(1) ;
         GXv_int41[17] = (byte)(1) ;
         GXv_int41[18] = (byte)(1) ;
         GXv_int41[19] = (byte)(1) ;
         GXv_int41[20] = (byte)(1) ;
         GXv_int41[21] = (byte)(1) ;
         GXv_int41[22] = (byte)(1) ;
         GXv_int41[23] = (byte)(1) ;
         GXv_int41[24] = (byte)(1) ;
         GXv_int41[25] = (byte)(1) ;
         GXv_int41[26] = (byte)(1) ;
         GXv_int41[27] = (byte)(1) ;
         GXv_int41[28] = (byte)(1) ;
         GXv_int41[29] = (byte)(1) ;
         GXv_int41[30] = (byte)(1) ;
         GXv_int41[31] = (byte)(1) ;
         GXv_int41[32] = (byte)(1) ;
         GXv_int41[33] = (byte)(1) ;
      }
      if ( ! (0==AV103Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int41[34] = (byte)(1) ;
      }
      if ( ! (0==AV104Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int41[35] = (byte)(1) ;
      }
      if ( ! (0==AV105Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int41[36] = (byte)(1) ;
      }
      if ( ! (0==AV106Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int41[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV107Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int41[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int41[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV109Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int41[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int41[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int41[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int41[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV113Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int41[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int41[45] = (byte)(1) ;
      }
      if ( AV115Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV117Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV116Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int41[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV117Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int41[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int41[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int41[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int41[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int41[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int41[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int41[53] = (byte)(1) ;
      }
      if ( AV124Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV124Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV125Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int41[54] = (byte)(1) ;
      }
      if ( ! (0==AV126Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int41[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV127Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int41[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV128Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int41[57] = (byte)(1) ;
      }
      if ( AV129Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV129Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV131Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV130Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int41[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int41[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int41[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int41[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int41[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int41[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV137Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV136Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int41[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV137Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int41[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV139Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV138Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int41[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV139Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int41[67] = (byte)(1) ;
      }
      if ( ! (0==AV140Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int41[68] = (byte)(1) ;
      }
      if ( ! (0==AV141Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int41[69] = (byte)(1) ;
      }
      if ( ! (0==AV142Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int41[70] = (byte)(1) ;
      }
      if ( ! (0==AV143Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int41[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV145Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV144Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int41[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV145Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int41[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV147Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV146Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int41[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV147Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int41[75] = (byte)(1) ;
      }
      if ( AV148Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV148Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoMonto]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoMonto] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[CitaCode]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[CitaCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadFecha]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoToken]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoToken] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumentoCliente]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumentoCliente] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteNroDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteNroDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDenominacion]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDenominacion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDireccion]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteDireccion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoClienteEmail]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoClienteEmail] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoTipoDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoNumero]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoNumero] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoFechaEmision]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoFechaEmision] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoMoneda]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoMoneda] DESC" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactRequest]" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactRequest] DESC" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactResponse]" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoNubefactResponse] DESC" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoRequest]" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoRequest] DESC" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoResponse]" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoResponse] DESC" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoPasarelaId]" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoPasarelaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoStatusCode]" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoStatusCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoEnlacePDF]" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoEnlacePDF] DESC" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoEnlaceXML]" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoEnlaceXML] DESC" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PagoEstadoR]" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PagoEstadoR] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[PagoId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object42[0] = scmdbuf ;
      GXv_Object42[1] = GXv_int41 ;
      return GXv_Object42 ;
   }

   protected Object[] conditional_H00263( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV115Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV124Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV129Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV148Pagowwds_47_tfpagoestador_sels ,
                                          String AV102Pagowwds_1_filterfulltext ,
                                          int AV103Pagowwds_2_tfpagoid ,
                                          int AV104Pagowwds_3_tfpagoid_to ,
                                          int AV105Pagowwds_4_tfcitaid ,
                                          int AV106Pagowwds_5_tfcitaid_to ,
                                          String AV108Pagowwds_7_tfcitacode_sel ,
                                          String AV107Pagowwds_6_tfcitacode ,
                                          java.util.Date AV109Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV111Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV112Pagowwds_11_tfpagomonto_to ,
                                          String AV114Pagowwds_13_tfpagotoken_sel ,
                                          String AV113Pagowwds_12_tfpagotoken ,
                                          int AV115Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV117Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV116Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV119Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV118Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV121Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV120Pagowwds_19_tfpagoclientedireccion ,
                                          String AV123Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV122Pagowwds_21_tfpagoclienteemail ,
                                          int AV124Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV125Pagowwds_24_tfpagonumero ,
                                          int AV126Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV127Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV128Pagowwds_27_tfpagofechaemision_to ,
                                          int AV129Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV131Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV130Pagowwds_29_tfpagonubefactrequest ,
                                          String AV133Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV132Pagowwds_31_tfpagonubefactresponse ,
                                          String AV135Pagowwds_34_tfpagorequest_sel ,
                                          String AV134Pagowwds_33_tfpagorequest ,
                                          String AV137Pagowwds_36_tfpagoresponse_sel ,
                                          String AV136Pagowwds_35_tfpagoresponse ,
                                          String AV139Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV138Pagowwds_37_tfpagopasarelaid ,
                                          int AV140Pagowwds_39_tfpagostatuscode ,
                                          int AV141Pagowwds_40_tfpagostatuscode_to ,
                                          int AV142Pagowwds_41_tfdisponibilidadid ,
                                          int AV143Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV145Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV144Pagowwds_43_tfpagoenlacepdf ,
                                          String AV147Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV146Pagowwds_45_tfpagoenlacexml ,
                                          int AV148Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int44 = new byte[76];
      Object[] GXv_Object45 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV102Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int44[0] = (byte)(1) ;
         GXv_int44[1] = (byte)(1) ;
         GXv_int44[2] = (byte)(1) ;
         GXv_int44[3] = (byte)(1) ;
         GXv_int44[4] = (byte)(1) ;
         GXv_int44[5] = (byte)(1) ;
         GXv_int44[6] = (byte)(1) ;
         GXv_int44[7] = (byte)(1) ;
         GXv_int44[8] = (byte)(1) ;
         GXv_int44[9] = (byte)(1) ;
         GXv_int44[10] = (byte)(1) ;
         GXv_int44[11] = (byte)(1) ;
         GXv_int44[12] = (byte)(1) ;
         GXv_int44[13] = (byte)(1) ;
         GXv_int44[14] = (byte)(1) ;
         GXv_int44[15] = (byte)(1) ;
         GXv_int44[16] = (byte)(1) ;
         GXv_int44[17] = (byte)(1) ;
         GXv_int44[18] = (byte)(1) ;
         GXv_int44[19] = (byte)(1) ;
         GXv_int44[20] = (byte)(1) ;
         GXv_int44[21] = (byte)(1) ;
         GXv_int44[22] = (byte)(1) ;
         GXv_int44[23] = (byte)(1) ;
         GXv_int44[24] = (byte)(1) ;
         GXv_int44[25] = (byte)(1) ;
         GXv_int44[26] = (byte)(1) ;
         GXv_int44[27] = (byte)(1) ;
         GXv_int44[28] = (byte)(1) ;
         GXv_int44[29] = (byte)(1) ;
         GXv_int44[30] = (byte)(1) ;
         GXv_int44[31] = (byte)(1) ;
         GXv_int44[32] = (byte)(1) ;
         GXv_int44[33] = (byte)(1) ;
      }
      if ( ! (0==AV103Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int44[34] = (byte)(1) ;
      }
      if ( ! (0==AV104Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int44[35] = (byte)(1) ;
      }
      if ( ! (0==AV105Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int44[36] = (byte)(1) ;
      }
      if ( ! (0==AV106Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int44[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV107Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int44[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int44[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV109Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int44[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV110Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int44[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int44[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int44[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV113Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int44[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int44[45] = (byte)(1) ;
      }
      if ( AV115Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV117Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV116Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int44[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV117Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int44[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int44[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int44[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int44[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int44[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int44[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int44[53] = (byte)(1) ;
      }
      if ( AV124Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV124Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV125Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int44[54] = (byte)(1) ;
      }
      if ( ! (0==AV126Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int44[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV127Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int44[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV128Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int44[57] = (byte)(1) ;
      }
      if ( AV129Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV129Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV131Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV130Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int44[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int44[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int44[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int44[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int44[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int44[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV137Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV136Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int44[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV137Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int44[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV139Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV138Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int44[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV139Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int44[67] = (byte)(1) ;
      }
      if ( ! (0==AV140Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int44[68] = (byte)(1) ;
      }
      if ( ! (0==AV141Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int44[69] = (byte)(1) ;
      }
      if ( ! (0==AV142Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int44[70] = (byte)(1) ;
      }
      if ( ! (0==AV143Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int44[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV145Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV144Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int44[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV145Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int44[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV147Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV146Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int44[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV147Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int44[75] = (byte)(1) ;
      }
      if ( AV148Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV148Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
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
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object45[0] = scmdbuf ;
      GXv_Object45[1] = GXv_int44 ;
      return GXv_Object45 ;
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
                  return conditional_H00262(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , ((Boolean) dynConstraints[77]).booleanValue() );
            case 1 :
                  return conditional_H00263(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , ((Boolean) dynConstraints[77]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00262", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00263", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[114]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[115]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[119]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[120]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[121], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[122], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[130], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[131], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[133]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[134]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[135]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[136]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[145], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[148]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[149]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[150]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[152], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[153], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[154], 1000);
               }
               if ( ((Number) parms[76]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[155]).intValue());
               }
               if ( ((Number) parms[77]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[156]).intValue());
               }
               if ( ((Number) parms[78]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[157]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
      }
   }

}

