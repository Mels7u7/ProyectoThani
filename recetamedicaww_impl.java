package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class recetamedicaww_impl extends GXDataArea
{
   public recetamedicaww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public recetamedicaww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recetamedicaww_impl.class ));
   }

   public recetamedicaww_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
            AV27TFRecetaMedicaId = (short)(GXutil.lval( httpContext.GetPar( "TFRecetaMedicaId"))) ;
            AV28TFRecetaMedicaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFRecetaMedicaId_To"))) ;
            AV29TFCitaId = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId"))) ;
            AV30TFCitaId_To = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId_To"))) ;
            AV31TFMedicamentoId = (short)(GXutil.lval( httpContext.GetPar( "TFMedicamentoId"))) ;
            AV32TFMedicamentoId_To = (short)(GXutil.lval( httpContext.GetPar( "TFMedicamentoId_To"))) ;
            AV33TFMedicamentoCodigo = httpContext.GetPar( "TFMedicamentoCodigo") ;
            AV34TFMedicamentoCodigo_Sel = httpContext.GetPar( "TFMedicamentoCodigo_Sel") ;
            AV35TFMedicamentoNombre = httpContext.GetPar( "TFMedicamentoNombre") ;
            AV36TFMedicamentoNombre_Sel = httpContext.GetPar( "TFMedicamentoNombre_Sel") ;
            AV37TFMedicamentoFormaFarm = httpContext.GetPar( "TFMedicamentoFormaFarm") ;
            AV38TFMedicamentoFormaFarm_Sel = httpContext.GetPar( "TFMedicamentoFormaFarm_Sel") ;
            AV39TFRecetaMedicaConcentracion = httpContext.GetPar( "TFRecetaMedicaConcentracion") ;
            AV40TFRecetaMedicaConcentracion_Sel = httpContext.GetPar( "TFRecetaMedicaConcentracion_Sel") ;
            AV41TFRecetaMedicaCantidad = (short)(GXutil.lval( httpContext.GetPar( "TFRecetaMedicaCantidad"))) ;
            AV42TFRecetaMedicaCantidad_To = (short)(GXutil.lval( httpContext.GetPar( "TFRecetaMedicaCantidad_To"))) ;
            AV43TFRecetaMedicaAtencion = httpContext.GetPar( "TFRecetaMedicaAtencion") ;
            AV44TFRecetaMedicaAtencion_Sel = httpContext.GetPar( "TFRecetaMedicaAtencion_Sel") ;
            AV47TFRecetaMedicaFlag = (byte)(GXutil.lval( httpContext.GetPar( "TFRecetaMedicaFlag"))) ;
            AV48TFRecetaMedicaFlag_To = (byte)(GXutil.lval( httpContext.GetPar( "TFRecetaMedicaFlag_To"))) ;
            AV60TFRecetaIndicaciones = httpContext.GetPar( "TFRecetaIndicaciones") ;
            AV61TFRecetaIndicaciones_Sel = httpContext.GetPar( "TFRecetaIndicaciones_Sel") ;
            AV87Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV54IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV56IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            AV59IsAuthorized_MedicamentoCodigo = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_MedicamentoCodigo")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFRecetaMedicaId, AV28TFRecetaMedicaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFMedicamentoId, AV32TFMedicamentoId_To, AV33TFMedicamentoCodigo, AV34TFMedicamentoCodigo_Sel, AV35TFMedicamentoNombre, AV36TFMedicamentoNombre_Sel, AV37TFMedicamentoFormaFarm, AV38TFMedicamentoFormaFarm_Sel, AV39TFRecetaMedicaConcentracion, AV40TFRecetaMedicaConcentracion_Sel, AV41TFRecetaMedicaCantidad, AV42TFRecetaMedicaCantidad_To, AV43TFRecetaMedicaAtencion, AV44TFRecetaMedicaAtencion_Sel, AV47TFRecetaMedicaFlag, AV48TFRecetaMedicaFlag_To, AV60TFRecetaIndicaciones, AV61TFRecetaIndicaciones_Sel, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV54IsAuthorized_Update, AV56IsAuthorized_Delete, AV59IsAuthorized_MedicamentoCodigo) ;
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
      pa2D2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2D2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110333837", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.recetamedicaww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV54IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV56IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MEDICAMENTOCODIGO", getSecureSignedToken( "", AV59IsAuthorized_MedicamentoCodigo));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV51GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV52GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV49DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV49DDO_TitleSettingsIcons);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICAID", GXutil.ltrim( localUtil.ntoc( AV27TFRecetaMedicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICAID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFRecetaMedicaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID", GXutil.ltrim( localUtil.ntoc( AV29TFCitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID_TO", GXutil.ltrim( localUtil.ntoc( AV30TFCitaId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTOID", GXutil.ltrim( localUtil.ntoc( AV31TFMedicamentoId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTOID_TO", GXutil.ltrim( localUtil.ntoc( AV32TFMedicamentoId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTOCODIGO", AV33TFMedicamentoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTOCODIGO_SEL", AV34TFMedicamentoCodigo_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTONOMBRE", AV35TFMedicamentoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTONOMBRE_SEL", AV36TFMedicamentoNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTOFORMAFARM", AV37TFMedicamentoFormaFarm);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFMEDICAMENTOFORMAFARM_SEL", AV38TFMedicamentoFormaFarm_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICACONCENTRACION", AV39TFRecetaMedicaConcentracion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICACONCENTRACION_SEL", AV40TFRecetaMedicaConcentracion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICACANTIDAD", GXutil.ltrim( localUtil.ntoc( AV41TFRecetaMedicaCantidad, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICACANTIDAD_TO", GXutil.ltrim( localUtil.ntoc( AV42TFRecetaMedicaCantidad_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICAATENCION", AV43TFRecetaMedicaAtencion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICAATENCION_SEL", AV44TFRecetaMedicaAtencion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICAFLAG", GXutil.ltrim( localUtil.ntoc( AV47TFRecetaMedicaFlag, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAMEDICAFLAG_TO", GXutil.ltrim( localUtil.ntoc( AV48TFRecetaMedicaFlag_To, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAINDICACIONES", AV60TFRecetaIndicaciones);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFRECETAINDICACIONES_SEL", AV61TFRecetaIndicaciones_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV54IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV54IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV56IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV56IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_MEDICAMENTOCODIGO", AV59IsAuthorized_MedicamentoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MEDICAMENTOCODIGO", getSecureSignedToken( "", AV59IsAuthorized_MedicamentoCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
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
         we2D2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2D2( ) ;
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
      return formatLink("com.projectthani.recetamedicaww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "RecetaMedicaWW" ;
   }

   public String getPgmdesc( )
   {
      return " Receta Medica" ;
   }

   public void wb2D0( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_2D2( true) ;
      }
      else
      {
         wb_table1_25_2D2( false) ;
      }
      return  ;
   }

   public void wb_table1_25_2D2e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtRecetaMedicaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medica Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCitaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Cita Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMedicamentoId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medicamento Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMedicamentoCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medicamento Codigo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMedicamentoNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medicamento Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMedicamentoFormaFarm_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medicamento Forma Farm") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtRecetaMedicaConcentracion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medica Concentracion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtRecetaMedicaCantidad_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medica Cantidad") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtRecetaMedicaAtencion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medica Atencion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Image"+"\" "+" style=\""+((edtRecetaMedicaArchivo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medica Archivo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtRecetaMedicaFlag_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Medica Flag") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtRecetaIndicaciones_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Indicaciones") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV53Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV55Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A50RecetaMedicaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaMedicaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCitaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A42MedicamentoId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMedicamentoId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A229MedicamentoCodigo);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtMedicamentoCodigo_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMedicamentoCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A230MedicamentoNombre);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMedicamentoNombre_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A231MedicamentoFormaFarm);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMedicamentoFormaFarm_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A268RecetaMedicaConcentracion);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtRecetaMedicaConcentracion_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaMedicaConcentracion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A269RecetaMedicaCantidad, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaMedicaCantidad_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A273RecetaMedicaAtencion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaMedicaAtencion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A270RecetaMedicaArchivo);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaMedicaArchivo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A267RecetaMedicaNombreArchivo);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A272RecetaMedicaFlag, (byte)(1), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaMedicaFlag_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A332RecetaIndicaciones);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtRecetaIndicaciones_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A271RecetaArchivoTipo);
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
         ucGridpaginationbar.setProperty("CurrentPage", AV51GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV52GridPageCount);
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
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV49DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV49DDO_TitleSettingsIcons);
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

   public void start2D2( )
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
         Form.getMeta().addItem("description", " Receta Medica", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2D0( ) ;
   }

   public void ws2D2( )
   {
      start2D2( ) ;
      evt2D2( ) ;
   }

   public void evt2D2( )
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
                           e112D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e162D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e172D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e182D2 ();
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
                           AV53Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV53Update);
                           AV55Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV55Delete);
                           A50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaId_Internalname), ",", ".")) ;
                           A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
                           A42MedicamentoId = (short)(localUtil.ctol( httpContext.cgiGet( edtMedicamentoId_Internalname), ",", ".")) ;
                           n42MedicamentoId = false ;
                           A229MedicamentoCodigo = httpContext.cgiGet( edtMedicamentoCodigo_Internalname) ;
                           A230MedicamentoNombre = httpContext.cgiGet( edtMedicamentoNombre_Internalname) ;
                           A231MedicamentoFormaFarm = httpContext.cgiGet( edtMedicamentoFormaFarm_Internalname) ;
                           n231MedicamentoFormaFarm = false ;
                           A268RecetaMedicaConcentracion = httpContext.cgiGet( edtRecetaMedicaConcentracion_Internalname) ;
                           n268RecetaMedicaConcentracion = false ;
                           A269RecetaMedicaCantidad = (short)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaCantidad_Internalname), ",", ".")) ;
                           n269RecetaMedicaCantidad = false ;
                           A273RecetaMedicaAtencion = httpContext.cgiGet( edtRecetaMedicaAtencion_Internalname) ;
                           n273RecetaMedicaAtencion = false ;
                           A270RecetaMedicaArchivo = httpContext.cgiGet( edtRecetaMedicaArchivo_Internalname) ;
                           n270RecetaMedicaArchivo = false ;
                           httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), !bGXsfl_43_Refreshing);
                           A272RecetaMedicaFlag = (byte)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaFlag_Internalname), ",", ".")) ;
                           n272RecetaMedicaFlag = false ;
                           A332RecetaIndicaciones = httpContext.cgiGet( edtRecetaIndicaciones_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e192D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e202D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e212D2 ();
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

   public void we2D2( )
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

   public void pa2D2( )
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
                                 short AV27TFRecetaMedicaId ,
                                 short AV28TFRecetaMedicaId_To ,
                                 int AV29TFCitaId ,
                                 int AV30TFCitaId_To ,
                                 short AV31TFMedicamentoId ,
                                 short AV32TFMedicamentoId_To ,
                                 String AV33TFMedicamentoCodigo ,
                                 String AV34TFMedicamentoCodigo_Sel ,
                                 String AV35TFMedicamentoNombre ,
                                 String AV36TFMedicamentoNombre_Sel ,
                                 String AV37TFMedicamentoFormaFarm ,
                                 String AV38TFMedicamentoFormaFarm_Sel ,
                                 String AV39TFRecetaMedicaConcentracion ,
                                 String AV40TFRecetaMedicaConcentracion_Sel ,
                                 short AV41TFRecetaMedicaCantidad ,
                                 short AV42TFRecetaMedicaCantidad_To ,
                                 String AV43TFRecetaMedicaAtencion ,
                                 String AV44TFRecetaMedicaAtencion_Sel ,
                                 byte AV47TFRecetaMedicaFlag ,
                                 byte AV48TFRecetaMedicaFlag_To ,
                                 String AV60TFRecetaIndicaciones ,
                                 String AV61TFRecetaIndicaciones_Sel ,
                                 String AV87Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV54IsAuthorized_Update ,
                                 boolean AV56IsAuthorized_Delete ,
                                 boolean AV59IsAuthorized_MedicamentoCodigo )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e202D2 ();
      GRID_nCurrentRecord = 0 ;
      rf2D2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_RECETAMEDICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RECETAMEDICAID", GXutil.ltrim( localUtil.ntoc( A50RecetaMedicaId, (byte)(4), (byte)(0), ".", "")));
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
      rf2D2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV87Pgmname = "RecetaMedicaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf2D2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e202D2 ();
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
                                              AV64Recetamedicawwds_1_filterfulltext ,
                                              Short.valueOf(AV65Recetamedicawwds_2_tfrecetamedicaid) ,
                                              Short.valueOf(AV66Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                              Integer.valueOf(AV67Recetamedicawwds_4_tfcitaid) ,
                                              Integer.valueOf(AV68Recetamedicawwds_5_tfcitaid_to) ,
                                              Short.valueOf(AV69Recetamedicawwds_6_tfmedicamentoid) ,
                                              Short.valueOf(AV70Recetamedicawwds_7_tfmedicamentoid_to) ,
                                              AV72Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                              AV71Recetamedicawwds_8_tfmedicamentocodigo ,
                                              AV74Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                              AV73Recetamedicawwds_10_tfmedicamentonombre ,
                                              AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                              AV75Recetamedicawwds_12_tfmedicamentoformafarm ,
                                              AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                              AV77Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                              Short.valueOf(AV79Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                              Short.valueOf(AV80Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                              AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                              AV81Recetamedicawwds_18_tfrecetamedicaatencion ,
                                              Byte.valueOf(AV83Recetamedicawwds_20_tfrecetamedicaflag) ,
                                              Byte.valueOf(AV84Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                              AV86Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                              AV85Recetamedicawwds_22_tfrecetaindicaciones ,
                                              Short.valueOf(A50RecetaMedicaId) ,
                                              Integer.valueOf(A19CitaId) ,
                                              Short.valueOf(A42MedicamentoId) ,
                                              A229MedicamentoCodigo ,
                                              A230MedicamentoNombre ,
                                              A231MedicamentoFormaFarm ,
                                              A268RecetaMedicaConcentracion ,
                                              Short.valueOf(A269RecetaMedicaCantidad) ,
                                              A273RecetaMedicaAtencion ,
                                              Byte.valueOf(A272RecetaMedicaFlag) ,
                                              A332RecetaIndicaciones ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
         lV71Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
         lV73Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV73Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
         lV75Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
         lV77Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV77Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
         lV81Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV81Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
         lV85Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV85Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
         /* Using cursor H002D2 */
         pr_default.execute(0, new Object[] {lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, Short.valueOf(AV65Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV66Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV67Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV68Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV69Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV70Recetamedicawwds_7_tfmedicamentoid_to), lV71Recetamedicawwds_8_tfmedicamentocodigo, AV72Recetamedicawwds_9_tfmedicamentocodigo_sel, lV73Recetamedicawwds_10_tfmedicamentonombre, AV74Recetamedicawwds_11_tfmedicamentonombre_sel, lV75Recetamedicawwds_12_tfmedicamentoformafarm, AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV77Recetamedicawwds_14_tfrecetamedicaconcentracion, AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV79Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV80Recetamedicawwds_17_tfrecetamedicacantidad_to), lV81Recetamedicawwds_18_tfrecetamedicaatencion, AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV83Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV84Recetamedicawwds_21_tfrecetamedicaflag_to), lV85Recetamedicawwds_22_tfrecetaindicaciones, AV86Recetamedicawwds_23_tfrecetaindicaciones_sel, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A267RecetaMedicaNombreArchivo = H002D2_A267RecetaMedicaNombreArchivo[0] ;
            n267RecetaMedicaNombreArchivo = H002D2_n267RecetaMedicaNombreArchivo[0] ;
            edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
            A271RecetaArchivoTipo = H002D2_A271RecetaArchivoTipo[0] ;
            edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
            httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, !bGXsfl_43_Refreshing);
            A332RecetaIndicaciones = H002D2_A332RecetaIndicaciones[0] ;
            A272RecetaMedicaFlag = H002D2_A272RecetaMedicaFlag[0] ;
            n272RecetaMedicaFlag = H002D2_n272RecetaMedicaFlag[0] ;
            A270RecetaMedicaArchivo = H002D2_A270RecetaMedicaArchivo[0] ;
            n270RecetaMedicaArchivo = H002D2_n270RecetaMedicaArchivo[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), !bGXsfl_43_Refreshing);
            A273RecetaMedicaAtencion = H002D2_A273RecetaMedicaAtencion[0] ;
            n273RecetaMedicaAtencion = H002D2_n273RecetaMedicaAtencion[0] ;
            A269RecetaMedicaCantidad = H002D2_A269RecetaMedicaCantidad[0] ;
            n269RecetaMedicaCantidad = H002D2_n269RecetaMedicaCantidad[0] ;
            A268RecetaMedicaConcentracion = H002D2_A268RecetaMedicaConcentracion[0] ;
            n268RecetaMedicaConcentracion = H002D2_n268RecetaMedicaConcentracion[0] ;
            A231MedicamentoFormaFarm = H002D2_A231MedicamentoFormaFarm[0] ;
            n231MedicamentoFormaFarm = H002D2_n231MedicamentoFormaFarm[0] ;
            A230MedicamentoNombre = H002D2_A230MedicamentoNombre[0] ;
            A229MedicamentoCodigo = H002D2_A229MedicamentoCodigo[0] ;
            A42MedicamentoId = H002D2_A42MedicamentoId[0] ;
            n42MedicamentoId = H002D2_n42MedicamentoId[0] ;
            A19CitaId = H002D2_A19CitaId[0] ;
            A50RecetaMedicaId = H002D2_A50RecetaMedicaId[0] ;
            A231MedicamentoFormaFarm = H002D2_A231MedicamentoFormaFarm[0] ;
            n231MedicamentoFormaFarm = H002D2_n231MedicamentoFormaFarm[0] ;
            A230MedicamentoNombre = H002D2_A230MedicamentoNombre[0] ;
            A229MedicamentoCodigo = H002D2_A229MedicamentoCodigo[0] ;
            e212D2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb2D0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2D2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV54IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV54IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV56IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV56IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_MEDICAMENTOCODIGO", AV59IsAuthorized_MedicamentoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MEDICAMENTOCODIGO", getSecureSignedToken( "", AV59IsAuthorized_MedicamentoCodigo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_RECETAMEDICAID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9")));
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
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV64Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV65Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV66Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV67Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV68Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV69Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV70Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV72Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV71Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV74Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV73Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV75Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV77Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV79Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV80Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV81Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV83Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV84Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV86Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV85Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV64Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV64Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV71Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV73Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV73Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV75Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV77Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV77Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV81Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV81Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV85Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV85Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor H002D3 */
      pr_default.execute(1, new Object[] {lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, lV64Recetamedicawwds_1_filterfulltext, Short.valueOf(AV65Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV66Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV67Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV68Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV69Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV70Recetamedicawwds_7_tfmedicamentoid_to), lV71Recetamedicawwds_8_tfmedicamentocodigo, AV72Recetamedicawwds_9_tfmedicamentocodigo_sel, lV73Recetamedicawwds_10_tfmedicamentonombre, AV74Recetamedicawwds_11_tfmedicamentonombre_sel, lV75Recetamedicawwds_12_tfmedicamentoformafarm, AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV77Recetamedicawwds_14_tfrecetamedicaconcentracion, AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV79Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV80Recetamedicawwds_17_tfrecetamedicacantidad_to), lV81Recetamedicawwds_18_tfrecetamedicaatencion, AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV83Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV84Recetamedicawwds_21_tfrecetamedicaflag_to), lV85Recetamedicawwds_22_tfrecetaindicaciones, AV86Recetamedicawwds_23_tfrecetaindicaciones_sel});
      GRID_nRecordCount = H002D3_AGRID_nRecordCount[0] ;
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
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFRecetaMedicaId, AV28TFRecetaMedicaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFMedicamentoId, AV32TFMedicamentoId_To, AV33TFMedicamentoCodigo, AV34TFMedicamentoCodigo_Sel, AV35TFMedicamentoNombre, AV36TFMedicamentoNombre_Sel, AV37TFMedicamentoFormaFarm, AV38TFMedicamentoFormaFarm_Sel, AV39TFRecetaMedicaConcentracion, AV40TFRecetaMedicaConcentracion_Sel, AV41TFRecetaMedicaCantidad, AV42TFRecetaMedicaCantidad_To, AV43TFRecetaMedicaAtencion, AV44TFRecetaMedicaAtencion_Sel, AV47TFRecetaMedicaFlag, AV48TFRecetaMedicaFlag_To, AV60TFRecetaIndicaciones, AV61TFRecetaIndicaciones_Sel, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV54IsAuthorized_Update, AV56IsAuthorized_Delete, AV59IsAuthorized_MedicamentoCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFRecetaMedicaId, AV28TFRecetaMedicaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFMedicamentoId, AV32TFMedicamentoId_To, AV33TFMedicamentoCodigo, AV34TFMedicamentoCodigo_Sel, AV35TFMedicamentoNombre, AV36TFMedicamentoNombre_Sel, AV37TFMedicamentoFormaFarm, AV38TFMedicamentoFormaFarm_Sel, AV39TFRecetaMedicaConcentracion, AV40TFRecetaMedicaConcentracion_Sel, AV41TFRecetaMedicaCantidad, AV42TFRecetaMedicaCantidad_To, AV43TFRecetaMedicaAtencion, AV44TFRecetaMedicaAtencion_Sel, AV47TFRecetaMedicaFlag, AV48TFRecetaMedicaFlag_To, AV60TFRecetaIndicaciones, AV61TFRecetaIndicaciones_Sel, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV54IsAuthorized_Update, AV56IsAuthorized_Delete, AV59IsAuthorized_MedicamentoCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFRecetaMedicaId, AV28TFRecetaMedicaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFMedicamentoId, AV32TFMedicamentoId_To, AV33TFMedicamentoCodigo, AV34TFMedicamentoCodigo_Sel, AV35TFMedicamentoNombre, AV36TFMedicamentoNombre_Sel, AV37TFMedicamentoFormaFarm, AV38TFMedicamentoFormaFarm_Sel, AV39TFRecetaMedicaConcentracion, AV40TFRecetaMedicaConcentracion_Sel, AV41TFRecetaMedicaCantidad, AV42TFRecetaMedicaCantidad_To, AV43TFRecetaMedicaAtencion, AV44TFRecetaMedicaAtencion_Sel, AV47TFRecetaMedicaFlag, AV48TFRecetaMedicaFlag_To, AV60TFRecetaIndicaciones, AV61TFRecetaIndicaciones_Sel, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV54IsAuthorized_Update, AV56IsAuthorized_Delete, AV59IsAuthorized_MedicamentoCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFRecetaMedicaId, AV28TFRecetaMedicaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFMedicamentoId, AV32TFMedicamentoId_To, AV33TFMedicamentoCodigo, AV34TFMedicamentoCodigo_Sel, AV35TFMedicamentoNombre, AV36TFMedicamentoNombre_Sel, AV37TFMedicamentoFormaFarm, AV38TFMedicamentoFormaFarm_Sel, AV39TFRecetaMedicaConcentracion, AV40TFRecetaMedicaConcentracion_Sel, AV41TFRecetaMedicaCantidad, AV42TFRecetaMedicaCantidad_To, AV43TFRecetaMedicaAtencion, AV44TFRecetaMedicaAtencion_Sel, AV47TFRecetaMedicaFlag, AV48TFRecetaMedicaFlag_To, AV60TFRecetaIndicaciones, AV61TFRecetaIndicaciones_Sel, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV54IsAuthorized_Update, AV56IsAuthorized_Delete, AV59IsAuthorized_MedicamentoCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFRecetaMedicaId, AV28TFRecetaMedicaId_To, AV29TFCitaId, AV30TFCitaId_To, AV31TFMedicamentoId, AV32TFMedicamentoId_To, AV33TFMedicamentoCodigo, AV34TFMedicamentoCodigo_Sel, AV35TFMedicamentoNombre, AV36TFMedicamentoNombre_Sel, AV37TFMedicamentoFormaFarm, AV38TFMedicamentoFormaFarm_Sel, AV39TFRecetaMedicaConcentracion, AV40TFRecetaMedicaConcentracion_Sel, AV41TFRecetaMedicaCantidad, AV42TFRecetaMedicaCantidad_To, AV43TFRecetaMedicaAtencion, AV44TFRecetaMedicaAtencion_Sel, AV47TFRecetaMedicaFlag, AV48TFRecetaMedicaFlag_To, AV60TFRecetaIndicaciones, AV61TFRecetaIndicaciones_Sel, AV87Pgmname, AV13OrderedBy, AV14OrderedDsc, AV54IsAuthorized_Update, AV56IsAuthorized_Delete, AV59IsAuthorized_MedicamentoCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV87Pgmname = "RecetaMedicaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2D0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e192D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV49DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ",", ".")) ;
         AV51GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV52GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
      e192D2 ();
      if (returnInSub) return;
   }

   public void e192D2( )
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
      GXt_boolean1 = AV59IsAuthorized_MedicamentoCodigo ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento", GXv_boolean2) ;
      recetamedicaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV59IsAuthorized_MedicamentoCodigo = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59IsAuthorized_MedicamentoCodigo", AV59IsAuthorized_MedicamentoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MEDICAMENTOCODIGO", getSecureSignedToken( "", AV59IsAuthorized_MedicamentoCodigo));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Receta Medica" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV49DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV49DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e202D2( )
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
      if ( GXutil.strcmp(AV23Session.getValue("RecetaMedicaWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("RecetaMedicaWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtRecetaMedicaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtCitaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtMedicamentoId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtMedicamentoCodigo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoCodigo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtMedicamentoNombre_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoNombre_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtMedicamentoFormaFarm_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoFormaFarm_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoFormaFarm_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtRecetaMedicaConcentracion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaConcentracion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaConcentracion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtRecetaMedicaCantidad_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaCantidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaCantidad_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtRecetaMedicaAtencion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaAtencion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaAtencion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtRecetaMedicaArchivo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaArchivo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtRecetaMedicaFlag_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaFlag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaFlag_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtRecetaIndicaciones_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaIndicaciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaIndicaciones_Visible), 5, 0), !bGXsfl_43_Refreshing);
      AV51GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51GridCurrentPage), 10, 0));
      AV52GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52GridPageCount), 10, 0));
      AV64Recetamedicawwds_1_filterfulltext = AV16FilterFullText ;
      AV65Recetamedicawwds_2_tfrecetamedicaid = AV27TFRecetaMedicaId ;
      AV66Recetamedicawwds_3_tfrecetamedicaid_to = AV28TFRecetaMedicaId_To ;
      AV67Recetamedicawwds_4_tfcitaid = AV29TFCitaId ;
      AV68Recetamedicawwds_5_tfcitaid_to = AV30TFCitaId_To ;
      AV69Recetamedicawwds_6_tfmedicamentoid = AV31TFMedicamentoId ;
      AV70Recetamedicawwds_7_tfmedicamentoid_to = AV32TFMedicamentoId_To ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = AV33TFMedicamentoCodigo ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = AV34TFMedicamentoCodigo_Sel ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = AV35TFMedicamentoNombre ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = AV36TFMedicamentoNombre_Sel ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = AV37TFMedicamentoFormaFarm ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV38TFMedicamentoFormaFarm_Sel ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = AV39TFRecetaMedicaConcentracion ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV40TFRecetaMedicaConcentracion_Sel ;
      AV79Recetamedicawwds_16_tfrecetamedicacantidad = AV41TFRecetaMedicaCantidad ;
      AV80Recetamedicawwds_17_tfrecetamedicacantidad_to = AV42TFRecetaMedicaCantidad_To ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = AV43TFRecetaMedicaAtencion ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV44TFRecetaMedicaAtencion_Sel ;
      AV83Recetamedicawwds_20_tfrecetamedicaflag = AV47TFRecetaMedicaFlag ;
      AV84Recetamedicawwds_21_tfrecetamedicaflag_to = AV48TFRecetaMedicaFlag_To ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = AV60TFRecetaIndicaciones ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = AV61TFRecetaIndicaciones_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122D2( )
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
         AV50PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV50PageToGo) ;
      }
   }

   public void e132D2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142D2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "RecetaMedicaId") == 0 )
         {
            AV27TFRecetaMedicaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFRecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFRecetaMedicaId), 4, 0));
            AV28TFRecetaMedicaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFRecetaMedicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFRecetaMedicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaId") == 0 )
         {
            AV29TFCitaId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
            AV30TFCitaId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MedicamentoId") == 0 )
         {
            AV31TFMedicamentoId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFMedicamentoId), 4, 0));
            AV32TFMedicamentoId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFMedicamentoId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFMedicamentoId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MedicamentoCodigo") == 0 )
         {
            AV33TFMedicamentoCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFMedicamentoCodigo", AV33TFMedicamentoCodigo);
            AV34TFMedicamentoCodigo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFMedicamentoCodigo_Sel", AV34TFMedicamentoCodigo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MedicamentoNombre") == 0 )
         {
            AV35TFMedicamentoNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFMedicamentoNombre", AV35TFMedicamentoNombre);
            AV36TFMedicamentoNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFMedicamentoNombre_Sel", AV36TFMedicamentoNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MedicamentoFormaFarm") == 0 )
         {
            AV37TFMedicamentoFormaFarm = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFMedicamentoFormaFarm", AV37TFMedicamentoFormaFarm);
            AV38TFMedicamentoFormaFarm_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFMedicamentoFormaFarm_Sel", AV38TFMedicamentoFormaFarm_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "RecetaMedicaConcentracion") == 0 )
         {
            AV39TFRecetaMedicaConcentracion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFRecetaMedicaConcentracion", AV39TFRecetaMedicaConcentracion);
            AV40TFRecetaMedicaConcentracion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFRecetaMedicaConcentracion_Sel", AV40TFRecetaMedicaConcentracion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "RecetaMedicaCantidad") == 0 )
         {
            AV41TFRecetaMedicaCantidad = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFRecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFRecetaMedicaCantidad), 4, 0));
            AV42TFRecetaMedicaCantidad_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFRecetaMedicaCantidad_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFRecetaMedicaCantidad_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "RecetaMedicaAtencion") == 0 )
         {
            AV43TFRecetaMedicaAtencion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFRecetaMedicaAtencion", AV43TFRecetaMedicaAtencion);
            AV44TFRecetaMedicaAtencion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFRecetaMedicaAtencion_Sel", AV44TFRecetaMedicaAtencion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "RecetaMedicaFlag") == 0 )
         {
            AV47TFRecetaMedicaFlag = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFRecetaMedicaFlag", GXutil.str( AV47TFRecetaMedicaFlag, 1, 0));
            AV48TFRecetaMedicaFlag_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFRecetaMedicaFlag_To", GXutil.str( AV48TFRecetaMedicaFlag_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "RecetaIndicaciones") == 0 )
         {
            AV60TFRecetaIndicaciones = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFRecetaIndicaciones", AV60TFRecetaIndicaciones);
            AV61TFRecetaIndicaciones_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFRecetaIndicaciones_Sel", AV61TFRecetaIndicaciones_Sel);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e212D2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV53Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV53Update);
      if ( AV54IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.recetamedica", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A50RecetaMedicaId,4,0))}, new String[] {"Mode","RecetaMedicaId"})  ;
      }
      AV55Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV55Delete);
      if ( AV56IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.recetamedica", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A50RecetaMedicaId,4,0))}, new String[] {"Mode","RecetaMedicaId"})  ;
      }
      if ( AV59IsAuthorized_MedicamentoCodigo )
      {
         edtMedicamentoCodigo_Link = formatLink("com.projectthani.medicamentoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A42MedicamentoId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"MedicamentoId","TabCode"})  ;
      }
      edtRecetaMedicaConcentracion_Link = formatLink("com.projectthani.recetamedicaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A50RecetaMedicaId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"RecetaMedicaId","TabCode"})  ;
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

   public void e152D2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "RecetaMedicaWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e112D2( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("RecetaMedicaWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV87Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("RecetaMedicaWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV25ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "RecetaMedicaWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         recetamedicaww_impl.this.GXt_char6 = GXv_char7[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e162D2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.recetamedica", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","RecetaMedicaId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e172D2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char8[0] = AV18ErrorMessage ;
      new com.projectthani.recetamedicawwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      recetamedicaww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      recetamedicaww_impl.this.AV18ErrorMessage = GXv_char8[0] ;
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
   }

   public void e182D2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.recetamedicawwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaMedicaId", "", "Medica Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Cita Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "MedicamentoId", "", "Medicamento Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "MedicamentoCodigo", "", "Medicamento Codigo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "MedicamentoNombre", "", "Medicamento Nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "MedicamentoFormaFarm", "", "Medicamento Forma Farm", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaMedicaConcentracion", "", "Medica Concentracion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaMedicaCantidad", "", "Medica Cantidad", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaMedicaAtencion", "", "Medica Atencion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaMedicaArchivo", "", "Medica Archivo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaMedicaFlag", "", "Medica Flag", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "RecetaIndicaciones", "", "Indicaciones", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "RecetaMedicaWWColumnsSelector", GXv_char8) ;
      recetamedicaww_impl.this.GXt_char6 = GXv_char8[0] ;
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
      GXt_boolean1 = AV54IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Update", GXv_boolean2) ;
      recetamedicaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV54IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54IsAuthorized_Update", AV54IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV54IsAuthorized_Update));
      if ( ! ( AV54IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV56IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Delete", GXv_boolean2) ;
      recetamedicaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV56IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56IsAuthorized_Delete", AV56IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV56IsAuthorized_Delete));
      if ( ! ( AV56IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean1 = AV57TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Insert", GXv_boolean2) ;
      recetamedicaww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV57TempBoolean = GXt_boolean1 ;
      if ( ! ( AV57TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "RecetaMedicaWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFRecetaMedicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFRecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFRecetaMedicaId), 4, 0));
      AV28TFRecetaMedicaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFRecetaMedicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFRecetaMedicaId_To), 4, 0));
      AV29TFCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
      AV30TFCitaId_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
      AV31TFMedicamentoId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFMedicamentoId), 4, 0));
      AV32TFMedicamentoId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFMedicamentoId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFMedicamentoId_To), 4, 0));
      AV33TFMedicamentoCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFMedicamentoCodigo", AV33TFMedicamentoCodigo);
      AV34TFMedicamentoCodigo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFMedicamentoCodigo_Sel", AV34TFMedicamentoCodigo_Sel);
      AV35TFMedicamentoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFMedicamentoNombre", AV35TFMedicamentoNombre);
      AV36TFMedicamentoNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFMedicamentoNombre_Sel", AV36TFMedicamentoNombre_Sel);
      AV37TFMedicamentoFormaFarm = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFMedicamentoFormaFarm", AV37TFMedicamentoFormaFarm);
      AV38TFMedicamentoFormaFarm_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFMedicamentoFormaFarm_Sel", AV38TFMedicamentoFormaFarm_Sel);
      AV39TFRecetaMedicaConcentracion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFRecetaMedicaConcentracion", AV39TFRecetaMedicaConcentracion);
      AV40TFRecetaMedicaConcentracion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFRecetaMedicaConcentracion_Sel", AV40TFRecetaMedicaConcentracion_Sel);
      AV41TFRecetaMedicaCantidad = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFRecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFRecetaMedicaCantidad), 4, 0));
      AV42TFRecetaMedicaCantidad_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFRecetaMedicaCantidad_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFRecetaMedicaCantidad_To), 4, 0));
      AV43TFRecetaMedicaAtencion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFRecetaMedicaAtencion", AV43TFRecetaMedicaAtencion);
      AV44TFRecetaMedicaAtencion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFRecetaMedicaAtencion_Sel", AV44TFRecetaMedicaAtencion_Sel);
      AV47TFRecetaMedicaFlag = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFRecetaMedicaFlag", GXutil.str( AV47TFRecetaMedicaFlag, 1, 0));
      AV48TFRecetaMedicaFlag_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFRecetaMedicaFlag_To", GXutil.str( AV48TFRecetaMedicaFlag_To, 1, 0));
      AV60TFRecetaIndicaciones = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFRecetaIndicaciones", AV60TFRecetaIndicaciones);
      AV61TFRecetaIndicaciones_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFRecetaIndicaciones_Sel", AV61TFRecetaIndicaciones_Sel);
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
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAID") == 0 )
         {
            AV27TFRecetaMedicaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFRecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFRecetaMedicaId), 4, 0));
            AV28TFRecetaMedicaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFRecetaMedicaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFRecetaMedicaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV29TFCitaId = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFCitaId), 8, 0));
            AV30TFCitaId_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOID") == 0 )
         {
            AV31TFMedicamentoId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFMedicamentoId), 4, 0));
            AV32TFMedicamentoId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFMedicamentoId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFMedicamentoId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO") == 0 )
         {
            AV33TFMedicamentoCodigo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFMedicamentoCodigo", AV33TFMedicamentoCodigo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO_SEL") == 0 )
         {
            AV34TFMedicamentoCodigo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFMedicamentoCodigo_Sel", AV34TFMedicamentoCodigo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE") == 0 )
         {
            AV35TFMedicamentoNombre = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFMedicamentoNombre", AV35TFMedicamentoNombre);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE_SEL") == 0 )
         {
            AV36TFMedicamentoNombre_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFMedicamentoNombre_Sel", AV36TFMedicamentoNombre_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM") == 0 )
         {
            AV37TFMedicamentoFormaFarm = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFMedicamentoFormaFarm", AV37TFMedicamentoFormaFarm);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM_SEL") == 0 )
         {
            AV38TFMedicamentoFormaFarm_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFMedicamentoFormaFarm_Sel", AV38TFMedicamentoFormaFarm_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION") == 0 )
         {
            AV39TFRecetaMedicaConcentracion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFRecetaMedicaConcentracion", AV39TFRecetaMedicaConcentracion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION_SEL") == 0 )
         {
            AV40TFRecetaMedicaConcentracion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFRecetaMedicaConcentracion_Sel", AV40TFRecetaMedicaConcentracion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACANTIDAD") == 0 )
         {
            AV41TFRecetaMedicaCantidad = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFRecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFRecetaMedicaCantidad), 4, 0));
            AV42TFRecetaMedicaCantidad_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFRecetaMedicaCantidad_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFRecetaMedicaCantidad_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION") == 0 )
         {
            AV43TFRecetaMedicaAtencion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFRecetaMedicaAtencion", AV43TFRecetaMedicaAtencion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION_SEL") == 0 )
         {
            AV44TFRecetaMedicaAtencion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFRecetaMedicaAtencion_Sel", AV44TFRecetaMedicaAtencion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAFLAG") == 0 )
         {
            AV47TFRecetaMedicaFlag = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFRecetaMedicaFlag", GXutil.str( AV47TFRecetaMedicaFlag, 1, 0));
            AV48TFRecetaMedicaFlag_To = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFRecetaMedicaFlag_To", GXutil.str( AV48TFRecetaMedicaFlag_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES") == 0 )
         {
            AV60TFRecetaIndicaciones = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFRecetaIndicaciones", AV60TFRecetaIndicaciones);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES_SEL") == 0 )
         {
            AV61TFRecetaIndicaciones_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFRecetaIndicaciones_Sel", AV61TFRecetaIndicaciones_Sel);
         }
         AV88GXV1 = (int)(AV88GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFMedicamentoCodigo_Sel)==0), AV34TFMedicamentoCodigo_Sel, GXv_char8) ;
      recetamedicaww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV36TFMedicamentoNombre_Sel)==0), AV36TFMedicamentoNombre_Sel, GXv_char7) ;
      recetamedicaww_impl.this.GXt_char13 = GXv_char7[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFMedicamentoFormaFarm_Sel)==0), AV38TFMedicamentoFormaFarm_Sel, GXv_char15) ;
      recetamedicaww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFRecetaMedicaConcentracion_Sel)==0), AV40TFRecetaMedicaConcentracion_Sel, GXv_char17) ;
      recetamedicaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFRecetaMedicaAtencion_Sel)==0), AV44TFRecetaMedicaAtencion_Sel, GXv_char19) ;
      recetamedicaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV61TFRecetaIndicaciones_Sel)==0), AV61TFRecetaIndicaciones_Sel, GXv_char21) ;
      recetamedicaww_impl.this.GXt_char20 = GXv_char21[0] ;
      Ddo_grid_Selectedvalue_set = "|||"+GXt_char6+"|"+GXt_char13+"|"+GXt_char14+"|"+GXt_char16+"||"+GXt_char18+"|||"+GXt_char20 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFMedicamentoCodigo)==0), AV33TFMedicamentoCodigo, GXv_char21) ;
      recetamedicaww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFMedicamentoNombre)==0), AV35TFMedicamentoNombre, GXv_char19) ;
      recetamedicaww_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFMedicamentoFormaFarm)==0), AV37TFMedicamentoFormaFarm, GXv_char17) ;
      recetamedicaww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFRecetaMedicaConcentracion)==0), AV39TFRecetaMedicaConcentracion, GXv_char15) ;
      recetamedicaww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char8[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFRecetaMedicaAtencion)==0), AV43TFRecetaMedicaAtencion, GXv_char8) ;
      recetamedicaww_impl.this.GXt_char13 = GXv_char8[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV60TFRecetaIndicaciones)==0), AV60TFRecetaIndicaciones, GXv_char7) ;
      recetamedicaww_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFRecetaMedicaId) ? "" : GXutil.str( AV27TFRecetaMedicaId, 4, 0))+"|"+((0==AV29TFCitaId) ? "" : GXutil.str( AV29TFCitaId, 8, 0))+"|"+((0==AV31TFMedicamentoId) ? "" : GXutil.str( AV31TFMedicamentoId, 4, 0))+"|"+GXt_char20+"|"+GXt_char18+"|"+GXt_char16+"|"+GXt_char14+"|"+((0==AV41TFRecetaMedicaCantidad) ? "" : GXutil.str( AV41TFRecetaMedicaCantidad, 4, 0))+"|"+GXt_char13+"||"+((0==AV47TFRecetaMedicaFlag) ? "" : GXutil.str( AV47TFRecetaMedicaFlag, 1, 0))+"|"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFRecetaMedicaId_To) ? "" : GXutil.str( AV28TFRecetaMedicaId_To, 4, 0))+"|"+((0==AV30TFCitaId_To) ? "" : GXutil.str( AV30TFCitaId_To, 8, 0))+"|"+((0==AV32TFMedicamentoId_To) ? "" : GXutil.str( AV32TFMedicamentoId_To, 4, 0))+"|||||"+((0==AV42TFRecetaMedicaCantidad_To) ? "" : GXutil.str( AV42TFRecetaMedicaCantidad_To, 4, 0))+"|||"+((0==AV48TFRecetaMedicaFlag_To) ? "" : GXutil.str( AV48TFRecetaMedicaFlag_To, 1, 0))+"|" ;
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
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFRECETAMEDICAID", !((0==AV27TFRecetaMedicaId)&&(0==AV28TFRecetaMedicaId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFRecetaMedicaId, 4, 0)), GXutil.trim( GXutil.str( AV28TFRecetaMedicaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCITAID", !((0==AV29TFCitaId)&&(0==AV30TFCitaId_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFCitaId, 8, 0)), GXutil.trim( GXutil.str( AV30TFCitaId_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFMEDICAMENTOID", !((0==AV31TFMedicamentoId)&&(0==AV32TFMedicamentoId_To)), (short)(0), GXutil.trim( GXutil.str( AV31TFMedicamentoId, 4, 0)), GXutil.trim( GXutil.str( AV32TFMedicamentoId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFMEDICAMENTOCODIGO", !(GXutil.strcmp("", AV33TFMedicamentoCodigo)==0), (short)(0), AV33TFMedicamentoCodigo, "", !(GXutil.strcmp("", AV34TFMedicamentoCodigo_Sel)==0), AV34TFMedicamentoCodigo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFMEDICAMENTONOMBRE", !(GXutil.strcmp("", AV35TFMedicamentoNombre)==0), (short)(0), AV35TFMedicamentoNombre, "", !(GXutil.strcmp("", AV36TFMedicamentoNombre_Sel)==0), AV36TFMedicamentoNombre_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFMEDICAMENTOFORMAFARM", !(GXutil.strcmp("", AV37TFMedicamentoFormaFarm)==0), (short)(0), AV37TFMedicamentoFormaFarm, "", !(GXutil.strcmp("", AV38TFMedicamentoFormaFarm_Sel)==0), AV38TFMedicamentoFormaFarm_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFRECETAMEDICACONCENTRACION", !(GXutil.strcmp("", AV39TFRecetaMedicaConcentracion)==0), (short)(0), AV39TFRecetaMedicaConcentracion, "", !(GXutil.strcmp("", AV40TFRecetaMedicaConcentracion_Sel)==0), AV40TFRecetaMedicaConcentracion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFRECETAMEDICACANTIDAD", !((0==AV41TFRecetaMedicaCantidad)&&(0==AV42TFRecetaMedicaCantidad_To)), (short)(0), GXutil.trim( GXutil.str( AV41TFRecetaMedicaCantidad, 4, 0)), GXutil.trim( GXutil.str( AV42TFRecetaMedicaCantidad_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFRECETAMEDICAATENCION", !(GXutil.strcmp("", AV43TFRecetaMedicaAtencion)==0), (short)(0), AV43TFRecetaMedicaAtencion, "", !(GXutil.strcmp("", AV44TFRecetaMedicaAtencion_Sel)==0), AV44TFRecetaMedicaAtencion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFRECETAMEDICAFLAG", !((0==AV47TFRecetaMedicaFlag)&&(0==AV48TFRecetaMedicaFlag_To)), (short)(0), GXutil.trim( GXutil.str( AV47TFRecetaMedicaFlag, 1, 0)), GXutil.trim( GXutil.str( AV48TFRecetaMedicaFlag_To, 1, 0))) ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFRECETAINDICACIONES", !(GXutil.strcmp("", AV60TFRecetaIndicaciones)==0), (short)(0), AV60TFRecetaIndicaciones, "", !(GXutil.strcmp("", AV61TFRecetaIndicaciones_Sel)==0), AV61TFRecetaIndicaciones_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState22[0] ;
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
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "RecetaMedica" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_2D2( boolean wbgen )
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
         wb_table2_30_2D2( true) ;
      }
      else
      {
         wb_table2_30_2D2( false) ;
      }
      return  ;
   }

   public void wb_table2_30_2D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_2D2e( true) ;
      }
      else
      {
         wb_table1_25_2D2e( false) ;
      }
   }

   public void wb_table2_30_2D2( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_RecetaMedicaWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_2D2e( true) ;
      }
      else
      {
         wb_table2_30_2D2e( false) ;
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
      pa2D2( ) ;
      ws2D2( ) ;
      we2D2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334232", true, true);
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
      httpContext.AddJavascriptSource("recetamedicaww.js", "?20225110334232", false, true);
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
      edtRecetaMedicaId_Internalname = "RECETAMEDICAID_"+sGXsfl_43_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_idx ;
      edtMedicamentoId_Internalname = "MEDICAMENTOID_"+sGXsfl_43_idx ;
      edtMedicamentoCodigo_Internalname = "MEDICAMENTOCODIGO_"+sGXsfl_43_idx ;
      edtMedicamentoNombre_Internalname = "MEDICAMENTONOMBRE_"+sGXsfl_43_idx ;
      edtMedicamentoFormaFarm_Internalname = "MEDICAMENTOFORMAFARM_"+sGXsfl_43_idx ;
      edtRecetaMedicaConcentracion_Internalname = "RECETAMEDICACONCENTRACION_"+sGXsfl_43_idx ;
      edtRecetaMedicaCantidad_Internalname = "RECETAMEDICACANTIDAD_"+sGXsfl_43_idx ;
      edtRecetaMedicaAtencion_Internalname = "RECETAMEDICAATENCION_"+sGXsfl_43_idx ;
      edtRecetaMedicaArchivo_Internalname = "RECETAMEDICAARCHIVO_"+sGXsfl_43_idx ;
      edtRecetaMedicaNombreArchivo_Internalname = "RECETAMEDICANOMBREARCHIVO_"+sGXsfl_43_idx ;
      edtRecetaMedicaFlag_Internalname = "RECETAMEDICAFLAG_"+sGXsfl_43_idx ;
      edtRecetaIndicaciones_Internalname = "RECETAINDICACIONES_"+sGXsfl_43_idx ;
      edtRecetaArchivoTipo_Internalname = "RECETAARCHIVOTIPO_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaId_Internalname = "RECETAMEDICAID_"+sGXsfl_43_fel_idx ;
      edtCitaId_Internalname = "CITAID_"+sGXsfl_43_fel_idx ;
      edtMedicamentoId_Internalname = "MEDICAMENTOID_"+sGXsfl_43_fel_idx ;
      edtMedicamentoCodigo_Internalname = "MEDICAMENTOCODIGO_"+sGXsfl_43_fel_idx ;
      edtMedicamentoNombre_Internalname = "MEDICAMENTONOMBRE_"+sGXsfl_43_fel_idx ;
      edtMedicamentoFormaFarm_Internalname = "MEDICAMENTOFORMAFARM_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaConcentracion_Internalname = "RECETAMEDICACONCENTRACION_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaCantidad_Internalname = "RECETAMEDICACANTIDAD_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaAtencion_Internalname = "RECETAMEDICAATENCION_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaArchivo_Internalname = "RECETAMEDICAARCHIVO_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaNombreArchivo_Internalname = "RECETAMEDICANOMBREARCHIVO_"+sGXsfl_43_fel_idx ;
      edtRecetaMedicaFlag_Internalname = "RECETAMEDICAFLAG_"+sGXsfl_43_fel_idx ;
      edtRecetaIndicaciones_Internalname = "RECETAINDICACIONES_"+sGXsfl_43_fel_idx ;
      edtRecetaArchivoTipo_Internalname = "RECETAARCHIVOTIPO_"+sGXsfl_43_fel_idx ;
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb2D0( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV53Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV55Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtRecetaMedicaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaMedicaId_Internalname,GXutil.ltrim( localUtil.ntoc( A50RecetaMedicaId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaMedicaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtRecetaMedicaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtMedicamentoId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMedicamentoId_Internalname,GXutil.ltrim( localUtil.ntoc( A42MedicamentoId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A42MedicamentoId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMedicamentoId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMedicamentoId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMedicamentoCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMedicamentoCodigo_Internalname,A229MedicamentoCodigo,"","","'"+""+"'"+",false,"+"'"+""+"'",edtMedicamentoCodigo_Link,"","","",edtMedicamentoCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMedicamentoCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMedicamentoNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMedicamentoNombre_Internalname,A230MedicamentoNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMedicamentoNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMedicamentoNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMedicamentoFormaFarm_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMedicamentoFormaFarm_Internalname,A231MedicamentoFormaFarm,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMedicamentoFormaFarm_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMedicamentoFormaFarm_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtRecetaMedicaConcentracion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaMedicaConcentracion_Internalname,A268RecetaMedicaConcentracion,"","","'"+""+"'"+",false,"+"'"+""+"'",edtRecetaMedicaConcentracion_Link,"","","",edtRecetaMedicaConcentracion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtRecetaMedicaConcentracion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtRecetaMedicaCantidad_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaMedicaCantidad_Internalname,GXutil.ltrim( localUtil.ntoc( A269RecetaMedicaCantidad, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaMedicaCantidad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtRecetaMedicaCantidad_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtRecetaMedicaAtencion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaMedicaAtencion_Internalname,A273RecetaMedicaAtencion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaMedicaAtencion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtRecetaMedicaAtencion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtRecetaMedicaArchivo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         ClassString = "Image" ;
         StyleString = "" ;
         edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         edtRecetaMedicaArchivo_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, !bGXsfl_43_Refreshing);
         edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, !bGXsfl_43_Refreshing);
         if ( ! (GXutil.strcmp("", A270RecetaMedicaArchivo)==0) )
         {
            gxblobfileaux.setSource( A270RecetaMedicaArchivo );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtRecetaMedicaArchivo_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtRecetaMedicaArchivo_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A270RecetaMedicaArchivo = gxblobfileaux.getURI() ;
               n270RecetaMedicaArchivo = false ;
               httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), !bGXsfl_43_Refreshing);
               edtRecetaMedicaArchivo_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, !bGXsfl_43_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), !bGXsfl_43_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtRecetaMedicaArchivo_Internalname,GXutil.rtrim( A270RecetaMedicaArchivo),httpContext.getResourceRelative(A270RecetaMedicaArchivo),((GXutil.strcmp("", edtRecetaMedicaArchivo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtRecetaMedicaArchivo_Filetype)==0) ? A270RecetaMedicaArchivo : edtRecetaMedicaArchivo_Filetype)) : edtRecetaMedicaArchivo_Contenttype),Boolean.valueOf(true),"",edtRecetaMedicaArchivo_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(edtRecetaMedicaArchivo_Visible),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtRecetaMedicaArchivo_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaMedicaNombreArchivo_Internalname,A267RecetaMedicaNombreArchivo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaMedicaNombreArchivo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtRecetaMedicaFlag_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaMedicaFlag_Internalname,GXutil.ltrim( localUtil.ntoc( A272RecetaMedicaFlag, (byte)(1), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A272RecetaMedicaFlag), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaMedicaFlag_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtRecetaMedicaFlag_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtRecetaIndicaciones_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaIndicaciones_Internalname,A332RecetaIndicaciones,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaIndicaciones_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtRecetaIndicaciones_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRecetaArchivoTipo_Internalname,A271RecetaArchivoTipo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRecetaArchivoTipo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2D2( ) ;
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
      edtRecetaMedicaId_Internalname = "RECETAMEDICAID" ;
      edtCitaId_Internalname = "CITAID" ;
      edtMedicamentoId_Internalname = "MEDICAMENTOID" ;
      edtMedicamentoCodigo_Internalname = "MEDICAMENTOCODIGO" ;
      edtMedicamentoNombre_Internalname = "MEDICAMENTONOMBRE" ;
      edtMedicamentoFormaFarm_Internalname = "MEDICAMENTOFORMAFARM" ;
      edtRecetaMedicaConcentracion_Internalname = "RECETAMEDICACONCENTRACION" ;
      edtRecetaMedicaCantidad_Internalname = "RECETAMEDICACANTIDAD" ;
      edtRecetaMedicaAtencion_Internalname = "RECETAMEDICAATENCION" ;
      edtRecetaMedicaArchivo_Internalname = "RECETAMEDICAARCHIVO" ;
      edtRecetaMedicaNombreArchivo_Internalname = "RECETAMEDICANOMBREARCHIVO" ;
      edtRecetaMedicaFlag_Internalname = "RECETAMEDICAFLAG" ;
      edtRecetaIndicaciones_Internalname = "RECETAINDICACIONES" ;
      edtRecetaArchivoTipo_Internalname = "RECETAARCHIVOTIPO" ;
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
      edtRecetaArchivoTipo_Jsonclick = "" ;
      edtRecetaIndicaciones_Jsonclick = "" ;
      edtRecetaMedicaFlag_Jsonclick = "" ;
      edtRecetaMedicaNombreArchivo_Jsonclick = "" ;
      edtRecetaMedicaArchivo_Jsonclick = "" ;
      edtRecetaMedicaArchivo_Parameters = "" ;
      edtRecetaMedicaArchivo_Contenttype = "" ;
      edtRecetaMedicaAtencion_Jsonclick = "" ;
      edtRecetaMedicaCantidad_Jsonclick = "" ;
      edtRecetaMedicaConcentracion_Jsonclick = "" ;
      edtMedicamentoFormaFarm_Jsonclick = "" ;
      edtMedicamentoNombre_Jsonclick = "" ;
      edtMedicamentoCodigo_Jsonclick = "" ;
      edtMedicamentoId_Jsonclick = "" ;
      edtCitaId_Jsonclick = "" ;
      edtRecetaMedicaId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtRecetaMedicaArchivo_Filetype = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtRecetaMedicaConcentracion_Link = "" ;
      edtMedicamentoCodigo_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtRecetaIndicaciones_Visible = -1 ;
      edtRecetaMedicaFlag_Visible = -1 ;
      edtRecetaMedicaArchivo_Visible = -1 ;
      edtRecetaMedicaAtencion_Visible = -1 ;
      edtRecetaMedicaCantidad_Visible = -1 ;
      edtRecetaMedicaConcentracion_Visible = -1 ;
      edtMedicamentoFormaFarm_Visible = -1 ;
      edtMedicamentoNombre_Visible = -1 ;
      edtMedicamentoCodigo_Visible = -1 ;
      edtMedicamentoId_Visible = -1 ;
      edtCitaId_Visible = -1 ;
      edtRecetaMedicaId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Receta Medica" );
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
      Ddo_grid_Datalistproc = "RecetaMedicaWWGetFilterData" ;
      Ddo_grid_Datalisttype = "|||Dynamic|Dynamic|Dynamic|Dynamic||Dynamic|||Dynamic" ;
      Ddo_grid_Includedatalist = "|||T|T|T|T||T|||T" ;
      Ddo_grid_Filterisrange = "T|T|T|||||T|||T|" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Numeric|Character|Character|Character|Character|Numeric|Character||Numeric|Character" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|T||T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T|T|T||T|T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7|1|8|9||10|11" ;
      Ddo_grid_Columnids = "2:RecetaMedicaId|3:CitaId|4:MedicamentoId|5:MedicamentoCodigo|6:MedicamentoNombre|7:MedicamentoFormaFarm|8:RecetaMedicaConcentracion|9:RecetaMedicaCantidad|10:RecetaMedicaAtencion|11:RecetaMedicaArchivo|13:RecetaMedicaFlag|14:RecetaIndicaciones" ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtRecetaMedicaId_Visible',ctrl:'RECETAMEDICAID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtMedicamentoId_Visible',ctrl:'MEDICAMENTOID',prop:'Visible'},{av:'edtMedicamentoCodigo_Visible',ctrl:'MEDICAMENTOCODIGO',prop:'Visible'},{av:'edtMedicamentoNombre_Visible',ctrl:'MEDICAMENTONOMBRE',prop:'Visible'},{av:'edtMedicamentoFormaFarm_Visible',ctrl:'MEDICAMENTOFORMAFARM',prop:'Visible'},{av:'edtRecetaMedicaConcentracion_Visible',ctrl:'RECETAMEDICACONCENTRACION',prop:'Visible'},{av:'edtRecetaMedicaCantidad_Visible',ctrl:'RECETAMEDICACANTIDAD',prop:'Visible'},{av:'edtRecetaMedicaAtencion_Visible',ctrl:'RECETAMEDICAATENCION',prop:'Visible'},{av:'edtRecetaMedicaArchivo_Visible',ctrl:'RECETAMEDICAARCHIVO',prop:'Visible'},{av:'edtRecetaMedicaFlag_Visible',ctrl:'RECETAMEDICAFLAG',prop:'Visible'},{av:'edtRecetaIndicaciones_Visible',ctrl:'RECETAINDICACIONES',prop:'Visible'},{av:'AV51GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV52GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122D2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132D2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e142D2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e212D2',iparms:[{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A50RecetaMedicaId',fld:'RECETAMEDICAID',pic:'ZZZ9',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'A42MedicamentoId',fld:'MEDICAMENTOID',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV53Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV55Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtMedicamentoCodigo_Link',ctrl:'MEDICAMENTOCODIGO',prop:'Link'},{av:'edtRecetaMedicaConcentracion_Link',ctrl:'RECETAMEDICACONCENTRACION',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e152D2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtRecetaMedicaId_Visible',ctrl:'RECETAMEDICAID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtMedicamentoId_Visible',ctrl:'MEDICAMENTOID',prop:'Visible'},{av:'edtMedicamentoCodigo_Visible',ctrl:'MEDICAMENTOCODIGO',prop:'Visible'},{av:'edtMedicamentoNombre_Visible',ctrl:'MEDICAMENTONOMBRE',prop:'Visible'},{av:'edtMedicamentoFormaFarm_Visible',ctrl:'MEDICAMENTOFORMAFARM',prop:'Visible'},{av:'edtRecetaMedicaConcentracion_Visible',ctrl:'RECETAMEDICACONCENTRACION',prop:'Visible'},{av:'edtRecetaMedicaCantidad_Visible',ctrl:'RECETAMEDICACANTIDAD',prop:'Visible'},{av:'edtRecetaMedicaAtencion_Visible',ctrl:'RECETAMEDICAATENCION',prop:'Visible'},{av:'edtRecetaMedicaArchivo_Visible',ctrl:'RECETAMEDICAARCHIVO',prop:'Visible'},{av:'edtRecetaMedicaFlag_Visible',ctrl:'RECETAMEDICAFLAG',prop:'Visible'},{av:'edtRecetaIndicaciones_Visible',ctrl:'RECETAINDICACIONES',prop:'Visible'},{av:'AV51GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV52GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112D2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtRecetaMedicaId_Visible',ctrl:'RECETAMEDICAID',prop:'Visible'},{av:'edtCitaId_Visible',ctrl:'CITAID',prop:'Visible'},{av:'edtMedicamentoId_Visible',ctrl:'MEDICAMENTOID',prop:'Visible'},{av:'edtMedicamentoCodigo_Visible',ctrl:'MEDICAMENTOCODIGO',prop:'Visible'},{av:'edtMedicamentoNombre_Visible',ctrl:'MEDICAMENTONOMBRE',prop:'Visible'},{av:'edtMedicamentoFormaFarm_Visible',ctrl:'MEDICAMENTOFORMAFARM',prop:'Visible'},{av:'edtRecetaMedicaConcentracion_Visible',ctrl:'RECETAMEDICACONCENTRACION',prop:'Visible'},{av:'edtRecetaMedicaCantidad_Visible',ctrl:'RECETAMEDICACANTIDAD',prop:'Visible'},{av:'edtRecetaMedicaAtencion_Visible',ctrl:'RECETAMEDICAATENCION',prop:'Visible'},{av:'edtRecetaMedicaArchivo_Visible',ctrl:'RECETAMEDICAARCHIVO',prop:'Visible'},{av:'edtRecetaMedicaFlag_Visible',ctrl:'RECETAMEDICAFLAG',prop:'Visible'},{av:'edtRecetaIndicaciones_Visible',ctrl:'RECETAINDICACIONES',prop:'Visible'},{av:'AV51GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV52GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e162D2',iparms:[{av:'A50RecetaMedicaId',fld:'RECETAMEDICAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e172D2',iparms:[{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e182D2',iparms:[{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFRecetaMedicaId',fld:'vTFRECETAMEDICAID',pic:'ZZZ9'},{av:'AV28TFRecetaMedicaId_To',fld:'vTFRECETAMEDICAID_TO',pic:'ZZZ9'},{av:'AV29TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV30TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV31TFMedicamentoId',fld:'vTFMEDICAMENTOID',pic:'ZZZ9'},{av:'AV32TFMedicamentoId_To',fld:'vTFMEDICAMENTOID_TO',pic:'ZZZ9'},{av:'AV33TFMedicamentoCodigo',fld:'vTFMEDICAMENTOCODIGO',pic:''},{av:'AV34TFMedicamentoCodigo_Sel',fld:'vTFMEDICAMENTOCODIGO_SEL',pic:''},{av:'AV35TFMedicamentoNombre',fld:'vTFMEDICAMENTONOMBRE',pic:''},{av:'AV36TFMedicamentoNombre_Sel',fld:'vTFMEDICAMENTONOMBRE_SEL',pic:''},{av:'AV37TFMedicamentoFormaFarm',fld:'vTFMEDICAMENTOFORMAFARM',pic:''},{av:'AV38TFMedicamentoFormaFarm_Sel',fld:'vTFMEDICAMENTOFORMAFARM_SEL',pic:''},{av:'AV39TFRecetaMedicaConcentracion',fld:'vTFRECETAMEDICACONCENTRACION',pic:''},{av:'AV40TFRecetaMedicaConcentracion_Sel',fld:'vTFRECETAMEDICACONCENTRACION_SEL',pic:''},{av:'AV41TFRecetaMedicaCantidad',fld:'vTFRECETAMEDICACANTIDAD',pic:'ZZZ9'},{av:'AV42TFRecetaMedicaCantidad_To',fld:'vTFRECETAMEDICACANTIDAD_TO',pic:'ZZZ9'},{av:'AV43TFRecetaMedicaAtencion',fld:'vTFRECETAMEDICAATENCION',pic:''},{av:'AV44TFRecetaMedicaAtencion_Sel',fld:'vTFRECETAMEDICAATENCION_SEL',pic:''},{av:'AV47TFRecetaMedicaFlag',fld:'vTFRECETAMEDICAFLAG',pic:'9'},{av:'AV48TFRecetaMedicaFlag_To',fld:'vTFRECETAMEDICAFLAG_TO',pic:'9'},{av:'AV60TFRecetaIndicaciones',fld:'vTFRECETAINDICACIONES',pic:''},{av:'AV61TFRecetaIndicaciones_Sel',fld:'vTFRECETAINDICACIONES_SEL',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV54IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV56IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV59IsAuthorized_MedicamentoCodigo',fld:'vISAUTHORIZED_MEDICAMENTOCODIGO',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_MEDICAMENTOID","{handler:'valid_Medicamentoid',iparms:[]");
      setEventMetadata("VALID_MEDICAMENTOID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Recetaarchivotipo',iparms:[]");
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
      AV33TFMedicamentoCodigo = "" ;
      AV34TFMedicamentoCodigo_Sel = "" ;
      AV35TFMedicamentoNombre = "" ;
      AV36TFMedicamentoNombre_Sel = "" ;
      AV37TFMedicamentoFormaFarm = "" ;
      AV38TFMedicamentoFormaFarm_Sel = "" ;
      AV39TFRecetaMedicaConcentracion = "" ;
      AV40TFRecetaMedicaConcentracion_Sel = "" ;
      AV43TFRecetaMedicaAtencion = "" ;
      AV44TFRecetaMedicaAtencion_Sel = "" ;
      AV60TFRecetaIndicaciones = "" ;
      AV61TFRecetaIndicaciones_Sel = "" ;
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
      AV49DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
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
      AV53Update = "" ;
      AV55Delete = "" ;
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      A268RecetaMedicaConcentracion = "" ;
      A273RecetaMedicaAtencion = "" ;
      A270RecetaMedicaArchivo = "" ;
      A267RecetaMedicaNombreArchivo = "" ;
      A332RecetaIndicaciones = "" ;
      A271RecetaArchivoTipo = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      lV64Recetamedicawwds_1_filterfulltext = "" ;
      lV71Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      lV73Recetamedicawwds_10_tfmedicamentonombre = "" ;
      lV75Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      lV77Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      lV81Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      lV85Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      AV64Recetamedicawwds_1_filterfulltext = "" ;
      AV72Recetamedicawwds_9_tfmedicamentocodigo_sel = "" ;
      AV71Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      AV74Recetamedicawwds_11_tfmedicamentonombre_sel = "" ;
      AV73Recetamedicawwds_10_tfmedicamentonombre = "" ;
      AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel = "" ;
      AV75Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = "" ;
      AV77Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel = "" ;
      AV81Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      AV86Recetamedicawwds_23_tfrecetaindicaciones_sel = "" ;
      AV85Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      H002D2_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      H002D2_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      H002D2_A271RecetaArchivoTipo = new String[] {""} ;
      H002D2_A332RecetaIndicaciones = new String[] {""} ;
      H002D2_A272RecetaMedicaFlag = new byte[1] ;
      H002D2_n272RecetaMedicaFlag = new boolean[] {false} ;
      H002D2_A270RecetaMedicaArchivo = new String[] {""} ;
      H002D2_n270RecetaMedicaArchivo = new boolean[] {false} ;
      H002D2_A273RecetaMedicaAtencion = new String[] {""} ;
      H002D2_n273RecetaMedicaAtencion = new boolean[] {false} ;
      H002D2_A269RecetaMedicaCantidad = new short[1] ;
      H002D2_n269RecetaMedicaCantidad = new boolean[] {false} ;
      H002D2_A268RecetaMedicaConcentracion = new String[] {""} ;
      H002D2_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      H002D2_A231MedicamentoFormaFarm = new String[] {""} ;
      H002D2_n231MedicamentoFormaFarm = new boolean[] {false} ;
      H002D2_A230MedicamentoNombre = new String[] {""} ;
      H002D2_A229MedicamentoCodigo = new String[] {""} ;
      H002D2_A42MedicamentoId = new short[1] ;
      H002D2_n42MedicamentoId = new boolean[] {false} ;
      H002D2_A19CitaId = new int[1] ;
      H002D2_A50RecetaMedicaId = new short[1] ;
      edtRecetaMedicaArchivo_Filename = "" ;
      H002D3_AGRID_nRecordCount = new long[1] ;
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
      GXt_char20 = "" ;
      GXv_char21 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char19 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char8 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState22 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedicaww__default(),
         new Object[] {
             new Object[] {
            H002D2_A267RecetaMedicaNombreArchivo, H002D2_n267RecetaMedicaNombreArchivo, H002D2_A271RecetaArchivoTipo, H002D2_A332RecetaIndicaciones, H002D2_A272RecetaMedicaFlag, H002D2_n272RecetaMedicaFlag, H002D2_A270RecetaMedicaArchivo, H002D2_n270RecetaMedicaArchivo, H002D2_A273RecetaMedicaAtencion, H002D2_n273RecetaMedicaAtencion,
            H002D2_A269RecetaMedicaCantidad, H002D2_n269RecetaMedicaCantidad, H002D2_A268RecetaMedicaConcentracion, H002D2_n268RecetaMedicaConcentracion, H002D2_A231MedicamentoFormaFarm, H002D2_n231MedicamentoFormaFarm, H002D2_A230MedicamentoNombre, H002D2_A229MedicamentoCodigo, H002D2_A42MedicamentoId, H002D2_n42MedicamentoId,
            H002D2_A19CitaId, H002D2_A50RecetaMedicaId
            }
            , new Object[] {
            H002D3_AGRID_nRecordCount
            }
         }
      );
      AV87Pgmname = "RecetaMedicaWW" ;
      /* GeneXus formulas. */
      AV87Pgmname = "RecetaMedicaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV26ManageFiltersExecutionStep ;
   private byte AV47TFRecetaMedicaFlag ;
   private byte AV48TFRecetaMedicaFlag_To ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte A272RecetaMedicaFlag ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte AV83Recetamedicawwds_20_tfrecetamedicaflag ;
   private byte AV84Recetamedicawwds_21_tfrecetamedicaflag_to ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV27TFRecetaMedicaId ;
   private short AV28TFRecetaMedicaId_To ;
   private short AV31TFMedicamentoId ;
   private short AV32TFMedicamentoId_To ;
   private short AV41TFRecetaMedicaCantidad ;
   private short AV42TFRecetaMedicaCantidad_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A50RecetaMedicaId ;
   private short A42MedicamentoId ;
   private short A269RecetaMedicaCantidad ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV65Recetamedicawwds_2_tfrecetamedicaid ;
   private short AV66Recetamedicawwds_3_tfrecetamedicaid_to ;
   private short AV69Recetamedicawwds_6_tfmedicamentoid ;
   private short AV70Recetamedicawwds_7_tfmedicamentoid_to ;
   private short AV79Recetamedicawwds_16_tfrecetamedicacantidad ;
   private short AV80Recetamedicawwds_17_tfrecetamedicacantidad_to ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int AV29TFCitaId ;
   private int AV30TFCitaId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtRecetaMedicaId_Visible ;
   private int edtCitaId_Visible ;
   private int edtMedicamentoId_Visible ;
   private int edtMedicamentoCodigo_Visible ;
   private int edtMedicamentoNombre_Visible ;
   private int edtMedicamentoFormaFarm_Visible ;
   private int edtRecetaMedicaConcentracion_Visible ;
   private int edtRecetaMedicaCantidad_Visible ;
   private int edtRecetaMedicaAtencion_Visible ;
   private int edtRecetaMedicaArchivo_Visible ;
   private int edtRecetaMedicaFlag_Visible ;
   private int edtRecetaIndicaciones_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int A19CitaId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV67Recetamedicawwds_4_tfcitaid ;
   private int AV68Recetamedicawwds_5_tfcitaid_to ;
   private int AV50PageToGo ;
   private int AV88GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV51GridCurrentPage ;
   private long AV52GridPageCount ;
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
   private String AV53Update ;
   private String edtavUpdate_Link ;
   private String AV55Delete ;
   private String edtavDelete_Link ;
   private String edtMedicamentoCodigo_Link ;
   private String edtRecetaMedicaConcentracion_Link ;
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
   private String edtRecetaMedicaId_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtMedicamentoId_Internalname ;
   private String edtMedicamentoCodigo_Internalname ;
   private String edtMedicamentoNombre_Internalname ;
   private String edtMedicamentoFormaFarm_Internalname ;
   private String edtRecetaMedicaConcentracion_Internalname ;
   private String edtRecetaMedicaCantidad_Internalname ;
   private String edtRecetaMedicaAtencion_Internalname ;
   private String edtRecetaMedicaArchivo_Internalname ;
   private String edtRecetaMedicaFlag_Internalname ;
   private String edtRecetaIndicaciones_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String edtRecetaMedicaArchivo_Filename ;
   private String edtRecetaMedicaArchivo_Filetype ;
   private String GXt_char20 ;
   private String GXv_char21[] ;
   private String GXt_char18 ;
   private String GXv_char19[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char13 ;
   private String GXv_char8[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String edtRecetaMedicaNombreArchivo_Internalname ;
   private String edtRecetaArchivoTipo_Internalname ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtRecetaMedicaId_Jsonclick ;
   private String edtCitaId_Jsonclick ;
   private String edtMedicamentoId_Jsonclick ;
   private String edtMedicamentoCodigo_Jsonclick ;
   private String edtMedicamentoNombre_Jsonclick ;
   private String edtMedicamentoFormaFarm_Jsonclick ;
   private String edtRecetaMedicaConcentracion_Jsonclick ;
   private String edtRecetaMedicaCantidad_Jsonclick ;
   private String edtRecetaMedicaAtencion_Jsonclick ;
   private String edtRecetaMedicaArchivo_Contenttype ;
   private String edtRecetaMedicaArchivo_Parameters ;
   private String edtRecetaMedicaArchivo_Jsonclick ;
   private String edtRecetaMedicaNombreArchivo_Jsonclick ;
   private String edtRecetaMedicaFlag_Jsonclick ;
   private String edtRecetaIndicaciones_Jsonclick ;
   private String edtRecetaArchivoTipo_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV54IsAuthorized_Update ;
   private boolean AV56IsAuthorized_Delete ;
   private boolean AV59IsAuthorized_MedicamentoCodigo ;
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
   private boolean n42MedicamentoId ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n270RecetaMedicaArchivo ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean n272RecetaMedicaFlag ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV57TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String A270RecetaMedicaArchivo ;
   private String AV16FilterFullText ;
   private String AV33TFMedicamentoCodigo ;
   private String AV34TFMedicamentoCodigo_Sel ;
   private String AV35TFMedicamentoNombre ;
   private String AV36TFMedicamentoNombre_Sel ;
   private String AV37TFMedicamentoFormaFarm ;
   private String AV38TFMedicamentoFormaFarm_Sel ;
   private String AV39TFRecetaMedicaConcentracion ;
   private String AV40TFRecetaMedicaConcentracion_Sel ;
   private String AV43TFRecetaMedicaAtencion ;
   private String AV44TFRecetaMedicaAtencion_Sel ;
   private String AV60TFRecetaIndicaciones ;
   private String AV61TFRecetaIndicaciones_Sel ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String A268RecetaMedicaConcentracion ;
   private String A273RecetaMedicaAtencion ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A332RecetaIndicaciones ;
   private String A271RecetaArchivoTipo ;
   private String lV64Recetamedicawwds_1_filterfulltext ;
   private String lV71Recetamedicawwds_8_tfmedicamentocodigo ;
   private String lV73Recetamedicawwds_10_tfmedicamentonombre ;
   private String lV75Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String lV77Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String lV81Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String lV85Recetamedicawwds_22_tfrecetaindicaciones ;
   private String AV64Recetamedicawwds_1_filterfulltext ;
   private String AV72Recetamedicawwds_9_tfmedicamentocodigo_sel ;
   private String AV71Recetamedicawwds_8_tfmedicamentocodigo ;
   private String AV74Recetamedicawwds_11_tfmedicamentonombre_sel ;
   private String AV73Recetamedicawwds_10_tfmedicamentonombre ;
   private String AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel ;
   private String AV75Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ;
   private String AV77Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel ;
   private String AV81Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String AV86Recetamedicawwds_23_tfrecetaindicaciones_sel ;
   private String AV85Recetamedicawwds_22_tfrecetaindicaciones ;
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
   private com.genexus.util.GXFile gxblobfileaux ;
   private IDataStoreProvider pr_default ;
   private String[] H002D2_A267RecetaMedicaNombreArchivo ;
   private boolean[] H002D2_n267RecetaMedicaNombreArchivo ;
   private String[] H002D2_A271RecetaArchivoTipo ;
   private String[] H002D2_A332RecetaIndicaciones ;
   private byte[] H002D2_A272RecetaMedicaFlag ;
   private boolean[] H002D2_n272RecetaMedicaFlag ;
   private String[] H002D2_A270RecetaMedicaArchivo ;
   private boolean[] H002D2_n270RecetaMedicaArchivo ;
   private String[] H002D2_A273RecetaMedicaAtencion ;
   private boolean[] H002D2_n273RecetaMedicaAtencion ;
   private short[] H002D2_A269RecetaMedicaCantidad ;
   private boolean[] H002D2_n269RecetaMedicaCantidad ;
   private String[] H002D2_A268RecetaMedicaConcentracion ;
   private boolean[] H002D2_n268RecetaMedicaConcentracion ;
   private String[] H002D2_A231MedicamentoFormaFarm ;
   private boolean[] H002D2_n231MedicamentoFormaFarm ;
   private String[] H002D2_A230MedicamentoNombre ;
   private String[] H002D2_A229MedicamentoCodigo ;
   private short[] H002D2_A42MedicamentoId ;
   private boolean[] H002D2_n42MedicamentoId ;
   private int[] H002D2_A19CitaId ;
   private short[] H002D2_A50RecetaMedicaId ;
   private long[] H002D3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState22[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV49DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class recetamedicaww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002D2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV64Recetamedicawwds_1_filterfulltext ,
                                          short AV65Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV66Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV67Recetamedicawwds_4_tfcitaid ,
                                          int AV68Recetamedicawwds_5_tfcitaid_to ,
                                          short AV69Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV70Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV72Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV71Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV74Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV73Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV75Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV77Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV79Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV80Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV81Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV83Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV84Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV86Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV85Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[36];
      Object[] GXv_Object24 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[RecetaMedicaNombreArchivo], T1.[RecetaArchivoTipo], T1.[RecetaIndicaciones], T1.[RecetaMedicaFlag], T1.[RecetaMedicaArchivo], T1.[RecetaMedicaAtencion], T1.[RecetaMedicaCantidad]," ;
      sSelectString += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId]" ;
      sFromString = " FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV64Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
      }
      else
      {
         GXv_int23[0] = (byte)(1) ;
         GXv_int23[1] = (byte)(1) ;
         GXv_int23[2] = (byte)(1) ;
         GXv_int23[3] = (byte)(1) ;
         GXv_int23[4] = (byte)(1) ;
         GXv_int23[5] = (byte)(1) ;
         GXv_int23[6] = (byte)(1) ;
         GXv_int23[7] = (byte)(1) ;
         GXv_int23[8] = (byte)(1) ;
         GXv_int23[9] = (byte)(1) ;
         GXv_int23[10] = (byte)(1) ;
      }
      if ( ! (0==AV65Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int23[11] = (byte)(1) ;
      }
      if ( ! (0==AV66Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int23[12] = (byte)(1) ;
      }
      if ( ! (0==AV67Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int23[13] = (byte)(1) ;
      }
      if ( ! (0==AV68Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int23[14] = (byte)(1) ;
      }
      if ( ! (0==AV69Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int23[15] = (byte)(1) ;
      }
      if ( ! (0==AV70Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int23[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int23[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int23[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV73Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int23[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int23[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int23[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int23[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV77Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int23[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int23[24] = (byte)(1) ;
      }
      if ( ! (0==AV79Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int23[25] = (byte)(1) ;
      }
      if ( ! (0==AV80Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int23[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV81Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int23[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int23[28] = (byte)(1) ;
      }
      if ( ! (0==AV83Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int23[29] = (byte)(1) ;
      }
      if ( ! (0==AV84Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int23[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV85Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int23[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int23[32] = (byte)(1) ;
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaConcentracion]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaConcentracion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaId] DESC" ;
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
         sOrderString += " ORDER BY T1.[MedicamentoId]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[MedicamentoId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[MedicamentoCodigo]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[MedicamentoCodigo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[MedicamentoNombre]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[MedicamentoNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[MedicamentoFormaFarm]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[MedicamentoFormaFarm] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaCantidad]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaCantidad] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaAtencion]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaAtencion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaFlag]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaFlag] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[RecetaIndicaciones]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[RecetaIndicaciones] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[RecetaMedicaId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_H002D3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV64Recetamedicawwds_1_filterfulltext ,
                                          short AV65Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV66Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV67Recetamedicawwds_4_tfcitaid ,
                                          int AV68Recetamedicawwds_5_tfcitaid_to ,
                                          short AV69Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV70Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV72Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV71Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV74Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV73Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV75Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV77Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV79Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV80Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV81Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV83Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV84Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV86Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV85Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[33];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV64Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
      }
      else
      {
         GXv_int25[0] = (byte)(1) ;
         GXv_int25[1] = (byte)(1) ;
         GXv_int25[2] = (byte)(1) ;
         GXv_int25[3] = (byte)(1) ;
         GXv_int25[4] = (byte)(1) ;
         GXv_int25[5] = (byte)(1) ;
         GXv_int25[6] = (byte)(1) ;
         GXv_int25[7] = (byte)(1) ;
         GXv_int25[8] = (byte)(1) ;
         GXv_int25[9] = (byte)(1) ;
         GXv_int25[10] = (byte)(1) ;
      }
      if ( ! (0==AV65Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int25[11] = (byte)(1) ;
      }
      if ( ! (0==AV66Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int25[12] = (byte)(1) ;
      }
      if ( ! (0==AV67Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int25[13] = (byte)(1) ;
      }
      if ( ! (0==AV68Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int25[14] = (byte)(1) ;
      }
      if ( ! (0==AV69Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int25[15] = (byte)(1) ;
      }
      if ( ! (0==AV70Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int25[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int25[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int25[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV74Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV73Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int25[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV74Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int25[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int25[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int25[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV77Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int25[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV78Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int25[24] = (byte)(1) ;
      }
      if ( ! (0==AV79Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int25[25] = (byte)(1) ;
      }
      if ( ! (0==AV80Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int25[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV81Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int25[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV82Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int25[28] = (byte)(1) ;
      }
      if ( ! (0==AV83Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int25[29] = (byte)(1) ;
      }
      if ( ! (0==AV84Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int25[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV85Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int25[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int25[32] = (byte)(1) ;
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
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
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
                  return conditional_H002D2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() );
            case 1 :
                  return conditional_H002D3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002D2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002D3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getBLOBFile(5, rslt.getVarchar(2), rslt.getVarchar(1));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((String[]) buf[17])[0] = rslt.getVarchar(11);
               ((short[]) buf[18])[0] = rslt.getShort(12);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((int[]) buf[20])[0] = rslt.getInt(13);
               ((short[]) buf[21])[0] = rslt.getShort(14);
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
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[47]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[49]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[50]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[52]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[61]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[65]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[66]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 300);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[69]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[70]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[71]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
      }
   }

}

