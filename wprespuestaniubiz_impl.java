package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wprespuestaniubiz_impl extends GXDataArea
{
   public wprespuestaniubiz_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wprespuestaniubiz_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wprespuestaniubiz_impl.class ));
   }

   public wprespuestaniubiz_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV13DisponibilidadId = (int) GXutil.lval( args[0]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
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
         gxfirstwebparm = httpContext.GetFirstPar( "DisponibilidadId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "DisponibilidadId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "DisponibilidadId") ;
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
            AV13DisponibilidadId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13DisponibilidadId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13DisponibilidadId), "ZZZZZZZ9")));
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.mphomepage");
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
      pa6H2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6H2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?202251103464", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoHomPagPaciente\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoHomPagPaciente\" data-gx-class=\"form-horizontal FormFondoHomPagPaciente\" novalidate action=\""+formatLink("com.projectthani.wprespuestaniubiz", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormFondoHomPagPaciente", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13DisponibilidadId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV13DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13DisponibilidadId), "ZZZZZZZ9")));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormFondoHomPagPaciente" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we6H2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6H2( ) ;
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
      return formatLink("com.projectthani.wprespuestaniubiz", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "WPRespuestaNiubiz" ;
   }

   public String getPgmdesc( )
   {
      return "WPRespuesta Niubiz" ;
   }

   public void wb6H0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "Table100x100H", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginRN", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontentrn_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingLeft30", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablerespuesta_Internalname, 1, 0, "px", 0, "px", "TableRespuestaNiubiz", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesuccess_Internalname, divTablesuccess_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockicono_Internalname, lblTextblockicono_Caption, "", "", lblTextblockicono_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmsgsuccses_Internalname, lblTbmsgsuccses_Caption, "", "", lblTbmsgsuccses_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionRN", 0, "", 1, 1, 0, (short)(1), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbinfopago_Internalname, lblTbinfopago_Caption, "", "", lblTbinfopago_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttIrinicio_Internalname, "", "Ir a inicio", bttIrinicio_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableerror_Internalname, divTableerror_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconerror_Internalname, lblTextblockiconerror_Caption, "", "", lblTextblockiconerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmsgerror_Internalname, lblTbmsgerror_Caption, "", "", lblTbmsgerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionRN", 0, "", 1, 1, 0, (short)(1), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbinfoerror_Internalname, lblTbinfoerror_Caption, "", "", lblTbinfoerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnirinicio_Internalname, "", "Ir a inicio", bttBtnirinicio_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecitaerror_Internalname, divTablecitaerror_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbiconcitaerror_Internalname, lblTbiconcitaerror_Caption, "", "", lblTbiconcitaerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbcitaerror_Internalname, lblTbcitaerror_Caption, "", "", lblTbcitaerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionRN", 0, "", 1, 1, 0, (short)(1), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttIrinicio1_Internalname, "", "Ir a inicio", bttIrinicio1_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRespuestaNiubiz.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6H2( )
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
         Form.getMeta().addItem("description", "WPRespuesta Niubiz", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6H0( ) ;
   }

   public void ws6H2( )
   {
      start6H2( ) ;
      evt6H2( ) ;
   }

   public void evt6H2( )
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
                           e116H2 ();
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
                                 e126H2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e136H2 ();
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

   public void we6H2( )
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

   public void pa6H2( )
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
      rf6H2( ) ;
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

   public void rf6H2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e136H2 ();
         wb6H0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6H2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6H0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e116H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
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
      e116H2 ();
      if (returnInSub) return;
   }

   public void e116H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divTablesuccess_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablesuccess_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesuccess_Visible), 5, 0), true);
      divTableerror_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTableerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableerror_Visible), 5, 0), true);
      divTablecitaerror_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablecitaerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitaerror_Visible), 5, 0), true);
      AV15EstadoPago = false ;
      if ( GXutil.strcmp(AV26HttpRequest.getMethod(), "POST") == 0 )
      {
         if ( new com.projectthani.prcvalidardisponibilidadcita(remoteHandle, context).executeUdp( AV13DisponibilidadId) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV41TransactionToken = AV26HttpRequest.getVariable("transactionToken") ;
            AV6accessToken = AV42WebSession.getValue("accessTokenNiubiz") ;
            AV33purchaseNumber = AV42WebSession.getValue("purchaseNumber") ;
            AV7amount = CommonUtil.decimalVal( AV42WebSession.getValue("monto"), ".") ;
            GXv_char1[0] = AV14ErrorMessage ;
            GXv_SdtSDTResponseAutorizacionPago2002[0] = AV34SDTResponseAutorizacionPago200;
            GXv_SdtSDTResponseAutorizacionPago4003[0] = AV35SDTResponseAutorizacionPago400;
            GXv_SdtSDTRequestAutorizacionPago4[0] = AV5SDTRequestAutorizacionPago;
            GXv_int5[0] = AV27HttpStatus ;
            new com.projectthani.prcautorizacionpagoniubiz(remoteHandle, context).execute( AV6accessToken, new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "merchantId"), AV41TransactionToken, AV33purchaseNumber, AV7amount, "PEN", GXv_char1, GXv_SdtSDTResponseAutorizacionPago2002, GXv_SdtSDTResponseAutorizacionPago4003, GXv_SdtSDTRequestAutorizacionPago4, GXv_int5) ;
            wprespuestaniubiz_impl.this.AV14ErrorMessage = GXv_char1[0] ;
            AV34SDTResponseAutorizacionPago200 = GXv_SdtSDTResponseAutorizacionPago2002[0] ;
            AV35SDTResponseAutorizacionPago400 = GXv_SdtSDTResponseAutorizacionPago4003[0] ;
            AV5SDTRequestAutorizacionPago = GXv_SdtSDTRequestAutorizacionPago4[0] ;
            wprespuestaniubiz_impl.this.AV27HttpStatus = GXv_int5[0] ;
            AV39temp = AV34SDTResponseAutorizacionPago200.toJSonString(false, true) ;
            AV40temp2 = AV35SDTResponseAutorizacionPago400.toJSonString(false, true) ;
            AV32PagoJson = AV42WebSession.getValue("PagoTemporal") ;
            AV31Pago.fromJSonString(AV32PagoJson, null);
            AV31Pago.setgxTv_SdtPago_Citaid_SetNull();
            AV31Pago.setgxTv_SdtPago_Disponibilidadid( AV13DisponibilidadId );
            AV31Pago.setgxTv_SdtPago_Pagoestador( "A" );
            AV31Pago.setgxTv_SdtPago_Pagofechaemision( GXutil.now( ) );
            AV31Pago.setgxTv_SdtPago_Pagotoken( AV41TransactionToken );
            AV31Pago.setgxTv_SdtPago_Pagorequest( AV5SDTRequestAutorizacionPago.toJSonString(false, true) );
            AV31Pago.setgxTv_SdtPago_Pagoresponse( AV14ErrorMessage );
            AV31Pago.setgxTv_SdtPago_Pagostatuscode( AV27HttpStatus );
            AV31Pago.setgxTv_SdtPago_Pagomoneda( (short)(1) );
            if ( AV27HttpStatus == 400 )
            {
               AV31Pago.setgxTv_SdtPago_Pagoresponse( AV35SDTResponseAutorizacionPago400.toJSonString(false, true) );
            }
            if ( ( AV27HttpStatus != 400 ) && ( AV27HttpStatus != 200 ) )
            {
            }
            if ( AV27HttpStatus == 200 )
            {
               AV9CitaJson = AV42WebSession.getValue("CitaTemporal") ;
               AV8Cita.fromJSonString(AV9CitaJson, null);
               AV8Cita.Save();
               if ( AV8Cita.Success() )
               {
                  AV31Pago.setgxTv_SdtPago_Citaid( AV8Cita.getgxTv_SdtCita_Citaid() );
                  AV12Disponibilidad.Load(AV13DisponibilidadId);
                  AV12Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestadocita( "O" );
                  AV12Disponibilidad.Save();
                  AV15EstadoPago = true ;
                  new com.projectthani.prcinformecitacorreo(remoteHandle, context).execute( AV8Cita.getgxTv_SdtCita_Citaid()) ;
               }
               AV31Pago.setgxTv_SdtPago_Pagopasarelaid( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Header().getgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid() );
               AV31Pago.setgxTv_SdtPago_Pagoresponse( AV34SDTResponseAutorizacionPago200.toJSonString(false, true) );
               AV21HtmlIconSucces = "<div><i class=\"fas fa-check-circle\" style=\"font-size: 80px;color: green;\"></i></div>" ;
               AV30NombresDoctor = AV42WebSession.getValue("NombreDoctor") ;
               AV16FechaCita = localUtil.ctod( AV42WebSession.getValue("FechaCita"), 3) ;
               AV17HoraCita = AV42WebSession.getValue("HoraCita") ;
               lblTextblockicono_Caption = AV21HtmlIconSucces ;
               httpContext.ajax_rsp_assign_prop("", false, lblTextblockicono_Internalname, "Caption", lblTextblockicono_Caption, true);
               AV25HtmlTbSuccess += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-top:-40px;margin-bottom: 10px;\"><h3>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25HtmlTbSuccess", AV25HtmlTbSuccess);
               AV25HtmlTbSuccess += "<font style=\"vertical-align: inherit; font-size: 24px;color: #15A015;font-family:" + "MyriadPro-Bold" + ";\">¡Cita reservada con éxito!</font></h3><p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25HtmlTbSuccess", AV25HtmlTbSuccess);
               AV25HtmlTbSuccess += "<font style=\"vertical-align: initial;font-size: 14px;text-align: justify;white-space: normal; color: #333;font-family:" + "MyriadPro-Bold" + ";\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25HtmlTbSuccess", AV25HtmlTbSuccess);
               AV25HtmlTbSuccess += "Cita reservada con el Dr(a). " + AV30NombresDoctor + " el " + GXutil.str( GXutil.day( AV16FechaCita), 10, 0) + " de " + localUtil.cmonth( AV16FechaCita, "spa") + " de " + GXutil.str( GXutil.year( AV16FechaCita), 10, 0) + " de " + AV17HoraCita + " </font></p></div>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25HtmlTbSuccess", AV25HtmlTbSuccess);
               lblTbmsgsuccses_Caption = AV25HtmlTbSuccess ;
               httpContext.ajax_rsp_assign_prop("", false, lblTbmsgsuccses_Internalname, "Caption", lblTbmsgsuccses_Caption, true);
               AV22HtmlInfoPago += "<div class=\"alert alert-primary\" role=\"alert\" style=\"padding: 15px;border:3px solid #00BAED;border-radius:10px;margin-left:20px;margin-right:20px;margin-top:-15px;margin-bottom:-1px;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<ul style=\"margin-left: -20px;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Nro pedido:" + AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_id() + " </li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Nombres y Apellidos : " + AV31Pago.getgxTv_SdtPago_Pagoclientedenominacion() + " </li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV11DateString = "20" + GXutil.trim( GXutil.substring( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(), 1, 2)) + "/" + GXutil.trim( GXutil.substring( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(), 3, 2)) + "/" + GXutil.trim( GXutil.substring( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(), 5, 2)) + " " + GXutil.trim( GXutil.substring( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(), 7, 2)) + ":" + GXutil.trim( GXutil.substring( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(), 9, 2)) + ":" + GXutil.trim( GXutil.substring( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Transaction_date(), 11, 2)) ;
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Fecha y hora del pedido:" + AV11DateString + " </li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Importe de la transacción:" + GXutil.str( AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Order().getgxTv_SdtSDTResponseAutorizacionPago200Order_Amount(), 6, 2) + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Tipo de moneda:" + AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Order().getgxTv_SdtSDTResponseAutorizacionPago200Order_Currency() + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Descripción de el/los productos(s):Reserva de cita</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Tarjeta Enmascarada:" + AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Card() + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Marca de la tarjeta:" + AV34SDTResponseAutorizacionPago200.getgxTv_SdtSDTResponseAutorizacionPago200_Datamap().getgxTv_SdtSDTResponseAutorizacionPago200DataMap_Brand() + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               AV22HtmlInfoPago += "</ul></div>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlInfoPago", AV22HtmlInfoPago);
               lblTbinfopago_Caption = AV22HtmlInfoPago ;
               httpContext.ajax_rsp_assign_prop("", false, lblTbinfopago_Internalname, "Caption", lblTbinfopago_Caption, true);
               divTablesuccess_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablesuccess_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesuccess_Visible), 5, 0), true);
            }
            AV31Pago.Save();
            if ( AV31Pago.Success() )
            {
               if ( AV15EstadoPago )
               {
                  new com.projectthani.prcsenddocnubefact(remoteHandle, context).execute( AV31Pago.getgxTv_SdtPago_Pagoid()) ;
               }
               Application.commitDataStores(context, remoteHandle, pr_default, "wprespuestaniubiz");
            }
            if ( AV27HttpStatus != 200 )
            {
               AV20HtmlIconError = "<div><i class=\"fas fa-times-circle\"style=\"font-size: 80px;color: red;\"></i></div>" ;
               lblTextblockiconerror_Caption = AV20HtmlIconError ;
               httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconerror_Internalname, "Caption", lblTextblockiconerror_Caption, true);
               AV24HtmlTbError += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-top:-40px;margin-bottom: 10px;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24HtmlTbError", AV24HtmlTbError);
               AV24HtmlTbError += "<h3><font style=\"vertical-align: inherit; font-size: 24px;color:#ff0000;font-family:" + "MyriadPro-Bold" + ";\">¡Hubo un error al realizar la transacción!</font></h3>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24HtmlTbError", AV24HtmlTbError);
               AV24HtmlTbError += "<p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24HtmlTbError", AV24HtmlTbError);
               AV24HtmlTbError += "<font style=\"vertical-align: initial;font-size: 17px;text-align: justify;white-space: normal;color:#333;font-family:" + "MyriadPro-Bold" + ";\">Por favor intente reservar la cita nuevamente</font></p></div>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24HtmlTbError", AV24HtmlTbError);
               lblTbmsgerror_Caption = AV24HtmlTbError ;
               httpContext.ajax_rsp_assign_prop("", false, lblTbmsgerror_Internalname, "Caption", lblTbmsgerror_Caption, true);
               AV23HtmlInfoPagoErr += "<div class=\"alert alert-primary\" role=\"alert\"style=\"padding: 15px;border:3px solid #00BAED;border-radius:10px;margin-left:20px;margin-right:20px;margin-top:-15px;margin-bottom:-1px;\"><ul style=\"margin-left: -20px;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlInfoPagoErr", AV23HtmlInfoPagoErr);
               AV23HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Número de pedido:" + AV35SDTResponseAutorizacionPago400.getgxTv_SdtSDTResponseAutorizacionPago400_Header().getgxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid() + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlInfoPagoErr", AV23HtmlInfoPagoErr);
               AV23HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Fecha y hora del pedido:" + localUtil.dtoc( AV31Pago.getgxTv_SdtPago_Pagofechaemision(), 3, "/") + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlInfoPagoErr", AV23HtmlInfoPagoErr);
               AV23HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Descripción de la denegación:" + AV35SDTResponseAutorizacionPago400.getgxTv_SdtSDTResponseAutorizacionPago400_Errormessage() + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlInfoPagoErr", AV23HtmlInfoPagoErr);
               AV23HtmlInfoPagoErr += "</ul></div>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlInfoPagoErr", AV23HtmlInfoPagoErr);
               lblTbinfoerror_Caption = AV23HtmlInfoPagoErr ;
               httpContext.ajax_rsp_assign_prop("", false, lblTbinfoerror_Internalname, "Caption", lblTbinfoerror_Caption, true);
               divTableerror_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divTableerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableerror_Visible), 5, 0), true);
            }
         }
         else
         {
            AV19HtmlIconCitaError = "<div><i class=\"fas fa-exclamation-triangle\"style=\"font-size: 80px;color: orange;\"></i></div>" ;
            lblTbiconcitaerror_Caption = AV19HtmlIconCitaError ;
            httpContext.ajax_rsp_assign_prop("", false, lblTbiconcitaerror_Internalname, "Caption", lblTbiconcitaerror_Caption, true);
            AV18HtmlCitaError += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-top:-15px;margin-bottom: 10px;\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18HtmlCitaError", AV18HtmlCitaError);
            AV18HtmlCitaError += "<h3><font style=\"vertical-align: inherit; font-size: 24px; color:#F4B008;font-family:" + "MyriadPro-Bold" + ";\">¡Cita reservada no disponible!</font></h3>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18HtmlCitaError", AV18HtmlCitaError);
            AV18HtmlCitaError += "<p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18HtmlCitaError", AV18HtmlCitaError);
            AV18HtmlCitaError += "<font style=\"vertical-align: initial;font-size: 16px;text-align: justify;white-space: normal;color:#333;font-family:" + "MyriadPro-Bold" + ";\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18HtmlCitaError", AV18HtmlCitaError);
            AV18HtmlCitaError += "El horario de esa cita ya se encuentra ocupada. Por favor intente con otro horario.</font></p></div>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18HtmlCitaError", AV18HtmlCitaError);
            lblTbcitaerror_Caption = AV18HtmlCitaError ;
            httpContext.ajax_rsp_assign_prop("", false, lblTbcitaerror_Internalname, "Caption", lblTbcitaerror_Caption, true);
            divTablecitaerror_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablecitaerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitaerror_Visible), 5, 0), true);
         }
      }
      else
      {
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e126H2 ();
      if (returnInSub) return;
   }

   public void e126H2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   protected void nextLoad( )
   {
   }

   protected void e136H2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV13DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13DisponibilidadId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13DisponibilidadId), "ZZZZZZZ9")));
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
      pa6H2( ) ;
      ws6H2( ) ;
      we6H2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034677", true, true);
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
      httpContext.AddJavascriptSource("wprespuestaniubiz.js", "?2022511034677", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockicono_Internalname = "TEXTBLOCKICONO" ;
      lblTbmsgsuccses_Internalname = "TBMSGSUCCSES" ;
      lblTbinfopago_Internalname = "TBINFOPAGO" ;
      bttIrinicio_Internalname = "IRINICIO" ;
      divTablesuccess_Internalname = "TABLESUCCESS" ;
      lblTextblockiconerror_Internalname = "TEXTBLOCKICONERROR" ;
      lblTbmsgerror_Internalname = "TBMSGERROR" ;
      lblTbinfoerror_Internalname = "TBINFOERROR" ;
      bttBtnirinicio_Internalname = "BTNIRINICIO" ;
      divTableerror_Internalname = "TABLEERROR" ;
      lblTbiconcitaerror_Internalname = "TBICONCITAERROR" ;
      lblTbcitaerror_Internalname = "TBCITAERROR" ;
      bttIrinicio1_Internalname = "IRINICIO1" ;
      divTablecitaerror_Internalname = "TABLECITAERROR" ;
      divTablerespuesta_Internalname = "TABLERESPUESTA" ;
      divTablecontentrn_Internalname = "TABLECONTENTRN" ;
      divTable1_Internalname = "TABLE1" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
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
      lblTbcitaerror_Caption = "MensajeError" ;
      lblTbiconcitaerror_Caption = "Text Block" ;
      divTablecitaerror_Visible = 1 ;
      lblTbinfoerror_Caption = "Text Block" ;
      lblTbmsgerror_Caption = "MensajeError" ;
      lblTextblockiconerror_Caption = "Text Block" ;
      divTableerror_Visible = 1 ;
      lblTbinfopago_Caption = "Text Block" ;
      lblTbmsgsuccses_Caption = "MensajeSucces" ;
      lblTextblockicono_Caption = "Text Block" ;
      divTablesuccess_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "WPRespuesta Niubiz" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e126H2',iparms:[]");
      setEventMetadata("ENTER",",oparms:[]}");
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
      lblTextblockicono_Jsonclick = "" ;
      lblTbmsgsuccses_Jsonclick = "" ;
      lblTbinfopago_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttIrinicio_Jsonclick = "" ;
      lblTextblockiconerror_Jsonclick = "" ;
      lblTbmsgerror_Jsonclick = "" ;
      lblTbinfoerror_Jsonclick = "" ;
      bttBtnirinicio_Jsonclick = "" ;
      lblTbiconcitaerror_Jsonclick = "" ;
      lblTbcitaerror_Jsonclick = "" ;
      bttIrinicio1_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV26HttpRequest = httpContext.getHttpRequest();
      AV41TransactionToken = "" ;
      AV6accessToken = "" ;
      AV42WebSession = httpContext.getWebSession();
      AV33purchaseNumber = "" ;
      AV7amount = DecimalUtil.ZERO ;
      AV14ErrorMessage = "" ;
      GXv_char1 = new String[1] ;
      AV34SDTResponseAutorizacionPago200 = new com.projectthani.SdtSDTResponseAutorizacionPago200(remoteHandle, context);
      GXv_SdtSDTResponseAutorizacionPago2002 = new com.projectthani.SdtSDTResponseAutorizacionPago200[1] ;
      AV35SDTResponseAutorizacionPago400 = new com.projectthani.SdtSDTResponseAutorizacionPago400(remoteHandle, context);
      GXv_SdtSDTResponseAutorizacionPago4003 = new com.projectthani.SdtSDTResponseAutorizacionPago400[1] ;
      AV5SDTRequestAutorizacionPago = new com.projectthani.SdtSDTRequestAutorizacionPago(remoteHandle, context);
      GXv_SdtSDTRequestAutorizacionPago4 = new com.projectthani.SdtSDTRequestAutorizacionPago[1] ;
      GXv_int5 = new short[1] ;
      AV39temp = "" ;
      AV40temp2 = "" ;
      AV32PagoJson = "" ;
      AV31Pago = new com.projectthani.SdtPago(remoteHandle);
      AV9CitaJson = "" ;
      AV8Cita = new com.projectthani.SdtCita(remoteHandle);
      AV12Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV21HtmlIconSucces = "" ;
      AV30NombresDoctor = "" ;
      AV16FechaCita = GXutil.nullDate() ;
      AV17HoraCita = "" ;
      AV25HtmlTbSuccess = "" ;
      AV22HtmlInfoPago = "" ;
      AV11DateString = "" ;
      AV20HtmlIconError = "" ;
      AV24HtmlTbError = "" ;
      AV23HtmlInfoPagoErr = "" ;
      AV19HtmlIconCitaError = "" ;
      AV18HtmlCitaError = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wprespuestaniubiz__default(),
         new Object[] {
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
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV27HttpStatus ;
   private short GXv_int5[] ;
   private int wcpOAV13DisponibilidadId ;
   private int AV13DisponibilidadId ;
   private int divTablesuccess_Visible ;
   private int divTableerror_Visible ;
   private int divTablecitaerror_Visible ;
   private int idxLst ;
   private java.math.BigDecimal AV7amount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTablecontentrn_Internalname ;
   private String divTablerespuesta_Internalname ;
   private String divTablesuccess_Internalname ;
   private String lblTextblockicono_Internalname ;
   private String lblTextblockicono_Caption ;
   private String lblTextblockicono_Jsonclick ;
   private String lblTbmsgsuccses_Internalname ;
   private String lblTbmsgsuccses_Caption ;
   private String lblTbmsgsuccses_Jsonclick ;
   private String lblTbinfopago_Internalname ;
   private String lblTbinfopago_Caption ;
   private String lblTbinfopago_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttIrinicio_Internalname ;
   private String bttIrinicio_Jsonclick ;
   private String divTableerror_Internalname ;
   private String lblTextblockiconerror_Internalname ;
   private String lblTextblockiconerror_Caption ;
   private String lblTextblockiconerror_Jsonclick ;
   private String lblTbmsgerror_Internalname ;
   private String lblTbmsgerror_Caption ;
   private String lblTbmsgerror_Jsonclick ;
   private String lblTbinfoerror_Internalname ;
   private String lblTbinfoerror_Caption ;
   private String lblTbinfoerror_Jsonclick ;
   private String bttBtnirinicio_Internalname ;
   private String bttBtnirinicio_Jsonclick ;
   private String divTablecitaerror_Internalname ;
   private String lblTbiconcitaerror_Internalname ;
   private String lblTbiconcitaerror_Caption ;
   private String lblTbiconcitaerror_Jsonclick ;
   private String lblTbcitaerror_Internalname ;
   private String lblTbcitaerror_Caption ;
   private String lblTbcitaerror_Jsonclick ;
   private String bttIrinicio1_Internalname ;
   private String bttIrinicio1_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXv_char1[] ;
   private java.util.Date AV16FechaCita ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV15EstadoPago ;
   private boolean Cond_result ;
   private String AV39temp ;
   private String AV40temp2 ;
   private String AV32PagoJson ;
   private String AV9CitaJson ;
   private String AV21HtmlIconSucces ;
   private String AV25HtmlTbSuccess ;
   private String AV22HtmlInfoPago ;
   private String AV20HtmlIconError ;
   private String AV24HtmlTbError ;
   private String AV23HtmlInfoPagoErr ;
   private String AV19HtmlIconCitaError ;
   private String AV18HtmlCitaError ;
   private String AV41TransactionToken ;
   private String AV6accessToken ;
   private String AV33purchaseNumber ;
   private String AV14ErrorMessage ;
   private String AV30NombresDoctor ;
   private String AV17HoraCita ;
   private String AV11DateString ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV26HttpRequest ;
   private com.genexus.webpanels.WebSession AV42WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.SdtSDTRequestAutorizacionPago AV5SDTRequestAutorizacionPago ;
   private com.projectthani.SdtSDTRequestAutorizacionPago GXv_SdtSDTRequestAutorizacionPago4[] ;
   private com.projectthani.SdtCita AV8Cita ;
   private com.projectthani.SdtDisponibilidad AV12Disponibilidad ;
   private com.projectthani.SdtPago AV31Pago ;
   private com.projectthani.SdtSDTResponseAutorizacionPago200 AV34SDTResponseAutorizacionPago200 ;
   private com.projectthani.SdtSDTResponseAutorizacionPago200 GXv_SdtSDTResponseAutorizacionPago2002[] ;
   private com.projectthani.SdtSDTResponseAutorizacionPago400 AV35SDTResponseAutorizacionPago400 ;
   private com.projectthani.SdtSDTResponseAutorizacionPago400 GXv_SdtSDTResponseAutorizacionPago4003[] ;
}

final  class wprespuestaniubiz__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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

