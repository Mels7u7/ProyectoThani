package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wppaciente_impl extends GXDataArea
{
   public wppaciente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wppaciente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wppaciente_impl.class ));
   }

   public wppaciente_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbProfesionalTipoDocumento = new HTMLChoice();
      cmbProfesionalSexo = new HTMLChoice();
      cmbProfesionalTiempoCita = new HTMLChoice();
      chkProfesionalTerminosCondiciones = UIFactory.getCheckbox(this);
      cmbProfesionalEstadoCuenta = new HTMLChoice();
      cmbProfesionalEstado = new HTMLChoice();
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
            AV27TFProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "TFProfesionalId"))) ;
            AV28TFProfesionalId_To = (int)(GXutil.lval( httpContext.GetPar( "TFProfesionalId_To"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFProfesionalTipoDocumento_Sels);
            AV31TFProfesionalNroDocumento = httpContext.GetPar( "TFProfesionalNroDocumento") ;
            AV32TFProfesionalNroDocumento_Sel = httpContext.GetPar( "TFProfesionalNroDocumento_Sel") ;
            AV33TFProfesionalApellidoPaterno = httpContext.GetPar( "TFProfesionalApellidoPaterno") ;
            AV34TFProfesionalApellidoPaterno_Sel = httpContext.GetPar( "TFProfesionalApellidoPaterno_Sel") ;
            AV35TFProfesionalApellidoMaterno = httpContext.GetPar( "TFProfesionalApellidoMaterno") ;
            AV36TFProfesionalApellidoMaterno_Sel = httpContext.GetPar( "TFProfesionalApellidoMaterno_Sel") ;
            AV37TFProfesionalNombres = httpContext.GetPar( "TFProfesionalNombres") ;
            AV38TFProfesionalNombres_Sel = httpContext.GetPar( "TFProfesionalNombres_Sel") ;
            AV39TFProfesionalNombreCompleto2 = httpContext.GetPar( "TFProfesionalNombreCompleto2") ;
            AV40TFProfesionalNombreCompleto2_Sel = httpContext.GetPar( "TFProfesionalNombreCompleto2_Sel") ;
            AV41TFProfesionalFechaNacimiento = localUtil.parseDateParm( httpContext.GetPar( "TFProfesionalFechaNacimiento")) ;
            AV42TFProfesionalFechaNacimiento_To = localUtil.parseDateParm( httpContext.GetPar( "TFProfesionalFechaNacimiento_To")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV47TFProfesionalSexo_Sels);
            AV48TFProfesionalDescripcion = httpContext.GetPar( "TFProfesionalDescripcion") ;
            AV49TFProfesionalDescripcion_Sel = httpContext.GetPar( "TFProfesionalDescripcion_Sel") ;
            AV50TFProfesionalCorreo = httpContext.GetPar( "TFProfesionalCorreo") ;
            AV51TFProfesionalCorreo_Sel = httpContext.GetPar( "TFProfesionalCorreo_Sel") ;
            AV52TFProfesionalCOP = httpContext.GetPar( "TFProfesionalCOP") ;
            AV53TFProfesionalCOP_Sel = httpContext.GetPar( "TFProfesionalCOP_Sel") ;
            AV54TFProfesionalColorDisponible = httpContext.GetPar( "TFProfesionalColorDisponible") ;
            AV55TFProfesionalColorDisponible_Sel = httpContext.GetPar( "TFProfesionalColorDisponible_Sel") ;
            AV56TFProfesionalColorCita = httpContext.GetPar( "TFProfesionalColorCita") ;
            AV57TFProfesionalColorCita_Sel = httpContext.GetPar( "TFProfesionalColorCita_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV59TFProfesionalTiempoCita_Sels);
            AV60TFProfesionalDireccion = httpContext.GetPar( "TFProfesionalDireccion") ;
            AV61TFProfesionalDireccion_Sel = httpContext.GetPar( "TFProfesionalDireccion_Sel") ;
            AV62TFPaisId = (short)(GXutil.lval( httpContext.GetPar( "TFPaisId"))) ;
            AV63TFPaisId_To = (short)(GXutil.lval( httpContext.GetPar( "TFPaisId_To"))) ;
            AV64TFPaisDescripcion = httpContext.GetPar( "TFPaisDescripcion") ;
            AV65TFPaisDescripcion_Sel = httpContext.GetPar( "TFPaisDescripcion_Sel") ;
            AV66TFUbigeoCode = httpContext.GetPar( "TFUbigeoCode") ;
            AV67TFUbigeoCode_Sel = httpContext.GetPar( "TFUbigeoCode_Sel") ;
            AV68TFUbigeoNombre = httpContext.GetPar( "TFUbigeoNombre") ;
            AV69TFUbigeoNombre_Sel = httpContext.GetPar( "TFUbigeoNombre_Sel") ;
            AV70TFProfesionalTwitter = httpContext.GetPar( "TFProfesionalTwitter") ;
            AV71TFProfesionalTwitter_Sel = httpContext.GetPar( "TFProfesionalTwitter_Sel") ;
            AV72TFProfesionalFacebook = httpContext.GetPar( "TFProfesionalFacebook") ;
            AV73TFProfesionalFacebook_Sel = httpContext.GetPar( "TFProfesionalFacebook_Sel") ;
            AV74TFProfesionalInstagram = httpContext.GetPar( "TFProfesionalInstagram") ;
            AV75TFProfesionalInstagram_Sel = httpContext.GetPar( "TFProfesionalInstagram_Sel") ;
            AV76TFProfesionalLinkedin = httpContext.GetPar( "TFProfesionalLinkedin") ;
            AV77TFProfesionalLinkedin_Sel = httpContext.GetPar( "TFProfesionalLinkedin_Sel") ;
            AV78TFProfesionalTelefono = httpContext.GetPar( "TFProfesionalTelefono") ;
            AV79TFProfesionalTelefono_Sel = httpContext.GetPar( "TFProfesionalTelefono_Sel") ;
            AV80TFSecUserId = (short)(GXutil.lval( httpContext.GetPar( "TFSecUserId"))) ;
            AV81TFSecUserId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSecUserId_To"))) ;
            AV82TFProfesionalFechaRegistro = localUtil.parseDateParm( httpContext.GetPar( "TFProfesionalFechaRegistro")) ;
            AV83TFProfesionalFechaRegistro_To = localUtil.parseDateParm( httpContext.GetPar( "TFProfesionalFechaRegistro_To")) ;
            AV87TFProfesionalTerminosCondiciones_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFProfesionalTerminosCondiciones_Sel"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV89TFProfesionalEstadoCuenta_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV91TFProfesionalEstado_Sels);
            AV160Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV97IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV99IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV100IsAuthorized_PaisDescripcion = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_PaisDescripcion")) ;
            AV101IsAuthorized_UbigeoNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_UbigeoNombre")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFProfesionalId, AV28TFProfesionalId_To, AV30TFProfesionalTipoDocumento_Sels, AV31TFProfesionalNroDocumento, AV32TFProfesionalNroDocumento_Sel, AV33TFProfesionalApellidoPaterno, AV34TFProfesionalApellidoPaterno_Sel, AV35TFProfesionalApellidoMaterno, AV36TFProfesionalApellidoMaterno_Sel, AV37TFProfesionalNombres, AV38TFProfesionalNombres_Sel, AV39TFProfesionalNombreCompleto2, AV40TFProfesionalNombreCompleto2_Sel, AV41TFProfesionalFechaNacimiento, AV42TFProfesionalFechaNacimiento_To, AV47TFProfesionalSexo_Sels, AV48TFProfesionalDescripcion, AV49TFProfesionalDescripcion_Sel, AV50TFProfesionalCorreo, AV51TFProfesionalCorreo_Sel, AV52TFProfesionalCOP, AV53TFProfesionalCOP_Sel, AV54TFProfesionalColorDisponible, AV55TFProfesionalColorDisponible_Sel, AV56TFProfesionalColorCita, AV57TFProfesionalColorCita_Sel, AV59TFProfesionalTiempoCita_Sels, AV60TFProfesionalDireccion, AV61TFProfesionalDireccion_Sel, AV62TFPaisId, AV63TFPaisId_To, AV64TFPaisDescripcion, AV65TFPaisDescripcion_Sel, AV66TFUbigeoCode, AV67TFUbigeoCode_Sel, AV68TFUbigeoNombre, AV69TFUbigeoNombre_Sel, AV70TFProfesionalTwitter, AV71TFProfesionalTwitter_Sel, AV72TFProfesionalFacebook, AV73TFProfesionalFacebook_Sel, AV74TFProfesionalInstagram, AV75TFProfesionalInstagram_Sel, AV76TFProfesionalLinkedin, AV77TFProfesionalLinkedin_Sel, AV78TFProfesionalTelefono, AV79TFProfesionalTelefono_Sel, AV80TFSecUserId, AV81TFSecUserId_To, AV82TFProfesionalFechaRegistro, AV83TFProfesionalFechaRegistro_To, AV87TFProfesionalTerminosCondiciones_Sel, AV89TFProfesionalEstadoCuenta_Sels, AV91TFProfesionalEstado_Sels, AV160Pgmname, AV13OrderedBy, AV14OrderedDsc, AV97IsAuthorized_Update, AV99IsAuthorized_Delete, AV100IsAuthorized_PaisDescripcion, AV101IsAuthorized_UbigeoNombre) ;
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
      pa2R2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2R2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110335223", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wppaciente", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV160Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV97IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV99IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV100IsAuthorized_PaisDescripcion));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV101IsAuthorized_UbigeoNombre));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV94GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV95GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV92DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV92DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PROFESIONALFECHANACIMIENTOAUXDATETO", localUtil.dtoc( AV44DDO_ProfesionalFechaNacimientoAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PROFESIONALFECHAREGISTROAUXDATETO", localUtil.dtoc( AV85DDO_ProfesionalFechaRegistroAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV27TFProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFProfesionalId_To, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPROFESIONALTIPODOCUMENTO_SELS", AV30TFProfesionalTipoDocumento_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPROFESIONALTIPODOCUMENTO_SELS", AV30TFProfesionalTipoDocumento_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNRODOCUMENTO", AV31TFProfesionalNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNRODOCUMENTO_SEL", AV32TFProfesionalNroDocumento_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOPATERNO", AV33TFProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOPATERNO_SEL", AV34TFProfesionalApellidoPaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOMATERNO", AV35TFProfesionalApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALAPELLIDOMATERNO_SEL", AV36TFProfesionalApellidoMaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRES", AV37TFProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRES_SEL", AV38TFProfesionalNombres_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRECOMPLETO2", AV39TFProfesionalNombreCompleto2);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALNOMBRECOMPLETO2_SEL", AV40TFProfesionalNombreCompleto2_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALFECHANACIMIENTO", localUtil.dtoc( AV41TFProfesionalFechaNacimiento, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALFECHANACIMIENTO_TO", localUtil.dtoc( AV42TFProfesionalFechaNacimiento_To, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPROFESIONALSEXO_SELS", AV47TFProfesionalSexo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPROFESIONALSEXO_SELS", AV47TFProfesionalSexo_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALDESCRIPCION", AV48TFProfesionalDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALDESCRIPCION_SEL", AV49TFProfesionalDescripcion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCORREO", AV50TFProfesionalCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCORREO_SEL", AV51TFProfesionalCorreo_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOP", AV52TFProfesionalCOP);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOP_SEL", AV53TFProfesionalCOP_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOLORDISPONIBLE", GXutil.rtrim( AV54TFProfesionalColorDisponible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOLORDISPONIBLE_SEL", GXutil.rtrim( AV55TFProfesionalColorDisponible_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOLORCITA", GXutil.rtrim( AV56TFProfesionalColorCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALCOLORCITA_SEL", GXutil.rtrim( AV57TFProfesionalColorCita_Sel));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPROFESIONALTIEMPOCITA_SELS", AV59TFProfesionalTiempoCita_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPROFESIONALTIEMPOCITA_SELS", AV59TFProfesionalTiempoCita_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALDIRECCION", AV60TFProfesionalDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALDIRECCION_SEL", AV61TFProfesionalDireccion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISID", GXutil.ltrim( localUtil.ntoc( AV62TFPaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISID_TO", GXutil.ltrim( localUtil.ntoc( AV63TFPaisId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISDESCRIPCION", AV64TFPaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPAISDESCRIPCION_SEL", AV65TFPaisDescripcion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE", GXutil.rtrim( AV66TFUbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE_SEL", GXutil.rtrim( AV67TFUbigeoCode_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE", AV68TFUbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE_SEL", AV69TFUbigeoNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTWITTER", AV70TFProfesionalTwitter);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTWITTER_SEL", AV71TFProfesionalTwitter_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALFACEBOOK", AV72TFProfesionalFacebook);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALFACEBOOK_SEL", AV73TFProfesionalFacebook_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALINSTAGRAM", AV74TFProfesionalInstagram);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALINSTAGRAM_SEL", AV75TFProfesionalInstagram_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALLINKEDIN", AV76TFProfesionalLinkedin);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALLINKEDIN_SEL", AV77TFProfesionalLinkedin_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTELEFONO", GXutil.rtrim( AV78TFProfesionalTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTELEFONO_SEL", GXutil.rtrim( AV79TFProfesionalTelefono_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERID", GXutil.ltrim( localUtil.ntoc( AV80TFSecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSECUSERID_TO", GXutil.ltrim( localUtil.ntoc( AV81TFSecUserId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALFECHAREGISTRO", localUtil.dtoc( AV82TFProfesionalFechaRegistro, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALFECHAREGISTRO_TO", localUtil.dtoc( AV83TFProfesionalFechaRegistro_To, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTERMINOSCONDICIONES_SEL", GXutil.ltrim( localUtil.ntoc( AV87TFProfesionalTerminosCondiciones_Sel, (byte)(1), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPROFESIONALESTADOCUENTA_SELS", AV89TFProfesionalEstadoCuenta_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPROFESIONALESTADOCUENTA_SELS", AV89TFProfesionalEstadoCuenta_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPROFESIONALESTADO_SELS", AV91TFProfesionalEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPROFESIONALESTADO_SELS", AV91TFProfesionalEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV160Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV160Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV97IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV97IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV99IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV99IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PAISDESCRIPCION", AV100IsAuthorized_PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV100IsAuthorized_PaisDescripcion));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UBIGEONOMBRE", AV101IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV101IsAuthorized_UbigeoNombre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTIPODOCUMENTO_SELSJSON", AV29TFProfesionalTipoDocumento_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALSEXO_SELSJSON", AV46TFProfesionalSexo_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALTIEMPOCITA_SELSJSON", AV58TFProfesionalTiempoCita_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALESTADOCUENTA_SELSJSON", AV88TFProfesionalEstadoCuenta_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPROFESIONALESTADO_SELSJSON", AV90TFProfesionalEstado_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODISTRITO", A188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PROFESIONALFECHANACIMIENTOAUXDATE", localUtil.dtoc( AV43DDO_ProfesionalFechaNacimientoAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_PROFESIONALFECHAREGISTROAUXDATE", localUtil.dtoc( AV84DDO_ProfesionalFechaRegistroAuxDate, 0, "/"));
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
         we2R2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2R2( ) ;
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
      return formatLink("com.projectthani.wppaciente", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPPaciente" ;
   }

   public String getPgmdesc( )
   {
      return " Profesional" ;
   }

   public void wb2R0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_2R2( true) ;
      }
      else
      {
         wb_table1_25_2R2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_2R2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbProfesionalTipoDocumento.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalNroDocumento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalNombreCompleto2_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Completo2") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalFechaNacimiento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Nacimiento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbProfesionalSexo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Sexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalDescripcion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalCorreo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalCOP_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "CMP") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalColorDisponible_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Color Disponible") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalColorCita_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Color Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbProfesionalTiempoCita.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tiempo Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalDireccion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaisId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Pais Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPaisDescripcion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Pais Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalFoto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Foto") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalTwitter_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Twitter") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalFacebook_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Facebook") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalInstagram_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Instagram") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalLinkedin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Linkedin") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalTelefono_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Telefono") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecUserId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "User Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtProfesionalFechaRegistro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Registro") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkProfesionalTerminosCondiciones.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Terminos Condiciones") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbProfesionalEstadoCuenta.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado Cuenta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbProfesionalEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV96Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV98Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A173ProfesionalTipoDocumento));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbProfesionalTipoDocumento.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A174ProfesionalNroDocumento);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalNroDocumento_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", A175ProfesionalNombreCompleto2);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalNombreCompleto2_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalFechaNacimiento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A177ProfesionalSexo));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbProfesionalSexo.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A178ProfesionalDescripcion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalDescripcion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A179ProfesionalCorreo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalCorreo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A88ProfesionalCOP);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalCOP_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A180ProfesionalColorDisponible));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalColorDisponible_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A181ProfesionalColorCita));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalColorCita_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A182ProfesionalTiempoCita, (byte)(2), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbProfesionalTiempoCita.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A183ProfesionalDireccion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalDireccion_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A44UbigeoCode));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A185UbigeoNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtUbigeoNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A189ProfesionalFoto));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalFoto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A190ProfesionalTwitter);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtProfesionalTwitter_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtProfesionalTwitter_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalTwitter_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A191ProfesionalFacebook);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtProfesionalFacebook_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtProfesionalFacebook_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalFacebook_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A192ProfesionalInstagram);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtProfesionalInstagram_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtProfesionalInstagram_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalInstagram_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A193ProfesionalLinkedin);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtProfesionalLinkedin_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtProfesionalLinkedin_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalLinkedin_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A194ProfesionalTelefono));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalTelefono_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtProfesionalFechaRegistro_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( A196ProfesionalTerminosCondiciones));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkProfesionalTerminosCondiciones.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A197ProfesionalEstadoCuenta));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbProfesionalEstadoCuenta.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A198ProfesionalEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbProfesionalEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV94GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV95GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV92DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV92DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_profesionalfechanacimientoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_profesionalfechanacimientoauxdatetext_Internalname, AV45DDO_ProfesionalFechaNacimientoAuxDateText, GXutil.rtrim( localUtil.format( AV45DDO_ProfesionalFechaNacimientoAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_profesionalfechanacimientoauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPPaciente.htm");
         /* User Defined Control */
         ucTfprofesionalfechanacimiento_rangepicker.setProperty("Start Date", AV43DDO_ProfesionalFechaNacimientoAuxDate);
         ucTfprofesionalfechanacimiento_rangepicker.setProperty("End Date", AV44DDO_ProfesionalFechaNacimientoAuxDateTo);
         ucTfprofesionalfechanacimiento_rangepicker.render(context, "wwp.daterangepicker", Tfprofesionalfechanacimiento_rangepicker_Internalname, "TFPROFESIONALFECHANACIMIENTO_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_profesionalfecharegistroauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_profesionalfecharegistroauxdatetext_Internalname, AV86DDO_ProfesionalFechaRegistroAuxDateText, GXutil.rtrim( localUtil.format( AV86DDO_ProfesionalFechaRegistroAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,91);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_profesionalfecharegistroauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPPaciente.htm");
         /* User Defined Control */
         ucTfprofesionalfecharegistro_rangepicker.setProperty("Start Date", AV84DDO_ProfesionalFechaRegistroAuxDate);
         ucTfprofesionalfecharegistro_rangepicker.setProperty("End Date", AV85DDO_ProfesionalFechaRegistroAuxDateTo);
         ucTfprofesionalfecharegistro_rangepicker.render(context, "wwp.daterangepicker", Tfprofesionalfecharegistro_rangepicker_Internalname, "TFPROFESIONALFECHAREGISTRO_RANGEPICKERContainer");
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

   public void start2R2( )
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
         Form.getMeta().addItem("description", " Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2R0( ) ;
   }

   public void ws2R2( )
   {
      start2R2( ) ;
      evt2R2( ) ;
   }

   public void evt2R2( )
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
                           e112R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e162R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e172R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e182R2 ();
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
                           AV96Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV96Update);
                           AV98Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV98Delete);
                           A31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".")) ;
                           cmbProfesionalTipoDocumento.setName( cmbProfesionalTipoDocumento.getInternalname() );
                           cmbProfesionalTipoDocumento.setValue( httpContext.cgiGet( cmbProfesionalTipoDocumento.getInternalname()) );
                           A173ProfesionalTipoDocumento = httpContext.cgiGet( cmbProfesionalTipoDocumento.getInternalname()) ;
                           A174ProfesionalNroDocumento = httpContext.cgiGet( edtProfesionalNroDocumento_Internalname) ;
                           A85ProfesionalApellidoPaterno = httpContext.cgiGet( edtProfesionalApellidoPaterno_Internalname) ;
                           A86ProfesionalApellidoMaterno = httpContext.cgiGet( edtProfesionalApellidoMaterno_Internalname) ;
                           A84ProfesionalNombres = httpContext.cgiGet( edtProfesionalNombres_Internalname) ;
                           A175ProfesionalNombreCompleto2 = httpContext.cgiGet( edtProfesionalNombreCompleto2_Internalname) ;
                           A176ProfesionalFechaNacimiento = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtProfesionalFechaNacimiento_Internalname), 0)) ;
                           cmbProfesionalSexo.setName( cmbProfesionalSexo.getInternalname() );
                           cmbProfesionalSexo.setValue( httpContext.cgiGet( cmbProfesionalSexo.getInternalname()) );
                           A177ProfesionalSexo = httpContext.cgiGet( cmbProfesionalSexo.getInternalname()) ;
                           A178ProfesionalDescripcion = httpContext.cgiGet( edtProfesionalDescripcion_Internalname) ;
                           A179ProfesionalCorreo = httpContext.cgiGet( edtProfesionalCorreo_Internalname) ;
                           A88ProfesionalCOP = httpContext.cgiGet( edtProfesionalCOP_Internalname) ;
                           A180ProfesionalColorDisponible = httpContext.cgiGet( edtProfesionalColorDisponible_Internalname) ;
                           A181ProfesionalColorCita = httpContext.cgiGet( edtProfesionalColorCita_Internalname) ;
                           cmbProfesionalTiempoCita.setName( cmbProfesionalTiempoCita.getInternalname() );
                           cmbProfesionalTiempoCita.setValue( httpContext.cgiGet( cmbProfesionalTiempoCita.getInternalname()) );
                           A182ProfesionalTiempoCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbProfesionalTiempoCita.getInternalname()))) ;
                           A183ProfesionalDireccion = httpContext.cgiGet( edtProfesionalDireccion_Internalname) ;
                           A43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".")) ;
                           A184PaisDescripcion = httpContext.cgiGet( edtPaisDescripcion_Internalname) ;
                           A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
                           A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
                           A189ProfesionalFoto = httpContext.cgiGet( edtProfesionalFoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
                           A190ProfesionalTwitter = httpContext.cgiGet( edtProfesionalTwitter_Internalname) ;
                           A191ProfesionalFacebook = httpContext.cgiGet( edtProfesionalFacebook_Internalname) ;
                           A192ProfesionalInstagram = httpContext.cgiGet( edtProfesionalInstagram_Internalname) ;
                           A193ProfesionalLinkedin = httpContext.cgiGet( edtProfesionalLinkedin_Internalname) ;
                           A194ProfesionalTelefono = httpContext.cgiGet( edtProfesionalTelefono_Internalname) ;
                           A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
                           A195ProfesionalFechaRegistro = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtProfesionalFechaRegistro_Internalname), 0)) ;
                           A196ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( chkProfesionalTerminosCondiciones.getInternalname())) ;
                           cmbProfesionalEstadoCuenta.setName( cmbProfesionalEstadoCuenta.getInternalname() );
                           cmbProfesionalEstadoCuenta.setValue( httpContext.cgiGet( cmbProfesionalEstadoCuenta.getInternalname()) );
                           A197ProfesionalEstadoCuenta = httpContext.cgiGet( cmbProfesionalEstadoCuenta.getInternalname()) ;
                           cmbProfesionalEstado.setName( cmbProfesionalEstado.getInternalname() );
                           cmbProfesionalEstado.setValue( httpContext.cgiGet( cmbProfesionalEstado.getInternalname()) );
                           A198ProfesionalEstado = httpContext.cgiGet( cmbProfesionalEstado.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e192R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e202R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e212R2 ();
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

   public void we2R2( )
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

   public void pa2R2( )
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
                                 int AV27TFProfesionalId ,
                                 int AV28TFProfesionalId_To ,
                                 GXSimpleCollection<String> AV30TFProfesionalTipoDocumento_Sels ,
                                 String AV31TFProfesionalNroDocumento ,
                                 String AV32TFProfesionalNroDocumento_Sel ,
                                 String AV33TFProfesionalApellidoPaterno ,
                                 String AV34TFProfesionalApellidoPaterno_Sel ,
                                 String AV35TFProfesionalApellidoMaterno ,
                                 String AV36TFProfesionalApellidoMaterno_Sel ,
                                 String AV37TFProfesionalNombres ,
                                 String AV38TFProfesionalNombres_Sel ,
                                 String AV39TFProfesionalNombreCompleto2 ,
                                 String AV40TFProfesionalNombreCompleto2_Sel ,
                                 java.util.Date AV41TFProfesionalFechaNacimiento ,
                                 java.util.Date AV42TFProfesionalFechaNacimiento_To ,
                                 GXSimpleCollection<String> AV47TFProfesionalSexo_Sels ,
                                 String AV48TFProfesionalDescripcion ,
                                 String AV49TFProfesionalDescripcion_Sel ,
                                 String AV50TFProfesionalCorreo ,
                                 String AV51TFProfesionalCorreo_Sel ,
                                 String AV52TFProfesionalCOP ,
                                 String AV53TFProfesionalCOP_Sel ,
                                 String AV54TFProfesionalColorDisponible ,
                                 String AV55TFProfesionalColorDisponible_Sel ,
                                 String AV56TFProfesionalColorCita ,
                                 String AV57TFProfesionalColorCita_Sel ,
                                 GXSimpleCollection<Byte> AV59TFProfesionalTiempoCita_Sels ,
                                 String AV60TFProfesionalDireccion ,
                                 String AV61TFProfesionalDireccion_Sel ,
                                 short AV62TFPaisId ,
                                 short AV63TFPaisId_To ,
                                 String AV64TFPaisDescripcion ,
                                 String AV65TFPaisDescripcion_Sel ,
                                 String AV66TFUbigeoCode ,
                                 String AV67TFUbigeoCode_Sel ,
                                 String AV68TFUbigeoNombre ,
                                 String AV69TFUbigeoNombre_Sel ,
                                 String AV70TFProfesionalTwitter ,
                                 String AV71TFProfesionalTwitter_Sel ,
                                 String AV72TFProfesionalFacebook ,
                                 String AV73TFProfesionalFacebook_Sel ,
                                 String AV74TFProfesionalInstagram ,
                                 String AV75TFProfesionalInstagram_Sel ,
                                 String AV76TFProfesionalLinkedin ,
                                 String AV77TFProfesionalLinkedin_Sel ,
                                 String AV78TFProfesionalTelefono ,
                                 String AV79TFProfesionalTelefono_Sel ,
                                 short AV80TFSecUserId ,
                                 short AV81TFSecUserId_To ,
                                 java.util.Date AV82TFProfesionalFechaRegistro ,
                                 java.util.Date AV83TFProfesionalFechaRegistro_To ,
                                 byte AV87TFProfesionalTerminosCondiciones_Sel ,
                                 GXSimpleCollection<String> AV89TFProfesionalEstadoCuenta_Sels ,
                                 GXSimpleCollection<String> AV91TFProfesionalEstado_Sels ,
                                 String AV160Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV97IsAuthorized_Update ,
                                 boolean AV99IsAuthorized_Delete ,
                                 boolean AV100IsAuthorized_PaisDescripcion ,
                                 boolean AV101IsAuthorized_UbigeoNombre )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e202R2 ();
      GRID_nCurrentRecord = 0 ;
      rf2R2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
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
      rf2R2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV160Pgmname = "WPPaciente" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf2R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e202R2 ();
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
                                              A173ProfesionalTipoDocumento ,
                                              AV108Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                              A177ProfesionalSexo ,
                                              AV121Wppacienteds_17_tfprofesionalsexo_sels ,
                                              Byte.valueOf(A182ProfesionalTiempoCita) ,
                                              AV132Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                              A197ProfesionalEstadoCuenta ,
                                              AV158Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                              A198ProfesionalEstado ,
                                              AV159Wppacienteds_55_tfprofesionalestado_sels ,
                                              AV105Wppacienteds_1_filterfulltext ,
                                              Integer.valueOf(AV106Wppacienteds_2_tfprofesionalid) ,
                                              Integer.valueOf(AV107Wppacienteds_3_tfprofesionalid_to) ,
                                              Integer.valueOf(AV108Wppacienteds_4_tfprofesionaltipodocumento_sels.size()) ,
                                              AV110Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                              AV109Wppacienteds_5_tfprofesionalnrodocumento ,
                                              AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                              AV111Wppacienteds_7_tfprofesionalapellidopaterno ,
                                              AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                              AV113Wppacienteds_9_tfprofesionalapellidomaterno ,
                                              AV116Wppacienteds_12_tfprofesionalnombres_sel ,
                                              AV115Wppacienteds_11_tfprofesionalnombres ,
                                              AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                              AV117Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                              AV119Wppacienteds_15_tfprofesionalfechanacimiento ,
                                              AV120Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                              Integer.valueOf(AV121Wppacienteds_17_tfprofesionalsexo_sels.size()) ,
                                              AV123Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                              AV122Wppacienteds_18_tfprofesionaldescripcion ,
                                              AV125Wppacienteds_21_tfprofesionalcorreo_sel ,
                                              AV124Wppacienteds_20_tfprofesionalcorreo ,
                                              AV127Wppacienteds_23_tfprofesionalcop_sel ,
                                              AV126Wppacienteds_22_tfprofesionalcop ,
                                              AV129Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                              AV128Wppacienteds_24_tfprofesionalcolordisponible ,
                                              AV131Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                              AV130Wppacienteds_26_tfprofesionalcolorcita ,
                                              Integer.valueOf(AV132Wppacienteds_28_tfprofesionaltiempocita_sels.size()) ,
                                              AV134Wppacienteds_30_tfprofesionaldireccion_sel ,
                                              AV133Wppacienteds_29_tfprofesionaldireccion ,
                                              Short.valueOf(AV135Wppacienteds_31_tfpaisid) ,
                                              Short.valueOf(AV136Wppacienteds_32_tfpaisid_to) ,
                                              AV138Wppacienteds_34_tfpaisdescripcion_sel ,
                                              AV137Wppacienteds_33_tfpaisdescripcion ,
                                              AV140Wppacienteds_36_tfubigeocode_sel ,
                                              AV139Wppacienteds_35_tfubigeocode ,
                                              AV142Wppacienteds_38_tfubigeonombre_sel ,
                                              AV141Wppacienteds_37_tfubigeonombre ,
                                              AV144Wppacienteds_40_tfprofesionaltwitter_sel ,
                                              AV143Wppacienteds_39_tfprofesionaltwitter ,
                                              AV146Wppacienteds_42_tfprofesionalfacebook_sel ,
                                              AV145Wppacienteds_41_tfprofesionalfacebook ,
                                              AV148Wppacienteds_44_tfprofesionalinstagram_sel ,
                                              AV147Wppacienteds_43_tfprofesionalinstagram ,
                                              AV150Wppacienteds_46_tfprofesionallinkedin_sel ,
                                              AV149Wppacienteds_45_tfprofesionallinkedin ,
                                              AV152Wppacienteds_48_tfprofesionaltelefono_sel ,
                                              AV151Wppacienteds_47_tfprofesionaltelefono ,
                                              Short.valueOf(AV153Wppacienteds_49_tfsecuserid) ,
                                              Short.valueOf(AV154Wppacienteds_50_tfsecuserid_to) ,
                                              AV155Wppacienteds_51_tfprofesionalfecharegistro ,
                                              AV156Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                              Byte.valueOf(AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel) ,
                                              Integer.valueOf(AV158Wppacienteds_54_tfprofesionalestadocuenta_sels.size()) ,
                                              Integer.valueOf(AV159Wppacienteds_55_tfprofesionalestado_sels.size()) ,
                                              Integer.valueOf(A31ProfesionalId) ,
                                              A174ProfesionalNroDocumento ,
                                              A85ProfesionalApellidoPaterno ,
                                              A86ProfesionalApellidoMaterno ,
                                              A84ProfesionalNombres ,
                                              A178ProfesionalDescripcion ,
                                              A179ProfesionalCorreo ,
                                              A88ProfesionalCOP ,
                                              A180ProfesionalColorDisponible ,
                                              A181ProfesionalColorCita ,
                                              A183ProfesionalDireccion ,
                                              Short.valueOf(A43PaisId) ,
                                              A184PaisDescripcion ,
                                              A44UbigeoCode ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito ,
                                              A190ProfesionalTwitter ,
                                              A191ProfesionalFacebook ,
                                              A192ProfesionalInstagram ,
                                              A193ProfesionalLinkedin ,
                                              A194ProfesionalTelefono ,
                                              Short.valueOf(A6SecUserId) ,
                                              A176ProfesionalFechaNacimiento ,
                                              A195ProfesionalFechaRegistro ,
                                              Boolean.valueOf(A196ProfesionalTerminosCondiciones) ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
         lV109Wppacienteds_5_tfprofesionalnrodocumento = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_5_tfprofesionalnrodocumento), "%", "") ;
         lV111Wppacienteds_7_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV111Wppacienteds_7_tfprofesionalapellidopaterno), "%", "") ;
         lV113Wppacienteds_9_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV113Wppacienteds_9_tfprofesionalapellidomaterno), "%", "") ;
         lV115Wppacienteds_11_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV115Wppacienteds_11_tfprofesionalnombres), "%", "") ;
         lV117Wppacienteds_13_tfprofesionalnombrecompleto2 = GXutil.concat( GXutil.rtrim( AV117Wppacienteds_13_tfprofesionalnombrecompleto2), "%", "") ;
         lV122Wppacienteds_18_tfprofesionaldescripcion = GXutil.concat( GXutil.rtrim( AV122Wppacienteds_18_tfprofesionaldescripcion), "%", "") ;
         lV124Wppacienteds_20_tfprofesionalcorreo = GXutil.concat( GXutil.rtrim( AV124Wppacienteds_20_tfprofesionalcorreo), "%", "") ;
         lV126Wppacienteds_22_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_22_tfprofesionalcop), "%", "") ;
         lV128Wppacienteds_24_tfprofesionalcolordisponible = GXutil.padr( GXutil.rtrim( AV128Wppacienteds_24_tfprofesionalcolordisponible), 20, "%") ;
         lV130Wppacienteds_26_tfprofesionalcolorcita = GXutil.padr( GXutil.rtrim( AV130Wppacienteds_26_tfprofesionalcolorcita), 20, "%") ;
         lV133Wppacienteds_29_tfprofesionaldireccion = GXutil.concat( GXutil.rtrim( AV133Wppacienteds_29_tfprofesionaldireccion), "%", "") ;
         lV137Wppacienteds_33_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV137Wppacienteds_33_tfpaisdescripcion), "%", "") ;
         lV139Wppacienteds_35_tfubigeocode = GXutil.padr( GXutil.rtrim( AV139Wppacienteds_35_tfubigeocode), 10, "%") ;
         lV141Wppacienteds_37_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV141Wppacienteds_37_tfubigeonombre), "%", "") ;
         lV143Wppacienteds_39_tfprofesionaltwitter = GXutil.concat( GXutil.rtrim( AV143Wppacienteds_39_tfprofesionaltwitter), "%", "") ;
         lV145Wppacienteds_41_tfprofesionalfacebook = GXutil.concat( GXutil.rtrim( AV145Wppacienteds_41_tfprofesionalfacebook), "%", "") ;
         lV147Wppacienteds_43_tfprofesionalinstagram = GXutil.concat( GXutil.rtrim( AV147Wppacienteds_43_tfprofesionalinstagram), "%", "") ;
         lV149Wppacienteds_45_tfprofesionallinkedin = GXutil.concat( GXutil.rtrim( AV149Wppacienteds_45_tfprofesionallinkedin), "%", "") ;
         lV151Wppacienteds_47_tfprofesionaltelefono = GXutil.padr( GXutil.rtrim( AV151Wppacienteds_47_tfprofesionaltelefono), 20, "%") ;
         /* Using cursor H002R2 */
         pr_default.execute(0, new Object[] {lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, Integer.valueOf(AV106Wppacienteds_2_tfprofesionalid), Integer.valueOf(AV107Wppacienteds_3_tfprofesionalid_to), lV109Wppacienteds_5_tfprofesionalnrodocumento, AV110Wppacienteds_6_tfprofesionalnrodocumento_sel, lV111Wppacienteds_7_tfprofesionalapellidopaterno, AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel, lV113Wppacienteds_9_tfprofesionalapellidomaterno, AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel, lV115Wppacienteds_11_tfprofesionalnombres, AV116Wppacienteds_12_tfprofesionalnombres_sel, lV117Wppacienteds_13_tfprofesionalnombrecompleto2, AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel, AV119Wppacienteds_15_tfprofesionalfechanacimiento, AV120Wppacienteds_16_tfprofesionalfechanacimiento_to, lV122Wppacienteds_18_tfprofesionaldescripcion, AV123Wppacienteds_19_tfprofesionaldescripcion_sel, lV124Wppacienteds_20_tfprofesionalcorreo, AV125Wppacienteds_21_tfprofesionalcorreo_sel, lV126Wppacienteds_22_tfprofesionalcop, AV127Wppacienteds_23_tfprofesionalcop_sel, lV128Wppacienteds_24_tfprofesionalcolordisponible, AV129Wppacienteds_25_tfprofesionalcolordisponible_sel, lV130Wppacienteds_26_tfprofesionalcolorcita, AV131Wppacienteds_27_tfprofesionalcolorcita_sel, lV133Wppacienteds_29_tfprofesionaldireccion, AV134Wppacienteds_30_tfprofesionaldireccion_sel, Short.valueOf(AV135Wppacienteds_31_tfpaisid), Short.valueOf(AV136Wppacienteds_32_tfpaisid_to), lV137Wppacienteds_33_tfpaisdescripcion, AV138Wppacienteds_34_tfpaisdescripcion_sel, lV139Wppacienteds_35_tfubigeocode, AV140Wppacienteds_36_tfubigeocode_sel, lV141Wppacienteds_37_tfubigeonombre, AV142Wppacienteds_38_tfubigeonombre_sel, lV143Wppacienteds_39_tfprofesionaltwitter, AV144Wppacienteds_40_tfprofesionaltwitter_sel, lV145Wppacienteds_41_tfprofesionalfacebook, AV146Wppacienteds_42_tfprofesionalfacebook_sel, lV147Wppacienteds_43_tfprofesionalinstagram, AV148Wppacienteds_44_tfprofesionalinstagram_sel, lV149Wppacienteds_45_tfprofesionallinkedin, AV150Wppacienteds_46_tfprofesionallinkedin_sel, lV151Wppacienteds_47_tfprofesionaltelefono, AV152Wppacienteds_48_tfprofesionaltelefono_sel, Short.valueOf(AV153Wppacienteds_49_tfsecuserid), Short.valueOf(AV154Wppacienteds_50_tfsecuserid_to), AV155Wppacienteds_51_tfprofesionalfecharegistro, AV156Wppacienteds_52_tfprofesionalfecharegistro_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A198ProfesionalEstado = H002R2_A198ProfesionalEstado[0] ;
            A197ProfesionalEstadoCuenta = H002R2_A197ProfesionalEstadoCuenta[0] ;
            A196ProfesionalTerminosCondiciones = H002R2_A196ProfesionalTerminosCondiciones[0] ;
            A195ProfesionalFechaRegistro = H002R2_A195ProfesionalFechaRegistro[0] ;
            A6SecUserId = H002R2_A6SecUserId[0] ;
            A194ProfesionalTelefono = H002R2_A194ProfesionalTelefono[0] ;
            A193ProfesionalLinkedin = H002R2_A193ProfesionalLinkedin[0] ;
            A192ProfesionalInstagram = H002R2_A192ProfesionalInstagram[0] ;
            A191ProfesionalFacebook = H002R2_A191ProfesionalFacebook[0] ;
            A190ProfesionalTwitter = H002R2_A190ProfesionalTwitter[0] ;
            A189ProfesionalFoto = H002R2_A189ProfesionalFoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
            A40000ProfesionalFoto_GXI = H002R2_A40000ProfesionalFoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
            A44UbigeoCode = H002R2_A44UbigeoCode[0] ;
            A184PaisDescripcion = H002R2_A184PaisDescripcion[0] ;
            A43PaisId = H002R2_A43PaisId[0] ;
            A183ProfesionalDireccion = H002R2_A183ProfesionalDireccion[0] ;
            A182ProfesionalTiempoCita = H002R2_A182ProfesionalTiempoCita[0] ;
            A181ProfesionalColorCita = H002R2_A181ProfesionalColorCita[0] ;
            A180ProfesionalColorDisponible = H002R2_A180ProfesionalColorDisponible[0] ;
            A88ProfesionalCOP = H002R2_A88ProfesionalCOP[0] ;
            A179ProfesionalCorreo = H002R2_A179ProfesionalCorreo[0] ;
            A178ProfesionalDescripcion = H002R2_A178ProfesionalDescripcion[0] ;
            A177ProfesionalSexo = H002R2_A177ProfesionalSexo[0] ;
            A176ProfesionalFechaNacimiento = H002R2_A176ProfesionalFechaNacimiento[0] ;
            A174ProfesionalNroDocumento = H002R2_A174ProfesionalNroDocumento[0] ;
            A173ProfesionalTipoDocumento = H002R2_A173ProfesionalTipoDocumento[0] ;
            A31ProfesionalId = H002R2_A31ProfesionalId[0] ;
            A84ProfesionalNombres = H002R2_A84ProfesionalNombres[0] ;
            A86ProfesionalApellidoMaterno = H002R2_A86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = H002R2_A85ProfesionalApellidoPaterno[0] ;
            A188UbigeoDistrito = H002R2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H002R2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H002R2_A186UbigeoDepartamento[0] ;
            A188UbigeoDistrito = H002R2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H002R2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H002R2_A186UbigeoDepartamento[0] ;
            A184PaisDescripcion = H002R2_A184PaisDescripcion[0] ;
            A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
            A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
            e212R2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb2R0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2R2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV160Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV160Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV97IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV97IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV99IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV99IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_PAISDESCRIPCION", AV100IsAuthorized_PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV100IsAuthorized_PaisDescripcion));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UBIGEONOMBRE", AV101IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV101IsAuthorized_UbigeoNombre));
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
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A173ProfesionalTipoDocumento ,
                                           AV108Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                           A177ProfesionalSexo ,
                                           AV121Wppacienteds_17_tfprofesionalsexo_sels ,
                                           Byte.valueOf(A182ProfesionalTiempoCita) ,
                                           AV132Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                           A197ProfesionalEstadoCuenta ,
                                           AV158Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                           A198ProfesionalEstado ,
                                           AV159Wppacienteds_55_tfprofesionalestado_sels ,
                                           AV105Wppacienteds_1_filterfulltext ,
                                           Integer.valueOf(AV106Wppacienteds_2_tfprofesionalid) ,
                                           Integer.valueOf(AV107Wppacienteds_3_tfprofesionalid_to) ,
                                           Integer.valueOf(AV108Wppacienteds_4_tfprofesionaltipodocumento_sels.size()) ,
                                           AV110Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                           AV109Wppacienteds_5_tfprofesionalnrodocumento ,
                                           AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                           AV111Wppacienteds_7_tfprofesionalapellidopaterno ,
                                           AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                           AV113Wppacienteds_9_tfprofesionalapellidomaterno ,
                                           AV116Wppacienteds_12_tfprofesionalnombres_sel ,
                                           AV115Wppacienteds_11_tfprofesionalnombres ,
                                           AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                           AV117Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                           AV119Wppacienteds_15_tfprofesionalfechanacimiento ,
                                           AV120Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                           Integer.valueOf(AV121Wppacienteds_17_tfprofesionalsexo_sels.size()) ,
                                           AV123Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                           AV122Wppacienteds_18_tfprofesionaldescripcion ,
                                           AV125Wppacienteds_21_tfprofesionalcorreo_sel ,
                                           AV124Wppacienteds_20_tfprofesionalcorreo ,
                                           AV127Wppacienteds_23_tfprofesionalcop_sel ,
                                           AV126Wppacienteds_22_tfprofesionalcop ,
                                           AV129Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                           AV128Wppacienteds_24_tfprofesionalcolordisponible ,
                                           AV131Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                           AV130Wppacienteds_26_tfprofesionalcolorcita ,
                                           Integer.valueOf(AV132Wppacienteds_28_tfprofesionaltiempocita_sels.size()) ,
                                           AV134Wppacienteds_30_tfprofesionaldireccion_sel ,
                                           AV133Wppacienteds_29_tfprofesionaldireccion ,
                                           Short.valueOf(AV135Wppacienteds_31_tfpaisid) ,
                                           Short.valueOf(AV136Wppacienteds_32_tfpaisid_to) ,
                                           AV138Wppacienteds_34_tfpaisdescripcion_sel ,
                                           AV137Wppacienteds_33_tfpaisdescripcion ,
                                           AV140Wppacienteds_36_tfubigeocode_sel ,
                                           AV139Wppacienteds_35_tfubigeocode ,
                                           AV142Wppacienteds_38_tfubigeonombre_sel ,
                                           AV141Wppacienteds_37_tfubigeonombre ,
                                           AV144Wppacienteds_40_tfprofesionaltwitter_sel ,
                                           AV143Wppacienteds_39_tfprofesionaltwitter ,
                                           AV146Wppacienteds_42_tfprofesionalfacebook_sel ,
                                           AV145Wppacienteds_41_tfprofesionalfacebook ,
                                           AV148Wppacienteds_44_tfprofesionalinstagram_sel ,
                                           AV147Wppacienteds_43_tfprofesionalinstagram ,
                                           AV150Wppacienteds_46_tfprofesionallinkedin_sel ,
                                           AV149Wppacienteds_45_tfprofesionallinkedin ,
                                           AV152Wppacienteds_48_tfprofesionaltelefono_sel ,
                                           AV151Wppacienteds_47_tfprofesionaltelefono ,
                                           Short.valueOf(AV153Wppacienteds_49_tfsecuserid) ,
                                           Short.valueOf(AV154Wppacienteds_50_tfsecuserid_to) ,
                                           AV155Wppacienteds_51_tfprofesionalfecharegistro ,
                                           AV156Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                           Byte.valueOf(AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel) ,
                                           Integer.valueOf(AV158Wppacienteds_54_tfprofesionalestadocuenta_sels.size()) ,
                                           Integer.valueOf(AV159Wppacienteds_55_tfprofesionalestado_sels.size()) ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A174ProfesionalNroDocumento ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A178ProfesionalDescripcion ,
                                           A179ProfesionalCorreo ,
                                           A88ProfesionalCOP ,
                                           A180ProfesionalColorDisponible ,
                                           A181ProfesionalColorCita ,
                                           A183ProfesionalDireccion ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A190ProfesionalTwitter ,
                                           A191ProfesionalFacebook ,
                                           A192ProfesionalInstagram ,
                                           A193ProfesionalLinkedin ,
                                           A194ProfesionalTelefono ,
                                           Short.valueOf(A6SecUserId) ,
                                           A176ProfesionalFechaNacimiento ,
                                           A195ProfesionalFechaRegistro ,
                                           Boolean.valueOf(A196ProfesionalTerminosCondiciones) ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV105Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_5_tfprofesionalnrodocumento = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_5_tfprofesionalnrodocumento), "%", "") ;
      lV111Wppacienteds_7_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV111Wppacienteds_7_tfprofesionalapellidopaterno), "%", "") ;
      lV113Wppacienteds_9_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV113Wppacienteds_9_tfprofesionalapellidomaterno), "%", "") ;
      lV115Wppacienteds_11_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV115Wppacienteds_11_tfprofesionalnombres), "%", "") ;
      lV117Wppacienteds_13_tfprofesionalnombrecompleto2 = GXutil.concat( GXutil.rtrim( AV117Wppacienteds_13_tfprofesionalnombrecompleto2), "%", "") ;
      lV122Wppacienteds_18_tfprofesionaldescripcion = GXutil.concat( GXutil.rtrim( AV122Wppacienteds_18_tfprofesionaldescripcion), "%", "") ;
      lV124Wppacienteds_20_tfprofesionalcorreo = GXutil.concat( GXutil.rtrim( AV124Wppacienteds_20_tfprofesionalcorreo), "%", "") ;
      lV126Wppacienteds_22_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_22_tfprofesionalcop), "%", "") ;
      lV128Wppacienteds_24_tfprofesionalcolordisponible = GXutil.padr( GXutil.rtrim( AV128Wppacienteds_24_tfprofesionalcolordisponible), 20, "%") ;
      lV130Wppacienteds_26_tfprofesionalcolorcita = GXutil.padr( GXutil.rtrim( AV130Wppacienteds_26_tfprofesionalcolorcita), 20, "%") ;
      lV133Wppacienteds_29_tfprofesionaldireccion = GXutil.concat( GXutil.rtrim( AV133Wppacienteds_29_tfprofesionaldireccion), "%", "") ;
      lV137Wppacienteds_33_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV137Wppacienteds_33_tfpaisdescripcion), "%", "") ;
      lV139Wppacienteds_35_tfubigeocode = GXutil.padr( GXutil.rtrim( AV139Wppacienteds_35_tfubigeocode), 10, "%") ;
      lV141Wppacienteds_37_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV141Wppacienteds_37_tfubigeonombre), "%", "") ;
      lV143Wppacienteds_39_tfprofesionaltwitter = GXutil.concat( GXutil.rtrim( AV143Wppacienteds_39_tfprofesionaltwitter), "%", "") ;
      lV145Wppacienteds_41_tfprofesionalfacebook = GXutil.concat( GXutil.rtrim( AV145Wppacienteds_41_tfprofesionalfacebook), "%", "") ;
      lV147Wppacienteds_43_tfprofesionalinstagram = GXutil.concat( GXutil.rtrim( AV147Wppacienteds_43_tfprofesionalinstagram), "%", "") ;
      lV149Wppacienteds_45_tfprofesionallinkedin = GXutil.concat( GXutil.rtrim( AV149Wppacienteds_45_tfprofesionallinkedin), "%", "") ;
      lV151Wppacienteds_47_tfprofesionaltelefono = GXutil.padr( GXutil.rtrim( AV151Wppacienteds_47_tfprofesionaltelefono), 20, "%") ;
      /* Using cursor H002R3 */
      pr_default.execute(1, new Object[] {lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, lV105Wppacienteds_1_filterfulltext, Integer.valueOf(AV106Wppacienteds_2_tfprofesionalid), Integer.valueOf(AV107Wppacienteds_3_tfprofesionalid_to), lV109Wppacienteds_5_tfprofesionalnrodocumento, AV110Wppacienteds_6_tfprofesionalnrodocumento_sel, lV111Wppacienteds_7_tfprofesionalapellidopaterno, AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel, lV113Wppacienteds_9_tfprofesionalapellidomaterno, AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel, lV115Wppacienteds_11_tfprofesionalnombres, AV116Wppacienteds_12_tfprofesionalnombres_sel, lV117Wppacienteds_13_tfprofesionalnombrecompleto2, AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel, AV119Wppacienteds_15_tfprofesionalfechanacimiento, AV120Wppacienteds_16_tfprofesionalfechanacimiento_to, lV122Wppacienteds_18_tfprofesionaldescripcion, AV123Wppacienteds_19_tfprofesionaldescripcion_sel, lV124Wppacienteds_20_tfprofesionalcorreo, AV125Wppacienteds_21_tfprofesionalcorreo_sel, lV126Wppacienteds_22_tfprofesionalcop, AV127Wppacienteds_23_tfprofesionalcop_sel, lV128Wppacienteds_24_tfprofesionalcolordisponible, AV129Wppacienteds_25_tfprofesionalcolordisponible_sel, lV130Wppacienteds_26_tfprofesionalcolorcita, AV131Wppacienteds_27_tfprofesionalcolorcita_sel, lV133Wppacienteds_29_tfprofesionaldireccion, AV134Wppacienteds_30_tfprofesionaldireccion_sel, Short.valueOf(AV135Wppacienteds_31_tfpaisid), Short.valueOf(AV136Wppacienteds_32_tfpaisid_to), lV137Wppacienteds_33_tfpaisdescripcion, AV138Wppacienteds_34_tfpaisdescripcion_sel, lV139Wppacienteds_35_tfubigeocode, AV140Wppacienteds_36_tfubigeocode_sel, lV141Wppacienteds_37_tfubigeonombre, AV142Wppacienteds_38_tfubigeonombre_sel, lV143Wppacienteds_39_tfprofesionaltwitter, AV144Wppacienteds_40_tfprofesionaltwitter_sel, lV145Wppacienteds_41_tfprofesionalfacebook, AV146Wppacienteds_42_tfprofesionalfacebook_sel, lV147Wppacienteds_43_tfprofesionalinstagram, AV148Wppacienteds_44_tfprofesionalinstagram_sel, lV149Wppacienteds_45_tfprofesionallinkedin, AV150Wppacienteds_46_tfprofesionallinkedin_sel, lV151Wppacienteds_47_tfprofesionaltelefono, AV152Wppacienteds_48_tfprofesionaltelefono_sel, Short.valueOf(AV153Wppacienteds_49_tfsecuserid), Short.valueOf(AV154Wppacienteds_50_tfsecuserid_to), AV155Wppacienteds_51_tfprofesionalfecharegistro, AV156Wppacienteds_52_tfprofesionalfecharegistro_to});
      GRID_nRecordCount = H002R3_AGRID_nRecordCount[0] ;
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
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFProfesionalId, AV28TFProfesionalId_To, AV30TFProfesionalTipoDocumento_Sels, AV31TFProfesionalNroDocumento, AV32TFProfesionalNroDocumento_Sel, AV33TFProfesionalApellidoPaterno, AV34TFProfesionalApellidoPaterno_Sel, AV35TFProfesionalApellidoMaterno, AV36TFProfesionalApellidoMaterno_Sel, AV37TFProfesionalNombres, AV38TFProfesionalNombres_Sel, AV39TFProfesionalNombreCompleto2, AV40TFProfesionalNombreCompleto2_Sel, AV41TFProfesionalFechaNacimiento, AV42TFProfesionalFechaNacimiento_To, AV47TFProfesionalSexo_Sels, AV48TFProfesionalDescripcion, AV49TFProfesionalDescripcion_Sel, AV50TFProfesionalCorreo, AV51TFProfesionalCorreo_Sel, AV52TFProfesionalCOP, AV53TFProfesionalCOP_Sel, AV54TFProfesionalColorDisponible, AV55TFProfesionalColorDisponible_Sel, AV56TFProfesionalColorCita, AV57TFProfesionalColorCita_Sel, AV59TFProfesionalTiempoCita_Sels, AV60TFProfesionalDireccion, AV61TFProfesionalDireccion_Sel, AV62TFPaisId, AV63TFPaisId_To, AV64TFPaisDescripcion, AV65TFPaisDescripcion_Sel, AV66TFUbigeoCode, AV67TFUbigeoCode_Sel, AV68TFUbigeoNombre, AV69TFUbigeoNombre_Sel, AV70TFProfesionalTwitter, AV71TFProfesionalTwitter_Sel, AV72TFProfesionalFacebook, AV73TFProfesionalFacebook_Sel, AV74TFProfesionalInstagram, AV75TFProfesionalInstagram_Sel, AV76TFProfesionalLinkedin, AV77TFProfesionalLinkedin_Sel, AV78TFProfesionalTelefono, AV79TFProfesionalTelefono_Sel, AV80TFSecUserId, AV81TFSecUserId_To, AV82TFProfesionalFechaRegistro, AV83TFProfesionalFechaRegistro_To, AV87TFProfesionalTerminosCondiciones_Sel, AV89TFProfesionalEstadoCuenta_Sels, AV91TFProfesionalEstado_Sels, AV160Pgmname, AV13OrderedBy, AV14OrderedDsc, AV97IsAuthorized_Update, AV99IsAuthorized_Delete, AV100IsAuthorized_PaisDescripcion, AV101IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFProfesionalId, AV28TFProfesionalId_To, AV30TFProfesionalTipoDocumento_Sels, AV31TFProfesionalNroDocumento, AV32TFProfesionalNroDocumento_Sel, AV33TFProfesionalApellidoPaterno, AV34TFProfesionalApellidoPaterno_Sel, AV35TFProfesionalApellidoMaterno, AV36TFProfesionalApellidoMaterno_Sel, AV37TFProfesionalNombres, AV38TFProfesionalNombres_Sel, AV39TFProfesionalNombreCompleto2, AV40TFProfesionalNombreCompleto2_Sel, AV41TFProfesionalFechaNacimiento, AV42TFProfesionalFechaNacimiento_To, AV47TFProfesionalSexo_Sels, AV48TFProfesionalDescripcion, AV49TFProfesionalDescripcion_Sel, AV50TFProfesionalCorreo, AV51TFProfesionalCorreo_Sel, AV52TFProfesionalCOP, AV53TFProfesionalCOP_Sel, AV54TFProfesionalColorDisponible, AV55TFProfesionalColorDisponible_Sel, AV56TFProfesionalColorCita, AV57TFProfesionalColorCita_Sel, AV59TFProfesionalTiempoCita_Sels, AV60TFProfesionalDireccion, AV61TFProfesionalDireccion_Sel, AV62TFPaisId, AV63TFPaisId_To, AV64TFPaisDescripcion, AV65TFPaisDescripcion_Sel, AV66TFUbigeoCode, AV67TFUbigeoCode_Sel, AV68TFUbigeoNombre, AV69TFUbigeoNombre_Sel, AV70TFProfesionalTwitter, AV71TFProfesionalTwitter_Sel, AV72TFProfesionalFacebook, AV73TFProfesionalFacebook_Sel, AV74TFProfesionalInstagram, AV75TFProfesionalInstagram_Sel, AV76TFProfesionalLinkedin, AV77TFProfesionalLinkedin_Sel, AV78TFProfesionalTelefono, AV79TFProfesionalTelefono_Sel, AV80TFSecUserId, AV81TFSecUserId_To, AV82TFProfesionalFechaRegistro, AV83TFProfesionalFechaRegistro_To, AV87TFProfesionalTerminosCondiciones_Sel, AV89TFProfesionalEstadoCuenta_Sels, AV91TFProfesionalEstado_Sels, AV160Pgmname, AV13OrderedBy, AV14OrderedDsc, AV97IsAuthorized_Update, AV99IsAuthorized_Delete, AV100IsAuthorized_PaisDescripcion, AV101IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFProfesionalId, AV28TFProfesionalId_To, AV30TFProfesionalTipoDocumento_Sels, AV31TFProfesionalNroDocumento, AV32TFProfesionalNroDocumento_Sel, AV33TFProfesionalApellidoPaterno, AV34TFProfesionalApellidoPaterno_Sel, AV35TFProfesionalApellidoMaterno, AV36TFProfesionalApellidoMaterno_Sel, AV37TFProfesionalNombres, AV38TFProfesionalNombres_Sel, AV39TFProfesionalNombreCompleto2, AV40TFProfesionalNombreCompleto2_Sel, AV41TFProfesionalFechaNacimiento, AV42TFProfesionalFechaNacimiento_To, AV47TFProfesionalSexo_Sels, AV48TFProfesionalDescripcion, AV49TFProfesionalDescripcion_Sel, AV50TFProfesionalCorreo, AV51TFProfesionalCorreo_Sel, AV52TFProfesionalCOP, AV53TFProfesionalCOP_Sel, AV54TFProfesionalColorDisponible, AV55TFProfesionalColorDisponible_Sel, AV56TFProfesionalColorCita, AV57TFProfesionalColorCita_Sel, AV59TFProfesionalTiempoCita_Sels, AV60TFProfesionalDireccion, AV61TFProfesionalDireccion_Sel, AV62TFPaisId, AV63TFPaisId_To, AV64TFPaisDescripcion, AV65TFPaisDescripcion_Sel, AV66TFUbigeoCode, AV67TFUbigeoCode_Sel, AV68TFUbigeoNombre, AV69TFUbigeoNombre_Sel, AV70TFProfesionalTwitter, AV71TFProfesionalTwitter_Sel, AV72TFProfesionalFacebook, AV73TFProfesionalFacebook_Sel, AV74TFProfesionalInstagram, AV75TFProfesionalInstagram_Sel, AV76TFProfesionalLinkedin, AV77TFProfesionalLinkedin_Sel, AV78TFProfesionalTelefono, AV79TFProfesionalTelefono_Sel, AV80TFSecUserId, AV81TFSecUserId_To, AV82TFProfesionalFechaRegistro, AV83TFProfesionalFechaRegistro_To, AV87TFProfesionalTerminosCondiciones_Sel, AV89TFProfesionalEstadoCuenta_Sels, AV91TFProfesionalEstado_Sels, AV160Pgmname, AV13OrderedBy, AV14OrderedDsc, AV97IsAuthorized_Update, AV99IsAuthorized_Delete, AV100IsAuthorized_PaisDescripcion, AV101IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFProfesionalId, AV28TFProfesionalId_To, AV30TFProfesionalTipoDocumento_Sels, AV31TFProfesionalNroDocumento, AV32TFProfesionalNroDocumento_Sel, AV33TFProfesionalApellidoPaterno, AV34TFProfesionalApellidoPaterno_Sel, AV35TFProfesionalApellidoMaterno, AV36TFProfesionalApellidoMaterno_Sel, AV37TFProfesionalNombres, AV38TFProfesionalNombres_Sel, AV39TFProfesionalNombreCompleto2, AV40TFProfesionalNombreCompleto2_Sel, AV41TFProfesionalFechaNacimiento, AV42TFProfesionalFechaNacimiento_To, AV47TFProfesionalSexo_Sels, AV48TFProfesionalDescripcion, AV49TFProfesionalDescripcion_Sel, AV50TFProfesionalCorreo, AV51TFProfesionalCorreo_Sel, AV52TFProfesionalCOP, AV53TFProfesionalCOP_Sel, AV54TFProfesionalColorDisponible, AV55TFProfesionalColorDisponible_Sel, AV56TFProfesionalColorCita, AV57TFProfesionalColorCita_Sel, AV59TFProfesionalTiempoCita_Sels, AV60TFProfesionalDireccion, AV61TFProfesionalDireccion_Sel, AV62TFPaisId, AV63TFPaisId_To, AV64TFPaisDescripcion, AV65TFPaisDescripcion_Sel, AV66TFUbigeoCode, AV67TFUbigeoCode_Sel, AV68TFUbigeoNombre, AV69TFUbigeoNombre_Sel, AV70TFProfesionalTwitter, AV71TFProfesionalTwitter_Sel, AV72TFProfesionalFacebook, AV73TFProfesionalFacebook_Sel, AV74TFProfesionalInstagram, AV75TFProfesionalInstagram_Sel, AV76TFProfesionalLinkedin, AV77TFProfesionalLinkedin_Sel, AV78TFProfesionalTelefono, AV79TFProfesionalTelefono_Sel, AV80TFSecUserId, AV81TFSecUserId_To, AV82TFProfesionalFechaRegistro, AV83TFProfesionalFechaRegistro_To, AV87TFProfesionalTerminosCondiciones_Sel, AV89TFProfesionalEstadoCuenta_Sels, AV91TFProfesionalEstado_Sels, AV160Pgmname, AV13OrderedBy, AV14OrderedDsc, AV97IsAuthorized_Update, AV99IsAuthorized_Delete, AV100IsAuthorized_PaisDescripcion, AV101IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFProfesionalId, AV28TFProfesionalId_To, AV30TFProfesionalTipoDocumento_Sels, AV31TFProfesionalNroDocumento, AV32TFProfesionalNroDocumento_Sel, AV33TFProfesionalApellidoPaterno, AV34TFProfesionalApellidoPaterno_Sel, AV35TFProfesionalApellidoMaterno, AV36TFProfesionalApellidoMaterno_Sel, AV37TFProfesionalNombres, AV38TFProfesionalNombres_Sel, AV39TFProfesionalNombreCompleto2, AV40TFProfesionalNombreCompleto2_Sel, AV41TFProfesionalFechaNacimiento, AV42TFProfesionalFechaNacimiento_To, AV47TFProfesionalSexo_Sels, AV48TFProfesionalDescripcion, AV49TFProfesionalDescripcion_Sel, AV50TFProfesionalCorreo, AV51TFProfesionalCorreo_Sel, AV52TFProfesionalCOP, AV53TFProfesionalCOP_Sel, AV54TFProfesionalColorDisponible, AV55TFProfesionalColorDisponible_Sel, AV56TFProfesionalColorCita, AV57TFProfesionalColorCita_Sel, AV59TFProfesionalTiempoCita_Sels, AV60TFProfesionalDireccion, AV61TFProfesionalDireccion_Sel, AV62TFPaisId, AV63TFPaisId_To, AV64TFPaisDescripcion, AV65TFPaisDescripcion_Sel, AV66TFUbigeoCode, AV67TFUbigeoCode_Sel, AV68TFUbigeoNombre, AV69TFUbigeoNombre_Sel, AV70TFProfesionalTwitter, AV71TFProfesionalTwitter_Sel, AV72TFProfesionalFacebook, AV73TFProfesionalFacebook_Sel, AV74TFProfesionalInstagram, AV75TFProfesionalInstagram_Sel, AV76TFProfesionalLinkedin, AV77TFProfesionalLinkedin_Sel, AV78TFProfesionalTelefono, AV79TFProfesionalTelefono_Sel, AV80TFSecUserId, AV81TFSecUserId_To, AV82TFProfesionalFechaRegistro, AV83TFProfesionalFechaRegistro_To, AV87TFProfesionalTerminosCondiciones_Sel, AV89TFProfesionalEstadoCuenta_Sels, AV91TFProfesionalEstado_Sels, AV160Pgmname, AV13OrderedBy, AV14OrderedDsc, AV97IsAuthorized_Update, AV99IsAuthorized_Delete, AV100IsAuthorized_PaisDescripcion, AV101IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV160Pgmname = "WPPaciente" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e192R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV92DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV94GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV95GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV43DDO_ProfesionalFechaNacimientoAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_PROFESIONALFECHANACIMIENTOAUXDATE"), 0) ;
         AV44DDO_ProfesionalFechaNacimientoAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_PROFESIONALFECHANACIMIENTOAUXDATETO"), 0) ;
         AV84DDO_ProfesionalFechaRegistroAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_PROFESIONALFECHAREGISTROAUXDATE"), 0) ;
         AV85DDO_ProfesionalFechaRegistroAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_PROFESIONALFECHAREGISTROAUXDATETO"), 0) ;
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
         AV45DDO_ProfesionalFechaNacimientoAuxDateText = httpContext.cgiGet( edtavDdo_profesionalfechanacimientoauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45DDO_ProfesionalFechaNacimientoAuxDateText", AV45DDO_ProfesionalFechaNacimientoAuxDateText);
         AV86DDO_ProfesionalFechaRegistroAuxDateText = httpContext.cgiGet( edtavDdo_profesionalfecharegistroauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV86DDO_ProfesionalFechaRegistroAuxDateText", AV86DDO_ProfesionalFechaRegistroAuxDateText);
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
      e192R2 ();
      if (returnInSub) return;
   }

   public void e192R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFPROFESIONALFECHAREGISTRO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_profesionalfecharegistroauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFPROFESIONALFECHANACIMIENTO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_profesionalfechanacimientoauxdatetext_Internalname});
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
      GXt_boolean1 = AV100IsAuthorized_PaisDescripcion ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais", GXv_boolean2) ;
      wppaciente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV100IsAuthorized_PaisDescripcion = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100IsAuthorized_PaisDescripcion", AV100IsAuthorized_PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_PAISDESCRIPCION", getSecureSignedToken( "", AV100IsAuthorized_PaisDescripcion));
      GXt_boolean1 = AV101IsAuthorized_UbigeoNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean2) ;
      wppaciente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV101IsAuthorized_UbigeoNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV101IsAuthorized_UbigeoNombre", AV101IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV101IsAuthorized_UbigeoNombre));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Profesional" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV92DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV92DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e202R2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("WPPacienteColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("WPPacienteColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtProfesionalId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbProfesionalTipoDocumento.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTipoDocumento.getInternalname(), "Visible", GXutil.ltrimstr( cmbProfesionalTipoDocumento.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalNroDocumento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNroDocumento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNroDocumento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalApellidoPaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoPaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoPaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalApellidoMaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoMaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoMaterno_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalNombres_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombres_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalNombreCompleto2_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombreCompleto2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombreCompleto2_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalFechaNacimiento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFechaNacimiento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFechaNacimiento_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbProfesionalSexo.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalSexo.getInternalname(), "Visible", GXutil.ltrimstr( cmbProfesionalSexo.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalDescripcion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalDescripcion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalDescripcion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalCorreo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalCorreo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalCorreo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalCOP_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalCOP_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalCOP_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalColorDisponible_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalColorDisponible_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalColorDisponible_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalColorCita_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalColorCita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalColorCita_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbProfesionalTiempoCita.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTiempoCita.getInternalname(), "Visible", GXutil.ltrimstr( cmbProfesionalTiempoCita.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalDireccion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalDireccion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalDireccion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPaisId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPaisDescripcion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisDescripcion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisDescripcion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalFoto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFoto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFoto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalTwitter_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalTwitter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalTwitter_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalFacebook_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFacebook_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFacebook_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalInstagram_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalInstagram_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalInstagram_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalLinkedin_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalLinkedin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalLinkedin_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalTelefono_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+26)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalTelefono_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalTelefono_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSecUserId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+27)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtProfesionalFechaRegistro_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFechaRegistro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFechaRegistro_Visible), 5, 0), !bGXsfl_43_Refreshing);
      chkProfesionalTerminosCondiciones.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkProfesionalTerminosCondiciones.getInternalname(), "Visible", GXutil.ltrimstr( chkProfesionalTerminosCondiciones.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbProfesionalEstadoCuenta.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+30)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstadoCuenta.getInternalname(), "Visible", GXutil.ltrimstr( cmbProfesionalEstadoCuenta.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbProfesionalEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+31)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbProfesionalEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV94GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV94GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV94GridCurrentPage), 10, 0));
      AV95GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridPageCount), 10, 0));
      AV105Wppacienteds_1_filterfulltext = AV16FilterFullText ;
      AV106Wppacienteds_2_tfprofesionalid = AV27TFProfesionalId ;
      AV107Wppacienteds_3_tfprofesionalid_to = AV28TFProfesionalId_To ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = AV30TFProfesionalTipoDocumento_Sels ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = AV31TFProfesionalNroDocumento ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = AV32TFProfesionalNroDocumento_Sel ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = AV33TFProfesionalApellidoPaterno ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV34TFProfesionalApellidoPaterno_Sel ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = AV35TFProfesionalApellidoMaterno ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV36TFProfesionalApellidoMaterno_Sel ;
      AV115Wppacienteds_11_tfprofesionalnombres = AV37TFProfesionalNombres ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = AV38TFProfesionalNombres_Sel ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = AV39TFProfesionalNombreCompleto2 ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV40TFProfesionalNombreCompleto2_Sel ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = AV41TFProfesionalFechaNacimiento ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = AV42TFProfesionalFechaNacimiento_To ;
      AV121Wppacienteds_17_tfprofesionalsexo_sels = AV47TFProfesionalSexo_Sels ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = AV48TFProfesionalDescripcion ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = AV49TFProfesionalDescripcion_Sel ;
      AV124Wppacienteds_20_tfprofesionalcorreo = AV50TFProfesionalCorreo ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = AV51TFProfesionalCorreo_Sel ;
      AV126Wppacienteds_22_tfprofesionalcop = AV52TFProfesionalCOP ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = AV53TFProfesionalCOP_Sel ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = AV54TFProfesionalColorDisponible ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = AV55TFProfesionalColorDisponible_Sel ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = AV56TFProfesionalColorCita ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = AV57TFProfesionalColorCita_Sel ;
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = AV59TFProfesionalTiempoCita_Sels ;
      AV133Wppacienteds_29_tfprofesionaldireccion = AV60TFProfesionalDireccion ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = AV61TFProfesionalDireccion_Sel ;
      AV135Wppacienteds_31_tfpaisid = AV62TFPaisId ;
      AV136Wppacienteds_32_tfpaisid_to = AV63TFPaisId_To ;
      AV137Wppacienteds_33_tfpaisdescripcion = AV64TFPaisDescripcion ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = AV65TFPaisDescripcion_Sel ;
      AV139Wppacienteds_35_tfubigeocode = AV66TFUbigeoCode ;
      AV140Wppacienteds_36_tfubigeocode_sel = AV67TFUbigeoCode_Sel ;
      AV141Wppacienteds_37_tfubigeonombre = AV68TFUbigeoNombre ;
      AV142Wppacienteds_38_tfubigeonombre_sel = AV69TFUbigeoNombre_Sel ;
      AV143Wppacienteds_39_tfprofesionaltwitter = AV70TFProfesionalTwitter ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = AV71TFProfesionalTwitter_Sel ;
      AV145Wppacienteds_41_tfprofesionalfacebook = AV72TFProfesionalFacebook ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = AV73TFProfesionalFacebook_Sel ;
      AV147Wppacienteds_43_tfprofesionalinstagram = AV74TFProfesionalInstagram ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = AV75TFProfesionalInstagram_Sel ;
      AV149Wppacienteds_45_tfprofesionallinkedin = AV76TFProfesionalLinkedin ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = AV77TFProfesionalLinkedin_Sel ;
      AV151Wppacienteds_47_tfprofesionaltelefono = AV78TFProfesionalTelefono ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = AV79TFProfesionalTelefono_Sel ;
      AV153Wppacienteds_49_tfsecuserid = AV80TFSecUserId ;
      AV154Wppacienteds_50_tfsecuserid_to = AV81TFSecUserId_To ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = AV82TFProfesionalFechaRegistro ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = AV83TFProfesionalFechaRegistro_To ;
      AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV87TFProfesionalTerminosCondiciones_Sel ;
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = AV89TFProfesionalEstadoCuenta_Sels ;
      AV159Wppacienteds_55_tfprofesionalestado_sels = AV91TFProfesionalEstado_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122R2( )
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
         AV93PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV93PageToGo) ;
      }
   }

   public void e132R2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142R2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalId") == 0 )
         {
            AV27TFProfesionalId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFProfesionalId), 8, 0));
            AV28TFProfesionalId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalTipoDocumento") == 0 )
         {
            AV29TFProfesionalTipoDocumento_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFProfesionalTipoDocumento_SelsJson", AV29TFProfesionalTipoDocumento_SelsJson);
            AV30TFProfesionalTipoDocumento_Sels.fromJSonString(AV29TFProfesionalTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalNroDocumento") == 0 )
         {
            AV31TFProfesionalNroDocumento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFProfesionalNroDocumento", AV31TFProfesionalNroDocumento);
            AV32TFProfesionalNroDocumento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFProfesionalNroDocumento_Sel", AV32TFProfesionalNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalApellidoPaterno") == 0 )
         {
            AV33TFProfesionalApellidoPaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFProfesionalApellidoPaterno", AV33TFProfesionalApellidoPaterno);
            AV34TFProfesionalApellidoPaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFProfesionalApellidoPaterno_Sel", AV34TFProfesionalApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalApellidoMaterno") == 0 )
         {
            AV35TFProfesionalApellidoMaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFProfesionalApellidoMaterno", AV35TFProfesionalApellidoMaterno);
            AV36TFProfesionalApellidoMaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFProfesionalApellidoMaterno_Sel", AV36TFProfesionalApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalNombres") == 0 )
         {
            AV37TFProfesionalNombres = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFProfesionalNombres", AV37TFProfesionalNombres);
            AV38TFProfesionalNombres_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFProfesionalNombres_Sel", AV38TFProfesionalNombres_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalNombreCompleto2") == 0 )
         {
            AV39TFProfesionalNombreCompleto2 = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFProfesionalNombreCompleto2", AV39TFProfesionalNombreCompleto2);
            AV40TFProfesionalNombreCompleto2_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFProfesionalNombreCompleto2_Sel", AV40TFProfesionalNombreCompleto2_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalFechaNacimiento") == 0 )
         {
            AV41TFProfesionalFechaNacimiento = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFProfesionalFechaNacimiento", localUtil.format(AV41TFProfesionalFechaNacimiento, "99/99/9999"));
            AV42TFProfesionalFechaNacimiento_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFProfesionalFechaNacimiento_To", localUtil.format(AV42TFProfesionalFechaNacimiento_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalSexo") == 0 )
         {
            AV46TFProfesionalSexo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFProfesionalSexo_SelsJson", AV46TFProfesionalSexo_SelsJson);
            AV47TFProfesionalSexo_Sels.fromJSonString(AV46TFProfesionalSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalDescripcion") == 0 )
         {
            AV48TFProfesionalDescripcion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFProfesionalDescripcion", AV48TFProfesionalDescripcion);
            AV49TFProfesionalDescripcion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFProfesionalDescripcion_Sel", AV49TFProfesionalDescripcion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalCorreo") == 0 )
         {
            AV50TFProfesionalCorreo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFProfesionalCorreo", AV50TFProfesionalCorreo);
            AV51TFProfesionalCorreo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFProfesionalCorreo_Sel", AV51TFProfesionalCorreo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalCOP") == 0 )
         {
            AV52TFProfesionalCOP = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFProfesionalCOP", AV52TFProfesionalCOP);
            AV53TFProfesionalCOP_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFProfesionalCOP_Sel", AV53TFProfesionalCOP_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalColorDisponible") == 0 )
         {
            AV54TFProfesionalColorDisponible = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFProfesionalColorDisponible", AV54TFProfesionalColorDisponible);
            AV55TFProfesionalColorDisponible_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFProfesionalColorDisponible_Sel", AV55TFProfesionalColorDisponible_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalColorCita") == 0 )
         {
            AV56TFProfesionalColorCita = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFProfesionalColorCita", AV56TFProfesionalColorCita);
            AV57TFProfesionalColorCita_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFProfesionalColorCita_Sel", AV57TFProfesionalColorCita_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalTiempoCita") == 0 )
         {
            AV58TFProfesionalTiempoCita_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFProfesionalTiempoCita_SelsJson", AV58TFProfesionalTiempoCita_SelsJson);
            AV59TFProfesionalTiempoCita_Sels.fromJSonString(GXutil.strReplace( AV58TFProfesionalTiempoCita_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalDireccion") == 0 )
         {
            AV60TFProfesionalDireccion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFProfesionalDireccion", AV60TFProfesionalDireccion);
            AV61TFProfesionalDireccion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFProfesionalDireccion_Sel", AV61TFProfesionalDireccion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaisId") == 0 )
         {
            AV62TFPaisId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFPaisId), 4, 0));
            AV63TFPaisId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaisId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFPaisId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaisDescripcion") == 0 )
         {
            AV64TFPaisDescripcion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFPaisDescripcion", AV64TFPaisDescripcion);
            AV65TFPaisDescripcion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFPaisDescripcion_Sel", AV65TFPaisDescripcion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoCode") == 0 )
         {
            AV66TFUbigeoCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFUbigeoCode", AV66TFUbigeoCode);
            AV67TFUbigeoCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFUbigeoCode_Sel", AV67TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoNombre") == 0 )
         {
            AV68TFUbigeoNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFUbigeoNombre", AV68TFUbigeoNombre);
            AV69TFUbigeoNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFUbigeoNombre_Sel", AV69TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalTwitter") == 0 )
         {
            AV70TFProfesionalTwitter = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFProfesionalTwitter", AV70TFProfesionalTwitter);
            AV71TFProfesionalTwitter_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFProfesionalTwitter_Sel", AV71TFProfesionalTwitter_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalFacebook") == 0 )
         {
            AV72TFProfesionalFacebook = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFProfesionalFacebook", AV72TFProfesionalFacebook);
            AV73TFProfesionalFacebook_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFProfesionalFacebook_Sel", AV73TFProfesionalFacebook_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalInstagram") == 0 )
         {
            AV74TFProfesionalInstagram = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFProfesionalInstagram", AV74TFProfesionalInstagram);
            AV75TFProfesionalInstagram_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFProfesionalInstagram_Sel", AV75TFProfesionalInstagram_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalLinkedin") == 0 )
         {
            AV76TFProfesionalLinkedin = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFProfesionalLinkedin", AV76TFProfesionalLinkedin);
            AV77TFProfesionalLinkedin_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFProfesionalLinkedin_Sel", AV77TFProfesionalLinkedin_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalTelefono") == 0 )
         {
            AV78TFProfesionalTelefono = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFProfesionalTelefono", AV78TFProfesionalTelefono);
            AV79TFProfesionalTelefono_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFProfesionalTelefono_Sel", AV79TFProfesionalTelefono_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecUserId") == 0 )
         {
            AV80TFSecUserId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV80TFSecUserId), 4, 0));
            AV81TFSecUserId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81TFSecUserId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalFechaRegistro") == 0 )
         {
            AV82TFProfesionalFechaRegistro = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFProfesionalFechaRegistro", localUtil.format(AV82TFProfesionalFechaRegistro, "99/99/99"));
            AV83TFProfesionalFechaRegistro_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFProfesionalFechaRegistro_To", localUtil.format(AV83TFProfesionalFechaRegistro_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalTerminosCondiciones") == 0 )
         {
            AV87TFProfesionalTerminosCondiciones_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFProfesionalTerminosCondiciones_Sel", GXutil.str( AV87TFProfesionalTerminosCondiciones_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalEstadoCuenta") == 0 )
         {
            AV88TFProfesionalEstadoCuenta_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFProfesionalEstadoCuenta_SelsJson", AV88TFProfesionalEstadoCuenta_SelsJson);
            AV89TFProfesionalEstadoCuenta_Sels.fromJSonString(AV88TFProfesionalEstadoCuenta_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ProfesionalEstado") == 0 )
         {
            AV90TFProfesionalEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFProfesionalEstado_SelsJson", AV90TFProfesionalEstado_SelsJson);
            AV91TFProfesionalEstado_Sels.fromJSonString(AV90TFProfesionalEstado_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFProfesionalEstado_Sels", AV91TFProfesionalEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFProfesionalEstadoCuenta_Sels", AV89TFProfesionalEstadoCuenta_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFProfesionalTiempoCita_Sels", AV59TFProfesionalTiempoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV47TFProfesionalSexo_Sels", AV47TFProfesionalSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFProfesionalTipoDocumento_Sels", AV30TFProfesionalTipoDocumento_Sels);
   }

   private void e212R2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV96Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV96Update);
      if ( AV97IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.profesional", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A31ProfesionalId,8,0))}, new String[] {})  ;
      }
      AV98Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV98Delete);
      if ( AV99IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.profesional", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A31ProfesionalId,8,0))}, new String[] {})  ;
      }
      if ( AV100IsAuthorized_PaisDescripcion )
      {
         edtPaisDescripcion_Link = formatLink("com.projectthani.paisview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A43PaisId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PaisId","TabCode"})  ;
      }
      if ( AV101IsAuthorized_UbigeoNombre )
      {
         edtUbigeoNombre_Link = formatLink("com.projectthani.ubigeoview", new String[] {GXutil.URLEncode(GXutil.rtrim(A44UbigeoCode)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"UbigeoCode","TabCode"})  ;
      }
      edtProfesionalTwitter_Linktarget = "_blank" ;
      edtProfesionalTwitter_Link = A190ProfesionalTwitter ;
      edtProfesionalFacebook_Linktarget = "_blank" ;
      edtProfesionalFacebook_Link = A191ProfesionalFacebook ;
      edtProfesionalInstagram_Linktarget = "_blank" ;
      edtProfesionalInstagram_Link = A192ProfesionalInstagram ;
      edtProfesionalLinkedin_Linktarget = "_blank" ;
      edtProfesionalLinkedin_Link = A193ProfesionalLinkedin ;
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

   public void e152R2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "WPPacienteColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e112R2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("WPPacienteFilters")),GXutil.URLEncode(GXutil.rtrim(AV160Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("WPPacienteFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "WPPacienteFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         wppaciente_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV160Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFProfesionalTipoDocumento_Sels", AV30TFProfesionalTipoDocumento_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV47TFProfesionalSexo_Sels", AV47TFProfesionalSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFProfesionalTiempoCita_Sels", AV59TFProfesionalTiempoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFProfesionalEstadoCuenta_Sels", AV89TFProfesionalEstadoCuenta_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFProfesionalEstado_Sels", AV91TFProfesionalEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e162R2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.profesional", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void e172R2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.wppacienteexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      wppaciente_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      wppaciente_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFProfesionalEstado_Sels", AV91TFProfesionalEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFProfesionalEstadoCuenta_Sels", AV89TFProfesionalEstadoCuenta_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFProfesionalTiempoCita_Sels", AV59TFProfesionalTiempoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV47TFProfesionalSexo_Sels", AV47TFProfesionalSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFProfesionalTipoDocumento_Sels", AV30TFProfesionalTipoDocumento_Sels);
   }

   public void e182R2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.wppacienteexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFProfesionalEstado_Sels", AV91TFProfesionalEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFProfesionalEstadoCuenta_Sels", AV89TFProfesionalEstadoCuenta_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFProfesionalTiempoCita_Sels", AV59TFProfesionalTiempoCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV47TFProfesionalSexo_Sels", AV47TFProfesionalSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFProfesionalTipoDocumento_Sels", AV30TFProfesionalTipoDocumento_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalTipoDocumento", "", "Tipo Documento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalNroDocumento", "", "Nro Documento", true, "") ;
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalNombreCompleto2", "", "Nombre Completo2", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalFechaNacimiento", "", "Fecha Nacimiento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalSexo", "", "Sexo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalDescripcion", "", "Descripcion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalCorreo", "", "Correo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalCOP", "", "CMP", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalColorDisponible", "", "Color Disponible", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalColorCita", "", "Color Cita", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalTiempoCita", "", "Tiempo Cita", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalDireccion", "", "Direccion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PaisId", "", "Pais Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PaisDescripcion", "", "Pais Descripcion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoCode", "", "Ubigeo Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalFoto", "", "Foto", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalTwitter", "", "Twitter", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalFacebook", "", "Facebook", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalInstagram", "", "Instagram", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalLinkedin", "", "Linkedin", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalTelefono", "", "Telefono", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecUserId", "", "User Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalFechaRegistro", "", "Fecha Registro", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalTerminosCondiciones", "", "Terminos Condiciones", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalEstadoCuenta", "", "Estado Cuenta", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WPPacienteColumnsSelector", GXv_char8) ;
      wppaciente_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV97IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "Profesional", GXv_boolean2) ;
      wppaciente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV97IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97IsAuthorized_Update", AV97IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV97IsAuthorized_Update));
      if ( ! ( AV97IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV99IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "Profesional", GXv_boolean2) ;
      wppaciente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV99IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99IsAuthorized_Delete", AV99IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV99IsAuthorized_Delete));
      if ( ! ( AV99IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV102TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "Profesional", GXv_boolean2) ;
      wppaciente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV102TempBoolean = GXt_boolean1 ;
      if ( ! ( AV102TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "WPPacienteFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFProfesionalId), 8, 0));
      AV28TFProfesionalId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFProfesionalId_To), 8, 0));
      AV30TFProfesionalTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFProfesionalNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFProfesionalNroDocumento", AV31TFProfesionalNroDocumento);
      AV32TFProfesionalNroDocumento_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFProfesionalNroDocumento_Sel", AV32TFProfesionalNroDocumento_Sel);
      AV33TFProfesionalApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFProfesionalApellidoPaterno", AV33TFProfesionalApellidoPaterno);
      AV34TFProfesionalApellidoPaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFProfesionalApellidoPaterno_Sel", AV34TFProfesionalApellidoPaterno_Sel);
      AV35TFProfesionalApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFProfesionalApellidoMaterno", AV35TFProfesionalApellidoMaterno);
      AV36TFProfesionalApellidoMaterno_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFProfesionalApellidoMaterno_Sel", AV36TFProfesionalApellidoMaterno_Sel);
      AV37TFProfesionalNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFProfesionalNombres", AV37TFProfesionalNombres);
      AV38TFProfesionalNombres_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFProfesionalNombres_Sel", AV38TFProfesionalNombres_Sel);
      AV39TFProfesionalNombreCompleto2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFProfesionalNombreCompleto2", AV39TFProfesionalNombreCompleto2);
      AV40TFProfesionalNombreCompleto2_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFProfesionalNombreCompleto2_Sel", AV40TFProfesionalNombreCompleto2_Sel);
      AV41TFProfesionalFechaNacimiento = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFProfesionalFechaNacimiento", localUtil.format(AV41TFProfesionalFechaNacimiento, "99/99/9999"));
      AV42TFProfesionalFechaNacimiento_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFProfesionalFechaNacimiento_To", localUtil.format(AV42TFProfesionalFechaNacimiento_To, "99/99/9999"));
      AV47TFProfesionalSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48TFProfesionalDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFProfesionalDescripcion", AV48TFProfesionalDescripcion);
      AV49TFProfesionalDescripcion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFProfesionalDescripcion_Sel", AV49TFProfesionalDescripcion_Sel);
      AV50TFProfesionalCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFProfesionalCorreo", AV50TFProfesionalCorreo);
      AV51TFProfesionalCorreo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFProfesionalCorreo_Sel", AV51TFProfesionalCorreo_Sel);
      AV52TFProfesionalCOP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFProfesionalCOP", AV52TFProfesionalCOP);
      AV53TFProfesionalCOP_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFProfesionalCOP_Sel", AV53TFProfesionalCOP_Sel);
      AV54TFProfesionalColorDisponible = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFProfesionalColorDisponible", AV54TFProfesionalColorDisponible);
      AV55TFProfesionalColorDisponible_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFProfesionalColorDisponible_Sel", AV55TFProfesionalColorDisponible_Sel);
      AV56TFProfesionalColorCita = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFProfesionalColorCita", AV56TFProfesionalColorCita);
      AV57TFProfesionalColorCita_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFProfesionalColorCita_Sel", AV57TFProfesionalColorCita_Sel);
      AV59TFProfesionalTiempoCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV60TFProfesionalDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFProfesionalDireccion", AV60TFProfesionalDireccion);
      AV61TFProfesionalDireccion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFProfesionalDireccion_Sel", AV61TFProfesionalDireccion_Sel);
      AV62TFPaisId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFPaisId), 4, 0));
      AV63TFPaisId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaisId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFPaisId_To), 4, 0));
      AV64TFPaisDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64TFPaisDescripcion", AV64TFPaisDescripcion);
      AV65TFPaisDescripcion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFPaisDescripcion_Sel", AV65TFPaisDescripcion_Sel);
      AV66TFUbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFUbigeoCode", AV66TFUbigeoCode);
      AV67TFUbigeoCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFUbigeoCode_Sel", AV67TFUbigeoCode_Sel);
      AV68TFUbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68TFUbigeoNombre", AV68TFUbigeoNombre);
      AV69TFUbigeoNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69TFUbigeoNombre_Sel", AV69TFUbigeoNombre_Sel);
      AV70TFProfesionalTwitter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70TFProfesionalTwitter", AV70TFProfesionalTwitter);
      AV71TFProfesionalTwitter_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFProfesionalTwitter_Sel", AV71TFProfesionalTwitter_Sel);
      AV72TFProfesionalFacebook = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72TFProfesionalFacebook", AV72TFProfesionalFacebook);
      AV73TFProfesionalFacebook_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73TFProfesionalFacebook_Sel", AV73TFProfesionalFacebook_Sel);
      AV74TFProfesionalInstagram = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74TFProfesionalInstagram", AV74TFProfesionalInstagram);
      AV75TFProfesionalInstagram_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75TFProfesionalInstagram_Sel", AV75TFProfesionalInstagram_Sel);
      AV76TFProfesionalLinkedin = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76TFProfesionalLinkedin", AV76TFProfesionalLinkedin);
      AV77TFProfesionalLinkedin_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFProfesionalLinkedin_Sel", AV77TFProfesionalLinkedin_Sel);
      AV78TFProfesionalTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFProfesionalTelefono", AV78TFProfesionalTelefono);
      AV79TFProfesionalTelefono_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79TFProfesionalTelefono_Sel", AV79TFProfesionalTelefono_Sel);
      AV80TFSecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV80TFSecUserId), 4, 0));
      AV81TFSecUserId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81TFSecUserId_To), 4, 0));
      AV82TFProfesionalFechaRegistro = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82TFProfesionalFechaRegistro", localUtil.format(AV82TFProfesionalFechaRegistro, "99/99/99"));
      AV83TFProfesionalFechaRegistro_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83TFProfesionalFechaRegistro_To", localUtil.format(AV83TFProfesionalFechaRegistro_To, "99/99/99"));
      AV87TFProfesionalTerminosCondiciones_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87TFProfesionalTerminosCondiciones_Sel", GXutil.str( AV87TFProfesionalTerminosCondiciones_Sel, 1, 0));
      AV89TFProfesionalEstadoCuenta_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV91TFProfesionalEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV160Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV160Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV160Pgmname+"GridState"), null, null);
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
      AV161GXV1 = 1 ;
      while ( AV161GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV161GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV27TFProfesionalId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFProfesionalId), 8, 0));
            AV28TFProfesionalId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFProfesionalId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFProfesionalId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTIPODOCUMENTO_SEL") == 0 )
         {
            AV29TFProfesionalTipoDocumento_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFProfesionalTipoDocumento_SelsJson", AV29TFProfesionalTipoDocumento_SelsJson);
            AV30TFProfesionalTipoDocumento_Sels.fromJSonString(AV29TFProfesionalTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNRODOCUMENTO") == 0 )
         {
            AV31TFProfesionalNroDocumento = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFProfesionalNroDocumento", AV31TFProfesionalNroDocumento);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNRODOCUMENTO_SEL") == 0 )
         {
            AV32TFProfesionalNroDocumento_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFProfesionalNroDocumento_Sel", AV32TFProfesionalNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV33TFProfesionalApellidoPaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFProfesionalApellidoPaterno", AV33TFProfesionalApellidoPaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV34TFProfesionalApellidoPaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFProfesionalApellidoPaterno_Sel", AV34TFProfesionalApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV35TFProfesionalApellidoMaterno = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFProfesionalApellidoMaterno", AV35TFProfesionalApellidoMaterno);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV36TFProfesionalApellidoMaterno_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFProfesionalApellidoMaterno_Sel", AV36TFProfesionalApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV37TFProfesionalNombres = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFProfesionalNombres", AV37TFProfesionalNombres);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV38TFProfesionalNombres_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFProfesionalNombres_Sel", AV38TFProfesionalNombres_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO2") == 0 )
         {
            AV39TFProfesionalNombreCompleto2 = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFProfesionalNombreCompleto2", AV39TFProfesionalNombreCompleto2);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO2_SEL") == 0 )
         {
            AV40TFProfesionalNombreCompleto2_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFProfesionalNombreCompleto2_Sel", AV40TFProfesionalNombreCompleto2_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFECHANACIMIENTO") == 0 )
         {
            AV41TFProfesionalFechaNacimiento = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFProfesionalFechaNacimiento", localUtil.format(AV41TFProfesionalFechaNacimiento, "99/99/9999"));
            AV42TFProfesionalFechaNacimiento_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFProfesionalFechaNacimiento_To", localUtil.format(AV42TFProfesionalFechaNacimiento_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALSEXO_SEL") == 0 )
         {
            AV46TFProfesionalSexo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFProfesionalSexo_SelsJson", AV46TFProfesionalSexo_SelsJson);
            AV47TFProfesionalSexo_Sels.fromJSonString(AV46TFProfesionalSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDESCRIPCION") == 0 )
         {
            AV48TFProfesionalDescripcion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFProfesionalDescripcion", AV48TFProfesionalDescripcion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDESCRIPCION_SEL") == 0 )
         {
            AV49TFProfesionalDescripcion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFProfesionalDescripcion_Sel", AV49TFProfesionalDescripcion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCORREO") == 0 )
         {
            AV50TFProfesionalCorreo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFProfesionalCorreo", AV50TFProfesionalCorreo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCORREO_SEL") == 0 )
         {
            AV51TFProfesionalCorreo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFProfesionalCorreo_Sel", AV51TFProfesionalCorreo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV52TFProfesionalCOP = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFProfesionalCOP", AV52TFProfesionalCOP);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV53TFProfesionalCOP_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFProfesionalCOP_Sel", AV53TFProfesionalCOP_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORDISPONIBLE") == 0 )
         {
            AV54TFProfesionalColorDisponible = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFProfesionalColorDisponible", AV54TFProfesionalColorDisponible);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORDISPONIBLE_SEL") == 0 )
         {
            AV55TFProfesionalColorDisponible_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFProfesionalColorDisponible_Sel", AV55TFProfesionalColorDisponible_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORCITA") == 0 )
         {
            AV56TFProfesionalColorCita = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFProfesionalColorCita", AV56TFProfesionalColorCita);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORCITA_SEL") == 0 )
         {
            AV57TFProfesionalColorCita_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFProfesionalColorCita_Sel", AV57TFProfesionalColorCita_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTIEMPOCITA_SEL") == 0 )
         {
            AV58TFProfesionalTiempoCita_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFProfesionalTiempoCita_SelsJson", AV58TFProfesionalTiempoCita_SelsJson);
            AV59TFProfesionalTiempoCita_Sels.fromJSonString(AV58TFProfesionalTiempoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDIRECCION") == 0 )
         {
            AV60TFProfesionalDireccion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFProfesionalDireccion", AV60TFProfesionalDireccion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDIRECCION_SEL") == 0 )
         {
            AV61TFProfesionalDireccion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFProfesionalDireccion_Sel", AV61TFProfesionalDireccion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV62TFPaisId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62TFPaisId), 4, 0));
            AV63TFPaisId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFPaisId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63TFPaisId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV64TFPaisDescripcion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFPaisDescripcion", AV64TFPaisDescripcion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV65TFPaisDescripcion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFPaisDescripcion_Sel", AV65TFPaisDescripcion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV66TFUbigeoCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFUbigeoCode", AV66TFUbigeoCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV67TFUbigeoCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFUbigeoCode_Sel", AV67TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV68TFUbigeoNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFUbigeoNombre", AV68TFUbigeoNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV69TFUbigeoNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFUbigeoNombre_Sel", AV69TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTWITTER") == 0 )
         {
            AV70TFProfesionalTwitter = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFProfesionalTwitter", AV70TFProfesionalTwitter);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTWITTER_SEL") == 0 )
         {
            AV71TFProfesionalTwitter_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFProfesionalTwitter_Sel", AV71TFProfesionalTwitter_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFACEBOOK") == 0 )
         {
            AV72TFProfesionalFacebook = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFProfesionalFacebook", AV72TFProfesionalFacebook);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFACEBOOK_SEL") == 0 )
         {
            AV73TFProfesionalFacebook_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFProfesionalFacebook_Sel", AV73TFProfesionalFacebook_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALINSTAGRAM") == 0 )
         {
            AV74TFProfesionalInstagram = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFProfesionalInstagram", AV74TFProfesionalInstagram);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALINSTAGRAM_SEL") == 0 )
         {
            AV75TFProfesionalInstagram_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFProfesionalInstagram_Sel", AV75TFProfesionalInstagram_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALLINKEDIN") == 0 )
         {
            AV76TFProfesionalLinkedin = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFProfesionalLinkedin", AV76TFProfesionalLinkedin);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALLINKEDIN_SEL") == 0 )
         {
            AV77TFProfesionalLinkedin_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFProfesionalLinkedin_Sel", AV77TFProfesionalLinkedin_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTELEFONO") == 0 )
         {
            AV78TFProfesionalTelefono = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFProfesionalTelefono", AV78TFProfesionalTelefono);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTELEFONO_SEL") == 0 )
         {
            AV79TFProfesionalTelefono_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFProfesionalTelefono_Sel", AV79TFProfesionalTelefono_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV80TFSecUserId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV80TFSecUserId), 4, 0));
            AV81TFSecUserId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFSecUserId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81TFSecUserId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFECHAREGISTRO") == 0 )
         {
            AV82TFProfesionalFechaRegistro = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFProfesionalFechaRegistro", localUtil.format(AV82TFProfesionalFechaRegistro, "99/99/99"));
            AV83TFProfesionalFechaRegistro_To = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFProfesionalFechaRegistro_To", localUtil.format(AV83TFProfesionalFechaRegistro_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTERMINOSCONDICIONES_SEL") == 0 )
         {
            AV87TFProfesionalTerminosCondiciones_Sel = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFProfesionalTerminosCondiciones_Sel", GXutil.str( AV87TFProfesionalTerminosCondiciones_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALESTADOCUENTA_SEL") == 0 )
         {
            AV88TFProfesionalEstadoCuenta_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFProfesionalEstadoCuenta_SelsJson", AV88TFProfesionalEstadoCuenta_SelsJson);
            AV89TFProfesionalEstadoCuenta_Sels.fromJSonString(AV88TFProfesionalEstadoCuenta_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALESTADO_SEL") == 0 )
         {
            AV90TFProfesionalEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFProfesionalEstado_SelsJson", AV90TFProfesionalEstado_SelsJson);
            AV91TFProfesionalEstado_Sels.fromJSonString(AV90TFProfesionalEstado_SelsJson, null);
         }
         AV161GXV1 = (int)(AV161GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFProfesionalTipoDocumento_Sels.size()==0), AV29TFProfesionalTipoDocumento_SelsJson, GXv_char8) ;
      wppaciente_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFProfesionalNroDocumento_Sel)==0), AV32TFProfesionalNroDocumento_Sel, GXv_char7) ;
      wppaciente_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFProfesionalApellidoPaterno_Sel)==0), AV34TFProfesionalApellidoPaterno_Sel, GXv_char15) ;
      wppaciente_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFProfesionalApellidoMaterno_Sel)==0), AV36TFProfesionalApellidoMaterno_Sel, GXv_char17) ;
      wppaciente_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFProfesionalNombres_Sel)==0), AV38TFProfesionalNombres_Sel, GXv_char19) ;
      wppaciente_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFProfesionalNombreCompleto2_Sel)==0), AV40TFProfesionalNombreCompleto2_Sel, GXv_char21) ;
      wppaciente_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV47TFProfesionalSexo_Sels.size()==0), AV46TFProfesionalSexo_SelsJson, GXv_char23) ;
      wppaciente_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFProfesionalDescripcion_Sel)==0), AV49TFProfesionalDescripcion_Sel, GXv_char25) ;
      wppaciente_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV51TFProfesionalCorreo_Sel)==0), AV51TFProfesionalCorreo_Sel, GXv_char27) ;
      wppaciente_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV53TFProfesionalCOP_Sel)==0), AV53TFProfesionalCOP_Sel, GXv_char29) ;
      wppaciente_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV55TFProfesionalColorDisponible_Sel)==0), AV55TFProfesionalColorDisponible_Sel, GXv_char31) ;
      wppaciente_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV57TFProfesionalColorCita_Sel)==0), AV57TFProfesionalColorCita_Sel, GXv_char33) ;
      wppaciente_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV61TFProfesionalDireccion_Sel)==0), AV61TFProfesionalDireccion_Sel, GXv_char35) ;
      wppaciente_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV65TFPaisDescripcion_Sel)==0), AV65TFPaisDescripcion_Sel, GXv_char37) ;
      wppaciente_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV67TFUbigeoCode_Sel)==0), AV67TFUbigeoCode_Sel, GXv_char39) ;
      wppaciente_impl.this.GXt_char38 = GXv_char39[0] ;
      GXt_char40 = "" ;
      GXv_char41[0] = GXt_char40 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV69TFUbigeoNombre_Sel)==0), AV69TFUbigeoNombre_Sel, GXv_char41) ;
      wppaciente_impl.this.GXt_char40 = GXv_char41[0] ;
      GXt_char42 = "" ;
      GXv_char43[0] = GXt_char42 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV71TFProfesionalTwitter_Sel)==0), AV71TFProfesionalTwitter_Sel, GXv_char43) ;
      wppaciente_impl.this.GXt_char42 = GXv_char43[0] ;
      GXt_char44 = "" ;
      GXv_char45[0] = GXt_char44 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV73TFProfesionalFacebook_Sel)==0), AV73TFProfesionalFacebook_Sel, GXv_char45) ;
      wppaciente_impl.this.GXt_char44 = GXv_char45[0] ;
      GXt_char46 = "" ;
      GXv_char47[0] = GXt_char46 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV75TFProfesionalInstagram_Sel)==0), AV75TFProfesionalInstagram_Sel, GXv_char47) ;
      wppaciente_impl.this.GXt_char46 = GXv_char47[0] ;
      GXt_char48 = "" ;
      GXv_char49[0] = GXt_char48 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV77TFProfesionalLinkedin_Sel)==0), AV77TFProfesionalLinkedin_Sel, GXv_char49) ;
      wppaciente_impl.this.GXt_char48 = GXv_char49[0] ;
      GXt_char50 = "" ;
      GXv_char51[0] = GXt_char50 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV79TFProfesionalTelefono_Sel)==0), AV79TFProfesionalTelefono_Sel, GXv_char51) ;
      wppaciente_impl.this.GXt_char50 = GXv_char51[0] ;
      GXt_char52 = "" ;
      GXv_char53[0] = GXt_char52 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV89TFProfesionalEstadoCuenta_Sels.size()==0), AV88TFProfesionalEstadoCuenta_SelsJson, GXv_char53) ;
      wppaciente_impl.this.GXt_char52 = GXv_char53[0] ;
      GXt_char54 = "" ;
      GXv_char55[0] = GXt_char54 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV91TFProfesionalEstado_Sels.size()==0), AV90TFProfesionalEstado_SelsJson, GXv_char55) ;
      wppaciente_impl.this.GXt_char54 = GXv_char55[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"||"+GXt_char22+"|"+GXt_char24+"|"+GXt_char26+"|"+GXt_char28+"|"+GXt_char30+"|"+GXt_char32+"|"+((AV59TFProfesionalTiempoCita_Sels.size()==0) ? "" : AV58TFProfesionalTiempoCita_SelsJson)+"|"+GXt_char34+"||"+GXt_char36+"|"+GXt_char38+"|"+GXt_char40+"||"+GXt_char42+"|"+GXt_char44+"|"+GXt_char46+"|"+GXt_char48+"|"+GXt_char50+"|||"+((0==AV87TFProfesionalTerminosCondiciones_Sel) ? "" : GXutil.str( AV87TFProfesionalTerminosCondiciones_Sel, 1, 0))+"|"+GXt_char52+"|"+GXt_char54 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char54 = "" ;
      GXv_char55[0] = GXt_char54 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFProfesionalNroDocumento)==0), AV31TFProfesionalNroDocumento, GXv_char55) ;
      wppaciente_impl.this.GXt_char54 = GXv_char55[0] ;
      GXt_char52 = "" ;
      GXv_char53[0] = GXt_char52 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFProfesionalApellidoPaterno)==0), AV33TFProfesionalApellidoPaterno, GXv_char53) ;
      wppaciente_impl.this.GXt_char52 = GXv_char53[0] ;
      GXt_char50 = "" ;
      GXv_char51[0] = GXt_char50 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFProfesionalApellidoMaterno)==0), AV35TFProfesionalApellidoMaterno, GXv_char51) ;
      wppaciente_impl.this.GXt_char50 = GXv_char51[0] ;
      GXt_char48 = "" ;
      GXv_char49[0] = GXt_char48 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFProfesionalNombres)==0), AV37TFProfesionalNombres, GXv_char49) ;
      wppaciente_impl.this.GXt_char48 = GXv_char49[0] ;
      GXt_char46 = "" ;
      GXv_char47[0] = GXt_char46 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFProfesionalNombreCompleto2)==0), AV39TFProfesionalNombreCompleto2, GXv_char47) ;
      wppaciente_impl.this.GXt_char46 = GXv_char47[0] ;
      GXt_char44 = "" ;
      GXv_char45[0] = GXt_char44 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV48TFProfesionalDescripcion)==0), AV48TFProfesionalDescripcion, GXv_char45) ;
      wppaciente_impl.this.GXt_char44 = GXv_char45[0] ;
      GXt_char42 = "" ;
      GXv_char43[0] = GXt_char42 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV50TFProfesionalCorreo)==0), AV50TFProfesionalCorreo, GXv_char43) ;
      wppaciente_impl.this.GXt_char42 = GXv_char43[0] ;
      GXt_char40 = "" ;
      GXv_char41[0] = GXt_char40 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFProfesionalCOP)==0), AV52TFProfesionalCOP, GXv_char41) ;
      wppaciente_impl.this.GXt_char40 = GXv_char41[0] ;
      GXt_char38 = "" ;
      GXv_char39[0] = GXt_char38 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV54TFProfesionalColorDisponible)==0), AV54TFProfesionalColorDisponible, GXv_char39) ;
      wppaciente_impl.this.GXt_char38 = GXv_char39[0] ;
      GXt_char36 = "" ;
      GXv_char37[0] = GXt_char36 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV56TFProfesionalColorCita)==0), AV56TFProfesionalColorCita, GXv_char37) ;
      wppaciente_impl.this.GXt_char36 = GXv_char37[0] ;
      GXt_char34 = "" ;
      GXv_char35[0] = GXt_char34 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV60TFProfesionalDireccion)==0), AV60TFProfesionalDireccion, GXv_char35) ;
      wppaciente_impl.this.GXt_char34 = GXv_char35[0] ;
      GXt_char32 = "" ;
      GXv_char33[0] = GXt_char32 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV64TFPaisDescripcion)==0), AV64TFPaisDescripcion, GXv_char33) ;
      wppaciente_impl.this.GXt_char32 = GXv_char33[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV66TFUbigeoCode)==0), AV66TFUbigeoCode, GXv_char31) ;
      wppaciente_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV68TFUbigeoNombre)==0), AV68TFUbigeoNombre, GXv_char29) ;
      wppaciente_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV70TFProfesionalTwitter)==0), AV70TFProfesionalTwitter, GXv_char27) ;
      wppaciente_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV72TFProfesionalFacebook)==0), AV72TFProfesionalFacebook, GXv_char25) ;
      wppaciente_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV74TFProfesionalInstagram)==0), AV74TFProfesionalInstagram, GXv_char23) ;
      wppaciente_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV76TFProfesionalLinkedin)==0), AV76TFProfesionalLinkedin, GXv_char21) ;
      wppaciente_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV78TFProfesionalTelefono)==0), AV78TFProfesionalTelefono, GXv_char19) ;
      wppaciente_impl.this.GXt_char18 = GXv_char19[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFProfesionalId) ? "" : GXutil.str( AV27TFProfesionalId, 8, 0))+"||"+GXt_char54+"|"+GXt_char52+"|"+GXt_char50+"|"+GXt_char48+"|"+GXt_char46+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFProfesionalFechaNacimiento)) ? "" : localUtil.dtoc( AV41TFProfesionalFechaNacimiento, 3, "/"))+"||"+GXt_char44+"|"+GXt_char42+"|"+GXt_char40+"|"+GXt_char38+"|"+GXt_char36+"||"+GXt_char34+"|"+((0==AV62TFPaisId) ? "" : GXutil.str( AV62TFPaisId, 4, 0))+"|"+GXt_char32+"|"+GXt_char30+"|"+GXt_char28+"||"+GXt_char26+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+GXt_char18+"|"+((0==AV80TFSecUserId) ? "" : GXutil.str( AV80TFSecUserId, 4, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV82TFProfesionalFechaRegistro)) ? "" : localUtil.dtoc( AV82TFProfesionalFechaRegistro, 3, "/"))+"|||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFProfesionalId_To) ? "" : GXutil.str( AV28TFProfesionalId_To, 8, 0))+"|||||||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFProfesionalFechaNacimiento_To)) ? "" : localUtil.dtoc( AV42TFProfesionalFechaNacimiento_To, 3, "/"))+"|||||||||"+((0==AV63TFPaisId_To) ? "" : GXutil.str( AV63TFPaisId_To, 4, 0))+"||||||||||"+((0==AV81TFSecUserId_To) ? "" : GXutil.str( AV81TFSecUserId_To, 4, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV83TFProfesionalFechaRegistro_To)) ? "" : localUtil.dtoc( AV83TFProfesionalFechaRegistro_To, 3, "/"))+"|||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV160Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALID", !((0==AV27TFProfesionalId)&&(0==AV28TFProfesionalId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFProfesionalId, 8, 0)), GXutil.trim( GXutil.str( AV28TFProfesionalId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALTIPODOCUMENTO_SEL", !(AV30TFProfesionalTipoDocumento_Sels.size()==0), (short)(0), AV30TFProfesionalTipoDocumento_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALNRODOCUMENTO", !(GXutil.strcmp("", AV31TFProfesionalNroDocumento)==0), (short)(0), AV31TFProfesionalNroDocumento, "", !(GXutil.strcmp("", AV32TFProfesionalNroDocumento_Sel)==0), AV32TFProfesionalNroDocumento_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALAPELLIDOPATERNO", !(GXutil.strcmp("", AV33TFProfesionalApellidoPaterno)==0), (short)(0), AV33TFProfesionalApellidoPaterno, "", !(GXutil.strcmp("", AV34TFProfesionalApellidoPaterno_Sel)==0), AV34TFProfesionalApellidoPaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALAPELLIDOMATERNO", !(GXutil.strcmp("", AV35TFProfesionalApellidoMaterno)==0), (short)(0), AV35TFProfesionalApellidoMaterno, "", !(GXutil.strcmp("", AV36TFProfesionalApellidoMaterno_Sel)==0), AV36TFProfesionalApellidoMaterno_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALNOMBRES", !(GXutil.strcmp("", AV37TFProfesionalNombres)==0), (short)(0), AV37TFProfesionalNombres, "", !(GXutil.strcmp("", AV38TFProfesionalNombres_Sel)==0), AV38TFProfesionalNombres_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALNOMBRECOMPLETO2", !(GXutil.strcmp("", AV39TFProfesionalNombreCompleto2)==0), (short)(0), AV39TFProfesionalNombreCompleto2, "", !(GXutil.strcmp("", AV40TFProfesionalNombreCompleto2_Sel)==0), AV40TFProfesionalNombreCompleto2_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALFECHANACIMIENTO", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFProfesionalFechaNacimiento))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFProfesionalFechaNacimiento_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV41TFProfesionalFechaNacimiento, 3, "/")), GXutil.trim( localUtil.dtoc( AV42TFProfesionalFechaNacimiento_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALSEXO_SEL", !(AV47TFProfesionalSexo_Sels.size()==0), (short)(0), AV47TFProfesionalSexo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALDESCRIPCION", !(GXutil.strcmp("", AV48TFProfesionalDescripcion)==0), (short)(0), AV48TFProfesionalDescripcion, "", !(GXutil.strcmp("", AV49TFProfesionalDescripcion_Sel)==0), AV49TFProfesionalDescripcion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALCORREO", !(GXutil.strcmp("", AV50TFProfesionalCorreo)==0), (short)(0), AV50TFProfesionalCorreo, "", !(GXutil.strcmp("", AV51TFProfesionalCorreo_Sel)==0), AV51TFProfesionalCorreo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALCOP", !(GXutil.strcmp("", AV52TFProfesionalCOP)==0), (short)(0), AV52TFProfesionalCOP, "", !(GXutil.strcmp("", AV53TFProfesionalCOP_Sel)==0), AV53TFProfesionalCOP_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALCOLORDISPONIBLE", !(GXutil.strcmp("", AV54TFProfesionalColorDisponible)==0), (short)(0), AV54TFProfesionalColorDisponible, "", !(GXutil.strcmp("", AV55TFProfesionalColorDisponible_Sel)==0), AV55TFProfesionalColorDisponible_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALCOLORCITA", !(GXutil.strcmp("", AV56TFProfesionalColorCita)==0), (short)(0), AV56TFProfesionalColorCita, "", !(GXutil.strcmp("", AV57TFProfesionalColorCita_Sel)==0), AV57TFProfesionalColorCita_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALTIEMPOCITA_SEL", !(AV59TFProfesionalTiempoCita_Sels.size()==0), (short)(0), AV59TFProfesionalTiempoCita_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALDIRECCION", !(GXutil.strcmp("", AV60TFProfesionalDireccion)==0), (short)(0), AV60TFProfesionalDireccion, "", !(GXutil.strcmp("", AV61TFProfesionalDireccion_Sel)==0), AV61TFProfesionalDireccion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPAISID", !((0==AV62TFPaisId)&&(0==AV63TFPaisId_To)), (short)(0), GXutil.trim( GXutil.str( AV62TFPaisId, 4, 0)), GXutil.trim( GXutil.str( AV63TFPaisId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPAISDESCRIPCION", !(GXutil.strcmp("", AV64TFPaisDescripcion)==0), (short)(0), AV64TFPaisDescripcion, "", !(GXutil.strcmp("", AV65TFPaisDescripcion_Sel)==0), AV65TFPaisDescripcion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFUBIGEOCODE", !(GXutil.strcmp("", AV66TFUbigeoCode)==0), (short)(0), AV66TFUbigeoCode, "", !(GXutil.strcmp("", AV67TFUbigeoCode_Sel)==0), AV67TFUbigeoCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFUBIGEONOMBRE", !(GXutil.strcmp("", AV68TFUbigeoNombre)==0), (short)(0), AV68TFUbigeoNombre, "", !(GXutil.strcmp("", AV69TFUbigeoNombre_Sel)==0), AV69TFUbigeoNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALTWITTER", !(GXutil.strcmp("", AV70TFProfesionalTwitter)==0), (short)(0), AV70TFProfesionalTwitter, "", !(GXutil.strcmp("", AV71TFProfesionalTwitter_Sel)==0), AV71TFProfesionalTwitter_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALFACEBOOK", !(GXutil.strcmp("", AV72TFProfesionalFacebook)==0), (short)(0), AV72TFProfesionalFacebook, "", !(GXutil.strcmp("", AV73TFProfesionalFacebook_Sel)==0), AV73TFProfesionalFacebook_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALINSTAGRAM", !(GXutil.strcmp("", AV74TFProfesionalInstagram)==0), (short)(0), AV74TFProfesionalInstagram, "", !(GXutil.strcmp("", AV75TFProfesionalInstagram_Sel)==0), AV75TFProfesionalInstagram_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALLINKEDIN", !(GXutil.strcmp("", AV76TFProfesionalLinkedin)==0), (short)(0), AV76TFProfesionalLinkedin, "", !(GXutil.strcmp("", AV77TFProfesionalLinkedin_Sel)==0), AV77TFProfesionalLinkedin_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALTELEFONO", !(GXutil.strcmp("", AV78TFProfesionalTelefono)==0), (short)(0), AV78TFProfesionalTelefono, "", !(GXutil.strcmp("", AV79TFProfesionalTelefono_Sel)==0), AV79TFProfesionalTelefono_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFSECUSERID", !((0==AV80TFSecUserId)&&(0==AV81TFSecUserId_To)), (short)(0), GXutil.trim( GXutil.str( AV80TFSecUserId, 4, 0)), GXutil.trim( GXutil.str( AV81TFSecUserId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALFECHAREGISTRO", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV82TFProfesionalFechaRegistro))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV83TFProfesionalFechaRegistro_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV82TFProfesionalFechaRegistro, 3, "/")), GXutil.trim( localUtil.dtoc( AV83TFProfesionalFechaRegistro_To, 3, "/"))) ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALTERMINOSCONDICIONES_SEL", !(0==AV87TFProfesionalTerminosCondiciones_Sel), (short)(0), GXutil.trim( GXutil.str( AV87TFProfesionalTerminosCondiciones_Sel, 1, 0)), "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALESTADOCUENTA_SEL", !(AV89TFProfesionalEstadoCuenta_Sels.size()==0), (short)(0), AV89TFProfesionalEstadoCuenta_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      GXv_SdtWWPGridState56[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState56, "TFPROFESIONALESTADO_SEL", !(AV91TFProfesionalEstado_Sels.size()==0), (short)(0), AV91TFProfesionalEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState56[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV160Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV160Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Profesional" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_2R2( boolean wbgen )
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
         wb_table2_30_2R2( true) ;
      }
      else
      {
         wb_table2_30_2R2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_2R2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_2R2e( true) ;
      }
      else
      {
         wb_table1_25_2R2e( false) ;
      }
   }

   public void wb_table2_30_2R2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_WPPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_2R2e( true) ;
      }
      else
      {
         wb_table2_30_2R2e( false) ;
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
      pa2R2( ) ;
      ws2R2( ) ;
      we2R2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335866", true, true);
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
      httpContext.AddJavascriptSource("wppaciente.js", "?20225110335867", false, true);
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
      edtProfesionalId_Internalname = "PROFESIONALID_"+sGXsfl_43_idx ;
      cmbProfesionalTipoDocumento.setInternalname( "PROFESIONALTIPODOCUMENTO_"+sGXsfl_43_idx );
      edtProfesionalNroDocumento_Internalname = "PROFESIONALNRODOCUMENTO_"+sGXsfl_43_idx ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO_"+sGXsfl_43_idx ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO_"+sGXsfl_43_idx ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES_"+sGXsfl_43_idx ;
      edtProfesionalNombreCompleto2_Internalname = "PROFESIONALNOMBRECOMPLETO2_"+sGXsfl_43_idx ;
      edtProfesionalFechaNacimiento_Internalname = "PROFESIONALFECHANACIMIENTO_"+sGXsfl_43_idx ;
      cmbProfesionalSexo.setInternalname( "PROFESIONALSEXO_"+sGXsfl_43_idx );
      edtProfesionalDescripcion_Internalname = "PROFESIONALDESCRIPCION_"+sGXsfl_43_idx ;
      edtProfesionalCorreo_Internalname = "PROFESIONALCORREO_"+sGXsfl_43_idx ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP_"+sGXsfl_43_idx ;
      edtProfesionalColorDisponible_Internalname = "PROFESIONALCOLORDISPONIBLE_"+sGXsfl_43_idx ;
      edtProfesionalColorCita_Internalname = "PROFESIONALCOLORCITA_"+sGXsfl_43_idx ;
      cmbProfesionalTiempoCita.setInternalname( "PROFESIONALTIEMPOCITA_"+sGXsfl_43_idx );
      edtProfesionalDireccion_Internalname = "PROFESIONALDIRECCION_"+sGXsfl_43_idx ;
      edtPaisId_Internalname = "PAISID_"+sGXsfl_43_idx ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION_"+sGXsfl_43_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_idx ;
      edtProfesionalFoto_Internalname = "PROFESIONALFOTO_"+sGXsfl_43_idx ;
      edtProfesionalTwitter_Internalname = "PROFESIONALTWITTER_"+sGXsfl_43_idx ;
      edtProfesionalFacebook_Internalname = "PROFESIONALFACEBOOK_"+sGXsfl_43_idx ;
      edtProfesionalInstagram_Internalname = "PROFESIONALINSTAGRAM_"+sGXsfl_43_idx ;
      edtProfesionalLinkedin_Internalname = "PROFESIONALLINKEDIN_"+sGXsfl_43_idx ;
      edtProfesionalTelefono_Internalname = "PROFESIONALTELEFONO_"+sGXsfl_43_idx ;
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_43_idx ;
      edtProfesionalFechaRegistro_Internalname = "PROFESIONALFECHAREGISTRO_"+sGXsfl_43_idx ;
      chkProfesionalTerminosCondiciones.setInternalname( "PROFESIONALTERMINOSCONDICIONES_"+sGXsfl_43_idx );
      cmbProfesionalEstadoCuenta.setInternalname( "PROFESIONALESTADOCUENTA_"+sGXsfl_43_idx );
      cmbProfesionalEstado.setInternalname( "PROFESIONALESTADO_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtProfesionalId_Internalname = "PROFESIONALID_"+sGXsfl_43_fel_idx ;
      cmbProfesionalTipoDocumento.setInternalname( "PROFESIONALTIPODOCUMENTO_"+sGXsfl_43_fel_idx );
      edtProfesionalNroDocumento_Internalname = "PROFESIONALNRODOCUMENTO_"+sGXsfl_43_fel_idx ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO_"+sGXsfl_43_fel_idx ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO_"+sGXsfl_43_fel_idx ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES_"+sGXsfl_43_fel_idx ;
      edtProfesionalNombreCompleto2_Internalname = "PROFESIONALNOMBRECOMPLETO2_"+sGXsfl_43_fel_idx ;
      edtProfesionalFechaNacimiento_Internalname = "PROFESIONALFECHANACIMIENTO_"+sGXsfl_43_fel_idx ;
      cmbProfesionalSexo.setInternalname( "PROFESIONALSEXO_"+sGXsfl_43_fel_idx );
      edtProfesionalDescripcion_Internalname = "PROFESIONALDESCRIPCION_"+sGXsfl_43_fel_idx ;
      edtProfesionalCorreo_Internalname = "PROFESIONALCORREO_"+sGXsfl_43_fel_idx ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP_"+sGXsfl_43_fel_idx ;
      edtProfesionalColorDisponible_Internalname = "PROFESIONALCOLORDISPONIBLE_"+sGXsfl_43_fel_idx ;
      edtProfesionalColorCita_Internalname = "PROFESIONALCOLORCITA_"+sGXsfl_43_fel_idx ;
      cmbProfesionalTiempoCita.setInternalname( "PROFESIONALTIEMPOCITA_"+sGXsfl_43_fel_idx );
      edtProfesionalDireccion_Internalname = "PROFESIONALDIRECCION_"+sGXsfl_43_fel_idx ;
      edtPaisId_Internalname = "PAISID_"+sGXsfl_43_fel_idx ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION_"+sGXsfl_43_fel_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_fel_idx ;
      edtProfesionalFoto_Internalname = "PROFESIONALFOTO_"+sGXsfl_43_fel_idx ;
      edtProfesionalTwitter_Internalname = "PROFESIONALTWITTER_"+sGXsfl_43_fel_idx ;
      edtProfesionalFacebook_Internalname = "PROFESIONALFACEBOOK_"+sGXsfl_43_fel_idx ;
      edtProfesionalInstagram_Internalname = "PROFESIONALINSTAGRAM_"+sGXsfl_43_fel_idx ;
      edtProfesionalLinkedin_Internalname = "PROFESIONALLINKEDIN_"+sGXsfl_43_fel_idx ;
      edtProfesionalTelefono_Internalname = "PROFESIONALTELEFONO_"+sGXsfl_43_fel_idx ;
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_43_fel_idx ;
      edtProfesionalFechaRegistro_Internalname = "PROFESIONALFECHAREGISTRO_"+sGXsfl_43_fel_idx ;
      chkProfesionalTerminosCondiciones.setInternalname( "PROFESIONALTERMINOSCONDICIONES_"+sGXsfl_43_fel_idx );
      cmbProfesionalEstadoCuenta.setInternalname( "PROFESIONALESTADOCUENTA_"+sGXsfl_43_fel_idx );
      cmbProfesionalEstado.setInternalname( "PROFESIONALESTADO_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb2R0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV96Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV98Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtProfesionalId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalId_Internalname,GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtProfesionalId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbProfesionalTipoDocumento.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbProfesionalTipoDocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PROFESIONALTIPODOCUMENTO_" + sGXsfl_43_idx ;
            cmbProfesionalTipoDocumento.setName( GXCCtl );
            cmbProfesionalTipoDocumento.setWebtags( "" );
            cmbProfesionalTipoDocumento.addItem("1", "DNI", (short)(0));
            cmbProfesionalTipoDocumento.addItem("6", "RUC", (short)(0));
            cmbProfesionalTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
            cmbProfesionalTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
            cmbProfesionalTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
            cmbProfesionalTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
            if ( cmbProfesionalTipoDocumento.getItemCount() > 0 )
            {
               A173ProfesionalTipoDocumento = cmbProfesionalTipoDocumento.getValidValue(A173ProfesionalTipoDocumento) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbProfesionalTipoDocumento,cmbProfesionalTipoDocumento.getInternalname(),GXutil.rtrim( A173ProfesionalTipoDocumento),Integer.valueOf(1),cmbProfesionalTipoDocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbProfesionalTipoDocumento.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbProfesionalTipoDocumento.setValue( GXutil.rtrim( A173ProfesionalTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTipoDocumento.getInternalname(), "Values", cmbProfesionalTipoDocumento.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalNroDocumento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalNroDocumento_Internalname,A174ProfesionalNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalNroDocumento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalNombreCompleto2_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalNombreCompleto2_Internalname,A175ProfesionalNombreCompleto2,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalNombreCompleto2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalNombreCompleto2_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtProfesionalFechaNacimiento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalFechaNacimiento_Internalname,localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"),localUtil.format( A176ProfesionalFechaNacimiento, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalFechaNacimiento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalFechaNacimiento_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbProfesionalSexo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbProfesionalSexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PROFESIONALSEXO_" + sGXsfl_43_idx ;
            cmbProfesionalSexo.setName( GXCCtl );
            cmbProfesionalSexo.setWebtags( "" );
            cmbProfesionalSexo.addItem("M", "Masculino", (short)(0));
            cmbProfesionalSexo.addItem("F", "Femenino", (short)(0));
            if ( cmbProfesionalSexo.getItemCount() > 0 )
            {
               A177ProfesionalSexo = cmbProfesionalSexo.getValidValue(A177ProfesionalSexo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbProfesionalSexo,cmbProfesionalSexo.getInternalname(),GXutil.rtrim( A177ProfesionalSexo),Integer.valueOf(1),cmbProfesionalSexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbProfesionalSexo.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbProfesionalSexo.setValue( GXutil.rtrim( A177ProfesionalSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalSexo.getInternalname(), "Values", cmbProfesionalSexo.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalDescripcion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalDescripcion_Internalname,A178ProfesionalDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalDescripcion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalCorreo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalCorreo_Internalname,A179ProfesionalCorreo,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A179ProfesionalCorreo,"","","",edtProfesionalCorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalCorreo_Visible),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalColorDisponible_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalColorDisponible_Internalname,GXutil.rtrim( A180ProfesionalColorDisponible),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalColorDisponible_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalColorDisponible_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalColorCita_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalColorCita_Internalname,GXutil.rtrim( A181ProfesionalColorCita),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalColorCita_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalColorCita_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbProfesionalTiempoCita.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbProfesionalTiempoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PROFESIONALTIEMPOCITA_" + sGXsfl_43_idx ;
            cmbProfesionalTiempoCita.setName( GXCCtl );
            cmbProfesionalTiempoCita.setWebtags( "" );
            cmbProfesionalTiempoCita.addItem("30", "30 minutos", (short)(0));
            cmbProfesionalTiempoCita.addItem("60", "1 hora", (short)(0));
            if ( cmbProfesionalTiempoCita.getItemCount() > 0 )
            {
               A182ProfesionalTiempoCita = (byte)(GXutil.lval( cmbProfesionalTiempoCita.getValidValue(GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbProfesionalTiempoCita,cmbProfesionalTiempoCita.getInternalname(),GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)),Integer.valueOf(1),cmbProfesionalTiempoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbProfesionalTiempoCita.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbProfesionalTiempoCita.setValue( GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTiempoCita.getInternalname(), "Values", cmbProfesionalTiempoCita.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalDireccion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalDireccion_Internalname,A183ProfesionalDireccion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalDireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalDireccion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtProfesionalFoto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A189ProfesionalFoto_IsBlob = (boolean)(((GXutil.strcmp("", A189ProfesionalFoto)==0)&&(GXutil.strcmp("", A40000ProfesionalFoto_GXI)==0))||!(GXutil.strcmp("", A189ProfesionalFoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.getResourceRelative(A189ProfesionalFoto)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtProfesionalFoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtProfesionalFoto_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A189ProfesionalFoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalTwitter_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalTwitter_Internalname,A190ProfesionalTwitter,"","","'"+""+"'"+",false,"+"'"+""+"'",edtProfesionalTwitter_Link,edtProfesionalTwitter_Linktarget,"","",edtProfesionalTwitter_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalTwitter_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalFacebook_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalFacebook_Internalname,A191ProfesionalFacebook,"","","'"+""+"'"+",false,"+"'"+""+"'",edtProfesionalFacebook_Link,edtProfesionalFacebook_Linktarget,"","",edtProfesionalFacebook_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalFacebook_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalInstagram_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalInstagram_Internalname,A192ProfesionalInstagram,"","","'"+""+"'"+",false,"+"'"+""+"'",edtProfesionalInstagram_Link,edtProfesionalInstagram_Linktarget,"","",edtProfesionalInstagram_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalInstagram_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalLinkedin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalLinkedin_Internalname,A193ProfesionalLinkedin,"","","'"+""+"'"+",false,"+"'"+""+"'",edtProfesionalLinkedin_Link,edtProfesionalLinkedin_Linktarget,"","",edtProfesionalLinkedin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalLinkedin_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtProfesionalTelefono_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         if ( httpContext.isSmartDevice( ) )
         {
            gxphoneLink = "tel:" + GXutil.rtrim( A194ProfesionalTelefono) ;
         }
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalTelefono_Internalname,GXutil.rtrim( A194ProfesionalTelefono),"","","'"+""+"'"+",false,"+"'"+""+"'",gxphoneLink,"","","",edtProfesionalTelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalTelefono_Visible),Integer.valueOf(0),Integer.valueOf(0),"tel","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Phone","left",Boolean.valueOf(true),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtProfesionalFechaRegistro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtProfesionalFechaRegistro_Internalname,localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"),localUtil.format( A195ProfesionalFechaRegistro, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtProfesionalFechaRegistro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtProfesionalFechaRegistro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkProfesionalTerminosCondiciones.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "PROFESIONALTERMINOSCONDICIONES_" + sGXsfl_43_idx ;
         chkProfesionalTerminosCondiciones.setName( GXCCtl );
         chkProfesionalTerminosCondiciones.setWebtags( "" );
         chkProfesionalTerminosCondiciones.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkProfesionalTerminosCondiciones.getInternalname(), "TitleCaption", chkProfesionalTerminosCondiciones.getCaption(), !bGXsfl_43_Refreshing);
         chkProfesionalTerminosCondiciones.setCheckedValue( "false" );
         A196ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( A196ProfesionalTerminosCondiciones)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkProfesionalTerminosCondiciones.getInternalname(),GXutil.booltostr( A196ProfesionalTerminosCondiciones),"","",Integer.valueOf(chkProfesionalTerminosCondiciones.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbProfesionalEstadoCuenta.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbProfesionalEstadoCuenta.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PROFESIONALESTADOCUENTA_" + sGXsfl_43_idx ;
            cmbProfesionalEstadoCuenta.setName( GXCCtl );
            cmbProfesionalEstadoCuenta.setWebtags( "" );
            cmbProfesionalEstadoCuenta.addItem("CV", "Cuenta Verificada", (short)(0));
            cmbProfesionalEstadoCuenta.addItem("CP", "Cuenta Por Verificar", (short)(0));
            if ( cmbProfesionalEstadoCuenta.getItemCount() > 0 )
            {
               A197ProfesionalEstadoCuenta = cmbProfesionalEstadoCuenta.getValidValue(A197ProfesionalEstadoCuenta) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbProfesionalEstadoCuenta,cmbProfesionalEstadoCuenta.getInternalname(),GXutil.rtrim( A197ProfesionalEstadoCuenta),Integer.valueOf(1),cmbProfesionalEstadoCuenta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbProfesionalEstadoCuenta.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbProfesionalEstadoCuenta.setValue( GXutil.rtrim( A197ProfesionalEstadoCuenta) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstadoCuenta.getInternalname(), "Values", cmbProfesionalEstadoCuenta.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbProfesionalEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbProfesionalEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PROFESIONALESTADO_" + sGXsfl_43_idx ;
            cmbProfesionalEstado.setName( GXCCtl );
            cmbProfesionalEstado.setWebtags( "" );
            cmbProfesionalEstado.addItem("A", "Activo", (short)(0));
            cmbProfesionalEstado.addItem("P", "Pendiente", (short)(0));
            cmbProfesionalEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbProfesionalEstado.getItemCount() > 0 )
            {
               A198ProfesionalEstado = cmbProfesionalEstado.getValidValue(A198ProfesionalEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbProfesionalEstado,cmbProfesionalEstado.getInternalname(),GXutil.rtrim( A198ProfesionalEstado),Integer.valueOf(1),cmbProfesionalEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbProfesionalEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbProfesionalEstado.setValue( GXutil.rtrim( A198ProfesionalEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstado.getInternalname(), "Values", cmbProfesionalEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes2R2( ) ;
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
      edtProfesionalId_Internalname = "PROFESIONALID" ;
      cmbProfesionalTipoDocumento.setInternalname( "PROFESIONALTIPODOCUMENTO" );
      edtProfesionalNroDocumento_Internalname = "PROFESIONALNRODOCUMENTO" ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO" ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO" ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES" ;
      edtProfesionalNombreCompleto2_Internalname = "PROFESIONALNOMBRECOMPLETO2" ;
      edtProfesionalFechaNacimiento_Internalname = "PROFESIONALFECHANACIMIENTO" ;
      cmbProfesionalSexo.setInternalname( "PROFESIONALSEXO" );
      edtProfesionalDescripcion_Internalname = "PROFESIONALDESCRIPCION" ;
      edtProfesionalCorreo_Internalname = "PROFESIONALCORREO" ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP" ;
      edtProfesionalColorDisponible_Internalname = "PROFESIONALCOLORDISPONIBLE" ;
      edtProfesionalColorCita_Internalname = "PROFESIONALCOLORCITA" ;
      cmbProfesionalTiempoCita.setInternalname( "PROFESIONALTIEMPOCITA" );
      edtProfesionalDireccion_Internalname = "PROFESIONALDIRECCION" ;
      edtPaisId_Internalname = "PAISID" ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION" ;
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      edtProfesionalFoto_Internalname = "PROFESIONALFOTO" ;
      edtProfesionalTwitter_Internalname = "PROFESIONALTWITTER" ;
      edtProfesionalFacebook_Internalname = "PROFESIONALFACEBOOK" ;
      edtProfesionalInstagram_Internalname = "PROFESIONALINSTAGRAM" ;
      edtProfesionalLinkedin_Internalname = "PROFESIONALLINKEDIN" ;
      edtProfesionalTelefono_Internalname = "PROFESIONALTELEFONO" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      edtProfesionalFechaRegistro_Internalname = "PROFESIONALFECHAREGISTRO" ;
      chkProfesionalTerminosCondiciones.setInternalname( "PROFESIONALTERMINOSCONDICIONES" );
      cmbProfesionalEstadoCuenta.setInternalname( "PROFESIONALESTADOCUENTA" );
      cmbProfesionalEstado.setInternalname( "PROFESIONALESTADO" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_profesionalfechanacimientoauxdatetext_Internalname = "vDDO_PROFESIONALFECHANACIMIENTOAUXDATETEXT" ;
      Tfprofesionalfechanacimiento_rangepicker_Internalname = "TFPROFESIONALFECHANACIMIENTO_RANGEPICKER" ;
      divDdo_profesionalfechanacimientoauxdates_Internalname = "DDO_PROFESIONALFECHANACIMIENTOAUXDATES" ;
      edtavDdo_profesionalfecharegistroauxdatetext_Internalname = "vDDO_PROFESIONALFECHAREGISTROAUXDATETEXT" ;
      Tfprofesionalfecharegistro_rangepicker_Internalname = "TFPROFESIONALFECHAREGISTRO_RANGEPICKER" ;
      divDdo_profesionalfecharegistroauxdates_Internalname = "DDO_PROFESIONALFECHAREGISTROAUXDATES" ;
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
      cmbProfesionalEstado.setJsonclick( "" );
      cmbProfesionalEstadoCuenta.setJsonclick( "" );
      chkProfesionalTerminosCondiciones.setCaption( "" );
      edtProfesionalFechaRegistro_Jsonclick = "" ;
      edtSecUserId_Jsonclick = "" ;
      edtProfesionalTelefono_Jsonclick = "" ;
      edtProfesionalLinkedin_Jsonclick = "" ;
      edtProfesionalInstagram_Jsonclick = "" ;
      edtProfesionalFacebook_Jsonclick = "" ;
      edtProfesionalTwitter_Jsonclick = "" ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoCode_Jsonclick = "" ;
      edtPaisDescripcion_Jsonclick = "" ;
      edtPaisId_Jsonclick = "" ;
      edtProfesionalDireccion_Jsonclick = "" ;
      cmbProfesionalTiempoCita.setJsonclick( "" );
      edtProfesionalColorCita_Jsonclick = "" ;
      edtProfesionalColorDisponible_Jsonclick = "" ;
      edtProfesionalCOP_Jsonclick = "" ;
      edtProfesionalCorreo_Jsonclick = "" ;
      edtProfesionalDescripcion_Jsonclick = "" ;
      cmbProfesionalSexo.setJsonclick( "" );
      edtProfesionalFechaNacimiento_Jsonclick = "" ;
      edtProfesionalNombreCompleto2_Jsonclick = "" ;
      edtProfesionalNombres_Jsonclick = "" ;
      edtProfesionalApellidoMaterno_Jsonclick = "" ;
      edtProfesionalApellidoPaterno_Jsonclick = "" ;
      edtProfesionalNroDocumento_Jsonclick = "" ;
      cmbProfesionalTipoDocumento.setJsonclick( "" );
      edtProfesionalId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_profesionalfecharegistroauxdatetext_Jsonclick = "" ;
      edtavDdo_profesionalfechanacimientoauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtProfesionalLinkedin_Linktarget = "" ;
      edtProfesionalLinkedin_Link = "" ;
      edtProfesionalInstagram_Linktarget = "" ;
      edtProfesionalInstagram_Link = "" ;
      edtProfesionalFacebook_Linktarget = "" ;
      edtProfesionalFacebook_Link = "" ;
      edtProfesionalTwitter_Linktarget = "" ;
      edtProfesionalTwitter_Link = "" ;
      edtUbigeoNombre_Link = "" ;
      edtPaisDescripcion_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbProfesionalEstado.setVisible( -1 );
      cmbProfesionalEstadoCuenta.setVisible( -1 );
      chkProfesionalTerminosCondiciones.setVisible( -1 );
      edtProfesionalFechaRegistro_Visible = -1 ;
      edtSecUserId_Visible = -1 ;
      edtProfesionalTelefono_Visible = -1 ;
      edtProfesionalLinkedin_Visible = -1 ;
      edtProfesionalInstagram_Visible = -1 ;
      edtProfesionalFacebook_Visible = -1 ;
      edtProfesionalTwitter_Visible = -1 ;
      edtProfesionalFoto_Visible = -1 ;
      edtUbigeoNombre_Visible = -1 ;
      edtUbigeoCode_Visible = -1 ;
      edtPaisDescripcion_Visible = -1 ;
      edtPaisId_Visible = -1 ;
      edtProfesionalDireccion_Visible = -1 ;
      cmbProfesionalTiempoCita.setVisible( -1 );
      edtProfesionalColorCita_Visible = -1 ;
      edtProfesionalColorDisponible_Visible = -1 ;
      edtProfesionalCOP_Visible = -1 ;
      edtProfesionalCorreo_Visible = -1 ;
      edtProfesionalDescripcion_Visible = -1 ;
      cmbProfesionalSexo.setVisible( -1 );
      edtProfesionalFechaNacimiento_Visible = -1 ;
      edtProfesionalNombreCompleto2_Visible = -1 ;
      edtProfesionalNombres_Visible = -1 ;
      edtProfesionalApellidoMaterno_Visible = -1 ;
      edtProfesionalApellidoPaterno_Visible = -1 ;
      edtProfesionalNroDocumento_Visible = -1 ;
      cmbProfesionalTipoDocumento.setVisible( -1 );
      edtProfesionalId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Profesional" );
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
      Ddo_grid_Datalistproc = "WPPacienteGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|1:DNI,6:RUC,2:LIBRETA ELECTORAL,4:CARNET DE EXTRANJERIA,7:PASAPORTE,0:SIN DOCUMENTO|||||||M:Masculino,F:Femenino||||||30:30 minutos,60:1 hora||||||||||||||1:WWP_TSChecked,2:WWP_TSUnChecked|CV:Cuenta Verificada,CP:Cuenta Por Verificar|A:Activo,P:Pendiente,I:Inactivo" ;
      Ddo_grid_Allowmultipleselection = "|T|||||||T||||||T|||||||||||||||T|T" ;
      Ddo_grid_Datalisttype = "|FixedValues|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic||FixedValues|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|Dynamic||Dynamic|Dynamic|Dynamic||Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|||FixedValues|FixedValues|FixedValues" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|T|T||T|T|T|T|T|T|T|T||T|T|T||T|T|T|T|T|||T|T|T" ;
      Ddo_grid_Filterisrange = "T|||||||P|||||||||T||||||||||T|P|||" ;
      Ddo_grid_Filtertype = "Numeric||Character|Character|Character|Character|Character|Date||Character|Character|Character|Character|Character||Character|Numeric|Character|Character|Character||Character|Character|Character|Character|Character|Numeric|Date|||" ;
      Ddo_grid_Includefilter = "T||T|T|T|T|T|T||T|T|T|T|T||T|T|T|T|T||T|T|T|T|T|T|T|||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T||T|T|T|T|T|T|T|T|T|T|T|T|||T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6||7|8|9|10|11|12|13|14|15|16|17|18|||19|20|21|22|23|24|25|26|27|28" ;
      Ddo_grid_Columnids = "2:ProfesionalId|3:ProfesionalTipoDocumento|4:ProfesionalNroDocumento|5:ProfesionalApellidoPaterno|6:ProfesionalApellidoMaterno|7:ProfesionalNombres|8:ProfesionalNombreCompleto2|9:ProfesionalFechaNacimiento|10:ProfesionalSexo|11:ProfesionalDescripcion|12:ProfesionalCorreo|13:ProfesionalCOP|14:ProfesionalColorDisponible|15:ProfesionalColorCita|16:ProfesionalTiempoCita|17:ProfesionalDireccion|18:PaisId|19:PaisDescripcion|20:UbigeoCode|21:UbigeoNombre|22:ProfesionalFoto|23:ProfesionalTwitter|24:ProfesionalFacebook|25:ProfesionalInstagram|26:ProfesionalLinkedin|27:ProfesionalTelefono|28:SecUserId|29:ProfesionalFechaRegistro|30:ProfesionalTerminosCondiciones|31:ProfesionalEstadoCuenta|32:ProfesionalEstado" ;
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
      GXCCtl = "PROFESIONALTIPODOCUMENTO_" + sGXsfl_43_idx ;
      cmbProfesionalTipoDocumento.setName( GXCCtl );
      cmbProfesionalTipoDocumento.setWebtags( "" );
      cmbProfesionalTipoDocumento.addItem("1", "DNI", (short)(0));
      cmbProfesionalTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbProfesionalTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbProfesionalTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbProfesionalTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbProfesionalTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbProfesionalTipoDocumento.getItemCount() > 0 )
      {
         A173ProfesionalTipoDocumento = cmbProfesionalTipoDocumento.getValidValue(A173ProfesionalTipoDocumento) ;
      }
      GXCCtl = "PROFESIONALSEXO_" + sGXsfl_43_idx ;
      cmbProfesionalSexo.setName( GXCCtl );
      cmbProfesionalSexo.setWebtags( "" );
      cmbProfesionalSexo.addItem("M", "Masculino", (short)(0));
      cmbProfesionalSexo.addItem("F", "Femenino", (short)(0));
      if ( cmbProfesionalSexo.getItemCount() > 0 )
      {
         A177ProfesionalSexo = cmbProfesionalSexo.getValidValue(A177ProfesionalSexo) ;
      }
      GXCCtl = "PROFESIONALTIEMPOCITA_" + sGXsfl_43_idx ;
      cmbProfesionalTiempoCita.setName( GXCCtl );
      cmbProfesionalTiempoCita.setWebtags( "" );
      cmbProfesionalTiempoCita.addItem("30", "30 minutos", (short)(0));
      cmbProfesionalTiempoCita.addItem("60", "1 hora", (short)(0));
      if ( cmbProfesionalTiempoCita.getItemCount() > 0 )
      {
         A182ProfesionalTiempoCita = (byte)(GXutil.lval( cmbProfesionalTiempoCita.getValidValue(GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0))))) ;
      }
      GXCCtl = "PROFESIONALTERMINOSCONDICIONES_" + sGXsfl_43_idx ;
      chkProfesionalTerminosCondiciones.setName( GXCCtl );
      chkProfesionalTerminosCondiciones.setWebtags( "" );
      chkProfesionalTerminosCondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkProfesionalTerminosCondiciones.getInternalname(), "TitleCaption", chkProfesionalTerminosCondiciones.getCaption(), !bGXsfl_43_Refreshing);
      chkProfesionalTerminosCondiciones.setCheckedValue( "false" );
      A196ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( A196ProfesionalTerminosCondiciones)) ;
      GXCCtl = "PROFESIONALESTADOCUENTA_" + sGXsfl_43_idx ;
      cmbProfesionalEstadoCuenta.setName( GXCCtl );
      cmbProfesionalEstadoCuenta.setWebtags( "" );
      cmbProfesionalEstadoCuenta.addItem("CV", "Cuenta Verificada", (short)(0));
      cmbProfesionalEstadoCuenta.addItem("CP", "Cuenta Por Verificar", (short)(0));
      if ( cmbProfesionalEstadoCuenta.getItemCount() > 0 )
      {
         A197ProfesionalEstadoCuenta = cmbProfesionalEstadoCuenta.getValidValue(A197ProfesionalEstadoCuenta) ;
      }
      GXCCtl = "PROFESIONALESTADO_" + sGXsfl_43_idx ;
      cmbProfesionalEstado.setName( GXCCtl );
      cmbProfesionalEstado.setWebtags( "" );
      cmbProfesionalEstado.addItem("A", "Activo", (short)(0));
      cmbProfesionalEstado.addItem("P", "Pendiente", (short)(0));
      cmbProfesionalEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbProfesionalEstado.getItemCount() > 0 )
      {
         A198ProfesionalEstado = cmbProfesionalEstado.getValidValue(A198ProfesionalEstado) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtProfesionalId_Visible',ctrl:'PROFESIONALID',prop:'Visible'},{av:'cmbProfesionalTipoDocumento'},{av:'edtProfesionalNroDocumento_Visible',ctrl:'PROFESIONALNRODOCUMENTO',prop:'Visible'},{av:'edtProfesionalApellidoPaterno_Visible',ctrl:'PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{av:'edtProfesionalApellidoMaterno_Visible',ctrl:'PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{av:'edtProfesionalNombres_Visible',ctrl:'PROFESIONALNOMBRES',prop:'Visible'},{av:'edtProfesionalNombreCompleto2_Visible',ctrl:'PROFESIONALNOMBRECOMPLETO2',prop:'Visible'},{av:'edtProfesionalFechaNacimiento_Visible',ctrl:'PROFESIONALFECHANACIMIENTO',prop:'Visible'},{av:'cmbProfesionalSexo'},{av:'edtProfesionalDescripcion_Visible',ctrl:'PROFESIONALDESCRIPCION',prop:'Visible'},{av:'edtProfesionalCorreo_Visible',ctrl:'PROFESIONALCORREO',prop:'Visible'},{av:'edtProfesionalCOP_Visible',ctrl:'PROFESIONALCOP',prop:'Visible'},{av:'edtProfesionalColorDisponible_Visible',ctrl:'PROFESIONALCOLORDISPONIBLE',prop:'Visible'},{av:'edtProfesionalColorCita_Visible',ctrl:'PROFESIONALCOLORCITA',prop:'Visible'},{av:'cmbProfesionalTiempoCita'},{av:'edtProfesionalDireccion_Visible',ctrl:'PROFESIONALDIRECCION',prop:'Visible'},{av:'edtPaisId_Visible',ctrl:'PAISID',prop:'Visible'},{av:'edtPaisDescripcion_Visible',ctrl:'PAISDESCRIPCION',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtProfesionalFoto_Visible',ctrl:'PROFESIONALFOTO',prop:'Visible'},{av:'edtProfesionalTwitter_Visible',ctrl:'PROFESIONALTWITTER',prop:'Visible'},{av:'edtProfesionalFacebook_Visible',ctrl:'PROFESIONALFACEBOOK',prop:'Visible'},{av:'edtProfesionalInstagram_Visible',ctrl:'PROFESIONALINSTAGRAM',prop:'Visible'},{av:'edtProfesionalLinkedin_Visible',ctrl:'PROFESIONALLINKEDIN',prop:'Visible'},{av:'edtProfesionalTelefono_Visible',ctrl:'PROFESIONALTELEFONO',prop:'Visible'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtProfesionalFechaRegistro_Visible',ctrl:'PROFESIONALFECHAREGISTRO',prop:'Visible'},{av:'chkProfesionalTerminosCondiciones.getVisible()',ctrl:'PROFESIONALTERMINOSCONDICIONES',prop:'Visible'},{av:'cmbProfesionalEstadoCuenta'},{av:'cmbProfesionalEstado'},{av:'AV94GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV95GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e142R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e212R2',iparms:[{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'A43PaisId',fld:'PAISID',pic:'ZZZ9'},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''},{av:'A190ProfesionalTwitter',fld:'PROFESIONALTWITTER',pic:''},{av:'A191ProfesionalFacebook',fld:'PROFESIONALFACEBOOK',pic:''},{av:'A192ProfesionalInstagram',fld:'PROFESIONALINSTAGRAM',pic:''},{av:'A193ProfesionalLinkedin',fld:'PROFESIONALLINKEDIN',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV96Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV98Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtPaisDescripcion_Link',ctrl:'PAISDESCRIPCION',prop:'Link'},{av:'edtUbigeoNombre_Link',ctrl:'UBIGEONOMBRE',prop:'Link'},{av:'edtProfesionalTwitter_Linktarget',ctrl:'PROFESIONALTWITTER',prop:'Linktarget'},{av:'edtProfesionalTwitter_Link',ctrl:'PROFESIONALTWITTER',prop:'Link'},{av:'edtProfesionalFacebook_Linktarget',ctrl:'PROFESIONALFACEBOOK',prop:'Linktarget'},{av:'edtProfesionalFacebook_Link',ctrl:'PROFESIONALFACEBOOK',prop:'Link'},{av:'edtProfesionalInstagram_Linktarget',ctrl:'PROFESIONALINSTAGRAM',prop:'Linktarget'},{av:'edtProfesionalInstagram_Link',ctrl:'PROFESIONALINSTAGRAM',prop:'Link'},{av:'edtProfesionalLinkedin_Linktarget',ctrl:'PROFESIONALLINKEDIN',prop:'Linktarget'},{av:'edtProfesionalLinkedin_Link',ctrl:'PROFESIONALLINKEDIN',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e152R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtProfesionalId_Visible',ctrl:'PROFESIONALID',prop:'Visible'},{av:'cmbProfesionalTipoDocumento'},{av:'edtProfesionalNroDocumento_Visible',ctrl:'PROFESIONALNRODOCUMENTO',prop:'Visible'},{av:'edtProfesionalApellidoPaterno_Visible',ctrl:'PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{av:'edtProfesionalApellidoMaterno_Visible',ctrl:'PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{av:'edtProfesionalNombres_Visible',ctrl:'PROFESIONALNOMBRES',prop:'Visible'},{av:'edtProfesionalNombreCompleto2_Visible',ctrl:'PROFESIONALNOMBRECOMPLETO2',prop:'Visible'},{av:'edtProfesionalFechaNacimiento_Visible',ctrl:'PROFESIONALFECHANACIMIENTO',prop:'Visible'},{av:'cmbProfesionalSexo'},{av:'edtProfesionalDescripcion_Visible',ctrl:'PROFESIONALDESCRIPCION',prop:'Visible'},{av:'edtProfesionalCorreo_Visible',ctrl:'PROFESIONALCORREO',prop:'Visible'},{av:'edtProfesionalCOP_Visible',ctrl:'PROFESIONALCOP',prop:'Visible'},{av:'edtProfesionalColorDisponible_Visible',ctrl:'PROFESIONALCOLORDISPONIBLE',prop:'Visible'},{av:'edtProfesionalColorCita_Visible',ctrl:'PROFESIONALCOLORCITA',prop:'Visible'},{av:'cmbProfesionalTiempoCita'},{av:'edtProfesionalDireccion_Visible',ctrl:'PROFESIONALDIRECCION',prop:'Visible'},{av:'edtPaisId_Visible',ctrl:'PAISID',prop:'Visible'},{av:'edtPaisDescripcion_Visible',ctrl:'PAISDESCRIPCION',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtProfesionalFoto_Visible',ctrl:'PROFESIONALFOTO',prop:'Visible'},{av:'edtProfesionalTwitter_Visible',ctrl:'PROFESIONALTWITTER',prop:'Visible'},{av:'edtProfesionalFacebook_Visible',ctrl:'PROFESIONALFACEBOOK',prop:'Visible'},{av:'edtProfesionalInstagram_Visible',ctrl:'PROFESIONALINSTAGRAM',prop:'Visible'},{av:'edtProfesionalLinkedin_Visible',ctrl:'PROFESIONALLINKEDIN',prop:'Visible'},{av:'edtProfesionalTelefono_Visible',ctrl:'PROFESIONALTELEFONO',prop:'Visible'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtProfesionalFechaRegistro_Visible',ctrl:'PROFESIONALFECHAREGISTRO',prop:'Visible'},{av:'chkProfesionalTerminosCondiciones.getVisible()',ctrl:'PROFESIONALTERMINOSCONDICIONES',prop:'Visible'},{av:'cmbProfesionalEstadoCuenta'},{av:'cmbProfesionalEstado'},{av:'AV94GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV95GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtProfesionalId_Visible',ctrl:'PROFESIONALID',prop:'Visible'},{av:'cmbProfesionalTipoDocumento'},{av:'edtProfesionalNroDocumento_Visible',ctrl:'PROFESIONALNRODOCUMENTO',prop:'Visible'},{av:'edtProfesionalApellidoPaterno_Visible',ctrl:'PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{av:'edtProfesionalApellidoMaterno_Visible',ctrl:'PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{av:'edtProfesionalNombres_Visible',ctrl:'PROFESIONALNOMBRES',prop:'Visible'},{av:'edtProfesionalNombreCompleto2_Visible',ctrl:'PROFESIONALNOMBRECOMPLETO2',prop:'Visible'},{av:'edtProfesionalFechaNacimiento_Visible',ctrl:'PROFESIONALFECHANACIMIENTO',prop:'Visible'},{av:'cmbProfesionalSexo'},{av:'edtProfesionalDescripcion_Visible',ctrl:'PROFESIONALDESCRIPCION',prop:'Visible'},{av:'edtProfesionalCorreo_Visible',ctrl:'PROFESIONALCORREO',prop:'Visible'},{av:'edtProfesionalCOP_Visible',ctrl:'PROFESIONALCOP',prop:'Visible'},{av:'edtProfesionalColorDisponible_Visible',ctrl:'PROFESIONALCOLORDISPONIBLE',prop:'Visible'},{av:'edtProfesionalColorCita_Visible',ctrl:'PROFESIONALCOLORCITA',prop:'Visible'},{av:'cmbProfesionalTiempoCita'},{av:'edtProfesionalDireccion_Visible',ctrl:'PROFESIONALDIRECCION',prop:'Visible'},{av:'edtPaisId_Visible',ctrl:'PAISID',prop:'Visible'},{av:'edtPaisDescripcion_Visible',ctrl:'PAISDESCRIPCION',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtProfesionalFoto_Visible',ctrl:'PROFESIONALFOTO',prop:'Visible'},{av:'edtProfesionalTwitter_Visible',ctrl:'PROFESIONALTWITTER',prop:'Visible'},{av:'edtProfesionalFacebook_Visible',ctrl:'PROFESIONALFACEBOOK',prop:'Visible'},{av:'edtProfesionalInstagram_Visible',ctrl:'PROFESIONALINSTAGRAM',prop:'Visible'},{av:'edtProfesionalLinkedin_Visible',ctrl:'PROFESIONALLINKEDIN',prop:'Visible'},{av:'edtProfesionalTelefono_Visible',ctrl:'PROFESIONALTELEFONO',prop:'Visible'},{av:'edtSecUserId_Visible',ctrl:'SECUSERID',prop:'Visible'},{av:'edtProfesionalFechaRegistro_Visible',ctrl:'PROFESIONALFECHAREGISTRO',prop:'Visible'},{av:'chkProfesionalTerminosCondiciones.getVisible()',ctrl:'PROFESIONALTERMINOSCONDICIONES',prop:'Visible'},{av:'cmbProfesionalEstadoCuenta'},{av:'cmbProfesionalEstado'},{av:'AV94GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV95GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e162R2',iparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e172R2',iparms:[{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e182R2',iparms:[{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFProfesionalId',fld:'vTFPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV28TFProfesionalId_To',fld:'vTFPROFESIONALID_TO',pic:'ZZZZZZZ9'},{av:'AV30TFProfesionalTipoDocumento_Sels',fld:'vTFPROFESIONALTIPODOCUMENTO_SELS',pic:''},{av:'AV31TFProfesionalNroDocumento',fld:'vTFPROFESIONALNRODOCUMENTO',pic:''},{av:'AV32TFProfesionalNroDocumento_Sel',fld:'vTFPROFESIONALNRODOCUMENTO_SEL',pic:''},{av:'AV33TFProfesionalApellidoPaterno',fld:'vTFPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV34TFProfesionalApellidoPaterno_Sel',fld:'vTFPROFESIONALAPELLIDOPATERNO_SEL',pic:''},{av:'AV35TFProfesionalApellidoMaterno',fld:'vTFPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV36TFProfesionalApellidoMaterno_Sel',fld:'vTFPROFESIONALAPELLIDOMATERNO_SEL',pic:''},{av:'AV37TFProfesionalNombres',fld:'vTFPROFESIONALNOMBRES',pic:''},{av:'AV38TFProfesionalNombres_Sel',fld:'vTFPROFESIONALNOMBRES_SEL',pic:''},{av:'AV39TFProfesionalNombreCompleto2',fld:'vTFPROFESIONALNOMBRECOMPLETO2',pic:''},{av:'AV40TFProfesionalNombreCompleto2_Sel',fld:'vTFPROFESIONALNOMBRECOMPLETO2_SEL',pic:''},{av:'AV41TFProfesionalFechaNacimiento',fld:'vTFPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV42TFProfesionalFechaNacimiento_To',fld:'vTFPROFESIONALFECHANACIMIENTO_TO',pic:''},{av:'AV47TFProfesionalSexo_Sels',fld:'vTFPROFESIONALSEXO_SELS',pic:''},{av:'AV48TFProfesionalDescripcion',fld:'vTFPROFESIONALDESCRIPCION',pic:''},{av:'AV49TFProfesionalDescripcion_Sel',fld:'vTFPROFESIONALDESCRIPCION_SEL',pic:''},{av:'AV50TFProfesionalCorreo',fld:'vTFPROFESIONALCORREO',pic:''},{av:'AV51TFProfesionalCorreo_Sel',fld:'vTFPROFESIONALCORREO_SEL',pic:''},{av:'AV52TFProfesionalCOP',fld:'vTFPROFESIONALCOP',pic:''},{av:'AV53TFProfesionalCOP_Sel',fld:'vTFPROFESIONALCOP_SEL',pic:''},{av:'AV54TFProfesionalColorDisponible',fld:'vTFPROFESIONALCOLORDISPONIBLE',pic:''},{av:'AV55TFProfesionalColorDisponible_Sel',fld:'vTFPROFESIONALCOLORDISPONIBLE_SEL',pic:''},{av:'AV56TFProfesionalColorCita',fld:'vTFPROFESIONALCOLORCITA',pic:''},{av:'AV57TFProfesionalColorCita_Sel',fld:'vTFPROFESIONALCOLORCITA_SEL',pic:''},{av:'AV59TFProfesionalTiempoCita_Sels',fld:'vTFPROFESIONALTIEMPOCITA_SELS',pic:''},{av:'AV60TFProfesionalDireccion',fld:'vTFPROFESIONALDIRECCION',pic:''},{av:'AV61TFProfesionalDireccion_Sel',fld:'vTFPROFESIONALDIRECCION_SEL',pic:''},{av:'AV62TFPaisId',fld:'vTFPAISID',pic:'ZZZ9'},{av:'AV63TFPaisId_To',fld:'vTFPAISID_TO',pic:'ZZZ9'},{av:'AV64TFPaisDescripcion',fld:'vTFPAISDESCRIPCION',pic:''},{av:'AV65TFPaisDescripcion_Sel',fld:'vTFPAISDESCRIPCION_SEL',pic:''},{av:'AV66TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV67TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV68TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV69TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV70TFProfesionalTwitter',fld:'vTFPROFESIONALTWITTER',pic:''},{av:'AV71TFProfesionalTwitter_Sel',fld:'vTFPROFESIONALTWITTER_SEL',pic:''},{av:'AV72TFProfesionalFacebook',fld:'vTFPROFESIONALFACEBOOK',pic:''},{av:'AV73TFProfesionalFacebook_Sel',fld:'vTFPROFESIONALFACEBOOK_SEL',pic:''},{av:'AV74TFProfesionalInstagram',fld:'vTFPROFESIONALINSTAGRAM',pic:''},{av:'AV75TFProfesionalInstagram_Sel',fld:'vTFPROFESIONALINSTAGRAM_SEL',pic:''},{av:'AV76TFProfesionalLinkedin',fld:'vTFPROFESIONALLINKEDIN',pic:''},{av:'AV77TFProfesionalLinkedin_Sel',fld:'vTFPROFESIONALLINKEDIN_SEL',pic:''},{av:'AV78TFProfesionalTelefono',fld:'vTFPROFESIONALTELEFONO',pic:''},{av:'AV79TFProfesionalTelefono_Sel',fld:'vTFPROFESIONALTELEFONO_SEL',pic:''},{av:'AV80TFSecUserId',fld:'vTFSECUSERID',pic:'ZZZ9'},{av:'AV81TFSecUserId_To',fld:'vTFSECUSERID_TO',pic:'ZZZ9'},{av:'AV82TFProfesionalFechaRegistro',fld:'vTFPROFESIONALFECHAREGISTRO',pic:''},{av:'AV83TFProfesionalFechaRegistro_To',fld:'vTFPROFESIONALFECHAREGISTRO_TO',pic:''},{av:'AV87TFProfesionalTerminosCondiciones_Sel',fld:'vTFPROFESIONALTERMINOSCONDICIONES_SEL',pic:'9'},{av:'AV89TFProfesionalEstadoCuenta_Sels',fld:'vTFPROFESIONALESTADOCUENTA_SELS',pic:''},{av:'AV91TFProfesionalEstado_Sels',fld:'vTFPROFESIONALESTADO_SELS',pic:''},{av:'AV160Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV97IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV99IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV100IsAuthorized_PaisDescripcion',fld:'vISAUTHORIZED_PAISDESCRIPCION',pic:'',hsh:true},{av:'AV101IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV90TFProfesionalEstado_SelsJson',fld:'vTFPROFESIONALESTADO_SELSJSON',pic:''},{av:'AV88TFProfesionalEstadoCuenta_SelsJson',fld:'vTFPROFESIONALESTADOCUENTA_SELSJSON',pic:''},{av:'AV58TFProfesionalTiempoCita_SelsJson',fld:'vTFPROFESIONALTIEMPOCITA_SELSJSON',pic:''},{av:'AV46TFProfesionalSexo_SelsJson',fld:'vTFPROFESIONALSEXO_SELSJSON',pic:''},{av:'AV29TFProfesionalTipoDocumento_SelsJson',fld:'vTFPROFESIONALTIPODOCUMENTO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO","{handler:'valid_Profesionalapellidopaterno',iparms:[]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO","{handler:'valid_Profesionalapellidomaterno',iparms:[]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALNOMBRES","{handler:'valid_Profesionalnombres',iparms:[]");
      setEventMetadata("VALID_PROFESIONALNOMBRES",",oparms:[]}");
      setEventMetadata("VALID_PAISID","{handler:'valid_Paisid',iparms:[]");
      setEventMetadata("VALID_PAISID",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Profesionalestado',iparms:[]");
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
      AV30TFProfesionalTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFProfesionalNroDocumento = "" ;
      AV32TFProfesionalNroDocumento_Sel = "" ;
      AV33TFProfesionalApellidoPaterno = "" ;
      AV34TFProfesionalApellidoPaterno_Sel = "" ;
      AV35TFProfesionalApellidoMaterno = "" ;
      AV36TFProfesionalApellidoMaterno_Sel = "" ;
      AV37TFProfesionalNombres = "" ;
      AV38TFProfesionalNombres_Sel = "" ;
      AV39TFProfesionalNombreCompleto2 = "" ;
      AV40TFProfesionalNombreCompleto2_Sel = "" ;
      AV41TFProfesionalFechaNacimiento = GXutil.nullDate() ;
      AV42TFProfesionalFechaNacimiento_To = GXutil.nullDate() ;
      AV47TFProfesionalSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFProfesionalDescripcion = "" ;
      AV49TFProfesionalDescripcion_Sel = "" ;
      AV50TFProfesionalCorreo = "" ;
      AV51TFProfesionalCorreo_Sel = "" ;
      AV52TFProfesionalCOP = "" ;
      AV53TFProfesionalCOP_Sel = "" ;
      AV54TFProfesionalColorDisponible = "" ;
      AV55TFProfesionalColorDisponible_Sel = "" ;
      AV56TFProfesionalColorCita = "" ;
      AV57TFProfesionalColorCita_Sel = "" ;
      AV59TFProfesionalTiempoCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV60TFProfesionalDireccion = "" ;
      AV61TFProfesionalDireccion_Sel = "" ;
      AV64TFPaisDescripcion = "" ;
      AV65TFPaisDescripcion_Sel = "" ;
      AV66TFUbigeoCode = "" ;
      AV67TFUbigeoCode_Sel = "" ;
      AV68TFUbigeoNombre = "" ;
      AV69TFUbigeoNombre_Sel = "" ;
      AV70TFProfesionalTwitter = "" ;
      AV71TFProfesionalTwitter_Sel = "" ;
      AV72TFProfesionalFacebook = "" ;
      AV73TFProfesionalFacebook_Sel = "" ;
      AV74TFProfesionalInstagram = "" ;
      AV75TFProfesionalInstagram_Sel = "" ;
      AV76TFProfesionalLinkedin = "" ;
      AV77TFProfesionalLinkedin_Sel = "" ;
      AV78TFProfesionalTelefono = "" ;
      AV79TFProfesionalTelefono_Sel = "" ;
      AV82TFProfesionalFechaRegistro = GXutil.nullDate() ;
      AV83TFProfesionalFechaRegistro_To = GXutil.nullDate() ;
      AV89TFProfesionalEstadoCuenta_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91TFProfesionalEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV160Pgmname = "" ;
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
      AV92DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV44DDO_ProfesionalFechaNacimientoAuxDateTo = GXutil.nullDate() ;
      AV85DDO_ProfesionalFechaRegistroAuxDateTo = GXutil.nullDate() ;
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV29TFProfesionalTipoDocumento_SelsJson = "" ;
      AV46TFProfesionalSexo_SelsJson = "" ;
      AV58TFProfesionalTiempoCita_SelsJson = "" ;
      AV88TFProfesionalEstadoCuenta_SelsJson = "" ;
      AV90TFProfesionalEstado_SelsJson = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      AV43DDO_ProfesionalFechaNacimientoAuxDate = GXutil.nullDate() ;
      AV84DDO_ProfesionalFechaRegistroAuxDate = GXutil.nullDate() ;
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
      AV96Update = "" ;
      AV98Delete = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A177ProfesionalSexo = "" ;
      A178ProfesionalDescripcion = "" ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A180ProfesionalColorDisponible = "" ;
      A181ProfesionalColorCita = "" ;
      A183ProfesionalDireccion = "" ;
      A184PaisDescripcion = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A189ProfesionalFoto = "" ;
      A190ProfesionalTwitter = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A193ProfesionalLinkedin = "" ;
      A194ProfesionalTelefono = "" ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV45DDO_ProfesionalFechaNacimientoAuxDateText = "" ;
      ucTfprofesionalfechanacimiento_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV86DDO_ProfesionalFechaRegistroAuxDateText = "" ;
      ucTfprofesionalfecharegistro_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A40000ProfesionalFoto_GXI = "" ;
      AV108Wppacienteds_4_tfprofesionaltipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV121Wppacienteds_17_tfprofesionalsexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV132Wppacienteds_28_tfprofesionaltiempocita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV158Wppacienteds_54_tfprofesionalestadocuenta_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV159Wppacienteds_55_tfprofesionalestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV105Wppacienteds_1_filterfulltext = "" ;
      lV109Wppacienteds_5_tfprofesionalnrodocumento = "" ;
      lV111Wppacienteds_7_tfprofesionalapellidopaterno = "" ;
      lV113Wppacienteds_9_tfprofesionalapellidomaterno = "" ;
      lV115Wppacienteds_11_tfprofesionalnombres = "" ;
      lV117Wppacienteds_13_tfprofesionalnombrecompleto2 = "" ;
      lV122Wppacienteds_18_tfprofesionaldescripcion = "" ;
      lV124Wppacienteds_20_tfprofesionalcorreo = "" ;
      lV126Wppacienteds_22_tfprofesionalcop = "" ;
      lV128Wppacienteds_24_tfprofesionalcolordisponible = "" ;
      lV130Wppacienteds_26_tfprofesionalcolorcita = "" ;
      lV133Wppacienteds_29_tfprofesionaldireccion = "" ;
      lV137Wppacienteds_33_tfpaisdescripcion = "" ;
      lV139Wppacienteds_35_tfubigeocode = "" ;
      lV141Wppacienteds_37_tfubigeonombre = "" ;
      lV143Wppacienteds_39_tfprofesionaltwitter = "" ;
      lV145Wppacienteds_41_tfprofesionalfacebook = "" ;
      lV147Wppacienteds_43_tfprofesionalinstagram = "" ;
      lV149Wppacienteds_45_tfprofesionallinkedin = "" ;
      lV151Wppacienteds_47_tfprofesionaltelefono = "" ;
      AV105Wppacienteds_1_filterfulltext = "" ;
      AV110Wppacienteds_6_tfprofesionalnrodocumento_sel = "" ;
      AV109Wppacienteds_5_tfprofesionalnrodocumento = "" ;
      AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel = "" ;
      AV111Wppacienteds_7_tfprofesionalapellidopaterno = "" ;
      AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel = "" ;
      AV113Wppacienteds_9_tfprofesionalapellidomaterno = "" ;
      AV116Wppacienteds_12_tfprofesionalnombres_sel = "" ;
      AV115Wppacienteds_11_tfprofesionalnombres = "" ;
      AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel = "" ;
      AV117Wppacienteds_13_tfprofesionalnombrecompleto2 = "" ;
      AV119Wppacienteds_15_tfprofesionalfechanacimiento = GXutil.nullDate() ;
      AV120Wppacienteds_16_tfprofesionalfechanacimiento_to = GXutil.nullDate() ;
      AV123Wppacienteds_19_tfprofesionaldescripcion_sel = "" ;
      AV122Wppacienteds_18_tfprofesionaldescripcion = "" ;
      AV125Wppacienteds_21_tfprofesionalcorreo_sel = "" ;
      AV124Wppacienteds_20_tfprofesionalcorreo = "" ;
      AV127Wppacienteds_23_tfprofesionalcop_sel = "" ;
      AV126Wppacienteds_22_tfprofesionalcop = "" ;
      AV129Wppacienteds_25_tfprofesionalcolordisponible_sel = "" ;
      AV128Wppacienteds_24_tfprofesionalcolordisponible = "" ;
      AV131Wppacienteds_27_tfprofesionalcolorcita_sel = "" ;
      AV130Wppacienteds_26_tfprofesionalcolorcita = "" ;
      AV134Wppacienteds_30_tfprofesionaldireccion_sel = "" ;
      AV133Wppacienteds_29_tfprofesionaldireccion = "" ;
      AV138Wppacienteds_34_tfpaisdescripcion_sel = "" ;
      AV137Wppacienteds_33_tfpaisdescripcion = "" ;
      AV140Wppacienteds_36_tfubigeocode_sel = "" ;
      AV139Wppacienteds_35_tfubigeocode = "" ;
      AV142Wppacienteds_38_tfubigeonombre_sel = "" ;
      AV141Wppacienteds_37_tfubigeonombre = "" ;
      AV144Wppacienteds_40_tfprofesionaltwitter_sel = "" ;
      AV143Wppacienteds_39_tfprofesionaltwitter = "" ;
      AV146Wppacienteds_42_tfprofesionalfacebook_sel = "" ;
      AV145Wppacienteds_41_tfprofesionalfacebook = "" ;
      AV148Wppacienteds_44_tfprofesionalinstagram_sel = "" ;
      AV147Wppacienteds_43_tfprofesionalinstagram = "" ;
      AV150Wppacienteds_46_tfprofesionallinkedin_sel = "" ;
      AV149Wppacienteds_45_tfprofesionallinkedin = "" ;
      AV152Wppacienteds_48_tfprofesionaltelefono_sel = "" ;
      AV151Wppacienteds_47_tfprofesionaltelefono = "" ;
      AV155Wppacienteds_51_tfprofesionalfecharegistro = GXutil.nullDate() ;
      AV156Wppacienteds_52_tfprofesionalfecharegistro_to = GXutil.nullDate() ;
      H002R2_A198ProfesionalEstado = new String[] {""} ;
      H002R2_A197ProfesionalEstadoCuenta = new String[] {""} ;
      H002R2_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      H002R2_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      H002R2_A6SecUserId = new short[1] ;
      H002R2_A194ProfesionalTelefono = new String[] {""} ;
      H002R2_A193ProfesionalLinkedin = new String[] {""} ;
      H002R2_A192ProfesionalInstagram = new String[] {""} ;
      H002R2_A191ProfesionalFacebook = new String[] {""} ;
      H002R2_A190ProfesionalTwitter = new String[] {""} ;
      H002R2_A189ProfesionalFoto = new String[] {""} ;
      H002R2_A40000ProfesionalFoto_GXI = new String[] {""} ;
      H002R2_A44UbigeoCode = new String[] {""} ;
      H002R2_A184PaisDescripcion = new String[] {""} ;
      H002R2_A43PaisId = new short[1] ;
      H002R2_A183ProfesionalDireccion = new String[] {""} ;
      H002R2_A182ProfesionalTiempoCita = new byte[1] ;
      H002R2_A181ProfesionalColorCita = new String[] {""} ;
      H002R2_A180ProfesionalColorDisponible = new String[] {""} ;
      H002R2_A88ProfesionalCOP = new String[] {""} ;
      H002R2_A179ProfesionalCorreo = new String[] {""} ;
      H002R2_A178ProfesionalDescripcion = new String[] {""} ;
      H002R2_A177ProfesionalSexo = new String[] {""} ;
      H002R2_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      H002R2_A174ProfesionalNroDocumento = new String[] {""} ;
      H002R2_A173ProfesionalTipoDocumento = new String[] {""} ;
      H002R2_A31ProfesionalId = new int[1] ;
      H002R2_A84ProfesionalNombres = new String[] {""} ;
      H002R2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H002R2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H002R2_A188UbigeoDistrito = new String[] {""} ;
      H002R2_A187UbigeoProvincia = new String[] {""} ;
      H002R2_A186UbigeoDepartamento = new String[] {""} ;
      H002R3_AGRID_nRecordCount = new long[1] ;
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
      GXt_char54 = "" ;
      GXv_char55 = new String[1] ;
      GXt_char52 = "" ;
      GXv_char53 = new String[1] ;
      GXt_char50 = "" ;
      GXv_char51 = new String[1] ;
      GXt_char48 = "" ;
      GXv_char49 = new String[1] ;
      GXt_char46 = "" ;
      GXv_char47 = new String[1] ;
      GXt_char44 = "" ;
      GXv_char45 = new String[1] ;
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
      GXv_SdtWWPGridState56 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      sImgUrl = "" ;
      gxphoneLink = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wppaciente__default(),
         new Object[] {
             new Object[] {
            H002R2_A198ProfesionalEstado, H002R2_A197ProfesionalEstadoCuenta, H002R2_A196ProfesionalTerminosCondiciones, H002R2_A195ProfesionalFechaRegistro, H002R2_A6SecUserId, H002R2_A194ProfesionalTelefono, H002R2_A193ProfesionalLinkedin, H002R2_A192ProfesionalInstagram, H002R2_A191ProfesionalFacebook, H002R2_A190ProfesionalTwitter,
            H002R2_A189ProfesionalFoto, H002R2_A40000ProfesionalFoto_GXI, H002R2_A44UbigeoCode, H002R2_A184PaisDescripcion, H002R2_A43PaisId, H002R2_A183ProfesionalDireccion, H002R2_A182ProfesionalTiempoCita, H002R2_A181ProfesionalColorCita, H002R2_A180ProfesionalColorDisponible, H002R2_A88ProfesionalCOP,
            H002R2_A179ProfesionalCorreo, H002R2_A178ProfesionalDescripcion, H002R2_A177ProfesionalSexo, H002R2_A176ProfesionalFechaNacimiento, H002R2_A174ProfesionalNroDocumento, H002R2_A173ProfesionalTipoDocumento, H002R2_A31ProfesionalId, H002R2_A84ProfesionalNombres, H002R2_A86ProfesionalApellidoMaterno, H002R2_A85ProfesionalApellidoPaterno,
            H002R2_A188UbigeoDistrito, H002R2_A187UbigeoProvincia, H002R2_A186UbigeoDepartamento
            }
            , new Object[] {
            H002R3_AGRID_nRecordCount
            }
         }
      );
      AV160Pgmname = "WPPaciente" ;
      /* GeneXus formulas. */
      AV160Pgmname = "WPPaciente" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV26ManageFiltersExecutionStep ;
   private byte AV87TFProfesionalTerminosCondiciones_Sel ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte A182ProfesionalTiempoCita ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV62TFPaisId ;
   private short AV63TFPaisId_To ;
   private short AV80TFSecUserId ;
   private short AV81TFSecUserId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV135Wppacienteds_31_tfpaisid ;
   private short AV136Wppacienteds_32_tfpaisid_to ;
   private short AV153Wppacienteds_49_tfsecuserid ;
   private short AV154Wppacienteds_50_tfsecuserid_to ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV27TFProfesionalId ;
   private int AV28TFProfesionalId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtProfesionalId_Visible ;
   private int edtProfesionalNroDocumento_Visible ;
   private int edtProfesionalApellidoPaterno_Visible ;
   private int edtProfesionalApellidoMaterno_Visible ;
   private int edtProfesionalNombres_Visible ;
   private int edtProfesionalNombreCompleto2_Visible ;
   private int edtProfesionalFechaNacimiento_Visible ;
   private int edtProfesionalDescripcion_Visible ;
   private int edtProfesionalCorreo_Visible ;
   private int edtProfesionalCOP_Visible ;
   private int edtProfesionalColorDisponible_Visible ;
   private int edtProfesionalColorCita_Visible ;
   private int edtProfesionalDireccion_Visible ;
   private int edtPaisId_Visible ;
   private int edtPaisDescripcion_Visible ;
   private int edtUbigeoCode_Visible ;
   private int edtUbigeoNombre_Visible ;
   private int edtProfesionalFoto_Visible ;
   private int edtProfesionalTwitter_Visible ;
   private int edtProfesionalFacebook_Visible ;
   private int edtProfesionalInstagram_Visible ;
   private int edtProfesionalLinkedin_Visible ;
   private int edtProfesionalTelefono_Visible ;
   private int edtSecUserId_Visible ;
   private int edtProfesionalFechaRegistro_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int A31ProfesionalId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV108Wppacienteds_4_tfprofesionaltipodocumento_sels_size ;
   private int AV121Wppacienteds_17_tfprofesionalsexo_sels_size ;
   private int AV132Wppacienteds_28_tfprofesionaltiempocita_sels_size ;
   private int AV158Wppacienteds_54_tfprofesionalestadocuenta_sels_size ;
   private int AV159Wppacienteds_55_tfprofesionalestado_sels_size ;
   private int AV106Wppacienteds_2_tfprofesionalid ;
   private int AV107Wppacienteds_3_tfprofesionalid_to ;
   private int AV93PageToGo ;
   private int AV161GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV94GridCurrentPage ;
   private long AV95GridPageCount ;
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
   private String AV54TFProfesionalColorDisponible ;
   private String AV55TFProfesionalColorDisponible_Sel ;
   private String AV56TFProfesionalColorCita ;
   private String AV57TFProfesionalColorCita_Sel ;
   private String AV66TFUbigeoCode ;
   private String AV67TFUbigeoCode_Sel ;
   private String AV78TFProfesionalTelefono ;
   private String AV79TFProfesionalTelefono_Sel ;
   private String AV160Pgmname ;
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
   private String AV96Update ;
   private String edtavUpdate_Link ;
   private String AV98Delete ;
   private String edtavDelete_Link ;
   private String A173ProfesionalTipoDocumento ;
   private String A177ProfesionalSexo ;
   private String A180ProfesionalColorDisponible ;
   private String A181ProfesionalColorCita ;
   private String edtPaisDescripcion_Link ;
   private String A44UbigeoCode ;
   private String edtUbigeoNombre_Link ;
   private String edtProfesionalTwitter_Link ;
   private String edtProfesionalTwitter_Linktarget ;
   private String edtProfesionalFacebook_Link ;
   private String edtProfesionalFacebook_Linktarget ;
   private String edtProfesionalInstagram_Link ;
   private String edtProfesionalInstagram_Linktarget ;
   private String edtProfesionalLinkedin_Link ;
   private String edtProfesionalLinkedin_Linktarget ;
   private String A194ProfesionalTelefono ;
   private String A197ProfesionalEstadoCuenta ;
   private String A198ProfesionalEstado ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_profesionalfechanacimientoauxdates_Internalname ;
   private String edtavDdo_profesionalfechanacimientoauxdatetext_Internalname ;
   private String edtavDdo_profesionalfechanacimientoauxdatetext_Jsonclick ;
   private String Tfprofesionalfechanacimiento_rangepicker_Internalname ;
   private String divDdo_profesionalfecharegistroauxdates_Internalname ;
   private String edtavDdo_profesionalfecharegistroauxdatetext_Internalname ;
   private String edtavDdo_profesionalfecharegistroauxdatetext_Jsonclick ;
   private String Tfprofesionalfecharegistro_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalNroDocumento_Internalname ;
   private String edtProfesionalApellidoPaterno_Internalname ;
   private String edtProfesionalApellidoMaterno_Internalname ;
   private String edtProfesionalNombres_Internalname ;
   private String edtProfesionalNombreCompleto2_Internalname ;
   private String edtProfesionalFechaNacimiento_Internalname ;
   private String edtProfesionalDescripcion_Internalname ;
   private String edtProfesionalCorreo_Internalname ;
   private String edtProfesionalCOP_Internalname ;
   private String edtProfesionalColorDisponible_Internalname ;
   private String edtProfesionalColorCita_Internalname ;
   private String edtProfesionalDireccion_Internalname ;
   private String edtPaisId_Internalname ;
   private String edtPaisDescripcion_Internalname ;
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoNombre_Internalname ;
   private String edtProfesionalFoto_Internalname ;
   private String edtProfesionalTwitter_Internalname ;
   private String edtProfesionalFacebook_Internalname ;
   private String edtProfesionalInstagram_Internalname ;
   private String edtProfesionalLinkedin_Internalname ;
   private String edtProfesionalTelefono_Internalname ;
   private String edtSecUserId_Internalname ;
   private String edtProfesionalFechaRegistro_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String lV128Wppacienteds_24_tfprofesionalcolordisponible ;
   private String lV130Wppacienteds_26_tfprofesionalcolorcita ;
   private String lV139Wppacienteds_35_tfubigeocode ;
   private String lV151Wppacienteds_47_tfprofesionaltelefono ;
   private String AV129Wppacienteds_25_tfprofesionalcolordisponible_sel ;
   private String AV128Wppacienteds_24_tfprofesionalcolordisponible ;
   private String AV131Wppacienteds_27_tfprofesionalcolorcita_sel ;
   private String AV130Wppacienteds_26_tfprofesionalcolorcita ;
   private String AV140Wppacienteds_36_tfubigeocode_sel ;
   private String AV139Wppacienteds_35_tfubigeocode ;
   private String AV152Wppacienteds_48_tfprofesionaltelefono_sel ;
   private String AV151Wppacienteds_47_tfprofesionaltelefono ;
   private String GXt_char6 ;
   private String GXv_char8[] ;
   private String GXt_char13 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char54 ;
   private String GXv_char55[] ;
   private String GXt_char52 ;
   private String GXv_char53[] ;
   private String GXt_char50 ;
   private String GXv_char51[] ;
   private String GXt_char48 ;
   private String GXv_char49[] ;
   private String GXt_char46 ;
   private String GXv_char47[] ;
   private String GXt_char44 ;
   private String GXv_char45[] ;
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
   private String edtProfesionalId_Jsonclick ;
   private String GXCCtl ;
   private String edtProfesionalNroDocumento_Jsonclick ;
   private String edtProfesionalApellidoPaterno_Jsonclick ;
   private String edtProfesionalApellidoMaterno_Jsonclick ;
   private String edtProfesionalNombres_Jsonclick ;
   private String edtProfesionalNombreCompleto2_Jsonclick ;
   private String edtProfesionalFechaNacimiento_Jsonclick ;
   private String edtProfesionalDescripcion_Jsonclick ;
   private String edtProfesionalCorreo_Jsonclick ;
   private String edtProfesionalCOP_Jsonclick ;
   private String edtProfesionalColorDisponible_Jsonclick ;
   private String edtProfesionalColorCita_Jsonclick ;
   private String edtProfesionalDireccion_Jsonclick ;
   private String edtPaisId_Jsonclick ;
   private String edtPaisDescripcion_Jsonclick ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoNombre_Jsonclick ;
   private String sImgUrl ;
   private String edtProfesionalTwitter_Jsonclick ;
   private String edtProfesionalFacebook_Jsonclick ;
   private String edtProfesionalInstagram_Jsonclick ;
   private String edtProfesionalLinkedin_Jsonclick ;
   private String gxphoneLink ;
   private String edtProfesionalTelefono_Jsonclick ;
   private String edtSecUserId_Jsonclick ;
   private String edtProfesionalFechaRegistro_Jsonclick ;
   private java.util.Date AV41TFProfesionalFechaNacimiento ;
   private java.util.Date AV42TFProfesionalFechaNacimiento_To ;
   private java.util.Date AV82TFProfesionalFechaRegistro ;
   private java.util.Date AV83TFProfesionalFechaRegistro_To ;
   private java.util.Date AV44DDO_ProfesionalFechaNacimientoAuxDateTo ;
   private java.util.Date AV85DDO_ProfesionalFechaRegistroAuxDateTo ;
   private java.util.Date AV43DDO_ProfesionalFechaNacimientoAuxDate ;
   private java.util.Date AV84DDO_ProfesionalFechaRegistroAuxDate ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private java.util.Date AV119Wppacienteds_15_tfprofesionalfechanacimiento ;
   private java.util.Date AV120Wppacienteds_16_tfprofesionalfechanacimiento_to ;
   private java.util.Date AV155Wppacienteds_51_tfprofesionalfecharegistro ;
   private java.util.Date AV156Wppacienteds_52_tfprofesionalfecharegistro_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV97IsAuthorized_Update ;
   private boolean AV99IsAuthorized_Delete ;
   private boolean AV100IsAuthorized_PaisDescripcion ;
   private boolean AV101IsAuthorized_UbigeoNombre ;
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
   private boolean A196ProfesionalTerminosCondiciones ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV102TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean A189ProfesionalFoto_IsBlob ;
   private String AV29TFProfesionalTipoDocumento_SelsJson ;
   private String AV46TFProfesionalSexo_SelsJson ;
   private String AV58TFProfesionalTiempoCita_SelsJson ;
   private String AV88TFProfesionalEstadoCuenta_SelsJson ;
   private String AV90TFProfesionalEstado_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV31TFProfesionalNroDocumento ;
   private String AV32TFProfesionalNroDocumento_Sel ;
   private String AV33TFProfesionalApellidoPaterno ;
   private String AV34TFProfesionalApellidoPaterno_Sel ;
   private String AV35TFProfesionalApellidoMaterno ;
   private String AV36TFProfesionalApellidoMaterno_Sel ;
   private String AV37TFProfesionalNombres ;
   private String AV38TFProfesionalNombres_Sel ;
   private String AV39TFProfesionalNombreCompleto2 ;
   private String AV40TFProfesionalNombreCompleto2_Sel ;
   private String AV48TFProfesionalDescripcion ;
   private String AV49TFProfesionalDescripcion_Sel ;
   private String AV50TFProfesionalCorreo ;
   private String AV51TFProfesionalCorreo_Sel ;
   private String AV52TFProfesionalCOP ;
   private String AV53TFProfesionalCOP_Sel ;
   private String AV60TFProfesionalDireccion ;
   private String AV61TFProfesionalDireccion_Sel ;
   private String AV64TFPaisDescripcion ;
   private String AV65TFPaisDescripcion_Sel ;
   private String AV68TFUbigeoNombre ;
   private String AV69TFUbigeoNombre_Sel ;
   private String AV70TFProfesionalTwitter ;
   private String AV71TFProfesionalTwitter_Sel ;
   private String AV72TFProfesionalFacebook ;
   private String AV73TFProfesionalFacebook_Sel ;
   private String AV74TFProfesionalInstagram ;
   private String AV75TFProfesionalInstagram_Sel ;
   private String AV76TFProfesionalLinkedin ;
   private String AV77TFProfesionalLinkedin_Sel ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A178ProfesionalDescripcion ;
   private String A179ProfesionalCorreo ;
   private String A88ProfesionalCOP ;
   private String A183ProfesionalDireccion ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A190ProfesionalTwitter ;
   private String A191ProfesionalFacebook ;
   private String A192ProfesionalInstagram ;
   private String A193ProfesionalLinkedin ;
   private String AV45DDO_ProfesionalFechaNacimientoAuxDateText ;
   private String AV86DDO_ProfesionalFechaRegistroAuxDateText ;
   private String A40000ProfesionalFoto_GXI ;
   private String lV105Wppacienteds_1_filterfulltext ;
   private String lV109Wppacienteds_5_tfprofesionalnrodocumento ;
   private String lV111Wppacienteds_7_tfprofesionalapellidopaterno ;
   private String lV113Wppacienteds_9_tfprofesionalapellidomaterno ;
   private String lV115Wppacienteds_11_tfprofesionalnombres ;
   private String lV117Wppacienteds_13_tfprofesionalnombrecompleto2 ;
   private String lV122Wppacienteds_18_tfprofesionaldescripcion ;
   private String lV124Wppacienteds_20_tfprofesionalcorreo ;
   private String lV126Wppacienteds_22_tfprofesionalcop ;
   private String lV133Wppacienteds_29_tfprofesionaldireccion ;
   private String lV137Wppacienteds_33_tfpaisdescripcion ;
   private String lV141Wppacienteds_37_tfubigeonombre ;
   private String lV143Wppacienteds_39_tfprofesionaltwitter ;
   private String lV145Wppacienteds_41_tfprofesionalfacebook ;
   private String lV147Wppacienteds_43_tfprofesionalinstagram ;
   private String lV149Wppacienteds_45_tfprofesionallinkedin ;
   private String AV105Wppacienteds_1_filterfulltext ;
   private String AV110Wppacienteds_6_tfprofesionalnrodocumento_sel ;
   private String AV109Wppacienteds_5_tfprofesionalnrodocumento ;
   private String AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel ;
   private String AV111Wppacienteds_7_tfprofesionalapellidopaterno ;
   private String AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel ;
   private String AV113Wppacienteds_9_tfprofesionalapellidomaterno ;
   private String AV116Wppacienteds_12_tfprofesionalnombres_sel ;
   private String AV115Wppacienteds_11_tfprofesionalnombres ;
   private String AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel ;
   private String AV117Wppacienteds_13_tfprofesionalnombrecompleto2 ;
   private String AV123Wppacienteds_19_tfprofesionaldescripcion_sel ;
   private String AV122Wppacienteds_18_tfprofesionaldescripcion ;
   private String AV125Wppacienteds_21_tfprofesionalcorreo_sel ;
   private String AV124Wppacienteds_20_tfprofesionalcorreo ;
   private String AV127Wppacienteds_23_tfprofesionalcop_sel ;
   private String AV126Wppacienteds_22_tfprofesionalcop ;
   private String AV134Wppacienteds_30_tfprofesionaldireccion_sel ;
   private String AV133Wppacienteds_29_tfprofesionaldireccion ;
   private String AV138Wppacienteds_34_tfpaisdescripcion_sel ;
   private String AV137Wppacienteds_33_tfpaisdescripcion ;
   private String AV142Wppacienteds_38_tfubigeonombre_sel ;
   private String AV141Wppacienteds_37_tfubigeonombre ;
   private String AV144Wppacienteds_40_tfprofesionaltwitter_sel ;
   private String AV143Wppacienteds_39_tfprofesionaltwitter ;
   private String AV146Wppacienteds_42_tfprofesionalfacebook_sel ;
   private String AV145Wppacienteds_41_tfprofesionalfacebook ;
   private String AV148Wppacienteds_44_tfprofesionalinstagram_sel ;
   private String AV147Wppacienteds_43_tfprofesionalinstagram ;
   private String AV150Wppacienteds_46_tfprofesionallinkedin_sel ;
   private String AV149Wppacienteds_45_tfprofesionallinkedin ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String A189ProfesionalFoto ;
   private GXSimpleCollection<Byte> AV132Wppacienteds_28_tfprofesionaltiempocita_sels ;
   private GXSimpleCollection<Byte> AV59TFProfesionalTiempoCita_Sels ;
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
   private com.genexus.webpanels.GXUserControl ucTfprofesionalfechanacimiento_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfprofesionalfecharegistro_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV108Wppacienteds_4_tfprofesionaltipodocumento_sels ;
   private GXSimpleCollection<String> AV121Wppacienteds_17_tfprofesionalsexo_sels ;
   private GXSimpleCollection<String> AV158Wppacienteds_54_tfprofesionalestadocuenta_sels ;
   private GXSimpleCollection<String> AV159Wppacienteds_55_tfprofesionalestado_sels ;
   private HTMLChoice cmbProfesionalTipoDocumento ;
   private HTMLChoice cmbProfesionalSexo ;
   private HTMLChoice cmbProfesionalTiempoCita ;
   private ICheckbox chkProfesionalTerminosCondiciones ;
   private HTMLChoice cmbProfesionalEstadoCuenta ;
   private HTMLChoice cmbProfesionalEstado ;
   private IDataStoreProvider pr_default ;
   private String[] H002R2_A198ProfesionalEstado ;
   private String[] H002R2_A197ProfesionalEstadoCuenta ;
   private boolean[] H002R2_A196ProfesionalTerminosCondiciones ;
   private java.util.Date[] H002R2_A195ProfesionalFechaRegistro ;
   private short[] H002R2_A6SecUserId ;
   private String[] H002R2_A194ProfesionalTelefono ;
   private String[] H002R2_A193ProfesionalLinkedin ;
   private String[] H002R2_A192ProfesionalInstagram ;
   private String[] H002R2_A191ProfesionalFacebook ;
   private String[] H002R2_A190ProfesionalTwitter ;
   private String[] H002R2_A189ProfesionalFoto ;
   private String[] H002R2_A40000ProfesionalFoto_GXI ;
   private String[] H002R2_A44UbigeoCode ;
   private String[] H002R2_A184PaisDescripcion ;
   private short[] H002R2_A43PaisId ;
   private String[] H002R2_A183ProfesionalDireccion ;
   private byte[] H002R2_A182ProfesionalTiempoCita ;
   private String[] H002R2_A181ProfesionalColorCita ;
   private String[] H002R2_A180ProfesionalColorDisponible ;
   private String[] H002R2_A88ProfesionalCOP ;
   private String[] H002R2_A179ProfesionalCorreo ;
   private String[] H002R2_A178ProfesionalDescripcion ;
   private String[] H002R2_A177ProfesionalSexo ;
   private java.util.Date[] H002R2_A176ProfesionalFechaNacimiento ;
   private String[] H002R2_A174ProfesionalNroDocumento ;
   private String[] H002R2_A173ProfesionalTipoDocumento ;
   private int[] H002R2_A31ProfesionalId ;
   private String[] H002R2_A84ProfesionalNombres ;
   private String[] H002R2_A86ProfesionalApellidoMaterno ;
   private String[] H002R2_A85ProfesionalApellidoPaterno ;
   private String[] H002R2_A188UbigeoDistrito ;
   private String[] H002R2_A187UbigeoProvincia ;
   private String[] H002R2_A186UbigeoDepartamento ;
   private long[] H002R3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV30TFProfesionalTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV47TFProfesionalSexo_Sels ;
   private GXSimpleCollection<String> AV89TFProfesionalEstadoCuenta_Sels ;
   private GXSimpleCollection<String> AV91TFProfesionalEstado_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState56[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV92DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class wppaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002R2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A173ProfesionalTipoDocumento ,
                                          GXSimpleCollection<String> AV108Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                          String A177ProfesionalSexo ,
                                          GXSimpleCollection<String> AV121Wppacienteds_17_tfprofesionalsexo_sels ,
                                          byte A182ProfesionalTiempoCita ,
                                          GXSimpleCollection<Byte> AV132Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                          String A197ProfesionalEstadoCuenta ,
                                          GXSimpleCollection<String> AV158Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                          String A198ProfesionalEstado ,
                                          GXSimpleCollection<String> AV159Wppacienteds_55_tfprofesionalestado_sels ,
                                          String AV105Wppacienteds_1_filterfulltext ,
                                          int AV106Wppacienteds_2_tfprofesionalid ,
                                          int AV107Wppacienteds_3_tfprofesionalid_to ,
                                          int AV108Wppacienteds_4_tfprofesionaltipodocumento_sels_size ,
                                          String AV110Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                          String AV109Wppacienteds_5_tfprofesionalnrodocumento ,
                                          String AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                          String AV111Wppacienteds_7_tfprofesionalapellidopaterno ,
                                          String AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                          String AV113Wppacienteds_9_tfprofesionalapellidomaterno ,
                                          String AV116Wppacienteds_12_tfprofesionalnombres_sel ,
                                          String AV115Wppacienteds_11_tfprofesionalnombres ,
                                          String AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                          String AV117Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                          java.util.Date AV119Wppacienteds_15_tfprofesionalfechanacimiento ,
                                          java.util.Date AV120Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                          int AV121Wppacienteds_17_tfprofesionalsexo_sels_size ,
                                          String AV123Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                          String AV122Wppacienteds_18_tfprofesionaldescripcion ,
                                          String AV125Wppacienteds_21_tfprofesionalcorreo_sel ,
                                          String AV124Wppacienteds_20_tfprofesionalcorreo ,
                                          String AV127Wppacienteds_23_tfprofesionalcop_sel ,
                                          String AV126Wppacienteds_22_tfprofesionalcop ,
                                          String AV129Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                          String AV128Wppacienteds_24_tfprofesionalcolordisponible ,
                                          String AV131Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                          String AV130Wppacienteds_26_tfprofesionalcolorcita ,
                                          int AV132Wppacienteds_28_tfprofesionaltiempocita_sels_size ,
                                          String AV134Wppacienteds_30_tfprofesionaldireccion_sel ,
                                          String AV133Wppacienteds_29_tfprofesionaldireccion ,
                                          short AV135Wppacienteds_31_tfpaisid ,
                                          short AV136Wppacienteds_32_tfpaisid_to ,
                                          String AV138Wppacienteds_34_tfpaisdescripcion_sel ,
                                          String AV137Wppacienteds_33_tfpaisdescripcion ,
                                          String AV140Wppacienteds_36_tfubigeocode_sel ,
                                          String AV139Wppacienteds_35_tfubigeocode ,
                                          String AV142Wppacienteds_38_tfubigeonombre_sel ,
                                          String AV141Wppacienteds_37_tfubigeonombre ,
                                          String AV144Wppacienteds_40_tfprofesionaltwitter_sel ,
                                          String AV143Wppacienteds_39_tfprofesionaltwitter ,
                                          String AV146Wppacienteds_42_tfprofesionalfacebook_sel ,
                                          String AV145Wppacienteds_41_tfprofesionalfacebook ,
                                          String AV148Wppacienteds_44_tfprofesionalinstagram_sel ,
                                          String AV147Wppacienteds_43_tfprofesionalinstagram ,
                                          String AV150Wppacienteds_46_tfprofesionallinkedin_sel ,
                                          String AV149Wppacienteds_45_tfprofesionallinkedin ,
                                          String AV152Wppacienteds_48_tfprofesionaltelefono_sel ,
                                          String AV151Wppacienteds_47_tfprofesionaltelefono ,
                                          short AV153Wppacienteds_49_tfsecuserid ,
                                          short AV154Wppacienteds_50_tfsecuserid_to ,
                                          java.util.Date AV155Wppacienteds_51_tfprofesionalfecharegistro ,
                                          java.util.Date AV156Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                          byte AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel ,
                                          int AV158Wppacienteds_54_tfprofesionalestadocuenta_sels_size ,
                                          int AV159Wppacienteds_55_tfprofesionalestado_sels_size ,
                                          int A31ProfesionalId ,
                                          String A174ProfesionalNroDocumento ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A178ProfesionalDescripcion ,
                                          String A179ProfesionalCorreo ,
                                          String A88ProfesionalCOP ,
                                          String A180ProfesionalColorDisponible ,
                                          String A181ProfesionalColorCita ,
                                          String A183ProfesionalDireccion ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A190ProfesionalTwitter ,
                                          String A191ProfesionalFacebook ,
                                          String A192ProfesionalInstagram ,
                                          String A193ProfesionalLinkedin ,
                                          String A194ProfesionalTelefono ,
                                          short A6SecUserId ,
                                          java.util.Date A176ProfesionalFechaNacimiento ,
                                          java.util.Date A195ProfesionalFechaRegistro ,
                                          boolean A196ProfesionalTerminosCondiciones ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int57 = new byte[88];
      Object[] GXv_Object58 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[ProfesionalEstado], T1.[ProfesionalEstadoCuenta], T1.[ProfesionalTerminosCondiciones], T1.[ProfesionalFechaRegistro], T1.[SecUserId], T1.[ProfesionalTelefono]," ;
      sSelectString += " T1.[ProfesionalLinkedin], T1.[ProfesionalInstagram], T1.[ProfesionalFacebook], T1.[ProfesionalTwitter], T1.[ProfesionalFoto], T1.[ProfesionalFoto_GXI], T1.[UbigeoCode]," ;
      sSelectString += " T3.[PaisDescripcion], T1.[PaisId], T1.[ProfesionalDireccion], T1.[ProfesionalTiempoCita], T1.[ProfesionalColorCita], T1.[ProfesionalColorDisponible], T1.[ProfesionalCOP]," ;
      sSelectString += " T1.[ProfesionalCorreo], T1.[ProfesionalDescripcion], T1.[ProfesionalSexo], T1.[ProfesionalFechaNacimiento], T1.[ProfesionalNroDocumento], T1.[ProfesionalTipoDocumento]," ;
      sSelectString += " T1.[ProfesionalId], T1.[ProfesionalNombres], T1.[ProfesionalApellidoMaterno], T1.[ProfesionalApellidoPaterno], T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento]" ;
      sFromString = " FROM (([Profesional] T1 INNER JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais] T3 ON T3.[PaisId] = T1.[PaisId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV105Wppacienteds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '0') or ( T1.[ProfesionalNroDocumento] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] like '%' + ?) or ( T1.[ProfesionalApellidoMaterno] like '%' + ?) or ( T1.[ProfesionalNombres] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'F') or ( T1.[ProfesionalDescripcion] like '%' + ?) or ( T1.[ProfesionalCorreo] like '%' + ?) or ( T1.[ProfesionalCOP] like '%' + ?) or ( T1.[ProfesionalColorDisponible] like '%' + ?) or ( T1.[ProfesionalColorCita] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 30) or ( '1 hora' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 60) or ( T1.[ProfesionalDireccion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T3.[PaisDescripcion] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( T1.[ProfesionalTwitter] like '%' + ?) or ( T1.[ProfesionalFacebook] like '%' + ?) or ( T1.[ProfesionalInstagram] like '%' + ?) or ( T1.[ProfesionalLinkedin] like '%' + ?) or ( T1.[ProfesionalTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( 'cuenta verificada' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CV') or ( 'cuenta por verificar' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CP') or ( 'activo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'I'))");
      }
      else
      {
         GXv_int57[0] = (byte)(1) ;
         GXv_int57[1] = (byte)(1) ;
         GXv_int57[2] = (byte)(1) ;
         GXv_int57[3] = (byte)(1) ;
         GXv_int57[4] = (byte)(1) ;
         GXv_int57[5] = (byte)(1) ;
         GXv_int57[6] = (byte)(1) ;
         GXv_int57[7] = (byte)(1) ;
         GXv_int57[8] = (byte)(1) ;
         GXv_int57[9] = (byte)(1) ;
         GXv_int57[10] = (byte)(1) ;
         GXv_int57[11] = (byte)(1) ;
         GXv_int57[12] = (byte)(1) ;
         GXv_int57[13] = (byte)(1) ;
         GXv_int57[14] = (byte)(1) ;
         GXv_int57[15] = (byte)(1) ;
         GXv_int57[16] = (byte)(1) ;
         GXv_int57[17] = (byte)(1) ;
         GXv_int57[18] = (byte)(1) ;
         GXv_int57[19] = (byte)(1) ;
         GXv_int57[20] = (byte)(1) ;
         GXv_int57[21] = (byte)(1) ;
         GXv_int57[22] = (byte)(1) ;
         GXv_int57[23] = (byte)(1) ;
         GXv_int57[24] = (byte)(1) ;
         GXv_int57[25] = (byte)(1) ;
         GXv_int57[26] = (byte)(1) ;
         GXv_int57[27] = (byte)(1) ;
         GXv_int57[28] = (byte)(1) ;
         GXv_int57[29] = (byte)(1) ;
         GXv_int57[30] = (byte)(1) ;
         GXv_int57[31] = (byte)(1) ;
         GXv_int57[32] = (byte)(1) ;
         GXv_int57[33] = (byte)(1) ;
         GXv_int57[34] = (byte)(1) ;
         GXv_int57[35] = (byte)(1) ;
         GXv_int57[36] = (byte)(1) ;
      }
      if ( ! (0==AV106Wppacienteds_2_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int57[37] = (byte)(1) ;
      }
      if ( ! (0==AV107Wppacienteds_3_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int57[38] = (byte)(1) ;
      }
      if ( AV108Wppacienteds_4_tfprofesionaltipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV108Wppacienteds_4_tfprofesionaltipodocumento_sels, "T1.[ProfesionalTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV110Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV109Wppacienteds_5_tfprofesionalnrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] like ?)");
      }
      else
      {
         GXv_int57[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] = ?)");
      }
      else
      {
         GXv_int57[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV111Wppacienteds_7_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int57[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int57[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV113Wppacienteds_9_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int57[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int57[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wppacienteds_12_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV115Wppacienteds_11_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int57[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wppacienteds_12_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int57[46] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) && ( ! (GXutil.strcmp("", AV117Wppacienteds_13_tfprofesionalnombrecompleto2)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int57[47] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int57[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV119Wppacienteds_15_tfprofesionalfechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int57[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV120Wppacienteds_16_tfprofesionalfechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int57[50] = (byte)(1) ;
      }
      if ( AV121Wppacienteds_17_tfprofesionalsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV121Wppacienteds_17_tfprofesionalsexo_sels, "T1.[ProfesionalSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV123Wppacienteds_19_tfprofesionaldescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV122Wppacienteds_18_tfprofesionaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] like ?)");
      }
      else
      {
         GXv_int57[51] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Wppacienteds_19_tfprofesionaldescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] = ?)");
      }
      else
      {
         GXv_int57[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Wppacienteds_21_tfprofesionalcorreo_sel)==0) && ( ! (GXutil.strcmp("", AV124Wppacienteds_20_tfprofesionalcorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] like ?)");
      }
      else
      {
         GXv_int57[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Wppacienteds_21_tfprofesionalcorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] = ?)");
      }
      else
      {
         GXv_int57[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Wppacienteds_23_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV126Wppacienteds_22_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int57[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Wppacienteds_23_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int57[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) && ( ! (GXutil.strcmp("", AV128Wppacienteds_24_tfprofesionalcolordisponible)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] like ?)");
      }
      else
      {
         GXv_int57[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] = ?)");
      }
      else
      {
         GXv_int57[58] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV131Wppacienteds_27_tfprofesionalcolorcita_sel)==0) && ( ! (GXutil.strcmp("", AV130Wppacienteds_26_tfprofesionalcolorcita)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] like ?)");
      }
      else
      {
         GXv_int57[59] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Wppacienteds_27_tfprofesionalcolorcita_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] = ?)");
      }
      else
      {
         GXv_int57[60] = (byte)(1) ;
      }
      if ( AV132Wppacienteds_28_tfprofesionaltiempocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wppacienteds_28_tfprofesionaltiempocita_sels, "T1.[ProfesionalTiempoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV134Wppacienteds_30_tfprofesionaldireccion_sel)==0) && ( ! (GXutil.strcmp("", AV133Wppacienteds_29_tfprofesionaldireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] like ?)");
      }
      else
      {
         GXv_int57[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV134Wppacienteds_30_tfprofesionaldireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] = ?)");
      }
      else
      {
         GXv_int57[62] = (byte)(1) ;
      }
      if ( ! (0==AV135Wppacienteds_31_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int57[63] = (byte)(1) ;
      }
      if ( ! (0==AV136Wppacienteds_32_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int57[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV138Wppacienteds_34_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV137Wppacienteds_33_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int57[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Wppacienteds_34_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int57[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV140Wppacienteds_36_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV139Wppacienteds_35_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int57[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV140Wppacienteds_36_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int57[68] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV142Wppacienteds_38_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV141Wppacienteds_37_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int57[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV142Wppacienteds_38_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int57[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV144Wppacienteds_40_tfprofesionaltwitter_sel)==0) && ( ! (GXutil.strcmp("", AV143Wppacienteds_39_tfprofesionaltwitter)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] like ?)");
      }
      else
      {
         GXv_int57[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Wppacienteds_40_tfprofesionaltwitter_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] = ?)");
      }
      else
      {
         GXv_int57[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV146Wppacienteds_42_tfprofesionalfacebook_sel)==0) && ( ! (GXutil.strcmp("", AV145Wppacienteds_41_tfprofesionalfacebook)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] like ?)");
      }
      else
      {
         GXv_int57[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV146Wppacienteds_42_tfprofesionalfacebook_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] = ?)");
      }
      else
      {
         GXv_int57[74] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Wppacienteds_44_tfprofesionalinstagram_sel)==0) && ( ! (GXutil.strcmp("", AV147Wppacienteds_43_tfprofesionalinstagram)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] like ?)");
      }
      else
      {
         GXv_int57[75] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Wppacienteds_44_tfprofesionalinstagram_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] = ?)");
      }
      else
      {
         GXv_int57[76] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV150Wppacienteds_46_tfprofesionallinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV149Wppacienteds_45_tfprofesionallinkedin)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] like ?)");
      }
      else
      {
         GXv_int57[77] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV150Wppacienteds_46_tfprofesionallinkedin_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] = ?)");
      }
      else
      {
         GXv_int57[78] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Wppacienteds_48_tfprofesionaltelefono_sel)==0) && ( ! (GXutil.strcmp("", AV151Wppacienteds_47_tfprofesionaltelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] like ?)");
      }
      else
      {
         GXv_int57[79] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Wppacienteds_48_tfprofesionaltelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] = ?)");
      }
      else
      {
         GXv_int57[80] = (byte)(1) ;
      }
      if ( ! (0==AV153Wppacienteds_49_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int57[81] = (byte)(1) ;
      }
      if ( ! (0==AV154Wppacienteds_50_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int57[82] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV155Wppacienteds_51_tfprofesionalfecharegistro)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int57[83] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV156Wppacienteds_52_tfprofesionalfecharegistro_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int57[84] = (byte)(1) ;
      }
      if ( AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 1 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 1)");
      }
      if ( AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 2 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 0)");
      }
      if ( AV158Wppacienteds_54_tfprofesionalestadocuenta_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV158Wppacienteds_54_tfprofesionalestadocuenta_sels, "T1.[ProfesionalEstadoCuenta] IN (", ")")+")");
      }
      if ( AV159Wppacienteds_55_tfprofesionalestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV159Wppacienteds_55_tfprofesionalestado_sels, "T1.[ProfesionalEstado] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTipoDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTipoDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalNroDocumento]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalNroDocumento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalNombres]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalFechaNacimiento]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalFechaNacimiento] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalSexo]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalSexo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalDescripcion]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalDescripcion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalCorreo]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalCorreo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalCOP]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalColorDisponible]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalColorDisponible] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalColorCita]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalColorCita] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTiempoCita]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTiempoCita] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalDireccion]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalDireccion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[PaisDescripcion]" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTwitter]" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTwitter] DESC" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalFacebook]" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalFacebook] DESC" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalInstagram]" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalInstagram] DESC" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalLinkedin]" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalLinkedin] DESC" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTelefono]" ;
      }
      else if ( ( AV13OrderedBy == 23 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTelefono] DESC" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV13OrderedBy == 24 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalFechaRegistro]" ;
      }
      else if ( ( AV13OrderedBy == 25 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalFechaRegistro] DESC" ;
      }
      else if ( ( AV13OrderedBy == 26 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTerminosCondiciones]" ;
      }
      else if ( ( AV13OrderedBy == 26 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalTerminosCondiciones] DESC" ;
      }
      else if ( ( AV13OrderedBy == 27 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalEstadoCuenta]" ;
      }
      else if ( ( AV13OrderedBy == 27 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalEstadoCuenta] DESC" ;
      }
      else if ( ( AV13OrderedBy == 28 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ProfesionalEstado]" ;
      }
      else if ( ( AV13OrderedBy == 28 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ProfesionalEstado] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[ProfesionalId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object58[0] = scmdbuf ;
      GXv_Object58[1] = GXv_int57 ;
      return GXv_Object58 ;
   }

   protected Object[] conditional_H002R3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A173ProfesionalTipoDocumento ,
                                          GXSimpleCollection<String> AV108Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                          String A177ProfesionalSexo ,
                                          GXSimpleCollection<String> AV121Wppacienteds_17_tfprofesionalsexo_sels ,
                                          byte A182ProfesionalTiempoCita ,
                                          GXSimpleCollection<Byte> AV132Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                          String A197ProfesionalEstadoCuenta ,
                                          GXSimpleCollection<String> AV158Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                          String A198ProfesionalEstado ,
                                          GXSimpleCollection<String> AV159Wppacienteds_55_tfprofesionalestado_sels ,
                                          String AV105Wppacienteds_1_filterfulltext ,
                                          int AV106Wppacienteds_2_tfprofesionalid ,
                                          int AV107Wppacienteds_3_tfprofesionalid_to ,
                                          int AV108Wppacienteds_4_tfprofesionaltipodocumento_sels_size ,
                                          String AV110Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                          String AV109Wppacienteds_5_tfprofesionalnrodocumento ,
                                          String AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                          String AV111Wppacienteds_7_tfprofesionalapellidopaterno ,
                                          String AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                          String AV113Wppacienteds_9_tfprofesionalapellidomaterno ,
                                          String AV116Wppacienteds_12_tfprofesionalnombres_sel ,
                                          String AV115Wppacienteds_11_tfprofesionalnombres ,
                                          String AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                          String AV117Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                          java.util.Date AV119Wppacienteds_15_tfprofesionalfechanacimiento ,
                                          java.util.Date AV120Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                          int AV121Wppacienteds_17_tfprofesionalsexo_sels_size ,
                                          String AV123Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                          String AV122Wppacienteds_18_tfprofesionaldescripcion ,
                                          String AV125Wppacienteds_21_tfprofesionalcorreo_sel ,
                                          String AV124Wppacienteds_20_tfprofesionalcorreo ,
                                          String AV127Wppacienteds_23_tfprofesionalcop_sel ,
                                          String AV126Wppacienteds_22_tfprofesionalcop ,
                                          String AV129Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                          String AV128Wppacienteds_24_tfprofesionalcolordisponible ,
                                          String AV131Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                          String AV130Wppacienteds_26_tfprofesionalcolorcita ,
                                          int AV132Wppacienteds_28_tfprofesionaltiempocita_sels_size ,
                                          String AV134Wppacienteds_30_tfprofesionaldireccion_sel ,
                                          String AV133Wppacienteds_29_tfprofesionaldireccion ,
                                          short AV135Wppacienteds_31_tfpaisid ,
                                          short AV136Wppacienteds_32_tfpaisid_to ,
                                          String AV138Wppacienteds_34_tfpaisdescripcion_sel ,
                                          String AV137Wppacienteds_33_tfpaisdescripcion ,
                                          String AV140Wppacienteds_36_tfubigeocode_sel ,
                                          String AV139Wppacienteds_35_tfubigeocode ,
                                          String AV142Wppacienteds_38_tfubigeonombre_sel ,
                                          String AV141Wppacienteds_37_tfubigeonombre ,
                                          String AV144Wppacienteds_40_tfprofesionaltwitter_sel ,
                                          String AV143Wppacienteds_39_tfprofesionaltwitter ,
                                          String AV146Wppacienteds_42_tfprofesionalfacebook_sel ,
                                          String AV145Wppacienteds_41_tfprofesionalfacebook ,
                                          String AV148Wppacienteds_44_tfprofesionalinstagram_sel ,
                                          String AV147Wppacienteds_43_tfprofesionalinstagram ,
                                          String AV150Wppacienteds_46_tfprofesionallinkedin_sel ,
                                          String AV149Wppacienteds_45_tfprofesionallinkedin ,
                                          String AV152Wppacienteds_48_tfprofesionaltelefono_sel ,
                                          String AV151Wppacienteds_47_tfprofesionaltelefono ,
                                          short AV153Wppacienteds_49_tfsecuserid ,
                                          short AV154Wppacienteds_50_tfsecuserid_to ,
                                          java.util.Date AV155Wppacienteds_51_tfprofesionalfecharegistro ,
                                          java.util.Date AV156Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                          byte AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel ,
                                          int AV158Wppacienteds_54_tfprofesionalestadocuenta_sels_size ,
                                          int AV159Wppacienteds_55_tfprofesionalestado_sels_size ,
                                          int A31ProfesionalId ,
                                          String A174ProfesionalNroDocumento ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A178ProfesionalDescripcion ,
                                          String A179ProfesionalCorreo ,
                                          String A88ProfesionalCOP ,
                                          String A180ProfesionalColorDisponible ,
                                          String A181ProfesionalColorCita ,
                                          String A183ProfesionalDireccion ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A190ProfesionalTwitter ,
                                          String A191ProfesionalFacebook ,
                                          String A192ProfesionalInstagram ,
                                          String A193ProfesionalLinkedin ,
                                          String A194ProfesionalTelefono ,
                                          short A6SecUserId ,
                                          java.util.Date A176ProfesionalFechaNacimiento ,
                                          java.util.Date A195ProfesionalFechaRegistro ,
                                          boolean A196ProfesionalTerminosCondiciones ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int60 = new byte[85];
      Object[] GXv_Object61 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Profesional] T1 INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId])" ;
      if ( ! (GXutil.strcmp("", AV105Wppacienteds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '0') or ( T1.[ProfesionalNroDocumento] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] like '%' + ?) or ( T1.[ProfesionalApellidoMaterno] like '%' + ?) or ( T1.[ProfesionalNombres] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'F') or ( T1.[ProfesionalDescripcion] like '%' + ?) or ( T1.[ProfesionalCorreo] like '%' + ?) or ( T1.[ProfesionalCOP] like '%' + ?) or ( T1.[ProfesionalColorDisponible] like '%' + ?) or ( T1.[ProfesionalColorCita] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 30) or ( '1 hora' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 60) or ( T1.[ProfesionalDireccion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[ProfesionalTwitter] like '%' + ?) or ( T1.[ProfesionalFacebook] like '%' + ?) or ( T1.[ProfesionalInstagram] like '%' + ?) or ( T1.[ProfesionalLinkedin] like '%' + ?) or ( T1.[ProfesionalTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( 'cuenta verificada' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CV') or ( 'cuenta por verificar' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CP') or ( 'activo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'I'))");
      }
      else
      {
         GXv_int60[0] = (byte)(1) ;
         GXv_int60[1] = (byte)(1) ;
         GXv_int60[2] = (byte)(1) ;
         GXv_int60[3] = (byte)(1) ;
         GXv_int60[4] = (byte)(1) ;
         GXv_int60[5] = (byte)(1) ;
         GXv_int60[6] = (byte)(1) ;
         GXv_int60[7] = (byte)(1) ;
         GXv_int60[8] = (byte)(1) ;
         GXv_int60[9] = (byte)(1) ;
         GXv_int60[10] = (byte)(1) ;
         GXv_int60[11] = (byte)(1) ;
         GXv_int60[12] = (byte)(1) ;
         GXv_int60[13] = (byte)(1) ;
         GXv_int60[14] = (byte)(1) ;
         GXv_int60[15] = (byte)(1) ;
         GXv_int60[16] = (byte)(1) ;
         GXv_int60[17] = (byte)(1) ;
         GXv_int60[18] = (byte)(1) ;
         GXv_int60[19] = (byte)(1) ;
         GXv_int60[20] = (byte)(1) ;
         GXv_int60[21] = (byte)(1) ;
         GXv_int60[22] = (byte)(1) ;
         GXv_int60[23] = (byte)(1) ;
         GXv_int60[24] = (byte)(1) ;
         GXv_int60[25] = (byte)(1) ;
         GXv_int60[26] = (byte)(1) ;
         GXv_int60[27] = (byte)(1) ;
         GXv_int60[28] = (byte)(1) ;
         GXv_int60[29] = (byte)(1) ;
         GXv_int60[30] = (byte)(1) ;
         GXv_int60[31] = (byte)(1) ;
         GXv_int60[32] = (byte)(1) ;
         GXv_int60[33] = (byte)(1) ;
         GXv_int60[34] = (byte)(1) ;
         GXv_int60[35] = (byte)(1) ;
         GXv_int60[36] = (byte)(1) ;
      }
      if ( ! (0==AV106Wppacienteds_2_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int60[37] = (byte)(1) ;
      }
      if ( ! (0==AV107Wppacienteds_3_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int60[38] = (byte)(1) ;
      }
      if ( AV108Wppacienteds_4_tfprofesionaltipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV108Wppacienteds_4_tfprofesionaltipodocumento_sels, "T1.[ProfesionalTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV110Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV109Wppacienteds_5_tfprofesionalnrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] like ?)");
      }
      else
      {
         GXv_int60[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] = ?)");
      }
      else
      {
         GXv_int60[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV111Wppacienteds_7_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int60[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int60[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV113Wppacienteds_9_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int60[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int60[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wppacienteds_12_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV115Wppacienteds_11_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int60[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wppacienteds_12_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int60[46] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) && ( ! (GXutil.strcmp("", AV117Wppacienteds_13_tfprofesionalnombrecompleto2)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int60[47] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int60[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV119Wppacienteds_15_tfprofesionalfechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int60[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV120Wppacienteds_16_tfprofesionalfechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int60[50] = (byte)(1) ;
      }
      if ( AV121Wppacienteds_17_tfprofesionalsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV121Wppacienteds_17_tfprofesionalsexo_sels, "T1.[ProfesionalSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV123Wppacienteds_19_tfprofesionaldescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV122Wppacienteds_18_tfprofesionaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] like ?)");
      }
      else
      {
         GXv_int60[51] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Wppacienteds_19_tfprofesionaldescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] = ?)");
      }
      else
      {
         GXv_int60[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Wppacienteds_21_tfprofesionalcorreo_sel)==0) && ( ! (GXutil.strcmp("", AV124Wppacienteds_20_tfprofesionalcorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] like ?)");
      }
      else
      {
         GXv_int60[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Wppacienteds_21_tfprofesionalcorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] = ?)");
      }
      else
      {
         GXv_int60[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Wppacienteds_23_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV126Wppacienteds_22_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int60[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Wppacienteds_23_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int60[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) && ( ! (GXutil.strcmp("", AV128Wppacienteds_24_tfprofesionalcolordisponible)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] like ?)");
      }
      else
      {
         GXv_int60[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] = ?)");
      }
      else
      {
         GXv_int60[58] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV131Wppacienteds_27_tfprofesionalcolorcita_sel)==0) && ( ! (GXutil.strcmp("", AV130Wppacienteds_26_tfprofesionalcolorcita)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] like ?)");
      }
      else
      {
         GXv_int60[59] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Wppacienteds_27_tfprofesionalcolorcita_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] = ?)");
      }
      else
      {
         GXv_int60[60] = (byte)(1) ;
      }
      if ( AV132Wppacienteds_28_tfprofesionaltiempocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wppacienteds_28_tfprofesionaltiempocita_sels, "T1.[ProfesionalTiempoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV134Wppacienteds_30_tfprofesionaldireccion_sel)==0) && ( ! (GXutil.strcmp("", AV133Wppacienteds_29_tfprofesionaldireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] like ?)");
      }
      else
      {
         GXv_int60[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV134Wppacienteds_30_tfprofesionaldireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] = ?)");
      }
      else
      {
         GXv_int60[62] = (byte)(1) ;
      }
      if ( ! (0==AV135Wppacienteds_31_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int60[63] = (byte)(1) ;
      }
      if ( ! (0==AV136Wppacienteds_32_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int60[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV138Wppacienteds_34_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV137Wppacienteds_33_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int60[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Wppacienteds_34_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int60[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV140Wppacienteds_36_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV139Wppacienteds_35_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int60[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV140Wppacienteds_36_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int60[68] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV142Wppacienteds_38_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV141Wppacienteds_37_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int60[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV142Wppacienteds_38_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int60[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV144Wppacienteds_40_tfprofesionaltwitter_sel)==0) && ( ! (GXutil.strcmp("", AV143Wppacienteds_39_tfprofesionaltwitter)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] like ?)");
      }
      else
      {
         GXv_int60[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Wppacienteds_40_tfprofesionaltwitter_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] = ?)");
      }
      else
      {
         GXv_int60[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV146Wppacienteds_42_tfprofesionalfacebook_sel)==0) && ( ! (GXutil.strcmp("", AV145Wppacienteds_41_tfprofesionalfacebook)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] like ?)");
      }
      else
      {
         GXv_int60[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV146Wppacienteds_42_tfprofesionalfacebook_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] = ?)");
      }
      else
      {
         GXv_int60[74] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Wppacienteds_44_tfprofesionalinstagram_sel)==0) && ( ! (GXutil.strcmp("", AV147Wppacienteds_43_tfprofesionalinstagram)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] like ?)");
      }
      else
      {
         GXv_int60[75] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Wppacienteds_44_tfprofesionalinstagram_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] = ?)");
      }
      else
      {
         GXv_int60[76] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV150Wppacienteds_46_tfprofesionallinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV149Wppacienteds_45_tfprofesionallinkedin)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] like ?)");
      }
      else
      {
         GXv_int60[77] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV150Wppacienteds_46_tfprofesionallinkedin_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] = ?)");
      }
      else
      {
         GXv_int60[78] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Wppacienteds_48_tfprofesionaltelefono_sel)==0) && ( ! (GXutil.strcmp("", AV151Wppacienteds_47_tfprofesionaltelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] like ?)");
      }
      else
      {
         GXv_int60[79] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Wppacienteds_48_tfprofesionaltelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] = ?)");
      }
      else
      {
         GXv_int60[80] = (byte)(1) ;
      }
      if ( ! (0==AV153Wppacienteds_49_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int60[81] = (byte)(1) ;
      }
      if ( ! (0==AV154Wppacienteds_50_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int60[82] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV155Wppacienteds_51_tfprofesionalfecharegistro)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int60[83] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV156Wppacienteds_52_tfprofesionalfecharegistro_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int60[84] = (byte)(1) ;
      }
      if ( AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 1 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 1)");
      }
      if ( AV157Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 2 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 0)");
      }
      if ( AV158Wppacienteds_54_tfprofesionalestadocuenta_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV158Wppacienteds_54_tfprofesionalestadocuenta_sels, "T1.[ProfesionalEstadoCuenta] IN (", ")")+")");
      }
      if ( AV159Wppacienteds_55_tfprofesionalestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV159Wppacienteds_55_tfprofesionalestado_sels, "T1.[ProfesionalEstado] IN (", ")")+")");
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
      else if ( ( AV13OrderedBy == 26 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 26 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 27 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 27 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 28 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 28 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object61[0] = scmdbuf ;
      GXv_Object61[1] = GXv_int60 ;
      return GXv_Object61 ;
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
                  return conditional_H002R2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , ((Number) dynConstraints[37]).intValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).shortValue() , ((Number) dynConstraints[59]).shortValue() , (java.util.Date)dynConstraints[60] , (java.util.Date)dynConstraints[61] , ((Number) dynConstraints[62]).byteValue() , ((Number) dynConstraints[63]).intValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (String)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , (String)dynConstraints[77] , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , (String)dynConstraints[81] , (String)dynConstraints[82] , (String)dynConstraints[83] , (String)dynConstraints[84] , (String)dynConstraints[85] , (String)dynConstraints[86] , ((Number) dynConstraints[87]).shortValue() , (java.util.Date)dynConstraints[88] , (java.util.Date)dynConstraints[89] , ((Boolean) dynConstraints[90]).booleanValue() , ((Number) dynConstraints[91]).shortValue() , ((Boolean) dynConstraints[92]).booleanValue() );
            case 1 :
                  return conditional_H002R3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , ((Number) dynConstraints[37]).intValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).shortValue() , ((Number) dynConstraints[59]).shortValue() , (java.util.Date)dynConstraints[60] , (java.util.Date)dynConstraints[61] , ((Number) dynConstraints[62]).byteValue() , ((Number) dynConstraints[63]).intValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (String)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , (String)dynConstraints[77] , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , (String)dynConstraints[81] , (String)dynConstraints[82] , (String)dynConstraints[83] , (String)dynConstraints[84] , (String)dynConstraints[85] , (String)dynConstraints[86] , ((Number) dynConstraints[87]).shortValue() , (java.util.Date)dynConstraints[88] , (java.util.Date)dynConstraints[89] , ((Boolean) dynConstraints[90]).booleanValue() , ((Number) dynConstraints[91]).shortValue() , ((Boolean) dynConstraints[92]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002R2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002R3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getMultimediaFile(11, rslt.getVarchar(12));
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 1);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
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
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[125]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[126]).intValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 15);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 15);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 50);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[130], 50);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[131], 50);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 50);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 50);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 50);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 100);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[137]);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[138]);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 5000);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 5000);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[145], 20);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[146], 20);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[147], 20);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[148], 20);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[151]).shortValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[152]).shortValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[153], 80);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[154], 80);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[155], 10);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[156], 10);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[157], 100);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[158], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[159], 1000);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[160], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[161], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[162], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[163], 1000);
               }
               if ( ((Number) parms[76]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[164], 1000);
               }
               if ( ((Number) parms[77]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[165], 1000);
               }
               if ( ((Number) parms[78]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[166], 1000);
               }
               if ( ((Number) parms[79]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[167], 20);
               }
               if ( ((Number) parms[80]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[168], 20);
               }
               if ( ((Number) parms[81]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[169]).shortValue());
               }
               if ( ((Number) parms[82]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[170]).shortValue());
               }
               if ( ((Number) parms[83]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[171]);
               }
               if ( ((Number) parms[84]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[172]);
               }
               if ( ((Number) parms[85]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[173]).intValue());
               }
               if ( ((Number) parms[86]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[174]).intValue());
               }
               if ( ((Number) parms[87]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[175]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[122]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[123]).intValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 15);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 15);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 50);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 50);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 50);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 50);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[130], 50);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[131], 50);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 100);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[134]);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[135]);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 5000);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 5000);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 100);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[142], 20);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[143], 20);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[144], 20);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[145], 20);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[148]).shortValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[149]).shortValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 80);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 80);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[152], 10);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[153], 10);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[154], 100);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[155], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[156], 1000);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[157], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[158], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[159], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[160], 1000);
               }
               if ( ((Number) parms[76]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[161], 1000);
               }
               if ( ((Number) parms[77]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[162], 1000);
               }
               if ( ((Number) parms[78]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[163], 1000);
               }
               if ( ((Number) parms[79]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[164], 20);
               }
               if ( ((Number) parms[80]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[165], 20);
               }
               if ( ((Number) parms[81]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[166]).shortValue());
               }
               if ( ((Number) parms[82]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[167]).shortValue());
               }
               if ( ((Number) parms[83]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[168]);
               }
               if ( ((Number) parms[84]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[169]);
               }
               return;
      }
   }

}

