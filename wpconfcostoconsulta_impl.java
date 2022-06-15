package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpconfcostoconsulta_impl extends GXDataArea
{
   public wpconfcostoconsulta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpconfcostoconsulta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpconfcostoconsulta_impl.class ));
   }

   public wpconfcostoconsulta_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavEspecialidadid = new HTMLChoice();
      dynavSedeid = new HTMLChoice();
      dynavSedetipoconsulta = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vESPECIALIDADID") == 0 )
         {
            AV14ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ProfesionalId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvespecialidadid6E2( AV14ProfesionalId) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vSEDEID") == 0 )
         {
            AV9EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EspecialidadId), 4, 0));
            AV14ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ProfesionalId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvsedeid6E2( AV9EspecialidadId, AV14ProfesionalId) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vSEDETIPOCONSULTA") == 0 )
         {
            AV14ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ProfesionalId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
            AV9EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EspecialidadId), 4, 0));
            AV16SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16SedeId), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvsedetipoconsulta6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
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
      pa6E2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6E2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034335", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpconfcostoconsulta", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SEDETIPOCONSULTA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A54SedeTipoConsulta, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISEXIST", AV21isExist);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDETIPOCONSULTA", GXutil.rtrim( A54SedeTipoConsulta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SEDETIPOCONSULTA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A54SedeTipoConsulta, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV14ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Width", GXutil.rtrim( Dvpanel_actualizacioncostos_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Autowidth", GXutil.booltostr( Dvpanel_actualizacioncostos_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Autoheight", GXutil.booltostr( Dvpanel_actualizacioncostos_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Cls", GXutil.rtrim( Dvpanel_actualizacioncostos_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Title", GXutil.rtrim( Dvpanel_actualizacioncostos_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Collapsible", GXutil.booltostr( Dvpanel_actualizacioncostos_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Collapsed", GXutil.booltostr( Dvpanel_actualizacioncostos_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Showcollapseicon", GXutil.booltostr( Dvpanel_actualizacioncostos_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Iconposition", GXutil.rtrim( Dvpanel_actualizacioncostos_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ACTUALIZACIONCOSTOS_Autoscroll", GXutil.booltostr( Dvpanel_actualizacioncostos_Autoscroll));
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
         we6E2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6E2( ) ;
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
      return formatLink("com.projectthani.wpconfcostoconsulta", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPConfCostoConsulta" ;
   }

   public String getPgmdesc( )
   {
      return "Configuración de Costo" ;
   }

   public void wb6E0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_actualizacioncostos.setProperty("Width", Dvpanel_actualizacioncostos_Width);
         ucDvpanel_actualizacioncostos.setProperty("AutoWidth", Dvpanel_actualizacioncostos_Autowidth);
         ucDvpanel_actualizacioncostos.setProperty("AutoHeight", Dvpanel_actualizacioncostos_Autoheight);
         ucDvpanel_actualizacioncostos.setProperty("Cls", Dvpanel_actualizacioncostos_Cls);
         ucDvpanel_actualizacioncostos.setProperty("Title", Dvpanel_actualizacioncostos_Title);
         ucDvpanel_actualizacioncostos.setProperty("Collapsible", Dvpanel_actualizacioncostos_Collapsible);
         ucDvpanel_actualizacioncostos.setProperty("Collapsed", Dvpanel_actualizacioncostos_Collapsed);
         ucDvpanel_actualizacioncostos.setProperty("ShowCollapseIcon", Dvpanel_actualizacioncostos_Showcollapseicon);
         ucDvpanel_actualizacioncostos.setProperty("IconPosition", Dvpanel_actualizacioncostos_Iconposition);
         ucDvpanel_actualizacioncostos.setProperty("AutoScroll", Dvpanel_actualizacioncostos_Autoscroll);
         ucDvpanel_actualizacioncostos.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_actualizacioncostos_Internalname, "DVPANEL_ACTUALIZACIONCOSTOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_ACTUALIZACIONCOSTOSContainer"+"ActualizacionCostos"+"\" style=\"display:none;\">") ;
         wb_table1_17_6E2( true) ;
      }
      else
      {
         wb_table1_17_6E2( false) ;
      }
      return  ;
   }

   public void wb_table1_17_6E2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6E2( )
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
         Form.getMeta().addItem("description", "Configuración de Costo", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6E0( ) ;
   }

   public void ws6E2( )
   {
      start6E2( ) ;
      evt6E2( ) ;
   }

   public void evt6E2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e116E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGUARDAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGuardar' */
                           e126E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VSEDETIPOCONSULTA.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e136E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e146E2 ();
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
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we6E2( )
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

   public void pa6E2( )
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
            GX_FocusControl = dynavEspecialidadid.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvsedeid_html6E2( AV9EspecialidadId, AV14ProfesionalId) ;
      gxvvsedetipoconsulta_html6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
      /* End function dynload_actions */
   }

   public void gxdsvvespecialidadid6E2( int AV14ProfesionalId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvespecialidadid_data6E2( AV14ProfesionalId) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvespecialidadid_html6E2( int AV14ProfesionalId )
   {
      short gxdynajaxvalue;
      gxdsvvespecialidadid_data6E2( AV14ProfesionalId) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEspecialidadid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavEspecialidadid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvespecialidadid_data6E2( int AV14ProfesionalId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione Especialidad");
      com.projectthani.SdtSDTEspecialidad gxcolitemvESPECIALIDADID;
      GXv_objcol_SdtSDTEspecialidad1[0] = gxcolvESPECIALIDADID ;
      new com.projectthani.dpespecialidaddisponibilidad(remoteHandle, context).execute( AV14ProfesionalId, GXv_objcol_SdtSDTEspecialidad1) ;
      wpconfcostoconsulta_impl.this.gxcolvESPECIALIDADID = GXv_objcol_SdtSDTEspecialidad1[0] ;
      gxcolvESPECIALIDADID.sort("Especialidadnombre");
      int gxindex = 1;
      while ( gxindex <= gxcolvESPECIALIDADID.size() )
      {
         gxcolitemvESPECIALIDADID = ((com.projectthani.SdtSDTEspecialidad)gxcolvESPECIALIDADID.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(GXutil.ltrimstr( gxcolitemvESPECIALIDADID.getgxTv_SdtSDTEspecialidad_Especialidadid(), 4, 0));
         gxdynajaxctrldescr.add(gxcolitemvESPECIALIDADID.getgxTv_SdtSDTEspecialidad_Especialidadnombre());
         gxindex = (int)(gxindex+1) ;
      }
   }

   public void gxdsvvsedeid6E2( short AV9EspecialidadId ,
                                int AV14ProfesionalId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvsedeid_data6E2( AV9EspecialidadId, AV14ProfesionalId) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvsedeid_html6E2( short AV9EspecialidadId ,
                                   int AV14ProfesionalId )
   {
      short gxdynajaxvalue;
      gxdsvvsedeid_data6E2( AV9EspecialidadId, AV14ProfesionalId) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavSedeid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavSedeid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvsedeid_data6E2( short AV9EspecialidadId ,
                                        int AV14ProfesionalId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione Sede");
      com.projectthani.SdtSDTSede gxcolitemvSEDEID;
      GXv_objcol_SdtSDTSede2[0] = gxcolvSEDEID ;
      new com.projectthani.dpsededisponibilidad(remoteHandle, context).execute( AV9EspecialidadId, AV14ProfesionalId, GXv_objcol_SdtSDTSede2) ;
      wpconfcostoconsulta_impl.this.gxcolvSEDEID = GXv_objcol_SdtSDTSede2[0] ;
      gxcolvSEDEID.sort("Sedefullname");
      int gxindex = 1;
      while ( gxindex <= gxcolvSEDEID.size() )
      {
         gxcolitemvSEDEID = ((com.projectthani.SdtSDTSede)gxcolvSEDEID.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(GXutil.ltrimstr( gxcolitemvSEDEID.getgxTv_SdtSDTSede_Sgespecialidadsedeid(), 4, 0));
         gxdynajaxctrldescr.add(gxcolitemvSEDEID.getgxTv_SdtSDTSede_Sedefullname());
         gxindex = (int)(gxindex+1) ;
      }
   }

   public void gxdsvvsedetipoconsulta6E2( int AV14ProfesionalId ,
                                          short AV9EspecialidadId ,
                                          short AV16SedeId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvsedetipoconsulta_data6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvsedetipoconsulta_html6E2( int AV14ProfesionalId ,
                                             short AV9EspecialidadId ,
                                             short AV16SedeId )
   {
      String gxdynajaxvalue;
      gxdsvvsedetipoconsulta_data6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavSedetipoconsulta.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavSedetipoconsulta.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvsedetipoconsulta_data6E2( int AV14ProfesionalId ,
                                                  short AV9EspecialidadId ,
                                                  short AV16SedeId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione tipo consulta");
      com.projectthani.SdtSDTTipoConsulta gxcolitemvSEDETIPOCONSULTA;
      GXv_objcol_SdtSDTTipoConsulta3[0] = gxcolvSEDETIPOCONSULTA ;
      new com.projectthani.dpgettiposconsulta(remoteHandle, context).execute( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId, GXv_objcol_SdtSDTTipoConsulta3) ;
      wpconfcostoconsulta_impl.this.gxcolvSEDETIPOCONSULTA = GXv_objcol_SdtSDTTipoConsulta3[0] ;
      gxcolvSEDETIPOCONSULTA.sort("Sedetipoconsultadescripcion");
      int gxindex = 1;
      while ( gxindex <= gxcolvSEDETIPOCONSULTA.size() )
      {
         gxcolitemvSEDETIPOCONSULTA = ((com.projectthani.SdtSDTTipoConsulta)gxcolvSEDETIPOCONSULTA.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(gxcolitemvSEDETIPOCONSULTA.getgxTv_SdtSDTTipoConsulta_Sedetipoconsulta());
         gxdynajaxctrldescr.add(gxcolitemvSEDETIPOCONSULTA.getgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion());
         gxindex = (int)(gxindex+1) ;
      }
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
      if ( dynavEspecialidadid.getItemCount() > 0 )
      {
         AV9EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValidValue(GXutil.trim( GXutil.str( AV9EspecialidadId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EspecialidadId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEspecialidadid.setValue( GXutil.trim( GXutil.str( AV9EspecialidadId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadid.getInternalname(), "Values", dynavEspecialidadid.ToJavascriptSource(), true);
      }
      if ( dynavSedeid.getItemCount() > 0 )
      {
         AV16SedeId = (short)(GXutil.lval( dynavSedeid.getValidValue(GXutil.trim( GXutil.str( AV16SedeId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16SedeId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV16SedeId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
      }
      if ( dynavSedetipoconsulta.getItemCount() > 0 )
      {
         AV19SedeTipoConsulta = dynavSedetipoconsulta.getValidValue(AV19SedeTipoConsulta) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19SedeTipoConsulta", AV19SedeTipoConsulta);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedetipoconsulta.setValue( GXutil.rtrim( AV19SedeTipoConsulta) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSedetipoconsulta.getInternalname(), "Values", dynavSedetipoconsulta.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6E2( ) ;
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
   }

   public void rf6E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H006E2 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A54SedeTipoConsulta = H006E2_A54SedeTipoConsulta[0] ;
            gxvvespecialidadid_html6E2( AV14ProfesionalId) ;
            gxvvsedeid_html6E2( AV9EspecialidadId, AV14ProfesionalId) ;
            gxvvsedetipoconsulta_html6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
            /* Execute user event: Load */
            e146E2 ();
            pr_default.readNext(0);
         }
         pr_default.close(0);
         wb6E0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6E2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV14ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDETIPOCONSULTA", GXutil.rtrim( A54SedeTipoConsulta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_SEDETIPOCONSULTA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A54SedeTipoConsulta, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e116E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvespecialidadid_html6E2( AV14ProfesionalId) ;
      gxvvsedeid_html6E2( AV9EspecialidadId, AV14ProfesionalId) ;
      gxvvsedetipoconsulta_html6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Dvpanel_actualizacioncostos_Width = httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Width") ;
         Dvpanel_actualizacioncostos_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Autowidth")) ;
         Dvpanel_actualizacioncostos_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Autoheight")) ;
         Dvpanel_actualizacioncostos_Cls = httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Cls") ;
         Dvpanel_actualizacioncostos_Title = httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Title") ;
         Dvpanel_actualizacioncostos_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Collapsible")) ;
         Dvpanel_actualizacioncostos_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Collapsed")) ;
         Dvpanel_actualizacioncostos_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Showcollapseicon")) ;
         Dvpanel_actualizacioncostos_Iconposition = httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Iconposition") ;
         Dvpanel_actualizacioncostos_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ACTUALIZACIONCOSTOS_Autoscroll")) ;
         /* Read variables values. */
         dynavEspecialidadid.setValue( httpContext.cgiGet( dynavEspecialidadid.getInternalname()) );
         AV9EspecialidadId = (short)(GXutil.lval( httpContext.cgiGet( dynavEspecialidadid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EspecialidadId), 4, 0));
         dynavSedeid.setValue( httpContext.cgiGet( dynavSedeid.getInternalname()) );
         AV16SedeId = (short)(GXutil.lval( httpContext.cgiGet( dynavSedeid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16SedeId), 4, 0));
         dynavSedetipoconsulta.setValue( httpContext.cgiGet( dynavSedetipoconsulta.getInternalname()) );
         AV19SedeTipoConsulta = httpContext.cgiGet( dynavSedetipoconsulta.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19SedeTipoConsulta", AV19SedeTipoConsulta);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavCostoconsulta_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavCostoconsulta_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCOSTOCONSULTA");
            GX_FocusControl = edtavCostoconsulta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV6CostoConsulta = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CostoConsulta", GXutil.ltrimstr( AV6CostoConsulta, 6, 2));
         }
         else
         {
            AV6CostoConsulta = localUtil.ctond( httpContext.cgiGet( edtavCostoconsulta_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CostoConsulta", GXutil.ltrimstr( AV6CostoConsulta, 6, 2));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvespecialidadid_html6E2( AV14ProfesionalId) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e116E2 ();
      if (returnInSub) return;
   }

   public void e116E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext4[0] = AV20WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext4) ;
      AV20WWPContext = GXv_SdtWWPContext4[0] ;
      GXt_int5 = AV14ProfesionalId ;
      GXv_int6[0] = GXt_int5 ;
      new com.projectthani.prcgetprofesionalidbynrodocumento(remoteHandle, context).execute( AV20WWPContext.getgxTv_SdtWWPContext_Username(), GXv_int6) ;
      wpconfcostoconsulta_impl.this.GXt_int5 = GXv_int6[0] ;
      AV14ProfesionalId = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ProfesionalId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProfesionalId), "ZZZZZZZ9")));
      edtavCostoconsulta_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCostoconsulta_Visible), 5, 0), true);
      lblTextblockcostoconsulta_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockcostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockcostoconsulta_Visible), 5, 0), true);
   }

   public void e126E2( )
   {
      /* 'DoGuardar' Routine */
      returnInSub = false ;
      AV13isValidated = true ;
      /* Execute user subroutine: 'VALIDARCOSTOCONSULTA' */
      S112 ();
      if (returnInSub) return;
      if ( AV21isExist && ! (0==AV9EspecialidadId) && ! (0==AV16SedeId) && ! (0==AV14ProfesionalId) && ! (GXutil.strcmp("", A54SedeTipoConsulta)==0) && AV13isValidated )
      {
         GXv_char7[0] = AV8ErrorMessage ;
         new com.projectthani.prcupdatecostoconsulta(remoteHandle, context).execute( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId, AV19SedeTipoConsulta, AV6CostoConsulta, GXv_char7) ;
         wpconfcostoconsulta_impl.this.AV8ErrorMessage = GXv_char7[0] ;
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", AV8ErrorMessage, "success", "", "true"));
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Información", "Por favor llene todos los campos", "notice", "", "true"));
      }
   }

   public void e136E2( )
   {
      /* Sedetipoconsulta_Controlvaluechanged Routine */
      returnInSub = false ;
      if ( ! (0==AV16SedeId) && ! (0==AV9EspecialidadId) && ! (GXutil.strcmp("", AV19SedeTipoConsulta)==0) )
      {
         GXv_decimal8[0] = AV6CostoConsulta ;
         GXv_boolean9[0] = AV21isExist ;
         new com.projectthani.prcgetcostoconsulta(remoteHandle, context).execute( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId, AV19SedeTipoConsulta, GXv_decimal8, GXv_boolean9) ;
         wpconfcostoconsulta_impl.this.AV6CostoConsulta = GXv_decimal8[0] ;
         wpconfcostoconsulta_impl.this.AV21isExist = GXv_boolean9[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6CostoConsulta", GXutil.ltrimstr( AV6CostoConsulta, 6, 2));
         httpContext.ajax_rsp_assign_attri("", false, "AV21isExist", AV21isExist);
         if ( ! AV21isExist )
         {
            httpContext.GX_msglist.addItem("No se encontró una configuración con el tipo de consulta seleccionado");
            AV6CostoConsulta = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CostoConsulta", GXutil.ltrimstr( AV6CostoConsulta, 6, 2));
            edtavCostoconsulta_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavCostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCostoconsulta_Visible), 5, 0), true);
            lblTextblockcostoconsulta_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, lblTextblockcostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockcostoconsulta_Visible), 5, 0), true);
         }
         else
         {
            edtavCostoconsulta_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavCostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCostoconsulta_Visible), 5, 0), true);
            lblTextblockcostoconsulta_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, lblTextblockcostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockcostoconsulta_Visible), 5, 0), true);
         }
      }
      else
      {
         edtavCostoconsulta_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCostoconsulta_Visible), 5, 0), true);
         lblTextblockcostoconsulta_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockcostoconsulta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockcostoconsulta_Visible), 5, 0), true);
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'VALIDARCOSTOCONSULTA' Routine */
      returnInSub = false ;
      if ( AV6CostoConsulta.doubleValue() < 0 )
      {
         httpContext.GX_msglist.addItem("El costo de consulta no puede ser menor a 0.");
         AV13isValidated = false ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e146E2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_17_6E2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblActualizacioncostos_Internalname, tblActualizacioncostos_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb10 DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableespecialidadid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockespecialidadid_Internalname, "Especialidad", "", "", lblTextblockespecialidadid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavEspecialidadid.getInternalname(), "Especialidad Id", "col-sm-3 mb15Label mt10Label", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEspecialidadid, dynavEspecialidadid.getInternalname(), GXutil.trim( GXutil.str( AV9EspecialidadId, 4, 0)), 1, dynavEspecialidadid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEspecialidadid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "mb15 mt10", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "", true, (byte)(1), "HLP_WPConfCostoConsulta.htm");
         dynavEspecialidadid.setValue( GXutil.trim( GXutil.str( AV9EspecialidadId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadid.getInternalname(), "Values", dynavEspecialidadid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb15 DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesedeid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksedeid_Internalname, "Sede", "", "", lblTextblocksedeid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavSedeid.getInternalname(), "Sede Id", "col-sm-3 mb15Label", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavSedeid, dynavSedeid.getInternalname(), GXutil.trim( GXutil.str( AV16SedeId, 4, 0)), 1, dynavSedeid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavSedeid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "mb15", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "", true, (byte)(1), "HLP_WPConfCostoConsulta.htm");
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV16SedeId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesedetipoconsulta_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksedetipoconsulta_Internalname, "Sede Tipo Consulta", "", "", lblTextblocksedetipoconsulta_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavSedetipoconsulta.getInternalname(), "Sede Tipo Consulta", "col-sm-3 mb15Label", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavSedetipoconsulta, dynavSedetipoconsulta.getInternalname(), GXutil.rtrim( AV19SedeTipoConsulta), 1, dynavSedetipoconsulta.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavSedetipoconsulta.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "mb15", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(1), "HLP_WPConfCostoConsulta.htm");
         dynavSedetipoconsulta.setValue( GXutil.rtrim( AV19SedeTipoConsulta) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSedetipoconsulta.getInternalname(), "Values", dynavSedetipoconsulta.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb15 DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablecostoconsulta_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcostoconsulta_Internalname, "Costo Consulta", "", "", lblTextblockcostoconsulta_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", lblTextblockcostoconsulta_Visible, 1, 0, (short)(0), "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavCostoconsulta_Internalname, "Costo Consulta", "col-sm-3 mb15Label", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCostoconsulta_Internalname, GXutil.ltrim( localUtil.ntoc( AV6CostoConsulta, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtavCostoconsulta_Enabled!=0) ? localUtil.format( AV6CostoConsulta, "ZZ9.99") : localUtil.format( AV6CostoConsulta, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCostoconsulta_Jsonclick, 0, "mb15", "", "", "", "", edtavCostoconsulta_Visible, edtavCostoconsulta_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='mb15'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "mb15", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnguardar_Internalname, "", "Actualizar", bttBtnguardar_Jsonclick, 5, "Actualizar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGUARDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Right", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "", "Cancelar", bttBtncancelar_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e156e1_client"+"'", TempTags, "", 2, "HLP_WPConfCostoConsulta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_17_6E2e( true) ;
      }
      else
      {
         wb_table1_17_6E2e( false) ;
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
      pa6E2( ) ;
      ws6E2( ) ;
      we6E2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034383", true, true);
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
      httpContext.AddJavascriptSource("wpconfcostoconsulta.js", "?2022511034383", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockespecialidadid_Internalname = "TEXTBLOCKESPECIALIDADID" ;
      dynavEspecialidadid.setInternalname( "vESPECIALIDADID" );
      divUnnamedtableespecialidadid_Internalname = "UNNAMEDTABLEESPECIALIDADID" ;
      lblTextblocksedeid_Internalname = "TEXTBLOCKSEDEID" ;
      dynavSedeid.setInternalname( "vSEDEID" );
      divUnnamedtablesedeid_Internalname = "UNNAMEDTABLESEDEID" ;
      lblTextblocksedetipoconsulta_Internalname = "TEXTBLOCKSEDETIPOCONSULTA" ;
      dynavSedetipoconsulta.setInternalname( "vSEDETIPOCONSULTA" );
      divUnnamedtablesedetipoconsulta_Internalname = "UNNAMEDTABLESEDETIPOCONSULTA" ;
      lblTextblockcostoconsulta_Internalname = "TEXTBLOCKCOSTOCONSULTA" ;
      edtavCostoconsulta_Internalname = "vCOSTOCONSULTA" ;
      divUnnamedtablecostoconsulta_Internalname = "UNNAMEDTABLECOSTOCONSULTA" ;
      bttBtnguardar_Internalname = "BTNGUARDAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      tblActualizacioncostos_Internalname = "ACTUALIZACIONCOSTOS" ;
      Dvpanel_actualizacioncostos_Internalname = "DVPANEL_ACTUALIZACIONCOSTOS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      edtavCostoconsulta_Jsonclick = "" ;
      edtavCostoconsulta_Enabled = 1 ;
      lblTextblockcostoconsulta_Visible = 1 ;
      dynavSedetipoconsulta.setJsonclick( "" );
      dynavSedetipoconsulta.setEnabled( 1 );
      dynavSedeid.setJsonclick( "" );
      dynavSedeid.setEnabled( 1 );
      dynavEspecialidadid.setJsonclick( "" );
      dynavEspecialidadid.setEnabled( 1 );
      edtavCostoconsulta_Visible = 1 ;
      Dvpanel_actualizacioncostos_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_actualizacioncostos_Iconposition = "Right" ;
      Dvpanel_actualizacioncostos_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_actualizacioncostos_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_actualizacioncostos_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_actualizacioncostos_Title = "Actualización de costo de consultas" ;
      Dvpanel_actualizacioncostos_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_actualizacioncostos_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_actualizacioncostos_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_actualizacioncostos_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Configuración de Costo" );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavEspecialidadid.setName( "vESPECIALIDADID" );
      dynavEspecialidadid.setWebtags( "" );
      dynavSedeid.setName( "vSEDEID" );
      dynavSedeid.setWebtags( "" );
      dynavSedetipoconsulta.setName( "vSEDETIPOCONSULTA" );
      dynavSedetipoconsulta.setWebtags( "" );
      /* End function init_web_controls */
   }

   public void validv_Especialidadid( )
   {
      AV9EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValue())) ;
      AV16SedeId = (short)(GXutil.lval( dynavSedeid.getValue())) ;
      AV19SedeTipoConsulta = dynavSedetipoconsulta.getValue() ;
      gxvvsedeid_html6E2( AV9EspecialidadId, AV14ProfesionalId) ;
      gxvvsedetipoconsulta_html6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
      dynload_actions( ) ;
      if ( dynavSedeid.getItemCount() > 0 )
      {
         AV16SedeId = (short)(GXutil.lval( dynavSedeid.getValidValue(GXutil.trim( GXutil.str( AV16SedeId, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV16SedeId, 4, 0)) );
      }
      if ( dynavSedetipoconsulta.getItemCount() > 0 )
      {
         AV19SedeTipoConsulta = dynavSedetipoconsulta.getValidValue(AV19SedeTipoConsulta) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedetipoconsulta.setValue( GXutil.rtrim( AV19SedeTipoConsulta) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV16SedeId", GXutil.ltrim( localUtil.ntoc( AV16SedeId, (byte)(4), (byte)(0), ".", "")));
      dynavSedeid.setValue( GXutil.trim( GXutil.str( AV16SedeId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV19SedeTipoConsulta", GXutil.rtrim( AV19SedeTipoConsulta));
      dynavSedetipoconsulta.setValue( GXutil.rtrim( AV19SedeTipoConsulta) );
      httpContext.ajax_rsp_assign_prop("", false, dynavSedetipoconsulta.getInternalname(), "Values", dynavSedetipoconsulta.ToJavascriptSource(), true);
   }

   public void validv_Sedeid( )
   {
      AV9EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValue())) ;
      AV16SedeId = (short)(GXutil.lval( dynavSedeid.getValue())) ;
      AV19SedeTipoConsulta = dynavSedetipoconsulta.getValue() ;
      gxvvsedetipoconsulta_html6E2( AV14ProfesionalId, AV9EspecialidadId, AV16SedeId) ;
      dynload_actions( ) ;
      if ( dynavSedetipoconsulta.getItemCount() > 0 )
      {
         AV19SedeTipoConsulta = dynavSedetipoconsulta.getValidValue(AV19SedeTipoConsulta) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedetipoconsulta.setValue( GXutil.rtrim( AV19SedeTipoConsulta) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV19SedeTipoConsulta", GXutil.rtrim( AV19SedeTipoConsulta));
      dynavSedetipoconsulta.setValue( GXutil.rtrim( AV19SedeTipoConsulta) );
      httpContext.ajax_rsp_assign_prop("", false, dynavSedetipoconsulta.getInternalname(), "Values", dynavSedetipoconsulta.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV14ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'A54SedeTipoConsulta',fld:'SEDETIPOCONSULTA',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOGUARDAR'","{handler:'e126E2',iparms:[{av:'AV21isExist',fld:'vISEXIST',pic:''},{av:'dynavEspecialidadid'},{av:'AV9EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV16SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'AV14ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'A54SedeTipoConsulta',fld:'SEDETIPOCONSULTA',pic:'',hsh:true},{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''},{av:'AV6CostoConsulta',fld:'vCOSTOCONSULTA',pic:'ZZ9.99'}]");
      setEventMetadata("'DOGUARDAR'",",oparms:[]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e156E1',iparms:[]");
      setEventMetadata("'DOCANCELAR'",",oparms:[{av:'dynavEspecialidadid'},{av:'AV9EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV16SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'AV6CostoConsulta',fld:'vCOSTOCONSULTA',pic:'ZZ9.99'},{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''},{av:'edtavCostoconsulta_Visible',ctrl:'vCOSTOCONSULTA',prop:'Visible'},{av:'lblTextblockcostoconsulta_Visible',ctrl:'TEXTBLOCKCOSTOCONSULTA',prop:'Visible'}]}");
      setEventMetadata("VSEDETIPOCONSULTA.CONTROLVALUECHANGED","{handler:'e136E2',iparms:[{av:'dynavSedeid'},{av:'AV16SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavEspecialidadid'},{av:'AV9EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''},{av:'AV14ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("VSEDETIPOCONSULTA.CONTROLVALUECHANGED",",oparms:[{av:'AV21isExist',fld:'vISEXIST',pic:''},{av:'AV6CostoConsulta',fld:'vCOSTOCONSULTA',pic:'ZZ9.99'},{av:'edtavCostoconsulta_Visible',ctrl:'vCOSTOCONSULTA',prop:'Visible'},{av:'lblTextblockcostoconsulta_Visible',ctrl:'TEXTBLOCKCOSTOCONSULTA',prop:'Visible'}]}");
      setEventMetadata("VALIDV_ESPECIALIDADID","{handler:'validv_Especialidadid',iparms:[{av:'AV14ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'dynavEspecialidadid'},{av:'AV9EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV16SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''}]");
      setEventMetadata("VALIDV_ESPECIALIDADID",",oparms:[{av:'dynavSedeid'},{av:'AV16SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''}]}");
      setEventMetadata("VALIDV_SEDEID","{handler:'validv_Sedeid',iparms:[{av:'AV14ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'dynavEspecialidadid'},{av:'AV9EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV16SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''}]");
      setEventMetadata("VALIDV_SEDEID",",oparms:[{av:'dynavSedetipoconsulta'},{av:'AV19SedeTipoConsulta',fld:'vSEDETIPOCONSULTA',pic:''}]}");
      setEventMetadata("VALIDV_SEDETIPOCONSULTA","{handler:'validv_Sedetipoconsulta',iparms:[]");
      setEventMetadata("VALIDV_SEDETIPOCONSULTA",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      A54SedeTipoConsulta = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_actualizacioncostos = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      gxcolvESPECIALIDADID = new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>(com.projectthani.SdtSDTEspecialidad.class, "SDTEspecialidad", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTEspecialidad1 = new GXBaseCollection[1] ;
      gxcolvSEDEID = new GXBaseCollection<com.projectthani.SdtSDTSede>(com.projectthani.SdtSDTSede.class, "SDTSede", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTSede2 = new GXBaseCollection[1] ;
      AV19SedeTipoConsulta = "" ;
      gxcolvSEDETIPOCONSULTA = new GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>(com.projectthani.SdtSDTTipoConsulta.class, "SDTTipoConsulta", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTTipoConsulta3 = new GXBaseCollection[1] ;
      scmdbuf = "" ;
      H006E2_A31ProfesionalId = new int[1] ;
      H006E2_A32EspecialidadId = new short[1] ;
      H006E2_A30SedeId = new short[1] ;
      H006E2_A54SedeTipoConsulta = new String[] {""} ;
      AV6CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      AV20WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext4 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_int6 = new int[1] ;
      AV8ErrorMessage = "" ;
      GXv_char7 = new String[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean9 = new boolean[1] ;
      sStyleString = "" ;
      lblTextblockespecialidadid_Jsonclick = "" ;
      TempTags = "" ;
      lblTextblocksedeid_Jsonclick = "" ;
      lblTextblocksedetipoconsulta_Jsonclick = "" ;
      lblTextblockcostoconsulta_Jsonclick = "" ;
      bttBtnguardar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ZV19SedeTipoConsulta = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpconfcostoconsulta__default(),
         new Object[] {
             new Object[] {
            H006E2_A31ProfesionalId, H006E2_A32EspecialidadId, H006E2_A30SedeId, H006E2_A54SedeTipoConsulta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short AV9EspecialidadId ;
   private short AV16SedeId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short ZV16SedeId ;
   private int AV14ProfesionalId ;
   private int gxdynajaxindex ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private int edtavCostoconsulta_Visible ;
   private int lblTextblockcostoconsulta_Visible ;
   private int edtavCostoconsulta_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal AV6CostoConsulta ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String A54SedeTipoConsulta ;
   private String GXKey ;
   private String Dvpanel_actualizacioncostos_Width ;
   private String Dvpanel_actualizacioncostos_Cls ;
   private String Dvpanel_actualizacioncostos_Title ;
   private String Dvpanel_actualizacioncostos_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_actualizacioncostos_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String AV19SedeTipoConsulta ;
   private String scmdbuf ;
   private String edtavCostoconsulta_Internalname ;
   private String lblTextblockcostoconsulta_Internalname ;
   private String GXv_char7[] ;
   private String sStyleString ;
   private String tblActualizacioncostos_Internalname ;
   private String divUnnamedtableespecialidadid_Internalname ;
   private String lblTextblockespecialidadid_Internalname ;
   private String lblTextblockespecialidadid_Jsonclick ;
   private String TempTags ;
   private String divUnnamedtablesedeid_Internalname ;
   private String lblTextblocksedeid_Internalname ;
   private String lblTextblocksedeid_Jsonclick ;
   private String divUnnamedtablesedetipoconsulta_Internalname ;
   private String lblTextblocksedetipoconsulta_Internalname ;
   private String lblTextblocksedetipoconsulta_Jsonclick ;
   private String divUnnamedtablecostoconsulta_Internalname ;
   private String lblTextblockcostoconsulta_Jsonclick ;
   private String edtavCostoconsulta_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String bttBtnguardar_Internalname ;
   private String bttBtnguardar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String ZV19SedeTipoConsulta ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV21isExist ;
   private boolean Dvpanel_actualizacioncostos_Autowidth ;
   private boolean Dvpanel_actualizacioncostos_Autoheight ;
   private boolean Dvpanel_actualizacioncostos_Collapsible ;
   private boolean Dvpanel_actualizacioncostos_Collapsed ;
   private boolean Dvpanel_actualizacioncostos_Showcollapseicon ;
   private boolean Dvpanel_actualizacioncostos_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV13isValidated ;
   private boolean GXv_boolean9[] ;
   private String AV8ErrorMessage ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_actualizacioncostos ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> gxcolvESPECIALIDADID ;
   private GXBaseCollection<com.projectthani.SdtSDTSede> gxcolvSEDEID ;
   private GXBaseCollection<com.projectthani.SdtSDTTipoConsulta> gxcolvSEDETIPOCONSULTA ;
   private HTMLChoice dynavEspecialidadid ;
   private HTMLChoice dynavSedeid ;
   private HTMLChoice dynavSedetipoconsulta ;
   private IDataStoreProvider pr_default ;
   private int[] H006E2_A31ProfesionalId ;
   private short[] H006E2_A32EspecialidadId ;
   private short[] H006E2_A30SedeId ;
   private String[] H006E2_A54SedeTipoConsulta ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> GXv_objcol_SdtSDTEspecialidad1[] ;
   private GXBaseCollection<com.projectthani.SdtSDTSede> GXv_objcol_SdtSDTSede2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTTipoConsulta> GXv_objcol_SdtSDTTipoConsulta3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV20WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext4[] ;
}

final  class wpconfcostoconsulta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006E2", "SELECT [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] ORDER BY [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

