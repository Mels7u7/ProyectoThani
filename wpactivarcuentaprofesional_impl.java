package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpactivarcuentaprofesional_impl extends GXDataArea
{
   public wpactivarcuentaprofesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpactivarcuentaprofesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpactivarcuentaprofesional_impl.class ));
   }

   public wpactivarcuentaprofesional_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento = new HTMLChoice();
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo = new HTMLChoice();
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta = new HTMLChoice();
      cmbavSdtcuentaporverificarprofesionals__profesionalestado = new HTMLChoice();
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
            nRC_GXsfl_37 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_37"))) ;
            nGXsfl_37_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_37_idx"))) ;
            sGXsfl_37_idx = httpContext.GetPar( "sGXsfl_37_idx") ;
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
            AV24ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
            AV47Pgmname = httpContext.GetPar( "Pgmname") ;
            AV13FilterFullText = httpContext.GetPar( "FilterFullText") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV14SDTCuentaPorVerificarProfesionals);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV24ManageFiltersExecutionStep, AV19ColumnsSelector, AV47Pgmname, AV13FilterFullText, AV14SDTCuentaPorVerificarProfesionals) ;
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      pa2N2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2N2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334264", false, true);
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
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpactivarcuentaprofesional", new String[] {}, new String[] {}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTCUENTAPORVERIFICARPROFESIONALS", getSecureSignedToken( "", AV14SDTCuentaPorVerificarProfesionals));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtcuentaporverificarprofesionals", AV14SDTCuentaPorVerificarProfesionals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtcuentaporverificarprofesionals", AV14SDTCuentaPorVerificarProfesionals);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtcuentaporverificarprofesionals", getSecureSignedToken( "", AV14SDTCuentaPorVerificarProfesionals));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_37", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_37, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV22ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV22ManageFiltersData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV27GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV28GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV25DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV25DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV24ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV47Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTCUENTAPORVERIFICARPROFESIONALS", AV14SDTCuentaPorVerificarProfesionals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTCUENTAPORVERIFICARPROFESIONALS", AV14SDTCuentaPorVerificarProfesionals);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTCUENTAPORVERIFICARPROFESIONALS", getSecureSignedToken( "", AV14SDTCuentaPorVerificarProfesionals));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         we2N2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2N2( ) ;
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
      return formatLink("com.projectthani.wpactivarcuentaprofesional", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPActivarCuentaProfesional" ;
   }

   public String getPgmdesc( )
   {
      return "Activar Cuenta Profesional" ;
   }

   public void wb2N0( )
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
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 37, 2, 0)+","+"null"+");", "Selecciona columnas", bttBtneditcolumns_Jsonclick, 0, "Selecciona columnas", "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPActivarCuentaProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_19_2N2( true) ;
      }
      else
      {
         wb_table1_19_2N2( false) ;
      }
      return  ;
   }

   public void wb_table1_19_2N2e( boolean wbgen )
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
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"37\">") ;
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Sexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "CMP") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Telefono") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Fecha Registro") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Estado Cuenta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionalestado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Profesional Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridContainer.AddObjectProperty("GridName", "Grid");
         }
         else
         {
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV29Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV31Display));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getVisible(), (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getEnabled(), (byte)(5), (byte)(0), ".", "")));
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
      if ( wbEnd == 37 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_37 = (int)(nGXsfl_37_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV34GXV1 = nGXsfl_37_idx ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV27GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV28GridPageCount);
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
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV25DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV25DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV19ColumnsSelector);
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
      if ( wbEnd == 37 )
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
               AV34GXV1 = nGXsfl_37_idx ;
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

   public void start2N2( )
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
         Form.getMeta().addItem("description", "Activar Cuenta Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2N0( ) ;
   }

   public void ws2N2( )
   {
      start2N2( ) ;
      evt2N2( ) ;
   }

   public void evt2N2( )
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
                           e112N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142N2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "VDISPLAY.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "VDISPLAY.CLICK") == 0 ) )
                        {
                           nGXsfl_37_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_372( ) ;
                           AV34GXV1 = (int)(nGXsfl_37_idx+GRID_nFirstRecordOnPage) ;
                           if ( ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && ( AV34GXV1 > 0 ) )
                           {
                              AV14SDTCuentaPorVerificarProfesionals.currentItem( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)) );
                              AV29Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV29Update);
                              AV31Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV31Display);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e152N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e162N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e172N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VDISPLAY.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e182N2 ();
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

   public void we2N2( )
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

   public void pa2N2( )
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
      subsflControlProps_372( ) ;
      while ( nGXsfl_37_idx <= nRC_GXsfl_37 )
      {
         sendrow_372( ) ;
         nGXsfl_37_idx = ((subGrid_Islastpage==1)&&(nGXsfl_37_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_37_idx+1) ;
         sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_372( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV24ManageFiltersExecutionStep ,
                                 com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV47Pgmname ,
                                 String AV13FilterFullText ,
                                 GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional> AV14SDTCuentaPorVerificarProfesionals )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e162N2 ();
      GRID_nCurrentRecord = 0 ;
      rf2N2( ) ;
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
      rf2N2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV47Pgmname = "WPActivarCuentaProfesional" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
   }

   public void rf2N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(37) ;
      /* Execute user event: Refresh */
      e162N2 ();
      nGXsfl_37_idx = 1 ;
      sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_372( ) ;
      bGXsfl_37_Refreshing = true ;
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
         subsflControlProps_372( ) ;
         e172N2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_37_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e172N2 ();
         }
         wbEnd = (short)(37) ;
         wb2N0( ) ;
      }
      bGXsfl_37_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2N2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV47Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTCUENTAPORVERIFICARPROFESIONALS", AV14SDTCuentaPorVerificarProfesionals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTCUENTAPORVERIFICARPROFESIONALS", AV14SDTCuentaPorVerificarProfesionals);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTCUENTAPORVERIFICARPROFESIONALS", getSecureSignedToken( "", AV14SDTCuentaPorVerificarProfesionals));
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
      return AV14SDTCuentaPorVerificarProfesionals.size() ;
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
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV24ManageFiltersExecutionStep, AV19ColumnsSelector, AV47Pgmname, AV13FilterFullText, AV14SDTCuentaPorVerificarProfesionals) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV24ManageFiltersExecutionStep, AV19ColumnsSelector, AV47Pgmname, AV13FilterFullText, AV14SDTCuentaPorVerificarProfesionals) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV24ManageFiltersExecutionStep, AV19ColumnsSelector, AV47Pgmname, AV13FilterFullText, AV14SDTCuentaPorVerificarProfesionals) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV24ManageFiltersExecutionStep, AV19ColumnsSelector, AV47Pgmname, AV13FilterFullText, AV14SDTCuentaPorVerificarProfesionals) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV24ManageFiltersExecutionStep, AV19ColumnsSelector, AV47Pgmname, AV13FilterFullText, AV14SDTCuentaPorVerificarProfesionals) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV47Pgmname = "WPActivarCuentaProfesional" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getEnabled(), 5, 0), !bGXsfl_37_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e152N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtcuentaporverificarprofesionals"), AV14SDTCuentaPorVerificarProfesionals);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV22ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV25DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTCUENTAPORVERIFICARPROFESIONALS"), AV14SDTCuentaPorVerificarProfesionals);
         /* Read saved values. */
         nRC_GXsfl_37 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_37"), ",", ".")) ;
         AV27GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV28GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
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
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         nRC_GXsfl_37 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_37"), ",", ".")) ;
         nGXsfl_37_fel_idx = 0 ;
         while ( nGXsfl_37_fel_idx < nRC_GXsfl_37 )
         {
            nGXsfl_37_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_37_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_37_fel_idx+1) ;
            sGXsfl_37_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_372( ) ;
            AV34GXV1 = (int)(nGXsfl_37_fel_idx+GRID_nFirstRecordOnPage) ;
            if ( ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && ( AV34GXV1 > 0 ) )
            {
               AV14SDTCuentaPorVerificarProfesionals.currentItem( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)) );
               AV29Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
               AV31Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
            }
         }
         if ( nGXsfl_37_fel_idx == 0 )
         {
            nGXsfl_37_idx = 1 ;
            sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_372( ) ;
         }
         nGXsfl_37_fel_idx = 1 ;
         /* Read variables values. */
         AV13FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
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
      e152N2 ();
      if (returnInSub) return;
   }

   public void e152N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_objcol_SdtSDTCuentaPorVerificarProfesional1 = AV14SDTCuentaPorVerificarProfesionals ;
      GXv_objcol_SdtSDTCuentaPorVerificarProfesional2[0] = GXt_objcol_SdtSDTCuentaPorVerificarProfesional1 ;
      new com.projectthani.prclistadoprofesionalcuentaporverificar(remoteHandle, context).execute( GXv_objcol_SdtSDTCuentaPorVerificarProfesional2) ;
      GXt_objcol_SdtSDTCuentaPorVerificarProfesional1 = GXv_objcol_SdtSDTCuentaPorVerificarProfesional2[0] ;
      AV14SDTCuentaPorVerificarProfesionals = GXt_objcol_SdtSDTCuentaPorVerificarProfesional1 ;
      gx_BV37 = true ;
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
      Form.setCaption( "Activar Cuenta Profesional" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV25DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV25DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e162N2( )
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
      if ( AV24ManageFiltersExecutionStep == 1 )
      {
         AV24ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ManageFiltersExecutionStep", GXutil.str( AV24ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV24ManageFiltersExecutionStep == 2 )
      {
         AV24ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ManageFiltersExecutionStep", GXutil.str( AV24ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("WPActivarCuentaProfesionalColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("WPActivarCuentaProfesionalColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S142 ();
         if (returnInSub) return;
      }
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getInternalname(), "Visible", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getVisible(), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getVisible(), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible), 5, 0), !bGXsfl_37_Refreshing);
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible = (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getInternalname(), "Visible", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getVisible(), 5, 0), !bGXsfl_37_Refreshing);
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setVisible( (((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestado.getInternalname(), "Visible", GXutil.ltrimstr( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getVisible(), 5, 0), !bGXsfl_37_Refreshing);
      /* Execute user subroutine: 'LOADGRIDSDT' */
      S152 ();
      if (returnInSub) return;
      AV27GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GridCurrentPage), 10, 0));
      AV28GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GridPageCount), 10, 0));
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ManageFiltersData", AV22ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122N2( )
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
         AV26PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV26PageToGo) ;
      }
   }

   public void e132N2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e172N2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV34GXV1 = 1 ;
      while ( AV34GXV1 <= AV14SDTCuentaPorVerificarProfesionals.size() )
      {
         AV14SDTCuentaPorVerificarProfesionals.currentItem( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)) );
         AV29Update = "<i class=\"fa fa-pen\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV29Update);
         AV31Display = "<i class=\"fa fa-search\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV31Display);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(37) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_372( ) ;
            GRID_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRID_nCurrentRecord + 1 >= subgrid_fnc_recordcount( ) )
            {
               GRID_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_37_Refreshing )
         {
            httpContext.doAjaxLoad(37, GridRow);
         }
         AV34GXV1 = (int)(AV34GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e142N2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new com.projectthani.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "WPActivarCuentaProfesionalColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "ProjectThani"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ManageFiltersData", AV22ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e112N2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S162 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S132 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("WPActivarCuentaProfesionalFilters")),GXutil.URLEncode(GXutil.rtrim(AV47Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV24ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ManageFiltersExecutionStep", GXutil.str( AV24ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("WPActivarCuentaProfesionalFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV24ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ManageFiltersExecutionStep", GXutil.str( AV24ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV23ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "WPActivarCuentaProfesionalFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         wpactivarcuentaprofesional_impl.this.GXt_char6 = GXv_char7[0] ;
         AV23ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV23ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem("El filtro seleccionado no existe más.");
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S162 ();
            if (returnInSub) return;
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV47Pgmname+"GridState", AV23ManageFiltersXml) ;
            AV11GridState.fromxml(AV23ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S172 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
            httpContext.doAjaxRefresh();
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ManageFiltersData", AV22ManageFiltersData);
   }

   public void S152( )
   {
      /* 'LOADGRIDSDT' Routine */
      returnInSub = false ;
   }

   public void S142( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV19ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalApellidoPaterno", "", "Apellido Paterno", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalApellidoMaterno", "", "Apellido Materno", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalNombres", "", "Nombres", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalTipoDocumento", "", "Tipo Documento", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalNroDocumento", "", "Nro Documento", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalSexo", "", "Profesional Sexo", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalCOP", "", "CMP", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalTelefono", "", "Profesional Telefono", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalCorreo", "", "Correo", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalFechaRegistro", "", "Profesional Fecha Registro", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalEstadoCuenta", "", "Profesional Estado Cuenta", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV19ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SDTCuentaPorVerificarProfesionals__ProfesionalEstado", "", "Profesional Estado", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV18UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WPActivarCuentaProfesionalColumnsSelector", GXv_char7) ;
      wpactivarcuentaprofesional_impl.this.GXt_char6 = GXv_char7[0] ;
      AV18UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV18UserCustomValue)==0) ) )
      {
         AV20ColumnsSelectorAux.fromxml(AV18UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV20ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV19ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV20ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item10 = AV22ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item11[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item10 ;
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "WPActivarCuentaProfesionalFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item11) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item10 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item11[0] ;
      AV22ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item10 ;
   }

   public void S162( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV13FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue(AV47Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV47Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV21Session.getValue(AV47Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S172 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S172( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV48GXV14 = 1 ;
      while ( AV48GXV14 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV14));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
         }
         AV48GXV14 = (int)(AV48GXV14+1) ;
      }
   }

   public void S132( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV21Session.getValue(AV47Pgmname+"GridState"), null, null);
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState12[0] = AV11GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "FILTERFULLTEXT", !(GXutil.strcmp("", AV13FilterFullText)==0), (short)(0), AV13FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState12[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV47Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void e182N2( )
   {
      AV34GXV1 = (int)(nGXsfl_37_idx+GRID_nFirstRecordOnPage) ;
      if ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 )
      {
         AV14SDTCuentaPorVerificarProfesionals.currentItem( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)) );
      }
      /* Display_Click Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wpinformaciondetalladadelprofesional", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)(AV14SDTCuentaPorVerificarProfesionals.currentItem())).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid(),8,0))}, new String[] {"ProfesionalId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void wb_table1_19_2N2( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV22ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_24_2N2( true) ;
      }
      else
      {
         wb_table2_24_2N2( false) ;
      }
      return  ;
   }

   public void wb_table2_24_2N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_19_2N2e( true) ;
      }
      else
      {
         wb_table1_19_2N2e( false) ;
      }
   }

   public void wb_table2_24_2N2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'" + sGXsfl_37_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV13FilterFullText, GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_WPActivarCuentaProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_24_2N2e( true) ;
      }
      else
      {
         wb_table2_24_2N2e( false) ;
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
      pa2N2( ) ;
      ws2N2( ) ;
      we2N2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334523", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("wpactivarcuentaprofesional.js", "?20225110334524", false, true);
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
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_372( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_37_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_37_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOPATERNO_"+sGXsfl_37_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOMATERNO_"+sGXsfl_37_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNOMBRES_"+sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO_"+sGXsfl_37_idx );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNRODOCUMENTO_"+sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO_"+sGXsfl_37_idx );
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCOP_"+sGXsfl_37_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTELEFONO_"+sGXsfl_37_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCORREO_"+sGXsfl_37_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALFECHAREGISTRO_"+sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA_"+sGXsfl_37_idx );
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO_"+sGXsfl_37_idx );
   }

   public void subsflControlProps_fel_372( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_37_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_37_fel_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOPATERNO_"+sGXsfl_37_fel_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOMATERNO_"+sGXsfl_37_fel_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNOMBRES_"+sGXsfl_37_fel_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO_"+sGXsfl_37_fel_idx );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNRODOCUMENTO_"+sGXsfl_37_fel_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO_"+sGXsfl_37_fel_idx );
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCOP_"+sGXsfl_37_fel_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTELEFONO_"+sGXsfl_37_fel_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCORREO_"+sGXsfl_37_fel_idx ;
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALFECHAREGISTRO_"+sGXsfl_37_fel_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA_"+sGXsfl_37_fel_idx );
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO_"+sGXsfl_37_fel_idx );
   }

   public void sendrow_372( )
   {
      subsflControlProps_372( ) ;
      wb2N0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_37_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_37_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_37_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 38,'',false,'"+sGXsfl_37_idx+"',37)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV29Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,38);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 39,'',false,'"+sGXsfl_37_idx+"',37)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV31Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,39);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDISPLAY.CLICK."+sGXsfl_37_idx+"'","","","Visualizar","",edtavDisplay_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname,((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname,((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname,((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalnombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO_" + sGXsfl_37_idx ;
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setName( GXCCtl );
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setWebtags( "" );
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("1", "DNI", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("6", "RUC", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
            if ( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getItemCount() > 0 )
            {
               if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento())==0) )
               {
                  ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento()) );
               }
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento,cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento()),Integer.valueOf(1),cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getVisible()),Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getInternalname(), "Values", cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname,((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO_" + sGXsfl_37_idx ;
            cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setName( GXCCtl );
            cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setWebtags( "" );
            cmbavSdtcuentaporverificarprofesionals__profesionalsexo.addItem("M", "Masculino", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionalsexo.addItem("F", "Femenino", (short)(0));
            if ( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getItemCount() > 0 )
            {
               if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo())==0) )
               {
                  ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo()) );
               }
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtcuentaporverificarprofesionals__profesionalsexo,cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo()),Integer.valueOf(1),cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getVisible()),Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getInternalname(), "Values", cmbavSdtcuentaporverificarprofesionals__profesionalsexo.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname,((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalcop_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname,GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono()),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname,((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname,localUtil.format(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible),Integer.valueOf(edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA_" + sGXsfl_37_idx ;
            cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setName( GXCCtl );
            cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setWebtags( "" );
            cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.addItem("CV", "Cuenta Verificada", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.addItem("CP", "Cuenta Por Verificar", (short)(0));
            if ( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getItemCount() > 0 )
            {
               if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta())==0) )
               {
                  ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta()) );
               }
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta,cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta()),Integer.valueOf(1),cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getVisible()),Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getInternalname(), "Values", cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbavSdtcuentaporverificarprofesionals__profesionalestado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO_" + sGXsfl_37_idx ;
            cmbavSdtcuentaporverificarprofesionals__profesionalestado.setName( GXCCtl );
            cmbavSdtcuentaporverificarprofesionals__profesionalestado.setWebtags( "" );
            cmbavSdtcuentaporverificarprofesionals__profesionalestado.addItem("A", "Activo", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionalestado.addItem("P", "Pendiente", (short)(0));
            cmbavSdtcuentaporverificarprofesionals__profesionalestado.addItem("I", "Inactivo", (short)(0));
            if ( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getItemCount() > 0 )
            {
               if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado())==0) )
               {
                  ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado()) );
               }
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtcuentaporverificarprofesionals__profesionalestado,cmbavSdtcuentaporverificarprofesionals__profesionalestado.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado()),Integer.valueOf(1),cmbavSdtcuentaporverificarprofesionals__profesionalestado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionalestado.getVisible()),Integer.valueOf(cmbavSdtcuentaporverificarprofesionals__profesionalestado.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtcuentaporverificarprofesionals__profesionalestado.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcuentaporverificarprofesionals__profesionalestado.getInternalname(), "Values", cmbavSdtcuentaporverificarprofesionals__profesionalestado.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         send_integrity_lvl_hashes2N2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_37_idx = ((subGrid_Islastpage==1)&&(nGXsfl_37_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_37_idx+1) ;
         sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_372( ) ;
      }
      /* End function sendrow_372 */
   }

   public void init_default_properties( )
   {
      bttBtneditcolumns_Internalname = "BTNEDITCOLUMNS" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      Dvpanel_tableheader_Internalname = "DVPANEL_TABLEHEADER" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOPATERNO" ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOMATERNO" ;
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNOMBRES" ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO" );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNRODOCUMENTO" ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO" );
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCOP" ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTELEFONO" ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCORREO" ;
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALFECHAREGISTRO" ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA" );
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setInternalname( "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
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
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setJsonclick( "" );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setJsonclick( "" );
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Jsonclick = "" ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Jsonclick = "" ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Jsonclick = "" ;
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Jsonclick = "" ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setJsonclick( "" );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Jsonclick = "" ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setJsonclick( "" );
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Jsonclick = "" ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Jsonclick = "" ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Jsonclick = "" ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Visible = -1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Visible = -1 ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setVisible( -1 );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setVisible( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setVisible( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setVisible( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setEnabled( -1 );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setEnabled( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setEnabled( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setEnabled( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled = -1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setEnabled( 0 );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setEnabled( 0 );
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled = 0 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setEnabled( 0 );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled = 0 ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setEnabled( 0 );
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled = 0 ;
      edtavDisplay_Enabled = 1 ;
      edtavUpdate_Enabled = 1 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setVisible( -1 );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setVisible( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setVisible( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible = -1 ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setVisible( -1 );
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible = -1 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Activar Cuenta Profesional" );
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = "" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector hidden-xs" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = "Selecciona columnas" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Columnssortvalues = "|||||||||||" ;
      Ddo_grid_Columnids = "2:SDTCuentaPorVerificarProfesionals__ProfesionalApellidoPaterno|3:SDTCuentaPorVerificarProfesionals__ProfesionalApellidoMaterno|4:SDTCuentaPorVerificarProfesionals__ProfesionalNombres|5:SDTCuentaPorVerificarProfesionals__ProfesionalTipoDocumento|6:SDTCuentaPorVerificarProfesionals__ProfesionalNroDocumento|7:SDTCuentaPorVerificarProfesionals__ProfesionalSexo|8:SDTCuentaPorVerificarProfesionals__ProfesionalCOP|9:SDTCuentaPorVerificarProfesionals__ProfesionalTelefono|10:SDTCuentaPorVerificarProfesionals__ProfesionalCorreo|11:SDTCuentaPorVerificarProfesionals__ProfesionalFechaRegistro|12:SDTCuentaPorVerificarProfesionals__ProfesionalEstadoCuenta|13:SDTCuentaPorVerificarProfesionals__ProfesionalEstado" ;
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
      GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO_" + sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setName( GXCCtl );
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setWebtags( "" );
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("1", "DNI", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("6", "RUC", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getItemCount() > 0 )
      {
         if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento( cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento()) );
         }
      }
      GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO_" + sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setName( GXCCtl );
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setWebtags( "" );
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.addItem("M", "Masculino", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getItemCount() > 0 )
      {
         if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo())==0) )
         {
            ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo( cmbavSdtcuentaporverificarprofesionals__profesionalsexo.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo()) );
         }
      }
      GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA_" + sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setName( GXCCtl );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setWebtags( "" );
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.addItem("CV", "Cuenta Verificada", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.addItem("CP", "Cuenta Por Verificar", (short)(0));
      if ( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getItemCount() > 0 )
      {
         if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta())==0) )
         {
            ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta( cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta()) );
         }
      }
      GXCCtl = "SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO_" + sGXsfl_37_idx ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setName( GXCCtl );
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setWebtags( "" );
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.addItem("A", "Activo", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.addItem("P", "Pendiente", (short)(0));
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.addItem("I", "Inactivo", (short)(0));
      if ( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getItemCount() > 0 )
      {
         if ( ( AV34GXV1 > 0 ) && ( AV14SDTCuentaPorVerificarProfesionals.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado())==0) )
         {
            ((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado( cmbavSdtcuentaporverificarprofesionals__profesionalestado.getValidValue(((com.projectthani.SdtSDTCuentaPorVerificarProfesional)AV14SDTCuentaPorVerificarProfesionals.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado()) );
         }
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV14SDTCuentaPorVerificarProfesionals',fld:'vSDTCUENTAPORVERIFICARPROFESIONALS',grid:37,pic:'',hsh:true},{av:'nRC_GXsfl_37',ctrl:'GRID',prop:'GridRC',grid:37}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNOMBRES',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNRODOCUMENTO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCOP',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTELEFONO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCORREO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALFECHAREGISTRO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO',prop:'Visible'},{av:'AV27GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV28GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV22ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV47Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV14SDTCuentaPorVerificarProfesionals',fld:'vSDTCUENTAPORVERIFICARPROFESIONALS',grid:37,pic:'',hsh:true},{av:'nRC_GXsfl_37',ctrl:'GRID',prop:'GridRC',grid:37},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV47Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV14SDTCuentaPorVerificarProfesionals',fld:'vSDTCUENTAPORVERIFICARPROFESIONALS',grid:37,pic:'',hsh:true},{av:'nRC_GXsfl_37',ctrl:'GRID',prop:'GridRC',grid:37},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e172N2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV29Update',fld:'vUPDATE',pic:''},{av:'AV31Display',fld:'vDISPLAY',pic:''}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e142N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV47Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV14SDTCuentaPorVerificarProfesionals',fld:'vSDTCUENTAPORVERIFICARPROFESIONALS',grid:37,pic:'',hsh:true},{av:'nRC_GXsfl_37',ctrl:'GRID',prop:'GridRC',grid:37},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNOMBRES',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNRODOCUMENTO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCOP',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTELEFONO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCORREO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALFECHAREGISTRO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO',prop:'Visible'},{av:'AV27GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV28GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV22ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV47Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV14SDTCuentaPorVerificarProfesionals',fld:'vSDTCUENTAPORVERIFICARPROFESIONALS',grid:37,pic:'',hsh:true},{av:'nRC_GXsfl_37',ctrl:'GRID',prop:'GridRC',grid:37},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV24ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOPATERNO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALAPELLIDOMATERNO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNOMBRES',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTIPODOCUMENTO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALNRODOCUMENTO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALSEXO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCOP',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALTELEFONO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALCORREO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALFECHAREGISTRO',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADOCUENTA',prop:'Visible'},{ctrl:'SDTCUENTAPORVERIFICARPROFESIONALS__PROFESIONALESTADO',prop:'Visible'},{av:'AV27GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV28GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV22ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VDISPLAY.CLICK","{handler:'e182N2',iparms:[{av:'AV14SDTCuentaPorVerificarProfesionals',fld:'vSDTCUENTAPORVERIFICARPROFESIONALS',grid:37,pic:'',hsh:true},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_37',ctrl:'GRID',prop:'GridRC',grid:37}]");
      setEventMetadata("VDISPLAY.CLICK",",oparms:[]}");
      setEventMetadata("VALIDV_GXV5","{handler:'validv_Gxv5',iparms:[]");
      setEventMetadata("VALIDV_GXV5",",oparms:[]}");
      setEventMetadata("VALIDV_GXV7","{handler:'validv_Gxv7',iparms:[]");
      setEventMetadata("VALIDV_GXV7",",oparms:[]}");
      setEventMetadata("VALIDV_GXV10","{handler:'validv_Gxv10',iparms:[]");
      setEventMetadata("VALIDV_GXV10",",oparms:[]}");
      setEventMetadata("VALIDV_GXV12","{handler:'validv_Gxv12',iparms:[]");
      setEventMetadata("VALIDV_GXV12",",oparms:[]}");
      setEventMetadata("VALIDV_GXV13","{handler:'validv_Gxv13',iparms:[]");
      setEventMetadata("VALIDV_GXV13",",oparms:[]}");
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
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV19ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV47Pgmname = "" ;
      AV13FilterFullText = "" ;
      AV14SDTCuentaPorVerificarProfesionals = new GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>(com.projectthani.SdtSDTCuentaPorVerificarProfesional.class, "SDTCuentaPorVerificarProfesional", "ProjectThani", remoteHandle);
      Ddo_grid_Caption = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV22ManageFiltersData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV25DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_tableheader = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtneditcolumns_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV29Update = "" ;
      AV31Display = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXt_objcol_SdtSDTCuentaPorVerificarProfesional1 = new GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>(com.projectthani.SdtSDTCuentaPorVerificarProfesional.class, "SDTCuentaPorVerificarProfesional", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTCuentaPorVerificarProfesional2 = new GXBaseCollection[1] ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV23ManageFiltersXml = "" ;
      AV18UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV20ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item10 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState12 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      AV47Pgmname = "WPActivarCuentaProfesional" ;
      /* GeneXus formulas. */
      AV47Pgmname = "WPActivarCuentaProfesional" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled = 0 ;
      cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento.setEnabled( 0 );
      edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled = 0 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalsexo.setEnabled( 0 );
      edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled = 0 ;
      edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled = 0 ;
      cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta.setEnabled( 0 );
      cmbavSdtcuentaporverificarprofesionals__profesionalestado.setEnabled( 0 );
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV24ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte subGrid_Backstyle ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_37 ;
   private int nGXsfl_37_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalnombres_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalcop_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Visible ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalnombres_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalcop_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Enabled ;
   private int edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int AV34GXV1 ;
   private int subGrid_Islastpage ;
   private int GRID_nGridOutOfScope ;
   private int nGXsfl_37_fel_idx=1 ;
   private int AV26PageToGo ;
   private int AV48GXV14 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDisplay_Visible ;
   private long GRID_nFirstRecordOnPage ;
   private long AV27GridCurrentPage ;
   private long AV28GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_37_idx="0001" ;
   private String AV47Pgmname ;
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
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Fixable ;
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
   private String bttBtneditcolumns_Internalname ;
   private String bttBtneditcolumns_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String AV29Update ;
   private String AV31Display ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUpdate_Internalname ;
   private String edtavDisplay_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalnombres_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalcop_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Internalname ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Internalname ;
   private String sGXsfl_37_fel_idx="0001" ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalapellidopaterno_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalapellidomaterno_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalnombres_Jsonclick ;
   private String GXCCtl ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalnrodocumento_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalcop_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionaltelefono_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalcorreo_Jsonclick ;
   private String edtavSdtcuentaporverificarprofesionals__profesionalfecharegistro_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
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
   private boolean bGXsfl_37_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV37 ;
   private boolean gx_refresh_fired ;
   private String AV17ColumnsSelectorXML ;
   private String AV23ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV13FilterFullText ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private HTMLChoice cmbavSdtcuentaporverificarprofesionals__profesionaltipodocumento ;
   private HTMLChoice cmbavSdtcuentaporverificarprofesionals__profesionalsexo ;
   private HTMLChoice cmbavSdtcuentaporverificarprofesionals__profesionalestadocuenta ;
   private HTMLChoice cmbavSdtcuentaporverificarprofesionals__profesionalestado ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional> AV14SDTCuentaPorVerificarProfesionals ;
   private GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional> GXt_objcol_SdtSDTCuentaPorVerificarProfesional1 ;
   private GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional> GXv_objcol_SdtSDTCuentaPorVerificarProfesional2[] ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV22ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item10 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item11[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState12[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV25DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

