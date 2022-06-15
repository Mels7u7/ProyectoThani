package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clinicaww_impl extends GXDataArea
{
   public clinicaww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clinicaww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clinicaww_impl.class ));
   }

   public clinicaww_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbClinicaMoneda = new HTMLChoice();
      cmbClinicaTiempoDeCita = new HTMLChoice();
      cmbClinicaEstado = new HTMLChoice();
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
            AV27TFClinicaId = (short)(GXutil.lval( httpContext.GetPar( "TFClinicaId"))) ;
            AV28TFClinicaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFClinicaId_To"))) ;
            AV29TFClinicaRUC = GXutil.lval( httpContext.GetPar( "TFClinicaRUC")) ;
            AV30TFClinicaRUC_To = GXutil.lval( httpContext.GetPar( "TFClinicaRUC_To")) ;
            AV31TFClinicaNombreComercial = httpContext.GetPar( "TFClinicaNombreComercial") ;
            AV32TFClinicaNombreComercial_Sel = httpContext.GetPar( "TFClinicaNombreComercial_Sel") ;
            AV33TFClinicaNombreAbreviado = httpContext.GetPar( "TFClinicaNombreAbreviado") ;
            AV34TFClinicaNombreAbreviado_Sel = httpContext.GetPar( "TFClinicaNombreAbreviado_Sel") ;
            AV35TFClinicaDireccionComercial = httpContext.GetPar( "TFClinicaDireccionComercial") ;
            AV36TFClinicaDireccionComercial_Sel = httpContext.GetPar( "TFClinicaDireccionComercial_Sel") ;
            AV37TFClinicaCorreo = httpContext.GetPar( "TFClinicaCorreo") ;
            AV38TFClinicaCorreo_Sel = httpContext.GetPar( "TFClinicaCorreo_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV40TFClinicaMoneda_Sels);
            AV41TFClinicaTelefono = httpContext.GetPar( "TFClinicaTelefono") ;
            AV42TFClinicaTelefono_Sel = httpContext.GetPar( "TFClinicaTelefono_Sel") ;
            AV43TFClinicaWhatsApp = httpContext.GetPar( "TFClinicaWhatsApp") ;
            AV44TFClinicaWhatsApp_Sel = httpContext.GetPar( "TFClinicaWhatsApp_Sel") ;
            AV45TFClinicaFacebook = httpContext.GetPar( "TFClinicaFacebook") ;
            AV46TFClinicaFacebook_Sel = httpContext.GetPar( "TFClinicaFacebook_Sel") ;
            AV47TFClinicaTwiter = httpContext.GetPar( "TFClinicaTwiter") ;
            AV48TFClinicaTwiter_Sel = httpContext.GetPar( "TFClinicaTwiter_Sel") ;
            AV49TFClinicaInstagram = httpContext.GetPar( "TFClinicaInstagram") ;
            AV50TFClinicaInstagram_Sel = httpContext.GetPar( "TFClinicaInstagram_Sel") ;
            AV51TFClinicaLinkedin = httpContext.GetPar( "TFClinicaLinkedin") ;
            AV52TFClinicaLinkedin_Sel = httpContext.GetPar( "TFClinicaLinkedin_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV54TFClinicaTiempoDeCita_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV56TFClinicaEstado_Sels);
            AV96Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV62IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV64IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFClinicaId, AV28TFClinicaId_To, AV29TFClinicaRUC, AV30TFClinicaRUC_To, AV31TFClinicaNombreComercial, AV32TFClinicaNombreComercial_Sel, AV33TFClinicaNombreAbreviado, AV34TFClinicaNombreAbreviado_Sel, AV35TFClinicaDireccionComercial, AV36TFClinicaDireccionComercial_Sel, AV37TFClinicaCorreo, AV38TFClinicaCorreo_Sel, AV40TFClinicaMoneda_Sels, AV41TFClinicaTelefono, AV42TFClinicaTelefono_Sel, AV43TFClinicaWhatsApp, AV44TFClinicaWhatsApp_Sel, AV45TFClinicaFacebook, AV46TFClinicaFacebook_Sel, AV47TFClinicaTwiter, AV48TFClinicaTwiter_Sel, AV49TFClinicaInstagram, AV50TFClinicaInstagram_Sel, AV51TFClinicaLinkedin, AV52TFClinicaLinkedin_Sel, AV54TFClinicaTiempoDeCita_Sels, AV56TFClinicaEstado_Sels, AV96Pgmname, AV13OrderedBy, AV14OrderedDsc, AV62IsAuthorized_Update, AV64IsAuthorized_Delete) ;
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
      pa1J2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1J2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331738", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.clinicaww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV96Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV62IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV64IsAuthorized_Delete));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV59GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV60GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV57DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV57DDO_TitleSettingsIcons);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAID", GXutil.ltrim( localUtil.ntoc( AV27TFClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFClinicaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICARUC", GXutil.ltrim( localUtil.ntoc( AV29TFClinicaRUC, (byte)(11), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICARUC_TO", GXutil.ltrim( localUtil.ntoc( AV30TFClinicaRUC_To, (byte)(11), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICANOMBRECOMERCIAL", AV31TFClinicaNombreComercial);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICANOMBRECOMERCIAL_SEL", AV32TFClinicaNombreComercial_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICANOMBREABREVIADO", AV33TFClinicaNombreAbreviado);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICANOMBREABREVIADO_SEL", AV34TFClinicaNombreAbreviado_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICADIRECCIONCOMERCIAL", AV35TFClinicaDireccionComercial);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICADIRECCIONCOMERCIAL_SEL", AV36TFClinicaDireccionComercial_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICACORREO", AV37TFClinicaCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICACORREO_SEL", AV38TFClinicaCorreo_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCLINICAMONEDA_SELS", AV40TFClinicaMoneda_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCLINICAMONEDA_SELS", AV40TFClinicaMoneda_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICATELEFONO", GXutil.rtrim( AV41TFClinicaTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICATELEFONO_SEL", GXutil.rtrim( AV42TFClinicaTelefono_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAWHATSAPP", GXutil.rtrim( AV43TFClinicaWhatsApp));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAWHATSAPP_SEL", GXutil.rtrim( AV44TFClinicaWhatsApp_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAFACEBOOK", AV45TFClinicaFacebook);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAFACEBOOK_SEL", AV46TFClinicaFacebook_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICATWITER", AV47TFClinicaTwiter);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICATWITER_SEL", AV48TFClinicaTwiter_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAINSTAGRAM", AV49TFClinicaInstagram);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAINSTAGRAM_SEL", AV50TFClinicaInstagram_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICALINKEDIN", AV51TFClinicaLinkedin);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICALINKEDIN_SEL", AV52TFClinicaLinkedin_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCLINICATIEMPODECITA_SELS", AV54TFClinicaTiempoDeCita_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCLINICATIEMPODECITA_SELS", AV54TFClinicaTiempoDeCita_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCLINICAESTADO_SELS", AV56TFClinicaEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCLINICAESTADO_SELS", AV56TFClinicaEstado_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV96Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV96Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV62IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV62IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV64IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV64IsAuthorized_Delete));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAMONEDA_SELSJSON", AV39TFClinicaMoneda_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICATIEMPODECITA_SELSJSON", AV53TFClinicaTiempoDeCita_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAESTADO_SELSJSON", AV55TFClinicaEstado_SelsJson);
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
         we1J2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1J2( ) ;
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
      return formatLink("com.projectthani.clinicaww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "ClinicaWW" ;
   }

   public String getPgmdesc( )
   {
      return " Clinica" ;
   }

   public void wb1J0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClinicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClinicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClinicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClinicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_1J2( true) ;
      }
      else
      {
         wb_table1_25_1J2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_1J2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaRUC_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "RUC") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaNombreComercial_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Comercial") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaNombreAbreviado_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Abrev.") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaDireccionComercial_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Direccion Comercial") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaCorreo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbClinicaMoneda.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Moneda") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaLogo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Logo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaLogoHeader_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Logo Header") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaLogoFactura_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Logo Factura") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaLogoBoleta_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Logo Boleta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaLogoPago_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Logo Pago") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaTelefono_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Telefono") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaWhatsApp_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Whats App") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaFacebook_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Facebook") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaTwiter_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Twiter") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaInstagram_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Instagram") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaLinkedin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Linkedin") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbClinicaTiempoDeCita.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tiempo De Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbClinicaEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV61Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV63Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtClinicaRUC_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaRUC_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A116ClinicaNombreComercial);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaNombreComercial_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A80ClinicaNombreAbreviado);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaNombreAbreviado_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A119ClinicaDireccionComercial);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaDireccionComercial_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A340ClinicaCorreo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaCorreo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A341ClinicaMoneda, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbClinicaMoneda.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A117ClinicaLogo));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaLogo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A342ClinicaLogoHeader));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaLogoHeader_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A343ClinicaLogoFactura));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaLogoFactura_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A344ClinicaLogoBoleta));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaLogoBoleta_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A345ClinicaLogoPago));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaLogoPago_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A346ClinicaTelefono));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaTelefono_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A347ClinicaWhatsApp));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaWhatsApp_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A348ClinicaFacebook);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtClinicaFacebook_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtClinicaFacebook_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaFacebook_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A349ClinicaTwiter);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtClinicaTwiter_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtClinicaTwiter_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaTwiter_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A350ClinicaInstagram);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtClinicaInstagram_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtClinicaInstagram_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaInstagram_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A351ClinicaLinkedin);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtClinicaLinkedin_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtClinicaLinkedin_Linktarget));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtClinicaLinkedin_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A120ClinicaTiempoDeCita, (byte)(2), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbClinicaTiempoDeCita.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A121ClinicaEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbClinicaEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV59GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV60GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV57DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV57DDO_TitleSettingsIcons);
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

   public void start1J2( )
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
         Form.getMeta().addItem("description", " Clinica", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1J0( ) ;
   }

   public void ws1J2( )
   {
      start1J2( ) ;
      evt1J2( ) ;
   }

   public void evt1J2( )
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
                           e111J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e161J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e171J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e181J2 ();
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
                           AV61Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV61Update);
                           AV63Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV63Delete);
                           A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".")) ;
                           A118ClinicaRUC = localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") ;
                           A116ClinicaNombreComercial = httpContext.cgiGet( edtClinicaNombreComercial_Internalname) ;
                           A80ClinicaNombreAbreviado = httpContext.cgiGet( edtClinicaNombreAbreviado_Internalname) ;
                           A119ClinicaDireccionComercial = httpContext.cgiGet( edtClinicaDireccionComercial_Internalname) ;
                           A340ClinicaCorreo = httpContext.cgiGet( edtClinicaCorreo_Internalname) ;
                           cmbClinicaMoneda.setName( cmbClinicaMoneda.getInternalname() );
                           cmbClinicaMoneda.setValue( httpContext.cgiGet( cmbClinicaMoneda.getInternalname()) );
                           A341ClinicaMoneda = (short)(GXutil.lval( httpContext.cgiGet( cmbClinicaMoneda.getInternalname()))) ;
                           A117ClinicaLogo = httpContext.cgiGet( edtClinicaLogo_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
                           A342ClinicaLogoHeader = httpContext.cgiGet( edtClinicaLogoHeader_Internalname) ;
                           n342ClinicaLogoHeader = false ;
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
                           A343ClinicaLogoFactura = httpContext.cgiGet( edtClinicaLogoFactura_Internalname) ;
                           n343ClinicaLogoFactura = false ;
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
                           A344ClinicaLogoBoleta = httpContext.cgiGet( edtClinicaLogoBoleta_Internalname) ;
                           n344ClinicaLogoBoleta = false ;
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
                           A345ClinicaLogoPago = httpContext.cgiGet( edtClinicaLogoPago_Internalname) ;
                           n345ClinicaLogoPago = false ;
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), !bGXsfl_43_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
                           A346ClinicaTelefono = httpContext.cgiGet( edtClinicaTelefono_Internalname) ;
                           A347ClinicaWhatsApp = httpContext.cgiGet( edtClinicaWhatsApp_Internalname) ;
                           A348ClinicaFacebook = httpContext.cgiGet( edtClinicaFacebook_Internalname) ;
                           A349ClinicaTwiter = httpContext.cgiGet( edtClinicaTwiter_Internalname) ;
                           A350ClinicaInstagram = httpContext.cgiGet( edtClinicaInstagram_Internalname) ;
                           A351ClinicaLinkedin = httpContext.cgiGet( edtClinicaLinkedin_Internalname) ;
                           cmbClinicaTiempoDeCita.setName( cmbClinicaTiempoDeCita.getInternalname() );
                           cmbClinicaTiempoDeCita.setValue( httpContext.cgiGet( cmbClinicaTiempoDeCita.getInternalname()) );
                           A120ClinicaTiempoDeCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbClinicaTiempoDeCita.getInternalname()))) ;
                           cmbClinicaEstado.setName( cmbClinicaEstado.getInternalname() );
                           cmbClinicaEstado.setValue( httpContext.cgiGet( cmbClinicaEstado.getInternalname()) );
                           A121ClinicaEstado = httpContext.cgiGet( cmbClinicaEstado.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e191J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e201J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e211J2 ();
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

   public void we1J2( )
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

   public void pa1J2( )
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
                                 short AV27TFClinicaId ,
                                 short AV28TFClinicaId_To ,
                                 long AV29TFClinicaRUC ,
                                 long AV30TFClinicaRUC_To ,
                                 String AV31TFClinicaNombreComercial ,
                                 String AV32TFClinicaNombreComercial_Sel ,
                                 String AV33TFClinicaNombreAbreviado ,
                                 String AV34TFClinicaNombreAbreviado_Sel ,
                                 String AV35TFClinicaDireccionComercial ,
                                 String AV36TFClinicaDireccionComercial_Sel ,
                                 String AV37TFClinicaCorreo ,
                                 String AV38TFClinicaCorreo_Sel ,
                                 GXSimpleCollection<Short> AV40TFClinicaMoneda_Sels ,
                                 String AV41TFClinicaTelefono ,
                                 String AV42TFClinicaTelefono_Sel ,
                                 String AV43TFClinicaWhatsApp ,
                                 String AV44TFClinicaWhatsApp_Sel ,
                                 String AV45TFClinicaFacebook ,
                                 String AV46TFClinicaFacebook_Sel ,
                                 String AV47TFClinicaTwiter ,
                                 String AV48TFClinicaTwiter_Sel ,
                                 String AV49TFClinicaInstagram ,
                                 String AV50TFClinicaInstagram_Sel ,
                                 String AV51TFClinicaLinkedin ,
                                 String AV52TFClinicaLinkedin_Sel ,
                                 GXSimpleCollection<Byte> AV54TFClinicaTiempoDeCita_Sels ,
                                 GXSimpleCollection<String> AV56TFClinicaEstado_Sels ,
                                 String AV96Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV62IsAuthorized_Update ,
                                 boolean AV64IsAuthorized_Delete )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e201J2 ();
      GRID_nCurrentRecord = 0 ;
      rf1J2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLINICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICAID", GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ".", "")));
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
      rf1J2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV96Pgmname = "ClinicaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf1J2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e201J2 ();
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
                                              Short.valueOf(A341ClinicaMoneda) ,
                                              AV81Clinicawwds_14_tfclinicamoneda_sels ,
                                              Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                              AV94Clinicawwds_27_tfclinicatiempodecita_sels ,
                                              A121ClinicaEstado ,
                                              AV95Clinicawwds_28_tfclinicaestado_sels ,
                                              AV68Clinicawwds_1_filterfulltext ,
                                              Short.valueOf(AV69Clinicawwds_2_tfclinicaid) ,
                                              Short.valueOf(AV70Clinicawwds_3_tfclinicaid_to) ,
                                              Long.valueOf(AV71Clinicawwds_4_tfclinicaruc) ,
                                              Long.valueOf(AV72Clinicawwds_5_tfclinicaruc_to) ,
                                              AV74Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                              AV73Clinicawwds_6_tfclinicanombrecomercial ,
                                              AV76Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                              AV75Clinicawwds_8_tfclinicanombreabreviado ,
                                              AV78Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                              AV77Clinicawwds_10_tfclinicadireccioncomercial ,
                                              AV80Clinicawwds_13_tfclinicacorreo_sel ,
                                              AV79Clinicawwds_12_tfclinicacorreo ,
                                              Integer.valueOf(AV81Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                              AV83Clinicawwds_16_tfclinicatelefono_sel ,
                                              AV82Clinicawwds_15_tfclinicatelefono ,
                                              AV85Clinicawwds_18_tfclinicawhatsapp_sel ,
                                              AV84Clinicawwds_17_tfclinicawhatsapp ,
                                              AV87Clinicawwds_20_tfclinicafacebook_sel ,
                                              AV86Clinicawwds_19_tfclinicafacebook ,
                                              AV89Clinicawwds_22_tfclinicatwiter_sel ,
                                              AV88Clinicawwds_21_tfclinicatwiter ,
                                              AV91Clinicawwds_24_tfclinicainstagram_sel ,
                                              AV90Clinicawwds_23_tfclinicainstagram ,
                                              AV93Clinicawwds_26_tfclinicalinkedin_sel ,
                                              AV92Clinicawwds_25_tfclinicalinkedin ,
                                              Integer.valueOf(AV94Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                              Integer.valueOf(AV95Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                              Short.valueOf(A28ClinicaId) ,
                                              Long.valueOf(A118ClinicaRUC) ,
                                              A116ClinicaNombreComercial ,
                                              A80ClinicaNombreAbreviado ,
                                              A119ClinicaDireccionComercial ,
                                              A340ClinicaCorreo ,
                                              A346ClinicaTelefono ,
                                              A347ClinicaWhatsApp ,
                                              A348ClinicaFacebook ,
                                              A349ClinicaTwiter ,
                                              A350ClinicaInstagram ,
                                              A351ClinicaLinkedin ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
         lV73Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
         lV75Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
         lV77Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
         lV79Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV79Clinicawwds_12_tfclinicacorreo), "%", "") ;
         lV82Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV82Clinicawwds_15_tfclinicatelefono), 12, "%") ;
         lV84Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV84Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
         lV86Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_19_tfclinicafacebook), "%", "") ;
         lV88Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_21_tfclinicatwiter), "%", "") ;
         lV90Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV90Clinicawwds_23_tfclinicainstagram), "%", "") ;
         lV92Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV92Clinicawwds_25_tfclinicalinkedin), "%", "") ;
         /* Using cursor H001J2 */
         pr_default.execute(0, new Object[] {lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, Short.valueOf(AV69Clinicawwds_2_tfclinicaid), Short.valueOf(AV70Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV71Clinicawwds_4_tfclinicaruc), Long.valueOf(AV72Clinicawwds_5_tfclinicaruc_to), lV73Clinicawwds_6_tfclinicanombrecomercial, AV74Clinicawwds_7_tfclinicanombrecomercial_sel, lV75Clinicawwds_8_tfclinicanombreabreviado, AV76Clinicawwds_9_tfclinicanombreabreviado_sel, lV77Clinicawwds_10_tfclinicadireccioncomercial, AV78Clinicawwds_11_tfclinicadireccioncomercial_sel, lV79Clinicawwds_12_tfclinicacorreo, AV80Clinicawwds_13_tfclinicacorreo_sel, lV82Clinicawwds_15_tfclinicatelefono, AV83Clinicawwds_16_tfclinicatelefono_sel, lV84Clinicawwds_17_tfclinicawhatsapp, AV85Clinicawwds_18_tfclinicawhatsapp_sel, lV86Clinicawwds_19_tfclinicafacebook, AV87Clinicawwds_20_tfclinicafacebook_sel, lV88Clinicawwds_21_tfclinicatwiter, AV89Clinicawwds_22_tfclinicatwiter_sel, lV90Clinicawwds_23_tfclinicainstagram, AV91Clinicawwds_24_tfclinicainstagram_sel, lV92Clinicawwds_25_tfclinicalinkedin, AV93Clinicawwds_26_tfclinicalinkedin_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A121ClinicaEstado = H001J2_A121ClinicaEstado[0] ;
            A120ClinicaTiempoDeCita = H001J2_A120ClinicaTiempoDeCita[0] ;
            A351ClinicaLinkedin = H001J2_A351ClinicaLinkedin[0] ;
            A350ClinicaInstagram = H001J2_A350ClinicaInstagram[0] ;
            A349ClinicaTwiter = H001J2_A349ClinicaTwiter[0] ;
            A348ClinicaFacebook = H001J2_A348ClinicaFacebook[0] ;
            A347ClinicaWhatsApp = H001J2_A347ClinicaWhatsApp[0] ;
            A346ClinicaTelefono = H001J2_A346ClinicaTelefono[0] ;
            A345ClinicaLogoPago = H001J2_A345ClinicaLogoPago[0] ;
            n345ClinicaLogoPago = H001J2_n345ClinicaLogoPago[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
            A40004ClinicaLogoPago_GXI = H001J2_A40004ClinicaLogoPago_GXI[0] ;
            n40004ClinicaLogoPago_GXI = H001J2_n40004ClinicaLogoPago_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
            A344ClinicaLogoBoleta = H001J2_A344ClinicaLogoBoleta[0] ;
            n344ClinicaLogoBoleta = H001J2_n344ClinicaLogoBoleta[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
            A40003ClinicaLogoBoleta_GXI = H001J2_A40003ClinicaLogoBoleta_GXI[0] ;
            n40003ClinicaLogoBoleta_GXI = H001J2_n40003ClinicaLogoBoleta_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
            A343ClinicaLogoFactura = H001J2_A343ClinicaLogoFactura[0] ;
            n343ClinicaLogoFactura = H001J2_n343ClinicaLogoFactura[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
            A40002ClinicaLogoFactura_GXI = H001J2_A40002ClinicaLogoFactura_GXI[0] ;
            n40002ClinicaLogoFactura_GXI = H001J2_n40002ClinicaLogoFactura_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
            A342ClinicaLogoHeader = H001J2_A342ClinicaLogoHeader[0] ;
            n342ClinicaLogoHeader = H001J2_n342ClinicaLogoHeader[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
            A40001ClinicaLogoHeader_GXI = H001J2_A40001ClinicaLogoHeader_GXI[0] ;
            n40001ClinicaLogoHeader_GXI = H001J2_n40001ClinicaLogoHeader_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
            A117ClinicaLogo = H001J2_A117ClinicaLogo[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
            A40000ClinicaLogo_GXI = H001J2_A40000ClinicaLogo_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), !bGXsfl_43_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
            A341ClinicaMoneda = H001J2_A341ClinicaMoneda[0] ;
            A340ClinicaCorreo = H001J2_A340ClinicaCorreo[0] ;
            A119ClinicaDireccionComercial = H001J2_A119ClinicaDireccionComercial[0] ;
            A80ClinicaNombreAbreviado = H001J2_A80ClinicaNombreAbreviado[0] ;
            A116ClinicaNombreComercial = H001J2_A116ClinicaNombreComercial[0] ;
            A118ClinicaRUC = H001J2_A118ClinicaRUC[0] ;
            A28ClinicaId = H001J2_A28ClinicaId[0] ;
            e211J2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb1J0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1J2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV96Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV96Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV62IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV62IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV64IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV64IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLINICAID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9")));
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
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV81Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV94Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV95Clinicawwds_28_tfclinicaestado_sels ,
                                           AV68Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV69Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV70Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV71Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV72Clinicawwds_5_tfclinicaruc_to) ,
                                           AV74Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV73Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV76Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV75Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV78Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV77Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV80Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV79Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV81Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV83Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV82Clinicawwds_15_tfclinicatelefono ,
                                           AV85Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV84Clinicawwds_17_tfclinicawhatsapp ,
                                           AV87Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV86Clinicawwds_19_tfclinicafacebook ,
                                           AV89Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV88Clinicawwds_21_tfclinicatwiter ,
                                           AV91Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV90Clinicawwds_23_tfclinicainstagram ,
                                           AV93Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV92Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV94Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV95Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV68Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV68Clinicawwds_1_filterfulltext), "%", "") ;
      lV73Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV73Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV75Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV75Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV77Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV79Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV79Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV82Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV82Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV84Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV84Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV86Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV88Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV90Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV90Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV92Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV92Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor H001J3 */
      pr_default.execute(1, new Object[] {lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, lV68Clinicawwds_1_filterfulltext, Short.valueOf(AV69Clinicawwds_2_tfclinicaid), Short.valueOf(AV70Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV71Clinicawwds_4_tfclinicaruc), Long.valueOf(AV72Clinicawwds_5_tfclinicaruc_to), lV73Clinicawwds_6_tfclinicanombrecomercial, AV74Clinicawwds_7_tfclinicanombrecomercial_sel, lV75Clinicawwds_8_tfclinicanombreabreviado, AV76Clinicawwds_9_tfclinicanombreabreviado_sel, lV77Clinicawwds_10_tfclinicadireccioncomercial, AV78Clinicawwds_11_tfclinicadireccioncomercial_sel, lV79Clinicawwds_12_tfclinicacorreo, AV80Clinicawwds_13_tfclinicacorreo_sel, lV82Clinicawwds_15_tfclinicatelefono, AV83Clinicawwds_16_tfclinicatelefono_sel, lV84Clinicawwds_17_tfclinicawhatsapp, AV85Clinicawwds_18_tfclinicawhatsapp_sel, lV86Clinicawwds_19_tfclinicafacebook, AV87Clinicawwds_20_tfclinicafacebook_sel, lV88Clinicawwds_21_tfclinicatwiter, AV89Clinicawwds_22_tfclinicatwiter_sel, lV90Clinicawwds_23_tfclinicainstagram, AV91Clinicawwds_24_tfclinicainstagram_sel, lV92Clinicawwds_25_tfclinicalinkedin, AV93Clinicawwds_26_tfclinicalinkedin_sel});
      GRID_nRecordCount = H001J3_AGRID_nRecordCount[0] ;
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
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFClinicaId, AV28TFClinicaId_To, AV29TFClinicaRUC, AV30TFClinicaRUC_To, AV31TFClinicaNombreComercial, AV32TFClinicaNombreComercial_Sel, AV33TFClinicaNombreAbreviado, AV34TFClinicaNombreAbreviado_Sel, AV35TFClinicaDireccionComercial, AV36TFClinicaDireccionComercial_Sel, AV37TFClinicaCorreo, AV38TFClinicaCorreo_Sel, AV40TFClinicaMoneda_Sels, AV41TFClinicaTelefono, AV42TFClinicaTelefono_Sel, AV43TFClinicaWhatsApp, AV44TFClinicaWhatsApp_Sel, AV45TFClinicaFacebook, AV46TFClinicaFacebook_Sel, AV47TFClinicaTwiter, AV48TFClinicaTwiter_Sel, AV49TFClinicaInstagram, AV50TFClinicaInstagram_Sel, AV51TFClinicaLinkedin, AV52TFClinicaLinkedin_Sel, AV54TFClinicaTiempoDeCita_Sels, AV56TFClinicaEstado_Sels, AV96Pgmname, AV13OrderedBy, AV14OrderedDsc, AV62IsAuthorized_Update, AV64IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFClinicaId, AV28TFClinicaId_To, AV29TFClinicaRUC, AV30TFClinicaRUC_To, AV31TFClinicaNombreComercial, AV32TFClinicaNombreComercial_Sel, AV33TFClinicaNombreAbreviado, AV34TFClinicaNombreAbreviado_Sel, AV35TFClinicaDireccionComercial, AV36TFClinicaDireccionComercial_Sel, AV37TFClinicaCorreo, AV38TFClinicaCorreo_Sel, AV40TFClinicaMoneda_Sels, AV41TFClinicaTelefono, AV42TFClinicaTelefono_Sel, AV43TFClinicaWhatsApp, AV44TFClinicaWhatsApp_Sel, AV45TFClinicaFacebook, AV46TFClinicaFacebook_Sel, AV47TFClinicaTwiter, AV48TFClinicaTwiter_Sel, AV49TFClinicaInstagram, AV50TFClinicaInstagram_Sel, AV51TFClinicaLinkedin, AV52TFClinicaLinkedin_Sel, AV54TFClinicaTiempoDeCita_Sels, AV56TFClinicaEstado_Sels, AV96Pgmname, AV13OrderedBy, AV14OrderedDsc, AV62IsAuthorized_Update, AV64IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFClinicaId, AV28TFClinicaId_To, AV29TFClinicaRUC, AV30TFClinicaRUC_To, AV31TFClinicaNombreComercial, AV32TFClinicaNombreComercial_Sel, AV33TFClinicaNombreAbreviado, AV34TFClinicaNombreAbreviado_Sel, AV35TFClinicaDireccionComercial, AV36TFClinicaDireccionComercial_Sel, AV37TFClinicaCorreo, AV38TFClinicaCorreo_Sel, AV40TFClinicaMoneda_Sels, AV41TFClinicaTelefono, AV42TFClinicaTelefono_Sel, AV43TFClinicaWhatsApp, AV44TFClinicaWhatsApp_Sel, AV45TFClinicaFacebook, AV46TFClinicaFacebook_Sel, AV47TFClinicaTwiter, AV48TFClinicaTwiter_Sel, AV49TFClinicaInstagram, AV50TFClinicaInstagram_Sel, AV51TFClinicaLinkedin, AV52TFClinicaLinkedin_Sel, AV54TFClinicaTiempoDeCita_Sels, AV56TFClinicaEstado_Sels, AV96Pgmname, AV13OrderedBy, AV14OrderedDsc, AV62IsAuthorized_Update, AV64IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFClinicaId, AV28TFClinicaId_To, AV29TFClinicaRUC, AV30TFClinicaRUC_To, AV31TFClinicaNombreComercial, AV32TFClinicaNombreComercial_Sel, AV33TFClinicaNombreAbreviado, AV34TFClinicaNombreAbreviado_Sel, AV35TFClinicaDireccionComercial, AV36TFClinicaDireccionComercial_Sel, AV37TFClinicaCorreo, AV38TFClinicaCorreo_Sel, AV40TFClinicaMoneda_Sels, AV41TFClinicaTelefono, AV42TFClinicaTelefono_Sel, AV43TFClinicaWhatsApp, AV44TFClinicaWhatsApp_Sel, AV45TFClinicaFacebook, AV46TFClinicaFacebook_Sel, AV47TFClinicaTwiter, AV48TFClinicaTwiter_Sel, AV49TFClinicaInstagram, AV50TFClinicaInstagram_Sel, AV51TFClinicaLinkedin, AV52TFClinicaLinkedin_Sel, AV54TFClinicaTiempoDeCita_Sels, AV56TFClinicaEstado_Sels, AV96Pgmname, AV13OrderedBy, AV14OrderedDsc, AV62IsAuthorized_Update, AV64IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFClinicaId, AV28TFClinicaId_To, AV29TFClinicaRUC, AV30TFClinicaRUC_To, AV31TFClinicaNombreComercial, AV32TFClinicaNombreComercial_Sel, AV33TFClinicaNombreAbreviado, AV34TFClinicaNombreAbreviado_Sel, AV35TFClinicaDireccionComercial, AV36TFClinicaDireccionComercial_Sel, AV37TFClinicaCorreo, AV38TFClinicaCorreo_Sel, AV40TFClinicaMoneda_Sels, AV41TFClinicaTelefono, AV42TFClinicaTelefono_Sel, AV43TFClinicaWhatsApp, AV44TFClinicaWhatsApp_Sel, AV45TFClinicaFacebook, AV46TFClinicaFacebook_Sel, AV47TFClinicaTwiter, AV48TFClinicaTwiter_Sel, AV49TFClinicaInstagram, AV50TFClinicaInstagram_Sel, AV51TFClinicaLinkedin, AV52TFClinicaLinkedin_Sel, AV54TFClinicaTiempoDeCita_Sels, AV56TFClinicaEstado_Sels, AV96Pgmname, AV13OrderedBy, AV14OrderedDsc, AV62IsAuthorized_Update, AV64IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV96Pgmname = "ClinicaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1J0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e191J2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV57DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV59GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV60GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
      e191J2 ();
      if (returnInSub) return;
   }

   public void e191J2( )
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
      Form.setCaption( " Clinica" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV57DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV57DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e201J2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("ClinicaWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("ClinicaWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtClinicaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaRUC_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaRUC_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaRUC_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaNombreComercial_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreComercial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreComercial_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaNombreAbreviado_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreAbreviado_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreAbreviado_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaDireccionComercial_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaDireccionComercial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaDireccionComercial_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaCorreo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaCorreo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaCorreo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbClinicaMoneda.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaMoneda.getInternalname(), "Visible", GXutil.ltrimstr( cmbClinicaMoneda.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaLogo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLogo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaLogoHeader_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoHeader_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLogoHeader_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaLogoFactura_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoFactura_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLogoFactura_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaLogoBoleta_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoBoleta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLogoBoleta_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaLogoPago_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLogoPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLogoPago_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaTelefono_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaTelefono_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaTelefono_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaWhatsApp_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaWhatsApp_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaWhatsApp_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaFacebook_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaFacebook_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaFacebook_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaTwiter_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaTwiter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaTwiter_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaInstagram_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaInstagram_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaInstagram_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaLinkedin_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLinkedin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLinkedin_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbClinicaTiempoDeCita.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaTiempoDeCita.getInternalname(), "Visible", GXutil.ltrimstr( cmbClinicaTiempoDeCita.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbClinicaEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbClinicaEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV59GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59GridCurrentPage), 10, 0));
      AV60GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60GridPageCount), 10, 0));
      AV68Clinicawwds_1_filterfulltext = AV16FilterFullText ;
      AV69Clinicawwds_2_tfclinicaid = AV27TFClinicaId ;
      AV70Clinicawwds_3_tfclinicaid_to = AV28TFClinicaId_To ;
      AV71Clinicawwds_4_tfclinicaruc = AV29TFClinicaRUC ;
      AV72Clinicawwds_5_tfclinicaruc_to = AV30TFClinicaRUC_To ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = AV31TFClinicaNombreComercial ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = AV32TFClinicaNombreComercial_Sel ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = AV33TFClinicaNombreAbreviado ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = AV34TFClinicaNombreAbreviado_Sel ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = AV35TFClinicaDireccionComercial ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = AV36TFClinicaDireccionComercial_Sel ;
      AV79Clinicawwds_12_tfclinicacorreo = AV37TFClinicaCorreo ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = AV38TFClinicaCorreo_Sel ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = AV40TFClinicaMoneda_Sels ;
      AV82Clinicawwds_15_tfclinicatelefono = AV41TFClinicaTelefono ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = AV42TFClinicaTelefono_Sel ;
      AV84Clinicawwds_17_tfclinicawhatsapp = AV43TFClinicaWhatsApp ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = AV44TFClinicaWhatsApp_Sel ;
      AV86Clinicawwds_19_tfclinicafacebook = AV45TFClinicaFacebook ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = AV46TFClinicaFacebook_Sel ;
      AV88Clinicawwds_21_tfclinicatwiter = AV47TFClinicaTwiter ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = AV48TFClinicaTwiter_Sel ;
      AV90Clinicawwds_23_tfclinicainstagram = AV49TFClinicaInstagram ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = AV50TFClinicaInstagram_Sel ;
      AV92Clinicawwds_25_tfclinicalinkedin = AV51TFClinicaLinkedin ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = AV52TFClinicaLinkedin_Sel ;
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = AV54TFClinicaTiempoDeCita_Sels ;
      AV95Clinicawwds_28_tfclinicaestado_sels = AV56TFClinicaEstado_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e121J2( )
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
         AV58PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV58PageToGo) ;
      }
   }

   public void e131J2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141J2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaId") == 0 )
         {
            AV27TFClinicaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFClinicaId), 4, 0));
            AV28TFClinicaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaRUC") == 0 )
         {
            AV29TFClinicaRUC = GXutil.lval( Ddo_grid_Filteredtext_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFClinicaRUC), 11, 0));
            AV30TFClinicaRUC_To = GXutil.lval( Ddo_grid_Filteredtextto_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFClinicaRUC_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFClinicaRUC_To), 11, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaNombreComercial") == 0 )
         {
            AV31TFClinicaNombreComercial = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFClinicaNombreComercial", AV31TFClinicaNombreComercial);
            AV32TFClinicaNombreComercial_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFClinicaNombreComercial_Sel", AV32TFClinicaNombreComercial_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaNombreAbreviado") == 0 )
         {
            AV33TFClinicaNombreAbreviado = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFClinicaNombreAbreviado", AV33TFClinicaNombreAbreviado);
            AV34TFClinicaNombreAbreviado_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFClinicaNombreAbreviado_Sel", AV34TFClinicaNombreAbreviado_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaDireccionComercial") == 0 )
         {
            AV35TFClinicaDireccionComercial = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFClinicaDireccionComercial", AV35TFClinicaDireccionComercial);
            AV36TFClinicaDireccionComercial_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFClinicaDireccionComercial_Sel", AV36TFClinicaDireccionComercial_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaCorreo") == 0 )
         {
            AV37TFClinicaCorreo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFClinicaCorreo", AV37TFClinicaCorreo);
            AV38TFClinicaCorreo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFClinicaCorreo_Sel", AV38TFClinicaCorreo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaMoneda") == 0 )
         {
            AV39TFClinicaMoneda_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFClinicaMoneda_SelsJson", AV39TFClinicaMoneda_SelsJson);
            AV40TFClinicaMoneda_Sels.fromJSonString(GXutil.strReplace( AV39TFClinicaMoneda_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaTelefono") == 0 )
         {
            AV41TFClinicaTelefono = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFClinicaTelefono", AV41TFClinicaTelefono);
            AV42TFClinicaTelefono_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFClinicaTelefono_Sel", AV42TFClinicaTelefono_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaWhatsApp") == 0 )
         {
            AV43TFClinicaWhatsApp = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFClinicaWhatsApp", AV43TFClinicaWhatsApp);
            AV44TFClinicaWhatsApp_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFClinicaWhatsApp_Sel", AV44TFClinicaWhatsApp_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaFacebook") == 0 )
         {
            AV45TFClinicaFacebook = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFClinicaFacebook", AV45TFClinicaFacebook);
            AV46TFClinicaFacebook_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFClinicaFacebook_Sel", AV46TFClinicaFacebook_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaTwiter") == 0 )
         {
            AV47TFClinicaTwiter = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFClinicaTwiter", AV47TFClinicaTwiter);
            AV48TFClinicaTwiter_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFClinicaTwiter_Sel", AV48TFClinicaTwiter_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaInstagram") == 0 )
         {
            AV49TFClinicaInstagram = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFClinicaInstagram", AV49TFClinicaInstagram);
            AV50TFClinicaInstagram_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFClinicaInstagram_Sel", AV50TFClinicaInstagram_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaLinkedin") == 0 )
         {
            AV51TFClinicaLinkedin = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFClinicaLinkedin", AV51TFClinicaLinkedin);
            AV52TFClinicaLinkedin_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFClinicaLinkedin_Sel", AV52TFClinicaLinkedin_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaTiempoDeCita") == 0 )
         {
            AV53TFClinicaTiempoDeCita_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFClinicaTiempoDeCita_SelsJson", AV53TFClinicaTiempoDeCita_SelsJson);
            AV54TFClinicaTiempoDeCita_Sels.fromJSonString(GXutil.strReplace( AV53TFClinicaTiempoDeCita_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaEstado") == 0 )
         {
            AV55TFClinicaEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFClinicaEstado_SelsJson", AV55TFClinicaEstado_SelsJson);
            AV56TFClinicaEstado_Sels.fromJSonString(AV55TFClinicaEstado_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFClinicaEstado_Sels", AV56TFClinicaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54TFClinicaTiempoDeCita_Sels", AV54TFClinicaTiempoDeCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFClinicaMoneda_Sels", AV40TFClinicaMoneda_Sels);
   }

   private void e211J2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV61Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV61Update);
      if ( AV62IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.clinica", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A28ClinicaId,4,0))}, new String[] {"Mode","ClinicaId"})  ;
      }
      AV63Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV63Delete);
      if ( AV64IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.clinica", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A28ClinicaId,4,0))}, new String[] {"Mode","ClinicaId"})  ;
      }
      edtClinicaRUC_Link = formatLink("com.projectthani.clinicaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A28ClinicaId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"ClinicaId","TabCode"})  ;
      edtClinicaFacebook_Linktarget = "_blank" ;
      edtClinicaFacebook_Link = A348ClinicaFacebook ;
      edtClinicaTwiter_Linktarget = "_blank" ;
      edtClinicaTwiter_Link = A349ClinicaTwiter ;
      edtClinicaInstagram_Linktarget = "_blank" ;
      edtClinicaInstagram_Link = A350ClinicaInstagram ;
      edtClinicaLinkedin_Linktarget = "_blank" ;
      edtClinicaLinkedin_Link = A351ClinicaLinkedin ;
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

   public void e151J2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "ClinicaWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e111J2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("ClinicaWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV96Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("ClinicaWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV25ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "ClinicaWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         clinicaww_impl.this.GXt_char4 = GXv_char5[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV96Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFClinicaMoneda_Sels", AV40TFClinicaMoneda_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54TFClinicaTiempoDeCita_Sels", AV54TFClinicaTiempoDeCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFClinicaEstado_Sels", AV56TFClinicaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e161J2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.clinica", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","ClinicaId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e171J2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char5[0] = AV17ExcelFilename ;
      GXv_char6[0] = AV18ErrorMessage ;
      new com.projectthani.clinicawwexport(remoteHandle, context).execute( GXv_char5, GXv_char6) ;
      clinicaww_impl.this.AV17ExcelFilename = GXv_char5[0] ;
      clinicaww_impl.this.AV18ErrorMessage = GXv_char6[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFClinicaEstado_Sels", AV56TFClinicaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54TFClinicaTiempoDeCita_Sels", AV54TFClinicaTiempoDeCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFClinicaMoneda_Sels", AV40TFClinicaMoneda_Sels);
   }

   public void e181J2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.clinicawwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFClinicaEstado_Sels", AV56TFClinicaEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54TFClinicaTiempoDeCita_Sels", AV54TFClinicaTiempoDeCita_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFClinicaMoneda_Sels", AV40TFClinicaMoneda_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaRUC", "", "RUC", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaNombreComercial", "", "Nombre Comercial", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaNombreAbreviado", "", "Nombre Abrev.", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaDireccionComercial", "", "Direccion Comercial", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaCorreo", "", "Correo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaMoneda", "", "Moneda", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaLogo", "", "Logo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaLogoHeader", "", "Logo Header", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaLogoFactura", "", "Logo Factura", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaLogoBoleta", "", "Logo Boleta", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaLogoPago", "", "Logo Pago", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaTelefono", "", "Telefono", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaWhatsApp", "", "Whats App", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaFacebook", "", "Facebook", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaTwiter", "", "Twiter", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaInstagram", "", "Instagram", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaLinkedin", "", "Linkedin", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaTiempoDeCita", "", "Tiempo De Cita", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ClinicaEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXt_char4 = AV20UserCustomValue ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ClinicaWWColumnsSelector", GXv_char6) ;
      clinicaww_impl.this.GXt_char4 = GXv_char6[0] ;
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
      GXt_boolean9 = AV62IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Update", GXv_boolean10) ;
      clinicaww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV62IsAuthorized_Update = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62IsAuthorized_Update", AV62IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV62IsAuthorized_Update));
      if ( ! ( AV62IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV64IsAuthorized_Delete ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Delete", GXv_boolean10) ;
      clinicaww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV64IsAuthorized_Delete = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64IsAuthorized_Delete", AV64IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV64IsAuthorized_Delete));
      if ( ! ( AV64IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV65TempBoolean ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Insert", GXv_boolean10) ;
      clinicaww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV65TempBoolean = GXt_boolean9 ;
      if ( ! ( AV65TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "ClinicaWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFClinicaId), 4, 0));
      AV28TFClinicaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFClinicaId_To), 4, 0));
      AV29TFClinicaRUC = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFClinicaRUC), 11, 0));
      AV30TFClinicaRUC_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFClinicaRUC_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFClinicaRUC_To), 11, 0));
      AV31TFClinicaNombreComercial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFClinicaNombreComercial", AV31TFClinicaNombreComercial);
      AV32TFClinicaNombreComercial_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFClinicaNombreComercial_Sel", AV32TFClinicaNombreComercial_Sel);
      AV33TFClinicaNombreAbreviado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFClinicaNombreAbreviado", AV33TFClinicaNombreAbreviado);
      AV34TFClinicaNombreAbreviado_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFClinicaNombreAbreviado_Sel", AV34TFClinicaNombreAbreviado_Sel);
      AV35TFClinicaDireccionComercial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFClinicaDireccionComercial", AV35TFClinicaDireccionComercial);
      AV36TFClinicaDireccionComercial_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFClinicaDireccionComercial_Sel", AV36TFClinicaDireccionComercial_Sel);
      AV37TFClinicaCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFClinicaCorreo", AV37TFClinicaCorreo);
      AV38TFClinicaCorreo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFClinicaCorreo_Sel", AV38TFClinicaCorreo_Sel);
      AV40TFClinicaMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV41TFClinicaTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFClinicaTelefono", AV41TFClinicaTelefono);
      AV42TFClinicaTelefono_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFClinicaTelefono_Sel", AV42TFClinicaTelefono_Sel);
      AV43TFClinicaWhatsApp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFClinicaWhatsApp", AV43TFClinicaWhatsApp);
      AV44TFClinicaWhatsApp_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFClinicaWhatsApp_Sel", AV44TFClinicaWhatsApp_Sel);
      AV45TFClinicaFacebook = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFClinicaFacebook", AV45TFClinicaFacebook);
      AV46TFClinicaFacebook_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFClinicaFacebook_Sel", AV46TFClinicaFacebook_Sel);
      AV47TFClinicaTwiter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFClinicaTwiter", AV47TFClinicaTwiter);
      AV48TFClinicaTwiter_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFClinicaTwiter_Sel", AV48TFClinicaTwiter_Sel);
      AV49TFClinicaInstagram = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFClinicaInstagram", AV49TFClinicaInstagram);
      AV50TFClinicaInstagram_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFClinicaInstagram_Sel", AV50TFClinicaInstagram_Sel);
      AV51TFClinicaLinkedin = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFClinicaLinkedin", AV51TFClinicaLinkedin);
      AV52TFClinicaLinkedin_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFClinicaLinkedin_Sel", AV52TFClinicaLinkedin_Sel);
      AV54TFClinicaTiempoDeCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV56TFClinicaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV96Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV96Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV96Pgmname+"GridState"), null, null);
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
      AV97GXV1 = 1 ;
      while ( AV97GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV97GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV27TFClinicaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFClinicaId), 4, 0));
            AV28TFClinicaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV29TFClinicaRUC = GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFClinicaRUC), 11, 0));
            AV30TFClinicaRUC_To = GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFClinicaRUC_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFClinicaRUC_To), 11, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV31TFClinicaNombreComercial = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFClinicaNombreComercial", AV31TFClinicaNombreComercial);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV32TFClinicaNombreComercial_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFClinicaNombreComercial_Sel", AV32TFClinicaNombreComercial_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO") == 0 )
         {
            AV33TFClinicaNombreAbreviado = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFClinicaNombreAbreviado", AV33TFClinicaNombreAbreviado);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO_SEL") == 0 )
         {
            AV34TFClinicaNombreAbreviado_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFClinicaNombreAbreviado_Sel", AV34TFClinicaNombreAbreviado_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL") == 0 )
         {
            AV35TFClinicaDireccionComercial = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFClinicaDireccionComercial", AV35TFClinicaDireccionComercial);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL_SEL") == 0 )
         {
            AV36TFClinicaDireccionComercial_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFClinicaDireccionComercial_Sel", AV36TFClinicaDireccionComercial_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO") == 0 )
         {
            AV37TFClinicaCorreo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFClinicaCorreo", AV37TFClinicaCorreo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO_SEL") == 0 )
         {
            AV38TFClinicaCorreo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFClinicaCorreo_Sel", AV38TFClinicaCorreo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAMONEDA_SEL") == 0 )
         {
            AV39TFClinicaMoneda_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFClinicaMoneda_SelsJson", AV39TFClinicaMoneda_SelsJson);
            AV40TFClinicaMoneda_Sels.fromJSonString(AV39TFClinicaMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO") == 0 )
         {
            AV41TFClinicaTelefono = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFClinicaTelefono", AV41TFClinicaTelefono);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO_SEL") == 0 )
         {
            AV42TFClinicaTelefono_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFClinicaTelefono_Sel", AV42TFClinicaTelefono_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP") == 0 )
         {
            AV43TFClinicaWhatsApp = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFClinicaWhatsApp", AV43TFClinicaWhatsApp);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP_SEL") == 0 )
         {
            AV44TFClinicaWhatsApp_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFClinicaWhatsApp_Sel", AV44TFClinicaWhatsApp_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK") == 0 )
         {
            AV45TFClinicaFacebook = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFClinicaFacebook", AV45TFClinicaFacebook);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK_SEL") == 0 )
         {
            AV46TFClinicaFacebook_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFClinicaFacebook_Sel", AV46TFClinicaFacebook_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER") == 0 )
         {
            AV47TFClinicaTwiter = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFClinicaTwiter", AV47TFClinicaTwiter);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER_SEL") == 0 )
         {
            AV48TFClinicaTwiter_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFClinicaTwiter_Sel", AV48TFClinicaTwiter_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM") == 0 )
         {
            AV49TFClinicaInstagram = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFClinicaInstagram", AV49TFClinicaInstagram);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM_SEL") == 0 )
         {
            AV50TFClinicaInstagram_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFClinicaInstagram_Sel", AV50TFClinicaInstagram_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN") == 0 )
         {
            AV51TFClinicaLinkedin = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFClinicaLinkedin", AV51TFClinicaLinkedin);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN_SEL") == 0 )
         {
            AV52TFClinicaLinkedin_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFClinicaLinkedin_Sel", AV52TFClinicaLinkedin_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATIEMPODECITA_SEL") == 0 )
         {
            AV53TFClinicaTiempoDeCita_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFClinicaTiempoDeCita_SelsJson", AV53TFClinicaTiempoDeCita_SelsJson);
            AV54TFClinicaTiempoDeCita_Sels.fromJSonString(AV53TFClinicaTiempoDeCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAESTADO_SEL") == 0 )
         {
            AV55TFClinicaEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFClinicaEstado_SelsJson", AV55TFClinicaEstado_SelsJson);
            AV56TFClinicaEstado_Sels.fromJSonString(AV55TFClinicaEstado_SelsJson, null);
         }
         AV97GXV1 = (int)(AV97GXV1+1) ;
      }
      GXt_char4 = "" ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFClinicaNombreComercial_Sel)==0), AV32TFClinicaNombreComercial_Sel, GXv_char6) ;
      clinicaww_impl.this.GXt_char4 = GXv_char6[0] ;
      GXt_char13 = "" ;
      GXv_char5[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFClinicaNombreAbreviado_Sel)==0), AV34TFClinicaNombreAbreviado_Sel, GXv_char5) ;
      clinicaww_impl.this.GXt_char13 = GXv_char5[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFClinicaDireccionComercial_Sel)==0), AV36TFClinicaDireccionComercial_Sel, GXv_char15) ;
      clinicaww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFClinicaCorreo_Sel)==0), AV38TFClinicaCorreo_Sel, GXv_char17) ;
      clinicaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFClinicaTelefono_Sel)==0), AV42TFClinicaTelefono_Sel, GXv_char19) ;
      clinicaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFClinicaWhatsApp_Sel)==0), AV44TFClinicaWhatsApp_Sel, GXv_char21) ;
      clinicaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV46TFClinicaFacebook_Sel)==0), AV46TFClinicaFacebook_Sel, GXv_char23) ;
      clinicaww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV48TFClinicaTwiter_Sel)==0), AV48TFClinicaTwiter_Sel, GXv_char25) ;
      clinicaww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV50TFClinicaInstagram_Sel)==0), AV50TFClinicaInstagram_Sel, GXv_char27) ;
      clinicaww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFClinicaLinkedin_Sel)==0), AV52TFClinicaLinkedin_Sel, GXv_char29) ;
      clinicaww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV56TFClinicaEstado_Sels.size()==0), AV55TFClinicaEstado_SelsJson, GXv_char31) ;
      clinicaww_impl.this.GXt_char30 = GXv_char31[0] ;
      Ddo_grid_Selectedvalue_set = "||"+GXt_char4+"|"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|"+((AV40TFClinicaMoneda_Sels.size()==0) ? "" : AV39TFClinicaMoneda_SelsJson)+"||||||"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"|"+GXt_char24+"|"+GXt_char26+"|"+GXt_char28+"|"+((AV54TFClinicaTiempoDeCita_Sels.size()==0) ? "" : AV53TFClinicaTiempoDeCita_SelsJson)+"|"+GXt_char30 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char30 = "" ;
      GXv_char31[0] = GXt_char30 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFClinicaNombreComercial)==0), AV31TFClinicaNombreComercial, GXv_char31) ;
      clinicaww_impl.this.GXt_char30 = GXv_char31[0] ;
      GXt_char28 = "" ;
      GXv_char29[0] = GXt_char28 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFClinicaNombreAbreviado)==0), AV33TFClinicaNombreAbreviado, GXv_char29) ;
      clinicaww_impl.this.GXt_char28 = GXv_char29[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFClinicaDireccionComercial)==0), AV35TFClinicaDireccionComercial, GXv_char27) ;
      clinicaww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFClinicaCorreo)==0), AV37TFClinicaCorreo, GXv_char25) ;
      clinicaww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV41TFClinicaTelefono)==0), AV41TFClinicaTelefono, GXv_char23) ;
      clinicaww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFClinicaWhatsApp)==0), AV43TFClinicaWhatsApp, GXv_char21) ;
      clinicaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFClinicaFacebook)==0), AV45TFClinicaFacebook, GXv_char19) ;
      clinicaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV47TFClinicaTwiter)==0), AV47TFClinicaTwiter, GXv_char17) ;
      clinicaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFClinicaInstagram)==0), AV49TFClinicaInstagram, GXv_char15) ;
      clinicaww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char6[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV51TFClinicaLinkedin)==0), AV51TFClinicaLinkedin, GXv_char6) ;
      clinicaww_impl.this.GXt_char13 = GXv_char6[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFClinicaId) ? "" : GXutil.str( AV27TFClinicaId, 4, 0))+"|"+((0==AV29TFClinicaRUC) ? "" : GXutil.str( AV29TFClinicaRUC, 11, 0))+"|"+GXt_char30+"|"+GXt_char28+"|"+GXt_char26+"|"+GXt_char24+"|||||||"+GXt_char22+"|"+GXt_char20+"|"+GXt_char18+"|"+GXt_char16+"|"+GXt_char14+"|"+GXt_char13+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFClinicaId_To) ? "" : GXutil.str( AV28TFClinicaId_To, 4, 0))+"|"+((0==AV30TFClinicaRUC_To) ? "" : GXutil.str( AV30TFClinicaRUC_To, 11, 0))+"||||||||||||||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV96Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState32, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICAID", !((0==AV27TFClinicaId)&&(0==AV28TFClinicaId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFClinicaId, 4, 0)), GXutil.trim( GXutil.str( AV28TFClinicaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICARUC", !((0==AV29TFClinicaRUC)&&(0==AV30TFClinicaRUC_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFClinicaRUC, 11, 0)), GXutil.trim( GXutil.str( AV30TFClinicaRUC_To, 11, 0))) ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICANOMBRECOMERCIAL", !(GXutil.strcmp("", AV31TFClinicaNombreComercial)==0), (short)(0), AV31TFClinicaNombreComercial, "", !(GXutil.strcmp("", AV32TFClinicaNombreComercial_Sel)==0), AV32TFClinicaNombreComercial_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICANOMBREABREVIADO", !(GXutil.strcmp("", AV33TFClinicaNombreAbreviado)==0), (short)(0), AV33TFClinicaNombreAbreviado, "", !(GXutil.strcmp("", AV34TFClinicaNombreAbreviado_Sel)==0), AV34TFClinicaNombreAbreviado_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICADIRECCIONCOMERCIAL", !(GXutil.strcmp("", AV35TFClinicaDireccionComercial)==0), (short)(0), AV35TFClinicaDireccionComercial, "", !(GXutil.strcmp("", AV36TFClinicaDireccionComercial_Sel)==0), AV36TFClinicaDireccionComercial_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICACORREO", !(GXutil.strcmp("", AV37TFClinicaCorreo)==0), (short)(0), AV37TFClinicaCorreo, "", !(GXutil.strcmp("", AV38TFClinicaCorreo_Sel)==0), AV38TFClinicaCorreo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICAMONEDA_SEL", !(AV40TFClinicaMoneda_Sels.size()==0), (short)(0), AV40TFClinicaMoneda_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICATELEFONO", !(GXutil.strcmp("", AV41TFClinicaTelefono)==0), (short)(0), AV41TFClinicaTelefono, "", !(GXutil.strcmp("", AV42TFClinicaTelefono_Sel)==0), AV42TFClinicaTelefono_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICAWHATSAPP", !(GXutil.strcmp("", AV43TFClinicaWhatsApp)==0), (short)(0), AV43TFClinicaWhatsApp, "", !(GXutil.strcmp("", AV44TFClinicaWhatsApp_Sel)==0), AV44TFClinicaWhatsApp_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICAFACEBOOK", !(GXutil.strcmp("", AV45TFClinicaFacebook)==0), (short)(0), AV45TFClinicaFacebook, "", !(GXutil.strcmp("", AV46TFClinicaFacebook_Sel)==0), AV46TFClinicaFacebook_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICATWITER", !(GXutil.strcmp("", AV47TFClinicaTwiter)==0), (short)(0), AV47TFClinicaTwiter, "", !(GXutil.strcmp("", AV48TFClinicaTwiter_Sel)==0), AV48TFClinicaTwiter_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICAINSTAGRAM", !(GXutil.strcmp("", AV49TFClinicaInstagram)==0), (short)(0), AV49TFClinicaInstagram, "", !(GXutil.strcmp("", AV50TFClinicaInstagram_Sel)==0), AV50TFClinicaInstagram_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICALINKEDIN", !(GXutil.strcmp("", AV51TFClinicaLinkedin)==0), (short)(0), AV51TFClinicaLinkedin, "", !(GXutil.strcmp("", AV52TFClinicaLinkedin_Sel)==0), AV52TFClinicaLinkedin_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICATIEMPODECITA_SEL", !(AV54TFClinicaTiempoDeCita_Sels.size()==0), (short)(0), AV54TFClinicaTiempoDeCita_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      GXv_SdtWWPGridState32[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState32, "TFCLINICAESTADO_SEL", !(AV56TFClinicaEstado_Sels.size()==0), (short)(0), AV56TFClinicaEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState32[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV96Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV96Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Clinica" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_1J2( boolean wbgen )
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
         wb_table2_30_1J2( true) ;
      }
      else
      {
         wb_table2_30_1J2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_1J2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_1J2e( true) ;
      }
      else
      {
         wb_table1_25_1J2e( false) ;
      }
   }

   public void wb_table2_30_1J2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_ClinicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_1J2e( true) ;
      }
      else
      {
         wb_table2_30_1J2e( false) ;
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
      pa1J2( ) ;
      ws1J2( ) ;
      we1J2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110332285", true, true);
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
      httpContext.AddJavascriptSource("clinicaww.js", "?20225110332285", false, true);
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
      edtClinicaId_Internalname = "CLINICAID_"+sGXsfl_43_idx ;
      edtClinicaRUC_Internalname = "CLINICARUC_"+sGXsfl_43_idx ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL_"+sGXsfl_43_idx ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO_"+sGXsfl_43_idx ;
      edtClinicaDireccionComercial_Internalname = "CLINICADIRECCIONCOMERCIAL_"+sGXsfl_43_idx ;
      edtClinicaCorreo_Internalname = "CLINICACORREO_"+sGXsfl_43_idx ;
      cmbClinicaMoneda.setInternalname( "CLINICAMONEDA_"+sGXsfl_43_idx );
      edtClinicaLogo_Internalname = "CLINICALOGO_"+sGXsfl_43_idx ;
      edtClinicaLogoHeader_Internalname = "CLINICALOGOHEADER_"+sGXsfl_43_idx ;
      edtClinicaLogoFactura_Internalname = "CLINICALOGOFACTURA_"+sGXsfl_43_idx ;
      edtClinicaLogoBoleta_Internalname = "CLINICALOGOBOLETA_"+sGXsfl_43_idx ;
      edtClinicaLogoPago_Internalname = "CLINICALOGOPAGO_"+sGXsfl_43_idx ;
      edtClinicaTelefono_Internalname = "CLINICATELEFONO_"+sGXsfl_43_idx ;
      edtClinicaWhatsApp_Internalname = "CLINICAWHATSAPP_"+sGXsfl_43_idx ;
      edtClinicaFacebook_Internalname = "CLINICAFACEBOOK_"+sGXsfl_43_idx ;
      edtClinicaTwiter_Internalname = "CLINICATWITER_"+sGXsfl_43_idx ;
      edtClinicaInstagram_Internalname = "CLINICAINSTAGRAM_"+sGXsfl_43_idx ;
      edtClinicaLinkedin_Internalname = "CLINICALINKEDIN_"+sGXsfl_43_idx ;
      cmbClinicaTiempoDeCita.setInternalname( "CLINICATIEMPODECITA_"+sGXsfl_43_idx );
      cmbClinicaEstado.setInternalname( "CLINICAESTADO_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtClinicaId_Internalname = "CLINICAID_"+sGXsfl_43_fel_idx ;
      edtClinicaRUC_Internalname = "CLINICARUC_"+sGXsfl_43_fel_idx ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL_"+sGXsfl_43_fel_idx ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO_"+sGXsfl_43_fel_idx ;
      edtClinicaDireccionComercial_Internalname = "CLINICADIRECCIONCOMERCIAL_"+sGXsfl_43_fel_idx ;
      edtClinicaCorreo_Internalname = "CLINICACORREO_"+sGXsfl_43_fel_idx ;
      cmbClinicaMoneda.setInternalname( "CLINICAMONEDA_"+sGXsfl_43_fel_idx );
      edtClinicaLogo_Internalname = "CLINICALOGO_"+sGXsfl_43_fel_idx ;
      edtClinicaLogoHeader_Internalname = "CLINICALOGOHEADER_"+sGXsfl_43_fel_idx ;
      edtClinicaLogoFactura_Internalname = "CLINICALOGOFACTURA_"+sGXsfl_43_fel_idx ;
      edtClinicaLogoBoleta_Internalname = "CLINICALOGOBOLETA_"+sGXsfl_43_fel_idx ;
      edtClinicaLogoPago_Internalname = "CLINICALOGOPAGO_"+sGXsfl_43_fel_idx ;
      edtClinicaTelefono_Internalname = "CLINICATELEFONO_"+sGXsfl_43_fel_idx ;
      edtClinicaWhatsApp_Internalname = "CLINICAWHATSAPP_"+sGXsfl_43_fel_idx ;
      edtClinicaFacebook_Internalname = "CLINICAFACEBOOK_"+sGXsfl_43_fel_idx ;
      edtClinicaTwiter_Internalname = "CLINICATWITER_"+sGXsfl_43_fel_idx ;
      edtClinicaInstagram_Internalname = "CLINICAINSTAGRAM_"+sGXsfl_43_fel_idx ;
      edtClinicaLinkedin_Internalname = "CLINICALINKEDIN_"+sGXsfl_43_fel_idx ;
      cmbClinicaTiempoDeCita.setInternalname( "CLINICATIEMPODECITA_"+sGXsfl_43_fel_idx );
      cmbClinicaEstado.setInternalname( "CLINICAESTADO_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb1J0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV61Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV63Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtClinicaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaId_Internalname,GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClinicaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtClinicaRUC_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaRUC_Internalname,GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'",edtClinicaRUC_Link,"","","",edtClinicaRUC_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtClinicaRUC_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaNombreComercial_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaNombreComercial_Internalname,A116ClinicaNombreComercial,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClinicaNombreComercial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaNombreComercial_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaNombreAbreviado_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaNombreAbreviado_Internalname,A80ClinicaNombreAbreviado,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClinicaNombreAbreviado_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaNombreAbreviado_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaDireccionComercial_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaDireccionComercial_Internalname,A119ClinicaDireccionComercial,"","","'"+""+"'"+",false,"+"'"+""+"'","http://maps.google.com/maps?q="+PrivateUtilities.encodeURL( A119ClinicaDireccionComercial),"_blank","","",edtClinicaDireccionComercial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaDireccionComercial_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1024),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Address","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaCorreo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaCorreo_Internalname,A340ClinicaCorreo,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A340ClinicaCorreo,"","","",edtClinicaCorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaCorreo_Visible),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbClinicaMoneda.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbClinicaMoneda.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CLINICAMONEDA_" + sGXsfl_43_idx ;
            cmbClinicaMoneda.setName( GXCCtl );
            cmbClinicaMoneda.setWebtags( "" );
            cmbClinicaMoneda.addItem("1", "Soles", (short)(0));
            cmbClinicaMoneda.addItem("2", "Dólares", (short)(0));
            cmbClinicaMoneda.addItem("3", "Euros", (short)(0));
            if ( cmbClinicaMoneda.getItemCount() > 0 )
            {
               A341ClinicaMoneda = (short)(GXutil.lval( cmbClinicaMoneda.getValidValue(GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbClinicaMoneda,cmbClinicaMoneda.getInternalname(),GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)),Integer.valueOf(1),cmbClinicaMoneda.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbClinicaMoneda.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbClinicaMoneda.setValue( GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbClinicaMoneda.getInternalname(), "Values", cmbClinicaMoneda.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtClinicaLogo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A117ClinicaLogo_IsBlob = (boolean)(((GXutil.strcmp("", A117ClinicaLogo)==0)&&(GXutil.strcmp("", A40000ClinicaLogo_GXI)==0))||!(GXutil.strcmp("", A117ClinicaLogo)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.getResourceRelative(A117ClinicaLogo)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtClinicaLogo_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtClinicaLogo_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A117ClinicaLogo_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtClinicaLogoHeader_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A342ClinicaLogoHeader_IsBlob = (boolean)(((GXutil.strcmp("", A342ClinicaLogoHeader)==0)&&(GXutil.strcmp("", A40001ClinicaLogoHeader_GXI)==0))||!(GXutil.strcmp("", A342ClinicaLogoHeader)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.getResourceRelative(A342ClinicaLogoHeader)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtClinicaLogoHeader_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtClinicaLogoHeader_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A342ClinicaLogoHeader_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtClinicaLogoFactura_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A343ClinicaLogoFactura_IsBlob = (boolean)(((GXutil.strcmp("", A343ClinicaLogoFactura)==0)&&(GXutil.strcmp("", A40002ClinicaLogoFactura_GXI)==0))||!(GXutil.strcmp("", A343ClinicaLogoFactura)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.getResourceRelative(A343ClinicaLogoFactura)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtClinicaLogoFactura_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtClinicaLogoFactura_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A343ClinicaLogoFactura_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtClinicaLogoBoleta_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A344ClinicaLogoBoleta_IsBlob = (boolean)(((GXutil.strcmp("", A344ClinicaLogoBoleta)==0)&&(GXutil.strcmp("", A40003ClinicaLogoBoleta_GXI)==0))||!(GXutil.strcmp("", A344ClinicaLogoBoleta)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.getResourceRelative(A344ClinicaLogoBoleta)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtClinicaLogoBoleta_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtClinicaLogoBoleta_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A344ClinicaLogoBoleta_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtClinicaLogoPago_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A345ClinicaLogoPago_IsBlob = (boolean)(((GXutil.strcmp("", A345ClinicaLogoPago)==0)&&(GXutil.strcmp("", A40004ClinicaLogoPago_GXI)==0))||!(GXutil.strcmp("", A345ClinicaLogoPago)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.getResourceRelative(A345ClinicaLogoPago)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtClinicaLogoPago_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtClinicaLogoPago_Visible),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A345ClinicaLogoPago_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaTelefono_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaTelefono_Internalname,GXutil.rtrim( A346ClinicaTelefono),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClinicaTelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaTelefono_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaWhatsApp_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaWhatsApp_Internalname,GXutil.rtrim( A347ClinicaWhatsApp),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClinicaWhatsApp_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaWhatsApp_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaFacebook_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaFacebook_Internalname,A348ClinicaFacebook,"","","'"+""+"'"+",false,"+"'"+""+"'",edtClinicaFacebook_Link,edtClinicaFacebook_Linktarget,"","",edtClinicaFacebook_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaFacebook_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaTwiter_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaTwiter_Internalname,A349ClinicaTwiter,"","","'"+""+"'"+",false,"+"'"+""+"'",edtClinicaTwiter_Link,edtClinicaTwiter_Linktarget,"","",edtClinicaTwiter_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaTwiter_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaInstagram_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaInstagram_Internalname,A350ClinicaInstagram,"","","'"+""+"'"+",false,"+"'"+""+"'",edtClinicaInstagram_Link,edtClinicaInstagram_Linktarget,"","",edtClinicaInstagram_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaInstagram_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtClinicaLinkedin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaLinkedin_Internalname,A351ClinicaLinkedin,"","","'"+""+"'"+",false,"+"'"+""+"'",edtClinicaLinkedin_Link,edtClinicaLinkedin_Linktarget,"","",edtClinicaLinkedin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaLinkedin_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbClinicaTiempoDeCita.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbClinicaTiempoDeCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CLINICATIEMPODECITA_" + sGXsfl_43_idx ;
            cmbClinicaTiempoDeCita.setName( GXCCtl );
            cmbClinicaTiempoDeCita.setWebtags( "" );
            cmbClinicaTiempoDeCita.addItem("30", "30 minutos", (short)(0));
            cmbClinicaTiempoDeCita.addItem("60", "1 hora", (short)(0));
            if ( cmbClinicaTiempoDeCita.getItemCount() > 0 )
            {
               A120ClinicaTiempoDeCita = (byte)(GXutil.lval( cmbClinicaTiempoDeCita.getValidValue(GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbClinicaTiempoDeCita,cmbClinicaTiempoDeCita.getInternalname(),GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)),Integer.valueOf(1),cmbClinicaTiempoDeCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbClinicaTiempoDeCita.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbClinicaTiempoDeCita.setValue( GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbClinicaTiempoDeCita.getInternalname(), "Values", cmbClinicaTiempoDeCita.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbClinicaEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbClinicaEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CLINICAESTADO_" + sGXsfl_43_idx ;
            cmbClinicaEstado.setName( GXCCtl );
            cmbClinicaEstado.setWebtags( "" );
            cmbClinicaEstado.addItem("A", "Activo", (short)(0));
            cmbClinicaEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbClinicaEstado.getItemCount() > 0 )
            {
               A121ClinicaEstado = cmbClinicaEstado.getValidValue(A121ClinicaEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbClinicaEstado,cmbClinicaEstado.getInternalname(),GXutil.rtrim( A121ClinicaEstado),Integer.valueOf(1),cmbClinicaEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbClinicaEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbClinicaEstado.setValue( GXutil.rtrim( A121ClinicaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbClinicaEstado.getInternalname(), "Values", cmbClinicaEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes1J2( ) ;
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
      edtClinicaId_Internalname = "CLINICAID" ;
      edtClinicaRUC_Internalname = "CLINICARUC" ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL" ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO" ;
      edtClinicaDireccionComercial_Internalname = "CLINICADIRECCIONCOMERCIAL" ;
      edtClinicaCorreo_Internalname = "CLINICACORREO" ;
      cmbClinicaMoneda.setInternalname( "CLINICAMONEDA" );
      edtClinicaLogo_Internalname = "CLINICALOGO" ;
      edtClinicaLogoHeader_Internalname = "CLINICALOGOHEADER" ;
      edtClinicaLogoFactura_Internalname = "CLINICALOGOFACTURA" ;
      edtClinicaLogoBoleta_Internalname = "CLINICALOGOBOLETA" ;
      edtClinicaLogoPago_Internalname = "CLINICALOGOPAGO" ;
      edtClinicaTelefono_Internalname = "CLINICATELEFONO" ;
      edtClinicaWhatsApp_Internalname = "CLINICAWHATSAPP" ;
      edtClinicaFacebook_Internalname = "CLINICAFACEBOOK" ;
      edtClinicaTwiter_Internalname = "CLINICATWITER" ;
      edtClinicaInstagram_Internalname = "CLINICAINSTAGRAM" ;
      edtClinicaLinkedin_Internalname = "CLINICALINKEDIN" ;
      cmbClinicaTiempoDeCita.setInternalname( "CLINICATIEMPODECITA" );
      cmbClinicaEstado.setInternalname( "CLINICAESTADO" );
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
      cmbClinicaEstado.setJsonclick( "" );
      cmbClinicaTiempoDeCita.setJsonclick( "" );
      edtClinicaLinkedin_Jsonclick = "" ;
      edtClinicaInstagram_Jsonclick = "" ;
      edtClinicaTwiter_Jsonclick = "" ;
      edtClinicaFacebook_Jsonclick = "" ;
      edtClinicaWhatsApp_Jsonclick = "" ;
      edtClinicaTelefono_Jsonclick = "" ;
      cmbClinicaMoneda.setJsonclick( "" );
      edtClinicaCorreo_Jsonclick = "" ;
      edtClinicaDireccionComercial_Jsonclick = "" ;
      edtClinicaNombreAbreviado_Jsonclick = "" ;
      edtClinicaNombreComercial_Jsonclick = "" ;
      edtClinicaRUC_Jsonclick = "" ;
      edtClinicaId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtClinicaLinkedin_Linktarget = "" ;
      edtClinicaLinkedin_Link = "" ;
      edtClinicaInstagram_Linktarget = "" ;
      edtClinicaInstagram_Link = "" ;
      edtClinicaTwiter_Linktarget = "" ;
      edtClinicaTwiter_Link = "" ;
      edtClinicaFacebook_Linktarget = "" ;
      edtClinicaFacebook_Link = "" ;
      edtClinicaRUC_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbClinicaEstado.setVisible( -1 );
      cmbClinicaTiempoDeCita.setVisible( -1 );
      edtClinicaLinkedin_Visible = -1 ;
      edtClinicaInstagram_Visible = -1 ;
      edtClinicaTwiter_Visible = -1 ;
      edtClinicaFacebook_Visible = -1 ;
      edtClinicaWhatsApp_Visible = -1 ;
      edtClinicaTelefono_Visible = -1 ;
      edtClinicaLogoPago_Visible = -1 ;
      edtClinicaLogoBoleta_Visible = -1 ;
      edtClinicaLogoFactura_Visible = -1 ;
      edtClinicaLogoHeader_Visible = -1 ;
      edtClinicaLogo_Visible = -1 ;
      cmbClinicaMoneda.setVisible( -1 );
      edtClinicaCorreo_Visible = -1 ;
      edtClinicaDireccionComercial_Visible = -1 ;
      edtClinicaNombreAbreviado_Visible = -1 ;
      edtClinicaNombreComercial_Visible = -1 ;
      edtClinicaRUC_Visible = -1 ;
      edtClinicaId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Clinica" );
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
      Ddo_grid_Datalistproc = "ClinicaWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||1:Soles,2:Dólares,3:Euros||||||||||||30:30 minutos,60:1 hora|A:Activo,I:Inactivo" ;
      Ddo_grid_Allowmultipleselection = "||||||T||||||||||||T|T" ;
      Ddo_grid_Datalisttype = "||Dynamic|Dynamic|Dynamic|Dynamic|FixedValues||||||Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|FixedValues" ;
      Ddo_grid_Includedatalist = "||T|T|T|T|T||||||T|T|T|T|T|T|T|T" ;
      Ddo_grid_Filterisrange = "T|T||||||||||||||||||" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Character|Character|Character|Character|||||||Character|Character|Character|Character|Character|Character||" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|||||||T|T|T|T|T|T||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T||||||T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5|6|7||||||8|9|10|11|12|13|14|15" ;
      Ddo_grid_Columnids = "2:ClinicaId|3:ClinicaRUC|4:ClinicaNombreComercial|5:ClinicaNombreAbreviado|6:ClinicaDireccionComercial|7:ClinicaCorreo|8:ClinicaMoneda|9:ClinicaLogo|10:ClinicaLogoHeader|11:ClinicaLogoFactura|12:ClinicaLogoBoleta|13:ClinicaLogoPago|14:ClinicaTelefono|15:ClinicaWhatsApp|16:ClinicaFacebook|17:ClinicaTwiter|18:ClinicaInstagram|19:ClinicaLinkedin|20:ClinicaTiempoDeCita|21:ClinicaEstado" ;
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
      GXCCtl = "CLINICAMONEDA_" + sGXsfl_43_idx ;
      cmbClinicaMoneda.setName( GXCCtl );
      cmbClinicaMoneda.setWebtags( "" );
      cmbClinicaMoneda.addItem("1", "Soles", (short)(0));
      cmbClinicaMoneda.addItem("2", "Dólares", (short)(0));
      cmbClinicaMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbClinicaMoneda.getItemCount() > 0 )
      {
         A341ClinicaMoneda = (short)(GXutil.lval( cmbClinicaMoneda.getValidValue(GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0))))) ;
      }
      GXCCtl = "CLINICATIEMPODECITA_" + sGXsfl_43_idx ;
      cmbClinicaTiempoDeCita.setName( GXCCtl );
      cmbClinicaTiempoDeCita.setWebtags( "" );
      cmbClinicaTiempoDeCita.addItem("30", "30 minutos", (short)(0));
      cmbClinicaTiempoDeCita.addItem("60", "1 hora", (short)(0));
      if ( cmbClinicaTiempoDeCita.getItemCount() > 0 )
      {
         A120ClinicaTiempoDeCita = (byte)(GXutil.lval( cmbClinicaTiempoDeCita.getValidValue(GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0))))) ;
      }
      GXCCtl = "CLINICAESTADO_" + sGXsfl_43_idx ;
      cmbClinicaEstado.setName( GXCCtl );
      cmbClinicaEstado.setWebtags( "" );
      cmbClinicaEstado.addItem("A", "Activo", (short)(0));
      cmbClinicaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbClinicaEstado.getItemCount() > 0 )
      {
         A121ClinicaEstado = cmbClinicaEstado.getValidValue(A121ClinicaEstado) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtClinicaId_Visible',ctrl:'CLINICAID',prop:'Visible'},{av:'edtClinicaRUC_Visible',ctrl:'CLINICARUC',prop:'Visible'},{av:'edtClinicaNombreComercial_Visible',ctrl:'CLINICANOMBRECOMERCIAL',prop:'Visible'},{av:'edtClinicaNombreAbreviado_Visible',ctrl:'CLINICANOMBREABREVIADO',prop:'Visible'},{av:'edtClinicaDireccionComercial_Visible',ctrl:'CLINICADIRECCIONCOMERCIAL',prop:'Visible'},{av:'edtClinicaCorreo_Visible',ctrl:'CLINICACORREO',prop:'Visible'},{av:'cmbClinicaMoneda'},{av:'edtClinicaLogo_Visible',ctrl:'CLINICALOGO',prop:'Visible'},{av:'edtClinicaLogoHeader_Visible',ctrl:'CLINICALOGOHEADER',prop:'Visible'},{av:'edtClinicaLogoFactura_Visible',ctrl:'CLINICALOGOFACTURA',prop:'Visible'},{av:'edtClinicaLogoBoleta_Visible',ctrl:'CLINICALOGOBOLETA',prop:'Visible'},{av:'edtClinicaLogoPago_Visible',ctrl:'CLINICALOGOPAGO',prop:'Visible'},{av:'edtClinicaTelefono_Visible',ctrl:'CLINICATELEFONO',prop:'Visible'},{av:'edtClinicaWhatsApp_Visible',ctrl:'CLINICAWHATSAPP',prop:'Visible'},{av:'edtClinicaFacebook_Visible',ctrl:'CLINICAFACEBOOK',prop:'Visible'},{av:'edtClinicaTwiter_Visible',ctrl:'CLINICATWITER',prop:'Visible'},{av:'edtClinicaInstagram_Visible',ctrl:'CLINICAINSTAGRAM',prop:'Visible'},{av:'edtClinicaLinkedin_Visible',ctrl:'CLINICALINKEDIN',prop:'Visible'},{av:'cmbClinicaTiempoDeCita'},{av:'cmbClinicaEstado'},{av:'AV59GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV60GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e211J2',iparms:[{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A348ClinicaFacebook',fld:'CLINICAFACEBOOK',pic:''},{av:'A349ClinicaTwiter',fld:'CLINICATWITER',pic:''},{av:'A350ClinicaInstagram',fld:'CLINICAINSTAGRAM',pic:''},{av:'A351ClinicaLinkedin',fld:'CLINICALINKEDIN',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV61Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV63Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtClinicaRUC_Link',ctrl:'CLINICARUC',prop:'Link'},{av:'edtClinicaFacebook_Linktarget',ctrl:'CLINICAFACEBOOK',prop:'Linktarget'},{av:'edtClinicaFacebook_Link',ctrl:'CLINICAFACEBOOK',prop:'Link'},{av:'edtClinicaTwiter_Linktarget',ctrl:'CLINICATWITER',prop:'Linktarget'},{av:'edtClinicaTwiter_Link',ctrl:'CLINICATWITER',prop:'Link'},{av:'edtClinicaInstagram_Linktarget',ctrl:'CLINICAINSTAGRAM',prop:'Linktarget'},{av:'edtClinicaInstagram_Link',ctrl:'CLINICAINSTAGRAM',prop:'Link'},{av:'edtClinicaLinkedin_Linktarget',ctrl:'CLINICALINKEDIN',prop:'Linktarget'},{av:'edtClinicaLinkedin_Link',ctrl:'CLINICALINKEDIN',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e151J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtClinicaId_Visible',ctrl:'CLINICAID',prop:'Visible'},{av:'edtClinicaRUC_Visible',ctrl:'CLINICARUC',prop:'Visible'},{av:'edtClinicaNombreComercial_Visible',ctrl:'CLINICANOMBRECOMERCIAL',prop:'Visible'},{av:'edtClinicaNombreAbreviado_Visible',ctrl:'CLINICANOMBREABREVIADO',prop:'Visible'},{av:'edtClinicaDireccionComercial_Visible',ctrl:'CLINICADIRECCIONCOMERCIAL',prop:'Visible'},{av:'edtClinicaCorreo_Visible',ctrl:'CLINICACORREO',prop:'Visible'},{av:'cmbClinicaMoneda'},{av:'edtClinicaLogo_Visible',ctrl:'CLINICALOGO',prop:'Visible'},{av:'edtClinicaLogoHeader_Visible',ctrl:'CLINICALOGOHEADER',prop:'Visible'},{av:'edtClinicaLogoFactura_Visible',ctrl:'CLINICALOGOFACTURA',prop:'Visible'},{av:'edtClinicaLogoBoleta_Visible',ctrl:'CLINICALOGOBOLETA',prop:'Visible'},{av:'edtClinicaLogoPago_Visible',ctrl:'CLINICALOGOPAGO',prop:'Visible'},{av:'edtClinicaTelefono_Visible',ctrl:'CLINICATELEFONO',prop:'Visible'},{av:'edtClinicaWhatsApp_Visible',ctrl:'CLINICAWHATSAPP',prop:'Visible'},{av:'edtClinicaFacebook_Visible',ctrl:'CLINICAFACEBOOK',prop:'Visible'},{av:'edtClinicaTwiter_Visible',ctrl:'CLINICATWITER',prop:'Visible'},{av:'edtClinicaInstagram_Visible',ctrl:'CLINICAINSTAGRAM',prop:'Visible'},{av:'edtClinicaLinkedin_Visible',ctrl:'CLINICALINKEDIN',prop:'Visible'},{av:'cmbClinicaTiempoDeCita'},{av:'cmbClinicaEstado'},{av:'AV59GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV60GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtClinicaId_Visible',ctrl:'CLINICAID',prop:'Visible'},{av:'edtClinicaRUC_Visible',ctrl:'CLINICARUC',prop:'Visible'},{av:'edtClinicaNombreComercial_Visible',ctrl:'CLINICANOMBRECOMERCIAL',prop:'Visible'},{av:'edtClinicaNombreAbreviado_Visible',ctrl:'CLINICANOMBREABREVIADO',prop:'Visible'},{av:'edtClinicaDireccionComercial_Visible',ctrl:'CLINICADIRECCIONCOMERCIAL',prop:'Visible'},{av:'edtClinicaCorreo_Visible',ctrl:'CLINICACORREO',prop:'Visible'},{av:'cmbClinicaMoneda'},{av:'edtClinicaLogo_Visible',ctrl:'CLINICALOGO',prop:'Visible'},{av:'edtClinicaLogoHeader_Visible',ctrl:'CLINICALOGOHEADER',prop:'Visible'},{av:'edtClinicaLogoFactura_Visible',ctrl:'CLINICALOGOFACTURA',prop:'Visible'},{av:'edtClinicaLogoBoleta_Visible',ctrl:'CLINICALOGOBOLETA',prop:'Visible'},{av:'edtClinicaLogoPago_Visible',ctrl:'CLINICALOGOPAGO',prop:'Visible'},{av:'edtClinicaTelefono_Visible',ctrl:'CLINICATELEFONO',prop:'Visible'},{av:'edtClinicaWhatsApp_Visible',ctrl:'CLINICAWHATSAPP',prop:'Visible'},{av:'edtClinicaFacebook_Visible',ctrl:'CLINICAFACEBOOK',prop:'Visible'},{av:'edtClinicaTwiter_Visible',ctrl:'CLINICATWITER',prop:'Visible'},{av:'edtClinicaInstagram_Visible',ctrl:'CLINICAINSTAGRAM',prop:'Visible'},{av:'edtClinicaLinkedin_Visible',ctrl:'CLINICALINKEDIN',prop:'Visible'},{av:'cmbClinicaTiempoDeCita'},{av:'cmbClinicaEstado'},{av:'AV59GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV60GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e161J2',iparms:[{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e171J2',iparms:[{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e181J2',iparms:[{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV28TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV30TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV32TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaNombreAbreviado',fld:'vTFCLINICANOMBREABREVIADO',pic:''},{av:'AV34TFClinicaNombreAbreviado_Sel',fld:'vTFCLINICANOMBREABREVIADO_SEL',pic:''},{av:'AV35TFClinicaDireccionComercial',fld:'vTFCLINICADIRECCIONCOMERCIAL',pic:''},{av:'AV36TFClinicaDireccionComercial_Sel',fld:'vTFCLINICADIRECCIONCOMERCIAL_SEL',pic:''},{av:'AV37TFClinicaCorreo',fld:'vTFCLINICACORREO',pic:''},{av:'AV38TFClinicaCorreo_Sel',fld:'vTFCLINICACORREO_SEL',pic:''},{av:'AV40TFClinicaMoneda_Sels',fld:'vTFCLINICAMONEDA_SELS',pic:''},{av:'AV41TFClinicaTelefono',fld:'vTFCLINICATELEFONO',pic:''},{av:'AV42TFClinicaTelefono_Sel',fld:'vTFCLINICATELEFONO_SEL',pic:''},{av:'AV43TFClinicaWhatsApp',fld:'vTFCLINICAWHATSAPP',pic:''},{av:'AV44TFClinicaWhatsApp_Sel',fld:'vTFCLINICAWHATSAPP_SEL',pic:''},{av:'AV45TFClinicaFacebook',fld:'vTFCLINICAFACEBOOK',pic:''},{av:'AV46TFClinicaFacebook_Sel',fld:'vTFCLINICAFACEBOOK_SEL',pic:''},{av:'AV47TFClinicaTwiter',fld:'vTFCLINICATWITER',pic:''},{av:'AV48TFClinicaTwiter_Sel',fld:'vTFCLINICATWITER_SEL',pic:''},{av:'AV49TFClinicaInstagram',fld:'vTFCLINICAINSTAGRAM',pic:''},{av:'AV50TFClinicaInstagram_Sel',fld:'vTFCLINICAINSTAGRAM_SEL',pic:''},{av:'AV51TFClinicaLinkedin',fld:'vTFCLINICALINKEDIN',pic:''},{av:'AV52TFClinicaLinkedin_Sel',fld:'vTFCLINICALINKEDIN_SEL',pic:''},{av:'AV54TFClinicaTiempoDeCita_Sels',fld:'vTFCLINICATIEMPODECITA_SELS',pic:''},{av:'AV56TFClinicaEstado_Sels',fld:'vTFCLINICAESTADO_SELS',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV62IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV64IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV55TFClinicaEstado_SelsJson',fld:'vTFCLINICAESTADO_SELSJSON',pic:''},{av:'AV53TFClinicaTiempoDeCita_SelsJson',fld:'vTFCLINICATIEMPODECITA_SELSJSON',pic:''},{av:'AV39TFClinicaMoneda_SelsJson',fld:'vTFCLINICAMONEDA_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("NULL","{handler:'valid_Clinicaestado',iparms:[]");
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
      AV31TFClinicaNombreComercial = "" ;
      AV32TFClinicaNombreComercial_Sel = "" ;
      AV33TFClinicaNombreAbreviado = "" ;
      AV34TFClinicaNombreAbreviado_Sel = "" ;
      AV35TFClinicaDireccionComercial = "" ;
      AV36TFClinicaDireccionComercial_Sel = "" ;
      AV37TFClinicaCorreo = "" ;
      AV38TFClinicaCorreo_Sel = "" ;
      AV40TFClinicaMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV41TFClinicaTelefono = "" ;
      AV42TFClinicaTelefono_Sel = "" ;
      AV43TFClinicaWhatsApp = "" ;
      AV44TFClinicaWhatsApp_Sel = "" ;
      AV45TFClinicaFacebook = "" ;
      AV46TFClinicaFacebook_Sel = "" ;
      AV47TFClinicaTwiter = "" ;
      AV48TFClinicaTwiter_Sel = "" ;
      AV49TFClinicaInstagram = "" ;
      AV50TFClinicaInstagram_Sel = "" ;
      AV51TFClinicaLinkedin = "" ;
      AV52TFClinicaLinkedin_Sel = "" ;
      AV54TFClinicaTiempoDeCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV56TFClinicaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Pgmname = "" ;
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
      AV57DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV39TFClinicaMoneda_SelsJson = "" ;
      AV53TFClinicaTiempoDeCita_SelsJson = "" ;
      AV55TFClinicaEstado_SelsJson = "" ;
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
      AV61Update = "" ;
      AV63Delete = "" ;
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A117ClinicaLogo = "" ;
      A342ClinicaLogoHeader = "" ;
      A343ClinicaLogoFactura = "" ;
      A344ClinicaLogoBoleta = "" ;
      A345ClinicaLogoPago = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      A121ClinicaEstado = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A40000ClinicaLogo_GXI = "" ;
      A40001ClinicaLogoHeader_GXI = "" ;
      A40002ClinicaLogoFactura_GXI = "" ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      A40004ClinicaLogoPago_GXI = "" ;
      AV81Clinicawwds_14_tfclinicamoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV94Clinicawwds_27_tfclinicatiempodecita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV95Clinicawwds_28_tfclinicaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV68Clinicawwds_1_filterfulltext = "" ;
      lV73Clinicawwds_6_tfclinicanombrecomercial = "" ;
      lV75Clinicawwds_8_tfclinicanombreabreviado = "" ;
      lV77Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      lV79Clinicawwds_12_tfclinicacorreo = "" ;
      lV82Clinicawwds_15_tfclinicatelefono = "" ;
      lV84Clinicawwds_17_tfclinicawhatsapp = "" ;
      lV86Clinicawwds_19_tfclinicafacebook = "" ;
      lV88Clinicawwds_21_tfclinicatwiter = "" ;
      lV90Clinicawwds_23_tfclinicainstagram = "" ;
      lV92Clinicawwds_25_tfclinicalinkedin = "" ;
      AV68Clinicawwds_1_filterfulltext = "" ;
      AV74Clinicawwds_7_tfclinicanombrecomercial_sel = "" ;
      AV73Clinicawwds_6_tfclinicanombrecomercial = "" ;
      AV76Clinicawwds_9_tfclinicanombreabreviado_sel = "" ;
      AV75Clinicawwds_8_tfclinicanombreabreviado = "" ;
      AV78Clinicawwds_11_tfclinicadireccioncomercial_sel = "" ;
      AV77Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      AV80Clinicawwds_13_tfclinicacorreo_sel = "" ;
      AV79Clinicawwds_12_tfclinicacorreo = "" ;
      AV83Clinicawwds_16_tfclinicatelefono_sel = "" ;
      AV82Clinicawwds_15_tfclinicatelefono = "" ;
      AV85Clinicawwds_18_tfclinicawhatsapp_sel = "" ;
      AV84Clinicawwds_17_tfclinicawhatsapp = "" ;
      AV87Clinicawwds_20_tfclinicafacebook_sel = "" ;
      AV86Clinicawwds_19_tfclinicafacebook = "" ;
      AV89Clinicawwds_22_tfclinicatwiter_sel = "" ;
      AV88Clinicawwds_21_tfclinicatwiter = "" ;
      AV91Clinicawwds_24_tfclinicainstagram_sel = "" ;
      AV90Clinicawwds_23_tfclinicainstagram = "" ;
      AV93Clinicawwds_26_tfclinicalinkedin_sel = "" ;
      AV92Clinicawwds_25_tfclinicalinkedin = "" ;
      H001J2_A121ClinicaEstado = new String[] {""} ;
      H001J2_A120ClinicaTiempoDeCita = new byte[1] ;
      H001J2_A351ClinicaLinkedin = new String[] {""} ;
      H001J2_A350ClinicaInstagram = new String[] {""} ;
      H001J2_A349ClinicaTwiter = new String[] {""} ;
      H001J2_A348ClinicaFacebook = new String[] {""} ;
      H001J2_A347ClinicaWhatsApp = new String[] {""} ;
      H001J2_A346ClinicaTelefono = new String[] {""} ;
      H001J2_A345ClinicaLogoPago = new String[] {""} ;
      H001J2_n345ClinicaLogoPago = new boolean[] {false} ;
      H001J2_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      H001J2_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      H001J2_A344ClinicaLogoBoleta = new String[] {""} ;
      H001J2_n344ClinicaLogoBoleta = new boolean[] {false} ;
      H001J2_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      H001J2_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      H001J2_A343ClinicaLogoFactura = new String[] {""} ;
      H001J2_n343ClinicaLogoFactura = new boolean[] {false} ;
      H001J2_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      H001J2_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      H001J2_A342ClinicaLogoHeader = new String[] {""} ;
      H001J2_n342ClinicaLogoHeader = new boolean[] {false} ;
      H001J2_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      H001J2_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      H001J2_A117ClinicaLogo = new String[] {""} ;
      H001J2_A40000ClinicaLogo_GXI = new String[] {""} ;
      H001J2_A341ClinicaMoneda = new short[1] ;
      H001J2_A340ClinicaCorreo = new String[] {""} ;
      H001J2_A119ClinicaDireccionComercial = new String[] {""} ;
      H001J2_A80ClinicaNombreAbreviado = new String[] {""} ;
      H001J2_A116ClinicaNombreComercial = new String[] {""} ;
      H001J2_A118ClinicaRUC = new long[1] ;
      H001J2_A28ClinicaId = new short[1] ;
      H001J3_AGRID_nRecordCount = new long[1] ;
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
      GXt_char13 = "" ;
      GXv_char6 = new String[1] ;
      GXv_SdtWWPGridState32 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      sImgUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinicaww__default(),
         new Object[] {
             new Object[] {
            H001J2_A121ClinicaEstado, H001J2_A120ClinicaTiempoDeCita, H001J2_A351ClinicaLinkedin, H001J2_A350ClinicaInstagram, H001J2_A349ClinicaTwiter, H001J2_A348ClinicaFacebook, H001J2_A347ClinicaWhatsApp, H001J2_A346ClinicaTelefono, H001J2_A345ClinicaLogoPago, H001J2_n345ClinicaLogoPago,
            H001J2_A40004ClinicaLogoPago_GXI, H001J2_n40004ClinicaLogoPago_GXI, H001J2_A344ClinicaLogoBoleta, H001J2_n344ClinicaLogoBoleta, H001J2_A40003ClinicaLogoBoleta_GXI, H001J2_n40003ClinicaLogoBoleta_GXI, H001J2_A343ClinicaLogoFactura, H001J2_n343ClinicaLogoFactura, H001J2_A40002ClinicaLogoFactura_GXI, H001J2_n40002ClinicaLogoFactura_GXI,
            H001J2_A342ClinicaLogoHeader, H001J2_n342ClinicaLogoHeader, H001J2_A40001ClinicaLogoHeader_GXI, H001J2_n40001ClinicaLogoHeader_GXI, H001J2_A117ClinicaLogo, H001J2_A40000ClinicaLogo_GXI, H001J2_A341ClinicaMoneda, H001J2_A340ClinicaCorreo, H001J2_A119ClinicaDireccionComercial, H001J2_A80ClinicaNombreAbreviado,
            H001J2_A116ClinicaNombreComercial, H001J2_A118ClinicaRUC, H001J2_A28ClinicaId
            }
            , new Object[] {
            H001J3_AGRID_nRecordCount
            }
         }
      );
      AV96Pgmname = "ClinicaWW" ;
      /* GeneXus formulas. */
      AV96Pgmname = "ClinicaWW" ;
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
   private byte A120ClinicaTiempoDeCita ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV27TFClinicaId ;
   private short AV28TFClinicaId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A28ClinicaId ;
   private short A341ClinicaMoneda ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV69Clinicawwds_2_tfclinicaid ;
   private short AV70Clinicawwds_3_tfclinicaid_to ;
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
   private int edtClinicaId_Visible ;
   private int edtClinicaRUC_Visible ;
   private int edtClinicaNombreComercial_Visible ;
   private int edtClinicaNombreAbreviado_Visible ;
   private int edtClinicaDireccionComercial_Visible ;
   private int edtClinicaCorreo_Visible ;
   private int edtClinicaLogo_Visible ;
   private int edtClinicaLogoHeader_Visible ;
   private int edtClinicaLogoFactura_Visible ;
   private int edtClinicaLogoBoleta_Visible ;
   private int edtClinicaLogoPago_Visible ;
   private int edtClinicaTelefono_Visible ;
   private int edtClinicaWhatsApp_Visible ;
   private int edtClinicaFacebook_Visible ;
   private int edtClinicaTwiter_Visible ;
   private int edtClinicaInstagram_Visible ;
   private int edtClinicaLinkedin_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV81Clinicawwds_14_tfclinicamoneda_sels_size ;
   private int AV94Clinicawwds_27_tfclinicatiempodecita_sels_size ;
   private int AV95Clinicawwds_28_tfclinicaestado_sels_size ;
   private int AV58PageToGo ;
   private int AV97GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV29TFClinicaRUC ;
   private long AV30TFClinicaRUC_To ;
   private long AV59GridCurrentPage ;
   private long AV60GridPageCount ;
   private long A118ClinicaRUC ;
   private long GRID_nCurrentRecord ;
   private long AV71Clinicawwds_4_tfclinicaruc ;
   private long AV72Clinicawwds_5_tfclinicaruc_to ;
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
   private String AV41TFClinicaTelefono ;
   private String AV42TFClinicaTelefono_Sel ;
   private String AV43TFClinicaWhatsApp ;
   private String AV44TFClinicaWhatsApp_Sel ;
   private String AV96Pgmname ;
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
   private String AV61Update ;
   private String edtavUpdate_Link ;
   private String AV63Delete ;
   private String edtavDelete_Link ;
   private String edtClinicaRUC_Link ;
   private String A346ClinicaTelefono ;
   private String A347ClinicaWhatsApp ;
   private String edtClinicaFacebook_Link ;
   private String edtClinicaFacebook_Linktarget ;
   private String edtClinicaTwiter_Link ;
   private String edtClinicaTwiter_Linktarget ;
   private String edtClinicaInstagram_Link ;
   private String edtClinicaInstagram_Linktarget ;
   private String edtClinicaLinkedin_Link ;
   private String edtClinicaLinkedin_Linktarget ;
   private String A121ClinicaEstado ;
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
   private String edtClinicaId_Internalname ;
   private String edtClinicaRUC_Internalname ;
   private String edtClinicaNombreComercial_Internalname ;
   private String edtClinicaNombreAbreviado_Internalname ;
   private String edtClinicaDireccionComercial_Internalname ;
   private String edtClinicaCorreo_Internalname ;
   private String edtClinicaLogo_Internalname ;
   private String edtClinicaLogoHeader_Internalname ;
   private String edtClinicaLogoFactura_Internalname ;
   private String edtClinicaLogoBoleta_Internalname ;
   private String edtClinicaLogoPago_Internalname ;
   private String edtClinicaTelefono_Internalname ;
   private String edtClinicaWhatsApp_Internalname ;
   private String edtClinicaFacebook_Internalname ;
   private String edtClinicaTwiter_Internalname ;
   private String edtClinicaInstagram_Internalname ;
   private String edtClinicaLinkedin_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String lV82Clinicawwds_15_tfclinicatelefono ;
   private String lV84Clinicawwds_17_tfclinicawhatsapp ;
   private String AV83Clinicawwds_16_tfclinicatelefono_sel ;
   private String AV82Clinicawwds_15_tfclinicatelefono ;
   private String AV85Clinicawwds_18_tfclinicawhatsapp_sel ;
   private String AV84Clinicawwds_17_tfclinicawhatsapp ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
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
   private String edtClinicaId_Jsonclick ;
   private String edtClinicaRUC_Jsonclick ;
   private String edtClinicaNombreComercial_Jsonclick ;
   private String edtClinicaNombreAbreviado_Jsonclick ;
   private String edtClinicaDireccionComercial_Jsonclick ;
   private String edtClinicaCorreo_Jsonclick ;
   private String GXCCtl ;
   private String sImgUrl ;
   private String edtClinicaTelefono_Jsonclick ;
   private String edtClinicaWhatsApp_Jsonclick ;
   private String edtClinicaFacebook_Jsonclick ;
   private String edtClinicaTwiter_Jsonclick ;
   private String edtClinicaInstagram_Jsonclick ;
   private String edtClinicaLinkedin_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV62IsAuthorized_Update ;
   private boolean AV64IsAuthorized_Delete ;
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
   private boolean n342ClinicaLogoHeader ;
   private boolean n343ClinicaLogoFactura ;
   private boolean n344ClinicaLogoBoleta ;
   private boolean n345ClinicaLogoPago ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40004ClinicaLogoPago_GXI ;
   private boolean n40003ClinicaLogoBoleta_GXI ;
   private boolean n40002ClinicaLogoFactura_GXI ;
   private boolean n40001ClinicaLogoHeader_GXI ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV65TempBoolean ;
   private boolean GXt_boolean9 ;
   private boolean GXv_boolean10[] ;
   private boolean A117ClinicaLogo_IsBlob ;
   private boolean A342ClinicaLogoHeader_IsBlob ;
   private boolean A343ClinicaLogoFactura_IsBlob ;
   private boolean A344ClinicaLogoBoleta_IsBlob ;
   private boolean A345ClinicaLogoPago_IsBlob ;
   private String AV39TFClinicaMoneda_SelsJson ;
   private String AV53TFClinicaTiempoDeCita_SelsJson ;
   private String AV55TFClinicaEstado_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV31TFClinicaNombreComercial ;
   private String AV32TFClinicaNombreComercial_Sel ;
   private String AV33TFClinicaNombreAbreviado ;
   private String AV34TFClinicaNombreAbreviado_Sel ;
   private String AV35TFClinicaDireccionComercial ;
   private String AV36TFClinicaDireccionComercial_Sel ;
   private String AV37TFClinicaCorreo ;
   private String AV38TFClinicaCorreo_Sel ;
   private String AV45TFClinicaFacebook ;
   private String AV46TFClinicaFacebook_Sel ;
   private String AV47TFClinicaTwiter ;
   private String AV48TFClinicaTwiter_Sel ;
   private String AV49TFClinicaInstagram ;
   private String AV50TFClinicaInstagram_Sel ;
   private String AV51TFClinicaLinkedin ;
   private String AV52TFClinicaLinkedin_Sel ;
   private String A116ClinicaNombreComercial ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String A40000ClinicaLogo_GXI ;
   private String A40001ClinicaLogoHeader_GXI ;
   private String A40002ClinicaLogoFactura_GXI ;
   private String A40003ClinicaLogoBoleta_GXI ;
   private String A40004ClinicaLogoPago_GXI ;
   private String lV68Clinicawwds_1_filterfulltext ;
   private String lV73Clinicawwds_6_tfclinicanombrecomercial ;
   private String lV75Clinicawwds_8_tfclinicanombreabreviado ;
   private String lV77Clinicawwds_10_tfclinicadireccioncomercial ;
   private String lV79Clinicawwds_12_tfclinicacorreo ;
   private String lV86Clinicawwds_19_tfclinicafacebook ;
   private String lV88Clinicawwds_21_tfclinicatwiter ;
   private String lV90Clinicawwds_23_tfclinicainstagram ;
   private String lV92Clinicawwds_25_tfclinicalinkedin ;
   private String AV68Clinicawwds_1_filterfulltext ;
   private String AV74Clinicawwds_7_tfclinicanombrecomercial_sel ;
   private String AV73Clinicawwds_6_tfclinicanombrecomercial ;
   private String AV76Clinicawwds_9_tfclinicanombreabreviado_sel ;
   private String AV75Clinicawwds_8_tfclinicanombreabreviado ;
   private String AV78Clinicawwds_11_tfclinicadireccioncomercial_sel ;
   private String AV77Clinicawwds_10_tfclinicadireccioncomercial ;
   private String AV80Clinicawwds_13_tfclinicacorreo_sel ;
   private String AV79Clinicawwds_12_tfclinicacorreo ;
   private String AV87Clinicawwds_20_tfclinicafacebook_sel ;
   private String AV86Clinicawwds_19_tfclinicafacebook ;
   private String AV89Clinicawwds_22_tfclinicatwiter_sel ;
   private String AV88Clinicawwds_21_tfclinicatwiter ;
   private String AV91Clinicawwds_24_tfclinicainstagram_sel ;
   private String AV90Clinicawwds_23_tfclinicainstagram ;
   private String AV93Clinicawwds_26_tfclinicalinkedin_sel ;
   private String AV92Clinicawwds_25_tfclinicalinkedin ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String A117ClinicaLogo ;
   private String A342ClinicaLogoHeader ;
   private String A343ClinicaLogoFactura ;
   private String A344ClinicaLogoBoleta ;
   private String A345ClinicaLogoPago ;
   private GXSimpleCollection<Byte> AV94Clinicawwds_27_tfclinicatiempodecita_sels ;
   private GXSimpleCollection<Short> AV81Clinicawwds_14_tfclinicamoneda_sels ;
   private GXSimpleCollection<Byte> AV54TFClinicaTiempoDeCita_Sels ;
   private GXSimpleCollection<Short> AV40TFClinicaMoneda_Sels ;
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
   private GXSimpleCollection<String> AV95Clinicawwds_28_tfclinicaestado_sels ;
   private HTMLChoice cmbClinicaMoneda ;
   private HTMLChoice cmbClinicaTiempoDeCita ;
   private HTMLChoice cmbClinicaEstado ;
   private IDataStoreProvider pr_default ;
   private String[] H001J2_A121ClinicaEstado ;
   private byte[] H001J2_A120ClinicaTiempoDeCita ;
   private String[] H001J2_A351ClinicaLinkedin ;
   private String[] H001J2_A350ClinicaInstagram ;
   private String[] H001J2_A349ClinicaTwiter ;
   private String[] H001J2_A348ClinicaFacebook ;
   private String[] H001J2_A347ClinicaWhatsApp ;
   private String[] H001J2_A346ClinicaTelefono ;
   private String[] H001J2_A345ClinicaLogoPago ;
   private boolean[] H001J2_n345ClinicaLogoPago ;
   private String[] H001J2_A40004ClinicaLogoPago_GXI ;
   private boolean[] H001J2_n40004ClinicaLogoPago_GXI ;
   private String[] H001J2_A344ClinicaLogoBoleta ;
   private boolean[] H001J2_n344ClinicaLogoBoleta ;
   private String[] H001J2_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] H001J2_n40003ClinicaLogoBoleta_GXI ;
   private String[] H001J2_A343ClinicaLogoFactura ;
   private boolean[] H001J2_n343ClinicaLogoFactura ;
   private String[] H001J2_A40002ClinicaLogoFactura_GXI ;
   private boolean[] H001J2_n40002ClinicaLogoFactura_GXI ;
   private String[] H001J2_A342ClinicaLogoHeader ;
   private boolean[] H001J2_n342ClinicaLogoHeader ;
   private String[] H001J2_A40001ClinicaLogoHeader_GXI ;
   private boolean[] H001J2_n40001ClinicaLogoHeader_GXI ;
   private String[] H001J2_A117ClinicaLogo ;
   private String[] H001J2_A40000ClinicaLogo_GXI ;
   private short[] H001J2_A341ClinicaMoneda ;
   private String[] H001J2_A340ClinicaCorreo ;
   private String[] H001J2_A119ClinicaDireccionComercial ;
   private String[] H001J2_A80ClinicaNombreAbreviado ;
   private String[] H001J2_A116ClinicaNombreComercial ;
   private long[] H001J2_A118ClinicaRUC ;
   private short[] H001J2_A28ClinicaId ;
   private long[] H001J3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV56TFClinicaEstado_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState32[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector7[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV57DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class clinicaww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001J2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV81Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV94Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV95Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV68Clinicawwds_1_filterfulltext ,
                                          short AV69Clinicawwds_2_tfclinicaid ,
                                          short AV70Clinicawwds_3_tfclinicaid_to ,
                                          long AV71Clinicawwds_4_tfclinicaruc ,
                                          long AV72Clinicawwds_5_tfclinicaruc_to ,
                                          String AV74Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV73Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV76Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV75Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV78Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV77Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV80Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV79Clinicawwds_12_tfclinicacorreo ,
                                          int AV81Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV83Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV82Clinicawwds_15_tfclinicatelefono ,
                                          String AV85Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV84Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV87Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV86Clinicawwds_19_tfclinicafacebook ,
                                          String AV89Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV88Clinicawwds_21_tfclinicatwiter ,
                                          String AV91Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV90Clinicawwds_23_tfclinicainstagram ,
                                          String AV93Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV92Clinicawwds_25_tfclinicalinkedin ,
                                          int AV94Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV95Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int33 = new byte[46];
      Object[] GXv_Object34 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook], [ClinicaWhatsApp], [ClinicaTelefono], [ClinicaLogoPago]," ;
      sSelectString += " [ClinicaLogoPago_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI]," ;
      sSelectString += " [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial], [ClinicaRUC]," ;
      sSelectString += " [ClinicaId]" ;
      sFromString = " FROM [Clinica]" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV68Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int33[0] = (byte)(1) ;
         GXv_int33[1] = (byte)(1) ;
         GXv_int33[2] = (byte)(1) ;
         GXv_int33[3] = (byte)(1) ;
         GXv_int33[4] = (byte)(1) ;
         GXv_int33[5] = (byte)(1) ;
         GXv_int33[6] = (byte)(1) ;
         GXv_int33[7] = (byte)(1) ;
         GXv_int33[8] = (byte)(1) ;
         GXv_int33[9] = (byte)(1) ;
         GXv_int33[10] = (byte)(1) ;
         GXv_int33[11] = (byte)(1) ;
         GXv_int33[12] = (byte)(1) ;
         GXv_int33[13] = (byte)(1) ;
         GXv_int33[14] = (byte)(1) ;
         GXv_int33[15] = (byte)(1) ;
         GXv_int33[16] = (byte)(1) ;
         GXv_int33[17] = (byte)(1) ;
         GXv_int33[18] = (byte)(1) ;
      }
      if ( ! (0==AV69Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int33[19] = (byte)(1) ;
      }
      if ( ! (0==AV70Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int33[20] = (byte)(1) ;
      }
      if ( ! (0==AV71Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int33[21] = (byte)(1) ;
      }
      if ( ! (0==AV72Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int33[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int33[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int33[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int33[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int33[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV78Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV77Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int33[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV78Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int33[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV79Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int33[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int33[30] = (byte)(1) ;
      }
      if ( AV81Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV81Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int33[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int33[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int33[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int33[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int33[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int33[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int33[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int33[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV91Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV90Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int33[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV91Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int33[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV93Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV92Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int33[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV93Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int33[42] = (byte)(1) ;
      }
      if ( AV94Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV94Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV95Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaRUC]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaRUC] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaNombreComercial]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaNombreComercial] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaDireccionComercial]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaDireccionComercial] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaCorreo]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaCorreo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaMoneda]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaMoneda] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaTelefono]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaTelefono] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaWhatsApp]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaWhatsApp] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaFacebook]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaFacebook] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaTwiter]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaTwiter] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaInstagram]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaInstagram] DESC" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaLinkedin]" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaLinkedin] DESC" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaTiempoDeCita]" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaTiempoDeCita] DESC" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY [ClinicaEstado]" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY [ClinicaEstado] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY [ClinicaId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object34[0] = scmdbuf ;
      GXv_Object34[1] = GXv_int33 ;
      return GXv_Object34 ;
   }

   protected Object[] conditional_H001J3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV81Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV94Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV95Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV68Clinicawwds_1_filterfulltext ,
                                          short AV69Clinicawwds_2_tfclinicaid ,
                                          short AV70Clinicawwds_3_tfclinicaid_to ,
                                          long AV71Clinicawwds_4_tfclinicaruc ,
                                          long AV72Clinicawwds_5_tfclinicaruc_to ,
                                          String AV74Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV73Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV76Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV75Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV78Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV77Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV80Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV79Clinicawwds_12_tfclinicacorreo ,
                                          int AV81Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV83Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV82Clinicawwds_15_tfclinicatelefono ,
                                          String AV85Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV84Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV87Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV86Clinicawwds_19_tfclinicafacebook ,
                                          String AV89Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV88Clinicawwds_21_tfclinicatwiter ,
                                          String AV91Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV90Clinicawwds_23_tfclinicainstagram ,
                                          String AV93Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV92Clinicawwds_25_tfclinicalinkedin ,
                                          int AV94Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV95Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int36 = new byte[43];
      Object[] GXv_Object37 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV68Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
      }
      else
      {
         GXv_int36[0] = (byte)(1) ;
         GXv_int36[1] = (byte)(1) ;
         GXv_int36[2] = (byte)(1) ;
         GXv_int36[3] = (byte)(1) ;
         GXv_int36[4] = (byte)(1) ;
         GXv_int36[5] = (byte)(1) ;
         GXv_int36[6] = (byte)(1) ;
         GXv_int36[7] = (byte)(1) ;
         GXv_int36[8] = (byte)(1) ;
         GXv_int36[9] = (byte)(1) ;
         GXv_int36[10] = (byte)(1) ;
         GXv_int36[11] = (byte)(1) ;
         GXv_int36[12] = (byte)(1) ;
         GXv_int36[13] = (byte)(1) ;
         GXv_int36[14] = (byte)(1) ;
         GXv_int36[15] = (byte)(1) ;
         GXv_int36[16] = (byte)(1) ;
         GXv_int36[17] = (byte)(1) ;
         GXv_int36[18] = (byte)(1) ;
      }
      if ( ! (0==AV69Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int36[19] = (byte)(1) ;
      }
      if ( ! (0==AV70Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int36[20] = (byte)(1) ;
      }
      if ( ! (0==AV71Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int36[21] = (byte)(1) ;
      }
      if ( ! (0==AV72Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int36[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV73Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int36[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int36[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV75Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int36[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int36[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV78Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV77Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int36[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV78Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int36[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV79Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int36[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int36[30] = (byte)(1) ;
      }
      if ( AV81Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV81Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int36[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int36[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int36[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int36[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int36[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int36[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int36[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int36[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV91Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV90Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int36[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV91Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int36[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV93Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV92Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int36[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV93Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int36[42] = (byte)(1) ;
      }
      if ( AV94Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV94Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV95Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object37[0] = scmdbuf ;
      GXv_Object37[1] = GXv_int36 ;
      return GXv_Object37 ;
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
                  return conditional_H001J2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).shortValue() , ((Boolean) dynConstraints[47]).booleanValue() );
            case 1 :
                  return conditional_H001J3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).shortValue() , ((Boolean) dynConstraints[47]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001J2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001J3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 15);
               ((String[]) buf[7])[0] = rslt.getString(8, 12);
               ((String[]) buf[8])[0] = rslt.getMultimediaFile(9, rslt.getVarchar(10));
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getMultimediaUri(10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getMultimediaFile(11, rslt.getVarchar(12));
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getMultimediaUri(12);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getMultimediaFile(13, rslt.getVarchar(14));
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getMultimediaUri(14);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getMultimediaFile(15, rslt.getVarchar(16));
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getMultimediaUri(16);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getMultimediaFile(17, rslt.getVarchar(18));
               ((String[]) buf[25])[0] = rslt.getMultimediaUri(18);
               ((short[]) buf[26])[0] = rslt.getShort(19);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((long[]) buf[31])[0] = rslt.getLong(24);
               ((short[]) buf[32])[0] = rslt.getShort(25);
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
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[65]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[66]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[67]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[68]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[78], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[79], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[80], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 1000);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[89]).intValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[90]).intValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[91]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
      }
   }

}

