package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidadcitawc_impl extends GXWebComponent
{
   public disponibilidadcitawc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidadcitawc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadcitawc_impl.class ));
   }

   public disponibilidadcitawc_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
      cmbCitaTipoDiagnostico = new HTMLChoice();
      cmbCitaEstadoCita = new HTMLChoice();
      cmbCitaEstado = new HTMLChoice();
      chkCitaConsentimiento = UIFactory.getCheckbox(this);
      chkCitaGestante = UIFactory.getCheckbox(this);
      cmbCitaEstadoPago = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "SGCitaDisponibilidadId") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV8SGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SGCitaDisponibilidadId), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV8SGCitaDisponibilidadId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "SGCitaDisponibilidadId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "SGCitaDisponibilidadId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
            {
               nRC_GXsfl_37 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_37"))) ;
               nGXsfl_37_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_37_idx"))) ;
               sGXsfl_37_idx = httpContext.GetPar( "sGXsfl_37_idx") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
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
               AV8SGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadId"))) ;
               AV20ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
               AV36Pgmname = httpContext.GetPar( "Pgmname") ;
               AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
               AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
               AV27IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
               AV29IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
               AV32IsAuthorized_PacienteNombres = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_PacienteNombres")) ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               init_default_properties( ) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV8SGCitaDisponibilidadId, AV20ManageFiltersExecutionStep, AV36Pgmname, AV14OrderedBy, AV15OrderedDsc, AV27IsAuthorized_Update, AV29IsAuthorized_Delete, AV32IsAuthorized_PacienteNombres, sPrefix) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa3T2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.projectthani.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "Disponibilidad Cita WC") ;
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
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110322713", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.disponibilidadcitawc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8SGCitaDisponibilidadId,8,0))}, new String[] {"SGCitaDisponibilidadId"}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV36Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV29IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( sPrefix, AV32IsAuthorized_PacienteNombres));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXH_vFILTERFULLTEXT", AV16FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_37", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_37, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMANAGEFILTERSDATA", AV18ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMANAGEFILTERSDATA", AV18ManageFiltersData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV24GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV25GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8SGCitaDisponibilidadId", GXutil.ltrim( localUtil.ntoc( wcpOAV8SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV20ManageFiltersExecutionStep, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV36Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV36Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV15OrderedDsc);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV27IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV29IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV29IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_PACIENTENOMBRES", AV32IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( sPrefix, AV32IsAuthorized_PacienteNombres));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vGRIDSTATE", AV12GridState);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSGCITADISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV8SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm3T2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "DisponibilidadCitaWC" ;
   }

   public String getPgmdesc( )
   {
      return "Disponibilidad Cita WC" ;
   }

   public void wb3T0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.disponibilidadcitawc");
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
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablegridheader_Internalname, 1, 0, "px", 0, "px", "Table100x100", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         ucDvpanel_tableheader.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableheader_Internalname, sPrefix+"DVPANEL_TABLEHEADERContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEHEADERContainer"+"TableHeader"+"\" style=\"display:none;\">") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 37, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DisponibilidadCitaWC.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_22_3T2( true) ;
      }
      else
      {
         wb_table1_22_3T2( false) ;
      }
      return  ;
   }

   public void wb_table1_22_3T2e( boolean wbgen )
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
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"37\">") ;
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Diagnostico") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Informe") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Antecedentes") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(410), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Link") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Reserva") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Log") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Gen Link") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Motivo Consulta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Archivo Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Image"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Archivo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Archivo Extencion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Consentimiento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Gestante") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado Pago") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Peso") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estatura") ;
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
            GridContainer.AddObjectProperty("CmpContext", sPrefix);
            GridContainer.AddObjectProperty("InMasterPage", "false");
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV26Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV28Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A64CitaCode);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCitaCode_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A103PacienteApellidoPaterno);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A104PacienteApellidoMaterno);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A105PacienteNombres);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtPacienteNombres_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A106PacienteNroDocumento);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A65CitaTipoDiagnostico);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A89CitaEstadoCita));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A90CitaInforme);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A100CitaAntecedentes);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A91CitaLink);
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCitaLink_Link));
            GridColumn.AddObjectProperty("Linktarget", GXutil.rtrim( edtCitaLink_Linktarget));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A92CitaFechaReserva, 10, 8, 0, 3, "/", ":", " "));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A93CitaLog);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A94CitaEmailGenLink);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A95CitaEstado));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A99CitaMotivoConsulta);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A96CitaArchivoNombre);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A98CitaArchivo);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A333CitaArchivoExtencion);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( A97CitaConsentimiento));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.booltostr( A101CitaGestante));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A102CitaEstadoPago));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A306CitaPeso, (byte)(6), (byte)(2), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A307CitaEstatura, (byte)(4), (byte)(2), ".", "")));
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
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV24GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV25GridPageCount);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadId_Jsonclick, 0, "Attribute", "", "", "", "", edtSGCitaDisponibilidadId_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_DisponibilidadCitaWC.htm");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
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
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start3T2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "Disponibilidad Cita WC", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup3T0( ) ;
         }
      }
   }

   public void ws3T2( )
   {
      start3T2( ) ;
      evt3T2( ) ;
   }

   public void evt3T2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e113T2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e123T2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e133T2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e143T2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoInsert' */
                                 e153T2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavFilterfulltext_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3T0( ) ;
                           }
                           nGXsfl_37_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_372( ) ;
                           AV26Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV26Update);
                           AV28Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV28Delete);
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
                           A92CitaFechaReserva = localUtil.ctot( httpContext.cgiGet( edtCitaFechaReserva_Internalname), 0) ;
                           n92CitaFechaReserva = false ;
                           A93CitaLog = httpContext.cgiGet( edtCitaLog_Internalname) ;
                           n93CitaLog = false ;
                           A94CitaEmailGenLink = httpContext.cgiGet( edtCitaEmailGenLink_Internalname) ;
                           n94CitaEmailGenLink = false ;
                           cmbCitaEstado.setName( cmbCitaEstado.getInternalname() );
                           cmbCitaEstado.setValue( httpContext.cgiGet( cmbCitaEstado.getInternalname()) );
                           A95CitaEstado = httpContext.cgiGet( cmbCitaEstado.getInternalname()) ;
                           n95CitaEstado = false ;
                           A99CitaMotivoConsulta = httpContext.cgiGet( edtCitaMotivoConsulta_Internalname) ;
                           n99CitaMotivoConsulta = false ;
                           A96CitaArchivoNombre = httpContext.cgiGet( edtCitaArchivoNombre_Internalname) ;
                           n96CitaArchivoNombre = false ;
                           A98CitaArchivo = httpContext.cgiGet( edtCitaArchivo_Internalname) ;
                           n98CitaArchivo = false ;
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), !bGXsfl_37_Refreshing);
                           A333CitaArchivoExtencion = httpContext.cgiGet( edtCitaArchivoExtencion_Internalname) ;
                           n333CitaArchivoExtencion = false ;
                           A97CitaConsentimiento = GXutil.strtobool( httpContext.cgiGet( chkCitaConsentimiento.getInternalname())) ;
                           n97CitaConsentimiento = false ;
                           A101CitaGestante = GXutil.strtobool( httpContext.cgiGet( chkCitaGestante.getInternalname())) ;
                           n101CitaGestante = false ;
                           cmbCitaEstadoPago.setName( cmbCitaEstadoPago.getInternalname() );
                           cmbCitaEstadoPago.setValue( httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) );
                           A102CitaEstadoPago = httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) ;
                           n102CitaEstadoPago = false ;
                           A306CitaPeso = localUtil.ctond( httpContext.cgiGet( edtCitaPeso_Internalname)) ;
                           n306CitaPeso = false ;
                           A307CitaEstatura = localUtil.ctond( httpContext.cgiGet( edtCitaEstatura_Internalname)) ;
                           n307CitaEstatura = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e163T2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e173T2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e183T2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          /* Set Refresh If Filterfulltext Changed */
                                          if ( GXutil.strcmp(httpContext.cgiGet( sPrefix+"GXH_vFILTERFULLTEXT"), AV16FilterFullText) != 0 )
                                          {
                                             Rfr0gs = true ;
                                          }
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup3T0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavFilterfulltext_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
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

   public void we3T2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3T2( ) ;
         }
      }
   }

   public void pa3T2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavFilterfulltext_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
                                 String AV16FilterFullText ,
                                 int AV8SGCitaDisponibilidadId ,
                                 byte AV20ManageFiltersExecutionStep ,
                                 String AV36Pgmname ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 boolean AV27IsAuthorized_Update ,
                                 boolean AV29IsAuthorized_Delete ,
                                 boolean AV32IsAuthorized_PacienteNombres ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e173T2 ();
      GRID_nCurrentRecord = 0 ;
      rf3T2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CITAID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CITAID", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
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
      rf3T2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV36Pgmname = "DisponibilidadCitaWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_37_Refreshing);
   }

   public void rf3T2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(37) ;
      /* Execute user event: Refresh */
      e173T2 ();
      nGXsfl_37_idx = 1 ;
      sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_372( ) ;
      bGXsfl_37_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
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
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV16FilterFullText ,
                                              Integer.valueOf(A19CitaId) ,
                                              A64CitaCode ,
                                              Integer.valueOf(A20PacienteId) ,
                                              A103PacienteApellidoPaterno ,
                                              A104PacienteApellidoMaterno ,
                                              A105PacienteNombres ,
                                              A106PacienteNroDocumento ,
                                              A65CitaTipoDiagnostico ,
                                              A89CitaEstadoCita ,
                                              A90CitaInforme ,
                                              A100CitaAntecedentes ,
                                              A91CitaLink ,
                                              A93CitaLog ,
                                              A94CitaEmailGenLink ,
                                              A95CitaEstado ,
                                              A99CitaMotivoConsulta ,
                                              A96CitaArchivoNombre ,
                                              A333CitaArchivoExtencion ,
                                              A102CitaEstadoPago ,
                                              A306CitaPeso ,
                                              A307CitaEstatura ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV8SGCitaDisponibilidadId) ,
                                              Integer.valueOf(A21SGCitaDisponibilidadId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
         /* Using cursor H003T2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8SGCitaDisponibilidadId), lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_37_idx = 1 ;
         sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_372( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A21SGCitaDisponibilidadId = H003T2_A21SGCitaDisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            A307CitaEstatura = H003T2_A307CitaEstatura[0] ;
            n307CitaEstatura = H003T2_n307CitaEstatura[0] ;
            A306CitaPeso = H003T2_A306CitaPeso[0] ;
            n306CitaPeso = H003T2_n306CitaPeso[0] ;
            A102CitaEstadoPago = H003T2_A102CitaEstadoPago[0] ;
            n102CitaEstadoPago = H003T2_n102CitaEstadoPago[0] ;
            A101CitaGestante = H003T2_A101CitaGestante[0] ;
            n101CitaGestante = H003T2_n101CitaGestante[0] ;
            A97CitaConsentimiento = H003T2_A97CitaConsentimiento[0] ;
            n97CitaConsentimiento = H003T2_n97CitaConsentimiento[0] ;
            A333CitaArchivoExtencion = H003T2_A333CitaArchivoExtencion[0] ;
            n333CitaArchivoExtencion = H003T2_n333CitaArchivoExtencion[0] ;
            A98CitaArchivo = H003T2_A98CitaArchivo[0] ;
            n98CitaArchivo = H003T2_n98CitaArchivo[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), !bGXsfl_37_Refreshing);
            A96CitaArchivoNombre = H003T2_A96CitaArchivoNombre[0] ;
            n96CitaArchivoNombre = H003T2_n96CitaArchivoNombre[0] ;
            A99CitaMotivoConsulta = H003T2_A99CitaMotivoConsulta[0] ;
            n99CitaMotivoConsulta = H003T2_n99CitaMotivoConsulta[0] ;
            A95CitaEstado = H003T2_A95CitaEstado[0] ;
            n95CitaEstado = H003T2_n95CitaEstado[0] ;
            A94CitaEmailGenLink = H003T2_A94CitaEmailGenLink[0] ;
            n94CitaEmailGenLink = H003T2_n94CitaEmailGenLink[0] ;
            A93CitaLog = H003T2_A93CitaLog[0] ;
            n93CitaLog = H003T2_n93CitaLog[0] ;
            A92CitaFechaReserva = H003T2_A92CitaFechaReserva[0] ;
            n92CitaFechaReserva = H003T2_n92CitaFechaReserva[0] ;
            A91CitaLink = H003T2_A91CitaLink[0] ;
            n91CitaLink = H003T2_n91CitaLink[0] ;
            A100CitaAntecedentes = H003T2_A100CitaAntecedentes[0] ;
            n100CitaAntecedentes = H003T2_n100CitaAntecedentes[0] ;
            A90CitaInforme = H003T2_A90CitaInforme[0] ;
            n90CitaInforme = H003T2_n90CitaInforme[0] ;
            A89CitaEstadoCita = H003T2_A89CitaEstadoCita[0] ;
            n89CitaEstadoCita = H003T2_n89CitaEstadoCita[0] ;
            A65CitaTipoDiagnostico = H003T2_A65CitaTipoDiagnostico[0] ;
            n65CitaTipoDiagnostico = H003T2_n65CitaTipoDiagnostico[0] ;
            A106PacienteNroDocumento = H003T2_A106PacienteNroDocumento[0] ;
            A105PacienteNombres = H003T2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H003T2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H003T2_A103PacienteApellidoPaterno[0] ;
            A20PacienteId = H003T2_A20PacienteId[0] ;
            A64CitaCode = H003T2_A64CitaCode[0] ;
            A19CitaId = H003T2_A19CitaId[0] ;
            A106PacienteNroDocumento = H003T2_A106PacienteNroDocumento[0] ;
            A105PacienteNombres = H003T2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H003T2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H003T2_A103PacienteApellidoPaterno[0] ;
            e183T2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(37) ;
         wb3T0( ) ;
      }
      bGXsfl_37_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes3T2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV36Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV36Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV27IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV29IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV29IsAuthorized_Delete));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_PACIENTENOMBRES", AV32IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( sPrefix, AV32IsAuthorized_PacienteNombres));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CITAID"+"_"+sGXsfl_37_idx, getSecureSignedToken( sPrefix+sGXsfl_37_idx, localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")));
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
                                           AV16FilterFullText ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           A65CitaTipoDiagnostico ,
                                           A89CitaEstadoCita ,
                                           A90CitaInforme ,
                                           A100CitaAntecedentes ,
                                           A91CitaLink ,
                                           A93CitaLog ,
                                           A94CitaEmailGenLink ,
                                           A95CitaEstado ,
                                           A99CitaMotivoConsulta ,
                                           A96CitaArchivoNombre ,
                                           A333CitaArchivoExtencion ,
                                           A102CitaEstadoPago ,
                                           A306CitaPeso ,
                                           A307CitaEstatura ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV8SGCitaDisponibilidadId) ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      lV16FilterFullText = GXutil.concat( GXutil.rtrim( AV16FilterFullText), "%", "") ;
      /* Using cursor H003T3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8SGCitaDisponibilidadId), lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText, lV16FilterFullText});
      GRID_nRecordCount = H003T3_AGRID_nRecordCount[0] ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV8SGCitaDisponibilidadId, AV20ManageFiltersExecutionStep, AV36Pgmname, AV14OrderedBy, AV15OrderedDsc, AV27IsAuthorized_Update, AV29IsAuthorized_Delete, AV32IsAuthorized_PacienteNombres, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV8SGCitaDisponibilidadId, AV20ManageFiltersExecutionStep, AV36Pgmname, AV14OrderedBy, AV15OrderedDsc, AV27IsAuthorized_Update, AV29IsAuthorized_Delete, AV32IsAuthorized_PacienteNombres, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV8SGCitaDisponibilidadId, AV20ManageFiltersExecutionStep, AV36Pgmname, AV14OrderedBy, AV15OrderedDsc, AV27IsAuthorized_Update, AV29IsAuthorized_Delete, AV32IsAuthorized_PacienteNombres, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV8SGCitaDisponibilidadId, AV20ManageFiltersExecutionStep, AV36Pgmname, AV14OrderedBy, AV15OrderedDsc, AV27IsAuthorized_Update, AV29IsAuthorized_Delete, AV32IsAuthorized_PacienteNombres, sPrefix) ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV16FilterFullText, AV8SGCitaDisponibilidadId, AV20ManageFiltersExecutionStep, AV36Pgmname, AV14OrderedBy, AV15OrderedDsc, AV27IsAuthorized_Update, AV29IsAuthorized_Delete, AV32IsAuthorized_PacienteNombres, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV36Pgmname = "DisponibilidadCitaWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_37_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup3T0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e163T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vMANAGEFILTERSDATA"), AV18ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV21DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_37 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_37"), ",", ".")) ;
         AV24GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), ",", ".") ;
         AV25GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), ",", ".") ;
         wcpOAV8SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8SGCitaDisponibilidadId"), ",", ".")) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_managefilters_Icontype = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Cls") ;
         Dvpanel_tableheader_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Width") ;
         Dvpanel_tableheader_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Autowidth")) ;
         Dvpanel_tableheader_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Autoheight")) ;
         Dvpanel_tableheader_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Cls") ;
         Dvpanel_tableheader_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Title") ;
         Dvpanel_tableheader_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Collapsible")) ;
         Dvpanel_tableheader_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Collapsed")) ;
         Dvpanel_tableheader_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Showcollapseicon")) ;
         Dvpanel_tableheader_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Iconposition") ;
         Dvpanel_tableheader_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEHEADER_Autoscroll")) ;
         Gridpaginationbar_Class = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( sPrefix+"DDO_GRID_Caption") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV16FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FilterFullText", AV16FilterFullText);
         A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( sPrefix+"GXH_vFILTERFULLTEXT"), AV16FilterFullText) != 0 )
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
      e163T2 ();
      if (returnInSub) return;
   }

   public void e163T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      /* Execute user subroutine: 'LOADSAVEDFILTERS' */
      S112 ();
      if (returnInSub) return;
      GXt_boolean1 = AV32IsAuthorized_PacienteNombres ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
      disponibilidadcitawc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV32IsAuthorized_PacienteNombres = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32IsAuthorized_PacienteNombres", AV32IsAuthorized_PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_PACIENTENOMBRES", getSecureSignedToken( sPrefix, AV32IsAuthorized_PacienteNombres));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtSGCitaDisponibilidadId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtSGCitaDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV14OrderedBy < 1 )
      {
         AV14OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV21DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV21DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e173T2( )
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
      if ( AV20ManageFiltersExecutionStep == 1 )
      {
         AV20ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ManageFiltersExecutionStep", GXutil.str( AV20ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV20ManageFiltersExecutionStep == 2 )
      {
         AV20ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ManageFiltersExecutionStep", GXutil.str( AV20ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      AV24GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
      AV25GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GridPageCount), 10, 0));
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV18ManageFiltersData", AV18ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
   }

   public void e123T2( )
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
         AV23PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV23PageToGo) ;
      }
   }

   public void e133T2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e143T2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV14OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         AV15OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15OrderedDsc", AV15OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e183T2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV26Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV26Update);
      if ( AV27IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0))}, new String[] {"Mode","CitaId"})  ;
      }
      AV28Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV28Delete);
      if ( AV29IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0))}, new String[] {"Mode","CitaId"})  ;
      }
      edtCitaCode_Link = formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CitaId","TabCode"})  ;
      if ( AV32IsAuthorized_PacienteNombres )
      {
         edtPacienteNombres_Link = formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PacienteId","TabCode"})  ;
      }
      edtCitaLink_Linktarget = "_blank" ;
      edtCitaLink_Link = A91CitaLink ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(37) ;
      }
      sendrow_372( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_37_Refreshing )
      {
         httpContext.doAjaxLoad(37, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e113T2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S172 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("DisponibilidadCitaWCFilters")),GXutil.URLEncode(GXutil.rtrim(AV36Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV20ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ManageFiltersExecutionStep", GXutil.str( AV20ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("DisponibilidadCitaWCFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV20ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ManageFiltersExecutionStep", GXutil.str( AV20ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else
      {
         GXt_char6 = AV19ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "DisponibilidadCitaWCFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         disponibilidadcitawc_impl.this.GXt_char6 = GXv_char7[0] ;
         AV19ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV19ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem("El filtro seleccionado no existe más.");
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV36Pgmname+"GridState", AV19ManageFiltersXml) ;
            AV12GridState.fromxml(AV19ManageFiltersXml, null, null);
            AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
            AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15OrderedDsc", AV15OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S182 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
            httpContext.doAjaxRefreshCmp(sPrefix);
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV18ManageFiltersData", AV18ManageFiltersData);
   }

   public void e153T2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","CitaId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV14OrderedBy, 4, 0))+":"+(AV15OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV27IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Update", GXv_boolean2) ;
      disponibilidadcitawc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV27IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27IsAuthorized_Update", AV27IsAuthorized_Update);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      if ( ! ( AV27IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_37_Refreshing);
      }
      GXt_boolean1 = AV29IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Delete", GXv_boolean2) ;
      disponibilidadcitawc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV29IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29IsAuthorized_Delete", AV29IsAuthorized_Delete);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV29IsAuthorized_Delete));
      if ( ! ( AV29IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_37_Refreshing);
      }
      GXt_boolean1 = AV30TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Insert", GXv_boolean2) ;
      disponibilidadcitawc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV30TempBoolean = GXt_boolean1 ;
      if ( ! ( AV30TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = AV18ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
      new com.projectthani.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "DisponibilidadCitaWCFilters", "", "", GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[0] ;
      AV18ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FilterFullText", AV16FilterFullText);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV17Session.getValue(AV36Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV36Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV17Session.getValue(AV36Pgmname+"GridState"), null, null);
      }
      AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
      AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15OrderedDsc", AV15OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S182 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S182( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV37GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV16FilterFullText = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FilterFullText", AV16FilterFullText);
         }
         AV37GXV1 = (int)(AV37GXV1+1) ;
      }
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV17Session.getValue(AV36Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState10[0] = AV12GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "FILTERFULLTEXT", !(GXutil.strcmp("", AV16FilterFullText)==0), (short)(0), AV16FilterFullText, "") ;
      AV12GridState = GXv_SdtWWPGridState10[0] ;
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV36Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV36Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Cita" );
      AV11TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV11TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "SGCitaDisponibilidadId" );
      AV11TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8SGCitaDisponibilidadId, 8, 0) );
      AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV11TrnContextAtt, 0);
      AV17Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_22_3T2( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV18ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, sPrefix+"DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_27_3T2( true) ;
      }
      else
      {
         wb_table2_27_3T2( false) ;
      }
      return  ;
   }

   public void wb_table2_27_3T2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_3T2e( true) ;
      }
      else
      {
         wb_table1_22_3T2e( false) ;
      }
   }

   public void wb_table2_27_3T2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'" + sPrefix + "',false,'" + sGXsfl_37_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV16FilterFullText, GXutil.rtrim( localUtil.format( AV16FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_DisponibilidadCitaWC.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_27_3T2e( true) ;
      }
      else
      {
         wb_table2_27_3T2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8SGCitaDisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SGCitaDisponibilidadId), 8, 0));
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
      pa3T2( ) ;
      ws3T2( ) ;
      we3T2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV8SGCitaDisponibilidadId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3T2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "disponibilidadcitawc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3T2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV8SGCitaDisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SGCitaDisponibilidadId), 8, 0));
      }
      wcpOAV8SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8SGCitaDisponibilidadId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( AV8SGCitaDisponibilidadId != wcpOAV8SGCitaDisponibilidadId ) ) )
      {
         setjustcreated();
      }
      wcpOAV8SGCitaDisponibilidadId = AV8SGCitaDisponibilidadId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV8SGCitaDisponibilidadId = httpContext.cgiGet( sPrefix+"AV8SGCitaDisponibilidadId_CTRL") ;
      if ( GXutil.len( sCtrlAV8SGCitaDisponibilidadId) > 0 )
      {
         AV8SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV8SGCitaDisponibilidadId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SGCitaDisponibilidadId), 8, 0));
      }
      else
      {
         AV8SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV8SGCitaDisponibilidadId_PARM"), ",", ".")) ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa3T2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3T2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws3T2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8SGCitaDisponibilidadId_PARM", GXutil.ltrim( localUtil.ntoc( AV8SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8SGCitaDisponibilidadId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8SGCitaDisponibilidadId_CTRL", GXutil.rtrim( sCtrlAV8SGCitaDisponibilidadId));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we3T2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323022", true, true);
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
      httpContext.AddJavascriptSource("disponibilidadcitawc.js", "?20225110323022", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_372( )
   {
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_37_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_37_idx ;
      edtCitaId_Internalname = sPrefix+"CITAID_"+sGXsfl_37_idx ;
      edtCitaCode_Internalname = sPrefix+"CITACODE_"+sGXsfl_37_idx ;
      edtPacienteId_Internalname = sPrefix+"PACIENTEID_"+sGXsfl_37_idx ;
      edtPacienteApellidoPaterno_Internalname = sPrefix+"PACIENTEAPELLIDOPATERNO_"+sGXsfl_37_idx ;
      edtPacienteApellidoMaterno_Internalname = sPrefix+"PACIENTEAPELLIDOMATERNO_"+sGXsfl_37_idx ;
      edtPacienteNombres_Internalname = sPrefix+"PACIENTENOMBRES_"+sGXsfl_37_idx ;
      edtPacienteNroDocumento_Internalname = sPrefix+"PACIENTENRODOCUMENTO_"+sGXsfl_37_idx ;
      cmbCitaTipoDiagnostico.setInternalname( sPrefix+"CITATIPODIAGNOSTICO_"+sGXsfl_37_idx );
      cmbCitaEstadoCita.setInternalname( sPrefix+"CITAESTADOCITA_"+sGXsfl_37_idx );
      edtCitaInforme_Internalname = sPrefix+"CITAINFORME_"+sGXsfl_37_idx ;
      edtCitaAntecedentes_Internalname = sPrefix+"CITAANTECEDENTES_"+sGXsfl_37_idx ;
      edtCitaLink_Internalname = sPrefix+"CITALINK_"+sGXsfl_37_idx ;
      edtCitaFechaReserva_Internalname = sPrefix+"CITAFECHARESERVA_"+sGXsfl_37_idx ;
      edtCitaLog_Internalname = sPrefix+"CITALOG_"+sGXsfl_37_idx ;
      edtCitaEmailGenLink_Internalname = sPrefix+"CITAEMAILGENLINK_"+sGXsfl_37_idx ;
      cmbCitaEstado.setInternalname( sPrefix+"CITAESTADO_"+sGXsfl_37_idx );
      edtCitaMotivoConsulta_Internalname = sPrefix+"CITAMOTIVOCONSULTA_"+sGXsfl_37_idx ;
      edtCitaArchivoNombre_Internalname = sPrefix+"CITAARCHIVONOMBRE_"+sGXsfl_37_idx ;
      edtCitaArchivo_Internalname = sPrefix+"CITAARCHIVO_"+sGXsfl_37_idx ;
      edtCitaArchivoExtencion_Internalname = sPrefix+"CITAARCHIVOEXTENCION_"+sGXsfl_37_idx ;
      chkCitaConsentimiento.setInternalname( sPrefix+"CITACONSENTIMIENTO_"+sGXsfl_37_idx );
      chkCitaGestante.setInternalname( sPrefix+"CITAGESTANTE_"+sGXsfl_37_idx );
      cmbCitaEstadoPago.setInternalname( sPrefix+"CITAESTADOPAGO_"+sGXsfl_37_idx );
      edtCitaPeso_Internalname = sPrefix+"CITAPESO_"+sGXsfl_37_idx ;
      edtCitaEstatura_Internalname = sPrefix+"CITAESTATURA_"+sGXsfl_37_idx ;
   }

   public void subsflControlProps_fel_372( )
   {
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_37_fel_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_37_fel_idx ;
      edtCitaId_Internalname = sPrefix+"CITAID_"+sGXsfl_37_fel_idx ;
      edtCitaCode_Internalname = sPrefix+"CITACODE_"+sGXsfl_37_fel_idx ;
      edtPacienteId_Internalname = sPrefix+"PACIENTEID_"+sGXsfl_37_fel_idx ;
      edtPacienteApellidoPaterno_Internalname = sPrefix+"PACIENTEAPELLIDOPATERNO_"+sGXsfl_37_fel_idx ;
      edtPacienteApellidoMaterno_Internalname = sPrefix+"PACIENTEAPELLIDOMATERNO_"+sGXsfl_37_fel_idx ;
      edtPacienteNombres_Internalname = sPrefix+"PACIENTENOMBRES_"+sGXsfl_37_fel_idx ;
      edtPacienteNroDocumento_Internalname = sPrefix+"PACIENTENRODOCUMENTO_"+sGXsfl_37_fel_idx ;
      cmbCitaTipoDiagnostico.setInternalname( sPrefix+"CITATIPODIAGNOSTICO_"+sGXsfl_37_fel_idx );
      cmbCitaEstadoCita.setInternalname( sPrefix+"CITAESTADOCITA_"+sGXsfl_37_fel_idx );
      edtCitaInforme_Internalname = sPrefix+"CITAINFORME_"+sGXsfl_37_fel_idx ;
      edtCitaAntecedentes_Internalname = sPrefix+"CITAANTECEDENTES_"+sGXsfl_37_fel_idx ;
      edtCitaLink_Internalname = sPrefix+"CITALINK_"+sGXsfl_37_fel_idx ;
      edtCitaFechaReserva_Internalname = sPrefix+"CITAFECHARESERVA_"+sGXsfl_37_fel_idx ;
      edtCitaLog_Internalname = sPrefix+"CITALOG_"+sGXsfl_37_fel_idx ;
      edtCitaEmailGenLink_Internalname = sPrefix+"CITAEMAILGENLINK_"+sGXsfl_37_fel_idx ;
      cmbCitaEstado.setInternalname( sPrefix+"CITAESTADO_"+sGXsfl_37_fel_idx );
      edtCitaMotivoConsulta_Internalname = sPrefix+"CITAMOTIVOCONSULTA_"+sGXsfl_37_fel_idx ;
      edtCitaArchivoNombre_Internalname = sPrefix+"CITAARCHIVONOMBRE_"+sGXsfl_37_fel_idx ;
      edtCitaArchivo_Internalname = sPrefix+"CITAARCHIVO_"+sGXsfl_37_fel_idx ;
      edtCitaArchivoExtencion_Internalname = sPrefix+"CITAARCHIVOEXTENCION_"+sGXsfl_37_fel_idx ;
      chkCitaConsentimiento.setInternalname( sPrefix+"CITACONSENTIMIENTO_"+sGXsfl_37_fel_idx );
      chkCitaGestante.setInternalname( sPrefix+"CITAGESTANTE_"+sGXsfl_37_fel_idx );
      cmbCitaEstadoPago.setInternalname( sPrefix+"CITAESTADOPAGO_"+sGXsfl_37_fel_idx );
      edtCitaPeso_Internalname = sPrefix+"CITAPESO_"+sGXsfl_37_fel_idx ;
      edtCitaEstatura_Internalname = sPrefix+"CITAESTATURA_"+sGXsfl_37_fel_idx ;
   }

   public void sendrow_372( )
   {
      subsflControlProps_372( ) ;
      wb3T0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV26Update),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","Modificar","",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV28Delete),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","Eliminar","",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaId_Internalname,GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaCode_Internalname,A64CitaCode,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtCitaCode_Link,"","","",edtCitaCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteId_Internalname,GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtPacienteId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoPaterno_Internalname,A103PacienteApellidoPaterno,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoPaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoMaterno_Internalname,A104PacienteApellidoMaterno,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoMaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombres_Internalname,A105PacienteNombres,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtPacienteNombres_Link,"","","",edtPacienteNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNroDocumento_Internalname,A106PacienteNroDocumento,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCitaTipoDiagnostico.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITATIPODIAGNOSTICO_" + sGXsfl_37_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaTipoDiagnostico,cmbCitaTipoDiagnostico.getInternalname(),GXutil.rtrim( A65CitaTipoDiagnostico),Integer.valueOf(1),cmbCitaTipoDiagnostico.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","svchar","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaTipoDiagnostico.setValue( GXutil.rtrim( A65CitaTipoDiagnostico) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaTipoDiagnostico.getInternalname(), "Values", cmbCitaTipoDiagnostico.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCitaEstadoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITAESTADOCITA_" + sGXsfl_37_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaEstadoCita,cmbCitaEstadoCita.getInternalname(),GXutil.rtrim( A89CitaEstadoCita),Integer.valueOf(1),cmbCitaEstadoCita.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaInforme_Internalname,A90CitaInforme,A90CitaInforme,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaInforme_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaAntecedentes_Internalname,A100CitaAntecedentes,A100CitaAntecedentes,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaAntecedentes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaLink_Internalname,A91CitaLink,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtCitaLink_Link,edtCitaLink_Linktarget,"","",edtCitaLink_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(410),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaFechaReserva_Internalname,localUtil.ttoc( A92CitaFechaReserva, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A92CitaFechaReserva, "99/99/99 99:99"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaFechaReserva_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaLog_Internalname,A93CitaLog,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaLog_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaEmailGenLink_Internalname,A94CitaEmailGenLink,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","mailto:"+A94CitaEmailGenLink,"","","",edtCitaEmailGenLink_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCitaEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITAESTADO_" + sGXsfl_37_idx ;
            cmbCitaEstado.setName( GXCCtl );
            cmbCitaEstado.setWebtags( "" );
            cmbCitaEstado.addItem("A", "Activo", (short)(0));
            cmbCitaEstado.addItem("I", "Inactivo", (short)(0));
            if ( cmbCitaEstado.getItemCount() > 0 )
            {
               A95CitaEstado = cmbCitaEstado.getValidValue(A95CitaEstado) ;
               n95CitaEstado = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaEstado,cmbCitaEstado.getInternalname(),GXutil.rtrim( A95CitaEstado),Integer.valueOf(1),cmbCitaEstado.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaEstado.setValue( GXutil.rtrim( A95CitaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstado.getInternalname(), "Values", cmbCitaEstado.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaMotivoConsulta_Internalname,A99CitaMotivoConsulta,A99CitaMotivoConsulta,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaMotivoConsulta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaArchivoNombre_Internalname,A96CitaArchivoNombre,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaArchivoNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         ClassString = "Image" ;
         StyleString = "" ;
         edtCitaArchivo_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "Filetype", edtCitaArchivo_Filetype, !bGXsfl_37_Refreshing);
         if ( ! (GXutil.strcmp("", A98CitaArchivo)==0) )
         {
            gxblobfileaux.setSource( A98CitaArchivo );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtCitaArchivo_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtCitaArchivo_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A98CitaArchivo = gxblobfileaux.getURI() ;
               n98CitaArchivo = false ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), !bGXsfl_37_Refreshing);
               edtCitaArchivo_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "Filetype", edtCitaArchivo_Filetype, !bGXsfl_37_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), !bGXsfl_37_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtCitaArchivo_Internalname,GXutil.rtrim( A98CitaArchivo),httpContext.getResourceRelative(A98CitaArchivo),((GXutil.strcmp("", edtCitaArchivo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtCitaArchivo_Filetype)==0) ? A98CitaArchivo : edtCitaArchivo_Filetype)) : edtCitaArchivo_Contenttype),Boolean.valueOf(false),"",edtCitaArchivo_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtCitaArchivo_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaArchivoExtencion_Internalname,A333CitaArchivoExtencion,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaArchivoExtencion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CITACONSENTIMIENTO_" + sGXsfl_37_idx ;
         chkCitaConsentimiento.setName( GXCCtl );
         chkCitaConsentimiento.setWebtags( "" );
         chkCitaConsentimiento.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCitaConsentimiento.getInternalname(), "TitleCaption", chkCitaConsentimiento.getCaption(), !bGXsfl_37_Refreshing);
         chkCitaConsentimiento.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkCitaConsentimiento.getInternalname(),GXutil.booltostr( A97CitaConsentimiento),"","",Integer.valueOf(-1),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CITAGESTANTE_" + sGXsfl_37_idx ;
         chkCitaGestante.setName( GXCCtl );
         chkCitaGestante.setWebtags( "" );
         chkCitaGestante.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCitaGestante.getInternalname(), "TitleCaption", chkCitaGestante.getCaption(), !bGXsfl_37_Refreshing);
         chkCitaGestante.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkCitaGestante.getInternalname(),GXutil.booltostr( A101CitaGestante),"","",Integer.valueOf(-1),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCitaEstadoPago.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITAESTADOPAGO_" + sGXsfl_37_idx ;
            cmbCitaEstadoPago.setName( GXCCtl );
            cmbCitaEstadoPago.setWebtags( "" );
            cmbCitaEstadoPago.addItem("S", "Sin Pago", (short)(0));
            cmbCitaEstadoPago.addItem("P", "Pendiente", (short)(0));
            cmbCitaEstadoPago.addItem("G", "Pagado", (short)(0));
            if ( cmbCitaEstadoPago.getItemCount() > 0 )
            {
               A102CitaEstadoPago = cmbCitaEstadoPago.getValidValue(A102CitaEstadoPago) ;
               n102CitaEstadoPago = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaEstadoPago,cmbCitaEstadoPago.getInternalname(),GXutil.rtrim( A102CitaEstadoPago),Integer.valueOf(1),cmbCitaEstadoPago.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaEstadoPago.setValue( GXutil.rtrim( A102CitaEstadoPago) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstadoPago.getInternalname(), "Values", cmbCitaEstadoPago.ToJavascriptSource(), !bGXsfl_37_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaPeso_Internalname,GXutil.ltrim( localUtil.ntoc( A306CitaPeso, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A306CitaPeso, "ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaPeso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaEstatura_Internalname,GXutil.ltrim( localUtil.ntoc( A307CitaEstatura, (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A307CitaEstatura, "9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCitaEstatura_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(37),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes3T2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_37_idx = ((subGrid_Islastpage==1)&&(nGXsfl_37_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_37_idx+1) ;
         sGXsfl_37_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_37_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_372( ) ;
      }
      /* End function sendrow_372 */
   }

   public void init_default_properties( )
   {
      bttBtninsert_Internalname = sPrefix+"BTNINSERT" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      Ddo_managefilters_Internalname = sPrefix+"DDO_MANAGEFILTERS" ;
      edtavFilterfulltext_Internalname = sPrefix+"vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = sPrefix+"TABLEFILTERS" ;
      tblTablerightheader_Internalname = sPrefix+"TABLERIGHTHEADER" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      Dvpanel_tableheader_Internalname = sPrefix+"DVPANEL_TABLEHEADER" ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE" ;
      edtavDelete_Internalname = sPrefix+"vDELETE" ;
      edtCitaId_Internalname = sPrefix+"CITAID" ;
      edtCitaCode_Internalname = sPrefix+"CITACODE" ;
      edtPacienteId_Internalname = sPrefix+"PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = sPrefix+"PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = sPrefix+"PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = sPrefix+"PACIENTENOMBRES" ;
      edtPacienteNroDocumento_Internalname = sPrefix+"PACIENTENRODOCUMENTO" ;
      cmbCitaTipoDiagnostico.setInternalname( sPrefix+"CITATIPODIAGNOSTICO" );
      cmbCitaEstadoCita.setInternalname( sPrefix+"CITAESTADOCITA" );
      edtCitaInforme_Internalname = sPrefix+"CITAINFORME" ;
      edtCitaAntecedentes_Internalname = sPrefix+"CITAANTECEDENTES" ;
      edtCitaLink_Internalname = sPrefix+"CITALINK" ;
      edtCitaFechaReserva_Internalname = sPrefix+"CITAFECHARESERVA" ;
      edtCitaLog_Internalname = sPrefix+"CITALOG" ;
      edtCitaEmailGenLink_Internalname = sPrefix+"CITAEMAILGENLINK" ;
      cmbCitaEstado.setInternalname( sPrefix+"CITAESTADO" );
      edtCitaMotivoConsulta_Internalname = sPrefix+"CITAMOTIVOCONSULTA" ;
      edtCitaArchivoNombre_Internalname = sPrefix+"CITAARCHIVONOMBRE" ;
      edtCitaArchivo_Internalname = sPrefix+"CITAARCHIVO" ;
      edtCitaArchivoExtencion_Internalname = sPrefix+"CITAARCHIVOEXTENCION" ;
      chkCitaConsentimiento.setInternalname( sPrefix+"CITACONSENTIMIENTO" );
      chkCitaGestante.setInternalname( sPrefix+"CITAGESTANTE" );
      cmbCitaEstadoPago.setInternalname( sPrefix+"CITAESTADOPAGO" );
      edtCitaPeso_Internalname = sPrefix+"CITAPESO" ;
      edtCitaEstatura_Internalname = sPrefix+"CITAESTATURA" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtSGCitaDisponibilidadId_Internalname = sPrefix+"SGCITADISPONIBILIDADID" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusTheme");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      edtCitaEstatura_Jsonclick = "" ;
      edtCitaPeso_Jsonclick = "" ;
      cmbCitaEstadoPago.setJsonclick( "" );
      chkCitaGestante.setCaption( "" );
      chkCitaConsentimiento.setCaption( "" );
      edtCitaArchivoExtencion_Jsonclick = "" ;
      edtCitaArchivo_Jsonclick = "" ;
      edtCitaArchivo_Parameters = "" ;
      edtCitaArchivo_Contenttype = "" ;
      edtCitaArchivo_Filetype = "" ;
      edtCitaArchivoNombre_Jsonclick = "" ;
      edtCitaMotivoConsulta_Jsonclick = "" ;
      cmbCitaEstado.setJsonclick( "" );
      edtCitaEmailGenLink_Jsonclick = "" ;
      edtCitaLog_Jsonclick = "" ;
      edtCitaFechaReserva_Jsonclick = "" ;
      edtCitaLink_Jsonclick = "" ;
      edtCitaAntecedentes_Jsonclick = "" ;
      edtCitaInforme_Jsonclick = "" ;
      cmbCitaEstadoCita.setJsonclick( "" );
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
      edtSGCitaDisponibilidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadId_Visible = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtCitaLink_Linktarget = "" ;
      edtCitaLink_Link = "" ;
      edtPacienteNombres_Link = "" ;
      edtCitaCode_Link = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24" ;
      Ddo_grid_Columnids = "2:CitaId|3:CitaCode|4:PacienteId|5:PacienteApellidoPaterno|6:PacienteApellidoMaterno|7:PacienteNombres|8:PacienteNroDocumento|9:CitaTipoDiagnostico|10:CitaEstadoCita|11:CitaInforme|12:CitaAntecedentes|13:CitaLink|14:CitaFechaReserva|15:CitaLog|16:CitaEmailGenLink|17:CitaEstado|18:CitaMotivoConsulta|19:CitaArchivoNombre|21:CitaArchivoExtencion|22:CitaConsentimiento|23:CitaGestante|24:CitaEstadoPago|25:CitaPeso|26:CitaEstatura" ;
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "CITATIPODIAGNOSTICO_" + sGXsfl_37_idx ;
      cmbCitaTipoDiagnostico.setName( GXCCtl );
      cmbCitaTipoDiagnostico.setWebtags( "" );
      cmbCitaTipoDiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
      cmbCitaTipoDiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
      cmbCitaTipoDiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
      if ( cmbCitaTipoDiagnostico.getItemCount() > 0 )
      {
      }
      GXCCtl = "CITAESTADOCITA_" + sGXsfl_37_idx ;
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
      }
      GXCCtl = "CITAESTADO_" + sGXsfl_37_idx ;
      cmbCitaEstado.setName( GXCCtl );
      cmbCitaEstado.setWebtags( "" );
      cmbCitaEstado.addItem("A", "Activo", (short)(0));
      cmbCitaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbCitaEstado.getItemCount() > 0 )
      {
      }
      GXCCtl = "CITACONSENTIMIENTO_" + sGXsfl_37_idx ;
      chkCitaConsentimiento.setName( GXCCtl );
      chkCitaConsentimiento.setWebtags( "" );
      chkCitaConsentimiento.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCitaConsentimiento.getInternalname(), "TitleCaption", chkCitaConsentimiento.getCaption(), !bGXsfl_37_Refreshing);
      chkCitaConsentimiento.setCheckedValue( "false" );
      GXCCtl = "CITAGESTANTE_" + sGXsfl_37_idx ;
      chkCitaGestante.setName( GXCCtl );
      chkCitaGestante.setWebtags( "" );
      chkCitaGestante.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCitaGestante.getInternalname(), "TitleCaption", chkCitaGestante.getCaption(), !bGXsfl_37_Refreshing);
      chkCitaGestante.setCheckedValue( "false" );
      GXCCtl = "CITAESTADOPAGO_" + sGXsfl_37_idx ;
      cmbCitaEstadoPago.setName( GXCCtl );
      cmbCitaEstadoPago.setWebtags( "" );
      cmbCitaEstadoPago.addItem("S", "Sin Pago", (short)(0));
      cmbCitaEstadoPago.addItem("P", "Pendiente", (short)(0));
      cmbCitaEstadoPago.addItem("G", "Pagado", (short)(0));
      if ( cmbCitaEstadoPago.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV8SGCitaDisponibilidadId',fld:'vSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV36Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV32IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV25GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV18ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e123T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV8SGCitaDisponibilidadId',fld:'vSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV36Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV32IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e133T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV8SGCitaDisponibilidadId',fld:'vSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV36Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV32IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e143T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV8SGCitaDisponibilidadId',fld:'vSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV36Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV32IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e183T2',iparms:[{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV32IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'A91CitaLink',fld:'CITALINK',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV26Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV28Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtCitaCode_Link',ctrl:'CITACODE',prop:'Link'},{av:'edtPacienteNombres_Link',ctrl:'PACIENTENOMBRES',prop:'Link'},{av:'edtCitaLink_Linktarget',ctrl:'CITALINK',prop:'Linktarget'},{av:'edtCitaLink_Link',ctrl:'CITALINK',prop:'Link'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e113T2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV8SGCitaDisponibilidadId',fld:'vSGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV36Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV32IsAuthorized_PacienteNombres',fld:'vISAUTHORIZED_PACIENTENOMBRES',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV20ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV16FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV25GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV29IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV18ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e153T2',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Citaestatura',iparms:[]");
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
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV16FilterFullText = "" ;
      AV36Pgmname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV18ManageFiltersData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV21DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV12GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableheader = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtninsert_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV26Update = "" ;
      AV28Delete = "" ;
      A64CitaCode = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A65CitaTipoDiagnostico = "" ;
      A89CitaEstadoCita = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A91CitaLink = "" ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      A93CitaLog = "" ;
      A94CitaEmailGenLink = "" ;
      A95CitaEstado = "" ;
      A99CitaMotivoConsulta = "" ;
      A96CitaArchivoNombre = "" ;
      A98CitaArchivo = "" ;
      A333CitaArchivoExtencion = "" ;
      A102CitaEstadoPago = "" ;
      A306CitaPeso = DecimalUtil.ZERO ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      lV16FilterFullText = "" ;
      H003T2_A21SGCitaDisponibilidadId = new int[1] ;
      H003T2_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H003T2_n307CitaEstatura = new boolean[] {false} ;
      H003T2_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H003T2_n306CitaPeso = new boolean[] {false} ;
      H003T2_A102CitaEstadoPago = new String[] {""} ;
      H003T2_n102CitaEstadoPago = new boolean[] {false} ;
      H003T2_A101CitaGestante = new boolean[] {false} ;
      H003T2_n101CitaGestante = new boolean[] {false} ;
      H003T2_A97CitaConsentimiento = new boolean[] {false} ;
      H003T2_n97CitaConsentimiento = new boolean[] {false} ;
      H003T2_A333CitaArchivoExtencion = new String[] {""} ;
      H003T2_n333CitaArchivoExtencion = new boolean[] {false} ;
      H003T2_A98CitaArchivo = new String[] {""} ;
      H003T2_n98CitaArchivo = new boolean[] {false} ;
      H003T2_A96CitaArchivoNombre = new String[] {""} ;
      H003T2_n96CitaArchivoNombre = new boolean[] {false} ;
      H003T2_A99CitaMotivoConsulta = new String[] {""} ;
      H003T2_n99CitaMotivoConsulta = new boolean[] {false} ;
      H003T2_A95CitaEstado = new String[] {""} ;
      H003T2_n95CitaEstado = new boolean[] {false} ;
      H003T2_A94CitaEmailGenLink = new String[] {""} ;
      H003T2_n94CitaEmailGenLink = new boolean[] {false} ;
      H003T2_A93CitaLog = new String[] {""} ;
      H003T2_n93CitaLog = new boolean[] {false} ;
      H003T2_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      H003T2_n92CitaFechaReserva = new boolean[] {false} ;
      H003T2_A91CitaLink = new String[] {""} ;
      H003T2_n91CitaLink = new boolean[] {false} ;
      H003T2_A100CitaAntecedentes = new String[] {""} ;
      H003T2_n100CitaAntecedentes = new boolean[] {false} ;
      H003T2_A90CitaInforme = new String[] {""} ;
      H003T2_n90CitaInforme = new boolean[] {false} ;
      H003T2_A89CitaEstadoCita = new String[] {""} ;
      H003T2_n89CitaEstadoCita = new boolean[] {false} ;
      H003T2_A65CitaTipoDiagnostico = new String[] {""} ;
      H003T2_n65CitaTipoDiagnostico = new boolean[] {false} ;
      H003T2_A106PacienteNroDocumento = new String[] {""} ;
      H003T2_A105PacienteNombres = new String[] {""} ;
      H003T2_A104PacienteApellidoMaterno = new String[] {""} ;
      H003T2_A103PacienteApellidoPaterno = new String[] {""} ;
      H003T2_A20PacienteId = new int[1] ;
      H003T2_A64CitaCode = new String[] {""} ;
      H003T2_A19CitaId = new int[1] ;
      H003T3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV19ManageFiltersXml = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9 = new GXBaseCollection[1] ;
      AV17Session = httpContext.getWebSession();
      AV13GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState10 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9HTTPRequest = httpContext.getHttpRequest();
      AV11TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8SGCitaDisponibilidadId = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadcitawc__default(),
         new Object[] {
             new Object[] {
            H003T2_A21SGCitaDisponibilidadId, H003T2_A307CitaEstatura, H003T2_n307CitaEstatura, H003T2_A306CitaPeso, H003T2_n306CitaPeso, H003T2_A102CitaEstadoPago, H003T2_n102CitaEstadoPago, H003T2_A101CitaGestante, H003T2_n101CitaGestante, H003T2_A97CitaConsentimiento,
            H003T2_n97CitaConsentimiento, H003T2_A333CitaArchivoExtencion, H003T2_n333CitaArchivoExtencion, H003T2_A98CitaArchivo, H003T2_n98CitaArchivo, H003T2_A96CitaArchivoNombre, H003T2_n96CitaArchivoNombre, H003T2_A99CitaMotivoConsulta, H003T2_n99CitaMotivoConsulta, H003T2_A95CitaEstado,
            H003T2_n95CitaEstado, H003T2_A94CitaEmailGenLink, H003T2_n94CitaEmailGenLink, H003T2_A93CitaLog, H003T2_n93CitaLog, H003T2_A92CitaFechaReserva, H003T2_n92CitaFechaReserva, H003T2_A91CitaLink, H003T2_n91CitaLink, H003T2_A100CitaAntecedentes,
            H003T2_n100CitaAntecedentes, H003T2_A90CitaInforme, H003T2_n90CitaInforme, H003T2_A89CitaEstadoCita, H003T2_n89CitaEstadoCita, H003T2_A65CitaTipoDiagnostico, H003T2_n65CitaTipoDiagnostico, H003T2_A106PacienteNroDocumento, H003T2_A105PacienteNombres, H003T2_A104PacienteApellidoMaterno,
            H003T2_A103PacienteApellidoPaterno, H003T2_A20PacienteId, H003T2_A64CitaCode, H003T2_A19CitaId
            }
            , new Object[] {
            H003T3_AGRID_nRecordCount
            }
         }
      );
      AV36Pgmname = "DisponibilidadCitaWC" ;
      /* GeneXus formulas. */
      AV36Pgmname = "DisponibilidadCitaWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV20ManageFiltersExecutionStep ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8SGCitaDisponibilidadId ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_37 ;
   private int AV8SGCitaDisponibilidadId ;
   private int nGXsfl_37_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int A21SGCitaDisponibilidadId ;
   private int edtSGCitaDisponibilidadId_Visible ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV23PageToGo ;
   private int AV37GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV24GridCurrentPage ;
   private long AV25GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal A306CitaPeso ;
   private java.math.BigDecimal A307CitaEstatura ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_37_idx="0001" ;
   private String AV36Pgmname ;
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
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String Dvpanel_tableheader_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String AV26Update ;
   private String edtavUpdate_Link ;
   private String AV28Delete ;
   private String edtavDelete_Link ;
   private String edtCitaCode_Link ;
   private String edtPacienteNombres_Link ;
   private String A89CitaEstadoCita ;
   private String edtCitaLink_Link ;
   private String edtCitaLink_Linktarget ;
   private String A95CitaEstado ;
   private String A102CitaEstadoPago ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtSGCitaDisponibilidadId_Internalname ;
   private String edtSGCitaDisponibilidadId_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavFilterfulltext_Internalname ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtCitaCode_Internalname ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtCitaInforme_Internalname ;
   private String edtCitaAntecedentes_Internalname ;
   private String edtCitaLink_Internalname ;
   private String edtCitaFechaReserva_Internalname ;
   private String edtCitaLog_Internalname ;
   private String edtCitaEmailGenLink_Internalname ;
   private String edtCitaMotivoConsulta_Internalname ;
   private String edtCitaArchivoNombre_Internalname ;
   private String edtCitaArchivo_Internalname ;
   private String edtCitaArchivoExtencion_Internalname ;
   private String edtCitaPeso_Internalname ;
   private String edtCitaEstatura_Internalname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sCtrlAV8SGCitaDisponibilidadId ;
   private String sGXsfl_37_fel_idx="0001" ;
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
   private String edtCitaInforme_Jsonclick ;
   private String edtCitaAntecedentes_Jsonclick ;
   private String edtCitaLink_Jsonclick ;
   private String edtCitaFechaReserva_Jsonclick ;
   private String edtCitaLog_Jsonclick ;
   private String edtCitaEmailGenLink_Jsonclick ;
   private String edtCitaMotivoConsulta_Jsonclick ;
   private String edtCitaArchivoNombre_Jsonclick ;
   private String edtCitaArchivo_Filetype ;
   private String edtCitaArchivo_Contenttype ;
   private String edtCitaArchivo_Parameters ;
   private String edtCitaArchivo_Jsonclick ;
   private String edtCitaArchivoExtencion_Jsonclick ;
   private String edtCitaPeso_Jsonclick ;
   private String edtCitaEstatura_Jsonclick ;
   private java.util.Date A92CitaFechaReserva ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV27IsAuthorized_Update ;
   private boolean AV29IsAuthorized_Delete ;
   private boolean AV32IsAuthorized_PacienteNombres ;
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
   private boolean wbLoad ;
   private boolean A97CitaConsentimiento ;
   private boolean A101CitaGestante ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n65CitaTipoDiagnostico ;
   private boolean n89CitaEstadoCita ;
   private boolean n90CitaInforme ;
   private boolean n100CitaAntecedentes ;
   private boolean n91CitaLink ;
   private boolean n92CitaFechaReserva ;
   private boolean n93CitaLog ;
   private boolean n94CitaEmailGenLink ;
   private boolean n95CitaEstado ;
   private boolean n99CitaMotivoConsulta ;
   private boolean n96CitaArchivoNombre ;
   private boolean n98CitaArchivo ;
   private boolean bGXsfl_37_Refreshing=false ;
   private boolean n333CitaArchivoExtencion ;
   private boolean n97CitaConsentimiento ;
   private boolean n101CitaGestante ;
   private boolean n102CitaEstadoPago ;
   private boolean n306CitaPeso ;
   private boolean n307CitaEstatura ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV30TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String A99CitaMotivoConsulta ;
   private String AV19ManageFiltersXml ;
   private String A98CitaArchivo ;
   private String AV16FilterFullText ;
   private String A64CitaCode ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A65CitaTipoDiagnostico ;
   private String A91CitaLink ;
   private String A93CitaLog ;
   private String A94CitaEmailGenLink ;
   private String A96CitaArchivoNombre ;
   private String A333CitaArchivoExtencion ;
   private String lV16FilterFullText ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV17Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice cmbCitaTipoDiagnostico ;
   private HTMLChoice cmbCitaEstadoCita ;
   private HTMLChoice cmbCitaEstado ;
   private ICheckbox chkCitaConsentimiento ;
   private ICheckbox chkCitaGestante ;
   private HTMLChoice cmbCitaEstadoPago ;
   private IDataStoreProvider pr_default ;
   private int[] H003T2_A21SGCitaDisponibilidadId ;
   private java.math.BigDecimal[] H003T2_A307CitaEstatura ;
   private boolean[] H003T2_n307CitaEstatura ;
   private java.math.BigDecimal[] H003T2_A306CitaPeso ;
   private boolean[] H003T2_n306CitaPeso ;
   private String[] H003T2_A102CitaEstadoPago ;
   private boolean[] H003T2_n102CitaEstadoPago ;
   private boolean[] H003T2_A101CitaGestante ;
   private boolean[] H003T2_n101CitaGestante ;
   private boolean[] H003T2_A97CitaConsentimiento ;
   private boolean[] H003T2_n97CitaConsentimiento ;
   private String[] H003T2_A333CitaArchivoExtencion ;
   private boolean[] H003T2_n333CitaArchivoExtencion ;
   private String[] H003T2_A98CitaArchivo ;
   private boolean[] H003T2_n98CitaArchivo ;
   private String[] H003T2_A96CitaArchivoNombre ;
   private boolean[] H003T2_n96CitaArchivoNombre ;
   private String[] H003T2_A99CitaMotivoConsulta ;
   private boolean[] H003T2_n99CitaMotivoConsulta ;
   private String[] H003T2_A95CitaEstado ;
   private boolean[] H003T2_n95CitaEstado ;
   private String[] H003T2_A94CitaEmailGenLink ;
   private boolean[] H003T2_n94CitaEmailGenLink ;
   private String[] H003T2_A93CitaLog ;
   private boolean[] H003T2_n93CitaLog ;
   private java.util.Date[] H003T2_A92CitaFechaReserva ;
   private boolean[] H003T2_n92CitaFechaReserva ;
   private String[] H003T2_A91CitaLink ;
   private boolean[] H003T2_n91CitaLink ;
   private String[] H003T2_A100CitaAntecedentes ;
   private boolean[] H003T2_n100CitaAntecedentes ;
   private String[] H003T2_A90CitaInforme ;
   private boolean[] H003T2_n90CitaInforme ;
   private String[] H003T2_A89CitaEstadoCita ;
   private boolean[] H003T2_n89CitaEstadoCita ;
   private String[] H003T2_A65CitaTipoDiagnostico ;
   private boolean[] H003T2_n65CitaTipoDiagnostico ;
   private String[] H003T2_A106PacienteNroDocumento ;
   private String[] H003T2_A105PacienteNombres ;
   private String[] H003T2_A104PacienteApellidoMaterno ;
   private String[] H003T2_A103PacienteApellidoPaterno ;
   private int[] H003T2_A20PacienteId ;
   private String[] H003T2_A64CitaCode ;
   private int[] H003T2_A19CitaId ;
   private long[] H003T3_AGRID_nRecordCount ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV18ManageFiltersData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV11TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState10[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV21DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class disponibilidadcitawc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H003T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV16FilterFullText ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          String A65CitaTipoDiagnostico ,
                                          String A89CitaEstadoCita ,
                                          String A90CitaInforme ,
                                          String A100CitaAntecedentes ,
                                          String A91CitaLink ,
                                          String A93CitaLog ,
                                          String A94CitaEmailGenLink ,
                                          String A95CitaEstado ,
                                          String A99CitaMotivoConsulta ,
                                          String A96CitaArchivoNombre ,
                                          String A333CitaArchivoExtencion ,
                                          String A102CitaEstadoPago ,
                                          java.math.BigDecimal A306CitaPeso ,
                                          java.math.BigDecimal A307CitaEstatura ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV8SGCitaDisponibilidadId ,
                                          int A21SGCitaDisponibilidadId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[35];
      Object[] GXv_Object12 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[SGCitaDisponibilidadId], T1.[CitaEstatura], T1.[CitaPeso], T1.[CitaEstadoPago], T1.[CitaGestante], T1.[CitaConsentimiento], T1.[CitaArchivoExtencion], T1.[CitaArchivo]," ;
      sSelectString += " T1.[CitaArchivoNombre], T1.[CitaMotivoConsulta], T1.[CitaEstado], T1.[CitaEmailGenLink], T1.[CitaLog], T1.[CitaFechaReserva], T1.[CitaLink], T1.[CitaAntecedentes]," ;
      sSelectString += " T1.[CitaInforme], T1.[CitaEstadoCita], T1.[CitaTipoDiagnostico], T2.[PacienteNroDocumento], T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno]," ;
      sSelectString += " T1.[PacienteId], T1.[CitaCode], T1.[CitaId]" ;
      sFromString = " FROM ([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] = ?)");
      if ( ! (GXutil.strcmp("", AV16FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T1.[CitaCode] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( 'prensuntivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Prensuntivo') or ( 'definitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Definitivo') or ( 'repetitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Repetitivo') or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( T1.[CitaInforme] like '%' + ?) or ( T1.[CitaAntecedentes] like '%' + ?) or ( T1.[CitaLink] like '%' + ?) or ( T1.[CitaLog] like '%' + ?) or ( T1.[CitaEmailGenLink] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[CitaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[CitaEstado] = 'I') or ( T1.[CitaMotivoConsulta] like '%' + ?) or ( T1.[CitaArchivoNombre] like '%' + ?) or ( T1.[CitaArchivoExtencion] like '%' + ?) or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G') or ( CONVERT( char(6), CAST(T1.[CitaPeso] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[CitaEstatura] AS decimal(4,2))) like '%' + ?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
         GXv_int11[2] = (byte)(1) ;
         GXv_int11[3] = (byte)(1) ;
         GXv_int11[4] = (byte)(1) ;
         GXv_int11[5] = (byte)(1) ;
         GXv_int11[6] = (byte)(1) ;
         GXv_int11[7] = (byte)(1) ;
         GXv_int11[8] = (byte)(1) ;
         GXv_int11[9] = (byte)(1) ;
         GXv_int11[10] = (byte)(1) ;
         GXv_int11[11] = (byte)(1) ;
         GXv_int11[12] = (byte)(1) ;
         GXv_int11[13] = (byte)(1) ;
         GXv_int11[14] = (byte)(1) ;
         GXv_int11[15] = (byte)(1) ;
         GXv_int11[16] = (byte)(1) ;
         GXv_int11[17] = (byte)(1) ;
         GXv_int11[18] = (byte)(1) ;
         GXv_int11[19] = (byte)(1) ;
         GXv_int11[20] = (byte)(1) ;
         GXv_int11[21] = (byte)(1) ;
         GXv_int11[22] = (byte)(1) ;
         GXv_int11[23] = (byte)(1) ;
         GXv_int11[24] = (byte)(1) ;
         GXv_int11[25] = (byte)(1) ;
         GXv_int11[26] = (byte)(1) ;
         GXv_int11[27] = (byte)(1) ;
         GXv_int11[28] = (byte)(1) ;
         GXv_int11[29] = (byte)(1) ;
         GXv_int11[30] = (byte)(1) ;
         GXv_int11[31] = (byte)(1) ;
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaCode]" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaCode] DESC" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaId]" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaId] DESC" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[PacienteId]" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[PacienteId] DESC" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T2.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T2.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T2.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T2.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T2.[PacienteNombres]" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T2.[PacienteNombres] DESC" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T2.[PacienteNroDocumento]" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T2.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaTipoDiagnostico]" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaTipoDiagnostico] DESC" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaEstadoCita]" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaEstadoCita] DESC" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaInforme]" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaInforme] DESC" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaAntecedentes]" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaAntecedentes] DESC" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaLink]" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaLink] DESC" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaFechaReserva]" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaFechaReserva] DESC" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaLog]" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaLog] DESC" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaEmailGenLink]" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaEmailGenLink] DESC" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaEstado]" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaEstado] DESC" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaMotivoConsulta]" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaMotivoConsulta] DESC" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaArchivoNombre]" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaArchivoNombre] DESC" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaArchivoExtencion]" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaArchivoExtencion] DESC" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaConsentimiento]" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaConsentimiento] DESC" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaGestante]" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaGestante] DESC" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaEstadoPago]" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaEstadoPago] DESC" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaPeso]" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaPeso] DESC" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId], T1.[CitaEstatura]" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SGCitaDisponibilidadId] DESC, T1.[CitaEstatura] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_H003T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV16FilterFullText ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          String A65CitaTipoDiagnostico ,
                                          String A89CitaEstadoCita ,
                                          String A90CitaInforme ,
                                          String A100CitaAntecedentes ,
                                          String A91CitaLink ,
                                          String A93CitaLog ,
                                          String A94CitaEmailGenLink ,
                                          String A95CitaEstado ,
                                          String A99CitaMotivoConsulta ,
                                          String A96CitaArchivoNombre ,
                                          String A333CitaArchivoExtencion ,
                                          String A102CitaEstadoPago ,
                                          java.math.BigDecimal A306CitaPeso ,
                                          java.math.BigDecimal A307CitaEstatura ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV8SGCitaDisponibilidadId ,
                                          int A21SGCitaDisponibilidadId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[32];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId])" ;
      addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] = ?)");
      if ( ! (GXutil.strcmp("", AV16FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T1.[CitaCode] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( 'prensuntivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Prensuntivo') or ( 'definitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Definitivo') or ( 'repetitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Repetitivo') or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( T1.[CitaInforme] like '%' + ?) or ( T1.[CitaAntecedentes] like '%' + ?) or ( T1.[CitaLink] like '%' + ?) or ( T1.[CitaLog] like '%' + ?) or ( T1.[CitaEmailGenLink] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[CitaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[CitaEstado] = 'I') or ( T1.[CitaMotivoConsulta] like '%' + ?) or ( T1.[CitaArchivoNombre] like '%' + ?) or ( T1.[CitaArchivoExtencion] like '%' + ?) or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G') or ( CONVERT( char(6), CAST(T1.[CitaPeso] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[CitaEstatura] AS decimal(4,2))) like '%' + ?))");
      }
      else
      {
         GXv_int13[1] = (byte)(1) ;
         GXv_int13[2] = (byte)(1) ;
         GXv_int13[3] = (byte)(1) ;
         GXv_int13[4] = (byte)(1) ;
         GXv_int13[5] = (byte)(1) ;
         GXv_int13[6] = (byte)(1) ;
         GXv_int13[7] = (byte)(1) ;
         GXv_int13[8] = (byte)(1) ;
         GXv_int13[9] = (byte)(1) ;
         GXv_int13[10] = (byte)(1) ;
         GXv_int13[11] = (byte)(1) ;
         GXv_int13[12] = (byte)(1) ;
         GXv_int13[13] = (byte)(1) ;
         GXv_int13[14] = (byte)(1) ;
         GXv_int13[15] = (byte)(1) ;
         GXv_int13[16] = (byte)(1) ;
         GXv_int13[17] = (byte)(1) ;
         GXv_int13[18] = (byte)(1) ;
         GXv_int13[19] = (byte)(1) ;
         GXv_int13[20] = (byte)(1) ;
         GXv_int13[21] = (byte)(1) ;
         GXv_int13[22] = (byte)(1) ;
         GXv_int13[23] = (byte)(1) ;
         GXv_int13[24] = (byte)(1) ;
         GXv_int13[25] = (byte)(1) ;
         GXv_int13[26] = (byte)(1) ;
         GXv_int13[27] = (byte)(1) ;
         GXv_int13[28] = (byte)(1) ;
         GXv_int13[29] = (byte)(1) ;
         GXv_int13[30] = (byte)(1) ;
         GXv_int13[31] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
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
                  return conditional_H003T2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() );
            case 1 :
                  return conditional_H003T3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getBLOBFile(8, "tmp", "");
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[25])[0] = rslt.getGXDateTime(14);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getLongVarchar(17);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getVarchar(19);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getVarchar(20);
               ((String[]) buf[38])[0] = rslt.getVarchar(21);
               ((String[]) buf[39])[0] = rslt.getVarchar(22);
               ((String[]) buf[40])[0] = rslt.getVarchar(23);
               ((int[]) buf[41])[0] = rslt.getInt(24);
               ((String[]) buf[42])[0] = rslt.getVarchar(25);
               ((int[]) buf[43])[0] = rslt.getInt(26);
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
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[67]).intValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[68]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[69]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[32]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               return;
      }
   }

}

