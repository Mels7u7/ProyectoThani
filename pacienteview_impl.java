package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacienteview_impl extends GXDataArea
{
   public pacienteview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pacienteview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacienteview_impl.class ));
   }

   public pacienteview_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "PacienteId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "PacienteId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "PacienteId") ;
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
            AV10PacienteId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10PacienteId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PacienteId), "ZZZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV8TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      pa1E2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1E2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331352", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"PacienteId","TabCode"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEID", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV10PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV11LoadAllTabs);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV12SelectedTabCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV8TabCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Width", GXutil.rtrim( Panel_general_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Autowidth", GXutil.booltostr( Panel_general_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Autoheight", GXutil.booltostr( Panel_general_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Cls", GXutil.rtrim( Panel_general_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Title", GXutil.rtrim( Panel_general_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Collapsible", GXutil.booltostr( Panel_general_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Collapsed", GXutil.booltostr( Panel_general_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Showcollapseicon", GXutil.booltostr( Panel_general_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Iconposition", GXutil.rtrim( Panel_general_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PANEL_GENERAL_Autoscroll", GXutil.booltostr( Panel_general_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABS_Class", GXutil.rtrim( Tabs_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABS_Historymanagement", GXutil.booltostr( Tabs_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
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
      if ( ! ( WebComp_Webcomponent_general == null ) )
      {
         WebComp_Webcomponent_general.componentjscripts();
      }
      if ( ! ( WebComp_Citawc == null ) )
      {
         WebComp_Citawc.componentjscripts();
      }
      if ( ! ( WebComp_Reclamowc == null ) )
      {
         WebComp_Reclamowc.componentjscripts();
      }
      if ( ! ( WebComp_Pacientefamiliarwc == null ) )
      {
         WebComp_Pacientefamiliarwc.componentjscripts();
      }
      if ( ! ( WebComp_Pacientefamiliar1wc == null ) )
      {
         WebComp_Pacientefamiliar1wc.componentjscripts();
      }
      if ( ! ( WebComp_Ratingprofesionalwc == null ) )
      {
         WebComp_Ratingprofesionalwc.componentjscripts();
      }
      if ( ! ( WebComp_Comentarioprofesionalwc == null ) )
      {
         WebComp_Comentarioprofesionalwc.componentjscripts();
      }
      if ( ! ( WebComp_Sugerenciasmejorasplataformawc == null ) )
      {
         WebComp_Sugerenciasmejorasplataformawc.componentjscripts();
      }
      if ( ! ( WebComp_Ratingplataformawc == null ) )
      {
         WebComp_Ratingplataformawc.componentjscripts();
      }
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we1E2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1E2( ) ;
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
      return formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"PacienteId","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "PacienteView" ;
   }

   public String getPgmdesc( )
   {
      return "Paciente View" ;
   }

   public void wb1E0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellWWLink", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableviewrightitems_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ViewCellRightItem", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblWorkwithlink_Internalname, "Ir a Paciente", lblWorkwithlink_Link, "", lblWorkwithlink_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockLink", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divPacientegeneral_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucPanel_general.setProperty("Width", Panel_general_Width);
         ucPanel_general.setProperty("AutoWidth", Panel_general_Autowidth);
         ucPanel_general.setProperty("AutoHeight", Panel_general_Autoheight);
         ucPanel_general.setProperty("Cls", Panel_general_Cls);
         ucPanel_general.setProperty("Title", Panel_general_Title);
         ucPanel_general.setProperty("Collapsible", Panel_general_Collapsible);
         ucPanel_general.setProperty("Collapsed", Panel_general_Collapsed);
         ucPanel_general.setProperty("ShowCollapseIcon", Panel_general_Showcollapseicon);
         ucPanel_general.setProperty("IconPosition", Panel_general_Iconposition);
         ucPanel_general.setProperty("AutoScroll", Panel_general_Autoscroll);
         ucPanel_general.render(context, "dvelop.gxbootstrap.panel_al", Panel_general_Internalname, "PANEL_GENERALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"PANEL_GENERALContainer"+"TablePanel_General"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablepanel_general_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0019"+"", GXutil.rtrim( WebComp_Webcomponent_general_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0019"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Webcomponent_general_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWebcomponent_general), GXutil.lower( WebComp_Webcomponent_general_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0019"+"");
               }
               WebComp_Webcomponent_general.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWebcomponent_general), GXutil.lower( WebComp_Webcomponent_general_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTabsPosition CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableviewcontainer_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTab", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabs.setProperty("PageCount", Tabs_Pagecount);
         ucTabs.setProperty("Class", Tabs_Class);
         ucTabs.setProperty("HistoryManagement", Tabs_Historymanagement);
         ucTabs.render(context, "tab", Tabs_Internalname, "TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCita_title_Internalname, "Cita", "", "", lblCita_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Cita") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablecita_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0033"+"", GXutil.rtrim( WebComp_Citawc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0033"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Citawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCitawc), GXutil.lower( WebComp_Citawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0033"+"");
               }
               WebComp_Citawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCitawc), GXutil.lower( WebComp_Citawc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblReclamo_title_Internalname, "Reclamo", "", "", lblReclamo_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Reclamo") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablereclamo_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0041"+"", GXutil.rtrim( WebComp_Reclamowc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0041"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Reclamowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldReclamowc), GXutil.lower( WebComp_Reclamowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0041"+"");
               }
               WebComp_Reclamowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldReclamowc), GXutil.lower( WebComp_Reclamowc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblPacientefamiliar_title_Internalname, "Paciente Familiar", "", "", lblPacientefamiliar_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "PacienteFamiliar") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablepacientefamiliar_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0049"+"", GXutil.rtrim( WebComp_Pacientefamiliarwc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0049"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Pacientefamiliarwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldPacientefamiliarwc), GXutil.lower( WebComp_Pacientefamiliarwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
               }
               WebComp_Pacientefamiliarwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldPacientefamiliarwc), GXutil.lower( WebComp_Pacientefamiliarwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblPacientefamiliar1_title_Internalname, "SGPaciente Hijo", "", "", lblPacientefamiliar1_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "PacienteFamiliar1") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablepacientefamiliar1_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0057"+"", GXutil.rtrim( WebComp_Pacientefamiliar1wc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0057"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Pacientefamiliar1wc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldPacientefamiliar1wc), GXutil.lower( WebComp_Pacientefamiliar1wc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0057"+"");
               }
               WebComp_Pacientefamiliar1wc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldPacientefamiliar1wc), GXutil.lower( WebComp_Pacientefamiliar1wc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblRatingprofesional_title_Internalname, "SGPaciente", "", "", lblRatingprofesional_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "RatingProfesional") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableratingprofesional_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0065"+"", GXutil.rtrim( WebComp_Ratingprofesionalwc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0065"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Ratingprofesionalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldRatingprofesionalwc), GXutil.lower( WebComp_Ratingprofesionalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0065"+"");
               }
               WebComp_Ratingprofesionalwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldRatingprofesionalwc), GXutil.lower( WebComp_Ratingprofesionalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblComentarioprofesional_title_Internalname, "SGPaciente", "", "", lblComentarioprofesional_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "ComentarioProfesional") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablecomentarioprofesional_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0073"+"", GXutil.rtrim( WebComp_Comentarioprofesionalwc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0073"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Comentarioprofesionalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldComentarioprofesionalwc), GXutil.lower( WebComp_Comentarioprofesionalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0073"+"");
               }
               WebComp_Comentarioprofesionalwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldComentarioprofesionalwc), GXutil.lower( WebComp_Comentarioprofesionalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title7"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblSugerenciasmejorasplataforma_title_Internalname, "SGPaciente", "", "", lblSugerenciasmejorasplataforma_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "SugerenciasMejorasPlataforma") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel7"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesugerenciasmejorasplataforma_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0081"+"", GXutil.rtrim( WebComp_Sugerenciasmejorasplataformawc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0081"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Sugerenciasmejorasplataformawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldSugerenciasmejorasplataformawc), GXutil.lower( WebComp_Sugerenciasmejorasplataformawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0081"+"");
               }
               WebComp_Sugerenciasmejorasplataformawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldSugerenciasmejorasplataformawc), GXutil.lower( WebComp_Sugerenciasmejorasplataformawc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title8"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblRatingplataforma_title_Internalname, "SGPaciente", "", "", lblRatingplataforma_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "RatingPlataforma") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel8"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableratingplataforma_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0089"+"", GXutil.rtrim( WebComp_Ratingplataformawc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0089"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Ratingplataformawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldRatingplataformawc), GXutil.lower( WebComp_Ratingplataformawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0089"+"");
               }
               WebComp_Ratingplataformawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldRatingplataformawc), GXutil.lower( WebComp_Ratingplataformawc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void start1E2( )
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
         Form.getMeta().addItem("description", "Paciente View", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1E0( ) ;
   }

   public void ws1E2( )
   {
      start1E2( ) ;
      evt1E2( ) ;
   }

   public void evt1E2( )
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
                        else if ( GXutil.strcmp(sEvt, "TABS.TABCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e111E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e121E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e131E2 ();
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 19 )
                     {
                        OldWebcomponent_general = httpContext.cgiGet( "W0019") ;
                        if ( ( GXutil.len( OldWebcomponent_general) == 0 ) || ( GXutil.strcmp(OldWebcomponent_general, WebComp_Webcomponent_general_Component) != 0 ) )
                        {
                           WebComp_Webcomponent_general = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldWebcomponent_general + "_impl", remoteHandle, context);
                           WebComp_Webcomponent_general_Component = OldWebcomponent_general ;
                        }
                        if ( GXutil.len( WebComp_Webcomponent_general_Component) != 0 )
                        {
                           WebComp_Webcomponent_general.componentprocess("W0019", "", sEvt);
                        }
                        WebComp_Webcomponent_general_Component = OldWebcomponent_general ;
                     }
                     else if ( nCmpId == 33 )
                     {
                        OldCitawc = httpContext.cgiGet( "W0033") ;
                        if ( ( GXutil.len( OldCitawc) == 0 ) || ( GXutil.strcmp(OldCitawc, WebComp_Citawc_Component) != 0 ) )
                        {
                           WebComp_Citawc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldCitawc + "_impl", remoteHandle, context);
                           WebComp_Citawc_Component = OldCitawc ;
                        }
                        if ( GXutil.len( WebComp_Citawc_Component) != 0 )
                        {
                           WebComp_Citawc.componentprocess("W0033", "", sEvt);
                        }
                        WebComp_Citawc_Component = OldCitawc ;
                     }
                     else if ( nCmpId == 41 )
                     {
                        OldReclamowc = httpContext.cgiGet( "W0041") ;
                        if ( ( GXutil.len( OldReclamowc) == 0 ) || ( GXutil.strcmp(OldReclamowc, WebComp_Reclamowc_Component) != 0 ) )
                        {
                           WebComp_Reclamowc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldReclamowc + "_impl", remoteHandle, context);
                           WebComp_Reclamowc_Component = OldReclamowc ;
                        }
                        if ( GXutil.len( WebComp_Reclamowc_Component) != 0 )
                        {
                           WebComp_Reclamowc.componentprocess("W0041", "", sEvt);
                        }
                        WebComp_Reclamowc_Component = OldReclamowc ;
                     }
                     else if ( nCmpId == 49 )
                     {
                        OldPacientefamiliarwc = httpContext.cgiGet( "W0049") ;
                        if ( ( GXutil.len( OldPacientefamiliarwc) == 0 ) || ( GXutil.strcmp(OldPacientefamiliarwc, WebComp_Pacientefamiliarwc_Component) != 0 ) )
                        {
                           WebComp_Pacientefamiliarwc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldPacientefamiliarwc + "_impl", remoteHandle, context);
                           WebComp_Pacientefamiliarwc_Component = OldPacientefamiliarwc ;
                        }
                        if ( GXutil.len( WebComp_Pacientefamiliarwc_Component) != 0 )
                        {
                           WebComp_Pacientefamiliarwc.componentprocess("W0049", "", sEvt);
                        }
                        WebComp_Pacientefamiliarwc_Component = OldPacientefamiliarwc ;
                     }
                     else if ( nCmpId == 57 )
                     {
                        OldPacientefamiliar1wc = httpContext.cgiGet( "W0057") ;
                        if ( ( GXutil.len( OldPacientefamiliar1wc) == 0 ) || ( GXutil.strcmp(OldPacientefamiliar1wc, WebComp_Pacientefamiliar1wc_Component) != 0 ) )
                        {
                           WebComp_Pacientefamiliar1wc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldPacientefamiliar1wc + "_impl", remoteHandle, context);
                           WebComp_Pacientefamiliar1wc_Component = OldPacientefamiliar1wc ;
                        }
                        if ( GXutil.len( WebComp_Pacientefamiliar1wc_Component) != 0 )
                        {
                           WebComp_Pacientefamiliar1wc.componentprocess("W0057", "", sEvt);
                        }
                        WebComp_Pacientefamiliar1wc_Component = OldPacientefamiliar1wc ;
                     }
                     else if ( nCmpId == 65 )
                     {
                        OldRatingprofesionalwc = httpContext.cgiGet( "W0065") ;
                        if ( ( GXutil.len( OldRatingprofesionalwc) == 0 ) || ( GXutil.strcmp(OldRatingprofesionalwc, WebComp_Ratingprofesionalwc_Component) != 0 ) )
                        {
                           WebComp_Ratingprofesionalwc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldRatingprofesionalwc + "_impl", remoteHandle, context);
                           WebComp_Ratingprofesionalwc_Component = OldRatingprofesionalwc ;
                        }
                        if ( GXutil.len( WebComp_Ratingprofesionalwc_Component) != 0 )
                        {
                           WebComp_Ratingprofesionalwc.componentprocess("W0065", "", sEvt);
                        }
                        WebComp_Ratingprofesionalwc_Component = OldRatingprofesionalwc ;
                     }
                     else if ( nCmpId == 73 )
                     {
                        OldComentarioprofesionalwc = httpContext.cgiGet( "W0073") ;
                        if ( ( GXutil.len( OldComentarioprofesionalwc) == 0 ) || ( GXutil.strcmp(OldComentarioprofesionalwc, WebComp_Comentarioprofesionalwc_Component) != 0 ) )
                        {
                           WebComp_Comentarioprofesionalwc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldComentarioprofesionalwc + "_impl", remoteHandle, context);
                           WebComp_Comentarioprofesionalwc_Component = OldComentarioprofesionalwc ;
                        }
                        if ( GXutil.len( WebComp_Comentarioprofesionalwc_Component) != 0 )
                        {
                           WebComp_Comentarioprofesionalwc.componentprocess("W0073", "", sEvt);
                        }
                        WebComp_Comentarioprofesionalwc_Component = OldComentarioprofesionalwc ;
                     }
                     else if ( nCmpId == 81 )
                     {
                        OldSugerenciasmejorasplataformawc = httpContext.cgiGet( "W0081") ;
                        if ( ( GXutil.len( OldSugerenciasmejorasplataformawc) == 0 ) || ( GXutil.strcmp(OldSugerenciasmejorasplataformawc, WebComp_Sugerenciasmejorasplataformawc_Component) != 0 ) )
                        {
                           WebComp_Sugerenciasmejorasplataformawc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldSugerenciasmejorasplataformawc + "_impl", remoteHandle, context);
                           WebComp_Sugerenciasmejorasplataformawc_Component = OldSugerenciasmejorasplataformawc ;
                        }
                        if ( GXutil.len( WebComp_Sugerenciasmejorasplataformawc_Component) != 0 )
                        {
                           WebComp_Sugerenciasmejorasplataformawc.componentprocess("W0081", "", sEvt);
                        }
                        WebComp_Sugerenciasmejorasplataformawc_Component = OldSugerenciasmejorasplataformawc ;
                     }
                     else if ( nCmpId == 89 )
                     {
                        OldRatingplataformawc = httpContext.cgiGet( "W0089") ;
                        if ( ( GXutil.len( OldRatingplataformawc) == 0 ) || ( GXutil.strcmp(OldRatingplataformawc, WebComp_Ratingplataformawc_Component) != 0 ) )
                        {
                           WebComp_Ratingplataformawc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldRatingplataformawc + "_impl", remoteHandle, context);
                           WebComp_Ratingplataformawc_Component = OldRatingplataformawc ;
                        }
                        if ( GXutil.len( WebComp_Ratingplataformawc_Component) != 0 )
                        {
                           WebComp_Ratingplataformawc.componentprocess("W0089", "", sEvt);
                        }
                        WebComp_Ratingplataformawc_Component = OldRatingplataformawc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1E2( )
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

   public void pa1E2( )
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
      rf1E2( ) ;
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

   public void rf1E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Webcomponent_general_Component) != 0 )
            {
               WebComp_Webcomponent_general.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Citawc_Component) != 0 )
            {
               WebComp_Citawc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Reclamowc_Component) != 0 )
            {
               WebComp_Reclamowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Pacientefamiliarwc_Component) != 0 )
            {
               WebComp_Pacientefamiliarwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Pacientefamiliar1wc_Component) != 0 )
            {
               WebComp_Pacientefamiliar1wc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Ratingprofesionalwc_Component) != 0 )
            {
               WebComp_Ratingprofesionalwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Comentarioprofesionalwc_Component) != 0 )
            {
               WebComp_Comentarioprofesionalwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Sugerenciasmejorasplataformawc_Component) != 0 )
            {
               WebComp_Sugerenciasmejorasplataformawc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Ratingplataformawc_Component) != 0 )
            {
               WebComp_Ratingplataformawc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e131E2 ();
         wb1E0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1E2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e121E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Panel_general_Width = httpContext.cgiGet( "PANEL_GENERAL_Width") ;
         Panel_general_Autowidth = GXutil.strtobool( httpContext.cgiGet( "PANEL_GENERAL_Autowidth")) ;
         Panel_general_Autoheight = GXutil.strtobool( httpContext.cgiGet( "PANEL_GENERAL_Autoheight")) ;
         Panel_general_Cls = httpContext.cgiGet( "PANEL_GENERAL_Cls") ;
         Panel_general_Title = httpContext.cgiGet( "PANEL_GENERAL_Title") ;
         Panel_general_Collapsible = GXutil.strtobool( httpContext.cgiGet( "PANEL_GENERAL_Collapsible")) ;
         Panel_general_Collapsed = GXutil.strtobool( httpContext.cgiGet( "PANEL_GENERAL_Collapsed")) ;
         Panel_general_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "PANEL_GENERAL_Showcollapseicon")) ;
         Panel_general_Iconposition = httpContext.cgiGet( "PANEL_GENERAL_Iconposition") ;
         Panel_general_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "PANEL_GENERAL_Autoscroll")) ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABS_Pagecount"), ",", ".")) ;
         Tabs_Class = httpContext.cgiGet( "TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABS_Historymanagement")) ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e121E2 ();
      if (returnInSub) return;
   }

   public void e121E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      lblWorkwithlink_Link = formatLink("com.projectthani.pacienteww", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblWorkwithlink_Internalname, "Link", lblWorkwithlink_Link, true);
      AV18GXLvl9 = (byte)(0) ;
      /* Using cursor H001E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = H001E2_A20PacienteId[0] ;
         A105PacienteNombres = H001E2_A105PacienteNombres[0] ;
         AV18GXLvl9 = (byte)(1) ;
         Form.setCaption( A105PacienteNombres );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV18GXLvl9 == 0 )
      {
         Form.setCaption( "Registro no encontrado" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = false ;
      }
      if ( AV9Exists )
      {
         AV12SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SelectedTabCode", AV12SelectedTabCode);
         Tabs_Activepagecontrolname = AV12SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADFIXEDTABS' */
         S112 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'LOADTABS' */
         S122 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e131E2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void e111E2( )
   {
      /* Tabs_Tabchanged Routine */
      returnInSub = false ;
      AV12SelectedTabCode = Tabs_Activepagecontrolname ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12SelectedTabCode", AV12SelectedTabCode);
      AV11LoadAllTabs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11LoadAllTabs", AV11LoadAllTabs);
      /* Execute user subroutine: 'LOADTABS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADFIXEDTABS' Routine */
      returnInSub = false ;
      /* Object Property */
      if ( true )
      {
         bDynCreated_Webcomponent_general = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Webcomponent_general_Component), GXutil.lower( "PacienteGeneral")) != 0 )
      {
         WebComp_Webcomponent_general = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientegeneral_impl", remoteHandle, context);
         WebComp_Webcomponent_general_Component = "PacienteGeneral" ;
      }
      if ( GXutil.len( WebComp_Webcomponent_general_Component) != 0 )
      {
         WebComp_Webcomponent_general.setjustcreated();
         WebComp_Webcomponent_general.componentprepare(new Object[] {"W0019","",Integer.valueOf(AV10PacienteId)});
         WebComp_Webcomponent_general.componentbind(new Object[] {""});
      }
      if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Webcomponent_general )
      {
         httpContext.ajax_rspStartCmp("gxHTMLWrpW0019"+"");
         WebComp_Webcomponent_general.componentdraw();
         httpContext.ajax_rspEndCmp();
      }
   }

   public void S122( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      /* Using cursor H001E3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10PacienteId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A20PacienteId = H001E3_A20PacienteId[0] ;
         GXt_boolean2 = AV15TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean3) ;
         pacienteview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15TempBoolean = GXt_boolean2 ;
         if ( AV15TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV12SelectedTabCode, "Cita") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Citawc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Citawc_Component), GXutil.lower( "PacienteCitaWC")) != 0 )
               {
                  WebComp_Citawc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientecitawc_impl", remoteHandle, context);
                  WebComp_Citawc_Component = "PacienteCitaWC" ;
               }
               if ( GXutil.len( WebComp_Citawc_Component) != 0 )
               {
                  WebComp_Citawc.setjustcreated();
                  WebComp_Citawc.componentprepare(new Object[] {"W0033","",Integer.valueOf(AV10PacienteId)});
                  WebComp_Citawc.componentbind(new Object[] {""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Citawc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0033"+"");
                  WebComp_Citawc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "Reclamo") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Reclamowc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Reclamowc_Component), GXutil.lower( "PacienteReclamoWC")) != 0 )
            {
               WebComp_Reclamowc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientereclamowc_impl", remoteHandle, context);
               WebComp_Reclamowc_Component = "PacienteReclamoWC" ;
            }
            if ( GXutil.len( WebComp_Reclamowc_Component) != 0 )
            {
               WebComp_Reclamowc.setjustcreated();
               WebComp_Reclamowc.componentprepare(new Object[] {"W0041","",Integer.valueOf(AV10PacienteId)});
               WebComp_Reclamowc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Reclamowc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0041"+"");
               WebComp_Reclamowc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "PacienteFamiliar") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Pacientefamiliarwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Pacientefamiliarwc_Component), GXutil.lower( "PacientePacienteFamiliarWC")) != 0 )
            {
               WebComp_Pacientefamiliarwc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientepacientefamiliarwc_impl", remoteHandle, context);
               WebComp_Pacientefamiliarwc_Component = "PacientePacienteFamiliarWC" ;
            }
            if ( GXutil.len( WebComp_Pacientefamiliarwc_Component) != 0 )
            {
               WebComp_Pacientefamiliarwc.setjustcreated();
               WebComp_Pacientefamiliarwc.componentprepare(new Object[] {"W0049","",Integer.valueOf(AV10PacienteId)});
               WebComp_Pacientefamiliarwc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Pacientefamiliarwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
               WebComp_Pacientefamiliarwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "PacienteFamiliar1") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Pacientefamiliar1wc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Pacientefamiliar1wc_Component), GXutil.lower( "PacientePacienteFamiliar1WC")) != 0 )
            {
               WebComp_Pacientefamiliar1wc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientepacientefamiliar1wc_impl", remoteHandle, context);
               WebComp_Pacientefamiliar1wc_Component = "PacientePacienteFamiliar1WC" ;
            }
            if ( GXutil.len( WebComp_Pacientefamiliar1wc_Component) != 0 )
            {
               WebComp_Pacientefamiliar1wc.setjustcreated();
               WebComp_Pacientefamiliar1wc.componentprepare(new Object[] {"W0057","",Integer.valueOf(AV10PacienteId)});
               WebComp_Pacientefamiliar1wc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Pacientefamiliar1wc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0057"+"");
               WebComp_Pacientefamiliar1wc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "RatingProfesional") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Ratingprofesionalwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Ratingprofesionalwc_Component), GXutil.lower( "PacienteRatingProfesionalWC")) != 0 )
            {
               WebComp_Ratingprofesionalwc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacienteratingprofesionalwc_impl", remoteHandle, context);
               WebComp_Ratingprofesionalwc_Component = "PacienteRatingProfesionalWC" ;
            }
            if ( GXutil.len( WebComp_Ratingprofesionalwc_Component) != 0 )
            {
               WebComp_Ratingprofesionalwc.setjustcreated();
               WebComp_Ratingprofesionalwc.componentprepare(new Object[] {"W0065","",Integer.valueOf(AV10PacienteId)});
               WebComp_Ratingprofesionalwc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Ratingprofesionalwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0065"+"");
               WebComp_Ratingprofesionalwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "ComentarioProfesional") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Comentarioprofesionalwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Comentarioprofesionalwc_Component), GXutil.lower( "PacienteComentarioProfesionalWC")) != 0 )
            {
               WebComp_Comentarioprofesionalwc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientecomentarioprofesionalwc_impl", remoteHandle, context);
               WebComp_Comentarioprofesionalwc_Component = "PacienteComentarioProfesionalWC" ;
            }
            if ( GXutil.len( WebComp_Comentarioprofesionalwc_Component) != 0 )
            {
               WebComp_Comentarioprofesionalwc.setjustcreated();
               WebComp_Comentarioprofesionalwc.componentprepare(new Object[] {"W0073","",Integer.valueOf(AV10PacienteId)});
               WebComp_Comentarioprofesionalwc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Comentarioprofesionalwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0073"+"");
               WebComp_Comentarioprofesionalwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "SugerenciasMejorasPlataforma") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Sugerenciasmejorasplataformawc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Sugerenciasmejorasplataformawc_Component), GXutil.lower( "PacienteSugerenciasMejorasPlataformaWC")) != 0 )
            {
               WebComp_Sugerenciasmejorasplataformawc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacientesugerenciasmejorasplataformawc_impl", remoteHandle, context);
               WebComp_Sugerenciasmejorasplataformawc_Component = "PacienteSugerenciasMejorasPlataformaWC" ;
            }
            if ( GXutil.len( WebComp_Sugerenciasmejorasplataformawc_Component) != 0 )
            {
               WebComp_Sugerenciasmejorasplataformawc.setjustcreated();
               WebComp_Sugerenciasmejorasplataformawc.componentprepare(new Object[] {"W0081","",Integer.valueOf(AV10PacienteId)});
               WebComp_Sugerenciasmejorasplataformawc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Sugerenciasmejorasplataformawc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0081"+"");
               WebComp_Sugerenciasmejorasplataformawc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "RatingPlataforma") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Ratingplataformawc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Ratingplataformawc_Component), GXutil.lower( "PacienteRatingPlataformaWC")) != 0 )
            {
               WebComp_Ratingplataformawc = WebUtils.getWebComponent(getClass(), "com.projectthani.pacienteratingplataformawc_impl", remoteHandle, context);
               WebComp_Ratingplataformawc_Component = "PacienteRatingPlataformaWC" ;
            }
            if ( GXutil.len( WebComp_Ratingplataformawc_Component) != 0 )
            {
               WebComp_Ratingplataformawc.setjustcreated();
               WebComp_Ratingplataformawc.componentprepare(new Object[] {"W0089","",Integer.valueOf(AV10PacienteId)});
               WebComp_Ratingplataformawc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Ratingplataformawc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0089"+"");
               WebComp_Ratingplataformawc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10PacienteId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10PacienteId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PacienteId), "ZZZZZZZ9")));
      AV8TabCode = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      pa1E2( ) ;
      ws1E2( ) ;
      we1E2( ) ;
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
      if ( ! ( WebComp_Webcomponent_general == null ) )
      {
         if ( GXutil.len( WebComp_Webcomponent_general_Component) != 0 )
         {
            WebComp_Webcomponent_general.componentthemes();
         }
      }
      if ( ! ( WebComp_Citawc == null ) )
      {
         if ( GXutil.len( WebComp_Citawc_Component) != 0 )
         {
            WebComp_Citawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Reclamowc == null ) )
      {
         if ( GXutil.len( WebComp_Reclamowc_Component) != 0 )
         {
            WebComp_Reclamowc.componentthemes();
         }
      }
      if ( ! ( WebComp_Pacientefamiliarwc == null ) )
      {
         if ( GXutil.len( WebComp_Pacientefamiliarwc_Component) != 0 )
         {
            WebComp_Pacientefamiliarwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Pacientefamiliar1wc == null ) )
      {
         if ( GXutil.len( WebComp_Pacientefamiliar1wc_Component) != 0 )
         {
            WebComp_Pacientefamiliar1wc.componentthemes();
         }
      }
      if ( ! ( WebComp_Ratingprofesionalwc == null ) )
      {
         if ( GXutil.len( WebComp_Ratingprofesionalwc_Component) != 0 )
         {
            WebComp_Ratingprofesionalwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Comentarioprofesionalwc == null ) )
      {
         if ( GXutil.len( WebComp_Comentarioprofesionalwc_Component) != 0 )
         {
            WebComp_Comentarioprofesionalwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Sugerenciasmejorasplataformawc == null ) )
      {
         if ( GXutil.len( WebComp_Sugerenciasmejorasplataformawc_Component) != 0 )
         {
            WebComp_Sugerenciasmejorasplataformawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Ratingplataformawc == null ) )
      {
         if ( GXutil.len( WebComp_Ratingplataformawc_Component) != 0 )
         {
            WebComp_Ratingplataformawc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331421", true, true);
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
      httpContext.AddJavascriptSource("pacienteview.js", "?20225110331421", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblWorkwithlink_Internalname = "WORKWITHLINK" ;
      divTableviewrightitems_Internalname = "TABLEVIEWRIGHTITEMS" ;
      divTablepanel_general_Internalname = "TABLEPANEL_GENERAL" ;
      Panel_general_Internalname = "PANEL_GENERAL" ;
      divPacientegeneral_cell_Internalname = "PACIENTEGENERAL_CELL" ;
      lblCita_title_Internalname = "CITA_TITLE" ;
      divUnnamedtablecita_Internalname = "UNNAMEDTABLECITA" ;
      lblReclamo_title_Internalname = "RECLAMO_TITLE" ;
      divUnnamedtablereclamo_Internalname = "UNNAMEDTABLERECLAMO" ;
      lblPacientefamiliar_title_Internalname = "PACIENTEFAMILIAR_TITLE" ;
      divUnnamedtablepacientefamiliar_Internalname = "UNNAMEDTABLEPACIENTEFAMILIAR" ;
      lblPacientefamiliar1_title_Internalname = "PACIENTEFAMILIAR1_TITLE" ;
      divUnnamedtablepacientefamiliar1_Internalname = "UNNAMEDTABLEPACIENTEFAMILIAR1" ;
      lblRatingprofesional_title_Internalname = "RATINGPROFESIONAL_TITLE" ;
      divUnnamedtableratingprofesional_Internalname = "UNNAMEDTABLERATINGPROFESIONAL" ;
      lblComentarioprofesional_title_Internalname = "COMENTARIOPROFESIONAL_TITLE" ;
      divUnnamedtablecomentarioprofesional_Internalname = "UNNAMEDTABLECOMENTARIOPROFESIONAL" ;
      lblSugerenciasmejorasplataforma_title_Internalname = "SUGERENCIASMEJORASPLATAFORMA_TITLE" ;
      divUnnamedtablesugerenciasmejorasplataforma_Internalname = "UNNAMEDTABLESUGERENCIASMEJORASPLATAFORMA" ;
      lblRatingplataforma_title_Internalname = "RATINGPLATAFORMA_TITLE" ;
      divUnnamedtableratingplataforma_Internalname = "UNNAMEDTABLERATINGPLATAFORMA" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
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
      lblWorkwithlink_Link = "" ;
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 8 ;
      Panel_general_Autoscroll = GXutil.toBoolean( 0) ;
      Panel_general_Iconposition = "Right" ;
      Panel_general_Showcollapseicon = GXutil.toBoolean( 0) ;
      Panel_general_Collapsed = GXutil.toBoolean( 0) ;
      Panel_general_Collapsible = GXutil.toBoolean( -1) ;
      Panel_general_Title = "Información General" ;
      Panel_general_Cls = "PanelCard_GrayTitle" ;
      Panel_general_Autoheight = GXutil.toBoolean( -1) ;
      Panel_general_Autowidth = GXutil.toBoolean( 0) ;
      Panel_general_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Paciente View" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e111E2',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'AV10PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{ctrl:'CITAWC'},{ctrl:'RECLAMOWC'},{ctrl:'PACIENTEFAMILIARWC'},{ctrl:'PACIENTEFAMILIAR1WC'},{ctrl:'RATINGPROFESIONALWC'},{ctrl:'COMENTARIOPROFESIONALWC'},{ctrl:'SUGERENCIASMEJORASPLATAFORMAWC'},{ctrl:'RATINGPLATAFORMAWC'}]}");
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
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV12SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblWorkwithlink_Jsonclick = "" ;
      ucPanel_general = new com.genexus.webpanels.GXUserControl();
      WebComp_Webcomponent_general_Component = "" ;
      OldWebcomponent_general = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      lblCita_title_Jsonclick = "" ;
      WebComp_Citawc_Component = "" ;
      OldCitawc = "" ;
      lblReclamo_title_Jsonclick = "" ;
      WebComp_Reclamowc_Component = "" ;
      OldReclamowc = "" ;
      lblPacientefamiliar_title_Jsonclick = "" ;
      WebComp_Pacientefamiliarwc_Component = "" ;
      OldPacientefamiliarwc = "" ;
      lblPacientefamiliar1_title_Jsonclick = "" ;
      WebComp_Pacientefamiliar1wc_Component = "" ;
      OldPacientefamiliar1wc = "" ;
      lblRatingprofesional_title_Jsonclick = "" ;
      WebComp_Ratingprofesionalwc_Component = "" ;
      OldRatingprofesionalwc = "" ;
      lblComentarioprofesional_title_Jsonclick = "" ;
      WebComp_Comentarioprofesionalwc_Component = "" ;
      OldComentarioprofesionalwc = "" ;
      lblSugerenciasmejorasplataforma_title_Jsonclick = "" ;
      WebComp_Sugerenciasmejorasplataformawc_Component = "" ;
      OldSugerenciasmejorasplataformawc = "" ;
      lblRatingplataforma_title_Jsonclick = "" ;
      WebComp_Ratingplataformawc_Component = "" ;
      OldRatingplataformawc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H001E2_A20PacienteId = new int[1] ;
      H001E2_A105PacienteNombres = new String[] {""} ;
      A105PacienteNombres = "" ;
      H001E3_A20PacienteId = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacienteview__default(),
         new Object[] {
             new Object[] {
            H001E2_A20PacienteId, H001E2_A105PacienteNombres
            }
            , new Object[] {
            H001E3_A20PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Webcomponent_general = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Citawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Reclamowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Pacientefamiliarwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Pacientefamiliar1wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Ratingprofesionalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Comentarioprofesionalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Sugerenciasmejorasplataformawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Ratingplataformawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV18GXLvl9 ;
   private byte nGXWrapped ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV10PacienteId ;
   private int AV10PacienteId ;
   private int A20PacienteId ;
   private int Tabs_Pagecount ;
   private int idxLst ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV12SelectedTabCode ;
   private String Panel_general_Width ;
   private String Panel_general_Cls ;
   private String Panel_general_Title ;
   private String Panel_general_Iconposition ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableviewrightitems_Internalname ;
   private String lblWorkwithlink_Internalname ;
   private String lblWorkwithlink_Link ;
   private String lblWorkwithlink_Jsonclick ;
   private String divPacientegeneral_cell_Internalname ;
   private String Panel_general_Internalname ;
   private String divTablepanel_general_Internalname ;
   private String WebComp_Webcomponent_general_Component ;
   private String OldWebcomponent_general ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String Tabs_Internalname ;
   private String lblCita_title_Internalname ;
   private String lblCita_title_Jsonclick ;
   private String divUnnamedtablecita_Internalname ;
   private String WebComp_Citawc_Component ;
   private String OldCitawc ;
   private String lblReclamo_title_Internalname ;
   private String lblReclamo_title_Jsonclick ;
   private String divUnnamedtablereclamo_Internalname ;
   private String WebComp_Reclamowc_Component ;
   private String OldReclamowc ;
   private String lblPacientefamiliar_title_Internalname ;
   private String lblPacientefamiliar_title_Jsonclick ;
   private String divUnnamedtablepacientefamiliar_Internalname ;
   private String WebComp_Pacientefamiliarwc_Component ;
   private String OldPacientefamiliarwc ;
   private String lblPacientefamiliar1_title_Internalname ;
   private String lblPacientefamiliar1_title_Jsonclick ;
   private String divUnnamedtablepacientefamiliar1_Internalname ;
   private String WebComp_Pacientefamiliar1wc_Component ;
   private String OldPacientefamiliar1wc ;
   private String lblRatingprofesional_title_Internalname ;
   private String lblRatingprofesional_title_Jsonclick ;
   private String divUnnamedtableratingprofesional_Internalname ;
   private String WebComp_Ratingprofesionalwc_Component ;
   private String OldRatingprofesionalwc ;
   private String lblComentarioprofesional_title_Internalname ;
   private String lblComentarioprofesional_title_Jsonclick ;
   private String divUnnamedtablecomentarioprofesional_Internalname ;
   private String WebComp_Comentarioprofesionalwc_Component ;
   private String OldComentarioprofesionalwc ;
   private String lblSugerenciasmejorasplataforma_title_Internalname ;
   private String lblSugerenciasmejorasplataforma_title_Jsonclick ;
   private String divUnnamedtablesugerenciasmejorasplataforma_Internalname ;
   private String WebComp_Sugerenciasmejorasplataformawc_Component ;
   private String OldSugerenciasmejorasplataformawc ;
   private String lblRatingplataforma_title_Internalname ;
   private String lblRatingplataforma_title_Jsonclick ;
   private String divUnnamedtableratingplataforma_Internalname ;
   private String WebComp_Ratingplataformawc_Component ;
   private String OldRatingplataformawc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV11LoadAllTabs ;
   private boolean Panel_general_Autowidth ;
   private boolean Panel_general_Autoheight ;
   private boolean Panel_general_Collapsible ;
   private boolean Panel_general_Collapsed ;
   private boolean Panel_general_Showcollapseicon ;
   private boolean Panel_general_Autoscroll ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Webcomponent_general ;
   private boolean AV15TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean bDynCreated_Citawc ;
   private boolean bDynCreated_Reclamowc ;
   private boolean bDynCreated_Pacientefamiliarwc ;
   private boolean bDynCreated_Pacientefamiliar1wc ;
   private boolean bDynCreated_Ratingprofesionalwc ;
   private boolean bDynCreated_Comentarioprofesionalwc ;
   private boolean bDynCreated_Sugerenciasmejorasplataformawc ;
   private boolean bDynCreated_Ratingplataformawc ;
   private String A105PacienteNombres ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Webcomponent_general ;
   private GXWebComponent WebComp_Citawc ;
   private GXWebComponent WebComp_Reclamowc ;
   private GXWebComponent WebComp_Pacientefamiliarwc ;
   private GXWebComponent WebComp_Pacientefamiliar1wc ;
   private GXWebComponent WebComp_Ratingprofesionalwc ;
   private GXWebComponent WebComp_Comentarioprofesionalwc ;
   private GXWebComponent WebComp_Sugerenciasmejorasplataformawc ;
   private GXWebComponent WebComp_Ratingplataformawc ;
   private com.genexus.webpanels.GXUserControl ucPanel_general ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private int[] H001E2_A20PacienteId ;
   private String[] H001E2_A105PacienteNombres ;
   private int[] H001E3_A20PacienteId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class pacienteview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001E2", "SELECT [PacienteId], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H001E3", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

