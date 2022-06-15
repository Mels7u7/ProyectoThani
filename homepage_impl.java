package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class homepage_impl extends GXDataArea
{
   public homepage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public homepage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( homepage_impl.class ));
   }

   public homepage_impl( int remoteHandle ,
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
      pa5O2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start5O2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110335232", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.homepage", new String[] {}, new String[] {}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Width", GXutil.rtrim( Dvpanel_card1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Autowidth", GXutil.booltostr( Dvpanel_card1_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Autoheight", GXutil.booltostr( Dvpanel_card1_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Cls", GXutil.rtrim( Dvpanel_card1_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Title", GXutil.rtrim( Dvpanel_card1_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Collapsible", GXutil.booltostr( Dvpanel_card1_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Collapsed", GXutil.booltostr( Dvpanel_card1_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Showcollapseicon", GXutil.booltostr( Dvpanel_card1_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Iconposition", GXutil.rtrim( Dvpanel_card1_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD1_Autoscroll", GXutil.booltostr( Dvpanel_card1_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Width", GXutil.rtrim( Dvpanel_card2_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Autowidth", GXutil.booltostr( Dvpanel_card2_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Autoheight", GXutil.booltostr( Dvpanel_card2_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Cls", GXutil.rtrim( Dvpanel_card2_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Title", GXutil.rtrim( Dvpanel_card2_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Collapsible", GXutil.booltostr( Dvpanel_card2_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Collapsed", GXutil.booltostr( Dvpanel_card2_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Showcollapseicon", GXutil.booltostr( Dvpanel_card2_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Iconposition", GXutil.rtrim( Dvpanel_card2_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD2_Autoscroll", GXutil.booltostr( Dvpanel_card2_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Width", GXutil.rtrim( Dvpanel_cardcalificacion_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Autowidth", GXutil.booltostr( Dvpanel_cardcalificacion_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Autoheight", GXutil.booltostr( Dvpanel_cardcalificacion_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Cls", GXutil.rtrim( Dvpanel_cardcalificacion_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Title", GXutil.rtrim( Dvpanel_cardcalificacion_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Collapsible", GXutil.booltostr( Dvpanel_cardcalificacion_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Collapsed", GXutil.booltostr( Dvpanel_cardcalificacion_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Showcollapseicon", GXutil.booltostr( Dvpanel_cardcalificacion_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Iconposition", GXutil.rtrim( Dvpanel_cardcalificacion_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCALIFICACION_Autoscroll", GXutil.booltostr( Dvpanel_cardcalificacion_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Width", GXutil.rtrim( Dvpanel_cardcomentarios_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Autowidth", GXutil.booltostr( Dvpanel_cardcomentarios_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Autoheight", GXutil.booltostr( Dvpanel_cardcomentarios_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Cls", GXutil.rtrim( Dvpanel_cardcomentarios_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Title", GXutil.rtrim( Dvpanel_cardcomentarios_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Collapsible", GXutil.booltostr( Dvpanel_cardcomentarios_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Collapsed", GXutil.booltostr( Dvpanel_cardcomentarios_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_cardcomentarios_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Iconposition", GXutil.rtrim( Dvpanel_cardcomentarios_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARDCOMENTARIOS_Autoscroll", GXutil.booltostr( Dvpanel_cardcomentarios_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Width", GXutil.rtrim( Dvpanel_card3_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Autowidth", GXutil.booltostr( Dvpanel_card3_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Autoheight", GXutil.booltostr( Dvpanel_card3_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Cls", GXutil.rtrim( Dvpanel_card3_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Title", GXutil.rtrim( Dvpanel_card3_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Collapsible", GXutil.booltostr( Dvpanel_card3_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Collapsed", GXutil.booltostr( Dvpanel_card3_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Showcollapseicon", GXutil.booltostr( Dvpanel_card3_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Iconposition", GXutil.rtrim( Dvpanel_card3_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD3_Autoscroll", GXutil.booltostr( Dvpanel_card3_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Width", GXutil.rtrim( Dvpanel_card4_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Autowidth", GXutil.booltostr( Dvpanel_card4_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Autoheight", GXutil.booltostr( Dvpanel_card4_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Cls", GXutil.rtrim( Dvpanel_card4_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Title", GXutil.rtrim( Dvpanel_card4_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Collapsible", GXutil.booltostr( Dvpanel_card4_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Collapsed", GXutil.booltostr( Dvpanel_card4_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Showcollapseicon", GXutil.booltostr( Dvpanel_card4_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Iconposition", GXutil.rtrim( Dvpanel_card4_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CARD4_Autoscroll", GXutil.booltostr( Dvpanel_card4_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
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
         we5O2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt5O2( ) ;
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
      return formatLink("com.projectthani.homepage", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "HomePage" ;
   }

   public String getPgmdesc( )
   {
      return "Home" ;
   }

   public void wb5O0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecards1_Internalname, divTablecards1_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-lg-3 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_card1.setProperty("Width", Dvpanel_card1_Width);
         ucDvpanel_card1.setProperty("AutoWidth", Dvpanel_card1_Autowidth);
         ucDvpanel_card1.setProperty("AutoHeight", Dvpanel_card1_Autoheight);
         ucDvpanel_card1.setProperty("Cls", Dvpanel_card1_Cls);
         ucDvpanel_card1.setProperty("Title", Dvpanel_card1_Title);
         ucDvpanel_card1.setProperty("Collapsible", Dvpanel_card1_Collapsible);
         ucDvpanel_card1.setProperty("Collapsed", Dvpanel_card1_Collapsed);
         ucDvpanel_card1.setProperty("ShowCollapseIcon", Dvpanel_card1_Showcollapseicon);
         ucDvpanel_card1.setProperty("IconPosition", Dvpanel_card1_Iconposition);
         ucDvpanel_card1.setProperty("AutoScroll", Dvpanel_card1_Autoscroll);
         ucDvpanel_card1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_card1_Internalname, "DVPANEL_CARD1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CARD1Container"+"Card1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 SimpleCardIconPadding", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon1_Internalname, "<i class='fas fa-stethoscope ProgressCardIconWarning' style='font-size: 50px'></i>", "", "", lblIcon1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecard1info_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard1_Internalname, "Citas Hoy", "", "", lblDescriptioncard1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecardcitahoy_Internalname, "Value Card Cita Hoy", "gx-form-item DashboardNumberCardLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecardcitahoy_Internalname, GXutil.ltrim( localUtil.ntoc( AV17ValueCardCitaHoy, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecardcitahoy_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV17ValueCardCitaHoy), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV17ValueCardCitaHoy), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,24);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecardcitahoy_Jsonclick, 0, "DashboardNumberCard", "", "", "", "", 1, edtavValuecardcitahoy_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MoreInfoCardCell", "left", "top", "", "", "div");
         wb_table1_27_5O2( true) ;
      }
      else
      {
         wb_table1_27_5O2( false) ;
      }
      return  ;
   }

   public void wb_table1_27_5O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-lg-3 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_card2.setProperty("Width", Dvpanel_card2_Width);
         ucDvpanel_card2.setProperty("AutoWidth", Dvpanel_card2_Autowidth);
         ucDvpanel_card2.setProperty("AutoHeight", Dvpanel_card2_Autoheight);
         ucDvpanel_card2.setProperty("Cls", Dvpanel_card2_Cls);
         ucDvpanel_card2.setProperty("Title", Dvpanel_card2_Title);
         ucDvpanel_card2.setProperty("Collapsible", Dvpanel_card2_Collapsible);
         ucDvpanel_card2.setProperty("Collapsed", Dvpanel_card2_Collapsed);
         ucDvpanel_card2.setProperty("ShowCollapseIcon", Dvpanel_card2_Showcollapseicon);
         ucDvpanel_card2.setProperty("IconPosition", Dvpanel_card2_Iconposition);
         ucDvpanel_card2.setProperty("AutoScroll", Dvpanel_card2_Autoscroll);
         ucDvpanel_card2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_card2_Internalname, "DVPANEL_CARD2Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CARD2Container"+"Card2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 SimpleCardIconPadding", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon2_Internalname, "<i class='fas fa-hospital-alt ProgressCardIconSuccess' style='font-size: 50px'></i>", "", "", lblIcon2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecard2info_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard2_Internalname, "Citas", "", "", lblDescriptioncard2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecardcitas_Internalname, "Value Card Citas", "gx-form-item DashboardNumberCardLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecardcitas_Internalname, GXutil.ltrim( localUtil.ntoc( AV18ValueCardCitas, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecardcitas_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV18ValueCardCitas), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV18ValueCardCitas), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,46);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecardcitas_Jsonclick, 0, "DashboardNumberCard", "", "", "", "", 1, edtavValuecardcitas_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MoreInfoCardCell", "left", "top", "", "", "div");
         wb_table2_49_5O2( true) ;
      }
      else
      {
         wb_table2_49_5O2( false) ;
      }
      return  ;
   }

   public void wb_table2_49_5O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-lg-3 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_cardcalificacion.setProperty("Width", Dvpanel_cardcalificacion_Width);
         ucDvpanel_cardcalificacion.setProperty("AutoWidth", Dvpanel_cardcalificacion_Autowidth);
         ucDvpanel_cardcalificacion.setProperty("AutoHeight", Dvpanel_cardcalificacion_Autoheight);
         ucDvpanel_cardcalificacion.setProperty("Cls", Dvpanel_cardcalificacion_Cls);
         ucDvpanel_cardcalificacion.setProperty("Title", Dvpanel_cardcalificacion_Title);
         ucDvpanel_cardcalificacion.setProperty("Collapsible", Dvpanel_cardcalificacion_Collapsible);
         ucDvpanel_cardcalificacion.setProperty("Collapsed", Dvpanel_cardcalificacion_Collapsed);
         ucDvpanel_cardcalificacion.setProperty("ShowCollapseIcon", Dvpanel_cardcalificacion_Showcollapseicon);
         ucDvpanel_cardcalificacion.setProperty("IconPosition", Dvpanel_cardcalificacion_Iconposition);
         ucDvpanel_cardcalificacion.setProperty("AutoScroll", Dvpanel_cardcalificacion_Autoscroll);
         ucDvpanel_cardcalificacion.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_cardcalificacion_Internalname, "DVPANEL_CARDCALIFICACIONContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CARDCALIFICACIONContainer"+"CardCalificacion"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCardcalificacion_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 SimpleCardIconPadding", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIconcalificacion_Internalname, "<i class='fas fa-star-half-alt  ProgressCardIconWarning' style='font-size: 50px'></i>", "", "", lblIconcalificacion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecardcalificacion_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncardtexblock_Internalname, "Calificacion", "", "", lblDescriptioncardtexblock_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecardcalificacion_Internalname, "Value Card Calificacion", "gx-form-item DashboardNumberCardLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecardcalificacion_Internalname, GXutil.ltrim( localUtil.ntoc( AV16ValueCardCalificacion, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecardcalificacion_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV16ValueCardCalificacion), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV16ValueCardCalificacion), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecardcalificacion_Jsonclick, 0, "DashboardNumberCard", "", "", "", "", 1, edtavValuecardcalificacion_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MoreInfoCardCell", "left", "top", "", "", "div");
         wb_table3_71_5O2( true) ;
      }
      else
      {
         wb_table3_71_5O2( false) ;
      }
      return  ;
   }

   public void wb_table3_71_5O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-lg-3 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_cardcomentarios.setProperty("Width", Dvpanel_cardcomentarios_Width);
         ucDvpanel_cardcomentarios.setProperty("AutoWidth", Dvpanel_cardcomentarios_Autowidth);
         ucDvpanel_cardcomentarios.setProperty("AutoHeight", Dvpanel_cardcomentarios_Autoheight);
         ucDvpanel_cardcomentarios.setProperty("Cls", Dvpanel_cardcomentarios_Cls);
         ucDvpanel_cardcomentarios.setProperty("Title", Dvpanel_cardcomentarios_Title);
         ucDvpanel_cardcomentarios.setProperty("Collapsible", Dvpanel_cardcomentarios_Collapsible);
         ucDvpanel_cardcomentarios.setProperty("Collapsed", Dvpanel_cardcomentarios_Collapsed);
         ucDvpanel_cardcomentarios.setProperty("ShowCollapseIcon", Dvpanel_cardcomentarios_Showcollapseicon);
         ucDvpanel_cardcomentarios.setProperty("IconPosition", Dvpanel_cardcomentarios_Iconposition);
         ucDvpanel_cardcomentarios.setProperty("AutoScroll", Dvpanel_cardcomentarios_Autoscroll);
         ucDvpanel_cardcomentarios.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_cardcomentarios_Internalname, "DVPANEL_CARDCOMENTARIOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CARDCOMENTARIOSContainer"+"CardComentarios"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCardcomentarios_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 SimpleCardIconPadding", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIconcomentarios_Internalname, "<i class='far fa-comment-dots ProgressCardIconBlack' style='font-size: 50px'></i>", "", "", lblIconcomentarios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecardcomentarios_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncardcalificacion_Internalname, "Comentarios", "", "", lblDescriptioncardcalificacion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecardcomentarios_Internalname, "Value Card Comentarios", "gx-form-item DashboardNumberCardLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecardcomentarios_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ValueCardComentarios, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecardcomentarios_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ValueCardComentarios), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ValueCardComentarios), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,90);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecardcomentarios_Jsonclick, 0, "DashboardNumberCard", "", "", "", "", 1, edtavValuecardcomentarios_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MoreInfoCardCell", "left", "top", "", "", "div");
         wb_table4_93_5O2( true) ;
      }
      else
      {
         wb_table4_93_5O2( false) ;
      }
      return  ;
   }

   public void wb_table4_93_5O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecards2_Internalname, divTablecards2_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecar21_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-lg-3 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_card3.setProperty("Width", Dvpanel_card3_Width);
         ucDvpanel_card3.setProperty("AutoWidth", Dvpanel_card3_Autowidth);
         ucDvpanel_card3.setProperty("AutoHeight", Dvpanel_card3_Autoheight);
         ucDvpanel_card3.setProperty("Cls", Dvpanel_card3_Cls);
         ucDvpanel_card3.setProperty("Title", Dvpanel_card3_Title);
         ucDvpanel_card3.setProperty("Collapsible", Dvpanel_card3_Collapsible);
         ucDvpanel_card3.setProperty("Collapsed", Dvpanel_card3_Collapsed);
         ucDvpanel_card3.setProperty("ShowCollapseIcon", Dvpanel_card3_Showcollapseicon);
         ucDvpanel_card3.setProperty("IconPosition", Dvpanel_card3_Iconposition);
         ucDvpanel_card3.setProperty("AutoScroll", Dvpanel_card3_Autoscroll);
         ucDvpanel_card3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_card3_Internalname, "DVPANEL_CARD3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CARD3Container"+"Card3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 SimpleCardIconPadding", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon3_Internalname, "<i class='fa fa-procedures  ProgressCardIconInfo' style='font-size: 50px'></i>", "", "", lblIcon3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecard3info_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard3_Internalname, "Pacientes", "", "", lblDescriptioncard3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecardpacientes_Internalname, "Value Card Pacientes", "gx-form-item DashboardNumberCardLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecardpacientes_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ValueCardPacientes, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecardpacientes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ValueCardPacientes), "ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ValueCardPacientes), "ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,118);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecardpacientes_Jsonclick, 0, "DashboardNumberCard", "", "", "", "", 1, edtavValuecardpacientes_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPINumericValue", "right", false, "", "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MoreInfoCardCell", "left", "top", "", "", "div");
         wb_table5_121_5O2( true) ;
      }
      else
      {
         wb_table5_121_5O2( false) ;
      }
      return  ;
   }

   public void wb_table5_121_5O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-lg-3 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_card4.setProperty("Width", Dvpanel_card4_Width);
         ucDvpanel_card4.setProperty("AutoWidth", Dvpanel_card4_Autowidth);
         ucDvpanel_card4.setProperty("AutoHeight", Dvpanel_card4_Autoheight);
         ucDvpanel_card4.setProperty("Cls", Dvpanel_card4_Cls);
         ucDvpanel_card4.setProperty("Title", Dvpanel_card4_Title);
         ucDvpanel_card4.setProperty("Collapsible", Dvpanel_card4_Collapsible);
         ucDvpanel_card4.setProperty("Collapsed", Dvpanel_card4_Collapsed);
         ucDvpanel_card4.setProperty("ShowCollapseIcon", Dvpanel_card4_Showcollapseicon);
         ucDvpanel_card4.setProperty("IconPosition", Dvpanel_card4_Iconposition);
         ucDvpanel_card4.setProperty("AutoScroll", Dvpanel_card4_Autoscroll);
         ucDvpanel_card4.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_card4_Internalname, "DVPANEL_CARD4Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CARD4Container"+"Card4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divCard4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 SimpleCardIconPadding", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIcon4_Internalname, "<i class='fas fa-money-check-alt  ProgressCardIconDanger' style='font-size: 50px'></i>", "", "", lblIcon4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecard4info_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDescriptioncard4_Internalname, "Ganancia", "", "", lblDescriptioncard4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockDashboardDescriptionCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavValuecardganancia_Internalname, "Value Card Ganancia", "gx-form-item DashboardNumberCardLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavValuecardganancia_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ValueCardGanancia, (byte)(11), (byte)(0), ",", "")), GXutil.ltrim( ((edtavValuecardganancia_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ValueCardGanancia), "$ZZ,ZZZ,ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ValueCardGanancia), "$ZZ,ZZZ,ZZ9"))), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,140);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValuecardganancia_Jsonclick, 0, "DashboardNumberCard", "", "", "", "", 1, edtavValuecardganancia_Enabled, 0, "text", "", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "KPIPrice", "right", false, "", "HLP_HomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MoreInfoCardCell", "left", "top", "", "", "div");
         wb_table6_143_5O2( true) ;
      }
      else
      {
         wb_table6_143_5O2( false) ;
      }
      return  ;
   }

   public void wb_table6_143_5O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecar22_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecards3_Internalname, divTablecards3_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         wb_table7_158_5O2( true) ;
      }
      else
      {
         wb_table7_158_5O2( false) ;
      }
      return  ;
   }

   public void wb_table7_158_5O2e( boolean wbgen )
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

   public void start5O2( )
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
         Form.getMeta().addItem("description", "Home", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup5O0( ) ;
   }

   public void ws5O2( )
   {
      start5O2( ) ;
      evt5O2( ) ;
   }

   public void evt5O2( )
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
                           e115O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e125O2 ();
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

   public void we5O2( )
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

   public void pa5O2( )
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
            GX_FocusControl = edtavValuecardcitahoy_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      rf5O2( ) ;
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
      edtavValuecardcitahoy_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcitahoy_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcitahoy_Enabled), 5, 0), true);
      edtavValuecardcitas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcitas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcitas_Enabled), 5, 0), true);
      edtavValuecardcalificacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcalificacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcalificacion_Enabled), 5, 0), true);
      edtavValuecardcomentarios_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcomentarios_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcomentarios_Enabled), 5, 0), true);
      edtavValuecardpacientes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardpacientes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardpacientes_Enabled), 5, 0), true);
      edtavValuecardganancia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardganancia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardganancia_Enabled), 5, 0), true);
   }

   public void rf5O2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e125O2 ();
         wb5O0( ) ;
      }
   }

   public void send_integrity_lvl_hashes5O2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavValuecardcitahoy_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcitahoy_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcitahoy_Enabled), 5, 0), true);
      edtavValuecardcitas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcitas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcitas_Enabled), 5, 0), true);
      edtavValuecardcalificacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcalificacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcalificacion_Enabled), 5, 0), true);
      edtavValuecardcomentarios_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardcomentarios_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardcomentarios_Enabled), 5, 0), true);
      edtavValuecardpacientes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardpacientes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardpacientes_Enabled), 5, 0), true);
      edtavValuecardganancia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValuecardganancia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValuecardganancia_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup5O0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e115O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Dvpanel_card1_Width = httpContext.cgiGet( "DVPANEL_CARD1_Width") ;
         Dvpanel_card1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD1_Autowidth")) ;
         Dvpanel_card1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD1_Autoheight")) ;
         Dvpanel_card1_Cls = httpContext.cgiGet( "DVPANEL_CARD1_Cls") ;
         Dvpanel_card1_Title = httpContext.cgiGet( "DVPANEL_CARD1_Title") ;
         Dvpanel_card1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD1_Collapsible")) ;
         Dvpanel_card1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD1_Collapsed")) ;
         Dvpanel_card1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD1_Showcollapseicon")) ;
         Dvpanel_card1_Iconposition = httpContext.cgiGet( "DVPANEL_CARD1_Iconposition") ;
         Dvpanel_card1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD1_Autoscroll")) ;
         Dvpanel_card2_Width = httpContext.cgiGet( "DVPANEL_CARD2_Width") ;
         Dvpanel_card2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD2_Autowidth")) ;
         Dvpanel_card2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD2_Autoheight")) ;
         Dvpanel_card2_Cls = httpContext.cgiGet( "DVPANEL_CARD2_Cls") ;
         Dvpanel_card2_Title = httpContext.cgiGet( "DVPANEL_CARD2_Title") ;
         Dvpanel_card2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD2_Collapsible")) ;
         Dvpanel_card2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD2_Collapsed")) ;
         Dvpanel_card2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD2_Showcollapseicon")) ;
         Dvpanel_card2_Iconposition = httpContext.cgiGet( "DVPANEL_CARD2_Iconposition") ;
         Dvpanel_card2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD2_Autoscroll")) ;
         Dvpanel_cardcalificacion_Width = httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Width") ;
         Dvpanel_cardcalificacion_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Autowidth")) ;
         Dvpanel_cardcalificacion_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Autoheight")) ;
         Dvpanel_cardcalificacion_Cls = httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Cls") ;
         Dvpanel_cardcalificacion_Title = httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Title") ;
         Dvpanel_cardcalificacion_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Collapsible")) ;
         Dvpanel_cardcalificacion_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Collapsed")) ;
         Dvpanel_cardcalificacion_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Showcollapseicon")) ;
         Dvpanel_cardcalificacion_Iconposition = httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Iconposition") ;
         Dvpanel_cardcalificacion_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCALIFICACION_Autoscroll")) ;
         Dvpanel_cardcomentarios_Width = httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Width") ;
         Dvpanel_cardcomentarios_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Autowidth")) ;
         Dvpanel_cardcomentarios_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Autoheight")) ;
         Dvpanel_cardcomentarios_Cls = httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Cls") ;
         Dvpanel_cardcomentarios_Title = httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Title") ;
         Dvpanel_cardcomentarios_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Collapsible")) ;
         Dvpanel_cardcomentarios_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Collapsed")) ;
         Dvpanel_cardcomentarios_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Showcollapseicon")) ;
         Dvpanel_cardcomentarios_Iconposition = httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Iconposition") ;
         Dvpanel_cardcomentarios_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARDCOMENTARIOS_Autoscroll")) ;
         Dvpanel_card3_Width = httpContext.cgiGet( "DVPANEL_CARD3_Width") ;
         Dvpanel_card3_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD3_Autowidth")) ;
         Dvpanel_card3_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD3_Autoheight")) ;
         Dvpanel_card3_Cls = httpContext.cgiGet( "DVPANEL_CARD3_Cls") ;
         Dvpanel_card3_Title = httpContext.cgiGet( "DVPANEL_CARD3_Title") ;
         Dvpanel_card3_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD3_Collapsible")) ;
         Dvpanel_card3_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD3_Collapsed")) ;
         Dvpanel_card3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD3_Showcollapseicon")) ;
         Dvpanel_card3_Iconposition = httpContext.cgiGet( "DVPANEL_CARD3_Iconposition") ;
         Dvpanel_card3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD3_Autoscroll")) ;
         Dvpanel_card4_Width = httpContext.cgiGet( "DVPANEL_CARD4_Width") ;
         Dvpanel_card4_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD4_Autowidth")) ;
         Dvpanel_card4_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD4_Autoheight")) ;
         Dvpanel_card4_Cls = httpContext.cgiGet( "DVPANEL_CARD4_Cls") ;
         Dvpanel_card4_Title = httpContext.cgiGet( "DVPANEL_CARD4_Title") ;
         Dvpanel_card4_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD4_Collapsible")) ;
         Dvpanel_card4_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD4_Collapsed")) ;
         Dvpanel_card4_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD4_Showcollapseicon")) ;
         Dvpanel_card4_Iconposition = httpContext.cgiGet( "DVPANEL_CARD4_Iconposition") ;
         Dvpanel_card4_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CARD4_Autoscroll")) ;
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcitahoy_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcitahoy_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARDCITAHOY");
            GX_FocusControl = edtavValuecardcitahoy_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17ValueCardCitaHoy = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17ValueCardCitaHoy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17ValueCardCitaHoy), 8, 0));
         }
         else
         {
            AV17ValueCardCitaHoy = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecardcitahoy_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17ValueCardCitaHoy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17ValueCardCitaHoy), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcitas_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcitas_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARDCITAS");
            GX_FocusControl = edtavValuecardcitas_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18ValueCardCitas = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18ValueCardCitas", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18ValueCardCitas), 8, 0));
         }
         else
         {
            AV18ValueCardCitas = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecardcitas_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18ValueCardCitas", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18ValueCardCitas), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcalificacion_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcalificacion_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARDCALIFICACION");
            GX_FocusControl = edtavValuecardcalificacion_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16ValueCardCalificacion = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16ValueCardCalificacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ValueCardCalificacion), 8, 0));
         }
         else
         {
            AV16ValueCardCalificacion = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecardcalificacion_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16ValueCardCalificacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ValueCardCalificacion), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcomentarios_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardcomentarios_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARDCOMENTARIOS");
            GX_FocusControl = edtavValuecardcomentarios_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19ValueCardComentarios = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ValueCardComentarios", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ValueCardComentarios), 8, 0));
         }
         else
         {
            AV19ValueCardComentarios = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecardcomentarios_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ValueCardComentarios", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ValueCardComentarios), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardpacientes_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardpacientes_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARDPACIENTES");
            GX_FocusControl = edtavValuecardpacientes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV21ValueCardPacientes = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ValueCardPacientes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ValueCardPacientes), 8, 0));
         }
         else
         {
            AV21ValueCardPacientes = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecardpacientes_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ValueCardPacientes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ValueCardPacientes), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardganancia_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavValuecardganancia_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALUECARDGANANCIA");
            GX_FocusControl = edtavValuecardganancia_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20ValueCardGanancia = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ValueCardGanancia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ValueCardGanancia), 8, 0));
         }
         else
         {
            AV20ValueCardGanancia = (int)(localUtil.ctol( httpContext.cgiGet( edtavValuecardganancia_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ValueCardGanancia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ValueCardGanancia), 8, 0));
         }
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
      e115O2 ();
      if (returnInSub) return;
   }

   public void e115O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.getJscriptsrc().add("ActualizarPagina.js") ;
      this.executeExternalObjectMethod("", false, "AV25ActualizarPagina", "ActualizarPagina", new Object[] {Integer.valueOf(1)}, false);
      GXv_SdtWWPContext1[0] = AV22WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV22WWPContext = GXv_SdtWWPContext1[0] ;
      /* Using cursor H005O2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV22WWPContext.getgxTv_SdtWWPContext_Userid())});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6SecUserId = H005O2_A6SecUserId[0] ;
         A4SecRoleId = H005O2_A4SecRoleId[0] ;
         AV24SecRoleId = A4SecRoleId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV24SecRoleId == 1 )
      {
         divTablecards1_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards1_Visible), 5, 0), true);
         divTablecards2_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards2_Visible), 5, 0), true);
         divTablecards3_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards3_Visible), 5, 0), true);
      }
      else if ( AV24SecRoleId == 2 )
      {
         divTablecards1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards1_Visible), 5, 0), true);
         divTablecards2_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards2_Visible), 5, 0), true);
         divTablecards3_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards3_Visible), 5, 0), true);
         /* Using cursor H005O3 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV22WWPContext.getgxTv_SdtWWPContext_Userid())});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A6SecUserId = H005O3_A6SecUserId[0] ;
            A31ProfesionalId = H005O3_A31ProfesionalId[0] ;
            AV7ProfesionalId = A31ProfesionalId ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ProfesionalId), 8, 0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Execute user subroutine: 'CARDS' */
         S112 ();
         if (returnInSub) return;
      }
      else if ( AV24SecRoleId == 3 )
      {
         divTablecards1_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards1_Visible), 5, 0), true);
         divTablecards2_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards2_Visible), 5, 0), true);
         divTablecards3_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecards3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecards3_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'CARDS' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV10TotalCitas ;
      new com.projectthani.prccountcitas(remoteHandle, context).execute( AV7ProfesionalId, GXv_int2) ;
      homepage_impl.this.AV10TotalCitas = GXv_int2[0] ;
      GXv_int2[0] = AV11TotalCitasHoy ;
      new com.projectthani.prccountcitashoy(remoteHandle, context).execute( AV7ProfesionalId, GXv_int2) ;
      homepage_impl.this.AV11TotalCitasHoy = GXv_int2[0] ;
      GXv_int2[0] = AV14TotalPaciente ;
      new com.projectthani.prccountpaciente(remoteHandle, context).execute( AV7ProfesionalId, GXv_int2) ;
      homepage_impl.this.AV14TotalPaciente = GXv_int2[0] ;
      GXv_decimal3[0] = DecimalUtil.doubleToDec(AV13TotalGanacias) ;
      new com.projectthani.prccountganancias(remoteHandle, context).execute( AV7ProfesionalId, GXv_decimal3) ;
      homepage_impl.this.AV13TotalGanacias = (short)(DecimalUtil.decToDouble(GXv_decimal3[0])) ;
      GXv_int2[0] = AV15TotalRating ;
      new com.projectthani.prccountrating(remoteHandle, context).execute( AV7ProfesionalId, GXv_int2) ;
      homepage_impl.this.AV15TotalRating = GXv_int2[0] ;
      GXv_int2[0] = AV12TotalComentario ;
      new com.projectthani.prccountcomentario(remoteHandle, context).execute( AV7ProfesionalId, GXv_int2) ;
      homepage_impl.this.AV12TotalComentario = GXv_int2[0] ;
      AV16ValueCardCalificacion = AV15TotalRating ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ValueCardCalificacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ValueCardCalificacion), 8, 0));
      AV19ValueCardComentarios = AV12TotalComentario ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ValueCardComentarios", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ValueCardComentarios), 8, 0));
      AV17ValueCardCitaHoy = AV11TotalCitasHoy ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ValueCardCitaHoy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17ValueCardCitaHoy), 8, 0));
      AV18ValueCardCitas = AV10TotalCitas ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ValueCardCitas", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18ValueCardCitas), 8, 0));
      AV20ValueCardGanancia = AV13TotalGanacias ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ValueCardGanancia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ValueCardGanancia), 8, 0));
      AV21ValueCardPacientes = AV14TotalPaciente ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ValueCardPacientes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ValueCardPacientes), 8, 0));
      lblMoreinfocard1caption_Link = formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblMoreinfocard1caption_Internalname, "Link", lblMoreinfocard1caption_Link, true);
      lblMoreinfocard2caption_Link = formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblMoreinfocard2caption_Internalname, "Link", lblMoreinfocard2caption_Link, true);
      lblMoreinfocardcalificacion_Link = formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblMoreinfocardcalificacion_Internalname, "Link", lblMoreinfocardcalificacion_Link, true);
      lblCardcomentariostexblock_Link = formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblCardcomentariostexblock_Internalname, "Link", lblCardcomentariostexblock_Link, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e125O2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table7_158_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTxtblockmensaje_Internalname, "BIENVENIDO A THANI", "", "", lblTxtblockmensaje_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_158_5O2e( true) ;
      }
      else
      {
         wb_table7_158_5O2e( false) ;
      }
   }

   public void wb_table6_143_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblMoreinfocard4_Internalname, tblMoreinfocard4_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard4_Internalname, "<i class='fas fa-arrow-circle-right  CardMaterialMoreInfoIcon' style='font-size: 16px'></i>", "", "", lblMoreinfoiconcard4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard4caption_Internalname, "Más información", "", "", lblMoreinfocard4caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_143_5O2e( true) ;
      }
      else
      {
         wb_table6_143_5O2e( false) ;
      }
   }

   public void wb_table5_121_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblMoreinfocard3_Internalname, tblMoreinfocard3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard3_Internalname, "<i class='fas fa-arrow-circle-right  CardMaterialMoreInfoIcon' style='font-size: 16px'></i>", "", "", lblMoreinfoiconcard3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard3caption_Internalname, "Más información", "", "", lblMoreinfocard3caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_121_5O2e( true) ;
      }
      else
      {
         wb_table5_121_5O2e( false) ;
      }
   }

   public void wb_table4_93_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemoreinfocardcomentarios_Internalname, tblTablemoreinfocardcomentarios_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblIconcardcomentarios_Internalname, "<i class='fas fa-arrow-circle-right  CardMaterialMoreInfoIcon' style='font-size: 16px'></i>", "", "", lblIconcardcomentarios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblCardcomentariostexblock_Internalname, "Más información", lblCardcomentariostexblock_Link, "", lblCardcomentariostexblock_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_93_5O2e( true) ;
      }
      else
      {
         wb_table4_93_5O2e( false) ;
      }
   }

   public void wb_table3_71_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblMoreinfocardcomentarios_Internalname, tblMoreinfocardcomentarios_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcardcalificacion_Internalname, "<i class='fas fa-arrow-circle-right  CardMaterialMoreInfoIcon' style='font-size: 16px'></i>", "", "", lblMoreinfoiconcardcalificacion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocardcalificacion_Internalname, "Más información", lblMoreinfocardcalificacion_Link, "", lblMoreinfocardcalificacion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_71_5O2e( true) ;
      }
      else
      {
         wb_table3_71_5O2e( false) ;
      }
   }

   public void wb_table2_49_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblMoreinfocard2_Internalname, tblMoreinfocard2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard2_Internalname, "<i class='fas fa-arrow-circle-right  CardMaterialMoreInfoIcon' style='font-size: 16px'></i>", "", "", lblMoreinfoiconcard2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard2caption_Internalname, "Más información", lblMoreinfocard2caption_Link, "", lblMoreinfocard2caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_49_5O2e( true) ;
      }
      else
      {
         wb_table2_49_5O2e( false) ;
      }
   }

   public void wb_table1_27_5O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblMoreinfocard1_Internalname, tblMoreinfocard1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfoiconcard1_Internalname, "<i class='fas fa-arrow-circle-right  CardMaterialMoreInfoIcon' style='font-size: 16px'></i>", "", "", lblMoreinfoiconcard1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblMoreinfocard1caption_Internalname, "Más información", lblMoreinfocard1caption_Link, "", lblMoreinfocard1caption_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockMoreInfoCard", 0, "", 1, 1, 0, (short)(0), "HLP_HomePage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_27_5O2e( true) ;
      }
      else
      {
         wb_table1_27_5O2e( false) ;
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
      pa5O2( ) ;
      ws5O2( ) ;
      we5O2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335443", true, true);
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
         httpContext.AddJavascriptSource("homepage.js", "?20225110335443", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblIcon1_Internalname = "ICON1" ;
      lblDescriptioncard1_Internalname = "DESCRIPTIONCARD1" ;
      edtavValuecardcitahoy_Internalname = "vVALUECARDCITAHOY" ;
      divTablecard1info_Internalname = "TABLECARD1INFO" ;
      lblMoreinfoiconcard1_Internalname = "MOREINFOICONCARD1" ;
      lblMoreinfocard1caption_Internalname = "MOREINFOCARD1CAPTION" ;
      tblMoreinfocard1_Internalname = "MOREINFOCARD1" ;
      divCard1_Internalname = "CARD1" ;
      Dvpanel_card1_Internalname = "DVPANEL_CARD1" ;
      lblIcon2_Internalname = "ICON2" ;
      lblDescriptioncard2_Internalname = "DESCRIPTIONCARD2" ;
      edtavValuecardcitas_Internalname = "vVALUECARDCITAS" ;
      divTablecard2info_Internalname = "TABLECARD2INFO" ;
      lblMoreinfoiconcard2_Internalname = "MOREINFOICONCARD2" ;
      lblMoreinfocard2caption_Internalname = "MOREINFOCARD2CAPTION" ;
      tblMoreinfocard2_Internalname = "MOREINFOCARD2" ;
      divCard2_Internalname = "CARD2" ;
      Dvpanel_card2_Internalname = "DVPANEL_CARD2" ;
      lblIconcalificacion_Internalname = "ICONCALIFICACION" ;
      lblDescriptioncardtexblock_Internalname = "DESCRIPTIONCARDTEXBLOCK" ;
      edtavValuecardcalificacion_Internalname = "vVALUECARDCALIFICACION" ;
      divTablecardcalificacion_Internalname = "TABLECARDCALIFICACION" ;
      lblMoreinfoiconcardcalificacion_Internalname = "MOREINFOICONCARDCALIFICACION" ;
      lblMoreinfocardcalificacion_Internalname = "MOREINFOCARDCALIFICACION" ;
      tblMoreinfocardcomentarios_Internalname = "MOREINFOCARDCOMENTARIOS" ;
      divCardcalificacion_Internalname = "CARDCALIFICACION" ;
      Dvpanel_cardcalificacion_Internalname = "DVPANEL_CARDCALIFICACION" ;
      lblIconcomentarios_Internalname = "ICONCOMENTARIOS" ;
      lblDescriptioncardcalificacion_Internalname = "DESCRIPTIONCARDCALIFICACION" ;
      edtavValuecardcomentarios_Internalname = "vVALUECARDCOMENTARIOS" ;
      divTablecardcomentarios_Internalname = "TABLECARDCOMENTARIOS" ;
      lblIconcardcomentarios_Internalname = "ICONCARDCOMENTARIOS" ;
      lblCardcomentariostexblock_Internalname = "CARDCOMENTARIOSTEXBLOCK" ;
      tblTablemoreinfocardcomentarios_Internalname = "TABLEMOREINFOCARDCOMENTARIOS" ;
      divCardcomentarios_Internalname = "CARDCOMENTARIOS" ;
      Dvpanel_cardcomentarios_Internalname = "DVPANEL_CARDCOMENTARIOS" ;
      divTablecards1_Internalname = "TABLECARDS1" ;
      lblIcon3_Internalname = "ICON3" ;
      lblDescriptioncard3_Internalname = "DESCRIPTIONCARD3" ;
      edtavValuecardpacientes_Internalname = "vVALUECARDPACIENTES" ;
      divTablecard3info_Internalname = "TABLECARD3INFO" ;
      lblMoreinfoiconcard3_Internalname = "MOREINFOICONCARD3" ;
      lblMoreinfocard3caption_Internalname = "MOREINFOCARD3CAPTION" ;
      tblMoreinfocard3_Internalname = "MOREINFOCARD3" ;
      divCard3_Internalname = "CARD3" ;
      Dvpanel_card3_Internalname = "DVPANEL_CARD3" ;
      lblIcon4_Internalname = "ICON4" ;
      lblDescriptioncard4_Internalname = "DESCRIPTIONCARD4" ;
      edtavValuecardganancia_Internalname = "vVALUECARDGANANCIA" ;
      divTablecard4info_Internalname = "TABLECARD4INFO" ;
      lblMoreinfoiconcard4_Internalname = "MOREINFOICONCARD4" ;
      lblMoreinfocard4caption_Internalname = "MOREINFOCARD4CAPTION" ;
      tblMoreinfocard4_Internalname = "MOREINFOCARD4" ;
      divCard4_Internalname = "CARD4" ;
      Dvpanel_card4_Internalname = "DVPANEL_CARD4" ;
      divTablecar21_Internalname = "TABLECAR21" ;
      divTablecar22_Internalname = "TABLECAR22" ;
      divTablecards2_Internalname = "TABLECARDS2" ;
      lblTxtblockmensaje_Internalname = "TXTBLOCKMENSAJE" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      divTablecards3_Internalname = "TABLECARDS3" ;
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
      lblMoreinfocard1caption_Link = "" ;
      lblMoreinfocard2caption_Link = "" ;
      lblMoreinfocardcalificacion_Link = "" ;
      lblCardcomentariostexblock_Link = "" ;
      divTablecards3_Visible = 1 ;
      edtavValuecardganancia_Jsonclick = "" ;
      edtavValuecardganancia_Enabled = 1 ;
      edtavValuecardpacientes_Jsonclick = "" ;
      edtavValuecardpacientes_Enabled = 1 ;
      divTablecards2_Visible = 1 ;
      edtavValuecardcomentarios_Jsonclick = "" ;
      edtavValuecardcomentarios_Enabled = 1 ;
      edtavValuecardcalificacion_Jsonclick = "" ;
      edtavValuecardcalificacion_Enabled = 1 ;
      edtavValuecardcitas_Jsonclick = "" ;
      edtavValuecardcitas_Enabled = 1 ;
      edtavValuecardcitahoy_Jsonclick = "" ;
      edtavValuecardcitahoy_Enabled = 1 ;
      divTablecards1_Visible = 1 ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = "" ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      Dvpanel_card4_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_card4_Iconposition = "Right" ;
      Dvpanel_card4_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_card4_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_card4_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_card4_Title = "" ;
      Dvpanel_card4_Cls = "PanelNoHeader" ;
      Dvpanel_card4_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_card4_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_card4_Width = "100%" ;
      Dvpanel_card3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_card3_Iconposition = "Right" ;
      Dvpanel_card3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_card3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_card3_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_card3_Title = "" ;
      Dvpanel_card3_Cls = "PanelNoHeader" ;
      Dvpanel_card3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_card3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_card3_Width = "100%" ;
      Dvpanel_cardcomentarios_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_cardcomentarios_Iconposition = "Right" ;
      Dvpanel_cardcomentarios_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_cardcomentarios_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_cardcomentarios_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_cardcomentarios_Title = "" ;
      Dvpanel_cardcomentarios_Cls = "PanelNoHeader" ;
      Dvpanel_cardcomentarios_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_cardcomentarios_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_cardcomentarios_Width = "100%" ;
      Dvpanel_cardcalificacion_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_cardcalificacion_Iconposition = "Right" ;
      Dvpanel_cardcalificacion_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_cardcalificacion_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_cardcalificacion_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_cardcalificacion_Title = "" ;
      Dvpanel_cardcalificacion_Cls = "PanelNoHeader" ;
      Dvpanel_cardcalificacion_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_cardcalificacion_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_cardcalificacion_Width = "100%" ;
      Dvpanel_card2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_card2_Iconposition = "Right" ;
      Dvpanel_card2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_card2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_card2_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_card2_Title = "" ;
      Dvpanel_card2_Cls = "PanelNoHeader" ;
      Dvpanel_card2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_card2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_card2_Width = "100%" ;
      Dvpanel_card1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_card1_Iconposition = "Right" ;
      Dvpanel_card1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_card1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_card1_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_card1_Title = "" ;
      Dvpanel_card1_Cls = "PanelNoHeader" ;
      Dvpanel_card1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_card1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_card1_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Home" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_card1 = new com.genexus.webpanels.GXUserControl();
      lblIcon1_Jsonclick = "" ;
      lblDescriptioncard1_Jsonclick = "" ;
      TempTags = "" ;
      ucDvpanel_card2 = new com.genexus.webpanels.GXUserControl();
      lblIcon2_Jsonclick = "" ;
      lblDescriptioncard2_Jsonclick = "" ;
      ucDvpanel_cardcalificacion = new com.genexus.webpanels.GXUserControl();
      lblIconcalificacion_Jsonclick = "" ;
      lblDescriptioncardtexblock_Jsonclick = "" ;
      ucDvpanel_cardcomentarios = new com.genexus.webpanels.GXUserControl();
      lblIconcomentarios_Jsonclick = "" ;
      lblDescriptioncardcalificacion_Jsonclick = "" ;
      ucDvpanel_card3 = new com.genexus.webpanels.GXUserControl();
      lblIcon3_Jsonclick = "" ;
      lblDescriptioncard3_Jsonclick = "" ;
      ucDvpanel_card4 = new com.genexus.webpanels.GXUserControl();
      lblIcon4_Jsonclick = "" ;
      lblDescriptioncard4_Jsonclick = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV22WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H005O2_A6SecUserId = new short[1] ;
      H005O2_A4SecRoleId = new short[1] ;
      H005O3_A6SecUserId = new short[1] ;
      H005O3_A31ProfesionalId = new int[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_int2 = new short[1] ;
      sStyleString = "" ;
      lblTxtblockmensaje_Jsonclick = "" ;
      lblMoreinfoiconcard4_Jsonclick = "" ;
      lblMoreinfocard4caption_Jsonclick = "" ;
      lblMoreinfoiconcard3_Jsonclick = "" ;
      lblMoreinfocard3caption_Jsonclick = "" ;
      lblIconcardcomentarios_Jsonclick = "" ;
      lblCardcomentariostexblock_Jsonclick = "" ;
      lblMoreinfoiconcardcalificacion_Jsonclick = "" ;
      lblMoreinfocardcalificacion_Jsonclick = "" ;
      lblMoreinfoiconcard2_Jsonclick = "" ;
      lblMoreinfocard2caption_Jsonclick = "" ;
      lblMoreinfoiconcard1_Jsonclick = "" ;
      lblMoreinfocard1caption_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.homepage__default(),
         new Object[] {
             new Object[] {
            H005O2_A6SecUserId, H005O2_A4SecRoleId
            }
            , new Object[] {
            H005O3_A6SecUserId, H005O3_A31ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavValuecardcitahoy_Enabled = 0 ;
      edtavValuecardcitas_Enabled = 0 ;
      edtavValuecardcalificacion_Enabled = 0 ;
      edtavValuecardcomentarios_Enabled = 0 ;
      edtavValuecardpacientes_Enabled = 0 ;
      edtavValuecardganancia_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV24SecRoleId ;
   private short AV10TotalCitas ;
   private short AV11TotalCitasHoy ;
   private short AV14TotalPaciente ;
   private short AV13TotalGanacias ;
   private short AV15TotalRating ;
   private short AV12TotalComentario ;
   private short GXv_int2[] ;
   private int divTablecards1_Visible ;
   private int AV17ValueCardCitaHoy ;
   private int edtavValuecardcitahoy_Enabled ;
   private int AV18ValueCardCitas ;
   private int edtavValuecardcitas_Enabled ;
   private int AV16ValueCardCalificacion ;
   private int edtavValuecardcalificacion_Enabled ;
   private int AV19ValueCardComentarios ;
   private int edtavValuecardcomentarios_Enabled ;
   private int divTablecards2_Visible ;
   private int AV21ValueCardPacientes ;
   private int edtavValuecardpacientes_Enabled ;
   private int AV20ValueCardGanancia ;
   private int edtavValuecardganancia_Enabled ;
   private int divTablecards3_Visible ;
   private int A31ProfesionalId ;
   private int AV7ProfesionalId ;
   private int idxLst ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_card1_Width ;
   private String Dvpanel_card1_Cls ;
   private String Dvpanel_card1_Title ;
   private String Dvpanel_card1_Iconposition ;
   private String Dvpanel_card2_Width ;
   private String Dvpanel_card2_Cls ;
   private String Dvpanel_card2_Title ;
   private String Dvpanel_card2_Iconposition ;
   private String Dvpanel_cardcalificacion_Width ;
   private String Dvpanel_cardcalificacion_Cls ;
   private String Dvpanel_cardcalificacion_Title ;
   private String Dvpanel_cardcalificacion_Iconposition ;
   private String Dvpanel_cardcomentarios_Width ;
   private String Dvpanel_cardcomentarios_Cls ;
   private String Dvpanel_cardcomentarios_Title ;
   private String Dvpanel_cardcomentarios_Iconposition ;
   private String Dvpanel_card3_Width ;
   private String Dvpanel_card3_Cls ;
   private String Dvpanel_card3_Title ;
   private String Dvpanel_card3_Iconposition ;
   private String Dvpanel_card4_Width ;
   private String Dvpanel_card4_Cls ;
   private String Dvpanel_card4_Title ;
   private String Dvpanel_card4_Iconposition ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablecards1_Internalname ;
   private String Dvpanel_card1_Internalname ;
   private String divCard1_Internalname ;
   private String lblIcon1_Internalname ;
   private String lblIcon1_Jsonclick ;
   private String divTablecard1info_Internalname ;
   private String lblDescriptioncard1_Internalname ;
   private String lblDescriptioncard1_Jsonclick ;
   private String edtavValuecardcitahoy_Internalname ;
   private String TempTags ;
   private String edtavValuecardcitahoy_Jsonclick ;
   private String Dvpanel_card2_Internalname ;
   private String divCard2_Internalname ;
   private String lblIcon2_Internalname ;
   private String lblIcon2_Jsonclick ;
   private String divTablecard2info_Internalname ;
   private String lblDescriptioncard2_Internalname ;
   private String lblDescriptioncard2_Jsonclick ;
   private String edtavValuecardcitas_Internalname ;
   private String edtavValuecardcitas_Jsonclick ;
   private String Dvpanel_cardcalificacion_Internalname ;
   private String divCardcalificacion_Internalname ;
   private String lblIconcalificacion_Internalname ;
   private String lblIconcalificacion_Jsonclick ;
   private String divTablecardcalificacion_Internalname ;
   private String lblDescriptioncardtexblock_Internalname ;
   private String lblDescriptioncardtexblock_Jsonclick ;
   private String edtavValuecardcalificacion_Internalname ;
   private String edtavValuecardcalificacion_Jsonclick ;
   private String Dvpanel_cardcomentarios_Internalname ;
   private String divCardcomentarios_Internalname ;
   private String lblIconcomentarios_Internalname ;
   private String lblIconcomentarios_Jsonclick ;
   private String divTablecardcomentarios_Internalname ;
   private String lblDescriptioncardcalificacion_Internalname ;
   private String lblDescriptioncardcalificacion_Jsonclick ;
   private String edtavValuecardcomentarios_Internalname ;
   private String edtavValuecardcomentarios_Jsonclick ;
   private String divTablecards2_Internalname ;
   private String divTablecar21_Internalname ;
   private String Dvpanel_card3_Internalname ;
   private String divCard3_Internalname ;
   private String lblIcon3_Internalname ;
   private String lblIcon3_Jsonclick ;
   private String divTablecard3info_Internalname ;
   private String lblDescriptioncard3_Internalname ;
   private String lblDescriptioncard3_Jsonclick ;
   private String edtavValuecardpacientes_Internalname ;
   private String edtavValuecardpacientes_Jsonclick ;
   private String Dvpanel_card4_Internalname ;
   private String divCard4_Internalname ;
   private String lblIcon4_Internalname ;
   private String lblIcon4_Jsonclick ;
   private String divTablecard4info_Internalname ;
   private String lblDescriptioncard4_Internalname ;
   private String lblDescriptioncard4_Jsonclick ;
   private String edtavValuecardganancia_Internalname ;
   private String edtavValuecardganancia_Jsonclick ;
   private String divTablecar22_Internalname ;
   private String divTablecards3_Internalname ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String lblMoreinfocard1caption_Link ;
   private String lblMoreinfocard1caption_Internalname ;
   private String lblMoreinfocard2caption_Link ;
   private String lblMoreinfocard2caption_Internalname ;
   private String lblMoreinfocardcalificacion_Link ;
   private String lblMoreinfocardcalificacion_Internalname ;
   private String lblCardcomentariostexblock_Link ;
   private String lblCardcomentariostexblock_Internalname ;
   private String sStyleString ;
   private String tblUnnamedtable1_Internalname ;
   private String lblTxtblockmensaje_Internalname ;
   private String lblTxtblockmensaje_Jsonclick ;
   private String tblMoreinfocard4_Internalname ;
   private String lblMoreinfoiconcard4_Internalname ;
   private String lblMoreinfoiconcard4_Jsonclick ;
   private String lblMoreinfocard4caption_Internalname ;
   private String lblMoreinfocard4caption_Jsonclick ;
   private String tblMoreinfocard3_Internalname ;
   private String lblMoreinfoiconcard3_Internalname ;
   private String lblMoreinfoiconcard3_Jsonclick ;
   private String lblMoreinfocard3caption_Internalname ;
   private String lblMoreinfocard3caption_Jsonclick ;
   private String tblTablemoreinfocardcomentarios_Internalname ;
   private String lblIconcardcomentarios_Internalname ;
   private String lblIconcardcomentarios_Jsonclick ;
   private String lblCardcomentariostexblock_Jsonclick ;
   private String tblMoreinfocardcomentarios_Internalname ;
   private String lblMoreinfoiconcardcalificacion_Internalname ;
   private String lblMoreinfoiconcardcalificacion_Jsonclick ;
   private String lblMoreinfocardcalificacion_Jsonclick ;
   private String tblMoreinfocard2_Internalname ;
   private String lblMoreinfoiconcard2_Internalname ;
   private String lblMoreinfoiconcard2_Jsonclick ;
   private String lblMoreinfocard2caption_Jsonclick ;
   private String tblMoreinfocard1_Internalname ;
   private String lblMoreinfoiconcard1_Internalname ;
   private String lblMoreinfoiconcard1_Jsonclick ;
   private String lblMoreinfocard1caption_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_card1_Autowidth ;
   private boolean Dvpanel_card1_Autoheight ;
   private boolean Dvpanel_card1_Collapsible ;
   private boolean Dvpanel_card1_Collapsed ;
   private boolean Dvpanel_card1_Showcollapseicon ;
   private boolean Dvpanel_card1_Autoscroll ;
   private boolean Dvpanel_card2_Autowidth ;
   private boolean Dvpanel_card2_Autoheight ;
   private boolean Dvpanel_card2_Collapsible ;
   private boolean Dvpanel_card2_Collapsed ;
   private boolean Dvpanel_card2_Showcollapseicon ;
   private boolean Dvpanel_card2_Autoscroll ;
   private boolean Dvpanel_cardcalificacion_Autowidth ;
   private boolean Dvpanel_cardcalificacion_Autoheight ;
   private boolean Dvpanel_cardcalificacion_Collapsible ;
   private boolean Dvpanel_cardcalificacion_Collapsed ;
   private boolean Dvpanel_cardcalificacion_Showcollapseicon ;
   private boolean Dvpanel_cardcalificacion_Autoscroll ;
   private boolean Dvpanel_cardcomentarios_Autowidth ;
   private boolean Dvpanel_cardcomentarios_Autoheight ;
   private boolean Dvpanel_cardcomentarios_Collapsible ;
   private boolean Dvpanel_cardcomentarios_Collapsed ;
   private boolean Dvpanel_cardcomentarios_Showcollapseicon ;
   private boolean Dvpanel_cardcomentarios_Autoscroll ;
   private boolean Dvpanel_card3_Autowidth ;
   private boolean Dvpanel_card3_Autoheight ;
   private boolean Dvpanel_card3_Collapsible ;
   private boolean Dvpanel_card3_Collapsed ;
   private boolean Dvpanel_card3_Showcollapseicon ;
   private boolean Dvpanel_card3_Autoscroll ;
   private boolean Dvpanel_card4_Autowidth ;
   private boolean Dvpanel_card4_Autoheight ;
   private boolean Dvpanel_card4_Collapsible ;
   private boolean Dvpanel_card4_Collapsed ;
   private boolean Dvpanel_card4_Showcollapseicon ;
   private boolean Dvpanel_card4_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_card1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_card2 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_cardcalificacion ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_cardcomentarios ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_card3 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_card4 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private IDataStoreProvider pr_default ;
   private short[] H005O2_A6SecUserId ;
   private short[] H005O2_A4SecRoleId ;
   private short[] H005O3_A6SecUserId ;
   private int[] H005O3_A31ProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV22WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class homepage__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005O2", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H005O3", "SELECT [SecUserId], [ProfesionalId] FROM [Profesional] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

