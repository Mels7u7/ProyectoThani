package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpreprogramarcita_impl extends GXDataArea
{
   public wpreprogramarcita_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpreprogramarcita_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpreprogramarcita_impl.class ));
   }

   public wpreprogramarcita_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
            nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
            sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
            edtDisponibilidadId_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), !bGXsfl_15_Refreshing);
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
            AV7ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            AV8SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
            AV6EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
            AV19DisponibilidadTipoCita = httpContext.GetPar( "DisponibilidadTipoCita") ;
            AV5CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
            AV36TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraInicio"))) ;
            AV37TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraInicio_To"))) ;
            AV34TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraFin"))) ;
            AV35TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFDisponibilidadHoraFin_To"))) ;
            AV51Pgmname = httpContext.GetPar( "Pgmname") ;
            AV27OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            edtDisponibilidadId_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), !bGXsfl_15_Refreshing);
            AV43DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV7ProfesionalId, AV8SedeId, AV6EspecialidadId, AV19DisponibilidadTipoCita, AV5CitaId, AV36TFDisponibilidadHoraInicio, AV37TFDisponibilidadHoraInicio_To, AV34TFDisponibilidadHoraFin, AV35TFDisponibilidadHoraFin_To, AV51Pgmname, AV27OrderedDsc, AV43DisponibilidadId) ;
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DISPONIBILIDADID_Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
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
            AV5CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CitaId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV43DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV43DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DisponibilidadId), 8, 0));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV43DisponibilidadId), "ZZZZZZZ9")));
            }
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
      pa2M2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2M2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110333988", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpreprogramarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV43DisponibilidadId,8,0))}, new String[] {"CitaId","DisponibilidadId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV43DisponibilidadId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV20GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV21GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAINICIOAUXDATETO", localUtil.dtoc( AV17DDO_DisponibilidadHoraInicioAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAFINAUXDATETO", localUtil.dtoc( AV14DDO_DisponibilidadHoraFinAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAINICIO", localUtil.ttoc( AV36TFDisponibilidadHoraInicio, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAINICIO_TO", localUtil.ttoc( AV37TFDisponibilidadHoraInicio_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAFIN", localUtil.ttoc( AV34TFDisponibilidadHoraFin, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFDISPONIBILIDADHORAFIN_TO", localUtil.ttoc( AV35TFDisponibilidadHoraFin_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV51Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV27OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV5CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV43DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV43DisponibilidadId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV7ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSEDEID", GXutil.ltrim( localUtil.ntoc( AV8SedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV6EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADTIPOCITA", GXutil.rtrim( AV19DisponibilidadTipoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAINICIOAUXDATE", localUtil.dtoc( AV15DDO_DisponibilidadHoraInicioAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_DISPONIBILIDADHORAFINAUXDATE", localUtil.dtoc( AV12DDO_DisponibilidadHoraFinAuxDate, 0, "/"));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DISPONIBILIDADID_Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadId_Visible, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
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
         we2M2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2M2( ) ;
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
      return formatLink("com.projectthani.wpreprogramarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV43DisponibilidadId,8,0))}, new String[] {"CitaId","DisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "WPReprogramarCita" ;
   }

   public String getPgmdesc( )
   {
      return " Disponibilidad" ;
   }

   public void wb2M0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain TablePL20PR20", "left", "top", "", "", "div");
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDisponibilidadId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hora Inicio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hora Fin") ;
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
            GridColumn.AddObjectProperty("Value", AV30SelecDisponibilidad);
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSelecdisponibilidad_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDisponibilidadId_Visible, (byte)(5), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "));
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
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV20GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV21GridPageCount);
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
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_disponibilidadhorainicioauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'" + sGXsfl_15_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_disponibilidadhorainicioauxdatetext_Internalname, AV16DDO_DisponibilidadHoraInicioAuxDateText, GXutil.rtrim( localUtil.format( AV16DDO_DisponibilidadHoraInicioAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_disponibilidadhorainicioauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPReprogramarCita.htm");
         /* User Defined Control */
         ucTfdisponibilidadhorainicio_rangepicker.setProperty("Start Date", AV15DDO_DisponibilidadHoraInicioAuxDate);
         ucTfdisponibilidadhorainicio_rangepicker.setProperty("End Date", AV17DDO_DisponibilidadHoraInicioAuxDateTo);
         ucTfdisponibilidadhorainicio_rangepicker.render(context, "wwp.daterangepicker", Tfdisponibilidadhorainicio_rangepicker_Internalname, "TFDISPONIBILIDADHORAINICIO_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_disponibilidadhorafinauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'" + sGXsfl_15_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_disponibilidadhorafinauxdatetext_Internalname, AV13DDO_DisponibilidadHoraFinAuxDateText, GXutil.rtrim( localUtil.format( AV13DDO_DisponibilidadHoraFinAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_disponibilidadhorafinauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPReprogramarCita.htm");
         /* User Defined Control */
         ucTfdisponibilidadhorafin_rangepicker.setProperty("Start Date", AV12DDO_DisponibilidadHoraFinAuxDate);
         ucTfdisponibilidadhorafin_rangepicker.setProperty("End Date", AV14DDO_DisponibilidadHoraFinAuxDateTo);
         ucTfdisponibilidadhorafin_rangepicker.render(context, "wwp.daterangepicker", Tfdisponibilidadhorafin_rangepicker_Internalname, "TFDISPONIBILIDADHORAFIN_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void start2M2( )
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
         Form.getMeta().addItem("description", " Disponibilidad", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2M0( ) ;
   }

   public void ws2M2( )
   {
      start2M2( ) ;
      evt2M2( ) ;
   }

   public void evt2M2( )
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
                           e112M2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122M2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "VSELECDISPONIBILIDAD.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "VSELECDISPONIBILIDAD.CLICK") == 0 ) )
                        {
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV30SelecDisponibilidad = httpContext.cgiGet( edtavSelecdisponibilidad_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavSelecdisponibilidad_Internalname, AV30SelecDisponibilidad);
                           A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
                           A67DisponibilidadFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadFecha_Internalname), 0)) ;
                           n67DisponibilidadFecha = false ;
                           A69DisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraInicio_Internalname), 0)) ;
                           n69DisponibilidadHoraInicio = false ;
                           A135DisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraFin_Internalname), 0)) ;
                           n135DisponibilidadHoraFin = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e132M2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e142M2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e152M2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VSELECDISPONIBILIDAD.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e162M2 ();
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

   public void we2M2( )
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

   public void pa2M2( )
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
            GX_FocusControl = edtavDdo_disponibilidadhorainicioauxdatetext_Internalname ;
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
                                 int AV7ProfesionalId ,
                                 short AV8SedeId ,
                                 short AV6EspecialidadId ,
                                 String AV19DisponibilidadTipoCita ,
                                 int AV5CitaId ,
                                 java.util.Date AV36TFDisponibilidadHoraInicio ,
                                 java.util.Date AV37TFDisponibilidadHoraInicio_To ,
                                 java.util.Date AV34TFDisponibilidadHoraFin ,
                                 java.util.Date AV35TFDisponibilidadHoraFin_To ,
                                 String AV51Pgmname ,
                                 boolean AV27OrderedDsc ,
                                 int AV43DisponibilidadId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e142M2 ();
      GRID_nCurrentRecord = 0 ;
      rf2M2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_DISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ".", "")));
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
      rf2M2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV51Pgmname = "WPReprogramarCita" ;
      Gx_err = (short)(0) ;
      edtavSelecdisponibilidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSelecdisponibilidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSelecdisponibilidad_Enabled), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rf2M2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      /* Execute user event: Refresh */
      e142M2 ();
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
                                              AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio ,
                                              AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to ,
                                              AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin ,
                                              AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to ,
                                              A69DisponibilidadHoraInicio ,
                                              A135DisponibilidadHoraFin ,
                                              Boolean.valueOf(AV27OrderedDsc) ,
                                              Integer.valueOf(A138DCitaId) ,
                                              Integer.valueOf(AV5CitaId) ,
                                              Short.valueOf(A35SGSedeDisponibilidadSedeId) ,
                                              Short.valueOf(AV8SedeId) ,
                                              A298DisponibilidadTipoCita ,
                                              AV19DisponibilidadTipoCita ,
                                              Integer.valueOf(AV7ProfesionalId) ,
                                              Short.valueOf(AV6EspecialidadId) ,
                                              Integer.valueOf(A31ProfesionalId) ,
                                              Short.valueOf(A32EspecialidadId) } ,
                                              new int[]{
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor H002M3 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV7ProfesionalId), Short.valueOf(AV6EspecialidadId), Integer.valueOf(AV5CitaId), Short.valueOf(AV8SedeId), AV19DisponibilidadTipoCita, AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio, AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to, AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin, AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_15_idx = 1 ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A31ProfesionalId = H002M3_A31ProfesionalId[0] ;
            A32EspecialidadId = H002M3_A32EspecialidadId[0] ;
            A35SGSedeDisponibilidadSedeId = H002M3_A35SGSedeDisponibilidadSedeId[0] ;
            A298DisponibilidadTipoCita = H002M3_A298DisponibilidadTipoCita[0] ;
            A135DisponibilidadHoraFin = H002M3_A135DisponibilidadHoraFin[0] ;
            n135DisponibilidadHoraFin = H002M3_n135DisponibilidadHoraFin[0] ;
            A69DisponibilidadHoraInicio = H002M3_A69DisponibilidadHoraInicio[0] ;
            n69DisponibilidadHoraInicio = H002M3_n69DisponibilidadHoraInicio[0] ;
            A67DisponibilidadFecha = H002M3_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = H002M3_n67DisponibilidadFecha[0] ;
            A34DisponibilidadId = H002M3_A34DisponibilidadId[0] ;
            A138DCitaId = H002M3_A138DCitaId[0] ;
            n138DCitaId = H002M3_n138DCitaId[0] ;
            A138DCitaId = H002M3_A138DCitaId[0] ;
            n138DCitaId = H002M3_n138DCitaId[0] ;
            e152M2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(15) ;
         wb2M0( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2M2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV51Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV5CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_DISPONIBILIDADID"+"_"+sGXsfl_15_idx, getSecureSignedToken( sGXsfl_15_idx, localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")));
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
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio ,
                                           AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to ,
                                           AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin ,
                                           AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Boolean.valueOf(AV27OrderedDsc) ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV5CitaId) ,
                                           Short.valueOf(A35SGSedeDisponibilidadSedeId) ,
                                           Short.valueOf(AV8SedeId) ,
                                           A298DisponibilidadTipoCita ,
                                           AV19DisponibilidadTipoCita ,
                                           Integer.valueOf(AV7ProfesionalId) ,
                                           Short.valueOf(AV6EspecialidadId) ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           Short.valueOf(A32EspecialidadId) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor H002M5 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV7ProfesionalId), Short.valueOf(AV6EspecialidadId), Integer.valueOf(AV5CitaId), Short.valueOf(AV8SedeId), AV19DisponibilidadTipoCita, AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio, AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to, AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin, AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to});
      GRID_nRecordCount = H002M5_AGRID_nRecordCount[0] ;
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
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV7ProfesionalId, AV8SedeId, AV6EspecialidadId, AV19DisponibilidadTipoCita, AV5CitaId, AV36TFDisponibilidadHoraInicio, AV37TFDisponibilidadHoraInicio_To, AV34TFDisponibilidadHoraFin, AV35TFDisponibilidadHoraFin_To, AV51Pgmname, AV27OrderedDsc, AV43DisponibilidadId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV7ProfesionalId, AV8SedeId, AV6EspecialidadId, AV19DisponibilidadTipoCita, AV5CitaId, AV36TFDisponibilidadHoraInicio, AV37TFDisponibilidadHoraInicio_To, AV34TFDisponibilidadHoraFin, AV35TFDisponibilidadHoraFin_To, AV51Pgmname, AV27OrderedDsc, AV43DisponibilidadId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV7ProfesionalId, AV8SedeId, AV6EspecialidadId, AV19DisponibilidadTipoCita, AV5CitaId, AV36TFDisponibilidadHoraInicio, AV37TFDisponibilidadHoraInicio_To, AV34TFDisponibilidadHoraFin, AV35TFDisponibilidadHoraFin_To, AV51Pgmname, AV27OrderedDsc, AV43DisponibilidadId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV7ProfesionalId, AV8SedeId, AV6EspecialidadId, AV19DisponibilidadTipoCita, AV5CitaId, AV36TFDisponibilidadHoraInicio, AV37TFDisponibilidadHoraInicio_To, AV34TFDisponibilidadHoraFin, AV35TFDisponibilidadHoraFin_To, AV51Pgmname, AV27OrderedDsc, AV43DisponibilidadId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV7ProfesionalId, AV8SedeId, AV6EspecialidadId, AV19DisponibilidadTipoCita, AV5CitaId, AV36TFDisponibilidadHoraInicio, AV37TFDisponibilidadHoraInicio_To, AV34TFDisponibilidadHoraFin, AV35TFDisponibilidadHoraFin_To, AV51Pgmname, AV27OrderedDsc, AV43DisponibilidadId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV51Pgmname = "WPReprogramarCita" ;
      Gx_err = (short)(0) ;
      edtavSelecdisponibilidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSelecdisponibilidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSelecdisponibilidad_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2M0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e132M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), ",", ".")) ;
         AV20GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV21GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV15DDO_DisponibilidadHoraInicioAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAINICIOAUXDATE"), 0) ;
         AV17DDO_DisponibilidadHoraInicioAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAINICIOAUXDATETO"), 0) ;
         AV12DDO_DisponibilidadHoraFinAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAFINAUXDATE"), 0) ;
         AV14DDO_DisponibilidadHoraFinAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_DISPONIBILIDADHORAFINAUXDATETO"), 0) ;
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
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         /* Read variables values. */
         AV16DDO_DisponibilidadHoraInicioAuxDateText = httpContext.cgiGet( edtavDdo_disponibilidadhorainicioauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16DDO_DisponibilidadHoraInicioAuxDateText", AV16DDO_DisponibilidadHoraInicioAuxDateText);
         AV13DDO_DisponibilidadHoraFinAuxDateText = httpContext.cgiGet( edtavDdo_disponibilidadhorafinauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13DDO_DisponibilidadHoraFinAuxDateText", AV13DDO_DisponibilidadHoraFinAuxDateText);
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
      e132M2 ();
      if (returnInSub) return;
   }

   public void e132M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeUsercontrolMethod("", false, "TFDISPONIBILIDADHORAFIN_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_disponibilidadhorafinauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFDISPONIBILIDADHORAINICIO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_disponibilidadhorainicioauxdatetext_Internalname});
      subGrid_Rows = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Disponibilidad" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      edtDisponibilidadId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), !bGXsfl_15_Refreshing);
      GXv_int3[0] = AV7ProfesionalId ;
      GXv_int4[0] = AV8SedeId ;
      GXv_int5[0] = AV6EspecialidadId ;
      GXv_char6[0] = AV19DisponibilidadTipoCita ;
      new com.projectthani.prcgetdisponibilidaddata(remoteHandle, context).execute( AV43DisponibilidadId, GXv_int3, GXv_int4, GXv_int5, GXv_char6) ;
      wpreprogramarcita_impl.this.AV7ProfesionalId = GXv_int3[0] ;
      wpreprogramarcita_impl.this.AV8SedeId = GXv_int4[0] ;
      wpreprogramarcita_impl.this.AV6EspecialidadId = GXv_int5[0] ;
      wpreprogramarcita_impl.this.AV19DisponibilidadTipoCita = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ProfesionalId), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV8SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SedeId), 4, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV6EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6EspecialidadId), 4, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV19DisponibilidadTipoCita", AV19DisponibilidadTipoCita);
   }

   public void e142M2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      edtDisponibilidadId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), !bGXsfl_15_Refreshing);
      GXv_SdtWWPContext7[0] = AV42WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
      AV42WWPContext = GXv_SdtWWPContext7[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      AV20GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GridCurrentPage), 10, 0));
      AV21GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21GridPageCount), 10, 0));
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = AV36TFDisponibilidadHoraInicio ;
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = AV37TFDisponibilidadHoraInicio_To ;
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = AV34TFDisponibilidadHoraFin ;
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = AV35TFDisponibilidadHoraFin_To ;
      /*  Sending Event outputs  */
   }

   public void e112M2( )
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
         AV28PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV28PageToGo) ;
      }
   }

   public void e122M2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV27OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27OrderedDsc", AV27OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadHoraInicio") == 0 )
         {
            AV36TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFDisponibilidadHoraInicio", localUtil.ttoc( AV36TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV37TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV37TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV37TFDisponibilidadHoraInicio_To) )
            {
               AV37TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV37TFDisponibilidadHoraInicio_To)), (byte)(GXutil.month( AV37TFDisponibilidadHoraInicio_To)), (byte)(GXutil.day( AV37TFDisponibilidadHoraInicio_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV37TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV37TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DisponibilidadHoraFin") == 0 )
         {
            AV34TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFDisponibilidadHoraFin", localUtil.ttoc( AV34TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV35TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFDisponibilidadHoraFin_To", localUtil.ttoc( AV35TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV35TFDisponibilidadHoraFin_To) )
            {
               AV35TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV35TFDisponibilidadHoraFin_To)), (byte)(GXutil.month( AV35TFDisponibilidadHoraFin_To)), (byte)(GXutil.day( AV35TFDisponibilidadHoraFin_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV35TFDisponibilidadHoraFin_To", localUtil.ttoc( AV35TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e152M2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      edtDisponibilidadId_Visible = 0 ;
      AV30SelecDisponibilidad = "<i class=\"fa fa-check\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavSelecdisponibilidad_Internalname, AV30SelecDisponibilidad);
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

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = "-1:"+(AV27OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue(AV51Pgmname+"GridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV51Pgmname+"GridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV31Session.getValue(AV51Pgmname+"GridState"), null, null);
      }
      AV27OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27OrderedDsc", AV27OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAINICIO") == 0 )
         {
            AV36TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFDisponibilidadHoraInicio", localUtil.ttoc( AV36TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV37TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFDisponibilidadHoraInicio_To", localUtil.ttoc( AV37TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            AV15DDO_DisponibilidadHoraInicioAuxDate = GXutil.resetTime(AV36TFDisponibilidadHoraInicio) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15DDO_DisponibilidadHoraInicioAuxDate", localUtil.format(AV15DDO_DisponibilidadHoraInicioAuxDate, "99/99/99"));
            AV17DDO_DisponibilidadHoraInicioAuxDateTo = GXutil.resetTime(AV37TFDisponibilidadHoraInicio_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17DDO_DisponibilidadHoraInicioAuxDateTo", localUtil.format(AV17DDO_DisponibilidadHoraInicioAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAFIN") == 0 )
         {
            AV34TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFDisponibilidadHoraFin", localUtil.ttoc( AV34TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV35TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFDisponibilidadHoraFin_To", localUtil.ttoc( AV35TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            AV12DDO_DisponibilidadHoraFinAuxDate = GXutil.resetTime(AV34TFDisponibilidadHoraFin) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12DDO_DisponibilidadHoraFinAuxDate", localUtil.format(AV12DDO_DisponibilidadHoraFinAuxDate, "99/99/99"));
            AV14DDO_DisponibilidadHoraFinAuxDateTo = GXutil.resetTime(AV35TFDisponibilidadHoraFin_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14DDO_DisponibilidadHoraFinAuxDateTo", localUtil.format(AV14DDO_DisponibilidadHoraFinAuxDateTo, "99/99/99"));
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
      Ddo_grid_Filteredtext_set = "|"+(GXutil.dateCompare(GXutil.nullDate(), AV36TFDisponibilidadHoraInicio) ? "" : localUtil.dtoc( AV15DDO_DisponibilidadHoraInicioAuxDate, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV34TFDisponibilidadHoraFin) ? "" : localUtil.dtoc( AV12DDO_DisponibilidadHoraFinAuxDate, 3, "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+(GXutil.dateCompare(GXutil.nullDate(), AV37TFDisponibilidadHoraInicio_To) ? "" : localUtil.dtoc( AV17DDO_DisponibilidadHoraInicioAuxDateTo, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV35TFDisponibilidadHoraFin_To) ? "" : localUtil.dtoc( AV14DDO_DisponibilidadHoraFinAuxDateTo, 3, "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV22GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV22GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV22GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S132( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV22GridState.fromxml(AV31Session.getValue(AV51Pgmname+"GridState"), null, null);
      AV22GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV27OrderedDsc );
      AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState8[0] = AV22GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState8, "TFDISPONIBILIDADHORAINICIO", !(GXutil.dateCompare(GXutil.nullDate(), AV36TFDisponibilidadHoraInicio)&&GXutil.dateCompare(GXutil.nullDate(), AV37TFDisponibilidadHoraInicio_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV36TFDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV37TFDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV22GridState = GXv_SdtWWPGridState8[0] ;
      GXv_SdtWWPGridState8[0] = AV22GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState8, "TFDISPONIBILIDADHORAFIN", !(GXutil.dateCompare(GXutil.nullDate(), AV34TFDisponibilidadHoraFin)&&GXutil.dateCompare(GXutil.nullDate(), AV35TFDisponibilidadHoraFin_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV34TFDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV35TFDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV22GridState = GXv_SdtWWPGridState8[0] ;
      AV22GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV22GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV51Pgmname+"GridState", AV22GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV40TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV40TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV51Pgmname );
      AV40TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV40TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV24HTTPRequest.getScriptName()+"?"+AV24HTTPRequest.getQuerystring() );
      AV40TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Disponibilidad" );
      AV31Session.setValue("TrnContext", AV40TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void e162M2( )
   {
      /* Selecdisponibilidad_Click Routine */
      returnInSub = false ;
      GXv_boolean9[0] = AV44isSuccess ;
      new com.projectthani.prcreprogramarcita(remoteHandle, context).execute( AV5CitaId, A34DisponibilidadId, GXv_boolean9) ;
      wpreprogramarcita_impl.this.AV44isSuccess = GXv_boolean9[0] ;
      this.executeExternalObjectMethod("", false, "GlobalEvents", "ReprogramarCita", new Object[] {Boolean.valueOf(AV44isSuccess)}, true);
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CitaId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
      AV43DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DisponibilidadId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV43DisponibilidadId), "ZZZZZZZ9")));
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
      pa2M2( ) ;
      ws2M2( ) ;
      we2M2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334125", true, true);
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
      httpContext.AddJavascriptSource("wpreprogramarcita.js", "?20225110334125", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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

   public void subsflControlProps_152( )
   {
      edtavSelecdisponibilidad_Internalname = "vSELECDISPONIBILIDAD_"+sGXsfl_15_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_15_idx ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA_"+sGXsfl_15_idx ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO_"+sGXsfl_15_idx ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      edtavSelecdisponibilidad_Internalname = "vSELECDISPONIBILIDAD_"+sGXsfl_15_fel_idx ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID_"+sGXsfl_15_fel_idx ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA_"+sGXsfl_15_fel_idx ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO_"+sGXsfl_15_fel_idx ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wb2M0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavSelecdisponibilidad_Enabled!=0)&&(edtavSelecdisponibilidad_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 16,'',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSelecdisponibilidad_Internalname,AV30SelecDisponibilidad,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSelecdisponibilidad_Enabled!=0)&&(edtavSelecdisponibilidad_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,16);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVSELECDISPONIBILIDAD.CLICK."+sGXsfl_15_idx+"'","","","","",edtavSelecdisponibilidad_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSelecdisponibilidad_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtDisponibilidadId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtDisponibilidadId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadFecha_Internalname,localUtil.format(A67DisponibilidadFecha, "99/99/99"),localUtil.format( A67DisponibilidadFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadHoraInicio_Internalname,localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A69DisponibilidadHoraInicio, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadHoraInicio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDisponibilidadHoraFin_Internalname,localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A135DisponibilidadHoraFin, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDisponibilidadHoraFin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2M2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_15_idx = ((subGrid_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      /* End function sendrow_152 */
   }

   public void init_default_properties( )
   {
      edtavSelecdisponibilidad_Internalname = "vSELECDISPONIBILIDAD" ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID" ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA" ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO" ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_disponibilidadhorainicioauxdatetext_Internalname = "vDDO_DISPONIBILIDADHORAINICIOAUXDATETEXT" ;
      Tfdisponibilidadhorainicio_rangepicker_Internalname = "TFDISPONIBILIDADHORAINICIO_RANGEPICKER" ;
      divDdo_disponibilidadhorainicioauxdates_Internalname = "DDO_DISPONIBILIDADHORAINICIOAUXDATES" ;
      edtavDdo_disponibilidadhorafinauxdatetext_Internalname = "vDDO_DISPONIBILIDADHORAFINAUXDATETEXT" ;
      Tfdisponibilidadhorafin_rangepicker_Internalname = "TFDISPONIBILIDADHORAFIN_RANGEPICKER" ;
      divDdo_disponibilidadhorafinauxdates_Internalname = "DDO_DISPONIBILIDADHORAFINAUXDATES" ;
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
      edtDisponibilidadHoraFin_Jsonclick = "" ;
      edtDisponibilidadHoraInicio_Jsonclick = "" ;
      edtDisponibilidadFecha_Jsonclick = "" ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtavSelecdisponibilidad_Jsonclick = "" ;
      edtavSelecdisponibilidad_Visible = -1 ;
      edtavDdo_disponibilidadhorafinauxdatetext_Jsonclick = "" ;
      edtavDdo_disponibilidadhorainicioauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtavSelecdisponibilidad_Enabled = 1 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Disponibilidad" );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Filterisrange = "|P|P" ;
      Ddo_grid_Filtertype = "|Date|Date" ;
      Ddo_grid_Includefilter = "|T|T" ;
      Ddo_grid_Includesortasc = "T||" ;
      Ddo_grid_Columnssortvalues = "-1||" ;
      Ddo_grid_Columnids = "2:DisponibilidadFecha|3:DisponibilidadHoraInicio|4:DisponibilidadHoraFin" ;
      Ddo_grid_Gridinternalname = "" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
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
      edtDisponibilidadId_Visible = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV7ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV8SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'AV6EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'AV19DisponibilidadTipoCita',fld:'vDISPONIBILIDADTIPOCITA',pic:''},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV36TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV37TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV34TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV35TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV27OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV43DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'AV20GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV21GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e112M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV8SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'AV6EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'AV19DisponibilidadTipoCita',fld:'vDISPONIBILIDADTIPOCITA',pic:''},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV36TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV37TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV34TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV35TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV27OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'AV43DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e122M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV8SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'AV6EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'AV19DisponibilidadTipoCita',fld:'vDISPONIBILIDADTIPOCITA',pic:''},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV36TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV37TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV34TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV35TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV27OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'AV43DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV27OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36TFDisponibilidadHoraInicio',fld:'vTFDISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV37TFDisponibilidadHoraInicio_To',fld:'vTFDISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV34TFDisponibilidadHoraFin',fld:'vTFDISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV35TFDisponibilidadHoraFin_To',fld:'vTFDISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e152M2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtDisponibilidadId_Visible',ctrl:'DISPONIBILIDADID',prop:'Visible'},{av:'AV30SelecDisponibilidad',fld:'vSELECDISPONIBILIDAD',pic:''}]}");
      setEventMetadata("VSELECDISPONIBILIDAD.CLICK","{handler:'e162M2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("VSELECDISPONIBILIDAD.CLICK",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADID","{handler:'valid_Disponibilidadid',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Disponibilidadhorafin',iparms:[]");
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
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV19DisponibilidadTipoCita = "" ;
      AV36TFDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV37TFDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV34TFDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV35TFDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV51Pgmname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV18DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17DDO_DisponibilidadHoraInicioAuxDateTo = GXutil.nullDate() ;
      AV14DDO_DisponibilidadHoraFinAuxDateTo = GXutil.nullDate() ;
      AV15DDO_DisponibilidadHoraInicioAuxDate = GXutil.nullDate() ;
      AV12DDO_DisponibilidadHoraFinAuxDate = GXutil.nullDate() ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV30SelecDisponibilidad = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV16DDO_DisponibilidadHoraInicioAuxDateText = "" ;
      ucTfdisponibilidadhorainicio_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV13DDO_DisponibilidadHoraFinAuxDateText = "" ;
      ucTfdisponibilidadhorafin_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      A298DisponibilidadTipoCita = "" ;
      H002M3_A31ProfesionalId = new int[1] ;
      H002M3_A32EspecialidadId = new short[1] ;
      H002M3_A35SGSedeDisponibilidadSedeId = new short[1] ;
      H002M3_A298DisponibilidadTipoCita = new String[] {""} ;
      H002M3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H002M3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      H002M3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H002M3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      H002M3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H002M3_n67DisponibilidadFecha = new boolean[] {false} ;
      H002M3_A34DisponibilidadId = new int[1] ;
      H002M3_A138DCitaId = new int[1] ;
      H002M3_n138DCitaId = new boolean[] {false} ;
      H002M5_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int3 = new int[1] ;
      GXv_int4 = new short[1] ;
      GXv_int5 = new short[1] ;
      GXv_char6 = new String[1] ;
      AV42WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV31Session = httpContext.getWebSession();
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState8 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV40TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV24HTTPRequest = httpContext.getHttpRequest();
      GXv_boolean9 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpreprogramarcita__default(),
         new Object[] {
             new Object[] {
            H002M3_A31ProfesionalId, H002M3_A32EspecialidadId, H002M3_A35SGSedeDisponibilidadSedeId, H002M3_A298DisponibilidadTipoCita, H002M3_A135DisponibilidadHoraFin, H002M3_n135DisponibilidadHoraFin, H002M3_A69DisponibilidadHoraInicio, H002M3_n69DisponibilidadHoraInicio, H002M3_A67DisponibilidadFecha, H002M3_n67DisponibilidadFecha,
            H002M3_A34DisponibilidadId, H002M3_A138DCitaId, H002M3_n138DCitaId
            }
            , new Object[] {
            H002M5_AGRID_nRecordCount
            }
         }
      );
      AV51Pgmname = "WPReprogramarCita" ;
      /* GeneXus formulas. */
      AV51Pgmname = "WPReprogramarCita" ;
      Gx_err = (short)(0) ;
      edtavSelecdisponibilidad_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
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
   private short AV8SedeId ;
   private short AV6EspecialidadId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A35SGSedeDisponibilidadSedeId ;
   private short A32EspecialidadId ;
   private short GXv_int4[] ;
   private short GXv_int5[] ;
   private int wcpOAV5CitaId ;
   private int wcpOAV43DisponibilidadId ;
   private int edtDisponibilidadId_Visible ;
   private int subGrid_Rows ;
   private int nRC_GXsfl_15 ;
   private int nGXsfl_15_idx=1 ;
   private int AV7ProfesionalId ;
   private int AV5CitaId ;
   private int AV43DisponibilidadId ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavSelecdisponibilidad_Enabled ;
   private int A34DisponibilidadId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int A138DCitaId ;
   private int A31ProfesionalId ;
   private int GXv_int3[] ;
   private int AV28PageToGo ;
   private int AV52GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int edtavSelecdisponibilidad_Visible ;
   private long GRID_nFirstRecordOnPage ;
   private long AV20GridCurrentPage ;
   private long AV21GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_15_idx="0001" ;
   private String edtDisponibilidadId_Internalname ;
   private String AV19DisponibilidadTipoCita ;
   private String AV51Pgmname ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
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
   private String subGrid_Header ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_disponibilidadhorainicioauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_disponibilidadhorainicioauxdatetext_Internalname ;
   private String edtavDdo_disponibilidadhorainicioauxdatetext_Jsonclick ;
   private String Tfdisponibilidadhorainicio_rangepicker_Internalname ;
   private String divDdo_disponibilidadhorafinauxdates_Internalname ;
   private String edtavDdo_disponibilidadhorafinauxdatetext_Internalname ;
   private String edtavDdo_disponibilidadhorafinauxdatetext_Jsonclick ;
   private String Tfdisponibilidadhorafin_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSelecdisponibilidad_Internalname ;
   private String edtDisponibilidadFecha_Internalname ;
   private String edtDisponibilidadHoraInicio_Internalname ;
   private String edtDisponibilidadHoraFin_Internalname ;
   private String scmdbuf ;
   private String A298DisponibilidadTipoCita ;
   private String GXv_char6[] ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavSelecdisponibilidad_Jsonclick ;
   private String edtDisponibilidadId_Jsonclick ;
   private String edtDisponibilidadFecha_Jsonclick ;
   private String edtDisponibilidadHoraInicio_Jsonclick ;
   private String edtDisponibilidadHoraFin_Jsonclick ;
   private java.util.Date AV36TFDisponibilidadHoraInicio ;
   private java.util.Date AV37TFDisponibilidadHoraInicio_To ;
   private java.util.Date AV34TFDisponibilidadHoraFin ;
   private java.util.Date AV35TFDisponibilidadHoraFin_To ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio ;
   private java.util.Date AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to ;
   private java.util.Date AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin ;
   private java.util.Date AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to ;
   private java.util.Date AV17DDO_DisponibilidadHoraInicioAuxDateTo ;
   private java.util.Date AV14DDO_DisponibilidadHoraFinAuxDateTo ;
   private java.util.Date AV15DDO_DisponibilidadHoraInicioAuxDate ;
   private java.util.Date AV12DDO_DisponibilidadHoraFinAuxDate ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean AV27OrderedDsc ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n138DCitaId ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV44isSuccess ;
   private boolean GXv_boolean9[] ;
   private String AV30SelecDisponibilidad ;
   private String AV16DDO_DisponibilidadHoraInicioAuxDateText ;
   private String AV13DDO_DisponibilidadHoraFinAuxDateText ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV24HTTPRequest ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfdisponibilidadhorainicio_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfdisponibilidadhorafin_rangepicker ;
   private IDataStoreProvider pr_default ;
   private int[] H002M3_A31ProfesionalId ;
   private short[] H002M3_A32EspecialidadId ;
   private short[] H002M3_A35SGSedeDisponibilidadSedeId ;
   private String[] H002M3_A298DisponibilidadTipoCita ;
   private java.util.Date[] H002M3_A135DisponibilidadHoraFin ;
   private boolean[] H002M3_n135DisponibilidadHoraFin ;
   private java.util.Date[] H002M3_A69DisponibilidadHoraInicio ;
   private boolean[] H002M3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] H002M3_A67DisponibilidadFecha ;
   private boolean[] H002M3_n67DisponibilidadFecha ;
   private int[] H002M3_A34DisponibilidadId ;
   private int[] H002M3_A138DCitaId ;
   private boolean[] H002M3_n138DCitaId ;
   private long[] H002M5_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV40TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV42WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
}

final  class wpreprogramarcita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002M3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio ,
                                          java.util.Date AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin ,
                                          java.util.Date AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          boolean AV27OrderedDsc ,
                                          int A138DCitaId ,
                                          int AV5CitaId ,
                                          short A35SGSedeDisponibilidadSedeId ,
                                          short AV8SedeId ,
                                          String A298DisponibilidadTipoCita ,
                                          String AV19DisponibilidadTipoCita ,
                                          int AV7ProfesionalId ,
                                          short AV6EspecialidadId ,
                                          int A31ProfesionalId ,
                                          short A32EspecialidadId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[12];
      Object[] GXv_Object11 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[ProfesionalId], T1.[EspecialidadId], T1.[SGSedeDisponibilidadSedeId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio]," ;
      sSelectString += " T1.[DisponibilidadFecha], T1.[DisponibilidadId], COALESCE( T2.[DCitaId], 0) AS DCitaId" ;
      sFromString = " FROM ([Disponibilidad] T1 LEFT JOIN (SELECT MIN(T3.[CitaId]) AS DCitaId, T3.[SGCitaDisponibilidadId] FROM [Cita] T3,  [Disponibilidad] T4 WHERE (T3.[SGCitaDisponibilidadId]" ;
      sFromString += " = T4.[DisponibilidadId]) AND (T3.[CitaEstado] = 'A') GROUP BY T3.[SGCitaDisponibilidadId] ) T2 ON T2.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ?)");
      addWhere(sWhereString, "(COALESCE( T2.[DCitaId], 0) = 0)");
      addWhere(sWhereString, "(COALESCE( T2.[DCitaId], 0) <> ?)");
      addWhere(sWhereString, "(T1.[SGSedeDisponibilidadSedeId] = ?)");
      addWhere(sWhereString, "(T1.[DisponibilidadTipoCita] = ?)");
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! AV27OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadFecha]" ;
      }
      else if ( AV27OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadFecha] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[DisponibilidadId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_H002M5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio ,
                                          java.util.Date AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin ,
                                          java.util.Date AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          boolean AV27OrderedDsc ,
                                          int A138DCitaId ,
                                          int AV5CitaId ,
                                          short A35SGSedeDisponibilidadSedeId ,
                                          short AV8SedeId ,
                                          String A298DisponibilidadTipoCita ,
                                          String AV19DisponibilidadTipoCita ,
                                          int AV7ProfesionalId ,
                                          short AV6EspecialidadId ,
                                          int A31ProfesionalId ,
                                          short A32EspecialidadId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[9];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ([Disponibilidad] T1 LEFT JOIN (SELECT MIN(T3.[CitaId]) AS DCitaId, T3.[SGCitaDisponibilidadId] FROM [Cita] T3,  [Disponibilidad] T4 WHERE (T3.[SGCitaDisponibilidadId]" ;
      scmdbuf += " = T4.[DisponibilidadId]) AND (T3.[CitaEstado] = 'A') GROUP BY T3.[SGCitaDisponibilidadId] ) T2 ON T2.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "(T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ?)");
      addWhere(sWhereString, "(COALESCE( T2.[DCitaId], 0) = 0)");
      addWhere(sWhereString, "(COALESCE( T2.[DCitaId], 0) <> ?)");
      addWhere(sWhereString, "(T1.[SGSedeDisponibilidadSedeId] = ?)");
      addWhere(sWhereString, "(T1.[DisponibilidadTipoCita] = ?)");
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV47Wpreprogramarcitads_1_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV48Wpreprogramarcitads_2_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV49Wpreprogramarcitads_3_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV50Wpreprogramarcitads_4_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ! AV27OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( AV27OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_H002M3(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Boolean) dynConstraints[6]).booleanValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() );
            case 1 :
                  return conditional_H002M5(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Boolean) dynConstraints[6]).booleanValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002M3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002M5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[17], true);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[18], true);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], true);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], true);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[14], true);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[15], true);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[16], true);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[17], true);
               }
               return;
      }
   }

}

