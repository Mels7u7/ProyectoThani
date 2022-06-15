package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class encuestaww_impl extends GXDataArea
{
   public encuestaww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public encuestaww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encuestaww_impl.class ));
   }

   public encuestaww_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbEncuestaAtencion = new HTMLChoice();
      cmbEncuestaAtendido = new HTMLChoice();
      cmbEncuestaEstado = new HTMLChoice();
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
            AV27TFEncuestaId = (short)(GXutil.lval( httpContext.GetPar( "TFEncuestaId"))) ;
            AV28TFEncuestaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFEncuestaId_To"))) ;
            AV29TFCitaId = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId"))) ;
            AV30TFCitaId_To = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId_To"))) ;
            AV31TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadProfesionalId"))) ;
            AV32TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadProfesionalId_To"))) ;
            AV33TFSGCitaDisponibilidadProFullName = httpContext.GetPar( "TFSGCitaDisponibilidadProFullName") ;
            AV34TFSGCitaDisponibilidadProFullName_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadProFullName_Sel") ;
            AV35TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadId"))) ;
            AV36TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadId_To"))) ;
            AV37TFSGCitaDisponibilidadEspecialidadNombre = httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadNombre") ;
            AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadNombre_Sel") ;
            AV39TFSGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadId"))) ;
            AV40TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadId_To"))) ;
            AV41TFSGCitaDisponibilidadFecha = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha")) ;
            AV42TFSGCitaDisponibilidadFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha_To")) ;
            AV45TFPacienteId = (int)(GXutil.lval( httpContext.GetPar( "TFPacienteId"))) ;
            AV46TFPacienteId_To = (int)(GXutil.lval( httpContext.GetPar( "TFPacienteId_To"))) ;
            AV47TFPacienteApellidoPaterno = httpContext.GetPar( "TFPacienteApellidoPaterno") ;
            AV48TFPacienteApellidoPaterno_Sel = httpContext.GetPar( "TFPacienteApellidoPaterno_Sel") ;
            AV49TFPacienteApellidoMaterno = httpContext.GetPar( "TFPacienteApellidoMaterno") ;
            AV50TFPacienteApellidoMaterno_Sel = httpContext.GetPar( "TFPacienteApellidoMaterno_Sel") ;
            AV51TFPacienteNombres = httpContext.GetPar( "TFPacienteNombres") ;
            AV52TFPacienteNombres_Sel = httpContext.GetPar( "TFPacienteNombres_Sel") ;
            AV53TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadClinicaId"))) ;
            AV54TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSGCitaDisponibilidadClinicaId_To"))) ;
            AV55TFSGCitaDisponibilidadClinicaNombre = httpContext.GetPar( "TFSGCitaDisponibilidadClinicaNombre") ;
            AV84TFSGCitaDisponibilidadClinicaNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadClinicaNombre_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV58TFEncuestaAtencion_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60TFEncuestaAtendido_Sels);
            AV61TFEncuestaHoraAtencion = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFEncuestaHoraAtencion"))) ;
            AV62TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFEncuestaHoraAtencion_To"))) ;
            AV65TFEncuestaComentarios = httpContext.GetPar( "TFEncuestaComentarios") ;
            AV66TFEncuestaComentarios_Sel = httpContext.GetPar( "TFEncuestaComentarios_Sel") ;
            AV67TFEncuestaRecomendacion = (byte)(GXutil.lval( httpContext.GetPar( "TFEncuestaRecomendacion"))) ;
            AV68TFEncuestaRecomendacion_To = (byte)(GXutil.lval( httpContext.GetPar( "TFEncuestaRecomendacion_To"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV70TFEncuestaEstado_Sels);
            AV125Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV76IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV78IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV81IsAuthorized_PacienteNombres = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_PacienteNombres")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFEncuestaId, AV28TFEncuestaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFSGCitaDisponibilidadProfesionalId, AV32TFSGCitaDisponibilidadProfesionalId_To, AV33TFSGCitaDisponibilidadProFullName, AV34TFSGCitaDisponibilidadProFullName_Sel, AV35TFSGCitaDisponibilidadEspecialidadId, AV36TFSGCitaDisponibilidadEspecialidadId_To, AV37TFSGCitaDisponibilidadEspecialidadNombre, AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV39TFSGCitaDisponibilidadId, AV40TFSGCitaDisponibilidadId_To, AV41TFSGCitaDisponibilidadFecha, AV42TFSGCitaDisponibilidadFecha_To, AV45TFPacienteId, AV46TFPacienteId_To, AV47TFPacienteApellidoPaterno, AV48TFPacienteApellidoPaterno_Sel, AV49TFPacienteApellidoMaterno, AV50TFPacienteApellidoMaterno_Sel, AV51TFPacienteNombres, AV52TFPacienteNombres_Sel, AV53TFSGCitaDisponibilidadClinicaId, AV54TFSGCitaDisponibilidadClinicaId_To, AV55TFSGCitaDisponibilidadClinicaNombre, AV84TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFEncuestaAtencion_Sels, AV60TFEncuestaAtendido_Sels, AV61TFEncuestaHoraAtencion, AV62TFEncuestaHoraAtencion_To, AV65TFEncuestaComentarios, AV66TFEncuestaComentarios_Sel, AV67TFEncuestaRecomendacion, AV68TFEncuestaRecomendacion_To, AV70TFEncuestaEstado_Sels, AV125Pgmname, AV13OrderedBy, AV14OrderedDsc, AV76IsAuthorized_Update, AV78IsAuthorized_Delete, AV81IsAuthorized_PacienteNombres) ;
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
      pa1V2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1V2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033280", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.encuestaww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV125Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV76IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV78IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV81IsAuthorized_PacienteNombres));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV73GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV74GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV71DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV71DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO", localUtil.dtoc( AV44DDO_SGCitaDisponibilidadFechaAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_ENCUESTAHORAATENCIONAUXDATETO", localUtil.dtoc( AV64DDO_EncuestaHoraAtencionAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAID", GXutil.ltrim( localUtil.ntoc( AV27TFEncuestaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFEncuestaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID", GXutil.ltrim( localUtil.ntoc( AV29TFCitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID_TO", GXutil.ltrim( localUtil.ntoc( AV30TFCitaId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV31TFSGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFESIONALID_TO", GXutil.ltrim( localUtil.ntoc( AV32TFSGCitaDisponibilidadProfesionalId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFULLNAME", AV33TFSGCitaDisponibilidadProFullName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADPROFULLNAME_SEL", AV34TFSGCitaDisponibilidadProFullName_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV35TFSGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV36TFSGCitaDisponibilidadEspecialidadId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE", AV37TFSGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL", AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV39TFSGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADID_TO", GXutil.ltrim( localUtil.ntoc( AV40TFSGCitaDisponibilidadId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA", localUtil.dtoc( AV41TFSGCitaDisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA_TO", localUtil.dtoc( AV42TFSGCitaDisponibilidadFecha_To, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV45TFPacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEID_TO", GXutil.ltrim( localUtil.ntoc( AV46TFPacienteId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO", AV47TFPacienteApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO_SEL", AV48TFPacienteApellidoPaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO", AV49TFPacienteApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO_SEL", AV50TFPacienteApellidoMaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES", AV51TFPacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES_SEL", AV52TFPacienteNombres_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICAID", GXutil.ltrim( localUtil.ntoc( AV53TFSGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICAID_TO", GXutil.ltrim( localUtil.ntoc( AV54TFSGCitaDisponibilidadClinicaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICANOMBRE", AV55TFSGCitaDisponibilidadClinicaNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL", AV84TFSGCitaDisponibilidadClinicaNombre_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFENCUESTAATENCION_SELS", AV58TFEncuestaAtencion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFENCUESTAATENCION_SELS", AV58TFEncuestaAtencion_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFENCUESTAATENDIDO_SELS", AV60TFEncuestaAtendido_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFENCUESTAATENDIDO_SELS", AV60TFEncuestaAtendido_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAHORAATENCION", localUtil.ttoc( AV61TFEncuestaHoraAtencion, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAHORAATENCION_TO", localUtil.ttoc( AV62TFEncuestaHoraAtencion_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTACOMENTARIOS", AV65TFEncuestaComentarios);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTACOMENTARIOS_SEL", AV66TFEncuestaComentarios_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTARECOMENDACION", GXutil.ltrim( localUtil.ntoc( AV67TFEncuestaRecomendacion, (byte)(2), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTARECOMENDACION_TO", GXutil.ltrim( localUtil.ntoc( AV68TFEncuestaRecomendacion_To, (byte)(2), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFENCUESTAESTADO_SELS", AV70TFEncuestaEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFENCUESTAESTADO_SELS", AV70TFEncuestaEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV125Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV125Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV76IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV76IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV78IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV78IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PACIENTENOMBRES", AV81IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV81IsAuthorized_PacienteNombres));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAATENCION_SELSJSON", AV57TFEncuestaAtencion_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAATENDIDO_SELSJSON", AV59TFEncuestaAtendido_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFENCUESTAESTADO_SELSJSON", AV69TFEncuestaEstado_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE", localUtil.dtoc( AV43DDO_SGCitaDisponibilidadFechaAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_ENCUESTAHORAATENCIONAUXDATE", localUtil.dtoc( AV63DDO_EncuestaHoraAtencionAuxDate, 0, "/"));
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
         we1V2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1V2( ) ;
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
      return formatLink("com.projectthani.encuestaww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "EncuestaWW" ;
   }

   public String getPgmdesc( )
   {
      return " Encuesta" ;
   }

   public void wb1V0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EncuestaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EncuestaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EncuestaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EncuestaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_1V2( true) ;
      }
      else
      {
         wb_table1_25_1V2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_1V2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEncuestaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cita Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadProfesionalId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Profesional Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadProFullName_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Pro Full Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadEspecialidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Especialidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadEspecialidadNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Especialidad Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Fecha") ;
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadClinicaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Clinica Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSGCitaDisponibilidadClinicaNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "SGCita Disponibilidad Clinica Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbEncuestaAtencion.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Atencion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbEncuestaAtendido.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Atendido") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEncuestaHoraAtencion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Hora Atencion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEncuestaComentarios_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Comentarios") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtEncuestaRecomendacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Recomendacion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbEncuestaEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV75Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV77Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A37EncuestaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEncuestaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaId_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadEspecialidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A146SGCitaDisponibilidadEspecialidadNombre);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadEspecialidadNombre_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadClinicaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A78SGCitaDisponibilidadClinicaNombre);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSGCitaDisponibilidadClinicaNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A148EncuestaAtencion));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbEncuestaAtencion.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A149EncuestaAtendido));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbEncuestaAtendido.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A150EncuestaHoraAtencion, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEncuestaHoraAtencion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A151EncuestaComentarios);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEncuestaComentarios_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A152EncuestaRecomendacion, (byte)(2), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEncuestaRecomendacion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A153EncuestaEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbEncuestaEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV73GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV74GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV71DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV71DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname, AV82DDO_SGCitaDisponibilidadFechaAuxDateText, GXutil.rtrim( localUtil.format( AV82DDO_SGCitaDisponibilidadFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaWW.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("Start Date", AV43DDO_SGCitaDisponibilidadFechaAuxDate);
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("End Date", AV44DDO_SGCitaDisponibilidadFechaAuxDateTo);
         ucTfsgcitadisponibilidadfecha_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadfecha_rangepicker_Internalname, "TFSGCITADISPONIBILIDADFECHA_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_encuestahoraatencionauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_encuestahoraatencionauxdatetext_Internalname, AV83DDO_EncuestaHoraAtencionAuxDateText, GXutil.rtrim( localUtil.format( AV83DDO_EncuestaHoraAtencionAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,80);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_encuestahoraatencionauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaWW.htm");
         /* User Defined Control */
         ucTfencuestahoraatencion_rangepicker.setProperty("Start Date", AV63DDO_EncuestaHoraAtencionAuxDate);
         ucTfencuestahoraatencion_rangepicker.setProperty("End Date", AV64DDO_EncuestaHoraAtencionAuxDateTo);
         ucTfencuestahoraatencion_rangepicker.render(context, "wwp.daterangepicker", Tfencuestahoraatencion_rangepicker_Internalname, "TFENCUESTAHORAATENCION_RANGEPICKERContainer");
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

   public void start1V2( )
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
         Form.getMeta().addItem("description", " Encuesta", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1V0( ) ;
   }

   public void ws1V2( )
   {
      start1V2( ) ;
      evt1V2( ) ;
   }

   public void evt1V2( )
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
                           e111V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e161V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e171V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e181V2 ();
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
                           AV75Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV75Update);
                           AV77Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV77Delete);
                           A37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( edtEncuestaId_Internalname), ",", ".")) ;
                           A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
                           A81SGCitaDisponibilidadProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadProfesionalId_Internalname), ",", ".")) ;
                           A82SGCitaDisponibilidadProFullName = httpContext.cgiGet( edtSGCitaDisponibilidadProFullName_Internalname) ;
                           A70SGCitaDisponibilidadEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadId_Internalname), ",", ".")) ;
                           A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
                           A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
                           A66SGCitaDisponibilidadFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 0)) ;
                           n66SGCitaDisponibilidadFecha = false ;
                           A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
                           A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
                           A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
                           A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
                           A76SGCitaDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadClinicaId_Internalname), ",", ".")) ;
                           A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
                           cmbEncuestaAtencion.setName( cmbEncuestaAtencion.getInternalname() );
                           cmbEncuestaAtencion.setValue( httpContext.cgiGet( cmbEncuestaAtencion.getInternalname()) );
                           A148EncuestaAtencion = httpContext.cgiGet( cmbEncuestaAtencion.getInternalname()) ;
                           n148EncuestaAtencion = false ;
                           cmbEncuestaAtendido.setName( cmbEncuestaAtendido.getInternalname() );
                           cmbEncuestaAtendido.setValue( httpContext.cgiGet( cmbEncuestaAtendido.getInternalname()) );
                           A149EncuestaAtendido = httpContext.cgiGet( cmbEncuestaAtendido.getInternalname()) ;
                           n149EncuestaAtendido = false ;
                           A150EncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtEncuestaHoraAtencion_Internalname), 0)) ;
                           n150EncuestaHoraAtencion = false ;
                           A151EncuestaComentarios = httpContext.cgiGet( edtEncuestaComentarios_Internalname) ;
                           n151EncuestaComentarios = false ;
                           A152EncuestaRecomendacion = (byte)(localUtil.ctol( httpContext.cgiGet( edtEncuestaRecomendacion_Internalname), ",", ".")) ;
                           cmbEncuestaEstado.setName( cmbEncuestaEstado.getInternalname() );
                           cmbEncuestaEstado.setValue( httpContext.cgiGet( cmbEncuestaEstado.getInternalname()) );
                           A153EncuestaEstado = httpContext.cgiGet( cmbEncuestaEstado.getInternalname()) ;
                           n153EncuestaEstado = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e191V2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e201V2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e211V2 ();
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

   public void we1V2( )
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

   public void pa1V2( )
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
                                 short AV27TFEncuestaId ,
                                 short AV28TFEncuestaId_To ,
                                 int AV29TFCitaId ,
                                 int AV30TFCitaId_To ,
                                 int AV31TFSGCitaDisponibilidadProfesionalId ,
                                 int AV32TFSGCitaDisponibilidadProfesionalId_To ,
                                 String AV33TFSGCitaDisponibilidadProFullName ,
                                 String AV34TFSGCitaDisponibilidadProFullName_Sel ,
                                 short AV35TFSGCitaDisponibilidadEspecialidadId ,
                                 short AV36TFSGCitaDisponibilidadEspecialidadId_To ,
                                 String AV37TFSGCitaDisponibilidadEspecialidadNombre ,
                                 String AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ,
                                 int AV39TFSGCitaDisponibilidadId ,
                                 int AV40TFSGCitaDisponibilidadId_To ,
                                 java.util.Date AV41TFSGCitaDisponibilidadFecha ,
                                 java.util.Date AV42TFSGCitaDisponibilidadFecha_To ,
                                 int AV45TFPacienteId ,
                                 int AV46TFPacienteId_To ,
                                 String AV47TFPacienteApellidoPaterno ,
                                 String AV48TFPacienteApellidoPaterno_Sel ,
                                 String AV49TFPacienteApellidoMaterno ,
                                 String AV50TFPacienteApellidoMaterno_Sel ,
                                 String AV51TFPacienteNombres ,
                                 String AV52TFPacienteNombres_Sel ,
                                 short AV53TFSGCitaDisponibilidadClinicaId ,
                                 short AV54TFSGCitaDisponibilidadClinicaId_To ,
                                 String AV55TFSGCitaDisponibilidadClinicaNombre ,
                                 String AV84TFSGCitaDisponibilidadClinicaNombre_Sel ,
                                 GXSimpleCollection<String> AV58TFEncuestaAtencion_Sels ,
                                 GXSimpleCollection<String> AV60TFEncuestaAtendido_Sels ,
                                 java.util.Date AV61TFEncuestaHoraAtencion ,
                                 java.util.Date AV62TFEncuestaHoraAtencion_To ,
                                 String AV65TFEncuestaComentarios ,
                                 String AV66TFEncuestaComentarios_Sel ,
                                 byte AV67TFEncuestaRecomendacion ,
                                 byte AV68TFEncuestaRecomendacion_To ,
                                 GXSimpleCollection<String> AV70TFEncuestaEstado_Sels ,
                                 String AV125Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV76IsAuthorized_Update ,
                                 boolean AV78IsAuthorized_Delete ,
                                 boolean AV81IsAuthorized_PacienteNombres )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e201V2 ();
      GRID_nCurrentRecord = 0 ;
      rf1V2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_ENCUESTAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ENCUESTAID", GXutil.ltrim( localUtil.ntoc( A37EncuestaId, (byte)(4), (byte)(0), ".", "")));
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
      rf1V2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV125Pgmname = "EncuestaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf1V2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e201V2 ();
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
                                              A148EncuestaAtencion ,
                                              AV116Encuestawwds_30_tfencuestaatencion_sels ,
                                              A149EncuestaAtendido ,
                                              AV117Encuestawwds_31_tfencuestaatendido_sels ,
                                              A153EncuestaEstado ,
                                              AV124Encuestawwds_38_tfencuestaestado_sels ,
                                              Short.valueOf(AV88Encuestawwds_2_tfencuestaid) ,
                                              Short.valueOf(AV89Encuestawwds_3_tfencuestaid_to) ,
                                              Integer.valueOf(AV90Encuestawwds_4_tfcitaid) ,
                                              Integer.valueOf(AV91Encuestawwds_5_tfcitaid_to) ,
                                              Integer.valueOf(AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                              Integer.valueOf(AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                              AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                              AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                              Short.valueOf(AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                              Short.valueOf(AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                              AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                              AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                              Integer.valueOf(AV100Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                              Integer.valueOf(AV101Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                              AV102Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                              AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                              Integer.valueOf(AV104Encuestawwds_18_tfpacienteid) ,
                                              Integer.valueOf(AV105Encuestawwds_19_tfpacienteid_to) ,
                                              AV107Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                              AV106Encuestawwds_20_tfpacienteapellidopaterno ,
                                              AV109Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                              AV108Encuestawwds_22_tfpacienteapellidomaterno ,
                                              AV111Encuestawwds_25_tfpacientenombres_sel ,
                                              AV110Encuestawwds_24_tfpacientenombres ,
                                              Short.valueOf(AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                              Short.valueOf(AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                              AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                              AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                              Integer.valueOf(AV116Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                              Integer.valueOf(AV117Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                              AV118Encuestawwds_32_tfencuestahoraatencion ,
                                              AV119Encuestawwds_33_tfencuestahoraatencion_to ,
                                              AV121Encuestawwds_35_tfencuestacomentarios_sel ,
                                              AV120Encuestawwds_34_tfencuestacomentarios ,
                                              Byte.valueOf(AV122Encuestawwds_36_tfencuestarecomendacion) ,
                                              Byte.valueOf(AV123Encuestawwds_37_tfencuestarecomendacion_to) ,
                                              Integer.valueOf(AV124Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                              Short.valueOf(A37EncuestaId) ,
                                              Integer.valueOf(A19CitaId) ,
                                              Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                              A84ProfesionalNombres ,
                                              A85ProfesionalApellidoPaterno ,
                                              A86ProfesionalApellidoMaterno ,
                                              Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                              A146SGCitaDisponibilidadEspecialidadNombre ,
                                              Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                              A66SGCitaDisponibilidadFecha ,
                                              Integer.valueOf(A20PacienteId) ,
                                              A103PacienteApellidoPaterno ,
                                              A104PacienteApellidoMaterno ,
                                              A105PacienteNombres ,
                                              Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                              A78SGCitaDisponibilidadClinicaNombre ,
                                              A150EncuestaHoraAtencion ,
                                              A151EncuestaComentarios ,
                                              Byte.valueOf(A152EncuestaRecomendacion) ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              AV87Encuestawwds_1_filterfulltext ,
                                              A82SGCitaDisponibilidadProFullName } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
         lV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
         lV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
         lV106Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV106Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
         lV108Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
         lV110Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV110Encuestawwds_24_tfpacientenombres), "%", "") ;
         lV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
         lV120Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV120Encuestawwds_34_tfencuestacomentarios), "%", "") ;
         /* Using cursor H001V2 */
         pr_default.execute(0, new Object[] {AV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, Short.valueOf(AV88Encuestawwds_2_tfencuestaid), Short.valueOf(AV89Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV90Encuestawwds_4_tfcitaid), Integer.valueOf(AV91Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV94Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV100Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV101Encuestawwds_15_tfsgcitadisponibilidadid_to), AV102Encuestawwds_16_tfsgcitadisponibilidadfecha, AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV104Encuestawwds_18_tfpacienteid), Integer.valueOf(AV105Encuestawwds_19_tfpacienteid_to), lV106Encuestawwds_20_tfpacienteapellidopaterno, AV107Encuestawwds_21_tfpacienteapellidopaterno_sel, lV108Encuestawwds_22_tfpacienteapellidomaterno, AV109Encuestawwds_23_tfpacienteapellidomaterno_sel, lV110Encuestawwds_24_tfpacientenombres, AV111Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV118Encuestawwds_32_tfencuestahoraatencion, AV119Encuestawwds_33_tfencuestahoraatencion_to, lV120Encuestawwds_34_tfencuestacomentarios, AV121Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV122Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV123Encuestawwds_37_tfencuestarecomendacion_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A72SGCitaDisponibilidadSedeId = H001V2_A72SGCitaDisponibilidadSedeId[0] ;
            A153EncuestaEstado = H001V2_A153EncuestaEstado[0] ;
            n153EncuestaEstado = H001V2_n153EncuestaEstado[0] ;
            A152EncuestaRecomendacion = H001V2_A152EncuestaRecomendacion[0] ;
            A151EncuestaComentarios = H001V2_A151EncuestaComentarios[0] ;
            n151EncuestaComentarios = H001V2_n151EncuestaComentarios[0] ;
            A150EncuestaHoraAtencion = H001V2_A150EncuestaHoraAtencion[0] ;
            n150EncuestaHoraAtencion = H001V2_n150EncuestaHoraAtencion[0] ;
            A149EncuestaAtendido = H001V2_A149EncuestaAtendido[0] ;
            n149EncuestaAtendido = H001V2_n149EncuestaAtendido[0] ;
            A148EncuestaAtencion = H001V2_A148EncuestaAtencion[0] ;
            n148EncuestaAtencion = H001V2_n148EncuestaAtencion[0] ;
            A78SGCitaDisponibilidadClinicaNombre = H001V2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            A76SGCitaDisponibilidadClinicaId = H001V2_A76SGCitaDisponibilidadClinicaId[0] ;
            A105PacienteNombres = H001V2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H001V2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H001V2_A103PacienteApellidoPaterno[0] ;
            A20PacienteId = H001V2_A20PacienteId[0] ;
            A66SGCitaDisponibilidadFecha = H001V2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H001V2_n66SGCitaDisponibilidadFecha[0] ;
            A21SGCitaDisponibilidadId = H001V2_A21SGCitaDisponibilidadId[0] ;
            A146SGCitaDisponibilidadEspecialidadNombre = H001V2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            A70SGCitaDisponibilidadEspecialidadId = H001V2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A82SGCitaDisponibilidadProFullName = H001V2_A82SGCitaDisponibilidadProFullName[0] ;
            A81SGCitaDisponibilidadProfesionalId = H001V2_A81SGCitaDisponibilidadProfesionalId[0] ;
            A19CitaId = H001V2_A19CitaId[0] ;
            A37EncuestaId = H001V2_A37EncuestaId[0] ;
            A84ProfesionalNombres = H001V2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H001V2_n84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H001V2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H001V2_n85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H001V2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H001V2_n86ProfesionalApellidoMaterno[0] ;
            A20PacienteId = H001V2_A20PacienteId[0] ;
            A21SGCitaDisponibilidadId = H001V2_A21SGCitaDisponibilidadId[0] ;
            A82SGCitaDisponibilidadProFullName = H001V2_A82SGCitaDisponibilidadProFullName[0] ;
            A105PacienteNombres = H001V2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H001V2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H001V2_A103PacienteApellidoPaterno[0] ;
            A72SGCitaDisponibilidadSedeId = H001V2_A72SGCitaDisponibilidadSedeId[0] ;
            A66SGCitaDisponibilidadFecha = H001V2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H001V2_n66SGCitaDisponibilidadFecha[0] ;
            A70SGCitaDisponibilidadEspecialidadId = H001V2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A81SGCitaDisponibilidadProfesionalId = H001V2_A81SGCitaDisponibilidadProfesionalId[0] ;
            A76SGCitaDisponibilidadClinicaId = H001V2_A76SGCitaDisponibilidadClinicaId[0] ;
            A78SGCitaDisponibilidadClinicaNombre = H001V2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            A146SGCitaDisponibilidadEspecialidadNombre = H001V2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            A84ProfesionalNombres = H001V2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H001V2_n84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = H001V2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H001V2_n85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = H001V2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H001V2_n86ProfesionalApellidoMaterno[0] ;
            e211V2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb1V0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1V2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV125Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV125Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV76IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV76IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV78IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV78IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PACIENTENOMBRES", AV81IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV81IsAuthorized_PacienteNombres));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_ENCUESTAID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9")));
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
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV116Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV117Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV124Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV88Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV89Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV90Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV91Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV100Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV101Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV102Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV104Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV105Encuestawwds_19_tfpacienteid_to) ,
                                           AV107Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV106Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV109Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV108Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV111Encuestawwds_25_tfpacientenombres_sel ,
                                           AV110Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV116Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV117Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV118Encuestawwds_32_tfencuestahoraatencion ,
                                           AV119Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV121Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV120Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV122Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV123Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV124Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           AV87Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV87Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV87Encuestawwds_1_filterfulltext), "%", "") ;
      lV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV106Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV106Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV108Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV110Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV110Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV120Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV120Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor H001V3 */
      pr_default.execute(1, new Object[] {AV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, lV87Encuestawwds_1_filterfulltext, Short.valueOf(AV88Encuestawwds_2_tfencuestaid), Short.valueOf(AV89Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV90Encuestawwds_4_tfcitaid), Integer.valueOf(AV91Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV94Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV100Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV101Encuestawwds_15_tfsgcitadisponibilidadid_to), AV102Encuestawwds_16_tfsgcitadisponibilidadfecha, AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV104Encuestawwds_18_tfpacienteid), Integer.valueOf(AV105Encuestawwds_19_tfpacienteid_to), lV106Encuestawwds_20_tfpacienteapellidopaterno, AV107Encuestawwds_21_tfpacienteapellidopaterno_sel, lV108Encuestawwds_22_tfpacienteapellidomaterno, AV109Encuestawwds_23_tfpacienteapellidomaterno_sel, lV110Encuestawwds_24_tfpacientenombres, AV111Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV118Encuestawwds_32_tfencuestahoraatencion, AV119Encuestawwds_33_tfencuestahoraatencion_to, lV120Encuestawwds_34_tfencuestacomentarios, AV121Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV122Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV123Encuestawwds_37_tfencuestarecomendacion_to)});
      GRID_nRecordCount = H001V3_AGRID_nRecordCount[0] ;
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
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFEncuestaId, AV28TFEncuestaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFSGCitaDisponibilidadProfesionalId, AV32TFSGCitaDisponibilidadProfesionalId_To, AV33TFSGCitaDisponibilidadProFullName, AV34TFSGCitaDisponibilidadProFullName_Sel, AV35TFSGCitaDisponibilidadEspecialidadId, AV36TFSGCitaDisponibilidadEspecialidadId_To, AV37TFSGCitaDisponibilidadEspecialidadNombre, AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV39TFSGCitaDisponibilidadId, AV40TFSGCitaDisponibilidadId_To, AV41TFSGCitaDisponibilidadFecha, AV42TFSGCitaDisponibilidadFecha_To, AV45TFPacienteId, AV46TFPacienteId_To, AV47TFPacienteApellidoPaterno, AV48TFPacienteApellidoPaterno_Sel, AV49TFPacienteApellidoMaterno, AV50TFPacienteApellidoMaterno_Sel, AV51TFPacienteNombres, AV52TFPacienteNombres_Sel, AV53TFSGCitaDisponibilidadClinicaId, AV54TFSGCitaDisponibilidadClinicaId_To, AV55TFSGCitaDisponibilidadClinicaNombre, AV84TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFEncuestaAtencion_Sels, AV60TFEncuestaAtendido_Sels, AV61TFEncuestaHoraAtencion, AV62TFEncuestaHoraAtencion_To, AV65TFEncuestaComentarios, AV66TFEncuestaComentarios_Sel, AV67TFEncuestaRecomendacion, AV68TFEncuestaRecomendacion_To, AV70TFEncuestaEstado_Sels, AV125Pgmname, AV13OrderedBy, AV14OrderedDsc, AV76IsAuthorized_Update, AV78IsAuthorized_Delete, AV81IsAuthorized_PacienteNombres) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFEncuestaId, AV28TFEncuestaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFSGCitaDisponibilidadProfesionalId, AV32TFSGCitaDisponibilidadProfesionalId_To, AV33TFSGCitaDisponibilidadProFullName, AV34TFSGCitaDisponibilidadProFullName_Sel, AV35TFSGCitaDisponibilidadEspecialidadId, AV36TFSGCitaDisponibilidadEspecialidadId_To, AV37TFSGCitaDisponibilidadEspecialidadNombre, AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV39TFSGCitaDisponibilidadId, AV40TFSGCitaDisponibilidadId_To, AV41TFSGCitaDisponibilidadFecha, AV42TFSGCitaDisponibilidadFecha_To, AV45TFPacienteId, AV46TFPacienteId_To, AV47TFPacienteApellidoPaterno, AV48TFPacienteApellidoPaterno_Sel, AV49TFPacienteApellidoMaterno, AV50TFPacienteApellidoMaterno_Sel, AV51TFPacienteNombres, AV52TFPacienteNombres_Sel, AV53TFSGCitaDisponibilidadClinicaId, AV54TFSGCitaDisponibilidadClinicaId_To, AV55TFSGCitaDisponibilidadClinicaNombre, AV84TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFEncuestaAtencion_Sels, AV60TFEncuestaAtendido_Sels, AV61TFEncuestaHoraAtencion, AV62TFEncuestaHoraAtencion_To, AV65TFEncuestaComentarios, AV66TFEncuestaComentarios_Sel, AV67TFEncuestaRecomendacion, AV68TFEncuestaRecomendacion_To, AV70TFEncuestaEstado_Sels, AV125Pgmname, AV13OrderedBy, AV14OrderedDsc, AV76IsAuthorized_Update, AV78IsAuthorized_Delete, AV81IsAuthorized_PacienteNombres) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFEncuestaId, AV28TFEncuestaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFSGCitaDisponibilidadProfesionalId, AV32TFSGCitaDisponibilidadProfesionalId_To, AV33TFSGCitaDisponibilidadProFullName, AV34TFSGCitaDisponibilidadProFullName_Sel, AV35TFSGCitaDisponibilidadEspecialidadId, AV36TFSGCitaDisponibilidadEspecialidadId_To, AV37TFSGCitaDisponibilidadEspecialidadNombre, AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV39TFSGCitaDisponibilidadId, AV40TFSGCitaDisponibilidadId_To, AV41TFSGCitaDisponibilidadFecha, AV42TFSGCitaDisponibilidadFecha_To, AV45TFPacienteId, AV46TFPacienteId_To, AV47TFPacienteApellidoPaterno, AV48TFPacienteApellidoPaterno_Sel, AV49TFPacienteApellidoMaterno, AV50TFPacienteApellidoMaterno_Sel, AV51TFPacienteNombres, AV52TFPacienteNombres_Sel, AV53TFSGCitaDisponibilidadClinicaId, AV54TFSGCitaDisponibilidadClinicaId_To, AV55TFSGCitaDisponibilidadClinicaNombre, AV84TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFEncuestaAtencion_Sels, AV60TFEncuestaAtendido_Sels, AV61TFEncuestaHoraAtencion, AV62TFEncuestaHoraAtencion_To, AV65TFEncuestaComentarios, AV66TFEncuestaComentarios_Sel, AV67TFEncuestaRecomendacion, AV68TFEncuestaRecomendacion_To, AV70TFEncuestaEstado_Sels, AV125Pgmname, AV13OrderedBy, AV14OrderedDsc, AV76IsAuthorized_Update, AV78IsAuthorized_Delete, AV81IsAuthorized_PacienteNombres) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFEncuestaId, AV28TFEncuestaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFSGCitaDisponibilidadProfesionalId, AV32TFSGCitaDisponibilidadProfesionalId_To, AV33TFSGCitaDisponibilidadProFullName, AV34TFSGCitaDisponibilidadProFullName_Sel, AV35TFSGCitaDisponibilidadEspecialidadId, AV36TFSGCitaDisponibilidadEspecialidadId_To, AV37TFSGCitaDisponibilidadEspecialidadNombre, AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV39TFSGCitaDisponibilidadId, AV40TFSGCitaDisponibilidadId_To, AV41TFSGCitaDisponibilidadFecha, AV42TFSGCitaDisponibilidadFecha_To, AV45TFPacienteId, AV46TFPacienteId_To, AV47TFPacienteApellidoPaterno, AV48TFPacienteApellidoPaterno_Sel, AV49TFPacienteApellidoMaterno, AV50TFPacienteApellidoMaterno_Sel, AV51TFPacienteNombres, AV52TFPacienteNombres_Sel, AV53TFSGCitaDisponibilidadClinicaId, AV54TFSGCitaDisponibilidadClinicaId_To, AV55TFSGCitaDisponibilidadClinicaNombre, AV84TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFEncuestaAtencion_Sels, AV60TFEncuestaAtendido_Sels, AV61TFEncuestaHoraAtencion, AV62TFEncuestaHoraAtencion_To, AV65TFEncuestaComentarios, AV66TFEncuestaComentarios_Sel, AV67TFEncuestaRecomendacion, AV68TFEncuestaRecomendacion_To, AV70TFEncuestaEstado_Sels, AV125Pgmname, AV13OrderedBy, AV14OrderedDsc, AV76IsAuthorized_Update, AV78IsAuthorized_Delete, AV81IsAuthorized_PacienteNombres) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFEncuestaId, AV28TFEncuestaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFSGCitaDisponibilidadProfesionalId, AV32TFSGCitaDisponibilidadProfesionalId_To, AV33TFSGCitaDisponibilidadProFullName, AV34TFSGCitaDisponibilidadProFullName_Sel, AV35TFSGCitaDisponibilidadEspecialidadId, AV36TFSGCitaDisponibilidadEspecialidadId_To, AV37TFSGCitaDisponibilidadEspecialidadNombre, AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV39TFSGCitaDisponibilidadId, AV40TFSGCitaDisponibilidadId_To, AV41TFSGCitaDisponibilidadFecha, AV42TFSGCitaDisponibilidadFecha_To, AV45TFPacienteId, AV46TFPacienteId_To, AV47TFPacienteApellidoPaterno, AV48TFPacienteApellidoPaterno_Sel, AV49TFPacienteApellidoMaterno, AV50TFPacienteApellidoMaterno_Sel, AV51TFPacienteNombres, AV52TFPacienteNombres_Sel, AV53TFSGCitaDisponibilidadClinicaId, AV54TFSGCitaDisponibilidadClinicaId_To, AV55TFSGCitaDisponibilidadClinicaNombre, AV84TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFEncuestaAtencion_Sels, AV60TFEncuestaAtendido_Sels, AV61TFEncuestaHoraAtencion, AV62TFEncuestaHoraAtencion_To, AV65TFEncuestaComentarios, AV66TFEncuestaComentarios_Sel, AV67TFEncuestaRecomendacion, AV68TFEncuestaRecomendacion_To, AV70TFEncuestaEstado_Sels, AV125Pgmname, AV13OrderedBy, AV14OrderedDsc, AV76IsAuthorized_Update, AV78IsAuthorized_Delete, AV81IsAuthorized_PacienteNombres) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV125Pgmname = "EncuestaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1V0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e191V2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV71DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV73GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV74GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV43DDO_SGCitaDisponibilidadFechaAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE"), 0) ;
         AV44DDO_SGCitaDisponibilidadFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO"), 0) ;
         AV63DDO_EncuestaHoraAtencionAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_ENCUESTAHORAATENCIONAUXDATE"), 0) ;
         AV64DDO_EncuestaHoraAtencionAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_ENCUESTAHORAATENCIONAUXDATETO"), 0) ;
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
         AV82DDO_SGCitaDisponibilidadFechaAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82DDO_SGCitaDisponibilidadFechaAuxDateText", AV82DDO_SGCitaDisponibilidadFechaAuxDateText);
         AV83DDO_EncuestaHoraAtencionAuxDateText = httpContext.cgiGet( edtavDdo_encuestahoraatencionauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV83DDO_EncuestaHoraAtencionAuxDateText", AV83DDO_EncuestaHoraAtencionAuxDateText);
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
      e191V2 ();
      if (returnInSub) return;
   }

   public void e191V2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFENCUESTAHORAATENCION_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_encuestahoraatencionauxdatetext_Internalname});
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
      GXt_boolean1 = AV81IsAuthorized_PacienteNombres ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
      encuestaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV81IsAuthorized_PacienteNombres = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81IsAuthorized_PacienteNombres", AV81IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( "", AV81IsAuthorized_PacienteNombres));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Encuesta" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV71DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV71DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e201V2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("EncuestaWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("EncuestaWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtEncuestaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadProfesionalId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProfesionalId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProfesionalId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadProFullName_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProFullName_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProFullName_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadEspecialidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadEspecialidadNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadFecha_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadFecha_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteApellidoPaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoPaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoPaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteApellidoMaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoMaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoMaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNombres_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombres_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadClinicaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSGCitaDisponibilidadClinicaNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbEncuestaAtencion.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtencion.getInternalname(), "Visible", GXutil.ltrimstr( cmbEncuestaAtencion.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbEncuestaAtendido.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtendido.getInternalname(), "Visible", GXutil.ltrimstr( cmbEncuestaAtendido.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtEncuestaHoraAtencion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaHoraAtencion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaHoraAtencion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtEncuestaComentarios_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaComentarios_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaComentarios_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtEncuestaRecomendacion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaRecomendacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaRecomendacion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbEncuestaEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbEncuestaEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV73GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73GridCurrentPage), 10, 0));
      AV74GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74GridPageCount), 10, 0));
      AV87Encuestawwds_1_filterfulltext = AV16FilterFullText ;
      AV88Encuestawwds_2_tfencuestaid = AV27TFEncuestaId ;
      AV89Encuestawwds_3_tfencuestaid_to = AV28TFEncuestaId_To ;
      AV90Encuestawwds_4_tfcitaid = AV29TFCitaId ;
      AV91Encuestawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV31TFSGCitaDisponibilidadProfesionalId ;
      AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV32TFSGCitaDisponibilidadProfesionalId_To ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV33TFSGCitaDisponibilidadProFullName ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV34TFSGCitaDisponibilidadProFullName_Sel ;
      AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV35TFSGCitaDisponibilidadEspecialidadId ;
      AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV36TFSGCitaDisponibilidadEspecialidadId_To ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV37TFSGCitaDisponibilidadEspecialidadNombre ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV100Encuestawwds_14_tfsgcitadisponibilidadid = AV39TFSGCitaDisponibilidadId ;
      AV101Encuestawwds_15_tfsgcitadisponibilidadid_to = AV40TFSGCitaDisponibilidadId_To ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV104Encuestawwds_18_tfpacienteid = AV45TFPacienteId ;
      AV105Encuestawwds_19_tfpacienteid_to = AV46TFPacienteId_To ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = AV47TFPacienteApellidoPaterno ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = AV48TFPacienteApellidoPaterno_Sel ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = AV49TFPacienteApellidoMaterno ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = AV50TFPacienteApellidoMaterno_Sel ;
      AV110Encuestawwds_24_tfpacientenombres = AV51TFPacienteNombres ;
      AV111Encuestawwds_25_tfpacientenombres_sel = AV52TFPacienteNombres_Sel ;
      AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV53TFSGCitaDisponibilidadClinicaId ;
      AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV54TFSGCitaDisponibilidadClinicaId_To ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV55TFSGCitaDisponibilidadClinicaNombre ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = AV58TFEncuestaAtencion_Sels ;
      AV117Encuestawwds_31_tfencuestaatendido_sels = AV60TFEncuestaAtendido_Sels ;
      AV118Encuestawwds_32_tfencuestahoraatencion = AV61TFEncuestaHoraAtencion ;
      AV119Encuestawwds_33_tfencuestahoraatencion_to = AV62TFEncuestaHoraAtencion_To ;
      AV120Encuestawwds_34_tfencuestacomentarios = AV65TFEncuestaComentarios ;
      AV121Encuestawwds_35_tfencuestacomentarios_sel = AV66TFEncuestaComentarios_Sel ;
      AV122Encuestawwds_36_tfencuestarecomendacion = AV67TFEncuestaRecomendacion ;
      AV123Encuestawwds_37_tfencuestarecomendacion_to = AV68TFEncuestaRecomendacion_To ;
      AV124Encuestawwds_38_tfencuestaestado_sels = AV70TFEncuestaEstado_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e121V2( )
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
         AV72PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV72PageToGo) ;
      }
   }

   public void e131V2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141V2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaId") == 0 )
         {
            AV27TFEncuestaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFEncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFEncuestaId), 4, 0));
            AV28TFEncuestaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFEncuestaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFEncuestaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaId") == 0 )
         {
            AV29TFCitaId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
            AV30TFCitaId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadProfesionalId") == 0 )
         {
            AV31TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFSGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFSGCitaDisponibilidadProfesionalId), 8, 0));
            AV32TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFSGCitaDisponibilidadProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFSGCitaDisponibilidadProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadProFullName") == 0 )
         {
            AV33TFSGCitaDisponibilidadProFullName = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSGCitaDisponibilidadProFullName", AV33TFSGCitaDisponibilidadProFullName);
            AV34TFSGCitaDisponibilidadProFullName_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFSGCitaDisponibilidadProFullName_Sel", AV34TFSGCitaDisponibilidadProFullName_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadEspecialidadId") == 0 )
         {
            AV35TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFSGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFSGCitaDisponibilidadEspecialidadId), 4, 0));
            AV36TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSGCitaDisponibilidadEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFSGCitaDisponibilidadEspecialidadId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadEspecialidadNombre") == 0 )
         {
            AV37TFSGCitaDisponibilidadEspecialidadNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFSGCitaDisponibilidadEspecialidadNombre", AV37TFSGCitaDisponibilidadEspecialidadNombre);
            AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadId") == 0 )
         {
            AV39TFSGCitaDisponibilidadId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39TFSGCitaDisponibilidadId), 8, 0));
            AV40TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFSGCitaDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40TFSGCitaDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadFecha") == 0 )
         {
            AV41TFSGCitaDisponibilidadFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSGCitaDisponibilidadFecha", localUtil.format(AV41TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV42TFSGCitaDisponibilidadFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSGCitaDisponibilidadFecha_To", localUtil.format(AV42TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteId") == 0 )
         {
            AV45TFPacienteId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFPacienteId), 8, 0));
            AV46TFPacienteId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFPacienteId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoPaterno") == 0 )
         {
            AV47TFPacienteApellidoPaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPacienteApellidoPaterno", AV47TFPacienteApellidoPaterno);
            AV48TFPacienteApellidoPaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFPacienteApellidoPaterno_Sel", AV48TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoMaterno") == 0 )
         {
            AV49TFPacienteApellidoMaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFPacienteApellidoMaterno", AV49TFPacienteApellidoMaterno);
            AV50TFPacienteApellidoMaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPacienteApellidoMaterno_Sel", AV50TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNombres") == 0 )
         {
            AV51TFPacienteNombres = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFPacienteNombres", AV51TFPacienteNombres);
            AV52TFPacienteNombres_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFPacienteNombres_Sel", AV52TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadClinicaId") == 0 )
         {
            AV53TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFSGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFSGCitaDisponibilidadClinicaId), 4, 0));
            AV54TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFSGCitaDisponibilidadClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFSGCitaDisponibilidadClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadClinicaNombre") == 0 )
         {
            AV55TFSGCitaDisponibilidadClinicaNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFSGCitaDisponibilidadClinicaNombre", AV55TFSGCitaDisponibilidadClinicaNombre);
            AV84TFSGCitaDisponibilidadClinicaNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84TFSGCitaDisponibilidadClinicaNombre_Sel", AV84TFSGCitaDisponibilidadClinicaNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaAtencion") == 0 )
         {
            AV57TFEncuestaAtencion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFEncuestaAtencion_SelsJson", AV57TFEncuestaAtencion_SelsJson);
            AV58TFEncuestaAtencion_Sels.fromJSonString(AV57TFEncuestaAtencion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaAtendido") == 0 )
         {
            AV59TFEncuestaAtendido_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFEncuestaAtendido_SelsJson", AV59TFEncuestaAtendido_SelsJson);
            AV60TFEncuestaAtendido_Sels.fromJSonString(AV59TFEncuestaAtendido_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaHoraAtencion") == 0 )
         {
            AV61TFEncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFEncuestaHoraAtencion", localUtil.ttoc( AV61TFEncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
            AV62TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFEncuestaHoraAtencion_To", localUtil.ttoc( AV62TFEncuestaHoraAtencion_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV62TFEncuestaHoraAtencion_To) )
            {
               AV62TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV62TFEncuestaHoraAtencion_To)), (byte)(GXutil.month( AV62TFEncuestaHoraAtencion_To)), (byte)(GXutil.day( AV62TFEncuestaHoraAtencion_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV62TFEncuestaHoraAtencion_To", localUtil.ttoc( AV62TFEncuestaHoraAtencion_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaComentarios") == 0 )
         {
            AV65TFEncuestaComentarios = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFEncuestaComentarios", AV65TFEncuestaComentarios);
            AV66TFEncuestaComentarios_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFEncuestaComentarios_Sel", AV66TFEncuestaComentarios_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaRecomendacion") == 0 )
         {
            AV67TFEncuestaRecomendacion = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFEncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFEncuestaRecomendacion), 2, 0));
            AV68TFEncuestaRecomendacion_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFEncuestaRecomendacion_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFEncuestaRecomendacion_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "EncuestaEstado") == 0 )
         {
            AV69TFEncuestaEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFEncuestaEstado_SelsJson", AV69TFEncuestaEstado_SelsJson);
            AV70TFEncuestaEstado_Sels.fromJSonString(AV69TFEncuestaEstado_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFEncuestaEstado_Sels", AV70TFEncuestaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFEncuestaAtendido_Sels", AV60TFEncuestaAtendido_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFEncuestaAtencion_Sels", AV58TFEncuestaAtencion_Sels);
   }

   private void e211V2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV75Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV75Update);
      if ( AV76IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.encuesta", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A37EncuestaId,4,0))}, new String[] {"Mode","EncuestaId"})  ;
      }
      AV77Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV77Delete);
      if ( AV78IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.encuesta", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A37EncuestaId,4,0))}, new String[] {"Mode","EncuestaId"})  ;
      }
      if ( AV81IsAuthorized_PacienteNombres )
      {
         edtPacienteNombres_Link = formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PacienteId","TabCode"})  ;
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

   public void e151V2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "EncuestaWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e111V2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("EncuestaWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV125Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("EncuestaWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "EncuestaWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         encuestaww_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV125Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFEncuestaAtencion_Sels", AV58TFEncuestaAtencion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFEncuestaAtendido_Sels", AV60TFEncuestaAtendido_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFEncuestaEstado_Sels", AV70TFEncuestaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e161V2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.encuesta", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","EncuestaId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e171V2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.encuestawwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      encuestaww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      encuestaww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFEncuestaEstado_Sels", AV70TFEncuestaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFEncuestaAtendido_Sels", AV60TFEncuestaAtendido_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFEncuestaAtencion_Sels", AV58TFEncuestaAtencion_Sels);
   }

   public void e181V2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.encuestawwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFEncuestaEstado_Sels", AV70TFEncuestaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFEncuestaAtendido_Sels", AV60TFEncuestaAtendido_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFEncuestaAtencion_Sels", AV58TFEncuestaAtencion_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Cita Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProfesionalId", "", "SGCita Disponibilidad Profesional Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProFullName", "", "SGCita Disponibilidad Pro Full Name", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadId", "", "SGCita Disponibilidad Especialidad Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadNombre", "", "SGCita Disponibilidad Especialidad Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadId", "", "SGCita Disponibilidad Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadFecha", "", "SGCita Disponibilidad Fecha", true, "") ;
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaId", "", "SGCita Disponibilidad Clinica Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaNombre", "", "SGCita Disponibilidad Clinica Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaAtencion", "", "Atencion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaAtendido", "", "Atendido", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaHoraAtencion", "", "Hora Atencion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaComentarios", "", "Comentarios", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaRecomendacion", "", "Recomendacion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EncuestaWWColumnsSelector", GXv_char8) ;
      encuestaww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV76IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Update", GXv_boolean2) ;
      encuestaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV76IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76IsAuthorized_Update", AV76IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV76IsAuthorized_Update));
      if ( ! ( AV76IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV78IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Delete", GXv_boolean2) ;
      encuestaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV78IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78IsAuthorized_Delete", AV78IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV78IsAuthorized_Delete));
      if ( ! ( AV78IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV79TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Insert", GXv_boolean2) ;
      encuestaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV79TempBoolean = GXt_boolean1 ;
      if ( ! ( AV79TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "EncuestaWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFEncuestaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFEncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFEncuestaId), 4, 0));
      AV28TFEncuestaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFEncuestaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFEncuestaId_To), 4, 0));
      AV29TFCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
      AV30TFCitaId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
      AV31TFSGCitaDisponibilidadProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFSGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFSGCitaDisponibilidadProfesionalId), 8, 0));
      AV32TFSGCitaDisponibilidadProfesionalId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFSGCitaDisponibilidadProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFSGCitaDisponibilidadProfesionalId_To), 8, 0));
      AV33TFSGCitaDisponibilidadProFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFSGCitaDisponibilidadProFullName", AV33TFSGCitaDisponibilidadProFullName);
      AV34TFSGCitaDisponibilidadProFullName_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFSGCitaDisponibilidadProFullName_Sel", AV34TFSGCitaDisponibilidadProFullName_Sel);
      AV35TFSGCitaDisponibilidadEspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFSGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFSGCitaDisponibilidadEspecialidadId), 4, 0));
      AV36TFSGCitaDisponibilidadEspecialidadId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFSGCitaDisponibilidadEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFSGCitaDisponibilidadEspecialidadId_To), 4, 0));
      AV37TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFSGCitaDisponibilidadEspecialidadNombre", AV37TFSGCitaDisponibilidadEspecialidadNombre);
      AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel);
      AV39TFSGCitaDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39TFSGCitaDisponibilidadId), 8, 0));
      AV40TFSGCitaDisponibilidadId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFSGCitaDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40TFSGCitaDisponibilidadId_To), 8, 0));
      AV41TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFSGCitaDisponibilidadFecha", localUtil.format(AV41TFSGCitaDisponibilidadFecha, "99/99/99"));
      AV42TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFSGCitaDisponibilidadFecha_To", localUtil.format(AV42TFSGCitaDisponibilidadFecha_To, "99/99/99"));
      AV45TFPacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFPacienteId), 8, 0));
      AV46TFPacienteId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFPacienteId_To), 8, 0));
      AV47TFPacienteApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFPacienteApellidoPaterno", AV47TFPacienteApellidoPaterno);
      AV48TFPacienteApellidoPaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFPacienteApellidoPaterno_Sel", AV48TFPacienteApellidoPaterno_Sel);
      AV49TFPacienteApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFPacienteApellidoMaterno", AV49TFPacienteApellidoMaterno);
      AV50TFPacienteApellidoMaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFPacienteApellidoMaterno_Sel", AV50TFPacienteApellidoMaterno_Sel);
      AV51TFPacienteNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFPacienteNombres", AV51TFPacienteNombres);
      AV52TFPacienteNombres_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFPacienteNombres_Sel", AV52TFPacienteNombres_Sel);
      AV53TFSGCitaDisponibilidadClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFSGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFSGCitaDisponibilidadClinicaId), 4, 0));
      AV54TFSGCitaDisponibilidadClinicaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFSGCitaDisponibilidadClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFSGCitaDisponibilidadClinicaId_To), 4, 0));
      AV55TFSGCitaDisponibilidadClinicaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFSGCitaDisponibilidadClinicaNombre", AV55TFSGCitaDisponibilidadClinicaNombre);
      AV84TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84TFSGCitaDisponibilidadClinicaNombre_Sel", AV84TFSGCitaDisponibilidadClinicaNombre_Sel);
      AV58TFEncuestaAtencion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60TFEncuestaAtendido_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61TFEncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFEncuestaHoraAtencion", localUtil.ttoc( AV61TFEncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
      AV62TFEncuestaHoraAtencion_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFEncuestaHoraAtencion_To", localUtil.ttoc( AV62TFEncuestaHoraAtencion_To, 0, 5, 0, 3, "/", ":", " "));
      AV65TFEncuestaComentarios = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFEncuestaComentarios", AV65TFEncuestaComentarios);
      AV66TFEncuestaComentarios_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFEncuestaComentarios_Sel", AV66TFEncuestaComentarios_Sel);
      AV67TFEncuestaRecomendacion = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFEncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFEncuestaRecomendacion), 2, 0));
      AV68TFEncuestaRecomendacion_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68TFEncuestaRecomendacion_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFEncuestaRecomendacion_To), 2, 0));
      AV70TFEncuestaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV125Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV125Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV125Pgmname+"GridState"), null, null);
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
      AV126GXV1 = 1 ;
      while ( AV126GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV126GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAID") == 0 )
         {
            AV27TFEncuestaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFEncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFEncuestaId), 4, 0));
            AV28TFEncuestaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFEncuestaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFEncuestaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV29TFCitaId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
            AV30TFCitaId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV31TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFSGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFSGCitaDisponibilidadProfesionalId), 8, 0));
            AV32TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFSGCitaDisponibilidadProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFSGCitaDisponibilidadProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV33TFSGCitaDisponibilidadProFullName = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSGCitaDisponibilidadProFullName", AV33TFSGCitaDisponibilidadProFullName);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV34TFSGCitaDisponibilidadProFullName_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFSGCitaDisponibilidadProFullName_Sel", AV34TFSGCitaDisponibilidadProFullName_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV35TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFSGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFSGCitaDisponibilidadEspecialidadId), 4, 0));
            AV36TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSGCitaDisponibilidadEspecialidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFSGCitaDisponibilidadEspecialidadId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV37TFSGCitaDisponibilidadEspecialidadNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFSGCitaDisponibilidadEspecialidadNombre", AV37TFSGCitaDisponibilidadEspecialidadNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV39TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39TFSGCitaDisponibilidadId), 8, 0));
            AV40TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFSGCitaDisponibilidadId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40TFSGCitaDisponibilidadId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV41TFSGCitaDisponibilidadFecha = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSGCitaDisponibilidadFecha", localUtil.format(AV41TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV42TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSGCitaDisponibilidadFecha_To", localUtil.format(AV42TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV45TFPacienteId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFPacienteId), 8, 0));
            AV46TFPacienteId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFPacienteId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV47TFPacienteApellidoPaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPacienteApellidoPaterno", AV47TFPacienteApellidoPaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV48TFPacienteApellidoPaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFPacienteApellidoPaterno_Sel", AV48TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV49TFPacienteApellidoMaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFPacienteApellidoMaterno", AV49TFPacienteApellidoMaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV50TFPacienteApellidoMaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPacienteApellidoMaterno_Sel", AV50TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV51TFPacienteNombres = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFPacienteNombres", AV51TFPacienteNombres);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV52TFPacienteNombres_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFPacienteNombres_Sel", AV52TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV53TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFSGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFSGCitaDisponibilidadClinicaId), 4, 0));
            AV54TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFSGCitaDisponibilidadClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFSGCitaDisponibilidadClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV55TFSGCitaDisponibilidadClinicaNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFSGCitaDisponibilidadClinicaNombre", AV55TFSGCitaDisponibilidadClinicaNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV84TFSGCitaDisponibilidadClinicaNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84TFSGCitaDisponibilidadClinicaNombre_Sel", AV84TFSGCitaDisponibilidadClinicaNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENCION_SEL") == 0 )
         {
            AV57TFEncuestaAtencion_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFEncuestaAtencion_SelsJson", AV57TFEncuestaAtencion_SelsJson);
            AV58TFEncuestaAtencion_Sels.fromJSonString(AV57TFEncuestaAtencion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENDIDO_SEL") == 0 )
         {
            AV59TFEncuestaAtendido_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFEncuestaAtendido_SelsJson", AV59TFEncuestaAtendido_SelsJson);
            AV60TFEncuestaAtendido_Sels.fromJSonString(AV59TFEncuestaAtendido_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAHORAATENCION") == 0 )
         {
            AV61TFEncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFEncuestaHoraAtencion", localUtil.ttoc( AV61TFEncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
            AV62TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFEncuestaHoraAtencion_To", localUtil.ttoc( AV62TFEncuestaHoraAtencion_To, 0, 5, 0, 3, "/", ":", " "));
            AV63DDO_EncuestaHoraAtencionAuxDate = GXutil.resetTime(AV61TFEncuestaHoraAtencion) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63DDO_EncuestaHoraAtencionAuxDate", localUtil.format(AV63DDO_EncuestaHoraAtencionAuxDate, "99/99/99"));
            AV64DDO_EncuestaHoraAtencionAuxDateTo = GXutil.resetTime(AV62TFEncuestaHoraAtencion_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64DDO_EncuestaHoraAtencionAuxDateTo", localUtil.format(AV64DDO_EncuestaHoraAtencionAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS") == 0 )
         {
            AV65TFEncuestaComentarios = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFEncuestaComentarios", AV65TFEncuestaComentarios);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS_SEL") == 0 )
         {
            AV66TFEncuestaComentarios_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFEncuestaComentarios_Sel", AV66TFEncuestaComentarios_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTARECOMENDACION") == 0 )
         {
            AV67TFEncuestaRecomendacion = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFEncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFEncuestaRecomendacion), 2, 0));
            AV68TFEncuestaRecomendacion_To = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFEncuestaRecomendacion_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFEncuestaRecomendacion_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAESTADO_SEL") == 0 )
         {
            AV69TFEncuestaEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFEncuestaEstado_SelsJson", AV69TFEncuestaEstado_SelsJson);
            AV70TFEncuestaEstado_Sels.fromJSonString(AV69TFEncuestaEstado_SelsJson, null);
         }
         AV126GXV1 = (int)(AV126GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFSGCitaDisponibilidadProFullName_Sel)==0), AV34TFSGCitaDisponibilidadProFullName_Sel, GXv_char8) ;
      encuestaww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0), AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, GXv_char7) ;
      encuestaww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV48TFPacienteApellidoPaterno_Sel)==0), AV48TFPacienteApellidoPaterno_Sel, GXv_char15) ;
      encuestaww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV50TFPacienteApellidoMaterno_Sel)==0), AV50TFPacienteApellidoMaterno_Sel, GXv_char17) ;
      encuestaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFPacienteNombres_Sel)==0), AV52TFPacienteNombres_Sel, GXv_char19) ;
      encuestaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV84TFSGCitaDisponibilidadClinicaNombre_Sel)==0), AV84TFSGCitaDisponibilidadClinicaNombre_Sel, GXv_char21) ;
      encuestaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV58TFEncuestaAtencion_Sels.size()==0), AV57TFEncuestaAtencion_SelsJson, GXv_char23) ;
      encuestaww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV60TFEncuestaAtendido_Sels.size()==0), AV59TFEncuestaAtendido_SelsJson, GXv_char25) ;
      encuestaww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV66TFEncuestaComentarios_Sel)==0), AV66TFEncuestaComentarios_Sel, GXv_char27) ;
      encuestaww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV70TFEncuestaEstado_Sels.size()==0), AV69TFEncuestaEstado_SelsJson, GXv_char29) ;
      encuestaww_impl.this.GXt_char28 = GXv_char29[0] ;
      Ddo_grid_Selectedvalue_set = "|||"+GXt_char6+"||"+GXt_char13+"||||"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"||"+GXt_char20+"|"+GXt_char22+"|"+GXt_char24+"||"+GXt_char26+"||"+GXt_char28 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFSGCitaDisponibilidadProFullName)==0), AV33TFSGCitaDisponibilidadProFullName, GXv_char29) ;
      encuestaww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFSGCitaDisponibilidadEspecialidadNombre)==0), AV37TFSGCitaDisponibilidadEspecialidadNombre, GXv_char27) ;
      encuestaww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV47TFPacienteApellidoPaterno)==0), AV47TFPacienteApellidoPaterno, GXv_char25) ;
      encuestaww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFPacienteApellidoMaterno)==0), AV49TFPacienteApellidoMaterno, GXv_char23) ;
      encuestaww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV51TFPacienteNombres)==0), AV51TFPacienteNombres, GXv_char21) ;
      encuestaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV55TFSGCitaDisponibilidadClinicaNombre)==0), AV55TFSGCitaDisponibilidadClinicaNombre, GXv_char19) ;
      encuestaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV65TFEncuestaComentarios)==0), AV65TFEncuestaComentarios, GXv_char17) ;
      encuestaww_impl.this.GXt_char16 = GXv_char17[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFEncuestaId) ? "" : GXutil.str( AV27TFEncuestaId, 4, 0))+"|"+((0==AV29TFCitaId) ? "" : GXutil.str( AV29TFCitaId, 8, 0))+"|"+((0==AV31TFSGCitaDisponibilidadProfesionalId) ? "" : GXutil.str( AV31TFSGCitaDisponibilidadProfesionalId, 8, 0))+"|"+GXt_char28+"|"+((0==AV35TFSGCitaDisponibilidadEspecialidadId) ? "" : GXutil.str( AV35TFSGCitaDisponibilidadEspecialidadId, 4, 0))+"|"+GXt_char26+"|"+((0==AV39TFSGCitaDisponibilidadId) ? "" : GXutil.str( AV39TFSGCitaDisponibilidadId, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFSGCitaDisponibilidadFecha)) ? "" : localUtil.dtoc( AV41TFSGCitaDisponibilidadFecha, 3, "/"))+"|"+((0==AV45TFPacienteId) ? "" : GXutil.str( AV45TFPacienteId, 8, 0))+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+((0==AV53TFSGCitaDisponibilidadClinicaId) ? "" : GXutil.str( AV53TFSGCitaDisponibilidadClinicaId, 4, 0))+"|"+GXt_char18+"|||"+(GXutil.dateCompare(GXutil.nullDate(), AV61TFEncuestaHoraAtencion) ? "" : localUtil.dtoc( AV63DDO_EncuestaHoraAtencionAuxDate, 3, "/"))+"|"+GXt_char16+"|"+((0==AV67TFEncuestaRecomendacion) ? "" : GXutil.str( AV67TFEncuestaRecomendacion, 2, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFEncuestaId_To) ? "" : GXutil.str( AV28TFEncuestaId_To, 4, 0))+"|"+((0==AV30TFCitaId_To) ? "" : GXutil.str( AV30TFCitaId_To, 8, 0))+"|"+((0==AV32TFSGCitaDisponibilidadProfesionalId_To) ? "" : GXutil.str( AV32TFSGCitaDisponibilidadProfesionalId_To, 8, 0))+"||"+((0==AV36TFSGCitaDisponibilidadEspecialidadId_To) ? "" : GXutil.str( AV36TFSGCitaDisponibilidadEspecialidadId_To, 4, 0))+"||"+((0==AV40TFSGCitaDisponibilidadId_To) ? "" : GXutil.str( AV40TFSGCitaDisponibilidadId_To, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFSGCitaDisponibilidadFecha_To)) ? "" : localUtil.dtoc( AV42TFSGCitaDisponibilidadFecha_To, 3, "/"))+"|"+((0==AV46TFPacienteId_To) ? "" : GXutil.str( AV46TFPacienteId_To, 8, 0))+"||||"+((0==AV54TFSGCitaDisponibilidadClinicaId_To) ? "" : GXutil.str( AV54TFSGCitaDisponibilidadClinicaId_To, 4, 0))+"||||"+(GXutil.dateCompare(GXutil.nullDate(), AV62TFEncuestaHoraAtencion_To) ? "" : localUtil.dtoc( AV64DDO_EncuestaHoraAtencionAuxDateTo, 3, "/"))+"||"+((0==AV68TFEncuestaRecomendacion_To) ? "" : GXutil.str( AV68TFEncuestaRecomendacion_To, 2, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV125Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTAID", !((0==AV27TFEncuestaId)&&(0==AV28TFEncuestaId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFEncuestaId, 4, 0)), GXutil.trim( GXutil.str( AV28TFEncuestaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFCITAID", !((0==AV29TFCitaId)&&(0==AV30TFCitaId_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFCitaId, 8, 0)), GXutil.trim( GXutil.str( AV30TFCitaId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADPROFESIONALID", !((0==AV31TFSGCitaDisponibilidadProfesionalId)&&(0==AV32TFSGCitaDisponibilidadProfesionalId_To)), (short)(0), GXutil.trim( GXutil.str( AV31TFSGCitaDisponibilidadProfesionalId, 8, 0)), GXutil.trim( GXutil.str( AV32TFSGCitaDisponibilidadProfesionalId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADPROFULLNAME", !(GXutil.strcmp("", AV33TFSGCitaDisponibilidadProFullName)==0), (short)(0), AV33TFSGCitaDisponibilidadProFullName, "", !(GXutil.strcmp("", AV34TFSGCitaDisponibilidadProFullName_Sel)==0), AV34TFSGCitaDisponibilidadProFullName_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADESPECIALIDADID", !((0==AV35TFSGCitaDisponibilidadEspecialidadId)&&(0==AV36TFSGCitaDisponibilidadEspecialidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV35TFSGCitaDisponibilidadEspecialidadId, 4, 0)), GXutil.trim( GXutil.str( AV36TFSGCitaDisponibilidadEspecialidadId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE", !(GXutil.strcmp("", AV37TFSGCitaDisponibilidadEspecialidadNombre)==0), (short)(0), AV37TFSGCitaDisponibilidadEspecialidadNombre, "", !(GXutil.strcmp("", AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0), AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADID", !((0==AV39TFSGCitaDisponibilidadId)&&(0==AV40TFSGCitaDisponibilidadId_To)), (short)(0), GXutil.trim( GXutil.str( AV39TFSGCitaDisponibilidadId, 8, 0)), GXutil.trim( GXutil.str( AV40TFSGCitaDisponibilidadId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADFECHA", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFSGCitaDisponibilidadFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFSGCitaDisponibilidadFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV41TFSGCitaDisponibilidadFecha, 3, "/")), GXutil.trim( localUtil.dtoc( AV42TFSGCitaDisponibilidadFecha_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFPACIENTEID", !((0==AV45TFPacienteId)&&(0==AV46TFPacienteId_To)), (short)(0), GXutil.trim( GXutil.str( AV45TFPacienteId, 8, 0)), GXutil.trim( GXutil.str( AV46TFPacienteId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFPACIENTEAPELLIDOPATERNO", !(GXutil.strcmp("", AV47TFPacienteApellidoPaterno)==0), (short)(0), AV47TFPacienteApellidoPaterno, "", !(GXutil.strcmp("", AV48TFPacienteApellidoPaterno_Sel)==0), AV48TFPacienteApellidoPaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFPACIENTEAPELLIDOMATERNO", !(GXutil.strcmp("", AV49TFPacienteApellidoMaterno)==0), (short)(0), AV49TFPacienteApellidoMaterno, "", !(GXutil.strcmp("", AV50TFPacienteApellidoMaterno_Sel)==0), AV50TFPacienteApellidoMaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFPACIENTENOMBRES", !(GXutil.strcmp("", AV51TFPacienteNombres)==0), (short)(0), AV51TFPacienteNombres, "", !(GXutil.strcmp("", AV52TFPacienteNombres_Sel)==0), AV52TFPacienteNombres_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADCLINICAID", !((0==AV53TFSGCitaDisponibilidadClinicaId)&&(0==AV54TFSGCitaDisponibilidadClinicaId_To)), (short)(0), GXutil.trim( GXutil.str( AV53TFSGCitaDisponibilidadClinicaId, 4, 0)), GXutil.trim( GXutil.str( AV54TFSGCitaDisponibilidadClinicaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFSGCITADISPONIBILIDADCLINICANOMBRE", !(GXutil.strcmp("", AV55TFSGCitaDisponibilidadClinicaNombre)==0), (short)(0), AV55TFSGCitaDisponibilidadClinicaNombre, "", !(GXutil.strcmp("", AV84TFSGCitaDisponibilidadClinicaNombre_Sel)==0), AV84TFSGCitaDisponibilidadClinicaNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTAATENCION_SEL", !(AV58TFEncuestaAtencion_Sels.size()==0), (short)(0), AV58TFEncuestaAtencion_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTAATENDIDO_SEL", !(AV60TFEncuestaAtendido_Sels.size()==0), (short)(0), AV60TFEncuestaAtendido_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTAHORAATENCION", !(GXutil.dateCompare(GXutil.nullDate(), AV61TFEncuestaHoraAtencion)&&GXutil.dateCompare(GXutil.nullDate(), AV62TFEncuestaHoraAtencion_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV61TFEncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV62TFEncuestaHoraAtencion_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTACOMENTARIOS", !(GXutil.strcmp("", AV65TFEncuestaComentarios)==0), (short)(0), AV65TFEncuestaComentarios, "", !(GXutil.strcmp("", AV66TFEncuestaComentarios_Sel)==0), AV66TFEncuestaComentarios_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTARECOMENDACION", !((0==AV67TFEncuestaRecomendacion)&&(0==AV68TFEncuestaRecomendacion_To)), (short)(0), GXutil.trim( GXutil.str( AV67TFEncuestaRecomendacion, 2, 0)), GXutil.trim( GXutil.str( AV68TFEncuestaRecomendacion_To, 2, 0))) ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      GXv_SdtWWPGridState30[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState30, "TFENCUESTAESTADO_SEL", !(AV70TFEncuestaEstado_Sels.size()==0), (short)(0), AV70TFEncuestaEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState30[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV125Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV125Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Encuesta" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_1V2( boolean wbgen )
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
         wb_table2_30_1V2( true) ;
      }
      else
      {
         wb_table2_30_1V2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_1V2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_1V2e( true) ;
      }
      else
      {
         wb_table1_25_1V2e( false) ;
      }
   }

   public void wb_table2_30_1V2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_EncuestaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_1V2e( true) ;
      }
      else
      {
         wb_table2_30_1V2e( false) ;
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
      pa1V2( ) ;
      ws1V2( ) ;
      we1V2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033343", true, true);
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
      httpContext.AddJavascriptSource("encuestaww.js", "?2022511033343", false, true);
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
      edtEncuestaId_Internalname = "ENCUESTAID_"+sGXsfl_43_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_43_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_43_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_43_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_43_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID_"+sGXsfl_43_idx ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE_"+sGXsfl_43_idx ;
      cmbEncuestaAtencion.setInternalname( "ENCUESTAATENCION_"+sGXsfl_43_idx );
      cmbEncuestaAtendido.setInternalname( "ENCUESTAATENDIDO_"+sGXsfl_43_idx );
      edtEncuestaHoraAtencion_Internalname = "ENCUESTAHORAATENCION_"+sGXsfl_43_idx ;
      edtEncuestaComentarios_Internalname = "ENCUESTACOMENTARIOS_"+sGXsfl_43_idx ;
      edtEncuestaRecomendacion_Internalname = "ENCUESTARECOMENDACION_"+sGXsfl_43_idx ;
      cmbEncuestaEstado.setInternalname( "ENCUESTAESTADO_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtEncuestaId_Internalname = "ENCUESTAID_"+sGXsfl_43_fel_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_43_fel_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_43_fel_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_43_fel_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_43_fel_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID_"+sGXsfl_43_fel_idx ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE_"+sGXsfl_43_fel_idx ;
      cmbEncuestaAtencion.setInternalname( "ENCUESTAATENCION_"+sGXsfl_43_fel_idx );
      cmbEncuestaAtendido.setInternalname( "ENCUESTAATENDIDO_"+sGXsfl_43_fel_idx );
      edtEncuestaHoraAtencion_Internalname = "ENCUESTAHORAATENCION_"+sGXsfl_43_fel_idx ;
      edtEncuestaComentarios_Internalname = "ENCUESTACOMENTARIOS_"+sGXsfl_43_fel_idx ;
      edtEncuestaRecomendacion_Internalname = "ENCUESTARECOMENDACION_"+sGXsfl_43_fel_idx ;
      cmbEncuestaEstado.setInternalname( "ENCUESTAESTADO_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb1V0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV75Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV77Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEncuestaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEncuestaId_Internalname,GXutil.ltrim( localUtil.ntoc( A37EncuestaId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEncuestaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEncuestaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadEspecialidadNombre_Internalname,A146SGCitaDisponibilidadEspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSGCitaDisponibilidadEspecialidadNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbEncuestaAtencion.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbEncuestaAtencion.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "ENCUESTAATENCION_" + sGXsfl_43_idx ;
            cmbEncuestaAtencion.setName( GXCCtl );
            cmbEncuestaAtencion.setWebtags( "" );
            cmbEncuestaAtencion.addItem("B", "Buena", (short)(0));
            cmbEncuestaAtencion.addItem("R", "Regular", (short)(0));
            cmbEncuestaAtencion.addItem("M", "Mala", (short)(0));
            if ( cmbEncuestaAtencion.getItemCount() > 0 )
            {
               A148EncuestaAtencion = cmbEncuestaAtencion.getValidValue(A148EncuestaAtencion) ;
               n148EncuestaAtencion = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEncuestaAtencion,cmbEncuestaAtencion.getInternalname(),GXutil.rtrim( A148EncuestaAtencion),Integer.valueOf(1),cmbEncuestaAtencion.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbEncuestaAtencion.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbEncuestaAtencion.setValue( GXutil.rtrim( A148EncuestaAtencion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtencion.getInternalname(), "Values", cmbEncuestaAtencion.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbEncuestaAtendido.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbEncuestaAtendido.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "ENCUESTAATENDIDO_" + sGXsfl_43_idx ;
            cmbEncuestaAtendido.setName( GXCCtl );
            cmbEncuestaAtendido.setWebtags( "" );
            cmbEncuestaAtendido.addItem("S", "Si", (short)(0));
            cmbEncuestaAtendido.addItem("N", "No", (short)(0));
            if ( cmbEncuestaAtendido.getItemCount() > 0 )
            {
               A149EncuestaAtendido = cmbEncuestaAtendido.getValidValue(A149EncuestaAtendido) ;
               n149EncuestaAtendido = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEncuestaAtendido,cmbEncuestaAtendido.getInternalname(),GXutil.rtrim( A149EncuestaAtendido),Integer.valueOf(1),cmbEncuestaAtendido.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbEncuestaAtendido.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbEncuestaAtendido.setValue( GXutil.rtrim( A149EncuestaAtendido) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtendido.getInternalname(), "Values", cmbEncuestaAtendido.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEncuestaHoraAtencion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEncuestaHoraAtencion_Internalname,localUtil.ttoc( A150EncuestaHoraAtencion, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A150EncuestaHoraAtencion, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEncuestaHoraAtencion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEncuestaHoraAtencion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtEncuestaComentarios_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEncuestaComentarios_Internalname,A151EncuestaComentarios,A151EncuestaComentarios,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEncuestaComentarios_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEncuestaComentarios_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtEncuestaRecomendacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEncuestaRecomendacion_Internalname,GXutil.ltrim( localUtil.ntoc( A152EncuestaRecomendacion, (byte)(2), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEncuestaRecomendacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtEncuestaRecomendacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbEncuestaEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbEncuestaEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "ENCUESTAESTADO_" + sGXsfl_43_idx ;
            cmbEncuestaEstado.setName( GXCCtl );
            cmbEncuestaEstado.setWebtags( "" );
            cmbEncuestaEstado.addItem("P", "Pendiente", (short)(0));
            cmbEncuestaEstado.addItem("R", "Realizada", (short)(0));
            cmbEncuestaEstado.addItem("", "", (short)(0));
            if ( cmbEncuestaEstado.getItemCount() > 0 )
            {
               A153EncuestaEstado = cmbEncuestaEstado.getValidValue(A153EncuestaEstado) ;
               n153EncuestaEstado = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbEncuestaEstado,cmbEncuestaEstado.getInternalname(),GXutil.rtrim( A153EncuestaEstado),Integer.valueOf(1),cmbEncuestaEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbEncuestaEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbEncuestaEstado.setValue( GXutil.rtrim( A153EncuestaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaEstado.getInternalname(), "Values", cmbEncuestaEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes1V2( ) ;
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
      edtEncuestaId_Internalname = "ENCUESTAID" ;
      edtCitaId_Internalname = "CITAID" ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID" ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME" ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtPacienteId_Internalname = "PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE" ;
      cmbEncuestaAtencion.setInternalname( "ENCUESTAATENCION" );
      cmbEncuestaAtendido.setInternalname( "ENCUESTAATENDIDO" );
      edtEncuestaHoraAtencion_Internalname = "ENCUESTAHORAATENCION" ;
      edtEncuestaComentarios_Internalname = "ENCUESTACOMENTARIOS" ;
      edtEncuestaRecomendacion_Internalname = "ENCUESTARECOMENDACION" ;
      cmbEncuestaEstado.setInternalname( "ENCUESTAESTADO" );
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
      edtavDdo_encuestahoraatencionauxdatetext_Internalname = "vDDO_ENCUESTAHORAATENCIONAUXDATETEXT" ;
      Tfencuestahoraatencion_rangepicker_Internalname = "TFENCUESTAHORAATENCION_RANGEPICKER" ;
      divDdo_encuestahoraatencionauxdates_Internalname = "DDO_ENCUESTAHORAATENCIONAUXDATES" ;
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
      cmbEncuestaEstado.setJsonclick( "" );
      edtEncuestaRecomendacion_Jsonclick = "" ;
      edtEncuestaComentarios_Jsonclick = "" ;
      edtEncuestaHoraAtencion_Jsonclick = "" ;
      cmbEncuestaAtendido.setJsonclick( "" );
      cmbEncuestaAtencion.setJsonclick( "" );
      edtSGCitaDisponibilidadClinicaNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaId_Jsonclick = "" ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteId_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadProFullName_Jsonclick = "" ;
      edtSGCitaDisponibilidadProfesionalId_Jsonclick = "" ;
      edtCitaId_Jsonclick = "" ;
      edtEncuestaId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_encuestahoraatencionauxdatetext_Jsonclick = "" ;
      edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtPacienteNombres_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbEncuestaEstado.setVisible( -1 );
      edtEncuestaRecomendacion_Visible = -1 ;
      edtEncuestaComentarios_Visible = -1 ;
      edtEncuestaHoraAtencion_Visible = -1 ;
      cmbEncuestaAtendido.setVisible( -1 );
      cmbEncuestaAtencion.setVisible( -1 );
      edtSGCitaDisponibilidadClinicaNombre_Visible = -1 ;
      edtSGCitaDisponibilidadClinicaId_Visible = -1 ;
      edtPacienteNombres_Visible = -1 ;
      edtPacienteApellidoMaterno_Visible = -1 ;
      edtPacienteApellidoPaterno_Visible = -1 ;
      edtPacienteId_Visible = -1 ;
      edtSGCitaDisponibilidadFecha_Visible = -1 ;
      edtSGCitaDisponibilidadId_Visible = -1 ;
      edtSGCitaDisponibilidadEspecialidadNombre_Visible = -1 ;
      edtSGCitaDisponibilidadEspecialidadId_Visible = -1 ;
      edtSGCitaDisponibilidadProFullName_Visible = -1 ;
      edtSGCitaDisponibilidadProfesionalId_Visible = -1 ;
      edtCitaId_Visible = -1 ;
      edtEncuestaId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Encuesta" );
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
      Ddo_grid_Datalistproc = "EncuestaWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||||||||||B:Buena,R:Regular,M:Mala|S:Si,N:No||||P:Pendiente,R:Realizada,:" ;
      Ddo_grid_Allowmultipleselection = "||||||||||||||T|T||||T" ;
      Ddo_grid_Datalisttype = "|||Dynamic||Dynamic||||Dynamic|Dynamic|Dynamic||Dynamic|FixedValues|FixedValues||Dynamic||FixedValues" ;
      Ddo_grid_Includedatalist = "|||T||T||||T|T|T||T|T|T||T||T" ;
      Ddo_grid_Filterisrange = "T|T|T||T||T|P|T||||T||||P||T|" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Numeric|Character|Numeric|Character|Numeric|Date|Numeric|Character|Character|Character|Numeric|Character|||Date|Character|Numeric|" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|T|T|T|T|T|T|||T|T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7|8|9|10|11|12|13|14|15|1|16|17|18|19|20" ;
      Ddo_grid_Columnids = "2:EncuestaId|3:CitaId|4:SGCitaDisponibilidadProfesionalId|5:SGCitaDisponibilidadProFullName|6:SGCitaDisponibilidadEspecialidadId|7:SGCitaDisponibilidadEspecialidadNombre|8:SGCitaDisponibilidadId|9:SGCitaDisponibilidadFecha|10:PacienteId|11:PacienteApellidoPaterno|12:PacienteApellidoMaterno|13:PacienteNombres|14:SGCitaDisponibilidadClinicaId|15:SGCitaDisponibilidadClinicaNombre|16:EncuestaAtencion|17:EncuestaAtendido|18:EncuestaHoraAtencion|19:EncuestaComentarios|20:EncuestaRecomendacion|21:EncuestaEstado" ;
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
      GXCCtl = "ENCUESTAATENCION_" + sGXsfl_43_idx ;
      cmbEncuestaAtencion.setName( GXCCtl );
      cmbEncuestaAtencion.setWebtags( "" );
      cmbEncuestaAtencion.addItem("B", "Buena", (short)(0));
      cmbEncuestaAtencion.addItem("R", "Regular", (short)(0));
      cmbEncuestaAtencion.addItem("M", "Mala", (short)(0));
      if ( cmbEncuestaAtencion.getItemCount() > 0 )
      {
         A148EncuestaAtencion = cmbEncuestaAtencion.getValidValue(A148EncuestaAtencion) ;
         n148EncuestaAtencion = false ;
      }
      GXCCtl = "ENCUESTAATENDIDO_" + sGXsfl_43_idx ;
      cmbEncuestaAtendido.setName( GXCCtl );
      cmbEncuestaAtendido.setWebtags( "" );
      cmbEncuestaAtendido.addItem("S", "Si", (short)(0));
      cmbEncuestaAtendido.addItem("N", "No", (short)(0));
      if ( cmbEncuestaAtendido.getItemCount() > 0 )
      {
         A149EncuestaAtendido = cmbEncuestaAtendido.getValidValue(A149EncuestaAtendido) ;
         n149EncuestaAtendido = false ;
      }
      GXCCtl = "ENCUESTAESTADO_" + sGXsfl_43_idx ;
      cmbEncuestaEstado.setName( GXCCtl );
      cmbEncuestaEstado.setWebtags( "" );
      cmbEncuestaEstado.addItem("P", "Pendiente", (short)(0));
      cmbEncuestaEstado.addItem("R", "Realizada", (short)(0));
      cmbEncuestaEstado.addItem("", "", (short)(0));
      if ( cmbEncuestaEstado.getItemCount() > 0 )
      {
         A153EncuestaEstado = cmbEncuestaEstado.getValidValue(A153EncuestaEstado) ;
         n153EncuestaEstado = false ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtEncuestaId_Visible',ctrl:'ENCUESTAID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProfesionalId_Visible',ctrl:'SGCITADISPONIBILIDADPROFESIONALID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProFullName_Visible',ctrl:'SGCITADISPONIBILIDADPROFULLNAME',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadId_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadId_Visible',ctrl:'SGCITADISPONIBILIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaId_Visible',ctrl:'SGCITADISPONIBILIDADCLINICAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaNombre_Visible',ctrl:'SGCITADISPONIBILIDADCLINICANOMBRE',prop:'Visible'},{av:'cmbEncuestaAtencion'},{av:'cmbEncuestaAtendido'},{av:'edtEncuestaHoraAtencion_Visible',ctrl:'ENCUESTAHORAATENCION',prop:'Visible'},{av:'edtEncuestaComentarios_Visible',ctrl:'ENCUESTACOMENTARIOS',prop:'Visible'},{av:'edtEncuestaRecomendacion_Visible',ctrl:'ENCUESTARECOMENDACION',prop:'Visible'},{av:'cmbEncuestaEstado'},{av:'AV73GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV74GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e211V2',iparms:[{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A37EncuestaId',fld:'ENCUESTAID',pic:'ZZZ9',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV75Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV77Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtPacienteNombres_Link',ctrl:'PACIENTENOMBRES',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e151V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtEncuestaId_Visible',ctrl:'ENCUESTAID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProfesionalId_Visible',ctrl:'SGCITADISPONIBILIDADPROFESIONALID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProFullName_Visible',ctrl:'SGCITADISPONIBILIDADPROFULLNAME',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadId_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadId_Visible',ctrl:'SGCITADISPONIBILIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaId_Visible',ctrl:'SGCITADISPONIBILIDADCLINICAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaNombre_Visible',ctrl:'SGCITADISPONIBILIDADCLINICANOMBRE',prop:'Visible'},{av:'cmbEncuestaAtencion'},{av:'cmbEncuestaAtendido'},{av:'edtEncuestaHoraAtencion_Visible',ctrl:'ENCUESTAHORAATENCION',prop:'Visible'},{av:'edtEncuestaComentarios_Visible',ctrl:'ENCUESTACOMENTARIOS',prop:'Visible'},{av:'edtEncuestaRecomendacion_Visible',ctrl:'ENCUESTARECOMENDACION',prop:'Visible'},{av:'cmbEncuestaEstado'},{av:'AV73GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV74GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV63DDO_EncuestaHoraAtencionAuxDate',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATE',pic:''},{av:'AV64DDO_EncuestaHoraAtencionAuxDateTo',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATETO',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV63DDO_EncuestaHoraAtencionAuxDate',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATE',pic:''},{av:'AV64DDO_EncuestaHoraAtencionAuxDateTo',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATETO',pic:''},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtEncuestaId_Visible',ctrl:'ENCUESTAID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProfesionalId_Visible',ctrl:'SGCITADISPONIBILIDADPROFESIONALID',prop:'Visible'},{av:'edtSGCitaDisponibilidadProFullName_Visible',ctrl:'SGCITADISPONIBILIDADPROFULLNAME',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadId_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadEspecialidadNombre_Visible',ctrl:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',prop:'Visible'},{av:'edtSGCitaDisponibilidadId_Visible',ctrl:'SGCITADISPONIBILIDADID',prop:'Visible'},{av:'edtSGCitaDisponibilidadFecha_Visible',ctrl:'SGCITADISPONIBILIDADFECHA',prop:'Visible'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaId_Visible',ctrl:'SGCITADISPONIBILIDADCLINICAID',prop:'Visible'},{av:'edtSGCitaDisponibilidadClinicaNombre_Visible',ctrl:'SGCITADISPONIBILIDADCLINICANOMBRE',prop:'Visible'},{av:'cmbEncuestaAtencion'},{av:'cmbEncuestaAtendido'},{av:'edtEncuestaHoraAtencion_Visible',ctrl:'ENCUESTAHORAATENCION',prop:'Visible'},{av:'edtEncuestaComentarios_Visible',ctrl:'ENCUESTACOMENTARIOS',prop:'Visible'},{av:'edtEncuestaRecomendacion_Visible',ctrl:'ENCUESTARECOMENDACION',prop:'Visible'},{av:'cmbEncuestaEstado'},{av:'AV73GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV74GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e161V2',iparms:[{av:'A37EncuestaId',fld:'ENCUESTAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e171V2',iparms:[{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV63DDO_EncuestaHoraAtencionAuxDate',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATE',pic:''},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV64DDO_EncuestaHoraAtencionAuxDateTo',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATETO',pic:''},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV63DDO_EncuestaHoraAtencionAuxDate',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATE',pic:''},{av:'AV64DDO_EncuestaHoraAtencionAuxDateTo',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATETO',pic:''},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e181V2',iparms:[{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV63DDO_EncuestaHoraAtencionAuxDate',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATE',pic:''},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV64DDO_EncuestaHoraAtencionAuxDateTo',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATETO',pic:''},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFEncuestaId',fld:'vTFENCUESTAID',pic:'ZZZ9'},{av:'AV28TFEncuestaId_To',fld:'vTFENCUESTAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFSGCitaDisponibilidadProfesionalId',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV32TFSGCitaDisponibilidadProfesionalId_To',fld:'vTFSGCITADISPONIBILIDADPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSGCitaDisponibilidadProFullName',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'AV34TFSGCitaDisponibilidadProFullName_Sel',fld:'vTFSGCITADISPONIBILIDADPROFULLNAME_SEL',pic:''},{av:'AV35TFSGCitaDisponibilidadEspecialidadId',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'AV36TFSGCitaDisponibilidadEspecialidadId_To',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADID_TO',pic:'ZZZ9'},{av:'AV37TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV39TFSGCitaDisponibilidadId',fld:'vTFSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV40TFSGCitaDisponibilidadId_To',fld:'vTFSGCITADISPONIBILIDADID_TO',pic:'ZZZZZZZ9'},{av:'AV41TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV42TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV45TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV46TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV47TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV48TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV49TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV50TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV51TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV52TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV53TFSGCitaDisponibilidadClinicaId',fld:'vTFSGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'AV54TFSGCitaDisponibilidadClinicaId_To',fld:'vTFSGCITADISPONIBILIDADCLINICAID_TO',pic:'ZZZ9'},{av:'AV55TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV84TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFEncuestaAtencion_Sels',fld:'vTFENCUESTAATENCION_SELS',pic:''},{av:'AV60TFEncuestaAtendido_Sels',fld:'vTFENCUESTAATENDIDO_SELS',pic:''},{av:'AV61TFEncuestaHoraAtencion',fld:'vTFENCUESTAHORAATENCION',pic:'99:99'},{av:'AV62TFEncuestaHoraAtencion_To',fld:'vTFENCUESTAHORAATENCION_TO',pic:'99:99'},{av:'AV65TFEncuestaComentarios',fld:'vTFENCUESTACOMENTARIOS',pic:''},{av:'AV66TFEncuestaComentarios_Sel',fld:'vTFENCUESTACOMENTARIOS_SEL',pic:''},{av:'AV67TFEncuestaRecomendacion',fld:'vTFENCUESTARECOMENDACION',pic:'Z9'},{av:'AV68TFEncuestaRecomendacion_To',fld:'vTFENCUESTARECOMENDACION_TO',pic:'Z9'},{av:'AV70TFEncuestaEstado_Sels',fld:'vTFENCUESTAESTADO_SELS',pic:''},{av:'AV125Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV76IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV78IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV69TFEncuestaEstado_SelsJson',fld:'vTFENCUESTAESTADO_SELSJSON',pic:''},{av:'AV63DDO_EncuestaHoraAtencionAuxDate',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATE',pic:''},{av:'AV64DDO_EncuestaHoraAtencionAuxDateTo',fld:'vDDO_ENCUESTAHORAATENCIONAUXDATETO',pic:''},{av:'AV59TFEncuestaAtendido_SelsJson',fld:'vTFENCUESTAATENDIDO_SELSJSON',pic:''},{av:'AV57TFEncuestaAtencion_SelsJson',fld:'vTFENCUESTAATENCION_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[]");
      setEventMetadata("VALID_CITAID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID","{handler:'valid_Sgcitadisponibilidadprofesionalid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID","{handler:'valid_Sgcitadisponibilidadespecialidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID","{handler:'valid_Sgcitadisponibilidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID","{handler:'valid_Sgcitadisponibilidadclinicaid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Encuestaestado',iparms:[]");
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
      AV33TFSGCitaDisponibilidadProFullName = "" ;
      AV34TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV37TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV41TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV42TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV47TFPacienteApellidoPaterno = "" ;
      AV48TFPacienteApellidoPaterno_Sel = "" ;
      AV49TFPacienteApellidoMaterno = "" ;
      AV50TFPacienteApellidoMaterno_Sel = "" ;
      AV51TFPacienteNombres = "" ;
      AV52TFPacienteNombres_Sel = "" ;
      AV55TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV84TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV58TFEncuestaAtencion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFEncuestaAtendido_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61TFEncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      AV62TFEncuestaHoraAtencion_To = GXutil.resetTime( GXutil.nullDate() );
      AV65TFEncuestaComentarios = "" ;
      AV66TFEncuestaComentarios_Sel = "" ;
      AV70TFEncuestaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV125Pgmname = "" ;
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
      AV71DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV44DDO_SGCitaDisponibilidadFechaAuxDateTo = GXutil.nullDate() ;
      AV64DDO_EncuestaHoraAtencionAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV57TFEncuestaAtencion_SelsJson = "" ;
      AV59TFEncuestaAtendido_SelsJson = "" ;
      AV69TFEncuestaEstado_SelsJson = "" ;
      AV43DDO_SGCitaDisponibilidadFechaAuxDate = GXutil.nullDate() ;
      AV63DDO_EncuestaHoraAtencionAuxDate = GXutil.nullDate() ;
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
      AV75Update = "" ;
      AV77Delete = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A148EncuestaAtencion = "" ;
      A149EncuestaAtendido = "" ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      A151EncuestaComentarios = "" ;
      A153EncuestaEstado = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV82DDO_SGCitaDisponibilidadFechaAuxDateText = "" ;
      ucTfsgcitadisponibilidadfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV83DDO_EncuestaHoraAtencionAuxDateText = "" ;
      ucTfencuestahoraatencion_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV116Encuestawwds_30_tfencuestaatencion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV117Encuestawwds_31_tfencuestaatendido_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV124Encuestawwds_38_tfencuestaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV87Encuestawwds_1_filterfulltext = "" ;
      lV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      lV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV106Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      lV108Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      lV110Encuestawwds_24_tfpacientenombres = "" ;
      lV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      lV120Encuestawwds_34_tfencuestacomentarios = "" ;
      AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV102Encuestawwds_16_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV107Encuestawwds_21_tfpacienteapellidopaterno_sel = "" ;
      AV106Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      AV109Encuestawwds_23_tfpacienteapellidomaterno_sel = "" ;
      AV108Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      AV111Encuestawwds_25_tfpacientenombres_sel = "" ;
      AV110Encuestawwds_24_tfpacientenombres = "" ;
      AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      AV118Encuestawwds_32_tfencuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
      AV119Encuestawwds_33_tfencuestahoraatencion_to = GXutil.resetTime( GXutil.nullDate() );
      AV121Encuestawwds_35_tfencuestacomentarios_sel = "" ;
      AV120Encuestawwds_34_tfencuestacomentarios = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      AV87Encuestawwds_1_filterfulltext = "" ;
      H001V2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      H001V2_A153EncuestaEstado = new String[] {""} ;
      H001V2_n153EncuestaEstado = new boolean[] {false} ;
      H001V2_A152EncuestaRecomendacion = new byte[1] ;
      H001V2_A151EncuestaComentarios = new String[] {""} ;
      H001V2_n151EncuestaComentarios = new boolean[] {false} ;
      H001V2_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      H001V2_n150EncuestaHoraAtencion = new boolean[] {false} ;
      H001V2_A149EncuestaAtendido = new String[] {""} ;
      H001V2_n149EncuestaAtendido = new boolean[] {false} ;
      H001V2_A148EncuestaAtencion = new String[] {""} ;
      H001V2_n148EncuestaAtencion = new boolean[] {false} ;
      H001V2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      H001V2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      H001V2_A105PacienteNombres = new String[] {""} ;
      H001V2_A104PacienteApellidoMaterno = new String[] {""} ;
      H001V2_A103PacienteApellidoPaterno = new String[] {""} ;
      H001V2_A20PacienteId = new int[1] ;
      H001V2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H001V2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H001V2_A21SGCitaDisponibilidadId = new int[1] ;
      H001V2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      H001V2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      H001V2_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      H001V2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      H001V2_A19CitaId = new int[1] ;
      H001V2_A37EncuestaId = new short[1] ;
      H001V2_A84ProfesionalNombres = new String[] {""} ;
      H001V2_n84ProfesionalNombres = new boolean[] {false} ;
      H001V2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H001V2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      H001V2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H001V2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      H001V3_AGRID_nRecordCount = new long[1] ;
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
      GXv_SdtWWPGridState30 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuestaww__default(),
         new Object[] {
             new Object[] {
            H001V2_A72SGCitaDisponibilidadSedeId, H001V2_A153EncuestaEstado, H001V2_n153EncuestaEstado, H001V2_A152EncuestaRecomendacion, H001V2_A151EncuestaComentarios, H001V2_n151EncuestaComentarios, H001V2_A150EncuestaHoraAtencion, H001V2_n150EncuestaHoraAtencion, H001V2_A149EncuestaAtendido, H001V2_n149EncuestaAtendido,
            H001V2_A148EncuestaAtencion, H001V2_n148EncuestaAtencion, H001V2_A78SGCitaDisponibilidadClinicaNombre, H001V2_A76SGCitaDisponibilidadClinicaId, H001V2_A105PacienteNombres, H001V2_A104PacienteApellidoMaterno, H001V2_A103PacienteApellidoPaterno, H001V2_A20PacienteId, H001V2_A66SGCitaDisponibilidadFecha, H001V2_n66SGCitaDisponibilidadFecha,
            H001V2_A21SGCitaDisponibilidadId, H001V2_A146SGCitaDisponibilidadEspecialidadNombre, H001V2_A70SGCitaDisponibilidadEspecialidadId, H001V2_A82SGCitaDisponibilidadProFullName, H001V2_A81SGCitaDisponibilidadProfesionalId, H001V2_A19CitaId, H001V2_A37EncuestaId, H001V2_A84ProfesionalNombres, H001V2_n84ProfesionalNombres, H001V2_A85ProfesionalApellidoPaterno,
            H001V2_n85ProfesionalApellidoPaterno, H001V2_A86ProfesionalApellidoMaterno, H001V2_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            H001V3_AGRID_nRecordCount
            }
         }
      );
      AV125Pgmname = "EncuestaWW" ;
      /* GeneXus formulas. */
      AV125Pgmname = "EncuestaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV26ManageFiltersExecutionStep ;
   private byte AV67TFEncuestaRecomendacion ;
   private byte AV68TFEncuestaRecomendacion_To ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte A152EncuestaRecomendacion ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte AV122Encuestawwds_36_tfencuestarecomendacion ;
   private byte AV123Encuestawwds_37_tfencuestarecomendacion_to ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV27TFEncuestaId ;
   private short AV28TFEncuestaId_To ;
   private short AV35TFSGCitaDisponibilidadEspecialidadId ;
   private short AV36TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV53TFSGCitaDisponibilidadClinicaId ;
   private short AV54TFSGCitaDisponibilidadClinicaId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A37EncuestaId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV88Encuestawwds_2_tfencuestaid ;
   private short AV89Encuestawwds_3_tfencuestaid_to ;
   private short AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ;
   private short AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid ;
   private short AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ;
   private short A72SGCitaDisponibilidadSedeId ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV29TFCitaId ;
   private int AV30TFCitaId_To ;
   private int AV31TFSGCitaDisponibilidadProfesionalId ;
   private int AV32TFSGCitaDisponibilidadProfesionalId_To ;
   private int AV39TFSGCitaDisponibilidadId ;
   private int AV40TFSGCitaDisponibilidadId_To ;
   private int AV45TFPacienteId ;
   private int AV46TFPacienteId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtEncuestaId_Visible ;
   private int edtCitaId_Visible ;
   private int edtSGCitaDisponibilidadProfesionalId_Visible ;
   private int edtSGCitaDisponibilidadProFullName_Visible ;
   private int edtSGCitaDisponibilidadEspecialidadId_Visible ;
   private int edtSGCitaDisponibilidadEspecialidadNombre_Visible ;
   private int edtSGCitaDisponibilidadId_Visible ;
   private int edtSGCitaDisponibilidadFecha_Visible ;
   private int edtPacienteId_Visible ;
   private int edtPacienteApellidoPaterno_Visible ;
   private int edtPacienteApellidoMaterno_Visible ;
   private int edtPacienteNombres_Visible ;
   private int edtSGCitaDisponibilidadClinicaId_Visible ;
   private int edtSGCitaDisponibilidadClinicaNombre_Visible ;
   private int edtEncuestaHoraAtencion_Visible ;
   private int edtEncuestaComentarios_Visible ;
   private int edtEncuestaRecomendacion_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int A19CitaId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int A20PacienteId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV116Encuestawwds_30_tfencuestaatencion_sels_size ;
   private int AV117Encuestawwds_31_tfencuestaatendido_sels_size ;
   private int AV124Encuestawwds_38_tfencuestaestado_sels_size ;
   private int AV90Encuestawwds_4_tfcitaid ;
   private int AV91Encuestawwds_5_tfcitaid_to ;
   private int AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ;
   private int AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV100Encuestawwds_14_tfsgcitadisponibilidadid ;
   private int AV101Encuestawwds_15_tfsgcitadisponibilidadid_to ;
   private int AV104Encuestawwds_18_tfpacienteid ;
   private int AV105Encuestawwds_19_tfpacienteid_to ;
   private int AV72PageToGo ;
   private int AV126GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV73GridCurrentPage ;
   private long AV74GridPageCount ;
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
   private String AV125Pgmname ;
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
   private String AV75Update ;
   private String edtavUpdate_Link ;
   private String AV77Delete ;
   private String edtavDelete_Link ;
   private String edtPacienteNombres_Link ;
   private String A148EncuestaAtencion ;
   private String A149EncuestaAtendido ;
   private String A153EncuestaEstado ;
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
   private String divDdo_encuestahoraatencionauxdates_Internalname ;
   private String edtavDdo_encuestahoraatencionauxdatetext_Internalname ;
   private String edtavDdo_encuestahoraatencionauxdatetext_Jsonclick ;
   private String Tfencuestahoraatencion_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtEncuestaId_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtSGCitaDisponibilidadProfesionalId_Internalname ;
   private String edtSGCitaDisponibilidadProFullName_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadId_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Internalname ;
   private String edtSGCitaDisponibilidadId_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteNombres_Internalname ;
   private String edtSGCitaDisponibilidadClinicaId_Internalname ;
   private String edtSGCitaDisponibilidadClinicaNombre_Internalname ;
   private String edtEncuestaHoraAtencion_Internalname ;
   private String edtEncuestaComentarios_Internalname ;
   private String edtEncuestaRecomendacion_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char8[] ;
   private String GXt_char13 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
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
   private String edtEncuestaId_Jsonclick ;
   private String edtCitaId_Jsonclick ;
   private String edtSGCitaDisponibilidadProfesionalId_Jsonclick ;
   private String edtSGCitaDisponibilidadProFullName_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaId_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaNombre_Jsonclick ;
   private String GXCCtl ;
   private String edtEncuestaHoraAtencion_Jsonclick ;
   private String edtEncuestaComentarios_Jsonclick ;
   private String edtEncuestaRecomendacion_Jsonclick ;
   private java.util.Date AV61TFEncuestaHoraAtencion ;
   private java.util.Date AV62TFEncuestaHoraAtencion_To ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date AV118Encuestawwds_32_tfencuestahoraatencion ;
   private java.util.Date AV119Encuestawwds_33_tfencuestahoraatencion_to ;
   private java.util.Date AV41TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV42TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV44DDO_SGCitaDisponibilidadFechaAuxDateTo ;
   private java.util.Date AV64DDO_EncuestaHoraAtencionAuxDateTo ;
   private java.util.Date AV43DDO_SGCitaDisponibilidadFechaAuxDate ;
   private java.util.Date AV63DDO_EncuestaHoraAtencionAuxDate ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV102Encuestawwds_16_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV76IsAuthorized_Update ;
   private boolean AV78IsAuthorized_Delete ;
   private boolean AV81IsAuthorized_PacienteNombres ;
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
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n148EncuestaAtencion ;
   private boolean n149EncuestaAtendido ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n151EncuestaComentarios ;
   private boolean n153EncuestaEstado ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV79TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV57TFEncuestaAtencion_SelsJson ;
   private String AV59TFEncuestaAtendido_SelsJson ;
   private String AV69TFEncuestaEstado_SelsJson ;
   private String A151EncuestaComentarios ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV33TFSGCitaDisponibilidadProFullName ;
   private String AV34TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV37TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV38TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV47TFPacienteApellidoPaterno ;
   private String AV48TFPacienteApellidoPaterno_Sel ;
   private String AV49TFPacienteApellidoMaterno ;
   private String AV50TFPacienteApellidoMaterno_Sel ;
   private String AV51TFPacienteNombres ;
   private String AV52TFPacienteNombres_Sel ;
   private String AV55TFSGCitaDisponibilidadClinicaNombre ;
   private String AV84TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV65TFEncuestaComentarios ;
   private String AV66TFEncuestaComentarios_Sel ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String AV82DDO_SGCitaDisponibilidadFechaAuxDateText ;
   private String AV83DDO_EncuestaHoraAtencionAuxDateText ;
   private String lV87Encuestawwds_1_filterfulltext ;
   private String lV94Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String lV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV106Encuestawwds_20_tfpacienteapellidopaterno ;
   private String lV108Encuestawwds_22_tfpacienteapellidomaterno ;
   private String lV110Encuestawwds_24_tfpacientenombres ;
   private String lV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String lV120Encuestawwds_34_tfencuestacomentarios ;
   private String AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ;
   private String AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV107Encuestawwds_21_tfpacienteapellidopaterno_sel ;
   private String AV106Encuestawwds_20_tfpacienteapellidopaterno ;
   private String AV109Encuestawwds_23_tfpacienteapellidomaterno_sel ;
   private String AV108Encuestawwds_22_tfpacienteapellidomaterno ;
   private String AV111Encuestawwds_25_tfpacientenombres_sel ;
   private String AV110Encuestawwds_24_tfpacientenombres ;
   private String AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String AV121Encuestawwds_35_tfencuestacomentarios_sel ;
   private String AV120Encuestawwds_34_tfencuestacomentarios ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String AV87Encuestawwds_1_filterfulltext ;
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
   private com.genexus.webpanels.GXUserControl ucTfencuestahoraatencion_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV116Encuestawwds_30_tfencuestaatencion_sels ;
   private GXSimpleCollection<String> AV117Encuestawwds_31_tfencuestaatendido_sels ;
   private GXSimpleCollection<String> AV124Encuestawwds_38_tfencuestaestado_sels ;
   private HTMLChoice cmbEncuestaAtencion ;
   private HTMLChoice cmbEncuestaAtendido ;
   private HTMLChoice cmbEncuestaEstado ;
   private IDataStoreProvider pr_default ;
   private short[] H001V2_A72SGCitaDisponibilidadSedeId ;
   private String[] H001V2_A153EncuestaEstado ;
   private boolean[] H001V2_n153EncuestaEstado ;
   private byte[] H001V2_A152EncuestaRecomendacion ;
   private String[] H001V2_A151EncuestaComentarios ;
   private boolean[] H001V2_n151EncuestaComentarios ;
   private java.util.Date[] H001V2_A150EncuestaHoraAtencion ;
   private boolean[] H001V2_n150EncuestaHoraAtencion ;
   private String[] H001V2_A149EncuestaAtendido ;
   private boolean[] H001V2_n149EncuestaAtendido ;
   private String[] H001V2_A148EncuestaAtencion ;
   private boolean[] H001V2_n148EncuestaAtencion ;
   private String[] H001V2_A78SGCitaDisponibilidadClinicaNombre ;
   private short[] H001V2_A76SGCitaDisponibilidadClinicaId ;
   private String[] H001V2_A105PacienteNombres ;
   private String[] H001V2_A104PacienteApellidoMaterno ;
   private String[] H001V2_A103PacienteApellidoPaterno ;
   private int[] H001V2_A20PacienteId ;
   private java.util.Date[] H001V2_A66SGCitaDisponibilidadFecha ;
   private boolean[] H001V2_n66SGCitaDisponibilidadFecha ;
   private int[] H001V2_A21SGCitaDisponibilidadId ;
   private String[] H001V2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] H001V2_A70SGCitaDisponibilidadEspecialidadId ;
   private String[] H001V2_A82SGCitaDisponibilidadProFullName ;
   private int[] H001V2_A81SGCitaDisponibilidadProfesionalId ;
   private int[] H001V2_A19CitaId ;
   private short[] H001V2_A37EncuestaId ;
   private String[] H001V2_A84ProfesionalNombres ;
   private boolean[] H001V2_n84ProfesionalNombres ;
   private String[] H001V2_A85ProfesionalApellidoPaterno ;
   private boolean[] H001V2_n85ProfesionalApellidoPaterno ;
   private String[] H001V2_A86ProfesionalApellidoMaterno ;
   private boolean[] H001V2_n86ProfesionalApellidoMaterno ;
   private long[] H001V3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV58TFEncuestaAtencion_Sels ;
   private GXSimpleCollection<String> AV60TFEncuestaAtendido_Sels ;
   private GXSimpleCollection<String> AV70TFEncuestaEstado_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState30[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV71DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class encuestaww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV116Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV117Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV124Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV88Encuestawwds_2_tfencuestaid ,
                                          short AV89Encuestawwds_3_tfencuestaid_to ,
                                          int AV90Encuestawwds_4_tfcitaid ,
                                          int AV91Encuestawwds_5_tfcitaid_to ,
                                          int AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV100Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV101Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV102Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV104Encuestawwds_18_tfpacienteid ,
                                          int AV105Encuestawwds_19_tfpacienteid_to ,
                                          String AV107Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV106Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV109Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV108Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV111Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV110Encuestawwds_24_tfpacientenombres ,
                                          short AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV116Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV117Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV118Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV119Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV121Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV120Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV122Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV123Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV124Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV87Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int31 = new byte[60];
      Object[] GXv_Object32 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T1.[EncuestaEstado], T1.[EncuestaRecomendacion], T1.[EncuestaComentarios], T1.[EncuestaHoraAtencion]," ;
      sSelectString += " T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId," ;
      sSelectString += " T3.[PacienteNombres], T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno], T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId]" ;
      sSelectString += " AS SGCitaDisponibilidadId, T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, COALESCE(" ;
      sSelectString += " T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName," ;
      sSelectString += " T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      sFromString = " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      sFromString += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      sFromString += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV88Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int31[23] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int31[24] = (byte)(1) ;
      }
      if ( ! (0==AV90Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int31[25] = (byte)(1) ;
      }
      if ( ! (0==AV91Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int31[26] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int31[27] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int31[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int31[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int31[30] = (byte)(1) ;
      }
      if ( ! (0==AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int31[31] = (byte)(1) ;
      }
      if ( ! (0==AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int31[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int31[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int31[34] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int31[35] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int31[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int31[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int31[38] = (byte)(1) ;
      }
      if ( ! (0==AV104Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int31[39] = (byte)(1) ;
      }
      if ( ! (0==AV105Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int31[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV106Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int31[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int31[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int31[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int31[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV110Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int31[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int31[46] = (byte)(1) ;
      }
      if ( ! (0==AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int31[47] = (byte)(1) ;
      }
      if ( ! (0==AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int31[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int31[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int31[50] = (byte)(1) ;
      }
      if ( AV116Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV117Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV118Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int31[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV119Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int31[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV120Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int31[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int31[54] = (byte)(1) ;
      }
      if ( ! (0==AV122Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int31[55] = (byte)(1) ;
      }
      if ( ! (0==AV123Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int31[56] = (byte)(1) ;
      }
      if ( AV124Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV124Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaAtencion]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaAtencion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaId] DESC" ;
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
         sOrderString += " ORDER BY T4.[ProfesionalId]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.[ProfesionalId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [SGCitaDisponibilidadProFullName] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T4.[EspecialidadId]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.[EspecialidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T7.[EspecialidadNombre]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T7.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[SGCitaDisponibilidadId]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[SGCitaDisponibilidadId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T4.[DisponibilidadFecha]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[PacienteId]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[PacienteId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[PacienteNombres]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[PacienteNombres] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T5.[ClinicaId]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T5.[ClinicaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T6.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T6.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaAtendido]" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaAtendido] DESC" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaHoraAtencion]" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaHoraAtencion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaComentarios]" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaComentarios] DESC" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaRecomendacion]" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaRecomendacion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[EncuestaEstado]" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[EncuestaEstado] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[EncuestaId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object32[0] = scmdbuf ;
      GXv_Object32[1] = GXv_int31 ;
      return GXv_Object32 ;
   }

   protected Object[] conditional_H001V3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV116Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV117Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV124Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV88Encuestawwds_2_tfencuestaid ,
                                          short AV89Encuestawwds_3_tfencuestaid_to ,
                                          int AV90Encuestawwds_4_tfcitaid ,
                                          int AV91Encuestawwds_5_tfcitaid_to ,
                                          int AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV100Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV101Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV102Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV104Encuestawwds_18_tfpacienteid ,
                                          int AV105Encuestawwds_19_tfpacienteid_to ,
                                          String AV107Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV106Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV109Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV108Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV111Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV110Encuestawwds_24_tfpacientenombres ,
                                          short AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV116Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV117Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV118Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV119Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV121Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV120Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV122Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV123Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV124Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV87Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int34 = new byte[57];
      Object[] GXv_Object35 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER" ;
      scmdbuf += " JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T7 ON T7.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN" ;
      scmdbuf += " [Clinica] T8 ON T8.[ClinicaId] = T7.[ClinicaId]) INNER JOIN [Especialidad] T6 ON T6.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T5 ON T5.[ProfesionalId]" ;
      scmdbuf += " = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T5.[ProfesionalNombres], '') + ' ' + COALESCE( T5.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T5.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T6.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T7.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T8.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV88Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int34[23] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int34[24] = (byte)(1) ;
      }
      if ( ! (0==AV90Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int34[25] = (byte)(1) ;
      }
      if ( ! (0==AV91Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int34[26] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int34[27] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int34[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T5.[ProfesionalNombres] + ' ' + T5.[ProfesionalApellidoPaterno] + ' ' + T5.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int34[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[ProfesionalNombres] + ' ' + T5.[ProfesionalApellidoPaterno] + ' ' + T5.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int34[30] = (byte)(1) ;
      }
      if ( ! (0==AV96Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int34[31] = (byte)(1) ;
      }
      if ( ! (0==AV97Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int34[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int34[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int34[34] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int34[35] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int34[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int34[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV103Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int34[38] = (byte)(1) ;
      }
      if ( ! (0==AV104Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int34[39] = (byte)(1) ;
      }
      if ( ! (0==AV105Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int34[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV106Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int34[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int34[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int34[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int34[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV110Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int34[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int34[46] = (byte)(1) ;
      }
      if ( ! (0==AV112Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T7.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int34[47] = (byte)(1) ;
      }
      if ( ! (0==AV113Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T7.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int34[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int34[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int34[50] = (byte)(1) ;
      }
      if ( AV116Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV117Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV118Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int34[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV119Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int34[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV120Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int34[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int34[54] = (byte)(1) ;
      }
      if ( ! (0==AV122Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int34[55] = (byte)(1) ;
      }
      if ( ! (0==AV123Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int34[56] = (byte)(1) ;
      }
      if ( AV124Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV124Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object35[0] = scmdbuf ;
      GXv_Object35[1] = GXv_int34 ;
      return GXv_Object35 ;
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
                  return conditional_H001V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , ((Number) dynConstraints[62]).shortValue() , ((Boolean) dynConstraints[63]).booleanValue() , (String)dynConstraints[64] , (String)dynConstraints[65] );
            case 1 :
                  return conditional_H001V3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , ((Number) dynConstraints[62]).shortValue() , ((Boolean) dynConstraints[63]).booleanValue() , (String)dynConstraints[64] , (String)dynConstraints[65] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 1);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((short[]) buf[13])[0] = rslt.getShort(9);
               ((String[]) buf[14])[0] = rslt.getVarchar(10);
               ((String[]) buf[15])[0] = rslt.getVarchar(11);
               ((String[]) buf[16])[0] = rslt.getVarchar(12);
               ((int[]) buf[17])[0] = rslt.getInt(13);
               ((java.util.Date[]) buf[18])[0] = rslt.getGXDate(14);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((int[]) buf[20])[0] = rslt.getInt(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((short[]) buf[22])[0] = rslt.getShort(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((int[]) buf[24])[0] = rslt.getInt(19);
               ((int[]) buf[25])[0] = rslt.getInt(20);
               ((short[]) buf[26])[0] = rslt.getShort(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[83]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[84]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[88]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[91]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[92]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[95]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[97]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[98]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[99]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[100]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[107]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[108]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[111], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[112], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[115]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[116]).byteValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[118]).intValue());
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[119]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
      }
   }

}

