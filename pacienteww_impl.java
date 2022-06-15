package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacienteww_impl extends GXDataArea
{
   public pacienteww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pacienteww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacienteww_impl.class ));
   }

   public pacienteww_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPacienteTipoDocumento = new HTMLChoice();
      cmbPacienteSexo = new HTMLChoice();
      cmbPacienteEstado = new HTMLChoice();
      cmbPacienteEnterarse = new HTMLChoice();
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
            AV74TFPacienteFechaRegistro = localUtil.parseDTimeParm( httpContext.GetPar( "TFPacienteFechaRegistro")) ;
            AV75TFPacienteFechaRegistro_To = localUtil.parseDTimeParm( httpContext.GetPar( "TFPacienteFechaRegistro_To")) ;
            AV26ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
            AV27TFPacienteId = (int)(GXutil.lval( httpContext.GetPar( "TFPacienteId"))) ;
            AV28TFPacienteId_To = (int)(GXutil.lval( httpContext.GetPar( "TFPacienteId_To"))) ;
            AV29TFPacienteApellidoPaterno = httpContext.GetPar( "TFPacienteApellidoPaterno") ;
            AV30TFPacienteApellidoPaterno_Sel = httpContext.GetPar( "TFPacienteApellidoPaterno_Sel") ;
            AV31TFPacienteApellidoMaterno = httpContext.GetPar( "TFPacienteApellidoMaterno") ;
            AV32TFPacienteApellidoMaterno_Sel = httpContext.GetPar( "TFPacienteApellidoMaterno_Sel") ;
            AV33TFPacienteNombres = httpContext.GetPar( "TFPacienteNombres") ;
            AV34TFPacienteNombres_Sel = httpContext.GetPar( "TFPacienteNombres_Sel") ;
            AV35TFPacienteNombreCompleto = httpContext.GetPar( "TFPacienteNombreCompleto") ;
            AV36TFPacienteNombreCompleto_Sel = httpContext.GetPar( "TFPacienteNombreCompleto_Sel") ;
            AV37TFPacienteFechaNacimiento = localUtil.parseDateParm( httpContext.GetPar( "TFPacienteFechaNacimiento")) ;
            AV38TFPacienteFechaNacimiento_To = localUtil.parseDateParm( httpContext.GetPar( "TFPacienteFechaNacimiento_To")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV43TFPacienteTipoDocumento_Sels);
            AV44TFPacienteNroDocumento = httpContext.GetPar( "TFPacienteNroDocumento") ;
            AV45TFPacienteNroDocumento_Sel = httpContext.GetPar( "TFPacienteNroDocumento_Sel") ;
            AV46TFPacienteDireccion = httpContext.GetPar( "TFPacienteDireccion") ;
            AV47TFPacienteDireccion_Sel = httpContext.GetPar( "TFPacienteDireccion_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV51TFPacienteSexo_Sels);
            AV52TFPacienteCorreo = httpContext.GetPar( "TFPacienteCorreo") ;
            AV53TFPacienteCorreo_Sel = httpContext.GetPar( "TFPacienteCorreo_Sel") ;
            AV54TFPacienteTelefono = httpContext.GetPar( "TFPacienteTelefono") ;
            AV55TFPacienteTelefono_Sel = httpContext.GetPar( "TFPacienteTelefono_Sel") ;
            AV56TFPaisId = (short)(GXutil.lval( httpContext.GetPar( "TFPaisId"))) ;
            AV57TFPaisId_To = (short)(GXutil.lval( httpContext.GetPar( "TFPaisId_To"))) ;
            AV58TFPaisDescripcion = httpContext.GetPar( "TFPaisDescripcion") ;
            AV59TFPaisDescripcion_Sel = httpContext.GetPar( "TFPaisDescripcion_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV61TFPacienteEstado_Sels);
            AV62TFSecUserId = (short)(GXutil.lval( httpContext.GetPar( "TFSecUserId"))) ;
            AV63TFSecUserId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSecUserId_To"))) ;
            AV64TFUbigeoCode = httpContext.GetPar( "TFUbigeoCode") ;
            AV65TFUbigeoCode_Sel = httpContext.GetPar( "TFUbigeoCode_Sel") ;
            AV66TFUbigeoNombre = httpContext.GetPar( "TFUbigeoNombre") ;
            AV67TFUbigeoNombre_Sel = httpContext.GetPar( "TFUbigeoNombre_Sel") ;
            AV68TFPacienteEstatura = CommonUtil.decimalVal( httpContext.GetPar( "TFPacienteEstatura"), ".") ;
            AV69TFPacienteEstatura_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPacienteEstatura_To"), ".") ;
            AV70TFPacientePeso = CommonUtil.decimalVal( httpContext.GetPar( "TFPacientePeso"), ".") ;
            AV71TFPacientePeso_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPacientePeso_To"), ".") ;
            AV72TFPacienteNombreAnexo = httpContext.GetPar( "TFPacienteNombreAnexo") ;
            AV73TFPacienteNombreAnexo_Sel = httpContext.GetPar( "TFPacienteNombreAnexo_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV49TFPacienteEnterarse_Sels);
            AV90TFPacienteEspecifique = httpContext.GetPar( "TFPacienteEspecifique") ;
            AV91TFPacienteEspecifique_Sel = httpContext.GetPar( "TFPacienteEspecifique_Sel") ;
            AV139Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV84IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV86IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV87IsAuthorized_PaisDescripcion = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_PaisDescripcion")) ;
            AV88IsAuthorized_UbigeoNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_UbigeoNombre")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV74TFPacienteFechaRegistro, AV75TFPacienteFechaRegistro_To, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPacienteId, AV28TFPacienteId_To, AV29TFPacienteApellidoPaterno, AV30TFPacienteApellidoPaterno_Sel, AV31TFPacienteApellidoMaterno, AV32TFPacienteApellidoMaterno_Sel, AV33TFPacienteNombres, AV34TFPacienteNombres_Sel, AV35TFPacienteNombreCompleto, AV36TFPacienteNombreCompleto_Sel, AV37TFPacienteFechaNacimiento, AV38TFPacienteFechaNacimiento_To, AV43TFPacienteTipoDocumento_Sels, AV44TFPacienteNroDocumento, AV45TFPacienteNroDocumento_Sel, AV46TFPacienteDireccion, AV47TFPacienteDireccion_Sel, AV51TFPacienteSexo_Sels, AV52TFPacienteCorreo, AV53TFPacienteCorreo_Sel, AV54TFPacienteTelefono, AV55TFPacienteTelefono_Sel, AV56TFPaisId, AV57TFPaisId_To, AV58TFPaisDescripcion, AV59TFPaisDescripcion_Sel, AV61TFPacienteEstado_Sels, AV62TFSecUserId, AV63TFSecUserId_To, AV64TFUbigeoCode, AV65TFUbigeoCode_Sel, AV66TFUbigeoNombre, AV67TFUbigeoNombre_Sel, AV68TFPacienteEstatura, AV69TFPacienteEstatura_To, AV70TFPacientePeso, AV71TFPacientePeso_To, AV72TFPacienteNombreAnexo, AV73TFPacienteNombreAnexo_Sel, AV49TFPacienteEnterarse_Sels, AV90TFPacienteEspecifique, AV91TFPacienteEspecifique_Sel, AV139Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV87IsAuthorized_PaisDescripcion, AV88IsAuthorized_UbigeoNombre) ;
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
      pa1F2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1F2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331894", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pacienteww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV139Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV87IsAuthorized_PaisDescripcion));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV88IsAuthorized_UbigeoNombre));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PACIENTEFECHANACIMIENTOAUXDATETO", localUtil.dtoc( AV40DDO_PacienteFechaNacimientoAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PACIENTEFECHAREGISTROAUXDATETO", localUtil.dtoc( AV77DDO_PacienteFechaRegistroAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV27TFPacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFPacienteId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO", AV29TFPacienteApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO_SEL", AV30TFPacienteApellidoPaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO", AV31TFPacienteApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO_SEL", AV32TFPacienteApellidoMaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES", AV33TFPacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES_SEL", AV34TFPacienteNombres_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRECOMPLETO", AV35TFPacienteNombreCompleto);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRECOMPLETO_SEL", AV36TFPacienteNombreCompleto_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEFECHANACIMIENTO", localUtil.dtoc( AV37TFPacienteFechaNacimiento, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEFECHANACIMIENTO_TO", localUtil.dtoc( AV38TFPacienteFechaNacimiento_To, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPACIENTETIPODOCUMENTO_SELS", AV43TFPacienteTipoDocumento_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPACIENTETIPODOCUMENTO_SELS", AV43TFPacienteTipoDocumento_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENRODOCUMENTO", AV44TFPacienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENRODOCUMENTO_SEL", AV45TFPacienteNroDocumento_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEDIRECCION", AV46TFPacienteDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEDIRECCION_SEL", AV47TFPacienteDireccion_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPACIENTESEXO_SELS", AV51TFPacienteSexo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPACIENTESEXO_SELS", AV51TFPacienteSexo_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTECORREO", AV52TFPacienteCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTECORREO_SEL", AV53TFPacienteCorreo_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTETELEFONO", GXutil.rtrim( AV54TFPacienteTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTETELEFONO_SEL", GXutil.rtrim( AV55TFPacienteTelefono_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISID", GXutil.ltrim( localUtil.ntoc( AV56TFPaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISID_TO", GXutil.ltrim( localUtil.ntoc( AV57TFPaisId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISDESCRIPCION", AV58TFPaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISDESCRIPCION_SEL", AV59TFPaisDescripcion_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPACIENTEESTADO_SELS", AV61TFPacienteEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPACIENTEESTADO_SELS", AV61TFPacienteEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERID", GXutil.ltrim( localUtil.ntoc( AV62TFSecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERID_TO", GXutil.ltrim( localUtil.ntoc( AV63TFSecUserId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE", GXutil.rtrim( AV64TFUbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE_SEL", GXutil.rtrim( AV65TFUbigeoCode_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE", AV66TFUbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE_SEL", AV67TFUbigeoNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEESTATURA", GXutil.ltrim( localUtil.ntoc( AV68TFPacienteEstatura, (byte)(4), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEESTATURA_TO", GXutil.ltrim( localUtil.ntoc( AV69TFPacienteEstatura_To, (byte)(4), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEPESO", GXutil.ltrim( localUtil.ntoc( AV70TFPacientePeso, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEPESO_TO", GXutil.ltrim( localUtil.ntoc( AV71TFPacientePeso_To, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBREANEXO", AV72TFPacienteNombreAnexo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBREANEXO_SEL", AV73TFPacienteNombreAnexo_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPACIENTEENTERARSE_SELS", AV49TFPacienteEnterarse_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPACIENTEENTERARSE_SELS", AV49TFPacienteEnterarse_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEESPECIFIQUE", AV90TFPacienteEspecifique);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEESPECIFIQUE_SEL", AV91TFPacienteEspecifique_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEFECHAREGISTRO", localUtil.ttoc( AV74TFPacienteFechaRegistro, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEFECHAREGISTRO_TO", localUtil.ttoc( AV75TFPacienteFechaRegistro_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV139Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV139Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV84IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV86IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PAISDESCRIPCION", AV87IsAuthorized_PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV87IsAuthorized_PaisDescripcion));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UBIGEONOMBRE", AV88IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV88IsAuthorized_UbigeoNombre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTETIPODOCUMENTO_SELSJSON", AV42TFPacienteTipoDocumento_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTESEXO_SELSJSON", AV50TFPacienteSexo_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEESTADO_SELSJSON", AV60TFPacienteEstado_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEENTERARSE_SELSJSON", AV48TFPacienteEnterarse_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODISTRITO", A188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PACIENTEFECHANACIMIENTOAUXDATE", localUtil.dtoc( AV39DDO_PacienteFechaNacimientoAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PACIENTEFECHAREGISTROAUXDATE", localUtil.dtoc( AV76DDO_PacienteFechaRegistroAuxDate, 0, "/"));
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
         we1F2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1F2( ) ;
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
      return formatLink("com.projectthani.pacienteww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "PacienteWW" ;
   }

   public String getPgmdesc( )
   {
      return " Paciente" ;
   }

   public void wb1F0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_1F2( true) ;
      }
      else
      {
         wb_table1_25_1F2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_1F2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteApellidoPaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteApellidoMaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteNombres_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteNombreCompleto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Completo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteFechaNacimiento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Nacimiento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPacienteTipoDocumento.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteNroDocumento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteDireccion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPacienteSexo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Sexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteCorreo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteTelefono_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Telefono") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaisId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Pais Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaisDescripcion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Pais Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPacienteEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecUserId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "User Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteEstatura_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estatura") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacientePeso_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Peso") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteNombreAnexo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Anexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Image"+"\" "+" style=\""+((edtPacienteAnexos_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Anexos") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPacienteEnterarse.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Enterarse") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteEspecifique_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Especifique") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPacienteFechaRegistro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Registro") ;
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
            GridColumn.AddObjectProperty("Value", A212PacienteNombreCompleto);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteNombreCompleto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteFechaNacimiento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A214PacienteTipoDocumento));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPacienteTipoDocumento.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A106PacienteNroDocumento);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteNroDocumento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A215PacienteDireccion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteDireccion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A216PacienteSexo));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPacienteSexo.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A217PacienteCorreo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteCorreo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A218PacienteTelefono));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteTelefono_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaisId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A184PaisDescripcion);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPaisDescripcion_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPaisDescripcion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A219PacienteEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPacienteEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A44UbigeoCode));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A185UbigeoNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtUbigeoNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A220PacienteEstatura, (byte)(4), (byte)(2), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteEstatura_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A221PacientePeso, (byte)(6), (byte)(2), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacientePeso_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A222PacienteNombreAnexo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteNombreAnexo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A223PacienteAnexos);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteAnexos_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A224PacienteEnterarse);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPacienteEnterarse.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A225PacienteEspecifique);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteEspecifique_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A226PacienteFechaRegistro, 10, 8, 0, 3, "/", ":", " "));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPacienteFechaRegistro_Visible, (byte)(5), (byte)(0), ".", "")));
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_pacientefechanacimientoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_pacientefechanacimientoauxdatetext_Internalname, AV41DDO_PacienteFechaNacimientoAuxDateText, GXutil.rtrim( localUtil.format( AV41DDO_PacienteFechaNacimientoAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_pacientefechanacimientoauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteWW.htm");
         /* User Defined Control */
         ucTfpacientefechanacimiento_rangepicker.setProperty("Start Date", AV39DDO_PacienteFechaNacimientoAuxDate);
         ucTfpacientefechanacimiento_rangepicker.setProperty("End Date", AV40DDO_PacienteFechaNacimientoAuxDateTo);
         ucTfpacientefechanacimiento_rangepicker.render(context, "wwp.daterangepicker", Tfpacientefechanacimiento_rangepicker_Internalname, "TFPACIENTEFECHANACIMIENTO_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_pacientefecharegistroauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_pacientefecharegistroauxdatetext_Internalname, AV78DDO_PacienteFechaRegistroAuxDateText, GXutil.rtrim( localUtil.format( AV78DDO_PacienteFechaRegistroAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_pacientefecharegistroauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteWW.htm");
         /* User Defined Control */
         ucTfpacientefecharegistro_rangepicker.setProperty("Start Date", AV76DDO_PacienteFechaRegistroAuxDate);
         ucTfpacientefecharegistro_rangepicker.setProperty("End Date", AV77DDO_PacienteFechaRegistroAuxDateTo);
         ucTfpacientefecharegistro_rangepicker.render(context, "wwp.daterangepicker", Tfpacientefecharegistro_rangepicker_Internalname, "TFPACIENTEFECHAREGISTRO_RANGEPICKERContainer");
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

   public void start1F2( )
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
         Form.getMeta().addItem("description", " Paciente", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1F0( ) ;
   }

   public void ws1F2( )
   {
      start1F2( ) ;
      evt1F2( ) ;
   }

   public void evt1F2( )
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
                           e111F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e161F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e171F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e181F2 ();
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
                           A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
                           A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
                           A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
                           A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
                           A212PacienteNombreCompleto = httpContext.cgiGet( edtPacienteNombreCompleto_Internalname) ;
                           A213PacienteFechaNacimiento = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtPacienteFechaNacimiento_Internalname), 0)) ;
                           cmbPacienteTipoDocumento.setName( cmbPacienteTipoDocumento.getInternalname() );
                           cmbPacienteTipoDocumento.setValue( httpContext.cgiGet( cmbPacienteTipoDocumento.getInternalname()) );
                           A214PacienteTipoDocumento = httpContext.cgiGet( cmbPacienteTipoDocumento.getInternalname()) ;
                           A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
                           A215PacienteDireccion = httpContext.cgiGet( edtPacienteDireccion_Internalname) ;
                           cmbPacienteSexo.setName( cmbPacienteSexo.getInternalname() );
                           cmbPacienteSexo.setValue( httpContext.cgiGet( cmbPacienteSexo.getInternalname()) );
                           A216PacienteSexo = httpContext.cgiGet( cmbPacienteSexo.getInternalname()) ;
                           A217PacienteCorreo = httpContext.cgiGet( edtPacienteCorreo_Internalname) ;
                           A218PacienteTelefono = httpContext.cgiGet( edtPacienteTelefono_Internalname) ;
                           A43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".")) ;
                           A184PaisDescripcion = httpContext.cgiGet( edtPaisDescripcion_Internalname) ;
                           cmbPacienteEstado.setName( cmbPacienteEstado.getInternalname() );
                           cmbPacienteEstado.setValue( httpContext.cgiGet( cmbPacienteEstado.getInternalname()) );
                           A219PacienteEstado = httpContext.cgiGet( cmbPacienteEstado.getInternalname()) ;
                           A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
                           n6SecUserId = false ;
                           A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
                           n44UbigeoCode = false ;
                           A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
                           A220PacienteEstatura = localUtil.ctond( httpContext.cgiGet( edtPacienteEstatura_Internalname)) ;
                           A221PacientePeso = localUtil.ctond( httpContext.cgiGet( edtPacientePeso_Internalname)) ;
                           A222PacienteNombreAnexo = httpContext.cgiGet( edtPacienteNombreAnexo_Internalname) ;
                           n222PacienteNombreAnexo = false ;
                           A223PacienteAnexos = httpContext.cgiGet( edtPacienteAnexos_Internalname) ;
                           n223PacienteAnexos = false ;
                           httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_43_Refreshing);
                           cmbPacienteEnterarse.setName( cmbPacienteEnterarse.getInternalname() );
                           cmbPacienteEnterarse.setValue( httpContext.cgiGet( cmbPacienteEnterarse.getInternalname()) );
                           A224PacienteEnterarse = httpContext.cgiGet( cmbPacienteEnterarse.getInternalname()) ;
                           n224PacienteEnterarse = false ;
                           A225PacienteEspecifique = httpContext.cgiGet( edtPacienteEspecifique_Internalname) ;
                           n225PacienteEspecifique = false ;
                           A226PacienteFechaRegistro = localUtil.ctot( httpContext.cgiGet( edtPacienteFechaRegistro_Internalname), 0) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e191F2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e201F2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e211F2 ();
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

   public void we1F2( )
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

   public void pa1F2( )
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
                                 java.util.Date AV74TFPacienteFechaRegistro ,
                                 java.util.Date AV75TFPacienteFechaRegistro_To ,
                                 byte AV26ManageFiltersExecutionStep ,
                                 com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 int AV27TFPacienteId ,
                                 int AV28TFPacienteId_To ,
                                 String AV29TFPacienteApellidoPaterno ,
                                 String AV30TFPacienteApellidoPaterno_Sel ,
                                 String AV31TFPacienteApellidoMaterno ,
                                 String AV32TFPacienteApellidoMaterno_Sel ,
                                 String AV33TFPacienteNombres ,
                                 String AV34TFPacienteNombres_Sel ,
                                 String AV35TFPacienteNombreCompleto ,
                                 String AV36TFPacienteNombreCompleto_Sel ,
                                 java.util.Date AV37TFPacienteFechaNacimiento ,
                                 java.util.Date AV38TFPacienteFechaNacimiento_To ,
                                 GXSimpleCollection<String> AV43TFPacienteTipoDocumento_Sels ,
                                 String AV44TFPacienteNroDocumento ,
                                 String AV45TFPacienteNroDocumento_Sel ,
                                 String AV46TFPacienteDireccion ,
                                 String AV47TFPacienteDireccion_Sel ,
                                 GXSimpleCollection<String> AV51TFPacienteSexo_Sels ,
                                 String AV52TFPacienteCorreo ,
                                 String AV53TFPacienteCorreo_Sel ,
                                 String AV54TFPacienteTelefono ,
                                 String AV55TFPacienteTelefono_Sel ,
                                 short AV56TFPaisId ,
                                 short AV57TFPaisId_To ,
                                 String AV58TFPaisDescripcion ,
                                 String AV59TFPaisDescripcion_Sel ,
                                 GXSimpleCollection<String> AV61TFPacienteEstado_Sels ,
                                 short AV62TFSecUserId ,
                                 short AV63TFSecUserId_To ,
                                 String AV64TFUbigeoCode ,
                                 String AV65TFUbigeoCode_Sel ,
                                 String AV66TFUbigeoNombre ,
                                 String AV67TFUbigeoNombre_Sel ,
                                 java.math.BigDecimal AV68TFPacienteEstatura ,
                                 java.math.BigDecimal AV69TFPacienteEstatura_To ,
                                 java.math.BigDecimal AV70TFPacientePeso ,
                                 java.math.BigDecimal AV71TFPacientePeso_To ,
                                 String AV72TFPacienteNombreAnexo ,
                                 String AV73TFPacienteNombreAnexo_Sel ,
                                 GXSimpleCollection<String> AV49TFPacienteEnterarse_Sels ,
                                 String AV90TFPacienteEspecifique ,
                                 String AV91TFPacienteEspecifique_Sel ,
                                 String AV139Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV84IsAuthorized_Update ,
                                 boolean AV86IsAuthorized_Delete ,
                                 boolean AV87IsAuthorized_PaisDescripcion ,
                                 boolean AV88IsAuthorized_UbigeoNombre )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e201F2 ();
      GRID_nCurrentRecord = 0 ;
      rf1F2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEID", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")));
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
      rf1F2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV139Pgmname = "PacienteWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf1F2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e201F2 ();
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
                                              A214PacienteTipoDocumento ,
                                              AV107Pacientewwds_14_tfpacientetipodocumento_sels ,
                                              A216PacienteSexo ,
                                              AV112Pacientewwds_19_tfpacientesexo_sels ,
                                              A219PacienteEstado ,
                                              AV121Pacientewwds_28_tfpacienteestado_sels ,
                                              A224PacienteEnterarse ,
                                              AV134Pacientewwds_41_tfpacienteenterarse_sels ,
                                              AV94Pacientewwds_1_filterfulltext ,
                                              Integer.valueOf(AV95Pacientewwds_2_tfpacienteid) ,
                                              Integer.valueOf(AV96Pacientewwds_3_tfpacienteid_to) ,
                                              AV98Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                              AV97Pacientewwds_4_tfpacienteapellidopaterno ,
                                              AV100Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                              AV99Pacientewwds_6_tfpacienteapellidomaterno ,
                                              AV102Pacientewwds_9_tfpacientenombres_sel ,
                                              AV101Pacientewwds_8_tfpacientenombres ,
                                              AV104Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                              AV103Pacientewwds_10_tfpacientenombrecompleto ,
                                              AV105Pacientewwds_12_tfpacientefechanacimiento ,
                                              AV106Pacientewwds_13_tfpacientefechanacimiento_to ,
                                              Integer.valueOf(AV107Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                              AV109Pacientewwds_16_tfpacientenrodocumento_sel ,
                                              AV108Pacientewwds_15_tfpacientenrodocumento ,
                                              AV111Pacientewwds_18_tfpacientedireccion_sel ,
                                              AV110Pacientewwds_17_tfpacientedireccion ,
                                              Integer.valueOf(AV112Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                              AV114Pacientewwds_21_tfpacientecorreo_sel ,
                                              AV113Pacientewwds_20_tfpacientecorreo ,
                                              AV116Pacientewwds_23_tfpacientetelefono_sel ,
                                              AV115Pacientewwds_22_tfpacientetelefono ,
                                              Short.valueOf(AV117Pacientewwds_24_tfpaisid) ,
                                              Short.valueOf(AV118Pacientewwds_25_tfpaisid_to) ,
                                              AV120Pacientewwds_27_tfpaisdescripcion_sel ,
                                              AV119Pacientewwds_26_tfpaisdescripcion ,
                                              Integer.valueOf(AV121Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                              Short.valueOf(AV122Pacientewwds_29_tfsecuserid) ,
                                              Short.valueOf(AV123Pacientewwds_30_tfsecuserid_to) ,
                                              AV125Pacientewwds_32_tfubigeocode_sel ,
                                              AV124Pacientewwds_31_tfubigeocode ,
                                              AV127Pacientewwds_34_tfubigeonombre_sel ,
                                              AV126Pacientewwds_33_tfubigeonombre ,
                                              AV128Pacientewwds_35_tfpacienteestatura ,
                                              AV129Pacientewwds_36_tfpacienteestatura_to ,
                                              AV130Pacientewwds_37_tfpacientepeso ,
                                              AV131Pacientewwds_38_tfpacientepeso_to ,
                                              AV133Pacientewwds_40_tfpacientenombreanexo_sel ,
                                              AV132Pacientewwds_39_tfpacientenombreanexo ,
                                              Integer.valueOf(AV134Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                              AV136Pacientewwds_43_tfpacienteespecifique_sel ,
                                              AV135Pacientewwds_42_tfpacienteespecifique ,
                                              AV137Pacientewwds_44_tfpacientefecharegistro ,
                                              AV138Pacientewwds_45_tfpacientefecharegistro_to ,
                                              Integer.valueOf(A20PacienteId) ,
                                              A103PacienteApellidoPaterno ,
                                              A104PacienteApellidoMaterno ,
                                              A105PacienteNombres ,
                                              A106PacienteNroDocumento ,
                                              A215PacienteDireccion ,
                                              A217PacienteCorreo ,
                                              A218PacienteTelefono ,
                                              Short.valueOf(A43PaisId) ,
                                              A184PaisDescripcion ,
                                              Short.valueOf(A6SecUserId) ,
                                              A44UbigeoCode ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito ,
                                              A220PacienteEstatura ,
                                              A221PacientePeso ,
                                              A222PacienteNombreAnexo ,
                                              A225PacienteEspecifique ,
                                              A213PacienteFechaNacimiento ,
                                              A226PacienteFechaRegistro ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                              TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
         lV97Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
         lV99Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV99Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
         lV101Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_8_tfpacientenombres), "%", "") ;
         lV103Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV103Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
         lV108Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV108Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
         lV110Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV110Pacientewwds_17_tfpacientedireccion), "%", "") ;
         lV113Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV113Pacientewwds_20_tfpacientecorreo), "%", "") ;
         lV115Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV115Pacientewwds_22_tfpacientetelefono), 20, "%") ;
         lV119Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV119Pacientewwds_26_tfpaisdescripcion), "%", "") ;
         lV124Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV124Pacientewwds_31_tfubigeocode), 10, "%") ;
         lV126Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV126Pacientewwds_33_tfubigeonombre), "%", "") ;
         lV132Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV132Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
         lV135Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV135Pacientewwds_42_tfpacienteespecifique), "%", "") ;
         /* Using cursor H001F2 */
         pr_default.execute(0, new Object[] {lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, Integer.valueOf(AV95Pacientewwds_2_tfpacienteid), Integer.valueOf(AV96Pacientewwds_3_tfpacienteid_to), lV97Pacientewwds_4_tfpacienteapellidopaterno, AV98Pacientewwds_5_tfpacienteapellidopaterno_sel, lV99Pacientewwds_6_tfpacienteapellidomaterno, AV100Pacientewwds_7_tfpacienteapellidomaterno_sel, lV101Pacientewwds_8_tfpacientenombres, AV102Pacientewwds_9_tfpacientenombres_sel, lV103Pacientewwds_10_tfpacientenombrecompleto, AV104Pacientewwds_11_tfpacientenombrecompleto_sel, AV105Pacientewwds_12_tfpacientefechanacimiento, AV106Pacientewwds_13_tfpacientefechanacimiento_to, lV108Pacientewwds_15_tfpacientenrodocumento, AV109Pacientewwds_16_tfpacientenrodocumento_sel, lV110Pacientewwds_17_tfpacientedireccion, AV111Pacientewwds_18_tfpacientedireccion_sel, lV113Pacientewwds_20_tfpacientecorreo, AV114Pacientewwds_21_tfpacientecorreo_sel, lV115Pacientewwds_22_tfpacientetelefono, AV116Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV117Pacientewwds_24_tfpaisid), Short.valueOf(AV118Pacientewwds_25_tfpaisid_to), lV119Pacientewwds_26_tfpaisdescripcion, AV120Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV122Pacientewwds_29_tfsecuserid), Short.valueOf(AV123Pacientewwds_30_tfsecuserid_to), lV124Pacientewwds_31_tfubigeocode, AV125Pacientewwds_32_tfubigeocode_sel, lV126Pacientewwds_33_tfubigeonombre, AV127Pacientewwds_34_tfubigeonombre_sel, AV128Pacientewwds_35_tfpacienteestatura, AV129Pacientewwds_36_tfpacienteestatura_to, AV130Pacientewwds_37_tfpacientepeso, AV131Pacientewwds_38_tfpacientepeso_to, lV132Pacientewwds_39_tfpacientenombreanexo, AV133Pacientewwds_40_tfpacientenombreanexo_sel, lV135Pacientewwds_42_tfpacienteespecifique, AV136Pacientewwds_43_tfpacienteespecifique_sel, AV137Pacientewwds_44_tfpacientefecharegistro, AV138Pacientewwds_45_tfpacientefecharegistro_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A226PacienteFechaRegistro = H001F2_A226PacienteFechaRegistro[0] ;
            A225PacienteEspecifique = H001F2_A225PacienteEspecifique[0] ;
            n225PacienteEspecifique = H001F2_n225PacienteEspecifique[0] ;
            A224PacienteEnterarse = H001F2_A224PacienteEnterarse[0] ;
            n224PacienteEnterarse = H001F2_n224PacienteEnterarse[0] ;
            A223PacienteAnexos = H001F2_A223PacienteAnexos[0] ;
            n223PacienteAnexos = H001F2_n223PacienteAnexos[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_43_Refreshing);
            A222PacienteNombreAnexo = H001F2_A222PacienteNombreAnexo[0] ;
            n222PacienteNombreAnexo = H001F2_n222PacienteNombreAnexo[0] ;
            A221PacientePeso = H001F2_A221PacientePeso[0] ;
            A220PacienteEstatura = H001F2_A220PacienteEstatura[0] ;
            A44UbigeoCode = H001F2_A44UbigeoCode[0] ;
            n44UbigeoCode = H001F2_n44UbigeoCode[0] ;
            A6SecUserId = H001F2_A6SecUserId[0] ;
            n6SecUserId = H001F2_n6SecUserId[0] ;
            A219PacienteEstado = H001F2_A219PacienteEstado[0] ;
            A184PaisDescripcion = H001F2_A184PaisDescripcion[0] ;
            A43PaisId = H001F2_A43PaisId[0] ;
            A218PacienteTelefono = H001F2_A218PacienteTelefono[0] ;
            A217PacienteCorreo = H001F2_A217PacienteCorreo[0] ;
            A216PacienteSexo = H001F2_A216PacienteSexo[0] ;
            A215PacienteDireccion = H001F2_A215PacienteDireccion[0] ;
            A106PacienteNroDocumento = H001F2_A106PacienteNroDocumento[0] ;
            A214PacienteTipoDocumento = H001F2_A214PacienteTipoDocumento[0] ;
            A213PacienteFechaNacimiento = H001F2_A213PacienteFechaNacimiento[0] ;
            A20PacienteId = H001F2_A20PacienteId[0] ;
            A105PacienteNombres = H001F2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H001F2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H001F2_A103PacienteApellidoPaterno[0] ;
            A188UbigeoDistrito = H001F2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H001F2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H001F2_A186UbigeoDepartamento[0] ;
            A188UbigeoDistrito = H001F2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H001F2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H001F2_A186UbigeoDepartamento[0] ;
            A184PaisDescripcion = H001F2_A184PaisDescripcion[0] ;
            A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
            A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
            e211F2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb1F0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1F2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV139Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV139Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV84IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV86IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PAISDESCRIPCION", AV87IsAuthorized_PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV87IsAuthorized_PaisDescripcion));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UBIGEONOMBRE", AV88IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV88IsAuthorized_UbigeoNombre));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PACIENTEID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")));
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
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV107Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV112Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV121Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV134Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV94Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV95Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV96Pacientewwds_3_tfpacienteid_to) ,
                                           AV98Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV97Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV100Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV99Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV102Pacientewwds_9_tfpacientenombres_sel ,
                                           AV101Pacientewwds_8_tfpacientenombres ,
                                           AV104Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV103Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV105Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV106Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV107Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV109Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV108Pacientewwds_15_tfpacientenrodocumento ,
                                           AV111Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV110Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV112Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV114Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV113Pacientewwds_20_tfpacientecorreo ,
                                           AV116Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV115Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV117Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV118Pacientewwds_25_tfpaisid_to) ,
                                           AV120Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV119Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV121Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV122Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV123Pacientewwds_30_tfsecuserid_to) ,
                                           AV125Pacientewwds_32_tfubigeocode_sel ,
                                           AV124Pacientewwds_31_tfubigeocode ,
                                           AV127Pacientewwds_34_tfubigeonombre_sel ,
                                           AV126Pacientewwds_33_tfubigeonombre ,
                                           AV128Pacientewwds_35_tfpacienteestatura ,
                                           AV129Pacientewwds_36_tfpacienteestatura_to ,
                                           AV130Pacientewwds_37_tfpacientepeso ,
                                           AV131Pacientewwds_38_tfpacientepeso_to ,
                                           AV133Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV132Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV134Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV136Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV135Pacientewwds_42_tfpacienteespecifique ,
                                           AV137Pacientewwds_44_tfpacientefecharegistro ,
                                           AV138Pacientewwds_45_tfpacientefecharegistro_to ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           A215PacienteDireccion ,
                                           A217PacienteCorreo ,
                                           A218PacienteTelefono ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           Short.valueOf(A6SecUserId) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A220PacienteEstatura ,
                                           A221PacientePeso ,
                                           A222PacienteNombreAnexo ,
                                           A225PacienteEspecifique ,
                                           A213PacienteFechaNacimiento ,
                                           A226PacienteFechaRegistro ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV94Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV94Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV99Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV99Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV101Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV103Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV103Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV108Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV108Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV110Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV110Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV113Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV113Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV115Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV115Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV119Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV119Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV124Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV124Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV126Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV126Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV132Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV132Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV135Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV135Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor H001F3 */
      pr_default.execute(1, new Object[] {lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, lV94Pacientewwds_1_filterfulltext, Integer.valueOf(AV95Pacientewwds_2_tfpacienteid), Integer.valueOf(AV96Pacientewwds_3_tfpacienteid_to), lV97Pacientewwds_4_tfpacienteapellidopaterno, AV98Pacientewwds_5_tfpacienteapellidopaterno_sel, lV99Pacientewwds_6_tfpacienteapellidomaterno, AV100Pacientewwds_7_tfpacienteapellidomaterno_sel, lV101Pacientewwds_8_tfpacientenombres, AV102Pacientewwds_9_tfpacientenombres_sel, lV103Pacientewwds_10_tfpacientenombrecompleto, AV104Pacientewwds_11_tfpacientenombrecompleto_sel, AV105Pacientewwds_12_tfpacientefechanacimiento, AV106Pacientewwds_13_tfpacientefechanacimiento_to, lV108Pacientewwds_15_tfpacientenrodocumento, AV109Pacientewwds_16_tfpacientenrodocumento_sel, lV110Pacientewwds_17_tfpacientedireccion, AV111Pacientewwds_18_tfpacientedireccion_sel, lV113Pacientewwds_20_tfpacientecorreo, AV114Pacientewwds_21_tfpacientecorreo_sel, lV115Pacientewwds_22_tfpacientetelefono, AV116Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV117Pacientewwds_24_tfpaisid), Short.valueOf(AV118Pacientewwds_25_tfpaisid_to), lV119Pacientewwds_26_tfpaisdescripcion, AV120Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV122Pacientewwds_29_tfsecuserid), Short.valueOf(AV123Pacientewwds_30_tfsecuserid_to), lV124Pacientewwds_31_tfubigeocode, AV125Pacientewwds_32_tfubigeocode_sel, lV126Pacientewwds_33_tfubigeonombre, AV127Pacientewwds_34_tfubigeonombre_sel, AV128Pacientewwds_35_tfpacienteestatura, AV129Pacientewwds_36_tfpacienteestatura_to, AV130Pacientewwds_37_tfpacientepeso, AV131Pacientewwds_38_tfpacientepeso_to, lV132Pacientewwds_39_tfpacientenombreanexo, AV133Pacientewwds_40_tfpacientenombreanexo_sel, lV135Pacientewwds_42_tfpacienteespecifique, AV136Pacientewwds_43_tfpacienteespecifique_sel, AV137Pacientewwds_44_tfpacientefecharegistro, AV138Pacientewwds_45_tfpacientefecharegistro_to});
      GRID_nRecordCount = H001F3_AGRID_nRecordCount[0] ;
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
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV74TFPacienteFechaRegistro, AV75TFPacienteFechaRegistro_To, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPacienteId, AV28TFPacienteId_To, AV29TFPacienteApellidoPaterno, AV30TFPacienteApellidoPaterno_Sel, AV31TFPacienteApellidoMaterno, AV32TFPacienteApellidoMaterno_Sel, AV33TFPacienteNombres, AV34TFPacienteNombres_Sel, AV35TFPacienteNombreCompleto, AV36TFPacienteNombreCompleto_Sel, AV37TFPacienteFechaNacimiento, AV38TFPacienteFechaNacimiento_To, AV43TFPacienteTipoDocumento_Sels, AV44TFPacienteNroDocumento, AV45TFPacienteNroDocumento_Sel, AV46TFPacienteDireccion, AV47TFPacienteDireccion_Sel, AV51TFPacienteSexo_Sels, AV52TFPacienteCorreo, AV53TFPacienteCorreo_Sel, AV54TFPacienteTelefono, AV55TFPacienteTelefono_Sel, AV56TFPaisId, AV57TFPaisId_To, AV58TFPaisDescripcion, AV59TFPaisDescripcion_Sel, AV61TFPacienteEstado_Sels, AV62TFSecUserId, AV63TFSecUserId_To, AV64TFUbigeoCode, AV65TFUbigeoCode_Sel, AV66TFUbigeoNombre, AV67TFUbigeoNombre_Sel, AV68TFPacienteEstatura, AV69TFPacienteEstatura_To, AV70TFPacientePeso, AV71TFPacientePeso_To, AV72TFPacienteNombreAnexo, AV73TFPacienteNombreAnexo_Sel, AV49TFPacienteEnterarse_Sels, AV90TFPacienteEspecifique, AV91TFPacienteEspecifique_Sel, AV139Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV87IsAuthorized_PaisDescripcion, AV88IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV74TFPacienteFechaRegistro, AV75TFPacienteFechaRegistro_To, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPacienteId, AV28TFPacienteId_To, AV29TFPacienteApellidoPaterno, AV30TFPacienteApellidoPaterno_Sel, AV31TFPacienteApellidoMaterno, AV32TFPacienteApellidoMaterno_Sel, AV33TFPacienteNombres, AV34TFPacienteNombres_Sel, AV35TFPacienteNombreCompleto, AV36TFPacienteNombreCompleto_Sel, AV37TFPacienteFechaNacimiento, AV38TFPacienteFechaNacimiento_To, AV43TFPacienteTipoDocumento_Sels, AV44TFPacienteNroDocumento, AV45TFPacienteNroDocumento_Sel, AV46TFPacienteDireccion, AV47TFPacienteDireccion_Sel, AV51TFPacienteSexo_Sels, AV52TFPacienteCorreo, AV53TFPacienteCorreo_Sel, AV54TFPacienteTelefono, AV55TFPacienteTelefono_Sel, AV56TFPaisId, AV57TFPaisId_To, AV58TFPaisDescripcion, AV59TFPaisDescripcion_Sel, AV61TFPacienteEstado_Sels, AV62TFSecUserId, AV63TFSecUserId_To, AV64TFUbigeoCode, AV65TFUbigeoCode_Sel, AV66TFUbigeoNombre, AV67TFUbigeoNombre_Sel, AV68TFPacienteEstatura, AV69TFPacienteEstatura_To, AV70TFPacientePeso, AV71TFPacientePeso_To, AV72TFPacienteNombreAnexo, AV73TFPacienteNombreAnexo_Sel, AV49TFPacienteEnterarse_Sels, AV90TFPacienteEspecifique, AV91TFPacienteEspecifique_Sel, AV139Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV87IsAuthorized_PaisDescripcion, AV88IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV74TFPacienteFechaRegistro, AV75TFPacienteFechaRegistro_To, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPacienteId, AV28TFPacienteId_To, AV29TFPacienteApellidoPaterno, AV30TFPacienteApellidoPaterno_Sel, AV31TFPacienteApellidoMaterno, AV32TFPacienteApellidoMaterno_Sel, AV33TFPacienteNombres, AV34TFPacienteNombres_Sel, AV35TFPacienteNombreCompleto, AV36TFPacienteNombreCompleto_Sel, AV37TFPacienteFechaNacimiento, AV38TFPacienteFechaNacimiento_To, AV43TFPacienteTipoDocumento_Sels, AV44TFPacienteNroDocumento, AV45TFPacienteNroDocumento_Sel, AV46TFPacienteDireccion, AV47TFPacienteDireccion_Sel, AV51TFPacienteSexo_Sels, AV52TFPacienteCorreo, AV53TFPacienteCorreo_Sel, AV54TFPacienteTelefono, AV55TFPacienteTelefono_Sel, AV56TFPaisId, AV57TFPaisId_To, AV58TFPaisDescripcion, AV59TFPaisDescripcion_Sel, AV61TFPacienteEstado_Sels, AV62TFSecUserId, AV63TFSecUserId_To, AV64TFUbigeoCode, AV65TFUbigeoCode_Sel, AV66TFUbigeoNombre, AV67TFUbigeoNombre_Sel, AV68TFPacienteEstatura, AV69TFPacienteEstatura_To, AV70TFPacientePeso, AV71TFPacientePeso_To, AV72TFPacienteNombreAnexo, AV73TFPacienteNombreAnexo_Sel, AV49TFPacienteEnterarse_Sels, AV90TFPacienteEspecifique, AV91TFPacienteEspecifique_Sel, AV139Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV87IsAuthorized_PaisDescripcion, AV88IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV74TFPacienteFechaRegistro, AV75TFPacienteFechaRegistro_To, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPacienteId, AV28TFPacienteId_To, AV29TFPacienteApellidoPaterno, AV30TFPacienteApellidoPaterno_Sel, AV31TFPacienteApellidoMaterno, AV32TFPacienteApellidoMaterno_Sel, AV33TFPacienteNombres, AV34TFPacienteNombres_Sel, AV35TFPacienteNombreCompleto, AV36TFPacienteNombreCompleto_Sel, AV37TFPacienteFechaNacimiento, AV38TFPacienteFechaNacimiento_To, AV43TFPacienteTipoDocumento_Sels, AV44TFPacienteNroDocumento, AV45TFPacienteNroDocumento_Sel, AV46TFPacienteDireccion, AV47TFPacienteDireccion_Sel, AV51TFPacienteSexo_Sels, AV52TFPacienteCorreo, AV53TFPacienteCorreo_Sel, AV54TFPacienteTelefono, AV55TFPacienteTelefono_Sel, AV56TFPaisId, AV57TFPaisId_To, AV58TFPaisDescripcion, AV59TFPaisDescripcion_Sel, AV61TFPacienteEstado_Sels, AV62TFSecUserId, AV63TFSecUserId_To, AV64TFUbigeoCode, AV65TFUbigeoCode_Sel, AV66TFUbigeoNombre, AV67TFUbigeoNombre_Sel, AV68TFPacienteEstatura, AV69TFPacienteEstatura_To, AV70TFPacientePeso, AV71TFPacientePeso_To, AV72TFPacienteNombreAnexo, AV73TFPacienteNombreAnexo_Sel, AV49TFPacienteEnterarse_Sels, AV90TFPacienteEspecifique, AV91TFPacienteEspecifique_Sel, AV139Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV87IsAuthorized_PaisDescripcion, AV88IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV74TFPacienteFechaRegistro, AV75TFPacienteFechaRegistro_To, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPacienteId, AV28TFPacienteId_To, AV29TFPacienteApellidoPaterno, AV30TFPacienteApellidoPaterno_Sel, AV31TFPacienteApellidoMaterno, AV32TFPacienteApellidoMaterno_Sel, AV33TFPacienteNombres, AV34TFPacienteNombres_Sel, AV35TFPacienteNombreCompleto, AV36TFPacienteNombreCompleto_Sel, AV37TFPacienteFechaNacimiento, AV38TFPacienteFechaNacimiento_To, AV43TFPacienteTipoDocumento_Sels, AV44TFPacienteNroDocumento, AV45TFPacienteNroDocumento_Sel, AV46TFPacienteDireccion, AV47TFPacienteDireccion_Sel, AV51TFPacienteSexo_Sels, AV52TFPacienteCorreo, AV53TFPacienteCorreo_Sel, AV54TFPacienteTelefono, AV55TFPacienteTelefono_Sel, AV56TFPaisId, AV57TFPaisId_To, AV58TFPaisDescripcion, AV59TFPaisDescripcion_Sel, AV61TFPacienteEstado_Sels, AV62TFSecUserId, AV63TFSecUserId_To, AV64TFUbigeoCode, AV65TFUbigeoCode_Sel, AV66TFUbigeoNombre, AV67TFUbigeoNombre_Sel, AV68TFPacienteEstatura, AV69TFPacienteEstatura_To, AV70TFPacientePeso, AV71TFPacientePeso_To, AV72TFPacienteNombreAnexo, AV73TFPacienteNombreAnexo_Sel, AV49TFPacienteEnterarse_Sels, AV90TFPacienteEspecifique, AV91TFPacienteEspecifique_Sel, AV139Pgmname, AV13OrderedBy, AV14OrderedDsc, AV84IsAuthorized_Update, AV86IsAuthorized_Delete, AV87IsAuthorized_PaisDescripcion, AV88IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV139Pgmname = "PacienteWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1F0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e191F2 ();
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
         AV39DDO_PacienteFechaNacimientoAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_PACIENTEFECHANACIMIENTOAUXDATE"), 0) ;
         AV40DDO_PacienteFechaNacimientoAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_PACIENTEFECHANACIMIENTOAUXDATETO"), 0) ;
         AV76DDO_PacienteFechaRegistroAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_PACIENTEFECHAREGISTROAUXDATE"), 0) ;
         AV77DDO_PacienteFechaRegistroAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_PACIENTEFECHAREGISTROAUXDATETO"), 0) ;
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
         AV41DDO_PacienteFechaNacimientoAuxDateText = httpContext.cgiGet( edtavDdo_pacientefechanacimientoauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41DDO_PacienteFechaNacimientoAuxDateText", AV41DDO_PacienteFechaNacimientoAuxDateText);
         AV78DDO_PacienteFechaRegistroAuxDateText = httpContext.cgiGet( edtavDdo_pacientefecharegistroauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78DDO_PacienteFechaRegistroAuxDateText", AV78DDO_PacienteFechaRegistroAuxDateText);
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
      e191F2 ();
      if (returnInSub) return;
   }

   public void e191F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFPACIENTEFECHAREGISTRO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_pacientefecharegistroauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFPACIENTEFECHANACIMIENTO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_pacientefechanacimientoauxdatetext_Internalname});
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
      GXt_boolean1 = AV87IsAuthorized_PaisDescripcion ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais", GXv_boolean2) ;
      pacienteww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV87IsAuthorized_PaisDescripcion = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87IsAuthorized_PaisDescripcion", AV87IsAuthorized_PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV87IsAuthorized_PaisDescripcion));
      GXt_boolean1 = AV88IsAuthorized_UbigeoNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean2) ;
      pacienteww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV88IsAuthorized_UbigeoNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88IsAuthorized_UbigeoNombre", AV88IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV88IsAuthorized_UbigeoNombre));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Paciente" );
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

   public void e201F2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("PacienteWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("PacienteWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtPacienteId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteApellidoPaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoPaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoPaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteApellidoMaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoMaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoMaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNombres_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombres_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNombreCompleto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombreCompleto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombreCompleto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteFechaNacimiento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteFechaNacimiento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteFechaNacimiento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPacienteTipoDocumento.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteTipoDocumento.getInternalname(), "Visible", GXutil.ltrimstr( cmbPacienteTipoDocumento.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNroDocumento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNroDocumento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNroDocumento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteDireccion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteDireccion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteDireccion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPacienteSexo.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteSexo.getInternalname(), "Visible", GXutil.ltrimstr( cmbPacienteSexo.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteCorreo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteCorreo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteCorreo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteTelefono_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteTelefono_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteTelefono_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPaisId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPaisDescripcion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisDescripcion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisDescripcion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPacienteEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbPacienteEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtSecUserId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteEstatura_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteEstatura_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteEstatura_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacientePeso_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacientePeso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacientePeso_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteNombreAnexo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombreAnexo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombreAnexo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteAnexos_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteAnexos_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbPacienteEnterarse.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEnterarse.getInternalname(), "Visible", GXutil.ltrimstr( cmbPacienteEnterarse.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteEspecifique_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteEspecifique_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteEspecifique_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPacienteFechaRegistro_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteFechaRegistro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteFechaRegistro_Visible), 5, 0), !bGXsfl_43_Refreshing);
      AV81GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81GridCurrentPage), 10, 0));
      AV82GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82GridPageCount), 10, 0));
      AV94Pacientewwds_1_filterfulltext = AV16FilterFullText ;
      AV95Pacientewwds_2_tfpacienteid = AV27TFPacienteId ;
      AV96Pacientewwds_3_tfpacienteid_to = AV28TFPacienteId_To ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV101Pacientewwds_8_tfpacientenombres = AV33TFPacienteNombres ;
      AV102Pacientewwds_9_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = AV35TFPacienteNombreCompleto ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = AV36TFPacienteNombreCompleto_Sel ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = AV37TFPacienteFechaNacimiento ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = AV38TFPacienteFechaNacimiento_To ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = AV43TFPacienteTipoDocumento_Sels ;
      AV108Pacientewwds_15_tfpacientenrodocumento = AV44TFPacienteNroDocumento ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = AV45TFPacienteNroDocumento_Sel ;
      AV110Pacientewwds_17_tfpacientedireccion = AV46TFPacienteDireccion ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = AV47TFPacienteDireccion_Sel ;
      AV112Pacientewwds_19_tfpacientesexo_sels = AV51TFPacienteSexo_Sels ;
      AV113Pacientewwds_20_tfpacientecorreo = AV52TFPacienteCorreo ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = AV53TFPacienteCorreo_Sel ;
      AV115Pacientewwds_22_tfpacientetelefono = AV54TFPacienteTelefono ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = AV55TFPacienteTelefono_Sel ;
      AV117Pacientewwds_24_tfpaisid = AV56TFPaisId ;
      AV118Pacientewwds_25_tfpaisid_to = AV57TFPaisId_To ;
      AV119Pacientewwds_26_tfpaisdescripcion = AV58TFPaisDescripcion ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = AV59TFPaisDescripcion_Sel ;
      AV121Pacientewwds_28_tfpacienteestado_sels = AV61TFPacienteEstado_Sels ;
      AV122Pacientewwds_29_tfsecuserid = AV62TFSecUserId ;
      AV123Pacientewwds_30_tfsecuserid_to = AV63TFSecUserId_To ;
      AV124Pacientewwds_31_tfubigeocode = AV64TFUbigeoCode ;
      AV125Pacientewwds_32_tfubigeocode_sel = AV65TFUbigeoCode_Sel ;
      AV126Pacientewwds_33_tfubigeonombre = AV66TFUbigeoNombre ;
      AV127Pacientewwds_34_tfubigeonombre_sel = AV67TFUbigeoNombre_Sel ;
      AV128Pacientewwds_35_tfpacienteestatura = AV68TFPacienteEstatura ;
      AV129Pacientewwds_36_tfpacienteestatura_to = AV69TFPacienteEstatura_To ;
      AV130Pacientewwds_37_tfpacientepeso = AV70TFPacientePeso ;
      AV131Pacientewwds_38_tfpacientepeso_to = AV71TFPacientePeso_To ;
      AV132Pacientewwds_39_tfpacientenombreanexo = AV72TFPacienteNombreAnexo ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = AV73TFPacienteNombreAnexo_Sel ;
      AV134Pacientewwds_41_tfpacienteenterarse_sels = AV49TFPacienteEnterarse_Sels ;
      AV135Pacientewwds_42_tfpacienteespecifique = AV90TFPacienteEspecifique ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = AV91TFPacienteEspecifique_Sel ;
      AV137Pacientewwds_44_tfpacientefecharegistro = AV74TFPacienteFechaRegistro ;
      AV138Pacientewwds_45_tfpacientefecharegistro_to = AV75TFPacienteFechaRegistro_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e121F2( )
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

   public void e131F2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141F2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteId") == 0 )
         {
            AV27TFPacienteId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPacienteId), 8, 0));
            AV28TFPacienteId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPacienteId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoPaterno") == 0 )
         {
            AV29TFPacienteApellidoPaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFPacienteApellidoPaterno", AV29TFPacienteApellidoPaterno);
            AV30TFPacienteApellidoPaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFPacienteApellidoPaterno_Sel", AV30TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoMaterno") == 0 )
         {
            AV31TFPacienteApellidoMaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPacienteApellidoMaterno", AV31TFPacienteApellidoMaterno);
            AV32TFPacienteApellidoMaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPacienteApellidoMaterno_Sel", AV32TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNombres") == 0 )
         {
            AV33TFPacienteNombres = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPacienteNombres", AV33TFPacienteNombres);
            AV34TFPacienteNombres_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPacienteNombres_Sel", AV34TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNombreCompleto") == 0 )
         {
            AV35TFPacienteNombreCompleto = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFPacienteNombreCompleto", AV35TFPacienteNombreCompleto);
            AV36TFPacienteNombreCompleto_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFPacienteNombreCompleto_Sel", AV36TFPacienteNombreCompleto_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteFechaNacimiento") == 0 )
         {
            AV37TFPacienteFechaNacimiento = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPacienteFechaNacimiento", localUtil.format(AV37TFPacienteFechaNacimiento, "99/99/99"));
            AV38TFPacienteFechaNacimiento_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPacienteFechaNacimiento_To", localUtil.format(AV38TFPacienteFechaNacimiento_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteTipoDocumento") == 0 )
         {
            AV42TFPacienteTipoDocumento_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFPacienteTipoDocumento_SelsJson", AV42TFPacienteTipoDocumento_SelsJson);
            AV43TFPacienteTipoDocumento_Sels.fromJSonString(AV42TFPacienteTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNroDocumento") == 0 )
         {
            AV44TFPacienteNroDocumento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFPacienteNroDocumento", AV44TFPacienteNroDocumento);
            AV45TFPacienteNroDocumento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPacienteNroDocumento_Sel", AV45TFPacienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteDireccion") == 0 )
         {
            AV46TFPacienteDireccion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPacienteDireccion", AV46TFPacienteDireccion);
            AV47TFPacienteDireccion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPacienteDireccion_Sel", AV47TFPacienteDireccion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteSexo") == 0 )
         {
            AV50TFPacienteSexo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPacienteSexo_SelsJson", AV50TFPacienteSexo_SelsJson);
            AV51TFPacienteSexo_Sels.fromJSonString(AV50TFPacienteSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteCorreo") == 0 )
         {
            AV52TFPacienteCorreo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFPacienteCorreo", AV52TFPacienteCorreo);
            AV53TFPacienteCorreo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFPacienteCorreo_Sel", AV53TFPacienteCorreo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteTelefono") == 0 )
         {
            AV54TFPacienteTelefono = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFPacienteTelefono", AV54TFPacienteTelefono);
            AV55TFPacienteTelefono_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFPacienteTelefono_Sel", AV55TFPacienteTelefono_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaisId") == 0 )
         {
            AV56TFPaisId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFPaisId), 4, 0));
            AV57TFPaisId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFPaisId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFPaisId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaisDescripcion") == 0 )
         {
            AV58TFPaisDescripcion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFPaisDescripcion", AV58TFPaisDescripcion);
            AV59TFPaisDescripcion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFPaisDescripcion_Sel", AV59TFPaisDescripcion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteEstado") == 0 )
         {
            AV60TFPacienteEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFPacienteEstado_SelsJson", AV60TFPacienteEstado_SelsJson);
            AV61TFPacienteEstado_Sels.fromJSonString(AV60TFPacienteEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecUserId") == 0 )
         {
            AV62TFSecUserId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFSecUserId), 4, 0));
            AV63TFSecUserId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFSecUserId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoCode") == 0 )
         {
            AV64TFUbigeoCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFUbigeoCode", AV64TFUbigeoCode);
            AV65TFUbigeoCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFUbigeoCode_Sel", AV65TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoNombre") == 0 )
         {
            AV66TFUbigeoNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFUbigeoNombre", AV66TFUbigeoNombre);
            AV67TFUbigeoNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFUbigeoNombre_Sel", AV67TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteEstatura") == 0 )
         {
            AV68TFPacienteEstatura = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFPacienteEstatura", GXutil.ltrimstr( AV68TFPacienteEstatura, 4, 2));
            AV69TFPacienteEstatura_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFPacienteEstatura_To", GXutil.ltrimstr( AV69TFPacienteEstatura_To, 4, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacientePeso") == 0 )
         {
            AV70TFPacientePeso = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFPacientePeso", GXutil.ltrimstr( AV70TFPacientePeso, 6, 2));
            AV71TFPacientePeso_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFPacientePeso_To", GXutil.ltrimstr( AV71TFPacientePeso_To, 6, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNombreAnexo") == 0 )
         {
            AV72TFPacienteNombreAnexo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFPacienteNombreAnexo", AV72TFPacienteNombreAnexo);
            AV73TFPacienteNombreAnexo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFPacienteNombreAnexo_Sel", AV73TFPacienteNombreAnexo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteEnterarse") == 0 )
         {
            AV48TFPacienteEnterarse_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFPacienteEnterarse_SelsJson", AV48TFPacienteEnterarse_SelsJson);
            AV49TFPacienteEnterarse_Sels.fromJSonString(AV48TFPacienteEnterarse_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteEspecifique") == 0 )
         {
            AV90TFPacienteEspecifique = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFPacienteEspecifique", AV90TFPacienteEspecifique);
            AV91TFPacienteEspecifique_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFPacienteEspecifique_Sel", AV91TFPacienteEspecifique_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteFechaRegistro") == 0 )
         {
            AV74TFPacienteFechaRegistro = localUtil.ctot( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFPacienteFechaRegistro", localUtil.ttoc( AV74TFPacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
            AV75TFPacienteFechaRegistro_To = localUtil.ctot( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFPacienteFechaRegistro_To", localUtil.ttoc( AV75TFPacienteFechaRegistro_To, 8, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV75TFPacienteFechaRegistro_To) )
            {
               AV75TFPacienteFechaRegistro_To = localUtil.ymdhmsToT( (short)(GXutil.year( AV75TFPacienteFechaRegistro_To)), (byte)(GXutil.month( AV75TFPacienteFechaRegistro_To)), (byte)(GXutil.day( AV75TFPacienteFechaRegistro_To)), (byte)(23), (byte)(59), (byte)(59)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV75TFPacienteFechaRegistro_To", localUtil.ttoc( AV75TFPacienteFechaRegistro_To, 8, 5, 0, 3, "/", ":", " "));
            }
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFPacienteEnterarse_Sels", AV49TFPacienteEnterarse_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFPacienteEstado_Sels", AV61TFPacienteEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51TFPacienteSexo_Sels", AV51TFPacienteSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43TFPacienteTipoDocumento_Sels", AV43TFPacienteTipoDocumento_Sels);
   }

   private void e211F2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV83Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV83Update);
      if ( AV84IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.paciente", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0))}, new String[] {"Mode","PacienteId"})  ;
      }
      AV85Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV85Delete);
      if ( AV86IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.paciente", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0))}, new String[] {"Mode","PacienteId"})  ;
      }
      edtPacienteNombres_Link = formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PacienteId","TabCode"})  ;
      if ( AV87IsAuthorized_PaisDescripcion )
      {
         edtPaisDescripcion_Link = formatLink("com.projectthani.paisview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A43PaisId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PaisId","TabCode"})  ;
      }
      if ( AV88IsAuthorized_UbigeoNombre )
      {
         edtUbigeoNombre_Link = formatLink("com.projectthani.ubigeoview", new String[] {GXutil.URLEncode(GXutil.rtrim(A44UbigeoCode)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"UbigeoCode","TabCode"})  ;
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

   public void e151F2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "PacienteWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e111F2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("PacienteWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV139Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("PacienteWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "PacienteWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         pacienteww_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV139Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43TFPacienteTipoDocumento_Sels", AV43TFPacienteTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51TFPacienteSexo_Sels", AV51TFPacienteSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFPacienteEstado_Sels", AV61TFPacienteEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFPacienteEnterarse_Sels", AV49TFPacienteEnterarse_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e161F2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.paciente", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","PacienteId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e171F2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.pacientewwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      pacienteww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      pacienteww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFPacienteEnterarse_Sels", AV49TFPacienteEnterarse_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFPacienteEstado_Sels", AV61TFPacienteEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51TFPacienteSexo_Sels", AV51TFPacienteSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43TFPacienteTipoDocumento_Sels", AV43TFPacienteTipoDocumento_Sels);
   }

   public void e181F2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.pacientewwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFPacienteEnterarse_Sels", AV49TFPacienteEnterarse_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFPacienteEstado_Sels", AV61TFPacienteEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51TFPacienteSexo_Sels", AV51TFPacienteSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43TFPacienteTipoDocumento_Sels", AV43TFPacienteTipoDocumento_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoPaterno", "", "Apellido Paterno", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoMaterno", "", "Apellido Materno", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombres", "", "Nombres", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombreCompleto", "", "Nombre Completo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteFechaNacimiento", "", "Fecha Nacimiento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteTipoDocumento", "", "Tipo Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNroDocumento", "", "Nro Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteDireccion", "", "Direccion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteSexo", "", "Sexo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteCorreo", "", "Correo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteTelefono", "", "Telefono", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PaisId", "", "Pais Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PaisDescripcion", "", "Pais Descripcion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecUserId", "", "User Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoCode", "", "Ubigeo Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEstatura", "", "Estatura", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacientePeso", "", "Peso", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombreAnexo", "", "Nombre Anexo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteAnexos", "", "Anexos", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEnterarse", "", "Enterarse", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEspecifique", "", "Especifique", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteFechaRegistro", "", "Fecha Registro", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PacienteWWColumnsSelector", GXv_char8) ;
      pacienteww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Update", GXv_boolean2) ;
      pacienteww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Delete", GXv_boolean2) ;
      pacienteww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV86IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86IsAuthorized_Delete", AV86IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV86IsAuthorized_Delete));
      if ( ! ( AV86IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV89TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Insert", GXv_boolean2) ;
      pacienteww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV89TempBoolean = GXt_boolean1 ;
      if ( ! ( AV89TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "PacienteWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFPacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPacienteId), 8, 0));
      AV28TFPacienteId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPacienteId_To), 8, 0));
      AV29TFPacienteApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFPacienteApellidoPaterno", AV29TFPacienteApellidoPaterno);
      AV30TFPacienteApellidoPaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFPacienteApellidoPaterno_Sel", AV30TFPacienteApellidoPaterno_Sel);
      AV31TFPacienteApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFPacienteApellidoMaterno", AV31TFPacienteApellidoMaterno);
      AV32TFPacienteApellidoMaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFPacienteApellidoMaterno_Sel", AV32TFPacienteApellidoMaterno_Sel);
      AV33TFPacienteNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFPacienteNombres", AV33TFPacienteNombres);
      AV34TFPacienteNombres_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFPacienteNombres_Sel", AV34TFPacienteNombres_Sel);
      AV35TFPacienteNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFPacienteNombreCompleto", AV35TFPacienteNombreCompleto);
      AV36TFPacienteNombreCompleto_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFPacienteNombreCompleto_Sel", AV36TFPacienteNombreCompleto_Sel);
      AV37TFPacienteFechaNacimiento = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFPacienteFechaNacimiento", localUtil.format(AV37TFPacienteFechaNacimiento, "99/99/99"));
      AV38TFPacienteFechaNacimiento_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFPacienteFechaNacimiento_To", localUtil.format(AV38TFPacienteFechaNacimiento_To, "99/99/99"));
      AV43TFPacienteTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44TFPacienteNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFPacienteNroDocumento", AV44TFPacienteNroDocumento);
      AV45TFPacienteNroDocumento_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFPacienteNroDocumento_Sel", AV45TFPacienteNroDocumento_Sel);
      AV46TFPacienteDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFPacienteDireccion", AV46TFPacienteDireccion);
      AV47TFPacienteDireccion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFPacienteDireccion_Sel", AV47TFPacienteDireccion_Sel);
      AV51TFPacienteSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52TFPacienteCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFPacienteCorreo", AV52TFPacienteCorreo);
      AV53TFPacienteCorreo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFPacienteCorreo_Sel", AV53TFPacienteCorreo_Sel);
      AV54TFPacienteTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFPacienteTelefono", AV54TFPacienteTelefono);
      AV55TFPacienteTelefono_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFPacienteTelefono_Sel", AV55TFPacienteTelefono_Sel);
      AV56TFPaisId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFPaisId), 4, 0));
      AV57TFPaisId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFPaisId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFPaisId_To), 4, 0));
      AV58TFPaisDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFPaisDescripcion", AV58TFPaisDescripcion);
      AV59TFPaisDescripcion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFPaisDescripcion_Sel", AV59TFPaisDescripcion_Sel);
      AV61TFPacienteEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62TFSecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFSecUserId), 4, 0));
      AV63TFSecUserId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFSecUserId_To), 4, 0));
      AV64TFUbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64TFUbigeoCode", AV64TFUbigeoCode);
      AV65TFUbigeoCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFUbigeoCode_Sel", AV65TFUbigeoCode_Sel);
      AV66TFUbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFUbigeoNombre", AV66TFUbigeoNombre);
      AV67TFUbigeoNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFUbigeoNombre_Sel", AV67TFUbigeoNombre_Sel);
      AV68TFPacienteEstatura = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68TFPacienteEstatura", GXutil.ltrimstr( AV68TFPacienteEstatura, 4, 2));
      AV69TFPacienteEstatura_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69TFPacienteEstatura_To", GXutil.ltrimstr( AV69TFPacienteEstatura_To, 4, 2));
      AV70TFPacientePeso = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70TFPacientePeso", GXutil.ltrimstr( AV70TFPacientePeso, 6, 2));
      AV71TFPacientePeso_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFPacientePeso_To", GXutil.ltrimstr( AV71TFPacientePeso_To, 6, 2));
      AV72TFPacienteNombreAnexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72TFPacienteNombreAnexo", AV72TFPacienteNombreAnexo);
      AV73TFPacienteNombreAnexo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73TFPacienteNombreAnexo_Sel", AV73TFPacienteNombreAnexo_Sel);
      AV49TFPacienteEnterarse_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV90TFPacienteEspecifique = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90TFPacienteEspecifique", AV90TFPacienteEspecifique);
      AV91TFPacienteEspecifique_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV91TFPacienteEspecifique_Sel", AV91TFPacienteEspecifique_Sel);
      AV74TFPacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV74TFPacienteFechaRegistro", localUtil.ttoc( AV74TFPacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
      AV75TFPacienteFechaRegistro_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV75TFPacienteFechaRegistro_To", localUtil.ttoc( AV75TFPacienteFechaRegistro_To, 8, 5, 0, 3, "/", ":", " "));
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
      if ( GXutil.strcmp(AV23Session.getValue(AV139Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV139Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV139Pgmname+"GridState"), null, null);
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
      AV140GXV1 = 1 ;
      while ( AV140GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV140GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV27TFPacienteId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPacienteId), 8, 0));
            AV28TFPacienteId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPacienteId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPacienteId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV29TFPacienteApellidoPaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFPacienteApellidoPaterno", AV29TFPacienteApellidoPaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV30TFPacienteApellidoPaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFPacienteApellidoPaterno_Sel", AV30TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV31TFPacienteApellidoMaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPacienteApellidoMaterno", AV31TFPacienteApellidoMaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV32TFPacienteApellidoMaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPacienteApellidoMaterno_Sel", AV32TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV33TFPacienteNombres = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPacienteNombres", AV33TFPacienteNombres);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV34TFPacienteNombres_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPacienteNombres_Sel", AV34TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO") == 0 )
         {
            AV35TFPacienteNombreCompleto = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFPacienteNombreCompleto", AV35TFPacienteNombreCompleto);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO_SEL") == 0 )
         {
            AV36TFPacienteNombreCompleto_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFPacienteNombreCompleto_Sel", AV36TFPacienteNombreCompleto_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHANACIMIENTO") == 0 )
         {
            AV37TFPacienteFechaNacimiento = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPacienteFechaNacimiento", localUtil.format(AV37TFPacienteFechaNacimiento, "99/99/99"));
            AV38TFPacienteFechaNacimiento_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPacienteFechaNacimiento_To", localUtil.format(AV38TFPacienteFechaNacimiento_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETIPODOCUMENTO_SEL") == 0 )
         {
            AV42TFPacienteTipoDocumento_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFPacienteTipoDocumento_SelsJson", AV42TFPacienteTipoDocumento_SelsJson);
            AV43TFPacienteTipoDocumento_Sels.fromJSonString(AV42TFPacienteTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV44TFPacienteNroDocumento = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFPacienteNroDocumento", AV44TFPacienteNroDocumento);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV45TFPacienteNroDocumento_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPacienteNroDocumento_Sel", AV45TFPacienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION") == 0 )
         {
            AV46TFPacienteDireccion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPacienteDireccion", AV46TFPacienteDireccion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION_SEL") == 0 )
         {
            AV47TFPacienteDireccion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPacienteDireccion_Sel", AV47TFPacienteDireccion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTESEXO_SEL") == 0 )
         {
            AV50TFPacienteSexo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFPacienteSexo_SelsJson", AV50TFPacienteSexo_SelsJson);
            AV51TFPacienteSexo_Sels.fromJSonString(AV50TFPacienteSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO") == 0 )
         {
            AV52TFPacienteCorreo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFPacienteCorreo", AV52TFPacienteCorreo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO_SEL") == 0 )
         {
            AV53TFPacienteCorreo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFPacienteCorreo_Sel", AV53TFPacienteCorreo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO") == 0 )
         {
            AV54TFPacienteTelefono = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFPacienteTelefono", AV54TFPacienteTelefono);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO_SEL") == 0 )
         {
            AV55TFPacienteTelefono_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFPacienteTelefono_Sel", AV55TFPacienteTelefono_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV56TFPaisId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFPaisId), 4, 0));
            AV57TFPaisId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFPaisId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFPaisId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV58TFPaisDescripcion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFPaisDescripcion", AV58TFPaisDescripcion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV59TFPaisDescripcion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFPaisDescripcion_Sel", AV59TFPaisDescripcion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTADO_SEL") == 0 )
         {
            AV60TFPacienteEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFPacienteEstado_SelsJson", AV60TFPacienteEstado_SelsJson);
            AV61TFPacienteEstado_Sels.fromJSonString(AV60TFPacienteEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV62TFSecUserId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFSecUserId), 4, 0));
            AV63TFSecUserId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFSecUserId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV64TFUbigeoCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFUbigeoCode", AV64TFUbigeoCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV65TFUbigeoCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFUbigeoCode_Sel", AV65TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV66TFUbigeoNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFUbigeoNombre", AV66TFUbigeoNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV67TFUbigeoNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFUbigeoNombre_Sel", AV67TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTATURA") == 0 )
         {
            AV68TFPacienteEstatura = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFPacienteEstatura", GXutil.ltrimstr( AV68TFPacienteEstatura, 4, 2));
            AV69TFPacienteEstatura_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFPacienteEstatura_To", GXutil.ltrimstr( AV69TFPacienteEstatura_To, 4, 2));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEPESO") == 0 )
         {
            AV70TFPacientePeso = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFPacientePeso", GXutil.ltrimstr( AV70TFPacientePeso, 6, 2));
            AV71TFPacientePeso_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFPacientePeso_To", GXutil.ltrimstr( AV71TFPacientePeso_To, 6, 2));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO") == 0 )
         {
            AV72TFPacienteNombreAnexo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFPacienteNombreAnexo", AV72TFPacienteNombreAnexo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO_SEL") == 0 )
         {
            AV73TFPacienteNombreAnexo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFPacienteNombreAnexo_Sel", AV73TFPacienteNombreAnexo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEENTERARSE_SEL") == 0 )
         {
            AV48TFPacienteEnterarse_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFPacienteEnterarse_SelsJson", AV48TFPacienteEnterarse_SelsJson);
            AV49TFPacienteEnterarse_Sels.fromJSonString(AV48TFPacienteEnterarse_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE") == 0 )
         {
            AV90TFPacienteEspecifique = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFPacienteEspecifique", AV90TFPacienteEspecifique);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE_SEL") == 0 )
         {
            AV91TFPacienteEspecifique_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFPacienteEspecifique_Sel", AV91TFPacienteEspecifique_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHAREGISTRO") == 0 )
         {
            AV74TFPacienteFechaRegistro = localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFPacienteFechaRegistro", localUtil.ttoc( AV74TFPacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
            AV75TFPacienteFechaRegistro_To = localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFPacienteFechaRegistro_To", localUtil.ttoc( AV75TFPacienteFechaRegistro_To, 8, 5, 0, 3, "/", ":", " "));
            AV76DDO_PacienteFechaRegistroAuxDate = GXutil.resetTime(AV74TFPacienteFechaRegistro) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76DDO_PacienteFechaRegistroAuxDate", localUtil.format(AV76DDO_PacienteFechaRegistroAuxDate, "99/99/99"));
            AV77DDO_PacienteFechaRegistroAuxDateTo = GXutil.resetTime(AV75TFPacienteFechaRegistro_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77DDO_PacienteFechaRegistroAuxDateTo", localUtil.format(AV77DDO_PacienteFechaRegistroAuxDateTo, "99/99/99"));
         }
         AV140GXV1 = (int)(AV140GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFPacienteApellidoPaterno_Sel)==0), AV30TFPacienteApellidoPaterno_Sel, GXv_char8) ;
      pacienteww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFPacienteApellidoMaterno_Sel)==0), AV32TFPacienteApellidoMaterno_Sel, GXv_char7) ;
      pacienteww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFPacienteNombres_Sel)==0), AV34TFPacienteNombres_Sel, GXv_char15) ;
      pacienteww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFPacienteNombreCompleto_Sel)==0), AV36TFPacienteNombreCompleto_Sel, GXv_char17) ;
      pacienteww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV43TFPacienteTipoDocumento_Sels.size()==0), AV42TFPacienteTipoDocumento_SelsJson, GXv_char19) ;
      pacienteww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFPacienteNroDocumento_Sel)==0), AV45TFPacienteNroDocumento_Sel, GXv_char21) ;
      pacienteww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV47TFPacienteDireccion_Sel)==0), AV47TFPacienteDireccion_Sel, GXv_char23) ;
      pacienteww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV51TFPacienteSexo_Sels.size()==0), AV50TFPacienteSexo_SelsJson, GXv_char25) ;
      pacienteww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV53TFPacienteCorreo_Sel)==0), AV53TFPacienteCorreo_Sel, GXv_char27) ;
      pacienteww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV55TFPacienteTelefono_Sel)==0), AV55TFPacienteTelefono_Sel, GXv_char29) ;
      pacienteww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV59TFPaisDescripcion_Sel)==0), AV59TFPaisDescripcion_Sel, GXv_char31) ;
      pacienteww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV61TFPacienteEstado_Sels.size()==0), AV60TFPacienteEstado_SelsJson, GXv_char33) ;
      pacienteww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV65TFUbigeoCode_Sel)==0), AV65TFUbigeoCode_Sel, GXv_char35) ;
      pacienteww_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV67TFUbigeoNombre_Sel)==0), AV67TFUbigeoNombre_Sel, GXv_char37) ;
      pacienteww_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV73TFPacienteNombreAnexo_Sel)==0), AV73TFPacienteNombreAnexo_Sel, GXv_char39) ;
      pacienteww_impl.this.GXt_char38 = GXv_char39[0] ;
      GXt_char40 = "" ;
      GXv_char41[0] = GXt_char40 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV49TFPacienteEnterarse_Sels.size()==0), AV48TFPacienteEnterarse_SelsJson, GXv_char41) ;
      pacienteww_impl.this.GXt_char40 = GXv_char41[0] ;
      GXt_char42 = "" ;
      GXv_char43[0] = GXt_char42 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV91TFPacienteEspecifique_Sel)==0), AV91TFPacienteEspecifique_Sel, GXv_char43) ;
      pacienteww_impl.this.GXt_char42 = GXv_char43[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"||"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"|"+GXt_char24+"|"+GXt_char26+"|"+GXt_char28+"||"+GXt_char30+"|"+GXt_char32+"||"+GXt_char34+"|"+GXt_char36+"|||"+GXt_char38+"||"+GXt_char40+"|"+GXt_char42+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char42 = "" ;
      GXv_char43[0] = GXt_char42 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFPacienteApellidoPaterno)==0), AV29TFPacienteApellidoPaterno, GXv_char43) ;
      pacienteww_impl.this.GXt_char42 = GXv_char43[0] ;
      GXt_char40 = "" ;
      GXv_char41[0] = GXt_char40 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFPacienteApellidoMaterno)==0), AV31TFPacienteApellidoMaterno, GXv_char41) ;
      pacienteww_impl.this.GXt_char40 = GXv_char41[0] ;
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFPacienteNombres)==0), AV33TFPacienteNombres, GXv_char39) ;
      pacienteww_impl.this.GXt_char38 = GXv_char39[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFPacienteNombreCompleto)==0), AV35TFPacienteNombreCompleto, GXv_char37) ;
      pacienteww_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFPacienteNroDocumento)==0), AV44TFPacienteNroDocumento, GXv_char35) ;
      pacienteww_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV46TFPacienteDireccion)==0), AV46TFPacienteDireccion, GXv_char33) ;
      pacienteww_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFPacienteCorreo)==0), AV52TFPacienteCorreo, GXv_char31) ;
      pacienteww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV54TFPacienteTelefono)==0), AV54TFPacienteTelefono, GXv_char29) ;
      pacienteww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV58TFPaisDescripcion)==0), AV58TFPaisDescripcion, GXv_char27) ;
      pacienteww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV64TFUbigeoCode)==0), AV64TFUbigeoCode, GXv_char25) ;
      pacienteww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV66TFUbigeoNombre)==0), AV66TFUbigeoNombre, GXv_char23) ;
      pacienteww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV72TFPacienteNombreAnexo)==0), AV72TFPacienteNombreAnexo, GXv_char21) ;
      pacienteww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV90TFPacienteEspecifique)==0), AV90TFPacienteEspecifique, GXv_char19) ;
      pacienteww_impl.this.GXt_char18 = GXv_char19[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFPacienteId) ? "" : GXutil.str( AV27TFPacienteId, 8, 0))+"|"+GXt_char42+"|"+GXt_char40+"|"+GXt_char38+"|"+GXt_char36+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV37TFPacienteFechaNacimiento)) ? "" : localUtil.dtoc( AV37TFPacienteFechaNacimiento, 3, "/"))+"||"+GXt_char34+"|"+GXt_char32+"||"+GXt_char30+"|"+GXt_char28+"|"+((0==AV56TFPaisId) ? "" : GXutil.str( AV56TFPaisId, 4, 0))+"|"+GXt_char26+"||"+((0==AV62TFSecUserId) ? "" : GXutil.str( AV62TFSecUserId, 4, 0))+"|"+GXt_char24+"|"+GXt_char22+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFPacienteEstatura)==0) ? "" : GXutil.str( AV68TFPacienteEstatura, 4, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFPacientePeso)==0) ? "" : GXutil.str( AV70TFPacientePeso, 6, 2))+"|"+GXt_char20+"|||"+GXt_char18+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV74TFPacienteFechaRegistro) ? "" : localUtil.dtoc( AV76DDO_PacienteFechaRegistroAuxDate, 3, "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFPacienteId_To) ? "" : GXutil.str( AV28TFPacienteId_To, 8, 0))+"|||||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV38TFPacienteFechaNacimiento_To)) ? "" : localUtil.dtoc( AV38TFPacienteFechaNacimiento_To, 3, "/"))+"|||||||"+((0==AV57TFPaisId_To) ? "" : GXutil.str( AV57TFPaisId_To, 4, 0))+"|||"+((0==AV63TFSecUserId_To) ? "" : GXutil.str( AV63TFSecUserId_To, 4, 0))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFPacienteEstatura_To)==0) ? "" : GXutil.str( AV69TFPacienteEstatura_To, 4, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFPacientePeso_To)==0) ? "" : GXutil.str( AV71TFPacientePeso_To, 6, 2))+"|||||"+(GXutil.dateCompare(GXutil.nullDate(), AV75TFPacienteFechaRegistro_To) ? "" : localUtil.dtoc( AV77DDO_PacienteFechaRegistroAuxDateTo, 3, "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV139Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEID", !((0==AV27TFPacienteId)&&(0==AV28TFPacienteId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFPacienteId, 8, 0)), GXutil.trim( GXutil.str( AV28TFPacienteId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEAPELLIDOPATERNO", !(GXutil.strcmp("", AV29TFPacienteApellidoPaterno)==0), (short)(0), AV29TFPacienteApellidoPaterno, "", !(GXutil.strcmp("", AV30TFPacienteApellidoPaterno_Sel)==0), AV30TFPacienteApellidoPaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEAPELLIDOMATERNO", !(GXutil.strcmp("", AV31TFPacienteApellidoMaterno)==0), (short)(0), AV31TFPacienteApellidoMaterno, "", !(GXutil.strcmp("", AV32TFPacienteApellidoMaterno_Sel)==0), AV32TFPacienteApellidoMaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTENOMBRES", !(GXutil.strcmp("", AV33TFPacienteNombres)==0), (short)(0), AV33TFPacienteNombres, "", !(GXutil.strcmp("", AV34TFPacienteNombres_Sel)==0), AV34TFPacienteNombres_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTENOMBRECOMPLETO", !(GXutil.strcmp("", AV35TFPacienteNombreCompleto)==0), (short)(0), AV35TFPacienteNombreCompleto, "", !(GXutil.strcmp("", AV36TFPacienteNombreCompleto_Sel)==0), AV36TFPacienteNombreCompleto_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEFECHANACIMIENTO", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV37TFPacienteFechaNacimiento))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV38TFPacienteFechaNacimiento_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV37TFPacienteFechaNacimiento, 3, "/")), GXutil.trim( localUtil.dtoc( AV38TFPacienteFechaNacimiento_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTETIPODOCUMENTO_SEL", !(AV43TFPacienteTipoDocumento_Sels.size()==0), (short)(0), AV43TFPacienteTipoDocumento_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTENRODOCUMENTO", !(GXutil.strcmp("", AV44TFPacienteNroDocumento)==0), (short)(0), AV44TFPacienteNroDocumento, "", !(GXutil.strcmp("", AV45TFPacienteNroDocumento_Sel)==0), AV45TFPacienteNroDocumento_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEDIRECCION", !(GXutil.strcmp("", AV46TFPacienteDireccion)==0), (short)(0), AV46TFPacienteDireccion, "", !(GXutil.strcmp("", AV47TFPacienteDireccion_Sel)==0), AV47TFPacienteDireccion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTESEXO_SEL", !(AV51TFPacienteSexo_Sels.size()==0), (short)(0), AV51TFPacienteSexo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTECORREO", !(GXutil.strcmp("", AV52TFPacienteCorreo)==0), (short)(0), AV52TFPacienteCorreo, "", !(GXutil.strcmp("", AV53TFPacienteCorreo_Sel)==0), AV53TFPacienteCorreo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTETELEFONO", !(GXutil.strcmp("", AV54TFPacienteTelefono)==0), (short)(0), AV54TFPacienteTelefono, "", !(GXutil.strcmp("", AV55TFPacienteTelefono_Sel)==0), AV55TFPacienteTelefono_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPAISID", !((0==AV56TFPaisId)&&(0==AV57TFPaisId_To)), (short)(0), GXutil.trim( GXutil.str( AV56TFPaisId, 4, 0)), GXutil.trim( GXutil.str( AV57TFPaisId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPAISDESCRIPCION", !(GXutil.strcmp("", AV58TFPaisDescripcion)==0), (short)(0), AV58TFPaisDescripcion, "", !(GXutil.strcmp("", AV59TFPaisDescripcion_Sel)==0), AV59TFPaisDescripcion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEESTADO_SEL", !(AV61TFPacienteEstado_Sels.size()==0), (short)(0), AV61TFPacienteEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFSECUSERID", !((0==AV62TFSecUserId)&&(0==AV63TFSecUserId_To)), (short)(0), GXutil.trim( GXutil.str( AV62TFSecUserId, 4, 0)), GXutil.trim( GXutil.str( AV63TFSecUserId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFUBIGEOCODE", !(GXutil.strcmp("", AV64TFUbigeoCode)==0), (short)(0), AV64TFUbigeoCode, "", !(GXutil.strcmp("", AV65TFUbigeoCode_Sel)==0), AV65TFUbigeoCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFUBIGEONOMBRE", !(GXutil.strcmp("", AV66TFUbigeoNombre)==0), (short)(0), AV66TFUbigeoNombre, "", !(GXutil.strcmp("", AV67TFUbigeoNombre_Sel)==0), AV67TFUbigeoNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEESTATURA", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFPacienteEstatura)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFPacienteEstatura_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV68TFPacienteEstatura, 4, 2)), GXutil.trim( GXutil.str( AV69TFPacienteEstatura_To, 4, 2))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEPESO", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFPacientePeso)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFPacientePeso_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV70TFPacientePeso, 6, 2)), GXutil.trim( GXutil.str( AV71TFPacientePeso_To, 6, 2))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTENOMBREANEXO", !(GXutil.strcmp("", AV72TFPacienteNombreAnexo)==0), (short)(0), AV72TFPacienteNombreAnexo, "", !(GXutil.strcmp("", AV73TFPacienteNombreAnexo_Sel)==0), AV73TFPacienteNombreAnexo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEENTERARSE_SEL", !(AV49TFPacienteEnterarse_Sels.size()==0), (short)(0), AV49TFPacienteEnterarse_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEESPECIFIQUE", !(GXutil.strcmp("", AV90TFPacienteEspecifique)==0), (short)(0), AV90TFPacienteEspecifique, "", !(GXutil.strcmp("", AV91TFPacienteEspecifique_Sel)==0), AV91TFPacienteEspecifique_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      GXv_SdtWWPGridState44[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState44, "TFPACIENTEFECHAREGISTRO", !(GXutil.dateCompare(GXutil.nullDate(), AV74TFPacienteFechaRegistro)&&GXutil.dateCompare(GXutil.nullDate(), AV75TFPacienteFechaRegistro_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV74TFPacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV75TFPacienteFechaRegistro_To, 8, 5, 0, 3, "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState44[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV139Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV139Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Paciente" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_1F2( boolean wbgen )
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
         wb_table2_30_1F2( true) ;
      }
      else
      {
         wb_table2_30_1F2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_1F2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_1F2e( true) ;
      }
      else
      {
         wb_table1_25_1F2e( false) ;
      }
   }

   public void wb_table2_30_1F2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_PacienteWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_1F2e( true) ;
      }
      else
      {
         wb_table2_30_1F2e( false) ;
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
      pa1F2( ) ;
      ws1F2( ) ;
      we1F2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110332664", true, true);
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
      httpContext.AddJavascriptSource("pacienteww.js", "?20225110332664", false, true);
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
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_43_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_43_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_43_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_43_idx ;
      edtPacienteNombreCompleto_Internalname = "PACIENTENOMBRECOMPLETO_"+sGXsfl_43_idx ;
      edtPacienteFechaNacimiento_Internalname = "PACIENTEFECHANACIMIENTO_"+sGXsfl_43_idx ;
      cmbPacienteTipoDocumento.setInternalname( "PACIENTETIPODOCUMENTO_"+sGXsfl_43_idx );
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_43_idx ;
      edtPacienteDireccion_Internalname = "PACIENTEDIRECCION_"+sGXsfl_43_idx ;
      cmbPacienteSexo.setInternalname( "PACIENTESEXO_"+sGXsfl_43_idx );
      edtPacienteCorreo_Internalname = "PACIENTECORREO_"+sGXsfl_43_idx ;
      edtPacienteTelefono_Internalname = "PACIENTETELEFONO_"+sGXsfl_43_idx ;
      edtPaisId_Internalname = "PAISID_"+sGXsfl_43_idx ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION_"+sGXsfl_43_idx ;
      cmbPacienteEstado.setInternalname( "PACIENTEESTADO_"+sGXsfl_43_idx );
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_43_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_idx ;
      edtPacienteEstatura_Internalname = "PACIENTEESTATURA_"+sGXsfl_43_idx ;
      edtPacientePeso_Internalname = "PACIENTEPESO_"+sGXsfl_43_idx ;
      edtPacienteNombreAnexo_Internalname = "PACIENTENOMBREANEXO_"+sGXsfl_43_idx ;
      edtPacienteAnexos_Internalname = "PACIENTEANEXOS_"+sGXsfl_43_idx ;
      cmbPacienteEnterarse.setInternalname( "PACIENTEENTERARSE_"+sGXsfl_43_idx );
      edtPacienteEspecifique_Internalname = "PACIENTEESPECIFIQUE_"+sGXsfl_43_idx ;
      edtPacienteFechaRegistro_Internalname = "PACIENTEFECHAREGISTRO_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_43_fel_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_43_fel_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_43_fel_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_43_fel_idx ;
      edtPacienteNombreCompleto_Internalname = "PACIENTENOMBRECOMPLETO_"+sGXsfl_43_fel_idx ;
      edtPacienteFechaNacimiento_Internalname = "PACIENTEFECHANACIMIENTO_"+sGXsfl_43_fel_idx ;
      cmbPacienteTipoDocumento.setInternalname( "PACIENTETIPODOCUMENTO_"+sGXsfl_43_fel_idx );
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_43_fel_idx ;
      edtPacienteDireccion_Internalname = "PACIENTEDIRECCION_"+sGXsfl_43_fel_idx ;
      cmbPacienteSexo.setInternalname( "PACIENTESEXO_"+sGXsfl_43_fel_idx );
      edtPacienteCorreo_Internalname = "PACIENTECORREO_"+sGXsfl_43_fel_idx ;
      edtPacienteTelefono_Internalname = "PACIENTETELEFONO_"+sGXsfl_43_fel_idx ;
      edtPaisId_Internalname = "PAISID_"+sGXsfl_43_fel_idx ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION_"+sGXsfl_43_fel_idx ;
      cmbPacienteEstado.setInternalname( "PACIENTEESTADO_"+sGXsfl_43_fel_idx );
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_43_fel_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_fel_idx ;
      edtPacienteEstatura_Internalname = "PACIENTEESTATURA_"+sGXsfl_43_fel_idx ;
      edtPacientePeso_Internalname = "PACIENTEPESO_"+sGXsfl_43_fel_idx ;
      edtPacienteNombreAnexo_Internalname = "PACIENTENOMBREANEXO_"+sGXsfl_43_fel_idx ;
      edtPacienteAnexos_Internalname = "PACIENTEANEXOS_"+sGXsfl_43_fel_idx ;
      cmbPacienteEnterarse.setInternalname( "PACIENTEENTERARSE_"+sGXsfl_43_fel_idx );
      edtPacienteEspecifique_Internalname = "PACIENTEESPECIFIQUE_"+sGXsfl_43_fel_idx ;
      edtPacienteFechaRegistro_Internalname = "PACIENTEFECHAREGISTRO_"+sGXsfl_43_fel_idx ;
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb1F0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombres_Internalname,A105PacienteNombres,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPacienteNombres_Link,"","","",edtPacienteNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPacienteNombres_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteNombreCompleto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombreCompleto_Internalname,A212PacienteNombreCompleto,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNombreCompleto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteNombreCompleto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPacienteFechaNacimiento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteFechaNacimiento_Internalname,localUtil.format(A213PacienteFechaNacimiento, "99/99/99"),localUtil.format( A213PacienteFechaNacimiento, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteFechaNacimiento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteFechaNacimiento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPacienteTipoDocumento.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPacienteTipoDocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTETIPODOCUMENTO_" + sGXsfl_43_idx ;
            cmbPacienteTipoDocumento.setName( GXCCtl );
            cmbPacienteTipoDocumento.setWebtags( "" );
            cmbPacienteTipoDocumento.addItem("1", "DNI", (short)(0));
            cmbPacienteTipoDocumento.addItem("6", "RUC", (short)(0));
            cmbPacienteTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
            cmbPacienteTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
            cmbPacienteTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
            cmbPacienteTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
            if ( cmbPacienteTipoDocumento.getItemCount() > 0 )
            {
               A214PacienteTipoDocumento = cmbPacienteTipoDocumento.getValidValue(A214PacienteTipoDocumento) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteTipoDocumento,cmbPacienteTipoDocumento.getInternalname(),GXutil.rtrim( A214PacienteTipoDocumento),Integer.valueOf(1),cmbPacienteTipoDocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPacienteTipoDocumento.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteTipoDocumento.setValue( GXutil.rtrim( A214PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteTipoDocumento.getInternalname(), "Values", cmbPacienteTipoDocumento.ToJavascriptSource(), !bGXsfl_43_Refreshing);
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteDireccion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteDireccion_Internalname,A215PacienteDireccion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteDireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteDireccion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPacienteSexo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPacienteSexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTESEXO_" + sGXsfl_43_idx ;
            cmbPacienteSexo.setName( GXCCtl );
            cmbPacienteSexo.setWebtags( "" );
            cmbPacienteSexo.addItem("M", "Masculino", (short)(0));
            cmbPacienteSexo.addItem("F", "Femenino", (short)(0));
            if ( cmbPacienteSexo.getItemCount() > 0 )
            {
               A216PacienteSexo = cmbPacienteSexo.getValidValue(A216PacienteSexo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteSexo,cmbPacienteSexo.getInternalname(),GXutil.rtrim( A216PacienteSexo),Integer.valueOf(1),cmbPacienteSexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPacienteSexo.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteSexo.setValue( GXutil.rtrim( A216PacienteSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteSexo.getInternalname(), "Values", cmbPacienteSexo.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteCorreo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteCorreo_Internalname,A217PacienteCorreo,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A217PacienteCorreo,"","","",edtPacienteCorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteCorreo_Visible),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteTelefono_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         if ( httpContext.isSmartDevice( ) )
         {
            gxphoneLink = "tel:" + GXutil.rtrim( A218PacienteTelefono) ;
         }
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteTelefono_Internalname,GXutil.rtrim( A218PacienteTelefono),"","","'"+""+"'"+",false,"+"'"+""+"'",gxphoneLink,"","","",edtPacienteTelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteTelefono_Visible),Integer.valueOf(0),Integer.valueOf(0),"tel","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Phone","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPaisId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaisId_Internalname,GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaisId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPaisId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPaisDescripcion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaisDescripcion_Internalname,A184PaisDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPaisDescripcion_Link,"","","",edtPaisDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPaisDescripcion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPacienteEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPacienteEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTEESTADO_" + sGXsfl_43_idx ;
            cmbPacienteEstado.setName( GXCCtl );
            cmbPacienteEstado.setWebtags( "" );
            cmbPacienteEstado.addItem("A", "Activo", (short)(0));
            cmbPacienteEstado.addItem("P", "Pendiente", (short)(0));
            cmbPacienteEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbPacienteEstado.getItemCount() > 0 )
            {
               A219PacienteEstado = cmbPacienteEstado.getValidValue(A219PacienteEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteEstado,cmbPacienteEstado.getInternalname(),GXutil.rtrim( A219PacienteEstado),Integer.valueOf(1),cmbPacienteEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPacienteEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteEstado.setValue( GXutil.rtrim( A219PacienteEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEstado.getInternalname(), "Values", cmbPacienteEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoCode_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoCode_Internalname,GXutil.rtrim( A44UbigeoCode),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoCode_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtUbigeoNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoNombre_Internalname,A185UbigeoNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtUbigeoNombre_Link,"","","",edtUbigeoNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtUbigeoNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPacienteEstatura_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteEstatura_Internalname,GXutil.ltrim( localUtil.ntoc( A220PacienteEstatura, (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A220PacienteEstatura, "9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteEstatura_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteEstatura_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPacientePeso_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacientePeso_Internalname,GXutil.ltrim( localUtil.ntoc( A221PacientePeso, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A221PacientePeso, "ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacientePeso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacientePeso_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteNombreAnexo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombreAnexo_Internalname,A222PacienteNombreAnexo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNombreAnexo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteNombreAnexo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteAnexos_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         ClassString = "Image" ;
         StyleString = "" ;
         edtPacienteAnexos_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, !bGXsfl_43_Refreshing);
         if ( ! (GXutil.strcmp("", A223PacienteAnexos)==0) )
         {
            gxblobfileaux.setSource( A223PacienteAnexos );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtPacienteAnexos_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtPacienteAnexos_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A223PacienteAnexos = gxblobfileaux.getURI() ;
               n223PacienteAnexos = false ;
               httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_43_Refreshing);
               edtPacienteAnexos_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, !bGXsfl_43_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_43_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtPacienteAnexos_Internalname,GXutil.rtrim( A223PacienteAnexos),httpContext.getResourceRelative(A223PacienteAnexos),((GXutil.strcmp("", edtPacienteAnexos_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtPacienteAnexos_Filetype)==0) ? A223PacienteAnexos : edtPacienteAnexos_Filetype)) : edtPacienteAnexos_Contenttype),Boolean.valueOf(false),"",edtPacienteAnexos_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(edtPacienteAnexos_Visible),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtPacienteAnexos_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPacienteEnterarse.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPacienteEnterarse.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTEENTERARSE_" + sGXsfl_43_idx ;
            cmbPacienteEnterarse.setName( GXCCtl );
            cmbPacienteEnterarse.setWebtags( "" );
            cmbPacienteEnterarse.addItem("F", "Facebook", (short)(0));
            cmbPacienteEnterarse.addItem("G", "Búsqueda en Google", (short)(0));
            cmbPacienteEnterarse.addItem("T", "Twitter", (short)(0));
            cmbPacienteEnterarse.addItem("I", "Instagram", (short)(0));
            cmbPacienteEnterarse.addItem("L", "Linked In", (short)(0));
            cmbPacienteEnterarse.addItem("C", "Mediante conocido o familiar", (short)(0));
            cmbPacienteEnterarse.addItem("O", "Otros", (short)(0));
            if ( cmbPacienteEnterarse.getItemCount() > 0 )
            {
               A224PacienteEnterarse = cmbPacienteEnterarse.getValidValue(A224PacienteEnterarse) ;
               n224PacienteEnterarse = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteEnterarse,cmbPacienteEnterarse.getInternalname(),GXutil.rtrim( A224PacienteEnterarse),Integer.valueOf(1),cmbPacienteEnterarse.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","svchar","",Integer.valueOf(cmbPacienteEnterarse.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteEnterarse.setValue( GXutil.rtrim( A224PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEnterarse.getInternalname(), "Values", cmbPacienteEnterarse.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPacienteEspecifique_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteEspecifique_Internalname,A225PacienteEspecifique,A225PacienteEspecifique,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteEspecifique_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteEspecifique_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPacienteFechaRegistro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteFechaRegistro_Internalname,localUtil.ttoc( A226PacienteFechaRegistro, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A226PacienteFechaRegistro, "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteFechaRegistro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPacienteFechaRegistro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes1F2( ) ;
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
      edtPacienteId_Internalname = "PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtPacienteNombreCompleto_Internalname = "PACIENTENOMBRECOMPLETO" ;
      edtPacienteFechaNacimiento_Internalname = "PACIENTEFECHANACIMIENTO" ;
      cmbPacienteTipoDocumento.setInternalname( "PACIENTETIPODOCUMENTO" );
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO" ;
      edtPacienteDireccion_Internalname = "PACIENTEDIRECCION" ;
      cmbPacienteSexo.setInternalname( "PACIENTESEXO" );
      edtPacienteCorreo_Internalname = "PACIENTECORREO" ;
      edtPacienteTelefono_Internalname = "PACIENTETELEFONO" ;
      edtPaisId_Internalname = "PAISID" ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION" ;
      cmbPacienteEstado.setInternalname( "PACIENTEESTADO" );
      edtSecUserId_Internalname = "SECUSERID" ;
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      edtPacienteEstatura_Internalname = "PACIENTEESTATURA" ;
      edtPacientePeso_Internalname = "PACIENTEPESO" ;
      edtPacienteNombreAnexo_Internalname = "PACIENTENOMBREANEXO" ;
      edtPacienteAnexos_Internalname = "PACIENTEANEXOS" ;
      cmbPacienteEnterarse.setInternalname( "PACIENTEENTERARSE" );
      edtPacienteEspecifique_Internalname = "PACIENTEESPECIFIQUE" ;
      edtPacienteFechaRegistro_Internalname = "PACIENTEFECHAREGISTRO" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_pacientefechanacimientoauxdatetext_Internalname = "vDDO_PACIENTEFECHANACIMIENTOAUXDATETEXT" ;
      Tfpacientefechanacimiento_rangepicker_Internalname = "TFPACIENTEFECHANACIMIENTO_RANGEPICKER" ;
      divDdo_pacientefechanacimientoauxdates_Internalname = "DDO_PACIENTEFECHANACIMIENTOAUXDATES" ;
      edtavDdo_pacientefecharegistroauxdatetext_Internalname = "vDDO_PACIENTEFECHAREGISTROAUXDATETEXT" ;
      Tfpacientefecharegistro_rangepicker_Internalname = "TFPACIENTEFECHAREGISTRO_RANGEPICKER" ;
      divDdo_pacientefecharegistroauxdates_Internalname = "DDO_PACIENTEFECHAREGISTROAUXDATES" ;
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
      edtPacienteFechaRegistro_Jsonclick = "" ;
      edtPacienteEspecifique_Jsonclick = "" ;
      cmbPacienteEnterarse.setJsonclick( "" );
      edtPacienteAnexos_Jsonclick = "" ;
      edtPacienteAnexos_Parameters = "" ;
      edtPacienteAnexos_Contenttype = "" ;
      edtPacienteAnexos_Filetype = "" ;
      edtPacienteNombreAnexo_Jsonclick = "" ;
      edtPacientePeso_Jsonclick = "" ;
      edtPacienteEstatura_Jsonclick = "" ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoCode_Jsonclick = "" ;
      edtSecUserId_Jsonclick = "" ;
      cmbPacienteEstado.setJsonclick( "" );
      edtPaisDescripcion_Jsonclick = "" ;
      edtPaisId_Jsonclick = "" ;
      edtPacienteTelefono_Jsonclick = "" ;
      edtPacienteCorreo_Jsonclick = "" ;
      cmbPacienteSexo.setJsonclick( "" );
      edtPacienteDireccion_Jsonclick = "" ;
      edtPacienteNroDocumento_Jsonclick = "" ;
      cmbPacienteTipoDocumento.setJsonclick( "" );
      edtPacienteFechaNacimiento_Jsonclick = "" ;
      edtPacienteNombreCompleto_Jsonclick = "" ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_pacientefecharegistroauxdatetext_Jsonclick = "" ;
      edtavDdo_pacientefechanacimientoauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtUbigeoNombre_Link = "" ;
      edtPaisDescripcion_Link = "" ;
      edtPacienteNombres_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtPacienteFechaRegistro_Visible = -1 ;
      edtPacienteEspecifique_Visible = -1 ;
      cmbPacienteEnterarse.setVisible( -1 );
      edtPacienteAnexos_Visible = -1 ;
      edtPacienteNombreAnexo_Visible = -1 ;
      edtPacientePeso_Visible = -1 ;
      edtPacienteEstatura_Visible = -1 ;
      edtUbigeoNombre_Visible = -1 ;
      edtUbigeoCode_Visible = -1 ;
      edtSecUserId_Visible = -1 ;
      cmbPacienteEstado.setVisible( -1 );
      edtPaisDescripcion_Visible = -1 ;
      edtPaisId_Visible = -1 ;
      edtPacienteTelefono_Visible = -1 ;
      edtPacienteCorreo_Visible = -1 ;
      cmbPacienteSexo.setVisible( -1 );
      edtPacienteDireccion_Visible = -1 ;
      edtPacienteNroDocumento_Visible = -1 ;
      cmbPacienteTipoDocumento.setVisible( -1 );
      edtPacienteFechaNacimiento_Visible = -1 ;
      edtPacienteNombreCompleto_Visible = -1 ;
      edtPacienteNombres_Visible = -1 ;
      edtPacienteApellidoMaterno_Visible = -1 ;
      edtPacienteApellidoPaterno_Visible = -1 ;
      edtPacienteId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Paciente" );
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
      Ddo_grid_Datalistproc = "PacienteWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||1:DNI,6:RUC,2:LIBRETA ELECTORAL,4:CARNET DE EXTRANJERIA,7:PASAPORTE,0:SIN DOCUMENTO|||M:Masculino,F:Femenino|||||A:Activo,P:Pendiente,I:Inactivo||||||||F:Facebook,G:Búsqueda en Google,T:Twitter,I:Instagram,L:Linked In,C:Mediante conocido o familiar,O:Otros||" ;
      Ddo_grid_Allowmultipleselection = "||||||T|||T|||||T||||||||T||" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|Dynamic|Dynamic||FixedValues|Dynamic|Dynamic|FixedValues|Dynamic|Dynamic||Dynamic|FixedValues||Dynamic|Dynamic|||Dynamic||FixedValues|Dynamic|" ;
      Ddo_grid_Includedatalist = "|T|T|T|T||T|T|T|T|T|T||T|T||T|T|||T||T|T|" ;
      Ddo_grid_Filterisrange = "T|||||P|||||||T|||T|||T|T|||||P" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Character|Character|Date||Character|Character||Character|Character|Numeric|Character||Numeric|Character|Character|Numeric|Numeric|Character|||Character|Date" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T||T|T||T|T|T|T||T|T|T|T|T|T|||T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T||T|T|T|T|T|T|T|T|T|T|T|T||T|T|T||T|T|T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|1||5|6|7|8|9|10|11|12|13|14|15|16||17|18|19||20|21|22" ;
      Ddo_grid_Columnids = "2:PacienteId|3:PacienteApellidoPaterno|4:PacienteApellidoMaterno|5:PacienteNombres|6:PacienteNombreCompleto|7:PacienteFechaNacimiento|8:PacienteTipoDocumento|9:PacienteNroDocumento|10:PacienteDireccion|11:PacienteSexo|12:PacienteCorreo|13:PacienteTelefono|14:PaisId|15:PaisDescripcion|16:PacienteEstado|17:SecUserId|18:UbigeoCode|19:UbigeoNombre|20:PacienteEstatura|21:PacientePeso|22:PacienteNombreAnexo|23:PacienteAnexos|24:PacienteEnterarse|25:PacienteEspecifique|26:PacienteFechaRegistro" ;
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
      GXCCtl = "PACIENTETIPODOCUMENTO_" + sGXsfl_43_idx ;
      cmbPacienteTipoDocumento.setName( GXCCtl );
      cmbPacienteTipoDocumento.setWebtags( "" );
      cmbPacienteTipoDocumento.addItem("1", "DNI", (short)(0));
      cmbPacienteTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbPacienteTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbPacienteTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbPacienteTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbPacienteTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbPacienteTipoDocumento.getItemCount() > 0 )
      {
         A214PacienteTipoDocumento = cmbPacienteTipoDocumento.getValidValue(A214PacienteTipoDocumento) ;
      }
      GXCCtl = "PACIENTESEXO_" + sGXsfl_43_idx ;
      cmbPacienteSexo.setName( GXCCtl );
      cmbPacienteSexo.setWebtags( "" );
      cmbPacienteSexo.addItem("M", "Masculino", (short)(0));
      cmbPacienteSexo.addItem("F", "Femenino", (short)(0));
      if ( cmbPacienteSexo.getItemCount() > 0 )
      {
         A216PacienteSexo = cmbPacienteSexo.getValidValue(A216PacienteSexo) ;
      }
      GXCCtl = "PACIENTEESTADO_" + sGXsfl_43_idx ;
      cmbPacienteEstado.setName( GXCCtl );
      cmbPacienteEstado.setWebtags( "" );
      cmbPacienteEstado.addItem("A", "Activo", (short)(0));
      cmbPacienteEstado.addItem("P", "Pendiente", (short)(0));
      cmbPacienteEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbPacienteEstado.getItemCount() > 0 )
      {
         A219PacienteEstado = cmbPacienteEstado.getValidValue(A219PacienteEstado) ;
      }
      GXCCtl = "PACIENTEENTERARSE_" + sGXsfl_43_idx ;
      cmbPacienteEnterarse.setName( GXCCtl );
      cmbPacienteEnterarse.setWebtags( "" );
      cmbPacienteEnterarse.addItem("F", "Facebook", (short)(0));
      cmbPacienteEnterarse.addItem("G", "Búsqueda en Google", (short)(0));
      cmbPacienteEnterarse.addItem("T", "Twitter", (short)(0));
      cmbPacienteEnterarse.addItem("I", "Instagram", (short)(0));
      cmbPacienteEnterarse.addItem("L", "Linked In", (short)(0));
      cmbPacienteEnterarse.addItem("C", "Mediante conocido o familiar", (short)(0));
      cmbPacienteEnterarse.addItem("O", "Otros", (short)(0));
      if ( cmbPacienteEnterarse.getItemCount() > 0 )
      {
         A224PacienteEnterarse = cmbPacienteEnterarse.getValidValue(A224PacienteEnterarse) ;
         n224PacienteEnterarse = false ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtPacienteNombreCompleto_Visible',ctrl:'PACIENTENOMBRECOMPLETO',prop:'Visible'},{av:'edtPacienteFechaNacimiento_Visible',ctrl:'PACIENTEFECHANACIMIENTO',prop:'Visible'},{av:'cmbPacienteTipoDocumento'},{av:'edtPacienteNroDocumento_Visible',ctrl:'PACIENTENRODOCUMENTO',prop:'Visible'},{av:'edtPacienteDireccion_Visible',ctrl:'PACIENTEDIRECCION',prop:'Visible'},{av:'cmbPacienteSexo'},{av:'edtPacienteCorreo_Visible',ctrl:'PACIENTECORREO',prop:'Visible'},{av:'edtPacienteTelefono_Visible',ctrl:'PACIENTETELEFONO',prop:'Visible'},{av:'edtPaisId_Visible',ctrl:'PAISID',prop:'Visible'},{av:'edtPaisDescripcion_Visible',ctrl:'PAISDESCRIPCION',prop:'Visible'},{av:'cmbPacienteEstado'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtPacienteEstatura_Visible',ctrl:'PACIENTEESTATURA',prop:'Visible'},{av:'edtPacientePeso_Visible',ctrl:'PACIENTEPESO',prop:'Visible'},{av:'edtPacienteNombreAnexo_Visible',ctrl:'PACIENTENOMBREANEXO',prop:'Visible'},{av:'edtPacienteAnexos_Visible',ctrl:'PACIENTEANEXOS',prop:'Visible'},{av:'cmbPacienteEnterarse'},{av:'edtPacienteEspecifique_Visible',ctrl:'PACIENTEESPECIFIQUE',prop:'Visible'},{av:'edtPacienteFechaRegistro_Visible',ctrl:'PACIENTEFECHAREGISTRO',prop:'Visible'},{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121F2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131F2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141F2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e211F2',iparms:[{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'A43PaisId',fld:'PAISID',pic:'ZZZ9'},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV83Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV85Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtPacienteNombres_Link',ctrl:'PACIENTENOMBRES',prop:'Link'},{av:'edtPaisDescripcion_Link',ctrl:'PAISDESCRIPCION',prop:'Link'},{av:'edtUbigeoNombre_Link',ctrl:'UBIGEONOMBRE',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e151F2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtPacienteNombreCompleto_Visible',ctrl:'PACIENTENOMBRECOMPLETO',prop:'Visible'},{av:'edtPacienteFechaNacimiento_Visible',ctrl:'PACIENTEFECHANACIMIENTO',prop:'Visible'},{av:'cmbPacienteTipoDocumento'},{av:'edtPacienteNroDocumento_Visible',ctrl:'PACIENTENRODOCUMENTO',prop:'Visible'},{av:'edtPacienteDireccion_Visible',ctrl:'PACIENTEDIRECCION',prop:'Visible'},{av:'cmbPacienteSexo'},{av:'edtPacienteCorreo_Visible',ctrl:'PACIENTECORREO',prop:'Visible'},{av:'edtPacienteTelefono_Visible',ctrl:'PACIENTETELEFONO',prop:'Visible'},{av:'edtPaisId_Visible',ctrl:'PAISID',prop:'Visible'},{av:'edtPaisDescripcion_Visible',ctrl:'PAISDESCRIPCION',prop:'Visible'},{av:'cmbPacienteEstado'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtPacienteEstatura_Visible',ctrl:'PACIENTEESTATURA',prop:'Visible'},{av:'edtPacientePeso_Visible',ctrl:'PACIENTEPESO',prop:'Visible'},{av:'edtPacienteNombreAnexo_Visible',ctrl:'PACIENTENOMBREANEXO',prop:'Visible'},{av:'edtPacienteAnexos_Visible',ctrl:'PACIENTEANEXOS',prop:'Visible'},{av:'cmbPacienteEnterarse'},{av:'edtPacienteEspecifique_Visible',ctrl:'PACIENTEESPECIFIQUE',prop:'Visible'},{av:'edtPacienteFechaRegistro_Visible',ctrl:'PACIENTEFECHAREGISTRO',prop:'Visible'},{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111F2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV76DDO_PacienteFechaRegistroAuxDate',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATE',pic:''},{av:'AV77DDO_PacienteFechaRegistroAuxDateTo',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATETO',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV76DDO_PacienteFechaRegistroAuxDate',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATE',pic:''},{av:'AV77DDO_PacienteFechaRegistroAuxDateTo',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATETO',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPacienteId_Visible',ctrl:'PACIENTEID',prop:'Visible'},{av:'edtPacienteApellidoPaterno_Visible',ctrl:'PACIENTEAPELLIDOPATERNO',prop:'Visible'},{av:'edtPacienteApellidoMaterno_Visible',ctrl:'PACIENTEAPELLIDOMATERNO',prop:'Visible'},{av:'edtPacienteNombres_Visible',ctrl:'PACIENTENOMBRES',prop:'Visible'},{av:'edtPacienteNombreCompleto_Visible',ctrl:'PACIENTENOMBRECOMPLETO',prop:'Visible'},{av:'edtPacienteFechaNacimiento_Visible',ctrl:'PACIENTEFECHANACIMIENTO',prop:'Visible'},{av:'cmbPacienteTipoDocumento'},{av:'edtPacienteNroDocumento_Visible',ctrl:'PACIENTENRODOCUMENTO',prop:'Visible'},{av:'edtPacienteDireccion_Visible',ctrl:'PACIENTEDIRECCION',prop:'Visible'},{av:'cmbPacienteSexo'},{av:'edtPacienteCorreo_Visible',ctrl:'PACIENTECORREO',prop:'Visible'},{av:'edtPacienteTelefono_Visible',ctrl:'PACIENTETELEFONO',prop:'Visible'},{av:'edtPaisId_Visible',ctrl:'PAISID',prop:'Visible'},{av:'edtPaisDescripcion_Visible',ctrl:'PAISDESCRIPCION',prop:'Visible'},{av:'cmbPacienteEstado'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtPacienteEstatura_Visible',ctrl:'PACIENTEESTATURA',prop:'Visible'},{av:'edtPacientePeso_Visible',ctrl:'PACIENTEPESO',prop:'Visible'},{av:'edtPacienteNombreAnexo_Visible',ctrl:'PACIENTENOMBREANEXO',prop:'Visible'},{av:'edtPacienteAnexos_Visible',ctrl:'PACIENTEANEXOS',prop:'Visible'},{av:'cmbPacienteEnterarse'},{av:'edtPacienteEspecifique_Visible',ctrl:'PACIENTEESPECIFIQUE',prop:'Visible'},{av:'edtPacienteFechaRegistro_Visible',ctrl:'PACIENTEFECHAREGISTRO',prop:'Visible'},{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e161F2',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e171F2',iparms:[{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV76DDO_PacienteFechaRegistroAuxDate',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATE',pic:''},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV77DDO_PacienteFechaRegistroAuxDateTo',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATETO',pic:''}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV76DDO_PacienteFechaRegistroAuxDate',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATE',pic:''},{av:'AV77DDO_PacienteFechaRegistroAuxDateTo',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATETO',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e181F2',iparms:[{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV76DDO_PacienteFechaRegistroAuxDate',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATE',pic:''},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV77DDO_PacienteFechaRegistroAuxDateTo',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATETO',pic:''}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV74TFPacienteFechaRegistro',fld:'vTFPACIENTEFECHAREGISTRO',pic:'99/99/99 99:99'},{av:'AV75TFPacienteFechaRegistro_To',fld:'vTFPACIENTEFECHAREGISTRO_TO',pic:'99/99/99 99:99'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPacienteId',fld:'vTFPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV28TFPacienteId_To',fld:'vTFPACIENTEID_TO',pic:'ZZZZZZZ9'},{av:'AV29TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV30TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV32TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV34TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV35TFPacienteNombreCompleto',fld:'vTFPACIENTENOMBRECOMPLETO',pic:''},{av:'AV36TFPacienteNombreCompleto_Sel',fld:'vTFPACIENTENOMBRECOMPLETO_SEL',pic:''},{av:'AV37TFPacienteFechaNacimiento',fld:'vTFPACIENTEFECHANACIMIENTO',pic:''},{av:'AV38TFPacienteFechaNacimiento_To',fld:'vTFPACIENTEFECHANACIMIENTO_TO',pic:''},{av:'AV43TFPacienteTipoDocumento_Sels',fld:'vTFPACIENTETIPODOCUMENTO_SELS',pic:''},{av:'AV44TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV45TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV46TFPacienteDireccion',fld:'vTFPACIENTEDIRECCION',pic:''},{av:'AV47TFPacienteDireccion_Sel',fld:'vTFPACIENTEDIRECCION_SEL',pic:''},{av:'AV51TFPacienteSexo_Sels',fld:'vTFPACIENTESEXO_SELS',pic:''},{av:'AV52TFPacienteCorreo',fld:'vTFPACIENTECORREO',pic:''},{av:'AV53TFPacienteCorreo_Sel',fld:'vTFPACIENTECORREO_SEL',pic:''},{av:'AV54TFPacienteTelefono',fld:'vTFPACIENTETELEFONO',pic:''},{av:'AV55TFPacienteTelefono_Sel',fld:'vTFPACIENTETELEFONO_SEL',pic:''},{av:'AV56TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV57TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV58TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV59TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV61TFPacienteEstado_Sels',fld:'vTFPACIENTEESTADO_SELS',pic:''},{av:'AV62TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV63TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV64TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV65TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV66TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV67TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV68TFPacienteEstatura',fld:'vTFPACIENTEESTATURA',pic:'9.99'},{av:'AV69TFPacienteEstatura_To',fld:'vTFPACIENTEESTATURA_TO',pic:'9.99'},{av:'AV70TFPacientePeso',fld:'vTFPACIENTEPESO',pic:'ZZ9.99'},{av:'AV71TFPacientePeso_To',fld:'vTFPACIENTEPESO_TO',pic:'ZZ9.99'},{av:'AV72TFPacienteNombreAnexo',fld:'vTFPACIENTENOMBREANEXO',pic:''},{av:'AV73TFPacienteNombreAnexo_Sel',fld:'vTFPACIENTENOMBREANEXO_SEL',pic:''},{av:'AV49TFPacienteEnterarse_Sels',fld:'vTFPACIENTEENTERARSE_SELS',pic:''},{av:'AV90TFPacienteEspecifique',fld:'vTFPACIENTEESPECIFIQUE',pic:''},{av:'AV91TFPacienteEspecifique_Sel',fld:'vTFPACIENTEESPECIFIQUE_SEL',pic:''},{av:'AV139Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV86IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV87IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV88IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV76DDO_PacienteFechaRegistroAuxDate',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATE',pic:''},{av:'AV77DDO_PacienteFechaRegistroAuxDateTo',fld:'vDDO_PACIENTEFECHAREGISTROAUXDATETO',pic:''},{av:'AV48TFPacienteEnterarse_SelsJson',fld:'vTFPACIENTEENTERARSE_SELSJSON',pic:''},{av:'AV60TFPacienteEstado_SelsJson',fld:'vTFPACIENTEESTADO_SELSJSON',pic:''},{av:'AV50TFPacienteSexo_SelsJson',fld:'vTFPACIENTESEXO_SELSJSON',pic:''},{av:'AV42TFPacienteTipoDocumento_SelsJson',fld:'vTFPACIENTETIPODOCUMENTO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_PACIENTEAPELLIDOPATERNO","{handler:'valid_Pacienteapellidopaterno',iparms:[]");
      setEventMetadata("VALID_PACIENTEAPELLIDOPATERNO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEAPELLIDOMATERNO","{handler:'valid_Pacienteapellidomaterno',iparms:[]");
      setEventMetadata("VALID_PACIENTEAPELLIDOMATERNO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTENOMBRES","{handler:'valid_Pacientenombres',iparms:[]");
      setEventMetadata("VALID_PACIENTENOMBRES",",oparms:[]}");
      setEventMetadata("VALID_PAISID","{handler:'valid_Paisid',iparms:[]");
      setEventMetadata("VALID_PAISID",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Pacientefecharegistro',iparms:[]");
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
      AV74TFPacienteFechaRegistro = GXutil.now( ) ;
      AV75TFPacienteFechaRegistro_To = GXutil.now( ) ;
      AV21ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV29TFPacienteApellidoPaterno = "" ;
      AV30TFPacienteApellidoPaterno_Sel = "" ;
      AV31TFPacienteApellidoMaterno = "" ;
      AV32TFPacienteApellidoMaterno_Sel = "" ;
      AV33TFPacienteNombres = "" ;
      AV34TFPacienteNombres_Sel = "" ;
      AV35TFPacienteNombreCompleto = "" ;
      AV36TFPacienteNombreCompleto_Sel = "" ;
      AV37TFPacienteFechaNacimiento = GXutil.nullDate() ;
      AV38TFPacienteFechaNacimiento_To = GXutil.nullDate() ;
      AV43TFPacienteTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFPacienteNroDocumento = "" ;
      AV45TFPacienteNroDocumento_Sel = "" ;
      AV46TFPacienteDireccion = "" ;
      AV47TFPacienteDireccion_Sel = "" ;
      AV51TFPacienteSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFPacienteCorreo = "" ;
      AV53TFPacienteCorreo_Sel = "" ;
      AV54TFPacienteTelefono = "" ;
      AV55TFPacienteTelefono_Sel = "" ;
      AV58TFPaisDescripcion = "" ;
      AV59TFPaisDescripcion_Sel = "" ;
      AV61TFPacienteEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFUbigeoCode = "" ;
      AV65TFUbigeoCode_Sel = "" ;
      AV66TFUbigeoNombre = "" ;
      AV67TFUbigeoNombre_Sel = "" ;
      AV68TFPacienteEstatura = DecimalUtil.ZERO ;
      AV69TFPacienteEstatura_To = DecimalUtil.ZERO ;
      AV70TFPacientePeso = DecimalUtil.ZERO ;
      AV71TFPacientePeso_To = DecimalUtil.ZERO ;
      AV72TFPacienteNombreAnexo = "" ;
      AV73TFPacienteNombreAnexo_Sel = "" ;
      AV49TFPacienteEnterarse_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90TFPacienteEspecifique = "" ;
      AV91TFPacienteEspecifique_Sel = "" ;
      AV139Pgmname = "" ;
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
      AV40DDO_PacienteFechaNacimientoAuxDateTo = GXutil.nullDate() ;
      AV77DDO_PacienteFechaRegistroAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV42TFPacienteTipoDocumento_SelsJson = "" ;
      AV50TFPacienteSexo_SelsJson = "" ;
      AV60TFPacienteEstado_SelsJson = "" ;
      AV48TFPacienteEnterarse_SelsJson = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      AV39DDO_PacienteFechaNacimientoAuxDate = GXutil.nullDate() ;
      AV76DDO_PacienteFechaRegistroAuxDate = GXutil.nullDate() ;
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
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A212PacienteNombreCompleto = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A216PacienteSexo = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      A184PaisDescripcion = "" ;
      A219PacienteEstado = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      A223PacienteAnexos = "" ;
      A224PacienteEnterarse = "" ;
      A225PacienteEspecifique = "" ;
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV41DDO_PacienteFechaNacimientoAuxDateText = "" ;
      ucTfpacientefechanacimiento_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV78DDO_PacienteFechaRegistroAuxDateText = "" ;
      ucTfpacientefecharegistro_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV107Pacientewwds_14_tfpacientetipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV112Pacientewwds_19_tfpacientesexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV121Pacientewwds_28_tfpacienteestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV134Pacientewwds_41_tfpacienteenterarse_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV94Pacientewwds_1_filterfulltext = "" ;
      lV97Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      lV99Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      lV101Pacientewwds_8_tfpacientenombres = "" ;
      lV103Pacientewwds_10_tfpacientenombrecompleto = "" ;
      lV108Pacientewwds_15_tfpacientenrodocumento = "" ;
      lV110Pacientewwds_17_tfpacientedireccion = "" ;
      lV113Pacientewwds_20_tfpacientecorreo = "" ;
      lV115Pacientewwds_22_tfpacientetelefono = "" ;
      lV119Pacientewwds_26_tfpaisdescripcion = "" ;
      lV124Pacientewwds_31_tfubigeocode = "" ;
      lV126Pacientewwds_33_tfubigeonombre = "" ;
      lV132Pacientewwds_39_tfpacientenombreanexo = "" ;
      lV135Pacientewwds_42_tfpacienteespecifique = "" ;
      AV94Pacientewwds_1_filterfulltext = "" ;
      AV98Pacientewwds_5_tfpacienteapellidopaterno_sel = "" ;
      AV97Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      AV100Pacientewwds_7_tfpacienteapellidomaterno_sel = "" ;
      AV99Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      AV102Pacientewwds_9_tfpacientenombres_sel = "" ;
      AV101Pacientewwds_8_tfpacientenombres = "" ;
      AV104Pacientewwds_11_tfpacientenombrecompleto_sel = "" ;
      AV103Pacientewwds_10_tfpacientenombrecompleto = "" ;
      AV105Pacientewwds_12_tfpacientefechanacimiento = GXutil.nullDate() ;
      AV106Pacientewwds_13_tfpacientefechanacimiento_to = GXutil.nullDate() ;
      AV109Pacientewwds_16_tfpacientenrodocumento_sel = "" ;
      AV108Pacientewwds_15_tfpacientenrodocumento = "" ;
      AV111Pacientewwds_18_tfpacientedireccion_sel = "" ;
      AV110Pacientewwds_17_tfpacientedireccion = "" ;
      AV114Pacientewwds_21_tfpacientecorreo_sel = "" ;
      AV113Pacientewwds_20_tfpacientecorreo = "" ;
      AV116Pacientewwds_23_tfpacientetelefono_sel = "" ;
      AV115Pacientewwds_22_tfpacientetelefono = "" ;
      AV120Pacientewwds_27_tfpaisdescripcion_sel = "" ;
      AV119Pacientewwds_26_tfpaisdescripcion = "" ;
      AV125Pacientewwds_32_tfubigeocode_sel = "" ;
      AV124Pacientewwds_31_tfubigeocode = "" ;
      AV127Pacientewwds_34_tfubigeonombre_sel = "" ;
      AV126Pacientewwds_33_tfubigeonombre = "" ;
      AV128Pacientewwds_35_tfpacienteestatura = DecimalUtil.ZERO ;
      AV129Pacientewwds_36_tfpacienteestatura_to = DecimalUtil.ZERO ;
      AV130Pacientewwds_37_tfpacientepeso = DecimalUtil.ZERO ;
      AV131Pacientewwds_38_tfpacientepeso_to = DecimalUtil.ZERO ;
      AV133Pacientewwds_40_tfpacientenombreanexo_sel = "" ;
      AV132Pacientewwds_39_tfpacientenombreanexo = "" ;
      AV136Pacientewwds_43_tfpacienteespecifique_sel = "" ;
      AV135Pacientewwds_42_tfpacienteespecifique = "" ;
      AV137Pacientewwds_44_tfpacientefecharegistro = GXutil.resetTime( GXutil.nullDate() );
      AV138Pacientewwds_45_tfpacientefecharegistro_to = GXutil.resetTime( GXutil.nullDate() );
      H001F2_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      H001F2_A225PacienteEspecifique = new String[] {""} ;
      H001F2_n225PacienteEspecifique = new boolean[] {false} ;
      H001F2_A224PacienteEnterarse = new String[] {""} ;
      H001F2_n224PacienteEnterarse = new boolean[] {false} ;
      H001F2_A223PacienteAnexos = new String[] {""} ;
      H001F2_n223PacienteAnexos = new boolean[] {false} ;
      H001F2_A222PacienteNombreAnexo = new String[] {""} ;
      H001F2_n222PacienteNombreAnexo = new boolean[] {false} ;
      H001F2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H001F2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H001F2_A44UbigeoCode = new String[] {""} ;
      H001F2_n44UbigeoCode = new boolean[] {false} ;
      H001F2_A6SecUserId = new short[1] ;
      H001F2_n6SecUserId = new boolean[] {false} ;
      H001F2_A219PacienteEstado = new String[] {""} ;
      H001F2_A184PaisDescripcion = new String[] {""} ;
      H001F2_A43PaisId = new short[1] ;
      H001F2_A218PacienteTelefono = new String[] {""} ;
      H001F2_A217PacienteCorreo = new String[] {""} ;
      H001F2_A216PacienteSexo = new String[] {""} ;
      H001F2_A215PacienteDireccion = new String[] {""} ;
      H001F2_A106PacienteNroDocumento = new String[] {""} ;
      H001F2_A214PacienteTipoDocumento = new String[] {""} ;
      H001F2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      H001F2_A20PacienteId = new int[1] ;
      H001F2_A105PacienteNombres = new String[] {""} ;
      H001F2_A104PacienteApellidoMaterno = new String[] {""} ;
      H001F2_A103PacienteApellidoPaterno = new String[] {""} ;
      H001F2_A188UbigeoDistrito = new String[] {""} ;
      H001F2_A187UbigeoProvincia = new String[] {""} ;
      H001F2_A186UbigeoDepartamento = new String[] {""} ;
      H001F3_AGRID_nRecordCount = new long[1] ;
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
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char42 = "" ;
      GXv_char43 = new String[1] ;
      GXt_char40 = "" ;
      GXv_char41 = new String[1] ;
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
      GXv_SdtWWPGridState44 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      gxphoneLink = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacienteww__default(),
         new Object[] {
             new Object[] {
            H001F2_A226PacienteFechaRegistro, H001F2_A225PacienteEspecifique, H001F2_n225PacienteEspecifique, H001F2_A224PacienteEnterarse, H001F2_n224PacienteEnterarse, H001F2_A223PacienteAnexos, H001F2_n223PacienteAnexos, H001F2_A222PacienteNombreAnexo, H001F2_n222PacienteNombreAnexo, H001F2_A221PacientePeso,
            H001F2_A220PacienteEstatura, H001F2_A44UbigeoCode, H001F2_n44UbigeoCode, H001F2_A6SecUserId, H001F2_n6SecUserId, H001F2_A219PacienteEstado, H001F2_A184PaisDescripcion, H001F2_A43PaisId, H001F2_A218PacienteTelefono, H001F2_A217PacienteCorreo,
            H001F2_A216PacienteSexo, H001F2_A215PacienteDireccion, H001F2_A106PacienteNroDocumento, H001F2_A214PacienteTipoDocumento, H001F2_A213PacienteFechaNacimiento, H001F2_A20PacienteId, H001F2_A105PacienteNombres, H001F2_A104PacienteApellidoMaterno, H001F2_A103PacienteApellidoPaterno, H001F2_A188UbigeoDistrito,
            H001F2_A187UbigeoProvincia, H001F2_A186UbigeoDepartamento
            }
            , new Object[] {
            H001F3_AGRID_nRecordCount
            }
         }
      );
      AV139Pgmname = "PacienteWW" ;
      /* GeneXus formulas. */
      AV139Pgmname = "PacienteWW" ;
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
   private short AV56TFPaisId ;
   private short AV57TFPaisId_To ;
   private short AV62TFSecUserId ;
   private short AV63TFSecUserId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV117Pacientewwds_24_tfpaisid ;
   private short AV118Pacientewwds_25_tfpaisid_to ;
   private short AV122Pacientewwds_29_tfsecuserid ;
   private short AV123Pacientewwds_30_tfsecuserid_to ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV27TFPacienteId ;
   private int AV28TFPacienteId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtPacienteId_Visible ;
   private int edtPacienteApellidoPaterno_Visible ;
   private int edtPacienteApellidoMaterno_Visible ;
   private int edtPacienteNombres_Visible ;
   private int edtPacienteNombreCompleto_Visible ;
   private int edtPacienteFechaNacimiento_Visible ;
   private int edtPacienteNroDocumento_Visible ;
   private int edtPacienteDireccion_Visible ;
   private int edtPacienteCorreo_Visible ;
   private int edtPacienteTelefono_Visible ;
   private int edtPaisId_Visible ;
   private int edtPaisDescripcion_Visible ;
   private int edtSecUserId_Visible ;
   private int edtUbigeoCode_Visible ;
   private int edtUbigeoNombre_Visible ;
   private int edtPacienteEstatura_Visible ;
   private int edtPacientePeso_Visible ;
   private int edtPacienteNombreAnexo_Visible ;
   private int edtPacienteAnexos_Visible ;
   private int edtPacienteEspecifique_Visible ;
   private int edtPacienteFechaRegistro_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int A20PacienteId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV107Pacientewwds_14_tfpacientetipodocumento_sels_size ;
   private int AV112Pacientewwds_19_tfpacientesexo_sels_size ;
   private int AV121Pacientewwds_28_tfpacienteestado_sels_size ;
   private int AV134Pacientewwds_41_tfpacienteenterarse_sels_size ;
   private int AV95Pacientewwds_2_tfpacienteid ;
   private int AV96Pacientewwds_3_tfpacienteid_to ;
   private int AV80PageToGo ;
   private int AV140GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV81GridCurrentPage ;
   private long AV82GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV68TFPacienteEstatura ;
   private java.math.BigDecimal AV69TFPacienteEstatura_To ;
   private java.math.BigDecimal AV70TFPacientePeso ;
   private java.math.BigDecimal AV71TFPacientePeso_To ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private java.math.BigDecimal AV128Pacientewwds_35_tfpacienteestatura ;
   private java.math.BigDecimal AV129Pacientewwds_36_tfpacienteestatura_to ;
   private java.math.BigDecimal AV130Pacientewwds_37_tfpacientepeso ;
   private java.math.BigDecimal AV131Pacientewwds_38_tfpacientepeso_to ;
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
   private String AV54TFPacienteTelefono ;
   private String AV55TFPacienteTelefono_Sel ;
   private String AV64TFUbigeoCode ;
   private String AV65TFUbigeoCode_Sel ;
   private String AV139Pgmname ;
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
   private String edtPacienteNombres_Link ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private String A218PacienteTelefono ;
   private String edtPaisDescripcion_Link ;
   private String A219PacienteEstado ;
   private String A44UbigeoCode ;
   private String edtUbigeoNombre_Link ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_pacientefechanacimientoauxdates_Internalname ;
   private String edtavDdo_pacientefechanacimientoauxdatetext_Internalname ;
   private String edtavDdo_pacientefechanacimientoauxdatetext_Jsonclick ;
   private String Tfpacientefechanacimiento_rangepicker_Internalname ;
   private String divDdo_pacientefecharegistroauxdates_Internalname ;
   private String edtavDdo_pacientefecharegistroauxdatetext_Internalname ;
   private String edtavDdo_pacientefecharegistroauxdatetext_Jsonclick ;
   private String Tfpacientefecharegistro_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombreCompleto_Internalname ;
   private String edtPacienteFechaNacimiento_Internalname ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtPacienteDireccion_Internalname ;
   private String edtPacienteCorreo_Internalname ;
   private String edtPacienteTelefono_Internalname ;
   private String edtPaisId_Internalname ;
   private String edtPaisDescripcion_Internalname ;
   private String edtSecUserId_Internalname ;
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoNombre_Internalname ;
   private String edtPacienteEstatura_Internalname ;
   private String edtPacientePeso_Internalname ;
   private String edtPacienteNombreAnexo_Internalname ;
   private String edtPacienteAnexos_Internalname ;
   private String edtPacienteEspecifique_Internalname ;
   private String edtPacienteFechaRegistro_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String lV115Pacientewwds_22_tfpacientetelefono ;
   private String lV124Pacientewwds_31_tfubigeocode ;
   private String AV116Pacientewwds_23_tfpacientetelefono_sel ;
   private String AV115Pacientewwds_22_tfpacientetelefono ;
   private String AV125Pacientewwds_32_tfubigeocode_sel ;
   private String AV124Pacientewwds_31_tfubigeocode ;
   private String GXt_char6 ;
   private String GXv_char8[] ;
   private String GXt_char13 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char42 ;
   private String GXv_char43[] ;
   private String GXt_char40 ;
   private String GXv_char41[] ;
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
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtPacienteNombreCompleto_Jsonclick ;
   private String edtPacienteFechaNacimiento_Jsonclick ;
   private String GXCCtl ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String edtPacienteDireccion_Jsonclick ;
   private String edtPacienteCorreo_Jsonclick ;
   private String gxphoneLink ;
   private String edtPacienteTelefono_Jsonclick ;
   private String edtPaisId_Jsonclick ;
   private String edtPaisDescripcion_Jsonclick ;
   private String edtSecUserId_Jsonclick ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoNombre_Jsonclick ;
   private String edtPacienteEstatura_Jsonclick ;
   private String edtPacientePeso_Jsonclick ;
   private String edtPacienteNombreAnexo_Jsonclick ;
   private String edtPacienteAnexos_Filetype ;
   private String edtPacienteAnexos_Contenttype ;
   private String edtPacienteAnexos_Parameters ;
   private String edtPacienteAnexos_Jsonclick ;
   private String edtPacienteEspecifique_Jsonclick ;
   private String edtPacienteFechaRegistro_Jsonclick ;
   private java.util.Date AV74TFPacienteFechaRegistro ;
   private java.util.Date AV75TFPacienteFechaRegistro_To ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date AV137Pacientewwds_44_tfpacientefecharegistro ;
   private java.util.Date AV138Pacientewwds_45_tfpacientefecharegistro_to ;
   private java.util.Date AV37TFPacienteFechaNacimiento ;
   private java.util.Date AV38TFPacienteFechaNacimiento_To ;
   private java.util.Date AV40DDO_PacienteFechaNacimientoAuxDateTo ;
   private java.util.Date AV77DDO_PacienteFechaRegistroAuxDateTo ;
   private java.util.Date AV39DDO_PacienteFechaNacimientoAuxDate ;
   private java.util.Date AV76DDO_PacienteFechaRegistroAuxDate ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private java.util.Date AV105Pacientewwds_12_tfpacientefechanacimiento ;
   private java.util.Date AV106Pacientewwds_13_tfpacientefechanacimiento_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV84IsAuthorized_Update ;
   private boolean AV86IsAuthorized_Delete ;
   private boolean AV87IsAuthorized_PaisDescripcion ;
   private boolean AV88IsAuthorized_UbigeoNombre ;
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
   private boolean n6SecUserId ;
   private boolean n44UbigeoCode ;
   private boolean n222PacienteNombreAnexo ;
   private boolean n223PacienteAnexos ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean n224PacienteEnterarse ;
   private boolean n225PacienteEspecifique ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV89TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV42TFPacienteTipoDocumento_SelsJson ;
   private String AV50TFPacienteSexo_SelsJson ;
   private String AV60TFPacienteEstado_SelsJson ;
   private String AV48TFPacienteEnterarse_SelsJson ;
   private String A225PacienteEspecifique ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String A223PacienteAnexos ;
   private String AV16FilterFullText ;
   private String AV29TFPacienteApellidoPaterno ;
   private String AV30TFPacienteApellidoPaterno_Sel ;
   private String AV31TFPacienteApellidoMaterno ;
   private String AV32TFPacienteApellidoMaterno_Sel ;
   private String AV33TFPacienteNombres ;
   private String AV34TFPacienteNombres_Sel ;
   private String AV35TFPacienteNombreCompleto ;
   private String AV36TFPacienteNombreCompleto_Sel ;
   private String AV44TFPacienteNroDocumento ;
   private String AV45TFPacienteNroDocumento_Sel ;
   private String AV46TFPacienteDireccion ;
   private String AV47TFPacienteDireccion_Sel ;
   private String AV52TFPacienteCorreo ;
   private String AV53TFPacienteCorreo_Sel ;
   private String AV58TFPaisDescripcion ;
   private String AV59TFPaisDescripcion_Sel ;
   private String AV66TFUbigeoNombre ;
   private String AV67TFUbigeoNombre_Sel ;
   private String AV72TFPacienteNombreAnexo ;
   private String AV73TFPacienteNombreAnexo_Sel ;
   private String AV90TFPacienteEspecifique ;
   private String AV91TFPacienteEspecifique_Sel ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A212PacienteNombreCompleto ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A222PacienteNombreAnexo ;
   private String A224PacienteEnterarse ;
   private String AV41DDO_PacienteFechaNacimientoAuxDateText ;
   private String AV78DDO_PacienteFechaRegistroAuxDateText ;
   private String lV94Pacientewwds_1_filterfulltext ;
   private String lV97Pacientewwds_4_tfpacienteapellidopaterno ;
   private String lV99Pacientewwds_6_tfpacienteapellidomaterno ;
   private String lV101Pacientewwds_8_tfpacientenombres ;
   private String lV103Pacientewwds_10_tfpacientenombrecompleto ;
   private String lV108Pacientewwds_15_tfpacientenrodocumento ;
   private String lV110Pacientewwds_17_tfpacientedireccion ;
   private String lV113Pacientewwds_20_tfpacientecorreo ;
   private String lV119Pacientewwds_26_tfpaisdescripcion ;
   private String lV126Pacientewwds_33_tfubigeonombre ;
   private String lV132Pacientewwds_39_tfpacientenombreanexo ;
   private String lV135Pacientewwds_42_tfpacienteespecifique ;
   private String AV94Pacientewwds_1_filterfulltext ;
   private String AV98Pacientewwds_5_tfpacienteapellidopaterno_sel ;
   private String AV97Pacientewwds_4_tfpacienteapellidopaterno ;
   private String AV100Pacientewwds_7_tfpacienteapellidomaterno_sel ;
   private String AV99Pacientewwds_6_tfpacienteapellidomaterno ;
   private String AV102Pacientewwds_9_tfpacientenombres_sel ;
   private String AV101Pacientewwds_8_tfpacientenombres ;
   private String AV104Pacientewwds_11_tfpacientenombrecompleto_sel ;
   private String AV103Pacientewwds_10_tfpacientenombrecompleto ;
   private String AV109Pacientewwds_16_tfpacientenrodocumento_sel ;
   private String AV108Pacientewwds_15_tfpacientenrodocumento ;
   private String AV111Pacientewwds_18_tfpacientedireccion_sel ;
   private String AV110Pacientewwds_17_tfpacientedireccion ;
   private String AV114Pacientewwds_21_tfpacientecorreo_sel ;
   private String AV113Pacientewwds_20_tfpacientecorreo ;
   private String AV120Pacientewwds_27_tfpaisdescripcion_sel ;
   private String AV119Pacientewwds_26_tfpaisdescripcion ;
   private String AV127Pacientewwds_34_tfubigeonombre_sel ;
   private String AV126Pacientewwds_33_tfubigeonombre ;
   private String AV133Pacientewwds_40_tfpacientenombreanexo_sel ;
   private String AV132Pacientewwds_39_tfpacientenombreanexo ;
   private String AV136Pacientewwds_43_tfpacienteespecifique_sel ;
   private String AV135Pacientewwds_42_tfpacienteespecifique ;
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
   private com.genexus.webpanels.GXUserControl ucTfpacientefechanacimiento_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfpacientefecharegistro_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private GXSimpleCollection<String> AV107Pacientewwds_14_tfpacientetipodocumento_sels ;
   private GXSimpleCollection<String> AV112Pacientewwds_19_tfpacientesexo_sels ;
   private GXSimpleCollection<String> AV121Pacientewwds_28_tfpacienteestado_sels ;
   private GXSimpleCollection<String> AV134Pacientewwds_41_tfpacienteenterarse_sels ;
   private HTMLChoice cmbPacienteTipoDocumento ;
   private HTMLChoice cmbPacienteSexo ;
   private HTMLChoice cmbPacienteEstado ;
   private HTMLChoice cmbPacienteEnterarse ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] H001F2_A226PacienteFechaRegistro ;
   private String[] H001F2_A225PacienteEspecifique ;
   private boolean[] H001F2_n225PacienteEspecifique ;
   private String[] H001F2_A224PacienteEnterarse ;
   private boolean[] H001F2_n224PacienteEnterarse ;
   private String[] H001F2_A223PacienteAnexos ;
   private boolean[] H001F2_n223PacienteAnexos ;
   private String[] H001F2_A222PacienteNombreAnexo ;
   private boolean[] H001F2_n222PacienteNombreAnexo ;
   private java.math.BigDecimal[] H001F2_A221PacientePeso ;
   private java.math.BigDecimal[] H001F2_A220PacienteEstatura ;
   private String[] H001F2_A44UbigeoCode ;
   private boolean[] H001F2_n44UbigeoCode ;
   private short[] H001F2_A6SecUserId ;
   private boolean[] H001F2_n6SecUserId ;
   private String[] H001F2_A219PacienteEstado ;
   private String[] H001F2_A184PaisDescripcion ;
   private short[] H001F2_A43PaisId ;
   private String[] H001F2_A218PacienteTelefono ;
   private String[] H001F2_A217PacienteCorreo ;
   private String[] H001F2_A216PacienteSexo ;
   private String[] H001F2_A215PacienteDireccion ;
   private String[] H001F2_A106PacienteNroDocumento ;
   private String[] H001F2_A214PacienteTipoDocumento ;
   private java.util.Date[] H001F2_A213PacienteFechaNacimiento ;
   private int[] H001F2_A20PacienteId ;
   private String[] H001F2_A105PacienteNombres ;
   private String[] H001F2_A104PacienteApellidoMaterno ;
   private String[] H001F2_A103PacienteApellidoPaterno ;
   private String[] H001F2_A188UbigeoDistrito ;
   private String[] H001F2_A187UbigeoProvincia ;
   private String[] H001F2_A186UbigeoDepartamento ;
   private long[] H001F3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV43TFPacienteTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV51TFPacienteSexo_Sels ;
   private GXSimpleCollection<String> AV61TFPacienteEstado_Sels ;
   private GXSimpleCollection<String> AV49TFPacienteEnterarse_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState44[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV79DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class pacienteww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001F2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV107Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV112Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV121Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV134Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV94Pacientewwds_1_filterfulltext ,
                                          int AV95Pacientewwds_2_tfpacienteid ,
                                          int AV96Pacientewwds_3_tfpacienteid_to ,
                                          String AV98Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV97Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV100Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV99Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV102Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV101Pacientewwds_8_tfpacientenombres ,
                                          String AV104Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV103Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV105Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV106Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV107Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV109Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV108Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV111Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV110Pacientewwds_17_tfpacientedireccion ,
                                          int AV112Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV114Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV113Pacientewwds_20_tfpacientecorreo ,
                                          String AV116Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV115Pacientewwds_22_tfpacientetelefono ,
                                          short AV117Pacientewwds_24_tfpaisid ,
                                          short AV118Pacientewwds_25_tfpaisid_to ,
                                          String AV120Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV119Pacientewwds_26_tfpaisdescripcion ,
                                          int AV121Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV122Pacientewwds_29_tfsecuserid ,
                                          short AV123Pacientewwds_30_tfsecuserid_to ,
                                          String AV125Pacientewwds_32_tfubigeocode_sel ,
                                          String AV124Pacientewwds_31_tfubigeocode ,
                                          String AV127Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV126Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV128Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV129Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV130Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV131Pacientewwds_38_tfpacientepeso_to ,
                                          String AV133Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV132Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV134Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV136Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV135Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV137Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV138Pacientewwds_45_tfpacientefecharegistro_to ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          String A215PacienteDireccion ,
                                          String A217PacienteCorreo ,
                                          String A218PacienteTelefono ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          short A6SecUserId ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          java.math.BigDecimal A220PacienteEstatura ,
                                          java.math.BigDecimal A221PacientePeso ,
                                          String A222PacienteNombreAnexo ,
                                          String A225PacienteEspecifique ,
                                          java.util.Date A213PacienteFechaNacimiento ,
                                          java.util.Date A226PacienteFechaRegistro ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int45 = new byte[79];
      Object[] GXv_Object46 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[PacienteFechaRegistro], T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteAnexos], T1.[PacienteNombreAnexo], T1.[PacientePeso], T1.[PacienteEstatura]," ;
      sSelectString += " T1.[UbigeoCode], T1.[SecUserId], T1.[PacienteEstado], T3.[PaisDescripcion], T1.[PaisId], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo], T1.[PacienteDireccion]," ;
      sSelectString += " T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      sSelectString += " T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento]" ;
      sFromString = " FROM (([Paciente] T1 LEFT JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais] T3 ON T3.[PaisId] = T1.[PaisId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV94Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T3.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int45[0] = (byte)(1) ;
         GXv_int45[1] = (byte)(1) ;
         GXv_int45[2] = (byte)(1) ;
         GXv_int45[3] = (byte)(1) ;
         GXv_int45[4] = (byte)(1) ;
         GXv_int45[5] = (byte)(1) ;
         GXv_int45[6] = (byte)(1) ;
         GXv_int45[7] = (byte)(1) ;
         GXv_int45[8] = (byte)(1) ;
         GXv_int45[9] = (byte)(1) ;
         GXv_int45[10] = (byte)(1) ;
         GXv_int45[11] = (byte)(1) ;
         GXv_int45[12] = (byte)(1) ;
         GXv_int45[13] = (byte)(1) ;
         GXv_int45[14] = (byte)(1) ;
         GXv_int45[15] = (byte)(1) ;
         GXv_int45[16] = (byte)(1) ;
         GXv_int45[17] = (byte)(1) ;
         GXv_int45[18] = (byte)(1) ;
         GXv_int45[19] = (byte)(1) ;
         GXv_int45[20] = (byte)(1) ;
         GXv_int45[21] = (byte)(1) ;
         GXv_int45[22] = (byte)(1) ;
         GXv_int45[23] = (byte)(1) ;
         GXv_int45[24] = (byte)(1) ;
         GXv_int45[25] = (byte)(1) ;
         GXv_int45[26] = (byte)(1) ;
         GXv_int45[27] = (byte)(1) ;
         GXv_int45[28] = (byte)(1) ;
         GXv_int45[29] = (byte)(1) ;
         GXv_int45[30] = (byte)(1) ;
         GXv_int45[31] = (byte)(1) ;
         GXv_int45[32] = (byte)(1) ;
         GXv_int45[33] = (byte)(1) ;
         GXv_int45[34] = (byte)(1) ;
         GXv_int45[35] = (byte)(1) ;
      }
      if ( ! (0==AV95Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int45[36] = (byte)(1) ;
      }
      if ( ! (0==AV96Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int45[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV97Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int45[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int45[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV99Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int45[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int45[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int45[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int45[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int45[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int45[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV105Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int45[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV106Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int45[47] = (byte)(1) ;
      }
      if ( AV107Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV107Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV109Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV108Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int45[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int45[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV110Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int45[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int45[51] = (byte)(1) ;
      }
      if ( AV112Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV114Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV113Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int45[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int45[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV115Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int45[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int45[55] = (byte)(1) ;
      }
      if ( ! (0==AV117Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int45[56] = (byte)(1) ;
      }
      if ( ! (0==AV118Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int45[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV119Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int45[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int45[59] = (byte)(1) ;
      }
      if ( AV121Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV121Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV122Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int45[60] = (byte)(1) ;
      }
      if ( ! (0==AV123Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int45[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV124Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int45[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int45[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV126Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int45[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int45[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV128Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int45[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV129Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int45[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV130Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int45[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV131Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int45[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV132Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int45[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int45[71] = (byte)(1) ;
      }
      if ( AV134Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV134Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV136Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV135Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int45[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int45[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV137Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int45[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV138Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int45[75] = (byte)(1) ;
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteNombres]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteNombres] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaNacimiento]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaNacimiento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteTipoDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteTipoDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteNroDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteDireccion]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteDireccion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteSexo]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteSexo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteCorreo]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteCorreo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteTelefono]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteTelefono] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[PaisDescripcion]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEstado]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEstado] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEstatura]" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEstatura] DESC" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacientePeso]" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacientePeso] DESC" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteNombreAnexo]" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteNombreAnexo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEnterarse]" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEnterarse] DESC" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEspecifique]" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEspecifique] DESC" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaRegistro]" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaRegistro] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[PacienteId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object46[0] = scmdbuf ;
      GXv_Object46[1] = GXv_int45 ;
      return GXv_Object46 ;
   }

   protected Object[] conditional_H001F3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV107Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV112Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV121Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV134Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV94Pacientewwds_1_filterfulltext ,
                                          int AV95Pacientewwds_2_tfpacienteid ,
                                          int AV96Pacientewwds_3_tfpacienteid_to ,
                                          String AV98Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV97Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV100Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV99Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV102Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV101Pacientewwds_8_tfpacientenombres ,
                                          String AV104Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV103Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV105Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV106Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV107Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV109Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV108Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV111Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV110Pacientewwds_17_tfpacientedireccion ,
                                          int AV112Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV114Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV113Pacientewwds_20_tfpacientecorreo ,
                                          String AV116Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV115Pacientewwds_22_tfpacientetelefono ,
                                          short AV117Pacientewwds_24_tfpaisid ,
                                          short AV118Pacientewwds_25_tfpaisid_to ,
                                          String AV120Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV119Pacientewwds_26_tfpaisdescripcion ,
                                          int AV121Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV122Pacientewwds_29_tfsecuserid ,
                                          short AV123Pacientewwds_30_tfsecuserid_to ,
                                          String AV125Pacientewwds_32_tfubigeocode_sel ,
                                          String AV124Pacientewwds_31_tfubigeocode ,
                                          String AV127Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV126Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV128Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV129Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV130Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV131Pacientewwds_38_tfpacientepeso_to ,
                                          String AV133Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV132Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV134Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV136Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV135Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV137Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV138Pacientewwds_45_tfpacientefecharegistro_to ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          String A215PacienteDireccion ,
                                          String A217PacienteCorreo ,
                                          String A218PacienteTelefono ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          short A6SecUserId ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          java.math.BigDecimal A220PacienteEstatura ,
                                          java.math.BigDecimal A221PacientePeso ,
                                          String A222PacienteNombreAnexo ,
                                          String A225PacienteEspecifique ,
                                          java.util.Date A213PacienteFechaNacimiento ,
                                          java.util.Date A226PacienteFechaRegistro ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int48 = new byte[76];
      Object[] GXv_Object49 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Paciente] T1 LEFT JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId])" ;
      if ( ! (GXutil.strcmp("", AV94Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int48[0] = (byte)(1) ;
         GXv_int48[1] = (byte)(1) ;
         GXv_int48[2] = (byte)(1) ;
         GXv_int48[3] = (byte)(1) ;
         GXv_int48[4] = (byte)(1) ;
         GXv_int48[5] = (byte)(1) ;
         GXv_int48[6] = (byte)(1) ;
         GXv_int48[7] = (byte)(1) ;
         GXv_int48[8] = (byte)(1) ;
         GXv_int48[9] = (byte)(1) ;
         GXv_int48[10] = (byte)(1) ;
         GXv_int48[11] = (byte)(1) ;
         GXv_int48[12] = (byte)(1) ;
         GXv_int48[13] = (byte)(1) ;
         GXv_int48[14] = (byte)(1) ;
         GXv_int48[15] = (byte)(1) ;
         GXv_int48[16] = (byte)(1) ;
         GXv_int48[17] = (byte)(1) ;
         GXv_int48[18] = (byte)(1) ;
         GXv_int48[19] = (byte)(1) ;
         GXv_int48[20] = (byte)(1) ;
         GXv_int48[21] = (byte)(1) ;
         GXv_int48[22] = (byte)(1) ;
         GXv_int48[23] = (byte)(1) ;
         GXv_int48[24] = (byte)(1) ;
         GXv_int48[25] = (byte)(1) ;
         GXv_int48[26] = (byte)(1) ;
         GXv_int48[27] = (byte)(1) ;
         GXv_int48[28] = (byte)(1) ;
         GXv_int48[29] = (byte)(1) ;
         GXv_int48[30] = (byte)(1) ;
         GXv_int48[31] = (byte)(1) ;
         GXv_int48[32] = (byte)(1) ;
         GXv_int48[33] = (byte)(1) ;
         GXv_int48[34] = (byte)(1) ;
         GXv_int48[35] = (byte)(1) ;
      }
      if ( ! (0==AV95Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int48[36] = (byte)(1) ;
      }
      if ( ! (0==AV96Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int48[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV97Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int48[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int48[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV99Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int48[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int48[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int48[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int48[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int48[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int48[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV105Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int48[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV106Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int48[47] = (byte)(1) ;
      }
      if ( AV107Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV107Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV109Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV108Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int48[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int48[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV110Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int48[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int48[51] = (byte)(1) ;
      }
      if ( AV112Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV114Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV113Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int48[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int48[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV115Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int48[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int48[55] = (byte)(1) ;
      }
      if ( ! (0==AV117Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int48[56] = (byte)(1) ;
      }
      if ( ! (0==AV118Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int48[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV119Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int48[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int48[59] = (byte)(1) ;
      }
      if ( AV121Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV121Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV122Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int48[60] = (byte)(1) ;
      }
      if ( ! (0==AV123Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int48[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV124Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int48[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int48[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV126Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int48[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int48[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV128Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int48[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV129Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int48[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV130Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int48[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV131Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int48[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV132Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int48[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int48[71] = (byte)(1) ;
      }
      if ( AV134Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV134Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV136Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV135Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int48[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int48[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV137Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int48[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV138Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int48[75] = (byte)(1) ;
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object49[0] = scmdbuf ;
      GXv_Object49[1] = GXv_int48 ;
      return GXv_Object49 ;
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
                  return conditional_H001F2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] , ((Number) dynConstraints[74]).shortValue() , ((Boolean) dynConstraints[75]).booleanValue() );
            case 1 :
                  return conditional_H001F3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] , ((Number) dynConstraints[74]).shortValue() , ((Boolean) dynConstraints[75]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001F2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001F3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getBLOBFile(4, "tmp", "");
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[11])[0] = rslt.getString(8, 10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(10, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(14);
               ((String[]) buf[20])[0] = rslt.getString(15, 1);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getString(18, 1);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(19);
               ((int[]) buf[25])[0] = rslt.getInt(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((String[]) buf[28])[0] = rslt.getVarchar(23);
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((String[]) buf[31])[0] = rslt.getVarchar(26);
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
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[125]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[126]);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 15);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 15);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 500);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[130], 500);
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
                  stmt.setString(sIdx, (String)parms[133], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[134], 20);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[135]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[136]).shortValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 80);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[139]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[140]).shortValue());
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[141], 10);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[142], 10);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[145], 2);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[146], 2);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[147], 2);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[148], 2);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 100);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[152], 200);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[153], false);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[154], false);
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
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[122]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[123]);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 15);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 15);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 500);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 500);
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
                  stmt.setString(sIdx, (String)parms[130], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[131], 20);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[132]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[133]).shortValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 80);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[136]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[137]).shortValue());
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[138], 10);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[139], 10);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[142], 2);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[143], 2);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[144], 2);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[145], 2);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 100);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 200);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[150], false);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[151], false);
               }
               return;
      }
   }

}

