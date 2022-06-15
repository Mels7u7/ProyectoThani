package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacienteprompt_impl extends GXDataArea
{
   public pacienteprompt_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pacienteprompt_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacienteprompt_impl.class ));
   }

   public pacienteprompt_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "InOutPacienteId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "InOutPacienteId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "InOutPacienteId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            nRC_GXsfl_24 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_24"))) ;
            nGXsfl_24_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_24_idx"))) ;
            sGXsfl_24_idx = httpContext.GetPar( "sGXsfl_24_idx") ;
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
            AV13FilterFullText = httpContext.GetPar( "FilterFullText") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
            AV8InOutPacienteId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8InOutPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutPacienteId), 8, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9InOutPacienteNombres = httpContext.GetPar( "InOutPacienteNombres") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9InOutPacienteNombres", AV9InOutPacienteNombres);
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.wwpbaseobjects.workwithplusmasterpageprompt");
         MasterPageObj.setDataArea(this,true);
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
      pa6K2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6K2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034570", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.pacienteprompt", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8InOutPacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(AV9InOutPacienteNombres))}, new String[] {"InOutPacienteId","InOutPacienteNombres"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV13FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_24", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_24, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV16GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV17GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV14DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV14DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV11OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV12OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINOUTPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV8InOutPacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINOUTPACIENTENOMBRES", AV9InOutPacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODISTRITO", A188UbigeoDistrito);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we6K2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6K2( ) ;
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
      return formatLink("com.projectthani.pacienteprompt", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8InOutPacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(AV9InOutPacienteNombres))}, new String[] {"InOutPacienteId","InOutPacienteNombres"})  ;
   }

   public String getPgmname( )
   {
      return "PacientePrompt" ;
   }

   public String getPgmdesc( )
   {
      return "Selecciona Paciente" ;
   }

   public void wb6K0( )
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
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainPrompt", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs", "left", "top", "", "", "div");
         wb_table1_12_6K2( true) ;
      }
      else
      {
         wb_table1_12_6K2( false) ;
      }
      return  ;
   }

   public void wb_table1_12_6K2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginPrompt GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
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
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"24\">") ;
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
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Completo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha Nacimiento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Sexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Telefono") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Pais Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Pais Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "User Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo Code") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Ubigeo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estatura") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Peso") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Anexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Image"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Anexos") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Enterarse") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especifique") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
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
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18Select));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSelect_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A212PacienteNombreCompleto);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A214PacienteTipoDocumento));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A106PacienteNroDocumento);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A215PacienteDireccion);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A216PacienteSexo));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A217PacienteCorreo);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A218PacienteTelefono));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A184PaisDescripcion);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A219PacienteEstado));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A44UbigeoCode));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A185UbigeoNombre);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A220PacienteEstatura, (byte)(4), (byte)(2), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A221PacientePeso, (byte)(6), (byte)(2), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A222PacienteNombreAnexo);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A223PacienteAnexos);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A224PacienteEnterarse);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A225PacienteEspecifique);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A226PacienteFechaRegistro, 10, 8, 0, 3, "/", ":", " "));
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
      if ( wbEnd == 24 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_24 = (int)(nGXsfl_24_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV16GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV17GridPageCount);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV14DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 24 )
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

   public void start6K2( )
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
         Form.getMeta().addItem("description", "Selecciona Paciente", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6K0( ) ;
   }

   public void ws6K2( )
   {
      start6K2( ) ;
      evt6K2( ) ;
   }

   public void evt6K2( )
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
                           e116K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e126K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e136K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCLEANFILTERS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCleanFilters' */
                           e146K2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) )
                        {
                           nGXsfl_24_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_242( ) ;
                           AV18Select = httpContext.cgiGet( edtavSelect_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavSelect_Internalname, AV18Select);
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
                           httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_24_Refreshing);
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
                                 e156K2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e166K2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e176K2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV13FilterFullText) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e186K2 ();
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

   public void we6K2( )
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

   public void pa6K2( )
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
      subsflControlProps_242( ) ;
      while ( nGXsfl_24_idx <= nRC_GXsfl_24 )
      {
         sendrow_242( ) ;
         nGXsfl_24_idx = ((subGrid_Islastpage==1)&&(nGXsfl_24_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV13FilterFullText )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e166K2 ();
      GRID_nCurrentRecord = 0 ;
      rf6K2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEID", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PACIENTENOMBRES", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A105PacienteNombres, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTENOMBRES", A105PacienteNombres);
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
      rf6K2( ) ;
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
      edtavSelect_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSelect_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSelect_Enabled), 5, 0), !bGXsfl_24_Refreshing);
   }

   public void rf6K2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(24) ;
      /* Execute user event: Refresh */
      e166K2 ();
      nGXsfl_24_idx = 1 ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
      bGXsfl_24_Refreshing = true ;
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
         subsflControlProps_242( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV13FilterFullText ,
                                              Integer.valueOf(A20PacienteId) ,
                                              A103PacienteApellidoPaterno ,
                                              A104PacienteApellidoMaterno ,
                                              A105PacienteNombres ,
                                              A214PacienteTipoDocumento ,
                                              A106PacienteNroDocumento ,
                                              A215PacienteDireccion ,
                                              A216PacienteSexo ,
                                              A217PacienteCorreo ,
                                              A218PacienteTelefono ,
                                              Short.valueOf(A43PaisId) ,
                                              A184PaisDescripcion ,
                                              A219PacienteEstado ,
                                              Short.valueOf(A6SecUserId) ,
                                              A44UbigeoCode ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito ,
                                              A220PacienteEstatura ,
                                              A221PacientePeso ,
                                              A222PacienteNombreAnexo ,
                                              A224PacienteEnterarse ,
                                              A225PacienteEspecifique ,
                                              Short.valueOf(AV11OrderedBy) ,
                                              Boolean.valueOf(AV12OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN
                                              }
         });
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
         /* Using cursor H006K2 */
         pr_default.execute(0, new Object[] {lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_24_idx = 1 ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A226PacienteFechaRegistro = H006K2_A226PacienteFechaRegistro[0] ;
            A225PacienteEspecifique = H006K2_A225PacienteEspecifique[0] ;
            n225PacienteEspecifique = H006K2_n225PacienteEspecifique[0] ;
            A224PacienteEnterarse = H006K2_A224PacienteEnterarse[0] ;
            n224PacienteEnterarse = H006K2_n224PacienteEnterarse[0] ;
            A223PacienteAnexos = H006K2_A223PacienteAnexos[0] ;
            n223PacienteAnexos = H006K2_n223PacienteAnexos[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_24_Refreshing);
            A222PacienteNombreAnexo = H006K2_A222PacienteNombreAnexo[0] ;
            n222PacienteNombreAnexo = H006K2_n222PacienteNombreAnexo[0] ;
            A221PacientePeso = H006K2_A221PacientePeso[0] ;
            A220PacienteEstatura = H006K2_A220PacienteEstatura[0] ;
            A44UbigeoCode = H006K2_A44UbigeoCode[0] ;
            n44UbigeoCode = H006K2_n44UbigeoCode[0] ;
            A6SecUserId = H006K2_A6SecUserId[0] ;
            n6SecUserId = H006K2_n6SecUserId[0] ;
            A219PacienteEstado = H006K2_A219PacienteEstado[0] ;
            A184PaisDescripcion = H006K2_A184PaisDescripcion[0] ;
            A43PaisId = H006K2_A43PaisId[0] ;
            A218PacienteTelefono = H006K2_A218PacienteTelefono[0] ;
            A217PacienteCorreo = H006K2_A217PacienteCorreo[0] ;
            A216PacienteSexo = H006K2_A216PacienteSexo[0] ;
            A215PacienteDireccion = H006K2_A215PacienteDireccion[0] ;
            A106PacienteNroDocumento = H006K2_A106PacienteNroDocumento[0] ;
            A214PacienteTipoDocumento = H006K2_A214PacienteTipoDocumento[0] ;
            A213PacienteFechaNacimiento = H006K2_A213PacienteFechaNacimiento[0] ;
            A20PacienteId = H006K2_A20PacienteId[0] ;
            A105PacienteNombres = H006K2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H006K2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H006K2_A103PacienteApellidoPaterno[0] ;
            A188UbigeoDistrito = H006K2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H006K2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H006K2_A186UbigeoDepartamento[0] ;
            A188UbigeoDistrito = H006K2_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H006K2_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H006K2_A186UbigeoDepartamento[0] ;
            A184PaisDescripcion = H006K2_A184PaisDescripcion[0] ;
            A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
            A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
            e176K2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(24) ;
         wb6K0( ) ;
      }
      bGXsfl_24_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6K2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PACIENTEID"+"_"+sGXsfl_24_idx, getSecureSignedToken( sGXsfl_24_idx, localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_PACIENTENOMBRES"+"_"+sGXsfl_24_idx, getSecureSignedToken( sGXsfl_24_idx, GXutil.rtrim( localUtil.format( A105PacienteNombres, ""))));
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
                                           AV13FilterFullText ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A214PacienteTipoDocumento ,
                                           A106PacienteNroDocumento ,
                                           A215PacienteDireccion ,
                                           A216PacienteSexo ,
                                           A217PacienteCorreo ,
                                           A218PacienteTelefono ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           A219PacienteEstado ,
                                           Short.valueOf(A6SecUserId) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A220PacienteEstatura ,
                                           A221PacientePeso ,
                                           A222PacienteNombreAnexo ,
                                           A224PacienteEnterarse ,
                                           A225PacienteEspecifique ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN
                                           }
      });
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      lV13FilterFullText = GXutil.concat( GXutil.rtrim( AV13FilterFullText), "%", "") ;
      /* Using cursor H006K3 */
      pr_default.execute(1, new Object[] {lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText, lV13FilterFullText});
      GRID_nRecordCount = H006K3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV13FilterFullText) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSelect_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSelect_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSelect_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup6K0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e156K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV14DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_24"), ",", ".")) ;
         AV16GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV17GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
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
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
         AV13FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV13FilterFullText) != 0 )
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
      e156K2 ();
      if (returnInSub) return;
   }

   public void e156K2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( "Selecciona Paciente" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      if ( AV11OrderedBy < 1 )
      {
         AV11OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV14DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV14DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e166K2( )
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
      AV16GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GridCurrentPage), 10, 0));
      AV17GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GridPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   public void e116K2( )
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
         AV15PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV15PageToGo) ;
      }
   }

   public void e126K2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e136K2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV11OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11OrderedBy), 4, 0));
         AV12OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12OrderedDsc", AV12OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S112 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e176K2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV18Select = "<i class=\"fas fa-check\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavSelect_Internalname, AV18Select);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(24) ;
      }
      sendrow_242( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_24_Refreshing )
      {
         httpContext.doAjaxLoad(24, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e186K2 ();
      if (returnInSub) return;
   }

   public void e186K2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8InOutPacienteId = A20PacienteId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8InOutPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutPacienteId), 8, 0));
      AV9InOutPacienteNombres = A105PacienteNombres ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9InOutPacienteNombres", AV9InOutPacienteNombres);
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV8InOutPacienteId),AV9InOutPacienteNombres});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV8InOutPacienteId","AV9InOutPacienteNombres"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void e146K2( )
   {
      /* 'DoCleanFilters' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CLEANFILTERS' */
      S122 ();
      if (returnInSub) return;
      subgrid_firstpage( ) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV11OrderedBy, 4, 0))+":"+(AV12OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV13FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13FilterFullText", AV13FilterFullText);
   }

   public void wb_table1_12_6K2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTopPaddingTop10'>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCleanfilters_Internalname, "<i class=\"fas fa-filter CleanFiltersIcon\"></i>", "", "", lblCleanfilters_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOCLEANFILTERS\\'."+"'", "", "TextBlock", 5, "Limpiar filtros", 1, 1, 0, (short)(1), "HLP_PacientePrompt.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, "Filter Full Text", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV13FilterFullText, GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,18);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_PacientePrompt.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_12_6K2e( true) ;
      }
      else
      {
         wb_table1_12_6K2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8InOutPacienteId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8InOutPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8InOutPacienteId), 8, 0));
      AV9InOutPacienteNombres = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9InOutPacienteNombres", AV9InOutPacienteNombres);
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
      pa6K2( ) ;
      ws6K2( ) ;
      we6K2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202251103470", true, true);
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
      httpContext.AddJavascriptSource("pacienteprompt.js", "?202251103470", false, true);
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

   public void subsflControlProps_242( )
   {
      edtavSelect_Internalname = "vSELECT_"+sGXsfl_24_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_24_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_24_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_24_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_24_idx ;
      edtPacienteNombreCompleto_Internalname = "PACIENTENOMBRECOMPLETO_"+sGXsfl_24_idx ;
      edtPacienteFechaNacimiento_Internalname = "PACIENTEFECHANACIMIENTO_"+sGXsfl_24_idx ;
      cmbPacienteTipoDocumento.setInternalname( "PACIENTETIPODOCUMENTO_"+sGXsfl_24_idx );
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_24_idx ;
      edtPacienteDireccion_Internalname = "PACIENTEDIRECCION_"+sGXsfl_24_idx ;
      cmbPacienteSexo.setInternalname( "PACIENTESEXO_"+sGXsfl_24_idx );
      edtPacienteCorreo_Internalname = "PACIENTECORREO_"+sGXsfl_24_idx ;
      edtPacienteTelefono_Internalname = "PACIENTETELEFONO_"+sGXsfl_24_idx ;
      edtPaisId_Internalname = "PAISID_"+sGXsfl_24_idx ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION_"+sGXsfl_24_idx ;
      cmbPacienteEstado.setInternalname( "PACIENTEESTADO_"+sGXsfl_24_idx );
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_24_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_24_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_24_idx ;
      edtPacienteEstatura_Internalname = "PACIENTEESTATURA_"+sGXsfl_24_idx ;
      edtPacientePeso_Internalname = "PACIENTEPESO_"+sGXsfl_24_idx ;
      edtPacienteNombreAnexo_Internalname = "PACIENTENOMBREANEXO_"+sGXsfl_24_idx ;
      edtPacienteAnexos_Internalname = "PACIENTEANEXOS_"+sGXsfl_24_idx ;
      cmbPacienteEnterarse.setInternalname( "PACIENTEENTERARSE_"+sGXsfl_24_idx );
      edtPacienteEspecifique_Internalname = "PACIENTEESPECIFIQUE_"+sGXsfl_24_idx ;
      edtPacienteFechaRegistro_Internalname = "PACIENTEFECHAREGISTRO_"+sGXsfl_24_idx ;
   }

   public void subsflControlProps_fel_242( )
   {
      edtavSelect_Internalname = "vSELECT_"+sGXsfl_24_fel_idx ;
      edtPacienteId_Internalname = "PACIENTEID_"+sGXsfl_24_fel_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_24_fel_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_24_fel_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_24_fel_idx ;
      edtPacienteNombreCompleto_Internalname = "PACIENTENOMBRECOMPLETO_"+sGXsfl_24_fel_idx ;
      edtPacienteFechaNacimiento_Internalname = "PACIENTEFECHANACIMIENTO_"+sGXsfl_24_fel_idx ;
      cmbPacienteTipoDocumento.setInternalname( "PACIENTETIPODOCUMENTO_"+sGXsfl_24_fel_idx );
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_24_fel_idx ;
      edtPacienteDireccion_Internalname = "PACIENTEDIRECCION_"+sGXsfl_24_fel_idx ;
      cmbPacienteSexo.setInternalname( "PACIENTESEXO_"+sGXsfl_24_fel_idx );
      edtPacienteCorreo_Internalname = "PACIENTECORREO_"+sGXsfl_24_fel_idx ;
      edtPacienteTelefono_Internalname = "PACIENTETELEFONO_"+sGXsfl_24_fel_idx ;
      edtPaisId_Internalname = "PAISID_"+sGXsfl_24_fel_idx ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION_"+sGXsfl_24_fel_idx ;
      cmbPacienteEstado.setInternalname( "PACIENTEESTADO_"+sGXsfl_24_fel_idx );
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_24_fel_idx ;
      edtUbigeoCode_Internalname = "UBIGEOCODE_"+sGXsfl_24_fel_idx ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE_"+sGXsfl_24_fel_idx ;
      edtPacienteEstatura_Internalname = "PACIENTEESTATURA_"+sGXsfl_24_fel_idx ;
      edtPacientePeso_Internalname = "PACIENTEPESO_"+sGXsfl_24_fel_idx ;
      edtPacienteNombreAnexo_Internalname = "PACIENTENOMBREANEXO_"+sGXsfl_24_fel_idx ;
      edtPacienteAnexos_Internalname = "PACIENTEANEXOS_"+sGXsfl_24_fel_idx ;
      cmbPacienteEnterarse.setInternalname( "PACIENTEENTERARSE_"+sGXsfl_24_fel_idx );
      edtPacienteEspecifique_Internalname = "PACIENTEESPECIFIQUE_"+sGXsfl_24_fel_idx ;
      edtPacienteFechaRegistro_Internalname = "PACIENTEFECHAREGISTRO_"+sGXsfl_24_fel_idx ;
   }

   public void sendrow_242( )
   {
      subsflControlProps_242( ) ;
      wb6K0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_24_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_24_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_24_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavSelect_Enabled!=0)&&(edtavSelect_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 25,'',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSelect_Internalname,GXutil.rtrim( AV18Select),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSelect_Enabled!=0)&&(edtavSelect_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,25);\"" : " "),"'"+""+"'"+",false,"+"'"+"EENTER."+sGXsfl_24_idx+"'","","","Seleccionar","",edtavSelect_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSelect_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteId_Internalname,GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoPaterno_Internalname,A103PacienteApellidoPaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoPaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoMaterno_Internalname,A104PacienteApellidoMaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoMaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombres_Internalname,A105PacienteNombres,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombreCompleto_Internalname,A212PacienteNombreCompleto,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNombreCompleto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteFechaNacimiento_Internalname,localUtil.format(A213PacienteFechaNacimiento, "99/99/99"),localUtil.format( A213PacienteFechaNacimiento, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteFechaNacimiento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPacienteTipoDocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTETIPODOCUMENTO_" + sGXsfl_24_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteTipoDocumento,cmbPacienteTipoDocumento.getInternalname(),GXutil.rtrim( A214PacienteTipoDocumento),Integer.valueOf(1),cmbPacienteTipoDocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteTipoDocumento.setValue( GXutil.rtrim( A214PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteTipoDocumento.getInternalname(), "Values", cmbPacienteTipoDocumento.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNroDocumento_Internalname,A106PacienteNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteDireccion_Internalname,A215PacienteDireccion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteDireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPacienteSexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTESEXO_" + sGXsfl_24_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteSexo,cmbPacienteSexo.getInternalname(),GXutil.rtrim( A216PacienteSexo),Integer.valueOf(1),cmbPacienteSexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteSexo.setValue( GXutil.rtrim( A216PacienteSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteSexo.getInternalname(), "Values", cmbPacienteSexo.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteCorreo_Internalname,A217PacienteCorreo,"","","'"+""+"'"+",false,"+"'"+""+"'","mailto:"+A217PacienteCorreo,"","","",edtPacienteCorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         if ( httpContext.isSmartDevice( ) )
         {
            gxphoneLink = "tel:" + GXutil.rtrim( A218PacienteTelefono) ;
         }
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteTelefono_Internalname,GXutil.rtrim( A218PacienteTelefono),"","","'"+""+"'"+",false,"+"'"+""+"'",gxphoneLink,"","","",edtPacienteTelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"tel","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Phone","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaisId_Internalname,GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaisId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPaisDescripcion_Internalname,A184PaisDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPaisDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPacienteEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTEESTADO_" + sGXsfl_24_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteEstado,cmbPacienteEstado.getInternalname(),GXutil.rtrim( A219PacienteEstado),Integer.valueOf(1),cmbPacienteEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteEstado.setValue( GXutil.rtrim( A219PacienteEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEstado.getInternalname(), "Values", cmbPacienteEstado.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserId_Internalname,GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecUserId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoCode_Internalname,GXutil.rtrim( A44UbigeoCode),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtUbigeoNombre_Internalname,A185UbigeoNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtUbigeoNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteEstatura_Internalname,GXutil.ltrim( localUtil.ntoc( A220PacienteEstatura, (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A220PacienteEstatura, "9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteEstatura_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacientePeso_Internalname,GXutil.ltrim( localUtil.ntoc( A221PacientePeso, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( A221PacientePeso, "ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacientePeso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombreAnexo_Internalname,A222PacienteNombreAnexo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNombreAnexo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         ClassString = "Image" ;
         StyleString = "" ;
         edtPacienteAnexos_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, !bGXsfl_24_Refreshing);
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
               httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_24_Refreshing);
               edtPacienteAnexos_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, !bGXsfl_24_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), !bGXsfl_24_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtPacienteAnexos_Internalname,GXutil.rtrim( A223PacienteAnexos),httpContext.getResourceRelative(A223PacienteAnexos),((GXutil.strcmp("", edtPacienteAnexos_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtPacienteAnexos_Filetype)==0) ? A223PacienteAnexos : edtPacienteAnexos_Filetype)) : edtPacienteAnexos_Contenttype),Boolean.valueOf(false),"",edtPacienteAnexos_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtPacienteAnexos_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPacienteEnterarse.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PACIENTEENTERARSE_" + sGXsfl_24_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPacienteEnterarse,cmbPacienteEnterarse.getInternalname(),GXutil.rtrim( A224PacienteEnterarse),Integer.valueOf(1),cmbPacienteEnterarse.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","svchar","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbPacienteEnterarse.setValue( GXutil.rtrim( A224PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEnterarse.getInternalname(), "Values", cmbPacienteEnterarse.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteEspecifique_Internalname,A225PacienteEspecifique,A225PacienteEspecifique,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteEspecifique_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteFechaRegistro_Internalname,localUtil.ttoc( A226PacienteFechaRegistro, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A226PacienteFechaRegistro, "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteFechaRegistro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes6K2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_24_idx = ((subGrid_Islastpage==1)&&(nGXsfl_24_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      /* End function sendrow_242 */
   }

   public void init_default_properties( )
   {
      lblCleanfilters_Internalname = "CLEANFILTERS" ;
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavSelect_Internalname = "vSELECT" ;
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
      edtavSelect_Jsonclick = "" ;
      edtavSelect_Visible = -1 ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtavSelect_Enabled = 1 ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Selecciona Paciente" );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|1|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22" ;
      Ddo_grid_Columnids = "1:PacienteId|2:PacienteApellidoPaterno|3:PacienteApellidoMaterno|4:PacienteNombres|6:PacienteFechaNacimiento|7:PacienteTipoDocumento|8:PacienteNroDocumento|9:PacienteDireccion|10:PacienteSexo|11:PacienteCorreo|12:PacienteTelefono|13:PaisId|14:PaisDescripcion|15:PacienteEstado|16:SecUserId|17:UbigeoCode|19:PacienteEstatura|20:PacientePeso|21:PacienteNombreAnexo|23:PacienteEnterarse|24:PacienteEspecifique|25:PacienteFechaRegistro" ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "PACIENTETIPODOCUMENTO_" + sGXsfl_24_idx ;
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
      GXCCtl = "PACIENTESEXO_" + sGXsfl_24_idx ;
      cmbPacienteSexo.setName( GXCCtl );
      cmbPacienteSexo.setWebtags( "" );
      cmbPacienteSexo.addItem("M", "Masculino", (short)(0));
      cmbPacienteSexo.addItem("F", "Femenino", (short)(0));
      if ( cmbPacienteSexo.getItemCount() > 0 )
      {
         A216PacienteSexo = cmbPacienteSexo.getValidValue(A216PacienteSexo) ;
      }
      GXCCtl = "PACIENTEESTADO_" + sGXsfl_24_idx ;
      cmbPacienteEstado.setName( GXCCtl );
      cmbPacienteEstado.setWebtags( "" );
      cmbPacienteEstado.addItem("A", "Activo", (short)(0));
      cmbPacienteEstado.addItem("P", "Pendiente", (short)(0));
      cmbPacienteEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbPacienteEstado.getItemCount() > 0 )
      {
         A219PacienteEstado = cmbPacienteEstado.getValidValue(A219PacienteEstado) ;
      }
      GXCCtl = "PACIENTEENTERARSE_" + sGXsfl_24_idx ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV16GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV17GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e116K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e126K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e136K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'AV11OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV12OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV11OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV12OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e176K2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV18Select',fld:'vSELECT',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e186K2',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'A105PacienteNombres',fld:'PACIENTENOMBRES',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV8InOutPacienteId',fld:'vINOUTPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV9InOutPacienteNombres',fld:'vINOUTPACIENTENOMBRES',pic:''}]}");
      setEventMetadata("'DOCLEANFILTERS'","{handler:'e146K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''}]");
      setEventMetadata("'DOCLEANFILTERS'",",oparms:[{av:'AV13FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV16GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV17GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
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
      wcpOAV9InOutPacienteNombres = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13FilterFullText = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      AV9InOutPacienteNombres = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV14DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV18Select = "" ;
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
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      lV13FilterFullText = "" ;
      H006K2_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      H006K2_A225PacienteEspecifique = new String[] {""} ;
      H006K2_n225PacienteEspecifique = new boolean[] {false} ;
      H006K2_A224PacienteEnterarse = new String[] {""} ;
      H006K2_n224PacienteEnterarse = new boolean[] {false} ;
      H006K2_A223PacienteAnexos = new String[] {""} ;
      H006K2_n223PacienteAnexos = new boolean[] {false} ;
      H006K2_A222PacienteNombreAnexo = new String[] {""} ;
      H006K2_n222PacienteNombreAnexo = new boolean[] {false} ;
      H006K2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H006K2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H006K2_A44UbigeoCode = new String[] {""} ;
      H006K2_n44UbigeoCode = new boolean[] {false} ;
      H006K2_A6SecUserId = new short[1] ;
      H006K2_n6SecUserId = new boolean[] {false} ;
      H006K2_A219PacienteEstado = new String[] {""} ;
      H006K2_A184PaisDescripcion = new String[] {""} ;
      H006K2_A43PaisId = new short[1] ;
      H006K2_A218PacienteTelefono = new String[] {""} ;
      H006K2_A217PacienteCorreo = new String[] {""} ;
      H006K2_A216PacienteSexo = new String[] {""} ;
      H006K2_A215PacienteDireccion = new String[] {""} ;
      H006K2_A106PacienteNroDocumento = new String[] {""} ;
      H006K2_A214PacienteTipoDocumento = new String[] {""} ;
      H006K2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      H006K2_A20PacienteId = new int[1] ;
      H006K2_A105PacienteNombres = new String[] {""} ;
      H006K2_A104PacienteApellidoMaterno = new String[] {""} ;
      H006K2_A103PacienteApellidoPaterno = new String[] {""} ;
      H006K2_A188UbigeoDistrito = new String[] {""} ;
      H006K2_A187UbigeoProvincia = new String[] {""} ;
      H006K2_A186UbigeoDepartamento = new String[] {""} ;
      H006K3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      lblCleanfilters_Jsonclick = "" ;
      TempTags = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      gxphoneLink = "" ;
      ClassString = "" ;
      StyleString = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacienteprompt__default(),
         new Object[] {
             new Object[] {
            H006K2_A226PacienteFechaRegistro, H006K2_A225PacienteEspecifique, H006K2_n225PacienteEspecifique, H006K2_A224PacienteEnterarse, H006K2_n224PacienteEnterarse, H006K2_A223PacienteAnexos, H006K2_n223PacienteAnexos, H006K2_A222PacienteNombreAnexo, H006K2_n222PacienteNombreAnexo, H006K2_A221PacientePeso,
            H006K2_A220PacienteEstatura, H006K2_A44UbigeoCode, H006K2_n44UbigeoCode, H006K2_A6SecUserId, H006K2_n6SecUserId, H006K2_A219PacienteEstado, H006K2_A184PaisDescripcion, H006K2_A43PaisId, H006K2_A218PacienteTelefono, H006K2_A217PacienteCorreo,
            H006K2_A216PacienteSexo, H006K2_A215PacienteDireccion, H006K2_A106PacienteNroDocumento, H006K2_A214PacienteTipoDocumento, H006K2_A213PacienteFechaNacimiento, H006K2_A20PacienteId, H006K2_A105PacienteNombres, H006K2_A104PacienteApellidoMaterno, H006K2_A103PacienteApellidoPaterno, H006K2_A188UbigeoDistrito,
            H006K2_A187UbigeoProvincia, H006K2_A186UbigeoDepartamento
            }
            , new Object[] {
            H006K3_AGRID_nRecordCount
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSelect_Enabled = 0 ;
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
   private short AV11OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8InOutPacienteId ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_24 ;
   private int nGXsfl_24_idx=1 ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Pagestoshow ;
   private int AV8InOutPacienteId ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavSelect_Enabled ;
   private int A20PacienteId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV15PageToGo ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int edtavSelect_Visible ;
   private long GRID_nFirstRecordOnPage ;
   private long AV16GridCurrentPage ;
   private long AV17GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_24_idx="0001" ;
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
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String AV18Select ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private String A218PacienteTelefono ;
   private String A219PacienteEstado ;
   private String A44UbigeoCode ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSelect_Internalname ;
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
   private String tblTablefilters_Internalname ;
   private String lblCleanfilters_Internalname ;
   private String lblCleanfilters_Jsonclick ;
   private String TempTags ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_24_fel_idx="0001" ;
   private String ROClassString ;
   private String edtavSelect_Jsonclick ;
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
   private String ClassString ;
   private String StyleString ;
   private String edtPacienteAnexos_Filetype ;
   private String edtPacienteAnexos_Contenttype ;
   private String edtPacienteAnexos_Parameters ;
   private String edtPacienteAnexos_Jsonclick ;
   private String edtPacienteEspecifique_Jsonclick ;
   private String edtPacienteFechaRegistro_Jsonclick ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean AV12OrderedDsc ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n6SecUserId ;
   private boolean n44UbigeoCode ;
   private boolean n222PacienteNombreAnexo ;
   private boolean n223PacienteAnexos ;
   private boolean bGXsfl_24_Refreshing=false ;
   private boolean n224PacienteEnterarse ;
   private boolean n225PacienteEspecifique ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A225PacienteEspecifique ;
   private String A223PacienteAnexos ;
   private String wcpOAV9InOutPacienteNombres ;
   private String AV13FilterFullText ;
   private String AV9InOutPacienteNombres ;
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
   private String lV13FilterFullText ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice cmbPacienteTipoDocumento ;
   private HTMLChoice cmbPacienteSexo ;
   private HTMLChoice cmbPacienteEstado ;
   private HTMLChoice cmbPacienteEnterarse ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] H006K2_A226PacienteFechaRegistro ;
   private String[] H006K2_A225PacienteEspecifique ;
   private boolean[] H006K2_n225PacienteEspecifique ;
   private String[] H006K2_A224PacienteEnterarse ;
   private boolean[] H006K2_n224PacienteEnterarse ;
   private String[] H006K2_A223PacienteAnexos ;
   private boolean[] H006K2_n223PacienteAnexos ;
   private String[] H006K2_A222PacienteNombreAnexo ;
   private boolean[] H006K2_n222PacienteNombreAnexo ;
   private java.math.BigDecimal[] H006K2_A221PacientePeso ;
   private java.math.BigDecimal[] H006K2_A220PacienteEstatura ;
   private String[] H006K2_A44UbigeoCode ;
   private boolean[] H006K2_n44UbigeoCode ;
   private short[] H006K2_A6SecUserId ;
   private boolean[] H006K2_n6SecUserId ;
   private String[] H006K2_A219PacienteEstado ;
   private String[] H006K2_A184PaisDescripcion ;
   private short[] H006K2_A43PaisId ;
   private String[] H006K2_A218PacienteTelefono ;
   private String[] H006K2_A217PacienteCorreo ;
   private String[] H006K2_A216PacienteSexo ;
   private String[] H006K2_A215PacienteDireccion ;
   private String[] H006K2_A106PacienteNroDocumento ;
   private String[] H006K2_A214PacienteTipoDocumento ;
   private java.util.Date[] H006K2_A213PacienteFechaNacimiento ;
   private int[] H006K2_A20PacienteId ;
   private String[] H006K2_A105PacienteNombres ;
   private String[] H006K2_A104PacienteApellidoMaterno ;
   private String[] H006K2_A103PacienteApellidoPaterno ;
   private String[] H006K2_A188UbigeoDistrito ;
   private String[] H006K2_A187UbigeoProvincia ;
   private String[] H006K2_A186UbigeoDepartamento ;
   private long[] H006K3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV14DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class pacienteprompt__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H006K2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13FilterFullText ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A214PacienteTipoDocumento ,
                                          String A106PacienteNroDocumento ,
                                          String A215PacienteDireccion ,
                                          String A216PacienteSexo ,
                                          String A217PacienteCorreo ,
                                          String A218PacienteTelefono ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          String A219PacienteEstado ,
                                          short A6SecUserId ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          java.math.BigDecimal A220PacienteEstatura ,
                                          java.math.BigDecimal A221PacientePeso ,
                                          String A222PacienteNombreAnexo ,
                                          String A224PacienteEnterarse ,
                                          String A225PacienteEspecifique ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[39];
      Object[] GXv_Object5 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[PacienteFechaRegistro], T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteAnexos], T1.[PacienteNombreAnexo], T1.[PacientePeso], T1.[PacienteEstatura]," ;
      sSelectString += " T1.[UbigeoCode], T1.[SecUserId], T1.[PacienteEstado], T3.[PaisDescripcion], T1.[PaisId], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo], T1.[PacienteDireccion]," ;
      sSelectString += " T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      sSelectString += " T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento]" ;
      sFromString = " FROM (([Paciente] T1 LEFT JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais] T3 ON T3.[PaisId] = T1.[PaisId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T3.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
         GXv_int4[19] = (byte)(1) ;
         GXv_int4[20] = (byte)(1) ;
         GXv_int4[21] = (byte)(1) ;
         GXv_int4[22] = (byte)(1) ;
         GXv_int4[23] = (byte)(1) ;
         GXv_int4[24] = (byte)(1) ;
         GXv_int4[25] = (byte)(1) ;
         GXv_int4[26] = (byte)(1) ;
         GXv_int4[27] = (byte)(1) ;
         GXv_int4[28] = (byte)(1) ;
         GXv_int4[29] = (byte)(1) ;
         GXv_int4[30] = (byte)(1) ;
         GXv_int4[31] = (byte)(1) ;
         GXv_int4[32] = (byte)(1) ;
         GXv_int4[33] = (byte)(1) ;
         GXv_int4[34] = (byte)(1) ;
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteNombres]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteNombres] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaNacimiento]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaNacimiento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteTipoDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteTipoDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteNroDocumento]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteSexo]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteSexo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteCorreo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteTelefono]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteTelefono] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[PaisDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEstado]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEstado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEstatura]" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEstatura] DESC" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacientePeso]" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacientePeso] DESC" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteNombreAnexo]" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteNombreAnexo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEnterarse]" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEnterarse] DESC" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteEspecifique]" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteEspecifique] DESC" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaRegistro]" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[PacienteFechaRegistro] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[PacienteId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_H006K3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13FilterFullText ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A214PacienteTipoDocumento ,
                                          String A106PacienteNroDocumento ,
                                          String A215PacienteDireccion ,
                                          String A216PacienteSexo ,
                                          String A217PacienteCorreo ,
                                          String A218PacienteTelefono ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          String A219PacienteEstado ,
                                          short A6SecUserId ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          java.math.BigDecimal A220PacienteEstatura ,
                                          java.math.BigDecimal A221PacientePeso ,
                                          String A222PacienteNombreAnexo ,
                                          String A224PacienteEnterarse ,
                                          String A225PacienteEspecifique ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[36];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (([Paciente] T1 LEFT JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId])" ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
         GXv_int6[4] = (byte)(1) ;
         GXv_int6[5] = (byte)(1) ;
         GXv_int6[6] = (byte)(1) ;
         GXv_int6[7] = (byte)(1) ;
         GXv_int6[8] = (byte)(1) ;
         GXv_int6[9] = (byte)(1) ;
         GXv_int6[10] = (byte)(1) ;
         GXv_int6[11] = (byte)(1) ;
         GXv_int6[12] = (byte)(1) ;
         GXv_int6[13] = (byte)(1) ;
         GXv_int6[14] = (byte)(1) ;
         GXv_int6[15] = (byte)(1) ;
         GXv_int6[16] = (byte)(1) ;
         GXv_int6[17] = (byte)(1) ;
         GXv_int6[18] = (byte)(1) ;
         GXv_int6[19] = (byte)(1) ;
         GXv_int6[20] = (byte)(1) ;
         GXv_int6[21] = (byte)(1) ;
         GXv_int6[22] = (byte)(1) ;
         GXv_int6[23] = (byte)(1) ;
         GXv_int6[24] = (byte)(1) ;
         GXv_int6[25] = (byte)(1) ;
         GXv_int6[26] = (byte)(1) ;
         GXv_int6[27] = (byte)(1) ;
         GXv_int6[28] = (byte)(1) ;
         GXv_int6[29] = (byte)(1) ;
         GXv_int6[30] = (byte)(1) ;
         GXv_int6[31] = (byte)(1) ;
         GXv_int6[32] = (byte)(1) ;
         GXv_int6[33] = (byte)(1) ;
         GXv_int6[34] = (byte)(1) ;
         GXv_int6[35] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 15 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 16 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 17 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 18 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 19 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 20 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 21 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ! AV12OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV11OrderedBy == 22 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_H006K2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
            case 1 :
                  return conditional_H006K3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006K2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006K3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[75]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[76]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[77]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
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
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               return;
      }
   }

}

