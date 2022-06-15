package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secrolefunroleassociationww_impl extends GXDataArea
{
   public secrolefunroleassociationww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secrolefunroleassociationww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolefunroleassociationww_impl.class ));
   }

   public secrolefunroleassociationww_impl( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavIsassociated = UIFactory.getCheckbox(this);
      chkavIsassociatedold = UIFactory.getCheckbox(this);
      cmbSecFunctionalityType = new HTMLChoice();
      chkSecFunctionalityActive = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
            nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
            sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
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
            AV13SecFunctionalityIdRemovedXml = httpContext.GetPar( "SecFunctionalityIdRemovedXml") ;
            AV12SecFunctionalityIdAddedXml = httpContext.GetPar( "SecFunctionalityIdAddedXml") ;
            AV9SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
            A4SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
            AV21i = GXutil.lval( httpContext.GetPar( "i")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV11SecFunctionalityIdRemoved);
            AV15SecFunctionalityIdToFind = GXutil.lval( httpContext.GetPar( "SecFunctionalityIdToFind")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV10SecFunctionalityIdAdded);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A4SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Title", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Confirmationtext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Yesbuttoncaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Nobuttoncaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Cancelbuttoncaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Yesbuttonposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Confirmtype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Result", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Result));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV9SecRoleId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
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
      pa0U2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0U2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331049", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secrolefunroleassociationww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9SecRoleId,4,0))}, new String[] {"SecRoleId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV81GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV82GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV74DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV74DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYIDREMOVEDXML", AV13SecFunctionalityIdRemovedXml);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYIDADDEDXML", AV12SecFunctionalityIdAddedXml);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV38OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV39OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECROLEID", GXutil.ltrim( localUtil.ntoc( AV9SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECROLEID", GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vI", GXutil.ltrim( localUtil.ntoc( AV21i, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECFUNCTIONALITYIDREMOVED", AV11SecFunctionalityIdRemoved);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECFUNCTIONALITYIDREMOVED", AV11SecFunctionalityIdRemoved);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYIDTOFIND", GXutil.ltrim( localUtil.ntoc( AV15SecFunctionalityIdToFind, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECFUNCTIONALITYIDADDED", AV10SecFunctionalityIdAdded);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECFUNCTIONALITYIDADDED", AV10SecFunctionalityIdAdded);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECFUNCTIONALITYROLE", AV16SecFunctionalityRole);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECFUNCTIONALITYROLE", AV16SecFunctionalityRole);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYID_SELECTED", GXutil.ltrim( localUtil.ntoc( AV33SecFunctionalityId_Selected, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Title", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Confirmationtext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Yesbuttoncaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Nobuttoncaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Cancelbuttoncaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Yesbuttonposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Confirmtype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Result", GXutil.rtrim( Dvelop_confirmpanel_uaviewchildren_Result));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
         we0U2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0U2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.projectthani.wwpbaseobjects.secrolefunroleassociationww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9SecRoleId,4,0))}, new String[] {"SecRoleId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecRoleFunRoleAssociationWW" ;
   }

   public String getPgmdesc( )
   {
      return "Asociados a Role" ;
   }

   public void wb0U0( )
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
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"15\">") ;
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
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUaviewchildren_Class+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Key") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Description") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Type") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Parent Functionality Id  ") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Parent Functionality") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Is Active?") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV18IsAssociated));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV19IsAssociatedOld));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavIsassociatedold.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV29UAViewChildren));
            GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUaviewchildren_Class));
            GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavUaviewchildren_Tooltiptext));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A3SecFunctionalityKey);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A8SecFunctionalityDescription);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A9SecFunctionalityType, (byte)(2), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2SecParentFunctionalityId, (byte)(10), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A11SecParentFunctionalityDescription);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( A7SecFunctionalityActive));
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
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirm_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Confirmar", bttBtnconfirm_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecRoleFunRoleAssociationWW.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecRoleFunRoleAssociationWW.htm");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV74DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         wb_table1_40_0U2( true) ;
      }
      else
      {
         wb_table1_40_0U2( false) ;
      }
      return  ;
   }

   public void wb_table1_40_0U2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 15 )
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

   public void start0U2( )
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
         Form.getMeta().addItem("description", "Asociados a Role", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0U0( ) ;
   }

   public void ws0U2( )
   {
      start0U2( ) ;
      evt0U2( ) ;
   }

   public void evt0U2( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e110U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e120U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e130U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e140U2 ();
                              }
                              dynload_actions( ) ;
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "'DOUAVIEWCHILDREN'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "VISASSOCIATED.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "VISASSOCIATED.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "'DOUAVIEWCHILDREN'") == 0 ) )
                        {
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV18IsAssociated = GXutil.strtobool( httpContext.cgiGet( chkavIsassociated.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
                           AV19IsAssociatedOld = GXutil.strtobool( httpContext.cgiGet( chkavIsassociatedold.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
                           com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, AV19IsAssociatedOld));
                           AV29UAViewChildren = httpContext.cgiGet( edtavUaviewchildren_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaviewchildren_Internalname, "Bitmap", ((GXutil.strcmp("", AV29UAViewChildren)==0) ? AV86Uaviewchildren_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV29UAViewChildren))), !bGXsfl_15_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaviewchildren_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV29UAViewChildren), true);
                           A1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") ;
                           A3SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
                           A8SecFunctionalityDescription = httpContext.cgiGet( edtSecFunctionalityDescription_Internalname) ;
                           cmbSecFunctionalityType.setName( cmbSecFunctionalityType.getInternalname() );
                           cmbSecFunctionalityType.setValue( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()) );
                           A9SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
                           A2SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), ",", ".") ;
                           n2SecParentFunctionalityId = false ;
                           A11SecParentFunctionalityDescription = httpContext.cgiGet( edtSecParentFunctionalityDescription_Internalname) ;
                           A7SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( chkSecFunctionalityActive.getInternalname())) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e150U2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e160U2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e170U2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DOUAVIEWCHILDREN'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoUAViewChildren' */
                                 e180U2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VISASSOCIATED.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e190U2 ();
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

   public void we0U2( )
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

   public void pa0U2( )
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
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGrid_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV13SecFunctionalityIdRemovedXml ,
                                 String AV12SecFunctionalityIdAddedXml ,
                                 short AV9SecRoleId ,
                                 short A4SecRoleId ,
                                 long AV21i ,
                                 GXSimpleCollection<Long> AV11SecFunctionalityIdRemoved ,
                                 long AV15SecFunctionalityIdToFind ,
                                 GXSimpleCollection<Long> AV10SecFunctionalityIdAdded )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e160U2 ();
      GRID_nCurrentRecord = 0 ;
      rf0U2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD", getSecureSignedToken( "", AV19IsAssociatedOld));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vISASSOCIATEDOLD", GXutil.booltostr( AV19IsAssociatedOld));
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
      rf0U2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      chkavIsassociatedold.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsassociatedold.getEnabled(), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rf0U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      /* Execute user event: Refresh */
      e160U2 ();
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
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
         subsflControlProps_152( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV38OrderedBy) ,
                                              Boolean.valueOf(AV39OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         /* Using cursor H000U2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_15_idx = 1 ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1SecFunctionalityId = H000U2_A1SecFunctionalityId[0] ;
            A7SecFunctionalityActive = H000U2_A7SecFunctionalityActive[0] ;
            A11SecParentFunctionalityDescription = H000U2_A11SecParentFunctionalityDescription[0] ;
            A2SecParentFunctionalityId = H000U2_A2SecParentFunctionalityId[0] ;
            n2SecParentFunctionalityId = H000U2_n2SecParentFunctionalityId[0] ;
            A9SecFunctionalityType = H000U2_A9SecFunctionalityType[0] ;
            A8SecFunctionalityDescription = H000U2_A8SecFunctionalityDescription[0] ;
            A3SecFunctionalityKey = H000U2_A3SecFunctionalityKey[0] ;
            A11SecParentFunctionalityDescription = H000U2_A11SecParentFunctionalityDescription[0] ;
            e170U2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(15) ;
         wb0U0( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0U2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, AV19IsAssociatedOld));
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
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Short.valueOf(AV38OrderedBy) ,
                                           Boolean.valueOf(AV39OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor H000U3 */
      pr_default.execute(1);
      GRID_nRecordCount = H000U3_AGRID_nRecordCount[0] ;
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
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A4SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A4SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A4SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A4SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A4SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      chkavIsassociatedold.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsassociatedold.getEnabled(), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e150U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV74DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), ",", ".")) ;
         AV81GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV82GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV9SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( "vSECROLEID"), ",", ".")) ;
         AV33SecFunctionalityId_Selected = localUtil.ctol( httpContext.cgiGet( "vSECFUNCTIONALITYID_SELECTED"), ",", ".") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Dvelop_confirmpanel_uaviewchildren_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Title") ;
         Dvelop_confirmpanel_uaviewchildren_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Confirmationtext") ;
         Dvelop_confirmpanel_uaviewchildren_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Yesbuttoncaption") ;
         Dvelop_confirmpanel_uaviewchildren_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Nobuttoncaption") ;
         Dvelop_confirmpanel_uaviewchildren_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_uaviewchildren_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Yesbuttonposition") ;
         Dvelop_confirmpanel_uaviewchildren_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN_Confirmtype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
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
      e150U2 ();
      if (returnInSub) return;
   }

   public void e150U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( "Asociados a Role" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      if ( AV38OrderedBy < 1 )
      {
         AV38OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV74DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV74DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      /* Using cursor H000U4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV9SecRoleId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A4SecRoleId = H000U4_A4SecRoleId[0] ;
         A13SecRoleName = H000U4_A13SecRoleName[0] ;
         Form.setCaption( GXutil.format( "Associate Functionalities to Role :: %1", A13SecRoleName, "", "", "", "", "", "", "", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
   }

   public void e160U2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV77WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV77WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'LOAD LISTS' */
      S122 ();
      if (returnInSub) return;
      AV81GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81GridCurrentPage), 10, 0));
      AV82GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82GridPageCount), 10, 0));
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e110U2( )
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

   public void e120U2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e130U2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV38OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38OrderedBy), 4, 0));
         AV39OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39OrderedDsc", AV39OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e170U2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV29UAViewChildren = context.getHttpContext().getImagePath( "f11923b6-6acd-4a79-bfc0-0cfc6f3bced5", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUaviewchildren_Internalname, AV29UAViewChildren);
      AV86Uaviewchildren_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "f11923b6-6acd-4a79-bfc0-0cfc6f3bced5", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavUaviewchildren_Tooltiptext = "View Actions, Tabs and Modes" ;
      GXt_boolean4 = AV31TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new com.projectthani.wwpbaseobjects.secfunctionalityhaschildren(remoteHandle, context).execute( A1SecFunctionalityId, GXv_boolean5) ;
      secrolefunroleassociationww_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV31TempBoolean = GXt_boolean4 ;
      if ( AV31TempBoolean )
      {
         edtavUaviewchildren_Class = "ActionBaseColorAttribute" ;
      }
      else
      {
         edtavUaviewchildren_Class = "Invisible" ;
      }
      AV34SecRoleIdParm = AV9SecRoleId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34SecRoleIdParm", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34SecRoleIdParm), 4, 0));
      AV19IsAssociatedOld = false ;
      httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, AV19IsAssociatedOld));
      /* Using cursor H000U5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(AV34SecRoleIdParm)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A4SecRoleId = H000U5_A4SecRoleId[0] ;
         AV19IsAssociatedOld = true ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, AV19IsAssociatedOld));
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      AV15SecFunctionalityIdToFind = A1SecFunctionalityId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15SecFunctionalityIdToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecFunctionalityIdToFind), 10, 0));
      if ( AV19IsAssociatedOld )
      {
         /* Execute user subroutine: 'FIND IN REMOVED' */
         S132 ();
         if (returnInSub) return;
      }
      else
      {
         /* Execute user subroutine: 'FIND IN ADDED' */
         S142 ();
         if (returnInSub) return;
      }
      if ( AV21i > 0 )
      {
         AV18IsAssociated = (boolean)(!AV19IsAssociatedOld) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
      }
      else
      {
         AV18IsAssociated = AV19IsAssociatedOld ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(15) ;
      }
      sendrow_152( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
      {
         httpContext.doAjaxLoad(15, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e140U2 ();
      if (returnInSub) return;
   }

   public void e140U2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOAD LISTS' */
      S122 ();
      if (returnInSub) return;
      AV17Success = true ;
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV88GXV1 = 1 ;
      while ( AV88GXV1 <= AV11SecFunctionalityIdRemoved.size() )
      {
         AV14SecFunctionalityId = ((Number) AV11SecFunctionalityIdRemoved.elementAt(-1+AV88GXV1)).longValue() ;
         AV16SecFunctionalityRole = (com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole)new com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole( remoteHandle, context);
         AV16SecFunctionalityRole.Load(AV14SecFunctionalityId, AV9SecRoleId);
         if ( AV16SecFunctionalityRole.Success() )
         {
            AV16SecFunctionalityRole.Delete();
         }
         if ( ! AV16SecFunctionalityRole.Success() )
         {
            AV17Success = false ;
            /* Execute user subroutine: 'SHOW ERROR MESSAGES' */
            S152 ();
            if (returnInSub) return;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV88GXV1 = (int)(AV88GXV1+1) ;
      }
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV89GXV2 = 1 ;
      while ( AV89GXV2 <= AV10SecFunctionalityIdAdded.size() )
      {
         AV14SecFunctionalityId = ((Number) AV10SecFunctionalityIdAdded.elementAt(-1+AV89GXV2)).longValue() ;
         AV16SecFunctionalityRole = (com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole)new com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole( remoteHandle, context);
         AV16SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Secroleid( AV9SecRoleId );
         AV16SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( AV14SecFunctionalityId );
         AV16SecFunctionalityRole.Save();
         if ( ! AV16SecFunctionalityRole.Success() )
         {
            AV17Success = false ;
            /* Execute user subroutine: 'SHOW ERROR MESSAGES' */
            S152 ();
            if (returnInSub) return;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV89GXV2 = (int)(AV89GXV2+1) ;
      }
      if ( AV17Success )
      {
         if ( AV10SecFunctionalityIdAdded.size() + AV11SecFunctionalityIdRemoved.size() > 0 )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secrolefunroleassociationww");
            AV12SecFunctionalityIdAddedXml = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12SecFunctionalityIdAddedXml", AV12SecFunctionalityIdAddedXml);
            AV13SecFunctionalityIdRemovedXml = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13SecFunctionalityIdRemovedXml", AV13SecFunctionalityIdRemovedXml);
            httpContext.GX_msglist.addItem("Datos actualizados satisfactoriamente.");
         }
         else
         {
            httpContext.GX_msglist.addItem("No se efectuaron cambios.");
         }
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16SecFunctionalityRole", AV16SecFunctionalityRole);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e180U2( )
   {
      /* 'DoUAViewChildren' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOAD LISTS' */
      S122 ();
      if (returnInSub) return;
      if ( AV10SecFunctionalityIdAdded.size() + AV11SecFunctionalityIdRemoved.size() > 0 )
      {
         AV33SecFunctionalityId_Selected = A1SecFunctionalityId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33SecFunctionalityId_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33SecFunctionalityId_Selected), 10, 0));
         this.executeUsercontrolMethod("", false, "DVELOP_CONFIRMPANEL_UAVIEWCHILDRENContainer", "Confirm", "", new Object[] {});
      }
      else
      {
         AV32SecRoleId_Selected = AV9SecRoleId ;
         AV33SecFunctionalityId_Selected = A1SecFunctionalityId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33SecFunctionalityId_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33SecFunctionalityId_Selected), 10, 0));
         /* Execute user subroutine: 'DO UAVIEWCHILDREN' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e190U2( )
   {
      /* Isassociated_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOAD LISTS' */
      S122 ();
      if (returnInSub) return;
      AV15SecFunctionalityIdToFind = A1SecFunctionalityId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15SecFunctionalityIdToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecFunctionalityIdToFind), 10, 0));
      if ( AV18IsAssociated )
      {
         if ( AV19IsAssociatedOld )
         {
            /* Execute user subroutine: 'FIND IN REMOVED' */
            S132 ();
            if (returnInSub) return;
            AV11SecFunctionalityIdRemoved.removeItem((int)(AV21i));
         }
         else
         {
            AV10SecFunctionalityIdAdded.add((long)(AV15SecFunctionalityIdToFind), 0);
         }
      }
      else
      {
         if ( AV19IsAssociatedOld )
         {
            AV11SecFunctionalityIdRemoved.add((long)(AV15SecFunctionalityIdToFind), 0);
         }
         else
         {
            /* Execute user subroutine: 'FIND IN ADDED' */
            S142 ();
            if (returnInSub) return;
            AV10SecFunctionalityIdAdded.removeItem((int)(AV21i));
         }
      }
      /* Execute user subroutine: 'SAVE LISTS' */
      S172 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void S112( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV38OrderedBy, 4, 0))+":"+(AV39OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'DO UAVIEWCHILDREN' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wwpbaseobjects.secrolefunroleactionassociationww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9SecRoleId,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV33SecFunctionalityId_Selected,10,0))}, new String[] {"SecRoleId","SecParentFunctionalityId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S142( )
   {
      /* 'FIND IN ADDED' Routine */
      returnInSub = false ;
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV90GXV3 = 1 ;
      while ( AV90GXV3 <= AV10SecFunctionalityIdAdded.size() )
      {
         AV14SecFunctionalityId = ((Number) AV10SecFunctionalityIdAdded.elementAt(-1+AV90GXV3)).longValue() ;
         if ( AV14SecFunctionalityId == AV15SecFunctionalityIdToFind )
         {
            if (true) break;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV90GXV3 = (int)(AV90GXV3+1) ;
      }
      if ( AV21i > AV10SecFunctionalityIdAdded.size() )
      {
         AV21i = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      }
   }

   public void S132( )
   {
      /* 'FIND IN REMOVED' Routine */
      returnInSub = false ;
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV91GXV4 = 1 ;
      while ( AV91GXV4 <= AV11SecFunctionalityIdRemoved.size() )
      {
         AV14SecFunctionalityId = ((Number) AV11SecFunctionalityIdRemoved.elementAt(-1+AV91GXV4)).longValue() ;
         if ( AV14SecFunctionalityId == AV15SecFunctionalityIdToFind )
         {
            if (true) break;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV91GXV4 = (int)(AV91GXV4+1) ;
      }
      if ( AV21i > AV11SecFunctionalityIdRemoved.size() )
      {
         AV21i = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      }
   }

   public void S122( )
   {
      /* 'LOAD LISTS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13SecFunctionalityIdRemovedXml)==0) )
      {
         AV11SecFunctionalityIdRemoved.fromxml(AV13SecFunctionalityIdRemovedXml, null, null);
      }
      if ( ! (GXutil.strcmp("", AV12SecFunctionalityIdAddedXml)==0) )
      {
         AV10SecFunctionalityIdAdded.fromxml(AV12SecFunctionalityIdAddedXml, null, null);
      }
   }

   public void S172( )
   {
      /* 'SAVE LISTS' Routine */
      returnInSub = false ;
      if ( AV11SecFunctionalityIdRemoved.size() > 0 )
      {
         AV13SecFunctionalityIdRemovedXml = AV11SecFunctionalityIdRemoved.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13SecFunctionalityIdRemovedXml", AV13SecFunctionalityIdRemovedXml);
      }
      else
      {
         AV13SecFunctionalityIdRemovedXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13SecFunctionalityIdRemovedXml", AV13SecFunctionalityIdRemovedXml);
      }
      if ( AV10SecFunctionalityIdAdded.size() > 0 )
      {
         AV12SecFunctionalityIdAddedXml = AV10SecFunctionalityIdAdded.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SecFunctionalityIdAddedXml", AV12SecFunctionalityIdAddedXml);
      }
      else
      {
         AV12SecFunctionalityIdAddedXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SecFunctionalityIdAddedXml", AV12SecFunctionalityIdAddedXml);
      }
   }

   public void S152( )
   {
      /* 'SHOW ERROR MESSAGES' Routine */
      returnInSub = false ;
      AV93GXV6 = 1 ;
      AV92GXV5 = AV16SecFunctionalityRole.GetMessages() ;
      while ( AV93GXV6 <= AV92GXV5.size() )
      {
         AV20Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV92GXV5.elementAt(-1+AV93GXV6));
         if ( AV20Message.getgxTv_SdtMessages_Message_Type() == 1 )
         {
            httpContext.GX_msglist.addItem(AV20Message.getgxTv_SdtMessages_Message_Description());
         }
         AV93GXV6 = (int)(AV93GXV6+1) ;
      }
   }

   public void wb_table1_40_0U2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_uaviewchildren_Internalname, tblTabledvelop_confirmpanel_uaviewchildren_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_uaviewchildren.setProperty("Title", Dvelop_confirmpanel_uaviewchildren_Title);
         ucDvelop_confirmpanel_uaviewchildren.setProperty("ConfirmationText", Dvelop_confirmpanel_uaviewchildren_Confirmationtext);
         ucDvelop_confirmpanel_uaviewchildren.setProperty("YesButtonCaption", Dvelop_confirmpanel_uaviewchildren_Yesbuttoncaption);
         ucDvelop_confirmpanel_uaviewchildren.setProperty("NoButtonCaption", Dvelop_confirmpanel_uaviewchildren_Nobuttoncaption);
         ucDvelop_confirmpanel_uaviewchildren.setProperty("CancelButtonCaption", Dvelop_confirmpanel_uaviewchildren_Cancelbuttoncaption);
         ucDvelop_confirmpanel_uaviewchildren.setProperty("YesButtonPosition", Dvelop_confirmpanel_uaviewchildren_Yesbuttonposition);
         ucDvelop_confirmpanel_uaviewchildren.setProperty("ConfirmType", Dvelop_confirmpanel_uaviewchildren_Confirmtype);
         ucDvelop_confirmpanel_uaviewchildren.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_uaviewchildren_Internalname, "DVELOP_CONFIRMPANEL_UAVIEWCHILDRENContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_UAVIEWCHILDRENContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_40_0U2e( true) ;
      }
      else
      {
         wb_table1_40_0U2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV9SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
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
      pa0U2( ) ;
      ws0U2( ) ;
      we0U2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331224", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secrolefunroleassociationww.js", "?20225110331225", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      chkavIsassociated.setInternalname( "vISASSOCIATED_"+sGXsfl_15_idx );
      chkavIsassociatedold.setInternalname( "vISASSOCIATEDOLD_"+sGXsfl_15_idx );
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN_"+sGXsfl_15_idx ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_15_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_15_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_15_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_15_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_15_idx ;
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION_"+sGXsfl_15_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_15_idx );
   }

   public void subsflControlProps_fel_152( )
   {
      chkavIsassociated.setInternalname( "vISASSOCIATED_"+sGXsfl_15_fel_idx );
      chkavIsassociatedold.setInternalname( "vISASSOCIATEDOLD_"+sGXsfl_15_fel_idx );
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN_"+sGXsfl_15_fel_idx ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_15_fel_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_15_fel_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_15_fel_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_15_fel_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_15_fel_idx ;
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION_"+sGXsfl_15_fel_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_15_fel_idx );
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wb0U0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_15_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_15_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_15_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavIsassociated.getEnabled()!=0)&&(chkavIsassociated.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 16,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vISASSOCIATED_" + sGXsfl_15_idx ;
         chkavIsassociated.setName( GXCCtl );
         chkavIsassociated.setWebtags( "" );
         chkavIsassociated.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsassociated.getInternalname(), "TitleCaption", chkavIsassociated.getCaption(), !bGXsfl_15_Refreshing);
         chkavIsassociated.setCheckedValue( "false" );
         AV18IsAssociated = GXutil.strtobool( GXutil.booltostr( AV18IsAssociated)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIsassociated.getInternalname(),GXutil.booltostr( AV18IsAssociated),"","",Integer.valueOf(-1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+((chkavIsassociated.getEnabled()!=0)&&(chkavIsassociated.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,16);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavIsassociatedold.getEnabled()!=0)&&(chkavIsassociatedold.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 17,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         GXCCtl = "vISASSOCIATEDOLD_" + sGXsfl_15_idx ;
         chkavIsassociatedold.setName( GXCCtl );
         chkavIsassociatedold.setWebtags( "" );
         chkavIsassociatedold.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "TitleCaption", chkavIsassociatedold.getCaption(), !bGXsfl_15_Refreshing);
         chkavIsassociatedold.setCheckedValue( "false" );
         AV19IsAssociatedOld = GXutil.strtobool( GXutil.booltostr( AV19IsAssociatedOld)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, AV19IsAssociatedOld));
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIsassociatedold.getInternalname(),GXutil.booltostr( AV19IsAssociatedOld),"","",Integer.valueOf(0),Integer.valueOf(chkavIsassociatedold.getEnabled()),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(17, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavIsassociatedold.getEnabled()!=0)&&(chkavIsassociatedold.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,17);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavUaviewchildren_Enabled!=0)&&(edtavUaviewchildren_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 18,'',false,'',15)\"" : " ") ;
         ClassString = edtavUaviewchildren_Class ;
         StyleString = "" ;
         AV29UAViewChildren_IsBlob = (boolean)(((GXutil.strcmp("", AV29UAViewChildren)==0)&&(GXutil.strcmp("", AV86Uaviewchildren_GXI)==0))||!(GXutil.strcmp("", AV29UAViewChildren)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV29UAViewChildren)==0) ? AV86Uaviewchildren_GXI : httpContext.getResourceRelative(AV29UAViewChildren)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavUaviewchildren_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"",edtavUaviewchildren_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavUaviewchildren_Jsonclick,"'"+""+"'"+",false,"+"'"+"E\\'DOUAVIEWCHILDREN\\'."+sGXsfl_15_idx+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV29UAViewChildren_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityKey_Internalname,A3SecFunctionalityKey,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityKey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityDescription_Internalname,A8SecFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbSecFunctionalityType.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_15_idx ;
            cmbSecFunctionalityType.setName( GXCCtl );
            cmbSecFunctionalityType.setWebtags( "" );
            cmbSecFunctionalityType.addItem("1", "Mode", (short)(0));
            cmbSecFunctionalityType.addItem("2", "Action", (short)(0));
            cmbSecFunctionalityType.addItem("3", "Tab", (short)(0));
            cmbSecFunctionalityType.addItem("4", "Object", (short)(0));
            cmbSecFunctionalityType.addItem("5", "Attribute", (short)(0));
            if ( cmbSecFunctionalityType.getItemCount() > 0 )
            {
               A9SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSecFunctionalityType,cmbSecFunctionalityType.getInternalname(),GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)),Integer.valueOf(1),cmbSecFunctionalityType.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), !bGXsfl_15_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A2SecParentFunctionalityId, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityDescription_Internalname,A11SecParentFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_15_idx ;
         chkSecFunctionalityActive.setName( GXCCtl );
         chkSecFunctionalityActive.setWebtags( "" );
         chkSecFunctionalityActive.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_15_Refreshing);
         chkSecFunctionalityActive.setCheckedValue( "false" );
         A7SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A7SecFunctionalityActive)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSecFunctionalityActive.getInternalname(),GXutil.booltostr( A7SecFunctionalityActive),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         send_integrity_lvl_hashes0U2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_15_idx = ((subGrid_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      /* End function sendrow_152 */
   }

   public void init_default_properties( )
   {
      chkavIsassociated.setInternalname( "vISASSOCIATED" );
      chkavIsassociatedold.setInternalname( "vISASSOCIATEDOLD" );
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN" ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY" ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION" ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE" );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID" ;
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION" ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      bttBtnconfirm_Internalname = "BTNCONFIRM" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Dvelop_confirmpanel_uaviewchildren_Internalname = "DVELOP_CONFIRMPANEL_UAVIEWCHILDREN" ;
      tblTabledvelop_confirmpanel_uaviewchildren_Internalname = "TABLEDVELOP_CONFIRMPANEL_UAVIEWCHILDREN" ;
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
      chkSecFunctionalityActive.setCaption( "" );
      edtSecParentFunctionalityDescription_Jsonclick = "" ;
      edtSecParentFunctionalityId_Jsonclick = "" ;
      cmbSecFunctionalityType.setJsonclick( "" );
      edtSecFunctionalityDescription_Jsonclick = "" ;
      edtSecFunctionalityKey_Jsonclick = "" ;
      edtSecFunctionalityId_Jsonclick = "" ;
      edtavUaviewchildren_Jsonclick = "" ;
      edtavUaviewchildren_Visible = -1 ;
      edtavUaviewchildren_Enabled = 1 ;
      chkavIsassociatedold.setCaption( "" );
      chkavIsassociatedold.setVisible( 0 );
      chkavIsassociated.setCaption( "" );
      chkavIsassociated.setVisible( -1 );
      chkavIsassociated.setEnabled( 1 );
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtavUaviewchildren_Tooltiptext = "View Actions, Tabs and Modes" ;
      chkavIsassociatedold.setEnabled( 1 );
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtavUaviewchildren_Class = "ActionBaseColorAttribute" ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Asociados a Role" );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Dvelop_confirmpanel_uaviewchildren_Confirmtype = "1" ;
      Dvelop_confirmpanel_uaviewchildren_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_uaviewchildren_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_uaviewchildren_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_uaviewchildren_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_uaviewchildren_Confirmationtext = "You will lose the changes made. Are you sure you want to continue?" ;
      Dvelop_confirmpanel_uaviewchildren_Title = "Confirmation of loss changes" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4" ;
      Ddo_grid_Columnids = "4:SecFunctionalityKey|5:SecFunctionalityDescription|6:SecFunctionalityType|8:SecParentFunctionalityDescription" ;
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
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "vISASSOCIATED_" + sGXsfl_15_idx ;
      chkavIsassociated.setName( GXCCtl );
      chkavIsassociated.setWebtags( "" );
      chkavIsassociated.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociated.getInternalname(), "TitleCaption", chkavIsassociated.getCaption(), !bGXsfl_15_Refreshing);
      chkavIsassociated.setCheckedValue( "false" );
      AV18IsAssociated = GXutil.strtobool( GXutil.booltostr( AV18IsAssociated)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
      GXCCtl = "vISASSOCIATEDOLD_" + sGXsfl_15_idx ;
      chkavIsassociatedold.setName( GXCCtl );
      chkavIsassociatedold.setWebtags( "" );
      chkavIsassociatedold.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "TitleCaption", chkavIsassociatedold.getCaption(), !bGXsfl_15_Refreshing);
      chkavIsassociatedold.setCheckedValue( "false" );
      AV19IsAssociatedOld = GXutil.strtobool( GXutil.booltostr( AV19IsAssociatedOld)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, AV19IsAssociatedOld));
      GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_15_idx ;
      cmbSecFunctionalityType.setName( GXCCtl );
      cmbSecFunctionalityType.setWebtags( "" );
      cmbSecFunctionalityType.addItem("1", "Mode", (short)(0));
      cmbSecFunctionalityType.addItem("2", "Action", (short)(0));
      cmbSecFunctionalityType.addItem("3", "Tab", (short)(0));
      cmbSecFunctionalityType.addItem("4", "Object", (short)(0));
      cmbSecFunctionalityType.addItem("5", "Attribute", (short)(0));
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
         A9SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0))))) ;
      }
      GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_15_idx ;
      chkSecFunctionalityActive.setName( GXCCtl );
      chkSecFunctionalityActive.setWebtags( "" );
      chkSecFunctionalityActive.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_15_Refreshing);
      chkSecFunctionalityActive.setCheckedValue( "false" );
      A7SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A7SecFunctionalityActive)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV81GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV82GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e110U2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e120U2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e130U2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV39OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV39OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e170U2',iparms:[{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV29UAViewChildren',fld:'vUAVIEWCHILDREN',pic:''},{av:'edtavUaviewchildren_Tooltiptext',ctrl:'vUAVIEWCHILDREN',prop:'Tooltiptext'},{av:'edtavUaviewchildren_Class',ctrl:'vUAVIEWCHILDREN',prop:'Class'},{av:'AV34SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9'},{av:'AV19IsAssociatedOld',fld:'vISASSOCIATEDOLD',pic:'',hsh:true},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV18IsAssociated',fld:'vISASSOCIATED',pic:''},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("ENTER","{handler:'e140U2',iparms:[{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV16SecFunctionalityRole',fld:'vSECFUNCTIONALITYROLE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV16SecFunctionalityRole',fld:'vSECFUNCTIONALITYROLE',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("'DOUAVIEWCHILDREN'","{handler:'e180U2',iparms:[{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV33SecFunctionalityId_Selected',fld:'vSECFUNCTIONALITYID_SELECTED',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("'DOUAVIEWCHILDREN'",",oparms:[{av:'AV33SecFunctionalityId_Selected',fld:'vSECFUNCTIONALITYID_SELECTED',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("VISASSOCIATED.CLICK","{handler:'e190U2',iparms:[{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV18IsAssociated',fld:'vISASSOCIATED',pic:''},{av:'AV19IsAssociatedOld',fld:'vISASSOCIATEDOLD',pic:'',hsh:true},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VISASSOCIATED.CLICK",",oparms:[{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''}]}");
      setEventMetadata("VALID_SECFUNCTIONALITYID","{handler:'valid_Secfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID","{handler:'valid_Secparentfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Secfunctionalityactive',iparms:[]");
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
      Dvelop_confirmpanel_uaviewchildren_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13SecFunctionalityIdRemovedXml = "" ;
      AV12SecFunctionalityIdAddedXml = "" ;
      AV11SecFunctionalityIdRemoved = new GXSimpleCollection<Long>(Long.class, "internal", "");
      AV10SecFunctionalityIdAdded = new GXSimpleCollection<Long>(Long.class, "internal", "");
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV74DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16SecFunctionalityRole = new com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV29UAViewChildren = "" ;
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtnconfirm_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV86Uaviewchildren_GXI = "" ;
      scmdbuf = "" ;
      H000U2_A1SecFunctionalityId = new long[1] ;
      H000U2_A7SecFunctionalityActive = new boolean[] {false} ;
      H000U2_A11SecParentFunctionalityDescription = new String[] {""} ;
      H000U2_A2SecParentFunctionalityId = new long[1] ;
      H000U2_n2SecParentFunctionalityId = new boolean[] {false} ;
      H000U2_A9SecFunctionalityType = new byte[1] ;
      H000U2_A8SecFunctionalityDescription = new String[] {""} ;
      H000U2_A3SecFunctionalityKey = new String[] {""} ;
      H000U3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      H000U4_A4SecRoleId = new short[1] ;
      H000U4_A13SecRoleName = new String[] {""} ;
      A13SecRoleName = "" ;
      AV77WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      H000U5_A1SecFunctionalityId = new long[1] ;
      H000U5_A4SecRoleId = new short[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV92GXV5 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV20Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      ucDvelop_confirmpanel_uaviewchildren = new com.genexus.webpanels.GXUserControl();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      GXCCtl = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secrolefunroleassociationww__default(),
         new Object[] {
             new Object[] {
            H000U2_A1SecFunctionalityId, H000U2_A7SecFunctionalityActive, H000U2_A11SecParentFunctionalityDescription, H000U2_A2SecParentFunctionalityId, H000U2_n2SecParentFunctionalityId, H000U2_A9SecFunctionalityType, H000U2_A8SecFunctionalityDescription, H000U2_A3SecFunctionalityKey
            }
            , new Object[] {
            H000U3_AGRID_nRecordCount
            }
            , new Object[] {
            H000U4_A4SecRoleId, H000U4_A13SecRoleName
            }
            , new Object[] {
            H000U5_A1SecFunctionalityId, H000U5_A4SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      chkavIsassociatedold.setEnabled( 0 );
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte A9SecFunctionalityType ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short wcpOAV9SecRoleId ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV9SecRoleId ;
   private short A4SecRoleId ;
   private short AV38OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV34SecRoleIdParm ;
   private short AV32SecRoleId_Selected ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_15 ;
   private int nGXsfl_15_idx=1 ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV80PageToGo ;
   private int AV88GXV1 ;
   private int AV89GXV2 ;
   private int AV90GXV3 ;
   private int AV91GXV4 ;
   private int AV93GXV6 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int edtavUaviewchildren_Enabled ;
   private int edtavUaviewchildren_Visible ;
   private long GRID_nFirstRecordOnPage ;
   private long AV21i ;
   private long AV15SecFunctionalityIdToFind ;
   private long AV81GridCurrentPage ;
   private long AV82GridPageCount ;
   private long AV33SecFunctionalityId_Selected ;
   private long A1SecFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long AV14SecFunctionalityId ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Dvelop_confirmpanel_uaviewchildren_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_15_idx="0001" ;
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
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Dvelop_confirmpanel_uaviewchildren_Title ;
   private String Dvelop_confirmpanel_uaviewchildren_Confirmationtext ;
   private String Dvelop_confirmpanel_uaviewchildren_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_uaviewchildren_Nobuttoncaption ;
   private String Dvelop_confirmpanel_uaviewchildren_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_uaviewchildren_Yesbuttonposition ;
   private String Dvelop_confirmpanel_uaviewchildren_Confirmtype ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String edtavUaviewchildren_Class ;
   private String subGrid_Header ;
   private String edtavUaviewchildren_Tooltiptext ;
   private String Gridpaginationbar_Internalname ;
   private String TempTags ;
   private String bttBtnconfirm_Internalname ;
   private String bttBtnconfirm_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUaviewchildren_Internalname ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityDescription_Internalname ;
   private String edtSecParentFunctionalityId_Internalname ;
   private String edtSecParentFunctionalityDescription_Internalname ;
   private String scmdbuf ;
   private String tblTabledvelop_confirmpanel_uaviewchildren_Internalname ;
   private String Dvelop_confirmpanel_uaviewchildren_Internalname ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String GXCCtl ;
   private String sImgUrl ;
   private String edtavUaviewchildren_Jsonclick ;
   private String ROClassString ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String edtSecParentFunctionalityId_Jsonclick ;
   private String edtSecParentFunctionalityDescription_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean AV39OrderedDsc ;
   private boolean wbLoad ;
   private boolean AV18IsAssociated ;
   private boolean AV19IsAssociatedOld ;
   private boolean A7SecFunctionalityActive ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean n2SecParentFunctionalityId ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV31TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean AV17Success ;
   private boolean AV29UAViewChildren_IsBlob ;
   private String AV13SecFunctionalityIdRemovedXml ;
   private String AV12SecFunctionalityIdAddedXml ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV86Uaviewchildren_GXI ;
   private String A13SecRoleName ;
   private String AV29UAViewChildren ;
   private GXSimpleCollection<Long> AV11SecFunctionalityIdRemoved ;
   private GXSimpleCollection<Long> AV10SecFunctionalityIdAdded ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_uaviewchildren ;
   private ICheckbox chkavIsassociated ;
   private ICheckbox chkavIsassociatedold ;
   private HTMLChoice cmbSecFunctionalityType ;
   private ICheckbox chkSecFunctionalityActive ;
   private IDataStoreProvider pr_default ;
   private long[] H000U2_A1SecFunctionalityId ;
   private boolean[] H000U2_A7SecFunctionalityActive ;
   private String[] H000U2_A11SecParentFunctionalityDescription ;
   private long[] H000U2_A2SecParentFunctionalityId ;
   private boolean[] H000U2_n2SecParentFunctionalityId ;
   private byte[] H000U2_A9SecFunctionalityType ;
   private String[] H000U2_A8SecFunctionalityDescription ;
   private String[] H000U2_A3SecFunctionalityKey ;
   private long[] H000U3_AGRID_nRecordCount ;
   private short[] H000U4_A4SecRoleId ;
   private String[] H000U4_A13SecRoleName ;
   private long[] H000U5_A1SecFunctionalityId ;
   private short[] H000U5_A4SecRoleId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV92GXV5 ;
   private com.genexus.SdtMessages_Message AV20Message ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV77WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole AV16SecFunctionalityRole ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV74DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class secrolefunroleassociationww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H000U2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV38OrderedBy ,
                                          boolean AV39OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[3];
      Object[] GXv_Object7 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[SecFunctionalityId], T1.[SecFunctionalityActive], T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecParentFunctionalityId] AS SecParentFunctionalityId," ;
      sSelectString += " T1.[SecFunctionalityType], T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey]" ;
      sFromString = " FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecParentFunctionalityId])" ;
      sOrderString = "" ;
      if ( ( AV38OrderedBy == 1 ) && ! AV39OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityKey]" ;
      }
      else if ( ( AV38OrderedBy == 1 ) && ( AV39OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ! AV39OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ( AV39OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ! AV39OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityType]" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ( AV39OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV38OrderedBy == 4 ) && ! AV39OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV38OrderedBy == 4 ) && ( AV39OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[SecFunctionalityDescription] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[SecFunctionalityId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_H000U3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV38OrderedBy ,
                                          boolean AV39OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecParentFunctionalityId])" ;
      scmdbuf += sWhereString ;
      if ( ( AV38OrderedBy == 1 ) && ! AV39OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 1 ) && ( AV39OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ! AV39OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ( AV39OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ! AV39OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ( AV39OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 4 ) && ! AV39OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 4 ) && ( AV39OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object8[0] = scmdbuf ;
      return GXv_Object8 ;
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
                  return conditional_H000U2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() );
            case 1 :
                  return conditional_H000U3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H000U2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H000U3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H000U4", "SELECT [SecRoleId], [SecRoleName] FROM [SecRole] WHERE [SecRoleId] = ? ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H000U5", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WHERE [SecFunctionalityId] = ? and [SecRoleId] = ? ORDER BY [SecFunctionalityId], [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

