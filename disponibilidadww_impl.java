package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidadww_impl extends GXDataArea
{
   public disponibilidadww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidadww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadww_impl.class ));
   }

   public disponibilidadww_impl( int remoteHandle ,
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
            AV27TFDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "TFDisponibilidadId"))) ;
            AV28TFDisponibilidadId_To = (int)(GXutil.lval( httpContext.GetPar( "TFDisponibilidadId_To"))) ;
            AV29TFEventId = httpContext.GetPar( "TFEventId") ;
            AV30TFEventId_Sel = httpContext.GetPar( "TFEventId_Sel") ;
            AV31TFDisponibilidadDescription = httpContext.GetPar( "TFDisponibilidadDescription") ;
            AV32TFDisponibilidadDescription_Sel = httpContext.GetPar( "TFDisponibilidadDescription_Sel") ;
            AV33TFProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "TFProfesionalId"))) ;
            AV34TFProfesionalId_To = (int)(GXutil.lval( httpContext.GetPar( "TFProfesionalId_To"))) ;
            AV35TFProfesionalApellidoPaterno = httpContext.GetPar( "TFProfesionalApellidoPaterno") ;
            AV36TFProfesionalApellidoPaterno_Sel = httpContext.GetPar( "TFProfesionalApellidoPaterno_Sel") ;
            AV37TFProfesionalApellidoMaterno = httpContext.GetPar( "TFProfesionalApellidoMaterno") ;
            AV38TFProfesionalApellidoMaterno_Sel = httpContext.GetPar( "TFProfesionalApellidoMaterno_Sel") ;
            AV39TFProfesionalNombres = httpContext.GetPar( "TFProfesionalNombres") ;
            AV40TFProfesionalNombres_Sel = httpContext.GetPar( "TFProfesionalNombres_Sel") ;
            AV41TFProfesionalNombreCompleto = httpContext.GetPar( "TFProfesionalNombreCompleto") ;
            AV42TFProfesionalNombreCompleto_Sel = httpContext.GetPar( "TFProfesionalNombreCompleto_Sel") ;
            AV43TFProfesionalCOP = httpContext.GetPar( "TFProfesionalCOP") ;
            AV44TFProfesionalCOP_Sel = httpContext.GetPar( "TFProfesionalCOP_Sel") ;
            AV45TFDisponibilidadFecha = localUtil.parseDateParm( httpContext.GetPar( "TFDisponibilidadFecha")) ;
            AV46TFDisponibilidadFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFDisponibilidadFecha_To")) ;
            AV49TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraInicio"))) ;
            AV50TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraInicio_To"))) ;
            AV53TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraFin"))) ;
            AV54TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraFin_To"))) ;
            AV57TFEspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "TFEspecialidadId"))) ;
            AV58TFEspecialidadId_To = (short)(GXutil.lval( httpContext.GetPar( "TFEspecialidadId_To"))) ;
            AV59TFEspecialidadCodigo = httpContext.GetPar( "TFEspecialidadCodigo") ;
            AV60TFEspecialidadCodigo_Sel = httpContext.GetPar( "TFEspecialidadCodigo_Sel") ;
            AV61TFEspecialidadNombre = httpContext.GetPar( "TFEspecialidadNombre") ;
            AV62TFEspecialidadNombre_Sel = httpContext.GetPar( "TFEspecialidadNombre_Sel") ;
            AV71TFDisponibilidadUser = (int)(GXutil.lval( httpContext.GetPar( "TFDisponibilidadUser"))) ;
            AV72TFDisponibilidadUser_To = (int)(GXutil.lval( httpContext.GetPar( "TFDisponibilidadUser_To"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV74TFDisponibilidadEstado_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV76TFDisponibilidadEstadoCita_Sels);
            AV77TFDCitaId = (int)(GXutil.lval( httpContext.GetPar( "TFDCitaId"))) ;
            AV78TFDCitaId_To = (int)(GXutil.lval( httpContext.GetPar( "TFDCitaId_To"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV89TFDisponibilidadTipoCita_Sels);
            AV135Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV84IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV86IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV91IsAuthorized_EspecialidadNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_EspecialidadNombre")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFDisponibilidadId, AV28TFDisponibilidadId_To, AV29TFEventId, AV30TFEventId_Sel, AV31TFDisponibilidadDescription, AV32TFDisponibilidadDescription_Sel, AV33TFProfesionalId, AV34TFProfesionalId_To, AV35TFProfesionalApellidoPaterno, AV36TFProfesionalApellidoPaterno_Sel, AV37TFProfesionalApellidoMaterno, AV38TFProfesionalApellidoMaterno_Sel, AV39TFProfesionalNombres, AV40TFProfesionalNombres_Sel, AV41TFProfesionalNombreCompleto, AV42TFProfesionalNombreCompleto_Sel, AV43TFProfesionalCOP, AV44TFProfesionalCOP_Sel, AV45TFDisponibilidadFecha, AV46TFDisponibilidadFecha_To, AV49TFDisponibilidadHoraInicio, AV50TFDisponibilidadHoraInicio_To, AV53TFDisponibilidadHoraFin, AV54TFDisponibilidadHoraFin_To, AV57TFEspecialidadId, AV58TFEspecialidadId_To, AV59TFEspecialidadCodigo, AV60TFEspecialidadCodigo_Sel, AV61TFEspecialidadNombre, AV62TFEspecialidadNombre_Sel, AV71TFDisponibilidadUser, AV72TFDisponibilidadUser_To, AV74TFDisponibilidadEstado_Sels, AV76TFDisponibilidadEstadoCita_Sels, AV77TFDCitaId, AV78TFDCitaId_To, AV89TFDisponibilidadTipoCita_Sels, AV135Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV91IsAuthorized_EspecialidadNombre) ;
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
      pa1S2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1S2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.disponibilidadww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV135Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_ESPECIALIDADNOMBRE", getSecureSignedToken( "", AV91IsAuthorized_EspecialidadNombre));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV81GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV82GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV79DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV79DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADFECHAAUXDATETO", localUtil.dtoc( AV48DDO_DisponibilidadFechaAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAINICIOAUXDATETO", localUtil.dtoc( AV52DDO_DisponibilidadHoraInicioAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAFINAUXDATETO", localUtil.dtoc( AV56DDO_DisponibilidadHoraFinAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV27TFDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFDisponibilidadId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFEVENTID", GXutil.rtrim( AV29TFEventId));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFEVENTID_SEL", GXutil.rtrim( AV30TFEventId_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADDESCRIPTION", AV31TFDisponibilidadDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADDESCRIPTION_SEL", AV32TFDisponibilidadDescription_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV33TFProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALID_TO", GXutil.ltrim( localUtil.ntoc( AV34TFProfesionalId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOPATERNO", AV35TFProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOPATERNO_SEL", AV36TFProfesionalApellidoPaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOMATERNO", AV37TFProfesionalApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOMATERNO_SEL", AV38TFProfesionalApellidoMaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRES", AV39TFProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRES_SEL", AV40TFProfesionalNombres_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRECOMPLETO", AV41TFProfesionalNombreCompleto);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRECOMPLETO_SEL", AV42TFProfesionalNombreCompleto_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOP", AV43TFProfesionalCOP);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOP_SEL", AV44TFProfesionalCOP_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADFECHA", localUtil.dtoc( AV45TFDisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADFECHA_TO", localUtil.dtoc( AV46TFDisponibilidadFecha_To, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAINICIO", localUtil.ttoc( AV49TFDisponibilidadHoraInicio, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAINICIO_TO", localUtil.ttoc( AV50TFDisponibilidadHoraInicio_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAFIN", localUtil.ttoc( AV53TFDisponibilidadHoraFin, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAFIN_TO", localUtil.ttoc( AV54TFDisponibilidadHoraFin_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV57TFEspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFESPECIALIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV58TFEspecialidadId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFESPECIALIDADCODIGO", AV59TFEspecialidadCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFESPECIALIDADCODIGO_SEL", AV60TFEspecialidadCodigo_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFESPECIALIDADNOMBRE", AV61TFEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFESPECIALIDADNOMBRE_SEL", AV62TFEspecialidadNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADUSER", GXutil.ltrim( localUtil.ntoc( AV71TFDisponibilidadUser, (byte)(6), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADUSER_TO", GXutil.ltrim( localUtil.ntoc( AV72TFDisponibilidadUser_To, (byte)(6), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDISPONIBILIDADESTADO_SELS", AV74TFDisponibilidadEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDISPONIBILIDADESTADO_SELS", AV74TFDisponibilidadEstado_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDISPONIBILIDADESTADOCITA_SELS", AV76TFDisponibilidadEstadoCita_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDISPONIBILIDADESTADOCITA_SELS", AV76TFDisponibilidadEstadoCita_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDCITAID", GXutil.ltrim( localUtil.ntoc( AV77TFDCitaId, (byte)(6), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDCITAID_TO", GXutil.ltrim( localUtil.ntoc( AV78TFDCitaId_To, (byte)(6), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDISPONIBILIDADTIPOCITA_SELS", AV89TFDisponibilidadTipoCita_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDISPONIBILIDADTIPOCITA_SELS", AV89TFDisponibilidadTipoCita_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV135Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV135Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV84IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV86IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_ESPECIALIDADNOMBRE", AV91IsAuthorized_EspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_ESPECIALIDADNOMBRE", getSecureSignedToken( "", AV91IsAuthorized_EspecialidadNombre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADESTADO_SELSJSON", AV73TFDisponibilidadEstado_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADESTADOCITA_SELSJSON", AV75TFDisponibilidadEstadoCita_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADTIPOCITA_SELSJSON", AV88TFDisponibilidadTipoCita_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADFECHAAUXDATE", localUtil.dtoc( AV47DDO_DisponibilidadFechaAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAINICIOAUXDATE", localUtil.dtoc( AV51DDO_DisponibilidadHoraInicioAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAFINAUXDATE", localUtil.dtoc( AV55DDO_DisponibilidadHoraFinAuxDate, 0, "/"));
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
         we1S2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1S2( ) ;
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
      return formatLink("com.projectthani.disponibilidadww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "DisponibilidadWW" ;
   }

   public String getPgmdesc( )
   {
      return " Disponibilidad" ;
   }

   public void wb1S0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DisponibilidadWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DisponibilidadWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DisponibilidadWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DisponibilidadWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_1S2( true) ;
      }
      else
      {
         wb_table1_25_1S2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_1S2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEventId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadDescription_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Description") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalApellidoPaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalApellidoMaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalNombres_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalNombreCompleto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Completo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalCOP_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "CMP") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadHoraInicio_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Hora Inicio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadHoraFin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Hora Fin") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEspecialidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEspecialidadCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Codigo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEspecialidadNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadUser_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "User") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbDisponibilidadEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbDisponibilidadEstadoCita.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDCitaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbDisponibilidadTipoCita.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV83Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV85Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A133EventId));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEventId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A134DisponibilidadDescription);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadDescription_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A85ProfesionalApellidoPaterno);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalApellidoPaterno_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A86ProfesionalApellidoMaterno);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalApellidoMaterno_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A84ProfesionalNombres);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalNombres_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A83ProfesionalNombreCompleto);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalNombreCompleto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A88ProfesionalCOP);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalCOP_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadFecha_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadHoraInicio_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadHoraFin_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEspecialidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A140EspecialidadCodigo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEspecialidadCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A71EspecialidadNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtEspecialidadNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEspecialidadNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A137DisponibilidadUser, (byte)(6), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadUser_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A136DisponibilidadEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbDisponibilidadEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A139DisponibilidadEstadoCita);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbDisponibilidadEstadoCita.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDCitaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A298DisponibilidadTipoCita));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbDisponibilidadTipoCita.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV81GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV82GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV79DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV79DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_disponibilidadfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_disponibilidadfechaauxdatetext_Internalname, AV92DDO_DisponibilidadFechaAuxDateText, GXutil.rtrim( localUtil.format( AV92DDO_DisponibilidadFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_disponibilidadfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadWW.htm");
         /* User Defined Control */
         ucTfdisponibilidadfecha_rangepicker.setProperty("Start Date", AV47DDO_DisponibilidadFechaAuxDate);
         ucTfdisponibilidadfecha_rangepicker.setProperty("End Date", AV48DDO_DisponibilidadFechaAuxDateTo);
         ucTfdisponibilidadfecha_rangepicker.render(context, "wwp.daterangepicker", Tfdisponibilidadfecha_rangepicker_Internalname, "TFDISPONIBILIDADFECHA_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_disponibilidadhorainicioauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_disponibilidadhorainicioauxdatetext_Internalname, AV93DDO_DisponibilidadHoraInicioAuxDateText, GXutil.rtrim( localUtil.format( AV93DDO_DisponibilidadHoraInicioAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,80);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_disponibilidadhorainicioauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadWW.htm");
         /* User Defined Control */
         ucTfdisponibilidadhorainicio_rangepicker.setProperty("Start Date", AV51DDO_DisponibilidadHoraInicioAuxDate);
         ucTfdisponibilidadhorainicio_rangepicker.setProperty("End Date", AV52DDO_DisponibilidadHoraInicioAuxDateTo);
         ucTfdisponibilidadhorainicio_rangepicker.render(context, "wwp.daterangepicker", Tfdisponibilidadhorainicio_rangepicker_Internalname, "TFDISPONIBILIDADHORAINICIO_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_disponibilidadhorafinauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_disponibilidadhorafinauxdatetext_Internalname, AV94DDO_DisponibilidadHoraFinAuxDateText, GXutil.rtrim( localUtil.format( AV94DDO_DisponibilidadHoraFinAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_disponibilidadhorafinauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadWW.htm");
         /* User Defined Control */
         ucTfdisponibilidadhorafin_rangepicker.setProperty("Start Date", AV55DDO_DisponibilidadHoraFinAuxDate);
         ucTfdisponibilidadhorafin_rangepicker.setProperty("End Date", AV56DDO_DisponibilidadHoraFinAuxDateTo);
         ucTfdisponibilidadhorafin_rangepicker.render(context, "wwp.daterangepicker", Tfdisponibilidadhorafin_rangepicker_Internalname, "TFDISPONIBILIDADHORAFIN_RANGEPICKERContainer");
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

   public void start1S2( )
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
         Form.getMeta().addItem("description", " Disponibilidad", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1S0( ) ;
   }

   public void ws1S2( )
   {
      start1S2( ) ;
      evt1S2( ) ;
   }

   public void evt1S2( )
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
                           e111S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e161S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e171S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e181S2 ();
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
                           AV83Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV83Update);
                           AV85Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV85Delete);
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
                                 e191S2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e201S2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e211S2 ();
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

   public void we1S2( )
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

   public void pa1S2( )
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
                                 int AV27TFDisponibilidadId ,
                                 int AV28TFDisponibilidadId_To ,
                                 String AV29TFEventId ,
                                 String AV30TFEventId_Sel ,
                                 String AV31TFDisponibilidadDescription ,
                                 String AV32TFDisponibilidadDescription_Sel ,
                                 int AV33TFProfesionalId ,
                                 int AV34TFProfesionalId_To ,
                                 String AV35TFProfesionalApellidoPaterno ,
                                 String AV36TFProfesionalApellidoPaterno_Sel ,
                                 String AV37TFProfesionalApellidoMaterno ,
                                 String AV38TFProfesionalApellidoMaterno_Sel ,
                                 String AV39TFProfesionalNombres ,
                                 String AV40TFProfesionalNombres_Sel ,
                                 String AV41TFProfesionalNombreCompleto ,
                                 String AV42TFProfesionalNombreCompleto_Sel ,
                                 String AV43TFProfesionalCOP ,
                                 String AV44TFProfesionalCOP_Sel ,
                                 java.util.Date AV45TFDisponibilidadFecha ,
                                 java.util.Date AV46TFDisponibilidadFecha_To ,
                                 java.util.Date AV49TFDisponibilidadHoraInicio ,
                                 java.util.Date AV50TFDisponibilidadHoraInicio_To ,
                                 java.util.Date AV53TFDisponibilidadHoraFin ,
                                 java.util.Date AV54TFDisponibilidadHoraFin_To ,
                                 short AV57TFEspecialidadId ,
                                 short AV58TFEspecialidadId_To ,
                                 String AV59TFEspecialidadCodigo ,
                                 String AV60TFEspecialidadCodigo_Sel ,
                                 String AV61TFEspecialidadNombre ,
                                 String AV62TFEspecialidadNombre_Sel ,
                                 int AV71TFDisponibilidadUser ,
                                 int AV72TFDisponibilidadUser_To ,
                                 GXSimpleCollection<String> AV74TFDisponibilidadEstado_Sels ,
                                 GXSimpleCollection<String> AV76TFDisponibilidadEstadoCita_Sels ,
                                 int AV77TFDCitaId ,
                                 int AV78TFDCitaId_To ,
                                 GXSimpleCollection<String> AV89TFDisponibilidadTipoCita_Sels ,
                                 String AV135Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV84IsAuthorized_Update ,
                                 boolean AV86IsAuthorized_Delete ,
                                 boolean AV91IsAuthorized_EspecialidadNombre )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e201S2 ();
      GRID_nCurrentRecord = 0 ;
      rf1S2( ) ;
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
      rf1S2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV135Pgmname = "DisponibilidadWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf1S2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e201S2 ();
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
                                              A136DisponibilidadEstado ,
                                              AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                              A139DisponibilidadEstadoCita ,
                                              AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                              A298DisponibilidadTipoCita ,
                                              AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                              Integer.valueOf(AV98Disponibilidadwwds_2_tfdisponibilidadid) ,
                                              Integer.valueOf(AV99Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                              AV101Disponibilidadwwds_5_tfeventid_sel ,
                                              AV100Disponibilidadwwds_4_tfeventid ,
                                              AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                              AV102Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                              Integer.valueOf(AV104Disponibilidadwwds_8_tfprofesionalid) ,
                                              Integer.valueOf(AV105Disponibilidadwwds_9_tfprofesionalid_to) ,
                                              AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                              AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                              AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                              AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                              AV111Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                              AV110Disponibilidadwwds_14_tfprofesionalnombres ,
                                              AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                              AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                              AV115Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                              AV114Disponibilidadwwds_18_tfprofesionalcop ,
                                              AV116Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                              AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                              AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                              AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                              AV120Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                              AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                              Short.valueOf(AV122Disponibilidadwwds_26_tfespecialidadid) ,
                                              Short.valueOf(AV123Disponibilidadwwds_27_tfespecialidadid_to) ,
                                              AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                              AV124Disponibilidadwwds_28_tfespecialidadcodigo ,
                                              AV127Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                              AV126Disponibilidadwwds_30_tfespecialidadnombre ,
                                              Integer.valueOf(AV128Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                              Integer.valueOf(AV129Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                              Integer.valueOf(AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                              Integer.valueOf(AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                              Integer.valueOf(AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                              Integer.valueOf(A34DisponibilidadId) ,
                                              A133EventId ,
                                              A134DisponibilidadDescription ,
                                              Integer.valueOf(A31ProfesionalId) ,
                                              A85ProfesionalApellidoPaterno ,
                                              A86ProfesionalApellidoMaterno ,
                                              A84ProfesionalNombres ,
                                              A88ProfesionalCOP ,
                                              A67DisponibilidadFecha ,
                                              A69DisponibilidadHoraInicio ,
                                              A135DisponibilidadHoraFin ,
                                              Short.valueOf(A32EspecialidadId) ,
                                              A140EspecialidadCodigo ,
                                              A71EspecialidadNombre ,
                                              Integer.valueOf(A137DisponibilidadUser) ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              AV97Disponibilidadwwds_1_filterfulltext ,
                                              A83ProfesionalNombreCompleto ,
                                              Integer.valueOf(A138DCitaId) ,
                                              Integer.valueOf(AV132Disponibilidadwwds_36_tfdcitaid) ,
                                              Integer.valueOf(AV133Disponibilidadwwds_37_tfdcitaid_to) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                              TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
         lV100Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV100Disponibilidadwwds_4_tfeventid), 20, "%") ;
         lV102Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV102Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
         lV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
         lV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
         lV110Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV110Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
         lV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
         lV114Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV114Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
         lV124Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV124Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
         lV126Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV126Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
         /* Using cursor H001S3 */
         pr_default.execute(0, new Object[] {AV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV132Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV132Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV133Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV133Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV98Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV99Disponibilidadwwds_3_tfdisponibilidadid_to), lV100Disponibilidadwwds_4_tfeventid, AV101Disponibilidadwwds_5_tfeventid_sel, lV102Disponibilidadwwds_6_tfdisponibilidaddescription, AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV104Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV105Disponibilidadwwds_9_tfprofesionalid_to), lV106Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV108Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV110Disponibilidadwwds_14_tfprofesionalnombres, AV111Disponibilidadwwds_15_tfprofesionalnombres_sel, lV112Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV114Disponibilidadwwds_18_tfprofesionalcop, AV115Disponibilidadwwds_19_tfprofesionalcop_sel, AV116Disponibilidadwwds_20_tfdisponibilidadfecha, AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV120Disponibilidadwwds_24_tfdisponibilidadhorafin, AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV122Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV123Disponibilidadwwds_27_tfespecialidadid_to), lV124Disponibilidadwwds_28_tfespecialidadcodigo, AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV126Disponibilidadwwds_30_tfespecialidadnombre, AV127Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV128Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV129Disponibilidadwwds_33_tfdisponibilidaduser_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A298DisponibilidadTipoCita = H001S3_A298DisponibilidadTipoCita[0] ;
            A139DisponibilidadEstadoCita = H001S3_A139DisponibilidadEstadoCita[0] ;
            A136DisponibilidadEstado = H001S3_A136DisponibilidadEstado[0] ;
            A137DisponibilidadUser = H001S3_A137DisponibilidadUser[0] ;
            A71EspecialidadNombre = H001S3_A71EspecialidadNombre[0] ;
            A140EspecialidadCodigo = H001S3_A140EspecialidadCodigo[0] ;
            A32EspecialidadId = H001S3_A32EspecialidadId[0] ;
            A135DisponibilidadHoraFin = H001S3_A135DisponibilidadHoraFin[0] ;
            n135DisponibilidadHoraFin = H001S3_n135DisponibilidadHoraFin[0] ;
            A69DisponibilidadHoraInicio = H001S3_A69DisponibilidadHoraInicio[0] ;
            n69DisponibilidadHoraInicio = H001S3_n69DisponibilidadHoraInicio[0] ;
            A67DisponibilidadFecha = H001S3_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = H001S3_n67DisponibilidadFecha[0] ;
            A88ProfesionalCOP = H001S3_A88ProfesionalCOP[0] ;
            A83ProfesionalNombreCompleto = H001S3_A83ProfesionalNombreCompleto[0] ;
            A31ProfesionalId = H001S3_A31ProfesionalId[0] ;
            A134DisponibilidadDescription = H001S3_A134DisponibilidadDescription[0] ;
            A133EventId = H001S3_A133EventId[0] ;
            A34DisponibilidadId = H001S3_A34DisponibilidadId[0] ;
            A138DCitaId = H001S3_A138DCitaId[0] ;
            n138DCitaId = H001S3_n138DCitaId[0] ;
            A84ProfesionalNombres = H001S3_A84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H001S3_A85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H001S3_A86ProfesionalApellidoMaterno[0] ;
            A71EspecialidadNombre = H001S3_A71EspecialidadNombre[0] ;
            A140EspecialidadCodigo = H001S3_A140EspecialidadCodigo[0] ;
            A88ProfesionalCOP = H001S3_A88ProfesionalCOP[0] ;
            A84ProfesionalNombres = H001S3_A84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H001S3_A85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H001S3_A86ProfesionalApellidoMaterno[0] ;
            A138DCitaId = H001S3_A138DCitaId[0] ;
            n138DCitaId = H001S3_n138DCitaId[0] ;
            e211S2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb1S0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1S2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV135Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV135Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV84IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV86IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_ESPECIALIDADNOMBRE", AV91IsAuthorized_EspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_ESPECIALIDADNOMBRE", getSecureSignedToken( "", AV91IsAuthorized_EspecialidadNombre));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_DISPONIBILIDADID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")));
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
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV98Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV99Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV101Disponibilidadwwds_5_tfeventid_sel ,
                                           AV100Disponibilidadwwds_4_tfeventid ,
                                           AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV102Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV104Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV105Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV111Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV110Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV115Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV114Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV116Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV120Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV122Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV123Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV124Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV127Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV126Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV128Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV129Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           AV97Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV132Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV133Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV97Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV100Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV100Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV102Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV102Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV110Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV110Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV114Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV114Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV124Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV124Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV126Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV126Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor H001S5 */
      pr_default.execute(1, new Object[] {AV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, lV97Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV132Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV132Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV133Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV133Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV98Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV99Disponibilidadwwds_3_tfdisponibilidadid_to), lV100Disponibilidadwwds_4_tfeventid, AV101Disponibilidadwwds_5_tfeventid_sel, lV102Disponibilidadwwds_6_tfdisponibilidaddescription, AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV104Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV105Disponibilidadwwds_9_tfprofesionalid_to), lV106Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV108Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV110Disponibilidadwwds_14_tfprofesionalnombres, AV111Disponibilidadwwds_15_tfprofesionalnombres_sel, lV112Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV114Disponibilidadwwds_18_tfprofesionalcop, AV115Disponibilidadwwds_19_tfprofesionalcop_sel, AV116Disponibilidadwwds_20_tfdisponibilidadfecha, AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV120Disponibilidadwwds_24_tfdisponibilidadhorafin, AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV122Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV123Disponibilidadwwds_27_tfespecialidadid_to), lV124Disponibilidadwwds_28_tfespecialidadcodigo, AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV126Disponibilidadwwds_30_tfespecialidadnombre, AV127Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV128Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV129Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      GRID_nRecordCount = H001S5_AGRID_nRecordCount[0] ;
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
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFDisponibilidadId, AV28TFDisponibilidadId_To, AV29TFEventId, AV30TFEventId_Sel, AV31TFDisponibilidadDescription, AV32TFDisponibilidadDescription_Sel, AV33TFProfesionalId, AV34TFProfesionalId_To, AV35TFProfesionalApellidoPaterno, AV36TFProfesionalApellidoPaterno_Sel, AV37TFProfesionalApellidoMaterno, AV38TFProfesionalApellidoMaterno_Sel, AV39TFProfesionalNombres, AV40TFProfesionalNombres_Sel, AV41TFProfesionalNombreCompleto, AV42TFProfesionalNombreCompleto_Sel, AV43TFProfesionalCOP, AV44TFProfesionalCOP_Sel, AV45TFDisponibilidadFecha, AV46TFDisponibilidadFecha_To, AV49TFDisponibilidadHoraInicio, AV50TFDisponibilidadHoraInicio_To, AV53TFDisponibilidadHoraFin, AV54TFDisponibilidadHoraFin_To, AV57TFEspecialidadId, AV58TFEspecialidadId_To, AV59TFEspecialidadCodigo, AV60TFEspecialidadCodigo_Sel, AV61TFEspecialidadNombre, AV62TFEspecialidadNombre_Sel, AV71TFDisponibilidadUser, AV72TFDisponibilidadUser_To, AV74TFDisponibilidadEstado_Sels, AV76TFDisponibilidadEstadoCita_Sels, AV77TFDCitaId, AV78TFDCitaId_To, AV89TFDisponibilidadTipoCita_Sels, AV135Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV91IsAuthorized_EspecialidadNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFDisponibilidadId, AV28TFDisponibilidadId_To, AV29TFEventId, AV30TFEventId_Sel, AV31TFDisponibilidadDescription, AV32TFDisponibilidadDescription_Sel, AV33TFProfesionalId, AV34TFProfesionalId_To, AV35TFProfesionalApellidoPaterno, AV36TFProfesionalApellidoPaterno_Sel, AV37TFProfesionalApellidoMaterno, AV38TFProfesionalApellidoMaterno_Sel, AV39TFProfesionalNombres, AV40TFProfesionalNombres_Sel, AV41TFProfesionalNombreCompleto, AV42TFProfesionalNombreCompleto_Sel, AV43TFProfesionalCOP, AV44TFProfesionalCOP_Sel, AV45TFDisponibilidadFecha, AV46TFDisponibilidadFecha_To, AV49TFDisponibilidadHoraInicio, AV50TFDisponibilidadHoraInicio_To, AV53TFDisponibilidadHoraFin, AV54TFDisponibilidadHoraFin_To, AV57TFEspecialidadId, AV58TFEspecialidadId_To, AV59TFEspecialidadCodigo, AV60TFEspecialidadCodigo_Sel, AV61TFEspecialidadNombre, AV62TFEspecialidadNombre_Sel, AV71TFDisponibilidadUser, AV72TFDisponibilidadUser_To, AV74TFDisponibilidadEstado_Sels, AV76TFDisponibilidadEstadoCita_Sels, AV77TFDCitaId, AV78TFDCitaId_To, AV89TFDisponibilidadTipoCita_Sels, AV135Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV91IsAuthorized_EspecialidadNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFDisponibilidadId, AV28TFDisponibilidadId_To, AV29TFEventId, AV30TFEventId_Sel, AV31TFDisponibilidadDescription, AV32TFDisponibilidadDescription_Sel, AV33TFProfesionalId, AV34TFProfesionalId_To, AV35TFProfesionalApellidoPaterno, AV36TFProfesionalApellidoPaterno_Sel, AV37TFProfesionalApellidoMaterno, AV38TFProfesionalApellidoMaterno_Sel, AV39TFProfesionalNombres, AV40TFProfesionalNombres_Sel, AV41TFProfesionalNombreCompleto, AV42TFProfesionalNombreCompleto_Sel, AV43TFProfesionalCOP, AV44TFProfesionalCOP_Sel, AV45TFDisponibilidadFecha, AV46TFDisponibilidadFecha_To, AV49TFDisponibilidadHoraInicio, AV50TFDisponibilidadHoraInicio_To, AV53TFDisponibilidadHoraFin, AV54TFDisponibilidadHoraFin_To, AV57TFEspecialidadId, AV58TFEspecialidadId_To, AV59TFEspecialidadCodigo, AV60TFEspecialidadCodigo_Sel, AV61TFEspecialidadNombre, AV62TFEspecialidadNombre_Sel, AV71TFDisponibilidadUser, AV72TFDisponibilidadUser_To, AV74TFDisponibilidadEstado_Sels, AV76TFDisponibilidadEstadoCita_Sels, AV77TFDCitaId, AV78TFDCitaId_To, AV89TFDisponibilidadTipoCita_Sels, AV135Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV91IsAuthorized_EspecialidadNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFDisponibilidadId, AV28TFDisponibilidadId_To, AV29TFEventId, AV30TFEventId_Sel, AV31TFDisponibilidadDescription, AV32TFDisponibilidadDescription_Sel, AV33TFProfesionalId, AV34TFProfesionalId_To, AV35TFProfesionalApellidoPaterno, AV36TFProfesionalApellidoPaterno_Sel, AV37TFProfesionalApellidoMaterno, AV38TFProfesionalApellidoMaterno_Sel, AV39TFProfesionalNombres, AV40TFProfesionalNombres_Sel, AV41TFProfesionalNombreCompleto, AV42TFProfesionalNombreCompleto_Sel, AV43TFProfesionalCOP, AV44TFProfesionalCOP_Sel, AV45TFDisponibilidadFecha, AV46TFDisponibilidadFecha_To, AV49TFDisponibilidadHoraInicio, AV50TFDisponibilidadHoraInicio_To, AV53TFDisponibilidadHoraFin, AV54TFDisponibilidadHoraFin_To, AV57TFEspecialidadId, AV58TFEspecialidadId_To, AV59TFEspecialidadCodigo, AV60TFEspecialidadCodigo_Sel, AV61TFEspecialidadNombre, AV62TFEspecialidadNombre_Sel, AV71TFDisponibilidadUser, AV72TFDisponibilidadUser_To, AV74TFDisponibilidadEstado_Sels, AV76TFDisponibilidadEstadoCita_Sels, AV77TFDCitaId, AV78TFDCitaId_To, AV89TFDisponibilidadTipoCita_Sels, AV135Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV91IsAuthorized_EspecialidadNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFDisponibilidadId, AV28TFDisponibilidadId_To, AV29TFEventId, AV30TFEventId_Sel, AV31TFDisponibilidadDescription, AV32TFDisponibilidadDescription_Sel, AV33TFProfesionalId, AV34TFProfesionalId_To, AV35TFProfesionalApellidoPaterno, AV36TFProfesionalApellidoPaterno_Sel, AV37TFProfesionalApellidoMaterno, AV38TFProfesionalApellidoMaterno_Sel, AV39TFProfesionalNombres, AV40TFProfesionalNombres_Sel, AV41TFProfesionalNombreCompleto, AV42TFProfesionalNombreCompleto_Sel, AV43TFProfesionalCOP, AV44TFProfesionalCOP_Sel, AV45TFDisponibilidadFecha, AV46TFDisponibilidadFecha_To, AV49TFDisponibilidadHoraInicio, AV50TFDisponibilidadHoraInicio_To, AV53TFDisponibilidadHoraFin, AV54TFDisponibilidadHoraFin_To, AV57TFEspecialidadId, AV58TFEspecialidadId_To, AV59TFEspecialidadCodigo, AV60TFEspecialidadCodigo_Sel, AV61TFEspecialidadNombre, AV62TFEspecialidadNombre_Sel, AV71TFDisponibilidadUser, AV72TFDisponibilidadUser_To, AV74TFDisponibilidadEstado_Sels, AV76TFDisponibilidadEstadoCita_Sels, AV77TFDCitaId, AV78TFDCitaId_To, AV89TFDisponibilidadTipoCita_Sels, AV135Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV91IsAuthorized_EspecialidadNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV135Pgmname = "DisponibilidadWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1S0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e191S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV79DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV81GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV82GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV47DDO_DisponibilidadFechaAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADFECHAAUXDATE"), 0) ;
         AV48DDO_DisponibilidadFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADFECHAAUXDATETO"), 0) ;
         AV51DDO_DisponibilidadHoraInicioAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAINICIOAUXDATE"), 0) ;
         AV52DDO_DisponibilidadHoraInicioAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAINICIOAUXDATETO"), 0) ;
         AV55DDO_DisponibilidadHoraFinAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAFINAUXDATE"), 0) ;
         AV56DDO_DisponibilidadHoraFinAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAFINAUXDATETO"), 0) ;
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
         AV92DDO_DisponibilidadFechaAuxDateText = httpContext.cgiGet( edtavDdo_disponibilidadfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92DDO_DisponibilidadFechaAuxDateText", AV92DDO_DisponibilidadFechaAuxDateText);
         AV93DDO_DisponibilidadHoraInicioAuxDateText = httpContext.cgiGet( edtavDdo_disponibilidadhorainicioauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV93DDO_DisponibilidadHoraInicioAuxDateText", AV93DDO_DisponibilidadHoraInicioAuxDateText);
         AV94DDO_DisponibilidadHoraFinAuxDateText = httpContext.cgiGet( edtavDdo_disponibilidadhorafinauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV94DDO_DisponibilidadHoraFinAuxDateText", AV94DDO_DisponibilidadHoraFinAuxDateText);
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
      e191S2 ();
      if (returnInSub) return;
   }

   public void e191S2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFDISPONIBILIDADHORAFIN_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_disponibilidadhorafinauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFDISPONIBILIDADHORAINICIO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_disponibilidadhorainicioauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFDISPONIBILIDADFECHA_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_disponibilidadfechaauxdatetext_Internalname});
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
      GXt_boolean1 = AV91IsAuthorized_EspecialidadNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean2) ;
      disponibilidadww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV91IsAuthorized_EspecialidadNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV91IsAuthorized_EspecialidadNombre", AV91IsAuthorized_EspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_ESPECIALIDADNOMBRE", getSecureSignedToken( "", AV91IsAuthorized_EspecialidadNombre));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Disponibilidad" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV79DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV79DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e201S2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("DisponibilidadWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("DisponibilidadWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtDisponibilidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtEventId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEventId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEventId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDisponibilidadDescription_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadDescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadDescription_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalApellidoPaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoPaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoPaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalApellidoMaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoMaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoMaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalNombres_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombres_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalNombreCompleto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombreCompleto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombreCompleto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalCOP_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalCOP_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalCOP_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDisponibilidadFecha_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadFecha_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDisponibilidadHoraInicio_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadHoraInicio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadHoraInicio_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDisponibilidadHoraFin_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadHoraFin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadHoraFin_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtEspecialidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtEspecialidadCodigo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadCodigo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtEspecialidadNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDisponibilidadUser_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadUser_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadUser_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbDisponibilidadEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbDisponibilidadEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbDisponibilidadEstadoCita.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstadoCita.getInternalname(), "Visible", GXutil.ltrimstr( cmbDisponibilidadEstadoCita.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtDCitaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDCitaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbDisponibilidadTipoCita.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadTipoCita.getInternalname(), "Visible", GXutil.ltrimstr( cmbDisponibilidadTipoCita.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV81GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81GridCurrentPage), 10, 0));
      AV82GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82GridPageCount), 10, 0));
      AV97Disponibilidadwwds_1_filterfulltext = AV16FilterFullText ;
      AV98Disponibilidadwwds_2_tfdisponibilidadid = AV27TFDisponibilidadId ;
      AV99Disponibilidadwwds_3_tfdisponibilidadid_to = AV28TFDisponibilidadId_To ;
      AV100Disponibilidadwwds_4_tfeventid = AV29TFEventId ;
      AV101Disponibilidadwwds_5_tfeventid_sel = AV30TFEventId_Sel ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = AV31TFDisponibilidadDescription ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV32TFDisponibilidadDescription_Sel ;
      AV104Disponibilidadwwds_8_tfprofesionalid = AV33TFProfesionalId ;
      AV105Disponibilidadwwds_9_tfprofesionalid_to = AV34TFProfesionalId_To ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV35TFProfesionalApellidoPaterno ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV36TFProfesionalApellidoPaterno_Sel ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV37TFProfesionalApellidoMaterno ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV38TFProfesionalApellidoMaterno_Sel ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = AV39TFProfesionalNombres ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = AV40TFProfesionalNombres_Sel ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV41TFProfesionalNombreCompleto ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV42TFProfesionalNombreCompleto_Sel ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = AV43TFProfesionalCOP ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = AV44TFProfesionalCOP_Sel ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = AV45TFDisponibilidadFecha ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV46TFDisponibilidadFecha_To ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV49TFDisponibilidadHoraInicio ;
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV50TFDisponibilidadHoraInicio_To ;
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = AV53TFDisponibilidadHoraFin ;
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV54TFDisponibilidadHoraFin_To ;
      AV122Disponibilidadwwds_26_tfespecialidadid = AV57TFEspecialidadId ;
      AV123Disponibilidadwwds_27_tfespecialidadid_to = AV58TFEspecialidadId_To ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = AV59TFEspecialidadCodigo ;
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV60TFEspecialidadCodigo_Sel ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = AV61TFEspecialidadNombre ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = AV62TFEspecialidadNombre_Sel ;
      AV128Disponibilidadwwds_32_tfdisponibilidaduser = AV71TFDisponibilidadUser ;
      AV129Disponibilidadwwds_33_tfdisponibilidaduser_to = AV72TFDisponibilidadUser_To ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV74TFDisponibilidadEstado_Sels ;
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV76TFDisponibilidadEstadoCita_Sels ;
      AV132Disponibilidadwwds_36_tfdcitaid = AV77TFDCitaId ;
      AV133Disponibilidadwwds_37_tfdcitaid_to = AV78TFDCitaId_To ;
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV89TFDisponibilidadTipoCita_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e121S2( )
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
         AV80PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV80PageToGo) ;
      }
   }

   public void e131S2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141S2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadId") == 0 )
         {
            AV27TFDisponibilidadId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFDisponibilidadId), 8, 0));
            AV28TFDisponibilidadId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EventId") == 0 )
         {
            AV29TFEventId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFEventId", AV29TFEventId);
            AV30TFEventId_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFEventId_Sel", AV30TFEventId_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadDescription") == 0 )
         {
            AV31TFDisponibilidadDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFDisponibilidadDescription", AV31TFDisponibilidadDescription);
            AV32TFDisponibilidadDescription_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFDisponibilidadDescription_Sel", AV32TFDisponibilidadDescription_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalId") == 0 )
         {
            AV33TFProfesionalId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFProfesionalId), 8, 0));
            AV34TFProfesionalId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalApellidoPaterno") == 0 )
         {
            AV35TFProfesionalApellidoPaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFProfesionalApellidoPaterno", AV35TFProfesionalApellidoPaterno);
            AV36TFProfesionalApellidoPaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFProfesionalApellidoPaterno_Sel", AV36TFProfesionalApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalApellidoMaterno") == 0 )
         {
            AV37TFProfesionalApellidoMaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFProfesionalApellidoMaterno", AV37TFProfesionalApellidoMaterno);
            AV38TFProfesionalApellidoMaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFProfesionalApellidoMaterno_Sel", AV38TFProfesionalApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalNombres") == 0 )
         {
            AV39TFProfesionalNombres = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFProfesionalNombres", AV39TFProfesionalNombres);
            AV40TFProfesionalNombres_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFProfesionalNombres_Sel", AV40TFProfesionalNombres_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalNombreCompleto") == 0 )
         {
            AV41TFProfesionalNombreCompleto = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFProfesionalNombreCompleto", AV41TFProfesionalNombreCompleto);
            AV42TFProfesionalNombreCompleto_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFProfesionalNombreCompleto_Sel", AV42TFProfesionalNombreCompleto_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalCOP") == 0 )
         {
            AV43TFProfesionalCOP = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFProfesionalCOP", AV43TFProfesionalCOP);
            AV44TFProfesionalCOP_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFProfesionalCOP_Sel", AV44TFProfesionalCOP_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadFecha") == 0 )
         {
            AV45TFDisponibilidadFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFDisponibilidadFecha", localUtil.format(AV45TFDisponibilidadFecha, "99/99/99"));
            AV46TFDisponibilidadFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFDisponibilidadFecha_To", localUtil.format(AV46TFDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadHoraInicio") == 0 )
         {
            AV49TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFDisponibilidadHoraInicio", localUtil.ttoc( AV49TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV50TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV50TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV50TFDisponibilidadHoraInicio_To) )
            {
               AV50TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV50TFDisponibilidadHoraInicio_To)), (byte)(GXutil.month( AV50TFDisponibilidadHoraInicio_To)), (byte)(GXutil.day( AV50TFDisponibilidadHoraInicio_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV50TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV50TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadHoraFin") == 0 )
         {
            AV53TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFDisponibilidadHoraFin", localUtil.ttoc( AV53TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV54TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFDisponibilidadHoraFin_To", localUtil.ttoc( AV54TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV54TFDisponibilidadHoraFin_To) )
            {
               AV54TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV54TFDisponibilidadHoraFin_To)), (byte)(GXutil.month( AV54TFDisponibilidadHoraFin_To)), (byte)(GXutil.day( AV54TFDisponibilidadHoraFin_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV54TFDisponibilidadHoraFin_To", localUtil.ttoc( AV54TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EspecialidadId") == 0 )
         {
            AV57TFEspecialidadId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFEspecialidadId), 4, 0));
            AV58TFEspecialidadId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFEspecialidadId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EspecialidadCodigo") == 0 )
         {
            AV59TFEspecialidadCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFEspecialidadCodigo", AV59TFEspecialidadCodigo);
            AV60TFEspecialidadCodigo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFEspecialidadCodigo_Sel", AV60TFEspecialidadCodigo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EspecialidadNombre") == 0 )
         {
            AV61TFEspecialidadNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFEspecialidadNombre", AV61TFEspecialidadNombre);
            AV62TFEspecialidadNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFEspecialidadNombre_Sel", AV62TFEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadUser") == 0 )
         {
            AV71TFDisponibilidadUser = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFDisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71TFDisponibilidadUser), 6, 0));
            AV72TFDisponibilidadUser_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFDisponibilidadUser_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72TFDisponibilidadUser_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadEstado") == 0 )
         {
            AV73TFDisponibilidadEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFDisponibilidadEstado_SelsJson", AV73TFDisponibilidadEstado_SelsJson);
            AV74TFDisponibilidadEstado_Sels.fromJSonString(AV73TFDisponibilidadEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadEstadoCita") == 0 )
         {
            AV75TFDisponibilidadEstadoCita_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFDisponibilidadEstadoCita_SelsJson", AV75TFDisponibilidadEstadoCita_SelsJson);
            AV76TFDisponibilidadEstadoCita_Sels.fromJSonString(AV75TFDisponibilidadEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DCitaId") == 0 )
         {
            AV77TFDCitaId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFDCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFDCitaId), 6, 0));
            AV78TFDCitaId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFDCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFDCitaId_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadTipoCita") == 0 )
         {
            AV88TFDisponibilidadTipoCita_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFDisponibilidadTipoCita_SelsJson", AV88TFDisponibilidadTipoCita_SelsJson);
            AV89TFDisponibilidadTipoCita_Sels.fromJSonString(AV88TFDisponibilidadTipoCita_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFDisponibilidadTipoCita_Sels", AV89TFDisponibilidadTipoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFDisponibilidadEstadoCita_Sels", AV76TFDisponibilidadEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74TFDisponibilidadEstado_Sels", AV74TFDisponibilidadEstado_Sels);
   }

   private void e211S2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV83Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV83Update);
      if ( AV84IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.disponibilidad", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A34DisponibilidadId,8,0))}, new String[] {"Mode","DisponibilidadId"})  ;
      }
      AV85Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV85Delete);
      if ( AV86IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.disponibilidad", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A34DisponibilidadId,8,0))}, new String[] {"Mode","DisponibilidadId"})  ;
      }
      if ( AV91IsAuthorized_EspecialidadNombre )
      {
         edtEspecialidadNombre_Link = formatLink("com.projectthani.especialidadview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A32EspecialidadId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"EspecialidadId","TabCode"})  ;
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

   public void e151S2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "DisponibilidadWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e111S2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("DisponibilidadWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV135Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("DisponibilidadWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "DisponibilidadWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         disponibilidadww_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV135Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74TFDisponibilidadEstado_Sels", AV74TFDisponibilidadEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFDisponibilidadEstadoCita_Sels", AV76TFDisponibilidadEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFDisponibilidadTipoCita_Sels", AV89TFDisponibilidadTipoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e161S2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.disponibilidad", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","DisponibilidadId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e171S2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.disponibilidadwwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      disponibilidadww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      disponibilidadww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFDisponibilidadTipoCita_Sels", AV89TFDisponibilidadTipoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFDisponibilidadEstadoCita_Sels", AV76TFDisponibilidadEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74TFDisponibilidadEstado_Sels", AV74TFDisponibilidadEstado_Sels);
   }

   public void e181S2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.disponibilidadwwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFDisponibilidadTipoCita_Sels", AV89TFDisponibilidadTipoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFDisponibilidadEstadoCita_Sels", AV76TFDisponibilidadEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74TFDisponibilidadEstado_Sels", AV74TFDisponibilidadEstado_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EventId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadDescription", "", "Description", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalId", "", "Profesional Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalApellidoPaterno", "", "Apellido Paterno", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalApellidoMaterno", "", "Apellido Materno", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalNombres", "", "Nombres", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalNombreCompleto", "", "Nombre Completo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalCOP", "", "CMP", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadFecha", "", "Fecha", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadHoraInicio", "", "Hora Inicio", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadHoraFin", "", "Hora Fin", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EspecialidadId", "", "Especialidad Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EspecialidadCodigo", "", "Especialidad Codigo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EspecialidadNombre", "", "Especialidad Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadUser", "", "User", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadEstadoCita", "", "Estado Cita", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DCitaId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadTipoCita", "", "Tipo Cita", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "DisponibilidadWWColumnsSelector", GXv_char8) ;
      disponibilidadww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV84IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Update", GXv_boolean2) ;
      disponibilidadww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV84IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84IsAuthorized_Update", AV84IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      if ( ! ( AV84IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV86IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Delete", GXv_boolean2) ;
      disponibilidadww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV86IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86IsAuthorized_Delete", AV86IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      if ( ! ( AV86IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV87TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Insert", GXv_boolean2) ;
      disponibilidadww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV87TempBoolean = GXt_boolean1 ;
      if ( ! ( AV87TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "DisponibilidadWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFDisponibilidadId), 8, 0));
      AV28TFDisponibilidadId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFDisponibilidadId_To), 8, 0));
      AV29TFEventId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFEventId", AV29TFEventId);
      AV30TFEventId_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFEventId_Sel", AV30TFEventId_Sel);
      AV31TFDisponibilidadDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFDisponibilidadDescription", AV31TFDisponibilidadDescription);
      AV32TFDisponibilidadDescription_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFDisponibilidadDescription_Sel", AV32TFDisponibilidadDescription_Sel);
      AV33TFProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFProfesionalId), 8, 0));
      AV34TFProfesionalId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFProfesionalId_To), 8, 0));
      AV35TFProfesionalApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFProfesionalApellidoPaterno", AV35TFProfesionalApellidoPaterno);
      AV36TFProfesionalApellidoPaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFProfesionalApellidoPaterno_Sel", AV36TFProfesionalApellidoPaterno_Sel);
      AV37TFProfesionalApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFProfesionalApellidoMaterno", AV37TFProfesionalApellidoMaterno);
      AV38TFProfesionalApellidoMaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFProfesionalApellidoMaterno_Sel", AV38TFProfesionalApellidoMaterno_Sel);
      AV39TFProfesionalNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFProfesionalNombres", AV39TFProfesionalNombres);
      AV40TFProfesionalNombres_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFProfesionalNombres_Sel", AV40TFProfesionalNombres_Sel);
      AV41TFProfesionalNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFProfesionalNombreCompleto", AV41TFProfesionalNombreCompleto);
      AV42TFProfesionalNombreCompleto_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFProfesionalNombreCompleto_Sel", AV42TFProfesionalNombreCompleto_Sel);
      AV43TFProfesionalCOP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFProfesionalCOP", AV43TFProfesionalCOP);
      AV44TFProfesionalCOP_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFProfesionalCOP_Sel", AV44TFProfesionalCOP_Sel);
      AV45TFDisponibilidadFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFDisponibilidadFecha", localUtil.format(AV45TFDisponibilidadFecha, "99/99/99"));
      AV46TFDisponibilidadFecha_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFDisponibilidadFecha_To", localUtil.format(AV46TFDisponibilidadFecha_To, "99/99/99"));
      AV49TFDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFDisponibilidadHoraInicio", localUtil.ttoc( AV49TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
      AV50TFDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV50TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
      AV53TFDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFDisponibilidadHoraFin", localUtil.ttoc( AV53TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
      AV54TFDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFDisponibilidadHoraFin_To", localUtil.ttoc( AV54TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
      AV57TFEspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFEspecialidadId), 4, 0));
      AV58TFEspecialidadId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFEspecialidadId_To), 4, 0));
      AV59TFEspecialidadCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFEspecialidadCodigo", AV59TFEspecialidadCodigo);
      AV60TFEspecialidadCodigo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFEspecialidadCodigo_Sel", AV60TFEspecialidadCodigo_Sel);
      AV61TFEspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFEspecialidadNombre", AV61TFEspecialidadNombre);
      AV62TFEspecialidadNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFEspecialidadNombre_Sel", AV62TFEspecialidadNombre_Sel);
      AV71TFDisponibilidadUser = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFDisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71TFDisponibilidadUser), 6, 0));
      AV72TFDisponibilidadUser_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72TFDisponibilidadUser_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72TFDisponibilidadUser_To), 6, 0));
      AV74TFDisponibilidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV76TFDisponibilidadEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV77TFDCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFDCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFDCitaId), 6, 0));
      AV78TFDCitaId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFDCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFDCitaId_To), 6, 0));
      AV89TFDisponibilidadTipoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV135Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV135Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV135Pgmname+"GridState"), null, null);
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
      AV136GXV1 = 1 ;
      while ( AV136GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV136GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV27TFDisponibilidadId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFDisponibilidadId), 8, 0));
            AV28TFDisponibilidadId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID") == 0 )
         {
            AV29TFEventId = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFEventId", AV29TFEventId);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID_SEL") == 0 )
         {
            AV30TFEventId_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFEventId_Sel", AV30TFEventId_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION") == 0 )
         {
            AV31TFDisponibilidadDescription = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFDisponibilidadDescription", AV31TFDisponibilidadDescription);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION_SEL") == 0 )
         {
            AV32TFDisponibilidadDescription_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFDisponibilidadDescription_Sel", AV32TFDisponibilidadDescription_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV33TFProfesionalId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFProfesionalId), 8, 0));
            AV34TFProfesionalId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV35TFProfesionalApellidoPaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFProfesionalApellidoPaterno", AV35TFProfesionalApellidoPaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV36TFProfesionalApellidoPaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFProfesionalApellidoPaterno_Sel", AV36TFProfesionalApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV37TFProfesionalApellidoMaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFProfesionalApellidoMaterno", AV37TFProfesionalApellidoMaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV38TFProfesionalApellidoMaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFProfesionalApellidoMaterno_Sel", AV38TFProfesionalApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV39TFProfesionalNombres = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFProfesionalNombres", AV39TFProfesionalNombres);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV40TFProfesionalNombres_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFProfesionalNombres_Sel", AV40TFProfesionalNombres_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO") == 0 )
         {
            AV41TFProfesionalNombreCompleto = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFProfesionalNombreCompleto", AV41TFProfesionalNombreCompleto);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO_SEL") == 0 )
         {
            AV42TFProfesionalNombreCompleto_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFProfesionalNombreCompleto_Sel", AV42TFProfesionalNombreCompleto_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV43TFProfesionalCOP = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFProfesionalCOP", AV43TFProfesionalCOP);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV44TFProfesionalCOP_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFProfesionalCOP_Sel", AV44TFProfesionalCOP_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADFECHA") == 0 )
         {
            AV45TFDisponibilidadFecha = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFDisponibilidadFecha", localUtil.format(AV45TFDisponibilidadFecha, "99/99/99"));
            AV46TFDisponibilidadFecha_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFDisponibilidadFecha_To", localUtil.format(AV46TFDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAINICIO") == 0 )
         {
            AV49TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFDisponibilidadHoraInicio", localUtil.ttoc( AV49TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV50TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV50TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            AV51DDO_DisponibilidadHoraInicioAuxDate = GXutil.resetTime(AV49TFDisponibilidadHoraInicio) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51DDO_DisponibilidadHoraInicioAuxDate", localUtil.format(AV51DDO_DisponibilidadHoraInicioAuxDate, "99/99/99"));
            AV52DDO_DisponibilidadHoraInicioAuxDateTo = GXutil.resetTime(AV50TFDisponibilidadHoraInicio_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52DDO_DisponibilidadHoraInicioAuxDateTo", localUtil.format(AV52DDO_DisponibilidadHoraInicioAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAFIN") == 0 )
         {
            AV53TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFDisponibilidadHoraFin", localUtil.ttoc( AV53TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV54TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFDisponibilidadHoraFin_To", localUtil.ttoc( AV54TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            AV55DDO_DisponibilidadHoraFinAuxDate = GXutil.resetTime(AV53TFDisponibilidadHoraFin) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55DDO_DisponibilidadHoraFinAuxDate", localUtil.format(AV55DDO_DisponibilidadHoraFinAuxDate, "99/99/99"));
            AV56DDO_DisponibilidadHoraFinAuxDateTo = GXutil.resetTime(AV54TFDisponibilidadHoraFin_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56DDO_DisponibilidadHoraFinAuxDateTo", localUtil.format(AV56DDO_DisponibilidadHoraFinAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV57TFEspecialidadId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFEspecialidadId), 4, 0));
            AV58TFEspecialidadId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFEspecialidadId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV59TFEspecialidadCodigo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFEspecialidadCodigo", AV59TFEspecialidadCodigo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV60TFEspecialidadCodigo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFEspecialidadCodigo_Sel", AV60TFEspecialidadCodigo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV61TFEspecialidadNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFEspecialidadNombre", AV61TFEspecialidadNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV62TFEspecialidadNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFEspecialidadNombre_Sel", AV62TFEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADUSER") == 0 )
         {
            AV71TFDisponibilidadUser = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFDisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71TFDisponibilidadUser), 6, 0));
            AV72TFDisponibilidadUser_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFDisponibilidadUser_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72TFDisponibilidadUser_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADO_SEL") == 0 )
         {
            AV73TFDisponibilidadEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFDisponibilidadEstado_SelsJson", AV73TFDisponibilidadEstado_SelsJson);
            AV74TFDisponibilidadEstado_Sels.fromJSonString(AV73TFDisponibilidadEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADOCITA_SEL") == 0 )
         {
            AV75TFDisponibilidadEstadoCita_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFDisponibilidadEstadoCita_SelsJson", AV75TFDisponibilidadEstadoCita_SelsJson);
            AV76TFDisponibilidadEstadoCita_Sels.fromJSonString(AV75TFDisponibilidadEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCITAID") == 0 )
         {
            AV77TFDCitaId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFDCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFDCitaId), 6, 0));
            AV78TFDCitaId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFDCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFDCitaId_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADTIPOCITA_SEL") == 0 )
         {
            AV88TFDisponibilidadTipoCita_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFDisponibilidadTipoCita_SelsJson", AV88TFDisponibilidadTipoCita_SelsJson);
            AV89TFDisponibilidadTipoCita_Sels.fromJSonString(AV88TFDisponibilidadTipoCita_SelsJson, null);
         }
         AV136GXV1 = (int)(AV136GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFEventId_Sel)==0), AV30TFEventId_Sel, GXv_char8) ;
      disponibilidadww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFDisponibilidadDescription_Sel)==0), AV32TFDisponibilidadDescription_Sel, GXv_char7) ;
      disponibilidadww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFProfesionalApellidoPaterno_Sel)==0), AV36TFProfesionalApellidoPaterno_Sel, GXv_char15) ;
      disponibilidadww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFProfesionalApellidoMaterno_Sel)==0), AV38TFProfesionalApellidoMaterno_Sel, GXv_char17) ;
      disponibilidadww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFProfesionalNombres_Sel)==0), AV40TFProfesionalNombres_Sel, GXv_char19) ;
      disponibilidadww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFProfesionalNombreCompleto_Sel)==0), AV42TFProfesionalNombreCompleto_Sel, GXv_char21) ;
      disponibilidadww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFProfesionalCOP_Sel)==0), AV44TFProfesionalCOP_Sel, GXv_char23) ;
      disponibilidadww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV60TFEspecialidadCodigo_Sel)==0), AV60TFEspecialidadCodigo_Sel, GXv_char25) ;
      disponibilidadww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV62TFEspecialidadNombre_Sel)==0), AV62TFEspecialidadNombre_Sel, GXv_char27) ;
      disponibilidadww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV74TFDisponibilidadEstado_Sels.size()==0), AV73TFDisponibilidadEstado_SelsJson, GXv_char29) ;
      disponibilidadww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV76TFDisponibilidadEstadoCita_Sels.size()==0), AV75TFDisponibilidadEstadoCita_SelsJson, GXv_char31) ;
      disponibilidadww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV89TFDisponibilidadTipoCita_Sels.size()==0), AV88TFDisponibilidadTipoCita_SelsJson, GXv_char33) ;
      disponibilidadww_impl.this.GXt_char32 = GXv_char33[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|"+GXt_char13+"||"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"|||||"+GXt_char24+"|"+GXt_char26+"||"+GXt_char28+"|"+GXt_char30+"||"+GXt_char32 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFEventId)==0), AV29TFEventId, GXv_char33) ;
      disponibilidadww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFDisponibilidadDescription)==0), AV31TFDisponibilidadDescription, GXv_char31) ;
      disponibilidadww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFProfesionalApellidoPaterno)==0), AV35TFProfesionalApellidoPaterno, GXv_char29) ;
      disponibilidadww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFProfesionalApellidoMaterno)==0), AV37TFProfesionalApellidoMaterno, GXv_char27) ;
      disponibilidadww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFProfesionalNombres)==0), AV39TFProfesionalNombres, GXv_char25) ;
      disponibilidadww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV41TFProfesionalNombreCompleto)==0), AV41TFProfesionalNombreCompleto, GXv_char23) ;
      disponibilidadww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFProfesionalCOP)==0), AV43TFProfesionalCOP, GXv_char21) ;
      disponibilidadww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV59TFEspecialidadCodigo)==0), AV59TFEspecialidadCodigo, GXv_char19) ;
      disponibilidadww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV61TFEspecialidadNombre)==0), AV61TFEspecialidadNombre, GXv_char17) ;
      disponibilidadww_impl.this.GXt_char16 = GXv_char17[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFDisponibilidadId) ? "" : GXutil.str( AV27TFDisponibilidadId, 8, 0))+"|"+GXt_char32+"|"+GXt_char30+"|"+((0==AV33TFProfesionalId) ? "" : GXutil.str( AV33TFProfesionalId, 8, 0))+"|"+GXt_char28+"|"+GXt_char26+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV45TFDisponibilidadFecha)) ? "" : localUtil.dtoc( AV45TFDisponibilidadFecha, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV49TFDisponibilidadHoraInicio) ? "" : localUtil.dtoc( AV51DDO_DisponibilidadHoraInicioAuxDate, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV53TFDisponibilidadHoraFin) ? "" : localUtil.dtoc( AV55DDO_DisponibilidadHoraFinAuxDate, 3, "/"))+"|"+((0==AV57TFEspecialidadId) ? "" : GXutil.str( AV57TFEspecialidadId, 4, 0))+"|"+GXt_char18+"|"+GXt_char16+"|"+((0==AV71TFDisponibilidadUser) ? "" : GXutil.str( AV71TFDisponibilidadUser, 6, 0))+"|||"+((0==AV77TFDCitaId) ? "" : GXutil.str( AV77TFDCitaId, 6, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFDisponibilidadId_To) ? "" : GXutil.str( AV28TFDisponibilidadId_To, 8, 0))+"|||"+((0==AV34TFProfesionalId_To) ? "" : GXutil.str( AV34TFProfesionalId_To, 8, 0))+"||||||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV46TFDisponibilidadFecha_To)) ? "" : localUtil.dtoc( AV46TFDisponibilidadFecha_To, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV50TFDisponibilidadHoraInicio_To) ? "" : localUtil.dtoc( AV52DDO_DisponibilidadHoraInicioAuxDateTo, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV54TFDisponibilidadHoraFin_To) ? "" : localUtil.dtoc( AV56DDO_DisponibilidadHoraFinAuxDateTo, 3, "/"))+"|"+((0==AV58TFEspecialidadId_To) ? "" : GXutil.str( AV58TFEspecialidadId_To, 4, 0))+"|||"+((0==AV72TFDisponibilidadUser_To) ? "" : GXutil.str( AV72TFDisponibilidadUser_To, 6, 0))+"|||"+((0==AV78TFDCitaId_To) ? "" : GXutil.str( AV78TFDCitaId_To, 6, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV135Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADID", !((0==AV27TFDisponibilidadId)&&(0==AV28TFDisponibilidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFDisponibilidadId, 8, 0)), GXutil.trim( GXutil.str( AV28TFDisponibilidadId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFEVENTID", !(GXutil.strcmp("", AV29TFEventId)==0), (short)(0), AV29TFEventId, "", !(GXutil.strcmp("", AV30TFEventId_Sel)==0), AV30TFEventId_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADDESCRIPTION", !(GXutil.strcmp("", AV31TFDisponibilidadDescription)==0), (short)(0), AV31TFDisponibilidadDescription, "", !(GXutil.strcmp("", AV32TFDisponibilidadDescription_Sel)==0), AV32TFDisponibilidadDescription_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFPROFESIONALID", !((0==AV33TFProfesionalId)&&(0==AV34TFProfesionalId_To)), (short)(0), GXutil.trim( GXutil.str( AV33TFProfesionalId, 8, 0)), GXutil.trim( GXutil.str( AV34TFProfesionalId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFPROFESIONALAPELLIDOPATERNO", !(GXutil.strcmp("", AV35TFProfesionalApellidoPaterno)==0), (short)(0), AV35TFProfesionalApellidoPaterno, "", !(GXutil.strcmp("", AV36TFProfesionalApellidoPaterno_Sel)==0), AV36TFProfesionalApellidoPaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFPROFESIONALAPELLIDOMATERNO", !(GXutil.strcmp("", AV37TFProfesionalApellidoMaterno)==0), (short)(0), AV37TFProfesionalApellidoMaterno, "", !(GXutil.strcmp("", AV38TFProfesionalApellidoMaterno_Sel)==0), AV38TFProfesionalApellidoMaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFPROFESIONALNOMBRES", !(GXutil.strcmp("", AV39TFProfesionalNombres)==0), (short)(0), AV39TFProfesionalNombres, "", !(GXutil.strcmp("", AV40TFProfesionalNombres_Sel)==0), AV40TFProfesionalNombres_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFPROFESIONALNOMBRECOMPLETO", !(GXutil.strcmp("", AV41TFProfesionalNombreCompleto)==0), (short)(0), AV41TFProfesionalNombreCompleto, "", !(GXutil.strcmp("", AV42TFProfesionalNombreCompleto_Sel)==0), AV42TFProfesionalNombreCompleto_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFPROFESIONALCOP", !(GXutil.strcmp("", AV43TFProfesionalCOP)==0), (short)(0), AV43TFProfesionalCOP, "", !(GXutil.strcmp("", AV44TFProfesionalCOP_Sel)==0), AV44TFProfesionalCOP_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADFECHA", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV45TFDisponibilidadFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV46TFDisponibilidadFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV45TFDisponibilidadFecha, 3, "/")), GXutil.trim( localUtil.dtoc( AV46TFDisponibilidadFecha_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADHORAINICIO", !(GXutil.dateCompare(GXutil.nullDate(), AV49TFDisponibilidadHoraInicio)&&GXutil.dateCompare(GXutil.nullDate(), AV50TFDisponibilidadHoraInicio_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV49TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV50TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADHORAFIN", !(GXutil.dateCompare(GXutil.nullDate(), AV53TFDisponibilidadHoraFin)&&GXutil.dateCompare(GXutil.nullDate(), AV54TFDisponibilidadHoraFin_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV53TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV54TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFESPECIALIDADID", !((0==AV57TFEspecialidadId)&&(0==AV58TFEspecialidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV57TFEspecialidadId, 4, 0)), GXutil.trim( GXutil.str( AV58TFEspecialidadId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFESPECIALIDADCODIGO", !(GXutil.strcmp("", AV59TFEspecialidadCodigo)==0), (short)(0), AV59TFEspecialidadCodigo, "", !(GXutil.strcmp("", AV60TFEspecialidadCodigo_Sel)==0), AV60TFEspecialidadCodigo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFESPECIALIDADNOMBRE", !(GXutil.strcmp("", AV61TFEspecialidadNombre)==0), (short)(0), AV61TFEspecialidadNombre, "", !(GXutil.strcmp("", AV62TFEspecialidadNombre_Sel)==0), AV62TFEspecialidadNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADUSER", !((0==AV71TFDisponibilidadUser)&&(0==AV72TFDisponibilidadUser_To)), (short)(0), GXutil.trim( GXutil.str( AV71TFDisponibilidadUser, 6, 0)), GXutil.trim( GXutil.str( AV72TFDisponibilidadUser_To, 6, 0))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADESTADO_SEL", !(AV74TFDisponibilidadEstado_Sels.size()==0), (short)(0), AV74TFDisponibilidadEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADESTADOCITA_SEL", !(AV76TFDisponibilidadEstadoCita_Sels.size()==0), (short)(0), AV76TFDisponibilidadEstadoCita_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDCITAID", !((0==AV77TFDCitaId)&&(0==AV78TFDCitaId_To)), (short)(0), GXutil.trim( GXutil.str( AV77TFDCitaId, 6, 0)), GXutil.trim( GXutil.str( AV78TFDCitaId_To, 6, 0))) ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      GXv_SdtWWPGridState34[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState34, "TFDISPONIBILIDADTIPOCITA_SEL", !(AV89TFDisponibilidadTipoCita_Sels.size()==0), (short)(0), AV89TFDisponibilidadTipoCita_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState34[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV135Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV135Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Disponibilidad" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_1S2( boolean wbgen )
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
         wb_table2_30_1S2( true) ;
      }
      else
      {
         wb_table2_30_1S2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_1S2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_1S2e( true) ;
      }
      else
      {
         wb_table1_25_1S2e( false) ;
      }
   }

   public void wb_table2_30_1S2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_DisponibilidadWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_1S2e( true) ;
      }
      else
      {
         wb_table2_30_1S2e( false) ;
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
      pa1S2( ) ;
      ws1S2( ) ;
      we1S2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033349", true, true);
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
      httpContext.AddJavascriptSource("disponibilidadww.js", "?20225110333410", false, true);
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
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_43_idx ;
      edtEventId_Internalname = "EVENTID_"+sGXsfl_43_idx ;
      edtDisponibilidadDescription_Internalname = "DISPONIBILIDADDESCRIPTION_"+sGXsfl_43_idx ;
      edtProfesionalId_Internalname = "PROFESIONALID_"+sGXsfl_43_idx ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO_"+sGXsfl_43_idx ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO_"+sGXsfl_43_idx ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES_"+sGXsfl_43_idx ;
      edtProfesionalNombreCompleto_Internalname = "PROFESIONALNOMBRECOMPLETO_"+sGXsfl_43_idx ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP_"+sGXsfl_43_idx ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA_"+sGXsfl_43_idx ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO_"+sGXsfl_43_idx ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN_"+sGXsfl_43_idx ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_43_idx ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO_"+sGXsfl_43_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_43_idx ;
      edtDisponibilidadUser_Internalname = "DISPONIBILIDADUSER_"+sGXsfl_43_idx ;
      cmbDisponibilidadEstado.setInternalname( "DISPONIBILIDADESTADO_"+sGXsfl_43_idx );
      cmbDisponibilidadEstadoCita.setInternalname( "DISPONIBILIDADESTADOCITA_"+sGXsfl_43_idx );
      edtDCitaId_Internalname = "DCITAID_"+sGXsfl_43_idx ;
      cmbDisponibilidadTipoCita.setInternalname( "DISPONIBILIDADTIPOCITA_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_43_fel_idx ;
      edtEventId_Internalname = "EVENTID_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadDescription_Internalname = "DISPONIBILIDADDESCRIPTION_"+sGXsfl_43_fel_idx ;
      edtProfesionalId_Internalname = "PROFESIONALID_"+sGXsfl_43_fel_idx ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO_"+sGXsfl_43_fel_idx ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO_"+sGXsfl_43_fel_idx ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES_"+sGXsfl_43_fel_idx ;
      edtProfesionalNombreCompleto_Internalname = "PROFESIONALNOMBRECOMPLETO_"+sGXsfl_43_fel_idx ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN_"+sGXsfl_43_fel_idx ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_43_fel_idx ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO_"+sGXsfl_43_fel_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_43_fel_idx ;
      edtDisponibilidadUser_Internalname = "DISPONIBILIDADUSER_"+sGXsfl_43_fel_idx ;
      cmbDisponibilidadEstado.setInternalname( "DISPONIBILIDADESTADO_"+sGXsfl_43_fel_idx );
      cmbDisponibilidadEstadoCita.setInternalname( "DISPONIBILIDADESTADOCITA_"+sGXsfl_43_fel_idx );
      edtDCitaId_Internalname = "DCITAID_"+sGXsfl_43_fel_idx ;
      cmbDisponibilidadTipoCita.setInternalname( "DISPONIBILIDADTIPOCITA_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb1S0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV83Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV85Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtDisponibilidadId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEventId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEventId_Internalname,GXutil.rtrim( A133EventId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEventId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEventId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtDisponibilidadDescription_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadDescription_Internalname,A134DisponibilidadDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDisponibilidadDescription_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"WWPBaseObjects\\WWP_Description","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtProfesionalId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalId_Internalname,GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalApellidoPaterno_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalApellidoPaterno_Internalname,A85ProfesionalApellidoPaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalApellidoPaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalApellidoPaterno_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalApellidoMaterno_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalApellidoMaterno_Internalname,A86ProfesionalApellidoMaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalApellidoMaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalApellidoMaterno_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalNombres_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalNombres_Internalname,A84ProfesionalNombres,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalNombres_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalNombreCompleto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalNombreCompleto_Internalname,A83ProfesionalNombreCompleto,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalNombreCompleto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalNombreCompleto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalCOP_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalCOP_Internalname,A88ProfesionalCOP,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalCOP_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalCOP_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadFecha_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadFecha_Internalname,localUtil.format(A67DisponibilidadFecha, "99/99/99"),localUtil.format( A67DisponibilidadFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDisponibilidadFecha_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadHoraInicio_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadHoraInicio_Internalname,localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A69DisponibilidadHoraInicio, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadHoraInicio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDisponibilidadHoraInicio_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadHoraFin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadHoraFin_Internalname,localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A135DisponibilidadHoraFin, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadHoraFin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDisponibilidadHoraFin_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEspecialidadId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEspecialidadId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEspecialidadCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadCodigo_Internalname,A140EspecialidadCodigo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEspecialidadCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEspecialidadNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadNombre_Internalname,A71EspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtEspecialidadNombre_Link,"","","",edtEspecialidadNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEspecialidadNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadUser_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadUser_Internalname,GXutil.ltrim( localUtil.ntoc( A137DisponibilidadUser, (byte)(6), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadUser_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDisponibilidadUser_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbDisponibilidadEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbDisponibilidadEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DISPONIBILIDADESTADO_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDisponibilidadEstado,cmbDisponibilidadEstado.getInternalname(),GXutil.rtrim( A136DisponibilidadEstado),Integer.valueOf(1),cmbDisponibilidadEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbDisponibilidadEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbDisponibilidadEstado.setValue( GXutil.rtrim( A136DisponibilidadEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstado.getInternalname(), "Values", cmbDisponibilidadEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbDisponibilidadEstadoCita.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbDisponibilidadEstadoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DISPONIBILIDADESTADOCITA_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDisponibilidadEstadoCita,cmbDisponibilidadEstadoCita.getInternalname(),GXutil.rtrim( A139DisponibilidadEstadoCita),Integer.valueOf(1),cmbDisponibilidadEstadoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","svchar","",Integer.valueOf(cmbDisponibilidadEstadoCita.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbDisponibilidadEstadoCita.setValue( GXutil.rtrim( A139DisponibilidadEstadoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstadoCita.getInternalname(), "Values", cmbDisponibilidadEstadoCita.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDCitaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDCitaId_Internalname,GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDCitaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDCitaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbDisponibilidadTipoCita.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbDisponibilidadTipoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DISPONIBILIDADTIPOCITA_" + sGXsfl_43_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDisponibilidadTipoCita,cmbDisponibilidadTipoCita.getInternalname(),GXutil.rtrim( A298DisponibilidadTipoCita),Integer.valueOf(1),cmbDisponibilidadTipoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbDisponibilidadTipoCita.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbDisponibilidadTipoCita.setValue( GXutil.rtrim( A298DisponibilidadTipoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadTipoCita.getInternalname(), "Values", cmbDisponibilidadTipoCita.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes1S2( ) ;
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
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_disponibilidadfechaauxdatetext_Internalname = "vDDO_DISPONIBILIDADFECHAAUXDATETEXT" ;
      Tfdisponibilidadfecha_rangepicker_Internalname = "TFDISPONIBILIDADFECHA_RANGEPICKER" ;
      divDdo_disponibilidadfechaauxdates_Internalname = "DDO_DISPONIBILIDADFECHAAUXDATES" ;
      edtavDdo_disponibilidadhorainicioauxdatetext_Internalname = "vDDO_DISPONIBILIDADHORAINICIOAUXDATETEXT" ;
      Tfdisponibilidadhorainicio_rangepicker_Internalname = "TFDISPONIBILIDADHORAINICIO_RANGEPICKER" ;
      divDdo_disponibilidadhorainicioauxdates_Internalname = "DDO_DISPONIBILIDADHORAINICIOAUXDATES" ;
      edtavDdo_disponibilidadhorafinauxdatetext_Internalname = "vDDO_DISPONIBILIDADHORAFINAUXDATETEXT" ;
      Tfdisponibilidadhorafin_rangepicker_Internalname = "TFDISPONIBILIDADHORAFIN_RANGEPICKER" ;
      divDdo_disponibilidadhorafinauxdates_Internalname = "DDO_DISPONIBILIDADHORAFINAUXDATES" ;
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
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_disponibilidadhorafinauxdatetext_Jsonclick = "" ;
      edtavDdo_disponibilidadhorainicioauxdatetext_Jsonclick = "" ;
      edtavDdo_disponibilidadfechaauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtEspecialidadNombre_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbDisponibilidadTipoCita.setVisible( -1 );
      edtDCitaId_Visible = -1 ;
      cmbDisponibilidadEstadoCita.setVisible( -1 );
      cmbDisponibilidadEstado.setVisible( -1 );
      edtDisponibilidadUser_Visible = -1 ;
      edtEspecialidadNombre_Visible = -1 ;
      edtEspecialidadCodigo_Visible = -1 ;
      edtEspecialidadId_Visible = -1 ;
      edtDisponibilidadHoraFin_Visible = -1 ;
      edtDisponibilidadHoraInicio_Visible = -1 ;
      edtDisponibilidadFecha_Visible = -1 ;
      edtProfesionalCOP_Visible = -1 ;
      edtProfesionalNombreCompleto_Visible = -1 ;
      edtProfesionalNombres_Visible = -1 ;
      edtProfesionalApellidoMaterno_Visible = -1 ;
      edtProfesionalApellidoPaterno_Visible = -1 ;
      edtProfesionalId_Visible = -1 ;
      edtDisponibilidadDescription_Visible = -1 ;
      edtEventId_Visible = -1 ;
      edtDisponibilidadId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Disponibilidad" );
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
      Ddo_grid_Datalistproc = "DisponibilidadWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||||||||||||A:Activo,I:Inactivo|L:Libre,O:Ocupado,E:Expiró||V:Virtual,P:En consultorio,D:Visita a domicilio" ;
      Ddo_grid_Allowmultipleselection = "||||||||||||||||T|T||T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic||Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|||||Dynamic|Dynamic||FixedValues|FixedValues||FixedValues" ;
      Ddo_grid_Includedatalist = "|T|T||T|T|T|T|T|||||T|T||T|T||T" ;
      Ddo_grid_Filterisrange = "T|||T||||||P|P|P|T|||T|||T|" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Numeric|Character|Character|Character|Character|Character|Date|Date|Date|Numeric|Character|Character|Numeric|||Numeric|" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|||T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T||T|T|T|T|T|T|T|T|T|T||T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7||8|9|10|11|12|13|14|15|16|17||18" ;
      Ddo_grid_Columnids = "2:DisponibilidadId|3:EventId|4:DisponibilidadDescription|5:ProfesionalId|6:ProfesionalApellidoPaterno|7:ProfesionalApellidoMaterno|8:ProfesionalNombres|9:ProfesionalNombreCompleto|10:ProfesionalCOP|11:DisponibilidadFecha|12:DisponibilidadHoraInicio|13:DisponibilidadHoraFin|14:EspecialidadId|15:EspecialidadCodigo|16:EspecialidadNombre|17:DisponibilidadUser|18:DisponibilidadEstado|19:DisponibilidadEstadoCita|20:DCitaId|21:DisponibilidadTipoCita" ;
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
      GXCCtl = "DISPONIBILIDADESTADO_" + sGXsfl_43_idx ;
      cmbDisponibilidadEstado.setName( GXCCtl );
      cmbDisponibilidadEstado.setWebtags( "" );
      cmbDisponibilidadEstado.addItem("A", "Activo", (short)(0));
      cmbDisponibilidadEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbDisponibilidadEstado.getItemCount() > 0 )
      {
         A136DisponibilidadEstado = cmbDisponibilidadEstado.getValidValue(A136DisponibilidadEstado) ;
      }
      GXCCtl = "DISPONIBILIDADESTADOCITA_" + sGXsfl_43_idx ;
      cmbDisponibilidadEstadoCita.setName( GXCCtl );
      cmbDisponibilidadEstadoCita.setWebtags( "" );
      cmbDisponibilidadEstadoCita.addItem("L", "Libre", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("O", "Ocupado", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("E", "Expiró", (short)(0));
      if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
      {
         A139DisponibilidadEstadoCita = cmbDisponibilidadEstadoCita.getValidValue(A139DisponibilidadEstadoCita) ;
      }
      GXCCtl = "DISPONIBILIDADTIPOCITA_" + sGXsfl_43_idx ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'edtEventId_Visible',ctrl:'EVENTID',prop:'Visible'},{av:'edtDisponibilidadDescription_Visible',ctrl:'DISPONIBILIDADDESCRIPTION',prop:'Visible'},{av:'edtProfesionalId_Visible',ctrl:'PROFESIONALID',prop:'Visible'},{av:'edtProfesionalApellidoPaterno_Visible',ctrl:'PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{av:'edtProfesionalApellidoMaterno_Visible',ctrl:'PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{av:'edtProfesionalNombres_Visible',ctrl:'PROFESIONALNOMBRES',prop:'Visible'},{av:'edtProfesionalNombreCompleto_Visible',ctrl:'PROFESIONALNOMBRECOMPLETO',prop:'Visible'},{av:'edtProfesionalCOP_Visible',ctrl:'PROFESIONALCOP',prop:'Visible'},{av:'edtDisponibilidadFecha_Visible',ctrl:'DISPONIBILIDADFECHA',prop:'Visible'},{av:'edtDisponibilidadHoraInicio_Visible',ctrl:'DISPONIBILIDADHORAINICIO',prop:'Visible'},{av:'edtDisponibilidadHoraFin_Visible',ctrl:'DISPONIBILIDADHORAFIN',prop:'Visible'},{av:'edtEspecialidadId_Visible',ctrl:'ESPECIALIDADID',prop:'Visible'},{av:'edtEspecialidadCodigo_Visible',ctrl:'ESPECIALIDADCODIGO',prop:'Visible'},{av:'edtEspecialidadNombre_Visible',ctrl:'ESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtDisponibilidadUser_Visible',ctrl:'DISPONIBILIDADUSER',prop:'Visible'},{av:'cmbDisponibilidadEstado'},{av:'cmbDisponibilidadEstadoCita'},{av:'edtDCitaId_Visible',ctrl:'DCITAID',prop:'Visible'},{av:'cmbDisponibilidadTipoCita'},{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e211S2',iparms:[{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV83Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV85Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtEspecialidadNombre_Link',ctrl:'ESPECIALIDADNOMBRE',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e151S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'edtEventId_Visible',ctrl:'EVENTID',prop:'Visible'},{av:'edtDisponibilidadDescription_Visible',ctrl:'DISPONIBILIDADDESCRIPTION',prop:'Visible'},{av:'edtProfesionalId_Visible',ctrl:'PROFESIONALID',prop:'Visible'},{av:'edtProfesionalApellidoPaterno_Visible',ctrl:'PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{av:'edtProfesionalApellidoMaterno_Visible',ctrl:'PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{av:'edtProfesionalNombres_Visible',ctrl:'PROFESIONALNOMBRES',prop:'Visible'},{av:'edtProfesionalNombreCompleto_Visible',ctrl:'PROFESIONALNOMBRECOMPLETO',prop:'Visible'},{av:'edtProfesionalCOP_Visible',ctrl:'PROFESIONALCOP',prop:'Visible'},{av:'edtDisponibilidadFecha_Visible',ctrl:'DISPONIBILIDADFECHA',prop:'Visible'},{av:'edtDisponibilidadHoraInicio_Visible',ctrl:'DISPONIBILIDADHORAINICIO',prop:'Visible'},{av:'edtDisponibilidadHoraFin_Visible',ctrl:'DISPONIBILIDADHORAFIN',prop:'Visible'},{av:'edtEspecialidadId_Visible',ctrl:'ESPECIALIDADID',prop:'Visible'},{av:'edtEspecialidadCodigo_Visible',ctrl:'ESPECIALIDADCODIGO',prop:'Visible'},{av:'edtEspecialidadNombre_Visible',ctrl:'ESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtDisponibilidadUser_Visible',ctrl:'DISPONIBILIDADUSER',prop:'Visible'},{av:'cmbDisponibilidadEstado'},{av:'cmbDisponibilidadEstadoCita'},{av:'edtDCitaId_Visible',ctrl:'DCITAID',prop:'Visible'},{av:'cmbDisponibilidadTipoCita'},{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV51DDO_DisponibilidadHoraInicioAuxDate',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV55DDO_DisponibilidadHoraFinAuxDate',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV52DDO_DisponibilidadHoraInicioAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV56DDO_DisponibilidadHoraFinAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATETO',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV55DDO_DisponibilidadHoraFinAuxDate',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV56DDO_DisponibilidadHoraFinAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV51DDO_DisponibilidadHoraInicioAuxDate',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV52DDO_DisponibilidadHoraInicioAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'edtEventId_Visible',ctrl:'EVENTID',prop:'Visible'},{av:'edtDisponibilidadDescription_Visible',ctrl:'DISPONIBILIDADDESCRIPTION',prop:'Visible'},{av:'edtProfesionalId_Visible',ctrl:'PROFESIONALID',prop:'Visible'},{av:'edtProfesionalApellidoPaterno_Visible',ctrl:'PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{av:'edtProfesionalApellidoMaterno_Visible',ctrl:'PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{av:'edtProfesionalNombres_Visible',ctrl:'PROFESIONALNOMBRES',prop:'Visible'},{av:'edtProfesionalNombreCompleto_Visible',ctrl:'PROFESIONALNOMBRECOMPLETO',prop:'Visible'},{av:'edtProfesionalCOP_Visible',ctrl:'PROFESIONALCOP',prop:'Visible'},{av:'edtDisponibilidadFecha_Visible',ctrl:'DISPONIBILIDADFECHA',prop:'Visible'},{av:'edtDisponibilidadHoraInicio_Visible',ctrl:'DISPONIBILIDADHORAINICIO',prop:'Visible'},{av:'edtDisponibilidadHoraFin_Visible',ctrl:'DISPONIBILIDADHORAFIN',prop:'Visible'},{av:'edtEspecialidadId_Visible',ctrl:'ESPECIALIDADID',prop:'Visible'},{av:'edtEspecialidadCodigo_Visible',ctrl:'ESPECIALIDADCODIGO',prop:'Visible'},{av:'edtEspecialidadNombre_Visible',ctrl:'ESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtDisponibilidadUser_Visible',ctrl:'DISPONIBILIDADUSER',prop:'Visible'},{av:'cmbDisponibilidadEstado'},{av:'cmbDisponibilidadEstadoCita'},{av:'edtDCitaId_Visible',ctrl:'DCITAID',prop:'Visible'},{av:'cmbDisponibilidadTipoCita'},{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e161S2',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e171S2',iparms:[{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV51DDO_DisponibilidadHoraInicioAuxDate',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV55DDO_DisponibilidadHoraFinAuxDate',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV52DDO_DisponibilidadHoraInicioAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV56DDO_DisponibilidadHoraFinAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV55DDO_DisponibilidadHoraFinAuxDate',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV56DDO_DisponibilidadHoraFinAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV51DDO_DisponibilidadHoraInicioAuxDate',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV52DDO_DisponibilidadHoraInicioAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e181S2',iparms:[{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV51DDO_DisponibilidadHoraInicioAuxDate',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV55DDO_DisponibilidadHoraFinAuxDate',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV52DDO_DisponibilidadHoraInicioAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV56DDO_DisponibilidadHoraFinAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFDisponibilidadId',fld:'vTFDISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV28TFDisponibilidadId_To',fld:'vTFDISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFEventId',fld:'vTFEVENTID',pic:''},{av:'AV30TFEventId_Sel',fld:'vTFEVENTID_SEL',pic:''},{av:'AV31TFDisponibilidadDescription',fld:'vTFDISPONIBILIDADDESCRIPTION',pic:''},{av:'AV32TFDisponibilidadDescription_Sel',fld:'vTFDISPONIBILIDADDESCRIPTION_SEL',pic:''},{av:'AV33TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV34TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV35TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV36TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV37TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV38TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV39TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV40TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV41TFProfesionalNombreCompleto',fld:'vTFPROFESIONALNOMBRECOMPLETO',pic:''},{av:'AV42TFProfesionalNombreCompleto_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV44TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV45TFDisponibilidadFecha',fld:'vTFDISPONIBILIDADFECHA',pic:''},{av:'AV46TFDisponibilidadFecha_To',fld:'vTFDISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV50TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV53TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV54TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV57TFEspecialidadId',fld:'vTFESPECIALIDADID',pic:'ZZZ9'},{av:'AV58TFEspecialidadId_To',fld:'vTFESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV59TFEspecialidadCodigo',fld:'vTFESPECIALIDADCODIGO',pic:''},{av:'AV60TFEspecialidadCodigo_Sel',fld:'vTFESPECIALIDADCODIGO_SEL',pic:''},{av:'AV61TFEspecialidadNombre',fld:'vTFESPECIALIDADNOMBRE',pic:''},{av:'AV62TFEspecialidadNombre_Sel',fld:'vTFESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV71TFDisponibilidadUser',fld:'vTFDISPONIBILIDADUSER',pic:'ZZZZZ9'},{av:'AV72TFDisponibilidadUser_To',fld:'vTFDISPONIBILIDADUSER_TO',pic:'ZZZZZ9'},{av:'AV74TFDisponibilidadEstado_Sels',fld:'vTFDISPONIBILIDADESTADO_SELS',pic:''},{av:'AV76TFDisponibilidadEstadoCita_Sels',fld:'vTFDISPONIBILIDADESTADOCITA_SELS',pic:''},{av:'AV77TFDCitaId',fld:'vTFDCITAID',pic:'ZZZZZ9'},{av:'AV78TFDCitaId_To',fld:'vTFDCITAID_TO',pic:'ZZZZZ9'},{av:'AV89TFDisponibilidadTipoCita_Sels',fld:'vTFDISPONIBILIDADTIPOCITA_SELS',pic:''},{av:'AV135Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV91IsAuthorized_EspecialidadNombre',fld:'vISAUTHORIZED_ESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV88TFDisponibilidadTipoCita_SelsJson',fld:'vTFDISPONIBILIDADTIPOCITA_SELSJSON',pic:''},{av:'AV75TFDisponibilidadEstadoCita_SelsJson',fld:'vTFDISPONIBILIDADESTADOCITA_SELSJSON',pic:''},{av:'AV73TFDisponibilidadEstado_SelsJson',fld:'vTFDISPONIBILIDADESTADO_SELSJSON',pic:''},{av:'AV55DDO_DisponibilidadHoraFinAuxDate',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV56DDO_DisponibilidadHoraFinAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV51DDO_DisponibilidadHoraInicioAuxDate',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV52DDO_DisponibilidadHoraInicioAuxDateTo',fld:'vDDO_DISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
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
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV21ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV16FilterFullText = "" ;
      AV29TFEventId = "" ;
      AV30TFEventId_Sel = "" ;
      AV31TFDisponibilidadDescription = "" ;
      AV32TFDisponibilidadDescription_Sel = "" ;
      AV35TFProfesionalApellidoPaterno = "" ;
      AV36TFProfesionalApellidoPaterno_Sel = "" ;
      AV37TFProfesionalApellidoMaterno = "" ;
      AV38TFProfesionalApellidoMaterno_Sel = "" ;
      AV39TFProfesionalNombres = "" ;
      AV40TFProfesionalNombres_Sel = "" ;
      AV41TFProfesionalNombreCompleto = "" ;
      AV42TFProfesionalNombreCompleto_Sel = "" ;
      AV43TFProfesionalCOP = "" ;
      AV44TFProfesionalCOP_Sel = "" ;
      AV45TFDisponibilidadFecha = GXutil.nullDate() ;
      AV46TFDisponibilidadFecha_To = GXutil.nullDate() ;
      AV49TFDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV50TFDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV53TFDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV54TFDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV59TFEspecialidadCodigo = "" ;
      AV60TFEspecialidadCodigo_Sel = "" ;
      AV61TFEspecialidadNombre = "" ;
      AV62TFEspecialidadNombre_Sel = "" ;
      AV74TFDisponibilidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFDisponibilidadEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV89TFDisponibilidadTipoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV135Pgmname = "" ;
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
      AV79DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV48DDO_DisponibilidadFechaAuxDateTo = GXutil.nullDate() ;
      AV52DDO_DisponibilidadHoraInicioAuxDateTo = GXutil.nullDate() ;
      AV56DDO_DisponibilidadHoraFinAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV73TFDisponibilidadEstado_SelsJson = "" ;
      AV75TFDisponibilidadEstadoCita_SelsJson = "" ;
      AV88TFDisponibilidadTipoCita_SelsJson = "" ;
      AV47DDO_DisponibilidadFechaAuxDate = GXutil.nullDate() ;
      AV51DDO_DisponibilidadHoraInicioAuxDate = GXutil.nullDate() ;
      AV55DDO_DisponibilidadHoraFinAuxDate = GXutil.nullDate() ;
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
      AV83Update = "" ;
      AV85Delete = "" ;
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
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV92DDO_DisponibilidadFechaAuxDateText = "" ;
      ucTfdisponibilidadfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV93DDO_DisponibilidadHoraInicioAuxDateText = "" ;
      ucTfdisponibilidadhorainicio_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV94DDO_DisponibilidadHoraFinAuxDateText = "" ;
      ucTfdisponibilidadhorafin_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV97Disponibilidadwwds_1_filterfulltext = "" ;
      lV100Disponibilidadwwds_4_tfeventid = "" ;
      lV102Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      lV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      lV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      lV110Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      lV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      lV114Disponibilidadwwds_18_tfprofesionalcop = "" ;
      lV124Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      lV126Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      AV101Disponibilidadwwds_5_tfeventid_sel = "" ;
      AV100Disponibilidadwwds_4_tfeventid = "" ;
      AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel = "" ;
      AV102Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = "" ;
      AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = "" ;
      AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      AV111Disponibilidadwwds_15_tfprofesionalnombres_sel = "" ;
      AV110Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = "" ;
      AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      AV115Disponibilidadwwds_19_tfprofesionalcop_sel = "" ;
      AV114Disponibilidadwwds_18_tfprofesionalcop = "" ;
      AV116Disponibilidadwwds_20_tfdisponibilidadfecha = GXutil.nullDate() ;
      AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to = GXutil.nullDate() ;
      AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV120Disponibilidadwwds_24_tfdisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel = "" ;
      AV124Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      AV127Disponibilidadwwds_31_tfespecialidadnombre_sel = "" ;
      AV126Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      AV97Disponibilidadwwds_1_filterfulltext = "" ;
      H001S3_A298DisponibilidadTipoCita = new String[] {""} ;
      H001S3_A139DisponibilidadEstadoCita = new String[] {""} ;
      H001S3_A136DisponibilidadEstado = new String[] {""} ;
      H001S3_A137DisponibilidadUser = new int[1] ;
      H001S3_A71EspecialidadNombre = new String[] {""} ;
      H001S3_A140EspecialidadCodigo = new String[] {""} ;
      H001S3_A32EspecialidadId = new short[1] ;
      H001S3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H001S3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      H001S3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H001S3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      H001S3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H001S3_n67DisponibilidadFecha = new boolean[] {false} ;
      H001S3_A88ProfesionalCOP = new String[] {""} ;
      H001S3_A83ProfesionalNombreCompleto = new String[] {""} ;
      H001S3_A31ProfesionalId = new int[1] ;
      H001S3_A134DisponibilidadDescription = new String[] {""} ;
      H001S3_A133EventId = new String[] {""} ;
      H001S3_A34DisponibilidadId = new int[1] ;
      H001S3_A138DCitaId = new int[1] ;
      H001S3_n138DCitaId = new boolean[] {false} ;
      H001S3_A84ProfesionalNombres = new String[] {""} ;
      H001S3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H001S3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H001S5_AGRID_nRecordCount = new long[1] ;
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
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
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
      GXv_SdtWWPGridState34 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadww__default(),
         new Object[] {
             new Object[] {
            H001S3_A298DisponibilidadTipoCita, H001S3_A139DisponibilidadEstadoCita, H001S3_A136DisponibilidadEstado, H001S3_A137DisponibilidadUser, H001S3_A71EspecialidadNombre, H001S3_A140EspecialidadCodigo, H001S3_A32EspecialidadId, H001S3_A135DisponibilidadHoraFin, H001S3_n135DisponibilidadHoraFin, H001S3_A69DisponibilidadHoraInicio,
            H001S3_n69DisponibilidadHoraInicio, H001S3_A67DisponibilidadFecha, H001S3_n67DisponibilidadFecha, H001S3_A88ProfesionalCOP, H001S3_A83ProfesionalNombreCompleto, H001S3_A31ProfesionalId, H001S3_A134DisponibilidadDescription, H001S3_A133EventId, H001S3_A34DisponibilidadId, H001S3_A138DCitaId,
            H001S3_n138DCitaId, H001S3_A84ProfesionalNombres, H001S3_A85ProfesionalApellidoPaterno, H001S3_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            H001S5_AGRID_nRecordCount
            }
         }
      );
      AV135Pgmname = "DisponibilidadWW" ;
      /* GeneXus formulas. */
      AV135Pgmname = "DisponibilidadWW" ;
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
   private short AV57TFEspecialidadId ;
   private short AV58TFEspecialidadId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A32EspecialidadId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV122Disponibilidadwwds_26_tfespecialidadid ;
   private short AV123Disponibilidadwwds_27_tfespecialidadid_to ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV27TFDisponibilidadId ;
   private int AV28TFDisponibilidadId_To ;
   private int AV33TFProfesionalId ;
   private int AV34TFProfesionalId_To ;
   private int AV71TFDisponibilidadUser ;
   private int AV72TFDisponibilidadUser_To ;
   private int AV77TFDCitaId ;
   private int AV78TFDCitaId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtDisponibilidadId_Visible ;
   private int edtEventId_Visible ;
   private int edtDisponibilidadDescription_Visible ;
   private int edtProfesionalId_Visible ;
   private int edtProfesionalApellidoPaterno_Visible ;
   private int edtProfesionalApellidoMaterno_Visible ;
   private int edtProfesionalNombres_Visible ;
   private int edtProfesionalNombreCompleto_Visible ;
   private int edtProfesionalCOP_Visible ;
   private int edtDisponibilidadFecha_Visible ;
   private int edtDisponibilidadHoraInicio_Visible ;
   private int edtDisponibilidadHoraFin_Visible ;
   private int edtEspecialidadId_Visible ;
   private int edtEspecialidadCodigo_Visible ;
   private int edtEspecialidadNombre_Visible ;
   private int edtDisponibilidadUser_Visible ;
   private int edtDCitaId_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
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
   private int AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ;
   private int AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ;
   private int AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ;
   private int AV98Disponibilidadwwds_2_tfdisponibilidadid ;
   private int AV99Disponibilidadwwds_3_tfdisponibilidadid_to ;
   private int AV104Disponibilidadwwds_8_tfprofesionalid ;
   private int AV105Disponibilidadwwds_9_tfprofesionalid_to ;
   private int AV128Disponibilidadwwds_32_tfdisponibilidaduser ;
   private int AV129Disponibilidadwwds_33_tfdisponibilidaduser_to ;
   private int AV132Disponibilidadwwds_36_tfdcitaid ;
   private int AV133Disponibilidadwwds_37_tfdcitaid_to ;
   private int AV80PageToGo ;
   private int AV136GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV81GridCurrentPage ;
   private long AV82GridPageCount ;
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
   private String AV29TFEventId ;
   private String AV30TFEventId_Sel ;
   private String AV135Pgmname ;
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
   private String AV83Update ;
   private String edtavUpdate_Link ;
   private String AV85Delete ;
   private String edtavDelete_Link ;
   private String A133EventId ;
   private String edtEspecialidadNombre_Link ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_disponibilidadfechaauxdates_Internalname ;
   private String edtavDdo_disponibilidadfechaauxdatetext_Internalname ;
   private String edtavDdo_disponibilidadfechaauxdatetext_Jsonclick ;
   private String Tfdisponibilidadfecha_rangepicker_Internalname ;
   private String divDdo_disponibilidadhorainicioauxdates_Internalname ;
   private String edtavDdo_disponibilidadhorainicioauxdatetext_Internalname ;
   private String edtavDdo_disponibilidadhorainicioauxdatetext_Jsonclick ;
   private String Tfdisponibilidadhorainicio_rangepicker_Internalname ;
   private String divDdo_disponibilidadhorafinauxdates_Internalname ;
   private String edtavDdo_disponibilidadhorafinauxdatetext_Internalname ;
   private String edtavDdo_disponibilidadhorafinauxdatetext_Jsonclick ;
   private String Tfdisponibilidadhorafin_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
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
   private String lV100Disponibilidadwwds_4_tfeventid ;
   private String AV101Disponibilidadwwds_5_tfeventid_sel ;
   private String AV100Disponibilidadwwds_4_tfeventid ;
   private String GXt_char6 ;
   private String GXv_char8[] ;
   private String GXt_char13 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
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
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
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
   private java.util.Date AV49TFDisponibilidadHoraInicio ;
   private java.util.Date AV50TFDisponibilidadHoraInicio_To ;
   private java.util.Date AV53TFDisponibilidadHoraFin ;
   private java.util.Date AV54TFDisponibilidadHoraFin_To ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio ;
   private java.util.Date AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ;
   private java.util.Date AV120Disponibilidadwwds_24_tfdisponibilidadhorafin ;
   private java.util.Date AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to ;
   private java.util.Date AV45TFDisponibilidadFecha ;
   private java.util.Date AV46TFDisponibilidadFecha_To ;
   private java.util.Date AV48DDO_DisponibilidadFechaAuxDateTo ;
   private java.util.Date AV52DDO_DisponibilidadHoraInicioAuxDateTo ;
   private java.util.Date AV56DDO_DisponibilidadHoraFinAuxDateTo ;
   private java.util.Date AV47DDO_DisponibilidadFechaAuxDate ;
   private java.util.Date AV51DDO_DisponibilidadHoraInicioAuxDate ;
   private java.util.Date AV55DDO_DisponibilidadHoraFinAuxDate ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV116Disponibilidadwwds_20_tfdisponibilidadfecha ;
   private java.util.Date AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV84IsAuthorized_Update ;
   private boolean AV86IsAuthorized_Delete ;
   private boolean AV91IsAuthorized_EspecialidadNombre ;
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
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n138DCitaId ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV87TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV73TFDisponibilidadEstado_SelsJson ;
   private String AV75TFDisponibilidadEstadoCita_SelsJson ;
   private String AV88TFDisponibilidadTipoCita_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV31TFDisponibilidadDescription ;
   private String AV32TFDisponibilidadDescription_Sel ;
   private String AV35TFProfesionalApellidoPaterno ;
   private String AV36TFProfesionalApellidoPaterno_Sel ;
   private String AV37TFProfesionalApellidoMaterno ;
   private String AV38TFProfesionalApellidoMaterno_Sel ;
   private String AV39TFProfesionalNombres ;
   private String AV40TFProfesionalNombres_Sel ;
   private String AV41TFProfesionalNombreCompleto ;
   private String AV42TFProfesionalNombreCompleto_Sel ;
   private String AV43TFProfesionalCOP ;
   private String AV44TFProfesionalCOP_Sel ;
   private String AV59TFEspecialidadCodigo ;
   private String AV60TFEspecialidadCodigo_Sel ;
   private String AV61TFEspecialidadNombre ;
   private String AV62TFEspecialidadNombre_Sel ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A139DisponibilidadEstadoCita ;
   private String AV92DDO_DisponibilidadFechaAuxDateText ;
   private String AV93DDO_DisponibilidadHoraInicioAuxDateText ;
   private String AV94DDO_DisponibilidadHoraFinAuxDateText ;
   private String lV97Disponibilidadwwds_1_filterfulltext ;
   private String lV102Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String lV106Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String lV108Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String lV110Disponibilidadwwds_14_tfprofesionalnombres ;
   private String lV112Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String lV114Disponibilidadwwds_18_tfprofesionalcop ;
   private String lV124Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String lV126Disponibilidadwwds_30_tfespecialidadnombre ;
   private String AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel ;
   private String AV102Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ;
   private String AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ;
   private String AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String AV111Disponibilidadwwds_15_tfprofesionalnombres_sel ;
   private String AV110Disponibilidadwwds_14_tfprofesionalnombres ;
   private String AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ;
   private String AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String AV115Disponibilidadwwds_19_tfprofesionalcop_sel ;
   private String AV114Disponibilidadwwds_18_tfprofesionalcop ;
   private String AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel ;
   private String AV124Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String AV127Disponibilidadwwds_31_tfespecialidadnombre_sel ;
   private String AV126Disponibilidadwwds_30_tfespecialidadnombre ;
   private String AV97Disponibilidadwwds_1_filterfulltext ;
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
   private com.genexus.webpanels.GXUserControl ucTfdisponibilidadfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfdisponibilidadhorainicio_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfdisponibilidadhorafin_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels ;
   private GXSimpleCollection<String> AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ;
   private GXSimpleCollection<String> AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ;
   private HTMLChoice cmbDisponibilidadEstado ;
   private HTMLChoice cmbDisponibilidadEstadoCita ;
   private HTMLChoice cmbDisponibilidadTipoCita ;
   private IDataStoreProvider pr_default ;
   private String[] H001S3_A298DisponibilidadTipoCita ;
   private String[] H001S3_A139DisponibilidadEstadoCita ;
   private String[] H001S3_A136DisponibilidadEstado ;
   private int[] H001S3_A137DisponibilidadUser ;
   private String[] H001S3_A71EspecialidadNombre ;
   private String[] H001S3_A140EspecialidadCodigo ;
   private short[] H001S3_A32EspecialidadId ;
   private java.util.Date[] H001S3_A135DisponibilidadHoraFin ;
   private boolean[] H001S3_n135DisponibilidadHoraFin ;
   private java.util.Date[] H001S3_A69DisponibilidadHoraInicio ;
   private boolean[] H001S3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] H001S3_A67DisponibilidadFecha ;
   private boolean[] H001S3_n67DisponibilidadFecha ;
   private String[] H001S3_A88ProfesionalCOP ;
   private String[] H001S3_A83ProfesionalNombreCompleto ;
   private int[] H001S3_A31ProfesionalId ;
   private String[] H001S3_A134DisponibilidadDescription ;
   private String[] H001S3_A133EventId ;
   private int[] H001S3_A34DisponibilidadId ;
   private int[] H001S3_A138DCitaId ;
   private boolean[] H001S3_n138DCitaId ;
   private String[] H001S3_A84ProfesionalNombres ;
   private String[] H001S3_A85ProfesionalApellidoPaterno ;
   private String[] H001S3_A86ProfesionalApellidoMaterno ;
   private long[] H001S5_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV74TFDisponibilidadEstado_Sels ;
   private GXSimpleCollection<String> AV89TFDisponibilidadTipoCita_Sels ;
   private GXSimpleCollection<String> AV76TFDisponibilidadEstadoCita_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState34[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV79DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class disponibilidadww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001S3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV98Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV99Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV101Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV100Disponibilidadwwds_4_tfeventid ,
                                          String AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV102Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV104Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV105Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV111Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV110Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV115Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV114Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV116Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV120Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV122Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV123Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV124Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV127Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV126Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV128Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV129Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV97Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV132Disponibilidadwwds_36_tfdcitaid ,
                                          int AV133Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int35 = new byte[62];
      Object[] GXv_Object36 = new Object[2];
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
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV98Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int35[27] = (byte)(1) ;
      }
      if ( ! (0==AV99Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int35[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV101Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int35[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV101Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int35[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV102Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int35[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int35[32] = (byte)(1) ;
      }
      if ( ! (0==AV104Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int35[33] = (byte)(1) ;
      }
      if ( ! (0==AV105Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int35[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int35[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int35[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int35[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int35[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int35[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int35[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int35[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int35[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV114Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int35[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int35[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int35[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int35[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int35[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int35[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV120Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int35[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int35[50] = (byte)(1) ;
      }
      if ( ! (0==AV122Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int35[51] = (byte)(1) ;
      }
      if ( ! (0==AV123Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int35[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV124Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int35[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int35[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV126Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int35[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int35[56] = (byte)(1) ;
      }
      if ( ! (0==AV128Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int35[57] = (byte)(1) ;
      }
      if ( ! (0==AV129Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int35[58] = (byte)(1) ;
      }
      if ( AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EventId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EventId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadDescription]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadDescription] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalNombres]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadFecha]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EspecialidadId]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EspecialidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[EspecialidadCodigo]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[EspecialidadCodigo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[EspecialidadNombre]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadUser]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadUser] DESC" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstado]" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstado] DESC" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstadoCita]" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadEstadoCita] DESC" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadTipoCita]" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadTipoCita] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object36[0] = scmdbuf ;
      GXv_Object36[1] = GXv_int35 ;
      return GXv_Object36 ;
   }

   protected Object[] conditional_H001S5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV98Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV99Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV101Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV100Disponibilidadwwds_4_tfeventid ,
                                          String AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV102Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV104Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV105Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV111Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV110Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV115Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV114Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV116Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV120Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV122Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV123Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV124Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV127Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV126Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV128Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV129Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV97Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV132Disponibilidadwwds_36_tfdcitaid ,
                                          int AV133Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int38 = new byte[59];
      Object[] GXv_Object39 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad] T3 ON T3.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T2 ON T2.[ProfesionalId]" ;
      scmdbuf += " = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId]" ;
      scmdbuf += " = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T2.[ProfesionalApellidoPaterno] like '%' + ?) or ( T2.[ProfesionalApellidoMaterno] like '%' + ?) or ( T2.[ProfesionalNombres] like '%' + ?) or ( T2.[ProfesionalNombres] + ' ' + T2.[ProfesionalApellidoPaterno] + ' ' + T2.[ProfesionalApellidoMaterno] like '%' + ?) or ( T2.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T3.[EspecialidadCodigo] like '%' + ?) or ( T3.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV98Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int38[27] = (byte)(1) ;
      }
      if ( ! (0==AV99Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int38[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV101Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int38[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV101Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int38[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV102Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int38[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int38[32] = (byte)(1) ;
      }
      if ( ! (0==AV104Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int38[33] = (byte)(1) ;
      }
      if ( ! (0==AV105Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int38[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV106Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int38[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int38[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV108Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int38[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int38[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int38[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int38[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalNombres] + ' ' + T2.[ProfesionalApellidoPaterno] + ' ' + T2.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int38[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalNombres] + ' ' + T2.[ProfesionalApellidoPaterno] + ' ' + T2.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int38[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV114Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int38[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int38[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int38[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV117Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int38[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV118Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int38[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV119Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int38[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV120Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int38[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV121Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int38[50] = (byte)(1) ;
      }
      if ( ! (0==AV122Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int38[51] = (byte)(1) ;
      }
      if ( ! (0==AV123Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int38[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV124Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int38[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int38[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV126Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int38[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int38[56] = (byte)(1) ;
      }
      if ( ! (0==AV128Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int38[57] = (byte)(1) ;
      }
      if ( ! (0==AV129Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int38[58] = (byte)(1) ;
      }
      if ( AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV130Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV134Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object39[0] = scmdbuf ;
      GXv_Object39[1] = GXv_int38 ;
      return GXv_Object39 ;
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
                  return conditional_H001S3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).shortValue() , ((Boolean) dynConstraints[57]).booleanValue() , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , ((Number) dynConstraints[62]).intValue() );
            case 1 :
                  return conditional_H001S5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).shortValue() , ((Boolean) dynConstraints[57]).booleanValue() , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , ((Number) dynConstraints[62]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001S3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001S5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[88]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[89]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[90]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[91], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[92], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[95]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[107]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[108]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[110], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[111], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[112], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[113]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[114]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[119]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[120]).intValue());
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[121]).intValue());
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[122]).intValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[123]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
      }
   }

}

