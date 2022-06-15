package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpvideollamadamedico_impl extends GXWebPanel
{
   public wpvideollamadamedico_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpvideollamadamedico_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpvideollamadamedico_impl.class ));
   }

   public wpvideollamadamedico_impl( int remoteHandle ,
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
            AV6CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CitaId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CitaId), "ZZZZZZZ9")));
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
         pa6R2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws6R2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we6R2( ) ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( "Video Llamada Medico") ;
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
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034654", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoHomPagPaciente\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoHomPagPaciente\" data-gx-class=\"form-horizontal FormFondoHomPagPaciente\" novalidate action=\""+formatLink("com.projectthani.wpvideollamadamedico", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV6CitaId,8,0))}, new String[] {"CitaId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESAPELLIDOSPAC", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20NombresApellidosPac, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CitaId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNOMBRESAPELLIDOSPAC", AV20NombresApellidosPac);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESAPELLIDOSPAC", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20NombresApellidosPac, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEETCONFIG", AV9MeetConfig);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEETCONFIG", AV9MeetConfig);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV6CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CitaId), "ZZZZZZZ9")));
   }

   public void renderHtmlCloseForm6R2( )
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
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WPVideoLlamadaMedico" ;
   }

   public String getPgmdesc( )
   {
      return "Video Llamada Medico" ;
   }

   public void wb6R0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "Table100x100H", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginLoginVideoLlamadaIL", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablelogincontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingLeft30Video", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablelogin_Internalname, 1, 0, "px", 0, "px", "TableVideoWithLeftImage", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "ImageFixedSize" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "62fabb4b-713d-4bd3-9f52-cde8b0a8f851", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgLogologin_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WPVideoLlamadaMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockicon_Internalname, lblTextblockicon_Caption, "", "", lblTextblockicon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WPVideoLlamadaMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMTVL", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbxvideollamada_Internalname, "¿Ingresar a la videollamada?", "", "", lblTbxvideollamada_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionVideollamada", 0, "", 1, 1, 0, (short)(1), "HLP_WPVideoLlamadaMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "ButtonIrLlamada" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnvideollamada_Internalname, "", "Iniciar videollamada", bttBtnvideollamada_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'BTNVIDEOLLAMADA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPVideoLlamadaMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellLogin CellPaddingLogin", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         ClassString = "ButtonIrCitas" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnregresarcitas_Internalname, "", "Ir a mis citas médicas", bttBtnregresarcitas_Jsonclick, 7, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116r1_client"+"'", TempTags, "", 2, "HLP_WPVideoLlamadaMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemeetcontainer_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
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

   public void start6R2( )
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
         Form.getMeta().addItem("description", "Video Llamada Medico", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6R0( ) ;
   }

   public void ws6R2( )
   {
      start6R2( ) ;
      evt6R2( ) ;
   }

   public void evt6R2( )
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
                        e126R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'BTNVIDEOLLAMADA'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'BtnVideollamada' */
                        e136R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e146R2 ();
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

   public void we6R2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6R2( ) ;
         }
      }
   }

   public void pa6R2( )
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
      rf6R2( ) ;
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

   public void rf6R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e146R2 ();
         wb6R0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6R2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNOMBRESAPELLIDOSPAC", AV20NombresApellidosPac);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESAPELLIDOSPAC", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20NombresApellidosPac, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e126R2 ();
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
      e126R2 ();
      if (returnInSub) return;
   }

   public void e126R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      lblTextblockicon_Caption = "<div><i class=\"fas fa-video\" style=\"margin-top: 20px;font-size: 80px;color: black;\"></i></div>" ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockicon_Internalname, "Caption", lblTextblockicon_Caption, true);
      /* Using cursor H006R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV6CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89CitaEstadoCita = H006R2_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = H006R2_n89CitaEstadoCita[0] ;
         A95CitaEstado = H006R2_A95CitaEstado[0] ;
         n95CitaEstado = H006R2_n95CitaEstado[0] ;
         A19CitaId = H006R2_A19CitaId[0] ;
         A20PacienteId = H006R2_A20PacienteId[0] ;
         A64CitaCode = H006R2_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = H006R2_A21SGCitaDisponibilidadId[0] ;
         AV14PacienteId = A20PacienteId ;
         AV15CodigoCita = A64CitaCode ;
         AV16DisponibilidadId = A21SGCitaDisponibilidadId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV17Paciente.Load(AV14PacienteId);
      AV20NombresApellidosPac = AV17Paciente.getgxTv_SdtPaciente_Pacientenombres() + " " + AV17Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() + " " + AV17Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20NombresApellidosPac", AV20NombresApellidosPac);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESAPELLIDOSPAC", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20NombresApellidosPac, ""))));
      AV18Disponibilidad.Load(AV16DisponibilidadId);
      AV19FechaCita = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha() ;
      AV21HoraInicio = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio() ;
      AV22HoraFin = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadhorafin() ;
      AV24ProfesionalId = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Profesionalid() ;
      AV8isOpenVideoCall = false ;
      AV7Domain = "meet.jit.si" ;
      AV10RoomName = AV15CodigoCita ;
      AV9MeetConfig = (com.hugao.hugaojitsiclient.common.SdtMeetConfig)new com.hugao.hugaojitsiclient.common.SdtMeetConfig(remoteHandle, context);
      AV9MeetConfig.setgxTv_SdtMeetConfig_Domain( AV7Domain );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().setgxTv_SdtMeetConfig_Options_Roomname( AV10RoomName );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Deeplinking( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Sharingchrome( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Sharingfirefox( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().setgxTv_SdtMeetConfig_Options_Config_Notstoreroom( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Welcomepage( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Closepage( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Ui().setgxTv_SdtMeetConfig_Options_Config_UI_Defaultlanguage( "es" );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startaudioonly( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startwithaudiomuted( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Startwithvideomuted( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Media().setgxTv_SdtMeetConfig_Options_Config_Media_Resolution( (short)(1080) );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Recording().setgxTv_SdtMeetConfig_Options_Config_Recording_Recordingsservice( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Config().getgxTv_SdtMeetConfig_Options_Config_Recording().setgxTv_SdtMeetConfig_Options_Config_Recording_Livestreamingenabled( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Filmstriponly( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Jitsiwatermark( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Watermarkforguests( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Brandwatermark( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Poweredby( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Verticalfilmstrip( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Disableringing( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Mobileapppromo( false );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Connectionindicatordisabled( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Videoqualitylabeldisabled( true );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().getgxTv_SdtMeetConfig_Options_InterfaceConfig_Settingssections().add("devices", 0);
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Videolayoutfit( "both" );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Interfaceconfig().setgxTv_SdtMeetConfig_Options_InterfaceConfig_Openinmobilebrowser( true );
   }

   public void e136R2( )
   {
      /* 'BtnVideollamada' Routine */
      returnInSub = false ;
      AV8isOpenVideoCall = true ;
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Displayname( AV20NombresApellidosPac );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Email( "" );
      AV9MeetConfig.getgxTv_SdtMeetConfig_Options().getgxTv_SdtMeetConfig_Options_Userinfo().setgxTv_SdtMeetConfig_Options_UserInfo_Avatarimage( "" );
      AV5JitsiJWTContext = (com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext)new com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext(remoteHandle, context);
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Id( java.util.UUID.randomUUID( ).toString() );
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Name( AV20NombresApellidosPac );
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Email( "" );
      AV5JitsiJWTContext.getgxTv_SdtJitsiJWTContext_User().setgxTv_SdtJitsiJWTContext_user_Avatar( "" );
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "_JITSI_MEET_CONTAINER", divTablemeetcontainer_Internalname);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "UseAllWindowForMeet", true);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "DisposeOnUnload", false);
      this.setExternalObjectProperty("", false, "gx.hugao.jitsiclient", "PipLocation", "tr");
      this.executeExternalObjectMethod("", false, "gx.hugao.jitsiclient.meet", "prepare", new Object[] {AV9MeetConfig,Boolean.valueOf(true)}, false);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV9MeetConfig", AV9MeetConfig);
   }

   protected void nextLoad( )
   {
   }

   protected void e146R2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CitaId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CitaId), "ZZZZZZZ9")));
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
      pa6R2( ) ;
      ws6R2( ) ;
      we6R2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034722", true, true);
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
      httpContext.AddJavascriptSource("wpvideollamadamedico.js", "?2022511034723", false, true);
      httpContext.AddJavascriptSource("Resources\\HugaoJitsiClient\\gx-hugao-jitsiclient.js", "", false, true);
      httpContext.AddJavascriptSource("Resources\\HugaoJitsiClient\\gx-hugao-jitsiclient.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgLogologin_Internalname = "LOGOLOGIN" ;
      lblTextblockicon_Internalname = "TEXTBLOCKICON" ;
      lblTbxvideollamada_Internalname = "TBXVIDEOLLAMADA" ;
      bttBtnvideollamada_Internalname = "BTNVIDEOLLAMADA" ;
      bttBtnregresarcitas_Internalname = "BTNREGRESARCITAS" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTablelogin_Internalname = "TABLELOGIN" ;
      divTablelogincontent_Internalname = "TABLELOGINCONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divTablemeetcontainer_Internalname = "TABLEMEETCONTAINER" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      divMaintable_Internalname = "MAINTABLE" ;
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
      lblTextblockicon_Caption = "Text Block" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV20NombresApellidosPac',fld:'vNOMBRESAPELLIDOSPAC',pic:'',hsh:true},{av:'AV6CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'BTNVIDEOLLAMADA'","{handler:'e136R2',iparms:[{av:'AV20NombresApellidosPac',fld:'vNOMBRESAPELLIDOSPAC',pic:'',hsh:true},{av:'AV9MeetConfig',fld:'vMEETCONFIG',pic:''}]");
      setEventMetadata("'BTNVIDEOLLAMADA'",",oparms:[{av:'AV9MeetConfig',fld:'vMEETCONFIG',pic:''},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Containername()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Containername'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Useallwindow()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Useallwindow'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Disposeonunload()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Disposeonunload'},{av:'new com.hugao.hugaojitsiclient.web.SdtProperties(remoteHandle, context).getgxTv_SdtProperties_Piplocation()',ctrl:'GX.HUGAO.JITSICLIENT',prop:'Piplocation'}]}");
      setEventMetadata("'IRCITASMEDICAS'","{handler:'e116R1',iparms:[]");
      setEventMetadata("'IRCITASMEDICAS'",",oparms:[]}");
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
      AV20NombresApellidosPac = "" ;
      GXKey = "" ;
      AV9MeetConfig = new com.hugao.hugaojitsiclient.common.SdtMeetConfig(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblTextblockicon_Jsonclick = "" ;
      lblTbxvideollamada_Jsonclick = "" ;
      TempTags = "" ;
      bttBtnvideollamada_Jsonclick = "" ;
      bttBtnregresarcitas_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H006R2_A89CitaEstadoCita = new String[] {""} ;
      H006R2_n89CitaEstadoCita = new boolean[] {false} ;
      H006R2_A95CitaEstado = new String[] {""} ;
      H006R2_n95CitaEstado = new boolean[] {false} ;
      H006R2_A19CitaId = new int[1] ;
      H006R2_A20PacienteId = new int[1] ;
      H006R2_A64CitaCode = new String[] {""} ;
      H006R2_A21SGCitaDisponibilidadId = new int[1] ;
      A89CitaEstadoCita = "" ;
      A95CitaEstado = "" ;
      A64CitaCode = "" ;
      AV15CodigoCita = "" ;
      AV17Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV18Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV19FechaCita = GXutil.nullDate() ;
      AV21HoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV22HoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV7Domain = "" ;
      AV10RoomName = "" ;
      AV5JitsiJWTContext = new com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpvideollamadamedico__default(),
         new Object[] {
             new Object[] {
            H006R2_A89CitaEstadoCita, H006R2_n89CitaEstadoCita, H006R2_A95CitaEstado, H006R2_n95CitaEstado, H006R2_A19CitaId, H006R2_A20PacienteId, H006R2_A64CitaCode, H006R2_A21SGCitaDisponibilidadId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV6CitaId ;
   private int AV6CitaId ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV14PacienteId ;
   private int AV16DisponibilidadId ;
   private int AV24ProfesionalId ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablelogincontent_Internalname ;
   private String divTablelogin_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgLogologin_Internalname ;
   private String lblTextblockicon_Internalname ;
   private String lblTextblockicon_Caption ;
   private String lblTextblockicon_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String lblTbxvideollamada_Internalname ;
   private String lblTbxvideollamada_Jsonclick ;
   private String TempTags ;
   private String bttBtnvideollamada_Internalname ;
   private String bttBtnvideollamada_Jsonclick ;
   private String bttBtnregresarcitas_Internalname ;
   private String bttBtnregresarcitas_Jsonclick ;
   private String divTablemeetcontainer_Internalname ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String A89CitaEstadoCita ;
   private String A95CitaEstado ;
   private java.util.Date AV21HoraInicio ;
   private java.util.Date AV22HoraFin ;
   private java.util.Date AV19FechaCita ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean n89CitaEstadoCita ;
   private boolean n95CitaEstado ;
   private boolean AV8isOpenVideoCall ;
   private String AV20NombresApellidosPac ;
   private String A64CitaCode ;
   private String AV15CodigoCita ;
   private String AV7Domain ;
   private String AV10RoomName ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private IDataStoreProvider pr_default ;
   private String[] H006R2_A89CitaEstadoCita ;
   private boolean[] H006R2_n89CitaEstadoCita ;
   private String[] H006R2_A95CitaEstado ;
   private boolean[] H006R2_n95CitaEstado ;
   private int[] H006R2_A19CitaId ;
   private int[] H006R2_A20PacienteId ;
   private String[] H006R2_A64CitaCode ;
   private int[] H006R2_A21SGCitaDisponibilidadId ;
   private com.hugao.hugaojitsiclient.security.SdtJitsiJWTContext AV5JitsiJWTContext ;
   private com.hugao.hugaojitsiclient.common.SdtMeetConfig AV9MeetConfig ;
   private com.projectthani.SdtPaciente AV17Paciente ;
   private com.projectthani.SdtDisponibilidad AV18Disponibilidad ;
}

final  class wpvideollamadamedico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006R2", "SELECT TOP 1 [CitaEstadoCita], [CitaEstado], [CitaId], [PacienteId], [CitaCode], [SGCitaDisponibilidadId] FROM [Cita] WHERE ([CitaId] = ?) AND ([CitaEstado] = 'A') AND ([CitaEstadoCita] = 'R') ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
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
      }
   }

}

