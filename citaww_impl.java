package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citaww_impl extends GXDataArea
{
   public citaww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citaww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citaww_impl.class ));
   }

   public citaww_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbCitaTipoDiagnostico = new HTMLChoice();
      cmbCitaEstadoCita = new HTMLChoice();
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
            AV27TFCitaId = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId"))) ;
            AV28TFCitaId_To = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId_To"))) ;
            AV29TFCitaCode = httpContext.GetPar( "TFCitaCode") ;
            AV30TFCitaCode_Sel = httpContext.GetPar( "TFCitaCode_Sel") ;
            AV31TFPacienteId = (int)(GXutil.lval( httpContext.GetPar( "TFPacienteId"))) ;
            AV32TFPacienteId_To = (int)(GXutil.lval( httpContext.GetPar( "TFPacienteId_To"))) ;
            AV33TFPacienteApellidoPaterno = httpContext.GetPar( "TFPacienteApellidoPaterno") ;
            AV34TFPacienteApellidoPaterno_Sel = httpContext.GetPar( "TFPacienteApellidoPaterno_Sel") ;
            AV35TFPacienteApellidoMaterno = httpContext.GetPar( "TFPacienteApellidoMaterno") ;
            AV36TFPacienteApellidoMaterno_Sel = httpContext.GetPar( "TFPacienteApellidoMaterno_Sel") ;
            AV37TFPacienteNombres = httpContext.GetPar( "TFPacienteNombres") ;
            AV38TFPacienteNombres_Sel = httpContext.GetPar( "TFPacienteNombres_Sel") ;
            AV39TFPacienteNroDocumento = httpContext.GetPar( "TFPacienteNroDocumento") ;
            AV40TFPacienteNroDocumento_Sel = httpContext.GetPar( "TFPacienteNroDocumento_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV109TFCitaTipoDiagnostico_Sels);
            AV49TFSGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadId"))) ;
            AV50TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadId_To"))) ;
            AV51TFSGCitaDisponibilidadFecha = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha")) ;
            AV52TFSGCitaDisponibilidadFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha_To")) ;
            AV56TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraInicio"))) ;
            AV57TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraInicio_To"))) ;
            AV110TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraFin"))) ;
            AV111TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraFin_To"))) ;
            AV61TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadId"))) ;
            AV62TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadId_To"))) ;
            AV63TFSGCitaDisponibilidadEspecialidadNombre = httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadNombre") ;
            AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadNombre_Sel") ;
            AV65TFSGCitaDisponibilidadSedeId = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadSedeId"))) ;
            AV66TFSGCitaDisponibilidadSedeId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadSedeId_To"))) ;
            AV67TFSGCitaDisponibilidadSedeNombre = httpContext.GetPar( "TFSGCitaDisponibilidadSedeNombre") ;
            AV96TFSGCitaDisponibilidadSedeNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadSedeNombre_Sel") ;
            AV69TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadClinicaId"))) ;
            AV70TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadClinicaId_To"))) ;
            AV71TFSGCitaDisponibilidadClinicaNombre = httpContext.GetPar( "TFSGCitaDisponibilidadClinicaNombre") ;
            AV97TFSGCitaDisponibilidadClinicaNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadClinicaNombre_Sel") ;
            AV73TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadProfesionalId"))) ;
            AV74TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadProfesionalId_To"))) ;
            AV75TFSGCitaDisponibilidadProFullName = httpContext.GetPar( "TFSGCitaDisponibilidadProFullName") ;
            AV76TFSGCitaDisponibilidadProFullName_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadProFullName_Sel") ;
            AV77TFSGCitaDisponibilidadProCOP = httpContext.GetPar( "TFSGCitaDisponibilidadProCOP") ;
            AV78TFSGCitaDisponibilidadProCOP_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadProCOP_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV80TFCitaEstadoCita_Sels);
            AV81TFCitaInforme = httpContext.GetPar( "TFCitaInforme") ;
            AV82TFCitaInforme_Sel = httpContext.GetPar( "TFCitaInforme_Sel") ;
            AV99TFCitaAntecedentes = httpContext.GetPar( "TFCitaAntecedentes") ;
            AV100TFCitaAntecedentes_Sel = httpContext.GetPar( "TFCitaAntecedentes_Sel") ;
            AV101TFCitaLink = httpContext.GetPar( "TFCitaLink") ;
            AV102TFCitaLink_Sel = httpContext.GetPar( "TFCitaLink_Sel") ;
            AV166Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV88IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV89IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV93IsAuthorized_PacienteNombres = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_PacienteNombres")) ;
            AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_SGCitaDisponibilidadEspecialidadNombre")) ;
            AV98IsAuthorized_SGCitaDisponibilidadSedeNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_SGCitaDisponibilidadSedeNombre")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFCitaId, AV28TFCitaId_To, AV29TFCitaCode, AV30TFCitaCode_Sel, AV31TFPacienteId, AV32TFPacienteId_To, AV33TFPacienteApellidoPaterno, AV34TFPacienteApellidoPaterno_Sel, AV35TFPacienteApellidoMaterno, AV36TFPacienteApellidoMaterno_Sel, AV37TFPacienteNombres, AV38TFPacienteNombres_Sel, AV39TFPacienteNroDocumento, AV40TFPacienteNroDocumento_Sel, AV109TFCitaTipoDiagnostico_Sels, AV49TFSGCitaDisponibilidadId, AV50TFSGCitaDisponibilidadId_To, AV51TFSGCitaDisponibilidadFecha, AV52TFSGCitaDisponibilidadFecha_To, AV56TFSGCitaDisponibilidadHoraInicio, AV57TFSGCitaDisponibilidadHoraInicio_To, AV110TFSGCitaDisponibilidadHoraFin, AV111TFSGCitaDisponibilidadHoraFin_To, AV61TFSGCitaDisponibilidadEspecialidadId, AV62TFSGCitaDisponibilidadEspecialidadId_To, AV63TFSGCitaDisponibilidadEspecialidadNombre, AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV65TFSGCitaDisponibilidadSedeId, AV66TFSGCitaDisponibilidadSedeId_To, AV67TFSGCitaDisponibilidadSedeNombre, AV96TFSGCitaDisponibilidadSedeNombre_Sel, AV69TFSGCitaDisponibilidadClinicaId, AV70TFSGCitaDisponibilidadClinicaId_To, AV71TFSGCitaDisponibilidadClinicaNombre, AV97TFSGCitaDisponibilidadClinicaNombre_Sel, AV73TFSGCitaDisponibilidadProfesionalId, AV74TFSGCitaDisponibilidadProfesionalId_To, AV75TFSGCitaDisponibilidadProFullName, AV76TFSGCitaDisponibilidadProFullName_Sel, AV77TFSGCitaDisponibilidadProCOP, AV78TFSGCitaDisponibilidadProCOP_Sel, AV80TFCitaEstadoCita_Sels, AV81TFCitaInforme, AV82TFCitaInforme_Sel, AV99TFCitaAntecedentes, AV100TFCitaAntecedentes_Sel, AV101TFCitaLink, AV102TFCitaLink_Sel, AV166Pgmname, AV13OrderedBy, AV14OrderedDsc, AV88IsAuthorized_Update, AV89IsAuthorized_Delete, AV93IsAuthorized_PacienteNombres, AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre, AV98IsAuthorized_SGCitaDisponibilidadSedeNombre) ;
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
      pa1H2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1H2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110332223", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.citaww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV166Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV88IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV89IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV93IsAuthorized_PacienteNombres));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE", getSecureSignedToken( "", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE", getSecureSignedToken( "", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV85GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV86GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV83DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV83DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO", localUtil.dtoc( AV54DDO_SGCitaDisponibilidadFechaAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO", localUtil.dtoc( AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO", localUtil.dtoc( AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID", GXutil.ltrim( localUtil.ntoc( AV27TFCitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFCitaId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITACODE", AV29TFCitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITACODE_SEL", AV30TFCitaCode_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV31TFPacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEID_TO", GXutil.ltrim( localUtil.ntoc( AV32TFPacienteId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO", AV33TFPacienteApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO_SEL", AV34TFPacienteApellidoPaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO", AV35TFPacienteApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO_SEL", AV36TFPacienteApellidoMaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES", AV37TFPacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES_SEL", AV38TFPacienteNombres_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENRODOCUMENTO", AV39TFPacienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENRODOCUMENTO_SEL", AV40TFPacienteNroDocumento_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCITATIPODIAGNOSTICO_SELS", AV109TFCitaTipoDiagnostico_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCITATIPODIAGNOSTICO_SELS", AV109TFCitaTipoDiagnostico_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV49TFSGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV50TFSGCitaDisponibilidadId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA", localUtil.dtoc( AV51TFSGCitaDisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA_TO", localUtil.dtoc( AV52TFSGCitaDisponibilidadFecha_To, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAINICIO", localUtil.ttoc( AV56TFSGCitaDisponibilidadHoraInicio, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAINICIO_TO", localUtil.ttoc( AV57TFSGCitaDisponibilidadHoraInicio_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAFIN", localUtil.ttoc( AV110TFSGCitaDisponibilidadHoraFin, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAFIN_TO", localUtil.ttoc( AV111TFSGCitaDisponibilidadHoraFin_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV61TFSGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV62TFSGCitaDisponibilidadEspecialidadId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE", AV63TFSGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL", AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADSEDEID", GXutil.ltrim( localUtil.ntoc( AV65TFSGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADSEDEID_TO", GXutil.ltrim( localUtil.ntoc( AV66TFSGCitaDisponibilidadSedeId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADSEDENOMBRE", AV67TFSGCitaDisponibilidadSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL", AV96TFSGCitaDisponibilidadSedeNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICAID", GXutil.ltrim( localUtil.ntoc( AV69TFSGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICAID_TO", GXutil.ltrim( localUtil.ntoc( AV70TFSGCitaDisponibilidadClinicaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICANOMBRE", AV71TFSGCitaDisponibilidadClinicaNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL", AV97TFSGCitaDisponibilidadClinicaNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV73TFSGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFESIONALID_TO", GXutil.ltrim( localUtil.ntoc( AV74TFSGCitaDisponibilidadProfesionalId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFULLNAME", AV75TFSGCitaDisponibilidadProFullName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFULLNAME_SEL", AV76TFSGCitaDisponibilidadProFullName_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROCOP", AV77TFSGCitaDisponibilidadProCOP);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROCOP_SEL", AV78TFSGCitaDisponibilidadProCOP_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCITAESTADOCITA_SELS", AV80TFCitaEstadoCita_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCITAESTADOCITA_SELS", AV80TFCitaEstadoCita_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAINFORME", AV81TFCitaInforme);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAINFORME_SEL", AV82TFCitaInforme_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAANTECEDENTES", AV99TFCitaAntecedentes);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAANTECEDENTES_SEL", AV100TFCitaAntecedentes_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITALINK", AV101TFCitaLink);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITALINK_SEL", AV102TFCitaLink_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV166Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV166Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV88IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV88IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV89IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV89IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PACIENTENOMBRES", AV93IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV93IsAuthorized_PacienteNombres));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE", getSecureSignedToken( "", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE", getSecureSignedToken( "", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITATIPODIAGNOSTICO_SELSJSON", AV108TFCitaTipoDiagnostico_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAESTADOCITA_SELSJSON", AV79TFCitaEstadoCita_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE", localUtil.dtoc( AV53DDO_SGCitaDisponibilidadFechaAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE", localUtil.dtoc( AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE", localUtil.dtoc( AV112DDO_SGCitaDisponibilidadHoraFinAuxDate, 0, "/"));
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
         we1H2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1H2( ) ;
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
      return formatLink("com.projectthani.citaww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "CitaWW" ;
   }

   public String getPgmdesc( )
   {
      return " Cita" ;
   }

   public void wb1H0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_1H2( true) ;
      }
      else
      {
         wb_table1_25_1H2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_1H2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteApellidoPaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteApellidoMaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteNombres_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteNroDocumento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbCitaTipoDiagnostico.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Diagnostico") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Disponibilidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Disponibilidad Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadHoraInicio_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Hora Inicio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadHoraFin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Hora Fin") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadEspecialidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadEspecialidadNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadSedeId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Sede Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadSedeNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Sede Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadClinicaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Clinica Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadClinicaNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Clinica Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadProfesionalId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadProFullName_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Full Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadProCOP_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Pro COP") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbCitaEstadoCita.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaInforme_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Informe") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaAntecedentes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Antecedentes") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaLink_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Link") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV91Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV92Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A103PacienteApellidoPaterno);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteApellidoPaterno_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A104PacienteApellidoMaterno);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteApellidoMaterno_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A105PacienteNombres);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPacienteNombres_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteNombres_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A106PacienteNroDocumento);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteNroDocumento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A65CitaTipoDiagnostico);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbCitaTipoDiagnostico.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadFecha_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadHoraInicio_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadHoraFin_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadEspecialidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A146SGCitaDisponibilidadEspecialidadNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSGCitaDisponibilidadEspecialidadNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadEspecialidadNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadSedeId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A73SGCitaDisponibilidadSedeNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSGCitaDisponibilidadSedeNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadSedeNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadClinicaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A78SGCitaDisponibilidadClinicaNombre);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadClinicaNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadProfesionalId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A82SGCitaDisponibilidadProFullName);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadProFullName_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A87SGCitaDisponibilidadProCOP);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadProCOP_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A89CitaEstadoCita));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbCitaEstadoCita.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A90CitaInforme);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaInforme_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A100CitaAntecedentes);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaAntecedentes_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A91CitaLink);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCitaLink_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtCitaLink_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaLink_Visible, (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV85GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV86GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV83DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV83DDO_TitleSettingsIcons);
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname, AV55DDO_SGCitaDisponibilidadFechaAuxDateText, GXutil.rtrim( localUtil.format( AV55DDO_SGCitaDisponibilidadFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaWW.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("Start Date", AV53DDO_SGCitaDisponibilidadFechaAuxDate);
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("End Date", AV54DDO_SGCitaDisponibilidadFechaAuxDateTo);
         ucTfsgcitadisponibilidadfecha_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadfecha_rangepicker_Internalname, "TFSGCITADISPONIBILIDADFECHA_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadhorainicioauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname, AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText, GXutil.rtrim( localUtil.format( AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaWW.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadhorainicio_rangepicker.setProperty("Start Date", AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate);
         ucTfsgcitadisponibilidadhorainicio_rangepicker.setProperty("End Date", AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo);
         ucTfsgcitadisponibilidadhorainicio_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadhorainicio_rangepicker_Internalname, "TFSGCITADISPONIBILIDADHORAINICIO_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadhorafinauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname, AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText, GXutil.rtrim( localUtil.format( AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaWW.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadhorafin_rangepicker.setProperty("Start Date", AV112DDO_SGCitaDisponibilidadHoraFinAuxDate);
         ucTfsgcitadisponibilidadhorafin_rangepicker.setProperty("End Date", AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo);
         ucTfsgcitadisponibilidadhorafin_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadhorafin_rangepicker_Internalname, "TFSGCITADISPONIBILIDADHORAFIN_RANGEPICKERContainer");
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

   public void start1H2( )
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
         Form.getMeta().addItem("description", " Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1H0( ) ;
   }

   public void ws1H2( )
   {
      start1H2( ) ;
      evt1H2( ) ;
   }

   public void evt1H2( )
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
                           e111H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e161H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e171H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e181H2 ();
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
                           AV91Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV91Update);
                           AV92Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV92Delete);
                           A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
                           A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
                           A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
                           A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
                           A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
                           A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
                           A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
                           cmbCitaTipoDiagnostico.setName( cmbCitaTipoDiagnostico.getInternalname() );
                           cmbCitaTipoDiagnostico.setValue( httpContext.cgiGet( cmbCitaTipoDiagnostico.getInternalname()) );
                           A65CitaTipoDiagnostico = httpContext.cgiGet( cmbCitaTipoDiagnostico.getInternalname()) ;
                           n65CitaTipoDiagnostico = false ;
                           A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
                           A66SGCitaDisponibilidadFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 0)) ;
                           n66SGCitaDisponibilidadFecha = false ;
                           A68SGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraInicio_Internalname), 0)) ;
                           n68SGCitaDisponibilidadHoraInicio = false ;
                           A387SGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraFin_Internalname), 0)) ;
                           n387SGCitaDisponibilidadHoraFin = false ;
                           A70SGCitaDisponibilidadEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadId_Internalname), ",", ".")) ;
                           A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
                           A72SGCitaDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadSedeId_Internalname), ",", ".")) ;
                           A73SGCitaDisponibilidadSedeNombre = httpContext.cgiGet( edtSGCitaDisponibilidadSedeNombre_Internalname) ;
                           A76SGCitaDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadClinicaId_Internalname), ",", ".")) ;
                           A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
                           A81SGCitaDisponibilidadProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadProfesionalId_Internalname), ",", ".")) ;
                           A82SGCitaDisponibilidadProFullName = httpContext.cgiGet( edtSGCitaDisponibilidadProFullName_Internalname) ;
                           A87SGCitaDisponibilidadProCOP = httpContext.cgiGet( edtSGCitaDisponibilidadProCOP_Internalname) ;
                           cmbCitaEstadoCita.setName( cmbCitaEstadoCita.getInternalname() );
                           cmbCitaEstadoCita.setValue( httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) );
                           A89CitaEstadoCita = httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) ;
                           n89CitaEstadoCita = false ;
                           A90CitaInforme = httpContext.cgiGet( edtCitaInforme_Internalname) ;
                           n90CitaInforme = false ;
                           A100CitaAntecedentes = httpContext.cgiGet( edtCitaAntecedentes_Internalname) ;
                           n100CitaAntecedentes = false ;
                           A91CitaLink = httpContext.cgiGet( edtCitaLink_Internalname) ;
                           n91CitaLink = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e191H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e201H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e211H2 ();
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

   public void we1H2( )
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

   public void pa1H2( )
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
                                 int AV27TFCitaId ,
                                 int AV28TFCitaId_To ,
                                 String AV29TFCitaCode ,
                                 String AV30TFCitaCode_Sel ,
                                 int AV31TFPacienteId ,
                                 int AV32TFPacienteId_To ,
                                 String AV33TFPacienteApellidoPaterno ,
                                 String AV34TFPacienteApellidoPaterno_Sel ,
                                 String AV35TFPacienteApellidoMaterno ,
                                 String AV36TFPacienteApellidoMaterno_Sel ,
                                 String AV37TFPacienteNombres ,
                                 String AV38TFPacienteNombres_Sel ,
                                 String AV39TFPacienteNroDocumento ,
                                 String AV40TFPacienteNroDocumento_Sel ,
                                 GXSimpleCollection<String> AV109TFCitaTipoDiagnostico_Sels ,
                                 int AV49TFSGCitaDisponibilidadId ,
                                 int AV50TFSGCitaDisponibilidadId_To ,
                                 java.util.Date AV51TFSGCitaDisponibilidadFecha ,
                                 java.util.Date AV52TFSGCitaDisponibilidadFecha_To ,
                                 java.util.Date AV56TFSGCitaDisponibilidadHoraInicio ,
                                 java.util.Date AV57TFSGCitaDisponibilidadHoraInicio_To ,
                                 java.util.Date AV110TFSGCitaDisponibilidadHoraFin ,
                                 java.util.Date AV111TFSGCitaDisponibilidadHoraFin_To ,
                                 short AV61TFSGCitaDisponibilidadEspecialidadId ,
                                 short AV62TFSGCitaDisponibilidadEspecialidadId_To ,
                                 String AV63TFSGCitaDisponibilidadEspecialidadNombre ,
                                 String AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ,
                                 short AV65TFSGCitaDisponibilidadSedeId ,
                                 short AV66TFSGCitaDisponibilidadSedeId_To ,
                                 String AV67TFSGCitaDisponibilidadSedeNombre ,
                                 String AV96TFSGCitaDisponibilidadSedeNombre_Sel ,
                                 short AV69TFSGCitaDisponibilidadClinicaId ,
                                 short AV70TFSGCitaDisponibilidadClinicaId_To ,
                                 String AV71TFSGCitaDisponibilidadClinicaNombre ,
                                 String AV97TFSGCitaDisponibilidadClinicaNombre_Sel ,
                                 int AV73TFSGCitaDisponibilidadProfesionalId ,
                                 int AV74TFSGCitaDisponibilidadProfesionalId_To ,
                                 String AV75TFSGCitaDisponibilidadProFullName ,
                                 String AV76TFSGCitaDisponibilidadProFullName_Sel ,
                                 String AV77TFSGCitaDisponibilidadProCOP ,
                                 String AV78TFSGCitaDisponibilidadProCOP_Sel ,
                                 GXSimpleCollection<String> AV80TFCitaEstadoCita_Sels ,
                                 String AV81TFCitaInforme ,
                                 String AV82TFCitaInforme_Sel ,
                                 String AV99TFCitaAntecedentes ,
                                 String AV100TFCitaAntecedentes_Sel ,
                                 String AV101TFCitaLink ,
                                 String AV102TFCitaLink_Sel ,
                                 String AV166Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV88IsAuthorized_Update ,
                                 boolean AV89IsAuthorized_Delete ,
                                 boolean AV93IsAuthorized_PacienteNombres ,
                                 boolean AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre ,
                                 boolean AV98IsAuthorized_SGCitaDisponibilidadSedeNombre )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e201H2 ();
      GRID_nCurrentRecord = 0 ;
      rf1H2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_CITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CITAID", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
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
      rf1H2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV166Pgmname = "CitaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf1H2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e201H2 ();
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
                                              A65CitaTipoDiagnostico ,
                                              AV132Citawwds_16_tfcitatipodiagnostico_sels ,
                                              A89CitaEstadoCita ,
                                              AV159Citawwds_43_tfcitaestadocita_sels ,
                                              AV117Citawwds_1_filterfulltext ,
                                              Integer.valueOf(AV118Citawwds_2_tfcitaid) ,
                                              Integer.valueOf(AV119Citawwds_3_tfcitaid_to) ,
                                              AV121Citawwds_5_tfcitacode_sel ,
                                              AV120Citawwds_4_tfcitacode ,
                                              Integer.valueOf(AV122Citawwds_6_tfpacienteid) ,
                                              Integer.valueOf(AV123Citawwds_7_tfpacienteid_to) ,
                                              AV125Citawwds_9_tfpacienteapellidopaterno_sel ,
                                              AV124Citawwds_8_tfpacienteapellidopaterno ,
                                              AV127Citawwds_11_tfpacienteapellidomaterno_sel ,
                                              AV126Citawwds_10_tfpacienteapellidomaterno ,
                                              AV129Citawwds_13_tfpacientenombres_sel ,
                                              AV128Citawwds_12_tfpacientenombres ,
                                              AV131Citawwds_15_tfpacientenrodocumento_sel ,
                                              AV130Citawwds_14_tfpacientenrodocumento ,
                                              Integer.valueOf(AV132Citawwds_16_tfcitatipodiagnostico_sels.size()) ,
                                              Integer.valueOf(AV133Citawwds_17_tfsgcitadisponibilidadid) ,
                                              Integer.valueOf(AV134Citawwds_18_tfsgcitadisponibilidadid_to) ,
                                              AV135Citawwds_19_tfsgcitadisponibilidadfecha ,
                                              AV136Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                              AV137Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                              AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                              AV139Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                              AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                              Short.valueOf(AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid) ,
                                              Short.valueOf(AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) ,
                                              AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                              AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                              Short.valueOf(AV145Citawwds_29_tfsgcitadisponibilidadsedeid) ,
                                              Short.valueOf(AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to) ,
                                              AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                              AV147Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                              Short.valueOf(AV149Citawwds_33_tfsgcitadisponibilidadclinicaid) ,
                                              Short.valueOf(AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to) ,
                                              AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                              AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                              Integer.valueOf(AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid) ,
                                              Integer.valueOf(AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) ,
                                              AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                              AV155Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                              AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                              AV157Citawwds_41_tfsgcitadisponibilidadprocop ,
                                              Integer.valueOf(AV159Citawwds_43_tfcitaestadocita_sels.size()) ,
                                              AV161Citawwds_45_tfcitainforme_sel ,
                                              AV160Citawwds_44_tfcitainforme ,
                                              AV163Citawwds_47_tfcitaantecedentes_sel ,
                                              AV162Citawwds_46_tfcitaantecedentes ,
                                              AV165Citawwds_49_tfcitalink_sel ,
                                              AV164Citawwds_48_tfcitalink ,
                                              Integer.valueOf(A19CitaId) ,
                                              A64CitaCode ,
                                              Integer.valueOf(A20PacienteId) ,
                                              A103PacienteApellidoPaterno ,
                                              A104PacienteApellidoMaterno ,
                                              A105PacienteNombres ,
                                              A106PacienteNroDocumento ,
                                              Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                              Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                              A146SGCitaDisponibilidadEspecialidadNombre ,
                                              Short.valueOf(A72SGCitaDisponibilidadSedeId) ,
                                              A73SGCitaDisponibilidadSedeNombre ,
                                              Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                              A78SGCitaDisponibilidadClinicaNombre ,
                                              Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                              A84ProfesionalNombres ,
                                              A85ProfesionalApellidoPaterno ,
                                              A86ProfesionalApellidoMaterno ,
                                              A87SGCitaDisponibilidadProCOP ,
                                              A90CitaInforme ,
                                              A100CitaAntecedentes ,
                                              A91CitaLink ,
                                              A66SGCitaDisponibilidadFecha ,
                                              A68SGCitaDisponibilidadHoraInicio ,
                                              A387SGCitaDisponibilidadHoraFin ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                              TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
         lV120Citawwds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV120Citawwds_4_tfcitacode), "%", "") ;
         lV124Citawwds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV124Citawwds_8_tfpacienteapellidopaterno), "%", "") ;
         lV126Citawwds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV126Citawwds_10_tfpacienteapellidomaterno), "%", "") ;
         lV128Citawwds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV128Citawwds_12_tfpacientenombres), "%", "") ;
         lV130Citawwds_14_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV130Citawwds_14_tfpacientenrodocumento), "%", "") ;
         lV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
         lV147Citawwds_31_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV147Citawwds_31_tfsgcitadisponibilidadsedenombre), "%", "") ;
         lV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre), "%", "") ;
         lV155Citawwds_39_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV155Citawwds_39_tfsgcitadisponibilidadprofullname), "%", "") ;
         lV157Citawwds_41_tfsgcitadisponibilidadprocop = GXutil.concat( GXutil.rtrim( AV157Citawwds_41_tfsgcitadisponibilidadprocop), "%", "") ;
         lV160Citawwds_44_tfcitainforme = GXutil.concat( GXutil.rtrim( AV160Citawwds_44_tfcitainforme), "%", "") ;
         lV162Citawwds_46_tfcitaantecedentes = GXutil.concat( GXutil.rtrim( AV162Citawwds_46_tfcitaantecedentes), "%", "") ;
         lV164Citawwds_48_tfcitalink = GXutil.concat( GXutil.rtrim( AV164Citawwds_48_tfcitalink), "%", "") ;
         /* Using cursor H001H2 */
         pr_default.execute(0, new Object[] {lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, Integer.valueOf(AV118Citawwds_2_tfcitaid), Integer.valueOf(AV119Citawwds_3_tfcitaid_to), lV120Citawwds_4_tfcitacode, AV121Citawwds_5_tfcitacode_sel, Integer.valueOf(AV122Citawwds_6_tfpacienteid), Integer.valueOf(AV123Citawwds_7_tfpacienteid_to), lV124Citawwds_8_tfpacienteapellidopaterno, AV125Citawwds_9_tfpacienteapellidopaterno_sel, lV126Citawwds_10_tfpacienteapellidomaterno, AV127Citawwds_11_tfpacienteapellidomaterno_sel, lV128Citawwds_12_tfpacientenombres, AV129Citawwds_13_tfpacientenombres_sel, lV130Citawwds_14_tfpacientenrodocumento, AV131Citawwds_15_tfpacientenrodocumento_sel, Integer.valueOf(AV133Citawwds_17_tfsgcitadisponibilidadid), Integer.valueOf(AV134Citawwds_18_tfsgcitadisponibilidadid_to), AV135Citawwds_19_tfsgcitadisponibilidadfecha, AV136Citawwds_20_tfsgcitadisponibilidadfecha_to, AV137Citawwds_21_tfsgcitadisponibilidadhorainicio, AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to, AV139Citawwds_23_tfsgcitadisponibilidadhorafin, AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to, Short.valueOf(AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to), lV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre, AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel, Short.valueOf(AV145Citawwds_29_tfsgcitadisponibilidadsedeid), Short.valueOf(AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to), lV147Citawwds_31_tfsgcitadisponibilidadsedenombre, AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel, Short.valueOf(AV149Citawwds_33_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to), lV151Citawwds_35_tfsgcitadisponibilidadclinicanombre, AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel, Integer.valueOf(AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to), lV155Citawwds_39_tfsgcitadisponibilidadprofullname, AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel, lV157Citawwds_41_tfsgcitadisponibilidadprocop, AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel, lV160Citawwds_44_tfcitainforme, AV161Citawwds_45_tfcitainforme_sel, lV162Citawwds_46_tfcitaantecedentes, AV163Citawwds_47_tfcitaantecedentes_sel, lV164Citawwds_48_tfcitalink, AV165Citawwds_49_tfcitalink_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A91CitaLink = H001H2_A91CitaLink[0] ;
            n91CitaLink = H001H2_n91CitaLink[0] ;
            A100CitaAntecedentes = H001H2_A100CitaAntecedentes[0] ;
            n100CitaAntecedentes = H001H2_n100CitaAntecedentes[0] ;
            A90CitaInforme = H001H2_A90CitaInforme[0] ;
            n90CitaInforme = H001H2_n90CitaInforme[0] ;
            A89CitaEstadoCita = H001H2_A89CitaEstadoCita[0] ;
            n89CitaEstadoCita = H001H2_n89CitaEstadoCita[0] ;
            A87SGCitaDisponibilidadProCOP = H001H2_A87SGCitaDisponibilidadProCOP[0] ;
            A82SGCitaDisponibilidadProFullName = H001H2_A82SGCitaDisponibilidadProFullName[0] ;
            A81SGCitaDisponibilidadProfesionalId = H001H2_A81SGCitaDisponibilidadProfesionalId[0] ;
            A78SGCitaDisponibilidadClinicaNombre = H001H2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            A76SGCitaDisponibilidadClinicaId = H001H2_A76SGCitaDisponibilidadClinicaId[0] ;
            A73SGCitaDisponibilidadSedeNombre = H001H2_A73SGCitaDisponibilidadSedeNombre[0] ;
            A72SGCitaDisponibilidadSedeId = H001H2_A72SGCitaDisponibilidadSedeId[0] ;
            A146SGCitaDisponibilidadEspecialidadNombre = H001H2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            A70SGCitaDisponibilidadEspecialidadId = H001H2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A387SGCitaDisponibilidadHoraFin = H001H2_A387SGCitaDisponibilidadHoraFin[0] ;
            n387SGCitaDisponibilidadHoraFin = H001H2_n387SGCitaDisponibilidadHoraFin[0] ;
            A68SGCitaDisponibilidadHoraInicio = H001H2_A68SGCitaDisponibilidadHoraInicio[0] ;
            n68SGCitaDisponibilidadHoraInicio = H001H2_n68SGCitaDisponibilidadHoraInicio[0] ;
            A66SGCitaDisponibilidadFecha = H001H2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H001H2_n66SGCitaDisponibilidadFecha[0] ;
            A21SGCitaDisponibilidadId = H001H2_A21SGCitaDisponibilidadId[0] ;
            A65CitaTipoDiagnostico = H001H2_A65CitaTipoDiagnostico[0] ;
            n65CitaTipoDiagnostico = H001H2_n65CitaTipoDiagnostico[0] ;
            A106PacienteNroDocumento = H001H2_A106PacienteNroDocumento[0] ;
            A105PacienteNombres = H001H2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H001H2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H001H2_A103PacienteApellidoPaterno[0] ;
            A20PacienteId = H001H2_A20PacienteId[0] ;
            A64CitaCode = H001H2_A64CitaCode[0] ;
            A19CitaId = H001H2_A19CitaId[0] ;
            A84ProfesionalNombres = H001H2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H001H2_n84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H001H2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H001H2_n85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H001H2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H001H2_n86ProfesionalApellidoMaterno[0] ;
            A81SGCitaDisponibilidadProfesionalId = H001H2_A81SGCitaDisponibilidadProfesionalId[0] ;
            A72SGCitaDisponibilidadSedeId = H001H2_A72SGCitaDisponibilidadSedeId[0] ;
            A70SGCitaDisponibilidadEspecialidadId = H001H2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A387SGCitaDisponibilidadHoraFin = H001H2_A387SGCitaDisponibilidadHoraFin[0] ;
            n387SGCitaDisponibilidadHoraFin = H001H2_n387SGCitaDisponibilidadHoraFin[0] ;
            A68SGCitaDisponibilidadHoraInicio = H001H2_A68SGCitaDisponibilidadHoraInicio[0] ;
            n68SGCitaDisponibilidadHoraInicio = H001H2_n68SGCitaDisponibilidadHoraInicio[0] ;
            A66SGCitaDisponibilidadFecha = H001H2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H001H2_n66SGCitaDisponibilidadFecha[0] ;
            A87SGCitaDisponibilidadProCOP = H001H2_A87SGCitaDisponibilidadProCOP[0] ;
            A84ProfesionalNombres = H001H2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H001H2_n84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H001H2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H001H2_n85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H001H2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H001H2_n86ProfesionalApellidoMaterno[0] ;
            A76SGCitaDisponibilidadClinicaId = H001H2_A76SGCitaDisponibilidadClinicaId[0] ;
            A73SGCitaDisponibilidadSedeNombre = H001H2_A73SGCitaDisponibilidadSedeNombre[0] ;
            A78SGCitaDisponibilidadClinicaNombre = H001H2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            A146SGCitaDisponibilidadEspecialidadNombre = H001H2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            A106PacienteNroDocumento = H001H2_A106PacienteNroDocumento[0] ;
            A105PacienteNombres = H001H2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H001H2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H001H2_A103PacienteApellidoPaterno[0] ;
            e211H2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb1H0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1H2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV166Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV166Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV88IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV88IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV89IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV89IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PACIENTENOMBRES", AV93IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV93IsAuthorized_PacienteNombres));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE", getSecureSignedToken( "", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE", getSecureSignedToken( "", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_CITAID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")));
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
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A65CitaTipoDiagnostico ,
                                           AV132Citawwds_16_tfcitatipodiagnostico_sels ,
                                           A89CitaEstadoCita ,
                                           AV159Citawwds_43_tfcitaestadocita_sels ,
                                           AV117Citawwds_1_filterfulltext ,
                                           Integer.valueOf(AV118Citawwds_2_tfcitaid) ,
                                           Integer.valueOf(AV119Citawwds_3_tfcitaid_to) ,
                                           AV121Citawwds_5_tfcitacode_sel ,
                                           AV120Citawwds_4_tfcitacode ,
                                           Integer.valueOf(AV122Citawwds_6_tfpacienteid) ,
                                           Integer.valueOf(AV123Citawwds_7_tfpacienteid_to) ,
                                           AV125Citawwds_9_tfpacienteapellidopaterno_sel ,
                                           AV124Citawwds_8_tfpacienteapellidopaterno ,
                                           AV127Citawwds_11_tfpacienteapellidomaterno_sel ,
                                           AV126Citawwds_10_tfpacienteapellidomaterno ,
                                           AV129Citawwds_13_tfpacientenombres_sel ,
                                           AV128Citawwds_12_tfpacientenombres ,
                                           AV131Citawwds_15_tfpacientenrodocumento_sel ,
                                           AV130Citawwds_14_tfpacientenrodocumento ,
                                           Integer.valueOf(AV132Citawwds_16_tfcitatipodiagnostico_sels.size()) ,
                                           Integer.valueOf(AV133Citawwds_17_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV134Citawwds_18_tfsgcitadisponibilidadid_to) ,
                                           AV135Citawwds_19_tfsgcitadisponibilidadfecha ,
                                           AV136Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                           AV137Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                           AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                           AV139Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                           AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                           Short.valueOf(AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                           Short.valueOf(AV145Citawwds_29_tfsgcitadisponibilidadsedeid) ,
                                           Short.valueOf(AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to) ,
                                           AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV147Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                           Short.valueOf(AV149Citawwds_33_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                           AV155Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                           AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                           AV157Citawwds_41_tfsgcitadisponibilidadprocop ,
                                           Integer.valueOf(AV159Citawwds_43_tfcitaestadocita_sels.size()) ,
                                           AV161Citawwds_45_tfcitainforme_sel ,
                                           AV160Citawwds_44_tfcitainforme ,
                                           AV163Citawwds_47_tfcitaantecedentes_sel ,
                                           AV162Citawwds_46_tfcitaantecedentes ,
                                           AV165Citawwds_49_tfcitalink_sel ,
                                           AV164Citawwds_48_tfcitalink ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Short.valueOf(A72SGCitaDisponibilidadSedeId) ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A87SGCitaDisponibilidadProCOP ,
                                           A90CitaInforme ,
                                           A100CitaAntecedentes ,
                                           A91CitaLink ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV117Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV117Citawwds_1_filterfulltext), "%", "") ;
      lV120Citawwds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV120Citawwds_4_tfcitacode), "%", "") ;
      lV124Citawwds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV124Citawwds_8_tfpacienteapellidopaterno), "%", "") ;
      lV126Citawwds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV126Citawwds_10_tfpacienteapellidomaterno), "%", "") ;
      lV128Citawwds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV128Citawwds_12_tfpacientenombres), "%", "") ;
      lV130Citawwds_14_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV130Citawwds_14_tfpacientenrodocumento), "%", "") ;
      lV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV147Citawwds_31_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV147Citawwds_31_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV155Citawwds_39_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV155Citawwds_39_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV157Citawwds_41_tfsgcitadisponibilidadprocop = GXutil.concat( GXutil.rtrim( AV157Citawwds_41_tfsgcitadisponibilidadprocop), "%", "") ;
      lV160Citawwds_44_tfcitainforme = GXutil.concat( GXutil.rtrim( AV160Citawwds_44_tfcitainforme), "%", "") ;
      lV162Citawwds_46_tfcitaantecedentes = GXutil.concat( GXutil.rtrim( AV162Citawwds_46_tfcitaantecedentes), "%", "") ;
      lV164Citawwds_48_tfcitalink = GXutil.concat( GXutil.rtrim( AV164Citawwds_48_tfcitalink), "%", "") ;
      /* Using cursor H001H3 */
      pr_default.execute(1, new Object[] {lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, lV117Citawwds_1_filterfulltext, Integer.valueOf(AV118Citawwds_2_tfcitaid), Integer.valueOf(AV119Citawwds_3_tfcitaid_to), lV120Citawwds_4_tfcitacode, AV121Citawwds_5_tfcitacode_sel, Integer.valueOf(AV122Citawwds_6_tfpacienteid), Integer.valueOf(AV123Citawwds_7_tfpacienteid_to), lV124Citawwds_8_tfpacienteapellidopaterno, AV125Citawwds_9_tfpacienteapellidopaterno_sel, lV126Citawwds_10_tfpacienteapellidomaterno, AV127Citawwds_11_tfpacienteapellidomaterno_sel, lV128Citawwds_12_tfpacientenombres, AV129Citawwds_13_tfpacientenombres_sel, lV130Citawwds_14_tfpacientenrodocumento, AV131Citawwds_15_tfpacientenrodocumento_sel, Integer.valueOf(AV133Citawwds_17_tfsgcitadisponibilidadid), Integer.valueOf(AV134Citawwds_18_tfsgcitadisponibilidadid_to), AV135Citawwds_19_tfsgcitadisponibilidadfecha, AV136Citawwds_20_tfsgcitadisponibilidadfecha_to, AV137Citawwds_21_tfsgcitadisponibilidadhorainicio, AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to, AV139Citawwds_23_tfsgcitadisponibilidadhorafin, AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to, Short.valueOf(AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to), lV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre, AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel, Short.valueOf(AV145Citawwds_29_tfsgcitadisponibilidadsedeid), Short.valueOf(AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to), lV147Citawwds_31_tfsgcitadisponibilidadsedenombre, AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel, Short.valueOf(AV149Citawwds_33_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to), lV151Citawwds_35_tfsgcitadisponibilidadclinicanombre, AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel, Integer.valueOf(AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to), lV155Citawwds_39_tfsgcitadisponibilidadprofullname, AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel, lV157Citawwds_41_tfsgcitadisponibilidadprocop, AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel, lV160Citawwds_44_tfcitainforme, AV161Citawwds_45_tfcitainforme_sel, lV162Citawwds_46_tfcitaantecedentes, AV163Citawwds_47_tfcitaantecedentes_sel, lV164Citawwds_48_tfcitalink, AV165Citawwds_49_tfcitalink_sel});
      GRID_nRecordCount = H001H3_AGRID_nRecordCount[0] ;
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
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFCitaId, AV28TFCitaId_To, AV29TFCitaCode, AV30TFCitaCode_Sel, AV31TFPacienteId, AV32TFPacienteId_To, AV33TFPacienteApellidoPaterno, AV34TFPacienteApellidoPaterno_Sel, AV35TFPacienteApellidoMaterno, AV36TFPacienteApellidoMaterno_Sel, AV37TFPacienteNombres, AV38TFPacienteNombres_Sel, AV39TFPacienteNroDocumento, AV40TFPacienteNroDocumento_Sel, AV109TFCitaTipoDiagnostico_Sels, AV49TFSGCitaDisponibilidadId, AV50TFSGCitaDisponibilidadId_To, AV51TFSGCitaDisponibilidadFecha, AV52TFSGCitaDisponibilidadFecha_To, AV56TFSGCitaDisponibilidadHoraInicio, AV57TFSGCitaDisponibilidadHoraInicio_To, AV110TFSGCitaDisponibilidadHoraFin, AV111TFSGCitaDisponibilidadHoraFin_To, AV61TFSGCitaDisponibilidadEspecialidadId, AV62TFSGCitaDisponibilidadEspecialidadId_To, AV63TFSGCitaDisponibilidadEspecialidadNombre, AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV65TFSGCitaDisponibilidadSedeId, AV66TFSGCitaDisponibilidadSedeId_To, AV67TFSGCitaDisponibilidadSedeNombre, AV96TFSGCitaDisponibilidadSedeNombre_Sel, AV69TFSGCitaDisponibilidadClinicaId, AV70TFSGCitaDisponibilidadClinicaId_To, AV71TFSGCitaDisponibilidadClinicaNombre, AV97TFSGCitaDisponibilidadClinicaNombre_Sel, AV73TFSGCitaDisponibilidadProfesionalId, AV74TFSGCitaDisponibilidadProfesionalId_To, AV75TFSGCitaDisponibilidadProFullName, AV76TFSGCitaDisponibilidadProFullName_Sel, AV77TFSGCitaDisponibilidadProCOP, AV78TFSGCitaDisponibilidadProCOP_Sel, AV80TFCitaEstadoCita_Sels, AV81TFCitaInforme, AV82TFCitaInforme_Sel, AV99TFCitaAntecedentes, AV100TFCitaAntecedentes_Sel, AV101TFCitaLink, AV102TFCitaLink_Sel, AV166Pgmname, AV13OrderedBy, AV14OrderedDsc, AV88IsAuthorized_Update, AV89IsAuthorized_Delete, AV93IsAuthorized_PacienteNombres, AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre, AV98IsAuthorized_SGCitaDisponibilidadSedeNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFCitaId, AV28TFCitaId_To, AV29TFCitaCode, AV30TFCitaCode_Sel, AV31TFPacienteId, AV32TFPacienteId_To, AV33TFPacienteApellidoPaterno, AV34TFPacienteApellidoPaterno_Sel, AV35TFPacienteApellidoMaterno, AV36TFPacienteApellidoMaterno_Sel, AV37TFPacienteNombres, AV38TFPacienteNombres_Sel, AV39TFPacienteNroDocumento, AV40TFPacienteNroDocumento_Sel, AV109TFCitaTipoDiagnostico_Sels, AV49TFSGCitaDisponibilidadId, AV50TFSGCitaDisponibilidadId_To, AV51TFSGCitaDisponibilidadFecha, AV52TFSGCitaDisponibilidadFecha_To, AV56TFSGCitaDisponibilidadHoraInicio, AV57TFSGCitaDisponibilidadHoraInicio_To, AV110TFSGCitaDisponibilidadHoraFin, AV111TFSGCitaDisponibilidadHoraFin_To, AV61TFSGCitaDisponibilidadEspecialidadId, AV62TFSGCitaDisponibilidadEspecialidadId_To, AV63TFSGCitaDisponibilidadEspecialidadNombre, AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV65TFSGCitaDisponibilidadSedeId, AV66TFSGCitaDisponibilidadSedeId_To, AV67TFSGCitaDisponibilidadSedeNombre, AV96TFSGCitaDisponibilidadSedeNombre_Sel, AV69TFSGCitaDisponibilidadClinicaId, AV70TFSGCitaDisponibilidadClinicaId_To, AV71TFSGCitaDisponibilidadClinicaNombre, AV97TFSGCitaDisponibilidadClinicaNombre_Sel, AV73TFSGCitaDisponibilidadProfesionalId, AV74TFSGCitaDisponibilidadProfesionalId_To, AV75TFSGCitaDisponibilidadProFullName, AV76TFSGCitaDisponibilidadProFullName_Sel, AV77TFSGCitaDisponibilidadProCOP, AV78TFSGCitaDisponibilidadProCOP_Sel, AV80TFCitaEstadoCita_Sels, AV81TFCitaInforme, AV82TFCitaInforme_Sel, AV99TFCitaAntecedentes, AV100TFCitaAntecedentes_Sel, AV101TFCitaLink, AV102TFCitaLink_Sel, AV166Pgmname, AV13OrderedBy, AV14OrderedDsc, AV88IsAuthorized_Update, AV89IsAuthorized_Delete, AV93IsAuthorized_PacienteNombres, AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre, AV98IsAuthorized_SGCitaDisponibilidadSedeNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFCitaId, AV28TFCitaId_To, AV29TFCitaCode, AV30TFCitaCode_Sel, AV31TFPacienteId, AV32TFPacienteId_To, AV33TFPacienteApellidoPaterno, AV34TFPacienteApellidoPaterno_Sel, AV35TFPacienteApellidoMaterno, AV36TFPacienteApellidoMaterno_Sel, AV37TFPacienteNombres, AV38TFPacienteNombres_Sel, AV39TFPacienteNroDocumento, AV40TFPacienteNroDocumento_Sel, AV109TFCitaTipoDiagnostico_Sels, AV49TFSGCitaDisponibilidadId, AV50TFSGCitaDisponibilidadId_To, AV51TFSGCitaDisponibilidadFecha, AV52TFSGCitaDisponibilidadFecha_To, AV56TFSGCitaDisponibilidadHoraInicio, AV57TFSGCitaDisponibilidadHoraInicio_To, AV110TFSGCitaDisponibilidadHoraFin, AV111TFSGCitaDisponibilidadHoraFin_To, AV61TFSGCitaDisponibilidadEspecialidadId, AV62TFSGCitaDisponibilidadEspecialidadId_To, AV63TFSGCitaDisponibilidadEspecialidadNombre, AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV65TFSGCitaDisponibilidadSedeId, AV66TFSGCitaDisponibilidadSedeId_To, AV67TFSGCitaDisponibilidadSedeNombre, AV96TFSGCitaDisponibilidadSedeNombre_Sel, AV69TFSGCitaDisponibilidadClinicaId, AV70TFSGCitaDisponibilidadClinicaId_To, AV71TFSGCitaDisponibilidadClinicaNombre, AV97TFSGCitaDisponibilidadClinicaNombre_Sel, AV73TFSGCitaDisponibilidadProfesionalId, AV74TFSGCitaDisponibilidadProfesionalId_To, AV75TFSGCitaDisponibilidadProFullName, AV76TFSGCitaDisponibilidadProFullName_Sel, AV77TFSGCitaDisponibilidadProCOP, AV78TFSGCitaDisponibilidadProCOP_Sel, AV80TFCitaEstadoCita_Sels, AV81TFCitaInforme, AV82TFCitaInforme_Sel, AV99TFCitaAntecedentes, AV100TFCitaAntecedentes_Sel, AV101TFCitaLink, AV102TFCitaLink_Sel, AV166Pgmname, AV13OrderedBy, AV14OrderedDsc, AV88IsAuthorized_Update, AV89IsAuthorized_Delete, AV93IsAuthorized_PacienteNombres, AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre, AV98IsAuthorized_SGCitaDisponibilidadSedeNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFCitaId, AV28TFCitaId_To, AV29TFCitaCode, AV30TFCitaCode_Sel, AV31TFPacienteId, AV32TFPacienteId_To, AV33TFPacienteApellidoPaterno, AV34TFPacienteApellidoPaterno_Sel, AV35TFPacienteApellidoMaterno, AV36TFPacienteApellidoMaterno_Sel, AV37TFPacienteNombres, AV38TFPacienteNombres_Sel, AV39TFPacienteNroDocumento, AV40TFPacienteNroDocumento_Sel, AV109TFCitaTipoDiagnostico_Sels, AV49TFSGCitaDisponibilidadId, AV50TFSGCitaDisponibilidadId_To, AV51TFSGCitaDisponibilidadFecha, AV52TFSGCitaDisponibilidadFecha_To, AV56TFSGCitaDisponibilidadHoraInicio, AV57TFSGCitaDisponibilidadHoraInicio_To, AV110TFSGCitaDisponibilidadHoraFin, AV111TFSGCitaDisponibilidadHoraFin_To, AV61TFSGCitaDisponibilidadEspecialidadId, AV62TFSGCitaDisponibilidadEspecialidadId_To, AV63TFSGCitaDisponibilidadEspecialidadNombre, AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV65TFSGCitaDisponibilidadSedeId, AV66TFSGCitaDisponibilidadSedeId_To, AV67TFSGCitaDisponibilidadSedeNombre, AV96TFSGCitaDisponibilidadSedeNombre_Sel, AV69TFSGCitaDisponibilidadClinicaId, AV70TFSGCitaDisponibilidadClinicaId_To, AV71TFSGCitaDisponibilidadClinicaNombre, AV97TFSGCitaDisponibilidadClinicaNombre_Sel, AV73TFSGCitaDisponibilidadProfesionalId, AV74TFSGCitaDisponibilidadProfesionalId_To, AV75TFSGCitaDisponibilidadProFullName, AV76TFSGCitaDisponibilidadProFullName_Sel, AV77TFSGCitaDisponibilidadProCOP, AV78TFSGCitaDisponibilidadProCOP_Sel, AV80TFCitaEstadoCita_Sels, AV81TFCitaInforme, AV82TFCitaInforme_Sel, AV99TFCitaAntecedentes, AV100TFCitaAntecedentes_Sel, AV101TFCitaLink, AV102TFCitaLink_Sel, AV166Pgmname, AV13OrderedBy, AV14OrderedDsc, AV88IsAuthorized_Update, AV89IsAuthorized_Delete, AV93IsAuthorized_PacienteNombres, AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre, AV98IsAuthorized_SGCitaDisponibilidadSedeNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFCitaId, AV28TFCitaId_To, AV29TFCitaCode, AV30TFCitaCode_Sel, AV31TFPacienteId, AV32TFPacienteId_To, AV33TFPacienteApellidoPaterno, AV34TFPacienteApellidoPaterno_Sel, AV35TFPacienteApellidoMaterno, AV36TFPacienteApellidoMaterno_Sel, AV37TFPacienteNombres, AV38TFPacienteNombres_Sel, AV39TFPacienteNroDocumento, AV40TFPacienteNroDocumento_Sel, AV109TFCitaTipoDiagnostico_Sels, AV49TFSGCitaDisponibilidadId, AV50TFSGCitaDisponibilidadId_To, AV51TFSGCitaDisponibilidadFecha, AV52TFSGCitaDisponibilidadFecha_To, AV56TFSGCitaDisponibilidadHoraInicio, AV57TFSGCitaDisponibilidadHoraInicio_To, AV110TFSGCitaDisponibilidadHoraFin, AV111TFSGCitaDisponibilidadHoraFin_To, AV61TFSGCitaDisponibilidadEspecialidadId, AV62TFSGCitaDisponibilidadEspecialidadId_To, AV63TFSGCitaDisponibilidadEspecialidadNombre, AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV65TFSGCitaDisponibilidadSedeId, AV66TFSGCitaDisponibilidadSedeId_To, AV67TFSGCitaDisponibilidadSedeNombre, AV96TFSGCitaDisponibilidadSedeNombre_Sel, AV69TFSGCitaDisponibilidadClinicaId, AV70TFSGCitaDisponibilidadClinicaId_To, AV71TFSGCitaDisponibilidadClinicaNombre, AV97TFSGCitaDisponibilidadClinicaNombre_Sel, AV73TFSGCitaDisponibilidadProfesionalId, AV74TFSGCitaDisponibilidadProfesionalId_To, AV75TFSGCitaDisponibilidadProFullName, AV76TFSGCitaDisponibilidadProFullName_Sel, AV77TFSGCitaDisponibilidadProCOP, AV78TFSGCitaDisponibilidadProCOP_Sel, AV80TFCitaEstadoCita_Sels, AV81TFCitaInforme, AV82TFCitaInforme_Sel, AV99TFCitaAntecedentes, AV100TFCitaAntecedentes_Sel, AV101TFCitaLink, AV102TFCitaLink_Sel, AV166Pgmname, AV13OrderedBy, AV14OrderedDsc, AV88IsAuthorized_Update, AV89IsAuthorized_Delete, AV93IsAuthorized_PacienteNombres, AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre, AV98IsAuthorized_SGCitaDisponibilidadSedeNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV166Pgmname = "CitaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1H0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e191H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV83DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV85GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV86GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV53DDO_SGCitaDisponibilidadFechaAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE"), 0) ;
         AV54DDO_SGCitaDisponibilidadFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO"), 0) ;
         AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE"), 0) ;
         AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO"), 0) ;
         AV112DDO_SGCitaDisponibilidadHoraFinAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE"), 0) ;
         AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO"), 0) ;
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
         AV55DDO_SGCitaDisponibilidadFechaAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55DDO_SGCitaDisponibilidadFechaAuxDateText", AV55DDO_SGCitaDisponibilidadFechaAuxDateText);
         AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText", AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText);
         AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText", AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText);
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
      e191H2 ();
      if (returnInSub) return;
   }

   public void e191H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFSGCITADISPONIBILIDADHORAFIN_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFSGCITADISPONIBILIDADHORAINICIO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname});
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
      GXt_boolean1 = AV93IsAuthorized_PacienteNombres ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
      citaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV93IsAuthorized_PacienteNombres = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV93IsAuthorized_PacienteNombres", AV93IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV93IsAuthorized_PacienteNombres));
      GXt_boolean1 = AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean2) ;
      citaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE", getSecureSignedToken( "", AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre));
      GXt_boolean1 = AV98IsAuthorized_SGCitaDisponibilidadSedeNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede", GXv_boolean2) ;
      citaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV98IsAuthorized_SGCitaDisponibilidadSedeNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98IsAuthorized_SGCitaDisponibilidadSedeNombre", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE", getSecureSignedToken( "", AV98IsAuthorized_SGCitaDisponibilidadSedeNombre));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Cita" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV83DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV83DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e201H2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("CitaWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("CitaWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtCitaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteApellidoPaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoPaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoPaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteApellidoMaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoMaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoMaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNombres_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombres_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNroDocumento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNroDocumento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNroDocumento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbCitaTipoDiagnostico.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaTipoDiagnostico.getInternalname(), "Visible", GXutil.ltrimstr( cmbCitaTipoDiagnostico.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadFecha_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadFecha_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadHoraInicio_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadHoraInicio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadHoraInicio_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadHoraFin_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadHoraFin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadHoraFin_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadEspecialidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadEspecialidadNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadSedeId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadSedeId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadSedeId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadSedeNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadSedeNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadSedeNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadClinicaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadClinicaNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadProfesionalId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProfesionalId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProfesionalId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadProFullName_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProFullName_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProFullName_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadProCOP_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProCOP_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProCOP_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbCitaEstadoCita.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoCita.getInternalname(), "Visible", GXutil.ltrimstr( cmbCitaEstadoCita.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaInforme_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaInforme_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaInforme_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaAntecedentes_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaAntecedentes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaAntecedentes_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaLink_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaLink_Visible), 5, 0), !bGXsfl_43_Refreshing);
      AV85GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV85GridCurrentPage), 10, 0));
      AV86GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86GridPageCount), 10, 0));
      AV117Citawwds_1_filterfulltext = AV16FilterFullText ;
      AV118Citawwds_2_tfcitaid = AV27TFCitaId ;
      AV119Citawwds_3_tfcitaid_to = AV28TFCitaId_To ;
      AV120Citawwds_4_tfcitacode = AV29TFCitaCode ;
      AV121Citawwds_5_tfcitacode_sel = AV30TFCitaCode_Sel ;
      AV122Citawwds_6_tfpacienteid = AV31TFPacienteId ;
      AV123Citawwds_7_tfpacienteid_to = AV32TFPacienteId_To ;
      AV124Citawwds_8_tfpacienteapellidopaterno = AV33TFPacienteApellidoPaterno ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = AV34TFPacienteApellidoPaterno_Sel ;
      AV126Citawwds_10_tfpacienteapellidomaterno = AV35TFPacienteApellidoMaterno ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = AV36TFPacienteApellidoMaterno_Sel ;
      AV128Citawwds_12_tfpacientenombres = AV37TFPacienteNombres ;
      AV129Citawwds_13_tfpacientenombres_sel = AV38TFPacienteNombres_Sel ;
      AV130Citawwds_14_tfpacientenrodocumento = AV39TFPacienteNroDocumento ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = AV40TFPacienteNroDocumento_Sel ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = AV109TFCitaTipoDiagnostico_Sels ;
      AV133Citawwds_17_tfsgcitadisponibilidadid = AV49TFSGCitaDisponibilidadId ;
      AV134Citawwds_18_tfsgcitadisponibilidadid_to = AV50TFSGCitaDisponibilidadId_To ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = AV51TFSGCitaDisponibilidadFecha ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = AV52TFSGCitaDisponibilidadFecha_To ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = AV56TFSGCitaDisponibilidadHoraInicio ;
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV57TFSGCitaDisponibilidadHoraInicio_To ;
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = AV110TFSGCitaDisponibilidadHoraFin ;
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV111TFSGCitaDisponibilidadHoraFin_To ;
      AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV61TFSGCitaDisponibilidadEspecialidadId ;
      AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV62TFSGCitaDisponibilidadEspecialidadId_To ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV63TFSGCitaDisponibilidadEspecialidadNombre ;
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV145Citawwds_29_tfsgcitadisponibilidadsedeid = AV65TFSGCitaDisponibilidadSedeId ;
      AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV66TFSGCitaDisponibilidadSedeId_To ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = AV67TFSGCitaDisponibilidadSedeNombre ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV149Citawwds_33_tfsgcitadisponibilidadclinicaid = AV69TFSGCitaDisponibilidadClinicaId ;
      AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV70TFSGCitaDisponibilidadClinicaId_To ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV71TFSGCitaDisponibilidadClinicaNombre ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV73TFSGCitaDisponibilidadProfesionalId ;
      AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV74TFSGCitaDisponibilidadProfesionalId_To ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = AV75TFSGCitaDisponibilidadProFullName ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV76TFSGCitaDisponibilidadProFullName_Sel ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = AV77TFSGCitaDisponibilidadProCOP ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV78TFSGCitaDisponibilidadProCOP_Sel ;
      AV159Citawwds_43_tfcitaestadocita_sels = AV80TFCitaEstadoCita_Sels ;
      AV160Citawwds_44_tfcitainforme = AV81TFCitaInforme ;
      AV161Citawwds_45_tfcitainforme_sel = AV82TFCitaInforme_Sel ;
      AV162Citawwds_46_tfcitaantecedentes = AV99TFCitaAntecedentes ;
      AV163Citawwds_47_tfcitaantecedentes_sel = AV100TFCitaAntecedentes_Sel ;
      AV164Citawwds_48_tfcitalink = AV101TFCitaLink ;
      AV165Citawwds_49_tfcitalink_sel = AV102TFCitaLink_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e121H2( )
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
         AV84PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV84PageToGo) ;
      }
   }

   public void e131H2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141H2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaId") == 0 )
         {
            AV27TFCitaId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFCitaId), 8, 0));
            AV28TFCitaId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaCode") == 0 )
         {
            AV29TFCitaCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaCode", AV29TFCitaCode);
            AV30TFCitaCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaCode_Sel", AV30TFCitaCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteId") == 0 )
         {
            AV31TFPacienteId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFPacienteId), 8, 0));
            AV32TFPacienteId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFPacienteId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoPaterno") == 0 )
         {
            AV33TFPacienteApellidoPaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPacienteApellidoPaterno", AV33TFPacienteApellidoPaterno);
            AV34TFPacienteApellidoPaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPacienteApellidoPaterno_Sel", AV34TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoMaterno") == 0 )
         {
            AV35TFPacienteApellidoMaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFPacienteApellidoMaterno", AV35TFPacienteApellidoMaterno);
            AV36TFPacienteApellidoMaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFPacienteApellidoMaterno_Sel", AV36TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNombres") == 0 )
         {
            AV37TFPacienteNombres = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPacienteNombres", AV37TFPacienteNombres);
            AV38TFPacienteNombres_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPacienteNombres_Sel", AV38TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNroDocumento") == 0 )
         {
            AV39TFPacienteNroDocumento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFPacienteNroDocumento", AV39TFPacienteNroDocumento);
            AV40TFPacienteNroDocumento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFPacienteNroDocumento_Sel", AV40TFPacienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaTipoDiagnostico") == 0 )
         {
            AV108TFCitaTipoDiagnostico_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFCitaTipoDiagnostico_SelsJson", AV108TFCitaTipoDiagnostico_SelsJson);
            AV109TFCitaTipoDiagnostico_Sels.fromJSonString(AV108TFCitaTipoDiagnostico_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadId") == 0 )
         {
            AV49TFSGCitaDisponibilidadId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49TFSGCitaDisponibilidadId), 8, 0));
            AV50TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFSGCitaDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TFSGCitaDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadFecha") == 0 )
         {
            AV51TFSGCitaDisponibilidadFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFSGCitaDisponibilidadFecha", localUtil.format(AV51TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV52TFSGCitaDisponibilidadFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSGCitaDisponibilidadFecha_To", localUtil.format(AV52TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadHoraInicio") == 0 )
         {
            AV56TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFSGCitaDisponibilidadHoraInicio", localUtil.ttoc( AV56TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV57TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV57TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV57TFSGCitaDisponibilidadHoraInicio_To) )
            {
               AV57TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV57TFSGCitaDisponibilidadHoraInicio_To)), (byte)(GXutil.month( AV57TFSGCitaDisponibilidadHoraInicio_To)), (byte)(GXutil.day( AV57TFSGCitaDisponibilidadHoraInicio_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV57TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV57TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadHoraFin") == 0 )
         {
            AV110TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV110TFSGCitaDisponibilidadHoraFin", localUtil.ttoc( AV110TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV111TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV111TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV111TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV111TFSGCitaDisponibilidadHoraFin_To) )
            {
               AV111TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV111TFSGCitaDisponibilidadHoraFin_To)), (byte)(GXutil.month( AV111TFSGCitaDisponibilidadHoraFin_To)), (byte)(GXutil.day( AV111TFSGCitaDisponibilidadHoraFin_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV111TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV111TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadEspecialidadId") == 0 )
         {
            AV61TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFSGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61TFSGCitaDisponibilidadEspecialidadId), 4, 0));
            AV62TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFSGCitaDisponibilidadEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFSGCitaDisponibilidadEspecialidadId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadEspecialidadNombre") == 0 )
         {
            AV63TFSGCitaDisponibilidadEspecialidadNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFSGCitaDisponibilidadEspecialidadNombre", AV63TFSGCitaDisponibilidadEspecialidadNombre);
            AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadSedeId") == 0 )
         {
            AV65TFSGCitaDisponibilidadSedeId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFSGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFSGCitaDisponibilidadSedeId), 4, 0));
            AV66TFSGCitaDisponibilidadSedeId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFSGCitaDisponibilidadSedeId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66TFSGCitaDisponibilidadSedeId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadSedeNombre") == 0 )
         {
            AV67TFSGCitaDisponibilidadSedeNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFSGCitaDisponibilidadSedeNombre", AV67TFSGCitaDisponibilidadSedeNombre);
            AV96TFSGCitaDisponibilidadSedeNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96TFSGCitaDisponibilidadSedeNombre_Sel", AV96TFSGCitaDisponibilidadSedeNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadClinicaId") == 0 )
         {
            AV69TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFSGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69TFSGCitaDisponibilidadClinicaId), 4, 0));
            AV70TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFSGCitaDisponibilidadClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70TFSGCitaDisponibilidadClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadClinicaNombre") == 0 )
         {
            AV71TFSGCitaDisponibilidadClinicaNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFSGCitaDisponibilidadClinicaNombre", AV71TFSGCitaDisponibilidadClinicaNombre);
            AV97TFSGCitaDisponibilidadClinicaNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFSGCitaDisponibilidadClinicaNombre_Sel", AV97TFSGCitaDisponibilidadClinicaNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadProfesionalId") == 0 )
         {
            AV73TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFSGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73TFSGCitaDisponibilidadProfesionalId), 8, 0));
            AV74TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFSGCitaDisponibilidadProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFSGCitaDisponibilidadProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadProFullName") == 0 )
         {
            AV75TFSGCitaDisponibilidadProFullName = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFSGCitaDisponibilidadProFullName", AV75TFSGCitaDisponibilidadProFullName);
            AV76TFSGCitaDisponibilidadProFullName_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFSGCitaDisponibilidadProFullName_Sel", AV76TFSGCitaDisponibilidadProFullName_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadProCOP") == 0 )
         {
            AV77TFSGCitaDisponibilidadProCOP = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFSGCitaDisponibilidadProCOP", AV77TFSGCitaDisponibilidadProCOP);
            AV78TFSGCitaDisponibilidadProCOP_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFSGCitaDisponibilidadProCOP_Sel", AV78TFSGCitaDisponibilidadProCOP_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaEstadoCita") == 0 )
         {
            AV79TFCitaEstadoCita_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFCitaEstadoCita_SelsJson", AV79TFCitaEstadoCita_SelsJson);
            AV80TFCitaEstadoCita_Sels.fromJSonString(AV79TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaInforme") == 0 )
         {
            AV81TFCitaInforme = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFCitaInforme", AV81TFCitaInforme);
            AV82TFCitaInforme_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFCitaInforme_Sel", AV82TFCitaInforme_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaAntecedentes") == 0 )
         {
            AV99TFCitaAntecedentes = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFCitaAntecedentes", AV99TFCitaAntecedentes);
            AV100TFCitaAntecedentes_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFCitaAntecedentes_Sel", AV100TFCitaAntecedentes_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaLink") == 0 )
         {
            AV101TFCitaLink = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101TFCitaLink", AV101TFCitaLink);
            AV102TFCitaLink_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102TFCitaLink_Sel", AV102TFCitaLink_Sel);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80TFCitaEstadoCita_Sels", AV80TFCitaEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV109TFCitaTipoDiagnostico_Sels", AV109TFCitaTipoDiagnostico_Sels);
   }

   private void e211H2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV91Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV91Update);
      if ( AV88IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0))}, new String[] {"Mode","CitaId"})  ;
      }
      AV92Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV92Delete);
      if ( AV89IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0))}, new String[] {"Mode","CitaId"})  ;
      }
      edtCitaCode_Link = formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CitaId","TabCode"})  ;
      if ( AV93IsAuthorized_PacienteNombres )
      {
         edtPacienteNombres_Link = formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PacienteId","TabCode"})  ;
      }
      if ( AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre )
      {
         edtSGCitaDisponibilidadEspecialidadNombre_Link = formatLink("com.projectthani.especialidadview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A70SGCitaDisponibilidadEspecialidadId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"EspecialidadId","TabCode"})  ;
      }
      if ( AV98IsAuthorized_SGCitaDisponibilidadSedeNombre )
      {
         edtSGCitaDisponibilidadSedeNombre_Link = formatLink("com.projectthani.sedeview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A72SGCitaDisponibilidadSedeId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SedeId","TabCode"})  ;
      }
      edtCitaLink_Linktarget = "_blank" ;
      edtCitaLink_Link = A91CitaLink ;
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

   public void e151H2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "CitaWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e111H2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("CitaWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV166Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("CitaWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "CitaWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         citaww_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV166Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV109TFCitaTipoDiagnostico_Sels", AV109TFCitaTipoDiagnostico_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80TFCitaEstadoCita_Sels", AV80TFCitaEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e161H2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","CitaId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e171H2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.citawwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      citaww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      citaww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80TFCitaEstadoCita_Sels", AV80TFCitaEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV109TFCitaTipoDiagnostico_Sels", AV109TFCitaTipoDiagnostico_Sels);
   }

   public void e181H2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.citawwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80TFCitaEstadoCita_Sels", AV80TFCitaEstadoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV109TFCitaTipoDiagnostico_Sels", AV109TFCitaTipoDiagnostico_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaCode", "", "Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteId", "", "Paciente Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoPaterno", "", "Paciente Apellido Paterno", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoMaterno", "", "Paciente Apellido Materno", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombres", "", "Paciente Nombres", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNroDocumento", "", "Paciente Nro Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaTipoDiagnostico", "", "Tipo Diagnostico", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadId", "", "Disponibilidad Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadFecha", "", "Disponibilidad Fecha", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadHoraInicio", "", "Hora Inicio", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadHoraFin", "", "Hora Fin", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadId", "", "Especialidad Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadNombre", "", "Especialidad Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadSedeId", "", "Sede Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadSedeNombre", "", "Sede Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaId", "", "Clinica Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaNombre", "", "Clinica Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProfesionalId", "", "Profesional Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProFullName", "", "Full Name", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProCOP", "", "Pro COP", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaEstadoCita", "", "Estado Cita", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaInforme", "", "Informe", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaAntecedentes", "", "Antecedentes", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaLink", "", "Link", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "CitaWWColumnsSelector", GXv_char8) ;
      citaww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV88IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Update", GXv_boolean2) ;
      citaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV88IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88IsAuthorized_Update", AV88IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV88IsAuthorized_Update));
      if ( ! ( AV88IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV89IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Delete", GXv_boolean2) ;
      citaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV89IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89IsAuthorized_Delete", AV89IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV89IsAuthorized_Delete));
      if ( ! ( AV89IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV90TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Insert", GXv_boolean2) ;
      citaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV90TempBoolean = GXt_boolean1 ;
      if ( ! ( AV90TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "CitaWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFCitaId), 8, 0));
      AV28TFCitaId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFCitaId_To), 8, 0));
      AV29TFCitaCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaCode", AV29TFCitaCode);
      AV30TFCitaCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaCode_Sel", AV30TFCitaCode_Sel);
      AV31TFPacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFPacienteId), 8, 0));
      AV32TFPacienteId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFPacienteId_To), 8, 0));
      AV33TFPacienteApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFPacienteApellidoPaterno", AV33TFPacienteApellidoPaterno);
      AV34TFPacienteApellidoPaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFPacienteApellidoPaterno_Sel", AV34TFPacienteApellidoPaterno_Sel);
      AV35TFPacienteApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFPacienteApellidoMaterno", AV35TFPacienteApellidoMaterno);
      AV36TFPacienteApellidoMaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFPacienteApellidoMaterno_Sel", AV36TFPacienteApellidoMaterno_Sel);
      AV37TFPacienteNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFPacienteNombres", AV37TFPacienteNombres);
      AV38TFPacienteNombres_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFPacienteNombres_Sel", AV38TFPacienteNombres_Sel);
      AV39TFPacienteNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFPacienteNroDocumento", AV39TFPacienteNroDocumento);
      AV40TFPacienteNroDocumento_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFPacienteNroDocumento_Sel", AV40TFPacienteNroDocumento_Sel);
      AV109TFCitaTipoDiagnostico_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49TFSGCitaDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49TFSGCitaDisponibilidadId), 8, 0));
      AV50TFSGCitaDisponibilidadId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFSGCitaDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TFSGCitaDisponibilidadId_To), 8, 0));
      AV51TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFSGCitaDisponibilidadFecha", localUtil.format(AV51TFSGCitaDisponibilidadFecha, "99/99/99"));
      AV52TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFSGCitaDisponibilidadFecha_To", localUtil.format(AV52TFSGCitaDisponibilidadFecha_To, "99/99/99"));
      AV56TFSGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFSGCitaDisponibilidadHoraInicio", localUtil.ttoc( AV56TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
      AV57TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV57TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
      AV110TFSGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV110TFSGCitaDisponibilidadHoraFin", localUtil.ttoc( AV110TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
      AV111TFSGCitaDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV111TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV111TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
      AV61TFSGCitaDisponibilidadEspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFSGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61TFSGCitaDisponibilidadEspecialidadId), 4, 0));
      AV62TFSGCitaDisponibilidadEspecialidadId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFSGCitaDisponibilidadEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFSGCitaDisponibilidadEspecialidadId_To), 4, 0));
      AV63TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFSGCitaDisponibilidadEspecialidadNombre", AV63TFSGCitaDisponibilidadEspecialidadNombre);
      AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel);
      AV65TFSGCitaDisponibilidadSedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFSGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFSGCitaDisponibilidadSedeId), 4, 0));
      AV66TFSGCitaDisponibilidadSedeId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFSGCitaDisponibilidadSedeId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66TFSGCitaDisponibilidadSedeId_To), 4, 0));
      AV67TFSGCitaDisponibilidadSedeNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFSGCitaDisponibilidadSedeNombre", AV67TFSGCitaDisponibilidadSedeNombre);
      AV96TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96TFSGCitaDisponibilidadSedeNombre_Sel", AV96TFSGCitaDisponibilidadSedeNombre_Sel);
      AV69TFSGCitaDisponibilidadClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69TFSGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69TFSGCitaDisponibilidadClinicaId), 4, 0));
      AV70TFSGCitaDisponibilidadClinicaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70TFSGCitaDisponibilidadClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70TFSGCitaDisponibilidadClinicaId_To), 4, 0));
      AV71TFSGCitaDisponibilidadClinicaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFSGCitaDisponibilidadClinicaNombre", AV71TFSGCitaDisponibilidadClinicaNombre);
      AV97TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97TFSGCitaDisponibilidadClinicaNombre_Sel", AV97TFSGCitaDisponibilidadClinicaNombre_Sel);
      AV73TFSGCitaDisponibilidadProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73TFSGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73TFSGCitaDisponibilidadProfesionalId), 8, 0));
      AV74TFSGCitaDisponibilidadProfesionalId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74TFSGCitaDisponibilidadProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFSGCitaDisponibilidadProfesionalId_To), 8, 0));
      AV75TFSGCitaDisponibilidadProFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75TFSGCitaDisponibilidadProFullName", AV75TFSGCitaDisponibilidadProFullName);
      AV76TFSGCitaDisponibilidadProFullName_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76TFSGCitaDisponibilidadProFullName_Sel", AV76TFSGCitaDisponibilidadProFullName_Sel);
      AV77TFSGCitaDisponibilidadProCOP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFSGCitaDisponibilidadProCOP", AV77TFSGCitaDisponibilidadProCOP);
      AV78TFSGCitaDisponibilidadProCOP_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFSGCitaDisponibilidadProCOP_Sel", AV78TFSGCitaDisponibilidadProCOP_Sel);
      AV80TFCitaEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV81TFCitaInforme = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TFCitaInforme", AV81TFCitaInforme);
      AV82TFCitaInforme_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82TFCitaInforme_Sel", AV82TFCitaInforme_Sel);
      AV99TFCitaAntecedentes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99TFCitaAntecedentes", AV99TFCitaAntecedentes);
      AV100TFCitaAntecedentes_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100TFCitaAntecedentes_Sel", AV100TFCitaAntecedentes_Sel);
      AV101TFCitaLink = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV101TFCitaLink", AV101TFCitaLink);
      AV102TFCitaLink_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV102TFCitaLink_Sel", AV102TFCitaLink_Sel);
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
      if ( GXutil.strcmp(AV23Session.getValue(AV166Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV166Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV166Pgmname+"GridState"), null, null);
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
      AV167GXV1 = 1 ;
      while ( AV167GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV167GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV27TFCitaId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFCitaId), 8, 0));
            AV28TFCitaId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV29TFCitaCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaCode", AV29TFCitaCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV30TFCitaCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaCode_Sel", AV30TFCitaCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV31TFPacienteId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFPacienteId), 8, 0));
            AV32TFPacienteId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFPacienteId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV33TFPacienteApellidoPaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPacienteApellidoPaterno", AV33TFPacienteApellidoPaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV34TFPacienteApellidoPaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPacienteApellidoPaterno_Sel", AV34TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV35TFPacienteApellidoMaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFPacienteApellidoMaterno", AV35TFPacienteApellidoMaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV36TFPacienteApellidoMaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFPacienteApellidoMaterno_Sel", AV36TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV37TFPacienteNombres = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPacienteNombres", AV37TFPacienteNombres);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV38TFPacienteNombres_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPacienteNombres_Sel", AV38TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV39TFPacienteNroDocumento = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFPacienteNroDocumento", AV39TFPacienteNroDocumento);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV40TFPacienteNroDocumento_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFPacienteNroDocumento_Sel", AV40TFPacienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITATIPODIAGNOSTICO_SEL") == 0 )
         {
            AV108TFCitaTipoDiagnostico_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFCitaTipoDiagnostico_SelsJson", AV108TFCitaTipoDiagnostico_SelsJson);
            AV109TFCitaTipoDiagnostico_Sels.fromJSonString(AV108TFCitaTipoDiagnostico_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV49TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49TFSGCitaDisponibilidadId), 8, 0));
            AV50TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFSGCitaDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TFSGCitaDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV51TFSGCitaDisponibilidadFecha = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFSGCitaDisponibilidadFecha", localUtil.format(AV51TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV52TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSGCitaDisponibilidadFecha_To", localUtil.format(AV52TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAINICIO") == 0 )
         {
            AV56TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFSGCitaDisponibilidadHoraInicio", localUtil.ttoc( AV56TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV57TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV57TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate = GXutil.resetTime(AV56TFSGCitaDisponibilidadHoraInicio) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate", localUtil.format(AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate, "99/99/99"));
            AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo = GXutil.resetTime(AV57TFSGCitaDisponibilidadHoraInicio_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo", localUtil.format(AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAFIN") == 0 )
         {
            AV110TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV110TFSGCitaDisponibilidadHoraFin", localUtil.ttoc( AV110TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV111TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV111TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV111TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            AV112DDO_SGCitaDisponibilidadHoraFinAuxDate = GXutil.resetTime(AV110TFSGCitaDisponibilidadHoraFin) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV112DDO_SGCitaDisponibilidadHoraFinAuxDate", localUtil.format(AV112DDO_SGCitaDisponibilidadHoraFinAuxDate, "99/99/99"));
            AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo = GXutil.resetTime(AV111TFSGCitaDisponibilidadHoraFin_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo", localUtil.format(AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV61TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFSGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61TFSGCitaDisponibilidadEspecialidadId), 4, 0));
            AV62TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFSGCitaDisponibilidadEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFSGCitaDisponibilidadEspecialidadId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV63TFSGCitaDisponibilidadEspecialidadNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFSGCitaDisponibilidadEspecialidadNombre", AV63TFSGCitaDisponibilidadEspecialidadNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDEID") == 0 )
         {
            AV65TFSGCitaDisponibilidadSedeId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFSGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFSGCitaDisponibilidadSedeId), 4, 0));
            AV66TFSGCitaDisponibilidadSedeId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFSGCitaDisponibilidadSedeId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66TFSGCitaDisponibilidadSedeId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE") == 0 )
         {
            AV67TFSGCitaDisponibilidadSedeNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFSGCitaDisponibilidadSedeNombre", AV67TFSGCitaDisponibilidadSedeNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE_SEL") == 0 )
         {
            AV96TFSGCitaDisponibilidadSedeNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96TFSGCitaDisponibilidadSedeNombre_Sel", AV96TFSGCitaDisponibilidadSedeNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV69TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFSGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69TFSGCitaDisponibilidadClinicaId), 4, 0));
            AV70TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFSGCitaDisponibilidadClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70TFSGCitaDisponibilidadClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV71TFSGCitaDisponibilidadClinicaNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFSGCitaDisponibilidadClinicaNombre", AV71TFSGCitaDisponibilidadClinicaNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV97TFSGCitaDisponibilidadClinicaNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFSGCitaDisponibilidadClinicaNombre_Sel", AV97TFSGCitaDisponibilidadClinicaNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV73TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFSGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73TFSGCitaDisponibilidadProfesionalId), 8, 0));
            AV74TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFSGCitaDisponibilidadProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFSGCitaDisponibilidadProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV75TFSGCitaDisponibilidadProFullName = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFSGCitaDisponibilidadProFullName", AV75TFSGCitaDisponibilidadProFullName);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV76TFSGCitaDisponibilidadProFullName_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFSGCitaDisponibilidadProFullName_Sel", AV76TFSGCitaDisponibilidadProFullName_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROCOP") == 0 )
         {
            AV77TFSGCitaDisponibilidadProCOP = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFSGCitaDisponibilidadProCOP", AV77TFSGCitaDisponibilidadProCOP);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROCOP_SEL") == 0 )
         {
            AV78TFSGCitaDisponibilidadProCOP_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFSGCitaDisponibilidadProCOP_Sel", AV78TFSGCitaDisponibilidadProCOP_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOCITA_SEL") == 0 )
         {
            AV79TFCitaEstadoCita_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFCitaEstadoCita_SelsJson", AV79TFCitaEstadoCita_SelsJson);
            AV80TFCitaEstadoCita_Sels.fromJSonString(AV79TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAINFORME") == 0 )
         {
            AV81TFCitaInforme = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFCitaInforme", AV81TFCitaInforme);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAINFORME_SEL") == 0 )
         {
            AV82TFCitaInforme_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFCitaInforme_Sel", AV82TFCitaInforme_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAANTECEDENTES") == 0 )
         {
            AV99TFCitaAntecedentes = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFCitaAntecedentes", AV99TFCitaAntecedentes);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAANTECEDENTES_SEL") == 0 )
         {
            AV100TFCitaAntecedentes_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFCitaAntecedentes_Sel", AV100TFCitaAntecedentes_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITALINK") == 0 )
         {
            AV101TFCitaLink = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101TFCitaLink", AV101TFCitaLink);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITALINK_SEL") == 0 )
         {
            AV102TFCitaLink_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102TFCitaLink_Sel", AV102TFCitaLink_Sel);
         }
         AV167GXV1 = (int)(AV167GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFCitaCode_Sel)==0), AV30TFCitaCode_Sel, GXv_char8) ;
      citaww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFPacienteApellidoPaterno_Sel)==0), AV34TFPacienteApellidoPaterno_Sel, GXv_char7) ;
      citaww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFPacienteApellidoMaterno_Sel)==0), AV36TFPacienteApellidoMaterno_Sel, GXv_char15) ;
      citaww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFPacienteNombres_Sel)==0), AV38TFPacienteNombres_Sel, GXv_char17) ;
      citaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFPacienteNroDocumento_Sel)==0), AV40TFPacienteNroDocumento_Sel, GXv_char19) ;
      citaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV109TFCitaTipoDiagnostico_Sels.size()==0), AV108TFCitaTipoDiagnostico_SelsJson, GXv_char21) ;
      citaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0), AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, GXv_char23) ;
      citaww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV96TFSGCitaDisponibilidadSedeNombre_Sel)==0), AV96TFSGCitaDisponibilidadSedeNombre_Sel, GXv_char25) ;
      citaww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV97TFSGCitaDisponibilidadClinicaNombre_Sel)==0), AV97TFSGCitaDisponibilidadClinicaNombre_Sel, GXv_char27) ;
      citaww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV76TFSGCitaDisponibilidadProFullName_Sel)==0), AV76TFSGCitaDisponibilidadProFullName_Sel, GXv_char29) ;
      citaww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV78TFSGCitaDisponibilidadProCOP_Sel)==0), AV78TFSGCitaDisponibilidadProCOP_Sel, GXv_char31) ;
      citaww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV80TFCitaEstadoCita_Sels.size()==0), AV79TFCitaEstadoCita_SelsJson, GXv_char33) ;
      citaww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV82TFCitaInforme_Sel)==0), AV82TFCitaInforme_Sel, GXv_char35) ;
      citaww_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV100TFCitaAntecedentes_Sel)==0), AV100TFCitaAntecedentes_Sel, GXv_char37) ;
      citaww_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV102TFCitaLink_Sel)==0), AV102TFCitaLink_Sel, GXv_char39) ;
      citaww_impl.this.GXt_char38 = GXv_char39[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"||"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"||||||"+GXt_char22+"||"+GXt_char24+"||"+GXt_char26+"||"+GXt_char28+"|"+GXt_char30+"|"+GXt_char32+"|"+GXt_char34+"|"+GXt_char36+"|"+GXt_char38 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFCitaCode)==0), AV29TFCitaCode, GXv_char39) ;
      citaww_impl.this.GXt_char38 = GXv_char39[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFPacienteApellidoPaterno)==0), AV33TFPacienteApellidoPaterno, GXv_char37) ;
      citaww_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFPacienteApellidoMaterno)==0), AV35TFPacienteApellidoMaterno, GXv_char35) ;
      citaww_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFPacienteNombres)==0), AV37TFPacienteNombres, GXv_char33) ;
      citaww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFPacienteNroDocumento)==0), AV39TFPacienteNroDocumento, GXv_char31) ;
      citaww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV63TFSGCitaDisponibilidadEspecialidadNombre)==0), AV63TFSGCitaDisponibilidadEspecialidadNombre, GXv_char29) ;
      citaww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV67TFSGCitaDisponibilidadSedeNombre)==0), AV67TFSGCitaDisponibilidadSedeNombre, GXv_char27) ;
      citaww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV71TFSGCitaDisponibilidadClinicaNombre)==0), AV71TFSGCitaDisponibilidadClinicaNombre, GXv_char25) ;
      citaww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV75TFSGCitaDisponibilidadProFullName)==0), AV75TFSGCitaDisponibilidadProFullName, GXv_char23) ;
      citaww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV77TFSGCitaDisponibilidadProCOP)==0), AV77TFSGCitaDisponibilidadProCOP, GXv_char21) ;
      citaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV81TFCitaInforme)==0), AV81TFCitaInforme, GXv_char19) ;
      citaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV99TFCitaAntecedentes)==0), AV99TFCitaAntecedentes, GXv_char17) ;
      citaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV101TFCitaLink)==0), AV101TFCitaLink, GXv_char15) ;
      citaww_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFCitaId) ? "" : GXutil.str( AV27TFCitaId, 8, 0))+"|"+GXt_char38+"|"+((0==AV31TFPacienteId) ? "" : GXutil.str( AV31TFPacienteId, 8, 0))+"|"+GXt_char36+"|"+GXt_char34+"|"+GXt_char32+"|"+GXt_char30+"||"+((0==AV49TFSGCitaDisponibilidadId) ? "" : GXutil.str( AV49TFSGCitaDisponibilidadId, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV51TFSGCitaDisponibilidadFecha)) ? "" : localUtil.dtoc( AV51TFSGCitaDisponibilidadFecha, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV56TFSGCitaDisponibilidadHoraInicio) ? "" : localUtil.dtoc( AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV110TFSGCitaDisponibilidadHoraFin) ? "" : localUtil.dtoc( AV112DDO_SGCitaDisponibilidadHoraFinAuxDate, 3, "/"))+"|"+((0==AV61TFSGCitaDisponibilidadEspecialidadId) ? "" : GXutil.str( AV61TFSGCitaDisponibilidadEspecialidadId, 4, 0))+"|"+GXt_char28+"|"+((0==AV65TFSGCitaDisponibilidadSedeId) ? "" : GXutil.str( AV65TFSGCitaDisponibilidadSedeId, 4, 0))+"|"+GXt_char26+"|"+((0==AV69TFSGCitaDisponibilidadClinicaId) ? "" : GXutil.str( AV69TFSGCitaDisponibilidadClinicaId, 4, 0))+"|"+GXt_char24+"|"+((0==AV73TFSGCitaDisponibilidadProfesionalId) ? "" : GXutil.str( AV73TFSGCitaDisponibilidadProfesionalId, 8, 0))+"|"+GXt_char22+"|"+GXt_char20+"||"+GXt_char18+"|"+GXt_char16+"|"+GXt_char14 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFCitaId_To) ? "" : GXutil.str( AV28TFCitaId_To, 8, 0))+"||"+((0==AV32TFPacienteId_To) ? "" : GXutil.str( AV32TFPacienteId_To, 8, 0))+"||||||"+((0==AV50TFSGCitaDisponibilidadId_To) ? "" : GXutil.str( AV50TFSGCitaDisponibilidadId_To, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV52TFSGCitaDisponibilidadFecha_To)) ? "" : localUtil.dtoc( AV52TFSGCitaDisponibilidadFecha_To, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV57TFSGCitaDisponibilidadHoraInicio_To) ? "" : localUtil.dtoc( AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV111TFSGCitaDisponibilidadHoraFin_To) ? "" : localUtil.dtoc( AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo, 3, "/"))+"|"+((0==AV62TFSGCitaDisponibilidadEspecialidadId_To) ? "" : GXutil.str( AV62TFSGCitaDisponibilidadEspecialidadId_To, 4, 0))+"||"+((0==AV66TFSGCitaDisponibilidadSedeId_To) ? "" : GXutil.str( AV66TFSGCitaDisponibilidadSedeId_To, 4, 0))+"||"+((0==AV70TFSGCitaDisponibilidadClinicaId_To) ? "" : GXutil.str( AV70TFSGCitaDisponibilidadClinicaId_To, 4, 0))+"||"+((0==AV74TFSGCitaDisponibilidadProfesionalId_To) ? "" : GXutil.str( AV74TFSGCitaDisponibilidadProfesionalId_To, 8, 0))+"||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV166Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITAID", !((0==AV27TFCitaId)&&(0==AV28TFCitaId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFCitaId, 8, 0)), GXutil.trim( GXutil.str( AV28TFCitaId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITACODE", !(GXutil.strcmp("", AV29TFCitaCode)==0), (short)(0), AV29TFCitaCode, "", !(GXutil.strcmp("", AV30TFCitaCode_Sel)==0), AV30TFCitaCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPACIENTEID", !((0==AV31TFPacienteId)&&(0==AV32TFPacienteId_To)), (short)(0), GXutil.trim( GXutil.str( AV31TFPacienteId, 8, 0)), GXutil.trim( GXutil.str( AV32TFPacienteId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPACIENTEAPELLIDOPATERNO", !(GXutil.strcmp("", AV33TFPacienteApellidoPaterno)==0), (short)(0), AV33TFPacienteApellidoPaterno, "", !(GXutil.strcmp("", AV34TFPacienteApellidoPaterno_Sel)==0), AV34TFPacienteApellidoPaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPACIENTEAPELLIDOMATERNO", !(GXutil.strcmp("", AV35TFPacienteApellidoMaterno)==0), (short)(0), AV35TFPacienteApellidoMaterno, "", !(GXutil.strcmp("", AV36TFPacienteApellidoMaterno_Sel)==0), AV36TFPacienteApellidoMaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPACIENTENOMBRES", !(GXutil.strcmp("", AV37TFPacienteNombres)==0), (short)(0), AV37TFPacienteNombres, "", !(GXutil.strcmp("", AV38TFPacienteNombres_Sel)==0), AV38TFPacienteNombres_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFPACIENTENRODOCUMENTO", !(GXutil.strcmp("", AV39TFPacienteNroDocumento)==0), (short)(0), AV39TFPacienteNroDocumento, "", !(GXutil.strcmp("", AV40TFPacienteNroDocumento_Sel)==0), AV40TFPacienteNroDocumento_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITATIPODIAGNOSTICO_SEL", !(AV109TFCitaTipoDiagnostico_Sels.size()==0), (short)(0), AV109TFCitaTipoDiagnostico_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADID", !((0==AV49TFSGCitaDisponibilidadId)&&(0==AV50TFSGCitaDisponibilidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV49TFSGCitaDisponibilidadId, 8, 0)), GXutil.trim( GXutil.str( AV50TFSGCitaDisponibilidadId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADFECHA", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV51TFSGCitaDisponibilidadFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV52TFSGCitaDisponibilidadFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV51TFSGCitaDisponibilidadFecha, 3, "/")), GXutil.trim( localUtil.dtoc( AV52TFSGCitaDisponibilidadFecha_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADHORAINICIO", !(GXutil.dateCompare(GXutil.nullDate(), AV56TFSGCitaDisponibilidadHoraInicio)&&GXutil.dateCompare(GXutil.nullDate(), AV57TFSGCitaDisponibilidadHoraInicio_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV56TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV57TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADHORAFIN", !(GXutil.dateCompare(GXutil.nullDate(), AV110TFSGCitaDisponibilidadHoraFin)&&GXutil.dateCompare(GXutil.nullDate(), AV111TFSGCitaDisponibilidadHoraFin_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV110TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV111TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADESPECIALIDADID", !((0==AV61TFSGCitaDisponibilidadEspecialidadId)&&(0==AV62TFSGCitaDisponibilidadEspecialidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV61TFSGCitaDisponibilidadEspecialidadId, 4, 0)), GXutil.trim( GXutil.str( AV62TFSGCitaDisponibilidadEspecialidadId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE", !(GXutil.strcmp("", AV63TFSGCitaDisponibilidadEspecialidadNombre)==0), (short)(0), AV63TFSGCitaDisponibilidadEspecialidadNombre, "", !(GXutil.strcmp("", AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0), AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADSEDEID", !((0==AV65TFSGCitaDisponibilidadSedeId)&&(0==AV66TFSGCitaDisponibilidadSedeId_To)), (short)(0), GXutil.trim( GXutil.str( AV65TFSGCitaDisponibilidadSedeId, 4, 0)), GXutil.trim( GXutil.str( AV66TFSGCitaDisponibilidadSedeId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADSEDENOMBRE", !(GXutil.strcmp("", AV67TFSGCitaDisponibilidadSedeNombre)==0), (short)(0), AV67TFSGCitaDisponibilidadSedeNombre, "", !(GXutil.strcmp("", AV96TFSGCitaDisponibilidadSedeNombre_Sel)==0), AV96TFSGCitaDisponibilidadSedeNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADCLINICAID", !((0==AV69TFSGCitaDisponibilidadClinicaId)&&(0==AV70TFSGCitaDisponibilidadClinicaId_To)), (short)(0), GXutil.trim( GXutil.str( AV69TFSGCitaDisponibilidadClinicaId, 4, 0)), GXutil.trim( GXutil.str( AV70TFSGCitaDisponibilidadClinicaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADCLINICANOMBRE", !(GXutil.strcmp("", AV71TFSGCitaDisponibilidadClinicaNombre)==0), (short)(0), AV71TFSGCitaDisponibilidadClinicaNombre, "", !(GXutil.strcmp("", AV97TFSGCitaDisponibilidadClinicaNombre_Sel)==0), AV97TFSGCitaDisponibilidadClinicaNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADPROFESIONALID", !((0==AV73TFSGCitaDisponibilidadProfesionalId)&&(0==AV74TFSGCitaDisponibilidadProfesionalId_To)), (short)(0), GXutil.trim( GXutil.str( AV73TFSGCitaDisponibilidadProfesionalId, 8, 0)), GXutil.trim( GXutil.str( AV74TFSGCitaDisponibilidadProfesionalId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADPROFULLNAME", !(GXutil.strcmp("", AV75TFSGCitaDisponibilidadProFullName)==0), (short)(0), AV75TFSGCitaDisponibilidadProFullName, "", !(GXutil.strcmp("", AV76TFSGCitaDisponibilidadProFullName_Sel)==0), AV76TFSGCitaDisponibilidadProFullName_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFSGCITADISPONIBILIDADPROCOP", !(GXutil.strcmp("", AV77TFSGCitaDisponibilidadProCOP)==0), (short)(0), AV77TFSGCitaDisponibilidadProCOP, "", !(GXutil.strcmp("", AV78TFSGCitaDisponibilidadProCOP_Sel)==0), AV78TFSGCitaDisponibilidadProCOP_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITAESTADOCITA_SEL", !(AV80TFCitaEstadoCita_Sels.size()==0), (short)(0), AV80TFCitaEstadoCita_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITAINFORME", !(GXutil.strcmp("", AV81TFCitaInforme)==0), (short)(0), AV81TFCitaInforme, "", !(GXutil.strcmp("", AV82TFCitaInforme_Sel)==0), AV82TFCitaInforme_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITAANTECEDENTES", !(GXutil.strcmp("", AV99TFCitaAntecedentes)==0), (short)(0), AV99TFCitaAntecedentes, "", !(GXutil.strcmp("", AV100TFCitaAntecedentes_Sel)==0), AV100TFCitaAntecedentes_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      GXv_SdtWWPGridState40[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState40, "TFCITALINK", !(GXutil.strcmp("", AV101TFCitaLink)==0), (short)(0), AV101TFCitaLink, "", !(GXutil.strcmp("", AV102TFCitaLink_Sel)==0), AV102TFCitaLink_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState40[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV166Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV166Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Cita" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_1H2( boolean wbgen )
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
         wb_table2_30_1H2( true) ;
      }
      else
      {
         wb_table2_30_1H2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_1H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_1H2e( true) ;
      }
      else
      {
         wb_table1_25_1H2e( false) ;
      }
   }

   public void wb_table2_30_1H2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_CitaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_1H2e( true) ;
      }
      else
      {
         wb_table2_30_1H2e( false) ;
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
      pa1H2( ) ;
      ws1H2( ) ;
      we1H2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110332981", true, true);
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
      httpContext.AddJavascriptSource("citaww.js", "?20225110332981", false, true);
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
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_43_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_43_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_43_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_43_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_43_idx ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_43_idx ;
      cmbCitaTipoDiagnostico.setInternalname( "CITATIPODIAGNOSTICO_"+sGXsfl_43_idx );
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadSedeId_Internalname = "SGCITADISPONIBILIDADSEDEID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadProCOP_Internalname = "SGCITADISPONIBILIDADPROCOP_"+sGXsfl_43_idx ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA_"+sGXsfl_43_idx );
      edtCitaInforme_Internalname = "CITAINFORME_"+sGXsfl_43_idx ;
      edtCitaAntecedentes_Internalname = "CITAANTECEDENTES_"+sGXsfl_43_idx ;
      edtCitaLink_Internalname = "CITALINK_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_fel_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_43_fel_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_43_fel_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_43_fel_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_43_fel_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_43_fel_idx ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_43_fel_idx ;
      cmbCitaTipoDiagnostico.setInternalname( "CITATIPODIAGNOSTICO_"+sGXsfl_43_fel_idx );
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadSedeId_Internalname = "SGCITADISPONIBILIDADSEDEID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadProCOP_Internalname = "SGCITADISPONIBILIDADPROCOP_"+sGXsfl_43_fel_idx ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA_"+sGXsfl_43_fel_idx );
      edtCitaInforme_Internalname = "CITAINFORME_"+sGXsfl_43_fel_idx ;
      edtCitaAntecedentes_Internalname = "CITAANTECEDENTES_"+sGXsfl_43_fel_idx ;
      edtCitaLink_Internalname = "CITALINK_"+sGXsfl_43_fel_idx ;
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb1H0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV91Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV92Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaCode_Internalname,A64CitaCode,"","","'"+""+"'"+",false,"+"'"+""+"'",edtCitaCode_Link,"","","",edtCitaCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCitaCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPacienteId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteId_Internalname,GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteApellidoPaterno_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoPaterno_Internalname,A103PacienteApellidoPaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoPaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteApellidoPaterno_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteApellidoMaterno_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoMaterno_Internalname,A104PacienteApellidoMaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoMaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteApellidoMaterno_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteNombres_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombres_Internalname,A105PacienteNombres,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPacienteNombres_Link,"","","",edtPacienteNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteNombres_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteNroDocumento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNroDocumento_Internalname,A106PacienteNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteNroDocumento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbCitaTipoDiagnostico.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbCitaTipoDiagnostico.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITATIPODIAGNOSTICO_" + sGXsfl_43_idx ;
            cmbCitaTipoDiagnostico.setName( GXCCtl );
            cmbCitaTipoDiagnostico.setWebtags( "" );
            cmbCitaTipoDiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
            cmbCitaTipoDiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
            cmbCitaTipoDiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
            if ( cmbCitaTipoDiagnostico.getItemCount() > 0 )
            {
               A65CitaTipoDiagnostico = cmbCitaTipoDiagnostico.getValidValue(A65CitaTipoDiagnostico) ;
               n65CitaTipoDiagnostico = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaTipoDiagnostico,cmbCitaTipoDiagnostico.getInternalname(),GXutil.rtrim( A65CitaTipoDiagnostico),Integer.valueOf(1),cmbCitaTipoDiagnostico.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","svchar","",Integer.valueOf(cmbCitaTipoDiagnostico.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaTipoDiagnostico.setValue( GXutil.rtrim( A65CitaTipoDiagnostico) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaTipoDiagnostico.getInternalname(), "Values", cmbCitaTipoDiagnostico.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadHoraInicio_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadHoraInicio_Internalname,localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A68SGCitaDisponibilidadHoraInicio, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadHoraInicio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadHoraInicio_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadHoraFin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadHoraFin_Internalname,localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A387SGCitaDisponibilidadHoraFin, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadHoraFin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadHoraFin_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadEspecialidadId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadEspecialidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadEspecialidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadEspecialidadId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSGCitaDisponibilidadEspecialidadNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadEspecialidadNombre_Internalname,A146SGCitaDisponibilidadEspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtSGCitaDisponibilidadEspecialidadNombre_Link,"","","",edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadEspecialidadNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadSedeId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadSedeId_Internalname,GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadSedeId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadSedeId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSGCitaDisponibilidadSedeNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadSedeNombre_Internalname,A73SGCitaDisponibilidadSedeNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtSGCitaDisponibilidadSedeNombre_Link,"","","",edtSGCitaDisponibilidadSedeNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadSedeNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadClinicaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadClinicaId_Internalname,GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadClinicaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadClinicaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSGCitaDisponibilidadClinicaNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadClinicaNombre_Internalname,A78SGCitaDisponibilidadClinicaNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadClinicaNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadClinicaNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSGCitaDisponibilidadProfesionalId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadProfesionalId_Internalname,GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadProfesionalId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadProfesionalId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSGCitaDisponibilidadProFullName_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadProFullName_Internalname,A82SGCitaDisponibilidadProFullName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadProFullName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadProFullName_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSGCitaDisponibilidadProCOP_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadProCOP_Internalname,A87SGCitaDisponibilidadProCOP,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadProCOP_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadProCOP_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbCitaEstadoCita.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbCitaEstadoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITAESTADOCITA_" + sGXsfl_43_idx ;
            cmbCitaEstadoCita.setName( GXCCtl );
            cmbCitaEstadoCita.setWebtags( "" );
            cmbCitaEstadoCita.addItem("R", "Registrado", (short)(0));
            cmbCitaEstadoCita.addItem("C", "Confirmado", (short)(0));
            cmbCitaEstadoCita.addItem("A", "En Atención", (short)(0));
            cmbCitaEstadoCita.addItem("F", "Finalizado", (short)(0));
            cmbCitaEstadoCita.addItem("X", "Cancelado", (short)(0));
            cmbCitaEstadoCita.addItem("N", "No se presentó", (short)(0));
            if ( cmbCitaEstadoCita.getItemCount() > 0 )
            {
               A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
               n89CitaEstadoCita = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaEstadoCita,cmbCitaEstadoCita.getInternalname(),GXutil.rtrim( A89CitaEstadoCita),Integer.valueOf(1),cmbCitaEstadoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbCitaEstadoCita.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCitaInforme_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaInforme_Internalname,A90CitaInforme,A90CitaInforme,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaInforme_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtCitaInforme_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCitaAntecedentes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaAntecedentes_Internalname,A100CitaAntecedentes,A100CitaAntecedentes,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaAntecedentes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtCitaAntecedentes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCitaLink_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaLink_Internalname,A91CitaLink,"","","'"+""+"'"+",false,"+"'"+""+"'",edtCitaLink_Link,edtCitaLink_Linktarget,"","",edtCitaLink_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtCitaLink_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1H2( ) ;
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
      edtCitaId_Internalname = "CITAID" ;
      edtCitaCode_Internalname = "CITACODE" ;
      edtPacienteId_Internalname = "PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO" ;
      cmbCitaTipoDiagnostico.setInternalname( "CITATIPODIAGNOSTICO" );
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO" ;
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN" ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadSedeId_Internalname = "SGCITADISPONIBILIDADSEDEID" ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE" ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE" ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID" ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME" ;
      edtSGCitaDisponibilidadProCOP_Internalname = "SGCITADISPONIBILIDADPROCOP" ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA" );
      edtCitaInforme_Internalname = "CITAINFORME" ;
      edtCitaAntecedentes_Internalname = "CITAANTECEDENTES" ;
      edtCitaLink_Internalname = "CITALINK" ;
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
      edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname = "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETEXT" ;
      Tfsgcitadisponibilidadhorainicio_rangepicker_Internalname = "TFSGCITADISPONIBILIDADHORAINICIO_RANGEPICKER" ;
      divDdo_sgcitadisponibilidadhorainicioauxdates_Internalname = "DDO_SGCITADISPONIBILIDADHORAINICIOAUXDATES" ;
      edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname = "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETEXT" ;
      Tfsgcitadisponibilidadhorafin_rangepicker_Internalname = "TFSGCITADISPONIBILIDADHORAFIN_RANGEPICKER" ;
      divDdo_sgcitadisponibilidadhorafinauxdates_Internalname = "DDO_SGCITADISPONIBILIDADHORAFINAUXDATES" ;
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
      edtCitaLink_Jsonclick = "" ;
      edtCitaAntecedentes_Jsonclick = "" ;
      edtCitaInforme_Jsonclick = "" ;
      cmbCitaEstadoCita.setJsonclick( "" );
      edtSGCitaDisponibilidadProCOP_Jsonclick = "" ;
      edtSGCitaDisponibilidadProFullName_Jsonclick = "" ;
      edtSGCitaDisponibilidadProfesionalId_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaId_Jsonclick = "" ;
      edtSGCitaDisponibilidadSedeNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadSedeId_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadHoraFin_Jsonclick = "" ;
      edtSGCitaDisponibilidadHoraInicio_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadId_Jsonclick = "" ;
      cmbCitaTipoDiagnostico.setJsonclick( "" );
      edtPacienteNroDocumento_Jsonclick = "" ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteId_Jsonclick = "" ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Jsonclick = "" ;
      edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Jsonclick = "" ;
      edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtCitaLink_Linktarget = "" ;
      edtCitaLink_Link = "" ;
      edtSGCitaDisponibilidadSedeNombre_Link = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Link = "" ;
      edtPacienteNombres_Link = "" ;
      edtCitaCode_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtCitaLink_Visible = -1 ;
      edtCitaAntecedentes_Visible = -1 ;
      edtCitaInforme_Visible = -1 ;
      cmbCitaEstadoCita.setVisible( -1 );
      edtSGCitaDisponibilidadProCOP_Visible = -1 ;
      edtSGCitaDisponibilidadProFullName_Visible = -1 ;
      edtSGCitaDisponibilidadProfesionalId_Visible = -1 ;
      edtSGCitaDisponibilidadClinicaNombre_Visible = -1 ;
      edtSGCitaDisponibilidadClinicaId_Visible = -1 ;
      edtSGCitaDisponibilidadSedeNombre_Visible = -1 ;
      edtSGCitaDisponibilidadSedeId_Visible = -1 ;
      edtSGCitaDisponibilidadEspecialidadNombre_Visible = -1 ;
      edtSGCitaDisponibilidadEspecialidadId_Visible = -1 ;
      edtSGCitaDisponibilidadHoraFin_Visible = -1 ;
      edtSGCitaDisponibilidadHoraInicio_Visible = -1 ;
      edtSGCitaDisponibilidadFecha_Visible = -1 ;
      edtSGCitaDisponibilidadId_Visible = -1 ;
      cmbCitaTipoDiagnostico.setVisible( -1 );
      edtPacienteNroDocumento_Visible = -1 ;
      edtPacienteNombres_Visible = -1 ;
      edtPacienteApellidoMaterno_Visible = -1 ;
      edtPacienteApellidoPaterno_Visible = -1 ;
      edtPacienteId_Visible = -1 ;
      edtCitaCode_Visible = -1 ;
      edtCitaId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Cita" );
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
      Ddo_grid_Datalistproc = "CitaWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||||Prensuntivo:Prensuntivo,Definitivo:Definitivo,Repetitivo:Repetitivo||||||||||||||R:Registrado,C:Confirmado,A:En Atención,F:Finalizado,X:Cancelado,N:No se presentó|||" ;
      Ddo_grid_Allowmultipleselection = "|||||||T||||||||||||||T|||" ;
      Ddo_grid_Datalisttype = "|Dynamic||Dynamic|Dynamic|Dynamic|Dynamic|FixedValues||||||Dynamic||Dynamic||Dynamic||Dynamic|Dynamic|FixedValues|Dynamic|Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "|T||T|T|T|T|T||||||T||T||T||T|T|T|T|T|T" ;
      Ddo_grid_Filterisrange = "T||T||||||T|P|P|P|T||T||T||T||||||" ;
      Ddo_grid_Filtertype = "Numeric|Character|Numeric|Character|Character|Character|Character||Numeric|Date|Date|Date|Numeric|Character|Numeric|Character|Numeric|Character|Numeric|Character|Character||Character|Character|Character" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T||T|T|T|T|T|T|T|T|T|T|T|T|T||T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25" ;
      Ddo_grid_Columnids = "2:CitaId|3:CitaCode|4:PacienteId|5:PacienteApellidoPaterno|6:PacienteApellidoMaterno|7:PacienteNombres|8:PacienteNroDocumento|9:CitaTipoDiagnostico|10:SGCitaDisponibilidadId|11:SGCitaDisponibilidadFecha|12:SGCitaDisponibilidadHoraInicio|13:SGCitaDisponibilidadHoraFin|14:SGCitaDisponibilidadEspecialidadId|15:SGCitaDisponibilidadEspecialidadNombre|16:SGCitaDisponibilidadSedeId|17:SGCitaDisponibilidadSedeNombre|18:SGCitaDisponibilidadClinicaId|19:SGCitaDisponibilidadClinicaNombre|20:SGCitaDisponibilidadProfesionalId|21:SGCitaDisponibilidadProFullName|22:SGCitaDisponibilidadProCOP|23:CitaEstadoCita|24:CitaInforme|25:CitaAntecedentes|26:CitaLink" ;
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
      GXCCtl = "CITATIPODIAGNOSTICO_" + sGXsfl_43_idx ;
      cmbCitaTipoDiagnostico.setName( GXCCtl );
      cmbCitaTipoDiagnostico.setWebtags( "" );
      cmbCitaTipoDiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
      cmbCitaTipoDiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
      cmbCitaTipoDiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
      if ( cmbCitaTipoDiagnostico.getItemCount() > 0 )
      {
         A65CitaTipoDiagnostico = cmbCitaTipoDiagnostico.getValidValue(A65CitaTipoDiagnostico) ;
         n65CitaTipoDiagnostico = false ;
      }
      GXCCtl = "CITAESTADOCITA_" + sGXsfl_43_idx ;
      cmbCitaEstadoCita.setName( GXCCtl );
      cmbCitaEstadoCita.setWebtags( "" );
      cmbCitaEstadoCita.addItem("R", "Registrado", (short)(0));
      cmbCitaEstadoCita.addItem("C", "Confirmado", (short)(0));
      cmbCitaEstadoCita.addItem("A", "En Atención", (short)(0));
      cmbCitaEstadoCita.addItem("F", "Finalizado", (short)(0));
      cmbCitaEstadoCita.addItem("X", "Cancelado", (short)(0));
      cmbCitaEstadoCita.addItem("N", "No se presentó", (short)(0));
      if ( cmbCitaEstadoCita.getItemCount() > 0 )
      {
         A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
         n89CitaEstadoCita = false ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtCitaCode_Visible',ctrl:'CITACODE',prop:'Visible'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtPacienteNroDocumento_Visible',ctrl:'PACIENTENRODOCUMENTO',prop:'Visible'},{av:'cmbCitaTipoDiagnostico'},{av:'edtSGCitaDisponibilidadId_Visible',ctrl:'SGCITADISPONIBILIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtSGCitaDisponibilidadHoraInicio_Visible',ctrl:'SGCITADISPONIBILIDADHORAINICIO',prop:'Visible'},{av:'edtSGCitaDisponibilidadHoraFin_Visible',ctrl:'SGCITADISPONIBILIDADHORAFIN',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadId_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadSedeId_Visible',ctrl:'SGCITADISPONIBILIDADSEDEID',prop:'Visible'},{av:'edtSGCitaDisponibilidadSedeNombre_Visible',ctrl:'SGCITADISPONIBILIDADSEDENOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaId_Visible',ctrl:'SGCITADISPONIBILIDADCLINICAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaNombre_Visible',ctrl:'SGCITADISPONIBILIDADCLINICANOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadProfesionalId_Visible',ctrl:'SGCITADISPONIBILIDADPROFESIONALID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProFullName_Visible',ctrl:'SGCITADISPONIBILIDADPROFULLNAME',prop:'Visible'},{av:'edtSGCitaDisponibilidadProCOP_Visible',ctrl:'SGCITADISPONIBILIDADPROCOP',prop:'Visible'},{av:'cmbCitaEstadoCita'},{av:'edtCitaInforme_Visible',ctrl:'CITAINFORME',prop:'Visible'},{av:'edtCitaAntecedentes_Visible',ctrl:'CITAANTECEDENTES',prop:'Visible'},{av:'edtCitaLink_Visible',ctrl:'CITALINK',prop:'Visible'},{av:'AV85GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV86GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e211H2',iparms:[{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'A70SGCitaDisponibilidadEspecialidadId',fld:'SGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'A72SGCitaDisponibilidadSedeId',fld:'SGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'A91CitaLink',fld:'CITALINK',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV91Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV92Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtCitaCode_Link',ctrl:'CITACODE',prop:'Link'},{av:'edtPacienteNombres_Link',ctrl:'PACIENTENOMBRES',prop:'Link'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Link',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Link'},{av:'edtSGCitaDisponibilidadSedeNombre_Link',ctrl:'SGCITADISPONIBILIDADSEDENOMBRE',prop:'Link'},{av:'edtCitaLink_Linktarget',ctrl:'CITALINK',prop:'Linktarget'},{av:'edtCitaLink_Link',ctrl:'CITALINK',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e151H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtCitaCode_Visible',ctrl:'CITACODE',prop:'Visible'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtPacienteNroDocumento_Visible',ctrl:'PACIENTENRODOCUMENTO',prop:'Visible'},{av:'cmbCitaTipoDiagnostico'},{av:'edtSGCitaDisponibilidadId_Visible',ctrl:'SGCITADISPONIBILIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtSGCitaDisponibilidadHoraInicio_Visible',ctrl:'SGCITADISPONIBILIDADHORAINICIO',prop:'Visible'},{av:'edtSGCitaDisponibilidadHoraFin_Visible',ctrl:'SGCITADISPONIBILIDADHORAFIN',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadId_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadSedeId_Visible',ctrl:'SGCITADISPONIBILIDADSEDEID',prop:'Visible'},{av:'edtSGCitaDisponibilidadSedeNombre_Visible',ctrl:'SGCITADISPONIBILIDADSEDENOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaId_Visible',ctrl:'SGCITADISPONIBILIDADCLINICAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaNombre_Visible',ctrl:'SGCITADISPONIBILIDADCLINICANOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadProfesionalId_Visible',ctrl:'SGCITADISPONIBILIDADPROFESIONALID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProFullName_Visible',ctrl:'SGCITADISPONIBILIDADPROFULLNAME',prop:'Visible'},{av:'edtSGCitaDisponibilidadProCOP_Visible',ctrl:'SGCITADISPONIBILIDADPROCOP',prop:'Visible'},{av:'cmbCitaEstadoCita'},{av:'edtCitaInforme_Visible',ctrl:'CITAINFORME',prop:'Visible'},{av:'edtCitaAntecedentes_Visible',ctrl:'CITAANTECEDENTES',prop:'Visible'},{av:'edtCitaLink_Visible',ctrl:'CITALINK',prop:'Visible'},{av:'AV85GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV86GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV112DDO_SGCitaDisponibilidadHoraFinAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV112DDO_SGCitaDisponibilidadHoraFinAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtCitaCode_Visible',ctrl:'CITACODE',prop:'Visible'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtPacienteNroDocumento_Visible',ctrl:'PACIENTENRODOCUMENTO',prop:'Visible'},{av:'cmbCitaTipoDiagnostico'},{av:'edtSGCitaDisponibilidadId_Visible',ctrl:'SGCITADISPONIBILIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtSGCitaDisponibilidadHoraInicio_Visible',ctrl:'SGCITADISPONIBILIDADHORAINICIO',prop:'Visible'},{av:'edtSGCitaDisponibilidadHoraFin_Visible',ctrl:'SGCITADISPONIBILIDADHORAFIN',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadId_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadSedeId_Visible',ctrl:'SGCITADISPONIBILIDADSEDEID',prop:'Visible'},{av:'edtSGCitaDisponibilidadSedeNombre_Visible',ctrl:'SGCITADISPONIBILIDADSEDENOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaId_Visible',ctrl:'SGCITADISPONIBILIDADCLINICAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaNombre_Visible',ctrl:'SGCITADISPONIBILIDADCLINICANOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadProfesionalId_Visible',ctrl:'SGCITADISPONIBILIDADPROFESIONALID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProFullName_Visible',ctrl:'SGCITADISPONIBILIDADPROFULLNAME',prop:'Visible'},{av:'edtSGCitaDisponibilidadProCOP_Visible',ctrl:'SGCITADISPONIBILIDADPROCOP',prop:'Visible'},{av:'cmbCitaEstadoCita'},{av:'edtCitaInforme_Visible',ctrl:'CITAINFORME',prop:'Visible'},{av:'edtCitaAntecedentes_Visible',ctrl:'CITAANTECEDENTES',prop:'Visible'},{av:'edtCitaLink_Visible',ctrl:'CITALINK',prop:'Visible'},{av:'AV85GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV86GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e161H2',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e171H2',iparms:[{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV112DDO_SGCitaDisponibilidadHoraFinAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV112DDO_SGCitaDisponibilidadHoraFinAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e181H2',iparms:[{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV112DDO_SGCitaDisponibilidadHoraFinAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV28TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV30TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV31TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV32TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV34TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV36TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV38TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV39TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV40TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV109TFCitaTipoDiagnostico_Sels',fld:'vTFCITATIPODIAGNOSTICO_SELS',pic:''},{av:'AV49TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV50TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV52TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV56TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV57TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV110TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV111TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV62TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV63TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV65TFSGCitaDisponibilidadSedeId',fld:'vTFSGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'AV66TFSGCitaDisponibilidadSedeId_To',fld:'vTFSGCITADISPONIBILIDADSEDEID_TO',pic:'ZZZ9'},{av:'AV67TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV96TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV69TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV70TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV71TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV97TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV73TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV74TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV75TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV76TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV77TFSGCitaDisponibilidadProCOP',fld:'vTFSGCITADISPONIBILIDADPROCOP',pic:''},{av:'AV78TFSGCitaDisponibilidadProCOP_Sel',fld:'vTFSGCITADISPONIBILIDADPROCOP_SEL',pic:''},{av:'AV80TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV81TFCitaInforme',fld:'vTFCITAINFORME',pic:''},{av:'AV82TFCitaInforme_Sel',fld:'vTFCITAINFORME_SEL',pic:''},{av:'AV99TFCitaAntecedentes',fld:'vTFCITAANTECEDENTES',pic:''},{av:'AV100TFCitaAntecedentes_Sel',fld:'vTFCITAANTECEDENTES_SEL',pic:''},{av:'AV101TFCitaLink',fld:'vTFCITALINK',pic:''},{av:'AV102TFCitaLink_Sel',fld:'vTFCITALINK_SEL',pic:''},{av:'AV166Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV88IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV89IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV93IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:'',hsh:true},{av:'AV98IsAuthorized_SGCitaDisponibilidadSedeNombre',fld:'vISAUTHORIZED_SGCITADISPONIBILIDADSEDENOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV79TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV112DDO_SGCitaDisponibilidadHoraFinAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE',pic:''},{av:'AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO',pic:''},{av:'AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE',pic:''},{av:'AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo',fld:'vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO',pic:''},{av:'AV108TFCitaTipoDiagnostico_SelsJson',fld:'vTFCITATIPODIAGNOSTICO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID","{handler:'valid_Sgcitadisponibilidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID","{handler:'valid_Sgcitadisponibilidadespecialidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADSEDEID","{handler:'valid_Sgcitadisponibilidadsedeid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADSEDEID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID","{handler:'valid_Sgcitadisponibilidadclinicaid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID","{handler:'valid_Sgcitadisponibilidadprofesionalid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Citalink',iparms:[]");
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
      AV29TFCitaCode = "" ;
      AV30TFCitaCode_Sel = "" ;
      AV33TFPacienteApellidoPaterno = "" ;
      AV34TFPacienteApellidoPaterno_Sel = "" ;
      AV35TFPacienteApellidoMaterno = "" ;
      AV36TFPacienteApellidoMaterno_Sel = "" ;
      AV37TFPacienteNombres = "" ;
      AV38TFPacienteNombres_Sel = "" ;
      AV39TFPacienteNroDocumento = "" ;
      AV40TFPacienteNroDocumento_Sel = "" ;
      AV109TFCitaTipoDiagnostico_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV52TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV56TFSGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV57TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV110TFSGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV111TFSGCitaDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV63TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV67TFSGCitaDisponibilidadSedeNombre = "" ;
      AV96TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      AV71TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV97TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV75TFSGCitaDisponibilidadProFullName = "" ;
      AV76TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV77TFSGCitaDisponibilidadProCOP = "" ;
      AV78TFSGCitaDisponibilidadProCOP_Sel = "" ;
      AV80TFCitaEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81TFCitaInforme = "" ;
      AV82TFCitaInforme_Sel = "" ;
      AV99TFCitaAntecedentes = "" ;
      AV100TFCitaAntecedentes_Sel = "" ;
      AV101TFCitaLink = "" ;
      AV102TFCitaLink_Sel = "" ;
      AV166Pgmname = "" ;
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
      AV83DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV54DDO_SGCitaDisponibilidadFechaAuxDateTo = GXutil.nullDate() ;
      AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo = GXutil.nullDate() ;
      AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV108TFCitaTipoDiagnostico_SelsJson = "" ;
      AV79TFCitaEstadoCita_SelsJson = "" ;
      AV53DDO_SGCitaDisponibilidadFechaAuxDate = GXutil.nullDate() ;
      AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate = GXutil.nullDate() ;
      AV112DDO_SGCitaDisponibilidadHoraFinAuxDate = GXutil.nullDate() ;
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
      AV91Update = "" ;
      AV92Delete = "" ;
      A64CitaCode = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A65CitaTipoDiagnostico = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A89CitaEstadoCita = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A91CitaLink = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV55DDO_SGCitaDisponibilidadFechaAuxDateText = "" ;
      ucTfsgcitadisponibilidadfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText = "" ;
      ucTfsgcitadisponibilidadhorainicio_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText = "" ;
      ucTfsgcitadisponibilidadhorafin_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV132Citawwds_16_tfcitatipodiagnostico_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV159Citawwds_43_tfcitaestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV117Citawwds_1_filterfulltext = "" ;
      lV120Citawwds_4_tfcitacode = "" ;
      lV124Citawwds_8_tfpacienteapellidopaterno = "" ;
      lV126Citawwds_10_tfpacienteapellidomaterno = "" ;
      lV128Citawwds_12_tfpacientenombres = "" ;
      lV130Citawwds_14_tfpacientenrodocumento = "" ;
      lV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV147Citawwds_31_tfsgcitadisponibilidadsedenombre = "" ;
      lV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = "" ;
      lV155Citawwds_39_tfsgcitadisponibilidadprofullname = "" ;
      lV157Citawwds_41_tfsgcitadisponibilidadprocop = "" ;
      lV160Citawwds_44_tfcitainforme = "" ;
      lV162Citawwds_46_tfcitaantecedentes = "" ;
      lV164Citawwds_48_tfcitalink = "" ;
      AV117Citawwds_1_filterfulltext = "" ;
      AV121Citawwds_5_tfcitacode_sel = "" ;
      AV120Citawwds_4_tfcitacode = "" ;
      AV125Citawwds_9_tfpacienteapellidopaterno_sel = "" ;
      AV124Citawwds_8_tfpacienteapellidopaterno = "" ;
      AV127Citawwds_11_tfpacienteapellidomaterno_sel = "" ;
      AV126Citawwds_10_tfpacienteapellidomaterno = "" ;
      AV129Citawwds_13_tfpacientenombres_sel = "" ;
      AV128Citawwds_12_tfpacientenombres = "" ;
      AV131Citawwds_15_tfpacientenrodocumento_sel = "" ;
      AV130Citawwds_14_tfpacientenrodocumento = "" ;
      AV135Citawwds_19_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV136Citawwds_20_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV137Citawwds_21_tfsgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV139Citawwds_23_tfsgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = "" ;
      AV147Citawwds_31_tfsgcitadisponibilidadsedenombre = "" ;
      AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre = "" ;
      AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV155Citawwds_39_tfsgcitadisponibilidadprofullname = "" ;
      AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel = "" ;
      AV157Citawwds_41_tfsgcitadisponibilidadprocop = "" ;
      AV161Citawwds_45_tfcitainforme_sel = "" ;
      AV160Citawwds_44_tfcitainforme = "" ;
      AV163Citawwds_47_tfcitaantecedentes_sel = "" ;
      AV162Citawwds_46_tfcitaantecedentes = "" ;
      AV165Citawwds_49_tfcitalink_sel = "" ;
      AV164Citawwds_48_tfcitalink = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      H001H2_A91CitaLink = new String[] {""} ;
      H001H2_n91CitaLink = new boolean[] {false} ;
      H001H2_A100CitaAntecedentes = new String[] {""} ;
      H001H2_n100CitaAntecedentes = new boolean[] {false} ;
      H001H2_A90CitaInforme = new String[] {""} ;
      H001H2_n90CitaInforme = new boolean[] {false} ;
      H001H2_A89CitaEstadoCita = new String[] {""} ;
      H001H2_n89CitaEstadoCita = new boolean[] {false} ;
      H001H2_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      H001H2_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      H001H2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      H001H2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      H001H2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      H001H2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      H001H2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      H001H2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      H001H2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      H001H2_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H001H2_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      H001H2_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H001H2_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      H001H2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H001H2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H001H2_A21SGCitaDisponibilidadId = new int[1] ;
      H001H2_A65CitaTipoDiagnostico = new String[] {""} ;
      H001H2_n65CitaTipoDiagnostico = new boolean[] {false} ;
      H001H2_A106PacienteNroDocumento = new String[] {""} ;
      H001H2_A105PacienteNombres = new String[] {""} ;
      H001H2_A104PacienteApellidoMaterno = new String[] {""} ;
      H001H2_A103PacienteApellidoPaterno = new String[] {""} ;
      H001H2_A20PacienteId = new int[1] ;
      H001H2_A64CitaCode = new String[] {""} ;
      H001H2_A19CitaId = new int[1] ;
      H001H2_A84ProfesionalNombres = new String[] {""} ;
      H001H2_n84ProfesionalNombres = new boolean[] {false} ;
      H001H2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H001H2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      H001H2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H001H2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      H001H3_AGRID_nRecordCount = new long[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citaww__default(),
         new Object[] {
             new Object[] {
            H001H2_A91CitaLink, H001H2_n91CitaLink, H001H2_A100CitaAntecedentes, H001H2_n100CitaAntecedentes, H001H2_A90CitaInforme, H001H2_n90CitaInforme, H001H2_A89CitaEstadoCita, H001H2_n89CitaEstadoCita, H001H2_A87SGCitaDisponibilidadProCOP, H001H2_A82SGCitaDisponibilidadProFullName,
            H001H2_A81SGCitaDisponibilidadProfesionalId, H001H2_A78SGCitaDisponibilidadClinicaNombre, H001H2_A76SGCitaDisponibilidadClinicaId, H001H2_A73SGCitaDisponibilidadSedeNombre, H001H2_A72SGCitaDisponibilidadSedeId, H001H2_A146SGCitaDisponibilidadEspecialidadNombre, H001H2_A70SGCitaDisponibilidadEspecialidadId, H001H2_A387SGCitaDisponibilidadHoraFin, H001H2_n387SGCitaDisponibilidadHoraFin, H001H2_A68SGCitaDisponibilidadHoraInicio,
            H001H2_n68SGCitaDisponibilidadHoraInicio, H001H2_A66SGCitaDisponibilidadFecha, H001H2_n66SGCitaDisponibilidadFecha, H001H2_A21SGCitaDisponibilidadId, H001H2_A65CitaTipoDiagnostico, H001H2_n65CitaTipoDiagnostico, H001H2_A106PacienteNroDocumento, H001H2_A105PacienteNombres, H001H2_A104PacienteApellidoMaterno, H001H2_A103PacienteApellidoPaterno,
            H001H2_A20PacienteId, H001H2_A64CitaCode, H001H2_A19CitaId, H001H2_A84ProfesionalNombres, H001H2_n84ProfesionalNombres, H001H2_A85ProfesionalApellidoPaterno, H001H2_n85ProfesionalApellidoPaterno, H001H2_A86ProfesionalApellidoMaterno, H001H2_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            H001H3_AGRID_nRecordCount
            }
         }
      );
      AV166Pgmname = "CitaWW" ;
      /* GeneXus formulas. */
      AV166Pgmname = "CitaWW" ;
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
   private short AV61TFSGCitaDisponibilidadEspecialidadId ;
   private short AV62TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV65TFSGCitaDisponibilidadSedeId ;
   private short AV66TFSGCitaDisponibilidadSedeId_To ;
   private short AV69TFSGCitaDisponibilidadClinicaId ;
   private short AV70TFSGCitaDisponibilidadClinicaId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid ;
   private short AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV145Citawwds_29_tfsgcitadisponibilidadsedeid ;
   private short AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to ;
   private short AV149Citawwds_33_tfsgcitadisponibilidadclinicaid ;
   private short AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV27TFCitaId ;
   private int AV28TFCitaId_To ;
   private int AV31TFPacienteId ;
   private int AV32TFPacienteId_To ;
   private int AV49TFSGCitaDisponibilidadId ;
   private int AV50TFSGCitaDisponibilidadId_To ;
   private int AV73TFSGCitaDisponibilidadProfesionalId ;
   private int AV74TFSGCitaDisponibilidadProfesionalId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtCitaId_Visible ;
   private int edtCitaCode_Visible ;
   private int edtPacienteId_Visible ;
   private int edtPacienteApellidoPaterno_Visible ;
   private int edtPacienteApellidoMaterno_Visible ;
   private int edtPacienteNombres_Visible ;
   private int edtPacienteNroDocumento_Visible ;
   private int edtSGCitaDisponibilidadId_Visible ;
   private int edtSGCitaDisponibilidadFecha_Visible ;
   private int edtSGCitaDisponibilidadHoraInicio_Visible ;
   private int edtSGCitaDisponibilidadHoraFin_Visible ;
   private int edtSGCitaDisponibilidadEspecialidadId_Visible ;
   private int edtSGCitaDisponibilidadEspecialidadNombre_Visible ;
   private int edtSGCitaDisponibilidadSedeId_Visible ;
   private int edtSGCitaDisponibilidadSedeNombre_Visible ;
   private int edtSGCitaDisponibilidadClinicaId_Visible ;
   private int edtSGCitaDisponibilidadClinicaNombre_Visible ;
   private int edtSGCitaDisponibilidadProfesionalId_Visible ;
   private int edtSGCitaDisponibilidadProFullName_Visible ;
   private int edtSGCitaDisponibilidadProCOP_Visible ;
   private int edtCitaInforme_Visible ;
   private int edtCitaAntecedentes_Visible ;
   private int edtCitaLink_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV132Citawwds_16_tfcitatipodiagnostico_sels_size ;
   private int AV159Citawwds_43_tfcitaestadocita_sels_size ;
   private int AV118Citawwds_2_tfcitaid ;
   private int AV119Citawwds_3_tfcitaid_to ;
   private int AV122Citawwds_6_tfpacienteid ;
   private int AV123Citawwds_7_tfpacienteid_to ;
   private int AV133Citawwds_17_tfsgcitadisponibilidadid ;
   private int AV134Citawwds_18_tfsgcitadisponibilidadid_to ;
   private int AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid ;
   private int AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV84PageToGo ;
   private int AV167GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV85GridCurrentPage ;
   private long AV86GridPageCount ;
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
   private String AV166Pgmname ;
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
   private String AV91Update ;
   private String edtavUpdate_Link ;
   private String AV92Delete ;
   private String edtavDelete_Link ;
   private String edtCitaCode_Link ;
   private String edtPacienteNombres_Link ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Link ;
   private String edtSGCitaDisponibilidadSedeNombre_Link ;
   private String A89CitaEstadoCita ;
   private String edtCitaLink_Link ;
   private String edtCitaLink_Linktarget ;
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
   private String divDdo_sgcitadisponibilidadhorainicioauxdates_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Jsonclick ;
   private String Tfsgcitadisponibilidadhorainicio_rangepicker_Internalname ;
   private String divDdo_sgcitadisponibilidadhorafinauxdates_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Jsonclick ;
   private String Tfsgcitadisponibilidadhorafin_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtCitaCode_Internalname ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtSGCitaDisponibilidadId_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadHoraInicio_Internalname ;
   private String edtSGCitaDisponibilidadHoraFin_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadId_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Internalname ;
   private String edtSGCitaDisponibilidadSedeId_Internalname ;
   private String edtSGCitaDisponibilidadSedeNombre_Internalname ;
   private String edtSGCitaDisponibilidadClinicaId_Internalname ;
   private String edtSGCitaDisponibilidadClinicaNombre_Internalname ;
   private String edtSGCitaDisponibilidadProfesionalId_Internalname ;
   private String edtSGCitaDisponibilidadProFullName_Internalname ;
   private String edtSGCitaDisponibilidadProCOP_Internalname ;
   private String edtCitaInforme_Internalname ;
   private String edtCitaAntecedentes_Internalname ;
   private String edtCitaLink_Internalname ;
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
   private String edtCitaId_Jsonclick ;
   private String edtCitaCode_Jsonclick ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String GXCCtl ;
   private String edtSGCitaDisponibilidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtSGCitaDisponibilidadHoraInicio_Jsonclick ;
   private String edtSGCitaDisponibilidadHoraFin_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeId_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaId_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadProfesionalId_Jsonclick ;
   private String edtSGCitaDisponibilidadProFullName_Jsonclick ;
   private String edtSGCitaDisponibilidadProCOP_Jsonclick ;
   private String edtCitaInforme_Jsonclick ;
   private String edtCitaAntecedentes_Jsonclick ;
   private String edtCitaLink_Jsonclick ;
   private java.util.Date AV56TFSGCitaDisponibilidadHoraInicio ;
   private java.util.Date AV57TFSGCitaDisponibilidadHoraInicio_To ;
   private java.util.Date AV110TFSGCitaDisponibilidadHoraFin ;
   private java.util.Date AV111TFSGCitaDisponibilidadHoraFin_To ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date AV137Citawwds_21_tfsgcitadisponibilidadhorainicio ;
   private java.util.Date AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to ;
   private java.util.Date AV139Citawwds_23_tfsgcitadisponibilidadhorafin ;
   private java.util.Date AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to ;
   private java.util.Date AV51TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV52TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV54DDO_SGCitaDisponibilidadFechaAuxDateTo ;
   private java.util.Date AV59DDO_SGCitaDisponibilidadHoraInicioAuxDateTo ;
   private java.util.Date AV113DDO_SGCitaDisponibilidadHoraFinAuxDateTo ;
   private java.util.Date AV53DDO_SGCitaDisponibilidadFechaAuxDate ;
   private java.util.Date AV58DDO_SGCitaDisponibilidadHoraInicioAuxDate ;
   private java.util.Date AV112DDO_SGCitaDisponibilidadHoraFinAuxDate ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV135Citawwds_19_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV136Citawwds_20_tfsgcitadisponibilidadfecha_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV88IsAuthorized_Update ;
   private boolean AV89IsAuthorized_Delete ;
   private boolean AV93IsAuthorized_PacienteNombres ;
   private boolean AV95IsAuthorized_SGCitaDisponibilidadEspecialidadNombre ;
   private boolean AV98IsAuthorized_SGCitaDisponibilidadSedeNombre ;
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
   private boolean n65CitaTipoDiagnostico ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n89CitaEstadoCita ;
   private boolean n90CitaInforme ;
   private boolean n100CitaAntecedentes ;
   private boolean n91CitaLink ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV90TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV108TFCitaTipoDiagnostico_SelsJson ;
   private String AV79TFCitaEstadoCita_SelsJson ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV29TFCitaCode ;
   private String AV30TFCitaCode_Sel ;
   private String AV33TFPacienteApellidoPaterno ;
   private String AV34TFPacienteApellidoPaterno_Sel ;
   private String AV35TFPacienteApellidoMaterno ;
   private String AV36TFPacienteApellidoMaterno_Sel ;
   private String AV37TFPacienteNombres ;
   private String AV38TFPacienteNombres_Sel ;
   private String AV39TFPacienteNroDocumento ;
   private String AV40TFPacienteNroDocumento_Sel ;
   private String AV63TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV64TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV67TFSGCitaDisponibilidadSedeNombre ;
   private String AV96TFSGCitaDisponibilidadSedeNombre_Sel ;
   private String AV71TFSGCitaDisponibilidadClinicaNombre ;
   private String AV97TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV75TFSGCitaDisponibilidadProFullName ;
   private String AV76TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV77TFSGCitaDisponibilidadProCOP ;
   private String AV78TFSGCitaDisponibilidadProCOP_Sel ;
   private String AV81TFCitaInforme ;
   private String AV82TFCitaInforme_Sel ;
   private String AV99TFCitaAntecedentes ;
   private String AV100TFCitaAntecedentes_Sel ;
   private String AV101TFCitaLink ;
   private String AV102TFCitaLink_Sel ;
   private String A64CitaCode ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A65CitaTipoDiagnostico ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String A91CitaLink ;
   private String AV55DDO_SGCitaDisponibilidadFechaAuxDateText ;
   private String AV60DDO_SGCitaDisponibilidadHoraInicioAuxDateText ;
   private String AV114DDO_SGCitaDisponibilidadHoraFinAuxDateText ;
   private String lV117Citawwds_1_filterfulltext ;
   private String lV120Citawwds_4_tfcitacode ;
   private String lV124Citawwds_8_tfpacienteapellidopaterno ;
   private String lV126Citawwds_10_tfpacienteapellidomaterno ;
   private String lV128Citawwds_12_tfpacientenombres ;
   private String lV130Citawwds_14_tfpacientenrodocumento ;
   private String lV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV147Citawwds_31_tfsgcitadisponibilidadsedenombre ;
   private String lV151Citawwds_35_tfsgcitadisponibilidadclinicanombre ;
   private String lV155Citawwds_39_tfsgcitadisponibilidadprofullname ;
   private String lV157Citawwds_41_tfsgcitadisponibilidadprocop ;
   private String lV160Citawwds_44_tfcitainforme ;
   private String lV162Citawwds_46_tfcitaantecedentes ;
   private String lV164Citawwds_48_tfcitalink ;
   private String AV117Citawwds_1_filterfulltext ;
   private String AV121Citawwds_5_tfcitacode_sel ;
   private String AV120Citawwds_4_tfcitacode ;
   private String AV125Citawwds_9_tfpacienteapellidopaterno_sel ;
   private String AV124Citawwds_8_tfpacienteapellidopaterno ;
   private String AV127Citawwds_11_tfpacienteapellidomaterno_sel ;
   private String AV126Citawwds_10_tfpacienteapellidomaterno ;
   private String AV129Citawwds_13_tfpacientenombres_sel ;
   private String AV128Citawwds_12_tfpacientenombres ;
   private String AV131Citawwds_15_tfpacientenrodocumento_sel ;
   private String AV130Citawwds_14_tfpacientenrodocumento ;
   private String AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ;
   private String AV147Citawwds_31_tfsgcitadisponibilidadsedenombre ;
   private String AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre ;
   private String AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel ;
   private String AV155Citawwds_39_tfsgcitadisponibilidadprofullname ;
   private String AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel ;
   private String AV157Citawwds_41_tfsgcitadisponibilidadprocop ;
   private String AV161Citawwds_45_tfcitainforme_sel ;
   private String AV160Citawwds_44_tfcitainforme ;
   private String AV163Citawwds_47_tfcitaantecedentes_sel ;
   private String AV162Citawwds_46_tfcitaantecedentes ;
   private String AV165Citawwds_49_tfcitalink_sel ;
   private String AV164Citawwds_48_tfcitalink ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
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
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadhorainicio_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadhorafin_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV159Citawwds_43_tfcitaestadocita_sels ;
   private GXSimpleCollection<String> AV132Citawwds_16_tfcitatipodiagnostico_sels ;
   private HTMLChoice cmbCitaTipoDiagnostico ;
   private HTMLChoice cmbCitaEstadoCita ;
   private IDataStoreProvider pr_default ;
   private String[] H001H2_A91CitaLink ;
   private boolean[] H001H2_n91CitaLink ;
   private String[] H001H2_A100CitaAntecedentes ;
   private boolean[] H001H2_n100CitaAntecedentes ;
   private String[] H001H2_A90CitaInforme ;
   private boolean[] H001H2_n90CitaInforme ;
   private String[] H001H2_A89CitaEstadoCita ;
   private boolean[] H001H2_n89CitaEstadoCita ;
   private String[] H001H2_A87SGCitaDisponibilidadProCOP ;
   private String[] H001H2_A82SGCitaDisponibilidadProFullName ;
   private int[] H001H2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] H001H2_A78SGCitaDisponibilidadClinicaNombre ;
   private short[] H001H2_A76SGCitaDisponibilidadClinicaId ;
   private String[] H001H2_A73SGCitaDisponibilidadSedeNombre ;
   private short[] H001H2_A72SGCitaDisponibilidadSedeId ;
   private String[] H001H2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] H001H2_A70SGCitaDisponibilidadEspecialidadId ;
   private java.util.Date[] H001H2_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] H001H2_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] H001H2_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] H001H2_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] H001H2_A66SGCitaDisponibilidadFecha ;
   private boolean[] H001H2_n66SGCitaDisponibilidadFecha ;
   private int[] H001H2_A21SGCitaDisponibilidadId ;
   private String[] H001H2_A65CitaTipoDiagnostico ;
   private boolean[] H001H2_n65CitaTipoDiagnostico ;
   private String[] H001H2_A106PacienteNroDocumento ;
   private String[] H001H2_A105PacienteNombres ;
   private String[] H001H2_A104PacienteApellidoMaterno ;
   private String[] H001H2_A103PacienteApellidoPaterno ;
   private int[] H001H2_A20PacienteId ;
   private String[] H001H2_A64CitaCode ;
   private int[] H001H2_A19CitaId ;
   private String[] H001H2_A84ProfesionalNombres ;
   private boolean[] H001H2_n84ProfesionalNombres ;
   private String[] H001H2_A85ProfesionalApellidoPaterno ;
   private boolean[] H001H2_n85ProfesionalApellidoPaterno ;
   private String[] H001H2_A86ProfesionalApellidoMaterno ;
   private boolean[] H001H2_n86ProfesionalApellidoMaterno ;
   private long[] H001H3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV80TFCitaEstadoCita_Sels ;
   private GXSimpleCollection<String> AV109TFCitaTipoDiagnostico_Sels ;
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
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV83DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class citaww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A65CitaTipoDiagnostico ,
                                          GXSimpleCollection<String> AV132Citawwds_16_tfcitatipodiagnostico_sels ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV159Citawwds_43_tfcitaestadocita_sels ,
                                          String AV117Citawwds_1_filterfulltext ,
                                          int AV118Citawwds_2_tfcitaid ,
                                          int AV119Citawwds_3_tfcitaid_to ,
                                          String AV121Citawwds_5_tfcitacode_sel ,
                                          String AV120Citawwds_4_tfcitacode ,
                                          int AV122Citawwds_6_tfpacienteid ,
                                          int AV123Citawwds_7_tfpacienteid_to ,
                                          String AV125Citawwds_9_tfpacienteapellidopaterno_sel ,
                                          String AV124Citawwds_8_tfpacienteapellidopaterno ,
                                          String AV127Citawwds_11_tfpacienteapellidomaterno_sel ,
                                          String AV126Citawwds_10_tfpacienteapellidomaterno ,
                                          String AV129Citawwds_13_tfpacientenombres_sel ,
                                          String AV128Citawwds_12_tfpacientenombres ,
                                          String AV131Citawwds_15_tfpacientenrodocumento_sel ,
                                          String AV130Citawwds_14_tfpacientenrodocumento ,
                                          int AV132Citawwds_16_tfcitatipodiagnostico_sels_size ,
                                          int AV133Citawwds_17_tfsgcitadisponibilidadid ,
                                          int AV134Citawwds_18_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV135Citawwds_19_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV136Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV137Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                          java.util.Date AV139Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                          short AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid ,
                                          short AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                          short AV145Citawwds_29_tfsgcitadisponibilidadsedeid ,
                                          short AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to ,
                                          String AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV147Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                          short AV149Citawwds_33_tfsgcitadisponibilidadclinicaid ,
                                          short AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                          int AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid ,
                                          int AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV155Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                          String AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                          String AV157Citawwds_41_tfsgcitadisponibilidadprocop ,
                                          int AV159Citawwds_43_tfcitaestadocita_sels_size ,
                                          String AV161Citawwds_45_tfcitainforme_sel ,
                                          String AV160Citawwds_44_tfcitainforme ,
                                          String AV163Citawwds_47_tfcitaantecedentes_sel ,
                                          String AV162Citawwds_46_tfcitaantecedentes ,
                                          String AV165Citawwds_49_tfcitalink_sel ,
                                          String AV164Citawwds_48_tfcitalink ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          int A21SGCitaDisponibilidadId ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          short A72SGCitaDisponibilidadSedeId ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A87SGCitaDisponibilidadProCOP ,
                                          String A90CitaInforme ,
                                          String A100CitaAntecedentes ,
                                          String A91CitaLink ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int41 = new byte[78];
      Object[] GXv_Object42 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[CitaLink], T1.[CitaAntecedentes], T1.[CitaInforme], T1.[CitaEstadoCita], T3.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, COALESCE( T3.[ProfesionalNombres]," ;
      sSelectString += " '') + ' ' + COALESCE( T3.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T3.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T2.[ProfesionalId]" ;
      sSelectString += " AS SGCitaDisponibilidadProfesionalId, T5.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T4.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T4.[SedeNombre]" ;
      sSelectString += " AS SGCitaDisponibilidadSedeNombre, T2.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T6.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre," ;
      sSelectString += " T2.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T2.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T2.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio," ;
      sSelectString += " T2.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[CitaTipoDiagnostico], T7.[PacienteNroDocumento]," ;
      sSelectString += " T7.[PacienteNombres], T7.[PacienteApellidoMaterno], T7.[PacienteApellidoPaterno], T1.[PacienteId], T1.[CitaCode], T1.[CitaId], T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno]," ;
      sSelectString += " T3.[ProfesionalApellidoMaterno]" ;
      sFromString = " FROM (((((([Cita] T1 INNER JOIN [Disponibilidad] T2 ON T2.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] =" ;
      sFromString += " T2.[ProfesionalId]) INNER JOIN [Sede] T4 ON T4.[SedeId] = T2.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T5 ON T5.[ClinicaId] = T4.[ClinicaId]) INNER JOIN" ;
      sFromString += " [Especialidad] T6 ON T6.[EspecialidadId] = T2.[EspecialidadId]) INNER JOIN [Paciente] T7 ON T7.[PacienteId] = T1.[PacienteId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV117Citawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T1.[CitaCode] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T7.[PacienteApellidoPaterno] like '%' + ?) or ( T7.[PacienteApellidoMaterno] like '%' + ?) or ( T7.[PacienteNombres] like '%' + ?) or ( T7.[PacienteNroDocumento] like '%' + ?) or ( 'prensuntivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Prensuntivo') or ( 'definitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Definitivo') or ( 'repetitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Repetitivo') or ( CONVERT( char(8), CAST(T1.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T6.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[SGSedeDisponibilidadSedeId] AS decimal(4,0))) like '%' + ?) or ( T4.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T4.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T5.[ClinicaNombreAbreviado] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( T1.[CitaInforme] like '%' + ?) or ( T1.[CitaAntecedentes] like '%' + ?) or ( T1.[CitaLink] like '%' + ?))");
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
      }
      if ( ! (0==AV118Citawwds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int41[29] = (byte)(1) ;
      }
      if ( ! (0==AV119Citawwds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int41[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Citawwds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV120Citawwds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int41[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Citawwds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int41[32] = (byte)(1) ;
      }
      if ( ! (0==AV122Citawwds_6_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int41[33] = (byte)(1) ;
      }
      if ( ! (0==AV123Citawwds_7_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int41[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Citawwds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV124Citawwds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int41[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Citawwds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int41[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Citawwds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV126Citawwds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int41[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Citawwds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int41[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Citawwds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV128Citawwds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int41[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Citawwds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int41[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV131Citawwds_15_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV130Citawwds_14_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int41[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Citawwds_15_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int41[42] = (byte)(1) ;
      }
      if ( AV132Citawwds_16_tfcitatipodiagnostico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Citawwds_16_tfcitatipodiagnostico_sels, "T1.[CitaTipoDiagnostico] IN (", ")")+")");
      }
      if ( ! (0==AV133Citawwds_17_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int41[43] = (byte)(1) ;
      }
      if ( ! (0==AV134Citawwds_18_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int41[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV135Citawwds_19_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int41[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV136Citawwds_20_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int41[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV137Citawwds_21_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int41[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int41[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV139Citawwds_23_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int41[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int41[50] = (byte)(1) ;
      }
      if ( ! (0==AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int41[51] = (byte)(1) ;
      }
      if ( ! (0==AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int41[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int41[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int41[54] = (byte)(1) ;
      }
      if ( ! (0==AV145Citawwds_29_tfsgcitadisponibilidadsedeid) )
      {
         addWhere(sWhereString, "(T2.[SGSedeDisponibilidadSedeId] >= ?)");
      }
      else
      {
         GXv_int41[55] = (byte)(1) ;
      }
      if ( ! (0==AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to) )
      {
         addWhere(sWhereString, "(T2.[SGSedeDisponibilidadSedeId] <= ?)");
      }
      else
      {
         GXv_int41[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV147Citawwds_31_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int41[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int41[58] = (byte)(1) ;
      }
      if ( ! (0==AV149Citawwds_33_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T4.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int41[59] = (byte)(1) ;
      }
      if ( ! (0==AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T4.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int41[60] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int41[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int41[62] = (byte)(1) ;
      }
      if ( ! (0==AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int41[63] = (byte)(1) ;
      }
      if ( ! (0==AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int41[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV155Citawwds_39_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int41[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int41[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) && ( ! (GXutil.strcmp("", AV157Citawwds_41_tfsgcitadisponibilidadprocop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int41[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int41[68] = (byte)(1) ;
      }
      if ( AV159Citawwds_43_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV159Citawwds_43_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV161Citawwds_45_tfcitainforme_sel)==0) && ( ! (GXutil.strcmp("", AV160Citawwds_44_tfcitainforme)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] like ?)");
      }
      else
      {
         GXv_int41[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV161Citawwds_45_tfcitainforme_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] = ?)");
      }
      else
      {
         GXv_int41[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV163Citawwds_47_tfcitaantecedentes_sel)==0) && ( ! (GXutil.strcmp("", AV162Citawwds_46_tfcitaantecedentes)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] like ?)");
      }
      else
      {
         GXv_int41[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV163Citawwds_47_tfcitaantecedentes_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] = ?)");
      }
      else
      {
         GXv_int41[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV165Citawwds_49_tfcitalink_sel)==0) && ( ! (GXutil.strcmp("", AV164Citawwds_48_tfcitalink)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] like ?)");
      }
      else
      {
         GXv_int41[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV165Citawwds_49_tfcitalink_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] = ?)");
      }
      else
      {
         GXv_int41[74] = (byte)(1) ;
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaCode]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T7.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T7.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T7.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T7.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T7.[PacienteNombres]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T7.[PacienteNombres] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T7.[PacienteNroDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T7.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaTipoDiagnostico]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaTipoDiagnostico] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[DisponibilidadFecha]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[EspecialidadId]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[EspecialidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T6.[EspecialidadNombre]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T6.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[SGSedeDisponibilidadSedeId]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[SGSedeDisponibilidadSedeId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T4.[SedeNombre]" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.[SedeNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T4.[ClinicaId]" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.[ClinicaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T5.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T5.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[ProfesionalId]" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[ProfesionalId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [SGCitaDisponibilidadProFullName] DESC" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaEstadoCita]" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaEstadoCita] DESC" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaInforme]" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaInforme] DESC" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaAntecedentes]" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaAntecedentes] DESC" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaLink]" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaLink] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object42[0] = scmdbuf ;
      GXv_Object42[1] = GXv_int41 ;
      return GXv_Object42 ;
   }

   protected Object[] conditional_H001H3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A65CitaTipoDiagnostico ,
                                          GXSimpleCollection<String> AV132Citawwds_16_tfcitatipodiagnostico_sels ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV159Citawwds_43_tfcitaestadocita_sels ,
                                          String AV117Citawwds_1_filterfulltext ,
                                          int AV118Citawwds_2_tfcitaid ,
                                          int AV119Citawwds_3_tfcitaid_to ,
                                          String AV121Citawwds_5_tfcitacode_sel ,
                                          String AV120Citawwds_4_tfcitacode ,
                                          int AV122Citawwds_6_tfpacienteid ,
                                          int AV123Citawwds_7_tfpacienteid_to ,
                                          String AV125Citawwds_9_tfpacienteapellidopaterno_sel ,
                                          String AV124Citawwds_8_tfpacienteapellidopaterno ,
                                          String AV127Citawwds_11_tfpacienteapellidomaterno_sel ,
                                          String AV126Citawwds_10_tfpacienteapellidomaterno ,
                                          String AV129Citawwds_13_tfpacientenombres_sel ,
                                          String AV128Citawwds_12_tfpacientenombres ,
                                          String AV131Citawwds_15_tfpacientenrodocumento_sel ,
                                          String AV130Citawwds_14_tfpacientenrodocumento ,
                                          int AV132Citawwds_16_tfcitatipodiagnostico_sels_size ,
                                          int AV133Citawwds_17_tfsgcitadisponibilidadid ,
                                          int AV134Citawwds_18_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV135Citawwds_19_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV136Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV137Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                          java.util.Date AV139Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                          short AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid ,
                                          short AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                          short AV145Citawwds_29_tfsgcitadisponibilidadsedeid ,
                                          short AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to ,
                                          String AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV147Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                          short AV149Citawwds_33_tfsgcitadisponibilidadclinicaid ,
                                          short AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                          int AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid ,
                                          int AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV155Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                          String AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                          String AV157Citawwds_41_tfsgcitadisponibilidadprocop ,
                                          int AV159Citawwds_43_tfcitaestadocita_sels_size ,
                                          String AV161Citawwds_45_tfcitainforme_sel ,
                                          String AV160Citawwds_44_tfcitainforme ,
                                          String AV163Citawwds_47_tfcitaantecedentes_sel ,
                                          String AV162Citawwds_46_tfcitaantecedentes ,
                                          String AV165Citawwds_49_tfcitalink_sel ,
                                          String AV164Citawwds_48_tfcitalink ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          int A21SGCitaDisponibilidadId ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          short A72SGCitaDisponibilidadSedeId ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A87SGCitaDisponibilidadProCOP ,
                                          String A90CitaInforme ,
                                          String A100CitaAntecedentes ,
                                          String A91CitaLink ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int44 = new byte[75];
      Object[] GXv_Object45 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (((((([Cita] T1 INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId]" ;
      scmdbuf += " = T3.[ProfesionalId]) INNER JOIN [Sede] T6 ON T6.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T7 ON T7.[ClinicaId] = T6.[ClinicaId]) INNER JOIN" ;
      scmdbuf += " [Especialidad] T5 ON T5.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId])" ;
      if ( ! (GXutil.strcmp("", AV117Citawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T1.[CitaCode] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( 'prensuntivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Prensuntivo') or ( 'definitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Definitivo') or ( 'repetitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Repetitivo') or ( CONVERT( char(8), CAST(T1.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T3.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T5.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T3.[SGSedeDisponibilidadSedeId] AS decimal(4,0))) like '%' + ?) or ( T6.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T6.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T7.[ClinicaNombreAbreviado] like '%' + ?) or ( CONVERT( char(8), CAST(T3.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T4.[ProfesionalNombres] + ' ' + T4.[ProfesionalApellidoPaterno] + ' ' + T4.[ProfesionalApellidoMaterno] like '%' + ?) or ( T4.[ProfesionalCOP] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( T1.[CitaInforme] like '%' + ?) or ( T1.[CitaAntecedentes] like '%' + ?) or ( T1.[CitaLink] like '%' + ?))");
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
      }
      if ( ! (0==AV118Citawwds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int44[29] = (byte)(1) ;
      }
      if ( ! (0==AV119Citawwds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int44[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Citawwds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV120Citawwds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int44[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Citawwds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int44[32] = (byte)(1) ;
      }
      if ( ! (0==AV122Citawwds_6_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int44[33] = (byte)(1) ;
      }
      if ( ! (0==AV123Citawwds_7_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int44[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Citawwds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV124Citawwds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int44[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Citawwds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int44[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Citawwds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV126Citawwds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int44[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Citawwds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int44[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Citawwds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV128Citawwds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int44[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Citawwds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int44[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV131Citawwds_15_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV130Citawwds_14_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int44[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Citawwds_15_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int44[42] = (byte)(1) ;
      }
      if ( AV132Citawwds_16_tfcitatipodiagnostico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Citawwds_16_tfcitatipodiagnostico_sels, "T1.[CitaTipoDiagnostico] IN (", ")")+")");
      }
      if ( ! (0==AV133Citawwds_17_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int44[43] = (byte)(1) ;
      }
      if ( ! (0==AV134Citawwds_18_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int44[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV135Citawwds_19_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int44[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV136Citawwds_20_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int44[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV137Citawwds_21_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int44[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV138Citawwds_22_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int44[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV139Citawwds_23_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int44[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV140Citawwds_24_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int44[50] = (byte)(1) ;
      }
      if ( ! (0==AV141Citawwds_25_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int44[51] = (byte)(1) ;
      }
      if ( ! (0==AV142Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int44[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV143Citawwds_27_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int44[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int44[54] = (byte)(1) ;
      }
      if ( ! (0==AV145Citawwds_29_tfsgcitadisponibilidadsedeid) )
      {
         addWhere(sWhereString, "(T3.[SGSedeDisponibilidadSedeId] >= ?)");
      }
      else
      {
         GXv_int44[55] = (byte)(1) ;
      }
      if ( ! (0==AV146Citawwds_30_tfsgcitadisponibilidadsedeid_to) )
      {
         addWhere(sWhereString, "(T3.[SGSedeDisponibilidadSedeId] <= ?)");
      }
      else
      {
         GXv_int44[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV147Citawwds_31_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int44[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int44[58] = (byte)(1) ;
      }
      if ( ! (0==AV149Citawwds_33_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T6.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int44[59] = (byte)(1) ;
      }
      if ( ! (0==AV150Citawwds_34_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T6.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int44[60] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV151Citawwds_35_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int44[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int44[62] = (byte)(1) ;
      }
      if ( ! (0==AV153Citawwds_37_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int44[63] = (byte)(1) ;
      }
      if ( ! (0==AV154Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int44[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV155Citawwds_39_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalNombres] + ' ' + T4.[ProfesionalApellidoPaterno] + ' ' + T4.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int44[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV156Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalNombres] + ' ' + T4.[ProfesionalApellidoPaterno] + ' ' + T4.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int44[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) && ( ! (GXutil.strcmp("", AV157Citawwds_41_tfsgcitadisponibilidadprocop)==0) ) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int44[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV158Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int44[68] = (byte)(1) ;
      }
      if ( AV159Citawwds_43_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV159Citawwds_43_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV161Citawwds_45_tfcitainforme_sel)==0) && ( ! (GXutil.strcmp("", AV160Citawwds_44_tfcitainforme)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] like ?)");
      }
      else
      {
         GXv_int44[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV161Citawwds_45_tfcitainforme_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] = ?)");
      }
      else
      {
         GXv_int44[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV163Citawwds_47_tfcitaantecedentes_sel)==0) && ( ! (GXutil.strcmp("", AV162Citawwds_46_tfcitaantecedentes)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] like ?)");
      }
      else
      {
         GXv_int44[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV163Citawwds_47_tfcitaantecedentes_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] = ?)");
      }
      else
      {
         GXv_int44[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV165Citawwds_49_tfcitalink_sel)==0) && ( ! (GXutil.strcmp("", AV164Citawwds_48_tfcitalink)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] like ?)");
      }
      else
      {
         GXv_int44[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV165Citawwds_49_tfcitalink_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] = ?)");
      }
      else
      {
         GXv_int44[74] = (byte)(1) ;
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
                  return conditional_H001H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (java.util.Date)dynConstraints[22] , (java.util.Date)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).shortValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (java.util.Date)dynConstraints[75] , (java.util.Date)dynConstraints[76] , (java.util.Date)dynConstraints[77] , ((Number) dynConstraints[78]).shortValue() , ((Boolean) dynConstraints[79]).booleanValue() );
            case 1 :
                  return conditional_H001H3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (java.util.Date)dynConstraints[22] , (java.util.Date)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).shortValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (java.util.Date)dynConstraints[75] , (java.util.Date)dynConstraints[76] , (java.util.Date)dynConstraints[77] , ((Number) dynConstraints[78]).shortValue() , ((Boolean) dynConstraints[79]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001H3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(5);
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((int[]) buf[10])[0] = rslt.getInt(7);
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((short[]) buf[12])[0] = rslt.getShort(9);
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((short[]) buf[16])[0] = rslt.getShort(13);
               ((java.util.Date[]) buf[17])[0] = GXutil.resetDate(rslt.getGXDateTime(14));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = GXutil.resetDate(rslt.getGXDateTime(15));
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[21])[0] = rslt.getGXDate(16);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(17);
               ((String[]) buf[24])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(19);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((int[]) buf[30])[0] = rslt.getInt(23);
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((int[]) buf[32])[0] = rslt.getInt(25);
               ((String[]) buf[33])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[107]).intValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[108]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 15);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 15);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[121]).intValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[122]).intValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[123]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[124]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[125], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[126], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[127], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[128], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[129]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[130]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[131], 40);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 40);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[133]).shortValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[134]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 80);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[137]).shortValue());
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[138]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 100);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[141]).intValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[142]).intValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[145], 40);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 40);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 200);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 200);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[152], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[153]).intValue());
               }
               if ( ((Number) parms[76]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[154]).intValue());
               }
               if ( ((Number) parms[77]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[155]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[104]).intValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[105]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[108]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[109]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 15);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 15);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[118]).intValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[119]).intValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[120]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[121]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[122], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[123], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[124], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[125], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[126]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[127]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 40);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 40);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[130]).shortValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[131]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 80);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[134]).shortValue());
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[135]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 100);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 100);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[138]).intValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[139]).intValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 40);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 40);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 200);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[145], 200);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 200);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               return;
      }
   }

}

