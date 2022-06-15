package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class petitorioww_impl extends GXDataArea
{
   public petitorioww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public petitorioww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitorioww_impl.class ));
   }

   public petitorioww_impl( int remoteHandle ,
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
            AV27TFPetitorioId = (short)(GXutil.lval( httpContext.GetPar( "TFPetitorioId"))) ;
            AV28TFPetitorioId_To = (short)(GXutil.lval( httpContext.GetPar( "TFPetitorioId_To"))) ;
            AV29TFDrogueriaId = (short)(GXutil.lval( httpContext.GetPar( "TFDrogueriaId"))) ;
            AV30TFDrogueriaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFDrogueriaId_To"))) ;
            AV31TFPetitorioPrincipioActivo = httpContext.GetPar( "TFPetitorioPrincipioActivo") ;
            AV32TFPetitorioPrincipioActivo_Sel = httpContext.GetPar( "TFPetitorioPrincipioActivo_Sel") ;
            AV33TFPetitorioProducto = httpContext.GetPar( "TFPetitorioProducto") ;
            AV34TFPetitorioProducto_Sel = httpContext.GetPar( "TFPetitorioProducto_Sel") ;
            AV35TFPetitorioCategId = (short)(GXutil.lval( httpContext.GetPar( "TFPetitorioCategId"))) ;
            AV36TFPetitorioCategId_To = (short)(GXutil.lval( httpContext.GetPar( "TFPetitorioCategId_To"))) ;
            AV37TFPetitorioSubCategId = (short)(GXutil.lval( httpContext.GetPar( "TFPetitorioSubCategId"))) ;
            AV38TFPetitorioSubCategId_To = (short)(GXutil.lval( httpContext.GetPar( "TFPetitorioSubCategId_To"))) ;
            AV39TFPetitorioConcentracion = httpContext.GetPar( "TFPetitorioConcentracion") ;
            AV40TFPetitorioConcentracion_Sel = httpContext.GetPar( "TFPetitorioConcentracion_Sel") ;
            AV41TFFormaFarmaceuticaId = (short)(GXutil.lval( httpContext.GetPar( "TFFormaFarmaceuticaId"))) ;
            AV42TFFormaFarmaceuticaId_To = (short)(GXutil.lval( httpContext.GetPar( "TFFormaFarmaceuticaId_To"))) ;
            AV43TFPetitorioPresentacion = httpContext.GetPar( "TFPetitorioPresentacion") ;
            AV44TFPetitorioPresentacion_Sel = httpContext.GetPar( "TFPetitorioPresentacion_Sel") ;
            AV45TFPetitorioPrecio = CommonUtil.decimalVal( httpContext.GetPar( "TFPetitorioPrecio"), ".") ;
            AV46TFPetitorioPrecio_To = CommonUtil.decimalVal( httpContext.GetPar( "TFPetitorioPrecio_To"), ".") ;
            AV80Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            AV52IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
            AV53IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPetitorioId, AV28TFPetitorioId_To, AV29TFDrogueriaId, AV30TFDrogueriaId_To, AV31TFPetitorioPrincipioActivo, AV32TFPetitorioPrincipioActivo_Sel, AV33TFPetitorioProducto, AV34TFPetitorioProducto_Sel, AV35TFPetitorioCategId, AV36TFPetitorioCategId_To, AV37TFPetitorioSubCategId, AV38TFPetitorioSubCategId_To, AV39TFPetitorioConcentracion, AV40TFPetitorioConcentracion_Sel, AV41TFFormaFarmaceuticaId, AV42TFFormaFarmaceuticaId_To, AV43TFPetitorioPresentacion, AV44TFPetitorioPresentacion_Sel, AV45TFPetitorioPrecio, AV46TFPetitorioPrecio_To, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV53IsAuthorized_Delete) ;
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
      pa292( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start292( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110333432", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.petitorioww", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV53IsAuthorized_Delete));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOID", GXutil.ltrim( localUtil.ntoc( AV27TFPetitorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOID_TO", GXutil.ltrim( localUtil.ntoc( AV28TFPetitorioId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDROGUERIAID", GXutil.ltrim( localUtil.ntoc( AV29TFDrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDROGUERIAID_TO", GXutil.ltrim( localUtil.ntoc( AV30TFDrogueriaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRINCIPIOACTIVO", AV31TFPetitorioPrincipioActivo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRINCIPIOACTIVO_SEL", AV32TFPetitorioPrincipioActivo_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRODUCTO", AV33TFPetitorioProducto);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRODUCTO_SEL", AV34TFPetitorioProducto_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOCATEGID", GXutil.ltrim( localUtil.ntoc( AV35TFPetitorioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOCATEGID_TO", GXutil.ltrim( localUtil.ntoc( AV36TFPetitorioCategId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOSUBCATEGID", GXutil.ltrim( localUtil.ntoc( AV37TFPetitorioSubCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOSUBCATEGID_TO", GXutil.ltrim( localUtil.ntoc( AV38TFPetitorioSubCategId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOCONCENTRACION", AV39TFPetitorioConcentracion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOCONCENTRACION_SEL", AV40TFPetitorioConcentracion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFFORMAFARMACEUTICAID", GXutil.ltrim( localUtil.ntoc( AV41TFFormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFFORMAFARMACEUTICAID_TO", GXutil.ltrim( localUtil.ntoc( AV42TFFormaFarmaceuticaId_To, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRESENTACION", AV43TFPetitorioPresentacion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRESENTACION_SEL", AV44TFPetitorioPresentacion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRECIO", GXutil.ltrim( localUtil.ntoc( AV45TFPetitorioPrecio, (byte)(7), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPETITORIOPRECIO_TO", GXutil.ltrim( localUtil.ntoc( AV46TFPetitorioPrecio_To, (byte)(7), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV80Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV80Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV52IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV53IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV53IsAuthorized_Delete));
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
         we292( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt292( ) ;
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
      return formatLink("com.projectthani.petitorioww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "PetitorioWW" ;
   }

   public String getPgmdesc( )
   {
      return " Petitorio" ;
   }

   public void wb290( )
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Excel", bttBtnexport_Jsonclick, 5, "Exportar a Excel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "PDF", bttBtnexportreport_Jsonclick, 5, "Exportar a PDF", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 43, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_25_292( true) ;
      }
      else
      {
         wb_table1_25_292( false) ;
      }
      return  ;
   }

   public void wb_table1_25_292e( boolean wbgen )
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDrogueriaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Drogueria Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioPrincipioActivo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Principio Activo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioProducto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Producto") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioCategId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Petitorio Categ Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioSubCategId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Sub Categoría") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioConcentracion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Concentracion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtFormaFarmaceuticaId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Forma Farmaceutica") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioPresentacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Presentacion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPetitorioPrecio_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Precio") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV55Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV56Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A36DrogueriaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDrogueriaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A262PetitorioPrincipioActivo);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPetitorioPrincipioActivo_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioPrincipioActivo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A263PetitorioProducto);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioProducto_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioCategId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A48PetitorioSubCategId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioSubCategId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A260PetitorioConcentracion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioConcentracion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A39FormaFarmaceuticaId, (byte)(4), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtFormaFarmaceuticaId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A261PetitorioPresentacion);
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioPresentacion_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A264PetitorioPrecio, (byte)(7), (byte)(2), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPetitorioPrecio_Visible, (byte)(5), (byte)(0), ".", "")));
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

   public void start292( )
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
         Form.getMeta().addItem("description", " Petitorio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup290( ) ;
   }

   public void ws292( )
   {
      start292( ) ;
      evt292( ) ;
   }

   public void evt292( )
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
                           e11292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17292 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e18292 ();
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
                           AV55Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV55Update);
                           AV56Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV56Delete);
                           A25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioId_Internalname), ",", ".")) ;
                           A36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( edtDrogueriaId_Internalname), ",", ".")) ;
                           A262PetitorioPrincipioActivo = httpContext.cgiGet( edtPetitorioPrincipioActivo_Internalname) ;
                           A263PetitorioProducto = httpContext.cgiGet( edtPetitorioProducto_Internalname) ;
                           A49PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioCategId_Internalname), ",", ".")) ;
                           A48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioSubCategId_Internalname), ",", ".")) ;
                           A260PetitorioConcentracion = httpContext.cgiGet( edtPetitorioConcentracion_Internalname) ;
                           A39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".")) ;
                           A261PetitorioPresentacion = httpContext.cgiGet( edtPetitorioPresentacion_Internalname) ;
                           A264PetitorioPrecio = localUtil.ctond( httpContext.cgiGet( edtPetitorioPrecio_Internalname)) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19292 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20292 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21292 ();
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

   public void we292( )
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

   public void pa292( )
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
                                 short AV27TFPetitorioId ,
                                 short AV28TFPetitorioId_To ,
                                 short AV29TFDrogueriaId ,
                                 short AV30TFDrogueriaId_To ,
                                 String AV31TFPetitorioPrincipioActivo ,
                                 String AV32TFPetitorioPrincipioActivo_Sel ,
                                 String AV33TFPetitorioProducto ,
                                 String AV34TFPetitorioProducto_Sel ,
                                 short AV35TFPetitorioCategId ,
                                 short AV36TFPetitorioCategId_To ,
                                 short AV37TFPetitorioSubCategId ,
                                 short AV38TFPetitorioSubCategId_To ,
                                 String AV39TFPetitorioConcentracion ,
                                 String AV40TFPetitorioConcentracion_Sel ,
                                 short AV41TFFormaFarmaceuticaId ,
                                 short AV42TFFormaFarmaceuticaId_To ,
                                 String AV43TFPetitorioPresentacion ,
                                 String AV44TFPetitorioPresentacion_Sel ,
                                 java.math.BigDecimal AV45TFPetitorioPrecio ,
                                 java.math.BigDecimal AV46TFPetitorioPrecio_To ,
                                 String AV80Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV52IsAuthorized_Update ,
                                 boolean AV53IsAuthorized_Delete )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20292 ();
      GRID_nCurrentRecord = 0 ;
      rf292( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PETITORIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PETITORIOID", GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ".", "")));
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
      rf292( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV80Pgmname = "PetitorioWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf292( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e20292 ();
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
                                              AV59Petitoriowwds_1_filterfulltext ,
                                              Short.valueOf(AV60Petitoriowwds_2_tfpetitorioid) ,
                                              Short.valueOf(AV61Petitoriowwds_3_tfpetitorioid_to) ,
                                              Short.valueOf(AV62Petitoriowwds_4_tfdrogueriaid) ,
                                              Short.valueOf(AV63Petitoriowwds_5_tfdrogueriaid_to) ,
                                              AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                              AV64Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                              AV67Petitoriowwds_9_tfpetitorioproducto_sel ,
                                              AV66Petitoriowwds_8_tfpetitorioproducto ,
                                              Short.valueOf(AV68Petitoriowwds_10_tfpetitoriocategid) ,
                                              Short.valueOf(AV69Petitoriowwds_11_tfpetitoriocategid_to) ,
                                              Short.valueOf(AV70Petitoriowwds_12_tfpetitoriosubcategid) ,
                                              Short.valueOf(AV71Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                              AV73Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                              AV72Petitoriowwds_14_tfpetitorioconcentracion ,
                                              Short.valueOf(AV74Petitoriowwds_16_tfformafarmaceuticaid) ,
                                              Short.valueOf(AV75Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                              AV77Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                              AV76Petitoriowwds_18_tfpetitoriopresentacion ,
                                              AV78Petitoriowwds_20_tfpetitorioprecio ,
                                              AV79Petitoriowwds_21_tfpetitorioprecio_to ,
                                              Short.valueOf(A25PetitorioId) ,
                                              Short.valueOf(A36DrogueriaId) ,
                                              A262PetitorioPrincipioActivo ,
                                              A263PetitorioProducto ,
                                              Short.valueOf(A49PetitorioCategId) ,
                                              Short.valueOf(A48PetitorioSubCategId) ,
                                              A260PetitorioConcentracion ,
                                              Short.valueOf(A39FormaFarmaceuticaId) ,
                                              A261PetitorioPresentacion ,
                                              A264PetitorioPrecio ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                              TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
         lV64Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV64Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
         lV66Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV66Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
         lV72Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV72Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
         lV76Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV76Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
         /* Using cursor H00292 */
         pr_default.execute(0, new Object[] {lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, Short.valueOf(AV60Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV61Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV62Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV63Petitoriowwds_5_tfdrogueriaid_to), lV64Petitoriowwds_6_tfpetitorioprincipioactivo, AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV66Petitoriowwds_8_tfpetitorioproducto, AV67Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV68Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV69Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV70Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV71Petitoriowwds_13_tfpetitoriosubcategid_to), lV72Petitoriowwds_14_tfpetitorioconcentracion, AV73Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV74Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV75Petitoriowwds_17_tfformafarmaceuticaid_to), lV76Petitoriowwds_18_tfpetitoriopresentacion, AV77Petitoriowwds_19_tfpetitoriopresentacion_sel, AV78Petitoriowwds_20_tfpetitorioprecio, AV79Petitoriowwds_21_tfpetitorioprecio_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_43_idx = 1 ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A264PetitorioPrecio = H00292_A264PetitorioPrecio[0] ;
            A261PetitorioPresentacion = H00292_A261PetitorioPresentacion[0] ;
            A39FormaFarmaceuticaId = H00292_A39FormaFarmaceuticaId[0] ;
            A260PetitorioConcentracion = H00292_A260PetitorioConcentracion[0] ;
            A48PetitorioSubCategId = H00292_A48PetitorioSubCategId[0] ;
            A49PetitorioCategId = H00292_A49PetitorioCategId[0] ;
            A263PetitorioProducto = H00292_A263PetitorioProducto[0] ;
            A262PetitorioPrincipioActivo = H00292_A262PetitorioPrincipioActivo[0] ;
            A36DrogueriaId = H00292_A36DrogueriaId[0] ;
            A25PetitorioId = H00292_A25PetitorioId[0] ;
            A49PetitorioCategId = H00292_A49PetitorioCategId[0] ;
            e21292 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(43) ;
         wb290( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes292( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV80Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV80Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV52IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV53IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV53IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PETITORIOID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9")));
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
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV59Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV60Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV61Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV62Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV63Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV64Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV67Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV66Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV68Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV69Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV70Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV71Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV73Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV72Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV74Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV75Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV77Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV76Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV78Petitoriowwds_20_tfpetitorioprecio ,
                                           AV79Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_1_filterfulltext), "%", "") ;
      lV64Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV64Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV66Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV66Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV72Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV72Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV76Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV76Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor H00293 */
      pr_default.execute(1, new Object[] {lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, lV59Petitoriowwds_1_filterfulltext, Short.valueOf(AV60Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV61Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV62Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV63Petitoriowwds_5_tfdrogueriaid_to), lV64Petitoriowwds_6_tfpetitorioprincipioactivo, AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV66Petitoriowwds_8_tfpetitorioproducto, AV67Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV68Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV69Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV70Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV71Petitoriowwds_13_tfpetitoriosubcategid_to), lV72Petitoriowwds_14_tfpetitorioconcentracion, AV73Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV74Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV75Petitoriowwds_17_tfformafarmaceuticaid_to), lV76Petitoriowwds_18_tfpetitoriopresentacion, AV77Petitoriowwds_19_tfpetitoriopresentacion_sel, AV78Petitoriowwds_20_tfpetitorioprecio, AV79Petitoriowwds_21_tfpetitorioprecio_to});
      GRID_nRecordCount = H00293_AGRID_nRecordCount[0] ;
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
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPetitorioId, AV28TFPetitorioId_To, AV29TFDrogueriaId, AV30TFDrogueriaId_To, AV31TFPetitorioPrincipioActivo, AV32TFPetitorioPrincipioActivo_Sel, AV33TFPetitorioProducto, AV34TFPetitorioProducto_Sel, AV35TFPetitorioCategId, AV36TFPetitorioCategId_To, AV37TFPetitorioSubCategId, AV38TFPetitorioSubCategId_To, AV39TFPetitorioConcentracion, AV40TFPetitorioConcentracion_Sel, AV41TFFormaFarmaceuticaId, AV42TFFormaFarmaceuticaId_To, AV43TFPetitorioPresentacion, AV44TFPetitorioPresentacion_Sel, AV45TFPetitorioPrecio, AV46TFPetitorioPrecio_To, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV53IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPetitorioId, AV28TFPetitorioId_To, AV29TFDrogueriaId, AV30TFDrogueriaId_To, AV31TFPetitorioPrincipioActivo, AV32TFPetitorioPrincipioActivo_Sel, AV33TFPetitorioProducto, AV34TFPetitorioProducto_Sel, AV35TFPetitorioCategId, AV36TFPetitorioCategId_To, AV37TFPetitorioSubCategId, AV38TFPetitorioSubCategId_To, AV39TFPetitorioConcentracion, AV40TFPetitorioConcentracion_Sel, AV41TFFormaFarmaceuticaId, AV42TFFormaFarmaceuticaId_To, AV43TFPetitorioPresentacion, AV44TFPetitorioPresentacion_Sel, AV45TFPetitorioPrecio, AV46TFPetitorioPrecio_To, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV53IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPetitorioId, AV28TFPetitorioId_To, AV29TFDrogueriaId, AV30TFDrogueriaId_To, AV31TFPetitorioPrincipioActivo, AV32TFPetitorioPrincipioActivo_Sel, AV33TFPetitorioProducto, AV34TFPetitorioProducto_Sel, AV35TFPetitorioCategId, AV36TFPetitorioCategId_To, AV37TFPetitorioSubCategId, AV38TFPetitorioSubCategId_To, AV39TFPetitorioConcentracion, AV40TFPetitorioConcentracion_Sel, AV41TFFormaFarmaceuticaId, AV42TFFormaFarmaceuticaId_To, AV43TFPetitorioPresentacion, AV44TFPetitorioPresentacion_Sel, AV45TFPetitorioPrecio, AV46TFPetitorioPrecio_To, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV53IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPetitorioId, AV28TFPetitorioId_To, AV29TFDrogueriaId, AV30TFDrogueriaId_To, AV31TFPetitorioPrincipioActivo, AV32TFPetitorioPrincipioActivo_Sel, AV33TFPetitorioProducto, AV34TFPetitorioProducto_Sel, AV35TFPetitorioCategId, AV36TFPetitorioCategId_To, AV37TFPetitorioSubCategId, AV38TFPetitorioSubCategId_To, AV39TFPetitorioConcentracion, AV40TFPetitorioConcentracion_Sel, AV41TFFormaFarmaceuticaId, AV42TFFormaFarmaceuticaId_To, AV43TFPetitorioPresentacion, AV44TFPetitorioPresentacion_Sel, AV45TFPetitorioPrecio, AV46TFPetitorioPrecio_To, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV53IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV27TFPetitorioId, AV28TFPetitorioId_To, AV29TFDrogueriaId, AV30TFDrogueriaId_To, AV31TFPetitorioPrincipioActivo, AV32TFPetitorioPrincipioActivo_Sel, AV33TFPetitorioProducto, AV34TFPetitorioProducto_Sel, AV35TFPetitorioCategId, AV36TFPetitorioCategId_To, AV37TFPetitorioSubCategId, AV38TFPetitorioSubCategId_To, AV39TFPetitorioConcentracion, AV40TFPetitorioConcentracion_Sel, AV41TFFormaFarmaceuticaId, AV42TFFormaFarmaceuticaId_To, AV43TFPetitorioPresentacion, AV44TFPetitorioPresentacion_Sel, AV45TFPetitorioPrecio, AV46TFPetitorioPrecio_To, AV80Pgmname, AV13OrderedBy, AV14OrderedDsc, AV52IsAuthorized_Update, AV53IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV80Pgmname = "PetitorioWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup290( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19292 ();
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
      e19292 ();
      if (returnInSub) return;
   }

   public void e19292( )
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
      Form.setCaption( " Petitorio" );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV47DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV47DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e20292( )
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
      if ( GXutil.strcmp(AV23Session.getValue("PetitorioWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("PetitorioWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtPetitorioId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtDrogueriaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioPrincipioActivo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioPrincipioActivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioPrincipioActivo_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioProducto_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioProducto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioProducto_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioCategId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioSubCategId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioConcentracion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioConcentracion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioConcentracion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtFormaFarmaceuticaId_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioPresentacion_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioPresentacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioPresentacion_Visible), 5, 0), !bGXsfl_43_Refreshing);
      edtPetitorioPrecio_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioPrecio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioPrecio_Visible), 5, 0), !bGXsfl_43_Refreshing);
      AV49GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49GridCurrentPage), 10, 0));
      AV50GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50GridPageCount), 10, 0));
      AV59Petitoriowwds_1_filterfulltext = AV16FilterFullText ;
      AV60Petitoriowwds_2_tfpetitorioid = AV27TFPetitorioId ;
      AV61Petitoriowwds_3_tfpetitorioid_to = AV28TFPetitorioId_To ;
      AV62Petitoriowwds_4_tfdrogueriaid = AV29TFDrogueriaId ;
      AV63Petitoriowwds_5_tfdrogueriaid_to = AV30TFDrogueriaId_To ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = AV31TFPetitorioPrincipioActivo ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV32TFPetitorioPrincipioActivo_Sel ;
      AV66Petitoriowwds_8_tfpetitorioproducto = AV33TFPetitorioProducto ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = AV34TFPetitorioProducto_Sel ;
      AV68Petitoriowwds_10_tfpetitoriocategid = AV35TFPetitorioCategId ;
      AV69Petitoriowwds_11_tfpetitoriocategid_to = AV36TFPetitorioCategId_To ;
      AV70Petitoriowwds_12_tfpetitoriosubcategid = AV37TFPetitorioSubCategId ;
      AV71Petitoriowwds_13_tfpetitoriosubcategid_to = AV38TFPetitorioSubCategId_To ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = AV39TFPetitorioConcentracion ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = AV40TFPetitorioConcentracion_Sel ;
      AV74Petitoriowwds_16_tfformafarmaceuticaid = AV41TFFormaFarmaceuticaId ;
      AV75Petitoriowwds_17_tfformafarmaceuticaid_to = AV42TFFormaFarmaceuticaId_To ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = AV43TFPetitorioPresentacion ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = AV44TFPetitorioPresentacion_Sel ;
      AV78Petitoriowwds_20_tfpetitorioprecio = AV45TFPetitorioPrecio ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = AV46TFPetitorioPrecio_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e12292( )
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

   public void e13292( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e14292( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioId") == 0 )
         {
            AV27TFPetitorioId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFPetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPetitorioId), 4, 0));
            AV28TFPetitorioId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPetitorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPetitorioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DrogueriaId") == 0 )
         {
            AV29TFDrogueriaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFDrogueriaId), 4, 0));
            AV30TFDrogueriaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFDrogueriaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFDrogueriaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioPrincipioActivo") == 0 )
         {
            AV31TFPetitorioPrincipioActivo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPetitorioPrincipioActivo", AV31TFPetitorioPrincipioActivo);
            AV32TFPetitorioPrincipioActivo_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPetitorioPrincipioActivo_Sel", AV32TFPetitorioPrincipioActivo_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioProducto") == 0 )
         {
            AV33TFPetitorioProducto = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPetitorioProducto", AV33TFPetitorioProducto);
            AV34TFPetitorioProducto_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPetitorioProducto_Sel", AV34TFPetitorioProducto_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioCategId") == 0 )
         {
            AV35TFPetitorioCategId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFPetitorioCategId), 4, 0));
            AV36TFPetitorioCategId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFPetitorioCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFPetitorioCategId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioSubCategId") == 0 )
         {
            AV37TFPetitorioSubCategId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFPetitorioSubCategId), 4, 0));
            AV38TFPetitorioSubCategId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPetitorioSubCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFPetitorioSubCategId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioConcentracion") == 0 )
         {
            AV39TFPetitorioConcentracion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFPetitorioConcentracion", AV39TFPetitorioConcentracion);
            AV40TFPetitorioConcentracion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFPetitorioConcentracion_Sel", AV40TFPetitorioConcentracion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "FormaFarmaceuticaId") == 0 )
         {
            AV41TFFormaFarmaceuticaId = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFFormaFarmaceuticaId), 4, 0));
            AV42TFFormaFarmaceuticaId_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFFormaFarmaceuticaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFFormaFarmaceuticaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioPresentacion") == 0 )
         {
            AV43TFPetitorioPresentacion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFPetitorioPresentacion", AV43TFPetitorioPresentacion);
            AV44TFPetitorioPresentacion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFPetitorioPresentacion_Sel", AV44TFPetitorioPresentacion_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PetitorioPrecio") == 0 )
         {
            AV45TFPetitorioPrecio = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPetitorioPrecio", GXutil.ltrimstr( AV45TFPetitorioPrecio, 7, 2));
            AV46TFPetitorioPrecio_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPetitorioPrecio_To", GXutil.ltrimstr( AV46TFPetitorioPrecio_To, 7, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e21292( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV55Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV55Update);
      if ( AV52IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.petitorio", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A25PetitorioId,4,0))}, new String[] {"Mode","PetitorioId"})  ;
      }
      AV56Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV56Delete);
      if ( AV53IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.petitorio", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A25PetitorioId,4,0))}, new String[] {"Mode","PetitorioId"})  ;
      }
      edtPetitorioPrincipioActivo_Link = formatLink("com.projectthani.petitorioview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A25PetitorioId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PetitorioId","TabCode"})  ;
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

   public void e15292( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "PetitorioWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e11292( )
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
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("PetitorioWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV80Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("PetitorioWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV25ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "PetitorioWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         petitorioww_impl.this.GXt_char4 = GXv_char5[0] ;
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e16292( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.petitorio", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","PetitorioId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17292( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char5[0] = AV17ExcelFilename ;
      GXv_char6[0] = AV18ErrorMessage ;
      new com.projectthani.petitoriowwexport(remoteHandle, context).execute( GXv_char5, GXv_char6) ;
      petitorioww_impl.this.AV17ExcelFilename = GXv_char5[0] ;
      petitorioww_impl.this.AV18ErrorMessage = GXv_char6[0] ;
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

   public void e18292( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.projectthani.petitoriowwexportreport", new String[] {}, new String[] {})  ;
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
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioId", "", "Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "DrogueriaId", "", "Drogueria Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioPrincipioActivo", "", "Principio Activo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioProducto", "", "Producto", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioCategId", "", "Petitorio Categ Id", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioSubCategId", "", "Sub Categoría", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioConcentracion", "", "Concentracion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "FormaFarmaceuticaId", "", "Forma Farmaceutica", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioPresentacion", "", "Presentacion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV21ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PetitorioPrecio", "", "Precio", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXt_char4 = AV20UserCustomValue ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PetitorioWWColumnsSelector", GXv_char6) ;
      petitorioww_impl.this.GXt_char4 = GXv_char6[0] ;
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
      GXt_boolean9 = AV52IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Update", GXv_boolean10) ;
      petitorioww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV52IsAuthorized_Update = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52IsAuthorized_Update", AV52IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV52IsAuthorized_Update));
      if ( ! ( AV52IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV53IsAuthorized_Delete ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Delete", GXv_boolean10) ;
      petitorioww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV53IsAuthorized_Delete = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53IsAuthorized_Delete", AV53IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV53IsAuthorized_Delete));
      if ( ! ( AV53IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_43_Refreshing);
      }
      GXt_boolean9 = AV54TempBoolean ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Insert", GXv_boolean10) ;
      petitorioww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV54TempBoolean = GXt_boolean9 ;
      if ( ! ( AV54TempBoolean ) )
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
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "PetitorioWWFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilterFullText", AV16FilterFullText);
      AV27TFPetitorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFPetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPetitorioId), 4, 0));
      AV28TFPetitorioId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFPetitorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPetitorioId_To), 4, 0));
      AV29TFDrogueriaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFDrogueriaId), 4, 0));
      AV30TFDrogueriaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFDrogueriaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFDrogueriaId_To), 4, 0));
      AV31TFPetitorioPrincipioActivo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFPetitorioPrincipioActivo", AV31TFPetitorioPrincipioActivo);
      AV32TFPetitorioPrincipioActivo_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFPetitorioPrincipioActivo_Sel", AV32TFPetitorioPrincipioActivo_Sel);
      AV33TFPetitorioProducto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFPetitorioProducto", AV33TFPetitorioProducto);
      AV34TFPetitorioProducto_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFPetitorioProducto_Sel", AV34TFPetitorioProducto_Sel);
      AV35TFPetitorioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFPetitorioCategId), 4, 0));
      AV36TFPetitorioCategId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFPetitorioCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFPetitorioCategId_To), 4, 0));
      AV37TFPetitorioSubCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFPetitorioSubCategId), 4, 0));
      AV38TFPetitorioSubCategId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFPetitorioSubCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFPetitorioSubCategId_To), 4, 0));
      AV39TFPetitorioConcentracion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFPetitorioConcentracion", AV39TFPetitorioConcentracion);
      AV40TFPetitorioConcentracion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFPetitorioConcentracion_Sel", AV40TFPetitorioConcentracion_Sel);
      AV41TFFormaFarmaceuticaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFFormaFarmaceuticaId), 4, 0));
      AV42TFFormaFarmaceuticaId_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFFormaFarmaceuticaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFFormaFarmaceuticaId_To), 4, 0));
      AV43TFPetitorioPresentacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFPetitorioPresentacion", AV43TFPetitorioPresentacion);
      AV44TFPetitorioPresentacion_Sel = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFPetitorioPresentacion_Sel", AV44TFPetitorioPresentacion_Sel);
      AV45TFPetitorioPrecio = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFPetitorioPrecio", GXutil.ltrimstr( AV45TFPetitorioPrecio, 7, 2));
      AV46TFPetitorioPrecio_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFPetitorioPrecio_To", GXutil.ltrimstr( AV46TFPetitorioPrecio_To, 7, 2));
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
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOID") == 0 )
         {
            AV27TFPetitorioId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFPetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFPetitorioId), 4, 0));
            AV28TFPetitorioId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFPetitorioId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28TFPetitorioId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV29TFDrogueriaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFDrogueriaId), 4, 0));
            AV30TFDrogueriaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFDrogueriaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFDrogueriaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO") == 0 )
         {
            AV31TFPetitorioPrincipioActivo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFPetitorioPrincipioActivo", AV31TFPetitorioPrincipioActivo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO_SEL") == 0 )
         {
            AV32TFPetitorioPrincipioActivo_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFPetitorioPrincipioActivo_Sel", AV32TFPetitorioPrincipioActivo_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO") == 0 )
         {
            AV33TFPetitorioProducto = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFPetitorioProducto", AV33TFPetitorioProducto);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO_SEL") == 0 )
         {
            AV34TFPetitorioProducto_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFPetitorioProducto_Sel", AV34TFPetitorioProducto_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV35TFPetitorioCategId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFPetitorioCategId), 4, 0));
            AV36TFPetitorioCategId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFPetitorioCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFPetitorioCategId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV37TFPetitorioSubCategId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFPetitorioSubCategId), 4, 0));
            AV38TFPetitorioSubCategId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFPetitorioSubCategId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFPetitorioSubCategId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION") == 0 )
         {
            AV39TFPetitorioConcentracion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFPetitorioConcentracion", AV39TFPetitorioConcentracion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION_SEL") == 0 )
         {
            AV40TFPetitorioConcentracion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFPetitorioConcentracion_Sel", AV40TFPetitorioConcentracion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV41TFFormaFarmaceuticaId = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41TFFormaFarmaceuticaId), 4, 0));
            AV42TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFFormaFarmaceuticaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFFormaFarmaceuticaId_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION") == 0 )
         {
            AV43TFPetitorioPresentacion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFPetitorioPresentacion", AV43TFPetitorioPresentacion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION_SEL") == 0 )
         {
            AV44TFPetitorioPresentacion_Sel = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFPetitorioPresentacion_Sel", AV44TFPetitorioPresentacion_Sel);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRECIO") == 0 )
         {
            AV45TFPetitorioPrecio = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFPetitorioPrecio", GXutil.ltrimstr( AV45TFPetitorioPrecio, 7, 2));
            AV46TFPetitorioPrecio_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPetitorioPrecio_To", GXutil.ltrimstr( AV46TFPetitorioPrecio_To, 7, 2));
         }
         AV81GXV1 = (int)(AV81GXV1+1) ;
      }
      GXt_char4 = "" ;
      GXv_char6[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFPetitorioPrincipioActivo_Sel)==0), AV32TFPetitorioPrincipioActivo_Sel, GXv_char6) ;
      petitorioww_impl.this.GXt_char4 = GXv_char6[0] ;
      GXt_char13 = "" ;
      GXv_char5[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFPetitorioProducto_Sel)==0), AV34TFPetitorioProducto_Sel, GXv_char5) ;
      petitorioww_impl.this.GXt_char13 = GXv_char5[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFPetitorioConcentracion_Sel)==0), AV40TFPetitorioConcentracion_Sel, GXv_char15) ;
      petitorioww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFPetitorioPresentacion_Sel)==0), AV44TFPetitorioPresentacion_Sel, GXv_char17) ;
      petitorioww_impl.this.GXt_char16 = GXv_char17[0] ;
      Ddo_grid_Selectedvalue_set = "||"+GXt_char4+"|"+GXt_char13+"|||"+GXt_char14+"||"+GXt_char16+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFPetitorioPrincipioActivo)==0), AV31TFPetitorioPrincipioActivo, GXv_char17) ;
      petitorioww_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFPetitorioProducto)==0), AV33TFPetitorioProducto, GXv_char15) ;
      petitorioww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char13 = "" ;
      GXv_char6[0] = GXt_char13 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFPetitorioConcentracion)==0), AV39TFPetitorioConcentracion, GXv_char6) ;
      petitorioww_impl.this.GXt_char13 = GXv_char6[0] ;
      GXt_char4 = "" ;
      GXv_char5[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFPetitorioPresentacion)==0), AV43TFPetitorioPresentacion, GXv_char5) ;
      petitorioww_impl.this.GXt_char4 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV27TFPetitorioId) ? "" : GXutil.str( AV27TFPetitorioId, 4, 0))+"|"+((0==AV29TFDrogueriaId) ? "" : GXutil.str( AV29TFDrogueriaId, 4, 0))+"|"+GXt_char16+"|"+GXt_char14+"|"+((0==AV35TFPetitorioCategId) ? "" : GXutil.str( AV35TFPetitorioCategId, 4, 0))+"|"+((0==AV37TFPetitorioSubCategId) ? "" : GXutil.str( AV37TFPetitorioSubCategId, 4, 0))+"|"+GXt_char13+"|"+((0==AV41TFFormaFarmaceuticaId) ? "" : GXutil.str( AV41TFFormaFarmaceuticaId, 4, 0))+"|"+GXt_char4+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFPetitorioPrecio)==0) ? "" : GXutil.str( AV45TFPetitorioPrecio, 7, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV28TFPetitorioId_To) ? "" : GXutil.str( AV28TFPetitorioId_To, 4, 0))+"|"+((0==AV30TFDrogueriaId_To) ? "" : GXutil.str( AV30TFDrogueriaId_To, 4, 0))+"|||"+((0==AV36TFPetitorioCategId_To) ? "" : GXutil.str( AV36TFPetitorioCategId_To, 4, 0))+"|"+((0==AV38TFPetitorioSubCategId_To) ? "" : GXutil.str( AV38TFPetitorioSubCategId_To, 4, 0))+"||"+((0==AV42TFFormaFarmaceuticaId_To) ? "" : GXutil.str( AV42TFFormaFarmaceuticaId_To, 4, 0))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFPetitorioPrecio_To)==0) ? "" : GXutil.str( AV46TFPetitorioPrecio_To, 7, 2)) ;
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
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOID", !((0==AV27TFPetitorioId)&&(0==AV28TFPetitorioId_To)), (short)(0), GXutil.trim( GXutil.str( AV27TFPetitorioId, 4, 0)), GXutil.trim( GXutil.str( AV28TFPetitorioId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFDROGUERIAID", !((0==AV29TFDrogueriaId)&&(0==AV30TFDrogueriaId_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFDrogueriaId, 4, 0)), GXutil.trim( GXutil.str( AV30TFDrogueriaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOPRINCIPIOACTIVO", !(GXutil.strcmp("", AV31TFPetitorioPrincipioActivo)==0), (short)(0), AV31TFPetitorioPrincipioActivo, "", !(GXutil.strcmp("", AV32TFPetitorioPrincipioActivo_Sel)==0), AV32TFPetitorioPrincipioActivo_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOPRODUCTO", !(GXutil.strcmp("", AV33TFPetitorioProducto)==0), (short)(0), AV33TFPetitorioProducto, "", !(GXutil.strcmp("", AV34TFPetitorioProducto_Sel)==0), AV34TFPetitorioProducto_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOCATEGID", !((0==AV35TFPetitorioCategId)&&(0==AV36TFPetitorioCategId_To)), (short)(0), GXutil.trim( GXutil.str( AV35TFPetitorioCategId, 4, 0)), GXutil.trim( GXutil.str( AV36TFPetitorioCategId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOSUBCATEGID", !((0==AV37TFPetitorioSubCategId)&&(0==AV38TFPetitorioSubCategId_To)), (short)(0), GXutil.trim( GXutil.str( AV37TFPetitorioSubCategId, 4, 0)), GXutil.trim( GXutil.str( AV38TFPetitorioSubCategId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOCONCENTRACION", !(GXutil.strcmp("", AV39TFPetitorioConcentracion)==0), (short)(0), AV39TFPetitorioConcentracion, "", !(GXutil.strcmp("", AV40TFPetitorioConcentracion_Sel)==0), AV40TFPetitorioConcentracion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFFORMAFARMACEUTICAID", !((0==AV41TFFormaFarmaceuticaId)&&(0==AV42TFFormaFarmaceuticaId_To)), (short)(0), GXutil.trim( GXutil.str( AV41TFFormaFarmaceuticaId, 4, 0)), GXutil.trim( GXutil.str( AV42TFFormaFarmaceuticaId_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOPRESENTACION", !(GXutil.strcmp("", AV43TFPetitorioPresentacion)==0), (short)(0), AV43TFPetitorioPresentacion, "", !(GXutil.strcmp("", AV44TFPetitorioPresentacion_Sel)==0), AV44TFPetitorioPresentacion_Sel, "") ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPETITORIOPRECIO", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFPetitorioPrecio)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFPetitorioPrecio_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV45TFPetitorioPrecio, 7, 2)), GXutil.trim( GXutil.str( AV46TFPetitorioPrecio_To, 7, 2))) ;
      AV11GridState = GXv_SdtWWPGridState18[0] ;
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
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Petitorio" );
      AV23Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_25_292( boolean wbgen )
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
         wb_table2_30_292( true) ;
      }
      else
      {
         wb_table2_30_292( false) ;
      }
      return  ;
   }

   public void wb_table2_30_292e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_25_292e( true) ;
      }
      else
      {
         wb_table1_25_292e( false) ;
      }
   }

   public void wb_table2_30_292( boolean wbgen )
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_PetitorioWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_30_292e( true) ;
      }
      else
      {
         wb_table2_30_292e( false) ;
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
      pa292( ) ;
      ws292( ) ;
      we292( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110333829", true, true);
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
      httpContext.AddJavascriptSource("petitorioww.js", "?20225110333830", false, true);
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
      edtPetitorioId_Internalname = "PETITORIOID_"+sGXsfl_43_idx ;
      edtDrogueriaId_Internalname = "DROGUERIAID_"+sGXsfl_43_idx ;
      edtPetitorioPrincipioActivo_Internalname = "PETITORIOPRINCIPIOACTIVO_"+sGXsfl_43_idx ;
      edtPetitorioProducto_Internalname = "PETITORIOPRODUCTO_"+sGXsfl_43_idx ;
      edtPetitorioCategId_Internalname = "PETITORIOCATEGID_"+sGXsfl_43_idx ;
      edtPetitorioSubCategId_Internalname = "PETITORIOSUBCATEGID_"+sGXsfl_43_idx ;
      edtPetitorioConcentracion_Internalname = "PETITORIOCONCENTRACION_"+sGXsfl_43_idx ;
      edtFormaFarmaceuticaId_Internalname = "FORMAFARMACEUTICAID_"+sGXsfl_43_idx ;
      edtPetitorioPresentacion_Internalname = "PETITORIOPRESENTACION_"+sGXsfl_43_idx ;
      edtPetitorioPrecio_Internalname = "PETITORIOPRECIO_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_432( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_43_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_43_fel_idx ;
      edtPetitorioId_Internalname = "PETITORIOID_"+sGXsfl_43_fel_idx ;
      edtDrogueriaId_Internalname = "DROGUERIAID_"+sGXsfl_43_fel_idx ;
      edtPetitorioPrincipioActivo_Internalname = "PETITORIOPRINCIPIOACTIVO_"+sGXsfl_43_fel_idx ;
      edtPetitorioProducto_Internalname = "PETITORIOPRODUCTO_"+sGXsfl_43_fel_idx ;
      edtPetitorioCategId_Internalname = "PETITORIOCATEGID_"+sGXsfl_43_fel_idx ;
      edtPetitorioSubCategId_Internalname = "PETITORIOSUBCATEGID_"+sGXsfl_43_fel_idx ;
      edtPetitorioConcentracion_Internalname = "PETITORIOCONCENTRACION_"+sGXsfl_43_fel_idx ;
      edtFormaFarmaceuticaId_Internalname = "FORMAFARMACEUTICAID_"+sGXsfl_43_fel_idx ;
      edtPetitorioPresentacion_Internalname = "PETITORIOPRESENTACION_"+sGXsfl_43_fel_idx ;
      edtPetitorioPrecio_Internalname = "PETITORIOPRECIO_"+sGXsfl_43_fel_idx ;
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb290( ) ;
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV55Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV56Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPetitorioId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioId_Internalname,GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDrogueriaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDrogueriaId_Internalname,GXutil.ltrim( localUtil.ntoc( A36DrogueriaId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDrogueriaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDrogueriaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPetitorioPrincipioActivo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioPrincipioActivo_Internalname,A262PetitorioPrincipioActivo,"","","'"+""+"'"+",false,"+"'"+""+"'",edtPetitorioPrincipioActivo_Link,"","","",edtPetitorioPrincipioActivo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtPetitorioPrincipioActivo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPetitorioProducto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioProducto_Internalname,A263PetitorioProducto,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioProducto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioProducto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPetitorioCategId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioCategId_Internalname,GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioCategId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioCategId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPetitorioSubCategId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioSubCategId_Internalname,GXutil.ltrim( localUtil.ntoc( A48PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioSubCategId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioSubCategId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPetitorioConcentracion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioConcentracion_Internalname,A260PetitorioConcentracion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioConcentracion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioConcentracion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtFormaFarmaceuticaId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtFormaFarmaceuticaId_Internalname,GXutil.ltrim( localUtil.ntoc( A39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtFormaFarmaceuticaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtFormaFarmaceuticaId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtPetitorioPresentacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioPresentacion_Internalname,A261PetitorioPresentacion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioPresentacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioPresentacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPetitorioPrecio_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPetitorioPrecio_Internalname,GXutil.ltrim( localUtil.ntoc( A264PetitorioPrecio, (byte)(7), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A264PetitorioPrecio, "ZZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPetitorioPrecio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPetitorioPrecio_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(7),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes292( ) ;
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
      edtPetitorioId_Internalname = "PETITORIOID" ;
      edtDrogueriaId_Internalname = "DROGUERIAID" ;
      edtPetitorioPrincipioActivo_Internalname = "PETITORIOPRINCIPIOACTIVO" ;
      edtPetitorioProducto_Internalname = "PETITORIOPRODUCTO" ;
      edtPetitorioCategId_Internalname = "PETITORIOCATEGID" ;
      edtPetitorioSubCategId_Internalname = "PETITORIOSUBCATEGID" ;
      edtPetitorioConcentracion_Internalname = "PETITORIOCONCENTRACION" ;
      edtFormaFarmaceuticaId_Internalname = "FORMAFARMACEUTICAID" ;
      edtPetitorioPresentacion_Internalname = "PETITORIOPRESENTACION" ;
      edtPetitorioPrecio_Internalname = "PETITORIOPRECIO" ;
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
      edtPetitorioPrecio_Jsonclick = "" ;
      edtPetitorioPresentacion_Jsonclick = "" ;
      edtFormaFarmaceuticaId_Jsonclick = "" ;
      edtPetitorioConcentracion_Jsonclick = "" ;
      edtPetitorioSubCategId_Jsonclick = "" ;
      edtPetitorioCategId_Jsonclick = "" ;
      edtPetitorioProducto_Jsonclick = "" ;
      edtPetitorioPrincipioActivo_Jsonclick = "" ;
      edtDrogueriaId_Jsonclick = "" ;
      edtPetitorioId_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtPetitorioPrincipioActivo_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtPetitorioPrecio_Visible = -1 ;
      edtPetitorioPresentacion_Visible = -1 ;
      edtFormaFarmaceuticaId_Visible = -1 ;
      edtPetitorioConcentracion_Visible = -1 ;
      edtPetitorioSubCategId_Visible = -1 ;
      edtPetitorioCategId_Visible = -1 ;
      edtPetitorioProducto_Visible = -1 ;
      edtPetitorioPrincipioActivo_Visible = -1 ;
      edtDrogueriaId_Visible = -1 ;
      edtPetitorioId_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Petitorio" );
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
      Ddo_grid_Datalistproc = "PetitorioWWGetFilterData" ;
      Ddo_grid_Datalisttype = "||Dynamic|Dynamic|||Dynamic||Dynamic|" ;
      Ddo_grid_Includedatalist = "||T|T|||T||T|" ;
      Ddo_grid_Filterisrange = "T|T|||T|T||T||T" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Character|Character|Numeric|Numeric|Character|Numeric|Character|Numeric" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|1|4|5|6|7|8|9|10" ;
      Ddo_grid_Columnids = "2:PetitorioId|3:DrogueriaId|4:PetitorioPrincipioActivo|5:PetitorioProducto|6:PetitorioCategId|7:PetitorioSubCategId|8:PetitorioConcentracion|9:FormaFarmaceuticaId|10:PetitorioPresentacion|11:PetitorioPrecio" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPetitorioId_Visible',ctrl:'PETITORIOID',prop:'Visible'},{av:'edtDrogueriaId_Visible',ctrl:'DROGUERIAID',prop:'Visible'},{av:'edtPetitorioPrincipioActivo_Visible',ctrl:'PETITORIOPRINCIPIOACTIVO',prop:'Visible'},{av:'edtPetitorioProducto_Visible',ctrl:'PETITORIOPRODUCTO',prop:'Visible'},{av:'edtPetitorioCategId_Visible',ctrl:'PETITORIOCATEGID',prop:'Visible'},{av:'edtPetitorioSubCategId_Visible',ctrl:'PETITORIOSUBCATEGID',prop:'Visible'},{av:'edtPetitorioConcentracion_Visible',ctrl:'PETITORIOCONCENTRACION',prop:'Visible'},{av:'edtFormaFarmaceuticaId_Visible',ctrl:'FORMAFARMACEUTICAID',prop:'Visible'},{av:'edtPetitorioPresentacion_Visible',ctrl:'PETITORIOPRESENTACION',prop:'Visible'},{av:'edtPetitorioPrecio_Visible',ctrl:'PETITORIOPRECIO',prop:'Visible'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12292',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13292',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e14292',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21292',iparms:[{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV55Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV56Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtPetitorioPrincipioActivo_Link',ctrl:'PETITORIOPRINCIPIOACTIVO',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e15292',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtPetitorioId_Visible',ctrl:'PETITORIOID',prop:'Visible'},{av:'edtDrogueriaId_Visible',ctrl:'DROGUERIAID',prop:'Visible'},{av:'edtPetitorioPrincipioActivo_Visible',ctrl:'PETITORIOPRINCIPIOACTIVO',prop:'Visible'},{av:'edtPetitorioProducto_Visible',ctrl:'PETITORIOPRODUCTO',prop:'Visible'},{av:'edtPetitorioCategId_Visible',ctrl:'PETITORIOCATEGID',prop:'Visible'},{av:'edtPetitorioSubCategId_Visible',ctrl:'PETITORIOSUBCATEGID',prop:'Visible'},{av:'edtPetitorioConcentracion_Visible',ctrl:'PETITORIOCONCENTRACION',prop:'Visible'},{av:'edtFormaFarmaceuticaId_Visible',ctrl:'FORMAFARMACEUTICAID',prop:'Visible'},{av:'edtPetitorioPresentacion_Visible',ctrl:'PETITORIOPRESENTACION',prop:'Visible'},{av:'edtPetitorioPrecio_Visible',ctrl:'PETITORIOPRECIO',prop:'Visible'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11292',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPetitorioId_Visible',ctrl:'PETITORIOID',prop:'Visible'},{av:'edtDrogueriaId_Visible',ctrl:'DROGUERIAID',prop:'Visible'},{av:'edtPetitorioPrincipioActivo_Visible',ctrl:'PETITORIOPRINCIPIOACTIVO',prop:'Visible'},{av:'edtPetitorioProducto_Visible',ctrl:'PETITORIOPRODUCTO',prop:'Visible'},{av:'edtPetitorioCategId_Visible',ctrl:'PETITORIOCATEGID',prop:'Visible'},{av:'edtPetitorioSubCategId_Visible',ctrl:'PETITORIOSUBCATEGID',prop:'Visible'},{av:'edtPetitorioConcentracion_Visible',ctrl:'PETITORIOCONCENTRACION',prop:'Visible'},{av:'edtFormaFarmaceuticaId_Visible',ctrl:'FORMAFARMACEUTICAID',prop:'Visible'},{av:'edtPetitorioPresentacion_Visible',ctrl:'PETITORIOPRESENTACION',prop:'Visible'},{av:'edtPetitorioPrecio_Visible',ctrl:'PETITORIOPRECIO',prop:'Visible'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16292',iparms:[{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17292',iparms:[{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e18292',iparms:[{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27TFPetitorioId',fld:'vTFPETITORIOID',pic:'ZZZ9'},{av:'AV28TFPetitorioId_To',fld:'vTFPETITORIOID_TO',pic:'ZZZ9'},{av:'AV29TFDrogueriaId',fld:'vTFDROGUERIAID',pic:'ZZZ9'},{av:'AV30TFDrogueriaId_To',fld:'vTFDROGUERIAID_TO',pic:'ZZZ9'},{av:'AV31TFPetitorioPrincipioActivo',fld:'vTFPETITORIOPRINCIPIOACTIVO',pic:''},{av:'AV32TFPetitorioPrincipioActivo_Sel',fld:'vTFPETITORIOPRINCIPIOACTIVO_SEL',pic:''},{av:'AV33TFPetitorioProducto',fld:'vTFPETITORIOPRODUCTO',pic:''},{av:'AV34TFPetitorioProducto_Sel',fld:'vTFPETITORIOPRODUCTO_SEL',pic:''},{av:'AV35TFPetitorioCategId',fld:'vTFPETITORIOCATEGID',pic:'ZZZ9'},{av:'AV36TFPetitorioCategId_To',fld:'vTFPETITORIOCATEGID_TO',pic:'ZZZ9'},{av:'AV37TFPetitorioSubCategId',fld:'vTFPETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'AV38TFPetitorioSubCategId_To',fld:'vTFPETITORIOSUBCATEGID_TO',pic:'ZZZ9'},{av:'AV39TFPetitorioConcentracion',fld:'vTFPETITORIOCONCENTRACION',pic:''},{av:'AV40TFPetitorioConcentracion_Sel',fld:'vTFPETITORIOCONCENTRACION_SEL',pic:''},{av:'AV41TFFormaFarmaceuticaId',fld:'vTFFORMAFARMACEUTICAID',pic:'ZZZ9'},{av:'AV42TFFormaFarmaceuticaId_To',fld:'vTFFORMAFARMACEUTICAID_TO',pic:'ZZZ9'},{av:'AV43TFPetitorioPresentacion',fld:'vTFPETITORIOPRESENTACION',pic:''},{av:'AV44TFPetitorioPresentacion_Sel',fld:'vTFPETITORIOPRESENTACION_SEL',pic:''},{av:'AV45TFPetitorioPrecio',fld:'vTFPETITORIOPRECIO',pic:'ZZZ9.99'},{av:'AV46TFPetitorioPrecio_To',fld:'vTFPETITORIOPRECIO_TO',pic:'ZZZ9.99'},{av:'AV80Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV52IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV53IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'}]}");
      setEventMetadata("VALID_PETITORIOSUBCATEGID","{handler:'valid_Petitoriosubcategid',iparms:[]");
      setEventMetadata("VALID_PETITORIOSUBCATEGID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Petitorioprecio',iparms:[]");
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
      AV31TFPetitorioPrincipioActivo = "" ;
      AV32TFPetitorioPrincipioActivo_Sel = "" ;
      AV33TFPetitorioProducto = "" ;
      AV34TFPetitorioProducto_Sel = "" ;
      AV39TFPetitorioConcentracion = "" ;
      AV40TFPetitorioConcentracion_Sel = "" ;
      AV43TFPetitorioPresentacion = "" ;
      AV44TFPetitorioPresentacion_Sel = "" ;
      AV45TFPetitorioPrecio = DecimalUtil.ZERO ;
      AV46TFPetitorioPrecio_To = DecimalUtil.ZERO ;
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
      AV55Update = "" ;
      AV56Delete = "" ;
      A262PetitorioPrincipioActivo = "" ;
      A263PetitorioProducto = "" ;
      A260PetitorioConcentracion = "" ;
      A261PetitorioPresentacion = "" ;
      A264PetitorioPrecio = DecimalUtil.ZERO ;
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
      lV59Petitoriowwds_1_filterfulltext = "" ;
      lV64Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      lV66Petitoriowwds_8_tfpetitorioproducto = "" ;
      lV72Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      lV76Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      AV59Petitoriowwds_1_filterfulltext = "" ;
      AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel = "" ;
      AV64Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      AV67Petitoriowwds_9_tfpetitorioproducto_sel = "" ;
      AV66Petitoriowwds_8_tfpetitorioproducto = "" ;
      AV73Petitoriowwds_15_tfpetitorioconcentracion_sel = "" ;
      AV72Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      AV77Petitoriowwds_19_tfpetitoriopresentacion_sel = "" ;
      AV76Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      AV78Petitoriowwds_20_tfpetitorioprecio = DecimalUtil.ZERO ;
      AV79Petitoriowwds_21_tfpetitorioprecio_to = DecimalUtil.ZERO ;
      H00292_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00292_A261PetitorioPresentacion = new String[] {""} ;
      H00292_A39FormaFarmaceuticaId = new short[1] ;
      H00292_A260PetitorioConcentracion = new String[] {""} ;
      H00292_A48PetitorioSubCategId = new short[1] ;
      H00292_A49PetitorioCategId = new short[1] ;
      H00292_A263PetitorioProducto = new String[] {""} ;
      H00292_A262PetitorioPrincipioActivo = new String[] {""} ;
      H00292_A36DrogueriaId = new short[1] ;
      H00292_A25PetitorioId = new short[1] ;
      H00293_AGRID_nRecordCount = new long[1] ;
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
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char13 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState18 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitorioww__default(),
         new Object[] {
             new Object[] {
            H00292_A264PetitorioPrecio, H00292_A261PetitorioPresentacion, H00292_A39FormaFarmaceuticaId, H00292_A260PetitorioConcentracion, H00292_A48PetitorioSubCategId, H00292_A49PetitorioCategId, H00292_A263PetitorioProducto, H00292_A262PetitorioPrincipioActivo, H00292_A36DrogueriaId, H00292_A25PetitorioId
            }
            , new Object[] {
            H00293_AGRID_nRecordCount
            }
         }
      );
      AV80Pgmname = "PetitorioWW" ;
      /* GeneXus formulas. */
      AV80Pgmname = "PetitorioWW" ;
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
   private short AV27TFPetitorioId ;
   private short AV28TFPetitorioId_To ;
   private short AV29TFDrogueriaId ;
   private short AV30TFDrogueriaId_To ;
   private short AV35TFPetitorioCategId ;
   private short AV36TFPetitorioCategId_To ;
   private short AV37TFPetitorioSubCategId ;
   private short AV38TFPetitorioSubCategId_To ;
   private short AV41TFFormaFarmaceuticaId ;
   private short AV42TFFormaFarmaceuticaId_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A25PetitorioId ;
   private short A36DrogueriaId ;
   private short A49PetitorioCategId ;
   private short A48PetitorioSubCategId ;
   private short A39FormaFarmaceuticaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV60Petitoriowwds_2_tfpetitorioid ;
   private short AV61Petitoriowwds_3_tfpetitorioid_to ;
   private short AV62Petitoriowwds_4_tfdrogueriaid ;
   private short AV63Petitoriowwds_5_tfdrogueriaid_to ;
   private short AV68Petitoriowwds_10_tfpetitoriocategid ;
   private short AV69Petitoriowwds_11_tfpetitoriocategid_to ;
   private short AV70Petitoriowwds_12_tfpetitoriosubcategid ;
   private short AV71Petitoriowwds_13_tfpetitoriosubcategid_to ;
   private short AV74Petitoriowwds_16_tfformafarmaceuticaid ;
   private short AV75Petitoriowwds_17_tfformafarmaceuticaid_to ;
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
   private int edtPetitorioId_Visible ;
   private int edtDrogueriaId_Visible ;
   private int edtPetitorioPrincipioActivo_Visible ;
   private int edtPetitorioProducto_Visible ;
   private int edtPetitorioCategId_Visible ;
   private int edtPetitorioSubCategId_Visible ;
   private int edtPetitorioConcentracion_Visible ;
   private int edtFormaFarmaceuticaId_Visible ;
   private int edtPetitorioPresentacion_Visible ;
   private int edtPetitorioPrecio_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
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
   private java.math.BigDecimal AV45TFPetitorioPrecio ;
   private java.math.BigDecimal AV46TFPetitorioPrecio_To ;
   private java.math.BigDecimal A264PetitorioPrecio ;
   private java.math.BigDecimal AV78Petitoriowwds_20_tfpetitorioprecio ;
   private java.math.BigDecimal AV79Petitoriowwds_21_tfpetitorioprecio_to ;
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
   private String AV55Update ;
   private String edtavUpdate_Link ;
   private String AV56Delete ;
   private String edtavDelete_Link ;
   private String edtPetitorioPrincipioActivo_Link ;
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
   private String edtPetitorioId_Internalname ;
   private String edtDrogueriaId_Internalname ;
   private String edtPetitorioPrincipioActivo_Internalname ;
   private String edtPetitorioProducto_Internalname ;
   private String edtPetitorioCategId_Internalname ;
   private String edtPetitorioSubCategId_Internalname ;
   private String edtPetitorioConcentracion_Internalname ;
   private String edtFormaFarmaceuticaId_Internalname ;
   private String edtPetitorioPresentacion_Internalname ;
   private String edtPetitorioPrecio_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char13 ;
   private String GXv_char6[] ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtPetitorioId_Jsonclick ;
   private String edtDrogueriaId_Jsonclick ;
   private String edtPetitorioPrincipioActivo_Jsonclick ;
   private String edtPetitorioProducto_Jsonclick ;
   private String edtPetitorioCategId_Jsonclick ;
   private String edtPetitorioSubCategId_Jsonclick ;
   private String edtPetitorioConcentracion_Jsonclick ;
   private String edtFormaFarmaceuticaId_Jsonclick ;
   private String edtPetitorioPresentacion_Jsonclick ;
   private String edtPetitorioPrecio_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV52IsAuthorized_Update ;
   private boolean AV53IsAuthorized_Delete ;
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
   private boolean AV54TempBoolean ;
   private boolean GXt_boolean9 ;
   private boolean GXv_boolean10[] ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV16FilterFullText ;
   private String AV31TFPetitorioPrincipioActivo ;
   private String AV32TFPetitorioPrincipioActivo_Sel ;
   private String AV33TFPetitorioProducto ;
   private String AV34TFPetitorioProducto_Sel ;
   private String AV39TFPetitorioConcentracion ;
   private String AV40TFPetitorioConcentracion_Sel ;
   private String AV43TFPetitorioPresentacion ;
   private String AV44TFPetitorioPresentacion_Sel ;
   private String A262PetitorioPrincipioActivo ;
   private String A263PetitorioProducto ;
   private String A260PetitorioConcentracion ;
   private String A261PetitorioPresentacion ;
   private String lV59Petitoriowwds_1_filterfulltext ;
   private String lV64Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String lV66Petitoriowwds_8_tfpetitorioproducto ;
   private String lV72Petitoriowwds_14_tfpetitorioconcentracion ;
   private String lV76Petitoriowwds_18_tfpetitoriopresentacion ;
   private String AV59Petitoriowwds_1_filterfulltext ;
   private String AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel ;
   private String AV64Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String AV67Petitoriowwds_9_tfpetitorioproducto_sel ;
   private String AV66Petitoriowwds_8_tfpetitorioproducto ;
   private String AV73Petitoriowwds_15_tfpetitorioconcentracion_sel ;
   private String AV72Petitoriowwds_14_tfpetitorioconcentracion ;
   private String AV77Petitoriowwds_19_tfpetitoriopresentacion_sel ;
   private String AV76Petitoriowwds_18_tfpetitoriopresentacion ;
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
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H00292_A264PetitorioPrecio ;
   private String[] H00292_A261PetitorioPresentacion ;
   private short[] H00292_A39FormaFarmaceuticaId ;
   private String[] H00292_A260PetitorioConcentracion ;
   private short[] H00292_A48PetitorioSubCategId ;
   private short[] H00292_A49PetitorioCategId ;
   private String[] H00292_A263PetitorioProducto ;
   private String[] H00292_A262PetitorioPrincipioActivo ;
   private short[] H00292_A36DrogueriaId ;
   private short[] H00292_A25PetitorioId ;
   private long[] H00293_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector7[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV47DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class petitorioww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00292( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV59Petitoriowwds_1_filterfulltext ,
                                          short AV60Petitoriowwds_2_tfpetitorioid ,
                                          short AV61Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV62Petitoriowwds_4_tfdrogueriaid ,
                                          short AV63Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV64Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV67Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV66Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV68Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV69Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV70Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV71Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV73Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV72Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV74Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV75Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV77Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV76Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV78Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV79Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[33];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[PetitorioPrecio], T1.[PetitorioPresentacion], T1.[FormaFarmaceuticaId], T1.[PetitorioConcentracion], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[PetitorioProducto]," ;
      sSelectString += " T1.[PetitorioPrincipioActivo], T1.[DrogueriaId], T1.[PetitorioId]" ;
      sFromString = " FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId] = T1.[PetitorioSubCategId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV59Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
         GXv_int19[1] = (byte)(1) ;
         GXv_int19[2] = (byte)(1) ;
         GXv_int19[3] = (byte)(1) ;
         GXv_int19[4] = (byte)(1) ;
         GXv_int19[5] = (byte)(1) ;
         GXv_int19[6] = (byte)(1) ;
         GXv_int19[7] = (byte)(1) ;
         GXv_int19[8] = (byte)(1) ;
         GXv_int19[9] = (byte)(1) ;
      }
      if ( ! (0==AV60Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ! (0==AV61Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      if ( ! (0==AV62Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int19[12] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int19[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV64Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int19[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int19[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV66Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int19[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int19[17] = (byte)(1) ;
      }
      if ( ! (0==AV68Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int19[18] = (byte)(1) ;
      }
      if ( ! (0==AV69Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int19[19] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int19[20] = (byte)(1) ;
      }
      if ( ! (0==AV71Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int19[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV72Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int19[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int19[23] = (byte)(1) ;
      }
      if ( ! (0==AV74Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int19[24] = (byte)(1) ;
      }
      if ( ! (0==AV75Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int19[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV76Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int19[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int19[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int19[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int19[29] = (byte)(1) ;
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioPrincipioActivo]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioPrincipioActivo] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioId]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DrogueriaId]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[DrogueriaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioProducto]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioProducto] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[PetitorioCategId]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[PetitorioCategId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioSubCategId]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioSubCategId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioConcentracion]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioConcentracion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[FormaFarmaceuticaId]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[FormaFarmaceuticaId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioPresentacion]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioPresentacion] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PetitorioPrecio]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PetitorioPrecio] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[PetitorioId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H00293( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV59Petitoriowwds_1_filterfulltext ,
                                          short AV60Petitoriowwds_2_tfpetitorioid ,
                                          short AV61Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV62Petitoriowwds_4_tfdrogueriaid ,
                                          short AV63Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV64Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV67Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV66Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV68Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV69Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV70Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV71Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV73Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV72Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV74Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV75Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV77Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV76Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV78Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV79Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[30];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId] = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV59Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
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
      }
      if ( ! (0==AV60Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int21[10] = (byte)(1) ;
      }
      if ( ! (0==AV61Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int21[11] = (byte)(1) ;
      }
      if ( ! (0==AV62Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int21[12] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int21[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV64Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int21[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int21[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV66Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int21[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int21[17] = (byte)(1) ;
      }
      if ( ! (0==AV68Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int21[18] = (byte)(1) ;
      }
      if ( ! (0==AV69Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int21[19] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int21[20] = (byte)(1) ;
      }
      if ( ! (0==AV71Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int21[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV72Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int21[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int21[23] = (byte)(1) ;
      }
      if ( ! (0==AV74Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int21[24] = (byte)(1) ;
      }
      if ( ! (0==AV75Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int21[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV76Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int21[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int21[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int21[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int21[29] = (byte)(1) ;
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
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
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
                  return conditional_H00292(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
            case 1 :
                  return conditional_H00293(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00292", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00293", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
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
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
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
                  stmt.setShort(sIdx, ((Number) parms[46]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[52]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[53]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
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
                  stmt.setShort(sIdx, ((Number) parms[57]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[61], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[62], 2);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[63]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[64]).intValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[65]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
      }
   }

}

