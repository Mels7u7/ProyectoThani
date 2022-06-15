package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sedeww_impl extends GXDataArea
{
   public sedeww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sedeww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sedeww_impl.class ));
   }

   public sedeww_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSedeEstado = new HTMLChoice();
      cmbSedeTipo = new HTMLChoice();
      cmbSedeSector = new HTMLChoice();
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
            AV27TFSedeId = (short)(GXutil.lval( httpContext.GetPar( "TFSedeId"))) ;
            AV28TFSedeId_To = (short)(GXutil.lval( httpContext.GetPar( "TFSedeId_To"))) ;
            AV29TFSedeNombre = httpContext.GetPar( "TFSedeNombre") ;
            AV30TFSedeNombre_Sel = httpContext.GetPar( "TFSedeNombre_Sel") ;
            AV31TFClinicaId = (short)(GXutil.lval( httpContext.GetPar( "TFClinicaId"))) ;
            AV32TFClinicaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFClinicaId_To"))) ;
            AV33TFClinicaRUC = GXutil.lval( httpContext.GetPar( "TFClinicaRUC")) ;
            AV34TFClinicaRUC_To = GXutil.lval( httpContext.GetPar( "TFClinicaRUC_To")) ;
            AV35TFClinicaNombreComercial = httpContext.GetPar( "TFClinicaNombreComercial") ;
            AV36TFClinicaNombreComercial_Sel = httpContext.GetPar( "TFClinicaNombreComercial_Sel") ;
            AV37TFUbigeoCode = httpContext.GetPar( "TFUbigeoCode") ;
            AV38TFUbigeoCode_Sel = httpContext.GetPar( "TFUbigeoCode_Sel") ;
            AV39TFUbigeoNombre = httpContext.GetPar( "TFUbigeoNombre") ;
            AV40TFUbigeoNombre_Sel = httpContext.GetPar( "TFUbigeoNombre_Sel") ;
            AV41TFSedeDireccion = httpContext.GetPar( "TFSedeDireccion") ;
            AV42TFSedeDireccion_Sel = httpContext.GetPar( "TFSedeDireccion_Sel") ;
            AV43TFSedeCorreo = httpContext.GetPar( "TFSedeCorreo") ;
            AV44TFSedeCorreo_Sel = httpContext.GetPar( "TFSedeCorreo_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV46TFSedeEstado_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV48TFSedeTipo_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV50TFSedeSector_Sels);
            AV87Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV56IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV57IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV58IsAuthorized_ClinicaRUC = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_ClinicaRUC")) ;
            AV62IsAuthorized_UbigeoNombre = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_UbigeoNombre")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFSedeId, AV28TFSedeId_To, AV29TFSedeNombre, AV30TFSedeNombre_Sel, AV31TFClinicaId, AV32TFClinicaId_To, AV33TFClinicaRUC, AV34TFClinicaRUC_To, AV35TFClinicaNombreComercial, AV36TFClinicaNombreComercial_Sel, AV37TFUbigeoCode, AV38TFUbigeoCode_Sel, AV39TFUbigeoNombre, AV40TFUbigeoNombre_Sel, AV41TFSedeDireccion, AV42TFSedeDireccion_Sel, AV43TFSedeCorreo, AV44TFSedeCorreo_Sel, AV46TFSedeEstado_Sels, AV48TFSedeTipo_Sels, AV50TFSedeSector_Sels, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV56IsAuthorized_Update, AV57IsAuthorized_Delete, AV58IsAuthorized_ClinicaRUC, AV62IsAuthorized_UbigeoNombre) ;
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
      pa2Q2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2Q2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334392", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.sedeww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV56IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CLINICARUC", getSecureSignedToken( "", AV58IsAuthorized_ClinicaRUC));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV62IsAuthorized_UbigeoNombre));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV53GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV54GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV51DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV51DDO_TitleSettingsIcons);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDEID", GXutil.ltrim( localUtil.ntoc( AV27TFSedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDEID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFSedeId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDENOMBRE", AV29TFSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDENOMBRE_SEL", AV30TFSedeNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAID", GXutil.ltrim( localUtil.ntoc( AV31TFClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICAID_TO", GXutil.ltrim( localUtil.ntoc( AV32TFClinicaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICARUC", GXutil.ltrim( localUtil.ntoc( AV33TFClinicaRUC, (byte)(11), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICARUC_TO", GXutil.ltrim( localUtil.ntoc( AV34TFClinicaRUC_To, (byte)(11), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICANOMBRECOMERCIAL", AV35TFClinicaNombreComercial);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCLINICANOMBRECOMERCIAL_SEL", AV36TFClinicaNombreComercial_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE", GXutil.rtrim( AV37TFUbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEOCODE_SEL", GXutil.rtrim( AV38TFUbigeoCode_Sel));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE", AV39TFUbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFUBIGEONOMBRE_SEL", AV40TFUbigeoNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDEDIRECCION", AV41TFSedeDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDEDIRECCION_SEL", AV42TFSedeDireccion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDECORREO", AV43TFSedeCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDECORREO_SEL", AV44TFSedeCorreo_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSEDEESTADO_SELS", AV46TFSedeEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSEDEESTADO_SELS", AV46TFSedeEstado_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSEDETIPO_SELS", AV48TFSedeTipo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSEDETIPO_SELS", AV48TFSedeTipo_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSEDESECTOR_SELS", AV50TFSedeSector_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSEDESECTOR_SELS", AV50TFSedeSector_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV56IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV56IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV57IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_CLINICARUC", AV58IsAuthorized_ClinicaRUC);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CLINICARUC", getSecureSignedToken( "", AV58IsAuthorized_ClinicaRUC));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UBIGEONOMBRE", AV62IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV62IsAuthorized_UbigeoNombre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDEESTADO_SELSJSON", AV45TFSedeEstado_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDETIPO_SELSJSON", AV47TFSedeTipo_SelsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSEDESECTOR_SELSJSON", AV49TFSedeSector_SelsJson);
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
         we2Q2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2Q2( ) ;
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
      return formatLink("com.projectthani.sedeww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "SedeWW" ;
   }

   public String getPgmdesc( )
   {
      return " Sede" ;
   }

   public void wb2Q0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SedeWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SedeWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SedeWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SedeWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_2Q2( true) ;
      }
      else
      {
         wb_table1_25_2Q2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_2Q2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSedeId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSedeNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Clinica Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaRUC_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Clinica RUC") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtClinicaNombreComercial_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Comercial") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoCode_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtUbigeoNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSedeDireccion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSedeCorreo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbSedeEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbSedeTipo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbSedeSector.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Sector") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV60Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV61Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSedeId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A75SedeNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtSedeNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSedeNombre_Visible, (byte)(5), (byte)(0), ".", "")));
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A44UbigeoCode));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoCode_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A185UbigeoNombre);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtUbigeoNombre_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtUbigeoNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A276SedeDireccion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSedeDireccion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A277SedeCorreo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSedeCorreo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A278SedeEstado));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbSedeEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A279SedeTipo));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbSedeTipo.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A280SedeSector));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbSedeSector.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         ucGridpaginationbar.setProperty("CurrentPage", AV53GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV54GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV51DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV51DDO_TitleSettingsIcons);
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

   public void start2Q2( )
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
         Form.getMeta().addItem("description", " Sede", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2Q0( ) ;
   }

   public void ws2Q2( )
   {
      start2Q2( ) ;
      evt2Q2( ) ;
   }

   public void evt2Q2( )
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
                           e112Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e162Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e172Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e182Q2 ();
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
                           AV60Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV60Update);
                           AV61Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV61Delete);
                           A30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".")) ;
                           A75SedeNombre = httpContext.cgiGet( edtSedeNombre_Internalname) ;
                           A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".")) ;
                           A118ClinicaRUC = localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") ;
                           A116ClinicaNombreComercial = httpContext.cgiGet( edtClinicaNombreComercial_Internalname) ;
                           A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
                           A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
                           A276SedeDireccion = httpContext.cgiGet( edtSedeDireccion_Internalname) ;
                           A277SedeCorreo = httpContext.cgiGet( edtSedeCorreo_Internalname) ;
                           cmbSedeEstado.setName( cmbSedeEstado.getInternalname() );
                           cmbSedeEstado.setValue( httpContext.cgiGet( cmbSedeEstado.getInternalname()) );
                           A278SedeEstado = httpContext.cgiGet( cmbSedeEstado.getInternalname()) ;
                           cmbSedeTipo.setName( cmbSedeTipo.getInternalname() );
                           cmbSedeTipo.setValue( httpContext.cgiGet( cmbSedeTipo.getInternalname()) );
                           A279SedeTipo = httpContext.cgiGet( cmbSedeTipo.getInternalname()) ;
                           cmbSedeSector.setName( cmbSedeSector.getInternalname() );
                           cmbSedeSector.setValue( httpContext.cgiGet( cmbSedeSector.getInternalname()) );
                           A280SedeSector = httpContext.cgiGet( cmbSedeSector.getInternalname()) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e192Q2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e202Q2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e212Q2 ();
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

   public void we2Q2( )
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

   public void pa2Q2( )
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
                                 short AV27TFSedeId ,
                                 short AV28TFSedeId_To ,
                                 String AV29TFSedeNombre ,
                                 String AV30TFSedeNombre_Sel ,
                                 short AV31TFClinicaId ,
                                 short AV32TFClinicaId_To ,
                                 long AV33TFClinicaRUC ,
                                 long AV34TFClinicaRUC_To ,
                                 String AV35TFClinicaNombreComercial ,
                                 String AV36TFClinicaNombreComercial_Sel ,
                                 String AV37TFUbigeoCode ,
                                 String AV38TFUbigeoCode_Sel ,
                                 String AV39TFUbigeoNombre ,
                                 String AV40TFUbigeoNombre_Sel ,
                                 String AV41TFSedeDireccion ,
                                 String AV42TFSedeDireccion_Sel ,
                                 String AV43TFSedeCorreo ,
                                 String AV44TFSedeCorreo_Sel ,
                                 GXSimpleCollection<String> AV46TFSedeEstado_Sels ,
                                 GXSimpleCollection<String> AV48TFSedeTipo_Sels ,
                                 GXSimpleCollection<String> AV50TFSedeSector_Sels ,
                                 String AV87Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV56IsAuthorized_Update ,
                                 boolean AV57IsAuthorized_Delete ,
                                 boolean AV58IsAuthorized_ClinicaRUC ,
                                 boolean AV62IsAuthorized_UbigeoNombre )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e202Q2 ();
      GRID_nCurrentRecord = 0 ;
      rf2Q2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SEDEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDEID", GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ".", "")));
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
      rf2Q2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV87Pgmname = "SedeWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf2Q2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e202Q2 ();
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
                                              A278SedeEstado ,
                                              AV84Sedewwds_20_tfsedeestado_sels ,
                                              A279SedeTipo ,
                                              AV85Sedewwds_21_tfsedetipo_sels ,
                                              A280SedeSector ,
                                              AV86Sedewwds_22_tfsedesector_sels ,
                                              Short.valueOf(AV66Sedewwds_2_tfsedeid) ,
                                              Short.valueOf(AV67Sedewwds_3_tfsedeid_to) ,
                                              AV69Sedewwds_5_tfsedenombre_sel ,
                                              AV68Sedewwds_4_tfsedenombre ,
                                              Short.valueOf(AV70Sedewwds_6_tfclinicaid) ,
                                              Short.valueOf(AV71Sedewwds_7_tfclinicaid_to) ,
                                              Long.valueOf(AV72Sedewwds_8_tfclinicaruc) ,
                                              Long.valueOf(AV73Sedewwds_9_tfclinicaruc_to) ,
                                              AV75Sedewwds_11_tfclinicanombrecomercial_sel ,
                                              AV74Sedewwds_10_tfclinicanombrecomercial ,
                                              AV77Sedewwds_13_tfubigeocode_sel ,
                                              AV76Sedewwds_12_tfubigeocode ,
                                              AV79Sedewwds_15_tfubigeonombre_sel ,
                                              AV78Sedewwds_14_tfubigeonombre ,
                                              AV81Sedewwds_17_tfsededireccion_sel ,
                                              AV80Sedewwds_16_tfsededireccion ,
                                              AV83Sedewwds_19_tfsedecorreo_sel ,
                                              AV82Sedewwds_18_tfsedecorreo ,
                                              Integer.valueOf(AV84Sedewwds_20_tfsedeestado_sels.size()) ,
                                              Integer.valueOf(AV85Sedewwds_21_tfsedetipo_sels.size()) ,
                                              Integer.valueOf(AV86Sedewwds_22_tfsedesector_sels.size()) ,
                                              Short.valueOf(A30SedeId) ,
                                              A75SedeNombre ,
                                              Short.valueOf(A28ClinicaId) ,
                                              Long.valueOf(A118ClinicaRUC) ,
                                              A116ClinicaNombreComercial ,
                                              A44UbigeoCode ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito ,
                                              A276SedeDireccion ,
                                              A277SedeCorreo ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              AV65Sedewwds_1_filterfulltext ,
                                              A185UbigeoNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                              TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
         lV68Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV68Sedewwds_4_tfsedenombre), "%", "") ;
         lV74Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV74Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
         lV76Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV76Sedewwds_12_tfubigeocode), 10, "%") ;
         lV78Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV78Sedewwds_14_tfubigeonombre), "%", "") ;
         lV80Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV80Sedewwds_16_tfsededireccion), "%", "") ;
         lV82Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV82Sedewwds_18_tfsedecorreo), "%", "") ;
         /* Using cursor H002Q2 */
         pr_default.execute(0, new Object[] {AV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, Short.valueOf(AV66Sedewwds_2_tfsedeid), Short.valueOf(AV67Sedewwds_3_tfsedeid_to), lV68Sedewwds_4_tfsedenombre, AV69Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV70Sedewwds_6_tfclinicaid), Short.valueOf(AV71Sedewwds_7_tfclinicaid_to), Long.valueOf(AV72Sedewwds_8_tfclinicaruc), Long.valueOf(AV73Sedewwds_9_tfclinicaruc_to), lV74Sedewwds_10_tfclinicanombrecomercial, AV75Sedewwds_11_tfclinicanombrecomercial_sel, lV76Sedewwds_12_tfubigeocode, AV77Sedewwds_13_tfubigeocode_sel, lV78Sedewwds_14_tfubigeonombre, AV79Sedewwds_15_tfubigeonombre_sel, lV80Sedewwds_16_tfsededireccion, AV81Sedewwds_17_tfsededireccion_sel, lV82Sedewwds_18_tfsedecorreo, AV83Sedewwds_19_tfsedecorreo_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A280SedeSector = H002Q2_A280SedeSector[0] ;
            A279SedeTipo = H002Q2_A279SedeTipo[0] ;
            A278SedeEstado = H002Q2_A278SedeEstado[0] ;
            A277SedeCorreo = H002Q2_A277SedeCorreo[0] ;
            A276SedeDireccion = H002Q2_A276SedeDireccion[0] ;
            A185UbigeoNombre = H002Q2_A185UbigeoNombre[0] ;
            A44UbigeoCode = H002Q2_A44UbigeoCode[0] ;
            A116ClinicaNombreComercial = H002Q2_A116ClinicaNombreComercial[0] ;
            A118ClinicaRUC = H002Q2_A118ClinicaRUC[0] ;
            A28ClinicaId = H002Q2_A28ClinicaId[0] ;
            A75SedeNombre = H002Q2_A75SedeNombre[0] ;
            A30SedeId = H002Q2_A30SedeId[0] ;
            A186UbigeoDepartamento = H002Q2_A186UbigeoDepartamento[0] ;
            A187UbigeoProvincia = H002Q2_A187UbigeoProvincia[0] ;
            A188UbigeoDistrito = H002Q2_A188UbigeoDistrito[0] ;
            A185UbigeoNombre = H002Q2_A185UbigeoNombre[0] ;
            A186UbigeoDepartamento = H002Q2_A186UbigeoDepartamento[0] ;
            A187UbigeoProvincia = H002Q2_A187UbigeoProvincia[0] ;
            A188UbigeoDistrito = H002Q2_A188UbigeoDistrito[0] ;
            A116ClinicaNombreComercial = H002Q2_A116ClinicaNombreComercial[0] ;
            A118ClinicaRUC = H002Q2_A118ClinicaRUC[0] ;
            e212Q2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb2Q0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Q2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV56IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV56IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV57IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_CLINICARUC", AV58IsAuthorized_ClinicaRUC);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CLINICARUC", getSecureSignedToken( "", AV58IsAuthorized_ClinicaRUC));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UBIGEONOMBRE", AV62IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV62IsAuthorized_UbigeoNombre));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SEDEID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9")));
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
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV84Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV85Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV86Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV66Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV67Sedewwds_3_tfsedeid_to) ,
                                           AV69Sedewwds_5_tfsedenombre_sel ,
                                           AV68Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV70Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV71Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV72Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV73Sedewwds_9_tfclinicaruc_to) ,
                                           AV75Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV74Sedewwds_10_tfclinicanombrecomercial ,
                                           AV77Sedewwds_13_tfubigeocode_sel ,
                                           AV76Sedewwds_12_tfubigeocode ,
                                           AV79Sedewwds_15_tfubigeonombre_sel ,
                                           AV78Sedewwds_14_tfubigeonombre ,
                                           AV81Sedewwds_17_tfsededireccion_sel ,
                                           AV80Sedewwds_16_tfsededireccion ,
                                           AV83Sedewwds_19_tfsedecorreo_sel ,
                                           AV82Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV84Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV85Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV86Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           AV65Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV65Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Sedewwds_1_filterfulltext), "%", "") ;
      lV68Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV68Sedewwds_4_tfsedenombre), "%", "") ;
      lV74Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV74Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV76Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV76Sedewwds_12_tfubigeocode), 10, "%") ;
      lV78Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV78Sedewwds_14_tfubigeonombre), "%", "") ;
      lV80Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV80Sedewwds_16_tfsededireccion), "%", "") ;
      lV82Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV82Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor H002Q3 */
      pr_default.execute(1, new Object[] {AV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, lV65Sedewwds_1_filterfulltext, Short.valueOf(AV66Sedewwds_2_tfsedeid), Short.valueOf(AV67Sedewwds_3_tfsedeid_to), lV68Sedewwds_4_tfsedenombre, AV69Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV70Sedewwds_6_tfclinicaid), Short.valueOf(AV71Sedewwds_7_tfclinicaid_to), Long.valueOf(AV72Sedewwds_8_tfclinicaruc), Long.valueOf(AV73Sedewwds_9_tfclinicaruc_to), lV74Sedewwds_10_tfclinicanombrecomercial, AV75Sedewwds_11_tfclinicanombrecomercial_sel, lV76Sedewwds_12_tfubigeocode, AV77Sedewwds_13_tfubigeocode_sel, lV78Sedewwds_14_tfubigeonombre, AV79Sedewwds_15_tfubigeonombre_sel, lV80Sedewwds_16_tfsededireccion, AV81Sedewwds_17_tfsededireccion_sel, lV82Sedewwds_18_tfsedecorreo, AV83Sedewwds_19_tfsedecorreo_sel});
      GRID_nRecordCount = H002Q3_AGRID_nRecordCount[0] ;
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
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFSedeId, AV28TFSedeId_To, AV29TFSedeNombre, AV30TFSedeNombre_Sel, AV31TFClinicaId, AV32TFClinicaId_To, AV33TFClinicaRUC, AV34TFClinicaRUC_To, AV35TFClinicaNombreComercial, AV36TFClinicaNombreComercial_Sel, AV37TFUbigeoCode, AV38TFUbigeoCode_Sel, AV39TFUbigeoNombre, AV40TFUbigeoNombre_Sel, AV41TFSedeDireccion, AV42TFSedeDireccion_Sel, AV43TFSedeCorreo, AV44TFSedeCorreo_Sel, AV46TFSedeEstado_Sels, AV48TFSedeTipo_Sels, AV50TFSedeSector_Sels, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV56IsAuthorized_Update, AV57IsAuthorized_Delete, AV58IsAuthorized_ClinicaRUC, AV62IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFSedeId, AV28TFSedeId_To, AV29TFSedeNombre, AV30TFSedeNombre_Sel, AV31TFClinicaId, AV32TFClinicaId_To, AV33TFClinicaRUC, AV34TFClinicaRUC_To, AV35TFClinicaNombreComercial, AV36TFClinicaNombreComercial_Sel, AV37TFUbigeoCode, AV38TFUbigeoCode_Sel, AV39TFUbigeoNombre, AV40TFUbigeoNombre_Sel, AV41TFSedeDireccion, AV42TFSedeDireccion_Sel, AV43TFSedeCorreo, AV44TFSedeCorreo_Sel, AV46TFSedeEstado_Sels, AV48TFSedeTipo_Sels, AV50TFSedeSector_Sels, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV56IsAuthorized_Update, AV57IsAuthorized_Delete, AV58IsAuthorized_ClinicaRUC, AV62IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFSedeId, AV28TFSedeId_To, AV29TFSedeNombre, AV30TFSedeNombre_Sel, AV31TFClinicaId, AV32TFClinicaId_To, AV33TFClinicaRUC, AV34TFClinicaRUC_To, AV35TFClinicaNombreComercial, AV36TFClinicaNombreComercial_Sel, AV37TFUbigeoCode, AV38TFUbigeoCode_Sel, AV39TFUbigeoNombre, AV40TFUbigeoNombre_Sel, AV41TFSedeDireccion, AV42TFSedeDireccion_Sel, AV43TFSedeCorreo, AV44TFSedeCorreo_Sel, AV46TFSedeEstado_Sels, AV48TFSedeTipo_Sels, AV50TFSedeSector_Sels, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV56IsAuthorized_Update, AV57IsAuthorized_Delete, AV58IsAuthorized_ClinicaRUC, AV62IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFSedeId, AV28TFSedeId_To, AV29TFSedeNombre, AV30TFSedeNombre_Sel, AV31TFClinicaId, AV32TFClinicaId_To, AV33TFClinicaRUC, AV34TFClinicaRUC_To, AV35TFClinicaNombreComercial, AV36TFClinicaNombreComercial_Sel, AV37TFUbigeoCode, AV38TFUbigeoCode_Sel, AV39TFUbigeoNombre, AV40TFUbigeoNombre_Sel, AV41TFSedeDireccion, AV42TFSedeDireccion_Sel, AV43TFSedeCorreo, AV44TFSedeCorreo_Sel, AV46TFSedeEstado_Sels, AV48TFSedeTipo_Sels, AV50TFSedeSector_Sels, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV56IsAuthorized_Update, AV57IsAuthorized_Delete, AV58IsAuthorized_ClinicaRUC, AV62IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV16FilterFullText, AV27TFSedeId, AV28TFSedeId_To, AV29TFSedeNombre, AV30TFSedeNombre_Sel, AV31TFClinicaId, AV32TFClinicaId_To, AV33TFClinicaRUC, AV34TFClinicaRUC_To, AV35TFClinicaNombreComercial, AV36TFClinicaNombreComercial_Sel, AV37TFUbigeoCode, AV38TFUbigeoCode_Sel, AV39TFUbigeoNombre, AV40TFUbigeoNombre_Sel, AV41TFSedeDireccion, AV42TFSedeDireccion_Sel, AV43TFSedeCorreo, AV44TFSedeCorreo_Sel, AV46TFSedeEstado_Sels, AV48TFSedeTipo_Sels, AV50TFSedeSector_Sels, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV56IsAuthorized_Update, AV57IsAuthorized_Delete, AV58IsAuthorized_ClinicaRUC, AV62IsAuthorized_UbigeoNombre) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV87Pgmname = "SedeWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2Q0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e192Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV51DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV53GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV54GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e192Q2 ();
      if (returnInSub) return;
   }

   public void e192Q2( )
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
      GXt_boolean1 = AV58IsAuthorized_ClinicaRUC ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica", GXv_boolean2) ;
      sedeww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV58IsAuthorized_ClinicaRUC = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58IsAuthorized_ClinicaRUC", AV58IsAuthorized_ClinicaRUC);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_CLINICARUC", getSecureSignedToken( "", AV58IsAuthorized_ClinicaRUC));
      GXt_boolean1 = AV62IsAuthorized_UbigeoNombre ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean2) ;
      sedeww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV62IsAuthorized_UbigeoNombre = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62IsAuthorized_UbigeoNombre", AV62IsAuthorized_UbigeoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UBIGEONOMBRE", getSecureSignedToken( "", AV62IsAuthorized_UbigeoNombre));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Sede" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV51DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV51DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e202Q2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("SedeWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("SedeWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtSedeId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSedeNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaRUC_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaRUC_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaRUC_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtClinicaNombreComercial_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreComercial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreComercial_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoCode_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtUbigeoNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSedeDireccion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeDireccion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeDireccion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtSedeCorreo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeCorreo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeCorreo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      cmbSedeEstado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbSedeEstado.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbSedeTipo.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipo.getInternalname(), "Visible", GXutil.ltrimstr( cmbSedeTipo.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      cmbSedeSector.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeSector.getInternalname(), "Visible", GXutil.ltrimstr( cmbSedeSector.getVisible(), 5, 0), !bGXsfl_43_Refreshing);
      AV53GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53GridCurrentPage), 10, 0));
      AV54GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54GridPageCount), 10, 0));
      AV65Sedewwds_1_filterfulltext = AV16FilterFullText ;
      AV66Sedewwds_2_tfsedeid = AV27TFSedeId ;
      AV67Sedewwds_3_tfsedeid_to = AV28TFSedeId_To ;
      AV68Sedewwds_4_tfsedenombre = AV29TFSedeNombre ;
      AV69Sedewwds_5_tfsedenombre_sel = AV30TFSedeNombre_Sel ;
      AV70Sedewwds_6_tfclinicaid = AV31TFClinicaId ;
      AV71Sedewwds_7_tfclinicaid_to = AV32TFClinicaId_To ;
      AV72Sedewwds_8_tfclinicaruc = AV33TFClinicaRUC ;
      AV73Sedewwds_9_tfclinicaruc_to = AV34TFClinicaRUC_To ;
      AV74Sedewwds_10_tfclinicanombrecomercial = AV35TFClinicaNombreComercial ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = AV36TFClinicaNombreComercial_Sel ;
      AV76Sedewwds_12_tfubigeocode = AV37TFUbigeoCode ;
      AV77Sedewwds_13_tfubigeocode_sel = AV38TFUbigeoCode_Sel ;
      AV78Sedewwds_14_tfubigeonombre = AV39TFUbigeoNombre ;
      AV79Sedewwds_15_tfubigeonombre_sel = AV40TFUbigeoNombre_Sel ;
      AV80Sedewwds_16_tfsededireccion = AV41TFSedeDireccion ;
      AV81Sedewwds_17_tfsededireccion_sel = AV42TFSedeDireccion_Sel ;
      AV82Sedewwds_18_tfsedecorreo = AV43TFSedeCorreo ;
      AV83Sedewwds_19_tfsedecorreo_sel = AV44TFSedeCorreo_Sel ;
      AV84Sedewwds_20_tfsedeestado_sels = AV46TFSedeEstado_Sels ;
      AV85Sedewwds_21_tfsedetipo_sels = AV48TFSedeTipo_Sels ;
      AV86Sedewwds_22_tfsedesector_sels = AV50TFSedeSector_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122Q2( )
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
         AV52PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV52PageToGo) ;
      }
   }

   public void e132Q2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142Q2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeId") == 0 )
         {
            AV27TFSedeId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFSedeId), 4, 0));
            AV28TFSedeId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFSedeId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFSedeId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeNombre") == 0 )
         {
            AV29TFSedeNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFSedeNombre", AV29TFSedeNombre);
            AV30TFSedeNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFSedeNombre_Sel", AV30TFSedeNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaId") == 0 )
         {
            AV31TFClinicaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFClinicaId), 4, 0));
            AV32TFClinicaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaRUC") == 0 )
         {
            AV33TFClinicaRUC = GXutil.lval( Ddo_grid_Filteredtext_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFClinicaRUC), 11, 0));
            AV34TFClinicaRUC_To = GXutil.lval( Ddo_grid_Filteredtextto_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFClinicaRUC_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFClinicaRUC_To), 11, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ClinicaNombreComercial") == 0 )
         {
            AV35TFClinicaNombreComercial = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFClinicaNombreComercial", AV35TFClinicaNombreComercial);
            AV36TFClinicaNombreComercial_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFClinicaNombreComercial_Sel", AV36TFClinicaNombreComercial_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoCode") == 0 )
         {
            AV37TFUbigeoCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFUbigeoCode", AV37TFUbigeoCode);
            AV38TFUbigeoCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFUbigeoCode_Sel", AV38TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "UbigeoNombre") == 0 )
         {
            AV39TFUbigeoNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFUbigeoNombre", AV39TFUbigeoNombre);
            AV40TFUbigeoNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFUbigeoNombre_Sel", AV40TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeDireccion") == 0 )
         {
            AV41TFSedeDireccion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSedeDireccion", AV41TFSedeDireccion);
            AV42TFSedeDireccion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSedeDireccion_Sel", AV42TFSedeDireccion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeCorreo") == 0 )
         {
            AV43TFSedeCorreo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFSedeCorreo", AV43TFSedeCorreo);
            AV44TFSedeCorreo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFSedeCorreo_Sel", AV44TFSedeCorreo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeEstado") == 0 )
         {
            AV45TFSedeEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFSedeEstado_SelsJson", AV45TFSedeEstado_SelsJson);
            AV46TFSedeEstado_Sels.fromJSonString(AV45TFSedeEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeTipo") == 0 )
         {
            AV47TFSedeTipo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFSedeTipo_SelsJson", AV47TFSedeTipo_SelsJson);
            AV48TFSedeTipo_Sels.fromJSonString(AV47TFSedeTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SedeSector") == 0 )
         {
            AV49TFSedeSector_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFSedeSector_SelsJson", AV49TFSedeSector_SelsJson);
            AV50TFSedeSector_Sels.fromJSonString(AV49TFSedeSector_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFSedeSector_Sels", AV50TFSedeSector_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFSedeTipo_Sels", AV48TFSedeTipo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFSedeEstado_Sels", AV46TFSedeEstado_Sels);
   }

   private void e212Q2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV60Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV60Update);
      if ( AV56IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.sede", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A30SedeId,4,0))}, new String[] {"Mode","SedeId"})  ;
      }
      AV61Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV61Delete);
      if ( AV57IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.sede", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A30SedeId,4,0))}, new String[] {"Mode","SedeId"})  ;
      }
      edtSedeNombre_Link = formatLink("com.projectthani.sedeview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A30SedeId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SedeId","TabCode"})  ;
      if ( AV58IsAuthorized_ClinicaRUC )
      {
         edtClinicaRUC_Link = formatLink("com.projectthani.clinicaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A28ClinicaId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"ClinicaId","TabCode"})  ;
      }
      if ( AV62IsAuthorized_UbigeoNombre )
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

   public void e152Q2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "SedeWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e112Q2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("SedeWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV87Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("SedeWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "SedeWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         sedeww_impl.this.GXt_char6 = GXv_char7[0] ;
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
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV25ManageFiltersXml) ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFSedeEstado_Sels", AV46TFSedeEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFSedeTipo_Sels", AV48TFSedeTipo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFSedeSector_Sels", AV50TFSedeSector_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e162Q2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.sede", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","SedeId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e172Q2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.sedewwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      sedeww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      sedeww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFSedeSector_Sels", AV50TFSedeSector_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFSedeTipo_Sels", AV48TFSedeTipo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFSedeEstado_Sels", AV46TFSedeEstado_Sels);
   }

   public void e182Q2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.sedewwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFSedeSector_Sels", AV50TFSedeSector_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFSedeTipo_Sels", AV48TFSedeTipo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFSedeEstado_Sels", AV46TFSedeEstado_Sels);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeNombre", "", "Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ClinicaId", "", "Clinica Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ClinicaRUC", "", "Clinica RUC", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ClinicaNombreComercial", "", "Nombre Comercial", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoCode", "", "Ubigeo Code", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeDireccion", "", "Direccion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeCorreo", "", "Correo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeEstado", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeTipo", "", "Tipo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SedeSector", "", "Sector", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "SedeWWColumnsSelector", GXv_char8) ;
      sedeww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV56IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Update", GXv_boolean2) ;
      sedeww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV56IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56IsAuthorized_Update", AV56IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV56IsAuthorized_Update));
      if ( ! ( AV56IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV57IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Delete", GXv_boolean2) ;
      sedeww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV57IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57IsAuthorized_Delete", AV57IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      if ( ! ( AV57IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV59TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Insert", GXv_boolean2) ;
      sedeww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV59TempBoolean = GXt_boolean1 ;
      if ( ! ( AV59TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "SedeWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFSedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFSedeId), 4, 0));
      AV28TFSedeId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFSedeId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFSedeId_To), 4, 0));
      AV29TFSedeNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFSedeNombre", AV29TFSedeNombre);
      AV30TFSedeNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFSedeNombre_Sel", AV30TFSedeNombre_Sel);
      AV31TFClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFClinicaId), 4, 0));
      AV32TFClinicaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFClinicaId_To), 4, 0));
      AV33TFClinicaRUC = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFClinicaRUC), 11, 0));
      AV34TFClinicaRUC_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFClinicaRUC_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFClinicaRUC_To), 11, 0));
      AV35TFClinicaNombreComercial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFClinicaNombreComercial", AV35TFClinicaNombreComercial);
      AV36TFClinicaNombreComercial_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFClinicaNombreComercial_Sel", AV36TFClinicaNombreComercial_Sel);
      AV37TFUbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFUbigeoCode", AV37TFUbigeoCode);
      AV38TFUbigeoCode_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFUbigeoCode_Sel", AV38TFUbigeoCode_Sel);
      AV39TFUbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFUbigeoNombre", AV39TFUbigeoNombre);
      AV40TFUbigeoNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFUbigeoNombre_Sel", AV40TFUbigeoNombre_Sel);
      AV41TFSedeDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFSedeDireccion", AV41TFSedeDireccion);
      AV42TFSedeDireccion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFSedeDireccion_Sel", AV42TFSedeDireccion_Sel);
      AV43TFSedeCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFSedeCorreo", AV43TFSedeCorreo);
      AV44TFSedeCorreo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFSedeCorreo_Sel", AV44TFSedeCorreo_Sel);
      AV46TFSedeEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48TFSedeTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50TFSedeSector_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV23Session.getValue(AV87Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV87Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV23Session.getValue(AV87Pgmname+"GridState"), null, null);
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
      AV88GXV1 = 1 ;
      while ( AV88GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV88GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEID") == 0 )
         {
            AV27TFSedeId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFSedeId), 4, 0));
            AV28TFSedeId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFSedeId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFSedeId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE") == 0 )
         {
            AV29TFSedeNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFSedeNombre", AV29TFSedeNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE_SEL") == 0 )
         {
            AV30TFSedeNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFSedeNombre_Sel", AV30TFSedeNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV31TFClinicaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFClinicaId), 4, 0));
            AV32TFClinicaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFClinicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFClinicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV33TFClinicaRUC = GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFClinicaRUC), 11, 0));
            AV34TFClinicaRUC_To = GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFClinicaRUC_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFClinicaRUC_To), 11, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV35TFClinicaNombreComercial = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFClinicaNombreComercial", AV35TFClinicaNombreComercial);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV36TFClinicaNombreComercial_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFClinicaNombreComercial_Sel", AV36TFClinicaNombreComercial_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV37TFUbigeoCode = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFUbigeoCode", AV37TFUbigeoCode);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV38TFUbigeoCode_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFUbigeoCode_Sel", AV38TFUbigeoCode_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV39TFUbigeoNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFUbigeoNombre", AV39TFUbigeoNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV40TFUbigeoNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFUbigeoNombre_Sel", AV40TFUbigeoNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION") == 0 )
         {
            AV41TFSedeDireccion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSedeDireccion", AV41TFSedeDireccion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION_SEL") == 0 )
         {
            AV42TFSedeDireccion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSedeDireccion_Sel", AV42TFSedeDireccion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO") == 0 )
         {
            AV43TFSedeCorreo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFSedeCorreo", AV43TFSedeCorreo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO_SEL") == 0 )
         {
            AV44TFSedeCorreo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFSedeCorreo_Sel", AV44TFSedeCorreo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEESTADO_SEL") == 0 )
         {
            AV45TFSedeEstado_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFSedeEstado_SelsJson", AV45TFSedeEstado_SelsJson);
            AV46TFSedeEstado_Sels.fromJSonString(AV45TFSedeEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDETIPO_SEL") == 0 )
         {
            AV47TFSedeTipo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFSedeTipo_SelsJson", AV47TFSedeTipo_SelsJson);
            AV48TFSedeTipo_Sels.fromJSonString(AV47TFSedeTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDESECTOR_SEL") == 0 )
         {
            AV49TFSedeSector_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFSedeSector_SelsJson", AV49TFSedeSector_SelsJson);
            AV50TFSedeSector_Sels.fromJSonString(AV49TFSedeSector_SelsJson, null);
         }
         AV88GXV1 = (int)(AV88GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFSedeNombre_Sel)==0), AV30TFSedeNombre_Sel, GXv_char8) ;
      sedeww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFClinicaNombreComercial_Sel)==0), AV36TFClinicaNombreComercial_Sel, GXv_char7) ;
      sedeww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFUbigeoCode_Sel)==0), AV38TFUbigeoCode_Sel, GXv_char15) ;
      sedeww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFUbigeoNombre_Sel)==0), AV40TFUbigeoNombre_Sel, GXv_char17) ;
      sedeww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFSedeDireccion_Sel)==0), AV42TFSedeDireccion_Sel, GXv_char19) ;
      sedeww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFSedeCorreo_Sel)==0), AV44TFSedeCorreo_Sel, GXv_char21) ;
      sedeww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV46TFSedeEstado_Sels.size()==0), AV45TFSedeEstado_SelsJson, GXv_char23) ;
      sedeww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV48TFSedeTipo_Sels.size()==0), AV47TFSedeTipo_SelsJson, GXv_char25) ;
      sedeww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV50TFSedeSector_Sels.size()==0), AV49TFSedeSector_SelsJson, GXv_char27) ;
      sedeww_impl.this.GXt_char26 = GXv_char27[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|||"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"|"+GXt_char24+"|"+GXt_char26 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFSedeNombre)==0), AV29TFSedeNombre, GXv_char27) ;
      sedeww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFClinicaNombreComercial)==0), AV35TFClinicaNombreComercial, GXv_char25) ;
      sedeww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFUbigeoCode)==0), AV37TFUbigeoCode, GXv_char23) ;
      sedeww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFUbigeoNombre)==0), AV39TFUbigeoNombre, GXv_char21) ;
      sedeww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV41TFSedeDireccion)==0), AV41TFSedeDireccion, GXv_char19) ;
      sedeww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFSedeCorreo)==0), AV43TFSedeCorreo, GXv_char17) ;
      sedeww_impl.this.GXt_char16 = GXv_char17[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFSedeId) ? "" : GXutil.str( AV27TFSedeId, 4, 0))+"|"+GXt_char26+"|"+((0==AV31TFClinicaId) ? "" : GXutil.str( AV31TFClinicaId, 4, 0))+"|"+((0==AV33TFClinicaRUC) ? "" : GXutil.str( AV33TFClinicaRUC, 11, 0))+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+GXt_char18+"|"+GXt_char16+"|||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFSedeId_To) ? "" : GXutil.str( AV28TFSedeId_To, 4, 0))+"||"+((0==AV32TFClinicaId_To) ? "" : GXutil.str( AV32TFClinicaId_To, 4, 0))+"|"+((0==AV34TFClinicaRUC_To) ? "" : GXutil.str( AV34TFClinicaRUC_To, 11, 0))+"||||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV23Session.getValue(AV87Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDEID", !((0==AV27TFSedeId)&&(0==AV28TFSedeId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFSedeId, 4, 0)), GXutil.trim( GXutil.str( AV28TFSedeId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDENOMBRE", !(GXutil.strcmp("", AV29TFSedeNombre)==0), (short)(0), AV29TFSedeNombre, "", !(GXutil.strcmp("", AV30TFSedeNombre_Sel)==0), AV30TFSedeNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFCLINICAID", !((0==AV31TFClinicaId)&&(0==AV32TFClinicaId_To)), (short)(0), GXutil.trim( GXutil.str( AV31TFClinicaId, 4, 0)), GXutil.trim( GXutil.str( AV32TFClinicaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFCLINICARUC", !((0==AV33TFClinicaRUC)&&(0==AV34TFClinicaRUC_To)), (short)(0), GXutil.trim( GXutil.str( AV33TFClinicaRUC, 11, 0)), GXutil.trim( GXutil.str( AV34TFClinicaRUC_To, 11, 0))) ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFCLINICANOMBRECOMERCIAL", !(GXutil.strcmp("", AV35TFClinicaNombreComercial)==0), (short)(0), AV35TFClinicaNombreComercial, "", !(GXutil.strcmp("", AV36TFClinicaNombreComercial_Sel)==0), AV36TFClinicaNombreComercial_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEOCODE", !(GXutil.strcmp("", AV37TFUbigeoCode)==0), (short)(0), AV37TFUbigeoCode, "", !(GXutil.strcmp("", AV38TFUbigeoCode_Sel)==0), AV38TFUbigeoCode_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFUBIGEONOMBRE", !(GXutil.strcmp("", AV39TFUbigeoNombre)==0), (short)(0), AV39TFUbigeoNombre, "", !(GXutil.strcmp("", AV40TFUbigeoNombre_Sel)==0), AV40TFUbigeoNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDEDIRECCION", !(GXutil.strcmp("", AV41TFSedeDireccion)==0), (short)(0), AV41TFSedeDireccion, "", !(GXutil.strcmp("", AV42TFSedeDireccion_Sel)==0), AV42TFSedeDireccion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDECORREO", !(GXutil.strcmp("", AV43TFSedeCorreo)==0), (short)(0), AV43TFSedeCorreo, "", !(GXutil.strcmp("", AV44TFSedeCorreo_Sel)==0), AV44TFSedeCorreo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDEESTADO_SEL", !(AV46TFSedeEstado_Sels.size()==0), (short)(0), AV46TFSedeEstado_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDETIPO_SEL", !(AV48TFSedeTipo_Sels.size()==0), (short)(0), AV48TFSedeTipo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFSEDESECTOR_SEL", !(AV50TFSedeSector_Sels.size()==0), (short)(0), AV50TFSedeSector_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV87Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Sede" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_2Q2( boolean wbgen )
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
         wb_table2_30_2Q2( true) ;
      }
      else
      {
         wb_table2_30_2Q2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_2Q2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_2Q2e( true) ;
      }
      else
      {
         wb_table1_25_2Q2e( false) ;
      }
   }

   public void wb_table2_30_2Q2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_SedeWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_2Q2e( true) ;
      }
      else
      {
         wb_table2_30_2Q2e( false) ;
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
      pa2Q2( ) ;
      ws2Q2( ) ;
      we2Q2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334749", true, true);
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
      httpContext.AddJavascriptSource("sedeww.js", "?20225110334749", false, true);
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
      edtSedeId_Internalname = "SEDEID_"+sGXsfl_43_idx ;
      edtSedeNombre_Internalname = "SEDENOMBRE_"+sGXsfl_43_idx ;
      edtClinicaId_Internalname = "CLINICAID_"+sGXsfl_43_idx ;
      edtClinicaRUC_Internalname = "CLINICARUC_"+sGXsfl_43_idx ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL_"+sGXsfl_43_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_idx ;
      edtSedeDireccion_Internalname = "SEDEDIRECCION_"+sGXsfl_43_idx ;
      edtSedeCorreo_Internalname = "SEDECORREO_"+sGXsfl_43_idx ;
      cmbSedeEstado.setInternalname( "SEDEESTADO_"+sGXsfl_43_idx );
      cmbSedeTipo.setInternalname( "SEDETIPO_"+sGXsfl_43_idx );
      cmbSedeSector.setInternalname( "SEDESECTOR_"+sGXsfl_43_idx );
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtSedeId_Internalname = "SEDEID_"+sGXsfl_43_fel_idx ;
      edtSedeNombre_Internalname = "SEDENOMBRE_"+sGXsfl_43_fel_idx ;
      edtClinicaId_Internalname = "CLINICAID_"+sGXsfl_43_fel_idx ;
      edtClinicaRUC_Internalname = "CLINICARUC_"+sGXsfl_43_fel_idx ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL_"+sGXsfl_43_fel_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_43_fel_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_43_fel_idx ;
      edtSedeDireccion_Internalname = "SEDEDIRECCION_"+sGXsfl_43_fel_idx ;
      edtSedeCorreo_Internalname = "SEDECORREO_"+sGXsfl_43_fel_idx ;
      cmbSedeEstado.setInternalname( "SEDEESTADO_"+sGXsfl_43_fel_idx );
      cmbSedeTipo.setInternalname( "SEDETIPO_"+sGXsfl_43_fel_idx );
      cmbSedeSector.setInternalname( "SEDESECTOR_"+sGXsfl_43_fel_idx );
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb2Q0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV60Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV61Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSedeId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeId_Internalname,GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSedeId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSedeId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSedeNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeNombre_Internalname,A75SedeNombre,"","","'"+""+"'"+",false,"+"'"+""+"'",edtSedeNombre_Link,"","","",edtSedeNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSedeNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaRUC_Internalname,GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'",edtClinicaRUC_Link,"","","",edtClinicaRUC_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtClinicaRUC_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSedeDireccion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeDireccion_Internalname,A276SedeDireccion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSedeDireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSedeDireccion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSedeCorreo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeCorreo_Internalname,A277SedeCorreo,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A277SedeCorreo,"","","",edtSedeCorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSedeCorreo_Visible),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbSedeEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbSedeEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SEDEESTADO_" + sGXsfl_43_idx ;
            cmbSedeEstado.setName( GXCCtl );
            cmbSedeEstado.setWebtags( "" );
            cmbSedeEstado.addItem("A", "Activo", (short)(0));
            cmbSedeEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbSedeEstado.getItemCount() > 0 )
            {
               A278SedeEstado = cmbSedeEstado.getValidValue(A278SedeEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSedeEstado,cmbSedeEstado.getInternalname(),GXutil.rtrim( A278SedeEstado),Integer.valueOf(1),cmbSedeEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbSedeEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbSedeEstado.setValue( GXutil.rtrim( A278SedeEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeEstado.getInternalname(), "Values", cmbSedeEstado.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbSedeTipo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbSedeTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SEDETIPO_" + sGXsfl_43_idx ;
            cmbSedeTipo.setName( GXCCtl );
            cmbSedeTipo.setWebtags( "" );
            cmbSedeTipo.addItem("", "Seleccione", (short)(0));
            cmbSedeTipo.addItem("H", "Hospital", (short)(0));
            cmbSedeTipo.addItem("C", "Clínica", (short)(0));
            cmbSedeTipo.addItem("P", "Policlínico", (short)(0));
            cmbSedeTipo.addItem("I", "Independiente", (short)(0));
            if ( cmbSedeTipo.getItemCount() > 0 )
            {
               A279SedeTipo = cmbSedeTipo.getValidValue(A279SedeTipo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSedeTipo,cmbSedeTipo.getInternalname(),GXutil.rtrim( A279SedeTipo),Integer.valueOf(1),cmbSedeTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbSedeTipo.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbSedeTipo.setValue( GXutil.rtrim( A279SedeTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipo.getInternalname(), "Values", cmbSedeTipo.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbSedeSector.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbSedeSector.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SEDESECTOR_" + sGXsfl_43_idx ;
            cmbSedeSector.setName( GXCCtl );
            cmbSedeSector.setWebtags( "" );
            cmbSedeSector.addItem("", "Seleccione", (short)(0));
            cmbSedeSector.addItem("P", "Publico", (short)(0));
            cmbSedeSector.addItem("V", "Privado", (short)(0));
            if ( cmbSedeSector.getItemCount() > 0 )
            {
               A280SedeSector = cmbSedeSector.getValidValue(A280SedeSector) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSedeSector,cmbSedeSector.getInternalname(),GXutil.rtrim( A280SedeSector),Integer.valueOf(1),cmbSedeSector.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbSedeSector.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbSedeSector.setValue( GXutil.rtrim( A280SedeSector) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeSector.getInternalname(), "Values", cmbSedeSector.ToJavascriptSource(), !bGXsfl_43_Refreshing);
         send_integrity_lvl_hashes2Q2( ) ;
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
      edtSedeId_Internalname = "SEDEID" ;
      edtSedeNombre_Internalname = "SEDENOMBRE" ;
      edtClinicaId_Internalname = "CLINICAID" ;
      edtClinicaRUC_Internalname = "CLINICARUC" ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL" ;
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      edtSedeDireccion_Internalname = "SEDEDIRECCION" ;
      edtSedeCorreo_Internalname = "SEDECORREO" ;
      cmbSedeEstado.setInternalname( "SEDEESTADO" );
      cmbSedeTipo.setInternalname( "SEDETIPO" );
      cmbSedeSector.setInternalname( "SEDESECTOR" );
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
      cmbSedeSector.setJsonclick( "" );
      cmbSedeTipo.setJsonclick( "" );
      cmbSedeEstado.setJsonclick( "" );
      edtSedeCorreo_Jsonclick = "" ;
      edtSedeDireccion_Jsonclick = "" ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoCode_Jsonclick = "" ;
      edtClinicaNombreComercial_Jsonclick = "" ;
      edtClinicaRUC_Jsonclick = "" ;
      edtClinicaId_Jsonclick = "" ;
      edtSedeNombre_Jsonclick = "" ;
      edtSedeId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtUbigeoNombre_Link = "" ;
      edtClinicaRUC_Link = "" ;
      edtSedeNombre_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbSedeSector.setVisible( -1 );
      cmbSedeTipo.setVisible( -1 );
      cmbSedeEstado.setVisible( -1 );
      edtSedeCorreo_Visible = -1 ;
      edtSedeDireccion_Visible = -1 ;
      edtUbigeoNombre_Visible = -1 ;
      edtUbigeoCode_Visible = -1 ;
      edtClinicaNombreComercial_Visible = -1 ;
      edtClinicaRUC_Visible = -1 ;
      edtClinicaId_Visible = -1 ;
      edtSedeNombre_Visible = -1 ;
      edtSedeId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Sede" );
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
      Ddo_grid_Datalistproc = "SedeWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||||||A:Activo,I:Inactivo|H:Hospital,C:Clínica,P:Policlínico,I:Independiente|P:Publico,V:Privado" ;
      Ddo_grid_Allowmultipleselection = "|||||||||T|T|T" ;
      Ddo_grid_Datalisttype = "|Dynamic|||Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|FixedValues|FixedValues" ;
      Ddo_grid_Includedatalist = "|T|||T|T|T|T|T|T|T|T" ;
      Ddo_grid_Filterisrange = "T||T|T||||||||" ;
      Ddo_grid_Filtertype = "Numeric|Character|Numeric|Numeric|Character|Character|Character|Character|Character|||" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|T|||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T||T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5|6||7|8|9|10|11" ;
      Ddo_grid_Columnids = "2:SedeId|3:SedeNombre|4:ClinicaId|5:ClinicaRUC|6:ClinicaNombreComercial|7:UbigeoCode|8:UbigeoNombre|9:SedeDireccion|10:SedeCorreo|11:SedeEstado|12:SedeTipo|13:SedeSector" ;
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
      GXCCtl = "SEDEESTADO_" + sGXsfl_43_idx ;
      cmbSedeEstado.setName( GXCCtl );
      cmbSedeEstado.setWebtags( "" );
      cmbSedeEstado.addItem("A", "Activo", (short)(0));
      cmbSedeEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbSedeEstado.getItemCount() > 0 )
      {
         A278SedeEstado = cmbSedeEstado.getValidValue(A278SedeEstado) ;
      }
      GXCCtl = "SEDETIPO_" + sGXsfl_43_idx ;
      cmbSedeTipo.setName( GXCCtl );
      cmbSedeTipo.setWebtags( "" );
      cmbSedeTipo.addItem("", "Seleccione", (short)(0));
      cmbSedeTipo.addItem("H", "Hospital", (short)(0));
      cmbSedeTipo.addItem("C", "Clínica", (short)(0));
      cmbSedeTipo.addItem("P", "Policlínico", (short)(0));
      cmbSedeTipo.addItem("I", "Independiente", (short)(0));
      if ( cmbSedeTipo.getItemCount() > 0 )
      {
         A279SedeTipo = cmbSedeTipo.getValidValue(A279SedeTipo) ;
      }
      GXCCtl = "SEDESECTOR_" + sGXsfl_43_idx ;
      cmbSedeSector.setName( GXCCtl );
      cmbSedeSector.setWebtags( "" );
      cmbSedeSector.addItem("", "Seleccione", (short)(0));
      cmbSedeSector.addItem("P", "Publico", (short)(0));
      cmbSedeSector.addItem("V", "Privado", (short)(0));
      if ( cmbSedeSector.getItemCount() > 0 )
      {
         A280SedeSector = cmbSedeSector.getValidValue(A280SedeSector) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtSedeId_Visible',ctrl:'SEDEID',prop:'Visible'},{av:'edtSedeNombre_Visible',ctrl:'SEDENOMBRE',prop:'Visible'},{av:'edtClinicaId_Visible',ctrl:'CLINICAID',prop:'Visible'},{av:'edtClinicaRUC_Visible',ctrl:'CLINICARUC',prop:'Visible'},{av:'edtClinicaNombreComercial_Visible',ctrl:'CLINICANOMBRECOMERCIAL',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtSedeDireccion_Visible',ctrl:'SEDEDIRECCION',prop:'Visible'},{av:'edtSedeCorreo_Visible',ctrl:'SEDECORREO',prop:'Visible'},{av:'cmbSedeEstado'},{av:'cmbSedeTipo'},{av:'cmbSedeSector'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e142Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e212Q2',iparms:[{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A30SedeId',fld:'SEDEID',pic:'ZZZ9',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV60Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV61Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtSedeNombre_Link',ctrl:'SEDENOMBRE',prop:'Link'},{av:'edtClinicaRUC_Link',ctrl:'CLINICARUC',prop:'Link'},{av:'edtUbigeoNombre_Link',ctrl:'UBIGEONOMBRE',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e152Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtSedeId_Visible',ctrl:'SEDEID',prop:'Visible'},{av:'edtSedeNombre_Visible',ctrl:'SEDENOMBRE',prop:'Visible'},{av:'edtClinicaId_Visible',ctrl:'CLINICAID',prop:'Visible'},{av:'edtClinicaRUC_Visible',ctrl:'CLINICARUC',prop:'Visible'},{av:'edtClinicaNombreComercial_Visible',ctrl:'CLINICANOMBRECOMERCIAL',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtSedeDireccion_Visible',ctrl:'SEDEDIRECCION',prop:'Visible'},{av:'edtSedeCorreo_Visible',ctrl:'SEDECORREO',prop:'Visible'},{av:'cmbSedeEstado'},{av:'cmbSedeTipo'},{av:'cmbSedeSector'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtSedeId_Visible',ctrl:'SEDEID',prop:'Visible'},{av:'edtSedeNombre_Visible',ctrl:'SEDENOMBRE',prop:'Visible'},{av:'edtClinicaId_Visible',ctrl:'CLINICAID',prop:'Visible'},{av:'edtClinicaRUC_Visible',ctrl:'CLINICARUC',prop:'Visible'},{av:'edtClinicaNombreComercial_Visible',ctrl:'CLINICANOMBRECOMERCIAL',prop:'Visible'},{av:'edtUbigeoCode_Visible',ctrl:'UBIGEOCODE',prop:'Visible'},{av:'edtUbigeoNombre_Visible',ctrl:'UBIGEONOMBRE',prop:'Visible'},{av:'edtSedeDireccion_Visible',ctrl:'SEDEDIRECCION',prop:'Visible'},{av:'edtSedeCorreo_Visible',ctrl:'SEDECORREO',prop:'Visible'},{av:'cmbSedeEstado'},{av:'cmbSedeTipo'},{av:'cmbSedeSector'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e162Q2',iparms:[{av:'A30SedeId',fld:'SEDEID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e172Q2',iparms:[{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e182Q2',iparms:[{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFSedeId',fld:'vTFSEDEID',pic:'ZZZ9'},{av:'AV28TFSedeId_To',fld:'vTFSEDEID_TO',pic:'ZZZ9'},{av:'AV29TFSedeNombre',fld:'vTFSEDENOMBRE',pic:''},{av:'AV30TFSedeNombre_Sel',fld:'vTFSEDENOMBRE_SEL',pic:''},{av:'AV31TFClinicaId',fld:'vTFCLINICAID',pic:'ZZZ9'},{av:'AV32TFClinicaId_To',fld:'vTFCLINICAID_TO',pic:'ZZZ9'},{av:'AV33TFClinicaRUC',fld:'vTFCLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'AV34TFClinicaRUC_To',fld:'vTFCLINICARUC_TO',pic:'ZZZZZZZZZZ9'},{av:'AV35TFClinicaNombreComercial',fld:'vTFCLINICANOMBRECOMERCIAL',pic:''},{av:'AV36TFClinicaNombreComercial_Sel',fld:'vTFCLINICANOMBRECOMERCIAL_SEL',pic:''},{av:'AV37TFUbigeoCode',fld:'vTFUBIGEOCODE',pic:''},{av:'AV38TFUbigeoCode_Sel',fld:'vTFUBIGEOCODE_SEL',pic:''},{av:'AV39TFUbigeoNombre',fld:'vTFUBIGEONOMBRE',pic:''},{av:'AV40TFUbigeoNombre_Sel',fld:'vTFUBIGEONOMBRE_SEL',pic:''},{av:'AV41TFSedeDireccion',fld:'vTFSEDEDIRECCION',pic:''},{av:'AV42TFSedeDireccion_Sel',fld:'vTFSEDEDIRECCION_SEL',pic:''},{av:'AV43TFSedeCorreo',fld:'vTFSEDECORREO',pic:''},{av:'AV44TFSedeCorreo_Sel',fld:'vTFSEDECORREO_SEL',pic:''},{av:'AV46TFSedeEstado_Sels',fld:'vTFSEDEESTADO_SELS',pic:''},{av:'AV48TFSedeTipo_Sels',fld:'vTFSEDETIPO_SELS',pic:''},{av:'AV50TFSedeSector_Sels',fld:'vTFSEDESECTOR_SELS',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV56IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV58IsAuthorized_ClinicaRUC',fld:'vISAUTHORIZED_CLINICARUC',pic:'',hsh:true},{av:'AV62IsAuthorized_UbigeoNombre',fld:'vISAUTHORIZED_UBIGEONOMBRE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV49TFSedeSector_SelsJson',fld:'vTFSEDESECTOR_SELSJSON',pic:''},{av:'AV47TFSedeTipo_SelsJson',fld:'vTFSEDETIPO_SELSJSON',pic:''},{av:'AV45TFSedeEstado_SelsJson',fld:'vTFSEDEESTADO_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_CLINICAID","{handler:'valid_Clinicaid',iparms:[]");
      setEventMetadata("VALID_CLINICAID",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Sedesector',iparms:[]");
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
      AV29TFSedeNombre = "" ;
      AV30TFSedeNombre_Sel = "" ;
      AV35TFClinicaNombreComercial = "" ;
      AV36TFClinicaNombreComercial_Sel = "" ;
      AV37TFUbigeoCode = "" ;
      AV38TFUbigeoCode_Sel = "" ;
      AV39TFUbigeoNombre = "" ;
      AV40TFUbigeoNombre_Sel = "" ;
      AV41TFSedeDireccion = "" ;
      AV42TFSedeDireccion_Sel = "" ;
      AV43TFSedeCorreo = "" ;
      AV44TFSedeCorreo_Sel = "" ;
      AV46TFSedeEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFSedeTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFSedeSector_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87Pgmname = "" ;
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
      AV51DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45TFSedeEstado_SelsJson = "" ;
      AV47TFSedeTipo_SelsJson = "" ;
      AV49TFSedeSector_SelsJson = "" ;
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
      AV60Update = "" ;
      AV61Delete = "" ;
      A75SedeNombre = "" ;
      A116ClinicaNombreComercial = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A276SedeDireccion = "" ;
      A277SedeCorreo = "" ;
      A278SedeEstado = "" ;
      A279SedeTipo = "" ;
      A280SedeSector = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV84Sedewwds_20_tfsedeestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV85Sedewwds_21_tfsedetipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV86Sedewwds_22_tfsedesector_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV65Sedewwds_1_filterfulltext = "" ;
      lV68Sedewwds_4_tfsedenombre = "" ;
      lV74Sedewwds_10_tfclinicanombrecomercial = "" ;
      lV76Sedewwds_12_tfubigeocode = "" ;
      lV78Sedewwds_14_tfubigeonombre = "" ;
      lV80Sedewwds_16_tfsededireccion = "" ;
      lV82Sedewwds_18_tfsedecorreo = "" ;
      AV69Sedewwds_5_tfsedenombre_sel = "" ;
      AV68Sedewwds_4_tfsedenombre = "" ;
      AV75Sedewwds_11_tfclinicanombrecomercial_sel = "" ;
      AV74Sedewwds_10_tfclinicanombrecomercial = "" ;
      AV77Sedewwds_13_tfubigeocode_sel = "" ;
      AV76Sedewwds_12_tfubigeocode = "" ;
      AV79Sedewwds_15_tfubigeonombre_sel = "" ;
      AV78Sedewwds_14_tfubigeonombre = "" ;
      AV81Sedewwds_17_tfsededireccion_sel = "" ;
      AV80Sedewwds_16_tfsededireccion = "" ;
      AV83Sedewwds_19_tfsedecorreo_sel = "" ;
      AV82Sedewwds_18_tfsedecorreo = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      AV65Sedewwds_1_filterfulltext = "" ;
      H002Q2_A280SedeSector = new String[] {""} ;
      H002Q2_A279SedeTipo = new String[] {""} ;
      H002Q2_A278SedeEstado = new String[] {""} ;
      H002Q2_A277SedeCorreo = new String[] {""} ;
      H002Q2_A276SedeDireccion = new String[] {""} ;
      H002Q2_A185UbigeoNombre = new String[] {""} ;
      H002Q2_A44UbigeoCode = new String[] {""} ;
      H002Q2_A116ClinicaNombreComercial = new String[] {""} ;
      H002Q2_A118ClinicaRUC = new long[1] ;
      H002Q2_A28ClinicaId = new short[1] ;
      H002Q2_A75SedeNombre = new String[] {""} ;
      H002Q2_A30SedeId = new short[1] ;
      H002Q2_A186UbigeoDepartamento = new String[] {""} ;
      H002Q2_A187UbigeoProvincia = new String[] {""} ;
      H002Q2_A188UbigeoDistrito = new String[] {""} ;
      H002Q3_AGRID_nRecordCount = new long[1] ;
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
      GXv_SdtWWPGridState28 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sedeww__default(),
         new Object[] {
             new Object[] {
            H002Q2_A280SedeSector, H002Q2_A279SedeTipo, H002Q2_A278SedeEstado, H002Q2_A277SedeCorreo, H002Q2_A276SedeDireccion, H002Q2_A185UbigeoNombre, H002Q2_A44UbigeoCode, H002Q2_A116ClinicaNombreComercial, H002Q2_A118ClinicaRUC, H002Q2_A28ClinicaId,
            H002Q2_A75SedeNombre, H002Q2_A30SedeId, H002Q2_A186UbigeoDepartamento, H002Q2_A187UbigeoProvincia, H002Q2_A188UbigeoDistrito
            }
            , new Object[] {
            H002Q3_AGRID_nRecordCount
            }
         }
      );
      AV87Pgmname = "SedeWW" ;
      /* GeneXus formulas. */
      AV87Pgmname = "SedeWW" ;
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
   private short AV27TFSedeId ;
   private short AV28TFSedeId_To ;
   private short AV31TFClinicaId ;
   private short AV32TFClinicaId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A30SedeId ;
   private short A28ClinicaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV66Sedewwds_2_tfsedeid ;
   private short AV67Sedewwds_3_tfsedeid_to ;
   private short AV70Sedewwds_6_tfclinicaid ;
   private short AV71Sedewwds_7_tfclinicaid_to ;
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
   private int edtSedeId_Visible ;
   private int edtSedeNombre_Visible ;
   private int edtClinicaId_Visible ;
   private int edtClinicaRUC_Visible ;
   private int edtClinicaNombreComercial_Visible ;
   private int edtUbigeoCode_Visible ;
   private int edtUbigeoNombre_Visible ;
   private int edtSedeDireccion_Visible ;
   private int edtSedeCorreo_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV84Sedewwds_20_tfsedeestado_sels_size ;
   private int AV85Sedewwds_21_tfsedetipo_sels_size ;
   private int AV86Sedewwds_22_tfsedesector_sels_size ;
   private int AV52PageToGo ;
   private int AV88GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV33TFClinicaRUC ;
   private long AV34TFClinicaRUC_To ;
   private long AV53GridCurrentPage ;
   private long AV54GridPageCount ;
   private long A118ClinicaRUC ;
   private long GRID_nCurrentRecord ;
   private long AV72Sedewwds_8_tfclinicaruc ;
   private long AV73Sedewwds_9_tfclinicaruc_to ;
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
   private String AV37TFUbigeoCode ;
   private String AV38TFUbigeoCode_Sel ;
   private String AV87Pgmname ;
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
   private String AV60Update ;
   private String edtavUpdate_Link ;
   private String AV61Delete ;
   private String edtavDelete_Link ;
   private String edtSedeNombre_Link ;
   private String edtClinicaRUC_Link ;
   private String A44UbigeoCode ;
   private String edtUbigeoNombre_Link ;
   private String A278SedeEstado ;
   private String A279SedeTipo ;
   private String A280SedeSector ;
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
   private String edtSedeId_Internalname ;
   private String edtSedeNombre_Internalname ;
   private String edtClinicaId_Internalname ;
   private String edtClinicaRUC_Internalname ;
   private String edtClinicaNombreComercial_Internalname ;
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoNombre_Internalname ;
   private String edtSedeDireccion_Internalname ;
   private String edtSedeCorreo_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String lV76Sedewwds_12_tfubigeocode ;
   private String AV77Sedewwds_13_tfubigeocode_sel ;
   private String AV76Sedewwds_12_tfubigeocode ;
   private String GXt_char6 ;
   private String GXv_char8[] ;
   private String GXt_char13 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
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
   private String edtSedeId_Jsonclick ;
   private String edtSedeNombre_Jsonclick ;
   private String edtClinicaId_Jsonclick ;
   private String edtClinicaRUC_Jsonclick ;
   private String edtClinicaNombreComercial_Jsonclick ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoNombre_Jsonclick ;
   private String edtSedeDireccion_Jsonclick ;
   private String edtSedeCorreo_Jsonclick ;
   private String GXCCtl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV56IsAuthorized_Update ;
   private boolean AV57IsAuthorized_Delete ;
   private boolean AV58IsAuthorized_ClinicaRUC ;
   private boolean AV62IsAuthorized_UbigeoNombre ;
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
   private boolean AV59TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV45TFSedeEstado_SelsJson ;
   private String AV47TFSedeTipo_SelsJson ;
   private String AV49TFSedeSector_SelsJson ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV29TFSedeNombre ;
   private String AV30TFSedeNombre_Sel ;
   private String AV35TFClinicaNombreComercial ;
   private String AV36TFClinicaNombreComercial_Sel ;
   private String AV39TFUbigeoNombre ;
   private String AV40TFUbigeoNombre_Sel ;
   private String AV41TFSedeDireccion ;
   private String AV42TFSedeDireccion_Sel ;
   private String AV43TFSedeCorreo ;
   private String AV44TFSedeCorreo_Sel ;
   private String A75SedeNombre ;
   private String A116ClinicaNombreComercial ;
   private String A185UbigeoNombre ;
   private String A276SedeDireccion ;
   private String A277SedeCorreo ;
   private String lV65Sedewwds_1_filterfulltext ;
   private String lV68Sedewwds_4_tfsedenombre ;
   private String lV74Sedewwds_10_tfclinicanombrecomercial ;
   private String lV78Sedewwds_14_tfubigeonombre ;
   private String lV80Sedewwds_16_tfsededireccion ;
   private String lV82Sedewwds_18_tfsedecorreo ;
   private String AV69Sedewwds_5_tfsedenombre_sel ;
   private String AV68Sedewwds_4_tfsedenombre ;
   private String AV75Sedewwds_11_tfclinicanombrecomercial_sel ;
   private String AV74Sedewwds_10_tfclinicanombrecomercial ;
   private String AV79Sedewwds_15_tfubigeonombre_sel ;
   private String AV78Sedewwds_14_tfubigeonombre ;
   private String AV81Sedewwds_17_tfsededireccion_sel ;
   private String AV80Sedewwds_16_tfsededireccion ;
   private String AV83Sedewwds_19_tfsedecorreo_sel ;
   private String AV82Sedewwds_18_tfsedecorreo ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String AV65Sedewwds_1_filterfulltext ;
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
   private GXSimpleCollection<String> AV84Sedewwds_20_tfsedeestado_sels ;
   private GXSimpleCollection<String> AV85Sedewwds_21_tfsedetipo_sels ;
   private GXSimpleCollection<String> AV86Sedewwds_22_tfsedesector_sels ;
   private HTMLChoice cmbSedeEstado ;
   private HTMLChoice cmbSedeTipo ;
   private HTMLChoice cmbSedeSector ;
   private IDataStoreProvider pr_default ;
   private String[] H002Q2_A280SedeSector ;
   private String[] H002Q2_A279SedeTipo ;
   private String[] H002Q2_A278SedeEstado ;
   private String[] H002Q2_A277SedeCorreo ;
   private String[] H002Q2_A276SedeDireccion ;
   private String[] H002Q2_A185UbigeoNombre ;
   private String[] H002Q2_A44UbigeoCode ;
   private String[] H002Q2_A116ClinicaNombreComercial ;
   private long[] H002Q2_A118ClinicaRUC ;
   private short[] H002Q2_A28ClinicaId ;
   private String[] H002Q2_A75SedeNombre ;
   private short[] H002Q2_A30SedeId ;
   private String[] H002Q2_A186UbigeoDepartamento ;
   private String[] H002Q2_A187UbigeoProvincia ;
   private String[] H002Q2_A188UbigeoDistrito ;
   private long[] H002Q3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV46TFSedeEstado_Sels ;
   private GXSimpleCollection<String> AV48TFSedeTipo_Sels ;
   private GXSimpleCollection<String> AV50TFSedeSector_Sels ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState28[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV51DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class sedeww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002Q2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV84Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV85Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV86Sedewwds_22_tfsedesector_sels ,
                                          short AV66Sedewwds_2_tfsedeid ,
                                          short AV67Sedewwds_3_tfsedeid_to ,
                                          String AV69Sedewwds_5_tfsedenombre_sel ,
                                          String AV68Sedewwds_4_tfsedenombre ,
                                          short AV70Sedewwds_6_tfclinicaid ,
                                          short AV71Sedewwds_7_tfclinicaid_to ,
                                          long AV72Sedewwds_8_tfclinicaruc ,
                                          long AV73Sedewwds_9_tfclinicaruc_to ,
                                          String AV75Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV74Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV77Sedewwds_13_tfubigeocode_sel ,
                                          String AV76Sedewwds_12_tfubigeocode ,
                                          String AV79Sedewwds_15_tfubigeonombre_sel ,
                                          String AV78Sedewwds_14_tfubigeonombre ,
                                          String AV81Sedewwds_17_tfsededireccion_sel ,
                                          String AV80Sedewwds_16_tfsededireccion ,
                                          String AV83Sedewwds_19_tfsedecorreo_sel ,
                                          String AV82Sedewwds_18_tfsedecorreo ,
                                          int AV84Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV85Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV86Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV65Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[41];
      Object[] GXv_Object30 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion], T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito]" ;
      sSelectString += " AS UbigeoNombre, T1.[UbigeoCode], T3.[ClinicaNombreComercial], T3.[ClinicaRUC], T1.[ClinicaId], T1.[SedeNombre], T1.[SedeId], T2.[UbigeoDepartamento], T2.[UbigeoProvincia]," ;
      sSelectString += " T2.[UbigeoDistrito]" ;
      sFromString = " FROM (([Sede] T1 INNER JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T1.[ClinicaId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T3.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV66Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int29[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int29[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV68Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int29[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int29[23] = (byte)(1) ;
      }
      if ( ! (0==AV70Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int29[24] = (byte)(1) ;
      }
      if ( ! (0==AV71Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int29[25] = (byte)(1) ;
      }
      if ( ! (0==AV72Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T3.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int29[26] = (byte)(1) ;
      }
      if ( ! (0==AV73Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T3.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int29[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV74Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int29[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int29[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV76Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int29[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int29[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV79Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV78Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int29[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int29[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV80Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int29[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int29[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV82Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int29[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int29[37] = (byte)(1) ;
      }
      if ( AV84Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV84Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV85Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV85Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV86Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV86Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeNombre]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ClinicaId]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ClinicaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ClinicaRUC]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ClinicaRUC] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[ClinicaNombreComercial]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[ClinicaNombreComercial] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeDireccion]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeDireccion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeCorreo]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeCorreo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeEstado]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeEstado] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeTipo]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeTipo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SedeSector]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SedeSector] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[SedeId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
   }

   protected Object[] conditional_H002Q3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV84Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV85Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV86Sedewwds_22_tfsedesector_sels ,
                                          short AV66Sedewwds_2_tfsedeid ,
                                          short AV67Sedewwds_3_tfsedeid_to ,
                                          String AV69Sedewwds_5_tfsedenombre_sel ,
                                          String AV68Sedewwds_4_tfsedenombre ,
                                          short AV70Sedewwds_6_tfclinicaid ,
                                          short AV71Sedewwds_7_tfclinicaid_to ,
                                          long AV72Sedewwds_8_tfclinicaruc ,
                                          long AV73Sedewwds_9_tfclinicaruc_to ,
                                          String AV75Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV74Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV77Sedewwds_13_tfubigeocode_sel ,
                                          String AV76Sedewwds_12_tfubigeocode ,
                                          String AV79Sedewwds_15_tfubigeonombre_sel ,
                                          String AV78Sedewwds_14_tfubigeonombre ,
                                          String AV81Sedewwds_17_tfsededireccion_sel ,
                                          String AV80Sedewwds_16_tfsededireccion ,
                                          String AV83Sedewwds_19_tfsedecorreo_sel ,
                                          String AV82Sedewwds_18_tfsedecorreo ,
                                          int AV84Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV85Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV86Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV65Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int32 = new byte[38];
      Object[] GXv_Object33 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Sede] T1 INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV66Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int32[20] = (byte)(1) ;
      }
      if ( ! (0==AV67Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int32[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV68Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int32[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int32[23] = (byte)(1) ;
      }
      if ( ! (0==AV70Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int32[24] = (byte)(1) ;
      }
      if ( ! (0==AV71Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int32[25] = (byte)(1) ;
      }
      if ( ! (0==AV72Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int32[26] = (byte)(1) ;
      }
      if ( ! (0==AV73Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int32[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV74Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int32[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int32[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV76Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int32[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int32[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV79Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV78Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int32[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int32[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV80Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int32[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int32[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV82Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int32[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int32[37] = (byte)(1) ;
      }
      if ( AV84Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV84Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV85Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV85Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV86Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV86Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object33[0] = scmdbuf ;
      GXv_Object33[1] = GXv_int32 ;
      return GXv_Object33 ;
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
                  return conditional_H002Q2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , (String)dynConstraints[40] , (String)dynConstraints[41] );
            case 1 :
                  return conditional_H002Q3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , (String)dynConstraints[40] , (String)dynConstraints[41] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002Q2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Q3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
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
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[61]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[65]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[66]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[67]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[68]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[71], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[72], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[79]).intValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[80]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[81]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
      }
   }

}

