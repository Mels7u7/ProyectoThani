package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citaview_impl extends GXDataArea
{
   public citaview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citaview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citaview_impl.class ));
   }

   public citaview_impl( int remoteHandle ,
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
            AV10CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CitaId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CitaId), "ZZZZZZZ9")));
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
      pa1G2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1G2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033146", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CitaId","TabCode"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CITAID", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV10CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CitaId), "ZZZZZZZ9")));
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
      if ( ! ( WebComp_Citadiagnosticowc == null ) )
      {
         WebComp_Citadiagnosticowc.componentjscripts();
      }
      if ( ! ( WebComp_Citarecetawc == null ) )
      {
         WebComp_Citarecetawc.componentjscripts();
      }
      if ( ! ( WebComp_Citaserviciowc == null ) )
      {
         WebComp_Citaserviciowc.componentjscripts();
      }
      if ( ! ( WebComp_Encuestawc == null ) )
      {
         WebComp_Encuestawc.componentjscripts();
      }
      if ( ! ( WebComp_Pagowc == null ) )
      {
         WebComp_Pagowc.componentjscripts();
      }
      if ( ! ( WebComp_Recetamedicawc == null ) )
      {
         WebComp_Recetamedicawc.componentjscripts();
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
         we1G2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1G2( ) ;
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
      return formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"CitaId","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "CitaView" ;
   }

   public String getPgmdesc( )
   {
      return "Cita View" ;
   }

   public void wb1G0( )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblWorkwithlink_Internalname, "Ir a Cita", lblWorkwithlink_Link, "", lblWorkwithlink_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockLink", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCitageneral_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCitadiagnostico_title_Internalname, "Cita Diagnostico", "", "", lblCitadiagnostico_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "CitaDiagnostico") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablecitadiagnostico_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0033"+"", GXutil.rtrim( WebComp_Citadiagnosticowc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0033"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Citadiagnosticowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCitadiagnosticowc), GXutil.lower( WebComp_Citadiagnosticowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0033"+"");
               }
               WebComp_Citadiagnosticowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCitadiagnosticowc), GXutil.lower( WebComp_Citadiagnosticowc_Component)) != 0 )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCitareceta_title_Internalname, "Cita Receta", "", "", lblCitareceta_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "CitaReceta") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablecitareceta_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0041"+"", GXutil.rtrim( WebComp_Citarecetawc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0041"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Citarecetawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCitarecetawc), GXutil.lower( WebComp_Citarecetawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0041"+"");
               }
               WebComp_Citarecetawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCitarecetawc), GXutil.lower( WebComp_Citarecetawc_Component)) != 0 )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCitaservicio_title_Internalname, "Cita Servicio", "", "", lblCitaservicio_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "CitaServicio") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablecitaservicio_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0049"+"", GXutil.rtrim( WebComp_Citaserviciowc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0049"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Citaserviciowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCitaserviciowc), GXutil.lower( WebComp_Citaserviciowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
               }
               WebComp_Citaserviciowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCitaserviciowc), GXutil.lower( WebComp_Citaserviciowc_Component)) != 0 )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblEncuesta_title_Internalname, "Encuesta", "", "", lblEncuesta_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Encuesta") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableencuesta_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0057"+"", GXutil.rtrim( WebComp_Encuestawc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0057"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Encuestawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldEncuestawc), GXutil.lower( WebComp_Encuestawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0057"+"");
               }
               WebComp_Encuestawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldEncuestawc), GXutil.lower( WebComp_Encuestawc_Component)) != 0 )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblPago_title_Internalname, "Pago", "", "", lblPago_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Pago") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablepago_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0065"+"", GXutil.rtrim( WebComp_Pagowc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0065"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Pagowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldPagowc), GXutil.lower( WebComp_Pagowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0065"+"");
               }
               WebComp_Pagowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldPagowc), GXutil.lower( WebComp_Pagowc_Component)) != 0 )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblRecetamedica_title_Internalname, "Receta Medica", "", "", lblRecetamedica_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CitaView.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "RecetaMedica") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablerecetamedica_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0073"+"", GXutil.rtrim( WebComp_Recetamedicawc_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0073"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Recetamedicawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldRecetamedicawc), GXutil.lower( WebComp_Recetamedicawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0073"+"");
               }
               WebComp_Recetamedicawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldRecetamedicawc), GXutil.lower( WebComp_Recetamedicawc_Component)) != 0 )
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

   public void start1G2( )
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
         Form.getMeta().addItem("description", "Cita View", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1G0( ) ;
   }

   public void ws1G2( )
   {
      start1G2( ) ;
      evt1G2( ) ;
   }

   public void evt1G2( )
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
                           e111G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e121G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e131G2 ();
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
                        OldCitadiagnosticowc = httpContext.cgiGet( "W0033") ;
                        if ( ( GXutil.len( OldCitadiagnosticowc) == 0 ) || ( GXutil.strcmp(OldCitadiagnosticowc, WebComp_Citadiagnosticowc_Component) != 0 ) )
                        {
                           WebComp_Citadiagnosticowc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldCitadiagnosticowc + "_impl", remoteHandle, context);
                           WebComp_Citadiagnosticowc_Component = OldCitadiagnosticowc ;
                        }
                        if ( GXutil.len( WebComp_Citadiagnosticowc_Component) != 0 )
                        {
                           WebComp_Citadiagnosticowc.componentprocess("W0033", "", sEvt);
                        }
                        WebComp_Citadiagnosticowc_Component = OldCitadiagnosticowc ;
                     }
                     else if ( nCmpId == 41 )
                     {
                        OldCitarecetawc = httpContext.cgiGet( "W0041") ;
                        if ( ( GXutil.len( OldCitarecetawc) == 0 ) || ( GXutil.strcmp(OldCitarecetawc, WebComp_Citarecetawc_Component) != 0 ) )
                        {
                           WebComp_Citarecetawc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldCitarecetawc + "_impl", remoteHandle, context);
                           WebComp_Citarecetawc_Component = OldCitarecetawc ;
                        }
                        if ( GXutil.len( WebComp_Citarecetawc_Component) != 0 )
                        {
                           WebComp_Citarecetawc.componentprocess("W0041", "", sEvt);
                        }
                        WebComp_Citarecetawc_Component = OldCitarecetawc ;
                     }
                     else if ( nCmpId == 49 )
                     {
                        OldCitaserviciowc = httpContext.cgiGet( "W0049") ;
                        if ( ( GXutil.len( OldCitaserviciowc) == 0 ) || ( GXutil.strcmp(OldCitaserviciowc, WebComp_Citaserviciowc_Component) != 0 ) )
                        {
                           WebComp_Citaserviciowc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldCitaserviciowc + "_impl", remoteHandle, context);
                           WebComp_Citaserviciowc_Component = OldCitaserviciowc ;
                        }
                        if ( GXutil.len( WebComp_Citaserviciowc_Component) != 0 )
                        {
                           WebComp_Citaserviciowc.componentprocess("W0049", "", sEvt);
                        }
                        WebComp_Citaserviciowc_Component = OldCitaserviciowc ;
                     }
                     else if ( nCmpId == 57 )
                     {
                        OldEncuestawc = httpContext.cgiGet( "W0057") ;
                        if ( ( GXutil.len( OldEncuestawc) == 0 ) || ( GXutil.strcmp(OldEncuestawc, WebComp_Encuestawc_Component) != 0 ) )
                        {
                           WebComp_Encuestawc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldEncuestawc + "_impl", remoteHandle, context);
                           WebComp_Encuestawc_Component = OldEncuestawc ;
                        }
                        if ( GXutil.len( WebComp_Encuestawc_Component) != 0 )
                        {
                           WebComp_Encuestawc.componentprocess("W0057", "", sEvt);
                        }
                        WebComp_Encuestawc_Component = OldEncuestawc ;
                     }
                     else if ( nCmpId == 65 )
                     {
                        OldPagowc = httpContext.cgiGet( "W0065") ;
                        if ( ( GXutil.len( OldPagowc) == 0 ) || ( GXutil.strcmp(OldPagowc, WebComp_Pagowc_Component) != 0 ) )
                        {
                           WebComp_Pagowc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldPagowc + "_impl", remoteHandle, context);
                           WebComp_Pagowc_Component = OldPagowc ;
                        }
                        if ( GXutil.len( WebComp_Pagowc_Component) != 0 )
                        {
                           WebComp_Pagowc.componentprocess("W0065", "", sEvt);
                        }
                        WebComp_Pagowc_Component = OldPagowc ;
                     }
                     else if ( nCmpId == 73 )
                     {
                        OldRecetamedicawc = httpContext.cgiGet( "W0073") ;
                        if ( ( GXutil.len( OldRecetamedicawc) == 0 ) || ( GXutil.strcmp(OldRecetamedicawc, WebComp_Recetamedicawc_Component) != 0 ) )
                        {
                           WebComp_Recetamedicawc = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldRecetamedicawc + "_impl", remoteHandle, context);
                           WebComp_Recetamedicawc_Component = OldRecetamedicawc ;
                        }
                        if ( GXutil.len( WebComp_Recetamedicawc_Component) != 0 )
                        {
                           WebComp_Recetamedicawc.componentprocess("W0073", "", sEvt);
                        }
                        WebComp_Recetamedicawc_Component = OldRecetamedicawc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1G2( )
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

   public void pa1G2( )
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
      rf1G2( ) ;
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

   public void rf1G2( )
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
            if ( GXutil.len( WebComp_Citadiagnosticowc_Component) != 0 )
            {
               WebComp_Citadiagnosticowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Citarecetawc_Component) != 0 )
            {
               WebComp_Citarecetawc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Citaserviciowc_Component) != 0 )
            {
               WebComp_Citaserviciowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Encuestawc_Component) != 0 )
            {
               WebComp_Encuestawc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Pagowc_Component) != 0 )
            {
               WebComp_Pagowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Recetamedicawc_Component) != 0 )
            {
               WebComp_Recetamedicawc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e131G2 ();
         wb1G0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1G2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1G0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e121G2 ();
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
      e121G2 ();
      if (returnInSub) return;
   }

   public void e121G2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      lblWorkwithlink_Link = formatLink("com.projectthani.citaww", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblWorkwithlink_Internalname, "Link", lblWorkwithlink_Link, true);
      AV18GXLvl9 = (byte)(0) ;
      /* Using cursor H001G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19CitaId = H001G2_A19CitaId[0] ;
         A64CitaCode = H001G2_A64CitaCode[0] ;
         AV18GXLvl9 = (byte)(1) ;
         Form.setCaption( A64CitaCode );
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

   protected void e131G2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void e111G2( )
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
      if ( GXutil.strcmp(GXutil.lower( WebComp_Webcomponent_general_Component), GXutil.lower( "CitaGeneral")) != 0 )
      {
         WebComp_Webcomponent_general = WebUtils.getWebComponent(getClass(), "com.projectthani.citageneral_impl", remoteHandle, context);
         WebComp_Webcomponent_general_Component = "CitaGeneral" ;
      }
      if ( GXutil.len( WebComp_Webcomponent_general_Component) != 0 )
      {
         WebComp_Webcomponent_general.setjustcreated();
         WebComp_Webcomponent_general.componentprepare(new Object[] {"W0019","",Integer.valueOf(AV10CitaId)});
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
      /* Using cursor H001G3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CitaId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A19CitaId = H001G3_A19CitaId[0] ;
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV12SelectedTabCode, "CitaDiagnostico") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Citadiagnosticowc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Citadiagnosticowc_Component), GXutil.lower( "CitaCitaDiagnosticoWC")) != 0 )
            {
               WebComp_Citadiagnosticowc = WebUtils.getWebComponent(getClass(), "com.projectthani.citacitadiagnosticowc_impl", remoteHandle, context);
               WebComp_Citadiagnosticowc_Component = "CitaCitaDiagnosticoWC" ;
            }
            if ( GXutil.len( WebComp_Citadiagnosticowc_Component) != 0 )
            {
               WebComp_Citadiagnosticowc.setjustcreated();
               WebComp_Citadiagnosticowc.componentprepare(new Object[] {"W0033","",Integer.valueOf(AV10CitaId)});
               WebComp_Citadiagnosticowc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Citadiagnosticowc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0033"+"");
               WebComp_Citadiagnosticowc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "CitaReceta") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Citarecetawc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Citarecetawc_Component), GXutil.lower( "CitaCitaRecetaWC")) != 0 )
            {
               WebComp_Citarecetawc = WebUtils.getWebComponent(getClass(), "com.projectthani.citacitarecetawc_impl", remoteHandle, context);
               WebComp_Citarecetawc_Component = "CitaCitaRecetaWC" ;
            }
            if ( GXutil.len( WebComp_Citarecetawc_Component) != 0 )
            {
               WebComp_Citarecetawc.setjustcreated();
               WebComp_Citarecetawc.componentprepare(new Object[] {"W0041","",Integer.valueOf(AV10CitaId)});
               WebComp_Citarecetawc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Citarecetawc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0041"+"");
               WebComp_Citarecetawc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "CitaServicio") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Citaserviciowc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Citaserviciowc_Component), GXutil.lower( "CitaCitaServicioWC")) != 0 )
            {
               WebComp_Citaserviciowc = WebUtils.getWebComponent(getClass(), "com.projectthani.citacitaserviciowc_impl", remoteHandle, context);
               WebComp_Citaserviciowc_Component = "CitaCitaServicioWC" ;
            }
            if ( GXutil.len( WebComp_Citaserviciowc_Component) != 0 )
            {
               WebComp_Citaserviciowc.setjustcreated();
               WebComp_Citaserviciowc.componentprepare(new Object[] {"W0049","",Integer.valueOf(AV10CitaId)});
               WebComp_Citaserviciowc.componentbind(new Object[] {""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Citaserviciowc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
               WebComp_Citaserviciowc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         GXt_boolean2 = AV13TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta", GXv_boolean3) ;
         citaview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13TempBoolean = GXt_boolean2 ;
         if ( AV13TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "Encuesta") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Encuestawc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Encuestawc_Component), GXutil.lower( "CitaEncuestaWC")) != 0 )
               {
                  WebComp_Encuestawc = WebUtils.getWebComponent(getClass(), "com.projectthani.citaencuestawc_impl", remoteHandle, context);
                  WebComp_Encuestawc_Component = "CitaEncuestaWC" ;
               }
               if ( GXutil.len( WebComp_Encuestawc_Component) != 0 )
               {
                  WebComp_Encuestawc.setjustcreated();
                  WebComp_Encuestawc.componentprepare(new Object[] {"W0057","",Integer.valueOf(AV10CitaId)});
                  WebComp_Encuestawc.componentbind(new Object[] {""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Encuestawc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0057"+"");
                  WebComp_Encuestawc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(4)});
         }
         GXt_boolean2 = AV13TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago", GXv_boolean3) ;
         citaview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13TempBoolean = GXt_boolean2 ;
         if ( AV13TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "Pago") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Pagowc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Pagowc_Component), GXutil.lower( "CitaPagoWC")) != 0 )
               {
                  WebComp_Pagowc = WebUtils.getWebComponent(getClass(), "com.projectthani.citapagowc_impl", remoteHandle, context);
                  WebComp_Pagowc_Component = "CitaPagoWC" ;
               }
               if ( GXutil.len( WebComp_Pagowc_Component) != 0 )
               {
                  WebComp_Pagowc.setjustcreated();
                  WebComp_Pagowc.componentprepare(new Object[] {"W0065","",Integer.valueOf(AV10CitaId)});
                  WebComp_Pagowc.componentbind(new Object[] {""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Pagowc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0065"+"");
                  WebComp_Pagowc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(5)});
         }
         GXt_boolean2 = AV13TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica", GXv_boolean3) ;
         citaview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13TempBoolean = GXt_boolean2 ;
         if ( AV13TempBoolean )
         {
            if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "RecetaMedica") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Recetamedicawc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Recetamedicawc_Component), GXutil.lower( "CitaRecetaMedicaWC")) != 0 )
               {
                  WebComp_Recetamedicawc = WebUtils.getWebComponent(getClass(), "com.projectthani.citarecetamedicawc_impl", remoteHandle, context);
                  WebComp_Recetamedicawc_Component = "CitaRecetaMedicaWC" ;
               }
               if ( GXutil.len( WebComp_Recetamedicawc_Component) != 0 )
               {
                  WebComp_Recetamedicawc.setjustcreated();
                  WebComp_Recetamedicawc.componentprepare(new Object[] {"W0073","",Integer.valueOf(AV10CitaId)});
                  WebComp_Recetamedicawc.componentbind(new Object[] {""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Recetamedicawc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0073"+"");
                  WebComp_Recetamedicawc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(6)});
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CitaId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10CitaId), "ZZZZZZZ9")));
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
      pa1G2( ) ;
      ws1G2( ) ;
      we1G2( ) ;
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
      if ( ! ( WebComp_Citadiagnosticowc == null ) )
      {
         if ( GXutil.len( WebComp_Citadiagnosticowc_Component) != 0 )
         {
            WebComp_Citadiagnosticowc.componentthemes();
         }
      }
      if ( ! ( WebComp_Citarecetawc == null ) )
      {
         if ( GXutil.len( WebComp_Citarecetawc_Component) != 0 )
         {
            WebComp_Citarecetawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Citaserviciowc == null ) )
      {
         if ( GXutil.len( WebComp_Citaserviciowc_Component) != 0 )
         {
            WebComp_Citaserviciowc.componentthemes();
         }
      }
      if ( ! ( WebComp_Encuestawc == null ) )
      {
         if ( GXutil.len( WebComp_Encuestawc_Component) != 0 )
         {
            WebComp_Encuestawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Pagowc == null ) )
      {
         if ( GXutil.len( WebComp_Pagowc_Component) != 0 )
         {
            WebComp_Pagowc.componentthemes();
         }
      }
      if ( ! ( WebComp_Recetamedicawc == null ) )
      {
         if ( GXutil.len( WebComp_Recetamedicawc_Component) != 0 )
         {
            WebComp_Recetamedicawc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331467", true, true);
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
      httpContext.AddJavascriptSource("citaview.js", "?20225110331467", false, true);
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
      divCitageneral_cell_Internalname = "CITAGENERAL_CELL" ;
      lblCitadiagnostico_title_Internalname = "CITADIAGNOSTICO_TITLE" ;
      divUnnamedtablecitadiagnostico_Internalname = "UNNAMEDTABLECITADIAGNOSTICO" ;
      lblCitareceta_title_Internalname = "CITARECETA_TITLE" ;
      divUnnamedtablecitareceta_Internalname = "UNNAMEDTABLECITARECETA" ;
      lblCitaservicio_title_Internalname = "CITASERVICIO_TITLE" ;
      divUnnamedtablecitaservicio_Internalname = "UNNAMEDTABLECITASERVICIO" ;
      lblEncuesta_title_Internalname = "ENCUESTA_TITLE" ;
      divUnnamedtableencuesta_Internalname = "UNNAMEDTABLEENCUESTA" ;
      lblPago_title_Internalname = "PAGO_TITLE" ;
      divUnnamedtablepago_Internalname = "UNNAMEDTABLEPAGO" ;
      lblRecetamedica_title_Internalname = "RECETAMEDICA_TITLE" ;
      divUnnamedtablerecetamedica_Internalname = "UNNAMEDTABLERECETAMEDICA" ;
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
      Tabs_Pagecount = 6 ;
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
      Form.setCaption( "Cita View" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e111G2',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'AV10CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV12SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV11LoadAllTabs',fld:'vLOADALLTABS',pic:''},{ctrl:'CITADIAGNOSTICOWC'},{ctrl:'CITARECETAWC'},{ctrl:'CITASERVICIOWC'},{ctrl:'ENCUESTAWC'},{ctrl:'PAGOWC'},{ctrl:'RECETAMEDICAWC'}]}");
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
      lblCitadiagnostico_title_Jsonclick = "" ;
      WebComp_Citadiagnosticowc_Component = "" ;
      OldCitadiagnosticowc = "" ;
      lblCitareceta_title_Jsonclick = "" ;
      WebComp_Citarecetawc_Component = "" ;
      OldCitarecetawc = "" ;
      lblCitaservicio_title_Jsonclick = "" ;
      WebComp_Citaserviciowc_Component = "" ;
      OldCitaserviciowc = "" ;
      lblEncuesta_title_Jsonclick = "" ;
      WebComp_Encuestawc_Component = "" ;
      OldEncuestawc = "" ;
      lblPago_title_Jsonclick = "" ;
      WebComp_Pagowc_Component = "" ;
      OldPagowc = "" ;
      lblRecetamedica_title_Jsonclick = "" ;
      WebComp_Recetamedicawc_Component = "" ;
      OldRecetamedicawc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H001G2_A19CitaId = new int[1] ;
      H001G2_A64CitaCode = new String[] {""} ;
      A64CitaCode = "" ;
      H001G3_A19CitaId = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citaview__default(),
         new Object[] {
             new Object[] {
            H001G2_A19CitaId, H001G2_A64CitaCode
            }
            , new Object[] {
            H001G3_A19CitaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Webcomponent_general = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Citadiagnosticowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Citarecetawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Citaserviciowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Encuestawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Pagowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Recetamedicawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
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
   private int wcpOAV10CitaId ;
   private int AV10CitaId ;
   private int A19CitaId ;
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
   private String divCitageneral_cell_Internalname ;
   private String Panel_general_Internalname ;
   private String divTablepanel_general_Internalname ;
   private String WebComp_Webcomponent_general_Component ;
   private String OldWebcomponent_general ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String Tabs_Internalname ;
   private String lblCitadiagnostico_title_Internalname ;
   private String lblCitadiagnostico_title_Jsonclick ;
   private String divUnnamedtablecitadiagnostico_Internalname ;
   private String WebComp_Citadiagnosticowc_Component ;
   private String OldCitadiagnosticowc ;
   private String lblCitareceta_title_Internalname ;
   private String lblCitareceta_title_Jsonclick ;
   private String divUnnamedtablecitareceta_Internalname ;
   private String WebComp_Citarecetawc_Component ;
   private String OldCitarecetawc ;
   private String lblCitaservicio_title_Internalname ;
   private String lblCitaservicio_title_Jsonclick ;
   private String divUnnamedtablecitaservicio_Internalname ;
   private String WebComp_Citaserviciowc_Component ;
   private String OldCitaserviciowc ;
   private String lblEncuesta_title_Internalname ;
   private String lblEncuesta_title_Jsonclick ;
   private String divUnnamedtableencuesta_Internalname ;
   private String WebComp_Encuestawc_Component ;
   private String OldEncuestawc ;
   private String lblPago_title_Internalname ;
   private String lblPago_title_Jsonclick ;
   private String divUnnamedtablepago_Internalname ;
   private String WebComp_Pagowc_Component ;
   private String OldPagowc ;
   private String lblRecetamedica_title_Internalname ;
   private String lblRecetamedica_title_Jsonclick ;
   private String divUnnamedtablerecetamedica_Internalname ;
   private String WebComp_Recetamedicawc_Component ;
   private String OldRecetamedicawc ;
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
   private boolean bDynCreated_Citadiagnosticowc ;
   private boolean bDynCreated_Citarecetawc ;
   private boolean bDynCreated_Citaserviciowc ;
   private boolean AV13TempBoolean ;
   private boolean bDynCreated_Encuestawc ;
   private boolean bDynCreated_Pagowc ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean bDynCreated_Recetamedicawc ;
   private String A64CitaCode ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Webcomponent_general ;
   private GXWebComponent WebComp_Citadiagnosticowc ;
   private GXWebComponent WebComp_Citarecetawc ;
   private GXWebComponent WebComp_Citaserviciowc ;
   private GXWebComponent WebComp_Encuestawc ;
   private GXWebComponent WebComp_Pagowc ;
   private GXWebComponent WebComp_Recetamedicawc ;
   private com.genexus.webpanels.GXUserControl ucPanel_general ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private int[] H001G2_A19CitaId ;
   private String[] H001G2_A64CitaCode ;
   private int[] H001G3_A19CitaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class citaview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001G2", "SELECT [CitaId], [CitaCode] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H001G3", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

